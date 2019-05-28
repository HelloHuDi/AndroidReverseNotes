package com.tencent.p177mm.plugin.order.p480ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C37807uo;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p612ui.base.MMLoadMoreListView;
import com.tencent.p177mm.p612ui.base.MMLoadMoreListView.C36055a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C19405n;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C42528t;
import com.tencent.p177mm.plugin.order.model.C21421d;
import com.tencent.p177mm.plugin.order.model.C28659e;
import com.tencent.p177mm.plugin.order.model.C43362g;
import com.tencent.p177mm.plugin.order.model.C43364i;
import com.tencent.p177mm.plugin.order.p1007a.C34656a;
import com.tencent.p177mm.plugin.order.p1007a.C34657b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.order.ui.MallOrderRecordListUI */
public class MallOrderRecordListUI extends WalletBaseUI {
    /* renamed from: Lp */
    protected int f1276Lp = 0;
    public MMLoadMoreListView emT;
    protected boolean isLoading = false;
    protected int mCount = 0;
    protected C7306ak mHandler = null;
    protected Dialog msu = null;
    public boolean ocG = true;
    public C3587a pdZ = null;
    protected List<C43364i> pea = new ArrayList();
    protected String peb = null;
    public boolean pec = false;
    protected Map<String, String> ped = new HashMap();

