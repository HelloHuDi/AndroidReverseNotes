package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class avm extends c {
    private final int height = 42;
    private final int width = 42;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 42;
            case 1:
                return 42;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix h = c.h(looper);
                float[] g = c.g(looper);
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
                k2 = c.a(k2, looper);
                k2.setStrokeWidth(1.0f);
                Paint a = c.a(k, looper);
                Paint a2 = c.a(k2, looper);
                a.setColor(-4210753);
                a2.setColor(-4210753);
                a2.setStrokeWidth(0.5f);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a3 = c.a(a, looper);
                a = c.a(a2, looper);
                Path l = c.l(looper);
                l.moveTo(20.0f, 40.0f);
                l.cubicTo(8.954305f, 40.0f, 0.0f, 31.045694f, 0.0f, 20.0f);
                l.cubicTo(0.0f, 8.954305f, 8.954305f, 0.0f, 20.0f, 0.0f);
                l.cubicTo(31.045694f, 0.0f, 40.0f, 8.954305f, 40.0f, 20.0f);
                l.cubicTo(40.0f, 31.045694f, 31.045694f, 40.0f, 20.0f, 40.0f);
                l.close();
                l.moveTo(20.0f, 25.384615f);
                l.cubicTo(22.97384f, 25.384615f, 25.384615f, 22.97384f, 25.384615f, 20.0f);
                l.cubicTo(25.384615f, 17.02616f, 22.97384f, 14.615385f, 20.0f, 14.615385f);
                l.cubicTo(17.02616f, 14.615385f, 14.615385f, 17.02616f, 14.615385f, 20.0f);
                l.cubicTo(14.615385f, 22.97384f, 17.02616f, 25.384615f, 20.0f, 25.384615f);
                l.close();
                l.moveTo(2.841629f, 13.025641f);
                l.lineTo(20.217196f, 13.025641f);
                l.lineTo(11.095022f, 3.7104073f);
                l.cubicTo(7.4411893f, 5.695587f, 4.4904046f, 8.919444f, 2.841629f, 13.025641f);
                l.close();
                l.moveTo(19.806938f, 1.5384616f);
                l.cubicTo(17.431908f, 1.5384616f, 15.042355f, 2.0230188f, 12.856712f, 2.841629f);
                l.lineTo(25.333334f, 15.438914f);
                l.lineTo(25.333334f, 2.40724f);
                l.cubicTo(23.70856f, 1.8235183f, 21.855545f, 1.5384616f, 19.806938f, 1.5384616f);
                l.close();
                l.moveTo(1.5384616f, 20.217196f);
                l.cubicTo(1.5384616f, 22.586182f, 2.0253615f, 24.979147f, 2.8461537f, 27.167421f);
                l.lineTo(15.48718f, 14.666667f);
                l.lineTo(2.4102564f, 14.666667f);
                l.cubicTo(1.8229419f, 16.312695f, 1.5384616f, 18.162403f, 1.5384616f, 20.217196f);
                l.close();
                l.moveTo(13.025641f, 37.15837f);
                l.lineTo(13.025641f, 19.782804f);
                l.lineTo(3.7104073f, 28.904978f);
                l.cubicTo(5.695056f, 32.564972f, 8.915772f, 35.512318f, 13.025641f, 37.15837f);
                l.close();
                l.moveTo(20.217196f, 38.46154f);
                l.cubicTo(22.583342f, 38.46154f, 24.97778f, 37.974f, 27.167421f, 37.15837f);
                l.lineTo(14.666667f, 24.561087f);
                l.lineTo(14.666667f, 37.592762f);
                l.cubicTo(16.31146f, 38.177578f, 18.159653f, 38.46154f, 20.217196f, 38.46154f);
                l.close();
                l.moveTo(37.15837f, 26.923077f);
                l.lineTo(19.782804f, 26.923077f);
                l.lineTo(28.904978f, 36.289593f);
                l.cubicTo(32.56479f, 34.306225f, 35.51124f, 31.088493f, 37.15837f, 26.923077f);
                l.close();
                l.moveTo(38.46154f, 20.217196f);
                l.cubicTo(38.46154f, 17.845076f, 37.973f, 15.454035f, 37.153847f, 13.266969f);
                l.lineTo(24.512821f, 25.384615f);
                l.lineTo(37.589745f, 25.384615f);
                l.cubicTo(38.175034f, 24.120005f, 38.46154f, 22.268494f, 38.46154f, 20.217196f);
                l.close();
                l.moveTo(26.97436f, 3.2518854f);
                l.lineTo(26.97436f, 20.62745f);
                l.lineTo(36.289593f, 11.505279f);
                l.cubicTo(34.305107f, 7.851749f, 31.083288f, 4.901771f, 26.97436f, 3.2518854f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
