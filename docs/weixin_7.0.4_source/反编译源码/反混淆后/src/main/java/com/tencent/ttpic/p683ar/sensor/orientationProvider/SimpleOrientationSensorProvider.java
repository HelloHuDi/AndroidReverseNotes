package com.tencent.ttpic.p683ar.sensor.orientationProvider;

import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.Queue;

/* renamed from: com.tencent.ttpic.ar.sensor.orientationProvider.SimpleOrientationSensorProvider */
public class SimpleOrientationSensorProvider extends OrientationProvider {
    private int ANGLE_QUEUE_MAX_SIZE = 5;
    private Queue<Float> azimuthQueue = new LinkedList();
    private float[] geomagnetic = new float[3];
    private float[] gravity = new float[3];
    private float lastAzimuth;
    private float lastPitch;
    private float lastRoll;
    private Queue<Float> pitchQueue = new LinkedList();
    private Queue<Float> rollQueue = new LinkedList();
    private float[] rotationMat = new float[9];
    private float[] values = new float[3];

    public SimpleOrientationSensorProvider(SensorManager sensorManager) {
        super(sensorManager);
        AppMethodBeat.m2504i(81680);
        this.sensorList.add(sensorManager.getDefaultSensor(2));
        this.sensorList.add(sensorManager.getDefaultSensor(1));
        AppMethodBeat.m2505o(81680);
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        AppMethodBeat.m2504i(81681);
        if (sensorEvent.sensor.getType() == 2) {
            this.geomagnetic = sensorEvent.values;
        }
        if (sensorEvent.sensor.getType() == 1) {
            this.gravity = sensorEvent.values;
        }
        AppMethodBeat.m2505o(81681);
    }

    public void getEulerAngles(float[] fArr) {
        AppMethodBeat.m2504i(81682);
        synchronized (this.synchronizationToken) {
            try {
                SensorManager.getRotationMatrix(this.rotationMat, null, this.gravity, this.geomagnetic);
                SensorManager.getOrientation(this.rotationMat, this.values);
                float toDegrees = (float) Math.toDegrees((double) this.values[0]);
                if (toDegrees < 0.0f) {
                    toDegrees += 360.0f;
                }
                if (180.0f <= toDegrees && toDegrees <= 360.0f) {
                    toDegrees -= 360.0f;
                }
                float toDegrees2 = (float) Math.toDegrees((double) this.values[1]);
                float f = -((float) Math.toDegrees((double) this.values[2]));
                if (Math.abs(toDegrees - this.lastAzimuth) > 20.0f) {
                    this.azimuthQueue.clear();
                }
                this.lastAzimuth = toDegrees;
                if (Math.abs(toDegrees2 - this.lastPitch) > 20.0f) {
                    this.pitchQueue.clear();
                }
                this.lastPitch = toDegrees2;
                if (Math.abs(f - this.lastRoll) > 20.0f) {
                    this.rollQueue.clear();
                }
                this.lastRoll = f;
                this.azimuthQueue.offer(Float.valueOf(toDegrees));
                this.pitchQueue.offer(Float.valueOf(toDegrees2));
                this.rollQueue.offer(Float.valueOf(f));
                while (this.azimuthQueue.size() > this.ANGLE_QUEUE_MAX_SIZE) {
                    this.azimuthQueue.poll();
                }
                while (this.pitchQueue.size() > this.ANGLE_QUEUE_MAX_SIZE) {
                    this.pitchQueue.poll();
                }
                while (this.rollQueue.size() > this.ANGLE_QUEUE_MAX_SIZE) {
                    this.rollQueue.poll();
                }
                fArr[2] = 0.0f;
                fArr[1] = 0.0f;
                fArr[0] = 0.0f;
                for (Float f2 : this.azimuthQueue) {
                    fArr[0] = f2.floatValue() + fArr[0];
                }
                for (Float f22 : this.pitchQueue) {
                    fArr[1] = f22.floatValue() + fArr[1];
                }
                for (Float f222 : this.rollQueue) {
                    fArr[2] = f222.floatValue() + fArr[2];
                }
                fArr[0] = fArr[0] / ((float) this.azimuthQueue.size());
                fArr[1] = fArr[1] / ((float) this.pitchQueue.size());
                fArr[2] = fArr[2] / ((float) this.rollQueue.size());
            } finally {
                AppMethodBeat.m2505o(81682);
            }
        }
    }
}
