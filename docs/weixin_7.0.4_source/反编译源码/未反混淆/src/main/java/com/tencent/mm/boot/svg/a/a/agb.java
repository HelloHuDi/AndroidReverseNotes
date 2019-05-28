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

public final class agb extends c {
    private final int height = 72;
    private final int width = 72;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                canvas.save();
                k2 = c.a(k, looper);
                k2.setColor(-1);
                Path l = c.l(looper);
                l.moveTo(21.0f, 15.150418f);
                l.lineTo(25.5f, 15.150418f);
                l.lineTo(25.5f, 56.83244f);
                l.lineTo(21.0f, 56.83244f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-1);
                Path l2 = c.l(looper);
                l2.moveTo(45.0f, 15.150418f);
                l2.lineTo(49.5f, 15.150418f);
                l2.lineTo(49.5f, 56.83244f);
                l2.lineTo(45.0f, 56.83244f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, k);
                canvas.restore();
                Path l3 = c.l(looper);
                l3.moveTo(0.0f, 0.0f);
                l3.lineTo(72.0f, 0.0f);
                l3.lineTo(72.0f, 72.0f);
                l3.lineTo(0.0f, 72.0f);
                l3.lineTo(0.0f, 0.0f);
                l3.close();
                c.j(looper);
                break;
        }
        return 0;
    }
}
