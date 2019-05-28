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

/* renamed from: com.tencent.mm.boot.svg.a.a.baf */
public final class baf extends C5163c {
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
                k.setColor(-16139513);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(25.802883f, 46.304134f);
                l.cubicTo(32.66371f, 53.164963f, 39.164425f, 56.38293f, 41.568413f, 56.19449f);
                l.cubicTo(43.972404f, 56.006046f, 49.959015f, 51.88904f, 52.785183f, 51.94384f);
                l.cubicTo(54.143463f, 51.970177f, 63.019405f, 57.972977f, 64.09384f, 58.667f);
                l.cubicTo(65.168274f, 59.361023f, 66.16451f, 60.171726f, 65.97718f, 61.197594f);
                l.cubicTo(65.789856f, 62.22346f, 61.88898f, 73.52336f, 51.930058f, 71.95859f);
                l.cubicTo(41.97113f, 70.39381f, 28.086994f, 59.657917f, 20.175474f, 51.931545f);
                l.lineTo(25.802883f, 46.304134f);
                l.lineTo(25.802883f, 46.304134f);
                l.close();
                l.moveTo(25.802883f, 46.304134f);
                l.cubicTo(18.942055f, 39.443306f, 15.724086f, 32.942593f, 15.91253f, 30.538603f);
                l.cubicTo(16.100973f, 28.134613f, 20.217976f, 22.148005f, 20.163176f, 19.321836f);
                l.cubicTo(20.13684f, 17.963554f, 14.13404f, 9.087612f, 13.440018f, 8.01318f);
                l.cubicTo(12.7459955f, 6.938746f, 11.935291f, 5.9425087f, 10.909425f, 6.129835f);
                l.cubicTo(9.883557f, 6.317161f, -1.4163445f, 10.218036f, 0.14843264f, 20.176962f);
                l.cubicTo(1.7132099f, 30.13589f, 12.449101f, 44.020023f, 20.175474f, 51.931545f);
                l.lineTo(25.802883f, 46.304134f);
                l.close();
                l.moveTo(71.95439f, 37.577858f);
                l.cubicTo(72.06316f, 27.928717f, 68.43634f, 18.245283f, 61.07391f, 10.8828535f);
                l.cubicTo(53.78275f, 3.591691f, 44.215294f, -0.035837848f, 34.659115f, 2.668559E-4f);
                l.lineTo(34.659115f, 2.668559E-4f);
                l.lineTo(34.659115f, 6.1705666f);
                l.cubicTo(42.622982f, 6.140183f, 50.596336f, 9.163122f, 56.672596f, 15.239385f);
                l.cubicTo(62.831516f, 21.398304f, 65.85348f, 29.506277f, 65.73848f, 37.577858f);
                l.lineTo(71.95439f, 37.577858f);
                l.close();
                l.moveTo(56.445175f, 37.661373f);
                l.cubicTo(56.561077f, 31.967367f, 54.446472f, 26.236395f, 50.10136f, 21.891281f);
                l.cubicTo(45.83891f, 17.628828f, 40.24282f, 15.512826f, 34.65626f, 15.543274f);
                l.lineTo(34.65626f, 15.543274f);
                l.lineTo(34.65626f, 21.736135f);
                l.cubicTo(38.657936f, 21.7056f, 42.669193f, 23.216957f, 45.72244f, 26.270203f);
                l.cubicTo(48.858353f, 29.406116f, 50.367752f, 33.552616f, 50.250637f, 37.661373f);
                l.lineTo(56.445175f, 37.661373f);
                l.lineTo(56.445175f, 37.661373f);
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
