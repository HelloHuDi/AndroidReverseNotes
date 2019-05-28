package com.tencent.p177mm.plugin.address.p276ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C9399ki;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p707ba.C45181k;
import com.tencent.p177mm.plugin.address.model.C18975g;
import com.tencent.p177mm.plugin.address.model.C42319d;
import com.tencent.p177mm.plugin.address.model.C42320e;
import com.tencent.p177mm.plugin.address.model.C42321f;
import com.tencent.p177mm.plugin.address.p1218e.C18972d;
import com.tencent.p177mm.plugin.address.p1218e.C42316a;
import com.tencent.p177mm.plugin.address.p1388c.C26685a;
import com.tencent.p177mm.plugin.address.p1388c.C33046b;
import com.tencent.p177mm.plugin.address.p1467a.C33045a;
import com.tencent.p177mm.plugin.address.p1534d.C38090b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C42526r;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.address.ui.WalletSelectAddrUI */
public class WalletSelectAddrUI extends MMActivity implements C26685a {
    private boolean gJy = false;
    private ListView gKd;
    private List<C38090b> gLa = new LinkedList();
    private C38090b gLb;
    private C18990a gLc;
    private C33046b gLd = null;
    private View gLe;
    private TextView gLf = null;
    private C1183p gLg;
    private boolean gLh = false;
    private boolean gLi = false;
    private C5653c gLj = null;
    private Object lockObj = new Object();

    /* renamed from: com.tencent.mm.plugin.address.ui.WalletSelectAddrUI$4 */
    class C100394 implements OnItemClickListener {
        C100394() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(16980);
            C4990ab.m7410d("MicroMsg.WalletSelectAddrUI", "select pos ".concat(String.valueOf(i)));
            synchronized (WalletSelectAddrUI.this.lockObj) {
                try {
                    if (i < WalletSelectAddrUI.this.gLa.size()) {
                        WalletSelectAddrUI.this.gLb = (C38090b) WalletSelectAddrUI.this.gLa.get(i);
                        if (!WalletSelectAddrUI.this.gJy && !WalletSelectAddrUI.this.gLi && WalletSelectAddrUI.this.gLb != null) {
                            WalletSelectAddrUI.m54029a(WalletSelectAddrUI.this, WalletSelectAddrUI.this.gLb.f16139id);
                        } else if (!(WalletSelectAddrUI.this.gLb == null || WalletSelectAddrUI.this.gLb.f16139id == 0)) {
                            WalletSelectAddrUI.this.gLd.mo53605g(new C18975g(WalletSelectAddrUI.this.gLb.f16139id));
                        }
                    }
                } finally {
                    AppMethodBeat.m2505o(16980);
                }
            }
            WalletSelectAddrUI.this.gLc.notifyDataSetChanged();
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.WalletSelectAddrUI$6 */
    class C189896 implements OnClickListener {
        C189896() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(16983);
            WalletSelectAddrUI.m54041j(WalletSelectAddrUI.this);
            AppMethodBeat.m2505o(16983);
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.WalletSelectAddrUI$a */
    public class C18990a extends BaseAdapter {
        private final Context context;
        List<C38090b> items = new ArrayList();

        /* renamed from: com.tencent.mm.plugin.address.ui.WalletSelectAddrUI$a$a */
        class C10040a {
            TextView gKl;
            ImageView gKm;
            TextView gtb;

            C10040a() {
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(16993);
            C38090b nk = m29564nk(i);
            AppMethodBeat.m2505o(16993);
            return nk;
        }

        public C18990a(Context context) {
            AppMethodBeat.m2504i(16989);
            this.context = context;
            AppMethodBeat.m2505o(16989);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C10040a c10040a;
            AppMethodBeat.m2504i(16990);
            C10040a c10040a2 = new C10040a();
            if (view == null) {
                view = View.inflate(this.context, 2130971041, null);
                c10040a2.gKm = (ImageView) view.findViewById(2131828587);
                c10040a2.gKl = (TextView) view.findViewById(2131828586);
                c10040a2.gtb = (TextView) view.findViewById(2131828585);
                view.setTag(c10040a2);
                c10040a = c10040a2;
            } else {
                c10040a = (C10040a) view.getTag();
            }
            C38090b nk = m29564nk(i);
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
            c10040a.gKl.setText(stringBuilder.toString());
            c10040a.gtb.setText(nk.gJf + "，" + nk.gJg);
            if (WalletSelectAddrUI.this.gJy && WalletSelectAddrUI.this.gLb != null && WalletSelectAddrUI.this.gLb.f16139id == nk.f16139id) {
                c10040a.gKm.setImageResource(C1318a.radio_on);
            } else {
                c10040a.gKm.setImageBitmap(null);
            }
            AppMethodBeat.m2505o(16990);
            return view;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(16991);
            int size = this.items.size();
            AppMethodBeat.m2505o(16991);
            return size;
        }

