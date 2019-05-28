package com.tencent.mm.plugin.websearch.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

public class WebSearchWebVideoViewControlBar extends WebSearchVideoPlayerSeekBar {
    private static int ucq = -1;
    private ImageView hZC;
    private FrameLayout hZD;
    private ImageView hZE;
    public ap hZK;
    public ap hZL;
    public boolean hZM;
    private ImageView hZz;
    protected RelativeLayout kGo;
    private ImageView uco;
    private a ucp;

    public interface a {
        int aFg();

        int aFh();

        int cVN();
    }

    static /* synthetic */ boolean b(WebSearchWebVideoViewControlBar webSearchWebVideoViewControlBar) {
        AppMethodBeat.i(73859);
        boolean aFP = webSearchWebVideoViewControlBar.aFP();
        AppMethodBeat.o(73859);
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

    public void setStatePorter(a aVar) {
        this.ucp = aVar;
    }

    public int getLayoutId() {
        return R.layout.a21;
    }

    public final void init() {
        AppMethodBeat.i(73838);
        super.init();
        this.hZz = (ImageView) this.contentView.findViewById(R.id.x9);
        this.hZE = (ImageView) this.contentView.findViewById(R.id.c05);
        this.hZC = (ImageView) this.contentView.findViewById(R.id.x3);
        this.hZD = (FrameLayout) this.contentView.findViewById(R.id.x1);
        this.kGo = (RelativeLayout) findViewById(R.id.l_);
        this.uco = (ImageView) this.contentView.findViewById(R.id.wx);
        if (ucq < 0) {
            ucq = getResources().getDimensionPixelSize(R.dimen.a2f);
        }
        AppMethodBeat.o(73838);
    }

    public void setIsPlay(boolean z) {
        AppMethodBeat.i(73839);
        this.cAW = z;
        cVL();
        AppMethodBeat.o(73839);
    }

    public int getBarPointWidth() {
        AppMethodBeat.i(73840);
        int width = this.qyn.getWidth();
        AppMethodBeat.o(73840);
        return width;
    }

    private void cVL() {
        AppMethodBeat.i(73841);
        if (this.hZM) {
            if (this.cAW) {
                this.qyo.setImageResource(R.drawable.b6g);
                AppMethodBeat.o(73841);
                return;
            }
            this.qyo.setImageResource(R.drawable.b6k);
            AppMethodBeat.o(73841);
        } else if (this.cAW) {
            this.qyo.setImageResource(R.drawable.b6g);
            AppMethodBeat.o(73841);
        } else {
            this.qyo.setImageResource(R.drawable.b6k);
            AppMethodBeat.o(73841);
        }
    }

    public final void NO() {
        AppMethodBeat.i(73842);
        this.hZE.setImageResource(R.drawable.b6m);
        AppMethodBeat.o(73842);
    }

    public final void cVM() {
        AppMethodBeat.i(73843);
        this.hZE.setImageResource(R.drawable.b6j);
        AppMethodBeat.o(73843);
    }

    public void setMuteBtnOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(73844);
        this.hZE.setOnClickListener(onClickListener);
        AppMethodBeat.o(73844);
    }

