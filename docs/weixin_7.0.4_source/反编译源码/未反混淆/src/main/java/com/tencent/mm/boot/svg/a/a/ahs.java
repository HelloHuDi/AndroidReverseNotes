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

public final class ahs extends c {
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
                k2 = c.a(k, looper);
                k2.setColor(-14046139);
                Path l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(96.0f, 0.0f);
                l.lineTo(96.0f, 96.0f);
                l.lineTo(0.0f, 96.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.saveLayerAlpha(null, 0, 4);
                canvas.drawPath(l, c.a(k2, looper));
                canvas.restore();
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                g = c.a(g, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 12.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.saveLayerAlpha(null, 204, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l2 = c.l(looper);
                l2.moveTo(20.25f, 36.0f);
                l2.cubicTo(20.25f, 38.89905f, 17.89905f, 41.25f, 15.0f, 41.25f);
                l2.cubicTo(12.10095f, 41.25f, 9.75f, 38.89905f, 9.75f, 36.0f);
                l2.cubicTo(9.75f, 33.0999f, 12.10095f, 30.75f, 15.0f, 30.75f);
                l2.cubicTo(17.89905f, 30.75f, 20.25f, 33.0999f, 20.25f, 36.0f);
                l2.close();
                l2.moveTo(36.0f, 30.75f);
                l2.cubicTo(38.89905f, 30.75f, 41.25f, 33.0999f, 41.25f, 36.0f);
                l2.cubicTo(41.25f, 38.89905f, 38.89905f, 41.25f, 36.0f, 41.25f);
                l2.cubicTo(33.10095f, 41.25f, 30.75f, 38.89905f, 30.75f, 36.0f);
                l2.cubicTo(30.75f, 33.0999f, 33.10095f, 30.75f, 36.0f, 30.75f);
                l2.close();
                l2.moveTo(57.0f, 30.75f);
                l2.cubicTo(59.89905f, 30.75f, 62.25f, 33.0999f, 62.25f, 36.0f);
                l2.cubicTo(62.25f, 38.89905f, 59.89905f, 41.25f, 57.0f, 41.25f);
                l2.cubicTo(54.10095f, 41.25f, 51.75f, 38.89905f, 51.75f, 36.0f);
                l2.cubicTo(51.75f, 33.0999f, 54.10095f, 30.75f, 57.0f, 30.75f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
