package com.tencent.map.lib.gl;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.Typeface;
import com.tencent.map.lib.thread.AsyncTask;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.fk;
import com.tencent.tencentmap.mapsdk.maps.a.gv;
import com.tencent.tencentmap.mapsdk.maps.a.hl;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Hashtable;

public class JNICallback {
    public i a = null;
    private gv b;
    private a c;
    private h d;
    private e e;
    private d f;
    private j g;
    private b h;
    private c i;
    private k j;
    private g k;
    private f l;
    private fk m;
    private Hashtable<Long, Paint> n = new Hashtable();
    private Hashtable<Long, PointF> o = new Hashtable();
    private Bitmap p = null;

    public interface f {
        int getEGLContextHash();
    }

    public interface g {
        void b(boolean z);
    }

    public interface h {
        void h(int i);
    }

    public interface d {
        Bitmap a(byte[] bArr);
    }

    public interface e {
        void z();
    }

    public static class IconImageInfo {
        public float anchorPointX1;
        public float anchorPointY1;
        public Bitmap bitmap;
        public float scale;
    }

    public interface a {
        void d(String str);
    }

    public interface c {
        void a(String str, byte[] bArr, byte[] bArr2);
    }

    public interface j {
        Bitmap a(byte[] bArr);
    }

    public interface b {
        Bitmap a(byte[] bArr);
    }

    public interface k {
        void a(String str, byte[] bArr, byte[] bArr2);
    }

    public static class i {
        public float a;
        public int b;
        public int c;
        public int d;
        public boolean e;
        byte[] f;

        /* synthetic */ i(AnonymousClass1 anonymousClass1) {
            this();
        }

        private i() {
            AppMethodBeat.i(98025);
            this.f = new byte[4];
            AppMethodBeat.o(98025);
        }

        public void a(byte[] bArr) {
            AppMethodBeat.i(98026);
            Arrays.fill(this.f, (byte) 0);
            System.arraycopy(bArr, 0, this.f, 0, 4);
            this.a = hl.c(this.f);
            System.arraycopy(bArr, 4, this.f, 0, 4);
            this.b = hl.a(this.f);
            System.arraycopy(bArr, 8, this.f, 0, 4);
            this.c = hl.a(this.f);
            System.arraycopy(bArr, 12, this.f, 0, 4);
            this.d = hl.a(this.f);
            System.arraycopy(bArr, 16, this.f, 0, 1);
            this.e = hl.b(this.f);
            AppMethodBeat.o(98026);
        }
    }

    public JNICallback(gv gvVar, a aVar, h hVar, e eVar, g gVar, fk fkVar) {
        AppMethodBeat.i(98027);
        this.b = gvVar;
        this.c = aVar;
        this.d = hVar;
        this.e = eVar;
        this.k = gVar;
        this.m = fkVar;
        this.p = Bitmap.createBitmap(800, 400, Config.ALPHA_8);
        this.a = new i();
        AppMethodBeat.o(98027);
    }

    public void a() {
        AppMethodBeat.i(98028);
        this.p = null;
        this.a = null;
        if (this.n != null) {
            this.n.clear();
            this.n = null;
        }
        if (this.o != null) {
            this.o.clear();
            this.o = null;
        }
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.j = null;
        AppMethodBeat.o(98028);
    }

    public void a(d dVar) {
        this.f = dVar;
    }

    public void a(b bVar) {
        this.h = bVar;
    }

    public void a(c cVar) {
        this.i = cVar;
    }

    public void a(j jVar) {
        this.g = jVar;
    }

    public void a(k kVar) {
        this.j = kVar;
    }

    public void a(f fVar) {
        this.l = fVar;
    }

    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Object a(int i, int i2, String str, byte[] bArr) {
        Object a;
        boolean z = false;
        AppMethodBeat.i(98029);
        switch (i) {
            case 1:
                a = a(i2, str, bArr);
                break;
            case 2:
                a = a(str, i2);
                break;
            case 3:
                a(str);
                a = null;
                break;
            case 4:
                a = a(i2, bArr);
                break;
            case 5:
                a(str, bArr);
                a = null;
                break;
            case 6:
                if (this.d != null) {
                    this.d.h(i2);
                    a = null;
                    break;
                }
            case 7:
                if (this.m != null) {
                    this.m.a(str);
                    a = null;
                    break;
                }
            case 8:
                if (this.e != null) {
                    this.e.z();
                    a = null;
                    break;
                }
            case 9:
                if (this.f != null) {
                    a = this.f.a(bArr);
                    AppMethodBeat.o(98029);
                    return a;
                }
                a = null;
                break;
            case 10:
                if (this.k != null) {
                    g gVar = this.k;
                    if (i2 > 0) {
                        z = true;
                    }
                    gVar.b(z);
                    a = null;
                    break;
                }
            case 11:
                if (this.g != null) {
                    a = this.g.a(bArr);
                    AppMethodBeat.o(98029);
                    return a;
                }
                a = null;
                break;
            case 12:
                if (this.j != null) {
                    this.j.a(str, Arrays.copyOfRange(bArr, 0, 12), Arrays.copyOfRange(bArr, 12, bArr.length));
                }
                a = null;
                break;
            case 13:
                if (this.h != null) {
                    a = this.h.a(bArr);
                    AppMethodBeat.o(98029);
                    return a;
                }
                a = null;
                break;
            case 14:
                if (this.i != null) {
                    this.i.a(str, Arrays.copyOfRange(bArr, 0, 12), Arrays.copyOfRange(bArr, 12, bArr.length));
                    a = null;
                    break;
                }
        }
        a = null;
        AppMethodBeat.o(98029);
        return a;
    }

