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

public final class asd extends c {
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
                Paint a = c.a(k, looper);
                a.setColor(-5592406);
                g = c.a(g, 1.0f, 0.0f, 18.0f, 0.0f, 1.0f, 18.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(3.35f, 12.4f);
                l.cubicTo(7.25f, 5.36f, 14.93f, 0.63f, 22.96f, 0.27f);
                l.cubicTo(31.48f, -0.27f, 40.05f, 4.2f, 44.53f, 11.46f);
                l.cubicTo(49.92f, 19.74f, 49.24f, 31.19f, 43.22f, 38.97f);
                l.cubicTo(48.42f, 44.2f, 53.65f, 49.4f, 58.86f, 54.62f);
                l.cubicTo(57.46f, 56.07f, 56.03f, 57.5f, 54.53f, 58.84f);
                l.cubicTo(49.4f, 53.57f, 44.14f, 48.41f, 38.95f, 43.2f);
                l.cubicTo(34.16f, 46.84f, 28.05f, 48.71f, 22.04f, 48.11f);
                l.cubicTo(13.48f, 47.41f, 5.55f, 41.7f, 2.22f, 33.77f);
                l.cubicTo(-0.77f, 26.99f, -0.35f, 18.82f, 3.35f, 12.4f);
                l.lineTo(3.35f, 12.4f);
                l.close();
                l.moveTo(22.25f, 6.34f);
                l.cubicTo(12.73f, 7.14f, 5.11f, 16.55f, 6.33f, 26.04f);
                l.cubicTo(7.03f, 35.6f, 16.43f, 43.3f, 25.94f, 42.13f);
                l.cubicTo(35.7f, 41.45f, 43.55f, 31.72f, 42.08f, 22.03f);
                l.cubicTo(41.15f, 12.55f, 31.71f, 5.05f, 22.25f, 6.34f);
                l.lineTo(22.25f, 6.34f);
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
