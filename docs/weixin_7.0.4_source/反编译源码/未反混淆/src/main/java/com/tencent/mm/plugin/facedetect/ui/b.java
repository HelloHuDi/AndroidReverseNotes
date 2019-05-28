package com.tencent.mm.plugin.facedetect.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

public final class b extends a {
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

    b(FaceDetectPrepareUI faceDetectPrepareUI) {
        super(faceDetectPrepareUI);
    }

    public final void create() {
        AppMethodBeat.i(ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_OPENINQB);
        synchronized (((FaceDetectPrepareUI) this.lWJ.get())) {
            try {
                if (this.lWJ.get() != null) {
                    this.lYe = (ViewGroup) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(R.id.bna);
                    this.lYf = (ImageView) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(R.id.bnb);
                    this.lYg = (RelativeLayout) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(R.id.blo);
                    this.lYh = (RelativeLayout) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(R.id.blk);
                    this.lYi = (RelativeLayout) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(R.id.blf);
                    this.lYj = (ImageView) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(R.id.blq);
                    this.lYk = (ImageView) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(R.id.blp);
                    this.lYl = (ImageView) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(R.id.blm);
                    this.lWE = (Button) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(R.id.bne);
                    this.lWA = (Button) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(R.id.bnc);
                    this.lWG = (TextView) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(R.id.bnd);
                    this.lYm = (TextView) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(R.id.blr);
                    this.lYn = (TextView) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(R.id.bln);
                    this.lYo = (TextView) ((FaceDetectPrepareUI) this.lWJ.get()).findViewById(R.id.blh);
                    this.lYe.setVisibility(8);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_OPENINQB);
            }
        }
    }

    public final void a(c cVar) {
        AppMethodBeat.i(509);
        ab.i("MicroMsg.FaceReflectJumper", "show config: %s", cVar);
        this.lYe.setVisibility(0);
        if (cVar.lYz) {
            if (cVar.lYP != null) {
                this.lWE.setOnClickListener(cVar.lYP);
            }
            this.lWE.setVisibility(0);
            if (!bo.isNullOrNil(cVar.lYI)) {
                this.lWE.setText(cVar.lYI);
            }
        } else {
            this.lWE.setVisibility(8);
        }
        if (cVar.lYw) {
            if (cVar.lYM != null) {
                this.lWA.setOnClickListener(cVar.lYM);
            }
            this.lWA.setVisibility(0);
            if (!bo.isNullOrNil(cVar.lYG)) {
                this.lWA.setText(cVar.lYG);
            }
        } else {
            this.lWA.setVisibility(8);
        }
        if (cVar.lYC) {
            if (cVar.lYO != null) {
                this.lWG.setClickable(true);
                this.lWG.setOnClickListener(cVar.lYO);
            }
            this.lWG.setVisibility(0);
            if (!bo.isNullOrNil(cVar.lYK)) {
                this.lWG.setText(cVar.lYK);
            }
        } else {
            this.lWG.setVisibility(8);
        }
        if (cVar.lYE != null) {
            this.lYf.setImageBitmap(cVar.lYE);
        }
        switch (cVar.status) {
            case 1:
                if (!bo.isNullOrNil(cVar.lYF)) {
                    this.lYm.setText(cVar.lYF);
                }
                ab.i("MicroMsg.FaceReflectJumper", "checking animation");
                this.lYg.setVisibility(0);
                this.lYh.setVisibility(8);
                this.lYi.setVisibility(8);
                this.lYj.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(506);
                        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) b.this.lYj.getHeight());
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
                        b.this.lYk.startAnimation(animationSet);
                        AppMethodBeat.o(506);
                    }
                });
                AppMethodBeat.o(509);
                return;
            case 2:
                if (!bo.isNullOrNil(cVar.lYF)) {
                    this.lYn.setText(cVar.lYF);
                }
                ab.i("MicroMsg.FaceReflectJumper", "check success animation");
                this.lYk.clearAnimation();
                this.lYg.setVisibility(8);
                this.lYh.setVisibility(0);
                this.lYg.setVisibility(8);
                this.lYi.setVisibility(8);
                this.lYl.setScaleX(0.0f);
                this.lYl.setScaleY(0.0f);
                this.lYl.animate().scaleX(1.0f).scaleY(1.0f).setDuration(800);
                AppMethodBeat.o(509);
                return;
            case 3:
                if (!bo.isNullOrNil(cVar.lYF)) {
                    this.lYo.setText(cVar.lYF);
                }
                ab.i("MicroMsg.FaceReflectJumper", "check failed animation");
                this.lYh.setVisibility(8);
                this.lYg.setVisibility(8);
                this.lYi.setVisibility(0);
                this.lYk.clearAnimation();
                this.lYg.setVisibility(8);
                break;
        }
        AppMethodBeat.o(509);
    }

    public final void dismiss() {
        AppMethodBeat.i(510);
        ab.c("MicroMsg.FaceReflectJumper", "dismiss jumper", new Object[0]);
        if (this.lWJ.get() != null) {
            ((FaceDetectPrepareUI) this.lWJ.get()).runOnUiThread(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(507);
                    b.this.lYe.setVisibility(4);
                    AppMethodBeat.o(507);
                }
            });
        }
        AppMethodBeat.o(510);
    }

    public final void M(Bitmap bitmap) {
        AppMethodBeat.i(ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_MINIQBFAILED);
        this.lYf.setImageBitmap(bitmap);
        AppMethodBeat.o(ErrorCode.INFO_CODE_FILEREADER_OPENFILEREADER_MINIQBFAILED);
    }

    public final void resetAll() {
        AppMethodBeat.i(512);
        this.lYg.setVisibility(8);
        this.lYh.setVisibility(8);
        this.lYi.setVisibility(8);
        this.lWE.setVisibility(8);
        this.lWG.setVisibility(8);
        this.lWA.setVisibility(8);
        AppMethodBeat.o(512);
    }

    public final boolean aFF() {
        AppMethodBeat.i(513);
        if (this.lYe.getVisibility() == 0) {
            AppMethodBeat.o(513);
            return true;
        }
        AppMethodBeat.o(513);
        return false;
    }
}
