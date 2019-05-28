package com.tencent.p177mm.plugin.voip.widget;

import android.content.Context;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.p230g.p231a.C26171jl;
import com.tencent.p177mm.p612ui.base.MMTextureView;
import com.tencent.p177mm.plugin.voip.C43727b;
import com.tencent.p177mm.plugin.voip.p546ui.C46324c;
import com.tencent.p177mm.plugin.voip.video.C40041b;
import com.tencent.p177mm.plugin.voip.video.CaptureView;
import com.tencent.p177mm.plugin.voip.video.OpenGlRender;
import com.tencent.p177mm.plugin.voip.video.OpenGlView;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

/* renamed from: com.tencent.mm.plugin.voip.widget.a */
public final class C43742a extends BaseSmallView {
    /* renamed from: UO */
    private boolean f17226UO;
    private C7306ak iGP = new C7306ak(Looper.getMainLooper());
    private C4884c sWj = new C295153();
    private int sXS;
    private OpenGlRender tcd;
    private OpenGlView tce;
    private OpenGlRender tcf;
    private OpenGlView tcg;
    private int[] tch = null;
    private int tci = 0;
    private float tcj;
    private int tck = 0;
    private Runnable tcl = new C295141();
    private Runnable tcm = new C140912();

    /* renamed from: com.tencent.mm.plugin.voip.widget.a$2 */
    class C140912 implements Runnable {
        C140912() {
        }

