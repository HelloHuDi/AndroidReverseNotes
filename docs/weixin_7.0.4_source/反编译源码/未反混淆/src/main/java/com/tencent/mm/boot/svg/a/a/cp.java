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

public final class cp extends c {
    private final int height = 80;
    private final int width = 80;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 80;
            case 1:
                return 80;
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
                k = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(61.0f, 33.0f);
                l.lineTo(61.0f, 64.0f);
                l.lineTo(19.0f, 64.0f);
                l.lineTo(19.0f, 17.0f);
                l.lineTo(47.0f, 17.0f);
                l.lineTo(47.0f, 33.0f);
                l.lineTo(49.0f, 33.0f);
                l.lineTo(61.0f, 33.0f);
                l.close();
                l.moveTo(60.989494f, 29.0f);
                l.lineTo(51.0f, 18.140165f);
                l.lineTo(51.0f, 29.0f);
                l.lineTo(60.989494f, 29.0f);
                l.close();
                l.moveTo(63.0f, 68.0f);
                l.lineTo(15.0f, 68.0f);
                l.lineTo(15.0f, 66.0f);
                l.lineTo(15.0f, 15.0f);
                l.lineTo(15.0f, 13.0f);
                l.lineTo(51.0f, 13.0f);
                l.lineTo(51.0f, 13.028122f);
                l.lineTo(65.04203f, 28.0f);
                l.lineTo(65.0f, 28.010773f);
                l.lineTo(65.0f, 68.0f);
                l.lineTo(63.0f, 68.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
