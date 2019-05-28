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

/* renamed from: com.tencent.mm.boot.svg.a.a.ur */
public final class C18075ur extends C5163c {
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
                Paint a = C5163c.m7876a(k2, looper);
                a.setStrokeWidth(1.0f);
                canvas.saveLayerAlpha(null, 230, 4);
                Paint a2 = C5163c.m7876a(k, looper);
                a2.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint a3 = C5163c.m7876a(a2, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(43.49117f, 12.6f);
                l.lineTo(14.091168f, 42.0f);
                l.lineTo(29.999989f, 57.90882f);
                l.lineTo(59.39849f, 28.508768f);
                l.lineTo(59.399723f, 12.6f);
                l.lineTo(43.49117f, 12.6f);
                l.close();
                l.moveTo(60.0f, 9.0f);
                l.cubicTo(61.657085f, 8.999896f, 63.00013f, 10.343145f, 63.0f, 12.0f);
                l.lineTo(62.99847f, 28.757538f);
                l.cubicTo(62.99841f, 29.553082f, 62.682365f, 30.316027f, 62.119843f, 30.878574f);
                l.lineTo(32.12132f, 60.87868f);
                l.cubicTo(30.949696f, 62.050304f, 29.0502f, 62.050304f, 27.878628f, 60.87873f);
                l.lineTo(11.121321f, 44.12132f);
                l.cubicTo(9.949747f, 42.94975f, 9.949747f, 41.05025f, 11.121321f, 39.87868f);
                l.lineTo(41.12132f, 9.878679f);
                l.cubicTo(41.68393f, 9.316071f, 42.44699f, 9.0f, 43.24264f, 9.0f);
                l.lineTo(60.0f, 9.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a3);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a2, looper);
                a = C5163c.m7876a(a, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                a.setStrokeWidth(1.2f);
                l = C5163c.m7884l(looper);
                l.moveTo(48.0f, 20.4f);
                l.cubicTo(49.988224f, 20.4f, 51.6f, 22.011774f, 51.6f, 24.0f);
                l.cubicTo(51.6f, 25.988226f, 49.988224f, 27.6f, 48.0f, 27.6f);
                l.cubicTo(46.011776f, 27.6f, 44.4f, 25.988226f, 44.4f, 24.0f);
                l.cubicTo(44.4f, 22.011774f, 46.011776f, 20.4f, 48.0f, 20.4f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
