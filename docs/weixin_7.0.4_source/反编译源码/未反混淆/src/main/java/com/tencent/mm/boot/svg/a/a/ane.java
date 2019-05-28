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

public final class ane extends c {
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
                k.setColor(-1);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(68.0f, 71.0f);
                l.lineTo(22.0f, 71.0f);
                l.lineTo(22.0f, 37.0f);
                l.lineTo(31.521f, 37.0f);
                l.cubicTo(32.823f, 34.063f, 34.368f, 31.769f, 36.079f, 30.0f);
                l.lineTo(18.0f, 30.0f);
                l.cubicTo(16.343f, 30.0f, 15.0f, 31.343f, 15.0f, 33.0f);
                l.lineTo(15.0f, 75.0f);
                l.cubicTo(15.0f, 76.657f, 16.343f, 78.0f, 18.0f, 78.0f);
                l.lineTo(72.0f, 78.0f);
                l.cubicTo(73.656f, 78.0f, 75.0f, 76.657f, 75.0f, 75.0f);
                l.lineTo(75.0f, 53.22f);
                l.lineTo(68.0f, 59.13f);
                l.lineTo(68.0f, 71.0f);
                l.lineTo(68.0f, 71.0f);
                l.close();
                l.moveTo(60.0f, 19.0f);
                l.lineTo(60.0f, 30.019f);
                l.cubicTo(58.325f, 30.008f, 56.583f, 30.0f, 55.0f, 30.0f);
                l.cubicTo(41.334f, 30.0f, 32.055f, 43.333f, 32.055f, 61.0f);
                l.cubicTo(36.721f, 50.16f, 41.284f, 45.0f, 60.0f, 45.0f);
                l.lineTo(60.0f, 56.0f);
                l.lineTo(74.452f, 43.848f);
                l.lineTo(75.0f, 44.357f);
                l.lineTo(75.0f, 43.386f);
                l.lineTo(82.0f, 37.5f);
                l.lineTo(60.0f, 19.0f);
                l.lineTo(60.0f, 19.0f);
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
