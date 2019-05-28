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

public final class aoq extends c {
    private final int height = 36;
    private final int width = 36;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 36;
            case 1:
                return 36;
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
                a.setColor(-15819547);
                Path l = c.l(looper);
                l.moveTo(18.0f, 36.0f);
                l.cubicTo(8.058874f, 36.0f, 0.0f, 27.941126f, 0.0f, 18.0f);
                l.cubicTo(0.0f, 8.058874f, 8.058874f, 0.0f, 18.0f, 0.0f);
                l.cubicTo(27.941126f, 0.0f, 36.0f, 8.058874f, 36.0f, 18.0f);
                l.cubicTo(36.0f, 27.941126f, 27.941126f, 36.0f, 18.0f, 36.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-1);
                l = c.l(looper);
                l.moveTo(15.882187f, 21.850769f);
                l.lineTo(25.960957f, 11.772f);
                l.lineTo(27.873507f, 13.684549f);
                l.lineTo(17.159441f, 24.394556f);
                l.cubicTo(16.45635f, 25.097353f, 15.316654f, 25.097116f, 14.613856f, 24.394026f);
                l.cubicTo(14.613791f, 24.39396f, 14.613726f, 24.393896f, 14.613661f, 24.393831f);
                l.lineTo(9.0f, 18.775719f);
                l.lineTo(10.903567f, 16.87215f);
                l.lineTo(15.882187f, 21.850769f);
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
