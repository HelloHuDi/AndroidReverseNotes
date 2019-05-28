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

/* renamed from: com.tencent.mm.boot.svg.a.a.cx */
public final class C41805cx extends C5163c {
    private final int height = 80;
    private final int width = 80;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 80;
            case 1:
                return 80;
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
                g = C5163c.m7878a(g, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 16.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                k = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(5.773585f, 0.0f);
                l.lineTo(21.169811f, 47.908745f);
                l.lineTo(15.396226f, 47.908745f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(30.792452f, 0.0f);
                l.lineTo(36.566036f, 0.0f);
                l.lineTo(51.962265f, 47.908745f);
                l.lineTo(46.18868f, 47.908745f);
                l.lineTo(30.792452f, 0.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.restore();
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                g = C5163c.m7878a(g, -1.0f, 0.0f, 51.962265f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(15.396226f, 0.0f);
                l2.lineTo(21.169811f, 0.0f);
                l2.lineTo(36.566036f, 47.908745f);
                l2.lineTo(30.792452f, 47.908745f);
                l2.lineTo(15.396226f, 0.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a2);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(a, looper);
                g = C5163c.m7878a(g, -1.0f, 0.0f, 113.54717f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l3 = C5163c.m7884l(looper);
                l3.moveTo(46.18868f, 0.0f);
                l3.lineTo(51.962265f, 0.0f);
                l3.lineTo(67.35849f, 47.908745f);
                l3.lineTo(61.584908f, 47.908745f);
                l3.lineTo(46.18868f, 0.0f);
                l3.close();
                WeChatSVGRenderC2Java.setFillType(l3, 2);
                canvas.drawPath(l3, a);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
