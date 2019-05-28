package com.tencent.liteav;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import com.tencent.liteav.audio.C0943a;
import com.tencent.liteav.audio.C8791c;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.audio.impl.Play.TXAudioJitterBufferReportInfo;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.C32147a;
import com.tencent.liteav.basic.p1168b.C17770a;
import com.tencent.liteav.basic.p1168b.C25645b;
import com.tencent.liteav.basic.p1169f.C45104b;
import com.tencent.liteav.basic.p140d.C0946a;
import com.tencent.liteav.basic.p1587a.C41678a;
import com.tencent.liteav.basic.p811g.C25648a;
import com.tencent.liteav.basic.p811g.C25649b;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.renderer.C45115e;
import com.tencent.liteav.renderer.C8837f;
import com.tencent.liteav.videodecoder.C37377d;
import com.tencent.liteav.videodecoder.C8848b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;

/* renamed from: com.tencent.liteav.h */
public class C17788h extends C32147a implements C8791c, C25645b, C0946a, C8837f, C37377d {
    /* renamed from: a */
    private Context f4188a = null;
    /* renamed from: b */
    private C17787g f4189b = null;
    /* renamed from: c */
    private C8848b f4190c = null;
    /* renamed from: d */
    private C45115e f4191d = null;
    /* renamed from: e */
    private C17770a f4192e = null;
    /* renamed from: f */
    private C0943a f4193f = null;
    /* renamed from: g */
    private C0946a f4194g = null;
    /* renamed from: h */
    private boolean f4195h = false;
    /* renamed from: i */
    private int f4196i = 0;
    /* renamed from: j */
    private long f4197j = 0;
    /* renamed from: k */
    private byte[] f4198k = null;
    /* renamed from: l */
    private C8832o f4199l = null;
    /* renamed from: m */
    private int f4200m;
    /* renamed from: n */
    private boolean f4201n = false;
    /* renamed from: o */
    private String f4202o;
    /* renamed from: p */
    private final float f4203p = C41678a.f16933o;
    /* renamed from: q */
    private final float f4204q = C41678a.f16934p;
    /* renamed from: r */
    private final float f4205r = C41678a.f16935q;
    /* renamed from: s */
    private final float f4206s = 0.3f;
    /* renamed from: t */
    private boolean f4207t = false;
    /* renamed from: u */
    private C17789a f4208u = null;

    /* renamed from: com.tencent.liteav.h$a */
    public interface C17789a {
        /* renamed from: a */
        void mo32936a(long j);

        /* renamed from: a */
        void mo32937a(SurfaceTexture surfaceTexture);

        /* renamed from: a */
        void mo32938a(C25648a c25648a);

        /* renamed from: a */
        void mo32939a(byte[] bArr, long j);
    }

    public C17788h(Context context, int i) {
        AppMethodBeat.m2504i(67721);
        this.f4188a = context;
        this.f4200m = i;
        C45104b.m82752a().mo72875a(this.f4188a);
        AppMethodBeat.m2505o(67721);
    }

    /* renamed from: a */
    public void mo32913a(C45115e c45115e) {
        AppMethodBeat.m2504i(67722);
        this.f4191d = c45115e;
        if (!(this.f4191d == null || this.f4194g == null)) {
            this.f4191d.mo72909a((C0946a) this);
        }
        if (!(this.f4191d == null || this.f4189b == null)) {
            this.f4191d.mo72905a(this.f4189b.f4175d);
        }
        AppMethodBeat.m2505o(67722);
    }

    /* renamed from: a */
    public void mo32907a(C0946a c0946a) {
        this.f4194g = c0946a;
    }

    /* renamed from: a */
    public void mo32910a(C17787g c17787g) {
        AppMethodBeat.m2504i(67723);
        this.f4189b = c17787g;
        m27776r();
        AppMethodBeat.m2505o(67723);
    }

    public void setID(String str) {
        AppMethodBeat.m2504i(67724);
        super.setID(str);
        if (this.f4191d != null) {
            this.f4191d.setID(getID());
        }
        AppMethodBeat.m2505o(67724);
    }

    /* renamed from: a */
    public void mo32911a(C17789a c17789a) {
        this.f4208u = c17789a;
    }

