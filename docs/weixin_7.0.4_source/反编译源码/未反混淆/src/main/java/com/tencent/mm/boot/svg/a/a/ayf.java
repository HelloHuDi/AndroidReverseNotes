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

public final class ayf extends c {
    private final int height = 11;
    private final int width = 6;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 6;
            case 1:
                return 11;
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
                a.setColor(-855310);
                g = c.a(g, 1.0f, 0.0f, -80.0f, 0.0f, 1.0f, -322.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 34.0f, 0.0f, 1.0f, 318.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                a = c.a(a, looper);
                g = c.a(g, -1.0f, 0.0f, 98.0f, 0.0f, -1.0f, 19.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l = c.l(looper);
                l.moveTo(52.0f, 14.3125f);
                l.lineTo(51.30351f, 15.0f);
                l.lineTo(46.16417f, 9.9270115f);
                l.cubicTo(45.928337f, 9.694224f, 45.92587f, 9.314333f, 46.158653f, 9.078502f);
                l.cubicTo(46.16048f, 9.076652f, 46.16232f, 9.074814f, 46.16417f, 9.0729885f);
                l.lineTo(51.30351f, 4.0f);
                l.lineTo(52.0f, 4.6875f);
                l.lineTo(47.124554f, 9.5f);
                l.lineTo(52.0f, 14.3125f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
