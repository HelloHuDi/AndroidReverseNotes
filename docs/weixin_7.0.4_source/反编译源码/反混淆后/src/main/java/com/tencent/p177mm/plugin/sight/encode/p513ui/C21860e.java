package com.tencent.p177mm.plugin.sight.encode.p513ui;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C41938t;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.pluginsdk.p1082i.C40435a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.sight.encode.ui.e */
final class C21860e implements SensorEventListener {
    private static int otN = BaseClientBuilder.API_PRIORITY_OTHER;
    C41938t erH = null;
    boolean faH = false;
    private Context mContext = null;
    PreviewCallback mPreviewCallback = null;
    boolean otL = false;
    private int otM = 0;
    private float otP = 0.0f;
    private float otQ = 0.0f;
    private float otR = 0.0f;
    private boolean oue = false;
    C40435a qBs = C40435a.diF();
    C21858a qBt = new C21858a(Looper.getMainLooper());

    /* renamed from: com.tencent.mm.plugin.sight.encode.ui.e$a */
    static class C21858a extends C7306ak {
        static AutoFocusCallback faP = new C218591();
        static boolean ouf = true;
        int faG = 0;
        boolean faH = false;
        boolean faI = false;
        boolean faJ = false;
        float faK;
        float faL;
        int faM;
        int faN;

        /* renamed from: com.tencent.mm.plugin.sight.encode.ui.e$a$1 */
        static class C218591 implements AutoFocusCallback {
            C218591() {
            }

            public final void onAutoFocus(boolean z, Camera camera) {
                AppMethodBeat.m2504i(25099);
                C4990ab.m7418v("MicroMsg.SightCamera", "auto focus callback");
                C21858a.ouf = true;
                AppMethodBeat.m2505o(25099);
            }
        }

        static {
            AppMethodBeat.m2504i(25105);
            AppMethodBeat.m2505o(25105);
        }

        /* renamed from: b */
        private static Rect m33396b(float f, float f2, float f3, int i, int i2) {
            AppMethodBeat.m2504i(25100);
            int intValue = Float.valueOf(((float) C1338a.fromDPToPix(C4996ah.getContext(), 72)) * f3).intValue();
            RectF rectF = new RectF();
            rectF.set((((f - ((float) (intValue / 2))) * 2000.0f) / ((float) i)) - 1000.0f, (((f2 - ((float) (intValue / 2))) * 2000.0f) / ((float) i2)) - 1000.0f, (((((float) (intValue / 2)) + f) * 2000.0f) / ((float) i)) - 1000.0f, (((((float) (intValue / 2)) + f2) * 2000.0f) / ((float) i2)) - 1000.0f);
            Rect rect = new Rect(C21858a.m33400yS(Math.round(rectF.left)), C21858a.m33400yS(Math.round(rectF.top)), C21858a.m33400yS(Math.round(rectF.right)), C21858a.m33400yS(Math.round(rectF.bottom)));
            AppMethodBeat.m2505o(25100);
            return rect;
        }

        /* renamed from: yS */
        private static int m33400yS(int i) {
            if (i > 1000) {
                return 1000;
            }
            if (i < -1000) {
                return -1000;
            }
            return i;
        }

        /* renamed from: f */
        static void m33399f(C41938t c41938t) {
            AppMethodBeat.m2504i(25101);
            if (c41938t == null) {
                C4990ab.m7420w("MicroMsg.SightCamera", "want to auto focus, but camera is null, do nothing");
            }
            if (ouf) {
                ouf = false;
                try {
                    c41938t.autoFocus(faP);
                    AppMethodBeat.m2505o(25101);
                    return;
                } catch (Exception e) {
                    C4990ab.m7421w("MicroMsg.SightCamera", "autofocus fail, exception %s", e.getMessage());
                    ouf = true;
                    AppMethodBeat.m2505o(25101);
                    return;
                }
            }
            C4990ab.m7420w("MicroMsg.SightCamera", "auto focus not back");
            AppMethodBeat.m2505o(25101);
        }

        public C21858a(Looper looper) {
            super(looper);
        }

