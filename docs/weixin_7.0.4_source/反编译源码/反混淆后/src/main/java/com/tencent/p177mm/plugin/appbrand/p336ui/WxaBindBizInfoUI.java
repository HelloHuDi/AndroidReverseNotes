package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.modelappbrand.p873a.C32804a;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C42201f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.widget.ThreeDotsLoadingView;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.p177mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.p177mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.C11052a;
import com.tencent.p177mm.plugin.appbrand.widget.recyclerview.MRecyclerView.C2594a;
import com.tencent.p177mm.protocal.protobuf.C23369arg;
import com.tencent.p177mm.protocal.protobuf.C23403jd;
import com.tencent.p177mm.protocal.protobuf.arf;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.WxaBindBizInfoUI */
public class WxaBindBizInfoUI extends MMActivity {
    private ThreeDotsLoadingView iDW;
    private String iJF;
    C44717a iJG;
    private LoadMoreRecyclerView iJH;
    private View iJI;
    private String mAppId;

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.WxaBindBizInfoUI$1 */
    class C197651 implements OnMenuItemClickListener {
        C197651() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(133189);
            WxaBindBizInfoUI.this.finish();
            AppMethodBeat.m2505o(133189);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.WxaBindBizInfoUI$b */
    static class C27322b extends C41531v {
        TextView gne;
        View goc;
        ImageView iyo;

