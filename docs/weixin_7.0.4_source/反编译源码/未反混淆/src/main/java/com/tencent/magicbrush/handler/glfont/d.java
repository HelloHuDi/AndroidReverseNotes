package com.tencent.magicbrush.handler.glfont;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class d {
    Bitmap bSR;
    private c bSS = new k();
    Rect bST = new Rect();
    int[] bSU = new int[4];

    d(int i, int i2) {
        AppMethodBeat.i(115911);
        if (i <= 0) {
            i = 512;
        }
        if (i2 <= 0) {
            i2 = 512;
        }
        this.bSR = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        this.bSS.init(i, i2);
        this.bST.setEmpty();
        AppMethodBeat.o(115911);
    }

    /* Access modifiers changed, original: final */
    public final boolean b(int i, int i2, Rect rect) {
        AppMethodBeat.i(115912);
        if (rect == null) {
            AppMethodBeat.o(115912);
            return false;
        } else if (i <= 0 || i2 <= 0) {
            rect.setEmpty();
            AppMethodBeat.o(115912);
            return false;
        } else {
            this.bSS.a(i, i2, rect);
            if (rect.left < 0 || rect.right < 0 || rect.width() <= 0 || rect.height() <= 0) {
                AppMethodBeat.o(115912);
                return false;
            }
            this.bST.union(rect);
            AppMethodBeat.o(115912);
            return true;
        }
    }

    /* Access modifiers changed, original: final */
    public final void clear() {
        AppMethodBeat.i(115913);
        this.bST.setEmpty();
        this.bSS.reset();
        if (this.bSR != null) {
            this.bSR.eraseColor(0);
        }
        AppMethodBeat.o(115913);
    }

    /* Access modifiers changed, original: final */
    public final int width() {
        AppMethodBeat.i(115914);
        if (this.bSR != null) {
            int width = this.bSR.getWidth();
            AppMethodBeat.o(115914);
            return width;
        }
        AppMethodBeat.o(115914);
        return 0;
    }

    /* Access modifiers changed, original: final */
    public final int height() {
        AppMethodBeat.i(115915);
        if (this.bSR != null) {
            int height = this.bSR.getHeight();
            AppMethodBeat.o(115915);
            return height;
        }
        AppMethodBeat.o(115915);
        return 0;
    }
}
