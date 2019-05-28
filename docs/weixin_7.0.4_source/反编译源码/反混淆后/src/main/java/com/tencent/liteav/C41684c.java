package com.tencent.liteav;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.liteav.C17762a.C8789b;
import com.tencent.liteav.audio.C45097e;
import com.tencent.liteav.audio.C8790b;
import com.tencent.liteav.audio.C8792d;
import com.tencent.liteav.audio.TXCLiveBGMPlayer;
import com.tencent.liteav.audio.TXEAudioDef;
import com.tencent.liteav.basic.datareport.C8795a;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.C32147a;
import com.tencent.liteav.basic.p1169f.C45104b;
import com.tencent.liteav.basic.p140d.C0946a;
import com.tencent.liteav.basic.p141e.C32143d;
import com.tencent.liteav.basic.p141e.C37354l;
import com.tencent.liteav.basic.p141e.C6268e;
import com.tencent.liteav.basic.p141e.C8802n;
import com.tencent.liteav.basic.p811g.C25649b;
import com.tencent.liteav.basic.p811g.C8803c;
import com.tencent.liteav.basic.util.C17778b;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.beauty.C37363c;
import com.tencent.liteav.beauty.C8812e;
import com.tencent.liteav.renderer.TXCGLSurfaceView;
import com.tencent.liteav.videoencoder.C0973b;
import com.tencent.liteav.videoencoder.C0982d;
import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import com.tencent.rtmp.TXLog;
import com.tencent.rtmp.p1423ui.TXCloudVideoView;
import com.tencent.ttpic.util.ActUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;

/* renamed from: com.tencent.liteav.c */
public class C41684c extends C32147a implements C8789b, C8792d, C0946a, C8812e, C37369l, C0982d {
    /* renamed from: d */
    private static final String f16960d = C41684c.class.getSimpleName();
    /* renamed from: A */
    private WeakReference<C0946a> f16961A;
    /* renamed from: B */
    private WeakReference<C45109m> f16962B;
    /* renamed from: C */
    private boolean f16963C = false;
    /* renamed from: D */
    private int f16964D = -1;
    /* renamed from: E */
    private int f16965E = -1;
    /* renamed from: a */
    C17762a f16966a;
    /* renamed from: b */
    C45097e f16967b = null;
    /* renamed from: c */
    OnBGMNotify f16968c = null;
    /* renamed from: e */
    private C45108k f16969e = null;
    /* renamed from: f */
    private C37363c f16970f = null;
    /* renamed from: g */
    private int f16971g = -1;
    /* renamed from: h */
    private TXSVideoEncoderParam f16972h = null;
    /* renamed from: i */
    private C0973b f16973i = null;
    /* renamed from: j */
    private Context f16974j = null;
    /* renamed from: k */
    private C25658f f16975k = null;
    /* renamed from: l */
    private int f16976l = 0;
    /* renamed from: m */
    private int f16977m = 0;
    /* renamed from: n */
    private int f16978n = 0;
    /* renamed from: o */
    private float f16979o = 1.0f;
    /* renamed from: p */
    private int f16980p = 0;
    /* renamed from: q */
    private float f16981q = 0.0f;
    /* renamed from: r */
    private TXCloudVideoView f16982r = null;
    /* renamed from: s */
    private Surface f16983s = null;
    /* renamed from: t */
    private int f16984t = 0;
    /* renamed from: u */
    private int f16985u = 0;
    /* renamed from: v */
    private C32143d f16986v = null;
    /* renamed from: w */
    private int f16987w = 0;
    /* renamed from: x */
    private C8803c f16988x;
    /* renamed from: y */
    private long f16989y = 0;
    /* renamed from: z */
    private C0962a f16990z = null;

    /* renamed from: com.tencent.liteav.c$4 */
    class C09614 implements Runnable {
        C09614() {
        }

        public void run() {
            AppMethodBeat.m2504i(67767);
            try {
                if (!(C41684c.this.f16966a == null || C41684c.this.f16969e == null || C41684c.this.f16974j == null)) {
                    C41684c.this.f16966a.mo32846a(C41684c.this.f16969e.mo43410f(), C41684c.this.f16974j, C41684c.this.f16975k.f5321t, C41684c.this.f16972h.width, C41684c.this.f16972h.height);
                }
                AppMethodBeat.m2505o(67767);
            } catch (Exception e) {
                AppMethodBeat.m2505o(67767);
            }
        }
    }

    /* renamed from: com.tencent.liteav.c$a */
    public interface C0962a {
        void onEncAudio(byte[] bArr, long j, int i, int i2);

        void onEncVideo(C25649b c25649b);

        void onEncVideoFormat(MediaFormat mediaFormat);

        void onRecordPcm(byte[] bArr, long j, int i, int i2, int i3);

        void onRecordRawPcm(byte[] bArr, long j, int i, int i2, int i3, boolean z);
    }

    /* renamed from: com.tencent.liteav.c$2 */
    class C88132 implements Runnable {
        C88132() {
        }

        public void run() {
            AppMethodBeat.m2504i(67096);
            C41684c.this.f16975k.mo43387a();
            if (C41684c.this.f16969e != null) {
                C41684c.this.f16969e.mo43405d(C41684c.this.f16975k.f5312k);
                C41684c.this.f16969e.mo43401b(false);
            }
            AppMethodBeat.m2505o(67096);
        }
    }

    /* renamed from: com.tencent.liteav.c$3 */
    class C88143 implements Runnable {
        C88143() {
        }

        public void run() {
            AppMethodBeat.m2504i(67095);
            if (C41684c.this.f16969e != null) {
                C41684c.this.f16969e.mo43392a(C41684c.this.f16975k.f5302a, C41684c.this.f16975k.f5303b);
                C41684c.this.f16969e.mo43405d(C41684c.this.f16975k.f5312k);
            }
            AppMethodBeat.m2505o(67095);
        }
    }

    /* renamed from: com.tencent.liteav.c$5 */
    class C88155 implements Runnable {
        C88155() {
        }

        public void run() {
            AppMethodBeat.m2504i(67447);
            C41684c.m73141a(C41684c.this, C41684c.this.f16972h.width, C41684c.this.f16972h.height);
            AppMethodBeat.m2505o(67447);
        }
    }

    /* renamed from: com.tencent.liteav.c$13 */
    class C2565613 implements Runnable {
        C2565613() {
        }

