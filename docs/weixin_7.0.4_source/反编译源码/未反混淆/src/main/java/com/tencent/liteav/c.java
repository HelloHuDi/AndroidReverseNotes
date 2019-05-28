package com.tencent.liteav;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.liteav.a.b;
import com.tencent.liteav.audio.TXCLiveBGMPlayer;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.d;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.e.l;
import com.tencent.liteav.basic.e.n;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.e;
import com.tencent.liteav.renderer.TXCGLSurfaceView;
import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import com.tencent.rtmp.TXLog;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ttpic.util.ActUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;

public class c extends com.tencent.liteav.basic.module.a implements b, d, com.tencent.liteav.basic.d.a, e, l, com.tencent.liteav.videoencoder.d {
    private static final String d = c.class.getSimpleName();
    private WeakReference<com.tencent.liteav.basic.d.a> A;
    private WeakReference<m> B;
    private boolean C = false;
    private int D = -1;
    private int E = -1;
    a a;
    com.tencent.liteav.audio.e b = null;
    OnBGMNotify c = null;
    private k e = null;
    private com.tencent.liteav.beauty.c f = null;
    private int g = -1;
    private TXSVideoEncoderParam h = null;
    private com.tencent.liteav.videoencoder.b i = null;
    private Context j = null;
    private f k = null;
    private int l = 0;
    private int m = 0;
    private int n = 0;
    private float o = 1.0f;
    private int p = 0;
    private float q = 0.0f;
    private TXCloudVideoView r = null;
    private Surface s = null;
    private int t = 0;
    private int u = 0;
    private com.tencent.liteav.basic.e.d v = null;
    private int w = 0;
    private com.tencent.liteav.basic.g.c x;
    private long y = 0;
    private a z = null;

    public interface a {
        void onEncAudio(byte[] bArr, long j, int i, int i2);

        void onEncVideo(com.tencent.liteav.basic.g.b bVar);

        void onEncVideoFormat(MediaFormat mediaFormat);

        void onRecordPcm(byte[] bArr, long j, int i, int i2, int i3);

        void onRecordRawPcm(byte[] bArr, long j, int i, int i2, int i3, boolean z);
    }

    static {
        AppMethodBeat.i(66474);
        AppMethodBeat.o(66474);
    }

    public c(Context context) {
        AppMethodBeat.i(66387);
        this.j = context.getApplicationContext();
        this.k = new f();
        this.f = new com.tencent.liteav.beauty.c(this.j, true);
        this.f.a((e) this);
        this.f.a((com.tencent.liteav.basic.d.a) this);
        this.h = new TXSVideoEncoderParam();
        this.i = null;
        this.a = new a(this);
        com.tencent.liteav.basic.f.b.a().a(this.j);
        AppMethodBeat.o(66387);
    }

    public void a(a aVar) {
        this.z = aVar;
    }

    public void a(f fVar) {
        Object obj = null;
        AppMethodBeat.i(66388);
        int i = this.k.k;
        Object obj2 = (fVar == null || (this.k.t == fVar.t && this.k.u == fVar.u && this.k.v == fVar.v)) ? null : 1;
        if (!(fVar == null || (this.k.x == fVar.x && this.k.y == fVar.y && this.k.z == fVar.z && this.k.C == fVar.C && this.k.A == fVar.A && this.k.B == fVar.B))) {
            obj = 1;
        }
        if (fVar != null) {
            try {
                this.k = (f) fVar.clone();
            } catch (CloneNotSupportedException e) {
                this.k = new f();
            }
        } else {
            this.k = new f();
        }
        k(i);
        if (i()) {
            u();
            x();
            if (this.e != null) {
                this.e.c(this.k.l);
            }
            if (obj2 != null) {
                v();
            }
            if (obj != null) {
                w();
            }
        }
        AppMethodBeat.o(66388);
    }

    public void a(com.tencent.liteav.basic.d.a aVar) {
        AppMethodBeat.i(66389);
        this.A = new WeakReference(aVar);
        AppMethodBeat.o(66389);
    }

    public void a(byte[] bArr) {
        AppMethodBeat.i(66390);
        com.tencent.liteav.audio.b.a().a(bArr);
        AppMethodBeat.o(66390);
    }

    public void a(m mVar) {
        AppMethodBeat.i(66391);
        this.B = new WeakReference(mVar);
        AppMethodBeat.o(66391);
    }

    public int b() {
        return this.h.width;
    }

    public int c() {
        return this.h.height;
    }

    public void setID(String str) {
        AppMethodBeat.i(66392);
        super.setID(str);
        if (this.i != null) {
            this.i.setID(str);
        }
        if (this.f != null) {
            this.f.setID(str);
        }
        AppMethodBeat.o(66392);
    }

    public String d() {
        AppMethodBeat.i(66393);
        String str = com.tencent.liteav.audio.b.a().f() + " | " + com.tencent.liteav.audio.b.a().e() + "," + com.tencent.liteav.audio.b.a().d();
        AppMethodBeat.o(66393);
        return str;
    }

