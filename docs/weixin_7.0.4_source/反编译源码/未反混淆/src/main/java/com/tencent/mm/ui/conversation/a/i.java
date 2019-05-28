package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;

public final class i extends b implements a {
    private View jyC = this.view.findViewById(R.id.bvd);
    private View jyD = this.view.findViewById(R.id.a2a);
    private View zwq = this.view.findViewById(R.id.bvg);
    private TextView zwr = ((TextView) this.view.findViewById(R.id.bvf));
    private TextView zws = ((TextView) this.view.findViewById(R.id.bvh));

    public i(Context context) {
        super(context);
        AppMethodBeat.i(34659);
        ab.i("MicroMsg.ForceNotifyBanner", "[initialize]");
        this.view.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(34658);
                ab.i("MicroMsg.ForceNotifyBanner", "[onClick]");
                com.tencent.mm.plugin.forcenotify.a.b bVar = (com.tencent.mm.plugin.forcenotify.a.b) g.K(com.tencent.mm.plugin.forcenotify.a.b.class);
                if (bVar != null) {
                    bVar.dS((Context) i.this.vlu.get());
                }
                AppMethodBeat.o(34658);
            }
        });
        com.tencent.mm.plugin.forcenotify.a.b bVar = (com.tencent.mm.plugin.forcenotify.a.b) g.K(com.tencent.mm.plugin.forcenotify.a.b.class);
        if (bVar != null) {
            bVar.bxV().c(this);
        }
        dIY();
        AppMethodBeat.o(34659);
    }

    public final int getLayoutId() {
        return R.layout.a0g;
    }

    public final void destroy() {
        AppMethodBeat.i(34660);
        if (((com.tencent.mm.plugin.forcenotify.a.b) g.K(com.tencent.mm.plugin.forcenotify.a.b.class)) != null) {
            j bxV = ((com.tencent.mm.plugin.forcenotify.a.b) g.K(com.tencent.mm.plugin.forcenotify.a.b.class)).bxV();
            if (bxV != null) {
                bxV.d(this);
            }
        }
        AppMethodBeat.o(34660);
    }

    private boolean dIY() {
        boolean bxU;
        View view;
        int i = 8;
        AppMethodBeat.i(34661);
        com.tencent.mm.plugin.forcenotify.a.b bVar = (com.tencent.mm.plugin.forcenotify.a.b) g.K(com.tencent.mm.plugin.forcenotify.a.b.class);
        if (bVar != null) {
            bxU = bVar.bxU();
        } else {
            bxU = false;
        }
        boolean hasError = ((com.tencent.mm.plugin.forcenotify.a.b) g.K(com.tencent.mm.plugin.forcenotify.a.b.class)).hasError();
        if (hasError) {
            this.zwq.setVisibility(bxU ? 0 : 8);
            view = this.jyC;
        } else {
            this.zwq.setVisibility(8);
            view = this.jyC;
            if (bxU) {
                i = 0;
            }
        }
        view.setVisibility(i);
        if (!bxU || hasError) {
            AppMethodBeat.o(34661);
            return false;
        }
        AppMethodBeat.o(34661);
        return true;
    }

    public final boolean aMN() {
        AppMethodBeat.i(34662);
        boolean hasError = ((com.tencent.mm.plugin.forcenotify.a.b) g.K(com.tencent.mm.plugin.forcenotify.a.b.class)).hasError();
        if (this.nfA && this.eVH) {
            if (hasError) {
                this.zwq.setBackgroundResource(R.drawable.a3g);
            } else {
                this.jyC.setBackgroundResource(R.drawable.a3h);
            }
        } else if (this.nfA) {
            if (hasError) {
                this.jyD.setBackgroundResource(R.drawable.yh);
                this.zwq.setBackgroundResource(R.drawable.b7t);
                this.zws.setBackgroundResource(R.drawable.a_q);
            } else {
                this.jyD.setBackgroundResource(R.drawable.r9);
                this.jyC.setBackgroundResource(R.drawable.b7t);
                this.zwr.setBackgroundResource(R.drawable.a_q);
            }
        } else if (this.eVH) {
            if (hasError) {
                this.jyD.setBackgroundResource(R.drawable.yh);
                this.zwq.setBackgroundResource(R.drawable.a_q);
                this.zws.setBackground(null);
            } else {
                this.jyD.setBackgroundResource(R.drawable.r9);
                this.jyC.setBackgroundResource(R.drawable.a_q);
                this.zwr.setBackground(null);
            }
        }
        hasError = super.aMN();
        AppMethodBeat.o(34662);
        return hasError;
    }

    public final void a(String str, m mVar) {
        AppMethodBeat.i(34663);
        dIY();
        AppMethodBeat.o(34663);
    }
}
