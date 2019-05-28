package com.tencent.mm.plugin.mmsight.segment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.Surface;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.mmsight.model.a.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.e;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@com.tencent.mm.ui.base.a(3)
public class VideoSegmentUI extends MMActivity {
    private CountDownLatch bXQ = new CountDownLatch(2);
    private ProgressDialog ehJ = null;
    private com.tencent.mm.remoteservice.d ext = new com.tencent.mm.remoteservice.d(this);
    private int fPW;
    private String lis = "";
    private Surface mSurface;
    private RelativeLayout mmW;
    private VideoTransPara ouc;
    private String ozB = null;
    private f ozC;
    private com.tencent.mm.plugin.mmsight.segment.a.c ozD;
    private boolean ozE = false;
    private c ozF;
    private int ozG = Downloads.MIN_WAIT_FOR_NETWORK;
    private boolean ozH = false;
    private boolean ozI = false;
    private boolean ozJ = false;
    private com.tencent.mm.plugin.mmsight.segment.c.b ozK = new com.tencent.mm.plugin.mmsight.segment.c.b() {
        public final void U(float f, float f2) {
            AppMethodBeat.i(55028);
            if (VideoSegmentUI.this.ozD == null) {
                AppMethodBeat.o(55028);
                return;
            }
            int e = VideoSegmentUI.this.fPW;
            VideoSegmentUI.this.ozD.setLoop((int) (((float) e) * f), (int) (((float) e) * f2));
            VideoSegmentUI.this.ozD.seekTo((int) (((float) e) * f));
            AppMethodBeat.o(55028);
        }

        public final void bQc() {
            AppMethodBeat.i(55029);
            if (VideoSegmentUI.this.ozD == null) {
                AppMethodBeat.o(55029);
                return;
            }
            VideoSegmentUI.this.ozD.pause();
            AppMethodBeat.o(55029);
        }

        public final void V(float f, float f2) {
            AppMethodBeat.i(55030);
            if (VideoSegmentUI.this.ozD == null) {
                AppMethodBeat.o(55030);
                return;
            }
            int e = (int) (((float) VideoSegmentUI.this.fPW) * f);
            VideoSegmentUI.this.ozD.setLoop(e, (int) (((float) VideoSegmentUI.this.fPW) * f2));
            VideoSegmentUI.this.ozD.seekTo(e);
            AppMethodBeat.o(55030);
        }

        public final void W(float f, float f2) {
            AppMethodBeat.i(55031);
            if ((f2 - f) * ((float) VideoSegmentUI.this.fPW) <= ((float) VideoSegmentUI.this.ozG)) {
                VideoSegmentUI.this.enableOptionMenu(true);
                AppMethodBeat.o(55031);
                return;
            }
            VideoSegmentUI.this.enableOptionMenu(false);
            AppMethodBeat.o(55031);
        }
    };
    private com.tencent.mm.plugin.mmsight.segment.a.c.a ozL = new com.tencent.mm.plugin.mmsight.segment.a.c.a() {
        private Runnable ozO;

        public final void yY(int i) {
            AppMethodBeat.i(55032);
            if (VideoSegmentUI.this.ozF == null) {
                AppMethodBeat.o(55032);
                return;
            }
            if (this.ozO != null) {
                ((View) VideoSegmentUI.this.ozF).removeCallbacks(this.ozO);
            }
            this.ozO = new c(VideoSegmentUI.this.ozF, i, VideoSegmentUI.this.fPW);
            ((View) VideoSegmentUI.this.ozF).post(this.ozO);
            AppMethodBeat.o(55032);
        }
    };
    private com.tencent.mm.plugin.mmsight.segment.a.a.d ozM = new com.tencent.mm.plugin.mmsight.segment.a.a.d() {
        public final void aa(int i, int i2, int i3) {
            AppMethodBeat.i(55033);
            if (i <= 0 || i2 <= 0) {
                ab.e("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged wrong size (%d, %d) invoked = %b", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(VideoSegmentUI.this.ozJ));
                AppMethodBeat.o(55033);
            } else if (VideoSegmentUI.this.ozJ) {
                ab.e("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged surface has invoked");
                AppMethodBeat.o(55033);
            } else {
                ab.i("MicroMsg.VideoSegmentUI", "VideoSegmentUI.onVideoSizeChanged (%d, %d)", Integer.valueOf(i), Integer.valueOf(i2));
                VideoSegmentUI.this.ozJ = true;
                if (i2 <= 0 || i <= 0) {
                    ab.e("MicroMsg.VideoSegmentUI", "This video has wrong size (%dx%d)", Integer.valueOf(i), Integer.valueOf(i2));
                    VideoSegmentUI.this.ozI = true;
                    VideoSegmentUI.this.finish();
                    VideoSegmentUI.b(VideoSegmentUI.this);
                    AppMethodBeat.o(55033);
                    return;
                }
                a aVar = new a(VideoSegmentUI.this, VideoSegmentUI.this.mmW, i2, i, i3, new b(VideoSegmentUI.this, (byte) 0), (byte) 0);
                if (VideoSegmentUI.this.mmW.getWidth() <= 0 || VideoSegmentUI.this.mmW.getHeight() <= 0) {
                    ab.i("MicroMsg.VideoSegmentUI", "post init surface task after root measured.");
                    VideoSegmentUI.this.mmW.post(aVar);
                    AppMethodBeat.o(55033);
                    return;
                }
                aVar.run();
                AppMethodBeat.o(55033);
            }
        }
    };
    private String thumbPath;

