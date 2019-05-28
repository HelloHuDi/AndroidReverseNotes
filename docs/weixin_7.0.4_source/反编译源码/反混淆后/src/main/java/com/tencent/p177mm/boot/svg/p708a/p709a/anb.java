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

/* renamed from: com.tencent.mm.boot.svg.a.a.anb */
public final class anb extends C5163c {
    private final int height = 96;
    private final int width = 96;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                k.setColor(-1);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(78.0f, 23.0f);
                l.lineTo(18.0f, 23.0f);
                l.cubicTo(16.344f, 23.0f, 15.0f, 24.343f, 15.0f, 26.0f);
                l.lineTo(15.0f, 70.0f);
                l.cubicTo(15.0f, 71.657f, 16.344f, 73.0f, 18.0f, 73.0f);
                l.lineTo(78.0f, 73.0f);
                l.cubicTo(79.656f, 73.0f, 81.0f, 71.657f, 81.0f, 70.0f);
                l.lineTo(81.0f, 26.0f);
                l.cubicTo(81.0f, 24.343f, 79.656f, 23.0f, 78.0f, 23.0f);
                l.close();
                l.moveTo(76.0f, 59.0f);
                l.cubicTo(73.152f, 54.088184f, 68.083f, 47.354908f, 63.744f, 47.354908f);
                l.cubicTo(62.005f, 47.354908f, 58.828f, 49.3773f, 55.663f, 52.12908f);
                l.cubicTo(56.991f, 55.097874f, 58.811f, 58.14101f, 58.8f, 58.14101f);
                l.cubicTo(57.888f, 58.14101f, 55.199f, 53.835007f, 55.199f, 53.835007f);
                l.cubicTo(55.026f, 53.55973f, 54.844f, 53.290478f, 54.659f, 53.026253f);
                l.cubicTo(54.605f, 53.07548f, 54.552f, 53.123703f, 54.498f, 53.17293f);
                l.cubicTo(51.521f, 49.35821f, 45.061f, 40.19967f, 39.359f, 40.19967f);
                l.cubicTo(35.016f, 40.19967f, 24.034f, 50.0655f, 20.0f, 57.164474f);
                l.lineTo(20.0f, 28.0f);
                l.lineTo(76.0f, 28.0f);
                l.lineTo(76.0f, 59.0f);
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
