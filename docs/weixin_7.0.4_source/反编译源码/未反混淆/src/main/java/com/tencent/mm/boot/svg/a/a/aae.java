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

public final class aae extends c {
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
                k = c.a(k, looper);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(36.0f, 66.0f);
                l.cubicTo(19.431458f, 66.0f, 6.0f, 52.568542f, 6.0f, 36.0f);
                l.cubicTo(6.0f, 19.431458f, 19.431458f, 6.0f, 36.0f, 6.0f);
                l.cubicTo(52.568542f, 6.0f, 66.0f, 19.431458f, 66.0f, 36.0f);
                l.cubicTo(66.0f, 52.568542f, 52.568542f, 66.0f, 36.0f, 66.0f);
                l.close();
                l.moveTo(27.805887f, 33.6f);
                l.lineTo(42.0f, 33.6f);
                l.cubicTo(44.982338f, 33.6f, 47.4f, 36.017662f, 47.4f, 39.0f);
                l.cubicTo(47.4f, 41.982338f, 44.982338f, 44.4f, 42.0f, 44.4f);
                l.lineTo(36.0f, 44.4f);
                l.lineTo(36.0f, 48.0f);
                l.lineTo(42.0f, 48.0f);
                l.cubicTo(46.970562f, 48.0f, 51.0f, 43.970562f, 51.0f, 39.0f);
                l.cubicTo(51.0f, 34.029438f, 46.970562f, 30.0f, 42.0f, 30.0f);
                l.lineTo(27.976452f, 30.0f);
                l.lineTo(32.030865f, 25.945585f);
                l.lineTo(29.485281f, 23.400002f);
                l.lineTo(22.06066f, 30.824621f);
                l.cubicTo(21.474874f, 31.410408f, 21.474874f, 32.360157f, 22.06066f, 32.945942f);
                l.lineTo(29.485281f, 40.370564f);
                l.lineTo(32.030865f, 37.824978f);
                l.lineTo(27.805887f, 33.6f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
