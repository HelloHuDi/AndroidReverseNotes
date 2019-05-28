package com.tencent.p177mm.plugin.location.p446ui;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.p443k.C28354d;

/* renamed from: com.tencent.mm.plugin.location.ui.g */
public final class C12383g extends FrameLayout {
    private Context mContext;
    public boolean nLR = false;
    private ImageView nMi;
    public C28354d nMj;

    public C12383g(Context context, C28354d c28354d) {
        super(context);
        AppMethodBeat.m2504i(113471);
        this.nMj = c28354d;
        this.mContext = context;
        this.nMi = (ImageView) View.inflate(this.mContext, 2130970369, this).findViewById(2131826561);
        AppMethodBeat.m2505o(113471);
    }

    public final void remove() {
        AppMethodBeat.m2504i(113472);
        if (this.nLR) {
            this.nMj.removeView(this);
        }
        this.nLR = false;
        AppMethodBeat.m2505o(113472);
    }
}
