package com.facebook.appevents.codeless;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ViewIndexingTrigger implements SensorEventListener {
    private static final double SHAKE_THRESHOLD_GRAVITY = 2.299999952316284d;
    private OnShakeListener mListener;

    public interface OnShakeListener {
        void onShake();
    }

    public void setOnShakeListener(OnShakeListener onShakeListener) {
        this.mListener = onShakeListener;
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        AppMethodBeat.m2504i(72090);
        if (this.mListener != null) {
            float f = sensorEvent.values[0];
            double d = (double) (f / 9.80665f);
            double d2 = (double) (sensorEvent.values[1] / 9.80665f);
            double d3 = (double) (sensorEvent.values[2] / 9.80665f);
            if (Math.sqrt(((d2 * d2) + (d * d)) + (d3 * d3)) > SHAKE_THRESHOLD_GRAVITY) {
                this.mListener.onShake();
            }
        }
        AppMethodBeat.m2505o(72090);
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}
