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

/* renamed from: com.tencent.mm.boot.svg.a.a.bcc */
public final class bcc extends C5163c {
    private final int height = 39;
    private final int width = 39;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 39;
            case 1:
                return 39;
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
                a.setColor(WebView.NIGHT_MODE_COLOR);
                Path l = C5163c.m7884l(looper);
                l.moveTo(15.911817f, 28.210007f);
                l.cubicTo(12.592391f, 26.960802f, 10.230769f, 23.756193f, 10.230769f, 20.0f);
                l.cubicTo(10.230769f, 15.156888f, 14.156888f, 11.230769f, 19.0f, 11.230769f);
                l.cubicTo(23.843113f, 11.230769f, 27.76923f, 15.156888f, 27.76923f, 20.0f);
                l.cubicTo(27.76923f, 20.19488f, 27.762875f, 20.388273f, 27.750357f, 20.579987f);
                l.cubicTo(30.774906f, 21.11086f, 33.20298f, 23.374031f, 33.973866f, 26.308788f);
                l.cubicTo(34.5412f, 26.484497f, 35.077324f, 26.731188f, 35.57187f, 27.038485f);
                l.cubicTo(36.491306f, 24.876438f, 37.0f, 22.497625f, 37.0f, 20.0f);
                l.cubicTo(37.0f, 10.058874f, 28.941126f, 2.0f, 19.0f, 2.0f);
                l.cubicTo(9.058874f, 2.0f, 1.0f, 10.058874f, 1.0f, 20.0f);
                l.cubicTo(1.0f, 29.941126f, 9.058874f, 38.0f, 19.0f, 38.0f);
                l.cubicTo(19.099163f, 38.0f, 19.198141f, 37.9992f, 19.296925f, 37.9976f);
                l.cubicTo(19.3516f, 37.999195f, 19.406475f, 38.0f, 19.461538f, 38.0f);
                l.lineTo(32.384617f, 38.0f);
                l.lineTo(32.384617f, 37.9793f);
                l.cubicTo(34.97223f, 37.74612f, 37.0f, 35.571404f, 37.0f, 32.923077f);
                l.cubicTo(37.0f, 30.269276f, 34.96384f, 28.091045f, 32.368565f, 27.865429f);
                l.cubicTo(32.142185f, 24.75823f, 29.549576f, 22.307692f, 26.384615f, 22.307692f);
                l.cubicTo(23.496096f, 22.307692f, 21.084314f, 24.348843f, 20.512947f, 27.067463f);
                l.cubicTo(20.216953f, 26.979319f, 19.868599f, 26.929428f, 19.461538f, 26.923077f);
                l.cubicTo(18.110815f, 26.923077f, 16.873026f, 27.406603f, 15.911817f, 28.210007f);
                l.close();
                canvas.saveLayerAlpha(null, 76, 4);
                k2 = C5163c.m7876a(a, looper);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k2);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
