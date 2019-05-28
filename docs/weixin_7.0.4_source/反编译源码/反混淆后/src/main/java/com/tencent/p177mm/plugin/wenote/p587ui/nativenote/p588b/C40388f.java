package com.tencent.p177mm.plugin.wenote.p587ui.nativenote.p588b;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C46457k;
import com.tencent.p177mm.plugin.wenote.model.p585a.C24930f;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44001c;
import com.tencent.p177mm.plugin.wenote.p1333b.C29977c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.b.f */
public final class C40388f extends C14790i {
    private int fgJ = 0;
    private ImageView uUu;

    public C40388f(View view, C46457k c46457k) {
        super(view, c46457k);
        AppMethodBeat.m2504i(27159);
        this.cAw.setVisibility(0);
        this.gCe.setVisibility(8);
        this.uUB.setVisibility(8);
        this.cAw.setTag(this);
        this.cAw.setOnClickListener(this.nij);
        this.uUu = (ImageView) view.findViewById(2131826063);
        this.uUu.setVisibility(8);
        this.fgJ = C46457k.mScreenWidth - ((int) C46457k.m87622aU(20.0f));
        AppMethodBeat.m2505o(27159);
    }

    /* renamed from: a */
    public final void mo9809a(C44001c c44001c, int i, int i2) {
        String str;
        AppMethodBeat.m2504i(27160);
        String str2 = ((C24930f) c44001c).cHg;
        String str3 = ((C24930f) c44001c).uOq;
        if (C5730e.m8628ct(str2)) {
            str = str2;
        } else if (C5730e.m8628ct(str3)) {
            str = str3;
        } else {
            Object str4 = null;
        }
        if (this.uSJ.uQI != 3) {
            str3 = str4;
        } else if (!C5730e.m8628ct(str3)) {
            str3 = str4;
        }
        Bitmap ahk = C5046bo.isNullOrNil(str3) ? null : C29977c.ahk(str3);
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
        if (c44001c.uOa) {
            this.uUu.setVisibility(0);
        } else {
            this.uUu.setVisibility(8);
        }
        super.mo9809a(c44001c, i, i2);
        AppMethodBeat.m2505o(27160);
    }

    public final int dfW() {
        return 2;
    }
}
