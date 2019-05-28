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

/* renamed from: com.tencent.mm.boot.svg.a.a.atr */
public final class atr extends C5163c {
    private final int height = 24;
    private final int width = 24;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                a.setColor(-2697514);
                Path l = C5163c.m7884l(looper);
                l.moveTo(12.0f, 0.0f);
                l.cubicTo(5.3716516f, 0.0f, 0.0f, 5.3716516f, 0.0f, 12.0f);
                l.cubicTo(0.0f, 18.628347f, 5.3716516f, 24.0f, 12.0f, 24.0f);
                l.cubicTo(18.628347f, 24.0f, 24.0f, 18.628347f, 24.0f, 12.0f);
                l.cubicTo(24.0f, 5.3716516f, 18.628347f, 0.0f, 12.0f, 0.0f);
                l.close();
                l.moveTo(12.148247f, 12.97082f);
                l.lineTo(18.91682f, 15.12273f);
                l.lineTo(18.506933f, 16.406258f);
                l.lineTo(10.797303f, 13.955056f);
                l.lineTo(10.797303f, 3.1551237f);
                l.lineTo(12.145618f, 3.1551237f);
                l.lineTo(12.145618f, 12.97082f);
                l.lineTo(12.148247f, 12.97082f);
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
