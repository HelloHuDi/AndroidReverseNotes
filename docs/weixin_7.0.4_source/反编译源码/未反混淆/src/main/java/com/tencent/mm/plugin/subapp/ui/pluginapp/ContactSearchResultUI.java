package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ah.o;
import com.tencent.mm.aj.d.b.d;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.but;
import com.tencent.mm.protocal.protobuf.buv;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.protocal.protobuf.uy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ContactSearchResultUI extends MMActivity {
    private static ak feP = new ak(Looper.getMainLooper());
    private LinkedList<but> fjr = new LinkedList();
    private ListView svg;
    private a svh;
    private LinkedList<bvk> svi = new LinkedList();
    private Map<String, b> svj;

    class a extends BaseAdapter {
        private Context mContext;

        public a(Context context) {
            this.mContext = context;
        }

        public final int getCount() {
            AppMethodBeat.i(25517);
            int size = ContactSearchResultUI.this.fjr.size() + ContactSearchResultUI.this.svi.size();
            AppMethodBeat.o(25517);
            return size;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            int i2 = 8;
            AppMethodBeat.i(25518);
            if (view == null) {
                view = View.inflate(this.mContext, R.layout.aq3, null);
                c cVar2 = new c();
                cVar2.ejo = (ImageView) view.findViewById(R.id.bj0);
                cVar2.emg = (TextView) view.findViewById(R.id.bzm);
                cVar2.jKL = view.findViewById(R.id.bzp);
                cVar2.jKM = (TextView) view.findViewById(R.id.bzr);
                cVar2.jKP = view.findViewById(R.id.bzo);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            if (i >= ContactSearchResultUI.this.fjr.size()) {
                bvk bvk = (bvk) ContactSearchResultUI.this.svi.get(i - ContactSearchResultUI.this.fjr.size());
                cVar.username = bvk.jBB;
                com.tencent.mm.pluginsdk.ui.a.b.r(cVar.ejo, cVar.username);
                cVar.ejo.setTag(cVar.username);
                com.tencent.mm.pluginsdk.ui.a.b.b(cVar.ejo, cVar.username);
                cVar.jKL.setVisibility(8);
                cVar.jKP.setVisibility(8);
                cVar.jKM.setText("");
                try {
                    cVar.emg.setText(j.b(this.mContext, bvk.jCH, cVar.emg.getTextSize()));
                } catch (Exception e) {
                    cVar.emg.setText("");
                }
                AppMethodBeat.o(25518);
            } else {
                but but = (but) ContactSearchResultUI.this.fjr.get(i);
                if (but == null) {
                    ab.e("MicroMsg.ContactSearchResultAdapter", "shouldnot be empty");
                    AppMethodBeat.o(25518);
                } else {
                    int i3;
                    cVar.username = but.wcB.wVI;
                    com.tencent.mm.pluginsdk.ui.a.b.r(cVar.ejo, cVar.username);
                    cVar.ejo.setTag(cVar.username);
                    com.tencent.mm.pluginsdk.ui.a.b.b(cVar.ejo, cVar.username);
                    String str = but.wcB.wVI;
                    b bVar = (b) ContactSearchResultUI.this.svj.get(str);
                    if (bVar == null) {
                        b bVar2 = new b();
                        ContactSearchResultUI.this.svj.put(str, bVar2);
                        uy uyVar = but.wCa;
                        if (uyVar != null) {
                            d aek;
                            com.tencent.mm.aj.d dVar = new com.tencent.mm.aj.d();
                            dVar.field_username = str;
                            dVar.field_brandFlag = uyVar.gvb;
                            dVar.field_brandIconURL = uyVar.gve;
                            dVar.field_brandInfo = uyVar.gvd;
                            dVar.field_extInfo = uyVar.gvc;
                            if (dVar.cJ(false) != null) {
                                aek = dVar.cJ(false).aek();
                            } else {
                                aek = null;
                            }
                            if (aek != null) {
                                boolean z = dVar.cJ(false).aem() && !bo.isNullOrNil(aek.fvS);
                                bVar2.jKJ = z;
                                if (but.wBT != 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                bVar2.jKI = z;
                            }
                        }
                        bVar = bVar2;
                    }
                    View view2 = cVar.jKL;
                    if (bVar.jKI) {
                        i3 = 0;
                    } else {
                        i3 = 8;
                    }
                    view2.setVisibility(i3);
                    View view3 = cVar.jKP;
                    if (bVar.jKJ) {
                        i2 = 0;
                    }
                    view3.setVisibility(i2);
                    ab.v("MicroMsg.ContactSearchResultAdapter", "verifyFlay : %d", Integer.valueOf(but.wBT));
                    try {
                        cVar.jKM.setText(j.b(this.mContext, bo.nullAsNil(but.guQ), cVar.jKM.getTextSize()));
                    } catch (Exception e2) {
                        cVar.jKM.setText("");
                    }
                    try {
                        CharSequence charSequence;
                        TextView textView = cVar.emg;
                        Context context = this.mContext;
                        if (!bo.isNullOrNil(but.wyX.wVI)) {
                            charSequence = but.wyX.wVI;
                        } else if (bo.isNullOrNil(but.guS)) {
                            charSequence = bo.nullAsNil(but.wcB.wVI);
                        } else {
                            charSequence = but.guS;
                        }
                        textView.setText(j.b(context, charSequence, cVar.emg.getTextSize()));
                    } catch (Exception e3) {
                        cVar.emg.setText("");
                    }
                    AppMethodBeat.o(25518);
                }
            }
            return view;
        }
    }

    static class b {
        protected boolean jKI;
        protected boolean jKJ;

        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }
    }

    static class c {
        public ImageView ejo;
        public TextView emg;
        public View jKL;
        public TextView jKM;
        View jKP;
        public String username;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public ContactSearchResultUI() {
        AppMethodBeat.i(25519);
        AppMethodBeat.o(25519);
    }

    static {
        AppMethodBeat.i(25524);
        AppMethodBeat.o(25524);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(25520);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(25520);
    }

    public final void initView() {
        AppMethodBeat.i(25521);
        setMMTitle((int) R.string.b2k);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(25515);
                ContactSearchResultUI.this.finish();
                AppMethodBeat.o(25515);
                return true;
            }
        });
        this.svj = new HashMap();
        this.svg = (ListView) findViewById(R.id.b65);
        this.svg.setEmptyView((TextView) findViewById(R.id.a5j));
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("result");
        final int intExtra = getIntent().getIntExtra("add_more_friend_search_scene", 0);
        if (byteArrayExtra != null) {
            try {
                buv buv = (buv) new buv().parseFrom(byteArrayExtra);
                if (buv != null) {
                    this.fjr = buv.woe;
                    this.svi = buv.wWn;
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.ContactSearchResultUI", e, "SearchContactResponse", new Object[0]);
                try {
                    this.svi.add((bvk) new bvk().parseFrom(byteArrayExtra));
                } catch (Exception e2) {
                    ab.printErrStackTrace("MicroMsg.ContactSearchResultUI", e2, "SearchOpenIMContactItem", new Object[0]);
                }
            }
        }
        if (this.fjr.size() == 0 && this.svi.isEmpty()) {
            AppMethodBeat.o(25521);
            return;
        }
        this.svh = new a(this);
        this.svg.setAdapter(this.svh);
        this.svg.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(25516);
                int headerViewsCount = i - ContactSearchResultUI.this.svg.getHeaderViewsCount();
                if (headerViewsCount < 0 || headerViewsCount >= ContactSearchResultUI.this.svg.getCount()) {
                    AppMethodBeat.o(25516);
                } else if (headerViewsCount >= ContactSearchResultUI.this.fjr.size()) {
                    ContactSearchResultUI.a(ContactSearchResultUI.this, (bvk) ContactSearchResultUI.this.svi.get(i - ContactSearchResultUI.this.fjr.size()));
                    AppMethodBeat.o(25516);
                } else {
                    but but = (but) ContactSearchResultUI.this.fjr.get(headerViewsCount);
                    String str = but.wcB.wVI;
                    aw.ZK();
                    ad aoO = com.tencent.mm.model.c.XM().aoO(str);
                    if (com.tencent.mm.n.a.jh(aoO.field_type)) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", str);
                        intent.putExtra("Contact_Scene", 3);
                        if (str != null && str.length() > 0) {
                            if (aoO.dsf()) {
                                h.pYm.X(10298, str + ",35");
                                intent.putExtra("Contact_Scene", 35);
                            }
                            com.tencent.mm.bp.d.b(ContactSearchResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                        }
                        AppMethodBeat.o(25516);
                        return;
                    }
                    if ((but.wBT & 8) > 0) {
                        h.pYm.X(10298, but.wcB.wVI + ",35");
                    }
                    Intent intent2 = new Intent();
                    intent2.putExtra("Contact_User", but.wcB.wVI);
                    intent2.putExtra("Contact_Alias", but.guS);
                    intent2.putExtra("Contact_Nick", but.wyX.wVI);
                    intent2.putExtra("Contact_Signature", but.guQ);
                    intent2.putExtra("Contact_RegionCode", RegionCodeDecoder.aC(but.guW, but.guO, but.guP));
                    intent2.putExtra("Contact_Sex", but.guN);
                    intent2.putExtra("Contact_VUser_Info", but.wBU);
                    intent2.putExtra("Contact_VUser_Info_Flag", but.wBT);
                    intent2.putExtra("Contact_KWeibo_flag", but.wBX);
                    intent2.putExtra("Contact_KWeibo", but.wBV);
                    intent2.putExtra("Contact_KWeiboNick", but.wBW);
                    intent2.putExtra("Contact_KSnsIFlag", but.wBZ.guY);
                    intent2.putExtra("Contact_KSnsBgId", but.wBZ.gva);
                    intent2.putExtra("Contact_KSnsBgUrl", but.wBZ.guZ);
                    intent2.putExtra("Contact_Scene", 35);
                    if (intExtra != 0) {
                        intent2.putExtra("add_more_friend_search_scene", intExtra);
                    }
                    if (but.wCa != null) {
                        try {
                            intent2.putExtra("Contact_customInfo", but.wCa.toByteArray());
                        } catch (IOException e) {
                            ab.printErrStackTrace("MicroMsg.ContactSearchResultUI", e, "", new Object[0]);
                        }
                    }
                    if ((but.wBT & 8) > 0) {
                        h.pYm.X(10298, but.wcB.wVI + ",35");
                    }
                    com.tencent.mm.bp.d.b(ContactSearchResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                    AppMethodBeat.o(25516);
                }
            }
        });
        this.svg.setOnScrollListener(new com.tencent.mm.ui.applet.a());
        AppMethodBeat.o(25521);
    }

    public final int getLayoutId() {
        return R.layout.r6;
    }

    public void onDestroy() {
        AppMethodBeat.i(25522);
        o.acv().cancel();
        if (this.svj != null) {
            this.svj.clear();
        }
        super.onDestroy();
        AppMethodBeat.o(25522);
    }

    static /* synthetic */ void a(ContactSearchResultUI contactSearchResultUI, bvk bvk) {
        int i = 1;
        AppMethodBeat.i(25523);
        Intent intent = new Intent();
        if (2 == bvk.wWh) {
            i = 15;
        } else if (1 != bvk.wWh) {
            i = 0;
        }
        com.tencent.mm.api.b.a(intent, bvk, i);
        com.tencent.mm.bp.d.b((Context) contactSearchResultUI, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        AppMethodBeat.o(25523);
    }
}
