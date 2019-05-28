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

/* renamed from: com.tencent.mm.boot.svg.a.a.agg */
public final class agg extends C5163c {
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
                a.setColor(-6710887);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 14.0f, 0.0f, 1.0f, 12.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(32.15f, 1.21f);
                l.cubicTo(35.31f, 0.04f, 39.4f, 2.29f, 38.97f, 5.93f);
                l.cubicTo(38.98f, 15.62f, 39.11f, 25.32f, 38.91f, 35.01f);
                l.cubicTo(38.66f, 40.35f, 29.36f, 40.37f, 29.1f, 35.03f);
                l.cubicTo(28.84f, 25.66f, 29.08f, 16.28f, 28.99f, 6.91f);
                l.cubicTo(28.75f, 4.59f, 29.67f, 1.89f, 32.15f, 1.21f);
                l.lineTo(32.15f, 1.21f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(10.5f, 14.5f);
                l.cubicTo(13.31f, 12.04f, 18.2f, 14.27f, 18.4f, 17.95f);
                l.cubicTo(18.76f, 20.52f, 16.55f, 22.3f, 15.2f, 24.19f);
                l.cubicTo(10.43f, 29.93f, 8.89f, 38.04f, 10.82f, 45.2f);
                l.cubicTo(12.8f, 52.84f, 18.84f, 59.26f, 26.33f, 61.74f);
                l.cubicTo(34.52f, 64.55f, 44.17f, 62.52f, 50.42f, 56.49f);
                l.cubicTo(56.65f, 50.76f, 59.37f, 41.62f, 57.34f, 33.41f);
                l.cubicTo(56.41f, 29.04f, 53.92f, 25.26f, 50.99f, 21.97f);
                l.cubicTo(49.54f, 20.48f, 48.99f, 18.13f, 50.02f, 16.26f);
                l.cubicTo(51.35f, 13.27f, 55.79f, 12.49f, 57.98f, 14.96f);
                l.cubicTo(66.34f, 23.07f, 69.85f, 35.71f, 67.04f, 47.0f);
                l.cubicTo(63.74f, 61.51f, 49.98f, 72.8f, 35.06f, 72.95f);
                l.cubicTo(20.81f, 73.68f, 6.93f, 64.23f, 2.13f, 50.83f);
                l.cubicTo(-2.61f, 38.49f, 0.77f, 23.49f, 10.5f, 14.5f);
                l.lineTo(10.5f, 14.5f);
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
