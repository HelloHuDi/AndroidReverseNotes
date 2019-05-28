package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.k.o;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class xu extends c {
    private final int height = 24;
    private final int width = 39;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 39;
            case 1:
                return 24;
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
                canvas.saveLayerAlpha(null, o.CTRL_INDEX, 4);
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-9408138);
                g = c.a(g, 1.0f, 0.0f, -991.0f, 0.0f, 1.0f, -1857.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                a = c.a(a, looper);
                g = c.a(g, 1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 3737.4177f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l = c.l(looper);
                l.moveTo(991.0f, 1876.2609f);
                l.lineTo(1010.26086f, 1857.0f);
                l.lineTo(1030.0183f, 1876.7574f);
                l.lineTo(1026.3582f, 1880.4176f);
                l.lineTo(1010.26086f, 1864.3204f);
                l.lineTo(994.6602f, 1879.9211f);
                l.lineTo(991.0f, 1876.2609f);
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
