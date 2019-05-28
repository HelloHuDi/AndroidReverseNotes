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

/* renamed from: com.tencent.mm.boot.svg.a.a.cw */
public final class C25876cw extends C5163c {
    private final int height = 90;
    private final int width = 90;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, 11.0f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-13871462);
                Path l = C5163c.m7884l(looper);
                l.moveTo(46.0f, 0.0f);
                l.lineTo(68.0f, 22.0f);
                l.lineTo(68.0f, 87.0f);
                l.cubicTo(68.0f, 88.65685f, 66.65685f, 90.0f, 65.0f, 90.0f);
                l.lineTo(3.0f, 90.0f);
                l.cubicTo(1.3431457f, 90.0f, 2.0290612E-16f, 88.65685f, 0.0f, 87.0f);
                l.lineTo(0.0f, 3.0f);
                l.cubicTo(-2.0290612E-16f, 1.3431457f, 1.3431457f, 3.043592E-16f, 3.0f, 0.0f);
                l.lineTo(46.0f, 0.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(k, looper);
                a.setColor(-14465925);
                l = C5163c.m7884l(looper);
                l.moveTo(68.0f, 22.0f);
                l.lineTo(49.0f, 22.0f);
                l.cubicTo(47.343147f, 22.0f, 46.0f, 20.656855f, 46.0f, 19.0f);
                l.lineTo(46.0f, 0.0f);
                l.lineTo(68.0f, 22.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                Paint a2 = C5163c.m7876a(k, looper);
                a2.setColor(-1);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(33.91211f, 50.648438f);
                l2.lineTo(28.726562f, 69.0f);
                l2.lineTo(24.455078f, 69.0f);
                l2.lineTo(17.652344f, 43.634766f);
                l2.lineTo(22.363281f, 43.634766f);
                l2.lineTo(26.757812f, 62.847656f);
                l2.lineTo(26.898438f, 62.847656f);
                l2.lineTo(31.996094f, 43.634766f);
                l2.lineTo(36.003906f, 43.634766f);
                l2.lineTo(41.101562f, 62.847656f);
                l2.lineTo(41.242188f, 62.847656f);
                l2.lineTo(45.63672f, 43.634766f);
                l2.lineTo(50.347656f, 43.634766f);
                l2.lineTo(43.54492f, 69.0f);
                l2.lineTo(39.273438f, 69.0f);
                l2.lineTo(34.08789f, 50.648438f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
