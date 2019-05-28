package com.tencent.p177mm.plugin.address.p276ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.plugin.address.model.C18974b;
import com.tencent.p177mm.plugin.address.model.C33048a;
import com.tencent.p177mm.plugin.address.p1218e.C18972d;
import com.tencent.p177mm.plugin.address.p1218e.C18973e;
import com.tencent.p177mm.plugin.address.p1467a.C33045a;
import com.tencent.p177mm.plugin.address.p718b.p719b.C6736a;
import com.tencent.p177mm.plugin.p984j.p985a.C12328b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.address.ui.InvoiceListUI */
public class InvoiceListUI extends MMActivity implements C1202f {
    private TextView gJn = null;
    private boolean gJy = false;
    private C12328b gKb;
    private C18982a gKc;
    private ListView gKd;
    private C6736a gKe = null;
    private TextView gKf = null;
    private LinkedList<C12328b> gKg = new LinkedList();
    private boolean gKh = false;
    private boolean gKi = false;
    private Object lockObj = new Object();

    /* renamed from: com.tencent.mm.plugin.address.ui.InvoiceListUI$6 */
    class C189796 implements OnClickListener {
        C189796() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(16863);
            C4990ab.m7416i("MicroMsg.InvoiceListUI", "dismiss DisclaimerDailog...");
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(16863);
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.InvoiceListUI$3 */
    class C189803 implements OnItemLongClickListener {
        C189803() {
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
            AppMethodBeat.m2504i(16860);
            C30379h.m48422a(InvoiceListUI.this.mController.ylL, null, InvoiceListUI.this.getResources().getStringArray(C25738R.array.f12614n), null, new C30391c() {
                /* renamed from: iE */
                public final void mo7700iE(int i) {
                    C12328b c12328b;
                    AppMethodBeat.m2504i(16859);
                    synchronized (InvoiceListUI.this.lockObj) {
                        try {
                            if (i < InvoiceListUI.this.gKg.size()) {
                                c12328b = (C12328b) InvoiceListUI.this.gKg.get(i);
                            } else {
                                c12328b = null;
                            }
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.m2505o(16859);
                        }
                    }
                    if (c12328b != null) {
                        switch (i) {
                            case 0:
                                InvoiceListUI.m29555a(InvoiceListUI.this, c12328b.nuH);
                                AppMethodBeat.m2505o(16859);
                                return;
                            case 1:
                                C1207m c33048a = new C33048a(c12328b.nuH);
                                InvoiceListUI.this.gKb = null;
                                C9638aw.m17182Rg().mo14541a(c33048a, 0);
                                AppMethodBeat.m2505o(16859);
                                return;
                            case 2:
                                InvoiceListUI.m29557b(InvoiceListUI.this, c12328b);
                                break;
                        }
                        AppMethodBeat.m2505o(16859);
                    }
                }
            });
            AppMethodBeat.m2505o(16860);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.InvoiceListUI$4 */
    class C189814 implements OnMenuItemClickListener {
        C189814() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(16861);
            InvoiceListUI.this.setResult(0);
            InvoiceListUI.this.finish();
            AppMethodBeat.m2505o(16861);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.InvoiceListUI$a */
    public class C18982a extends BaseAdapter {
        private final Context context;
        List<C12328b> items = new ArrayList();

        /* renamed from: com.tencent.mm.plugin.address.ui.InvoiceListUI$a$a */
        class C18983a {
            TextView gKl;
            ImageView gKm;
            TextView gtb;

            C18983a() {
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(16868);
            C12328b ni = m29563ni(i);
            AppMethodBeat.m2505o(16868);
            return ni;
        }

        public C18982a(Context context) {
            AppMethodBeat.m2504i(16864);
            this.context = context;
            AppMethodBeat.m2505o(16864);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C18983a c18983a;
            AppMethodBeat.m2504i(16865);
            C18983a c18983a2 = new C18983a();
            if (view == null) {
                view = View.inflate(this.context, 2130971041, null);
                c18983a2.gKm = (ImageView) view.findViewById(2131828587);
                c18983a2.gKl = (TextView) view.findViewById(2131828586);
                c18983a2.gtb = (TextView) view.findViewById(2131828585);
                view.setTag(c18983a2);
                c18983a = c18983a2;
            } else {
                c18983a = (C18983a) view.getTag();
            }
            C12328b ni = m29563ni(i);
            if (ni.type != null && ni.type.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                c18983a.gKl.setText(C25738R.string.cfb);
                c18983a.gtb.setText(ni.title);
            } else if (ni.type != null && ni.type.equals("1")) {
                c18983a.gKl.setText(C25738R.string.cfh);
                c18983a.gtb.setText(ni.nuI);
            }
            if (InvoiceListUI.this.gJy && InvoiceListUI.this.gKb != null && InvoiceListUI.this.gKb.nuH == ni.nuH) {
                c18983a.gKm.setImageResource(C1318a.radio_on);
            } else {
                c18983a.gKm.setImageBitmap(null);
            }
            AppMethodBeat.m2505o(16865);
            return view;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(16866);
            int size = this.items.size();
            AppMethodBeat.m2505o(16866);
            return size;
        }

        /* renamed from: ni */
        private C12328b m29563ni(int i) {
            AppMethodBeat.m2504i(16867);
            C12328b c12328b = (C12328b) this.items.get(i);
            AppMethodBeat.m2505o(16867);
            return c12328b;
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.InvoiceListUI$2 */
    class C189842 implements OnItemClickListener {
        C189842() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(16858);
            C4990ab.m7410d("MicroMsg.InvoiceListUI", "select pos ".concat(String.valueOf(i)));
            synchronized (InvoiceListUI.this.lockObj) {
                try {
                    if (i < InvoiceListUI.this.gKg.size()) {
                        InvoiceListUI.this.gKb = (C12328b) InvoiceListUI.this.gKg.get(i);
                        if (!InvoiceListUI.this.gJy && InvoiceListUI.this.gKb != null) {
                            InvoiceListUI.m29555a(InvoiceListUI.this, InvoiceListUI.this.gKb.nuH);
                        } else if (!(InvoiceListUI.this.gKb == null || InvoiceListUI.this.gKb.nuH == 0)) {
                            Intent intent = new Intent();
                            intent.putExtra("choose_invoice_title_info", C18973e.m29545a(InvoiceListUI.this.gKb));
                            InvoiceListUI.this.setResult(-1, intent);
                            InvoiceListUI.this.finish();
                        }
                    }
                } finally {
                    AppMethodBeat.m2505o(16858);
                }
            }
            InvoiceListUI.this.gKc.notifyDataSetChanged();
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.InvoiceListUI$5 */
    class C189855 implements OnMenuItemClickListener {
        C189855() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(16862);
            InvoiceListUI.m29554a(InvoiceListUI.this);
            AppMethodBeat.m2505o(16862);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.InvoiceListUI$1 */
    class C189861 implements View.OnClickListener {
        C189861() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(16857);
            InvoiceListUI.m29554a(InvoiceListUI.this);
            AppMethodBeat.m2505o(16857);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public InvoiceListUI() {
        AppMethodBeat.m2504i(16869);
        AppMethodBeat.m2505o(16869);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(16870);
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.gJy = intent.getBooleanExtra("launch_from_webview", false);
        this.gKh = intent.getBooleanExtra("launch_from_appbrand", false);
        if (this.gJy || this.gKh) {
            this.gJy = true;
        }
        if (this.gJy) {
            C9638aw.m17190ZK();
            boolean booleanValue = ((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_INVOICE_HAS_SHOW_DISCLAIMER_DIALOG_BOOLEAN_SYNC, Boolean.TRUE)).booleanValue();
            C4990ab.m7416i("MicroMsg.InvoiceListUI", "showDisclaimerDailog..isShowDisclaimerDialog ".concat(String.valueOf(booleanValue)));
            if (booleanValue) {
                C4990ab.m7416i("MicroMsg.InvoiceListUI", "showDisclaimerDialog");
                C30379h.m48447a((Context) this, getString(C25738R.string.cfs), getString(C25738R.string.cft), getString(C25738R.string.f8636aj), false, new C189796());
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERINFO_INVOICE_HAS_SHOW_DISCLAIMER_DIALOG_BOOLEAN_SYNC, Boolean.FALSE);
            }
        }
        setMMTitle((int) C25738R.string.e90);
        C9638aw.m17182Rg().mo14539a(1194, (C1202f) this);
        C9638aw.m17182Rg().mo14539a(1191, (C1202f) this);
        initView();
        asc();
        AppMethodBeat.m2505o(16870);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(16871);
        C9638aw.m17182Rg().mo14546b(1194, (C1202f) this);
        C9638aw.m17182Rg().mo14546b(1191, (C1202f) this);
        super.onDestroy();
        AppMethodBeat.m2505o(16871);
    }

    public void onResume() {
        AppMethodBeat.m2504i(16872);
        C9638aw.m17182Rg().mo14541a(new C18974b(), 0);
        super.onResume();
        AppMethodBeat.m2505o(16872);
    }

    private void asc() {
        AppMethodBeat.m2504i(16873);
        synchronized (this.lockObj) {
            try {
                C33045a.arQ();
                this.gKg = C33045a.arR().gIF.nuG;
                this.gKc.items = this.gKg;
                this.gKg.size();
                this.gKc.notifyDataSetChanged();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(16873);
            }
        }
    }

    public final void initView() {
        AppMethodBeat.m2504i(16874);
        this.gKf = (TextView) findViewById(2131825031);
        if (this.gKf != null) {
            this.gKf.setVisibility(8);
        }
        if (this.gJy) {
            this.gJn = (TextView) findViewById(2131825032);
            if (this.gJn != null) {
                this.gJn.setVisibility(0);
            }
        } else {
            this.gJn = (TextView) findViewById(2131825032);
            if (this.gJn != null) {
                this.gJn.setVisibility(8);
            }
        }
        this.gKf.setOnClickListener(new C189861());
        this.gKd = (ListView) findViewById(2131825029);
        this.gKc = new C18982a(this);
        this.gKd.setAdapter(this.gKc);
        this.gKd.setOnItemClickListener(new C189842());
        this.gKd.setOnItemLongClickListener(new C189803());
        this.gKc.notifyDataSetChanged();
        setBackBtn(new C189814());
        addIconOptionMenu(0, C25738R.string.e5i, C1318a.actionbar_icon_dark_add, new C189855());
        AppMethodBeat.m2505o(16874);
    }

    public final int getLayoutId() {
        return 2130969876;
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(16875);
        if (i == 0 && i2 == 0) {
            if (c1207m.getType() == 1191) {
                asc();
                if (this.gJy) {
                    C33045a.arQ();
                    if (C33045a.arR().gIF.nuG.size() == 0 && !this.gKi) {
                        Intent intent = new Intent();
                        intent.setClass(this, AddInvoiceUI.class);
                        intent.putExtra("launch_from_webview", true);
                        startActivityForResult(intent, 1);
                        AppMethodBeat.m2505o(16875);
                        return;
                    }
                }
            } else if (c1207m.getType() == 1194) {
                C9638aw.m17182Rg().mo14541a(new C18974b(), 0);
                this.gKi = true;
            }
        }
        AppMethodBeat.m2505o(16875);
    }

    /* renamed from: nh */
    private void m29562nh(int i) {
        AppMethodBeat.m2504i(16876);
        Intent intent = new Intent();
        if (i != 0) {
            intent.setClass(this, QrcodeInvoiceUI.class);
            intent.putExtra("invoice_id", i);
        } else {
            intent.setClass(this, AddInvoiceUI.class);
            intent.putExtra("launch_from_invoicelist_webview", this.gJy);
            intent.putExtra("invoice_id", i);
        }
        startActivity(intent);
        AppMethodBeat.m2505o(16876);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(16877);
        if (i == 1) {
            if (-1 == i2) {
                C12328b c12328b;
                if (intent == null) {
                    C4990ab.m7412e("MicroMsg.InvoiceUtil", "intent is null");
                    c12328b = null;
                } else {
                    c12328b = new C12328b();
                    c12328b.type = intent.getStringExtra("type");
                    if (c12328b.type == null || !c12328b.type.equals("1")) {
                        c12328b.title = intent.getStringExtra("title");
                        c12328b.nuJ = intent.getStringExtra("tax_number");
                        c12328b.nuP = intent.getStringExtra("company_address");
                        c12328b.nuN = intent.getStringExtra("telephone");
                        c12328b.nuL = intent.getStringExtra("bank_name");
                        c12328b.nuK = intent.getStringExtra("bank_account");
                    } else {
                        c12328b.nuI = intent.getStringExtra("title");
                    }
                }
                Intent intent2 = new Intent();
                intent2.putExtra("choose_invoice_title_info", C18973e.m29545a(c12328b));
                setResult(-1, intent2);
            } else {
                setResult(0);
            }
            finish();
        }
        AppMethodBeat.m2505o(16877);
    }

    /* renamed from: a */
    static /* synthetic */ void m29554a(InvoiceListUI invoiceListUI) {
        AppMethodBeat.m2504i(16878);
        C7060h.pYm.mo8381e(14199, Integer.valueOf(2));
        invoiceListUI.m29562nh(0);
        AppMethodBeat.m2505o(16878);
    }

    /* renamed from: b */
    static /* synthetic */ void m29557b(InvoiceListUI invoiceListUI, C12328b c12328b) {
        AppMethodBeat.m2504i(16880);
        if (c12328b != null) {
            StringBuilder stringBuilder = new StringBuilder();
            if (c12328b.type != null && c12328b.type.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                if (!TextUtils.isEmpty(c12328b.title)) {
                    stringBuilder.append(invoiceListUI.getString(C25738R.string.cfu));
                    stringBuilder.append("：");
                    stringBuilder.append(c12328b.title);
                    stringBuilder.append(" \n");
                }
                if (!TextUtils.isEmpty(c12328b.nuJ)) {
                    stringBuilder.append(invoiceListUI.getString(C25738R.string.cfp));
                    stringBuilder.append("：");
                    stringBuilder.append(c12328b.nuJ);
                    stringBuilder.append(" \n");
                }
                if (!TextUtils.isEmpty(c12328b.nuP)) {
                    stringBuilder.append(invoiceListUI.getString(C25738R.string.cf_));
                    stringBuilder.append("：");
                    stringBuilder.append(c12328b.nuP);
                    stringBuilder.append(" \n");
                }
                if (!TextUtils.isEmpty(c12328b.nuN)) {
                    stringBuilder.append(invoiceListUI.getString(C25738R.string.cfk));
                    stringBuilder.append("：");
                    stringBuilder.append(c12328b.nuN);
                    stringBuilder.append(" \n");
                }
                if (!TextUtils.isEmpty(c12328b.nuL)) {
                    stringBuilder.append(invoiceListUI.getString(C25738R.string.cf3));
                    stringBuilder.append("：");
                    stringBuilder.append(c12328b.nuL);
                    stringBuilder.append(" \n");
                }
                if (!TextUtils.isEmpty(c12328b.nuK)) {
                    stringBuilder.append(invoiceListUI.getString(C25738R.string.cf5));
                    stringBuilder.append("：");
                    stringBuilder.append(c12328b.nuK);
                    stringBuilder.append(" \n");
                }
            } else if (!(c12328b.type == null || !c12328b.type.equals("1") || TextUtils.isEmpty(c12328b.nuI))) {
                stringBuilder.append(invoiceListUI.getString(C25738R.string.cfu));
                stringBuilder.append("：");
                stringBuilder.append(c12328b.nuI);
                stringBuilder.append(" \n");
            }
            try {
                C18972d.m29544wG(stringBuilder.toString());
                AppMethodBeat.m2505o(16880);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.InvoiceListUI", e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(16880);
    }
}
