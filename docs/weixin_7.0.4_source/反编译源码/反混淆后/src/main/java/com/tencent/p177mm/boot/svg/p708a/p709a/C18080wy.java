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

/* renamed from: com.tencent.mm.boot.svg.a.a.wy */
public final class C18080wy extends C5163c {
    private final int height = 33;
    private final int width = 38;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 38;
            case 1:
                return 33;
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
                C5163c.m7876a(k2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                g = C5163c.m7878a(g, 1.0f, 0.0f, -480.0f, 0.0f, 1.0f, -190.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(504.54526f, 207.37386f);
                l.lineTo(481.53622f, 221.99107f);
                l.lineTo(481.53622f, 221.99107f);
                l.cubicTo(481.07007f, 222.28723f, 480.4521f, 222.1494f, 480.1559f, 221.68323f);
                l.cubicTo(480.05408f, 221.52292f, 480.0f, 221.33693f, 480.0f, 221.147f);
                l.lineTo(480.0f, 191.00273f);
                l.lineTo(480.0f, 191.00273f);
                l.cubicTo(480.0f, 190.45044f, 480.44772f, 190.00273f, 481.0f, 190.00273f);
                l.cubicTo(481.19934f, 190.00273f, 481.39413f, 190.0623f, 481.5594f, 190.17381f);
                l.lineTo(504.5684f, 205.70087f);
                l.cubicTo(505.02618f, 206.00981f, 505.14688f, 206.63136f, 504.83795f, 207.08916f);
                l.cubicTo(504.761f, 207.20319f, 504.66135f, 207.3001f, 504.54526f, 207.37386f);
                l.lineTo(504.54526f, 207.37386f);
                l.close();
                l.moveTo(511.0f, 190.00006f);
                l.lineTo(517.0f, 190.00006f);
                l.lineTo(517.0f, 190.00006f);
                l.cubicTo(517.5523f, 190.00006f, 518.0f, 190.44777f, 518.0f, 191.00006f);
                l.lineTo(518.0f, 221.0f);
                l.lineTo(518.0f, 221.0f);
                l.cubicTo(518.0f, 221.55229f, 517.5523f, 222.0f, 517.0f, 222.0f);
                l.lineTo(511.0f, 222.0f);
                l.lineTo(511.0f, 222.0f);
                l.cubicTo(510.44772f, 222.0f, 510.0f, 221.55229f, 510.0f, 221.0f);
                l.lineTo(510.0f, 191.00006f);
                l.lineTo(510.0f, 191.00006f);
                l.cubicTo(510.0f, 190.44777f, 510.44772f, 190.00006f, 511.0f, 190.00006f);
                l.lineTo(511.0f, 190.00006f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
