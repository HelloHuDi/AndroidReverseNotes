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

/* renamed from: com.tencent.mm.boot.svg.a.a.aky */
public final class aky extends C5163c {
    private final int height = 271;
    private final int width = 152;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 152;
            case 1:
                return 271;
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
                Paint a = C5163c.m7876a(k2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                float[] a2 = C5163c.m7878a(g, 1.0f, 0.0f, 1.333333f, 0.0f, 1.0f, 2.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                Paint a3 = C5163c.m7876a(a, looper);
                a3.setColor(WebView.NIGHT_MODE_COLOR);
                a3.setStrokeWidth(4.0f);
                Path l = C5163c.m7884l(looper);
                l.moveTo(2.0f, 16.0f);
                l.cubicTo(2.0f, 8.268013f, 8.268013f, 2.0f, 16.0f, 2.0f);
                l.lineTo(133.33333f, 2.0f);
                l.cubicTo(141.0653f, 2.0f, 147.33333f, 8.268013f, 147.33333f, 16.0f);
                l.lineTo(147.33333f, 250.66666f);
                l.cubicTo(147.33333f, 258.39865f, 141.0653f, 264.66666f, 133.33333f, 264.66666f);
                l.lineTo(16.0f, 264.66666f);
                l.cubicTo(8.268013f, 264.66666f, 2.0f, 258.39865f, 2.0f, 250.66666f);
                l.lineTo(2.0f, 16.0f);
                l.close();
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                Paint a4 = C5163c.m7876a(a, looper);
                a4.setColor(WebView.NIGHT_MODE_COLOR);
                a4.setStrokeWidth(2.0f);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(11.666667f, 29.0f);
                l2.lineTo(11.666667f, 232.33333f);
                l2.lineTo(137.66667f, 232.33333f);
                l2.lineTo(137.66667f, 29.0f);
                l2.lineTo(11.666667f, 29.0f);
                l2.close();
                canvas.drawPath(l2, a4);
                canvas.restore();
                canvas.save();
                a4 = C5163c.m7876a(k, looper);
                a4.setColor(WebView.NIGHT_MODE_COLOR);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(65.333336f, 13.333333f);
                l2.lineTo(85.333336f, 13.333333f);
                l2.lineTo(85.333336f, 17.333332f);
                l2.lineTo(65.333336f, 17.333332f);
                l2.lineTo(65.333336f, 13.333333f);
                l2.close();
                canvas.drawPath(l2, a4);
                canvas.restore();
                canvas.restore();
                canvas.save();
                g = C5163c.m7878a(a2, 1.0f, 0.0f, 42.666668f, 0.0f, 1.0f, 91.333336f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a5 = C5163c.m7876a(a, looper);
                a5.setColor(-15028967);
                a5.setStrokeWidth(3.0f);
                l = C5163c.m7884l(looper);
                l.moveTo(66.666664f, 33.744858f);
                l.cubicTo(66.666664f, 14.923457f, 51.74321f, 0.0f, 32.92181f, 0.0f);
                l.cubicTo(14.923457f, 0.0f, 0.0f, 14.923457f, 0.0f, 33.744858f);
                l.cubicTo(0.0f, 51.74321f, 14.923457f, 66.666664f, 32.92181f, 66.666664f);
                l.cubicTo(51.74321f, 66.666664f, 66.666664f, 51.74321f, 66.666664f, 33.744858f);
                l.close();
                canvas.drawPath(l, a5);
                canvas.restore();
                canvas.save();
                a5 = C5163c.m7876a(k, looper);
                a5.setColor(-15028967);
                l = C5163c.m7884l(looper);
                l.moveTo(16.874653f, 34.66012f);
                l.lineTo(18.06757f, 33.036938f);
                l.lineTo(18.06757f, 33.036938f);
                l.cubicTo(18.28561f, 32.740253f, 18.702879f, 32.676502f, 18.999563f, 32.894543f);
                l.cubicTo(19.003172f, 32.897194f, 19.006756f, 32.899883f, 19.010311f, 32.90261f);
                l.lineTo(27.124714f, 39.121834f);
                l.lineTo(27.124714f, 39.121834f);
                l.cubicTo(27.619293f, 39.5009f, 28.310467f, 39.48685f, 28.789234f, 39.088f);
                l.lineTo(49.794125f, 21.589226f);
                l.lineTo(49.794125f, 21.589226f);
                l.cubicTo(50.05779f, 21.369574f, 50.445126f, 21.385962f, 50.689293f, 21.6271f);
                l.lineTo(51.706726f, 22.631914f);
                l.lineTo(51.706726f, 22.631914f);
                l.cubicTo(51.968697f, 22.890633f, 51.97133f, 23.312735f, 51.71261f, 23.574705f);
                l.cubicTo(51.71039f, 23.576954f, 51.70815f, 23.579187f, 51.7059f, 23.581406f);
                l.lineTo(28.928864f, 45.99741f);
                l.lineTo(28.928864f, 45.99741f);
                l.cubicTo(28.404022f, 46.51393f, 27.559828f, 46.507187f, 27.043306f, 45.982346f);
                l.cubicTo(27.040442f, 45.979435f, 27.037592f, 45.976513f, 27.034756f, 45.973576f);
                l.lineTo(16.932417f, 35.518158f);
                l.lineTo(16.932417f, 35.518158f);
                l.cubicTo(16.706604f, 35.284454f, 16.682201f, 34.92198f, 16.874653f, 34.66012f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a5);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