        public C27322b(View view) {
            super(view);
            AppMethodBeat.m2504i(133200);
            this.iyo = (ImageView) view.findViewById(2131820915);
            this.gne = (TextView) view.findViewById(2131820649);
            this.goc = view.findViewById(2131821128);
            AppMethodBeat.m2505o(133200);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.WxaBindBizInfoUI$3 */
    class C412543 implements C11052a {

        /* renamed from: com.tencent.mm.plugin.appbrand.ui.WxaBindBizInfoUI$3$1 */
        class C412551 implements C1224a {
            C412551() {
            }

            /* renamed from: a */
            public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                AppMethodBeat.m2504i(133191);
                if (i == 0 && i2 == 0) {
                    C23369arg c23369arg = (C23369arg) c7472b.fsH.fsP;
                    LinkedList linkedList = c23369arg.wvi;
                    boolean z = c23369arg.wvj;
                    WxaBindBizInfoUI.this.iJF = c23369arg.wvh;
                    if (z) {
                        WxaBindBizInfoUI.this.iJH.mo22757fh(false);
                        WxaBindBizInfoUI.this.iDW.dKT();
                        WxaBindBizInfoUI.this.iJG.iJM = true;
                        WxaBindBizInfoUI.this.iJI.setVisibility(0);
                    }
                    if (!(linkedList == null || linkedList.isEmpty())) {
                        LinkedList linkedList2 = new LinkedList();
                        Iterator it = linkedList.iterator();
                        while (it.hasNext()) {
                            C23403jd c23403jd = (C23403jd) it.next();
                            if (c23403jd != null) {
                                WxaEntryInfo wxaEntryInfo = new WxaEntryInfo();
                                wxaEntryInfo.title = c23403jd.nickname;
                                wxaEntryInfo.iconUrl = c23403jd.kKZ;
                                wxaEntryInfo.username = c23403jd.username;
                                linkedList2.add(wxaEntryInfo);
                            }
                        }
                        WxaBindBizInfoUI.this.iJG.mo71780aN(linkedList2);
                    }
                    AppMethodBeat.m2505o(133191);
                } else {
                    C4990ab.m7413e("MicroMsg.WxaBindBizInfoUI", "onResp, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    AppMethodBeat.m2505o(133191);
                }
                return 0;
            }
        }

        C412543() {
        }

        public final void aMC() {
            AppMethodBeat.m2504i(133192);
            arf arf = new arf();
            arf.csB = WxaBindBizInfoUI.this.mAppId;
            arf.wvh = WxaBindBizInfoUI.this.iJF;
            C1196a c1196a = new C1196a();
            c1196a.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getwxabindbizinfo";
            c1196a.fsI = 1823;
            c1196a.fsJ = arf;
            c1196a.fsK = new C23369arg();
            C1226w.m2655a(c1196a.acD(), new C412551(), false);
            AppMethodBeat.m2505o(133192);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.WxaBindBizInfoUI$a */
    static class C44717a extends C41523a {
        private final List<WxaEntryInfo> iJL;
        boolean iJM = true;
        private LayoutInflater mInflater;

        public C44717a(LayoutInflater layoutInflater) {
            AppMethodBeat.m2504i(133193);
            this.mInflater = layoutInflater;
            this.iJL = new LinkedList();
            AppMethodBeat.m2505o(133193);
        }

        /* renamed from: a */
        public final C41531v mo4976a(ViewGroup viewGroup, int i) {
            AppMethodBeat.m2504i(133194);
            C27322b c27322b = new C27322b(this.mInflater.inflate(2130968692, viewGroup, false));
            AppMethodBeat.m2505o(133194);
            return c27322b;
        }

        /* renamed from: a */
        public final void mo4977a(C41531v c41531v, int i) {
            int i2 = 0;
            AppMethodBeat.m2504i(133195);
            WxaEntryInfo pQ = mo71781pQ(i);
            if (pQ == null) {
                C4990ab.m7417i("MicroMsg.WxaBindBizInfoUI", "onBindViewHolder failed, getItem(%d) return null", Integer.valueOf(i));
                AppMethodBeat.m2505o(133195);
                return;
            }
            C27322b c27322b = (C27322b) c41531v;
            C37926b.abR().mo60683a(c27322b.iyo, pQ.iconUrl, C32804a.abQ(), C42201f.fqH);
            c27322b.gne.setText(C5046bo.nullAsNil(pQ.title));
            if (this.iJM) {
                View view = c27322b.goc;
                if (this.iJL.size() - 1 == i) {
                    i2 = 8;
                }
                view.setVisibility(i2);
            }
            AppMethodBeat.m2505o(133195);
        }

        public final int getItemCount() {
            AppMethodBeat.m2504i(133196);
            int size = this.iJL.size();
            AppMethodBeat.m2505o(133196);
            return size;
        }

        /* renamed from: pQ */
        public final WxaEntryInfo mo71781pQ(int i) {
            AppMethodBeat.m2504i(133197);
            if (i < 0 || i >= getItemCount()) {
                AppMethodBeat.m2505o(133197);
                return null;
            }
            WxaEntryInfo wxaEntryInfo = (WxaEntryInfo) this.iJL.get(i);
            AppMethodBeat.m2505o(133197);
            return wxaEntryInfo;
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: aN */
        public final void mo71780aN(List<WxaEntryInfo> list) {
            AppMethodBeat.m2504i(133198);
            if (list == null || list.isEmpty()) {
                AppMethodBeat.m2505o(133198);
                return;
            }
            LinkedList linkedList = new LinkedList();
            for (WxaEntryInfo wxaEntryInfo : list) {
                if (!contains(wxaEntryInfo.username)) {
                    linkedList.add(wxaEntryInfo);
                }
            }
            this.iJL.addAll(linkedList);
            mo66308ar(this.iJL.size() - list.size(), list.size());
            AppMethodBeat.m2505o(133198);
        }

        private boolean contains(String str) {
            AppMethodBeat.m2504i(133199);
            if (str == null || str.length() == 0) {
                AppMethodBeat.m2505o(133199);
                return false;
            }
            for (WxaEntryInfo wxaEntryInfo : this.iJL) {
                if (str.equals(wxaEntryInfo.username)) {
                    AppMethodBeat.m2505o(133199);
                    return true;
                }
            }
            AppMethodBeat.m2505o(133199);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.WxaBindBizInfoUI$2 */
    class C456962 implements C2594a {
        C456962() {
        }

        /* renamed from: I */
        public final void mo6645I(View view, int i) {
            AppMethodBeat.m2504i(133190);
            WxaEntryInfo pQ = WxaBindBizInfoUI.this.iJG.mo71781pQ(i);
            if (pQ == null) {
                AppMethodBeat.m2505o(133190);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("Contact_User", pQ.username);
            intent.putExtra("key_start_biz_profile_from_app_brand_profile", true);
            intent.putExtra("key_use_new_contact_profile", true);
            intent.putExtra("force_get_contact", true);
            C25985d.m41467b(WxaBindBizInfoUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            AppMethodBeat.m2505o(133190);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(133201);
        super.onCreate(bundle);
        setBackBtn(new C197651(), C1318a.actionbar_icon_dark_back);
        setMMTitle((int) C25738R.string.f9014mh);
        mo17443ta(WebView.NIGHT_MODE_COLOR);
        mo17446xE(-855310);
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("wxa_entry_info_list");
        this.mAppId = getIntent().getStringExtra("app_id");
        this.iJH = (LoadMoreRecyclerView) findViewById(2131821796);
        this.iJG = new C44717a(getLayoutInflater());
        this.iJH.setOnItemClickListener(new C456962());
        this.iJG.mo71780aN(parcelableArrayListExtra);
        this.iJH.setItemAnimator(null);
        this.iJH.setOnLoadingStateChangedListener(new C412543());
        this.iJH.setAdapter(this.iJG);
        View inflate = getLayoutInflater().inflate(2130971241, this.iJH, false);
        this.iDW = (ThreeDotsLoadingView) inflate.findViewById(2131821325);
        this.iDW.dKS();
        this.iJH.setLoadingView(inflate);
        this.iJI = getLayoutInflater().inflate(2130971242, this.iJH, false);
        this.iJH.addFooterView(this.iJI);
        this.iJI.setVisibility(8);
        if (this.iJG.getItemCount() > 20) {
            this.iJH.mo22757fh(true);
            this.iJG.iJM = false;
        }
        this.mController.contentView.setBackgroundColor(-855310);
        AppMethodBeat.m2505o(133201);
    }

    public final int getLayoutId() {
        return 2130971240;
    }
}
