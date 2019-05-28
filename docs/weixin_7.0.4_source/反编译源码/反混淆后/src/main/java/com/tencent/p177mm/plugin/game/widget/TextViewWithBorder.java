package com.tencent.p177mm.plugin.game.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.p069v7.widget.AppCompatTextView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;

/* renamed from: com.tencent.mm.plugin.game.widget.TextViewWithBorder */
public class TextViewWithBorder extends AppCompatTextView {
    public TextViewWithBorder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(112417);
        Paint paint = new Paint();
        paint.setStyle(Style.STROKE);
        paint.setColor(getResources().getColor(C25738R.color.f12043qe));
        canvas.drawRoundRect(new RectF(2.0f, 2.0f, (float) (getWidth() - 2), (float) (getHeight() - 2)), 5.0f, 5.0f, paint);
        super.onDraw(canvas);
        AppMethodBeat.m2505o(112417);
    }
}
