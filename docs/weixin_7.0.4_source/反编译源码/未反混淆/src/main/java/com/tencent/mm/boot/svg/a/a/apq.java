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

public final class apq extends c {
    private final int height = 36;
    private final int width = 36;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 36;
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
                k.setColor(-3833595);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(30.0f, 18.0f);
                l.cubicTo(30.0f, 18.0f, 26.249992f, 20.250055f, 23.249962f, 23.249962f);
                l.cubicTo(20.250055f, 26.249992f, 18.0f, 30.0f, 18.0f, 30.0f);
                l.cubicTo(18.0f, 30.0f, 15.698808f, 26.198854f, 12.750039f, 23.249962f);
                l.cubicTo(9.801146f, 20.301191f, 6.0f, 18.0f, 6.0f, 18.0f);
                l.cubicTo(6.0f, 18.0f, 9.750008f, 15.749946f, 12.750039f, 12.750039f);
                l.cubicTo(15.749946f, 9.750008f, 18.0f, 6.0f, 18.0f, 6.0f);
                l.cubicTo(18.0f, 6.0f, 20.223738f, 9.723691f, 23.249962f, 12.750039f);
                l.cubicTo(26.27631f, 15.776262f, 30.0f, 18.0f, 30.0f, 18.0f);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