    public int e() {
        AppMethodBeat.i(66394);
        if (i()) {
            TXCLog.w(d, "ignore startPush when pushing, status:" + this.m);
            AppMethodBeat.o(66394);
            return -2;
        }
        TXCDRApi.initCrashReport(this.j);
        this.m = 1;
        TXCLog.d(d, "startPusher");
        u();
        com.tencent.liteav.audio.b.a().a((d) this);
        if ((this.k != null && this.k.F) || this.l == 1 || this.e == null || this.e.d()) {
            com.tencent.liteav.audio.b.a().a(this.j);
        } else if (this.e != null) {
            this.e.e(true);
        }
        x();
        TXCDRApi.txReportDAU(this.j, com.tencent.liteav.basic.datareport.a.bw);
        AppMethodBeat.o(66394);
        return 0;
    }

    public void f() {
        AppMethodBeat.i(66395);
        if (i()) {
            TXCLog.d(d, "stopPusher");
            this.m = 0;
            com.tencent.liteav.audio.b.a().b();
            com.tencent.liteav.audio.b.a().a(null);
            s();
            this.q = 0.0f;
            this.k.I = false;
            if (this.a != null) {
                this.a.a();
            }
            this.x = null;
            AppMethodBeat.o(66395);
            return;
        }
        TXCLog.w(d, "ignore stopPush when not pushing, status:" + this.m);
        AppMethodBeat.o(66395);
    }

    public void g() {
        AppMethodBeat.i(66396);
        if (this.m != 1) {
            TXCLog.w(d, "ignore pause push when is not pushing, status:" + this.m);
            AppMethodBeat.o(66396);
            return;
        }
        this.m = 2;
        TXCLog.d(d, "pausePusher");
        if ((this.k.w & 1) == 1) {
            if (!(this.a == null || this.k.F || this.e == null)) {
                this.a.a(this.k.v, this.k.u, this.k.t, this.h.width, this.h.height);
            }
            if (this.e != null) {
                this.e.c();
            }
        }
        if ((this.k.w & 2) == 2) {
            com.tencent.liteav.audio.b.a().c(true);
        }
        AppMethodBeat.o(66396);
    }

    public void h() {
        AppMethodBeat.i(66397);
        if (this.m != 2) {
            TXCLog.w(d, "ignore resume push when is not pause, status:" + this.m);
            AppMethodBeat.o(66397);
            return;
        }
        this.m = 1;
        TXCLog.d(d, "resumePusher");
        if ((this.k.w & 1) == 1) {
            if (!(this.a == null || this.k.F)) {
                this.a.a();
            }
            if (this.e != null) {
                this.e.b();
            }
            w();
        }
        if ((this.k.w & 2) == 2) {
            com.tencent.liteav.audio.b.a().c(this.C);
            if ((this.k.K & 1) == 0) {
                com.tencent.liteav.audio.b.a().b();
                com.tencent.liteav.audio.b.a().a(this.k.q);
                com.tencent.liteav.audio.b.a().a(this.k.s, this.j);
                com.tencent.liteav.audio.b.a().d(this.p);
                com.tencent.liteav.audio.b.a().a(this.D, this.E);
                com.tencent.liteav.audio.b.a().a(this.o);
                com.tencent.liteav.audio.b.a().c(this.C);
                com.tencent.liteav.audio.b.a().a((d) this);
                com.tencent.liteav.audio.b.a().a(this.j);
            }
        }
        AppMethodBeat.o(66397);
    }

    public void a(final int i, final int i2, final int i3) {
        AppMethodBeat.i(66398);
        if (this.e == null) {
            AppMethodBeat.o(66398);
            return;
        }
        this.e.a(new Runnable() {
            public void run() {
                AppMethodBeat.i(66385);
                if (!(i2 == 0 || i3 == 0)) {
                    c.this.k.a = i2;
                    c.this.k.b = i3;
                    if (c.this.e != null) {
                        c.this.e.a(i2, i3);
                    }
                }
                if (!(i == 0 || c.this.i == null)) {
                    c.this.k.c = i;
                    c.this.i.a(i);
                }
                AppMethodBeat.o(66385);
            }
        });
        AppMethodBeat.o(66398);
    }

    public boolean i() {
        return this.m != 0;
    }

    public void j() {
        AppMethodBeat.i(66399);
        if (this.e == null) {
            AppMethodBeat.o(66399);
            return;
        }
        this.e.a(new Runnable() {
            public void run() {
                AppMethodBeat.i(67446);
                if (c.this.e != null) {
                    c.this.e.b(true);
                }
                c.a(c.this, c.this.h.width, c.this.h.height);
                AppMethodBeat.o(67446);
            }
        });
        AppMethodBeat.o(66399);
    }