    /* renamed from: a */
    public void mo32914a(boolean z) {
        AppMethodBeat.m2504i(67725);
        this.f4195h = z;
        this.f4201n = true;
        if (this.f4191d != null) {
            this.f4191d.mo72910a((C8837f) this);
            this.f4191d.mo72916i();
            this.f4191d.setID(getID());
        }
        this.f4190c = new C8848b();
        this.f4190c.mo20006a(this.f4197j);
        this.f4190c.mo20011a((C37377d) this);
        this.f4190c.mo20009a((C0946a) this);
        this.f4193f = new C0943a();
        this.f4193f.mo3791a((C8791c) this);
        m27774c(this.f4195h);
        this.f4193f.mo3790a(this.f4196i);
        this.f4193f.mo3787a(this.f4188a);
        this.f4192e = new C17770a();
        this.f4192e.mo32871a((C25645b) this);
        this.f4192e.mo32868a();
        m27775q();
        m27776r();
        AppMethodBeat.m2505o(67725);
    }

    /* renamed from: a */
    public void mo32905a() {
        AppMethodBeat.m2504i(67726);
        this.f4195h = false;
        this.f4196i = 0;
        if (this.f4190c != null) {
            this.f4190c.mo20011a(null);
            this.f4190c.mo20009a(null);
            this.f4190c.mo20017c();
        }
        if (this.f4193f != null) {
            this.f4193f.mo3791a(null);
            this.f4193f.mo3786a();
        }
        if (this.f4192e != null) {
            this.f4192e.mo32871a(null);
            this.f4192e.mo32874b();
        }
        if (this.f4191d != null) {
            this.f4191d.mo72917j();
            this.f4191d.mo72910a(null);
        }
        AppMethodBeat.m2505o(67726);
    }

    /* renamed from: a */
    public void mo32908a(C25648a c25648a) {
        AppMethodBeat.m2504i(67727);
        if (this.f4193f != null) {
            this.f4193f.mo3788a(c25648a);
            AppMethodBeat.m2505o(67727);
            return;
        }
        TXCLog.m15679w("TXCRenderAndDec", "decAudio fail which audio play hasn't been created!");
        AppMethodBeat.m2505o(67727);
    }

    /* renamed from: a */
    public void mo32909a(C25649b c25649b) {
        AppMethodBeat.m2504i(67728);
        try {
            if (this.f4192e != null) {
                this.f4192e.mo32872a(c25649b);
            }
            AppMethodBeat.m2505o(67728);
        } catch (Exception e) {
            AppMethodBeat.m2505o(67728);
        }
    }

    /* renamed from: a */
    public void mo32906a(int i) {
        AppMethodBeat.m2504i(67729);
        if (this.f4191d != null) {
            this.f4191d.mo72912b(i);
        }
        AppMethodBeat.m2505o(67729);
    }

    /* renamed from: b */
    public void mo32917b(int i) {
        AppMethodBeat.m2504i(67730);
        if (this.f4191d != null) {
            this.f4191d.mo72914c(i);
        }
        AppMethodBeat.m2505o(67730);
    }

    /* renamed from: b */
    public void mo32919b(boolean z) {
        AppMethodBeat.m2504i(67731);
        if (this.f4193f != null) {
            this.f4193f.mo3802d(z);
        }
        AppMethodBeat.m2505o(67731);
    }

    /* renamed from: c */
    public void mo32921c(int i) {
        AppMethodBeat.m2504i(67732);
        this.f4196i = i;
        if (this.f4193f != null) {
            this.f4193f.mo3790a(this.f4196i);
        }
        AppMethodBeat.m2505o(67732);
    }

    /* renamed from: a */
    public static void m27772a(Context context, int i) {
        AppMethodBeat.m2504i(67733);
        C0943a.m2119a(context, i);
        AppMethodBeat.m2505o(67733);
    }

    /* renamed from: b */
    public long mo32916b() {
        AppMethodBeat.m2504i(67734);
        if (this.f4193f != null) {
            long b = this.f4193f.mo3794b();
            AppMethodBeat.m2505o(67734);
            return b;
        }
        AppMethodBeat.m2505o(67734);
        return 0;
    }

