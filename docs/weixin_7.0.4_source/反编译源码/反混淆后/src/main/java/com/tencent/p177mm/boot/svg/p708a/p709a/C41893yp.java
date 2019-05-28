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

/* renamed from: com.tencent.mm.boot.svg.a.a.yp */
public final class C41893yp extends C5163c {
    private final int height = 61;
    private final int width = 61;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 61;
            case 1:
                return 61;
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
                a.setColor(-10970130);
                Path l = C5163c.m7884l(looper);
                l.moveTo(24.357143f, 31.267857f);
                l.cubicTo(26.82522f, 35.67271f, 22.368435f, 37.603485f, 20.517857f, 38.94643f);
                l.cubicTo(12.49915f, 43.23181f, 9.0f, 44.938072f, 9.0f, 46.625f);
                l.lineTo(9.0f, 50.464287f);
                l.cubicTo(9.0f, 51.156628f, 9.728162f, 52.0f, 10.535714f, 52.0f);
                l.lineTo(50.464287f, 52.0f);
                l.cubicTo(51.27184f, 52.0f, 52.0f, 51.156628f, 52.0f, 50.464287f);
                l.lineTo(52.0f, 46.625f);
                l.cubicTo(52.0f, 44.938072f, 48.50085f, 43.23181f, 40.482143f, 38.94643f);
                l.cubicTo(38.631565f, 37.603485f, 34.17478f, 35.67271f, 36.642857f, 31.267857f);
                l.cubicTo(39.24307f, 27.868282f, 41.103214f, 26.426222f, 41.25f, 20.517857f);
                l.cubicTo(41.103214f, 14.887795f, 36.947693f, 9.0f, 30.5f, 9.0f);
                l.cubicTo(24.052307f, 9.0f, 19.896786f, 14.887795f, 19.75f, 20.517857f);
                l.cubicTo(19.896786f, 26.426222f, 21.756931f, 27.868282f, 24.357143f, 31.267857f);
                l.close();
                l.moveTo(30.714453f, 42.92168f);
                l.cubicTo(26.309618f, 42.92168f, 23.007446f, 38.011597f, 23.007446f, 38.011597f);
                l.cubicTo(23.007446f, 38.011597f, 24.622948f, 50.719337f, 30.714453f, 50.719337f);
                l.cubicTo(36.805958f, 50.719337f, 38.079346f, 38.011597f, 38.079346f, 38.011597f);
                l.cubicTo(38.079346f, 38.011597f, 35.11929f, 42.92168f, 30.714453f, 42.92168f);
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
