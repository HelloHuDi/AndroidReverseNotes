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

/* renamed from: com.tencent.mm.boot.svg.a.a.acg */
public final class acg extends C5163c {
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
                k = C5163c.m7876a(k, looper);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(31.322699f, 25.5f);
                l.lineTo(38.61396f, 32.791264f);
                l.lineTo(35.43198f, 35.973244f);
                l.lineTo(25.88604f, 26.427301f);
                l.lineTo(23.764719f, 24.305983f);
                l.cubicTo(23.178932f, 23.720196f, 23.178932f, 22.770449f, 23.764719f, 22.184662f);
                l.lineTo(35.43198f, 10.5174f);
                l.lineTo(38.61396f, 13.69938f);
                l.lineTo(31.313341f, 21.0f);
                l.lineTo(45.0f, 21.0f);
                l.cubicTo(54.941124f, 21.0f, 63.0f, 29.058874f, 63.0f, 39.0f);
                l.cubicTo(63.0f, 48.941124f, 54.941124f, 57.0f, 45.0f, 57.0f);
                l.lineTo(12.0f, 57.0f);
                l.lineTo(12.0f, 52.5f);
                l.lineTo(45.0f, 52.5f);
                l.cubicTo(52.455845f, 52.5f, 58.5f, 46.455845f, 58.5f, 39.0f);
                l.cubicTo(58.5f, 31.544155f, 52.455845f, 25.5f, 45.0f, 25.5f);
                l.lineTo(31.322699f, 25.5f);
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
