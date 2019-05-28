package com.tencent.mm.plugin.facedetect.views;

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
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.jsapi.bb;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.be;
import com.tencent.mm.plugin.appbrand.weishi.f;
import com.tencent.mm.plugin.facedetect.d.b;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetect.model.q;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.c.a.c;

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
    private a maE;
    public b maF;
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

    /* renamed from: com.tencent.mm.plugin.facedetect.views.FaceDetectView$4 */
    public class AnonymousClass4 implements c {
        final /* synthetic */ c maV;

        public AnonymousClass4(c cVar) {
            this.maV = cVar;
        }

        public final void vt(int i) {
            AppMethodBeat.i(623);
            ab.i("MicroMsg.FaceDetectView", "hy: camera preview init done : %d", Integer.valueOf(i));
            if (i == 0) {
                FaceDetectView.this.maH = false;
                FaceDetectView.h(FaceDetectView.this);
            }
            if (this.maV != null) {
                this.maV.vt(i);
            }
            AppMethodBeat.o(623);
        }
    }

    static /* synthetic */ void btJ() {
    }

    static /* synthetic */ void h(FaceDetectView faceDetectView) {
        AppMethodBeat.i(641);
        faceDetectView.btI();
        AppMethodBeat.o(641);
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
        AppMethodBeat.i(625);
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
        this.maI = ah.getContext().getString(R.string.er4);
        this.maJ = true;
        this.maK = false;
        this.lTW = -1;
        this.maL = -1;
        this.maM = -1;
        this.maN = 1500;
        this.maP = null;
        View inflate = LayoutInflater.from(context).inflate(R.layout.axd, null, false);
        addView(inflate);
        this.maA = (FaceDetectCameraView) inflate.findViewById(R.id.eop);
        this.maB = (FaceDetectDecorView) inflate.findViewById(R.id.eor);
        this.maP = inflate.findViewById(R.id.eoq);
        this.maA.lZO = new b() {
            public final void a(int i, CharSequence charSequence) {
                AppMethodBeat.i(be.CTRL_INDEX);
                ab.e("MicroMsg.FaceDetectView", "hy: onDetectError: %d, %s", Integer.valueOf(i), charSequence);
                if (FaceDetectView.this.eTf || FaceDetectView.this.isPaused) {
                    ab.w("MicroMsg.FaceDetectView", "hy: already end or paused");
                    AppMethodBeat.o(be.CTRL_INDEX);
                } else if (FaceDetectView.this.maF == null || !FaceDetectView.this.maF.bsW()) {
                    FaceDetectView.this.hc(false);
                    FaceDetectView.this.maH = true;
                    FaceDetectView.a(FaceDetectView.this, charSequence != null ? charSequence.toString() : FaceDetectView.this.getContext().getString(R.string.bjk));
                    if (FaceDetectView.this.maE != null) {
                        FaceDetectView.this.maE.T(i, charSequence != null ? charSequence.toString() : FaceDetectView.this.getContext().getString(R.string.bjk));
                    }
                    AppMethodBeat.o(be.CTRL_INDEX);
                } else {
                    ab.e("MicroMsg.FaceDetectView", "hy: motion eat result");
                    FaceDetectView.a(FaceDetectView.this, FaceDetectView.this.maF.bsZ());
                    AppMethodBeat.o(be.CTRL_INDEX);
                }
            }

            public final void d(FaceCharacteristicsResult faceCharacteristicsResult) {
                AppMethodBeat.i(bc.CTRL_INDEX);
                ab.d("MicroMsg.FaceDetectView", "hy: onDetectSucceed: %s", faceCharacteristicsResult.toString());
                if (FaceDetectView.this.eTf || FaceDetectView.this.isPaused) {
                    ab.w("MicroMsg.FaceDetectView", "hy: already end pr paused");
                    AppMethodBeat.o(bc.CTRL_INDEX);
                } else if (FaceDetectView.this.maF == null || !FaceDetectView.this.maF.b(faceCharacteristicsResult)) {
                    FaceDetectView.this.maH = false;
                    if ((FaceDetectView.this.maF != null && FaceDetectView.this.maF.bsV()) || FaceDetectView.f(FaceDetectView.this)) {
                        FaceDetectView.h(FaceDetectView.this);
                        FaceDetectView.e(FaceDetectView.this);
                    }
                    AppMethodBeat.o(bc.CTRL_INDEX);
                } else {
                    ab.e("MicroMsg.FaceDetectView", "hy: motion eat result");
                    FaceDetectView.a(FaceDetectView.this, FaceDetectView.this.maF.bsZ());
                    AppMethodBeat.o(bc.CTRL_INDEX);
                }
            }

            public final void c(FaceCharacteristicsResult faceCharacteristicsResult) {
                AppMethodBeat.i(bb.CTRL_INDEX);
                int i = faceCharacteristicsResult.errCode;
                String str = faceCharacteristicsResult.aIm;
                ab.v("MicroMsg.FaceDetectView", "hy: onDetectHelp: %d, %s", Integer.valueOf(i), str);
                if (FaceDetectView.this.eTf || FaceDetectView.this.isPaused) {
                    ab.w("MicroMsg.FaceDetectView", "hy: already end");
                    AppMethodBeat.o(bb.CTRL_INDEX);
                } else if (FaceDetectView.this.maF == null || !FaceDetectView.this.maF.a(faceCharacteristicsResult)) {
                    FaceDetectView.e(FaceDetectView.this);
                    if (!FaceDetectView.f(FaceDetectView.this)) {
                        AppMethodBeat.o(bb.CTRL_INDEX);
                    } else if (FaceDetectView.this.maJ || !(faceCharacteristicsResult.errCode == 10 || faceCharacteristicsResult.errCode == 11)) {
                        FaceDetectView.this.maH = FaceCharacteristicsResult.vh(i);
                        FaceDetectView faceDetectView = FaceDetectView.this;
                        if (str == null) {
                            str = "";
                        }
                        FaceDetectView.a(faceDetectView, str);
                        AppMethodBeat.o(bb.CTRL_INDEX);
                    } else {
                        AppMethodBeat.o(bb.CTRL_INDEX);
                    }
                } else {
                    ab.e("MicroMsg.FaceDetectView", "hy: motion eat result");
                    FaceDetectView.a(FaceDetectView.this, FaceDetectView.this.maF.bsZ());
                    AppMethodBeat.o(bb.CTRL_INDEX);
                }
            }
        };
        Context context2 = getContext();
        if (context2 == null) {
            ab.e("MicroMsg.MMAnimationEffectLoader", "hy: context is null.");
            animation = null;
        } else {
            animation = AnimationUtils.loadAnimation(context2, R.anim.u);
            animation.setInterpolator(new c());
        }
        this.maO = animation;
        AppMethodBeat.o(625);
    }

    public final void m(boolean z, final String str) {
        AppMethodBeat.i(JsApiShowImageOperateSheet.CTRL_INDEX);
        if (z) {
            d.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(f.CTRL_INDEX);
                    final Bitmap Lr = p.Lr(str);
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(620);
                            FaceDetectView.this.maP.setVisibility(0);
                            FaceDetectView.this.maP.setBackgroundDrawable(new BitmapDrawable(Lr));
                            AppMethodBeat.o(620);
                        }
                    });
                    AppMethodBeat.o(f.CTRL_INDEX);
                }
            }, "face_detect_set_backgroud");
            AppMethodBeat.o(JsApiShowImageOperateSheet.CTRL_INDEX);
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setDuration(500);
        alphaAnimation.setFillAfter(true);
        this.maP.startAnimation(alphaAnimation);
        AppMethodBeat.o(JsApiShowImageOperateSheet.CTRL_INDEX);
    }

    private void btI() {
        AppMethodBeat.i(ag.CTRL_INDEX);
        this.lXH.setText("");
        this.lXH.setVisibility(4);
        AppMethodBeat.o(ag.CTRL_INDEX);
    }

    private void Lv(String str) {
        AppMethodBeat.i(628);
        if (bo.nullAsNil(str).equals(this.lXH.getText().toString())) {
            ab.v("MicroMsg.FaceDetectView", "hy: same error. ignore");
            AppMethodBeat.o(628);
            return;
        }
        this.lXH.setText(str);
        this.lXH.setVisibility(0);
        this.lXH.setAnimation(this.maO);
        AppMethodBeat.o(628);
    }

    public int getCameraRotation() {
        AppMethodBeat.i(629);
        int rotation = this.maA.mae.getRotation();
        AppMethodBeat.o(629);
        return rotation;
    }

    public int getCameraPreivewWidth() {
        AppMethodBeat.i(630);
        int previewWidth = this.maA.mae.getPreviewWidth();
        AppMethodBeat.o(630);
        return previewWidth;
    }

    public int getCameraPreviewHeight() {
        AppMethodBeat.i(631);
        int previewHeight = this.maA.mae.getPreviewHeight();
        AppMethodBeat.o(631);
        return previewHeight;
    }

    public int getCameraBestWidth() {
        AppMethodBeat.i(632);
        int i = this.maA.getEncodeVideoBestSize().x;
        AppMethodBeat.o(632);
        return i;
    }

    public int getCameraBestHeight() {
        AppMethodBeat.i(633);
        int i = this.maA.getEncodeVideoBestSize().y;
        AppMethodBeat.o(633);
        return i;
    }

    public b.b getCurrentMotionCancelInfo() {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.c.CTRL_INDEX);
        b.b bsY;
        if (this.maF != null) {
            bsY = this.maF.bsY();
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.c.CTRL_INDEX);
            return bsY;
        }
        bsY = new b.b(90004, "user cancelled in processing");
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.c.CTRL_INDEX);
        return bsY;
    }

    public final void hc(boolean z) {
        AppMethodBeat.i(com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.b.CTRL_INDEX);
        if (this.maF != null) {
            this.maF.bsX();
        }
        if (this.eTf) {
            ab.w("MicroMsg.FaceDetectView", "hy: already end");
            AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.b.CTRL_INDEX);
            return;
        }
        this.eTf = true;
        if (z) {
            if (this.maA != null) {
                com.tencent.mm.plugin.facedetect.model.f.V(new Runnable() {
                    final /* synthetic */ q lVX = null;

                    public final void run() {
                        AppMethodBeat.i(624);
                        FaceDetectView.this.maA.btD();
                        if (this.lVX != null) {
                            this.lVX.b(FaceDetectView.this.maA.btF());
                        }
                        AppMethodBeat.o(624);
                    }
                });
            }
        } else if (this.maA != null) {
            this.maA.btC();
        }
        ab.i("MicroMsg.FaceDetectView", "hy: stopped capture face");
        this.maH = false;
        btI();
        AppMethodBeat.o(com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.b.CTRL_INDEX);
    }

    public void setCallback(a aVar) {
        this.maE = aVar;
    }

    public void setErrTextView(TextView textView) {
        this.lXH = textView;
    }

    public Bitmap getPreviewBm() {
        AppMethodBeat.i(636);
        Bitmap bitmap = this.maA.getBitmap();
        AppMethodBeat.o(636);
        return bitmap;
    }

    public void setBusinessTip(String str) {
        this.lXd = str;
    }

    static /* synthetic */ void e(FaceDetectView faceDetectView) {
        AppMethodBeat.i(639);
        if (faceDetectView.maF != null && faceDetectView.maF.bsV()) {
            ab.i("MicroMsg.FaceDetectView", "hy: meet require");
            faceDetectView.maA.btD();
            faceDetectView.isPaused = true;
            long az = bo.az(faceDetectView.maL);
            ab.i("MicroMsg.FaceDetectView", "hy: current motion used time: %d", Long.valueOf(az));
            if (az < faceDetectView.lTW - 5) {
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(622);
                        if (!(FaceDetectView.this.maE == null || FaceDetectView.this.eTf)) {
                            FaceDetectView.this.maE.T(0, "");
                        }
                        FaceDetectView.btJ();
                        AppMethodBeat.o(622);
                    }
                }, faceDetectView.lTW - az);
                AppMethodBeat.o(639);
                return;
            } else if (!(faceDetectView.maE == null || faceDetectView.eTf)) {
                faceDetectView.maE.T(0, "");
            }
        }
        AppMethodBeat.o(639);
    }

    static /* synthetic */ boolean f(FaceDetectView faceDetectView) {
        AppMethodBeat.i(640);
        long yz = bo.yz();
        ab.d("MicroMsg.FaceDetectView", "hy: tick between: %d, threshold: %d", Long.valueOf(yz - faceDetectView.maM), Integer.valueOf(1500));
        if (yz - faceDetectView.maM > 1500) {
            faceDetectView.maM = yz;
            AppMethodBeat.o(640);
            return true;
        }
        AppMethodBeat.o(640);
        return false;
    }
}
