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

public final class atu extends c {
    private final int height = 45;
    private final int width = 45;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 45;
            case 1:
                return 45;
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
                canvas.saveLayerAlpha(null, 38, 4);
                Paint a = c.a(k, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 4.0f, 0.0f, 1.0f, 3.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = c.a(g, 1.0f, 0.0f, 0.5f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(9.457563f, 7.8087344f);
                l.cubicTo(11.167546f, 6.0274277f, 13.166591f, 5.1481767f, 14.952687f, 4.761591f);
                l.cubicTo(14.593289f, 4.2669635f, 14.3813095f, 3.65827f, 14.3813095f, 3.0f);
                l.cubicTo(14.3813095f, 1.3429188f, 15.724614f, 0.0f, 17.38131f, 0.0f);
                l.cubicTo(19.038004f, 0.0f, 20.38131f, 1.3429188f, 20.38131f, 3.0f);
                l.cubicTo(20.38131f, 3.65827f, 20.169329f, 4.2669635f, 19.80993f, 4.761591f);
                l.cubicTo(23.826532f, 5.630951f, 28.920044f, 8.991799f, 29.38131f, 19.5f);
                l.cubicTo(29.192793f, 23.44757f, 29.636072f, 26.433947f, 30.30884f, 28.660011f);
                l.lineTo(37.4661f, 35.81727f);
                l.cubicTo(37.86362f, 36.214794f, 37.86378f, 36.846252f, 37.474403f, 37.23563f);
                l.lineTo(36.61694f, 38.093094f);
                l.cubicTo(36.2272f, 38.482834f, 35.59254f, 38.478752f, 35.198578f, 38.08479f);
                l.lineTo(0.094642155f, 2.980852f);
                l.cubicTo(-0.30288154f, 2.5833282f, -0.3030391f, 1.9518675f, 0.08633687f, 1.5624915f);
                l.lineTo(0.9438008f, 0.7050276f);
                l.cubicTo(1.3335396f, 0.3152888f, 1.9681984f, 0.31937f, 2.3621612f, 0.71333283f);
                l.lineTo(9.457563f, 7.8087344f);
                l.close();
                l.moveTo(6.360238f, 13.343368f);
                l.lineTo(29.01687f, 36.0f);
                l.lineTo(0.8813093f, 36.0f);
                l.lineTo(0.8813093f, 34.5f);
                l.cubicTo(0.8813093f, 34.5f, 5.943809f, 31.278849f, 5.3813095f, 19.5f);
                l.cubicTo(5.487063f, 17.090797f, 5.836307f, 15.05729f, 6.360238f, 13.343368f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
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
