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

/* renamed from: com.tencent.mm.boot.svg.a.a.ajc */
public final class ajc extends C5163c {
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
                k = C5163c.m7876a(k, looper);
                k.setColor(-5592406);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(28.0f, 24.0f);
                l.lineTo(34.0f, 24.0f);
                l.lineTo(34.0f, 36.0f);
                l.lineTo(28.0f, 36.0f);
                l.lineTo(28.0f, 24.0f);
                l.close();
                l.moveTo(38.0f, 24.0f);
                l.lineTo(43.0f, 24.0f);
                l.lineTo(43.0f, 36.0f);
                l.lineTo(38.0f, 36.0f);
                l.lineTo(38.0f, 24.0f);
                l.close();
                l.moveTo(47.0f, 24.0f);
                l.lineTo(51.0f, 24.0f);
                l.lineTo(51.0f, 36.0f);
                l.lineTo(47.0f, 36.0f);
                l.lineTo(47.0f, 24.0f);
                l.close();
                l.moveTo(25.763962f, 14.012434f);
                l.cubicTo(26.998892f, 12.900997f, 28.0f, 13.345539f, 28.0f, 15.00742f);
                l.lineTo(28.0f, 44.99258f);
                l.cubicTo(28.0f, 46.653534f, 27.008198f, 47.107376f, 25.763962f, 45.987564f);
                l.lineTo(10.236038f, 32.012436f);
                l.cubicTo(9.001108f, 30.900997f, 8.991803f, 29.107378f, 10.236038f, 27.987566f);
                l.lineTo(25.763962f, 14.012434f);
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
