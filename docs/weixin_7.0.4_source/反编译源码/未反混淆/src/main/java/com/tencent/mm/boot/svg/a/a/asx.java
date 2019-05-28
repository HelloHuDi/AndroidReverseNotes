package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.k.o;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class asx extends c {
    private final int height = o.CTRL_INDEX;
    private final int width = o.CTRL_INDEX;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return o.CTRL_INDEX;
            case 1:
                return o.CTRL_INDEX;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix h = c.h(looper);
                float[] g = c.g(looper);
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
                k.setColor(-3355444);
                canvas.save();
                Paint a = c.a(k, looper);
                g = c.a(g, 0.70710677f, 0.70710677f, -41.00714f, -0.70710677f, 0.70710677f, 99.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l = c.l(looper);
                l.moveTo(168.0f, 99.0f);
                l.lineTo(168.0f, 165.0f);
                l.cubicTo(168.0f, 166.65686f, 166.65686f, 168.0f, 165.0f, 168.0f);
                l.lineTo(99.0f, 168.0f);
                l.cubicTo(60.892353f, 168.0f, 30.0f, 137.10765f, 30.0f, 99.0f);
                l.cubicTo(30.0f, 60.892353f, 60.892353f, 30.0f, 99.0f, 30.0f);
                l.cubicTo(137.10765f, 30.0f, 168.0f, 60.892353f, 168.0f, 99.0f);
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
