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

public final class avd extends c {
    private final int height = 144;
    private final int width = 144;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                k2 = c.a(k, looper);
                k2.setColor(-1710619);
                Path l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(144.0f, 0.0f);
                l.lineTo(144.0f, 146.0f);
                l.lineTo(0.0f, 146.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                Path l2 = c.l(looper);
                l2.moveTo(59.612698f, 75.461945f);
                l2.lineTo(95.98885f, 75.461945f);
                l2.lineTo(95.98885f, 69.461945f);
                l2.lineTo(59.357864f, 69.461945f);
                l2.lineTo(75.57716f, 53.24264f);
                l2.lineTo(71.334526f, 49.0f);
                l2.lineTo(48.0f, 72.334526f);
                l2.lineTo(50.12132f, 74.45584f);
                l2.lineTo(71.334526f, 95.669044f);
                l2.lineTo(75.57716f, 91.42641f);
                l2.lineTo(59.612698f, 75.461945f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, k);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
