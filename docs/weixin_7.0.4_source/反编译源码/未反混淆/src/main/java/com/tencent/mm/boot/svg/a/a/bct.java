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
import com.tencent.view.d;

public final class bct extends c {
    private final int height = 242;
    private final int width = d.MIC_PTU_ZIPAI_LIGHTWHITE;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return d.MIC_PTU_ZIPAI_LIGHTWHITE;
            case 1:
                return 242;
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
                Paint a = c.a(k2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                Paint a2 = c.a(k, looper);
                a2.setColor(-3552823);
                g = c.a(g, 1.0f, 0.0f, 55.0f, 0.0f, 1.0f, 75.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                Path l = c.l(looper);
                l.moveTo(134.481f, 27.64f);
                l.lineTo(125.895f, 36.226f);
                l.cubicTo(110.961f, 21.261f, 90.312f, 12.0f, 67.499f, 12.0f);
                l.cubicTo(44.686f, 12.0f, 24.037f, 21.261f, 9.103f, 36.226f);
                l.lineTo(0.517f, 27.64f);
                l.cubicTo(17.694f, 10.56f, 41.362f, 0.0f, 67.499f, 0.0f);
                l.cubicTo(93.636f, 0.0f, 117.304f, 10.56f, 134.481f, 27.64f);
                l.lineTo(134.481f, 27.64f);
                l.close();
                l.moveTo(115.389f, 46.732f);
                l.lineTo(106.807f, 55.314f);
                l.cubicTo(96.758f, 45.234f, 82.859f, 38.996f, 67.501f, 38.996f);
                l.cubicTo(52.142f, 38.996f, 38.242f, 45.235f, 28.192f, 55.316f);
                l.lineTo(19.608f, 46.732f);
                l.cubicTo(31.899f, 34.537f, 48.817f, 27.0f, 67.499f, 27.0f);
                l.cubicTo(86.181f, 27.0f, 103.098f, 34.537f, 115.389f, 46.732f);
                l.lineTo(115.389f, 46.732f);
                l.close();
                l.moveTo(96.196f, 65.925f);
                l.lineTo(87.607f, 74.514f);
                l.cubicTo(82.517f, 69.262f, 75.393f, 65.993f, 67.502f, 65.993f);
                l.cubicTo(59.609f, 65.993f, 52.484f, 69.263f, 47.394f, 74.517f);
                l.lineTo(38.802f, 65.925f);
                l.cubicTo(46.135f, 58.56f, 56.284f, 54.0f, 67.499f, 54.0f);
                l.cubicTo(78.714f, 54.0f, 88.862f, 58.56f, 96.196f, 65.925f);
                l.lineTo(96.196f, 65.925f);
                l.close();
                l.moveTo(77.2f, 84.921f);
                l.lineTo(67.498f, 94.623f);
                l.lineTo(57.796f, 84.922f);
                l.cubicTo(60.314f, 82.497f, 63.729f, 81.0f, 67.499f, 81.0f);
                l.cubicTo(71.269f, 81.0f, 74.683f, 82.497f, 77.2f, 84.921f);
                l.lineTo(77.2f, 84.921f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a3 = c.a(a, looper);
                a3.setColor(-3552823);
                a3.setStrokeWidth(4.0f);
                l = c.l(looper);
                l.moveTo(123.0f, 7.0f);
                l.cubicTo(185.96046f, 7.0f, 237.0f, 58.039536f, 237.0f, 121.0f);
                l.cubicTo(237.0f, 183.96046f, 185.96046f, 235.0f, 123.0f, 235.0f);
                l.cubicTo(60.039536f, 235.0f, 9.0f, 183.96046f, 9.0f, 121.0f);
                l.cubicTo(9.0f, 58.039536f, 60.039536f, 7.0f, 123.0f, 7.0f);
                l.close();
                canvas.drawPath(l, a3);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
