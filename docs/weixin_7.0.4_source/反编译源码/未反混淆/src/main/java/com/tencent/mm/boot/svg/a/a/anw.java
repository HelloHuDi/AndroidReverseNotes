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

public final class anw extends c {
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
                g = c.a(g, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 12.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(28.1486f, 46.8514f);
                l.cubicTo(35.63314f, 54.33594f, 42.724827f, 57.84645f, 45.347363f, 57.640877f);
                l.cubicTo(47.9699f, 57.435303f, 54.500744f, 52.944027f, 57.583836f, 53.003807f);
                l.cubicTo(59.065594f, 53.03254f, 68.74844f, 59.581047f, 69.92055f, 60.33816f);
                l.cubicTo(71.09266f, 61.095276f, 72.17947f, 61.979683f, 71.975105f, 63.09881f);
                l.cubicTo(71.77075f, 64.21793f, 67.51525f, 76.545105f, 56.65097f, 74.83807f);
                l.cubicTo(45.786686f, 73.13104f, 30.640358f, 61.419163f, 22.009607f, 52.99039f);
                l.lineTo(28.1486f, 46.8514f);
                l.lineTo(28.1486f, 46.8514f);
                l.close();
                l.moveTo(28.1486f, 46.8514f);
                l.cubicTo(20.66406f, 39.36686f, 17.15355f, 32.275173f, 17.359123f, 29.65264f);
                l.cubicTo(17.564697f, 27.030104f, 22.055973f, 20.499258f, 21.996193f, 17.416164f);
                l.cubicTo(21.967463f, 15.934404f, 15.418953f, 6.251558f, 14.661838f, 5.0794487f);
                l.cubicTo(13.904722f, 3.9073398f, 13.020318f, 2.8205357f, 11.901191f, 3.0248914f);
                l.cubicTo(10.782063f, 3.2292473f, -1.5451031f, 7.484747f, 0.16192652f, 18.34903f);
                l.cubicTo(1.8689562f, 29.213312f, 13.580837f, 44.359642f, 22.009607f, 52.99039f);
                l.lineTo(28.1486f, 46.8514f);
                l.lineTo(28.1486f, 46.8514f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(36.0f, 2.5528953f);
                l.cubicTo(36.0f, 1.9161688f, 36.537994f, 1.4f, 37.198494f, 1.4f);
                l.lineTo(60.001503f, 1.4f);
                l.cubicTo(60.663414f, 1.4f, 61.2f, 1.9141779f, 61.2f, 2.5528953f);
                l.lineTo(61.2f, 19.847105f);
                l.cubicTo(61.2f, 20.483831f, 60.662003f, 21.0f, 60.001503f, 21.0f);
                l.lineTo(37.198494f, 21.0f);
                l.cubicTo(36.536583f, 21.0f, 36.0f, 20.485823f, 36.0f, 19.847105f);
                l.lineTo(36.0f, 2.5528953f);
                l.close();
                l.moveTo(71.9625f, 22.315844f);
                l.cubicTo(71.603096f, 21.929012f, 67.161896f, 17.713648f, 64.0f, 14.820552f);
                l.lineTo(64.0f, 7.4903607f);
                l.cubicTo(67.086624f, 4.6363034f, 71.430885f, 0.5419411f, 71.9625f, 0.07080274f);
                l.cubicTo(72.85872f, -0.1871373f, 73.8f, 0.26488438f, 73.8f, 1.3419479f);
                l.lineTo(73.8f, 21.044699f);
                l.cubicTo(73.8f, 22.006937f, 72.94881f, 22.635838f, 71.9625f, 22.315844f);
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
