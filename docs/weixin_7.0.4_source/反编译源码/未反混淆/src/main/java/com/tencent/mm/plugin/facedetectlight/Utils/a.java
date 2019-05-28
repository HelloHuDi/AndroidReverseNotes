package com.tencent.mm.plugin.facedetectlight.Utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsMediaPlayer.TbsMediaPlayerListener;

public final class a {
    private SensorManager bCW;
    private a mdn;
    private boolean mdo;

    class a implements SensorEventListener {
        private float mdp;

        private a() {
        }

        /* synthetic */ a(a aVar, byte b) {
            this();
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
            AppMethodBeat.i(749);
            if (sensorEvent.sensor.getType() == 5) {
                this.mdp = sensorEvent.values[0];
            }
            AppMethodBeat.o(749);
        }

        public final void onAccuracyChanged(Sensor sensor, int i) {
        }
    }

    public static class b {
        private static a mdr = new a();

        static {
            AppMethodBeat.i(750);
            AppMethodBeat.o(750);
        }
    }

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
        this.mdo = false;
    }

    public final void dM(Context context) {
        AppMethodBeat.i(TbsMediaPlayerListener.MEDIA_INFO_NO_VIDEO_DATA);
        if (this.mdo) {
            AppMethodBeat.o(TbsMediaPlayerListener.MEDIA_INFO_NO_VIDEO_DATA);
            return;
        }
        this.mdo = true;
        new StringBuilder("lightSensor has started:").append(this.mdo);
        this.bCW = (SensorManager) context.getApplicationContext().getSystemService("sensor");
        Sensor defaultSensor = this.bCW.getDefaultSensor(5);
        if (defaultSensor != null) {
            this.mdn = new a(this, (byte) 0);
            this.bCW.registerListener(this.mdn, defaultSensor, 3);
        }
        AppMethodBeat.o(TbsMediaPlayerListener.MEDIA_INFO_NO_VIDEO_DATA);
    }

    public final float btS() {
        AppMethodBeat.i(TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA);
        if (this.mdn != null) {
            new StringBuilder("Light lux: ").append(this.mdn.mdp);
            float a = this.mdn.mdp;
            AppMethodBeat.o(TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA);
            return a;
        }
        AppMethodBeat.o(TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA);
        return -1.0f;
    }

    public final void stop() {
        AppMethodBeat.i(753);
        if (!this.mdo || this.bCW == null) {
            AppMethodBeat.o(753);
            return;
        }
        this.mdo = false;
        this.bCW.unregisterListener(this.mdn);
        AppMethodBeat.o(753);
    }
}
