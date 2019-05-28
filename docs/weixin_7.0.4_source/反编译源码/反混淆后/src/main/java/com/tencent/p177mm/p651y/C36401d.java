package com.tencent.p177mm.p651y;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p1639ch.C45281a;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.y.d */
public final class C36401d implements Cloneable {
    private static int eHv = C45281a.m83492bu(12.0f);
    private static Paint eHx;
    private LinkedList<C36400b> cks;
    public C24187a ckt;
    private Bitmap eHw;
    private float mScale;
    /* renamed from: vr */
    private Path f15107vr;

    /* renamed from: com.tencent.mm.y.d$a */
    public enum C24187a {
        ONE,
        TWO;

        static {
            AppMethodBeat.m2505o(116292);
        }
    }

    /* renamed from: com.tencent.mm.y.d$b */
    public static class C36400b {
        public float centerX;
        public float centerY;
        public int color = 0;
        public float rotation = 0.0f;
        public float scale = 0.0f;

        public C36400b(float f, int i, float f2, float f3, float f4) {
            this.scale = f;
            this.color = i;
            this.rotation = f2;
            this.centerX = f3;
            this.centerY = f4;
        }
    }

    static {
        AppMethodBeat.m2504i(116296);
        Paint paint = new Paint();
        eHx = paint;
        paint.setAntiAlias(true);
        eHx.setStyle(Style.STROKE);
        eHx.setColor(-16776961);
        eHx.setStrokeCap(Cap.ROUND);
        AppMethodBeat.m2505o(116296);
    }

    public C36401d(C24187a c24187a, Path path, float f, Bitmap bitmap) {
        AppMethodBeat.m2504i(116293);
        this.ckt = c24187a;
        this.eHw = bitmap;
        this.f15107vr = path;
        this.mScale = f;
        eHx.setStrokeWidth(((float) C45281a.m83492bu(24.0f)) * f);
        AppMethodBeat.m2505o(116293);
    }

    public C36401d(C24187a c24187a, LinkedList<C36400b> linkedList, float f) {
        AppMethodBeat.m2504i(116294);
        this.ckt = c24187a;
        this.cks = linkedList;
        this.mScale = f;
        eHx.setStrokeWidth(((float) C45281a.m83492bu(24.0f)) * f);
        AppMethodBeat.m2505o(116294);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.m2504i(116295);
        Bitmap bitmap;
        if (this.ckt == C24187a.ONE) {
            bitmap = this.eHw;
            if (!(bitmap == null || bitmap.isRecycled())) {
                canvas.saveLayer(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight(), null, 31);
                canvas.drawColor(0, Mode.CLEAR);
                canvas.drawPath(this.f15107vr, eHx);
                eHx.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, eHx);
                eHx.setXfermode(null);
                canvas.restore();
            }
            AppMethodBeat.m2505o(116295);
            return;
        }
        if (this.ckt == C24187a.TWO) {
            if (this.cks.size() <= 0) {
                AppMethodBeat.m2505o(116295);
                return;
            }
            float width;
            float f;
            C36400b c36400b = (C36400b) this.cks.getLast();
            float f2 = c36400b.scale;
            int i = c36400b.color;
            int random = (int) (Math.random() * 100.0d);
            float f3 = ((float) eHv) * f2;
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeResource(C4996ah.getContext().getResources(), C25738R.drawable.f6913v9, options);
            options.inSampleSize = C45281a.m83491a(options, Math.round((((float) options.outWidth) * f2) * 0.7f), Math.round((f2 * ((float) options.outHeight)) * 0.7f));
            options.inJustDecodeBounds = false;
            bitmap = BitmapFactory.decodeResource(C4996ah.getContext().getResources(), C25738R.drawable.f6913v9, options);
            eHx.setStyle(Style.FILL);
            eHx.setColorFilter(new LightingColorFilter(i, 1));
            if (bitmap != null) {
                width = c36400b.centerX - ((((float) bitmap.getWidth()) * 1.0f) / 2.0f);
                f2 = c36400b.centerY - ((((float) bitmap.getHeight()) * 1.0f) / 2.0f);
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
            canvas.rotate(-c36400b.rotation, c36400b.centerX, c36400b.centerY);
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, width, f, eHx);
            }
            canvas.restore();
            eHx.setStyle(Style.STROKE);
            eHx.setColorFilter(null);
        }
        AppMethodBeat.m2505o(116295);
    }
}
