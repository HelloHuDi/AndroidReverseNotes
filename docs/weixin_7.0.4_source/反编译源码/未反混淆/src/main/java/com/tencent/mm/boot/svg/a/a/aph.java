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

public final class aph extends c {
    private final int height = 66;
    private final int width = 66;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 66;
            case 1:
                return 66;
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
                k.setColor(-499359);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(29.81802f, 33.0f);
                l.lineTo(17.90901f, 21.09099f);
                l.lineTo(21.09099f, 17.90901f);
                l.lineTo(33.0f, 29.81802f);
                l.lineTo(44.909008f, 17.90901f);
                l.lineTo(48.090992f, 21.09099f);
                l.lineTo(36.18198f, 33.0f);
                l.lineTo(48.090992f, 44.909008f);
                l.lineTo(44.909008f, 48.090992f);
                l.lineTo(33.0f, 36.18198f);
                l.lineTo(21.09099f, 48.090992f);
                l.lineTo(17.90901f, 44.909008f);
                l.lineTo(29.81802f, 33.0f);
                l.close();
                l.moveTo(33.0f, 66.0f);
                l.cubicTo(51.225395f, 66.0f, 66.0f, 51.225395f, 66.0f, 33.0f);
                l.cubicTo(66.0f, 14.774603f, 51.225395f, 0.0f, 33.0f, 0.0f);
                l.cubicTo(14.774603f, 0.0f, 0.0f, 14.774603f, 0.0f, 33.0f);
                l.cubicTo(0.0f, 51.225395f, 14.774603f, 66.0f, 33.0f, 66.0f);
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
