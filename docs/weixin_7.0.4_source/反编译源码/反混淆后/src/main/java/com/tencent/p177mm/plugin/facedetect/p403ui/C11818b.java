package com.tencent.p177mm.plugin.facedetect.p403ui;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

/* renamed from: com.tencent.mm.plugin.facedetect.ui.b */
public final class C11818b extends C34109a {
    private Button lWA;
    private Button lWE;
    private TextView lWG;
    private ViewGroup lYe;
    private ImageView lYf;
    private RelativeLayout lYg;
    private RelativeLayout lYh;
    private RelativeLayout lYi;
    private ImageView lYj;
    private ImageView lYk;
    private ImageView lYl;
    private TextView lYm;
    private TextView lYn;
    private TextView lYo;

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.b$2 */
    class C118192 implements Runnable {
        C118192() {
        }

        public final void run() {
            AppMethodBeat.m2504i(507);
            C11818b.this.lYe.setVisibility(4);
            AppMethodBeat.m2505o(507);
        }
    }

    /* renamed from: com.tencent.mm.plugin.facedetect.ui.b$1 */
    class C118201 implements Runnable {
        C118201() {
        }

        public final void run() {
            AppMethodBeat.m2504i(506);
            TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) C11818b.this.lYj.getHeight());
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
            animationSet.setRepeatCount(-1);
            C11818b.this.lYk.startAnimation(animationSet);
            AppMethodBeat.m2505o(506);
        }
    }

    C11818b(FaceDetectPrepareUI faceDetectPrepareUI) {
        super(faceDetectPrepareUI);
    }

    public final void create() {
        AppMethodBeat.m2504i(ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_OPENINQB);
        synchronized (((FaceDetectPrepareUI) this.lWJ.get())) {
            try {
                if (this.lWJ.get() != null) {
                    this.lYe = (ViewGroup) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(2131823811);
                    this.lYf = (ImageView) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(2131823812);
                    this.lYg = (RelativeLayout) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(2131823751);
                    this.lYh = (RelativeLayout) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(2131823747);
                    this.lYi = (RelativeLayout) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(2131823742);
                    this.lYj = (ImageView) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(2131823753);
                    this.lYk = (ImageView) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(2131823752);
                    this.lYl = (ImageView) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(2131823749);
                    this.lWE = (Button) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(2131823815);
                    this.lWA = (Button) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(2131823813);
                    this.lWG = (TextView) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(2131823814);
                    this.lYm = (TextView) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(2131823754);
                    this.lYn = (TextView) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(2131823750);
                    this.lYo = (TextView) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(2131823744);
                    this.lYe.setVisibility(8);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_OPENINQB);
            }
        }
    }

    /* renamed from: a */
    public final void mo23624a(C3048c c3048c) {
        AppMethodBeat.m2504i(509);
        C4990ab.m7417i("MicroMsg.FaceReflectJumper", "show config: %s", c3048c);
        this.lYe.setVisibility(0);
        if (c3048c.lYz) {
            if (c3048c.lYP != null) {
                this.lWE.setOnClickListener(c3048c.lYP);
            }
            this.lWE.setVisibility(0);
            if (!C5046bo.isNullOrNil(c3048c.lYI)) {
                this.lWE.setText(c3048c.lYI);
            }
        } else {
            this.lWE.setVisibility(8);
        }
        if (c3048c.lYw) {
            if (c3048c.lYM != null) {
                this.lWA.setOnClickListener(c3048c.lYM);
            }
            this.lWA.setVisibility(0);
            if (!C5046bo.isNullOrNil(c3048c.lYG)) {
                this.lWA.setText(c3048c.lYG);
            }
        } else {
            this.lWA.setVisibility(8);
        }
        if (c3048c.lYC) {
            if (c3048c.lYO != null) {
                this.lWG.setClickable(true);
                this.lWG.setOnClickListener(c3048c.lYO);
            }
            this.lWG.setVisibility(0);
            if (!C5046bo.isNullOrNil(c3048c.lYK)) {
                this.lWG.setText(c3048c.lYK);
            }
        } else {
            this.lWG.setVisibility(8);
        }
        if (c3048c.lYE != null) {
            this.lYf.setImageBitmap(c3048c.lYE);
        }
        switch (c3048c.status) {
            case 1:
                if (!C5046bo.isNullOrNil(c3048c.lYF)) {
                    this.lYm.setText(c3048c.lYF);
                }
                C4990ab.m7416i("MicroMsg.FaceReflectJumper", "checking animation");
                this.lYg.setVisibility(0);
                this.lYh.setVisibility(8);
                this.lYi.setVisibility(8);
                this.lYj.post(new C118201());
                AppMethodBeat.m2505o(509);
                return;
            case 2:
                if (!C5046bo.isNullOrNil(c3048c.lYF)) {
                    this.lYn.setText(c3048c.lYF);
                }
                C4990ab.m7416i("MicroMsg.FaceReflectJumper", "check success animation");
                this.lYk.clearAnimation();
                this.lYg.setVisibility(8);
                this.lYh.setVisibility(0);
                this.lYg.setVisibility(8);
                this.lYi.setVisibility(8);
                this.lYl.setScaleX(0.0f);
                this.lYl.setScaleY(0.0f);
                this.lYl.animate().scaleX(1.0f).scaleY(1.0f).setDuration(800);
                AppMethodBeat.m2505o(509);
                return;
            case 3:
                if (!C5046bo.isNullOrNil(c3048c.lYF)) {
                    this.lYo.setText(c3048c.lYF);
                }
                C4990ab.m7416i("MicroMsg.FaceReflectJumper", "check failed animation");
                this.lYh.setVisibility(8);
                this.lYg.setVisibility(8);
                this.lYi.setVisibility(0);
                this.lYk.clearAnimation();
                this.lYg.setVisibility(8);
                break;
        }
        AppMethodBeat.m2505o(509);
    }

    public final void dismiss() {
        AppMethodBeat.m2504i(510);
        C4990ab.m7409c("MicroMsg.FaceReflectJumper", "dismiss jumper", new Object[0]);
        if (this.lWJ.get() != null) {
            ((FaceDetectPrepareUI) this.lWJ.get()).runOnUiThread(new C118192());
        }
        AppMethodBeat.m2505o(510);
    }

    /* renamed from: M */
    public final void mo23623M(Bitmap bitmap) {
        AppMethodBeat.m2504i(ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_MINIQBFAILED);
        this.lYf.setImageBitmap(bitmap);
        AppMethodBeat.m2505o(ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_MINIQBFAILED);
    }

    public final void resetAll() {
        AppMethodBeat.m2504i(512);
        this.lYg.setVisibility(8);
        this.lYh.setVisibility(8);
        this.lYi.setVisibility(8);
        this.lWE.setVisibility(8);
        this.lWG.setVisibility(8);
        this.lWA.setVisibility(8);
        AppMethodBeat.m2505o(512);
    }

    public final boolean aFF() {
        AppMethodBeat.m2504i(513);
        if (this.lYe.getVisibility() == 0) {
            AppMethodBeat.m2505o(513);
            return true;
        }
        AppMethodBeat.m2505o(513);
        return false;
    }
}
