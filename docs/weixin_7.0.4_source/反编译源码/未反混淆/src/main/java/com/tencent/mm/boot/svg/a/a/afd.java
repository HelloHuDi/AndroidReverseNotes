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

public final class afd extends c {
    private final int height = 93;
    private final int width = 93;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 93;
            case 1:
                return 93;
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
                Paint a = c.a(k, looper);
                a.setColor(-1);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 13.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(3.7996218f, 0.0f);
                l.cubicTo(2.1727934f, 0.0f, 0.0f, 2.2915592f, 0.0f, 5.020509f);
                l.lineTo(0.0f, 61.501232f);
                l.cubicTo(0.0f, 64.23018f, 2.1727934f, 66.521736f, 3.7996218f, 66.521736f);
                l.lineTo(83.59168f, 66.521736f);
                l.cubicTo(85.217415f, 66.521736f, 87.391304f, 64.23018f, 87.391304f, 61.501232f);
                l.lineTo(87.391304f, 5.020509f);
                l.cubicTo(87.391304f, 2.2915592f, 85.217415f, 0.0f, 83.59168f, 0.0f);
                l.lineTo(3.7996218f, 0.0f);
                l.close();
                l.moveTo(10.302137f, 6.521739f);
                l.cubicTo(8.370235f, 6.521739f, 6.521739f, 8.363973f, 6.521739f, 10.252781f);
                l.lineTo(6.521739f, 56.26896f);
                l.cubicTo(6.521739f, 58.157764f, 8.370235f, 60.0f, 10.302137f, 60.0f);
                l.lineTo(77.089165f, 60.0f);
                l.cubicTo(79.02014f, 60.0f, 80.86957f, 58.157764f, 80.86957f, 56.26896f);
                l.lineTo(80.86957f, 10.252781f);
                l.cubicTo(80.86957f, 8.363973f, 79.02014f, 6.521739f, 77.089165f, 6.521739f);
                l.lineTo(10.302137f, 6.521739f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path l2 = c.l(looper);
                l2.moveTo(13.0f, 18.0f);
                l2.lineTo(74.30435f, 18.0f);
                l2.lineTo(74.30435f, 25.826088f);
                l2.lineTo(13.0f, 25.826088f);
                l2.lineTo(13.0f, 18.0f);
                l2.close();
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
