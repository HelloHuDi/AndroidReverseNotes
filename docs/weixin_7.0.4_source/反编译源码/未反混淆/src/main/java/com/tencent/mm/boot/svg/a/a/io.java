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

public final class io extends c {
    private final int height = 60;
    private final int width = 60;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                a.setColor(-5592406);
                g = c.a(g, 1.0f, 0.0f, -154.0f, 0.0f, 1.0f, -132.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -3.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 160.0f, 0.0f, 1.0f, 141.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(0.0f, 6.0063868f);
                l.cubicTo(0.0f, 2.6891508f, 2.6835413f, 0.0f, 6.0063868f, 0.0f);
                l.lineTo(41.993614f, 0.0f);
                l.cubicTo(45.31085f, 0.0f, 48.0f, 2.6835413f, 48.0f, 6.0063868f);
                l.lineTo(48.0f, 41.993614f);
                l.cubicTo(48.0f, 45.31085f, 45.31646f, 48.0f, 41.993614f, 48.0f);
                l.lineTo(6.0063868f, 48.0f);
                l.cubicTo(2.6891508f, 48.0f, 0.0f, 45.31646f, 0.0f, 41.993614f);
                l.lineTo(0.0f, 6.0063868f);
                l.lineTo(0.0f, 6.0063868f);
                l.close();
                l.moveTo(4.0f, 5.9972916f);
                l.cubicTo(4.0f, 4.894218f, 4.89154f, 4.0f, 5.9972916f, 4.0f);
                l.lineTo(42.00271f, 4.0f);
                l.cubicTo(43.10578f, 4.0f, 44.0f, 4.89154f, 44.0f, 5.9972916f);
                l.lineTo(44.0f, 42.00271f);
                l.cubicTo(44.0f, 43.10578f, 43.10846f, 44.0f, 42.00271f, 44.0f);
                l.lineTo(5.9972916f, 44.0f);
                l.cubicTo(4.894218f, 44.0f, 4.0f, 43.10846f, 4.0f, 42.00271f);
                l.lineTo(4.0f, 5.9972916f);
                l.lineTo(4.0f, 5.9972916f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
