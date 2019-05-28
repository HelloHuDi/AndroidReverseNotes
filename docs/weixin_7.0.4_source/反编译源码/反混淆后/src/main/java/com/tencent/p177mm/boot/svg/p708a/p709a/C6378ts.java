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

/* renamed from: com.tencent.mm.boot.svg.a.a.ts */
public final class C6378ts extends C5163c {
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, 8.0f, 0.0f, 1.0f, 12.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(46.01f, 0.01f);
                l.cubicTo(53.34f, 6.17f, 60.67f, 12.33f, 68.0f, 18.5f);
                l.cubicTo(60.71f, 24.71f, 53.33f, 30.82f, 46.0f, 36.99f);
                l.lineTo(46.0f, 25.98f);
                l.cubicTo(38.85f, 26.16f, 30.92f, 26.38f, 25.14f, 31.16f);
                l.cubicTo(21.72f, 33.97f, 19.85f, 38.1f, 17.97f, 41.99f);
                l.cubicTo(18.18f, 31.93f, 21.12f, 20.86f, 29.63f, 14.65f);
                l.cubicTo(34.27f, 11.04f, 40.36f, 10.72f, 45.99f, 11.02f);
                l.cubicTo(46.0f, 7.35f, 45.99f, 3.68f, 46.01f, 0.01f);
                l.lineTo(46.01f, 0.01f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(1.0f, 14.89f);
                l.cubicTo(0.71f, 13.12f, 1.88f, 10.94f, 3.88f, 11.06f);
                l.cubicTo(9.91f, 10.89f, 15.95f, 11.07f, 21.98f, 10.99f);
                l.cubicTo(20.16f, 13.11f, 18.66f, 15.48f, 17.45f, 17.99f);
                l.cubicTo(14.3f, 18.0f, 11.15f, 18.0f, 8.0f, 18.0f);
                l.lineTo(8.0f, 52.0f);
                l.lineTo(54.0f, 52.0f);
                l.lineTo(54.0f, 40.15f);
                l.cubicTo(56.31f, 38.17f, 58.64f, 36.2f, 60.99f, 34.26f);
                l.cubicTo(60.97f, 41.54f, 61.08f, 48.82f, 60.94f, 56.1f);
                l.cubicTo(61.02f, 58.07f, 58.92f, 59.33f, 57.12f, 58.99f);
                l.cubicTo(39.71f, 59.0f, 22.31f, 59.0f, 4.91f, 59.0f);
                l.cubicTo(3.11f, 59.32f, 0.93f, 58.1f, 1.05f, 56.09f);
                l.cubicTo(0.93f, 42.36f, 1.03f, 28.62f, 1.0f, 14.89f);
                l.lineTo(1.0f, 14.89f);
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
