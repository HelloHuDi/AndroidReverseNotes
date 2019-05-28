package com.tencent.mm.plugin.brandservice.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.h;
import com.tencent.mm.plugin.sight.decode.ui.AdVideoPlayerLoadingBar;
import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerSeekBar;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.VideoMaterialUtil;

public class MPVideoViewControlBar extends VideoPlayerSeekBar implements a {
    private TextView atH;
    private LinearLayout hZB;
    private ImageView hZC;
    private FrameLayout hZD;
    private ImageView hZE;
    private ImageView hZF;
    private ImageView hZG;
    private LinearLayout hZH;
    private LinearLayout hZI;
    private h hZJ;
    ap hZK;
    private ap hZL;
    private boolean hZM;
    private boolean hZO;
    private boolean hZP;
    private boolean hZQ;
    private boolean hZR;
    private boolean hZS;
    private d hZT;
    private e hZU;
    private ImageView hZz;

    static /* synthetic */ boolean b(MPVideoViewControlBar mPVideoViewControlBar) {
        AppMethodBeat.i(14630);
        boolean aFP = mPVideoViewControlBar.aFP();
        AppMethodBeat.o(14630);
        return aFP;
    }

    public MPVideoViewControlBar(Context context) {
        super(context);
    }

    public MPVideoViewControlBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MPVideoViewControlBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setStatePorter(h hVar) {
        this.hZJ = hVar;
    }

    public final void onDestroy() {
        AppMethodBeat.i(14589);
        if (this.hZL != null) {
            this.hZL.stopTimer();
        }
        if (this.hZK != null) {
            this.hZK.stopTimer();
        }
        AppMethodBeat.o(14589);
    }

    public void setIplaySeekCallback(final c cVar) {
        AppMethodBeat.i(14590);
        setIplaySeekCallback(new b() {
            public final void aFw() {
                AppMethodBeat.i(14585);
                cVar.aFw();
                AppMethodBeat.o(14585);
            }

            public final void oA(int i) {
                AppMethodBeat.i(14586);
                cVar.oA(i);
                AppMethodBeat.o(14586);
            }
        });
        AppMethodBeat.o(14590);
    }

    public int getLayoutId() {
        return R.layout.aho;
    }

    public final void init() {
        AppMethodBeat.i(14591);
        super.init();
        this.hZz = (ImageView) this.contentView.findViewById(R.id.x9);
        this.hZC = (ImageView) this.contentView.findViewById(R.id.x3);
        this.hZD = (FrameLayout) this.contentView.findViewById(R.id.x1);
        this.hZB = (LinearLayout) findViewById(R.id.l_);
        this.hZE = (ImageView) findViewById(R.id.x8);
        this.hZF = (ImageView) findViewById(R.id.wy);
        this.hZG = (ImageView) findViewById(R.id.wx);
        this.atH = (TextView) findViewById(R.id.cx);
        this.hZH = (LinearLayout) findViewById(R.id.ww);
        this.hZI = (LinearLayout) findViewById(R.id.wz);
        AppMethodBeat.o(14591);
    }

