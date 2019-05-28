package com.tencent.liteav;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.c;
import com.tencent.liteav.audio.impl.Play.TXAudioJitterBufferReportInfo;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.renderer.e;
import com.tencent.liteav.renderer.f;
import com.tencent.liteav.videodecoder.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;

public class h extends com.tencent.liteav.basic.module.a implements c, b, com.tencent.liteav.basic.d.a, f, d {
    private Context a = null;
    private g b = null;
    private com.tencent.liteav.videodecoder.b c = null;
    private e d = null;
    private com.tencent.liteav.basic.b.a e = null;
    private com.tencent.liteav.audio.a f = null;
    private com.tencent.liteav.basic.d.a g = null;
    private boolean h = false;
    private int i = 0;
    private long j = 0;
    private byte[] k = null;
    private o l = null;
    private int m;
    private boolean n = false;
    private String o;
    private final float p = com.tencent.liteav.basic.a.a.o;
    private final float q = com.tencent.liteav.basic.a.a.p;
    private final float r = com.tencent.liteav.basic.a.a.q;
    private final float s = 0.3f;
    private boolean t = false;
    private a u = null;

    public interface a {
        void a(long j);

        void a(SurfaceTexture surfaceTexture);

        void a(com.tencent.liteav.basic.g.a aVar);

        void a(byte[] bArr, long j);
    }

    public h(Context context, int i) {
        AppMethodBeat.i(67721);
        this.a = context;
        this.m = i;
        com.tencent.liteav.basic.f.b.a().a(this.a);
        AppMethodBeat.o(67721);
    }

    public void a(e eVar) {
        AppMethodBeat.i(67722);
        this.d = eVar;
        if (!(this.d == null || this.g == null)) {
            this.d.a((com.tencent.liteav.basic.d.a) this);
        }
        if (!(this.d == null || this.b == null)) {
            this.d.a(this.b.d);
        }
        AppMethodBeat.o(67722);
    }

    public void a(com.tencent.liteav.basic.d.a aVar) {
        this.g = aVar;
    }

    public void a(g gVar) {
        AppMethodBeat.i(67723);
        this.b = gVar;
        r();
        AppMethodBeat.o(67723);
    }

    public void setID(String str) {
        AppMethodBeat.i(67724);
        super.setID(str);
        if (this.d != null) {
            this.d.setID(getID());
        }
        AppMethodBeat.o(67724);
    }

    public void a(a aVar) {
        this.u = aVar;
    }

    public void a(boolean z) {
        AppMethodBeat.i(67725);
        this.h = z;
        this.n = true;
        if (this.d != null) {
            this.d.a((f) this);
            this.d.i();
            this.d.setID(getID());
        }
        this.c = new com.tencent.liteav.videodecoder.b();
        this.c.a(this.j);
        this.c.a((d) this);
        this.c.a((com.tencent.liteav.basic.d.a) this);
        this.f = new com.tencent.liteav.audio.a();
        this.f.a((c) this);
        c(this.h);
        this.f.a(this.i);
        this.f.a(this.a);
        this.e = new com.tencent.liteav.basic.b.a();
        this.e.a((b) this);
        this.e.a();
        q();
        r();
        AppMethodBeat.o(67725);
    }

    public void a() {
        AppMethodBeat.i(67726);
        this.h = false;
        this.i = 0;
        if (this.c != null) {
            this.c.a(null);
            this.c.a(null);
            this.c.c();
        }
        if (this.f != null) {
            this.f.a(null);
            this.f.a();
        }
        if (this.e != null) {
            this.e.a(null);
            this.e.b();
        }
        if (this.d != null) {
            this.d.j();
            this.d.a(null);
        }
        AppMethodBeat.o(67726);
    }

    public void a(com.tencent.liteav.basic.g.a aVar) {
        AppMethodBeat.i(67727);
        if (this.f != null) {
            this.f.a(aVar);
            AppMethodBeat.o(67727);
            return;
        }
        TXCLog.w("TXCRenderAndDec", "decAudio fail which audio play hasn't been created!");
        AppMethodBeat.o(67727);
    }