    class b implements SurfaceTextureListener {
        private b() {
        }

        /* synthetic */ b(VideoSegmentUI videoSegmentUI, byte b) {
            this();
        }

        public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            AppMethodBeat.i(55047);
            String str = "MicroMsg.VideoSegmentUI";
            String str2 = "TextureViewCallback create needResume[%b] segmentPlayer is null[%b]";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(VideoSegmentUI.this.ozH);
            objArr[1] = Boolean.valueOf(VideoSegmentUI.this.ozD == null);
            ab.i(str, str2, objArr);
            VideoSegmentUI.this.mSurface = new Surface(surfaceTexture);
            if (VideoSegmentUI.this.ozD == null && VideoSegmentUI.this.ozH) {
                ab.i("MicroMsg.VideoSegmentUI", "MediaPlayer resume");
                try {
                    VideoSegmentUI.a(VideoSegmentUI.this, VideoSegmentUI.this.mSurface);
                    if (!(VideoSegmentUI.this.ozF == null || VideoSegmentUI.this.ozD == null)) {
                        VideoSegmentUI.this.ozD.setLoop((int) (((float) VideoSegmentUI.this.fPW) * VideoSegmentUI.this.ozF.bQa()), (int) (((float) VideoSegmentUI.this.fPW) * VideoSegmentUI.this.ozF.bQb()));
                    }
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.VideoSegmentUI", e, "ResumeMediaPlayer error %s", e.getMessage());
                }
                VideoSegmentUI.this.ozH = false;
            }
            VideoSegmentUI.this.bXQ.countDown();
            AppMethodBeat.o(55047);
        }

