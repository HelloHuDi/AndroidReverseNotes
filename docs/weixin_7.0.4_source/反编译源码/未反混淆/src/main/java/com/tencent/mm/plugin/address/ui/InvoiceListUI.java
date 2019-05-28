package com.tencent.mm.plugin.address.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.address.e.d;
import com.tencent.mm.plugin.address.e.e;
import com.tencent.mm.plugin.j.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InvoiceListUI extends MMActivity implements f {
    private TextView gJn = null;
    private boolean gJy = false;
    private b gKb;
    private a gKc;
    private ListView gKd;
    private com.tencent.mm.plugin.address.b.b.a gKe = null;
    private TextView gKf = null;
    private LinkedList<b> gKg = new LinkedList();
    private boolean gKh = false;
    private boolean gKi = false;
    private Object lockObj = new Object();

    public class a extends BaseAdapter {
        private final Context context;
        List<b> items = new ArrayList();

        class a {
            TextView gKl;
            ImageView gKm;
            TextView gtb;

            a() {
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(16868);
            b ni = ni(i);
            AppMethodBeat.o(16868);
            return ni;
        }

        public a(Context context) {
            AppMethodBeat.i(16864);
            this.context = context;
            AppMethodBeat.o(16864);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(16865);
            a aVar2 = new a();
            if (view == null) {
                view = View.inflate(this.context, R.layout.b2p, null);
                aVar2.gKm = (ImageView) view.findViewById(R.id.f5e);
                aVar2.gKl = (TextView) view.findViewById(R.id.f5d);
                aVar2.gtb = (TextView) view.findViewById(R.id.f5c);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            b ni = ni(i);
            if (ni.type != null && ni.type.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                aVar.gKl.setText(R.string.cfb);
                aVar.gtb.setText(ni.title);
            } else if (ni.type != null && ni.type.equals("1")) {
                aVar.gKl.setText(R.string.cfh);
                aVar.gtb.setText(ni.nuI);
            }
            if (InvoiceListUI.this.gJy && InvoiceListUI.this.gKb != null && InvoiceListUI.this.gKb.nuH == ni.nuH) {
                aVar.gKm.setImageResource(R.raw.radio_on);
            } else {
                aVar.gKm.setImageBitmap(null);
            }
            AppMethodBeat.o(16865);
            return view;
        }

        public final int getCount() {
            AppMethodBeat.i(16866);
            int size = this.items.size();
            AppMethodBeat.o(16866);
            return size;
        }

        private b ni(int i) {
            AppMethodBeat.i(16867);
            b bVar = (b) this.items.get(i);
            AppMethodBeat.o(16867);
            return bVar;
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public InvoiceListUI() {
        AppMethodBeat.i(16869);
        AppMethodBeat.o(16869);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(16870);
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.gJy = intent.getBooleanExtra("launch_from_webview", false);
        this.gKh = intent.getBooleanExtra("launch_from_appbrand", false);
        if (this.gJy || this.gKh) {
            this.gJy = true;
        }
        if (this.gJy) {
            aw.ZK();
            boolean booleanValue = ((Boolean) c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_INVOICE_HAS_SHOW_DISCLAIMER_DIALOG_BOOLEAN_SYNC, Boolean.TRUE)).booleanValue();
            ab.i("MicroMsg.InvoiceListUI", "showDisclaimerDailog..isShowDisclaimerDialog ".concat(String.valueOf(booleanValue)));
            if (booleanValue) {
                ab.i("MicroMsg.InvoiceListUI", "showDisclaimerDialog");
                h.a((Context) this, getString(R.string.cfs), getString(R.string.cft), getString(R.string.aj), false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(16863);
                        ab.i("MicroMsg.InvoiceListUI", "dismiss DisclaimerDailog...");
                        dialogInterface.dismiss();
                        AppMethodBeat.o(16863);
                    }
                });
                aw.ZK();
                c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_INVOICE_HAS_SHOW_DISCLAIMER_DIALOG_BOOLEAN_SYNC, Boolean.FALSE);
            }
        }
        setMMTitle((int) R.string.e90);
        aw.Rg().a(1194, (f) this);
        aw.Rg().a(1191, (f) this);
        initView();
        asc();
        AppMethodBeat.o(16870);
    }

    public void onDestroy() {
        AppMethodBeat.i(16871);
        aw.Rg().b(1194, (f) this);
        aw.Rg().b(1191, (f) this);
        super.onDestroy();
        AppMethodBeat.o(16871);
    }

    public void onResume() {
        AppMethodBeat.i(16872);
        aw.Rg().a(new com.tencent.mm.plugin.address.model.b(), 0);
        super.onResume();
        AppMethodBeat.o(16872);
    }

    private void asc() {
        AppMethodBeat.i(16873);
        synchronized (this.lockObj) {
            try {
                com.tencent.mm.plugin.address.a.a.arQ();
                this.gKg = com.tencent.mm.plugin.address.a.a.arR().gIF.nuG;
                this.gKc.items = this.gKg;
                this.gKg.size();
                this.gKc.notifyDataSetChanged();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(16873);
            }
        }
    }

    public final void initView() {
        AppMethodBeat.i(16874);
        this.gKf = (TextView) findViewById(R.id.cj_);
        if (this.gKf != null) {
            this.gKf.setVisibility(8);
        }
        if (this.gJy) {
            this.gJn = (TextView) findViewById(R.id.cja);
            if (this.gJn != null) {
                this.gJn.setVisibility(0);
            }
        } else {
            this.gJn = (TextView) findViewById(R.id.cja);
            if (this.gJn != null) {
                this.gJn.setVisibility(8);
            }
        }
        this.gKf.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(16857);
                InvoiceListUI.a(InvoiceListUI.this);
                AppMethodBeat.o(16857);
            }
        });
        this.gKd = (ListView) findViewById(R.id.cj8);
        this.gKc = new a(this);
        this.gKd.setAdapter(this.gKc);
        this.gKd.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(16858);
                ab.d("MicroMsg.InvoiceListUI", "select pos ".concat(String.valueOf(i)));
                synchronized (InvoiceListUI.this.lockObj) {
                    try {
                        if (i < InvoiceListUI.this.gKg.size()) {
                            InvoiceListUI.this.gKb = (b) InvoiceListUI.this.gKg.get(i);
                            if (!InvoiceListUI.this.gJy && InvoiceListUI.this.gKb != null) {
                                InvoiceListUI.a(InvoiceListUI.this, InvoiceListUI.this.gKb.nuH);
                            } else if (!(InvoiceListUI.this.gKb == null || InvoiceListUI.this.gKb.nuH == 0)) {
                                Intent intent = new Intent();
                                intent.putExtra("choose_invoice_title_info", e.a(InvoiceListUI.this.gKb));
                                InvoiceListUI.this.setResult(-1, intent);
                                InvoiceListUI.this.finish();
                            }
                        }
                    } finally {
                        AppMethodBeat.o(16858);
                    }
                }
                InvoiceListUI.this.gKc.notifyDataSetChanged();
            }
        });
        this.gKd.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                AppMethodBeat.i(16860);
                h.a(InvoiceListUI.this.mController.ylL, null, InvoiceListUI.this.getResources().getStringArray(R.array.n), null, new h.c() {
                    public final void iE(int i) {
                        b bVar;
                        AppMethodBeat.i(16859);
                        synchronized (InvoiceListUI.this.lockObj) {
                            try {
                                if (i < InvoiceListUI.this.gKg.size()) {
                                    bVar = (b) InvoiceListUI.this.gKg.get(i);
                                } else {
                                    bVar = null;
                                }
                            } finally {
                                while (true) {
                                }
                                AppMethodBeat.o(16859);
                            }
                        }
                        if (bVar != null) {
                            switch (i) {
                                case 0:
                                    InvoiceListUI.a(InvoiceListUI.this, bVar.nuH);
                                    AppMethodBeat.o(16859);
                                    return;
                                case 1:
                                    m aVar = new com.tencent.mm.plugin.address.model.a(bVar.nuH);
                                    InvoiceListUI.this.gKb = null;
                                    aw.Rg().a(aVar, 0);
                                    AppMethodBeat.o(16859);
                                    return;
                                case 2:
                                    InvoiceListUI.b(InvoiceListUI.this, bVar);
                                    break;
                            }
                            AppMethodBeat.o(16859);
                        }
                    }
                });
                AppMethodBeat.o(16860);
                return true;
            }
        });
        this.gKc.notifyDataSetChanged();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(16861);
                InvoiceListUI.this.setResult(0);
                InvoiceListUI.this.finish();
                AppMethodBeat.o(16861);
                return true;
            }
        });
        addIconOptionMenu(0, R.string.e5i, R.raw.actionbar_icon_dark_add, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(16862);
                InvoiceListUI.a(InvoiceListUI.this);
                AppMethodBeat.o(16862);
                return true;
            }
        });
        AppMethodBeat.o(16874);
    }

    public final int getLayoutId() {
        return R.layout.a8b;
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(16875);
        if (i == 0 && i2 == 0) {
            if (mVar.getType() == 1191) {
                asc();
                if (this.gJy) {
                    com.tencent.mm.plugin.address.a.a.arQ();
                    if (com.tencent.mm.plugin.address.a.a.arR().gIF.nuG.size() == 0 && !this.gKi) {
                        Intent intent = new Intent();
                        intent.setClass(this, AddInvoiceUI.class);
                        intent.putExtra("launch_from_webview", true);
                        startActivityForResult(intent, 1);
                        AppMethodBeat.o(16875);
                        return;
                    }
                }
            } else if (mVar.getType() == 1194) {
                aw.Rg().a(new com.tencent.mm.plugin.address.model.b(), 0);
                this.gKi = true;
            }
        }
        AppMethodBeat.o(16875);
    }

    private void nh(int i) {
        AppMethodBeat.i(16876);
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
        AppMethodBeat.o(16876);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(16877);
        if (i == 1) {
            if (-1 == i2) {
                b bVar;
                if (intent == null) {
                    ab.e("MicroMsg.InvoiceUtil", "intent is null");
                    bVar = null;
                } else {
                    bVar = new b();
                    bVar.type = intent.getStringExtra("type");
                    if (bVar.type == null || !bVar.type.equals("1")) {
                        bVar.title = intent.getStringExtra("title");
                        bVar.nuJ = intent.getStringExtra("tax_number");
                        bVar.nuP = intent.getStringExtra("company_address");
                        bVar.nuN = intent.getStringExtra("telephone");
                        bVar.nuL = intent.getStringExtra("bank_name");
                        bVar.nuK = intent.getStringExtra("bank_account");
                    } else {
                        bVar.nuI = intent.getStringExtra("title");
                    }
                }
                Intent intent2 = new Intent();
                intent2.putExtra("choose_invoice_title_info", e.a(bVar));
                setResult(-1, intent2);
            } else {
                setResult(0);
            }
            finish();
        }
        AppMethodBeat.o(16877);
    }

    static /* synthetic */ void a(InvoiceListUI invoiceListUI) {
        AppMethodBeat.i(16878);
        com.tencent.mm.plugin.report.service.h.pYm.e(14199, Integer.valueOf(2));
        invoiceListUI.nh(0);
        AppMethodBeat.o(16878);
    }

    static /* synthetic */ void b(InvoiceListUI invoiceListUI, b bVar) {
        AppMethodBeat.i(16880);
        if (bVar != null) {
            StringBuilder stringBuilder = new StringBuilder();
            if (bVar.type != null && bVar.type.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                if (!TextUtils.isEmpty(bVar.title)) {
                    stringBuilder.append(invoiceListUI.getString(R.string.cfu));
                    stringBuilder.append("：");
                    stringBuilder.append(bVar.title);
                    stringBuilder.append(" \n");
                }
                if (!TextUtils.isEmpty(bVar.nuJ)) {
                    stringBuilder.append(invoiceListUI.getString(R.string.cfp));
                    stringBuilder.append("：");
                    stringBuilder.append(bVar.nuJ);
                    stringBuilder.append(" \n");
                }
                if (!TextUtils.isEmpty(bVar.nuP)) {
                    stringBuilder.append(invoiceListUI.getString(R.string.cf_));
                    stringBuilder.append("：");
                    stringBuilder.append(bVar.nuP);
                    stringBuilder.append(" \n");
                }
                if (!TextUtils.isEmpty(bVar.nuN)) {
                    stringBuilder.append(invoiceListUI.getString(R.string.cfk));
                    stringBuilder.append("：");
                    stringBuilder.append(bVar.nuN);
                    stringBuilder.append(" \n");
                }
                if (!TextUtils.isEmpty(bVar.nuL)) {
                    stringBuilder.append(invoiceListUI.getString(R.string.cf3));
                    stringBuilder.append("：");
                    stringBuilder.append(bVar.nuL);
                    stringBuilder.append(" \n");
                }
                if (!TextUtils.isEmpty(bVar.nuK)) {
                    stringBuilder.append(invoiceListUI.getString(R.string.cf5));
                    stringBuilder.append("：");
                    stringBuilder.append(bVar.nuK);
                    stringBuilder.append(" \n");
                }
            } else if (!(bVar.type == null || !bVar.type.equals("1") || TextUtils.isEmpty(bVar.nuI))) {
                stringBuilder.append(invoiceListUI.getString(R.string.cfu));
                stringBuilder.append("：");
                stringBuilder.append(bVar.nuI);
                stringBuilder.append(" \n");
            }
            try {
                d.wG(stringBuilder.toString());
                AppMethodBeat.o(16880);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.InvoiceListUI", e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(16880);
    }
}
