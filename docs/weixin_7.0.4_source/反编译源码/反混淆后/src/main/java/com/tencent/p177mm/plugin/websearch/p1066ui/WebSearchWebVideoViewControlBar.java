package com.tencent.p177mm.plugin.websearch.p1066ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

/* renamed from: com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar */
public class WebSearchWebVideoViewControlBar extends WebSearchVideoPlayerSeekBar {
    private static int ucq = -1;
    private ImageView hZC;
    private FrameLayout hZD;
    private ImageView hZE;
    public C7564ap hZK;
    public C7564ap hZL;
    public boolean hZM;
    private ImageView hZz;
    protected RelativeLayout kGo;
    private ImageView uco;
    private C40199a ucp;

    /* renamed from: com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar$1 */
    class C227631 implements C5015a {
        C227631() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(73836);
            WebSearchWebVideoViewControlBar.this.setVisibility(8);
            WebSearchWebVideoViewControlBar.this.hZK.stopTimer();
            AppMethodBeat.m2505o(73836);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar$2 */
    public class C227642 implements C5015a {
        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(73837);
            if (WebSearchWebVideoViewControlBar.m68941b(WebSearchWebVideoViewControlBar.this)) {
                AppMethodBeat.m2505o(73837);
                return true;
            }
            AppMethodBeat.m2505o(73837);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.ui.WebSearchWebVideoViewControlBar$a */
    public interface C40199a {
        int aFg();

        int aFh();

        int cVN();
    }

    /* renamed from: b */
    static /* synthetic */ boolean m68941b(WebSearchWebVideoViewControlBar webSearchWebVideoViewControlBar) {
        AppMethodBeat.m2504i(73859);
        boolean aFP = webSearchWebVideoViewControlBar.aFP();
        AppMethodBeat.m2505o(73859);
        return aFP;
    }

    public WebSearchWebVideoViewControlBar(Context context) {
        super(context);
    }

    public WebSearchWebVideoViewControlBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WebSearchWebVideoViewControlBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setStatePorter(C40199a c40199a) {
        this.ucp = c40199a;
    }

    public int getLayoutId() {
        return 2130969643;
    }

    public final void init() {
        AppMethodBeat.m2504i(73838);
        super.init();
        this.hZz = (ImageView) this.contentView.findViewById(2131821430);
        this.hZE = (ImageView) this.contentView.findViewById(2131824286);
        this.hZC = (ImageView) this.contentView.findViewById(2131821424);
        this.hZD = (FrameLayout) this.contentView.findViewById(2131821422);
        this.kGo = (RelativeLayout) findViewById(2131820987);
        this.uco = (ImageView) this.contentView.findViewById(2131821418);
        if (ucq < 0) {
            ucq = getResources().getDimensionPixelSize(C25738R.dimen.a2f);
        }
        AppMethodBeat.m2505o(73838);
    }

    public void setIsPlay(boolean z) {
        AppMethodBeat.m2504i(73839);
        this.cAW = z;
        cVL();
        AppMethodBeat.m2505o(73839);
    }

    public int getBarPointWidth() {
        AppMethodBeat.m2504i(73840);
        int width = this.qyn.getWidth();
        AppMethodBeat.m2505o(73840);
        return width;
    }

    private void cVL() {
        AppMethodBeat.m2504i(73841);
        if (this.hZM) {
            if (this.cAW) {
                this.qyo.setImageResource(C25738R.drawable.b6g);
                AppMethodBeat.m2505o(73841);
                return;
            }
            this.qyo.setImageResource(C25738R.drawable.b6k);
            AppMethodBeat.m2505o(73841);
        } else if (this.cAW) {
            this.qyo.setImageResource(C25738R.drawable.b6g);
            AppMethodBeat.m2505o(73841);
        } else {
            this.qyo.setImageResource(C25738R.drawable.b6k);
            AppMethodBeat.m2505o(73841);
        }
    }

    /* renamed from: NO */
    public final void mo63539NO() {
        AppMethodBeat.m2504i(73842);
        this.hZE.setImageResource(C25738R.drawable.b6m);
        AppMethodBeat.m2505o(73842);
    }

    public final void cVM() {
        AppMethodBeat.m2504i(73843);
        this.hZE.setImageResource(C25738R.drawable.b6j);
        AppMethodBeat.m2505o(73843);
    }

    public void setMuteBtnOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(73844);
        this.hZE.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(73844);
    }

    public void setEnterFullScreenBtnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(73845);
        this.hZz.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(73845);
    }

