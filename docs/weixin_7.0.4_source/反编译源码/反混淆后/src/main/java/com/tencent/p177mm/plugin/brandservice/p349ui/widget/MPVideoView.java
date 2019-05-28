package com.tencent.p177mm.plugin.brandservice.p349ui.widget;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p181af.C37436r;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.C25815a;
import com.tencent.p177mm.p190at.p191a.p827a.C25814c.C17927a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.AppBrandDotPercentIndicator;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C27128b;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C33414l;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C33414l.C33416b;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C33417m;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C45630d.C19512d;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C45630d.C27129e;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C45630d.C27130g;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C45630d.C38400h;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C45630d.C42593b;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C45630d.C42594c;
import com.tencent.p177mm.plugin.brandservice.C33720b;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.C45767b;
import com.tencent.p177mm.pluginsdk.model.C30080q;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35836e;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35838f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView */
public class MPVideoView extends RelativeLayout {
    /* renamed from: Yp */
    private int f17193Yp = -1;
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
    private C33414l hZi;
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
    private C33751a jZr;
    private C38723b jZs;
    private boolean jZt = false;
    private OnTouchListener jZu;
    private C45767b jZv;
    private int jZw = 0;
    private long jZx = 0;
    private long jZy = 0;
    private boolean mAutoPlay;
    private int mDuration;
    private boolean mIsMute = false;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView$3 */
    class C201153 implements C27129e {
        C201153() {
        }

