package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import android.support.v4.widget.j;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class age extends c {
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
                a.setColor(j.INVALID_ID);
                Path l = c.l(looper);
                l.moveTo(0.0f, 9.6f);
                l.cubicTo(0.0f, 4.298066f, 4.298066f, 0.0f, 9.6f, 0.0f);
                l.lineTo(86.4f, 0.0f);
                l.cubicTo(91.701935f, 0.0f, 96.0f, 4.298066f, 96.0f, 9.6f);
                l.lineTo(96.0f, 86.4f);
                l.cubicTo(96.0f, 91.701935f, 91.701935f, 96.0f, 86.4f, 96.0f);
                l.lineTo(9.6f, 96.0f);
                l.cubicTo(4.298066f, 96.0f, 0.0f, 91.701935f, 0.0f, 86.4f);
                l.lineTo(0.0f, 9.6f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k2 = c.a(k, looper);
                k2.setColor(-1);
                Path l2 = c.l(looper);
                l2.moveTo(48.0f, 45.001343f);
                l2.lineTo(30.427227f, 27.428572f);
                l2.lineTo(27.428572f, 30.427227f);
                l2.lineTo(45.001343f, 48.0f);
                l2.lineTo(27.428572f, 65.57277f);
                l2.lineTo(30.427227f, 68.57143f);
                l2.lineTo(48.0f, 50.998657f);
                l2.lineTo(65.57277f, 68.57143f);
                l2.lineTo(68.57143f, 65.57277f);
                l2.lineTo(50.998657f, 48.0f);
                l2.lineTo(68.57143f, 30.427227f);
                l2.lineTo(65.57277f, 27.428572f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, k2);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
