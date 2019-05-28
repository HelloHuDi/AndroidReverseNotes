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

public final class rw extends c {
    private final int height = 32;
    private final int width = 32;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 32;
            case 1:
                return 32;
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
                canvas.saveLayerAlpha(null, 51, 4);
                canvas.save();
                k = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(12.320716f, 29.0f);
                l.lineTo(9.3872795f, 25.98882f);
                l.lineTo(19.132097f, 16.4053f);
                l.lineTo(9.0f, 7.0749907f);
                l.lineTo(12.127076f, 4.0f);
                l.lineTo(25.0f, 16.531904f);
                l.lineTo(12.320716f, 29.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
