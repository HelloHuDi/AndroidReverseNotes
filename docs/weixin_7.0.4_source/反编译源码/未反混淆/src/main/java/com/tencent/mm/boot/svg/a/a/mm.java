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

public final class mm extends c {
    private final int height = 42;
    private final int width = 42;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 42;
            case 1:
                return 42;
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
                canvas.saveLayerAlpha(null, 102, 4);
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(-1);
                g = c.a(g, 1.0f, 0.0f, -1491.0f, 0.0f, 1.0f, -387.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(1492.763f, 389.7632f);
                l.cubicTo(1492.5024f, 389.2075f, 1492.6007f, 388.5263f, 1493.0635f, 388.06348f);
                l.cubicTo(1493.6508f, 387.47614f, 1494.6017f, 387.4747f, 1495.1901f, 388.0631f);
                l.lineTo(1501.127f, 394.0f);
                l.lineTo(1523.9926f, 394.0f);
                l.cubicTo(1525.6536f, 394.0f, 1527.0f, 395.3431f, 1527.0f, 397.00793f);
                l.lineTo(1527.0f, 416.99207f);
                l.cubicTo(1527.0f, 417.79025f, 1526.6876f, 418.51584f, 1526.1813f, 419.05432f);
                l.lineTo(1530.607f, 423.48016f);
                l.cubicTo(1531.1942f, 424.0673f, 1531.1981f, 425.01532f, 1530.6067f, 425.60675f);
                l.cubicTo(1530.147f, 426.06656f, 1529.4644f, 426.16727f, 1528.9072f, 425.907f);
                l.cubicTo(1528.8348f, 425.75256f, 1528.7347f, 425.60782f, 1528.607f, 425.48016f);
                l.lineTo(1493.1901f, 390.0631f);
                l.cubicTo(1493.0623f, 389.93536f, 1492.9175f, 389.8354f, 1492.763f, 389.7632f);
                l.close();
                l.moveTo(1493.0339f, 394.16092f);
                l.cubicTo(1491.8503f, 394.56543f, 1491.0f, 395.6873f, 1491.0f, 397.00793f);
                l.lineTo(1491.0f, 416.99207f);
                l.cubicTo(1491.0f, 418.6569f, 1492.3418f, 420.0f, 1493.9968f, 420.0f);
                l.lineTo(1500.0f, 420.0f);
                l.lineTo(1500.0f, 426.8875f);
                l.cubicTo(1500.0f, 428.08762f, 1500.6836f, 428.36902f, 1501.5267f, 427.5205f);
                l.lineTo(1509.0f, 420.0f);
                l.lineTo(1518.873f, 420.0f);
                l.lineTo(1493.0339f, 394.16092f);
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
