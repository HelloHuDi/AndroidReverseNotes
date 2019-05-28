package android.support.v4.a;

import android.graphics.Bitmap;
import android.os.Build.VERSION;

public final class a {
    static final c GY;

    static class a extends c {
        a() {
        }
    }

    static class c {
        c() {
        }

        public int c(Bitmap bitmap) {
            return bitmap.getByteCount();
        }
    }

    static class b extends a {
        b() {
        }

        public final int c(Bitmap bitmap) {
            return bitmap.getAllocationByteCount();
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            GY = new b();
        } else if (VERSION.SDK_INT >= 18) {
            GY = new a();
        } else {
            GY = new c();
        }
    }

    public static int c(Bitmap bitmap) {
        return GY.c(bitmap);
    }
}
