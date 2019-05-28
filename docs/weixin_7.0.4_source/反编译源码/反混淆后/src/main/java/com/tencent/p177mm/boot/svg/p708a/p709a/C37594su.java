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

/* renamed from: com.tencent.mm.boot.svg.a.a.su */
public final class C37594su extends C5163c {
    private final int height = 224;
    private final int width = 224;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 224;
            case 1:
                return 224;
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
                float[] a = C5163c.m7878a(g, 1.0f, 0.0f, 25.0f, 0.0f, 1.0f, 60.0f);
                h.reset();
                h.setValues(a);
                canvas.concat(h);
                Paint a2 = C5163c.m7876a(k, looper);
                a2.setColor(-1749411);
                canvas.save();
                Paint a3 = C5163c.m7876a(a2, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(78.05f, 2.08f);
                l.cubicTo(92.32f, -2.34f, 108.61f, 0.42f, 120.54f, 9.45f);
                l.cubicTo(131.03f, 17.08f, 138.02f, 29.15f, 139.66f, 42.01f);
                l.cubicTo(150.08f, 40.99f, 160.9f, 45.34f, 167.32f, 53.67f);
                l.cubicTo(174.74f, 62.81f, 176.09f, 76.3f, 170.66f, 86.74f);
                l.cubicTo(165.6f, 96.97f, 154.51f, 103.83f, 143.08f, 103.73f);
                l.cubicTo(107.72f, 103.72f, 72.35f, 103.76f, 36.99f, 103.71f);
                l.cubicTo(21.48f, 103.54f, 6.85f, 92.76f, 2.02f, 78.03f);
                l.cubicTo(-2.32f, 65.62f, 0.47f, 51.06f, 9.16f, 41.18f);
                l.cubicTo(18.37f, 30.18f, 33.97f, 25.52f, 47.79f, 29.14f);
                l.cubicTo(53.35f, 16.31f, 64.62f, 6.08f, 78.05f, 2.08f);
                l.lineTo(78.05f, 2.08f);
                l.close();
                l.moveTo(88.29f, 34.29f);
                l.cubicTo(86.16f, 35.27f, 85.9f, 37.85f, 86.04f, 39.91f);
                l.cubicTo(86.45f, 50.3f, 86.59f, 60.7f, 87.07f, 71.08f);
                l.cubicTo(87.03f, 73.46f, 90.38f, 74.74f, 92.01f, 73.03f);
                l.cubicTo(93.22f, 72.07f, 92.9f, 70.4f, 93.07f, 69.06f);
                l.cubicTo(93.32f, 58.68f, 93.77f, 48.31f, 93.96f, 37.93f);
                l.cubicTo(94.28f, 34.98f, 90.81f, 32.98f, 88.29f, 34.29f);
                l.lineTo(88.29f, 34.29f);
                l.close();
                l.moveTo(88.38f, 80.23f);
                l.cubicTo(85.15f, 82.09f, 88.2f, 87.31f, 91.36f, 85.43f);
                l.cubicTo(95.05f, 83.76f, 91.72f, 77.96f, 88.38f, 80.23f);
                l.lineTo(88.38f, 80.23f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-1);
                g = C5163c.m7878a(a, 1.0f, 0.0f, 86.0f, 0.0f, 1.0f, 33.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a4 = C5163c.m7876a(k, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(2.29f, 1.29f);
                l.cubicTo(4.81f, -0.02f, 8.28f, 1.98f, 7.96f, 4.93f);
                l.cubicTo(7.77f, 15.31f, 7.32f, 25.68f, 7.07f, 36.06f);
                l.cubicTo(6.9f, 37.4f, 7.22f, 39.07f, 6.01f, 40.03f);
                l.cubicTo(4.38f, 41.74f, 1.03f, 40.46f, 1.07f, 38.08f);
                l.cubicTo(0.59f, 27.7f, 0.45f, 17.3f, 0.04f, 6.91f);
                l.cubicTo(-0.1f, 4.85f, 0.16f, 2.27f, 2.29f, 1.29f);
                l.lineTo(2.29f, 1.29f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.save();
                a4 = C5163c.m7876a(k, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(2.38f, 47.23f);
                l.cubicTo(5.72f, 44.96f, 9.05f, 50.76f, 5.36f, 52.43f);
                l.cubicTo(2.2f, 54.31f, -0.85f, 49.09f, 2.38f, 47.23f);
                l.lineTo(2.38f, 47.23f);
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
