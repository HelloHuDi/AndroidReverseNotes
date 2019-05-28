package com.tencent.p177mm.pluginsdk.p1082i;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.List;

/* renamed from: com.tencent.mm.pluginsdk.i.d */
public final class C30050d {
    private SensorManager vfZ;
    private C30051a vga;

    /* renamed from: com.tencent.mm.pluginsdk.i.d$a */
    public static abstract class C30051a implements SensorEventListener {
        private static int vgd;
        private final float[] vgb = new float[]{2.0f, 2.5f, 0.5f};
        private float[] vgc = new float[3];

        public abstract void bUT();

        public static void reset() {
            C4990ab.m7410d("MicroMsg.ShakeSensorListener", "reset threadHold");
            vgd = 5;
            if (Build.MODEL.equals("LG-E510")) {
                vgd = 4;
            }
        }

        static {
            vgd = 5;
            if (Build.MODEL.equals("LG-E510")) {
                vgd = 4;
            }
        }

        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] fArr = new float[3];
            float[] fArr2 = sensorEvent.values;
            int i = 0;
            for (int i2 = 0; i2 < 3; i2++) {
                fArr[i2] = (float) Math.round((this.vgb[i2] * (fArr2[i2] - this.vgc[i2])) * 0.45f);
                float abs = Math.abs(fArr[i2]);
                if (abs >= 4.0f) {
                    C4990ab.m7418v("MicroMsg.ShakeSensorListener", "result:" + abs + " THREAHOLD:" + vgd);
                }
                if (vgd < 9) {
                    if (abs >= 14.0f) {
                        vgd = 9;
                    } else {
                        int i3 = (int) abs;
                        if (vgd < i3 - 4) {
                            vgd = i3 - 4;
                        }
                    }
                }
                if (abs > ((float) vgd)) {
                    i = 1;
                }
                this.vgc[i2] = fArr2[i2];
            }
            if (i != 0) {
                C4990ab.m7410d("MicroMsg.ShakeSensorListener", "sensorChanged " + sensorEvent.sensor.getName() + " (" + fArr2[0] + ", " + fArr2[1] + ", " + fArr2[2] + ") diff(" + fArr[0] + " " + fArr[1] + " " + fArr[2] + ")");
                bUT();
                float[] fArr3 = sensorEvent.values;
            }
        }

        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    }

    public C30050d(Context context) {
        AppMethodBeat.m2504i(79650);
        this.vfZ = (SensorManager) context.getSystemService("sensor");
        AppMethodBeat.m2505o(79650);
    }

    public final boolean diI() {
        return this.vga != null;
    }

    public final void diJ() {
        AppMethodBeat.m2504i(79651);
        if (this.vga != null) {
            C30051a.reset();
        }
        AppMethodBeat.m2505o(79651);
    }

    /* renamed from: a */
    public final void mo48276a(C30051a c30051a) {
        AppMethodBeat.m2504i(79652);
        bgr();
        if (diL()) {
            this.vga = c30051a;
            this.vfZ.registerListener(this.vga, this.vfZ.getDefaultSensor(1), 1);
            AppMethodBeat.m2505o(79652);
            return;
        }
        C4990ab.m7412e("MicroMsg.ShakeSensorService", "no sensor found for shake detection");
        AppMethodBeat.m2505o(79652);
    }

    public final void bgr() {
        AppMethodBeat.m2504i(79653);
        if (this.vga != null) {
            this.vfZ.unregisterListener(this.vga, this.vfZ.getDefaultSensor(1));
            this.vga = null;
        }
        AppMethodBeat.m2505o(79653);
    }

    public final boolean diK() {
        AppMethodBeat.m2504i(79654);
        if (diL()) {
            AppMethodBeat.m2505o(79654);
            return true;
        }
        AppMethodBeat.m2505o(79654);
        return false;
    }

    private boolean diL() {
        AppMethodBeat.m2504i(79655);
        if (this.vfZ == null) {
            C4990ab.m7412e("MicroMsg.ShakeSensorService", "cannot init sensor manager");
            AppMethodBeat.m2505o(79655);
            return false;
        }
        List sensorList = this.vfZ.getSensorList(1);
        if (sensorList == null || sensorList.size() <= 0) {
            AppMethodBeat.m2505o(79655);
            return false;
        }
        AppMethodBeat.m2505o(79655);
        return true;
    }
}