        public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        }

        public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            AppMethodBeat.i(55048);
            ab.i("MicroMsg.VideoSegmentUI", "TextureViewCallback.surfaceDestroyed %s", bo.dpG());
            try {
                if (VideoSegmentUI.this.ozD != null) {
                    ab.i("MicroMsg.VideoSegmentUI", "TextureViewCallback MediaPlayer pause");
                    VideoSegmentUI.this.ozD.release();
                    VideoSegmentUI.this.ozD = null;
                    VideoSegmentUI.this.ozH = true;
                }
                VideoSegmentUI.this.mSurface = null;
            } catch (Exception e) {
            }
            AppMethodBeat.o(55048);
            return false;
        }

        public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    class a implements Runnable {
        private Context context;
        private ViewGroup lYe;
        private int ozU;
        private int ozV;
        private int ozW;
        private b ozX;

        /* synthetic */ a(VideoSegmentUI videoSegmentUI, ViewGroup viewGroup, int i, int i2, int i3, b bVar, byte b) {
            this(viewGroup, i, i2, i3, bVar);
        }

        private a(ViewGroup viewGroup, int i, int i2, int i3, b bVar) {
            AppMethodBeat.i(55045);
            this.ozU = i;
            this.ozV = i2;
            this.ozW = i3;
            this.context = viewGroup.getContext();
            this.lYe = viewGroup;
            this.ozX = bVar;
            AppMethodBeat.o(55045);
        }

        public final void run() {
            AppMethodBeat.i(55046);
            if (VideoSegmentUI.this.isFinishing()) {
                AppMethodBeat.o(55046);
                return;
            }
            float f;
            AnonymousClass1 anonymousClass1 = new MMTextureView(this.context) {
                /* Access modifiers changed, original: protected|final */
                public final void onMeasure(int i, int i2) {
                    AppMethodBeat.i(55044);
                    ab.d("MicroMsg.VideoSegmentUI", "onMeasure video size[%d, %d, %d] spec[%d, %d]", Integer.valueOf(a.this.ozV), Integer.valueOf(a.this.ozU), Integer.valueOf(a.this.ozW), Integer.valueOf(View.getDefaultSize(1, i)), Integer.valueOf(View.getDefaultSize(1, i2)));
                    if (a.this.ozW == 90 || a.this.ozW == 270) {
                        Matrix matrix = new Matrix();
                        matrix.set(getMatrix());
                        int defaultSize = View.getDefaultSize(1, i);
                        int defaultSize2 = View.getDefaultSize(1, i2);
                        float f = ((float) defaultSize) / 2.0f;
                        float f2 = ((float) defaultSize2) / 2.0f;
                        float f3 = ((float) defaultSize2) / ((float) defaultSize);
                        matrix.postRotate((float) a.this.ozW, f, f2);
                        matrix.postScale(1.0f / f3, f3, f, f2);
                        setTransform(matrix);
                        ab.i("MicroMsg.VideoSegmentUI", "rotate transform mDegrees[%d] screenSize[%d, %d]", Integer.valueOf(a.this.ozW), Integer.valueOf(defaultSize), Integer.valueOf(defaultSize2));
                    }
                    super.onMeasure(i, i2);
                    AppMethodBeat.o(55044);
                }
            };
            int width = this.lYe.getWidth();
            int al = com.tencent.mm.bz.a.al(this.context, R.dimen.aa2);
            int top = ((View) VideoSegmentUI.this.ozF).getTop() - (al * 2);
            int i = this.ozV;
            int i2 = this.ozU;
            Point point = new Point();
            if (((float) i2) / ((float) i) > ((float) top) / ((float) width)) {
                f = ((float) top) / ((float) i2);
            } else {
                f = ((float) width) / ((float) i);
            }
            point.x = (int) (((float) i) * f);
            point.y = (int) (f * ((float) i2));
            ab.i("MicroMsg.VideoSegmentUI", "rawWidth %d rawHeight %d  rawDegress %d padding %d validWidth %d validHeight %d scaled %s", Integer.valueOf(this.ozV), Integer.valueOf(this.ozU), Integer.valueOf(this.ozW), Integer.valueOf(al), Integer.valueOf(width), Integer.valueOf(top), point.toString());
            if (point.x <= 0 || point.y <= 0) {
                ab.e("MicroMsg.VideoSegmentUI", "rawWidth %d rawHeight %d padding %d validWidth %d validHeight %d scaled %s", Integer.valueOf(this.ozV), Integer.valueOf(this.ozU), Integer.valueOf(al), Integer.valueOf(width), Integer.valueOf(top), point.toString());
                if (this.ozX != null) {
                    b bVar = this.ozX;
                    ab.e("MicroMsg.VideoSegmentUI", "TextureViewCallback error");
                    VideoSegmentUI.this.ozI = true;
                    VideoSegmentUI.this.finish();
                    VideoSegmentUI.b(VideoSegmentUI.this);
                }
                AppMethodBeat.o(55046);
                return;
            }
            LayoutParams layoutParams = new LayoutParams(point.x, point.y);
            al += (int) (((float) (top - point.y)) / 2.0f);
            layoutParams.topMargin = al;
            layoutParams.bottomMargin = al;
            width = (int) (((float) (width - point.x)) / 2.0f);
            layoutParams.leftMargin = width;
            layoutParams.rightMargin = width;
            anonymousClass1.setSurfaceTextureListener(this.ozX);
            this.lYe.addView(anonymousClass1, 0, layoutParams);
            AppMethodBeat.o(55046);
        }
    }

    static class c implements Runnable {
        private WeakReference<c> aIp;
        private int fPW;
        private int ozZ;

        public c(c cVar, int i, int i2) {
            AppMethodBeat.i(55049);
            this.aIp = new WeakReference(cVar);
            this.ozZ = i;
            this.fPW = i2;
            AppMethodBeat.o(55049);
        }

        public final void run() {
            AppMethodBeat.i(55050);
            c cVar = (c) this.aIp.get();
            if (cVar == null) {
                AppMethodBeat.o(55050);
                return;
            }
            cVar.setCurrentCursorPosition(((float) this.ozZ) / ((float) this.fPW));
            AppMethodBeat.o(55050);
        }
    }

    class d implements Runnable {
        private d() {
        }

        /* synthetic */ d(VideoSegmentUI videoSegmentUI, byte b) {
            this();
        }

        public final void run() {
            boolean await;
            AppMethodBeat.i(55052);
            try {
                await = VideoSegmentUI.this.bXQ.await(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                ab.e("MicroMsg.VideoSegmentUI", "count down latch error %s", e);
                await = false;
            }
            if (await) {
                try {
                    if (!(VideoSegmentUI.this.ozI || VideoSegmentUI.this.isFinishing() || VideoSegmentUI.this.mSurface == null || !VideoSegmentUI.this.mSurface.isValid())) {
                        if (VideoSegmentUI.this.ozD != null) {
                            VideoSegmentUI.this.ozD.a(null);
                            VideoSegmentUI.this.ozD.a(null);
                            VideoSegmentUI.this.ozD.release();
                            VideoSegmentUI.this.ozD = null;
                        }
                        try {
                            VideoSegmentUI.a(VideoSegmentUI.this, VideoSegmentUI.this.mSurface);
                            VideoSegmentUI.this.ozD.setSurface(VideoSegmentUI.this.mSurface);
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(55051);
                                    if (VideoSegmentUI.this.ozI || VideoSegmentUI.this.isFinishing() || VideoSegmentUI.this.ozF == null || VideoSegmentUI.this.ozD == null) {
                                        ab.i("MicroMsg.VideoSegmentUI", "waiting end, main thread, activity not valid.");
                                        AppMethodBeat.o(55051);
                                        return;
                                    }
                                    ((View) VideoSegmentUI.this.ozF).setAlpha(0.0f);
                                    ((View) VideoSegmentUI.this.ozF).setVisibility(0);
                                    ((View) VideoSegmentUI.this.ozF).animate().setDuration(300).setStartDelay(200).alpha(1.0f);
                                    float bQa = VideoSegmentUI.this.ozF.bQa();
                                    float bQb = VideoSegmentUI.this.ozF.bQb();
                                    if ((bQb - bQa) * ((float) VideoSegmentUI.this.fPW) <= ((float) VideoSegmentUI.this.ozG)) {
                                        VideoSegmentUI.this.enableOptionMenu(true);
                                    }
                                    VideoSegmentUI.this.ozD.setLoop((int) (bQa * ((float) VideoSegmentUI.this.fPW)), (int) (bQb * ((float) VideoSegmentUI.this.fPW)));
                                    AppMethodBeat.o(55051);
                                }
                            });
                            AppMethodBeat.o(55052);
                            return;
                        } catch (IOException e2) {
                            ab.printErrStackTrace("MicroMsg.VideoSegmentUI", e2, "init segmentPlayer second time %s", e2.getMessage());
                            VideoSegmentUI.this.finish();
                            AppMethodBeat.o(55052);
                            return;
                        }
                    }
                } catch (Exception e3) {
                    ab.printErrStackTrace("MicroMsg.VideoSegmentUI", e3, "Finished when init", new Object[0]);
                    VideoSegmentUI.this.finish();
                    AppMethodBeat.o(55052);
                    return;
                }
            }
            String str = "MicroMsg.VideoSegmentUI";
            String str2 = "Waiting Prepared error result[%b] needFinish[%b] isFinishing[%b] mSurface is null[%b]";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(await);
            objArr[1] = Boolean.valueOf(VideoSegmentUI.this.ozI);
            objArr[2] = Boolean.valueOf(VideoSegmentUI.this.isFinishing());
            objArr[3] = Boolean.valueOf(VideoSegmentUI.this.mSurface == null);
            ab.w(str, str2, objArr);
            VideoSegmentUI.this.finish();
            AppMethodBeat.o(55052);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public VideoSegmentUI() {
        AppMethodBeat.i(55053);
        AppMethodBeat.o(55053);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(55054);
        super.onCreate(bundle);
        getWindow().addFlags(128);
        CaptureMMProxy.createProxy(new CaptureMMProxy(this.ext));
        this.ext.connect(new Runnable() {
            public final void run() {
                AppMethodBeat.i(55027);
                ab.i("MicroMsg.VideoSegmentUI", "has connect");
                if (CaptureMMProxy.getInstance() != null) {
                    q.ku(CaptureMMProxy.getInstance().getDeviceInfoConfig());
                }
                VideoSegmentUI.a(VideoSegmentUI.this);
                AppMethodBeat.o(55027);
            }
        });
        AppMethodBeat.o(55054);
    }

    public final void initView() {
        AppMethodBeat.i(55055);
        this.ozF = (c) findViewById(R.id.f17);
        this.mmW = (RelativeLayout) findViewById(R.id.l_);
        AppMethodBeat.o(55055);
    }

    private void a(boolean z, Surface surface) {
        AppMethodBeat.i(55056);
        if (this.ozD != null) {
            ab.e("MicroMsg.VideoSegmentUI", "initSegmentPlayer not null, you can not init segmentPlayer");
            AppMethodBeat.o(55056);
            return;
        }
        this.ozD = new com.tencent.mm.plugin.mmsight.segment.a.c();
        this.ozE = false;
        this.ozD.setDataSource(this.ozB);
        this.ozD.a(new com.tencent.mm.plugin.mmsight.segment.a.a.a() {
            public final boolean ey(int i, int i2) {
                AppMethodBeat.i(55040);
                ab.e("MicroMsg.VideoSegmentUI", "MediaPlayer on error what = %d extra = %d", Integer.valueOf(i), Integer.valueOf(i2));
                VideoSegmentUI.this.ozI = true;
                VideoSegmentUI.this.finish();
                VideoSegmentUI.b(VideoSegmentUI.this);
                AppMethodBeat.o(55040);
                return true;
            }
        });
        if (z) {
            this.ozD.a(this.ozM);
        }
        this.ozD.setAudioStreamType(3);
        this.ozD.setLooping(true);
        if (surface != null) {
            this.ozD.setSurface(surface);
        }
        this.ozD.ozL = this.ozL;
        this.ozD.a(new com.tencent.mm.plugin.mmsight.segment.a.a.b() {
            public final void ce(Object obj) {
                AppMethodBeat.i(55041);
                ab.i("MicroMsg.VideoSegmentUI", "MediaPlayer.onPrepared start %s", obj);
                try {
                    if (VideoSegmentUI.this.ozD != null) {
                        VideoSegmentUI.this.ozE = true;
                        VideoSegmentUI.this.ozD.start();
                    }
                    AppMethodBeat.o(55041);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.VideoSegmentUI", e, "hy: exception when onPrepared waiting for starting", new Object[0]);
                    AppMethodBeat.o(55041);
                }
            }
        });
        this.ozD.prepareAsync();
        this.ozD.a(new com.tencent.mm.plugin.mmsight.segment.a.a.c() {
            public final void cf(Object obj) {
                AppMethodBeat.i(55042);
                try {
                    if (VideoSegmentUI.this.ozD != null) {
                        VideoSegmentUI.this.ozD.start();
                    }
                    AppMethodBeat.o(55042);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.VideoSegmentUI", e, "hy: exception when onSeekComplete waiting for starting", new Object[0]);
                    AppMethodBeat.o(55042);
                }
            }
        });
        AppMethodBeat.o(55056);
    }

    public void onResume() {
        AppMethodBeat.i(55057);
        if (this.ozD != null && this.ozE) {
            ab.i("MicroMsg.VideoSegmentUI", "onResume start player");
            this.ozD.start();
        }
        super.onResume();
        AppMethodBeat.o(55057);
    }

    public void onPause() {
        AppMethodBeat.i(55058);
        if (this.ozD != null) {
            ab.i("MicroMsg.VideoSegmentUI", "onPause pause player");
            this.ozD.pause();
        }
        super.onPause();
        AppMethodBeat.o(55058);
    }

    public void onDestroy() {
        AppMethodBeat.i(55059);
        ab.i("MicroMsg.VideoSegmentUI", "onDestroy");
        super.onDestroy();
        getWindow().clearFlags(128);
        this.ext.release();
        if (this.ozF != null) {
            this.ozF.release();
        }
        if (this.ozD != null) {
            this.ozD.release();
        }
        if (this.mSurface != null) {
            this.mSurface.release();
        }
        if (this.ozC != null) {
            this.ozC.release();
        }
        j.owk.WY();
        AppMethodBeat.o(55059);
    }

    public final int getLayoutId() {
        return R.layout.b1l;
    }

    static /* synthetic */ void a(VideoSegmentUI videoSegmentUI) {
        boolean z = false;
        AppMethodBeat.i(55060);
        videoSegmentUI.setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(55034);
                VideoSegmentUI.this.finish();
                VideoSegmentUI.b(VideoSegmentUI.this);
                AppMethodBeat.o(55034);
                return true;
            }
        });
        videoSegmentUI.setMMTitle((int) R.string.b8i);
        videoSegmentUI.a(0, com.tencent.mm.bz.a.an(videoSegmentUI.mController.ylL, R.string.qt), (OnMenuItemClickListener) new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(55035);
                VideoSegmentUI.c(VideoSegmentUI.this);
                AppMethodBeat.o(55035);
                return true;
            }
        }, com.tencent.mm.ui.q.b.GREEN);
        videoSegmentUI.enableOptionMenu(false);
        Intent intent = videoSegmentUI.getIntent();
        if (intent == null || bo.isNullOrNil(intent.getStringExtra("key_video_path"))) {
            String str = "MicroMsg.VideoSegmentUI";
            String str2 = "is Intent null ? %b, is path null ? %b";
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(intent == null);
            if (intent == null || intent.getStringExtra("key_video_path") == null) {
                z = true;
            }
            objArr[1] = Boolean.valueOf(z);
            ab.e(str, str2, objArr);
            videoSegmentUI.finish();
            AppMethodBeat.o(55060);
            return;
        }
        videoSegmentUI.ozB = intent.getStringExtra("key_video_path");
        ab.i("MicroMsg.VideoSegmentUI", "selectVideoPath: %s", videoSegmentUI.ozB);
        if (videoSegmentUI.ozB == null || videoSegmentUI.ozB.length() == 0) {
            ab.e("MicroMsg.VideoSegmentUI", "Please pick a video first");
            AppMethodBeat.o(55060);
            return;
        }
        videoSegmentUI.initView();
        try {
            videoSegmentUI.a(true, null);
            videoSegmentUI.ozF.setOnPreparedListener(new com.tencent.mm.plugin.mmsight.segment.c.a() {
                public final void iY(boolean z) {
                    AppMethodBeat.i(55043);
                    if (z) {
                        Toast.makeText(VideoSegmentUI.this, R.string.d01, 1).show();
                        ab.e("MicroMsg.VideoSegmentUI", "Not Supported init SegmentSeekBar failed.");
                        VideoSegmentUI.this.ozI = true;
                        VideoSegmentUI.this.finish();
                        VideoSegmentUI.b(VideoSegmentUI.this);
                        AppMethodBeat.o(55043);
                        return;
                    }
                    if (!(VideoSegmentUI.this.isFinishing() || VideoSegmentUI.this.ozF == null)) {
                        VideoSegmentUI.this.fPW = VideoSegmentUI.this.ozF.getDurationMs();
                        ab.i("MicroMsg.VideoSegmentUI", "SeekBar.onPrepared success %d", Integer.valueOf(VideoSegmentUI.this.fPW));
                        try {
                            if (VideoSegmentUI.this.ozD != null) {
                                VideoSegmentUI.this.ozD.setLoop((int) (((float) VideoSegmentUI.this.fPW) * VideoSegmentUI.this.ozF.bQa()), (int) (((float) VideoSegmentUI.this.fPW) * VideoSegmentUI.this.ozF.bQb()));
                            }
                        } catch (Exception e) {
                        }
                    }
                    VideoSegmentUI.this.bXQ.countDown();
                    AppMethodBeat.o(55043);
                }
            });
            videoSegmentUI.ozF.setThumbBarSeekListener(videoSegmentUI.ozK);
            videoSegmentUI.ozF.RO(videoSegmentUI.ozB);
            videoSegmentUI.ozC = new q();
            com.tencent.mm.sdk.g.d.g(new d(videoSegmentUI, (byte) 0), "waiting_for_component_prepared.");
            AppMethodBeat.o(55060);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.VideoSegmentUI", e, "MediaPlayer set data source error : [%s]", e.getMessage());
            videoSegmentUI.finish();
            AppMethodBeat.o(55060);
        }
    }

    static /* synthetic */ void b(VideoSegmentUI videoSegmentUI) {
        AppMethodBeat.i(55061);
        int i = 0;
        while (true) {
            try {
                if (((long) i) < videoSegmentUI.bXQ.getCount()) {
                    videoSegmentUI.bXQ.countDown();
                    i++;
                } else {
                    AppMethodBeat.o(55061);
                    return;
                }
            } catch (Exception e) {
                ab.e("MicroMsg.VideoSegmentUI", "ensureNotWaiting e : %s", e);
                AppMethodBeat.o(55061);
                return;
            }
        }
    }

    static /* synthetic */ void c(VideoSegmentUI videoSegmentUI) {
        AppMethodBeat.i(55062);
        String accVideoPath = CaptureMMProxy.getInstance().getAccVideoPath();
        long currentTimeMillis = System.currentTimeMillis();
        final String str = "vsg_output_" + currentTimeMillis + VideoMaterialUtil.MP4_SUFFIX;
        final String str2 = "vsg_thumb_" + currentTimeMillis + FileUtils.PIC_POSTFIX_JPEG;
        videoSegmentUI.lis = accVideoPath + str;
        videoSegmentUI.thumbPath = accVideoPath + str2;
        com.tencent.mm.sdk.g.d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(55039);
                List<com.tencent.mm.vfs.FileSystem.a> cl = e.cl(CaptureMMProxy.getInstance().getAccVideoPath(), false);
                if (cl == null) {
                    AppMethodBeat.o(55039);
                    return;
                }
                for (com.tencent.mm.vfs.FileSystem.a aVar : cl) {
                    if (aVar.name != null && ((aVar.name.startsWith("vsg_output_") && !aVar.name.equals(str)) || (aVar.name.startsWith("vsg_thumb_") && !aVar.name.equals(str2)))) {
                        aVar.delete();
                    }
                }
                AppMethodBeat.o(55039);
            }
        }, "delete_old_temp_video_file");
        if (bo.isNullOrNil(videoSegmentUI.lis) || bo.isNullOrNil(videoSegmentUI.thumbPath)) {
            ab.e("MicroMsg.VideoSegmentUI", "Create output file failed.");
            AppMethodBeat.o(55062);
            return;
        }
        videoSegmentUI.ouc = CaptureMMProxy.getInstance().getSnsAlbumVideoTransPara();
        if (videoSegmentUI.ouc == null) {
            ab.e("MicroMsg.VideoSegmentUI", "VideoTransPara not provided.");
            AppMethodBeat.o(55062);
        } else if (videoSegmentUI.ozB == null) {
            ab.e("MicroMsg.VideoSegmentUI", "Please pick a video first");
            AppMethodBeat.o(55062);
        } else if (videoSegmentUI.bXQ.getCount() != 0) {
            ab.e("MicroMsg.VideoSegmentUI", "Not prepared right now, please try again.");
            AppMethodBeat.o(55062);
        } else {
            ab.i("MicroMsg.VideoSegmentUI", "Start to process video");
            videoSegmentUI.getString(R.string.tz);
            videoSegmentUI.ehJ = h.b((Context) videoSegmentUI, videoSegmentUI.getString(R.string.un), false, null);
            videoSegmentUI.ozF.iX(true);
            com.tencent.mm.sdk.g.d.post(new Runnable() {
                public final void run() {
                    boolean z = true;
                    AppMethodBeat.i(55038);
                    String str = null;
                    try {
                        VideoSegmentUI.this.ozD.stop();
                        int e = VideoSegmentUI.this.fPW;
                        long yz = bo.yz();
                        VideoSegmentUI.this.ozC.b(VideoSegmentUI.this.ozB, VideoSegmentUI.this.lis, VideoSegmentUI.this.ouc);
                        if (VideoSegmentUI.this.ozC.O((long) (VideoSegmentUI.this.ozF.bQa() * ((float) e)), (long) (((float) e) * VideoSegmentUI.this.ozF.bQb())) < 0) {
                            ab.i("MicroMsg.VideoSegmentUI", "clip failed! %s", Integer.valueOf(VideoSegmentUI.this.ozC.O((long) (VideoSegmentUI.this.ozF.bQa() * ((float) e)), (long) (((float) e) * VideoSegmentUI.this.ozF.bQb()))));
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(55036);
                                    if (VideoSegmentUI.this.ehJ != null) {
                                        VideoSegmentUI.this.ehJ.dismiss();
                                    }
                                    if (VideoSegmentUI.this.ozF != null) {
                                        VideoSegmentUI.this.ozF.iX(false);
                                    }
                                    Toast.makeText(VideoSegmentUI.this, R.string.d01, 1).show();
                                    AppMethodBeat.o(55036);
                                }
                            });
                            AppMethodBeat.o(55038);
                            return;
                        }
                        Bitmap tv = com.tencent.mm.plugin.mmsight.d.tv(VideoSegmentUI.this.lis);
                        if (tv != null) {
                            PInt pInt = new PInt();
                            PInt pInt2 = new PInt();
                            if (com.tencent.mm.plugin.mmsight.d.a(tv.getWidth(), tv.getHeight(), VideoSegmentUI.this.ouc.fAf, pInt, pInt2)) {
                                tv = Bitmap.createScaledBitmap(tv, pInt.value, pInt2.value, true);
                            }
                            ab.i("MicroMsg.VideoSegmentUI", "getBitmap size = [%d, %d]", Integer.valueOf(tv.getWidth()), Integer.valueOf(tv.getHeight()));
                            com.tencent.mm.sdk.platformtools.d.a(tv, 80, CompressFormat.JPEG, VideoSegmentUI.this.thumbPath, true);
                            ab.i("MicroMsg.VideoSegmentUI", "create video thumb. use %dms", Long.valueOf(bo.az(yz)));
                        } else {
                            ab.e("MicroMsg.VideoSegmentUI", "getVideoThumb failed!");
                        }
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(55037);
                                if (VideoSegmentUI.this.ehJ != null) {
                                    VideoSegmentUI.this.ehJ.dismiss();
                                }
                                if (VideoSegmentUI.this.ozF != null) {
                                    VideoSegmentUI.this.ozF.iX(false);
                                }
                                VideoSegmentUI.a(VideoSegmentUI.this, z, str);
                                AppMethodBeat.o(55037);
                            }
                        });
                        AppMethodBeat.o(55038);
                    } catch (Exception e2) {
                        Exception exception = e2;
                        str = exception.getMessage();
                        ab.printErrStackTrace("MicroMsg.VideoSegmentUI", exception, "UnexpectedException when clip : [%s]", exception.getMessage());
                        z = false;
                    }
                }
            }, "clip_video");
            AppMethodBeat.o(55062);
        }
    }

    static /* synthetic */ void a(VideoSegmentUI videoSegmentUI, boolean z, String str) {
        AppMethodBeat.i(55063);
        if (z) {
            Intent intent = new Intent();
            intent.putExtra("K_SEGMENTVIDEOPATH", videoSegmentUI.lis);
            intent.putExtra("KSEGMENTVIDEOTHUMBPATH", videoSegmentUI.thumbPath);
            videoSegmentUI.setResult(-1, intent);
            videoSegmentUI.finish();
            AppMethodBeat.o(55063);
            return;
        }
        ab.e("MicroMsg.VideoSegmentUI", "Clip not success. %s", str);
        AppMethodBeat.o(55063);
    }
}
