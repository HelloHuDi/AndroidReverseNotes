package com.tencent.p177mm.plugin.p268aa.p270ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.p268aa.p269a.p717c.C24676b;
import com.tencent.p177mm.plugin.p268aa.p270ui.C9821a.C9822a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C30132m;
import com.tencent.p177mm.protocal.protobuf.C46558k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5692d.C5690a;
import com.tencent.p177mm.vending.p644j.C7625d;
import com.tencent.p177mm.wallet_core.p650ui.C30901g;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.aa.ui.AAQueryListUI */
public class AAQueryListUI extends BaseAAPresenterActivity {
    private C24676b gnk = ((C24676b) mo21155V(C24676b.class));
    private ListView gnl;
    private C9824b gnm;
    private Dialog gnn;
    private boolean gno = false;
    private boolean gnp = false;
    private View gnq;
    private AAQueryListH5UrlFooterView gnr;
    private String gns;
    private int mode = 1;

    /* renamed from: com.tencent.mm.plugin.aa.ui.AAQueryListUI$1 */
    class C19571 implements OnMenuItemClickListener {
        C19571() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(40728);
            AAQueryListUI.this.finish();
            AppMethodBeat.m2505o(40728);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.AAQueryListUI$2 */
    class C19582 implements OnScrollListener {
        C19582() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            AppMethodBeat.m2504i(40729);
            if (AAQueryListUI.this.gnl.getLastVisiblePosition() == AAQueryListUI.this.gnl.getCount() - 1 && AAQueryListUI.this.gnl.getCount() > 0 && !AAQueryListUI.this.gnp && !AAQueryListUI.this.gno) {
                AAQueryListUI.this.gnl.addFooterView(AAQueryListUI.this.gnq);
                AAQueryListUI.m74651a(AAQueryListUI.this, false, AAQueryListUI.this.mode);
            }
            AppMethodBeat.m2505o(40729);
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.AAQueryListUI$3 */
    class C19593 implements OnItemClickListener {
        C19593() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(40730);
            if (AAQueryListUI.this.gnm != null) {
                if (i < 0 || i >= AAQueryListUI.this.gnm.getCount()) {
                    C4990ab.m7417i("MicroMsg.AAQueryListUI", "click out of bound! %s", Integer.valueOf(i));
                    AppMethodBeat.m2505o(40730);
                    return;
                }
                int top = view.getTop();
                C46558k c46558k = (C46558k) AAQueryListUI.this.gnm.getItem(i);
                if (c46558k != null) {
                    if (!C5046bo.isNullOrNil(c46558k.vzX)) {
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", c46558k.vzX);
                        C25985d.m41467b(AAQueryListUI.this, "webview", ".ui.tools.WebViewUI", intent);
                    } else if (!C5046bo.isNullOrNil(c46558k.vzL)) {
                        String str = null;
                        if (c46558k.vzW == 2) {
                            str = C1853r.m3846Yz();
                        }
                        Intent intent2 = new Intent(AAQueryListUI.this, PaylistAAUI.class);
                        intent2.putExtra("bill_no", c46558k.vzL);
                        intent2.putExtra("launcher_user_name", str);
                        intent2.putExtra("enter_scene", 4);
                        intent2.putExtra("chatroom", c46558k.vzM);
                        intent2.putExtra("item_position", i);
                        intent2.putExtra("item_offset", top);
                        AAQueryListUI.this.startActivityForResult(intent2, 1);
                    }
                }
            }
            C7060h.pYm.mo8381e(13721, Integer.valueOf(5), Integer.valueOf(3));
            AppMethodBeat.m2505o(40730);
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.AAQueryListUI$4 */
    class C329004 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.aa.ui.AAQueryListUI$4$1 */
        class C187801 implements C36073c {
            C187801() {
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(40731);
                c44273l.add(0, 1, 1, (int) C25738R.string.f8675bp);
                c44273l.add(1, 2, 1, (int) C25738R.string.f8676bq);
                AppMethodBeat.m2505o(40731);
            }
        }

