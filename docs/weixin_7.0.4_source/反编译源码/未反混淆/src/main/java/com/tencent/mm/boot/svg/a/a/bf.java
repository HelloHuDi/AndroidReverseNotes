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

public final class bf extends c {
    private final int height = 24;
    private final int width = 24;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                k.setColor(-15028967);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(11.261719f, 22.134476f);
                l.cubicTo(11.261719f, 22.134476f, 4.0f, 16.018278f, 4.0f, 10.0f);
                l.cubicTo(4.0f, 5.581722f, 7.581722f, 2.0f, 12.0f, 2.0f);
                l.cubicTo(16.418278f, 2.0f, 20.0f, 5.581722f, 20.0f, 10.0f);
                l.cubicTo(20.0f, 16.018278f, 12.738281f, 22.134476f, 12.738281f, 22.134476f);
                l.cubicTo(12.333565f, 22.50602f, 11.66946f, 22.502035f, 11.261719f, 22.134476f);
                l.close();
                l.moveTo(12.0f, 13.2f);
                l.cubicTo(13.767311f, 13.2f, 15.2f, 11.767311f, 15.2f, 10.0f);
                l.cubicTo(15.2f, 8.232689f, 13.767311f, 6.8f, 12.0f, 6.8f);
                l.cubicTo(10.232689f, 6.8f, 8.8f, 8.232689f, 8.8f, 10.0f);
                l.cubicTo(8.8f, 11.767311f, 10.232689f, 13.2f, 12.0f, 13.2f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
