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

public final class aqf extends c {
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
                a.setColor(-899014);
                g = c.a(g, 1.0f, 0.0f, -218.0f, 0.0f, 1.0f, -230.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 224.0f, 0.0f, 1.0f, 236.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(0.0f, 24.0f);
                l.cubicTo(0.0f, 10.8f, 10.8f, 0.0f, 24.0f, 0.0f);
                l.cubicTo(37.2f, 0.0f, 48.0f, 10.8f, 48.0f, 24.0f);
                l.cubicTo(48.0f, 37.2f, 37.2f, 48.0f, 24.0f, 48.0f);
                l.cubicTo(10.8f, 48.0f, 0.0f, 37.2f, 0.0f, 24.0f);
                l.close();
                l.moveTo(4.0f, 24.0f);
                l.cubicTo(4.0f, 35.0f, 13.0f, 44.0f, 24.0f, 44.0f);
                l.cubicTo(35.0f, 44.0f, 44.0f, 35.0f, 44.0f, 24.0f);
                l.cubicTo(44.0f, 13.0f, 35.0f, 4.0f, 24.0f, 4.0f);
                l.cubicTo(13.0f, 4.0f, 4.0f, 13.0f, 4.0f, 24.0f);
                l.close();
                l.moveTo(10.0f, 24.0f);
                l.cubicTo(10.0f, 31.7f, 16.3f, 38.0f, 24.0f, 38.0f);
                l.cubicTo(31.7f, 38.0f, 38.0f, 31.7f, 38.0f, 24.0f);
                l.cubicTo(38.0f, 16.3f, 31.7f, 10.0f, 24.0f, 10.0f);
                l.cubicTo(16.3f, 10.0f, 10.0f, 16.3f, 10.0f, 24.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
