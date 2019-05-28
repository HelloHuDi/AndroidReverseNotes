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

public final class gt extends c {
    private final int height = 66;
    private final int width = 66;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 66;
            case 1:
                return 66;
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
                a.setColor(-372399);
                Path l = c.l(looper);
                l.moveTo(33.0f, 0.0f);
                l.cubicTo(51.225395f, 0.0f, 66.0f, 14.774603f, 66.0f, 33.0f);
                l.cubicTo(66.0f, 51.225395f, 51.225395f, 66.0f, 33.0f, 66.0f);
                l.cubicTo(14.774603f, 66.0f, 0.0f, 51.225395f, 0.0f, 33.0f);
                l.cubicTo(0.0f, 14.774603f, 14.774603f, 0.0f, 33.0f, 0.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k2 = c.a(k, looper);
                k2.setColor(-1);
                Path l2 = c.l(looper);
                l2.moveTo(40.0f, 18.0f);
                l2.lineTo(44.0f, 18.0f);
                l2.lineTo(44.0f, 48.0f);
                l2.lineTo(40.0f, 48.0f);
                l2.lineTo(40.0f, 18.0f);
                l2.close();
                canvas.drawPath(l2, k2);
                canvas.restore();
                canvas.save();
                k2 = c.a(k, looper);
                k2.setColor(-1);
                l2 = c.l(looper);
                l2.moveTo(22.0f, 18.0f);
                l2.lineTo(26.0f, 18.0f);
                l2.lineTo(26.0f, 48.0f);
                l2.lineTo(22.0f, 48.0f);
                l2.lineTo(22.0f, 18.0f);
                l2.close();
                canvas.drawPath(l2, k2);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(419430400);
                l = c.l(looper);
                l.moveTo(33.0f, 0.0f);
                l.cubicTo(51.225395f, 0.0f, 66.0f, 14.774603f, 66.0f, 33.0f);
                l.cubicTo(66.0f, 51.225395f, 51.225395f, 66.0f, 33.0f, 66.0f);
                l.cubicTo(14.774603f, 66.0f, 0.0f, 51.225395f, 0.0f, 33.0f);
                l.cubicTo(0.0f, 14.774603f, 14.774603f, 0.0f, 33.0f, 0.0f);
                l.close();
                canvas.drawPath(l, k);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
