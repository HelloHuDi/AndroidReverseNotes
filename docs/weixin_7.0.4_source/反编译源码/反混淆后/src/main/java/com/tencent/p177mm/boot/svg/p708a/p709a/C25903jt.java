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

/* renamed from: com.tencent.mm.boot.svg.a.a.jt */
public final class C25903jt extends C5163c {
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
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(79.0f, 54.0f);
                l.cubicTo(78.25857f, 56.12818f, 77.36423f, 57.0f, 75.0f, 57.0f);
                l.lineTo(41.0f, 57.0f);
                l.cubicTo(38.447094f, 57.0f, 36.622643f, 55.168636f, 37.0f, 53.0f);
                l.lineTo(33.0f, 32.0f);
                l.lineTo(81.0f, 39.0f);
                l.cubicTo(81.0f, 38.81818f, 79.41102f, 50.549545f, 79.0f, 54.0f);
                l.lineTo(79.0f, 54.0f);
                l.close();
                l.moveTo(31.0f, 24.0f);
                l.lineTo(30.0f, 14.0f);
                l.lineTo(30.0f, 14.0f);
                l.cubicTo(29.09645f, 10.765857f, 26.07245f, 8.0f, 22.0f, 8.0f);
                l.lineTo(8.0f, 8.0f);
                l.lineTo(8.0f, 16.0f);
                l.lineTo(12.0f, 16.0f);
                l.lineTo(15.0f, 16.0f);
                l.lineTo(20.0f, 16.0f);
                l.cubicTo(20.94245f, 16.142857f, 21.95f, 17.155739f, 22.0f, 18.0f);
                l.lineTo(22.0f, 18.0f);
                l.lineTo(29.0f, 56.0f);
                l.lineTo(29.0f, 56.0f);
                l.cubicTo(30.31235f, 61.371452f, 34.9343f, 65.0f, 40.0f, 65.0f);
                l.lineTo(77.0f, 65.0f);
                l.cubicTo(82.3562f, 65.0f, 84.95f, 60.92857f, 85.0f, 57.0f);
                l.cubicTo(85.6574f, 54.530094f, 89.0f, 32.42857f, 89.0f, 32.0f);
                l.lineTo(31.0f, 24.0f);
                l.close();
                l.moveTo(77.0f, 73.0f);
                l.cubicTo(72.58178f, 73.0f, 69.0f, 76.58178f, 69.0f, 81.0f);
                l.cubicTo(69.0f, 85.41822f, 72.58178f, 89.0f, 77.0f, 89.0f);
                l.cubicTo(81.41822f, 89.0f, 85.0f, 85.41822f, 85.0f, 81.0f);
                l.cubicTo(85.0f, 76.58178f, 81.41822f, 73.0f, 77.0f, 73.0f);
                l.lineTo(77.0f, 73.0f);
                l.close();
                l.moveTo(36.0f, 73.0f);
                l.cubicTo(31.581778f, 73.0f, 28.0f, 76.58178f, 28.0f, 81.0f);
                l.cubicTo(28.0f, 85.41822f, 31.581778f, 89.0f, 36.0f, 89.0f);
                l.cubicTo(40.41822f, 89.0f, 44.0f, 85.41822f, 44.0f, 81.0f);
                l.cubicTo(44.0f, 76.58178f, 40.41822f, 73.0f, 36.0f, 73.0f);
                l.lineTo(36.0f, 73.0f);
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
