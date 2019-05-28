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
import com.tencent.view.d;

public final class akj extends c {
    private final int height = d.MIC_PTU_TRANS_ROUHE;
    private final int width = d.MIC_PTU_TRANS_ROUHE;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return d.MIC_PTU_TRANS_ROUHE;
            case 1:
                return d.MIC_PTU_TRANS_ROUHE;
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
                g = c.a(g, 1.0f, 0.0f, -17.0f, 0.0f, 1.0f, -250.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                float[] a = c.a(g, 1.0f, 0.0f, 17.0f, 0.0f, 1.0f, 250.0f);
                h.reset();
                h.setValues(a);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(k, looper);
                a2.setColor(-15683841);
                Path l = c.l(looper);
                l.moveTo(279.0f, 141.22223f);
                l.cubicTo(279.0f, 62.454666f, 216.54533f, 0.0f, 137.77777f, 0.0f);
                l.cubicTo(62.454666f, 0.0f, 0.0f, 62.454666f, 0.0f, 141.22223f);
                l.cubicTo(0.0f, 216.54533f, 62.454666f, 279.0f, 137.77777f, 279.0f);
                l.cubicTo(216.54533f, 279.0f, 279.0f, 216.54533f, 279.0f, 141.22223f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-1);
                g = c.a(a, 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 279.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                l = c.l(looper);
                l.moveTo(134.99942f, 70.5f);
                l.lineTo(144.00058f, 70.5f);
                l.cubicTo(145.65565f, 70.5f, 147.03334f, 71.843925f, 147.07448f, 73.50175f);
                l.lineTo(149.42552f, 168.25435f);
                l.cubicTo(149.46655f, 169.90797f, 148.15945f, 171.2561f, 146.5058f, 171.2561f);
                l.lineTo(132.4942f, 171.2561f);
                l.cubicTo(130.8433f, 171.2561f, 129.53334f, 169.91217f, 129.57448f, 168.25435f);
                l.lineTo(131.92552f, 73.50175f);
                l.cubicTo(131.96655f, 71.84813f, 133.34288f, 70.5f, 134.99942f, 70.5f);
                l.close();
                l.moveTo(139.5f, 208.5f);
                l.cubicTo(132.87259f, 208.5f, 127.5f, 203.12741f, 127.5f, 196.5f);
                l.cubicTo(127.5f, 189.87259f, 132.87259f, 184.5f, 139.5f, 184.5f);
                l.cubicTo(146.12741f, 184.5f, 151.5f, 189.87259f, 151.5f, 196.5f);
                l.cubicTo(151.5f, 203.12741f, 146.12741f, 208.5f, 139.5f, 208.5f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
