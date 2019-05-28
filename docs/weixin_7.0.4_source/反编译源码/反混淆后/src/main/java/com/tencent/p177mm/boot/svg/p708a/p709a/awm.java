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

/* renamed from: com.tencent.mm.boot.svg.a.a.awm */
public final class awm extends C5163c {
    private final int height = 60;
    private final int width = 60;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                a.setColor(-1);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 3.0f);
                l.cubicTo(0.0f, 1.3431456f, 1.3431456f, 0.0f, 3.0f, 0.0f);
                l.lineTo(55.5f, 0.0f);
                l.cubicTo(57.156853f, 0.0f, 58.5f, 1.3431456f, 58.5f, 3.0f);
                l.lineTo(58.5f, 55.5f);
                l.cubicTo(58.5f, 57.156853f, 57.156853f, 58.5f, 55.5f, 58.5f);
                l.lineTo(3.0f, 58.5f);
                l.cubicTo(1.3431456f, 58.5f, 0.0f, 57.156853f, 0.0f, 55.5f);
                l.lineTo(0.0f, 3.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                l = C5163c.m7884l(looper);
                l.moveTo(31.5f, 18.0f);
                l.lineTo(31.5f, 46.5f);
                l.cubicTo(31.5f, 47.328426f, 30.828426f, 48.0f, 30.0f, 48.0f);
                l.lineTo(27.0f, 48.0f);
                l.cubicTo(26.171574f, 48.0f, 25.5f, 47.328426f, 25.5f, 46.5f);
                l.lineTo(25.5f, 18.0f);
                l.lineTo(13.5f, 18.0f);
                l.cubicTo(12.671573f, 18.0f, 12.0f, 17.328426f, 12.0f, 16.5f);
                l.lineTo(12.0f, 13.5f);
                l.cubicTo(12.0f, 12.671573f, 12.671573f, 12.0f, 13.5f, 12.0f);
                l.lineTo(45.0f, 12.0f);
                l.cubicTo(45.828426f, 12.0f, 46.5f, 12.671573f, 46.5f, 13.5f);
                l.lineTo(46.5f, 16.5f);
                l.cubicTo(46.5f, 17.328426f, 45.828426f, 18.0f, 45.0f, 18.0f);
                l.lineTo(31.5f, 18.0f);
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
