package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class asf extends c {
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
                k = c.a(k2, looper);
                k.setStrokeWidth(1.0f);
                Path l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(72.0f, 0.0f);
                l.lineTo(72.0f, 72.0f);
                l.lineTo(0.0f, 72.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-1);
                a.setStrokeWidth(3.6f);
                Path l2 = c.l(looper);
                l2.moveTo(50.391575f, 17.210928f);
                l2.lineTo(37.490154f, 24.8f);
                l2.lineTo(21.0f, 24.8f);
                l2.cubicTo(20.337257f, 24.8f, 19.8f, 25.337257f, 19.8f, 26.0f);
                l2.lineTo(19.8f, 46.0f);
                l2.cubicTo(19.8f, 46.662743f, 20.337257f, 47.2f, 21.0f, 47.2f);
                l2.lineTo(37.490154f, 47.2f);
                l2.lineTo(50.391575f, 54.78907f);
                l2.cubicTo(50.57599f, 54.89755f, 50.78605f, 54.95475f, 51.0f, 54.95475f);
                l2.cubicTo(51.662743f, 54.95475f, 52.2f, 54.417492f, 52.2f, 53.75475f);
                l2.lineTo(52.2f, 18.24525f);
                l2.cubicTo(52.2f, 18.031298f, 52.1428f, 17.821238f, 52.03432f, 17.636826f);
                l2.cubicTo(51.6983f, 17.065586f, 50.962814f, 16.874905f, 50.391575f, 17.210928f);
                l2.close();
                canvas.drawPath(l2, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
