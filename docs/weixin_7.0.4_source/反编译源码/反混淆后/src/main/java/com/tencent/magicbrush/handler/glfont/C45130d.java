package com.tencent.magicbrush.handler.glfont;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.magicbrush.handler.glfont.d */
final class C45130d {
    Bitmap bSR;
    private C37418c bSS = new C45131k();
    Rect bST = new Rect();
    int[] bSU = new int[4];

    C45130d(int i, int i2) {
        AppMethodBeat.m2504i(115911);
        if (i <= 0) {
            i = 512;
        }
        if (i2 <= 0) {
            i2 = 512;
        }
        this.bSR = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        this.bSS.init(i, i2);
        this.bST.setEmpty();
        AppMethodBeat.m2505o(115911);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final boolean mo72944b(int i, int i2, Rect rect) {
        AppMethodBeat.m2504i(115912);
        if (rect == null) {
            AppMethodBeat.m2505o(115912);
            return false;
        } else if (i <= 0 || i2 <= 0) {
            rect.setEmpty();
            AppMethodBeat.m2505o(115912);
            return false;
        } else {
            this.bSS.mo60253a(i, i2, rect);
            if (rect.left < 0 || rect.right < 0 || rect.width() <= 0 || rect.height() <= 0) {
                AppMethodBeat.m2505o(115912);
                return false;
            }
            this.bST.union(rect);
            AppMethodBeat.m2505o(115912);
            return true;
        }
    }

    /* Access modifiers changed, original: final */
    public final void clear() {
        AppMethodBeat.m2504i(115913);
        this.bST.setEmpty();
        this.bSS.reset();
        if (this.bSR != null) {
            this.bSR.eraseColor(0);
        }
        AppMethodBeat.m2505o(115913);
    }

    /* Access modifiers changed, original: final */
    public final int width() {
        AppMethodBeat.m2504i(115914);
        if (this.bSR != null) {
            int width = this.bSR.getWidth();
            AppMethodBeat.m2505o(115914);
            return width;
        }
        AppMethodBeat.m2505o(115914);
        return 0;
    }

    /* Access modifiers changed, original: final */
    public final int height() {
        AppMethodBeat.m2504i(115915);
        if (this.bSR != null) {
            int height = this.bSR.getHeight();
            AppMethodBeat.m2505o(115915);
            return height;
        }
        AppMethodBeat.m2505o(115915);
        return 0;
    }
}
