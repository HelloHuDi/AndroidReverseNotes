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

public final class pe extends c {
    private final int height = 96;
    private final int width = 96;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                a.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(36.0f, 67.68f);
                l.cubicTo(53.49638f, 67.68f, 67.68f, 53.49638f, 67.68f, 36.0f);
                l.cubicTo(67.68f, 18.503618f, 53.49638f, 4.32f, 36.0f, 4.32f);
                l.cubicTo(18.503618f, 4.32f, 4.32f, 18.503618f, 4.32f, 36.0f);
                l.cubicTo(4.32f, 53.49638f, 18.503618f, 67.68f, 36.0f, 67.68f);
                l.close();
                l.moveTo(36.0f, 72.0f);
                l.cubicTo(16.117748f, 72.0f, 0.0f, 55.88225f, 0.0f, 36.0f);
                l.cubicTo(0.0f, 16.117748f, 16.117748f, 0.0f, 36.0f, 0.0f);
                l.cubicTo(55.88225f, 0.0f, 72.0f, 16.117748f, 72.0f, 36.0f);
                l.cubicTo(72.0f, 55.88225f, 55.88225f, 72.0f, 36.0f, 72.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(25.2f, 27.745117f);
                l.lineTo(29.494884f, 27.745117f);
                l.cubicTo(29.771162f, 24.153488f, 32.182327f, 21.91814f, 35.974884f, 21.91814f);
                l.cubicTo(39.71721f, 21.91814f, 42.128372f, 24.20372f, 42.128372f, 27.31814f);
                l.cubicTo(42.128372f, 30.00558f, 40.99814f, 31.587908f, 38.084652f, 33.371162f);
                l.cubicTo(34.643723f, 35.4307f, 33.036278f, 37.691162f, 33.061394f, 41.00651f);
                l.lineTo(33.061394f, 43.31721f);
                l.lineTo(37.456745f, 43.31721f);
                l.lineTo(37.456745f, 41.68465f);
                l.cubicTo(37.456745f, 39.047443f, 38.36093f, 37.64093f, 41.550697f, 35.75721f);
                l.cubicTo(44.765583f, 33.823257f, 46.8f, 31.035349f, 46.8f, 27.092093f);
                l.cubicTo(46.8f, 21.91814f, 42.48f, 18.0f, 36.150696f, 18.0f);
                l.cubicTo(29.093023f, 18.0f, 25.476278f, 22.32f, 25.2f, 27.745117f);
                l.close();
                l.moveTo(35.27163f, 54.770233f);
                l.cubicTo(36.904186f, 54.770233f, 38.134884f, 53.51442f, 38.134884f, 51.90698f);
                l.cubicTo(38.134884f, 50.274418f, 36.904186f, 49.04372f, 35.27163f, 49.04372f);
                l.cubicTo(33.664185f, 49.04372f, 32.40837f, 50.274418f, 32.40837f, 51.90698f);
                l.cubicTo(32.40837f, 53.51442f, 33.664185f, 54.770233f, 35.27163f, 54.770233f);
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
