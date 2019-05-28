package com.tencent.liteav.beauty;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.C32147a;
import com.tencent.liteav.basic.p140d.C0946a;
import com.tencent.liteav.basic.p141e.C32140a;
import com.tencent.liteav.basic.p141e.C32144i;
import com.tencent.liteav.basic.p811g.C8803c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.wxmm.v2helper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.tencent.liteav.beauty.c */
public class C37363c extends C32147a implements C8811d {
    /* renamed from: a */
    protected Context f15932a;
    /* renamed from: b */
    protected boolean f15933b = true;
    /* renamed from: c */
    protected boolean f15934c = false;
    /* renamed from: d */
    protected int f15935d = 0;
    /* renamed from: e */
    protected int f15936e = 0;
    /* renamed from: f */
    protected int f15937f = 0;
    /* renamed from: g */
    protected C32140a f15938g = null;
    /* renamed from: h */
    protected C32157b f15939h;
    /* renamed from: i */
    protected C37362b f15940i = new C37362b();
    /* renamed from: j */
    protected C25655c f15941j = null;
    /* renamed from: k */
    C8812e f15942k;
    /* renamed from: l */
    private boolean f15943l = false;
    /* renamed from: m */
    private long f15944m = 0;
    /* renamed from: n */
    private long f15945n = 0;
    /* renamed from: o */
    private long f15946o = 0;
    /* renamed from: p */
    private C37364a f15947p = new C37364a(this);

    /* renamed from: com.tencent.liteav.beauty.c$d */
    public static class C8810d {
        /* renamed from: a */
        public Bitmap f2675a;
        /* renamed from: b */
        public float f2676b;
        /* renamed from: c */
        public float f2677c;
        /* renamed from: d */
        public float f2678d;
    }

    /* renamed from: com.tencent.liteav.beauty.c$c */
    static class C25655c {
        /* renamed from: a */
        public boolean f5272a;
        /* renamed from: b */
        public int f5273b;
        /* renamed from: c */
        public int f5274c;
        /* renamed from: d */
        public int f5275d;
        /* renamed from: e */
        public int f5276e;
        /* renamed from: f */
        public int f5277f;
        /* renamed from: g */
        public boolean f5278g;
        /* renamed from: h */
        public int f5279h;
        /* renamed from: i */
        public int f5280i;
        /* renamed from: j */
        public int f5281j;
        /* renamed from: k */
        public int f5282k;
        /* renamed from: l */
        public int f5283l;
        /* renamed from: m */
        public C32140a f5284m;

        private C25655c() {
            this.f5278g = false;
            this.f5282k = 5;
            this.f5283l = 0;
            this.f5284m = null;
        }

        /* synthetic */ C25655c(C321641 c321641) {
            this();
        }
    }

    /* renamed from: com.tencent.liteav.beauty.c$b */
    static class C37362b {
        /* renamed from: a */
        int f15919a;
        /* renamed from: b */
        int f15920b;
        /* renamed from: c */
        int f15921c;
        /* renamed from: d */
        int f15922d;
        /* renamed from: e */
        int f15923e;
        /* renamed from: f */
        int f15924f;
        /* renamed from: g */
        int f15925g;
        /* renamed from: h */
        int f15926h;
        /* renamed from: i */
        boolean f15927i;
        /* renamed from: j */
        boolean f15928j;
        /* renamed from: k */
        public int f15929k = 5;
        /* renamed from: l */
        public int f15930l = 0;
        /* renamed from: m */
        C32140a f15931m = null;

        C37362b() {
        }
    }

    /* renamed from: com.tencent.liteav.beauty.c$a */
    protected static class C37364a {
        /* renamed from: a */
        WeakReference<C37363c> f15948a;
        /* renamed from: b */
        private HashMap<String, String> f15949b = new HashMap();

        public C37364a(C37363c c37363c) {
            AppMethodBeat.m2504i(66831);
            this.f15948a = new WeakReference(c37363c);
            AppMethodBeat.m2505o(66831);
        }

        /* renamed from: a */
        public void mo60159a(String str, int i) {
            AppMethodBeat.m2504i(66832);
            this.f15949b.put(str, String.valueOf(i));
            C37363c c37363c = (C37363c) this.f15948a.get();
            if (c37363c != null) {
                String id = c37363c.getID();
                if (id != null && id.length() > 0) {
                    c37363c.setStatusValue(3001, mo60158a());
                }
            }
            AppMethodBeat.m2505o(66832);
        }