    public void setEnterFullScreenBtnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(73845);
        this.hZz.setOnClickListener(onClickListener);
        AppMethodBeat.o(73845);
    }

    public void setExitFullScreenBtnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(73846);
        this.uco.setOnClickListener(onClickListener);
        AppMethodBeat.o(73846);
    }

    private void aFC() {
        AppMethodBeat.i(73847);
        if (this.hZM) {
            this.hZz.setImageResource(R.raw.fts_web_video_fullscreen_op_fullscreen_btn);
            this.hZz.setVisibility(8);
            this.uco.setVisibility(0);
            AppMethodBeat.o(73847);
            return;
        }
        this.uco.setVisibility(8);
        this.hZz.setVisibility(0);
        this.hZz.setImageResource(R.drawable.b6i);
        AppMethodBeat.o(73847);
    }

    public final void cHd() {
        AppMethodBeat.i(73848);
        if (this.hZK != null) {
            this.hZK.stopTimer();
        }
        AppMethodBeat.o(73848);
    }

    public final void aFE() {
        AppMethodBeat.i(73849);
        if (this.hZK != null) {
            this.hZK.stopTimer();
            this.hZK.ae(FaceGestureDetGLThread.BRIGHTNESS_DURATION, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        AppMethodBeat.o(73849);
    }

    public final void aDF() {
        AppMethodBeat.i(73851);
        this.hZM = false;
        aFJ();
        AppMethodBeat.o(73851);
    }

    public final void aFJ() {
        AppMethodBeat.i(73852);
        aFM();
        aFC();
        cVL();
        aFL();
        AppMethodBeat.o(73852);
    }

    private void aFL() {
        float dimensionPixelSize;
        AppMethodBeat.i(73853);
        if (this.hZM) {
            dimensionPixelSize = (float) getResources().getDimensionPixelSize(R.dimen.a2e);
        } else {
            dimensionPixelSize = (float) getResources().getDimensionPixelSize(R.dimen.a2c);
        }
        this.qyp.setTextSize(0, dimensionPixelSize);
        this.qyq.setTextSize(0, dimensionPixelSize);
        AppMethodBeat.o(73853);
    }

    private void aFM() {
        AppMethodBeat.i(73854);
        LayoutParams layoutParams = this.kGo.getLayoutParams();
        if (this.hZM) {
            layoutParams.height = getResources().getDimensionPixelSize(R.dimen.a2d);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(R.dimen.a2b);
        }
        this.kGo.setLayoutParams(layoutParams);
        AppMethodBeat.o(73854);
    }

    public final boolean aFP() {
        AppMethodBeat.i(73855);
        if (this.ucp == null) {
            ab.i("MicroMsg.FtsWebVideoViewControlBar", "updateMiddleBar mStatePorter null");
            AppMethodBeat.o(73855);
            return false;
        }
        int aFg = this.ucp.aFg();
        int aFh = this.ucp.aFh();
        if (aFg < 0 || aFh < 0) {
            AppMethodBeat.o(73855);
            return false;
        }
        int width = this.hZD.getWidth();
        if (width <= 0) {
            AppMethodBeat.o(73855);
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
            AppMethodBeat.o(73855);
            return true;
        }
        AppMethodBeat.o(73855);
        return false;
    }

    public final void cHe() {
        AppMethodBeat.i(73856);
        this.qyo.setVisibility(8);
        AppMethodBeat.o(73856);
    }

    public final void cHf() {
        AppMethodBeat.i(73857);
        this.qyo.setVisibility(0);
        AppMethodBeat.o(73857);
    }

    public final void Dq(int i) {
        AppMethodBeat.i(73858);
        seek((int) Math.ceil((((double) this.ucp.cVN()) * 1.0d) / 1000.0d));
        AppMethodBeat.o(73858);
    }

    /* Access modifiers changed, original: protected */
    public ImageView getExitFullscreenIv() {
        return this.uco;
    }

    public final void nG(boolean z) {
        int i;
        AppMethodBeat.i(73850);
        if (getVisibility() == 0) {
            i = 1;
        } else {
            i = 0;
        }
        if (i != 0) {
            setVisibility(8);
            AppMethodBeat.o(73850);
            return;
        }
        setVisibility(0);
        if (z) {
            cHe();
        } else {
            cHf();
        }
        if (this.hZK == null) {
            this.hZK = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(73836);
                    WebSearchWebVideoViewControlBar.this.setVisibility(8);
                    WebSearchWebVideoViewControlBar.this.hZK.stopTimer();
                    AppMethodBeat.o(73836);
                    return false;
                }
            }, false);
        }
        this.hZK.stopTimer();
        this.hZK.ae(FaceGestureDetGLThread.BRIGHTNESS_DURATION, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        AppMethodBeat.o(73850);
    }
}
