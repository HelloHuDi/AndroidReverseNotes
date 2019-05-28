package com.tencent.ttpic.p683ar.sensor.orientationProvider;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.p683ar.sensor.representation.Quaternion;

/* renamed from: com.tencent.ttpic.ar.sensor.orientationProvider.ImprovedOrientationSensor2Provider */
public class ImprovedOrientationSensor2Provider extends OrientationProvider {
    private static final double EPSILON = 0.10000000149011612d;
    private static final float INDIRECT_INTERPOLATION_WEIGHT = 0.01f;
    private static final float NS2S = 1.0E-9f;
    private static final float OUTLIER_PANIC_THRESHOLD = 0.75f;
    private static final float OUTLIER_THRESHOLD = 0.85f;
    private static final int PANIC_THRESHOLD = 60;
    private final Quaternion correctedQuaternion = new Quaternion();
    private final Quaternion deltaQuaternion = new Quaternion();
    private double gyroscopeRotationVelocity = 0.0d;
    private final Quaternion interpolatedQuaternion = new Quaternion();
    private int panicCounter;
    private boolean positionInitialised = false;
    private Quaternion quaternionGyroscope = new Quaternion();
    private Quaternion quaternionRotationVector = new Quaternion();
    private final float[] temporaryQuaternion = new float[4];
    private long timestamp;

    public ImprovedOrientationSensor2Provider(SensorManager sensorManager) {
        super(sensorManager);
        AppMethodBeat.m2504i(81677);
        this.sensorList.add(sensorManager.getDefaultSensor(4));
        this.sensorList.add(sensorManager.getDefaultSensor(11));
        AppMethodBeat.m2505o(81677);
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        AppMethodBeat.m2504i(81678);
        if (sensorEvent.sensor.getType() == 11) {
            SensorManager.getQuaternionFromVector(this.temporaryQuaternion, sensorEvent.values);
            this.quaternionRotationVector.setXYZW(this.temporaryQuaternion[1], this.temporaryQuaternion[2], this.temporaryQuaternion[3], -this.temporaryQuaternion[0]);
            if (!this.positionInitialised) {
                this.quaternionGyroscope.set(this.quaternionRotationVector);
                this.positionInitialised = true;
                AppMethodBeat.m2505o(81678);
                return;
            }
        } else if (sensorEvent.sensor.getType() == 4) {
            if (this.timestamp != 0) {
                float f = ((float) (sensorEvent.timestamp - this.timestamp)) * NS2S;
                float f2 = sensorEvent.values[0];
                float f3 = sensorEvent.values[1];
                float f4 = sensorEvent.values[2];
                this.gyroscopeRotationVelocity = Math.sqrt((double) (((f2 * f2) + (f3 * f3)) + (f4 * f4)));
                if (this.gyroscopeRotationVelocity > EPSILON) {
                    f2 = (float) (((double) f2) / this.gyroscopeRotationVelocity);
                    f3 = (float) (((double) f3) / this.gyroscopeRotationVelocity);
                    f4 = (float) (((double) f4) / this.gyroscopeRotationVelocity);
                }
                double d = (this.gyroscopeRotationVelocity * ((double) f)) / 2.0d;
                double sin = Math.sin(d);
                d = Math.cos(d);
                this.deltaQuaternion.setX((float) (((double) f2) * sin));
                this.deltaQuaternion.setY((float) (((double) f3) * sin));
                this.deltaQuaternion.setZ((float) (((double) f4) * sin));
                this.deltaQuaternion.setW(-((float) d));
                this.deltaQuaternion.multiplyByQuat(this.quaternionGyroscope, this.quaternionGyroscope);
                f4 = this.quaternionGyroscope.dotProduct(this.quaternionRotationVector);
                if (Math.abs(f4) < OUTLIER_THRESHOLD) {
                    if (Math.abs(f4) < OUTLIER_PANIC_THRESHOLD) {
                        this.panicCounter++;
                    }
                    setOrientationQuaternionAndMatrix(this.quaternionGyroscope);
                } else {
                    this.quaternionGyroscope.slerp(this.quaternionRotationVector, this.interpolatedQuaternion, (float) (0.009999999776482582d * this.gyroscopeRotationVelocity));
                    setOrientationQuaternionAndMatrix(this.interpolatedQuaternion);
                    this.quaternionGyroscope.copyVec4(this.interpolatedQuaternion);
                    this.panicCounter = 0;
                }
                if (this.panicCounter > 60) {
                    if (this.gyroscopeRotationVelocity < 3.0d) {
                        setOrientationQuaternionAndMatrix(this.quaternionRotationVector);
                        this.quaternionGyroscope.copyVec4(this.quaternionRotationVector);
                        this.panicCounter = 0;
                    } else {
                        String.format("Panic reset delayed due to ongoing motion (user is still shaking the device). Gyroscope Velocity: %.2f > 3", new Object[]{Double.valueOf(this.gyroscopeRotationVelocity)});
                    }
                }
            }
            this.timestamp = sensorEvent.timestamp;
        }
        AppMethodBeat.m2505o(81678);
    }

    private void setOrientationQuaternionAndMatrix(Quaternion quaternion) {
        AppMethodBeat.m2504i(81679);
        this.correctedQuaternion.set(quaternion);
        this.correctedQuaternion.mo71103w(-this.correctedQuaternion.mo71102w());
        synchronized (this.synchronizationToken) {
            try {
                this.currentOrientationQuaternion.copyVec4(quaternion);
                SensorManager.getRotationMatrixFromVector(this.currentOrientationRotationMatrix.matrix, this.correctedQuaternion.array());
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(81679);
            }
        }
    }
}
