package com.tencent.p177mm.plugin.facedetect.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.p615c.p1344a.C23651c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38269bc;
import com.tencent.p177mm.plugin.appbrand.jsapi.C38271be;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42466ag;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45579bb;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet;
import com.tencent.p177mm.plugin.appbrand.jsapi.offlinevoice.C42558b;
import com.tencent.p177mm.plugin.appbrand.jsapi.offlinevoice.C42559c;
import com.tencent.p177mm.plugin.appbrand.weishi.C2509f;
import com.tencent.p177mm.plugin.facedetect.model.C11810f;
import com.tencent.p177mm.plugin.facedetect.model.C43036p;
import com.tencent.p177mm.plugin.facedetect.model.C43037q;
import com.tencent.p177mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.p177mm.plugin.facedetect.p401d.C11802b;
import com.tencent.p177mm.plugin.facedetect.p401d.C11802b.C11803b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.facedetect.views.FaceDetectView */
public class FaceDetectView extends RelativeLayout {
    public static long maQ = 100;
    public static int maR = 1;
    public volatile boolean eTf;
    public boolean isPaused;
    public long lTW;
    private TextView lXH;
    public String lXd;
    public FaceDetectCameraView maA;
    public FaceDetectDecorView maB;
    public ViewGroup maC;
    public ViewGroup maD;
    private C11821a maE;
    public C11802b maF;
    public boolean maG;
    public boolean maH;
    public String maI;
    public boolean maJ;
    public boolean maK;
    public long maL;
    private long maM;
    private final int maN;
    private Animation maO;
    private View maP;

    /* renamed from: com.tencent.mm.plugin.facedetect.views.FaceDetectView$1 */
    class C30581 implements C11822b {
        C30581() {
        }

        /* renamed from: a */
        public final void mo7301a(int i, CharSequence charSequence) {
            AppMethodBeat.m2504i(C38271be.CTRL_INDEX);
            C4990ab.m7413e("MicroMsg.FaceDetectView", "hy: onDetectError: %d, %s", Integer.valueOf(i), charSequence);
            if (FaceDetectView.this.eTf || FaceDetectView.this.isPaused) {
                C4990ab.m7420w("MicroMsg.FaceDetectView", "hy: already end or paused");
                AppMethodBeat.m2505o(C38271be.CTRL_INDEX);
            } else if (FaceDetectView.this.maF == null || !FaceDetectView.this.maF.bsW()) {
                FaceDetectView.this.mo61941hc(false);
                FaceDetectView.this.maH = true;
                FaceDetectView.m66309a(FaceDetectView.this, charSequence != null ? charSequence.toString() : FaceDetectView.this.getContext().getString(C25738R.string.bjk));
                if (FaceDetectView.this.maE != null) {
                    FaceDetectView.this.maE.mo23631T(i, charSequence != null ? charSequence.toString() : FaceDetectView.this.getContext().getString(C25738R.string.bjk));
                }
                AppMethodBeat.m2505o(C38271be.CTRL_INDEX);
            } else {
                C4990ab.m7412e("MicroMsg.FaceDetectView", "hy: motion eat result");
                FaceDetectView.m66308a(FaceDetectView.this, FaceDetectView.this.maF.bsZ());
                AppMethodBeat.m2505o(C38271be.CTRL_INDEX);
            }
        }

        /* renamed from: d */
        public final void mo7303d(FaceCharacteristicsResult faceCharacteristicsResult) {
            AppMethodBeat.m2504i(C38269bc.CTRL_INDEX);
            C4990ab.m7411d("MicroMsg.FaceDetectView", "hy: onDetectSucceed: %s", faceCharacteristicsResult.toString());
            if (FaceDetectView.this.eTf || FaceDetectView.this.isPaused) {
                C4990ab.m7420w("MicroMsg.FaceDetectView", "hy: already end pr paused");
                AppMethodBeat.m2505o(C38269bc.CTRL_INDEX);
            } else if (FaceDetectView.this.maF == null || !FaceDetectView.this.maF.mo7240b(faceCharacteristicsResult)) {
                FaceDetectView.this.maH = false;
                if ((FaceDetectView.this.maF != null && FaceDetectView.this.maF.bsV()) || FaceDetectView.m66316f(FaceDetectView.this)) {
                    FaceDetectView.m66318h(FaceDetectView.this);
                    FaceDetectView.m66315e(FaceDetectView.this);
                }
                AppMethodBeat.m2505o(C38269bc.CTRL_INDEX);
            } else {
                C4990ab.m7412e("MicroMsg.FaceDetectView", "hy: motion eat result");
                FaceDetectView.m66308a(FaceDetectView.this, FaceDetectView.this.maF.bsZ());
                AppMethodBeat.m2505o(C38269bc.CTRL_INDEX);
            }
        }

