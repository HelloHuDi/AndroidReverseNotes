package com.tencent.tencentmap.mapsdk.maps.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import com.tencent.map.lib.f;
import com.tencent.map.lib.gl.JNICallback.j;
import com.tencent.map.lib.gl.JNICallback.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.be;
import com.tencent.tencentmap.mapsdk.a.bg;
import com.tencent.tencentmap.mapsdk.a.da;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.microedition.khronos.opengles.GL10;

public class lo extends hz implements j, k {
    lt a;
    private WeakReference<ls> b;
    private ll c;
    private volatile int d = -1;
    private volatile ExecutorService e = null;

    static /* synthetic */ da b(lo loVar, String str) {
        AppMethodBeat.i(100462);
        da b = loVar.b(str);
        AppMethodBeat.o(100462);
        return b;
    }

    public lo(ls lsVar, lt ltVar) {
        AppMethodBeat.i(100454);
        if (lsVar == null || lsVar.a() == null) {
            AppMethodBeat.o(100454);
            return;
        }
        f b = lsVar.a().b();
        this.c = ll.a(lsVar.a().i().getApplicationContext());
        this.b = new WeakReference(lsVar);
        this.a = ltVar;
        b.a((j) this);
        b.a((k) this);
        this.d = b.e(false);
        AppMethodBeat.o(100454);
    }

    public void a(GL10 gl10) {
    }

    public boolean a(float f, float f2) {
        return false;
    }

    public boolean a() {
        return false;
    }

    public void b() {
    }

    public void d() {
        AppMethodBeat.i(100455);
        if (!(this.b == null || this.b.get() == null)) {
            iz a = ((ls) this.b.get()).a();
            if (!(a == null || a.b() == null)) {
                f b = a.b();
                b.a(null);
                b.a(null);
                b.i(this.d);
                this.d = -1;
            }
        }
        AppMethodBeat.o(100455);
    }

    public void c() {
    }

    public Bitmap a(byte[] bArr) {
        AppMethodBeat.i(100456);
        if (this.b == null || this.b.get() == null || this.d == -1) {
            AppMethodBeat.o(100456);
            return null;
        }
        bg bgVar = new bg();
        bgVar.a(bArr);
        be beVar = new be(bgVar.a(), bgVar.b(), bgVar.c(), 0, this.a.a());
        Bitmap a = this.c.a(beVar);
        if (a != null) {
            AppMethodBeat.o(100456);
            return a;
        }
        String a2 = this.a.a(beVar.a(), beVar.b(), beVar.c());
        if (a2 == null) {
            AppMethodBeat.o(100456);
            return null;
        }
        byte[] bytes = a2.getBytes();
        Arrays.fill(bArr, (byte) 0);
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        AppMethodBeat.o(100456);
        return null;
    }

    public void a(final String str, final byte[] bArr, final byte[] bArr2) {
        AppMethodBeat.i(100457);
        if (this.e == null) {
            synchronized (lo.class) {
                try {
                    if (this.e == null) {
                        this.e = Executors.newSingleThreadExecutor();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(100457);
                    }
                }
            }
        }
        if (!this.e.isShutdown()) {
            this.e.execute(new Runnable() {
                public void run() {
                    AppMethodBeat.i(100453);
                    if (lo.a(lo.this, str)) {
                        bg bgVar = new bg();
                        bgVar.a(bArr);
                        be beVar = new be(bgVar.a(), bgVar.b(), bgVar.c(), 0, lo.b(lo.this, str));
                        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length);
                        if (decodeByteArray != null) {
                            if (!(lo.this.b == null || lo.this.b.get() == null)) {
                                ((ls) lo.this.b.get()).a(1);
                            }
                            lo.this.c.a(ht.a(decodeByteArray, CompressFormat.PNG), beVar);
                        }
                        AppMethodBeat.o(100453);
                        return;
                    }
                    AppMethodBeat.o(100453);
                }
            });
        }
        AppMethodBeat.o(100457);
    }

    public void e() {
        AppMethodBeat.i(100458);
        if (!(this.d == -1 || this.b == null || this.b.get() == null)) {
            ((ls) this.b.get()).a().b().j(this.d);
        }
        AppMethodBeat.o(100458);
    }

    private boolean a(String str) {
        AppMethodBeat.i(100459);
        if (str != null && str.length() > 0) {
            Matcher matcher = Pattern.compile("version=\\d+").matcher(str);
            if (matcher.find()) {
                String group = matcher.group();
                if (Integer.parseInt(group.substring(group.indexOf("=") + 1)) == lq.c()) {
                    AppMethodBeat.o(100459);
                    return true;
                }
                AppMethodBeat.o(100459);
                return false;
            }
        }
        AppMethodBeat.o(100459);
        return false;
    }

    private da b(String str) {
        AppMethodBeat.i(100460);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(100460);
            return null;
        }
        String str2 = "foreignLanguage";
        da valueOf = da.valueOf(str.substring((str2.length() + 1) + str.lastIndexOf(str2)));
        AppMethodBeat.o(100460);
        return valueOf;
    }
}
