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

/* renamed from: com.tencent.mm.boot.svg.a.a.azm */
public final class azm extends C5163c {
    private final int height = 27;
    private final int width = 42;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 42;
            case 1:
                return 27;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.5f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(-1);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.5f);
                l.lineTo(26.0f, 0.5f);
                l.lineTo(26.0f, 24.5f);
                l.lineTo(0.0f, 24.5f);
                l.lineTo(0.0f, 0.5f);
                l.close();
                l.moveTo(2.0f, 2.5f);
                l.lineTo(2.0f, 22.5f);
                l.lineTo(24.0f, 22.5f);
                l.lineTo(24.0f, 2.5f);
                l.lineTo(2.0f, 2.5f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 27.363636f, 0.0f, 1.0f, 1.090909f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.restore();
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(31.008236f, 11.565939f);
                l2.lineTo(31.002834f, 13.579968f);
                l2.lineTo(39.986187f, 19.714403f);
                l2.lineTo(39.997097f, 5.3252935f);
                l2.lineTo(31.008236f, 11.565939f);
                l2.close();
                l2.moveTo(29.011042f, 10.51777f);
                l2.lineTo(42.0f, 1.5f);
                l2.lineTo(41.983315f, 23.5f);
                l2.lineTo(29.0f, 14.634123f);
                l2.lineTo(29.011042f, 10.51777f);
                l2.close();
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
