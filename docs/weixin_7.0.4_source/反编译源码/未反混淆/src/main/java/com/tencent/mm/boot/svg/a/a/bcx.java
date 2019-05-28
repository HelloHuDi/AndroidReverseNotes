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

public final class bcx extends c {
    private final int height = 116;
    private final int width = 132;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 132;
            case 1:
                return 116;
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
                k.setColor(-15028967);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(48.0f, 73.0f);
                l.cubicTo(47.41073f, 73.67583f, 46.739857f, 73.84797f, 46.0f, 74.0f);
                l.cubicTo(44.37787f, 73.84797f, 42.943207f, 72.94284f, 42.0f, 71.0f);
                l.lineTo(42.0f, 71.0f);
                l.lineTo(30.0f, 45.0f);
                l.cubicTo(29.756216f, 44.430573f, 29.674448f, 44.108505f, 30.0f, 44.0f);
                l.cubicTo(29.674448f, 42.58331f, 30.659384f, 41.6023f, 32.0f, 41.0f);
                l.cubicTo(32.369083f, 41.6023f, 32.824383f, 41.763332f, 33.0f, 42.0f);
                l.lineTo(48.0f, 52.0f);
                l.cubicTo(48.406815f, 52.767323f, 49.64449f, 53.16343f, 51.0f, 53.0f);
                l.cubicTo(51.768604f, 53.16343f, 52.52682f, 53.01535f, 53.0f, 53.0f);
                l.lineTo(120.0f, 23.0f);
                l.cubicTo(107.96013f, 9.1696825f, 88.276276f, 0.0f, 66.0f, 0.0f);
                l.cubicTo(29.548079f, 0.0f, 0.0f, 24.525291f, 0.0f, 54.0f);
                l.cubicTo(0.0f, 71.28993f, 8.890441f, 86.14763f, 23.0f, 96.0f);
                l.cubicTo(23.920935f, 96.98503f, 24.651274f, 98.28811f, 25.0f, 100.0f);
                l.cubicTo(24.651274f, 100.24644f, 24.547205f, 100.69251f, 25.0f, 101.0f);
                l.cubicTo(23.307673f, 105.28476f, 21.529213f, 111.89641f, 21.0f, 112.0f);
                l.cubicTo(21.308067f, 112.72379f, 21.090637f, 113.264275f, 21.0f, 114.0f);
                l.cubicTo(21.090637f, 115.01899f, 22.075573f, 116.0f, 23.0f, 116.0f);
                l.cubicTo(23.768549f, 116.0f, 24.158806f, 115.8223f, 25.0f, 116.0f);
                l.lineTo(39.0f, 107.0f);
                l.cubicTo(40.09804f, 106.65818f, 41.248375f, 106.271324f, 42.0f, 106.0f);
                l.cubicTo(43.19037f, 106.271324f, 43.84266f, 106.37498f, 45.0f, 106.0f);
                l.cubicTo(51.198086f, 108.492485f, 58.469887f, 109.56605f, 66.0f, 110.0f);
                l.cubicTo(102.450066f, 109.56605f, 132.0f, 85.0389f, 132.0f, 54.0f);
                l.cubicTo(132.0f, 45.617043f, 129.27563f, 36.987843f, 124.0f, 29.0f);
                l.lineTo(48.0f, 73.0f);
                l.lineTo(48.0f, 73.0f);
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