    /* renamed from: c */
    public long mo32920c() {
        AppMethodBeat.m2504i(67735);
        if (this.f4192e != null) {
            long d = this.f4192e.mo32877d();
            AppMethodBeat.m2505o(67735);
            return d;
        }
        AppMethodBeat.m2505o(67735);
        return 0;
    }

    /* renamed from: d */
    public long mo32923d() {
        AppMethodBeat.m2504i(67736);
        if (this.f4192e != null) {
            long e = this.f4192e.mo32878e();
            AppMethodBeat.m2505o(67736);
            return e;
        }
        AppMethodBeat.m2505o(67736);
        return 0;
    }

    /* renamed from: e */
    public int mo32924e() {
        AppMethodBeat.m2504i(67737);
        if (this.f4190c != null) {
            int d = this.f4190c.mo20018d();
            AppMethodBeat.m2505o(67737);
            return d;
        }
        AppMethodBeat.m2505o(67737);
        return 0;
    }

    /* renamed from: f */
    public long mo32925f() {
        AppMethodBeat.m2504i(67738);
        if (this.f4192e == null || this.f4193f == null) {
            AppMethodBeat.m2505o(67738);
            return 0;
        }
        long c = this.f4193f.mo3798c() - this.f4192e.mo32879f();
        AppMethodBeat.m2505o(67738);
        return c;
    }

    /* renamed from: g */
    public int mo32926g() {
        AppMethodBeat.m2504i(67739);
        if (this.f4193f != null) {
            int d = this.f4193f.mo3801d();
            AppMethodBeat.m2505o(67739);
            return d;
        }
        AppMethodBeat.m2505o(67739);
        return 0;
    }

    /* renamed from: h */
    public long mo32927h() {
        AppMethodBeat.m2504i(67740);
        if (this.f4193f == null || this.f4192e == null) {
            AppMethodBeat.m2505o(67740);
            return 0;
        }
        long e = this.f4193f.mo3803e() - this.f4192e.mo32881g();
        AppMethodBeat.m2505o(67740);
        return e;
    }

    /* renamed from: i */
    public float mo32928i() {
        AppMethodBeat.m2504i(67741);
        if (this.f4193f != null) {
            float f = this.f4193f.mo3804f();
            AppMethodBeat.m2505o(67741);
            return f;
        }
        AppMethodBeat.m2505o(67741);
        return 0.0f;
    }

    /* renamed from: j */
    public int mo32929j() {
        AppMethodBeat.m2504i(67742);
        if (this.f4192e != null) {
            int h = this.f4192e.mo32882h();
            AppMethodBeat.m2505o(67742);
            return h;
        }
        AppMethodBeat.m2505o(67742);
        return 0;
    }

    /* renamed from: k */
    public String mo32930k() {
        int g;
        AppMethodBeat.m2504i(67743);
        if (this.f4193f != null) {
            g = this.f4193f.mo3805g();
        } else {
            g = TXEAudioDef.TXE_AEC_NONE;
        }
        String str = g + " | " + this.f4202o;
        AppMethodBeat.m2505o(67743);
        return str;
    }

