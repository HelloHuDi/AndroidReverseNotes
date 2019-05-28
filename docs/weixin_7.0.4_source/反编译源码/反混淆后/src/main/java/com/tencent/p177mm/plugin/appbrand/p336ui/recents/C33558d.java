package com.tencent.p177mm.plugin.appbrand.p336ui.recents;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.modelappbrand.p873a.C32804a;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.plugin.appbrand.p336ui.widget.C10929a;
import com.tencent.p177mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.d */
public abstract class C33558d<_DataSource extends C7296k> extends C27336a implements OnClickListener {
    /* renamed from: Dx */
    private boolean f15038Dx;
    private final int eop;
    private final int eoq;
    private final int eor;
    private final int eos = -1;
    private final Class iLZ;
    private final C10929a iMa;
    protected final int iMb = 4;
    private ViewGroup iMc;
    protected AppBrandNearbyShowcaseView iMd;
    private volatile List<LocalUsageInfo> iMe;
    private ImageView iMf;
    private final OnPreDrawListener iMg = new C335611();
    private final C4931a iMh = new C335604();
    private Activity mActivity;

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.d$2 */
    class C335592 implements Runnable {
        C335592() {
        }

        public final void run() {
            AppMethodBeat.m2504i(133326);
            List aNk = C33558d.this.aNk();
            if (C5046bo.m7548ek(aNk)) {
                AppMethodBeat.m2505o(133326);
                return;
            }
            C33558d.m54787a(C33558d.this, aNk);
            AppMethodBeat.m2505o(133326);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.d$4 */
    class C335604 implements C4931a {
        C335604() {
        }

        /* renamed from: a */
        public final void mo5248a(String str, C4935m c4935m) {
            AppMethodBeat.m2504i(133328);
            C33558d.this.iMe;
            C33558d.m54787a(C33558d.this, C33558d.this.aNk());
            AppMethodBeat.m2505o(133328);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.recents.d$1 */
    class C335611 implements OnPreDrawListener {
        C335611() {
        }

        public final boolean onPreDraw() {
            AppMethodBeat.m2504i(133325);
            C33558d.this.iMc.getViewTreeObserver().removeOnPreDrawListener(this);
            C33558d.m54789b(C33558d.this);
            AppMethodBeat.m2505o(133325);
            return true;
        }
    }

    public abstract List<LocalUsageInfo> aNk();

    public abstract String getTitle();

    C33558d(Class<_DataSource> cls, Activity activity, ViewGroup viewGroup) {
        this.mActivity = activity;
        this.iLZ = cls;
        this.eop = C1338a.fromDPToPix(activity, 25);
        this.eoq = C1338a.fromDPToPix(activity, 19);
        this.eor = C1338a.fromDPToPix(activity, 2);
        this.iMa = new C10929a(this.eop, this.eor);
        this.iMc = (ViewGroup) LayoutInflater.from(activity).inflate(2130968714, viewGroup, false);
        this.iMc.setOnClickListener(this);
        ((TextView) this.iMc.findViewById(2131820678)).setText(getTitle());
        this.iMf = (ImageView) this.iMc.findViewById(2131821332);
        this.iMd = (AppBrandNearbyShowcaseView) this.iMc.findViewById(2131821330);
        this.iMd.setIconLayerCount(4);
        this.iMd.setIconSize(this.eop + (this.eor * 2));
        this.iMd.setIconGap(this.eoq);
    }

    /* Access modifiers changed, original: protected|final */
    public final Activity getActivity() {
        return this.mActivity;
    }

    public final void aNh() {
        this.f15038Dx = true;
        mo45020eG(true);
        this.iMc.getViewTreeObserver().addOnPreDrawListener(this.iMg);
    }

    public final void onDetached() {
        this.f15038Dx = false;
        this.iMc.getViewTreeObserver().removeOnPreDrawListener(this.iMg);
        C42340f.auO().mo10117d(this.iMh);
        ((C7296k) C42340f.m74878E(this.iLZ)).mo10117d(this.iMh);
    }

    public final void onResume() {
    }

    public final View aNi() {
        return this.iMc;
    }

    /* renamed from: pS */
    public final void mo6437pS(int i) {
        if (this.iMf != null) {
            this.iMf.setVisibility(i);
        }
        TextView textView = (TextView) this.iMc.findViewById(2131820678);
        LayoutParams layoutParams = (LayoutParams) textView.getLayoutParams();
        layoutParams.leftMargin = this.iMc.getResources().getDimensionPixelOffset(C25738R.dimen.f10153ro);
        textView.setLayoutParams(layoutParams);
    }

    /* renamed from: pT */
    public final void mo6438pT(int i) {
        this.iMc.setBackgroundResource(i);
    }

    public void onClick(View view) {
    }

    /* renamed from: b */
    static /* synthetic */ void m54789b(C33558d c33558d) {
        C42340f.auO().mo10114a(c33558d.iMh, C42677e.aNS().oAl.getLooper());
        ((C7296k) C42340f.m74878E(c33558d.iLZ)).mo10114a(c33558d.iMh, C42677e.aNS().oAl.getLooper());
        C42677e.aNS().mo10302aa(new C335592());
    }

    /* renamed from: a */
    static /* synthetic */ void m54787a(C33558d c33558d, List list) {
        if (list == null) {
            list = new ArrayList(0);
        }
        c33558d.mActivity.runOnUiThread(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(133327);
                if (C33558d.this.f15038Dx) {
                    C33558d.this.iMe = list;
                    int min = Math.min(4, list.size());
                    C33558d.this.iMd.setIconLayerCount(min);
                    int i = 0;
                    for (LocalUsageInfo localUsageInfo : list) {
                        if (min == i) {
                            AppMethodBeat.m2505o(133327);
                            return;
                        }
                        int i2 = i + 1;
                        C37926b.abR().mo60683a(C33558d.this.iMd.mo54072qf(i), localUsageInfo.haO, C32804a.abQ(), C33558d.this.iMa);
                        i = i2;
                    }
                    if (C5046bo.m7548ek(list)) {
                        C33558d.this.iMd.mo54070eO(true);
                        AppMethodBeat.m2505o(133327);
                        return;
                    }
                    C33558d.this.iMd.aOB();
                    AppMethodBeat.m2505o(133327);
                    return;
                }
                AppMethodBeat.m2505o(133327);
            }
        });
    }
}
