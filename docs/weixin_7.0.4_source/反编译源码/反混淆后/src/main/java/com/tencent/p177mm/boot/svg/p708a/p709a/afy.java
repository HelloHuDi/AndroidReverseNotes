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

/* renamed from: com.tencent.mm.boot.svg.a.a.afy */
public final class afy extends C5163c {
    private final int height = 180;
    private final int width = 180;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 180;
            case 1:
                return 180;
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
                a.setColor(1711276032);
                Path l = C5163c.m7884l(looper);
                l.moveTo(90.0f, 0.0f);
                l.cubicTo(139.70563f, 0.0f, 180.0f, 40.29437f, 180.0f, 90.0f);
                l.cubicTo(180.0f, 139.70563f, 139.70563f, 180.0f, 90.0f, 180.0f);
                l.cubicTo(40.29437f, 180.0f, 0.0f, 139.70563f, 0.0f, 90.0f);
                l.cubicTo(0.0f, 40.29437f, 40.29437f, 0.0f, 90.0f, 0.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                l = C5163c.m7884l(looper);
                l.moveTo(69.0f, 59.64535f);
                l.cubicTo(69.0f, 56.333775f, 71.31589f, 54.997013f, 74.19147f, 56.67054f);
                l.lineTo(126.27224f, 86.98049f);
                l.cubicTo(129.1394f, 88.649124f, 129.14781f, 91.349625f, 126.27224f, 93.023155f);
                l.lineTo(74.19147f, 123.33311f);
                l.cubicTo(71.3243f, 125.00174f, 69.0f, 123.65884f, 69.0f, 120.35829f);
                l.lineTo(69.0f, 59.64535f);
                l.close();
                canvas.saveLayerAlpha(null, 204, 4);
                Paint a2 = C5163c.m7876a(a, looper);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-855638017);
                l = C5163c.m7884l(looper);
                l.moveTo(90.0f, 174.0f);
                l.cubicTo(136.39192f, 174.0f, 174.0f, 136.39192f, 174.0f, 90.0f);
                l.cubicTo(174.0f, 43.60808f, 136.39192f, 6.0f, 90.0f, 6.0f);
                l.cubicTo(43.60808f, 6.0f, 6.0f, 43.60808f, 6.0f, 90.0f);
                l.cubicTo(6.0f, 136.39192f, 43.60808f, 174.0f, 90.0f, 174.0f);
                l.close();
                l.moveTo(90.0f, 180.0f);
                l.cubicTo(40.294373f, 180.0f, 0.0f, 139.70563f, 0.0f, 90.0f);
                l.cubicTo(0.0f, 40.294373f, 40.294373f, 0.0f, 90.0f, 0.0f);
                l.cubicTo(139.70563f, 0.0f, 180.0f, 40.294373f, 180.0f, 90.0f);
                l.cubicTo(180.0f, 139.70563f, 139.70563f, 180.0f, 90.0f, 180.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
