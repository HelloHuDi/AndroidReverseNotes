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

/* renamed from: com.tencent.mm.boot.svg.a.a.wu */
public final class C25950wu extends C5163c {
    private final int height = 46;
    private final int width = 46;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 46;
            case 1:
                return 46;
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
                a.setColor(-8744017);
                Path l = C5163c.m7884l(looper);
                l.moveTo(30.430653f, 34.178318f);
                l.cubicTo(27.249908f, 36.57749f, 23.291077f, 38.0f, 19.0f, 38.0f);
                l.cubicTo(8.50659f, 38.0f, 0.0f, 29.49341f, 0.0f, 19.0f);
                l.cubicTo(0.0f, 8.50659f, 8.50659f, 0.0f, 19.0f, 0.0f);
                l.cubicTo(29.49341f, 0.0f, 38.0f, 8.50659f, 38.0f, 19.0f);
                l.cubicTo(38.0f, 23.291077f, 36.57749f, 27.249908f, 34.178318f, 30.430653f);
                l.lineTo(45.619164f, 41.8715f);
                l.lineTo(41.8715f, 45.619164f);
                l.lineTo(30.430653f, 34.178318f);
                l.close();
                l.moveTo(27.062714f, 30.44662f);
                l.cubicTo(24.783264f, 32.055153f, 22.001972f, 33.0f, 19.0f, 33.0f);
                l.cubicTo(11.268014f, 33.0f, 5.0f, 26.731987f, 5.0f, 19.0f);
                l.cubicTo(5.0f, 11.268014f, 11.268014f, 5.0f, 19.0f, 5.0f);
                l.cubicTo(26.731987f, 5.0f, 33.0f, 11.268014f, 33.0f, 19.0f);
                l.cubicTo(33.0f, 22.001972f, 32.055153f, 24.783264f, 30.44662f, 27.062714f);
                l.lineTo(27.062714f, 30.44662f);
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
