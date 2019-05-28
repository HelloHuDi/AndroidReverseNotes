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

public final class abt extends c {
    private final int height = 96;
    private final int width = 96;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                a.setColor(WebView.NIGHT_MODE_COLOR);
                g = c.a(g, 0.8660254f, -0.5f, 30.430782f, 0.5f, 0.8660254f, -17.569218f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l = c.l(looper);
                l.moveTo(68.0f, 82.641014f);
                l.cubicTo(48.868294f, 93.686714f, 24.404678f, 87.13171f, 13.358984f, 68.0f);
                l.cubicTo(2.313289f, 48.868294f, 8.868295f, 24.404678f, 28.0f, 13.358984f);
                l.cubicTo(47.131706f, 2.313289f, 71.59532f, 8.868295f, 82.641014f, 28.0f);
                l.cubicTo(93.686714f, 47.131706f, 87.13171f, 71.59532f, 68.0f, 82.641014f);
                l.close();
                l.moveTo(65.6f, 78.48409f);
                l.cubicTo(82.4359f, 68.763885f, 88.20431f, 47.2359f, 78.48409f, 30.4f);
                l.cubicTo(68.763885f, 13.564099f, 47.2359f, 7.7956944f, 30.4f, 17.515905f);
                l.cubicTo(13.564099f, 27.236118f, 7.7956944f, 48.7641f, 17.515905f, 65.6f);
                l.cubicTo(27.236118f, 82.4359f, 48.7641f, 88.20431f, 65.6f, 78.48409f);
                l.close();
                l.moveTo(48.0f, 30.8f);
                l.cubicTo(45.12812f, 30.8f, 42.8f, 33.12812f, 42.8f, 36.0f);
                l.lineTo(42.8f, 50.0f);
                l.cubicTo(42.8f, 52.87188f, 45.12812f, 55.2f, 48.0f, 55.2f);
                l.cubicTo(50.87188f, 55.2f, 53.2f, 52.87188f, 53.2f, 50.0f);
                l.lineTo(53.2f, 36.0f);
                l.cubicTo(53.2f, 33.12812f, 50.87188f, 30.8f, 48.0f, 30.8f);
                l.close();
                l.moveTo(50.400097f, 67.841354f);
                l.lineTo(50.400097f, 74.0f);
                l.lineTo(45.600098f, 74.0f);
                l.lineTo(45.600098f, 67.84136f);
                l.cubicTo(36.793587f, 66.667694f, 30.0f, 59.124485f, 30.0f, 49.990005f);
                l.lineTo(30.0f, 44.0f);
                l.lineTo(34.8f, 44.0f);
                l.lineTo(34.8f, 49.990005f);
                l.cubicTo(34.8f, 57.287613f, 40.7096f, 63.2f, 48.0f, 63.2f);
                l.cubicTo(55.2909f, 63.2f, 61.2f, 57.287125f, 61.2f, 49.990005f);
                l.lineTo(61.2f, 44.0f);
                l.lineTo(66.0f, 44.0f);
                l.lineTo(66.0f, 49.990005f);
                l.cubicTo(66.0f, 59.12258f, 59.208122f, 66.66752f, 50.400097f, 67.841354f);
                l.close();
                l.moveTo(48.0f, 26.0f);
                l.cubicTo(53.522846f, 26.0f, 58.0f, 30.477152f, 58.0f, 36.0f);
                l.lineTo(58.0f, 50.0f);
                l.cubicTo(58.0f, 55.522846f, 53.522846f, 60.0f, 48.0f, 60.0f);
                l.cubicTo(42.477154f, 60.0f, 38.0f, 55.522846f, 38.0f, 50.0f);
                l.lineTo(38.0f, 36.0f);
                l.cubicTo(38.0f, 30.477152f, 42.477154f, 26.0f, 48.0f, 26.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
