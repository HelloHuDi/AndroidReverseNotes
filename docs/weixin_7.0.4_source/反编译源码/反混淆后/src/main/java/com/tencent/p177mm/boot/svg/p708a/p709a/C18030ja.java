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

/* renamed from: com.tencent.mm.boot.svg.a.a.ja */
public final class C18030ja extends C5163c {
    private final int height = 144;
    private final int width = 144;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-9276814);
                Path l = C5163c.m7884l(looper);
                l.moveTo(15.052474f, 8.0f);
                l.cubicTo(11.166417f, 8.0f, 8.0f, 11.165231f, 8.0f, 15.049831f);
                l.lineTo(8.0f, 128.9022f);
                l.cubicTo(8.0f, 132.78682f, 11.166417f, 135.95204f, 15.052474f, 135.95204f);
                l.lineTo(76.365814f, 135.95204f);
                l.lineTo(76.365814f, 86.41139f);
                l.lineTo(59.670166f, 86.41139f);
                l.lineTo(59.670166f, 67.084305f);
                l.lineTo(76.365814f, 67.084305f);
                l.lineTo(76.365814f, 52.840763f);
                l.cubicTo(76.365814f, 36.295242f, 86.488754f, 27.32709f, 101.21739f, 27.32709f);
                l.cubicTo(108.26987f, 27.32709f, 114.362816f, 27.854628f, 116.13793f, 28.094418f);
                l.lineTo(116.13793f, 45.35931f);
                l.lineTo(105.91904f, 45.35931f);
                l.cubicTo(97.90704f, 45.35931f, 96.32384f, 49.147995f, 96.32384f, 54.759087f);
                l.lineTo(96.32384f, 67.084305f);
                l.lineTo(115.46627f, 67.084305f);
                l.lineTo(112.97151f, 86.41139f);
                l.lineTo(96.32384f, 86.41139f);
                l.lineTo(96.32384f, 136.0f);
                l.lineTo(128.94753f, 136.0f);
                l.cubicTo(132.83359f, 136.0f, 136.0f, 132.83476f, 136.0f, 128.95016f);
                l.lineTo(136.0f, 15.049831f);
                l.cubicTo(136.0f, 11.117272f, 132.88156f, 8.0f, 128.94753f, 8.0f);
                l.lineTo(15.052474f, 8.0f);
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
