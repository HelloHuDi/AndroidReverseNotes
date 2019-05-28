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

public final class acs extends c {
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
                l.moveTo(26.545586f, 21.454414f);
                l.lineTo(33.87868f, 14.121321f);
                l.cubicTo(35.05025f, 12.949747f, 36.94975f, 12.949747f, 38.12132f, 14.121321f);
                l.cubicTo(38.68393f, 14.683929f, 39.0f, 15.446991f, 39.0f, 16.242641f);
                l.lineTo(39.0f, 33.90883f);
                l.lineTo(47.590534f, 42.499363f);
                l.cubicTo(48.822994f, 40.591305f, 49.5f, 38.35166f, 49.5f, 36.0f);
                l.cubicTo(49.5f, 32.77088f, 48.22353f, 29.752968f, 45.985283f, 27.514719f);
                l.lineTo(48.530865f, 24.969133f);
                l.cubicTo(51.353912f, 27.79218f, 53.1f, 31.692179f, 53.1f, 36.0f);
                l.cubicTo(53.1f, 39.39122f, 52.01791f, 42.5297f, 50.180176f, 45.08901f);
                l.lineTo(53.609615f, 48.518444f);
                l.cubicTo(56.362686f, 44.983818f, 57.9f, 40.616837f, 57.9f, 36.0f);
                l.cubicTo(57.9f, 30.51273f, 55.728367f, 25.378408f, 51.92498f, 21.575022f);
                l.lineTo(54.470562f, 19.029438f);
                l.cubicTo(58.81371f, 23.372583f, 61.5f, 29.372583f, 61.5f, 36.0f);
                l.cubicTo(61.5f, 41.712715f, 59.504047f, 46.959255f, 56.171463f, 51.080296f);
                l.lineTo(64.27494f, 59.183765f);
                l.lineTo(61.72935f, 61.72935f);
                l.lineTo(11.545586f, 11.545585f);
                l.lineTo(14.09117f, 9.0f);
                l.lineTo(26.545586f, 21.454414f);
                l.close();
                l.moveTo(36.0f, 30.908829f);
                l.lineTo(36.0f, 16.242641f);
                l.lineTo(28.666906f, 23.575735f);
                l.lineTo(36.0f, 30.908829f);
                l.close();
                l.moveTo(23.408829f, 28.5f);
                l.lineTo(9.0f, 28.5f);
                l.lineTo(9.0f, 43.5f);
                l.lineTo(23.742641f, 43.5f);
                l.lineTo(36.0f, 55.75736f);
                l.lineTo(36.0f, 41.09117f);
                l.lineTo(39.0f, 44.09117f);
                l.lineTo(39.0f, 55.75736f);
                l.cubicTo(39.0f, 57.414215f, 37.656853f, 58.75736f, 36.0f, 58.75736f);
                l.cubicTo(35.20435f, 58.75736f, 34.441288f, 58.441288f, 33.87868f, 57.87868f);
                l.lineTo(22.5f, 46.5f);
                l.lineTo(9.0f, 46.5f);
                l.cubicTo(7.343146f, 46.5f, 6.0f, 45.156853f, 6.0f, 43.5f);
                l.lineTo(6.0f, 28.5f);
                l.cubicTo(6.0f, 26.843145f, 7.343146f, 25.5f, 9.0f, 25.5f);
                l.lineTo(20.408829f, 25.5f);
                l.lineTo(23.408829f, 28.5f);
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
