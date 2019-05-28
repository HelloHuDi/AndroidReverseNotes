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

public final class arc extends c {
    private final int height = 49;
    private final int width = 56;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 56;
            case 1:
                return 49;
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
                k.setColor(-27648);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(52.0f, 0.0f);
                l.cubicTo(53.5f, 1.0525777f, 54.73f, 2.1051555f, 56.0f, 3.0f);
                l.lineTo(56.0f, 5.0f);
                l.cubicTo(53.09f, 7.1074057f, 50.94f, 10.395458f, 49.0f, 13.0f);
                l.cubicTo(39.47f, 25.301964f, 30.39f, 37.161007f, 21.0f, 49.0f);
                l.cubicTo(13.57f, 41.7723f, 7.51f, 33.00082f, 0.0f, 26.0f);
                l.lineTo(0.0f, 24.0f);
                l.cubicTo(0.87f, 22.956219f, 1.72f, 21.643003f, 3.0f, 20.0f);
                l.cubicTo(8.66f, 25.121523f, 14.88f, 29.762888f, 21.0f, 34.0f);
                l.cubicTo(31.45f, 22.986294f, 41.91f, 11.538257f, 52.0f, 0.0f);
                l.lineTo(52.0f, 0.0f);
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
