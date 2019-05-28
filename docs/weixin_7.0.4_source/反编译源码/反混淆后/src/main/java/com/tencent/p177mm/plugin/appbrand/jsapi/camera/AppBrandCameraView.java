package com.tencent.p177mm.plugin.appbrand.jsapi.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Rect;
import android.support.p057v4.widget.C8415j;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.plugin.appbrand.appstorage.C45518j;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33303e;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10379b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10380c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10381d;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiScanCode;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiStopRecordVoice;
import com.tencent.p177mm.plugin.appbrand.jsapi.camera.C10360a.C10361a;
import com.tencent.p177mm.plugin.appbrand.jsapi.camera.C2247j.C2251a;
import com.tencent.p177mm.plugin.appbrand.jsapi.camera.p302a.C19350c;
import com.tencent.p177mm.plugin.appbrand.jsapi.camera.p302a.C19350c.C19351a;
import com.tencent.p177mm.plugin.appbrand.jsapi.camera.p302a.C26952d;
import com.tencent.p177mm.plugin.appbrand.p328r.C19681j;
import com.tencent.p177mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.p177mm.plugin.mmsight.api.MMSightRecordView.C12536a;
import com.tencent.p177mm.plugin.mmsight.api.MMSightRecordView.C21285c;
import com.tencent.p177mm.plugin.mmsight.api.MMSightRecordView.C21286d;
import com.tencent.p177mm.plugin.mmsight.api.MMSightRecordView.C21287f;
import com.tencent.p177mm.plugin.mmsight.api.MMSightRecordView.C21289g;
import com.tencent.p177mm.plugin.mmsight.api.MMSightRecordView.C3474h;
import com.tencent.p177mm.plugin.sight.base.C21846d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView */
public class AppBrandCameraView extends RelativeLayout implements C33272e, C10379b, C10380c, C10381d {
    private ImageView cAw;
    private String fcU;
    private Rect hGA;
    private int hGB;
    private C10362c hGC;
    private C26953b hGD;
    private MMSightRecordView hGE;
    private String hGF;
    private String hGG;
    int hGH = -1;
    private boolean hGI = false;
    private long hGJ = -1;
    private long hGK = -1;
    private C33271d hGL;
    private boolean hGM;
    C12536a hGN = new C166504();
    private C33303e hGm;
    private String hGn = JsApiScanCode.NAME;
    private int hGo;
    private C16651a hGp;
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

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView$b */
    class C10357b implements C16651a {

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView$b$2 */
        class C67732 implements C3474h {
            C67732() {
            }

