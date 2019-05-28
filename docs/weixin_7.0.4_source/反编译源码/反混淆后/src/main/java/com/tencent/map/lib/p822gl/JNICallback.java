package com.tencent.map.lib.p822gl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.Typeface;
import com.tencent.map.lib.C1015d;
import com.tencent.map.lib.thread.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36507fk;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36515gv;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36517hl;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Hashtable;

/* renamed from: com.tencent.map.lib.gl.JNICallback */
public class JNICallback {
    /* renamed from: a */
    public C32213i f14973a = null;
    /* renamed from: b */
    private C36515gv f14974b;
    /* renamed from: c */
    private C32208a f14975c;
    /* renamed from: d */
    private C17849h f14976d;
    /* renamed from: e */
    private C25721e f14977e;
    /* renamed from: f */
    private C25720d f14978f;
    /* renamed from: g */
    private C32210j f14979g;
    /* renamed from: h */
    private C32211b f14980h;
    /* renamed from: i */
    private C32209c f14981i;
    /* renamed from: j */
    private C32212k f14982j;
    /* renamed from: k */
    private C17848g f14983k;
    /* renamed from: l */
    private C17847f f14984l;
    /* renamed from: m */
    private C36507fk f14985m;
    /* renamed from: n */
    private Hashtable<Long, Paint> f14986n = new Hashtable();
    /* renamed from: o */
    private Hashtable<Long, PointF> f14987o = new Hashtable();
    /* renamed from: p */
    private Bitmap f14988p = null;

    /* renamed from: com.tencent.map.lib.gl.JNICallback$f */
    public interface C17847f {
        int getEGLContextHash();
    }

    /* renamed from: com.tencent.map.lib.gl.JNICallback$g */
    public interface C17848g {
        /* renamed from: b */
        void mo33211b(boolean z);
    }

    /* renamed from: com.tencent.map.lib.gl.JNICallback$h */
    public interface C17849h {
        /* renamed from: h */
        void mo29391h(int i);
    }

    /* renamed from: com.tencent.map.lib.gl.JNICallback$d */
    public interface C25720d {
        /* renamed from: a */
        Bitmap mo43566a(byte[] bArr);
    }

    /* renamed from: com.tencent.map.lib.gl.JNICallback$e */
    public interface C25721e {
        /* renamed from: z */
        void mo29413z();
    }

    /* renamed from: com.tencent.map.lib.gl.JNICallback$IconImageInfo */
    public static class IconImageInfo {
        public float anchorPointX1;
        public float anchorPointY1;
        public Bitmap bitmap;
        public float scale;
    }

    /* renamed from: com.tencent.map.lib.gl.JNICallback$a */
    public interface C32208a {
        /* renamed from: d */
        void mo29375d(String str);
    }

    /* renamed from: com.tencent.map.lib.gl.JNICallback$c */
    public interface C32209c {
        /* renamed from: a */
        void mo52881a(String str, byte[] bArr, byte[] bArr2);
    }

    /* renamed from: com.tencent.map.lib.gl.JNICallback$j */
    public interface C32210j {
        /* renamed from: a */
        Bitmap mo52882a(byte[] bArr);
    }

    /* renamed from: com.tencent.map.lib.gl.JNICallback$b */
    public interface C32211b {
        /* renamed from: a */
        Bitmap mo52883a(byte[] bArr);
    }

    /* renamed from: com.tencent.map.lib.gl.JNICallback$k */
    public interface C32212k {
        /* renamed from: a */
        void mo52884a(String str, byte[] bArr, byte[] bArr2);
    }

    /* renamed from: com.tencent.map.lib.gl.JNICallback$i */
    public static class C32213i {
        /* renamed from: a */
        public float f14989a;
        /* renamed from: b */
        public int f14990b;
        /* renamed from: c */
        public int f14991c;
        /* renamed from: d */
        public int f14992d;
        /* renamed from: e */
        public boolean f14993e;
        /* renamed from: f */
        byte[] f14994f;

        /* synthetic */ C32213i(C178461 c178461) {
            this();
        }

        private C32213i() {
            AppMethodBeat.m2504i(98025);
            this.f14994f = new byte[4];
            AppMethodBeat.m2505o(98025);
        }

