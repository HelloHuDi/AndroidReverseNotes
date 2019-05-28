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

public final class rj extends c {
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
                k2 = c.a(k, looper);
                k2.setColor(-12206054);
                Path l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(192.0f, 0.0f);
                l.lineTo(192.0f, 192.0f);
                l.lineTo(0.0f, 192.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-1);
                Path l2 = c.l(looper);
                l2.moveTo(65.454544f, 90.181816f);
                l2.lineTo(58.18182f, 90.181816f);
                l2.lineTo(58.18182f, 103.31862f);
                l2.cubicTo(58.18182f, 122.70565f, 72.80536f, 138.68132f, 91.63636f, 140.84218f);
                l2.lineTo(91.63636f, 149.81818f);
                l2.lineTo(73.72098f, 149.81818f);
                l2.cubicTo(73.172165f, 149.81818f, 72.72727f, 150.27472f, 72.72727f, 150.81836f);
                l2.lineTo(72.72727f, 154.63618f);
                l2.cubicTo(72.72727f, 155.18857f, 73.17303f, 155.63637f, 73.72098f, 155.63637f);
                l2.lineTo(118.27902f, 155.63637f);
                l2.cubicTo(118.827835f, 155.63637f, 119.27273f, 155.17982f, 119.27273f, 154.63618f);
                l2.lineTo(119.27273f, 150.81836f);
                l2.cubicTo(119.27273f, 150.26598f, 118.82698f, 149.81818f, 118.27902f, 149.81818f);
                l2.lineTo(100.36363f, 149.81818f);
                l2.lineTo(100.36363f, 149.81818f);
                l2.lineTo(100.36363f, 140.84218f);
                l2.lineTo(100.36363f, 140.84218f);
                l2.cubicTo(119.19464f, 138.68132f, 133.81818f, 122.70565f, 133.81818f, 103.31862f);
                l2.lineTo(133.81818f, 90.181816f);
                l2.lineTo(126.545456f, 90.181816f);
                l2.lineTo(126.545456f, 102.822685f);
                l2.cubicTo(126.545456f, 119.941025f, 112.86979f, 133.81818f, 96.0f, 133.81818f);
                l2.cubicTo(79.13021f, 133.81818f, 65.454544f, 119.941025f, 65.454544f, 102.822685f);
                l2.lineTo(65.454544f, 90.181816f);
                l2.lineTo(65.454544f, 90.181816f);
                l2.close();
                l2.moveTo(96.0f, 36.363636f);
                l2.cubicTo(83.14683f, 36.363636f, 72.72727f, 46.774685f, 72.72727f, 59.646313f);
                l2.lineTo(72.72727f, 103.26278f);
                l2.cubicTo(72.72727f, 116.121445f, 83.144005f, 126.545456f, 96.0f, 126.545456f);
                l2.cubicTo(108.85317f, 126.545456f, 119.27273f, 116.13441f, 119.27273f, 103.26278f);
                l2.lineTo(119.27273f, 59.646313f);
                l2.cubicTo(119.27273f, 46.787647f, 108.855995f, 36.363636f, 96.0f, 36.363636f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
