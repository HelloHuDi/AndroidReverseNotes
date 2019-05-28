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

/* renamed from: com.tencent.mm.boot.svg.a.a.ar */
public final class C37519ar extends C5163c {
    private final int height = 16;
    private final int width = 28;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 28;
            case 1:
                return 16;
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
                a.setColor(-3355444);
                Path l = C5163c.m7884l(looper);
                l.moveTo(13.962992f, 10.188502f);
                l.cubicTo(13.08834f, 9.283867f, 12.178382f, 8.349955f, 11.50355f, 7.6751227f);
                l.lineTo(3.828427f, 8.881784E-16f);
                l.lineTo(1.0f, 2.828427f);
                l.lineTo(13.9616785f, 15.961207f);
                l.lineTo(13.994814f, 15.928072f);
                l.lineTo(14.008518f, 15.941776f);
                l.lineTo(15.711977f, 14.210909f);
                l.lineTo(16.790106f, 13.13278f);
                l.cubicTo(16.790106f, 13.13278f, 16.787266f, 13.1298f, 16.781706f, 13.123969f);
                l.lineTo(26.914213f, 2.828427f);
                l.lineTo(24.085787f, -5.3290705E-15f);
                l.lineTo(16.410664f, 7.6751227f);
                l.cubicTo(15.7343025f, 8.351483f, 14.829623f, 9.285367f, 13.962992f, 10.188502f);
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
