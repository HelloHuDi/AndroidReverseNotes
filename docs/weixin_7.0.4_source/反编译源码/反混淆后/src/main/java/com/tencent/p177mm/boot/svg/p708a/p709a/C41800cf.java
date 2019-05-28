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

/* renamed from: com.tencent.mm.boot.svg.a.a.cf */
public final class C41800cf extends C5163c {
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
                a.setColor(-1686720);
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
                a.setColor(-4704973);
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
                l.moveTo(13.462891f, 48.089844f);
                l.lineTo(20.03711f, 48.089844f);
                l.cubicTo(23.40039f, 48.089844f, 25.732422f, 50.375f, 25.732422f, 53.75f);
                l.cubicTo(25.732422f, 57.125f, 23.330078f, 59.410156f, 19.908203f, 59.410156f);
                l.lineTo(16.486328f, 59.410156f);
                l.lineTo(16.486328f, 65.0f);
                l.lineTo(13.462891f, 65.0f);
                l.lineTo(13.462891f, 48.089844f);
                l.close();
                l.moveTo(16.486328f, 50.5625f);
                l.lineTo(16.486328f, 56.972656f);
                l.lineTo(19.228516f, 56.972656f);
                l.cubicTo(21.396484f, 56.972656f, 22.66211f, 55.80078f, 22.66211f, 53.75f);
                l.cubicTo(22.66211f, 51.722656f, 21.408203f, 50.5625f, 19.240234f, 50.5625f);
                l.lineTo(16.486328f, 50.5625f);
                l.close();
                l.moveTo(27.935547f, 48.089844f);
                l.lineTo(34.11133f, 48.089844f);
                l.cubicTo(39.16211f, 48.089844f, 42.15039f, 51.148438f, 42.15039f, 56.503906f);
                l.cubicTo(42.15039f, 61.859375f, 39.17383f, 65.0f, 34.11133f, 65.0f);
                l.lineTo(27.935547f, 65.0f);
                l.lineTo(27.935547f, 48.089844f);
                l.close();
                l.moveTo(30.958984f, 50.64453f);
                l.lineTo(30.958984f, 62.445312f);
                l.lineTo(33.79492f, 62.445312f);
                l.cubicTo(37.19336f, 62.445312f, 39.06836f, 60.371094f, 39.06836f, 56.515625f);
                l.cubicTo(39.06836f, 52.73047f, 37.16992f, 50.64453f, 33.79492f, 50.64453f);
                l.lineTo(30.958984f, 50.64453f);
                l.close();
                l.moveTo(47.564453f, 65.0f);
                l.lineTo(44.541016f, 65.0f);
                l.lineTo(44.541016f, 48.089844f);
                l.lineTo(55.322266f, 48.089844f);
                l.lineTo(55.322266f, 50.64453f);
                l.lineTo(47.564453f, 50.64453f);
                l.lineTo(47.564453f, 55.63672f);
                l.lineTo(54.654297f, 55.63672f);
                l.lineTo(54.654297f, 58.097656f);
                l.lineTo(47.564453f, 58.097656f);
                l.lineTo(47.564453f, 65.0f);
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
