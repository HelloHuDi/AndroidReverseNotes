package com.tencent.p177mm.plugin.order.p480ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.p222g.C1434a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.platformtools.C18764x.C18765a;
import com.tencent.p177mm.plugin.order.model.C21422f;
import com.tencent.p177mm.plugin.order.model.C34664c;
import com.tencent.p177mm.plugin.order.model.C43363h;
import com.tencent.p177mm.plugin.order.model.C43365j;
import com.tencent.p177mm.plugin.order.model.C43365j.C28660a;
import com.tencent.p177mm.plugin.order.model.C43365j.C34665b;
import com.tencent.p177mm.plugin.order.model.MallOrderDetailObject;
import com.tencent.p177mm.plugin.order.model.MallOrderDetailObject.C34660a;
import com.tencent.p177mm.plugin.order.model.MallOrderDetailObject.C34661b;
import com.tencent.p177mm.plugin.order.model.MallTransactionObject;
import com.tencent.p177mm.plugin.order.model.ProductSectionItem;
import com.tencent.p177mm.plugin.order.model.ProductSectionItem.Skus;
import com.tencent.p177mm.plugin.order.p1007a.C34656a;
import com.tencent.p177mm.plugin.order.p1007a.C34657b;
import com.tencent.p177mm.plugin.order.p1008c.C12785c;
import com.tencent.p177mm.plugin.order.p1008c.C28657b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.C40931c;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@C5271a(3)
/* renamed from: com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI */
public class MallOrderDetailInfoUI extends WalletBaseUI implements C18765a {
    private OnClickListener gKK = new C35681();
    private String kBE = "";
    private ListView mListView;
    private HashMap<String, View> oZx = new HashMap();
    private List<C34660a> pbL = new ArrayList();
    protected MallOrderDetailObject pcS = null;
    String pdC;
    private C3575a pdD;
    private View pdE;
    private View pdF;
    private View pdG;
    private View pdH;
    private View pdI;
    private View pdJ;
    private View pdK;
    private boolean pdL = false;
    private boolean pdM = false;
    private int pdN = 0;
    private CheckedTextView pdO;
    private CheckedTextView pdP;
    OnClickListener pdQ = new C35737();

