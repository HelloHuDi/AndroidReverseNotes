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

public final class sc extends c {
    private final int height = 63;
    private final int width = 63;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 63;
            case 1:
                return 63;
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
                k = c.a(k, looper);
                k.setColor(-1);
                canvas.save();
                Paint a = c.a(k, looper);
                g = c.a(g, 0.70710677f, -0.70710677f, 31.39409f, 0.70710677f, 0.70710677f, -12.125177f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l = c.l(looper);
                l.moveTo(25.405478f, 12.6148405f);
                l.lineTo(25.645857f, 54.121506f);
                l.lineTo(30.480642f, 63.385418f);
                l.lineTo(35.31543f, 54.121506f);
                l.lineTo(35.21498f, 12.6148405f);
                l.lineTo(25.405478f, 12.6148405f);
                l.close();
                l.moveTo(25.389639f, 9.879872f);
                l.lineTo(25.351372f, 3.272119f);
                l.cubicTo(25.341805f, 1.6204139f, 26.683146f, 0.28144225f, 28.343227f, 0.28144225f);
                l.lineTo(32.175957f, 0.28144225f);
                l.cubicTo(33.83788f, 0.28144225f, 35.188385f, 1.6257602f, 35.19237f, 3.272119f);
                l.lineTo(35.208363f, 9.879872f);
                l.lineTo(25.389639f, 9.879872f);
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
