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

/* renamed from: com.tencent.mm.boot.svg.a.a.ih */
public final class C25897ih extends C5163c {
    private final int height = 54;
    private final int width = 54;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 54;
            case 1:
                return 54;
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
                k2 = C5163c.m7876a(k2, looper);
                k2.setStrokeWidth(1.0f);
                canvas.save();
                Paint a = C5163c.m7876a(k2, looper);
                a.setColor(-13290187);
                a.setStrokeWidth(4.0f);
                Path l = C5163c.m7884l(looper);
                l.moveTo(27.0f, 2.0f);
                l.cubicTo(40.80712f, 2.0f, 52.0f, 13.192881f, 52.0f, 27.0f);
                l.cubicTo(52.0f, 40.80712f, 40.80712f, 52.0f, 27.0f, 52.0f);
                l.cubicTo(13.192881f, 52.0f, 2.0f, 40.80712f, 2.0f, 27.0f);
                l.cubicTo(2.0f, 13.192881f, 13.192881f, 2.0f, 27.0f, 2.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-13290187);
                l = C5163c.m7884l(looper);
                l.moveTo(18.515137f, 20.405273f);
                l.lineTo(22.760254f, 20.405273f);
                l.cubicTo(22.944824f, 17.780273f, 24.77002f, 16.11914f, 27.600098f, 16.11914f);
                l.cubicTo(30.409668f, 16.11914f, 32.234863f, 17.759766f, 32.234863f, 20.015625f);
                l.cubicTo(32.234863f, 22.086914f, 31.353027f, 23.25586f, 28.871582f, 24.75293f);
                l.cubicTo(26.062012f, 26.43457f, 24.811035f, 28.280273f, 24.913574f, 31.233398f);
                l.lineTo(24.934082f, 32.791992f);
                l.lineTo(29.1792f, 32.791992f);
                l.lineTo(29.1792f, 31.561523f);
                l.cubicTo(29.1792f, 29.490234f, 29.937988f, 28.40332f, 32.583496f, 26.844727f);
                l.cubicTo(35.290527f, 25.22461f, 36.890137f, 22.989258f, 36.890137f, 19.831055f);
                l.cubicTo(36.890137f, 15.380859f, 33.239746f, 12.161133f, 27.825684f, 12.161133f);
                l.cubicTo(21.878418f, 12.161133f, 18.699707f, 15.688477f, 18.515137f, 20.405273f);
                l.close();
                l.moveTo(27.312988f, 42.47168f);
                l.cubicTo(29.199707f, 42.47168f, 30.471191f, 41.220703f, 30.471191f, 39.354492f);
                l.cubicTo(30.471191f, 37.447266f, 29.199707f, 36.19629f, 27.312988f, 36.19629f);
                l.cubicTo(25.42627f, 36.19629f, 24.134277f, 37.447266f, 24.134277f, 39.354492f);
                l.cubicTo(24.134277f, 41.220703f, 25.42627f, 42.47168f, 27.312988f, 42.47168f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
