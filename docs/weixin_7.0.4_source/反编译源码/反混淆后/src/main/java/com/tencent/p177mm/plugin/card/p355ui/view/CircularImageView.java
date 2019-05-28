package com.tencent.p177mm.plugin.card.p355ui.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.card.ui.view.CircularImageView */
public class CircularImageView extends ImageView {
    private Paint aFY;

    public CircularImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircularImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(88800);
        this.aFY = new Paint();
        AppMethodBeat.m2505o(88800);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(88801);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap);
            Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
            RectF rectF = new RectF(rect);
            this.aFY.setAntiAlias(true);
            this.aFY.setDither(true);
            this.aFY.setFlags(1);
            canvas2.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas2.drawARGB(0, 0, 0, 0);
            canvas2.drawRoundRect(rectF, 20.0f, 20.0f, this.aFY);
            this.aFY.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
            canvas2.drawBitmap(bitmap, rect, rect, this.aFY);
            Rect rect2 = new Rect(0, 0, createBitmap.getWidth(), createBitmap.getHeight());
            Rect rect3 = new Rect(0, 0, getWidth(), getHeight());
            this.aFY.reset();
            canvas.drawBitmap(createBitmap, rect2, rect3, this.aFY);
            canvas.save();
            AppMethodBeat.m2505o(88801);
            return;
        }
        super.onDraw(canvas);
        AppMethodBeat.m2505o(88801);
    }
}
