package com.tencent.p177mm.plugin.appbrand.p336ui.recents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.modelappbrand.p873a.C32804a;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C37932f;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.widget.ThreeDotsLoadingView;
import com.tencent.p177mm.plugin.appbrand.p336ui.widget.C10929a;
import com.tencent.p177mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.h */
public final class C2489h implements OnClickListener {
    C2491b iNP;
    C2494c iNQ = C2494c.NONE;
    final C2492d iNR = new C2492d();
    private final int iNS;
    private final int iNT = 200;
    private final C2490a iNU;

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.h$a */
    class C2490a {
        final int eop;
        final int eoq;
        final int eor;
        private final int eos;
        C10929a iNW;

        /* synthetic */ C2490a(C2489h c2489h, Context context, byte b) {
            this(context);
        }

        private C2490a(Context context) {
            AppMethodBeat.m2504i(133435);
            this.eos = -1;
            this.eop = C1338a.fromDPToPix(context, 25);
            this.eoq = C1338a.fromDPToPix(context, 19);
            this.eor = C1338a.fromDPToPix(context, 2);
            AppMethodBeat.m2505o(133435);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.h$b */
    interface C2491b {
        /* renamed from: a */
        void mo6429a(C2494c c2494c, View view);
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.h$d */
    static class C2492d {
        View apJ;
        ThreeDotsLoadingView iNB;
        TextView iOc;
        View iOd;
        AppBrandNearbyShowcaseView iOe;
        TextView iOf;
        ImageView iOg;
        ImageView iOh;

        private C2492d() {
        }

        /* synthetic */ C2492d(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.h$c */
    enum C2494c {
        NONE,
        LOADING,
        LOADING_SUCCESS,
        LOADING_ERROR;

        static {
            AppMethodBeat.m2505o(133438);
        }
    }

    public C2489h(ViewGroup viewGroup) {
        AppMethodBeat.m2504i(133439);
        Context context = viewGroup.getContext();
        this.iNU = new C2490a(this, context, (byte) 0);
        View inflate = LayoutInflater.from(context).inflate(2130968716, viewGroup, false);
        this.iNR.apJ = inflate;
        this.iNR.iOc = (TextView) inflate.findViewById(2131820678);
        this.iNR.iOd = inflate.findViewById(2131821329);
        this.iNR.iOf = (TextView) inflate.findViewById(2131821331);
        this.iNR.iOe = (AppBrandNearbyShowcaseView) inflate.findViewById(2131821330);
        this.iNR.iNB = (ThreeDotsLoadingView) inflate.findViewById(2131821334);
        this.iNR.iOg = (ImageView) inflate.findViewById(2131821335);
        this.iNR.iOh = (ImageView) inflate.findViewById(2131821332);
        this.iNR.apJ.setOnClickListener(this);
        this.iNR.iOc.setText(C25738R.string.f8948kf);
        AppBrandNearbyShowcaseView appBrandNearbyShowcaseView = this.iNR.iOe;
        if (appBrandNearbyShowcaseView != null) {
            appBrandNearbyShowcaseView.setIconLayerCount(4);
            appBrandNearbyShowcaseView.setIconSize(this.iNU.eop + (this.iNU.eor * 2));
            appBrandNearbyShowcaseView.setIconGap(this.iNU.eoq);
        }
        this.iNS = C1338a.m2872i(context, C25738R.color.f12082ro);
        AppMethodBeat.m2505o(133439);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aNt() {
        AppMethodBeat.m2504i(133440);
        C4990ab.m7416i("MicroMsg.AppBrandLauncherRecentsListHeaderBase", "AppBrandLauncherRecentsListHeaderBase.loading");
        this.iNQ = C2494c.LOADING;
        mo6427cw(this.iNR.iOd);
        mo6427cw(this.iNR.iOg);
        C2489h.m4717cx(this.iNR.iNB);
        this.iNR.iNB.dKS();
        AppMethodBeat.m2505o(133440);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo6425a(List<String> list, String str, Integer num) {
        boolean z = false;
        AppMethodBeat.m2504i(133441);
        C4990ab.m7416i("MicroMsg.AppBrandLauncherRecentsListHeaderBase", "AppBrandLauncherRecentsListHeaderBase.loadingSuccess");
        this.iNQ = C2494c.LOADING_SUCCESS;
        this.iNR.iNB.dKT();
        mo6427cw(this.iNR.iNB);
        if (list == null || list.size() == 0) {
            C4990ab.m7412e("MicroMsg.AppBrandLauncherRecentsListHeaderBase", "AppBrandLauncherRecentsListHeaderBase.showLoadingSuccess empty iconUrl list");
            AppMethodBeat.m2505o(133441);
            return;
        }
        int i;
        if (list != null) {
            this.iNR.iOe.setIconLayerCount(Math.min(list.size(), 4));
            this.iNR.iOe.mo54070eO(false);
            C2490a c2490a = this.iNU;
            if (c2490a.iNW == null) {
                c2490a.iNW = new C10929a(c2490a.eop, c2490a.eor);
            }
            C37932f c37932f = c2490a.iNW;
            while (true) {
                boolean z2 = z;
                if (z2 >= this.iNR.iOe.getChildCount()) {
                    break;
                }
                C37926b.abR().mo60683a(this.iNR.iOe.mo54072qf(z2), (String) list.get(z2), C32804a.abQ(), c37932f);
                z = z2 + 1;
            }
        } else {
            C4990ab.m7412e("MicroMsg.AppBrandLauncherRecentsListHeaderBase", "prepareIconList without icon urls");
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
            C2489h.m4717cx(this.iNR.iOd);
            if (this.iNR.iOe != null) {
                this.iNR.iOe.aOB();
            }
            if (this.iNR.iOf != null) {
                this.iNR.iOf.setAlpha(0.0f);
                this.iNR.iOf.animate().alpha(1.0f).setDuration(500).start();
            }
        }
        AppMethodBeat.m2505o(133441);
    }

    public final void onClick(View view) {
        AppMethodBeat.m2504i(133442);
        if (this.iNP != null) {
            this.iNP.mo6429a(this.iNQ, view);
        }
        AppMethodBeat.m2505o(133442);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: cw */
    public final void mo6427cw(final View view) {
        AppMethodBeat.m2504i(133443);
        if (view.getVisibility() == 0) {
            view.animate().setDuration(200).alpha(0.0f).withEndAction(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(133434);
                    view.setVisibility(8);
                    AppMethodBeat.m2505o(133434);
                }
            }).start();
        }
        AppMethodBeat.m2505o(133443);
    }

    /* renamed from: cx */
    static void m4717cx(View view) {
        AppMethodBeat.m2504i(133444);
        if (view.getVisibility() != 0) {
            view.setAlpha(0.0f);
            view.setVisibility(0);
        }
        view.animate().setDuration(200).alpha(1.0f).withEndAction(null).start();
        AppMethodBeat.m2505o(133444);
    }
}
