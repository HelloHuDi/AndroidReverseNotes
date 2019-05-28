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

public final class ml extends c {
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
                canvas.saveLayerAlpha(null, 38, 4);
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                g = c.a(g, 1.0f, 0.0f, -1538.0f, 0.0f, 1.0f, -387.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(1539.7643f, 389.7639f);
                l.cubicTo(1539.5017f, 389.20786f, 1539.599f, 388.5254f, 1540.0621f, 388.06216f);
                l.cubicTo(1540.6488f, 387.47556f, 1541.5945f, 387.47012f, 1542.1871f, 388.06277f);
                l.lineTo(1548.1244f, 394.0f);
                l.lineTo(1570.9926f, 394.0f);
                l.cubicTo(1572.6536f, 394.0f, 1574.0f, 395.3431f, 1574.0f, 397.00793f);
                l.lineTo(1574.0f, 416.99207f);
                l.cubicTo(1574.0f, 417.79092f, 1573.6871f, 418.51703f, 1573.1799f, 419.05563f);
                l.lineTo(1577.2443f, 423.11996f);
                l.cubicTo(1577.8313f, 423.70694f, 1577.8357f, 424.6542f, 1577.2449f, 425.24493f);
                l.cubicTo(1576.784f, 425.70578f, 1576.1017f, 425.80792f, 1575.5428f, 425.5432f);
                l.cubicTo(1575.4706f, 425.39014f, 1575.371f, 425.24667f, 1575.2443f, 425.11996f);
                l.lineTo(1540.1871f, 390.06277f);
                l.cubicTo(1540.06f, 389.93573f, 1539.9167f, 389.83615f, 1539.7643f, 389.7639f);
                l.close();
                l.moveTo(1540.0359f, 394.16028f);
                l.cubicTo(1538.8513f, 394.5642f, 1538.0f, 395.68658f, 1538.0f, 397.00793f);
                l.lineTo(1538.0f, 416.99207f);
                l.cubicTo(1538.0f, 418.6569f, 1539.3418f, 420.0f, 1540.9968f, 420.0f);
                l.lineTo(1547.0f, 420.0f);
                l.lineTo(1547.0f, 426.8875f);
                l.cubicTo(1547.0f, 428.08762f, 1547.6836f, 428.36902f, 1548.5267f, 427.5205f);
                l.lineTo(1556.0f, 420.0f);
                l.lineTo(1565.8756f, 420.0f);
                l.lineTo(1540.0359f, 394.16028f);
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
