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

public final class azn extends c {
    private final int height = 255;
    private final int width = 255;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 255;
            case 1:
                return 255;
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
                g = c.a(g, 1.0f, 0.0f, 74.0f, 0.0f, 1.0f, 65.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(98.000374f, 0.0f);
                l.lineTo(21.999622f, 0.0f);
                l.lineTo(24.0f, 0.0f);
                l.lineTo(12.0f, 12.0f);
                l.lineTo(12.0f, 10.000714f);
                l.lineTo(12.0f, 126.0f);
                l.lineTo(108.0f, 126.0f);
                l.lineTo(108.0f, 10.000714f);
                l.lineTo(108.0f, 12.0f);
                l.lineTo(96.0f, 0.0f);
                l.lineTo(98.000374f, 0.0f);
                l.close();
                l.moveTo(108.0f, 114.0f);
                l.lineTo(96.0f, 126.0f);
                l.lineTo(108.0f, 126.0f);
                l.lineTo(108.0f, 114.0f);
                l.close();
                l.moveTo(0.0f, 48.0f);
                l.lineTo(12.0f, 48.0f);
                l.lineTo(12.0f, 126.0f);
                l.lineTo(0.0f, 126.0f);
                l.lineTo(0.0f, 48.0f);
                l.close();
                l.moveTo(0.0f, 114.0f);
                l.lineTo(12.0f, 126.0f);
                l.lineTo(0.0f, 126.0f);
                l.lineTo(0.0f, 114.0f);
                l.close();
                l.moveTo(0.0f, 60.0f);
                l.lineTo(12.0f, 48.0f);
                l.lineTo(0.0f, 48.0f);
                l.lineTo(0.0f, 60.0f);
                l.close();
                l.moveTo(36.0f, 12.0f);
                l.lineTo(48.0f, 12.0f);
                l.lineTo(48.0f, 42.0f);
                l.lineTo(36.0f, 42.0f);
                l.lineTo(36.0f, 12.0f);
                l.close();
                l.moveTo(54.0f, 12.0f);
                l.lineTo(66.0f, 12.0f);
                l.lineTo(66.0f, 42.0f);
                l.lineTo(54.0f, 42.0f);
                l.lineTo(54.0f, 12.0f);
                l.close();
                l.moveTo(72.0f, 12.0f);
                l.lineTo(84.0f, 12.0f);
                l.lineTo(84.0f, 42.0f);
                l.lineTo(72.0f, 42.0f);
                l.lineTo(72.0f, 12.0f);
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
