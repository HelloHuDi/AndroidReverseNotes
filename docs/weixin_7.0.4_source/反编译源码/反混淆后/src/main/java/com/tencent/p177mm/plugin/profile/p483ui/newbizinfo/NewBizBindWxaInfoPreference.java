package com.tencent.p177mm.plugin.profile.p483ui.newbizinfo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelappbrand.p873a.C32804a;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C37926b.C37932f;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.p612ui.widget.ThreeDotsLoadingView;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.p177mm.plugin.appbrand.p336ui.widget.C10929a;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.service.C19731g;
import com.tencent.p177mm.plugin.appbrand.service.C45691e;
import com.tencent.p177mm.plugin.appbrand.widget.AppBrandNearbyShowcaseView;
import com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p484c.C34739c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizBindWxaInfoPreference */
public class NewBizBindWxaInfoPreference extends Preference {
    private static final int eop = C1338a.fromDPToPix(C4996ah.getContext(), 25);
    private static final int eoq = C1338a.fromDPToPix(C4996ah.getContext(), 20);
    private static final int eor = C1338a.fromDPToPix(C4996ah.getContext(), 2);
    private Context context;
    private C37932f eoo;
    private ThreeDotsLoadingView iDW;
    private AppBrandNearbyShowcaseView iMd;
    private View iQN;
    private boolean iQO = false;
    private List<WxaEntryInfo> iUl;
    private OnClickListener lBl;
    private View mView = null;
    private OnClickListener pkL;
    private C16527d pkW;

    /* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizBindWxaInfoPreference$2 */
    class C36382 implements OnClickListener {
        C36382() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(23828);
            ((C19731g) C1720g.m3528K(C19731g.class)).mo34963a(NewBizBindWxaInfoPreference.this.mContext, NewBizBindWxaInfoPreference.this.pkW.field_username, NewBizBindWxaInfoPreference.this.pkW.field_appId, NewBizBindWxaInfoPreference.this.iUl);
            AppMethodBeat.m2505o(23828);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.NewBizBindWxaInfoPreference$1 */
    class C36401 implements OnClickListener {
        C36401() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(23827);
            Object tag = view.getTag();
            if (tag == null || !(tag instanceof String)) {
                C4990ab.m7412e("MicroMsg.NewBizBindWxaInfoPreference", "username is null, err");
                AppMethodBeat.m2505o(23827);
                return;
            }
            C4990ab.m7417i("MicroMsg.NewBizBindWxaInfoPreference", "jump to wxa:%s", (String) tag);
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1020;
            appBrandStatObject.cst = NewBizBindWxaInfoPreference.this.pkW.field_username;
            ((C45691e) C1720g.m3528K(C45691e.class)).mo68046a(NewBizBindWxaInfoPreference.this.mContext, (String) tag, null, 0, 0, null, appBrandStatObject, NewBizBindWxaInfoPreference.this.pkW.field_appId);
            C34739c.m57055cP(NewBizBindWxaInfoPreference.this.pkW.field_username, 500);
            AppMethodBeat.m2505o(23827);
        }
    }

    public NewBizBindWxaInfoPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(23831);
        this.context = context;
        init();
        AppMethodBeat.m2505o(23831);
    }

    public NewBizBindWxaInfoPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(23832);
        this.context = context;
        init();
        AppMethodBeat.m2505o(23832);
    }

    private void init() {
        AppMethodBeat.m2504i(23833);
        this.lBl = new C36401();
        this.pkL = new C36382();
        AppMethodBeat.m2505o(23833);
    }

    public final View getView(View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(23834);
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        View view2 = this.mView;
        AppMethodBeat.m2505o(23834);
        return view2;
    }

    public final void onBindView(View view) {
        AppMethodBeat.m2504i(23835);
        super.onBindView(view);
        this.iQN = view.findViewById(2131822973);
        this.iDW = (ThreeDotsLoadingView) view.findViewById(2131822975);
        this.iMd = (AppBrandNearbyShowcaseView) view.findViewById(2131822974);
        this.iMd.setIconSize(eop + (eor * 2));
        this.iMd.setIconGap(eoq);
        m5970ou();
        AppMethodBeat.m2505o(23835);
    }

    /* renamed from: a */
    public final void mo8225a(C16527d c16527d, List<WxaEntryInfo> list) {
        AppMethodBeat.m2504i(23836);
        this.pkW = c16527d;
        if (this.iUl == null) {
            this.iUl = new LinkedList();
        } else {
            this.iUl.clear();
        }
        if (!(list == null || list.isEmpty())) {
            this.iUl.addAll(list);
        }
        m5970ou();
        AppMethodBeat.m2505o(23836);
    }

    /* renamed from: ou */
    private void m5970ou() {
        AppMethodBeat.m2504i(23837);
        if (this.iDW == null) {
            C4990ab.m7416i("MicroMsg.NewBizBindWxaInfoPreference", "startLoad or mLoadingView is null");
            AppMethodBeat.m2505o(23837);
        } else if (this.iQO) {
            C4990ab.m7416i("MicroMsg.NewBizBindWxaInfoPreference", "startLoad has load.");
            AppMethodBeat.m2505o(23837);
        } else {
            this.iQO = true;
            m5969cw(this.iQN);
            NewBizBindWxaInfoPreference.m5968c(this.iDW, null);
            this.iDW.dKS();
            azx();
            AppMethodBeat.m2505o(23837);
        }
    }

    static {
        AppMethodBeat.m2504i(23841);
        AppMethodBeat.m2505o(23841);
    }

    private void azx() {
        AppMethodBeat.m2504i(23838);
        if (this.pkW == null || this.iUl == null) {
            C4990ab.m7420w("MicroMsg.NewBizBindWxaInfoPreference", "mWxaEntryInfoList or bizInfo is null, return");
            AppMethodBeat.m2505o(23838);
            return;
        }
        this.iDW.dKT();
        m5969cw(this.iDW);
        if (this.iUl.size() > 0) {
            this.iMd.setVisibility(0);
            this.iMd.setIconLayerCount(Math.min(this.iUl.size(), 4));
            final boolean z = this.iQN.getVisibility() != 0;
            if (z) {
                this.iMd.mo54070eO(false);
            }
            if (this.eoo == null) {
                this.eoo = new C10929a(eop, eor);
            }
            for (int i = 0; i < this.iMd.getChildCount(); i++) {
                String str;
                C37926b abR = C37926b.abR();
                ImageView qf = this.iMd.mo54072qf(i);
                if (this.iUl.size() > i) {
                    str = ((WxaEntryInfo) this.iUl.get(i)).iconUrl;
                } else {
                    str = null;
                }
                abR.mo60683a(qf, str, C32804a.abQ(), this.eoo);
            }
            NewBizBindWxaInfoPreference.m5968c(this.iQN, new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(23829);
                    if (z && NewBizBindWxaInfoPreference.this.iMd != null) {
                        NewBizBindWxaInfoPreference.this.iMd.aOB();
                    }
                    AppMethodBeat.m2505o(23829);
                }
            });
            if (this.iUl.size() == 1) {
                this.mView.setTag(((WxaEntryInfo) this.iUl.get(0)).username);
                this.mView.setOnClickListener(this.lBl);
                AppMethodBeat.m2505o(23838);
                return;
            }
            this.mView.setTag(null);
            this.mView.setOnClickListener(this.pkL);
            AppMethodBeat.m2505o(23838);
            return;
        }
        this.iMd.setVisibility(8);
        AppMethodBeat.m2505o(23838);
    }

    /* renamed from: c */
    private static void m5968c(View view, Runnable runnable) {
        AppMethodBeat.m2504i(23839);
        if (view.getVisibility() != 0) {
            view.setAlpha(0.0f);
            view.setVisibility(0);
        }
        view.animate().setDuration(200).alpha(1.0f).withEndAction(runnable).start();
        AppMethodBeat.m2505o(23839);
    }

    /* renamed from: cw */
    private void m5969cw(final View view) {
        AppMethodBeat.m2504i(23840);
        if (view.getVisibility() == 0) {
            view.animate().setDuration(200).alpha(0.0f).withEndAction(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(23830);
                    view.setVisibility(8);
                    AppMethodBeat.m2505o(23830);
                }
            }).start();
        }
        AppMethodBeat.m2505o(23840);
    }
}
