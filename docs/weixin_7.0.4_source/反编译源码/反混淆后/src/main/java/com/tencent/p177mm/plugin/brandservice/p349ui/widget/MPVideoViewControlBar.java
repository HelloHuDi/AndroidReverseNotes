package com.tencent.p177mm.plugin.brandservice.p349ui.widget;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C45630d.C10555f;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C45630d.C19512d;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C45630d.C27129e;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C45630d.C38399a;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C45630d.C38400h;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C45630d.C42594c;
import com.tencent.p177mm.plugin.sight.decode.p512ui.AdVideoPlayerLoadingBar;
import com.tencent.p177mm.plugin.sight.decode.p512ui.C3855b;
import com.tencent.p177mm.pluginsdk.p597ui.tools.VideoPlayerSeekBar;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar */
public class MPVideoViewControlBar extends VideoPlayerSeekBar implements C38399a {
    private TextView atH;
    private LinearLayout hZB;
    private ImageView hZC;
    private FrameLayout hZD;
    private ImageView hZE;
    private ImageView hZF;
    private ImageView hZG;
    private LinearLayout hZH;
    private LinearLayout hZI;
    private C38400h hZJ;
    C7564ap hZK;
    private C7564ap hZL;
    private boolean hZM;
    private boolean hZO;
    private boolean hZP;
    private boolean hZQ;
    private boolean hZR;
    private boolean hZS;
    private C19512d hZT;
    private C27129e hZU;
    private ImageView hZz;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar$2 */
    class C387242 implements C5015a {
        C387242() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(14587);
            MPVideoViewControlBar.this.setVisibility(8);
            MPVideoViewControlBar.this.hZK.stopTimer();
            AppMethodBeat.m2505o(14587);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.widget.MPVideoViewControlBar$3 */
    class C457703 implements C5015a {
        C457703() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(14588);
            if (MPVideoViewControlBar.m84610b(MPVideoViewControlBar.this)) {
                AppMethodBeat.m2505o(14588);
                return true;
            }
            AppMethodBeat.m2505o(14588);
            return false;
        }
    }

    /* renamed from: b */
    static /* synthetic */ boolean m84610b(MPVideoViewControlBar mPVideoViewControlBar) {
        AppMethodBeat.m2504i(14630);
        boolean aFP = mPVideoViewControlBar.aFP();
        AppMethodBeat.m2505o(14630);
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

    public void setStatePorter(C38400h c38400h) {
        this.hZJ = c38400h;
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(14589);
        if (this.hZL != null) {
            this.hZL.stopTimer();
        }
        if (this.hZK != null) {
            this.hZK.stopTimer();
        }
        AppMethodBeat.m2505o(14589);
    }

    public void setIplaySeekCallback(final C42594c c42594c) {
        AppMethodBeat.m2504i(14590);
        setIplaySeekCallback(new C3855b() {
            public final void aFw() {
                AppMethodBeat.m2504i(14585);
                c42594c.aFw();
                AppMethodBeat.m2505o(14585);
            }

            /* renamed from: oA */
            public final void mo8552oA(int i) {
                AppMethodBeat.m2504i(14586);
                c42594c.mo22044oA(i);
                AppMethodBeat.m2505o(14586);
            }
        });
        AppMethodBeat.m2505o(14590);
    }

    public int getLayoutId() {
        return 2130970259;
    }

    public final void init() {
        AppMethodBeat.m2504i(14591);
        super.init();
        this.hZz = (ImageView) this.contentView.findViewById(2131821430);
        this.hZC = (ImageView) this.contentView.findViewById(2131821424);
        this.hZD = (FrameLayout) this.contentView.findViewById(2131821422);
        this.hZB = (LinearLayout) findViewById(2131820987);
        this.hZE = (ImageView) findViewById(2131821429);
        this.hZF = (ImageView) findViewById(2131821419);
        this.hZG = (ImageView) findViewById(2131821418);
        this.atH = (TextView) findViewById(2131820678);
        this.hZH = (LinearLayout) findViewById(2131821417);
        this.hZI = (LinearLayout) findViewById(2131821420);
        AppMethodBeat.m2505o(14591);
    }

    public void setMuteBtnOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(14592);
        this.hZE.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(14592);
    }

