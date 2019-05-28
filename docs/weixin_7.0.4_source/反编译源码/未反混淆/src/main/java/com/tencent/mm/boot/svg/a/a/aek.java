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

public final class aek extends c {
    private final int height = 120;
    private final int width = 120;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                g = c.a(g, 1.0f, 0.0f, -180.0f, 0.0f, 1.0f, -98.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 180.0f, 0.0f, 1.0f, 98.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Paint a = c.a(k, looper);
                a.setColor(-3552823);
                canvas.save();
                a = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(120.0f, 0.0f);
                l.lineTo(120.0f, 120.0f);
                l.lineTo(0.0f, 120.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                Paint a2 = c.a(k, looper);
                a2.setColor(-1);
                Path l2 = c.l(looper);
                l2.moveTo(84.01563f, 54.268833f);
                l2.cubicTo(89.06397f, 49.220486f, 89.01945f, 40.99985f, 83.91914f, 35.89955f);
                l2.cubicTo(78.81996f, 30.80037f, 70.595184f, 30.757744f, 65.549866f, 35.803066f);
                l2.lineTo(53.803066f, 47.549866f);
                l2.cubicTo(48.75472f, 52.59821f, 48.799248f, 60.818844f, 53.89955f, 65.91914f);
                l2.lineTo(56.50995f, 63.308746f);
                l2.cubicTo(52.866802f, 59.6656f, 52.805256f, 53.823605f, 56.441032f, 50.18783f);
                l2.lineTo(68.18783f, 38.441032f);
                l2.cubicTo(71.82153f, 34.807327f, 77.66728f, 34.86849f, 81.30875f, 38.50995f);
                l2.cubicTo(84.9519f, 42.153095f, 85.01344f, 47.99509f, 81.37766f, 51.630867f);
                l2.lineTo(75.504265f, 57.504265f);
                l2.lineTo(78.142235f, 60.14223f);
                l2.lineTo(84.01563f, 54.268833f);
                l2.close();
                l2.moveTo(35.803066f, 65.549866f);
                l2.cubicTo(30.75472f, 70.598206f, 30.799248f, 78.81885f, 35.89955f, 83.91914f);
                l2.cubicTo(40.99873f, 89.018326f, 49.22351f, 89.06095f, 54.268833f, 84.01563f);
                l2.lineTo(66.01563f, 72.26883f);
                l2.cubicTo(71.06397f, 67.22049f, 71.01945f, 58.99985f, 65.91914f, 53.89955f);
                l2.lineTo(63.308746f, 56.50995f);
                l2.cubicTo(66.9519f, 60.153095f, 67.01344f, 65.99509f, 63.377663f, 69.63087f);
                l2.lineTo(51.630867f, 81.37766f);
                l2.cubicTo(47.997158f, 85.01137f, 42.151413f, 84.95021f, 38.50995f, 81.30875f);
                l2.cubicTo(34.866802f, 77.665596f, 34.805256f, 71.82361f, 38.441032f, 68.18783f);
                l2.lineTo(44.31443f, 62.31443f);
                l2.lineTo(41.676464f, 59.676464f);
                l2.lineTo(35.803066f, 65.549866f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
