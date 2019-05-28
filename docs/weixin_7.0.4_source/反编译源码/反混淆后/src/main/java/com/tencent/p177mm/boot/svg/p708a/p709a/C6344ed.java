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

/* renamed from: com.tencent.mm.boot.svg.a.a.ed */
public final class C6344ed extends C5163c {
    private final int height = 96;
    private final int width = 105;

    /* renamed from: a */
    public final int mo10620a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 105;
            case 1:
                return 96;
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
                canvas.save();
                Paint a = C5163c.m7876a(k, looper);
                a.setColor(-2565928);
                g = C5163c.m7878a(g, 1.0f, 0.0f, -1303.0f, 0.0f, 1.0f, -1088.0f);
                h.reset();
                h.setValues(g);
                canvas.concat(h);
                canvas.save();
                Paint a2 = C5163c.m7876a(a, looper);
                Path l = C5163c.m7884l(looper);
                l.moveTo(1363.0f, 1092.5238f);
                l.cubicTo(1354.1088f, 1097.0039f, 1348.5f, 1105.5363f, 1348.0f, 1115.1428f);
                l.lineTo(1348.0f, 1155.8572f);
                l.cubicTo(1348.5f, 1163.0183f, 1341.4475f, 1168.9259f, 1333.0f, 1169.4286f);
                l.cubicTo(1324.0508f, 1168.9259f, 1317.0f, 1163.0183f, 1316.5f, 1155.8572f);
                l.cubicTo(1317.0f, 1150.5452f, 1320.5804f, 1146.0714f, 1325.5f, 1143.7937f);
                l.cubicTo(1326.1508f, 1143.7598f, 1333.0f, 1140.7778f, 1334.5f, 1136.254f);
                l.cubicTo(1335.7126f, 1132.5968f, 1331.5f, 1128.7142f, 1327.0f, 1128.7142f);
                l.cubicTo(1322.5f, 1128.7142f, 1321.0f, 1130.2222f, 1318.0f, 1131.7301f);
                l.cubicTo(1315.0f, 1133.2382f, 1310.4043f, 1136.4799f, 1306.0f, 1142.2858f);
                l.cubicTo(1304.3615f, 1146.4514f, 1303.0f, 1150.9463f, 1303.0f, 1155.8572f);
                l.cubicTo(1303.0f, 1170.7678f, 1316.3455f, 1183.0f, 1333.0f, 1183.0f);
                l.cubicTo(1338.5372f, 1183.0f, 1343.9255f, 1181.4536f, 1348.0f, 1178.4762f);
                l.cubicTo(1356.8912f, 1173.9961f, 1362.5f, 1165.4637f, 1363.0f, 1155.8572f);
                l.lineTo(1363.0f, 1115.1428f);
                l.cubicTo(1362.5f, 1107.9817f, 1369.5508f, 1102.0741f, 1378.0f, 1101.5714f);
                l.cubicTo(1386.9475f, 1102.0741f, 1394.0f, 1107.9817f, 1394.5f, 1115.1428f);
                l.cubicTo(1394.0f, 1120.6765f, 1388.5f, 1127.2063f, 1384.0f, 1128.7142f);
                l.cubicTo(1379.5f, 1130.2222f, 1378.033f, 1131.1792f, 1376.5f, 1134.746f);
                l.cubicTo(1375.3835f, 1138.496f, 1378.0f, 1142.2858f, 1384.0f, 1142.2858f);
                l.cubicTo(1384.8744f, 1142.2858f, 1390.6953f, 1141.1154f, 1396.0f, 1137.7618f);
                l.cubicTo(1399.7954f, 1135.3627f, 1403.1697f, 1131.1248f, 1405.0f, 1128.7142f);
                l.cubicTo(1406.6385f, 1124.5504f, 1408.0f, 1120.0537f, 1408.0f, 1115.1428f);
                l.cubicTo(1408.0f, 1100.2322f, 1394.6545f, 1088.0f, 1378.0f, 1088.0f);
                l.cubicTo(1372.4628f, 1088.0f, 1367.0745f, 1089.5464f, 1363.0f, 1092.5238f);
                l.close();
                WeChatSVGRenderC2Java.setFillType(l, 2);
                canvas.drawPath(l, a2);
                canvas.restore();
                canvas.restore();
                C5163c.m7882j(looper);
                break;
        }
        return 0;
    }
}
