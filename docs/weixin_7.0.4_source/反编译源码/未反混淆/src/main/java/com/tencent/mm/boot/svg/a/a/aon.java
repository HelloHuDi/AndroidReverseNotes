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

public final class aon extends c {
    private final int height = 24;
    private final int width = 30;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 30;
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
                k.setColor(-1);
                canvas.save();
                k2 = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(26.0f, 0.0f);
                l.lineTo(26.0f, 20.0f);
                l.lineTo(0.0f, 20.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                l.moveTo(24.0f, 2.0f);
                l.lineTo(2.0f, 2.0f);
                l.lineTo(2.0f, 17.0f);
                l.lineTo(24.0f, 17.0f);
                l.lineTo(24.0f, 2.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                k2 = c.a(k, looper);
                l = c.l(looper);
                l.moveTo(28.0f, 23.0f);
                l.lineTo(29.0f, 23.0f);
                l.lineTo(29.0f, 3.0f);
                l.lineTo(27.0f, 3.0f);
                l.lineTo(27.0f, 21.0f);
                l.lineTo(3.0f, 21.0f);
                l.lineTo(3.0f, 23.0f);
                l.lineTo(28.0f, 23.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                Path l2 = c.l(looper);
                l2.moveTo(19.784946f, 8.898396f);
                l2.lineTo(15.462585f, 11.916007f);
                l2.lineTo(8.518518f, 6.5454545f);
                l2.lineTo(0.0f, 13.368984f);
                l2.lineTo(0.0f, 18.545454f);
                l2.lineTo(25.555555f, 18.545454f);
                l2.lineTo(25.555555f, 13.368984f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, k);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