        /* renamed from: a */
        public void mo52885a(byte[] bArr) {
            AppMethodBeat.m2504i(98026);
            Arrays.fill(this.f14994f, (byte) 0);
            System.arraycopy(bArr, 0, this.f14994f, 0, 4);
            this.f14989a = C36517hl.m60441c(this.f14994f);
            System.arraycopy(bArr, 4, this.f14994f, 0, 4);
            this.f14990b = C36517hl.m60436a(this.f14994f);
            System.arraycopy(bArr, 8, this.f14994f, 0, 4);
            this.f14991c = C36517hl.m60436a(this.f14994f);
            System.arraycopy(bArr, 12, this.f14994f, 0, 4);
            this.f14992d = C36517hl.m60436a(this.f14994f);
            System.arraycopy(bArr, 16, this.f14994f, 0, 1);
            this.f14993e = C36517hl.m60440b(this.f14994f);
            AppMethodBeat.m2505o(98026);
        }
    }

    public JNICallback(C36515gv c36515gv, C32208a c32208a, C17849h c17849h, C25721e c25721e, C17848g c17848g, C36507fk c36507fk) {
        AppMethodBeat.m2504i(98027);
        this.f14974b = c36515gv;
        this.f14975c = c32208a;
        this.f14976d = c17849h;
        this.f14977e = c25721e;
        this.f14983k = c17848g;
        this.f14985m = c36507fk;
        this.f14988p = Bitmap.createBitmap(800, 400, Config.ALPHA_8);
        this.f14973a = new C32213i();
        AppMethodBeat.m2505o(98027);
    }

    /* renamed from: a */
    public void mo52873a() {
        AppMethodBeat.m2504i(98028);
        this.f14988p = null;
        this.f14973a = null;
        if (this.f14986n != null) {
            this.f14986n.clear();
            this.f14986n = null;
        }
        if (this.f14987o != null) {
            this.f14987o.clear();
            this.f14987o = null;
        }
        this.f14974b = null;
        this.f14975c = null;
        this.f14976d = null;
        this.f14977e = null;
        this.f14978f = null;
        this.f14979g = null;
        this.f14982j = null;
        AppMethodBeat.m2505o(98028);
    }

    /* renamed from: a */
    public void mo52876a(C25720d c25720d) {
        this.f14978f = c25720d;
    }

    /* renamed from: a */
    public void mo52874a(C32211b c32211b) {
        this.f14980h = c32211b;
    }

    /* renamed from: a */
    public void mo52875a(C32209c c32209c) {
        this.f14981i = c32209c;
    }

    /* renamed from: a */
    public void mo52878a(C32210j c32210j) {
        this.f14979g = c32210j;
    }

    /* renamed from: a */
    public void mo52879a(C32212k c32212k) {
        this.f14982j = c32212k;
    }

