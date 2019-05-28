package com.tencent.p177mm.plugin.luckymoney.p449ui;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.p057v4.widget.C8415j;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;

/* renamed from: com.tencent.mm.plugin.luckymoney.ui.j */
public class C43284j {
    public MMActivity knn;
    public int oic;
    private int oid;

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.j$a */
    public static final class C43283a {
        public int jlo;
        public Drawable oie;
        public int oif;
        public int oig;
        public int oih;
        public int oii;
    }

    public C43284j(MMActivity mMActivity) {
        AppMethodBeat.m2504i(43045);
        this.knn = mMActivity;
        if (C43284j.bMM()) {
            Window window = mMActivity.getWindow();
            window.addFlags(C8415j.INVALID_ID);
            this.oid = window.getStatusBarColor();
        }
        AppMethodBeat.m2505o(43045);
    }

    public static boolean bMM() {
        return VERSION.SDK_INT >= 21;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: t */
    public void mo7772t(Drawable drawable) {
        AppMethodBeat.m2504i(43046);
        if (this.knn.getSupportActionBar() != null) {
            this.knn.getSupportActionBar().setBackgroundDrawable(drawable);
        }
        AppMethodBeat.m2505o(43046);
    }
}
