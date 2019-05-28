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

/* renamed from: com.tencent.mm.boot.svg.a.a.aon */
public final class aon extends C5163c {
    private final int height = 24;
    private final int width = 30;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 30;
            case 1:
                return 24;
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
                canvas.save();
                k2 = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(26.0f, 0.0f);
                l.lineTo(26.0f, 20.0f);
                l.lineTo(0.0f, 20.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                l.moveTo(24.0f, 2.0f);
                l.lineTo(2.0f, 2.0f);
                l.lineTo(2.0f, 17.0f);
                l.lineTo(24.0f, 17.0f);
                l.lineTo(24.0f, 2.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                k2 = C5163c.m7876a(k, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(28.0f, 23.0f);
                l.lineTo(29.0f, 23.0f);
                l.lineTo(29.0f, 3.0f);
                l.lineTo(27.0f, 3.0f);
                l.lineTo(27.0f, 21.0f);
                l.lineTo(3.0f, 21.0f);
                l.lineTo(3.0f, 23.0f);
                l.lineTo(28.0f, 23.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(19.784946f, 8.898396f);
                l2.lineTo(15.462585f, 11.916007f);
                l2.lineTo(8.518518f, 6.5454545f);
                l2.lineTo(0.0f, 13.368984f);
                l2.lineTo(0.0f, 18.545454f);
                l2.lineTo(25.555555f, 18.545454f);
                l2.lineTo(25.555555f, 13.368984f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, k);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
