package com.tencent.mm.plugin.brandservice.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.r;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandDotPercentIndicator;
import com.tencent.mm.plugin.appbrand.jsapi.video.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.l;
import com.tencent.mm.plugin.appbrand.jsapi.video.m;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.pluginsdk.ui.applet.e;
import com.tencent.mm.pluginsdk.ui.applet.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.ttpic.util.VideoMaterialUtil;

public class MPVideoView extends RelativeLayout {
    private int Yp = -1;
    private TextView hYN;
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
    private boolean hZe;
    private boolean hZg;
    private boolean hZh;
    private l hZi;
    private boolean hZk;
    private boolean hZl;
    private double hZm;
    private String hZn;
    private boolean hZo;
    private boolean hZp;
    private boolean hZq;
    private boolean hZr;
    private int hZs;
    private boolean hZu;
    private boolean hZv;
    private boolean hZw = false;
    private String ien;
    private MPVideoWrapper jZp;
    private MPVideoViewControlBar jZq;
    private a jZr;
    private b jZs;
    private boolean jZt = false;
    private OnTouchListener jZu;
    private com.tencent.mm.plugin.brandservice.ui.timeline.video.b jZv;
    private int jZw = 0;
    private long jZx = 0;
    private long jZy = 0;
    private boolean mAutoPlay;
    private int mDuration;
    private boolean mIsMute = false;

    public interface a {
        void aDF();

        boolean isFullScreen();

        void on(int i);
    }

    public interface b {
        void Gf(String str);
    }

    static /* synthetic */ boolean j(MPVideoView mPVideoView) {
        AppMethodBeat.i(14576);
        boolean aFd = mPVideoView.aFd();
        AppMethodBeat.o(14576);
        return aFd;
    }

    static /* synthetic */ boolean r(MPVideoView mPVideoView) {
        AppMethodBeat.i(14578);
        boolean aFe = mPVideoView.aFe();
        AppMethodBeat.o(14578);
        return aFe;
    }

    static /* synthetic */ String sI(int i) {
        AppMethodBeat.i(14581);
        String ox = ox(i);
        AppMethodBeat.o(14581);
        return ox;
    }

    static /* synthetic */ boolean w(MPVideoView mPVideoView) {
        AppMethodBeat.i(14580);
        boolean isLive = mPVideoView.isLive();
        AppMethodBeat.o(14580);
        return isLive;
    }