    public void setExitFullScreenBtnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(73846);
        this.uco.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(73846);
    }

    private void aFC() {
        AppMethodBeat.m2504i(73847);
        if (this.hZM) {
            this.hZz.setImageResource(C1318a.fts_web_video_fullscreen_op_fullscreen_btn);
            this.hZz.setVisibility(8);
            this.uco.setVisibility(0);
            AppMethodBeat.m2505o(73847);
            return;
        }
        this.uco.setVisibility(8);
        this.hZz.setVisibility(0);
        this.hZz.setImageResource(C25738R.drawable.b6i);
        AppMethodBeat.m2505o(73847);
    }

    public final void cHd() {
        AppMethodBeat.m2504i(73848);
        if (this.hZK != null) {
            this.hZK.stopTimer();
        }
        AppMethodBeat.m2505o(73848);
    }

    public final void aFE() {
        AppMethodBeat.m2504i(73849);
        if (this.hZK != null) {
            this.hZK.stopTimer();
            this.hZK.mo16770ae(FaceGestureDetGLThread.BRIGHTNESS_DURATION, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        AppMethodBeat.m2505o(73849);
    }

    public final void aDF() {
        AppMethodBeat.m2504i(73851);
        this.hZM = false;
        aFJ();
        AppMethodBeat.m2505o(73851);
    }

    public final void aFJ() {
        AppMethodBeat.m2504i(73852);
        aFM();
        aFC();
        cVL();
        aFL();
        AppMethodBeat.m2505o(73852);
    }

    private void aFL() {
        float dimensionPixelSize;
        AppMethodBeat.m2504i(73853);
        if (this.hZM) {
            dimensionPixelSize = (float) getResources().getDimensionPixelSize(C25738R.dimen.a2e);
        } else {
            dimensionPixelSize = (float) getResources().getDimensionPixelSize(C25738R.dimen.a2c);
        }
        this.qyp.setTextSize(0, dimensionPixelSize);
        this.qyq.setTextSize(0, dimensionPixelSize);
        AppMethodBeat.m2505o(73853);
    }

    private void aFM() {
        AppMethodBeat.m2504i(73854);
        LayoutParams layoutParams = this.kGo.getLayoutParams();
        if (this.hZM) {
            layoutParams.height = getResources().getDimensionPixelSize(C25738R.dimen.a2d);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(C25738R.dimen.a2b);
        }
        this.kGo.setLayoutParams(layoutParams);
        AppMethodBeat.m2505o(73854);
    }

    public final boolean aFP() {
        AppMethodBeat.m2504i(73855);
        if (this.ucp == null) {
            C4990ab.m7416i("MicroMsg.FtsWebVideoViewControlBar", "updateMiddleBar mStatePorter null");
            AppMethodBeat.m2505o(73855);
            return false;
        }
        int aFg = this.ucp.aFg();
        int aFh = this.ucp.aFh();
        if (aFg < 0 || aFh < 0) {
            AppMethodBeat.m2505o(73855);
            return false;
        }
        int width = this.hZD.getWidth();
        if (width <= 0) {
            AppMethodBeat.m2505o(73855);
            return true;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hZC.getLayoutParams();
        if (aFh != 0) {
            width = (int) (((float) width) * (1.0f - (((float) aFg) / ((float) aFh))));
        }
        if (width <= 0) {
            width = 0;
        }
        layoutParams.rightMargin = width + ucq;
        this.hZC.setLayoutParams(layoutParams);
        if (aFg < aFh || aFh == 0) {
            AppMethodBeat.m2505o(73855);
            return true;
        }
        AppMethodBeat.m2505o(73855);
        return false;
    }

    public final void cHe() {
        AppMethodBeat.m2504i(73856);
        this.qyo.setVisibility(8);
        AppMethodBeat.m2505o(73856);
    }

    public final void cHf() {
        AppMethodBeat.m2504i(73857);
        this.qyo.setVisibility(0);
        AppMethodBeat.m2505o(73857);
    }

    /* renamed from: Dq */
    public final void mo27328Dq(int i) {
        AppMethodBeat.m2504i(73858);
        seek((int) Math.ceil((((double) this.ucp.cVN()) * 1.0d) / 1000.0d));
        AppMethodBeat.m2505o(73858);
    }

    /* Access modifiers changed, original: protected */
    public ImageView getExitFullscreenIv() {
        return this.uco;
    }

    /* renamed from: nG */
    public final void mo63549nG(boolean z) {
        int i;
        AppMethodBeat.m2504i(73850);
        if (getVisibility() == 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            setVisibility(8);
            AppMethodBeat.m2505o(73850);
            return;
        }
        setVisibility(0);
        if (z) {
            cHe();
        } else {
            cHf();
        }
        if (this.hZK == null) {
            this.hZK = new C7564ap(new C227631(), false);
        }
        this.hZK.stopTimer();
        this.hZK.mo16770ae(FaceGestureDetGLThread.BRIGHTNESS_DURATION, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        AppMethodBeat.m2505o(73850);
    }
}
