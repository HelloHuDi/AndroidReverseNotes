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

public final class ay extends c {
    private final int height = 45;
    private final int width = 45;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 45;
            case 1:
                return 45;
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
                k.setColor(-2631721);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(37.639984f, 18.956465f);
                l.cubicTo(40.8106f, 15.785851f, 40.782635f, 10.622878f, 37.579388f, 7.4196324f);
                l.cubicTo(34.376846f, 4.2170906f, 29.211271f, 4.1903195f, 26.042555f, 7.3590355f);
                l.lineTo(18.664976f, 14.736615f);
                l.cubicTo(15.494361f, 17.90723f, 15.522326f, 23.070202f, 18.725573f, 26.273449f);
                l.lineTo(20.365034f, 24.633986f);
                l.cubicTo(18.076956f, 22.345907f, 18.038301f, 18.67684f, 20.32175f, 16.39339f);
                l.lineTo(27.699331f, 9.015811f);
                l.cubicTo(29.981482f, 6.7336607f, 33.652905f, 6.7720737f, 35.939926f, 9.059094f);
                l.cubicTo(38.228004f, 11.347174f, 38.26666f, 15.01624f, 35.98321f, 17.29969f);
                l.lineTo(31.21839f, 22.06451f);
                l.lineTo(32.875164f, 23.721285f);
                l.lineTo(37.639984f, 18.956465f);
                l.close();
                l.moveTo(7.3600707f, 26.041521f);
                l.cubicTo(4.189456f, 29.212135f, 4.2174215f, 34.375107f, 7.4206676f, 37.578354f);
                l.cubicTo(10.62321f, 40.780895f, 15.788785f, 40.807667f, 18.9575f, 37.63895f);
                l.lineTo(26.335081f, 30.26137f);
                l.cubicTo(29.505695f, 27.090755f, 29.47773f, 21.927784f, 26.274483f, 18.724537f);
                l.lineTo(24.635021f, 20.364f);
                l.cubicTo(26.9231f, 22.652079f, 26.961754f, 26.321144f, 24.678305f, 28.604595f);
                l.lineTo(17.300724f, 35.982174f);
                l.cubicTo(15.018575f, 38.264324f, 11.347151f, 38.22591f, 9.06013f, 35.938892f);
                l.cubicTo(6.7720504f, 33.65081f, 6.7333965f, 29.981745f, 9.016847f, 27.698296f);
                l.lineTo(13.781667f, 22.933475f);
                l.lineTo(12.12489f, 21.2767f);
                l.lineTo(7.3600707f, 26.041521f);
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
