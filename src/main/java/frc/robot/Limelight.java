package frc.robot;

import java.lang.reflect.Array;
import java.util.ArrayList;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight {
  /*
   * tv Whether the limelight has any valid targets (0 or 1) tx Horizontal Offset
   * From Crosshair To Target (LL1: -27 degrees to 27 degrees | LL2: -29.8 to
   * 29.8degrees) ty Vertical Offset From Crosshair To Target (LL1: -20.5 degrees
   * to 20.5 degrees | LL2: -24.85 to 24.85 degrees) ta Target Area (0% of image
   * to 100% of image) ts Skew or rotation (-90 degrees to 0 degrees) tl The
   * pipeline’s latency contribution (ms) Add at least 11ms for image capture
   * latency. tshort Sidelength of shortest side of the fitted bounding box
   * (pixels) tlong Sidelength of longest side of the fitted bounding box (pixels)
   * thor Horizontal sidelength of the rough bounding box (0 - 320 pixels) tvert
   * Vertical sidelength of the rough bounding box (0 - 320 pixels) getpipe True
   * active pipeline index of the camera (0 .. 9) camtran Results of a 3D position
   * solution, 6 numbers: Translation (x,y,y) Rotation(pitch,yaw,roll)
   */

  private NetworkTableEntry tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv");
  private NetworkTableEntry tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx");
  private NetworkTableEntry ty = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty");
  private NetworkTableEntry ta = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta");
  private NetworkTableEntry ts = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ts");
  private NetworkTableEntry tl = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tl");
  private NetworkTableEntry tshort = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tshort");
  private NetworkTableEntry tlong = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tlong");
  private NetworkTableEntry thor = NetworkTableInstance.getDefault().getTable("limelight").getEntry("thor");
  private NetworkTableEntry tvert = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tvert");
  private NetworkTableEntry getpipe = NetworkTableInstance.getDefault().getTable("limelight").getEntry("getpipe");
  private NetworkTableEntry camtran = NetworkTableInstance.getDefault().getTable("limelight").getEntry("camtran");

  public Limelight() {

  }

  public double hasValidTargets() {
    return tv.getDouble(0);
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

  public double getShortSize() {
    return tshort.getDouble(0);
  }

  public double getLongSize() {
    return tlong.getDouble(0);
  }

  public double getHorizontalSize() {
    return thor.getDouble(0);
  }

  public double getVerticalSize() {
    return tvert.getDouble(0);
  }

  public double getPipeline() {
    return getpipe.getDouble(0);
  }
  //FIXME: prob not going to work
  public double[] getTranslationRotation() {
  return camtran.getDoubleArray(new double[5]);
  }
}
