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

/* renamed from: com.tencent.mm.boot.svg.a.a.azx */
public final class azx extends C5163c {
    private final int height = 72;
    private final int width = 72;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 72;
            case 1:
                return 72;
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
                Paint a = C5163c.m7876a(k2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                Paint a2 = C5163c.m7876a(k, looper);
                a2.setColor(-15028967);
                Path l = C5163c.m7884l(looper);
                l.moveTo(29.278912f, 21.516287f);
                l.lineTo(52.24126f, 35.468605f);
                l.cubicTo(52.949238f, 35.898785f, 53.17444f, 36.82145f, 52.74426f, 37.52943f);
                l.cubicTo(52.61935f, 37.735f, 52.44683f, 37.90752f, 52.24126f, 38.03243f);
                l.lineTo(29.278912f, 51.98475f);
                l.cubicTo(28.57093f, 52.41493f, 27.64827f, 52.189728f, 27.218088f, 51.481747f);
                l.cubicTo(27.07544f, 51.24698f, 27.0f, 50.977547f, 27.0f, 50.702835f);
                l.lineTo(27.0f, 22.798197f);
                l.cubicTo(27.0f, 21.96977f, 27.671574f, 21.298197f, 28.5f, 21.298197f);
                l.cubicTo(28.77471f, 21.298197f, 29.044144f, 21.373636f, 29.278912f, 21.516287f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.save();
                a = C5163c.m7876a(a, looper);
                a.setColor(-15028967);
                a.setStrokeWidth(3.6f);
                l = C5163c.m7884l(looper);
                l.moveTo(36.0f, 1.7999992f);
                l.cubicTo(54.888138f, 1.7999992f, 70.2f, 17.11186f, 70.2f, 36.0f);
                l.cubicTo(70.2f, 54.888138f, 54.888138f, 70.2f, 36.0f, 70.2f);
                l.cubicTo(17.11186f, 70.2f, 1.7999992f, 54.888138f, 1.7999992f, 36.0f);
                l.cubicTo(1.7999992f, 17.11186f, 17.11186f, 1.7999992f, 36.0f, 1.7999992f);
                l.close();
                canvas.drawPath(l, a);
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
