package com.bumptech.glide.c.d.a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.j;
import android.util.Log;
import com.bumptech.glide.c.b.a.e;
import com.bumptech.glide.c.b.a.f;
import com.bumptech.glide.c.b.u;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.Lock;

final class i {
    private static final e aFu = new f() {
        public final void g(Bitmap bitmap) {
        }
    };

    static {
        AppMethodBeat.i(92234);
        AppMethodBeat.o(92234);
    }

    static u<Bitmap> a(e eVar, Drawable drawable, int i, int i2) {
        Object obj;
        AppMethodBeat.i(92232);
        Drawable current = drawable.getCurrent();
        Bitmap bitmap = null;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
            obj = null;
        } else if (current instanceof Animatable) {
            obj = null;
        } else {
            Bitmap b = b(eVar, current, i, i2);
            obj = 1;
            bitmap = b;
        }
        if (obj == null) {
            eVar = aFu;
        }
        d a = d.a(bitmap, eVar);
        AppMethodBeat.o(92232);
        return a;
    }

    private static Bitmap b(e eVar, Drawable drawable, int i, int i2) {
        Bitmap bitmap = null;
        AppMethodBeat.i(92233);
        if (i == j.INVALID_ID && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                new StringBuilder("Unable to draw ").append(drawable).append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            AppMethodBeat.o(92233);
        } else if (i2 != j.INVALID_ID || drawable.getIntrinsicHeight() > 0) {
            if (drawable.getIntrinsicWidth() > 0) {
                i = drawable.getIntrinsicWidth();
            }
            if (drawable.getIntrinsicHeight() > 0) {
                i2 = drawable.getIntrinsicHeight();
            }
            Lock nx = p.nx();
            nx.lock();
            bitmap = eVar.c(i, i2, Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(bitmap);
                drawable.setBounds(0, 0, i, i2);
                drawable.draw(canvas);
                canvas.setBitmap(null);
            } finally {
                nx.unlock();
                AppMethodBeat.o(92233);
            }
        } else {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                new StringBuilder("Unable to draw ").append(drawable).append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
            }
            AppMethodBeat.o(92233);
        }
        return bitmap;
    }
}
