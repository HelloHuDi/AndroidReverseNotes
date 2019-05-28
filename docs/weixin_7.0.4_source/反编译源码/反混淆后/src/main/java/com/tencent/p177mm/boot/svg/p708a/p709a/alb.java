package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.alb */
public final class alb extends C5163c {
    private final int height = 90;
    private final int width = 90;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix h = C5163c.m7881h(looper);
                float[] g = C5163c.m7880g(looper);
                Paint k = C5163c.m7883k(looper);
                k.setFlags(385);
                k.setStyle(Style.FILL);
                Paint k2 = C5163c.m7883k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.STROKE);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(1.0f);
                k2.setStrokeCap(Cap.BUTT);
                k2.setStrokeJoin(Join.MITER);
                k2.setStrokeMiter(4.0f);
                k2.setPathEffect(null);
                Paint a = C5163c.m7876a(k2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, -276.0f, 0.0f, 1.0f, -265.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 276.0f, 0.0f, 1.0f, 265.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Paint a2 = C5163c.m7876a(k, looper);
                a2.setColor(838860800);
                canvas.save();
                Paint a3 = C5163c.m7876a(a2, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(45.0f, 0.0f);
                l.cubicTo(69.85281f, 0.0f, 90.0f, 20.147184f, 90.0f, 45.0f);
                l.cubicTo(90.0f, 69.85281f, 69.85281f, 90.0f, 45.0f, 90.0f);
                l.cubicTo(20.147184f, 90.0f, 0.0f, 69.85281f, 0.0f, 45.0f);
                l.cubicTo(0.0f, 20.147184f, 20.147184f, 0.0f, 45.0f, 0.0f);
                l.close();
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(a, looper);
                a3.setColor(-1);
                a3.setStrokeWidth(6.0f);
                l = C5163c.m7884l(looper);
                l.moveTo(45.0f, 3.0f);
                l.cubicTo(68.19596f, 3.0f, 87.0f, 21.804039f, 87.0f, 45.0f);
                l.cubicTo(87.0f, 68.19596f, 68.19596f, 87.0f, 45.0f, 87.0f);
                l.cubicTo(21.804039f, 87.0f, 3.0f, 68.19596f, 3.0f, 45.0f);
                l.cubicTo(3.0f, 21.804039f, 21.804039f, 3.0f, 45.0f, 3.0f);
                l.close();
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                a3 = C5163c.m7876a(k, looper);
                a3.setColor(-1);
                l = C5163c.m7884l(looper);
                l.moveTo(59.248722f, 48.12048f);
                l.lineTo(39.167625f, 62.609314f);
                l.cubicTo(38.27261f, 63.25508f, 37.023556f, 63.053024f, 36.37779f, 62.15801f);
                l.cubicTo(36.13218f, 61.817604f, 36.0f, 61.408504f, 36.0f, 60.988743f);
                l.lineTo(36.0f, 32.011078f);
                l.cubicTo(36.0f, 30.907413f, 36.894695f, 30.012718f, 37.998356f, 30.012718f);
                l.cubicTo(38.418118f, 30.012718f, 38.82722f, 30.1449f, 39.167625f, 30.390507f);
                l.lineTo(59.248722f, 44.87934f);
                l.cubicTo(60.14374f, 45.52511f, 60.345795f, 46.774162f, 59.700027f, 47.669178f);
                l.cubicTo(59.57474f, 47.84282f, 59.422363f, 47.995193f, 59.248722f, 48.12048f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
