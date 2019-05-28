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

public final class azy extends c {
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
                k2 = c.a(k2, looper);
                k2.setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(k2, looper);
                a.setColor(-15028967);
                a.setStrokeWidth(3.6f);
                Path l = c.l(looper);
                l.moveTo(36.0f, 1.7999992f);
                l.cubicTo(54.888138f, 1.7999992f, 70.2f, 17.11186f, 70.2f, 36.0f);
                l.cubicTo(70.2f, 54.888138f, 54.888138f, 70.2f, 36.0f, 70.2f);
                l.cubicTo(17.11186f, 70.2f, 1.7999992f, 54.888138f, 1.7999992f, 36.0f);
                l.cubicTo(1.7999992f, 17.11186f, 17.11186f, 1.7999992f, 36.0f, 1.7999992f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k2 = c.a(k, looper);
                k2.setColor(-15028967);
                Path l2 = c.l(looper);
                l2.moveTo(24.0f, 19.5f);
                l2.lineTo(29.4f, 19.5f);
                l2.lineTo(29.4f, 52.5f);
                l2.lineTo(24.0f, 52.5f);
                l2.lineTo(24.0f, 19.5f);
                l2.close();
                canvas.drawPath(l2, k2);
                canvas.restore();
                canvas.save();
                k2 = c.a(k, looper);
                k2.setColor(-15028967);
                l2 = c.l(looper);
                l2.moveTo(42.59999f, 19.5f);
                l2.lineTo(47.999992f, 19.5f);
                l2.lineTo(47.999992f, 52.5f);
                l2.lineTo(42.59999f, 52.5f);
                l2.lineTo(42.59999f, 19.5f);
                l2.close();
                canvas.drawPath(l2, k2);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
