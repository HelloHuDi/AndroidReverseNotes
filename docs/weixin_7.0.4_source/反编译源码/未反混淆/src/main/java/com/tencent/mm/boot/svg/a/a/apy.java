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

public final class apy extends c {
    private final int height = 48;
    private final int width = 48;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                g = c.a(g, 1.0f, 0.0f, 5.0f, 0.0f, 1.0f, 8.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(6.0f, 0.0f);
                l.lineTo(6.0f, 13.0f);
                l.lineTo(19.0f, 13.0f);
                l.lineTo(19.0f, 0.0f);
                l.lineTo(25.0f, 0.0f);
                l.lineTo(25.0f, 32.0f);
                l.lineTo(19.0f, 32.0f);
                l.lineTo(19.0f, 18.0f);
                l.cubicTo(14.64f, 17.98f, 10.29f, 18.1f, 5.94f, 18.07f);
                l.cubicTo(5.95f, 22.71f, 6.03f, 27.36f, 6.0f, 32.0f);
                l.lineTo(0.0f, 32.0f);
                l.lineTo(0.0f, 0.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path l2 = c.l(looper);
                l2.moveTo(31.0f, 0.0f);
                l2.lineTo(37.0f, 0.0f);
                l2.lineTo(37.0f, 5.0f);
                l2.lineTo(31.0f, 5.0f);
                l2.lineTo(31.0f, 0.0f);
                l2.lineTo(31.0f, 0.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                l2 = c.l(looper);
                l2.moveTo(31.0f, 9.0f);
                l2.lineTo(37.0f, 9.0f);
                l2.lineTo(37.0f, 32.0f);
                l2.lineTo(31.0f, 32.0f);
                l2.lineTo(31.0f, 9.0f);
                l2.lineTo(31.0f, 9.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a3);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
