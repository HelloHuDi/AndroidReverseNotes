package com.tencent.p177mm.plugin.sns.p520ui.widget;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.sns.ui.widget.a */
public final class C29247a extends Animation {
    private final float ccw;
    private final float ccx;
    private Context context;
    private final float rMv;
    private final float rMw;
    private final float rMx;
    private final boolean rMy;
    private Camera rMz;
    private float scale = 1.0f;

    public C29247a(Context context, float f, float f2, float f3, float f4, boolean z) {
        AppMethodBeat.m2504i(40435);
        this.context = context;
        this.rMv = f;
        this.rMw = f2;
        this.ccw = f3;
        this.ccx = f4;
        this.rMx = 150.0f;
        this.rMy = z;
        this.scale = context.getResources().getDisplayMetrics().density;
        AppMethodBeat.m2505o(40435);
    }

    public final void initialize(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(40436);
        super.initialize(i, i2, i3, i4);
        this.rMz = new Camera();
        AppMethodBeat.m2505o(40436);
    }

    /* Access modifiers changed, original: protected|final */
    public final void applyTransformation(float f, Transformation transformation) {
        AppMethodBeat.m2504i(40437);
        float f2 = this.rMv + ((this.rMw - this.rMv) * f);
        float f3 = this.ccw;
        float f4 = this.ccx;
        Camera camera = this.rMz;
        Matrix matrix = transformation.getMatrix();
        camera.save();
        if (this.rMy) {
            camera.translate(0.0f, 0.0f, this.rMx * f);
        } else {
            camera.translate(0.0f, 0.0f, this.rMx * (1.0f - f));
        }
        camera.rotateY(f2);
        camera.getMatrix(matrix);
        camera.restore();
        float[] fArr = new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        matrix.getValues(fArr);
        fArr[6] = fArr[6] / this.scale;
        matrix.setValues(fArr);
        matrix.preTranslate(-f3, -f4);
        matrix.postTranslate(f3, f4);
        AppMethodBeat.m2505o(40437);
    }
}
