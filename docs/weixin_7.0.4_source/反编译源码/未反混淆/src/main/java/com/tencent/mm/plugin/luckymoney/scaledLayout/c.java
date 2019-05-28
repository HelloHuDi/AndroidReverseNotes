package com.tencent.mm.plugin.luckymoney.scaledLayout;

import android.content.Context;
import android.view.View;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c extends ViewPagerLayoutManager {
    private float aJg;
    private int oaY;
    private float oaZ;
    private float oba;
    private float obb;

    public static class a {
        private static float obc = 1.0f;
        private static float obd = 1.0f;
        private float aJg;
        private Context context;
        private int oaY = 0;
        private float oaZ;
        private float oba;
        private float obb;
        private boolean obe;
        private int obf;
        private int obg;
        private int orientation;

        public a(Context context) {
            this.context = context;
            this.orientation = 0;
            this.aJg = 0.8f;
            this.oaZ = 1.0f;
            this.oba = obd;
            this.obb = obc;
            this.obe = false;
            this.obg = BaseClientBuilder.API_PRIORITY_OTHER;
            this.obf = -1;
        }
    }

    public c(Context context) {
        this(new a(context));
        AppMethodBeat.i(42479);
        AppMethodBeat.o(42479);
    }

    private c(a aVar) {
        aVar.context;
        this(aVar.oaY, aVar.aJg, aVar.oba, aVar.obb, aVar.orientation, aVar.oaZ, aVar.obf, aVar.obg, aVar.obe);
        AppMethodBeat.i(42480);
        AppMethodBeat.o(42480);
    }

    private c(int i, float f, float f2, float f3, int i2, float f4, int i3, int i4, boolean z) {
        super(i2, z);
        AppMethodBeat.i(42481);
        T(null);
        if (this.obw != i4) {
            this.obw = i4;
            removeAllViews();
        }
        T(null);
        if (this.obu != i3) {
            this.obu = i3;
            removeAllViews();
        }
        this.oaY = i;
        this.aJg = f;
        this.oaZ = f4;
        this.oba = f2;
        this.obb = f3;
        AppMethodBeat.o(42481);
    }

    public final void bLS() {
        AppMethodBeat.i(42482);
        T(null);
        if (this.aJg == 0.8f) {
            AppMethodBeat.o(42482);
            return;
        }
        this.aJg = 0.8f;
        removeAllViews();
        AppMethodBeat.o(42482);
    }

    /* Access modifiers changed, original: protected|final */
    public final float bLT() {
        return (float) (this.oaY + this.obi);
    }

    /* Access modifiers changed, original: protected|final */
    public final void m(View view, float f) {
        AppMethodBeat.i(42483);
        float abs = Math.abs((((float) this.obl) + f) - ((float) this.obl));
        if (abs - ((float) this.obi) > 0.0f) {
            abs = (float) this.obi;
        }
        abs = 1.0f - ((abs / ((float) this.obi)) * (1.0f - this.aJg));
        view.setScaleX(abs);
        view.setScaleY(abs);
        float abs2 = Math.abs(f);
        abs = (((this.obb - this.oba) / this.obq) * abs2) + this.oba;
        if (abs2 >= this.obq) {
            abs = this.obb;
        }
        view.setAlpha(abs);
        AppMethodBeat.o(42483);
    }

    /* Access modifiers changed, original: protected|final */
    public final float bLU() {
        if (this.oaZ == 0.0f) {
            return Float.MAX_VALUE;
        }
        return 1.0f / this.oaZ;
    }
}
