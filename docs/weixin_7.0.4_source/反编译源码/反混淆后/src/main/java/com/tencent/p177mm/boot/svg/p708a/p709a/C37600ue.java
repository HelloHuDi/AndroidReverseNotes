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

/* renamed from: com.tencent.mm.boot.svg.a.a.ue */
public final class C37600ue extends C5163c {
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
                k.setColor(-15028967);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(37.8f, 59.92905f);
                l.lineTo(37.8f, 69.0f);
                l.lineTo(34.2f, 69.0f);
                l.lineTo(34.2f, 59.929047f);
                l.cubicTo(22.615196f, 59.012062f, 13.5f, 49.320515f, 13.5f, 37.5f);
                l.lineTo(13.5f, 33.0f);
                l.lineTo(17.1f, 33.0f);
                l.lineTo(17.1f, 37.5f);
                l.cubicTo(17.1f, 47.938183f, 25.56182f, 56.4f, 36.0f, 56.4f);
                l.cubicTo(46.438183f, 56.4f, 54.9f, 47.938183f, 54.9f, 37.5f);
                l.lineTo(54.9f, 33.0f);
                l.lineTo(58.5f, 33.0f);
                l.lineTo(58.5f, 37.5f);
                l.cubicTo(58.5f, 49.320515f, 49.384804f, 59.012062f, 37.8f, 59.92905f);
                l.close();
                l.moveTo(22.5f, 19.5f);
                l.cubicTo(22.5f, 12.044156f, 28.544155f, 6.0f, 36.0f, 6.0f);
                l.cubicTo(43.455845f, 6.0f, 49.5f, 12.044156f, 49.5f, 19.5f);
                l.lineTo(49.5f, 37.5f);
                l.cubicTo(49.5f, 44.955845f, 43.455845f, 51.0f, 36.0f, 51.0f);
                l.cubicTo(28.544155f, 51.0f, 22.5f, 44.955845f, 22.5f, 37.5f);
                l.lineTo(22.5f, 19.5f);
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
