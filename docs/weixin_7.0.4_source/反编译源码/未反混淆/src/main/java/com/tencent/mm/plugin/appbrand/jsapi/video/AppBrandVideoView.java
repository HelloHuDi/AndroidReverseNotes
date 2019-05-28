package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView;
import com.tencent.mm.plugin.appbrand.r.m;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppBrandVideoView extends RelativeLayout {
    private static b hYK;
    private int Yp = -1;
    private boolean hLW;
    private boolean hLX;
    private int hLe;
    private RelativeLayout hYL;
    d hYM;
    private TextView hYN;
    private DanmuView hYO;
    com.tencent.mm.plugin.appbrand.jsapi.video.d.a hYP;
    private View hYQ;
    private View hYR;
    private TextView hYS;
    private LinearLayout hYT;
    private AppBrandDotPercentIndicator hYU;
    private TextView hYV;
    private ImageView hYW;
    private ImageView hYX;
    private ImageView hYY;
    private ImageView hYZ;
    private FrameLayout hZa;
    private String hZb;
    private int hZc;
    private c hZd;
    private boolean hZe;
    k hZf;
    private boolean hZg;
    private boolean hZh;
    private l hZi;
    private a hZj;
    private boolean hZk;
    private boolean hZl;
    private double hZm;
    private String hZn;
    private boolean hZo;
    private boolean hZp;
    private boolean hZq;
    private boolean hZr;
    private int hZs;
    private String hZt;
    private boolean hZu;
    private boolean hZv;
    private boolean hZw = false;
    private String mAppId;
    private boolean mAutoPlay;
    private int mDuration;
    private boolean mIsMute;

    public interface a {
        void aDF();

        boolean isFullScreen();

        void on(int i);
    }

    public interface b {
        AppBrandVideoView cM(Context context);
    }

    static /* synthetic */ void j(AppBrandVideoView appBrandVideoView) {
        AppMethodBeat.i(126538);
        appBrandVideoView.aEZ();
        AppMethodBeat.o(126538);
    }

    static /* synthetic */ boolean l(AppBrandVideoView appBrandVideoView) {
        AppMethodBeat.i(126539);
        boolean aFd = appBrandVideoView.aFd();
        AppMethodBeat.o(126539);
        return aFd;
    }

    static /* synthetic */ String oz(int i) {
        AppMethodBeat.i(126543);
        String ox = ox(i);
        AppMethodBeat.o(126543);
        return ox;
    }

    static /* synthetic */ boolean s(AppBrandVideoView appBrandVideoView) {
        AppMethodBeat.i(126541);
        boolean aFe = appBrandVideoView.aFe();
        AppMethodBeat.o(126541);
        return aFe;
    }

    static /* synthetic */ boolean v(AppBrandVideoView appBrandVideoView) {
        AppMethodBeat.i(126542);
        boolean isLive = appBrandVideoView.isLive();
        AppMethodBeat.o(126542);
        return isLive;
    }

    public static void setProxy(b bVar) {
        hYK = bVar;
    }

    public static b aEW() {
        return hYK;
    }

    public <T extends View & d> AppBrandVideoView(Context context, T t) {
        super(context);
        AppMethodBeat.i(126477);
        this.hYM = (d) t;
        init(context);
        this.hYL.addView(t);
        AppMethodBeat.o(126477);
    }

    public AppBrandVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(126478);
        init(context);
        AppMethodBeat.o(126478);
    }

    public AppBrandVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(126479);
        init(context);
        AppMethodBeat.o(126479);
    }

    private void init(Context context) {
        AppMethodBeat.i(126480);
        LayoutInflater.from(context).inflate(R.layout.dt, this);
        this.hYL = (RelativeLayout) findViewById(R.id.wh);
        this.hYN = (TextView) findViewById(R.id.vm);
        this.hYQ = findViewById(R.id.wi);
        this.hYR = findViewById(R.id.wk);
        this.hYS = (TextView) findViewById(R.id.wm);
        this.hYT = (LinearLayout) findViewById(R.id.wo);
        this.hYU = (AppBrandDotPercentIndicator) findViewById(R.id.wr);
        this.hYV = (TextView) findViewById(R.id.wq);
        this.hYW = (ImageView) findViewById(R.id.wp);
        this.hYX = (ImageView) findViewById(R.id.wj);
        this.hYY = (ImageView) findViewById(R.id.wu);
        this.hYZ = (ImageView) findViewById(R.id.wt);
        this.hZa = (FrameLayout) findViewById(R.id.ws);
        this.hYU.setDotsNum(8);
        ((ImageView) findViewById(R.id.wl)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(126441);
                AppBrandVideoView.this.start();
                AppMethodBeat.o(126441);
            }
        });
        aEY();
        aFa();
        AppMethodBeat.o(126480);
    }

    public void setComponent(c cVar) {
        AppMethodBeat.i(126481);
        this.hZd = cVar;
        this.mAppId = cVar.getAppId();
        AppMethodBeat.o(126481);
    }

    public void setConsumeTouchEvent(boolean z) {
        AppMethodBeat.i(126482);
        ab.i("MicroMsg.AppBrandVideoView", "setConsumeTouchEvent game=%s", Boolean.valueOf(z));
        this.hZo = z;
        AppMethodBeat.o(126482);
    }

    public void setVideoPlayerId(int i) {
        this.hZc = i;
    }

    public void setShowMuteBtn(boolean z) {
        AppMethodBeat.i(126483);
        ab.i("MicroMsg.AppBrandVideoView", "showMuteBtn %b", Boolean.valueOf(z));
        this.hYP.setShowMuteBtn(z);
        AppMethodBeat.o(126483);
    }

    public void setTitle(String str) {
        AppMethodBeat.i(126484);
        ab.i("MicroMsg.AppBrandVideoView", "setTitle %s", str);
        this.hYP.setTitle(str);
        AppMethodBeat.o(126484);
    }

    public void setShowControlProgress(boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(126485);
        ab.i("MicroMsg.AppBrandVideoView", "setShowControlProgress %b", Boolean.valueOf(z));
        com.tencent.mm.plugin.appbrand.jsapi.video.d.a aVar = this.hYP;
        if (!z || isLive()) {
            z2 = false;
        }
        aVar.setShowControlProgress(z2);
        AppMethodBeat.o(126485);
    }

    public void setPlayBtnPosition(String str) {
        AppMethodBeat.i(126486);
        ab.i("MicroMsg.AppBrandVideoView", "setPlayBtnPosition: %s", str);
        if (bo.isNullOrNil(str) || !str.equalsIgnoreCase("center")) {
            this.hYP.setPlayBtnInCenterPosition(false);
            AppMethodBeat.o(126486);
            return;
        }
        this.hYP.setPlayBtnInCenterPosition(true);
        AppMethodBeat.o(126486);
    }

    public void setEnablePlayGesture(boolean z) {
        AppMethodBeat.i(126487);
        ab.i("MicroMsg.AppBrandVideoView", "setEnablePlayGesture: %b", Boolean.valueOf(z));
        this.hZv = z;
        AppMethodBeat.o(126487);
    }

    public void setAutoPlay(boolean z) {
        AppMethodBeat.i(126488);
        ab.i("MicroMsg.AppBrandVideoView", "setAutoPlay =%b", Boolean.valueOf(z));
        this.mAutoPlay = z;
        AppMethodBeat.o(126488);
    }

    public void setVideoSource(int i) {
        AppMethodBeat.i(126489);
        ab.i("MicroMsg.AppBrandVideoView", "setVideoSource =%d", Integer.valueOf(i));
        this.hZs = i;
        AppMethodBeat.o(126489);
    }

    public void setDuration(int i) {
        AppMethodBeat.i(126490);
        if (i <= 0) {
            ab.i("MicroMsg.AppBrandVideoView", "setDuration error duration=%d", Integer.valueOf(i));
            AppMethodBeat.o(126490);
            return;
        }
        this.hYS.setText(ox(i));
        this.mDuration = i;
        AppMethodBeat.o(126490);
    }

    public int getDuration() {
        AppMethodBeat.i(126491);
        int i;
        if (this.mDuration > 0) {
            i = this.mDuration;
            AppMethodBeat.o(126491);
            return i;
        }
        i = this.hYM.getVideoDurationSec();
        AppMethodBeat.o(126491);
        return i;
    }

    public void setLoop(boolean z) {
        AppMethodBeat.i(126492);
        ab.i("MicroMsg.AppBrandVideoView", "setLoop loop=%b", Boolean.valueOf(z));
        this.hZl = z;
        AppMethodBeat.o(126492);
    }

    public void setAutoPauseIfNavigate(boolean z) {
        this.hLW = z;
    }

    public void setAutoPauseIfOpenNative(boolean z) {
        this.hLX = z;
    }

    public final void start() {
        AppMethodBeat.i(126493);
        ab.i("MicroMsg.AppBrandVideoView", "start");
        if (this.hYM.isPlaying()) {
            AppMethodBeat.o(126493);
            return;
        }
        if (this.hZe) {
            this.hYP.aFN();
        }
        this.hYQ.setVisibility(8);
        this.hYM.start();
        if (this.hYO != null && this.hYP.aFA()) {
            this.hYO.show();
        }
        ((e) e.B(e.class)).report(this.hZt);
        AppMethodBeat.o(126493);
    }

    public final void pause() {
        AppMethodBeat.i(126494);
        ab.i("MicroMsg.AppBrandVideoView", "pause");
        if (this.hYM.isPlaying()) {
            this.hYM.pause();
            if (this.hYO != null && this.hYP.aFA()) {
                this.hYO.pause();
            }
            AppMethodBeat.o(126494);
            return;
        }
        AppMethodBeat.o(126494);
    }

    public final void stop() {
        AppMethodBeat.i(126495);
        ab.i("MicroMsg.AppBrandVideoView", "stop");
        if (this.hYM.isPlaying()) {
            this.hYM.stop();
            this.hYP.aFO();
            if (this.hYO != null) {
                this.hYO.hide();
            }
            AppMethodBeat.o(126495);
            return;
        }
        AppMethodBeat.o(126495);
    }

    public final void akW() {
        AppMethodBeat.i(126496);
        ab.i("MicroMsg.AppBrandVideoView", "onUIResume");
        if (this.hZw) {
            ab.i("MicroMsg.AppBrandVideoView", "onUIResume, should skip ui resume");
            this.hZw = false;
            AppMethodBeat.o(126496);
            return;
        }
        this.hYM.akW();
        AppMethodBeat.o(126496);
    }

    public final void ow(int i) {
        AppMethodBeat.i(126497);
        ab.i("MicroMsg.AppBrandVideoView", "onUIPause, type:%d", Integer.valueOf(i));
        if ((i != 2 || this.hLX) && (i != 1 || this.hLW)) {
            this.hYM.akV();
            AppMethodBeat.o(126497);
            return;
        }
        ab.i("MicroMsg.AppBrandVideoView", "onUIPause, should skip ui pause");
        this.hZw = true;
        AppMethodBeat.o(126497);
    }

    public final void aEX() {
        AppMethodBeat.i(126498);
        ab.i("MicroMsg.AppBrandVideoView", "onUIDestroy");
        clean();
        AppMethodBeat.o(126498);
    }

    public final void clean() {
        AppMethodBeat.i(126499);
        ab.i("MicroMsg.AppBrandVideoView", "clean");
        stop();
        this.hYM.aEX();
        if (this.hYO != null) {
            this.hYO.clear();
        }
        this.hYP.onDestroy();
        AppMethodBeat.o(126499);
    }

    public final void e(String str, boolean z, int i) {
        AppMethodBeat.i(126500);
        if (!(this.hZd == null || this.hZd.asE() == null || !this.hZd.asE().ca(str))) {
            File yg = this.hZd.asE().yg(str);
            str = yg == null ? null : "file://" + yg.getAbsolutePath();
        }
        ab.i("MicroMsg.AppBrandVideoView", "setVideoPath path=%s isLive=%s", str, Boolean.valueOf(z));
        if (bo.isNullOrNil(str)) {
            ab.v("MicroMsg.AppBrandVideoView", "setVideoPath videoPath empty");
            AppMethodBeat.o(126500);
            return;
        }
        stop();
        this.hZk = z;
        this.hZt = str;
        this.hYM.setVideoSource(this.hZs);
        this.hYM.c(z, str, i);
        if (this.hZm > 0.0d) {
            this.hYM.e(this.hZm, this.mAutoPlay);
        }
        if (this.hZs == 1) {
            String BR = ((e) e.B(e.class)).BR(this.hZt);
            if (BR != null) {
                ab.i("MicroMsg.AppBrandVideoView", "setVideoPath localVideoPath");
                String str2 = this.hZt;
                ab.i("MicroMsg.AppBrandVideoView", "leonlad setPreLoadVidePath videoPath=%s", BR);
                if (!this.hYM.isPlaying() && this.hZt.equalsIgnoreCase(str2)) {
                    this.hZt = str2;
                    this.hYM.c(this.hZk, BR, 0);
                    if (this.mAutoPlay) {
                        ab.i("MicroMsg.AppBrandVideoView", "setPreLoadVidePath autoPlay");
                        start();
                    }
                }
                if (this.hZf != null) {
                    k kVar = this.hZf;
                    try {
                        JSONObject aFV = kVar.aFV();
                        aFV.put("timeStamp", System.currentTimeMillis());
                        aFV.put("url", str2);
                        kVar.a(new a(), aFV);
                    } catch (JSONException e) {
                        ab.e("MicroMsg.JsApiVideoCallback", "onVideoCanPlay e=%s", e);
                    }
                }
            }
        }
        if (this.mAutoPlay) {
            ab.i("MicroMsg.AppBrandVideoView", "setVideoPath autoPlay");
            start();
        }
        setCover(str);
        AppMethodBeat.o(126500);
    }

    public final void d(double d, boolean z) {
        AppMethodBeat.i(126501);
        ab.i("MicroMsg.AppBrandVideoView", "seek to position=%s current=%d isLive=%b", Double.valueOf(d), Integer.valueOf(this.hYM.getCurrPosSec()), Boolean.valueOf(this.hZk));
        if (isLive()) {
            AppMethodBeat.o(126501);
            return;
        }
        this.hYQ.setVisibility(8);
        if (z) {
            this.hYM.e(d, z);
        } else {
            this.hYM.s(d);
        }
        if (this.hYO != null && ((double) r0) > d) {
            DanmuView danmuView = this.hYO;
            ab.i("MicroMsg.DanmuView", "seekToPlayTime playTime=%d", Integer.valueOf((int) d));
            danmuView.aGh();
            danmuView.aGj();
            danmuView.prepare();
            d.post(new com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.AnonymousClass5(r1), "DanmuView-seekToPlayTime");
        }
        AppMethodBeat.o(126501);
    }

    public void setIsShowBasicControls(boolean z) {
        AppMethodBeat.i(126502);
        ab.i("MicroMsg.AppBrandVideoView", "setIsShowBasicControls isShowBasicControls=%b", Boolean.valueOf(z));
        this.hZe = z;
        if (this.hYP != null) {
            if (this.hZe) {
                this.hYP.aFD();
                AppMethodBeat.o(126502);
                return;
            }
            this.hYP.hide();
        }
        AppMethodBeat.o(126502);
    }

    public final void setCover$16da05f7(String str) {
        AppMethodBeat.i(126503);
        ab.i("MicroMsg.AppBrandVideoView", "setCover coverUrl=%s", str);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(126503);
            return;
        }
        this.hZn = str;
        com.tencent.mm.modelappbrand.a.b.abR().a(this.hYX, str, null, null);
        AppMethodBeat.o(126503);
    }

    private void setCover(final String str) {
        AppMethodBeat.i(126504);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(126504);
        } else if (bo.isNullOrNil(this.hZn)) {
            m.aNS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(126450);
                    final Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 1);
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(126449);
                            if (!(createVideoThumbnail == null || createVideoThumbnail.isRecycled())) {
                                AppBrandVideoView.this.hYX.setImageBitmap(createVideoThumbnail);
                            }
                            AppMethodBeat.o(126449);
                        }
                    });
                    AppMethodBeat.o(126450);
                }
            });
            AppMethodBeat.o(126504);
        } else {
            ab.i("MicroMsg.AppBrandVideoView", "setCover mCoverUrl not null");
            AppMethodBeat.o(126504);
        }
    }

    public void setShowProgress(boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(126505);
        ab.i("MicroMsg.AppBrandVideoView", "setShowProgress %b", Boolean.valueOf(z));
        this.hZq = z;
        com.tencent.mm.plugin.appbrand.jsapi.video.d.a aVar = this.hYP;
        if (!z || isLive()) {
            z2 = false;
        }
        aVar.setShowProgress(z2);
        AppMethodBeat.o(126505);
    }

    public void setShowFullScreenBtn(boolean z) {
        AppMethodBeat.i(126506);
        ab.i("MicroMsg.AppBrandVideoView", "setShowFullScreenBtn %b", Boolean.valueOf(z));
        this.hYP.setShowFullScreenBtn(z);
        AppMethodBeat.o(126506);
    }

    public void setShowPlayBtn(boolean z) {
        AppMethodBeat.i(126507);
        ab.i("MicroMsg.AppBrandVideoView", "setShowPlayBtn %b", Boolean.valueOf(z));
        this.hYP.setShowPlayBtn(z);
        AppMethodBeat.o(126507);
    }

    public final void eq(boolean z) {
        AppMethodBeat.i(126508);
        ab.i("MicroMsg.AppBrandVideoView", "enableProgressGesture %b", Boolean.valueOf(z));
        this.hZp = z;
        AppMethodBeat.o(126508);
    }

    public void setShowCenterPlayBtn(boolean z) {
        int i = 0;
        AppMethodBeat.i(126509);
        ab.i("MicroMsg.AppBrandVideoView", "setPlayBtnInCenterPosition %b", Boolean.valueOf(z));
        this.hZr = z;
        this.hYQ.setVisibility(z ? 0 : 8);
        View view = this.hYR;
        if (!z) {
            i = 8;
        }
        view.setVisibility(i);
        if (this.hZr && this.hYP != null) {
            this.hYP.hide();
        }
        AppMethodBeat.o(126509);
    }

    public void setDanmakuEnable(boolean z) {
        AppMethodBeat.i(126510);
        ab.i("MicroMsg.AppBrandVideoView", "setDanmakuEnable isEnable=%b", Boolean.valueOf(z));
        this.hYP.setDanmakuBtnOpen(z);
        AppMethodBeat.o(126510);
    }

    public void setShowDanmakuBtn(boolean z) {
        AppMethodBeat.i(126511);
        ab.i("MicroMsg.AppBrandVideoView", "setShowDanmakuBtn showDanmakuBtn=%b", Boolean.valueOf(z));
        if (z) {
            if (this.hYO == null) {
                aFc();
            }
            this.hYP.setDanmakuBtnOnClickListener(new f() {
                public final void es(boolean z) {
                    AppMethodBeat.i(126451);
                    if (!z) {
                        AppBrandVideoView.this.hYO.hide();
                    } else if (AppBrandVideoView.this.hYM.isPlaying()) {
                        AppBrandVideoView.this.hYO.show();
                    } else {
                        AppBrandVideoView.this.hYO.pause();
                    }
                    if (AppBrandVideoView.this.hZf != null) {
                        k d = AppBrandVideoView.this.hZf;
                        int e = AppBrandVideoView.this.hZc;
                        try {
                            ab.i("MicroMsg.JsApiVideoCallback", "onVideoClickDanmuBtn showDanmu=%b", Boolean.valueOf(z));
                            JSONObject aFV = d.aFV();
                            aFV.put("showDanmu", z);
                            aFV.put("videoPlayerId", e);
                            d.a(new b(), aFV);
                            AppMethodBeat.o(126451);
                            return;
                        } catch (JSONException e2) {
                            ab.e("MicroMsg.JsApiVideoCallback", "onVideoClickDanmuBtn e=%s", e2);
                        }
                    }
                    AppMethodBeat.o(126451);
                }
            });
        }
        this.hYP.setShowDanmakuBtn(z);
        AppMethodBeat.o(126511);
    }

    public void setObjectFit(String str) {
        AppMethodBeat.i(126512);
        ab.i("MicroMsg.AppBrandVideoView", "setObjectFit objectFit=%s", str);
        if ("fill".equalsIgnoreCase(str)) {
            this.hYM.setScaleType(g.FILL);
            this.hYX.setScaleType(ScaleType.FIT_XY);
            AppMethodBeat.o(126512);
        } else if ("cover".equalsIgnoreCase(str)) {
            this.hYM.setScaleType(g.COVER);
            this.hYX.setScaleType(ScaleType.CENTER_CROP);
            AppMethodBeat.o(126512);
        } else {
            this.hYM.setScaleType(g.CONTAIN);
            this.hYX.setScaleType(ScaleType.FIT_CENTER);
            AppMethodBeat.o(126512);
        }
    }

    public void setMute(boolean z) {
        AppMethodBeat.i(126513);
        ab.i("MicroMsg.AppBrandVideoView", "setMute isMute=%b", Boolean.valueOf(z));
        this.mIsMute = z;
        this.hYM.setMute(z);
        this.hYP.setMuteBtnState(z);
        AppMethodBeat.o(126513);
    }

    public void setCookieData(String str) {
        this.hZb = str;
    }

    public String getCookieData() {
        return this.hZb;
    }

    public int getCurrPosSec() {
        AppMethodBeat.i(126514);
        int currPosSec = this.hYM.getCurrPosSec();
        AppMethodBeat.o(126514);
        return currPosSec;
    }

    public int getCurrPosMs() {
        AppMethodBeat.i(126515);
        int currPosMs = this.hYM.getCurrPosMs();
        AppMethodBeat.o(126515);
        return currPosMs;
    }

    public int getCacheTimeSec() {
        AppMethodBeat.i(126516);
        if (this.hYM != null) {
            int cacheTimeSec = this.hYM.getCacheTimeSec();
            AppMethodBeat.o(126516);
            return cacheTimeSec;
        }
        AppMethodBeat.o(126516);
        return 0;
    }

    public void setFullScreenDirection(int i) {
        AppMethodBeat.i(126517);
        ab.i("MicroMsg.AppBrandVideoView", "setFullScreenDirection %d", Integer.valueOf(i));
        this.Yp = i;
        AppMethodBeat.o(126517);
    }

    public void setPageGesture(boolean z) {
        AppMethodBeat.i(126518);
        ab.i("MicroMsg.AppBrandVideoView", "setPageGesture pageGesture=%b", Boolean.valueOf(z));
        this.hZg = z;
        AppMethodBeat.o(126518);
    }

    public void setPageGestureInFullscreen(boolean z) {
        AppMethodBeat.i(126519);
        ab.i("MicroMsg.AppBrandVideoView", "setPageGestureInFullscreen pageGestureInFullscreen=%b", Boolean.valueOf(z));
        this.hZh = z;
        AppMethodBeat.o(126519);
    }

    public void setInitialTime(double d) {
        AppMethodBeat.i(126520);
        ab.i("MicroMsg.AppBrandVideoView", "setInitialTime initialTime=%s", Double.valueOf(d));
        this.hZm = d;
        AppMethodBeat.o(126520);
    }

    public void setCallback(k kVar) {
        this.hZf = kVar;
    }

    public void setDanmakuItemList(JSONArray jSONArray) {
        AppMethodBeat.i(126521);
        if (jSONArray == null) {
            AppMethodBeat.o(126521);
            return;
        }
        String str = "MicroMsg.AppBrandVideoView";
        String str2 = "setDanmakuItemList length=%d";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(jSONArray != null ? jSONArray.length() : 0);
        ab.i(str, str2, objArr);
        if (this.hYO == null) {
            ab.w("MicroMsg.AppBrandVideoView", " setDanmakuItemList mDanmakuView null");
            aFc();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj;
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject == null) {
                obj = null;
            } else {
                int optInt = optJSONObject.optInt("time", 0);
                String optString = optJSONObject.optString("text", "");
                int Ee = com.tencent.mm.plugin.appbrand.r.g.Ee(optJSONObject.optString("color", ""));
                if (Ee == 0) {
                    Ee = -1;
                }
                com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a obj2 = new com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a(getContext(), new SpannableString(optString), Ee, optInt);
            }
            if (obj2 != null) {
                arrayList.add(obj2);
            }
        }
        DanmuView danmuView = this.hYO;
        danmuView.aGh();
        danmuView.aGj();
        danmuView.ibg.clear();
        danmuView.prepare();
        if (arrayList.isEmpty()) {
            danmuView.aGi();
            AppMethodBeat.o(126521);
            return;
        }
        new com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.AnonymousClass4(arrayList).start();
        danmuView.aGi();
        AppMethodBeat.o(126521);
    }

    public final boolean co(String str, String str2) {
        AppMethodBeat.i(126522);
        if (this.hYO == null) {
            ab.w("MicroMsg.AppBrandVideoView", " addDanmaku mDanmakuView null");
            aFc();
        }
        int Ee = com.tencent.mm.plugin.appbrand.r.g.Ee(str2);
        if (Ee == 0) {
            Ee = -1;
        }
        com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a aVar = new com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a(getContext(), new SpannableString(str), Ee, this.hYM.getCurrPosSec());
        DanmuView danmuView = this.hYO;
        synchronized (danmuView.ibf) {
            try {
                danmuView.ibf.offerFirst(aVar);
                d.post(new com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.AnonymousClass3(aVar), "DanmuView-addItemToWaitingHead");
            } finally {
                while (true) {
                }
                AppMethodBeat.o(126522);
            }
        }
        return true;
    }

    public void setFullScreenDelegate(a aVar) {
        this.hZj = aVar;
    }

    public k getCallback() {
        return this.hZf;
    }

    private void aEY() {
        AppMethodBeat.i(126523);
        this.hZi = new l(getContext(), this, new com.tencent.mm.plugin.appbrand.jsapi.video.l.b() {
            public final void aFi() {
                AppMethodBeat.i(126452);
                ab.d("MicroMsg.AppBrandVideoView", "onSingleTap");
                if (AppBrandVideoView.this.hZe && AppBrandVideoView.this.hYQ.getVisibility() != 0) {
                    AppBrandVideoView.this.hYP.aFG();
                    if (AppBrandVideoView.this.hZu) {
                        AppBrandVideoView.j(AppBrandVideoView.this);
                    }
                }
                AppMethodBeat.o(126452);
            }

            public final void aFj() {
                AppMethodBeat.i(126453);
                ab.d("MicroMsg.AppBrandVideoView", "onDoubleTap");
                if (AppBrandVideoView.this.hZv) {
                    if (AppBrandVideoView.this.hYM.isPlaying()) {
                        AppBrandVideoView.this.pause();
                        AppMethodBeat.o(126453);
                        return;
                    }
                    AppBrandVideoView.this.start();
                }
                AppMethodBeat.o(126453);
            }

            public final void aFk() {
                AppMethodBeat.i(126454);
                if (AppBrandVideoView.l(AppBrandVideoView.this)) {
                    AppBrandVideoView.this.hYN.setVisibility(0);
                    AppBrandVideoView.j(AppBrandVideoView.this);
                    AppMethodBeat.o(126454);
                    return;
                }
                AppMethodBeat.o(126454);
            }

            public final int i(int i, float f) {
                AppMethodBeat.i(126455);
                if (AppBrandVideoView.l(AppBrandVideoView.this)) {
                    ab.i("MicroMsg.AppBrandVideoView", "onDragProgress:" + i + "/" + f);
                    int videoDurationSec = AppBrandVideoView.this.hYM.getVideoDurationSec();
                    int c = b.c(f, (float) AppBrandVideoView.this.getMeasuredWidth(), getCurrentPosition(), videoDurationSec);
                    AppBrandVideoView.this.hYN.setText(m.fQ(((long) c) * 1000) + "/" + m.fQ(((long) videoDurationSec) * 1000));
                    AppBrandVideoView.this.hYP.seek(c);
                    if (AppBrandVideoView.this.hYP.aFF()) {
                        AppBrandVideoView.this.hYP.aFE();
                    }
                    AppMethodBeat.o(126455);
                    return c;
                }
                AppMethodBeat.o(126455);
                return 0;
            }

            public final void j(int i, float f) {
                AppMethodBeat.i(126456);
                if (AppBrandVideoView.l(AppBrandVideoView.this)) {
                    AppBrandVideoView.this.hYN.setVisibility(8);
                    AppBrandVideoView.n(AppBrandVideoView.this);
                    int currPosSec = AppBrandVideoView.this.hYM.getCurrPosSec();
                    ab.i("MicroMsg.AppBrandVideoView", "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", Integer.valueOf(i), Integer.valueOf(currPosSec), Float.valueOf(f));
                    AppBrandVideoView.this.d((double) i, false);
                    AppMethodBeat.o(126456);
                    return;
                }
                AppMethodBeat.o(126456);
            }

            public final int getCurrentPosition() {
                AppMethodBeat.i(126457);
                int currPosSec = AppBrandVideoView.this.hYM.getCurrPosSec();
                AppMethodBeat.o(126457);
                return currPosSec;
            }

            public final boolean aFn() {
                AppMethodBeat.i(139051);
                boolean s = AppBrandVideoView.s(AppBrandVideoView.this);
                AppMethodBeat.o(139051);
                return s;
            }

            public final boolean aFo() {
                AppMethodBeat.i(139052);
                boolean s = AppBrandVideoView.s(AppBrandVideoView.this);
                AppMethodBeat.o(139052);
                return s;
            }

            public final boolean aFp() {
                AppMethodBeat.i(126464);
                boolean l = AppBrandVideoView.l(AppBrandVideoView.this);
                AppMethodBeat.o(126464);
                return l;
            }

            public final void aq(float f) {
                AppMethodBeat.i(126458);
                if (AppBrandVideoView.s(AppBrandVideoView.this)) {
                    ab.d("MicroMsg.AppBrandVideoView", "onAdjustVolume:".concat(String.valueOf(f)));
                    AppBrandVideoView.this.hYU.setPercent(f);
                    AppBrandVideoView.this.hYV.setText(R.string.cu9);
                    AppBrandVideoView.this.hYW.setImageResource(R.drawable.asi);
                    AppBrandVideoView.this.hYT.setVisibility(0);
                    AppBrandVideoView.j(AppBrandVideoView.this);
                    AppMethodBeat.o(126458);
                    return;
                }
                AppMethodBeat.o(126458);
            }

            public final void ar(float f) {
                AppMethodBeat.i(126459);
                if (AppBrandVideoView.s(AppBrandVideoView.this)) {
                    ab.d("MicroMsg.AppBrandVideoView", "onAdjustBrightness:".concat(String.valueOf(f)));
                    AppBrandVideoView.this.hYU.setPercent(f);
                    AppBrandVideoView.this.hYV.setText(R.string.cu8);
                    AppBrandVideoView.this.hYW.setImageResource(R.drawable.asg);
                    AppBrandVideoView.this.hYT.setVisibility(0);
                    AppBrandVideoView.j(AppBrandVideoView.this);
                    AppMethodBeat.o(126459);
                    return;
                }
                AppMethodBeat.o(126459);
            }

            public final void aFl() {
                AppMethodBeat.i(126460);
                if (AppBrandVideoView.s(AppBrandVideoView.this)) {
                    AppBrandVideoView.this.hYT.setVisibility(8);
                    AppBrandVideoView.n(AppBrandVideoView.this);
                    AppMethodBeat.o(126460);
                    return;
                }
                AppMethodBeat.o(126460);
            }

            public final void aFm() {
                AppMethodBeat.i(126461);
                if (AppBrandVideoView.s(AppBrandVideoView.this)) {
                    AppBrandVideoView.this.hYT.setVisibility(8);
                    AppBrandVideoView.n(AppBrandVideoView.this);
                    AppMethodBeat.o(126461);
                    return;
                }
                AppMethodBeat.o(126461);
            }
        });
        AppMethodBeat.o(126523);
    }

    private void aEZ() {
        AppMethodBeat.i(126524);
        this.hYP.aEZ();
        AppMethodBeat.o(126524);
    }

    private void aFa() {
        AppMethodBeat.i(126525);
        this.hYM.setIMMVideoViewCallback(new com.tencent.mm.plugin.appbrand.jsapi.video.d.b() {
            public final void H(String str, int i, int i2) {
                AppMethodBeat.i(126465);
                ab.i("MicroMsg.AppBrandVideoView", "onError errorMsg=%s what=%d extra=%d", str, Integer.valueOf(i), Integer.valueOf(i2));
                if (AppBrandVideoView.this.hZf != null) {
                    k d = AppBrandVideoView.this.hZf;
                    d.clean();
                    try {
                        JSONObject aFV = d.aFV();
                        aFV.put("errMsg", str);
                        d.a(new d(), aFV);
                        AppMethodBeat.o(126465);
                        return;
                    } catch (JSONException e) {
                        ab.e("MicroMsg.JsApiVideoCallback", "onError e=%s", e);
                    }
                }
                AppMethodBeat.o(126465);
            }

            public final void aFq() {
                AppMethodBeat.i(126466);
                ab.i("MicroMsg.AppBrandVideoView", "onPrepared");
                AppBrandVideoView.this.hZi.aFY();
                AppMethodBeat.o(126466);
            }

            public final void aFr() {
                AppMethodBeat.i(126467);
                ab.i("MicroMsg.AppBrandVideoView", "onVideoEnded");
                AppBrandVideoView.this.hYN.setVisibility(8);
                AppBrandVideoView.this.hYQ.setVisibility(0);
                if (AppBrandVideoView.this.hYP.aFF()) {
                    AppBrandVideoView.this.hYP.hide();
                }
                if (AppBrandVideoView.this.hZa.getVisibility() == 0) {
                    AppBrandVideoView.this.hZa.setVisibility(8);
                }
                if (AppBrandVideoView.v(AppBrandVideoView.this) || !AppBrandVideoView.this.hZr) {
                    AppBrandVideoView.this.hYR.setVisibility(8);
                } else {
                    if (AppBrandVideoView.this.mDuration <= 0) {
                        AppBrandVideoView.this.hYS.setText(AppBrandVideoView.oz(AppBrandVideoView.this.hYM.getVideoDurationSec()));
                    }
                    AppBrandVideoView.this.hYR.setVisibility(0);
                }
                if (AppBrandVideoView.this.hZf != null) {
                    k d = AppBrandVideoView.this.hZf;
                    try {
                        d.a(new c(), d.aFV());
                    } catch (JSONException e) {
                        ab.e("MicroMsg.JsApiVideoCallback", "OnVideoEnded e=%s", e);
                    }
                    d.aFW();
                    d.aFX();
                }
                if (AppBrandVideoView.this.hZl) {
                    AppBrandVideoView.this.d(0.0d, true);
                }
                AppMethodBeat.o(126467);
            }

            public final void de(int i, int i2) {
                AppMethodBeat.i(126468);
                ab.i("MicroMsg.AppBrandVideoView", "onGetVideoSize width=%d height=%d", Integer.valueOf(i), Integer.valueOf(i2));
                if (AppBrandVideoView.this.Yp == -1) {
                    AppBrandVideoView.this.Yp = i < i2 ? 0 : 90;
                    ab.i("MicroMsg.AppBrandVideoView", "onGetVideoSize adjust direction from AUTO to %s", Integer.valueOf(AppBrandVideoView.this.Yp));
                }
                if (AppBrandVideoView.this.hZf != null) {
                    k d = AppBrandVideoView.this.hZf;
                    try {
                        ab.i("MicroMsg.JsApiVideoCallback", "onVideoLoadedMetaData, width:%d, height:%d, duration:%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(AppBrandVideoView.this.getDuration()));
                        JSONObject aFV = d.aFV();
                        aFV.put("width", i);
                        aFV.put("height", i2);
                        aFV.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, (((double) r2) * 1.0d) / 1000.0d);
                        d.a(new f(), aFV);
                        AppMethodBeat.o(126468);
                        return;
                    } catch (JSONException e) {
                        ab.e("MicroMsg.JsApiVideoCallback", "onVideoLoadedMetaData e=%s", e);
                    }
                }
                AppMethodBeat.o(126468);
            }

            public final void aFs() {
                AppMethodBeat.i(126469);
                ab.i("MicroMsg.AppBrandVideoView", "onVideoPause");
                if (AppBrandVideoView.this.hZf != null) {
                    k d = AppBrandVideoView.this.hZf;
                    try {
                        d.a(new g(), d.aFV());
                    } catch (JSONException e) {
                        ab.e("MicroMsg.JsApiVideoCallback", "OnVideoPause e=%s", e);
                    }
                    d.aFW();
                }
                AppMethodBeat.o(126469);
            }

            public final void aFt() {
                AppMethodBeat.i(126470);
                ab.i("MicroMsg.AppBrandVideoView", "onVideoPlay, isLive:%b", Boolean.valueOf(AppBrandVideoView.v(AppBrandVideoView.this)));
                if (AppBrandVideoView.this.mDuration <= 0 && !AppBrandVideoView.v(AppBrandVideoView.this)) {
                    AppBrandVideoView.this.hYS.setText(AppBrandVideoView.oz(AppBrandVideoView.this.hYM.getVideoDurationSec()));
                }
                AppBrandVideoView.a(AppBrandVideoView.this, AppBrandVideoView.v(AppBrandVideoView.this));
                if (AppBrandVideoView.this.hZe) {
                    AppBrandVideoView.C(AppBrandVideoView.this);
                }
                if (AppBrandVideoView.this.hZf != null) {
                    k d = AppBrandVideoView.this.hZf;
                    try {
                        d.iat = 0;
                        JSONObject aFV = d.aFV();
                        aFV.put("timeStamp", System.currentTimeMillis());
                        d.a(new h(), aFV);
                        if (d.ias == null) {
                            d.ias = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
                                public final boolean BI() {
                                    AppMethodBeat.i(126570);
                                    try {
                                        int currPosMs = k.this.iaq.getCurrPosMs();
                                        if (Math.abs(currPosMs - k.this.iat) < 250) {
                                            AppMethodBeat.o(126570);
                                            return true;
                                        }
                                        JSONObject aFV = k.this.aFV();
                                        k.this.iat = currPosMs;
                                        aFV.put("position", new BigDecimal((((double) currPosMs) * 1.0d) / 1000.0d).setScale(3, 4).doubleValue());
                                        aFV.put(FFmpegMetadataRetriever.METADATA_KEY_DURATION, k.this.iaq.getDuration());
                                        k.this.a(new l(), aFV);
                                        AppMethodBeat.o(126570);
                                        return true;
                                    } catch (JSONException e) {
                                        ab.e("MicroMsg.JsApiVideoCallback", "OnVideoTimeUpdate e=%s", e);
                                    }
                                }
                            }, true);
                        }
                        d.ias.ae(250, 250);
                        if (d.hZL == null) {
                            d.hZL = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
                                public final boolean BI() {
                                    AppMethodBeat.i(126571);
                                    if (k.this.iaq != null) {
                                        int cacheTimeSec = k.this.iaq.getCacheTimeSec();
                                        int duration = k.this.iaq.getDuration();
                                        if (duration != 0) {
                                            cacheTimeSec = (int) ((((float) cacheTimeSec) * 100.0f) / ((float) duration));
                                            if (cacheTimeSec != k.this.iau) {
                                                k.this.iau = cacheTimeSec;
                                                k kVar = k.this;
                                                try {
                                                    ab.i("MicroMsg.JsApiVideoCallback", "onVideoCacheUpdate, percent:%d", Integer.valueOf(cacheTimeSec));
                                                    JSONObject aFV = kVar.aFV();
                                                    aFV.put("buffered", cacheTimeSec);
                                                    kVar.a(new i(), aFV);
                                                } catch (JSONException e) {
                                                    ab.e("MicroMsg.JsApiVideoCallback", "onVideoCacheUpdate e=%s", e);
                                                }
                                            }
                                        }
                                    }
                                    AppMethodBeat.o(126571);
                                    return true;
                                }
                            }, true);
                        }
                        d.hZL.ae(500, 500);
                        AppMethodBeat.o(126470);
                        return;
                    } catch (JSONException e) {
                        ab.e("MicroMsg.JsApiVideoCallback", "OnVideoPlay e=%s", e);
                    }
                }
                AppMethodBeat.o(126470);
            }

            public final void aFu() {
                AppMethodBeat.i(126471);
                ab.i("MicroMsg.AppBrandVideoView", "onVideoWaiting");
                if (AppBrandVideoView.this.hZf != null) {
                    k d = AppBrandVideoView.this.hZf;
                    try {
                        JSONObject aFV = d.aFV();
                        aFV.put("timeStamp", System.currentTimeMillis());
                        d.a(new m(), aFV);
                    } catch (JSONException e) {
                        ab.e("MicroMsg.JsApiVideoCallback", "onVideoWaiting e=%s", e);
                    }
                }
                AppBrandVideoView.this.hZu = true;
                AppBrandVideoView.j(AppBrandVideoView.this);
                AppMethodBeat.o(126471);
            }

            public final void aFv() {
                AppMethodBeat.i(126472);
                AppBrandVideoView.this.hZu = false;
                AppBrandVideoView.n(AppBrandVideoView.this);
                AppMethodBeat.o(126472);
            }
        });
        AppMethodBeat.o(126525);
    }

    public final void j(boolean z, int i) {
        AppMethodBeat.i(126527);
        ab.i("MicroMsg.AppBrandVideoView", "operateFullScreen toFullScreen:%b direction:%d", Boolean.valueOf(z), Integer.valueOf(i));
        if (this.hZj == null) {
            ab.w("MicroMsg.AppBrandVideoView", "operateFullScreen mFullScreenDelegate null");
            AppMethodBeat.o(126527);
        } else if (z == aFb()) {
            ab.i("MicroMsg.AppBrandVideoView", "operateFullScreen current same");
            AppMethodBeat.o(126527);
        } else {
            int i2;
            if (i == -1) {
                i2 = this.Yp == -1 ? 90 : this.Yp;
                ab.i("MicroMsg.AppBrandVideoView", "operateFullScreen target direction:%d", Integer.valueOf(i2));
            } else {
                i2 = i;
            }
            if (z) {
                this.hLe = i2;
                this.hZj.on(i2);
                this.hYP.aFH();
                er(true);
                AppMethodBeat.o(126527);
                return;
            }
            this.hZj.aDF();
            this.hYP.aDF();
            AppMethodBeat.o(126527);
        }
    }

    public final boolean aFb() {
        AppMethodBeat.i(126528);
        if (this.hZj == null) {
            ab.w("MicroMsg.AppBrandVideoView", "isInFullScreen mFullScreenDelegate null");
            AppMethodBeat.o(126528);
            return false;
        }
        boolean isFullScreen = this.hZj.isFullScreen();
        AppMethodBeat.o(126528);
        return isFullScreen;
    }

    private void aFc() {
        AppMethodBeat.i(126529);
        this.hYO = (DanmuView) findViewById(R.id.wn);
        this.hYO.setDanmuViewCallBack(new com.tencent.mm.plugin.appbrand.jsapi.video.danmu.c() {
            public final int afA() {
                AppMethodBeat.i(126473);
                int currPosSec = AppBrandVideoView.this.hYM.getCurrPosSec();
                AppMethodBeat.o(126473);
                return currPosSec;
            }
        });
        this.hYO.aGm();
        this.hYO.setMaxRunningPerRow(5);
        this.hYO.setPickItemInterval(200);
        this.hYO.hide();
        if (this.hYM != null && ((View) this.hYM).getHeight() > 0) {
            int height = (int) (((float) ((View) this.hYM).getHeight()) * this.hYO.getYOffset());
            this.hYO.setMaxRow((int) (((float) height) / com.tencent.mm.plugin.appbrand.jsapi.video.danmu.b.cO(getContext())));
        }
        AppMethodBeat.o(126529);
    }

    public final void a(com.tencent.mm.plugin.appbrand.jsapi.video.d.a aVar) {
        AppMethodBeat.i(126530);
        this.hYP = aVar;
        this.hYP.hide();
        this.hYP.setFullScreenBtnOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(126474);
                boolean z = !AppBrandVideoView.this.aFb();
                AppBrandVideoView appBrandVideoView = AppBrandVideoView.this;
                appBrandVideoView.j(z, appBrandVideoView.Yp);
                AppMethodBeat.o(126474);
            }
        });
        this.hYP.setIplaySeekCallback(new d.c() {
            public final void aFw() {
                AppMethodBeat.i(126475);
                ab.i("MicroMsg.AppBrandVideoView", "onSeekPre");
                AppMethodBeat.o(126475);
            }

            public final void oA(int i) {
                AppMethodBeat.i(126476);
                AppBrandVideoView.this.d((double) i, false);
                AppMethodBeat.o(126476);
            }
        });
        this.hYP.setOnPlayButtonClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(126442);
                if (AppBrandVideoView.this.hYM.isPlaying()) {
                    AppBrandVideoView.this.pause();
                    AppMethodBeat.o(126442);
                    return;
                }
                AppBrandVideoView.this.start();
                AppMethodBeat.o(126442);
            }
        });
        this.hYP.setStatePorter(new h() {
            public final int aFg() {
                AppMethodBeat.i(126443);
                int cacheTimeSec = AppBrandVideoView.this.hYM.getCacheTimeSec();
                AppMethodBeat.o(126443);
                return cacheTimeSec;
            }

            public final int aFh() {
                AppMethodBeat.i(126444);
                int videoDurationSec = AppBrandVideoView.this.hYM.getVideoDurationSec();
                AppMethodBeat.o(126444);
                return videoDurationSec;
            }
        });
        this.hYP.setMuteBtnOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(126445);
                AppBrandVideoView.this.setMute(!AppBrandVideoView.this.mIsMute);
                AppMethodBeat.o(126445);
            }
        });
        this.hYP.setExitFullScreenBtnOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(126446);
                AppBrandVideoView.this.j(false, AppBrandVideoView.this.Yp);
                AppMethodBeat.o(126446);
            }
        });
        this.hYP.setOnVisibilityChangedListener(new d.e() {
            public final void onVisibilityChanged(boolean z) {
                AppMethodBeat.i(126447);
                AppBrandVideoView.C(AppBrandVideoView.this);
                AppMethodBeat.o(126447);
            }
        });
        this.hYP.setOnUpdateProgressLenListener(new d.d() {
            public final void dd(int i, int i2) {
                AppMethodBeat.i(126448);
                if (i2 <= 0) {
                    AppMethodBeat.o(126448);
                    return;
                }
                int i3;
                if (i < 0) {
                    i3 = 0;
                } else {
                    i3 = i;
                }
                if (i3 > i2) {
                    i3 = i2;
                }
                int width = (i3 * AppBrandVideoView.this.hYZ.getWidth()) / i2;
                LayoutParams layoutParams = (LayoutParams) AppBrandVideoView.this.hYY.getLayoutParams();
                layoutParams.width = width;
                AppBrandVideoView.this.hYY.setLayoutParams(layoutParams);
                AppBrandVideoView.this.hYY.requestLayout();
                AppMethodBeat.o(126448);
            }
        });
        this.hYM.setControlBar(aVar);
        AppMethodBeat.o(126530);
    }

    private static String ox(int i) {
        AppMethodBeat.i(126531);
        String str = oy(i / 60) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + oy(i % 60);
        AppMethodBeat.o(126531);
        return str;
    }

    private static String oy(int i) {
        AppMethodBeat.i(126532);
        String concat;
        if (i < 10) {
            concat = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(i));
            AppMethodBeat.o(126532);
            return concat;
        }
        concat = String.valueOf(i);
        AppMethodBeat.o(126532);
        return concat;
    }

    /* Access modifiers changed, original: final */
    public final void er(boolean z) {
        AppMethodBeat.i(126533);
        if (this.hZf == null) {
            AppMethodBeat.o(126533);
            return;
        }
        this.hZf.c(this.hZc, z, this.hLe);
        AppMethodBeat.o(126533);
    }

    private boolean isLive() {
        AppMethodBeat.i(126534);
        ab.i("MicroMsg.AppBrandVideoView", "isLive %b %b", Boolean.valueOf(this.hZk), Boolean.valueOf(this.hYM.isLive()));
        if (this.hZk || this.hYM.isLive()) {
            AppMethodBeat.o(126534);
            return true;
        }
        AppMethodBeat.o(126534);
        return false;
    }

    private boolean aFd() {
        AppMethodBeat.i(126535);
        if (!this.hZp || this.hYM.isLive() || aFf()) {
            AppMethodBeat.o(126535);
            return false;
        }
        AppMethodBeat.o(126535);
        return true;
    }

    private boolean aFe() {
        AppMethodBeat.i(126536);
        if (aFf() || ((aFb() || !this.hZg) && !(aFb() && this.hZh))) {
            AppMethodBeat.o(126536);
            return false;
        }
        AppMethodBeat.o(126536);
        return true;
    }

    private boolean aFf() {
        AppMethodBeat.i(126537);
        if (this.hYQ.getVisibility() == 0) {
            AppMethodBeat.o(126537);
            return true;
        }
        AppMethodBeat.o(126537);
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        AppMethodBeat.i(126526);
        if (this.hZv) {
            z = true;
        } else {
            z = aFd();
            if (!aFe()) {
                z = false;
            }
        }
        if (z) {
            if (this.hZi != null) {
                this.hZi.z(motionEvent);
            }
            AppMethodBeat.o(126526);
            return true;
        }
        if (motionEvent.getAction() == 0 && this.hZe && this.hYQ.getVisibility() != 0) {
            this.hYP.aFG();
            if (this.hZu) {
                aEZ();
            }
        }
        if (this.hZo) {
            AppMethodBeat.o(126526);
            return true;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(126526);
        return onTouchEvent;
    }

    static /* synthetic */ void n(AppBrandVideoView appBrandVideoView) {
        AppMethodBeat.i(126540);
        appBrandVideoView.hYP.aFy();
        AppMethodBeat.o(126540);
    }

    static /* synthetic */ void C(AppBrandVideoView appBrandVideoView) {
        AppMethodBeat.i(126545);
        boolean aFR = appBrandVideoView.hYP.aFR();
        if (!appBrandVideoView.hZe || !appBrandVideoView.hZq || aFR || appBrandVideoView.isLive() || appBrandVideoView.aFf()) {
            appBrandVideoView.hZa.setVisibility(8);
            AppMethodBeat.o(126545);
            return;
        }
        appBrandVideoView.hZa.setVisibility(0);
        AppMethodBeat.o(126545);
    }
}
