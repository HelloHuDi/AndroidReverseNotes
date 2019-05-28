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

public final class acw extends c {
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
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                Path l = c.l(looper);
                l.moveTo(48.0f, 37.500957f);
                l.cubicTo(44.632545f, 35.047546f, 40.48532f, 33.6f, 36.0f, 33.6f);
                l.cubicTo(30.366695f, 33.6f, 25.266695f, 35.883347f, 21.575022f, 39.57502f);
                l.lineTo(19.029438f, 37.029438f);
                l.cubicTo(23.372583f, 32.68629f, 29.372583f, 30.0f, 36.0f, 30.0f);
                l.cubicTo(40.371445f, 30.0f, 44.46992f, 31.168732f, 48.0f, 33.210773f);
                l.lineTo(48.0f, 37.500957f);
                l.close();
                l.moveTo(48.0f, 27.152483f);
                l.cubicTo(44.335747f, 25.512175f, 40.2744f, 24.6f, 36.0f, 24.6f);
                l.cubicTo(27.881414f, 24.6f, 20.531414f, 27.890707f, 15.211061f, 33.21106f);
                l.lineTo(12.665476f, 30.665476f);
                l.cubicTo(18.637302f, 24.693651f, 26.887302f, 21.0f, 36.0f, 21.0f);
                l.cubicTo(40.2335f, 21.0f, 44.28081f, 21.79719f, 48.0f, 23.249641f);
                l.lineTo(48.0f, 27.152483f);
                l.close();
                l.moveTo(31.757359f, 49.75736f);
                l.cubicTo(32.843147f, 48.671574f, 34.343147f, 48.0f, 36.0f, 48.0f);
                l.cubicTo(37.656853f, 48.0f, 39.156853f, 48.671574f, 40.24264f, 49.75736f);
                l.lineTo(36.0f, 54.0f);
                l.lineTo(31.757359f, 49.75736f);
                l.close();
                l.moveTo(44.061016f, 45.938984f);
                l.cubicTo(41.998024f, 43.875988f, 39.14802f, 42.6f, 36.0f, 42.6f);
                l.cubicTo(32.85198f, 42.6f, 30.001976f, 43.875988f, 27.938982f, 45.938984f);
                l.lineTo(25.393398f, 43.3934f);
                l.cubicTo(28.107864f, 40.678932f, 31.857864f, 39.0f, 36.0f, 39.0f);
                l.cubicTo(40.142136f, 39.0f, 43.892136f, 40.678932f, 46.6066f, 43.3934f);
                l.lineTo(44.061016f, 45.938984f);
                l.close();
                l.moveTo(51.473682f, 25.5f);
                l.lineTo(55.026318f, 25.5f);
                l.lineTo(54.789474f, 44.526318f);
                l.lineTo(51.710526f, 44.526318f);
                l.lineTo(51.473682f, 25.5f);
                l.close();
                l.moveTo(53.25f, 54.17763f);
                l.cubicTo(51.986843f, 54.17763f, 51.0f, 53.19079f, 51.0f, 51.92763f);
                l.cubicTo(51.0f, 50.644737f, 51.986843f, 49.67763f, 53.25f, 49.67763f);
                l.cubicTo(54.532894f, 49.67763f, 55.5f, 50.644737f, 55.5f, 51.92763f);
                l.cubicTo(55.5f, 53.19079f, 54.532894f, 54.17763f, 53.25f, 54.17763f);
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
