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

/* renamed from: com.tencent.mm.boot.svg.a.a.ade */
public final class ade extends C5163c {
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
                a.setColor(-4868683);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 23.0f, 0.0f, 1.0f, 23.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(20.43f, 0.56f);
                l.cubicTo(26.75f, -0.88f, 33.58f, 0.53f, 38.89f, 4.21f);
                l.cubicTo(47.37f, 10.01f, 51.78f, 21.3f, 49.26f, 31.28f);
                l.cubicTo(47.01f, 40.43f, 39.16f, 47.82f, 29.91f, 49.59f);
                l.cubicTo(17.72f, 51.88f, 4.26f, 44.13f, 0.95f, 32.0f);
                l.cubicTo(-3.19f, 18.46f, 6.49f, 2.93f, 20.43f, 0.56f);
                l.lineTo(20.43f, 0.56f);
                l.close();
                l.moveTo(20.46f, 3.53f);
                l.cubicTo(11.63f, 5.29f, 4.4f, 13.0f, 3.28f, 21.94f);
                l.cubicTo(2.12f, 29.59f, 5.43f, 37.68f, 11.58f, 42.35f);
                l.cubicTo(17.99f, 47.43f, 27.32f, 48.37f, 34.62f, 44.71f);
                l.cubicTo(41.38f, 41.48f, 46.2f, 34.55f, 46.83f, 27.08f);
                l.cubicTo(47.61f, 19.72f, 44.29f, 12.11f, 38.4f, 7.64f);
                l.cubicTo(33.4f, 3.72f, 26.66f, 2.21f, 20.46f, 3.53f);
                l.lineTo(20.46f, 3.53f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(24.26f, 11.33f);
                l.cubicTo(27.01f, 9.64f, 29.55f, 14.15f, 26.77f, 15.67f);
                l.cubicTo(24.01f, 17.4f, 21.42f, 12.82f, 24.26f, 11.33f);
                l.lineTo(24.26f, 11.33f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(21.0f, 19.0f);
                l.cubicTo(23.29f, 19.0f, 25.58f, 19.0f, 27.87f, 19.01f);
                l.cubicTo(27.86f, 25.15f, 27.86f, 31.3f, 27.86f, 37.45f);
                l.cubicTo(28.91f, 37.46f, 29.95f, 37.47f, 31.0f, 37.48f);
                l.lineTo(31.0f, 38.99f);
                l.cubicTo(27.67f, 39.0f, 24.33f, 39.0f, 21.0f, 38.99f);
                l.lineTo(21.0f, 37.49f);
                l.cubicTo(22.05f, 37.47f, 23.1f, 37.44f, 24.15f, 37.4f);
                l.cubicTo(24.12f, 31.78f, 24.15f, 26.17f, 24.14f, 20.55f);
                l.cubicTo(23.09f, 20.54f, 22.05f, 20.53f, 21.0f, 20.53f);
                l.lineTo(21.0f, 19.0f);
                l.lineTo(21.0f, 19.0f);
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
