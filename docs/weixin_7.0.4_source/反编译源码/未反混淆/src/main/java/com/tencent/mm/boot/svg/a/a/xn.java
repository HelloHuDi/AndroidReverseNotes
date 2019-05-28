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

public final class xn extends c {
    private final int height = 80;
    private final int width = 120;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 80;
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
                g = c.a(g, 1.0f, 0.0f, 31.0f, 0.0f, 1.0f, 22.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(14.0f, 0.0f);
                l.lineTo(14.0f, 14.0f);
                l.lineTo(0.0f, 14.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                l.moveTo(22.0f, 0.0f);
                l.lineTo(36.0f, 0.0f);
                l.lineTo(36.0f, 14.0f);
                l.lineTo(22.0f, 14.0f);
                l.lineTo(22.0f, 0.0f);
                l.close();
                l.moveTo(44.0f, 0.0f);
                l.lineTo(58.0f, 0.0f);
                l.lineTo(58.0f, 14.0f);
                l.lineTo(44.0f, 14.0f);
                l.lineTo(44.0f, 0.0f);
                l.close();
                l.moveTo(0.0f, 22.0f);
                l.lineTo(14.0f, 22.0f);
                l.lineTo(14.0f, 36.0f);
                l.lineTo(0.0f, 36.0f);
                l.lineTo(0.0f, 22.0f);
                l.close();
                l.moveTo(22.0f, 22.0f);
                l.lineTo(36.0f, 22.0f);
                l.lineTo(36.0f, 36.0f);
                l.lineTo(22.0f, 36.0f);
                l.lineTo(22.0f, 22.0f);
                l.close();
                l.moveTo(44.0f, 22.0f);
                l.lineTo(58.0f, 22.0f);
                l.lineTo(58.0f, 36.0f);
                l.lineTo(44.0f, 36.0f);
                l.lineTo(44.0f, 22.0f);
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
