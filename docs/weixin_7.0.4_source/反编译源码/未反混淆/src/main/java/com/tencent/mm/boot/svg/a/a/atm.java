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

public final class atm extends c {
    private final int height = 90;
    private final int width = 90;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                k = c.a(k2, looper);
                k.setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(k, looper);
                a.setStrokeWidth(3.0f);
                Path l = c.l(looper);
                l.moveTo(45.0f, 11.0f);
                l.cubicTo(63.225395f, 11.0f, 78.0f, 25.774603f, 78.0f, 44.0f);
                l.cubicTo(78.0f, 62.225395f, 63.225395f, 77.0f, 45.0f, 77.0f);
                l.cubicTo(26.774603f, 77.0f, 12.0f, 62.225395f, 12.0f, 44.0f);
                l.cubicTo(12.0f, 25.774603f, 26.774603f, 11.0f, 45.0f, 11.0f);
                l.close();
                k2 = c.k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.FILL);
                Paint k3 = c.k(looper);
                k3.setFlags(385);
                k3.setStyle(Style.STROKE);
                k2.setColor(WebView.NIGHT_MODE_COLOR);
                k3.setStrokeWidth(1.0f);
                k3.setStrokeCap(Cap.BUTT);
                k3.setStrokeJoin(Join.MITER);
                k3.setStrokeMiter(4.0f);
                k3.setPathEffect(null);
                float[] a2 = c.a(g, 66.0f, 0.0f, 12.0f, 0.0f, 66.0f, 11.0f);
                h.reset();
                h.setValues(a2);
                WeChatSVGRenderC2Java.setLinearGradient(a, 0.5f, 0.0f, 0.5f, 1.0f, new int[]{-11019676, -5439996}, new float[]{0.0f, 1.0f}, h, 0);
                canvas.drawPath(l, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
