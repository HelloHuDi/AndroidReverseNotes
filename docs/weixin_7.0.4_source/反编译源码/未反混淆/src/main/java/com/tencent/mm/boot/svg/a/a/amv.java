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

public final class amv extends c {
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
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-12206054);
                g = c.a(g, 1.0f, 0.0f, 17.0f, 0.0f, 1.0f, 20.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(30.9995f, 0.0f);
                l.cubicTo(13.878777f, 0.0f, 0.0f, 11.798211f, 0.0f, 26.35247f);
                l.cubicTo(0.0f, 33.18859f, 3.0619507f, 39.415703f, 8.08287f, 44.09879f);
                l.cubicTo(6.80389f, 48.17186f, 4.4279284f, 56.0f, 4.4279284f, 56.0f);
                l.lineTo(17.250721f, 49.972893f);
                l.cubicTo(21.394655f, 51.719925f, 26.06058f, 52.70594f, 31.0005f, 52.70594f);
                l.cubicTo(48.121223f, 52.70594f, 62.0f, 40.90773f, 62.0f, 26.35147f);
                l.cubicTo(61.999f, 11.798211f, 48.120224f, 0.0f, 30.9995f, 0.0f);
                l.lineTo(30.9995f, 0.0f);
                l.lineTo(30.9995f, 0.0f);
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
