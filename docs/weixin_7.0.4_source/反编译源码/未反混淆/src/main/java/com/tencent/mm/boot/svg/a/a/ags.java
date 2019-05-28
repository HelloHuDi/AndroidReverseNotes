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

public final class ags extends c {
    private final int height = 56;
    private final int width = 40;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 40;
            case 1:
                return 56;
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
                k.setColor(-7105645);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(40.0f, 0.0f);
                l.lineTo(40.0f, 0.0f);
                l.lineTo(40.0f, 56.0f);
                l.lineTo(40.0f, 56.0f);
                l.cubicTo(28.04299f, 47.66f, 16.135965f, 39.26f, 4.0f, 31.0f);
                l.cubicTo(2.9492626f, 29.86f, 1.6795801f, 28.79f, 0.0f, 29.0f);
                l.lineTo(0.0f, 27.0f);
                l.cubicTo(0.179955f, 27.41f, 0.52986753f, 27.41f, 1.0f, 27.0f);
                l.cubicTo(13.886528f, 18.41f, 26.88328f, 9.13f, 40.0f, 0.0f);
                l.lineTo(40.0f, 0.0f);
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
