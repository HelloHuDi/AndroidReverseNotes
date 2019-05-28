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

public final class fb extends c {
    private final int height = 200;
    private final int width = 200;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 200;
            case 1:
                return 200;
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
                g = c.a(g, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 29.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(0.31970137f, 77.93319f);
                l.cubicTo(-0.063724294f, 77.53636f, -0.108552635f, 76.85273f, 0.2193248f, 76.40659f);
                l.lineTo(9.792403f, 63.380688f);
                l.cubicTo(10.120393f, 62.934402f, 10.738718f, 62.842735f, 11.176576f, 63.17833f);
                l.lineTo(61.002815f, 101.36729f);
                l.cubicTo(62.317314f, 102.37477f, 64.42048f, 102.32714f, 65.687584f, 101.27154f);
                l.lineTo(186.95796f, 0.24350294f);
                l.cubicTo(187.37868f, -0.10698287f, 188.04178f, -0.07305191f, 188.42578f, 0.3061832f);
                l.lineTo(197.7745f, 9.538964f);
                l.cubicTo(198.16446f, 9.9240675f, 198.16162f, 10.550133f, 197.76987f, 10.935685f);
                l.lineTo(64.80481f, 141.79317f);
                l.cubicTo(64.01734f, 142.56815f, 62.75824f, 142.55399f, 61.988094f, 141.75691f);
                l.lineTo(0.31970137f, 77.93319f);
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