    public void a(com.tencent.liteav.basic.g.b bVar) {
        AppMethodBeat.i(67728);
        try {
            if (this.e != null) {
                this.e.a(bVar);
            }
            AppMethodBeat.o(67728);
        } catch (Exception e) {
            AppMethodBeat.o(67728);
        }
    }

    public void a(int i) {
        AppMethodBeat.i(67729);
        if (this.d != null) {
            this.d.b(i);
        }
        AppMethodBeat.o(67729);
    }

    public void b(int i) {
        AppMethodBeat.i(67730);
        if (this.d != null) {
            this.d.c(i);
        }
        AppMethodBeat.o(67730);
    }

    public void b(boolean z) {
        AppMethodBeat.i(67731);
        if (this.f != null) {
            this.f.d(z);
        }
        AppMethodBeat.o(67731);
    }

    public void c(int i) {
        AppMethodBeat.i(67732);
        this.i = i;
        if (this.f != null) {
            this.f.a(this.i);
        }
        AppMethodBeat.o(67732);
    }

    public static void a(Context context, int i) {
        AppMethodBeat.i(67733);
        com.tencent.liteav.audio.a.a(context, i);
        AppMethodBeat.o(67733);
    }

    public long b() {
        AppMethodBeat.i(67734);
        if (this.f != null) {
            long b = this.f.b();
            AppMethodBeat.o(67734);
            return b;
        }
        AppMethodBeat.o(67734);
        return 0;
    }

    public long c() {
        AppMethodBeat.i(67735);
        if (this.e != null) {
            long d = this.e.d();
            AppMethodBeat.o(67735);
            return d;
        }
        AppMethodBeat.o(67735);
        return 0;
    }

    public long d() {
        AppMethodBeat.i(67736);
        if (this.e != null) {
            long e = this.e.e();
            AppMethodBeat.o(67736);
            return e;
        }
        AppMethodBeat.o(67736);
        return 0;
    }

    public int e() {
        AppMethodBeat.i(67737);
        if (this.c != null) {
            int d = this.c.d();
            AppMethodBeat.o(67737);
            return d;
        }
        AppMethodBeat.o(67737);
        return 0;
    }

    public long f() {
        AppMethodBeat.i(67738);
        if (this.e == null || this.f == null) {
            AppMethodBeat.o(67738);
            return 0;
        }
        long c = this.f.c() - this.e.f();
        AppMethodBeat.o(67738);
        return c;
    }

    public int g() {
        AppMethodBeat.i(67739);
        if (this.f != null) {
            int d = this.f.d();
            AppMethodBeat.o(67739);
            return d;
        }
        AppMethodBeat.o(67739);
        return 0;
    }

    public long h() {
        AppMethodBeat.i(67740);
        if (this.f == null || this.e == null) {
            AppMethodBeat.o(67740);
            return 0;
        }
        long e = this.f.e() - this.e.g();
        AppMethodBeat.o(67740);
        return e;
    }

    public float i() {
        AppMethodBeat.i(67741);
        if (this.f != null) {
            float f = this.f.f();
            AppMethodBeat.o(67741);
            return f;
        }
        AppMethodBeat.o(67741);
        return 0.0f;
    }

    public int j() {
        AppMethodBeat.i(67742);
        if (this.e != null) {
            int h = this.e.h();
            AppMethodBeat.o(67742);
            return h;
        }
        AppMethodBeat.o(67742);
        return 0;
    }

    public String k() {
        int g;
        AppMethodBeat.i(67743);
        if (this.f != null) {
            g = this.f.g();
        } else {
            g = TXEAudioDef.TXE_AEC_NONE;
        }
        String str = g + " | " + this.o;
        AppMethodBeat.o(67743);
        return str;
    }