        public void run() {
            AppMethodBeat.m2504i(65996);
            C41684c.m73155h(C41684c.this);
            AppMethodBeat.m2505o(65996);
        }
    }

    /* renamed from: com.tencent.liteav.c$6 */
    class C321656 implements Runnable {
        C321656() {
        }

        public void run() {
            AppMethodBeat.m2504i(67446);
            if (C41684c.this.f16969e != null) {
                C41684c.this.f16969e.mo43401b(true);
            }
            C41684c.m73141a(C41684c.this, C41684c.this.f16972h.width, C41684c.this.f16972h.height);
            AppMethodBeat.m2505o(67446);
        }
    }

    /* renamed from: com.tencent.liteav.c$10 */
    class C4168210 implements C45097e {
        C4168210() {
        }

        /* renamed from: a */
        public void mo67227a() {
            AppMethodBeat.m2504i(66381);
            if (C41684c.this.f16968c != null) {
                C41684c.this.f16968c.onBGMStart();
            }
            AppMethodBeat.m2505o(66381);
        }

        /* renamed from: a */
        public void mo67228a(int i) {
            AppMethodBeat.m2504i(66382);
            if (C41684c.this.f16968c != null) {
                C41684c.this.f16968c.onBGMComplete(i);
            }
            AppMethodBeat.m2505o(66382);
        }

        /* renamed from: a */
        public void mo67229a(long j, long j2) {
            AppMethodBeat.m2504i(66383);
            if (C41684c.this.f16968c != null) {
                C41684c.this.f16968c.onBGMProgress(j, j2);
            }
            AppMethodBeat.m2505o(66383);
        }
    }

    static {
        AppMethodBeat.m2504i(66474);
        AppMethodBeat.m2505o(66474);
    }

    public C41684c(Context context) {
        AppMethodBeat.m2504i(66387);
        this.f16974j = context.getApplicationContext();
        this.f16975k = new C25658f();
        this.f16970f = new C37363c(this.f16974j, true);
        this.f16970f.mo60141a((C8812e) this);
        this.f16970f.mo60138a((C0946a) this);
        this.f16972h = new TXSVideoEncoderParam();
        this.f16973i = null;
        this.f16966a = new C17762a(this);
        C45104b.m82752a().mo72875a(this.f16974j);
        AppMethodBeat.m2505o(66387);
    }

    /* renamed from: a */
    public void mo67241a(C0962a c0962a) {
        this.f16990z = c0962a;
    }

    /* renamed from: a */
    public void mo67242a(C25658f c25658f) {
        Object obj = null;
        AppMethodBeat.m2504i(66388);
        int i = this.f16975k.f5312k;
        Object obj2 = (c25658f == null || (this.f16975k.f5321t == c25658f.f5321t && this.f16975k.f5322u == c25658f.f5322u && this.f16975k.f5323v == c25658f.f5323v)) ? null : 1;
        if (!(c25658f == null || (this.f16975k.f5325x == c25658f.f5325x && this.f16975k.f5326y == c25658f.f5326y && this.f16975k.f5327z == c25658f.f5327z && this.f16975k.f5290C == c25658f.f5290C && this.f16975k.f5288A == c25658f.f5288A && this.f16975k.f5289B == c25658f.f5289B))) {
            obj = 1;
        }
        if (c25658f != null) {
            try {
                this.f16975k = (C25658f) c25658f.clone();
            } catch (CloneNotSupportedException e) {
                this.f16975k = new C25658f();
            }
        } else {
            this.f16975k = new C25658f();
        }
        m73157k(i);
        if (mo67277i()) {
            m73159u();
            m73162x();
            if (this.f16969e != null) {
                this.f16969e.mo43403c(this.f16975k.f5313l);
            }
            if (obj2 != null) {
                m73160v();
            }
            if (obj != null) {
                m73161w();
            }
        }
        AppMethodBeat.m2505o(66388);
    }

    /* renamed from: a */
    public void mo67239a(C0946a c0946a) {
        AppMethodBeat.m2504i(66389);
        this.f16961A = new WeakReference(c0946a);
        AppMethodBeat.m2505o(66389);
    }

    /* renamed from: a */
    public void mo67248a(byte[] bArr) {
        AppMethodBeat.m2504i(66390);
        C8790b.m15606a().mo19841a(bArr);
        AppMethodBeat.m2505o(66390);
    }

    /* renamed from: a */
    public void mo67243a(C45109m c45109m) {
        AppMethodBeat.m2504i(66391);
        this.f16962B = new WeakReference(c45109m);
        AppMethodBeat.m2505o(66391);
    }

    /* renamed from: b */
    public int mo67249b() {
        return this.f16972h.width;
    }

    /* renamed from: c */
    public int mo67256c() {
        return this.f16972h.height;
    }

    public void setID(String str) {
        AppMethodBeat.m2504i(66392);
        super.setID(str);
        if (this.f16973i != null) {
            this.f16973i.setID(str);
        }
        if (this.f16970f != null) {
            this.f16970f.setID(str);
        }
        AppMethodBeat.m2505o(66392);
    }

    /* renamed from: d */
    public String mo67263d() {
        AppMethodBeat.m2504i(66393);
        String str = C8790b.m15606a().mo19850f() + " | " + C8790b.m15606a().mo19849e() + "," + C8790b.m15606a().mo19847d();
        AppMethodBeat.m2505o(66393);
        return str;
    }

    /* renamed from: e */
    public int mo67267e() {
        AppMethodBeat.m2504i(66394);
        if (mo67277i()) {
            TXCLog.m15679w(f16960d, "ignore startPush when pushing, status:" + this.f16977m);
            AppMethodBeat.m2505o(66394);
            return -2;
        }
        TXCDRApi.initCrashReport(this.f16974j);
        this.f16977m = 1;
        TXCLog.m15675d(f16960d, "startPusher");
        m73159u();
        C8790b.m15606a().mo19838a((C8792d) this);
        if ((this.f16975k != null && this.f16975k.f5293F) || this.f16976l == 1 || this.f16969e == null || this.f16969e.mo43406d()) {
            C8790b.m15606a().mo19834a(this.f16974j);
        } else if (this.f16969e != null) {
            this.f16969e.mo43409e(true);
        }
        m73162x();
        TXCDRApi.txReportDAU(this.f16974j, C8795a.f2588bw);
        AppMethodBeat.m2505o(66394);
        return 0;
    }

