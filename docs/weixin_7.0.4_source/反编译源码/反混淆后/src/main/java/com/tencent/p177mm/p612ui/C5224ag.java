package com.tencent.p177mm.p612ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.ag */
public final class C5224ag {
    /* renamed from: d */
    public static Bitmap m7956d(Bitmap bitmap, float f) {
        AppMethodBeat.m2504i(112468);
        if (bitmap == null || bitmap.isRecycled()) {
            C5227ai.m7972e("WeUIBitmapUtil", "getRoundedCornerBitmap in bitmap is null", new Object[0]);
            AppMethodBeat.m2505o(112468);
            return null;
        }
        Bitmap k = C5224ag.m7957k(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
        if (k == null) {
            AppMethodBeat.m2505o(112468);
            return null;
        }
        Canvas canvas = new Canvas(k);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setFilterBitmap(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-4144960);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        C5227ai.m7973i("WeUIBitmapUtil", "getRoundedCornerBitmap bitmap recycle %s", bitmap);
        bitmap.recycle();
        AppMethodBeat.m2505o(112468);
        return k;
    }

    /* renamed from: k */
    private static Bitmap m7957k(int i, int i2, Config config) {
        AppMethodBeat.m2504i(112469);
        Bitmap bitmap = null;
        try {
            bitmap = Bitmap.createBitmap(i, i2, config);
        } catch (Throwable th) {
        }
        AppMethodBeat.m2505o(112469);
        return bitmap;
    }
}
