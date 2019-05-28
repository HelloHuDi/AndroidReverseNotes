package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.aut */
public final class aut extends C5163c {
    private final int height = 60;
    private final int width = 60;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix h = C5163c.m7881h(looper);
                float[] g = C5163c.m7880g(looper);
                Paint k = C5163c.m7883k(looper);
                k.setFlags(385);
                k.setStyle(Style.FILL);
                Paint k2 = C5163c.m7883k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.STROKE);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(1.0f);
                k2.setStrokeCap(Cap.BUTT);
                k2.setStrokeJoin(Join.MITER);
                k2.setStrokeMiter(4.0f);
                k2.setPathEffect(null);
                C5163c.m7876a(k2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-12206054);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 6.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(18.37f, 1.52f);
                l.cubicTo(23.08f, 0.55f, 28.2f, 0.64f, 32.69f, 2.53f);
                l.cubicTo(41.17f, 5.91f, 47.42f, 14.72f, 47.03f, 23.96f);
                l.cubicTo(47.65f, 36.29f, 36.31f, 47.64f, 23.98f, 47.03f);
                l.cubicTo(10.46f, 47.71f, -1.15f, 34.21f, 1.07f, 20.93f);
                l.cubicTo(2.04f, 11.65f, 9.54f, 3.93f, 18.37f, 1.52f);
                l.lineTo(18.37f, 1.52f);
                l.close();
                l.moveTo(5.04f, 17.36f);
                l.cubicTo(7.12f, 19.25f, 7.11f, 22.21f, 7.98f, 24.7f);
                l.cubicTo(10.56f, 25.78f, 13.04f, 27.06f, 15.5f, 28.38f);
                l.cubicTo(15.2f, 27.12f, 14.76f, 25.91f, 14.18f, 24.77f);
                l.cubicTo(13.02f, 23.83f, 11.45f, 24.49f, 10.12f, 24.44f);
                l.cubicTo(10.26f, 22.87f, 9.41f, 20.87f, 10.68f, 19.61f);
                l.cubicTo(11.97f, 18.33f, 13.92f, 18.68f, 15.56f, 18.44f);
                l.cubicTo(16.27f, 19.32f, 16.97f, 20.19f, 17.68f, 21.06f);
                l.cubicTo(17.86f, 18.91f, 17.17f, 16.47f, 18.57f, 14.6f);
                l.cubicTo(20.53f, 11.73f, 22.95f, 9.18f, 24.96f, 6.33f);
                l.lineTo(18.93f, 6.33f);
                l.cubicTo(19.0f, 7.24f, 19.16f, 9.05f, 19.23f, 9.96f);
                l.lineTo(20.48f, 10.29f);
                l.cubicTo(17.86f, 11.08f, 17.12f, 7.21f, 15.92f, 5.62f);
                l.cubicTo(10.94f, 7.98f, 7.02f, 12.21f, 5.04f, 17.36f);
                l.lineTo(5.04f, 17.36f);
                l.close();
                l.moveTo(17.15f, 27.13f);
                l.cubicTo(17.83f, 28.03f, 18.53f, 28.93f, 19.11f, 29.91f);
                l.cubicTo(19.58f, 32.28f, 17.17f, 34.5f, 18.31f, 36.83f);
                l.cubicTo(19.38f, 39.03f, 22.16f, 38.94f, 24.2f, 39.46f);
                l.cubicTo(24.1f, 41.01f, 23.94f, 42.56f, 23.79f, 44.12f);
                l.cubicTo(26.84f, 43.83f, 30.18f, 43.63f, 32.47f, 41.31f);
                l.cubicTo(34.92f, 39.12f, 38.83f, 37.01f, 38.16f, 33.14f);
                l.cubicTo(38.13f, 31.02f, 35.31f, 32.11f, 34.01f, 31.85f);
                l.cubicTo(31.97f, 29.6f, 30.48f, 25.84f, 27.01f, 25.72f);
                l.cubicTo(23.74f, 26.33f, 20.54f, 27.89f, 17.15f, 27.13f);
                l.lineTo(17.15f, 27.13f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
