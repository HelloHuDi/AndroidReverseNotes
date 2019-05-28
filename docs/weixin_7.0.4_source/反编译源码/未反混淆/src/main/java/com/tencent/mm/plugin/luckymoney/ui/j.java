package com.tencent.mm.plugin.luckymoney.ui;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;

public class j {
    public MMActivity knn;
    public int oic;
    private int oid;

    public static final class a {
        public int jlo;
        public Drawable oie;
        public int oif;
        public int oig;
        public int oih;
        public int oii;
    }

    public j(MMActivity mMActivity) {
        AppMethodBeat.i(43045);
        this.knn = mMActivity;
        if (bMM()) {
            Window window = mMActivity.getWindow();
            window.addFlags(android.support.v4.widget.j.INVALID_ID);
            this.oid = window.getStatusBarColor();
        }
        AppMethodBeat.o(43045);
    }

    public static boolean bMM() {
        return VERSION.SDK_INT >= 21;
    }

    /* Access modifiers changed, original: protected */
    public void t(Drawable drawable) {
        AppMethodBeat.i(43046);
        if (this.knn.getSupportActionBar() != null) {
            this.knn.getSupportActionBar().setBackgroundDrawable(drawable);
        }
        AppMethodBeat.o(43046);
    }
}
