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

/* renamed from: com.tencent.mm.boot.svg.a.a.ok */
public final class C9141ok extends C5163c {
    private final int height = 60;
    private final int width = 60;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(60.0f, 0.0f);
                l.lineTo(60.0f, 60.0f);
                l.lineTo(0.0f, 60.0f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                k = C5163c.m7876a(k, looper);
                k.setColor(-1);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(6.0f, 12.0f);
                l2.cubicTo(6.0f, 8.689151f, 8.683541f, 6.0f, 12.0f, 6.0f);
                l2.lineTo(48.0f, 6.0f);
                l2.cubicTo(51.31085f, 6.0f, 54.0f, 8.683541f, 54.0f, 12.0f);
                l2.lineTo(54.0f, 48.0f);
                l2.cubicTo(54.0f, 51.31085f, 51.31646f, 54.0f, 48.0f, 54.0f);
                l2.lineTo(12.0f, 54.0f);
                l2.cubicTo(8.689151f, 54.0f, 6.0f, 51.31646f, 6.0f, 48.0f);
                l2.lineTo(6.0f, 12.0f);
                l2.lineTo(6.0f, 12.0f);
                l2.close();
                l2.moveTo(9.0f, 11.0f);
                l2.cubicTo(9.0f, 9.938929f, 9.936117f, 9.0f, 11.0f, 9.0f);
                l2.lineTo(49.0f, 9.0f);
                l2.cubicTo(50.06107f, 9.0f, 51.0f, 9.936117f, 51.0f, 11.0f);
                l2.lineTo(51.0f, 49.0f);
                l2.cubicTo(51.0f, 50.06107f, 50.063885f, 51.0f, 49.0f, 51.0f);
                l2.lineTo(11.0f, 51.0f);
                l2.cubicTo(9.938929f, 51.0f, 9.0f, 50.063885f, 9.0f, 49.0f);
                l2.lineTo(9.0f, 11.0f);
                l2.lineTo(9.0f, 11.0f);
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
