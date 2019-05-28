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

public final class aab extends c {
    private final int height = 72;
    private final int width = 72;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                k.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(18.0f, 19.5f);
                l.lineTo(18.0f, 15.0f);
                l.cubicTo(18.0f, 13.343145f, 19.343145f, 12.0f, 21.0f, 12.0f);
                l.lineTo(63.0f, 12.0f);
                l.cubicTo(64.65685f, 12.0f, 66.0f, 13.343145f, 66.0f, 15.0f);
                l.lineTo(66.0f, 45.0f);
                l.cubicTo(66.0f, 46.656853f, 64.65685f, 48.0f, 63.0f, 48.0f);
                l.lineTo(58.5f, 48.0f);
                l.lineTo(58.5f, 24.0f);
                l.cubicTo(58.5f, 21.514719f, 56.485283f, 19.5f, 54.0f, 19.5f);
                l.lineTo(18.0f, 19.5f);
                l.close();
                l.moveTo(9.0f, 24.0f);
                l.lineTo(51.0f, 24.0f);
                l.cubicTo(52.656853f, 24.0f, 54.0f, 25.343145f, 54.0f, 27.0f);
                l.lineTo(54.0f, 57.0f);
                l.cubicTo(54.0f, 58.656853f, 52.656853f, 60.0f, 51.0f, 60.0f);
                l.lineTo(9.0f, 60.0f);
                l.cubicTo(7.343146f, 60.0f, 6.0f, 58.656853f, 6.0f, 57.0f);
                l.lineTo(6.0f, 27.0f);
                l.cubicTo(6.0f, 25.343145f, 7.343146f, 24.0f, 9.0f, 24.0f);
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
