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

public final class iz extends c {
    private final int height = 144;
    private final int width = 144;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-9276814);
                Path l = c.l(looper);
                l.moveTo(8.0f, 32.0f);
                l.cubicTo(8.0f, 28.68629f, 10.686291f, 26.0f, 14.0f, 26.0f);
                l.lineTo(130.0f, 26.0f);
                l.cubicTo(133.3137f, 26.0f, 136.0f, 28.68629f, 136.0f, 32.0f);
                l.lineTo(136.0f, 112.0f);
                l.cubicTo(136.0f, 115.313705f, 133.3137f, 118.0f, 130.0f, 118.0f);
                l.lineTo(14.0f, 118.0f);
                l.cubicTo(10.686291f, 118.0f, 8.0f, 115.313705f, 8.0f, 112.0f);
                l.lineTo(8.0f, 32.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-1);
                l = c.l(looper);
                l.moveTo(71.88509f, 65.0309f);
                l.lineTo(27.494259f, 39.401836f);
                l.cubicTo(26.058262f, 38.57276f, 24.230272f, 39.068474f, 23.401754f, 40.50351f);
                l.lineTo(21.402084f, 43.967037f);
                l.cubicTo(20.576242f, 45.39744f, 21.06255f, 47.23549f, 22.494259f, 48.062088f);
                l.lineTo(70.312874f, 75.67018f);
                l.cubicTo(70.809265f, 75.95677f, 71.3525f, 76.08506f, 71.88509f, 76.07097f);
                l.cubicTo(72.417694f, 76.08506f, 72.96093f, 75.95677f, 73.45732f, 75.67018f);
                l.lineTo(121.27593f, 48.062088f);
                l.cubicTo(122.70764f, 47.23549f, 123.19395f, 45.39744f, 122.36811f, 43.967037f);
                l.lineTo(120.36844f, 40.50351f);
                l.cubicTo(119.53992f, 39.068474f, 117.71193f, 38.57276f, 116.27593f, 39.401836f);
                l.lineTo(71.88509f, 65.0309f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
