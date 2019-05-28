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

public final class aco extends c {
    private final int height = 72;
    private final int width = 72;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                Paint a = c.a(k2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 6.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(WebView.NIGHT_MODE_COLOR);
                a2.setStrokeWidth(3.6f);
                Path l = c.l(looper);
                l.moveTo(1.8f, 18.004917f);
                l.lineTo(1.8f, 54.001087f);
                l.cubicTo(1.8f, 56.322994f, 3.6805599f, 58.2f, 6.0063868f, 58.2f);
                l.lineTo(41.993614f, 58.2f);
                l.cubicTo(44.320652f, 58.2f, 46.2f, 56.321777f, 46.2f, 54.001087f);
                l.lineTo(46.2f, 18.004917f);
                l.cubicTo(46.2f, 17.339945f, 45.660645f, 16.8f, 44.997383f, 16.8f);
                l.lineTo(3.002615f, 16.8f);
                l.cubicTo(2.3328836f, 16.8f, 1.8f, 17.334574f, 1.8f, 18.004917f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(k, looper);
                a2.setColor(WebView.NIGHT_MODE_COLOR);
                l = c.l(looper);
                l.moveTo(12.0f, 12.0f);
                l.cubicTo(12.0f, 5.372583f, 17.372583f, 0.0f, 24.0f, 0.0f);
                l.cubicTo(30.627417f, 0.0f, 36.0f, 5.372583f, 36.0f, 12.0f);
                l.lineTo(35.999996f, 27.0f);
                l.lineTo(32.399998f, 27.0f);
                l.lineTo(32.399998f, 12.0f);
                l.cubicTo(32.39999f, 7.360799f, 28.639183f, 3.5999908f, 23.99999f, 3.5999908f);
                l.cubicTo(19.3608f, 3.5999908f, 15.599991f, 7.360799f, 15.599991f, 11.99999f);
                l.lineTo(15.6f, 27.0f);
                l.lineTo(12.0f, 27.0f);
                l.lineTo(12.0f, 12.0f);
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
