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

public final class asp extends c {
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
                Paint a = c.a(k, looper);
                a.setColor(-3750202);
                canvas.save();
                float[] a2 = c.a(g, 1.0f, 0.0f, 13.0f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(9.666615f, 0.0f);
                l.lineTo(11.372898f, 0.0f);
                l.cubicTo(19.305622f, 0.02008788f, 24.773712f, 9.732577f, 20.51299f, 16.52228f);
                l.cubicTo(16.801077f, 23.834269f, 5.1564374f, 23.824224f, 1.4644784f, 16.502193f);
                l.cubicTo(-2.5567636f, 9.973632f, 2.2028701f, 0.87382275f, 9.666615f, 0.0f);
                l.lineTo(9.666615f, 0.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a2 = c.a(a2, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 22.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                a3 = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(6.1586027f, 1.137319f);
                l.cubicTo(12.047705f, -2.00158f, 20.032927f, 1.687126f, 21.580063f, 8.154857f);
                l.cubicTo(23.476555f, 14.432654f, 18.695402f, 21.130304f, 12.34715f, 22.0f);
                l.lineTo(9.9216385f, 22.0f);
                l.cubicTo(4.6414104f, 21.400211f, 0.359335f, 16.991756f, 0.0f, 11.673622f);
                l.lineTo(0.0f, 9.884251f);
                l.cubicTo(0.61885476f, 6.2355304f, 2.7149756f, 2.7367578f, 6.1586027f, 1.137319f);
                l.lineTo(6.1586027f, 1.137319f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.restore();
                canvas.save();
                g = c.a(a2, 1.0f, 0.0f, 26.0f, 0.0f, 1.0f, 22.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a4 = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(0.069737285f, 11.9446945f);
                l.cubicTo(-0.7299077f, 5.4077463f, 5.4773364f, -0.7793648f, 12.014434f, 0.080233835f);
                l.cubicTo(17.142157f, 0.4000845f, 21.220346f, 4.75805f, 22.0f, 9.70574f);
                l.lineTo(22.0f, 12.044648f);
                l.cubicTo(21.440248f, 17.152264f, 17.332073f, 21.260345f, 12.284314f, 22.0f);
                l.lineTo(10.015322f, 22.0f);
                l.cubicTo(4.8776026f, 21.440262f, 0.3795997f, 17.192245f, 0.069737285f, 11.9446945f);
                l.lineTo(0.069737285f, 11.9446945f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
