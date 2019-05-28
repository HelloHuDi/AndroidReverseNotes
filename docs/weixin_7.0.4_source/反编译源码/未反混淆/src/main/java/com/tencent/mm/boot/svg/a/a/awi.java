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

public final class awi extends c {
    private final int height = 72;
    private final int width = 210;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 210;
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
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-11286451);
                Path l = c.l(looper);
                l.moveTo(0.0f, 12.0f);
                l.cubicTo(0.0f, 5.3725824f, 5.3725824f, 0.0f, 12.0f, 0.0f);
                l.lineTo(198.0f, 0.0f);
                l.cubicTo(204.62741f, 0.0f, 210.0f, 5.3725824f, 210.0f, 12.0f);
                l.lineTo(210.0f, 60.0f);
                l.cubicTo(210.0f, 66.62742f, 204.62741f, 72.0f, 198.0f, 72.0f);
                l.lineTo(12.0f, 72.0f);
                l.cubicTo(5.3725824f, 72.0f, 0.0f, 66.62742f, 0.0f, 60.0f);
                l.lineTo(0.0f, 12.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-1);
                l = c.l(looper);
                l.moveTo(105.0f, 11.0f);
                l.cubicTo(105.0f, 6.581722f, 108.58172f, 3.0f, 113.0f, 3.0f);
                l.lineTo(199.0f, 3.0f);
                l.cubicTo(203.41827f, 3.0f, 207.0f, 6.581722f, 207.0f, 11.0f);
                l.lineTo(207.0f, 61.0f);
                l.cubicTo(207.0f, 65.41828f, 203.41827f, 69.0f, 199.0f, 69.0f);
                l.lineTo(113.0f, 69.0f);
                l.cubicTo(108.58172f, 69.0f, 105.0f, 65.41828f, 105.0f, 61.0f);
                l.lineTo(105.0f, 11.0f);
                l.close();
                canvas.drawPath(l, k);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
