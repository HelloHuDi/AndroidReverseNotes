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

public final class bae extends c {
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
                canvas.saveLayerAlpha(null, 230, 4);
                canvas.save();
                g = c.a(g, -1.0f, 0.0f, 72.0f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                g = c.a(g, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 18.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a = c.a(k, looper);
                float[] a2 = c.a(g, -1.0f, 0.0f, 66.650795f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(a2);
                canvas.concat(h);
                Path l = c.l(looper);
                l.moveTo(15.814285f, 31.066668f);
                l.lineTo(50.83651f, 31.066668f);
                l.lineTo(50.83651f, 3.6f);
                l.lineTo(15.814285f, 3.6f);
                l.lineTo(15.814285f, 31.066668f);
                l.close();
                l.moveTo(14.401286f, 2.220446E-16f);
                l.lineTo(52.249508f, -1.110223E-16f);
                l.cubicTo(53.457355f, -3.3290015E-16f, 54.43651f, 0.9791533f, 54.43651f, 2.187f);
                l.lineTo(54.43651f, 32.479668f);
                l.cubicTo(54.43651f, 33.687515f, 53.457355f, 34.666668f, 52.249508f, 34.666668f);
                l.lineTo(14.401286f, 34.666668f);
                l.cubicTo(13.193439f, 34.666668f, 12.214286f, 33.687515f, 12.214286f, 32.479668f);
                l.lineTo(12.214286f, 2.187f);
                l.cubicTo(12.214286f, 0.9791533f, 13.193439f, 1.1100563E-15f, 14.401286f, 2.220446E-16f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                g = c.a(a2, -1.0f, 0.0f, 15.079366f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                l = c.l(looper);
                l.moveTo(3.6f, 19.946148f);
                l.lineTo(11.479365f, 27.687836f);
                l.lineTo(11.479365f, 6.7578244f);
                l.lineTo(3.6f, 14.499511f);
                l.lineTo(3.6f, 19.946148f);
                l.close();
                l.moveTo(0.0f, 12.989721f);
                l.lineTo(11.3596115f, 1.8286f);
                l.cubicTo(12.221183f, 0.9820839f, 13.605861f, 0.99428797f, 14.452377f, 1.8558587f);
                l.cubicTo(14.854209f, 2.2648373f, 15.079365f, 2.8152597f, 15.079365f, 3.3886118f);
                l.lineTo(15.079365f, 31.057047f);
                l.cubicTo(15.079365f, 32.264893f, 14.100212f, 33.24405f, 12.892365f, 33.24405f);
                l.cubicTo(12.319013f, 33.24405f, 11.768591f, 33.01889f, 11.3596115f, 32.617058f);
                l.lineTo(0.0f, 21.455938f);
                l.lineTo(0.0f, 12.989721f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
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
