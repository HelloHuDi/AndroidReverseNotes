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

/* renamed from: com.tencent.mm.boot.svg.a.a.zy */
public final class C18094zy extends C5163c {
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
                k = C5163c.m7876a(k, looper);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(54.0f, 12.926538f);
                l.lineTo(24.0f, 19.503462f);
                l.lineTo(24.0f, 54.587288f);
                l.lineTo(24.0f, 57.603806f);
                l.cubicTo(24.0f, 60.412968f, 22.11874f, 63.15209f, 19.588413f, 64.3322f);
                l.cubicTo(19.118036f, 64.551575f, 16.14658f, 65.21572f, 15.758582f, 65.29378f);
                l.cubicTo(12.030496f, 66.043785f, 9.166035f, 62.850475f, 9.008285f, 59.62134f);
                l.cubicTo(8.850535f, 56.39221f, 10.96819f, 53.699585f, 13.425209f, 53.205288f);
                l.lineTo(17.218742f, 52.253464f);
                l.cubicTo(18.559702f, 51.917004f, 19.5f, 50.711636f, 19.5f, 49.32911f);
                l.lineTo(19.5f, 18.935236f);
                l.lineTo(19.5f, 17.881247f);
                l.cubicTo(19.5f, 16.471695f, 20.481295f, 15.252241f, 21.858213f, 14.950698f);
                l.lineTo(56.679108f, 7.3249645f);
                l.cubicTo(57.488354f, 7.1477404f, 58.288048f, 7.660097f, 58.465275f, 8.469345f);
                l.cubicTo(58.488358f, 8.574749f, 58.5f, 8.682337f, 58.5f, 8.790238f);
                l.lineTo(58.5f, 10.462189f);
                l.lineTo(58.5f, 46.601345f);
                l.lineTo(58.5f, 49.617863f);
                l.cubicTo(58.5f, 52.427025f, 56.602406f, 55.166145f, 54.050106f, 56.346252f);
                l.cubicTo(53.575645f, 56.56563f, 50.57839f, 57.229782f, 50.187023f, 57.30784f);
                l.cubicTo(46.426563f, 58.057846f, 43.53723f, 54.864536f, 43.37811f, 51.635403f);
                l.cubicTo(43.21899f, 48.40627f, 45.355034f, 45.713642f, 47.833385f, 45.219345f);
                l.lineTo(51.70845f, 44.261543f);
                l.cubicTo(53.054424f, 43.928856f, 54.0f, 42.721104f, 54.0f, 41.334625f);
                l.lineTo(54.0f, 12.926538f);
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
