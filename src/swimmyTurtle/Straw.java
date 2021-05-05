package swimmyTurtle;

import visual.dynamic.described.*;
import visual.statik.TransformableContent;

/**
 * Straw that moves leftward and resets after crossing screen.
 *
 * @author Michael DeProspo
 * @version 1.0
 */
public class Straw extends RuleBasedSprite
{
  protected double intX, intY, initialSpeed, maxX, maxY, x, y, reset_x, reset_y;
  public double speed;

  /**
   * Explicit Value Constructor
   *
   * @param content
   *          The static visual content
   * @param width
   *          The width of the Stage
   * @param height
   *          The height of the Stage
   * @param speed
   *          The normal speed
   */
  public Straw(TransformableContent content, double width, double height, double speed, double x,
      double y)
  {
    super(content);
    maxX = width;
    maxY = height;
    intX = x;
    intY = y;
    this.x = x;
    this.y = y;

    this.initialSpeed = speed;
    this.speed = speed;
  }

  /**
   * Slowly increases speed, collisions are handled by the antagonists, not this sprite.
   *
   * @param time
   *          The current time (which is not used)
   */
  public void handleTick(int time)
  {
    speed -= .1;
    updateLocation();
  }

  /**
   * Update the location
   */
  protected void updateLocation()
  {
    x += speed;

    if (x <= 0)
    {
      x = maxX;

    }

    setLocation(x, y);
  }

  /**
   * Reset straw to initial position and speed.
   */
  public void reset()
  {
    setLocation(intX, intY);
    speed = initialSpeed;
  }
}
