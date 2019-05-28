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

/* renamed from: com.tencent.mm.boot.svg.a.a.sj */
public final class C6374sj extends C5163c {
    private final int height = 36;
    private final int width = 20;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 20;
            case 1:
                return 36;
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
                a.setColor(-6710887);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.21f, 2.83f);
                l.cubicTo(1.15f, 1.89f, 2.09f, 0.94f, 3.03f, 0.0f);
                l.cubicTo(8.69f, 5.66f, 14.34f, 11.31f, 19.99f, 16.97f);
                l.cubicTo(14.34f, 22.63f, 8.69f, 28.29f, 3.03f, 33.94f);
                l.cubicTo(2.09f, 33.0f, 1.15f, 32.06f, 0.21f, 31.12f);
                l.cubicTo(4.91f, 26.39f, 9.64f, 21.7f, 14.33f, 16.97f);
                l.cubicTo(9.64f, 12.25f, 4.91f, 7.55f, 0.21f, 2.83f);
                l.lineTo(0.21f, 2.83f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