        /* renamed from: a */
        public String mo60158a() {
            AppMethodBeat.m2504i(66833);
            String str = "";
            Iterator it = this.f15949b.keySet().iterator();
            while (true) {
                String str2 = str;
                if (it.hasNext()) {
                    str = (String) it.next();
                    str = str2 + str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + ((String) this.f15949b.get(str)) + " ";
                } else {
                    str = "{" + str2 + "}";
                    AppMethodBeat.m2505o(66833);
                    return str;
                }
            }
        }
    }

    /* renamed from: a */
    public int mo19908a(int i, int i2, int i3) {
        boolean z = false;
        AppMethodBeat.m2504i(67055);
        if (this.f15942k != null) {
            C8803c c8803c = new C8803c();
            c8803c.f2655d = i2;
            c8803c.f2656e = i3;
            c8803c.f2660i = this.f15941j != null ? this.f15941j.f5281j : 0;
            if (this.f15941j != null) {
                z = this.f15941j.f5278g;
            }
            c8803c.f2659h = z;
            c8803c.f2652a = i;
            int a = this.f15942k.mo19911a(c8803c);
            AppMethodBeat.m2505o(67055);
            return a;
        }
        AppMethodBeat.m2505o(67055);
        return 0;
    }

    /* renamed from: a */
    public void mo19909a(int i, int i2, int i3, long j) {
        boolean z = false;
        AppMethodBeat.m2504i(67056);
        m62823b();
        if (this.f15942k != null) {
            C8803c c8803c = new C8803c();
            c8803c.f2655d = i2;
            c8803c.f2656e = i3;
            c8803c.f2660i = this.f15941j != null ? this.f15941j.f5281j : 0;
            if (this.f15941j != null) {
                z = this.f15941j.f5278g;
            }
            c8803c.f2659h = z;
            c8803c.f2652a = i;
            this.f15942k.mo19912a(c8803c, j);
        }
        AppMethodBeat.m2505o(67056);
    }

    /* renamed from: a */
    public void mo19910a(byte[] bArr, int i, int i2, int i3, long j) {
        AppMethodBeat.m2504i(67057);
        if (this.f15942k != null) {
            this.f15942k.mo19913a(bArr, i, i2, i3, j);
        }
        AppMethodBeat.m2505o(67057);
    }

