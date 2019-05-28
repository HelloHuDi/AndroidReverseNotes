package com.tencent.p177mm.plugin.profile.p483ui;

import android.os.Bundle;
import android.view.LayoutInflater;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelappbrand.p873a.C32804a;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C42201f;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.service.C45691e;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.profile.ui.BizBindWxaInfoUI */
public final class BizBindWxaInfoUI extends MMActivity {
    private TextView pkN;
    private ListView pkO;
    private String pkP;
    private String pkQ;

    /* renamed from: com.tencent.mm.plugin.profile.ui.BizBindWxaInfoUI$1 */
    class C36131 implements OnMenuItemClickListener {
        C36131() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(134412);
            BizBindWxaInfoUI.this.finish();
            AppMethodBeat.m2505o(134412);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.BizBindWxaInfoUI$2 */
    class C214552 implements OnItemClickListener {
        C214552() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(134413);
            WxaEntryInfo wxaEntryInfo = (WxaEntryInfo) adapterView.getAdapter().getItem(i);
            if (wxaEntryInfo == null) {
                AppMethodBeat.m2505o(134413);
                return;
            }
            AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
            appBrandStatObject.scene = 1020;
            appBrandStatObject.cst = BizBindWxaInfoUI.this.pkP;
            ((C45691e) C1720g.m3528K(C45691e.class)).mo68046a(BizBindWxaInfoUI.this, wxaEntryInfo.username, null, 0, 0, null, appBrandStatObject, BizBindWxaInfoUI.this.pkQ);
            AppMethodBeat.m2505o(134413);
        }
    }

    /* renamed from: com.tencent.mm.plugin.profile.ui.BizBindWxaInfoUI$a */
    static class C39505a extends BaseAdapter {
        private List<WxaEntryInfo> iJL = new LinkedList();
        private LayoutInflater mInflater;

        /* renamed from: com.tencent.mm.plugin.profile.ui.BizBindWxaInfoUI$a$a */
        static class C12831a {
            TextView gne;
            View goc;
            ImageView iyo;

            private C12831a() {
            }

            /* synthetic */ C12831a(byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(134418);
            WxaEntryInfo pQ = m67496pQ(i);
            AppMethodBeat.m2505o(134418);
            return pQ;
        }

        public C39505a(LayoutInflater layoutInflater, List<WxaEntryInfo> list) {
            AppMethodBeat.m2504i(134414);
            this.mInflater = layoutInflater;
            if (list != null) {
                this.iJL.addAll(list);
            }
            AppMethodBeat.m2505o(134414);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(134415);
            int size = this.iJL.size();
            AppMethodBeat.m2505o(134415);
            return size;
        }

        /* renamed from: pQ */
        private WxaEntryInfo m67496pQ(int i) {
            AppMethodBeat.m2504i(134416);
            WxaEntryInfo wxaEntryInfo = (WxaEntryInfo) this.iJL.get(i);
            AppMethodBeat.m2505o(134416);
            return wxaEntryInfo;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C12831a c12831a;
            AppMethodBeat.m2504i(134417);
            if (view == null) {
                view = this.mInflater.inflate(2130968692, viewGroup, false);
                C12831a c12831a2 = new C12831a();
                c12831a2.iyo = (ImageView) view.findViewById(2131820915);
                c12831a2.gne = (TextView) view.findViewById(2131820649);
                c12831a2.goc = view.findViewById(2131821128);
                view.setTag(c12831a2);
                c12831a = c12831a2;
            } else {
                c12831a = (C12831a) view.getTag();
            }
            WxaEntryInfo pQ = m67496pQ(i);
            C37926b.abR().mo60683a(c12831a.iyo, pQ.iconUrl, C32804a.abQ(), C42201f.fqH);
            c12831a.gne.setText(C5046bo.nullAsNil(pQ.title));
            if (this.iJL != null) {
                int i2;
                View view2 = c12831a.goc;
                if (this.iJL.size() - 1 == i) {
                    i2 = 8;
                } else {
                    i2 = 0;
                }
                view2.setVisibility(i2);
            }
            AppMethodBeat.m2505o(134417);
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(134419);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
            AppMethodBeat.m2505o(134419);
            return;
        }
        this.pkP = getIntent().getStringExtra("extra_username");
        this.pkQ = getIntent().getStringExtra("extra_appid");
        setBackBtn(new C36131());
        setMMTitle((int) C25738R.string.au2);
        mo17446xE(this.mController.dyj());
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("extra_wxa_entry_info_list");
        View inflate = getLayoutInflater().inflate(2130968852, null);
        this.pkN = (TextView) inflate.findViewById(2131821314);
        TextView textView = this.pkN;
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(parcelableArrayListExtra != null ? parcelableArrayListExtra.size() : 0);
        textView.setText(getString(C25738R.string.a9a, objArr));
        this.pkO = (ListView) findViewById(2131821796);
        this.pkO.addHeaderView(inflate);
        this.pkO.setAdapter(new C39505a(getLayoutInflater(), parcelableArrayListExtra));
        this.pkO.setOnItemClickListener(new C214552());
        this.mController.contentView.setBackgroundResource(C25738R.color.f12305zf);
        AppMethodBeat.m2505o(134419);
    }

    public final int getLayoutId() {
        return 2130968853;
    }
}
