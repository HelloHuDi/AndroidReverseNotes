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

public final class gq extends c {
    private final int height = 21;
    private final int width = 36;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 36;
            case 1:
                return 21;
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
                k = c.a(k, looper);
                k.setColor(-6710887);
                canvas.save();
                Paint a = c.a(k, looper);
                g = c.a(g, 0.70710677f, 0.70710677f, 2.4558444f, -0.70710677f, 0.70710677f, 13.870058f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l = c.l(looper);
                l.moveTo(10.970563f, 10.970563f);
                l.lineTo(29.970562f, 10.970563f);
                l.lineTo(29.970562f, 15.970563f);
                l.lineTo(5.970563f, 15.970563f);
                l.lineTo(5.970563f, 13.470563f);
                l.lineTo(5.970563f, -8.029437f);
                l.lineTo(10.970563f, -8.029437f);
                l.lineTo(10.970563f, 10.970563f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
