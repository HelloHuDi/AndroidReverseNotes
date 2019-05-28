package com.tencent.mm.plugin.scanner.util;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class m implements SensorEventListener {
    public static final m qiz = new m();
    public SensorManager bCW = ((SensorManager) ah.getContext().getSystemService("sensor"));
    public Sensor qiv = this.bCW.getDefaultSensor(1);
    public float[] qiw = new float[3];
    public int qix;
    private long qiy;

    static {
        AppMethodBeat.i(81465);
        AppMethodBeat.o(81465);
    }

    private m() {
        AppMethodBeat.i(81462);
        AppMethodBeat.o(81462);
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        AppMethodBeat.i(81463);
        if (sensorEvent.sensor.getType() == 1) {
            float[] fArr = sensorEvent.values;
            ab.d("MicroMsg.ScanStableDetector", "x:%f,y:%f,z:%f", Float.valueOf(fArr[0]), Float.valueOf(fArr[1]), Float.valueOf(fArr[2]));
            if (this.qiw[0] == 0.0f && this.qiw[1] == 0.0f && this.qiw[2] == 0.0f) {
                this.qiw[0] = fArr[0];
                this.qiw[1] = fArr[1];
                this.qiw[2] = fArr[2];
                AppMethodBeat.o(81463);
                return;
            }
            if (Math.abs(fArr[0] - this.qiw[0]) > 0.7f || Math.abs(fArr[1] - this.qiw[1]) > 0.7f || Math.abs(fArr[2] - this.qiw[2]) > 0.7f) {
                ab.d("MicroMsg.ScanStableDetector", "scan unstable");
                this.qix = 0;
            } else {
                if (this.qix == 0) {
                    this.qiy = System.currentTimeMillis();
                }
                this.qix++;
                if (this.qix >= 5) {
                    ab.d("MicroMsg.ScanStableDetector", "scan stable");
                }
            }
            this.qiw[0] = fArr[0];
            this.qiw[1] = fArr[1];
            this.qiw[2] = fArr[2];
        }
        AppMethodBeat.o(81463);
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void stop() {
        AppMethodBeat.i(81464);
        ab.i("MicroMsg.ScanStableDetector", "stop detect scan stable");
        if (this.bCW != null) {
            ab.i("MicroMsg.ScanStableDetector", "unregister accelerate listener");
            this.bCW.unregisterListener(this);
        }
        AppMethodBeat.o(81464);
    }

    public final long cil() {
        if (this.qix >= 5) {
            return this.qiy;
        }
        return 0;
    }
}