    public void setExitFullScreenBtnOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(14593);
        this.hZG.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(14593);
    }

    public void setOnPlayButtonClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(14594);
        super.setOnPlayButtonClickListener(onClickListener);
        this.hZF.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(14594);
    }

    public void setTitle(String str) {
        AppMethodBeat.m2504i(14595);
        if (!C5046bo.isNullOrNil(str)) {
            this.atH.setText(str);
        }
        AppMethodBeat.m2505o(14595);
    }

    public void setShowMuteBtn(boolean z) {
        AppMethodBeat.m2504i(14596);
        this.hZE.setVisibility(z ? 0 : 8);
        AppMethodBeat.m2505o(14596);
    }

    public void setMuteBtnState(boolean z) {
        AppMethodBeat.m2504i(14597);
        if (z) {
            this.hZE.setImageResource(C1318a.mp_video_mute_btn_off);
            AppMethodBeat.m2505o(14597);
            return;
        }
        this.hZE.setImageResource(C1318a.mp_video_mute_btn_on);
        AppMethodBeat.m2505o(14597);
    }

    public void setShowControlProgress(boolean z) {
        AppMethodBeat.m2504i(14598);
        this.hZQ = z;
        aFS();
        AppMethodBeat.m2505o(14598);
    }

    private void aFx() {
        AppMethodBeat.m2504i(14599);
        if (this.hZM) {
            this.hZH.setVisibility(0);
            AppMethodBeat.m2505o(14599);
            return;
        }
        this.hZH.setVisibility(8);
        AppMethodBeat.m2505o(14599);
    }

    public void setPlayBtnInCenterPosition(boolean z) {
        AppMethodBeat.m2504i(14600);
        this.hZS = z;
        aFz();
        AppMethodBeat.m2505o(14600);
    }

    public final void aEZ() {
        AppMethodBeat.m2504i(14601);
        if (this.hZR && this.hZS) {
            this.hZF.setVisibility(8);
        }
        AppMethodBeat.m2505o(14601);
    }

    public final void aFy() {
        AppMethodBeat.m2504i(14602);
        if (this.hZR && this.hZS) {
            this.hZF.setVisibility(0);
        }
        AppMethodBeat.m2505o(14602);
    }

    private void aFz() {
        AppMethodBeat.m2504i(14603);
        if (!this.hZR) {
            this.qyo.setVisibility(8);
            this.hZF.setVisibility(8);
            AppMethodBeat.m2505o(14603);
        } else if (this.hZS) {
            this.qyo.setVisibility(8);
            this.hZF.setVisibility(0);
            AppMethodBeat.m2505o(14603);
        } else {
            this.qyo.setVisibility(0);
            this.hZF.setVisibility(8);
            AppMethodBeat.m2505o(14603);
        }
    }

    public void setIsPlay(boolean z) {
        AppMethodBeat.m2504i(14604);
        this.cAW = z;
        if (this.cAW) {
            this.qyo.setImageResource(C1318a.mp_video_play_btn_pause);
            this.hZF.setImageResource(C1318a.mp_video_play_btn_pause);
            AppMethodBeat.m2505o(14604);
            return;
        }
        this.qyo.setImageResource(C1318a.mp_video_play_btn_play);
        this.hZF.setImageResource(C1318a.mp_video_play_btn_play);
        AppMethodBeat.m2505o(14604);
    }

    public void setFullScreenBtnOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(14605);
        this.hZz.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(14605);
    }

    public void setDanmakuBtnOnClickListener(C10555f c10555f) {
    }

    public final boolean aFA() {
        return false;
    }

    public void setDanmakuBtnOpen(boolean z) {
    }

    private void aFC() {
        AppMethodBeat.m2504i(14606);
        if (this.hZO) {
            this.hZz.setVisibility(0);
            if (this.hZM) {
                this.hZz.setImageResource(C1318a.mp_video_fullscreen_exit_btn);
                AppMethodBeat.m2505o(14606);
                return;
            }
            this.hZz.setImageResource(C1318a.mp_video_fullscreen_btn);
            AppMethodBeat.m2505o(14606);
            return;
        }
        this.hZz.setVisibility(8);
        AppMethodBeat.m2505o(14606);
    }

    public void setShowDanmakuBtn(boolean z) {
    }

    public final void aFD() {
        AppMethodBeat.m2504i(14607);
        setVisibility(0);
        if (this.hZK == null) {
            this.hZK = new C7564ap(new C387242(), false);
        }
        this.hZK.stopTimer();
        this.hZK.mo16770ae(3000, 3000);
        AppMethodBeat.m2505o(14607);
    }

    public final void aFE() {
        AppMethodBeat.m2504i(14608);
        if (this.hZK != null) {
            this.hZK.stopTimer();
            this.hZK.mo16770ae(3000, 3000);
        }
        AppMethodBeat.m2505o(14608);
    }

    public final void hide() {
        AppMethodBeat.m2504i(138970);
        setVisibility(8);
        AppMethodBeat.m2505o(138970);
    }

    public final boolean aFF() {
        AppMethodBeat.m2504i(14610);
        if (getVisibility() == 0) {
            AppMethodBeat.m2505o(14610);
            return true;
        }
        AppMethodBeat.m2505o(14610);
        return false;
    }

    public final void aFG() {
        AppMethodBeat.m2504i(14611);
        if (aFF()) {
            setVisibility(8);
            AppMethodBeat.m2505o(14611);
            return;
        }
        aFD();
        AppMethodBeat.m2505o(14611);
    }

    public final void aFH() {
        AppMethodBeat.m2504i(14612);
        this.hZM = true;
        aFJ();
        AppMethodBeat.m2505o(14612);
    }

    public final void aDF() {
        AppMethodBeat.m2504i(14613);
        this.hZM = false;
        aFJ();
        AppMethodBeat.m2505o(14613);
    }

    public final boolean aFI() {
        return this.hZM;
    }

    private void aFJ() {
        AppMethodBeat.m2504i(14614);
        aFM();
        aFC();
        aFx();
        aFL();
        aFK();
        AppMethodBeat.m2505o(14614);
    }

    private void aFK() {
        int dimensionPixelSize;
        MarginLayoutParams marginLayoutParams;
        AppMethodBeat.m2504i(14615);
        if (this.hZM) {
            dimensionPixelSize = getResources().getDimensionPixelSize(C25738R.dimen.a6m);
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(C25738R.dimen.a6c);
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
        AppMethodBeat.m2505o(14615);
    }

    private void aFL() {
        float dimensionPixelSize;
        AppMethodBeat.m2504i(14616);
        if (this.hZM) {
            dimensionPixelSize = (float) getResources().getDimensionPixelSize(C25738R.dimen.a6p);
        } else {
            dimensionPixelSize = (float) getResources().getDimensionPixelSize(C25738R.dimen.a6i);
        }
        this.qyp.setTextSize(0, dimensionPixelSize);
        this.qyq.setTextSize(0, dimensionPixelSize);
        AppMethodBeat.m2505o(14616);
    }

    private void aFM() {
        int dimensionPixelSize;
        AppMethodBeat.m2504i(14617);
        LayoutParams layoutParams = this.hZB.getLayoutParams();
        if (this.hZM) {
            layoutParams.height = getResources().getDimensionPixelSize(C25738R.dimen.a6n);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(C25738R.dimen.a6e);
        }
        this.hZB.setLayoutParams(layoutParams);
        if (this.hZM) {
            dimensionPixelSize = getResources().getDimensionPixelSize(C25738R.dimen.a6o);
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(C25738R.dimen.a6f);
        }
        this.hZB.setPadding(0, 0, dimensionPixelSize, 0);
        if (this.hZH != null) {
            this.hZH.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
        AppMethodBeat.m2505o(14617);
    }

    public final void aFN() {
        AppMethodBeat.m2504i(14618);
        if (this.hZL == null) {
            this.hZL = new C7564ap(new C457703(), true);
        }
        aFP();
        this.hZL.stopTimer();
        this.hZL.mo16770ae(500, 500);
        AppMethodBeat.m2505o(14618);
    }

    public final void aFO() {
        AppMethodBeat.m2504i(14619);
        if (this.hZL != null) {
            this.hZL.stopTimer();
        }
        AppMethodBeat.m2505o(14619);
    }

    private boolean aFP() {
        AppMethodBeat.m2504i(14620);
        if (this.hZJ == null) {
            C4990ab.m7416i("MicroMsg.MPVideoViewControlBar", "updateMiddleBar mStatePorter null");
            AppMethodBeat.m2505o(14620);
            return false;
        }
        int aFg = this.hZJ.aFg();
        int aFh = this.hZJ.aFh();
        if (aFg < 0 || aFh < 0) {
            AppMethodBeat.m2505o(14620);
            return false;
        }
        if (aFg > aFh) {
            aFg = aFh;
        }
        int barLen = getBarLen();
        if (barLen <= 0) {
            AppMethodBeat.m2505o(14620);
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
        AppMethodBeat.m2505o(14620);
        return true;
    }

    public final void seek(int i) {
        AppMethodBeat.m2504i(14621);
        super.seek(i);
        m84611df(this.mPosition, this.qyr);
        AppMethodBeat.m2505o(14621);
    }

    public final void aFQ() {
        AppMethodBeat.m2504i(14622);
        if (this.qyr == 0) {
            AppMethodBeat.m2505o(14622);
        } else if (this.hOy) {
            AppMethodBeat.m2505o(14622);
        } else if (this.qyn == null) {
            AppMethodBeat.m2505o(14622);
        } else {
            this.qyp.setText(AdVideoPlayerLoadingBar.m33392oy(this.mPosition / 60) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + AdVideoPlayerLoadingBar.m33392oy(this.mPosition % 60));
            if (getBarLen() == 0) {
                AppMethodBeat.m2505o(14622);
                return;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.qyn.getLayoutParams();
            int barLen = getBarLen();
            layoutParams.leftMargin = mo27331gR(this.mPosition, barLen);
            this.qyn.setLayoutParams(layoutParams);
            layoutParams = (FrameLayout.LayoutParams) this.qyl.getLayoutParams();
            layoutParams.width = (int) (((((double) this.mPosition) * 1.0d) / ((double) this.qyr)) * ((double) barLen));
            this.qyl.setLayoutParams(layoutParams);
            requestLayout();
            m84611df(this.mPosition, this.qyr);
            AppMethodBeat.m2505o(14622);
        }
    }

    public void setShowFullScreenBtn(boolean z) {
        AppMethodBeat.m2504i(14623);
        this.hZO = z;
        aFC();
        aFx();
        AppMethodBeat.m2505o(14623);
    }

    public void setShowPlayBtn(boolean z) {
        AppMethodBeat.m2504i(14624);
        this.hZR = z;
        aFz();
        AppMethodBeat.m2505o(14624);
    }

    public void setShowProgress(boolean z) {
        AppMethodBeat.m2504i(14625);
        this.hZP = z;
        aFS();
        AppMethodBeat.m2505o(14625);
    }

    public final boolean aFR() {
        AppMethodBeat.m2504i(14626);
        if (this.hZD == null) {
            AppMethodBeat.m2505o(14626);
            return false;
        } else if (getVisibility() == 0 && this.hZD.getVisibility() == 0) {
            AppMethodBeat.m2505o(14626);
            return true;
        } else {
            AppMethodBeat.m2505o(14626);
            return false;
        }
    }

    private void aFS() {
        boolean z;
        int i;
        int i2 = 0;
        AppMethodBeat.m2504i(14627);
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
        AppMethodBeat.m2505o(14627);
    }

    /* renamed from: df */
    private void m84611df(int i, int i2) {
        AppMethodBeat.m2504i(14628);
        if (this.hZT != null) {
            this.hZT.mo34676dd(i, i2);
        }
        AppMethodBeat.m2505o(14628);
    }

    public void setVisibility(int i) {
        AppMethodBeat.m2504i(14629);
        super.setVisibility(i);
        if (i == 0) {
            if (this.hZU != null) {
                this.hZU.onVisibilityChanged(true);
                AppMethodBeat.m2505o(14629);
                return;
            }
        } else if ((i == 8 || i == 4) && this.hZU != null) {
            this.hZU.onVisibilityChanged(false);
        }
        AppMethodBeat.m2505o(14629);
    }

    public void setOnUpdateProgressLenListener(C19512d c19512d) {
        this.hZT = c19512d;
    }

    public void setOnVisibilityChangedListener(C27129e c27129e) {
        this.hZU = c27129e;
    }
}
