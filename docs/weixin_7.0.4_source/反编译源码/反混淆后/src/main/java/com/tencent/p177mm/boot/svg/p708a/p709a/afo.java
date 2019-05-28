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

/* renamed from: com.tencent.mm.boot.svg.a.a.afo */
public final class afo extends C5163c {
    private final int height = 132;
    private final int width = 132;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 132;
            case 1:
                return 132;
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
                float[] a = C5163c.m7878a(g, -1.0f, 1.2246469E-16f, 132.0f, -1.2246469E-16f, -1.0f, 132.0f);
                h.reset();
                h.setValues(a);
                canvas.concat(h);
                Paint a2 = C5163c.m7876a(k, looper);
                a2.setColor(-7822636);
                canvas.save();
                Paint a3 = C5163c.m7876a(a2, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(63.08f, 0.0f);
                l.lineTo(68.64f, 0.0f);
                l.cubicTo(86.01f, 0.73f, 102.96f, 8.52f, 114.65f, 21.42f);
                l.cubicTo(125.1f, 32.69f, 131.2f, 47.7f, 132.0f, 63.02f);
                l.lineTo(132.0f, 68.71f);
                l.cubicTo(131.26f, 85.08f, 124.34f, 101.1f, 112.68f, 112.64f);
                l.cubicTo(101.21f, 124.27f, 85.29f, 131.18f, 69.0f, 132.0f);
                l.lineTo(63.29f, 132.0f);
                l.cubicTo(45.93f, 131.25f, 29.0f, 123.46f, 17.34f, 110.56f);
                l.cubicTo(6.91f, 99.32f, 0.82f, 84.33f, 0.0f, 69.05f);
                l.lineTo(0.0f, 63.01f);
                l.cubicTo(0.8f, 47.69f, 6.91f, 32.67f, 17.37f, 21.41f);
                l.cubicTo(28.99f, 8.57f, 45.82f, 0.84f, 63.08f, 0.0f);
                l.lineTo(63.08f, 0.0f);
                l.close();
                l.moveTo(43.12f, 44.22f);
                l.cubicTo(39.58f, 45.31f, 38.89f, 49.56f, 40.43f, 52.55f);
                l.cubicTo(39.08f, 53.81f, 37.32f, 55.04f, 37.23f, 57.08f);
                l.cubicTo(36.88f, 58.97f, 38.19f, 60.52f, 38.97f, 62.1f);
                l.cubicTo(37.38f, 63.66f, 35.52f, 65.5f, 36.06f, 67.97f);
                l.cubicTo(36.21f, 70.17f, 38.12f, 71.4f, 39.79f, 72.48f);
                l.cubicTo(38.62f, 73.82f, 37.05f, 75.11f, 37.02f, 77.05f);
                l.cubicTo(36.65f, 80.31f, 39.66f, 83.26f, 42.9f, 82.97f);
                l.cubicTo(49.86f, 83.07f, 56.81f, 82.96f, 63.77f, 82.99f);
                l.cubicTo(62.15f, 89.22f, 62.4f, 95.81f, 64.01f, 102.01f);
                l.cubicTo(64.64f, 105.52f, 68.51f, 108.13f, 71.97f, 107.48f);
                l.cubicTo(73.7f, 106.68f, 73.45f, 104.59f, 73.46f, 103.04f);
                l.cubicTo(73.1f, 97.44f, 73.59f, 91.53f, 76.6f, 86.65f);
                l.cubicTo(79.18f, 82.72f, 83.06f, 78.77f, 88.1f, 78.81f);
                l.cubicTo(89.99f, 78.29f, 92.79f, 78.99f, 93.82f, 76.88f);
                l.cubicTo(94.27f, 70.61f, 93.86f, 64.31f, 94.0f, 58.03f);
                l.cubicTo(93.87f, 54.64f, 94.55f, 51.09f, 93.2f, 47.87f);
                l.cubicTo(84.14f, 49.17f, 76.71f, 42.55f, 67.96f, 41.85f);
                l.cubicTo(59.66f, 40.97f, 51.07f, 41.6f, 43.12f, 44.22f);
                l.lineTo(43.12f, 44.22f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-1);
                g = C5163c.m7878a(a, 1.0f, 0.0f, 35.0f, 0.0f, 1.0f, 41.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a4 = C5163c.m7876a(k, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(8.12f, 3.22f);
                l.cubicTo(16.07f, 0.6f, 24.66f, -0.03f, 32.96f, 0.85f);
                l.cubicTo(41.71f, 1.55f, 49.14f, 8.17f, 58.2f, 6.87f);
                l.cubicTo(59.55f, 10.09f, 58.87f, 13.64f, 59.0f, 17.03f);
                l.cubicTo(58.86f, 23.31f, 59.27f, 29.61f, 58.82f, 35.88f);
                l.cubicTo(57.79f, 37.99f, 54.99f, 37.29f, 53.1f, 37.81f);
                l.cubicTo(48.06f, 37.77f, 44.18f, 41.72f, 41.6f, 45.65f);
                l.cubicTo(38.59f, 50.53f, 38.1f, 56.44f, 38.46f, 62.04f);
                l.cubicTo(38.45f, 63.59f, 38.7f, 65.68f, 36.97f, 66.48f);
                l.cubicTo(33.51f, 67.13f, 29.64f, 64.52f, 29.01f, 61.01f);
                l.cubicTo(27.4f, 54.81f, 27.15f, 48.22f, 28.77f, 41.99f);
                l.cubicTo(21.81f, 41.96f, 14.86f, 42.07f, 7.9f, 41.97f);
                l.cubicTo(4.66f, 42.26f, 1.65f, 39.31f, 2.02f, 36.05f);
                l.cubicTo(2.05f, 34.11f, 3.62f, 32.82f, 4.79f, 31.48f);
                l.cubicTo(3.12f, 30.4f, 1.21f, 29.17f, 1.06f, 26.97f);
                l.cubicTo(0.52f, 24.5f, 2.38f, 22.66f, 3.97f, 21.1f);
                l.cubicTo(3.19f, 19.52f, 1.88f, 17.97f, 2.23f, 16.08f);
                l.cubicTo(2.32f, 14.04f, 4.08f, 12.81f, 5.43f, 11.55f);
                l.cubicTo(3.89f, 8.56f, 4.58f, 4.31f, 8.12f, 3.22f);
                l.lineTo(8.12f, 3.22f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
