package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class awa extends c {
    private final int height = 46;
    private final int width = 46;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 46;
            case 1:
                return 46;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.h(looper);
                c.g(looper);
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
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-499359);
                Path l = c.l(looper);
                l.moveTo(23.0f, 0.0f);
                l.cubicTo(35.70255f, 0.0f, 46.0f, 10.29745f, 46.0f, 23.0f);
                l.cubicTo(46.0f, 35.70255f, 35.70255f, 46.0f, 23.0f, 46.0f);
                l.cubicTo(10.29745f, 46.0f, 0.0f, 35.70255f, 0.0f, 23.0f);
                l.cubicTo(0.0f, 10.29745f, 10.29745f, 0.0f, 23.0f, 0.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-1);
                l = c.l(looper);
                l.moveTo(29.85458f, 16.970005f);
                l.cubicTo(29.680027f, 15.727787f, 29.348436f, 14.533834f, 28.44f, 13.570005f);
                l.cubicTo(25.85f, 10.150005f, 20.18f, 10.140005f, 17.59f, 13.560005f);
                l.cubicTo(15.97f, 15.310005f, 16.18f, 17.790005f, 15.83f, 19.970005f);
                l.lineTo(13.0f, 19.970005f);
                l.cubicTo(13.01f, 24.310005f, 13.01f, 28.640005f, 13.01f, 32.970005f);
                l.lineTo(33.01f, 32.970005f);
                l.cubicTo(33.01f, 28.640005f, 33.01f, 24.310005f, 33.02f, 19.970005f);
                l.lineTo(31.605f, 19.970005f);
                l.lineTo(26.1f, 19.970005f);
                l.lineTo(18.83f, 19.970005f);
                l.cubicTo(18.81f, 17.350006f, 19.72f, 13.870006f, 23.0f, 13.970005f);
                l.cubicTo(25.080025f, 13.887314f, 26.22539f, 15.273373f, 26.773254f, 16.970005f);
                l.lineTo(29.85458f, 16.970005f);
                l.lineTo(29.85458f, 16.970005f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
