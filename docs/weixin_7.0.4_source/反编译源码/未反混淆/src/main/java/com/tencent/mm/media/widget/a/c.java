package com.tencent.mm.media.widget.a;

import a.f.b.j;
import a.l;
import a.v;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.t;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import java.util.List;

@l(dWo = {1, 1, 13}, dWp = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 N2\u00020\u0001:\u0001NB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J5\u00101\u001a\u0002022\u0006\u00103\u001a\u00020&2\u0006\u00104\u001a\u00020&2\u0006\u00105\u001a\u00020&2\u0006\u00106\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\u000eH\u0000¢\u0006\u0002\b8J%\u00109\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\u000e2\u0006\u0010;\u001a\u00020\u000eH\u0000¢\u0006\u0002\b<J\u0019\u0010=\u001a\u00020\u000e2\n\u0010>\u001a\u00060?R\u00020@H\u0000¢\u0006\u0002\bAJ\u001b\u0010B\u001a\u00020\u000e2\f\u0010>\u001a\b\u0018\u00010?R\u00020@H\u0000¢\u0006\u0002\bCJ\u0010\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020GH\u0016J7\u0010H\u001a\u00020E2\b\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010%\u001a\u00020&2\u0006\u0010+\u001a\u00020&2\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eH\u0001¢\u0006\u0002\bKJ\u0017\u0010L\u001a\u00020E2\b\u0010I\u001a\u0004\u0018\u00010JH\u0000¢\u0006\u0002\bMR\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR\u001a\u0010\u001c\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\n\"\u0004\b\u001e\u0010\fR\u001a\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020&X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*R\u001a\u0010.\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\n\"\u0004\b0\u0010\f¨\u0006O"}, dWq = {"Lcom/tencent/mm/media/widget/camera/CameraHandler;", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "looper", "Landroid/os/Looper;", "(Landroid/os/Looper;)V", "TAG", "", "bCameraReleased", "", "getBCameraReleased$plugin_mediaeditor_release", "()Z", "setBCameraReleased$plugin_mediaeditor_release", "(Z)V", "curZoomStep", "", "getCurZoomStep$plugin_mediaeditor_release", "()I", "setCurZoomStep$plugin_mediaeditor_release", "(I)V", "displayH", "getDisplayH$plugin_mediaeditor_release", "setDisplayH$plugin_mediaeditor_release", "displayW", "getDisplayW$plugin_mediaeditor_release", "setDisplayW$plugin_mediaeditor_release", "forInitialize", "getForInitialize$plugin_mediaeditor_release", "setForInitialize$plugin_mediaeditor_release", "sAutoFocusBack", "getSAutoFocusBack$plugin_mediaeditor_release", "setSAutoFocusBack$plugin_mediaeditor_release", "sAutoFocusCallback", "Landroid/hardware/Camera$AutoFocusCallback;", "getSAutoFocusCallback$plugin_mediaeditor_release", "()Landroid/hardware/Camera$AutoFocusCallback;", "setSAutoFocusCallback$plugin_mediaeditor_release", "(Landroid/hardware/Camera$AutoFocusCallback;)V", "touchX", "", "getTouchX$plugin_mediaeditor_release", "()F", "setTouchX$plugin_mediaeditor_release", "(F)V", "touchY", "getTouchY$plugin_mediaeditor_release", "setTouchY$plugin_mediaeditor_release", "zoomed", "getZoomed$plugin_mediaeditor_release", "setZoomed$plugin_mediaeditor_release", "calculateTapArea", "Landroid/graphics/Rect;", "x", "y", "coefficient", "surfaceWidth", "surfaceHeight", "calculateTapArea$plugin_mediaeditor_release", "clamp", "min", "max", "clamp$plugin_mediaeditor_release", "getTargetZoomStep", "params", "Landroid/hardware/Camera$Parameters;", "Landroid/hardware/Camera;", "getTargetZoomStep$plugin_mediaeditor_release", "getTargetZoomValue", "getTargetZoomValue$plugin_mediaeditor_release", "handleMessage", "", "msg", "Landroid/os/Message;", "trigetAutoFocus", "camera", "Lcom/tencent/mm/compatible/deviceinfo/MCamera;", "trigetAutoFocus$plugin_mediaeditor_release", "triggerAutoFocus", "triggerAutoFocus$plugin_mediaeditor_release", "Companion", "plugin-mediaeditor_release"})
public final class c extends ak {
    private static final int faQ = faQ;
    private static final int faR = faR;
    private static final int faS = 10;
    private static final int faT = 20;
    private static final int faU = 6;
    public static final a faV = new a();
    private final String TAG = "MicroMsg.CameraHandler";
    private int faG;
    boolean faH;
    private boolean faI;
    boolean faJ;
    float faK;
    float faL;
    int faM;
    int faN;
    boolean faO = true;
    private AutoFocusCallback faP = new b(this);

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0014\u0010\r\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006¨\u0006\u000f"}, dWq = {"Lcom/tencent/mm/media/widget/camera/CameraHandler$Companion;", "", "()V", "FOCUS_MSG_ID", "", "getFOCUS_MSG_ID$plugin_mediaeditor_release", "()I", "ZOOM_DELAY", "getZOOM_DELAY$plugin_mediaeditor_release", "ZOOM_DELAY_FOR_INIT", "getZOOM_DELAY_FOR_INIT$plugin_mediaeditor_release", "ZOOM_MSG_ID", "getZOOM_MSG_ID$plugin_mediaeditor_release", "ZOOM_STEP_NUM", "getZOOM_STEP_NUM$plugin_mediaeditor_release", "plugin-mediaeditor_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "success", "", "camera", "Landroid/hardware/Camera;", "kotlin.jvm.PlatformType", "onAutoFocus"})
    static final class b implements AutoFocusCallback {
        final /* synthetic */ c faW;

        b(c cVar) {
            this.faW = cVar;
        }

        public final void onAutoFocus(boolean z, Camera camera) {
            AppMethodBeat.i(13189);
            ab.v(this.faW.TAG, "auto focus callback success ".concat(String.valueOf(z)));
            this.faW.faO = true;
            AppMethodBeat.o(13189);
        }
    }

    public c(Looper looper) {
        j.p(looper, "looper");
        super(looper);
        AppMethodBeat.i(13193);
        AppMethodBeat.o(13193);
    }

    private static Rect a(float f, float f2, float f3, int i, int i2) {
        AppMethodBeat.i(13190);
        float f4 = 80.0f * f3;
        float f5 = (((f / ((float) i)) * 2000.0f) - 1000.0f) - (f4 / 2.0f);
        float f6 = (((f2 / ((float) i2)) * 2000.0f) - 1000.0f) - (f4 / 2.0f);
        float f7 = f5 + f4;
        f4 += f6;
        RectF rectF = new RectF();
        rectF.set(f5, f6, f7, f4);
        Rect rect = new Rect(ki(Math.round(rectF.left)), ki(Math.round(rectF.top)), ki(Math.round(rectF.right)), ki(Math.round(rectF.bottom)));
        AppMethodBeat.o(13190);
        return rect;
    }

    private static int ki(int i) {
        if (i > 1000) {
            return 1000;
        }
        if (i < -1000) {
            return -1000;
        }
        return i;
    }

    private int a(Parameters parameters) {
        AppMethodBeat.i(13191);
        if (parameters == null) {
            AppMethodBeat.o(13191);
            return 0;
        }
        int maxZoom;
        try {
            maxZoom = parameters.getMaxZoom() / 2;
            if (maxZoom <= 0) {
                maxZoom = parameters.getMaxZoom();
            }
        } catch (Exception e) {
            ab.e(this.TAG, "get target zoom value error: %s", e.getMessage());
            maxZoom = 0;
        }
        AppMethodBeat.o(13191);
        return maxZoom;
    }

    public final void handleMessage(Message message) {
        int i = 1;
        AppMethodBeat.i(13192);
        j.p(message, "msg");
        int i2 = message.what;
        Object obj;
        v vVar;
        t tVar;
        Parameters parameters;
        if (i2 == faR) {
            obj = message.obj;
            if (obj == null) {
                vVar = new v("null cannot be cast to non-null type com.tencent.mm.compatible.deviceinfo.MCamera");
                AppMethodBeat.o(13192);
                throw vVar;
            }
            tVar = (t) obj;
            if (this.faM != 0 && this.faN != 0 && !d.fP(14)) {
                float f = this.faK;
                float f2 = this.faL;
                int i3 = this.faM;
                int i4 = this.faN;
                if (tVar == null) {
                    ab.w(this.TAG, "want to auto focus, but camera is null, do nothing");
                    AppMethodBeat.o(13192);
                    return;
                } else if (this.faO) {
                    this.faO = false;
                    try {
                        ArrayList arrayList;
                        tVar.cancelAutoFocus();
                        ab.i(this.TAG, "ashutest:: touch %f %f, display %d %d", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(i3), Integer.valueOf(i4));
                        ab.i(this.TAG, "ashutest:: focus rect %s, meter rect %s", a(f, f2, 1.0f, i3, i4), a(f, f2, 1.5f, i3, i4));
                        parameters = tVar.getParameters();
                        j.o(parameters, "parameters");
                        List supportedFocusModes = parameters.getSupportedFocusModes();
                        if (supportedFocusModes != null && supportedFocusModes.contains("auto")) {
                            parameters.setFocusMode("auto");
                        }
                        if (parameters.getMaxNumFocusAreas() > 0) {
                            arrayList = new ArrayList(1);
                            arrayList.add(new Area(r7, 1000));
                            parameters.setFocusAreas(arrayList);
                        }
                        if (parameters.getMaxNumMeteringAreas() > 0) {
                            arrayList = new ArrayList(1);
                            arrayList.add(new Area(r2, 1000));
                            parameters.setMeteringAreas(arrayList);
                        }
                        tVar.setParameters(parameters);
                        tVar.autoFocus(this.faP);
                        AppMethodBeat.o(13192);
                        return;
                    } catch (Exception e) {
                        ab.w(this.TAG, "autofocus with area fail, exception %s", e.getMessage());
                        this.faO = true;
                        AppMethodBeat.o(13192);
                        return;
                    }
                } else {
                    ab.w(this.TAG, "auto focus not back");
                    AppMethodBeat.o(13192);
                    return;
                }
            } else if (tVar == null) {
                ab.w(this.TAG, "want to auto focus, but camera is null, do nothing");
                AppMethodBeat.o(13192);
                return;
            } else if (this.faO) {
                this.faO = false;
                try {
                    ab.i(this.TAG, "triggerAutoFocus");
                    tVar.cancelAutoFocus();
                    tVar.autoFocus(this.faP);
                    AppMethodBeat.o(13192);
                    return;
                } catch (Exception e2) {
                    ab.w(this.TAG, "autofocus fail, exception %s", e2.getMessage());
                    this.faO = true;
                    AppMethodBeat.o(13192);
                    return;
                }
            } else {
                ab.w(this.TAG, "auto focus not back");
                AppMethodBeat.o(13192);
                return;
            }
        }
        if (i2 == faQ) {
            if (this.faJ) {
                AppMethodBeat.o(13192);
                return;
            }
            obj = message.obj;
            if (obj == null) {
                vVar = new v("null cannot be cast to non-null type com.tencent.mm.compatible.deviceinfo.MCamera");
                AppMethodBeat.o(13192);
                throw vVar;
            }
            int a;
            tVar = (t) obj;
            parameters = tVar.getParameters();
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(this.faH);
            objArr[1] = Integer.valueOf(this.faG);
            j.o(parameters, "params");
            objArr[2] = Integer.valueOf(parameters.getZoom());
            ab.i(this.TAG, "zoomed %s curZoomStep %s params.getZoom() %s", objArr);
            int zoom = this.faG + parameters.getZoom();
            if (this.faH) {
                a = a(parameters);
                if (zoom < a) {
                    sendMessageDelayed(obtainMessage(faQ, message.obj), (long) (this.faI ? faS : faT));
                    a = zoom;
                    i = 0;
                }
            } else if (zoom <= 0) {
                a = 0;
            } else {
                sendMessageDelayed(obtainMessage(faQ, message.obj), (long) (this.faI ? faS : faT));
                a = zoom;
                i = 0;
            }
            parameters.setZoom(a);
            try {
                tVar.setParameters(parameters);
            } catch (Exception e3) {
            }
            if (i != 0) {
                this.faM = 0;
                this.faN = this.faM;
            }
        }
        AppMethodBeat.o(13192);
    }

    static {
        AppMethodBeat.i(13194);
        AppMethodBeat.o(13194);
    }
}
