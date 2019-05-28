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

public final class ly extends c {
    private final int height = 48;
    private final int width = 66;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 66;
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
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-15683841);
                Path l = c.l(looper);
                l.moveTo(0.1875f, 2.88f);
                l.cubicTo(0.1875f, 1.2894199f, 1.4769199f, 0.0f, 3.0675f, 0.0f);
                l.lineTo(62.9325f, 0.0f);
                l.cubicTo(64.52308f, 0.0f, 65.8125f, 1.2894199f, 65.8125f, 2.88f);
                l.lineTo(65.8125f, 45.12f);
                l.cubicTo(65.8125f, 46.71058f, 64.52308f, 48.0f, 62.9325f, 48.0f);
                l.lineTo(3.0675f, 48.0f);
                l.cubicTo(1.4769199f, 48.0f, 0.1875f, 46.71058f, 0.1875f, 45.12f);
                l.lineTo(0.1875f, 2.88f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = c.a(k, looper);
                a.setColor(-1);
                l = c.l(looper);
                l.moveTo(14.4375f, 9.081081f);
                l.cubicTo(17.854763f, 9.081081f, 20.625f, 11.69477f, 20.625f, 14.918919f);
                l.cubicTo(20.625f, 18.143068f, 17.854763f, 20.756756f, 14.4375f, 20.756756f);
                l.cubicTo(11.020238f, 20.756756f, 8.25f, 18.143068f, 8.25f, 14.918919f);
                l.cubicTo(8.25f, 11.69477f, 11.020238f, 9.081081f, 14.4375f, 9.081081f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k2 = c.a(k, looper);
                k2.setColor(-1);
                Path l2 = c.l(looper);
                l2.moveTo(8.25f, 29.837837f);
                l2.lineTo(55.0f, 29.837837f);
                l2.lineTo(55.0f, 36.705883f);
                l2.lineTo(8.25f, 36.705883f);
                l2.lineTo(8.25f, 29.837837f);
                l2.close();
                canvas.drawPath(l2, k2);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
