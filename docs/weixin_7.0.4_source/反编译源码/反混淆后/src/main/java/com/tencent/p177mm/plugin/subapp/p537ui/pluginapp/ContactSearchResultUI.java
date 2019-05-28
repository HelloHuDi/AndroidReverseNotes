package com.tencent.p177mm.plugin.subapp.p537ui.pluginapp;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.api.C17915b;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p184aj.C16527d;
import com.tencent.p177mm.p184aj.C16527d.C16529b.C16531d;
import com.tencent.p177mm.p264n.C7486a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.applet.C23576a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.protobuf.C7285uy;
import com.tencent.p177mm.protocal.protobuf.but;
import com.tencent.p177mm.protocal.protobuf.buv;
import com.tencent.p177mm.protocal.protobuf.bvk;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.p177mm.storage.RegionCodeDecoder;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchResultUI */
public class ContactSearchResultUI extends MMActivity {
    private static C7306ak feP = new C7306ak(Looper.getMainLooper());
    private LinkedList<but> fjr = new LinkedList();
    private ListView svg;
    private C13914a svh;
    private LinkedList<bvk> svi = new LinkedList();
    private Map<String, C13915b> svj;

    /* renamed from: com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchResultUI$a */
    class C13914a extends BaseAdapter {
        private Context mContext;

