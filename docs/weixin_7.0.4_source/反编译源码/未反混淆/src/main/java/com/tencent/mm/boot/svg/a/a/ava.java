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

public final class ava extends c {
    private final int height = 30;
    private final int width = 42;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 42;
            case 1:
                return 30;
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
                g = c.a(g, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 3.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(3.0f, 21.0f);
                l.lineTo(25.0f, 21.0f);
                l.lineTo(25.0f, 3.0f);
                l.lineTo(3.0f, 3.0f);
                l.lineTo(3.0f, 21.0f);
                l.close();
                l.moveTo(0.0f, 2.0049467f);
                l.cubicTo(0.0f, 0.8976452f, 0.8998975f, 0.0f, 1.9912443f, 0.0f);
                l.lineTo(26.008757f, 0.0f);
                l.cubicTo(27.10849f, 0.0f, 28.0f, 0.89702624f, 28.0f, 2.0049467f);
                l.lineTo(28.0f, 21.995054f);
                l.cubicTo(28.0f, 23.102354f, 27.100103f, 24.0f, 26.008757f, 24.0f);
                l.lineTo(1.9912443f, 24.0f);
                l.cubicTo(0.8915104f, 24.0f, 0.0f, 23.102974f, 0.0f, 21.995054f);
                l.lineTo(0.0f, 2.0049467f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(34.0f, 14.914493f);
                l.lineTo(39.0f, 18.323584f);
                l.lineTo(39.0f, 5.6764164f);
                l.lineTo(34.0f, 9.085507f);
                l.lineTo(34.0f, 14.914493f);
                l.close();
                l.moveTo(31.0f, 7.5f);
                l.lineTo(39.51767f, 1.692498f);
                l.cubicTo(40.888622f, 0.7577572f, 42.0f, 1.3417706f, 42.0f, 2.9910905f);
                l.lineTo(42.0f, 21.00891f);
                l.cubicTo(42.0f, 22.660843f, 40.884727f, 23.239586f, 39.51767f, 22.307503f);
                l.lineTo(31.0f, 16.5f);
                l.lineTo(31.0f, 7.5f);
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
