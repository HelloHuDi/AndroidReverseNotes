package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class nd extends c {
    private final int height = 96;
    private final int width = 96;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-2500135);
                g = c.a(g, 1.0f, 0.0f, 21.0f, 0.0f, 1.0f, 21.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(1.7508265f, 9.118188f);
                l.cubicTo(3.893294f, 5.1235943f, 7.759701f, 2.3841593f, 11.516493f, 0.043187827f);
                l.cubicTo(13.110888f, -0.28554434f, 13.8184f, 1.3381933f, 14.665422f, 2.344313f);
                l.cubicTo(16.967329f, 5.7113276f, 19.49843f, 8.928918f, 21.72062f, 12.355701f);
                l.cubicTo(22.48792f, 13.341898f, 21.899988f, 14.786327f, 20.813807f, 15.254521f);
                l.cubicTo(18.37239f, 16.977875f, 15.622059f, 18.173265f, 12.911589f, 19.398539f);
                l.cubicTo(14.197069f, 23.56248f, 16.658415f, 27.228342f, 19.588116f, 30.416048f);
                l.cubicTo(23.753471f, 34.95853f, 28.58648f, 39.24201f, 34.595356f, 41.0849f);
                l.cubicTo(36.080135f, 38.026695f, 37.35565f, 34.759296f, 39.6177f, 32.169285f);
                l.cubicTo(41.381496f, 31.37236f, 42.7168f, 33.14552f, 44.101933f, 33.922523f);
                l.cubicTo(47.29072f, 36.402958f, 50.828285f, 38.43512f, 53.837704f, 41.13471f);
                l.cubicTo(54.455532f, 42.59906f, 53.160088f, 43.744644f, 52.45257f, 44.880264f);
                l.cubicTo(50.150665f, 47.908585f, 47.70925f, 51.235752f, 44.01225f, 52.61045f);
                l.cubicTo(41.411392f, 53.61657f, 38.66106f, 52.461025f, 36.20968f, 51.54456f);
                l.cubicTo(20.993176f, 45.03965f, 8.477179f, 32.44821f, 2.17932f, 17.127298f);
                l.cubicTo(1.1927884f, 14.616981f, 0.32583636f, 11.658391f, 1.7508265f, 9.118188f);
                l.lineTo(1.7508265f, 9.118188f);
                l.lineTo(1.7508265f, 9.118188f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
