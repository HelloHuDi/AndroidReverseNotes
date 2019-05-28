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

/* renamed from: com.tencent.mm.boot.svg.a.a.ajr */
public final class ajr extends C5163c {
    private final int height = 240;
    private final int width = 180;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 180;
            case 1:
                return 240;
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
                k.setColor(-1);
                canvas.saveLayerAlpha(null, 230, 4);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(90.0f, 180.0f);
                l.cubicTo(139.70563f, 180.0f, 180.0f, 139.70563f, 180.0f, 90.0f);
                l.cubicTo(180.0f, 40.294373f, 139.70563f, 0.0f, 90.0f, 0.0f);
                l.cubicTo(40.294373f, 0.0f, 0.0f, 40.294373f, 0.0f, 90.0f);
                l.cubicTo(0.0f, 139.70563f, 40.294373f, 180.0f, 90.0f, 180.0f);
                l.close();
                l.moveTo(103.76728f, 117.98263f);
                l.cubicTo(100.49875f, 119.62946f, 96.85723f, 120.66371f, 93.0f, 120.93096f);
                l.lineTo(93.0f, 129.0f);
                l.lineTo(93.0f, 129.0f);
                l.lineTo(107.000854f, 129.0f);
                l.cubicTo(107.552666f, 129.0f, 108.0f, 129.44336f, 108.0f, 130.00937f);
                l.lineTo(108.0f, 131.99063f);
                l.cubicTo(108.0f, 132.5481f, 107.545074f, 133.0f, 107.000854f, 133.0f);
                l.lineTo(74.999146f, 133.0f);
                l.cubicTo(74.447334f, 133.0f, 74.0f, 132.55664f, 74.0f, 131.99063f);
                l.lineTo(74.0f, 130.00937f);
                l.cubicTo(74.0f, 129.4519f, 74.454926f, 129.0f, 74.999146f, 129.0f);
                l.lineTo(89.0f, 129.0f);
                l.lineTo(89.0f, 120.93096f);
                l.lineTo(89.0f, 120.93096f);
                l.cubicTo(74.46945f, 119.92421f, 63.0f, 108.032974f, 63.0f, 93.51188f);
                l.lineTo(63.0f, 88.99816f);
                l.cubicTo(63.0f, 88.45106f, 63.451874f, 88.0f, 64.009285f, 88.0f);
                l.lineTo(65.99039f, 88.0f);
                l.cubicTo(66.55636f, 88.0f, 66.99967f, 88.45177f, 66.99967f, 89.009056f);
                l.lineTo(66.99967f, 93.36467f);
                l.cubicTo(66.99967f, 106.95095f, 78.00566f, 117.0f, 91.0f, 117.0f);
                l.cubicTo(94.46276f, 117.0f, 97.784004f, 116.298294f, 100.79325f, 115.0086f);
                l.lineTo(103.76728f, 117.98263f);
                l.lineTo(103.76728f, 117.98263f);
                l.close();
                l.moveTo(112.10175f, 111.58026f);
                l.cubicTo(116.397675f, 106.74892f, 119.0f, 100.42874f, 119.0f, 93.51188f);
                l.lineTo(119.0f, 88.99816f);
                l.cubicTo(119.0f, 88.44689f, 118.556175f, 88.0f, 117.99989f, 88.0f);
                l.lineTo(115.99589f, 88.0f);
                l.cubicTo(115.44354f, 88.0f, 114.99578f, 88.45739f, 114.99578f, 89.009056f);
                l.lineTo(114.99578f, 93.36467f);
                l.cubicTo(114.99578f, 99.441376f, 112.848305f, 104.76214f, 109.33026f, 108.80877f);
                l.lineTo(112.10175f, 111.58026f);
                l.lineTo(112.10175f, 111.58026f);
                l.close();
                l.moveTo(103.92377f, 103.40227f);
                l.cubicTo(105.85821f, 100.75579f, 107.0f, 97.49277f, 107.0f, 93.96288f);
                l.lineTo(107.0f, 63.976562f);
                l.cubicTo(107.0f, 55.14248f, 99.836555f, 47.969723f, 91.0f, 47.969723f);
                l.cubicTo(82.1615f, 47.969723f, 75.0f, 55.13623f, 75.0f, 63.976562f);
                l.lineTo(75.0f, 74.47851f);
                l.lineTo(103.92377f, 103.40227f);
                l.lineTo(103.92377f, 103.40227f);
                l.close();
                l.moveTo(95.19794f, 109.413284f);
                l.cubicTo(93.86017f, 109.776115f, 92.452736f, 109.96972f, 91.0f, 109.96972f);
                l.cubicTo(82.163445f, 109.96972f, 75.0f, 102.79697f, 75.0f, 93.96288f);
                l.lineTo(75.0f, 89.21535f);
                l.lineTo(95.19794f, 109.413284f);
                l.lineTo(95.19794f, 109.413284f);
                l.close();
                l.moveTo(117.006836f, 126.44923f);
                l.lineTo(60.164734f, 69.60712f);
                l.lineTo(62.99316f, 66.778694f);
                l.lineTo(119.835266f, 123.6208f);
                l.lineTo(117.006836f, 126.44923f);
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
