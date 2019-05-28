package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class AppIconView extends AppCompatImageView {
    private static final PorterDuffXfermode kPO = new PorterDuffXfermode(Mode.SRC_IN);
    private Bitmap bitmap;
    private RectF kPM;
    private Bitmap kPN;
    private Rect rect;

    static {
        AppMethodBeat.i(136208);
        AppMethodBeat.o(136208);
    }

    public AppIconView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(136205);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(-1);
        if (this.rect == null) {
            this.rect = new Rect(0, 0, getWidth(), getHeight());
        }
        if (this.kPM == null) {
            this.kPM = new RectF(this.rect);
        }
        if (!(this.bitmap == null || this.kPN == null)) {
            int saveLayer;
            if (VERSION.SDK_INT >= 21) {
                saveLayer = canvas.saveLayer(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), null);
            } else {
                saveLayer = canvas.saveLayer(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), null, 31);
            }
            canvas.drawBitmap(this.kPN, this.rect, this.rect, paint);
            paint.setXfermode(kPO);
            canvas.drawBitmap(this.bitmap, null, this.rect, paint);
            canvas.restoreToCount(saveLayer);
            paint.setXfermode(null);
        }
        paint.setStyle(Style.STROKE);
        paint.setStrokeWidth(1.0f);
        paint.setColor(getResources().getColor(R.color.ge));
        canvas.drawRoundRect(this.kPM, 32.0f, 32.0f, paint);
        AppMethodBeat.o(136205);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(136206);
        this.kPM = new RectF(0.0f, 0.0f, (float) i, (float) i2);
        this.rect = new Rect(0, 0, i, i2);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(getResources().getColor(R.color.gd));
        canvas.drawRoundRect(this.kPM, 32.0f, 32.0f, paint);
        this.kPN = createBitmap;
        AppMethodBeat.o(136206);
    }

    public void setImageBitmap(Bitmap bitmap) {
        AppMethodBeat.i(136207);
        this.bitmap = bitmap;
        super.setImageBitmap(bitmap);
        AppMethodBeat.o(136207);
    }
}
