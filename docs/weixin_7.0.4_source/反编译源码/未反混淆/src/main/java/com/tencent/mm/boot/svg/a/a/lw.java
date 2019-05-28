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

public final class lw extends c {
    private final int height = 64;
    private final int width = 64;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 64;
            case 1:
                return 64;
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
                canvas.saveLayerAlpha(null, 12, 4);
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                Path l = c.l(looper);
                l.moveTo(64.0f, 38.090908f);
                l.lineTo(64.0f, 52.545456f);
                l.cubicTo(64.0f, 54.20231f, 62.656853f, 55.545456f, 61.0f, 55.545456f);
                l.lineTo(3.0f, 55.545456f);
                l.cubicTo(1.3431457f, 55.545456f, 2.0290612E-16f, 54.20231f, 0.0f, 52.545456f);
                l.lineTo(0.0f, 38.090908f);
                l.cubicTo(3.213293f, 38.090908f, 5.818182f, 35.48602f, 5.818182f, 32.272728f);
                l.cubicTo(5.818182f, 29.059435f, 3.213293f, 26.454546f, 4.9790656E-16f, 26.454546f);
                l.lineTo(0.0f, 12.0f);
                l.cubicTo(-2.0290612E-16f, 10.343145f, 1.3431457f, 9.0f, 3.0f, 9.0f);
                l.lineTo(61.0f, 9.0f);
                l.cubicTo(62.656853f, 9.0f, 64.0f, 10.343145f, 64.0f, 12.0f);
                l.lineTo(64.0f, 26.454546f);
                l.cubicTo(60.786705f, 26.454546f, 58.18182f, 29.059435f, 58.18182f, 32.272728f);
                l.cubicTo(58.18182f, 35.48602f, 60.786705f, 38.090908f, 64.0f, 38.090908f);
                l.close();
                l.moveTo(15.045454f, 20.636364f);
                l.cubicTo(14.769312f, 20.636364f, 14.545454f, 20.860222f, 14.545454f, 21.136364f);
                l.lineTo(14.545454f, 25.954546f);
                l.cubicTo(14.545454f, 26.230688f, 14.769312f, 26.454546f, 15.045454f, 26.454546f);
                l.lineTo(40.227272f, 26.454546f);
                l.cubicTo(40.503414f, 26.454546f, 40.727272f, 26.230688f, 40.727272f, 25.954546f);
                l.lineTo(40.727272f, 21.136364f);
                l.cubicTo(40.727272f, 20.860222f, 40.503414f, 20.636364f, 40.227272f, 20.636364f);
                l.lineTo(15.045454f, 20.636364f);
                l.close();
                l.moveTo(15.045454f, 32.272728f);
                l.cubicTo(14.769312f, 32.272728f, 14.545454f, 32.496586f, 14.545454f, 32.772728f);
                l.lineTo(14.545454f, 37.590908f);
                l.cubicTo(14.545454f, 37.86705f, 14.769312f, 38.090908f, 15.045454f, 38.090908f);
                l.lineTo(31.5f, 38.090908f);
                l.cubicTo(31.776142f, 38.090908f, 32.0f, 37.86705f, 32.0f, 37.590908f);
                l.lineTo(32.0f, 32.772728f);
                l.cubicTo(32.0f, 32.496586f, 31.776142f, 32.272728f, 31.5f, 32.272728f);
                l.lineTo(15.045454f, 32.272728f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
