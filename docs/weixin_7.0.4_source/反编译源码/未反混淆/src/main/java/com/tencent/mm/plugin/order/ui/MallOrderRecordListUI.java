package com.tencent.mm.plugin.order.ui;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.uo;
import com.tencent.mm.plugin.appbrand.jsapi.k.n;
import com.tencent.mm.plugin.appbrand.jsapi.k.t;
import com.tencent.mm.plugin.order.model.d;
import com.tencent.mm.plugin.order.model.g;
import com.tencent.mm.plugin.order.model.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MallOrderRecordListUI extends WalletBaseUI {
    protected int Lp = 0;
    public MMLoadMoreListView emT;
    protected boolean isLoading = false;
    protected int mCount = 0;
    protected ak mHandler = null;
    protected Dialog msu = null;
    public boolean ocG = true;
    public a pdZ = null;
    protected List<i> pea = new ArrayList();
    protected String peb = null;
    public boolean pec = false;
    protected Map<String, String> ped = new HashMap();

    public class a extends BaseAdapter {
        protected a() {
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(43859);
            i AJ = AJ(i);
            AppMethodBeat.o(43859);
            return AJ;
        }

        public final int getCount() {
            AppMethodBeat.i(43856);
            int size = MallOrderRecordListUI.this.pea.size();
            AppMethodBeat.o(43856);
            return size;
        }

        private i AJ(int i) {
            AppMethodBeat.i(43857);
            i iVar = (i) MallOrderRecordListUI.this.pea.get(i);
            AppMethodBeat.o(43857);
            return iVar;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            String eS;
            AppMethodBeat.i(43858);
            if (view == null) {
                view = View.inflate(MallOrderRecordListUI.this, R.layout.ac5, null);
                bVar = new b(MallOrderRecordListUI.this, (byte) 0);
                bVar.peg = (TextView) view.findViewById(R.id.d53);
                bVar.pei = (TextView) view.findViewById(R.id.d55);
                bVar.peh = (TextView) view.findViewById(R.id.d54);
                bVar.pej = (TextView) view.findViewById(R.id.d57);
                bVar.pel = view.findViewById(R.id.d50);
                bVar.pem = (TextView) view.findViewById(R.id.d51);
                bVar.pen = (TextView) view.findViewById(R.id.d52);
                bVar.pek = (TextView) view.findViewById(R.id.d56);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            i AJ = AJ(i);
            Object obj = null;
            if (i == 0) {
                obj = 1;
                i AJ2 = AJ(0);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.setTimeInMillis(((long) AJ2.pcX) * 1000);
                eS = MallOrderRecordListUI.eS(gregorianCalendar.get(1), gregorianCalendar.get(2) + 1);
            } else {
                i AJ3 = AJ(i);
                i AJ4 = AJ(i - 1);
                if (AJ3.pcX > 0 && AJ4.pcX > 0) {
                    GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
                    gregorianCalendar2.setTimeInMillis(((long) AJ4.pcX) * 1000);
                    GregorianCalendar gregorianCalendar3 = new GregorianCalendar();
                    gregorianCalendar3.setTimeInMillis(((long) AJ3.pcX) * 1000);
                    if (!(gregorianCalendar2.get(1) == gregorianCalendar3.get(1) && gregorianCalendar2.get(2) == gregorianCalendar3.get(2))) {
                        obj = 1;
                        eS = MallOrderRecordListUI.eS(gregorianCalendar3.get(1), gregorianCalendar3.get(2) + 1);
                    }
                }
                eS = null;
            }
            if (obj != null) {
                bVar.pem.setText(new SimpleDateFormat(MallOrderRecordListUI.this.getString(R.string.bz3, new Object[]{""})).format(new Date(((long) AJ(i).pcX) * 1000)));
                if (!(bo.isNullOrNil(eS) || bo.isNullOrNil((String) MallOrderRecordListUI.this.ped.get(eS)))) {
                    bVar.pen.setText((CharSequence) MallOrderRecordListUI.this.ped.get(eS));
                }
                bVar.pel.setVisibility(0);
            } else {
                bVar.pel.setVisibility(8);
            }
            bVar.peg.setText(AJ.pcW);
            bVar.peh.setText(AJ.pcY);
            int color = MallOrderRecordListUI.this.mController.ylL.getResources().getColor(R.color.uo);
            if (!bo.isNullOrNil(AJ.pdk)) {
                try {
                    color = Color.parseColor(AJ.pdk);
                } catch (Exception e) {
                    ab.w("MicroMsg.WalletOrderListUI", "Parse color exp. colortext=" + bo.nullAsNil(AJ.pdk));
                }
            }
            bVar.peh.setTextColor(color);
            bVar.pei.setText(MallOrderRecordListUI.this.AI(AJ.pcX));
            color = MallOrderRecordListUI.this.mController.ylL.getResources().getColor(R.color.uq);
            if (!bo.isNullOrNil(AJ.pdl)) {
                try {
                    color = Color.parseColor(AJ.pdl);
                } catch (Exception e2) {
                    ab.w("MicroMsg.WalletOrderListUI", "Parse color exp. colortext=" + bo.nullAsNil(AJ.pdl));
                }
            }
            if (AJ.pcV != AJ.pdm) {
                eS = e.e(AJ.pcV / 100.0d, AJ.pda);
                SpannableString spannableString = new SpannableString(eS);
                spannableString.setSpan(new StrikethroughSpan(), 0, eS.length(), 33);
                bVar.pej.setText(spannableString);
            } else {
                bVar.pej.setText("");
            }
            bVar.pek.setTextColor(color);
            bVar.pek.setText(e.e(AJ.pdm / 100.0d, AJ.pda));
            AppMethodBeat.o(43858);
            return view;
        }
    }

    class b {
        TextView peg;
        TextView peh;
        TextView pei;
        TextView pej;
        TextView pek;
        View pel;
        TextView pem;
        TextView pen;

        private b() {
        }

        /* synthetic */ b(MallOrderRecordListUI mallOrderRecordListUI, byte b) {
            this();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public MallOrderRecordListUI() {
        AppMethodBeat.i(43860);
        AppMethodBeat.o(43860);
    }

    static /* synthetic */ String eS(int i, int i2) {
        AppMethodBeat.i(43876);
        String eR = eR(i, i2);
        AppMethodBeat.o(43876);
        return eR;
    }

    public final int getLayoutId() {
        return R.layout.ac4;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(43861);
        super.onCreate(bundle);
        this.mHandler = new ak();
        bZf();
        initView();
        this.Lp = 0;
        this.peb = null;
        AppMethodBeat.o(43861);
    }

    /* Access modifiers changed, original: protected */
    public void bZf() {
        AppMethodBeat.i(43862);
        nf(n.CTRL_INDEX);
        nf(t.CTRL_INDEX);
        AppMethodBeat.o(43862);
    }

    /* Access modifiers changed, original: protected */
    public void bZg() {
        AppMethodBeat.i(43863);
        ng(n.CTRL_INDEX);
        ng(t.CTRL_INDEX);
        AppMethodBeat.o(43863);
    }

    public void onResume() {
        AppMethodBeat.i(43864);
        super.onResume();
        if (this.pdZ != null) {
            this.pdZ.notifyDataSetChanged();
        }
        AppMethodBeat.o(43864);
    }

    /* Access modifiers changed, original: protected */
    public void fz(String str, String str2) {
        AppMethodBeat.i(43865);
        a(new g(str, str2), true, true);
        AppMethodBeat.o(43865);
    }

    /* Access modifiers changed, original: protected */
    public void bZh() {
        AppMethodBeat.i(43866);
        a(new com.tencent.mm.plugin.order.model.e(this.Lp, this.peb), true, true);
        AppMethodBeat.o(43866);
    }

    public final void initView() {
        AppMethodBeat.i(43867);
        if (com.tencent.mm.wallet_core.a.aE(this) instanceof com.tencent.mm.plugin.order.a.a) {
            this.isLoading = true;
            bZh();
        }
        setMMTitle((int) R.string.cwm);
        this.emT = (MMLoadMoreListView) findViewById(R.id.d4y);
        this.pdZ = new a();
        this.emT.setAdapter(this.pdZ);
        this.emT.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(43849);
                MallOrderRecordListUI.this.AH(i);
                e.QS(26);
                AppMethodBeat.o(43849);
            }
        });
        this.emT.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
                AppMethodBeat.i(43851);
                if (i >= MallOrderRecordListUI.this.pea.size()) {
                    AppMethodBeat.o(43851);
                } else {
                    h.a(MallOrderRecordListUI.this, MallOrderRecordListUI.this.getResources().getString(R.string.flu), null, MallOrderRecordListUI.this.getResources().getString(R.string.p4), new c() {
                        public final void iE(int i) {
                            AppMethodBeat.i(43850);
                            switch (i) {
                                case 0:
                                    i iVar = (i) MallOrderRecordListUI.this.pea.get(i);
                                    if (iVar != null) {
                                        MallOrderRecordListUI.this.fz(iVar.pcU, iVar.pdn);
                                        break;
                                    }
                                    break;
                            }
                            AppMethodBeat.o(43850);
                        }
                    });
                    AppMethodBeat.o(43851);
                }
                return true;
            }
        });
        this.emT.setOnLoadMoreListener(new com.tencent.mm.ui.base.MMLoadMoreListView.a() {
            public final void KB() {
                AppMethodBeat.i(43852);
                if (!MallOrderRecordListUI.this.isLoading) {
                    MallOrderRecordListUI.this.isLoading = true;
                    MallOrderRecordListUI mallOrderRecordListUI = MallOrderRecordListUI.this;
                    mallOrderRecordListUI.Lp += 10;
                    MallOrderRecordListUI.this.bZh();
                }
                AppMethodBeat.o(43852);
            }
        });
        final uo uoVar = new uo();
        uoVar.cQJ.cQL = "6";
        uoVar.callback = new Runnable() {
            public final void run() {
                AppMethodBeat.i(43853);
                if (bo.isNullOrNil(uoVar.cQK.cQM)) {
                    ab.i("MicroMsg.WalletOrderListUI", "no bulletin data");
                    AppMethodBeat.o(43853);
                    return;
                }
                e.a((TextView) MallOrderRecordListUI.this.findViewById(R.id.a2f), uoVar.cQK.cQM, uoVar.cQK.content, uoVar.cQK.url);
                AppMethodBeat.o(43853);
            }
        };
        com.tencent.mm.sdk.b.a.xxA.m(uoVar);
        com.tencent.mm.plugin.order.a.b.bYR().aVU();
        this.pdZ.notifyDataSetChanged();
        com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
        Object[] objArr = new Object[1];
        com.tencent.mm.plugin.order.a.b.bYR();
        objArr[0] = Integer.valueOf(com.tencent.mm.plugin.order.a.b.bYU().bYZ());
        hVar.e(11036, objArr);
        AppMethodBeat.o(43867);
    }

    /* Access modifiers changed, original: protected|final */
    public final void AH(int i) {
        AppMethodBeat.i(43868);
        if (i >= this.pea.size()) {
            AppMethodBeat.o(43868);
            return;
        }
        i iVar = (i) this.pea.get(i);
        if (iVar != null) {
            Bundle bundle = this.mBundle;
            bundle.putString("key_trans_id", iVar.pcU);
            bundle.putInt("key_pay_type", iVar.pdc);
            bundle.putString("bill_id", iVar.pdn);
            com.tencent.mm.wallet_core.a.j(this, bundle);
        }
        AppMethodBeat.o(43868);
    }

    /* Access modifiers changed, original: protected|final */
    public final void cw(List<i> list) {
        AppMethodBeat.i(43869);
        if (list == null || list.size() == 0) {
            AppMethodBeat.o(43869);
            return;
        }
        if (this.pea == null) {
            this.pea = new ArrayList();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                i iVar = (i) list.get(i2);
                if (!Uy(iVar.pcU)) {
                    this.pea.add(iVar);
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(43869);
                return;
            }
        }
    }

    private boolean Uy(String str) {
        AppMethodBeat.i(43870);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(43870);
            return false;
        }
        int i = 0;
        while (i < this.pea.size()) {
            i iVar = (i) this.pea.get(i);
            if (iVar == null || !str.equals(iVar.pcU)) {
                i++;
            } else {
                AppMethodBeat.o(43870);
                return true;
            }
        }
        AppMethodBeat.o(43870);
        return false;
    }

    public void onDestroy() {
        AppMethodBeat.i(43871);
        bZg();
        super.onDestroy();
        AppMethodBeat.o(43871);
    }

    /* Access modifiers changed, original: protected */
    public String AI(int i) {
        AppMethodBeat.i(43872);
        String QR = e.QR(i);
        AppMethodBeat.o(43872);
        return QR;
    }

    /* Access modifiers changed, original: protected|final */
    public final void cx(List<d> list) {
        AppMethodBeat.i(43873);
        if (list == null) {
            AppMethodBeat.o(43873);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                d dVar = (d) list.get(i2);
                if (dVar != null) {
                    this.ped.put(eR(dVar.year, dVar.month), dVar.pcO);
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(43873);
                return;
            }
        }
    }

    private static String eR(int i, int i2) {
        AppMethodBeat.i(43874);
        String str = i + "-" + i2;
        AppMethodBeat.o(43874);
        return str;
    }

    public boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(43875);
        if (mVar instanceof com.tencent.mm.plugin.order.model.e) {
            if (this.msu != null) {
                this.msu.dismiss();
                this.msu = null;
            }
            com.tencent.mm.plugin.order.model.e eVar = (com.tencent.mm.plugin.order.model.e) mVar;
            this.peb = eVar.pcR;
            cw(eVar.pcP);
            cx(eVar.pcQ);
            this.mCount = this.pea.size();
            this.ocG = eVar.kCd > this.mCount;
            this.pdZ.notifyDataSetChanged();
            ab.d("MicroMsg.WalletOrderListUI", "orders list count: " + this.mCount);
            ab.d("MicroMsg.WalletOrderListUI", "orders list total record: " + eVar.kCd);
            ab.d("MicroMsg.WalletOrderListUI", "orders list has more: " + this.ocG);
            this.mHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(43854);
                    if (MallOrderRecordListUI.this.ocG) {
                        ab.v("MicroMsg.WalletOrderListUI", "has more");
                        if (!MallOrderRecordListUI.this.pec) {
                            MallOrderRecordListUI.this.emT.dzN();
                            MallOrderRecordListUI.this.emT.setAdapter(MallOrderRecordListUI.this.pdZ);
                            MallOrderRecordListUI.this.pec = true;
                        }
                    } else {
                        ab.v("MicroMsg.WalletOrderListUI", "no more! dismiss footer view!");
                        MallOrderRecordListUI.this.emT.dzO();
                    }
                    MallOrderRecordListUI.this.pdZ.notifyDataSetChanged();
                    AppMethodBeat.o(43854);
                }
            });
            this.isLoading = false;
        } else if (mVar instanceof g) {
            if (this.msu != null) {
                this.msu.dismiss();
                this.msu = null;
            }
            g gVar = (g) mVar;
            if (gVar.bZa() == 2) {
                if (this.pea != null) {
                    this.pea.clear();
                }
                this.mCount = 0;
                this.ocG = false;
                this.emT.dzO();
            } else {
                String bZb = gVar.bZb();
                ab.d("MicroMsg.WalletOrderListUI", "delete transId:".concat(String.valueOf(bZb)));
                if (!bo.isNullOrNil(bZb)) {
                    for (i iVar : this.pea) {
                        if (bZb.equals(iVar.pcU)) {
                            this.pea.remove(iVar);
                            this.mCount = this.pea.size();
                            break;
                        }
                    }
                }
            }
            this.mHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(43855);
                    MallOrderRecordListUI.this.pdZ.notifyDataSetChanged();
                    AppMethodBeat.o(43855);
                }
            });
        }
        if (this.mCount > 0 || this.pea.size() != 0) {
            showOptionMenu(true);
            findViewById(R.id.d4z).setVisibility(8);
        } else {
            showOptionMenu(false);
            findViewById(R.id.d4z).setVisibility(0);
        }
        AppMethodBeat.o(43875);
        return true;
    }
}