    public int b() {
        AppMethodBeat.i(98030);
        if (this.l != null) {
            int eGLContextHash = this.l.getEGLContextHash();
            AppMethodBeat.o(98030);
            return eGLContextHash;
        }
        AppMethodBeat.o(98030);
        return 0;
    }

    private Paint c() {
        AppMethodBeat.i(98031);
        if (this.n == null) {
            AppMethodBeat.o(98031);
            return null;
        }
        Paint paint = (Paint) this.n.get(Long.valueOf(Thread.currentThread().getId()));
        AppMethodBeat.o(98031);
        return paint;
    }

    private void a(Paint paint) {
        AppMethodBeat.i(98032);
        if (this.n != null) {
            this.n.put(Long.valueOf(Thread.currentThread().getId()), paint);
        }
        AppMethodBeat.o(98032);
    }

    private PointF d() {
        AppMethodBeat.i(98033);
        if (this.o == null) {
            AppMethodBeat.o(98033);
            return null;
        }
        PointF pointF = (PointF) this.o.get(Long.valueOf(Thread.currentThread().getId()));
        AppMethodBeat.o(98033);
        return pointF;
    }

    private void a(PointF pointF) {
        AppMethodBeat.i(98034);
        if (this.o != null) {
            this.o.put(Long.valueOf(Thread.currentThread().getId()), pointF);
        }
        AppMethodBeat.o(98034);
    }

    private Paint a(int i) {
        AppMethodBeat.i(98035);
        Paint c = c();
        if (c == null) {
            c = new Paint();
            c.setTypeface(Typeface.DEFAULT);
            c.setAntiAlias(true);
            c.setStyle(Style.FILL);
            c.setTextAlign(Align.CENTER);
            c.setLinearText(true);
            a(c);
        }
        c.setTextAlign(Align.CENTER);
        c.setTextSize((float) i);
        AppMethodBeat.o(98035);
        return c;
    }

    private Bitmap a(int i, String str, byte[] bArr) {
        AppMethodBeat.i(98036);
        if (this.p == null) {
            this.p = Bitmap.createBitmap(800, 400, Config.ALPHA_8);
        }
        if (this.p == null) {
            AppMethodBeat.o(98036);
            return null;
        }
        this.a.a(bArr);
        Paint a = a(i);
        this.p.eraseColor(0);
        Canvas canvas = new Canvas(this.p);
        float descent = 200.0f - ((a.descent() + a.ascent()) / 2.0f);
        a.setFakeBoldText(this.a.e);
        canvas.drawText(str, 400.0f, descent, a);
        Bitmap bitmap = this.p;
        AppMethodBeat.o(98036);
        return bitmap;
    }

    private PointF a(String str, int i) {
        AppMethodBeat.i(98037);
        float measureText = 1.0f + a(i).measureText(str);
        int i2 = i + 2;
        PointF d = d();
        if (d == null) {
            d = new PointF();
            a(d);
        }
        d.x = measureText;
        d.y = (float) i2;
        AppMethodBeat.o(98037);
        return d;
    }

    private IconImageInfo a(int i, byte[] bArr) {
        IconImageInfo iconImageInfo = null;
        AppMethodBeat.i(98038);
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.o(98038);
        } else {
            try {
                String str = new String(bArr);
                if (i == 1) {
                    iconImageInfo = this.b.a(str);
                    AppMethodBeat.o(98038);
                } else {
                    iconImageInfo = this.b.b(str);
                    AppMethodBeat.o(98038);
                }
            } catch (Exception e) {
                AppMethodBeat.o(98038);
            }
        }
        return iconImageInfo;
    }

    private void a(String str) {
        AppMethodBeat.i(98039);
        if (this.c != null) {
            com.tencent.map.lib.d.a("Engine callback download:".concat(String.valueOf(str)));
            this.c.d(str);
        }
        AppMethodBeat.o(98039);
    }

    private void a(final String str, final byte[] bArr) {
        AppMethodBeat.i(98040);
        if (bArr == null) {
            AppMethodBeat.o(98040);
            return;
        }
        new AsyncTask<Void, Void, Void>() {
            public /* synthetic */ Object doInBackground(Object[] objArr) {
                AppMethodBeat.i(98024);
                Void a = a((Void[]) objArr);
                AppMethodBeat.o(98024);
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
            public Void a(Void... voidArr) {
                Object obj;
                Throwable th;
                FileOutputStream fileOutputStream;
                AppMethodBeat.i(98023);
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
                        AppMethodBeat.o(98023);
                        return null;
                    } catch (IOException e3) {
                        if (fileOutputStream2 != null) {
                        }
                        obj2 = null;
                        if (obj2 != null) {
                        }
                        AppMethodBeat.o(98023);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                        }
                        AppMethodBeat.o(98023);
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
                        AppMethodBeat.o(98023);
                        return null;
                    }
                    obj2 = null;
                    if (obj2 != null) {
                    }
                    AppMethodBeat.o(98023);
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
                        AppMethodBeat.o(98023);
                        return null;
                    }
                    obj2 = null;
                    if (obj2 != null) {
                    }
                    AppMethodBeat.o(98023);
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
                    AppMethodBeat.o(98023);
                    throw th;
                }
                if (obj2 != null) {
                    file.renameTo(new File(str));
                }
                AppMethodBeat.o(98023);
                return null;
            }
        }.execute((Object[]) new Void[0]);
        AppMethodBeat.o(98040);
    }
}
