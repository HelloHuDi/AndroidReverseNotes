package com.tencent.p177mm.plugin.product.p482ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.platformtools.C18764x.C18765a;
import com.tencent.p177mm.plugin.product.p481b.C12813n.C3596a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.product.ui.m */
public final class C43379m implements C18765a {
    public TextView gne;
    public ImageView iyo;
    public C3596a pjH;

    /* renamed from: m */
    public final void mo8136m(String str, final Bitmap bitmap) {
        AppMethodBeat.m2504i(44138);
        if (this.pjH == null || C5046bo.isNullOrNil(this.pjH.iconUrl)) {
            AppMethodBeat.m2505o(44138);
            return;
        }
        if (str.equals(this.pjH.iconUrl)) {
            this.iyo.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(44137);
                    C43379m.this.iyo.setImageBitmap(bitmap);
                    AppMethodBeat.m2505o(44137);
                }
            });
        }
        AppMethodBeat.m2505o(44138);
    }
}
