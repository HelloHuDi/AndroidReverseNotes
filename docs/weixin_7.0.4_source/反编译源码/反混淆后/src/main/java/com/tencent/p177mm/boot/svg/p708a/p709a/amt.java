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

/* renamed from: com.tencent.mm.boot.svg.a.a.amt */
public final class amt extends C5163c {
    private final int height = 96;
    private final int width = 96;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                k.setColor(-65794);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(77.0f, 25.0f);
                l.lineTo(19.0f, 25.0f);
                l.cubicTo(17.343f, 25.0f, 16.0f, 26.34297f, 16.0f, 27.999935f);
                l.lineTo(16.0f, 68.00007f);
                l.cubicTo(16.0f, 69.65703f, 17.343f, 71.0f, 19.0f, 71.0f);
                l.lineTo(77.0f, 71.0f);
                l.cubicTo(78.656f, 71.0f, 80.0f, 69.65703f, 80.0f, 68.00007f);
                l.lineTo(80.0f, 27.999935f);
                l.cubicTo(80.0f, 26.34297f, 78.657f, 25.0f, 77.0f, 25.0f);
                l.close();
                l.moveTo(72.77142f, 39.42813f);
                l.lineTo(49.779076f, 52.676395f);
                l.cubicTo(49.218597f, 52.999264f, 48.584373f, 53.06992f, 48.000298f, 52.935474f);
                l.cubicTo(47.414253f, 53.06992f, 46.781013f, 52.99828f, 46.22152f, 52.676395f);
                l.lineTo(23.229168f, 39.42813f);
                l.cubicTo(22.054132f, 38.750996f, 21.650982f, 37.250507f, 22.329454f, 36.07681f);
                l.lineTo(22.821102f, 35.226955f);
                l.cubicTo(23.499575f, 34.053257f, 25.004013f, 33.651886f, 26.179049f, 34.329018f);
                l.lineTo(48.000298f, 46.902115f);
                l.lineTo(69.820564f, 34.329018f);
                l.cubicTo(70.9956f, 33.651886f, 72.50004f, 34.053257f, 73.17753f, 35.226955f);
                l.lineTo(73.669174f, 36.07681f);
                l.cubicTo(74.34961f, 37.250507f, 73.94646f, 38.750996f, 72.77142f, 39.42813f);
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
