package com.tencent.p177mm.boot.svg.p708a.p709a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.p177mm.svg.C5163c;
import com.tencent.p177mm.svg.WeChatSVGRenderC2Java;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.mm.boot.svg.a.a.of */
public final class C37574of extends C5163c {
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
                canvas.saveLayerAlpha(null, 230, 4);
                canvas.save();
                g = C5163c.m7878a(g, -1.0f, 0.0f, 72.0f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.restore();
                canvas.save();
                k = C5163c.m7876a(k, looper);
                k.setColor(WebView.NIGHT_MODE_COLOR);
                g = C5163c.m7878a(g, -1.0f, 0.0f, 72.0f, 0.0f, 1.0f, 0.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                Path l = C5163c.m7884l(looper);
                l.moveTo(42.834522f, 12.0f);
                l.cubicTo(48.80635f, 18.142136f, 52.5f, 26.627417f, 52.5f, 36.0f);
                l.cubicTo(52.5f, 45.37258f, 48.80635f, 53.857864f, 42.834522f, 60.0f);
                l.lineTo(39.334347f, 56.4f);
                l.cubicTo(44.410397f, 51.179184f, 47.55f, 43.966694f, 47.55f, 36.0f);
                l.cubicTo(47.55f, 28.033304f, 44.410397f, 20.820816f, 39.334347f, 15.6f);
                l.lineTo(42.834522f, 12.0f);
                l.close();
                l.moveTo(34.667442f, 20.4f);
                l.cubicTo(38.549126f, 24.392387f, 40.95f, 29.907822f, 40.95f, 36.0f);
                l.cubicTo(40.95f, 42.09218f, 38.549126f, 47.607613f, 34.667442f, 51.6f);
                l.lineTo(31.167261f, 48.0f);
                l.cubicTo(34.153175f, 44.928932f, 36.0f, 40.68629f, 36.0f, 36.0f);
                l.cubicTo(36.0f, 31.31371f, 34.153175f, 27.071068f, 31.167261f, 24.0f);
                l.lineTo(34.667442f, 20.4f);
                l.close();
                l.moveTo(26.500357f, 28.8f);
                l.cubicTo(28.291904f, 30.642641f, 29.4f, 33.188225f, 29.4f, 36.0f);
                l.cubicTo(29.4f, 38.811775f, 28.291904f, 41.35736f, 26.500357f, 43.2f);
                l.lineTo(19.5f, 36.0f);
                l.lineTo(26.500357f, 28.8f);
                l.close();
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
