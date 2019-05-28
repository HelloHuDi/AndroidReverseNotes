package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.aan */
public final class aan extends C5163c {
    private final int height = 32;
    private final int width = 32;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 32;
            case 1:
                return 32;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix h = C5163c.m7881h(looper);
                float[] g = C5163c.m7880g(looper);
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
                a.setColor(WebView.NIGHT_MODE_COLOR);
                g = C5163c.m7878a(g, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 2.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 2.333333f, 0.0f, 1.0f, 2.333333f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(11.666667f, 21.933332f);
                l.cubicTo(17.33679f, 21.933332f, 21.933332f, 17.33679f, 21.933332f, 11.666667f);
                l.cubicTo(21.933332f, 5.9965434f, 17.33679f, 1.4f, 11.666667f, 1.4f);
                l.cubicTo(5.9965434f, 1.4f, 1.4f, 5.9965434f, 1.4f, 11.666667f);
                l.cubicTo(1.4f, 17.33679f, 5.9965434f, 21.933332f, 11.666667f, 21.933332f);
                l.close();
                l.moveTo(11.666667f, 23.333334f);
                l.cubicTo(5.223345f, 23.333334f, 0.0f, 18.10999f, 0.0f, 11.666667f);
                l.cubicTo(0.0f, 5.223345f, 5.223345f, 0.0f, 11.666667f, 0.0f);
                l.cubicTo(18.10999f, 0.0f, 23.333334f, 5.223345f, 23.333334f, 11.666667f);
                l.cubicTo(23.333334f, 18.10999f, 18.10999f, 23.333334f, 11.666667f, 23.333334f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(11.666667f, 17.85f);
                l.cubicTo(14.276042f, 17.85f, 16.468582f, 16.065317f, 17.090242f, 13.65f);
                l.lineTo(6.243091f, 13.65f);
                l.cubicTo(6.864751f, 16.065317f, 9.057291f, 17.85f, 11.666667f, 17.85f);
                l.close();
                l.moveTo(4.6666665f, 12.25f);
                l.lineTo(18.666666f, 12.25f);
                l.cubicTo(18.666666f, 16.115993f, 15.53266f, 19.25f, 11.666667f, 19.25f);
                l.cubicTo(7.8006735f, 19.25f, 4.6666665f, 16.115993f, 4.6666665f, 12.25f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a2 = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(7.5833335f, 9.916667f);
                l.cubicTo(6.616835f, 9.916667f, 5.8333335f, 9.133165f, 5.8333335f, 8.166667f);
                l.cubicTo(5.8333335f, 7.200168f, 6.616835f, 6.4166665f, 7.5833335f, 6.4166665f);
                l.cubicTo(8.549831f, 6.4166665f, 9.333333f, 7.200168f, 9.333333f, 8.166667f);
                l.cubicTo(9.333333f, 9.133165f, 8.549831f, 9.916667f, 7.5833335f, 9.916667f);
                l.close();
                l.moveTo(15.75f, 9.916667f);
                l.cubicTo(14.783502f, 9.916667f, 14.0f, 9.133165f, 14.0f, 8.166667f);
                l.cubicTo(14.0f, 7.200168f, 14.783502f, 6.4166665f, 15.75f, 6.4166665f);
                l.cubicTo(16.716497f, 6.4166665f, 17.5f, 7.200168f, 17.5f, 8.166667f);
                l.cubicTo(17.5f, 9.133165f, 16.716497f, 9.916667f, 15.75f, 9.916667f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
