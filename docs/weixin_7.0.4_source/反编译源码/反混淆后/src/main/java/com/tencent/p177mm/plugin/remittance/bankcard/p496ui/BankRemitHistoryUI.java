package com.tencent.p177mm.plugin.remittance.bankcard.p496ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.tools.C46696j;
import com.tencent.p177mm.plugin.remittance.bankcard.p495a.C13020e;
import com.tencent.p177mm.plugin.remittance.bankcard.p495a.C46916i;
import com.tencent.p177mm.pluginsdk.p597ui.applet.CdnImageView;
import com.tencent.p177mm.protocal.protobuf.atf;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C44428p.C40929a;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI */
public class BankRemitHistoryUI extends BankRemitBaseUI implements C5279d {
    private boolean gno = false;
    private boolean gnp = false;
    private C46696j icA;
    private List<atf> kPz = new ArrayList();
    private View leb;
    private int limit = 20;
    private int offset = 0;
    private ListView pNq;
    private C13042a pNr;

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI$2 */
    class C130352 implements OnScrollListener {
        C130352() {
        }

        public final void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            AppMethodBeat.m2504i(44607);
            if (BankRemitHistoryUI.this.pNq.getLastVisiblePosition() == BankRemitHistoryUI.this.pNq.getCount() - 1 && BankRemitHistoryUI.this.pNq.getCount() > 0 && !BankRemitHistoryUI.this.gnp && !BankRemitHistoryUI.this.gno) {
                BankRemitHistoryUI.m21018e(BankRemitHistoryUI.this);
            }
            AppMethodBeat.m2505o(44607);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI$b */
    class C13037b {
        TextView gnf;
        TextView hrg;
        TextView pNv;
        TextView pNw;
        TextView pNx;
        CdnImageView pNy;

