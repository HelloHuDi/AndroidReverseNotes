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

/* renamed from: com.tencent.mm.boot.svg.a.a.agk */
public final class agk extends C5163c {
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
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(-921103);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(120.0f, 0.0f);
                l.lineTo(120.0f, 120.0f);
                l.lineTo(0.0f, 120.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-3552823);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(50.865784f, 61.30489f);
                l2.cubicTo(54.72159f, 67.43002f, 48.319912f, 70.20336f, 45.64623f, 71.743996f);
                l2.cubicTo(34.143787f, 78.28783f, 29.117647f, 80.738686f, 29.117647f, 83.92295f);
                l2.lineTo(29.117647f, 88.272575f);
                l2.cubicTo(29.117647f, 89.670944f, 30.16357f, 90.882355f, 31.727423f, 90.882355f);
                l2.lineTo(88.272575f, 90.882355f);
                l2.cubicTo(89.83643f, 90.882355f, 90.882355f, 89.670944f, 90.882355f, 88.272575f);
                l2.lineTo(90.882355f, 83.92295f);
                l2.cubicTo(90.882355f, 80.738686f, 85.85622f, 78.28783f, 74.35377f, 71.743996f);
                l2.cubicTo(71.680084f, 70.20336f, 65.27841f, 67.43002f, 69.13422f, 61.30489f);
                l2.cubicTo(72.55844f, 56.21983f, 75.23033f, 54.14847f, 75.223694f, 45.64623f);
                l2.cubicTo(75.23033f, 37.574806f, 69.26139f, 29.117647f, 60.434963f, 29.117647f);
                l2.cubicTo(50.73861f, 29.117647f, 44.769665f, 37.574806f, 44.776306f, 45.64623f);
                l2.cubicTo(44.769665f, 54.14847f, 47.44156f, 56.21983f, 50.865784f, 61.30489f);
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
