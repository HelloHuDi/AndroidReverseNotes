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

/* renamed from: com.tencent.mm.boot.svg.a.a.abu */
public final class abu extends C5163c {
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
                l.moveTo(36.0f, 66.0f);
                l.cubicTo(19.431458f, 66.0f, 6.0f, 52.568542f, 6.0f, 36.0f);
                l.cubicTo(6.0f, 19.431458f, 19.431458f, 6.0f, 36.0f, 6.0f);
                l.cubicTo(52.568542f, 6.0f, 66.0f, 19.431458f, 66.0f, 36.0f);
                l.cubicTo(66.0f, 52.568542f, 52.568542f, 66.0f, 36.0f, 66.0f);
                l.close();
                l.moveTo(36.0f, 62.4f);
                l.cubicTo(50.58032f, 62.4f, 62.4f, 50.58032f, 62.4f, 36.0f);
                l.cubicTo(62.4f, 21.419683f, 50.58032f, 9.6f, 36.0f, 9.6f);
                l.cubicTo(21.419683f, 9.6f, 9.6f, 21.419683f, 9.6f, 36.0f);
                l.cubicTo(9.6f, 50.58032f, 21.419683f, 62.4f, 36.0f, 62.4f);
                l.close();
                l.moveTo(45.43322f, 37.56829f);
                l.lineTo(45.01818f, 37.572727f);
                l.cubicTo(43.807514f, 37.572727f, 43.1058f, 36.723286f, 43.56062f, 35.700005f);
                l.cubicTo(43.882267f, 34.949493f, 44.61438f, 34.358173f, 45.493244f, 34.16292f);
                l.cubicTo(48.049187f, 33.545967f, 49.80909f, 31.53819f, 49.80909f, 29.181818f);
                l.cubicTo(49.80909f, 26.344769f, 47.118664f, 24.027273f, 43.745453f, 24.027273f);
                l.cubicTo(40.372242f, 24.027273f, 37.681816f, 26.344769f, 37.681816f, 29.181818f);
                l.lineTo(37.681816f, 42.81818f);
                l.cubicTo(37.681816f, 47.521393f, 33.467216f, 51.3f, 28.290909f, 51.3f);
                l.cubicTo(23.1146f, 51.3f, 18.9f, 47.521393f, 18.9f, 42.81818f);
                l.cubicTo(18.9f, 38.697357f, 22.159544f, 35.184917f, 26.563635f, 34.51818f);
                l.lineTo(26.92727f, 34.51818f);
                l.cubicTo(27.858202f, 34.51818f, 28.499998f, 35.058643f, 28.499998f, 35.81818f);
                l.cubicTo(28.500383f, 35.950336f, 28.497911f, 36.01463f, 28.484554f, 36.094772f);
                l.cubicTo(28.46752f, 36.19698f, 28.434095f, 36.293537f, 28.384832f, 36.390903f);
                l.cubicTo(28.079563f, 37.1032f, 27.287638f, 37.719143f, 26.45221f, 37.92799f);
                l.cubicTo(23.910059f, 38.54161f, 22.136362f, 40.540142f, 22.136362f, 42.81818f);
                l.cubicTo(22.136362f, 45.65523f, 24.82679f, 47.97273f, 28.199999f, 47.97273f);
                l.cubicTo(31.573208f, 47.97273f, 34.263634f, 45.65523f, 34.263634f, 42.81818f);
                l.lineTo(34.263634f, 29.181818f);
                l.cubicTo(34.263634f, 24.478607f, 38.478237f, 20.7f, 43.654545f, 20.7f);
                l.cubicTo(48.830853f, 20.7f, 53.045452f, 24.478607f, 53.045452f, 29.181818f);
                l.cubicTo(53.045452f, 33.34714f, 49.839336f, 36.80201f, 45.43322f, 37.56829f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
