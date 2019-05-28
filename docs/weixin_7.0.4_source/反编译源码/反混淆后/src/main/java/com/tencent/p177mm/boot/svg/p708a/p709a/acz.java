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
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.mm.boot.svg.a.a.acz */
public final class acz extends C5163c {
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
                C5163c.m7876a(k2, looper).setStrokeWidth(1.0f);
                k = C5163c.m7876a(k, looper);
                k.setColor(-1);
                canvas.saveLayerAlpha(null, XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION, 4);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.5f, 0.0f);
                l.lineTo(1.32f, 0.0f);
                l.cubicTo(5.04f, 3.33f, 8.42f, 7.02f, 12.0f, 10.5f);
                l.cubicTo(15.57f, 7.02f, 18.96f, 3.36f, 22.63f, 0.0f);
                l.lineTo(23.38f, 0.0f);
                l.lineTo(23.52f, 0.52f);
                l.lineTo(24.0f, 0.5f);
                l.lineTo(24.0f, 1.32f);
                l.cubicTo(20.67f, 5.04f, 16.98f, 8.42f, 13.5f, 12.0f);
                l.cubicTo(16.99f, 15.56f, 20.63f, 18.96f, 24.0f, 22.63f);
                l.lineTo(24.0f, 23.38f);
                l.lineTo(23.48f, 23.52f);
                l.lineTo(23.5f, 24.0f);
                l.lineTo(22.67f, 24.0f);
                l.cubicTo(18.96f, 20.66f, 15.58f, 16.98f, 12.0f, 13.51f);
                l.cubicTo(8.43f, 16.98f, 5.04f, 20.65f, 1.35f, 24.0f);
                l.lineTo(0.55f, 24.0f);
                l.lineTo(0.56f, 23.47f);
                l.lineTo(0.0f, 23.48f);
                l.lineTo(0.0f, 22.69f);
                l.cubicTo(3.32f, 18.96f, 7.02f, 15.59f, 10.48f, 12.0f);
                l.cubicTo(7.02f, 8.43f, 3.36f, 5.04f, 0.0f, 1.37f);
                l.lineTo(0.0f, 0.62f);
                l.lineTo(0.52f, 0.48f);
                l.lineTo(0.5f, 0.0f);
                l.lineTo(0.5f, 0.0f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