        public C13914a(Context context) {
            this.mContext = context;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(25517);
            int size = ContactSearchResultUI.this.fjr.size() + ContactSearchResultUI.this.svi.size();
            AppMethodBeat.m2505o(25517);
            return size;
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C13918c c13918c;
            int i2 = 8;
            AppMethodBeat.m2504i(25518);
            if (view == null) {
                view = View.inflate(this.mContext, 2130970571, null);
                C13918c c13918c2 = new C13918c();
                c13918c2.ejo = (ImageView) view.findViewById(2131823652);
                c13918c2.emg = (TextView) view.findViewById(2131824267);
                c13918c2.jKL = view.findViewById(2131824270);
                c13918c2.jKM = (TextView) view.findViewById(2131824272);
                c13918c2.jKP = view.findViewById(2131824269);
                view.setTag(c13918c2);
                c13918c = c13918c2;
            } else {
                c13918c = (C13918c) view.getTag();
            }
            if (i >= ContactSearchResultUI.this.fjr.size()) {
                bvk bvk = (bvk) ContactSearchResultUI.this.svi.get(i - ContactSearchResultUI.this.fjr.size());
                c13918c.username = bvk.jBB;
                C40460b.m69437r(c13918c.ejo, c13918c.username);
                c13918c.ejo.setTag(c13918c.username);
                C40460b.m69434b(c13918c.ejo, c13918c.username);
                c13918c.jKL.setVisibility(8);
                c13918c.jKP.setVisibility(8);
                c13918c.jKM.setText("");
                try {
                    c13918c.emg.setText(C44089j.m79293b(this.mContext, bvk.jCH, c13918c.emg.getTextSize()));
                } catch (Exception e) {
                    c13918c.emg.setText("");
                }
                AppMethodBeat.m2505o(25518);
            } else {
                but but = (but) ContactSearchResultUI.this.fjr.get(i);
                if (but == null) {
                    C4990ab.m7412e("MicroMsg.ContactSearchResultAdapter", "shouldnot be empty");
                    AppMethodBeat.m2505o(25518);
                } else {
                    int i3;
                    c13918c.username = but.wcB.wVI;
                    C40460b.m69437r(c13918c.ejo, c13918c.username);
                    c13918c.ejo.setTag(c13918c.username);
                    C40460b.m69434b(c13918c.ejo, c13918c.username);
                    String str = but.wcB.wVI;
                    C13915b c13915b = (C13915b) ContactSearchResultUI.this.svj.get(str);
                    if (c13915b == null) {
                        C13915b c13915b2 = new C13915b();
                        ContactSearchResultUI.this.svj.put(str, c13915b2);
                        C7285uy c7285uy = but.wCa;
                        if (c7285uy != null) {
                            C16531d aek;
                            C16527d c16527d = new C16527d();
                            c16527d.field_username = str;
                            c16527d.field_brandFlag = c7285uy.gvb;
                            c16527d.field_brandIconURL = c7285uy.gve;
                            c16527d.field_brandInfo = c7285uy.gvd;
                            c16527d.field_extInfo = c7285uy.gvc;
                            if (c16527d.mo30481cJ(false) != null) {
                                aek = c16527d.mo30481cJ(false).aek();
                            } else {
                                aek = null;
                            }
                            if (aek != null) {
                                boolean z = c16527d.mo30481cJ(false).aem() && !C5046bo.isNullOrNil(aek.fvS);
                                c13915b2.jKJ = z;
                                if (but.wBT != 0) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                c13915b2.jKI = z;
                            }
                        }
                        c13915b = c13915b2;
                    }
                    View view2 = c13918c.jKL;
                    if (c13915b.jKI) {
                        i3 = 0;
                    } else {
                        i3 = 8;
                    }
                    view2.setVisibility(i3);
                    View view3 = c13918c.jKP;
                    if (c13915b.jKJ) {
                        i2 = 0;
                    }
                    view3.setVisibility(i2);
                    C4990ab.m7419v("MicroMsg.ContactSearchResultAdapter", "verifyFlay : %d", Integer.valueOf(but.wBT));
                    try {
                        c13918c.jKM.setText(C44089j.m79293b(this.mContext, C5046bo.nullAsNil(but.guQ), c13918c.jKM.getTextSize()));
                    } catch (Exception e2) {
                        c13918c.jKM.setText("");
                    }
                    try {
                        CharSequence charSequence;
                        TextView textView = c13918c.emg;
                        Context context = this.mContext;
                        if (!C5046bo.isNullOrNil(but.wyX.wVI)) {
                            charSequence = but.wyX.wVI;
                        } else if (C5046bo.isNullOrNil(but.guS)) {
                            charSequence = C5046bo.nullAsNil(but.wcB.wVI);
                        } else {
                            charSequence = but.guS;
                        }
                        textView.setText(C44089j.m79293b(context, charSequence, c13918c.emg.getTextSize()));
                    } catch (Exception e3) {
                        c13918c.emg.setText("");
                    }
                    AppMethodBeat.m2505o(25518);
                }
            }
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchResultUI$b */
    static class C13915b {
        protected boolean jKI;
        protected boolean jKJ;

        private C13915b() {
        }

        /* synthetic */ C13915b(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchResultUI$1 */
    class C139161 implements OnMenuItemClickListener {
        C139161() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(25515);
            ContactSearchResultUI.this.finish();
            AppMethodBeat.m2505o(25515);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.subapp.ui.pluginapp.ContactSearchResultUI$c */
    static class C13918c {
        public ImageView ejo;
        public TextView emg;
        public View jKL;
        public TextView jKM;
        View jKP;
        public String username;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public ContactSearchResultUI() {
        AppMethodBeat.m2504i(25519);
        AppMethodBeat.m2505o(25519);
    }

    static {
        AppMethodBeat.m2504i(25524);
        AppMethodBeat.m2505o(25524);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(25520);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.m2505o(25520);
    }

    public final void initView() {
        AppMethodBeat.m2504i(25521);
        setMMTitle((int) C25738R.string.b2k);
        setBackBtn(new C139161());
        this.svj = new HashMap();
        this.svg = (ListView) findViewById(2131823139);
        this.svg.setEmptyView((TextView) findViewById(2131821749));
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
                C4990ab.printErrStackTrace("MicroMsg.ContactSearchResultUI", e, "SearchContactResponse", new Object[0]);
                try {
                    this.svi.add((bvk) new bvk().parseFrom(byteArrayExtra));
                } catch (Exception e2) {
                    C4990ab.printErrStackTrace("MicroMsg.ContactSearchResultUI", e2, "SearchOpenIMContactItem", new Object[0]);
                }
            }
        }
        if (this.fjr.size() == 0 && this.svi.isEmpty()) {
            AppMethodBeat.m2505o(25521);
            return;
        }
        this.svh = new C13914a(this);
        this.svg.setAdapter(this.svh);
        this.svg.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.m2504i(25516);
                int headerViewsCount = i - ContactSearchResultUI.this.svg.getHeaderViewsCount();
                if (headerViewsCount < 0 || headerViewsCount >= ContactSearchResultUI.this.svg.getCount()) {
                    AppMethodBeat.m2505o(25516);
                } else if (headerViewsCount >= ContactSearchResultUI.this.fjr.size()) {
                    ContactSearchResultUI.m22070a(ContactSearchResultUI.this, (bvk) ContactSearchResultUI.this.svi.get(i - ContactSearchResultUI.this.fjr.size()));
                    AppMethodBeat.m2505o(25516);
                } else {
                    but but = (but) ContactSearchResultUI.this.fjr.get(headerViewsCount);
                    String str = but.wcB.wVI;
                    C9638aw.m17190ZK();
                    C7616ad aoO = C18628c.m29078XM().aoO(str);
                    if (C7486a.m12942jh(aoO.field_type)) {
                        Intent intent = new Intent();
                        intent.putExtra("Contact_User", str);
                        intent.putExtra("Contact_Scene", 3);
                        if (str != null && str.length() > 0) {
                            if (aoO.dsf()) {
                                C7060h.pYm.mo8374X(10298, str + ",35");
                                intent.putExtra("Contact_Scene", 35);
                            }
                            C25985d.m41467b(ContactSearchResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
                        }
                        AppMethodBeat.m2505o(25516);
                        return;
                    }
                    if ((but.wBT & 8) > 0) {
                        C7060h.pYm.mo8374X(10298, but.wcB.wVI + ",35");
                    }
                    Intent intent2 = new Intent();
                    intent2.putExtra("Contact_User", but.wcB.wVI);
                    intent2.putExtra("Contact_Alias", but.guS);
                    intent2.putExtra("Contact_Nick", but.wyX.wVI);
                    intent2.putExtra("Contact_Signature", but.guQ);
                    intent2.putExtra("Contact_RegionCode", RegionCodeDecoder.m7796aC(but.guW, but.guO, but.guP));
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
                            C4990ab.printErrStackTrace("MicroMsg.ContactSearchResultUI", e, "", new Object[0]);
                        }
                    }
                    if ((but.wBT & 8) > 0) {
                        C7060h.pYm.mo8374X(10298, but.wcB.wVI + ",35");
                    }
                    C25985d.m41467b(ContactSearchResultUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent2);
                    AppMethodBeat.m2505o(25516);
                }
            }
        });
        this.svg.setOnScrollListener(new C23576a());
        AppMethodBeat.m2505o(25521);
    }

    public final int getLayoutId() {
        return 2130969239;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(25522);
        C17884o.acv().cancel();
        if (this.svj != null) {
            this.svj.clear();
        }
        super.onDestroy();
        AppMethodBeat.m2505o(25522);
    }

    /* renamed from: a */
    static /* synthetic */ void m22070a(ContactSearchResultUI contactSearchResultUI, bvk bvk) {
        int i = 1;
        AppMethodBeat.m2504i(25523);
        Intent intent = new Intent();
        if (2 == bvk.wWh) {
            i = 15;
        } else if (1 != bvk.wWh) {
            i = 0;
        }
        C17915b.m28131a(intent, bvk, i);
        C25985d.m41467b((Context) contactSearchResultUI, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
        AppMethodBeat.m2505o(25523);
    }
}
