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

public final class tm extends c {
    private final int height = 30;
    private final int width = 24;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 24;
            case 1:
                return 30;
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
                k.setColor(WebView.NIGHT_MODE_COLOR);
                Path l = c.l(looper);
                l.moveTo(22.0f, 14.999688f);
                l.lineTo(7.130435f, 29.999374f);
                l.lineTo(3.826087f, 26.666111f);
                l.lineTo(15.391304f, 14.999688f);
                l.lineTo(3.0f, 3.3332639f);
                l.lineTo(6.304348f, 0.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.saveLayerAlpha(null, 51, 4);
                k = c.a(k, looper);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.restore();
                Path l2 = c.l(looper);
                l2.moveTo(0.0f, 0.0f);
                l2.lineTo(24.0f, 0.0f);
                l2.lineTo(24.0f, 30.0f);
                l2.lineTo(0.0f, 30.0f);
                l2.lineTo(0.0f, 0.0f);
                l2.close();
                c.j(looper);
                break;
        }
        return 0;
    }
}
