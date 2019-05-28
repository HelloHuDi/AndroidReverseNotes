package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class yw extends c {
    private final int height = 24;
    private final int width = 24;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 24;
            case 1:
                return 24;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix h = c.h(looper);
                float[] g = c.g(looper);
                Paint k = c.k(looper);
                k.setFlags(385);
                k.setStyle(Style.FILL);
                Paint k2 = c.k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.STROKE);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(1.0f);
                k2.setStrokeCap(Cap.BUTT);
                k2.setStrokeJoin(Join.MITER);
                k2.setStrokeMiter(4.0f);
                k2.setPathEffect(null);
                Paint a = c.a(k2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 3.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.5625f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(k, looper);
                a2.setColor(-1);
                Path l = c.l(looper);
                l.moveTo(4.0f, 4.8907175f);
                l.lineTo(9.341856f, 1.1454085f);
                l.cubicTo(9.818216f, 0.8114202f, 10.475134f, 0.92683566f, 10.809122f, 1.4031961f);
                l.cubicTo(10.933353f, 1.5803846f, 11.0f, 1.7915347f, 11.0f, 2.0079353f);
                l.lineTo(11.0f, 14.870968f);
                l.cubicTo(11.0f, 15.452748f, 10.528375f, 15.924374f, 9.946595f, 15.924374f);
                l.cubicTo(9.766121f, 15.924374f, 9.588673f, 15.878006f, 9.431269f, 15.789718f);
                l.lineTo(4.0f, 12.743319f);
                l.lineTo(1.053405f, 12.743319f);
                l.cubicTo(0.47162548f, 12.743319f, 2.9329204E-16f, 12.271693f, 2.220446E-16f, 11.689914f);
                l.lineTo(0.0f, 5.944123f);
                l.cubicTo(-7.124744E-17f, 5.3623433f, 0.47162548f, 4.8907175f, 1.053405f, 4.8907175f);
                l.lineTo(4.0f, 4.8907175f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                a2.setColor(-1);
                a2.setStrokeWidth(1.87272f);
                a2.setStrokeCap(Cap.ROUND);
                l = c.l(looper);
                l.moveTo(14.029777f, 12.4375f);
                l.cubicTo(15.813192f, 12.025054f, 17.145054f, 10.392283f, 17.145054f, 8.440882f);
                l.cubicTo(17.145054f, 6.478635f, 15.798347f, 4.83857f, 14.0f, 4.4375f);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(24.0f, 0.0f);
                l.lineTo(24.0f, 24.0f);
                l.lineTo(0.0f, 24.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(24.0f, 0.0f);
                l.lineTo(24.0f, 24.0f);
                l.lineTo(0.0f, 24.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                c.j(looper);
                break;
        }
        return 0;
    }
}
