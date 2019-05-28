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

public final class aug extends c {
    private final int height = 186;
    private final int width = 186;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 186;
            case 1:
                return 186;
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
                k.setColor(-2105120);
                canvas.save();
                k2 = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(186.0f, 0.0f);
                l.lineTo(186.0f, 186.0f);
                l.lineTo(0.0f, 186.0f);
                l.lineTo(0.0f, 0.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                l.moveTo(3.0f, 3.0f);
                l.lineTo(3.0f, 183.0f);
                l.lineTo(183.0f, 183.0f);
                l.lineTo(183.0f, 3.0f);
                l.lineTo(3.0f, 3.0f);
                l.lineTo(3.0f, 3.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                Path l2 = c.l(looper);
                l2.moveTo(90.0f, 33.0f);
                l2.lineTo(96.0f, 33.0f);
                l2.lineTo(96.0f, 90.0f);
                l2.lineTo(153.0f, 90.0f);
                l2.lineTo(153.0f, 96.0f);
                l2.lineTo(96.0f, 96.0f);
                l2.lineTo(96.0f, 153.0f);
                l2.lineTo(90.0f, 153.0f);
                l2.lineTo(90.0f, 96.0f);
                l2.lineTo(33.0f, 96.0f);
                l2.lineTo(33.0f, 90.0f);
                l2.lineTo(90.0f, 90.0f);
                l2.lineTo(90.0f, 33.0f);
                l2.lineTo(90.0f, 33.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, k);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
