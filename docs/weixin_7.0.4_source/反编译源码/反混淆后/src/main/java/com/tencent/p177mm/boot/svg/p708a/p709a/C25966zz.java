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

/* renamed from: com.tencent.mm.boot.svg.a.a.zz */
public final class C25966zz extends C5163c {
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
                l.moveTo(27.992208f, 18.628246f);
                l.lineTo(52.969006f, 43.605045f);
                l.cubicTo(53.607788f, 43.046383f, 54.0f, 42.22757f, 54.0f, 41.334625f);
                l.lineTo(54.0f, 12.926538f);
                l.lineTo(27.992208f, 18.628246f);
                l.close();
                l.moveTo(58.5f, 49.13604f);
                l.lineTo(66.27565f, 56.91169f);
                l.lineTo(63.09367f, 60.09367f);
                l.lineTo(12.18198f, 9.18198f);
                l.lineTo(15.363961f, 6.0f);
                l.lineTo(23.873346f, 14.509386f);
                l.lineTo(56.679108f, 7.3249645f);
                l.cubicTo(57.488354f, 7.1477404f, 58.288048f, 7.660097f, 58.465275f, 8.469345f);
                l.cubicTo(58.488358f, 8.574749f, 58.5f, 8.682337f, 58.5f, 8.790238f);
                l.lineTo(58.5f, 49.13604f);
                l.close();
                l.moveTo(24.0f, 27.36396f);
                l.lineTo(24.0f, 57.603806f);
                l.cubicTo(24.0f, 60.412968f, 22.11874f, 63.15209f, 19.588413f, 64.3322f);
                l.cubicTo(19.118036f, 64.551575f, 16.14658f, 65.21572f, 15.758582f, 65.29378f);
                l.cubicTo(12.030496f, 66.043785f, 9.166035f, 62.850475f, 9.008285f, 59.62134f);
                l.cubicTo(8.850535f, 56.39221f, 10.96819f, 53.699585f, 13.425209f, 53.205288f);
                l.lineTo(17.218742f, 52.253464f);
                l.cubicTo(18.559702f, 51.917004f, 19.5f, 50.711636f, 19.5f, 49.32911f);
                l.lineTo(19.5f, 22.86396f);
                l.lineTo(24.0f, 27.36396f);
                l.close();
                l.moveTo(53.232395f, 56.596355f);
                l.cubicTo(52.16537f, 56.877518f, 50.474274f, 57.250546f, 50.187023f, 57.30784f);
                l.cubicTo(46.426563f, 58.057846f, 43.53723f, 54.864536f, 43.37811f, 51.635403f);
                l.cubicTo(43.306374f, 50.179596f, 43.701134f, 48.83284f, 44.383442f, 47.747402f);
                l.lineTo(53.232395f, 56.596355f);
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
