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

/* renamed from: com.tencent.mm.boot.svg.a.a.xa */
public final class C18082xa extends C5163c {
    private final int height = 16;
    private final int width = 20;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 20;
            case 1:
                return 16;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, -320.0f, 0.0f, 1.0f, -110.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 108.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 320.0f, 0.0f, 1.0f, 2.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(20.0f, 16.0f);
                l.lineTo(0.0f, 16.0f);
                l.lineTo(0.0f, 9.25f);
                l.lineTo(0.0f, 9.25f);
                l.cubicTo(-1.6908844E-17f, 9.111929f, 0.11192881f, 9.0f, 0.25f, 9.0f);
                l.lineTo(1.75f, 9.0f);
                l.lineTo(1.75f, 9.0f);
                l.cubicTo(1.8880712f, 9.0f, 2.0f, 9.111929f, 2.0f, 9.25f);
                l.lineTo(2.0f, 14.0f);
                l.lineTo(18.0f, 14.0f);
                l.lineTo(18.0f, 9.25f);
                l.lineTo(18.0f, 9.25f);
                l.cubicTo(18.0f, 9.111929f, 18.111929f, 9.0f, 18.25f, 9.0f);
                l.lineTo(19.75f, 9.0f);
                l.lineTo(19.75f, 9.0f);
                l.cubicTo(19.888071f, 9.0f, 20.0f, 9.111929f, 20.0f, 9.25f);
                l.lineTo(20.0f, 16.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(14.0f, 0.0f);
                l.lineTo(19.0f, 4.0f);
                l.lineTo(14.0f, 8.0f);
                l.lineTo(14.0f, 0.0f);
                l.close();
                l.moveTo(5.0f, 11.0f);
                l.cubicTo(4.9955163f, 7.91632f, 7.619254f, 2.002248f, 14.0f, 2.0f);
                l.cubicTo(13.975887f, 2.0f, 13.975887f, 3.3333333f, 14.0f, 6.0f);
                l.cubicTo(10.277842f, 6.0545654f, 7.277841f, 7.7212324f, 5.0f, 11.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