    /* renamed from: l */
    public void mo32931l() {
        long j = 0;
        AppMethodBeat.m2504i(67744);
        if (this.f4193f != null) {
            TXAudioJitterBufferReportInfo h = this.f4193f.mo3806h();
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
        if (this.f4192e != null) {
            setStatusValue(TXLiveConstants.PLAY_EVT_PLAY_END, Long.valueOf(mo32923d()));
            setStatusValue(6007, Long.valueOf(this.f4192e.mo32885k()));
            setStatusValue(6008, Long.valueOf(this.f4192e.mo32884j()));
            setStatusValue(6009, Long.valueOf(this.f4192e.mo32883i()));
        }
        if (this.f4190c != null) {
            if (this.f4190c.mo20014a()) {
                j = 1;
            }
            setStatusValue(ReaderCallback.SHOW_BAR, Long.valueOf(j));
        }
        AppMethodBeat.m2505o(67744);
    }

    /* renamed from: a */
    public boolean mo32915a(byte[] bArr) {
        synchronized (this) {
            this.f4198k = bArr;
        }
        return true;
    }

    /* renamed from: a */
    public void mo32912a(C8832o c8832o) {
        synchronized (this) {
            this.f4199l = c8832o;
        }
    }

    /* renamed from: c */
    private void m27773c(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(67745);
        C8848b c8848b = this.f4190c;
        if (c8848b != null) {
            c8848b.mo20012a(this.f4189b.f4180i);
            if (surfaceTexture != null) {
                c8848b.mo20003a(surfaceTexture, null, null, !this.f4195h);
                c8848b.mo20015b();
            }
        }
        AppMethodBeat.m2505o(67745);
    }

    /* renamed from: q */
    private void m27775q() {
        AppMethodBeat.m2504i(67746);
        m27773c(this.f4191d != null ? this.f4191d.mo60191a() : null);
        AppMethodBeat.m2505o(67746);
    }

    /* renamed from: r */
    private void m27776r() {
        AppMethodBeat.m2504i(67747);
        m27774c(this.f4195h);
        if (this.f4193f != null) {
            this.f4193f.mo3789a(this.f4189b.f4172a);
            this.f4193f.mo3792a(this.f4189b.f4178g);
            this.f4193f.mo3799c(this.f4189b.f4174c);
            this.f4193f.mo3795b(this.f4189b.f4173b);
            setStatusValue(2012, Long.valueOf((long) (this.f4189b.f4174c * 1000.0f)));
            setStatusValue(2013, Long.valueOf((long) (this.f4189b.f4173b * 1000.0f)));
            setStatusValue(2015, Long.valueOf(0));
        }
        if (this.f4192e != null) {
            this.f4192e.mo32869a(this.f4189b.f4174c);
        }
        if (this.f4190c != null && this.f4190c.mo20014a() && this.f4189b.f4174c < 0.3f && this.f4189b.f4173b < 0.3f) {
            this.f4189b.f4180i = false;
            this.f4190c.mo20017c();
            m27775q();
        }
        if (this.f4191d != null) {
            this.f4191d.mo72905a(this.f4189b.f4175d);
        }
        AppMethodBeat.m2505o(67747);
    }

    /* renamed from: c */
    private void m27774c(boolean z) {
        AppMethodBeat.m2504i(67748);
        if (z) {
            float f;
            float f2 = this.f4189b.f4174c;
            float f3 = this.f4189b.f4173b;
            if (f2 > this.f4204q) {
                f2 = this.f4204q;
            }
            if (f3 > this.f4205r) {
                f3 = this.f4205r;
            }
            if (f2 >= f3) {
                f = this.f4204q;
                f3 = this.f4205r;
            } else {
                f = f2;
            }
            this.f4189b.f4178g = true;
            this.f4189b.f4172a = f;
            this.f4189b.f4174c = f;
            this.f4189b.f4173b = f3;
            if (this.f4193f != null) {
                this.f4193f.mo3793a(true, this.f4188a);
                this.f4193f.mo3800c(true);
            }
        } else {
            TXCLog.m15676e("TXCRenderAndDec", "setupRealTimePlayParams current cache time : min-cache[" + this.f4189b.f4174c + "], max-cache[" + this.f4189b.f4173b + "], org-cache[" + this.f4189b.f4172a + "]");
            if (this.f4193f != null) {
                if (this.f4189b == null || !this.f4189b.f4179h) {
                    this.f4193f.mo3793a(false, this.f4188a);
                } else {
                    this.f4193f.mo3793a(true, this.f4188a);
                }
                this.f4193f.mo3800c(false);
            }
            if (this.f4189b.f4172a > this.f4189b.f4173b || this.f4189b.f4172a < this.f4189b.f4174c) {
                this.f4189b.f4172a = this.f4189b.f4173b;
            }
        }
        if (this.f4192e != null) {
            this.f4192e.mo32875b(z);
        }
        AppMethodBeat.m2505o(67748);
    }

    /* renamed from: a */
    private void m27771a(int i, String str) {
        AppMethodBeat.m2504i(67749);
        C0946a c0946a = this.f4194g;
        if (c0946a != null) {
            Bundle bundle = new Bundle();
            new StringBuilder("TXCRenderAndDec notifyEvent: mUserID  ").append(this.f4197j);
            bundle.putLong("EVT_USERID", this.f4197j);
            bundle.putInt("EVT_ID", i);
            bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
            if (str != null) {
                bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str);
            }
            c0946a.onNotifyEvent(i, bundle);
        }
        AppMethodBeat.m2505o(67749);
    }

