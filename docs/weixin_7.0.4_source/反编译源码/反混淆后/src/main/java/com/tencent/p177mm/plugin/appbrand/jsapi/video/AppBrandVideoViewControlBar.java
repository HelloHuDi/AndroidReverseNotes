package com.tencent.p177mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
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

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoViewControlBar */
public class AppBrandVideoViewControlBar extends VideoPlayerSeekBar implements C38399a {
    private TextView atH;
    private ImageView hZA;
    private LinearLayout hZB;
    private ImageView hZC;
    private FrameLayout hZD;
    private ImageView hZE;
    private ImageView hZF;
    private ImageView hZG;
    private LinearLayout hZH;
    private LinearLayout hZI;
    private C38400h hZJ;
    private C7564ap hZK;
    private C7564ap hZL;
    private boolean hZM;
    private boolean hZN;
    private boolean hZO;
    private boolean hZP;
    private boolean hZQ;
    private boolean hZR;
    private boolean hZS;
    private C19512d hZT;
    private C27129e hZU;
    private ImageView hZz;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoViewControlBar$3 */
    class C67813 implements C5015a {
        C67813() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(131536);
            AppBrandVideoViewControlBar.this.setVisibility(8);
            AppBrandVideoViewControlBar.this.hZK.stopTimer();
            AppMethodBeat.m2505o(131536);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoViewControlBar$4 */
    class C195114 implements C5015a {
        C195114() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(131537);
            if (AppBrandVideoViewControlBar.m84240d(AppBrandVideoViewControlBar.this)) {
                AppMethodBeat.m2505o(131537);
                return true;
            }
            AppMethodBeat.m2505o(131537);
            return false;
        }
    }

    /* renamed from: d */
    static /* synthetic */ boolean m84240d(AppBrandVideoViewControlBar appBrandVideoViewControlBar) {
        AppMethodBeat.m2504i(131584);
        boolean aFP = appBrandVideoViewControlBar.aFP();
        AppMethodBeat.m2505o(131584);
        return aFP;
    }

    public AppBrandVideoViewControlBar(Context context) {
        super(context);
    }

    public AppBrandVideoViewControlBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AppBrandVideoViewControlBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setStatePorter(C38400h c38400h) {
        this.hZJ = c38400h;
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(131538);
        if (this.hZL != null) {
            this.hZL.stopTimer();
        }
        if (this.hZK != null) {
            this.hZK.stopTimer();
        }
        AppMethodBeat.m2505o(131538);
    }

    public void setIplaySeekCallback(final C42594c c42594c) {
        AppMethodBeat.m2504i(131539);
        setIplaySeekCallback(new C3855b() {
            public final void aFw() {
                AppMethodBeat.m2504i(131533);
                c42594c.aFw();
                AppMethodBeat.m2505o(131533);
            }

            /* renamed from: oA */
            public final void mo8552oA(int i) {
                AppMethodBeat.m2504i(131534);
                c42594c.mo22044oA(i);
                AppMethodBeat.m2505o(131534);
            }
        });
        AppMethodBeat.m2505o(131539);
    }

    public int getLayoutId() {
        return 2130968745;
    }

    public final void init() {
        AppMethodBeat.m2504i(131540);
        super.init();
        this.hZz = (ImageView) this.contentView.findViewById(2131821430);
        this.hZA = (ImageView) this.contentView.findViewById(2131821428);
        this.hZC = (ImageView) this.contentView.findViewById(2131821424);
        this.hZD = (FrameLayout) this.contentView.findViewById(2131821422);
        this.hZB = (LinearLayout) findViewById(2131820987);
        this.hZE = (ImageView) findViewById(2131821429);
        this.hZF = (ImageView) findViewById(2131821419);
        this.hZG = (ImageView) findViewById(2131821418);
        this.atH = (TextView) findViewById(2131820678);
        this.hZH = (LinearLayout) findViewById(2131821417);
        this.hZI = (LinearLayout) findViewById(2131821420);
        AppMethodBeat.m2505o(131540);
    }

