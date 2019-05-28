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

public final class akg extends c {
    private final int height = 107;
    private final int width = 107;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 107;
            case 1:
                return 107;
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
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(33.506958f, 86.825905f);
                l.cubicTo(32.122402f, 87.74495f, 31.0f, 87.15455f, 31.0f, 85.48306f);
                l.lineTo(31.0f, 21.517584f);
                l.cubicTo(31.0f, 19.856905f, 32.125355f, 19.257656f, 33.506958f, 20.174744f);
                l.lineTo(81.20527f, 51.83624f);
                l.cubicTo(82.58983f, 52.755287f, 82.586876f, 54.24732f, 81.20527f, 55.16441f);
                l.lineTo(33.506958f, 86.825905f);
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
