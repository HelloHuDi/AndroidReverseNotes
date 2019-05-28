package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.acp */
public final class acp extends C5163c {
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
                k = C5163c.m7876a(k2, looper);
                k.setStrokeWidth(1.0f);
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                a.setStrokeWidth(1.125f);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(3.5625f, 6.5625f);
                l.cubicTo(3.5625f, 4.9056454f, 4.9056454f, 3.5625f, 6.5625f, 3.5625f);
                l.lineTo(17.4375f, 3.5625f);
                l.cubicTo(19.094355f, 3.5625f, 20.4375f, 4.9056454f, 20.4375f, 6.5625f);
                l.lineTo(20.4375f, 17.4375f);
                l.cubicTo(20.4375f, 19.094355f, 19.094355f, 20.4375f, 17.4375f, 20.4375f);
                l.lineTo(6.5625f, 20.4375f);
                l.cubicTo(4.9056454f, 20.4375f, 3.5625f, 19.094355f, 3.5625f, 17.4375f);
                l.lineTo(3.5625f, 6.5625f);
                l.close();
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(a, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(12.0000105f, 15.584204f);
                l.lineTo(9.245821f, 17.032167f);
                l.cubicTo(8.957653f, 17.183666f, 8.601233f, 17.072874f, 8.449733f, 16.784706f);
                l.cubicTo(8.389405f, 16.669954f, 8.3685875f, 16.538517f, 8.390503f, 16.410742f);
                l.lineTo(8.916507f, 13.343907f);
                l.lineTo(6.6883206f, 11.171963f);
                l.cubicTo(6.455188f, 10.944715f, 6.4504175f, 10.571502f, 6.6776657f, 10.338368f);
                l.cubicTo(6.7681575f, 10.245533f, 6.886729f, 10.185119f, 7.015023f, 10.166476f);
                l.lineTo(10.0943f, 9.719031f);
                l.lineTo(11.471395f, 6.928733f);
                l.cubicTo(11.6154785f, 6.6367865f, 11.968951f, 6.51692f, 12.260898f, 6.6610045f);
                l.cubicTo(12.377152f, 6.7183795f, 12.4712515f, 6.812478f, 12.528626f, 6.928733f);
                l.lineTo(13.905721f, 9.719031f);
                l.lineTo(16.984997f, 10.166476f);
                l.cubicTo(17.30718f, 10.213292f, 17.530409f, 10.5124235f, 17.483593f, 10.834606f);
                l.cubicTo(17.46495f, 10.9629f, 17.404535f, 11.081471f, 17.3117f, 11.171963f);
                l.lineTo(15.083514f, 13.343907f);
                l.lineTo(15.609518f, 16.410742f);
                l.cubicTo(15.664553f, 16.731623f, 15.449043f, 17.036362f, 15.128163f, 17.091396f);
                l.cubicTo(15.000386f, 17.113312f, 14.86895f, 17.092495f, 14.754199f, 17.032167f);
                l.lineTo(12.0000105f, 15.584204f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
