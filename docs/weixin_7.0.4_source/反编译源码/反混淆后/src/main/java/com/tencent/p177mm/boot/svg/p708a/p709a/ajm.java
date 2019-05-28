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

/* renamed from: com.tencent.mm.boot.svg.a.a.ajm */
public final class ajm extends C5163c {
    private final int height = 24;
    private final int width = 120;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
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
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-1);
                Paint a2 = C5163c.m7876a(a, looper);
                a2.setColor(-1);
                Path l = C5163c.m7884l(looper);
                l.moveTo(60.0f, 24.0f);
                l.cubicTo(66.62742f, 24.0f, 72.0f, 18.627417f, 72.0f, 12.0f);
                l.cubicTo(72.0f, 5.372583f, 66.62742f, 0.0f, 60.0f, 0.0f);
                l.cubicTo(53.37258f, 0.0f, 48.0f, 5.372583f, 48.0f, 12.0f);
                l.cubicTo(48.0f, 18.627417f, 53.37258f, 24.0f, 60.0f, 24.0f);
                l.close();
                l.moveTo(12.0f, 24.0f);
                l.cubicTo(18.627417f, 24.0f, 24.0f, 18.627417f, 24.0f, 12.0f);
                l.cubicTo(24.0f, 5.372583f, 18.627417f, 0.0f, 12.0f, 0.0f);
                l.cubicTo(5.372583f, 0.0f, 0.0f, 5.372583f, 0.0f, 12.0f);
                l.cubicTo(0.0f, 18.627417f, 5.372583f, 24.0f, 12.0f, 24.0f);
                l.close();
                l.moveTo(108.0f, 24.0f);
                l.cubicTo(114.62742f, 24.0f, 120.0f, 18.627417f, 120.0f, 12.0f);
                l.cubicTo(120.0f, 5.372583f, 114.62742f, 0.0f, 108.0f, 0.0f);
                l.cubicTo(101.37258f, 0.0f, 96.0f, 5.372583f, 96.0f, 12.0f);
                l.cubicTo(96.0f, 18.627417f, 101.37258f, 24.0f, 108.0f, 24.0f);
                l.close();
                canvas.saveLayerAlpha(null, 76, 4);
                k2 = C5163c.m7876a(a2, looper);
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k2);
                canvas.restore();
                a2 = C5163c.m7876a(a, looper);
                a2.setColor(-1);
                l = C5163c.m7884l(looper);
                l.moveTo(60.0f, 0.0f);
                l.cubicTo(66.62742f, 0.0f, 72.0f, 5.3725824f, 72.0f, 12.0f);
                l.cubicTo(72.0f, 18.627419f, 66.62742f, 24.0f, 60.0f, 24.0f);
                l.cubicTo(53.37258f, 24.0f, 48.0f, 18.627419f, 48.0f, 12.0f);
                l.cubicTo(48.0f, 5.3725824f, 53.37258f, 0.0f, 60.0f, 0.0f);
                l.close();
                canvas.saveLayerAlpha(null, XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION, 4);
                canvas.drawPath(l, C5163c.m7876a(a2, looper));
                canvas.restore();
                a = C5163c.m7876a(a, looper);
                a.setColor(-1);
                l = C5163c.m7884l(looper);
                l.moveTo(12.0f, 0.0f);
                l.cubicTo(18.627419f, 0.0f, 24.0f, 5.3725824f, 24.0f, 12.0f);
                l.cubicTo(24.0f, 18.627419f, 18.627419f, 24.0f, 12.0f, 24.0f);
                l.cubicTo(5.3725824f, 24.0f, 0.0f, 18.627419f, 0.0f, 12.0f);
                l.cubicTo(0.0f, 5.3725824f, 5.3725824f, 0.0f, 12.0f, 0.0f);
                l.close();
                canvas.saveLayerAlpha(null, 76, 4);
                canvas.drawPath(l, C5163c.m7876a(a, looper));
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
