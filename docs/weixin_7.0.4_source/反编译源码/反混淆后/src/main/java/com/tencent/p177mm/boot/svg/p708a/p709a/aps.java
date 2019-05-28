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

/* renamed from: com.tencent.mm.boot.svg.a.a.aps */
public final class aps extends C5163c {
    private final int height = 210;
    private final int width = 210;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 210;
            case 1:
                return 210;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 5.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-263173);
                float[] a2 = C5163c.m7878a(g, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                a = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(24.7f, 33.63f);
                l.cubicTo(40.27f, 15.91f, 62.45f, 4.14f, 85.88f, 1.28f);
                l.cubicTo(108.44f, -1.63f, 131.96f, 3.59f, 151.09f, 15.93f);
                l.cubicTo(172.67f, 29.61f, 188.49f, 52.03f, 194.03f, 76.98f);
                l.cubicTo(200.74f, 105.79f, 193.44f, 137.4f, 174.77f, 160.34f);
                l.cubicTo(173.15f, 160.22f, 171.53f, 160.1f, 169.92f, 159.98f);
                l.cubicTo(183.87f, 143.67f, 192.18f, 122.51f, 192.44f, 100.99f);
                l.cubicTo(193.16f, 79.56f, 185.98f, 58.09f, 172.86f, 41.17f);
                l.cubicTo(159.56f, 23.77f, 139.95f, 11.4f, 118.6f, 6.64f);
                l.cubicTo(99.24f, 2.59f, 78.5f, 4.25f, 60.39f, 12.4f);
                l.cubicTo(38.52f, 21.96f, 20.59f, 40.16f, 11.33f, 62.16f);
                l.cubicTo(-0.62f, 90.04f, 2.12f, 123.71f, 18.58f, 149.22f);
                l.cubicTo(17.56f, 149.45f, 15.51f, 149.9f, 14.49f, 150.13f);
                l.cubicTo(3.87f, 132.83f, -1.21f, 112.21f, 0.26f, 91.96f);
                l.cubicTo(1.63f, 70.52f, 10.41f, 49.66f, 24.7f, 33.63f);
                l.lineTo(24.7f, 33.63f);
                l.lineTo(24.7f, 33.63f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                canvas.save();
                float[] a3 = C5163c.m7878a(a2, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f);
                h.reset();
                h.setValues(a3);
                canvas.concat(h);
                canvas.save();
                Paint a4 = C5163c.m7876a(k, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(99.0f, 198.0f);
                l.cubicTo(153.6762f, 198.0f, 198.0f, 153.6762f, 198.0f, 99.0f);
                l.cubicTo(198.0f, 44.32381f, 153.6762f, 0.0f, 99.0f, 0.0f);
                l.cubicTo(44.32381f, 0.0f, 0.0f, 44.32381f, 0.0f, 99.0f);
                l.cubicTo(0.0f, 153.6762f, 44.32381f, 198.0f, 99.0f, 198.0f);
                l.lineTo(99.0f, 198.0f);
                l.close();
                l.moveTo(99.0f, 193.0f);
                l.cubicTo(150.91476f, 193.0f, 193.0f, 150.91476f, 193.0f, 99.0f);
                l.cubicTo(193.0f, 47.08523f, 150.91476f, 5.0f, 99.0f, 5.0f);
                l.cubicTo(47.08523f, 5.0f, 5.0f, 47.08523f, 5.0f, 99.0f);
                l.cubicTo(5.0f, 150.91476f, 47.08523f, 193.0f, 99.0f, 193.0f);
                l.lineTo(99.0f, 193.0f);
                l.close();
                k2 = C5163c.m7883k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.FILL);
                Paint k3 = C5163c.m7883k(looper);
                k3.setFlags(385);
                k3.setStyle(Style.STROKE);
                k2.setColor(WebView.NIGHT_MODE_COLOR);
                k3.setStrokeWidth(1.0f);
                k3.setStrokeCap(Cap.BUTT);
                k3.setStrokeJoin(Join.MITER);
                k3.setStrokeMiter(4.0f);
                k3.setPathEffect(null);
                float[] a5 = C5163c.m7878a(a3, 198.0f, 0.0f, 0.0f, 0.0f, 198.0f, 0.0f);
                h.reset();
                h.setValues(a5);
                WeChatSVGRenderC2Java.setLinearGradient(a4, 0.5f, 0.0f, 0.5f, 1.0f, new int[]{-1, -1184275}, new float[]{0.0f, 1.0f}, h, 0);
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
