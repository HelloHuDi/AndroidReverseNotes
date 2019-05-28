package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.be;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ju implements jw {
    private ll a;
    private jv b;
    private js c;
    private volatile ExecutorService d = null;

    public ju(Context context) {
        AppMethodBeat.i(100113);
        this.a = ll.a(context);
        this.b = new jv(a(context));
        this.c = new js();
        this.d = Executors.newSingleThreadExecutor();
        AppMethodBeat.o(100113);
    }

    public Bitmap a(int i, int i2, int i3, byte[] bArr) {
        AppMethodBeat.i(100114);
        be beVar = new be(i, i2, i3, 1);
        Bitmap a = this.b.a(beVar.toString());
        if (a != null) {
            AppMethodBeat.o(100114);
            return a;
        }
        Options c = c();
        Bitmap a2 = this.b.a();
        if (a2 != null) {
            c.inBitmap = a2;
        }
        beVar.a(c);
        a = a(beVar);
        if (a != null) {
            this.b.a(beVar.toString(), a);
            AppMethodBeat.o(100114);
            return a;
        }
        a(beVar, bArr);
        AppMethodBeat.o(100114);
        return null;
    }

    public void a(int i, int i2, int i3, final String str, final byte[] bArr) {
        AppMethodBeat.i(100115);
        final be beVar = new be(i, i2, i3, 1);
        if (a(str)) {
            Options c = c();
            Bitmap a = this.b.a();
            if (a != null) {
                c.inBitmap = a;
            }
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, c);
            if (decodeByteArray != null) {
                this.b.a(beVar.toString(), decodeByteArray);
                this.d.execute(new Runnable() {
                    public void run() {
                        AppMethodBeat.i(100112);
                        if (ju.a(ju.this, str)) {
                            ju.this.a.a(bArr, beVar);
                            AppMethodBeat.o(100112);
                            return;
                        }
                        AppMethodBeat.o(100112);
                    }
                });
            }
            AppMethodBeat.o(100115);
            return;
        }
        AppMethodBeat.o(100115);
    }

    public void a() {
        AppMethodBeat.i(100116);
        this.b.b();
        this.a.a(1);
        AppMethodBeat.o(100116);
    }

    public void b() {
        AppMethodBeat.i(100117);
        this.b.c();
        AppMethodBeat.o(100117);
    }

    private Bitmap a(be beVar) {
        AppMethodBeat.i(100118);
        if (beVar == null) {
            AppMethodBeat.o(100118);
            return null;
        }
        Options c = c();
        Bitmap a = this.b.a();
        if (a != null) {
            c.inBitmap = a;
        }
        beVar.a(c);
        Bitmap a2 = this.a.a(beVar);
        AppMethodBeat.o(100118);
        return a2;
    }

    private void a(be beVar, byte[] bArr) {
        AppMethodBeat.i(100119);
        String a = this.c.a(beVar.a(), beVar.b(), beVar.c());
        if (a == null) {
            AppMethodBeat.o(100119);
            return;
        }
        byte[] bytes = a.getBytes();
        Arrays.fill(bArr, (byte) 0);
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        AppMethodBeat.o(100119);
    }

    private Options c() {
        AppMethodBeat.i(100120);
        Options options = new Options();
        options.inPreferredConfig = Config.ARGB_8888;
        options.inSampleSize = 1;
        options.outWidth = 256;
        options.outHeight = 256;
        options.inMutable = true;
        AppMethodBeat.o(100120);
        return options;
    }

    private boolean a(String str) {
        AppMethodBeat.i(100121);
        if (str != null && str.length() > 0) {
            Matcher matcher = Pattern.compile("version=\\d+").matcher(str);
            if (matcher.find()) {
                String group = matcher.group();
                if (Integer.parseInt(group.substring(group.indexOf("=") + 1)) == jp.a()) {
                    AppMethodBeat.o(100121);
                    return true;
                }
                AppMethodBeat.o(100121);
                return false;
            }
        }
        AppMethodBeat.o(100121);
        return false;
    }

    private int a(Context context) {
        AppMethodBeat.i(100122);
        int i = ((((int) (((((double) context.getResources().getDisplayMetrics().heightPixels) * 1.0d) / 256.0d) + 0.5d)) * 262144) * ((int) (((((double) context.getResources().getDisplayMetrics().widthPixels) * 1.0d) / 256.0d) + 0.5d))) * 3;
        AppMethodBeat.o(100122);
        return i;
    }
}
