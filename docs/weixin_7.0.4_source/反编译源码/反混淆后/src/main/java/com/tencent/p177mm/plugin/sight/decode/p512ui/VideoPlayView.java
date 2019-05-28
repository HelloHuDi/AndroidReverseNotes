package com.tencent.p177mm.plugin.sight.decode.p512ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g;
import com.tencent.p177mm.model.C42192d.C42190a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C34915a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14978d;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14980e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14981a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14982c;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C14979e.C14983b;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C46510q;
import com.tencent.p177mm.pluginsdk.p597ui.tools.VideoSightView;
import com.tencent.p177mm.sdk.platformtools.BackwardSupportUtil.C4977b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

/* renamed from: com.tencent.mm.plugin.sight.decode.ui.VideoPlayView */
public class VideoPlayView extends RelativeLayout implements C42190a, C14979e {
    private int duration = 0;
    private String ePJ;
    private boolean eif = false;
    private C7306ak fbD = new C7306ak();
    private ProgressBar gHA;
    public View iVh;
    public C14979e klq = null;
    private int qyX = 320;
    private int qyY = 240;
    private boolean qyZ = true;
    private C13332a qza;
    private ViewGroup qzb;
    public C13333a qzc;
    private double qzd = 0.0d;
    public TextView qze;
    public String qzf = "";
    private View qzg;
    public ImageView qzh;
    public boolean qzi = true;
    private int qzj = 0;
    private int qzk = 0;
    private boolean qzl = false;
    private boolean qzm = false;
    private long qzn = 0;
    private Animation qzo = new AlphaAnimation(1.0f, 0.0f);
    private Animation qzp = new AlphaAnimation(0.0f, 1.0f);
    private Runnable qzq = new C447634();
    public int qzr = 0;

    /* renamed from: com.tencent.mm.plugin.sight.decode.ui.VideoPlayView$8 */
    class C38548 implements Runnable {
        C38548() {
        }

