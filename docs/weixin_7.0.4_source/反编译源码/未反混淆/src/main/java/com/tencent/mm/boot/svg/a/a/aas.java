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

public final class aas extends c {
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
                c.a(k2, looper).setStrokeWidth(1.0f);
                k = c.a(k, looper);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(33.808594f, 24.5625f);
                l.cubicTo(28.710938f, 24.5625f, 25.40625f, 28.886719f, 25.40625f, 35.53125f);
                l.cubicTo(25.40625f, 42.140625f, 28.675781f, 46.429688f, 33.773438f, 46.429688f);
                l.cubicTo(38.976562f, 46.429688f, 42.316406f, 42.070312f, 42.316406f, 35.35547f);
                l.cubicTo(42.316406f, 28.746094f, 39.046875f, 24.5625f, 33.808594f, 24.5625f);
                l.close();
                l.moveTo(34.933594f, 6.0f);
                l.cubicTo(50.339474f, 6.0f, 63.058594f, 16.582031f, 63.058594f, 32.15625f);
                l.cubicTo(63.058594f, 43.335938f, 58.41797f, 50.507812f, 50.683594f, 50.507812f);
                l.cubicTo(46.5f, 50.507812f, 43.195312f, 47.976562f, 42.66797f, 44.039062f);
                l.lineTo(42.421875f, 44.039062f);
                l.cubicTo(40.839844f, 48.046875f, 37.570312f, 50.26172f, 33.210938f, 50.26172f);
                l.cubicTo(25.96875f, 50.26172f, 21.046875f, 44.285156f, 21.046875f, 35.42578f);
                l.cubicTo(21.046875f, 26.777344f, 26.039062f, 20.800781f, 33.210938f, 20.800781f);
                l.cubicTo(37.289062f, 20.800781f, 40.839844f, 23.015625f, 42.140625f, 26.460938f);
                l.lineTo(42.38672f, 26.460938f);
                l.lineTo(42.38672f, 21.503906f);
                l.lineTo(46.464844f, 21.503906f);
                l.lineTo(46.464844f, 41.61328f);
                l.cubicTo(46.464844f, 44.8125f, 48.152344f, 46.921875f, 51.351562f, 46.921875f);
                l.cubicTo(56.027344f, 46.921875f, 59.226562f, 41.54297f, 59.226562f, 32.085938f);
                l.cubicTo(59.226562f, 18.65625f, 48.71459f, 9.527114f, 34.933594f, 9.527114f);
                l.cubicTo(21.1526f, 9.527114f, 9.8671875f, 19.576914f, 9.8671875f, 35.320312f);
                l.cubicTo(9.8671875f, 49.944553f, 21.909554f, 61.089844f, 35.320312f, 61.089844f);
                l.cubicTo(40.066406f, 61.089844f, 44.601562f, 60.492188f, 46.992188f, 59.54297f);
                l.lineTo(46.992188f, 63.023438f);
                l.cubicTo(44.14453f, 64.00781f, 39.996094f, 64.57031f, 35.285156f, 64.57031f);
                l.cubicTo(18.59385f, 64.57031f, 6.0f, 51.976818f, 6.0f, 35.179688f);
                l.cubicTo(6.0f, 18.382557f, 19.527716f, 6.0f, 34.933594f, 6.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
