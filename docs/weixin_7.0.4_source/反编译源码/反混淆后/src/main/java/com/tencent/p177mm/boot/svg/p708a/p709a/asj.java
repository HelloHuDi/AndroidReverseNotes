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

/* renamed from: com.tencent.mm.boot.svg.a.a.asj */
public final class asj extends C5163c {
    private final int height = 168;
    private final int width = 168;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 168;
            case 1:
                return 168;
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
                k.setColor(-1973786);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(168.0f, 0.0f);
                l.lineTo(168.0f, 168.0f);
                l.lineTo(0.0f, 168.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                l.moveTo(0.0f, 11.997895f);
                l.cubicTo(0.0f, 5.3716407f, 5.3758125f, 0.0f, 11.997895f, 0.0f);
                l.lineTo(156.0021f, 0.0f);
                l.cubicTo(162.62836f, 0.0f, 168.0f, 5.3758125f, 168.0f, 11.997895f);
                l.lineTo(168.0f, 156.0021f);
                l.cubicTo(168.0f, 162.62836f, 162.62419f, 168.0f, 156.0021f, 168.0f);
                l.lineTo(11.997895f, 168.0f);
                l.cubicTo(5.3716407f, 168.0f, 0.0f, 162.62419f, 0.0f, 156.0021f);
                l.lineTo(0.0f, 11.997895f);
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
