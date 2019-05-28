package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class bf {
    private SensorManager vfZ;
    private a xBK;

    static class a implements SensorListener {
        private Runnable callback;
        private float[] vgc = new float[]{0.0f, 0.0f, 0.0f};

        public a(Runnable runnable) {
            AppMethodBeat.i(52270);
            this.callback = runnable;
            AppMethodBeat.o(52270);
        }

        public final void onAccuracyChanged(int i, int i2) {
        }

        public final void onSensorChanged(int i, float[] fArr) {
            AppMethodBeat.i(52271);
            float[] fArr2 = new float[3];
            int i2 = 0;
            Object obj = null;
            while (i2 < 3) {
                fArr2[i2] = Math.abs(fArr[i2] - this.vgc[i2]);
                if (this.vgc[i2] != 0.0f && fArr2[i2] > 1.0f) {
                    obj = 1;
                    ab.d("MicroMsg.ShakeManager", "isONShake:" + fArr2[i2]);
                }
                this.vgc[i2] = fArr[i2];
                i2++;
            }
            if (obj != null) {
                this.callback.run();
            }
            AppMethodBeat.o(52271);
        }
    }

    public bf(Context context) {
        AppMethodBeat.i(52272);
        this.vfZ = (SensorManager) context.getSystemService("sensor");
        AppMethodBeat.o(52272);
    }

    public final boolean aj(Runnable runnable) {
        AppMethodBeat.i(52273);
        if (this.vfZ == null) {
            AppMethodBeat.o(52273);
            return false;
        }
        List sensorList = this.vfZ.getSensorList(1);
        if (sensorList == null || sensorList.size() <= 0) {
            AppMethodBeat.o(52273);
            return false;
        }
        this.xBK = new a(runnable);
        this.vfZ.registerListener(this.xBK, 2, 3);
        AppMethodBeat.o(52273);
        return true;
    }

    public final void dpt() {
        AppMethodBeat.i(52274);
        if (!(this.vfZ == null || this.xBK == null)) {
            this.vfZ.unregisterListener(this.xBK, 2);
        }
        AppMethodBeat.o(52274);
    }
}
