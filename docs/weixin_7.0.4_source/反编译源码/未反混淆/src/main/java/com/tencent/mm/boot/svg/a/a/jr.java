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

public final class jr extends c {
    private final int height = 96;
    private final int width = 96;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                k.setColor(-9341831);
                canvas.save();
                k = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(53.0f, 44.0f);
                l.lineTo(85.0f, 44.0f);
                l.lineTo(85.0f, 12.0f);
                l.lineTo(53.0f, 12.0f);
                l.lineTo(53.0f, 44.0f);
                l.close();
                l.moveTo(61.0f, 36.0f);
                l.lineTo(77.0f, 36.0f);
                l.lineTo(77.0f, 20.0f);
                l.lineTo(61.0f, 20.0f);
                l.lineTo(61.0f, 36.0f);
                l.close();
                l.moveTo(12.0f, 44.0f);
                l.lineTo(44.0f, 44.0f);
                l.lineTo(44.0f, 12.0f);
                l.lineTo(12.0f, 12.0f);
                l.lineTo(12.0f, 44.0f);
                l.close();
                l.moveTo(20.0f, 36.0f);
                l.lineTo(36.0f, 36.0f);
                l.lineTo(36.0f, 20.0f);
                l.lineTo(20.0f, 20.0f);
                l.lineTo(20.0f, 36.0f);
                l.close();
                l.moveTo(53.0f, 85.0f);
                l.lineTo(85.0f, 85.0f);
                l.lineTo(85.0f, 53.0f);
                l.lineTo(53.0f, 53.0f);
                l.lineTo(53.0f, 85.0f);
                l.close();
                l.moveTo(61.0f, 77.0f);
                l.lineTo(77.0f, 77.0f);
                l.lineTo(77.0f, 61.0f);
                l.lineTo(61.0f, 61.0f);
                l.lineTo(61.0f, 77.0f);
                l.close();
                l.moveTo(36.0f, 61.0f);
                l.lineTo(44.0f, 61.0f);
                l.lineTo(44.0f, 53.0f);
                l.lineTo(36.0f, 53.0f);
                l.lineTo(36.0f, 61.0f);
                l.close();
                l.moveTo(20.0f, 53.0f);
                l.lineTo(12.0f, 53.0f);
                l.lineTo(12.0f, 61.0f);
                l.lineTo(20.0f, 61.0f);
                l.lineTo(28.0f, 61.0f);
                l.lineTo(28.0f, 53.0f);
                l.lineTo(20.0f, 53.0f);
                l.close();
                l.moveTo(28.0f, 69.0f);
                l.lineTo(36.0f, 69.0f);
                l.lineTo(36.0f, 61.0f);
                l.lineTo(28.0f, 61.0f);
                l.lineTo(28.0f, 69.0f);
                l.close();
                l.moveTo(36.0f, 69.0f);
                l.lineTo(36.0f, 77.0f);
                l.lineTo(28.0f, 77.0f);
                l.lineTo(28.0f, 85.0f);
                l.lineTo(36.0f, 85.0f);
                l.lineTo(44.0f, 85.0f);
                l.lineTo(44.0f, 69.0f);
                l.lineTo(36.0f, 69.0f);
                l.close();
                l.moveTo(12.0f, 69.0f);
                l.lineTo(12.0f, 77.0f);
                l.lineTo(12.0f, 85.0f);
                l.lineTo(20.0f, 85.0f);
                l.lineTo(20.0f, 77.0f);
                l.lineTo(28.0f, 77.0f);
                l.lineTo(28.0f, 69.0f);
                l.lineTo(12.0f, 69.0f);
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
