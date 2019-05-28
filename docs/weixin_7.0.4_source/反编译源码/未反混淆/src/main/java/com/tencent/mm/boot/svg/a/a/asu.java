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

public final class asu extends c {
    private final int height = 54;
    private final int width = 54;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 54;
            case 1:
                return 54;
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
                l.moveTo(35.48387f, 28.66256f);
                l.lineTo(35.48387f, 37.66291f);
                l.cubicTo(35.48387f, 38.4582f, 34.83916f, 39.10291f, 34.043873f, 39.10291f);
                l.lineTo(6.44f, 39.10291f);
                l.cubicTo(5.64471f, 39.10291f, 5.0f, 38.4582f, 5.0f, 37.66291f);
                l.lineTo(5.0f, 16.157227f);
                l.cubicTo(5.0f, 15.361936f, 5.64471f, 14.717226f, 6.44f, 14.717226f);
                l.lineTo(34.043873f, 14.717226f);
                l.cubicTo(34.83916f, 14.717226f, 35.48387f, 15.361936f, 35.48387f, 16.157227f);
                l.lineTo(35.48387f, 25.287582f);
                l.cubicTo(38.18783f, 22.945694f, 46.986294f, 14.808152f, 47.822582f, 14.082182f);
                l.cubicTo(48.88459f, 13.782787f, 50.0f, 14.307455f, 50.0f, 15.557618f);
                l.lineTo(50.0f, 38.42688f);
                l.cubicTo(50.0f, 39.543766f, 48.99135f, 40.27374f, 47.822582f, 39.902317f);
                l.cubicTo(47.261726f, 39.311028f, 38.312565f, 31.01308f, 35.48387f, 28.66256f);
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
