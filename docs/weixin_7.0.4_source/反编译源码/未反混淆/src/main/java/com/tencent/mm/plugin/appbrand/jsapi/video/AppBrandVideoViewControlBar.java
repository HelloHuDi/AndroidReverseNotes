package com.tencent.mm.plugin.appbrand.jsapi.video;

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

public class AppBrandVideoViewControlBar extends VideoPlayerSeekBar implements a {
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
    private h hZJ;
    private ap hZK;
    private ap hZL;
    private boolean hZM;
    private boolean hZN;
    private boolean hZO;
    private boolean hZP;
    private boolean hZQ;
    private boolean hZR;
    private boolean hZS;
    private d hZT;
    private e hZU;
    private ImageView hZz;

    static /* synthetic */ boolean d(AppBrandVideoViewControlBar appBrandVideoViewControlBar) {
        AppMethodBeat.i(131584);
        boolean aFP = appBrandVideoViewControlBar.aFP();
        AppMethodBeat.o(131584);
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

    public void setStatePorter(h hVar) {
        this.hZJ = hVar;
    }

    public final void onDestroy() {
        AppMethodBeat.i(131538);
        if (this.hZL != null) {
            this.hZL.stopTimer();
        }
        if (this.hZK != null) {
            this.hZK.stopTimer();
        }
        AppMethodBeat.o(131538);
    }

    public void setIplaySeekCallback(final c cVar) {
        AppMethodBeat.i(131539);
        setIplaySeekCallback(new b() {
            public final void aFw() {
                AppMethodBeat.i(131533);
                cVar.aFw();
                AppMethodBeat.o(131533);
            }

            public final void oA(int i) {
                AppMethodBeat.i(131534);
                cVar.oA(i);
                AppMethodBeat.o(131534);
            }
        });
        AppMethodBeat.o(131539);
    }

    public int getLayoutId() {
        return R.layout.dv;
    }

    public final void init() {
        AppMethodBeat.i(131540);
        super.init();
        this.hZz = (ImageView) this.contentView.findViewById(R.id.x9);
        this.hZA = (ImageView) this.contentView.findViewById(R.id.x7);
        this.hZC = (ImageView) this.contentView.findViewById(R.id.x3);
        this.hZD = (FrameLayout) this.contentView.findViewById(R.id.x1);
        this.hZB = (LinearLayout) findViewById(R.id.l_);
        this.hZE = (ImageView) findViewById(R.id.x8);
        this.hZF = (ImageView) findViewById(R.id.wy);
        this.hZG = (ImageView) findViewById(R.id.wx);
        this.atH = (TextView) findViewById(R.id.cx);
        this.hZH = (LinearLayout) findViewById(R.id.ww);
        this.hZI = (LinearLayout) findViewById(R.id.wz);
        AppMethodBeat.o(131540);
    }

    public void setMuteBtnOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(131541);
        this.hZE.setOnClickListener(onClickListener);
        AppMethodBeat.o(131541);
    }

