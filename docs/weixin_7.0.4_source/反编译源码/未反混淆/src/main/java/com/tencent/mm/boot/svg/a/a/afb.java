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

public final class afb extends c {
    private final int height = 93;
    private final int width = 93;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 93;
            case 1:
                return 93;
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
                g = c.a(g, 1.0f, 0.0f, 31.0f, 0.0f, 1.0f, 31.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.restore();
                Paint a = c.a(k, looper);
                a.setColor(-1);
                canvas.save();
                k = c.a(a, looper);
                Path l = c.l(looper);
                l.moveTo(78.991554f, 14.00827f);
                l.cubicTo(97.66948f, 31.740889f, 97.66948f, 61.25771f, 78.991554f, 78.99145f);
                l.cubicTo(61.258163f, 97.66952f, 31.741741f, 97.66952f, 14.008727f, 78.99145f);
                l.cubicTo(-4.6695757f, 61.25771f, -4.6695757f, 31.740889f, 14.008727f, 14.00827f);
                l.cubicTo(31.740246f, -4.669423f, 61.258163f, -4.669423f, 78.991554f, 14.00827f);
                l.close();
                l.moveTo(86.38453f, 48.423794f);
                l.cubicTo(86.38453f, 25.27637f, 68.759476f, 7.65122f, 48.42406f, 7.65122f);
                l.cubicTo(25.275711f, 7.65122f, 7.6517115f, 25.27637f, 7.6517115f, 48.423794f);
                l.cubicTo(7.6517115f, 68.759315f, 25.276764f, 86.38446f, 45.612175f, 86.38446f);
                l.cubicTo(68.759476f, 86.38446f, 86.38453f, 68.759315f, 86.38453f, 48.423794f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.restore();
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path l2 = c.l(looper);
                l2.moveTo(48.44434f, 43.142254f);
                l2.lineTo(55.190773f, 29.0f);
                l2.lineTo(61.51553f, 29.0f);
                l2.lineTo(54.769096f, 43.142254f);
                l2.lineTo(61.51553f, 43.142254f);
                l2.lineTo(61.51553f, 48.44558f);
                l2.lineTo(49.28777f, 48.44558f);
                l2.lineTo(49.28777f, 53.306904f);
                l2.lineTo(61.51553f, 53.306904f);
                l2.lineTo(61.51553f, 58.61023f);
                l2.lineTo(49.28777f, 58.61023f);
                l2.lineTo(49.28777f, 66.565216f);
                l2.lineTo(44.227966f, 66.565216f);
                l2.lineTo(44.227966f, 58.61023f);
                l2.lineTo(32.0f, 58.61023f);
                l2.lineTo(32.0f, 53.306904f);
                l2.lineTo(44.227966f, 53.306904f);
                l2.lineTo(44.227966f, 48.44558f);
                l2.lineTo(32.0f, 48.44558f);
                l2.lineTo(32.0f, 43.142254f);
                l2.lineTo(38.746433f, 43.142254f);
                l2.lineTo(32.0f, 29.0f);
                l2.lineTo(38.324757f, 29.0f);
                l2.lineTo(45.07119f, 43.142254f);
                l2.lineTo(48.44434f, 43.142254f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a2);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
