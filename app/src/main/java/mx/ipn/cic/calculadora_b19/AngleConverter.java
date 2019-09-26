package mx.ipn.cic.calculadora_b19;

/**
 * Class that converts radians to degrees and degrees to radians.
 */
public class AngleConverter {

    /**
     * Converts radians to degrees.
     * @param angle Angle expressed in radians.
     * @return Angle expressed in degrees.
     */
    public static double rad2deg(double angle) {
        return angle * 180.0 / Math.PI;
    }

    /**
     * Converts degrees to radians.
     * @param angle Angle expressed in degrees.
     * @return Angle expressed in radians.
     */
    public static double deg2rad(double angle) {
        return angle * Math.PI /180.0;
    }

}
