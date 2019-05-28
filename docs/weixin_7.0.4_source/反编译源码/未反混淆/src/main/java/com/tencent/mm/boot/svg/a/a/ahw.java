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

public final class ahw extends c {
    private final int height = 72;
    private final int width = 72;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                g = c.a(g, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 10.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-16726153);
                Path l = c.l(looper);
                l.moveTo(54.0f, 3.0685034f);
                l.cubicTo(54.0f, 1.6369854f, 52.866337f, 0.657453f, 51.467896f, 0.85168105f);
                l.lineTo(2.5321038f, 7.648319f);
                l.cubicTo(1.1278667f, 7.843352f, 0.0f, 9.149959f, 0.0f, 10.568503f);
                l.lineTo(3.6f, 11.134557f);
                l.lineTo(50.4f, 4.6345563f);
                l.lineTo(50.4f, 14.487597f);
                l.lineTo(54.0f, 14.961282f);
                l.lineTo(54.0f, 3.0685034f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = c.a(k, looper);
                a.setColor(-15365900);
                l = c.l(looper);
                l.moveTo(3.6f, 11.738222f);
                l.lineTo(3.6f, 41.976162f);
                l.lineTo(53.4f, 48.528793f);
                l.lineTo(53.4f, 18.290854f);
                l.lineTo(3.6f, 11.738222f);
                l.close();
                l.moveTo(0.0f, 10.638901f);
                l.cubicTo(0.0f, 8.979069f, 1.3527762f, 7.8115053f, 2.9843135f, 8.026181f);
                l.lineTo(54.477234f, 14.801565f);
                l.cubicTo(55.870518f, 14.984893f, 57.0f, 16.29693f, 57.0f, 17.711035f);
                l.lineTo(57.0f, 49.628117f);
                l.cubicTo(57.0f, 51.28795f, 55.647224f, 52.455513f, 54.015686f, 52.240837f);
                l.lineTo(2.522766f, 45.46545f);
                l.cubicTo(1.129481f, 45.282124f, 0.0f, 43.970085f, 0.0f, 42.55598f);
                l.lineTo(0.0f, 10.638901f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
