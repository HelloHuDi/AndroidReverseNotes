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

/* renamed from: com.tencent.mm.boot.svg.a.a.ark */
public final class ark extends C5163c {
    private final int height = 64;
    private final int width = 38;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 38;
            case 1:
                return 64;
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
                canvas.save();
                k2 = C5163c.m7876a(k, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(0.0f, 0.0f);
                l.lineTo(38.0f, 0.0f);
                l.lineTo(38.0f, 3.1230671f);
                l.lineTo(0.0f, 3.1230671f);
                l.lineTo(0.0f, 0.0f);
                l.close();
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                k2 = C5163c.m7876a(k, looper);
                l = C5163c.m7884l(looper);
                l.moveTo(3.9542723f, 13.915369f);
                l.lineTo(5.7826085f, 15.157895f);
                l.lineTo(0.0f, 15.157895f);
                l.lineTo(0.0f, 6.965601f);
                l.lineTo(38.0f, 6.965601f);
                l.lineTo(38.0f, 15.157895f);
                l.lineTo(32.217392f, 15.157895f);
                l.lineTo(34.045727f, 13.915369f);
                l.lineTo(34.924232f, 13.915369f);
                l.lineTo(34.924232f, 10.105263f);
                l.lineTo(3.0557573f, 10.105263f);
                l.lineTo(3.0557573f, 13.915369f);
                l.lineTo(3.9542723f, 13.915369f);
                l.close();
                l.moveTo(32.217392f, 15.157895f);
                l.lineTo(38.0f, 15.157895f);
                l.lineTo(28.086956f, 22.37594f);
                l.lineTo(28.086956f, 64.0f);
                l.lineTo(9.913043f, 64.0f);
                l.lineTo(9.913043f, 22.37594f);
                l.lineTo(0.0f, 15.157895f);
                l.lineTo(5.7826085f, 15.157895f);
                l.lineTo(13.217391f, 20.210526f);
                l.lineTo(24.782608f, 20.210526f);
                l.lineTo(32.217392f, 15.157895f);
                l.close();
                l.moveTo(13.062004f, 20.210526f);
                l.lineTo(24.988686f, 20.210526f);
                l.lineTo(24.988686f, 60.93955f);
                l.lineTo(13.062004f, 60.93955f);
                l.lineTo(13.062004f, 20.210526f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, k2);
                canvas.restore();
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                Path l2 = C5163c.m7884l(looper);
                l2.moveTo(19.0f, 27.022888f);
                l2.cubicTo(20.368706f, 27.022888f, 21.47826f, 25.816298f, 21.47826f, 24.421053f);
                l2.cubicTo(21.47826f, 23.025806f, 20.368706f, 21.894737f, 19.0f, 21.894737f);
                l2.cubicTo(17.631294f, 21.894737f, 16.52174f, 23.025806f, 16.52174f, 24.421053f);
                l2.cubicTo(16.52174f, 25.816298f, 17.631294f, 27.022888f, 19.0f, 27.022888f);
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
