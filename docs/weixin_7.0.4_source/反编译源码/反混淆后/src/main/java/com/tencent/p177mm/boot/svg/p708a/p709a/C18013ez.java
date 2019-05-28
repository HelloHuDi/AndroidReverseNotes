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

/* renamed from: com.tencent.mm.boot.svg.a.a.ez */
public final class C18013ez extends C5163c {
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
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                g = C5163c.m7878a(g, 1.0f, 0.0f, -211.0f, 0.0f, 1.0f, -317.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 211.0f, 0.0f, 1.0f, 317.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(67.0f, 69.0f);
                l.lineTo(21.0f, 69.0f);
                l.lineTo(21.0f, 35.0f);
                l.lineTo(30.521f, 35.0f);
                l.cubicTo(31.823f, 32.063f, 33.368f, 29.769f, 35.079f, 28.0f);
                l.lineTo(17.0f, 28.0f);
                l.cubicTo(15.343f, 28.0f, 14.0f, 29.343f, 14.0f, 31.0f);
                l.lineTo(14.0f, 73.0f);
                l.cubicTo(14.0f, 74.657f, 15.343f, 76.0f, 17.0f, 76.0f);
                l.lineTo(71.0f, 76.0f);
                l.cubicTo(72.656f, 76.0f, 74.0f, 74.657f, 74.0f, 73.0f);
                l.lineTo(74.0f, 51.22f);
                l.lineTo(67.0f, 57.13f);
                l.lineTo(67.0f, 69.0f);
                l.lineTo(67.0f, 69.0f);
                l.close();
                l.moveTo(59.0f, 17.0f);
                l.lineTo(59.0f, 28.019f);
                l.cubicTo(57.325f, 28.008f, 55.583f, 28.0f, 54.0f, 28.0f);
                l.cubicTo(40.334f, 28.0f, 31.055f, 41.333f, 31.055f, 59.0f);
                l.cubicTo(35.721f, 48.16f, 40.284f, 43.0f, 59.0f, 43.0f);
                l.lineTo(59.0f, 54.0f);
                l.lineTo(73.452f, 41.848f);
                l.lineTo(74.0f, 42.357f);
                l.lineTo(74.0f, 41.386f);
                l.lineTo(81.0f, 35.5f);
                l.lineTo(59.0f, 17.0f);
                l.lineTo(59.0f, 17.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
