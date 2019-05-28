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

/* renamed from: com.tencent.mm.boot.svg.a.a.acq */
public final class acq extends C5163c {
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
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-436207616);
                Path l = C5163c.m7884l(looper);
                l.moveTo(14.8f, 9.0f);
                l.lineTo(14.8f, 6.0f);
                l.cubicTo(14.8f, 3.790861f, 16.59086f, 2.0f, 18.8f, 2.0f);
                l.cubicTo(21.009138f, 2.0f, 22.8f, 3.7908611f, 22.8f, 6.0f);
                l.lineTo(22.8f, 9.0f);
                l.lineTo(21.599998f, 9.0f);
                l.lineTo(21.599998f, 6.0f);
                l.cubicTo(21.599997f, 4.4535995f, 20.346394f, 3.199997f, 18.799995f, 3.199997f);
                l.cubicTo(17.253597f, 3.199997f, 15.999995f, 4.4535995f, 15.999995f, 5.999997f);
                l.lineTo(15.999998f, 9.0f);
                l.lineTo(18.999126f, 9.0f);
                l.cubicTo(19.551893f, 9.0f, 19.999998f, 9.44749f, 19.999998f, 9.998503f);
                l.lineTo(19.999998f, 21.0015f);
                l.cubicTo(19.999998f, 21.552958f, 19.555367f, 22.000002f, 18.999126f, 22.000002f);
                l.lineTo(5.0008698f, 22.000002f);
                l.cubicTo(4.4481034f, 22.000002f, 3.999998f, 21.552513f, 3.999998f, 21.0015f);
                l.lineTo(3.999998f, 9.998504f);
                l.cubicTo(3.999998f, 9.447046f, 4.4446287f, 9.000001f, 5.0008698f, 9.000001f);
                l.close();
                l.moveTo(5.2f, 10.2f);
                l.lineTo(5.2f, 20.8f);
                l.lineTo(18.8f, 20.8f);
                l.lineTo(18.8f, 10.199999f);
                l.close();
                l.moveTo(11.4f, 15.875187f);
                l.cubicTo(10.870229f, 15.64372f, 10.5f, 15.115096f, 10.5f, 14.5f);
                l.cubicTo(10.5f, 13.671573f, 11.171573f, 13.0f, 12.0f, 13.0f);
                l.cubicTo(12.828427f, 13.0f, 13.5f, 13.671573f, 13.5f, 14.5f);
                l.cubicTo(13.5f, 15.115096f, 13.129771f, 15.643721f, 12.599999f, 15.875187f);
                l.lineTo(12.599999f, 18.0f);
                l.lineTo(11.4f, 18.0f);
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
