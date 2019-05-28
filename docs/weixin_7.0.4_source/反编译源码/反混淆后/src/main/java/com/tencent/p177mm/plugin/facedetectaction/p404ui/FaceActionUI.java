package com.tencent.p177mm.plugin.facedetectaction.p404ui;

import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p612ui.C5229aj;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.MMTextureView;
import com.tencent.p177mm.plugin.facedetect.model.C43036p;
import com.tencent.p177mm.plugin.facedetectaction.p967b.C39031b;
import com.tencent.p177mm.plugin.facedetectaction.p967b.C43048d;
import com.tencent.p177mm.plugin.facedetectaction.p967b.C43048d.C39034a;
import com.tencent.p177mm.plugin.facedetectaction.p967b.C45922a.C20665a;
import com.tencent.p177mm.plugin.facedetectlight.p405ui.C11830b;
import com.tencent.p177mm.plugin.facedetectlight.p405ui.PreviewFrameLayout;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.youtu.ytfacetrace.jni.YTFaceTraceJNIInterface.FaceStatus;
import com.tencent.youtu.ytposedetect.YTPoseDetectInterface;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI */
public class FaceActionUI extends MMActivity {
    int cvG;
    private long endTime;
    RelativeLayout lYg;
    RelativeLayout lYh;
    RelativeLayout lYi;
    ImageView lYj;
    ImageView lYk;
    ImageView lYl;
    private int mbW;
    private String mbX;
    RelativeLayout mcN;
    private PreviewFrameLayout mcO;
    private FaceActionMask mcP;
    private MMTextureView mcQ;
    ImageView mcR;
    private TextView mcS;
    private TextView mcT;
    private ImageView mcU;
    private Button mcV;
    private Button mcW;
    private TextView mcX;
    public boolean mcY = false;
    C11830b mcZ;
    private C20665a mca;
    private int mda;
    private int mdb;
    private String mdc;
    private int mdd;
    private int scene;
    private long startTime;

    /* renamed from: com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI$9 */
    class C118249 implements Runnable {
        C118249() {
        }

