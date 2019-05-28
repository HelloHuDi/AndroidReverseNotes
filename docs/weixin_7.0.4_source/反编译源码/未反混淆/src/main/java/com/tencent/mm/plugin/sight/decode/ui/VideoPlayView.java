package com.tencent.mm.plugin.sight.decode.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.pluginsdk.ui.tools.VideoSightView;
import com.tencent.mm.pluginsdk.ui.tools.e;
import com.tencent.mm.pluginsdk.ui.tools.e.c;
import com.tencent.mm.pluginsdk.ui.tools.e.d;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

public class VideoPlayView extends RelativeLayout implements com.tencent.mm.model.d.a, e {
    private int duration = 0;
    private String ePJ;
    private boolean eif = false;
    private ak fbD = new ak();
    private ProgressBar gHA;
    public View iVh;
    public e klq = null;
    private int qyX = 320;
    private int qyY = 240;
    private boolean qyZ = true;
    private a qza;
    private ViewGroup qzb;
    public a qzc;
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
    private Runnable qzq = new Runnable() {
        public final void run() {
            AppMethodBeat.i(70318);
            VideoPlayView.this.clq();
            AppMethodBeat.o(70318);
        }
    };
    public int qzr = 0;

    public interface a {
        void CG(int i);

        void clr();

        void cls();

        void clt();

        void kC(boolean z);
    }

    static /* synthetic */ void d(VideoPlayView videoPlayView) {
        AppMethodBeat.i(70355);
        videoPlayView.clp();
        AppMethodBeat.o(70355);
    }

    static /* synthetic */ void e(VideoPlayView videoPlayView, int i) {
        AppMethodBeat.i(70356);
        videoPlayView.update(i);
        AppMethodBeat.o(70356);
    }

    public void setVideoPath(String str) {
        AppMethodBeat.i(70324);
        this.ePJ = str;
        ab.i("MicroMsg.VideoPlayView", "videoPath  %s", this.ePJ);
        this.klq.setVideoPath(this.ePJ);
        AppMethodBeat.o(70324);
    }

    public void setVideoPlayViewEvent(a aVar) {
        this.qza = aVar;
    }