    public void setMuteBtnOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(131541);
        this.hZE.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(131541);
    }

    public void setExitFullScreenBtnOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(131542);
        this.hZG.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(131542);
    }

    public void setOnPlayButtonClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(131543);
        super.setOnPlayButtonClickListener(onClickListener);
        this.hZF.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(131543);
    }

    public void setTitle(String str) {
        AppMethodBeat.m2504i(131544);
        if (!C5046bo.isNullOrNil(str)) {
            this.atH.setText(str);
        }
        AppMethodBeat.m2505o(131544);
    }

    public void setShowMuteBtn(boolean z) {
        AppMethodBeat.m2504i(131545);
        this.hZE.setVisibility(z ? 0 : 8);
        AppMethodBeat.m2505o(131545);
    }

    public void setMuteBtnState(boolean z) {
        AppMethodBeat.m2504i(131546);
        if (z) {
            this.hZE.setImageResource(C1318a.app_brand_video_mute_btn_off);
            AppMethodBeat.m2505o(131546);
            return;
        }
        this.hZE.setImageResource(C1318a.app_brand_video_mute_btn_on);
        AppMethodBeat.m2505o(131546);
    }

    public void setShowControlProgress(boolean z) {
        AppMethodBeat.m2504i(131547);
        this.hZQ = z;
        aFS();
        AppMethodBeat.m2505o(131547);
    }

    private void aFx() {
        AppMethodBeat.m2504i(131548);
        if (this.hZM) {
            this.hZH.setVisibility(0);
            AppMethodBeat.m2505o(131548);
            return;
        }
        this.hZH.setVisibility(8);
        AppMethodBeat.m2505o(131548);
    }

    public void setPlayBtnInCenterPosition(boolean z) {
        AppMethodBeat.m2504i(131549);
        this.hZS = z;
        aFz();
        AppMethodBeat.m2505o(131549);
    }

    public final void aEZ() {
        AppMethodBeat.m2504i(131550);
        if (this.hZR && this.hZS) {
            this.hZF.setVisibility(8);
        }
        AppMethodBeat.m2505o(131550);
    }

    public final void aFy() {
        AppMethodBeat.m2504i(131551);
        if (this.hZR && this.hZS) {
            this.hZF.setVisibility(0);
        }
        AppMethodBeat.m2505o(131551);
    }

    private void aFz() {
        AppMethodBeat.m2504i(131552);
        if (!this.hZR) {
            this.qyo.setVisibility(8);
            this.hZF.setVisibility(8);
            AppMethodBeat.m2505o(131552);
        } else if (this.hZS) {
            this.qyo.setVisibility(8);
            this.hZF.setVisibility(0);
            AppMethodBeat.m2505o(131552);
        } else {
            this.qyo.setVisibility(0);
            this.hZF.setVisibility(8);
            AppMethodBeat.m2505o(131552);
        }
    }

    public void setIsPlay(boolean z) {
        AppMethodBeat.m2504i(131553);
        this.cAW = z;
        if (this.cAW) {
            this.qyo.setImageResource(C1318a.app_brand_video_play_btn_pause);
            this.hZF.setImageResource(C1318a.app_brand_video_play_btn_pause);
            AppMethodBeat.m2505o(131553);
            return;
        }
        this.qyo.setImageResource(C1318a.app_brand_video_play_btn_play);
        this.hZF.setImageResource(C1318a.app_brand_video_play_btn_play);
        AppMethodBeat.m2505o(131553);
    }

    public void setFullScreenBtnOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(131554);
        this.hZz.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(131554);
    }

    public void setDanmakuBtnOnClickListener(final C10555f c10555f) {
        AppMethodBeat.m2504i(131555);
        this.hZA.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(131535);
                AppBrandVideoViewControlBar.m84237a(AppBrandVideoViewControlBar.this);
                if (c10555f != null) {
                    c10555f.mo22049es(AppBrandVideoViewControlBar.this.hZN);
                }
                AppMethodBeat.m2505o(131535);
            }
        });
        AppMethodBeat.m2505o(131555);
    }

    public final boolean aFA() {
        return this.hZN;
    }

    public void setDanmakuBtnOpen(boolean z) {
        AppMethodBeat.m2504i(131556);
        this.hZN = z;
        aFB();
        AppMethodBeat.m2505o(131556);
    }

    private void aFB() {
        AppMethodBeat.m2504i(131557);
        if (this.hZN) {
            this.hZA.setImageResource(C1318a.app_brand_video_danmu_on);
            AppMethodBeat.m2505o(131557);
            return;
        }
        this.hZA.setImageResource(C1318a.app_brand_video_danmu_off);
        AppMethodBeat.m2505o(131557);
    }

    private void aFC() {
        AppMethodBeat.m2504i(131558);
        if (this.hZO) {
            this.hZz.setVisibility(0);
            if (this.hZM) {
                this.hZz.setImageResource(C1318a.app_brand_video_fullscreen_exit_btn);
                AppMethodBeat.m2505o(131558);
                return;
            }
            this.hZz.setImageResource(C1318a.app_brand_video_fullscreen_btn);
            AppMethodBeat.m2505o(131558);
            return;
        }
        this.hZz.setVisibility(8);
        AppMethodBeat.m2505o(131558);
    }

    public void setShowDanmakuBtn(boolean z) {
        AppMethodBeat.m2504i(131559);
        if (z) {
            this.hZA.setVisibility(0);
            AppMethodBeat.m2505o(131559);
            return;
        }
        this.hZA.setVisibility(8);
        AppMethodBeat.m2505o(131559);
    }

    public final void aFD() {
        AppMethodBeat.m2504i(131560);
        setVisibility(0);
        if (this.hZK == null) {
            this.hZK = new C7564ap(new C67813(), false);
        }
        this.hZK.stopTimer();
        this.hZK.mo16770ae(7000, 7000);
        AppMethodBeat.m2505o(131560);
    }

    public final void aFE() {
        AppMethodBeat.m2504i(131561);
        if (this.hZK != null) {
            this.hZK.stopTimer();
            this.hZK.mo16770ae(7000, 7000);
        }
        AppMethodBeat.m2505o(131561);
    }

    public final void hide() {
        AppMethodBeat.m2504i(131562);
        setVisibility(8);
        AppMethodBeat.m2505o(131562);
    }

    public final boolean aFF() {
        AppMethodBeat.m2504i(131563);
        if (getVisibility() == 0) {
            AppMethodBeat.m2505o(131563);
            return true;
        }
        AppMethodBeat.m2505o(131563);
        return false;
    }

    public final void aFG() {
        AppMethodBeat.m2504i(131564);
        if (aFF()) {
            setVisibility(8);
            AppMethodBeat.m2505o(131564);
            return;
        }
        aFD();
        AppMethodBeat.m2505o(131564);
    }

    public final void aFH() {
        AppMethodBeat.m2504i(131565);
        this.hZM = true;
        aFJ();
        AppMethodBeat.m2505o(131565);
    }

    public final void aDF() {
        AppMethodBeat.m2504i(131566);
        this.hZM = false;
        aFJ();
        AppMethodBeat.m2505o(131566);
    }

    public final boolean aFI() {
        return this.hZM;
    }

    private void aFJ() {
        AppMethodBeat.m2504i(131567);
        aFM();
        aFC();
        aFx();
        aFL();
        aFK();
        AppMethodBeat.m2505o(131567);
    }

    private void aFK() {
        int dimensionPixelSize;
        MarginLayoutParams marginLayoutParams;
        AppMethodBeat.m2504i(131568);
        if (this.hZM) {
            dimensionPixelSize = getResources().getDimensionPixelSize(C25738R.dimen.f10191ty);
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(C25738R.dimen.f10183to);
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
        if (this.hZA != null) {
            marginLayoutParams = (MarginLayoutParams) this.hZA.getLayoutParams();
            marginLayoutParams.setMarginStart(dimensionPixelSize);
            this.hZA.setLayoutParams(marginLayoutParams);
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
        AppMethodBeat.m2505o(131568);
    }

    private void aFL() {
        float dimensionPixelSize;
        AppMethodBeat.m2504i(131569);
        if (this.hZM) {
            dimensionPixelSize = (float) getResources().getDimensionPixelSize(C25738R.dimen.f10194u1);
        } else {
            dimensionPixelSize = (float) getResources().getDimensionPixelSize(C25738R.dimen.f10188tu);
        }
        this.qyp.setTextSize(0, dimensionPixelSize);
        this.qyq.setTextSize(0, dimensionPixelSize);
        AppMethodBeat.m2505o(131569);
    }

    private void aFM() {
        int dimensionPixelSize;
        AppMethodBeat.m2504i(131570);
        LayoutParams layoutParams = this.hZB.getLayoutParams();
        if (this.hZM) {
            layoutParams.height = getResources().getDimensionPixelSize(C25738R.dimen.f10192tz);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(C25738R.dimen.f10184tq);
        }
        this.hZB.setLayoutParams(layoutParams);
        if (this.hZM) {
            dimensionPixelSize = getResources().getDimensionPixelSize(C25738R.dimen.f10193u0);
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(C25738R.dimen.f10185tr);
        }
        this.hZB.setPadding(0, 0, dimensionPixelSize, 0);
        if (this.hZH != null) {
            this.hZH.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
        AppMethodBeat.m2505o(131570);
    }

    public final void aFN() {
        AppMethodBeat.m2504i(131571);
        if (this.hZL == null) {
            this.hZL = new C7564ap(new C195114(), true);
        }
        aFP();
        this.hZL.stopTimer();
        this.hZL.mo16770ae(500, 500);
        AppMethodBeat.m2505o(131571);
    }

    public final void aFO() {
        AppMethodBeat.m2504i(131572);
        if (this.hZL != null) {
            this.hZL.stopTimer();
        }
        AppMethodBeat.m2505o(131572);
    }

    private boolean aFP() {
        AppMethodBeat.m2504i(131573);
        if (this.hZJ == null) {
            C4990ab.m7416i("MicroMsg.AppBrandVideoViewControlBar", "updateMiddleBar mStatePorter null");
            AppMethodBeat.m2505o(131573);
            return false;
        }
        int aFg = this.hZJ.aFg();
        int aFh = this.hZJ.aFh();
        if (aFg < 0 || aFh < 0) {
            AppMethodBeat.m2505o(131573);
            return false;
        }
        if (aFg > aFh) {
            aFg = aFh;
        }
        int barLen = getBarLen();
        if (barLen <= 0) {
            AppMethodBeat.m2505o(131573);
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
        AppMethodBeat.m2505o(131573);
        return true;
    }

    public final void seek(int i) {
        AppMethodBeat.m2504i(131574);
        super.seek(i);
        m84241df(this.mPosition, this.qyr);
        AppMethodBeat.m2505o(131574);
    }

    public final void aFQ() {
        AppMethodBeat.m2504i(131575);
        if (this.qyr == 0) {
            AppMethodBeat.m2505o(131575);
        } else if (this.hOy) {
            AppMethodBeat.m2505o(131575);
        } else if (this.qyn == null) {
            AppMethodBeat.m2505o(131575);
        } else {
            this.qyp.setText(AdVideoPlayerLoadingBar.m33392oy(this.mPosition / 60) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + AdVideoPlayerLoadingBar.m33392oy(this.mPosition % 60));
            if (getBarLen() == 0) {
                AppMethodBeat.m2505o(131575);
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
            m84241df(this.mPosition, this.qyr);
            AppMethodBeat.m2505o(131575);
        }
    }

    public void setShowFullScreenBtn(boolean z) {
        AppMethodBeat.m2504i(131576);
        this.hZO = z;
        aFC();
        aFx();
        AppMethodBeat.m2505o(131576);
    }

    public void setShowPlayBtn(boolean z) {
        AppMethodBeat.m2504i(131577);
        this.hZR = z;
        aFz();
        AppMethodBeat.m2505o(131577);
    }

    public void setShowProgress(boolean z) {
        AppMethodBeat.m2504i(131578);
        this.hZP = z;
        aFS();
        AppMethodBeat.m2505o(131578);
    }

    public final boolean aFR() {
        AppMethodBeat.m2504i(131579);
        if (this.hZD == null) {
            AppMethodBeat.m2505o(131579);
            return false;
        } else if (getVisibility() == 0 && this.hZD.getVisibility() == 0) {
            AppMethodBeat.m2505o(131579);
            return true;
        } else {
            AppMethodBeat.m2505o(131579);
            return false;
        }
    }

    private void aFS() {
        boolean z;
        int i;
        int i2 = 0;
        AppMethodBeat.m2504i(131580);
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
        AppMethodBeat.m2505o(131580);
    }

    /* renamed from: df */
    private void m84241df(int i, int i2) {
        AppMethodBeat.m2504i(131581);
        if (this.hZT != null) {
            this.hZT.mo34676dd(i, i2);
        }
        AppMethodBeat.m2505o(131581);
    }

    public void setVisibility(int i) {
        AppMethodBeat.m2504i(131582);
        super.setVisibility(i);
        if (i == 0) {
            if (this.hZU != null) {
                this.hZU.onVisibilityChanged(true);
                AppMethodBeat.m2505o(131582);
                return;
            }
        } else if ((i == 8 || i == 4) && this.hZU != null) {
            this.hZU.onVisibilityChanged(false);
        }
        AppMethodBeat.m2505o(131582);
    }

    public void setOnUpdateProgressLenListener(C19512d c19512d) {
        this.hZT = c19512d;
    }

    public void setOnVisibilityChangedListener(C27129e c27129e) {
        this.hZU = c27129e;
    }

    /* renamed from: a */
    static /* synthetic */ void m84237a(AppBrandVideoViewControlBar appBrandVideoViewControlBar) {
        AppMethodBeat.m2504i(131583);
        appBrandVideoViewControlBar.hZN = !appBrandVideoViewControlBar.hZN;
        appBrandVideoViewControlBar.aFB();
        AppMethodBeat.m2505o(131583);
    }
}
