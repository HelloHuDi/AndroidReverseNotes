package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.aal */
public final class aal extends C5163c {
    private final int height = 72;
    private final int width = 72;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                C5163c.m7881h(looper);
                C5163c.m7880g(looper);
                Paint k = C5163c.m7883k(looper);
                k.setFlags(385);
                k.setStyle(Style.FILL);
                Paint k2 = C5163c.m7883k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.STROKE);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(1.0f);
                k2.setStrokeCap(Cap.BUTT);
                k2.setStrokeJoin(Join.MITER);
                k2.setStrokeMiter(4.0f);
                k2.setPathEffect(null);
                C5163c.m7876a(k2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                Path l = C5163c.m7884l(looper);
                l.moveTo(9.0f, 16.5f);
                l.lineTo(48.0f, 16.5f);
                l.cubicTo(49.656853f, 16.5f, 51.0f, 17.843145f, 51.0f, 19.5f);
                l.lineTo(51.0f, 52.5f);
                l.cubicTo(51.0f, 54.156853f, 49.656853f, 55.5f, 48.0f, 55.5f);
                l.lineTo(9.0f, 55.5f);
                l.cubicTo(7.343146f, 55.5f, 6.0f, 54.156853f, 6.0f, 52.5f);
                l.lineTo(6.0f, 19.5f);
                l.cubicTo(6.0f, 17.843145f, 7.343146f, 16.5f, 9.0f, 16.5f);
                l.close();
                l.moveTo(54.0f, 30.0f);
                l.lineTo(64.125916f, 21.899267f);
                l.cubicTo(65.4197f, 20.864239f, 67.30758f, 21.074003f, 68.342606f, 22.36779f);
                l.cubicTo(68.76816f, 22.899729f, 69.0f, 23.56066f, 69.0f, 24.241875f);
                l.lineTo(69.0f, 47.758125f);
                l.cubicTo(69.0f, 49.414978f, 67.65685f, 50.758125f, 66.0f, 50.758125f);
                l.cubicTo(65.31879f, 50.758125f, 64.65785f, 50.526283f, 64.125916f, 50.10073f);
                l.lineTo(54.0f, 42.0f);
                l.lineTo(54.0f, 30.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
