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

/* renamed from: com.tencent.mm.boot.svg.a.a.asw */
public final class asw extends C5163c {
    private final int height = 120;
    private final int width = 120;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 120;
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
                a.setColor(1711276032);
                Path l = C5163c.m7884l(looper);
                l.moveTo(60.0f, 0.0f);
                l.cubicTo(93.137085f, 0.0f, 120.0f, 26.862915f, 120.0f, 60.0f);
                l.cubicTo(120.0f, 93.137085f, 93.137085f, 120.0f, 60.0f, 120.0f);
                l.cubicTo(26.862915f, 120.0f, 0.0f, 93.137085f, 0.0f, 60.0f);
                l.cubicTo(0.0f, 26.862915f, 26.862915f, 0.0f, 60.0f, 0.0f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                l = C5163c.m7884l(looper);
                l.moveTo(60.0f, 117.0f);
                l.cubicTo(91.48023f, 117.0f, 117.0f, 91.48023f, 117.0f, 60.0f);
                l.cubicTo(117.0f, 28.51977f, 91.48023f, 3.0f, 60.0f, 3.0f);
                l.cubicTo(28.51977f, 3.0f, 3.0f, 28.51977f, 3.0f, 60.0f);
                l.cubicTo(3.0f, 91.48023f, 28.51977f, 117.0f, 60.0f, 117.0f);
                l.close();
                l.moveTo(60.0f, 120.0f);
                l.cubicTo(26.862915f, 120.0f, 0.0f, 93.137085f, 0.0f, 60.0f);
                l.cubicTo(0.0f, 26.862915f, 26.862915f, 0.0f, 60.0f, 0.0f);
                l.cubicTo(93.137085f, 0.0f, 120.0f, 26.862915f, 120.0f, 60.0f);
                l.cubicTo(120.0f, 93.137085f, 93.137085f, 120.0f, 60.0f, 120.0f);
                l.close();
                canvas.saveLayerAlpha(null, 204, 4);
                Paint a2 = C5163c.m7876a(a, looper);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                k = C5163c.m7876a(k, looper);
                k.setColor(-1);
                l = C5163c.m7884l(looper);
                l.moveTo(46.5f, 38.223152f);
                l.cubicTo(46.5f, 36.562f, 47.656143f, 35.89766f, 49.079807f, 36.73782f);
                l.lineTo(85.92019f, 58.478794f);
                l.cubicTo(87.34498f, 59.31962f, 87.34386f, 60.68353f, 85.92019f, 61.52369f);
                l.lineTo(49.079807f, 83.26466f);
                l.cubicTo(47.655018f, 84.10549f, 46.5f, 83.43548f, 46.5f, 81.779335f);
                l.lineTo(46.5f, 38.223152f);
                l.close();
                canvas.saveLayerAlpha(null, 204, 4);
                a2 = C5163c.m7876a(k, looper);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