    /* renamed from: f */
    public void mo67271f() {
        AppMethodBeat.m2504i(66395);
        if (mo67277i()) {
            TXCLog.m15675d(f16960d, "stopPusher");
            this.f16977m = 0;
            C8790b.m15606a().mo19842b();
            C8790b.m15606a().mo19838a(null);
            mo67288s();
            this.f16981q = 0.0f;
            this.f16975k.f5296I = false;
            if (this.f16966a != null) {
                this.f16966a.mo32843a();
            }
            this.f16988x = null;
            AppMethodBeat.m2505o(66395);
            return;
        }
        TXCLog.m15679w(f16960d, "ignore stopPush when not pushing, status:" + this.f16977m);
        AppMethodBeat.m2505o(66395);
    }

    /* renamed from: g */
    public void mo67273g() {
        AppMethodBeat.m2504i(66396);
        if (this.f16977m != 1) {
            TXCLog.m15679w(f16960d, "ignore pause push when is not pushing, status:" + this.f16977m);
            AppMethodBeat.m2505o(66396);
            return;
        }
        this.f16977m = 2;
        TXCLog.m15675d(f16960d, "pausePusher");
        if ((this.f16975k.f5324w & 1) == 1) {
            if (!(this.f16966a == null || this.f16975k.f5293F || this.f16969e == null)) {
                this.f16966a.mo32845a(this.f16975k.f5323v, this.f16975k.f5322u, this.f16975k.f5321t, this.f16972h.width, this.f16972h.height);
            }
            if (this.f16969e != null) {
                this.f16969e.mo43402c();
            }
        }
        if ((this.f16975k.f5324w & 2) == 2) {
            C8790b.m15606a().mo19845c(true);
        }
        AppMethodBeat.m2505o(66396);
    }

    /* renamed from: h */
    public void mo67275h() {
        AppMethodBeat.m2504i(66397);
        if (this.f16977m != 2) {
            TXCLog.m15679w(f16960d, "ignore resume push when is not pause, status:" + this.f16977m);
            AppMethodBeat.m2505o(66397);
            return;
        }
        this.f16977m = 1;
        TXCLog.m15675d(f16960d, "resumePusher");
        if ((this.f16975k.f5324w & 1) == 1) {
            if (!(this.f16966a == null || this.f16975k.f5293F)) {
                this.f16966a.mo32843a();
            }
            if (this.f16969e != null) {
                this.f16969e.mo43399b();
            }
            m73161w();
        }
        if ((this.f16975k.f5324w & 2) == 2) {
            C8790b.m15606a().mo19845c(this.f16963C);
            if ((this.f16975k.f5298K & 1) == 0) {
                C8790b.m15606a().mo19842b();
                C8790b.m15606a().mo19836a(this.f16975k.f5318q);
                C8790b.m15606a().mo19840a(this.f16975k.f5320s, this.f16974j);
                C8790b.m15606a().mo19848d(this.f16980p);
                C8790b.m15606a().mo19837a(this.f16964D, this.f16965E);
                C8790b.m15606a().mo19835a(this.f16979o);
                C8790b.m15606a().mo19845c(this.f16963C);
                C8790b.m15606a().mo19838a((C8792d) this);
                C8790b.m15606a().mo19834a(this.f16974j);
            }
        }
        AppMethodBeat.m2505o(66397);
    }

