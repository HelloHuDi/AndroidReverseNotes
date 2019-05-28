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

/* renamed from: com.tencent.mm.boot.svg.a.a.ra */
public final class C32392ra extends C5163c {
    private final int height = 480;
    private final int width = 480;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 480;
            case 1:
                return 480;
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
                k2.setColor(-16337763);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(480.0f, 0.0f);
                l.lineTo(480.0f, 480.0f);
                l.lineTo(0.0f, 480.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(110.0f, 114.0f);
                l2.cubicTo(110.0f, 111.79086f, 111.79086f, 110.0f, 114.0f, 110.0f);
                l2.lineTo(366.0f, 110.0f);
                l2.cubicTo(368.20914f, 110.0f, 370.0f, 111.79086f, 370.0f, 114.0f);
                l2.lineTo(370.0f, 366.0f);
                l2.cubicTo(370.0f, 368.20914f, 368.20914f, 370.0f, 366.0f, 370.0f);
                l2.lineTo(114.0f, 370.0f);
                l2.cubicTo(111.79086f, 370.0f, 110.0f, 368.20914f, 110.0f, 366.0f);
                l2.lineTo(110.0f, 114.0f);
                l2.close();
                canvas.drawPath(l2, a);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(k, looper);
                a.setColor(-16337763);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(240.0f, 156.0f);
                l2.cubicTo(262.0914f, 156.0f, 280.0f, 173.90862f, 280.0f, 196.0f);
                l2.cubicTo(280.0f, 218.09138f, 262.0914f, 236.0f, 240.0f, 236.0f);
                l2.cubicTo(217.90862f, 236.0f, 200.0f, 218.09138f, 200.0f, 196.0f);
                l2.cubicTo(200.0f, 173.90862f, 217.90862f, 156.0f, 240.0f, 156.0f);
                l2.close();
                canvas.drawPath(l2, a);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(k, looper);
                a.setColor(-16337763);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(191.0f, 244.0f);
                l2.cubicTo(213.09138f, 244.0f, 231.0f, 261.9086f, 231.0f, 284.0f);
                l2.cubicTo(231.0f, 306.0914f, 213.09138f, 324.0f, 191.0f, 324.0f);
                l2.cubicTo(168.90862f, 324.0f, 151.0f, 306.0914f, 151.0f, 284.0f);
                l2.cubicTo(151.0f, 261.9086f, 168.90862f, 244.0f, 191.0f, 244.0f);
                l2.close();
                canvas.drawPath(l2, a);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-16337763);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(289.0f, 324.0f);
                l2.cubicTo(311.0914f, 324.0f, 329.0f, 306.0914f, 329.0f, 284.0f);
                l2.cubicTo(329.0f, 261.9086f, 311.0914f, 244.0f, 289.0f, 244.0f);
                l2.cubicTo(266.9086f, 244.0f, 249.0f, 261.9086f, 249.0f, 284.0f);
                l2.cubicTo(249.0f, 306.0914f, 266.9086f, 324.0f, 289.0f, 324.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, k);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
