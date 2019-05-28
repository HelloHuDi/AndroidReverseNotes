package com.tencent.p177mm.plugin.scanner.util;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C6536pq;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector */
public class ScanCameraLightDetector implements SensorEventListener {
    public static final ScanCameraLightDetector qia = new ScanCameraLightDetector();
    public C7306ak handler;
    private float lTs = -1.0f;
    public long qib = -1;
    public Sensor qic;
    public boolean qid = false;
    public HandlerThread qie;
    public SensorManager sensorManager;

    /* renamed from: com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector$1 */
    public class C131721 extends C7306ak {

        /* renamed from: com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector$1$1 */
        class C131711 implements Runnable {
            C131711() {
            }

            public final void run() {
                AppMethodBeat.m2504i(81444);
                C6536pq c6536pq = new C6536pq();
                c6536pq.cLQ.cLR = true;
                C4879a.xxA.mo10055m(c6536pq);
                AppMethodBeat.m2505o(81444);
            }
        }

        /* renamed from: com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector$1$2 */
        class C131732 implements Runnable {
            C131732() {
            }

            public final void run() {
                AppMethodBeat.m2504i(81445);
                C6536pq c6536pq = new C6536pq();
                c6536pq.cLQ.cLR = false;
                C4879a.xxA.mo10055m(c6536pq);
                AppMethodBeat.m2505o(81445);
            }
        }

        public C131721(Looper looper) {
            super(looper);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(81446);
            if (message.what == C31128d.MIC_PTU_MEISHI) {
                C13174a c13174a = (C13174a) message.obj;
                if (c13174a != null) {
                    long yz = C5046bo.m7588yz();
                    C4990ab.m7417i("MicroMsg.ScanCameraLightDetector", "isYuvDark: %s, currentLight: %s, used %sms", Boolean.valueOf(ScanCameraLightDetector.m21190w(c13174a.ovq, c13174a.width, c13174a.height)), Float.valueOf(ScanCameraLightDetector.this.lTs), Long.valueOf(C5046bo.m7525az(yz)));
                    if (ScanCameraLightDetector.m21190w(c13174a.ovq, c13174a.width, c13174a.height)) {
                        C4990ab.m7416i("MicroMsg.ScanCameraLightDetector", "is dark now");
                        C5004al.m7441d(new C131711());
                        AppMethodBeat.m2505o(81446);
                        return;
                    }
                    C4990ab.m7416i("MicroMsg.ScanCameraLightDetector", "not dark");
                    C5004al.m7441d(new C131732());
                }
            }
            AppMethodBeat.m2505o(81446);
        }
    }

    /* renamed from: com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector$a */
    public class C13174a {
        public int height;
        public byte[] ovq;
        public int width;

        private C13174a() {
        }

        public /* synthetic */ C13174a(ScanCameraLightDetector scanCameraLightDetector, byte b) {
            this();
        }
    }

    private static native int calcLumNative(byte[] bArr, int i, int i2);

    static {
        AppMethodBeat.m2504i(81449);
        AppMethodBeat.m2505o(81449);
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr != null && fArr.length > 0) {
            this.lTs = fArr[0];
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
        AppMethodBeat.m2504i(81447);
        C4990ab.m7410d("MicroMsg.ScanCameraLightDetector", "onAccuracyChanged");
        AppMethodBeat.m2505o(81447);
    }

    /* renamed from: w */
    static /* synthetic */ boolean m21190w(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(81448);
        if (!C5046bo.m7540cb(bArr) && bArr.length > i * i2) {
            C4990ab.m7417i("MicroMsg.ScanCameraLightDetector", "lum light: %s", Integer.valueOf(ScanCameraLightDetector.calcLumNative(bArr, i, i2)));
            if (ScanCameraLightDetector.calcLumNative(bArr, i, i2) < 50) {
                AppMethodBeat.m2505o(81448);
                return true;
            }
        }
        AppMethodBeat.m2505o(81448);
        return false;
    }
}
