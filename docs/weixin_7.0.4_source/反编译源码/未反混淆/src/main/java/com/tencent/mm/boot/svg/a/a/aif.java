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

public final class aif extends c {
    private final int height = 108;
    private final int width = 108;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 108;
            case 1:
                return 108;
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
                a.setColor(-15683841);
                canvas.save();
                g = c.a(g, -1.0f, 0.0f, 90.0f, 0.0f, 1.0f, 21.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(11.396121f, 32.09012f);
                l.cubicTo(10.260603f, 31.398438f, 8.926831f, 31.0f, 7.5f, 31.0f);
                l.cubicTo(3.3578644f, 31.0f, 0.0f, 34.357864f, 0.0f, 38.5f);
                l.cubicTo(0.0f, 42.642136f, 3.3578644f, 46.0f, 7.5f, 46.0f);
                l.cubicTo(8.929695f, 46.0f, 10.265957f, 45.59996f, 11.402957f, 44.905712f);
                l.lineTo(11.401377f, 44.90862f);
                l.cubicTo(11.805888f, 44.684177f, 12.121924f, 44.571957f, 12.349486f, 44.571957f);
                l.cubicTo(12.684298f, 44.571957f, 12.890045f, 44.695858f, 13.0f, 44.99306f);
                l.lineTo(13.0f, 58.0f);
                l.cubicTo(13.0f, 61.31371f, 15.686292f, 64.0f, 19.0f, 64.0f);
                l.lineTo(58.0f, 64.0f);
                l.cubicTo(61.31371f, 64.0f, 64.0f, 61.31371f, 64.0f, 58.0f);
                l.lineTo(64.0f, 43.599068f);
                l.cubicTo(63.99934f, 43.599777f, 63.998684f, 43.60049f, 63.998024f, 43.6012f);
                l.cubicTo(63.997887f, 44.011288f, 63.997795f, 44.488285f, 63.997757f, 45.032185f);
                l.cubicTo(63.889458f, 44.72227f, 63.682262f, 44.593487f, 63.34092f, 44.593487f);
                l.cubicTo(63.124115f, 44.593487f, 62.815083f, 44.695347f, 62.41382f, 44.899067f);
                l.cubicTo(61.27447f, 45.59741f, 59.93425f, 46.0f, 58.5f, 46.0f);
                l.cubicTo(54.357864f, 46.0f, 51.0f, 42.642136f, 51.0f, 38.5f);
                l.cubicTo(51.0f, 34.357864f, 54.357864f, 31.0f, 58.5f, 31.0f);
                l.cubicTo(59.902565f, 31.0f, 61.215206f, 31.384998f, 62.338013f, 32.05508f);
                l.lineTo(62.336735f, 32.05282f);
                l.cubicTo(62.780434f, 32.27726f, 63.116066f, 32.38948f, 63.343628f, 32.38948f);
                l.cubicTo(63.68448f, 32.38948f, 63.89157f, 32.261066f, 64.0f, 31.952118f);
                l.lineTo(64.0f, 19.0f);
                l.cubicTo(64.0f, 15.686292f, 61.31371f, 13.0f, 58.0f, 13.0f);
                l.lineTo(44.985634f, 13.0f);
                l.cubicTo(44.683487f, 12.890678f, 44.557682f, 12.684352f, 44.557682f, 12.346982f);
                l.cubicTo(44.557682f, 12.121241f, 44.668118f, 11.815655f, 44.88898f, 11.430226f);
                l.cubicTo(45.593533f, 10.287346f, 46.0f, 8.941141f, 46.0f, 7.5f);
                l.cubicTo(46.0f, 3.3578644f, 42.642136f, 0.0f, 38.5f, 0.0f);
                l.cubicTo(34.357864f, 0.0f, 31.0f, 3.3578644f, 31.0f, 7.5f);
                l.cubicTo(31.0f, 8.92941f, 31.399878f, 10.265423f, 32.093872f, 11.402275f);
                l.lineTo(32.08055f, 11.395013f);
                l.cubicTo(32.304993f, 11.802097f, 32.417213f, 12.11942f, 32.417213f, 12.346982f);
                l.cubicTo(32.417213f, 12.684352f, 32.29141f, 12.890678f, 31.989262f, 13.0f);
                l.lineTo(19.0f, 13.0f);
                l.cubicTo(15.686292f, 13.0f, 13.0f, 15.686292f, 13.0f, 19.0f);
                l.lineTo(13.0f, 31.97362f);
                l.cubicTo(12.89148f, 32.281895f, 12.684464f, 32.41005f, 12.343956f, 32.41005f);
                l.cubicTo(12.122121f, 32.41005f, 11.806176f, 32.303406f, 11.396121f, 32.09012f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
