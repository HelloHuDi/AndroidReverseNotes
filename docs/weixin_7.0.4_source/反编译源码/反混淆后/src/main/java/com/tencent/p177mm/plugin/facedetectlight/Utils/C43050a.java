package com.tencent.p177mm.plugin.facedetectlight.Utils;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsMediaPlayer.TbsMediaPlayerListener;

/* renamed from: com.tencent.mm.plugin.facedetectlight.Utils.a */
public final class C43050a {
    private SensorManager bCW;
    private C3061a mdn;
    private boolean mdo;

    /* renamed from: com.tencent.mm.plugin.facedetectlight.Utils.a$a */
    class C3061a implements SensorEventListener {
        private float mdp;

        private C3061a() {
        }

        /* synthetic */ C3061a(C43050a c43050a, byte b) {
            this();
        }

        public final void onSensorChanged(SensorEvent sensorEvent) {
            AppMethodBeat.m2504i(749);
            if (sensorEvent.sensor.getType() == 5) {
                this.mdp = sensorEvent.values[0];
            }
            AppMethodBeat.m2505o(749);
        }

        public final void onAccuracyChanged(Sensor sensor, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetectlight.Utils.a$b */
    public static class C3062b {
        private static C43050a mdr = new C43050a();

        static {
            AppMethodBeat.m2504i(750);
            AppMethodBeat.m2505o(750);
        }
    }

    /* synthetic */ C43050a(byte b) {
        this();
    }

    private C43050a() {
        this.mdo = false;
    }

    /* renamed from: dM */
    public final void mo68582dM(Context context) {
        AppMethodBeat.m2504i(TbsMediaPlayerListener.MEDIA_INFO_NO_VIDEO_DATA);
        if (this.mdo) {
            AppMethodBeat.m2505o(TbsMediaPlayerListener.MEDIA_INFO_NO_VIDEO_DATA);
            return;
        }
        this.mdo = true;
        new StringBuilder("lightSensor has started:").append(this.mdo);
        this.bCW = (SensorManager) context.getApplicationContext().getSystemService("sensor");
        Sensor defaultSensor = this.bCW.getDefaultSensor(5);
        if (defaultSensor != null) {
            this.mdn = new C3061a(this, (byte) 0);
            this.bCW.registerListener(this.mdn, defaultSensor, 3);
        }
        AppMethodBeat.m2505o(TbsMediaPlayerListener.MEDIA_INFO_NO_VIDEO_DATA);
    }

    public final float btS() {
        AppMethodBeat.m2504i(TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA);
        if (this.mdn != null) {
            new StringBuilder("Light lux: ").append(this.mdn.mdp);
            float a = this.mdn.mdp;
            AppMethodBeat.m2505o(TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA);
            return a;
        }
        AppMethodBeat.m2505o(TbsMediaPlayerListener.MEDIA_INFO_HAVE_VIDEO_DATA);
        return -1.0f;
    }

    public final void stop() {
        AppMethodBeat.m2504i(753);
        if (!this.mdo || this.bCW == null) {
            AppMethodBeat.m2505o(753);
            return;
        }
        this.mdo = false;
        this.bCW.unregisterListener(this.mdn);
        AppMethodBeat.m2505o(753);
    }
}