    public MPVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(14520);
        init(context);
        AppMethodBeat.o(14520);
    }

    public MPVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(14521);
        init(context);
        AppMethodBeat.o(14521);
    }

    private void init(Context context) {
        AppMethodBeat.i(14522);
        LayoutInflater.from(context).inflate(R.layout.ahl, this);
        this.jZp = (MPVideoWrapper) findViewById(R.id.wh);
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
                AppMethodBeat.i(14486);
                MPVideoView.this.start();
                AppMethodBeat.o(14486);
            }
        });
        aEY();
        aFa();
        aZb();
        aZa();
        initParam();
        AppMethodBeat.o(14522);
    }

    private void initParam() {
        AppMethodBeat.i(14523);
        setShowProgress(true);
        setShowControlProgress(true);
        setPageGesture(false);
        setPageGestureInFullscreen(true);
        setEnablePlayGesture(true);
        setShowMuteBtn(true);
        setShowFullScreenBtn(true);
        setShowPlayBtn(true);
        setShowCenterPlayBtn(false);
        aYZ();
        setVideoSource(0);
        setConsumeTouchEvent(false);
        setIsShowBasicControls(true);
        setAutoHideTitle(true);
        setAutoHideTitle(false);
        AppMethodBeat.o(14523);
    }

    public void setConsumeTouchEvent(boolean z) {
        AppMethodBeat.i(14524);
        ab.i("MicroMsg.MPVideoView", "setConsumeTouchEvent value=%s", Boolean.valueOf(z));
        this.hZo = z;
        AppMethodBeat.o(14524);
    }

    public void setShowMuteBtn(boolean z) {
        AppMethodBeat.i(14525);
        ab.i("MicroMsg.MPVideoView", "showMuteBtn %b", Boolean.valueOf(z));
        this.jZq.setShowMuteBtn(z);
        AppMethodBeat.o(14525);
    }

    public void setTitle(String str) {
        AppMethodBeat.i(14526);
        ab.i("MicroMsg.MPVideoView", "setTitle %s", str);
        this.jZq.setTitle(str);
        AppMethodBeat.o(14526);
    }

    public void setShowControlProgress(boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(14527);
        ab.i("MicroMsg.MPVideoView", "setShowControlProgress %b", Boolean.valueOf(z));
        MPVideoViewControlBar mPVideoViewControlBar = this.jZq;
        if (!z || isLive()) {
            z2 = false;
        }
        mPVideoViewControlBar.setShowControlProgress(z2);
        AppMethodBeat.o(14527);
    }

    public void setCustomOnTouchListener(OnTouchListener onTouchListener) {
        this.jZu = onTouchListener;
    }

    public void setBizVideoControlBar(com.tencent.mm.plugin.brandservice.ui.timeline.video.b bVar) {
        this.jZv = bVar;
    }

    public long getRealPlayTime() {
        AppMethodBeat.i(14528);
        if (!(this.jZx != 0 || this.jZy == 0 || this.jZw == 0)) {
            this.jZx = System.currentTimeMillis() - this.jZy;
        }
        long j = this.jZx;
        AppMethodBeat.o(14528);
        return j;
    }

    public int getEndPlayTime() {
        AppMethodBeat.i(14529);
        int currPosMs;
        if (getCurrPosMs() != 0 || this.jZw == 0) {
            currPosMs = getCurrPosMs();
            AppMethodBeat.o(14529);
            return currPosMs;
        }
        currPosMs = getDuration() * 1000;
        AppMethodBeat.o(14529);
        return currPosMs;
    }

    public void setPlayBtnPosition(String str) {
        AppMethodBeat.i(14530);
        ab.i("MicroMsg.MPVideoView", "setPlayBtnPosition: %s", str);
        if (bo.isNullOrNil(str) || !str.equalsIgnoreCase("center")) {
            this.jZq.setPlayBtnInCenterPosition(false);
            AppMethodBeat.o(14530);
            return;
        }
        this.jZq.setPlayBtnInCenterPosition(true);
        AppMethodBeat.o(14530);
    }

    public void setEnablePlayGesture(boolean z) {
        AppMethodBeat.i(14531);
        ab.i("MicroMsg.MPVideoView", "setEnablePlayGesture: %b", Boolean.valueOf(z));
        this.hZv = z;
        AppMethodBeat.o(14531);
    }

    public void setAutoPlay(boolean z) {
        AppMethodBeat.i(14532);
        ab.i("MicroMsg.MPVideoView", "setAutoPlay =%b", Boolean.valueOf(z));
        this.mAutoPlay = z;
        if (this.jZw == 0) {
            this.jZw = 1;
        }
        AppMethodBeat.o(14532);
    }

    public void setVideoSource(int i) {
        AppMethodBeat.i(14533);
        ab.i("MicroMsg.MPVideoView", "setVideoSource =%d", Integer.valueOf(i));
        this.hZs = i;
        AppMethodBeat.o(14533);
    }

    public void setDuration(int i) {
        AppMethodBeat.i(14534);
        if (i <= 0) {
            ab.i("MicroMsg.MPVideoView", "setDuration error duration=%d", Integer.valueOf(i));
            AppMethodBeat.o(14534);
            return;
        }
        this.hYS.setText(ox(i));
        this.mDuration = i;
        AppMethodBeat.o(14534);
    }

    public int getDuration() {
        AppMethodBeat.i(14535);
        int i;
        if (this.mDuration > 0) {
            i = this.mDuration;
            AppMethodBeat.o(14535);
            return i;
        }
        i = this.jZp.getVideoDurationSec();
        AppMethodBeat.o(14535);
        return i;
    }

    public void setLoop(boolean z) {
        AppMethodBeat.i(14536);
        ab.i("MicroMsg.MPVideoView", "setLoop loop=%b", Boolean.valueOf(z));
        this.hZl = z;
        AppMethodBeat.o(14536);
    }

    public final void start() {
        AppMethodBeat.i(14537);
        ab.i("MicroMsg.MPVideoView", "start");
        if (this.jZp.isPlaying()) {
            AppMethodBeat.o(14537);
            return;
        }
        if (this.hZe) {
            this.jZq.aFN();
        }
        this.hYQ.setVisibility(8);
        this.jZp.start();
        AppMethodBeat.o(14537);
    }

    public final void pause() {
        AppMethodBeat.i(14538);
        ab.i("MicroMsg.MPVideoView", "pause");
        if (this.jZp.isPlaying()) {
            this.jZp.pause();
            AppMethodBeat.o(14538);
            return;
        }
        AppMethodBeat.o(14538);
    }

    private void stop() {
        AppMethodBeat.i(14539);
        ab.i("MicroMsg.MPVideoView", "stop");
        if (this.jZp.isPlaying()) {
            this.jZp.stop();
            this.jZq.aFO();
            AppMethodBeat.o(14539);
            return;
        }
        AppMethodBeat.o(14539);
    }

    public final void akW() {
        AppMethodBeat.i(14540);
        ab.i("MicroMsg.MPVideoView", "onUIResume");
        if (this.hZw) {
            ab.i("MicroMsg.MPVideoView", "onUIResume, should skip ui resume");
            this.hZw = false;
            AppMethodBeat.o(14540);
            return;
        }
        this.jZp.akW();
        AppMethodBeat.o(14540);
    }

    public final void akV() {
        AppMethodBeat.i(14541);
        ab.i("MicroMsg.MPVideoView", "onUIPause");
        this.jZp.akV();
        AppMethodBeat.o(14541);
    }

    public final void aEX() {
        AppMethodBeat.i(14542);
        ab.i("MicroMsg.MPVideoView", "onUIDestroy");
        ab.i("MicroMsg.MPVideoView", "clean");
        stop();
        this.jZp.aEX();
        this.jZq.onDestroy();
        AppMethodBeat.o(14542);
    }

    public final void bL(String str, int i) {
        AppMethodBeat.i(14543);
        ab.i("MicroMsg.MPVideoView", "setVideoPath path=%s isLive=%s", str, Boolean.FALSE);
        if (bo.isNullOrNil(str)) {
            ab.v("MicroMsg.MPVideoView", "setVideoPath videoPath empty");
            AppMethodBeat.o(14543);
            return;
        }
        this.ien = str;
        stop();
        this.hZk = false;
        this.jZp.setVideoSource(this.hZs);
        this.jZp.c(false, str, i);
        if (this.hZm > 0.0d) {
            this.jZp.e(this.hZm, this.mAutoPlay);
        }
        if (this.mAutoPlay) {
            ab.i("MicroMsg.MPVideoView", "setVideoPath autoPlay");
            start();
        }
        setCover(str);
        setMute(this.mIsMute);
        AppMethodBeat.o(14543);
    }

    public String getVideoPath() {
        return this.ien;
    }

    public final void d(double d, boolean z) {
        AppMethodBeat.i(14544);
        int currPosSec = this.jZp.getCurrPosSec();
        ab.i("MicroMsg.MPVideoView", "seek to position=%s current=%d isLive=%b", Double.valueOf(d), Integer.valueOf(currPosSec), Boolean.valueOf(this.hZk));
        if (isLive()) {
            AppMethodBeat.o(14544);
            return;
        }
        this.hYQ.setVisibility(8);
        if (z) {
            this.jZp.e(d, z);
            AppMethodBeat.o(14544);
            return;
        }
        this.jZp.s(d);
        AppMethodBeat.o(14544);
    }

    public void setIsShowBasicControls(boolean z) {
        AppMethodBeat.i(14545);
        ab.i("MicroMsg.MPVideoView", "setIsShowBasicControls isShowBasicControls=%b", Boolean.valueOf(z));
        this.hZe = z;
        if (this.jZq != null) {
            if (this.hZe) {
                this.jZq.aFD();
                AppMethodBeat.o(14545);
                return;
            }
            this.jZq.setVisibility(8);
        }
        AppMethodBeat.o(14545);
    }

    public void setAutoHideTitle(boolean z) {
        this.jZt = z;
    }

    public static String a(r rVar) {
        AppMethodBeat.i(14546);
        String v = q.v(rVar.fjT.fjx, rVar.type, rVar.fjQ == 0 ? "@T" : "@S");
        AppMethodBeat.o(14546);
        return v;
    }

    public final void a(ImageView imageView, String str, int i, int i2, r rVar) {
        AppMethodBeat.i(14547);
        ab.i("MicroMsg.MPVideoView", "setCover coverUrl=%s", str);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(14547);
            return;
        }
        this.hZn = str;
        imageView.setContentDescription(getContext().getString(R.string.al_));
        com.tencent.mm.at.a.a ahp = o.ahp();
        String str2 = this.hZn;
        com.tencent.mm.at.a.a.c.a aVar = new com.tencent.mm.at.a.a.c.a();
        aVar.ePH = true;
        aVar = aVar.ct(i, i2);
        aVar.fGV = new f();
        aVar.ePJ = a(rVar);
        ahp.a(str2, imageView, aVar.ahG(), null, new e(0, i, i2, null));
        AppMethodBeat.o(14547);
    }

    private void setCover(final String str) {
        AppMethodBeat.i(14548);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(14548);
        } else if (bo.isNullOrNil(this.hZn)) {
            com.tencent.mm.plugin.brandservice.b.a("BrandServiceWorkerThread", new Runnable() {
                public final void run() {
                    AppMethodBeat.i(14491);
                    final Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 1);
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(14490);
                            if (!(createVideoThumbnail == null || createVideoThumbnail.isRecycled())) {
                                MPVideoView.this.hYX.setImageBitmap(createVideoThumbnail);
                            }
                            AppMethodBeat.o(14490);
                        }
                    });
                    AppMethodBeat.o(14491);
                }
            }, 0);
            AppMethodBeat.o(14548);
        } else {
            ab.i("MicroMsg.MPVideoView", "setCover mCoverUrl not null");
            AppMethodBeat.o(14548);
        }
    }

    public void setShowProgress(boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(14549);
        ab.i("MicroMsg.MPVideoView", "setShowProgress %b", Boolean.valueOf(z));
        this.hZq = z;
        MPVideoViewControlBar mPVideoViewControlBar = this.jZq;
        if (!z || isLive()) {
            z2 = false;
        }
        mPVideoViewControlBar.setShowProgress(z2);
        AppMethodBeat.o(14549);
    }

    public void setShowFullScreenBtn(boolean z) {
        AppMethodBeat.i(14550);
        ab.i("MicroMsg.MPVideoView", "setShowFullScreenBtn %b", Boolean.valueOf(z));
        this.jZq.setShowFullScreenBtn(z);
        AppMethodBeat.o(14550);
    }

    public void setShowPlayBtn(boolean z) {
        AppMethodBeat.i(14551);
        ab.i("MicroMsg.MPVideoView", "setShowPlayBtn %b", Boolean.valueOf(z));
        this.jZq.setShowPlayBtn(z);
        AppMethodBeat.o(14551);
    }

    private void aYZ() {
        AppMethodBeat.i(14552);
        ab.i("MicroMsg.MPVideoView", "enableProgressGesture %b", Boolean.TRUE);
        this.hZp = true;
        AppMethodBeat.o(14552);
    }

    public void setShowCenterPlayBtn(boolean z) {
        int i = 0;
        AppMethodBeat.i(14553);
        ab.i("MicroMsg.MPVideoView", "setPlayBtnInCenterPosition %b", Boolean.valueOf(z));
        this.hZr = z;
        this.hYQ.setVisibility(z ? 0 : 8);
        View view = this.hYR;
        if (!z) {
            i = 8;
        }
        view.setVisibility(i);
        if (this.hZr && this.jZq != null) {
            this.jZq.setVisibility(8);
        }
        AppMethodBeat.o(14553);
    }

    private void aZa() {
        AppMethodBeat.i(14554);
        this.jZp.setScaleType(g.CONTAIN);
        this.hYX.setScaleType(ScaleType.FIT_CENTER);
        AppMethodBeat.o(14554);
    }

    public void setMute(boolean z) {
        AppMethodBeat.i(14555);
        ab.i("MicroMsg.MPVideoView", "setMute isMute=%b", Boolean.valueOf(z));
        this.mIsMute = z;
        this.jZp.setMute(z);
        this.jZq.setMuteBtnState(z);
        AppMethodBeat.o(14555);
    }

    public void setCookieData(String str) {
        this.hZb = str;
    }

    public String getCookieData() {
        return this.hZb;
    }

    public int getCurrPosSec() {
        AppMethodBeat.i(14556);
        int currPosSec = this.jZp.getCurrPosSec();
        AppMethodBeat.o(14556);
        return currPosSec;
    }

    public int getCurrPosMs() {
        AppMethodBeat.i(14557);
        int currPosMs = this.jZp.getCurrPosMs();
        AppMethodBeat.o(14557);
        return currPosMs;
    }

    public int getCacheTimeSec() {
        AppMethodBeat.i(14558);
        if (this.jZp != null) {
            int cacheTimeSec = this.jZp.getCacheTimeSec();
            AppMethodBeat.o(14558);
            return cacheTimeSec;
        }
        AppMethodBeat.o(14558);
        return 0;
    }

    public void setFullScreenDirection(int i) {
        AppMethodBeat.i(14559);
        ab.i("MicroMsg.MPVideoView", "setFullScreenDirection %d", Integer.valueOf(i));
        this.Yp = i;
        AppMethodBeat.o(14559);
    }

    public void setPageGesture(boolean z) {
        AppMethodBeat.i(14560);
        ab.i("MicroMsg.MPVideoView", "setPageGesture pageGesture=%b", Boolean.valueOf(z));
        this.hZg = z;
        AppMethodBeat.o(14560);
    }

    public void setPageGestureInFullscreen(boolean z) {
        AppMethodBeat.i(14561);
        ab.i("MicroMsg.MPVideoView", "setPageGestureInFullscreen pageGestureInFullscreen=%b", Boolean.valueOf(z));
        this.hZh = z;
        AppMethodBeat.o(14561);
    }

    public void setInitialTime(double d) {
        AppMethodBeat.i(14562);
        ab.i("MicroMsg.MPVideoView", "setInitialTime initialTime=%s", Double.valueOf(d));
        this.hZm = d;
        AppMethodBeat.o(14562);
    }

    public void setFullScreenDelegate(a aVar) {
        this.jZr = aVar;
    }

    public void setMPVideoViewCallBack(b bVar) {
        this.jZs = bVar;
    }

    private void aEY() {
        AppMethodBeat.i(14563);
        this.hZi = new l(getContext(), this, new com.tencent.mm.plugin.appbrand.jsapi.video.l.b() {
            public final void aFi() {
                AppMethodBeat.i(14492);
                ab.d("MicroMsg.MPVideoView", "onSingleTap");
                if (MPVideoView.this.hZe && !MPVideoView.this.hZr) {
                    MPVideoView.this.jZq.aFG();
                }
                if (MPVideoView.this.hYQ.getVisibility() != 0 && MPVideoView.this.hZu) {
                    MPVideoView.g(MPVideoView.this);
                }
                AppMethodBeat.o(14492);
            }

            public final void aFj() {
                AppMethodBeat.i(14493);
                ab.d("MicroMsg.MPVideoView", "onDoubleTap");
                if (MPVideoView.this.hZv) {
                    if (MPVideoView.this.jZp.isPlaying()) {
                        MPVideoView.this.pause();
                        AppMethodBeat.o(14493);
                        return;
                    }
                    MPVideoView.this.start();
                }
                AppMethodBeat.o(14493);
            }

            public final void aFk() {
                AppMethodBeat.i(14494);
                if (MPVideoView.j(MPVideoView.this)) {
                    MPVideoView.this.hYN.setVisibility(0);
                    MPVideoView.g(MPVideoView.this);
                    AppMethodBeat.o(14494);
                    return;
                }
                AppMethodBeat.o(14494);
            }

            public final int i(int i, float f) {
                AppMethodBeat.i(14495);
                if (MPVideoView.j(MPVideoView.this)) {
                    ab.i("MicroMsg.MPVideoView", "onDragProgress:" + i + "/" + f);
                    int videoDurationSec = MPVideoView.this.jZp.getVideoDurationSec();
                    int c = com.tencent.mm.plugin.appbrand.jsapi.video.b.c(f, (float) MPVideoView.this.getMeasuredWidth(), getCurrentPosition(), videoDurationSec);
                    MPVideoView.this.hYN.setText(m.fQ(((long) c) * 1000) + "/" + m.fQ(((long) videoDurationSec) * 1000));
                    MPVideoView.this.jZq.seek(c);
                    if (MPVideoView.this.jZq.aFF()) {
                        MPVideoView.this.jZq.aFE();
                    }
                    AppMethodBeat.o(14495);
                    return c;
                }
                AppMethodBeat.o(14495);
                return 0;
            }

            public final void j(int i, float f) {
                AppMethodBeat.i(14496);
                if (MPVideoView.j(MPVideoView.this)) {
                    MPVideoView.this.hYN.setVisibility(8);
                    MPVideoView.l(MPVideoView.this);
                    int currPosSec = MPVideoView.this.jZp.getCurrPosSec();
                    ab.i("MicroMsg.MPVideoView", "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", Integer.valueOf(i), Integer.valueOf(currPosSec), Float.valueOf(f));
                    MPVideoView.this.d((double) i, false);
                    MPVideoView.this.jZv.jVJ.sE(12);
                    AppMethodBeat.o(14496);
                    return;
                }
                AppMethodBeat.o(14496);
            }

            public final int getCurrentPosition() {
                AppMethodBeat.i(14497);
                int currPosSec = MPVideoView.this.jZp.getCurrPosSec();
                AppMethodBeat.o(14497);
                return currPosSec;
            }

            public final boolean aFn() {
                AppMethodBeat.i(138968);
                boolean r = MPVideoView.r(MPVideoView.this);
                AppMethodBeat.o(138968);
                return r;
            }

            public final boolean aFo() {
                AppMethodBeat.i(138969);
                boolean r = MPVideoView.r(MPVideoView.this);
                AppMethodBeat.o(138969);
                return r;
            }

            public final boolean aFp() {
                AppMethodBeat.i(14504);
                boolean j = MPVideoView.j(MPVideoView.this);
                AppMethodBeat.o(14504);
                return j;
            }

            public final void aq(float f) {
                AppMethodBeat.i(14498);
                if (MPVideoView.r(MPVideoView.this)) {
                    ab.d("MicroMsg.MPVideoView", "onAdjustVolume:".concat(String.valueOf(f)));
                    MPVideoView.this.hYU.setPercent(f);
                    MPVideoView.this.hYV.setText(R.string.cu9);
                    MPVideoView.this.hYW.setImageResource(R.drawable.asi);
                    MPVideoView.this.hYT.setVisibility(0);
                    MPVideoView.g(MPVideoView.this);
                    AppMethodBeat.o(14498);
                    return;
                }
                AppMethodBeat.o(14498);
            }

            public final void ar(float f) {
                AppMethodBeat.i(14499);
                if (MPVideoView.r(MPVideoView.this)) {
                    ab.d("MicroMsg.MPVideoView", "onAdjustBrightness:".concat(String.valueOf(f)));
                    MPVideoView.this.hYU.setPercent(f);
                    MPVideoView.this.hYV.setText(R.string.cu8);
                    MPVideoView.this.hYW.setImageResource(R.drawable.asg);
                    MPVideoView.this.hYT.setVisibility(0);
                    MPVideoView.g(MPVideoView.this);
                    AppMethodBeat.o(14499);
                    return;
                }
                AppMethodBeat.o(14499);
            }

            public final void aFl() {
                AppMethodBeat.i(14500);
                if (MPVideoView.r(MPVideoView.this)) {
                    MPVideoView.this.hYT.setVisibility(8);
                    MPVideoView.l(MPVideoView.this);
                    AppMethodBeat.o(14500);
                    return;
                }
                AppMethodBeat.o(14500);
            }

            public final void aFm() {
                AppMethodBeat.i(14501);
                if (MPVideoView.r(MPVideoView.this)) {
                    MPVideoView.this.hYT.setVisibility(8);
                    MPVideoView.l(MPVideoView.this);
                    AppMethodBeat.o(14501);
                    return;
                }
                AppMethodBeat.o(14501);
            }
        });
        AppMethodBeat.o(14563);
    }

    private void aFa() {
        AppMethodBeat.i(14564);
        this.jZp.setIMMVideoViewCallback(new com.tencent.mm.plugin.appbrand.jsapi.video.d.b() {
            public final void H(String str, int i, int i2) {
                AppMethodBeat.i(14505);
                ab.i("MicroMsg.MPVideoView", "onError errorMsg=%s what=%d extra=%d", str, Integer.valueOf(i), Integer.valueOf(i2));
                MPVideoView.this.jZv.jVJ.jYA = str;
                MPVideoView.this.jZv.jVJ.sE(11);
                MPVideoView.s(MPVideoView.this);
                if (MPVideoView.this.jZs != null) {
                    MPVideoView.this.jZs.Gf(str);
                }
                MPVideoView.this.jZw = 4;
                AppMethodBeat.o(14505);
            }

            public final void aFq() {
                AppMethodBeat.i(14506);
                ab.i("MicroMsg.MPVideoView", "onPrepared");
                MPVideoView.this.hZi.aFY();
                AppMethodBeat.o(14506);
            }

            public final void aFr() {
                AppMethodBeat.i(14507);
                ab.i("MicroMsg.MPVideoView", "onVideoEnded");
                MPVideoView.s(MPVideoView.this);
                MPVideoView.this.hYN.setVisibility(8);
                if (MPVideoView.this.hZr) {
                    MPVideoView.this.hYQ.setVisibility(0);
                    if (MPVideoView.this.jZq.aFF()) {
                        MPVideoView.this.jZq.setVisibility(8);
                    }
                } else {
                    MPVideoViewControlBar d = MPVideoView.this.jZq;
                    if (d.hZK != null) {
                        d.hZK.stopTimer();
                    }
                    MPVideoView.this.jZq.setVisibility(0);
                }
                if (MPVideoView.this.hZa.getVisibility() == 0) {
                    MPVideoView.this.hZa.setVisibility(8);
                }
                if (MPVideoView.w(MPVideoView.this) || !MPVideoView.this.hZr) {
                    MPVideoView.this.hYR.setVisibility(8);
                } else {
                    if (MPVideoView.this.mDuration <= 0) {
                        MPVideoView.this.hYS.setText(MPVideoView.sI(MPVideoView.this.jZp.getVideoDurationSec()));
                    }
                    MPVideoView.this.hYR.setVisibility(0);
                }
                if (MPVideoView.this.hZl) {
                    MPVideoView.this.d(0.0d, true);
                } else {
                    MPVideoView.this.d(0.0d, false);
                    if (MPVideoView.this.jZt && (MPVideoView.this.getContext() instanceof MMActivity)) {
                        ((MMActivity) MPVideoView.this.getContext()).mController.showTitleView();
                    }
                }
                MPVideoView.this.jZw = 4;
                MPVideoView.this.jZv.jVJ.sE(7);
                AppMethodBeat.o(14507);
            }

            public final void de(int i, int i2) {
                AppMethodBeat.i(14508);
                ab.i("MicroMsg.MPVideoView", "onGetVideoSize width=%d height=%d", Integer.valueOf(i), Integer.valueOf(i2));
                if (MPVideoView.this.Yp == -1) {
                    MPVideoView.this.Yp = i < i2 ? 0 : 90;
                    ab.i("MicroMsg.MPVideoView", "onGetVideoSize adjust direction from AUTO to %s", Integer.valueOf(MPVideoView.this.Yp));
                }
                AppMethodBeat.o(14508);
            }

            public final void aFs() {
                AppMethodBeat.i(14509);
                ab.i("MicroMsg.MPVideoView", "onVideoPause");
                if (MPVideoView.this.jZw == 2) {
                    MPVideoView.this.jZv.jVJ.sE(8);
                }
                MPVideoView.this.jZw = 3;
                MPVideoView.s(MPVideoView.this);
                AppMethodBeat.o(14509);
            }

            public final void aFt() {
                int i = 3;
                AppMethodBeat.i(14510);
                ab.i("MicroMsg.MPVideoView", "onVideoPlay, isLive:%b", Boolean.valueOf(MPVideoView.w(MPVideoView.this)));
                if (MPVideoView.this.mDuration <= 0 && !MPVideoView.w(MPVideoView.this)) {
                    MPVideoView.this.hYS.setText(MPVideoView.sI(MPVideoView.this.jZp.getVideoDurationSec()));
                }
                MPVideoView.a(MPVideoView.this, MPVideoView.w(MPVideoView.this));
                if (MPVideoView.this.hZe) {
                    MPVideoView.E(MPVideoView.this);
                }
                MPVideoView.this.jZv;
                switch (MPVideoView.this.jZw) {
                    case 1:
                        i = 4;
                        break;
                    case 2:
                        i = 8;
                        break;
                    case 3:
                        i = 9;
                        break;
                    case 4:
                        i = 10;
                        break;
                }
                MPVideoView.this.jZv.jVJ.sE(i);
                MPVideoView.F(MPVideoView.this);
                MPVideoView.this.jZw = 2;
                AppMethodBeat.o(14510);
            }

            public final void aFu() {
                AppMethodBeat.i(14511);
                ab.i("MicroMsg.MPVideoView", "onVideoWaiting");
                MPVideoView.this.hZu = true;
                MPVideoView.g(MPVideoView.this);
                AppMethodBeat.o(14511);
            }

            public final void aFv() {
                AppMethodBeat.i(14512);
                MPVideoView.this.hZu = false;
                MPVideoView.l(MPVideoView.this);
                AppMethodBeat.o(14512);
            }
        });
        AppMethodBeat.o(14564);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        AppMethodBeat.i(14565);
        if (this.jZu != null) {
            this.jZu.onTouch(this, motionEvent);
        }
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
            AppMethodBeat.o(14565);
            return true;
        }
        if (motionEvent.getAction() == 0) {
            if (this.hZe && !this.hZr) {
                this.jZq.aFG();
            }
            if (this.hYQ.getVisibility() != 0 && this.hZu) {
                this.jZq.aEZ();
            }
        }
        if (this.hZo) {
            AppMethodBeat.o(14565);
            return true;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(14565);
        return onTouchEvent;
    }

    public final void j(boolean z, int i) {
        AppMethodBeat.i(14566);
        ab.i("MicroMsg.MPVideoView", "operateFullScreen toFullScreen:%b direction:%d", Boolean.valueOf(z), Integer.valueOf(i));
        if (this.jZr == null) {
            ab.w("MicroMsg.MPVideoView", "operateFullScreen mFullScreenDelegate null");
            AppMethodBeat.o(14566);
        } else if (z == aFb()) {
            ab.i("MicroMsg.MPVideoView", "operateFullScreen current same");
            AppMethodBeat.o(14566);
        } else {
            int i2;
            if (i == -1) {
                i2 = this.Yp == -1 ? 90 : this.Yp;
                ab.i("MicroMsg.MPVideoView", "operateFullScreen target direction:%d", Integer.valueOf(i2));
            } else {
                i2 = i;
            }
            if (z) {
                this.jZr.on(i2);
                this.jZq.aFH();
                AppMethodBeat.o(14566);
                return;
            }
            this.jZr.aDF();
            this.jZq.aDF();
            AppMethodBeat.o(14566);
        }
    }

    public final boolean aFb() {
        AppMethodBeat.i(14567);
        if (this.jZr == null) {
            ab.w("MicroMsg.MPVideoView", "isInFullScreen mFullScreenDelegate null");
            AppMethodBeat.o(14567);
            return false;
        }
        boolean isFullScreen = this.jZr.isFullScreen();
        AppMethodBeat.o(14567);
        return isFullScreen;
    }

    private void aZb() {
        AppMethodBeat.i(14568);
        this.jZq = new MPVideoViewControlBar(getContext());
        this.jZp.setVideoFooterView(this.jZq);
        this.jZq.setVisibility(8);
        this.jZq.setFullScreenBtnOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(14513);
                boolean z = !MPVideoView.this.aFb();
                MPVideoView mPVideoView = MPVideoView.this;
                mPVideoView.j(z, mPVideoView.Yp);
                AppMethodBeat.o(14513);
            }
        });
        this.jZq.setIplaySeekCallback(new c() {
            public final void aFw() {
                AppMethodBeat.i(14514);
                ab.i("MicroMsg.MPVideoView", "onSeekPre");
                AppMethodBeat.o(14514);
            }

            public final void oA(int i) {
                AppMethodBeat.i(14515);
                MPVideoView.this.d((double) i, false);
                MPVideoView.this.jZv.jVJ.sE(13);
                AppMethodBeat.o(14515);
            }
        });
        this.jZq.setOnPlayButtonClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(14516);
                if (MPVideoView.this.jZp.isPlaying()) {
                    MPVideoView.this.pause();
                    AppMethodBeat.o(14516);
                    return;
                }
                MPVideoView.this.start();
                AppMethodBeat.o(14516);
            }
        });
        this.jZq.setStatePorter(new h() {
            public final int aFg() {
                AppMethodBeat.i(14517);
                int cacheTimeSec = MPVideoView.this.jZp.getCacheTimeSec();
                AppMethodBeat.o(14517);
                return cacheTimeSec;
            }

            public final int aFh() {
                AppMethodBeat.i(14518);
                int videoDurationSec = MPVideoView.this.jZp.getVideoDurationSec();
                AppMethodBeat.o(14518);
                return videoDurationSec;
            }
        });
        this.jZq.setMuteBtnOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(14519);
                MPVideoView.this.setMute(!MPVideoView.this.mIsMute);
                AppMethodBeat.o(14519);
            }
        });
        this.jZq.setExitFullScreenBtnOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(14487);
                MPVideoView.this.j(false, MPVideoView.this.Yp);
                AppMethodBeat.o(14487);
            }
        });
        this.jZq.setOnVisibilityChangedListener(new d.e() {
            public final void onVisibilityChanged(boolean z) {
                AppMethodBeat.i(14488);
                MPVideoView.E(MPVideoView.this);
                if (MPVideoView.this.jZt && (MPVideoView.this.getContext() instanceof MMActivity) && MPVideoView.this.jZr != null && !MPVideoView.this.jZr.isFullScreen()) {
                    MMActivity mMActivity = (MMActivity) MPVideoView.this.getContext();
                    if (z || !MPVideoView.this.jZp.isPlaying()) {
                        mMActivity.mController.showTitleView();
                        AppMethodBeat.o(14488);
                        return;
                    }
                    mMActivity.mController.hideTitleView();
                }
                AppMethodBeat.o(14488);
            }
        });
        this.jZq.setOnUpdateProgressLenListener(new d.d() {
            public final void dd(int i, int i2) {
                AppMethodBeat.i(14489);
                if (i2 <= 0) {
                    AppMethodBeat.o(14489);
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
                int width = (i3 * MPVideoView.this.hYZ.getWidth()) / i2;
                LayoutParams layoutParams = (LayoutParams) MPVideoView.this.hYY.getLayoutParams();
                layoutParams.width = width;
                MPVideoView.this.hYY.setLayoutParams(layoutParams);
                MPVideoView.this.hYY.requestLayout();
                AppMethodBeat.o(14489);
            }
        });
        this.jZp.setControlBar(this.jZq);
        AppMethodBeat.o(14568);
    }

    private static String ox(int i) {
        AppMethodBeat.i(14569);
        String str = oy(i / 60) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + oy(i % 60);
        AppMethodBeat.o(14569);
        return str;
    }

    private static String oy(int i) {
        AppMethodBeat.i(14570);
        String concat;
        if (i < 10) {
            concat = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(i));
            AppMethodBeat.o(14570);
            return concat;
        }
        concat = String.valueOf(i);
        AppMethodBeat.o(14570);
        return concat;
    }

    private boolean isLive() {
        AppMethodBeat.i(14571);
        ab.i("MicroMsg.MPVideoView", "isLive %b %b", Boolean.valueOf(this.hZk), Boolean.valueOf(this.jZp.isLive()));
        if (this.hZk || this.jZp.isLive()) {
            AppMethodBeat.o(14571);
            return true;
        }
        AppMethodBeat.o(14571);
        return false;
    }

    private boolean aFd() {
        AppMethodBeat.i(14572);
        if (!this.hZp || this.jZp.isLive() || aFf()) {
            AppMethodBeat.o(14572);
            return false;
        }
        AppMethodBeat.o(14572);
        return true;
    }

    private boolean aFe() {
        AppMethodBeat.i(14573);
        if (aFf() || ((aFb() || !this.hZg) && !(aFb() && this.hZh))) {
            AppMethodBeat.o(14573);
            return false;
        }
        AppMethodBeat.o(14573);
        return true;
    }

    private boolean aFf() {
        AppMethodBeat.i(14574);
        if (this.hYQ.getVisibility() == 0) {
            AppMethodBeat.o(14574);
            return true;
        }
        AppMethodBeat.o(14574);
        return false;
    }

    static /* synthetic */ void g(MPVideoView mPVideoView) {
        AppMethodBeat.i(14575);
        mPVideoView.jZq.aEZ();
        AppMethodBeat.o(14575);
    }

    static /* synthetic */ void l(MPVideoView mPVideoView) {
        AppMethodBeat.i(14577);
        mPVideoView.jZq.aFy();
        AppMethodBeat.o(14577);
    }

    static /* synthetic */ void s(MPVideoView mPVideoView) {
        AppMethodBeat.i(14579);
        long currentTimeMillis = System.currentTimeMillis();
        mPVideoView.jZx += currentTimeMillis - mPVideoView.jZy;
        mPVideoView.jZy = currentTimeMillis;
        AppMethodBeat.o(14579);
    }

    static /* synthetic */ void E(MPVideoView mPVideoView) {
        AppMethodBeat.i(14583);
        boolean aFR = mPVideoView.jZq.aFR();
        if (!mPVideoView.hZe || !mPVideoView.hZq || aFR || mPVideoView.isLive() || mPVideoView.aFf()) {
            mPVideoView.hZa.setVisibility(8);
            AppMethodBeat.o(14583);
            return;
        }
        mPVideoView.hZa.setVisibility(0);
        AppMethodBeat.o(14583);
    }

    static /* synthetic */ void F(MPVideoView mPVideoView) {
        AppMethodBeat.i(14584);
        mPVideoView.jZy = System.currentTimeMillis();
        AppMethodBeat.o(14584);
    }
}
