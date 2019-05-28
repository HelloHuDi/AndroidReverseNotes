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

public final class z extends c {
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
                canvas.saveLayerAlpha(null, 230, 4);
                k = c.a(k, looper);
                k.setColor(-855638017);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(36.0f, 60.0f);
                l.cubicTo(22.745167f, 60.0f, 12.0f, 49.254833f, 12.0f, 36.0f);
                l.cubicTo(12.0f, 22.745167f, 22.745167f, 12.0f, 36.0f, 12.0f);
                l.cubicTo(49.254833f, 12.0f, 60.0f, 22.745167f, 60.0f, 36.0f);
                l.cubicTo(60.0f, 49.254833f, 49.254833f, 60.0f, 36.0f, 60.0f);
                l.close();
                l.moveTo(36.0f, 32.938873f);
                l.lineTo(27.061129f, 24.0f);
                l.lineTo(24.0f, 27.061129f);
                l.lineTo(32.938873f, 36.0f);
                l.lineTo(24.0f, 44.938873f);
                l.lineTo(27.061129f, 48.0f);
                l.lineTo(36.0f, 39.061127f);
                l.lineTo(44.938873f, 48.0f);
                l.lineTo(48.0f, 44.938873f);
                l.lineTo(39.061127f, 36.0f);
                l.lineTo(48.0f, 27.061129f);
                l.lineTo(44.938873f, 24.0f);
                l.lineTo(36.0f, 32.938873f);
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
