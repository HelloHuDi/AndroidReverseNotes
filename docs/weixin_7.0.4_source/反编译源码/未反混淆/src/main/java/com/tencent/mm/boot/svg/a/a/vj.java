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

public final class vj extends c {
    private final int height = 100;
    private final int width = 100;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 100;
            case 1:
                return 100;
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
                k.setColor(-1686720);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(51.515152f, 100.0f);
                l.cubicTo(22.385763f, 100.0f, 0.0f, 77.614235f, 0.0f, 51.515152f);
                l.cubicTo(0.0f, 22.385763f, 22.385763f, 0.0f, 51.515152f, 0.0f);
                l.cubicTo(77.614235f, 0.0f, 100.0f, 22.385763f, 100.0f, 51.515152f);
                l.cubicTo(100.0f, 77.614235f, 77.614235f, 100.0f, 51.515152f, 100.0f);
                l.close();
                l.moveTo(45.567917f, 25.108103f);
                l.lineTo(47.272728f, 60.909092f);
                l.lineTo(54.545456f, 60.909092f);
                l.lineTo(56.250263f, 25.108103f);
                l.cubicTo(56.309967f, 23.85433f, 55.341984f, 22.789549f, 54.08821f, 22.729845f);
                l.cubicTo(54.052204f, 22.72813f, 54.01616f, 22.727272f, 53.98011f, 22.727272f);
                l.lineTo(47.838074f, 22.727272f);
                l.cubicTo(46.582882f, 22.727272f, 45.565346f, 23.744808f, 45.565346f, 25.0f);
                l.cubicTo(45.565346f, 25.036049f, 45.566204f, 25.072094f, 45.567917f, 25.108103f);
                l.close();
                l.moveTo(50.909092f, 76.818184f);
                l.cubicTo(53.921555f, 76.818184f, 56.363636f, 74.3761f, 56.363636f, 71.36364f);
                l.cubicTo(56.363636f, 68.35117f, 53.921555f, 65.90909f, 50.909092f, 65.90909f);
                l.cubicTo(47.89663f, 65.90909f, 45.454544f, 68.35117f, 45.454544f, 71.36364f);
                l.cubicTo(45.454544f, 74.3761f, 47.89663f, 76.818184f, 50.909092f, 76.818184f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
