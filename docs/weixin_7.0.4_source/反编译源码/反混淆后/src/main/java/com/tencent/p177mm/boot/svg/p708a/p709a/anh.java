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

/* renamed from: com.tencent.mm.boot.svg.a.a.anh */
public final class anh extends C5163c {
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
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(16.0f, 29.0f);
                l.cubicTo(17.726973f, 27.70042f, 19.455055f, 28.159777f, 21.0f, 28.0f);
                l.cubicTo(34.0089f, 28.089874f, 47.05442f, 27.920113f, 60.0f, 28.0f);
                l.cubicTo(62.067753f, 27.960056f, 63.226467f, 30.137007f, 63.0f, 32.0f);
                l.cubicTo(62.976746f, 42.61952f, 62.966755f, 53.34449f, 63.0f, 64.0f);
                l.cubicTo(63.246445f, 65.83699f, 62.057766f, 68.023926f, 60.0f, 68.0f);
                l.cubicTo(46.335217f, 68.023926f, 32.600464f, 67.94404f, 19.0f, 68.0f);
                l.cubicTo(17.10766f, 68.2536f, 14.970034f, 67.06527f, 15.0f, 65.0f);
                l.cubicTo(14.920089f, 54.383034f, 15.0899f, 43.678036f, 15.0f, 33.0f);
                l.cubicTo(15.059934f, 31.435186f, 14.790233f, 29.447971f, 16.0f, 29.0f);
                l.lineTo(16.0f, 29.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(66.0f, 41.0f);
                l.cubicTo(71.03873f, 37.01664f, 75.738205f, 32.185577f, 81.0f, 28.0f);
                l.cubicTo(82.33345f, 30.067574f, 81.93434f, 32.58901f, 82.0f, 35.0f);
                l.cubicTo(81.94432f, 44.71205f, 81.97425f, 54.505295f, 82.0f, 64.0f);
                l.cubicTo(82.00419f, 65.62985f, 81.66495f, 66.86031f, 81.0f, 68.0f);
                l.cubicTo(75.718254f, 63.82451f, 71.01877f, 58.993443f, 66.0f, 55.0f);
                l.lineTo(66.0f, 41.0f);
                l.lineTo(66.0f, 41.0f);
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
