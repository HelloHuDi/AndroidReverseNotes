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

public final class afa extends c {
    private final int height = 34;
    private final int width = 34;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 34;
            case 1:
                return 34;
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
                Paint a = c.a(k2, looper);
                a.setStrokeWidth(1.0f);
                canvas.saveLayerAlpha(null, 76, 4);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, -171.0f, 0.0f, 1.0f, -553.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 171.0f, 0.0f, 1.0f, 553.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 6.8f, 0.0f, 1.0f, 9.35f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(WebView.NIGHT_MODE_COLOR);
                a2.setStrokeWidth(2.016f);
                Path l = c.l(looper);
                l.moveTo(1.0626365f, 9.508f);
                l.cubicTo(1.5646234f, 14.110367f, 5.464044f, 17.692f, 10.2f, 17.692f);
                l.cubicTo(14.935956f, 17.692f, 18.835377f, 14.110367f, 19.337364f, 9.508f);
                l.lineTo(1.0626365f, 9.508f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(k, looper);
                a2.setColor(WebView.NIGHT_MODE_COLOR);
                l = c.l(looper);
                l.moveTo(4.25f, 5.1f);
                l.cubicTo(2.8416739f, 5.1f, 1.7f, 3.958326f, 1.7f, 2.55f);
                l.cubicTo(1.7f, 1.1416739f, 2.8416739f, 0.0f, 4.25f, 0.0f);
                l.cubicTo(5.658326f, 0.0f, 6.8f, 1.1416739f, 6.8f, 2.55f);
                l.cubicTo(6.8f, 3.958326f, 5.658326f, 5.1f, 4.25f, 5.1f);
                l.close();
                l.moveTo(16.15f, 5.1f);
                l.cubicTo(14.741673f, 5.1f, 13.6f, 3.958326f, 13.6f, 2.55f);
                l.cubicTo(13.6f, 1.1416739f, 14.741673f, 0.0f, 16.15f, 0.0f);
                l.cubicTo(17.558327f, 0.0f, 18.7f, 1.1416739f, 18.7f, 2.55f);
                l.cubicTo(18.7f, 3.958326f, 17.558327f, 5.1f, 16.15f, 5.1f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a2 = c.a(k, looper);
                a2.setColor(WebView.NIGHT_MODE_COLOR);
                l = c.l(looper);
                l.moveTo(17.0f, 34.0f);
                l.cubicTo(7.6111593f, 34.0f, 0.0f, 26.388842f, 0.0f, 17.0f);
                l.cubicTo(0.0f, 7.6111593f, 7.6111593f, 0.0f, 17.0f, 0.0f);
                l.cubicTo(26.388842f, 0.0f, 34.0f, 7.6111593f, 34.0f, 17.0f);
                l.cubicTo(34.0f, 26.388842f, 26.388842f, 34.0f, 17.0f, 34.0f);
                l.close();
                l.moveTo(17.0f, 32.3f);
                l.cubicTo(25.449957f, 32.3f, 32.3f, 25.449957f, 32.3f, 17.0f);
                l.cubicTo(32.3f, 8.550043f, 25.449957f, 1.7f, 17.0f, 1.7f);
                l.cubicTo(8.550043f, 1.7f, 1.7f, 8.550043f, 1.7f, 17.0f);
                l.cubicTo(1.7f, 25.449957f, 8.550043f, 32.3f, 17.0f, 32.3f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
