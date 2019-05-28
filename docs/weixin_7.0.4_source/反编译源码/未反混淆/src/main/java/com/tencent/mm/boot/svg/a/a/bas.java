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

public final class bas extends c {
    private final int height = 52;
    private final int width = 66;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 66;
            case 1:
                return 52;
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
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-9139786);
                g = c.a(g, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(19.4f, 0.0f);
                l.lineTo(45.39f, 0.0f);
                l.cubicTo(45.87f, 1.9689571f, 46.06f, 3.9878876f, 46.12f, 6.0068183f);
                l.cubicTo(51.06f, 6.086776f, 56.02f, 5.7569504f, 60.95f, 6.1567388f);
                l.cubicTo(63.61f, 6.2666807f, 65.29f, 8.605442f, 66.0f, 10.944203f);
                l.lineTo(66.0f, 43.96671f);
                l.cubicTo(65.34f, 46.72525f, 63.07f, 49.06401f, 60.08f, 48.904095f);
                l.cubicTo(42.37f, 49.06401f, 24.65f, 48.944073f, 6.93f, 48.964066f);
                l.cubicTo(3.74f, 49.293888f, 0.86f, 47.324932f, 0.0f, 44.226574f);
                l.lineTo(0.0f, 11.014166f);
                l.cubicTo(0.67f, 8.955256f, 1.89f, 6.726437f, 4.23f, 6.2966647f);
                l.cubicTo(9.06f, 5.6270194f, 13.96f, 6.1367493f, 18.82f, 6.0068183f);
                l.cubicTo(19.05f, 4.007877f, 19.27f, 2.008936f, 19.4f, 0.0f);
                l.lineTo(19.4f, 0.0f);
                l.close();
                l.moveTo(28.390493f, 10.6254015f);
                l.cubicTo(21.38109f, 12.364714f, 15.771568f, 18.70221f, 15.111625f, 25.929352f);
                l.cubicTo(14.381687f, 32.00695f, 17.28144f, 38.294464f, 22.351007f, 41.723106f);
                l.cubicTo(29.330412f, 46.68115f, 39.75952f, 45.961433f, 45.879f, 39.913822f);
                l.cubicTo(50.78858f, 35.275658f, 52.328453f, 27.618683f, 49.798668f, 21.391146f);
                l.cubicTo(46.728928f, 13.064437f, 36.919765f, 8.196362f, 28.390493f, 10.6254015f);
                l.lineTo(28.390493f, 10.6254015f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(29.357378f, 16.571178f);
                l.cubicTo(35.96738f, 14.336706f, 44.02519f, 18.905405f, 44.86392f, 25.967936f);
                l.cubicTo(45.942287f, 32.382072f, 40.450596f, 38.576748f, 34.090218f, 38.925884f);
                l.cubicTo(27.719856f, 39.68401f, 21.17975f, 34.526764f, 21.019993f, 28.002903f);
                l.cubicTo(20.69049f, 22.835684f, 24.474766f, 18.017601f, 29.357378f, 16.571178f);
                l.lineTo(29.357378f, 16.571178f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
