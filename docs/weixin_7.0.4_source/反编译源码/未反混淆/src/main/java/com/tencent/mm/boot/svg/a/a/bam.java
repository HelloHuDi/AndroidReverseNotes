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

public final class bam extends c {
    private final int height = 240;
    private final int width = 240;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 240;
            case 1:
                return 240;
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
                a.setColor(-407039);
                Path l = c.l(looper);
                l.moveTo(120.0f, 0.0f);
                l.cubicTo(186.27417f, 0.0f, 240.0f, 53.72583f, 240.0f, 120.0f);
                l.cubicTo(240.0f, 186.27417f, 186.27417f, 240.0f, 120.0f, 240.0f);
                l.cubicTo(53.72583f, 240.0f, 0.0f, 186.27417f, 0.0f, 120.0f);
                l.cubicTo(0.0f, 53.72583f, 53.72583f, 0.0f, 120.0f, 0.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                a = c.a(k, looper);
                a.setColor(-1);
                l = c.l(looper);
                l.moveTo(120.0f, 21.0f);
                l.cubicTo(174.6762f, 21.0f, 219.0f, 65.32381f, 219.0f, 120.0f);
                l.cubicTo(219.0f, 174.6762f, 174.6762f, 219.0f, 120.0f, 219.0f);
                l.cubicTo(65.32381f, 219.0f, 21.0f, 174.6762f, 21.0f, 120.0f);
                l.cubicTo(21.0f, 65.32381f, 65.32381f, 21.0f, 120.0f, 21.0f);
                l.close();
                canvas.saveLayerAlpha(null, 102, 4);
                canvas.drawPath(l, c.a(a, looper));
                canvas.restore();
                canvas.save();
                k2 = c.a(k, looper);
                k2.setColor(-407039);
                Path l2 = c.l(looper);
                l2.moveTo(125.57143f, 108.0f);
                l2.lineTo(142.28572f, 72.0f);
                l2.lineTo(159.0f, 72.0f);
                l2.lineTo(142.28572f, 108.0f);
                l2.lineTo(159.0f, 108.0f);
                l2.lineTo(159.0f, 123.0f);
                l2.lineTo(126.0f, 123.0f);
                l2.lineTo(126.0f, 135.0f);
                l2.lineTo(159.0f, 135.0f);
                l2.lineTo(159.0f, 150.0f);
                l2.lineTo(126.0f, 150.0f);
                l2.lineTo(126.0f, 171.0f);
                l2.lineTo(114.0f, 171.0f);
                l2.lineTo(114.0f, 150.0f);
                l2.lineTo(81.0f, 150.0f);
                l2.lineTo(81.0f, 135.0f);
                l2.lineTo(114.0f, 135.0f);
                l2.lineTo(114.0f, 123.0f);
                l2.lineTo(81.0f, 123.0f);
                l2.lineTo(81.0f, 108.0f);
                l2.lineTo(97.71429f, 108.0f);
                l2.lineTo(81.0f, 72.0f);
                l2.lineTo(97.71429f, 72.0f);
                l2.lineTo(114.42857f, 108.0f);
                l2.lineTo(125.57143f, 108.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, k2);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
