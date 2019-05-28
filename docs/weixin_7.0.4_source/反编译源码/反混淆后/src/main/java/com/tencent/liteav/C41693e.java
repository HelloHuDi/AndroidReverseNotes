package com.tencent.liteav;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.TextureView;
import com.tencent.liteav.C17788h.C17789a;
import com.tencent.liteav.basic.datareport.C8795a;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.p1169f.C45104b;
import com.tencent.liteav.basic.p140d.C0946a;
import com.tencent.liteav.basic.p811g.C25648a;
import com.tencent.liteav.basic.p811g.C25649b;
import com.tencent.liteav.basic.util.C17778b;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.network.C25665f;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.liteav.p1167a.C37346a;
import com.tencent.liteav.p1167a.C37346a.C37345a;
import com.tencent.liteav.p1167a.C37346a.C37347b;
import com.tencent.liteav.renderer.C0971h;
import com.tencent.liteav.renderer.C25672g;
import com.tencent.liteav.renderer.C37373a;
import com.tencent.liteav.renderer.C37373a.C8836a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.rtmp.TXLivePlayer.ITXAudioRawDataListener;
import com.tencent.rtmp.p1423ui.TXCloudVideoView;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ugc.TXRecordCommon.ITXVideoRecordListener;
import com.tencent.ugc.TXRecordCommon.TXRecordResult;

/* renamed from: com.tencent.liteav.e */
public class C41693e extends C45110n implements C0946a, C17789a, C25665f, C8836a, C25672g {
    /* renamed from: A */
    private ITXAudioRawDataListener f17031A;
    /* renamed from: B */
    private String f17032B;
    /* renamed from: C */
    private boolean f17033C;
    /* renamed from: D */
    private long f17034D;
    /* renamed from: E */
    private long f17035E;
    /* renamed from: F */
    private boolean f17036F;
    /* renamed from: e */
    private C17788h f17037e;
    /* renamed from: f */
    private C37373a f17038f;
    /* renamed from: g */
    private TXCStreamDownloader f17039g;
    /* renamed from: h */
    private Handler f17040h;
    /* renamed from: i */
    private TextureView f17041i;
    /* renamed from: j */
    private boolean f17042j;
    /* renamed from: k */
    private boolean f17043k;
    /* renamed from: l */
    private int f17044l;
    /* renamed from: m */
    private int f17045m;
    /* renamed from: n */
    private int f17046n;
    /* renamed from: o */
    private boolean f17047o;
    /* renamed from: p */
    private C37346a f17048p;
    /* renamed from: q */
    private ITXVideoRecordListener f17049q;
    /* renamed from: r */
    private C41687d f17050r;
    /* renamed from: s */
    private int f17051s;
    /* renamed from: t */
    private int f17052t;
    /* renamed from: u */
    private C0971h f17053u;
    /* renamed from: v */
    private C0971h f17054v;
    /* renamed from: w */
    private float[] f17055w;
    /* renamed from: x */
    private float[] f17056x;
    /* renamed from: y */
    private String f17057y;
    /* renamed from: z */
    private int f17058z;

    /* renamed from: com.tencent.liteav.e$1 */
    class C177851 implements C37347b {
        C177851() {
        }

        /* renamed from: a */
        public void mo32902a(int i, String str, String str2, String str3) {
            AppMethodBeat.m2504i(67359);
            if (C41693e.this.f17049q != null) {
                TXRecordResult tXRecordResult = new TXRecordResult();
                if (i == 0) {
                    tXRecordResult.retCode = 0;
                } else {
                    tXRecordResult.retCode = -1;
                }
                tXRecordResult.descMsg = str;
                tXRecordResult.videoPath = str2;
                tXRecordResult.coverPath = str3;
                C41693e.this.f17049q.onRecordComplete(tXRecordResult);
            }
            C41693e.this.f17038f.mo60197a(null);
            C41693e.this.f17038f.mo60196a(null);
            AppMethodBeat.m2505o(67359);
        }

        /* renamed from: a */
        public void mo32903a(long j) {
            AppMethodBeat.m2504i(67360);
            if (C41693e.this.f17049q != null) {
                C41693e.this.f17049q.onRecordProgress(j);
            }
            AppMethodBeat.m2505o(67360);
        }
    }

    /* renamed from: com.tencent.liteav.e$2 */
    class C177862 implements Runnable {
        C177862() {
        }

