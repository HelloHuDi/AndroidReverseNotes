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

public final class qo extends c {
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
                k2 = c.a(k, looper);
                k2.setColor(-13786557);
                Path l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(192.0f, 0.0f);
                l.lineTo(192.0f, 192.0f);
                l.lineTo(0.0f, 192.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 42.666668f, 0.0f, 1.0f, 48.375f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-1);
                g = c.a(g, -1.0f, 0.0f, 106.5f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l2 = c.l(looper);
                l2.moveTo(88.101395f, 78.85144f);
                l2.cubicTo(99.326584f, 70.61707f, 106.5f, 58.437584f, 106.5f, 44.908268f);
                l2.cubicTo(106.5f, 20.105265f, 82.65881f, 0.0f, 53.25f, 0.0f);
                l2.cubicTo(23.841188f, 0.0f, 0.0f, 20.105265f, 0.0f, 44.908268f);
                l2.cubicTo(0.0f, 69.70905f, 23.841188f, 89.816536f, 53.25f, 89.816536f);
                l2.cubicTo(59.326565f, 89.816536f, 65.19253f, 88.93738f, 70.63073f, 87.35222f);
                l2.cubicTo(71.1265f, 87.201256f, 71.65299f, 87.11689f, 72.19703f, 87.11689f);
                l2.cubicTo(73.2193f, 87.11689f, 74.14943f, 87.432144f, 75.02472f, 87.94499f);
                l2.lineTo(86.67987f, 94.75627f);
                l2.cubicTo(87.00674f, 94.94498f, 87.32263f, 95.08929f, 87.708725f, 95.08929f);
                l2.cubicTo(88.68931f, 95.08929f, 89.48123f, 94.28561f, 89.48123f, 93.29544f);
                l2.cubicTo(89.48123f, 92.8492f, 89.30793f, 92.40518f, 89.19605f, 91.98114f);
                l2.cubicTo(89.12805f, 91.72805f, 87.69337f, 86.30656f, 86.79614f, 82.92311f);
                l2.cubicTo(86.69523f, 82.54126f, 86.60967f, 82.17494f, 86.60967f, 81.77754f);
                l2.cubicTo(86.60967f, 80.57202f, 87.19978f, 79.50193f, 88.101395f, 78.85144f);
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a);
                canvas.restore();
                canvas.save();
                Paint a2 = c.a(k, looper);
                a2.setColor(-13786557);
                Path l3 = c.l(looper);
                l3.moveTo(49.501553f, 52.715603f);
                l3.lineTo(49.501553f, 27.0f);
                l3.lineTo(57.24297f, 27.0f);
                l3.lineTo(57.24297f, 52.62429f);
                l3.lineTo(69.24226f, 40.625f);
                l3.lineTo(74.403206f, 45.785946f);
                l3.lineTo(53.348446f, 66.840706f);
                l3.lineTo(53.326603f, 66.81886f);
                l3.lineTo(53.30476f, 66.840706f);
                l3.lineTo(32.25f, 45.785946f);
                l3.lineTo(37.410946f, 40.625f);
                l3.close();
                WeChatSVGRenderC2Java.setFillType(l3, 1);
                WeChatSVGRenderC2Java.setFillType(l3, 1);
                canvas.drawPath(l3, a2);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
