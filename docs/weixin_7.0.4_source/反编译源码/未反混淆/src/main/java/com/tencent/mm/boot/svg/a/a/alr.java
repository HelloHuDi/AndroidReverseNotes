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

public final class alr extends c {
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
                Paint a = c.a(k2, looper);
                a.setStrokeWidth(1.0f);
                k2 = c.a(k, looper);
                k2.setColor(-855638017);
                canvas.save();
                Paint a2 = c.a(k2, looper);
                Path l = c.l(looper);
                l.moveTo(0.0f, 28.8f);
                l.cubicTo(0.0f, 12.894198f, 12.894198f, 0.0f, 28.8f, 0.0f);
                l.lineTo(115.2f, 0.0f);
                l.cubicTo(131.1058f, 0.0f, 144.0f, 12.894198f, 144.0f, 28.8f);
                l.lineTo(144.0f, 115.2f);
                l.cubicTo(144.0f, 131.1058f, 131.1058f, 144.0f, 115.2f, 144.0f);
                l.lineTo(28.8f, 144.0f);
                l.cubicTo(12.894198f, 144.0f, 0.0f, 131.1058f, 0.0f, 115.2f);
                l.lineTo(0.0f, 28.8f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-14477034);
                l = c.l(looper);
                l.moveTo(94.2f, 67.7346f);
                l.lineTo(94.2f, 89.8806f);
                l.cubicTo(94.2f, 92.2656f, 92.265f, 94.2006f, 89.88f, 94.2006f);
                l.lineTo(55.32f, 94.2006f);
                l.cubicTo(52.935f, 94.2006f, 51.0f, 92.2656f, 51.0f, 89.8806f);
                l.lineTo(51.0f, 55.3206f);
                l.cubicTo(51.0f, 52.9326f, 52.935f, 51.0006f, 55.32f, 51.0006f);
                l.lineTo(89.88f, 51.0006f);
                l.cubicTo(90.219f, 51.0006f, 90.552f, 51.0396f, 90.867f, 51.1146f);
                l.lineTo(87.6f, 54.6006f);
                l.lineTo(55.32f, 54.6006f);
                l.cubicTo(54.921f, 54.6006f, 54.6f, 54.9216f, 54.6f, 55.3206f);
                l.lineTo(54.6f, 89.8806f);
                l.cubicTo(54.6f, 90.2766f, 54.921f, 90.6006f, 55.32f, 90.6006f);
                l.lineTo(89.88f, 90.6006f);
                l.cubicTo(90.279f, 90.6006f, 90.6f, 90.2766f, 90.6f, 89.8806f);
                l.lineTo(90.6f, 71.5746f);
                l.lineTo(94.2f, 67.7346f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.restore();
                canvas.save();
                k2 = c.a(a, looper);
                k2.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(3.6f);
                k2.setStrokeCap(Cap.SQUARE);
                k2.setStrokeJoin(Join.MITER);
                Path l2 = c.l(looper);
                l2.moveTo(63.648f, 67.40708f);
                l2.lineTo(73.50063f, 78.48f);
                l2.lineTo(96.0f, 54.48867f);
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                canvas.drawPath(l2, k2);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
