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

public final class awo extends c {
    private final int height = 63;
    private final int width = 63;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 63;
            case 1:
                return 63;
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
                k.setColor(-14624737);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(35.0f, 20.0f);
                l.lineTo(50.492165f, 20.0f);
                l.cubicTo(51.322575f, 20.0f, 52.0f, 19.326305f, 52.0f, 18.495262f);
                l.lineTo(52.0f, 13.504739f);
                l.cubicTo(52.0f, 12.668316f, 51.324917f, 12.0f, 50.492165f, 12.0f);
                l.lineTo(12.507836f, 12.0f);
                l.cubicTo(11.677424f, 12.0f, 11.0f, 12.673695f, 11.0f, 13.504739f);
                l.lineTo(11.0f, 18.495262f);
                l.cubicTo(11.0f, 19.331684f, 11.675081f, 20.0f, 12.507836f, 20.0f);
                l.lineTo(27.0f, 20.0f);
                l.lineTo(27.0f, 52.5052f);
                l.cubicTo(27.0f, 53.32327f, 27.673695f, 54.0f, 28.504738f, 54.0f);
                l.lineTo(33.495262f, 54.0f);
                l.cubicTo(34.331684f, 54.0f, 35.0f, 53.330753f, 35.0f, 52.5052f);
                l.lineTo(35.0f, 20.0f);
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
