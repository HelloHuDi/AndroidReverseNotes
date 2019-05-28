package com.tencent.mm.plugin.product.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.x.a;
import com.tencent.mm.plugin.product.b.n;
import com.tencent.mm.sdk.platformtools.bo;

public final class m implements a {
    public TextView gne;
    public ImageView iyo;
    public n.a pjH;

    public final void m(String str, final Bitmap bitmap) {
        AppMethodBeat.i(44138);
        if (this.pjH == null || bo.isNullOrNil(this.pjH.iconUrl)) {
            AppMethodBeat.o(44138);
            return;
        }
        if (str.equals(this.pjH.iconUrl)) {
            this.iyo.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(44137);
                    m.this.iyo.setImageBitmap(bitmap);
                    AppMethodBeat.o(44137);
                }
            });
        }
        AppMethodBeat.o(44138);
    }
}
