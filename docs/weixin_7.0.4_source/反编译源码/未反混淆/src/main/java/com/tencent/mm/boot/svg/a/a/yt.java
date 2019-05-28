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

public final class yt extends c {
    private final int height = 36;
    private final int width = 36;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 36;
            case 1:
                return 36;
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
                g = c.a(g, 1.0f, 0.0f, -3864.0f, 0.0f, 1.0f, -2672.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 3855.0f, 0.0f, 1.0f, 2663.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(42.0f, 12.0f);
                l.lineTo(42.0f, 24.0f);
                l.lineTo(45.0f, 24.0f);
                l.lineTo(45.0f, 10.5f);
                l.lineTo(45.0f, 9.0f);
                l.lineTo(30.0f, 9.0f);
                l.lineTo(30.0f, 12.0f);
                l.lineTo(42.0f, 12.0f);
                l.close();
                l.moveTo(12.0f, 42.0f);
                l.lineTo(12.0f, 30.0f);
                l.lineTo(9.0f, 30.0f);
                l.lineTo(9.0f, 43.5f);
                l.lineTo(9.0f, 45.0f);
                l.lineTo(24.0f, 45.0f);
                l.lineTo(24.0f, 42.0f);
                l.lineTo(12.0f, 42.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
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
