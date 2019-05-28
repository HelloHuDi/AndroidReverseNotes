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

/* renamed from: com.tencent.mm.boot.svg.a.a.bw */
public final class C37524bw extends C5163c {
    private final int height = 180;
    private final int width = 180;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 180;
            case 1:
                return 180;
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
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(-13917627);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(180.0f, 0.0f);
                l.lineTo(180.0f, 180.0f);
                l.lineTo(0.0f, 180.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(49.799175f, 34.8f);
                l2.cubicTo(48.142776f, 34.8f, 46.8f, 36.136326f, 46.8f, 37.79583f);
                l2.lineTo(46.8f, 142.20418f);
                l2.cubicTo(46.8f, 143.85872f, 48.139797f, 145.2f, 49.799175f, 145.2f);
                l2.lineTo(130.20082f, 145.2f);
                l2.cubicTo(131.85722f, 145.2f, 133.2f, 143.86368f, 133.2f, 142.20418f);
                l2.lineTo(133.2f, 37.79583f);
                l2.cubicTo(133.2f, 36.141277f, 131.8602f, 34.8f, 130.20082f, 34.8f);
                l2.lineTo(49.799175f, 34.8f);
                l2.close();
                l2.moveTo(88.8f, 84.0f);
                l2.lineTo(88.8f, 90.0f);
                l2.lineTo(57.6f, 90.0f);
                l2.lineTo(57.6f, 84.0f);
                l2.lineTo(88.8f, 84.0f);
                l2.close();
                l2.moveTo(108.0f, 67.2f);
                l2.lineTo(108.0f, 73.2f);
                l2.lineTo(57.6f, 73.2f);
                l2.lineTo(57.6f, 67.2f);
                l2.lineTo(108.0f, 67.2f);
                l2.close();
                l2.moveTo(122.4f, 51.6f);
                l2.lineTo(122.4f, 57.6f);
                l2.lineTo(57.6f, 57.6f);
                l2.lineTo(57.6f, 51.6f);
                l2.lineTo(122.4f, 51.6f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
