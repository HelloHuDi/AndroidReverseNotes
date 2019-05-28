package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class anv extends c {
    private final int height = az.CTRL_INDEX;
    private final int width = az.CTRL_INDEX;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return az.CTRL_INDEX;
            case 1:
                return az.CTRL_INDEX;
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
                a.setColor(-13421773);
                Path l = c.l(looper);
                l.moveTo(96.0f, 96.249916f);
                l.cubicTo(92.54822f, 96.249916f, 89.75f, 93.4517f, 89.75f, 89.999916f);
                l.cubicTo(89.75f, 86.54813f, 92.54822f, 83.749916f, 96.0f, 83.749916f);
                l.cubicTo(99.45178f, 83.749916f, 102.25f, 86.54813f, 102.25f, 89.999916f);
                l.cubicTo(102.25f, 93.4517f, 99.45178f, 96.249916f, 96.0f, 96.249916f);
                l.moveTo(126.0f, 63.005955f);
                l.cubicTo(126.0f, 61.345814f, 124.66269f, 60.0f, 123.00407f, 60.0f);
                l.lineTo(68.99594f, 60.0f);
                l.cubicTo(67.341324f, 60.0f, 66.0f, 61.347015f, 66.0f, 63.005955f);
                l.lineTo(66.0f, 65.80777f);
                l.cubicTo(66.0f, 76.38241f, 75.167145f, 85.296455f, 87.69257f, 88.081665f);
                l.cubicTo(87.52628f, 88.75229f, 87.42857f, 89.44967f, 87.42857f, 90.17208f);
                l.cubicTo(87.42857f, 90.45863f, 87.444f, 90.74173f, 87.47143f, 91.02137f);
                l.cubicTo(79.20257f, 89.72672f, 71.797714f, 86.58592f, 66.0f, 82.178955f);
                l.lineTo(66.0f, 132.00877f);
                l.cubicTo(66.0f, 133.66078f, 67.33731f, 135.0f, 68.99594f, 135.0f);
                l.lineTo(123.00407f, 135.0f);
                l.cubicTo(124.658676f, 135.0f, 126.0f, 133.65459f, 126.0f, 132.00877f);
                l.lineTo(126.0f, 82.178955f);
                l.cubicTo(120.202286f, 86.58592f, 112.79743f, 89.72672f, 104.52857f, 91.02137f);
                l.cubicTo(104.556f, 90.74173f, 104.57143f, 90.45863f, 104.57143f, 90.17208f);
                l.cubicTo(104.57143f, 89.44967f, 104.47372f, 88.75229f, 104.30743f, 88.081665f);
                l.cubicTo(116.832855f, 85.296455f, 126.0f, 76.38241f, 126.0f, 65.80777f);
                l.lineTo(126.0f, 63.005955f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
