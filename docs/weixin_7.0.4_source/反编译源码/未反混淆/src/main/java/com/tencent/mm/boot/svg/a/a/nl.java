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

public final class nl extends c {
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
                Paint a = c.a(k, looper);
                a.setColor(-1);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 3.5f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(18.55476f, 10.685851f);
                l.lineTo(18.55476f, 1.9568864f);
                l.lineTo(1.4761076f, 1.9568864f);
                l.lineTo(1.4761076f, 10.368928f);
                l.lineTo(6.1992455f, 6.5492587f);
                l.cubicTo(6.661799f, 6.175185f, 7.4046254f, 6.193327f, 7.8504953f, 6.5850835f);
                l.lineTo(12.326923f, 10.518227f);
                l.lineTo(14.609102f, 8.5774975f);
                l.cubicTo(15.071318f, 8.184438f, 15.806723f, 8.192423f, 16.255432f, 8.595083f);
                l.lineTo(18.55476f, 10.685851f);
                l.close();
                l.moveTo(18.55476f, 12.52428f);
                l.lineTo(15.40987f, 9.694547f);
                l.lineTo(13.2216625f, 11.555364f);
                l.lineTo(14.566126f, 12.736655f);
                l.lineTo(12.794854f, 12.736655f);
                l.lineTo(6.9897428f, 7.6767383f);
                l.lineTo(1.4761076f, 12.135694f);
                l.lineTo(1.4761076f, 15.028442f);
                l.lineTo(18.55476f, 15.028442f);
                l.lineTo(18.55476f, 12.52428f);
                l.close();
                l.moveTo(0.9918031f, 0.5f);
                l.lineTo(19.008198f, 0.5f);
                l.cubicTo(19.544695f, 0.5f, 20.0f, 0.981137f, 20.0f, 1.5746496f);
                l.lineTo(20.0f, 15.42535f);
                l.cubicTo(20.0f, 16.021152f, 19.555954f, 16.5f, 19.008198f, 16.5f);
                l.lineTo(0.9918031f, 16.5f);
                l.cubicTo(0.45530558f, 16.5f, 0.0f, 16.018864f, 0.0f, 15.42535f);
                l.lineTo(0.0f, 1.5746496f);
                l.cubicTo(0.0f, 0.9788482f, 0.44404536f, 0.5f, 0.9918031f, 0.5f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
