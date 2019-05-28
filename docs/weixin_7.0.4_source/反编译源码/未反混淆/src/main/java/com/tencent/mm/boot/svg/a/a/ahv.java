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

public final class ahv extends c {
    private final int height = 108;
    private final int width = 108;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 108;
            case 1:
                return 108;
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
                k.setColor(-15683841);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(87.115f, 33.87689f);
                l.cubicTo(87.115f, 30.632847f, 84.48362f, 28.0f, 81.23811f, 28.0f);
                l.lineTo(26.876888f, 28.0f);
                l.cubicTo(23.631376f, 28.0f, 21.0f, 30.632847f, 21.0f, 33.87689f);
                l.lineTo(21.0f, 75.01658f);
                l.cubicTo(21.0f, 78.26209f, 23.631376f, 80.892f, 26.876888f, 80.892f);
                l.lineTo(81.23811f, 80.892f);
                l.cubicTo(84.48362f, 80.892f, 87.115f, 78.26209f, 87.115f, 75.01658f);
                l.lineTo(87.115f, 66.199776f);
                l.lineTo(72.422775f, 66.199776f);
                l.cubicTo(65.931755f, 66.199776f, 60.669f, 60.937023f, 60.669f, 54.446f);
                l.cubicTo(60.669f, 47.954975f, 65.931755f, 42.692223f, 72.422775f, 42.692223f);
                l.lineTo(87.115f, 42.692223f);
                l.lineTo(87.115f, 33.87689f);
                l.lineTo(87.115f, 33.87689f);
                l.close();
                l.moveTo(66.54589f, 54.446f);
                l.cubicTo(66.54589f, 57.69298f, 69.17727f, 60.322887f, 72.422775f, 60.322887f);
                l.cubicTo(75.66829f, 60.322887f, 78.29967f, 57.69298f, 78.29967f, 54.446f);
                l.cubicTo(78.29967f, 51.20049f, 75.66829f, 48.56911f, 72.422775f, 48.56911f);
                l.cubicTo(69.17727f, 48.56911f, 66.54589f, 51.20049f, 66.54589f, 54.446f);
                l.lineTo(66.54589f, 54.446f);
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