        public final void run() {
            AppMethodBeat.m2504i(727);
            FaceActionUI.this.finish();
            AppMethodBeat.m2505o(727);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI$7 */
    class C206687 implements AnimationListener {
        C206687() {
        }

        public final void onAnimationEnd(Animation animation) {
            AppMethodBeat.m2504i(724);
            C4990ab.m7410d("MicroMsg.FaceActionUI", "checkingAnimation, AnimationEnd");
            C4990ab.m7410d("MicroMsg.FaceActionUI", "checkingAnimation, AnimationEnd");
            AppMethodBeat.m2505o(724);
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationStart(Animation animation) {
            AppMethodBeat.m2504i(725);
            C4990ab.m7410d("MicroMsg.FaceActionUI", "checkingAnimation, AnimationStart");
            AppMethodBeat.m2505o(725);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI$1 */
    class C247521 implements C20665a {
        C247521() {
        }

        /* renamed from: a */
        public final void mo35962a(FaceStatus faceStatus, byte[] bArr) {
            AppMethodBeat.m2504i(709);
            C43048d c43048d = C43048d.mcq;
            Camera camera = FaceActionUI.this.mcZ.mdw.etv;
            if (c43048d.mcr != null) {
                c43048d.mStatus = 1;
                C39031b c39031b = c43048d.mcr;
                if (faceStatus != null) {
                    c39031b.status = 2;
                    YTPoseDetectInterface.poseDetect(faceStatus.xys, c39031b.mcm, bArr, camera, faceStatus.pitch, faceStatus.yaw, faceStatus.roll, c39031b.mcn);
                }
            }
            AppMethodBeat.m2505o(709);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI$2 */
    class C279512 implements C39034a {

        /* renamed from: com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI$2$2 */
        class C30592 implements Runnable {
            C30592() {
            }

            public final void run() {
                AppMethodBeat.m2504i(711);
                FaceActionUI faceActionUI = FaceActionUI.this;
                if (faceActionUI.mcZ != null) {
                    faceActionUI.mcZ.stopPreview();
                }
                faceActionUI.mcN.setVisibility(8);
                faceActionUI.lYg.setVisibility(0);
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) faceActionUI.lYj.getHeight());
                translateAnimation.setDuration(FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                translateAnimation.setRepeatMode(2);
                translateAnimation.setRepeatCount(-1);
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 1.0f, 1.0f, 1, 0.5f, 1, 0.5f);
                scaleAnimation.setDuration(1000);
                scaleAnimation.setRepeatMode(2);
                scaleAnimation.setRepeatCount(-1);
                AnimationSet animationSet = new AnimationSet(true);
                animationSet.addAnimation(translateAnimation);
                animationSet.addAnimation(scaleAnimation);
                animationSet.setAnimationListener(new C206687());
                animationSet.setRepeatCount(-1);
                faceActionUI.lYk.startAnimation(animationSet);
                AppMethodBeat.m2505o(711);
            }
        }

        C279512() {
        }

        /* renamed from: aA */
        public final void mo45864aA(final int i, final String str) {
            AppMethodBeat.m2504i(716);
            C4990ab.m7417i("MicroMsg.FaceActionUI", "onInitFaceCheckFinish: %s", Integer.valueOf(i));
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(710);
                    FaceActionUI.this.mbW = i;
                    FaceActionUI.this.mbX = str;
                    FaceActionUI.m55922c(FaceActionUI.this);
                    FaceActionUI.m55925d(FaceActionUI.this);
                    FaceActionUI.this.mdd = FaceActionUI.this.mdd + 1;
                    AppMethodBeat.m2505o(710);
                }
            });
            AppMethodBeat.m2505o(716);
        }

        public final void btP() {
            AppMethodBeat.m2504i(717);
            C4990ab.m7416i("MicroMsg.FaceActionUI", "onStartUpload");
            C5004al.m7441d(new C30592());
            AppMethodBeat.m2505o(717);
        }

        /* renamed from: Lx */
        public final void mo45862Lx(final String str) {
            AppMethodBeat.m2504i(718);
            C4990ab.m7417i("MicroMsg.FaceActionUI", "onVerifyFinish:   authToken ：%s", str);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(712);
                    FaceActionUI.this.lYk.clearAnimation();
                    FaceActionUI faceActionUI = FaceActionUI.this;
                    faceActionUI.mcN.setVisibility(8);
                    faceActionUI.lYk.clearAnimation();
                    faceActionUI.lYg.setVisibility(8);
                    faceActionUI.mcR.setVisibility(0);
                    faceActionUI.lYh.setVisibility(0);
                    faceActionUI.lYl.setScaleX(0.0f);
                    faceActionUI.lYl.setScaleY(0.0f);
                    faceActionUI.lYl.animate().scaleX(1.0f).scaleY(1.0f).setDuration(800);
                    faceActionUI = FaceActionUI.this;
                    String str = str;
                    C4990ab.m7416i("MicroMsg.FaceActionUI", "callbackDetectSuccess（）");
                    Bundle bundle = new Bundle();
                    bundle.putString("token", str);
                    faceActionUI.cvG = 0;
                    faceActionUI.mo54673a("ok", 0, bundle, Boolean.valueOf(faceActionUI.mcY));
                    AppMethodBeat.m2505o(712);
                }
            });
            AppMethodBeat.m2505o(718);
        }