    /* renamed from: com.tencent.mm.plugin.order.ui.MallOrderRecordListUI$1 */
    class C35811 implements OnItemClickListener {
        C35811() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(43849);
            MallOrderRecordListUI.this.mo8156AH(i);
            C36391e.m59978QS(26);
            AppMethodBeat.m2505o(43849);
        }
    }

    /* renamed from: com.tencent.mm.plugin.order.ui.MallOrderRecordListUI$2 */
    class C35822 implements OnItemLongClickListener {
        C35822() {
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, final int i, long j) {
            AppMethodBeat.m2504i(43851);
            if (i >= MallOrderRecordListUI.this.pea.size()) {
                AppMethodBeat.m2505o(43851);
            } else {
                C30379h.m48422a(MallOrderRecordListUI.this, MallOrderRecordListUI.this.getResources().getString(C25738R.string.flu), null, MallOrderRecordListUI.this.getResources().getString(C25738R.string.f9088p4), new C30391c() {
                    /* renamed from: iE */
                    public final void mo7700iE(int i) {
                        AppMethodBeat.m2504i(43850);
                        switch (i) {
                            case 0:
                                C43364i c43364i = (C43364i) MallOrderRecordListUI.this.pea.get(i);
                                if (c43364i != null) {
                                    MallOrderRecordListUI.this.mo8163fz(c43364i.pcU, c43364i.pdn);
                                    break;
                                }
                                break;
                        }
                        AppMethodBeat.m2505o(43850);
                    }
                });
                AppMethodBeat.m2505o(43851);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.order.ui.MallOrderRecordListUI$3 */
    class C35843 implements C36055a {
        C35843() {
        }

        /* renamed from: KB */
        public final void mo8166KB() {
            AppMethodBeat.m2504i(43852);
            if (!MallOrderRecordListUI.this.isLoading) {
                MallOrderRecordListUI.this.isLoading = true;
                MallOrderRecordListUI mallOrderRecordListUI = MallOrderRecordListUI.this;
                mallOrderRecordListUI.f1276Lp += 10;
                MallOrderRecordListUI.this.bZh();
            }
            AppMethodBeat.m2505o(43852);
        }
    }

    /* renamed from: com.tencent.mm.plugin.order.ui.MallOrderRecordListUI$5 */
    class C35855 implements Runnable {
        C35855() {
        }

        public final void run() {
            AppMethodBeat.m2504i(43854);
            if (MallOrderRecordListUI.this.ocG) {
                C4990ab.m7418v("MicroMsg.WalletOrderListUI", "has more");
                if (!MallOrderRecordListUI.this.pec) {
                    MallOrderRecordListUI.this.emT.dzN();
                    MallOrderRecordListUI.this.emT.setAdapter(MallOrderRecordListUI.this.pdZ);
                    MallOrderRecordListUI.this.pec = true;
                }
            } else {
                C4990ab.m7418v("MicroMsg.WalletOrderListUI", "no more! dismiss footer view!");
                MallOrderRecordListUI.this.emT.dzO();
            }
            MallOrderRecordListUI.this.pdZ.notifyDataSetChanged();
            AppMethodBeat.m2505o(43854);
        }
    }

    /* renamed from: com.tencent.mm.plugin.order.ui.MallOrderRecordListUI$6 */
    class C35866 implements Runnable {
        C35866() {
        }

        public final void run() {
            AppMethodBeat.m2504i(43855);
            MallOrderRecordListUI.this.pdZ.notifyDataSetChanged();
            AppMethodBeat.m2505o(43855);
        }
    }

    /* renamed from: com.tencent.mm.plugin.order.ui.MallOrderRecordListUI$a */
    public class C3587a extends BaseAdapter {
        protected C3587a() {
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(43859);
            C43364i AJ = m5943AJ(i);
            AppMethodBeat.m2505o(43859);
            return AJ;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(43856);
            int size = MallOrderRecordListUI.this.pea.size();
            AppMethodBeat.m2505o(43856);
            return size;
        }

        /* renamed from: AJ */
        private C43364i m5943AJ(int i) {
            AppMethodBeat.m2504i(43857);
            C43364i c43364i = (C43364i) MallOrderRecordListUI.this.pea.get(i);
            AppMethodBeat.m2505o(43857);
            return c43364i;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C3588b c3588b;
            String eS;
            AppMethodBeat.m2504i(43858);
            if (view == null) {
                view = View.inflate(MallOrderRecordListUI.this, 2130970054, null);
                c3588b = new C3588b(MallOrderRecordListUI.this, (byte) 0);
                c3588b.peg = (TextView) view.findViewById(2131825837);
                c3588b.pei = (TextView) view.findViewById(2131825839);
                c3588b.peh = (TextView) view.findViewById(2131825838);
                c3588b.pej = (TextView) view.findViewById(2131825841);
                c3588b.pel = view.findViewById(2131825834);
                c3588b.pem = (TextView) view.findViewById(2131825835);
                c3588b.pen = (TextView) view.findViewById(2131825836);
                c3588b.pek = (TextView) view.findViewById(2131825840);
                view.setTag(c3588b);
            } else {
                c3588b = (C3588b) view.getTag();
            }
            C43364i AJ = m5943AJ(i);
            Object obj = null;
            if (i == 0) {
                obj = 1;
                C43364i AJ2 = m5943AJ(0);
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.setTimeInMillis(((long) AJ2.pcX) * 1000);
                eS = MallOrderRecordListUI.m5934eS(gregorianCalendar.get(1), gregorianCalendar.get(2) + 1);
            } else {
                C43364i AJ3 = m5943AJ(i);
                C43364i AJ4 = m5943AJ(i - 1);
                if (AJ3.pcX > 0 && AJ4.pcX > 0) {
                    GregorianCalendar gregorianCalendar2 = new GregorianCalendar();
                    gregorianCalendar2.setTimeInMillis(((long) AJ4.pcX) * 1000);
                    GregorianCalendar gregorianCalendar3 = new GregorianCalendar();
                    gregorianCalendar3.setTimeInMillis(((long) AJ3.pcX) * 1000);
                    if (!(gregorianCalendar2.get(1) == gregorianCalendar3.get(1) && gregorianCalendar2.get(2) == gregorianCalendar3.get(2))) {
                        obj = 1;
                        eS = MallOrderRecordListUI.m5934eS(gregorianCalendar3.get(1), gregorianCalendar3.get(2) + 1);
                    }
                }
                eS = null;
            }
            if (obj != null) {
                c3588b.pem.setText(new SimpleDateFormat(MallOrderRecordListUI.this.getString(C25738R.string.bz3, new Object[]{""})).format(new Date(((long) m5943AJ(i).pcX) * 1000)));
                if (!(C5046bo.isNullOrNil(eS) || C5046bo.isNullOrNil((String) MallOrderRecordListUI.this.ped.get(eS)))) {
                    c3588b.pen.setText((CharSequence) MallOrderRecordListUI.this.ped.get(eS));
                }
                c3588b.pel.setVisibility(0);
            } else {
                c3588b.pel.setVisibility(8);
            }
            c3588b.peg.setText(AJ.pcW);
            c3588b.peh.setText(AJ.pcY);
            int color = MallOrderRecordListUI.this.mController.ylL.getResources().getColor(C25738R.color.f12168uo);
            if (!C5046bo.isNullOrNil(AJ.pdk)) {
                try {
                    color = Color.parseColor(AJ.pdk);
                } catch (Exception e) {
                    C4990ab.m7420w("MicroMsg.WalletOrderListUI", "Parse color exp. colortext=" + C5046bo.nullAsNil(AJ.pdk));
                }
            }
            c3588b.peh.setTextColor(color);
            c3588b.pei.setText(MallOrderRecordListUI.this.mo8157AI(AJ.pcX));
            color = MallOrderRecordListUI.this.mController.ylL.getResources().getColor(C25738R.color.f12170uq);
            if (!C5046bo.isNullOrNil(AJ.pdl)) {
                try {
                    color = Color.parseColor(AJ.pdl);
                } catch (Exception e2) {
                    C4990ab.m7420w("MicroMsg.WalletOrderListUI", "Parse color exp. colortext=" + C5046bo.nullAsNil(AJ.pdl));
                }
            }
            if (AJ.pcV != AJ.pdm) {
                eS = C36391e.m60006e(AJ.pcV / 100.0d, AJ.pda);
                SpannableString spannableString = new SpannableString(eS);
                spannableString.setSpan(new StrikethroughSpan(), 0, eS.length(), 33);
                c3588b.pej.setText(spannableString);
            } else {
                c3588b.pej.setText("");
            }
            c3588b.pek.setTextColor(color);
            c3588b.pek.setText(C36391e.m60006e(AJ.pdm / 100.0d, AJ.pda));
            AppMethodBeat.m2505o(43858);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.plugin.order.ui.MallOrderRecordListUI$b */
    class C3588b {
        TextView peg;
        TextView peh;
        TextView pei;
        TextView pej;
        TextView pek;
        View pel;
        TextView pem;
        TextView pen;

        private C3588b() {
        }

        /* synthetic */ C3588b(MallOrderRecordListUI mallOrderRecordListUI, byte b) {
            this();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public MallOrderRecordListUI() {
        AppMethodBeat.m2504i(43860);
        AppMethodBeat.m2505o(43860);
    }

    /* renamed from: eS */
    static /* synthetic */ String m5934eS(int i, int i2) {
        AppMethodBeat.m2504i(43876);
        String eR = MallOrderRecordListUI.m5933eR(i, i2);
        AppMethodBeat.m2505o(43876);
        return eR;
    }

    public final int getLayoutId() {
        return 2130970053;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(43861);
        super.onCreate(bundle);
        this.mHandler = new C7306ak();
        bZf();
        initView();
        this.f1276Lp = 0;
        this.peb = null;
        AppMethodBeat.m2505o(43861);
    }

    /* Access modifiers changed, original: protected */
    public void bZf() {
        AppMethodBeat.m2504i(43862);
        mo39992nf(C19405n.CTRL_INDEX);
        mo39992nf(C42528t.CTRL_INDEX);
        AppMethodBeat.m2505o(43862);
    }

    /* Access modifiers changed, original: protected */
    public void bZg() {
        AppMethodBeat.m2504i(43863);
        mo39993ng(C19405n.CTRL_INDEX);
        mo39993ng(C42528t.CTRL_INDEX);
        AppMethodBeat.m2505o(43863);
    }

    public void onResume() {
        AppMethodBeat.m2504i(43864);
        super.onResume();
        if (this.pdZ != null) {
            this.pdZ.notifyDataSetChanged();
        }
        AppMethodBeat.m2505o(43864);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: fz */
    public void mo8163fz(String str, String str2) {
        AppMethodBeat.m2504i(43865);
        mo39970a(new C43362g(str, str2), true, true);
        AppMethodBeat.m2505o(43865);
    }

    /* Access modifiers changed, original: protected */
    public void bZh() {
        AppMethodBeat.m2504i(43866);
        mo39970a(new C28659e(this.f1276Lp, this.peb), true, true);
        AppMethodBeat.m2505o(43866);
    }

    public final void initView() {
        AppMethodBeat.m2504i(43867);
        if (C24143a.m37112aE(this) instanceof C34656a) {
            this.isLoading = true;
            bZh();
        }
        setMMTitle((int) C25738R.string.cwm);
        this.emT = (MMLoadMoreListView) findViewById(2131825832);
        this.pdZ = new C3587a();
        this.emT.setAdapter(this.pdZ);
        this.emT.setOnItemClickListener(new C35811());
        this.emT.setOnItemLongClickListener(new C35822());
        this.emT.setOnLoadMoreListener(new C35843());
        final C37807uo c37807uo = new C37807uo();
        c37807uo.cQJ.cQL = "6";
        c37807uo.callback = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(43853);
                if (C5046bo.isNullOrNil(c37807uo.cQK.cQM)) {
                    C4990ab.m7416i("MicroMsg.WalletOrderListUI", "no bulletin data");
                    AppMethodBeat.m2505o(43853);
                    return;
                }
                C36391e.m59985a((TextView) MallOrderRecordListUI.this.findViewById(2131821634), c37807uo.cQK.cQM, c37807uo.cQK.content, c37807uo.cQK.url);
                AppMethodBeat.m2505o(43853);
            }
        };
        C4879a.xxA.mo10055m(c37807uo);
        C34657b.bYR().aVU();
        this.pdZ.notifyDataSetChanged();
        C7060h c7060h = C7060h.pYm;
        Object[] objArr = new Object[1];
        C34657b.bYR();
        objArr[0] = Integer.valueOf(C34657b.bYU().bYZ());
        c7060h.mo8381e(11036, objArr);
        AppMethodBeat.m2505o(43867);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: AH */
    public final void mo8156AH(int i) {
        AppMethodBeat.m2504i(43868);
        if (i >= this.pea.size()) {
            AppMethodBeat.m2505o(43868);
            return;
        }
        C43364i c43364i = (C43364i) this.pea.get(i);
        if (c43364i != null) {
            Bundle bundle = this.mBundle;
            bundle.putString("key_trans_id", c43364i.pcU);
            bundle.putInt("key_pay_type", c43364i.pdc);
            bundle.putString("bill_id", c43364i.pdn);
            C24143a.m37116j(this, bundle);
        }
        AppMethodBeat.m2505o(43868);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: cw */
    public final void mo8161cw(List<C43364i> list) {
        AppMethodBeat.m2504i(43869);
        if (list == null || list.size() == 0) {
            AppMethodBeat.m2505o(43869);
            return;
        }
        if (this.pea == null) {
            this.pea = new ArrayList();
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                C43364i c43364i = (C43364i) list.get(i2);
                if (!m5932Uy(c43364i.pcU)) {
                    this.pea.add(c43364i);
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(43869);
                return;
            }
        }
    }

    /* renamed from: Uy */
    private boolean m5932Uy(String str) {
        AppMethodBeat.m2504i(43870);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(43870);
            return false;
        }
        int i = 0;
        while (i < this.pea.size()) {
            C43364i c43364i = (C43364i) this.pea.get(i);
            if (c43364i == null || !str.equals(c43364i.pcU)) {
                i++;
            } else {
                AppMethodBeat.m2505o(43870);
                return true;
            }
        }
        AppMethodBeat.m2505o(43870);
        return false;
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(43871);
        bZg();
        super.onDestroy();
        AppMethodBeat.m2505o(43871);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: AI */
    public String mo8157AI(int i) {
        AppMethodBeat.m2504i(43872);
        String QR = C36391e.m59977QR(i);
        AppMethodBeat.m2505o(43872);
        return QR;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: cx */
    public final void mo8162cx(List<C21421d> list) {
        AppMethodBeat.m2504i(43873);
        if (list == null) {
            AppMethodBeat.m2505o(43873);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                C21421d c21421d = (C21421d) list.get(i2);
                if (c21421d != null) {
                    this.ped.put(MallOrderRecordListUI.m5933eR(c21421d.year, c21421d.month), c21421d.pcO);
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(43873);
                return;
            }
        }
    }

    /* renamed from: eR */
    private static String m5933eR(int i, int i2) {
        AppMethodBeat.m2504i(43874);
        String str = i + "-" + i2;
        AppMethodBeat.m2505o(43874);
        return str;
    }

    /* renamed from: c */
    public boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(43875);
        if (c1207m instanceof C28659e) {
            if (this.msu != null) {
                this.msu.dismiss();
                this.msu = null;
            }
            C28659e c28659e = (C28659e) c1207m;
            this.peb = c28659e.pcR;
            mo8161cw(c28659e.pcP);
            mo8162cx(c28659e.pcQ);
            this.mCount = this.pea.size();
            this.ocG = c28659e.kCd > this.mCount;
            this.pdZ.notifyDataSetChanged();
            C4990ab.m7410d("MicroMsg.WalletOrderListUI", "orders list count: " + this.mCount);
            C4990ab.m7410d("MicroMsg.WalletOrderListUI", "orders list total record: " + c28659e.kCd);
            C4990ab.m7410d("MicroMsg.WalletOrderListUI", "orders list has more: " + this.ocG);
            this.mHandler.post(new C35855());
            this.isLoading = false;
        } else if (c1207m instanceof C43362g) {
            if (this.msu != null) {
                this.msu.dismiss();
                this.msu = null;
            }
            C43362g c43362g = (C43362g) c1207m;
            if (c43362g.bZa() == 2) {
                if (this.pea != null) {
                    this.pea.clear();
                }
                this.mCount = 0;
                this.ocG = false;
                this.emT.dzO();
            } else {
                String bZb = c43362g.bZb();
                C4990ab.m7410d("MicroMsg.WalletOrderListUI", "delete transId:".concat(String.valueOf(bZb)));
                if (!C5046bo.isNullOrNil(bZb)) {
                    for (C43364i c43364i : this.pea) {
                        if (bZb.equals(c43364i.pcU)) {
                            this.pea.remove(c43364i);
                            this.mCount = this.pea.size();
                            break;
                        }
                    }
                }
            }
            this.mHandler.post(new C35866());
        }
        if (this.mCount > 0 || this.pea.size() != 0) {
            showOptionMenu(true);
            findViewById(2131825833).setVisibility(8);
        } else {
            showOptionMenu(false);
            findViewById(2131825833).setVisibility(0);
        }
        AppMethodBeat.m2505o(43875);
        return true;
    }
}
