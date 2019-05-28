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

public final class yi extends c {
    private final int height = 30;
    private final int width = 26;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 26;
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
                canvas.save();
                c.a(k2, looper).setStrokeWidth(1.0f);
                g = c.a(g, 1.0f, 0.0f, -174.0f, 0.0f, 1.0f, -448.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-3684409);
                Path l = c.l(looper);
                l.moveTo(199.0f, 450.0f);
                l.cubicTo(199.55229f, 450.0f, 200.0f, 450.44772f, 200.0f, 451.0f);
                l.lineTo(200.0f, 477.0f);
                l.cubicTo(200.0f, 477.55228f, 199.55229f, 478.0f, 199.0f, 478.0f);
                l.lineTo(175.0f, 478.0f);
                l.cubicTo(174.44771f, 478.0f, 174.0f, 477.55228f, 174.0f, 477.0f);
                l.lineTo(174.0f, 451.0f);
                l.cubicTo(174.0f, 450.44772f, 174.44771f, 450.0f, 175.0f, 450.0f);
                l.lineTo(177.0f, 450.0f);
                l.cubicTo(177.55229f, 450.0f, 178.0f, 450.44772f, 178.0f, 451.0f);
                l.cubicTo(178.0f, 451.55228f, 177.55229f, 452.0f, 177.0f, 452.0f);
                l.lineTo(176.0f, 452.0f);
                l.lineTo(176.0f, 476.0f);
                l.lineTo(198.0f, 476.0f);
                l.lineTo(198.0f, 452.0f);
                l.lineTo(197.0f, 452.0f);
                l.cubicTo(196.44771f, 452.0f, 196.0f, 451.55228f, 196.0f, 451.0f);
                l.cubicTo(196.0f, 450.44772f, 196.44771f, 450.0f, 197.0f, 450.0f);
                l.lineTo(199.0f, 450.0f);
                l.close();
                l.moveTo(181.0f, 448.0f);
                l.cubicTo(181.55229f, 448.0f, 182.0f, 448.44772f, 182.0f, 449.0f);
                l.lineTo(182.0f, 453.0f);
                l.cubicTo(182.0f, 453.55228f, 181.55229f, 454.0f, 181.0f, 454.0f);
                l.cubicTo(180.44771f, 454.0f, 180.0f, 453.55228f, 180.0f, 453.0f);
                l.lineTo(180.0f, 449.0f);
                l.cubicTo(180.0f, 448.44772f, 180.44771f, 448.0f, 181.0f, 448.0f);
                l.close();
                l.moveTo(193.0f, 448.0f);
                l.cubicTo(193.55229f, 448.0f, 194.0f, 448.44772f, 194.0f, 449.0f);
                l.lineTo(194.0f, 453.0f);
                l.cubicTo(194.0f, 453.55228f, 193.55229f, 454.0f, 193.0f, 454.0f);
                l.cubicTo(192.44771f, 454.0f, 192.0f, 453.55228f, 192.0f, 453.0f);
                l.lineTo(192.0f, 449.0f);
                l.cubicTo(192.0f, 448.44772f, 192.44771f, 448.0f, 193.0f, 448.0f);
                l.close();
                l.moveTo(185.0f, 450.0f);
                l.lineTo(189.0f, 450.0f);
                l.cubicTo(189.55229f, 450.0f, 190.0f, 450.44772f, 190.0f, 451.0f);
                l.cubicTo(190.0f, 451.55228f, 189.55229f, 452.0f, 189.0f, 452.0f);
                l.lineTo(185.0f, 452.0f);
                l.cubicTo(184.44771f, 452.0f, 184.0f, 451.55228f, 184.0f, 451.0f);
                l.cubicTo(184.0f, 450.44772f, 184.44771f, 450.0f, 185.0f, 450.0f);
                l.close();
                l.moveTo(181.0f, 460.0f);
                l.lineTo(193.0f, 460.0f);
                l.cubicTo(193.55229f, 460.0f, 194.0f, 460.44772f, 194.0f, 461.0f);
                l.cubicTo(194.0f, 461.55228f, 193.55229f, 462.0f, 193.0f, 462.0f);
                l.lineTo(181.0f, 462.0f);
                l.cubicTo(180.44771f, 462.0f, 180.0f, 461.55228f, 180.0f, 461.0f);
                l.cubicTo(180.0f, 460.44772f, 180.44771f, 460.0f, 181.0f, 460.0f);
                l.close();
                l.moveTo(181.0f, 468.0f);
                l.lineTo(193.0f, 468.0f);
                l.cubicTo(193.55229f, 468.0f, 194.0f, 468.44772f, 194.0f, 469.0f);
                l.cubicTo(194.0f, 469.55228f, 193.55229f, 470.0f, 193.0f, 470.0f);
                l.lineTo(181.0f, 470.0f);
                l.cubicTo(180.44771f, 470.0f, 180.0f, 469.55228f, 180.0f, 469.0f);
                l.cubicTo(180.0f, 468.44772f, 180.44771f, 468.0f, 181.0f, 468.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
