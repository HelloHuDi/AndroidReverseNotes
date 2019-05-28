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

public final class aoj extends c {
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
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 23.0f, 0.0f, 1.0f, 13.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-5592406);
                Path l = c.l(looper);
                l.moveTo(3.8078494f, 11.822346f);
                l.cubicTo(8.404776f, 4.3013563f, 17.218054f, -0.42926627f, 26.051363f, 0.030794242f);
                l.cubicTo(35.185123f, 0.3208324f, 43.81813f, 6.141598f, 47.61385f, 14.432689f);
                l.cubicTo(51.018982f, 21.393604f, 50.488182f, 29.64469f, 47.854214f, 36.76563f);
                l.cubicTo(43.167152f, 49.54731f, 34.35387f, 60.318726f, 24.989763f, 70.0f);
                l.cubicTo(15.275126f, 59.908672f, 6.0412145f, 48.637188f, 1.6045299f, 35.145412f);
                l.cubicTo(-0.95933306f, 27.51441f, -0.60880494f, 18.713253f, 3.8078494f, 11.822346f);
                l.lineTo(3.8078494f, 11.822346f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                Paint a2 = c.a(k, looper);
                a2.setColor(-1);
                Path l2 = c.l(looper);
                l2.moveTo(25.084106f, 24.087467f);
                l2.lineTo(16.49832f, 15.50168f);
                l2.lineTo(13.669893f, 18.330107f);
                l2.lineTo(22.25568f, 26.915894f);
                l2.lineTo(13.669893f, 35.50168f);
                l2.lineTo(16.49832f, 38.33011f);
                l2.lineTo(25.084106f, 29.74432f);
                l2.lineTo(33.66989f, 38.33011f);
                l2.lineTo(36.49832f, 35.50168f);
                l2.lineTo(27.912533f, 26.915894f);
                l2.lineTo(36.49832f, 18.330107f);
                l2.lineTo(33.66989f, 15.50168f);
                l2.lineTo(25.084106f, 24.087467f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
