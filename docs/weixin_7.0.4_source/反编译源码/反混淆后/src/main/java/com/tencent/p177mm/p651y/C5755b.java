package com.tencent.p177mm.p651y;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1639ch.C45281a;

/* renamed from: com.tencent.mm.y.b */
public final class C5755b implements Cloneable {
    private static Paint eHe;
    public int mColor;
    private float mScale = 1.0f;
    /* renamed from: uW */
    private float f1358uW = ((float) C45281a.m83492bu(5.0f));
    /* renamed from: vr */
    private Path f1359vr;

    static {
        AppMethodBeat.m2504i(116272);
        Paint paint = new Paint();
        eHe = paint;
        paint.setAntiAlias(true);
        eHe.setStyle(Style.STROKE);
        eHe.setStrokeCap(Cap.ROUND);
        AppMethodBeat.m2505o(116272);
    }

    public C5755b(Path path, float f, int i) {
        AppMethodBeat.m2504i(116270);
        this.f1359vr = path;
        this.mScale = f;
        this.mColor = i;
        AppMethodBeat.m2505o(116270);
    }

    public final void draw(Canvas canvas) {
        AppMethodBeat.m2504i(116271);
        eHe.setColor(this.mColor);
        eHe.setStrokeWidth(this.f1358uW * this.mScale);
        if (!this.f1359vr.isEmpty()) {
            canvas.drawPath(this.f1359vr, eHe);
        }
        AppMethodBeat.m2505o(116271);
    }
}
