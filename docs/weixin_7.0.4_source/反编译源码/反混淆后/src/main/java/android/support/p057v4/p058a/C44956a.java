package android.support.p057v4.p058a;

import android.graphics.Bitmap;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.a.a */
public final class C44956a {
    /* renamed from: GY */
    static final C17427c f17673GY;

    /* renamed from: android.support.v4.a.a$a */
    static class C8376a extends C17427c {
        C8376a() {
        }
    }

    /* renamed from: android.support.v4.a.a$c */
    static class C17427c {
        C17427c() {
        }

        /* renamed from: c */
        public int mo31690c(Bitmap bitmap) {
            return bitmap.getByteCount();
        }
    }

    /* renamed from: android.support.v4.a.a$b */
    static class C25331b extends C8376a {
        C25331b() {
        }

        /* renamed from: c */
        public final int mo31690c(Bitmap bitmap) {
            return bitmap.getAllocationByteCount();
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            f17673GY = new C25331b();
        } else if (VERSION.SDK_INT >= 18) {
            f17673GY = new C8376a();
        } else {
            f17673GY = new C17427c();
        }
    }

    /* renamed from: c */
    public static int m82246c(Bitmap bitmap) {
        return f17673GY.mo31690c(bitmap);
    }
}
