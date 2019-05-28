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

/* renamed from: com.tencent.mm.boot.svg.a.a.asq */
public final class asq extends C5163c {
    private final int height = 168;
    private final int width = 168;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 168;
            case 1:
                return 168;
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
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.saveLayerAlpha(null, 12, 4);
                canvas.save();
                Paint a = C5163c.m7876a(k2, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(75.64f, 0.0f);
                l.lineTo(92.35f, 0.0f);
                l.cubicTo(108.49f, 2.54f, 124.47f, 8.31f, 137.1f, 18.92f);
                l.cubicTo(146.41f, 26.74f, 154.4f, 36.29f, 159.53f, 47.36f);
                l.cubicTo(163.95f, 56.22f, 166.21f, 65.93f, 168.0f, 75.6f);
                l.lineTo(168.0f, 92.35f);
                l.cubicTo(165.12f, 111.53f, 157.1f, 130.37f, 142.86f, 143.85f);
                l.cubicTo(129.5f, 157.55f, 111.09f, 165.1f, 92.41f, 168.0f);
                l.lineTo(75.58f, 168.0f);
                l.cubicTo(56.68f, 165.11f, 38.04f, 157.37f, 24.68f, 143.35f);
                l.cubicTo(10.65f, 129.97f, 2.92f, 111.3f, 0.0f, 92.39f);
                l.lineTo(0.0f, 75.59f);
                l.cubicTo(2.9f, 56.92f, 10.4f, 38.45f, 24.17f, 25.14f);
                l.cubicTo(37.62f, 10.85f, 56.48f, 2.9f, 75.64f, 0.0f);
                l.lineTo(75.64f, 0.0f);
                l.close();
                l.moveTo(46.5f, 68.45f);
                l.cubicTo(45.36f, 76.59f, 46.25f, 84.82f, 46.0f, 92.99f);
                l.cubicTo(46.26f, 100.47f, 45.34f, 108.01f, 46.54f, 115.43f);
                l.cubicTo(51.87f, 117.08f, 57.48f, 117.16f, 62.98f, 117.82f);
                l.cubicTo(76.25f, 119.33f, 89.51f, 120.92f, 102.79f, 122.36f);
                l.cubicTo(108.34f, 122.9f, 113.87f, 124.28f, 119.47f, 123.62f);
                l.cubicTo(120.66f, 115.13f, 119.69f, 106.53f, 120.0f, 97.99f);
                l.cubicTo(119.79f, 90.86f, 120.64f, 83.67f, 119.48f, 76.59f);
                l.cubicTo(113.5f, 74.71f, 107.17f, 74.8f, 101.01f, 73.98f);
                l.cubicTo(88.41f, 72.47f, 75.8f, 71.0f, 63.18f, 69.65f);
                l.cubicTo(57.63f, 69.15f, 52.09f, 67.55f, 46.5f, 68.45f);
                l.lineTo(46.5f, 68.45f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(k, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                float[] a2 = C5163c.m7878a(g, 1.0f, 0.0f, 45.0f, 0.0f, 1.0f, 68.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.saveLayerAlpha(null, 25, 4);
                canvas.save();
                Paint a3 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(1.5f, 0.45f);
                l.cubicTo(7.09f, -0.45f, 12.63f, 1.15f, 18.18f, 1.65f);
                l.cubicTo(30.8f, 3.0f, 43.41f, 4.47f, 56.01f, 5.98f);
                l.cubicTo(62.17f, 6.8f, 68.5f, 6.71f, 74.48f, 8.59f);
                l.cubicTo(75.64f, 15.67f, 74.79f, 22.86f, 75.0f, 29.99f);
                l.cubicTo(74.69f, 38.53f, 75.66f, 47.13f, 74.47f, 55.62f);
                l.cubicTo(68.87f, 56.28f, 63.34f, 54.9f, 57.79f, 54.36f);
                l.cubicTo(44.51f, 52.92f, 31.25f, 51.33f, 17.98f, 49.82f);
                l.cubicTo(12.48f, 49.16f, 6.87f, 49.08f, 1.54f, 47.43f);
                l.cubicTo(0.34f, 40.01f, 1.26f, 32.47f, 1.0f, 24.99f);
                l.cubicTo(1.25f, 16.82f, 0.36f, 8.59f, 1.5f, 0.45f);
                l.lineTo(1.5f, 0.45f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(k, looper);
                a3.setColor(-1644826);
                l = C5163c.m7884l(looper);
                l.moveTo(50.35764f, 63.368923f);
                l.lineTo(113.62674f, 55.344185f);
                l.cubicTo(113.62674f, 55.344185f, 118.90408f, 54.899307f, 118.90408f, 59.134113f);
                l.cubicTo(118.904076f, 63.368923f, 118.90408f, 70.766945f, 118.90408f, 70.766945f);
                l.lineTo(50.35764f, 63.368923f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
