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

public final class jp extends c {
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
                k.setColor(-8683387);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(11.0f, 67.75325f);
                l.lineTo(11.0f, 67.75325f);
                l.lineTo(11.0f, 63.701298f);
                l.cubicTo(11.007332f, 66.43168f, 12.668421f, 69.08772f, 15.0f, 70.792206f);
                l.lineTo(15.0f, 70.792206f);
                l.lineTo(43.0f, 87.0f);
                l.cubicTo(43.626083f, 86.7779f, 43.811207f, 86.89193f, 44.0f, 87.0f);
                l.lineTo(44.0f, 53.57143f);
                l.lineTo(11.0f, 34.324677f);
                l.lineTo(11.0f, 67.75325f);
                l.close();
                l.moveTo(52.0f, 53.57143f);
                l.lineTo(52.0f, 87.0f);
                l.cubicTo(52.188793f, 86.89292f, 52.373917f, 86.77946f, 53.0f, 87.0f);
                l.lineTo(81.0f, 70.792206f);
                l.lineTo(81.0f, 70.792206f);
                l.cubicTo(83.33158f, 69.17696f, 84.99267f, 66.53409f, 85.0f, 63.701298f);
                l.lineTo(85.0f, 68.766235f);
                l.lineTo(85.0f, 68.766235f);
                l.lineTo(85.0f, 34.324677f);
                l.lineTo(52.0f, 53.57143f);
                l.close();
                l.moveTo(53.0f, 10.012987f);
                l.cubicTo(51.805397f, 9.510585f, 50.266872f, 9.0f, 49.0f, 9.0f);
                l.cubicTo(46.95472f, 9.0f, 45.416195f, 9.510585f, 44.0f, 10.012987f);
                l.lineTo(16.0f, 27.233767f);
                l.lineTo(48.0f, 46.48052f);
                l.lineTo(81.0f, 27.233767f);
                l.lineTo(53.0f, 10.012987f);
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
