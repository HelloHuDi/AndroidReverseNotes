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

public final class qp extends c {
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
                k2.setColor(-12953699);
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
                l2.moveTo(104.72727f, 192.0f);
                l2.lineTo(104.72727f, 117.818184f);
                l2.lineTo(80.0f, 117.818184f);
                l2.lineTo(80.0f, 87.27273f);
                l2.lineTo(104.72727f, 87.27273f);
                l2.lineTo(104.72727f, 61.090908f);
                l2.cubicTo(104.62603f, 44.320255f, 121.209656f, 29.09091f, 138.18182f, 29.09091f);
                l2.lineTo(164.36363f, 29.09091f);
                l2.lineTo(164.36363f, 58.18182f);
                l2.lineTo(148.36363f, 58.18182f);
                l2.cubicTo(137.98802f, 58.097572f, 133.74586f, 62.3439f, 133.81818f, 72.72727f);
                l2.lineTo(133.81818f, 87.27273f);
                l2.lineTo(164.36363f, 87.27273f);
                l2.lineTo(158.54546f, 117.818184f);
                l2.lineTo(133.81818f, 117.818184f);
                l2.lineTo(133.81818f, 192.0f);
                l2.lineTo(104.72727f, 192.0f);
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
