package com.bumptech.glide.p086c.p092d.p093a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.p057v4.widget.C8415j;
import android.util.Log;
import com.bumptech.glide.p086c.p088b.C17526u;
import com.bumptech.glide.p086c.p088b.p089a.C31925e;
import com.bumptech.glide.p086c.p088b.p089a.C36670f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.Lock;

/* renamed from: com.bumptech.glide.c.d.a.i */
final class C44995i {
    private static final C31925e aFu = new C254431();

    /* renamed from: com.bumptech.glide.c.d.a.i$1 */
    class C254431 extends C36670f {
        C254431() {
        }

        /* renamed from: g */
        public final void mo2199g(Bitmap bitmap) {
        }
    }

    static {
        AppMethodBeat.m2504i(92234);
        AppMethodBeat.m2505o(92234);
    }

    /* renamed from: a */
    static C17526u<Bitmap> m82394a(C31925e c31925e, Drawable drawable, int i, int i2) {
        Object obj;
        AppMethodBeat.m2504i(92232);
        Drawable current = drawable.getCurrent();
        Bitmap bitmap = null;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
            obj = null;
        } else if (current instanceof Animatable) {
            obj = null;
        } else {
            Bitmap b = C44995i.m82395b(c31925e, current, i, i2);
            obj = 1;
            bitmap = b;
        }
        if (obj == null) {
            c31925e = aFu;
        }
        C0771d a = C0771d.m1760a(bitmap, c31925e);
        AppMethodBeat.m2505o(92232);
        return a;
    }

    /* renamed from: b */
    private static Bitmap m82395b(C31925e c31925e, Drawable drawable, int i, int i2) {
        Bitmap bitmap = null;
        AppMethodBeat.m2504i(92233);
        if (i == C8415j.INVALID_ID && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                new StringBuilder("Unable to draw ").append(drawable).append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            AppMethodBeat.m2505o(92233);
        } else if (i2 != C8415j.INVALID_ID || drawable.getIntrinsicHeight() > 0) {
            if (drawable.getIntrinsicWidth() > 0) {
                i = drawable.getIntrinsicWidth();
            }
            if (drawable.getIntrinsicHeight() > 0) {
                i2 = drawable.getIntrinsicHeight();
            }
            Lock nx = C44996p.m82399nx();
            nx.lock();
            bitmap = c31925e.mo2198c(i, i2, Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(bitmap);
                drawable.setBounds(0, 0, i, i2);
                drawable.draw(canvas);
                canvas.setBitmap(null);
            } finally {
                nx.unlock();
                AppMethodBeat.m2505o(92233);
            }
        } else {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                new StringBuilder("Unable to draw ").append(drawable).append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
            }
            AppMethodBeat.m2505o(92233);
        }
        return bitmap;
    }
}
