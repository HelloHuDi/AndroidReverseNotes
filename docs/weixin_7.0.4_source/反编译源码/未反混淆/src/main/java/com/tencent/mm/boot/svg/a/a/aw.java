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

public final class aw extends c {
    private final int height = 48;
    private final int width = 48;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                k2 = c.a(k, looper);
                k2.setColor(-9342607);
                canvas.save();
                Paint a = c.a(k2, looper);
                Path l = c.l(looper);
                l.moveTo(22.7f, 0.0f);
                l.lineTo(25.07f, 0.0f);
                l.cubicTo(37.02f, 0.35f, 47.45f, 10.65f, 48.0f, 22.58f);
                l.lineTo(48.0f, 25.35f);
                l.cubicTo(47.49f, 37.13f, 37.36f, 47.34f, 25.6f, 48.0f);
                l.lineTo(22.6f, 48.0f);
                l.cubicTo(10.77f, 47.46f, 0.55f, 37.22f, 0.0f, 25.4f);
                l.lineTo(0.0f, 22.73f);
                l.cubicTo(0.46f, 10.81f, 10.8f, 0.49f, 22.7f, 0.0f);
                l.lineTo(22.7f, 0.0f);
                l.close();
                l.moveTo(22.0f, 12.0f);
                l.cubicTo(22.171429f, 17.652987f, 22.37143f, 23.305975f, 22.571428f, 28.958961f);
                l.cubicTo(23.514286f, 28.97948f, 24.457144f, 28.98974f, 25.409523f, 29.0f);
                l.cubicTo(25.52381f, 23.326494f, 25.77143f, 17.663246f, 26.0f, 12.0f);
                l.cubicTo(24.666666f, 12.01026f, 23.333334f, 12.01026f, 22.0f, 12.0f);
                l.lineTo(22.0f, 12.0f);
                l.close();
                l.moveTo(23.251102f, 31.157341f);
                l.cubicTo(22.210506f, 31.45582f, 21.597021f, 33.081738f, 22.303694f, 33.977173f);
                l.cubicTo(22.948242f, 35.658073f, 25.883654f, 35.14752f, 25.953545f, 33.31738f);
                l.cubicTo(26.302998f, 31.817135f, 24.610088f, 30.544678f, 23.251102f, 31.157341f);
                l.lineTo(23.251102f, 31.157341f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-1);
                float[] a2 = c.a(g, 1.0f, 0.0f, 22.0f, 0.0f, 1.0f, 12.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                Paint a3 = c.a(k, looper);
                l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.cubicTo(1.3333334f, 0.010259505f, 2.6666667f, 0.010259505f, 4.0f, 0.0f);
                l.cubicTo(3.7714286f, 5.6632466f, 3.5238094f, 11.326493f, 3.4095237f, 17.0f);
                l.cubicTo(2.4571428f, 16.98974f, 1.5142857f, 16.97948f, 0.5714286f, 16.958961f);
                l.cubicTo(0.37142858f, 11.305975f, 0.17142858f, 5.6529875f, 0.0f, 0.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