    /* renamed from: s */
    private void m27777s() {
        AppMethodBeat.m2504i(67750);
        C8848b c8848b = this.f4190c;
        if (c8848b != null) {
            TXCLog.m15679w("TXCRenderAndDec", "switch to soft decoder when hw error");
            c8848b.mo20017c();
            this.f4189b.f4180i = false;
            m27774c(this.f4195h);
            m27775q();
        }
        AppMethodBeat.m2505o(67750);
    }

    /* renamed from: m */
    public void mo32932m() {
        AppMethodBeat.m2504i(67751);
        C8848b c8848b = this.f4190c;
        if (c8848b != null && c8848b.mo20019e()) {
            c8848b.mo20016b(true);
        }
        AppMethodBeat.m2505o(67751);
    }

    public void onNotifyEvent(int i, Bundle bundle) {
        AppMethodBeat.m2504i(67752);
        if (i == TXLiveConstants.PLAY_WARNING_HW_ACCELERATION_FAIL) {
            m27777s();
        } else if (i == 2003 && this.f4201n) {
            m27771a(2004, "视频播放开始");
            this.f4201n = false;
        }
        C0946a c0946a = this.f4194g;
        if (c0946a != null) {
            c0946a.onNotifyEvent(i, bundle);
        }
        AppMethodBeat.m2505o(67752);
    }

    /* renamed from: a */
    public void mo19969a(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(67753);
        m27773c(surfaceTexture);
        AppMethodBeat.m2505o(67753);
    }

    /* renamed from: b */
    public void mo19970b(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(67754);
        try {
            TXCLog.m15679w("TXCRenderAndDec", "play:stop decode when surface texture release");
            if (this.f4190c != null) {
                this.f4190c.mo20017c();
            }
            if (this.f4208u != null) {
                this.f4208u.mo32937a(surfaceTexture);
            }
            AppMethodBeat.m2505o(67754);
        } catch (Exception e) {
            AppMethodBeat.m2505o(67754);
        }
    }

