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

/* renamed from: com.tencent.mm.boot.svg.a.a.bbb */
public final class bbb extends C5163c {
    private final int height = 240;
    private final int width = 240;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 240;
            case 1:
                return 240;
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
                a.setColor(-15879408);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(95.55f, 0.86f);
                l.cubicTo(119.32f, -2.19f, 144.07f, 2.98f, 164.58f, 15.41f);
                l.cubicTo(186.83f, 28.72f, 204.03f, 50.3f, 211.85f, 75.04f);
                l.cubicTo(219.43f, 98.53f, 218.59f, 124.63f, 209.5f, 147.57f);
                l.cubicTo(199.91f, 172.1f, 180.97f, 192.79f, 157.4f, 204.55f);
                l.cubicTo(134.65f, 216.07f, 107.76f, 218.98f, 83.03f, 212.84f);
                l.cubicTo(56.39f, 206.36f, 32.6f, 189.18f, 17.92f, 166.03f);
                l.cubicTo(4.3f, 144.85f, -1.44f, 118.78f, 1.94f, 93.84f);
                l.cubicTo(4.98f, 69.99f, 16.41f, 47.37f, 33.67f, 30.65f);
                l.cubicTo(50.33f, 14.34f, 72.39f, 3.65f, 95.55f, 0.86f);
                l.lineTo(95.55f, 0.86f);
                l.close();
                l.moveTo(158.3f, 71.29f);
                l.cubicTo(138.2f, 94.33f, 118.23f, 117.5f, 98.19f, 140.6f);
                l.cubicTo(88.05f, 130.48f, 77.91f, 120.35f, 67.79f, 110.2f);
                l.cubicTo(66.69f, 109.14f, 65.53f, 108.0f, 63.96f, 107.72f);
                l.cubicTo(58.37f, 106.48f, 52.71f, 114.39f, 57.26f, 118.78f);
                l.cubicTo(69.36f, 131.0f, 81.57f, 143.12f, 93.73f, 155.3f);
                l.cubicTo(96.07f, 158.1f, 100.88f, 158.18f, 103.15f, 155.26f);
                l.cubicTo(124.54f, 130.6f, 145.9f, 105.9f, 167.3f, 81.25f);
                l.cubicTo(168.06f, 80.26f, 168.99f, 79.31f, 169.25f, 78.04f);
                l.cubicTo(170.72f, 72.43f, 162.64f, 66.64f, 158.3f, 71.29f);
                l.lineTo(158.3f, 71.29f);
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
