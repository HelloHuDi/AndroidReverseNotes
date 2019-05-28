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

/* renamed from: com.tencent.mm.boot.svg.a.a.aai */
public final class aai extends C5163c {
    private final int height = 24;
    private final int width = 24;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.save();
                g = C5163c.m7878a(g, 1.0f, 0.0f, 3.0f, 0.0f, 1.0f, 3.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(3.0f, 0.0f);
                l.lineTo(15.0f, 0.0f);
                l.cubicTo(16.656855f, -3.043592E-16f, 18.0f, 1.3431457f, 18.0f, 3.0f);
                l.lineTo(18.0f, 15.0f);
                l.cubicTo(18.0f, 16.656855f, 16.656855f, 18.0f, 15.0f, 18.0f);
                l.lineTo(3.0f, 18.0f);
                l.cubicTo(1.3431457f, 18.0f, -6.852723E-16f, 16.656855f, -8.881784E-16f, 15.0f);
                l.lineTo(0.0f, 3.0f);
                l.cubicTo(-2.0290612E-16f, 1.3431457f, 1.3431457f, -5.838192E-16f, 3.0f, -8.881784E-16f);
                l.close();
                l.moveTo(9.0f, 12.857142f);
                l.lineTo(11.811378f, 14.335172f);
                l.cubicTo(11.957373f, 14.411925f, 12.1245985f, 14.438412f, 12.287167f, 14.410529f);
                l.cubicTo(12.695419f, 14.340508f, 12.96961f, 13.952791f, 12.89959f, 13.544539f);
                l.lineTo(12.362664f, 10.414024f);
                l.lineTo(14.637116f, 8.196981f);
                l.cubicTo(14.755229f, 8.08185f, 14.832094f, 7.9309936f, 14.855813f, 7.7677655f);
                l.cubicTo(14.915376f, 7.3578568f, 14.631365f, 6.977275f, 14.221457f, 6.9177117f);
                l.lineTo(11.07824f, 6.4609756f);
                l.lineTo(9.672552f, 3.6127393f);
                l.cubicTo(9.599554f, 3.46483f, 9.479834f, 3.3451092f, 9.331924f, 3.2721117f);
                l.cubicTo(8.9604845f, 3.0887947f, 8.510765f, 3.2412992f, 8.327448f, 3.6127393f);
                l.lineTo(6.921759f, 6.4609756f);
                l.lineTo(3.778544f, 6.9177117f);
                l.cubicTo(3.6153162f, 6.94143f, 3.4644594f, 7.0182953f, 3.3493278f, 7.136408f);
                l.cubicTo(3.060202f, 7.4330206f, 3.066271f, 7.9078555f, 3.3628838f, 8.196981f);
                l.lineTo(5.637336f, 10.414024f);
                l.lineTo(5.1004105f, 13.544539f);
                l.cubicTo(5.072528f, 13.707108f, 5.099014f, 13.874333f, 5.1757684f, 14.0203285f);
                l.cubicTo(5.368519f, 14.386962f, 5.821989f, 14.527922f, 6.1886225f, 14.335172f);
                l.lineTo(9.0f, 12.857142f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
