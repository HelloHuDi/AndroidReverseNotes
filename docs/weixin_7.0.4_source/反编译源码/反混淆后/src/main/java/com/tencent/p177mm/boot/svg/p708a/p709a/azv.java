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

/* renamed from: com.tencent.mm.boot.svg.a.a.azv */
public final class azv extends C5163c {
    private final int height = 70;
    private final int width = 120;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 70;
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
                canvas.saveLayerAlpha(null, XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION, 4);
                k = C5163c.m7876a(k, looper);
                k.setColor(-9473160);
                k.setStrokeWidth(5.0f);
                canvas.save();
                k = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(24.0f, 17.0f);
                l.lineTo(60.0f, 53.0f);
                l.lineTo(96.0f, 17.0f);
                WeChatSVGRenderC2Java.setFillType(l, 1);
                canvas.drawPath(l, k);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
