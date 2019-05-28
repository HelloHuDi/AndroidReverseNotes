package com.tencent.p177mm.plugin.mmsight.model;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.support.p057v4.widget.C8415j;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p1188f.C37657b;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.p221e.C32468d;
import com.tencent.p177mm.compatible.p221e.C32468d.C32469a.C32470a;
import com.tencent.p177mm.compatible.p221e.C41938t;
import com.tencent.p177mm.compatible.p221e.C45290m;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.modelcontrol.VideoTransPara;
import com.tencent.p177mm.p230g.p231a.C18330mi;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.plugin.base.model.C42780a;
import com.tencent.p177mm.plugin.mmsight.C3475d;
import com.tencent.p177mm.plugin.mmsight.model.C39388g.C39389b;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43305j;
import com.tencent.p177mm.plugin.mmsight.model.p456a.C43306k;
import com.tencent.p177mm.plugin.sight.base.SightVideoJNI;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.mmsight.model.e */
public final class C39385e implements SensorEventListener {
    protected static int otN = BaseClientBuilder.API_PRIORITY_OTHER;
    static boolean ouf = true;
    protected boolean aJI = false;
    protected SensorManager bCW;
    protected C41938t erH = null;
    protected boolean faH = false;
    AutoFocusCallback faP = new C393862();
    protected List<C39387f> faZ = new ArrayList();
    protected boolean fas = true;
    protected C34552p fav = C34552p.bPJ();
    protected C32470a fbb;
    protected Point fbc = null;
    protected int fbd = -1;
    protected int fbe = -1;
    private C34547b fbf = new C34547b("prevcameraCallback");
    private C34547b fbg = new C34547b("cameraCallback");
    private C34547b fbh = new C34547b("cameraPreviewCallback");
    private C34547b fbi = new C34547b("cameraCropCallback");
    private C34547b fbj = new C34547b("finishCallbackTimeCallback");
    public volatile boolean fbk = false;
    public volatile byte[] fbl = null;
    protected Context mContext = null;
    protected boolean otL = false;
    protected int otM = 0;
    protected Sensor otO;
    protected float otP = 0.0f;
    protected float otQ = 0.0f;
    protected float otR = 0.0f;
    protected Point otS = null;
    protected Point otT = null;
    protected int otU = 0;
    protected byte[] otV;
    protected boolean otW = false;
    protected C42780a otX = new C42780a();
    protected boolean otY = false;
    protected boolean otZ = false;
    private C39384a oua = C39384a.Preview;
    private C34547b oub = new C34547b("mirrorCameraCallback");
    protected VideoTransPara ouc;
    public boolean oud = false;
    private boolean oue = false;
    public C21305c oug = new C21305c(Looper.getMainLooper());
    private int scene = 0;

    /* renamed from: com.tencent.mm.plugin.mmsight.model.e$1 */
    class C213041 implements PreviewCallback {
        C213041() {
        }

