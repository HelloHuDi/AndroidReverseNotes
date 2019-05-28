package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C27011o;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.asx */
public final class asx extends C5163c {
    private final int height = C27011o.CTRL_INDEX;
    private final int width = C27011o.CTRL_INDEX;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return C27011o.CTRL_INDEX;
            case 1:
                return C27011o.CTRL_INDEX;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix h = C5163c.m7881h(looper);
                float[] g = C5163c.m7880g(looper);
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
                k.setColor(-3355444);
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                g = C5163c.m7878a(g, 0.70710677f, 0.70710677f, -41.00714f, -0.70710677f, 0.70710677f, 99.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l = C5163c.m7884l(looper);
                l.moveTo(168.0f, 99.0f);
                l.lineTo(168.0f, 165.0f);
                l.cubicTo(168.0f, 166.65686f, 166.65686f, 168.0f, 165.0f, 168.0f);
                l.lineTo(99.0f, 168.0f);
                l.cubicTo(60.892353f, 168.0f, 30.0f, 137.10765f, 30.0f, 99.0f);
                l.cubicTo(30.0f, 60.892353f, 60.892353f, 30.0f, 99.0f, 30.0f);
                l.cubicTo(137.10765f, 30.0f, 168.0f, 60.892353f, 168.0f, 99.0f);
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
