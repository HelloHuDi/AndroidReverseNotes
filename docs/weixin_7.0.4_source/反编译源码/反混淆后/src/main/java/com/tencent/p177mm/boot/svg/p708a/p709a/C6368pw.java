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

/* renamed from: com.tencent.mm.boot.svg.a.a.pw */
public final class C6368pw extends C5163c {
    private final int height = 240;
    private final int width = 240;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 240;
            case 1:
                return 240;
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
                a.setColor(-16139513);
                Path l = C5163c.m7884l(looper);
                l.moveTo(213.0f, 121.14815f);
                l.cubicTo(213.0f, 68.636444f, 171.36356f, 27.0f, 118.85185f, 27.0f);
                l.cubicTo(68.636444f, 27.0f, 27.0f, 68.636444f, 27.0f, 121.14815f);
                l.cubicTo(27.0f, 171.36356f, 68.636444f, 213.0f, 118.85185f, 213.0f);
                l.cubicTo(171.36356f, 213.0f, 213.0f, 171.36356f, 213.0f, 121.14815f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(-1);
                l = C5163c.m7884l(looper);
                l.moveTo(73.845436f, 126.13097f);
                l.cubicTo(73.46136f, 125.73346f, 73.40951f, 125.05811f, 73.74635f, 124.59977f);
                l.lineTo(77.93406f, 118.90164f);
                l.cubicTo(78.26342f, 118.45349f, 78.884964f, 118.36194f, 79.323456f, 118.69801f);
                l.lineTo(104.235695f, 137.79182f);
                l.cubicTo(104.67368f, 138.1275f, 105.378365f, 138.10837f, 105.79235f, 137.76349f);
                l.lineTo(166.43353f, 87.244484f);
                l.cubicTo(166.85526f, 86.89315f, 167.5176f, 86.92481f, 167.91162f, 87.31395f);
                l.lineTo(171.86308f, 91.2164f);
                l.cubicTo(172.25768f, 91.6061f, 172.26135f, 92.23321f, 171.86464f, 92.623634f);
                l.lineTo(105.73968f, 157.70047f);
                l.cubicTo(105.34595f, 158.08797f, 104.711266f, 158.07556f, 104.33132f, 157.68234f);
                l.lineTo(73.845436f, 126.13097f);
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
