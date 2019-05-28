package com.tencent.view;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.HardCoderJNI;

/* renamed from: com.tencent.view.f */
public final class C36573f {
    private static final float[] AIO = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    private static final float[] AIP = new float[]{-1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f};
    public int height;
    public int texture = HardCoderJNI.ERR_CLIENT_CONNECT;
    public int width;

    /* renamed from: as */
    public static C36573f m60612as(Bitmap bitmap) {
        AppMethodBeat.m2504i(86637);
        if (bitmap != null) {
            C36573f c36573f = new C36573f(C41106g.m71543at(bitmap), bitmap.getWidth(), bitmap.getHeight());
            AppMethodBeat.m2505o(86637);
            return c36573f;
        }
        AppMethodBeat.m2505o(86637);
        return null;
    }

    private C36573f(int i, int i2, int i3) {
        this.texture = i;
        this.width = i2;
        this.height = i3;
    }
}
