package com.tencent.mm.plugin.scanner.util;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.view.d;

public class ScanCameraLightDetector implements SensorEventListener {
    public static final ScanCameraLightDetector qia = new ScanCameraLightDetector();
    public ak handler;
    private float lTs = -1.0f;
    public long qib = -1;
    public Sensor qic;
    public boolean qid = false;
    public HandlerThread qie;
    public SensorManager sensorManager;

    /* renamed from: com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector$1 */
    public class AnonymousClass1 extends ak {
        public AnonymousClass1(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(81446);
            if (message.what == d.MIC_PTU_MEISHI) {
                a aVar = (a) message.obj;
                if (aVar != null) {
                    long yz = bo.yz();
                    ab.i("MicroMsg.ScanCameraLightDetector", "isYuvDark: %s, currentLight: %s, used %sms", Boolean.valueOf(ScanCameraLightDetector.w(aVar.ovq, aVar.width, aVar.height)), Float.valueOf(ScanCameraLightDetector.this.lTs), Long.valueOf(bo.az(yz)));
                    if (ScanCameraLightDetector.w(aVar.ovq, aVar.width, aVar.height)) {
                        ab.i("MicroMsg.ScanCameraLightDetector", "is dark now");
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(81444);
                                pq pqVar = new pq();
                                pqVar.cLQ.cLR = true;
                                com.tencent.mm.sdk.b.a.xxA.m(pqVar);
                                AppMethodBeat.o(81444);
                            }
                        });
                        AppMethodBeat.o(81446);
                        return;
                    }
                    ab.i("MicroMsg.ScanCameraLightDetector", "not dark");
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(81445);
                            pq pqVar = new pq();
                            pqVar.cLQ.cLR = false;
                            com.tencent.mm.sdk.b.a.xxA.m(pqVar);
                            AppMethodBeat.o(81445);
                        }
                    });
                }
            }
            AppMethodBeat.o(81446);
        }
    }

    public class a {
        public int height;
        public byte[] ovq;
        public int width;

        private a() {
        }

        public /* synthetic */ a(ScanCameraLightDetector scanCameraLightDetector, byte b) {
            this();
        }
    }

    private static native int calcLumNative(byte[] bArr, int i, int i2);

    static {
        AppMethodBeat.i(81449);
        AppMethodBeat.o(81449);
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr != null && fArr.length > 0) {
            this.lTs = fArr[0];
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
        AppMethodBeat.i(81447);
        ab.d("MicroMsg.ScanCameraLightDetector", "onAccuracyChanged");
        AppMethodBeat.o(81447);
    }

    static /* synthetic */ boolean w(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(81448);
        if (!bo.cb(bArr) && bArr.length > i * i2) {
            ab.i("MicroMsg.ScanCameraLightDetector", "lum light: %s", Integer.valueOf(calcLumNative(bArr, i, i2)));
            if (calcLumNative(bArr, i, i2) < 50) {
                AppMethodBeat.o(81448);
                return true;
            }
        }
        AppMethodBeat.o(81448);
        return false;
    }
}