        public final void onVisibilityChanged(boolean z) {
            AppMethodBeat.m2504i(14488);
            MPVideoView.m75984E(MPVideoView.this);
            if (MPVideoView.this.jZt && (MPVideoView.this.getContext() instanceof MMActivity) && MPVideoView.this.jZr != null && !MPVideoView.this.jZr.isFullScreen()) {
                MMActivity mMActivity = (MMActivity) MPVideoView.this.getContext();
                if (z || !MPVideoView.this.jZp.isPlaying()) {
                    mMActivity.mController.showTitleView();
                    AppMethodBeat.m2505o(14488);
                    return;
                }
                mMActivity.mController.hideTitleView();
            }
            AppMethodBeat.m2505o(14488);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView$4 */
    class C247284 implements C19512d {
        C247284() {
        }

        /* renamed from: dd */
        public final void mo34676dd(int i, int i2) {
            AppMethodBeat.m2504i(14489);
            if (i2 <= 0) {
                AppMethodBeat.m2505o(14489);
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
            AppMethodBeat.m2505o(14489);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView$6 */
    class C275666 implements C33416b {
        C275666() {
        }

        public final void aFi() {
            AppMethodBeat.m2504i(14492);
            C4990ab.m7410d("MicroMsg.MPVideoView", "onSingleTap");
            if (MPVideoView.this.hZe && !MPVideoView.this.hZr) {
                MPVideoView.this.jZq.aFG();
            }
            if (MPVideoView.this.hYQ.getVisibility() != 0 && MPVideoView.this.hZu) {
                MPVideoView.m76001g(MPVideoView.this);
            }
            AppMethodBeat.m2505o(14492);
        }

        public final void aFj() {
            AppMethodBeat.m2504i(14493);
            C4990ab.m7410d("MicroMsg.MPVideoView", "onDoubleTap");
            if (MPVideoView.this.hZv) {
                if (MPVideoView.this.jZp.isPlaying()) {
                    MPVideoView.this.pause();
                    AppMethodBeat.m2505o(14493);
                    return;
                }
                MPVideoView.this.start();
            }
            AppMethodBeat.m2505o(14493);
        }

        public final void aFk() {
            AppMethodBeat.m2504i(14494);
            if (MPVideoView.m76004j(MPVideoView.this)) {
                MPVideoView.this.hYN.setVisibility(0);
                MPVideoView.m76001g(MPVideoView.this);
                AppMethodBeat.m2505o(14494);
                return;
            }
            AppMethodBeat.m2505o(14494);
        }

        /* renamed from: i */
        public final int mo34699i(int i, float f) {
            AppMethodBeat.m2504i(14495);
            if (MPVideoView.m76004j(MPVideoView.this)) {
                C4990ab.m7416i("MicroMsg.MPVideoView", "onDragProgress:" + i + "/" + f);
                int videoDurationSec = MPVideoView.this.jZp.getVideoDurationSec();
                int c = C27128b.m43113c(f, (float) MPVideoView.this.getMeasuredWidth(), getCurrentPosition(), videoDurationSec);
                MPVideoView.this.hYN.setText(C33417m.m54609fQ(((long) c) * 1000) + "/" + C33417m.m54609fQ(((long) videoDurationSec) * 1000));
                MPVideoView.this.jZq.seek(c);
                if (MPVideoView.this.jZq.aFF()) {
                    MPVideoView.this.jZq.aFE();
                }
                AppMethodBeat.m2505o(14495);
                return c;
            }
            AppMethodBeat.m2505o(14495);
            return 0;
        }

        /* renamed from: j */
        public final void mo34700j(int i, float f) {
            AppMethodBeat.m2504i(14496);
            if (MPVideoView.m76004j(MPVideoView.this)) {
                MPVideoView.this.hYN.setVisibility(8);
                MPVideoView.m76006l(MPVideoView.this);
                int currPosSec = MPVideoView.this.jZp.getCurrPosSec();
                C4990ab.m7417i("MicroMsg.MPVideoView", "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", Integer.valueOf(i), Integer.valueOf(currPosSec), Float.valueOf(f));
                MPVideoView.this.mo68316d((double) i, false);
                MPVideoView.this.jZv.jVJ.mo45367sE(12);
                AppMethodBeat.m2505o(14496);
                return;
            }
            AppMethodBeat.m2505o(14496);
        }

        public final int getCurrentPosition() {
            AppMethodBeat.m2504i(14497);
            int currPosSec = MPVideoView.this.jZp.getCurrPosSec();
            AppMethodBeat.m2505o(14497);
            return currPosSec;
        }

        public final boolean aFn() {
            AppMethodBeat.m2504i(138968);
            boolean r = MPVideoView.m76014r(MPVideoView.this);
            AppMethodBeat.m2505o(138968);
            return r;
        }

        public final boolean aFo() {
            AppMethodBeat.m2504i(138969);
            boolean r = MPVideoView.m76014r(MPVideoView.this);
            AppMethodBeat.m2505o(138969);
            return r;
        }

        public final boolean aFp() {
            AppMethodBeat.m2504i(14504);
            boolean j = MPVideoView.m76004j(MPVideoView.this);
            AppMethodBeat.m2505o(14504);
            return j;
        }

        /* renamed from: aq */
        public final void mo34696aq(float f) {
            AppMethodBeat.m2504i(14498);
            if (MPVideoView.m76014r(MPVideoView.this)) {
                C4990ab.m7410d("MicroMsg.MPVideoView", "onAdjustVolume:".concat(String.valueOf(f)));
                MPVideoView.this.hYU.setPercent(f);
                MPVideoView.this.hYV.setText(C25738R.string.cu9);
                MPVideoView.this.hYW.setImageResource(C25738R.drawable.asi);
                MPVideoView.this.hYT.setVisibility(0);
                MPVideoView.m76001g(MPVideoView.this);
                AppMethodBeat.m2505o(14498);
                return;
            }
            AppMethodBeat.m2505o(14498);
        }

        /* renamed from: ar */
        public final void mo34697ar(float f) {
            AppMethodBeat.m2504i(14499);
            if (MPVideoView.m76014r(MPVideoView.this)) {
                C4990ab.m7410d("MicroMsg.MPVideoView", "onAdjustBrightness:".concat(String.valueOf(f)));
                MPVideoView.this.hYU.setPercent(f);
                MPVideoView.this.hYV.setText(C25738R.string.cu8);
                MPVideoView.this.hYW.setImageResource(C25738R.drawable.asg);
                MPVideoView.this.hYT.setVisibility(0);
                MPVideoView.m76001g(MPVideoView.this);
                AppMethodBeat.m2505o(14499);
                return;
            }
            AppMethodBeat.m2505o(14499);
        }

        public final void aFl() {
            AppMethodBeat.m2504i(14500);
            if (MPVideoView.m76014r(MPVideoView.this)) {
                MPVideoView.this.hYT.setVisibility(8);
                MPVideoView.m76006l(MPVideoView.this);
                AppMethodBeat.m2505o(14500);
                return;
            }
            AppMethodBeat.m2505o(14500);
        }

        public final void aFm() {
            AppMethodBeat.m2504i(14501);
            if (MPVideoView.m76014r(MPVideoView.this)) {
                MPVideoView.this.hYT.setVisibility(8);
                MPVideoView.m76006l(MPVideoView.this);
                AppMethodBeat.m2505o(14501);
                return;
            }
            AppMethodBeat.m2505o(14501);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView$10 */
    class C3374810 implements OnClickListener {
        C3374810() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(14516);
            if (MPVideoView.this.jZp.isPlaying()) {
                MPVideoView.this.pause();
                AppMethodBeat.m2505o(14516);
                return;
            }
            MPVideoView.this.start();
            AppMethodBeat.m2505o(14516);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView$11 */
    class C3374911 implements C38400h {
        C3374911() {
        }

        public final int aFg() {
            AppMethodBeat.m2504i(14517);
            int cacheTimeSec = MPVideoView.this.jZp.getCacheTimeSec();
            AppMethodBeat.m2505o(14517);
            return cacheTimeSec;
        }

        public final int aFh() {
            AppMethodBeat.m2504i(14518);
            int videoDurationSec = MPVideoView.this.jZp.getVideoDurationSec();
            AppMethodBeat.m2505o(14518);
            return videoDurationSec;
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView$12 */
    class C3375012 implements OnClickListener {
        C3375012() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(14519);
            MPVideoView.this.setMute(!MPVideoView.this.mIsMute);
            AppMethodBeat.m2505o(14519);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView$a */
    public interface C33751a {
        void aDF();

        boolean isFullScreen();

        /* renamed from: on */
        void mo6803on(int i);
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView$7 */
    class C387217 implements C42593b {
        C387217() {
        }

        /* renamed from: H */
        public final void mo34677H(String str, int i, int i2) {
            AppMethodBeat.m2504i(14505);
            C4990ab.m7417i("MicroMsg.MPVideoView", "onError errorMsg=%s what=%d extra=%d", str, Integer.valueOf(i), Integer.valueOf(i2));
            MPVideoView.this.jZv.jVJ.jYA = str;
            MPVideoView.this.jZv.jVJ.mo45367sE(11);
            MPVideoView.m76015s(MPVideoView.this);
            if (MPVideoView.this.jZs != null) {
                MPVideoView.this.jZs.mo6804Gf(str);
            }
            MPVideoView.this.jZw = 4;
            AppMethodBeat.m2505o(14505);
        }

        public final void aFq() {
            AppMethodBeat.m2504i(14506);
            C4990ab.m7416i("MicroMsg.MPVideoView", "onPrepared");
            MPVideoView.this.hZi.aFY();
            AppMethodBeat.m2505o(14506);
        }

        public final void aFr() {
            AppMethodBeat.m2504i(14507);
            C4990ab.m7416i("MicroMsg.MPVideoView", "onVideoEnded");
            MPVideoView.m76015s(MPVideoView.this);
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
            if (MPVideoView.m76020w(MPVideoView.this) || !MPVideoView.this.hZr) {
                MPVideoView.this.hYR.setVisibility(8);
            } else {
                if (MPVideoView.this.mDuration <= 0) {
                    MPVideoView.this.hYS.setText(MPVideoView.m76016sI(MPVideoView.this.jZp.getVideoDurationSec()));
                }
                MPVideoView.this.hYR.setVisibility(0);
            }
            if (MPVideoView.this.hZl) {
                MPVideoView.this.mo68316d(0.0d, true);
            } else {
                MPVideoView.this.mo68316d(0.0d, false);
                if (MPVideoView.this.jZt && (MPVideoView.this.getContext() instanceof MMActivity)) {
                    ((MMActivity) MPVideoView.this.getContext()).mController.showTitleView();
                }
            }
            MPVideoView.this.jZw = 4;
            MPVideoView.this.jZv.jVJ.mo45367sE(7);
            AppMethodBeat.m2505o(14507);
        }

        /* renamed from: de */
        public final void mo34684de(int i, int i2) {
            AppMethodBeat.m2504i(14508);
            C4990ab.m7417i("MicroMsg.MPVideoView", "onGetVideoSize width=%d height=%d", Integer.valueOf(i), Integer.valueOf(i2));
            if (MPVideoView.this.f17193Yp == -1) {
                MPVideoView.this.f17193Yp = i < i2 ? 0 : 90;
                C4990ab.m7417i("MicroMsg.MPVideoView", "onGetVideoSize adjust direction from AUTO to %s", Integer.valueOf(MPVideoView.this.f17193Yp));
            }
            AppMethodBeat.m2505o(14508);
        }

        public final void aFs() {
            AppMethodBeat.m2504i(14509);
            C4990ab.m7416i("MicroMsg.MPVideoView", "onVideoPause");
            if (MPVideoView.this.jZw == 2) {
                MPVideoView.this.jZv.jVJ.mo45367sE(8);
            }
            MPVideoView.this.jZw = 3;
            MPVideoView.m76015s(MPVideoView.this);
            AppMethodBeat.m2505o(14509);
        }

        public final void aFt() {
            int i = 3;
            AppMethodBeat.m2504i(14510);
            C4990ab.m7417i("MicroMsg.MPVideoView", "onVideoPlay, isLive:%b", Boolean.valueOf(MPVideoView.m76020w(MPVideoView.this)));
            if (MPVideoView.this.mDuration <= 0 && !MPVideoView.m76020w(MPVideoView.this)) {
                MPVideoView.this.hYS.setText(MPVideoView.m76016sI(MPVideoView.this.jZp.getVideoDurationSec()));
            }
            MPVideoView.m75993a(MPVideoView.this, MPVideoView.m76020w(MPVideoView.this));
            if (MPVideoView.this.hZe) {
                MPVideoView.m75984E(MPVideoView.this);
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
            MPVideoView.this.jZv.jVJ.mo45367sE(i);
            MPVideoView.m75985F(MPVideoView.this);
            MPVideoView.this.jZw = 2;
            AppMethodBeat.m2505o(14510);
        }

        public final void aFu() {
            AppMethodBeat.m2504i(14511);
            C4990ab.m7416i("MicroMsg.MPVideoView", "onVideoWaiting");
            MPVideoView.this.hZu = true;
            MPVideoView.m76001g(MPVideoView.this);
            AppMethodBeat.m2505o(14511);
        }

        public final void aFv() {
            AppMethodBeat.m2504i(14512);
            MPVideoView.this.hZu = false;
            MPVideoView.m76006l(MPVideoView.this);
            AppMethodBeat.m2505o(14512);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView$9 */
    class C387229 implements C42594c {
        C387229() {
        }

        public final void aFw() {
            AppMethodBeat.m2504i(14514);
            C4990ab.m7416i("MicroMsg.MPVideoView", "onSeekPre");
            AppMethodBeat.m2505o(14514);
        }

        /* renamed from: oA */
        public final void mo22044oA(int i) {
            AppMethodBeat.m2504i(14515);
            MPVideoView.this.mo68316d((double) i, false);
            MPVideoView.this.jZv.jVJ.mo45367sE(13);
            AppMethodBeat.m2505o(14515);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView$b */
    public interface C38723b {
        /* renamed from: Gf */
        void mo6804Gf(String str);
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView$1 */
    class C428341 implements OnClickListener {
        C428341() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(14486);
            MPVideoView.this.start();
            AppMethodBeat.m2505o(14486);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView$2 */
    class C428352 implements OnClickListener {
        C428352() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(14487);
            MPVideoView.this.mo68325j(false, MPVideoView.this.f17193Yp);
            AppMethodBeat.m2505o(14487);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.widget.MPVideoView$8 */
    class C428368 implements OnClickListener {
        C428368() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(14513);
            boolean z = !MPVideoView.this.aFb();
            MPVideoView mPVideoView = MPVideoView.this;
            mPVideoView.mo68325j(z, mPVideoView.f17193Yp);
            AppMethodBeat.m2505o(14513);
        }
    }

    /* renamed from: j */
    static /* synthetic */ boolean m76004j(MPVideoView mPVideoView) {
        AppMethodBeat.m2504i(14576);
        boolean aFd = mPVideoView.aFd();
        AppMethodBeat.m2505o(14576);
        return aFd;
    }

    /* renamed from: r */
    static /* synthetic */ boolean m76014r(MPVideoView mPVideoView) {
        AppMethodBeat.m2504i(14578);
        boolean aFe = mPVideoView.aFe();
        AppMethodBeat.m2505o(14578);
        return aFe;
    }

    /* renamed from: sI */
    static /* synthetic */ String m76016sI(int i) {
        AppMethodBeat.m2504i(14581);
        String ox = MPVideoView.m76010ox(i);
        AppMethodBeat.m2505o(14581);
        return ox;
    }

    /* renamed from: w */
    static /* synthetic */ boolean m76020w(MPVideoView mPVideoView) {
        AppMethodBeat.m2504i(14580);
        boolean isLive = mPVideoView.isLive();
        AppMethodBeat.m2505o(14580);
        return isLive;
    }

    public MPVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(14520);
        init(context);
        AppMethodBeat.m2505o(14520);
    }

    public MPVideoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(14521);
        init(context);
        AppMethodBeat.m2505o(14521);
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(14522);
        LayoutInflater.from(context).inflate(2130970256, this);
        this.jZp = (MPVideoWrapper) findViewById(2131821402);
        this.hYN = (TextView) findViewById(2131821370);
        this.hYQ = findViewById(2131821403);
        this.hYR = findViewById(2131821405);
        this.hYS = (TextView) findViewById(2131821407);
        this.hYT = (LinearLayout) findViewById(2131821409);
        this.hYU = (AppBrandDotPercentIndicator) findViewById(2131821412);
        this.hYV = (TextView) findViewById(2131821411);
        this.hYW = (ImageView) findViewById(2131821410);
        this.hYX = (ImageView) findViewById(2131821404);
        this.hYY = (ImageView) findViewById(2131821415);
        this.hYZ = (ImageView) findViewById(2131821414);
        this.hZa = (FrameLayout) findViewById(2131821413);
        this.hYU.setDotsNum(8);
        ((ImageView) findViewById(2131821406)).setOnClickListener(new C428341());
        aEY();
        aFa();
        aZb();
        aZa();
        initParam();
        AppMethodBeat.m2505o(14522);
    }

    private void initParam() {
        AppMethodBeat.m2504i(14523);
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
        AppMethodBeat.m2505o(14523);
    }

    public void setConsumeTouchEvent(boolean z) {
        AppMethodBeat.m2504i(14524);
        C4990ab.m7417i("MicroMsg.MPVideoView", "setConsumeTouchEvent value=%s", Boolean.valueOf(z));
        this.hZo = z;
        AppMethodBeat.m2505o(14524);
    }

    public void setShowMuteBtn(boolean z) {
        AppMethodBeat.m2504i(14525);
        C4990ab.m7417i("MicroMsg.MPVideoView", "showMuteBtn %b", Boolean.valueOf(z));
        this.jZq.setShowMuteBtn(z);
        AppMethodBeat.m2505o(14525);
    }

    public void setTitle(String str) {
        AppMethodBeat.m2504i(14526);
        C4990ab.m7417i("MicroMsg.MPVideoView", "setTitle %s", str);
        this.jZq.setTitle(str);
        AppMethodBeat.m2505o(14526);
    }

    public void setShowControlProgress(boolean z) {
        boolean z2 = true;
        AppMethodBeat.m2504i(14527);
        C4990ab.m7417i("MicroMsg.MPVideoView", "setShowControlProgress %b", Boolean.valueOf(z));
        MPVideoViewControlBar mPVideoViewControlBar = this.jZq;
        if (!z || isLive()) {
            z2 = false;
        }
        mPVideoViewControlBar.setShowControlProgress(z2);
        AppMethodBeat.m2505o(14527);
    }

    public void setCustomOnTouchListener(OnTouchListener onTouchListener) {
        this.jZu = onTouchListener;
    }

    public void setBizVideoControlBar(C45767b c45767b) {
        this.jZv = c45767b;
    }

    public long getRealPlayTime() {
        AppMethodBeat.m2504i(14528);
        if (!(this.jZx != 0 || this.jZy == 0 || this.jZw == 0)) {
            this.jZx = System.currentTimeMillis() - this.jZy;
        }
        long j = this.jZx;
        AppMethodBeat.m2505o(14528);
        return j;
    }

    public int getEndPlayTime() {
        AppMethodBeat.m2504i(14529);
        int currPosMs;
        if (getCurrPosMs() != 0 || this.jZw == 0) {
            currPosMs = getCurrPosMs();
            AppMethodBeat.m2505o(14529);
            return currPosMs;
        }
        currPosMs = getDuration() * 1000;
        AppMethodBeat.m2505o(14529);
        return currPosMs;
    }

    public void setPlayBtnPosition(String str) {
        AppMethodBeat.m2504i(14530);
        C4990ab.m7417i("MicroMsg.MPVideoView", "setPlayBtnPosition: %s", str);
        if (C5046bo.isNullOrNil(str) || !str.equalsIgnoreCase("center")) {
            this.jZq.setPlayBtnInCenterPosition(false);
            AppMethodBeat.m2505o(14530);
            return;
        }
        this.jZq.setPlayBtnInCenterPosition(true);
        AppMethodBeat.m2505o(14530);
    }

    public void setEnablePlayGesture(boolean z) {
        AppMethodBeat.m2504i(14531);
        C4990ab.m7417i("MicroMsg.MPVideoView", "setEnablePlayGesture: %b", Boolean.valueOf(z));
        this.hZv = z;
        AppMethodBeat.m2505o(14531);
    }

    public void setAutoPlay(boolean z) {
        AppMethodBeat.m2504i(14532);
        C4990ab.m7417i("MicroMsg.MPVideoView", "setAutoPlay =%b", Boolean.valueOf(z));
        this.mAutoPlay = z;
        if (this.jZw == 0) {
            this.jZw = 1;
        }
        AppMethodBeat.m2505o(14532);
    }

    public void setVideoSource(int i) {
        AppMethodBeat.m2504i(14533);
        C4990ab.m7417i("MicroMsg.MPVideoView", "setVideoSource =%d", Integer.valueOf(i));
        this.hZs = i;
        AppMethodBeat.m2505o(14533);
    }

    public void setDuration(int i) {
        AppMethodBeat.m2504i(14534);
        if (i <= 0) {
            C4990ab.m7417i("MicroMsg.MPVideoView", "setDuration error duration=%d", Integer.valueOf(i));
            AppMethodBeat.m2505o(14534);
            return;
        }
        this.hYS.setText(MPVideoView.m76010ox(i));
        this.mDuration = i;
        AppMethodBeat.m2505o(14534);
    }

    public int getDuration() {
        AppMethodBeat.m2504i(14535);
        int i;
        if (this.mDuration > 0) {
            i = this.mDuration;
            AppMethodBeat.m2505o(14535);
            return i;
        }
        i = this.jZp.getVideoDurationSec();
        AppMethodBeat.m2505o(14535);
        return i;
    }

    public void setLoop(boolean z) {
        AppMethodBeat.m2504i(14536);
        C4990ab.m7417i("MicroMsg.MPVideoView", "setLoop loop=%b", Boolean.valueOf(z));
        this.hZl = z;
        AppMethodBeat.m2505o(14536);
    }

    public final void start() {
        AppMethodBeat.m2504i(14537);
        C4990ab.m7416i("MicroMsg.MPVideoView", "start");
        if (this.jZp.isPlaying()) {
            AppMethodBeat.m2505o(14537);
            return;
        }
        if (this.hZe) {
            this.jZq.aFN();
        }
        this.hYQ.setVisibility(8);
        this.jZp.start();
        AppMethodBeat.m2505o(14537);
    }

    public final void pause() {
        AppMethodBeat.m2504i(14538);
        C4990ab.m7416i("MicroMsg.MPVideoView", "pause");
        if (this.jZp.isPlaying()) {
            this.jZp.pause();
            AppMethodBeat.m2505o(14538);
            return;
        }
        AppMethodBeat.m2505o(14538);
    }

    private void stop() {
        AppMethodBeat.m2504i(14539);
        C4990ab.m7416i("MicroMsg.MPVideoView", "stop");
        if (this.jZp.isPlaying()) {
            this.jZp.stop();
            this.jZq.aFO();
            AppMethodBeat.m2505o(14539);
            return;
        }
        AppMethodBeat.m2505o(14539);
    }

    public final void akW() {
        AppMethodBeat.m2504i(14540);
        C4990ab.m7416i("MicroMsg.MPVideoView", "onUIResume");
        if (this.hZw) {
            C4990ab.m7416i("MicroMsg.MPVideoView", "onUIResume, should skip ui resume");
            this.hZw = false;
            AppMethodBeat.m2505o(14540);
            return;
        }
        this.jZp.akW();
        AppMethodBeat.m2505o(14540);
    }

    public final void akV() {
        AppMethodBeat.m2504i(14541);
        C4990ab.m7416i("MicroMsg.MPVideoView", "onUIPause");
        this.jZp.akV();
        AppMethodBeat.m2505o(14541);
    }

    public final void aEX() {
        AppMethodBeat.m2504i(14542);
        C4990ab.m7416i("MicroMsg.MPVideoView", "onUIDestroy");
        C4990ab.m7416i("MicroMsg.MPVideoView", "clean");
        stop();
        this.jZp.aEX();
        this.jZq.onDestroy();
        AppMethodBeat.m2505o(14542);
    }

    /* renamed from: bL */
    public final void mo68315bL(String str, int i) {
        AppMethodBeat.m2504i(14543);
        C4990ab.m7417i("MicroMsg.MPVideoView", "setVideoPath path=%s isLive=%s", str, Boolean.FALSE);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7418v("MicroMsg.MPVideoView", "setVideoPath videoPath empty");
            AppMethodBeat.m2505o(14543);
            return;
        }
        this.ien = str;
        stop();
        this.hZk = false;
        this.jZp.setVideoSource(this.hZs);
        this.jZp.mo61580c(false, str, i);
        if (this.hZm > 0.0d) {
            this.jZp.mo61581e(this.hZm, this.mAutoPlay);
        }
        if (this.mAutoPlay) {
            C4990ab.m7416i("MicroMsg.MPVideoView", "setVideoPath autoPlay");
            start();
        }
        setCover(str);
        setMute(this.mIsMute);
        AppMethodBeat.m2505o(14543);
    }

    public String getVideoPath() {
        return this.ien;
    }

    /* renamed from: d */
    public final void mo68316d(double d, boolean z) {
        AppMethodBeat.m2504i(14544);
        int currPosSec = this.jZp.getCurrPosSec();
        C4990ab.m7417i("MicroMsg.MPVideoView", "seek to position=%s current=%d isLive=%b", Double.valueOf(d), Integer.valueOf(currPosSec), Boolean.valueOf(this.hZk));
        if (isLive()) {
            AppMethodBeat.m2505o(14544);
            return;
        }
        this.hYQ.setVisibility(8);
        if (z) {
            this.jZp.mo61581e(d, z);
            AppMethodBeat.m2505o(14544);
            return;
        }
        this.jZp.mo61590s(d);
        AppMethodBeat.m2505o(14544);
    }

    public void setIsShowBasicControls(boolean z) {
        AppMethodBeat.m2504i(14545);
        C4990ab.m7417i("MicroMsg.MPVideoView", "setIsShowBasicControls isShowBasicControls=%b", Boolean.valueOf(z));
        this.hZe = z;
        if (this.jZq != null) {
            if (this.hZe) {
                this.jZq.aFD();
                AppMethodBeat.m2505o(14545);
                return;
            }
            this.jZq.setVisibility(8);
        }
        AppMethodBeat.m2505o(14545);
    }

    public void setAutoHideTitle(boolean z) {
        this.jZt = z;
    }

    /* renamed from: a */
    public static String m75992a(C37436r c37436r) {
        AppMethodBeat.m2504i(14546);
        String v = C30080q.m47642v(c37436r.fjT.fjx, c37436r.type, c37436r.fjQ == 0 ? "@T" : "@S");
        AppMethodBeat.m2505o(14546);
        return v;
    }

    /* renamed from: a */
    public final void mo68310a(ImageView imageView, String str, int i, int i2, C37436r c37436r) {
        AppMethodBeat.m2504i(14547);
        C4990ab.m7417i("MicroMsg.MPVideoView", "setCover coverUrl=%s", str);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(14547);
            return;
        }
        this.hZn = str;
        imageView.setContentDescription(getContext().getString(C25738R.string.al_));
        C25815a ahp = C32291o.ahp();
        String str2 = this.hZn;
        C17927a c17927a = new C17927a();
        c17927a.ePH = true;
        c17927a = c17927a.mo33448ct(i, i2);
        c17927a.fGV = new C35838f();
        c17927a.ePJ = MPVideoView.m75992a(c37436r);
        ahp.mo43769a(str2, imageView, c17927a.ahG(), null, new C35836e(0, i, i2, null));
        AppMethodBeat.m2505o(14547);
    }

    private void setCover(final String str) {
        AppMethodBeat.m2504i(14548);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(14548);
        } else if (C5046bo.isNullOrNil(this.hZn)) {
            C33720b.m55105a("BrandServiceWorkerThread", new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(14491);
                    final Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 1);
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(14490);
                            if (!(createVideoThumbnail == null || createVideoThumbnail.isRecycled())) {
                                MPVideoView.this.hYX.setImageBitmap(createVideoThumbnail);
                            }
                            AppMethodBeat.m2505o(14490);
                        }
                    });
                    AppMethodBeat.m2505o(14491);
                }
            }, 0);
            AppMethodBeat.m2505o(14548);
        } else {
            C4990ab.m7416i("MicroMsg.MPVideoView", "setCover mCoverUrl not null");
            AppMethodBeat.m2505o(14548);
        }
    }

    public void setShowProgress(boolean z) {
        boolean z2 = true;
        AppMethodBeat.m2504i(14549);
        C4990ab.m7417i("MicroMsg.MPVideoView", "setShowProgress %b", Boolean.valueOf(z));
        this.hZq = z;
        MPVideoViewControlBar mPVideoViewControlBar = this.jZq;
        if (!z || isLive()) {
            z2 = false;
        }
        mPVideoViewControlBar.setShowProgress(z2);
        AppMethodBeat.m2505o(14549);
    }

    public void setShowFullScreenBtn(boolean z) {
        AppMethodBeat.m2504i(14550);
        C4990ab.m7417i("MicroMsg.MPVideoView", "setShowFullScreenBtn %b", Boolean.valueOf(z));
        this.jZq.setShowFullScreenBtn(z);
        AppMethodBeat.m2505o(14550);
    }

    public void setShowPlayBtn(boolean z) {
        AppMethodBeat.m2504i(14551);
        C4990ab.m7417i("MicroMsg.MPVideoView", "setShowPlayBtn %b", Boolean.valueOf(z));
        this.jZq.setShowPlayBtn(z);
        AppMethodBeat.m2505o(14551);
    }

    private void aYZ() {
        AppMethodBeat.m2504i(14552);
        C4990ab.m7417i("MicroMsg.MPVideoView", "enableProgressGesture %b", Boolean.TRUE);
        this.hZp = true;
        AppMethodBeat.m2505o(14552);
    }

    public void setShowCenterPlayBtn(boolean z) {
        int i = 0;
        AppMethodBeat.m2504i(14553);
        C4990ab.m7417i("MicroMsg.MPVideoView", "setPlayBtnInCenterPosition %b", Boolean.valueOf(z));
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
        AppMethodBeat.m2505o(14553);
    }

    private void aZa() {
        AppMethodBeat.m2504i(14554);
        this.jZp.setScaleType(C27130g.CONTAIN);
        this.hYX.setScaleType(ScaleType.FIT_CENTER);
        AppMethodBeat.m2505o(14554);
    }

    public void setMute(boolean z) {
        AppMethodBeat.m2504i(14555);
        C4990ab.m7417i("MicroMsg.MPVideoView", "setMute isMute=%b", Boolean.valueOf(z));
        this.mIsMute = z;
        this.jZp.setMute(z);
        this.jZq.setMuteBtnState(z);
        AppMethodBeat.m2505o(14555);
    }

    public void setCookieData(String str) {
        this.hZb = str;
    }

    public String getCookieData() {
        return this.hZb;
    }

    public int getCurrPosSec() {
        AppMethodBeat.m2504i(14556);
        int currPosSec = this.jZp.getCurrPosSec();
        AppMethodBeat.m2505o(14556);
        return currPosSec;
    }

    public int getCurrPosMs() {
        AppMethodBeat.m2504i(14557);
        int currPosMs = this.jZp.getCurrPosMs();
        AppMethodBeat.m2505o(14557);
        return currPosMs;
    }

    public int getCacheTimeSec() {
        AppMethodBeat.m2504i(14558);
        if (this.jZp != null) {
            int cacheTimeSec = this.jZp.getCacheTimeSec();
            AppMethodBeat.m2505o(14558);
            return cacheTimeSec;
        }
        AppMethodBeat.m2505o(14558);
        return 0;
    }

    public void setFullScreenDirection(int i) {
        AppMethodBeat.m2504i(14559);
        C4990ab.m7417i("MicroMsg.MPVideoView", "setFullScreenDirection %d", Integer.valueOf(i));
        this.f17193Yp = i;
        AppMethodBeat.m2505o(14559);
    }

    public void setPageGesture(boolean z) {
        AppMethodBeat.m2504i(14560);
        C4990ab.m7417i("MicroMsg.MPVideoView", "setPageGesture pageGesture=%b", Boolean.valueOf(z));
        this.hZg = z;
        AppMethodBeat.m2505o(14560);
    }

    public void setPageGestureInFullscreen(boolean z) {
        AppMethodBeat.m2504i(14561);
        C4990ab.m7417i("MicroMsg.MPVideoView", "setPageGestureInFullscreen pageGestureInFullscreen=%b", Boolean.valueOf(z));
        this.hZh = z;
        AppMethodBeat.m2505o(14561);
    }

    public void setInitialTime(double d) {
        AppMethodBeat.m2504i(14562);
        C4990ab.m7417i("MicroMsg.MPVideoView", "setInitialTime initialTime=%s", Double.valueOf(d));
        this.hZm = d;
        AppMethodBeat.m2505o(14562);
    }

    public void setFullScreenDelegate(C33751a c33751a) {
        this.jZr = c33751a;
    }

    public void setMPVideoViewCallBack(C38723b c38723b) {
        this.jZs = c38723b;
    }

    private void aEY() {
        AppMethodBeat.m2504i(14563);
        this.hZi = new C33414l(getContext(), this, new C275666());
        AppMethodBeat.m2505o(14563);
    }

    private void aFa() {
        AppMethodBeat.m2504i(14564);
        this.jZp.setIMMVideoViewCallback(new C387217());
        AppMethodBeat.m2505o(14564);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        AppMethodBeat.m2504i(14565);
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
                this.hZi.mo53904z(motionEvent);
            }
            AppMethodBeat.m2505o(14565);
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
            AppMethodBeat.m2505o(14565);
            return true;
        }
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.m2505o(14565);
        return onTouchEvent;
    }

    /* renamed from: j */
    public final void mo68325j(boolean z, int i) {
        AppMethodBeat.m2504i(14566);
        C4990ab.m7417i("MicroMsg.MPVideoView", "operateFullScreen toFullScreen:%b direction:%d", Boolean.valueOf(z), Integer.valueOf(i));
        if (this.jZr == null) {
            C4990ab.m7420w("MicroMsg.MPVideoView", "operateFullScreen mFullScreenDelegate null");
            AppMethodBeat.m2505o(14566);
        } else if (z == aFb()) {
            C4990ab.m7416i("MicroMsg.MPVideoView", "operateFullScreen current same");
            AppMethodBeat.m2505o(14566);
        } else {
            int i2;
            if (i == -1) {
                i2 = this.f17193Yp == -1 ? 90 : this.f17193Yp;
                C4990ab.m7417i("MicroMsg.MPVideoView", "operateFullScreen target direction:%d", Integer.valueOf(i2));
            } else {
                i2 = i;
            }
            if (z) {
                this.jZr.mo6803on(i2);
                this.jZq.aFH();
                AppMethodBeat.m2505o(14566);
                return;
            }
            this.jZr.aDF();
            this.jZq.aDF();
            AppMethodBeat.m2505o(14566);
        }
    }

    public final boolean aFb() {
        AppMethodBeat.m2504i(14567);
        if (this.jZr == null) {
            C4990ab.m7420w("MicroMsg.MPVideoView", "isInFullScreen mFullScreenDelegate null");
            AppMethodBeat.m2505o(14567);
            return false;
        }
        boolean isFullScreen = this.jZr.isFullScreen();
        AppMethodBeat.m2505o(14567);
        return isFullScreen;
    }

    private void aZb() {
        AppMethodBeat.m2504i(14568);
        this.jZq = new MPVideoViewControlBar(getContext());
        this.jZp.setVideoFooterView(this.jZq);
        this.jZq.setVisibility(8);
        this.jZq.setFullScreenBtnOnClickListener(new C428368());
        this.jZq.setIplaySeekCallback(new C387229());
        this.jZq.setOnPlayButtonClickListener(new C3374810());
        this.jZq.setStatePorter(new C3374911());
        this.jZq.setMuteBtnOnClickListener(new C3375012());
        this.jZq.setExitFullScreenBtnOnClickListener(new C428352());
        this.jZq.setOnVisibilityChangedListener(new C201153());
        this.jZq.setOnUpdateProgressLenListener(new C247284());
        this.jZp.setControlBar(this.jZq);
        AppMethodBeat.m2505o(14568);
    }

    /* renamed from: ox */
    private static String m76010ox(int i) {
        AppMethodBeat.m2504i(14569);
        String str = MPVideoView.m76011oy(i / 60) + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + MPVideoView.m76011oy(i % 60);
        AppMethodBeat.m2505o(14569);
        return str;
    }

    /* renamed from: oy */
    private static String m76011oy(int i) {
        AppMethodBeat.m2504i(14570);
        String concat;
        if (i < 10) {
            concat = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(i));
            AppMethodBeat.m2505o(14570);
            return concat;
        }
        concat = String.valueOf(i);
        AppMethodBeat.m2505o(14570);
        return concat;
    }

    private boolean isLive() {
        AppMethodBeat.m2504i(14571);
        C4990ab.m7417i("MicroMsg.MPVideoView", "isLive %b %b", Boolean.valueOf(this.hZk), Boolean.valueOf(this.jZp.isLive()));
        if (this.hZk || this.jZp.isLive()) {
            AppMethodBeat.m2505o(14571);
            return true;
        }
        AppMethodBeat.m2505o(14571);
        return false;
    }

    private boolean aFd() {
        AppMethodBeat.m2504i(14572);
        if (!this.hZp || this.jZp.isLive() || aFf()) {
            AppMethodBeat.m2505o(14572);
            return false;
        }
        AppMethodBeat.m2505o(14572);
        return true;
    }

    private boolean aFe() {
        AppMethodBeat.m2504i(14573);
        if (aFf() || ((aFb() || !this.hZg) && !(aFb() && this.hZh))) {
            AppMethodBeat.m2505o(14573);
            return false;
        }
        AppMethodBeat.m2505o(14573);
        return true;
    }

    private boolean aFf() {
        AppMethodBeat.m2504i(14574);
        if (this.hYQ.getVisibility() == 0) {
            AppMethodBeat.m2505o(14574);
            return true;
        }
        AppMethodBeat.m2505o(14574);
        return false;
    }

    /* renamed from: g */
    static /* synthetic */ void m76001g(MPVideoView mPVideoView) {
        AppMethodBeat.m2504i(14575);
        mPVideoView.jZq.aEZ();
        AppMethodBeat.m2505o(14575);
    }

    /* renamed from: l */
    static /* synthetic */ void m76006l(MPVideoView mPVideoView) {
        AppMethodBeat.m2504i(14577);
        mPVideoView.jZq.aFy();
        AppMethodBeat.m2505o(14577);
    }

    /* renamed from: s */
    static /* synthetic */ void m76015s(MPVideoView mPVideoView) {
        AppMethodBeat.m2504i(14579);
        long currentTimeMillis = System.currentTimeMillis();
        mPVideoView.jZx += currentTimeMillis - mPVideoView.jZy;
        mPVideoView.jZy = currentTimeMillis;
        AppMethodBeat.m2505o(14579);
    }

    /* renamed from: E */
    static /* synthetic */ void m75984E(MPVideoView mPVideoView) {
        AppMethodBeat.m2504i(14583);
        boolean aFR = mPVideoView.jZq.aFR();
        if (!mPVideoView.hZe || !mPVideoView.hZq || aFR || mPVideoView.isLive() || mPVideoView.aFf()) {
            mPVideoView.hZa.setVisibility(8);
            AppMethodBeat.m2505o(14583);
            return;
        }
        mPVideoView.hZa.setVisibility(0);
        AppMethodBeat.m2505o(14583);
    }

    /* renamed from: F */
    static /* synthetic */ void m75985F(MPVideoView mPVideoView) {
        AppMethodBeat.m2504i(14584);
        mPVideoView.jZy = System.currentTimeMillis();
        AppMethodBeat.m2505o(14584);
    }
}
