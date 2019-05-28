package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView.v;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.bp.d;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.jd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WxaBindBizInfoUI extends MMActivity {
    private ThreeDotsLoadingView iDW;
    private String iJF;
    a iJG;
    private LoadMoreRecyclerView iJH;
    private View iJI;
    private String mAppId;

    static class b extends v {
        TextView gne;
        View goc;
        ImageView iyo;

        public b(View view) {
            super(view);
            AppMethodBeat.i(133200);
            this.iyo = (ImageView) view.findViewById(R.id.jb);
            this.gne = (TextView) view.findViewById(R.id.c5);
            this.goc = view.findViewById(R.id.p3);
            AppMethodBeat.o(133200);
        }
    }

    static class a extends android.support.v7.widget.RecyclerView.a {
        private final List<WxaEntryInfo> iJL;
        boolean iJM = true;
        private LayoutInflater mInflater;

        public a(LayoutInflater layoutInflater) {
            AppMethodBeat.i(133193);
            this.mInflater = layoutInflater;
            this.iJL = new LinkedList();
            AppMethodBeat.o(133193);
        }

        public final v a(ViewGroup viewGroup, int i) {
            AppMethodBeat.i(133194);
            b bVar = new b(this.mInflater.inflate(R.layout.cf, viewGroup, false));
            AppMethodBeat.o(133194);
            return bVar;
        }

        public final void a(v vVar, int i) {
            int i2 = 0;
            AppMethodBeat.i(133195);
            WxaEntryInfo pQ = pQ(i);
            if (pQ == null) {
                ab.i("MicroMsg.WxaBindBizInfoUI", "onBindViewHolder failed, getItem(%d) return null", Integer.valueOf(i));
                AppMethodBeat.o(133195);
                return;
            }
            b bVar = (b) vVar;
            com.tencent.mm.modelappbrand.a.b.abR().a(bVar.iyo, pQ.iconUrl, com.tencent.mm.modelappbrand.a.a.abQ(), f.fqH);
            bVar.gne.setText(bo.nullAsNil(pQ.title));
            if (this.iJM) {
                View view = bVar.goc;
                if (this.iJL.size() - 1 == i) {
                    i2 = 8;
                }
                view.setVisibility(i2);
            }
            AppMethodBeat.o(133195);
        }

        public final int getItemCount() {
            AppMethodBeat.i(133196);
            int size = this.iJL.size();
            AppMethodBeat.o(133196);
            return size;
        }

        public final WxaEntryInfo pQ(int i) {
            AppMethodBeat.i(133197);
            if (i < 0 || i >= getItemCount()) {
                AppMethodBeat.o(133197);
                return null;
            }
            WxaEntryInfo wxaEntryInfo = (WxaEntryInfo) this.iJL.get(i);
            AppMethodBeat.o(133197);
            return wxaEntryInfo;
        }

        /* Access modifiers changed, original: protected|final */
        public final void aN(List<WxaEntryInfo> list) {
            AppMethodBeat.i(133198);
            if (list == null || list.isEmpty()) {
                AppMethodBeat.o(133198);
                return;
            }
            LinkedList linkedList = new LinkedList();
            for (WxaEntryInfo wxaEntryInfo : list) {
                if (!contains(wxaEntryInfo.username)) {
                    linkedList.add(wxaEntryInfo);
                }
            }
            this.iJL.addAll(linkedList);
            ar(this.iJL.size() - list.size(), list.size());
            AppMethodBeat.o(133198);
        }

        private boolean contains(String str) {
            AppMethodBeat.i(133199);
            if (str == null || str.length() == 0) {
                AppMethodBeat.o(133199);
                return false;
            }
            for (WxaEntryInfo wxaEntryInfo : this.iJL) {
                if (str.equals(wxaEntryInfo.username)) {
                    AppMethodBeat.o(133199);
                    return true;
                }
            }
            AppMethodBeat.o(133199);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(133201);
        super.onCreate(bundle);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(133189);
                WxaBindBizInfoUI.this.finish();
                AppMethodBeat.o(133189);
                return false;
            }
        }, R.raw.actionbar_icon_dark_back);
        setMMTitle((int) R.string.mh);
        ta(WebView.NIGHT_MODE_COLOR);
        xE(-855310);
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("wxa_entry_info_list");
        this.mAppId = getIntent().getStringExtra("app_id");
        this.iJH = (LoadMoreRecyclerView) findViewById(R.id.a6t);
        this.iJG = new a(getLayoutInflater());
        this.iJH.setOnItemClickListener(new com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView.a() {
            public final void I(View view, int i) {
                AppMethodBeat.i(133190);
                WxaEntryInfo pQ = WxaBindBizInfoUI.this.iJG.pQ(i);
                if (pQ == null) {
                    AppMethodBeat.o(133190);
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("Contact_User", pQ.username);
                intent.putExtra("key_start_biz_profile_from_app_brand_profile", true);
                intent.putExtra("key_use_new_contact_profile", true);
                intent.putExtra("force_get_contact", true);
                d.b(WxaBindBizInfoUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                AppMethodBeat.o(133190);
            }
        });
        this.iJG.aN(parcelableArrayListExtra);
        this.iJH.setItemAnimator(null);
        this.iJH.setOnLoadingStateChangedListener(new com.tencent.mm.plugin.appbrand.widget.recyclerview.LoadMoreRecyclerView.a() {
            public final void aMC() {
                AppMethodBeat.i(133192);
                arf arf = new arf();
                arf.csB = WxaBindBizInfoUI.this.mAppId;
                arf.wvh = WxaBindBizInfoUI.this.iJF;
                com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
                aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getwxabindbizinfo";
                aVar.fsI = 1823;
                aVar.fsJ = arf;
                aVar.fsK = new arg();
                w.a(aVar.acD(), new com.tencent.mm.ai.w.a() {
                    public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                        AppMethodBeat.i(133191);
                        if (i == 0 && i2 == 0) {
                            arg arg = (arg) bVar.fsH.fsP;
                            LinkedList linkedList = arg.wvi;
                            boolean z = arg.wvj;
                            WxaBindBizInfoUI.this.iJF = arg.wvh;
                            if (z) {
                                WxaBindBizInfoUI.this.iJH.fh(false);
                                WxaBindBizInfoUI.this.iDW.dKT();
                                WxaBindBizInfoUI.this.iJG.iJM = true;
                                WxaBindBizInfoUI.this.iJI.setVisibility(0);
                            }
                            if (!(linkedList == null || linkedList.isEmpty())) {
                                LinkedList linkedList2 = new LinkedList();
                                Iterator it = linkedList.iterator();
                                while (it.hasNext()) {
                                    jd jdVar = (jd) it.next();
                                    if (jdVar != null) {
                                        WxaEntryInfo wxaEntryInfo = new WxaEntryInfo();
                                        wxaEntryInfo.title = jdVar.nickname;
                                        wxaEntryInfo.iconUrl = jdVar.kKZ;
                                        wxaEntryInfo.username = jdVar.username;
                                        linkedList2.add(wxaEntryInfo);
                                    }
                                }
                                WxaBindBizInfoUI.this.iJG.aN(linkedList2);
                            }
                            AppMethodBeat.o(133191);
                        } else {
                            ab.e("MicroMsg.WxaBindBizInfoUI", "onResp, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                            AppMethodBeat.o(133191);
                        }
                        return 0;
                    }
                }, false);
                AppMethodBeat.o(133192);
            }
        });
        this.iJH.setAdapter(this.iJG);
        View inflate = getLayoutInflater().inflate(R.layout.b84, this.iJH, false);
        this.iDW = (ThreeDotsLoadingView) inflate.findViewById(R.id.ue);
        this.iDW.dKS();
        this.iJH.setLoadingView(inflate);
        this.iJI = getLayoutInflater().inflate(R.layout.b85, this.iJH, false);
        this.iJH.addFooterView(this.iJI);
        this.iJI.setVisibility(8);
        if (this.iJG.getItemCount() > 20) {
            this.iJH.fh(true);
            this.iJG.iJM = false;
        }
        this.mController.contentView.setBackgroundColor(-855310);
        AppMethodBeat.o(133201);
    }

    public final int getLayoutId() {
        return R.layout.b83;
    }
}
