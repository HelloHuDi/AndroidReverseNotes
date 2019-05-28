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

/* renamed from: com.tencent.mm.boot.svg.a.a.kg */
public final class C18033kg extends C5163c {
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
                k.setColor(-8617851);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(47.0f, 87.98775f);
                l.cubicTo(25.370693f, 87.45702f, 8.0f, 69.75708f, 8.0f, 48.0f);
                l.cubicTo(8.0f, 34.31184f, 14.875527f, 22.229542f, 25.36142f, 15.018275f);
                l.lineTo(31.139889f, 20.796743f);
                l.cubicTo(22.05139f, 26.441599f, 16.0f, 36.51411f, 16.0f, 48.0f);
                l.cubicTo(16.0f, 65.338554f, 29.789598f, 79.456375f, 47.0f, 79.98467f);
                l.lineTo(47.0f, 70.0f);
                l.lineTo(65.0f, 88.0f);
                l.lineTo(47.0f, 88.0f);
                l.lineTo(47.0f, 87.98775f);
                l.close();
                l.moveTo(47.0f, 8.012256f);
                l.cubicTo(47.332344f, 8.004101f, 47.66569f, 8.0f, 48.0f, 8.0f);
                l.cubicTo(70.09139f, 8.0f, 88.0f, 25.90861f, 88.0f, 48.0f);
                l.cubicTo(88.0f, 62.075714f, 80.72963f, 74.45335f, 69.73931f, 81.58246f);
                l.lineTo(63.921238f, 75.76438f);
                l.cubicTo(73.52948f, 70.24273f, 80.0f, 59.877f, 80.0f, 48.0f);
                l.cubicTo(80.0f, 30.326887f, 65.67311f, 16.0f, 48.0f, 16.0f);
                l.cubicTo(47.665443f, 16.0f, 47.332085f, 16.005135f, 47.0f, 16.015327f);
                l.lineTo(47.0f, 26.0f);
                l.lineTo(29.0f, 8.0f);
                l.lineTo(47.0f, 8.0f);
                l.lineTo(47.0f, 8.012256f);
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
