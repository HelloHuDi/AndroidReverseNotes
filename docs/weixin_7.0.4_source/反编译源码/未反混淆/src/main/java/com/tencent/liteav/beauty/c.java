package com.tencent.liteav.beauty;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.tencent.liteav.basic.e.i;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.wxmm.v2helper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;

public class c extends com.tencent.liteav.basic.module.a implements d {
    protected Context a;
    protected boolean b = true;
    protected boolean c = false;
    protected int d = 0;
    protected int e = 0;
    protected int f = 0;
    protected com.tencent.liteav.basic.e.a g = null;
    protected b h;
    protected b i = new b();
    protected c j = null;
    e k;
    private boolean l = false;
    private long m = 0;
    private long n = 0;
    private long o = 0;
    private a p = new a(this);

    public static class d {
        public Bitmap a;
        public float b;
        public float c;
        public float d;
    }

    static class c {
        public boolean a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public boolean g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l;
        public com.tencent.liteav.basic.e.a m;

        private c() {
            this.g = false;
            this.k = 5;
            this.l = 0;
            this.m = null;
        }

        /* synthetic */ c(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    static class b {
        int a;
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;
        int h;
        boolean i;
        boolean j;
        public int k = 5;
        public int l = 0;
        com.tencent.liteav.basic.e.a m = null;

        b() {
        }
    }

    protected static class a {
        WeakReference<c> a;
        private HashMap<String, String> b = new HashMap();

        public a(c cVar) {
            AppMethodBeat.i(66831);
            this.a = new WeakReference(cVar);
            AppMethodBeat.o(66831);
        }

        public void a(String str, int i) {
            AppMethodBeat.i(66832);
            this.b.put(str, String.valueOf(i));
            c cVar = (c) this.a.get();
            if (cVar != null) {
                String id = cVar.getID();
                if (id != null && id.length() > 0) {
                    cVar.setStatusValue(3001, a());
                }
            }
            AppMethodBeat.o(66832);
        }

        public String a() {
            AppMethodBeat.i(66833);
            String str = "";
            Iterator it = this.b.keySet().iterator();
            while (true) {
                String str2 = str;
                if (it.hasNext()) {
                    str = (String) it.next();
                    str = str2 + str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + ((String) this.b.get(str)) + " ";
                } else {
                    str = "{" + str2 + "}";
                    AppMethodBeat.o(66833);
                    return str;
                }
            }
        }
    }

    public int a(int i, int i2, int i3) {
        boolean z = false;
        AppMethodBeat.i(67055);
        if (this.k != null) {
            com.tencent.liteav.basic.g.c cVar = new com.tencent.liteav.basic.g.c();
            cVar.d = i2;
            cVar.e = i3;
            cVar.i = this.j != null ? this.j.j : 0;
            if (this.j != null) {
                z = this.j.g;
            }
            cVar.h = z;
            cVar.a = i;
            int a = this.k.a(cVar);
            AppMethodBeat.o(67055);
            return a;
        }
        AppMethodBeat.o(67055);
        return 0;
    }

    public void a(int i, int i2, int i3, long j) {
        boolean z = false;
        AppMethodBeat.i(67056);
        b();
        if (this.k != null) {
            com.tencent.liteav.basic.g.c cVar = new com.tencent.liteav.basic.g.c();
            cVar.d = i2;
            cVar.e = i3;
            cVar.i = this.j != null ? this.j.j : 0;
            if (this.j != null) {
                z = this.j.g;
            }
            cVar.h = z;
            cVar.a = i;
            this.k.a(cVar, j);
        }
        AppMethodBeat.o(67056);
    }

    public void a(byte[] bArr, int i, int i2, int i3, long j) {
        AppMethodBeat.i(67057);
        if (this.k != null) {
            this.k.a(bArr, i, i2, i3, j);
        }
        AppMethodBeat.o(67057);
    }

    private void b() {
        AppMethodBeat.i(67058);
        if (this.m != 0) {
            setStatusValue(3002, Long.valueOf(System.currentTimeMillis() - this.m));
        }
        this.n++;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis > this.o + FaceGestureDetGLThread.BRIGHTNESS_DURATION) {
            setStatusValue(3003, Double.valueOf((((double) this.n) * 1000.0d) / ((double) (currentTimeMillis - this.o))));
            this.n = 0;
            this.o = currentTimeMillis;
        }
        AppMethodBeat.o(67058);
    }

