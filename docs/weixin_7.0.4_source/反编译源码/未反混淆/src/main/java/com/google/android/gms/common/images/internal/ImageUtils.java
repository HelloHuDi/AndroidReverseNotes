package com.google.android.gms.common.images.internal;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;

public final class ImageUtils {
    public static Bitmap frameBitmapInCircle(Bitmap bitmap) {
        AppMethodBeat.i(61280);
        if (bitmap == null) {
            AppMethodBeat.o(61280);
            return null;
        }
        int i;
        int i2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width >= height) {
            i = (height - width) / 2;
            i2 = 0;
        } else {
            i2 = (width - height) / 2;
            i = 0;
            height = width;
        }
        Bitmap createBitmap = Bitmap.createBitmap(height, height, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(WebView.NIGHT_MODE_COLOR);
        canvas.drawCircle((float) (height / 2), (float) (height / 2), (float) (height / 2), paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, (float) i, (float) i2, paint);
        AppMethodBeat.o(61280);
        return createBitmap;
    }

    public static Drawable frameDrawableInCircle(Resources resources, Drawable drawable) {
        Bitmap bitmap;
        AppMethodBeat.i(61281);
        if (drawable == null) {
            bitmap = null;
        } else if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, frameBitmapInCircle(bitmap));
        AppMethodBeat.o(61281);
        return bitmapDrawable;
    }
}
