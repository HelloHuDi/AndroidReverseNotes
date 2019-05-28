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

public final class atq extends c {
    private final int height = 36;
    private final int width = 22;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 22;
            case 1:
                return 36;
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
                k.setColor(-1);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(10.0f, 0.0f);
                l.lineTo(11.59f, 0.0f);
                l.cubicTo(14.44f, 4.26f, 18.06f, 8.06f, 22.0f, 11.34f);
                l.lineTo(22.0f, 11.75f);
                l.cubicTo(19.0f, 11.97f, 16.0f, 12.05f, 13.0f, 12.02f);
                l.cubicTo(13.05f, 20.01f, 12.89f, 28.01f, 13.09f, 36.0f);
                l.lineTo(9.0f, 36.0f);
                l.lineTo(9.0f, 12.03f);
                l.cubicTo(6.0f, 12.04f, 3.0f, 11.98f, 0.0f, 11.77f);
                l.lineTo(0.0f, 11.38f);
                l.cubicTo(3.84f, 8.02f, 7.68f, 4.33f, 10.39f, 0.0f);
                l.lineTo(10.0f, 0.0f);
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
