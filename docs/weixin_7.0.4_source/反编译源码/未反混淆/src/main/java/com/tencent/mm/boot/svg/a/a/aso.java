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

public final class aso extends c {
    private final int height = 44;
    private final int width = 48;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 44;
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
                c.a(k2, looper).setStrokeWidth(1.0f);
                canvas.saveLayerAlpha(null, 217, 4);
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-2928046);
                float[] a2 = c.a(g, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                a = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(10.666615f, 0.0f);
                l.lineTo(12.372898f, 0.0f);
                l.cubicTo(20.305622f, 0.02008788f, 25.773712f, 9.732577f, 21.51299f, 16.52228f);
                l.cubicTo(17.801077f, 23.834269f, 6.1564374f, 23.824224f, 2.4644783f, 16.502193f);
                l.cubicTo(-1.5567636f, 9.973632f, 3.2028701f, 0.87382275f, 10.666615f, 0.0f);
                l.lineTo(10.666615f, 0.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a = c.a(k, looper);
                a.setColor(-12537567);
                a2 = c.a(a2, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 21.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                a = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(6.1586027f, 2.1373188f);
                l.cubicTo(12.047705f, -1.0015799f, 20.032927f, 2.6871262f, 21.580063f, 9.154857f);
                l.cubicTo(23.476555f, 15.432654f, 18.695402f, 22.130304f, 12.34715f, 23.0f);
                l.lineTo(9.9216385f, 23.0f);
                l.cubicTo(4.6414104f, 22.400211f, 0.359335f, 17.991756f, 0.0f, 12.673622f);
                l.lineTo(0.0f, 10.884251f);
                l.cubicTo(0.61885476f, 7.2355304f, 2.7149756f, 3.7367578f, 6.1586027f, 2.1373188f);
                l.lineTo(6.1586027f, 2.1373188f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-2511616);
                g = c.a(a2, 1.0f, 0.0f, 25.0f, 0.0f, 1.0f, 21.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a3 = c.a(k, looper);
                l = c.l(looper);
                l.moveTo(1.0697373f, 12.9446945f);
                l.cubicTo(0.27009234f, 6.4077463f, 6.4773364f, 0.22063516f, 13.014434f, 1.0802338f);
                l.cubicTo(18.142157f, 1.4000845f, 22.220346f, 5.75805f, 23.0f, 10.70574f);
                l.lineTo(23.0f, 13.044648f);
                l.cubicTo(22.440248f, 18.152264f, 18.332073f, 22.260345f, 13.284314f, 23.0f);
                l.lineTo(11.015322f, 23.0f);
                l.cubicTo(5.8776026f, 22.440262f, 1.3795997f, 18.192245f, 1.0697373f, 12.9446945f);
                l.lineTo(1.0697373f, 12.9446945f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