    /* renamed from: a */
    public void mo52877a(C17847f c17847f) {
        this.f14984l = c17847f;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public Object mo52872a(int i, int i2, String str, byte[] bArr) {
        Object a;
        boolean z = false;
        AppMethodBeat.m2504i(98029);
        switch (i) {
            case 1:
                a = m52533a(i2, str, bArr);
                break;
            case 2:
                a = m52535a(str, i2);
                break;
            case 3:
                m52539a(str);
                a = null;
                break;
            case 4:
                a = m52536a(i2, bArr);
                break;
            case 5:
                m52540a(str, bArr);
                a = null;
                break;
            case 6:
                if (this.f14976d != null) {
                    this.f14976d.mo29391h(i2);
                    a = null;
                    break;
                }
            case 7:
                if (this.f14985m != null) {
                    this.f14985m.mo29340a(str);
                    a = null;
                    break;
                }
            case 8:
                if (this.f14977e != null) {
                    this.f14977e.mo29413z();
                    a = null;
                    break;
                }
            case 9:
                if (this.f14978f != null) {
                    a = this.f14978f.mo43566a(bArr);
                    AppMethodBeat.m2505o(98029);
                    return a;
                }
                a = null;
                break;
            case 10:
                if (this.f14983k != null) {
                    C17848g c17848g = this.f14983k;
                    if (i2 > 0) {
                        z = true;
                    }
                    c17848g.mo33211b(z);
                    a = null;
                    break;
                }
            case 11:
                if (this.f14979g != null) {
                    a = this.f14979g.mo52882a(bArr);
                    AppMethodBeat.m2505o(98029);
                    return a;
                }
                a = null;
                break;
            case 12:
                if (this.f14982j != null) {
                    this.f14982j.mo52884a(str, Arrays.copyOfRange(bArr, 0, 12), Arrays.copyOfRange(bArr, 12, bArr.length));
                }
                a = null;
                break;
            case 13:
                if (this.f14980h != null) {
                    a = this.f14980h.mo52883a(bArr);
                    AppMethodBeat.m2505o(98029);
                    return a;
                }
                a = null;
                break;
            case 14:
                if (this.f14981i != null) {
                    this.f14981i.mo52881a(str, Arrays.copyOfRange(bArr, 0, 12), Arrays.copyOfRange(bArr, 12, bArr.length));
                    a = null;
                    break;
                }
        }
        a = null;
        AppMethodBeat.m2505o(98029);
        return a;
    }

    /* renamed from: b */
    public int mo52880b() {
        AppMethodBeat.m2504i(98030);
        if (this.f14984l != null) {
            int eGLContextHash = this.f14984l.getEGLContextHash();
            AppMethodBeat.m2505o(98030);
            return eGLContextHash;
        }
        AppMethodBeat.m2505o(98030);
        return 0;
    }

    /* renamed from: c */
    private Paint m52541c() {
        AppMethodBeat.m2504i(98031);
        if (this.f14986n == null) {
            AppMethodBeat.m2505o(98031);
            return null;
        }
        Paint paint = (Paint) this.f14986n.get(Long.valueOf(Thread.currentThread().getId()));
        AppMethodBeat.m2505o(98031);
        return paint;
    }

    /* renamed from: a */
    private void m52537a(Paint paint) {
        AppMethodBeat.m2504i(98032);
        if (this.f14986n != null) {
            this.f14986n.put(Long.valueOf(Thread.currentThread().getId()), paint);
        }
        AppMethodBeat.m2505o(98032);
    }

    /* renamed from: d */
    private PointF m52542d() {
        AppMethodBeat.m2504i(98033);
        if (this.f14987o == null) {
            AppMethodBeat.m2505o(98033);
            return null;
        }
        PointF pointF = (PointF) this.f14987o.get(Long.valueOf(Thread.currentThread().getId()));
        AppMethodBeat.m2505o(98033);
        return pointF;
    }

    /* renamed from: a */
    private void m52538a(PointF pointF) {
        AppMethodBeat.m2504i(98034);
        if (this.f14987o != null) {
            this.f14987o.put(Long.valueOf(Thread.currentThread().getId()), pointF);
        }
        AppMethodBeat.m2505o(98034);
    }

    /* renamed from: a */
    private Paint m52534a(int i) {
        AppMethodBeat.m2504i(98035);
        Paint c = m52541c();
        if (c == null) {
            c = new Paint();
            c.setTypeface(Typeface.DEFAULT);
            c.setAntiAlias(true);
            c.setStyle(Style.FILL);
            c.setTextAlign(Align.CENTER);
            c.setLinearText(true);
            m52537a(c);
        }
        c.setTextAlign(Align.CENTER);
        c.setTextSize((float) i);
        AppMethodBeat.m2505o(98035);
        return c;
    }

    /* renamed from: a */
    private Bitmap m52533a(int i, String str, byte[] bArr) {
        AppMethodBeat.m2504i(98036);
        if (this.f14988p == null) {
            this.f14988p = Bitmap.createBitmap(800, 400, Config.ALPHA_8);
        }
        if (this.f14988p == null) {
            AppMethodBeat.m2505o(98036);
            return null;
        }
        this.f14973a.mo52885a(bArr);
        Paint a = m52534a(i);
        this.f14988p.eraseColor(0);
        Canvas canvas = new Canvas(this.f14988p);
        float descent = 200.0f - ((a.descent() + a.ascent()) / 2.0f);
        a.setFakeBoldText(this.f14973a.f14993e);
        canvas.drawText(str, 400.0f, descent, a);
        Bitmap bitmap = this.f14988p;
        AppMethodBeat.m2505o(98036);
        return bitmap;
    }

    /* renamed from: a */
    private PointF m52535a(String str, int i) {
        AppMethodBeat.m2504i(98037);
        float measureText = 1.0f + m52534a(i).measureText(str);
        int i2 = i + 2;
        PointF d = m52542d();
        if (d == null) {
            d = new PointF();
            m52538a(d);
        }
        d.x = measureText;
        d.y = (float) i2;
        AppMethodBeat.m2505o(98037);
        return d;
    }

    /* renamed from: a */
    private IconImageInfo m52536a(int i, byte[] bArr) {
        IconImageInfo iconImageInfo = null;
        AppMethodBeat.m2504i(98038);
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.m2505o(98038);
        } else {
            try {
                String str = new String(bArr);
                if (i == 1) {
                    iconImageInfo = this.f14974b.mo57738a(str);
                    AppMethodBeat.m2505o(98038);
                } else {
                    iconImageInfo = this.f14974b.mo57741b(str);
                    AppMethodBeat.m2505o(98038);
                }
            } catch (Exception e) {
                AppMethodBeat.m2505o(98038);
            }
        }
        return iconImageInfo;
    }

