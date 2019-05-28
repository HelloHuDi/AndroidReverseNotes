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

public final class aci extends c {
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
                l.moveTo(55.091885f, 19.908117f);
                l.cubicTo(59.97792f, 24.794155f, 63.0f, 31.544155f, 63.0f, 39.0f);
                l.cubicTo(63.0f, 53.91169f, 50.91169f, 66.0f, 36.0f, 66.0f);
                l.cubicTo(21.088312f, 66.0f, 9.0f, 53.91169f, 9.0f, 39.0f);
                l.cubicTo(9.0f, 24.088312f, 21.088312f, 12.0f, 36.0f, 12.0f);
                l.lineTo(36.0f, 15.6f);
                l.cubicTo(23.076536f, 15.6f, 12.6f, 26.076536f, 12.6f, 39.0f);
                l.cubicTo(12.6f, 51.923462f, 23.076536f, 62.4f, 36.0f, 62.4f);
                l.cubicTo(48.923462f, 62.4f, 59.4f, 51.923462f, 59.4f, 39.0f);
                l.cubicTo(59.4f, 32.706245f, 56.908665f, 26.816067f, 52.5463f, 22.453701f);
                l.lineTo(55.091885f, 19.908117f);
                l.close();
                l.moveTo(34.730843f, 15.633832f);
                l.cubicTo(22.397545f, 16.293022f, 12.6f, 26.502342f, 12.6f, 39.0f);
                l.cubicTo(12.6f, 51.923462f, 23.076536f, 62.4f, 36.0f, 62.4f);
                l.cubicTo(48.923462f, 62.4f, 59.4f, 51.923462f, 59.4f, 39.0f);
                l.cubicTo(59.4f, 32.706245f, 56.908665f, 26.816067f, 52.5463f, 22.453701f);
                l.lineTo(55.091885f, 19.908117f);
                l.cubicTo(59.97792f, 24.794155f, 63.0f, 31.544155f, 63.0f, 39.0f);
                l.cubicTo(63.0f, 53.91169f, 50.91169f, 66.0f, 36.0f, 66.0f);
                l.cubicTo(21.088312f, 66.0f, 9.0f, 53.91169f, 9.0f, 39.0f);
                l.cubicTo(9.0f, 24.928625f, 19.764284f, 13.371382f, 33.507618f, 12.113505f);
                l.lineTo(29.939697f, 8.545585f);
                l.lineTo(32.485283f, 6.0f);
                l.lineTo(39.909904f, 13.424622f);
                l.cubicTo(40.49569f, 14.010407f, 40.49569f, 14.9601555f, 39.909904f, 15.545941f);
                l.lineTo(38.424976f, 17.030867f);
                l.lineTo(32.485283f, 22.970562f);
                l.lineTo(29.939697f, 20.424978f);
                l.lineTo(34.730843f, 15.633832f);
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
