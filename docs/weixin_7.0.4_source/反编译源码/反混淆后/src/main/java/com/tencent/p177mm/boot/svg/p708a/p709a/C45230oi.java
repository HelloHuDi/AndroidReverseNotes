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

/* renamed from: com.tencent.mm.boot.svg.a.a.oi */
public final class C45230oi extends C5163c {
    private final int height = 60;
    private final int width = 60;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(60.0f, 0.0f);
                l.lineTo(60.0f, 60.0f);
                l.lineTo(0.0f, 60.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                l = C5163c.m7884l(looper);
                l.moveTo(9.0f, 14.380721f);
                l.cubicTo(9.0f, 11.409031f, 11.404006f, 9.0f, 14.380721f, 9.0f);
                l.lineTo(46.619278f, 9.0f);
                l.cubicTo(49.59097f, 9.0f, 52.0f, 11.404006f, 52.0f, 14.380721f);
                l.lineTo(52.0f, 46.619278f);
                l.cubicTo(52.0f, 49.59097f, 49.595993f, 52.0f, 46.619278f, 52.0f);
                l.lineTo(14.380721f, 52.0f);
                l.cubicTo(11.409031f, 52.0f, 9.0f, 49.595993f, 9.0f, 46.619278f);
                l.lineTo(9.0f, 14.380721f);
                l.lineTo(9.0f, 14.380721f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-964550);
                l = C5163c.m7884l(looper);
                l.moveTo(6.0f, 12.006387f);
                l.cubicTo(6.0f, 8.689151f, 8.683541f, 6.0f, 12.006387f, 6.0f);
                l.lineTo(47.993614f, 6.0f);
                l.cubicTo(51.31085f, 6.0f, 54.0f, 8.683541f, 54.0f, 12.006387f);
                l.lineTo(54.0f, 47.993614f);
                l.cubicTo(54.0f, 51.31085f, 51.31646f, 54.0f, 47.993614f, 54.0f);
                l.lineTo(12.006387f, 54.0f);
                l.cubicTo(8.689151f, 54.0f, 6.0f, 51.31646f, 6.0f, 47.993614f);
                l.lineTo(6.0f, 12.006387f);
                l.lineTo(6.0f, 12.006387f);
                l.close();
                l.moveTo(12.0f, 32.576923f);
                l.lineTo(16.2f, 28.538462f);
                l.lineTo(25.0f, 36.923077f);
                l.lineTo(43.8f, 19.0f);
                l.lineTo(48.0f, 23.038462f);
                l.lineTo(25.0f, 45.0f);
                l.lineTo(12.0f, 32.576923f);
                l.lineTo(12.0f, 32.576923f);
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
