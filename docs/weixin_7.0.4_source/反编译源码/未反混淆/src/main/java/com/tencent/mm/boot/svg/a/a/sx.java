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

public final class sx extends c {
    private final int height = 72;
    private final int width = 72;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                a.setColor(-436207616);
                g = c.a(g, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 15.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(48.853916f, 22.935286f);
                l.cubicTo(53.186268f, 18.470255f, 53.135693f, 11.344611f, 48.730064f, 6.9389825f);
                l.cubicTo(44.278088f, 2.4870057f, 37.06001f, 2.4870057f, 32.60803f, 6.9389825f);
                l.cubicTo(32.031235f, 7.515777f, 31.29962f, 8.221499f, 30.409842f, 9.059835f);
                l.lineTo(27.941126f, 11.385826f);
                l.lineTo(25.47241f, 9.059835f);
                l.cubicTo(24.582632f, 8.221499f, 23.851015f, 7.515777f, 23.274221f, 6.9389825f);
                l.cubicTo(18.822245f, 2.4870057f, 11.604163f, 2.4870057f, 7.152186f, 6.9389825f);
                l.cubicTo(2.7466114f, 11.344558f, 2.6957495f, 18.470612f, 6.989021f, 22.897852f);
                l.lineTo(27.940998f, 43.850048f);
                l.lineTo(48.853916f, 22.935286f);
                l.close();
                l.moveTo(4.6066017f, 4.3933983f);
                l.cubicTo(10.464466f, -1.4644661f, 19.96194f, -1.4644661f, 25.819805f, 4.3933983f);
                l.cubicTo(26.368225f, 4.941818f, 27.075333f, 5.623898f, 27.941126f, 6.4396367f);
                l.cubicTo(28.80692f, 5.623898f, 29.514027f, 4.941818f, 30.062447f, 4.3933983f);
                l.cubicTo(35.92031f, -1.4644661f, 45.417786f, -1.4644661f, 51.27565f, 4.3933983f);
                l.cubicTo(57.079025f, 10.196773f, 57.133007f, 19.572361f, 51.4376f, 25.442194f);
                l.lineTo(30.062447f, 46.819805f);
                l.cubicTo(28.890934f, 47.99144f, 26.99144f, 47.99154f, 25.819805f, 46.820026f);
                l.lineTo(4.4434233f, 25.443422f);
                l.cubicTo(-1.2507558f, 19.572361f, -1.1967729f, 10.196773f, 4.6066017f, 4.3933983f);
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
