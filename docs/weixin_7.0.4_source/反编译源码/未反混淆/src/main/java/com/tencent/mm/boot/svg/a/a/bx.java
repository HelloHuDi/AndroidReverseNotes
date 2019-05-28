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

public final class bx extends c {
    private final int height = 90;
    private final int width = 90;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                k.setColor(-2049700);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(86.25f, 32.25337f);
                l.lineTo(86.25f, 28.75f);
                l.cubicTo(86.25f, 26.678932f, 84.57107f, 25.0f, 82.5f, 25.0f);
                l.lineTo(7.5f, 25.0f);
                l.cubicTo(5.428932f, 25.0f, 3.75f, 26.678932f, 3.75f, 28.75f);
                l.lineTo(3.75f, 32.25337f);
                l.cubicTo(4.8531504f, 31.615229f, 6.133923f, 31.25f, 7.5f, 31.25f);
                l.lineTo(82.5f, 31.25f);
                l.cubicTo(83.86607f, 31.25f, 85.14685f, 31.615229f, 86.25f, 32.25337f);
                l.close();
                l.moveTo(3.75f, 10.0f);
                l.lineTo(29.6967f, 10.0f);
                l.cubicTo(30.691261f, 10.0f, 31.645088f, 10.395088f, 32.34835f, 11.09835f);
                l.lineTo(37.65165f, 16.40165f);
                l.cubicTo(38.35491f, 17.104912f, 39.30874f, 17.5f, 40.303303f, 17.5f);
                l.lineTo(86.25f, 17.5f);
                l.cubicTo(88.32107f, 17.5f, 90.0f, 19.178932f, 90.0f, 21.25f);
                l.lineTo(90.0f, 76.25f);
                l.cubicTo(90.0f, 78.32107f, 88.32107f, 80.0f, 86.25f, 80.0f);
                l.lineTo(3.75f, 80.0f);
                l.cubicTo(1.6789322f, 80.0f, 2.5363266E-16f, 78.32107f, 0.0f, 76.25f);
                l.lineTo(-8.881784E-16f, 13.75f);
                l.cubicTo(-1.1418111E-15f, 11.678932f, 1.6789322f, 10.0f, 3.75f, 10.0f);
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