        /* renamed from: d */
        private static int m33397d(Parameters parameters) {
            AppMethodBeat.m2504i(25102);
            if (parameters == null) {
                AppMethodBeat.m2505o(25102);
                return 0;
            }
            int maxZoom;
            try {
                maxZoom = parameters.getMaxZoom() / 2;
                if (maxZoom <= 0) {
                    maxZoom = parameters.getMaxZoom();
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.SightCamera", "get target zoom value error: %s", e.getMessage());
                maxZoom = 0;
            }
            AppMethodBeat.m2505o(25102);
            return maxZoom;
        }

        /* renamed from: f */
        static int m33398f(Parameters parameters) {
            AppMethodBeat.m2504i(25103);
            int d = C21858a.m33397d(parameters) / 6;
            if (d <= 0) {
                d = 1;
            }
            AppMethodBeat.m2505o(25103);
            return d;
        }

        public final void handleMessage(Message message) {
            int i = 1;
            AppMethodBeat.m2504i(25104);
            switch (message.what) {
                case 4353:
                    if (!this.faJ) {
                        int d;
                        Camera camera = (Camera) message.obj;
                        Parameters parameters = camera.getParameters();
                        C4990ab.m7417i("MicroMsg.SightCamera", "zoomed %s curZoomStep %s params.getZoom() %s", Boolean.valueOf(this.faH), Integer.valueOf(this.faG), Integer.valueOf(parameters.getZoom()));
                        int zoom = parameters.getZoom() + this.faG;
                        if (this.faH) {
                            d = C21858a.m33397d(parameters);
                            if (zoom < d) {
                                long j;
                                Message obtainMessage = obtainMessage(4353, message.obj);
                                if (this.faI) {
                                    j = 10;
                                } else {
                                    j = 20;
                                }
                                sendMessageDelayed(obtainMessage, j);
                                d = zoom;
                                i = 0;
                            }
                        } else if (zoom <= 0) {
                            d = 0;
                        } else {
                            sendMessageDelayed(obtainMessage(4353, message.obj), this.faI ? 10 : 20);
                            d = zoom;
                            i = 0;
                        }
                        parameters.setZoom(d);
                        try {
                            camera.setParameters(parameters);
                        } catch (Exception e) {
                            C4990ab.printErrStackTrace("MicroMsg.SightCamera", e, "", new Object[0]);
                        }
                        if (i != 0) {
                            this.faM = 0;
                            this.faN = 0;
                            sendMessageDelayed(obtainMessage(4354, message.obj), 20);
                            break;
                        }
                    }
                    AppMethodBeat.m2505o(25104);
                    return;
                    break;
                case 4354:
                    C41938t c41938t = (C41938t) message.obj;
                    if (this.faM == 0 || this.faM == 0 || C1443d.m3067fP(14)) {
                        C21858a.m33399f(c41938t);
                        AppMethodBeat.m2505o(25104);
                        return;
                    }
                    float f = this.faK;
                    float f2 = this.faL;
                    int i2 = this.faM;
                    int i3 = this.faN;
                    if (c41938t == null) {
                        C4990ab.m7420w("MicroMsg.SightCamera", "want to auto focus, but camera is null, do nothing");
                    }
                    if (ouf) {
                        ouf = false;
                        try {
                            ArrayList arrayList;
                            C4990ab.m7417i("MicroMsg.SightCamera", "ashutest:: touch %f %f, display %d %d", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3));
                            C4990ab.m7417i("MicroMsg.SightCamera", "ashutest:: focus rect %s, meter rect %s", C21858a.m33396b(f, f2, 1.0f, i2, i3), C21858a.m33396b(f, f2, 1.5f, i2, i3));
                            Parameters parameters2 = c41938t.getParameters();
                            List supportedFocusModes = parameters2.getSupportedFocusModes();
                            if (supportedFocusModes != null && supportedFocusModes.contains("auto")) {
                                parameters2.setFocusMode("auto");
                            }
                            if (parameters2.getMaxNumFocusAreas() > 0) {
                                arrayList = new ArrayList(1);
                                arrayList.add(new Area(r6, 1000));
                                parameters2.setFocusAreas(arrayList);
                            }
                            if (parameters2.getMaxNumMeteringAreas() > 0) {
                                arrayList = new ArrayList(1);
                                arrayList.add(new Area(r1, 1000));
                                parameters2.setMeteringAreas(arrayList);
                            }
                            c41938t.setParameters(parameters2);
                            c41938t.autoFocus(faP);
                            AppMethodBeat.m2505o(25104);
                            return;
                        } catch (Exception e2) {
                            C4990ab.m7421w("MicroMsg.SightCamera", "autofocus with area fail, exception %s", e2.getMessage());
                            ouf = true;
                            AppMethodBeat.m2505o(25104);
                            return;
                        }
                    }
                    C4990ab.m7420w("MicroMsg.SightCamera", "auto focus not back");
                    AppMethodBeat.m2505o(25104);
                    return;
            }
            AppMethodBeat.m2505o(25104);
        }
    }

    public C21860e() {
        AppMethodBeat.m2504i(25106);
        AppMethodBeat.m2505o(25106);
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        AppMethodBeat.m2504i(25107);
        float f = sensorEvent.values[0];
        float f2 = sensorEvent.values[1];
        float f3 = sensorEvent.values[2];
        if (Math.abs(this.otP - f) > 3.0f || Math.abs(this.otQ - f2) > 3.0f || Math.abs(this.otR - f3) > 3.0f) {
            C4990ab.m7417i("MicroMsg.SightCamera", "match accel limit %f, try auto focus", Float.valueOf(3.0f));
            C21858a.m33399f(this.erH);
            this.otP = f;
            this.otQ = f2;
            this.otR = f3;
        }
        AppMethodBeat.m2505o(25107);
    }
}