    /* renamed from: a */
    public void mo67236a(final int i, final int i2, final int i3) {
        AppMethodBeat.m2504i(66398);
        if (this.f16969e == null) {
            AppMethodBeat.m2505o(66398);
            return;
        }
        this.f16969e.mo43396a(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(66385);
                if (!(i2 == 0 || i3 == 0)) {
                    C41684c.this.f16975k.f5302a = i2;
                    C41684c.this.f16975k.f5303b = i3;
                    if (C41684c.this.f16969e != null) {
                        C41684c.this.f16969e.mo43392a(i2, i3);
                    }
                }
                if (!(i == 0 || C41684c.this.f16973i == null)) {
                    C41684c.this.f16975k.f5304c = i;
                    C41684c.this.f16973i.mo3921a(i);
                }
                AppMethodBeat.m2505o(66385);
            }
        });
        AppMethodBeat.m2505o(66398);
    }

    /* renamed from: i */
    public boolean mo67277i() {
        return this.f16977m != 0;
    }

    /* renamed from: j */
    public void mo67279j() {
        AppMethodBeat.m2504i(66399);
        if (this.f16969e == null) {
            AppMethodBeat.m2505o(66399);
            return;
        }
        this.f16969e.mo43396a(new C321656());
        AppMethodBeat.m2505o(66399);
    }

    /* renamed from: a */
    public void mo67245a(TXCloudVideoView tXCloudVideoView) {
        AppMethodBeat.m2504i(66400);
        if (this.f16975k.f5293F) {
            TXCLog.m15676e(f16960d, "enable pure audio push , so can not start preview!");
            AppMethodBeat.m2505o(66400);
            return;
        }
        C37354l gLSurfaceView;
        if (tXCloudVideoView != null) {
            gLSurfaceView = tXCloudVideoView.getGLSurfaceView();
            if (gLSurfaceView == null) {
                gLSurfaceView = new TXCGLSurfaceView(tXCloudVideoView.getContext());
                tXCloudVideoView.addVideoView((TXCGLSurfaceView) gLSurfaceView);
            }
        } else {
            gLSurfaceView = new C6268e();
        }
        this.f16976l = 0;
        this.f16969e = new C46873b(this.f16974j, this.f16975k, gLSurfaceView);
        this.f16969e.mo43395a((C37369l) this);
        this.f16969e.mo43393a((C0946a) this);
        this.f16969e.mo43389a();
        this.f16969e.mo43400b(this.f16978n);
        this.f16982r = tXCloudVideoView;
        if (this.f16982r != null) {
            this.f16982r.start(this.f16975k.f5291D, this.f16975k.f5292E, this.f16969e);
        }
        AppMethodBeat.m2505o(66400);
    }

    /* renamed from: a */
    public void mo67247a(boolean z) {
        AppMethodBeat.m2504i(66401);
        if (this.f16969e == null) {
            AppMethodBeat.m2505o(66401);
            return;
        }
        this.f16969e.mo43397a(z);
        this.f16969e = null;
        if (this.f16982r != null) {
            this.f16982r.stop(z);
            this.f16982r = null;
        }
        this.f16983s = null;
        if (this.f16986v != null) {
            this.f16986v.mo52730a();
            this.f16986v = null;
        }
        AppMethodBeat.m2505o(66401);
    }

    /* renamed from: a */
    public void mo67238a(Surface surface) {
        AppMethodBeat.m2504i(66402);
        if (this.f16982r != null) {
            TXCLog.m15679w(f16960d, "camera preview view is not null, can't set surface");
            AppMethodBeat.m2505o(66402);
            return;
        }
        this.f16983s = surface;
        AppMethodBeat.m2505o(66402);
    }

    /* renamed from: a */
    public void mo67235a(final int i, final int i2) {
        AppMethodBeat.m2504i(66403);
        if (this.f16986v != null) {
            this.f16986v.mo52733a(new Runnable() {
                public void run() {
                    AppMethodBeat.m2504i(66384);
                    C41684c.this.f16984t = i;
                    C41684c.this.f16985u = i2;
                    if (!(C41684c.this.f16988x == null || C41684c.this.f16986v == null)) {
                        C41684c.m73142a(C41684c.this, C41684c.this.f16988x, true);
                    }
                    AppMethodBeat.m2505o(66384);
                }
            });
            AppMethodBeat.m2505o(66403);
            return;
        }
        this.f16984t = i;
        this.f16985u = i2;
        AppMethodBeat.m2505o(66403);
    }

    /* renamed from: a */
    public void mo67240a(final C8802n c8802n) {
        AppMethodBeat.m2504i(66404);
        if (this.f16982r != null) {
            TXCGLSurfaceView gLSurfaceView = this.f16982r.getGLSurfaceView();
            if (gLSurfaceView != null) {
                gLSurfaceView.mo52803a(new C8802n() {
                    public void onTakePhotoComplete(Bitmap bitmap) {
                        AppMethodBeat.m2504i(66386);
                        if (c8802n != null) {
                            c8802n.onTakePhotoComplete(bitmap);
                        }
                        AppMethodBeat.m2505o(66386);
                    }
                });
            }
            AppMethodBeat.m2505o(66404);
            return;
        }
        if (this.f16986v != null) {
            this.f16986v.mo52732a(new C8802n() {
                public void onTakePhotoComplete(Bitmap bitmap) {
                    AppMethodBeat.m2504i(67151);
                    if (c8802n != null) {
                        c8802n.onTakePhotoComplete(bitmap);
                    }
                    AppMethodBeat.m2505o(67151);
                }
            });
        }
        AppMethodBeat.m2505o(66404);
    }

    /* renamed from: k */
    public void mo67281k() {
        AppMethodBeat.m2504i(66405);
        if (VERSION.SDK_INT < 21) {
            Bundle bundle = new Bundle();
            bundle.putString(TXLiveConstants.EVT_DESCRIPTION, "录屏失败,不支持的Android系统版本,需要5.0以上的系统");
            onNotifyEvent(TXLiveConstants.PUSH_ERR_SCREEN_CAPTURE_UNSURPORT, bundle);
            TXLog.m71029e(f16960d, "Screen capture need running on Android Lollipop or higher version, current:" + VERSION.SDK_INT);
            AppMethodBeat.m2505o(66405);
            return;
        }
        this.f16976l = 1;
        this.f16969e = new C25659i(this.f16974j, this.f16975k);
        this.f16969e.mo43393a((C0946a) this);
        this.f16969e.mo43395a((C37369l) this);
        this.f16969e.mo43389a();
        TXCDRApi.txReportDAU(this.f16974j, C8795a.f2513aL);
        AppMethodBeat.m2505o(66405);
    }

    /* renamed from: l */
    public void mo67282l() {
        AppMethodBeat.m2504i(66406);
        if (this.f16969e == null) {
            AppMethodBeat.m2505o(66406);
            return;
        }
        mo67288s();
        this.f16969e.mo43397a(false);
        this.f16969e = null;
        AppMethodBeat.m2505o(66406);
    }

    /* renamed from: a */
    public void mo67234a(int i) {
        AppMethodBeat.m2504i(66407);
        this.f16978n = i;
        if (this.f16969e == null) {
            AppMethodBeat.m2505o(66407);
            return;
        }
        this.f16969e.mo43400b(i);
        AppMethodBeat.m2505o(66407);
    }

    /* renamed from: b */
    public boolean mo67255b(boolean z) {
        AppMethodBeat.m2504i(66408);
        if (this.f16969e == null) {
            AppMethodBeat.m2505o(66408);
            return false;
        }
        boolean d = this.f16969e.mo43407d(z);
        AppMethodBeat.m2505o(66408);
        return d;
    }

    /* renamed from: b */
    public boolean mo67253b(int i, int i2, int i3) {
        AppMethodBeat.m2504i(66409);
        if (this.f16970f != null) {
            this.f16970f.mo60148c(i);
            this.f16970f.mo60149d(i2);
            this.f16970f.mo60150e(i3);
        }
        AppMethodBeat.m2505o(66409);
        return true;
    }

    /* renamed from: b */
    public void mo67251b(int i) {
        AppMethodBeat.m2504i(66410);
        if (this.f16970f != null) {
            this.f16970f.mo60146b(i);
        }
        AppMethodBeat.m2505o(66410);
    }

    /* renamed from: a */
    public void mo67237a(Bitmap bitmap) {
        AppMethodBeat.m2504i(66411);
        if (this.f16970f != null) {
            this.f16970f.mo60136a(bitmap);
        }
        AppMethodBeat.m2505o(66411);
    }

    /* renamed from: a */
    public void mo67246a(String str) {
        AppMethodBeat.m2504i(66412);
        if (this.f16970f != null) {
            this.f16970f.mo60142a(str);
        }
        AppMethodBeat.m2505o(66412);
    }

    /* renamed from: c */
    public void mo67260c(boolean z) {
        AppMethodBeat.m2504i(66413);
        if (this.f16970f != null) {
            this.f16970f.mo60147b(z);
        }
        AppMethodBeat.m2505o(66413);
    }

    @TargetApi(18)
    /* renamed from: b */
    public boolean mo67254b(String str) {
        AppMethodBeat.m2504i(66414);
        if (this.f16970f != null) {
            boolean a = this.f16970f.mo60145a(str, true);
            AppMethodBeat.m2505o(66414);
            return a;
        }
        AppMethodBeat.m2505o(66414);
        return false;
    }

    /* renamed from: c */
    public void mo67259c(int i) {
        AppMethodBeat.m2504i(66415);
        if (this.f16970f != null) {
            this.f16970f.mo60152g(i);
        }
        AppMethodBeat.m2505o(66415);
    }

    /* renamed from: d */
    public void mo67264d(int i) {
        AppMethodBeat.m2504i(66416);
        if (this.f16970f != null) {
            this.f16970f.mo60153h(i);
        }
        AppMethodBeat.m2505o(66416);
    }

    /* renamed from: a */
    public void mo67232a(float f) {
        AppMethodBeat.m2504i(66417);
        if (this.f16970f != null) {
            this.f16970f.mo60133a(f);
        }
        AppMethodBeat.m2505o(66417);
    }

    /* renamed from: e */
    public void mo67268e(int i) {
        AppMethodBeat.m2504i(66418);
        if (this.f16970f != null) {
            this.f16970f.mo60154i(i);
        }
        AppMethodBeat.m2505o(66418);
    }

    /* renamed from: f */
    public void mo67272f(int i) {
        AppMethodBeat.m2504i(66419);
        if (this.f16970f != null) {
            this.f16970f.mo60155j(i);
        }
        AppMethodBeat.m2505o(66419);
    }

    /* renamed from: g */
    public void mo67274g(int i) {
        AppMethodBeat.m2504i(66420);
        if (this.f16970f != null) {
            this.f16970f.mo60156k(i);
        }
        AppMethodBeat.m2505o(66420);
    }

    /* renamed from: h */
    public void mo67276h(int i) {
        AppMethodBeat.m2504i(66421);
        if (this.f16970f != null) {
            this.f16970f.mo60157l(i);
        }
        AppMethodBeat.m2505o(66421);
    }

    /* renamed from: d */
    public void mo67265d(boolean z) {
        AppMethodBeat.m2504i(66422);
        this.f16963C = z;
        C8790b.m15606a().mo19845c(z);
        AppMethodBeat.m2505o(66422);
    }

    /* renamed from: m */
    public boolean mo67283m() {
        return this.f16963C;
    }

    /* renamed from: b */
    public void mo67252b(int i, int i2) {
        AppMethodBeat.m2504i(66423);
        this.f16964D = i;
        this.f16965E = i2;
        C8790b.m15606a().mo19837a(i, i2);
        AppMethodBeat.m2505o(66423);
    }

    /* renamed from: b */
    public void mo67250b(float f) {
        AppMethodBeat.m2504i(66424);
        this.f16981q = f;
        TXCLiveBGMPlayer.getInstance().setPitch(f);
        AppMethodBeat.m2505o(66424);
    }

    /* renamed from: n */
    public int mo67284n() {
        AppMethodBeat.m2504i(66425);
        if (this.f16969e == null) {
            AppMethodBeat.m2505o(66425);
            return 0;
        }
        int e = this.f16969e.mo43408e();
        AppMethodBeat.m2505o(66425);
        return e;
    }

    /* renamed from: i */
    public boolean mo67278i(int i) {
        AppMethodBeat.m2504i(66426);
        if (this.f16969e == null) {
            AppMethodBeat.m2505o(66426);
            return false;
        }
        boolean a = this.f16969e.mo43398a(i);
        AppMethodBeat.m2505o(66426);
        return a;
    }

    /* renamed from: e */
    public boolean mo67270e(boolean z) {
        AppMethodBeat.m2504i(66427);
        if (this.f16969e == null) {
            AppMethodBeat.m2505o(66427);
            return false;
        }
        this.f16969e.mo43404c(z);
        AppMethodBeat.m2505o(66427);
        return true;
    }

    /* renamed from: c */
    public void mo67258c(float f) {
        AppMethodBeat.m2504i(66428);
        if (this.f16969e == null) {
            AppMethodBeat.m2505o(66428);
            return;
        }
        this.f16969e.mo43390a(f);
        AppMethodBeat.m2505o(66428);
    }

    /* renamed from: j */
    public void mo67280j(int i) {
        AppMethodBeat.m2504i(66429);
        this.f16980p = i;
        C8790b.m15606a().mo19848d(i);
        TXCDRApi.txReportDAU(this.f16974j, C8795a.f2506aE);
        AppMethodBeat.m2505o(66429);
    }

    /* renamed from: b */
    private void m73146b(int i, String str) {
        AppMethodBeat.m2504i(66430);
        Bundle bundle = new Bundle();
        bundle.putLong("EVT_USERID", this.f16989y);
        bundle.putInt("EVT_ID", i);
        bundle.putLong("EVT_TIME", TXCTimeUtil.getTimeTick());
        if (str != null) {
            bundle.putCharSequence(TXLiveConstants.EVT_DESCRIPTION, str);
        }
        C17778b.m27742a(this.f16961A, i, bundle);
        AppMethodBeat.m2505o(66430);
    }

    /* renamed from: c */
    public boolean mo67261c(String str) {
        AppMethodBeat.m2504i(66431);
        if (C8790b.m15606a().mo19846c()) {
            TXCDRApi.txReportDAU(this.f16974j, C8795a.f2507aF);
            boolean startPlay = TXCLiveBGMPlayer.getInstance().startPlay(str, C8790b.m15606a().mo19850f());
            AppMethodBeat.m2505o(66431);
            return startPlay;
        }
        AppMethodBeat.m2505o(66431);
        return false;
    }

    /* renamed from: o */
    public boolean mo67285o() {
        AppMethodBeat.m2504i(66432);
        TXCLiveBGMPlayer.getInstance().stopPlay();
        AppMethodBeat.m2505o(66432);
        return true;
    }

    /* renamed from: p */
    public boolean mo67286p() {
        AppMethodBeat.m2504i(66433);
        TXCLiveBGMPlayer.getInstance().pause();
        AppMethodBeat.m2505o(66433);
        return true;
    }

    /* renamed from: q */
    public boolean mo67287q() {
        AppMethodBeat.m2504i(66434);
        TXCLiveBGMPlayer.getInstance().resume();
        AppMethodBeat.m2505o(66434);
        return true;
    }

    /* renamed from: d */
    public boolean mo67266d(float f) {
        AppMethodBeat.m2504i(66435);
        this.f16979o = f;
        C8790b.m15606a().mo19835a(f);
        AppMethodBeat.m2505o(66435);
        return true;
    }

    /* renamed from: e */
    public boolean mo67269e(float f) {
        AppMethodBeat.m2504i(66436);
        TXCLiveBGMPlayer.getInstance().setVolume(f);
        AppMethodBeat.m2505o(66436);
        return true;
    }

    /* renamed from: d */
    public int mo67262d(String str) {
        AppMethodBeat.m2504i(66437);
        int musicDuration = (int) TXCLiveBGMPlayer.getInstance().getMusicDuration(str);
        AppMethodBeat.m2505o(66437);
        return musicDuration;
    }

    /* renamed from: a */
    public void mo67244a(OnBGMNotify onBGMNotify) {
        AppMethodBeat.m2504i(66438);
        if (onBGMNotify == null) {
            this.f16967b = null;
            this.f16968c = null;
            TXCLiveBGMPlayer.getInstance().setOnPlayListener(null);
            AppMethodBeat.m2505o(66438);
            return;
        }
        this.f16968c = onBGMNotify;
        if (this.f16967b == null) {
            this.f16967b = new C4168210();
        }
        TXCLiveBGMPlayer.getInstance().setOnPlayListener(this.f16967b);
        AppMethodBeat.m2505o(66438);
    }

    /* renamed from: a */
    public int mo67231a(byte[] bArr, int i, int i2, int i3) {
        AppMethodBeat.m2504i(66439);
        int a = m73136a(i2, i3, null);
        if (a != 0) {
            AppMethodBeat.m2505o(66439);
            return a;
        }
        if (this.f16973i != null) {
            this.f16973i.mo3918a(bArr, i, i2, i3, TXCTimeUtil.getTimeTick());
        }
        AppMethodBeat.m2505o(66439);
        return 0;
    }

    /* renamed from: c */
    public int mo67257c(int i, int i2, int i3) {
        AppMethodBeat.m2504i(66440);
        int a = m73136a(i2, i3, ((EGL10) EGLContext.getEGL()).eglGetCurrentContext());
        if (a != 0) {
            AppMethodBeat.m2505o(66440);
            return a;
        }
        if (this.f16973i != null) {
            this.f16973i.mo3917a(i, i2, i3, TXCTimeUtil.getTimeTick());
        }
        AppMethodBeat.m2505o(66440);
        return 0;
    }

    /* renamed from: a */
    public void mo19857a(byte[] bArr, long j, int i, int i2, int i3, boolean z) {
        AppMethodBeat.m2504i(66441);
        C0962a c0962a = this.f16990z;
        if (c0962a != null) {
            c0962a.onRecordRawPcm(bArr, j, i, i2, i3, z);
        }
        AppMethodBeat.m2505o(66441);
    }

    /* renamed from: a */
    public void mo19856a(byte[] bArr, long j, int i, int i2, int i3) {
        AppMethodBeat.m2504i(66442);
        C0962a c0962a = this.f16990z;
        if (c0962a != null) {
            c0962a.onRecordPcm(bArr, j, i, i2, i3);
        }
        AppMethodBeat.m2505o(66442);
    }

    /* renamed from: b */
    public void mo19858b(byte[] bArr, long j, int i, int i2, int i3) {
        AppMethodBeat.m2504i(66443);
        C0962a c0962a = this.f16990z;
        if (c0962a != null) {
            c0962a.onEncAudio(bArr, j, i, i2);
        }
        AppMethodBeat.m2505o(66443);
    }

    /* renamed from: a */
    public void mo19855a(int i, String str) {
        AppMethodBeat.m2504i(66444);
        TXCLog.m15676e(f16960d, "onRecordError code = " + i + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + str);
        if (i == TXEAudioDef.TXE_AUDIO_RECORD_ERR_NO_MIC_PERMIT) {
            m73146b((int) TXLiveConstants.PUSH_ERR_OPEN_MIC_FAIL, "打开麦克风失败");
        }
        AppMethodBeat.m2505o(66444);
    }

    /* renamed from: a */
    public int mo19911a(C8803c c8803c) {
        AppMethodBeat.m2504i(66445);
        if (this.f16962B != null) {
            C45109m c45109m = (C45109m) this.f16962B.get();
            if (c45109m != null) {
                c8803c.f2652a = c45109m.onTextureCustomProcess(c8803c.f2652a, c8803c.f2655d, c8803c.f2656e);
            }
        }
        m73140a(c8803c, false);
        int i = c8803c.f2652a;
        AppMethodBeat.m2505o(66445);
        return i;
    }

    /* renamed from: a */
    public void mo19912a(C8803c c8803c, long j) {
        AppMethodBeat.m2504i(66446);
        m73151d(c8803c.f2652a, c8803c.f2655d, c8803c.f2656e);
        AppMethodBeat.m2505o(66446);
    }

    /* renamed from: a */
    public void mo19913a(byte[] bArr, int i, int i2, int i3, long j) {
    }

    /* renamed from: a */
    public void mo3950a(C25649b c25649b, int i) {
        AppMethodBeat.m2504i(66447);
        if (i == 0) {
            C0962a c0962a = this.f16990z;
            if (!(c0962a == null || c25649b == null)) {
                c0962a.onEncVideo(c25649b);
            }
            AppMethodBeat.m2505o(66447);
            return;
        }
        if (i == 10000004 && this.f16971g == 1) {
            this.f16975k.f5311j = 0;
            m73146b(1103, "硬编码启动失败,采用软编码");
        }
        AppMethodBeat.m2505o(66447);
    }

    /* renamed from: a */
    public void mo3949a(MediaFormat mediaFormat) {
        AppMethodBeat.m2504i(66448);
        C0962a c0962a = this.f16990z;
        if (c0962a != null) {
            c0962a.onEncVideoFormat(mediaFormat);
        }
        AppMethodBeat.m2505o(66448);
    }

    public void onNotifyEvent(int i, Bundle bundle) {
        AppMethodBeat.m2504i(66449);
        if (bundle != null) {
            bundle.putLong("EVT_USERID", this.f16989y);
        }
        C17778b.m27742a(this.f16961A, i, bundle);
        AppMethodBeat.m2505o(66449);
    }

    /* renamed from: a */
    public void mo19832a(Bitmap bitmap, ByteBuffer byteBuffer, int i, int i2) {
        AppMethodBeat.m2504i(66450);
        if (this.f16969e != null) {
            final Bitmap bitmap2 = bitmap;
            final int i3 = i;
            final int i4 = i2;
            final ByteBuffer byteBuffer2 = byteBuffer;
            this.f16969e.mo43396a(new Runnable() {
                public void run() {
                    AppMethodBeat.m2504i(67654);
                    try {
                        int width = bitmap2.getWidth();
                        int height = bitmap2.getHeight();
                        C41684c.this.f16970f.mo60139a(C17778b.m27738a(width, height, i3, i4));
                        C41684c.this.f16970f.mo60143a(false);
                        C41684c.this.f16970f.mo60135a(i3, i4);
                        C41684c.this.f16970f.mo60134a(0);
                        C41684c.this.f16970f.mo60131a(byteBuffer2.array(), width, height, 0, 2, 0);
                        AppMethodBeat.m2505o(67654);
                    } catch (Exception e) {
                        AppMethodBeat.m2505o(67654);
                    }
                }
            });
        }
        AppMethodBeat.m2505o(66450);
    }

    /* renamed from: a */
    public void mo19833a(final C0973b c0973b) {
        AppMethodBeat.m2504i(66451);
        if (this.f16969e != null) {
            this.f16969e.mo43396a(new Runnable() {
                public void run() {
                    AppMethodBeat.m2504i(67705);
                    try {
                        if (c0973b != null) {
                            c0973b.mo3920a();
                            c0973b.mo3923a(null);
                        }
                        AppMethodBeat.m2505o(67705);
                    } catch (Exception e) {
                        AppMethodBeat.m2505o(67705);
                    }
                }
            });
            AppMethodBeat.m2505o(66451);
            return;
        }
        if (c0973b != null) {
            try {
                c0973b.mo3920a();
                c0973b.mo3923a(null);
            } catch (Exception e) {
                AppMethodBeat.m2505o(66451);
                return;
            }
        }
        AppMethodBeat.m2505o(66451);
    }

    /* renamed from: a */
    public void mo19831a() {
        AppMethodBeat.m2504i(66452);
        C8790b.m15606a().mo19842b();
        C8790b.m15606a().mo19838a(null);
        AppMethodBeat.m2505o(66452);
    }

    /* renamed from: a */
    public void mo60181a(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(66453);
        if (this.f16970f != null) {
            this.f16970f.mo60132a();
        }
        AppMethodBeat.m2505o(66453);
    }

    /* renamed from: b */
    public void mo60182b(C8803c c8803c) {
        AppMethodBeat.m2504i(66454);
        if (!(this.f16970f == null || this.f16975k.f5293F || this.f16969e == null)) {
            if (!(this.f16972h.height == c8803c.f2658g && this.f16972h.width == c8803c.f2657f)) {
                m73150d(c8803c.f2657f, c8803c.f2658g);
            }
            this.f16987w = c8803c.f2661j;
            this.f16970f.mo60130a(c8803c, c8803c.f2653b, 0);
        }
        AppMethodBeat.m2505o(66454);
    }

    /* renamed from: r */
    public void mo60183r() {
        AppMethodBeat.m2504i(66455);
        if (this.f16970f != null) {
            this.f16970f.mo60132a();
        }
        m73158t();
        if (this.f16962B != null) {
            C45109m c45109m = (C45109m) this.f16962B.get();
            if (c45109m != null) {
                c45109m.onTextureDestoryed();
            }
        }
        AppMethodBeat.m2505o(66455);
    }

    /* renamed from: a */
    private void m73139a(int i, int i2, int i3, EGLContext eGLContext) {
        Object eGLContext2;
        int i4;
        AppMethodBeat.m2504i(66456);
        TXCLog.m15675d(f16960d, "New encode size width = " + i + " height = " + i2 + " encType = " + i3);
        m73158t();
        this.f16971g = i3;
        this.f16973i = new C0973b(this.f16971g);
        if ((this.f16975k.f5298K & 2) != 2) {
            eGLContext2 = this.f16969e != null ? this.f16969e.mo43410f() : null;
        } else if (eGLContext2 == null) {
            eGLContext2 = this.f16973i.mo3919a(i, i2);
        }
        this.f16972h.width = i;
        this.f16972h.height = i2;
        this.f16972h.fps = this.f16975k.f5309h;
        this.f16972h.gop = this.f16975k.f5310i;
        TXSVideoEncoderParam tXSVideoEncoderParam = this.f16972h;
        if (this.f16975k.f5315n) {
            i4 = 3;
        } else {
            i4 = 1;
        }
        tXSVideoEncoderParam.encoderProfile = i4;
        this.f16972h.encoderMode = 1;
        this.f16972h.glContext = eGLContext2;
        this.f16972h.realTime = this.f16975k.f5296I;
        this.f16973i.mo3923a((C0982d) this);
        this.f16973i.mo3922a((C0946a) this);
        this.f16973i.mo3916a(this.f16972h);
        this.f16973i.mo3921a(this.f16975k.f5304c);
        this.f16973i.setID(getID());
        AppMethodBeat.m2505o(66456);
    }

    /* renamed from: d */
    private void m73151d(int i, int i2, int i3) {
        AppMethodBeat.m2504i(66457);
        m73145b(i2, i3, null);
        if (this.f16973i != null) {
            this.f16973i.mo3917a(i, i2, i3, TXCTimeUtil.getTimeTick());
        }
        AppMethodBeat.m2505o(66457);
    }

    /* renamed from: a */
    private int m73136a(int i, int i2, EGLContext eGLContext) {
        AppMethodBeat.m2504i(66458);
        if (this.f16975k == null) {
            AppMethodBeat.m2505o(66458);
            return -5;
        }
        int i3;
        int i4;
        switch (this.f16975k.f5312k) {
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
                TXCLog.m15676e(f16960d, "sendCustomYUVData: invalid video_resolution");
                AppMethodBeat.m2505o(66458);
                return -1;
        }
        if (i4 > i || i3 > i2) {
            AppMethodBeat.m2505o(66458);
            return -4;
        } else if (this.f16975k.f5293F) {
            m73158t();
            AppMethodBeat.m2505o(66458);
            return -1000;
        } else {
            m73145b(i4, i3, eGLContext);
            AppMethodBeat.m2505o(66458);
            return 0;
        }
    }

    /* renamed from: b */
    private void m73145b(int i, int i2, EGLContext eGLContext) {
        int i3 = 2;
        int i4 = 1;
        AppMethodBeat.m2504i(66459);
        switch (this.f16975k.f5311j) {
            case 1:
                i3 = 1;
                break;
            case 2:
                i3 = 3;
                break;
        }
        if (this.f16976l != 1) {
            i4 = i3;
        }
        i3 = this.f16975k.f5310i;
        if (!(this.f16973i != null && this.f16972h.width == i && this.f16972h.height == i2 && this.f16971g == i4 && this.f16972h.gop == i3)) {
            m73139a(i, i2, i4, eGLContext);
        }
        AppMethodBeat.m2505o(66459);
    }

    /* renamed from: s */
    public void mo67288s() {
        AppMethodBeat.m2504i(66460);
        if (this.f16973i == null) {
            AppMethodBeat.m2505o(66460);
        } else if (this.f16969e != null) {
            this.f16969e.mo43396a(new C2565613());
            AppMethodBeat.m2505o(66460);
        } else {
            m73158t();
            AppMethodBeat.m2505o(66460);
        }
    }

    /* renamed from: t */
    private void m73158t() {
        AppMethodBeat.m2504i(66461);
        try {
            if (this.f16973i != null) {
                this.f16973i.mo3920a();
                this.f16973i.mo3923a(null);
                this.f16973i = null;
            }
            this.f16972h.width = 0;
            this.f16972h.height = 0;
            AppMethodBeat.m2505o(66461);
        } catch (Exception e) {
            AppMethodBeat.m2505o(66461);
        }
    }

    /* renamed from: u */
    private void m73159u() {
        AppMethodBeat.m2504i(66462);
        if ((this.f16975k.f5298K & 1) != 0) {
            C8790b.m15606a().mo19839a(true);
            C8790b.m15606a().mo19844c(this.f16975k.f5319r);
            C8790b.m15606a().mo19836a(this.f16975k.f5318q);
        } else {
            C8790b.m15606a().mo19844c(1);
            C8790b.m15606a().mo19836a(this.f16975k.f5318q);
        }
        C8790b.m15606a().mo19840a(this.f16975k.f5320s, this.f16974j);
        C8790b.m15606a().mo19845c(this.f16963C);
        TXCLiveBGMPlayer.getInstance().switchAecType(C8790b.m15606a().mo19850f());
        TXCLiveBGMPlayer.getInstance().setPitch(this.f16981q);
        AppMethodBeat.m2505o(66462);
    }

    /* renamed from: k */
    private void m73157k(int i) {
        AppMethodBeat.m2504i(66463);
        if (this.f16969e == null || !this.f16969e.mo43406d() || i == this.f16975k.f5312k || this.f16975k.f5300M || this.f16976l != 0) {
            this.f16975k.mo43387a();
            if (this.f16969e != null && this.f16969e.mo43406d()) {
                this.f16969e.mo43396a(new C88143());
            }
            AppMethodBeat.m2505o(66463);
            return;
        }
        this.f16969e.mo43396a(new C88132());
        AppMethodBeat.m2505o(66463);
    }

    /* renamed from: v */
    private void m73160v() {
        AppMethodBeat.m2504i(66464);
        if (!(this.f16975k.f5321t == null || this.f16969e == null)) {
            this.f16969e.mo43396a(new C09614());
        }
        AppMethodBeat.m2505o(66464);
    }

    /* renamed from: w */
    private void m73161w() {
        AppMethodBeat.m2504i(66465);
        if (this.f16969e != null) {
            this.f16969e.mo43396a(new C88155());
        }
        AppMethodBeat.m2505o(66465);
    }

    /* renamed from: c */
    private void m73148c(int i, int i2) {
        C37363c c37363c;
        Bitmap bitmap;
        float f;
        float f2;
        float f3;
        AppMethodBeat.m2504i(66466);
        if (this.f16975k.f5290C != -1.0f) {
            if (this.f16970f != null) {
                c37363c = this.f16970f;
                bitmap = this.f16975k.f5325x;
                f = this.f16975k.f5288A;
                f2 = this.f16975k.f5289B;
                f3 = this.f16975k.f5290C;
            }
            AppMethodBeat.m2505o(66466);
        }
        if (!(this.f16970f == null || i == 0 || i2 == 0)) {
            c37363c = this.f16970f;
            bitmap = this.f16975k.f5325x;
            f = ((float) this.f16975k.f5326y) / ((float) i);
            f2 = ((float) this.f16975k.f5327z) / ((float) i2);
            f3 = this.f16975k.f5325x == null ? 0.0f : ((float) this.f16975k.f5325x.getWidth()) / ((float) i);
        }
        AppMethodBeat.m2505o(66466);
        c37363c.mo60137a(bitmap, f, f2, f3);
        AppMethodBeat.m2505o(66466);
    }

    /* renamed from: x */
    private void m73162x() {
        AppMethodBeat.m2504i(66467);
        if (this.f16970f != null) {
            if (this.f16975k.f5296I) {
                this.f16970f.mo60151f(0);
                AppMethodBeat.m2505o(66467);
                return;
            }
            this.f16970f.mo60151f(3);
        }
        AppMethodBeat.m2505o(66467);
    }

    /* renamed from: d */
    private void m73150d(int i, int i2) {
        AppMethodBeat.m2504i(66468);
        m73148c(i, i2);
        AppMethodBeat.m2505o(66468);
    }

    /* renamed from: a */
    private void m73140a(C8803c c8803c, boolean z) {
        AppMethodBeat.m2504i(66469);
        this.f16988x = c8803c;
        if (this.f16982r == null) {
            if (this.f16983s != null) {
                if (!(this.f16986v == null || this.f16986v.mo52735b() == this.f16983s)) {
                    this.f16986v.mo52730a();
                    this.f16986v = null;
                }
                if (!(this.f16986v != null || this.f16969e == null || this.f16969e.mo43410f() == null)) {
                    this.f16986v = new C32143d();
                    this.f16986v.mo52734a(this.f16969e.mo43410f(), this.f16983s);
                }
            } else if (this.f16986v != null) {
                this.f16986v.mo52730a();
                this.f16986v = null;
            }
            if (this.f16986v != null) {
                this.f16986v.mo52731a(c8803c.f2652a, c8803c.f2659h, this.f16987w, this.f16984t, this.f16985u, c8803c.f2655d, c8803c.f2656e, z);
            }
        } else if (this.f16969e != null) {
            this.f16969e.mo43394a(c8803c);
            AppMethodBeat.m2505o(66469);
            return;
        }
        AppMethodBeat.m2505o(66469);
    }

    /* renamed from: a */
    public void mo67233a(float f, float f2) {
        AppMethodBeat.m2504i(66470);
        if (this.f16969e != null && this.f16975k.f5291D) {
            this.f16969e.mo43391a(f, f2);
        }
        AppMethodBeat.m2505o(66470);
    }
}
