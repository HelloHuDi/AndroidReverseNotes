package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class anu extends c {
    private final int height = az.CTRL_INDEX;
    private final int width = az.CTRL_INDEX;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return az.CTRL_INDEX;
            case 1:
                return az.CTRL_INDEX;
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
                a.setColor(-13421773);
                g = c.a(g, 1.0f, 0.0f, 48.0f, 0.0f, 1.0f, 48.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(45.781845f, 85.01546f);
                l.cubicTo(45.781845f, 85.01546f, 18.0f, 61.568542f, 18.0f, 39.0f);
                l.cubicTo(18.0f, 22.431458f, 31.431458f, 9.0f, 48.0f, 9.0f);
                l.cubicTo(64.56854f, 9.0f, 78.0f, 22.431458f, 78.0f, 39.0f);
                l.cubicTo(78.0f, 61.568542f, 50.230366f, 85.00419f, 50.230366f, 85.00419f);
                l.cubicTo(49.015343f, 86.10895f, 47.006897f, 86.11149f, 45.781845f, 85.01546f);
                l.close();
                l.moveTo(48.0f, 51.0f);
                l.cubicTo(54.62742f, 51.0f, 60.0f, 45.62742f, 60.0f, 39.0f);
                l.cubicTo(60.0f, 32.37258f, 54.62742f, 27.0f, 48.0f, 27.0f);
                l.cubicTo(41.37258f, 27.0f, 36.0f, 32.37258f, 36.0f, 39.0f);
                l.cubicTo(36.0f, 45.62742f, 41.37258f, 51.0f, 48.0f, 51.0f);
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
