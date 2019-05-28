package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class RoundedCornerRelativeLayout extends RelativeLayout {
    private Paint aFY;
    private a zNX;
    private Bitmap zNY;

    class a {
        float zNZ = 0.0f;
        float zOa = 0.0f;
        float zOb = 0.0f;
        float zOc = 0.0f;

        a() {
        }
    }

    public RoundedCornerRelativeLayout(Context context) {
        super(context);
        AppMethodBeat.i(107959);
        dKQ();
        AppMethodBeat.o(107959);
    }

    public RoundedCornerRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(107960);
        dKQ();
        AppMethodBeat.o(107960);
    }

    public RoundedCornerRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(107961);
        dKQ();
        AppMethodBeat.o(107961);
    }

    private void dKQ() {
        AppMethodBeat.i(107962);
        this.zNX = new a();
        this.aFY = new Paint(1);
        this.aFY.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        setWillNotDraw(false);
        AppMethodBeat.o(107962);
    }

    public void draw(Canvas canvas) {
        AppMethodBeat.i(107964);
        if (canvas.getWidth() <= 0 || canvas.getHeight() <= 0) {
            AppMethodBeat.o(107964);
            return;
        }
        int saveLayer = canvas.saveLayer(new RectF(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight()), null, 31);
        super.draw(canvas);
        if (this.zNX.zNZ > 0.0f || this.zNX.zOa > 0.0f || this.zNX.zOb > 0.0f || this.zNX.zOc > 0.0f) {
            if (this.zNY == null) {
                int width = canvas.getWidth();
                int height = canvas.getHeight();
                Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.ALPHA_8);
                Canvas canvas2 = new Canvas(createBitmap);
                Path path = new Path();
                path.addRoundRect(new RectF(0.0f, 0.0f, (float) width, (float) height), new float[]{this.zNX.zNZ, this.zNX.zNZ, this.zNX.zOa, this.zNX.zOa, this.zNX.zOc, this.zNX.zOc, this.zNX.zOb, this.zNX.zOb}, Direction.CCW);
                path.setFillType(FillType.WINDING);
                canvas2.drawPath(path, new Paint(1));
                this.zNY = createBitmap;
            }
            canvas.drawBitmap(this.zNY, 0.0f, 0.0f, this.aFY);
        }
        canvas.restoreToCount(saveLayer);
        AppMethodBeat.o(107964);
    }

    public void setRadius(float f) {
        AppMethodBeat.i(107963);
        this.zNX.zNZ = f;
        this.zNX.zOa = f;
        this.zNX.zOb = f;
        this.zNX.zOc = f;
        if (this.zNY != null) {
            this.zNY = null;
            postInvalidate();
        }
        AppMethodBeat.o(107963);
    }
}
