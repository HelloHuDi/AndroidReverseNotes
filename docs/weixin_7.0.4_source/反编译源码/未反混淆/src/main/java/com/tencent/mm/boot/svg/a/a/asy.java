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

public final class asy extends c {
    private final int height = 90;
    private final int width = 90;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                float[] a = c.a(g, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f);
                h.reset();
                h.setValues(a);
                canvas.concat(h);
                Paint a2 = c.a(k, looper);
                a2.setColor(-1);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                Path l = c.l(looper);
                l.moveTo(26.43f, 1.68f);
                l.cubicTo(41.46f, -1.69f, 57.9f, 7.14f, 63.51f, 21.45f);
                l.cubicTo(69.44f, 35.22f, 64.39f, 52.55f, 51.99f, 60.97f);
                l.cubicTo(39.83f, 69.86f, 21.65f, 68.7f, 10.73f, 58.32f);
                l.cubicTo(-0.37f, 48.51f, -3.25f, 30.94f, 4.11f, 18.1f);
                l.cubicTo(8.68f, 9.71f, 17.05f, 3.53f, 26.43f, 1.68f);
                l.lineTo(26.43f, 1.68f);
                l.close();
                l.moveTo(20.27f, 23.38f);
                l.cubicTo(23.8f, 26.93f, 27.34f, 30.45f, 30.87f, 34.0f);
                l.cubicTo(27.35f, 37.54f, 23.8f, 41.06f, 20.28f, 44.61f);
                l.cubicTo(20.8f, 45.14f, 21.86f, 46.2f, 22.38f, 46.73f);
                l.cubicTo(25.94f, 43.21f, 29.45f, 39.65f, 33.0f, 36.13f);
                l.cubicTo(36.55f, 39.66f, 40.07f, 43.21f, 43.62f, 46.73f);
                l.cubicTo(44.14f, 46.2f, 45.2f, 45.14f, 45.72f, 44.61f);
                l.cubicTo(42.2f, 41.06f, 38.65f, 37.54f, 35.13f, 34.0f);
                l.cubicTo(38.65f, 30.46f, 42.2f, 26.93f, 45.73f, 23.39f);
                l.cubicTo(45.2f, 22.86f, 44.14f, 21.8f, 43.61f, 21.28f);
                l.cubicTo(40.06f, 24.79f, 36.55f, 28.35f, 33.0f, 31.87f);
                l.cubicTo(29.46f, 28.34f, 25.93f, 24.8f, 22.39f, 21.27f);
                l.cubicTo(21.86f, 21.8f, 20.8f, 22.86f, 20.27f, 23.38f);
                l.lineTo(20.27f, 23.38f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                g = c.a(a, 1.0f, 0.0f, 20.0f, 0.0f, 1.0f, 21.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a4 = c.a(k, looper);
                l = c.l(looper);
                l.moveTo(0.27f, 2.38f);
                l.cubicTo(0.8f, 1.86f, 1.86f, 0.8f, 2.39f, 0.27f);
                l.cubicTo(5.93f, 3.8f, 9.46f, 7.34f, 13.0f, 10.87f);
                l.cubicTo(16.55f, 7.35f, 20.06f, 3.79f, 23.61f, 0.28f);
                l.cubicTo(24.14f, 0.8f, 25.2f, 1.86f, 25.73f, 2.39f);
                l.cubicTo(22.2f, 5.93f, 18.65f, 9.46f, 15.13f, 13.0f);
                l.cubicTo(18.65f, 16.54f, 22.2f, 20.06f, 25.72f, 23.61f);
                l.cubicTo(25.2f, 24.14f, 24.14f, 25.2f, 23.62f, 25.73f);
                l.cubicTo(20.07f, 22.21f, 16.55f, 18.66f, 13.0f, 15.13f);
                l.cubicTo(9.45f, 18.65f, 5.94f, 22.21f, 2.38f, 25.73f);
                l.cubicTo(1.86f, 25.2f, 0.8f, 24.14f, 0.28f, 23.61f);
                l.cubicTo(3.8f, 20.06f, 7.35f, 16.54f, 10.87f, 13.0f);
                l.cubicTo(7.34f, 9.45f, 3.8f, 5.93f, 0.27f, 2.38f);
                l.lineTo(0.27f, 2.38f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
