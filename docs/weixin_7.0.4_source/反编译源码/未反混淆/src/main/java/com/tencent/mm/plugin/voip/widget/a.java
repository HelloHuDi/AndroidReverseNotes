package com.tencent.mm.plugin.voip.widget;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.jl;
import com.tencent.mm.plugin.voip.video.CaptureView;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.OpenGlView;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

public final class a extends BaseSmallView {
    private boolean UO;
    private ak iGP = new ak(Looper.getMainLooper());
    private c sWj = new c<jl>() {
        {
            AppMethodBeat.i(5140);
            this.xxI = jl.class.getName().hashCode();
            AppMethodBeat.o(5140);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(5141);
            if (((jl) bVar) instanceof jl) {
                ab.i("MicroMsg.Voip.TalkingSmallView", "summerkick LogoutEvent thread name[%s]", Thread.currentThread().getName());
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(5139);
                        if (!(a.this.sVY == null || a.this.sVY.get() == null)) {
                            boolean cJs = ((com.tencent.mm.plugin.voip.ui.c) a.this.sVY.get()).cJs();
                            boolean cJr = ((com.tencent.mm.plugin.voip.ui.c) a.this.sVY.get()).cJr();
                            boolean cJk = ((com.tencent.mm.plugin.voip.ui.c) a.this.sVY.get()).cJk();
                            ab.i("MicroMsg.Voip.TalkingSmallView", "summerkick LogoutEvent ret[%b, %b, %b]", Boolean.valueOf(cJs), Boolean.valueOf(cJr), Boolean.valueOf(cJk));
                        }
                        AppMethodBeat.o(5139);
                    }
                });
            }
            AppMethodBeat.o(5141);
            return false;
        }
    };
    private int sXS;
    private OpenGlRender tcd;
    private OpenGlView tce;
    private OpenGlRender tcf;
    private OpenGlView tcg;
    private int[] tch = null;
    private int tci = 0;
    private float tcj;
    private int tck = 0;
    private Runnable tcl = new Runnable() {
        public final void run() {
            AppMethodBeat.i(5137);
            ab.i("MicroMsg.Voip.TalkingSmallView", "on mDismissLocalView");
            if (a.this.tcg.tbe) {
                a.this.tcf.mD(true);
                AppMethodBeat.o(5137);
                return;
            }
            a.this.tcg.setVisibility(4);
            AppMethodBeat.o(5137);
        }
    };
    private Runnable tcm = new Runnable() {
        public final void run() {
            AppMethodBeat.i(5138);
            ab.i("MicroMsg.Voip.TalkingSmallView", "on mShowLocalView");
            if (a.this.tcg.tbe) {
                a.this.tcf.mD(false);
            }
            a.this.tcg.setVisibility(0);
            AppMethodBeat.o(5138);
        }
    };

    public a(Context context, float f) {
        super(context, null);
        AppMethodBeat.i(5145);
        LayoutInflater.from(context).inflate(R.layout.b2l, this);
        this.tcj = f;
        this.tce = (OpenGlView) findViewById(R.id.f51);
        this.tcd = new OpenGlRender(this.tce, OpenGlRender.RenderRemote);
        this.tce.setRenderer(this.tcd);
        this.tce.setRenderMode(0);
        this.tcg = (OpenGlView) findViewById(R.id.f53);
        this.tcf = new OpenGlRender(this.tcg, OpenGlRender.RenderLocal);
        if (d.iW(21)) {
            OpenGlView openGlView = this.tcg;
            openGlView.tbe = true;
            if (openGlView.tbe) {
                openGlView.setEGLConfigChooser(new com.tencent.mm.plugin.voip.video.b(8, 8, 8, 8));
            } else {
                openGlView.setEGLConfigChooser(new com.tencent.mm.plugin.voip.video.b(5, 6, 5, 0));
            }
            this.tcg.setZOrderOnTop(true);
            this.tcg.getHolder().setFormat(1);
            OpenGlRender openGlRender = this.tcf;
            ab.i(OpenGlRender.TAG, "setRenderWithNativeGL: %s", Boolean.TRUE);
            openGlRender.taV = true;
        } else {
            this.tcg.setVisibility(4);
            this.tcg.setZOrderMediaOverlay(true);
        }
        this.tcg.setRenderer(this.tcf);
        this.tcg.setRenderMode(0);
        this.UO = false;
        com.tencent.mm.sdk.b.a.xxA.c(this.sWj);
        this.sXQ = (MMTextureView) findViewById(R.id.f52);
        if (this.sXQ != null) {
            ab.i("MicroMsg.Voip.TalkingSmallView", "hwViewSmall creat ok!");
        }
        this.lda.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(5142);
                a.this.findViewById(R.id.f54).setVisibility(8);
                AppMethodBeat.o(5142);
            }
        }, 3000);
        this.lda.postDelayed(this.tcm, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        this.lda.postDelayed(this.tcl, 5000);
        AppMethodBeat.o(5145);
    }

    public final void dY(int i, int i2) {
        AppMethodBeat.i(5146);
        LayoutParams layoutParams = (LayoutParams) this.tcg.getLayoutParams();
        layoutParams.height = i2 / 4;
        layoutParams.width = (int) (this.tcj * ((float) layoutParams.height));
        this.tcg.setLayoutParams(layoutParams);
        WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new WindowManager.LayoutParams();
        }
        layoutParams2.width = i;
        layoutParams2.height = i2;
        setLayoutParams(layoutParams2);
        AppMethodBeat.o(5146);
    }

    private void cLT() {
        AppMethodBeat.i(5147);
        if (!this.UO) {
            ab.i("MicroMsg.Voip.TalkingSmallView", "startRenderForVideoDisplay, voipBeauty: %s", Integer.valueOf(this.tck));
            this.UO = true;
            this.tcd.taA = true;
            this.tcf.taA = true;
            this.tcf.setVoipBeauty(this.tck);
            this.tcd.setVoipBeauty(this.tck);
        }
        AppMethodBeat.o(5147);
    }

    public final void c(int i, int i2, int[] iArr) {
        AppMethodBeat.i(5148);
        cLT();
        if (OpenGlRender.taQ == 1) {
            this.tcd.a(iArr, i, i2, OpenGlRender.FLAG_RGBA + OpenGlRender.FLAG_Angle90, false);
            AppMethodBeat.o(5148);
            return;
        }
        this.tcd.a(iArr, i, i2, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false);
        AppMethodBeat.o(5148);
    }

    public final void cJD() {
        AppMethodBeat.i(5149);
        if (!(!this.UO || this.tcf == null || this.tcd == null)) {
            this.tcf.cLJ();
            this.tcd.cLJ();
        }
        AppMethodBeat.o(5149);
    }

    public final void setVoipBeauty(int i) {
        AppMethodBeat.i(5150);
        ab.i("MicroMsg.Voip.TalkingSmallView", "setVoipBeauty, mIsStarted:%b, isON:%d", Boolean.valueOf(this.UO), Integer.valueOf(i));
        this.tck = i;
        if (!(!this.UO || this.tcf == null || this.tcd == null)) {
            this.tcf.setVoipBeauty(i);
            this.tcd.setVoipBeauty(i);
        }
        AppMethodBeat.o(5150);
    }

    public final void setHWDecMode(int i) {
        AppMethodBeat.i(5151);
        int i2 = i & 1;
        if (this.iGP != null) {
            if ((i2 != 0 ? 1 : null) == null) {
                ab.i("MicroMsg.Voip.TalkingSmallView", "setHWDecMode, not hwdec");
                this.iGP.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(5143);
                        a.this.sXQ.setVisibility(4);
                        if (d.iW(21)) {
                            a.this.tcg.setVisibility(0);
                        }
                        a.this.tce.setVisibility(0);
                        AppMethodBeat.o(5143);
                    }
                });
            } else {
                ab.i("MicroMsg.Voip.TalkingSmallView", "setHWDecMode, is hwdec");
                this.iGP.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(5144);
                        a.this.sXQ.setVisibility(0);
                        if (d.iW(21)) {
                            a.this.tcg.setVisibility(0);
                        }
                        a.this.tce.setVisibility(4);
                        AppMethodBeat.o(5144);
                    }
                });
            }
        }
        this.sXS = i;
        AppMethodBeat.o(5151);
    }

    public final void a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(5152);
        if (this.tcg.getVisibility() != 0) {
            AppMethodBeat.o(5152);
            return;
        }
        cLT();
        if (OpenGlRender.taQ == 1) {
            if (this.tci < i * i2) {
                this.tch = null;
            }
            if (this.tch == null) {
                this.tci = i * i2;
                this.tch = new int[this.tci];
            }
            if (com.tencent.mm.plugin.voip.b.cIj().a(bArr, (int) j, i3 & 31, i, i2, this.tch, false) < 0 || this.tch == null) {
                AppMethodBeat.o(5152);
                return;
            }
            this.tcf.a(this.tch, i, i2, (OpenGlRender.FLAG_RGBAClip + i4) + i5, true);
            AppMethodBeat.o(5152);
            return;
        }
        if (OpenGlRender.taQ == 2) {
            this.tcf.c(bArr, i, i2, (OpenGlRender.FLAG_NV21 + i4) + i5, true);
        }
        AppMethodBeat.o(5152);
    }

    public final void uninit() {
        AppMethodBeat.i(5153);
        super.uninit();
        com.tencent.mm.sdk.b.a.xxA.d(this.sWj);
        setVisibility(4);
        if (this.UO) {
            this.tcd.cLI();
            this.tcf.cLI();
        }
        this.lda.removeCallbacks(this.tcl);
        AppMethodBeat.o(5153);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cLq() {
        AppMethodBeat.i(5155);
        ab.i("MicroMsg.Voip.TalkingSmallView", "onMoveStop");
        this.tcg.setVisibility(0);
        if (this.tcg.tbe) {
            this.tcf.mD(false);
        }
        this.lda.removeCallbacks(this.tcl);
        this.lda.postDelayed(this.tcl, 3000);
        AppMethodBeat.o(5155);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cLr() {
        AppMethodBeat.i(5156);
        this.tcd.cLI();
        this.tcf.cLI();
        AppMethodBeat.o(5156);
    }

    /* Access modifiers changed, original: protected|final */
    public final void onAnimationEnd() {
        this.tcd.taA = true;
        this.tcf.taA = true;
    }

    public final OpenGlRender getFilterData() {
        return this.tcf;
    }

    public final void setCaptureView(CaptureView captureView) {
        AppMethodBeat.i(5154);
        ab.b("MicroMsg.Voip.BaseSmallView", "addCaptureView", new Object[0]);
        if (this.sRg != null) {
            removeView(this.sRg);
            this.sRg = null;
        }
        if (captureView != null) {
            this.sRg = captureView;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(1, 1);
            layoutParams.leftMargin = 20;
            layoutParams.topMargin = 20;
            addView(captureView, layoutParams);
            captureView.setVisibility(0);
            ab.d("MicroMsg.Voip.BaseSmallView", "CaptureView added");
        }
        AppMethodBeat.o(5154);
    }
}
