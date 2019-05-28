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

/* renamed from: com.tencent.mm.boot.svg.a.a.aun */
public final class aun extends C5163c {
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
                float[] a = C5163c.m7878a(g, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 4.0f);
                h.reset();
                h.setValues(a);
                canvas.concat(h);
                Paint a2 = C5163c.m7876a(k, looper);
                a2.setColor(-11962667);
                canvas.save();
                Paint a3 = C5163c.m7876a(a2, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.04f, 6.94f);
                l.cubicTo(8.881784E-16f, 2.86f, 4.0f, -0.44f, 7.99f, 0.0f);
                l.cubicTo(20.37f, 0.04f, 32.75f, -0.07f, 45.12f, 0.05f);
                l.cubicTo(48.71f, 0.04f, 51.97f, 3.27f, 51.94f, 6.87f);
                l.cubicTo(52.12f, 18.57f, 51.89f, 30.28f, 52.04f, 41.99f);
                l.cubicTo(46.03f, 42.0f, 40.01f, 42.01f, 34.0f, 41.99f);
                l.lineTo(34.0f, 36.0f);
                l.cubicTo(36.66f, 36.01f, 39.33f, 35.99f, 42.0f, 36.0f);
                l.lineTo(42.0f, 26.0f);
                l.cubicTo(39.33f, 26.01f, 36.65f, 25.99f, 33.98f, 26.0f);
                l.cubicTo(33.98f, 23.98f, 33.91f, 21.94f, 34.17f, 19.93f);
                l.cubicTo(35.74f, 17.24f, 39.43f, 18.28f, 42.0f, 17.94f);
                l.lineTo(42.0f, 8.01f);
                l.cubicTo(36.9f, 8.27f, 30.84f, 6.82f, 26.7f, 10.63f);
                l.cubicTo(22.53f, 14.63f, 24.4f, 20.89f, 24.01f, 26.0f);
                l.lineTo(18.0f, 26.0f);
                l.lineTo(18.0f, 36.0f);
                l.lineTo(24.0f, 36.0f);
                l.cubicTo(24.0f, 38.0f, 23.99f, 39.99f, 24.0f, 41.99f);
                l.cubicTo(15.99f, 42.0f, 7.97f, 42.0f, -0.04f, 41.99f);
                l.cubicTo(0.09f, 30.31f, -0.1f, 18.62f, 0.04f, 6.94f);
                l.lineTo(0.04f, 6.94f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-9398565);
                g = C5163c.m7878a(a, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 42.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a4 = C5163c.m7876a(k, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(-0.04f, -0.01f);
                l.cubicTo(7.97f, 0.0f, 15.99f, 0.0f, 24.0f, -0.01f);
                l.lineTo(24.0f, 10.0f);
                l.cubicTo(17.69f, 9.83f, 11.35f, 10.34f, 5.07f, 9.75f);
                l.cubicTo(0.85f, 8.58f, -0.57f, 3.92f, -0.04f, -0.01f);
                l.lineTo(-0.04f, -0.01f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.save();
                a4 = C5163c.m7876a(k, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(34.0f, -0.01f);
                l.cubicTo(40.01f, 0.01f, 46.03f, 0.0f, 52.04f, -0.01f);
                l.cubicTo(52.55f, 3.89f, 51.21f, 8.51f, 47.03f, 9.72f);
                l.cubicTo(42.72f, 10.34f, 38.34f, 9.85f, 34.0f, 10.0f);
                l.lineTo(34.0f, -0.01f);
                l.lineTo(34.0f, -0.01f);
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
