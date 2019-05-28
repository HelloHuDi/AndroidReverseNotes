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

/* renamed from: com.tencent.mm.boot.svg.a.a.cd */
public final class C25873cd extends C5163c {
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
                a.setColor(-14824411);
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
                a.setColor(-15228131);
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
                a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                l = C5163c.m7884l(looper);
                l.moveTo(19.75f, 62.0f);
                l.lineTo(24.25f, 62.0f);
                l.cubicTo(24.664213f, 62.0f, 25.0f, 62.335785f, 25.0f, 62.75f);
                l.lineTo(25.0f, 65.25f);
                l.cubicTo(25.0f, 65.664215f, 24.664213f, 66.0f, 24.25f, 66.0f);
                l.lineTo(19.75f, 66.0f);
                l.cubicTo(19.335787f, 66.0f, 19.0f, 65.664215f, 19.0f, 65.25f);
                l.lineTo(19.0f, 62.75f);
                l.cubicTo(19.0f, 62.335785f, 19.335787f, 62.0f, 19.75f, 62.0f);
                l.close();
                l.moveTo(27.75f, 55.0f);
                l.lineTo(32.25f, 55.0f);
                l.cubicTo(32.664215f, 55.0f, 33.0f, 55.335785f, 33.0f, 55.75f);
                l.lineTo(33.0f, 65.25f);
                l.cubicTo(33.0f, 65.664215f, 32.664215f, 66.0f, 32.25f, 66.0f);
                l.lineTo(27.75f, 66.0f);
                l.cubicTo(27.335787f, 66.0f, 27.0f, 65.664215f, 27.0f, 65.25f);
                l.lineTo(27.0f, 55.75f);
                l.cubicTo(27.0f, 55.335785f, 27.335787f, 55.0f, 27.75f, 55.0f);
                l.close();
                l.moveTo(35.75f, 44.0f);
                l.lineTo(40.25f, 44.0f);
                l.cubicTo(40.664215f, 44.0f, 41.0f, 44.335785f, 41.0f, 44.75f);
                l.lineTo(41.0f, 65.25f);
                l.cubicTo(41.0f, 65.664215f, 40.664215f, 66.0f, 40.25f, 66.0f);
                l.lineTo(35.75f, 66.0f);
                l.cubicTo(35.335785f, 66.0f, 35.0f, 65.664215f, 35.0f, 65.25f);
                l.lineTo(35.0f, 44.75f);
                l.cubicTo(35.0f, 44.335785f, 35.335785f, 44.0f, 35.75f, 44.0f);
                l.close();
                l.moveTo(19.0f, 68.0f);
                l.lineTo(49.0f, 68.0f);
                l.cubicTo(49.552284f, 68.0f, 50.0f, 68.447716f, 50.0f, 69.0f);
                l.cubicTo(50.0f, 69.552284f, 49.552284f, 70.0f, 49.0f, 70.0f);
                l.lineTo(19.0f, 70.0f);
                l.cubicTo(18.447716f, 70.0f, 18.0f, 69.552284f, 18.0f, 69.0f);
                l.cubicTo(18.0f, 68.447716f, 18.447716f, 68.0f, 19.0f, 68.0f);
                l.close();
                l.moveTo(43.75f, 50.0f);
                l.lineTo(48.25f, 50.0f);
                l.cubicTo(48.664215f, 50.0f, 49.0f, 50.335785f, 49.0f, 50.75f);
                l.lineTo(49.0f, 65.25f);
                l.cubicTo(49.0f, 65.664215f, 48.664215f, 66.0f, 48.25f, 66.0f);
                l.lineTo(43.75f, 66.0f);
                l.cubicTo(43.335785f, 66.0f, 43.0f, 65.664215f, 43.0f, 65.25f);
                l.lineTo(43.0f, 50.75f);
                l.cubicTo(43.0f, 50.335785f, 43.335785f, 50.0f, 43.75f, 50.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
