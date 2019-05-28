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

public final class amn extends c {
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
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-1);
                g = c.a(g, 1.0f, 0.0f, 19.0f, 0.0f, 1.0f, 21.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(3.0f, 6.0f);
                l.cubicTo(19.673405f, 4.218915f, 36.356895f, 2.132536f, 53.0f, -3.5527137E-15f);
                l.cubicTo(54.563484f, -0.26629594f, 56.399273f, 0.39892635f, 57.0f, 2.0f);
                l.cubicTo(57.15578f, 5.3276186f, 56.88344f, 8.673888f, 57.0f, 12.0f);
                l.cubicTo(38.97945f, 10.115204f, 20.994768f, 8.169932f, 3.0f, 6.0f);
                l.lineTo(3.0f, 6.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                l = c.l(looper);
                l.moveTo(1.0f, 10.0f);
                l.cubicTo(2.8582108f, 9.652563f, 4.5471535f, 10.303478f, 6.0f, 10.0f);
                l.cubicTo(22.725773f, 12.346351f, 39.365356f, 14.088799f, 56.0f, 16.0f);
                l.cubicTo(57.334106f, 16.161715f, 58.083637f, 17.643797f, 58.0f, 19.0f);
                l.cubicTo(58.00369f, 29.600607f, 57.993694f, 40.325684f, 58.0f, 51.0f);
                l.cubicTo(58.253532f, 52.72311f, 56.764465f, 54.375435f, 55.0f, 54.0f);
                l.cubicTo(37.66642f, 51.972057f, 20.307287f, 49.959225f, 3.0f, 48.0f);
                l.cubicTo(1.2891929f, 48.07658f, -0.20986862f, 46.794777f, -3.5527137E-15f, 45.0f);
                l.cubicTo(-0.039974976f, 34.657715f, 0.069956206f, 24.263103f, -3.5527137E-15f, 14.0f);
                l.cubicTo(0.07994995f, 12.616731f, -0.14990616f, 10.82421f, 1.0f, 10.0f);
                l.lineTo(1.0f, 10.0f);
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
