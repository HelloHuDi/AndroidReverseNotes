package com.tencent.mm.plugin.mmsight.model;

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
import android.support.v4.widget.j;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.e.t;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.mi;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.a.k;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.h;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class e implements SensorEventListener {
    protected static int otN = BaseClientBuilder.API_PRIORITY_OTHER;
    static boolean ouf = true;
    protected boolean aJI = false;
    protected SensorManager bCW;
    protected t erH = null;
    protected boolean faH = false;
    AutoFocusCallback faP = new AutoFocusCallback() {
        public final void onAutoFocus(boolean z, Camera camera) {
            AppMethodBeat.i(76469);
            ab.v("MicroMsg.MMSightCamera", "auto focus callback success %s, status: %s", Boolean.valueOf(z), e.this.oua);
            e.ouf = true;
            AppMethodBeat.o(76469);
        }
    };
    protected List<f> faZ = new ArrayList();
    protected boolean fas = true;
    protected p fav = p.bPJ();
    protected com.tencent.mm.compatible.e.d.a.a fbb;
    protected Point fbc = null;
    protected int fbd = -1;
    protected int fbe = -1;
    private b fbf = new b("prevcameraCallback");
    private b fbg = new b("cameraCallback");
    private b fbh = new b("cameraPreviewCallback");
    private b fbi = new b("cameraCropCallback");
    private b fbj = new b("finishCallbackTimeCallback");
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
    protected com.tencent.mm.plugin.base.model.a otX = new com.tencent.mm.plugin.base.model.a();
    protected boolean otY = false;
    protected boolean otZ = false;
    private a oua = a.Preview;
    private b oub = new b("mirrorCameraCallback");
    protected VideoTransPara ouc;
    public boolean oud = false;
    private boolean oue = false;
    public c oug = new c(Looper.getMainLooper());
    private int scene = 0;

    public class c extends ak {
        int faG = 0;
        boolean faH = false;
        boolean faI = false;
        boolean faJ = false;
        float faK;
        float faL;
        int faM;
        int faN;

        private static Rect b(float f, float f2, float f3, int i, int i2) {
            AppMethodBeat.i(76474);
            float f4 = 80.0f * f3;
            float f5 = (((f / ((float) i)) * 2000.0f) - 1000.0f) - (f4 / 2.0f);
            float f6 = (((f2 / ((float) i2)) * 2000.0f) - 1000.0f) - (f4 / 2.0f);
            float f7 = f5 + f4;
            f4 += f6;
            RectF rectF = new RectF();
            rectF.set(f5, f6, f7, f4);
            Rect rect = new Rect(yS(Math.round(rectF.left)), yS(Math.round(rectF.top)), yS(Math.round(rectF.right)), yS(Math.round(rectF.bottom)));
            AppMethodBeat.o(76474);
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

        /* Access modifiers changed, original: final */
        public final void e(t tVar) {
            AppMethodBeat.i(76475);
            if (tVar == null) {
                ab.w("MicroMsg.MMSightCamera", "want to auto focus, but camera is null, do nothing");
                AppMethodBeat.o(76475);
            } else if (e.ouf) {
                e.ouf = false;
                try {
                    ab.i("MicroMsg.MMSightCamera", "triggerAutoFocus");
                    tVar.cancelAutoFocus();
                    tVar.autoFocus(e.this.faP);
                    AppMethodBeat.o(76475);
                } catch (Exception e) {
                    ab.w("MicroMsg.MMSightCamera", "autofocus fail, exception %s", e.getMessage());
                    e.ouf = true;
                    AppMethodBeat.o(76475);
                }
            } else {
                ab.w("MicroMsg.MMSightCamera", "auto focus not back");
                AppMethodBeat.o(76475);
            }
        }

        public c(Looper looper) {
            super(looper);
        }

        private static int d(Parameters parameters) {
            AppMethodBeat.i(76476);
            if (parameters == null) {
                AppMethodBeat.o(76476);
                return 0;
            }
            int maxZoom;
            try {
                maxZoom = parameters.getMaxZoom() / 2;
                if (maxZoom <= 0) {
                    maxZoom = parameters.getMaxZoom();
                }
            } catch (Exception e) {
                ab.e("MicroMsg.MMSightCamera", "get target zoom value error: %s", e.getMessage());
                maxZoom = 0;
            }
            AppMethodBeat.o(76476);
            return maxZoom;
        }

        public final void handleMessage(Message message) {
            int i = 1;
            AppMethodBeat.i(76477);
            int zoom;
            switch (message.what) {
                case 4353:
                    if (!this.faJ) {
                        int d;
                        Camera camera = (Camera) message.obj;
                        Parameters parameters = camera.getParameters();
                        ab.i("MicroMsg.MMSightCamera", "zoomed %s curZoomStep %s params.getZoom() %s", Boolean.valueOf(this.faH), Integer.valueOf(this.faG), Integer.valueOf(parameters.getZoom()));
                        zoom = parameters.getZoom() + this.faG;
                        if (this.faH) {
                            d = d(parameters);
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
                    AppMethodBeat.o(76477);
                    return;
                    break;
                case 4354:
                    t tVar = (t) message.obj;
                    if (this.faM == 0 || this.faN == 0 || d.fP(14)) {
                        e(tVar);
                        AppMethodBeat.o(76477);
                        return;
                    }
                    float f = this.faK;
                    float f2 = this.faL;
                    zoom = this.faM;
                    int i2 = this.faN;
                    if (tVar == null) {
                        ab.w("MicroMsg.MMSightCamera", "want to auto focus, but camera is null, do nothing");
                        AppMethodBeat.o(76477);
                        return;
                    } else if (e.ouf) {
                        e.ouf = false;
                        try {
                            ArrayList arrayList;
                            tVar.cancelAutoFocus();
                            ab.i("MicroMsg.MMSightCamera", "ashutest:: touch %f %f, display %d %d", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(zoom), Integer.valueOf(i2));
                            ab.i("MicroMsg.MMSightCamera", "ashutest:: focus rect %s, meter rect %s", b(f, f2, 1.0f, zoom, i2), b(f, f2, 1.5f, zoom, i2));
                            Parameters parameters2 = tVar.getParameters();
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
                            tVar.setParameters(parameters2);
                            tVar.autoFocus(e.this.faP);
                            AppMethodBeat.o(76477);
                            return;
                        } catch (Exception e2) {
                            ab.w("MicroMsg.MMSightCamera", "autofocus with area fail, exception %s", e2.getMessage());
                            e.ouf = true;
                            AppMethodBeat.o(76477);
                            return;
                        }
                    } else {
                        ab.w("MicroMsg.MMSightCamera", "auto focus not back");
                        AppMethodBeat.o(76477);
                        return;
                    }
            }
            AppMethodBeat.o(76477);
        }
    }

    public interface b {
        void a(byte[] bArr, int i, int i2, int i3, int i4);
    }

    public enum a {
        Preview,
        Recording,
        Stoping;

        static {
            AppMethodBeat.o(76473);
        }
    }

    public e(VideoTransPara videoTransPara, int i) {
        AppMethodBeat.i(76478);
        this.ouc = videoTransPara;
        this.scene = i;
        AppMethodBeat.o(76478);
    }

    public final void a(f fVar) {
        AppMethodBeat.i(76479);
        if (fVar != null) {
            this.faZ.add(fVar);
        }
        AppMethodBeat.o(76479);
    }

    public final void b(f fVar) {
        AppMethodBeat.i(76480);
        if (fVar != null) {
            this.faZ.remove(fVar);
        }
        AppMethodBeat.o(76480);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(76481);
        this.oua = aVar;
        if (aVar == a.Stoping) {
            int i;
            a bPi = a.bPi();
            String bPk = this.fbg.bPk();
            String bPk2 = this.fbf.bPk();
            com.tencent.mm.plugin.base.model.a aVar2 = this.otX;
            if (aVar2.jDj == 0) {
                i = 0;
            } else {
                i = aVar2.jDi / aVar2.jDj;
            }
            bPi.ott = (int) (bo.anm(bPk) * 10.0d);
            bPi.otu = (int) (bo.anm(bPk2) * 10.0d);
            bPi.otz = i;
        }
        AppMethodBeat.o(76481);
    }

    private void bPl() {
        AppMethodBeat.i(76482);
        try {
            if (!(this.bCW == null || this.otO == null)) {
                this.bCW.unregisterListener(this);
            }
            ab.i("MicroMsg.MMSightCamera", this.fbf.getValue());
            ab.i("MicroMsg.MMSightCamera", this.fbg.getValue());
            ab.i("MicroMsg.MMSightCamera", this.fbh.getValue());
            ab.i("MicroMsg.MMSightCamera", this.fbi.getValue());
            ab.i("MicroMsg.MMSightCamera", this.oub.getValue());
            ab.i("MicroMsg.MMSightCamera", this.fbj.getValue());
            if (this.erH != null) {
                long yz = bo.yz();
                ab.i("MicroMsg.MMSightCamera", "release camera beg, %s", Looper.myLooper());
                this.oug.removeCallbacksAndMessages(null);
                this.oug.faJ = true;
                this.erH.setPreviewCallback(null);
                this.erH.stopPreview();
                this.erH.release();
                this.erH = null;
                this.otL = false;
                ab.i("MicroMsg.MMSightCamera", "release camera end, use %dms, %s", Long.valueOf(bo.az(yz)), Looper.myLooper());
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
            AppMethodBeat.o(76482);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MMSightCamera", e, "cameraRelease error", new Object[0]);
            AppMethodBeat.o(76482);
        }
    }

    private boolean b(t tVar, boolean z) {
        AppMethodBeat.i(76483);
        if (tVar == null) {
            AppMethodBeat.o(76483);
            return false;
        }
        try {
            a bPi;
            boolean z2;
            Point point;
            Parameters parameters = tVar.getParameters();
            Point eu = com.tencent.mm.plugin.mmsight.d.eu(this.mContext);
            List supportedPreviewSizes;
            List supportedPictureSizes;
            int i;
            if (this.fas) {
                bPi = a.bPi();
                supportedPreviewSizes = parameters.getSupportedPreviewSizes();
                supportedPictureSizes = parameters.getSupportedPictureSizes();
                i = this.fbb.rotate;
                if (bo.isNullOrNil(bPi.otj)) {
                    bPi.otj = com.tencent.mm.plugin.mmsight.d.cp(supportedPreviewSizes);
                }
                if (bo.isNullOrNil(bPi.otk)) {
                    bPi.otk = com.tencent.mm.plugin.mmsight.d.cp(supportedPictureSizes);
                }
                bPi.rotate = i;
                bPi.otE = 1;
            } else {
                bPi = a.bPi();
                supportedPreviewSizes = parameters.getSupportedPreviewSizes();
                supportedPictureSizes = parameters.getSupportedPictureSizes();
                i = this.fbb.rotate;
                if (bo.isNullOrNil(bPi.otl)) {
                    bPi.otl = com.tencent.mm.plugin.mmsight.d.cp(supportedPreviewSizes);
                }
                if (bo.isNullOrNil(bPi.otm)) {
                    bPi.otm = com.tencent.mm.plugin.mmsight.d.cp(supportedPictureSizes);
                }
                bPi.rotate = i;
                bPi.otE = 2;
            }
            if (z) {
                z2 = this.fbb.rotate == 90 || this.fbb.rotate == 270;
                j.a(parameters, z2);
            }
            k.bPR();
            int bPU = k.bPU();
            if (this.fbb.rotate == 90 || this.fbb.rotate == 270) {
                z2 = true;
            } else {
                z2 = false;
            }
            com.tencent.mm.plugin.mmsight.model.g.b a = g.a(parameters, eu, bPU, z2);
            if (a == null || a.oum == null) {
                ab.e("MicroMsg.MMSightCamera", "fuck, preview size still null!!");
                point = new Point(Math.min(eu.x, eu.y), Math.max(eu.x, eu.y));
                z2 = this.fbb.rotate == 90 || this.fbb.rotate == 270;
                a = g.c(parameters, point, 2100, z2);
                this.oud = false;
            }
            com.tencent.mm.plugin.mmsight.model.g.b bVar = a;
            j.a(bVar);
            Point point2 = bVar.oum;
            if (point2 == null) {
                k.bPD();
                AppMethodBeat.o(76483);
                return false;
            }
            boolean z3;
            int i2;
            this.fav.lZe = point2.x;
            this.fav.lZf = point2.y;
            this.otT = point2;
            Context context = this.mContext;
            z2 = this.fbb.rotate == 90 || this.fbb.rotate == 270;
            z2 = com.tencent.mm.plugin.mmsight.d.a(context, point2, z2);
            Object obj = 1;
            if (this.fbb.rotate == 90 || this.fbb.rotate == 270) {
                if (point2.y < this.ouc.width || point2.x < this.ouc.height) {
                    obj = null;
                    ab.w("MicroMsg.MMSightCamera", "previewSize %s not support real scale", point2);
                }
            } else if (point2.x < this.ouc.width || point2.y < this.ouc.height) {
                obj = null;
                ab.w("MicroMsg.MMSightCamera", "previewSize %s not support real scale", point2);
            }
            ab.i("MicroMsg.MMSightCameraSetting", "checkIfNeedUsePreviewLarge, needCrop: %s", Boolean.valueOf(z2));
            if (z2) {
                if (j.ouz.etz == 2) {
                    this.fbc = bVar.ouo;
                    if (this.fbc.x < point2.x || this.fbc.y < point2.y) {
                        if (this.fbb.rotate == 90 || this.fbb.rotate == 270) {
                            this.fbc.y = com.tencent.mm.plugin.mmsight.d.yQ(this.fbc.y);
                        } else {
                            this.fbc.x = com.tencent.mm.plugin.mmsight.d.yQ(this.fbc.x);
                        }
                    }
                } else {
                    this.fbc = bVar.oun;
                }
                this.otT = new Point(this.fbc.x, this.fbc.y);
                this.otU = ((this.fbc.x * this.fbc.y) * 3) / 2;
                ab.i("MicroMsg.MMSightCameraSetting", "cropSize: %s", this.fbc);
                z3 = z2;
            } else {
                if (j.ouz.ouM && j.ouz.fay == FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN && obj != null) {
                    int yP;
                    int i3;
                    int yP2;
                    if (this.fbb.rotate == 90 || this.fbb.rotate == 270) {
                        bPU = point2.y / 2;
                        yP = com.tencent.mm.plugin.mmsight.d.yP(bPU);
                        i3 = point2.x / 2;
                        yP2 = com.tencent.mm.plugin.mmsight.d.yP(i3);
                        if (Math.abs(yP - bPU) >= 8 || Math.abs(yP2 - i3) >= 8) {
                            this.fbc = new Point(point2.x, point2.y);
                            this.fbc.y = com.tencent.mm.plugin.mmsight.d.yQ(point2.y);
                            this.fbc.x = com.tencent.mm.plugin.mmsight.d.yQ(point2.x);
                            this.otT = new Point(this.fbc.x, this.fbc.y);
                            this.otU = ((this.fbc.x * this.fbc.y) * 3) / 2;
                            z2 = true;
                        }
                        z3 = z2;
                    } else {
                        bPU = point2.x / 2;
                        yP = com.tencent.mm.plugin.mmsight.d.yP(bPU);
                        i3 = point2.y / 2;
                        yP2 = com.tencent.mm.plugin.mmsight.d.yP(i3);
                        if (Math.abs(yP - bPU) >= 8 || Math.abs(yP2 - i3) >= 8) {
                            this.fbc = new Point(point2.x, point2.y);
                            this.fbc.y = com.tencent.mm.plugin.mmsight.d.yQ(point2.x);
                            this.fbc.x = com.tencent.mm.plugin.mmsight.d.yQ(point2.y);
                            this.otT = new Point(this.fbc.x, this.fbc.y);
                            this.otU = ((this.fbc.x * this.fbc.y) * 3) / 2;
                            z3 = true;
                        }
                    }
                }
                z3 = z2;
            }
            if (j.ouz.ouM) {
                if (this.fbb.rotate == 90 || this.fbb.rotate == 270) {
                    if (obj != null) {
                        if (j.ouz.fay == FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN) {
                            this.otT = new Point(com.tencent.mm.plugin.mmsight.d.ev(this.fbc == null ? point2.x / 2 : this.fbc.x / 2, this.fbc == null ? point2.x : this.fbc.x), com.tencent.mm.plugin.mmsight.d.ev(this.fbc == null ? point2.y / 2 : this.fbc.y / 2, this.fbc == null ? point2.y : this.fbc.y));
                        } else if (j.ouz.fay == 720) {
                            this.otT = new Point(com.tencent.mm.plugin.mmsight.d.ev((int) (this.fbc == null ? ((float) point2.x) * 0.75f : ((float) this.fbc.x) * 0.75f), this.fbc == null ? point2.x : this.fbc.x), com.tencent.mm.plugin.mmsight.d.ev((int) (this.fbc == null ? ((float) point2.y) * 0.75f : ((float) this.fbc.y) * 0.75f), this.fbc == null ? point2.y : this.fbc.y));
                        }
                    }
                } else if (obj != null) {
                    if (j.ouz.fay == FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN) {
                        this.otT = new Point(com.tencent.mm.plugin.mmsight.d.ev(this.fbc == null ? point2.y / 2 : this.fbc.y / 2, this.fbc == null ? point2.y : this.fbc.y), com.tencent.mm.plugin.mmsight.d.ev(this.fbc == null ? point2.x / 2 : this.fbc.x / 2, this.fbc == null ? point2.x : this.fbc.x));
                    } else if (j.ouz.fay == 720) {
                        bPU = (int) (this.fbc == null ? ((float) point2.x) * 0.75f : ((float) this.fbc.x) * 0.75f);
                        int ev = com.tencent.mm.plugin.mmsight.d.ev((int) (this.fbc == null ? ((float) point2.y) * 0.75f : ((float) this.fbc.y) * 0.75f), this.fbc == null ? point2.y : this.fbc.y);
                        if (this.fbc == null) {
                            i2 = point2.x;
                        } else {
                            i2 = this.fbc.x;
                        }
                        this.otT = new Point(ev, com.tencent.mm.plugin.mmsight.d.ev(bPU, i2));
                    }
                }
            }
            bPi = a.bPi();
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
                if (z3 || j.ouz.etz != 2 || com.tencent.mm.plugin.mmsight.d.yO(this.otT.y)) {
                    j.d(this.otT);
                } else {
                    i2 = com.tencent.mm.plugin.mmsight.d.yP(this.otT.y);
                    if (Math.abs(i2 - this.otT.y) <= 16) {
                        ab.i("MicroMsg.MMSightCamera", "padding 16 for encode video best size: %s, alignY: %s", this.otT, Integer.valueOf(i2));
                        this.otS = new Point(this.otT.x, this.otT.y);
                        this.otT.y = i2;
                        this.otW = true;
                        this.otV = new byte[(((this.otT.x * this.otT.y) * 3) / 2)];
                    } else {
                        j.d(this.otT);
                    }
                }
            } else if (!z3 && j.ouz.etz == 2 && !com.tencent.mm.plugin.mmsight.d.yO(this.otT.y) && this.otW && this.otV != null && this.otS.y == this.otT.y) {
                i2 = com.tencent.mm.plugin.mmsight.d.yP(this.otT.y);
                if (this.otV.length == ((this.otT.x * i2) * 3) / 2) {
                    this.otT.y = i2;
                }
            }
            ab.i("MicroMsg.MMSightCameraSetting", "final set camera preview size: %s, encodeVideoBestSize: %s, cropSize: %s", point2, this.otT, this.fbc);
            parameters.setPreviewSize(this.fav.lZe, this.fav.lZf);
            tVar.setParameters(parameters);
            AppMethodBeat.o(76483);
            return true;
        } catch (Exception e) {
            ab.i("MicroMsg.MMSightCameraSetting", "setPreviewSize Exception, %s, %s", Looper.myLooper(), e.getMessage());
            AppMethodBeat.o(76483);
            return false;
        }
    }

    private boolean a(t tVar, int i, float f, boolean z) {
        AppMethodBeat.i(76484);
        if (tVar == null || i <= 0) {
            AppMethodBeat.o(76484);
            return false;
        }
        try {
            int i2;
            boolean z2;
            Parameters parameters = tVar.getParameters();
            Point point = new Point(i, (int) (((float) i) / f));
            point = ae.hy(ah.getContext());
            Point point2 = new Point(Math.min(point.x, point.y), Math.max(point.x, point.y));
            ab.i("MicroMsg.MMSightCamera", "screenSize: %s, currentScreenSize: %s", point2, point);
            float min = ((float) Math.min(point2.x, point2.y)) / ((float) Math.max(point2.x, point2.y));
            float f2 = 1.0f / f;
            if (f < 1.0f) {
                i2 = i;
            } else {
                i2 = Math.round(((float) i) / f2);
            }
            ab.i("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimitAndRatio, shortSize: %s, displayRatio: %s, screenRatio: %s", Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(min));
            if (this.fbb.rotate == 90 || this.fbb.rotate == 270) {
                z2 = true;
            } else {
                z2 = false;
            }
            com.tencent.mm.plugin.mmsight.model.g.b a = g.a(parameters, point2, i2, z2);
            if (a == null || a.oum == null) {
                ab.e("MicroMsg.MMSightCamera", "fuck, preview size still null!!");
                z2 = this.fbb.rotate == 90 || this.fbb.rotate == 270;
                a = g.c(parameters, point2, i, z2);
                this.oud = false;
            }
            if (!(a == null || a.oum == null)) {
                ab.i("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimitAndRatio result preview size: %s, cropHeight: %s", a.oum, Integer.valueOf((int) (((float) a.oum.x) * f)));
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
                    if (j.ouz.etz != 2 || com.tencent.mm.plugin.mmsight.d.yO(this.otT.y)) {
                        j.d(this.otT);
                    } else {
                        i2 = com.tencent.mm.plugin.mmsight.d.yP(this.otT.y);
                        if (Math.abs(i2 - this.otT.y) <= 16) {
                            ab.i("MicroMsg.MMSightCamera", "padding 16 for encode video best size: %s, alignY: %s", this.otT, Integer.valueOf(i2));
                            this.otS = new Point(this.otT.x, this.otT.y);
                            this.otT.y = i2;
                            this.otW = true;
                            this.otV = new byte[(((this.otT.x * this.otT.y) * 3) / 2)];
                        } else {
                            j.d(this.otT);
                        }
                    }
                }
                ab.i("MicroMsg.MMSightCameraSetting", "final set camera preview size: %s, encodeVideoBestSize: %s, cropSize: %s, cropWidth: %s", point, this.otT, this.fbc, Boolean.valueOf(this.oud));
                parameters.setPreviewSize(this.fav.lZe, this.fav.lZf);
                tVar.setParameters(parameters);
                AppMethodBeat.o(76484);
                return true;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.MMSightCamera", "safeSetPreviewSizeWithLimit error: %s", e.getMessage());
        }
        AppMethodBeat.o(76484);
        return false;
    }

    public final Point getEncodeVideoBestSize() {
        return this.otT;
    }

    @TargetApi(14)
    private static boolean c(t tVar) {
        AppMethodBeat.i(76485);
        if (tVar == null) {
            AppMethodBeat.o(76485);
            return false;
        }
        try {
            ab.i("MicroMsg.MMSightCameraSetting", "safeSetMetering");
            Parameters parameters = tVar.getParameters();
            if (parameters.getMaxNumMeteringAreas() > 0) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new Area(new Rect(-1000, -1000, 1000, 1000), 600));
                parameters.setMeteringAreas(arrayList);
            }
            tVar.setParameters(parameters);
            AppMethodBeat.o(76485);
            return true;
        } catch (Exception e) {
            ab.i("MicroMsg.MMSightCameraSetting", "safeSetMetering Exception, %s, %s", Looper.myLooper(), e.getMessage());
            AppMethodBeat.o(76485);
            return false;
        }
    }

    private static boolean a(t tVar, boolean z) {
        AppMethodBeat.i(76486);
        if (tVar == null) {
            AppMethodBeat.o(76486);
            return false;
        }
        try {
            List supportedPreviewFrameRates;
            Parameters parameters = tVar.getParameters();
            int i;
            if (z) {
                if (q.etc.eri > 0) {
                    ab.i("MicroMsg.MMSightCameraSetting", "set frame rate > 0, do not try set preview frame rate");
                } else if (parameters == null) {
                    ab.e("MicroMsg.MMSightCamera", "trySetPreviewFrameRateParameters error, p is null!");
                } else {
                    try {
                        supportedPreviewFrameRates = parameters.getSupportedPreviewFrameRates();
                        if (supportedPreviewFrameRates != null && supportedPreviewFrameRates.size() > 0) {
                            parameters.setPreviewFrameRate(Math.min(30, ((Integer) Collections.max(supportedPreviewFrameRates)).intValue()));
                            ab.i("MicroMsg.MMSightCameraSetting", "set preview frame rate %d", Integer.valueOf(i));
                        }
                    } catch (Exception e) {
                        ab.i("MicroMsg.MMSightCameraSetting", "trySetPreviewFrameRateParameters Exception, %s, %s", Looper.myLooper(), e.getMessage());
                    }
                }
            } else if (q.etc.eri > 0) {
                ab.i("MicroMsg.MMSightCameraSetting", "set frame rate > 0, do not try set preview fps range");
            } else {
                List supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
                if (!(supportedPreviewFpsRange == null || supportedPreviewFpsRange.size() == 0)) {
                    int i2 = j.INVALID_ID;
                    int i3 = j.INVALID_ID;
                    Object obj = null;
                    int size = supportedPreviewFpsRange.size();
                    int i4 = 0;
                    while (i4 < size) {
                        Object obj2;
                        int[] iArr = (int[]) supportedPreviewFpsRange.get(i4);
                        if (iArr != null && iArr.length > 1) {
                            int i5 = iArr[0];
                            i = iArr[1];
                            ab.i("MicroMsg.MMSightCamera", "dkfps %d:[%d %d]", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i));
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
                    ab.i("MicroMsg.MMSightCameraSetting", "dkfps get fit  [%d %d], max target fps %d", Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(30));
                    if (!(i2 == BaseClientBuilder.API_PRIORITY_OTHER || i3 == BaseClientBuilder.API_PRIORITY_OTHER)) {
                        try {
                            parameters.setPreviewFpsRange(i2, i3);
                            ab.i("MicroMsg.MMSightCameraSetting", "set fps range %d %d", Integer.valueOf(i2), Integer.valueOf(i3));
                        } catch (Exception e2) {
                            ab.i("MicroMsg.MMSightCameraSetting", "trySetPreviewFpsRangeParameters Exception, %s, %s", Looper.myLooper(), e2.getMessage());
                        }
                    }
                }
            }
            supportedPreviewFrameRates = parameters.getSupportedPreviewFrameRates();
            ab.i("MicroMsg.MMSightCameraSetting", "use fix mode %B, supported preview frame rates %s", Boolean.valueOf(z), supportedPreviewFrameRates);
            tVar.setParameters(parameters);
            AppMethodBeat.o(76486);
            return true;
        } catch (Exception e22) {
            ab.i("MicroMsg.MMSightCameraSetting", "setPreviewFrameRate Exception, %s, %s", Looper.myLooper(), e22.getMessage());
            AppMethodBeat.o(76486);
            return false;
        }
    }

    private static boolean b(t tVar) {
        AppMethodBeat.i(76487);
        if (tVar == null) {
            AppMethodBeat.o(76487);
            return false;
        }
        try {
            ab.i("MicroMsg.MMSightCameraSetting", "safeSetPreviewFormat");
            Parameters parameters = tVar.getParameters();
            List supportedPreviewFormats = parameters.getSupportedPreviewFormats();
            if (supportedPreviewFormats == null || !supportedPreviewFormats.contains(Integer.valueOf(17))) {
                ab.e("MicroMsg.MMSightCameraSetting", "not support YCbCr_420_SP");
            }
            parameters.setPreviewFormat(17);
            tVar.setParameters(parameters);
            AppMethodBeat.o(76487);
            return true;
        } catch (Exception e) {
            ab.i("MicroMsg.MMSightCameraSetting", "setPreviewFormat Exception, %s, %s", Looper.myLooper(), e.getMessage());
            AppMethodBeat.o(76487);
            return false;
        }
    }

    private static boolean a(t tVar) {
        AppMethodBeat.i(76488);
        if (tVar == null) {
            AppMethodBeat.o(76488);
            return false;
        }
        try {
            Parameters parameters = tVar.getParameters();
            List supportedFocusModes = parameters.getSupportedFocusModes();
            if (supportedFocusModes == null || !supportedFocusModes.contains("continuous-picture")) {
                if (supportedFocusModes != null) {
                    if (supportedFocusModes.contains("continuous-video")) {
                        ab.i("MicroMsg.MMSightCameraSetting", "support continuous video");
                        parameters.setFocusMode("continuous-video");
                    }
                }
                if (supportedFocusModes != null) {
                    if (supportedFocusModes.contains("auto")) {
                        ab.i("MicroMsg.MMSightCameraSetting", "support auto focus");
                        parameters.setFocusMode("auto");
                    }
                }
                ab.i("MicroMsg.MMSightCameraSetting", "not support continuous video or auto focus");
            } else {
                ab.i("MicroMsg.MMSightCameraSetting", "support continuous picture");
                parameters.setFocusMode("continuous-picture");
            }
            tVar.setParameters(parameters);
            AppMethodBeat.o(76488);
            return true;
        } catch (Exception e) {
            ab.i("MicroMsg.MMSightCameraSetting", "setFocusMode Exception, %s, %s", Looper.myLooper(), e.getMessage());
            AppMethodBeat.o(76488);
            return false;
        }
    }

    public final void bPm() {
        AppMethodBeat.i(76489);
        ab.i("MicroMsg.MMSightCamera", "switchToVideoFocusMode");
        if (this.erH != null && this.otL) {
            try {
                Parameters parameters = this.erH.getParameters();
                List supportedFocusModes = parameters.getSupportedFocusModes();
                if (supportedFocusModes != null && supportedFocusModes.contains("continuous-video")) {
                    ab.i("MicroMsg.MMSightCameraSetting", "support continuous video");
                    parameters.setFocusMode("continuous-video");
                }
                this.erH.setParameters(parameters);
                AppMethodBeat.o(76489);
                return;
            } catch (Exception e) {
                ab.i("MicroMsg.MMSightCamera", "switchToVideoFocusMode error: %s", e.getMessage());
            }
        }
        AppMethodBeat.o(76489);
    }

    public final void bPn() {
        AppMethodBeat.i(76490);
        ab.i("MicroMsg.MMSightCamera", "switchToPictureFocusMode");
        if (this.erH != null && this.otL) {
            try {
                Parameters parameters = this.erH.getParameters();
                List supportedFocusModes = parameters.getSupportedFocusModes();
                if (supportedFocusModes != null && supportedFocusModes.contains("continuous-picture")) {
                    ab.i("MicroMsg.MMSightCameraSetting", "support continuous picture");
                    parameters.setFocusMode("continuous-picture");
                }
                this.erH.setParameters(parameters);
                AppMethodBeat.o(76490);
                return;
            } catch (Exception e) {
                ab.i("MicroMsg.MMSightCamera", "switchToPictureFocusMode error: %s", e.getMessage());
            }
        }
        AppMethodBeat.o(76490);
    }

    private void Ws() {
        AppMethodBeat.i(76491);
        if (this.erH != null) {
            try {
                Parameters parameters = this.erH.getParameters();
                ab.i("MicroMsg.MMSightCamera", "setPreviewCallbackImpl");
                int bitsPerPixel = (ImageFormat.getBitsPerPixel(parameters.getPreviewFormat()) * (this.fav.lZe * this.fav.lZf)) / 8;
                for (int i = 0; i < 5; i++) {
                    this.erH.addCallbackBuffer(com.tencent.mm.plugin.mmsight.model.a.j.owk.g(Integer.valueOf(bitsPerPixel)));
                }
                this.fbf.reset();
                this.fbg.reset();
                this.fbh.reset();
                this.fbi.reset();
                this.oub.reset();
                this.fbj.reset();
                this.otX = new com.tencent.mm.plugin.base.model.a();
                this.erH.setPreviewCallbackWithBuffer(new PreviewCallback() {
                    public final void onPreviewFrame(byte[] bArr, Camera camera) {
                        AppMethodBeat.i(76468);
                        if (!e.this.otZ) {
                            ab.i("MicroMsg.MMSightCamera", "onPreviewFrame: %s %s", bArr, e.this.erH);
                            e.this.otZ = true;
                        }
                        if (bArr == null || bArr.length <= 0) {
                            ab.e("MicroMsg.MMSightCamera", "onPreviewFrame, frame data is null!!");
                            AppMethodBeat.o(76468);
                            return;
                        }
                        int i;
                        byte[] bArr2;
                        byte[] bArr3;
                        com.tencent.mm.plugin.base.model.a aVar = e.this.otX;
                        if (aVar.jDk == 0) {
                            aVar.jDj++;
                            aVar.jDi = bo.ank(m.Lz());
                        }
                        aVar.jDk++;
                        if (aVar.jDk >= 90) {
                            i = 0;
                        } else {
                            i = aVar.jDk;
                        }
                        aVar.jDk = i;
                        long yz;
                        int i2;
                        boolean z;
                        if (e.this.fbk || e.this.faZ == null || e.this.faZ.size() <= 0) {
                            bArr2 = bArr;
                            bArr3 = bArr;
                        } else if (e.this.fbc != null) {
                            bArr2 = com.tencent.mm.plugin.mmsight.model.a.j.owk.g(Integer.valueOf(((e.this.fav.lZe * e.this.fbc.y) * 3) / 2));
                            e.this.fbh.jl(1);
                            yz = bo.yz();
                            SightVideoJNI.cropCameraData(bArr, bArr2, e.this.fav.lZe, e.this.fav.lZf, e.this.fbc.y);
                            if (e.this.fbc.x < e.this.fav.lZe) {
                                bArr3 = com.tencent.mm.plugin.mmsight.model.a.j.owk.g(Integer.valueOf(((e.this.fbc.x * e.this.fbc.y) * 3) / 2));
                                SightVideoJNI.cropCameraDataLongEdge(bArr2, bArr3, e.this.fav.lZe, e.this.fbc.x, e.this.fbc.y);
                                com.tencent.mm.plugin.mmsight.model.a.j.owk.g(bArr2);
                            } else {
                                bArr3 = bArr2;
                            }
                            e.this.fbi.jl(bo.az(yz));
                            if (!e.this.fas) {
                                yz = bo.yz();
                                i2 = e.this.fbc.x;
                                int i3 = e.this.fbc.y;
                                z = e.this.fbb.rotate == 270 || e.this.fbb.rotate == 90;
                                SightVideoJNI.mirrorCameraData(bArr3, i2, i3, z);
                                e.this.oub.jl(bo.az(yz));
                            }
                            z = e.a(e.this, bArr3);
                            yz = bo.az(yz);
                            if (z) {
                                e.this.fbj.jl(yz);
                            }
                            bArr2 = bArr;
                        } else {
                            yz = bo.yz();
                            if (!e.this.fas) {
                                int i4 = e.this.fav.lZe;
                                i2 = e.this.fav.lZf;
                                boolean z2 = e.this.fbb.rotate == 270 || e.this.fbb.rotate == 90;
                                SightVideoJNI.mirrorCameraData(bArr, i4, i2, z2);
                                e.this.oub.jl(bo.az(yz));
                            }
                            if (!e.this.otW || e.this.otV == null) {
                                bArr3 = bArr;
                            } else {
                                SightVideoJNI.paddingYuvData16(bArr, e.this.otV, e.this.otT.x, e.this.otS.y, e.this.otT.y);
                                bArr3 = e.this.otV;
                            }
                            z = e.a(e.this, bArr3);
                            yz = bo.az(yz);
                            if (z) {
                                e.this.fbj.jl(yz);
                            }
                            if ((!e.this.otW || e.this.otV == null) && z) {
                                bArr = com.tencent.mm.plugin.mmsight.model.a.j.owk.g(Integer.valueOf(bArr.length));
                            }
                            if (e.this.otW && e.this.otV != null) {
                                e eVar = e.this;
                                if (z) {
                                    bArr2 = com.tencent.mm.plugin.mmsight.model.a.j.owk.g(Integer.valueOf(e.this.otV.length));
                                } else {
                                    bArr2 = e.this.otV;
                                }
                                eVar.otV = bArr2;
                            }
                            bArr2 = bArr;
                        }
                        e.this.fbl = bArr3;
                        if (e.this.oua == a.Preview) {
                            e.this.fbg.jl(1);
                        } else if (e.this.oua == a.Recording) {
                            e.this.fbf.jl(1);
                        }
                        e.this.erH.addCallbackBuffer(bArr2);
                        AppMethodBeat.o(76468);
                    }
                });
                AppMethodBeat.o(76491);
                return;
            } catch (Exception e) {
                ab.e("MicroMsg.MMSightCamera", "setPreviewCallbackImpl error: %s", e.getMessage());
            }
        }
        AppMethodBeat.o(76491);
    }

    @TargetApi(11)
    public final int a(SurfaceTexture surfaceTexture, boolean z) {
        AppMethodBeat.i(76492);
        long yz = bo.yz();
        this.otZ = false;
        ab.i("MicroMsg.MMSightCamera", "start preview, previewing %B, %s %s autoConfig %s", Boolean.valueOf(this.otL), Looper.myLooper(), surfaceTexture, Boolean.valueOf(z));
        int line;
        if (this.otL) {
            AppMethodBeat.o(76492);
            return 0;
        } else if (surfaceTexture == null) {
            line = 0 - g.getLine();
            AppMethodBeat.o(76492);
            return line;
        } else {
            ab.i("MicroMsg.MMSightCamera", "this texture %s", surfaceTexture);
            try {
                Integer valueOf;
                boolean z2;
                b(this.erH, z);
                Integer valueOf2 = Integer.valueOf(0);
                if (k.bPR().owm != null) {
                    valueOf = Integer.valueOf(k.bPR().owm.osS);
                } else {
                    valueOf = valueOf2;
                }
                String str = "MicroMsg.MMSightCamera";
                String str2 = "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]";
                Object[] objArr = new Object[6];
                objArr[0] = valueOf;
                String str3 = q.etc.ern == 1 ? "Range" : q.etc.erm == 1 ? "Fix" : "Error";
                objArr[1] = str3;
                objArr[2] = Boolean.valueOf(q.etc.ero == 1);
                if (q.etc.erp == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr[3] = Boolean.valueOf(z2);
                if (q.etc.erq == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr[4] = Boolean.valueOf(z2);
                if (q.etc.err == 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objArr[5] = Boolean.valueOf(z2);
                ab.i(str, str2, objArr);
                if (q.etc.ern == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 1)) {
                    a(this.erH, false);
                } else if (q.etc.erm == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 5)) {
                    a(this.erH, true);
                }
                if (q.etc.ero == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 2)) {
                    b(this.erH);
                }
                if (q.etj.etH != -1 && q.etj.etH == 1 && d.iX(14)) {
                    c(this.erH);
                }
                if (q.etc.erq == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 4)) {
                    a(this.erH);
                }
                if (q.etc.err == 1 && valueOf.intValue() != 0) {
                    valueOf.intValue();
                }
                d(this.erH);
                Ws();
                this.erH.setPreviewTexture(surfaceTexture);
                this.erH.startPreview();
                if (!j.ouz.ouN) {
                    this.bCW.registerListener(this, this.otO, 2);
                } else if (!(q.etc.erq != 0 || this.bCW == null || this.otO == null)) {
                    this.bCW.registerListener(this, this.otO, 2);
                }
                this.otL = true;
                ab.i("MicroMsg.MMSightCamera", "start preview end, use %dms %s", Long.valueOf(bo.az(yz)), Looper.myLooper());
                AppMethodBeat.o(76492);
                return 0;
            } catch (Exception e) {
                ab.e("MicroMsg.MMSightCamera", "start preview FAILED, %s, %s", Looper.myLooper(), e.getMessage());
                line = 0 - g.getLine();
                AppMethodBeat.o(76492);
                return line;
            }
        }
    }

    public final int a(SurfaceTexture surfaceTexture, int i, float f, boolean z) {
        AppMethodBeat.i(76493);
        long yz = bo.yz();
        this.otZ = false;
        ab.i("MicroMsg.MMSightCamera", "start preview, previewing %B, %s %s", Boolean.valueOf(this.otL), Looper.myLooper(), surfaceTexture);
        int line;
        if (this.otL) {
            AppMethodBeat.o(76493);
            return 0;
        } else if (surfaceTexture == null) {
            line = 0 - g.getLine();
            AppMethodBeat.o(76493);
            return line;
        } else {
            ab.i("MicroMsg.MMSightCamera", "this texture %s", surfaceTexture);
            try {
                Integer valueOf;
                a(this.erH, i, f, z);
                Integer valueOf2 = Integer.valueOf(0);
                if (k.bPR().owm != null) {
                    valueOf = Integer.valueOf(k.bPR().owm.osS);
                } else {
                    valueOf = valueOf2;
                }
                String str = "MicroMsg.MMSightCamera";
                String str2 = "startPreview Texture:: sightTest %s, config list: setFPS[%s], setYUV420SP[%B], useMetering[%B], useContinueFocus[%B] mUseContinueVideoFocusMode[%B]";
                Object[] objArr = new Object[6];
                objArr[0] = valueOf;
                String str3 = q.etc.ern == 1 ? "Range" : q.etc.erm == 1 ? "Fix" : "Error";
                objArr[1] = str3;
                objArr[2] = Boolean.valueOf(q.etc.ero == 1);
                objArr[3] = Boolean.valueOf(q.etc.erp == 1);
                objArr[4] = Boolean.valueOf(q.etc.erq == 1);
                objArr[5] = Boolean.valueOf(q.etc.err == 1);
                ab.i(str, str2, objArr);
                if (q.etc.ern == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 1)) {
                    a(this.erH, false);
                } else if (q.etc.erm == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 5)) {
                    a(this.erH, true);
                }
                if (q.etc.ero == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 2)) {
                    b(this.erH);
                }
                if (q.etj.etH != -1 && q.etj.etH == 1 && d.iX(14)) {
                    c(this.erH);
                }
                if (q.etc.erq == 1 && (valueOf.intValue() == 0 || valueOf.intValue() == 4)) {
                    a(this.erH);
                }
                if (q.etc.err == 1 && valueOf.intValue() != 0) {
                    valueOf.intValue();
                }
                d(this.erH);
                Ws();
                this.erH.setPreviewTexture(surfaceTexture);
                this.erH.startPreview();
                if (!j.ouz.ouN) {
                    this.bCW.registerListener(this, this.otO, 2);
                } else if (!(q.etc.erq != 0 || this.bCW == null || this.otO == null)) {
                    this.bCW.registerListener(this, this.otO, 2);
                }
                this.otL = true;
                ab.i("MicroMsg.MMSightCamera", "start preview end, use %dms %s", Long.valueOf(bo.az(yz)), Looper.myLooper());
                AppMethodBeat.o(76493);
                return 0;
            } catch (Exception e) {
                ab.e("MicroMsg.MMSightCamera", "start preview FAILED, %s, %s", Looper.myLooper(), e.getMessage());
                line = 0 - g.getLine();
                AppMethodBeat.o(76493);
                return line;
            }
        }
    }

    private static void d(t tVar) {
        AppMethodBeat.i(76494);
        try {
            Parameters parameters = tVar.getParameters();
            if (parameters.isZoomSupported()) {
                parameters.setZoom(0);
            }
            tVar.setParameters(parameters);
            AppMethodBeat.o(76494);
        } catch (Exception e) {
            ab.e("MicroMsg.MMSightCamera", "safeResetZoom error: %s", e.getMessage());
            AppMethodBeat.o(76494);
        }
    }

    private void Wf() {
        AppMethodBeat.i(76495);
        if (true == this.oue) {
            AppMethodBeat.o(76495);
        } else if (this.mContext == null) {
            AppMethodBeat.o(76495);
        } else if (!Build.MANUFACTURER.equalsIgnoreCase("meizu") || com.tencent.mm.compatible.f.b.Mj()) {
            mi miVar = new mi();
            miVar.cIm.type = 2;
            com.tencent.mm.sdk.b.a.xxA.m(miVar);
            if (miVar.cIn.cIl) {
                this.oue = true;
                AppMethodBeat.o(76495);
                return;
            }
            com.tencent.mm.ui.widget.a.c g = h.g(this.mContext, R.string.ehg, R.string.tz);
            if (g != null) {
                g.setCancelable(false);
                g.setCanceledOnTouchOutside(false);
                g.show();
                this.oue = true;
            }
            AppMethodBeat.o(76495);
        } else {
            AppMethodBeat.o(76495);
        }
    }

    public final String bPo() {
        AppMethodBeat.i(76496);
        String str;
        if (this.erH == null) {
            str = "";
            AppMethodBeat.o(76496);
            return str;
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            ArrayList c = com.tencent.mm.plugin.mmsight.d.c(this.erH.getParameters());
            Point eu = com.tencent.mm.plugin.mmsight.d.eu(this.mContext);
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
            stringBuffer.append("\nrecorderOption: " + q.etj.etG);
            str = stringBuffer.toString();
            AppMethodBeat.o(76496);
            return str;
        } catch (Exception e) {
            ab.e("MicroMsg.MMSightCamera", "getDebugInfo error: %s", e.getMessage());
            AppMethodBeat.o(76496);
            return null;
        }
    }

    public final void a(b bVar, boolean z, int i) {
        AppMethodBeat.i(76497);
        ab.i("MicroMsg.MMSightCamera", "takePicture, callback: %s, currentFrameData: %s, isLandscape: %s, degree: %s", bVar, this.fbl, Boolean.valueOf(z), Integer.valueOf(i));
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
                byte[] g = com.tencent.mm.plugin.mmsight.model.a.j.owk.g(Integer.valueOf(this.fbl.length));
                System.arraycopy(this.fbl, 0, g, 0, this.fbl.length);
                int i2 = this.fbb.rotate;
                bVar.a(g, point.x, point.y, i2, i);
            } catch (Exception e) {
                ab.e("MicroMsg.MMSightCamera", "takePicture error: %s", e.getMessage());
                this.fbk = false;
                bVar.a(null, 0, 0, -1, 0);
            } finally {
                this.fbk = false;
                AppMethodBeat.o(76497);
            }
            return;
        }
        bVar.a(null, 0, 0, -1, 0);
        AppMethodBeat.o(76497);
    }

    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    public final void onSensorChanged(SensorEvent sensorEvent) {
        AppMethodBeat.i(76498);
        float f = sensorEvent.values[0];
        float f2 = sensorEvent.values[1];
        float f3 = sensorEvent.values[2];
        if (Math.abs(this.otP - f) > 5.0f || Math.abs(this.otQ - f2) > 5.0f || Math.abs(this.otR - f3) > 5.0f) {
            ab.i("MicroMsg.MMSightCamera", "match accel limit %f, try auto focus x %s y %s z %s", Float.valueOf(5.0f), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3));
            this.oug.e(this.erH);
            this.otP = f;
            this.otQ = f2;
            this.otR = f3;
        }
        AppMethodBeat.o(76498);
    }

    public final void b(float f, float f2, int i, int i2) {
        AppMethodBeat.i(76499);
        if (d.fP(14)) {
            AppMethodBeat.o(76499);
            return;
        }
        this.oug.removeMessages(4354);
        this.oug.faK = f;
        this.oug.faL = f2;
        this.oug.faM = i;
        this.oug.faN = i2;
        this.oug.sendMessageDelayed(this.oug.obtainMessage(4354, this.erH), 400);
        AppMethodBeat.o(76499);
    }

    public final void bPp() {
        AppMethodBeat.i(76500);
        if (this.erH != null && this.otL) {
            try {
                Parameters parameters = this.erH.getParameters();
                List supportedFocusModes = parameters.getSupportedFocusModes();
                if (supportedFocusModes != null && supportedFocusModes.contains("auto")) {
                    ab.i("MicroMsg.MMSightCameraSetting", "support auto focus");
                    parameters.setFocusMode("auto");
                    this.erH.setParameters(parameters);
                }
                this.erH.cancelAutoFocus();
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.MMSightCamera", e, "simple auto focus error", new Object[0]);
            }
            this.erH.autoFocus(new AutoFocusCallback() {
                public final void onAutoFocus(boolean z, Camera camera) {
                    AppMethodBeat.i(76470);
                    if (camera != null && e.this.bPu()) {
                        try {
                            Parameters parameters = camera.getParameters();
                            List supportedFocusModes = parameters.getSupportedFocusModes();
                            if (supportedFocusModes != null && supportedFocusModes.contains("continuous-picture")) {
                                ab.i("MicroMsg.MMSightCameraSetting", "support continues picture focus");
                                parameters.setFocusMode("continuous-picture");
                                camera.setParameters(parameters);
                            }
                            AppMethodBeat.o(76470);
                            return;
                        } catch (Exception e) {
                            ab.printErrStackTrace("MicroMsg.MMSightCamera", e, "simple auto focus resetToPictureFocus error", new Object[0]);
                        }
                    }
                    AppMethodBeat.o(76470);
                }
            });
        }
        AppMethodBeat.o(76500);
    }

    public final void d(boolean z, boolean z2, int i) {
        AppMethodBeat.i(76501);
        if (this.erH == null || !this.otL) {
            AppMethodBeat.o(76501);
            return;
        }
        try {
            ab.d("MicroMsg.MMSightCamera", "triggerSmallZoom, zoom: %s", Boolean.valueOf(z));
            if (this.aJI) {
                ab.d("MicroMsg.MMSightCamera", "triggerSmallZoom, zooming, ignore");
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
                    ab.e("MicroMsg.MMSightCamera", "scroll zoom error, scrollSmallZoomStep: %s", Integer.valueOf(this.fbd));
                    this.aJI = false;
                    AppMethodBeat.o(76501);
                    return;
                } else {
                    i2 = this.fbd;
                }
                ab.d("MicroMsg.MMSightCamera", "triggerSmallZoom, currentZoom: %s, maxZoom: %s, smallZoomStep: %s, scrollSmallZoomStep: %s, factor: %s", Integer.valueOf(zoom), Integer.valueOf(maxZoom), Integer.valueOf(this.fbe), Integer.valueOf(this.fbd), Integer.valueOf(i));
                if (i > 0) {
                    i2 *= i;
                }
                if (z) {
                    if (zoom >= maxZoom) {
                        this.aJI = false;
                        AppMethodBeat.o(76501);
                        return;
                    }
                    i2 += zoom;
                    if (i2 < maxZoom) {
                        maxZoom = i2;
                    }
                } else if (zoom == 0) {
                    this.aJI = false;
                    AppMethodBeat.o(76501);
                    return;
                } else {
                    maxZoom = zoom - i2;
                    if (maxZoom <= 0) {
                        maxZoom = 0;
                    }
                }
                ab.d("MicroMsg.MMSightCamera", "triggerSmallZoom, nextZoom: %s", Integer.valueOf(maxZoom));
                parameters.setZoom(maxZoom);
                this.erH.setParameters(parameters);
            }
            this.aJI = false;
            AppMethodBeat.o(76501);
        } catch (Exception e) {
            ab.e("MicroMsg.MMSightCamera", "triggerSmallZoom error: %s", e.getMessage());
        } finally {
            this.aJI = false;
            AppMethodBeat.o(76501);
        }
    }

    public final void kj(int i) {
        AppMethodBeat.i(76502);
        if (this.fbd > 0) {
            AppMethodBeat.o(76502);
            return;
        }
        int i2 = ae.hy(ah.getContext()).y;
        ab.i("MicroMsg.MMSightCamera", "calcScrollZoomStep, recordButtonTopLocation: %s, screenSize: %s", Integer.valueOf(i), r0);
        if (i2 / 2 >= i) {
            AppMethodBeat.o(76502);
            return;
        }
        try {
            if (this.erH != null) {
                this.fbd = ((int) (((double) this.erH.getParameters().getMaxZoom()) / ((((double) i) / 3.0d) / 10.0d))) + 1;
                ab.i("MicroMsg.MMSightCamera", "scrollSmallZoomStep: %s, maxZoom: %s", Integer.valueOf(this.fbd), Integer.valueOf(r0));
            }
            AppMethodBeat.o(76502);
        } catch (Exception e) {
            ab.e("MicroMsg.MMSightCamera", "calcScrollZoomStep error: %s", e.getMessage());
            AppMethodBeat.o(76502);
        }
    }

    public final boolean v(Context context, boolean z) {
        AppMethodBeat.i(76503);
        if (!j.ouz.ouN || (q.etc.erq == 0 && this.bCW == null && this.otO == null)) {
            this.bCW = (SensorManager) ah.getContext().getSystemService("sensor");
            this.otO = this.bCW.getDefaultSensor(1);
        }
        if (this.erH == null) {
            bPl();
            this.fas = z;
            if (z) {
                try {
                    this.otM = com.tencent.mm.compatible.e.d.Lr();
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.MMSightCamera", e, "try to get cameraid error %s, useBackCamera: %s", e.getMessage(), Boolean.valueOf(this.fas));
                    this.otM = 0;
                }
            } else {
                this.otM = com.tencent.mm.compatible.e.d.Ls();
            }
            ab.i("MicroMsg.MMSightCamera", "use camera id %d, DeviceInfo id %d", Integer.valueOf(this.otM), Integer.valueOf(q.etc.ert));
            this.oue = false;
            this.mContext = context;
            this.fbb = new n().R(context, this.otM);
            ab.i("MicroMsg.MMSightCamera", "open camera end, %s", Looper.myLooper());
            if (this.fbb == null) {
                ab.i("MicroMsg.MMSightCamera", "open camera FAILED, %s", Looper.myLooper());
                Wf();
                AppMethodBeat.o(76503);
                return false;
            }
            this.erH = this.fbb.erH;
            this.oug.faJ = false;
            this.fav.rotate = this.fbb.rotate;
            if (this.erH == null) {
                ab.e("MicroMsg.MMSightCamera", "start camera FAILED!");
                Wf();
                AppMethodBeat.o(76503);
                return false;
            }
        }
        AppMethodBeat.o(76503);
        return true;
    }

    public final boolean a(Context context, SurfaceTexture surfaceTexture, boolean z) {
        AppMethodBeat.i(76504);
        ab.i("MicroMsg.MMSightCamera", "switch camera, current useBack: %s", Boolean.valueOf(this.fas));
        try {
            bPq();
            v(context, !this.fas);
            a(surfaceTexture, z);
            AppMethodBeat.o(76504);
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.MMSightCamera", "switchCamera error: %s", e);
            AppMethodBeat.o(76504);
            return false;
        }
    }

    public final boolean a(Context context, SurfaceTexture surfaceTexture, int i, float f, boolean z) {
        AppMethodBeat.i(76505);
        ab.i("MicroMsg.MMSightCamera", "switch camera with limit, current useBack: %s", Boolean.valueOf(this.fas));
        try {
            bPq();
            v(context, !this.fas);
            a(surfaceTexture, i, f, z);
            AppMethodBeat.o(76505);
            return true;
        } catch (Exception e) {
            ab.e("MicroMsg.MMSightCamera", "switchCamera error: %s", e);
            AppMethodBeat.o(76505);
            return false;
        }
    }

    public final int bPq() {
        AppMethodBeat.i(76506);
        bPl();
        AppMethodBeat.o(76506);
        return 0;
    }

    public final void bPr() {
        AppMethodBeat.i(76507);
        ab.i("MicroMsg.MMSightCamera", "openFlash, camera: %s, isPreviewing: %s", this.erH, Boolean.valueOf(this.otL));
        if (this.erH != null && this.otL) {
            try {
                this.otY = true;
                Parameters parameters = this.erH.getParameters();
                if (bo.ek(parameters.getSupportedFlashModes()) || !parameters.getSupportedFlashModes().contains("torch")) {
                    ab.i("MicroMsg.MMSightCamera", "camera not support flash!!");
                    AppMethodBeat.o(76507);
                    return;
                }
                parameters.setFlashMode("torch");
                this.erH.setParameters(parameters);
                ab.i("MicroMsg.MMSightCamera", "open flash");
                AppMethodBeat.o(76507);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.MMSightCamera", e, "openFlash error: %s", e.getMessage());
            }
        }
        AppMethodBeat.o(76507);
    }

    public final void bPs() {
        AppMethodBeat.i(76508);
        ab.i("MicroMsg.MMSightCamera", "closeFlash, camera: %s, isPreviewing: %s", this.erH, Boolean.valueOf(this.otL));
        if (this.erH != null && this.otL) {
            try {
                this.otY = false;
                Parameters parameters = this.erH.getParameters();
                if (bo.ek(parameters.getSupportedFlashModes()) || !parameters.getSupportedFlashModes().contains("off")) {
                    ab.i("MicroMsg.MMSightCamera", "camera not support close flash!!");
                    AppMethodBeat.o(76508);
                    return;
                }
                parameters.setFlashMode("off");
                this.erH.setParameters(parameters);
                ab.i("MicroMsg.MMSightCamera", "close flash");
                AppMethodBeat.o(76508);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.MMSightCamera", e, "closeFlash error: %s", e.getMessage());
            }
        }
        AppMethodBeat.o(76508);
    }

    public final void bPt() {
        AppMethodBeat.i(76509);
        ab.i("MicroMsg.MMSightCamera", "autoFlash, camera: %s, isPreviewing: %s", this.erH, Boolean.valueOf(this.otL));
        if (this.erH != null && this.otL) {
            try {
                this.otY = true;
                Parameters parameters = this.erH.getParameters();
                if (bo.ek(parameters.getSupportedFlashModes()) || !parameters.getSupportedFlashModes().contains("auto")) {
                    ab.i("MicroMsg.MMSightCamera", "camera not support auto flash!!");
                    AppMethodBeat.o(76509);
                    return;
                }
                parameters.setFlashMode("auto");
                this.erH.setParameters(parameters);
                ab.i("MicroMsg.MMSightCamera", "auto flash");
                AppMethodBeat.o(76509);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.MMSightCamera", e, "autoFlash error: %s", e.getMessage());
            }
        }
        AppMethodBeat.o(76509);
    }

    public final int getPreviewWidth() {
        int i = 0;
        AppMethodBeat.i(76510);
        if (this.erH == null) {
            AppMethodBeat.o(76510);
        } else {
            if (this.fbb != null) {
                try {
                    i = (!this.otW || this.otV == null) ? this.fbc == null ? (this.fbb.rotate == 0 || this.fbb.rotate == 180) ? this.fav.lZe : this.fav.lZf : (this.fbb.rotate == 0 || this.fbb.rotate == 180) ? this.fbc.x : this.fbc.y : (this.fbb.rotate == 0 || this.fbb.rotate == 180) ? this.otT.x : this.otT.y;
                    AppMethodBeat.o(76510);
                } catch (Exception e) {
                    ab.e("MicroMsg.MMSightCamera", "getPreviewWidth: %s", e.getMessage());
                }
            }
            AppMethodBeat.o(76510);
        }
        return i;
    }

    public final int getPreviewHeight() {
        int i = 0;
        AppMethodBeat.i(76511);
        if (this.erH == null) {
            AppMethodBeat.o(76511);
        } else {
            if (this.fbb != null) {
                try {
                    i = (!this.otW || this.otV == null) ? this.fbc == null ? (this.fbb.rotate == 0 || this.fbb.rotate == 180) ? this.fav.lZf : this.fav.lZe : (this.fbb.rotate == 0 || this.fbb.rotate == 180) ? this.fbc.y : this.fbc.x : (this.fbb.rotate == 0 || this.fbb.rotate == 180) ? this.otT.y : this.otT.x;
                    AppMethodBeat.o(76511);
                } catch (Exception e) {
                    ab.e("MicroMsg.MMSightCamera", "getPreviewHeight: %s", e.getMessage());
                }
            }
            AppMethodBeat.o(76511);
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
