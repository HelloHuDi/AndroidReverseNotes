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

/* renamed from: com.tencent.mm.boot.svg.a.a.lo */
public final class C41841lo extends C5163c {
    private final int height = 63;
    private final int width = 63;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 63;
            case 1:
                return 63;
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
                k = C5163c.m7876a(k2, looper);
                k.setStrokeWidth(1.0f);
                k.setStrokeCap(Cap.SQUARE);
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                a.setStrokeWidth(7.5f);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 13.5f, 0.0f, 1.0f, 13.5f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                k = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.6666667f, 0.6666667f);
                l.lineTo(14.956543f, 14.956543f);
                l.lineTo(35.333332f, 35.333332f);
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, k);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(a, looper);
                g = C5163c.m7878a(g, -1.0f, 0.0f, 36.0f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(0.6666667f, 0.6666667f);
                l2.lineTo(14.956543f, 14.956543f);
                l2.lineTo(35.333332f, 35.333332f);
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                canvas.drawPath(l2, a);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
