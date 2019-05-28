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

public final class baw extends c {
    private final int height = 102;
    private final int width = 102;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 102;
            case 1:
                return 102;
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
                k2 = c.a(k2, looper);
                k2.setStrokeWidth(1.0f);
                Paint a = c.a(k, looper);
                a.setColor(-986896);
                Path l = c.l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(102.0f, 0.0f);
                l.lineTo(102.0f, 102.0f);
                l.lineTo(0.0f, 102.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.saveLayerAlpha(null, 0, 4);
                canvas.drawPath(l, c.a(a, looper));
                canvas.restore();
                canvas.save();
                Paint a2 = c.a(k2, looper);
                a2.setColor(-11048043);
                a2.setStrokeWidth(6.0f);
                Path l2 = c.l(looper);
                l2.moveTo(24.0f, 50.0f);
                l2.cubicTo(24.0f, 48.89543f, 24.89543f, 48.0f, 26.0f, 48.0f);
                l2.lineTo(76.0f, 48.0f);
                l2.cubicTo(77.10457f, 48.0f, 78.0f, 48.89543f, 78.0f, 50.0f);
                l2.lineTo(78.0f, 79.0f);
                l2.cubicTo(78.0f, 80.10457f, 77.10457f, 81.0f, 76.0f, 81.0f);
                l2.lineTo(26.0f, 81.0f);
                l2.cubicTo(24.89543f, 81.0f, 24.0f, 80.10457f, 24.0f, 79.0f);
                l2.lineTo(24.0f, 50.0f);
                l2.close();
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(k, looper);
                a2.setColor(-11048043);
                l2 = c.l(looper);
                l2.moveTo(28.5f, 35.0f);
                l2.cubicTo(28.5f, 22.573593f, 38.573593f, 12.5f, 51.0f, 12.5f);
                l2.cubicTo(63.426407f, 12.5f, 73.5f, 22.573593f, 73.5f, 35.0f);
                l2.lineTo(67.5f, 35.0f);
                l2.cubicTo(67.5f, 25.887302f, 60.112698f, 18.5f, 51.0f, 18.5f);
                l2.cubicTo(41.887302f, 18.5f, 34.5f, 25.887302f, 34.5f, 35.0f);
                l2.lineTo(28.5f, 35.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.save();
                k2 = c.a(k, looper);
                k2.setColor(-11048043);
                Path l3 = c.l(looper);
                l3.moveTo(28.5f, 35.0f);
                l3.lineTo(34.5f, 35.0f);
                l3.lineTo(34.5f, 47.0f);
                l3.lineTo(28.5f, 47.0f);
                l3.lineTo(28.5f, 35.0f);
                l3.close();
                canvas.drawPath(l3, k2);
                canvas.restore();
                canvas.save();
                k = c.a(k, looper);
                k.setColor(-11048043);
                l2 = c.l(looper);
                l2.moveTo(67.5f, 35.0f);
                l2.lineTo(73.5f, 35.0f);
                l2.lineTo(73.5f, 35.0f);
                l2.lineTo(73.5f, 35.0f);
                l2.cubicTo(73.5f, 36.656853f, 72.15685f, 38.0f, 70.5f, 38.0f);
                l2.lineTo(70.5f, 38.0f);
                l2.lineTo(70.5f, 38.0f);
                l2.cubicTo(68.84315f, 38.0f, 67.5f, 36.656853f, 67.5f, 35.0f);
                l2.lineTo(67.5f, 35.0f);
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
