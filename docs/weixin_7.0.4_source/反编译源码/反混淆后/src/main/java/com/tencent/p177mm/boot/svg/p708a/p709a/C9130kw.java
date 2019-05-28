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

/* renamed from: com.tencent.mm.boot.svg.a.a.kw */
public final class C9130kw extends C5163c {
    private final int height = 144;
    private final int width = 144;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                a.setColor(-9276814);
                Path l = C5163c.m7884l(looper);
                l.moveTo(120.0f, 12.0f);
                l.lineTo(24.0f, 12.0f);
                l.cubicTo(17.4f, 12.0f, 12.06f, 17.4f, 12.06f, 24.0f);
                l.lineTo(12.0f, 132.0f);
                l.lineTo(36.0f, 108.0f);
                l.lineTo(120.0f, 108.0f);
                l.cubicTo(126.6f, 108.0f, 132.0f, 102.6f, 132.0f, 96.0f);
                l.lineTo(132.0f, 24.0f);
                l.cubicTo(132.0f, 17.4f, 126.6f, 12.0f, 120.0f, 12.0f);
                l.lineTo(120.0f, 12.0f);
                l.close();
                l.moveTo(108.0f, 84.0f);
                l.lineTo(36.0f, 84.0f);
                l.lineTo(36.0f, 72.0f);
                l.lineTo(108.0f, 72.0f);
                l.lineTo(108.0f, 84.0f);
                l.lineTo(108.0f, 84.0f);
                l.close();
                l.moveTo(108.0f, 66.0f);
                l.lineTo(36.0f, 66.0f);
                l.lineTo(36.0f, 54.0f);
                l.lineTo(108.0f, 54.0f);
                l.lineTo(108.0f, 66.0f);
                l.lineTo(108.0f, 66.0f);
                l.close();
                l.moveTo(108.0f, 48.0f);
                l.lineTo(36.0f, 48.0f);
                l.lineTo(36.0f, 36.0f);
                l.lineTo(108.0f, 36.0f);
                l.lineTo(108.0f, 48.0f);
                l.lineTo(108.0f, 48.0f);
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
