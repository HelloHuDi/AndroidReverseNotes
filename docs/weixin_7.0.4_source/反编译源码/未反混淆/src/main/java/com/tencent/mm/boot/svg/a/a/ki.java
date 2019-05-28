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

public final class ki extends c {
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
                k.setColor(-8617851);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(41.0f, 65.0f);
                l.cubicTo(28.297495f, 65.0f, 18.0f, 54.702503f, 18.0f, 42.0f);
                l.cubicTo(18.0f, 29.297495f, 28.297495f, 19.0f, 41.0f, 19.0f);
                l.cubicTo(53.702503f, 19.0f, 64.0f, 29.297495f, 64.0f, 42.0f);
                l.cubicTo(64.0f, 54.702503f, 53.702503f, 65.0f, 41.0f, 65.0f);
                l.lineTo(41.0f, 65.0f);
                l.close();
                l.moveTo(85.0f, 78.0f);
                l.lineTo(66.0f, 61.0f);
                l.cubicTo(70.123146f, 55.956898f, 72.5f, 49.400074f, 73.0f, 42.0f);
                l.cubicTo(72.5f, 25.006767f, 58.508797f, 11.0f, 41.0f, 11.0f);
                l.cubicTo(23.991203f, 11.0f, 10.0f, 25.006767f, 10.0f, 42.0f);
                l.cubicTo(10.0f, 59.562756f, 23.991203f, 73.56952f, 41.0f, 74.0f);
                l.cubicTo(48.358334f, 73.56952f, 54.908794f, 71.18956f, 60.0f, 67.0f);
                l.lineTo(77.0f, 86.0f);
                l.lineTo(85.0f, 78.0f);
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
