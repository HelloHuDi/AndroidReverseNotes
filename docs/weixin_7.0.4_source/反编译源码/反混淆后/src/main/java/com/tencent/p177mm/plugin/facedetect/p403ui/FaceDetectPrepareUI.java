package com.tencent.p177mm.plugin.facedetect.p403ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.support.p057v4.app.C6184a.C0315a;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMFragmentActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.jsapi.C27141z;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiResumeDownloadTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiWriteCommData;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskStraight;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiGetInstallState;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.p299b.C42476h;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C38317l;
import com.tencent.p177mm.plugin.facedetect.model.C27932e;
import com.tencent.p177mm.plugin.facedetect.model.C34097l;
import com.tencent.p177mm.plugin.facedetect.model.C43036p;
import com.tencent.p177mm.plugin.facedetect.model.FaceContextData;
import com.tencent.p177mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.p177mm.plugin.facedetect.p400c.C11795f;
import com.tencent.p177mm.plugin.facedetect.p400c.C34094b;
import com.tencent.p177mm.plugin.facedetect.p400c.C39010a;
import com.tencent.p177mm.plugin.facedetect.p403ui.FaceTutorial.C20659a;
import com.tencent.p177mm.plugin.facedetect.p966b.C27918p;
import com.tencent.p177mm.plugin.facedetect.p966b.C39007d;
import com.tencent.p177mm.plugin.facedetect.p966b.C45915c;
import com.tencent.p177mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.p177mm.plugin.facedetectlight.Utils.C43050a;
import com.tencent.p177mm.plugin.facedetectlight.Utils.C43050a.C3062b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.wcdb.FileUtils;
import com.tencent.wxmm.v2helper;
import java.lang.ref.WeakReference;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI */
public class FaceDetectPrepareUI extends MMFragmentActivity implements C0315a, C11795f {
    private boolean eTM = false;
    private boolean eVT = false;
    private String edV;
    private String lSK = null;
    private float lSM;
    private int lSf;
    private C39007d lSg = null;
    private int lSq;
    private long lTH;
    private C39010a lWT = null;
    private C34109a lWU = null;
    private FaceTutorial lWV = null;
    private boolean lWW;
    private byte[] lWX;
    private boolean lWY = false;
    private boolean lWZ = false;
    private int lWs;
    private C34105b lXa;
    private boolean lXb = false;
    private boolean lXc = false;
    private String lXd = null;
    private long lXe = -1;
    private Messenger lXf = null;
    private C39023a lXg = null;
    private int lXh = -1;
    private boolean lXi = false;
    private C43050a lXj;
    private RelativeLayout lXk;
    private boolean lXl = false;
    private int lXm = -1;
    private boolean lXn = false;
    private float lXo = 0.0f;
    private String mAppId;

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI$16 */
    class C2064316 implements Runnable {
        C2064316() {
        }

