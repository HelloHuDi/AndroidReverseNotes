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

public final class ajk extends c {
    private final int height = 24;
    private final int width = 120;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 24;
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
                k = c.a(k, looper);
                k.setColor(-1);
                canvas.saveLayerAlpha(null, 76, 4);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(60.0f, 24.0f);
                l.cubicTo(66.62742f, 24.0f, 72.0f, 18.627417f, 72.0f, 12.0f);
                l.cubicTo(72.0f, 5.372583f, 66.62742f, 0.0f, 60.0f, 0.0f);
                l.cubicTo(53.37258f, 0.0f, 48.0f, 5.372583f, 48.0f, 12.0f);
                l.cubicTo(48.0f, 18.627417f, 53.37258f, 24.0f, 60.0f, 24.0f);
                l.close();
                l.moveTo(12.0f, 24.0f);
                l.cubicTo(18.627417f, 24.0f, 24.0f, 18.627417f, 24.0f, 12.0f);
                l.cubicTo(24.0f, 5.372583f, 18.627417f, 0.0f, 12.0f, 0.0f);
                l.cubicTo(5.372583f, 0.0f, 0.0f, 5.372583f, 0.0f, 12.0f);
                l.cubicTo(0.0f, 18.627417f, 5.372583f, 24.0f, 12.0f, 24.0f);
                l.close();
                l.moveTo(108.0f, 24.0f);
                l.cubicTo(114.62742f, 24.0f, 120.0f, 18.627417f, 120.0f, 12.0f);
                l.cubicTo(120.0f, 5.372583f, 114.62742f, 0.0f, 108.0f, 0.0f);
                l.cubicTo(101.37258f, 0.0f, 96.0f, 5.372583f, 96.0f, 12.0f);
                l.cubicTo(96.0f, 18.627417f, 101.37258f, 24.0f, 108.0f, 24.0f);
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
