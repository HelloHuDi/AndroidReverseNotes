package com.tencent.mm.plugin.setting.ui.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

class NetStatUnit extends View {
    protected static int max;
    private int qkX;
    private int total;

    public NetStatUnit(Context context) {
        this(context, null);
    }

    public NetStatUnit(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetStatUnit(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void fg(int i, int i2) {
        AppMethodBeat.i(126970);
        this.qkX = i;
        this.total = i2;
        if (i > 94371840) {
            this.qkX = 94371840;
        }
        if (i2 > 94371840) {
            this.total = 94371840;
        }
        if (i <= i2) {
            i = i2;
        }
        Cj(i);
        AppMethodBeat.o(126970);
    }

    private static void Cj(int i) {
        int i2 = ((i / 1572864) + 1) * 1572864;
        if (94371840 <= i2) {
            i2 = 94371840;
        }
        if (3145728 >= i2) {
            i2 = 3145728;
        }
        if (i2 > max) {
            max = i2;
        }
    }

    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(126971);
        super.onDraw(canvas);
        Paint paint = new Paint();
        Rect rect = new Rect();
        getDrawingRect(rect);
        Rect rect2 = new Rect(rect.left, (int) (((float) rect.bottom) - ((((float) rect.height()) * ((float) this.total)) / ((float) max))), (int) ((((float) rect.width()) * 0.6f) + ((float) rect.left)), rect.bottom);
        paint.setColor(-7829368);
        canvas.drawRect(rect2, paint);
        rect2 = new Rect(rect.left, (int) (((float) rect.bottom) - ((((float) rect.height()) * ((float) this.qkX)) / ((float) max))), (int) ((((float) rect.width()) * 0.6f) + ((float) rect.left)), rect.bottom);
        paint.setColor(-16711936);
        canvas.drawRect(rect2, paint);
        AppMethodBeat.o(126971);
    }
}