        public final void run() {
            AppMethodBeat.m2504i(v2helper.EMethodOutputVolumeGainEnable);
            final Bitmap Lr = C43036p.m76425Lr(FaceDetectPrepareUI.this.edV);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(v2helper.EMethodSetPlayerPreCorrectCofOff);
                    FaceDetectPrepareUI.this.lWU.mo23623M(Lr);
                    AppMethodBeat.m2505o(v2helper.EMethodSetPlayerPreCorrectCofOff);
                }
            });
            AppMethodBeat.m2505o(v2helper.EMethodOutputVolumeGainEnable);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI$15 */
    class C2793515 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI$15$1 */
        class C30431 implements OnClickListener {
            C30431() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(418);
                FaceDetectPrepareUI.m76447a(FaceDetectPrepareUI.this, 90003, "user cancel in init");
                AppMethodBeat.m2505o(418);
            }
        }

        C2793515() {
        }

        public final void run() {
            AppMethodBeat.m2504i(v2helper.EMethodSetPlayerPreCorrectCofOn);
            final Bitmap Lr = C43036p.m76425Lr(FaceDetectPrepareUI.this.edV);
            final C30431 c30431 = new C30431();
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(419);
                    C3048c a = C34109a.m55906a(FaceDetectPrepareUI.this, c30431);
                    a.lYE = Lr;
                    FaceDetectPrepareUI.this.mo23590a(false, false, a);
                    AppMethodBeat.m2505o(419);
                }
            });
            AppMethodBeat.m2505o(v2helper.EMethodSetPlayerPreCorrectCofOn);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI$17 */
    class C2793617 implements OnClickListener {
        C2793617() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(v2helper.EMethodSetNgStrength);
            FaceDetectPrepareUI.m76447a(FaceDetectPrepareUI.this, 90005, "user cancel in uploading");
            AppMethodBeat.m2505o(v2helper.EMethodSetNgStrength);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI$11 */
    class C3410211 implements C43041c {
        C3410211() {
        }

        /* renamed from: p */
        public final void mo54657p(int i, int i2, String str) {
            AppMethodBeat.m2504i(414);
            if (FaceDetectPrepareUI.this.lWT != null) {
                FaceDetectPrepareUI.this.lWT.mo7229c(i, i2, str, null);
            }
            AppMethodBeat.m2505o(414);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI$12 */
    class C3410312 implements C43041c {
        C3410312() {
        }

        /* renamed from: p */
        public final void mo54657p(int i, int i2, String str) {
            AppMethodBeat.m2504i(415);
            if (FaceDetectPrepareUI.this.lWT != null) {
                FaceDetectPrepareUI.this.lWT.mo7229c(i, i2, str, null);
            }
            AppMethodBeat.m2505o(415);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI$b */
    class C34105b {
        String aIm;
        int errCode;
        int errType;
        Bundle extras;

        private C34105b() {
        }

        /* synthetic */ C34105b(FaceDetectPrepareUI faceDetectPrepareUI, byte b) {
            this();
        }

        /* Access modifiers changed, original: final */
        /* renamed from: e */
        public final void mo54659e(int i, int i2, String str, Bundle bundle) {
            this.errType = i;
            this.errCode = i2;
            this.aIm = str;
            this.extras = bundle;
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI$14 */
    class C3901914 implements C43041c {
        C3901914() {
        }

        /* renamed from: p */
        public final void mo54657p(int i, int i2, String str) {
            AppMethodBeat.m2504i(417);
            if (FaceDetectPrepareUI.this.lWT != null) {
                FaceDetectPrepareUI.this.lWT.mo7229c(i, i2, str, null);
            }
            AppMethodBeat.m2505o(417);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI$6 */
    class C390206 implements C45915c {
        C390206() {
        }

        /* renamed from: e */
        public final void mo61925e(long j, byte[] bArr) {
            AppMethodBeat.m2504i(405);
            C4990ab.m7417i("MicroMsg.FaceDetectPrepareUI", "alvinluo onGetConfigSuccess, bioId: %d, isCancel: %b", Long.valueOf(j), Boolean.valueOf(FaceDetectPrepareUI.this.eVT));
            if (FaceDetectPrepareUI.this.eVT) {
                AppMethodBeat.m2505o(405);
                return;
            }
            FaceDetectPrepareUI.this.lTH = j;
            FaceDetectPrepareUI.this.lWX = bArr;
            FaceDetectPrepareUI.m76449a(FaceDetectPrepareUI.this, j, bArr);
            AppMethodBeat.m2505o(405);
        }

        /* renamed from: aw */
        public final void mo61924aw(int i, String str) {
            AppMethodBeat.m2504i(406);
            C4990ab.m7417i("MicroMsg.FaceDetectPrepareUI", "alvinluo onGetConfigFailed, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(90015), str);
            FaceDetectPrepareUI.m76446a(FaceDetectPrepareUI.this, FaceDetectPrepareUI.m76464vr(i), 90015, str, FaceDetectPrepareUI.this.getString(C25738R.string.bkk));
            AppMethodBeat.m2505o(406);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI$a */
    static class C39023a extends Handler {
        private WeakReference<FaceDetectPrepareUI> lWJ;

        /* synthetic */ C39023a(FaceDetectPrepareUI faceDetectPrepareUI, byte b) {
            this(faceDetectPrepareUI);
        }

        private C39023a(FaceDetectPrepareUI faceDetectPrepareUI) {
            AppMethodBeat.m2504i(v2helper.EMethodSetSpkEnhance);
            this.lWJ = null;
            this.lWJ = new WeakReference(faceDetectPrepareUI);
            AppMethodBeat.m2505o(v2helper.EMethodSetSpkEnhance);
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(425);
            C4990ab.m7417i("MicroMsg.FaceDetectPrepareUI", "alvinluo client msg.what: %d", Integer.valueOf(message.what));
            if (!(this.lWJ == null || this.lWJ.get() == null)) {
                switch (message.what) {
                    case 0:
                        FaceDetectPrepareUI.m76448a((FaceDetectPrepareUI) this.lWJ.get(), message);
                        AppMethodBeat.m2505o(425);
                        return;
                    case 1:
                        FaceDetectPrepareUI.m76453b((FaceDetectPrepareUI) this.lWJ.get(), message);
                        AppMethodBeat.m2505o(425);
                        return;
                    case 6:
                        FaceDetectPrepareUI.m76455c((FaceDetectPrepareUI) this.lWJ.get(), message);
                        break;
                }
            }
            AppMethodBeat.m2505o(425);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI$1 */
    class C430391 implements C20659a {
        C430391() {
        }

        public final void onCancel() {
            AppMethodBeat.m2504i(399);
            C4990ab.m7416i("MicroMsg.FaceDetectPrepareUI", "hy: user cancel in tutorial");
            FaceDetectPrepareUI.m76447a(FaceDetectPrepareUI.this, 90002, "user cancel in tutorial");
            AppMethodBeat.m2505o(399);
        }

        public final void btp() {
            AppMethodBeat.m2504i(400);
            C4990ab.m7416i("MicroMsg.FaceDetectPrepareUI", "hy: tutorial confirmed. start");
            FaceDetectPrepareUI.m76445a(FaceDetectPrepareUI.this);
            AppMethodBeat.m2505o(400);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI$7 */
    class C430407 implements C39007d {
        private double lXt = 0.0d;

        C430407() {
        }

        /* renamed from: w */
        public final void mo61905w(double d) {
            AppMethodBeat.m2504i(407);
            C4990ab.m7417i("MicroMsg.FaceDetectPrepareUI", "hy: reg on process : %f", Double.valueOf(d));
            this.lXt = 100.0d * d;
            if (FaceDetectPrepareUI.this.lWT != null) {
                FaceDetectPrepareUI.this.lWT;
            }
            AppMethodBeat.m2505o(407);
        }

        /* renamed from: a */
        public final void mo61902a(int i, int i2, int i3, String str) {
            AppMethodBeat.m2504i(408);
            C4990ab.m7417i("MicroMsg.FaceDetectPrepareUI", "onError scene: %d, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
            FaceDetectPrepareUI.m76446a(FaceDetectPrepareUI.this, i2, i3, str, FaceDetectPrepareUI.this.getString(C25738R.string.er5));
            AppMethodBeat.m2505o(408);
        }

        /* renamed from: n */
        public final void mo61904n(String str, Bundle bundle) {
            AppMethodBeat.m2504i(409);
            C4990ab.m7416i("MicroMsg.FaceDetectPrepareUI", "alvinluo onUploadEnd");
            int vr = FaceDetectPrepareUI.m76464vr(0);
            if (vr != 0) {
                FaceDetectPrepareUI.this.mo23594d(vr, 0, str, bundle);
            }
            if (FaceDetectPrepareUI.this.lWT != null) {
                FaceDetectPrepareUI.this.lWT.mo61912b(vr, str, bundle);
            }
            AppMethodBeat.m2505o(409);
        }

        /* renamed from: g */
        public final void mo61903g(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(410);
            C4990ab.m7417i("MicroMsg.FaceDetectPrepareUI", "alvinluo onVerifyEnd sceneType: %d, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(c1207m.getType()), Integer.valueOf(i), Integer.valueOf(i2), str);
            int vr = FaceDetectPrepareUI.m76464vr(i);
            if (!(vr == 0 && i2 == 0)) {
                FaceDetectPrepareUI.this.mo23594d(vr, i2, str, null);
            }
            if (FaceDetectPrepareUI.this.lWT != null) {
                FaceDetectPrepareUI.this.lWT.mo7231g(vr, i2, str, c1207m);
            }
            AppMethodBeat.m2505o(410);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI$c */
    interface C43041c {
        /* renamed from: p */
        void mo54657p(int i, int i2, String str);
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI$10 */
    class C4304210 implements C43041c {
        C4304210() {
        }

        /* renamed from: p */
        public final void mo54657p(int i, int i2, String str) {
            AppMethodBeat.m2504i(413);
            if (FaceDetectPrepareUI.this.lWT != null) {
                FaceDetectPrepareUI.this.lWT.mo7229c(i, i2, str, FaceDetectPrepareUI.this.lXa.extras);
            }
            AppMethodBeat.m2505o(413);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI$13 */
    class C4304313 implements C43041c {
        C4304313() {
        }

        /* renamed from: p */
        public final void mo54657p(int i, int i2, String str) {
            AppMethodBeat.m2504i(416);
            if (FaceDetectPrepareUI.this.lWT != null) {
                FaceDetectPrepareUI.this.lWT.mo7229c(i, i2, str, null);
            }
            AppMethodBeat.m2505o(416);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: a */
    static /* synthetic */ void m76445a(FaceDetectPrepareUI faceDetectPrepareUI) {
        AppMethodBeat.m2504i(455);
        faceDetectPrepareUI.btl();
        AppMethodBeat.m2505o(455);
    }

    /* renamed from: a */
    static /* synthetic */ void m76446a(FaceDetectPrepareUI faceDetectPrepareUI, int i, int i2, String str, String str2) {
        AppMethodBeat.m2504i(457);
        faceDetectPrepareUI.m76457d(i, i2, str, str2);
        AppMethodBeat.m2505o(457);
    }

    /* renamed from: vr */
    static /* synthetic */ int m76464vr(int i) {
        if (i == 1 || i == 2) {
            return 3;
        }
        if (i == 4) {
            return 2;
        }
        if (i != 0) {
            return 4;
        }
        return i;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(v2helper.EMethodSetAgcRxOn);
        super.onCreate(bundle);
        setContentView(2130969471);
        this.lXk = (RelativeLayout) findViewById(2131823789);
        this.lXk.setVisibility(4);
        getWindow().addFlags(2097280);
        this.mAppId = getIntent().getStringExtra("k_app_id");
        this.edV = getIntent().getStringExtra("k_user_name");
        this.lSf = getIntent().getIntExtra("k_server_scene", -1);
        this.lWW = getIntent().getBooleanExtra("k_need_signature", false);
        boolean z = C27932e.bsu() || getIntent().getBooleanExtra("key_is_need_video", false);
        this.lXb = z;
        this.lSK = getIntent().getStringExtra("key_feedback_url");
        this.lXd = getIntent().getStringExtra("business_tips");
        this.lWs = getIntent().getIntExtra("check_alive_type_response", -1);
        if (this.lWs == -1) {
            this.lWs = getIntent().getIntExtra("check_alive_type", 0);
        }
        this.lSM = getIntent().getFloatExtra("mLight_threshold", -1.0f);
        this.lXj = C3062b.mdr;
        this.lXj.mo68582dM(this);
        C4990ab.m7416i("MicroMsg.FaceDetectPrepareUI", "mIsNeedVideo： " + this.lXb);
        C4990ab.m7416i("MicroMsg.FaceDetectPrepareUI", "check_alive_type is " + this.lWs);
        C4990ab.m7416i("MicroMsg.FaceDetectPrepareUI", "mLight_threshold is " + this.lSM);
        C4990ab.m7416i("MicroMsg.FaceDetectPrepareUI", "mChechLiveFlag is " + this.lSq);
        this.lXg = new C39023a(this, (byte) 0);
        this.lXf = new Messenger(this.lXg);
        Intent intent = new Intent(this, FaceDetectProcessService.class);
        intent.putExtra("k_messenger", this.lXf);
        C25985d.m41477j(intent, "tools");
        FaceContextData.m85187a(new FaceContextData());
        C43036p.m76429N(this);
        Bundle extras = getIntent().getExtras();
        float btS = this.lXj.btS();
        this.lXo = btS;
        if (extras != null) {
            extras.putFloat("key_current_light", btS);
            extras.putBoolean("key_upload_video", this.lXb);
        }
        C34094b c34094b = C34094b.lTj;
        this.lWT = C34094b.m55881a(this, this, this.lSf, this.lSq, extras);
        if (this.lWT == null) {
            aDo();
        } else {
            this.lWT.mo61908a(new C390206());
            this.lSg = new C430407();
            this.lWT.mo61909a(this.lSg);
        }
        if (this.lXa != null) {
            C34105b c34105b = this.lXa;
            c34105b.errType = -1;
            c34105b.errCode = -1;
            c34105b.aIm = "";
            if (c34105b.extras != null) {
                c34105b.extras.clear();
            }
        }
        this.lWY = false;
        this.lXh = 1;
        btm();
        if (C43036p.m76428M(this)) {
            C4990ab.m7416i("MicroMsg.FaceDetectPrepareUI", "alvinluo checkFacePermissionAnd Request true and do init ");
            btj();
        } else {
            C4990ab.m7416i("MicroMsg.FaceDetectPrepareUI", "hy: no camera permission. request permission");
        }
        if (this.lXb) {
            extras = new Bundle();
            extras.putBoolean("key_is_need_video", this.lXb);
            m76463m(4, extras);
        }
        AppMethodBeat.m2505o(v2helper.EMethodSetAgcRxOn);
    }

    /* renamed from: m */
    private void m76463m(int i, Bundle bundle) {
        AppMethodBeat.m2504i(v2helper.EMethodPcMicLevel);
        String str = "MicroMsg.FaceDetectPrepareUI";
        String str2 = "hy: sending msg: cmd: %d, data: %s";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = bundle != null ? bundle.toString() : BuildConfig.COMMAND;
        C4990ab.m7417i(str, str2, objArr);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putInt("k_cmd", i);
        Intent intent = new Intent(this, FaceDetectProcessService.class);
        intent.putExtras(bundle);
        C25985d.m41477j(intent, "tools");
        AppMethodBeat.m2505o(v2helper.EMethodPcMicLevel);
    }

    private void btj() {
        AppMethodBeat.m2504i(v2helper.EMethodSetIosMicAbCheckOn);
        if (this.lWT != null) {
            this.lWT.bsk();
        }
        AppMethodBeat.m2505o(v2helper.EMethodSetIosMicAbCheckOn);
    }

    public final void bsk() {
        int i;
        AppMethodBeat.m2504i(v2helper.EMethodSetIosMicAbCheckOff);
        C4990ab.m7416i("MicroMsg.FaceDetectPrepareUI", "alvinluo startFaceDetect");
        C4990ab.m7416i("MicroMsg.FaceDetectPrepareUI", "alvinluo preparing");
        if (this.lWT != null) {
            String string = getIntent().getExtras().getString("k_ticket");
            if (!C5046bo.isNullOrNil(string)) {
                C4990ab.m7416i("MicroMsg.FaceDetectBaseController", "hy: has prepared ticket. force set");
                C27918p.m44395Lp(string);
            }
        }
        C4990ab.m7417i("MicroMsg.FaceDetectPrepareUI", "carson init jumper: %b", Boolean.valueOf(this.lXl));
        if (!this.lXl) {
            C4990ab.m7417i("MicroMsg.FaceDetectPrepareUI", "hy: start show jumper: %b", Boolean.TRUE);
            this.lXe = C5046bo.m7588yz();
            C7305d.post(new C2793515(), "face_prepareInit");
        }
        btk();
        switch (this.lXm) {
            case 0:
                i = 1;
                break;
            case 1:
                i = 2;
                break;
            default:
                i = 1;
                break;
        }
        if (this.lSf == 0 || this.lSf == 1 || this.lSf == 3 || this.lSf == 4) {
            i = 1;
        }
        this.lSq = i;
        if (this.lWT != null) {
            this.lWT.lTf = this.lSq;
            this.lWT.bsj();
        }
        this.lXi = true;
        AppMethodBeat.m2505o(v2helper.EMethodSetIosMicAbCheckOff);
    }

    private void btk() {
        AppMethodBeat.m2504i(430);
        switch (this.lWs) {
            case 0:
                this.lXm = 0;
                FaceDetectReporter.bsJ().lUv = 4;
                AppMethodBeat.m2505o(430);
                return;
            case 1:
                this.lXm = 1;
                FaceDetectReporter.bsJ().lUv = 6;
                AppMethodBeat.m2505o(430);
                return;
            case 2:
                float btS = this.lXj.btS();
                FaceDetectReporter.bsJ().lUw = Math.round(btS);
                C4990ab.m7416i("MicroMsg.FaceDetectPrepareUI", "curLux is : ".concat(String.valueOf(btS)));
                C4990ab.m7416i("MicroMsg.FaceDetectPrepareUI", "Light threshold is : " + this.lSM);
                if (btS < this.lSM) {
                    this.lXj.stop();
                    this.lXm = 1;
                    FaceDetectReporter.bsJ().lUv = 6;
                    AppMethodBeat.m2505o(430);
                    return;
                }
                this.lXm = 0;
                FaceDetectReporter.bsJ().lUv = 4;
                AppMethodBeat.m2505o(430);
                return;
            default:
                this.lXm = 0;
                AppMethodBeat.m2505o(430);
                return;
        }
    }

    private void btl() {
        AppMethodBeat.m2504i(431);
        this.lXh = 2;
        if (this.lWT != null) {
            this.lWT.mo61917vg(0);
        }
        Intent intent = new Intent(this, FaceDetectUI.class);
        intent.putExtra("k_user_name", this.edV);
        intent.putExtra("k_server_scene", this.lSf);
        intent.putExtra("k_need_signature", this.lWW);
        intent.putExtra("k_bio_id", String.valueOf(this.lTH));
        intent.putExtra("k_bio_config", this.lWX);
        intent.putExtra("business_tips", this.lXd);
        C4990ab.m7416i("MicroMsg.FaceDetectPrepareUI", "carson logic ");
        C4990ab.m7416i("MicroMsg.FaceDetectPrepareUI", "Config is " + this.lWX);
        C4990ab.m7416i("MicroMsg.FaceDetectPrepareUI", "Carson bioID is " + this.lTH + "  string：" + String.valueOf(this.lTH));
        C4990ab.m7419v("MicroMsg.FaceDetectPrepareUI", "alvinluo FaceDetectReporter info: %s", Long.valueOf(FaceDetectReporter.bsJ().hbj));
        Bundle bundle = new Bundle();
        bundle.putParcelable("key_parcelable_reporter", FaceDetectReporter.bsJ());
        intent.putExtra("key_reporter_bundle", bundle);
        if (this.lWU != null) {
            this.lWU.resetAll();
        }
        startActivityForResult(intent, 1);
        AppMethodBeat.m2505o(431);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        boolean z = false;
        AppMethodBeat.m2504i(v2helper.EMethodSetSendToNetworkOn);
        C4990ab.m7417i("MicroMsg.FaceDetectPrepareUI", "alvinluo onActivityResult requestCode: %d, resultCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
        FaceDetectReporter faceDetectReporter;
        int intExtra;
        int intExtra2;
        String stringExtra;
        C39010a c39010a;
        String stringExtra2;
        if (i == 2) {
            this.lXh = 1;
            this.lXk.setVisibility(0);
            if (intent == null) {
                C4990ab.m7412e("MicroMsg.FaceDetectPrepareUI", "carson onActivityResult data is null");
                m76444a(4, 90018, "system error", getString(C25738R.string.bkz), false, new C3410211());
                AppMethodBeat.m2505o(v2helper.EMethodSetSendToNetworkOn);
                return;
            }
            int i3;
            faceDetectReporter = (FaceDetectReporter) intent.getParcelableExtra("key_parcelable_reporter");
            if (faceDetectReporter != null) {
                FaceDetectReporter.bsJ().mo54648a(faceDetectReporter);
            }
            FaceDetectReporter bsJ = FaceDetectReporter.bsJ();
            if (this.lXb) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            bsJ.lUx = i3;
            FaceDetectReporter.bsJ().lUw = Math.round(this.lXo);
            intExtra = intent.getIntExtra("err_type", -1);
            intExtra2 = intent.getIntExtra("err_code", -1);
            stringExtra = intent.getStringExtra("err_msg");
            if (this.lWT != null) {
                c39010a = this.lWT;
                intent.getExtras();
                c39010a.mo7232n(intExtra, intExtra2, stringExtra);
            }
            C4990ab.m7417i("MicroMsg.FaceDetectPrepareUI", "carson onActivityResult errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(intExtra), Integer.valueOf(intExtra2), stringExtra);
            if (intExtra == 0 && intExtra2 == 0) {
                btn();
                m76463m(6, intent.getExtras());
                AppMethodBeat.m2505o(v2helper.EMethodSetSendToNetworkOn);
                return;
            }
            if (intExtra != 1) {
                stringExtra2 = intent.getStringExtra("show_err_msg");
                if (intExtra2 == 90013) {
                    stringExtra2 = getString(C25738R.string.bkk);
                } else if (intExtra2 == 90008 || intExtra2 == 90010) {
                    stringExtra2 = getString(C25738R.string.dbs);
                } else if (intExtra2 == 90009) {
                    stringExtra2 = getString(C25738R.string.dc0);
                } else if (C5046bo.isNullOrNil(stringExtra2)) {
                    stringExtra2 = getString(C25738R.string.er5);
                }
                mo23594d(intExtra, intExtra2, stringExtra, null);
                if (intExtra2 == 90023) {
                    z = true;
                }
                m76444a(intExtra, intExtra2, stringExtra, stringExtra2, z, new C3410312());
            } else if (intExtra2 == 90004 || intExtra2 == 90025) {
                m76451az(intExtra2, stringExtra);
                AppMethodBeat.m2505o(v2helper.EMethodSetSendToNetworkOn);
                return;
            }
            AppMethodBeat.m2505o(v2helper.EMethodSetSendToNetworkOn);
            return;
        }
        this.lXh = 1;
        if (intent == null) {
            C4990ab.m7412e("MicroMsg.FaceDetectPrepareUI", "alvinluo onActivityResult data is null");
            m76444a(4, 90018, "system error", getString(C25738R.string.bkz), false, new C4304313());
            AppMethodBeat.m2505o(v2helper.EMethodSetSendToNetworkOn);
            return;
        }
        faceDetectReporter = (FaceDetectReporter) intent.getParcelableExtra("key_parcelable_reporter");
        if (faceDetectReporter != null) {
            FaceDetectReporter.bsJ().mo54648a(faceDetectReporter);
        }
        intExtra = intent.getIntExtra("err_type", -1);
        intExtra2 = intent.getIntExtra("err_code", -1);
        stringExtra = intent.getStringExtra("err_msg");
        if (this.lWT != null) {
            c39010a = this.lWT;
            intent.getExtras();
            c39010a.mo7232n(intExtra, intExtra2, stringExtra);
        }
        C4990ab.m7417i("MicroMsg.FaceDetectPrepareUI", "alvinluo onActivityResult errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(intExtra), Integer.valueOf(intExtra2), stringExtra);
        if (intExtra == 0 && intExtra2 == 0) {
            btn();
            m76463m(1, null);
            AppMethodBeat.m2505o(v2helper.EMethodSetSendToNetworkOn);
            return;
        }
        if (intExtra != 1) {
            stringExtra2 = intent.getStringExtra("show_err_msg");
            if (intExtra2 == 90013) {
                stringExtra2 = getString(C25738R.string.bkk);
            } else if (intExtra2 == 90008 || intExtra2 == 90010) {
                stringExtra2 = getString(C25738R.string.dbs);
            } else if (intExtra2 == 90009) {
                stringExtra2 = getString(C25738R.string.dc0);
            } else if (C5046bo.isNullOrNil(stringExtra2)) {
                stringExtra2 = getString(C25738R.string.er5);
            }
            mo23594d(intExtra, intExtra2, stringExtra, null);
            if (intExtra2 == 90023) {
                z = true;
            }
            m76444a(intExtra, intExtra2, stringExtra, stringExtra2, z, new C3901914());
        } else if (intExtra2 == 90004 || intExtra2 == 90025) {
            m76451az(intExtra2, stringExtra);
            AppMethodBeat.m2505o(v2helper.EMethodSetSendToNetworkOn);
            return;
        }
        AppMethodBeat.m2505o(v2helper.EMethodSetSendToNetworkOn);
    }

    private void btm() {
        AppMethodBeat.m2504i(v2helper.EMethodSetSendToNetworkOff);
        if (this.lWU != null) {
            this.lWU.dismiss();
        }
        C4990ab.m7417i("MicroMsg.FaceDetectPrepareUI", "carson init jumper: %b", Boolean.valueOf(this.lXl));
        if (this.lXl) {
            this.lWU = new C11818b(this);
            this.lWU.create();
            AppMethodBeat.m2505o(v2helper.EMethodSetSendToNetworkOff);
            return;
        }
        this.lWU = new C34109a(this);
        this.lWU.create();
        AppMethodBeat.m2505o(v2helper.EMethodSetSendToNetworkOff);
    }

    /* renamed from: a */
    public final void mo23590a(boolean z, boolean z2, C3048c c3048c) {
        AppMethodBeat.m2504i(434);
        if (z2) {
            C4990ab.m7416i("MicroMsg.FaceDetectPrepareUI", "hy: need blur");
            C7305d.post(new C2064316(), "face_refresh_background");
        }
        this.lWU.mo23624a(c3048c);
        AppMethodBeat.m2505o(434);
    }

    private void btn() {
        AppMethodBeat.m2504i(C27141z.CTRL_INDEX);
        String string = getString(C25738R.string.bko);
        C3048c b = C34109a.m55909b(C25738R.drawable.b31, string, null, getString(C25738R.string.f9076or), null, new C2793617());
        b.lYB = true;
        b.lYD = string.length() - 3;
        b.status = 1;
        mo23590a(false, true, b);
        AppMethodBeat.m2505o(C27141z.CTRL_INDEX);
    }

    /* renamed from: a */
    private void m76444a(final int i, final int i2, final String str, String str2, boolean z, C43041c c43041c) {
        AppMethodBeat.m2504i(C42476h.CTRL_INDEX);
        C4990ab.m7417i("MicroMsg.FaceDetectPrepareUI", "alvinluo showFailJumper showErrMsg: %s", str2);
        if (this.lXn) {
            View findViewById = findViewById(2131823828);
            if (findViewById != null) {
                C4990ab.m7416i("MicroMsg.FaceDetectPrepareUI", "carson: hide tutorialRoot");
                findViewById.setVisibility(8);
            }
            this.lXk.setVisibility(0);
        }
        final boolean z2 = z;
        final C43041c c43041c2 = c43041c;
        final int i3 = i;
        final int i4 = i2;
        final String str3 = str;
        final C3048c a = C34109a.m55905a(C25738R.drawable.b33, str2, z ? getResources().getString(C25738R.string.blm) : getString(C25738R.string.blk), z ? getResources().getString(C25738R.string.f9076or) : null, new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(401);
                if (!z2) {
                    if (c43041c2 != null) {
                        c43041c2.mo54657p(i3, i4, str3);
                    }
                    FaceDetectPrepareUI.this.mo23589a(i3, i4, str3, null);
                } else if (FaceDetectPrepareUI.this.lWT != null) {
                    FaceDetectPrepareUI.this.lWT.bsk();
                    AppMethodBeat.m2505o(401);
                    return;
                }
                AppMethodBeat.m2505o(401);
            }
        }, new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(402);
                FaceDetectPrepareUI.this.mo23589a(i, i2, str, null);
                AppMethodBeat.m2505o(402);
            }
        });
        a.status = 3;
        String string = getString(C25738R.string.bke);
        if (this.lSK == null) {
            string = null;
        }
        C34109a.m55907a(a, string, new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(403);
                if (C5046bo.isNullOrNil(FaceDetectPrepareUI.this.lSK)) {
                    C4990ab.m7412e("MicroMsg.FaceDetectPrepareUI", "alvinluo feedback url is null");
                    AppMethodBeat.m2505o(403);
                    return;
                }
                FaceDetectPrepareUI.this.lXi = false;
                try {
                    String str = "appid=%s;errcode=%d;identifyid=%s";
                    Object[] objArr = new Object[3];
                    objArr[0] = FaceDetectPrepareUI.this.mAppId != null ? FaceDetectPrepareUI.this.mAppId : "";
                    objArr[1] = Integer.valueOf(i2);
                    objArr[2] = "";
                    C4990ab.m7417i("MicroMsg.FaceDetectPrepareUI", "alvinluo feedback url: %s", FaceDetectPrepareUI.this.lSK + "?customInfo=" + C18178q.encode(String.format(str, objArr), "UTF-8"));
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", r0);
                    C25985d.m41467b(FaceDetectPrepareUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    AppMethodBeat.m2505o(403);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.FaceDetectPrepareUI", e, "alvinluo start feedback webview exception", new Object[0]);
                    AppMethodBeat.m2505o(403);
                }
            }
        });
        C5004al.m7441d(new Runnable() {
            final /* synthetic */ boolean lXs = true;

            public final void run() {
                AppMethodBeat.m2504i(404);
                FaceDetectPrepareUI.this.mo23590a(true, this.lXs, a);
                AppMethodBeat.m2505o(404);
            }
        });
        AppMethodBeat.m2505o(C42476h.CTRL_INDEX);
    }

    public final void bsm() {
    }

    /* renamed from: a */
    public final void mo23589a(int i, int i2, String str, Bundle bundle) {
        int i3 = 1;
        AppMethodBeat.m2504i(437);
        C4990ab.m7417i("MicroMsg.FaceDetectPrepareUI", "finishWithResult errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        if (bundle != null) {
            bundle.putString("k_bio_id", String.valueOf(this.lTH));
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("err_code", C34097l.m55892vm(i2));
        bundle2.putString("err_msg", str);
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        Intent intent = new Intent();
        intent.putExtras(bundle2);
        setResult(-1, intent);
        if (this.lXb) {
            this.lXc = true;
            m76463m(5, this.lWT.bso());
            FaceDetectReporter bsJ = FaceDetectReporter.bsJ();
            if (!this.lXb) {
                i3 = 0;
            }
            bsJ.lUx = i3;
        }
        finish();
        AppMethodBeat.m2505o(437);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(438);
        C4990ab.m7416i("MicroMsg.FaceDetectPrepareUI", "onDestroy");
        super.onDestroy();
        if (!this.lXc) {
            C25985d.m41479l(new Intent(this, FaceDetectProcessService.class), "tools");
        }
        if (this.lXj != null) {
            this.lXj.stop();
        }
        AppMethodBeat.m2505o(438);
    }

    public void onStart() {
        AppMethodBeat.m2504i(JsApiGetInstallState.CTRL_INDEX);
        super.onStart();
        AppMethodBeat.m2505o(JsApiGetInstallState.CTRL_INDEX);
    }

    public void onResume() {
        AppMethodBeat.m2504i(JsApiAddDownloadTaskStraight.CTRL_INDEX);
        C4990ab.m7416i("MicroMsg.FaceDetectPrepareUI", "onResume");
        super.onResume();
        this.lXi = true;
        AppMethodBeat.m2505o(JsApiAddDownloadTaskStraight.CTRL_INDEX);
    }

    public void onStop() {
        AppMethodBeat.m2504i(JsApiQueryDownloadTask.CTRL_INDEX);
        super.onStop();
        if (this.lXi) {
            if (this.eTM || !hasError()) {
                finish();
            } else {
                mo23589a(this.lXa.errType, this.lXa.errCode, this.lXa.aIm, this.lXa.extras);
                AppMethodBeat.m2505o(JsApiQueryDownloadTask.CTRL_INDEX);
                return;
            }
        }
        AppMethodBeat.m2505o(JsApiQueryDownloadTask.CTRL_INDEX);
    }

    private void bto() {
        AppMethodBeat.m2504i(JsApiPauseDownloadTask.CTRL_INDEX);
        m76457d(4, 90011, "get image failed", getString(C25738R.string.bkf));
        AppMethodBeat.m2505o(JsApiPauseDownloadTask.CTRL_INDEX);
    }

    private void aDo() {
        AppMethodBeat.m2504i(JsApiResumeDownloadTask.CTRL_INDEX);
        m76457d(4, 90013, "init lib failed", getString(C25738R.string.bkk));
        AppMethodBeat.m2505o(JsApiResumeDownloadTask.CTRL_INDEX);
    }

    /* renamed from: d */
    private void m76457d(int i, int i2, String str, String str2) {
        AppMethodBeat.m2504i(JsApiWriteCommData.CTRL_INDEX);
        C4990ab.m7417i("MicroMsg.FaceDetectPrepareUI", "onProcessingError errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), str);
        mo23594d(i, i2, str, null);
        this.lWZ = true;
        m76444a(i, i2, str, str2, false, new C4304210());
        AppMethodBeat.m2505o(JsApiWriteCommData.CTRL_INDEX);
    }

    private boolean hasError() {
        boolean z;
        AppMethodBeat.m2504i(446);
        String str = "MicroMsg.FaceDetectPrepareUI";
        String str2 = "alvinluo hasLastError: %b, lastError == null: %b, hashCode: %d";
        Object[] objArr = new Object[3];
        objArr[0] = Boolean.valueOf(this.lWY);
        if (this.lXa == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Integer.valueOf(hashCode());
        C4990ab.m7417i(str, str2, objArr);
        if (!this.lWY || this.lXa == null) {
            AppMethodBeat.m2505o(446);
            return false;
        }
        AppMethodBeat.m2505o(446);
        return true;
    }

    /* renamed from: d */
    public final void mo23594d(int i, int i2, String str, Bundle bundle) {
        AppMethodBeat.m2504i(447);
        C4990ab.m7417i("MicroMsg.FaceDetectPrepareUI", "alvinluo saveError errType: %d, errCode: %d, errMsg: %s, hashCode: %d", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(hashCode()));
        if (this.lXa == null) {
            this.lXa = new C34105b(this, (byte) 0);
        }
        this.lWY = true;
        this.lXa.mo54659e(i, i2, str, bundle);
        AppMethodBeat.m2505o(447);
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(FileUtils.S_IRWXU);
        if (hasError()) {
            if (this.lWT != null) {
                this.lWT.mo7229c(this.lXa.errType, this.lXa.errCode, this.lXa.aIm, this.lXa.extras);
                AppMethodBeat.m2505o(FileUtils.S_IRWXU);
                return;
            }
        } else if (this.lXh == 1) {
            m76451az(90003, "user cancel in init");
            AppMethodBeat.m2505o(FileUtils.S_IRWXU);
            return;
        } else if (this.lXh == 3) {
            m76451az(90005, "user cancel in uploading");
            AppMethodBeat.m2505o(FileUtils.S_IRWXU);
            return;
        } else if (this.lXh == 0) {
            m76451az(90002, "user cancel in tutorial");
            AppMethodBeat.m2505o(FileUtils.S_IRWXU);
            return;
        } else {
            m76451az(90050, "user cancel unknown");
        }
        AppMethodBeat.m2505o(FileUtils.S_IRWXU);
    }

    /* renamed from: az */
    private void m76451az(int i, String str) {
        AppMethodBeat.m2504i(449);
        if (hasError()) {
            if (this.lWT != null) {
                this.lWT.mo7229c(this.lXa.errType, this.lXa.errCode, this.lXa.aIm, this.lXa.extras);
            }
        } else if (this.lWT != null) {
            this.lWT.mo7226ax(i, str);
        }
        this.eVT = true;
        finish();
        AppMethodBeat.m2505o(449);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = 90008;
        AppMethodBeat.m2504i(450);
        C4990ab.m7416i("MicroMsg.FaceDetectPrepareUI", "alvinluo onRequestPermissionsResult");
        if (iArr == null || iArr.length <= 0) {
            AppMethodBeat.m2505o(450);
            return;
        }
        switch (i) {
            case 23:
                int i3;
                String str = "";
                String str2 = "";
                View findViewById;
                if (iArr.length != 1) {
                    if (iArr.length == 2) {
                        if (iArr[0] == 0 && iArr[1] == 0) {
                            i3 = 1;
                        } else {
                            if (iArr[0] != 0) {
                                str = "camera permission not granted";
                                str2 = getString(C25738R.string.dbs);
                            } else {
                                i2 = -1;
                            }
                            if (iArr[1] != 0) {
                                i2 = 90009;
                                str = "audio permission not granted";
                                str2 = getString(C25738R.string.dc0);
                            }
                            if (!(iArr[0] == 0 || iArr[1] == 0)) {
                                i2 = 90010;
                                str = "both camera and audio permission not granted";
                                str2 = getString(C25738R.string.dbs);
                            }
                            this.lXk.setVisibility(0);
                            C4990ab.m7417i("MicroMsg.FaceDetectPrepareUI", " mFacePrepareLayout, visible: %s", Integer.valueOf(this.lXk.getVisibility()));
                            findViewById = findViewById(2131823828);
                            if (findViewById != null) {
                            }
                            m76457d(1, i2, str, str2);
                            i3 = 0;
                        }
                    }
                    i2 = -1;
                    this.lXk.setVisibility(0);
                    C4990ab.m7417i("MicroMsg.FaceDetectPrepareUI", " mFacePrepareLayout, visible: %s", Integer.valueOf(this.lXk.getVisibility()));
                    findViewById = findViewById(2131823828);
                    if (findViewById != null) {
                    }
                    m76457d(1, i2, str, str2);
                    i3 = 0;
                } else if (iArr[0] == 0) {
                    i3 = 1;
                } else {
                    if (strArr[0].equals("android.permission.CAMERA")) {
                        str = "camera permission not granted";
                        str2 = getString(C25738R.string.dbs);
                    } else {
                        if (strArr[0].equals("android.permission.RECORD_AUDIO")) {
                            i2 = 90009;
                            str = "audio permission not granted";
                            str2 = getString(C25738R.string.dc0);
                        }
                        i2 = -1;
                    }
                    this.lXk.setVisibility(0);
                    C4990ab.m7417i("MicroMsg.FaceDetectPrepareUI", " mFacePrepareLayout, visible: %s", Integer.valueOf(this.lXk.getVisibility()));
                    findViewById = findViewById(2131823828);
                    if (findViewById != null) {
                        findViewById.setVisibility(8);
                    }
                    m76457d(1, i2, str, str2);
                    i3 = 0;
                }
                if (i3 != 0) {
                    btj();
                    AppMethodBeat.m2505o(450);
                    return;
                }
                break;
            default:
                C4990ab.m7416i("MicroMsg.FaceDetectPrepareUI", "carson：finish()");
                break;
        }
        AppMethodBeat.m2505o(450);
    }

    public final void bsp() {
        this.lXi = false;
    }

    public void finish() {
        AppMethodBeat.m2504i(JsApiInstallDownloadTask.CTRL_INDEX);
        C4990ab.m7416i("MicroMsg.FaceDetectPrepareUI", "dismissJumper");
        if (this.lWU != null && this.lWU.aFF()) {
            this.lWU.dismiss();
        }
        if (this.lWV != null) {
            this.lWV.dismiss();
        }
        C4990ab.m7418v("MicroMsg.FaceDetectPrepareUI", "alvinluo: releaseFaceDetect");
        if (this.lWT != null) {
            this.lWT.bsm();
        }
        super.finish();
        this.eTM = true;
        AppMethodBeat.m2505o(JsApiInstallDownloadTask.CTRL_INDEX);
    }

    /* renamed from: b */
    static /* synthetic */ void m76453b(FaceDetectPrepareUI faceDetectPrepareUI, Message message) {
        AppMethodBeat.m2504i(452);
        Bundle data = message.getData();
        if (data == null) {
            faceDetectPrepareUI.bto();
            AppMethodBeat.m2505o(452);
        } else if (data.getInt("key_face_result_code", -1) != 0) {
            faceDetectPrepareUI.bto();
            AppMethodBeat.m2505o(452);
        } else {
            faceDetectPrepareUI.lXh = 3;
            final String string = data.getString("key_face_result_file_path");
            if (string != null) {
                C7305d.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(412);
                        try {
                            FaceDetectPrepareUI.this.lWT.mo61906Lq(string);
                            AppMethodBeat.m2505o(412);
                        } catch (Exception e) {
                            C4990ab.printErrStackTrace("MicroMsg.FaceDetectPrepareUI", e, "", new Object[0]);
                            AppMethodBeat.m2505o(412);
                        }
                    }
                }, "face_upload");
            }
            AppMethodBeat.m2505o(452);
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m76455c(FaceDetectPrepareUI faceDetectPrepareUI, Message message) {
        AppMethodBeat.m2504i(C38317l.CTRL_INDEX);
        Bundle data = message.getData();
        if (data == null) {
            C4990ab.m7416i("MicroMsg.FaceDetectPrepareUI", "onUploadBioBuffer, data is null");
            faceDetectPrepareUI.bto();
            AppMethodBeat.m2505o(C38317l.CTRL_INDEX);
            return;
        }
        final String string = data.getString("key_bio_buffer_path");
        if (C5046bo.isNullOrNil(string)) {
            C4990ab.m7416i("MicroMsg.FaceDetectPrepareUI", "onUploadBioBuffer, filepath is null");
            faceDetectPrepareUI.bto();
            AppMethodBeat.m2505o(C38317l.CTRL_INDEX);
            return;
        }
        C7305d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(411);
                try {
                    C4990ab.m7417i("MicroMsg.FaceDetectPrepareUI", "call controller start upload biobuffer: %s", string);
                    FaceDetectPrepareUI.this.lWT.mo61906Lq(string);
                    AppMethodBeat.m2505o(411);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.FaceDetectPrepareUI", e, "", new Object[0]);
                    AppMethodBeat.m2505o(411);
                }
            }
        }, "face_upload");
        AppMethodBeat.m2505o(C38317l.CTRL_INDEX);
    }
}
