package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopView.c;

public final class e extends v {
    public TextView gne;
    public ImageView iYd;
    public FrameLayout iYe;
    public TextView iYf;
    public ImageView iYg;
    public c iYh;
    public ImageView iqT;

    public e(View view) {
        super(view);
        AppMethodBeat.i(133896);
        this.iqT = (ImageView) view.findViewById(R.id.jb);
        this.iYd = (ImageView) view.findViewById(R.id.yp);
        this.iYe = (FrameLayout) view.findViewById(R.id.yv);
        this.gne = (TextView) view.findViewById(R.id.cx);
        this.iYf = (TextView) view.findViewById(R.id.yq);
        this.iYg = (ImageView) view.findViewById(R.id.b9u);
        AppMethodBeat.o(133896);
    }
}
