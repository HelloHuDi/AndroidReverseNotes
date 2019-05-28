package com.tencent.p177mm.sdk.platformtools;

import android.content.Context;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

/* renamed from: com.tencent.mm.sdk.platformtools.bf */
public final class C35992bf {
    private SensorManager vfZ;
    private C35991a xBK;

    /* renamed from: com.tencent.mm.sdk.platformtools.bf$a */
    static class C35991a implements SensorListener {
        private Runnable callback;
        private float[] vgc = new float[]{0.0f, 0.0f, 0.0f};

        public C35991a(Runnable runnable) {
            AppMethodBeat.m2504i(52270);
            this.callback = runnable;
            AppMethodBeat.m2505o(52270);
        }

        public final void onAccuracyChanged(int i, int i2) {
        }

        public final void onSensorChanged(int i, float[] fArr) {
            AppMethodBeat.m2504i(52271);
            float[] fArr2 = new float[3];
            int i2 = 0;
            Object obj = null;
            while (i2 < 3) {
                fArr2[i2] = Math.abs(fArr[i2] - this.vgc[i2]);
                if (this.vgc[i2] != 0.0f && fArr2[i2] > 1.0f) {
                    obj = 1;
                    C4990ab.m7410d("MicroMsg.ShakeManager", "isONShake:" + fArr2[i2]);
                }
                this.vgc[i2] = fArr[i2];
                i2++;
            }
            if (obj != null) {
                this.callback.run();
            }
            AppMethodBeat.m2505o(52271);
        }
    }

    public C35992bf(Context context) {
        AppMethodBeat.m2504i(52272);
        this.vfZ = (SensorManager) context.getSystemService("sensor");
        AppMethodBeat.m2505o(52272);
    }

    /* renamed from: aj */
    public final boolean mo56732aj(Runnable runnable) {
        AppMethodBeat.m2504i(52273);
        if (this.vfZ == null) {
            AppMethodBeat.m2505o(52273);
            return false;
        }
        List sensorList = this.vfZ.getSensorList(1);
        if (sensorList == null || sensorList.size() <= 0) {
            AppMethodBeat.m2505o(52273);
            return false;
        }
        this.xBK = new C35991a(runnable);
        this.vfZ.registerListener(this.xBK, 2, 3);
        AppMethodBeat.m2505o(52273);
        return true;
    }

    public final void dpt() {
        AppMethodBeat.m2504i(52274);
        if (!(this.vfZ == null || this.xBK == null)) {
            this.vfZ.unregisterListener(this.xBK, 2);
        }
        AppMethodBeat.m2505o(52274);
    }
}