    public void l() {
        long j = 0;
        AppMethodBeat.i(67744);
        if (this.f != null) {
            TXAudioJitterBufferReportInfo h = this.f.h();
            if (h != null) {
                long j2 = h.mLoadCnt == 0 ? 0 : (long) (h.mLoadTime / h.mLoadCnt);
                long j3 = h.mTimeTotalCacheTimeCnt == 0 ? 0 : h.mTimeTotalCacheTime / h.mTimeTotalCacheTimeCnt;
                long j4 = (long) (h.mTimeTotalJittCnt == 0 ? 0 : h.mTimeTotalJitt / h.mTimeTotalJittCnt);
                setStatusValue(2001, Long.valueOf(j2));
                setStatusValue(2002, Long.valueOf((long) h.mLoadCnt));
                setStatusValue(2003, Long.valueOf((long) h.mLoadMaxTime));
                setStatusValue(2004, Long.valueOf((long) h.mSpeedCnt));
                setStatusValue(TXLiveConstants.PLAY_EVT_PLAY_PROGRESS, Long.valueOf((long) h.mNoDataCnt));
                setStatusValue(TXLiveConstants.PLAY_EVT_PLAY_LOADING, Long.valueOf((long) h.mAvgCacheTime));
                setStatusValue(2008, Long.valueOf((long) h.mIsRealTime));
                setStatusValue(2010, Long.valueOf(j3));
                setStatusValue(2011, Long.valueOf(j4));
                setStatusValue(2014, Long.valueOf((long) h.mTimeDropCnt));
            }
        }
        if (this.e != null) {
            setStatusValue(TXLiveConstants.PLAY_EVT_PLAY_END, Long.valueOf(d()));
            setStatusValue(6007, Long.valueOf(this.e.k()));
            setStatusValue(6008, Long.valueOf(this.e.j()));
            setStatusValue(6009, Long.valueOf(this.e.i()));
        }
        if (this.c != null) {
            if (this.c.a()) {
                j = 1;
            }
            setStatusValue(ReaderCallback.SHOW_BAR, Long.valueOf(j));
        }
        AppMethodBeat.o(67744);
    }

    public boolean a(byte[] bArr) {
        synchronized (this) {
            this.k = bArr;
        }
        return true;
    }

    public void a(o oVar) {
        synchronized (this) {
            this.l = oVar;
        }
    }

    private void c(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(67745);
        com.tencent.liteav.videodecoder.b bVar = this.c;
        if (bVar != null) {
            bVar.a(this.b.i);
            if (surfaceTexture != null) {
                bVar.a(surfaceTexture, null, null, !this.h);
                bVar.b();
            }
        }
        AppMethodBeat.o(67745);
    }

    private void q() {
        AppMethodBeat.i(67746);
        c(this.d != null ? this.d.a() : null);
        AppMethodBeat.o(67746);
    }

    private void r() {
        AppMethodBeat.i(67747);
        c(this.h);
        if (this.f != null) {
            this.f.a(this.b.a);
            this.f.a(this.b.g);
            this.f.c(this.b.c);
            this.f.b(this.b.b);
            setStatusValue(2012, Long.valueOf((long) (this.b.c * 1000.0f)));
            setStatusValue(2013, Long.valueOf((long) (this.b.b * 1000.0f)));
            setStatusValue(2015, Long.valueOf(0));
        }
        if (this.e != null) {
            this.e.a(this.b.c);
        }
        if (this.c != null && this.c.a() && this.b.c < 0.3f && this.b.b < 0.3f) {
            this.b.i = false;
            this.c.c();
            q();
        }
        if (this.d != null) {
            this.d.a(this.b.d);
        }
        AppMethodBeat.o(67747);
    }

    private void c(boolean z) {
        AppMethodBeat.i(67748);
        if (z) {
            float f;
            float f2 = this.b.c;
            float f3 = this.b.b;
            if (f2 > this.q) {
                f2 = this.q;
            }
            if (f3 > this.r) {
                f3 = this.r;
            }
            if (f2 >= f3) {
                f = this.q;
                f3 = this.r;
            } else {
                f = f2;
            }
            this.b.g = true;
            this.b.a = f;
            this.b.c = f;
            this.b.b = f3;
            if (this.f != null) {
                this.f.a(true, this.a);
                this.f.c(true);
            }
        } else {
            TXCLog.e("TXCRenderAndDec", "setupRealTimePlayParams current cache time : min-cache[" + this.b.c + "], max-cache[" + this.b.b + "], org-cache[" + this.b.a + "]");
            if (this.f != null) {
                if (this.b == null || !this.b.h) {
                    this.f.a(false, this.a);
                } else {
                    this.f.a(true, this.a);
                }
                this.f.c(false);
            }
            if (this.b.a > this.b.b || this.b.a < this.b.c) {
                this.b.a = this.b.b;
            }
        }
        if (this.e != null) {
            this.e.b(z);
        }
        AppMethodBeat.o(67748);
    }