    public void a(TXCloudVideoView tXCloudVideoView) {
        AppMethodBeat.i(66400);
        if (this.k.F) {
            TXCLog.e(d, "enable pure audio push , so can not start preview!");
            AppMethodBeat.o(66400);
            return;
        }
        l gLSurfaceView;
        if (tXCloudVideoView != null) {
            gLSurfaceView = tXCloudVideoView.getGLSurfaceView();
            if (gLSurfaceView == null) {
                gLSurfaceView = new TXCGLSurfaceView(tXCloudVideoView.getContext());
                tXCloudVideoView.addVideoView((TXCGLSurfaceView) gLSurfaceView);
            }
        } else {
            gLSurfaceView = new com.tencent.liteav.basic.e.e();
        }
        this.l = 0;
        this.e = new b(this.j, this.k, gLSurfaceView);
        this.e.a((l) this);
        this.e.a((com.tencent.liteav.basic.d.a) this);
        this.e.a();
        this.e.b(this.n);
        this.r = tXCloudVideoView;
        if (this.r != null) {
            this.r.start(this.k.D, this.k.E, this.e);
        }
        AppMethodBeat.o(66400);
    }

    public void a(boolean z) {
        AppMethodBeat.i(66401);
        if (this.e == null) {
            AppMethodBeat.o(66401);
            return;
        }
        this.e.a(z);
        this.e = null;
        if (this.r != null) {
            this.r.stop(z);
            this.r = null;
        }
        this.s = null;
        if (this.v != null) {
            this.v.a();
            this.v = null;
        }
        AppMethodBeat.o(66401);
    }

    public void a(Surface surface) {
        AppMethodBeat.i(66402);
        if (this.r != null) {
            TXCLog.w(d, "camera preview view is not null, can't set surface");
            AppMethodBeat.o(66402);
            return;
        }
        this.s = surface;
        AppMethodBeat.o(66402);
    }

    public void a(final int i, final int i2) {
        AppMethodBeat.i(66403);
        if (this.v != null) {
            this.v.a(new Runnable() {
                public void run() {
                    AppMethodBeat.i(66384);
                    c.this.t = i;
                    c.this.u = i2;
                    if (!(c.this.x == null || c.this.v == null)) {
                        c.a(c.this, c.this.x, true);
                    }
                    AppMethodBeat.o(66384);
                }
            });
            AppMethodBeat.o(66403);
            return;
        }
        this.t = i;
        this.u = i2;
        AppMethodBeat.o(66403);
    }

    public void a(final n nVar) {
        AppMethodBeat.i(66404);
        if (this.r != null) {
            TXCGLSurfaceView gLSurfaceView = this.r.getGLSurfaceView();
            if (gLSurfaceView != null) {
                gLSurfaceView.a(new n() {
                    public void onTakePhotoComplete(Bitmap bitmap) {
                        AppMethodBeat.i(66386);
                        if (nVar != null) {
                            nVar.onTakePhotoComplete(bitmap);
                        }
                        AppMethodBeat.o(66386);
                    }
                });
            }
            AppMethodBeat.o(66404);
            return;
        }
        if (this.v != null) {
            this.v.a(new n() {
                public void onTakePhotoComplete(Bitmap bitmap) {
                    AppMethodBeat.i(67151);
                    if (nVar != null) {
                        nVar.onTakePhotoComplete(bitmap);
                    }
                    AppMethodBeat.o(67151);
                }
            });
        }
        AppMethodBeat.o(66404);
    }

