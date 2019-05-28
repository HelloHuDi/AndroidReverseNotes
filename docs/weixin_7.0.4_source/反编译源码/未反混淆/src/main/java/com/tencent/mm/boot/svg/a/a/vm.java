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

public final class vm extends c {
    private final int height = 6;
    private final int width = 14;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 14;
            case 1:
                return 6;
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
                a.setColor(-12666825);
                Path l = c.l(looper);
                l.moveTo(2.0f, 1.0f);
                l.lineTo(12.0f, 1.0f);
                l.cubicTo(12.552284f, 1.0f, 13.0f, 1.4477153f, 13.0f, 2.0f);
                l.lineTo(13.0f, 4.0f);
                l.cubicTo(13.0f, 4.5522847f, 12.552284f, 5.0f, 12.0f, 5.0f);
                l.lineTo(2.0f, 5.0f);
                l.cubicTo(1.4477153f, 5.0f, 1.0f, 4.5522847f, 1.0f, 4.0f);
                l.lineTo(1.0f, 2.0f);
                l.cubicTo(1.0f, 1.4477153f, 1.4477153f, 1.0f, 2.0f, 1.0f);
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