            /* renamed from: dX */
            public final void mo7934dX(boolean z) {
                AppMethodBeat.m2504i(130915);
                C4990ab.m7417i("MicroMsg.AppBrandCameraView", "onRecordFinish error %b", Boolean.valueOf(z));
                if (AppBrandCameraView.this.hGE == null) {
                    C4990ab.m7416i("MicroMsg.AppBrandCameraView", "onRecordFinish recordView is null");
                    C10357b.m18059a(C10357b.this, -1, "camera is null", null, null);
                    AppMethodBeat.m2505o(130915);
                    return;
                }
                AppBrandCameraView.this.hGH = 1;
                if (z) {
                    C10357b.m18059a(C10357b.this, -1, "stop error", null, null);
                } else {
                    String videoFilePath = AppBrandCameraView.this.hGE.getVideoFilePath();
                    int s = AppBrandCameraView.this.hGw;
                    int t = AppBrandCameraView.this.hGx;
                    AppBrandCameraView.this.hGE.getCameraRotation();
                    C10357b.this.mo21830a(C21846d.m33390ag(videoFilePath, s, t), AppBrandCameraView.this.hGG);
                    C10357b.m18059a(C10357b.this, 0, "", AppBrandCameraView.this.hGG, AppBrandCameraView.this.hGE.getVideoFilePath());
                }
                AppBrandCameraView.m25643v(AppBrandCameraView.this);
                AppBrandCameraView.this.hGv = false;
                AppMethodBeat.m2505o(130915);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView$b$1 */
        class C103581 implements C21289g {
            C103581() {
            }

            /* renamed from: F */
            public final void mo21838F(Bitmap bitmap) {
                AppMethodBeat.m2504i(130913);
                if (bitmap == null) {
                    AppBrandCameraView.m25618a(AppBrandCameraView.this, -1, null, "bitmap is null");
                    AppMethodBeat.m2505o(130913);
                } else if (C10357b.this.mo21830a(bitmap, AppBrandCameraView.this.fcU)) {
                    AppBrandCameraView.m25618a(AppBrandCameraView.this, 0, C10357b.m18061g(AppBrandCameraView.this.hGm, AppBrandCameraView.this.fcU), "");
                    AppMethodBeat.m2505o(130913);
                } else {
                    AppBrandCameraView.m25618a(AppBrandCameraView.this, -1, null, "save fail");
                    AppMethodBeat.m2505o(130913);
                }
            }

            public final void aDq() {
                AppMethodBeat.m2504i(130914);
                AppBrandCameraView.m25618a(AppBrandCameraView.this, -1, null, "take picture error");
                AppMethodBeat.m2505o(130914);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView$b$3 */
        class C103593 implements Runnable {
            C103593() {
            }

            public final void run() {
                AppMethodBeat.m2504i(130916);
                C10357b.this.stopRecord();
                AppMethodBeat.m2505o(130916);
            }
        }

        private C10357b() {
        }

        /* synthetic */ C10357b(AppBrandCameraView appBrandCameraView, byte b) {
            this();
        }

        /* renamed from: a */
        static /* synthetic */ void m18059a(C10357b c10357b, int i, String str, String str2, String str3) {
            AppMethodBeat.m2504i(130926);
            c10357b.m18060d(i, str, str2, str3);
            AppMethodBeat.m2505o(130926);
        }

        public final void init() {
        }

        /* renamed from: q */
        public final void mo21835q(byte[] bArr, int i, int i2) {
            AppMethodBeat.m2504i(130917);
            if (AppBrandCameraView.this.hGu) {
                AppMethodBeat.m2505o(130917);
            } else {
                AppMethodBeat.m2505o(130917);
            }
        }

        public final void aDd() {
            AppMethodBeat.m2504i(130918);
            C4990ab.m7416i("MicroMsg.AppBrandCameraView", "takePicture.");
            if (AppBrandCameraView.this.hGE == null) {
                C4990ab.m7416i("MicroMsg.AppBrandCameraView", "recordView is null");
                AppMethodBeat.m2505o(130918);
            } else if (AppBrandCameraView.this.hGH == 2) {
                C4990ab.m7420w("MicroMsg.AppBrandCameraView", "takePicture is recording!!");
                AppMethodBeat.m2505o(130918);
            } else if (AppBrandCameraView.this.hGI || C5046bo.m7525az(AppBrandCameraView.this.hGJ) < 300) {
                C4990ab.m7416i("MicroMsg.AppBrandCameraView", "not the right time to take picture.");
                AppMethodBeat.m2505o(130918);
            } else if (AppBrandCameraView.this.hGM) {
                AppBrandCameraView.this.hGJ = C5046bo.m7588yz();
                AppBrandCameraView.this.hGI = true;
                AppBrandCameraView.this.hGH = 3;
                AppBrandCameraView.this.hGE.mo36648a(new C103581(), "on".equals(AppBrandCameraView.this.hGs));
                AppMethodBeat.m2505o(130918);
            } else {
                C4990ab.m7420w("MicroMsg.AppBrandCameraView", "takePicture err, isn't init done");
                AppBrandCameraView.m25618a(AppBrandCameraView.this, -1, null, "camera has not been initialized");
                AppMethodBeat.m2505o(130918);
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: a */
        public final boolean mo21830a(Bitmap bitmap, String str) {
            AppMethodBeat.m2504i(130919);
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
                    C5056d.m7625a(bitmap, i, CompressFormat.JPEG, str, true);
                    C4990ab.m7417i("MicroMsg.AppBrandCameraView", "bitmap filelen %s", Long.valueOf(C5730e.asZ(str)));
                    AppMethodBeat.m2505o(130919);
                    return true;
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.AppBrandCameraView", "error for saveBitmapToImage %s", e.getMessage());
                }
            }
            AppMethodBeat.m2505o(130919);
            return false;
        }

        public final void aDm() {
            int i;
            AppMethodBeat.m2504i(130920);
            C4990ab.m7416i("MicroMsg.AppBrandCameraView", "startRecord.");
            C10360a aDb = C10361a.hGl;
            if (!(aDb.hGi && aDb.hGj)) {
                C4990ab.m7416i("MicroMsg.AppBrandCameraMrg", "no all permission");
            }
            if (aDb.hGi && aDb.hGj) {
                i = 1;
            } else {
                i = 0;
            }
            if (i == 0) {
                Toast.makeText(AppBrandCameraView.this.mContext, C25738R.string.czz, 1).show();
                C4990ab.m7420w("MicroMsg.AppBrandCameraView", "no micro phone permission");
                m18058Q(-1, "permission");
                AppMethodBeat.m2505o(130920);
            } else if (AppBrandCameraView.this.hGH == 2) {
                C4990ab.m7420w("MicroMsg.AppBrandCameraView", "startRecord is recording!!");
                m18058Q(-1, "is recording");
                AppMethodBeat.m2505o(130920);
            } else if (!AppBrandCameraView.this.hGM) {
                C4990ab.m7420w("MicroMsg.AppBrandCameraView", "startRecord err, isn't init done");
                m18058Q(-1, "camera has not been initialized");
                AppMethodBeat.m2505o(130920);
            } else if (AppBrandCameraView.this.hGE.osY.mo36674EL()) {
                AppBrandCameraView.this.hGK = C5046bo.m7588yz();
                AppBrandCameraView.this.hGH = 2;
                m18058Q(0, "");
                AppBrandCameraView.m25637p(AppBrandCameraView.this);
                AppMethodBeat.m2505o(130920);
            } else {
                C4990ab.m7420w("MicroMsg.AppBrandCameraView", "startRecord fail !!");
                m18058Q(-1, "startRecord fail");
                AppMethodBeat.m2505o(130920);
            }
        }

        /* renamed from: Q */
        private void m18058Q(int i, String str) {
            AppMethodBeat.m2504i(130921);
            if (AppBrandCameraView.this.hGC != null) {
                AppBrandCameraView.this.hGC.mo21842Q(i, str);
            }
            AppMethodBeat.m2505o(130921);
        }

        public final void stopRecord() {
            AppMethodBeat.m2504i(130922);
            C4990ab.m7416i("MicroMsg.AppBrandCameraView", JsApiStopRecordVoice.NAME);
            if (AppBrandCameraView.this.hGE == null) {
                C4990ab.m7416i("MicroMsg.AppBrandCameraView", "recordView is null");
                m18060d(-1, "camera is null", null, null);
                AppMethodBeat.m2505o(130922);
            } else if (AppBrandCameraView.this.hGH != 2) {
                C4990ab.m7420w("MicroMsg.AppBrandCameraView", "stopRecord is not recording!!");
                m18060d(-1, "is not recording", null, null);
                AppMethodBeat.m2505o(130922);
            } else if (AppBrandCameraView.this.hGv) {
                C4990ab.m7416i("MicroMsg.AppBrandCameraView", "recordView is IsStopping");
                m18060d(-1, "is stopping", null, null);
                AppMethodBeat.m2505o(130922);
            } else {
                AppBrandCameraView.this.hGv = true;
                AppBrandCameraView.this.hGE.mo36649a(new C67732());
                AppMethodBeat.m2505o(130922);
            }
        }

        /* renamed from: d */
        private void m18060d(int i, String str, String str2, String str3) {
            AppMethodBeat.m2504i(130923);
            if (AppBrandCameraView.this.hGC != null) {
                AppBrandCameraView.this.hGC.mo21844d(i, str, C10357b.m18061g(AppBrandCameraView.this.hGm, str2), C10357b.m18061g(AppBrandCameraView.this.hGm, str3));
            }
            AppBrandCameraView.m25637p(AppBrandCameraView.this);
            AppMethodBeat.m2505o(130923);
        }

        public final void aDn() {
            AppMethodBeat.m2504i(130924);
            long az = C5046bo.m7525az(AppBrandCameraView.this.hGK);
            if (az < 1500) {
                C4990ab.m7417i("MicroMsg.AppBrandCameraView", "stopRecord in %d ms later", Long.valueOf(1500 - az));
                C5004al.m7442n(new C103593(), 1500 - az);
                AppMethodBeat.m2505o(130924);
                return;
            }
            stopRecord();
            AppMethodBeat.m2505o(130924);
        }

        /* renamed from: g */
        static String m18061g(C2241c c2241c, String str) {
            AppMethodBeat.m2504i(130925);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(130925);
                return str;
            }
            C19681j c19681j = new C19681j();
            if (c2241c.asE().mo5835a(new File(str), "", true, c19681j) == C45518j.OK) {
                String str2 = (String) c19681j.value;
                AppMethodBeat.m2505o(130925);
                return str2;
            }
            AppMethodBeat.m2505o(130925);
            return null;
        }

        public final void release() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView$4 */
    class C166504 implements C12536a {
        C166504() {
        }

        /* renamed from: q */
        public final void mo24462q(byte[] bArr, int i, int i2) {
            AppMethodBeat.m2504i(130912);
            if (AppBrandCameraView.this.hGp != null) {
                AppBrandCameraView.this.hGp.mo21835q(bArr, i, i2);
            }
            AppMethodBeat.m2505o(130912);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView$a */
    public interface C16651a {
        void aDd();

        void aDm();

        void aDn();

        void init();

        /* renamed from: q */
        void mo21835q(byte[] bArr, int i, int i2);

        void release();
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView$1 */
    static class C166521 implements C2251a {
        C166521() {
        }

        /* renamed from: cI */
        public final /* synthetic */ C33272e mo6131cI(Context context) {
            AppMethodBeat.m2504i(130909);
            AppBrandCameraView appBrandCameraView = new AppBrandCameraView(context);
            AppMethodBeat.m2505o(130909);
            return appBrandCameraView;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView$2 */
    class C166532 implements C21286d {
        C166532() {
        }

        public final void aDo() {
            AppMethodBeat.m2504i(130910);
            C4990ab.m7420w("MicroMsg.AppBrandCameraView", "InitErrorCallback");
            HashMap hashMap = new HashMap();
            hashMap.put("cameraId", Integer.valueOf(AppBrandCameraView.this.hGq));
            new C33275g().mo61032j(AppBrandCameraView.this.hGm).mo61028AM(new JSONObject(hashMap).toString()).aCj();
            AppMethodBeat.m2505o(130910);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView$3 */
    class C166543 implements C21285c {
        C166543() {
        }

        public final void aDp() {
            AppMethodBeat.m2504i(130911);
            AppBrandCameraView.this.hGM = true;
            C4990ab.m7416i("MicroMsg.AppBrandCameraView", "InitDoneCallback");
            C33274f c33274f = new C33274f();
            HashMap hashMap = new HashMap();
            hashMap.put("cameraId", Integer.valueOf(AppBrandCameraView.this.hGq));
            c33274f.mo61028AM(new JSONObject(hashMap).toString());
            AppBrandCameraView.this.hGm.mo6115b(c33274f);
            AppMethodBeat.m2505o(130911);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView$c */
    class C16655c implements C16651a, C19351a {
        private int duration;
        private C19350c hGQ;
        AtomicBoolean hGR;
        private int hGS;

        /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.camera.AppBrandCameraView$c$1 */
        class C166561 implements Runnable {
            C166561() {
            }

            public final void run() {
                AppMethodBeat.m2504i(130927);
                C16655c.this.hGR.set(false);
                AppMethodBeat.m2505o(130927);
            }
        }

        private C16655c() {
            AppMethodBeat.m2504i(130928);
            this.hGR = new AtomicBoolean(false);
            this.hGS = 200;
            this.duration = this.hGS;
            AppMethodBeat.m2505o(130928);
        }

        /* synthetic */ C16655c(AppBrandCameraView appBrandCameraView, byte b) {
            this();
        }

        public final void init() {
            AppMethodBeat.m2504i(130929);
            this.hGQ = new C26952d();
            this.hGQ.init();
            this.hGQ.hHx = this;
            AppBrandCameraView.this.hGH = 4;
            if (AppBrandCameraView.this.hGB > 0) {
                this.duration = 1000 / AppBrandCameraView.this.hGB;
            }
            AppMethodBeat.m2505o(130929);
        }

        /* renamed from: q */
        public final void mo21835q(byte[] bArr, int i, int i2) {
            AppMethodBeat.m2504i(130930);
            if (this.hGR.get()) {
                C4990ab.m7410d("MicroMsg.AppBrandCameraView", "[onFrameData] isScanPause, return");
                AppMethodBeat.m2505o(130930);
                return;
            }
            if (!(this.hGQ == null || AppBrandCameraView.this.hGE == null)) {
                this.hGQ.mo34514a(bArr, i, i2, AppBrandCameraView.this.hGA, AppBrandCameraView.this.hGE.getCameraRotation());
            }
            AppMethodBeat.m2505o(130930);
        }

        /* renamed from: b */
        public final void mo30633b(int i, String str, byte[] bArr) {
            AppMethodBeat.m2504i(130931);
            if (this.hGR.compareAndSet(false, true)) {
                C5004al.m7442n(new C166561(), (long) this.duration);
                C4990ab.m7411d("MicroMsg.AppBrandCameraView", "resultText:%s, resultType:%d", str, Integer.valueOf(i));
                switch (i) {
                    case 1:
                        C33276h.m54431a(AppBrandCameraView.this.hGm, AppBrandCameraView.this.getCameraId(), "qrcode", str, bArr);
                        AppMethodBeat.m2505o(130931);
                        return;
                    case 2:
                        C33276h.m54431a(AppBrandCameraView.this.hGm, AppBrandCameraView.this.getCameraId(), "barcode", str, bArr);
                        AppMethodBeat.m2505o(130931);
                        return;
                    default:
                        C4990ab.m7420w("MicroMsg.AppBrandCameraView", "resultType:%d is not support, ignore");
                        break;
                }
            }
            AppMethodBeat.m2505o(130931);
        }

        public final void aDd() {
            AppMethodBeat.m2504i(130932);
            C4990ab.m7412e("MicroMsg.AppBrandCameraView", "ScanCodeMode, takePicture err");
            AppMethodBeat.m2505o(130932);
        }

        public final void aDm() {
            AppMethodBeat.m2504i(130933);
            C4990ab.m7412e("MicroMsg.AppBrandCameraView", "ScanCodeMode, startRecord err");
            AppMethodBeat.m2505o(130933);
        }

        public final void aDn() {
            AppMethodBeat.m2504i(130934);
            C4990ab.m7412e("MicroMsg.AppBrandCameraView", "ScanCodeMode, safeStopRecord err");
            AppMethodBeat.m2505o(130934);
        }

        public final void release() {
            AppMethodBeat.m2504i(130935);
            if (this.hGQ != null) {
                this.hGQ.release();
            }
            AppMethodBeat.m2505o(130935);
        }
    }

    /* renamed from: p */
    static /* synthetic */ void m25637p(AppBrandCameraView appBrandCameraView) {
        AppMethodBeat.m2504i(130966);
        appBrandCameraView.aDj();
        AppMethodBeat.m2505o(130966);
    }

    /* renamed from: v */
    static /* synthetic */ void m25643v(AppBrandCameraView appBrandCameraView) {
        AppMethodBeat.m2504i(130967);
        appBrandCameraView.aDi();
        AppMethodBeat.m2505o(130967);
    }

    public static void aDc() {
        AppMethodBeat.m2504i(130936);
        C2247j.hHa = new C166521();
        AppMethodBeat.m2505o(130936);
    }

    public AppBrandCameraView(Context context) {
        super(context);
        AppMethodBeat.m2504i(130937);
        init(context);
        AppMethodBeat.m2505o(130937);
    }

    public AppBrandCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(130938);
        init(context);
        AppMethodBeat.m2505o(130938);
    }

    public AppBrandCameraView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(130939);
        init(context);
        AppMethodBeat.m2505o(130939);
    }

    public void setOperateCallBack(C10362c c10362c) {
        this.hGC = c10362c;
    }

    public void setOutPutCallBack(C26953b c26953b) {
        this.hGD = c26953b;
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(130940);
        this.mContext = context;
        LayoutInflater.from(context).inflate(2130968665, this);
        AppMethodBeat.m2505o(130940);
    }

    public final void initView() {
        AppMethodBeat.m2504i(130941);
        C4990ab.m7416i("MicroMsg.AppBrandCameraView", "initView");
        if (C10361a.hGl.aDa()) {
            aDi();
            aDh();
            aDe();
            aDf();
            AppMethodBeat.m2505o(130941);
            return;
        }
        AppMethodBeat.m2505o(130941);
    }

    public View getView() {
        return this;
    }

    public void setPage(C33303e c33303e) {
        this.hGm = c33303e;
    }

    public void setMode(String str) {
        this.hGn = str;
    }

    public void setFrameLimitSize(int i) {
        AppMethodBeat.m2504i(130942);
        C4990ab.m7417i("MicroMsg.AppBrandCameraView", "setFrameLimitSize:%d", Integer.valueOf(i));
        this.hGo = i;
        AppMethodBeat.m2505o(130942);
    }

    public void setAppId(String str) {
        this.mAppId = str;
    }

    /* renamed from: ai */
    public final void mo30612ai(String str, boolean z) {
        AppMethodBeat.m2504i(130943);
        if (C5046bo.isEqual(this.hGr, str)) {
            AppMethodBeat.m2505o(130943);
        } else if (C5046bo.isEqual(this.hGn, JsApiScanCode.NAME)) {
            AppMethodBeat.m2505o(130943);
        } else {
            this.hGr = str;
            if (!(z || this.hGE == null)) {
                this.hGE.osY.switchCamera();
            }
            AppMethodBeat.m2505o(130943);
        }
    }

    public void setCameraId(int i) {
        this.hGq = i;
    }

    public int getCameraId() {
        return this.hGq;
    }

    public void setFlash(String str) {
        AppMethodBeat.m2504i(130944);
        if (C5046bo.isEqual(this.hGs, str)) {
            AppMethodBeat.m2505o(130944);
            return;
        }
        this.hGs = str;
        AppMethodBeat.m2505o(130944);
    }

    public void setQuality(String str) {
        AppMethodBeat.m2504i(130945);
        if (C5046bo.isEqual(this.hGt, str)) {
            AppMethodBeat.m2505o(130945);
            return;
        }
        this.hGt = str;
        AppMethodBeat.m2505o(130945);
    }

    /* renamed from: da */
    public final boolean mo30613da(int i, int i2) {
        AppMethodBeat.m2504i(130946);
        if (this.hGw == i && this.hGx == i2) {
            AppMethodBeat.m2505o(130946);
            return false;
        }
        C4990ab.m7416i("MicroMsg.AppBrandCameraView", "setViewSize");
        this.hGw = i;
        this.hGx = i2;
        AppMethodBeat.m2505o(130946);
        return true;
    }

    public void setNeedOutput(boolean z) {
        this.hGu = z;
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(130949);
        if (this.hGL != null) {
            this.hGL.mo53797a(this.hGE);
        }
        release();
        AppMethodBeat.m2505o(130949);
    }

    public final void release() {
        AppMethodBeat.m2504i(130950);
        C4990ab.m7416i("MicroMsg.AppBrandCameraView", "release");
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
                AppMethodBeat.m2505o(130950);
            }
        }
        aDl();
    }

    public final void aDd() {
        AppMethodBeat.m2504i(130951);
        if (this.hGp != null) {
            this.hGp.aDd();
        }
        AppMethodBeat.m2505o(130951);
    }

    private void aDe() {
        AppMethodBeat.m2504i(130952);
        C4990ab.m7416i("MicroMsg.AppBrandCameraView", "initCamera.");
        if (!C10361a.hGl.aDa()) {
            Toast.makeText(this.mContext, C25738R.string.czz, 1).show();
            C4990ab.m7420w("MicroMsg.AppBrandCameraView", "no permission");
            AppMethodBeat.m2505o(130952);
        } else if (this.hGE != null) {
            C4990ab.m7416i("MicroMsg.AppBrandCameraView", "initCamera recordView not null.");
            AppMethodBeat.m2505o(130952);
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
            this.hGE.setInitErrorCallback(new C166532());
            this.hGE.setInitDoneCallback(new C166543());
            this.hGE.osY.startPreview();
            this.hGE.osY.aso();
            this.hGH = 1;
            AppMethodBeat.m2505o(130952);
        }
    }

    public final void aDf() {
        AppMethodBeat.m2504i(130953);
        if (this.hGE == null) {
            C4990ab.m7416i("MicroMsg.AppBrandCameraView", "recordView is null");
            AppMethodBeat.m2505o(130953);
            return;
        }
        aDk();
        aDj();
        AppMethodBeat.m2505o(130953);
    }

    /* renamed from: n */
    public final void mo30617n(C2241c c2241c) {
        AppMethodBeat.m2504i(130954);
        if (this.hGC == null) {
            AppMethodBeat.m2505o(130954);
        } else if (this.hGE == null) {
            C4990ab.m7420w("MicroMsg.AppBrandCameraView", "listenFrameChange recordView null");
            this.hGC.mo21845g("camera illegal state", -1, -1, -1);
            AppMethodBeat.m2505o(130954);
        } else {
            int i;
            if (this.hGL == null) {
                this.hGL = new C33271d(c2241c);
            }
            int i2 = this.hGE.getDrawSizePoint().x;
            int i3 = this.hGE.getDrawSizePoint().y;
            C21287f c21287f = this.hGL;
            MMSightRecordView mMSightRecordView = this.hGE;
            if (mMSightRecordView == null) {
                C4990ab.m7420w("MicroMsg.FrameDataCallbackHelper", "listenFrameChange recordView null");
                i = -1;
            } else {
                if (c21287f.hGW != C8415j.INVALID_ID) {
                    C4990ab.m7417i("MicroMsg.FrameDataCallbackHelper", "listenFrameChange destroy last one bufferId:%d", Integer.valueOf(c21287f.hGW));
                    c21287f.hGU.mo30584oQ(c21287f.hGW);
                }
                c21287f.hGW = c21287f.hGU.mo30586oS((i2 * i3) * 4);
                C4990ab.m7417i("MicroMsg.FrameDataCallbackHelper", "listenFrameChange bufferId:%d height:%d width:%d", Integer.valueOf(c21287f.hGW), Integer.valueOf(i3), Integer.valueOf(i2));
                c21287f.hGV = true;
                mMSightRecordView.mo36650a(c21287f.hGU.mo30585oR(c21287f.hGW), c21287f);
                i = c21287f.hGW;
            }
            if (i < 0) {
                this.hGC.mo21845g("camera illegal state", -1, -1, -1);
                AppMethodBeat.m2505o(130954);
                return;
            }
            this.hGC.mo21845g(null, i, i2, i3);
            AppMethodBeat.m2505o(130954);
        }
    }

    public final void aDg() {
        AppMethodBeat.m2504i(130955);
        if (this.hGC == null) {
            AppMethodBeat.m2505o(130955);
        } else if (this.hGL == null) {
            AppMethodBeat.m2505o(130955);
        } else {
            this.hGL.mo53797a(this.hGE);
            this.hGL = null;
            AppMethodBeat.m2505o(130955);
        }
    }

    private void aDh() {
        AppMethodBeat.m2504i(130956);
        this.fcU = C6457e.euR + String.format("%s%d.%s", new Object[]{"capture", Long.valueOf(System.currentTimeMillis()), "jpg"});
        AppMethodBeat.m2505o(130956);
    }

    private void aDi() {
        AppMethodBeat.m2504i(130957);
        String str = "MicroMsg_" + System.currentTimeMillis();
        this.hGF = C6457e.euR + str + VideoMaterialUtil.MP4_SUFFIX;
        this.hGG = C6457e.euR + str + ".jpeg";
        if (this.hGE != null) {
            this.hGE.setVideoFilePath(this.hGF);
        }
        AppMethodBeat.m2505o(130957);
    }

    private void aDj() {
        AppMethodBeat.m2504i(130958);
        if (this.hGE == null || this.hGs == null) {
            AppMethodBeat.m2505o(130958);
        } else if (this.hGs.equals("auto")) {
            this.hGE.setFlashMode(3);
            AppMethodBeat.m2505o(130958);
        } else if (this.hGs.equals("torch")) {
            this.hGE.setFlashMode(1);
            AppMethodBeat.m2505o(130958);
        } else {
            if (this.hGs.equals("on")) {
                if (this.hGH == 2 || this.hGH == 4 || !this.hGs.equals("on")) {
                    this.hGE.setFlashMode(1);
                    AppMethodBeat.m2505o(130958);
                    return;
                }
            } else if (this.hGs.equals("torch")) {
                this.hGE.setFlashMode(1);
                AppMethodBeat.m2505o(130958);
                return;
            }
            this.hGE.setFlashMode(2);
            AppMethodBeat.m2505o(130958);
        }
    }

    private void aDk() {
        AppMethodBeat.m2504i(130959);
        C4990ab.m7417i("MicroMsg.AppBrandCameraView", "setCameraMode mode:%s", this.hGn);
        aDl();
        if (C5046bo.isNullOrNil(this.hGn) || !this.hGn.equals(JsApiScanCode.NAME)) {
            this.hGp = new C10357b(this, (byte) 0);
        } else {
            this.hGp = new C16655c(this, (byte) 0);
        }
        this.hGp.init();
        AppMethodBeat.m2505o(130959);
    }

    private void aDl() {
        AppMethodBeat.m2504i(130960);
        if (this.hGp != null) {
            this.hGp.release();
            this.hGp = null;
        }
        AppMethodBeat.m2505o(130960);
    }

    public void setScanFreq(int i) {
        AppMethodBeat.m2504i(130961);
        C4990ab.m7417i("MicroMsg.AppBrandCameraView", "scanFreq:%d", Integer.valueOf(i));
        if (i <= 0) {
            C4990ab.m7412e("MicroMsg.AppBrandCameraView", "scanFreq is err");
            AppMethodBeat.m2505o(130961);
            return;
        }
        this.hGB = i;
        AppMethodBeat.m2505o(130961);
    }

    /* renamed from: w */
    public final void mo30630w(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(130962);
        C4990ab.m7417i("MicroMsg.AppBrandCameraView", "x:%d, y:%d, w:%d, h:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        if (i3 <= 0 || i4 <= 0) {
            AppMethodBeat.m2505o(130962);
            return;
        }
        this.hGA = new Rect(i, i2, i + i3, i2 + i4);
        AppMethodBeat.m2505o(130962);
    }

    public final void aDm() {
        AppMethodBeat.m2504i(130963);
        if (this.hGp != null) {
            this.hGp.aDm();
        }
        AppMethodBeat.m2505o(130963);
    }

    public final void aDn() {
        AppMethodBeat.m2504i(130964);
        if (this.hGp != null) {
            this.hGp.aDn();
        }
        AppMethodBeat.m2505o(130964);
    }

    /* renamed from: wW */
    public final void mo21857wW() {
        HashMap hashMap;
        AppMethodBeat.m2504i(130947);
        C4990ab.m7416i("MicroMsg.AppBrandCameraView", "onUIPause");
        if (this.hGH == 2) {
            C4990ab.m7410d("MicroMsg.AppBrandCameraView", "onStopRecord fromOnPause");
            hashMap = new HashMap();
            hashMap.put("cameraId", Integer.valueOf(this.hGq));
            hashMap.put("errMsg", "stop on record");
            new C33277k().mo61032j(this.hGm).mo61028AM(new JSONObject(hashMap).toString()).aCj();
        }
        if (this.hGE != null) {
            Bitmap currentFramePicture = this.hGE.getCurrentFramePicture();
            if (currentFramePicture != null) {
                this.cAw.setImageBitmap(currentFramePicture);
            }
        }
        if (this.hGL != null) {
            C33271d c33271d = this.hGL;
            MMSightRecordView mMSightRecordView = this.hGE;
            C4990ab.m7417i("MicroMsg.FrameDataCallbackHelper", "onUIPause mNeedCallback:%b", Boolean.valueOf(c33271d.hGV));
            if (mMSightRecordView == null) {
                C4990ab.m7420w("MicroMsg.FrameDataCallbackHelper", "onUIPause recordView null");
            } else {
                mMSightRecordView.mo36650a(null, null);
            }
        }
        release();
        hashMap = new HashMap();
        hashMap.put("cameraId", Integer.valueOf(getCameraId()));
        new C2246i().mo61032j(this.hGm).mo61028AM(new JSONObject(hashMap).toString()).aCj();
        AppMethodBeat.m2505o(130947);
    }

    /* renamed from: wU */
    public final void mo6095wU() {
        AppMethodBeat.m2504i(130948);
        C4990ab.m7416i("MicroMsg.AppBrandCameraView", "onUIResume");
        synchronized (AppBrandCameraView.class) {
            try {
                aDe();
                aDk();
                aDj();
                if (this.hGL != null) {
                    C21287f c21287f = this.hGL;
                    MMSightRecordView mMSightRecordView = this.hGE;
                    C4990ab.m7417i("MicroMsg.FrameDataCallbackHelper", "onUIResume mNeedCallback:%b", Boolean.valueOf(c21287f.hGV));
                    if (c21287f.hGV) {
                        if (mMSightRecordView == null) {
                            C4990ab.m7420w("MicroMsg.FrameDataCallbackHelper", "onUIResume recordView null");
                        } else if (c21287f.hGW == C8415j.INVALID_ID) {
                            C4990ab.m7420w("MicroMsg.FrameDataCallbackHelper", "onUIResume invalid mCurrentSharedBufferId");
                        } else if (c21287f.hGU == null) {
                            C4990ab.m7420w("MicroMsg.FrameDataCallbackHelper", "onUIResume mSharedBufferAddon null");
                        } else {
                            mMSightRecordView.mo36650a(c21287f.hGU.mo30585oR(c21287f.hGW), c21287f);
                        }
                    }
                }
            } finally {
                AppMethodBeat.m2505o(130948);
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m25618a(AppBrandCameraView appBrandCameraView, int i, String str, String str2) {
        AppMethodBeat.m2504i(130965);
        C4990ab.m7417i("MicroMsg.AppBrandCameraView", "onTakePhoto.ret:%d, path:%s, errMsg:%s", Integer.valueOf(i), str, str2);
        if (appBrandCameraView.hGC != null) {
            appBrandCameraView.hGC.mo21843a(i, str, str2, appBrandCameraView.hGy, appBrandCameraView.hGz);
        }
        appBrandCameraView.hGI = false;
        appBrandCameraView.aDh();
        appBrandCameraView.hGH = 1;
        AppMethodBeat.m2505o(130965);
    }
}
