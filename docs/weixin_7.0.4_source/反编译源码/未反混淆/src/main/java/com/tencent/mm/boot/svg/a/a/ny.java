package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class ny extends c {
    private final int height = 21;
    private final int width = 28;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 28;
            case 1:
                return 21;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.h(looper);
                c.g(looper);
                Paint k = c.k(looper);
                k.setFlags(385);
                k.setStyle(Style.FILL);
                Paint k2 = c.k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.STROKE);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(1.0f);
                k2.setStrokeCap(Cap.BUTT);
                k2.setStrokeJoin(Join.MITER);
                k2.setStrokeMiter(4.0f);
                k2.setPathEffect(null);
                c.a(k2, looper).setStrokeWidth(1.0f);
                k = c.a(k, looper);
                k.setColor(-15679443);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(9.74392f, 16.81017f);
                l.cubicTo(15.2217455f, 11.2271185f, 20.549356f, 5.4915257f, 26.107296f, 0.0f);
                l.cubicTo(26.587982f, 0.4881356f, 27.529327f, 1.4745762f, 28.0f, 1.9728813f);
                l.cubicTo(22.341917f, 8.60339f, 15.872675f, 14.481356f, 10.084406f, 21.0f);
                l.cubicTo(6.679542f, 18.254238f, 3.304721f, 15.477966f, 0.0f, 12.620339f);
                l.lineTo(0.0f, 10.901695f);
                l.cubicTo(0.41058657f, 10.698305f, 1.241774f, 10.301695f, 1.6623749f, 10.098305f);
                l.cubicTo(4.346209f, 12.345762f, 7.030043f, 14.60339f, 9.74392f, 16.81017f);
                l.lineTo(9.74392f, 16.81017f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
