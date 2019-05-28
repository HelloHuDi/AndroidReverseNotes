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

/* renamed from: com.tencent.mm.boot.svg.a.a.wn */
public final class C9165wn extends C5163c {
    private final int height = 33;
    private final int width = 38;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 38;
            case 1:
                return 33;
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
                k.setColor(-4547478);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(14.666667f, 23.0f);
                l.lineTo(33.0f, 23.0f);
                l.lineTo(33.0f, 5.0f);
                l.lineTo(5.0f, 5.0f);
                l.lineTo(5.0f, 23.0f);
                l.lineTo(11.0f, 23.0f);
                l.lineTo(11.0f, 26.0f);
                l.lineTo(14.666667f, 23.0f);
                l.close();
                l.moveTo(15.222222f, 27.0f);
                l.lineTo(35.000294f, 27.0f);
                l.cubicTo(36.110107f, 27.0f, 37.0f, 26.105911f, 37.0f, 25.002995f);
                l.lineTo(37.0f, 2.9970047f);
                l.cubicTo(37.0f, 1.8949789f, 36.104702f, 1.0f, 35.000294f, 1.0f);
                l.lineTo(2.9997072f, 1.0f);
                l.cubicTo(1.8898926f, 1.0f, 1.0f, 1.8940895f, 1.0f, 2.9970047f);
                l.lineTo(1.0f, 25.002995f);
                l.cubicTo(1.0f, 26.10502f, 1.8952994f, 27.0f, 2.9997072f, 27.0f);
                l.lineTo(8.0f, 27.0f);
                l.lineTo(8.0f, 32.0f);
                l.lineTo(15.222222f, 27.0f);
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
