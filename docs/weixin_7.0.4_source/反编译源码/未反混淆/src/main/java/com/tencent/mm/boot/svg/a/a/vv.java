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

public final class vv extends c {
    private final int height = 46;
    private final int width = 66;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 66;
            case 1:
                return 46;
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
                k.setColor(-4547478);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(12.0f, 31.470589f);
                l.lineTo(12.0f, 46.0f);
                l.lineTo(66.0f, 46.0f);
                l.lineTo(66.0f, 0.0f);
                l.lineTo(12.0f, 0.0f);
                l.lineTo(12.0f, 14.529412f);
                l.lineTo(0.0f, 23.0f);
                l.lineTo(12.0f, 31.470589f);
                l.close();
                l.moveTo(27.0f, 29.0f);
                l.cubicTo(30.31371f, 29.0f, 33.0f, 26.31371f, 33.0f, 23.0f);
                l.cubicTo(33.0f, 19.68629f, 30.31371f, 17.0f, 27.0f, 17.0f);
                l.cubicTo(23.68629f, 17.0f, 21.0f, 19.68629f, 21.0f, 23.0f);
                l.cubicTo(21.0f, 26.31371f, 23.68629f, 29.0f, 27.0f, 29.0f);
                l.close();
                l.moveTo(51.0f, 29.0f);
                l.cubicTo(54.31371f, 29.0f, 57.0f, 26.31371f, 57.0f, 23.0f);
                l.cubicTo(57.0f, 19.68629f, 54.31371f, 17.0f, 51.0f, 17.0f);
                l.cubicTo(47.68629f, 17.0f, 45.0f, 19.68629f, 45.0f, 23.0f);
                l.cubicTo(45.0f, 26.31371f, 47.68629f, 29.0f, 51.0f, 29.0f);
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