    /* renamed from: com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI$1 */
    class C35681 implements OnClickListener {
        C35681() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(43798);
            if (view.getId() == 2131825812) {
                if (MallOrderDetailInfoUI.this.pcS.pbJ != null) {
                    C12785c.m20788aM(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.pcS.pbJ.mZj);
                    MallOrderDetailInfoUI.m5912a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.pcS.pbJ.pbR);
                    AppMethodBeat.m2505o(43798);
                    return;
                }
            } else if (view.getId() == 2131825814 || view.getId() == 2131825816) {
                if (MallOrderDetailInfoUI.this.pcS.pbK != null && MallOrderDetailInfoUI.this.pcS.pbK.size() > 0) {
                    boolean z;
                    if (TextUtils.isEmpty(((ProductSectionItem) MallOrderDetailInfoUI.this.pcS.pbK.get(0)).jumpUrl)) {
                        z = false;
                    } else {
                        z = C12785c.m20788aM(MallOrderDetailInfoUI.this, ((ProductSectionItem) MallOrderDetailInfoUI.this.pcS.pbK.get(0)).jumpUrl);
                    }
                    if (!z) {
                        C12785c.m20789aN(MallOrderDetailInfoUI.this, ((ProductSectionItem) MallOrderDetailInfoUI.this.pcS.pbK.get(0)).pdA);
                    }
                    MallOrderDetailInfoUI.m5912a(MallOrderDetailInfoUI.this, ((ProductSectionItem) MallOrderDetailInfoUI.this.pcS.pbK.get(0)).name);
                    AppMethodBeat.m2505o(43798);
                    return;
                }
            } else if (view.getId() == 2131825815) {
                Bundle bundle = MallOrderDetailInfoUI.this.mBundle;
                bundle.putParcelableArrayList("order_product_list", MallOrderDetailInfoUI.this.pcS.pbK);
                bundle.putInt("key_enter_id", 0);
                bundle.putString("key_trans_id", MallOrderDetailInfoUI.this.kBE);
                bundle.putString("appname", MallOrderDetailInfoUI.this.pcS.cBb);
                C24143a.m37116j(MallOrderDetailInfoUI.this, new Bundle());
                MallOrderDetailInfoUI.m5912a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.getResources().getString(C25738R.string.cx6));
                AppMethodBeat.m2505o(43798);
                return;
            } else if (view.getId() == 2131825817) {
                String string = MallOrderDetailInfoUI.this.mBundle.getString("key_trans_id");
                Bundle bundle2 = MallOrderDetailInfoUI.this.mBundle;
                bundle2.putString("key_trans_id", string);
                bundle2.putInt("key_enter_id", 1);
                if (MallOrderDetailInfoUI.this.pcS != null) {
                    bundle2.putParcelable("transaction_data", MallOrderDetailInfoUI.this.pcS.pbI);
                }
                C24143a.m37116j(MallOrderDetailInfoUI.this, bundle2);
                MallOrderDetailInfoUI.m5912a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.getResources().getString(C25738R.string.cx3));
                AppMethodBeat.m2505o(43798);
                return;
            } else if (view.getId() == 2131825831) {
                MallOrderDetailInfoUI.m5915b(MallOrderDetailInfoUI.this);
                AppMethodBeat.m2505o(43798);
                return;
            } else if (view.getId() == 2131825822) {
                if (!(MallOrderDetailInfoUI.this.pcS == null || MallOrderDetailInfoUI.this.pcS.pbP == null)) {
                    MallOrderDetailInfoUI.this.pdC = MallOrderDetailInfoUI.this.pcS.pbP;
                    MallOrderDetailInfoUI.m5916c(MallOrderDetailInfoUI.this);
                    MallOrderDetailInfoUI.m5912a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.getResources().getString(C25738R.string.cx1));
                    AppMethodBeat.m2505o(43798);
                    return;
                }
            } else if (view.getId() == 2131825824) {
                C36391e.m59992af(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.pcS.cBb);
                MallOrderDetailInfoUI.m5912a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.getResources().getString(C25738R.string.cxb));
            }
            AppMethodBeat.m2505o(43798);
        }
    }

    /* renamed from: com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI$2 */
    class C35692 implements DialogInterface.OnClickListener {
        C35692() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI$3 */
    class C35703 implements DialogInterface.OnClickListener {
        C35703() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI$4 */
    class C35714 implements OnMenuItemClickListener {
        C35714() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(43799);
            MallOrderDetailInfoUI.m5919d(MallOrderDetailInfoUI.this);
            AppMethodBeat.m2505o(43799);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI$5 */
    class C35725 implements C30391c {
        C35725() {
        }

        /* renamed from: iE */
        public final void mo7700iE(int i) {
            AppMethodBeat.m2504i(43800);
            switch (i) {
                case 0:
                    C12785c.m20787aL(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.pcS.pbO);
                    break;
            }
            AppMethodBeat.m2505o(43800);
        }
    }

    /* renamed from: com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI$7 */
    class C35737 implements OnClickListener {
        C35737() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(43802);
            if (!(MallOrderDetailInfoUI.this.pdO == null || MallOrderDetailInfoUI.this.pdP == null)) {
                if (view.getId() == 2131825800) {
                    MallOrderDetailInfoUI.this.pdO.setSelected(true);
                    MallOrderDetailInfoUI.this.pdP.setSelected(false);
                    MallOrderDetailInfoUI.this.pdN = 100;
                    AppMethodBeat.m2505o(43802);
                    return;
                }
                MallOrderDetailInfoUI.this.pdO.setSelected(false);
                MallOrderDetailInfoUI.this.pdP.setSelected(true);
                MallOrderDetailInfoUI.this.pdN = -100;
            }
            AppMethodBeat.m2505o(43802);
        }
    }

    /* renamed from: com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI$8 */
    class C35748 implements DialogInterface.OnClickListener {
        C35748() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(43803);
            MallOrderDetailInfoUI.this.finish();
            AppMethodBeat.m2505o(43803);
        }
    }

    /* renamed from: com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI$a */
    class C3575a extends BaseAdapter {
        private C3575a() {
        }

        /* synthetic */ C3575a(MallOrderDetailInfoUI mallOrderDetailInfoUI, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(43808);
            C34660a AF = m5929AF(i);
            AppMethodBeat.m2505o(43808);
            return AF;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(43804);
            int size = MallOrderDetailInfoUI.this.pbL.size();
            AppMethodBeat.m2505o(43804);
            return size;
        }

        /* renamed from: AF */
        private C34660a m5929AF(int i) {
            AppMethodBeat.m2504i(43805);
            C34660a c34660a = (C34660a) MallOrderDetailInfoUI.this.pbL.get(i);
            AppMethodBeat.m2505o(43805);
            return c34660a;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(43806);
            C34660a AF = m5929AF(i);
            View findViewById;
            switch (AF.type) {
                case 1:
                    view = View.inflate(MallOrderDetailInfoUI.this, 2130970042, null);
                    findViewById = view.findViewById(2131825796);
                    MallOrderDetailInfoUI.this.pdO = (CheckedTextView) view.findViewById(2131825800);
                    MallOrderDetailInfoUI.this.pdP = (CheckedTextView) view.findViewById(2131825799);
                    MallOrderDetailInfoUI.this.pdO.setOnClickListener(MallOrderDetailInfoUI.this.pdQ);
                    MallOrderDetailInfoUI.this.pdP.setOnClickListener(MallOrderDetailInfoUI.this.pdQ);
                    if (i + 1 < getCount()) {
                        MallOrderDetailInfoUI.m5914b(findViewById, m5929AF(i + 1));
                    }
                    AppMethodBeat.m2505o(43806);
                    break;
                case 2:
                    view = View.inflate(MallOrderDetailInfoUI.this, 2130970041, null);
                    TextView textView = (TextView) view.findViewById(2131825799);
                    findViewById = view.findViewById(2131825796);
                    if (C5046bo.getInt(AF.value, 0) >= 0) {
                        textView.setText(C25738R.string.cww);
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, C1318a.mall_order_detail_good, 0);
                    } else {
                        textView.setText(C25738R.string.cwv);
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, C1318a.mall_order_detail_bad, 0);
                    }
                    if (i + 1 < getCount()) {
                        MallOrderDetailInfoUI.m5914b(findViewById, m5929AF(i + 1));
                    }
                    AppMethodBeat.m2505o(43806);
                    break;
                default:
                    C3577b c3577b;
                    if (view == null) {
                        view = View.inflate(MallOrderDetailInfoUI.this, 2130970040, null);
                        C3577b c3577b2 = new C3577b(MallOrderDetailInfoUI.this, (byte) 0);
                        c3577b2.kne = (TextView) view.findViewById(2131825797);
                        c3577b2.kog = (TextView) view.findViewById(2131825798);
                        c3577b2.koh = (TextView) view.findViewById(2131825794);
                        c3577b2.jAp = view.findViewById(2131825796);
                        view.setTag(c3577b2);
                        c3577b = c3577b2;
                    } else {
                        c3577b = (C3577b) view.getTag();
                    }
                    c3577b.kne.setText(AF.name);
                    if (TextUtils.isEmpty(AF.value)) {
                        c3577b.kog.setVisibility(4);
                    } else {
                        c3577b.kog.setVisibility(0);
                        c3577b.kog.setText(AF.value);
                    }
                    if (AF.kch) {
                        c3577b.koh.setVisibility(0);
                    } else {
                        c3577b.koh.setVisibility(8);
                    }
                    if (i + 1 < getCount()) {
                        MallOrderDetailInfoUI.m5914b(c3577b.jAp, m5929AF(i + 1));
                    }
                    AppMethodBeat.m2505o(43806);
                    break;
            }
            return view;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.m2504i(43807);
            int i2 = m5929AF(i).type;
            AppMethodBeat.m2505o(43807);
            return i2;
        }

        public final int getViewTypeCount() {
            return 3;
        }
    }

    /* renamed from: com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI$6 */
    class C35766 implements OnItemClickListener {
        C35766() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(43801);
            C34660a c34660a = (C34660a) MallOrderDetailInfoUI.this.pbL.get(i);
            if (!TextUtils.isEmpty(c34660a.jumpUrl)) {
                C12785c.m20788aM(MallOrderDetailInfoUI.this, c34660a.jumpUrl);
            }
            MallOrderDetailInfoUI.m5912a(MallOrderDetailInfoUI.this, c34660a.name);
            AppMethodBeat.m2505o(43801);
        }
    }

    /* renamed from: com.tencent.mm.plugin.order.ui.MallOrderDetailInfoUI$b */
    class C3577b {
        View jAp;
        TextView kne;
        TextView kog;
        TextView koh;

        private C3577b() {
        }

        /* synthetic */ C3577b(MallOrderDetailInfoUI mallOrderDetailInfoUI, byte b) {
            this();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public MallOrderDetailInfoUI() {
        AppMethodBeat.m2504i(43809);
        AppMethodBeat.m2505o(43809);
    }

    public final int getLayoutId() {
        return 2130970048;
    }

    public void onCreate(Bundle bundle) {
        MallOrderDetailObject mallOrderDetailObject = null;
        AppMethodBeat.m2504i(43810);
        super.onCreate(bundle);
        C40931c aE = C24143a.m37112aE(this);
        if (aE != null && (aE instanceof C34656a)) {
            String string = this.mBundle.getString("key_trans_id");
            this.kBE = string;
            if (string != null) {
                C34657b.bYR();
                if (!C34657b.bYU().mo55268Uv(string)) {
                    this.pdL = false;
                    mo39970a(new C43363h(string), true, true);
                }
            }
            C34657b.bYR();
            if (C34657b.bYU().mo55268Uv(string)) {
                this.pdL = true;
                C34657b.bYR();
                C34664c bYU = C34657b.bYU();
                if (!TextUtils.isEmpty(string)) {
                    C4990ab.m7418v("MicroMsg.MallPayMsgManager", "getMallOrderDetailObjectByMsgId msgId:".concat(String.valueOf(string)));
                    C43365j Uw = bYU.mo55269Uw(string);
                    if (Uw != null) {
                        int i;
                        C34660a c34660a;
                        MallOrderDetailObject mallOrderDetailObject2 = new MallOrderDetailObject();
                        C34661b c34661b = new C34661b();
                        c34661b.pbR = Uw.pds;
                        if (TextUtils.isEmpty(Uw.pdq) || !C12785c.isNumeric(Uw.pdq)) {
                            c34661b.oyB = (int) (System.currentTimeMillis() / 1000);
                        } else {
                            c34661b.oyB = Integer.valueOf(Uw.pdq).intValue();
                        }
                        c34661b.thumbUrl = Uw.pdr;
                        c34661b.mZj = Uw.pdt;
                        c34661b.pbS = Uw.cJh;
                        mallOrderDetailObject2.pbJ = c34661b;
                        List list = Uw.pdw;
                        if (list != null && list.size() > 0) {
                            mallOrderDetailObject2.pbL = new ArrayList();
                            for (i = 0; i < list.size(); i++) {
                                C28660a c28660a = (C28660a) list.get(i);
                                c34660a = new C34660a();
                                c34660a.name = c28660a.name;
                                c34660a.value = "";
                                c34660a.jumpUrl = c28660a.jumpUrl;
                                c34660a.kch = false;
                                mallOrderDetailObject2.pbL.add(c34660a);
                            }
                        }
                        list = Uw.pdx;
                        if (list != null && list.size() > 0) {
                            if (mallOrderDetailObject2.pbL == null) {
                                mallOrderDetailObject2.pbL = new ArrayList();
                            }
                            for (i = 0; i < list.size(); i++) {
                                C34665b c34665b = (C34665b) list.get(i);
                                c34660a = new C34660a();
                                c34660a.name = c34665b.name;
                                c34660a.value = c34665b.value;
                                c34660a.jumpUrl = c34665b.jumpUrl;
                                c34660a.kch = false;
                                if (i == 0) {
                                    c34660a.kch = true;
                                }
                                mallOrderDetailObject2.pbL.add(c34660a);
                            }
                        }
                        mallOrderDetailObject2.pbP = Uw.pdv;
                        mallOrderDetailObject2.cBb = Uw.pdu;
                        if (TextUtils.isEmpty(Uw.pdq) || !C12785c.isNumeric(Uw.pdq)) {
                            mallOrderDetailObject2.pbQ = (int) (System.currentTimeMillis() / 1000);
                        } else {
                            mallOrderDetailObject2.pbQ = Integer.valueOf(Uw.pdq).intValue();
                        }
                        mallOrderDetailObject = mallOrderDetailObject2;
                    }
                }
                this.pcS = mallOrderDetailObject;
                if (this.pcS == null) {
                    bZd();
                }
            } else {
                C4990ab.m7420w("MicroMsg.MallOrderDetailInfoUI", "mOrders info is Illegal!");
                bZd();
            }
        }
        initView();
        AppMethodBeat.m2505o(43810);
    }

    public final void initView() {
        AppMethodBeat.m2504i(43811);
        if (this.pdL) {
            int i;
            C34657b.bYR();
            C43365j Uw = C34657b.bYU().mo55269Uw(this.kBE);
            if (Uw == null || TextUtils.isEmpty(Uw.pdo) || !C12785c.isNumeric(Uw.pdo)) {
                i = -1;
            } else {
                i = Integer.valueOf(Uw.pdo).intValue();
            }
            if (i == 2) {
                setMMTitle((int) C25738R.string.cwy);
            } else if (i == 1) {
                setMMTitle((int) C25738R.string.cwz);
            }
        } else {
            setMMTitle((int) C25738R.string.cx0);
        }
        this.pdE = findViewById(2131825812);
        this.pdF = findViewById(2131825813);
        this.pdJ = findViewById(2131825814);
        this.pdK = findViewById(2131825815);
        this.pdI = findViewById(2131825816);
        this.pdG = findViewById(2131825817);
        this.pdH = findViewById(2131825818);
        this.pdE.setOnClickListener(this.gKK);
        this.pdK.setOnClickListener(this.gKK);
        this.pdJ.setOnClickListener(this.gKK);
        this.pdI.setOnClickListener(this.gKK);
        this.pdG.setOnClickListener(this.gKK);
        findViewById(2131825831).setOnClickListener(this.gKK);
        findViewById(2131825822).setOnClickListener(this.gKK);
        findViewById(2131825824).setOnClickListener(this.gKK);
        this.mListView = (ListView) findViewById(2131825820);
        this.pdD = new C3575a(this, (byte) 0);
        this.mListView.setAdapter(this.pdD);
        this.pdD.notifyDataSetChanged();
        this.mListView.setOnItemClickListener(new C35766());
        ard();
        AppMethodBeat.m2505o(43811);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(43812);
        if (i == 4) {
            if (C24143a.m37112aE(this) instanceof C34656a) {
                C24143a.m37108aB(this);
            }
            AppMethodBeat.m2505o(43812);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.m2505o(43812);
        return onKeyUp;
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(43813);
        if (i == 0 && i2 == 0) {
            if (c1207m instanceof C43363h) {
                MallOrderDetailObject mallOrderDetailObject = ((C43363h) c1207m).pcS;
                C4990ab.m7410d("MicroMsg.MallOrderDetailInfoUI", "tempObject:".concat(String.valueOf(mallOrderDetailObject)));
                if (mallOrderDetailObject != null) {
                    this.pcS = mallOrderDetailObject;
                    ard();
                }
            }
            AppMethodBeat.m2505o(43813);
            return true;
        }
        AppMethodBeat.m2505o(43813);
        return false;
    }

    private void ard() {
        AppMethodBeat.m2504i(43814);
        if (this.pcS == null) {
            AppMethodBeat.m2505o(43814);
            return;
        }
        C18764x.m29326a((C18765a) this);
        this.oZx.clear();
        m5910a(this.pcS.pbJ);
        m5918cv(this.pcS.pbK);
        m5911a(this.pcS.pbI);
        m5917cu(this.pcS.pbL);
        findViewById(2131825821).setVisibility(0);
        TextView textView;
        if (this.pcS != null && TextUtils.isEmpty(this.pcS.pbP) && TextUtils.isEmpty(this.pcS.cBb)) {
            findViewById(2131825821).setVisibility(8);
        } else if (this.pcS != null && !TextUtils.isEmpty(this.pcS.pbP) && TextUtils.isEmpty(this.pcS.cBb)) {
            findViewById(2131825824).setVisibility(8);
            findViewById(2131825823).setVisibility(8);
            textView = (TextView) findViewById(2131825822);
            textView.setVisibility(0);
            textView.setGravity(3);
        } else if (!(this.pcS == null || !TextUtils.isEmpty(this.pcS.pbP) || TextUtils.isEmpty(this.pcS.cBb))) {
            findViewById(2131825822).setVisibility(8);
            findViewById(2131825823).setVisibility(8);
            textView = (TextView) findViewById(2131825824);
            textView.setVisibility(0);
            textView.setGravity(3);
        }
        if (!(this.pcS == null || TextUtils.isEmpty(this.pcS.pbO))) {
            bcQ();
        }
        AppMethodBeat.m2505o(43814);
    }

    /* renamed from: a */
    private void m5910a(C34661b c34661b) {
        AppMethodBeat.m2504i(43815);
        if (c34661b != null) {
            CharSequence charSequence;
            String str = c34661b.pbR;
            if (TextUtils.isEmpty(c34661b.pbS)) {
                Object charSequence2 = str;
            } else {
                charSequence2 = str + "：" + c34661b.pbS;
            }
            if (this.pdL) {
                this.pdE.setVisibility(8);
                this.pdF.setVisibility(0);
                ((TextView) this.pdF.findViewById(2131825829)).setText(charSequence2);
                ((TextView) this.pdF.findViewById(2131825830)).setText(C36391e.m60014kC(this.pcS.pbQ));
                if (TextUtils.isEmpty(c34661b.thumbUrl) || !C36391e.ats(c34661b.thumbUrl)) {
                    m5923h((ImageView) this.pdF.findViewById(2131825828));
                    AppMethodBeat.m2505o(43815);
                    return;
                }
                m5924p((ImageView) this.pdF.findViewById(2131825828), c34661b.thumbUrl);
                AppMethodBeat.m2505o(43815);
                return;
            }
            this.pdF.setVisibility(8);
            this.pdE.setVisibility(0);
            ((TextView) this.pdE.findViewById(2131825829)).setText(charSequence2);
            ((TextView) this.pdE.findViewById(2131825830)).setText(C36391e.m60014kC(this.pcS.pbQ));
            if (TextUtils.isEmpty(c34661b.thumbUrl) || !C36391e.ats(c34661b.thumbUrl)) {
                m5923h((ImageView) this.pdE.findViewById(2131825828));
                AppMethodBeat.m2505o(43815);
                return;
            }
            m5924p((ImageView) this.pdE.findViewById(2131825828), c34661b.thumbUrl);
            AppMethodBeat.m2505o(43815);
            return;
        }
        this.pdE.setVisibility(8);
        this.pdF.setVisibility(8);
        AppMethodBeat.m2505o(43815);
    }

    /* renamed from: a */
    private void m5911a(MallTransactionObject mallTransactionObject) {
        AppMethodBeat.m2504i(43816);
        if (mallTransactionObject != null) {
            this.pdG.setVisibility(0);
            ((TextView) findViewById(2131825819)).setText(C36391e.m60006e(mallTransactionObject.kCJ, mallTransactionObject.pcl));
            if (!(this.pcS == null || this.pcS.pbL == null || this.pcS.pbL.size() <= 0)) {
                MallOrderDetailInfoUI.m5908a(this.pdH, (C34660a) this.pcS.pbL.get(0));
                AppMethodBeat.m2505o(43816);
                return;
            }
        }
        this.pdG.setVisibility(8);
        AppMethodBeat.m2505o(43816);
    }

    /* renamed from: cu */
    private void m5917cu(List<C34660a> list) {
        AppMethodBeat.m2504i(43817);
        if (list != null) {
            this.pbL.addAll(list);
            this.pdD.notifyDataSetChanged();
        }
        AppMethodBeat.m2505o(43817);
    }

    /* renamed from: cv */
    private void m5918cv(List<ProductSectionItem> list) {
        AppMethodBeat.m2504i(43818);
        if (list == null || list.size() == 0) {
            this.pdI.setVisibility(8);
            this.pdJ.setVisibility(8);
            this.pdK.setVisibility(8);
            AppMethodBeat.m2505o(43818);
        } else if (list.size() == 1) {
            this.pdK.setVisibility(8);
            ProductSectionItem productSectionItem = (ProductSectionItem) list.get(0);
            if (TextUtils.isEmpty(productSectionItem.iconUrl)) {
                this.pdJ.setVisibility(8);
                this.pdI.setVisibility(0);
                ((TextView) this.pdI.findViewById(2131825845)).setText(productSectionItem.name);
                if (TextUtils.isEmpty(productSectionItem.jumpUrl)) {
                    Rect rect = new Rect();
                    rect.set(this.pdI.findViewById(2131825849).getPaddingLeft(), this.pdI.findViewById(2131825849).getPaddingTop(), this.pdI.findViewById(2131825849).getPaddingRight(), this.pdI.findViewById(2131825849).getPaddingBottom());
                    this.pdI.findViewById(2131825849).setBackgroundResource(C25738R.drawable.a_q);
                    this.pdI.findViewById(2131825849).setPadding(rect.left, rect.top, rect.right, rect.bottom);
                    AppMethodBeat.m2505o(43818);
                    return;
                }
                ((TextView) this.pdI.findViewById(2131825845)).setTextColor(getResources().getColor(C25738R.color.f12170uq));
            } else {
                this.pdI.setVisibility(8);
                this.pdJ.setVisibility(0);
                ((TextView) this.pdJ.findViewById(2131825845)).setText(productSectionItem.name);
                ((TextView) this.pdJ.findViewById(2131825853)).setText(productSectionItem.pdz);
                ((TextView) this.pdJ.findViewById(2131825854)).setText("+" + productSectionItem.count);
                ((TextView) this.pdJ.findViewById(2131825852)).setText(Skus.m56902ct(productSectionItem.pdy));
                if (!TextUtils.isEmpty(productSectionItem.iconUrl)) {
                    m5924p((ImageView) this.pdJ.findViewById(2131825844), productSectionItem.iconUrl);
                    AppMethodBeat.m2505o(43818);
                    return;
                }
            }
            AppMethodBeat.m2505o(43818);
        } else {
            this.pdI.setVisibility(8);
            this.pdJ.setVisibility(8);
            this.pdK.setVisibility(0);
            if (list.size() == 2) {
                m5909a(this.pdK.findViewById(2131825843), (ProductSectionItem) list.get(0));
                m5909a(this.pdK.findViewById(2131825846), (ProductSectionItem) list.get(1));
                this.pdK.findViewById(2131825847).setVisibility(8);
                this.pdK.findViewById(2131825848).setVisibility(8);
                AppMethodBeat.m2505o(43818);
            } else if (list.size() == 3) {
                m5909a(this.pdK.findViewById(2131825843), (ProductSectionItem) list.get(0));
                m5909a(this.pdK.findViewById(2131825846), (ProductSectionItem) list.get(1));
                m5909a(this.pdK.findViewById(2131825847), (ProductSectionItem) list.get(2));
                this.pdK.findViewById(2131825848).setVisibility(8);
                AppMethodBeat.m2505o(43818);
            } else {
                if (list.size() >= 4) {
                    m5909a(this.pdK.findViewById(2131825843), (ProductSectionItem) list.get(0));
                    m5909a(this.pdK.findViewById(2131825846), (ProductSectionItem) list.get(1));
                    m5909a(this.pdK.findViewById(2131825847), (ProductSectionItem) list.get(2));
                    m5909a(this.pdK.findViewById(2131825848), (ProductSectionItem) list.get(3));
                }
                AppMethodBeat.m2505o(43818);
            }
        }
    }

    /* renamed from: a */
    private void m5909a(View view, ProductSectionItem productSectionItem) {
        AppMethodBeat.m2504i(43819);
        if (view == null || productSectionItem == null) {
            AppMethodBeat.m2505o(43819);
            return;
        }
        view.setVisibility(0);
        TextView textView = (TextView) view.findViewById(2131825845);
        if (textView != null) {
            textView.setText(productSectionItem.name);
        }
        if (!TextUtils.isEmpty(productSectionItem.iconUrl)) {
            m5924p((ImageView) view.findViewById(2131825844), productSectionItem.iconUrl);
        }
        AppMethodBeat.m2505o(43819);
    }

    /* renamed from: p */
    private void m5924p(ImageView imageView, String str) {
        AppMethodBeat.m2504i(43820);
        if (imageView == null || TextUtils.isEmpty(str) || !C36391e.ats(str)) {
            AppMethodBeat.m2505o(43820);
            return;
        }
        imageView.setImageBitmap(C18764x.m29325a(new C28657b(str)));
        this.oZx.put(str, imageView);
        AppMethodBeat.m2505o(43820);
    }

    private void bcQ() {
        AppMethodBeat.m2504i(43821);
        addIconOptionMenu(0, C25738R.drawable.f6899uu, new C35714());
        AppMethodBeat.m2505o(43821);
    }

    /* renamed from: a */
    private static void m5908a(View view, C34660a c34660a) {
        AppMethodBeat.m2504i(43822);
        if (c34660a == null) {
            AppMethodBeat.m2505o(43822);
            return;
        }
        Rect rect = new Rect();
        rect.left = view.getPaddingLeft();
        rect.right = view.getPaddingRight();
        rect.top = view.getPaddingTop();
        rect.bottom = view.getPaddingBottom();
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (c34660a == null || !c34660a.kch) {
            view.setBackgroundResource(C25738R.drawable.a_q);
        } else {
            view.setBackgroundResource(C25738R.drawable.f6900uv);
        }
        view.setLayoutParams(layoutParams);
        view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        AppMethodBeat.m2505o(43822);
    }

    /* renamed from: m */
    public final void mo8136m(String str, Bitmap bitmap) {
        AppMethodBeat.m2504i(43823);
        ImageView imageView = (ImageView) this.oZx.get(str);
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
        AppMethodBeat.m2505o(43823);
    }

    /* renamed from: h */
    private void m5923h(ImageView imageView) {
        AppMethodBeat.m2504i(43824);
        Bitmap decodeResource = C1434a.decodeResource(getResources(), C1318a.mall_order_trade_state_icon);
        if (decodeResource != null) {
            imageView.setImageBitmap(C5056d.m7616a(decodeResource, false, 96.0f));
        }
        AppMethodBeat.m2505o(43824);
    }

    private void bZc() {
        AppMethodBeat.m2504i(43825);
        if (!(this.pdM || this.pdN == 0)) {
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(new C21422f(this.kBE, "", this.pdN), 0);
            this.pdM = true;
        }
        AppMethodBeat.m2505o(43825);
    }

    public void finish() {
        AppMethodBeat.m2504i(43826);
        bZc();
        super.finish();
        AppMethodBeat.m2505o(43826);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(43827);
        bZc();
        super.onDestroy();
        AppMethodBeat.m2505o(43827);
    }

    /* renamed from: wU */
    public final void mo8137wU(int i) {
        AppMethodBeat.m2504i(43828);
        finish();
        AppMethodBeat.m2505o(43828);
    }

    private void bZd() {
        AppMethodBeat.m2504i(43829);
        C30379h.m48431a(this.mController.ylL, (int) C25738R.string.fkw, 0, new C35748());
        AppMethodBeat.m2505o(43829);
    }

    /* renamed from: b */
    static /* synthetic */ void m5915b(MallOrderDetailInfoUI mallOrderDetailInfoUI) {
        AppMethodBeat.m2504i(43831);
        C30379h.m48466d(mallOrderDetailInfoUI, "商家已退全款，总价125元，包含商品价格115元，邮费10元，请确认是否同意通过该处理结果。", mallOrderDetailInfoUI.getString(C25738R.string.cwr), mallOrderDetailInfoUI.getString(C25738R.string.cx7), mallOrderDetailInfoUI.getString(C25738R.string.cx8), new C35692(), new C35703());
        AppMethodBeat.m2505o(43831);
    }

    /* renamed from: c */
    static /* synthetic */ void m5916c(MallOrderDetailInfoUI mallOrderDetailInfoUI) {
        AppMethodBeat.m2504i(43832);
        if (!TextUtils.isEmpty(mallOrderDetailInfoUI.pdC)) {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(mallOrderDetailInfoUI.pdC).toString()));
            intent.addFlags(268435456);
            mallOrderDetailInfoUI.startActivity(intent);
        }
        AppMethodBeat.m2505o(43832);
    }

    /* renamed from: d */
    static /* synthetic */ void m5919d(MallOrderDetailInfoUI mallOrderDetailInfoUI) {
        AppMethodBeat.m2504i(43833);
        Context context = mallOrderDetailInfoUI;
        C30379h.m48424a(context, "", new String[]{mallOrderDetailInfoUI.getString(C25738R.string.cx9)}, "", false, new C35725());
        AppMethodBeat.m2505o(43833);
    }
}
