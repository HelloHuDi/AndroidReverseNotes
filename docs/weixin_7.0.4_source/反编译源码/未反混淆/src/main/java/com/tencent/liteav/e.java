package com.tencent.liteav;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.liteav.a.a.b;
import com.tencent.liteav.basic.d.a;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.liteav.network.f;
import com.tencent.liteav.renderer.g;
import com.tencent.liteav.renderer.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLivePlayer.ITXAudioRawDataListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;
import com.tencent.ugc.TXRecordCommon.TXRecordResult;

public class e extends n implements a, h.a, f, com.tencent.liteav.renderer.a.a, g {
    private ITXAudioRawDataListener A;
    private String B;
    private boolean C;
    private long D;
    private long E;
    private boolean F;
    private h e;
    private com.tencent.liteav.renderer.a f;
    private TXCStreamDownloader g;
    private Handler h;
    private TextureView i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private com.tencent.liteav.a.a p;
    private ITXVideoRecordListener q;
    private d r;
    private int s;
    private int t;
    private h u;
    private h v;
    private float[] w;
    private float[] x;
    private String y;
    private int z;

    public e(Context context) {
        super(context);
        AppMethodBeat.i(66322);
        this.e = null;
        this.f = null;
        this.g = null;
        this.j = false;
        this.k = false;
        this.l = 0;
        this.m = 0;
        this.n = 16;
        this.o = false;
        this.s = 0;
        this.t = 0;
        this.u = null;
        this.v = null;
        this.w = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};
        this.x = new float[16];
        this.y = "";
        this.B = "";
        this.C = false;
        this.D = 0;
        this.E = 0;
        this.F = false;
        this.h = new Handler(Looper.getMainLooper());
        this.f = new com.tencent.liteav.renderer.a();
        this.f.a((a) this);
        AppMethodBeat.o(66322);
    }

    public void a(TXCloudVideoView tXCloudVideoView) {
        AppMethodBeat.i(66323);
        if (!(this.c == null || this.c == tXCloudVideoView)) {
            TextureView videoView = this.c.getVideoView();
            if (videoView != null) {
                this.c.removeView(videoView);
            }
        }
        super.a(tXCloudVideoView);
        if (this.c != null) {
            this.i = this.c.getVideoView();
            if (this.i == null) {
                this.i = new TextureView(this.c.getContext());
            }
            this.c.addVideoView(this.i);
        }
        if (this.f != null) {
            this.f.a(this.i);
        }
        AppMethodBeat.o(66323);
    }

    public void a(Surface surface) {
        AppMethodBeat.i(66324);
        if (this.f != null) {
            this.f.a(surface);
        }
        AppMethodBeat.o(66324);
    }

    public void a(int i, int i2) {
        AppMethodBeat.i(66325);
        if (this.f != null) {
            this.f.c(i, i2);
        }
        AppMethodBeat.o(66325);
    }

    public void a(g gVar) {
        AppMethodBeat.i(66326);
        super.a(gVar);
        if (this.e != null) {
            this.e.a(gVar);
        }
        AppMethodBeat.o(66326);
    }

    public int a(String str, int i) {
        AppMethodBeat.i(66327);
        if (c()) {
            TXCLog.w("TXCLivePlayer", "play: ignore start play when is playing");
            AppMethodBeat.o(66327);
            return -2;
        }
        this.y = str;
        this.z = i;
        b(str);
        this.k = true;
        f(i);
        int b = b(str, i);
        if (b != 0) {
            this.k = false;
            m();
            l();
            if (this.i != null) {
                this.i.setVisibility(8);
            }
        } else {
            n();
            r();
            TXCDRApi.txReportDAU(this.b, com.tencent.liteav.basic.datareport.a.bv);
            try {
                if (Class.forName("com.tencent.liteav.demo.play.SuperPlayerView") != null) {
                    TXCDRApi.txReportDAU(this.b, com.tencent.liteav.basic.datareport.a.bG);
                }
            } catch (Exception e) {
            }
        }
        AppMethodBeat.o(66327);
        return b;
    }

    public int a(boolean z) {
        AppMethodBeat.i(66328);
        if (c()) {
            TXCLog.v("TXCLivePlayer", "play: stop");
            this.k = false;
            m();
            l();
            if (this.i != null && z) {
                this.i.setVisibility(8);
            }
            o();
            s();
            p();
            AppMethodBeat.o(66328);
            return 0;
        }
        TXCLog.w("TXCLivePlayer", "play: ignore stop play when not started");
        AppMethodBeat.o(66328);
        return -2;
    }

    public int a(String str) {
        AppMethodBeat.i(66329);
        if (!c() || this.g == null) {
            AppMethodBeat.o(66329);
            return -1;
        }
        boolean switchStream = this.g.switchStream(str);
        if (this.e != null) {
            TXCLog.w("TXCLivePlayer", " stream_switch video cache " + this.e.c() + " audio cache " + this.e.b());
        }
        if (switchStream) {
            this.y = str;
            AppMethodBeat.o(66329);
            return 0;
        }
        AppMethodBeat.o(66329);
        return -2;
    }

    public void a() {
        AppMethodBeat.i(66330);
        a(false);
        AppMethodBeat.o(66330);
    }

    public void b() {
        AppMethodBeat.i(66331);
        a(this.y, this.z);
        AppMethodBeat.o(66331);
    }

    public boolean c() {
        return this.k;
    }

    public void a(int i) {
        AppMethodBeat.i(66332);
        if (this.e != null) {
            this.e.a(i);
        }
        AppMethodBeat.o(66332);
    }

    public void b(int i) {
        AppMethodBeat.i(66333);
        if (this.e != null) {
            this.e.b(i);
        }
        AppMethodBeat.o(66333);
    }

    public void b(boolean z) {
        AppMethodBeat.i(66334);
        this.j = z;
        if (this.e != null) {
            this.e.b(this.j);
        }
        AppMethodBeat.o(66334);
    }

    public void a(Context context, int i) {
        AppMethodBeat.i(66335);
        h.a(context, i);
        AppMethodBeat.o(66335);
    }

    public void a(ITXVideoRecordListener iTXVideoRecordListener) {
        this.q = iTXVideoRecordListener;
    }

    public int c(int i) {
        AppMethodBeat.i(66336);
        if (this.o) {
            TXCLog.e("TXCLivePlayer", "startRecord: there is existing uncompleted record task");
            AppMethodBeat.o(66336);
            return -1;
        }
        this.o = true;
        this.f.a((g) this);
        this.f.a((com.tencent.liteav.renderer.a.a) this);
        TXCDRApi.txReportDAU(this.b, com.tencent.liteav.basic.datareport.a.aA);
        AppMethodBeat.o(66336);
        return 0;
    }

    public TextureView d() {
        return this.i;
    }

    public void a(ITXAudioRawDataListener iTXAudioRawDataListener) {
        this.A = iTXAudioRawDataListener;
    }

    public int e() {
        AppMethodBeat.i(66337);
        if (this.o) {
            this.o = false;
            if (this.p != null) {
                this.p.a();
                this.p = null;
            }
            AppMethodBeat.o(66337);
            return 0;
        }
        TXCLog.w("TXCLivePlayer", "stopRecord: no recording task exist");
        AppMethodBeat.o(66337);
        return -1;
    }

    public boolean a(byte[] bArr) {
        AppMethodBeat.i(66338);
        if (this.e != null) {
            boolean a = this.e.a(bArr);
            AppMethodBeat.o(66338);
            return a;
        }
        AppMethodBeat.o(66338);
        return false;
    }

    public void a(o oVar) {
        AppMethodBeat.i(66339);
        if (this.e != null) {
            this.e.a(oVar);
        }
        AppMethodBeat.o(66339);
    }

    public boolean f() {
        return true;
    }

    private void i() {
        AppMethodBeat.i(66340);
        if (this.p == null) {
            this.s = this.f.m();
            this.t = this.f.n();
            com.tencent.liteav.a.a.a k = k();
            this.p = new com.tencent.liteav.a.a(this.b);
            this.p.a(k);
            this.p.a(new b() {
                public void a(int i, String str, String str2, String str3) {
                    AppMethodBeat.i(67359);
                    if (e.this.q != null) {
                        TXRecordResult tXRecordResult = new TXRecordResult();
                        if (i == 0) {
                            tXRecordResult.retCode = 0;
                        } else {
                            tXRecordResult.retCode = -1;
                        }
                        tXRecordResult.descMsg = str;
                        tXRecordResult.videoPath = str2;
                        tXRecordResult.coverPath = str3;
                        e.this.q.onRecordComplete(tXRecordResult);
                    }
                    e.this.f.a(null);
                    e.this.f.a(null);
                    AppMethodBeat.o(67359);
                }

                public void a(long j) {
                    AppMethodBeat.i(67360);
                    if (e.this.q != null) {
                        e.this.q.onRecordProgress(j);
                    }
                    AppMethodBeat.o(67360);
                }
            });
        }
        if (this.u == null) {
            this.u = new h(Boolean.TRUE);
            this.u.b();
            this.u.b(this.s, this.t);
            this.u.a(this.s, this.t);
        }
        if (this.v == null) {
            this.v = new h(Boolean.FALSE);
            this.v.b();
            this.v.b(this.f.k(), this.f.l());
            this.v.a(this.f.k(), this.f.l());
            Matrix.setIdentityM(this.x, 0);
        }
        AppMethodBeat.o(66340);
    }

    private void j() {
        AppMethodBeat.i(66341);
        if (this.u != null) {
            this.u.c();
            this.u = null;
        }
        if (this.v != null) {
            this.v.c();
            this.v = null;
        }
        AppMethodBeat.o(66341);
    }

    private com.tencent.liteav.a.a.a k() {
        AppMethodBeat.i(66342);
        int i = 480;
        int i2 = 640;
        if (this.s > 0 && this.t > 0) {
            i = this.s;
            i2 = this.t;
        }
        com.tencent.liteav.a.a.a aVar = new com.tencent.liteav.a.a.a();
        aVar.a = i;
        aVar.b = i2;
        aVar.c = 20;
        aVar.d = (int) (Math.sqrt(((double) (i2 * i2)) + (((double) (i * i)) * 1.0d)) * 1.2d);
        aVar.h = this.l;
        aVar.i = this.m;
        aVar.j = this.n;
        aVar.f = com.tencent.liteav.a.a.a(this.b, VideoMaterialUtil.MP4_SUFFIX);
        aVar.g = com.tencent.liteav.a.a.a(this.b, FileUtils.PIC_POSTFIX_JPEG);
        aVar.e = this.f.b();
        TXCLog.d("TXCLivePlayer", "record config: ".concat(String.valueOf(aVar)));
        AppMethodBeat.o(66342);
        return aVar;
    }

    private void f(int i) {
        boolean z = true;
        AppMethodBeat.i(66343);
        if (this.i != null) {
            this.i.setVisibility(0);
        }
        this.e = new h(this.b, 1);
        this.e.a((a) this);
        this.e.a(this.f);
        this.e.a((h.a) this);
        this.e.a(this.a);
        this.e.setID(this.B);
        h hVar = this.e;
        if (i != 5) {
            z = false;
        }
        hVar.a(z);
        this.e.b(this.j);
        AppMethodBeat.o(66343);
    }

    private void l() {
        AppMethodBeat.i(66344);
        if (this.e != null) {
            this.e.a();
            this.e.a(null);
            this.e.a(null);
            this.e.a(null);
            this.e = null;
        }
        AppMethodBeat.o(66344);
    }

    private int b(String str, int i) {
        int i2 = 0;
        AppMethodBeat.i(66345);
        if (i == 0) {
            this.g = new TXCStreamDownloader(this.b, 1);
        } else if (i == 5) {
            this.g = new TXCStreamDownloader(this.b, 4);
        } else {
            this.g = new TXCStreamDownloader(this.b, 0);
        }
        this.g.setID(this.B);
        this.g.setListener(this);
        this.g.setNotifyListener(this);
        this.g.setHeaders(this.a.o);
        if (i == 5) {
            i2 = 1;
        }
        if (i2 != 0) {
            this.g.setRetryTimes(5);
            this.g.setRetryInterval(1);
        } else {
            this.g.setRetryTimes(this.a.e);
            this.g.setRetryInterval(this.a.f);
        }
        i2 = this.g.start(str, this.a.j, this.a.l, this.a.k);
        AppMethodBeat.o(66345);
        return i2;
    }

    private void m() {
        AppMethodBeat.i(66346);
        if (this.g != null) {
            this.g.setListener(null);
            this.g.setNotifyListener(null);
            this.g.stop();
            this.g = null;
        }
        AppMethodBeat.o(66346);
    }

    private void n() {
        AppMethodBeat.i(66347);
        this.r = new d(this.b);
        this.r.a(this.y);
        this.r.a(this.z == 5);
        this.r.d(this.B);
        this.r.a();
        AppMethodBeat.o(66347);
    }

    private void o() {
        AppMethodBeat.i(66348);
        if (this.r != null) {
            this.r.c();
            this.r = null;
        }
        AppMethodBeat.o(66348);
    }

    private void b(String str) {
        AppMethodBeat.i(66349);
        this.B = String.format("%s-%d", new Object[]{str, Long.valueOf(TXCTimeUtil.getTimeTick() % 10000)});
        if (this.e != null) {
            this.e.setID(this.B);
        }
        if (this.f != null) {
            this.f.setID(this.B);
        }
        if (this.g != null) {
            this.g.setID(this.B);
        }
        if (this.r != null) {
            this.r.d(this.B);
        }
        AppMethodBeat.o(66349);
    }

    public void g() {
        AppMethodBeat.i(66350);
        this.E = 0;
        if (this.C) {
            AppMethodBeat.o(66350);
            return;
        }
        this.C = true;
        if (this.h != null) {
            this.h.postDelayed(new Runnable() {
                public void run() {
                    AppMethodBeat.i(67766);
                    if (e.this.C) {
                        e.d(e.this);
                    }
                    AppMethodBeat.o(67766);
                }
            }, 1000);
        }
        AppMethodBeat.o(66350);
    }

    private void p() {
        this.C = false;
    }

    private void q() {
        AppMethodBeat.i(66351);
        if (this.D > 0) {
            Bundle bundle = new Bundle();
            bundle.putInt(TXLiveConstants.EVT_PLAY_PROGRESS, (int) (this.D / 1000));
            bundle.putInt(TXLiveConstants.EVT_PLAY_PROGRESS_MS, (int) this.D);
            onNotifyEvent(TXLiveConstants.PLAY_EVT_PLAY_PROGRESS, bundle);
        }
        if (this.h != null && this.C) {
            this.h.postDelayed(new Runnable() {
                public void run() {
                    AppMethodBeat.i(67357);
                    if (e.this.C) {
                        e.d(e.this);
                    }
                    AppMethodBeat.o(67357);
                }
            }, 1000);
        }
        AppMethodBeat.o(66351);
    }

    private void r() {
        AppMethodBeat.i(66352);
        this.F = true;
        if (this.h != null) {
            this.h.postDelayed(new Runnable() {
                public void run() {
                    AppMethodBeat.i(66379);
                    if (e.this.F) {
                        e.f(e.this);
                    }
                    AppMethodBeat.o(66379);
                }
            }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        AppMethodBeat.o(66352);
    }

    private void s() {
        this.F = false;
    }

    private void t() {
        AppMethodBeat.i(66353);
        int[] a = com.tencent.liteav.basic.util.b.a();
        int i = a[0] / 10;
        String str = i + "/" + (a[1] / 10) + "%";
        int d = TXCStatus.d(this.B, 7102);
        int d2 = TXCStatus.d(this.B, 7101);
        String c = TXCStatus.c(this.B, 7110);
        i = (int) TXCStatus.e(this.B, 6002);
        Bundle bundle = new Bundle();
        if (this.f != null) {
            bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_WIDTH, this.f.m());
            bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_HEIGHT, this.f.n());
        }
        if (this.e != null) {
            int i2;
            bundle.putInt(TXLiveConstants.NET_STATUS_CACHE_SIZE, (int) this.e.c());
            bundle.putInt(TXLiveConstants.NET_STATUS_CODEC_CACHE, (int) this.e.b());
            bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_CACHE_SIZE, (int) this.e.d());
            bundle.putInt(TXLiveConstants.NET_STATUS_V_DEC_CACHE_SIZE, this.e.e());
            bundle.putInt(TXLiveConstants.NET_STATUS_AV_PLAY_INTERVAL, (int) this.e.f());
            bundle.putString(TXLiveConstants.NET_STATUS_AUDIO_INFO, this.e.k());
            bundle.putInt(TXLiveConstants.NET_STATUS_NET_JITTER, this.e.g());
            bundle.putInt(TXLiveConstants.NET_STATUS_AV_RECV_INTERVAL, (int) this.e.h());
            bundle.putFloat(TXLiveConstants.NET_STATUS_AUDIO_PLAY_SPEED, this.e.i());
            if (i == 0) {
                i2 = 15;
            } else {
                i2 = i;
            }
            bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_GOP, (int) (((double) (((float) ((this.e.j() * 10) / i2)) / 10.0f)) + 0.5d));
        }
        bundle.putInt(TXLiveConstants.NET_STATUS_NET_SPEED, d2 + d);
        bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_FPS, i);
        bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_BITRATE, d2);
        bundle.putInt(TXLiveConstants.NET_STATUS_AUDIO_BITRATE, d);
        bundle.putCharSequence(TXLiveConstants.NET_STATUS_SERVER_IP, c);
        bundle.putCharSequence(TXLiveConstants.NET_STATUS_CPU_USAGE, str);
        com.tencent.liteav.basic.util.b.a(this.d, 15001, bundle);
        if (this.e != null) {
            this.e.l();
        }
        if (this.r != null) {
            this.r.f();
        }
        if (this.h != null && this.F) {
            this.h.postDelayed(new Runnable() {
                public void run() {
                    AppMethodBeat.i(67707);
                    if (e.this.F) {
                        e.f(e.this);
                    }
                    AppMethodBeat.o(67707);
                }
            }, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        AppMethodBeat.o(66353);
    }

    public void onPullAudio(com.tencent.liteav.basic.g.a aVar) {
        AppMethodBeat.i(66354);
        if (this.k) {
            if (this.e != null) {
                this.e.a(aVar);
            }
            AppMethodBeat.o(66354);
            return;
        }
        AppMethodBeat.o(66354);
    }

    public void onPullNAL(com.tencent.liteav.basic.g.b bVar) {
        AppMethodBeat.i(66355);
        if (this.k) {
            try {
                if (this.e != null) {
                    this.e.a(bVar);
                }
                AppMethodBeat.o(66355);
                return;
            } catch (Exception e) {
                AppMethodBeat.o(66355);
                return;
            }
        }
        AppMethodBeat.o(66355);
    }

    public void onNotifyEvent(final int i, final Bundle bundle) {
        AppMethodBeat.i(66356);
        if (TXLiveConstants.PLAY_ERR_GET_RTMP_ACC_URL_FAIL == i && this.e != null) {
            this.e.c((int) com.tencent.liteav.basic.f.b.a().a("Audio", "SmoothModeAdjust"));
        }
        if (this.h != null) {
            this.h.post(new Runnable() {
                public void run() {
                    AppMethodBeat.i(67358);
                    com.tencent.liteav.basic.util.b.a(e.this.d, i, bundle);
                    if (i == TXLiveConstants.PLAY_WARNING_RECONNECT && e.this.e != null) {
                        e.this.e.m();
                    }
                    AppMethodBeat.o(67358);
                }
            });
        }
        AppMethodBeat.o(66356);
    }

    public int a(int i, float[] fArr) {
        AppMethodBeat.i(66357);
        com.tencent.liteav.a.a aVar = this.p;
        if (!(!this.o || aVar == null || this.u == null)) {
            int d = this.u.d(i);
            aVar.a(d, TXCTimeUtil.getTimeTick());
            this.f.a(d, this.s, this.t, false, 0);
        }
        if (this.o) {
            i();
        } else {
            j();
        }
        AppMethodBeat.o(66357);
        return i;
    }

    public void d(int i) {
        AppMethodBeat.i(66358);
        com.tencent.liteav.a.a aVar = this.p;
        if (!(!this.o || aVar == null || this.v == null)) {
            this.v.a(this.w);
            aVar.a(this.v.d(i), TXCTimeUtil.getTimeTick());
            this.v.a(this.x);
            this.v.c(i);
        }
        if (this.o) {
            i();
            AppMethodBeat.o(66358);
            return;
        }
        j();
        AppMethodBeat.o(66358);
    }

    public void a(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(66359);
        j();
        e();
        AppMethodBeat.o(66359);
    }

    public void a(byte[] bArr, long j) {
        AppMethodBeat.i(66360);
        if (this.p != null) {
            if (j <= 0) {
                j = TXCTimeUtil.getTimeTick();
            }
            this.p.a(bArr, j);
        }
        if (this.A != null) {
            this.A.onPcmDataAvailable(bArr, j);
        }
        if (this.E <= 0) {
            this.E = j;
            AppMethodBeat.o(66360);
            return;
        }
        this.D = j - this.E;
        AppMethodBeat.o(66360);
    }

    public void a(com.tencent.liteav.basic.g.a aVar) {
        AppMethodBeat.i(66361);
        TXCLog.d("TXCLivePlayer", "onPlayAudioInfoChanged, samplerate=" + aVar.a + ", channels=" + aVar.b + ", bits=" + aVar.c);
        this.l = aVar.b;
        this.m = aVar.a;
        if (aVar.c > 1) {
            this.n = aVar.c;
        }
        if (this.A != null) {
            this.A.onAudioInfoChanged(aVar.a, aVar.b, aVar.c);
        }
        AppMethodBeat.o(66361);
    }

    public void a(long j) {
    }
}
