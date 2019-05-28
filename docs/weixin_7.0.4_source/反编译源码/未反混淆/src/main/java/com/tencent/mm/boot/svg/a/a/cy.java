package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.appbrand.jsapi.g.d;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class cy extends c {
    private final int height = d.CTRL_INDEX;
    private final int width = d.CTRL_INDEX;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return d.CTRL_INDEX;
            case 1:
                return d.CTRL_INDEX;
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
                a.setColor(-4605512);
                Path l = c.l(looper);
                l.moveTo(67.0f, 134.0f);
                l.cubicTo(104.003075f, 134.0f, 134.0f, 104.003075f, 134.0f, 67.0f);
                l.cubicTo(134.0f, 29.996922f, 104.003075f, 0.0f, 67.0f, 0.0f);
                l.cubicTo(29.996922f, 0.0f, 0.0f, 29.996922f, 0.0f, 67.0f);
                l.cubicTo(0.0f, 104.003075f, 29.996922f, 134.0f, 67.0f, 134.0f);
                l.close();
                l.moveTo(67.0f, 133.0f);
                l.cubicTo(103.45079f, 133.0f, 133.0f, 103.45079f, 133.0f, 67.0f);
                l.cubicTo(133.0f, 30.549206f, 103.45079f, 1.0f, 67.0f, 1.0f);
                l.cubicTo(30.549206f, 1.0f, 1.0f, 30.549206f, 1.0f, 67.0f);
                l.cubicTo(1.0f, 103.45079f, 30.549206f, 133.0f, 67.0f, 133.0f);
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