        public final void run() {
            AppMethodBeat.m2504i(5138);
            C4990ab.m7416i("MicroMsg.Voip.TalkingSmallView", "on mShowLocalView");
            if (C43742a.this.tcg.tbe) {
                C43742a.this.tcf.mo63364mD(false);
            }
            C43742a.this.tcg.setVisibility(0);
            AppMethodBeat.m2505o(5138);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.widget.a$1 */
    class C295141 implements Runnable {
        C295141() {
        }

        public final void run() {
            AppMethodBeat.m2504i(5137);
            C4990ab.m7416i("MicroMsg.Voip.TalkingSmallView", "on mDismissLocalView");
            if (C43742a.this.tcg.tbe) {
                C43742a.this.tcf.mo63364mD(true);
                AppMethodBeat.m2505o(5137);
                return;
            }
            C43742a.this.tcg.setVisibility(4);
            AppMethodBeat.m2505o(5137);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.widget.a$3 */
    class C295153 extends C4884c<C26171jl> {

        /* renamed from: com.tencent.mm.plugin.voip.widget.a$3$1 */
        class C295161 implements Runnable {
            C295161() {
            }

            public final void run() {
                AppMethodBeat.m2504i(5139);
                if (!(C43742a.this.sVY == null || C43742a.this.sVY.get() == null)) {
                    boolean cJs = ((C46324c) C43742a.this.sVY.get()).cJs();
                    boolean cJr = ((C46324c) C43742a.this.sVY.get()).cJr();
                    boolean cJk = ((C46324c) C43742a.this.sVY.get()).cJk();
                    C4990ab.m7417i("MicroMsg.Voip.TalkingSmallView", "summerkick LogoutEvent ret[%b, %b, %b]", Boolean.valueOf(cJs), Boolean.valueOf(cJr), Boolean.valueOf(cJk));
                }
                AppMethodBeat.m2505o(5139);
            }
        }

        C295153() {
            AppMethodBeat.m2504i(5140);
            this.xxI = C26171jl.class.getName().hashCode();
            AppMethodBeat.m2505o(5140);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(5141);
            if (((C26171jl) c4883b) instanceof C26171jl) {
                C4990ab.m7417i("MicroMsg.Voip.TalkingSmallView", "summerkick LogoutEvent thread name[%s]", Thread.currentThread().getName());
                C5004al.m7441d(new C295161());
            }
            AppMethodBeat.m2505o(5141);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.widget.a$4 */
    class C295174 implements Runnable {
        C295174() {
        }

        public final void run() {
            AppMethodBeat.m2504i(5142);
            C43742a.this.findViewById(2131828576).setVisibility(8);
            AppMethodBeat.m2505o(5142);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.widget.a$5 */
    class C400435 implements Runnable {
        C400435() {
        }

        public final void run() {
            AppMethodBeat.m2504i(5143);
            C43742a.this.sXQ.setVisibility(4);
            if (C1443d.m3068iW(21)) {
                C43742a.this.tcg.setVisibility(0);
            }
            C43742a.this.tce.setVisibility(0);
            AppMethodBeat.m2505o(5143);
        }
    }

    /* renamed from: com.tencent.mm.plugin.voip.widget.a$6 */
    class C437436 implements Runnable {
        C437436() {
        }

        public final void run() {
            AppMethodBeat.m2504i(5144);
            C43742a.this.sXQ.setVisibility(0);
            if (C1443d.m3068iW(21)) {
                C43742a.this.tcg.setVisibility(0);
            }
            C43742a.this.tce.setVisibility(4);
            AppMethodBeat.m2505o(5144);
        }
    }

    public C43742a(Context context, float f) {
        super(context, null);
        AppMethodBeat.m2504i(5145);
        LayoutInflater.from(context).inflate(2130971037, this);
        this.tcj = f;
        this.tce = (OpenGlView) findViewById(2131828573);
        this.tcd = new OpenGlRender(this.tce, OpenGlRender.RenderRemote);
        this.tce.setRenderer(this.tcd);
        this.tce.setRenderMode(0);
        this.tcg = (OpenGlView) findViewById(2131828575);
        this.tcf = new OpenGlRender(this.tcg, OpenGlRender.RenderLocal);
        if (C1443d.m3068iW(21)) {
            OpenGlView openGlView = this.tcg;
            openGlView.tbe = true;
            if (openGlView.tbe) {
                openGlView.setEGLConfigChooser(new C40041b(8, 8, 8, 8));
            } else {
                openGlView.setEGLConfigChooser(new C40041b(5, 6, 5, 0));
            }
            this.tcg.setZOrderOnTop(true);
            this.tcg.getHolder().setFormat(1);
            OpenGlRender openGlRender = this.tcf;
            C4990ab.m7417i(OpenGlRender.TAG, "setRenderWithNativeGL: %s", Boolean.TRUE);
            openGlRender.taV = true;
        } else {
            this.tcg.setVisibility(4);
            this.tcg.setZOrderMediaOverlay(true);
        }
        this.tcg.setRenderer(this.tcf);
        this.tcg.setRenderMode(0);
        this.f17226UO = false;
        C4879a.xxA.mo10052c(this.sWj);
        this.sXQ = (MMTextureView) findViewById(2131828574);
        if (this.sXQ != null) {
            C4990ab.m7416i("MicroMsg.Voip.TalkingSmallView", "hwViewSmall creat ok!");
        }
        this.lda.postDelayed(new C295174(), 3000);
        this.lda.postDelayed(this.tcm, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        this.lda.postDelayed(this.tcl, 5000);
        AppMethodBeat.m2505o(5145);
    }

    /* renamed from: dY */
    public final void mo69440dY(int i, int i2) {
        AppMethodBeat.m2504i(5146);
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
        AppMethodBeat.m2505o(5146);
    }

    private void cLT() {
        AppMethodBeat.m2504i(5147);
        if (!this.f17226UO) {
            C4990ab.m7417i("MicroMsg.Voip.TalkingSmallView", "startRenderForVideoDisplay, voipBeauty: %s", Integer.valueOf(this.tck));
            this.f17226UO = true;
            this.tcd.taA = true;
            this.tcf.taA = true;
            this.tcf.setVoipBeauty(this.tck);
            this.tcd.setVoipBeauty(this.tck);
        }
        AppMethodBeat.m2505o(5147);
    }

    /* renamed from: c */
    public final void mo69436c(int i, int i2, int[] iArr) {
        AppMethodBeat.m2504i(5148);
        cLT();
        if (OpenGlRender.taQ == 1) {
            this.tcd.mo63360a(iArr, i, i2, OpenGlRender.FLAG_RGBA + OpenGlRender.FLAG_Angle90, false);
            AppMethodBeat.m2505o(5148);
            return;
        }
        this.tcd.mo63360a(iArr, i, i2, OpenGlRender.FLAG_YV12Edge + OpenGlRender.FLAG_Angle90, false);
        AppMethodBeat.m2505o(5148);
    }

    public final void cJD() {
        AppMethodBeat.m2504i(5149);
        if (!(!this.f17226UO || this.tcf == null || this.tcd == null)) {
            this.tcf.cLJ();
            this.tcd.cLJ();
        }
        AppMethodBeat.m2505o(5149);
    }

    public final void setVoipBeauty(int i) {
        AppMethodBeat.m2504i(5150);
        C4990ab.m7417i("MicroMsg.Voip.TalkingSmallView", "setVoipBeauty, mIsStarted:%b, isON:%d", Boolean.valueOf(this.f17226UO), Integer.valueOf(i));
        this.tck = i;
        if (!(!this.f17226UO || this.tcf == null || this.tcd == null)) {
            this.tcf.setVoipBeauty(i);
            this.tcd.setVoipBeauty(i);
        }
        AppMethodBeat.m2505o(5150);
    }

    public final void setHWDecMode(int i) {
        AppMethodBeat.m2504i(5151);
        int i2 = i & 1;
        if (this.iGP != null) {
            if ((i2 != 0 ? 1 : null) == null) {
                C4990ab.m7416i("MicroMsg.Voip.TalkingSmallView", "setHWDecMode, not hwdec");
                this.iGP.post(new C400435());
            } else {
                C4990ab.m7416i("MicroMsg.Voip.TalkingSmallView", "setHWDecMode, is hwdec");
                this.iGP.post(new C437436());
            }
        }
        this.sXS = i;
        AppMethodBeat.m2505o(5151);
    }

    /* renamed from: a */
    public final void mo69435a(byte[] bArr, long j, int i, int i2, int i3, int i4, int i5) {
        AppMethodBeat.m2504i(5152);
        if (this.tcg.getVisibility() != 0) {
            AppMethodBeat.m2505o(5152);
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
            if (C43727b.cIj().mo26344a(bArr, (int) j, i3 & 31, i, i2, this.tch, false) < 0 || this.tch == null) {
                AppMethodBeat.m2505o(5152);
                return;
            }
            this.tcf.mo63360a(this.tch, i, i2, (OpenGlRender.FLAG_RGBAClip + i4) + i5, true);
            AppMethodBeat.m2505o(5152);
            return;
        }
        if (OpenGlRender.taQ == 2) {
            this.tcf.mo63361c(bArr, i, i2, (OpenGlRender.FLAG_NV21 + i4) + i5, true);
        }
        AppMethodBeat.m2505o(5152);
    }

    public final void uninit() {
        AppMethodBeat.m2504i(5153);
        super.uninit();
        C4879a.xxA.mo10053d(this.sWj);
        setVisibility(4);
        if (this.f17226UO) {
            this.tcd.cLI();
            this.tcf.cLI();
        }
        this.lda.removeCallbacks(this.tcl);
        AppMethodBeat.m2505o(5153);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cLq() {
        AppMethodBeat.m2504i(5155);
        C4990ab.m7416i("MicroMsg.Voip.TalkingSmallView", "onMoveStop");
        this.tcg.setVisibility(0);
        if (this.tcg.tbe) {
            this.tcf.mo63364mD(false);
        }
        this.lda.removeCallbacks(this.tcl);
        this.lda.postDelayed(this.tcl, 3000);
        AppMethodBeat.m2505o(5155);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cLr() {
        AppMethodBeat.m2504i(5156);
        this.tcd.cLI();
        this.tcf.cLI();
        AppMethodBeat.m2505o(5156);
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
        AppMethodBeat.m2504i(5154);
        C4990ab.m7408b("MicroMsg.Voip.BaseSmallView", "addCaptureView", new Object[0]);
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
            C4990ab.m7410d("MicroMsg.Voip.BaseSmallView", "CaptureView added");
        }
        AppMethodBeat.m2505o(5154);
    }
}