        public void run() {
            AppMethodBeat.m2504i(67766);
            if (C41693e.this.f17033C) {
                C41693e.m73271d(C41693e.this);
            }
            AppMethodBeat.m2505o(67766);
        }
    }

    /* renamed from: com.tencent.liteav.e$3 */
    class C416893 implements Runnable {
        C416893() {
        }

        public void run() {
            AppMethodBeat.m2504i(67357);
            if (C41693e.this.f17033C) {
                C41693e.m73271d(C41693e.this);
            }
            AppMethodBeat.m2505o(67357);
        }
    }

    /* renamed from: com.tencent.liteav.e$4 */
    class C416904 implements Runnable {
        C416904() {
        }

        public void run() {
            AppMethodBeat.m2504i(66379);
            if (C41693e.this.f17036F) {
                C41693e.m73274f(C41693e.this);
            }
            AppMethodBeat.m2505o(66379);
        }
    }

    /* renamed from: com.tencent.liteav.e$5 */
    class C416915 implements Runnable {
        C416915() {
        }

        public void run() {
            AppMethodBeat.m2504i(67707);
            if (C41693e.this.f17036F) {
                C41693e.m73274f(C41693e.this);
            }
            AppMethodBeat.m2505o(67707);
        }
    }

    public C41693e(Context context) {
        super(context);
        AppMethodBeat.m2504i(66322);
        this.f17037e = null;
        this.f17038f = null;
        this.f17039g = null;
        this.f17042j = false;
        this.f17043k = false;
        this.f17044l = 0;
        this.f17045m = 0;
        this.f17046n = 16;
        this.f17047o = false;
        this.f17051s = 0;
        this.f17052t = 0;
        this.f17053u = null;
        this.f17054v = null;
        this.f17055w = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};
        this.f17056x = new float[16];
        this.f17057y = "";
        this.f17032B = "";
        this.f17033C = false;
        this.f17034D = 0;
        this.f17035E = 0;
        this.f17036F = false;
        this.f17040h = new Handler(Looper.getMainLooper());
        this.f17038f = new C37373a();
        this.f17038f.mo72909a((C0946a) this);
        AppMethodBeat.m2505o(66322);
    }

    /* renamed from: a */
    public void mo67318a(TXCloudVideoView tXCloudVideoView) {
        AppMethodBeat.m2504i(66323);
        if (!(this.f17794c == null || this.f17794c == tXCloudVideoView)) {
            TextureView videoView = this.f17794c.getVideoView();
            if (videoView != null) {
                this.f17794c.removeView(videoView);
            }
        }
        super.mo67318a(tXCloudVideoView);
        if (this.f17794c != null) {
            this.f17041i = this.f17794c.getVideoView();
            if (this.f17041i == null) {
                this.f17041i = new TextureView(this.f17794c.getContext());
            }
            this.f17794c.addVideoView(this.f17041i);
        }
        if (this.f17038f != null) {
            this.f17038f.mo72908a(this.f17041i);
        }
        AppMethodBeat.m2505o(66323);
    }

    /* renamed from: a */
    public void mo67314a(Surface surface) {
        AppMethodBeat.m2504i(66324);
        if (this.f17038f != null) {
            this.f17038f.mo72907a(surface);
        }
        AppMethodBeat.m2505o(66324);
    }

    /* renamed from: a */
    public void mo67312a(int i, int i2) {
        AppMethodBeat.m2504i(66325);
        if (this.f17038f != null) {
            this.f17038f.mo72915c(i, i2);
        }
        AppMethodBeat.m2505o(66325);
    }

    /* renamed from: a */
    public void mo67315a(C17787g c17787g) {
        AppMethodBeat.m2504i(66326);
        super.mo67315a(c17787g);
        if (this.f17037e != null) {
            this.f17037e.mo32910a(c17787g);
        }
        AppMethodBeat.m2505o(66326);
    }

    /* renamed from: a */
    public int mo67308a(String str, int i) {
        AppMethodBeat.m2504i(66327);
        if (mo67325c()) {
            TXCLog.m15679w("TXCLivePlayer", "play: ignore start play when is playing");
            AppMethodBeat.m2505o(66327);
            return -2;
        }
        this.f17057y = str;
        this.f17058z = i;
        m73269b(str);
        this.f17043k = true;
        m73273f(i);
        int b = m73267b(str, i);
        if (b != 0) {
            this.f17043k = false;
            m73280m();
            m73279l();
            if (this.f17041i != null) {
                this.f17041i.setVisibility(8);
            }
        } else {
            m73281n();
            m73285r();
            TXCDRApi.txReportDAU(this.f17793b, C8795a.f2587bv);
            try {
                if (Class.forName("com.tencent.liteav.demo.play.SuperPlayerView") != null) {
                    TXCDRApi.txReportDAU(this.f17793b, C8795a.f2561bG);
                }
            } catch (Exception e) {
            }
        }
        AppMethodBeat.m2505o(66327);
        return b;
    }

    /* renamed from: a */
    public int mo67309a(boolean z) {
        AppMethodBeat.m2504i(66328);
        if (mo67325c()) {
            TXCLog.m15678v("TXCLivePlayer", "play: stop");
            this.f17043k = false;
            m73280m();
            m73279l();
            if (this.f17041i != null && z) {
                this.f17041i.setVisibility(8);
            }
            m73282o();
            m73286s();
            m73283p();
            AppMethodBeat.m2505o(66328);
            return 0;
        }
        TXCLog.m15679w("TXCLivePlayer", "play: ignore stop play when not started");
        AppMethodBeat.m2505o(66328);
        return -2;
    }

    /* renamed from: a */
    public int mo67307a(String str) {
        AppMethodBeat.m2504i(66329);
        if (!mo67325c() || this.f17039g == null) {
            AppMethodBeat.m2505o(66329);
            return -1;
        }
        boolean switchStream = this.f17039g.switchStream(str);
        if (this.f17037e != null) {
            TXCLog.m15679w("TXCLivePlayer", " stream_switch video cache " + this.f17037e.mo32920c() + " audio cache " + this.f17037e.mo32916b());
        }
        if (switchStream) {
            this.f17057y = str;
            AppMethodBeat.m2505o(66329);
            return 0;
        }
        AppMethodBeat.m2505o(66329);
        return -2;
    }

    /* renamed from: a */
    public void mo67310a() {
        AppMethodBeat.m2504i(66330);
        mo67309a(false);
        AppMethodBeat.m2505o(66330);
    }

    /* renamed from: b */
    public void mo67321b() {
        AppMethodBeat.m2504i(66331);
        mo67308a(this.f17057y, this.f17058z);
        AppMethodBeat.m2505o(66331);
    }

    /* renamed from: c */
    public boolean mo67325c() {
        return this.f17043k;
    }

    /* renamed from: a */
    public void mo67311a(int i) {
        AppMethodBeat.m2504i(66332);
        if (this.f17037e != null) {
            this.f17037e.mo32906a(i);
        }
        AppMethodBeat.m2505o(66332);
    }

    /* renamed from: b */
    public void mo67322b(int i) {
        AppMethodBeat.m2504i(66333);
        if (this.f17037e != null) {
            this.f17037e.mo32917b(i);
        }
        AppMethodBeat.m2505o(66333);
    }

    /* renamed from: b */
    public void mo67323b(boolean z) {
        AppMethodBeat.m2504i(66334);
        this.f17042j = z;
        if (this.f17037e != null) {
            this.f17037e.mo32919b(this.f17042j);
        }
        AppMethodBeat.m2505o(66334);
    }

    /* renamed from: a */
    public void mo67313a(Context context, int i) {
        AppMethodBeat.m2504i(66335);
        C17788h.m27772a(context, i);
        AppMethodBeat.m2505o(66335);
    }

    /* renamed from: a */
    public void mo67319a(ITXVideoRecordListener iTXVideoRecordListener) {
        this.f17049q = iTXVideoRecordListener;
    }

    /* renamed from: c */
    public int mo67324c(int i) {
        AppMethodBeat.m2504i(66336);
        if (this.f17047o) {
            TXCLog.m15676e("TXCLivePlayer", "startRecord: there is existing uncompleted record task");
            AppMethodBeat.m2505o(66336);
            return -1;
        }
        this.f17047o = true;
        this.f17038f.mo60197a((C25672g) this);
        this.f17038f.mo60196a((C8836a) this);
        TXCDRApi.txReportDAU(this.f17793b, C8795a.f2502aA);
        AppMethodBeat.m2505o(66336);
        return 0;
    }

    /* renamed from: d */
    public TextureView mo67326d() {
        return this.f17041i;
    }

    /* renamed from: a */
    public void mo67317a(ITXAudioRawDataListener iTXAudioRawDataListener) {
        this.f17031A = iTXAudioRawDataListener;
    }

    /* renamed from: e */
    public int mo67327e() {
        AppMethodBeat.m2504i(66337);
        if (this.f17047o) {
            this.f17047o = false;
            if (this.f17048p != null) {
                this.f17048p.mo60058a();
                this.f17048p = null;
            }
            AppMethodBeat.m2505o(66337);
            return 0;
        }
        TXCLog.m15679w("TXCLivePlayer", "stopRecord: no recording task exist");
        AppMethodBeat.m2505o(66337);
        return -1;
    }

    /* renamed from: a */
    public boolean mo67320a(byte[] bArr) {
        AppMethodBeat.m2504i(66338);
        if (this.f17037e != null) {
            boolean a = this.f17037e.mo32915a(bArr);
            AppMethodBeat.m2505o(66338);
            return a;
        }
        AppMethodBeat.m2505o(66338);
        return false;
    }

    /* renamed from: a */
    public void mo67316a(C8832o c8832o) {
        AppMethodBeat.m2504i(66339);
        if (this.f17037e != null) {
            this.f17037e.mo32912a(c8832o);
        }
        AppMethodBeat.m2505o(66339);
    }

    /* renamed from: f */
    public boolean mo67328f() {
        return true;
    }

    /* renamed from: i */
    private void m73276i() {
        AppMethodBeat.m2504i(66340);
        if (this.f17048p == null) {
            this.f17051s = this.f17038f.mo72920m();
            this.f17052t = this.f17038f.mo72921n();
            C37345a k = m73278k();
            this.f17048p = new C37346a(this.f17793b);
            this.f17048p.mo60060a(k);
            this.f17048p.mo60061a(new C177851());
        }
        if (this.f17053u == null) {
            this.f17053u = new C0971h(Boolean.TRUE);
            this.f17053u.mo3901b();
            this.f17053u.mo3903b(this.f17051s, this.f17052t);
            this.f17053u.mo3898a(this.f17051s, this.f17052t);
        }
        if (this.f17054v == null) {
            this.f17054v = new C0971h(Boolean.FALSE);
            this.f17054v.mo3901b();
            this.f17054v.mo3903b(this.f17038f.mo72918k(), this.f17038f.mo72919l());
            this.f17054v.mo3898a(this.f17038f.mo72918k(), this.f17038f.mo72919l());
            Matrix.setIdentityM(this.f17056x, 0);
        }
        AppMethodBeat.m2505o(66340);
    }

    /* renamed from: j */
    private void m73277j() {
        AppMethodBeat.m2504i(66341);
        if (this.f17053u != null) {
            this.f17053u.mo3904c();
            this.f17053u = null;
        }
        if (this.f17054v != null) {
            this.f17054v.mo3904c();
            this.f17054v = null;
        }
        AppMethodBeat.m2505o(66341);
    }

    /* renamed from: k */
    private C37345a m73278k() {
        AppMethodBeat.m2504i(66342);
        int i = 480;
        int i2 = 640;
        if (this.f17051s > 0 && this.f17052t > 0) {
            i = this.f17051s;
            i2 = this.f17052t;
        }
        C37345a c37345a = new C37345a();
        c37345a.f15851a = i;
        c37345a.f15852b = i2;
        c37345a.f15853c = 20;
        c37345a.f15854d = (int) (Math.sqrt(((double) (i2 * i2)) + (((double) (i * i)) * 1.0d)) * 1.2d);
        c37345a.f15858h = this.f17044l;
        c37345a.f15859i = this.f17045m;
        c37345a.f15860j = this.f17046n;
        c37345a.f15856f = C37346a.m62733a(this.f17793b, VideoMaterialUtil.MP4_SUFFIX);
        c37345a.f15857g = C37346a.m62733a(this.f17793b, FileUtils.PIC_POSTFIX_JPEG);
        c37345a.f15855e = this.f17038f.mo60198b();
        TXCLog.m15675d("TXCLivePlayer", "record config: ".concat(String.valueOf(c37345a)));
        AppMethodBeat.m2505o(66342);
        return c37345a;
    }

    /* renamed from: f */
    private void m73273f(int i) {
        boolean z = true;
        AppMethodBeat.m2504i(66343);
        if (this.f17041i != null) {
            this.f17041i.setVisibility(0);
        }
        this.f17037e = new C17788h(this.f17793b, 1);
        this.f17037e.mo32907a((C0946a) this);
        this.f17037e.mo32913a(this.f17038f);
        this.f17037e.mo32911a((C17789a) this);
        this.f17037e.mo32910a(this.f17792a);
        this.f17037e.setID(this.f17032B);
        C17788h c17788h = this.f17037e;
        if (i != 5) {
            z = false;
        }
        c17788h.mo32914a(z);
        this.f17037e.mo32919b(this.f17042j);
        AppMethodBeat.m2505o(66343);
    }

    /* renamed from: l */
    private void m73279l() {
        AppMethodBeat.m2504i(66344);
        if (this.f17037e != null) {
            this.f17037e.mo32905a();
            this.f17037e.mo32913a(null);
            this.f17037e.mo32911a(null);
            this.f17037e.mo32907a(null);
            this.f17037e = null;
        }
        AppMethodBeat.m2505o(66344);
    }

    /* renamed from: b */
    private int m73267b(String str, int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(66345);
        if (i == 0) {
            this.f17039g = new TXCStreamDownloader(this.f17793b, 1);
        } else if (i == 5) {
            this.f17039g = new TXCStreamDownloader(this.f17793b, 4);
        } else {
            this.f17039g = new TXCStreamDownloader(this.f17793b, 0);
        }
        this.f17039g.setID(this.f17032B);
        this.f17039g.setListener(this);
        this.f17039g.setNotifyListener(this);
        this.f17039g.setHeaders(this.f17792a.f4186o);
        if (i == 5) {
            i2 = 1;
        }
        if (i2 != 0) {
            this.f17039g.setRetryTimes(5);
            this.f17039g.setRetryInterval(1);
        } else {
            this.f17039g.setRetryTimes(this.f17792a.f4176e);
            this.f17039g.setRetryInterval(this.f17792a.f4177f);
        }
        i2 = this.f17039g.start(str, this.f17792a.f4181j, this.f17792a.f4183l, this.f17792a.f4182k);
        AppMethodBeat.m2505o(66345);
        return i2;
    }

    /* renamed from: m */
    private void m73280m() {
        AppMethodBeat.m2504i(66346);
        if (this.f17039g != null) {
            this.f17039g.setListener(null);
            this.f17039g.setNotifyListener(null);
            this.f17039g.stop();
            this.f17039g = null;
        }
        AppMethodBeat.m2505o(66346);
    }

    /* renamed from: n */
    private void m73281n() {
        AppMethodBeat.m2504i(66347);
        this.f17050r = new C41687d(this.f17793b);
        this.f17050r.mo67293a(this.f17057y);
        this.f17050r.mo67294a(this.f17058z == 5);
        this.f17050r.mo67300d(this.f17032B);
        this.f17050r.mo67290a();
        AppMethodBeat.m2505o(66347);
    }

    /* renamed from: o */
    private void m73282o() {
        AppMethodBeat.m2504i(66348);
        if (this.f17050r != null) {
            this.f17050r.mo67298c();
            this.f17050r = null;
        }
        AppMethodBeat.m2505o(66348);
    }

    /* renamed from: b */
    private void m73269b(String str) {
        AppMethodBeat.m2504i(66349);
        this.f17032B = String.format("%s-%d", new Object[]{str, Long.valueOf(TXCTimeUtil.getTimeTick() % 10000)});
        if (this.f17037e != null) {
            this.f17037e.setID(this.f17032B);
        }
        if (this.f17038f != null) {
            this.f17038f.setID(this.f17032B);
        }
        if (this.f17039g != null) {
            this.f17039g.setID(this.f17032B);
        }
        if (this.f17050r != null) {
            this.f17050r.mo67300d(this.f17032B);
        }
        AppMethodBeat.m2505o(66349);
    }

    /* renamed from: g */
    public void mo67329g() {
        AppMethodBeat.m2504i(66350);
        this.f17035E = 0;
        if (this.f17033C) {
            AppMethodBeat.m2505o(66350);
            return;
        }
        this.f17033C = true;
        if (this.f17040h != null) {
            this.f17040h.postDelayed(new C177862(), 1000);
        }
        AppMethodBeat.m2505o(66350);
    }

    /* renamed from: p */
    private void m73283p() {
        this.f17033C = false;
    }

    /* renamed from: q */
    private void m73284q() {
        AppMethodBeat.m2504i(66351);
        if (this.f17034D > 0) {
            Bundle bundle = new Bundle();
            bundle.putInt(TXLiveConstants.EVT_PLAY_PROGRESS, (int) (this.f17034D / 1000));
            bundle.putInt(TXLiveConstants.EVT_PLAY_PROGRESS_MS, (int) this.f17034D);
            onNotifyEvent(TXLiveConstants.PLAY_EVT_PLAY_PROGRESS, bundle);
        }
        if (this.f17040h != null && this.f17033C) {
            this.f17040h.postDelayed(new C416893(), 1000);
        }
        AppMethodBeat.m2505o(66351);
    }

    /* renamed from: r */
    private void m73285r() {
        AppMethodBeat.m2504i(66352);
        this.f17036F = true;
        if (this.f17040h != null) {
            this.f17040h.postDelayed(new C416904(), FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        AppMethodBeat.m2505o(66352);
    }

    /* renamed from: s */
    private void m73286s() {
        this.f17036F = false;
    }

    /* renamed from: t */
    private void m73287t() {
        AppMethodBeat.m2504i(66353);
        int[] a = C17778b.m27747a();
        int i = a[0] / 10;
        String str = i + "/" + (a[1] / 10) + "%";
        int d = TXCStatus.m40656d(this.f17032B, 7102);
        int d2 = TXCStatus.m40656d(this.f17032B, 7101);
        String c = TXCStatus.m40655c(this.f17032B, 7110);
        i = (int) TXCStatus.m40657e(this.f17032B, 6002);
        Bundle bundle = new Bundle();
        if (this.f17038f != null) {
            bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_WIDTH, this.f17038f.mo72920m());
            bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_HEIGHT, this.f17038f.mo72921n());
        }
        if (this.f17037e != null) {
            int i2;
            bundle.putInt(TXLiveConstants.NET_STATUS_CACHE_SIZE, (int) this.f17037e.mo32920c());
            bundle.putInt(TXLiveConstants.NET_STATUS_CODEC_CACHE, (int) this.f17037e.mo32916b());
            bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_CACHE_SIZE, (int) this.f17037e.mo32923d());
            bundle.putInt(TXLiveConstants.NET_STATUS_V_DEC_CACHE_SIZE, this.f17037e.mo32924e());
            bundle.putInt(TXLiveConstants.NET_STATUS_AV_PLAY_INTERVAL, (int) this.f17037e.mo32925f());
            bundle.putString(TXLiveConstants.NET_STATUS_AUDIO_INFO, this.f17037e.mo32930k());
            bundle.putInt(TXLiveConstants.NET_STATUS_NET_JITTER, this.f17037e.mo32926g());
            bundle.putInt(TXLiveConstants.NET_STATUS_AV_RECV_INTERVAL, (int) this.f17037e.mo32927h());
            bundle.putFloat(TXLiveConstants.NET_STATUS_AUDIO_PLAY_SPEED, this.f17037e.mo32928i());
            if (i == 0) {
                i2 = 15;
            } else {
                i2 = i;
            }
            bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_GOP, (int) (((double) (((float) ((this.f17037e.mo32929j() * 10) / i2)) / 10.0f)) + 0.5d));
        }
        bundle.putInt(TXLiveConstants.NET_STATUS_NET_SPEED, d2 + d);
        bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_FPS, i);
        bundle.putInt(TXLiveConstants.NET_STATUS_VIDEO_BITRATE, d2);
        bundle.putInt(TXLiveConstants.NET_STATUS_AUDIO_BITRATE, d);
        bundle.putCharSequence(TXLiveConstants.NET_STATUS_SERVER_IP, c);
        bundle.putCharSequence(TXLiveConstants.NET_STATUS_CPU_USAGE, str);
        C17778b.m27742a(this.f17795d, 15001, bundle);
        if (this.f17037e != null) {
            this.f17037e.mo32931l();
        }
        if (this.f17050r != null) {
            this.f17050r.mo67302f();
        }
        if (this.f17040h != null && this.f17036F) {
            this.f17040h.postDelayed(new C416915(), FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        }
        AppMethodBeat.m2505o(66353);
    }

    public void onPullAudio(C25648a c25648a) {
        AppMethodBeat.m2504i(66354);
        if (this.f17043k) {
            if (this.f17037e != null) {
                this.f17037e.mo32908a(c25648a);
            }
            AppMethodBeat.m2505o(66354);
            return;
        }
        AppMethodBeat.m2505o(66354);
    }

    public void onPullNAL(C25649b c25649b) {
        AppMethodBeat.m2504i(66355);
        if (this.f17043k) {
            try {
                if (this.f17037e != null) {
                    this.f17037e.mo32909a(c25649b);
                }
                AppMethodBeat.m2505o(66355);
                return;
            } catch (Exception e) {
                AppMethodBeat.m2505o(66355);
                return;
            }
        }
        AppMethodBeat.m2505o(66355);
    }

    public void onNotifyEvent(final int i, final Bundle bundle) {
        AppMethodBeat.m2504i(66356);
        if (TXLiveConstants.PLAY_ERR_GET_RTMP_ACC_URL_FAIL == i && this.f17037e != null) {
            this.f17037e.mo32921c((int) C45104b.m82752a().mo72874a("Audio", "SmoothModeAdjust"));
        }
        if (this.f17040h != null) {
            this.f17040h.post(new Runnable() {
                public void run() {
                    AppMethodBeat.m2504i(67358);
                    C17778b.m27742a(C41693e.this.f17795d, i, bundle);
                    if (i == TXLiveConstants.PLAY_WARNING_RECONNECT && C41693e.this.f17037e != null) {
                        C41693e.this.f17037e.mo32932m();
                    }
                    AppMethodBeat.m2505o(67358);
                }
            });
        }
        AppMethodBeat.m2505o(66356);
    }

    /* renamed from: a */
    public int mo43454a(int i, float[] fArr) {
        AppMethodBeat.m2504i(66357);
        C37346a c37346a = this.f17048p;
        if (!(!this.f17047o || c37346a == null || this.f17053u == null)) {
            int d = this.f17053u.mo3906d(i);
            c37346a.mo60059a(d, TXCTimeUtil.getTimeTick());
            this.f17038f.mo60193a(d, this.f17051s, this.f17052t, false, 0);
        }
        if (this.f17047o) {
            m73276i();
        } else {
            m73277j();
        }
        AppMethodBeat.m2505o(66357);
        return i;
    }

    /* renamed from: d */
    public void mo19968d(int i) {
        AppMethodBeat.m2504i(66358);
        C37346a c37346a = this.f17048p;
        if (!(!this.f17047o || c37346a == null || this.f17054v == null)) {
            this.f17054v.mo3899a(this.f17055w);
            c37346a.mo60059a(this.f17054v.mo3906d(i), TXCTimeUtil.getTimeTick());
            this.f17054v.mo3899a(this.f17056x);
            this.f17054v.mo3905c(i);
        }
        if (this.f17047o) {
            m73276i();
            AppMethodBeat.m2505o(66358);
            return;
        }
        m73277j();
        AppMethodBeat.m2505o(66358);
    }

    /* renamed from: a */
    public void mo32937a(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(66359);
        m73277j();
        mo67327e();
        AppMethodBeat.m2505o(66359);
    }

    /* renamed from: a */
    public void mo32939a(byte[] bArr, long j) {
        AppMethodBeat.m2504i(66360);
        if (this.f17048p != null) {
            if (j <= 0) {
                j = TXCTimeUtil.getTimeTick();
            }
            this.f17048p.mo60062a(bArr, j);
        }
        if (this.f17031A != null) {
            this.f17031A.onPcmDataAvailable(bArr, j);
        }
        if (this.f17035E <= 0) {
            this.f17035E = j;
            AppMethodBeat.m2505o(66360);
            return;
        }
        this.f17034D = j - this.f17035E;
        AppMethodBeat.m2505o(66360);
    }

    /* renamed from: a */
    public void mo32938a(C25648a c25648a) {
        AppMethodBeat.m2504i(66361);
        TXCLog.m15675d("TXCLivePlayer", "onPlayAudioInfoChanged, samplerate=" + c25648a.f5245a + ", channels=" + c25648a.f5246b + ", bits=" + c25648a.f5247c);
        this.f17044l = c25648a.f5246b;
        this.f17045m = c25648a.f5245a;
        if (c25648a.f5247c > 1) {
            this.f17046n = c25648a.f5247c;
        }
        if (this.f17031A != null) {
            this.f17031A.onAudioInfoChanged(c25648a.f5245a, c25648a.f5246b, c25648a.f5247c);
        }
        AppMethodBeat.m2505o(66361);
    }

    /* renamed from: a */
    public void mo32936a(long j) {
    }
}
