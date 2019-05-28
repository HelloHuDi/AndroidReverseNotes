package com.tencent.mm.plugin.sight.encode.ui;

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
import com.tencent.mm.compatible.e.t;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import java.util.List;

final class e implements SensorEventListener {
    private static int otN = BaseClientBuilder.API_PRIORITY_OTHER;
    t erH = null;
    boolean faH = false;
    private Context mContext = null;
    PreviewCallback mPreviewCallback = null;
    boolean otL = false;
    private int otM = 0;
    private float otP = 0.0f;
    private float otQ = 0.0f;
    private float otR = 0.0f;
    private boolean oue = false;
    com.tencent.mm.pluginsdk.i.a qBs = com.tencent.mm.pluginsdk.i.a.diF();
    a qBt = new a(Looper.getMainLooper());

    static class a extends ak {
        static AutoFocusCallback faP = new AutoFocusCallback() {
            public final void onAutoFocus(boolean z, Camera camera) {
                AppMethodBeat.i(25099);
                ab.v("MicroMsg.SightCamera", "auto focus callback");
                a.ouf = true;
                AppMethodBeat.o(25099);
            }
        };
        static boolean ouf = true;
        int faG = 0;
        boolean faH = false;
        boolean faI = false;
        boolean faJ = false;
        float faK;
        float faL;
        int faM;
        int faN;

        static {
            AppMethodBeat.i(25105);
            AppMethodBeat.o(25105);
        }

        private static Rect b(float f, float f2, float f3, int i, int i2) {
            AppMethodBeat.i(25100);
            int intValue = Float.valueOf(((float) com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 72)) * f3).intValue();
            RectF rectF = new RectF();
            rectF.set((((f - ((float) (intValue / 2))) * 2000.0f) / ((float) i)) - 1000.0f, (((f2 - ((float) (intValue / 2))) * 2000.0f) / ((float) i2)) - 1000.0f, (((((float) (intValue / 2)) + f) * 2000.0f) / ((float) i)) - 1000.0f, (((((float) (intValue / 2)) + f2) * 2000.0f) / ((float) i2)) - 1000.0f);
            Rect rect = new Rect(yS(Math.round(rectF.left)), yS(Math.round(rectF.top)), yS(Math.round(rectF.right)), yS(Math.round(rectF.bottom)));
            AppMethodBeat.o(25100);
            return rect;
        }

        private static int yS(int i) {
            if (i > 1000) {
                return 1000;
            }
            if (i < -1000) {
                return -1000;
            }
            return i;
        }

        static void f(t tVar) {
            AppMethodBeat.i(25101);
            if (tVar == null) {
                ab.w("MicroMsg.SightCamera", "want to auto focus, but camera is null, do nothing");
            }
            if (ouf) {
                ouf = false;
                try {
                    tVar.autoFocus(faP);
                    AppMethodBeat.o(25101);
                    return;
                } catch (Exception e) {
                    ab.w("MicroMsg.SightCamera", "autofocus fail, exception %s", e.getMessage());
                    ouf = true;
                    AppMethodBeat.o(25101);
                    return;
                }
            }
            ab.w("MicroMsg.SightCamera", "auto focus not back");
            AppMethodBeat.o(25101);
        }

        public a(Looper looper) {
            super(looper);
        }

        private static int d(Parameters parameters) {
            AppMethodBeat.i(25102);
            if (parameters == null) {
                AppMethodBeat.o(25102);
                return 0;
            }
            int maxZoom;
            try {
                maxZoom = parameters.getMaxZoom() / 2;
                if (maxZoom <= 0) {
                    maxZoom = parameters.getMaxZoom();
                }
            } catch (Exception e) {
                ab.e("MicroMsg.SightCamera", "get target zoom value error: %s", e.getMessage());
                maxZoom = 0;
            }
            AppMethodBeat.o(25102);
            return maxZoom;
        }

        static int f(Parameters parameters) {
            AppMethodBeat.i(25103);
            int d = d(parameters) / 6;
            if (d <= 0) {
                d = 1;
            }
            AppMethodBeat.o(25103);
            return d;
        }

        public final void handleMessage(Message message) {
            int i = 1;
            AppMethodBeat.i(25104);
            switch (message.what) {
                case 4353:
                    if (!this.faJ) {
                        int d;
                        Camera camera = (Camera) message.obj;
                        Parameters parameters = camera.getParameters();
                        ab.i("MicroMsg.SightCamera", "zoomed %s curZoomStep %s params.getZoom() %s", Boolean.valueOf(this.faH), Integer.valueOf(this.faG), Integer.valueOf(parameters.getZoom()));
                        int zoom = parameters.getZoom() + this.faG;
                        if (this.faH) {
                            d = d(parameters);
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
                            ab.printErrStackTrace("MicroMsg.SightCamera", e, "", new Object[0]);
                        }
                        if (i != 0) {
                            this.faM = 0;
                            this.faN = 0;
                            sendMessageDelayed(obtainMessage(4354, message.obj), 20);
                            break;
                        }
                    }
                    AppMethodBeat.o(25104);
                    return;
                    break;
                case 4354:
                    t tVar = (t) message.obj;
                    if (this.faM == 0 || this.faM == 0 || d.fP(14)) {
                        f(tVar);
                        AppMethodBeat.o(25104);
                        return;
                    }
                    float f = this.faK;
                    float f2 = this.faL;
                    int i2 = this.faM;
                    int i3 = this.faN;
                    if (tVar == null) {
                        ab.w("MicroMsg.SightCamera", "want to auto focus, but camera is null, do nothing");
                    }
                    if (ouf) {
                        ouf = false;
                        try {
                            ArrayList arrayList;
                            ab.i("MicroMsg.SightCamera", "ashutest:: touch %f %f, display %d %d", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3));
                            ab.i("MicroMsg.SightCamera", "ashutest:: focus rect %s, meter rect %s", b(f, f2, 1.0f, i2, i3), b(f, f2, 1.5f, i2, i3));
                            Parameters parameters2 = tVar.getParameters();
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
                            tVar.setParameters(parameters2);
                            tVar.autoFocus(faP);
                            AppMethodBeat.o(25104);
                            return;
                        } catch (Exception e2) {
                            ab.w("MicroMsg.SightCamera", "autofocus with area fail, exception %s", e2.getMessage());
                            ouf = true;
                            AppMethodBeat.o(25104);
                            return;
                        }
                    }
                    ab.w("MicroMsg.SightCamera", "auto focus not back");
                    AppMethodBeat.o(25104);
                    return;
            }
            AppMethodBeat.o(25104);
        }
    }

    public e() {
        AppMethodBeat.i(25106);
        AppMethodBeat.o(25106);
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        AppMethodBeat.i(25107);
        float f = sensorEvent.values[0];
        float f2 = sensorEvent.values[1];
        float f3 = sensorEvent.values[2];
        if (Math.abs(this.otP - f) > 3.0f || Math.abs(this.otQ - f2) > 3.0f || Math.abs(this.otR - f3) > 3.0f) {
            ab.i("MicroMsg.SightCamera", "match accel limit %f, try auto focus", Float.valueOf(3.0f));
            a.f(this.erH);
            this.otP = f;
            this.otQ = f2;
            this.otR = f3;
        }
        AppMethodBeat.o(25107);
    }
}
