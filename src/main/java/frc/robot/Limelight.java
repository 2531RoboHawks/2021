package frc.robot;

import java.lang.reflect.Array;
import java.util.ArrayList;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight {
  private NetworkTable networkEntry = NetworkTableInstance.getDefault().getTable("limelight");

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

  private double tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
  private double tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
  private double ty = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
  private double ta = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);
  private double ts = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ts").getDouble(0);
  private double tl = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tl").getDouble(0);
  private double tshort = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tshort").getDouble(0);
  private double tlong = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tlong").getDouble(0);
  private double thor = NetworkTableInstance.getDefault().getTable("limelight").getEntry("thor").getDouble(0);
  private double tvert = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tvert").getDouble(0);
  private double getpipe = NetworkTableInstance.getDefault().getTable("limelight").getEntry("getpipe").getDouble(0);

  private NetworkTableEntry camtran = networkEntry.getEntry("camtran");

  public Limelight() {

  }

  public double hasValidTargets() {
    return tv;
  }

  public double getX() {
    return tx;
  }

  public double getY() {
    return ty;
  }

  public double getArea() {
    return ta;
  }

  public double getSkew() {
    return ts;
  }

  public double getLatency() {
    return tl;
  }

  public double getShortSize() {
    return tshort;
  }

  public double getLongSize() {
    return tlong;
  }

  public double getHorizontalSize() {
    return thor;
  }

  public double getVerticalSize() {
    return tvert;
  }

  public double getPipeline() {
    return getpipe;
  }
  //FIXME: prob not going to work
  public double[] getTranslationRotation() {
  return camtran.getDoubleArray(new double[5]);
  }
}
