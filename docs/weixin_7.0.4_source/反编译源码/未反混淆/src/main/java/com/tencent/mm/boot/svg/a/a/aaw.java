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

public final class aaw extends c {
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
                l.moveTo(15.0f, 9.0f);
                l.cubicTo(15.0f, 7.343146f, 16.343145f, 6.0f, 18.0f, 6.0f);
                l.lineTo(54.0f, 6.0f);
                l.cubicTo(55.656853f, 6.0f, 57.0f, 7.343146f, 57.0f, 9.0f);
                l.lineTo(57.0f, 63.0f);
                l.cubicTo(57.0f, 64.65685f, 55.656853f, 66.0f, 54.0f, 66.0f);
                l.lineTo(18.0f, 66.0f);
                l.cubicTo(16.343145f, 66.0f, 15.0f, 64.65685f, 15.0f, 63.0f);
                l.lineTo(15.0f, 9.0f);
                l.close();
                l.moveTo(18.6f, 9.6f);
                l.lineTo(18.6f, 62.4f);
                l.lineTo(53.4f, 62.4f);
                l.lineTo(53.4f, 9.6f);
                l.lineTo(18.6f, 9.6f);
                l.close();
                l.moveTo(36.0f, 60.0f);
                l.cubicTo(34.343147f, 60.0f, 33.0f, 58.656853f, 33.0f, 57.0f);
                l.cubicTo(33.0f, 55.343147f, 34.343147f, 54.0f, 36.0f, 54.0f);
                l.cubicTo(37.656853f, 54.0f, 39.0f, 55.343147f, 39.0f, 57.0f);
                l.cubicTo(39.0f, 58.656853f, 37.656853f, 60.0f, 36.0f, 60.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
