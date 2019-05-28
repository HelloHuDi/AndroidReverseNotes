package com.tencent.ttpic.p683ar.sensor.orientationProvider;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.ttpic.p683ar.sensor.representation.MatrixF4x4;
import com.tencent.ttpic.p683ar.sensor.representation.Quaternion;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.ttpic.ar.sensor.orientationProvider.OrientationProvider */
public abstract class OrientationProvider implements SensorEventListener {
    protected final Quaternion currentOrientationQuaternion;
    protected final MatrixF4x4 currentOrientationRotationMatrix;
    protected List<Sensor> sensorList = new ArrayList();
    protected SensorManager sensorManager;
    protected final Object synchronizationToken = new Object();

    public OrientationProvider(SensorManager sensorManager) {
        this.sensorManager = sensorManager;
        this.currentOrientationRotationMatrix = new MatrixF4x4();
        this.currentOrientationQuaternion = new Quaternion();
    }

    public void start() {
        for (Sensor registerListener : this.sensorList) {
            this.sensorManager.registerListener(this, registerListener, 1);
        }
    }

    public void stop() {
        for (Sensor unregisterListener : this.sensorList) {
            this.sensorManager.unregisterListener(this, unregisterListener);
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void getRotationMatrix(MatrixF4x4 matrixF4x4) {
        synchronized (this.synchronizationToken) {
            matrixF4x4.set(this.currentOrientationRotationMatrix);
        }
    }

    public void getQuaternion(Quaternion quaternion) {
        synchronized (this.synchronizationToken) {
            quaternion.set(this.currentOrientationQuaternion);
        }
    }

    public void getEulerAngles(float[] fArr) {
        synchronized (this.synchronizationToken) {
            SensorManager.getOrientation(this.currentOrientationRotationMatrix.matrix, fArr);
            fArr[0] = (float) Math.toDegrees((double) fArr[0]);
            fArr[1] = (float) Math.toDegrees((double) fArr[1]);
            fArr[2] = -((float) Math.toDegrees((double) fArr[2]));
        }
    }
}
