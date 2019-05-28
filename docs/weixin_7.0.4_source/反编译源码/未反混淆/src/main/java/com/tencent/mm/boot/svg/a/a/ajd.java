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

public final class ajd extends c {
    private final int height = 96;
    private final int width = 96;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                c.a(k2, looper).setStrokeWidth(1.0f);
                Paint a = c.a(k, looper);
                a.setColor(-1);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 20.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(58.99807f, 24.0f);
                l.lineTo(47.996223f, 24.0f);
                l.cubicTo(47.445435f, 24.0f, 46.99807f, 24.443586f, 46.99807f, 24.990778f);
                l.lineTo(46.99807f, 29.009222f);
                l.cubicTo(46.99807f, 29.549025f, 47.444958f, 30.0f, 47.996223f, 30.0f);
                l.lineTo(58.99807f, 30.0f);
                l.lineTo(58.99807f, 41.001846f);
                l.cubicTo(58.99807f, 41.552635f, 59.441654f, 42.0f, 59.988846f, 42.0f);
                l.lineTo(64.00729f, 42.0f);
                l.cubicTo(64.5471f, 42.0f, 64.99807f, 41.553112f, 64.99807f, 41.001846f);
                l.lineTo(64.99807f, 30.0f);
                l.lineTo(75.999916f, 30.0f);
                l.cubicTo(76.550705f, 30.0f, 76.99807f, 29.556414f, 76.99807f, 29.009222f);
                l.lineTo(76.99807f, 24.990778f);
                l.cubicTo(76.99807f, 24.450975f, 76.55118f, 24.0f, 75.999916f, 24.0f);
                l.lineTo(64.99807f, 24.0f);
                l.lineTo(64.99807f, 12.998154f);
                l.cubicTo(64.99807f, 12.447365f, 64.55448f, 12.0f, 64.00729f, 12.0f);
                l.lineTo(59.988846f, 12.0f);
                l.cubicTo(59.449043f, 12.0f, 58.99807f, 12.446889f, 58.99807f, 12.998154f);
                l.lineTo(58.99807f, 24.0f);
                l.close();
                l.moveTo(55.99517f, 51.671585f);
                l.cubicTo(55.95076f, 47.44745f, 55.089516f, 46.365105f, 40.725517f, 38.43724f);
                l.cubicTo(37.76138f, 36.80069f, 31.511587f, 34.22469f, 35.636276f, 28.296413f);
                l.cubicTo(35.95876f, 27.832f, 36.162483f, 27.363724f, 36.278343f, 26.896414f);
                l.cubicTo(38.76552f, 23.956413f, 40.579723f, 20.117517f, 40.703312f, 16.545103f);
                l.lineTo(40.726482f, 16.545103f);
                l.lineTo(40.726482f, 11.454897f);
                l.lineTo(40.666622f, 11.454897f);
                l.cubicTo(40.0651f, 3.2904828f, 33.36538f, 0.0f, 27.999035f, 0.0f);
                l.cubicTo(22.626896f, 0.0f, 15.920414f, 3.106069f, 15.329517f, 11.454897f);
                l.lineTo(15.271586f, 11.454897f);
                l.lineTo(15.271586f, 16.545103f);
                l.lineTo(15.294759f, 16.545103f);
                l.cubicTo(15.4183445f, 20.117517f, 17.232552f, 23.956413f, 19.719725f, 26.896414f);
                l.cubicTo(19.835587f, 27.362759f, 20.038345f, 27.832f, 20.361794f, 28.296413f);
                l.cubicTo(24.485518f, 34.22469f, 18.235723f, 36.801655f, 15.272552f, 38.43724f);
                l.cubicTo(0.90855175f, 46.365105f, 0.047310345f, 47.44745f, 0.0028965517f, 51.671585f);
                l.cubicTo(0.0028965517f, 51.680275f, 0.0f, 51.688965f, 0.0f, 51.69862f);
                l.lineTo(0.0f, 52.66414f);
                l.cubicTo(0.0f, 54.50538f, 1.4936552f, 55.999035f, 3.3358622f, 55.999035f);
                l.lineTo(52.66414f, 55.999035f);
                l.cubicTo(54.506344f, 55.999035f, 56.0f, 54.50538f, 56.0f, 52.66414f);
                l.lineTo(56.0f, 51.69862f);
                l.cubicTo(55.99807f, 51.68993f, 55.99517f, 51.68124f, 55.99517f, 51.671585f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