        /* renamed from: c */
        public final void mo7302c(FaceCharacteristicsResult faceCharacteristicsResult) {
            AppMethodBeat.m2504i(C45579bb.CTRL_INDEX);
            int i = faceCharacteristicsResult.errCode;
            String str = faceCharacteristicsResult.aIm;
            C4990ab.m7419v("MicroMsg.FaceDetectView", "hy: onDetectHelp: %d, %s", Integer.valueOf(i), str);
            if (FaceDetectView.this.eTf || FaceDetectView.this.isPaused) {
                C4990ab.m7420w("MicroMsg.FaceDetectView", "hy: already end");
                AppMethodBeat.m2505o(C45579bb.CTRL_INDEX);
            } else if (FaceDetectView.this.maF == null || !FaceDetectView.this.maF.mo7239a(faceCharacteristicsResult)) {
                FaceDetectView.m66315e(FaceDetectView.this);
                if (!FaceDetectView.m66316f(FaceDetectView.this)) {
                    AppMethodBeat.m2505o(C45579bb.CTRL_INDEX);
                } else if (FaceDetectView.this.maJ || !(faceCharacteristicsResult.errCode == 10 || faceCharacteristicsResult.errCode == 11)) {
                    FaceDetectView.this.maH = FaceCharacteristicsResult.m19654vh(i);
                    FaceDetectView faceDetectView = FaceDetectView.this;
                    if (str == null) {
                        str = "";
                    }
                    FaceDetectView.m66309a(faceDetectView, str);
                    AppMethodBeat.m2505o(C45579bb.CTRL_INDEX);
                } else {
                    AppMethodBeat.m2505o(C45579bb.CTRL_INDEX);
                }
            } else {
                C4990ab.m7412e("MicroMsg.FaceDetectView", "hy: motion eat result");
                FaceDetectView.m66308a(FaceDetectView.this, FaceDetectView.this.maF.bsZ());
                AppMethodBeat.m2505o(C45579bb.CTRL_INDEX);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.views.FaceDetectView$4 */
    public class C341154 implements C45920c {
        final /* synthetic */ C45920c maV;

        public C341154(C45920c c45920c) {
            this.maV = c45920c;
        }

        /* renamed from: vt */
        public final void mo35946vt(int i) {
            AppMethodBeat.m2504i(623);
            C4990ab.m7417i("MicroMsg.FaceDetectView", "hy: camera preview init done : %d", Integer.valueOf(i));
            if (i == 0) {
                FaceDetectView.this.maH = false;
                FaceDetectView.m66318h(FaceDetectView.this);
            }
            if (this.maV != null) {
                this.maV.mo35946vt(i);
            }
            AppMethodBeat.m2505o(623);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.views.FaceDetectView$5 */
    class C341165 implements Runnable {
        final /* synthetic */ C43037q lVX = null;

        C341165() {
        }

        public final void run() {
            AppMethodBeat.m2504i(624);
            FaceDetectView.this.maA.btD();
            if (this.lVX != null) {
                this.lVX.mo54656b(FaceDetectView.this.maA.btF());
            }
            AppMethodBeat.m2505o(624);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.views.FaceDetectView$3 */
    class C390263 implements Runnable {
        C390263() {
        }

        public final void run() {
            AppMethodBeat.m2504i(622);
            if (!(FaceDetectView.this.maE == null || FaceDetectView.this.eTf)) {
                FaceDetectView.this.maE.mo23631T(0, "");
            }
            FaceDetectView.btJ();
            AppMethodBeat.m2505o(622);
        }
    }

    static /* synthetic */ void btJ() {
    }

    /* renamed from: h */
    static /* synthetic */ void m66318h(FaceDetectView faceDetectView) {
        AppMethodBeat.m2504i(641);
        faceDetectView.btI();
        AppMethodBeat.m2505o(641);
    }

    public FaceDetectView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FaceDetectView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, (byte) 0);
    }

    private FaceDetectView(Context context, AttributeSet attributeSet, int i, byte b) {
        Animation animation;
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(625);
        this.maA = null;
        this.maB = null;
        this.lXH = null;
        this.maC = null;
        this.maD = null;
        this.maE = null;
        this.maG = false;
        this.eTf = false;
        this.isPaused = false;
        this.maH = false;
        this.maI = C4996ah.getContext().getString(C25738R.string.er4);
        this.maJ = true;
        this.maK = false;
        this.lTW = -1;
        this.maL = -1;
        this.maM = -1;
        this.maN = 1500;
        this.maP = null;
        View inflate = LayoutInflater.from(context).inflate(2130970840, null, false);
        addView(inflate);
        this.maA = (FaceDetectCameraView) inflate.findViewById(2131827969);
        this.maB = (FaceDetectDecorView) inflate.findViewById(2131827971);
        this.maP = inflate.findViewById(2131827970);
        this.maA.lZO = new C30581();
        Context context2 = getContext();
        if (context2 == null) {
            C4990ab.m7412e("MicroMsg.MMAnimationEffectLoader", "hy: context is null.");
            animation = null;
        } else {
            animation = AnimationUtils.loadAnimation(context2, C25738R.anim.f8294u);
            animation.setInterpolator(new C23651c());
        }
        this.maO = animation;
        AppMethodBeat.m2505o(625);
    }

    /* renamed from: m */
    public final void mo61942m(boolean z, final String str) {
        AppMethodBeat.m2504i(JsApiShowImageOperateSheet.CTRL_INDEX);
        if (z) {
            C7305d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(C2509f.CTRL_INDEX);
                    final Bitmap Lr = C43036p.m76425Lr(str);
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(620);
                            FaceDetectView.this.maP.setVisibility(0);
                            FaceDetectView.this.maP.setBackgroundDrawable(new BitmapDrawable(Lr));
                            AppMethodBeat.m2505o(620);
                        }
                    });
                    AppMethodBeat.m2505o(C2509f.CTRL_INDEX);
                }
            }, "face_detect_set_backgroud");
            AppMethodBeat.m2505o(JsApiShowImageOperateSheet.CTRL_INDEX);
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setDuration(500);
        alphaAnimation.setFillAfter(true);
        this.maP.startAnimation(alphaAnimation);
        AppMethodBeat.m2505o(JsApiShowImageOperateSheet.CTRL_INDEX);
    }