        /* renamed from: nk */
        private C38090b m29564nk(int i) {
            AppMethodBeat.m2504i(16992);
            C38090b c38090b = (C38090b) this.items.get(i);
            AppMethodBeat.m2505o(16992);
            return c38090b;
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.WalletSelectAddrUI$2 */
    class C267082 implements DialogInterface.OnClickListener {
        C267082() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(16977);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(16977);
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.WalletSelectAddrUI$3 */
    class C267093 implements OnClickListener {

        /* renamed from: com.tencent.mm.plugin.address.ui.WalletSelectAddrUI$3$1 */
        class C267101 implements DialogInterface.OnClickListener {
            C267101() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(16978);
                WalletSelectAddrUI.m54031b(WalletSelectAddrUI.this);
                AppMethodBeat.m2505o(16978);
            }
        }

        C267093() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(16979);
            C30379h.m48453a(WalletSelectAddrUI.this, true, WalletSelectAddrUI.this.getString(C25738R.string.f8784ex, new Object[]{WalletSelectAddrUI.this.gLg.toString()}), "", WalletSelectAddrUI.this.getString(C25738R.string.f8785ey), WalletSelectAddrUI.this.getString(C25738R.string.f9076or), new C267101(), null);
            AppMethodBeat.m2505o(16979);
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.WalletSelectAddrUI$5 */
    class C267125 implements OnItemLongClickListener {
        C267125() {
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
            AppMethodBeat.m2504i(16982);
            C30379h.m48422a(WalletSelectAddrUI.this.mController.ylL, null, WalletSelectAddrUI.this.getResources().getStringArray(C25738R.array.f12638ar), null, new C30391c() {
                /* renamed from: iE */
                public final void mo7700iE(int i) {
                    C38090b c38090b;
                    AppMethodBeat.m2504i(16981);
                    synchronized (WalletSelectAddrUI.this.lockObj) {
                        try {
                            if (i < WalletSelectAddrUI.this.gLa.size()) {
                                c38090b = (C38090b) WalletSelectAddrUI.this.gLa.get(i);
                            } else {
                                c38090b = null;
                            }
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.m2505o(16981);
                        }
                    }
                    if (c38090b != null) {
                        switch (i) {
                            case 0:
                                WalletSelectAddrUI.m54029a(WalletSelectAddrUI.this, c38090b.f16139id);
                                AppMethodBeat.m2505o(16981);
                                return;
                            case 1:
                                C42321f c42321f = new C42321f(c38090b.f16139id);
                                WalletSelectAddrUI.this.gLb = null;
                                WalletSelectAddrUI.this.gLd.mo53605g(c42321f);
                                AppMethodBeat.m2505o(16981);
                                return;
                            case 2:
                                WalletSelectAddrUI.m54032b(WalletSelectAddrUI.this, c38090b);
                                break;
                        }
                        AppMethodBeat.m2505o(16981);
                    }
                }
            });
            AppMethodBeat.m2505o(16982);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.WalletSelectAddrUI$10 */
    class C3305210 implements DialogInterface.OnClickListener {
        C3305210() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(16988);
            dialogInterface.dismiss();
            WalletSelectAddrUI.m54029a(WalletSelectAddrUI.this, WalletSelectAddrUI.this.gLb.f16139id);
            AppMethodBeat.m2505o(16988);
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.WalletSelectAddrUI$1 */
    class C330541 implements DialogInterface.OnClickListener {
        C330541() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(16976);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(16976);
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.WalletSelectAddrUI$8 */
    class C330558 implements OnMenuItemClickListener {
        C330558() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(16985);
            WalletSelectAddrUI.m54041j(WalletSelectAddrUI.this);
            AppMethodBeat.m2505o(16985);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.address.ui.WalletSelectAddrUI$7 */
    class C330577 implements OnMenuItemClickListener {
        C330577() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(16984);
            WalletSelectAddrUI.this.setResult(0);
            WalletSelectAddrUI.this.finish();
            AppMethodBeat.m2505o(16984);
            return true;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletSelectAddrUI() {
        AppMethodBeat.m2504i(16994);
        AppMethodBeat.m2505o(16994);
    }

    /* renamed from: a */
    static /* synthetic */ void m54030a(WalletSelectAddrUI walletSelectAddrUI, String str, String str2) {
        AppMethodBeat.m2504i(17009);
        walletSelectAddrUI.m54033bn(str, str2);
        AppMethodBeat.m2505o(17009);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(16995);
        super.onCreate(bundle);
        this.gLd = new C33046b(this, this);
        Intent intent = getIntent();
        this.gLh = intent.getBooleanExtra("launch_from_appbrand", false);
        this.gLi = intent.getBooleanExtra("launch_from_remittance", false);
        if (intent.getBooleanExtra("launch_from_webview", false) || this.gLh) {
            this.gJy = true;
            this.mController.contentView.setVisibility(8);
            if (this.gLh) {
                getWindow().setBackgroundDrawableResource(C25738R.color.f12200vs);
            }
            C4990ab.m7416i("MicroMsg.WalletSelectAddrUI", "showDisclaimerDailog()");
            C9638aw.m17190ZK();
            if (((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_ADDRESS_HAS_SHOW_DISCLAIMER_DIALOG_BOOLEAN_SYNC, Boolean.TRUE)).booleanValue()) {
                C4990ab.m7416i("MicroMsg.WalletSelectAddrUI", "isShowDisclaimerDialog");
                C30379h.m48443a((Context) this, getString(C25738R.string.f8776en), getString(C25738R.string.f8777eo), getString(C25738R.string.f8636aj), new C330541());
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(C5127a.USERINFO_ADDRESS_HAS_SHOW_DISCLAIMER_DIALOG_BOOLEAN_SYNC, Boolean.FALSE);
            }
        }
        setMMTitle((int) C25738R.string.f8775em);
        this.gLd.mo53606nf(417);
        this.gLd.mo53606nf(416);
        this.gLd.mo53606nf(419);
        this.gLd.mo53606nf(C42526r.CTRL_INDEX);
        this.gLd.mo53605g(new C42320e(intent.getStringExtra("req_url"), intent.getStringExtra("req_app_id"), 2));
        C9638aw.m17190ZK();
        this.gLg = new C1183p(C5046bo.m7512a((Integer) C18628c.m29072Ry().get(9, null), 0));
        initView();
        C9638aw.m17190ZK();
        if (C18628c.isSDCardAvailable()) {
            C9638aw.m17182Rg().mo14541a(new C45181k(12), 0);
        }
        AppMethodBeat.m2505o(16995);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(16996);
        super.onDestroy();
        this.gLd.mo53607ng(417);
        this.gLd.mo53607ng(416);
        this.gLd.mo53607ng(419);
        this.gLd.mo53607ng(C42526r.CTRL_INDEX);
        AppMethodBeat.m2505o(16996);
    }

    public void onResume() {
        AppMethodBeat.m2504i(16997);
        super.onResume();
        asc();
        AppMethodBeat.m2505o(16997);
    }

    private void asc() {
        AppMethodBeat.m2504i(16998);
        synchronized (this.lockObj) {
            try {
                C33045a.arQ();
                this.gLa = C33045a.arS().gIQ.gIY;
                this.gLc.items = this.gLa;
                this.gLa.size();
                this.gLe.setVisibility(8);
                this.gLc.notifyDataSetChanged();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(16998);
            }
        }
    }

    public final void initView() {
        AppMethodBeat.m2504i(16999);
        this.gLf = (TextView) findViewById(2131828590);
        this.gLf.setVisibility(8);
        this.gLf.setOnClickListener(new C267093());
        this.gKd = (ListView) findViewById(2131828588);
        this.gLc = new C18990a(this);
        this.gLe = findViewById(2131828589);
        this.gLe.findViewById(2131828586).setVisibility(8);
        ((TextView) this.gLe.findViewById(2131828585)).setText(C25738R.string.f8731de);
        this.gKd.setAdapter(this.gLc);
        this.gKd.setOnItemClickListener(new C100394());
        this.gKd.setOnItemLongClickListener(new C267125());
        asc();
        this.gLe.setOnClickListener(new C189896());
        this.gLc.notifyDataSetChanged();
        setBackBtn(new C330577());
        addIconOptionMenu(0, C25738R.string.f8733dg, C1318a.actionbar_icon_dark_add, new C330558());
        AppMethodBeat.m2505o(16999);
    }

    public final int getLayoutId() {
        return 2130971042;
    }

    /* renamed from: d */
    public final void mo44444d(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(17000);
        this.gLd.onSceneEnd(i, i2, str, c1207m);
        if (i == 0 && i2 == 0) {
            if (c1207m.getType() == 417) {
                if (((C42320e) c1207m).gIJ) {
                    asc();
                    this.mController.contentView.setVisibility(0);
                    if (this.gJy && this.gLa.size() == 0) {
                        Intent intent = new Intent();
                        intent.setClass(this, WalletAddAddressUI.class);
                        startActivityForResult(intent, 1);
                    }
                }
                AppMethodBeat.m2505o(17000);
                return;
            } else if (c1207m.getType() == 416) {
                C42321f c42321f = (C42321f) c1207m;
                C33045a.arQ();
                C38090b ne = C33045a.arS().mo67843ne(c42321f.gIK);
                if (ne != null) {
                    C33045a.arQ();
                    C4990ab.m7410d("MicroMsg.WalletSelectAddrUI", "delte addr ".concat(String.valueOf(C33045a.arS().mo67839a(ne))));
                }
                asc();
                AppMethodBeat.m2505o(17000);
                return;
            } else if (c1207m.getType() == 419) {
                if (this.gLb != null) {
                    setResult(-1, C42316a.m74836b(this.gLb));
                    finish();
                    AppMethodBeat.m2505o(17000);
                    return;
                }
            } else if (c1207m.getType() == C42526r.CTRL_INDEX) {
                String string = getString(C25738R.string.f8787f0);
                switch (((C42319d) c1207m).status) {
                    case 0:
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().set(196657, Boolean.TRUE);
                        this.gLf.setVisibility(8);
                        asc();
                        this.mController.contentView.setVisibility(0);
                        string = getString(C25738R.string.f8789f2);
                        break;
                    case 1:
                    case 2:
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().set(196657, Boolean.TRUE);
                        this.gLf.setVisibility(8);
                        string = getString(C25738R.string.f8788f1);
                        break;
                    case 3:
                        asj();
                        AppMethodBeat.m2505o(17000);
                        return;
                }
                if (this.gLj != null) {
                    this.gLj.dismiss();
                }
                this.gLj = C30379h.m48448a((Context) this, string, null, true, null);
                AppMethodBeat.m2505o(17000);
                return;
            }
        } else if (c1207m.getType() == 419 && i2 == -3103) {
            C30379h.m48453a((Context) this, true, str, "", getString(C25738R.string.f8737dk), getString(C25738R.string.f9076or), new C3305210(), new C267082());
        }
        AppMethodBeat.m2505o(17000);
    }

    /* renamed from: bn */
    private void m54033bn(String str, String str2) {
        AppMethodBeat.m2504i(17001);
        this.gLd.mo53605g(new C42319d(str, str2, this.gLg));
        AppMethodBeat.m2505o(17001);
    }

    private void asj() {
        AppMethodBeat.m2504i(17002);
        final C4883b c9399ki = new C9399ki();
        c9399ki.cFO.czX = this;
        c9399ki.cFO.cFQ = new Runnable() {

            /* renamed from: com.tencent.mm.plugin.address.ui.WalletSelectAddrUI$9$1 */
            class C330531 implements Runnable {
                C330531() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(16986);
                    if (c9399ki.cFP.cvi) {
                        C9638aw.m17190ZK();
                        String nullAsNil = C5046bo.nullAsNil((String) C18628c.m29072Ry().get(46, null));
                        C9638aw.m17190ZK();
                        WalletSelectAddrUI.m54030a(WalletSelectAddrUI.this, nullAsNil, C5046bo.nullAsNil((String) C18628c.m29072Ry().get(72, null)));
                    }
                    AppMethodBeat.m2505o(16986);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(16987);
                WalletSelectAddrUI.this.gKd.post(new C330531());
                AppMethodBeat.m2505o(16987);
            }
        };
        C4879a.xxA.mo10048a(c9399ki, Looper.myLooper());
        AppMethodBeat.m2505o(17002);
    }

    /* renamed from: nj */
    private void m54043nj(int i) {
        AppMethodBeat.m2504i(17003);
        Intent intent = new Intent();
        intent.setClass(this, WalletAddAddressUI.class);
        intent.putExtra("address_id", i);
        startActivity(intent);
        AppMethodBeat.m2505o(17003);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(17004);
        if (i == 1) {
            if (-1 == i2) {
                C38090b c38090b;
                if (intent == null) {
                    C4990ab.m7412e("MicroMsg.AddrUtil", "intent == null");
                    c38090b = null;
                } else {
                    c38090b = new C38090b();
                    c38090b.gJh = intent.getStringExtra("nationalCode");
                    c38090b.gJf = intent.getStringExtra("userName");
                    c38090b.gJg = intent.getStringExtra("telNumber");
                    c38090b.gJd = intent.getStringExtra("addressPostalCode");
                    c38090b.gJa = intent.getStringExtra("proviceFirstStageName");
                    c38090b.gJb = intent.getStringExtra("addressCitySecondStageName");
                    c38090b.gJc = intent.getStringExtra("addressCountiesThirdStageName");
                    c38090b.gJe = intent.getStringExtra("addressDetailInfo");
                }
                setResult(-1, C42316a.m74836b(c38090b));
            } else {
                setResult(0);
            }
            finish();
        }
        AppMethodBeat.m2505o(17004);
    }

    /* renamed from: b */
    static /* synthetic */ void m54031b(WalletSelectAddrUI walletSelectAddrUI) {
        AppMethodBeat.m2504i(17005);
        C9638aw.m17190ZK();
        String nullAsNil = C5046bo.nullAsNil((String) C18628c.m29072Ry().get(46, null));
        C9638aw.m17190ZK();
        String nullAsNil2 = C5046bo.nullAsNil((String) C18628c.m29072Ry().get(72, null));
        if (C5046bo.isNullOrNil(nullAsNil) && C5046bo.isNullOrNil(nullAsNil2)) {
            walletSelectAddrUI.asj();
            AppMethodBeat.m2505o(17005);
            return;
        }
        walletSelectAddrUI.m54033bn(nullAsNil, nullAsNil2);
        AppMethodBeat.m2505o(17005);
    }

    /* renamed from: b */
    static /* synthetic */ void m54032b(WalletSelectAddrUI walletSelectAddrUI, C38090b c38090b) {
        AppMethodBeat.m2504i(17007);
        if (c38090b != null) {
            StringBuilder stringBuilder = new StringBuilder();
            if (!TextUtils.isEmpty(c38090b.gJf)) {
                stringBuilder.append(walletSelectAddrUI.getString(C25738R.string.f8764eb));
                stringBuilder.append("：");
                stringBuilder.append(c38090b.gJf);
                stringBuilder.append(" \n");
            }
            if (!TextUtils.isEmpty(c38090b.gJg)) {
                stringBuilder.append(walletSelectAddrUI.getString(C25738R.string.f8769eg));
                stringBuilder.append("：");
                stringBuilder.append(c38090b.gJg);
                stringBuilder.append(" \n");
            }
            stringBuilder.append(walletSelectAddrUI.getString(C25738R.string.f8775em));
            stringBuilder.append("：");
            if (!TextUtils.isEmpty(c38090b.gJa)) {
                stringBuilder.append(c38090b.gJa);
            }
            if (!TextUtils.isEmpty(c38090b.gJb)) {
                stringBuilder.append(c38090b.gJb);
            }
            if (!TextUtils.isEmpty(c38090b.gJc)) {
                stringBuilder.append(c38090b.gJc);
            }
            if (!TextUtils.isEmpty(c38090b.gJe)) {
                stringBuilder.append(c38090b.gJe);
            }
            if (!TextUtils.isEmpty(c38090b.gJd)) {
                stringBuilder.append(" \n");
                stringBuilder.append(walletSelectAddrUI.getString(C25738R.string.f8771ei));
                stringBuilder.append("：");
                stringBuilder.append(c38090b.gJd);
            }
            try {
                C18972d.m29544wG(stringBuilder.toString());
                AppMethodBeat.m2505o(17007);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.WalletSelectAddrUI", e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(17007);
    }

    /* renamed from: j */
    static /* synthetic */ void m54041j(WalletSelectAddrUI walletSelectAddrUI) {
        AppMethodBeat.m2504i(17008);
        walletSelectAddrUI.m54043nj(0);
        AppMethodBeat.m2505o(17008);
    }
}
