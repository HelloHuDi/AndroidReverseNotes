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

public final class app extends c {
    private final int height = 290;
    private final int width = 290;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 290;
            case 1:
                return 290;
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
                a.setColor(-3833595);
                Path l = c.l(looper);
                l.moveTo(274.5553f, 275.0f);
                l.cubicTo(245.1193f, 272.369f, 198.0823f, 270.665f, 145.0633f, 270.665f);
                l.cubicTo(92.0443f, 270.665f, 45.0103f, 272.369f, 15.5753f, 275.0f);
                l.lineTo(15.0003f, 275.0f);
                l.cubicTo(17.6523f, 245.596f, 19.3733f, 198.364f, 19.3733f, 145.1f);
                l.cubicTo(19.3733f, 91.835f, 17.6523f, 44.606f, 15.0003f, 15.202f);
                l.lineTo(15.0003f, 15.0f);
                l.cubicTo(44.3963f, 17.66f, 91.7033f, 19.386f, 145.0633f, 19.386f);
                l.cubicTo(198.3403f, 19.386f, 245.5833f, 17.665f, 274.9893f, 15.013f);
                l.cubicTo(272.3353f, 44.414f, 270.6143f, 91.664f, 270.6143f, 144.951f);
                l.cubicTo(270.6143f, 198.306f, 272.3403f, 245.607f, 275.0003f, 275.0f);
                l.lineTo(274.5553f, 275.0f);
                l.close();
                l.moveTo(285.1083f, 144.945f);
                l.cubicTo(285.1083f, 85.51f, 287.0283f, 32.808f, 289.9883f, 0.014f);
                l.cubicTo(257.1893f, 2.973f, 204.4943f, 4.892f, 145.0703f, 4.892f);
                l.cubicTo(85.5533f, 4.892f, 32.7883f, 2.966f, 3.0E-4f, 0.0f);
                l.lineTo(3.0E-4f, 0.225f);
                l.cubicTo(2.9583f, 33.022f, 4.8773f, 85.7f, 4.8773f, 145.112f);
                l.cubicTo(4.8773f, 204.522f, 2.9583f, 257.203f, 3.0E-4f, 290.0f);
                l.lineTo(0.6413f, 290.0f);
                l.cubicTo(33.4733f, 287.066f, 85.9343f, 285.165f, 145.0703f, 285.165f);
                l.cubicTo(204.2073f, 285.165f, 256.6723f, 287.066f, 289.5043f, 290.0f);
                l.lineTo(290.0003f, 290.0f);
                l.cubicTo(287.0333f, 257.215f, 285.1083f, 204.456f, 285.1083f, 144.945f);
                l.lineTo(285.1083f, 144.945f);
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
