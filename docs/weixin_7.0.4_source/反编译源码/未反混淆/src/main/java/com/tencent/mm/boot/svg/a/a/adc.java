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

public final class adc extends c {
    private final int height = 60;
    private final int width = 48;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 60;
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
                l.moveTo(2.0f, 55.19479f);
                l.cubicTo(2.0f, 57.400494f, 3.5235274f, 58.24533f, 5.3961477f, 57.085964f);
                l.lineTo(44.789597f, 32.69689f);
                l.cubicTo(46.665234f, 31.535654f, 46.68837f, 29.615736f, 44.8456f, 28.411467f);
                l.lineTo(5.340144f, 2.594247f);
                l.cubicTo(3.4954336f, 1.3887097f, 2.0f, 2.202605f, 2.0f, 4.4052105f);
                l.lineTo(2.0f, 55.19479f);
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