        public final void run() {
            AppMethodBeat.m2504i(70323);
            if (!VideoPlayView.this.klq.isPlaying()) {
                ((AdVideoPlayerLoadingBar) VideoPlayView.this.qzc).aFQ();
            }
            AppMethodBeat.m2505o(70323);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.decode.ui.VideoPlayView$7 */
    class C133317 implements Runnable {
        C133317() {
        }

        public final void run() {
            AppMethodBeat.m2504i(70322);
            if (VideoPlayView.this.qzc != null) {
                VideoPlayView.this.qzc.setIsPlay(false);
            }
            AppMethodBeat.m2505o(70322);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.decode.ui.VideoPlayView$a */
    public interface C13332a {
        /* renamed from: CG */
        void mo17716CG(int i);

        void clr();

        void cls();

        void clt();

        /* renamed from: kC */
        void mo17720kC(boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.sight.decode.ui.VideoPlayView$5 */
    public class C218475 implements C3855b {
        public final void aFw() {
            AppMethodBeat.m2504i(70319);
            VideoPlayView.this.fbD.removeCallbacks(VideoPlayView.this.qzq);
            VideoPlayView.m81645d(VideoPlayView.this);
            AppMethodBeat.m2505o(70319);
        }

        /* renamed from: oA */
        public final void mo8552oA(int i) {
            AppMethodBeat.m2504i(70320);
            C4990ab.m7416i("MicroMsg.VideoPlayView", "onSeek time ".concat(String.valueOf(i)));
            VideoPlayView.this.qzd = (double) i;
            VideoPlayView.this.klq.mo9052B((double) i);
            VideoPlayView.this.fbD.removeCallbacks(VideoPlayView.this.qzq);
            VideoPlayView.this.fbD.postDelayed(VideoPlayView.this.qzq, 3000);
            AppMethodBeat.m2505o(70320);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.decode.ui.VideoPlayView$6 */
    public class C290186 implements OnClickListener {
        public final void onClick(View view) {
            AppMethodBeat.m2504i(70321);
            VideoPlayView.this.fbD.removeCallbacks(VideoPlayView.this.qzq);
            VideoPlayView.this.fbD.postDelayed(VideoPlayView.this.qzq, 3000);
            if (VideoPlayView.this.klq.isPlaying()) {
                VideoPlayView.m81658o(VideoPlayView.this);
                if (VideoPlayView.this.qzc != null) {
                    VideoPlayView.this.qzc.setIsPlay(false);
                    AppMethodBeat.m2505o(70321);
                    return;
                }
            }
            VideoPlayView.m81639a(VideoPlayView.this, false);
            VideoPlayView.this.klq.mo9052B(VideoPlayView.this.qzd);
            if (VideoPlayView.this.qzc != null) {
                VideoPlayView.this.qzc.setIsPlay(true);
            }
            AppMethodBeat.m2505o(70321);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.decode.ui.VideoPlayView$3 */
    class C397133 implements Runnable {
        C397133() {
        }

        public final void run() {
            AppMethodBeat.m2504i(70317);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            if (VideoPlayView.this.getContext() instanceof MMActivity) {
                ((MMActivity) VideoPlayView.this.getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                if (VideoPlayView.this.klq instanceof VideoSightView) {
                    ((VideoSightView) VideoPlayView.this.klq).setDrawableWidth(displayMetrics.widthPixels);
                }
            }
            ((View) VideoPlayView.this.klq).requestLayout();
            ((View) VideoPlayView.this.klq).postInvalidate();
            AppMethodBeat.m2505o(70317);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.decode.ui.VideoPlayView$1 */
    class C435291 implements C14981a {

        /* renamed from: com.tencent.mm.plugin.sight.decode.ui.VideoPlayView$1$2 */
        class C133302 implements Runnable {
            C133302() {
            }

            public final void run() {
                AppMethodBeat.m2504i(70310);
                VideoPlayView.m81647e(VideoPlayView.this, VideoPlayView.this.qzr);
                AppMethodBeat.m2505o(70310);
            }
        }

        C435291() {
        }

        /* renamed from: pL */
        public final void mo8557pL() {
            AppMethodBeat.m2504i(70311);
            C4990ab.m7410d("MicroMsg.VideoPlayView", C1447g.m3074Mp() + " onPrepared");
            VideoPlayView.m81639a(VideoPlayView.this, true);
            AppMethodBeat.m2505o(70311);
        }

        public final void onError(int i, int i2) {
            AppMethodBeat.m2504i(70312);
            C4990ab.m7413e("MicroMsg.VideoPlayView", "on play video error, what %d extra %d", Integer.valueOf(i), Integer.valueOf(i2));
            VideoPlayView.this.klq.stop();
            AppMethodBeat.m2505o(70312);
        }

        /* renamed from: EA */
        public final void mo8553EA() {
            AppMethodBeat.m2504i(70313);
            C4990ab.m7410d("MicroMsg.VideoPlayView", "on completion " + C5046bo.dpG().toString());
            if (VideoPlayView.this.qzl) {
                VideoPlayView.this.qzc.setIsPlay(false);
                VideoPlayView.m81638a(VideoPlayView.this, (int) VideoPlayView.this.qzd);
                VideoPlayView.m81645d(VideoPlayView.this);
                if (VideoPlayView.this.qza != null) {
                    VideoPlayView.this.qza.clt();
                }
            } else {
                VideoPlayView.this.qzd = 0.0d;
                VideoPlayView.this.mo9052B(0.0d);
                VideoPlayView.this.qzc.setIsPlay(false);
                VideoPlayView.m81638a(VideoPlayView.this, 0);
                VideoPlayView.m81645d(VideoPlayView.this);
                if (System.currentTimeMillis() - VideoPlayView.this.qzn < FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                    C4990ab.m7416i("MicroMsg.VideoPlayView", "Too short onCompletion");
                    AppMethodBeat.m2505o(70313);
                    return;
                }
                VideoPlayView.this.qzn = System.currentTimeMillis();
                if (VideoPlayView.this.qza != null) {
                    VideoPlayView.this.qza.cls();
                    AppMethodBeat.m2505o(70313);
                    return;
                }
            }
            AppMethodBeat.m2505o(70313);
        }

        /* renamed from: dG */
        public final int mo8554dG(final int i, final int i2) {
            AppMethodBeat.m2504i(70314);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(70309);
                    C4990ab.m7416i("MicroMsg.VideoPlayView", "play time " + i + " video time " + i2);
                    if (i2 > 0) {
                        VideoPlayView.this.duration = i2;
                        if (VideoPlayView.this.qzc != null && VideoPlayView.this.qyZ) {
                            VideoPlayView.this.qyZ = false;
                        }
                        VideoPlayView.this.qza.mo17716CG(i2);
                    }
                    if (VideoPlayView.this.qzc != null) {
                        if (VideoPlayView.this.qzc.getVideoTotalTime() != i2) {
                            VideoPlayView.this.qzc.setVideoTotalTime(i2);
                        }
                        VideoPlayView.this.qzc.seek(i);
                        VideoPlayView.this.qzc.setIsPlay(true);
                    }
                    if (VideoPlayView.this.gHA.getVisibility() == 0) {
                        VideoPlayView.this.gHA.setVisibility(8);
                    }
                    VideoPlayView.this.qzd = (double) i;
                    AppMethodBeat.m2505o(70309);
                }
            });
            AppMethodBeat.m2505o(70314);
            return 0;
        }

        /* renamed from: dH */
        public final void mo8555dH(int i, int i2) {
            AppMethodBeat.m2504i(70315);
            VideoPlayView.this.qyX = i;
            VideoPlayView.this.qyY = i2;
            if (VideoPlayView.this.qzm) {
                VideoPlayView.this.fbD.post(new C133302());
            }
            AppMethodBeat.m2505o(70315);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.decode.ui.VideoPlayView$2 */
    class C447622 implements OnTouchListener {
        C447622() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(70316);
            if (motionEvent.getAction() == 1) {
                VideoPlayView.m81656m(VideoPlayView.this);
            } else {
                motionEvent.getAction();
            }
            AppMethodBeat.m2505o(70316);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.sight.decode.ui.VideoPlayView$4 */
    class C447634 implements Runnable {
        C447634() {
        }

        public final void run() {
            AppMethodBeat.m2504i(70318);
            VideoPlayView.this.clq();
            AppMethodBeat.m2505o(70318);
        }
    }

    /* renamed from: d */
    static /* synthetic */ void m81645d(VideoPlayView videoPlayView) {
        AppMethodBeat.m2504i(70355);
        videoPlayView.clp();
        AppMethodBeat.m2505o(70355);
    }

    /* renamed from: e */
    static /* synthetic */ void m81647e(VideoPlayView videoPlayView, int i) {
        AppMethodBeat.m2504i(70356);
        videoPlayView.update(i);
        AppMethodBeat.m2505o(70356);
    }

    public void setVideoPath(String str) {
        AppMethodBeat.m2504i(70324);
        this.ePJ = str;
        C4990ab.m7417i("MicroMsg.VideoPlayView", "videoPath  %s", this.ePJ);
        this.klq.setVideoPath(this.ePJ);
        AppMethodBeat.m2505o(70324);
    }

    public void setVideoPlayViewEvent(C13332a c13332a) {
        this.qza = c13332a;
    }

    public VideoPlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(70325);
        init();
        AppMethodBeat.m2505o(70325);
    }

    public VideoPlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(70326);
        init();
        AppMethodBeat.m2505o(70326);
    }

    private void init() {
        AppMethodBeat.m2504i(70327);
        this.qzo.setDuration(200);
        this.qzp.setDuration(200);
        View.inflate(getContext(), 2130970989, this);
        this.qzg = findViewById(2131828415);
        this.qzh = (ImageView) findViewById(2131828416);
        this.qzh.getDrawable().setColorFilter(-1, Mode.SRC_ATOP);
        this.gHA = (ProgressBar) findViewById(2131821219);
        this.qzb = (ViewGroup) findViewById(2131823992);
        this.klq = C46510q.m87801fT(getContext());
        this.klq.setLoop(false);
        this.qzb.addView((View) this.klq, 0, new LayoutParams(-1, -1));
        this.qze = (TextView) findViewById(2131827573);
        this.iVh = this.qze;
        this.klq.setVideoCallback(new C435291());
        if (this.klq instanceof VideoSightView) {
            ((VideoSightView) this.klq).setEnableConfigChanged(false);
        }
        setOnTouchListener(new C447622());
        clq();
        ((View) this.klq).post(new C397133());
        AppMethodBeat.m2505o(70327);
    }

    public void setVideoTotalTime(int i) {
        AppMethodBeat.m2504i(70328);
        if (this.qzc.getVideoTotalTime() != i) {
            this.qzc.setVideoTotalTime(i);
        }
        AppMethodBeat.m2505o(70328);
    }

    public void setIsDownloading(boolean z) {
        AppMethodBeat.m2504i(70329);
        this.qzl = z;
        if (this.klq != null && (this.klq instanceof VideoSightView)) {
            VideoSightView videoSightView = (VideoSightView) this.klq;
            if (videoSightView.getController() != null) {
                videoSightView.getController().qxH = !z;
            }
        }
        AppMethodBeat.m2505o(70329);
    }

    public final void clo() {
        AppMethodBeat.m2504i(70330);
        this.gHA.setVisibility(0);
        AppMethodBeat.m2505o(70330);
    }

    private void clp() {
        int i;
        AppMethodBeat.m2504i(70331);
        ((View) this.qzc).setVisibility(0);
        this.qzg.setVisibility(0);
        if (this.qzi) {
            this.qzh.setVisibility(0);
        }
        if (this.qzr == 2) {
            i = 0;
        } else if (C5046bo.isNullOrNil(this.qzf)) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            this.iVh.setVisibility(0);
        }
        this.fbD.removeCallbacks(this.qzq);
        this.fbD.postDelayed(this.qzq, 3000);
        AppMethodBeat.m2505o(70331);
    }

    public final void clq() {
        AppMethodBeat.m2504i(70332);
        if (this.qzc != null) {
            ((View) this.qzc).setVisibility(4);
        }
        this.qzg.setVisibility(8);
        this.qzh.setVisibility(8);
        this.iVh.setVisibility(8);
        AppMethodBeat.m2505o(70332);
    }

    public void setLeftButtonOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(70333);
        this.qzg.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(70333);
    }

    public void setRightButtonOnCliclListener(OnClickListener onClickListener) {
        AppMethodBeat.m2504i(70334);
        this.qzh.setOnClickListener(onClickListener);
        AppMethodBeat.m2505o(70334);
    }

    public final boolean start() {
        AppMethodBeat.m2504i(70335);
        m81654kB(true);
        AppMethodBeat.m2505o(70335);
        return true;
    }

    /* renamed from: kB */
    private void m81654kB(boolean z) {
        AppMethodBeat.m2504i(70337);
        this.klq.mo9052B(this.qzd);
        this.klq.start();
        C4990ab.m7416i("MicroMsg.VideoPlayView", "startplay get duration " + this.duration + " lastPlayProgressTime: " + this.qzd);
        if (this.qza != null) {
            this.qza.mo17720kC(z);
        }
        AppMethodBeat.m2505o(70337);
    }

    /* renamed from: CF */
    private void m81634CF(int i) {
        AppMethodBeat.m2504i(70338);
        this.qzd = i >= 0 ? (double) i : this.klq.getLastProgresstime();
        C4990ab.m7416i("MicroMsg.VideoPlayView", "pause play " + this.qzd + " lastTime: " + i + " last " + this.klq.getLastProgresstime());
        this.klq.pause();
        this.fbD.post(new C133317());
        if (this.qza != null) {
            this.qza.clr();
        }
        AppMethodBeat.m2505o(70338);
    }

    public final boolean isPlaying() {
        AppMethodBeat.m2504i(70339);
        boolean isPlaying = this.klq.isPlaying();
        AppMethodBeat.m2505o(70339);
        return isPlaying;
    }

    public String getVideoPath() {
        return this.ePJ;
    }

    /* renamed from: w */
    public final boolean mo27377w(Context context, boolean z) {
        AppMethodBeat.m2504i(70340);
        boolean w = this.klq.mo27377w(context, z);
        AppMethodBeat.m2505o(70340);
        return w;
    }

    public final void stop() {
        AppMethodBeat.m2504i(70341);
        this.klq.stop();
        AppMethodBeat.m2505o(70341);
    }

    public final void onDetach() {
        AppMethodBeat.m2504i(70342);
        this.klq.onDetach();
        AppMethodBeat.m2505o(70342);
    }

    public void setLoop(boolean z) {
        AppMethodBeat.m2504i(70343);
        this.klq.setLoop(z);
        AppMethodBeat.m2505o(70343);
    }

    public double getLastProgresstime() {
        AppMethodBeat.m2504i(70344);
        double max = Math.max(this.qzd, this.klq.getLastProgresstime());
        AppMethodBeat.m2505o(70344);
        return max;
    }

    public void setVideoCallback(C14981a c14981a) {
        AppMethodBeat.m2504i(70345);
        this.klq.setVideoCallback(c14981a);
        AppMethodBeat.m2505o(70345);
    }

    public int getCurrentPosition() {
        AppMethodBeat.m2504i(70346);
        int currentPosition = this.klq.getCurrentPosition();
        AppMethodBeat.m2505o(70346);
        return currentPosition;
    }

    public int getDuration() {
        AppMethodBeat.m2504i(70347);
        int duration;
        if (this.duration == 0) {
            duration = this.klq.getDuration();
            AppMethodBeat.m2505o(70347);
            return duration;
        }
        duration = this.duration;
        AppMethodBeat.m2505o(70347);
        return duration;
    }

    public void setThumb(Bitmap bitmap) {
        AppMethodBeat.m2504i(70348);
        this.klq.setThumb(bitmap);
        AppMethodBeat.m2505o(70348);
    }

    /* renamed from: B */
    public final void mo9052B(double d) {
        AppMethodBeat.m2504i(70349);
        this.klq.mo9052B(d);
        this.qzc.seek((int) d);
        AppMethodBeat.m2505o(70349);
    }

    public void setPlayProgressCallback(boolean z) {
        AppMethodBeat.m2504i(70350);
        this.klq.setPlayProgressCallback(z);
        AppMethodBeat.m2505o(70350);
    }

    public final void update(int i) {
        LayoutParams layoutParams;
        AppMethodBeat.m2504i(70351);
        this.qzm = true;
        if (this.qzk == 0 || this.qzj == 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.qzk = displayMetrics.heightPixels;
            this.qzj = displayMetrics.widthPixels;
            if (this.qzk < this.qzj) {
                this.qzk = displayMetrics.widthPixels;
                this.qzj = displayMetrics.heightPixels;
            }
            C4990ab.m7416i("MicroMsg.VideoPlayView", "getScreen screen_height:" + this.qzk + " screen_width:" + this.qzj);
        }
        ViewGroup.LayoutParams layoutParams2 = this.qzb.getLayoutParams();
        if (this.qzc == null) {
            layoutParams = null;
        } else {
            layoutParams = (LayoutParams) ((View) this.qzc).getLayoutParams();
        }
        LayoutParams layoutParams3 = new LayoutParams(-1, -1);
        if (i == 1) {
            layoutParams3.width = this.qzj;
            layoutParams3.height = (int) (((((double) this.qzj) * 1.0d) * ((double) this.qyY)) / ((double) this.qyX));
            if (this.qzc != null) {
                layoutParams.bottomMargin = C4977b.m7371b(getContext(), 0.0f);
            }
        } else {
            layoutParams3.height = this.qzj;
            layoutParams3.width = (int) (((((double) this.qzj) * 1.0d) * ((double) this.qyX)) / ((double) this.qyY));
            if (this.qzc != null) {
                layoutParams.bottomMargin = C4977b.m7371b(getContext(), 0.0f);
            }
        }
        if (this.qzc != null) {
            this.qzc.clm();
            ((View) this.qzc).setLayoutParams(layoutParams);
            if (this.qzc instanceof AdVideoPlayerLoadingBar) {
                this.fbD.postDelayed(new C38548(), 500);
            }
        }
        C4990ab.m7416i("MicroMsg.VideoPlayView", "orientation " + i + " " + layoutParams3.width + " " + layoutParams3.height);
        ((View) this.klq).setLayoutParams(layoutParams3);
        if (this.klq instanceof C34915a) {
            ((C34915a) this.klq).mo8513fi(layoutParams3.width, layoutParams3.height);
        }
        layoutParams2.height = layoutParams3.height;
        layoutParams2.width = layoutParams3.width;
        this.qzb.setLayoutParams(layoutParams2);
        ((View) this.klq).requestLayout();
        AppMethodBeat.m2505o(70351);
    }

    public long getLastSurfaceUpdateTime() {
        return 0;
    }

    public void setForceScaleFullScreen(boolean z) {
    }

    public void setMute(boolean z) {
        this.eif = z;
    }

    /* renamed from: d */
    public final void mo27356d(double d, boolean z) {
        AppMethodBeat.m2504i(70352);
        mo9052B(d);
        AppMethodBeat.m2505o(70352);
    }

    public void setOneTimeVideoTextureUpdateCallback(C14980e c14980e) {
    }

    public void setOnSeekCompleteCallback(C14982c c14982c) {
    }

    public void setOnInfoCallback(C14983b c14983b) {
    }

    public void setOnSurfaceCallback(C14978d c14978d) {
    }

    public final void pause() {
        AppMethodBeat.m2504i(70336);
        m81634CF(-1);
        AppMethodBeat.m2505o(70336);
    }

    /* renamed from: m */
    static /* synthetic */ void m81656m(VideoPlayView videoPlayView) {
        AppMethodBeat.m2504i(70357);
        if (videoPlayView.qzg.getVisibility() == 0) {
            videoPlayView.clq();
            AppMethodBeat.m2505o(70357);
            return;
        }
        videoPlayView.clp();
        AppMethodBeat.m2505o(70357);
    }

    /* renamed from: o */
    static /* synthetic */ void m81658o(VideoPlayView videoPlayView) {
        AppMethodBeat.m2504i(70358);
        videoPlayView.m81634CF(-1);
        AppMethodBeat.m2505o(70358);
    }
}