    public void setExitFullScreenBtnOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(131542);
        this.hZG.setOnClickListener(onClickListener);
        AppMethodBeat.o(131542);
    }

    public void setOnPlayButtonClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(131543);
        super.setOnPlayButtonClickListener(onClickListener);
        this.hZF.setOnClickListener(onClickListener);
        AppMethodBeat.o(131543);
    }

    public void setTitle(String str) {
        AppMethodBeat.i(131544);
        if (!bo.isNullOrNil(str)) {
            this.atH.setText(str);
        }
        AppMethodBeat.o(131544);
    }

    public void setShowMuteBtn(boolean z) {
        AppMethodBeat.i(131545);
        this.hZE.setVisibility(z ? 0 : 8);
        AppMethodBeat.o(131545);
    }

    public void setMuteBtnState(boolean z) {
        AppMethodBeat.i(131546);
        if (z) {
            this.hZE.setImageResource(R.raw.app_brand_video_mute_btn_off);
            AppMethodBeat.o(131546);
            return;
        }
        this.hZE.setImageResource(R.raw.app_brand_video_mute_btn_on);
        AppMethodBeat.o(131546);
    }

    public void setShowControlProgress(boolean z) {
        AppMethodBeat.i(131547);
        this.hZQ = z;
        aFS();
        AppMethodBeat.o(131547);
    }

    private void aFx() {
        AppMethodBeat.i(131548);
        if (this.hZM) {
            this.hZH.setVisibility(0);
            AppMethodBeat.o(131548);
            return;
        }
        this.hZH.setVisibility(8);
        AppMethodBeat.o(131548);
    }

    public void setPlayBtnInCenterPosition(boolean z) {
        AppMethodBeat.i(131549);
        this.hZS = z;
        aFz();
        AppMethodBeat.o(131549);
    }

    public final void aEZ() {
        AppMethodBeat.i(131550);
        if (this.hZR && this.hZS) {
            this.hZF.setVisibility(8);
        }
        AppMethodBeat.o(131550);
    }

    public final void aFy() {
        AppMethodBeat.i(131551);
        if (this.hZR && this.hZS) {
            this.hZF.setVisibility(0);
        }
        AppMethodBeat.o(131551);
    }

    private void aFz() {
        AppMethodBeat.i(131552);
        if (!this.hZR) {
            this.qyo.setVisibility(8);
            this.hZF.setVisibility(8);
            AppMethodBeat.o(131552);
        } else if (this.hZS) {
            this.qyo.setVisibility(8);
            this.hZF.setVisibility(0);
            AppMethodBeat.o(131552);
        } else {
            this.qyo.setVisibility(0);
            this.hZF.setVisibility(8);
            AppMethodBeat.o(131552);
        }
    }

    public void setIsPlay(boolean z) {
        AppMethodBeat.i(131553);
        this.cAW = z;
        if (this.cAW) {
            this.qyo.setImageResource(R.raw.app_brand_video_play_btn_pause);
            this.hZF.setImageResource(R.raw.app_brand_video_play_btn_pause);
            AppMethodBeat.o(131553);
            return;
        }
        this.qyo.setImageResource(R.raw.app_brand_video_play_btn_play);
        this.hZF.setImageResource(R.raw.app_brand_video_play_btn_play);
        AppMethodBeat.o(131553);
    }

    public void setFullScreenBtnOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(131554);
        this.hZz.setOnClickListener(onClickListener);
        AppMethodBeat.o(131554);
    }

    public void setDanmakuBtnOnClickListener(final f fVar) {
        AppMethodBeat.i(131555);
        this.hZA.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(131535);
                AppBrandVideoViewControlBar.a(AppBrandVideoViewControlBar.this);
                if (fVar != null) {
                    fVar.es(AppBrandVideoViewControlBar.this.hZN);
                }
                AppMethodBeat.o(131535);
            }
        });
        AppMethodBeat.o(131555);
    }

    public final boolean aFA() {
        return this.hZN;
    }

    public void setDanmakuBtnOpen(boolean z) {
        AppMethodBeat.i(131556);
        this.hZN = z;
        aFB();
        AppMethodBeat.o(131556);
    }

    private void aFB() {
        AppMethodBeat.i(131557);
        if (this.hZN) {
            this.hZA.setImageResource(R.raw.app_brand_video_danmu_on);
            AppMethodBeat.o(131557);
            return;
        }
        this.hZA.setImageResource(R.raw.app_brand_video_danmu_off);
        AppMethodBeat.o(131557);
    }

    private void aFC() {
        AppMethodBeat.i(131558);
        if (this.hZO) {
            this.hZz.setVisibility(0);
            if (this.hZM) {
                this.hZz.setImageResource(R.raw.app_brand_video_fullscreen_exit_btn);
                AppMethodBeat.o(131558);
                return;
            }
            this.hZz.setImageResource(R.raw.app_brand_video_fullscreen_btn);
            AppMethodBeat.o(131558);
            return;
        }
        this.hZz.setVisibility(8);
        AppMethodBeat.o(131558);
    }

    public void setShowDanmakuBtn(boolean z) {
        AppMethodBeat.i(131559);
        if (z) {
            this.hZA.setVisibility(0);
            AppMethodBeat.o(131559);
            return;
        }
        this.hZA.setVisibility(8);
        AppMethodBeat.o(131559);
    }

    public final void aFD() {
        AppMethodBeat.i(131560);
        setVisibility(0);
        if (this.hZK == null) {
            this.hZK = new ap(new ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(131536);
                    AppBrandVideoViewControlBar.this.setVisibility(8);
                    AppBrandVideoViewControlBar.this.hZK.stopTimer();
                    AppMethodBeat.o(131536);
                    return false;
                }
            }, false);
        }
        this.hZK.stopTimer();
        this.hZK.ae(7000, 7000);
        AppMethodBeat.o(131560);
    }

    public final void aFE() {
        AppMethodBeat.i(131561);
        if (this.hZK != null) {
            this.hZK.stopTimer();
            this.hZK.ae(7000, 7000);
        }
        AppMethodBeat.o(131561);
    }

    public final void hide() {
        AppMethodBeat.i(131562);
        setVisibility(8);
        AppMethodBeat.o(131562);
    }

    public final boolean aFF() {
        AppMethodBeat.i(131563);
        if (getVisibility() == 0) {
            AppMethodBeat.o(131563);
            return true;
        }
        AppMethodBeat.o(131563);
        return false;
    }

    public final void aFG() {
        AppMethodBeat.i(131564);
        if (aFF()) {
            setVisibility(8);
            AppMethodBeat.o(131564);
            return;
        }
        aFD();
        AppMethodBeat.o(131564);
    }

    public final void aFH() {
        AppMethodBeat.i(131565);
        this.hZM = true;
        aFJ();
        AppMethodBeat.o(131565);
    }

    public final void aDF() {
        AppMethodBeat.i(131566);
        this.hZM = false;
        aFJ();
        AppMethodBeat.o(131566);
    }

    public final boolean aFI() {
        return this.hZM;
    }

    private void aFJ() {
        AppMethodBeat.i(131567);
        aFM();
        aFC();
        aFx();
        aFL();
        aFK();
        AppMethodBeat.o(131567);
    }

    private void aFK() {
        int dimensionPixelSize;
        MarginLayoutParams marginLayoutParams;
        AppMethodBeat.i(131568);
        if (this.hZM) {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ty);
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.to);
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
        AppMethodBeat.o(131568);
    }

    private void aFL() {
        float dimensionPixelSize;
        AppMethodBeat.i(131569);
        if (this.hZM) {
            dimensionPixelSize = (float) getResources().getDimensionPixelSize(R.dimen.u1);
        } else {
            dimensionPixelSize = (float) getResources().getDimensionPixelSize(R.dimen.tu);
        }
        this.qyp.setTextSize(0, dimensionPixelSize);
        this.qyq.setTextSize(0, dimensionPixelSize);
        AppMethodBeat.o(131569);
    }

    private void aFM() {
        int dimensionPixelSize;
        AppMethodBeat.i(131570);
        LayoutParams layoutParams = this.hZB.getLayoutParams();
        if (this.hZM) {
            layoutParams.height = getResources().getDimensionPixelSize(R.dimen.tz);
        } else {
            layoutParams.height = getResources().getDimensionPixelSize(R.dimen.tq);
        }
        this.hZB.setLayoutParams(layoutParams);
        if (this.hZM) {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.u0);
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.tr);
        }
        this.hZB.setPadding(0, 0, dimensionPixelSize, 0);
        if (this.hZH != null) {
            this.hZH.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
        }
        AppMethodBeat.o(131570);
    }

    public final void aFN() {
        AppMethodBeat.i(131571);
        if (this.hZL == null) {
            this.hZL = new ap(new ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(131537);
                    if (AppBrandVideoViewControlBar.d(AppBrandVideoViewControlBar.this)) {
                        AppMethodBeat.o(131537);
                        return true;
                    }
                    AppMethodBeat.o(131537);
                    return false;
                }
            }, true);
        }
        aFP();
        this.hZL.stopTimer();
        this.hZL.ae(500, 500);
        AppMethodBeat.o(131571);
    }

    public final void aFO() {
        AppMethodBeat.i(131572);
        if (this.hZL != null) {
            this.hZL.stopTimer();
        }
        AppMethodBeat.o(131572);
    }

    private boolean aFP() {
        AppMethodBeat.i(131573);
        if (this.hZJ == null) {
            ab.i("MicroMsg.AppBrandVideoViewControlBar", "updateMiddleBar mStatePorter null");
            AppMethodBeat.o(131573);
            return false;
        }
        int aFg = this.hZJ.aFg();
        int aFh = this.hZJ.aFh();
        if (aFg < 0 || aFh < 0) {
            AppMethodBeat.o(131573);
            return false;
        }
        if (aFg > aFh) {
            aFg = aFh;
        }
        int barLen = getBarLen();
        if (barLen <= 0) {
            AppMethodBeat.o(131573);
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
        AppMethodBeat.o(131573);
        return true;
    }

    public final void seek(int i) {
        AppMethodBeat.i(131574);
        super.seek(i);
        df(this.mPosition, this.qyr);
        AppMethodBeat.o(131574);
    }

    public final void aFQ() {
        AppMethodBeat.i(131575);
        if (this.qyr == 0) {
            AppMethodBeat.o(131575);
        } else if (this.hOy) {
            AppMethodBeat.o(131575);
        } else if (this.qyn == null) {
            AppMethodBeat.o(131575);
        } else {
            this.qyp.setText(AdVideoPlayerLoadingBar.oy(this.mPosition / 60) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + AdVideoPlayerLoadingBar.oy(this.mPosition % 60));
            if (getBarLen() == 0) {
                AppMethodBeat.o(131575);
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
            AppMethodBeat.o(131575);
        }
    }

    public void setShowFullScreenBtn(boolean z) {
        AppMethodBeat.i(131576);
        this.hZO = z;
        aFC();
        aFx();
        AppMethodBeat.o(131576);
    }

    public void setShowPlayBtn(boolean z) {
        AppMethodBeat.i(131577);
        this.hZR = z;
        aFz();
        AppMethodBeat.o(131577);
    }

    public void setShowProgress(boolean z) {
        AppMethodBeat.i(131578);
        this.hZP = z;
        aFS();
        AppMethodBeat.o(131578);
    }

    public final boolean aFR() {
        AppMethodBeat.i(131579);
        if (this.hZD == null) {
            AppMethodBeat.o(131579);
            return false;
        } else if (getVisibility() == 0 && this.hZD.getVisibility() == 0) {
            AppMethodBeat.o(131579);
            return true;
        } else {
            AppMethodBeat.o(131579);
            return false;
        }
    }

    private void aFS() {
        boolean z;
        int i;
        int i2 = 0;
        AppMethodBeat.i(131580);
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
        AppMethodBeat.o(131580);
    }

    private void df(int i, int i2) {
        AppMethodBeat.i(131581);
        if (this.hZT != null) {
            this.hZT.dd(i, i2);
        }
        AppMethodBeat.o(131581);
    }

    public void setVisibility(int i) {
        AppMethodBeat.i(131582);
        super.setVisibility(i);
        if (i == 0) {
            if (this.hZU != null) {
                this.hZU.onVisibilityChanged(true);
                AppMethodBeat.o(131582);
                return;
            }
        } else if ((i == 8 || i == 4) && this.hZU != null) {
            this.hZU.onVisibilityChanged(false);
        }
        AppMethodBeat.o(131582);
    }

    public void setOnUpdateProgressLenListener(d dVar) {
        this.hZT = dVar;
    }

    public void setOnVisibilityChangedListener(e eVar) {
        this.hZU = eVar;
    }

    static /* synthetic */ void a(AppBrandVideoViewControlBar appBrandVideoViewControlBar) {
        AppMethodBeat.i(131583);
        appBrandVideoViewControlBar.hZN = !appBrandVideoViewControlBar.hZN;
        appBrandVideoViewControlBar.aFB();
        AppMethodBeat.o(131583);
    }
}
