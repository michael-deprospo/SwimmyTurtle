package swimmyTurtle;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Menu for starting the game, just handles clicking start button.
 * 
 * @author Michael DeProspo
 * @version 1.0
 */
public class StartMenu extends JPanel
{

  private static final long serialVersionUID = 1L;
  Display main;
  JButton start;

  public StartMenu(Display display, int x, int y, int width, int height)
  {
    main = display;
    JPanel contentPane = (JPanel) main.getContentPane();
    start = new JButton("START");
    start.setForeground(Color.WHITE);
    start.setFont(new Font("Verdana", Font.BOLD, 24));
    start.setBounds(x, y, width, height);
    contentPane.add(start);
    contentPane.setBackground(Color.BLUE);
    start.addActionListener(new ActionListener()
    {
      @Override
      public void actionPerformed(ActionEvent e)
      {
        main.startGame();
        start.setVisible(false);

      }
    });

  }

}
