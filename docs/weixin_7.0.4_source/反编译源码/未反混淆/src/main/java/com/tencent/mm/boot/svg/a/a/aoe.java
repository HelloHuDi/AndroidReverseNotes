package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class aoe extends c {
    private final int height = az.CTRL_INDEX;
    private final int width = az.CTRL_INDEX;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return az.CTRL_INDEX;
            case 1:
                return az.CTRL_INDEX;
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
                a.setColor(-13421773);
                g = c.a(g, 1.0f, 0.0f, 48.0f, 0.0f, 1.0f, 48.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 15.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(28.1486f, 43.8514f);
                l.cubicTo(35.63314f, 51.33594f, 42.724827f, 54.84645f, 45.347363f, 54.640877f);
                l.cubicTo(47.9699f, 54.435303f, 54.500744f, 49.944027f, 57.583836f, 50.003807f);
                l.cubicTo(59.065594f, 50.03254f, 68.74844f, 56.581047f, 69.92055f, 57.33816f);
                l.cubicTo(71.09266f, 58.095276f, 72.17947f, 58.979683f, 71.975105f, 60.09881f);
                l.cubicTo(71.77075f, 61.217937f, 67.51525f, 73.545105f, 56.65097f, 71.83807f);
                l.cubicTo(45.786686f, 70.13104f, 30.640358f, 58.419163f, 22.009607f, 49.99039f);
                l.lineTo(28.1486f, 43.8514f);
                l.lineTo(28.1486f, 43.8514f);
                l.close();
                l.moveTo(28.1486f, 43.8514f);
                l.cubicTo(20.66406f, 36.36686f, 17.15355f, 29.275175f, 17.359123f, 26.65264f);
                l.cubicTo(17.564697f, 24.030104f, 22.055973f, 17.499258f, 21.996193f, 14.416165f);
                l.cubicTo(21.967463f, 12.934404f, 15.418953f, 3.2515578f, 14.661838f, 2.079449f);
                l.cubicTo(13.904722f, 0.9073399f, 13.020318f, -0.17946438f, 11.901191f, 0.024891442f);
                l.cubicTo(10.782063f, 0.22924727f, -1.5451031f, 4.484747f, 0.16192652f, 15.34903f);
                l.cubicTo(1.8689562f, 26.213312f, 13.580837f, 41.359642f, 22.009607f, 49.99039f);
                l.lineTo(28.1486f, 43.8514f);
                l.lineTo(28.1486f, 43.8514f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