    /* renamed from: a */
    private void m52539a(String str) {
        AppMethodBeat.m2504i(98039);
        if (this.f14975c != null) {
            C1015d.m2288a("Engine callback download:".concat(String.valueOf(str)));
            this.f14975c.mo29375d(str);
        }
        AppMethodBeat.m2505o(98039);
    }

    /* renamed from: a */
    private void m52540a(final String str, final byte[] bArr) {
        AppMethodBeat.m2504i(98040);
        if (bArr == null) {
            AppMethodBeat.m2505o(98040);
            return;
        }
        new AsyncTask<Void, Void, Void>() {
            public /* synthetic */ Object doInBackground(Object[] objArr) {
                AppMethodBeat.m2504i(98024);
                Void a = mo33209a((Void[]) objArr);
                AppMethodBeat.m2505o(98024);
                return a;
            }

            /* Access modifiers changed, original: protected|varargs */
            /* JADX WARNING: Removed duplicated region for block: B:13:0x003d  */
            /* JADX WARNING: Removed duplicated region for block: B:13:0x003d  */
            /* JADX WARNING: Removed duplicated region for block: B:13:0x003d  */
            /* JADX WARNING: Removed duplicated region for block: B:13:0x003d  */
            /* JADX WARNING: Removed duplicated region for block: B:21:0x0052 A:{SYNTHETIC, Splitter:B:21:0x0052} */
            /* JADX WARNING: Removed duplicated region for block: B:13:0x003d  */
            /* JADX WARNING: Removed duplicated region for block: B:29:0x005e A:{SYNTHETIC, Splitter:B:29:0x005e} */
            /* JADX WARNING: Removed duplicated region for block: B:13:0x003d  */
            /* JADX WARNING: Removed duplicated region for block: B:37:0x006b A:{SYNTHETIC, Splitter:B:37:0x006b} */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            /* renamed from: a */
            public Void mo33209a(Void... voidArr) {
                Object obj;
                Throwable th;
                FileOutputStream fileOutputStream;
                AppMethodBeat.m2504i(98023);
                File file = new File(str + ".tmp");
                FileOutputStream fileOutputStream2;
                try {
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(bArr);
                        try {
                            fileOutputStream2.close();
                            obj = 1;
                        } catch (IOException e) {
                            int obj2 = 1;
                        }
                    } catch (FileNotFoundException e2) {
                        if (fileOutputStream2 != null) {
                        }
                        obj2 = null;
                        if (obj2 != null) {
                        }
                        AppMethodBeat.m2505o(98023);
                        return null;
                    } catch (IOException e3) {
                        if (fileOutputStream2 != null) {
                        }
                        obj2 = null;
                        if (obj2 != null) {
                        }
                        AppMethodBeat.m2505o(98023);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                        }
                        AppMethodBeat.m2505o(98023);
                        throw th;
                    }
                } catch (FileNotFoundException e4) {
                    fileOutputStream2 = null;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                            obj2 = null;
                        } catch (IOException e5) {
                            obj2 = null;
                        }
                        if (obj2 != null) {
                        }
                        AppMethodBeat.m2505o(98023);
                        return null;
                    }
                    obj2 = null;
                    if (obj2 != null) {
                    }
                    AppMethodBeat.m2505o(98023);
                    return null;
                } catch (IOException e6) {
                    fileOutputStream2 = null;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                            obj2 = null;
                        } catch (IOException e7) {
                            obj2 = null;
                        }
                        if (obj2 != null) {
                        }
                        AppMethodBeat.m2505o(98023);
                        return null;
                    }
                    obj2 = null;
                    if (obj2 != null) {
                    }
                    AppMethodBeat.m2505o(98023);
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e8) {
                        }
                    }
                    AppMethodBeat.m2505o(98023);
                    throw th;
                }
                if (obj2 != null) {
                    file.renameTo(new File(str));
                }
                AppMethodBeat.m2505o(98023);
                return null;
            }
        }.execute((Object[]) new Void[0]);
        AppMethodBeat.m2505o(98040);
    }
}
