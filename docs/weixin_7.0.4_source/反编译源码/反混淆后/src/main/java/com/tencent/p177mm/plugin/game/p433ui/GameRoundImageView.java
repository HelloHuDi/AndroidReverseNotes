package com.tencent.p177mm.plugin.game.p433ui;

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
import android.support.p069v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;

/* renamed from: com.tencent.mm.plugin.game.ui.GameRoundImageView */
public class GameRoundImageView extends AppCompatImageView {
    private static final PorterDuffXfermode kPO = new PorterDuffXfermode(Mode.SRC_IN);
    private Bitmap bitmap;
    private RectF kPM;
    private Bitmap kPN;
    private Rect rect;

    static {
        AppMethodBeat.m2504i(112170);
        AppMethodBeat.m2505o(112170);
    }

    public GameRoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(112167);
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
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), null, 31);
            canvas.drawBitmap(this.kPN, this.rect, this.rect, paint);
            paint.setXfermode(kPO);
            canvas.drawBitmap(this.bitmap, null, this.rect, paint);
            canvas.restoreToCount(saveLayer);
            paint.setXfermode(null);
        }
        paint.setStyle(Style.STROKE);
        paint.setStrokeWidth(1.0f);
        paint.setColor(getResources().getColor(C25738R.color.f12024pu));
        canvas.drawRoundRect(this.kPM, 18.0f, 18.0f, paint);
        AppMethodBeat.m2505o(112167);
    }

    /* Access modifiers changed, original: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(112168);
        this.kPM = new RectF(0.0f, 0.0f, (float) i, (float) i2);
        this.rect = new Rect(0, 0, i, i2);
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(-1);
        canvas.drawRoundRect(this.kPM, 18.0f, 18.0f, paint);
        this.kPN = createBitmap;
        AppMethodBeat.m2505o(112168);
    }

    public void setImageBitmap(Bitmap bitmap) {
        AppMethodBeat.m2504i(112169);
        this.bitmap = bitmap;
        super.setImageBitmap(bitmap);
        AppMethodBeat.m2505o(112169);
    }
}
