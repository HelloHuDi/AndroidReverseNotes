package com.tencent.mm.plugin.profile.ui.newbizinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.d;
import com.tencent.mm.bz.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.f;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.e;
import com.tencent.mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.mm.plugin.profile.ui.newbizinfo.c.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.LinkedList;
import java.util.List;

public class NewBizBindWxaInfoPreference extends Preference {
    private static final int eop = a.fromDPToPix(ah.getContext(), 25);
    private static final int eoq = a.fromDPToPix(ah.getContext(), 20);
    private static final int eor = a.fromDPToPix(ah.getContext(), 2);
    private Context context;
    private f eoo;
    private ThreeDotsLoadingView iDW;
    private AppBrandNearbyShowcaseView iMd;
    private View iQN;
    private boolean iQO = false;
    private List<WxaEntryInfo> iUl;
    private OnClickListener lBl;
    private View mView = null;
    private OnClickListener pkL;
    private d pkW;

    public NewBizBindWxaInfoPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(23831);
        this.context = context;
        init();
        AppMethodBeat.o(23831);
    }

    public NewBizBindWxaInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(23832);
        this.context = context;
        init();
        AppMethodBeat.o(23832);
    }

    private void init() {
        AppMethodBeat.i(23833);
        this.lBl = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(23827);
                Object tag = view.getTag();
                if (tag == null || !(tag instanceof String)) {
                    ab.e("MicroMsg.NewBizBindWxaInfoPreference", "username is null, err");
                    AppMethodBeat.o(23827);
                    return;
                }
                ab.i("MicroMsg.NewBizBindWxaInfoPreference", "jump to wxa:%s", (String) tag);
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = 1020;
                appBrandStatObject.cst = NewBizBindWxaInfoPreference.this.pkW.field_username;
                ((e) g.K(e.class)).a(NewBizBindWxaInfoPreference.this.mContext, (String) tag, null, 0, 0, null, appBrandStatObject, NewBizBindWxaInfoPreference.this.pkW.field_appId);
                c.cP(NewBizBindWxaInfoPreference.this.pkW.field_username, 500);
                AppMethodBeat.o(23827);
            }
        };
        this.pkL = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(23828);
                ((com.tencent.mm.plugin.appbrand.service.g) g.K(com.tencent.mm.plugin.appbrand.service.g.class)).a(NewBizBindWxaInfoPreference.this.mContext, NewBizBindWxaInfoPreference.this.pkW.field_username, NewBizBindWxaInfoPreference.this.pkW.field_appId, NewBizBindWxaInfoPreference.this.iUl);
                AppMethodBeat.o(23828);
            }
        };
        AppMethodBeat.o(23833);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.i(23834);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.o(23834);
        return view2;
    }

    public final void onBindView(View view) {
        AppMethodBeat.i(23835);
        super.onBindView(view);
        this.iQN = view.findViewById(R.id.b1n);
        this.iDW = (ThreeDotsLoadingView) view.findViewById(R.id.b1p);
        this.iMd = (AppBrandNearbyShowcaseView) view.findViewById(R.id.b1o);
        this.iMd.setIconSize(eop + (eor * 2));
        this.iMd.setIconGap(eoq);
        ou();
        AppMethodBeat.o(23835);
    }

    public final void a(d dVar, List<WxaEntryInfo> list) {
        AppMethodBeat.i(23836);
        this.pkW = dVar;
        if (this.iUl == null) {
            this.iUl = new LinkedList();
        } else {
            this.iUl.clear();
        }
        if (!(list == null || list.isEmpty())) {
            this.iUl.addAll(list);
        }
        ou();
        AppMethodBeat.o(23836);
    }

    private void ou() {
        AppMethodBeat.i(23837);
        if (this.iDW == null) {
            ab.i("MicroMsg.NewBizBindWxaInfoPreference", "startLoad or mLoadingView is null");
            AppMethodBeat.o(23837);
        } else if (this.iQO) {
            ab.i("MicroMsg.NewBizBindWxaInfoPreference", "startLoad has load.");
            AppMethodBeat.o(23837);
        } else {
            this.iQO = true;
            cw(this.iQN);
            c(this.iDW, null);
            this.iDW.dKS();
            azx();
            AppMethodBeat.o(23837);
        }
    }

    static {
        AppMethodBeat.i(23841);
        AppMethodBeat.o(23841);
    }

    private void azx() {
        AppMethodBeat.i(23838);
        if (this.pkW == null || this.iUl == null) {
            ab.w("MicroMsg.NewBizBindWxaInfoPreference", "mWxaEntryInfoList or bizInfo is null, return");
            AppMethodBeat.o(23838);
            return;
        }
        this.iDW.dKT();
        cw(this.iDW);
        if (this.iUl.size() > 0) {
            this.iMd.setVisibility(0);
            this.iMd.setIconLayerCount(Math.min(this.iUl.size(), 4));
            final boolean z = this.iQN.getVisibility() != 0;
            if (z) {
                this.iMd.eO(false);
            }
            if (this.eoo == null) {
                this.eoo = new com.tencent.mm.plugin.appbrand.ui.widget.a(eop, eor);
            }
            for (int i = 0; i < this.iMd.getChildCount(); i++) {
                String str;
                b abR = b.abR();
                ImageView qf = this.iMd.qf(i);
                if (this.iUl.size() > i) {
                    str = ((WxaEntryInfo) this.iUl.get(i)).iconUrl;
                } else {
                    str = null;
                }
                abR.a(qf, str, com.tencent.mm.modelappbrand.a.a.abQ(), this.eoo);
            }
            c(this.iQN, new Runnable() {
                public final void run() {
                    AppMethodBeat.i(23829);
                    if (z && NewBizBindWxaInfoPreference.this.iMd != null) {
                        NewBizBindWxaInfoPreference.this.iMd.aOB();
                    }
                    AppMethodBeat.o(23829);
                }
            });
            if (this.iUl.size() == 1) {
                this.mView.setTag(((WxaEntryInfo) this.iUl.get(0)).username);
                this.mView.setOnClickListener(this.lBl);
                AppMethodBeat.o(23838);
                return;
            }
            this.mView.setTag(null);
            this.mView.setOnClickListener(this.pkL);
            AppMethodBeat.o(23838);
            return;
        }
        this.iMd.setVisibility(8);
        AppMethodBeat.o(23838);
    }

    private static void c(View view, Runnable runnable) {
        AppMethodBeat.i(23839);
        if (view.getVisibility() != 0) {
            view.setAlpha(0.0f);
            view.setVisibility(0);
        }
        view.animate().setDuration(200).alpha(1.0f).withEndAction(runnable).start();
        AppMethodBeat.o(23839);
    }

    private void cw(final View view) {
        AppMethodBeat.i(23840);
        if (view.getVisibility() == 0) {
            view.animate().setDuration(200).alpha(0.0f).withEndAction(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(23830);
                    view.setVisibility(8);
                    AppMethodBeat.o(23830);
                }
            }).start();
        }
        AppMethodBeat.o(23840);
    }
}
