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

public final class qc extends c {
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
                k2 = c.a(k, looper);
                k2.setColor(-12206054);
                canvas.save();
                Paint a = c.a(k2, looper);
                Path l = c.l(looper);
                l.moveTo(28.32f, 0.0f);
                l.lineTo(31.73f, 0.0f);
                l.cubicTo(46.52f, 0.66f, 59.35f, 13.49f, 60.0f, 28.28f);
                l.lineTo(60.0f, 31.52f);
                l.cubicTo(59.48f, 46.57f, 46.27f, 59.66f, 31.21f, 60.0f);
                l.lineTo(28.74f, 60.0f);
                l.cubicTo(13.88f, 59.63f, 0.87f, 46.88f, 0.0f, 32.07f);
                l.lineTo(0.0f, 28.48f);
                l.cubicTo(0.53f, 13.59f, 13.45f, 0.64f, 28.32f, 0.0f);
                l.lineTo(28.32f, 0.0f);
                l.close();
                l.moveTo(28.0f, 12.0f);
                l.lineTo(28.0f, 28.0f);
                l.lineTo(12.0f, 28.0f);
                l.lineTo(12.0f, 32.0f);
                l.lineTo(28.0f, 32.0f);
                l.lineTo(28.0f, 48.0f);
                l.lineTo(32.0f, 48.0f);
                l.lineTo(32.0f, 32.0f);
                l.lineTo(48.0f, 32.0f);
                l.lineTo(48.0f, 28.0f);
                l.lineTo(32.0f, 28.0f);
                l.lineTo(32.0f, 12.0f);
                l.lineTo(28.0f, 12.0f);
                l.lineTo(28.0f, 12.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-1);
                float[] a2 = c.a(g, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                canvas.save();
                k2 = c.a(k, looper);
                Path l2 = c.l(looper);
                l2.moveTo(16.0f, 0.0f);
                l2.lineTo(20.0f, 0.0f);
                l2.lineTo(20.0f, 16.0f);
                l2.lineTo(36.0f, 16.0f);
                l2.lineTo(36.0f, 20.0f);
                l2.lineTo(20.0f, 20.0f);
                l2.lineTo(20.0f, 36.0f);
                l2.lineTo(16.0f, 36.0f);
                l2.lineTo(16.0f, 20.0f);
                l2.lineTo(0.0f, 20.0f);
                l2.lineTo(0.0f, 16.0f);
                l2.lineTo(16.0f, 16.0f);
                l2.lineTo(16.0f, 0.0f);
                l2.lineTo(16.0f, 0.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, k2);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
