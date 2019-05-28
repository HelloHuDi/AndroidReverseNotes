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

/* renamed from: com.tencent.mm.boot.svg.a.a.ahg */
public final class ahg extends C5163c {
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
                k.setColor(-16896);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(21.44831f, 69.12264f);
                l.lineTo(46.491844f, 26.187445f);
                l.cubicTo(47.320778f, 24.766298f, 48.675976f, 24.758957f, 49.509193f, 26.187445f);
                l.lineTo(74.55273f, 69.12264f);
                l.cubicTo(75.38166f, 70.54379f, 74.719376f, 71.70915f, 73.063896f, 71.70915f);
                l.lineTo(22.937145f, 71.70915f);
                l.cubicTo(21.285309f, 71.70915f, 20.615093f, 70.55113f, 21.44831f, 69.12264f);
                l.close();
                l.moveTo(46.700405f, 41.400345f);
                l.cubicTo(46.15008f, 41.400345f, 45.72443f, 41.842537f, 45.75011f, 42.39727f);
                l.lineTo(46.46933f, 57.932423f);
                l.lineTo(49.530827f, 57.932423f);
                l.lineTo(50.250046f, 42.39727f);
                l.cubicTo(50.275536f, 41.846684f, 49.83909f, 41.400345f, 49.29975f, 41.400345f);
                l.lineTo(46.700405f, 41.400345f);
                l.close();
                l.moveTo(48.000076f, 65.280014f);
                l.cubicTo(49.268192f, 65.280014f, 50.2962f, 64.252f, 50.2962f, 62.98389f);
                l.cubicTo(50.2962f, 61.715775f, 49.268192f, 60.687767f, 48.000076f, 60.687767f);
                l.cubicTo(46.731964f, 60.687767f, 45.703957f, 61.715775f, 45.703957f, 62.98389f);
                l.cubicTo(45.703957f, 64.252f, 46.731964f, 65.280014f, 48.000076f, 65.280014f);
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