    public c(Context context, boolean z) {
        AppMethodBeat.i(67059);
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        TXCLog.i("TXCVideoPreprocessor", "TXCVideoPreprocessor version: VideoPreprocessor-v1.1");
        ConfigurationInfo deviceConfigurationInfo = activityManager.getDeviceConfigurationInfo();
        if (deviceConfigurationInfo != null) {
            TXCLog.i("TXCVideoPreprocessor", "opengl es version " + deviceConfigurationInfo.reqGlEsVersion);
            TXCLog.i("TXCVideoPreprocessor", "set GLContext ".concat(String.valueOf(z)));
            if (deviceConfigurationInfo.reqGlEsVersion > WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
                TXCLog.i("TXCVideoPreprocessor", "This devices is OpenGlUtils.OPENGL_ES_3");
                i.a(3);
            } else {
                TXCLog.i("TXCVideoPreprocessor", "This devices is OpenGlUtils.OPENGL_ES_2");
                i.a(2);
            }
        } else {
            TXCLog.e("TXCVideoPreprocessor", "getDeviceConfigurationInfo opengl Info failed!");
        }
        this.a = context;
        this.b = z;
        this.h = new b(this.a, this.b);
        a.a().a(context);
        AppMethodBeat.o(67059);
    }

    public void a(float[] fArr) {
        AppMethodBeat.i(67060);
        if (this.h != null) {
            this.h.a(fArr);
        }
        AppMethodBeat.o(67060);
    }

    public synchronized int a(byte[] bArr, int i, int i2, int i3, int i4, int i5) {
        int a;
        AppMethodBeat.i(67061);
        a(i, i2, m(i3), i4, i5);
        this.h.b(this.i);
        a = this.h.a(bArr, i4);
        AppMethodBeat.o(67061);
        return a;
    }

    public synchronized int a(int i, int i2, int i3, int i4, int i5, int i6) {
        int a;
        AppMethodBeat.i(67062);
        a(i2, i3, m(i4), i5, i6);
        this.h.b(this.i);
        a = this.h.a(i, i5);
        AppMethodBeat.o(67062);
        return a;
    }

    public synchronized int a(com.tencent.liteav.basic.g.c cVar, int i, int i2) {
        int a;
        AppMethodBeat.i(67063);
        this.m = System.currentTimeMillis();
        a(cVar.k);
        a(cVar.f, cVar.g);
        a(cVar.h);
        a(cVar.i);
        a(cVar.c);
        a = a(cVar.a, cVar.d, cVar.e, cVar.i, i, i2);
        AppMethodBeat.o(67063);
        return a;
    }

    public synchronized void a(com.tencent.liteav.basic.e.a aVar) {
        this.g = aVar;
    }

    public synchronized void a(int i, int i2) {
        this.d = i;
        this.e = i2;
    }

    public synchronized void a(int i) {
        this.f = i;
    }

    public synchronized void a(Bitmap bitmap, float f, float f2, float f3) {
        AppMethodBeat.i(67064);
        if (f < 0.0f || f2 < 0.0f || ((double) f3) < 0.0d) {
            TXCLog.e("TXCVideoPreprocessor", "WaterMark param is Error!");
            AppMethodBeat.o(67064);
        } else {
            if (this.h != null) {
                this.h.a(bitmap, f, f2, f3);
            }
            AppMethodBeat.o(67064);
        }
    }

    public synchronized void a(boolean z) {
        this.c = z;
    }

    public synchronized void a(d dVar) {
        AppMethodBeat.i(67065);
        if (this.h == null) {
            TXCLog.e("TXCVideoPreprocessor", "setListener mDrawer is null!");
            AppMethodBeat.o(67065);
        } else {
            this.h.a(dVar);
            AppMethodBeat.o(67065);
        }
    }

    public synchronized void a(e eVar) {
        AppMethodBeat.i(67066);
        if (this.h == null) {
            TXCLog.e("TXCVideoPreprocessor", "setListener mDrawer is null!");
            AppMethodBeat.o(67066);
        } else {
            this.k = eVar;
            if (eVar == null) {
                this.h.a(null);
                AppMethodBeat.o(67066);
            } else {
                this.h.a((d) this);
                AppMethodBeat.o(67066);
            }
        }
    }

    public synchronized void a(com.tencent.liteav.basic.d.a aVar) {
        AppMethodBeat.i(67067);
        if (this.h == null) {
            TXCLog.e("TXCVideoPreprocessor", "setListener mDrawer is null!");
            AppMethodBeat.o(67067);
        } else {
            this.h.a(aVar);
            AppMethodBeat.o(67067);
        }
    }

