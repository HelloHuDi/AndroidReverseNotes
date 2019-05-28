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

public final class xv extends c {
    private final int height = 24;
    private final int width = 24;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 24;
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
                canvas.save();
                c.a(k2, looper).setStrokeWidth(1.0f);
                g = c.a(g, 1.0f, 0.0f, -175.0f, 0.0f, 1.0f, -368.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-11048043);
                g = c.a(g, 1.0f, 0.0f, 7.0f, 0.0f, 1.0f, 339.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(179.0f, 40.0f);
                l.lineTo(179.0f, 30.0f);
                l.cubicTo(179.0f, 29.447716f, 179.44771f, 29.0f, 180.0f, 29.0f);
                l.cubicTo(180.55229f, 29.0f, 181.0f, 29.447716f, 181.0f, 30.0f);
                l.lineTo(181.0f, 40.0f);
                l.lineTo(191.0f, 40.0f);
                l.cubicTo(191.55229f, 40.0f, 192.0f, 40.447716f, 192.0f, 41.0f);
                l.cubicTo(192.0f, 41.552284f, 191.55229f, 42.0f, 191.0f, 42.0f);
                l.lineTo(181.0f, 42.0f);
                l.lineTo(181.0f, 52.0f);
                l.cubicTo(181.0f, 52.552284f, 180.55229f, 53.0f, 180.0f, 53.0f);
                l.cubicTo(179.44771f, 53.0f, 179.0f, 52.552284f, 179.0f, 52.0f);
                l.lineTo(179.0f, 42.0f);
                l.lineTo(169.0f, 42.0f);
                l.cubicTo(168.44771f, 42.0f, 168.0f, 41.552284f, 168.0f, 41.0f);
                l.cubicTo(168.0f, 40.447716f, 168.44771f, 40.0f, 169.0f, 40.0f);
                l.lineTo(179.0f, 40.0f);
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
