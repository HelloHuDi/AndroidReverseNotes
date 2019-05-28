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

public final class i extends c {
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
                canvas.save();
                Paint a = c.a(k, looper);
                a.setColor(1090519039);
                g = c.a(g, 1.0f, 0.0f, 8.0f, 0.0f, 1.0f, 8.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                a = c.a(a, looper);
                g = c.a(g, 0.70710677f, 0.70710677f, -16.568542f, -0.70710677f, 0.70710677f, 40.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l = c.l(looper);
                l.moveTo(37.0f, 37.0f);
                l.lineTo(37.0f, 12.995752f);
                l.cubicTo(37.0f, 12.450768f, 37.44359f, 12.0f, 37.99078f, 12.0f);
                l.lineTo(42.00922f, 12.0f);
                l.cubicTo(42.549026f, 12.0f, 43.0f, 12.445813f, 43.0f, 12.995752f);
                l.lineTo(43.0f, 37.0f);
                l.lineTo(67.00425f, 37.0f);
                l.cubicTo(67.54923f, 37.0f, 68.0f, 37.44359f, 68.0f, 37.99078f);
                l.lineTo(68.0f, 42.00922f);
                l.cubicTo(68.0f, 42.549026f, 67.554184f, 43.0f, 67.00425f, 43.0f);
                l.lineTo(43.0f, 43.0f);
                l.lineTo(43.0f, 67.00425f);
                l.cubicTo(43.0f, 67.54923f, 42.55641f, 68.0f, 42.00922f, 68.0f);
                l.lineTo(37.99078f, 68.0f);
                l.cubicTo(37.450974f, 68.0f, 37.0f, 67.554184f, 37.0f, 67.00425f);
                l.lineTo(37.0f, 43.0f);
                l.lineTo(12.995752f, 43.0f);
                l.cubicTo(12.450768f, 43.0f, 12.0f, 42.55641f, 12.0f, 42.00922f);
                l.lineTo(12.0f, 37.99078f);
                l.cubicTo(12.0f, 37.450974f, 12.445813f, 37.0f, 12.995752f, 37.0f);
                l.lineTo(37.0f, 37.0f);
                l.lineTo(37.0f, 37.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
