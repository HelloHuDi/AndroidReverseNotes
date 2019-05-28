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

/* renamed from: com.tencent.mm.boot.svg.a.a.acd */
public final class acd extends C5163c {
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
                k.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(15.6f, 9.6f);
                l.lineTo(15.6f, 62.4f);
                l.lineTo(56.4f, 62.4f);
                l.lineTo(56.4f, 9.6f);
                l.lineTo(15.6f, 9.6f);
                l.close();
                l.moveTo(12.0f, 9.0f);
                l.cubicTo(12.0f, 7.343146f, 13.343145f, 6.0f, 15.0f, 6.0f);
                l.lineTo(57.0f, 6.0f);
                l.cubicTo(58.656853f, 6.0f, 60.0f, 7.343146f, 60.0f, 9.0f);
                l.lineTo(60.0f, 63.0f);
                l.cubicTo(60.0f, 64.65685f, 58.656853f, 66.0f, 57.0f, 66.0f);
                l.lineTo(15.0f, 66.0f);
                l.cubicTo(13.343145f, 66.0f, 12.0f, 64.65685f, 12.0f, 63.0f);
                l.lineTo(12.0f, 9.0f);
                l.close();
                l.moveTo(36.0f, 60.0f);
                l.cubicTo(34.343147f, 60.0f, 33.0f, 58.656853f, 33.0f, 57.0f);
                l.cubicTo(33.0f, 55.343147f, 34.343147f, 54.0f, 36.0f, 54.0f);
                l.cubicTo(37.656853f, 54.0f, 39.0f, 55.343147f, 39.0f, 57.0f);
                l.cubicTo(39.0f, 58.656853f, 37.656853f, 60.0f, 36.0f, 60.0f);
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
