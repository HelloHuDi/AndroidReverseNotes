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

/* renamed from: com.tencent.mm.boot.svg.a.a.pk */
public final class C41854pk extends C5163c {
    private final int height = 292;
    private final int width = 378;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 378;
            case 1:
                return 292;
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
                a.setColor(-13092808);
                Path l = C5163c.m7884l(looper);
                l.moveTo(373.0f, 236.0006f);
                l.cubicTo(373.0f, 242.0656f, 368.063f, 247.0006f, 361.993f, 247.0006f);
                l.lineTo(16.007f, 247.0006f);
                l.cubicTo(9.938f, 247.0006f, 5.0f, 242.0656f, 5.0f, 236.0006f);
                l.lineTo(5.0f, 15.9996f);
                l.cubicTo(5.0f, 9.9346f, 9.938f, 5.0006f, 16.007f, 5.0006f);
                l.lineTo(361.993f, 5.0006f);
                l.cubicTo(368.063f, 5.0006f, 373.0f, 9.9346f, 373.0f, 15.9996f);
                l.lineTo(373.0f, 236.0006f);
                l.lineTo(373.0f, 236.0006f);
                l.close();
                l.moveTo(361.993f, 1.9996f);
                l.lineTo(16.007f, 1.9996f);
                l.cubicTo(8.276f, 1.9996f, 2.0f, 8.2676f, 2.0f, 15.9996f);
                l.lineTo(2.0f, 236.0006f);
                l.cubicTo(2.0f, 243.7296f, 8.271f, 249.9996f, 16.007f, 249.9996f);
                l.lineTo(361.993f, 249.9996f);
                l.cubicTo(369.724f, 249.9996f, 376.0f, 243.7326f, 376.0f, 236.0006f);
                l.lineTo(376.0f, 15.9996f);
                l.cubicTo(376.0f, 8.2696f, 369.729f, 1.9996f, 361.993f, 1.9996f);
                l.lineTo(361.993f, 1.9996f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.save();
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(-13092808);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(243.0f, 288.0001f);
                l2.lineTo(134.0f, 288.0001f);
                l2.lineTo(134.0f, 286.5041f);
                l2.lineTo(155.712f, 282.5561f);
                l2.lineTo(159.658f, 250.0001f);
                l2.lineTo(217.342f, 250.0001f);
                l2.lineTo(221.288f, 282.5561f);
                l2.lineTo(243.0f, 286.5041f);
                l2.lineTo(243.0f, 288.0001f);
                l2.close();
                l2.moveTo(220.0f, 247.0001f);
                l2.lineTo(157.0f, 247.0001f);
                l2.lineTo(153.0f, 280.0001f);
                l2.lineTo(131.0f, 284.0001f);
                l2.lineTo(131.0f, 291.0001f);
                l2.lineTo(246.0f, 291.0001f);
                l2.lineTo(246.0f, 284.0001f);
                l2.lineTo(224.0f, 280.0001f);
                l2.lineTo(220.0f, 247.0001f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, k2);
                canvas.restore();
                canvas.save();
                k2 = C5163c.m7876a(k, looper);
                k2.setColor(-13092808);
                l2 = C5163c.m7884l(looper);
                l2.moveTo(4.0f, 201.0f);
                l2.lineTo(376.0f, 201.0f);
                l2.lineTo(376.0f, 198.0f);
                l2.lineTo(4.0f, 198.0f);
                l2.close();
                WeChatSVGRenderC2Java.setFillType(l2, 1);
                WeChatSVGRenderC2Java.setFillType(l2, 2);
                canvas.drawPath(l2, k2);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
