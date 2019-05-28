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

/* renamed from: com.tencent.mm.boot.svg.a.a.afe */
public final class afe extends C5163c {
    private final int height = 70;
    private final int width = 90;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 70;
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
                a.setColor(-1);
                Path l = C5163c.m7884l(looper);
                l.moveTo(69.0f, 50.0f);
                l.lineTo(21.0f, 50.0f);
                l.lineTo(21.0f, 52.008118f);
                l.cubicTo(21.0f, 53.108204f, 20.113445f, 54.0f, 18.994081f, 54.0f);
                l.lineTo(16.005919f, 54.0f);
                l.cubicTo(14.898081f, 54.0f, 14.0f, 53.1066f, 14.0f, 52.008118f);
                l.lineTo(14.0f, 50.0f);
                l.lineTo(0.0f, 50.0f);
                l.lineTo(0.0f, 43.0f);
                l.lineTo(14.0f, 43.0f);
                l.lineTo(14.0f, 43.0f);
                l.lineTo(14.0f, 40.991882f);
                l.cubicTo(14.0f, 39.891796f, 14.886555f, 39.0f, 16.005919f, 39.0f);
                l.lineTo(18.994081f, 39.0f);
                l.cubicTo(20.10192f, 39.0f, 21.0f, 39.8934f, 21.0f, 40.991882f);
                l.lineTo(21.0f, 43.0f);
                l.lineTo(69.0f, 43.0f);
                l.lineTo(69.0f, 40.991882f);
                l.cubicTo(69.0f, 39.891796f, 69.88656f, 39.0f, 71.00592f, 39.0f);
                l.lineTo(73.99408f, 39.0f);
                l.cubicTo(75.10192f, 39.0f, 76.0f, 39.8934f, 76.0f, 40.991882f);
                l.lineTo(76.0f, 43.0f);
                l.lineTo(90.0f, 43.0f);
                l.lineTo(90.0f, 50.0f);
                l.lineTo(76.0f, 50.0f);
                l.lineTo(76.0f, 52.008118f);
                l.cubicTo(76.0f, 53.108204f, 75.11344f, 54.0f, 73.99408f, 54.0f);
                l.lineTo(71.00592f, 54.0f);
                l.cubicTo(69.89808f, 54.0f, 69.0f, 53.1066f, 69.0f, 52.008118f);
                l.lineTo(69.0f, 50.0f);
                l.close();
                l.moveTo(0.0f, 3.99323f);
                l.cubicTo(0.0f, 2.8923995f, 0.8907616f, 2.0f, 2.0059645f, 2.0f);
                l.lineTo(87.99403f, 2.0f);
                l.cubicTo(89.1019f, 2.0f, 90.0f, 2.8954434f, 90.0f, 3.99323f);
                l.lineTo(90.0f, 66.00677f);
                l.cubicTo(90.0f, 67.1076f, 89.10924f, 68.0f, 87.99403f, 68.0f);
                l.lineTo(2.0059645f, 68.0f);
                l.cubicTo(0.898101f, 68.0f, 0.0f, 67.10455f, 0.0f, 66.00677f);
                l.lineTo(0.0f, 3.99323f);
                l.close();
                canvas.saveLayerAlpha(null, 128, 4);
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
