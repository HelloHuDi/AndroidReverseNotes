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

public final class az extends c {
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
                c.a(k2, looper).setStrokeWidth(1.0f);
                canvas.saveLayerAlpha(null, 51, 4);
                Paint a = c.a(k, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 3.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(16.972387f, 0.040298507f);
                l.lineTo(1.027612f, 0.040298507f);
                l.cubicTo(0.48358208f, 0.040298507f, 0.040298507f, 0.48358208f, 0.040298507f, 1.027612f);
                l.lineTo(0.040298507f, 16.972387f);
                l.cubicTo(0.040298507f, 17.516418f, 0.48358208f, 17.959702f, 1.027612f, 17.959702f);
                l.lineTo(9.611194f, 17.959702f);
                l.lineTo(9.611194f, 11.021642f);
                l.lineTo(7.2738805f, 11.021642f);
                l.lineTo(7.2738805f, 8.314925f);
                l.lineTo(9.611194f, 8.314925f);
                l.lineTo(9.611194f, 6.3201494f);
                l.cubicTo(9.611194f, 4.002985f, 11.028358f, 2.747015f, 13.090299f, 2.747015f);
                l.cubicTo(14.077612f, 2.747015f, 14.930597f, 2.8208954f, 15.179105f, 2.8544776f);
                l.lineTo(15.179105f, 5.272388f);
                l.lineTo(13.7485075f, 5.272388f);
                l.cubicTo(12.626865f, 5.272388f, 12.405224f, 5.802985f, 12.405224f, 6.588806f);
                l.lineTo(12.405224f, 8.314925f);
                l.lineTo(15.085074f, 8.314925f);
                l.lineTo(14.735821f, 11.021642f);
                l.lineTo(12.405224f, 11.021642f);
                l.lineTo(12.405224f, 17.966417f);
                l.lineTo(16.972387f, 17.966417f);
                l.cubicTo(17.516418f, 17.966417f, 17.959702f, 17.523134f, 17.959702f, 16.979105f);
                l.lineTo(17.959702f, 1.027612f);
                l.cubicTo(17.959702f, 0.47686568f, 17.523134f, 0.040298507f, 16.972387f, 0.040298507f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
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
