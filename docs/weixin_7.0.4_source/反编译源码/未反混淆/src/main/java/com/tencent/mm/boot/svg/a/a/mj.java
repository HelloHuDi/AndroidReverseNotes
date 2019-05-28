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

public final class mj extends c {
    private final int height = 48;
    private final int width = 48;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                canvas.saveLayerAlpha(null, 76, 4);
                k = c.a(k, looper);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(37.233665f, 33.873493f);
                l.lineTo(44.40146f, 41.041286f);
                l.lineTo(42.72137f, 42.72137f);
                l.lineTo(9.600087f, 9.600086f);
                l.lineTo(11.280172f, 7.92f);
                l.lineTo(15.06498f, 11.704807f);
                l.cubicTo(16.369446f, 10.304305f, 18.008224f, 9.2193365f, 19.854246f, 8.57697f);
                l.cubicTo(19.818567f, 8.363288f, 19.8f, 8.143812f, 19.8f, 7.92f);
                l.cubicTo(19.8f, 5.7329526f, 21.572952f, 3.96f, 23.76f, 3.96f);
                l.cubicTo(25.947048f, 3.96f, 27.72f, 5.7329526f, 27.72f, 7.92f);
                l.cubicTo(27.72f, 8.143812f, 27.701433f, 8.363288f, 27.665754f, 8.57697f);
                l.cubicTo(32.30823f, 10.192428f, 35.64f, 14.607125f, 35.64f, 19.8f);
                l.lineTo(35.64f, 27.72f);
                l.cubicTo(35.64f, 29.771164f, 36.171223f, 31.822327f, 37.233665f, 33.873493f);
                l.close();
                l.moveTo(36.239826f, 39.6f);
                l.lineTo(5.94f, 39.6f);
                l.cubicTo(9.9f, 35.64f, 11.88f, 31.68f, 11.88f, 27.72f);
                l.lineTo(11.88f, 19.8f);
                l.cubicTo(11.88f, 18.432533f, 12.111043f, 17.11903f, 12.536222f, 15.896395f);
                l.lineTo(36.239826f, 39.6f);
                l.close();
                l.moveTo(21.78f, 41.58f);
                l.lineTo(25.74f, 41.58f);
                l.lineTo(25.74f, 41.976f);
                l.cubicTo(25.74f, 43.069523f, 24.853523f, 43.956f, 23.76f, 43.956f);
                l.cubicTo(22.666475f, 43.956f, 21.78f, 43.069523f, 21.78f, 41.976f);
                l.lineTo(21.78f, 41.58f);
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
