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

public final class aj extends c {
    private final int height = 96;
    private final int width = 96;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                a.setColor(-1);
                g = c.a(g, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 24.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(1.0f, 5.270896f);
                l.cubicTo(2.4202743f, 3.8405488f, 3.8405488f, 2.4202743f, 5.270896f, 1.0f);
                l.cubicTo(11.687312f, 7.3962708f, 18.083584f, 13.812688f, 24.5f, 20.21903f);
                l.cubicTo(30.916416f, 13.822761f, 37.312687f, 7.3962708f, 43.729103f, 1.0f);
                l.cubicTo(45.15945f, 2.4202743f, 46.579727f, 3.8405488f, 48.0f, 5.270896f);
                l.cubicTo(41.60373f, 11.687312f, 35.17724f, 18.083584f, 28.78097f, 24.5f);
                l.cubicTo(35.17724f, 30.916416f, 41.60373f, 37.312687f, 48.0f, 43.739178f);
                l.cubicTo(46.579727f, 45.15945f, 45.15945f, 46.579727f, 43.739178f, 48.0f);
                l.cubicTo(37.312687f, 41.60373f, 30.916416f, 35.17724f, 24.5f, 28.78097f);
                l.cubicTo(18.083584f, 35.17724f, 11.687312f, 41.60373f, 5.270896f, 48.0f);
                l.cubicTo(3.8405488f, 46.579727f, 2.4202743f, 45.15945f, 1.0f, 43.739178f);
                l.cubicTo(7.3962708f, 37.312687f, 13.822761f, 30.916416f, 20.21903f, 24.5f);
                l.cubicTo(13.822761f, 18.083584f, 7.3962708f, 11.687312f, 1.0f, 5.270896f);
                l.lineTo(1.0f, 5.270896f);
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
