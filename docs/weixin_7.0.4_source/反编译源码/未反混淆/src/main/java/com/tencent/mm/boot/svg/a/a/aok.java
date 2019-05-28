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

public final class aok extends c {
    private final int height = 120;
    private final int width = 120;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                g = c.a(g, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 15.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(8.001439f, 18.0f);
                l.cubicTo(3.5823665f, 18.0f, 0.0f, 21.582798f, 0.0f, 25.997679f);
                l.lineTo(0.0f, 82.00232f);
                l.cubicTo(0.0f, 86.41932f, 3.5913615f, 90.0f, 8.001439f, 90.0f);
                l.lineTo(111.99856f, 90.0f);
                l.cubicTo(116.41763f, 90.0f, 120.0f, 86.4172f, 120.0f, 82.00232f);
                l.lineTo(120.0f, 25.997679f);
                l.cubicTo(120.0f, 21.580683f, 116.40864f, 18.0f, 111.99856f, 18.0f);
                l.lineTo(8.001439f, 18.0f);
                l.close();
                l.moveTo(47.750492f, 0.0f);
                l.lineTo(60.0f, 0.0f);
                l.lineTo(60.0f, 18.0f);
                l.lineTo(23.340025f, 18.0f);
                l.cubicTo(33.061623f, 18.0f, 38.284004f, 0.0f, 47.750492f, 0.0f);
                l.close();
                l.moveTo(96.65997f, 18.0f);
                l.cubicTo(86.93838f, 18.0f, 81.715996f, 0.0f, 72.2474f, 0.0f);
                l.lineTo(60.0f, 0.0f);
                l.lineTo(60.0f, 18.0f);
                l.lineTo(96.65997f, 18.0f);
                l.close();
                l.moveTo(60.0f, 27.0f);
                l.cubicTo(74.91231f, 27.0f, 87.0f, 39.087692f, 87.0f, 54.0f);
                l.cubicTo(87.0f, 68.91231f, 74.91231f, 81.0f, 60.0f, 81.0f);
                l.cubicTo(45.087692f, 81.0f, 33.0f, 68.91231f, 33.0f, 54.0f);
                l.cubicTo(33.0f, 39.087692f, 45.087692f, 27.0f, 60.0f, 27.0f);
                l.close();
                l.moveTo(78.0f, 54.0f);
                l.cubicTo(78.0f, 63.9414f, 69.9414f, 72.0f, 60.0f, 72.0f);
                l.cubicTo(50.0586f, 72.0f, 42.0f, 63.9414f, 42.0f, 54.0f);
                l.cubicTo(42.0f, 44.0586f, 50.0586f, 36.0f, 60.0f, 36.0f);
                l.cubicTo(69.9414f, 36.0f, 78.0f, 44.0586f, 78.0f, 54.0f);
                l.close();
                l.moveTo(5.4545455f, 6.4315085f);
                l.lineTo(21.818182f, 6.4315085f);
                l.lineTo(21.818182f, 12.407947f);
                l.lineTo(5.4545455f, 12.407947f);
                l.lineTo(5.4545455f, 6.4315085f);
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