    private void btI() {
        AppMethodBeat.m2504i(C42466ag.CTRL_INDEX);
        this.lXH.setText("");
        this.lXH.setVisibility(4);
        AppMethodBeat.m2505o(C42466ag.CTRL_INDEX);
    }

    /* renamed from: Lv */
    private void m66307Lv(String str) {
        AppMethodBeat.m2504i(628);
        if (C5046bo.nullAsNil(str).equals(this.lXH.getText().toString())) {
            C4990ab.m7418v("MicroMsg.FaceDetectView", "hy: same error. ignore");
            AppMethodBeat.m2505o(628);
            return;
        }
        this.lXH.setText(str);
        this.lXH.setVisibility(0);
        this.lXH.setAnimation(this.maO);
        AppMethodBeat.m2505o(628);
    }

    public int getCameraRotation() {
        AppMethodBeat.m2504i(629);
        int rotation = this.maA.mae.getRotation();
        AppMethodBeat.m2505o(629);
        return rotation;
    }

    public int getCameraPreivewWidth() {
        AppMethodBeat.m2504i(630);
        int previewWidth = this.maA.mae.getPreviewWidth();
        AppMethodBeat.m2505o(630);
        return previewWidth;
    }

    public int getCameraPreviewHeight() {
        AppMethodBeat.m2504i(631);
        int previewHeight = this.maA.mae.getPreviewHeight();
        AppMethodBeat.m2505o(631);
        return previewHeight;
    }

