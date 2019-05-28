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

public final class azr extends c {
    private final int height = 180;
    private final int width = 120;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 180;
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
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-1);
                Path l = c.l(looper);
                l.moveTo(24.0f, 76.0f);
                l.lineTo(24.0f, 98.23779f);
                l.cubicTo(24.0f, 121.084274f, 40.67616f, 139.71544f, 62.0f, 141.80502f);
                l.lineTo(62.0f, 152.0f);
                l.lineTo(70.0f, 152.0f);
                l.lineTo(70.0f, 141.80527f);
                l.lineTo(70.0f, 141.80527f);
                l.cubicTo(91.31973f, 139.7189f, 108.0f, 121.12331f, 108.0f, 98.434006f);
                l.lineTo(108.0f, 76.0f);
                l.lineTo(100.0f, 76.0f);
                l.lineTo(100.0f, 98.63076f);
                l.cubicTo(100.0f, 118.188705f, 84.77768f, 134.0f, 66.0f, 134.0f);
                l.cubicTo(47.21819f, 134.0f, 32.0f, 118.16465f, 32.0f, 98.63076f);
                l.lineTo(32.0f, 76.0f);
                l.lineTo(24.0f, 76.0f);
                l.lineTo(24.0f, 76.0f);
                l.close();
                l.moveTo(38.0f, 152.0f);
                l.cubicTo(35.79086f, 152.0f, 34.0f, 153.79086f, 34.0f, 156.0f);
                l.cubicTo(34.0f, 158.20914f, 35.79086f, 160.0f, 38.0f, 160.0f);
                l.lineTo(94.0f, 160.0f);
                l.cubicTo(96.20914f, 160.0f, 98.0f, 158.20914f, 98.0f, 156.0f);
                l.cubicTo(98.0f, 153.79086f, 96.20914f, 152.0f, 94.0f, 152.0f);
                l.lineTo(38.0f, 152.0f);
                l.close();
                l.moveTo(40.0f, 98.66034f);
                l.cubicTo(40.0f, 113.75961f, 51.63744f, 126.0f, 66.0f, 126.0f);
                l.cubicTo(80.359406f, 126.0f, 92.0f, 113.77821f, 92.0f, 98.66034f);
                l.lineTo(92.0f, 45.339664f);
                l.cubicTo(92.0f, 30.240385f, 80.362564f, 18.0f, 66.0f, 18.0f);
                l.cubicTo(51.6406f, 18.0f, 40.0f, 30.22179f, 40.0f, 45.339664f);
                l.lineTo(40.0f, 98.66034f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = c.a(k, looper);
                a.setColor(-1);
                l = c.l(looper);
                l.moveTo(104.0f, 80.0f);
                l.cubicTo(106.20914f, 80.0f, 108.0f, 78.20914f, 108.0f, 76.0f);
                l.cubicTo(108.0f, 73.79086f, 106.20914f, 72.0f, 104.0f, 72.0f);
                l.cubicTo(101.79086f, 72.0f, 100.0f, 73.79086f, 100.0f, 76.0f);
                l.cubicTo(100.0f, 78.20914f, 101.79086f, 80.0f, 104.0f, 80.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-1);
                l = c.l(looper);
                l.moveTo(28.0f, 80.0f);
                l.cubicTo(30.209139f, 80.0f, 32.0f, 78.20914f, 32.0f, 76.0f);
                l.cubicTo(32.0f, 73.79086f, 30.209139f, 72.0f, 28.0f, 72.0f);
                l.cubicTo(25.790861f, 72.0f, 24.0f, 73.79086f, 24.0f, 76.0f);
                l.cubicTo(24.0f, 78.20914f, 25.790861f, 80.0f, 28.0f, 80.0f);
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
