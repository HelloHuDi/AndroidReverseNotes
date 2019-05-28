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

public final class abi extends c {
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
                l.moveTo(66.0f, 30.0f);
                l.lineTo(69.0f, 30.0f);
                l.cubicTo(70.65685f, 30.0f, 72.0f, 31.343145f, 72.0f, 33.0f);
                l.lineTo(72.0f, 63.0f);
                l.cubicTo(72.0f, 64.65685f, 70.65685f, 66.0f, 69.0f, 66.0f);
                l.lineTo(51.0f, 66.0f);
                l.cubicTo(49.343147f, 66.0f, 48.0f, 64.65685f, 48.0f, 63.0f);
                l.lineTo(48.0f, 57.0f);
                l.lineTo(9.0f, 57.0f);
                l.cubicTo(7.343146f, 57.0f, 6.0f, 55.656853f, 6.0f, 54.0f);
                l.lineTo(6.0f, 15.0f);
                l.cubicTo(6.0f, 13.343145f, 7.343146f, 12.0f, 9.0f, 12.0f);
                l.lineTo(63.0f, 12.0f);
                l.cubicTo(64.65685f, 12.0f, 66.0f, 13.343145f, 66.0f, 15.0f);
                l.lineTo(66.0f, 30.0f);
                l.close();
                l.moveTo(62.4f, 30.0f);
                l.lineTo(62.4f, 15.6f);
                l.lineTo(9.6f, 15.6f);
                l.lineTo(9.6f, 53.4f);
                l.lineTo(48.0f, 53.4f);
                l.lineTo(48.0f, 33.0f);
                l.cubicTo(48.0f, 31.343145f, 49.343147f, 30.0f, 51.0f, 30.0f);
                l.lineTo(62.4f, 30.0f);
                l.close();
                l.moveTo(24.0f, 62.699997f);
                l.cubicTo(24.0f, 61.705887f, 24.797583f, 60.899998f, 25.79045f, 60.899998f);
                l.lineTo(43.209553f, 60.899998f);
                l.cubicTo(44.198387f, 60.899998f, 45.0f, 61.698956f, 45.0f, 62.699997f);
                l.lineTo(45.0f, 64.5f);
                l.lineTo(24.0f, 64.5f);
                l.lineTo(24.0f, 62.699997f);
                l.close();
                l.moveTo(51.6f, 33.6f);
                l.lineTo(51.6f, 62.4f);
                l.lineTo(68.4f, 62.4f);
                l.lineTo(68.4f, 33.6f);
                l.lineTo(51.6f, 33.6f);
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
