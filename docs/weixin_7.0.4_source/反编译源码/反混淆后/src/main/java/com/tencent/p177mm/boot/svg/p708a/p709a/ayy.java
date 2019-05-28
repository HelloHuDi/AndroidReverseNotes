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

/* renamed from: com.tencent.mm.boot.svg.a.a.ayy */
public final class ayy extends C5163c {
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
                l.moveTo(68.4f, 36.444443f);
                l.cubicTo(68.4f, 18.105558f, 53.89444f, 3.6f, 35.555557f, 3.6f);
                l.cubicTo(17.983149f, 3.6f, 3.6f, 18.230572f, 3.6f, 36.444443f);
                l.cubicTo(3.6f, 53.89444f, 18.105558f, 68.4f, 35.555557f, 68.4f);
                l.cubicTo(53.76943f, 68.4f, 68.4f, 54.01685f, 68.4f, 36.444443f);
                l.close();
                l.moveTo(72.0f, 36.444443f);
                l.cubicTo(72.0f, 55.882668f, 55.882668f, 72.0f, 35.555557f, 72.0f);
                l.cubicTo(16.117332f, 72.0f, 0.0f, 55.882668f, 0.0f, 36.444443f);
                l.cubicTo(0.0f, 16.117332f, 16.117332f, 0.0f, 35.555557f, 0.0f);
                l.cubicTo(55.882668f, 0.0f, 72.0f, 16.117332f, 72.0f, 36.444443f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
