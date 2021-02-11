package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight {
  private NetworkTable networkEntry = NetworkTableInstance.getDefault().getTable("limelight");

  /*
   * tv Whether the limelight has any valid targets (0 or 1) tx Horizontal Offset
   * From Crosshair To Target (LL1: -27 degrees to 27 degrees | LL2: -29.8 to 29.8
   * degrees) ty Vertical Offset From Crosshair To Target (LL1: -20.5 degrees to
   * 20.5 degrees | LL2: -24.85 to 24.85 degrees) ta Target Area (0% of image to
   * 100% of image) ts Skew or rotation (-90 degrees to 0 degrees) tl The
   * pipeline’s latency contribution (ms) Add at least 11ms for image capture
   * latency. tshort Sidelength of shortest side of the fitted bounding box
   * (pixels) tlong Sidelength of longest side of the fitted bounding box (pixels)
   * thor Horizontal sidelength of the rough bounding box (0 - 320 pixels) tvert
   * Vertical sidelength of the rough bounding box (0 - 320 pixels) getpipe True
   * active pipeline index of the camera (0 .. 9) camtran Results of a 3D position
   * solution, 6 numbers: Translation (x,y,y) Rotation(pitch,yaw,roll)
   */

  private NetworkTableEntry tv = networkEntry.getEntry("tv");
  private NetworkTableEntry tx = networkEntry.getEntry("tx");
  private NetworkTableEntry ty = networkEntry.getEntry("ty");
  private NetworkTableEntry ta = networkEntry.getEntry("ta");
  private NetworkTableEntry ts = networkEntry.getEntry("ts");
  private NetworkTableEntry tl = networkEntry.getEntry("tl");
  private NetworkTableEntry tshort = networkEntry.getEntry("tshort");
  private NetworkTableEntry tlong = networkEntry.getEntry("tlong");
  private NetworkTableEntry thor = networkEntry.getEntry("thor");
  private NetworkTableEntry tvert = networkEntry.getEntry("tvert");
  private NetworkTableEntry getpipe = networkEntry.getEntry("getpipe");
  private NetworkTableEntry camtran = networkEntry.getEntry("camtran");

  public Limelight() {

  }

  public boolean hasValidTargets() {
    return tv.getBoolean(false);
  }
  public double getX() {
    return tx.getDouble(0);
  }
  public double getY() {
    return ty.getDouble(0);
  }
  public double getArea() {
    return ta.getDouble(0);
  }
  public double getSkew() {
    return ts.getDouble(0);
  }
  public double getLatency() {
    return tl.getDouble(0);
  }
}
