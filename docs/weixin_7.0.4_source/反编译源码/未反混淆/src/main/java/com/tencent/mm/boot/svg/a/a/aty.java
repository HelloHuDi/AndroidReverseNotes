package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.k.ae;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class aty extends c {
    private final int height = 96;
    private final int width = ae.CTRL_INDEX;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return ae.CTRL_INDEX;
            case 1:
                return 96;
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
                k = c.a(k, looper);
                k.setColor(419430400);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(0.0f, 9.00051f);
                l.cubicTo(0.0f, 4.0296655f, 4.0212784f, 0.0f, 8.997707f, 0.0f);
                l.lineTo(575.0023f, 0.0f);
                l.cubicTo(579.9716f, 0.0f, 584.0f, 4.0326095f, 584.0f, 9.00051f);
                l.lineTo(584.0f, 76.99949f);
                l.cubicTo(584.0f, 81.97034f, 579.9787f, 86.0f, 575.0023f, 86.0f);
                l.lineTo(8.997707f, 86.0f);
                l.cubicTo(4.028411f, 86.0f, 0.0f, 81.96739f, 0.0f, 76.99949f);
                l.lineTo(0.0f, 9.00051f);
                l.close();
                l.moveTo(113.04867f, 96.0f);
                l.lineTo(104.0f, 86.0f);
                l.lineTo(122.09733f, 86.0f);
                l.lineTo(113.04867f, 96.0f);
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
