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

/* renamed from: com.tencent.mm.boot.svg.a.a.pv */
public final class C6367pv extends C5163c {
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
                a.setColor(-1);
                Path l = C5163c.m7884l(looper);
                l.moveTo(114.11689f, 70.98039f);
                l.cubicTo(111.951485f, 70.98039f, 110.27686f, 72.72528f, 110.37761f, 74.90139f);
                l.lineTo(113.37151f, 139.56976f);
                l.cubicTo(113.42262f, 140.6737f, 114.36253f, 141.56863f, 115.46362f, 141.56863f);
                l.lineTo(124.53638f, 141.56863f);
                l.cubicTo(125.64071f, 141.56863f, 126.57727f, 140.67613f, 126.62849f, 139.56976f);
                l.lineTo(129.62239f, 74.90139f);
                l.cubicTo(129.72266f, 72.73588f, 128.0466f, 70.98039f, 125.88311f, 70.98039f);
                l.lineTo(114.11689f, 70.98039f);
                l.close();
                l.moveTo(120.0f, 172.94118f);
                l.cubicTo(125.41456f, 172.94118f, 129.80392f, 168.5518f, 129.80392f, 163.13725f);
                l.cubicTo(129.80392f, 157.7227f, 125.41456f, 153.33333f, 120.0f, 153.33333f);
                l.cubicTo(114.58544f, 153.33333f, 110.196075f, 157.7227f, 110.196075f, 163.13725f);
                l.cubicTo(110.196075f, 168.5518f, 114.58544f, 172.94118f, 120.0f, 172.94118f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 58.0f, 0.0f, 1.0f, 75.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-16139513);
                l = C5163c.m7884l(looper);
                l.moveTo(88.503105f, 63.260868f);
                l.cubicTo(81.83925f, 55.480328f, 72.46273f, 51.086956f, 62.509315f, 51.086956f);
                l.cubicTo(51.689445f, 51.086956f, 42.312923f, 55.480328f, 35.649067f, 63.260868f);
                l.lineTo(42.580746f, 70.21739f);
                l.cubicTo(47.99571f, 65.064156f, 54.781292f, 61.847816f, 62.509315f, 62.391304f);
                l.cubicTo(69.71429f, 61.847816f, 76.405556f, 64.96478f, 81.57143f, 70.21739f);
                l.lineTo(88.503105f, 63.260868f);
                l.close();
                l.moveTo(61.642857f, 25.869566f);
                l.cubicTo(44.52152f, 25.869566f, 28.799698f, 32.994526f, 17.453417f, 45.0f);
                l.lineTo(25.251553f, 52.826088f);
                l.cubicTo(35.159626f, 43.23779f, 48.249474f, 37.29962f, 62.509315f, 37.173912f);
                l.cubicTo(76.95079f, 37.29962f, 89.85206f, 43.048466f, 98.90062f, 51.95652f);
                l.lineTo(106.69876f, 45.0f);
                l.cubicTo(95.32615f, 33.14707f, 79.4547f, 25.869566f, 61.642857f, 25.869566f);
                l.close();
                l.moveTo(124.02795f, 26.73913f);
                l.cubicTo(108.21251f, 10.5176935f, 86.30065f, 0.65217394f, 62.509315f, 0.65217394f);
                l.cubicTo(37.861656f, 0.65217394f, 15.941242f, 10.526303f, 0.124223605f, 26.73913f);
                l.lineTo(7.9223604f, 34.565216f);
                l.cubicTo(22.125067f, 20.522926f, 41.417408f, 11.826344f, 62.509315f, 11.956522f);
                l.cubicTo(83.71855f, 11.826344f, 102.73295f, 20.24566f, 116.22981f, 33.695652f);
                l.lineTo(124.02795f, 26.73913f);
                l.close();
                l.moveTo(71.17391f, 80.652176f);
                l.cubicTo(68.97959f, 77.84855f, 65.76467f, 76.304344f, 62.509315f, 76.304344f);
                l.cubicTo(58.48254f, 76.304344f, 55.174686f, 77.95143f, 52.97826f, 80.652176f);
                l.lineTo(61.642857f, 89.347824f);
                l.lineTo(71.17391f, 80.652176f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.restore();
                canvas.save();
                float[] a2 = C5163c.m7878a(g, 1.0f, 0.0f, 0.095238f, 0.0f, 1.0f, 0.652174f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
