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

/* renamed from: com.tencent.mm.boot.svg.a.a.akb */
public final class akb extends C5163c {
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
                a.setColor(419430400);
                Path l = C5163c.m7884l(looper);
                l.moveTo(36.0f, 1.5f);
                l.cubicTo(55.053825f, 1.5f, 70.5f, 16.946175f, 70.5f, 36.0f);
                l.cubicTo(70.5f, 55.053825f, 55.053825f, 70.5f, 36.0f, 70.5f);
                l.cubicTo(16.946175f, 70.5f, 1.5f, 55.053825f, 1.5f, 36.0f);
                l.cubicTo(1.5f, 16.946175f, 16.946175f, 1.5f, 36.0f, 1.5f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(k, looper);
                a.setColor(-1710619);
                l = C5163c.m7884l(looper);
                l.moveTo(36.0f, 72.0f);
                l.cubicTo(55.88225f, 72.0f, 72.0f, 55.88225f, 72.0f, 36.0f);
                l.cubicTo(72.0f, 16.117748f, 55.88225f, 0.0f, 36.0f, 0.0f);
                l.cubicTo(16.117748f, 0.0f, 0.0f, 16.117748f, 0.0f, 36.0f);
                l.cubicTo(0.0f, 55.88225f, 16.117748f, 72.0f, 36.0f, 72.0f);
                l.close();
                l.moveTo(36.0f, 67.5f);
                l.cubicTo(53.39697f, 67.5f, 67.5f, 53.39697f, 67.5f, 36.0f);
                l.cubicTo(67.5f, 18.603031f, 53.39697f, 4.5f, 36.0f, 4.5f);
                l.cubicTo(18.603031f, 4.5f, 4.5f, 18.603031f, 4.5f, 36.0f);
                l.cubicTo(4.5f, 53.39697f, 18.603031f, 67.5f, 36.0f, 67.5f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-1710619);
                l = C5163c.m7884l(looper);
                l.moveTo(24.0f, 27.0f);
                l.cubicTo(24.0f, 25.343145f, 25.343145f, 24.0f, 27.0f, 24.0f);
                l.lineTo(45.0f, 24.0f);
                l.cubicTo(46.656853f, 24.0f, 48.0f, 25.343145f, 48.0f, 27.0f);
                l.lineTo(48.0f, 45.0f);
                l.cubicTo(48.0f, 46.656853f, 46.656853f, 48.0f, 45.0f, 48.0f);
                l.lineTo(27.0f, 48.0f);
                l.cubicTo(25.343145f, 48.0f, 24.0f, 46.656853f, 24.0f, 45.0f);
                l.lineTo(24.0f, 27.0f);
                l.close();
                canvas.drawPath(l, k);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
