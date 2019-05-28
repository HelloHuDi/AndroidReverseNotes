package com.tencent.p177mm.plugin.setting.p505ui.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.setting.ui.setting.NetStatRuler */
class NetStatRuler extends View {
    public NetStatRuler(Context context) {
        this(context, null);
    }

    public NetStatRuler(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NetStatRuler(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @SuppressLint({"DrawAllocation"})
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(126969);
        super.onDraw(canvas);
        TextPaint textPaint = new TextPaint();
        textPaint.setAntiAlias(true);
        textPaint.setDither(true);
        textPaint.setTextSize((float) getContext().getResources().getDimensionPixelSize(C25738R.dimen.f10026ns));
        Rect rect = new Rect();
        getDrawingRect(rect);
        float height = (float) rect.height();
        float paddingLeft = (float) (rect.left + getPaddingLeft());
        float f = ((float) rect.top) + (height / 3.0f);
        float f2 = ((float) rect.top) + ((2.0f * height) / 3.0f);
        float f3 = ((float) rect.top) + height;
        textPaint.setColor(-7829368);
        canvas.drawText(C5046bo.m7580my((long) ((NetStatUnit.max * 2) / 3)), paddingLeft, f, textPaint);
        canvas.drawText(C5046bo.m7580my((long) (NetStatUnit.max / 3)), paddingLeft, f2, textPaint);
        canvas.drawText(C5046bo.m7580my(0), paddingLeft, f3, textPaint);
        AppMethodBeat.m2505o(126969);
    }
}
