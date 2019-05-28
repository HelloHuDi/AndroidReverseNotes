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

/* renamed from: com.tencent.mm.boot.svg.a.a.tk */
public final class C25938tk extends C5163c {
    private final int height = 84;
    private final int width = 84;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 84;
            case 1:
                return 84;
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
                a.setColor(-12632257);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 11.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(35.22f, 1.24f);
                l.cubicTo(37.07f, 0.38f, 38.78f, 1.74f, 39.99f, 3.02f);
                l.cubicTo(46.3f, 9.37f, 52.64f, 15.71f, 59.0f, 22.03f);
                l.cubicTo(60.28f, 23.24f, 61.63f, 24.96f, 60.75f, 26.81f);
                l.cubicTo(59.45f, 28.82f, 57.57f, 30.34f, 55.92f, 32.03f);
                l.cubicTo(46.93f, 41.02f, 37.93f, 50.0f, 28.97f, 59.01f);
                l.cubicTo(27.92f, 60.06f, 26.73f, 61.17f, 25.11f, 60.97f);
                l.cubicTo(18.37f, 61.03f, 11.64f, 61.03f, 4.91f, 60.97f);
                l.cubicTo(2.69f, 61.26f, 0.76f, 59.27f, 1.03f, 57.08f);
                l.cubicTo(0.97f, 50.36f, 0.97f, 43.63f, 1.03f, 36.91f);
                l.cubicTo(0.83f, 35.27f, 1.97f, 34.09f, 3.01f, 33.02f);
                l.cubicTo(12.02f, 24.05f, 21.0f, 15.05f, 29.99f, 6.06f);
                l.cubicTo(31.69f, 4.41f, 33.2f, 2.52f, 35.22f, 1.24f);
                l.lineTo(35.22f, 1.24f);
                l.close();
                l.moveTo(16.19f, 38.29f);
                l.cubicTo(12.01f, 39.42f, 10.56f, 45.34f, 13.77f, 48.25f);
                l.cubicTo(16.68f, 51.44f, 22.61f, 49.99f, 23.71f, 45.81f);
                l.cubicTo(25.36f, 41.43f, 20.56f, 36.65f, 16.19f, 38.29f);
                l.lineTo(16.19f, 38.29f);
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