        public final void onPreviewFrame(byte[] bArr, Camera camera) {
            AppMethodBeat.m2504i(76468);
            if (!C39385e.this.otZ) {
                C4990ab.m7417i("MicroMsg.MMSightCamera", "onPreviewFrame: %s %s", bArr, C39385e.this.erH);
                C39385e.this.otZ = true;
            }
            if (bArr == null || bArr.length <= 0) {
                C4990ab.m7412e("MicroMsg.MMSightCamera", "onPreviewFrame, frame data is null!!");
                AppMethodBeat.m2505o(76468);
                return;
            }
            int i;
            byte[] bArr2;
            byte[] bArr3;
            C42780a c42780a = C39385e.this.otX;
            if (c42780a.jDk == 0) {
                c42780a.jDj++;
                c42780a.jDi = C5046bo.ank(C45290m.m83512Lz());
            }
            c42780a.jDk++;
            if (c42780a.jDk >= 90) {
                i = 0;
            } else {
                i = c42780a.jDk;
            }
            c42780a.jDk = i;
            long yz;
            int i2;
            boolean z;
            if (C39385e.this.fbk || C39385e.this.faZ == null || C39385e.this.faZ.size() <= 0) {
                bArr2 = bArr;
                bArr3 = bArr;
            } else if (C39385e.this.fbc != null) {
                bArr2 = C43305j.owk.mo68846g(Integer.valueOf(((C39385e.this.fav.lZe * C39385e.this.fbc.y) * 3) / 2));
                C39385e.this.fbh.mo55078jl(1);
                yz = C5046bo.m7588yz();
                SightVideoJNI.cropCameraData(bArr, bArr2, C39385e.this.fav.lZe, C39385e.this.fav.lZf, C39385e.this.fbc.y);
                if (C39385e.this.fbc.x < C39385e.this.fav.lZe) {
                    bArr3 = C43305j.owk.mo68846g(Integer.valueOf(((C39385e.this.fbc.x * C39385e.this.fbc.y) * 3) / 2));
                    SightVideoJNI.cropCameraDataLongEdge(bArr2, bArr3, C39385e.this.fav.lZe, C39385e.this.fbc.x, C39385e.this.fbc.y);
                    C43305j.owk.mo68845g(bArr2);
                } else {
                    bArr3 = bArr2;
                }
                C39385e.this.fbi.mo55078jl(C5046bo.m7525az(yz));
                if (!C39385e.this.fas) {
                    yz = C5046bo.m7588yz();
                    i2 = C39385e.this.fbc.x;
                    int i3 = C39385e.this.fbc.y;
                    z = C39385e.this.fbb.rotate == 270 || C39385e.this.fbb.rotate == 90;
                    SightVideoJNI.mirrorCameraData(bArr3, i2, i3, z);
                    C39385e.this.oub.mo55078jl(C5046bo.m7525az(yz));
                }
                z = C39385e.m67191a(C39385e.this, bArr3);
                yz = C5046bo.m7525az(yz);
                if (z) {
                    C39385e.this.fbj.mo55078jl(yz);
                }
                bArr2 = bArr;
            } else {
                yz = C5046bo.m7588yz();
                if (!C39385e.this.fas) {
                    int i4 = C39385e.this.fav.lZe;
                    i2 = C39385e.this.fav.lZf;
                    boolean z2 = C39385e.this.fbb.rotate == 270 || C39385e.this.fbb.rotate == 90;
                    SightVideoJNI.mirrorCameraData(bArr, i4, i2, z2);
                    C39385e.this.oub.mo55078jl(C5046bo.m7525az(yz));
                }
                if (!C39385e.this.otW || C39385e.this.otV == null) {
                    bArr3 = bArr;
                } else {
                    SightVideoJNI.paddingYuvData16(bArr, C39385e.this.otV, C39385e.this.otT.x, C39385e.this.otS.y, C39385e.this.otT.y);
                    bArr3 = C39385e.this.otV;
                }
                z = C39385e.m67191a(C39385e.this, bArr3);
                yz = C5046bo.m7525az(yz);
                if (z) {
                    C39385e.this.fbj.mo55078jl(yz);
                }
                if ((!C39385e.this.otW || C39385e.this.otV == null) && z) {
                    bArr = C43305j.owk.mo68846g(Integer.valueOf(bArr.length));
                }
                if (C39385e.this.otW && C39385e.this.otV != null) {
                    C39385e c39385e = C39385e.this;
                    if (z) {
                        bArr2 = C43305j.owk.mo68846g(Integer.valueOf(C39385e.this.otV.length));
                    } else {
                        bArr2 = C39385e.this.otV;
                    }
                    c39385e.otV = bArr2;
                }
                bArr2 = bArr;
            }
            C39385e.this.fbl = bArr3;
            if (C39385e.this.oua == C39384a.Preview) {
                C39385e.this.fbg.mo55078jl(1);
            } else if (C39385e.this.oua == C39384a.Recording) {
                C39385e.this.fbf.mo55078jl(1);
            }
            C39385e.this.erH.addCallbackBuffer(bArr2);
            AppMethodBeat.m2505o(76468);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.model.e$c */
    public class C21305c extends C7306ak {
        int faG = 0;
        boolean faH = false;
        boolean faI = false;
        boolean faJ = false;
        float faK;
        float faL;
        int faM;
        int faN;

        /* renamed from: b */
        private static Rect m32686b(float f, float f2, float f3, int i, int i2) {
            AppMethodBeat.m2504i(76474);
            float f4 = 80.0f * f3;
            float f5 = (((f / ((float) i)) * 2000.0f) - 1000.0f) - (f4 / 2.0f);
            float f6 = (((f2 / ((float) i2)) * 2000.0f) - 1000.0f) - (f4 / 2.0f);
            float f7 = f5 + f4;
            f4 += f6;
            RectF rectF = new RectF();
            rectF.set(f5, f6, f7, f4);
            Rect rect = new Rect(C21305c.m32688yS(Math.round(rectF.left)), C21305c.m32688yS(Math.round(rectF.top)), C21305c.m32688yS(Math.round(rectF.right)), C21305c.m32688yS(Math.round(rectF.bottom)));
            AppMethodBeat.m2505o(76474);
            return rect;
        }

        /* renamed from: yS */
        private static int m32688yS(int i) {
            if (i > 1000) {
                return 1000;
            }
            if (i < -1000) {
                return -1000;
            }
            return i;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: e */
        public final void mo36724e(C41938t c41938t) {
            AppMethodBeat.m2504i(76475);
            if (c41938t == null) {
                C4990ab.m7420w("MicroMsg.MMSightCamera", "want to auto focus, but camera is null, do nothing");
                AppMethodBeat.m2505o(76475);
            } else if (C39385e.ouf) {
                C39385e.ouf = false;
                try {
                    C4990ab.m7416i("MicroMsg.MMSightCamera", "triggerAutoFocus");
                    c41938t.cancelAutoFocus();
                    c41938t.autoFocus(C39385e.this.faP);
                    AppMethodBeat.m2505o(76475);
                } catch (Exception e) {
                    C4990ab.m7421w("MicroMsg.MMSightCamera", "autofocus fail, exception %s", e.getMessage());
                    C39385e.ouf = true;
                    AppMethodBeat.m2505o(76475);
                }
            } else {
                C4990ab.m7420w("MicroMsg.MMSightCamera", "auto focus not back");
                AppMethodBeat.m2505o(76475);
            }
        }

        public C21305c(Looper looper) {
            super(looper);
        }

        /* renamed from: d */
        private static int m32687d(Parameters parameters) {
            AppMethodBeat.m2504i(76476);
            if (parameters == null) {
                AppMethodBeat.m2505o(76476);
                return 0;
            }
            int maxZoom;
            try {
                maxZoom = parameters.getMaxZoom() / 2;
                if (maxZoom <= 0) {
                    maxZoom = parameters.getMaxZoom();
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MMSightCamera", "get target zoom value error: %s", e.getMessage());
                maxZoom = 0;
            }
            AppMethodBeat.m2505o(76476);
            return maxZoom;
        }

        public final void handleMessage(Message message) {
            int i = 1;
            AppMethodBeat.m2504i(76477);
            int zoom;
            switch (message.what) {
                case 4353:
                    if (!this.faJ) {
                        int d;
                        Camera camera = (Camera) message.obj;
                        Parameters parameters = camera.getParameters();
                        C4990ab.m7417i("MicroMsg.MMSightCamera", "zoomed %s curZoomStep %s params.getZoom() %s", Boolean.valueOf(this.faH), Integer.valueOf(this.faG), Integer.valueOf(parameters.getZoom()));
                        zoom = parameters.getZoom() + this.faG;
                        if (this.faH) {
                            d = C21305c.m32687d(parameters);
                            if (zoom < d) {
                                sendMessageDelayed(obtainMessage(4353, message.obj), this.faI ? 10 : 20);
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
                        }
                        if (i != 0) {
                            this.faM = 0;
                            this.faN = 0;
                            break;
                        }
                    }
                    AppMethodBeat.m2505o(76477);
                    return;
                    break;
                case 4354:
                    C41938t c41938t = (C41938t) message.obj;
                    if (this.faM == 0 || this.faN == 0 || C1443d.m3067fP(14)) {
                        mo36724e(c41938t);
                        AppMethodBeat.m2505o(76477);
                        return;
                    }
                    float f = this.faK;
                    float f2 = this.faL;
                    zoom = this.faM;
                    int i2 = this.faN;
                    if (c41938t == null) {
                        C4990ab.m7420w("MicroMsg.MMSightCamera", "want to auto focus, but camera is null, do nothing");
                        AppMethodBeat.m2505o(76477);
                        return;
                    } else if (C39385e.ouf) {
                        C39385e.ouf = false;
                        try {
                            ArrayList arrayList;
                            c41938t.cancelAutoFocus();
                            C4990ab.m7417i("MicroMsg.MMSightCamera", "ashutest:: touch %f %f, display %d %d", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(zoom), Integer.valueOf(i2));
                            C4990ab.m7417i("MicroMsg.MMSightCamera", "ashutest:: focus rect %s, meter rect %s", C21305c.m32686b(f, f2, 1.0f, zoom, i2), C21305c.m32686b(f, f2, 1.5f, zoom, i2));
                            Parameters parameters2 = c41938t.getParameters();
                            List supportedFocusModes = parameters2.getSupportedFocusModes();
                            if (supportedFocusModes != null && supportedFocusModes.contains("auto")) {
                                parameters2.setFocusMode("auto");
                            }
                            if (parameters2.getMaxNumFocusAreas() > 0) {
                                arrayList = new ArrayList(1);
                                arrayList.add(new Area(r7, 1000));
                                parameters2.setFocusAreas(arrayList);
                            }
                            if (parameters2.getMaxNumMeteringAreas() > 0) {
                                arrayList = new ArrayList(1);
                                arrayList.add(new Area(r1, 1000));
                                parameters2.setMeteringAreas(arrayList);
                            }
                            c41938t.setParameters(parameters2);
                            c41938t.autoFocus(C39385e.this.faP);
                            AppMethodBeat.m2505o(76477);
                            return;
                        } catch (Exception e2) {
                            C4990ab.m7421w("MicroMsg.MMSightCamera", "autofocus with area fail, exception %s", e2.getMessage());
                            C39385e.ouf = true;
                            AppMethodBeat.m2505o(76477);
                            return;
                        }
                    } else {
                        C4990ab.m7420w("MicroMsg.MMSightCamera", "auto focus not back");
                        AppMethodBeat.m2505o(76477);
                        return;
                    }
            }
            AppMethodBeat.m2505o(76477);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.model.e$b */
    public interface C34548b {
        /* renamed from: a */
        void mo30824a(byte[] bArr, int i, int i2, int i3, int i4);
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.model.e$3 */
    class C393833 implements AutoFocusCallback {
        C393833() {
        }

        public final void onAutoFocus(boolean z, Camera camera) {
            AppMethodBeat.m2504i(76470);
            if (camera != null && C39385e.this.bPu()) {
                try {
                    Parameters parameters = camera.getParameters();
                    List supportedFocusModes = parameters.getSupportedFocusModes();
                    if (supportedFocusModes != null && supportedFocusModes.contains("continuous-picture")) {
                        C4990ab.m7416i("MicroMsg.MMSightCameraSetting", "support continues picture focus");
                        parameters.setFocusMode("continuous-picture");
                        camera.setParameters(parameters);
                    }
                    AppMethodBeat.m2505o(76470);
                    return;
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.MMSightCamera", e, "simple auto focus resetToPictureFocus error", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(76470);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.model.e$a */
    public enum C39384a {
        Preview,
        Recording,
        Stoping;

        static {
            AppMethodBeat.m2505o(76473);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.model.e$2 */
    class C393862 implements AutoFocusCallback {
        C393862() {
        }

        public final void onAutoFocus(boolean z, Camera camera) {
            AppMethodBeat.m2504i(76469);
            C4990ab.m7419v("MicroMsg.MMSightCamera", "auto focus callback success %s, status: %s", Boolean.valueOf(z), C39385e.this.oua);
            C39385e.ouf = true;
            AppMethodBeat.m2505o(76469);
        }
    }

    public C39385e(VideoTransPara videoTransPara, int i) {
        AppMethodBeat.m2504i(76478);
        this.ouc = videoTransPara;
        this.scene = i;
        AppMethodBeat.m2505o(76478);
    }

    /* renamed from: a */
    public final void mo62281a(C39387f c39387f) {
        AppMethodBeat.m2504i(76479);
        if (c39387f != null) {
            this.faZ.add(c39387f);
        }
        AppMethodBeat.m2505o(76479);
    }

    /* renamed from: b */
    public final void mo62285b(C39387f c39387f) {
        AppMethodBeat.m2504i(76480);
        if (c39387f != null) {
            this.faZ.remove(c39387f);
        }
        AppMethodBeat.m2505o(76480);
    }

    /* renamed from: a */
    public final void mo62279a(C39384a c39384a) {
        AppMethodBeat.m2504i(76481);
        this.oua = c39384a;
        if (c39384a == C39384a.Stoping) {
            int i;
            C12558a bPi = C12558a.bPi();
            String bPk = this.fbg.bPk();
            String bPk2 = this.fbf.bPk();
            C42780a c42780a = this.otX;
            if (c42780a.jDj == 0) {
                i = 0;
            } else {
                i = c42780a.jDi / c42780a.jDj;
            }
            bPi.ott = (int) (C5046bo.anm(bPk) * 10.0d);
            bPi.otu = (int) (C5046bo.anm(bPk2) * 10.0d);
            bPi.otz = i;
        }
        AppMethodBeat.m2505o(76481);
    }

    private void bPl() {
        AppMethodBeat.m2504i(76482);
        try {
            if (!(this.bCW == null || this.otO == null)) {
                this.bCW.unregisterListener(this);
            }
            C4990ab.m7416i("MicroMsg.MMSightCamera", this.fbf.getValue());
            C4990ab.m7416i("MicroMsg.MMSightCamera", this.fbg.getValue());
            C4990ab.m7416i("MicroMsg.MMSightCamera", this.fbh.getValue());
            C4990ab.m7416i("MicroMsg.MMSightCamera", this.fbi.getValue());
            C4990ab.m7416i("MicroMsg.MMSightCamera", this.oub.getValue());
            C4990ab.m7416i("MicroMsg.MMSightCamera", this.fbj.getValue());
            if (this.erH != null) {
                long yz = C5046bo.m7588yz();
                C4990ab.m7417i("MicroMsg.MMSightCamera", "release camera beg, %s", Looper.myLooper());
                this.oug.removeCallbacksAndMessages(null);
                this.oug.faJ = true;
                this.erH.setPreviewCallback(null);
                this.erH.stopPreview();
                this.erH.release();
                this.erH = null;
                this.otL = false;
                C4990ab.m7417i("MicroMsg.MMSightCamera", "release camera end, use %dms, %s", Long.valueOf(C5046bo.m7525az(yz)), Looper.myLooper());
            }
            this.faH = false;
            this.otP = 0.0f;
            this.otQ = 0.0f;
            this.otR = 0.0f;
            ouf = true;
            this.mContext = null;
            this.oue = false;
            this.otT = null;
            this.fbc = null;
            this.fbl = null;
            this.otZ = false;
            AppMethodBeat.m2505o(76482);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MMSightCamera", e, "cameraRelease error", new Object[0]);
            AppMethodBeat.m2505o(76482);
        }
    }

    /* renamed from: b */
    private boolean m67194b(C41938t c41938t, boolean z) {
        AppMethodBeat.m2504i(76483);
        if (c41938t == null) {
            AppMethodBeat.m2505o(76483);
            return false;
        }
        try {
            C12558a bPi;
            boolean z2;
            Point point;
            Parameters parameters = c41938t.getParameters();
            Point eu = C3475d.m5780eu(this.mContext);
            List supportedPreviewSizes;
            List supportedPictureSizes;
            int i;
            if (this.fas) {
                bPi = C12558a.bPi();
                supportedPreviewSizes = parameters.getSupportedPreviewSizes();
                supportedPictureSizes = parameters.getSupportedPictureSizes();
                i = this.fbb.rotate;
                if (C5046bo.isNullOrNil(bPi.otj)) {
                    bPi.otj = C3475d.m5777cp(supportedPreviewSizes);
                }
                if (C5046bo.isNullOrNil(bPi.otk)) {
                    bPi.otk = C3475d.m5777cp(supportedPictureSizes);
                }
                bPi.rotate = i;
                bPi.otE = 1;
            } else {
                bPi = C12558a.bPi();
                supportedPreviewSizes = parameters.getSupportedPreviewSizes();
                supportedPictureSizes = parameters.getSupportedPictureSizes();
                i = this.fbb.rotate;
                if (C5046bo.isNullOrNil(bPi.otl)) {
                    bPi.otl = C3475d.m5777cp(supportedPreviewSizes);
                }
                if (C5046bo.isNullOrNil(bPi.otm)) {
                    bPi.otm = C3475d.m5777cp(supportedPictureSizes);
                }
                bPi.rotate = i;
                bPi.otE = 2;
            }
            if (z) {
                z2 = this.fbb.rotate == 90 || this.fbb.rotate == 270;
                C12563j.m20497a(parameters, z2);
            }
            C43306k.bPR();
            int bPU = C43306k.bPU();
            if (this.fbb.rotate == 90 || this.fbb.rotate == 270) {
                z2 = true;
            } else {
                z2 = false;
            }
            C39389b a = C39388g.m67218a(parameters, eu, bPU, z2);
            if (a == null || a.oum == null) {
                C4990ab.m7412e("MicroMsg.MMSightCamera", "fuck, preview size still null!!");
                point = new Point(Math.min(eu.x, eu.y), Math.max(eu.x, eu.y));
                z2 = this.fbb.rotate == 90 || this.fbb.rotate == 270;
                a = C39388g.m67220c(parameters, point, 2100, z2);
                this.oud = false;
            }
            C39389b c39389b = a;
            C12563j.m20498a(c39389b);
            Point point2 = c39389b.oum;
            if (point2 == null) {
                C34549k.bPD();
                AppMethodBeat.m2505o(76483);
                return false;
            }
            boolean z3;
            int i2;
            this.fav.lZe = point2.x;
            this.fav.lZf = point2.y;
            this.otT = point2;
            Context context = this.mContext;
            z2 = this.fbb.rotate == 90 || this.fbb.rotate == 270;
            z2 = C3475d.m5771a(context, point2, z2);
            Object obj = 1;
            if (this.fbb.rotate == 90 || this.fbb.rotate == 270) {
                if (point2.y < this.ouc.width || point2.x < this.ouc.height) {
                    obj = null;
                    C4990ab.m7421w("MicroMsg.MMSightCamera", "previewSize %s not support real scale", point2);
                }
            } else if (point2.x < this.ouc.width || point2.y < this.ouc.height) {
                obj = null;
                C4990ab.m7421w("MicroMsg.MMSightCamera", "previewSize %s not support real scale", point2);
            }
            C4990ab.m7417i("MicroMsg.MMSightCameraSetting", "checkIfNeedUsePreviewLarge, needCrop: %s", Boolean.valueOf(z2));
            if (z2) {
                if (C12563j.ouz.etz == 2) {
                    this.fbc = c39389b.ouo;
                    if (this.fbc.x < point2.x || this.fbc.y < point2.y) {
                        if (this.fbb.rotate == 90 || this.fbb.rotate == 270) {
                            this.fbc.y = C3475d.m5788yQ(this.fbc.y);
                        } else {
                            this.fbc.x = C3475d.m5788yQ(this.fbc.x);
                        }
                    }
                } else {
                    this.fbc = c39389b.oun;
                }
                this.otT = new Point(this.fbc.x, this.fbc.y);
                this.otU = ((this.fbc.x * this.fbc.y) * 3) / 2;
                C4990ab.m7417i("MicroMsg.MMSightCameraSetting", "cropSize: %s", this.fbc);
                z3 = z2;
            } else {
                if (C12563j.ouz.ouM && C12563j.ouz.fay == FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN && obj != null) {
                    int yP;
                    int i3;
                    int yP2;
                    if (this.fbb.rotate == 90 || this.fbb.rotate == 270) {
                        bPU = point2.y / 2;
                        yP = C3475d.m5787yP(bPU);
                        i3 = point2.x / 2;
                        yP2 = C3475d.m5787yP(i3);
                        if (Math.abs(yP - bPU) >= 8 || Math.abs(yP2 - i3) >= 8) {
                            this.fbc = new Point(point2.x, point2.y);
                            this.fbc.y = C3475d.m5788yQ(point2.y);
                            this.fbc.x = C3475d.m5788yQ(point2.x);
                            this.otT = new Point(this.fbc.x, this.fbc.y);
                            this.otU = ((this.fbc.x * this.fbc.y) * 3) / 2;
                            z2 = true;
                        }
                        z3 = z2;
                    } else {
                        bPU = point2.x / 2;
                        yP = C3475d.m5787yP(bPU);
                        i3 = point2.y / 2;
                        yP2 = C3475d.m5787yP(i3);
                        if (Math.abs(yP - bPU) >= 8 || Math.abs(yP2 - i3) >= 8) {
                            this.fbc = new Point(point2.x, point2.y);
                            this.fbc.y = C3475d.m5788yQ(point2.x);
                            this.fbc.x = C3475d.m5788yQ(point2.y);
                            this.otT = new Point(this.fbc.x, this.fbc.y);
                            this.otU = ((this.fbc.x * this.fbc.y) * 3) / 2;
                            z3 = true;
                        }
                    }
                }
                z3 = z2;
            }
            if (C12563j.ouz.ouM) {
                if (this.fbb.rotate == 90 || this.fbb.rotate == 270) {
                    if (obj != null) {
                        if (C12563j.ouz.fay == FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN) {
                            this.otT = new Point(C3475d.m5781ev(this.fbc == null ? point2.x / 2 : this.fbc.x / 2, this.fbc == null ? point2.x : this.fbc.x), C3475d.m5781ev(this.fbc == null ? point2.y / 2 : this.fbc.y / 2, this.fbc == null ? point2.y : this.fbc.y));
                        } else if (C12563j.ouz.fay == 720) {
                            this.otT = new Point(C3475d.m5781ev((int) (this.fbc == null ? ((float) point2.x) * 0.75f : ((float) this.fbc.x) * 0.75f), this.fbc == null ? point2.x : this.fbc.x), C3475d.m5781ev((int) (this.fbc == null ? ((float) point2.y) * 0.75f : ((float) this.fbc.y) * 0.75f), this.fbc == null ? point2.y : this.fbc.y));
                        }
                    }
                } else if (obj != null) {
                    if (C12563j.ouz.fay == FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN) {
                        this.otT = new Point(C3475d.m5781ev(this.fbc == null ? point2.y / 2 : this.fbc.y / 2, this.fbc == null ? point2.y : this.fbc.y), C3475d.m5781ev(this.fbc == null ? point2.x / 2 : this.fbc.x / 2, this.fbc == null ? point2.x : this.fbc.x));
                    } else if (C12563j.ouz.fay == 720) {
                        bPU = (int) (this.fbc == null ? ((float) point2.x) * 0.75f : ((float) this.fbc.x) * 0.75f);
                        int ev = C3475d.m5781ev((int) (this.fbc == null ? ((float) point2.y) * 0.75f : ((float) this.fbc.y) * 0.75f), this.fbc == null ? point2.y : this.fbc.y);
                        if (this.fbc == null) {
                            i2 = point2.x;
                        } else {
                            i2 = this.fbc.x;
                        }
                        this.otT = new Point(ev, C3475d.m5781ev(bPU, i2));
                    }
                }
            }
            bPi = C12558a.bPi();
            eu = this.fbc;
            point = this.otT;
            bPi.ots = -1;
            bPi.otr = -1;
            bPi.oto = -1;
            bPi.otn = -1;
            bPi.otq = -1;
            bPi.otp = -1;
            if (point2 != null) {
                bPi.otp = point2.x;
                bPi.otq = point2.y;
            }
            if (eu != null) {
                bPi.otn = eu.x;
                bPi.oto = eu.y;
            }
            if (point != null) {
                bPi.otr = point.x;
                bPi.ots = point.y;
            }
            if (z) {
                if (z3 || C12563j.ouz.etz != 2 || C3475d.m5786yO(this.otT.y)) {
                    C12563j.m20500d(this.otT);
                } else {
                    i2 = C3475d.m5787yP(this.otT.y);
                    if (Math.abs(i2 - this.otT.y) <= 16) {
                        C4990ab.m7417i("MicroMsg.MMSightCamera", "padding 16 for encode video best size: %s, alignY: %s", this.otT, Integer.valueOf(i2));
                        this.otS = new Point(this.otT.x, this.otT.y);
                        this.otT.y = i2;
                        this.otW = true;
                        this.otV = new byte[(((this.otT.x * this.otT.y) * 3) / 2)];
                    } else {
                        C12563j.m20500d(this.otT);
                    }
                }
            } else if (!z3 && C12563j.ouz.etz == 2 && !C3475d.m5786yO(this.otT.y) && this.otW && this.otV != null && this.otS.y == this.otT.y) {
                i2 = C3475d.m5787yP(this.otT.y);
                if (this.otV.length == ((this.otT.x * i2) * 3) / 2) {
                    this.otT.y = i2;
                }
            }
            C4990ab.m7417i("MicroMsg.MMSightCameraSetting", "final set camera preview size: %s, encodeVideoBestSize: %s, cropSize: %s", point2, this.otT, this.fbc);
            parameters.setPreviewSize(this.fav.lZe, this.fav.lZf);
            c41938t.setParameters(parameters);
            AppMethodBeat.m2505o(76483);
            return true;
        } catch (Exception e) {
            C4990ab.m7417i("MicroMsg.MMSightCameraSetting", "setPreviewSize Exception, %s, %s", Looper.myLooper(), e.getMessage());
            AppMethodBeat.m2505o(76483);
            return false;
        }
    }

    /* renamed from: a */
    private boolean m67188a(C41938t c41938t, int i, float f, boolean z) {
        AppMethodBeat.m2504i(76484);
        if (c41938t == null || i <= 0) {
            AppMethodBeat.m2505o(76484);
            return false;
        }
        try {
            int i2;
            boolean z2;
            Parameters parameters = c41938t.getParameters();
            Point point = new Point(i, (int) (((float) i) / f));
            point = C5222ae.m7953hy(C4996ah.getContext());
            Point point2 = new Point(Math.min(point.x, point.y), Math.max(point.x, point.y));
            C4990ab.m7417i("MicroMsg.MMSightCamera", "screenSize: %s, currentScreenSize: %s", point2, point);
            float min = ((float) Math.min(point2.x, point2.y)) / ((float) Math.max(point2.x, point2.y));
            float f2 = 1.0f / f;
            if (f < 1.0f) {
                i2 = i;
            } else {
                i2 = Math.round(((float) i) / f2);
            }
            C4990ab.m7417i("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimitAndRatio, shortSize: %s, displayRatio: %s, screenRatio: %s", Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(min));
            if (this.fbb.rotate == 90 || this.fbb.rotate == 270) {
                z2 = true;
            } else {
                z2 = false;
            }
            C39389b a = C39388g.m67218a(parameters, point2, i2, z2);
            if (a == null || a.oum == null) {
                C4990ab.m7412e("MicroMsg.MMSightCamera", "fuck, preview size still null!!");
                z2 = this.fbb.rotate == 90 || this.fbb.rotate == 270;
                a = C39388g.m67220c(parameters, point2, i, z2);
                this.oud = false;
            }
            if (!(a == null || a.oum == null)) {
                C4990ab.m7417i("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimitAndRatio result preview size: %s, cropHeight: %s", a.oum, Integer.valueOf((int) (((float) a.oum.x) * f)));
                if (((int) (((float) a.oum.x) * f)) <= a.oum.y) {
                    this.oud = false;
                } else {
                    this.oud = true;
                }
            }
            if (!(a == null || a.oum == null)) {
                point = a.oum;
                this.fav.lZe = point.x;
                this.fav.lZf = point.y;
                this.otT = point;
                this.fbc = null;
                if (!z) {
                    if (C12563j.ouz.etz != 2 || C3475d.m5786yO(this.otT.y)) {
                        C12563j.m20500d(this.otT);
                    } else {
                        i2 = C3475d.m5787yP(this.otT.y);
                        if (Math.abs(i2 - this.otT.y) <= 16) {
                            C4990ab.m7417i("MicroMsg.MMSightCamera", "padding 16 for encode video best size: %s, alignY: %s", this.otT, Integer.valueOf(i2));
                            this.otS = new Point(this.otT.x, this.otT.y);
                            this.otT.y = i2;
                            this.otW = true;
                            this.otV = new byte[(((this.otT.x * this.otT.y) * 3) / 2)];
                        } else {
                            C12563j.m20500d(this.otT);
                        }
                    }
                }
                C4990ab.m7417i("MicroMsg.MMSightCameraSetting", "final set camera preview size: %s, encodeVideoBestSize: %s, cropSize: %s, cropWidth: %s", point, this.otT, this.fbc, Boolean.valueOf(this.oud));
                parameters.setPreviewSize(this.fav.lZe, this.fav.lZf);
                c41938t.setParameters(parameters);
                AppMethodBeat.m2505o(76484);
                return true;
            }
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimit error: %s", e.getMessage());
        }
        AppMethodBeat.m2505o(76484);
        return false;
    }

    public final Point getEncodeVideoBestSize() {
        return this.otT;
    }

    @TargetApi(14)
    /* renamed from: c */
    private static boolean m67197c(C41938t c41938t) {
        AppMethodBeat.m2504i(76485);
        if (c41938t == null) {
            AppMethodBeat.m2505o(76485);
            return false;
        }
        try {
            C4990ab.m7416i("MicroMsg.MMSightCameraSetting", "safeSetMetering");
            Parameters parameters = c41938t.getParameters();
            if (parameters.getMaxNumMeteringAreas() > 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Area(new Rect(-1000, -1000, 1000, 1000), 600));
                parameters.setMeteringAreas(arrayList);
            }
            c41938t.setParameters(parameters);
            AppMethodBeat.m2505o(76485);
            return true;
        } catch (Exception e) {
            C4990ab.m7417i("MicroMsg.MMSightCameraSetting", "safeSetMetering Exception, %s, %s", Looper.myLooper(), e.getMessage());
            AppMethodBeat.m2505o(76485);
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m67189a(C41938t c41938t, boolean z) {
        AppMethodBeat.m2504i(76486);
        if (c41938t == null) {
            AppMethodBeat.m2505o(76486);
            return false;
        }
        try {
            List supportedPreviewFrameRates;
            Parameters parameters = c41938t.getParameters();
            int i;
            if (z) {
                if (C1427q.etc.eri > 0) {
                    C4990ab.m7416i("MicroMsg.MMSightCameraSetting", "set frame rate > 0, do not try set preview frame rate");
                } else if (parameters == null) {
                    C4990ab.m7412e("MicroMsg.MMSightCamera", "trySetPreviewFrameRateParameters error, p is null!");
                } else {
                    try {
                        supportedPreviewFrameRates = parameters.getSupportedPreviewFrameRates();
                        if (supportedPreviewFrameRates != null && supportedPreviewFrameRates.size() > 0) {
                            parameters.setPreviewFrameRate(Math.min(30, ((Integer) Collections.max(supportedPreviewFrameRates)).intValue()));
                            C4990ab.m7417i("MicroMsg.MMSightCameraSetting", "set preview frame rate %d", Integer.valueOf(i));
                        }
                    } catch (Exception e) {
                        C4990ab.m7417i("MicroMsg.MMSightCameraSetting", "trySetPreviewFrameRateParameters Exception, %s, %s", Looper.myLooper(), e.getMessage());
                    }
                }
            } else if (C1427q.etc.eri > 0) {
                C4990ab.m7416i("MicroMsg.MMSightCameraSetting", "set frame rate > 0, do not try set preview fps range");
            } else {
                List supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
                if (!(supportedPreviewFpsRange == null || supportedPreviewFpsRange.size() == 0)) {
                    int i2 = C8415j.INVALID_ID;
                    int i3 = C8415j.INVALID_ID;
                    Object obj = null;
                    int size = supportedPreviewFpsRange.size();
                    int i4 = 0;
                    while (i4 < size) {
                        Object obj2;
                        int[] iArr = (int[]) supportedPreviewFpsRange.get(i4);
                        if (iArr != null && iArr.length > 1) {
                            int i5 = iArr[0];
                            i = iArr[1];
                            C4990ab.m7417i("MicroMsg.MMSightCamera", "dkfps %d:[%d %d]", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i));
                            if (i5 >= 0 && i >= i5) {
                                if (i >= i3 && obj == null) {
                                    i3 = i;
                                    i2 = i5;
                                }
                                if (i >= 30000) {
                                    obj2 = 1;
                                    i4++;
                                    obj = obj2;
                                }
                            }
                        }
                        obj2 = obj;
                        i4++;
                        obj = obj2;
                    }
                    C4990ab.m7417i("MicroMsg.MMSightCameraSetting", "dkfps get fit  [%d %d], max target fps %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(30));
                    if (!(i2 == BaseClientBuilder.API_PRIORITY_OTHER || i3 == BaseClientBuilder.API_PRIORITY_OTHER)) {
                        try {
                            parameters.setPreviewFpsRange(i2, i3);
                            C4990ab.m7417i("MicroMsg.MMSightCameraSetting", "set fps range %d %d", Integer.valueOf(i2), Integer.valueOf(i3));
                        } catch (Exception e2) {
                            C4990ab.m7417i("MicroMsg.MMSightCameraSetting", "trySetPreviewFpsRangeParameters Exception, %s, %s", Looper.myLooper(), e2.getMessage());
                        }
                    }
                }
            }
            supportedPreviewFrameRates = parameters.getSupportedPreviewFrameRates();
            C4990ab.m7417i("MicroMsg.MMSightCameraSetting", "use fix mode %B, supported preview frame rates %s", Boolean.valueOf(z), supportedPreviewFrameRates);
            c41938t.setParameters(parameters);
            AppMethodBeat.m2505o(76486);
            return true;
        } catch (Exception e22) {
            C4990ab.m7417i("MicroMsg.MMSightCameraSetting", "setPreviewFrameRate Exception, %s, %s", Looper.myLooper(), e22.getMessage());
            AppMethodBeat.m2505o(76486);
            return false;
        }
    }

    /* renamed from: b */
    private static boolean m67193b(C41938t c41938t) {
        AppMethodBeat.m2504i(76487);
        if (c41938t == null) {
            AppMethodBeat.m2505o(76487);
            return false;
        }
        try {
            C4990ab.m7416i("MicroMsg.MMSightCameraSetting", "safeSetPreviewFormat");
            Parameters parameters = c41938t.getParameters();
            List supportedPreviewFormats = parameters.getSupportedPreviewFormats();
            if (supportedPreviewFormats == null || !supportedPreviewFormats.contains(Integer.valueOf(17))) {
                C4990ab.m7412e("MicroMsg.MMSightCameraSetting", "not support YCbCr_420_SP");
            }
            parameters.setPreviewFormat(17);
            c41938t.setParameters(parameters);
            AppMethodBeat.m2505o(76487);
            return true;
        } catch (Exception e) {
            C4990ab.m7417i("MicroMsg.MMSightCameraSetting", "setPreviewFormat Exception, %s, %s", Looper.myLooper(), e.getMessage());
            AppMethodBeat.m2505o(76487);
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m67187a(C41938t c41938t) {
        AppMethodBeat.m2504i(76488);
        if (c41938t == null) {
            AppMethodBeat.m2505o(76488);
            return false;
        }
        try {
            Parameters parameters = c41938t.getParameters();
            List supportedFocusModes = parameters.getSupportedFocusModes();
            if (supportedFocusModes == null || !supportedFocusModes.contains("continuous-picture")) {
                if (supportedFocusModes != null) {
                    if (supportedFocusModes.contains("continuous-video")) {
                        C4990ab.m7416i("MicroMsg.MMSightCameraSetting", "support continuous video");
                        parameters.setFocusMode("continuous-video");
                    }
                }
                if (supportedFocusModes != null) {
                    if (supportedFocusModes.contains("auto")) {
                        C4990ab.m7416i("MicroMsg.MMSightCameraSetting", "support auto focus");
                        parameters.setFocusMode("auto");
                    }
                }
                C4990ab.m7416i("MicroMsg.MMSightCameraSetting", "not support continuous video or auto focus");
            } else {
                C4990ab.m7416i("MicroMsg.MMSightCameraSetting", "support continuous picture");
                parameters.setFocusMode("continuous-picture");
            }
            c41938t.setParameters(parameters);
            AppMethodBeat.m2505o(76488);
            return true;
        } catch (Exception e) {
            C4990ab.m7417i("MicroMsg.MMSightCameraSetting", "setFocusMode Exception, %s, %s", Looper.myLooper(), e.getMessage());
            AppMethodBeat.m2505o(76488);
            return false;
        }
    }

    public final void bPm() {
        AppMethodBeat.m2504i(76489);
        C4990ab.m7416i("MicroMsg.MMSightCamera", "switchToVideoFocusMode");
        if (this.erH != null && this.otL) {
            try {
                Parameters parameters = this.erH.getParameters();
                List supportedFocusModes = parameters.getSupportedFocusModes();
                if (supportedFocusModes != null && supportedFocusModes.contains("continuous-video")) {
                    C4990ab.m7416i("MicroMsg.MMSightCameraSetting", "support continuous video");
                    parameters.setFocusMode("continuous-video");
                }
                this.erH.setParameters(parameters);
                AppMethodBeat.m2505o(76489);
                return;
            } catch (Exception e) {
                C4990ab.m7417i("MicroMsg.MMSightCamera", "switchToVideoFocusMode error: %s", e.getMessage());
            }
        }
        AppMethodBeat.m2505o(76489);
    }

    public final void bPn() {
        AppMethodBeat.m2504i(76490);
        C4990ab.m7416i("MicroMsg.MMSightCamera", "switchToPictureFocusMode");
        if (this.erH != null && this.otL) {
            try {
                Parameters parameters = this.erH.getParameters();
                List supportedFocusModes = parameters.getSupportedFocusModes();
                if (supportedFocusModes != null && supportedFocusModes.contains("continuous-picture")) {
                    C4990ab.m7416i("MicroMsg.MMSightCameraSetting", "support continuous picture");
                    parameters.setFocusMode("continuous-picture");
                }
                this.erH.setParameters(parameters);
                AppMethodBeat.m2505o(76490);
                return;
            } catch (Exception e) {
                C4990ab.m7417i("MicroMsg.MMSightCamera", "switchToPictureFocusMode error: %s", e.getMessage());
            }
        }
        AppMethodBeat.m2505o(76490);
    }

    /* renamed from: Ws */
    private void m67186Ws() {
        AppMethodBeat.m2504i(76491);
        if (this.erH != null) {
            try {
                Parameters parameters = this.erH.getParameters();
                C4990ab.m7416i("MicroMsg.MMSightCamera", "setPreviewCallbackImpl");
                int bitsPerPixel = (ImageFormat.getBitsPerPixel(parameters.getPreviewFormat()) * (this.fav.lZe * this.fav.lZf)) / 8;
                for (int i = 0; i < 5; i++) {
                    this.erH.addCallbackBuffer(C43305j.owk.mo68846g(Integer.valueOf(bitsPerPixel)));
                }
                this.fbf.reset();
                this.fbg.reset();
                this.fbh.reset();
                this.fbi.reset();
                this.oub.reset();
                this.fbj.reset();
                this.otX = new C42780a();
                this.erH.setPreviewCallbackWithBuffer(new C213041());
                AppMethodBeat.m2505o(76491);
                return;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MMSightCamera", "setPreviewCallbackImpl error: %s", e.getMessage());
            }
        }
        AppMethodBeat.m2505o(76491);
    }

    @TargetApi(11)
    /* renamed from: a */
    public final int mo62278a(SurfaceTexture surfaceTexture, boolean z) {
        AppMethodBeat.m2504i(76492);
        long yz = C5046bo.m7588yz();
        this.otZ = false;
        C4990ab.m7417i("MicroMsg.MMSightCamera", "start preview, previewing %B, %s %s autoConfig %s", Boolean.valueOf(this.otL), Looper.myLooper(), surfaceTexture, Boolean.valueOf(z));
        int line;
        if (this.otL) {
            AppMethodBeat.m2505o(76492);
            return 0;
        } else if (surfaceTexture == null) {
            line = 0 - C1447g.getLine();
            AppMethodBeat.m2505o(76492);
            return line;
        } else {
            C4990ab.m7417i("MicroMsg.MMSightCamera", "this texture %s", surfaceTexture);
            try {
                Integer valueOf;
                boolean z2;
                m67194b(this.erH, z);
                Integer valueOf2 = Integer.valueOf(0);
                if (C43306k.bPR().owm != null) {
                    valueOf = Integer.valueOf(C43306k.bPR().owm.osS);
                } else {
                    valueOf = valueOf2;
                }
                String str = "MicroMsg.MMSightCamera";
                String str2 = "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]";
                Object[] objArr = new Object[6];
                objArr[0] = valueOf;
                String str3 = C1427q.etc.ern == 1 ? "Range" : C1427q.etc.erm == 1 ? "Fix" : "Error";
                objArr[1] = str3;
                objArr[2] = Boolean.valueOf(C1427q.etc.ero == 1);
                if (C1427q.etc.erp == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr[3] = Boolean.valueOf(z2);
                if (C1427q.etc.erq == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr[4] = Boolean.valueOf(z2);
                if (C1427q.etc.err == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr[5] = Boolean.valueOf(z2);
                C4990ab.m7417i(str, str2, objArr);
                if (C1427q.etc.ern == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 1)) {
                    C39385e.m67189a(this.erH, false);
                } else if (C1427q.etc.erm == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 5)) {
                    C39385e.m67189a(this.erH, true);
                }
                if (C1427q.etc.ero == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 2)) {
                    C39385e.m67193b(this.erH);
                }
                if (C1427q.etj.etH != -1 && C1427q.etj.etH == 1 && C1443d.m3069iX(14)) {
                    C39385e.m67197c(this.erH);
                }
                if (C1427q.etc.erq == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 4)) {
                    C39385e.m67187a(this.erH);
                }
                if (C1427q.etc.err == 1 && valueOf.intValue() != 0) {
                    valueOf.intValue();
                }
                C39385e.m67199d(this.erH);
                m67186Ws();
                this.erH.setPreviewTexture(surfaceTexture);
                this.erH.startPreview();
                if (!C12563j.ouz.ouN) {
                    this.bCW.registerListener(this, this.otO, 2);
                } else if (!(C1427q.etc.erq != 0 || this.bCW == null || this.otO == null)) {
                    this.bCW.registerListener(this, this.otO, 2);
                }
                this.otL = true;
                C4990ab.m7417i("MicroMsg.MMSightCamera", "start preview end, use %dms %s", Long.valueOf(C5046bo.m7525az(yz)), Looper.myLooper());
                AppMethodBeat.m2505o(76492);
                return 0;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MMSightCamera", "start preview FAILED, %s, %s", Looper.myLooper(), e.getMessage());
                line = 0 - C1447g.getLine();
                AppMethodBeat.m2505o(76492);
                return line;
            }
        }
    }

    /* renamed from: a */
    public final int mo62277a(SurfaceTexture surfaceTexture, int i, float f, boolean z) {
        AppMethodBeat.m2504i(76493);
        long yz = C5046bo.m7588yz();
        this.otZ = false;
        C4990ab.m7417i("MicroMsg.MMSightCamera", "start preview, previewing %B, %s %s", Boolean.valueOf(this.otL), Looper.myLooper(), surfaceTexture);
        int line;
        if (this.otL) {
            AppMethodBeat.m2505o(76493);
            return 0;
        } else if (surfaceTexture == null) {
            line = 0 - C1447g.getLine();
            AppMethodBeat.m2505o(76493);
            return line;
        } else {
            C4990ab.m7417i("MicroMsg.MMSightCamera", "this texture %s", surfaceTexture);
            try {
                Integer valueOf;
                m67188a(this.erH, i, f, z);
                Integer valueOf2 = Integer.valueOf(0);
                if (C43306k.bPR().owm != null) {
                    valueOf = Integer.valueOf(C43306k.bPR().owm.osS);
                } else {
                    valueOf = valueOf2;
                }
                String str = "MicroMsg.MMSightCamera";
                String str2 = "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]";
                Object[] objArr = new Object[6];
                objArr[0] = valueOf;
                String str3 = C1427q.etc.ern == 1 ? "Range" : C1427q.etc.erm == 1 ? "Fix" : "Error";
                objArr[1] = str3;
                objArr[2] = Boolean.valueOf(C1427q.etc.ero == 1);
                objArr[3] = Boolean.valueOf(C1427q.etc.erp == 1);
                objArr[4] = Boolean.valueOf(C1427q.etc.erq == 1);
                objArr[5] = Boolean.valueOf(C1427q.etc.err == 1);
                C4990ab.m7417i(str, str2, objArr);
                if (C1427q.etc.ern == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 1)) {
                    C39385e.m67189a(this.erH, false);
                } else if (C1427q.etc.erm == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 5)) {
                    C39385e.m67189a(this.erH, true);
                }
                if (C1427q.etc.ero == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 2)) {
                    C39385e.m67193b(this.erH);
                }
                if (C1427q.etj.etH != -1 && C1427q.etj.etH == 1 && C1443d.m3069iX(14)) {
                    C39385e.m67197c(this.erH);
                }
                if (C1427q.etc.erq == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 4)) {
                    C39385e.m67187a(this.erH);
                }
                if (C1427q.etc.err == 1 && valueOf.intValue() != 0) {
                    valueOf.intValue();
                }
                C39385e.m67199d(this.erH);
                m67186Ws();
                this.erH.setPreviewTexture(surfaceTexture);
                this.erH.startPreview();
                if (!C12563j.ouz.ouN) {
                    this.bCW.registerListener(this, this.otO, 2);
                } else if (!(C1427q.etc.erq != 0 || this.bCW == null || this.otO == null)) {
                    this.bCW.registerListener(this, this.otO, 2);
                }
                this.otL = true;
                C4990ab.m7417i("MicroMsg.MMSightCamera", "start preview end, use %dms %s", Long.valueOf(C5046bo.m7525az(yz)), Looper.myLooper());
                AppMethodBeat.m2505o(76493);
                return 0;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MMSightCamera", "start preview FAILED, %s, %s", Looper.myLooper(), e.getMessage());
                line = 0 - C1447g.getLine();
                AppMethodBeat.m2505o(76493);
                return line;
            }
        }
    }

    /* renamed from: d */
    private static void m67199d(C41938t c41938t) {
        AppMethodBeat.m2504i(76494);
        try {
            Parameters parameters = c41938t.getParameters();
            if (parameters.isZoomSupported()) {
                parameters.setZoom(0);
            }
            c41938t.setParameters(parameters);
            AppMethodBeat.m2505o(76494);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MMSightCamera", "safeResetZoom error: %s", e.getMessage());
            AppMethodBeat.m2505o(76494);
        }
    }

    /* renamed from: Wf */
    private void m67185Wf() {
        AppMethodBeat.m2504i(76495);
        if (true == this.oue) {
            AppMethodBeat.m2505o(76495);
        } else if (this.mContext == null) {
            AppMethodBeat.m2505o(76495);
        } else if (!Build.MANUFACTURER.equalsIgnoreCase("meizu") || C37657b.m63681Mj()) {
            C18330mi c18330mi = new C18330mi();
            c18330mi.cIm.type = 2;
            C4879a.xxA.mo10055m(c18330mi);
            if (c18330mi.cIn.cIl) {
                this.oue = true;
                AppMethodBeat.m2505o(76495);
                return;
            }
            C5653c g = C30379h.m48467g(this.mContext, C25738R.string.ehg, C25738R.string.f9238tz);
            if (g != null) {
                g.setCancelable(false);
                g.setCanceledOnTouchOutside(false);
                g.show();
                this.oue = true;
            }
            AppMethodBeat.m2505o(76495);
        } else {
            AppMethodBeat.m2505o(76495);
        }
    }

    public final String bPo() {
        AppMethodBeat.m2504i(76496);
        String str;
        if (this.erH == null) {
            str = "";
            AppMethodBeat.m2505o(76496);
            return str;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            ArrayList c = C3475d.m5775c(this.erH.getParameters());
            Point eu = C3475d.m5780eu(this.mContext);
            stringBuffer.append(String.format("Screen size %d %d r:%.4f\n", new Object[]{Integer.valueOf(eu.x), Integer.valueOf(eu.y), Double.valueOf((((double) eu.x) * 1.0d) / ((double) eu.y))}));
            Iterator it = c.iterator();
            while (it.hasNext()) {
                Size size = (Size) it.next();
                if ((getPreviewWidth() == size.width && getPreviewHeight() == size.height) || (getPreviewWidth() == size.height && getPreviewHeight() == size.width)) {
                    stringBuffer.append(String.format("%s*%s √ r:%.4f\n", new Object[]{Integer.valueOf(size.width), Integer.valueOf(size.height), Double.valueOf((((double) size.height) * 1.0d) / ((double) size.width))}));
                } else {
                    stringBuffer.append(String.format("%s*%s X r:%.4f\n", new Object[]{Integer.valueOf(size.width), Integer.valueOf(size.height), Double.valueOf((((double) size.height) * 1.0d) / ((double) size.width))}));
                }
            }
            if (this.fbc != null) {
                stringBuffer.append("\nSIGHTCROPMODE:  " + this.fbc.x + " " + this.fbc.y + " from " + this.fav.lZe + " " + this.fav.lZf);
            } else {
                stringBuffer.append("\nFinalPreviewSize: " + getPreviewWidth() + " " + getPreviewHeight());
            }
            stringBuffer.append("\ngetOrientation:" + getOrientation());
            stringBuffer.append("\nrecorderOption: " + C1427q.etj.etG);
            str = stringBuffer.toString();
            AppMethodBeat.m2505o(76496);
            return str;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MMSightCamera", "getDebugInfo error: %s", e.getMessage());
            AppMethodBeat.m2505o(76496);
            return null;
        }
    }

    /* renamed from: a */
    public final void mo62280a(C34548b c34548b, boolean z, int i) {
        AppMethodBeat.m2504i(76497);
        C4990ab.m7417i("MicroMsg.MMSightCamera", "takePicture, callback: %s, currentFrameData: %s, isLandscape: %s, degree: %s", c34548b, this.fbl, Boolean.valueOf(z), Integer.valueOf(i));
        if (this.fbl != null) {
            try {
                this.fbk = true;
                Point point = new Point();
                if (this.fbc != null) {
                    point.x = this.fbc.x;
                    point.y = this.fbc.y;
                } else if (this.otV == null || !this.otW) {
                    point.x = this.fav.lZe;
                    point.y = this.fav.lZf;
                } else {
                    point.x = this.otT.x;
                    point.y = this.otT.y;
                }
                byte[] g = C43305j.owk.mo68846g(Integer.valueOf(this.fbl.length));
                System.arraycopy(this.fbl, 0, g, 0, this.fbl.length);
                int i2 = this.fbb.rotate;
                c34548b.mo30824a(g, point.x, point.y, i2, i);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MMSightCamera", "takePicture error: %s", e.getMessage());
                this.fbk = false;
                c34548b.mo30824a(null, 0, 0, -1, 0);
            } finally {
                this.fbk = false;
                AppMethodBeat.m2505o(76497);
            }
            return;
        }
        c34548b.mo30824a(null, 0, 0, -1, 0);
        AppMethodBeat.m2505o(76497);
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        AppMethodBeat.m2504i(76498);
        float f = sensorEvent.values[0];
        float f2 = sensorEvent.values[1];
        float f3 = sensorEvent.values[2];
        if (Math.abs(this.otP - f) > 5.0f || Math.abs(this.otQ - f2) > 5.0f || Math.abs(this.otR - f3) > 5.0f) {
            C4990ab.m7417i("MicroMsg.MMSightCamera", "match accel limit %f, try auto focus x %s y %s z %s", Float.valueOf(5.0f), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3));
            this.oug.mo36724e(this.erH);
            this.otP = f;
            this.otQ = f2;
            this.otR = f3;
        }
        AppMethodBeat.m2505o(76498);
    }

    /* renamed from: b */
    public final void mo62284b(float f, float f2, int i, int i2) {
        AppMethodBeat.m2504i(76499);
        if (C1443d.m3067fP(14)) {
            AppMethodBeat.m2505o(76499);
            return;
        }
        this.oug.removeMessages(4354);
        this.oug.faK = f;
        this.oug.faL = f2;
        this.oug.faM = i;
        this.oug.faN = i2;
        this.oug.sendMessageDelayed(this.oug.obtainMessage(4354, this.erH), 400);
        AppMethodBeat.m2505o(76499);
    }

    public final void bPp() {
        AppMethodBeat.m2504i(76500);
        if (this.erH != null && this.otL) {
            try {
                Parameters parameters = this.erH.getParameters();
                List supportedFocusModes = parameters.getSupportedFocusModes();
                if (supportedFocusModes != null && supportedFocusModes.contains("auto")) {
                    C4990ab.m7416i("MicroMsg.MMSightCameraSetting", "support auto focus");
                    parameters.setFocusMode("auto");
                    this.erH.setParameters(parameters);
                }
                this.erH.cancelAutoFocus();
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.MMSightCamera", e, "simple auto focus error", new Object[0]);
            }
            this.erH.autoFocus(new C393833());
        }
        AppMethodBeat.m2505o(76500);
    }

    /* renamed from: d */
    public final void mo62296d(boolean z, boolean z2, int i) {
        AppMethodBeat.m2504i(76501);
        if (this.erH == null || !this.otL) {
            AppMethodBeat.m2505o(76501);
            return;
        }
        try {
            C4990ab.m7411d("MicroMsg.MMSightCamera", "triggerSmallZoom, zoom: %s", Boolean.valueOf(z));
            if (this.aJI) {
                C4990ab.m7410d("MicroMsg.MMSightCamera", "triggerSmallZoom, zooming, ignore");
                return;
            }
            Parameters parameters = this.erH.getParameters();
            if (parameters.isZoomSupported()) {
                int i2;
                this.aJI = true;
                int zoom = parameters.getZoom();
                int maxZoom = parameters.getMaxZoom();
                if (!z2) {
                    if (this.fbe <= 0) {
                        this.fbe = Math.round(((float) maxZoom) / 15.0f);
                        if (this.fbe > 5) {
                            this.fbe = 5;
                        }
                    }
                    i2 = this.fbe;
                } else if (this.fbd <= 0) {
                    C4990ab.m7413e("MicroMsg.MMSightCamera", "scroll zoom error, scrollSmallZoomStep: %s", Integer.valueOf(this.fbd));
                    this.aJI = false;
                    AppMethodBeat.m2505o(76501);
                    return;
                } else {
                    i2 = this.fbd;
                }
                C4990ab.m7411d("MicroMsg.MMSightCamera", "triggerSmallZoom, currentZoom: %s, maxZoom: %s, smallZoomStep: %s, scrollSmallZoomStep: %s, factor: %s", Integer.valueOf(zoom), Integer.valueOf(maxZoom), Integer.valueOf(this.fbe), Integer.valueOf(this.fbd), Integer.valueOf(i));
                if (i > 0) {
                    i2 *= i;
                }
                if (z) {
                    if (zoom >= maxZoom) {
                        this.aJI = false;
                        AppMethodBeat.m2505o(76501);
                        return;
                    }
                    i2 += zoom;
                    if (i2 < maxZoom) {
                        maxZoom = i2;
                    }
                } else if (zoom == 0) {
                    this.aJI = false;
                    AppMethodBeat.m2505o(76501);
                    return;
                } else {
                    maxZoom = zoom - i2;
                    if (maxZoom <= 0) {
                        maxZoom = 0;
                    }
                }
                C4990ab.m7411d("MicroMsg.MMSightCamera", "triggerSmallZoom, nextZoom: %s", Integer.valueOf(maxZoom));
                parameters.setZoom(maxZoom);
                this.erH.setParameters(parameters);
            }
            this.aJI = false;
            AppMethodBeat.m2505o(76501);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MMSightCamera", "triggerSmallZoom error: %s", e.getMessage());
        } finally {
            this.aJI = false;
            AppMethodBeat.m2505o(76501);
        }
    }

    /* renamed from: kj */
    public final void mo62301kj(int i) {
        AppMethodBeat.m2504i(76502);
        if (this.fbd > 0) {
            AppMethodBeat.m2505o(76502);
            return;
        }
        int i2 = C5222ae.m7953hy(C4996ah.getContext()).y;
        C4990ab.m7417i("MicroMsg.MMSightCamera", "calcScrollZoomStep, recordButtonTopLocation: %s, screenSize: %s", Integer.valueOf(i), r0);
        if (i2 / 2 >= i) {
            AppMethodBeat.m2505o(76502);
            return;
        }
        try {
            if (this.erH != null) {
                this.fbd = ((int) (((double) this.erH.getParameters().getMaxZoom()) / ((((double) i) / 3.0d) / 10.0d))) + 1;
                C4990ab.m7417i("MicroMsg.MMSightCamera", "scrollSmallZoomStep: %s, maxZoom: %s", Integer.valueOf(this.fbd), Integer.valueOf(r0));
            }
            AppMethodBeat.m2505o(76502);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MMSightCamera", "calcScrollZoomStep error: %s", e.getMessage());
            AppMethodBeat.m2505o(76502);
        }
    }

    /* renamed from: v */
    public final boolean mo62304v(Context context, boolean z) {
        AppMethodBeat.m2504i(76503);
        if (!C12563j.ouz.ouN || (C1427q.etc.erq == 0 && this.bCW == null && this.otO == null)) {
            this.bCW = (SensorManager) C4996ah.getContext().getSystemService("sensor");
            this.otO = this.bCW.getDefaultSensor(1);
        }
        if (this.erH == null) {
            bPl();
            this.fas = z;
            if (z) {
                try {
                    this.otM = C32468d.m53152Lr();
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.MMSightCamera", e, "try to get cameraid error %s, useBackCamera: %s", e.getMessage(), Boolean.valueOf(this.fas));
                    this.otM = 0;
                }
            } else {
                this.otM = C32468d.m53153Ls();
            }
            C4990ab.m7417i("MicroMsg.MMSightCamera", "use camera id %d, DeviceInfo id %d", Integer.valueOf(this.otM), Integer.valueOf(C1427q.etc.ert));
            this.oue = false;
            this.mContext = context;
            this.fbb = new C34550n().mo55080R(context, this.otM);
            C4990ab.m7417i("MicroMsg.MMSightCamera", "open camera end, %s", Looper.myLooper());
            if (this.fbb == null) {
                C4990ab.m7417i("MicroMsg.MMSightCamera", "open camera FAILED, %s", Looper.myLooper());
                m67185Wf();
                AppMethodBeat.m2505o(76503);
                return false;
            }
            this.erH = this.fbb.erH;
            this.oug.faJ = false;
            this.fav.rotate = this.fbb.rotate;
            if (this.erH == null) {
                C4990ab.m7412e("MicroMsg.MMSightCamera", "start camera FAILED!");
                m67185Wf();
                AppMethodBeat.m2505o(76503);
                return false;
            }
        }
        AppMethodBeat.m2505o(76503);
        return true;
    }

    /* renamed from: a */
    public final boolean mo62283a(Context context, SurfaceTexture surfaceTexture, boolean z) {
        AppMethodBeat.m2504i(76504);
        C4990ab.m7417i("MicroMsg.MMSightCamera", "switch camera, current useBack: %s", Boolean.valueOf(this.fas));
        try {
            bPq();
            mo62304v(context, !this.fas);
            mo62278a(surfaceTexture, z);
            AppMethodBeat.m2505o(76504);
            return true;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MMSightCamera", "switchCamera error: %s", e);
            AppMethodBeat.m2505o(76504);
            return false;
        }
    }

    /* renamed from: a */
    public final boolean mo62282a(Context context, SurfaceTexture surfaceTexture, int i, float f, boolean z) {
        AppMethodBeat.m2504i(76505);
        C4990ab.m7417i("MicroMsg.MMSightCamera", "switch camera with limit, current useBack: %s", Boolean.valueOf(this.fas));
        try {
            bPq();
            mo62304v(context, !this.fas);
            mo62277a(surfaceTexture, i, f, z);
            AppMethodBeat.m2505o(76505);
            return true;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.MMSightCamera", "switchCamera error: %s", e);
            AppMethodBeat.m2505o(76505);
            return false;
        }
    }

    public final int bPq() {
        AppMethodBeat.m2504i(76506);
        bPl();
        AppMethodBeat.m2505o(76506);
        return 0;
    }

    public final void bPr() {
        AppMethodBeat.m2504i(76507);
        C4990ab.m7417i("MicroMsg.MMSightCamera", "openFlash, camera: %s, isPreviewing: %s", this.erH, Boolean.valueOf(this.otL));
        if (this.erH != null && this.otL) {
            try {
                this.otY = true;
                Parameters parameters = this.erH.getParameters();
                if (C5046bo.m7548ek(parameters.getSupportedFlashModes()) || !parameters.getSupportedFlashModes().contains("torch")) {
                    C4990ab.m7416i("MicroMsg.MMSightCamera", "camera not support flash!!");
                    AppMethodBeat.m2505o(76507);
                    return;
                }
                parameters.setFlashMode("torch");
                this.erH.setParameters(parameters);
                C4990ab.m7416i("MicroMsg.MMSightCamera", "open flash");
                AppMethodBeat.m2505o(76507);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.MMSightCamera", e, "openFlash error: %s", e.getMessage());
            }
        }
        AppMethodBeat.m2505o(76507);
    }

    public final void bPs() {
        AppMethodBeat.m2504i(76508);
        C4990ab.m7417i("MicroMsg.MMSightCamera", "closeFlash, camera: %s, isPreviewing: %s", this.erH, Boolean.valueOf(this.otL));
        if (this.erH != null && this.otL) {
            try {
                this.otY = false;
                Parameters parameters = this.erH.getParameters();
                if (C5046bo.m7548ek(parameters.getSupportedFlashModes()) || !parameters.getSupportedFlashModes().contains("off")) {
                    C4990ab.m7416i("MicroMsg.MMSightCamera", "camera not support close flash!!");
                    AppMethodBeat.m2505o(76508);
                    return;
                }
                parameters.setFlashMode("off");
                this.erH.setParameters(parameters);
                C4990ab.m7416i("MicroMsg.MMSightCamera", "close flash");
                AppMethodBeat.m2505o(76508);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.MMSightCamera", e, "closeFlash error: %s", e.getMessage());
            }
        }
        AppMethodBeat.m2505o(76508);
    }

    public final void bPt() {
        AppMethodBeat.m2504i(76509);
        C4990ab.m7417i("MicroMsg.MMSightCamera", "autoFlash, camera: %s, isPreviewing: %s", this.erH, Boolean.valueOf(this.otL));
        if (this.erH != null && this.otL) {
            try {
                this.otY = true;
                Parameters parameters = this.erH.getParameters();
                if (C5046bo.m7548ek(parameters.getSupportedFlashModes()) || !parameters.getSupportedFlashModes().contains("auto")) {
                    C4990ab.m7416i("MicroMsg.MMSightCamera", "camera not support auto flash!!");
                    AppMethodBeat.m2505o(76509);
                    return;
                }
                parameters.setFlashMode("auto");
                this.erH.setParameters(parameters);
                C4990ab.m7416i("MicroMsg.MMSightCamera", "auto flash");
                AppMethodBeat.m2505o(76509);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.MMSightCamera", e, "autoFlash error: %s", e.getMessage());
            }
        }
        AppMethodBeat.m2505o(76509);
    }

    public final int getPreviewWidth() {
        int i = 0;
        AppMethodBeat.m2504i(76510);
        if (this.erH == null) {
            AppMethodBeat.m2505o(76510);
        } else {
            if (this.fbb != null) {
                try {
                    i = (!this.otW || this.otV == null) ? this.fbc == null ? (this.fbb.rotate == 0 || this.fbb.rotate == 180) ? this.fav.lZe : this.fav.lZf : (this.fbb.rotate == 0 || this.fbb.rotate == 180) ? this.fbc.x : this.fbc.y : (this.fbb.rotate == 0 || this.fbb.rotate == 180) ? this.otT.x : this.otT.y;
                    AppMethodBeat.m2505o(76510);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.MMSightCamera", "getPreviewWidth: %s", e.getMessage());
                }
            }
            AppMethodBeat.m2505o(76510);
        }
        return i;
    }

    public final int getPreviewHeight() {
        int i = 0;
        AppMethodBeat.m2504i(76511);
        if (this.erH == null) {
            AppMethodBeat.m2505o(76511);
        } else {
            if (this.fbb != null) {
                try {
                    i = (!this.otW || this.otV == null) ? this.fbc == null ? (this.fbb.rotate == 0 || this.fbb.rotate == 180) ? this.fav.lZf : this.fav.lZe : (this.fbb.rotate == 0 || this.fbb.rotate == 180) ? this.fbc.y : this.fbc.x : (this.fbb.rotate == 0 || this.fbb.rotate == 180) ? this.otT.y : this.otT.x;
                    AppMethodBeat.m2505o(76511);
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.MMSightCamera", "getPreviewHeight: %s", e.getMessage());
                }
            }
            AppMethodBeat.m2505o(76511);
        }
        return i;
    }

    public final boolean bPu() {
        return this.otL;
    }

    public final boolean bPv() {
        return this.fas;
    }

    public final int getOrientation() {
        if (this.fbb == null || !this.otL) {
            return -1;
        }
        return this.fbb.rotate;
    }
}