    public void k() {
        AppMethodBeat.i(66405);
        if (VERSION.SDK_INT < 21) {
            Bundle bundle = new Bundle();
            bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "录屏失败,不支持的Android系统版本,需要5.0以上的系统");
            onNotifyEvent(TXLiveConstants.PUSH_ERR_SCREEN_CAPTURE_UNSURPORT, bundle);
            TXLog.e(d, "Screen capture need running on Android Lollipop or higher version, current:" + VERSION.SDK_INT);
            AppMethodBeat.o(66405);
            return;
        }
        this.l = 1;
        this.e = new i(this.j, this.k);
        this.e.a((com.tencent.liteav.basic.d.a) this);
        this.e.a((l) this);
        this.e.a();
        TXCDRApi.txReportDAU(this.j, com.tencent.liteav.basic.datareport.a.aL);
        AppMethodBeat.o(66405);
    }

    public void l() {
        AppMethodBeat.i(66406);
        if (this.e == null) {
            AppMethodBeat.o(66406);
            return;
        }
        s();
        this.e.a(false);
        this.e = null;
        AppMethodBeat.o(66406);
    }

    public void a(int i) {
        AppMethodBeat.i(66407);
        this.n = i;
        if (this.e == null) {
            AppMethodBeat.o(66407);
            return;
        }
        this.e.b(i);
        AppMethodBeat.o(66407);
    }

    public boolean b(boolean z) {
        AppMethodBeat.i(66408);
        if (this.e == null) {
            AppMethodBeat.o(66408);
            return false;
        }
        boolean d = this.e.d(z);
        AppMethodBeat.o(66408);
        return d;
    }

    public boolean b(int i, int i2, int i3) {
        AppMethodBeat.i(66409);
        if (this.f != null) {
            this.f.c(i);
            this.f.d(i2);
            this.f.e(i3);
        }
        AppMethodBeat.o(66409);
        return true;
    }

    public void b(int i) {
        AppMethodBeat.i(66410);
        if (this.f != null) {
            this.f.b(i);
        }
        AppMethodBeat.o(66410);
    }

    public void a(Bitmap bitmap) {
        AppMethodBeat.i(66411);
        if (this.f != null) {
            this.f.a(bitmap);
        }
        AppMethodBeat.o(66411);
    }

    public void a(String str) {
        AppMethodBeat.i(66412);
        if (this.f != null) {
            this.f.a(str);
        }
        AppMethodBeat.o(66412);
    }

    public void c(boolean z) {
        AppMethodBeat.i(66413);
        if (this.f != null) {
            this.f.b(z);
        }
        AppMethodBeat.o(66413);
    }

    @TargetApi(18)
    public boolean b(String str) {
        AppMethodBeat.i(66414);
        if (this.f != null) {
            boolean a = this.f.a(str, true);
            AppMethodBeat.o(66414);
            return a;
        }
        AppMethodBeat.o(66414);
        return false;
    }

    public void c(int i) {
        AppMethodBeat.i(66415);
        if (this.f != null) {
            this.f.g(i);
        }
        AppMethodBeat.o(66415);
    }

    public void d(int i) {
        AppMethodBeat.i(66416);
        if (this.f != null) {
            this.f.h(i);
        }
        AppMethodBeat.o(66416);
    }

    public void a(float f) {
        AppMethodBeat.i(66417);
        if (this.f != null) {
            this.f.a(f);
        }
        AppMethodBeat.o(66417);
    }

    public void e(int i) {
        AppMethodBeat.i(66418);
        if (this.f != null) {
            this.f.i(i);
        }
        AppMethodBeat.o(66418);
    }

    public void f(int i) {
        AppMethodBeat.i(66419);
        if (this.f != null) {
            this.f.j(i);
        }
        AppMethodBeat.o(66419);
    }

    public void g(int i) {
        AppMethodBeat.i(66420);
        if (this.f != null) {
            this.f.k(i);
        }
        AppMethodBeat.o(66420);
    }

    public void h(int i) {
        AppMethodBeat.i(66421);
        if (this.f != null) {
            this.f.l(i);
        }
        AppMethodBeat.o(66421);
    }

    public void d(boolean z) {
        AppMethodBeat.i(66422);
        this.C = z;
        com.tencent.liteav.audio.b.a().c(z);
        AppMethodBeat.o(66422);
    }

    public boolean m() {
        return this.C;
    }

    public void b(int i, int i2) {
        AppMethodBeat.i(66423);
        this.D = i;
        this.E = i2;
        com.tencent.liteav.audio.b.a().a(i, i2);
        AppMethodBeat.o(66423);
    }

    public void b(float f) {
        AppMethodBeat.i(66424);
        this.q = f;
        TXCLiveBGMPlayer.getInstance().setPitch(f);
        AppMethodBeat.o(66424);
    }

    public int n() {
        AppMethodBeat.i(66425);
        if (this.e == null) {
            AppMethodBeat.o(66425);
            return 0;
        }
        int e = this.e.e();
        AppMethodBeat.o(66425);
        return e;
    }

    public boolean i(int i) {
        AppMethodBeat.i(66426);
        if (this.e == null) {
            AppMethodBeat.o(66426);
            return false;
        }
        boolean a = this.e.a(i);
        AppMethodBeat.o(66426);
        return a;
    }

    public boolean e(boolean z) {
        AppMethodBeat.i(66427);
        if (this.e == null) {
            AppMethodBeat.o(66427);
            return false;
        }
        this.e.c(z);
        AppMethodBeat.o(66427);
        return true;
    }

    public void c(float f) {
        AppMethodBeat.i(66428);
        if (this.e == null) {
            AppMethodBeat.o(66428);
            return;
        }
        this.e.a(f);
        AppMethodBeat.o(66428);
    }

    public void j(int i) {
        AppMethodBeat.i(66429);
        this.p = i;
        com.tencent.liteav.audio.b.a().d(i);
        TXCDRApi.txReportDAU(this.j, com.tencent.liteav.basic.datareport.a.aE);
        AppMethodBeat.o(66429);
    }

    private void b(int i, String str) {
        AppMethodBeat.i(66430);
        Bundle bundle = new Bundle();
        bundle.putLong("EVT_USERID", this.y);
        bundle.putInt("EVT_ID", i);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        if (str != null) {
            bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str);
        }
        com.tencent.liteav.basic.util.b.a(this.A, i, bundle);
        AppMethodBeat.o(66430);
    }

    public boolean c(String str) {
        AppMethodBeat.i(66431);
        if (com.tencent.liteav.audio.b.a().c()) {
            TXCDRApi.txReportDAU(this.j, com.tencent.liteav.basic.datareport.a.aF);
            boolean startPlay = TXCLiveBGMPlayer.getInstance().startPlay(str, com.tencent.liteav.audio.b.a().f());
            AppMethodBeat.o(66431);
            return startPlay;
        }
        AppMethodBeat.o(66431);
        return false;
    }

    public boolean o() {
        AppMethodBeat.i(66432);
        TXCLiveBGMPlayer.getInstance().stopPlay();
        AppMethodBeat.o(66432);
        return true;
    }

    public boolean p() {
        AppMethodBeat.i(66433);
        TXCLiveBGMPlayer.getInstance().pause();
        AppMethodBeat.o(66433);
        return true;
    }

    public boolean q() {
        AppMethodBeat.i(66434);
        TXCLiveBGMPlayer.getInstance().resume();
        AppMethodBeat.o(66434);
        return true;
    }

    public boolean d(float f) {
        AppMethodBeat.i(66435);
        this.o = f;
        com.tencent.liteav.audio.b.a().a(f);
        AppMethodBeat.o(66435);
        return true;
    }

    public boolean e(float f) {
        AppMethodBeat.i(66436);
        TXCLiveBGMPlayer.getInstance().setVolume(f);
        AppMethodBeat.o(66436);
        return true;
    }

    public int d(String str) {
        AppMethodBeat.i(66437);
        int musicDuration = (int) TXCLiveBGMPlayer.getInstance().getMusicDuration(str);
        AppMethodBeat.o(66437);
        return musicDuration;
    }

    public void a(OnBGMNotify onBGMNotify) {
        AppMethodBeat.i(66438);
        if (onBGMNotify == null) {
            this.b = null;
            this.c = null;
            TXCLiveBGMPlayer.getInstance().setOnPlayListener(null);
            AppMethodBeat.o(66438);
            return;
        }
        this.c = onBGMNotify;
        if (this.b == null) {
            this.b = new com.tencent.liteav.audio.e() {
                public void a() {
                    AppMethodBeat.i(66381);
                    if (c.this.c != null) {
                        c.this.c.onBGMStart();
                    }
                    AppMethodBeat.o(66381);
                }

                public void a(int i) {
                    AppMethodBeat.i(66382);
                    if (c.this.c != null) {
                        c.this.c.onBGMComplete(i);
                    }
                    AppMethodBeat.o(66382);
                }

                public void a(long j, long j2) {
                    AppMethodBeat.i(66383);
                    if (c.this.c != null) {
                        c.this.c.onBGMProgress(j, j2);
                    }
                    AppMethodBeat.o(66383);
                }
            };
        }
        TXCLiveBGMPlayer.getInstance().setOnPlayListener(this.b);
        AppMethodBeat.o(66438);
    }

    public int a(byte[] bArr, int i, int i2, int i3) {
        AppMethodBeat.i(66439);
        int a = a(i2, i3, null);
        if (a != 0) {
            AppMethodBeat.o(66439);
            return a;
        }
        if (this.i != null) {
            this.i.a(bArr, i, i2, i3, TXCTimeUtil.getTimeTick());
        }
        AppMethodBeat.o(66439);
        return 0;
    }

    public int c(int i, int i2, int i3) {
        AppMethodBeat.i(66440);
        int a = a(i2, i3, ((EGL10) EGLContext.getEGL()).eglGetCurrentContext());
        if (a != 0) {
            AppMethodBeat.o(66440);
            return a;
        }
        if (this.i != null) {
            this.i.a(i, i2, i3, TXCTimeUtil.getTimeTick());
        }
        AppMethodBeat.o(66440);
        return 0;
    }

    public void a(byte[] bArr, long j, int i, int i2, int i3, boolean z) {
        AppMethodBeat.i(66441);
        a aVar = this.z;
        if (aVar != null) {
            aVar.onRecordRawPcm(bArr, j, i, i2, i3, z);
        }
        AppMethodBeat.o(66441);
    }

    public void a(byte[] bArr, long j, int i, int i2, int i3) {
        AppMethodBeat.i(66442);
        a aVar = this.z;
        if (aVar != null) {
            aVar.onRecordPcm(bArr, j, i, i2, i3);
        }
        AppMethodBeat.o(66442);
    }

    public void b(byte[] bArr, long j, int i, int i2, int i3) {
        AppMethodBeat.i(66443);
        a aVar = this.z;
        if (aVar != null) {
            aVar.onEncAudio(bArr, j, i, i2);
        }
        AppMethodBeat.o(66443);
    }

    public void a(int i, String str) {
        AppMethodBeat.i(66444);
        TXCLog.e(d, "onRecordError code = " + i + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str);
        if (i == TXEAudioDef.TXE_AUDIO_RECORD_ERR_NO_MIC_PERMIT) {
            b((int) TXLiveConstants.PUSH_ERR_OPEN_MIC_FAIL, "打开麦克风失败");
        }
        AppMethodBeat.o(66444);
    }

    public int a(com.tencent.liteav.basic.g.c cVar) {
        AppMethodBeat.i(66445);
        if (this.B != null) {
            m mVar = (m) this.B.get();
            if (mVar != null) {
                cVar.a = mVar.onTextureCustomProcess(cVar.a, cVar.d, cVar.e);
            }
        }
        a(cVar, false);
        int i = cVar.a;
        AppMethodBeat.o(66445);
        return i;
    }

    public void a(com.tencent.liteav.basic.g.c cVar, long j) {
        AppMethodBeat.i(66446);
        d(cVar.a, cVar.d, cVar.e);
        AppMethodBeat.o(66446);
    }

    public void a(byte[] bArr, int i, int i2, int i3, long j) {
    }

    public void a(com.tencent.liteav.basic.g.b bVar, int i) {
        AppMethodBeat.i(66447);
        if (i == 0) {
            a aVar = this.z;
            if (!(aVar == null || bVar == null)) {
                aVar.onEncVideo(bVar);
            }
            AppMethodBeat.o(66447);
            return;
        }
        if (i == 10000004 && this.g == 1) {
            this.k.j = 0;
            b(1103, "硬编码启动失败,采用软编码");
        }
        AppMethodBeat.o(66447);
    }

    public void a(MediaFormat mediaFormat) {
        AppMethodBeat.i(66448);
        a aVar = this.z;
        if (aVar != null) {
            aVar.onEncVideoFormat(mediaFormat);
        }
        AppMethodBeat.o(66448);
    }

    public void onNotifyEvent(int i, Bundle bundle) {
        AppMethodBeat.i(66449);
        if (bundle != null) {
            bundle.putLong("EVT_USERID", this.y);
        }
        com.tencent.liteav.basic.util.b.a(this.A, i, bundle);
        AppMethodBeat.o(66449);
    }

    public void a(Bitmap bitmap, ByteBuffer byteBuffer, int i, int i2) {
        AppMethodBeat.i(66450);
        if (this.e != null) {
            final Bitmap bitmap2 = bitmap;
            final int i3 = i;
            final int i4 = i2;
            final ByteBuffer byteBuffer2 = byteBuffer;
            this.e.a(new Runnable() {
                public void run() {
                    AppMethodBeat.i(67654);
                    try {
                        int width = bitmap2.getWidth();
                        int height = bitmap2.getHeight();
                        c.this.f.a(com.tencent.liteav.basic.util.b.a(width, height, i3, i4));
                        c.this.f.a(false);
                        c.this.f.a(i3, i4);
                        c.this.f.a(0);
                        c.this.f.a(byteBuffer2.array(), width, height, 0, 2, 0);
                        AppMethodBeat.o(67654);
                    } catch (Exception e) {
                        AppMethodBeat.o(67654);
                    }
                }
            });
        }
        AppMethodBeat.o(66450);
    }

    public void a(final com.tencent.liteav.videoencoder.b bVar) {
        AppMethodBeat.i(66451);
        if (this.e != null) {
            this.e.a(new Runnable() {
                public void run() {
                    AppMethodBeat.i(67705);
                    try {
                        if (bVar != null) {
                            bVar.a();
                            bVar.a(null);
                        }
                        AppMethodBeat.o(67705);
                    } catch (Exception e) {
                        AppMethodBeat.o(67705);
                    }
                }
            });
            AppMethodBeat.o(66451);
            return;
        }
        if (bVar != null) {
            try {
                bVar.a();
                bVar.a(null);
            } catch (Exception e) {
                AppMethodBeat.o(66451);
                return;
            }
        }
        AppMethodBeat.o(66451);
    }

    public void a() {
        AppMethodBeat.i(66452);
        com.tencent.liteav.audio.b.a().b();
        com.tencent.liteav.audio.b.a().a(null);
        AppMethodBeat.o(66452);
    }

    public void a(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(66453);
        if (this.f != null) {
            this.f.a();
        }
        AppMethodBeat.o(66453);
    }

    public void b(com.tencent.liteav.basic.g.c cVar) {
        AppMethodBeat.i(66454);
        if (!(this.f == null || this.k.F || this.e == null)) {
            if (!(this.h.height == cVar.g && this.h.width == cVar.f)) {
                d(cVar.f, cVar.g);
            }
            this.w = cVar.j;
            this.f.a(cVar, cVar.b, 0);
        }
        AppMethodBeat.o(66454);
    }

    public void r() {
        AppMethodBeat.i(66455);
        if (this.f != null) {
            this.f.a();
        }
        t();
        if (this.B != null) {
            m mVar = (m) this.B.get();
            if (mVar != null) {
                mVar.onTextureDestoryed();
            }
        }
        AppMethodBeat.o(66455);
    }

    private void a(int i, int i2, int i3, EGLContext eGLContext) {
        Object eGLContext2;
        int i4;
        AppMethodBeat.i(66456);
        TXCLog.d(d, "New encode size width = " + i + " height = " + i2 + " encType = " + i3);
        t();
        this.g = i3;
        this.i = new com.tencent.liteav.videoencoder.b(this.g);
        if ((this.k.K & 2) != 2) {
            eGLContext2 = this.e != null ? this.e.f() : null;
        } else if (eGLContext2 == null) {
            eGLContext2 = this.i.a(i, i2);
        }
        this.h.width = i;
        this.h.height = i2;
        this.h.fps = this.k.h;
        this.h.gop = this.k.i;
        TXSVideoEncoderParam tXSVideoEncoderParam = this.h;
        if (this.k.n) {
            i4 = 3;
        } else {
            i4 = 1;
        }
        tXSVideoEncoderParam.encoderProfile = i4;
        this.h.encoderMode = 1;
        this.h.glContext = eGLContext2;
        this.h.realTime = this.k.I;
        this.i.a((com.tencent.liteav.videoencoder.d) this);
        this.i.a((com.tencent.liteav.basic.d.a) this);
        this.i.a(this.h);
        this.i.a(this.k.c);
        this.i.setID(getID());
        AppMethodBeat.o(66456);
    }

    private void d(int i, int i2, int i3) {
        AppMethodBeat.i(66457);
        b(i2, i3, null);
        if (this.i != null) {
            this.i.a(i, i2, i3, TXCTimeUtil.getTimeTick());
        }
        AppMethodBeat.o(66457);
    }

    private int a(int i, int i2, EGLContext eGLContext) {
        AppMethodBeat.i(66458);
        if (this.k == null) {
            AppMethodBeat.o(66458);
            return -5;
        }
        int i3;
        int i4;
        switch (this.k.k) {
            case 0:
                i3 = 640;
                i4 = 368;
                break;
            case 1:
                i3 = VideoFilterUtil.IMAGE_HEIGHT;
                i4 = 544;
                break;
            case 2:
                i3 = ActUtil.HEIGHT;
                i4 = 720;
                break;
            case 3:
                i3 = 368;
                i4 = 640;
                break;
            case 4:
                i3 = 544;
                i4 = VideoFilterUtil.IMAGE_HEIGHT;
                break;
            case 5:
                i3 = 720;
                i4 = ActUtil.HEIGHT;
                break;
            default:
                TXCLog.e(d, "sendCustomYUVData: invalid video_resolution");
                AppMethodBeat.o(66458);
                return -1;
        }
        if (i4 > i || i3 > i2) {
            AppMethodBeat.o(66458);
            return -4;
        } else if (this.k.F) {
            t();
            AppMethodBeat.o(66458);
            return -1000;
        } else {
            b(i4, i3, eGLContext);
            AppMethodBeat.o(66458);
            return 0;
        }
    }

    private void b(int i, int i2, EGLContext eGLContext) {
        int i3 = 2;
        int i4 = 1;
        AppMethodBeat.i(66459);
        switch (this.k.j) {
            case 1:
                i3 = 1;
                break;
            case 2:
                i3 = 3;
                break;
        }
        if (this.l != 1) {
            i4 = i3;
        }
        i3 = this.k.i;
        if (!(this.i != null && this.h.width == i && this.h.height == i2 && this.g == i4 && this.h.gop == i3)) {
            a(i, i2, i4, eGLContext);
        }
        AppMethodBeat.o(66459);
    }

    public void s() {
        AppMethodBeat.i(66460);
        if (this.i == null) {
            AppMethodBeat.o(66460);
        } else if (this.e != null) {
            this.e.a(new Runnable() {
                public void run() {
                    AppMethodBeat.i(65996);
                    c.h(c.this);
                    AppMethodBeat.o(65996);
                }
            });
            AppMethodBeat.o(66460);
        } else {
            t();
            AppMethodBeat.o(66460);
        }
    }

    private void t() {
        AppMethodBeat.i(66461);
        try {
            if (this.i != null) {
                this.i.a();
                this.i.a(null);
                this.i = null;
            }
            this.h.width = 0;
            this.h.height = 0;
            AppMethodBeat.o(66461);
        } catch (Exception e) {
            AppMethodBeat.o(66461);
        }
    }

    private void u() {
        AppMethodBeat.i(66462);
        if ((this.k.K & 1) != 0) {
            com.tencent.liteav.audio.b.a().a(true);
            com.tencent.liteav.audio.b.a().c(this.k.r);
            com.tencent.liteav.audio.b.a().a(this.k.q);
        } else {
            com.tencent.liteav.audio.b.a().c(1);
            com.tencent.liteav.audio.b.a().a(this.k.q);
        }
        com.tencent.liteav.audio.b.a().a(this.k.s, this.j);
        com.tencent.liteav.audio.b.a().c(this.C);
        TXCLiveBGMPlayer.getInstance().switchAecType(com.tencent.liteav.audio.b.a().f());
        TXCLiveBGMPlayer.getInstance().setPitch(this.q);
        AppMethodBeat.o(66462);
    }

    private void k(int i) {
        AppMethodBeat.i(66463);
        if (this.e == null || !this.e.d() || i == this.k.k || this.k.M || this.l != 0) {
            this.k.a();
            if (this.e != null && this.e.d()) {
                this.e.a(new Runnable() {
                    public void run() {
                        AppMethodBeat.i(67095);
                        if (c.this.e != null) {
                            c.this.e.a(c.this.k.a, c.this.k.b);
                            c.this.e.d(c.this.k.k);
                        }
                        AppMethodBeat.o(67095);
                    }
                });
            }
            AppMethodBeat.o(66463);
            return;
        }
        this.e.a(new Runnable() {
            public void run() {
                AppMethodBeat.i(67096);
                c.this.k.a();
                if (c.this.e != null) {
                    c.this.e.d(c.this.k.k);
                    c.this.e.b(false);
                }
                AppMethodBeat.o(67096);
            }
        });
        AppMethodBeat.o(66463);
    }

    private void v() {
        AppMethodBeat.i(66464);
        if (!(this.k.t == null || this.e == null)) {
            this.e.a(new Runnable() {
                public void run() {
                    AppMethodBeat.i(67767);
                    try {
                        if (!(c.this.a == null || c.this.e == null || c.this.j == null)) {
                            c.this.a.a(c.this.e.f(), c.this.j, c.this.k.t, c.this.h.width, c.this.h.height);
                        }
                        AppMethodBeat.o(67767);
                    } catch (Exception e) {
                        AppMethodBeat.o(67767);
                    }
                }
            });
        }
        AppMethodBeat.o(66464);
    }

    private void w() {
        AppMethodBeat.i(66465);
        if (this.e != null) {
            this.e.a(new Runnable() {
                public void run() {
                    AppMethodBeat.i(67447);
                    c.a(c.this, c.this.h.width, c.this.h.height);
                    AppMethodBeat.o(67447);
                }
            });
        }
        AppMethodBeat.o(66465);
    }

    private void c(int i, int i2) {
        com.tencent.liteav.beauty.c cVar;
        Bitmap bitmap;
        float f;
        float f2;
        float f3;
        AppMethodBeat.i(66466);
        if (this.k.C != -1.0f) {
            if (this.f != null) {
                cVar = this.f;
                bitmap = this.k.x;
                f = this.k.A;
                f2 = this.k.B;
                f3 = this.k.C;
            }
            AppMethodBeat.o(66466);
        }
        if (!(this.f == null || i == 0 || i2 == 0)) {
            cVar = this.f;
            bitmap = this.k.x;
            f = ((float) this.k.y) / ((float) i);
            f2 = ((float) this.k.z) / ((float) i2);
            f3 = this.k.x == null ? 0.0f : ((float) this.k.x.getWidth()) / ((float) i);
        }
        AppMethodBeat.o(66466);
        cVar.a(bitmap, f, f2, f3);
        AppMethodBeat.o(66466);
    }

    private void x() {
        AppMethodBeat.i(66467);
        if (this.f != null) {
            if (this.k.I) {
                this.f.f(0);
                AppMethodBeat.o(66467);
                return;
            }
            this.f.f(3);
        }
        AppMethodBeat.o(66467);
    }

    private void d(int i, int i2) {
        AppMethodBeat.i(66468);
        c(i, i2);
        AppMethodBeat.o(66468);
    }

    private void a(com.tencent.liteav.basic.g.c cVar, boolean z) {
        AppMethodBeat.i(66469);
        this.x = cVar;
        if (this.r == null) {
            if (this.s != null) {
                if (!(this.v == null || this.v.b() == this.s)) {
                    this.v.a();
                    this.v = null;
                }
                if (!(this.v != null || this.e == null || this.e.f() == null)) {
                    this.v = new com.tencent.liteav.basic.e.d();
                    this.v.a(this.e.f(), this.s);
                }
            } else if (this.v != null) {
                this.v.a();
                this.v = null;
            }
            if (this.v != null) {
                this.v.a(cVar.a, cVar.h, this.w, this.t, this.u, cVar.d, cVar.e, z);
            }
        } else if (this.e != null) {
            this.e.a(cVar);
            AppMethodBeat.o(66469);
            return;
        }
        AppMethodBeat.o(66469);
    }

    public void a(float f, float f2) {
        AppMethodBeat.i(66470);
        if (this.e != null && this.k.D) {
            this.e.a(f, f2);
        }
        AppMethodBeat.o(66470);
    }
}
