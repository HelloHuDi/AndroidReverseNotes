package com.tencent.mm.plugin.appbrand.ui.recents;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.plugin.appbrand.ui.widget.a;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

public abstract class d<_DataSource extends k> extends a implements OnClickListener {
    private boolean Dx;
    private final int eop;
    private final int eoq;
    private final int eor;
    private final int eos = -1;
    private final Class iLZ;
    private final a iMa;
    protected final int iMb = 4;
    private ViewGroup iMc;
    protected AppBrandNearbyShowcaseView iMd;
    private volatile List<LocalUsageInfo> iMe;
    private ImageView iMf;
    private final OnPreDrawListener iMg = new OnPreDrawListener() {
        public final boolean onPreDraw() {
            AppMethodBeat.i(133325);
            d.this.iMc.getViewTreeObserver().removeOnPreDrawListener(this);
            d.b(d.this);
            AppMethodBeat.o(133325);
            return true;
        }
    };
    private final k.a iMh = new k.a() {
        public final void a(String str, m mVar) {
            AppMethodBeat.i(133328);
            d.this.iMe;
            d.a(d.this, d.this.aNk());
            AppMethodBeat.o(133328);
        }
    };
    private Activity mActivity;

    public abstract List<LocalUsageInfo> aNk();

    public abstract String getTitle();

    d(Class<_DataSource> cls, Activity activity, ViewGroup viewGroup) {
        this.mActivity = activity;
        this.iLZ = cls;
        this.eop = com.tencent.mm.bz.a.fromDPToPix(activity, 25);
        this.eoq = com.tencent.mm.bz.a.fromDPToPix(activity, 19);
        this.eor = com.tencent.mm.bz.a.fromDPToPix(activity, 2);
        this.iMa = new a(this.eop, this.eor);
        this.iMc = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.d1, viewGroup, false);
        this.iMc.setOnClickListener(this);
        ((TextView) this.iMc.findViewById(R.id.cx)).setText(getTitle());
        this.iMf = (ImageView) this.iMc.findViewById(R.id.ul);
        this.iMd = (AppBrandNearbyShowcaseView) this.iMc.findViewById(R.id.uj);
        this.iMd.setIconLayerCount(4);
        this.iMd.setIconSize(this.eop + (this.eor * 2));
        this.iMd.setIconGap(this.eoq);
    }

    /* Access modifiers changed, original: protected|final */
    public final Activity getActivity() {
        return this.mActivity;
    }

    public final void aNh() {
        this.Dx = true;
        eG(true);
        this.iMc.getViewTreeObserver().addOnPreDrawListener(this.iMg);
    }

    public final void onDetached() {
        this.Dx = false;
        this.iMc.getViewTreeObserver().removeOnPreDrawListener(this.iMg);
        f.auO().d(this.iMh);
        ((k) f.E(this.iLZ)).d(this.iMh);
    }

    public final void onResume() {
    }

    public final View aNi() {
        return this.iMc;
    }

    public final void pS(int i) {
        if (this.iMf != null) {
            this.iMf.setVisibility(i);
        }
        TextView textView = (TextView) this.iMc.findViewById(R.id.cx);
        LayoutParams layoutParams = (LayoutParams) textView.getLayoutParams();
        layoutParams.leftMargin = this.iMc.getResources().getDimensionPixelOffset(R.dimen.ro);
        textView.setLayoutParams(layoutParams);
    }

    public final void pT(int i) {
        this.iMc.setBackgroundResource(i);
    }

    public void onClick(View view) {
    }

    static /* synthetic */ void b(d dVar) {
        f.auO().a(dVar.iMh, e.aNS().oAl.getLooper());
        ((k) f.E(dVar.iLZ)).a(dVar.iMh, e.aNS().oAl.getLooper());
        e.aNS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(133326);
                List aNk = d.this.aNk();
                if (bo.ek(aNk)) {
                    AppMethodBeat.o(133326);
                    return;
                }
                d.a(d.this, aNk);
                AppMethodBeat.o(133326);
            }
        });
    }

    static /* synthetic */ void a(d dVar, List list) {
        if (list == null) {
            list = new ArrayList(0);
        }
        dVar.mActivity.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.i(133327);
                if (d.this.Dx) {
                    d.this.iMe = list;
                    int min = Math.min(4, list.size());
                    d.this.iMd.setIconLayerCount(min);
                    int i = 0;
                    for (LocalUsageInfo localUsageInfo : list) {
                        if (min == i) {
                            AppMethodBeat.o(133327);
                            return;
                        }
                        int i2 = i + 1;
                        b.abR().a(d.this.iMd.qf(i), localUsageInfo.haO, com.tencent.mm.modelappbrand.a.a.abQ(), d.this.iMa);
                        i = i2;
                    }
                    if (bo.ek(list)) {
                        d.this.iMd.eO(true);
                        AppMethodBeat.o(133327);
                        return;
                    }
                    d.this.iMd.aOB();
                    AppMethodBeat.o(133327);
                    return;
                }
                AppMethodBeat.o(133327);
            }
        });
    }
}
