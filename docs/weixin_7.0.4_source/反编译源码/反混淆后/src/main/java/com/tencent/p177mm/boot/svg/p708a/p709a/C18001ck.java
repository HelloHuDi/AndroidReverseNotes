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

/* renamed from: com.tencent.mm.boot.svg.a.a.ck */
public final class C18001ck extends C5163c {
    private final int height = 90;
    private final int width = 90;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-7645398);
                Path l = C5163c.m7884l(looper);
                l.moveTo(46.0f, 0.0f);
                l.lineTo(68.0f, 22.0f);
                l.lineTo(68.0f, 87.0f);
                l.cubicTo(68.0f, 88.65685f, 66.65685f, 90.0f, 65.0f, 90.0f);
                l.lineTo(3.0f, 90.0f);
                l.cubicTo(1.3431457f, 90.0f, 2.0290612E-16f, 88.65685f, 0.0f, 87.0f);
                l.lineTo(0.0f, 3.0f);
                l.cubicTo(-2.0290612E-16f, 1.3431457f, 1.3431457f, 3.043592E-16f, 3.0f, 0.0f);
                l.lineTo(46.0f, 0.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(k, looper);
                a.setColor(-9485023);
                l = C5163c.m7884l(looper);
                l.moveTo(68.0f, 22.0f);
                l.lineTo(49.0f, 22.0f);
                l.cubicTo(47.343147f, 22.0f, 46.0f, 20.656855f, 46.0f, 19.0f);
                l.lineTo(46.0f, 0.0f);
                l.lineTo(68.0f, 22.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                l = C5163c.m7884l(looper);
                l.moveTo(32.714287f, 22.67442f);
                l.lineTo(32.714287f, 15.116279f);
                l.lineTo(29.5f, 15.116279f);
                l.cubicTo(28.671574f, 15.116279f, 28.0f, 14.444706f, 28.0f, 13.616279f);
                l.lineTo(28.0f, 9.05814f);
                l.cubicTo(28.0f, 8.2297125f, 28.671574f, 7.5581393f, 29.5f, 7.5581393f);
                l.lineTo(32.714287f, 7.5581393f);
                l.lineTo(32.714287f, 0.0f);
                l.lineTo(37.5f, 2.220446E-16f);
                l.cubicTo(38.328426f, -6.659261E-16f, 39.0f, 0.67157286f, 39.0f, 1.5f);
                l.lineTo(39.0f, 6.0581393f);
                l.cubicTo(39.0f, 6.8865666f, 38.328426f, 7.5581393f, 37.5f, 7.5581393f);
                l.lineTo(34.285713f, 7.5581393f);
                l.lineTo(34.285713f, 15.116279f);
                l.lineTo(37.5f, 15.116279f);
                l.cubicTo(38.328426f, 15.116279f, 39.0f, 15.787852f, 39.0f, 16.61628f);
                l.lineTo(39.0f, 21.17442f);
                l.cubicTo(39.0f, 22.002846f, 38.328426f, 22.67442f, 37.5f, 22.67442f);
                l.lineTo(34.285713f, 22.67442f);
                l.lineTo(34.285713f, 30.232557f);
                l.lineTo(37.5f, 30.232557f);
                l.cubicTo(38.328426f, 30.232557f, 39.0f, 30.90413f, 39.0f, 31.732557f);
                l.lineTo(39.0f, 36.2907f);
                l.cubicTo(39.0f, 37.119125f, 38.328426f, 37.7907f, 37.5f, 37.7907f);
                l.lineTo(32.714287f, 37.7907f);
                l.lineTo(32.714287f, 30.232557f);
                l.lineTo(29.5f, 30.232557f);
                l.cubicTo(28.671574f, 30.232557f, 28.0f, 29.560986f, 28.0f, 28.732557f);
                l.lineTo(28.0f, 24.17442f);
                l.cubicTo(28.0f, 23.345991f, 28.671574f, 22.67442f, 29.5f, 22.67442f);
                l.lineTo(32.714287f, 22.67442f);
                l.close();
                l.moveTo(29.5f, 42.32558f);
                l.lineTo(37.5f, 42.32558f);
                l.cubicTo(38.328426f, 42.32558f, 39.0f, 42.997154f, 39.0f, 43.82558f);
                l.lineTo(39.0f, 63.5f);
                l.cubicTo(39.0f, 64.32843f, 38.328426f, 65.0f, 37.5f, 65.0f);
                l.lineTo(29.5f, 65.0f);
                l.cubicTo(28.671574f, 65.0f, 28.0f, 64.32843f, 28.0f, 63.5f);
                l.lineTo(28.0f, 43.82558f);
                l.cubicTo(28.0f, 42.997154f, 28.671574f, 42.32558f, 29.5f, 42.32558f);
                l.close();
                l.moveTo(30.357143f, 54.418606f);
                l.lineTo(30.357143f, 62.73256f);
                l.lineTo(36.642857f, 62.73256f);
                l.lineTo(36.642857f, 54.418606f);
                l.lineTo(30.357143f, 54.418606f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
