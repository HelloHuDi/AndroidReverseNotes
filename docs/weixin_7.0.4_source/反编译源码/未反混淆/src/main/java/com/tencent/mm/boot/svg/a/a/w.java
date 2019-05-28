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

public final class w extends c {
    private final int height = 72;
    private final int width = 72;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                canvas.saveLayerAlpha(null, 76, 4);
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-13421773);
                g = c.a(g, 1.0f, 0.0f, -9.0f, 0.0f, 1.0f, -3.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 0.8660254f, -0.5f, 35.39353f, 0.5f, 0.8660254f, 1.0432687f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(29.976608f, 53.99089f);
                l.lineTo(28.02372f, 58.706367f);
                l.lineTo(26.070831f, 53.99089f);
                l.lineTo(26.051668f, 53.99089f);
                l.lineTo(26.051668f, 47.683502f);
                l.cubicTo(17.177538f, 46.702515f, 10.275263f, 39.178997f, 10.275263f, 30.043367f);
                l.lineTo(10.275263f, 23.18063f);
                l.lineTo(14.219365f, 23.18063f);
                l.lineTo(14.219365f, 29.885603f);
                l.cubicTo(14.219365f, 37.509537f, 20.399784f, 43.689957f, 28.02372f, 43.689957f);
                l.cubicTo(35.647655f, 43.689957f, 41.828075f, 37.509537f, 41.828075f, 29.885603f);
                l.lineTo(41.828075f, 23.18063f);
                l.lineTo(45.772175f, 23.18063f);
                l.lineTo(45.772175f, 30.043367f);
                l.cubicTo(45.772175f, 39.178997f, 38.8699f, 46.702515f, 29.99577f, 47.683502f);
                l.lineTo(29.99577f, 53.99089f);
                l.lineTo(29.976608f, 53.99089f);
                l.close();
                l.moveTo(28.02372f, 2.6713028f);
                l.cubicTo(33.469387f, 2.6713028f, 37.883972f, 7.085889f, 37.883972f, 12.531556f);
                l.lineTo(37.883972f, 29.727839f);
                l.cubicTo(37.883972f, 35.173508f, 33.469387f, 39.588093f, 28.02372f, 39.588093f);
                l.cubicTo(22.578053f, 39.588093f, 18.163465f, 35.173508f, 18.163465f, 29.727839f);
                l.lineTo(18.163465f, 12.531556f);
                l.cubicTo(18.163465f, 7.085889f, 22.578053f, 2.6713028f, 28.02372f, 2.6713028f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
