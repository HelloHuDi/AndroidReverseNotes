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

public final class agx extends c {
    private final int height = 240;
    private final int width = 240;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 240;
            case 1:
                return 240;
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
                canvas.saveLayerAlpha(null, 204, 4);
                Paint a = c.a(k, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 83.0f, 0.0f, 1.0f, 91.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(32.8514f, 18.0f);
                l.lineTo(15.0f, 18.0f);
                l.lineTo(15.0f, 30.0f);
                l.lineTo(0.0f, 15.0f);
                l.lineTo(15.0f, 0.0f);
                l.lineTo(15.0f, 12.0f);
                l.lineTo(52.5f, 12.0f);
                l.cubicTo(64.92641f, 12.0f, 75.0f, 22.073593f, 75.0f, 34.5f);
                l.cubicTo(75.0f, 46.926407f, 64.92641f, 57.0f, 52.5f, 57.0f);
                l.lineTo(28.0f, 57.0f);
                l.lineTo(28.0f, 51.0f);
                l.lineTo(28.5f, 51.0f);
                l.lineTo(32.8514f, 51.0f);
                l.lineTo(37.202793f, 51.0f);
                l.lineTo(52.5f, 51.0f);
                l.cubicTo(61.612698f, 51.0f, 69.0f, 43.612698f, 69.0f, 34.5f);
                l.cubicTo(69.0f, 25.387302f, 61.612698f, 18.0f, 52.5f, 18.0f);
                l.lineTo(32.8514f, 18.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
