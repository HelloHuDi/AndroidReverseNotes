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

public final class abs extends c {
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
                l.moveTo(48.0f, 54.0f);
                l.lineTo(48.0f, 63.0f);
                l.cubicTo(48.0f, 64.65685f, 46.656853f, 66.0f, 45.0f, 66.0f);
                l.lineTo(15.0f, 66.0f);
                l.cubicTo(13.343145f, 66.0f, 12.0f, 64.65685f, 12.0f, 63.0f);
                l.lineTo(12.0f, 21.0f);
                l.cubicTo(12.0f, 19.343145f, 13.343145f, 18.0f, 15.0f, 18.0f);
                l.lineTo(24.0f, 18.0f);
                l.lineTo(24.0f, 9.0f);
                l.cubicTo(24.0f, 7.343146f, 25.343145f, 6.0f, 27.0f, 6.0f);
                l.lineTo(57.0f, 6.0f);
                l.cubicTo(58.656853f, 6.0f, 60.0f, 7.343146f, 60.0f, 9.0f);
                l.lineTo(60.0f, 51.0f);
                l.cubicTo(60.0f, 52.656853f, 58.656853f, 54.0f, 57.0f, 54.0f);
                l.lineTo(48.0f, 54.0f);
                l.close();
                l.moveTo(48.0f, 50.4f);
                l.lineTo(56.4f, 50.4f);
                l.lineTo(56.4f, 9.6f);
                l.lineTo(27.6f, 9.6f);
                l.lineTo(27.6f, 18.0f);
                l.lineTo(45.0f, 18.0f);
                l.cubicTo(46.656853f, 18.0f, 48.0f, 19.343145f, 48.0f, 21.0f);
                l.lineTo(48.0f, 50.4f);
                l.close();
                l.moveTo(44.4f, 62.4f);
                l.lineTo(44.4f, 21.6f);
                l.lineTo(15.6f, 21.6f);
                l.lineTo(15.6f, 62.4f);
                l.lineTo(44.4f, 62.4f);
                l.close();
                l.moveTo(30.0f, 60.0f);
                l.cubicTo(28.343145f, 60.0f, 27.0f, 58.656853f, 27.0f, 57.0f);
                l.cubicTo(27.0f, 55.343147f, 28.343145f, 54.0f, 30.0f, 54.0f);
                l.cubicTo(31.656855f, 54.0f, 33.0f, 55.343147f, 33.0f, 57.0f);
                l.cubicTo(33.0f, 58.656853f, 31.656855f, 60.0f, 30.0f, 60.0f);
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
