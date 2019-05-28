package com.tencent.mm.plugin.appbrand.ui.recents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.List;

public final class h implements OnClickListener {
    b iNP;
    c iNQ = c.NONE;
    final d iNR = new d();
    private final int iNS;
    private final int iNT = 200;
    private final a iNU;

    class a {
        final int eop;
        final int eoq;
        final int eor;
        private final int eos;
        com.tencent.mm.plugin.appbrand.ui.widget.a iNW;

        /* synthetic */ a(h hVar, Context context, byte b) {
            this(context);
        }

        private a(Context context) {
            AppMethodBeat.i(133435);
            this.eos = -1;
            this.eop = com.tencent.mm.bz.a.fromDPToPix(context, 25);
            this.eoq = com.tencent.mm.bz.a.fromDPToPix(context, 19);
            this.eor = com.tencent.mm.bz.a.fromDPToPix(context, 2);
            AppMethodBeat.o(133435);
        }
    }

    interface b {
        void a(c cVar, View view);
    }

    static class d {
        View apJ;
        ThreeDotsLoadingView iNB;
        TextView iOc;
        View iOd;
        AppBrandNearbyShowcaseView iOe;
        TextView iOf;
        ImageView iOg;
        ImageView iOh;

        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }
    }

    enum c {
        NONE,
        LOADING,
        LOADING_SUCCESS,
        LOADING_ERROR;

        static {
            AppMethodBeat.o(133438);
        }
    }

    public h(ViewGroup viewGroup) {
        AppMethodBeat.i(133439);
        Context context = viewGroup.getContext();
        this.iNU = new a(this, context, (byte) 0);
        View inflate = LayoutInflater.from(context).inflate(R.layout.d3, viewGroup, false);
        this.iNR.apJ = inflate;
        this.iNR.iOc = (TextView) inflate.findViewById(R.id.cx);
        this.iNR.iOd = inflate.findViewById(R.id.ui);
        this.iNR.iOf = (TextView) inflate.findViewById(R.id.uk);
        this.iNR.iOe = (AppBrandNearbyShowcaseView) inflate.findViewById(R.id.uj);
        this.iNR.iNB = (ThreeDotsLoadingView) inflate.findViewById(R.id.un);
        this.iNR.iOg = (ImageView) inflate.findViewById(R.id.uo);
        this.iNR.iOh = (ImageView) inflate.findViewById(R.id.ul);
        this.iNR.apJ.setOnClickListener(this);
        this.iNR.iOc.setText(R.string.kf);
        AppBrandNearbyShowcaseView appBrandNearbyShowcaseView = this.iNR.iOe;
        if (appBrandNearbyShowcaseView != null) {
            appBrandNearbyShowcaseView.setIconLayerCount(4);
            appBrandNearbyShowcaseView.setIconSize(this.iNU.eop + (this.iNU.eor * 2));
            appBrandNearbyShowcaseView.setIconGap(this.iNU.eoq);
        }
        this.iNS = com.tencent.mm.bz.a.i(context, R.color.ro);
        AppMethodBeat.o(133439);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aNt() {
        AppMethodBeat.i(133440);
        ab.i("MicroMsg.AppBrandLauncherRecentsListHeaderBase", "AppBrandLauncherRecentsListHeaderBase.loading");
        this.iNQ = c.LOADING;
        cw(this.iNR.iOd);
        cw(this.iNR.iOg);
        cx(this.iNR.iNB);
        this.iNR.iNB.dKS();
        AppMethodBeat.o(133440);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(List<String> list, String str, Integer num) {
        boolean z = false;
        AppMethodBeat.i(133441);
        ab.i("MicroMsg.AppBrandLauncherRecentsListHeaderBase", "AppBrandLauncherRecentsListHeaderBase.loadingSuccess");
        this.iNQ = c.LOADING_SUCCESS;
        this.iNR.iNB.dKT();
        cw(this.iNR.iNB);
        if (list == null || list.size() == 0) {
            ab.e("MicroMsg.AppBrandLauncherRecentsListHeaderBase", "AppBrandLauncherRecentsListHeaderBase.showLoadingSuccess empty iconUrl list");
            AppMethodBeat.o(133441);
            return;
        }
        int i;
        if (list != null) {
            this.iNR.iOe.setIconLayerCount(Math.min(list.size(), 4));
            this.iNR.iOe.eO(false);
            a aVar = this.iNU;
            if (aVar.iNW == null) {
                aVar.iNW = new com.tencent.mm.plugin.appbrand.ui.widget.a(aVar.eop, aVar.eor);
            }
            f fVar = aVar.iNW;
            while (true) {
                boolean z2 = z;
                if (z2 >= this.iNR.iOe.getChildCount()) {
                    break;
                }
                com.tencent.mm.modelappbrand.a.b.abR().a(this.iNR.iOe.qf(z2), (String) list.get(z2), com.tencent.mm.modelappbrand.a.a.abQ(), fVar);
                z = z2 + 1;
            }
        } else {
            ab.e("MicroMsg.AppBrandLauncherRecentsListHeaderBase", "prepareIconList without icon urls");
        }
        if (num == null) {
            i = this.iNS;
        } else {
            i = num.intValue();
        }
        if (this.iNR.iOf != null) {
            this.iNR.iOf.setText(str);
            this.iNR.iOf.setTextColor(i);
        }
        if (this.iNR.iOd != null) {
            cx(this.iNR.iOd);
            if (this.iNR.iOe != null) {
                this.iNR.iOe.aOB();
            }
            if (this.iNR.iOf != null) {
                this.iNR.iOf.setAlpha(0.0f);
                this.iNR.iOf.animate().alpha(1.0f).setDuration(500).start();
            }
        }
        AppMethodBeat.o(133441);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(133442);
        if (this.iNP != null) {
            this.iNP.a(this.iNQ, view);
        }
        AppMethodBeat.o(133442);
    }

    /* Access modifiers changed, original: final */
    public final void cw(final View view) {
        AppMethodBeat.i(133443);
        if (view.getVisibility() == 0) {
            view.animate().setDuration(200).alpha(0.0f).withEndAction(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(133434);
                    view.setVisibility(8);
                    AppMethodBeat.o(133434);
                }
            }).start();
        }
        AppMethodBeat.o(133443);
    }

    static void cx(View view) {
        AppMethodBeat.i(133444);
        if (view.getVisibility() != 0) {
            view.setAlpha(0.0f);
            view.setVisibility(0);
        }
        view.animate().setDuration(200).alpha(1.0f).withEndAction(null).start();
        AppMethodBeat.o(133444);
    }
}
