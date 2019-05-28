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

/* renamed from: com.tencent.mm.boot.svg.a.a.af */
public final class C17993af extends C5163c {
    private final int height = 96;
    private final int width = 96;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                a.setColor(-1);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 23.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(2.11f, 1.14f);
                l.cubicTo(21.75f, 0.82f, 41.42f, 1.08f, 61.06f, 1.0f);
                l.cubicTo(62.34f, 0.79f, 64.15f, 1.37f, 63.95f, 2.98f);
                l.cubicTo(64.04f, 17.98f, 64.03f, 33.0f, 63.95f, 48.01f);
                l.cubicTo(64.14f, 49.6f, 62.39f, 50.21f, 61.11f, 49.99f);
                l.cubicTo(41.73f, 49.98f, 22.35f, 50.07f, 2.97f, 49.95f);
                l.cubicTo(1.37f, 50.15f, 0.79f, 48.35f, 1.0f, 47.09f);
                l.cubicTo(0.98f, 33.07f, 1.02f, 19.04f, 0.99f, 5.01f);
                l.cubicTo(1.1f, 3.66f, 0.63f, 1.9f, 2.11f, 1.14f);
                l.lineTo(2.11f, 1.14f);
                l.close();
                l.moveTo(40.12f, 8.16f);
                l.cubicTo(39.87f, 8.41f, 39.38f, 8.92f, 39.13f, 9.18f);
                l.cubicTo(38.91f, 14.42f, 38.89f, 19.7f, 39.14f, 24.95f);
                l.cubicTo(39.4f, 25.18f, 39.93f, 25.63f, 40.2f, 25.86f);
                l.cubicTo(45.41f, 26.11f, 50.67f, 26.09f, 55.88f, 25.87f);
                l.cubicTo(56.13f, 25.62f, 56.61f, 25.12f, 56.85f, 24.87f);
                l.cubicTo(57.11f, 19.64f, 57.11f, 14.35f, 56.85f, 9.12f);
                l.cubicTo(56.61f, 8.87f, 56.13f, 8.39f, 55.89f, 8.15f);
                l.cubicTo(50.65f, 7.9f, 45.36f, 7.88f, 40.12f, 8.16f);
                l.lineTo(40.12f, 8.16f);
                l.close();
                l.moveTo(7.15f, 27.14f);
                l.cubicTo(7.13f, 27.81f, 7.1f, 29.15f, 7.08f, 29.82f);
                l.cubicTo(16.02f, 30.11f, 24.98f, 30.13f, 33.91f, 29.81f);
                l.cubicTo(33.89f, 29.14f, 33.86f, 27.82f, 33.84f, 27.15f);
                l.cubicTo(24.95f, 26.9f, 16.04f, 26.91f, 7.15f, 27.14f);
                l.lineTo(7.15f, 27.14f);
                l.close();
                l.moveTo(7.1f, 37.16f);
                l.cubicTo(7.12f, 37.84f, 7.14f, 39.19f, 7.15f, 39.87f);
                l.cubicTo(16.06f, 40.06f, 24.99f, 40.14f, 33.9f, 39.82f);
                l.cubicTo(33.88f, 39.15f, 33.84f, 37.79f, 33.82f, 37.12f);
                l.cubicTo(24.92f, 36.94f, 16.0f, 36.88f, 7.1f, 37.16f);
                l.lineTo(7.1f, 37.16f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(42.3f, 11.32f);
                l.cubicTo(46.01f, 10.77f, 49.94f, 10.79f, 53.66f, 11.31f);
                l.cubicTo(54.26f, 15.03f, 54.2f, 18.98f, 53.69f, 22.72f);
                l.cubicTo(49.93f, 23.17f, 46.01f, 23.26f, 42.28f, 22.68f);
                l.cubicTo(41.82f, 18.94f, 41.77f, 15.04f, 42.3f, 11.32f);
                l.lineTo(42.3f, 11.32f);
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
