package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.dx */
public final class C25880dx extends C5163c {
    private final int height = 72;
    private final int width = 72;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                C5163c.m7881h(looper);
                C5163c.m7880g(looper);
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
                canvas.saveLayerAlpha(null, 128, 4);
                k = C5163c.m7876a(k, looper);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(48.929794f, 46.684208f);
                l.lineTo(61.272793f, 59.027206f);
                l.lineTo(58.727207f, 61.572792f);
                l.lineTo(46.35855f, 49.204136f);
                l.cubicTo(42.728428f, 52.200203f, 38.0744f, 54.0f, 33.0f, 54.0f);
                l.cubicTo(21.402f, 54.0f, 12.0f, 44.598f, 12.0f, 33.0f);
                l.cubicTo(12.0f, 21.402f, 21.402f, 12.0f, 33.0f, 12.0f);
                l.cubicTo(44.598f, 12.0f, 54.0f, 21.402f, 54.0f, 33.0f);
                l.cubicTo(54.0f, 38.22745f, 52.089996f, 43.00879f, 48.929794f, 46.684208f);
                l.close();
                l.moveTo(50.399994f, 33.00004f);
                l.cubicTo(50.399994f, 23.390265f, 42.609764f, 15.600037f, 32.999992f, 15.600037f);
                l.cubicTo(23.39022f, 15.600037f, 15.599991f, 23.390265f, 15.599991f, 33.00004f);
                l.cubicTo(15.599991f, 42.60981f, 23.39022f, 50.40004f, 32.999992f, 50.40004f);
                l.cubicTo(42.609764f, 50.40004f, 50.399994f, 42.60981f, 50.399994f, 33.00004f);
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
