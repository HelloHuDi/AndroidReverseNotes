package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.f.d;
import com.tencent.mm.plugin.appbrand.r.j;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.f;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.g;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class AppBrandCameraView extends RelativeLayout implements e, com.tencent.mm.plugin.appbrand.jsapi.f.b, com.tencent.mm.plugin.appbrand.jsapi.f.c, d {
    private ImageView cAw;
    private String fcU;
    private Rect hGA;
    private int hGB;
    private c hGC;
    private b hGD;
    private MMSightRecordView hGE;
    private String hGF;
    private String hGG;
    int hGH = -1;
    private boolean hGI = false;
    private long hGJ = -1;
    private long hGK = -1;
    private d hGL;
    private boolean hGM;
    com.tencent.mm.plugin.mmsight.api.MMSightRecordView.a hGN = new com.tencent.mm.plugin.mmsight.api.MMSightRecordView.a() {
        public final void q(byte[] bArr, int i, int i2) {
            AppMethodBeat.i(130912);
            if (AppBrandCameraView.this.hGp != null) {
                AppBrandCameraView.this.hGp.q(bArr, i, i2);
            }
            AppMethodBeat.o(130912);
        }
    };
    private e hGm;
    private String hGn = JsApiScanCode.NAME;
    private int hGo;
    private a hGp;
    private int hGq;
    private String hGr = "back";
    private String hGs = "auto";
    private String hGt = "high";
    private boolean hGu;
    private boolean hGv = false;
    private int hGw = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
    private int hGx = 1920;
    private int hGy = FilterEnum4Shaka.MIC_WEISHI_v4_4_ZIRAN;
    private int hGz = 1920;
    private String mAppId;
    private Context mContext;

    class b implements a {
        private b() {
        }

        /* synthetic */ b(AppBrandCameraView appBrandCameraView, byte b) {
            this();
        }

        static /* synthetic */ void a(b bVar, int i, String str, String str2, String str3) {
            AppMethodBeat.i(130926);
            bVar.d(i, str, str2, str3);
            AppMethodBeat.o(130926);
        }

        public final void init() {
        }

        public final void q(byte[] bArr, int i, int i2) {
            AppMethodBeat.i(130917);
            if (AppBrandCameraView.this.hGu) {
                AppMethodBeat.o(130917);
            } else {
                AppMethodBeat.o(130917);
            }
        }

        public final void aDd() {
            AppMethodBeat.i(130918);
            ab.i("MicroMsg.AppBrandCameraView", "takePicture.");
            if (AppBrandCameraView.this.hGE == null) {
                ab.i("MicroMsg.AppBrandCameraView", "recordView is null");
                AppMethodBeat.o(130918);
            } else if (AppBrandCameraView.this.hGH == 2) {
                ab.w("MicroMsg.AppBrandCameraView", "takePicture is recording!!");
                AppMethodBeat.o(130918);
            } else if (AppBrandCameraView.this.hGI || bo.az(AppBrandCameraView.this.hGJ) < 300) {
                ab.i("MicroMsg.AppBrandCameraView", "not the right time to take picture.");
                AppMethodBeat.o(130918);
            } else if (AppBrandCameraView.this.hGM) {
                AppBrandCameraView.this.hGJ = bo.yz();
                AppBrandCameraView.this.hGI = true;
                AppBrandCameraView.this.hGH = 3;
                AppBrandCameraView.this.hGE.a(new g() {
                    public final void F(Bitmap bitmap) {
                        AppMethodBeat.i(130913);
                        if (bitmap == null) {
                            AppBrandCameraView.a(AppBrandCameraView.this, -1, null, "bitmap is null");
                            AppMethodBeat.o(130913);
                        } else if (b.this.a(bitmap, AppBrandCameraView.this.fcU)) {
                            AppBrandCameraView.a(AppBrandCameraView.this, 0, b.g(AppBrandCameraView.this.hGm, AppBrandCameraView.this.fcU), "");
                            AppMethodBeat.o(130913);
                        } else {
                            AppBrandCameraView.a(AppBrandCameraView.this, -1, null, "save fail");
                            AppMethodBeat.o(130913);
                        }
                    }

                    public final void aDq() {
                        AppMethodBeat.i(130914);
                        AppBrandCameraView.a(AppBrandCameraView.this, -1, null, "take picture error");
                        AppMethodBeat.o(130914);
                    }
                }, "on".equals(AppBrandCameraView.this.hGs));
                AppMethodBeat.o(130918);
            } else {
                ab.w("MicroMsg.AppBrandCameraView", "takePicture err, isn't init done");
                AppBrandCameraView.a(AppBrandCameraView.this, -1, null, "camera has not been initialized");
                AppMethodBeat.o(130918);
            }
        }

        /* Access modifiers changed, original: final */
        public final boolean a(Bitmap bitmap, String str) {
            AppMethodBeat.i(130919);
            if (!(bitmap == null || bitmap.isRecycled())) {
                try {
                    AppBrandCameraView.this.hGy = bitmap.getWidth();
                    AppBrandCameraView.this.hGz = bitmap.getHeight();
                    int i = 90;
                    if ("normal".equals(AppBrandCameraView.this.hGt)) {
                        i = 44;
                    } else if ("low".equals(AppBrandCameraView.this.hGt)) {
                        i = 25;
                    }
                    com.tencent.mm.sdk.platformtools.d.a(bitmap, i, CompressFormat.JPEG, str, true);
                    ab.i("MicroMsg.AppBrandCameraView", "bitmap filelen %s", Long.valueOf(com.tencent.mm.vfs.e.asZ(str)));
                    AppMethodBeat.o(130919);
                    return true;
                } catch (Exception e) {
                    ab.e("MicroMsg.AppBrandCameraView", "error for saveBitmapToImage %s", e.getMessage());
                }
            }
            AppMethodBeat.o(130919);
            return false;
        }

        public final void aDm() {
            int i;
            AppMethodBeat.i(130920);
            ab.i("MicroMsg.AppBrandCameraView", "startRecord.");
            a aDb = a.hGl;
            if (!(aDb.hGi && aDb.hGj)) {
                ab.i("MicroMsg.AppBrandCameraMrg", "no all permission");
            }
            if (aDb.hGi && aDb.hGj) {
                i = 1;
            } else {
                i = 0;
            }
            if (i == 0) {
                Toast.makeText(AppBrandCameraView.this.mContext, R.string.czz, 1).show();
                ab.w("MicroMsg.AppBrandCameraView", "no micro phone permission");
                Q(-1, "permission");
                AppMethodBeat.o(130920);
            } else if (AppBrandCameraView.this.hGH == 2) {
                ab.w("MicroMsg.AppBrandCameraView", "startRecord is recording!!");
                Q(-1, "is recording");
                AppMethodBeat.o(130920);
            } else if (!AppBrandCameraView.this.hGM) {
                ab.w("MicroMsg.AppBrandCameraView", "startRecord err, isn't init done");
                Q(-1, "camera has not been initialized");
                AppMethodBeat.o(130920);
            } else if (AppBrandCameraView.this.hGE.osY.EL()) {
                AppBrandCameraView.this.hGK = bo.yz();
                AppBrandCameraView.this.hGH = 2;
                Q(0, "");
                AppBrandCameraView.p(AppBrandCameraView.this);
                AppMethodBeat.o(130920);
            } else {
                ab.w("MicroMsg.AppBrandCameraView", "startRecord fail !!");
                Q(-1, "startRecord fail");
                AppMethodBeat.o(130920);
            }
        }

        private void Q(int i, String str) {
            AppMethodBeat.i(130921);
            if (AppBrandCameraView.this.hGC != null) {
                AppBrandCameraView.this.hGC.Q(i, str);
            }
            AppMethodBeat.o(130921);
        }

        public final void stopRecord() {
            AppMethodBeat.i(130922);
            ab.i("MicroMsg.AppBrandCameraView", JsApiStopRecordVoice.NAME);
            if (AppBrandCameraView.this.hGE == null) {
                ab.i("MicroMsg.AppBrandCameraView", "recordView is null");
                d(-1, "camera is null", null, null);
                AppMethodBeat.o(130922);
            } else if (AppBrandCameraView.this.hGH != 2) {
                ab.w("MicroMsg.AppBrandCameraView", "stopRecord is not recording!!");
                d(-1, "is not recording", null, null);
                AppMethodBeat.o(130922);
            } else if (AppBrandCameraView.this.hGv) {
                ab.i("MicroMsg.AppBrandCameraView", "recordView is IsStopping");
                d(-1, "is stopping", null, null);
                AppMethodBeat.o(130922);
            } else {
                AppBrandCameraView.this.hGv = true;
                AppBrandCameraView.this.hGE.a(new h() {
                    public final void dX(boolean z) {
                        AppMethodBeat.i(130915);
                        ab.i("MicroMsg.AppBrandCameraView", "onRecordFinish error %b", Boolean.valueOf(z));
                        if (AppBrandCameraView.this.hGE == null) {
                            ab.i("MicroMsg.AppBrandCameraView", "onRecordFinish recordView is null");
                            b.a(b.this, -1, "camera is null", null, null);
                            AppMethodBeat.o(130915);
                            return;
                        }
                        AppBrandCameraView.this.hGH = 1;
                        if (z) {
                            b.a(b.this, -1, "stop error", null, null);
                        } else {
                            String videoFilePath = AppBrandCameraView.this.hGE.getVideoFilePath();
                            int s = AppBrandCameraView.this.hGw;
                            int t = AppBrandCameraView.this.hGx;
                            AppBrandCameraView.this.hGE.getCameraRotation();
                            b.this.a(com.tencent.mm.plugin.sight.base.d.ag(videoFilePath, s, t), AppBrandCameraView.this.hGG);
                            b.a(b.this, 0, "", AppBrandCameraView.this.hGG, AppBrandCameraView.this.hGE.getVideoFilePath());
                        }
                        AppBrandCameraView.v(AppBrandCameraView.this);
                        AppBrandCameraView.this.hGv = false;
                        AppMethodBeat.o(130915);
                    }
                });
                AppMethodBeat.o(130922);
            }
        }

        private void d(int i, String str, String str2, String str3) {
            AppMethodBeat.i(130923);
            if (AppBrandCameraView.this.hGC != null) {
                AppBrandCameraView.this.hGC.d(i, str, g(AppBrandCameraView.this.hGm, str2), g(AppBrandCameraView.this.hGm, str3));
            }
            AppBrandCameraView.p(AppBrandCameraView.this);
            AppMethodBeat.o(130923);
        }

        public final void aDn() {
            AppMethodBeat.i(130924);
            long az = bo.az(AppBrandCameraView.this.hGK);
            if (az < 1500) {
                ab.i("MicroMsg.AppBrandCameraView", "stopRecord in %d ms later", Long.valueOf(1500 - az));
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(130916);
                        b.this.stopRecord();
                        AppMethodBeat.o(130916);
                    }
                }, 1500 - az);
                AppMethodBeat.o(130924);
                return;
            }
            stopRecord();
            AppMethodBeat.o(130924);
        }

        static String g(com.tencent.mm.plugin.appbrand.jsapi.c cVar, String str) {
            AppMethodBeat.i(130925);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(130925);
                return str;
            }
            j jVar = new j();
            if (cVar.asE().a(new File(str), "", true, jVar) == com.tencent.mm.plugin.appbrand.appstorage.j.OK) {
                String str2 = (String) jVar.value;
                AppMethodBeat.o(130925);
                return str2;
            }
            AppMethodBeat.o(130925);
            return null;
        }

        public final void release() {
        }
    }

    public interface a {
        void aDd();

        void aDm();

        void aDn();

        void init();

        void q(byte[] bArr, int i, int i2);

        void release();
    }

    class c implements a, com.tencent.mm.plugin.appbrand.jsapi.camera.a.c.a {
        private int duration;
        private com.tencent.mm.plugin.appbrand.jsapi.camera.a.c hGQ;
        AtomicBoolean hGR;
        private int hGS;

        private c() {
            AppMethodBeat.i(130928);
            this.hGR = new AtomicBoolean(false);
            this.hGS = 200;
            this.duration = this.hGS;
            AppMethodBeat.o(130928);
        }

        /* synthetic */ c(AppBrandCameraView appBrandCameraView, byte b) {
            this();
        }

        public final void init() {
            AppMethodBeat.i(130929);
            this.hGQ = new com.tencent.mm.plugin.appbrand.jsapi.camera.a.d();
            this.hGQ.init();
            this.hGQ.hHx = this;
            AppBrandCameraView.this.hGH = 4;
            if (AppBrandCameraView.this.hGB > 0) {
                this.duration = 1000 / AppBrandCameraView.this.hGB;
            }
            AppMethodBeat.o(130929);
        }

        public final void q(byte[] bArr, int i, int i2) {
            AppMethodBeat.i(130930);
            if (this.hGR.get()) {
                ab.d("MicroMsg.AppBrandCameraView", "[onFrameData] isScanPause, return");
                AppMethodBeat.o(130930);
                return;
            }
            if (!(this.hGQ == null || AppBrandCameraView.this.hGE == null)) {
                this.hGQ.a(bArr, i, i2, AppBrandCameraView.this.hGA, AppBrandCameraView.this.hGE.getCameraRotation());
            }
            AppMethodBeat.o(130930);
        }

        public final void b(int i, String str, byte[] bArr) {
            AppMethodBeat.i(130931);
            if (this.hGR.compareAndSet(false, true)) {
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(130927);
                        c.this.hGR.set(false);
                        AppMethodBeat.o(130927);
                    }
                }, (long) this.duration);
                ab.d("MicroMsg.AppBrandCameraView", "resultText:%s, resultType:%d", str, Integer.valueOf(i));
                switch (i) {
                    case 1:
                        h.a(AppBrandCameraView.this.hGm, AppBrandCameraView.this.getCameraId(), "qrcode", str, bArr);
                        AppMethodBeat.o(130931);
                        return;
                    case 2:
                        h.a(AppBrandCameraView.this.hGm, AppBrandCameraView.this.getCameraId(), "barcode", str, bArr);
                        AppMethodBeat.o(130931);
                        return;
                    default:
                        ab.w("MicroMsg.AppBrandCameraView", "resultType:%d is not support, ignore");
                        break;
                }
            }
            AppMethodBeat.o(130931);
        }

        public final void aDd() {
            AppMethodBeat.i(130932);
            ab.e("MicroMsg.AppBrandCameraView", "ScanCodeMode, takePicture err");
            AppMethodBeat.o(130932);
        }

        public final void aDm() {
            AppMethodBeat.i(130933);
            ab.e("MicroMsg.AppBrandCameraView", "ScanCodeMode, startRecord err");
            AppMethodBeat.o(130933);
        }

        public final void aDn() {
            AppMethodBeat.i(130934);
            ab.e("MicroMsg.AppBrandCameraView", "ScanCodeMode, safeStopRecord err");
            AppMethodBeat.o(130934);
        }

        public final void release() {
            AppMethodBeat.i(130935);
            if (this.hGQ != null) {
                this.hGQ.release();
            }
            AppMethodBeat.o(130935);
        }
    }

    static /* synthetic */ void p(AppBrandCameraView appBrandCameraView) {
        AppMethodBeat.i(130966);
        appBrandCameraView.aDj();
        AppMethodBeat.o(130966);
    }

    static /* synthetic */ void v(AppBrandCameraView appBrandCameraView) {
        AppMethodBeat.i(130967);
        appBrandCameraView.aDi();
        AppMethodBeat.o(130967);
    }

    public static void aDc() {
        AppMethodBeat.i(130936);
        j.hHa = new com.tencent.mm.plugin.appbrand.jsapi.camera.j.a() {
            public final /* synthetic */ e cI(Context context) {
                AppMethodBeat.i(130909);
                AppBrandCameraView appBrandCameraView = new AppBrandCameraView(context);
                AppMethodBeat.o(130909);
                return appBrandCameraView;
            }
        };
        AppMethodBeat.o(130936);
    }

    public AppBrandCameraView(Context context) {
        super(context);
        AppMethodBeat.i(130937);
        init(context);
        AppMethodBeat.o(130937);
    }

    public AppBrandCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(130938);
        init(context);
        AppMethodBeat.o(130938);
    }

    public AppBrandCameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(130939);
        init(context);
        AppMethodBeat.o(130939);
    }

    public void setOperateCallBack(c cVar) {
        this.hGC = cVar;
    }

    public void setOutPutCallBack(b bVar) {
        this.hGD = bVar;
    }

    private void init(Context context) {
        AppMethodBeat.i(130940);
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.bp, this);
        AppMethodBeat.o(130940);
    }

    public final void initView() {
        AppMethodBeat.i(130941);
        ab.i("MicroMsg.AppBrandCameraView", "initView");
        if (a.hGl.aDa()) {
            aDi();
            aDh();
            aDe();
            aDf();
            AppMethodBeat.o(130941);
            return;
        }
        AppMethodBeat.o(130941);
    }

    public View getView() {
        return this;
    }

    public void setPage(e eVar) {
        this.hGm = eVar;
    }

    public void setMode(String str) {
        this.hGn = str;
    }

    public void setFrameLimitSize(int i) {
        AppMethodBeat.i(130942);
        ab.i("MicroMsg.AppBrandCameraView", "setFrameLimitSize:%d", Integer.valueOf(i));
        this.hGo = i;
        AppMethodBeat.o(130942);
    }

    public void setAppId(String str) {
        this.mAppId = str;
    }

    public final void ai(String str, boolean z) {
        AppMethodBeat.i(130943);
        if (bo.isEqual(this.hGr, str)) {
            AppMethodBeat.o(130943);
        } else if (bo.isEqual(this.hGn, JsApiScanCode.NAME)) {
            AppMethodBeat.o(130943);
        } else {
            this.hGr = str;
            if (!(z || this.hGE == null)) {
                this.hGE.osY.switchCamera();
            }
            AppMethodBeat.o(130943);
        }
    }

    public void setCameraId(int i) {
        this.hGq = i;
    }

    public int getCameraId() {
        return this.hGq;
    }

    public void setFlash(String str) {
        AppMethodBeat.i(130944);
        if (bo.isEqual(this.hGs, str)) {
            AppMethodBeat.o(130944);
            return;
        }
        this.hGs = str;
        AppMethodBeat.o(130944);
    }

    public void setQuality(String str) {
        AppMethodBeat.i(130945);
        if (bo.isEqual(this.hGt, str)) {
            AppMethodBeat.o(130945);
            return;
        }
        this.hGt = str;
        AppMethodBeat.o(130945);
    }

    public final boolean da(int i, int i2) {
        AppMethodBeat.i(130946);
        if (this.hGw == i && this.hGx == i2) {
            AppMethodBeat.o(130946);
            return false;
        }
        ab.i("MicroMsg.AppBrandCameraView", "setViewSize");
        this.hGw = i;
        this.hGx = i2;
        AppMethodBeat.o(130946);
        return true;
    }

    public void setNeedOutput(boolean z) {
        this.hGu = z;
    }

    public final void onDestroy() {
        AppMethodBeat.i(130949);
        if (this.hGL != null) {
            this.hGL.a(this.hGE);
        }
        release();
        AppMethodBeat.o(130949);
    }

    public final void release() {
        AppMethodBeat.i(130950);
        ab.i("MicroMsg.AppBrandCameraView", "release");
        synchronized (AppBrandCameraView.class) {
            try {
                if (this.hGE != null) {
                    this.hGE.osY.release();
                    removeView(this.hGE);
                    this.hGH = -1;
                    this.hGE = null;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(130950);
            }
        }
        aDl();
    }

    public final void aDd() {
        AppMethodBeat.i(130951);
        if (this.hGp != null) {
            this.hGp.aDd();
        }
        AppMethodBeat.o(130951);
    }

    private void aDe() {
        AppMethodBeat.i(130952);
        ab.i("MicroMsg.AppBrandCameraView", "initCamera.");
        if (!a.hGl.aDa()) {
            Toast.makeText(this.mContext, R.string.czz, 1).show();
            ab.w("MicroMsg.AppBrandCameraView", "no permission");
            AppMethodBeat.o(130952);
        } else if (this.hGE != null) {
            ab.i("MicroMsg.AppBrandCameraView", "initCamera recordView not null.");
            AppMethodBeat.o(130952);
        } else {
            if (this.cAw == null) {
                this.cAw = new ImageView(this.mContext);
                this.cAw.setScaleType(ScaleType.FIT_XY);
                addView(this.cAw, new LayoutParams(-1, -1));
            } else {
                this.cAw.setImageBitmap(null);
            }
            this.hGE = new MMSightRecordView(this.mContext);
            this.hGM = false;
            addView(this.hGE);
            this.hGE.setPreviewSizeLimit(720);
            this.hGE.setRGBSizeLimit(this.hGo);
            this.hGE.osY.asu();
            this.hGE.setDisplayRatio((((float) this.hGw) * 1.0f) / ((float) this.hGx));
            this.hGE.setVideoPara$2e715812(600000);
            this.hGE.setVideoFilePath(this.hGF);
            this.hGE.setClipPictureSize(true);
            this.hGE.setClipVideoSize(true);
            this.hGE.setUseBackCamera("back".equals(this.hGr));
            this.hGE.setFrameDataCallback(this.hGN);
            this.hGE.setInitErrorCallback(new MMSightRecordView.d() {
                public final void aDo() {
                    AppMethodBeat.i(130910);
                    ab.w("MicroMsg.AppBrandCameraView", "InitErrorCallback");
                    HashMap hashMap = new HashMap();
                    hashMap.put("cameraId", Integer.valueOf(AppBrandCameraView.this.hGq));
                    new g().j(AppBrandCameraView.this.hGm).AM(new JSONObject(hashMap).toString()).aCj();
                    AppMethodBeat.o(130910);
                }
            });
            this.hGE.setInitDoneCallback(new com.tencent.mm.plugin.mmsight.api.MMSightRecordView.c() {
                public final void aDp() {
                    AppMethodBeat.i(130911);
                    AppBrandCameraView.this.hGM = true;
                    ab.i("MicroMsg.AppBrandCameraView", "InitDoneCallback");
                    f fVar = new f();
                    HashMap hashMap = new HashMap();
                    hashMap.put("cameraId", Integer.valueOf(AppBrandCameraView.this.hGq));
                    fVar.AM(new JSONObject(hashMap).toString());
                    AppBrandCameraView.this.hGm.b(fVar);
                    AppMethodBeat.o(130911);
                }
            });
            this.hGE.osY.startPreview();
            this.hGE.osY.aso();
            this.hGH = 1;
            AppMethodBeat.o(130952);
        }
    }

    public final void aDf() {
        AppMethodBeat.i(130953);
        if (this.hGE == null) {
            ab.i("MicroMsg.AppBrandCameraView", "recordView is null");
            AppMethodBeat.o(130953);
            return;
        }
        aDk();
        aDj();
        AppMethodBeat.o(130953);
    }

    public final void n(com.tencent.mm.plugin.appbrand.jsapi.c cVar) {
        AppMethodBeat.i(130954);
        if (this.hGC == null) {
            AppMethodBeat.o(130954);
        } else if (this.hGE == null) {
            ab.w("MicroMsg.AppBrandCameraView", "listenFrameChange recordView null");
            this.hGC.g("camera illegal state", -1, -1, -1);
            AppMethodBeat.o(130954);
        } else {
            int i;
            if (this.hGL == null) {
                this.hGL = new d(cVar);
            }
            int i2 = this.hGE.getDrawSizePoint().x;
            int i3 = this.hGE.getDrawSizePoint().y;
            f fVar = this.hGL;
            MMSightRecordView mMSightRecordView = this.hGE;
            if (mMSightRecordView == null) {
                ab.w("MicroMsg.FrameDataCallbackHelper", "listenFrameChange recordView null");
                i = -1;
            } else {
                if (fVar.hGW != android.support.v4.widget.j.INVALID_ID) {
                    ab.i("MicroMsg.FrameDataCallbackHelper", "listenFrameChange destroy last one bufferId:%d", Integer.valueOf(fVar.hGW));
                    fVar.hGU.oQ(fVar.hGW);
                }
                fVar.hGW = fVar.hGU.oS((i2 * i3) * 4);
                ab.i("MicroMsg.FrameDataCallbackHelper", "listenFrameChange bufferId:%d height:%d width:%d", Integer.valueOf(fVar.hGW), Integer.valueOf(i3), Integer.valueOf(i2));
                fVar.hGV = true;
                mMSightRecordView.a(fVar.hGU.oR(fVar.hGW), fVar);
                i = fVar.hGW;
            }
            if (i < 0) {
                this.hGC.g("camera illegal state", -1, -1, -1);
                AppMethodBeat.o(130954);
                return;
            }
            this.hGC.g(null, i, i2, i3);
            AppMethodBeat.o(130954);
        }
    }

    public final void aDg() {
        AppMethodBeat.i(130955);
        if (this.hGC == null) {
            AppMethodBeat.o(130955);
        } else if (this.hGL == null) {
            AppMethodBeat.o(130955);
        } else {
            this.hGL.a(this.hGE);
            this.hGL = null;
            AppMethodBeat.o(130955);
        }
    }

    private void aDh() {
        AppMethodBeat.i(130956);
        this.fcU = com.tencent.mm.compatible.util.e.euR + String.format("%s%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"});
        AppMethodBeat.o(130956);
    }

    private void aDi() {
        AppMethodBeat.i(130957);
        String str = "MicroMsg_" + System.currentTimeMillis();
        this.hGF = com.tencent.mm.compatible.util.e.euR + str + VideoMaterialUtil.MP4_SUFFIX;
        this.hGG = com.tencent.mm.compatible.util.e.euR + str + ".jpeg";
        if (this.hGE != null) {
            this.hGE.setVideoFilePath(this.hGF);
        }
        AppMethodBeat.o(130957);
    }

    private void aDj() {
        AppMethodBeat.i(130958);
        if (this.hGE == null || this.hGs == null) {
            AppMethodBeat.o(130958);
        } else if (this.hGs.equals("auto")) {
            this.hGE.setFlashMode(3);
            AppMethodBeat.o(130958);
        } else if (this.hGs.equals("torch")) {
            this.hGE.setFlashMode(1);
            AppMethodBeat.o(130958);
        } else {
            if (this.hGs.equals("on")) {
                if (this.hGH == 2 || this.hGH == 4 || !this.hGs.equals("on")) {
                    this.hGE.setFlashMode(1);
                    AppMethodBeat.o(130958);
                    return;
                }
            } else if (this.hGs.equals("torch")) {
                this.hGE.setFlashMode(1);
                AppMethodBeat.o(130958);
                return;
            }
            this.hGE.setFlashMode(2);
            AppMethodBeat.o(130958);
        }
    }

    private void aDk() {
        AppMethodBeat.i(130959);
        ab.i("MicroMsg.AppBrandCameraView", "setCameraMode mode:%s", this.hGn);
        aDl();
        if (bo.isNullOrNil(this.hGn) || !this.hGn.equals(JsApiScanCode.NAME)) {
            this.hGp = new b(this, (byte) 0);
        } else {
            this.hGp = new c(this, (byte) 0);
        }
        this.hGp.init();
        AppMethodBeat.o(130959);
    }

    private void aDl() {
        AppMethodBeat.i(130960);
        if (this.hGp != null) {
            this.hGp.release();
            this.hGp = null;
        }
        AppMethodBeat.o(130960);
    }

    public void setScanFreq(int i) {
        AppMethodBeat.i(130961);
        ab.i("MicroMsg.AppBrandCameraView", "scanFreq:%d", Integer.valueOf(i));
        if (i <= 0) {
            ab.e("MicroMsg.AppBrandCameraView", "scanFreq is err");
            AppMethodBeat.o(130961);
            return;
        }
        this.hGB = i;
        AppMethodBeat.o(130961);
    }

    public final void w(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(130962);
        ab.i("MicroMsg.AppBrandCameraView", "x:%d, y:%d, w:%d, h:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        if (i3 <= 0 || i4 <= 0) {
            AppMethodBeat.o(130962);
            return;
        }
        this.hGA = new Rect(i, i2, i + i3, i2 + i4);
        AppMethodBeat.o(130962);
    }

    public final void aDm() {
        AppMethodBeat.i(130963);
        if (this.hGp != null) {
            this.hGp.aDm();
        }
        AppMethodBeat.o(130963);
    }

    public final void aDn() {
        AppMethodBeat.i(130964);
        if (this.hGp != null) {
            this.hGp.aDn();
        }
        AppMethodBeat.o(130964);
    }

    public final void wW() {
        HashMap hashMap;
        AppMethodBeat.i(130947);
        ab.i("MicroMsg.AppBrandCameraView", "onUIPause");
        if (this.hGH == 2) {
            ab.d("MicroMsg.AppBrandCameraView", "onStopRecord fromOnPause");
            hashMap = new HashMap();
            hashMap.put("cameraId", Integer.valueOf(this.hGq));
            hashMap.put("errMsg", "stop on record");
            new k().j(this.hGm).AM(new JSONObject(hashMap).toString()).aCj();
        }
        if (this.hGE != null) {
            Bitmap currentFramePicture = this.hGE.getCurrentFramePicture();
            if (currentFramePicture != null) {
                this.cAw.setImageBitmap(currentFramePicture);
            }
        }
        if (this.hGL != null) {
            d dVar = this.hGL;
            MMSightRecordView mMSightRecordView = this.hGE;
            ab.i("MicroMsg.FrameDataCallbackHelper", "onUIPause mNeedCallback:%b", Boolean.valueOf(dVar.hGV));
            if (mMSightRecordView == null) {
                ab.w("MicroMsg.FrameDataCallbackHelper", "onUIPause recordView null");
            } else {
                mMSightRecordView.a(null, null);
            }
        }
        release();
        hashMap = new HashMap();
        hashMap.put("cameraId", Integer.valueOf(getCameraId()));
        new i().j(this.hGm).AM(new JSONObject(hashMap).toString()).aCj();
        AppMethodBeat.o(130947);
    }

    public final void wU() {
        AppMethodBeat.i(130948);
        ab.i("MicroMsg.AppBrandCameraView", "onUIResume");
        synchronized (AppBrandCameraView.class) {
            try {
                aDe();
                aDk();
                aDj();
                if (this.hGL != null) {
                    f fVar = this.hGL;
                    MMSightRecordView mMSightRecordView = this.hGE;
                    ab.i("MicroMsg.FrameDataCallbackHelper", "onUIResume mNeedCallback:%b", Boolean.valueOf(fVar.hGV));
                    if (fVar.hGV) {
                        if (mMSightRecordView == null) {
                            ab.w("MicroMsg.FrameDataCallbackHelper", "onUIResume recordView null");
                        } else if (fVar.hGW == android.support.v4.widget.j.INVALID_ID) {
                            ab.w("MicroMsg.FrameDataCallbackHelper", "onUIResume invalid mCurrentSharedBufferId");
                        } else if (fVar.hGU == null) {
                            ab.w("MicroMsg.FrameDataCallbackHelper", "onUIResume mSharedBufferAddon null");
                        } else {
                            mMSightRecordView.a(fVar.hGU.oR(fVar.hGW), fVar);
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(130948);
            }
        }
    }

    static /* synthetic */ void a(AppBrandCameraView appBrandCameraView, int i, String str, String str2) {
        AppMethodBeat.i(130965);
        ab.i("MicroMsg.AppBrandCameraView", "onTakePhoto.ret:%d, path:%s, errMsg:%s", Integer.valueOf(i), str, str2);
        if (appBrandCameraView.hGC != null) {
            appBrandCameraView.hGC.a(i, str, str2, appBrandCameraView.hGy, appBrandCameraView.hGz);
        }
        appBrandCameraView.hGI = false;
        appBrandCameraView.aDh();
        appBrandCameraView.hGH = 1;
        AppMethodBeat.o(130965);
    }
}