    public VideoPlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(70325);
        init();
        AppMethodBeat.o(70325);
    }

    public VideoPlayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(70326);
        init();
        AppMethodBeat.o(70326);
    }

    private void init() {
        AppMethodBeat.i(70327);
        this.qzo.setDuration(200);
        this.qzp.setDuration(200);
        View.inflate(getContext(), R.layout.b1c, this);
        this.qzg = findViewById(R.id.f0r);
        this.qzh = (ImageView) findViewById(R.id.f0s);
        this.qzh.getDrawable().setColorFilter(-1, Mode.SRC_ATOP);
        this.gHA = (ProgressBar) findViewById(R.id.rj);
        this.qzb = (ViewGroup) findViewById(R.id.bs7);
        this.klq = q.fT(getContext());
        this.klq.setLoop(false);
        this.qzb.addView((View) this.klq, 0, new LayoutParams(-1, -1));
        this.qze = (TextView) findViewById(R.id.ee0);
        this.iVh = this.qze;
        this.klq.setVideoCallback(new com.tencent.mm.pluginsdk.ui.tools.e.a() {
            public final void pL() {
                AppMethodBeat.i(70311);
                ab.d("MicroMsg.VideoPlayView", g.Mp() + " onPrepared");
                VideoPlayView.a(VideoPlayView.this, true);
                AppMethodBeat.o(70311);
            }

            public final void onError(int i, int i2) {
                AppMethodBeat.i(70312);
                ab.e("MicroMsg.VideoPlayView", "on play video error, what %d extra %d", Integer.valueOf(i), Integer.valueOf(i2));
                VideoPlayView.this.klq.stop();
                AppMethodBeat.o(70312);
            }

            public final void EA() {
                AppMethodBeat.i(70313);
                ab.d("MicroMsg.VideoPlayView", "on completion " + bo.dpG().toString());
                if (VideoPlayView.this.qzl) {
                    VideoPlayView.this.qzc.setIsPlay(false);
                    VideoPlayView.a(VideoPlayView.this, (int) VideoPlayView.this.qzd);
                    VideoPlayView.d(VideoPlayView.this);
                    if (VideoPlayView.this.qza != null) {
                        VideoPlayView.this.qza.clt();
                    }
                } else {
                    VideoPlayView.this.qzd = 0.0d;
                    VideoPlayView.this.B(0.0d);
                    VideoPlayView.this.qzc.setIsPlay(false);
                    VideoPlayView.a(VideoPlayView.this, 0);
                    VideoPlayView.d(VideoPlayView.this);
                    if (System.currentTimeMillis() - VideoPlayView.this.qzn < FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
                        ab.i("MicroMsg.VideoPlayView", "Too short onCompletion");
                        AppMethodBeat.o(70313);
                        return;
                    }
                    VideoPlayView.this.qzn = System.currentTimeMillis();
                    if (VideoPlayView.this.qza != null) {
                        VideoPlayView.this.qza.cls();
                        AppMethodBeat.o(70313);
                        return;
                    }
                }
                AppMethodBeat.o(70313);
            }

            public final int dG(final int i, final int i2) {
                AppMethodBeat.i(70314);
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(70309);
                        ab.i("MicroMsg.VideoPlayView", "play time " + i + " video time " + i2);
                        if (i2 > 0) {
                            VideoPlayView.this.duration = i2;
                            if (VideoPlayView.this.qzc != null && VideoPlayView.this.qyZ) {
                                VideoPlayView.this.qyZ = false;
                            }
                            VideoPlayView.this.qza.CG(i2);
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
                        AppMethodBeat.o(70309);
                    }
                });
                AppMethodBeat.o(70314);
                return 0;
            }

            public final void dH(int i, int i2) {
                AppMethodBeat.i(70315);
                VideoPlayView.this.qyX = i;
                VideoPlayView.this.qyY = i2;
                if (VideoPlayView.this.qzm) {
                    VideoPlayView.this.fbD.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(70310);
                            VideoPlayView.e(VideoPlayView.this, VideoPlayView.this.qzr);
                            AppMethodBeat.o(70310);
                        }
                    });
                }
                AppMethodBeat.o(70315);
            }
        });
        if (this.klq instanceof VideoSightView) {
            ((VideoSightView) this.klq).setEnableConfigChanged(false);
        }
        setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(70316);
                if (motionEvent.getAction() == 1) {
                    VideoPlayView.m(VideoPlayView.this);
                } else {
                    motionEvent.getAction();
                }
                AppMethodBeat.o(70316);
                return true;
            }
        });
        clq();
        ((View) this.klq).post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(70317);
                DisplayMetrics displayMetrics = new DisplayMetrics();
                if (VideoPlayView.this.getContext() instanceof MMActivity) {
                    ((MMActivity) VideoPlayView.this.getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                    if (VideoPlayView.this.klq instanceof VideoSightView) {
                        ((VideoSightView) VideoPlayView.this.klq).setDrawableWidth(displayMetrics.widthPixels);
                    }
                }
                ((View) VideoPlayView.this.klq).requestLayout();
                ((View) VideoPlayView.this.klq).postInvalidate();
                AppMethodBeat.o(70317);
            }
        });
        AppMethodBeat.o(70327);
    }

    public void setVideoTotalTime(int i) {
        AppMethodBeat.i(70328);
        if (this.qzc.getVideoTotalTime() != i) {
            this.qzc.setVideoTotalTime(i);
        }
        AppMethodBeat.o(70328);
    }

    public void setIsDownloading(boolean z) {
        AppMethodBeat.i(70329);
        this.qzl = z;
        if (this.klq != null && (this.klq instanceof VideoSightView)) {
            VideoSightView videoSightView = (VideoSightView) this.klq;
            if (videoSightView.getController() != null) {
                videoSightView.getController().qxH = !z;
            }
        }
        AppMethodBeat.o(70329);
    }

    public final void clo() {
        AppMethodBeat.i(70330);
        this.gHA.setVisibility(0);
        AppMethodBeat.o(70330);
    }

    private void clp() {
        int i;
        AppMethodBeat.i(70331);
        ((View) this.qzc).setVisibility(0);
        this.qzg.setVisibility(0);
        if (this.qzi) {
            this.qzh.setVisibility(0);
        }
        if (this.qzr == 2) {
            i = 0;
        } else if (bo.isNullOrNil(this.qzf)) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            this.iVh.setVisibility(0);
        }
        this.fbD.removeCallbacks(this.qzq);
        this.fbD.postDelayed(this.qzq, 3000);
        AppMethodBeat.o(70331);
    }

    public final void clq() {
        AppMethodBeat.i(70332);
        if (this.qzc != null) {
            ((View) this.qzc).setVisibility(4);
        }
        this.qzg.setVisibility(8);
        this.qzh.setVisibility(8);
        this.iVh.setVisibility(8);
        AppMethodBeat.o(70332);
    }

    public void setLeftButtonOnClickListener(OnClickListener onClickListener) {
        AppMethodBeat.i(70333);
        this.qzg.setOnClickListener(onClickListener);
        AppMethodBeat.o(70333);
    }

    public void setRightButtonOnCliclListener(OnClickListener onClickListener) {
        AppMethodBeat.i(70334);
        this.qzh.setOnClickListener(onClickListener);
        AppMethodBeat.o(70334);
    }

    public final boolean start() {
        AppMethodBeat.i(70335);
        kB(true);
        AppMethodBeat.o(70335);
        return true;
    }

    private void kB(boolean z) {
        AppMethodBeat.i(70337);
        this.klq.B(this.qzd);
        this.klq.start();
        ab.i("MicroMsg.VideoPlayView", "startplay get duration " + this.duration + " lastPlayProgressTime: " + this.qzd);
        if (this.qza != null) {
            this.qza.kC(z);
        }
        AppMethodBeat.o(70337);
    }

    private void CF(int i) {
        AppMethodBeat.i(70338);
        this.qzd = i >= 0 ? (double) i : this.klq.getLastProgresstime();
        ab.i("MicroMsg.VideoPlayView", "pause play " + this.qzd + " lastTime: " + i + " last " + this.klq.getLastProgresstime());
        this.klq.pause();
        this.fbD.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(70322);
                if (VideoPlayView.this.qzc != null) {
                    VideoPlayView.this.qzc.setIsPlay(false);
                }
                AppMethodBeat.o(70322);
            }
        });
        if (this.qza != null) {
            this.qza.clr();
        }
        AppMethodBeat.o(70338);
    }

    public final boolean isPlaying() {
        AppMethodBeat.i(70339);
        boolean isPlaying = this.klq.isPlaying();
        AppMethodBeat.o(70339);
        return isPlaying;
    }

    public String getVideoPath() {
        return this.ePJ;
    }

    public final boolean w(Context context, boolean z) {
        AppMethodBeat.i(70340);
        boolean w = this.klq.w(context, z);
        AppMethodBeat.o(70340);
        return w;
    }

    public final void stop() {
        AppMethodBeat.i(70341);
        this.klq.stop();
        AppMethodBeat.o(70341);
    }

    public final void onDetach() {
        AppMethodBeat.i(70342);
        this.klq.onDetach();
        AppMethodBeat.o(70342);
    }

    public void setLoop(boolean z) {
        AppMethodBeat.i(70343);
        this.klq.setLoop(z);
        AppMethodBeat.o(70343);
    }

    public double getLastProgresstime() {
        AppMethodBeat.i(70344);
        double max = Math.max(this.qzd, this.klq.getLastProgresstime());
        AppMethodBeat.o(70344);
        return max;
    }

    public void setVideoCallback(com.tencent.mm.pluginsdk.ui.tools.e.a aVar) {
        AppMethodBeat.i(70345);
        this.klq.setVideoCallback(aVar);
        AppMethodBeat.o(70345);
    }

    public int getCurrentPosition() {
        AppMethodBeat.i(70346);
        int currentPosition = this.klq.getCurrentPosition();
        AppMethodBeat.o(70346);
        return currentPosition;
    }

    public int getDuration() {
        AppMethodBeat.i(70347);
        int duration;
        if (this.duration == 0) {
            duration = this.klq.getDuration();
            AppMethodBeat.o(70347);
            return duration;
        }
        duration = this.duration;
        AppMethodBeat.o(70347);
        return duration;
    }

    public void setThumb(Bitmap bitmap) {
        AppMethodBeat.i(70348);
        this.klq.setThumb(bitmap);
        AppMethodBeat.o(70348);
    }

    public final void B(double d) {
        AppMethodBeat.i(70349);
        this.klq.B(d);
        this.qzc.seek((int) d);
        AppMethodBeat.o(70349);
    }

    public void setPlayProgressCallback(boolean z) {
        AppMethodBeat.i(70350);
        this.klq.setPlayProgressCallback(z);
        AppMethodBeat.o(70350);
    }

    public final void update(int i) {
        LayoutParams layoutParams;
        AppMethodBeat.i(70351);
        this.qzm = true;
        if (this.qzk == 0 || this.qzj == 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            this.qzk = displayMetrics.heightPixels;
            this.qzj = displayMetrics.widthPixels;
            if (this.qzk < this.qzj) {
                this.qzk = displayMetrics.widthPixels;
                this.qzj = displayMetrics.heightPixels;
            }
            ab.i("MicroMsg.VideoPlayView", "getScreen screen_height:" + this.qzk + " screen_width:" + this.qzj);
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
                layoutParams.bottomMargin = b.b(getContext(), 0.0f);
            }
        } else {
            layoutParams3.height = this.qzj;
            layoutParams3.width = (int) (((((double) this.qzj) * 1.0d) * ((double) this.qyX)) / ((double) this.qyY));
            if (this.qzc != null) {
                layoutParams.bottomMargin = b.b(getContext(), 0.0f);
            }
        }
        if (this.qzc != null) {
            this.qzc.clm();
            ((View) this.qzc).setLayoutParams(layoutParams);
            if (this.qzc instanceof AdVideoPlayerLoadingBar) {
                this.fbD.postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(70323);
                        if (!VideoPlayView.this.klq.isPlaying()) {
                            ((AdVideoPlayerLoadingBar) VideoPlayView.this.qzc).aFQ();
                        }
                        AppMethodBeat.o(70323);
                    }
                }, 500);
            }
        }
        ab.i("MicroMsg.VideoPlayView", "orientation " + i + " " + layoutParams3.width + " " + layoutParams3.height);
        ((View) this.klq).setLayoutParams(layoutParams3);
        if (this.klq instanceof com.tencent.mm.plugin.sight.decode.a.a) {
            ((com.tencent.mm.plugin.sight.decode.a.a) this.klq).fi(layoutParams3.width, layoutParams3.height);
        }
        layoutParams2.height = layoutParams3.height;
        layoutParams2.width = layoutParams3.width;
        this.qzb.setLayoutParams(layoutParams2);
        ((View) this.klq).requestLayout();
        AppMethodBeat.o(70351);
    }

    public long getLastSurfaceUpdateTime() {
        return 0;
    }

    public void setForceScaleFullScreen(boolean z) {
    }

    public void setMute(boolean z) {
        this.eif = z;
    }

    public final void d(double d, boolean z) {
        AppMethodBeat.i(70352);
        B(d);
        AppMethodBeat.o(70352);
    }

    public void setOneTimeVideoTextureUpdateCallback(e.e eVar) {
    }

    public void setOnSeekCompleteCallback(c cVar) {
    }

    public void setOnInfoCallback(e.b bVar) {
    }

    public void setOnSurfaceCallback(d dVar) {
    }

    public final void pause() {
        AppMethodBeat.i(70336);
        CF(-1);
        AppMethodBeat.o(70336);
    }

    static /* synthetic */ void m(VideoPlayView videoPlayView) {
        AppMethodBeat.i(70357);
        if (videoPlayView.qzg.getVisibility() == 0) {
            videoPlayView.clq();
            AppMethodBeat.o(70357);
            return;
        }
        videoPlayView.clp();
        AppMethodBeat.o(70357);
    }

    static /* synthetic */ void o(VideoPlayView videoPlayView) {
        AppMethodBeat.i(70358);
        videoPlayView.CF(-1);
        AppMethodBeat.o(70358);
    }
}
