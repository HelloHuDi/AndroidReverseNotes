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

/* renamed from: com.tencent.mm.boot.svg.a.a.aqi */
public final class aqi extends C5163c {
    private final int height = 36;
    private final int width = 46;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 46;
            case 1:
                return 36;
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
                k = C5163c.m7876a(k, looper);
                k.setColor(-9205837);
                canvas.save();
                k2 = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(9.0f, 12.0f);
                l.lineTo(36.0f, 12.0f);
                l.lineTo(36.0f, 17.0f);
                l.lineTo(9.0f, 17.0f);
                l.lineTo(9.0f, 12.0f);
                l.lineTo(9.0f, 12.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(0.0f, 3.0074198f);
                l2.cubicTo(0.0f, 1.3464677f, 1.3517805f, 0.0f, 3.0004442f, 0.0f);
                l2.lineTo(42.999557f, 0.0f);
                l2.cubicTo(44.656654f, 0.0f, 46.0f, 1.3455393f, 46.0f, 3.0074198f);
                l2.lineTo(46.0f, 32.99258f);
                l2.cubicTo(46.0f, 34.653534f, 44.64822f, 36.0f, 42.999557f, 36.0f);
                l2.lineTo(3.0004442f, 36.0f);
                l2.cubicTo(1.3433446f, 36.0f, 0.0f, 34.65446f, 0.0f, 32.99258f);
                l2.lineTo(0.0f, 3.0074198f);
                l2.close();
                l2.moveTo(3.0666666f, 3.0f);
                l2.lineTo(43.0f, 3.0f);
                l2.lineTo(43.0f, 33.0f);
                l2.lineTo(3.0666666f, 33.0f);
                l2.lineTo(3.0666666f, 3.0f);
                l2.close();
                l2.moveTo(9.2f, 12.0f);
                l2.lineTo(37.0f, 12.0f);
                l2.lineTo(37.0f, 17.0f);
                l2.lineTo(9.2f, 17.0f);
                l2.lineTo(9.2f, 12.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
