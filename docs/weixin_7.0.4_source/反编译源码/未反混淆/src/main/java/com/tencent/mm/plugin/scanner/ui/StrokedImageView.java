package com.tencent.mm.plugin.scanner.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public class StrokedImageView extends ImageView {
    private int color;

    public StrokedImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(81341);
        this.color = context.getResources().getColor(R.color.yl);
        AppMethodBeat.o(81341);
    }

    public void setStrokeColor(int i) {
        this.color = i;
    }

    /* Access modifiers changed, original: protected */
    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(81342);
        super.onDraw(canvas);
        Rect clipBounds = canvas.getClipBounds();
        clipBounds.left++;
        clipBounds.top++;
        clipBounds.bottom--;
        clipBounds.right--;
        Paint paint = new Paint();
        paint.setColor(this.color);
        paint.setStyle(Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(1.5f);
        canvas.drawRect(clipBounds, paint);
        AppMethodBeat.o(81342);
    }
}
