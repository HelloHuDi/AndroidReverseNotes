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

public final class atl extends c {
    private final int height = 90;
    private final int width = 90;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                a.setColor(-27648);
                g = c.a(g, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 11.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(26.41996f, 1.7123995f);
                l.cubicTo(42.029785f, -1.784037f, 59.069595f, 7.9460464f, 64.08954f, 23.090612f);
                l.cubicTo(69.899475f, 38.474934f, 61.969563f, 57.26578f, 46.91973f, 63.879044f);
                l.cubicTo(32.549892f, 71.01177f, 13.600102f, 65.46742f, 5.210196f, 51.84131f);
                l.cubicTo(-2.9097135f, 39.703682f, -1.3797306f, 22.281437f, 8.690157f, 11.712208f);
                l.cubicTo(13.340105f, 6.6174006f, 19.670034f, 3.110974f, 26.41996f, 1.7123995f);
                l.lineTo(26.41996f, 1.7123995f);
                l.close();
                l.moveTo(12.0f, 32.0f);
                l.lineTo(12.0f, 36.0f);
                l.lineTo(54.0f, 36.0f);
                l.lineTo(54.0f, 32.0f);
                l.lineTo(12.0f, 32.0f);
                l.lineTo(12.0f, 32.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
