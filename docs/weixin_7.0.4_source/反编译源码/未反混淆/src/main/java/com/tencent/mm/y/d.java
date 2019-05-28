package com.tencent.mm.y;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.LinkedList;

public final class d implements Cloneable {
    private static int eHv = com.tencent.mm.ch.a.bu(12.0f);
    private static Paint eHx;
    private LinkedList<b> cks;
    public a ckt;
    private Bitmap eHw;
    private float mScale;
    private Path vr;

    public enum a {
        ONE,
        TWO;

        static {
            AppMethodBeat.o(116292);
        }
    }

    public static class b {
        public float centerX;
        public float centerY;
        public int color = 0;
        public float rotation = 0.0f;
        public float scale = 0.0f;

        public b(float f, int i, float f2, float f3, float f4) {
            this.scale = f;
            this.color = i;
            this.rotation = f2;
            this.centerX = f3;
            this.centerY = f4;
        }
    }

    static {
        AppMethodBeat.i(116296);
        Paint paint = new Paint();
        eHx = paint;
        paint.setAntiAlias(true);
        eHx.setStyle(Style.STROKE);
        eHx.setColor(-16776961);
        eHx.setStrokeCap(Cap.ROUND);
        AppMethodBeat.o(116296);
    }

    public d(a aVar, Path path, float f, Bitmap bitmap) {
        AppMethodBeat.i(116293);
        this.ckt = aVar;
        this.eHw = bitmap;
        this.vr = path;
        this.mScale = f;
        eHx.setStrokeWidth(((float) com.tencent.mm.ch.a.bu(24.0f)) * f);
        AppMethodBeat.o(116293);
    }

    public d(a aVar, LinkedList<b> linkedList, float f) {
        AppMethodBeat.i(116294);
        this.ckt = aVar;
        this.cks = linkedList;
        this.mScale = f;
        eHx.setStrokeWidth(((float) com.tencent.mm.ch.a.bu(24.0f)) * f);
        AppMethodBeat.o(116294);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.i(116295);
        Bitmap bitmap;
        if (this.ckt == a.ONE) {
            bitmap = this.eHw;
            if (!(bitmap == null || bitmap.isRecycled())) {
                canvas.saveLayer(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight(), null, 31);
                canvas.drawColor(0, Mode.CLEAR);
                canvas.drawPath(this.vr, eHx);
                eHx.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, eHx);
                eHx.setXfermode(null);
                canvas.restore();
            }
            AppMethodBeat.o(116295);
            return;
        }
        if (this.ckt == a.TWO) {
            if (this.cks.size() <= 0) {
                AppMethodBeat.o(116295);
                return;
            }
            float width;
            float f;
            b bVar = (b) this.cks.getLast();
            float f2 = bVar.scale;
            int i = bVar.color;
            int random = (int) (Math.random() * 100.0d);
            float f3 = ((float) eHv) * f2;
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(ah.getContext().getResources(), R.drawable.v9, options);
            options.inSampleSize = com.tencent.mm.ch.a.a(options, Math.round((((float) options.outWidth) * f2) * 0.7f), Math.round((f2 * ((float) options.outHeight)) * 0.7f));
            options.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeResource(ah.getContext().getResources(), R.drawable.v9, options);
            eHx.setStyle(Style.FILL);
            eHx.setColorFilter(new LightingColorFilter(i, 1));
            if (bitmap != null) {
                width = bVar.centerX - ((((float) bitmap.getWidth()) * 1.0f) / 2.0f);
                f2 = bVar.centerY - ((((float) bitmap.getHeight()) * 1.0f) / 2.0f);
            } else {
                f2 = 0.0f;
                width = 0.0f;
            }
            if (random > 0 && random <= 20) {
                width += f3;
                f = f2 + f3;
            } else if (80 < random) {
                width -= f3;
                f = f2 - f3;
            } else {
                f = f2;
            }
            canvas.save();
            canvas.rotate(-bVar.rotation, bVar.centerX, bVar.centerY);
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, width, f, eHx);
            }
            canvas.restore();
            eHx.setStyle(Style.STROKE);
            eHx.setColorFilter(null);
        }
        AppMethodBeat.o(116295);
    }
}
