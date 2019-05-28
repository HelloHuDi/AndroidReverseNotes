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

/* renamed from: com.tencent.mm.boot.svg.a.a.kq */
public final class C25905kq extends C5163c {
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
                k.setColor(-8617851);
                canvas.save();
                k = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(10.0f, 15.0f);
                l.lineTo(10.0f, 23.0f);
                l.lineTo(84.0f, 23.0f);
                l.lineTo(84.0f, 15.0f);
                l.lineTo(10.0f, 15.0f);
                l.close();
                l.moveTo(59.0f, 48.0f);
                l.lineTo(69.0f, 48.0f);
                l.lineTo(69.0f, 81.0f);
                l.lineTo(77.0f, 81.0f);
                l.lineTo(77.0f, 48.0f);
                l.lineTo(88.0f, 48.0f);
                l.lineTo(72.89502f, 31.989258f);
                l.lineTo(59.0f, 48.0f);
                l.close();
                l.moveTo(10.0f, 48.0f);
                l.lineTo(50.145832f, 48.0f);
                l.lineTo(57.0f, 40.0f);
                l.lineTo(10.0f, 40.0f);
                l.lineTo(10.0f, 48.0f);
                l.close();
                l.moveTo(10.0f, 73.0f);
                l.lineTo(61.0f, 73.0f);
                l.lineTo(61.0f, 65.0f);
                l.lineTo(10.0f, 65.0f);
                l.lineTo(10.0f, 73.0f);
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
