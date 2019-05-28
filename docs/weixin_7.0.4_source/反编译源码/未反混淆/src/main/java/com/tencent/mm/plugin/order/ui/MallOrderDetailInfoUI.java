package com.tencent.mm.plugin.order.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.order.c.c;
import com.tencent.mm.plugin.order.model.MallOrderDetailObject;
import com.tencent.mm.plugin.order.model.MallTransactionObject;
import com.tencent.mm.plugin.order.model.ProductSectionItem;
import com.tencent.mm.plugin.order.model.ProductSectionItem.Skus;
import com.tencent.mm.plugin.order.model.f;
import com.tencent.mm.plugin.order.model.h;
import com.tencent.mm.plugin.order.model.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class MallOrderDetailInfoUI extends WalletBaseUI implements com.tencent.mm.platformtools.x.a {
    private OnClickListener gKK = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(43798);
            if (view.getId() == R.id.d4e) {
                if (MallOrderDetailInfoUI.this.pcS.pbJ != null) {
                    c.aM(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.pcS.pbJ.mZj);
                    MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.pcS.pbJ.pbR);
                    AppMethodBeat.o(43798);
                    return;
                }
            } else if (view.getId() == R.id.d4g || view.getId() == R.id.d4i) {
                if (MallOrderDetailInfoUI.this.pcS.pbK != null && MallOrderDetailInfoUI.this.pcS.pbK.size() > 0) {
                    boolean z;
                    if (TextUtils.isEmpty(((ProductSectionItem) MallOrderDetailInfoUI.this.pcS.pbK.get(0)).jumpUrl)) {
                        z = false;
                    } else {
                        z = c.aM(MallOrderDetailInfoUI.this, ((ProductSectionItem) MallOrderDetailInfoUI.this.pcS.pbK.get(0)).jumpUrl);
                    }
                    if (!z) {
                        c.aN(MallOrderDetailInfoUI.this, ((ProductSectionItem) MallOrderDetailInfoUI.this.pcS.pbK.get(0)).pdA);
                    }
                    MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, ((ProductSectionItem) MallOrderDetailInfoUI.this.pcS.pbK.get(0)).name);
                    AppMethodBeat.o(43798);
                    return;
                }
            } else if (view.getId() == R.id.d4h) {
                Bundle bundle = MallOrderDetailInfoUI.this.mBundle;
                bundle.putParcelableArrayList("order_product_list", MallOrderDetailInfoUI.this.pcS.pbK);
                bundle.putInt("key_enter_id", 0);
                bundle.putString("key_trans_id", MallOrderDetailInfoUI.this.kBE);
                bundle.putString("appname", MallOrderDetailInfoUI.this.pcS.cBb);
                com.tencent.mm.wallet_core.a.j(MallOrderDetailInfoUI.this, new Bundle());
                MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.getResources().getString(R.string.cx6));
                AppMethodBeat.o(43798);
                return;
            } else if (view.getId() == R.id.d4j) {
                String string = MallOrderDetailInfoUI.this.mBundle.getString("key_trans_id");
                Bundle bundle2 = MallOrderDetailInfoUI.this.mBundle;
                bundle2.putString("key_trans_id", string);
                bundle2.putInt("key_enter_id", 1);
                if (MallOrderDetailInfoUI.this.pcS != null) {
                    bundle2.putParcelable("transaction_data", MallOrderDetailInfoUI.this.pcS.pbI);
                }
                com.tencent.mm.wallet_core.a.j(MallOrderDetailInfoUI.this, bundle2);
                MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.getResources().getString(R.string.cx3));
                AppMethodBeat.o(43798);
                return;
            } else if (view.getId() == R.id.d4x) {
                MallOrderDetailInfoUI.b(MallOrderDetailInfoUI.this);
                AppMethodBeat.o(43798);
                return;
            } else if (view.getId() == R.id.d4o) {
                if (!(MallOrderDetailInfoUI.this.pcS == null || MallOrderDetailInfoUI.this.pcS.pbP == null)) {
                    MallOrderDetailInfoUI.this.pdC = MallOrderDetailInfoUI.this.pcS.pbP;
                    MallOrderDetailInfoUI.c(MallOrderDetailInfoUI.this);
                    MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.getResources().getString(R.string.cx1));
                    AppMethodBeat.o(43798);
                    return;
                }
            } else if (view.getId() == R.id.d4q) {
                e.af(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.pcS.cBb);
                MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.getResources().getString(R.string.cxb));
            }
            AppMethodBeat.o(43798);
        }
    };
    private String kBE = "";
    private ListView mListView;
    private HashMap<String, View> oZx = new HashMap();
    private List<com.tencent.mm.plugin.order.model.MallOrderDetailObject.a> pbL = new ArrayList();
    protected MallOrderDetailObject pcS = null;
    String pdC;
    private a pdD;
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
    OnClickListener pdQ = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(43802);
            if (!(MallOrderDetailInfoUI.this.pdO == null || MallOrderDetailInfoUI.this.pdP == null)) {
                if (view.getId() == R.id.d43) {
                    MallOrderDetailInfoUI.this.pdO.setSelected(true);
                    MallOrderDetailInfoUI.this.pdP.setSelected(false);
                    MallOrderDetailInfoUI.this.pdN = 100;
                    AppMethodBeat.o(43802);
                    return;
                }
                MallOrderDetailInfoUI.this.pdO.setSelected(false);
                MallOrderDetailInfoUI.this.pdP.setSelected(true);
                MallOrderDetailInfoUI.this.pdN = -100;
            }
            AppMethodBeat.o(43802);
        }
    };

    class a extends BaseAdapter {
        private a() {
        }

        /* synthetic */ a(MallOrderDetailInfoUI mallOrderDetailInfoUI, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(43808);
            com.tencent.mm.plugin.order.model.MallOrderDetailObject.a AF = AF(i);
            AppMethodBeat.o(43808);
            return AF;
        }

        public final int getCount() {
            AppMethodBeat.i(43804);
            int size = MallOrderDetailInfoUI.this.pbL.size();
            AppMethodBeat.o(43804);
            return size;
        }

        private com.tencent.mm.plugin.order.model.MallOrderDetailObject.a AF(int i) {
            AppMethodBeat.i(43805);
            com.tencent.mm.plugin.order.model.MallOrderDetailObject.a aVar = (com.tencent.mm.plugin.order.model.MallOrderDetailObject.a) MallOrderDetailInfoUI.this.pbL.get(i);
            AppMethodBeat.o(43805);
            return aVar;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(43806);
            com.tencent.mm.plugin.order.model.MallOrderDetailObject.a AF = AF(i);
            View findViewById;
            switch (AF.type) {
                case 1:
                    view = View.inflate(MallOrderDetailInfoUI.this, R.layout.abt, null);
                    findViewById = view.findViewById(R.id.d3z);
                    MallOrderDetailInfoUI.this.pdO = (CheckedTextView) view.findViewById(R.id.d43);
                    MallOrderDetailInfoUI.this.pdP = (CheckedTextView) view.findViewById(R.id.d42);
                    MallOrderDetailInfoUI.this.pdO.setOnClickListener(MallOrderDetailInfoUI.this.pdQ);
                    MallOrderDetailInfoUI.this.pdP.setOnClickListener(MallOrderDetailInfoUI.this.pdQ);
                    if (i + 1 < getCount()) {
                        MallOrderDetailInfoUI.b(findViewById, AF(i + 1));
                    }
                    AppMethodBeat.o(43806);
                    break;
                case 2:
                    view = View.inflate(MallOrderDetailInfoUI.this, R.layout.abs, null);
                    TextView textView = (TextView) view.findViewById(R.id.d42);
                    findViewById = view.findViewById(R.id.d3z);
                    if (bo.getInt(AF.value, 0) >= 0) {
                        textView.setText(R.string.cww);
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.raw.mall_order_detail_good, 0);
                    } else {
                        textView.setText(R.string.cwv);
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.raw.mall_order_detail_bad, 0);
                    }
                    if (i + 1 < getCount()) {
                        MallOrderDetailInfoUI.b(findViewById, AF(i + 1));
                    }
                    AppMethodBeat.o(43806);
                    break;
                default:
                    b bVar;
                    if (view == null) {
                        view = View.inflate(MallOrderDetailInfoUI.this, R.layout.abr, null);
                        b bVar2 = new b(MallOrderDetailInfoUI.this, (byte) 0);
                        bVar2.kne = (TextView) view.findViewById(R.id.d40);
                        bVar2.kog = (TextView) view.findViewById(R.id.d41);
                        bVar2.koh = (TextView) view.findViewById(R.id.d3x);
                        bVar2.jAp = view.findViewById(R.id.d3z);
                        view.setTag(bVar2);
                        bVar = bVar2;
                    } else {
                        bVar = (b) view.getTag();
                    }
                    bVar.kne.setText(AF.name);
                    if (TextUtils.isEmpty(AF.value)) {
                        bVar.kog.setVisibility(4);
                    } else {
                        bVar.kog.setVisibility(0);
                        bVar.kog.setText(AF.value);
                    }
                    if (AF.kch) {
                        bVar.koh.setVisibility(0);
                    } else {
                        bVar.koh.setVisibility(8);
                    }
                    if (i + 1 < getCount()) {
                        MallOrderDetailInfoUI.b(bVar.jAp, AF(i + 1));
                    }
                    AppMethodBeat.o(43806);
                    break;
            }
            return view;
        }

        public final int getItemViewType(int i) {
            AppMethodBeat.i(43807);
            int i2 = AF(i).type;
            AppMethodBeat.o(43807);
            return i2;
        }

        public final int getViewTypeCount() {
            return 3;
        }
    }

    class b {
        View jAp;
        TextView kne;
        TextView kog;
        TextView koh;

        private b() {
        }

        /* synthetic */ b(MallOrderDetailInfoUI mallOrderDetailInfoUI, byte b) {
            this();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MallOrderDetailInfoUI() {
        AppMethodBeat.i(43809);
        AppMethodBeat.o(43809);
    }

    public final int getLayoutId() {
        return R.layout.abz;
    }

    public void onCreate(Bundle bundle) {
        MallOrderDetailObject mallOrderDetailObject = null;
        AppMethodBeat.i(43810);
        super.onCreate(bundle);
        com.tencent.mm.wallet_core.c aE = com.tencent.mm.wallet_core.a.aE(this);
        if (aE != null && (aE instanceof com.tencent.mm.plugin.order.a.a)) {
            String string = this.mBundle.getString("key_trans_id");
            this.kBE = string;
            if (string != null) {
                com.tencent.mm.plugin.order.a.b.bYR();
                if (!com.tencent.mm.plugin.order.a.b.bYU().Uv(string)) {
                    this.pdL = false;
                    a(new h(string), true, true);
                }
            }
            com.tencent.mm.plugin.order.a.b.bYR();
            if (com.tencent.mm.plugin.order.a.b.bYU().Uv(string)) {
                this.pdL = true;
                com.tencent.mm.plugin.order.a.b.bYR();
                com.tencent.mm.plugin.order.model.c bYU = com.tencent.mm.plugin.order.a.b.bYU();
                if (!TextUtils.isEmpty(string)) {
                    ab.v("MicroMsg.MallPayMsgManager", "getMallOrderDetailObjectByMsgId msgId:".concat(String.valueOf(string)));
                    j Uw = bYU.Uw(string);
                    if (Uw != null) {
                        int i;
                        com.tencent.mm.plugin.order.model.MallOrderDetailObject.a aVar;
                        MallOrderDetailObject mallOrderDetailObject2 = new MallOrderDetailObject();
                        com.tencent.mm.plugin.order.model.MallOrderDetailObject.b bVar = new com.tencent.mm.plugin.order.model.MallOrderDetailObject.b();
                        bVar.pbR = Uw.pds;
                        if (TextUtils.isEmpty(Uw.pdq) || !c.isNumeric(Uw.pdq)) {
                            bVar.oyB = (int) (System.currentTimeMillis() / 1000);
                        } else {
                            bVar.oyB = Integer.valueOf(Uw.pdq).intValue();
                        }
                        bVar.thumbUrl = Uw.pdr;
                        bVar.mZj = Uw.pdt;
                        bVar.pbS = Uw.cJh;
                        mallOrderDetailObject2.pbJ = bVar;
                        List list = Uw.pdw;
                        if (list != null && list.size() > 0) {
                            mallOrderDetailObject2.pbL = new ArrayList();
                            for (i = 0; i < list.size(); i++) {
                                com.tencent.mm.plugin.order.model.j.a aVar2 = (com.tencent.mm.plugin.order.model.j.a) list.get(i);
                                aVar = new com.tencent.mm.plugin.order.model.MallOrderDetailObject.a();
                                aVar.name = aVar2.name;
                                aVar.value = "";
                                aVar.jumpUrl = aVar2.jumpUrl;
                                aVar.kch = false;
                                mallOrderDetailObject2.pbL.add(aVar);
                            }
                        }
                        list = Uw.pdx;
                        if (list != null && list.size() > 0) {
                            if (mallOrderDetailObject2.pbL == null) {
                                mallOrderDetailObject2.pbL = new ArrayList();
                            }
                            for (i = 0; i < list.size(); i++) {
                                com.tencent.mm.plugin.order.model.j.b bVar2 = (com.tencent.mm.plugin.order.model.j.b) list.get(i);
                                aVar = new com.tencent.mm.plugin.order.model.MallOrderDetailObject.a();
                                aVar.name = bVar2.name;
                                aVar.value = bVar2.value;
                                aVar.jumpUrl = bVar2.jumpUrl;
                                aVar.kch = false;
                                if (i == 0) {
                                    aVar.kch = true;
                                }
                                mallOrderDetailObject2.pbL.add(aVar);
                            }
                        }
                        mallOrderDetailObject2.pbP = Uw.pdv;
                        mallOrderDetailObject2.cBb = Uw.pdu;
                        if (TextUtils.isEmpty(Uw.pdq) || !c.isNumeric(Uw.pdq)) {
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
                ab.w("MicroMsg.MallOrderDetailInfoUI", "mOrders info is Illegal!");
                bZd();
            }
        }
        initView();
        AppMethodBeat.o(43810);
    }

    public final void initView() {
        AppMethodBeat.i(43811);
        if (this.pdL) {
            int i;
            com.tencent.mm.plugin.order.a.b.bYR();
            j Uw = com.tencent.mm.plugin.order.a.b.bYU().Uw(this.kBE);
            if (Uw == null || TextUtils.isEmpty(Uw.pdo) || !c.isNumeric(Uw.pdo)) {
                i = -1;
            } else {
                i = Integer.valueOf(Uw.pdo).intValue();
            }
            if (i == 2) {
                setMMTitle((int) R.string.cwy);
            } else if (i == 1) {
                setMMTitle((int) R.string.cwz);
            }
        } else {
            setMMTitle((int) R.string.cx0);
        }
        this.pdE = findViewById(R.id.d4e);
        this.pdF = findViewById(R.id.d4f);
        this.pdJ = findViewById(R.id.d4g);
        this.pdK = findViewById(R.id.d4h);
        this.pdI = findViewById(R.id.d4i);
        this.pdG = findViewById(R.id.d4j);
        this.pdH = findViewById(R.id.d4k);
        this.pdE.setOnClickListener(this.gKK);
        this.pdK.setOnClickListener(this.gKK);
        this.pdJ.setOnClickListener(this.gKK);
        this.pdI.setOnClickListener(this.gKK);
        this.pdG.setOnClickListener(this.gKK);
        findViewById(R.id.d4x).setOnClickListener(this.gKK);
        findViewById(R.id.d4o).setOnClickListener(this.gKK);
        findViewById(R.id.d4q).setOnClickListener(this.gKK);
        this.mListView = (ListView) findViewById(R.id.d4m);
        this.pdD = new a(this, (byte) 0);
        this.mListView.setAdapter(this.pdD);
        this.pdD.notifyDataSetChanged();
        this.mListView.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(43801);
                com.tencent.mm.plugin.order.model.MallOrderDetailObject.a aVar = (com.tencent.mm.plugin.order.model.MallOrderDetailObject.a) MallOrderDetailInfoUI.this.pbL.get(i);
                if (!TextUtils.isEmpty(aVar.jumpUrl)) {
                    c.aM(MallOrderDetailInfoUI.this, aVar.jumpUrl);
                }
                MallOrderDetailInfoUI.a(MallOrderDetailInfoUI.this, aVar.name);
                AppMethodBeat.o(43801);
            }
        });
        ard();
        AppMethodBeat.o(43811);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(43812);
        if (i == 4) {
            if (com.tencent.mm.wallet_core.a.aE(this) instanceof com.tencent.mm.plugin.order.a.a) {
                com.tencent.mm.wallet_core.a.aB(this);
            }
            AppMethodBeat.o(43812);
            return true;
        }
        boolean onKeyUp = super.onKeyUp(i, keyEvent);
        AppMethodBeat.o(43812);
        return onKeyUp;
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(43813);
        if (i == 0 && i2 == 0) {
            if (mVar instanceof h) {
                MallOrderDetailObject mallOrderDetailObject = ((h) mVar).pcS;
                ab.d("MicroMsg.MallOrderDetailInfoUI", "tempObject:".concat(String.valueOf(mallOrderDetailObject)));
                if (mallOrderDetailObject != null) {
                    this.pcS = mallOrderDetailObject;
                    ard();
                }
            }
            AppMethodBeat.o(43813);
            return true;
        }
        AppMethodBeat.o(43813);
        return false;
    }

    private void ard() {
        AppMethodBeat.i(43814);
        if (this.pcS == null) {
            AppMethodBeat.o(43814);
            return;
        }
        x.a((com.tencent.mm.platformtools.x.a) this);
        this.oZx.clear();
        a(this.pcS.pbJ);
        cv(this.pcS.pbK);
        a(this.pcS.pbI);
        cu(this.pcS.pbL);
        findViewById(R.id.d4n).setVisibility(0);
        TextView textView;
        if (this.pcS != null && TextUtils.isEmpty(this.pcS.pbP) && TextUtils.isEmpty(this.pcS.cBb)) {
            findViewById(R.id.d4n).setVisibility(8);
        } else if (this.pcS != null && !TextUtils.isEmpty(this.pcS.pbP) && TextUtils.isEmpty(this.pcS.cBb)) {
            findViewById(R.id.d4q).setVisibility(8);
            findViewById(R.id.d4p).setVisibility(8);
            textView = (TextView) findViewById(R.id.d4o);
            textView.setVisibility(0);
            textView.setGravity(3);
        } else if (!(this.pcS == null || !TextUtils.isEmpty(this.pcS.pbP) || TextUtils.isEmpty(this.pcS.cBb))) {
            findViewById(R.id.d4o).setVisibility(8);
            findViewById(R.id.d4p).setVisibility(8);
            textView = (TextView) findViewById(R.id.d4q);
            textView.setVisibility(0);
            textView.setGravity(3);
        }
        if (!(this.pcS == null || TextUtils.isEmpty(this.pcS.pbO))) {
            bcQ();
        }
        AppMethodBeat.o(43814);
    }

    private void a(com.tencent.mm.plugin.order.model.MallOrderDetailObject.b bVar) {
        AppMethodBeat.i(43815);
        if (bVar != null) {
            CharSequence charSequence;
            String str = bVar.pbR;
            if (TextUtils.isEmpty(bVar.pbS)) {
                Object charSequence2 = str;
            } else {
                charSequence2 = str + "：" + bVar.pbS;
            }
            if (this.pdL) {
                this.pdE.setVisibility(8);
                this.pdF.setVisibility(0);
                ((TextView) this.pdF.findViewById(R.id.d4v)).setText(charSequence2);
                ((TextView) this.pdF.findViewById(R.id.d4w)).setText(e.kC(this.pcS.pbQ));
                if (TextUtils.isEmpty(bVar.thumbUrl) || !e.ats(bVar.thumbUrl)) {
                    h((ImageView) this.pdF.findViewById(R.id.d4u));
                    AppMethodBeat.o(43815);
                    return;
                }
                p((ImageView) this.pdF.findViewById(R.id.d4u), bVar.thumbUrl);
                AppMethodBeat.o(43815);
                return;
            }
            this.pdF.setVisibility(8);
            this.pdE.setVisibility(0);
            ((TextView) this.pdE.findViewById(R.id.d4v)).setText(charSequence2);
            ((TextView) this.pdE.findViewById(R.id.d4w)).setText(e.kC(this.pcS.pbQ));
            if (TextUtils.isEmpty(bVar.thumbUrl) || !e.ats(bVar.thumbUrl)) {
                h((ImageView) this.pdE.findViewById(R.id.d4u));
                AppMethodBeat.o(43815);
                return;
            }
            p((ImageView) this.pdE.findViewById(R.id.d4u), bVar.thumbUrl);
            AppMethodBeat.o(43815);
            return;
        }
        this.pdE.setVisibility(8);
        this.pdF.setVisibility(8);
        AppMethodBeat.o(43815);
    }

    private void a(MallTransactionObject mallTransactionObject) {
        AppMethodBeat.i(43816);
        if (mallTransactionObject != null) {
            this.pdG.setVisibility(0);
            ((TextView) findViewById(R.id.d4l)).setText(e.e(mallTransactionObject.kCJ, mallTransactionObject.pcl));
            if (!(this.pcS == null || this.pcS.pbL == null || this.pcS.pbL.size() <= 0)) {
                a(this.pdH, (com.tencent.mm.plugin.order.model.MallOrderDetailObject.a) this.pcS.pbL.get(0));
                AppMethodBeat.o(43816);
                return;
            }
        }
        this.pdG.setVisibility(8);
        AppMethodBeat.o(43816);
    }

    private void cu(List<com.tencent.mm.plugin.order.model.MallOrderDetailObject.a> list) {
        AppMethodBeat.i(43817);
        if (list != null) {
            this.pbL.addAll(list);
            this.pdD.notifyDataSetChanged();
        }
        AppMethodBeat.o(43817);
    }

    private void cv(List<ProductSectionItem> list) {
        AppMethodBeat.i(43818);
        if (list == null || list.size() == 0) {
            this.pdI.setVisibility(8);
            this.pdJ.setVisibility(8);
            this.pdK.setVisibility(8);
            AppMethodBeat.o(43818);
        } else if (list.size() == 1) {
            this.pdK.setVisibility(8);
            ProductSectionItem productSectionItem = (ProductSectionItem) list.get(0);
            if (TextUtils.isEmpty(productSectionItem.iconUrl)) {
                this.pdJ.setVisibility(8);
                this.pdI.setVisibility(0);
                ((TextView) this.pdI.findViewById(R.id.d5a)).setText(productSectionItem.name);
                if (TextUtils.isEmpty(productSectionItem.jumpUrl)) {
                    Rect rect = new Rect();
                    rect.set(this.pdI.findViewById(R.id.d5e).getPaddingLeft(), this.pdI.findViewById(R.id.d5e).getPaddingTop(), this.pdI.findViewById(R.id.d5e).getPaddingRight(), this.pdI.findViewById(R.id.d5e).getPaddingBottom());
                    this.pdI.findViewById(R.id.d5e).setBackgroundResource(R.drawable.a_q);
                    this.pdI.findViewById(R.id.d5e).setPadding(rect.left, rect.top, rect.right, rect.bottom);
                    AppMethodBeat.o(43818);
                    return;
                }
                ((TextView) this.pdI.findViewById(R.id.d5a)).setTextColor(getResources().getColor(R.color.uq));
            } else {
                this.pdI.setVisibility(8);
                this.pdJ.setVisibility(0);
                ((TextView) this.pdJ.findViewById(R.id.d5a)).setText(productSectionItem.name);
                ((TextView) this.pdJ.findViewById(R.id.d5i)).setText(productSectionItem.pdz);
                ((TextView) this.pdJ.findViewById(R.id.d5j)).setText("+" + productSectionItem.count);
                ((TextView) this.pdJ.findViewById(R.id.d5h)).setText(Skus.ct(productSectionItem.pdy));
                if (!TextUtils.isEmpty(productSectionItem.iconUrl)) {
                    p((ImageView) this.pdJ.findViewById(R.id.d5_), productSectionItem.iconUrl);
                    AppMethodBeat.o(43818);
                    return;
                }
            }
            AppMethodBeat.o(43818);
        } else {
            this.pdI.setVisibility(8);
            this.pdJ.setVisibility(8);
            this.pdK.setVisibility(0);
            if (list.size() == 2) {
                a(this.pdK.findViewById(R.id.d59), (ProductSectionItem) list.get(0));
                a(this.pdK.findViewById(R.id.d5b), (ProductSectionItem) list.get(1));
                this.pdK.findViewById(R.id.d5c).setVisibility(8);
                this.pdK.findViewById(R.id.d5d).setVisibility(8);
                AppMethodBeat.o(43818);
            } else if (list.size() == 3) {
                a(this.pdK.findViewById(R.id.d59), (ProductSectionItem) list.get(0));
                a(this.pdK.findViewById(R.id.d5b), (ProductSectionItem) list.get(1));
                a(this.pdK.findViewById(R.id.d5c), (ProductSectionItem) list.get(2));
                this.pdK.findViewById(R.id.d5d).setVisibility(8);
                AppMethodBeat.o(43818);
            } else {
                if (list.size() >= 4) {
                    a(this.pdK.findViewById(R.id.d59), (ProductSectionItem) list.get(0));
                    a(this.pdK.findViewById(R.id.d5b), (ProductSectionItem) list.get(1));
                    a(this.pdK.findViewById(R.id.d5c), (ProductSectionItem) list.get(2));
                    a(this.pdK.findViewById(R.id.d5d), (ProductSectionItem) list.get(3));
                }
                AppMethodBeat.o(43818);
            }
        }
    }

    private void a(View view, ProductSectionItem productSectionItem) {
        AppMethodBeat.i(43819);
        if (view == null || productSectionItem == null) {
            AppMethodBeat.o(43819);
            return;
        }
        view.setVisibility(0);
        TextView textView = (TextView) view.findViewById(R.id.d5a);
        if (textView != null) {
            textView.setText(productSectionItem.name);
        }
        if (!TextUtils.isEmpty(productSectionItem.iconUrl)) {
            p((ImageView) view.findViewById(R.id.d5_), productSectionItem.iconUrl);
        }
        AppMethodBeat.o(43819);
    }

    private void p(ImageView imageView, String str) {
        AppMethodBeat.i(43820);
        if (imageView == null || TextUtils.isEmpty(str) || !e.ats(str)) {
            AppMethodBeat.o(43820);
            return;
        }
        imageView.setImageBitmap(x.a(new com.tencent.mm.plugin.order.c.b(str)));
        this.oZx.put(str, imageView);
        AppMethodBeat.o(43820);
    }

    private void bcQ() {
        AppMethodBeat.i(43821);
        addIconOptionMenu(0, R.drawable.uu, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(43799);
                MallOrderDetailInfoUI.d(MallOrderDetailInfoUI.this);
                AppMethodBeat.o(43799);
                return true;
            }
        });
        AppMethodBeat.o(43821);
    }

    private static void a(View view, com.tencent.mm.plugin.order.model.MallOrderDetailObject.a aVar) {
        AppMethodBeat.i(43822);
        if (aVar == null) {
            AppMethodBeat.o(43822);
            return;
        }
        Rect rect = new Rect();
        rect.left = view.getPaddingLeft();
        rect.right = view.getPaddingRight();
        rect.top = view.getPaddingTop();
        rect.bottom = view.getPaddingBottom();
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (aVar == null || !aVar.kch) {
            view.setBackgroundResource(R.drawable.a_q);
        } else {
            view.setBackgroundResource(R.drawable.uv);
        }
        view.setLayoutParams(layoutParams);
        view.setPadding(rect.left, rect.top, rect.right, rect.bottom);
        AppMethodBeat.o(43822);
    }

    public final void m(String str, Bitmap bitmap) {
        AppMethodBeat.i(43823);
        ImageView imageView = (ImageView) this.oZx.get(str);
        if (imageView != null) {
            imageView.setImageBitmap(bitmap);
        }
        AppMethodBeat.o(43823);
    }

    private void h(ImageView imageView) {
        AppMethodBeat.i(43824);
        Bitmap decodeResource = com.tencent.mm.compatible.g.a.decodeResource(getResources(), R.raw.mall_order_trade_state_icon);
        if (decodeResource != null) {
            imageView.setImageBitmap(d.a(decodeResource, false, 96.0f));
        }
        AppMethodBeat.o(43824);
    }

    private void bZc() {
        AppMethodBeat.i(43825);
        if (!(this.pdM || this.pdN == 0)) {
            g.RQ();
            g.RO().eJo.a(new f(this.kBE, "", this.pdN), 0);
            this.pdM = true;
        }
        AppMethodBeat.o(43825);
    }

    public void finish() {
        AppMethodBeat.i(43826);
        bZc();
        super.finish();
        AppMethodBeat.o(43826);
    }

    public void onDestroy() {
        AppMethodBeat.i(43827);
        bZc();
        super.onDestroy();
        AppMethodBeat.o(43827);
    }

    public final void wU(int i) {
        AppMethodBeat.i(43828);
        finish();
        AppMethodBeat.o(43828);
    }

    private void bZd() {
        AppMethodBeat.i(43829);
        com.tencent.mm.ui.base.h.a(this.mController.ylL, (int) R.string.fkw, 0, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(43803);
                MallOrderDetailInfoUI.this.finish();
                AppMethodBeat.o(43803);
            }
        });
        AppMethodBeat.o(43829);
    }

    static /* synthetic */ void b(MallOrderDetailInfoUI mallOrderDetailInfoUI) {
        AppMethodBeat.i(43831);
        com.tencent.mm.ui.base.h.d(mallOrderDetailInfoUI, "商家已退全款，总价125元，包含商品价格115元，邮费10元，请确认是否同意通过该处理结果。", mallOrderDetailInfoUI.getString(R.string.cwr), mallOrderDetailInfoUI.getString(R.string.cx7), mallOrderDetailInfoUI.getString(R.string.cx8), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(43831);
    }

    static /* synthetic */ void c(MallOrderDetailInfoUI mallOrderDetailInfoUI) {
        AppMethodBeat.i(43832);
        if (!TextUtils.isEmpty(mallOrderDetailInfoUI.pdC)) {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(mallOrderDetailInfoUI.pdC).toString()));
            intent.addFlags(268435456);
            mallOrderDetailInfoUI.startActivity(intent);
        }
        AppMethodBeat.o(43832);
    }

    static /* synthetic */ void d(MallOrderDetailInfoUI mallOrderDetailInfoUI) {
        AppMethodBeat.i(43833);
        Context context = mallOrderDetailInfoUI;
        com.tencent.mm.ui.base.h.a(context, "", new String[]{mallOrderDetailInfoUI.getString(R.string.cx9)}, "", false, new com.tencent.mm.ui.base.h.c() {
            public final void iE(int i) {
                AppMethodBeat.i(43800);
                switch (i) {
                    case 0:
                        c.aL(MallOrderDetailInfoUI.this, MallOrderDetailInfoUI.this.pcS.pbO);
                        break;
                }
                AppMethodBeat.o(43800);
            }
        });
        AppMethodBeat.o(43833);
    }
}