    /* renamed from: b */
    private void m62823b() {
        AppMethodBeat.m2504i(67058);
        if (this.f15944m != 0) {
            setStatusValue(3002, Long.valueOf(System.currentTimeMillis() - this.f15944m));
        }
        this.f15945n++;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis > this.f15946o + FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
            setStatusValue(3003, Double.valueOf((((double) this.f15945n) * 1000.0d) / ((double) (currentTimeMillis - this.f15946o))));
            this.f15945n = 0;
            this.f15946o = currentTimeMillis;
        }
        AppMethodBeat.m2505o(67058);
    }

    public C37363c(Context context, boolean z) {
        AppMethodBeat.m2504i(67059);
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        TXCLog.m15677i("TXCVideoPreprocessor", "TXCVideoPreprocessor version: VideoPreprocessor-v1.1");
        ConfigurationInfo deviceConfigurationInfo = activityManager.getDeviceConfigurationInfo();
        if (deviceConfigurationInfo != null) {
            TXCLog.m15677i("TXCVideoPreprocessor", "opengl es version " + deviceConfigurationInfo.reqGlEsVersion);
            TXCLog.m15677i("TXCVideoPreprocessor", "set GLContext ".concat(String.valueOf(z)));
            if (deviceConfigurationInfo.reqGlEsVersion > WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                TXCLog.m15677i("TXCVideoPreprocessor", "This devices is OpenGlUtils.OPENGL_ES_3");
                C32144i.m52318a(3);
            } else {
                TXCLog.m15677i("TXCVideoPreprocessor", "This devices is OpenGlUtils.OPENGL_ES_2");
                C32144i.m52318a(2);
            }
        } else {
            TXCLog.m15676e("TXCVideoPreprocessor", "getDeviceConfigurationInfo opengl Info failed!");
        }
        this.f15932a = context;
        this.f15933b = z;
        this.f15939h = new C32157b(this.f15932a, this.f15933b);
        C32148a.m52321a().mo52741a(context);
        AppMethodBeat.m2505o(67059);
    }

    /* renamed from: a */
    public void mo60144a(float[] fArr) {
        AppMethodBeat.m2504i(67060);
        if (this.f15939h != null) {
            this.f15939h.mo52769a(fArr);
        }
        AppMethodBeat.m2505o(67060);
    }

    /* renamed from: a */
    public synchronized int mo60131a(byte[] bArr, int i, int i2, int i3, int i4, int i5) {
        int a;
        AppMethodBeat.m2504i(67061);
        m62821a(i, i2, m62824m(i3), i4, i5);
        this.f15939h.mo52772b(this.f15940i);
        a = this.f15939h.mo52756a(bArr, i4);
        AppMethodBeat.m2505o(67061);
        return a;
    }

    /* renamed from: a */
    public synchronized int mo60129a(int i, int i2, int i3, int i4, int i5, int i6) {
        int a;
        AppMethodBeat.m2504i(67062);
        m62821a(i2, i3, m62824m(i4), i5, i6);
        this.f15939h.mo52772b(this.f15940i);
        a = this.f15939h.mo52755a(i, i5);
        AppMethodBeat.m2505o(67062);
        return a;
    }

    /* renamed from: a */
    public synchronized int mo60130a(C8803c c8803c, int i, int i2) {
        int a;
        AppMethodBeat.m2504i(67063);
        this.f15944m = System.currentTimeMillis();
        mo60139a(c8803c.f2662k);
        mo60135a(c8803c.f2657f, c8803c.f2658g);
        mo60143a(c8803c.f2659h);
        mo60134a(c8803c.f2660i);
        mo60144a(c8803c.f2654c);
        a = mo60129a(c8803c.f2652a, c8803c.f2655d, c8803c.f2656e, c8803c.f2660i, i, i2);
        AppMethodBeat.m2505o(67063);
        return a;
    }

    /* renamed from: a */
    public synchronized void mo60139a(C32140a c32140a) {
        this.f15938g = c32140a;
    }

    /* renamed from: a */
    public synchronized void mo60135a(int i, int i2) {
        this.f15935d = i;
        this.f15936e = i2;
    }

    /* renamed from: a */
    public synchronized void mo60134a(int i) {
        this.f15937f = i;
    }

    /* renamed from: a */
    public synchronized void mo60137a(Bitmap bitmap, float f, float f2, float f3) {
        AppMethodBeat.m2504i(67064);
        if (f < 0.0f || f2 < 0.0f || ((double) f3) < 0.0d) {
            TXCLog.m15676e("TXCVideoPreprocessor", "WaterMark param is Error!");
            AppMethodBeat.m2505o(67064);
        } else {
            if (this.f15939h != null) {
                this.f15939h.mo52762a(bitmap, f, f2, f3);
            }
            AppMethodBeat.m2505o(67064);
        }
    }

    /* renamed from: a */
    public synchronized void mo60143a(boolean z) {
        this.f15934c = z;
    }

    /* renamed from: a */
    public synchronized void mo60140a(C8811d c8811d) {
        AppMethodBeat.m2504i(67065);
        if (this.f15939h == null) {
            TXCLog.m15676e("TXCVideoPreprocessor", "setListener mDrawer is null!");
            AppMethodBeat.m2505o(67065);
        } else {
            this.f15939h.mo52764a(c8811d);
            AppMethodBeat.m2505o(67065);
        }
    }

    /* renamed from: a */
    public synchronized void mo60141a(C8812e c8812e) {
        AppMethodBeat.m2504i(67066);
        if (this.f15939h == null) {
            TXCLog.m15676e("TXCVideoPreprocessor", "setListener mDrawer is null!");
            AppMethodBeat.m2505o(67066);
        } else {
            this.f15942k = c8812e;
            if (c8812e == null) {
                this.f15939h.mo52764a(null);
                AppMethodBeat.m2505o(67066);
            } else {
                this.f15939h.mo52764a((C8811d) this);
                AppMethodBeat.m2505o(67066);
            }
        }
    }

    /* renamed from: a */
    public synchronized void mo60138a(C0946a c0946a) {
        AppMethodBeat.m2504i(67067);
        if (this.f15939h == null) {
            TXCLog.m15676e("TXCVideoPreprocessor", "setListener mDrawer is null!");
            AppMethodBeat.m2505o(67067);
        } else {
            this.f15939h.mo52763a(c0946a);
            AppMethodBeat.m2505o(67067);
        }
    }

    /* renamed from: m */
    private int m62824m(int i) {
        switch (i) {
            case 1:
                return 90;
            case 2:
                return 180;
            case 3:
                return 270;
            default:
                return i;
        }
    }

    /* renamed from: a */
    private boolean m62821a(int i, int i2, int i3, int i4, int i5) {
        AppMethodBeat.m2504i(67068);
        if (this.f15941j == null) {
            this.f15941j = new C25655c();
            this.f15945n = 0;
            this.f15946o = System.currentTimeMillis();
        }
        if (i != this.f15941j.f5273b || i2 != this.f15941j.f5274c || i3 != this.f15941j.f5277f || ((this.f15935d > 0 && this.f15935d != this.f15941j.f5279h) || ((this.f15936e > 0 && this.f15936e != this.f15941j.f5280i) || ((this.f15937f > 0 && this.f15937f != this.f15941j.f5281j) || ((this.f15938g != null && ((this.f15938g.f14703c > 0 && (this.f15941j.f5284m == null || this.f15938g.f14703c != this.f15941j.f5284m.f14703c)) || ((this.f15938g.f14704d > 0 && (this.f15941j.f5284m == null || this.f15938g.f14704d != this.f15941j.f5284m.f14704d)) || ((this.f15938g.f14701a >= 0 && (this.f15941j.f5284m == null || this.f15938g.f14701a != this.f15941j.f5284m.f14701a)) || (this.f15938g.f14702b >= 0 && (this.f15941j.f5284m == null || this.f15938g.f14702b != this.f15941j.f5284m.f14702b)))))) || this.f15934c != this.f15941j.f5278g))))) {
            TXCLog.m15677i("TXCVideoPreprocessor", "Init sdk");
            TXCLog.m15677i("TXCVideoPreprocessor", "Input widht " + i + " height " + i2);
            this.f15941j.f5273b = i;
            this.f15941j.f5274c = i2;
            if (this.f15938g != null && this.f15938g.f14701a >= 0 && this.f15938g.f14702b >= 0 && this.f15938g.f14703c > 0 && this.f15938g.f14704d > 0) {
                int i6;
                TXCLog.m15677i("TXCVideoPreprocessor", "set Crop Rect; init ");
                int i7 = i - this.f15938g.f14701a > this.f15938g.f14703c ? this.f15938g.f14703c : i - this.f15938g.f14701a;
                if (i2 - this.f15938g.f14702b > this.f15938g.f14704d) {
                    i6 = this.f15938g.f14704d;
                } else {
                    i6 = i2 - this.f15938g.f14702b;
                }
                this.f15938g.f14703c = i7;
                this.f15938g.f14704d = i6;
                i = this.f15938g.f14703c;
                i2 = this.f15938g.f14704d;
                this.f15941j.f5284m = this.f15938g;
            }
            this.f15941j.f5277f = i3;
            this.f15941j.f5272a = this.f15933b;
            this.f15941j.f5282k = i4;
            this.f15941j.f5283l = i5;
            if (true == this.f15943l) {
                this.f15941j.f5279h = this.f15935d;
                this.f15941j.f5280i = this.f15936e;
            } else {
                this.f15941j.f5279h = 0;
                this.f15941j.f5280i = 0;
            }
            this.f15941j.f5281j = this.f15937f;
            if (this.f15941j.f5281j <= 0) {
                this.f15941j.f5281j = 0;
            }
            if (this.f15941j.f5279h <= 0 || this.f15941j.f5280i <= 0) {
                if (90 == this.f15941j.f5281j || 270 == this.f15941j.f5281j) {
                    this.f15941j.f5279h = i2;
                    this.f15941j.f5280i = i;
                } else {
                    this.f15941j.f5279h = i;
                    this.f15941j.f5280i = i2;
                }
            }
            if (90 == this.f15941j.f5281j || 270 == this.f15941j.f5281j) {
                this.f15941j.f5275d = this.f15941j.f5280i;
                this.f15941j.f5276e = this.f15941j.f5279h;
            } else {
                this.f15941j.f5275d = this.f15941j.f5279h;
                this.f15941j.f5276e = this.f15941j.f5280i;
            }
            if (true != this.f15943l) {
                this.f15941j.f5279h = this.f15935d;
                this.f15941j.f5280i = this.f15936e;
                if (this.f15941j.f5279h <= 0 || this.f15941j.f5280i <= 0) {
                    if (90 == this.f15941j.f5281j || 270 == this.f15941j.f5281j) {
                        this.f15941j.f5279h = i2;
                        this.f15941j.f5280i = i;
                    } else {
                        this.f15941j.f5279h = i;
                        this.f15941j.f5280i = i2;
                    }
                }
            }
            this.f15941j.f5278g = this.f15934c;
            if (!m62822a(this.f15941j)) {
                TXCLog.m15676e("TXCVideoPreprocessor", "init failed!");
                AppMethodBeat.m2505o(67068);
                return false;
            }
        } else if (!(i4 == this.f15941j.f5282k && i5 == this.f15941j.f5283l)) {
            this.f15941j.f5282k = i4;
            this.f15940i.f15929k = i4;
            this.f15941j.f5283l = i5;
            this.f15940i.f15930l = i5;
            this.f15939h.mo52760a(i5);
        }
        AppMethodBeat.m2505o(67068);
        return true;
    }

    /* renamed from: a */
    private boolean m62822a(C25655c c25655c) {
        AppMethodBeat.m2504i(67069);
        this.f15940i.f15922d = c25655c.f5273b;
        this.f15940i.f15923e = c25655c.f5274c;
        this.f15940i.f15931m = c25655c.f5284m;
        this.f15940i.f15925g = c25655c.f5275d;
        this.f15940i.f15924f = c25655c.f5276e;
        this.f15940i.f15926h = (c25655c.f5277f + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
        this.f15940i.f15920b = c25655c.f5279h;
        this.f15940i.f15921c = c25655c.f5280i;
        this.f15940i.f15919a = c25655c.f5281j;
        this.f15940i.f15928j = c25655c.f5272a;
        this.f15940i.f15927i = c25655c.f5278g;
        this.f15940i.f15929k = c25655c.f5282k;
        this.f15940i.f15930l = c25655c.f5283l;
        if (this.f15939h == null) {
            this.f15939h = new C32157b(this.f15932a, c25655c.f5272a);
        }
        boolean a = this.f15939h.mo52770a(this.f15940i);
        AppMethodBeat.m2505o(67069);
        return a;
    }

    /* renamed from: a */
    public synchronized void mo60132a() {
        AppMethodBeat.m2504i(67070);
        if (this.f15939h != null) {
            this.f15939h.mo52757a();
        }
        this.f15941j = null;
        AppMethodBeat.m2505o(67070);
    }

    /* renamed from: b */
    public synchronized void mo60146b(int i) {
        AppMethodBeat.m2504i(67071);
        if (this.f15939h != null) {
            this.f15939h.mo52773c(i);
        }
        this.f15947p.mo60159a("beautyStyle", i);
        AppMethodBeat.m2505o(67071);
    }

    /* renamed from: c */
    public synchronized void mo60148c(int i) {
        AppMethodBeat.m2504i(67072);
        if (i > 9) {
            TXCLog.m15676e("TXCVideoPreprocessor", "Beauty value too large! set max value 9");
            i = 9;
        } else if (i < 0) {
            TXCLog.m15676e("TXCVideoPreprocessor", "Beauty < 0; set 0");
            i = 0;
        }
        if (this.f15939h != null) {
            this.f15939h.mo52771b(i);
        }
        this.f15947p.mo60159a("beautyLevel", i);
        AppMethodBeat.m2505o(67072);
    }

    /* renamed from: d */
    public synchronized void mo60149d(int i) {
        AppMethodBeat.m2504i(67073);
        if (i > 9) {
            TXCLog.m15676e("TXCVideoPreprocessor", "Brightness value too large! set max value 9");
            i = 9;
        } else if (i < 0) {
            TXCLog.m15676e("TXCVideoPreprocessor", "Brightness < 0; set 0");
            i = 0;
        }
        if (this.f15939h != null) {
            this.f15939h.mo52774d(i);
        }
        this.f15947p.mo60159a("whiteLevel", i);
        AppMethodBeat.m2505o(67073);
    }

    /* renamed from: e */
    public synchronized void mo60150e(int i) {
        AppMethodBeat.m2504i(67074);
        if (i > 9) {
            TXCLog.m15676e("TXCVideoPreprocessor", "Ruddy value too large! set max value 9");
            i = 9;
        } else if (i < 0) {
            TXCLog.m15676e("TXCVideoPreprocessor", "Ruddy < 0; set 0");
            i = 0;
        }
        if (this.f15939h != null) {
            this.f15939h.mo52776f(i);
        }
        this.f15947p.mo60159a("ruddyLevel", i);
        AppMethodBeat.m2505o(67074);
    }

    /* renamed from: f */
    public void mo60151f(int i) {
        AppMethodBeat.m2504i(67075);
        if (i > 9) {
            TXCLog.m15676e("TXCVideoPreprocessor", "Brightness value too large! set max value 9");
            i = 9;
        } else if (i < 0) {
            TXCLog.m15676e("TXCVideoPreprocessor", "Brightness < 0; set 0");
            i = 0;
        }
        if (this.f15939h != null) {
            this.f15939h.mo52775e(i);
        }
        AppMethodBeat.m2505o(67075);
    }

    /* renamed from: a */
    public synchronized void mo60142a(String str) {
        AppMethodBeat.m2504i(67076);
        if (this.f15939h != null) {
            this.f15939h.mo52765a(str);
        }
        AppMethodBeat.m2505o(67076);
    }

    /* renamed from: b */
    public synchronized void mo60147b(boolean z) {
        AppMethodBeat.m2504i(67077);
        if (this.f15939h != null) {
            this.f15939h.mo52767a(z);
        }
        AppMethodBeat.m2505o(67077);
    }

    @TargetApi(18)
    /* renamed from: a */
    public boolean mo60145a(String str, boolean z) {
        AppMethodBeat.m2504i(67078);
        if (VERSION.SDK_INT < 18) {
            AppMethodBeat.m2505o(67078);
            return false;
        }
        if (this.f15939h != null) {
            this.f15939h.mo52766a(str, z);
        }
        AppMethodBeat.m2505o(67078);
        return true;
    }

    /* renamed from: g */
    public synchronized void mo60152g(int i) {
        AppMethodBeat.m2504i(67079);
        if (this.f15939h != null) {
            this.f15939h.mo52777g(i);
        }
        this.f15947p.mo60159a("eyeBigScale", i);
        AppMethodBeat.m2505o(67079);
    }

    /* renamed from: h */
    public synchronized void mo60153h(int i) {
        AppMethodBeat.m2504i(67080);
        if (this.f15939h != null) {
            this.f15939h.mo52778h(i);
        }
        this.f15947p.mo60159a("faceSlimLevel", i);
        AppMethodBeat.m2505o(67080);
    }

    /* renamed from: i */
    public void mo60154i(int i) {
        AppMethodBeat.m2504i(67081);
        if (this.f15939h != null) {
            this.f15939h.mo52779i(i);
        }
        this.f15947p.mo60159a("faceVLevel", i);
        AppMethodBeat.m2505o(67081);
    }

    /* renamed from: j */
    public void mo60155j(int i) {
        AppMethodBeat.m2504i(67082);
        if (this.f15939h != null) {
            this.f15939h.mo52780j(i);
        }
        this.f15947p.mo60159a("faceShortLevel", i);
        AppMethodBeat.m2505o(67082);
    }

    /* renamed from: k */
    public void mo60156k(int i) {
        AppMethodBeat.m2504i(67083);
        if (this.f15939h != null) {
            this.f15939h.mo52781k(i);
        }
        this.f15947p.mo60159a("chinLevel", i);
        AppMethodBeat.m2505o(67083);
    }

    /* renamed from: l */
    public void mo60157l(int i) {
        AppMethodBeat.m2504i(67084);
        if (this.f15939h != null) {
            this.f15939h.mo52782l(i);
        }
        this.f15947p.mo60159a("noseSlimLevel", i);
        AppMethodBeat.m2505o(67084);
    }

    /* renamed from: a */
    public synchronized void mo60133a(float f) {
        AppMethodBeat.m2504i(67085);
        if (this.f15939h != null) {
            this.f15939h.mo52758a(f);
        }
        AppMethodBeat.m2505o(67085);
    }

    /* renamed from: a */
    public synchronized void mo60136a(Bitmap bitmap) {
        AppMethodBeat.m2504i(67086);
        if (this.f15939h != null) {
            this.f15939h.mo52761a(bitmap);
        }
        AppMethodBeat.m2505o(67086);
    }

    public void setID(String str) {
        AppMethodBeat.m2504i(67087);
        super.setID(str);
        setStatusValue(3001, this.f15947p.mo60158a());
        AppMethodBeat.m2505o(67087);
    }
}