        /* renamed from: com.tencent.mm.plugin.aa.ui.AAQueryListUI$4$2 */
        class C329012 implements C5279d {
            C329012() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(40732);
                switch (menuItem.getItemId()) {
                    case 1:
                        C4990ab.m7417i("MicroMsg.AAQueryListUI", "go to launch list: %d", Integer.valueOf(AAQueryListUI.this.mode));
                        if (AAQueryListUI.this.mode == 1) {
                            AppMethodBeat.m2505o(40732);
                            return;
                        }
                        AAQueryListUI.this.mode = 1;
                        AAQueryListUI.this.setMMTitle((int) C25738R.string.f8674bo);
                        AAQueryListUI.this.gnm.mode = AAQueryListUI.this.mode;
                        AAQueryListUI.this.gnm.aot();
                        AAQueryListUI.this.gnm.notifyDataSetChanged();
                        AAQueryListUI.m74651a(AAQueryListUI.this, true, AAQueryListUI.this.mode);
                        AppMethodBeat.m2505o(40732);
                        return;
                    case 2:
                        C4990ab.m7417i("MicroMsg.AAQueryListUI", "go to pay query list: %d", Integer.valueOf(AAQueryListUI.this.mode));
                        if (AAQueryListUI.this.mode != 2) {
                            AAQueryListUI.this.setMMTitle((int) C25738R.string.f8677br);
                            AAQueryListUI.this.gnm.mode = AAQueryListUI.this.mode;
                            AAQueryListUI.this.gnm.aot();
                            AAQueryListUI.this.gnm.notifyDataSetChanged();
                            AAQueryListUI.this.mode = 2;
                            AAQueryListUI.m74651a(AAQueryListUI.this, true, AAQueryListUI.this.mode);
                            break;
                        }
                        AppMethodBeat.m2505o(40732);
                        return;
                }
                AppMethodBeat.m2505o(40732);
            }
        }

        C329004() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(40733);
            C36356d c36356d = new C36356d(AAQueryListUI.this, 1, false);
            c36356d.rBl = new C187801();
            c36356d.rBm = new C329012();
            c36356d.cpD();
            AppMethodBeat.m2505o(40733);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.AAQueryListUI$5 */
    class C329025 implements C5690a {
        C329025() {
        }

