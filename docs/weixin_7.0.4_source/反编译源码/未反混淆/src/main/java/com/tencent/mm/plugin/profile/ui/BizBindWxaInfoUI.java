package com.tencent.mm.plugin.profile.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.e;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class BizBindWxaInfoUI extends MMActivity {
    private TextView pkN;
    private ListView pkO;
    private String pkP;
    private String pkQ;

    static class a extends BaseAdapter {
        private List<WxaEntryInfo> iJL = new LinkedList();
        private LayoutInflater mInflater;

        static class a {
            TextView gne;
            View goc;
            ImageView iyo;

            private a() {
            }

            /* synthetic */ a(byte b) {
                this();
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(134418);
            WxaEntryInfo pQ = pQ(i);
            AppMethodBeat.o(134418);
            return pQ;
        }

        public a(LayoutInflater layoutInflater, List<WxaEntryInfo> list) {
            AppMethodBeat.i(134414);
            this.mInflater = layoutInflater;
            if (list != null) {
                this.iJL.addAll(list);
            }
            AppMethodBeat.o(134414);
        }

        public final int getCount() {
            AppMethodBeat.i(134415);
            int size = this.iJL.size();
            AppMethodBeat.o(134415);
            return size;
        }

        private WxaEntryInfo pQ(int i) {
            AppMethodBeat.i(134416);
            WxaEntryInfo wxaEntryInfo = (WxaEntryInfo) this.iJL.get(i);
            AppMethodBeat.o(134416);
            return wxaEntryInfo;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(134417);
            if (view == null) {
                view = this.mInflater.inflate(R.layout.cf, viewGroup, false);
                a aVar2 = new a();
                aVar2.iyo = (ImageView) view.findViewById(R.id.jb);
                aVar2.gne = (TextView) view.findViewById(R.id.c5);
                aVar2.goc = view.findViewById(R.id.p3);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            WxaEntryInfo pQ = pQ(i);
            b.abR().a(aVar.iyo, pQ.iconUrl, com.tencent.mm.modelappbrand.a.a.abQ(), f.fqH);
            aVar.gne.setText(bo.nullAsNil(pQ.title));
            if (this.iJL != null) {
                int i2;
                View view2 = aVar.goc;
                if (this.iJL.size() - 1 == i) {
                    i2 = 8;
                } else {
                    i2 = 0;
                }
                view2.setVisibility(i2);
            }
            AppMethodBeat.o(134417);
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(134419);
        super.onCreate(bundle);
        if (getIntent() == null) {
            finish();
            AppMethodBeat.o(134419);
            return;
        }
        this.pkP = getIntent().getStringExtra("extra_username");
        this.pkQ = getIntent().getStringExtra("extra_appid");
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(134412);
                BizBindWxaInfoUI.this.finish();
                AppMethodBeat.o(134412);
                return false;
            }
        });
        setMMTitle((int) R.string.au2);
        xE(this.mController.dyj());
        ArrayList parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("extra_wxa_entry_info_list");
        View inflate = getLayoutInflater().inflate(R.layout.gr, null);
        this.pkN = (TextView) inflate.findViewById(R.id.u4);
        TextView textView = this.pkN;
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(parcelableArrayListExtra != null ? parcelableArrayListExtra.size() : 0);
        textView.setText(getString(R.string.a9a, objArr));
        this.pkO = (ListView) findViewById(R.id.a6t);
        this.pkO.addHeaderView(inflate);
        this.pkO.setAdapter(new a(getLayoutInflater(), parcelableArrayListExtra));
        this.pkO.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(134413);
                WxaEntryInfo wxaEntryInfo = (WxaEntryInfo) adapterView.getAdapter().getItem(i);
                if (wxaEntryInfo == null) {
                    AppMethodBeat.o(134413);
                    return;
                }
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = 1020;
                appBrandStatObject.cst = BizBindWxaInfoUI.this.pkP;
                ((e) g.K(e.class)).a(BizBindWxaInfoUI.this, wxaEntryInfo.username, null, 0, 0, null, appBrandStatObject, BizBindWxaInfoUI.this.pkQ);
                AppMethodBeat.o(134413);
            }
        });
        this.mController.contentView.setBackgroundResource(R.color.zf);
        AppMethodBeat.o(134419);
    }

    public final int getLayoutId() {
        return R.layout.gs;
    }
}
