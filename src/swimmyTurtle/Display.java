package swimmyTurtle;

import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import app.JApplication;
import io.*;
import visual.VisualizationView;
import visual.dynamic.described.*;
import visual.statik.sampled.*;

/**
 * Blatant rip off of flappy bird.
 *
 * @author Michael DeProspo
 * @version 1.0
 */
public class Display extends JApplication implements KeyListener
{
  Stage stage;
  StartMenu menu;
  BufferedImage image;
  ResourceFinder finder;
  VisualizationView stageView;
  JLabel pointsLabel;
  int points = 0;
  int width;
  int height;
  ContentFactory factory;
  ImageFactory imageFactory;

  public static void main(String[] args)
  {
    System.out.println(System.getProperty("java.classpath"));
    JApplication demo = new Display(args, 640, 480);
    invokeInEventDispatchThread(demo);
  }

  /**
   * Creates display with specified params.
   * 
   * @param args
   *          Command line args
   * @param width
   *          the width
   * @param height
   *          the height
   */
  public Display(String[] args, int width, int height)
  {
    super(args, width, height);
  }

  /**
   * Loads start screen.
   */
  public void init()
  {
    startScreen();
  }

  /**
   * Loads start screen, ocean background with a start button.
   */
  public void startScreen()
  {

    width = 640;
    height = 480;

    finder = ResourceFinder.createInstance(resources.Marker.class);
    factory = new ContentFactory(finder);
    imageFactory = new ImageFactory(finder);

    // The Stage
    stage = new Stage(50);
    stage.setBackground(Color.blue);
    Content content = factory.createContent("ocean.png", 3, false);
    stage.add(content);
    stageView = stage.getView();
    stageView.setBounds(0, 0, width, height);
    JPanel panel = (JPanel) getContentPane();
    int wid = width / 5;
    int len = height / 5;
    menu = new StartMenu(this, (width / 2) - wid / 2, (height / 2) - len / 2, wid, len);
    panel.add(menu);
    panel.add(stageView);

  }

  /**
   * Renders straws and turtle.
   */
  public void renderGame()
  {

    Content content = factory.createContent("turttrans.png", 4, false);
    JPanel contentPane = (JPanel) getContentPane();
    pointsLabel = new JLabel("Points: 0");
    pointsLabel.setForeground(Color.WHITE);
    pointsLabel.setFont(new Font("Verdana", Font.BOLD, 24));
    pointsLabel.setBounds(width - 150, 30, 150, 50);
    Turtle turtle = new Turtle(content, width, height, 0., pointsLabel, stage);
    stage.add(turtle);

    image = imageFactory.createBufferedImage("straw.png", 4);
    for (int i = 0; i < 3; i++)
    {
      content = factory.createContent(image, false);
      Straw straw = new Straw(content, width, height, -3., (width - 100 * i) / 1.0,
          (height - 150.0 - (30 * (i % 2))) / 1.0);
      turtle.addAntagonist(straw);
      stage.add(straw);
    }
    image = imageFactory.createBufferedImage("invstrawtrans.png", 4);
    // inverted straws for above
    for (int i = 0; i < 3; i++)
    {
      content = factory.createContent(image, false);
      Straw straw = new Straw(content, width, height, -3., (75 * i) / 1.0, (40 * (i % 2)) / 1.0);
      turtle.addAntagonist(straw);
      stage.add(straw);

    }

    contentPane.add(pointsLabel);
    contentPane.add(stageView);

    stage.addKeyListener(this);
    stage.addKeyListener((KeyListener) turtle);

  }

  /**
   * Starts stage and renders graphics.
   */
  public void startGame()
  {
    renderGame();
    stage.start();
  }

  @Override
  public void keyTyped(KeyEvent e)
  {
    switch (e.getKeyChar())
    {
      case ' ':
    }

  }

  @Override
  public void keyPressed(KeyEvent e)
  {
    // TODO Auto-generated method stub

  }

  @Override
  public void keyReleased(KeyEvent e)
  {
    // TODO Auto-generated method stub

  }

}