        /* renamed from: bi */
        public final void mo9345bi(Object obj) {
            AppMethodBeat.m2504i(40734);
            C4990ab.m7417i("MicroMsg.AAQueryListUI", "getNexPage failed: %s", obj);
            if (AAQueryListUI.this.gnn != null) {
                AAQueryListUI.this.gnn.dismiss();
                AAQueryListUI.this.gnn = null;
            }
            AAQueryListUI.this.gno = false;
            if (AAQueryListUI.this.gnl.getFooterViewsCount() > 0) {
                AAQueryListUI.this.gnl.removeFooterView(AAQueryListUI.this.gnq);
            }
            if (obj instanceof String) {
                Toast.makeText(AAQueryListUI.this, obj.toString(), 1).show();
                AppMethodBeat.m2505o(40734);
                return;
            }
            Toast.makeText(AAQueryListUI.this, C25738R.string.c9m, 1).show();
            AppMethodBeat.m2505o(40734);
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.AAQueryListUI$7 */
    class C367067 implements C9822a {
        C367067() {
        }

        public final void aos() {
            AppMethodBeat.m2504i(40736);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", AAQueryListUI.this.gns);
            C25985d.m41467b(AAQueryListUI.this, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.m2505o(40736);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public AAQueryListUI() {
        AppMethodBeat.m2504i(40737);
        AppMethodBeat.m2505o(40737);
    }

    /* renamed from: a */
    static /* synthetic */ void m74651a(AAQueryListUI aAQueryListUI, boolean z, int i) {
        AppMethodBeat.m2504i(40741);
        aAQueryListUI.m74659h(z, i);
        AppMethodBeat.m2505o(40741);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(40738);
        super.onCreate(bundle);
        setBackBtn(new C19571());
        setMMTitle((int) C25738R.string.f8674bo);
        addIconOptionMenu(0, C25738R.drawable.f6899uu, new C329004());
        this.gnl = (ListView) findViewById(2131820894);
        this.gnl.setOnScrollListener(new C19582());
        this.gnl.setOnItemClickListener(new C19593());
        this.gnq = new AAQueryListLoadingMoreView(this);
        this.gnr = new AAQueryListH5UrlFooterView(this);
        this.gnn = C30901g.m49317a((Context) this, false, null);
        this.gnm = new C9824b(this, this.mode);
        this.gnl.setAdapter(this.gnm);
        this.gnl.setVisibility(4);
        m74659h(false, this.mode);
        AppMethodBeat.m2505o(40738);
    }

    /* renamed from: h */
    private void m74659h(final boolean z, int i) {
        AppMethodBeat.m2504i(40739);
        if (this.gno) {
            C4990ab.m7416i("MicroMsg.AAQueryListUI", "getNextPage, loading");
            AppMethodBeat.m2505o(40739);
            return;
        }
        if (z) {
            this.gnp = false;
            this.gnl.removeFooterView(this.gnr);
        }
        this.gno = true;
        this.gnk.gmD.mo34042g(z, i).mo15896f(new C5681a<Object, C7625d<List, String, Boolean>>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(40735);
                C7625d c7625d = (C7625d) obj;
                List list = (List) c7625d.get(0);
                C4990ab.m7417i("MicroMsg.AAQueryListUI", "record list size: %s, h5Url: %s, lastFlag: %s", Integer.valueOf(list.size()), c7625d.get(1), c7625d.get(2));
                if (!C5046bo.isNullOrNil((String) c7625d.get(1))) {
                    AAQueryListUI.this.gns = (String) c7625d.get(1);
                }
                if (z) {
                    AAQueryListUI.this.gnm.aot();
                }
                C9824b f = AAQueryListUI.this.gnm;
                C4990ab.m7417i("MicroMsg.AAQueryListAdapter", "addNewRecord: %s", list);
                if (list != null && list.size() > 0) {
                    C4990ab.m7417i("MicroMsg.AAQueryListAdapter", "addNewRecord size: %s", Integer.valueOf(list.size()));
                    f.dataList.addAll(list);
                    f.notifyDataSetChanged();
                }
                if (AAQueryListUI.this.gnn != null) {
                    AAQueryListUI.this.gnn.dismiss();
                    AAQueryListUI.this.gnn = null;
                }
                if (AAQueryListUI.this.gnl.getVisibility() != 0) {
                    AAQueryListUI.this.gnl.setVisibility(0);
                }
                AAQueryListUI.this.gno = false;
                if (!((Boolean) c7625d.get(2)).booleanValue()) {
                    AAQueryListUI.this.gnp = true;
                }
                if (AAQueryListUI.this.gnl.getFooterViewsCount() > 0) {
                    AAQueryListUI.this.gnl.removeFooterView(AAQueryListUI.this.gnq);
                }
                if (AAQueryListUI.this.gnp) {
                    AAQueryListUI.m74662k(AAQueryListUI.this);
                    if (AAQueryListUI.this.gnr.getVisibility() == 0) {
                        AAQueryListUI.this.gnl.addFooterView(AAQueryListUI.this.gnr, null, false);
                    }
                }
                Void voidR = zXH;
                AppMethodBeat.m2505o(40735);
                return voidR;
            }
        }).mo11586a((C5690a) new C329025());
        AppMethodBeat.m2505o(40739);
    }

    public final int getLayoutId() {
        return 2130968579;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(40740);
        if (i == 1 && i2 == -1) {
            boolean booleanExtra = intent.getBooleanExtra("close_aa", false);
            int intExtra = intent.getIntExtra("item_position", 0);
            int intExtra2 = intent.getIntExtra("item_offset", 0);
            if (booleanExtra) {
                this.gnl.setSelectionFromTop(intExtra, intExtra2);
                m74659h(true, this.mode);
            }
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(40740);
    }

    /* renamed from: k */
    static /* synthetic */ void m74662k(AAQueryListUI aAQueryListUI) {
        AppMethodBeat.m2504i(40742);
        if (C5046bo.isNullOrNil(aAQueryListUI.gns)) {
            C4990ab.m7416i("MicroMsg.AAQueryListUI", "empty h5 url!");
            aAQueryListUI.gnr.setVisibility(8);
            AppMethodBeat.m2505o(40742);
            return;
        }
        TextView bottomLinkTv = aAQueryListUI.gnr.getBottomLinkTv();
        bottomLinkTv.setClickable(true);
        bottomLinkTv.setOnTouchListener(new C30132m(aAQueryListUI));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(aAQueryListUI.getString(C25738R.string.f8654b5));
        spannableStringBuilder.setSpan(new C9821a(new C367067()), 0, spannableStringBuilder.length(), 18);
        bottomLinkTv.setText(spannableStringBuilder);
        AppMethodBeat.m2505o(40742);
    }
}
