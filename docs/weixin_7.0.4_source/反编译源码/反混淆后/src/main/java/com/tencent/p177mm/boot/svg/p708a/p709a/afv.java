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

/* renamed from: com.tencent.mm.boot.svg.a.a.afv */
public final class afv extends C5163c {
    private final int height = 36;
    private final int width = 46;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 46;
            case 1:
                return 36;
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
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-16036);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(25.915672f, 0.0f);
                l.cubicTo(25.97802f, 12.003458f, 26.092323f, 24.006916f, 25.863716f, 36.0f);
                l.cubicTo(19.75988f, 32.49351f, 13.654047f, 28.48876f, 7.201107f, 25.397118f);
                l.cubicTo(4.8215203f, 25.034006f, 2.4003692f, 25.241499f, 0.0f, 25.241499f);
                l.lineTo(0.0f, 10.696254f);
                l.cubicTo(2.4003692f, 10.696254f, 4.8215203f, 10.903747f, 7.2114983f, 10.540634f);
                l.cubicTo(13.685221f, 7.5008645f, 19.217047f, 3.8922536f, 25.915672f, 0.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(34.0f, 8.687097f);
                l.cubicTo(37.385418f, 6.432258f, 40.822918f, 4.225806f, 44.239582f, 2.0f);
                l.cubicTo(44.822918f, 2.7935483f, 45.40625f, 3.5774193f, 46.0f, 4.370968f);
                l.cubicTo(42.5625f, 6.548387f, 39.177082f, 8.793549f, 35.760418f, 11.0f);
                l.cubicTo(35.1875f, 10.225806f, 34.59375f, 9.451612f, 34.0f, 8.687097f);
                l.lineTo(34.0f, 8.687097f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(a, looper);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(46.0f, 16.0f);
                l2.lineTo(46.0f, 19.0f);
                l2.lineTo(34.0f, 19.0f);
                l2.lineTo(34.0f, 16.0f);
                l2.lineTo(46.0f, 16.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, k);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(34.0f, 26.688448f);
                l.cubicTo(34.535355f, 25.806301f, 35.050507f, 24.913652f, 35.535355f, 24.0f);
                l.cubicTo(39.0101f, 26.121353f, 42.50505f, 28.211203f, 46.0f, 30.290548f);
                l.cubicTo(45.626263f, 30.973162f, 44.878788f, 32.317387f, 44.515152f, 33.0f);
                l.cubicTo(41.0f, 30.89965f, 37.50505f, 28.788797f, 34.0f, 26.688448f);
                l.lineTo(34.0f, 26.688448f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
