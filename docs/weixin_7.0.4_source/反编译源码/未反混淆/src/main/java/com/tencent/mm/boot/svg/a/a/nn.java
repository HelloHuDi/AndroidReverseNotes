package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class nn extends c {
    private final int height = 39;
    private final int width = 39;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 39;
            case 1:
                return 39;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix h = c.h(looper);
                float[] g = c.g(looper);
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
                canvas.saveLayerAlpha(null, 128, 4);
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-4210753);
                g = c.a(g, 1.0f, 0.0f, -267.0f, 0.0f, 1.0f, -942.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(290.74658f, 962.3673f);
                l.lineTo(281.66696f, 950.38226f);
                l.cubicTo(281.66696f, 950.38226f, 280.0749f, 947.686f, 281.897f, 946.12305f);
                l.cubicTo(285.0006f, 943.46094f, 288.86172f, 945.6186f, 292.41647f, 942.0f);
                l.cubicTo(293.6008f, 943.90704f, 293.0603f, 947.8834f, 290.84427f, 948.8545f);
                l.cubicTo(288.6282f, 949.82556f, 285.94733f, 949.9153f, 285.94733f, 949.9153f);
                l.lineTo(295.2846f, 966.53125f);
                l.lineTo(295.0269f, 966.30566f);
                l.cubicTo(295.32394f, 967.01917f, 295.48572f, 967.7877f, 295.48572f, 968.5886f);
                l.cubicTo(295.48572f, 972.3405f, 291.93597f, 975.38196f, 287.55713f, 975.38196f);
                l.cubicTo(283.1783f, 975.38196f, 279.62857f, 972.3405f, 279.62857f, 968.5886f);
                l.cubicTo(279.62857f, 964.8368f, 283.1783f, 961.7953f, 287.55713f, 961.7953f);
                l.cubicTo(288.6917f, 961.7953f, 289.77066f, 961.9995f, 290.74658f, 962.3673f);
                l.close();
                l.moveTo(278.57144f, 946.18054f);
                l.lineTo(278.57144f, 948.52997f);
                l.cubicTo(273.52835f, 951.2919f, 270.1143f, 956.6069f, 270.1143f, 962.7102f);
                l.cubicTo(270.1143f, 971.657f, 277.4504f, 978.9097f, 286.5f, 978.9097f);
                l.cubicTo(295.5496f, 978.9097f, 302.8857f, 971.657f, 302.8857f, 962.7102f);
                l.cubicTo(302.8857f, 957.0437f, 299.94287f, 952.0567f, 295.48572f, 949.1616f);
                l.lineTo(295.48572f, 946.719f);
                l.cubicTo(301.1608f, 949.8425f, 305.0f, 955.8331f, 305.0f, 962.7102f);
                l.cubicTo(305.0f, 972.8114f, 296.71725f, 981.0f, 286.5f, 981.0f);
                l.cubicTo(276.28275f, 981.0f, 268.0f, 972.8114f, 268.0f, 962.7102f);
                l.cubicTo(268.0f, 955.4142f, 272.3212f, 949.11597f, 278.57144f, 946.18054f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