    public int getCameraBestWidth() {
        AppMethodBeat.m2504i(632);
        int i = this.maA.getEncodeVideoBestSize().x;
        AppMethodBeat.m2505o(632);
        return i;
    }

    public int getCameraBestHeight() {
        AppMethodBeat.m2504i(633);
        int i = this.maA.getEncodeVideoBestSize().y;
        AppMethodBeat.m2505o(633);
        return i;
    }

    public C11803b getCurrentMotionCancelInfo() {
        AppMethodBeat.m2504i(C42559c.CTRL_INDEX);
        C11803b bsY;
        if (this.maF != null) {
            bsY = this.maF.bsY();
            AppMethodBeat.m2505o(C42559c.CTRL_INDEX);
            return bsY;
        }
        bsY = new C11803b(90004, "user cancelled in processing");
        AppMethodBeat.m2505o(C42559c.CTRL_INDEX);
        return bsY;
    }

    /* renamed from: hc */
    public final void mo61941hc(boolean z) {
        AppMethodBeat.m2504i(C42558b.CTRL_INDEX);
        if (this.maF != null) {
            this.maF.bsX();
        }
        if (this.eTf) {
            C4990ab.m7420w("MicroMsg.FaceDetectView", "hy: already end");
            AppMethodBeat.m2505o(C42558b.CTRL_INDEX);
            return;
        }
        this.eTf = true;
        if (z) {
            if (this.maA != null) {
                C11810f.m19659V(new C341165());
            }
        } else if (this.maA != null) {
            this.maA.btC();
        }
        C4990ab.m7416i("MicroMsg.FaceDetectView", "hy: stopped capture face");
        this.maH = false;
        btI();
        AppMethodBeat.m2505o(C42558b.CTRL_INDEX);
    }

    public void setCallback(C11821a c11821a) {
        this.maE = c11821a;
    }

    public void setErrTextView(TextView textView) {
        this.lXH = textView;
    }

    public Bitmap getPreviewBm() {
        AppMethodBeat.m2504i(636);
        Bitmap bitmap = this.maA.getBitmap();
        AppMethodBeat.m2505o(636);
        return bitmap;
    }

    public void setBusinessTip(String str) {
        this.lXd = str;
    }

    /* renamed from: e */
    static /* synthetic */ void m66315e(FaceDetectView faceDetectView) {
        AppMethodBeat.m2504i(639);
        if (faceDetectView.maF != null && faceDetectView.maF.bsV()) {
            C4990ab.m7416i("MicroMsg.FaceDetectView", "hy: meet require");
            faceDetectView.maA.btD();
            faceDetectView.isPaused = true;
            long az = C5046bo.m7525az(faceDetectView.maL);
            C4990ab.m7417i("MicroMsg.FaceDetectView", "hy: current motion used time: %d", Long.valueOf(az));
            if (az < faceDetectView.lTW - 5) {
                C5004al.m7442n(new C390263(), faceDetectView.lTW - az);
                AppMethodBeat.m2505o(639);
                return;
            } else if (!(faceDetectView.maE == null || faceDetectView.eTf)) {
                faceDetectView.maE.mo23631T(0, "");
            }
        }
        AppMethodBeat.m2505o(639);
    }

    /* renamed from: f */
    static /* synthetic */ boolean m66316f(FaceDetectView faceDetectView) {
        AppMethodBeat.m2504i(640);
        long yz = C5046bo.m7588yz();
        C4990ab.m7411d("MicroMsg.FaceDetectView", "hy: tick between: %d, threshold: %d", Long.valueOf(yz - faceDetectView.maM), Integer.valueOf(1500));
        if (yz - faceDetectView.maM > 1500) {
            faceDetectView.maM = yz;
            AppMethodBeat.m2505o(640);
            return true;
        }
        AppMethodBeat.m2505o(640);
        return false;
    }
}
