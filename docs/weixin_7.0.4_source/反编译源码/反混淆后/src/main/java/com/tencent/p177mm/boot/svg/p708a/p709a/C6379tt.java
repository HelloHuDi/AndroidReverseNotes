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

/* renamed from: com.tencent.mm.boot.svg.a.a.tt */
public final class C6379tt extends C5163c {
    private final int height = 66;
    private final int width = 66;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 66;
            case 1:
                return 66;
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
                a.setColor(-564640);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 3.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(57.0f, 30.37037f);
                l.cubicTo(57.0f, 15.087965f, 44.912033f, 3.0f, 29.62963f, 3.0f);
                l.cubicTo(14.985957f, 3.0f, 3.0f, 15.1921425f, 3.0f, 30.37037f);
                l.cubicTo(3.0f, 44.912033f, 15.087965f, 57.0f, 29.62963f, 57.0f);
                l.cubicTo(44.807858f, 57.0f, 57.0f, 45.01404f, 57.0f, 30.37037f);
                l.close();
                l.moveTo(60.0f, 30.37037f);
                l.cubicTo(60.0f, 46.56889f, 46.56889f, 60.0f, 29.62963f, 60.0f);
                l.cubicTo(13.431111f, 60.0f, 0.0f, 46.56889f, 0.0f, 30.37037f);
                l.cubicTo(0.0f, 13.431111f, 13.431111f, 0.0f, 29.62963f, 0.0f);
                l.cubicTo(46.56889f, 0.0f, 60.0f, 13.431111f, 60.0f, 30.37037f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(30.0f, 45.0f);
                l.cubicTo(31.656855f, 45.0f, 33.0f, 43.656853f, 33.0f, 42.0f);
                l.cubicTo(33.0f, 40.343147f, 31.656855f, 39.0f, 30.0f, 39.0f);
                l.cubicTo(28.343145f, 39.0f, 27.0f, 40.343147f, 27.0f, 42.0f);
                l.cubicTo(27.0f, 43.656853f, 28.343145f, 45.0f, 30.0f, 45.0f);
                l.close();
                l.moveTo(28.498575f, 15.0f);
                l.cubicTo(27.670935f, 15.0f, 27.032139f, 15.674923f, 27.071115f, 16.493433f);
                l.lineTo(28.0f, 36.0f);
                l.lineTo(32.0f, 36.0f);
                l.lineTo(32.928883f, 16.493433f);
                l.cubicTo(32.96816f, 15.6686325f, 32.33497f, 15.0f, 31.501425f, 15.0f);
                l.lineTo(28.498575f, 15.0f);
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
