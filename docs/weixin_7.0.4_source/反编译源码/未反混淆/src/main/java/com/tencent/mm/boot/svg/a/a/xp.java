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

public final class xp extends c {
    private final int height = 216;
    private final int width = 216;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 216;
            case 1:
                return 216;
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
                a.setColor(-5066062);
                Path l = c.l(looper);
                l.moveTo(0.0f, 40.0f);
                l.cubicTo(0.0f, 17.90861f, 17.90861f, 0.0f, 40.0f, 0.0f);
                l.lineTo(176.0f, 0.0f);
                l.cubicTo(198.09138f, 0.0f, 216.0f, 17.90861f, 216.0f, 40.0f);
                l.lineTo(216.0f, 176.0f);
                l.cubicTo(216.0f, 198.09138f, 198.09138f, 216.0f, 176.0f, 216.0f);
                l.lineTo(40.0f, 216.0f);
                l.cubicTo(17.90861f, 216.0f, 0.0f, 198.09138f, 0.0f, 176.0f);
                l.lineTo(0.0f, 40.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
