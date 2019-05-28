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

public final class wh extends c {
    private final int height = 54;
    private final int width = 60;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 54;
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
                a.setColor(-2171170);
                g = c.a(g, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 3.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(1.049754f, 4.9430923f);
                l.cubicTo(0.7401684f, 3.184852f, 1.8986177f, 1.0170214f, 3.875971f, 1.1069314f);
                l.cubicTo(19.59493f, 0.9670714f, 35.333862f, 1.0769614f, 51.052822f, 1.0569814f);
                l.cubicTo(52.84043f, 0.7173214f, 54.937622f, 1.9261116f, 54.897675f, 3.884152f);
                l.cubicTo(55.05746f, 14.303724f, 54.937622f, 24.743277f, 54.957596f, 35.16285f);
                l.cubicTo(55.247208f, 36.92109f, 54.02884f, 39.088917f, 52.051487f, 38.95905f);
                l.cubicTo(42.384426f, 39.088917f, 32.70738f, 38.96904f, 23.030333f, 39.009f);
                l.cubicTo(18.686148f, 41.99601f, 14.361935f, 45.003f, 10.027737f, 48.0f);
                l.lineTo(10.027737f, 39.009f);
                l.cubicTo(7.1515865f, 38.599407f, 2.7974145f, 40.32768f, 1.1995535f, 37.04097f);
                l.cubicTo(0.8400347f, 26.351665f, 1.129647f, 15.632394f, 1.049754f, 4.9430923f);
                l.lineTo(1.049754f, 4.9430923f);
                l.close();
                l.moveTo(7.0f, 7.0f);
                l.lineTo(7.0f, 32.991615f);
                l.lineTo(15.0f, 32.991615f);
                l.cubicTo(15.0f, 34.661076f, 15.0f, 36.33054f, 15.01f, 38.0f);
                l.cubicTo(17.34f, 36.32054f, 19.68f, 34.65108f, 22.03f, 32.981617f);
                l.cubicTo(31.02f, 33.001614f, 40.01f, 32.991615f, 49.0f, 32.991615f);
                l.lineTo(49.0f, 7.0f);
                l.lineTo(7.0f, 7.0f);
                l.lineTo(7.0f, 7.0f);
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
