package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class adw extends c {
    private final int height = 75;
    private final int width = 75;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 75;
            case 1:
                return 75;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.h(looper);
                c.g(looper);
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
                k = c.a(k, looper);
                k.setColor(-15028967);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(4.0f, 60.0f);
                l.lineTo(4.0f, 71.990364f);
                l.cubicTo(4.0f, 73.65254f, 5.348283f, 75.0f, 7.0073853f, 75.0f);
                l.lineTo(66.992615f, 75.0f);
                l.cubicTo(68.65355f, 75.0f, 70.0f, 73.666405f, 70.0f, 71.990364f);
                l.lineTo(70.0f, 3.0096345f);
                l.cubicTo(70.0f, 1.3474593f, 68.65172f, 0.0f, 66.992615f, 0.0f);
                l.lineTo(7.0073853f, 0.0f);
                l.cubicTo(5.346452f, 0.0f, 4.0f, 1.3335965f, 4.0f, 3.0096345f);
                l.lineTo(4.0f, 15.0f);
                l.cubicTo(6.4852815f, 15.0f, 8.5f, 17.014719f, 8.5f, 19.5f);
                l.cubicTo(8.5f, 21.985281f, 6.4852815f, 24.0f, 4.0f, 24.0f);
                l.lineTo(4.0f, 51.0f);
                l.cubicTo(6.4852815f, 51.0f, 8.5f, 53.014717f, 8.5f, 55.5f);
                l.cubicTo(8.5f, 57.985283f, 6.4852815f, 60.0f, 4.0f, 60.0f);
                l.close();
                l.moveTo(35.16073f, 42.33927f);
                l.cubicTo(31.262531f, 38.441074f, 29.43414f, 34.747486f, 29.54121f, 33.381584f);
                l.cubicTo(29.648281f, 32.01568f, 31.987486f, 28.614197f, 31.95635f, 27.008419f);
                l.cubicTo(31.941387f, 26.23667f, 28.530704f, 21.19352f, 28.136374f, 20.583046f);
                l.cubicTo(27.742043f, 19.972572f, 27.281416f, 19.406528f, 26.698536f, 19.512964f);
                l.cubicTo(26.115658f, 19.6194f, 19.69526f, 21.835806f, 20.584337f, 27.494286f);
                l.cubicTo(21.473415f, 33.152767f, 27.573353f, 41.04148f, 31.963337f, 45.536663f);
                l.lineTo(35.16073f, 42.33927f);
                l.close();
                l.moveTo(35.16073f, 42.33927f);
                l.cubicTo(39.058926f, 46.23747f, 42.752514f, 48.06586f, 44.118416f, 47.95879f);
                l.cubicTo(45.48432f, 47.85172f, 48.885803f, 45.512516f, 50.49158f, 45.54365f);
                l.cubicTo(51.263332f, 45.558613f, 56.30648f, 48.969296f, 56.916954f, 49.363625f);
                l.cubicTo(57.527428f, 49.757957f, 58.09347f, 50.218586f, 57.987034f, 50.801464f);
                l.cubicTo(57.8806f, 51.384342f, 55.664196f, 57.80474f, 50.005714f, 56.915665f);
                l.cubicTo(44.347233f, 56.026585f, 36.45852f, 49.926647f, 31.963337f, 45.536663f);
                l.lineTo(35.16073f, 42.33927f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