        public C13037b(View view) {
            AppMethodBeat.m2504i(44619);
            this.pNv = (TextView) view.findViewById(2131821664);
            this.hrg = (TextView) view.findViewById(2131821667);
            this.pNw = (TextView) view.findViewById(2131821668);
            this.gnf = (TextView) view.findViewById(2131821669);
            this.pNx = (TextView) view.findViewById(2131821670);
            this.pNy = (CdnImageView) view.findViewById(2131821666);
            AppMethodBeat.m2505o(44619);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI$1 */
    class C130381 implements OnItemLongClickListener {
        C130381() {
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(44606);
            C4990ab.m7411d("MicroMsg.BankRemitHistoryUI", "click item, %s", ((atf) adapterView.getAdapter().getItem(i)).title);
            BankRemitHistoryUI.this.icA.mo75004a(view, i, j, BankRemitHistoryUI.this, BankRemitHistoryUI.this);
            AppMethodBeat.m2505o(44606);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI$6 */
    class C130416 implements C40929a {
        C130416() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(44611);
            C4990ab.m7413e("MicroMsg.BankRemitHistoryUI", "net error: %s", c1207m);
            AppMethodBeat.m2505o(44611);
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI$a */
    class C13042a extends BaseAdapter {
        private SimpleDateFormat pJi;

        private C13042a() {
            AppMethodBeat.m2504i(44614);
            this.pJi = new SimpleDateFormat(BankRemitHistoryUI.this.mController.ylL.getString(C25738R.string.a4j));
            AppMethodBeat.m2505o(44614);
        }

        /* synthetic */ C13042a(BankRemitHistoryUI bankRemitHistoryUI, byte b) {
            this();
        }

        public final int getCount() {
            AppMethodBeat.m2504i(44615);
            int size = BankRemitHistoryUI.this.kPz.size();
            AppMethodBeat.m2505o(44615);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(44616);
            Object obj = BankRemitHistoryUI.this.kPz.get(i);
            AppMethodBeat.m2505o(44616);
            return obj;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            boolean z;
            AppMethodBeat.m2504i(44617);
            if (view == null) {
                view = LayoutInflater.from(BankRemitHistoryUI.this.mController.ylL).inflate(2130968818, viewGroup, false);
                view.setTag(new C13037b(view));
            }
            C13037b c13037b = (C13037b) view.getTag();
            atf atf = (atf) getItem(i);
            String fQ = m21029fQ(atf.wxg);
            if (i == 0) {
                z = true;
            } else if (fQ.equals(m21029fQ(((atf) getItem(i - 1)).wxg))) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                c13037b.pNv.setText(fQ);
                c13037b.pNv.setVisibility(0);
            } else {
                c13037b.pNv.setVisibility(8);
            }
            c13037b.pNy.setUrl(atf.pLH);
            c13037b.hrg.setText(atf.title);
            c13037b.pNw.setText(atf.wxh);
            c13037b.gnf.setText(atf.wxf);
            if (C5046bo.isNullOrNil(atf.wxi)) {
                c13037b.pNx.setVisibility(8);
            } else {
                if (!C5046bo.isNullOrNil(atf.wxj)) {
                    c13037b.pNx.setTextColor(Color.parseColor(atf.wxj));
                }
                c13037b.pNx.setText(atf.wxi);
                c13037b.pNx.setVisibility(0);
            }
            AppMethodBeat.m2505o(44617);
            return view;
        }

        /* renamed from: fQ */
        private String m21029fQ(long j) {
            AppMethodBeat.m2504i(44618);
            String format = this.pJi.format(new Date(1000 * j));
            AppMethodBeat.m2505o(44618);
            return format;
        }
    }

    /* renamed from: com.tencent.mm.plugin.remittance.bankcard.ui.BankRemitHistoryUI$3 */
    class C130433 implements C40929a {
        C130433() {
        }

        /* renamed from: e */
        public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(44608);
            C4990ab.m7413e("MicroMsg.BankRemitHistoryUI", "net error: %s", c1207m);
            AppMethodBeat.m2505o(44608);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public BankRemitHistoryUI() {
        AppMethodBeat.m2504i(44620);
        AppMethodBeat.m2505o(44620);
    }

    /* renamed from: e */
    static /* synthetic */ void m21018e(BankRemitHistoryUI bankRemitHistoryUI) {
        AppMethodBeat.m2504i(44628);
        bankRemitHistoryUI.cfk();
        AppMethodBeat.m2505o(44628);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(44621);
        super.onCreate(bundle);
        mo39992nf(1511);
        mo39992nf(1737);
        setMMTitle((int) C25738R.string.a4k);
        initView();
        cfk();
        AppMethodBeat.m2505o(44621);
    }

    public final void initView() {
        AppMethodBeat.m2504i(44622);
        this.pNq = (ListView) findViewById(2131821671);
        this.leb = LayoutInflater.from(this).inflate(2130968581, null);
        this.icA = new C46696j(this);
        this.pNr = new C13042a(this, (byte) 0);
        this.pNq.addFooterView(this.leb);
        this.pNq.setAdapter(this.pNr);
        this.pNq.setOnItemLongClickListener(new C130381());
        this.pNq.setOnScrollListener(new C130352());
        AppMethodBeat.m2505o(44622);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.m2504i(44623);
        contextMenu.add(0, 1, 0, C25738R.string.a50);
        AppMethodBeat.m2505o(44623);
    }

    public void onMMMenuItemSelected(MenuItem menuItem, int i) {
        AppMethodBeat.m2504i(44624);
        atf atf = (atf) this.pNq.getItemAtPosition(((AdapterContextMenuInfo) menuItem.getMenuInfo()).position);
        if (menuItem.getItemId() == 1 && atf != null) {
            C4990ab.m7417i("MicroMsg.BankRemitHistoryUI", "delete record: %s", atf.vPX);
            C1207m c13020e = new C13020e(r0);
            c13020e.mo70321o(this);
            mo39970a(c13020e, true, true);
        }
        AppMethodBeat.m2505o(44624);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(44625);
        if (c1207m instanceof C46916i) {
            final C46916i c46916i = (C46916i) c1207m;
            c46916i.mo70318a(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(44610);
                    if (c46916i.pLA.wvw != null) {
                        C4990ab.m7417i("MicroMsg.BankRemitHistoryUI", "history size: %s", Integer.valueOf(c46916i.pLA.wvw.size()));
                        if (c46916i.pLA.wvw.size() < c46916i.limit) {
                            C4990ab.m7417i("MicroMsg.BankRemitHistoryUI", "is last: %s", Integer.valueOf(BankRemitHistoryUI.this.offset));
                            BankRemitHistoryUI.this.gnp = true;
                            BankRemitHistoryUI.this.pNq.removeFooterView(BankRemitHistoryUI.this.leb);
                        }
                        if (c46916i.pLA.wvw != null) {
                            BankRemitHistoryUI.this.offset = BankRemitHistoryUI.this.offset + c46916i.pLA.wvw.size();
                            BankRemitHistoryUI.this.kPz.addAll(c46916i.pLA.wvw);
                            BankRemitHistoryUI.this.pNr.notifyDataSetChanged();
                            AppMethodBeat.m2505o(44610);
                            return;
                        }
                    }
                    C4990ab.m7416i("MicroMsg.BankRemitHistoryUI", "return history is null");
                    BankRemitHistoryUI.this.gnp = true;
                    BankRemitHistoryUI.this.pNq.removeFooterView(BankRemitHistoryUI.this.leb);
                    AppMethodBeat.m2505o(44610);
                }
            }).mo70319b(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(44609);
                    C4990ab.m7413e("MicroMsg.BankRemitHistoryUI", "history response error: %s, %s", Integer.valueOf(c46916i.pLA.kCl), c46916i.pLA.kCm);
                    AppMethodBeat.m2505o(44609);
                }
            }).mo70320c(new C130433());
            this.gno = false;
        } else if (c1207m instanceof C13020e) {
            final C13020e c13020e = (C13020e) c1207m;
            c13020e.mo70318a(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(44613);
                    BankRemitHistoryUI.m21014a(BankRemitHistoryUI.this, c13020e.kBD);
                    AppMethodBeat.m2505o(44613);
                }
            }).mo70319b(new C40929a() {
                /* renamed from: e */
                public final void mo7656e(int i, int i2, String str, C1207m c1207m) {
                    AppMethodBeat.m2504i(44612);
                    C4990ab.m7413e("MicroMsg.BankRemitHistoryUI", "history response: %s, %s", Integer.valueOf(c13020e.pLw.kCl), c13020e.pLw.kCm);
                    AppMethodBeat.m2505o(44612);
                }
            }).mo70320c(new C130416());
        }
        AppMethodBeat.m2505o(44625);
        return false;
    }

    public final int getLayoutId() {
        return 2130968819;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(44626);
        super.onDestroy();
        mo39993ng(1511);
        mo39993ng(1737);
        AppMethodBeat.m2505o(44626);
    }

    private void cfk() {
        AppMethodBeat.m2504i(44627);
        C4990ab.m7417i("MicroMsg.BankRemitHistoryUI", "fetch data: %s, %s", Integer.valueOf(this.limit), Integer.valueOf(this.offset));
        this.gno = true;
        C1207m c46916i = new C46916i(this.limit, this.offset);
        c46916i.mo70321o(this);
        mo39970a(c46916i, false, false);
        AppMethodBeat.m2505o(44627);
    }
}