        /* renamed from: a */
        public final void mo45863a(int i, final int i2, final String str, final int i3) {
            AppMethodBeat.m2504i(719);
            C4990ab.m7417i("MicroMsg.FaceActionUI", "onError, err: %s, cgiErrCode: %s, cgiErrMsg: %s,retry: %s", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3));
            FaceActionUI.this.mda = i;
            FaceActionUI.this.mdb = i2;
            FaceActionUI.this.mdc = str;
            C5004al.m7441d(new Runnable() {

                /* renamed from: com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI$2$4$1 */
                class C279491 implements OnClickListener {
                    C279491() {
                    }

                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(713);
                        C4990ab.m7416i("MicroMsg.FaceActionUI", "click retry");
                        FaceActionUI.m55931j(FaceActionUI.this);
                        AppMethodBeat.m2505o(713);
                    }
                }

                /* renamed from: com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI$2$4$2 */
                class C279502 implements OnClickListener {
                    C279502() {
                    }

                    public final void onClick(View view) {
                        AppMethodBeat.m2504i(714);
                        C4990ab.m7416i("MicroMsg.FaceActionUI", "click finish");
                        FaceActionUI.this.mo54674s("fail", i2, "");
                        AppMethodBeat.m2505o(714);
                    }
                }

                public final void run() {
                    AppMethodBeat.m2504i(715);
                    if (C5046bo.isNullOrNil(str)) {
                        FaceActionUI.this.mcX.setText(C25738R.string.bje);
                    } else {
                        FaceActionUI.this.mcX.setText(str);
                        FaceActionUI.this.cvG = 2;
                    }
                    if (i3 == 1) {
                        FaceActionUI.this.mcV.setText(C25738R.string.bll);
                        FaceActionUI.this.mcV.setOnClickListener(new C279491());
                    } else {
                        FaceActionUI.this.mcV.setText(C25738R.string.blk);
                        FaceActionUI.this.mcV.setOnClickListener(new C279502());
                    }
                    FaceActionUI.this.lYk.clearAnimation();
                    FaceActionUI faceActionUI = FaceActionUI.this;
                    faceActionUI.mcN.setVisibility(8);
                    faceActionUI.lYi.setVisibility(0);
                    faceActionUI.lYk.clearAnimation();
                    faceActionUI.mcR.setVisibility(0);
                    faceActionUI.lYg.setVisibility(8);
                    C43048d.mcq.mStatus = 3;
                    if (C5046bo.isNullOrNil(C43048d.mcq.cKU)) {
                        FaceActionUI.this.mo54674s("fail", i2, "");
                    }
                    AppMethodBeat.m2505o(715);
                }
            });
            AppMethodBeat.m2505o(719);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI$8 */
    class C279538 implements OnClickListener {
        C279538() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(726);
            C4990ab.m7416i("MicroMsg.FaceActionUI", "click finish");
            FaceActionUI.this.mo54674s("fail", 90010, "");
            AppMethodBeat.m2505o(726);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI$5 */
    class C341185 implements OnClickListener {
        C341185() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(722);
            C43048d.mcq.onBackPressed();
            FaceActionUI.this.finish();
            AppMethodBeat.m2505o(722);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI$3 */
    class C341193 implements Runnable {
        C341193() {
        }

        public final void run() {
            AppMethodBeat.m2504i(720);
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) FaceActionUI.this.mcU.getLayoutParams();
            marginLayoutParams.topMargin = (int) (((double) FaceActionUI.this.mcP.getHeight()) * 0.4d);
            FaceActionUI.this.mcU.setLayoutParams(marginLayoutParams);
            FaceActionUI.this.mcU.setVisibility(0);
            AppMethodBeat.m2505o(720);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI$4 */
    class C341204 implements Runnable {
        C341204() {
        }

        public final void run() {
            AppMethodBeat.m2504i(721);
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) FaceActionUI.this.mcS.getLayoutParams();
            marginLayoutParams.topMargin = (((int) (((double) FaceActionUI.this.mcP.getHeight()) * 0.4d)) + ((int) (((double) FaceActionUI.this.mcP.getWidth()) * 0.35d))) + C5229aj.fromDPToPix(FaceActionUI.this, 30);
            C4990ab.m7417i("MicroMsg.FaceActionUI", "topMargin：%d", Integer.valueOf(r1));
            FaceActionUI.this.mcS.setLayoutParams(marginLayoutParams);
            FaceActionUI.this.mcS.setVisibility(0);
            AppMethodBeat.m2505o(721);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetectaction.ui.FaceActionUI$6 */
    class C341216 implements OnClickListener {
        C341216() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(723);
            C4990ab.m7416i("MicroMsg.FaceActionUI", "click mUploadFailedConfig");
            FaceActionUI.this.mcY = true;
            FaceActionUI.this.mo54674s("fail", FaceActionUI.this.mdb, "");
            AppMethodBeat.m2505o(723);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: d */
    static /* synthetic */ void m55925d(FaceActionUI faceActionUI) {
        AppMethodBeat.m2504i(744);
        faceActionUI.btR();
        AppMethodBeat.m2505o(744);
    }

    public final int getLayoutId() {
        return 2130969457;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(728);
        C4990ab.m7410d("MicroMsg.FaceActionUI", "start VerifyActivity");
        super.onCreate(bundle);
        getWindow().setFlags(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        getWindow().addFlags(2097280);
        this.scene = getIntent().getIntExtra("scene", 0);
        this.mdd = 0;
        this.startTime = C5046bo.m7588yz();
        this.cvG = 4;
        C4990ab.m7410d("MicroMsg.FaceActionUI", "initLayout");
        this.mcR = (ImageView) findViewById(2131823758);
        btQ();
        this.lYg = (RelativeLayout) findViewById(2131823751);
        this.lYh = (RelativeLayout) findViewById(2131823747);
        this.lYi = (RelativeLayout) findViewById(2131823742);
        this.lYg.setVisibility(4);
        this.lYh.setVisibility(4);
        this.lYi.setVisibility(4);
        this.lYj = (ImageView) findViewById(2131823753);
        this.lYk = (ImageView) findViewById(2131823752);
        this.lYl = (ImageView) findViewById(2131823749);
        this.mcX = (TextView) findViewById(2131823744);
        this.mcV = (Button) findViewById(2131823745);
        this.mcW = (Button) findViewById(2131823746);
        if (C5046bo.isNullOrNil(C43048d.mcq.cKU)) {
            this.mcW.setVisibility(8);
        } else {
            this.mcW.setText(C43048d.mcq.cKU);
            this.mcW.setOnClickListener(new C341216());
        }
        if (C43036p.m76428M(this)) {
            C4990ab.m7416i("MicroMsg.FaceActionUI", "carson: checkFacePermissionAnd Request true and do init ");
            btj();
            AppMethodBeat.m2505o(728);
            return;
        }
        C4990ab.m7416i("MicroMsg.FaceActionUI", "carson: no camera permission. request permission");
        AppMethodBeat.m2505o(728);
    }

    private void btj() {
        AppMethodBeat.m2504i(729);
        this.mca = new C247521();
        C43048d.mcq.mcw = new C279512();
        C43048d.mcq.crP = this;
        C43048d.mcq.mo68576a(this);
        AppMethodBeat.m2505o(729);
    }

    public void onStart() {
        AppMethodBeat.m2504i(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH);
        C4990ab.m7410d("MicroMsg.FaceActionUI", "onStart");
        super.onStart();
        if (this.mcZ != null) {
            this.mcZ.mo23643a(this.mcQ);
            this.mcZ.btX();
        }
        AppMethodBeat.m2505o(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH);
    }

    public void onResume() {
        AppMethodBeat.m2504i(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_URL_EMPTY);
        super.onResume();
        C4990ab.m7410d("MicroMsg.FaceActionUI", "onResume");
        btR();
        AppMethodBeat.m2505o(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_URL_EMPTY);
    }

    public void onPause() {
        AppMethodBeat.m2504i(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION);
        C4990ab.m7410d("MicroMsg.FaceActionUI", "onPause");
        super.onPause();
        AppMethodBeat.m2505o(TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION);
    }

    public void onStop() {
        AppMethodBeat.m2504i(733);
        C4990ab.m7416i("MicroMsg.FaceActionUI", "onStop");
        super.onStop();
        if (this.mcZ != null) {
            this.mcZ.lXB = false;
        }
        AppMethodBeat.m2505o(733);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(734);
        super.onDestroy();
        C4990ab.m7416i("MicroMsg.FaceActionUI", "onDestroy");
        C43048d.mcq.release(true);
        AppMethodBeat.m2505o(734);
    }

    private void btQ() {
        AppMethodBeat.m2504i(735);
        this.mcN = (RelativeLayout) findViewById(2131823755);
        this.mcO = (PreviewFrameLayout) findViewById(2131823756);
        this.mcQ = (MMTextureView) findViewById(2131823757);
        this.mcQ.setVisibility(4);
        this.mcP = (FaceActionMask) findViewById(2131823760);
        this.mcU = (ImageView) findViewById(2131823759);
        this.mcU.post(new C341193());
        this.mcS = (TextView) findViewById(2131823761);
        this.mcS.post(new C341204());
        this.mcT = (TextView) findViewById(2131823762);
        this.mcT.setOnClickListener(new C341185());
        AppMethodBeat.m2505o(735);
    }

    /* renamed from: s */
    public final void mo54674s(String str, int i, String str2) {
        AppMethodBeat.m2504i(736);
        C4990ab.m7416i("MicroMsg.FaceActionUI", "callbackDetectFailed（）");
        Bundle bundle = new Bundle();
        bundle.putString("token", str2);
        mo54673a(str, i, bundle, Boolean.valueOf(this.mcY));
        AppMethodBeat.m2505o(736);
    }

    /* renamed from: a */
    public final void mo54673a(String str, int i, Bundle bundle, Boolean bool) {
        String str2;
        AppMethodBeat.m2504i(737);
        C4990ab.m7417i("MicroMsg.FaceActionUI", "finishWithResult errMsg: %s, errCode: %d", str, Integer.valueOf(i));
        if (bool.booleanValue()) {
            str2 = "yes";
        } else {
            str2 = "no";
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("click_other_verify_btn", str2);
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        m55923c(str, i, bundle2);
        new C7306ak().postDelayed(new C118249(), 1500);
        AppMethodBeat.m2505o(737);
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    private void m55923c(String str, int i, Bundle bundle) {
        int i2;
        AppMethodBeat.m2504i(738);
        Intent d = m55924d(str, i, bundle);
        switch (str.hashCode()) {
            case -1367724422:
                if (str.equals("cancel")) {
                    i2 = 2;
                    break;
                }
            case 3548:
                if (str.equals("ok")) {
                    i2 = 0;
                    break;
                }
            case 3135262:
                if (str.equals("fail")) {
                    i2 = 1;
                    break;
                }
            default:
                i2 = -1;
                break;
        }
        switch (i2) {
            case 0:
                setResult(-1, d);
                AppMethodBeat.m2505o(738);
                return;
            case 1:
                setResult(1, d);
                AppMethodBeat.m2505o(738);
                return;
            case 2:
                setResult(0, d);
                AppMethodBeat.m2505o(738);
                return;
            default:
                setResult(-1, d);
                AppMethodBeat.m2505o(738);
                return;
        }
    }

    /* renamed from: d */
    private Intent m55924d(String str, int i, Bundle bundle) {
        AppMethodBeat.m2504i(739);
        Bundle bundle2 = new Bundle();
        bundle2.putInt("err_code", i);
        bundle2.putString("err_msg", str);
        bundle2.putInt("scene", this.scene);
        bundle2.putInt("countFace", this.mdd);
        bundle2.putInt("err_type", this.cvG);
        this.endTime = C5046bo.m7588yz();
        C4990ab.m7416i("MicroMsg.FaceActionUI", "endTime：" + this.endTime);
        C4990ab.m7416i("MicroMsg.FaceActionUI", "startTime：" + this.startTime);
        bundle2.putLong("totalTime", this.endTime - this.startTime);
        if (bundle != null) {
            bundle2.putAll(bundle);
        }
        Intent intent = new Intent();
        intent.putExtras(bundle2);
        AppMethodBeat.m2505o(739);
        return intent;
    }

    public void onBackPressed() {
        AppMethodBeat.m2504i(740);
        C43048d.mcq.onBackPressed();
        AppMethodBeat.m2505o(740);
    }

    private void btR() {
        AppMethodBeat.m2504i(741);
        C4990ab.m7416i("MicroMsg.FaceActionUI", "preview");
        if (this.mcZ != null) {
            this.mcZ.mdx = true;
            C4990ab.m7416i("MicroMsg.FaceActionUI", "mCamera ！= null");
        }
        this.mcS.setText(C25738R.string.bld);
        AppMethodBeat.m2505o(741);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AppMethodBeat.m2504i(742);
        C4990ab.m7416i("MicroMsg.FaceActionUI", "carson onRequestPermissionsResult");
        if (iArr == null || iArr.length <= 0) {
            AppMethodBeat.m2505o(742);
            return;
        }
        switch (i) {
            case 23:
                int i2;
                Object obj = "";
                Object obj2 = "";
                if (iArr.length != 1) {
                    if (iArr.length == 2) {
                        if (iArr[0] == 0 && iArr[1] == 0) {
                            i2 = 1;
                        } else {
                            if (iArr[0] != 0) {
                                obj = "camera permission not granted";
                                obj2 = getString(C25738R.string.dbs);
                            }
                            if (iArr[1] != 0) {
                                obj = "audio permission not granted";
                                obj2 = getString(C25738R.string.dc0);
                            }
                            if (!(iArr[0] == 0 || iArr[1] == 0)) {
                                obj = "both camera and audio permission not granted";
                                obj2 = getString(C25738R.string.dbs);
                            }
                        }
                    }
                    C4990ab.m7416i("MicroMsg.FaceActionUI", "carson PermissionsResult:errMsg".concat(String.valueOf(obj)));
                    C4990ab.m7416i("MicroMsg.FaceActionUI", "carson PermissionsResult:showErrMsg".concat(String.valueOf(obj2)));
                    C4990ab.m7416i("MicroMsg.FaceActionUI", "checkPermissionFailedAnimation");
                    this.mcX.setText(obj2);
                    this.mcV.setText(C25738R.string.blk);
                    this.mcV.setOnClickListener(new C279538());
                    this.mcN.setVisibility(8);
                    this.lYi.setVisibility(0);
                    this.lYk.clearAnimation();
                    this.mcR.setVisibility(0);
                    this.lYg.setVisibility(8);
                    i2 = 0;
                } else if (iArr[0] == 0) {
                    i2 = 1;
                } else {
                    if (strArr[0].equals("android.permission.CAMERA")) {
                        obj = "camera permission not granted";
                        obj2 = getString(C25738R.string.dbs);
                    } else if (strArr[0].equals("android.permission.RECORD_AUDIO")) {
                        obj = "audio permission not granted";
                        obj2 = getString(C25738R.string.dc0);
                    }
                    C4990ab.m7416i("MicroMsg.FaceActionUI", "carson PermissionsResult:errMsg".concat(String.valueOf(obj)));
                    C4990ab.m7416i("MicroMsg.FaceActionUI", "carson PermissionsResult:showErrMsg".concat(String.valueOf(obj2)));
                    C4990ab.m7416i("MicroMsg.FaceActionUI", "checkPermissionFailedAnimation");
                    this.mcX.setText(obj2);
                    this.mcV.setText(C25738R.string.blk);
                    this.mcV.setOnClickListener(new C279538());
                    this.mcN.setVisibility(8);
                    this.lYi.setVisibility(0);
                    this.lYk.clearAnimation();
                    this.mcR.setVisibility(0);
                    this.lYg.setVisibility(8);
                    i2 = 0;
                }
                if (i2 != 0) {
                    btj();
                    break;
                }
                break;
        }
        AppMethodBeat.m2505o(742);
    }

    /* renamed from: c */
    static /* synthetic */ void m55922c(FaceActionUI faceActionUI) {
        AppMethodBeat.m2504i(743);
        C4990ab.m7410d("MicroMsg.FaceActionUI", "initCamera");
        faceActionUI.mcZ = new C11830b(faceActionUI, faceActionUI.mca);
        faceActionUI.mcZ.mdy = faceActionUI.mcS;
        faceActionUI.mcZ.mcP = faceActionUI.mcP;
        faceActionUI.mcZ.mdA = faceActionUI.mcO;
        faceActionUI.mcZ.mbW = faceActionUI.mbW;
        faceActionUI.mcZ.mbX = faceActionUI.mbX;
        faceActionUI.mcZ.mdE = faceActionUI.mcU;
        faceActionUI.mcZ.mdD = faceActionUI.mcR;
        faceActionUI.mcZ.mo23643a(faceActionUI.mcQ);
        faceActionUI.mcZ.btX();
        AppMethodBeat.m2505o(743);
    }

    /* renamed from: j */
    static /* synthetic */ void m55931j(FaceActionUI faceActionUI) {
        AppMethodBeat.m2504i(745);
        C43048d.mcq.release(false);
        faceActionUI.mcZ.btW();
        faceActionUI.lYg.setVisibility(8);
        faceActionUI.lYi.setVisibility(8);
        faceActionUI.mcN.setVisibility(0);
        faceActionUI.btQ();
        C43048d.mcq.mo68576a(faceActionUI);
        AppMethodBeat.m2505o(745);
    }
}