    private int m(int i) {
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

    private boolean a(int i, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(67068);
        if (this.j == null) {
            this.j = new c();
            this.n = 0;
            this.o = System.currentTimeMillis();
        }
        if (i != this.j.b || i2 != this.j.c || i3 != this.j.f || ((this.d > 0 && this.d != this.j.h) || ((this.e > 0 && this.e != this.j.i) || ((this.f > 0 && this.f != this.j.j) || ((this.g != null && ((this.g.c > 0 && (this.j.m == null || this.g.c != this.j.m.c)) || ((this.g.d > 0 && (this.j.m == null || this.g.d != this.j.m.d)) || ((this.g.a >= 0 && (this.j.m == null || this.g.a != this.j.m.a)) || (this.g.b >= 0 && (this.j.m == null || this.g.b != this.j.m.b)))))) || this.c != this.j.g))))) {
            TXCLog.i("TXCVideoPreprocessor", "Init sdk");
            TXCLog.i("TXCVideoPreprocessor", "Input widht " + i + " height " + i2);
            this.j.b = i;
            this.j.c = i2;
            if (this.g != null && this.g.a >= 0 && this.g.b >= 0 && this.g.c > 0 && this.g.d > 0) {
                int i6;
                TXCLog.i("TXCVideoPreprocessor", "set Crop Rect; init ");
                int i7 = i - this.g.a > this.g.c ? this.g.c : i - this.g.a;
                if (i2 - this.g.b > this.g.d) {
                    i6 = this.g.d;
                } else {
                    i6 = i2 - this.g.b;
                }
                this.g.c = i7;
                this.g.d = i6;
                i = this.g.c;
                i2 = this.g.d;
                this.j.m = this.g;
            }
            this.j.f = i3;
            this.j.a = this.b;
            this.j.k = i4;
            this.j.l = i5;
            if (true == this.l) {
                this.j.h = this.d;
                this.j.i = this.e;
            } else {
                this.j.h = 0;
                this.j.i = 0;
            }
            this.j.j = this.f;
            if (this.j.j <= 0) {
                this.j.j = 0;
            }
            if (this.j.h <= 0 || this.j.i <= 0) {
                if (90 == this.j.j || 270 == this.j.j) {
                    this.j.h = i2;
                    this.j.i = i;
                } else {
                    this.j.h = i;
                    this.j.i = i2;
                }
            }
            if (90 == this.j.j || 270 == this.j.j) {
                this.j.d = this.j.i;
                this.j.e = this.j.h;
            } else {
                this.j.d = this.j.h;
                this.j.e = this.j.i;
            }
            if (true != this.l) {
                this.j.h = this.d;
                this.j.i = this.e;
                if (this.j.h <= 0 || this.j.i <= 0) {
                    if (90 == this.j.j || 270 == this.j.j) {
                        this.j.h = i2;
                        this.j.i = i;
                    } else {
                        this.j.h = i;
                        this.j.i = i2;
                    }
                }
            }
            this.j.g = this.c;
            if (!a(this.j)) {
                TXCLog.e("TXCVideoPreprocessor", "init failed!");
                AppMethodBeat.o(67068);
                return false;
            }
        } else if (!(i4 == this.j.k && i5 == this.j.l)) {
            this.j.k = i4;
            this.i.k = i4;
            this.j.l = i5;
            this.i.l = i5;
            this.h.a(i5);
        }
        AppMethodBeat.o(67068);
        return true;
    }

    private boolean a(c cVar) {
        AppMethodBeat.i(67069);
        this.i.d = cVar.b;
        this.i.e = cVar.c;
        this.i.m = cVar.m;
        this.i.g = cVar.d;
        this.i.f = cVar.e;
        this.i.h = (cVar.f + v2helper.VOIP_ENC_HEIGHT_LV1) % v2helper.VOIP_ENC_HEIGHT_LV1;
        this.i.b = cVar.h;
        this.i.c = cVar.i;
        this.i.a = cVar.j;
        this.i.j = cVar.a;
        this.i.i = cVar.g;
        this.i.k = cVar.k;
        this.i.l = cVar.l;
        if (this.h == null) {
            this.h = new b(this.a, cVar.a);
        }
        boolean a = this.h.a(this.i);
        AppMethodBeat.o(67069);
        return a;
    }

    public synchronized void a() {
        AppMethodBeat.i(67070);
        if (this.h != null) {
            this.h.a();
        }
        this.j = null;
        AppMethodBeat.o(67070);
    }

    public synchronized void b(int i) {
        AppMethodBeat.i(67071);
        if (this.h != null) {
            this.h.c(i);
        }
        this.p.a("beautyStyle", i);
        AppMethodBeat.o(67071);
    }

    public synchronized void c(int i) {
        AppMethodBeat.i(67072);
        if (i > 9) {
            TXCLog.e("TXCVideoPreprocessor", "Beauty value too large! set max value 9");
            i = 9;
        } else if (i < 0) {
            TXCLog.e("TXCVideoPreprocessor", "Beauty < 0; set 0");
            i = 0;
        }
        if (this.h != null) {
            this.h.b(i);
        }
        this.p.a("beautyLevel", i);
        AppMethodBeat.o(67072);
    }

    public synchronized void d(int i) {
        AppMethodBeat.i(67073);
        if (i > 9) {
            TXCLog.e("TXCVideoPreprocessor", "Brightness value too large! set max value 9");
            i = 9;
        } else if (i < 0) {
            TXCLog.e("TXCVideoPreprocessor", "Brightness < 0; set 0");
            i = 0;
        }
        if (this.h != null) {
            this.h.d(i);
        }
        this.p.a("whiteLevel", i);
        AppMethodBeat.o(67073);
    }

    public synchronized void e(int i) {
        AppMethodBeat.i(67074);
        if (i > 9) {
            TXCLog.e("TXCVideoPreprocessor", "Ruddy value too large! set max value 9");
            i = 9;
        } else if (i < 0) {
            TXCLog.e("TXCVideoPreprocessor", "Ruddy < 0; set 0");
            i = 0;
        }
        if (this.h != null) {
            this.h.f(i);
        }
        this.p.a("ruddyLevel", i);
        AppMethodBeat.o(67074);
    }

    public void f(int i) {
        AppMethodBeat.i(67075);
        if (i > 9) {
            TXCLog.e("TXCVideoPreprocessor", "Brightness value too large! set max value 9");
            i = 9;
        } else if (i < 0) {
            TXCLog.e("TXCVideoPreprocessor", "Brightness < 0; set 0");
            i = 0;
        }
        if (this.h != null) {
            this.h.e(i);
        }
        AppMethodBeat.o(67075);
    }

    public synchronized void a(String str) {
        AppMethodBeat.i(67076);
        if (this.h != null) {
            this.h.a(str);
        }
        AppMethodBeat.o(67076);
    }

    public synchronized void b(boolean z) {
        AppMethodBeat.i(67077);
        if (this.h != null) {
            this.h.a(z);
        }
        AppMethodBeat.o(67077);
    }

    @TargetApi(18)
    public boolean a(String str, boolean z) {
        AppMethodBeat.i(67078);
        if (VERSION.SDK_INT < 18) {
            AppMethodBeat.o(67078);
            return false;
        }
        if (this.h != null) {
            this.h.a(str, z);
        }
        AppMethodBeat.o(67078);
        return true;
    }

    public synchronized void g(int i) {
        AppMethodBeat.i(67079);
        if (this.h != null) {
            this.h.g(i);
        }
        this.p.a("eyeBigScale", i);
        AppMethodBeat.o(67079);
    }

    public synchronized void h(int i) {
        AppMethodBeat.i(67080);
        if (this.h != null) {
            this.h.h(i);
        }
        this.p.a("faceSlimLevel", i);
        AppMethodBeat.o(67080);
    }

    public void i(int i) {
        AppMethodBeat.i(67081);
        if (this.h != null) {
            this.h.i(i);
        }
        this.p.a("faceVLevel", i);
        AppMethodBeat.o(67081);
    }

    public void j(int i) {
        AppMethodBeat.i(67082);
        if (this.h != null) {
            this.h.j(i);
        }
        this.p.a("faceShortLevel", i);
        AppMethodBeat.o(67082);
    }

    public void k(int i) {
        AppMethodBeat.i(67083);
        if (this.h != null) {
            this.h.k(i);
        }
        this.p.a("chinLevel", i);
        AppMethodBeat.o(67083);
    }

    public void l(int i) {
        AppMethodBeat.i(67084);
        if (this.h != null) {
            this.h.l(i);
        }
        this.p.a("noseSlimLevel", i);
        AppMethodBeat.o(67084);
    }

    public synchronized void a(float f) {
        AppMethodBeat.i(67085);
        if (this.h != null) {
            this.h.a(f);
        }
        AppMethodBeat.o(67085);
    }

    public synchronized void a(Bitmap bitmap) {
        AppMethodBeat.i(67086);
        if (this.h != null) {
            this.h.a(bitmap);
        }
        AppMethodBeat.o(67086);
    }

    public void setID(String str) {
        AppMethodBeat.i(67087);
        super.setID(str);
        setStatusValue(3001, this.p.a());
        AppMethodBeat.o(67087);
    }
}
