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

public final class afr extends c {
    private final int height = 210;
    private final int width = 210;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 210;
            case 1:
                return 210;
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
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-3026479);
                g = c.a(g, 1.0f, 0.0f, 16.0f, 0.0f, 1.0f, 48.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(29.022663f, 6.881502f);
                l.cubicTo(28.962679f, 3.3246841f, 32.48179f, 0.6071154f, 35.910923f, 1.046722f);
                l.lineTo(171.01677f, 1.046722f);
                l.cubicTo(174.47589f, 0.6071154f, 178.005f, 3.3646483f, 177.90503f, 6.941448f);
                l.cubicTo(177.99501f, 40.29161f, 177.92502f, 73.651764f, 177.94502f, 107.01192f);
                l.cubicTo(178.48488f, 110.91843f, 174.96577f, 114.48524f, 171.04677f, 113.94572f);
                l.lineTo(35.900925f, 113.94572f);
                l.cubicTo(32.4418f, 114.38532f, 28.92269f, 111.60781f, 29.012667f, 108.041f);
                l.cubicTo(28.932686f, 97.59035f, 29.002668f, 87.14969f, 28.992672f, 76.69904f);
                l.cubicTo(19.335112f, 70.45463f, 9.657558f, 64.24019f, 0.0f, 57.995773f);
                l.cubicTo(9.647561f, 51.16189f, 19.265131f, 44.288036f, 28.95268f, 37.504105f);
                l.cubicTo(29.062653f, 27.293242f, 28.902695f, 17.092367f, 29.022663f, 6.881502f);
                l.lineTo(29.022663f, 6.881502f);
                l.close();
                l.moveTo(63.374653f, 45.406013f);
                l.cubicTo(56.590252f, 46.86757f, 51.75968f, 54.195107f, 53.28151f, 61.058495f);
                l.cubicTo(54.43024f, 67.90214f, 61.469917f, 72.93858f, 68.27395f, 71.85229f);
                l.cubicTo(75.66708f, 71.09189f, 81.342026f, 63.319958f, 79.722015f, 55.992424f);
                l.cubicTo(78.51437f, 48.635265f, 70.53214f, 43.480316f, 63.374653f, 45.406013f);
                l.lineTo(63.374653f, 45.406013f);
                l.close();
                l.moveTo(100.24062f, 45.43193f);
                l.cubicTo(93.876f, 46.893433f, 89.20076f, 53.509697f, 90.1142f, 60.046963f);
                l.cubicTo(90.76244f, 67.24585f, 97.94228f, 72.914116f, 105.063194f, 71.877235f);
                l.cubicTo(112.50823f, 71.22549f, 118.313f, 63.473595f, 116.741486f, 56.08708f);
                l.cubicTo(115.5825f, 48.64131f, 107.459755f, 43.427303f, 100.24062f, 45.43193f);
                l.lineTo(100.24062f, 45.43193f);
                l.close();
                l.moveTo(136.14615f, 45.755013f);
                l.cubicTo(129.64459f, 47.81871f, 125.55901f, 55.32308f, 127.47412f, 61.938766f);
                l.cubicTo(129.1437f, 68.89018f, 136.88274f, 73.471794f, 143.74768f, 71.56608f);
                l.cubicTo(150.77959f, 70.01583f, 155.54282f, 62.146126f, 153.5393f, 55.155216f);
                l.cubicTo(151.84026f, 47.73972f, 143.23698f, 43.09886f, 136.14615f, 45.755013f);
                l.lineTo(136.14615f, 45.755013f);
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
