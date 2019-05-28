package com.tencent.p177mm.plugin.scanner.util;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.scanner.util.m */
public final class C21731m implements SensorEventListener {
    public static final C21731m qiz = new C21731m();
    public SensorManager bCW = ((SensorManager) C4996ah.getContext().getSystemService("sensor"));
    public Sensor qiv = this.bCW.getDefaultSensor(1);
    public float[] qiw = new float[3];
    public int qix;
    private long qiy;

    static {
        AppMethodBeat.m2504i(81465);
        AppMethodBeat.m2505o(81465);
    }

    private C21731m() {
        AppMethodBeat.m2504i(81462);
        AppMethodBeat.m2505o(81462);
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        AppMethodBeat.m2504i(81463);
        if (sensorEvent.sensor.getType() == 1) {
            float[] fArr = sensorEvent.values;
            C4990ab.m7411d("MicroMsg.ScanStableDetector", "x:%f,y:%f,z:%f", Float.valueOf(fArr[0]), Float.valueOf(fArr[1]), Float.valueOf(fArr[2]));
            if (this.qiw[0] == 0.0f && this.qiw[1] == 0.0f && this.qiw[2] == 0.0f) {
                this.qiw[0] = fArr[0];
                this.qiw[1] = fArr[1];
                this.qiw[2] = fArr[2];
                AppMethodBeat.m2505o(81463);
                return;
            }
            if (Math.abs(fArr[0] - this.qiw[0]) > 0.7f || Math.abs(fArr[1] - this.qiw[1]) > 0.7f || Math.abs(fArr[2] - this.qiw[2]) > 0.7f) {
                C4990ab.m7410d("MicroMsg.ScanStableDetector", "scan unstable");
                this.qix = 0;
            } else {
                if (this.qix == 0) {
                    this.qiy = System.currentTimeMillis();
                }
                this.qix++;
                if (this.qix >= 5) {
                    C4990ab.m7410d("MicroMsg.ScanStableDetector", "scan stable");
                }
            }
            this.qiw[0] = fArr[0];
            this.qiw[1] = fArr[1];
            this.qiw[2] = fArr[2];
        }
        AppMethodBeat.m2505o(81463);
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void stop() {
        AppMethodBeat.m2504i(81464);
        C4990ab.m7416i("MicroMsg.ScanStableDetector", "stop detect scan stable");
        if (this.bCW != null) {
            C4990ab.m7416i("MicroMsg.ScanStableDetector", "unregister accelerate listener");
            this.bCW.unregisterListener(this);
        }
        AppMethodBeat.m2505o(81464);
    }

    public final long cil() {
        if (this.qix >= 5) {
            return this.qiy;
        }
        return 0;
    }
}