    public void setMuteBtnOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(14592);
        this.hZE.setOnClickListener(onClickListener);
        AppMethodBeat.o(14592);
    }

    public void setExitFullScreenBtnOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(14593);
        this.hZG.setOnClickListener(onClickListener);
        AppMethodBeat.o(14593);
    }

    public void setOnPlayButtonClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(14594);
        super.setOnPlayButtonClickListener(onClickListener);
        this.hZF.setOnClickListener(onClickListener);
        AppMethodBeat.o(14594);
    }

    public void setTitle(String str) {
        AppMethodBeat.i(14595);
        if (!bo.isNullOrNil(str)) {
            this.atH.setText(str);
        }
        AppMethodBeat.o(14595);
    }

    public void setShowMuteBtn(boolean z) {
        AppMethodBeat.i(14596);
        this.hZE.setVisibility(z ? 0 : 8);
        AppMethodBeat.o(14596);
    }

    public void setMuteBtnState(boolean z) {
        AppMethodBeat.i(14597);
        if (z) {
            this.hZE.setImageResource(R.raw.mp_video_mute_btn_off);
            AppMethodBeat.o(14597);
            return;
        }
        this.hZE.setImageResource(R.raw.mp_video_mute_btn_on);
        AppMethodBeat.o(14597);
    }

    public void setShowControlProgress(boolean z) {
        AppMethodBeat.i(14598);
        this.hZQ = z;
        aFS();
        AppMethodBeat.o(14598);
    }

    private void aFx() {
        AppMethodBeat.i(14599);
        if (this.hZM) {
            this.hZH.setVisibility(0);
            AppMethodBeat.o(14599);
            return;
        }
        this.hZH.setVisibility(8);
        AppMethodBeat.o(14599);
    }

    public void setPlayBtnInCenterPosition(boolean z) {
        AppMethodBeat.i(14600);
        this.hZS = z;
        aFz();
        AppMethodBeat.o(14600);
    }

    public final void aEZ() {
        AppMethodBeat.i(14601);
        if (this.hZR && this.hZS) {
            this.hZF.setVisibility(8);
        }
        AppMethodBeat.o(14601);
    }

    public final void aFy() {
        AppMethodBeat.i(14602);
        if (this.hZR && this.hZS) {
            this.hZF.setVisibility(0);
        }
        AppMethodBeat.o(14602);
    }

    private void aFz() {
        AppMethodBeat.i(14603);
        if (!this.hZR) {
            this.qyo.setVisibility(8);
            this.hZF.setVisibility(8);
            AppMethodBeat.o(14603);
        } else if (this.hZS) {
            this.qyo.setVisibility(8);
            this.hZF.setVisibility(0);
            AppMethodBeat.o(14603);
        } else {
            this.qyo.setVisibility(0);
            this.hZF.setVisibility(8);
            AppMethodBeat.o(14603);
        }
    }

    public void setIsPlay(boolean z) {
        AppMethodBeat.i(14604);
        this.cAW = z;
        if (this.cAW) {
            this.qyo.setImageResource(R.raw.mp_video_play_btn_pause);
            this.hZF.setImageResource(R.raw.mp_video_play_btn_pause);
            AppMethodBeat.o(14604);
            return;
        }
        this.qyo.setImageResource(R.raw.mp_video_play_btn_play);
        this.hZF.setImageResource(R.raw.mp_video_play_btn_play);
        AppMethodBeat.o(14604);
    }

    public void setFullScreenBtnOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(14605);
        this.hZz.setOnClickListener(onClickListener);
        AppMethodBeat.o(14605);
    }

    public void setDanmakuBtnOnClickListener(f fVar) {
    }

    public final boolean aFA() {
        return false;
    }

    public void setDanmakuBtnOpen(boolean z) {
    }

    private void aFC() {
        AppMethodBeat.i(14606);
        if (this.hZO) {
            this.hZz.setVisibility(0);
            if (this.hZM) {
                this.hZz.setImageResource(R.raw.mp_video_fullscreen_exit_btn);
                AppMethodBeat.o(14606);
                return;
            }
            this.hZz.setImageResource(R.raw.mp_video_fullscreen_btn);
            AppMethodBeat.o(14606);
            return;
        }
        this.hZz.setVisibility(8);
        AppMethodBeat.o(14606);
    }

    public void setShowDanmakuBtn(boolean z) {
    }

    public final void aFD() {
        AppMethodBeat.i(14607);
        setVisibility(0);
        if (this.hZK == null) {
            this.hZK = new ap(new ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(14587);
                    MPVideoViewControlBar.this.setVisibility(8);
                    MPVideoViewControlBar.this.hZK.stopTimer();
                    AppMethodBeat.o(14587);
                    return false;
                }
            }, false);
        }
        this.hZK.stopTimer();
        this.hZK.ae(3000, 3000);
        AppMethodBeat.o(14607);
    }

    public final void aFE() {
        AppMethodBeat.i(14608);
        if (this.hZK != null) {
            this.hZK.stopTimer();
            this.hZK.ae(3000, 3000);
        }
        AppMethodBeat.o(14608);
    }

    public final void hide() {
        AppMethodBeat.i(138970);
        setVisibility(8);
        AppMethodBeat.o(138970);
    }

    public final boolean aFF() {
        AppMethodBeat.i(14610);
        if (getVisibility() == 0) {
            AppMethodBeat.o(14610);
            return true;
        }
        AppMethodBeat.o(14610);
        return false;
    }

    public final void aFG() {
        AppMethodBeat.i(14611);
        if (aFF()) {
            setVisibility(8);
            AppMethodBeat.o(14611);
            return;
        }
        aFD();
        AppMethodBeat.o(14611);
    }

    public final void aFH() {
        AppMethodBeat.i(14612);
        this.hZM = true;
        aFJ();
        AppMethodBeat.o(14612);
    }

    public final void aDF() {
        AppMethodBeat.i(14613);
        this.hZM = false;
        aFJ();
        AppMethodBeat.o(14613);
    }

    public final boolean aFI() {
        return this.hZM;
    }

    private void aFJ() {
        AppMethodBeat.i(14614);
        aFM();
        aFC();
        aFx();
        aFL();
        aFK();
        AppMethodBeat.o(14614);
    }

    private void aFK() {
        int dimensionPixelSize;
        MarginLayoutParams marginLayoutParams;
        AppMethodBeat.i(14615);
        if (this.hZM) {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.a6m);
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.a6c);
        }
        if (this.qyo != null) {
            marginLayoutParams = (MarginLayoutParams) this.qyo.getLayoutParams();
            marginLayoutParams.setMarginStart(dimensionPixelSize);
            this.qyo.setLayoutParams(marginLayoutParams);
        }
        if (this.hZI != null) {
            marginLayoutParams = (MarginLayoutParams) this.hZI.getLayoutParams();
            marginLayoutParams.setMarginStart(dimensionPixelSize);
            this.hZI.setLayoutParams(marginLayoutParams);
        }
        if (this.hZE != null) {
            marginLayoutParams = (MarginLayoutParams) this.hZE.getLayoutParams();
            marginLayoutParams.setMarginStart(dimensionPixelSize);
            this.hZE.setLayoutParams(marginLayoutParams);
        }
        if (this.hZz != null) {
            marginLayoutParams = (MarginLayoutParams) this.hZz.getLayoutParams();
            marginLayoutParams.setMarginStart(dimensionPixelSize);
            this.hZz.setLayoutParams(marginLayoutParams);
        }
        AppMethodBeat.o(14615);
    }

    private void aFL() {
        float dimensionPixelSize;
        AppMethodBeat.i(14616);
        if (this.hZM) {
            dimensionPixelSize = (float) getResources().getDimensionPixelSize(R.dimen.a6p);
        } else {
            dimensionPixelSize = (float) getResources().getDimensionPixelSize(R.dimen.a6i);
        }
        this.qyp.setTextSize(0, dimensionPixelSize);
        this.qyq.setTextSize(0, dimensionPixelSize);
        AppMethodBeat.o(14616);
    }

    private void aFM() {
        int dimensionPixelSize;
        AppMethodBeat.i(14617);
        LayoutParams layoutParams = this.hZB.getLayoutParams();
        if (this.hZM) {
            layoutParams.height = getResources().getDimensionPixelSize(R.dimen.a6n);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(R.dimen.a6e);
        }
        this.hZB.setLayoutParams(layoutParams);
        if (this.hZM) {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.a6o);
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.a6f);
        }
        this.hZB.setPadding(0, 0, dimensionPixelSize, 0);
        if (this.hZH != null) {
            this.hZH.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
        AppMethodBeat.o(14617);
    }

    public final void aFN() {
        AppMethodBeat.i(14618);
        if (this.hZL == null) {
            this.hZL = new ap(new ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(14588);
                    if (MPVideoViewControlBar.b(MPVideoViewControlBar.this)) {
                        AppMethodBeat.o(14588);
                        return true;
                    }
                    AppMethodBeat.o(14588);
                    return false;
                }
            }, true);
        }
        aFP();
        this.hZL.stopTimer();
        this.hZL.ae(500, 500);
        AppMethodBeat.o(14618);
    }

    public final void aFO() {
        AppMethodBeat.i(14619);
        if (this.hZL != null) {
            this.hZL.stopTimer();
        }
        AppMethodBeat.o(14619);
    }

    private boolean aFP() {
        AppMethodBeat.i(14620);
        if (this.hZJ == null) {
            ab.i("MicroMsg.MPVideoViewControlBar", "updateMiddleBar mStatePorter null");
            AppMethodBeat.o(14620);
            return false;
        }
        int aFg = this.hZJ.aFg();
        int aFh = this.hZJ.aFh();
        if (aFg < 0 || aFh < 0) {
            AppMethodBeat.o(14620);
            return false;
        }
        if (aFg > aFh) {
            aFg = aFh;
        }
        int barLen = getBarLen();
        if (barLen <= 0) {
            AppMethodBeat.o(14620);
            return true;
        }
        if (aFh == 0) {
            aFh = 0;
        } else {
            aFh = (int) (((((double) aFg) * 1.0d) / ((double) aFh)) * ((double) barLen));
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.hZC.getLayoutParams();
        layoutParams.width = aFh;
        this.hZC.setLayoutParams(layoutParams);
        AppMethodBeat.o(14620);
        return true;
    }

    public final void seek(int i) {
        AppMethodBeat.i(14621);
        super.seek(i);
        df(this.mPosition, this.qyr);
        AppMethodBeat.o(14621);
    }

    public final void aFQ() {
        AppMethodBeat.i(14622);
        if (this.qyr == 0) {
            AppMethodBeat.o(14622);
        } else if (this.hOy) {
            AppMethodBeat.o(14622);
        } else if (this.qyn == null) {
            AppMethodBeat.o(14622);
        } else {
            this.qyp.setText(AdVideoPlayerLoadingBar.oy(this.mPosition / 60) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + AdVideoPlayerLoadingBar.oy(this.mPosition % 60));
            if (getBarLen() == 0) {
                AppMethodBeat.o(14622);
                return;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.qyn.getLayoutParams();
            int barLen = getBarLen();
            layoutParams.leftMargin = gR(this.mPosition, barLen);
            this.qyn.setLayoutParams(layoutParams);
            layoutParams = (FrameLayout.LayoutParams) this.qyl.getLayoutParams();
            layoutParams.width = (int) (((((double) this.mPosition) * 1.0d) / ((double) this.qyr)) * ((double) barLen));
            this.qyl.setLayoutParams(layoutParams);
            requestLayout();
            df(this.mPosition, this.qyr);
            AppMethodBeat.o(14622);
        }
    }

    public void setShowFullScreenBtn(boolean z) {
        AppMethodBeat.i(14623);
        this.hZO = z;
        aFC();
        aFx();
        AppMethodBeat.o(14623);
    }

    public void setShowPlayBtn(boolean z) {
        AppMethodBeat.i(14624);
        this.hZR = z;
        aFz();
        AppMethodBeat.o(14624);
    }

    public void setShowProgress(boolean z) {
        AppMethodBeat.i(14625);
        this.hZP = z;
        aFS();
        AppMethodBeat.o(14625);
    }

    public final boolean aFR() {
        AppMethodBeat.i(14626);
        if (this.hZD == null) {
            AppMethodBeat.o(14626);
            return false;
        } else if (getVisibility() == 0 && this.hZD.getVisibility() == 0) {
            AppMethodBeat.o(14626);
            return true;
        } else {
            AppMethodBeat.o(14626);
            return false;
        }
    }

    private void aFS() {
        boolean z;
        int i;
        int i2 = 0;
        AppMethodBeat.i(14627);
        if (this.hZQ) {
            z = this.hZP;
        } else {
            z = false;
        }
        FrameLayout frameLayout = this.hZD;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        frameLayout.setVisibility(i);
        TextView textView = this.qyp;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        TextView textView2 = this.qyq;
        if (!z) {
            i2 = 8;
        }
        textView2.setVisibility(i2);
        AppMethodBeat.o(14627);
    }

    private void df(int i, int i2) {
        AppMethodBeat.i(14628);
        if (this.hZT != null) {
            this.hZT.dd(i, i2);
        }
        AppMethodBeat.o(14628);
    }

    public void setVisibility(int i) {
        AppMethodBeat.i(14629);
        super.setVisibility(i);
        if (i == 0) {
            if (this.hZU != null) {
                this.hZU.onVisibilityChanged(true);
                AppMethodBeat.o(14629);
                return;
            }
        } else if ((i == 8 || i == 4) && this.hZU != null) {
            this.hZU.onVisibilityChanged(false);
        }
        AppMethodBeat.o(14629);
    }

    public void setOnUpdateProgressLenListener(d dVar) {
        this.hZT = dVar;
    }

    public void setOnVisibilityChangedListener(e eVar) {
        this.hZU = eVar;
    }
}
