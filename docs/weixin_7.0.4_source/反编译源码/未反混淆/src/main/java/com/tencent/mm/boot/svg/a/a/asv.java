package com.tencent.mm.boot.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class asv extends c {
    private final int height = 54;
    private final int width = 54;

    public final int a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 54;
            case 1:
                return 54;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.h(looper);
                c.g(looper);
                Paint k = c.k(looper);
                k.setFlags(385);
                k.setStyle(Style.FILL);
                Paint k2 = c.k(looper);
                k2.setFlags(385);
                k2.setStyle(Style.STROKE);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                k2.setStrokeWidth(1.0f);
                k2.setStrokeCap(Cap.BUTT);
                k2.setStrokeJoin(Join.MITER);
                k2.setStrokeMiter(4.0f);
                k2.setPathEffect(null);
                c.a(k2, looper).setStrokeWidth(1.0f);
                k = c.a(k, looper);
                k.setColor(-8683387);
                canvas.save();
                Paint a = c.a(k, looper);
                Path l = c.l(looper);
                l.moveTo(22.908676f, 30.950693f);
                l.cubicTo(27.023159f, 35.1021f, 30.232687f, 36.895073f, 32.456608f, 36.895073f);
                l.cubicTo(34.680527f, 36.895073f, 37.381214f, 34.49798f, 39.075436f, 34.45544f);
                l.cubicTo(40.475136f, 34.420296f, 45.419086f, 37.832767f, 45.94186f, 38.32456f);
                l.cubicTo(46.464634f, 38.816353f, 47.099957f, 39.55505f, 46.986763f, 40.05478f);
                l.cubicTo(46.87357f, 40.55451f, 44.11331f, 47.862286f, 38.14088f, 46.915455f);
                l.cubicTo(32.16845f, 45.968628f, 23.842045f, 39.47246f, 19.097456f, 34.797325f);
                l.lineTo(22.908676f, 30.950693f);
                l.close();
                l.moveTo(16.985262f, 21.787113f);
                l.cubicTo(17.054878f, 19.63332f, 19.520647f, 16.662056f, 19.493423f, 14.951664f);
                l.cubicTo(19.463087f, 13.04565f, 16.725452f, 8.970869f, 15.613527f, 7.9975863f);
                l.cubicTo(14.5016f, 7.024304f, 14.318393f, 6.923723f, 13.703174f, 7.037072f);
                l.cubicTo(13.0879545f, 7.150421f, 6.1487045f, 9.55696f, 7.0871115f, 15.582992f);
                l.cubicTo(8.025518f, 21.609024f, 14.463901f, 30.010153f, 19.097456f, 34.797325f);
                l.lineTo(22.911219f, 30.946669f);
                l.cubicTo(18.796738f, 26.79526f, 16.915646f, 23.940908f, 16.985262f, 21.787113f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                c.j(looper);
                break;
        }
        return 0;
    }
}
