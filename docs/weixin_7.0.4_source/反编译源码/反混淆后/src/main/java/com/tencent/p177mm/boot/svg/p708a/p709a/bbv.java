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

/* renamed from: com.tencent.mm.boot.svg.a.a.bbv */
public final class bbv extends C5163c {
    private final int height = 48;
    private final int width = 48;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                a.setColor(-1);
                Path l = C5163c.m7884l(looper);
                l.moveTo(16.966213f, 24.12567f);
                l.lineTo(18.380426f, 25.539883f);
                l.lineTo(15.993941f, 27.926369f);
                l.cubicTo(14.794056f, 29.126255f, 14.782134f, 31.04559f, 15.949747f, 32.213203f);
                l.cubicTo(17.117361f, 33.380817f, 19.036695f, 33.368896f, 20.236582f, 32.16901f);
                l.lineTo(25.009554f, 27.396038f);
                l.cubicTo(26.20944f, 26.196152f, 26.221361f, 24.276817f, 25.053747f, 23.109203f);
                l.lineTo(26.46796f, 21.69499f);
                l.cubicTo(28.420582f, 23.647612f, 28.400795f, 26.833223f, 26.423767f, 28.810251f);
                l.lineTo(21.650795f, 33.58322f);
                l.cubicTo(19.673767f, 35.560253f, 16.488155f, 35.58004f, 14.535534f, 33.62742f);
                l.cubicTo(12.582912f, 31.674795f, 12.602699f, 28.489183f, 14.579728f, 26.512156f);
                l.lineTo(16.966213f, 24.12567f);
                l.close();
                l.moveTo(33.58322f, 21.650795f);
                l.lineTo(31.196737f, 24.037281f);
                l.lineTo(29.782524f, 22.623068f);
                l.lineTo(32.16901f, 20.236582f);
                l.cubicTo(33.368896f, 19.036695f, 33.380817f, 17.117361f, 32.213203f, 15.949747f);
                l.cubicTo(31.04559f, 14.782134f, 29.126255f, 14.794056f, 27.926369f, 15.993941f);
                l.lineTo(23.153399f, 20.766912f);
                l.cubicTo(21.953512f, 21.966799f, 21.94159f, 23.886133f, 23.109203f, 25.053747f);
                l.lineTo(21.69499f, 26.46796f);
                l.cubicTo(19.742369f, 24.515339f, 19.762156f, 21.329727f, 21.739183f, 19.3527f);
                l.lineTo(26.512156f, 14.579728f);
                l.cubicTo(28.489183f, 12.602699f, 31.674795f, 12.582912f, 33.62742f, 14.535534f);
                l.cubicTo(35.58004f, 16.488155f, 35.560253f, 19.673767f, 33.58322f, 21.650795f);
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
