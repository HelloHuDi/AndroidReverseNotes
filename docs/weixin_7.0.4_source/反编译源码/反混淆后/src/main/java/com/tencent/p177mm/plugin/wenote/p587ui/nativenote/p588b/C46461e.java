package com.tencent.p177mm.plugin.wenote.p587ui.nativenote.p588b;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C46457k;
import com.tencent.p177mm.plugin.wenote.model.p585a.C23177e;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44001c;

/* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.b.e */
public final class C46461e extends C4689a {
    private TextView uUr;
    private View uUs;
    public LinearLayout uUt;

    public C46461e(View view, C46457k c46457k) {
        super(view, c46457k);
        AppMethodBeat.m2504i(27157);
        this.uUt = (LinearLayout) view.findViewById(2131826378);
        this.uUt.setVisibility(0);
        this.uUr = (TextView) view.findViewById(2131826379);
        this.uUs = view.findViewById(2131826380);
        AppMethodBeat.m2505o(27157);
    }

    /* renamed from: a */
    public final void mo9809a(C44001c c44001c, int i, int i2) {
        AppMethodBeat.m2504i(27158);
        if (c44001c.getType() != -3) {
            AppMethodBeat.m2505o(27158);
        } else if (this.uSJ.uQI == 3) {
            this.uUt.setVisibility(8);
            AppMethodBeat.m2505o(27158);
        } else {
            this.uUt.setVisibility(0);
            C23177e c23177e = (C23177e) c44001c;
            if (c23177e.uOe <= 0) {
                AppMethodBeat.m2505o(27158);
                return;
            }
            Object obj;
            Context context = this.uUr.getContext();
            long j = c23177e.uOe;
            if (j < 3600000) {
                obj = "";
            } else {
                obj = DateFormat.format(context.getString(C25738R.string.bpk), j);
            }
            this.uUr.setText(this.uUr.getContext().getString(C25738R.string.d83) + " " + obj);
            AppMethodBeat.m2505o(27158);
        }
    }

    public final int dfW() {
        return -3;
    }
}
