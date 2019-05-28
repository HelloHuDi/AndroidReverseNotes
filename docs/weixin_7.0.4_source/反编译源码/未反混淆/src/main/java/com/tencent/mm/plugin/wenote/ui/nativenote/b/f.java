package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;

public final class f extends i {
    private int fgJ = 0;
    private ImageView uUu;

    public f(View view, k kVar) {
        super(view, kVar);
        AppMethodBeat.i(27159);
        this.cAw.setVisibility(0);
        this.gCe.setVisibility(8);
        this.uUB.setVisibility(8);
        this.cAw.setTag(this);
        this.cAw.setOnClickListener(this.nij);
        this.uUu = (ImageView) view.findViewById(R.id.da7);
        this.uUu.setVisibility(8);
        this.fgJ = k.mScreenWidth - ((int) k.aU(20.0f));
        AppMethodBeat.o(27159);
    }

    public final void a(c cVar, int i, int i2) {
        String str;
        AppMethodBeat.i(27160);
        String str2 = ((com.tencent.mm.plugin.wenote.model.a.f) cVar).cHg;
        String str3 = ((com.tencent.mm.plugin.wenote.model.a.f) cVar).uOq;
        if (e.ct(str2)) {
            str = str2;
        } else if (e.ct(str3)) {
            str = str3;
        } else {
            Object str4 = null;
        }
        if (this.uSJ.uQI != 3) {
            str3 = str4;
        } else if (!e.ct(str3)) {
            str3 = str4;
        }
        Bitmap ahk = bo.isNullOrNil(str3) ? null : com.tencent.mm.plugin.wenote.b.c.ahk(str3);
        this.cAw.setImageBitmap(null);
        LayoutParams layoutParams = this.cAw.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.cAw.setLayoutParams(layoutParams);
        if (ahk != null) {
            this.cAw.setImageBitmap(ahk);
        } else {
            this.cAw.setImageBitmap(null);
            LayoutParams layoutParams2 = this.cAw.getLayoutParams();
            layoutParams2.width = this.fgJ;
            layoutParams2.height = this.fgJ;
            this.cAw.setLayoutParams(layoutParams2);
            this.cAw.setBackgroundColor(Color.parseColor("#f6f6f6"));
        }
        if (cVar.uOa) {
            this.uUu.setVisibility(0);
        } else {
            this.uUu.setVisibility(8);
        }
        super.a(cVar, i, i2);
        AppMethodBeat.o(27160);
    }

    public final int dfW() {
        return 2;
    }
}