    private void a(int i, String str) {
        AppMethodBeat.i(67749);
        com.tencent.liteav.basic.d.a aVar = this.g;
        if (aVar != null) {
            Bundle bundle = new Bundle();
            new StringBuilder("TXCRenderAndDec notifyEvent: mUserID  ").append(this.j);
            bundle.putLong("EVT_USERID", this.j);
            bundle.putInt("EVT_ID", i);
            bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
            if (str != null) {
                bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str);
            }
            aVar.onNotifyEvent(i, bundle);
        }
        AppMethodBeat.o(67749);
    }

    private void s() {
        AppMethodBeat.i(67750);
        com.tencent.liteav.videodecoder.b bVar = this.c;
        if (bVar != null) {
            TXCLog.w("TXCRenderAndDec", "switch to soft decoder when hw error");
            bVar.c();
            this.b.i = false;
            c(this.h);
            q();
        }
        AppMethodBeat.o(67750);
    }

    public void m() {
        AppMethodBeat.i(67751);
        com.tencent.liteav.videodecoder.b bVar = this.c;
        if (bVar != null && bVar.e()) {
            bVar.b(true);
        }
        AppMethodBeat.o(67751);
    }

    public void onNotifyEvent(int i, Bundle bundle) {
        AppMethodBeat.i(67752);
        if (i == TXLiveConstants.PLAY_WARNING_HW_ACCELERATION_FAIL) {
            s();
        } else if (i == 2003 && this.n) {
            a(2004, "视频播放开始");
            this.n = false;
        }
        com.tencent.liteav.basic.d.a aVar = this.g;
        if (aVar != null) {
            aVar.onNotifyEvent(i, bundle);
        }
        AppMethodBeat.o(67752);
    }

    public void a(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(67753);
        c(surfaceTexture);
        AppMethodBeat.o(67753);
    }

    public void b(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(67754);
        try {
            TXCLog.w("TXCRenderAndDec", "play:stop decode when surface texture release");
            if (this.c != null) {
                this.c.c();
            }
            if (this.u != null) {
                this.u.a(surfaceTexture);
            }
            AppMethodBeat.o(67754);
        } catch (Exception e) {
            AppMethodBeat.o(67754);
        }
    }

    public long n() {
        AppMethodBeat.i(67755);
        try {
            if (this.f != null) {
                long b = this.f.b();
                AppMethodBeat.o(67755);
                return b;
            }
        } catch (Exception e) {
        }
        AppMethodBeat.o(67755);
        return 0;
    }

    public long o() {
        AppMethodBeat.i(67756);
        try {
            if (this.f != null) {
                long c = this.f.c();
                AppMethodBeat.o(67756);
                return c;
            }
        } catch (Exception e) {
        }
        AppMethodBeat.o(67756);
        return 0;
    }

    public void b(com.tencent.liteav.basic.g.b bVar) {
        AppMethodBeat.i(67757);
        try {
            if (this.c != null) {
                this.c.a(bVar);
                AppMethodBeat.o(67757);
                return;
            }
            if (this.e != null) {
                this.e.a(bVar.g);
            }
            AppMethodBeat.o(67757);
        } catch (Exception e) {
            AppMethodBeat.o(67757);
        }
    }

    public void c(com.tencent.liteav.basic.g.b bVar) {
        AppMethodBeat.i(67758);
        Bundle bundle = new Bundle();
        bundle.putByteArray(TXLiveConstants.EVT_GET_MSG, bVar.a);
        onNotifyEvent(2012, bundle);
        AppMethodBeat.o(67758);
    }

    public int p() {
        AppMethodBeat.i(67759);
        try {
            if (this.c != null) {
                int d = this.c.d();
                AppMethodBeat.o(67759);
                return d;
            }
        } catch (Exception e) {
        }
        AppMethodBeat.o(67759);
        return 0;
    }

    public void a(SurfaceTexture surfaceTexture, int i, int i2, long j, long j2) {
        AppMethodBeat.i(67760);
        if (this.d != null) {
            this.d.a(surfaceTexture, i, i2);
            if (this.u != null) {
                this.u.a(j);
            }
            if (this.e != null) {
                this.e.a(j);
            }
        }
        AppMethodBeat.o(67760);
    }

    public void a(long j, int i, int i2, long j2, long j3) {
        AppMethodBeat.i(67761);
        Object obj = null;
        if (!(this.l == null || this.k == null)) {
            synchronized (this) {
                try {
                    byte[] bArr = this.k;
                    this.k = null;
                    if (!(this.l == null || bArr == null || this.c == null)) {
                        if (bArr.length <= ((i * i2) * 3) / 2) {
                            this.c.a(bArr, j, bArr.length);
                            this.l.onVideoRawDataAvailable(bArr, i, i2, (int) j2);
                            obj = 1;
                        } else {
                            TXCLog.e("TXCRenderAndDec", "raw data buffer length is too large");
                        }
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(67761);
                }
            }
        }
        if (obj == null) {
            if (j > 0 && this.d != null) {
                this.d.a(j, i, i2);
            }
            if (this.e != null) {
                this.e.a(j2);
            }
        }
        AppMethodBeat.o(67761);
    }

    public void a(int i, int i2) {
        AppMethodBeat.i(67762);
        if (this.d != null) {
            this.d.b(i, i2);
        }
        Bundle bundle = new Bundle();
        bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, "分辨率改变");
        bundle.putInt("EVT_PARAM1", i);
        bundle.putInt("EVT_PARAM2", i2);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        onNotifyEvent(2009, bundle);
        AppMethodBeat.o(67762);
    }

    public void onPlayAudioInfoChanged(com.tencent.liteav.basic.g.a aVar, com.tencent.liteav.basic.g.a aVar2) {
        AppMethodBeat.i(67763);
        if (this.u != null) {
            this.u.a(aVar2);
        }
        if (!(aVar == null || aVar2 == null)) {
            this.o = aVar.a + "," + aVar.b + " | " + aVar2.a + "," + aVar2.b;
        }
        AppMethodBeat.o(67763);
    }

    public void onPlayPcmData(byte[] bArr, long j) {
        AppMethodBeat.i(67764);
        if (this.u != null) {
            this.u.a(bArr, j);
        }
        AppMethodBeat.o(67764);
    }

    public void onPlayError(int i, String str) {
    }

    public void onPlayJitterStateNotify(int i) {
        AppMethodBeat.i(67765);
        if (i == TXEAudioDef.TXE_AUDIO_JITTER_STATE_LOADING) {
            if (!(this.e == null || this.h)) {
                this.e.a(true);
            }
            a((int) TXLiveConstants.PLAY_EVT_PLAY_LOADING, "视频缓冲中...");
            AppMethodBeat.o(67765);
        } else if (i == TXEAudioDef.TXE_AUDIO_JITTER_STATE_FIRST_LAODING) {
            a((int) TXLiveConstants.PLAY_EVT_PLAY_LOADING, "视频缓冲中...");
            AppMethodBeat.o(67765);
        } else if (i == TXEAudioDef.TXE_AUDIO_JITTER_STATE_PLAYING) {
            if (this.e != null) {
                this.e.a(false);
            }
            a(2004, "视频播放开始");
            AppMethodBeat.o(67765);
        } else {
            if (i == TXEAudioDef.TXE_AUDIO_JITTER_STATE_FIRST_PLAY) {
                if (this.e != null) {
                    this.e.a(false);
                }
                if (this.n) {
                    a(2004, "视频播放开始");
                    this.n = false;
                }
            }
            AppMethodBeat.o(67765);
        }
    }
}
