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

/* renamed from: com.tencent.mm.boot.svg.a.a.wj */
public final class C45258wj extends C5163c {
    private final int height = 32;
    private final int width = 33;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 33;
            case 1:
                return 32;
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
                k.setColor(-4547478);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(9.0f, 0.0f);
                l.cubicTo(4.4698386f, 0.0f, 1.2866651E-7f, 4.280687f, 0.0f, 12.0f);
                l.cubicTo(-1.2866651E-7f, 19.4983f, 7.829132f, 28.649586f, 16.5f, 31.5f);
                l.cubicTo(25.447317f, 28.649586f, 33.0f, 19.289865f, 33.0f, 12.0f);
                l.cubicTo(33.0f, 4.0722513f, 28.71333f, 1.0442231E-7f, 24.0f, 0.0f);
                l.cubicTo(19.675785f, -9.371384E-8f, 17.939146f, 1.5439653f, 16.5f, 3.0f);
                l.cubicTo(15.07374f, 1.5439653f, 12.953914f, 0.0f, 9.0f, 0.0f);
                l.close();
                l.moveTo(9.965287f, 4.0f);
                l.cubicTo(7.320104f, 4.0f, 4.0f, 6.7830515f, 4.0f, 11.904762f);
                l.cubicTo(4.0f, 17.026472f, 9.405654f, 24.647278f, 16.5f, 27.0f);
                l.cubicTo(23.820532f, 24.647278f, 29.0f, 15.826896f, 29.0f, 11.904762f);
                l.cubicTo(29.0f, 7.982628f, 26.492723f, 4.0f, 22.636364f, 4.0f);
                l.cubicTo(19.09837f, 4.0f, 17.274794f, 7.6027136f, 16.5f, 9.0f);
                l.cubicTo(15.76442f, 7.6027136f, 12.610471f, 4.0f, 9.965287f, 4.0f);
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
