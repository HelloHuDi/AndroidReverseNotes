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

/* renamed from: com.tencent.mm.boot.svg.a.a.tf */
public final class C41868tf extends C5163c {
    private final int height = 27;
    private final int width = 27;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 27;
            case 1:
                return 27;
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
                a.setColor(-772816);
                Path l = C5163c.m7884l(looper);
                l.moveTo(27.0f, 13.666667f);
                l.cubicTo(27.0f, 6.044f, 20.956f, 0.0f, 13.333333f, 0.0f);
                l.cubicTo(6.044f, 0.0f, 0.0f, 6.044f, 0.0f, 13.666667f);
                l.cubicTo(0.0f, 20.956f, 6.044f, 27.0f, 13.333333f, 27.0f);
                l.cubicTo(20.956f, 27.0f, 27.0f, 20.956f, 27.0f, 13.666667f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-1);
                l = C5163c.m7884l(looper);
                l.moveTo(13.5f, 6.0f);
                l.cubicTo(14.334203f, 6.0f, 14.962531f, 6.674437f, 14.916311f, 7.5063977f);
                l.lineTo(14.5f, 15.0f);
                l.lineTo(12.5f, 15.0f);
                l.lineTo(12.083689f, 7.5063977f);
                l.cubicTo(12.037581f, 6.6764627f, 12.671573f, 6.0f, 13.5f, 6.0f);
                l.close();
                l.moveTo(13.5f, 20.0f);
                l.cubicTo(12.671573f, 20.0f, 12.0f, 19.328426f, 12.0f, 18.5f);
                l.cubicTo(12.0f, 17.671574f, 12.671573f, 17.0f, 13.5f, 17.0f);
                l.cubicTo(14.328427f, 17.0f, 15.0f, 17.671574f, 15.0f, 18.5f);
                l.cubicTo(15.0f, 19.328426f, 14.328427f, 20.0f, 13.5f, 20.0f);
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
