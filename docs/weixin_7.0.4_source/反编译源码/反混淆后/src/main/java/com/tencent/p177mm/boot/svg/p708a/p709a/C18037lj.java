package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.lj */
public final class C18037lj extends C5163c {
    private final int height = 102;
    private final int width = 102;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 102;
            case 1:
                return 102;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix h = C5163c.m7881h(looper);
                float[] g = C5163c.m7880g(looper);
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
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(51.0f, 102.0f);
                l.cubicTo(79.16652f, 102.0f, 102.0f, 79.16652f, 102.0f, 51.0f);
                l.cubicTo(102.0f, 22.833477f, 79.16652f, 0.0f, 51.0f, 0.0f);
                l.cubicTo(22.833477f, 0.0f, 0.0f, 22.833477f, 0.0f, 51.0f);
                l.cubicTo(0.0f, 79.16652f, 22.833477f, 102.0f, 51.0f, 102.0f);
                l.close();
                l.moveTo(51.0f, 98.0f);
                l.cubicTo(76.95738f, 98.0f, 98.0f, 76.95738f, 98.0f, 51.0f);
                l.cubicTo(98.0f, 25.042616f, 76.95738f, 4.0f, 51.0f, 4.0f);
                l.cubicTo(25.042616f, 4.0f, 4.0f, 25.042616f, 4.0f, 51.0f);
                l.cubicTo(4.0f, 76.95738f, 25.042616f, 98.0f, 51.0f, 98.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                float[] a3 = C5163c.m7878a(g, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 14.0f);
                h.reset();
                h.setValues(a3);
                canvas.concat(h);
                canvas.save();
                a3 = C5163c.m7878a(a3, 1.0f, 0.0f, 9.0f, 0.0f, 1.0f, 24.0f);
                h.reset();
                h.setValues(a3);
                canvas.concat(h);
                canvas.save();
                Paint a4 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(15.415947f, 1.2113346f);
                l.cubicTo(16.290796f, 0.54233295f, 17.0f, 0.8949788f, 17.0f, 1.9970046f);
                l.lineTo(17.0f, 24.002995f);
                l.cubicTo(17.0f, 25.105911f, 16.291174f, 25.457956f, 15.415947f, 24.788666f);
                l.lineTo(1.5840529f, 14.211334f);
                l.cubicTo(0.7092046f, 13.542333f, 0.70882535f, 12.457957f, 1.5840529f, 11.788666f);
                l.lineTo(15.415947f, 1.2113346f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a4);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(a, looper);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(14.0f, 9.0f);
                l2.lineTo(55.0f, 9.0f);
                l2.lineTo(55.0f, 17.0f);
                l2.lineTo(14.0f, 17.0f);
                l2.lineTo(14.0f, 9.0f);
                l2.close();
                canvas.drawPath(l2, k);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
