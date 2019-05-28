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

public final class ago extends c {
    private final int height = 38;
    private final int width = 18;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 18;
            case 1:
                return 38;
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
                k.setColor(-6710887);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(6.0f, 0.0f);
                l.cubicTo(10.03f, 6.2841287f, 13.99f, 12.663152f, 18.0f, 19.0f);
                l.cubicTo(13.97f, 25.305216f, 10.03f, 31.673697f, 6.0f, 38.0f);
                l.lineTo(0.0f, 38.0f);
                l.cubicTo(3.97f, 31.642065f, 8.0f, 25.326303f, 12.0f, 19.0f);
                l.cubicTo(8.01f, 12.673696f, 4.04f, 6.336848f, 0.0f, 0.0f);
                l.lineTo(6.0f, 0.0f);
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
