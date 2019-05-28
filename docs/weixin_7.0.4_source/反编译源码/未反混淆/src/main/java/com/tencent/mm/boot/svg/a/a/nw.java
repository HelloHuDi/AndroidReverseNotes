package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.g.b;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class nw extends c {
    private final int height = b.CTRL_INDEX;
    private final int width = 300;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 300;
            case 1:
                return b.CTRL_INDEX;
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
                k2 = c.a(k, looper);
                k2.setColor(-921103);
                Path l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(300.0f, 0.0f);
                l.lineTo(300.0f, 136.0f);
                l.lineTo(0.0f, 136.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-3552823);
                g = c.a(g, 1.0f, 0.0f, 111.0f, 0.0f, 1.0f, 39.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l2 = c.l(looper);
                l2.moveTo(0.0f, 3.004289f);
                l2.cubicTo(0.0f, 1.345066f, 1.3380457f, 0.0f, 3.0004263f, 0.0f);
                l2.lineTo(75.99957f, 0.0f);
                l2.cubicTo(77.65666f, 0.0f, 79.0f, 1.3527762f, 79.0f, 3.004289f);
                l2.lineTo(79.0f, 53.995712f);
                l2.cubicTo(79.0f, 55.654934f, 77.66196f, 57.0f, 75.99957f, 57.0f);
                l2.lineTo(3.0004263f, 57.0f);
                l2.cubicTo(1.3433366f, 57.0f, 0.0f, 55.647224f, 0.0f, 53.995712f);
                l2.lineTo(0.0f, 3.004289f);
                l2.close();
                l2.moveTo(4.0f, 4.0f);
                l2.lineTo(75.0f, 4.0f);
                l2.lineTo(75.0f, 53.0f);
                l2.lineTo(4.0f, 53.0f);
                l2.lineTo(4.0f, 4.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(a, looper);
                Path l3 = c.l(looper);
                l3.moveTo(60.92106f, 30.279995f);
                l3.lineTo(50.039062f, 38.768322f);
                l3.lineTo(53.85942f, 46.690155f);
                l3.lineTo(27.17777f, 22.0f);
                l3.lineTo(2.0f, 45.710293f);
                l3.lineTo(2.0f, 56.5f);
                l3.lineTo(77.96154f, 56.5f);
                l3.lineTo(77.96154f, 45.710293f);
                l3.close();
                WeChatSVGRenderC2Java.setFillType(l3, 1);
                WeChatSVGRenderC2Java.setFillType(l3, 2);
                canvas.drawPath(l3, a3);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
