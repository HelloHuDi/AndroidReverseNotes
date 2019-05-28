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

/* renamed from: com.tencent.mm.boot.svg.a.a.awb */
public final class awb extends C5163c {
    private final int height = 46;
    private final int width = 46;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 46;
            case 1:
                return 46;
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
                a.setColor(-6710887);
                Path l = C5163c.m7884l(looper);
                l.moveTo(23.0f, 0.0f);
                l.cubicTo(35.70255f, 0.0f, 46.0f, 10.29745f, 46.0f, 23.0f);
                l.cubicTo(46.0f, 35.70255f, 35.70255f, 46.0f, 23.0f, 46.0f);
                l.cubicTo(10.29745f, 46.0f, 0.0f, 35.70255f, 0.0f, 23.0f);
                l.cubicTo(0.0f, 10.29745f, 10.29745f, 0.0f, 23.0f, 0.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-1);
                l = C5163c.m7884l(looper);
                l.moveTo(29.837742f, 16.978155f);
                l.cubicTo(29.663364f, 15.734242f, 29.332104f, 14.538659f, 28.424576f, 13.573514f);
                l.cubicTo(25.837162f, 10.148845f, 20.172827f, 10.138831f, 17.585415f, 13.5635f);
                l.cubicTo(15.967033f, 15.315889f, 16.176823f, 17.799276f, 15.827173f, 19.982252f);
                l.lineTo(13.0f, 19.982252f);
                l.cubicTo(13.00999f, 24.328176f, 13.00999f, 28.66409f, 13.00999f, 33.0f);
                l.lineTo(32.99001f, 33.0f);
                l.cubicTo(32.99001f, 28.66409f, 32.99001f, 24.328176f, 33.0f, 19.982252f);
                l.lineTo(31.586414f, 19.982252f);
                l.lineTo(26.086912f, 19.982252f);
                l.lineTo(18.824175f, 19.982252f);
                l.cubicTo(18.804195f, 17.358675f, 19.713287f, 13.873924f, 22.99001f, 13.97406f);
                l.cubicTo(25.067957f, 13.891255f, 26.212177f, 15.279206f, 26.759495f, 16.978155f);
                l.lineTo(29.837742f, 16.978155f);
                l.lineTo(29.837742f, 16.978155f);
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
