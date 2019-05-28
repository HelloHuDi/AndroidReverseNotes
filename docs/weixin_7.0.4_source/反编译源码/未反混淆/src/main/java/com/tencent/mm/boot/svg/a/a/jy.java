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

public final class jy extends c {
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
                k.setColor(-8617594);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(39.0f, 87.17454f);
                l.cubicTo(41.636593f, 87.715576f, 44.36543f, 88.0f, 47.160282f, 88.0f);
                l.cubicTo(52.397297f, 88.0f, 57.40235f, 87.001335f, 62.0f, 85.18495f);
                l.lineTo(39.0f, 62.0f);
                l.lineTo(39.0f, 87.17454f);
                l.close();
                l.moveTo(84.18153f, 34.0f);
                l.lineTo(61.0f, 57.0f);
                l.lineTo(86.17404f, 57.0f);
                l.cubicTo(86.71542f, 54.364433f, 87.0f, 51.636253f, 87.0f, 48.841667f);
                l.cubicTo(87.0f, 43.60351f, 86.00011f, 38.59756f, 84.18153f, 34.0f);
                l.lineTo(84.18153f, 34.0f);
                l.close();
                l.moveTo(68.36796f, 82.0f);
                l.cubicTo(74.77223f, 77.61014f, 79.888794f, 71.36405f, 83.0f, 64.0f);
                l.lineTo(51.0f, 64.0f);
                l.lineTo(68.36796f, 82.0f);
                l.close();
                l.moveTo(7.0f, 48.134434f);
                l.cubicTo(7.0f, 53.381317f, 8.00163f, 58.394844f, 9.8239765f, 63.0f);
                l.lineTo(33.0f, 40.0f);
                l.lineTo(7.8198056f, 40.0f);
                l.cubicTo(7.2825346f, 42.628418f, 7.0f, 45.348637f, 7.0f, 48.134434f);
                l.lineTo(7.0f, 48.134434f);
                l.close();
                l.moveTo(24.616856f, 15.0f);
                l.cubicTo(18.216589f, 19.392467f, 13.105181f, 25.63808f, 10.0f, 33.0f);
                l.lineTo(42.0f, 33.0f);
                l.lineTo(24.616856f, 15.0f);
                l.close();
                l.moveTo(63.0f, 11.0f);
                l.lineTo(63.0f, 43.0f);
                l.lineTo(81.0f, 25.622782f);
                l.cubicTo(76.60968f, 19.219759f, 70.3637f, 14.106408f, 63.0f, 11.0f);
                l.lineTo(63.0f, 11.0f);
                l.close();
                l.moveTo(32.0f, 84.0f);
                l.lineTo(32.0f, 52.0f);
                l.lineTo(14.0f, 69.37412f);
                l.cubicTo(18.39201f, 75.77617f, 24.637726f, 80.88998f, 32.0f, 84.0f);
                l.lineTo(32.0f, 84.0f);
                l.close();
                l.moveTo(56.0f, 8.82031f);
                l.cubicTo(53.37215f, 8.282693f, 50.65258f, 8.0f, 47.867496f, 8.0f);
                l.cubicTo(42.61948f, 8.0f, 37.60506f, 9.003309f, 33.0f, 10.826928f);
                l.lineTo(56.0f, 34.0f);
                l.lineTo(56.0f, 8.82031f);
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
