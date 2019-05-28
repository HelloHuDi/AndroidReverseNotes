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

public final class abl extends c {
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
                k.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(57.7577f, 21.974848f);
                l.lineTo(36.774937f, 9.734903f);
                l.cubicTo(36.466652f, 9.555071f, 35.53348f, 9.554993f, 35.225063f, 9.734903f);
                l.lineTo(14.2423f, 21.974848f);
                l.lineTo(36.0f, 34.536663f);
                l.lineTo(57.7577f, 21.974848f);
                l.close();
                l.moveTo(59.4f, 25.183588f);
                l.lineTo(37.8f, 37.654354f);
                l.lineTo(37.8f, 62.89739f);
                l.lineTo(58.59719f, 50.765697f);
                l.cubicTo(58.920998f, 50.57681f, 59.4f, 49.743988f, 59.4f, 49.37328f);
                l.lineTo(59.4f, 25.183588f);
                l.close();
                l.moveTo(12.6f, 25.183588f);
                l.lineTo(12.6f, 49.37328f);
                l.cubicTo(12.6f, 49.73662f, 13.083672f, 50.579533f, 13.402809f, 50.765697f);
                l.lineTo(34.2f, 62.89739f);
                l.lineTo(34.2f, 37.654354f);
                l.lineTo(12.6f, 25.183588f);
                l.close();
                l.moveTo(33.411125f, 6.6252995f);
                l.cubicTo(34.840923f, 5.791252f, 37.160156f, 5.791881f, 38.588875f, 6.6252995f);
                l.lineTo(60.411125f, 19.354948f);
                l.cubicTo(61.840923f, 20.188995f, 63.0f, 22.21864f, 63.0f, 23.856966f);
                l.lineTo(63.0f, 49.37328f);
                l.cubicTo(63.0f, 51.02563f, 61.839844f, 53.04188f, 60.411125f, 53.8753f);
                l.lineTo(38.588875f, 66.60495f);
                l.cubicTo(37.159077f, 67.438995f, 34.839844f, 67.43836f, 33.411125f, 66.60495f);
                l.lineTo(11.588874f, 53.8753f);
                l.cubicTo(10.159078f, 53.041252f, 9.0f, 51.01161f, 9.0f, 49.37328f);
                l.lineTo(9.0f, 23.856966f);
                l.cubicTo(9.0f, 22.204617f, 10.160156f, 20.188366f, 11.588874f, 19.354948f);
                l.lineTo(33.411125f, 6.6252995f);
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
