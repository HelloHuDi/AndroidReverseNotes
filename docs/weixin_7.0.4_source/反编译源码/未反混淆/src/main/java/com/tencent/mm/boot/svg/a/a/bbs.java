package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class bbs extends c {
    private final int height = 50;
    private final int width = 34;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 34;
            case 1:
                return 50;
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
                a.setColor(-3815995);
                g = c.a(g, 1.0f, 0.0f, -945.0f, 0.0f, 1.0f, -405.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(948.125f, 426.5625f);
                l.lineTo(948.125f, 432.50198f);
                l.cubicTo(948.125f, 440.09482f, 954.28107f, 446.25f, 961.875f, 446.25f);
                l.cubicTo(969.46893f, 446.25f, 975.625f, 440.09482f, 975.625f, 432.50198f);
                l.lineTo(975.625f, 426.5625f);
                l.lineTo(977.99774f, 426.5625f);
                l.cubicTo(978.41595f, 426.5625f, 978.75f, 426.89874f, 978.75f, 427.31354f);
                l.lineTo(978.75f, 432.3685f);
                l.cubicTo(978.75f, 440.96136f, 972.1874f, 448.0379f, 963.75f, 448.9606f);
                l.lineTo(963.75f, 451.875f);
                l.lineTo(971.42896f, 451.875f);
                l.cubicTo(971.84674f, 451.875f, 972.1875f, 452.21368f, 972.1875f, 452.63147f);
                l.lineTo(972.1875f, 454.24353f);
                l.cubicTo(972.1875f, 454.66556f, 971.8479f, 455.0f, 971.42896f, 455.0f);
                l.lineTo(952.32104f, 455.0f);
                l.cubicTo(951.90326f, 455.0f, 951.5625f, 454.66132f, 951.5625f, 454.24353f);
                l.lineTo(951.5625f, 452.63147f);
                l.cubicTo(951.5625f, 452.20944f, 951.9021f, 451.875f, 952.32104f, 451.875f);
                l.lineTo(960.0f, 451.875f);
                l.lineTo(960.0f, 448.9606f);
                l.cubicTo(951.5626f, 448.0379f, 945.0f, 440.96136f, 945.0f, 432.3685f);
                l.lineTo(945.0f, 427.30655f);
                l.cubicTo(945.0f, 426.89603f, 945.3368f, 426.5625f, 945.75226f, 426.5625f);
                l.lineTo(948.125f, 426.5625f);
                l.close();
                l.moveTo(961.875f, 405.0f);
                l.cubicTo(967.05383f, 405.0f, 971.25f, 409.20065f, 971.25f, 414.38242f);
                l.lineTo(971.25f, 431.86758f);
                l.cubicTo(971.25f, 437.05624f, 967.0527f, 441.25f, 961.875f, 441.25f);
                l.cubicTo(956.69617f, 441.25f, 952.5f, 437.04935f, 952.5f, 431.86758f);
                l.lineTo(952.5f, 414.38242f);
                l.cubicTo(952.5f, 409.19376f, 956.6973f, 405.0f, 961.875f, 405.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