    /* renamed from: n */
    public long mo32933n() {
        AppMethodBeat.m2504i(67755);
        try {
            if (this.f4193f != null) {
                long b = this.f4193f.mo3794b();
                AppMethodBeat.m2505o(67755);
                return b;
            }
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(67755);
        return 0;
    }

    /* renamed from: o */
    public long mo32934o() {
        AppMethodBeat.m2504i(67756);
        try {
            if (this.f4193f != null) {
                long c = this.f4193f.mo3798c();
                AppMethodBeat.m2505o(67756);
                return c;
            }
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(67756);
        return 0;
    }

    /* renamed from: b */
    public void mo32918b(C25649b c25649b) {
        AppMethodBeat.m2504i(67757);
        try {
            if (this.f4190c != null) {
                this.f4190c.mo20010a(c25649b);
                AppMethodBeat.m2505o(67757);
                return;
            }
            if (this.f4192e != null) {
                this.f4192e.mo32870a(c25649b.f5257g);
            }
            AppMethodBeat.m2505o(67757);
        } catch (Exception e) {
            AppMethodBeat.m2505o(67757);
        }
    }

    /* renamed from: c */
    public void mo32922c(C25649b c25649b) {
        AppMethodBeat.m2504i(67758);
        Bundle bundle = new Bundle();
        bundle.putByteArray(TXLiveConstants.EVT_GET_MSG, c25649b.f5251a);
        onNotifyEvent(2012, bundle);
        AppMethodBeat.m2505o(67758);
    }

    /* renamed from: p */
    public int mo32935p() {
        AppMethodBeat.m2504i(67759);
        try {
            if (this.f4190c != null) {
                int d = this.f4190c.mo20018d();
                AppMethodBeat.m2505o(67759);
                return d;
            }
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(67759);
        return 0;
    }

    /* renamed from: a */
    public void mo20008a(SurfaceTexture surfaceTexture, int i, int i2, long j, long j2) {
        AppMethodBeat.m2504i(67760);
        if (this.f4191d != null) {
            this.f4191d.mo72906a(surfaceTexture, i, i2);
            if (this.f4208u != null) {
                this.f4208u.mo32936a(j);
            }
            if (this.f4192e != null) {
                this.f4192e.mo32870a(j);
            }
        }
        AppMethodBeat.m2505o(67760);
    }

    /* renamed from: a */
    public void mo20007a(long j, int i, int i2, long j2, long j3) {
        AppMethodBeat.m2504i(67761);
        Object obj = null;
        if (!(this.f4199l == null || this.f4198k == null)) {
            synchronized (this) {
                try {
                    byte[] bArr = this.f4198k;
                    this.f4198k = null;
                    if (!(this.f4199l == null || bArr == null || this.f4190c == null)) {
                        if (bArr.length <= ((i * i2) * 3) / 2) {
                            this.f4190c.mo20013a(bArr, j, bArr.length);
                            this.f4199l.onVideoRawDataAvailable(bArr, i, i2, (int) j2);
                            obj = 1;
                        } else {
                            TXCLog.m15676e("TXCRenderAndDec", "raw data buffer length is too large");
                        }
                    }
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(67761);
                }
            }
        }
        if (obj == null) {
            if (j > 0 && this.f4191d != null) {
                this.f4191d.mo60194a(j, i, i2);
            }
            if (this.f4192e != null) {
                this.f4192e.mo32870a(j2);
            }
        }
        AppMethodBeat.m2505o(67761);
    }

    /* renamed from: a */
    public void mo20005a(int i, int i2) {
        AppMethodBeat.m2504i(67762);
        if (this.f4191d != null) {
            this.f4191d.mo72913b(i, i2);
        }
        Bundle bundle = new Bundle();
        bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, "分辨率改变");
        bundle.putInt("EVT_PARAM1", i);
        bundle.putInt("EVT_PARAM2", i2);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        onNotifyEvent(2009, bundle);
        AppMethodBeat.m2505o(67762);
    }

    public void onPlayAudioInfoChanged(C25648a c25648a, C25648a c25648a2) {
        AppMethodBeat.m2504i(67763);
        if (this.f4208u != null) {
            this.f4208u.mo32938a(c25648a2);
        }
        if (!(c25648a == null || c25648a2 == null)) {
            this.f4202o = c25648a.f5245a + "," + c25648a.f5246b + " | " + c25648a2.f5245a + "," + c25648a2.f5246b;
        }
        AppMethodBeat.m2505o(67763);
    }

    public void onPlayPcmData(byte[] bArr, long j) {
        AppMethodBeat.m2504i(67764);
        if (this.f4208u != null) {
            this.f4208u.mo32939a(bArr, j);
        }
        AppMethodBeat.m2505o(67764);
    }

    public void onPlayError(int i, String str) {
    }

    public void onPlayJitterStateNotify(int i) {
        AppMethodBeat.m2504i(67765);
        if (i == TXEAudioDef.TXE_AUDIO_JITTER_STATE_LOADING) {
            if (!(this.f4192e == null || this.f4195h)) {
                this.f4192e.mo32873a(true);
            }
            m27771a((int) TXLiveConstants.PLAY_EVT_PLAY_LOADING, "视频缓冲中...");
            AppMethodBeat.m2505o(67765);
        } else if (i == TXEAudioDef.TXE_AUDIO_JITTER_STATE_FIRST_LAODING) {
            m27771a((int) TXLiveConstants.PLAY_EVT_PLAY_LOADING, "视频缓冲中...");
            AppMethodBeat.m2505o(67765);
        } else if (i == TXEAudioDef.TXE_AUDIO_JITTER_STATE_PLAYING) {
            if (this.f4192e != null) {
                this.f4192e.mo32873a(false);
            }
            m27771a(2004, "视频播放开始");
            AppMethodBeat.m2505o(67765);
        } else {
            if (i == TXEAudioDef.TXE_AUDIO_JITTER_STATE_FIRST_PLAY) {
                if (this.f4192e != null) {
                    this.f4192e.mo32873a(false);
                }
                if (this.f4201n) {
                    m27771a(2004, "视频播放开始");
                    this.f4201n = false;
                }
            }
            AppMethodBeat.m2505o(67765);
        }
    }
}
