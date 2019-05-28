package com.tencent.mm.plugin.address.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.p;
import com.tencent.mm.ai.m;
import com.tencent.mm.ba.k;
import com.tencent.mm.g.a.ki;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.plugin.address.model.d;
import com.tencent.mm.plugin.address.model.e;
import com.tencent.mm.plugin.address.model.f;
import com.tencent.mm.plugin.address.model.g;
import com.tencent.mm.plugin.appbrand.jsapi.k.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.a.c;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WalletSelectAddrUI extends MMActivity implements com.tencent.mm.plugin.address.c.a {
    private boolean gJy = false;
    private ListView gKd;
    private List<b> gLa = new LinkedList();
    private b gLb;
    private a gLc;
    private com.tencent.mm.plugin.address.c.b gLd = null;
    private View gLe;
    private TextView gLf = null;
    private p gLg;
    private boolean gLh = false;
    private boolean gLi = false;
    private c gLj = null;
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
            AppMethodBeat.i(16993);
            b nk = nk(i);
            AppMethodBeat.o(16993);
            return nk;
        }

        public a(Context context) {
            AppMethodBeat.i(16989);
            this.context = context;
            AppMethodBeat.o(16989);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(16990);
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
            b nk = nk(i);
            StringBuilder stringBuilder = new StringBuilder();
            if (!TextUtils.isEmpty(nk.gJa)) {
                stringBuilder.append(nk.gJa);
            }
            if (!TextUtils.isEmpty(nk.gJb)) {
                stringBuilder.append(" ");
                stringBuilder.append(nk.gJb);
            }
            if (!TextUtils.isEmpty(nk.gJc)) {
                stringBuilder.append(" ");
                stringBuilder.append(nk.gJc);
            }
            if (!TextUtils.isEmpty(nk.gJe)) {
                stringBuilder.append(" ");
                stringBuilder.append(nk.gJe);
            }
            aVar.gKl.setText(stringBuilder.toString());
            aVar.gtb.setText(nk.gJf + "，" + nk.gJg);
            if (WalletSelectAddrUI.this.gJy && WalletSelectAddrUI.this.gLb != null && WalletSelectAddrUI.this.gLb.id == nk.id) {
                aVar.gKm.setImageResource(R.raw.radio_on);
            } else {
                aVar.gKm.setImageBitmap(null);
            }
            AppMethodBeat.o(16990);
            return view;
        }

        public final int getCount() {
            AppMethodBeat.i(16991);
            int size = this.items.size();
            AppMethodBeat.o(16991);
            return size;
        }

        private b nk(int i) {
            AppMethodBeat.i(16992);
            b bVar = (b) this.items.get(i);
            AppMethodBeat.o(16992);
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

    public WalletSelectAddrUI() {
        AppMethodBeat.i(16994);
        AppMethodBeat.o(16994);
    }

    static /* synthetic */ void a(WalletSelectAddrUI walletSelectAddrUI, String str, String str2) {
        AppMethodBeat.i(17009);
        walletSelectAddrUI.bn(str, str2);
        AppMethodBeat.o(17009);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(16995);
        super.onCreate(bundle);
        this.gLd = new com.tencent.mm.plugin.address.c.b(this, this);
        Intent intent = getIntent();
        this.gLh = intent.getBooleanExtra("launch_from_appbrand", false);
        this.gLi = intent.getBooleanExtra("launch_from_remittance", false);
        if (intent.getBooleanExtra("launch_from_webview", false) || this.gLh) {
            this.gJy = true;
            this.mController.contentView.setVisibility(8);
            if (this.gLh) {
                getWindow().setBackgroundDrawableResource(R.color.vs);
            }
            ab.i("MicroMsg.WalletSelectAddrUI", "showDisclaimerDailog()");
            aw.ZK();
            if (((Boolean) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_ADDRESS_HAS_SHOW_DISCLAIMER_DIALOG_BOOLEAN_SYNC, Boolean.TRUE)).booleanValue()) {
                ab.i("MicroMsg.WalletSelectAddrUI", "isShowDisclaimerDialog");
                h.a((Context) this, getString(R.string.en), getString(R.string.eo), getString(R.string.aj), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(16976);
                        dialogInterface.dismiss();
                        AppMethodBeat.o(16976);
                    }
                });
                aw.ZK();
                com.tencent.mm.model.c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_ADDRESS_HAS_SHOW_DISCLAIMER_DIALOG_BOOLEAN_SYNC, Boolean.FALSE);
            }
        }
        setMMTitle((int) R.string.em);
        this.gLd.nf(417);
        this.gLd.nf(416);
        this.gLd.nf(419);
        this.gLd.nf(r.CTRL_INDEX);
        this.gLd.g(new e(intent.getStringExtra("req_url"), intent.getStringExtra("req_app_id"), 2));
        aw.ZK();
        this.gLg = new p(bo.a((Integer) com.tencent.mm.model.c.Ry().get(9, null), 0));
        initView();
        aw.ZK();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            aw.Rg().a(new k(12), 0);
        }
        AppMethodBeat.o(16995);
    }

    public void onDestroy() {
        AppMethodBeat.i(16996);
        super.onDestroy();
        this.gLd.ng(417);
        this.gLd.ng(416);
        this.gLd.ng(419);
        this.gLd.ng(r.CTRL_INDEX);
        AppMethodBeat.o(16996);
    }

    public void onResume() {
        AppMethodBeat.i(16997);
        super.onResume();
        asc();
        AppMethodBeat.o(16997);
    }

    private void asc() {
        AppMethodBeat.i(16998);
        synchronized (this.lockObj) {
            try {
                com.tencent.mm.plugin.address.a.a.arQ();
                this.gLa = com.tencent.mm.plugin.address.a.a.arS().gIQ.gIY;
                this.gLc.items = this.gLa;
                this.gLa.size();
                this.gLe.setVisibility(8);
                this.gLc.notifyDataSetChanged();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(16998);
            }
        }
    }

    public final void initView() {
        AppMethodBeat.i(16999);
        this.gLf = (TextView) findViewById(R.id.f5h);
        this.gLf.setVisibility(8);
        this.gLf.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(16979);
                h.a(WalletSelectAddrUI.this, true, WalletSelectAddrUI.this.getString(R.string.ex, new Object[]{WalletSelectAddrUI.this.gLg.toString()}), "", WalletSelectAddrUI.this.getString(R.string.ey), WalletSelectAddrUI.this.getString(R.string.or), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(16978);
                        WalletSelectAddrUI.b(WalletSelectAddrUI.this);
                        AppMethodBeat.o(16978);
                    }
                }, null);
                AppMethodBeat.o(16979);
            }
        });
        this.gKd = (ListView) findViewById(R.id.f5f);
        this.gLc = new a(this);
        this.gLe = findViewById(R.id.f5g);
        this.gLe.findViewById(R.id.f5d).setVisibility(8);
        ((TextView) this.gLe.findViewById(R.id.f5c)).setText(R.string.de);
        this.gKd.setAdapter(this.gLc);
        this.gKd.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(16980);
                ab.d("MicroMsg.WalletSelectAddrUI", "select pos ".concat(String.valueOf(i)));
                synchronized (WalletSelectAddrUI.this.lockObj) {
                    try {
                        if (i < WalletSelectAddrUI.this.gLa.size()) {
                            WalletSelectAddrUI.this.gLb = (b) WalletSelectAddrUI.this.gLa.get(i);
                            if (!WalletSelectAddrUI.this.gJy && !WalletSelectAddrUI.this.gLi && WalletSelectAddrUI.this.gLb != null) {
                                WalletSelectAddrUI.a(WalletSelectAddrUI.this, WalletSelectAddrUI.this.gLb.id);
                            } else if (!(WalletSelectAddrUI.this.gLb == null || WalletSelectAddrUI.this.gLb.id == 0)) {
                                WalletSelectAddrUI.this.gLd.g(new g(WalletSelectAddrUI.this.gLb.id));
                            }
                        }
                    } finally {
                        AppMethodBeat.o(16980);
                    }
                }
                WalletSelectAddrUI.this.gLc.notifyDataSetChanged();
            }
        });
        this.gKd.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                AppMethodBeat.i(16982);
                h.a(WalletSelectAddrUI.this.mController.ylL, null, WalletSelectAddrUI.this.getResources().getStringArray(R.array.ar), null, new h.c() {
                    public final void iE(int i) {
                        b bVar;
                        AppMethodBeat.i(16981);
                        synchronized (WalletSelectAddrUI.this.lockObj) {
                            try {
                                if (i < WalletSelectAddrUI.this.gLa.size()) {
                                    bVar = (b) WalletSelectAddrUI.this.gLa.get(i);
                                } else {
                                    bVar = null;
                                }
                            } finally {
                                while (true) {
                                }
                                AppMethodBeat.o(16981);
                            }
                        }
                        if (bVar != null) {
                            switch (i) {
                                case 0:
                                    WalletSelectAddrUI.a(WalletSelectAddrUI.this, bVar.id);
                                    AppMethodBeat.o(16981);
                                    return;
                                case 1:
                                    f fVar = new f(bVar.id);
                                    WalletSelectAddrUI.this.gLb = null;
                                    WalletSelectAddrUI.this.gLd.g(fVar);
                                    AppMethodBeat.o(16981);
                                    return;
                                case 2:
                                    WalletSelectAddrUI.b(WalletSelectAddrUI.this, bVar);
                                    break;
                            }
                            AppMethodBeat.o(16981);
                        }
                    }
                });
                AppMethodBeat.o(16982);
                return true;
            }
        });
        asc();
        this.gLe.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(16983);
                WalletSelectAddrUI.j(WalletSelectAddrUI.this);
                AppMethodBeat.o(16983);
            }
        });
        this.gLc.notifyDataSetChanged();
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(16984);
                WalletSelectAddrUI.this.setResult(0);
                WalletSelectAddrUI.this.finish();
                AppMethodBeat.o(16984);
                return true;
            }
        });
        addIconOptionMenu(0, R.string.dg, R.raw.actionbar_icon_dark_add, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(16985);
                WalletSelectAddrUI.j(WalletSelectAddrUI.this);
                AppMethodBeat.o(16985);
                return true;
            }
        });
        AppMethodBeat.o(16999);
    }

    public final int getLayoutId() {
        return R.layout.b2q;
    }

    public final void d(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(17000);
        this.gLd.onSceneEnd(i, i2, str, mVar);
        if (i == 0 && i2 == 0) {
            if (mVar.getType() == 417) {
                if (((e) mVar).gIJ) {
                    asc();
                    this.mController.contentView.setVisibility(0);
                    if (this.gJy && this.gLa.size() == 0) {
                        Intent intent = new Intent();
                        intent.setClass(this, WalletAddAddressUI.class);
                        startActivityForResult(intent, 1);
                    }
                }
                AppMethodBeat.o(17000);
                return;
            } else if (mVar.getType() == 416) {
                f fVar = (f) mVar;
                com.tencent.mm.plugin.address.a.a.arQ();
                b ne = com.tencent.mm.plugin.address.a.a.arS().ne(fVar.gIK);
                if (ne != null) {
                    com.tencent.mm.plugin.address.a.a.arQ();
                    ab.d("MicroMsg.WalletSelectAddrUI", "delte addr ".concat(String.valueOf(com.tencent.mm.plugin.address.a.a.arS().a(ne))));
                }
                asc();
                AppMethodBeat.o(17000);
                return;
            } else if (mVar.getType() == 419) {
                if (this.gLb != null) {
                    setResult(-1, com.tencent.mm.plugin.address.e.a.b(this.gLb));
                    finish();
                    AppMethodBeat.o(17000);
                    return;
                }
            } else if (mVar.getType() == r.CTRL_INDEX) {
                String string = getString(R.string.f0);
                switch (((d) mVar).status) {
                    case 0:
                        aw.ZK();
                        com.tencent.mm.model.c.Ry().set(196657, Boolean.TRUE);
                        this.gLf.setVisibility(8);
                        asc();
                        this.mController.contentView.setVisibility(0);
                        string = getString(R.string.f2);
                        break;
                    case 1:
                    case 2:
                        aw.ZK();
                        com.tencent.mm.model.c.Ry().set(196657, Boolean.TRUE);
                        this.gLf.setVisibility(8);
                        string = getString(R.string.f1);
                        break;
                    case 3:
                        asj();
                        AppMethodBeat.o(17000);
                        return;
                }
                if (this.gLj != null) {
                    this.gLj.dismiss();
                }
                this.gLj = h.a((Context) this, string, null, true, null);
                AppMethodBeat.o(17000);
                return;
            }
        } else if (mVar.getType() == 419 && i2 == -3103) {
            h.a((Context) this, true, str, "", getString(R.string.dk), getString(R.string.or), new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(16988);
                    dialogInterface.dismiss();
                    WalletSelectAddrUI.a(WalletSelectAddrUI.this, WalletSelectAddrUI.this.gLb.id);
                    AppMethodBeat.o(16988);
                }
            }, new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(16977);
                    dialogInterface.dismiss();
                    AppMethodBeat.o(16977);
                }
            });
        }
        AppMethodBeat.o(17000);
    }

    private void bn(String str, String str2) {
        AppMethodBeat.i(17001);
        this.gLd.g(new d(str, str2, this.gLg));
        AppMethodBeat.o(17001);
    }

    private void asj() {
        AppMethodBeat.i(17002);
        final com.tencent.mm.sdk.b.b kiVar = new ki();
        kiVar.cFO.czX = this;
        kiVar.cFO.cFQ = new Runnable() {
            public final void run() {
                AppMethodBeat.i(16987);
                WalletSelectAddrUI.this.gKd.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(16986);
                        if (kiVar.cFP.cvi) {
                            aw.ZK();
                            String nullAsNil = bo.nullAsNil((String) com.tencent.mm.model.c.Ry().get(46, null));
                            aw.ZK();
                            WalletSelectAddrUI.a(WalletSelectAddrUI.this, nullAsNil, bo.nullAsNil((String) com.tencent.mm.model.c.Ry().get(72, null)));
                        }
                        AppMethodBeat.o(16986);
                    }
                });
                AppMethodBeat.o(16987);
            }
        };
        com.tencent.mm.sdk.b.a.xxA.a(kiVar, Looper.myLooper());
        AppMethodBeat.o(17002);
    }

    private void nj(int i) {
        AppMethodBeat.i(17003);
        Intent intent = new Intent();
        intent.setClass(this, WalletAddAddressUI.class);
        intent.putExtra("address_id", i);
        startActivity(intent);
        AppMethodBeat.o(17003);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(17004);
        if (i == 1) {
            if (-1 == i2) {
                b bVar;
                if (intent == null) {
                    ab.e("MicroMsg.AddrUtil", "intent == null");
                    bVar = null;
                } else {
                    bVar = new b();
                    bVar.gJh = intent.getStringExtra("nationalCode");
                    bVar.gJf = intent.getStringExtra("userName");
                    bVar.gJg = intent.getStringExtra("telNumber");
                    bVar.gJd = intent.getStringExtra("addressPostalCode");
                    bVar.gJa = intent.getStringExtra("proviceFirstStageName");
                    bVar.gJb = intent.getStringExtra("addressCitySecondStageName");
                    bVar.gJc = intent.getStringExtra("addressCountiesThirdStageName");
                    bVar.gJe = intent.getStringExtra("addressDetailInfo");
                }
                setResult(-1, com.tencent.mm.plugin.address.e.a.b(bVar));
            } else {
                setResult(0);
            }
            finish();
        }
        AppMethodBeat.o(17004);
    }

    static /* synthetic */ void b(WalletSelectAddrUI walletSelectAddrUI) {
        AppMethodBeat.i(17005);
        aw.ZK();
        String nullAsNil = bo.nullAsNil((String) com.tencent.mm.model.c.Ry().get(46, null));
        aw.ZK();
        String nullAsNil2 = bo.nullAsNil((String) com.tencent.mm.model.c.Ry().get(72, null));
        if (bo.isNullOrNil(nullAsNil) && bo.isNullOrNil(nullAsNil2)) {
            walletSelectAddrUI.asj();
            AppMethodBeat.o(17005);
            return;
        }
        walletSelectAddrUI.bn(nullAsNil, nullAsNil2);
        AppMethodBeat.o(17005);
    }

    static /* synthetic */ void b(WalletSelectAddrUI walletSelectAddrUI, b bVar) {
        AppMethodBeat.i(17007);
        if (bVar != null) {
            StringBuilder stringBuilder = new StringBuilder();
            if (!TextUtils.isEmpty(bVar.gJf)) {
                stringBuilder.append(walletSelectAddrUI.getString(R.string.eb));
                stringBuilder.append("：");
                stringBuilder.append(bVar.gJf);
                stringBuilder.append(" \n");
            }
            if (!TextUtils.isEmpty(bVar.gJg)) {
                stringBuilder.append(walletSelectAddrUI.getString(R.string.eg));
                stringBuilder.append("：");
                stringBuilder.append(bVar.gJg);
                stringBuilder.append(" \n");
            }
            stringBuilder.append(walletSelectAddrUI.getString(R.string.em));
            stringBuilder.append("：");
            if (!TextUtils.isEmpty(bVar.gJa)) {
                stringBuilder.append(bVar.gJa);
            }
            if (!TextUtils.isEmpty(bVar.gJb)) {
                stringBuilder.append(bVar.gJb);
            }
            if (!TextUtils.isEmpty(bVar.gJc)) {
                stringBuilder.append(bVar.gJc);
            }
            if (!TextUtils.isEmpty(bVar.gJe)) {
                stringBuilder.append(bVar.gJe);
            }
            if (!TextUtils.isEmpty(bVar.gJd)) {
                stringBuilder.append(" \n");
                stringBuilder.append(walletSelectAddrUI.getString(R.string.ei));
                stringBuilder.append("：");
                stringBuilder.append(bVar.gJd);
            }
            try {
                com.tencent.mm.plugin.address.e.d.wG(stringBuilder.toString());
                AppMethodBeat.o(17007);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.WalletSelectAddrUI", e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(17007);
    }

    static /* synthetic */ void j(WalletSelectAddrUI walletSelectAddrUI) {
        AppMethodBeat.i(17008);
        walletSelectAddrUI.nj(0);
        AppMethodBeat.o(17008);
    }
}
