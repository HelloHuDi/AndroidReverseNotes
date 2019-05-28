package com.tencent.p177mm.plugin.luckymoney.p449ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.ListViewInScrollView;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30391c;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.MMLoadMoreListView;
import com.tencent.p177mm.p612ui.base.MMLoadMoreListView.C36055a;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.plugin.luckymoney.model.C21205q;
import com.tencent.p177mm.plugin.luckymoney.model.C21206r;
import com.tencent.p177mm.plugin.luckymoney.model.C3383ai;
import com.tencent.p177mm.plugin.luckymoney.model.C46058aj;
import com.tencent.p177mm.plugin.luckymoney.model.C46063x;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI */
public class LuckyMoneyMyRecordUI extends LuckyMoneyBaseUI {
    /* renamed from: Lp */
    private int f17208Lp = 0;
    private View gwR;
    private boolean hZu = false;
    private ImageView kEn;
    private TextView kFs;
    private int mType;
    private TextView nSD;
    private List<C21206r> nSx = new LinkedList();
    public String nYT = "";
    private boolean ocG = true;
    private Map<String, Integer> ocN = new HashMap();
    public String ocP = "";
    private MMLoadMoreListView odn;
    private C39343e odo;
    private TextView oeR;
    private TextView oeS;
    private TextView oeT;
    private TextView oeU;
    private TextView oeV;
    private TextView oeW;
    private TextView oeX;
    private String oeY;
    private int oeZ = -1;
    public List<String> ofa = new ArrayList();

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI$2 */
    class C34102 implements OnMenuItemClickListener {

        /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI$2$1 */
        class C34111 implements C36073c {
            C34111() {
            }

            /* renamed from: a */
            public final void mo5746a(C44273l c44273l) {
                AppMethodBeat.m2504i(42756);
                c44273l.mo70072hi(1, C25738R.string.crm);
                c44273l.mo70072hi(2, C25738R.string.cro);
                AppMethodBeat.m2505o(42756);
            }
        }

        /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI$2$2 */
        class C34122 implements C5279d {
            C34122() {
            }

            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(42757);
                switch (menuItem.getItemId()) {
                    case 1:
                        if (LuckyMoneyMyRecordUI.this.mType != 2) {
                            LuckyMoneyMyRecordUI.this.mType = 2;
                            LuckyMoneyMyRecordUI.m77038b(LuckyMoneyMyRecordUI.this);
                            LuckyMoneyMyRecordUI.m77039c(LuckyMoneyMyRecordUI.this);
                            LuckyMoneyMyRecordUI.m77040d(LuckyMoneyMyRecordUI.this);
                            AppMethodBeat.m2505o(42757);
                            return;
                        }
                        break;
                    case 2:
                        if (LuckyMoneyMyRecordUI.this.mType != 1) {
                            LuckyMoneyMyRecordUI.this.mType = 1;
                            LuckyMoneyMyRecordUI.m77038b(LuckyMoneyMyRecordUI.this);
                            LuckyMoneyMyRecordUI.m77039c(LuckyMoneyMyRecordUI.this);
                            LuckyMoneyMyRecordUI.m77040d(LuckyMoneyMyRecordUI.this);
                            break;
                        }
                        break;
                }
                AppMethodBeat.m2505o(42757);
            }
        }

        C34102() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(42758);
            C36356d c36356d = new C36356d(LuckyMoneyMyRecordUI.this.mController.ylL, 1, false);
            c36356d.rBl = new C34111();
            c36356d.rBm = new C34122();
            c36356d.cpD();
            AppMethodBeat.m2505o(42758);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI$3 */
    class C34133 implements OnItemClickListener {
        C34133() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            int i2 = 3;
            AppMethodBeat.m2504i(42759);
            int i3 = (int) j;
            C7060h.pYm.mo8381e(11701, Integer.valueOf(LuckyMoneyMyRecordUI.m77041e(LuckyMoneyMyRecordUI.this)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2));
            if (i3 >= 0 && i3 < LuckyMoneyMyRecordUI.this.odo.getCount()) {
                C21206r yb = LuckyMoneyMyRecordUI.this.odo.getItem(i3);
                if (!(yb == null || C5046bo.isNullOrNil(yb.nSX))) {
                    Intent intent = new Intent();
                    if (yb.nXi == 2) {
                        C4990ab.m7410d("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go busi detail");
                        intent.setClass(LuckyMoneyMyRecordUI.this.mController.ylL, LuckyMoneyBusiDetailUI.class);
                    } else {
                        C4990ab.m7410d("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go normal detail");
                        intent.setClass(LuckyMoneyMyRecordUI.this.mController.ylL, LuckyMoneyBeforeDetailUI.class);
                    }
                    intent.putExtra("key_sendid", yb.nSX);
                    if (LuckyMoneyMyRecordUI.this.mType != 1) {
                        i2 = 1;
                    }
                    intent.putExtra("key_jump_from", i2);
                    LuckyMoneyMyRecordUI.this.startActivity(intent);
                }
            }
            AppMethodBeat.m2505o(42759);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI$4 */
    class C34144 implements OnItemLongClickListener {
        C34144() {
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(42761);
            if (i <= 0 || i > LuckyMoneyMyRecordUI.this.odo.getCount()) {
                AppMethodBeat.m2505o(42761);
            } else {
                final int i2 = i - 1;
                C30379h.m48422a(LuckyMoneyMyRecordUI.this, LuckyMoneyMyRecordUI.this.getResources().getString(C25738R.string.crf), null, LuckyMoneyMyRecordUI.this.getResources().getString(C25738R.string.f9088p4), new C30391c() {
                    /* renamed from: iE */
                    public final void mo7700iE(int i) {
                        AppMethodBeat.m2504i(42760);
                        switch (i) {
                            case 0:
                                C21206r yb = LuckyMoneyMyRecordUI.this.odo.getItem(i2);
                                if (yb != null) {
                                    LuckyMoneyMyRecordUI.this.oeZ = i2;
                                    LuckyMoneyMyRecordUI.m77036a(LuckyMoneyMyRecordUI.this, yb, i2);
                                    break;
                                }
                                break;
                        }
                        AppMethodBeat.m2505o(42760);
                    }
                });
                AppMethodBeat.m2505o(42761);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI$6 */
    class C34166 implements OnClickListener {
        C34166() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42763);
            if (C5046bo.isNullOrNil(LuckyMoneyMyRecordUI.this.nYT)) {
                C4990ab.m7420w("MicroMsg.LuckyMoneyMyRecordUI", "hy: no avatar jump h5");
                AppMethodBeat.m2505o(42763);
                return;
            }
            C36391e.m60016n(LuckyMoneyMyRecordUI.this, LuckyMoneyMyRecordUI.this.nYT, true);
            AppMethodBeat.m2505o(42763);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI$a */
    class C3417a extends BaseAdapter {
        int biG;
        List<String> ofa;

        C3417a() {
        }

        public final int getCount() {
            AppMethodBeat.m2504i(42766);
            int size = this.ofa.size();
            AppMethodBeat.m2505o(42766);
            return size;
        }

        public final String getItem(int i) {
            AppMethodBeat.m2504i(42767);
            String str = (String) this.ofa.get(i);
            AppMethodBeat.m2505o(42767);
            return str;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.m2504i(42768);
            CheckedTextView checkedTextView = (CheckedTextView) LayoutInflater.from(LuckyMoneyMyRecordUI.this.mController.ylL).inflate(2130971115, viewGroup, false);
            checkedTextView.setText(getItem(i));
            if (i == this.biG) {
                checkedTextView.setChecked(true);
            } else {
                checkedTextView.setChecked(false);
            }
            AppMethodBeat.m2505o(42768);
            return checkedTextView;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI$5 */
    class C212245 implements C36055a {
        C212245() {
        }

        /* renamed from: KB */
        public final void mo8166KB() {
            AppMethodBeat.m2504i(42762);
            if (!LuckyMoneyMyRecordUI.this.ocz.bLA()) {
                LuckyMoneyMyRecordUI.this.hZu = false;
            }
            if (LuckyMoneyMyRecordUI.this.ocG && !LuckyMoneyMyRecordUI.this.hZu) {
                LuckyMoneyMyRecordUI.m77040d(LuckyMoneyMyRecordUI.this);
            }
            AppMethodBeat.m2505o(42762);
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI$1 */
    class C344781 implements OnMenuItemClickListener {
        C344781() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(42755);
            LuckyMoneyMyRecordUI.this.finish();
            AppMethodBeat.m2505o(42755);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI$7 */
    class C344797 implements OnClickListener {
        C344797() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(42764);
            LuckyMoneyMyRecordUI.this.showDialog(1);
            AppMethodBeat.m2505o(42764);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public LuckyMoneyMyRecordUI() {
        AppMethodBeat.m2504i(42770);
        AppMethodBeat.m2505o(42770);
    }

    /* renamed from: c */
    static /* synthetic */ void m77039c(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI) {
        AppMethodBeat.m2504i(42778);
        luckyMoneyMyRecordUI.bMB();
        AppMethodBeat.m2505o(42778);
    }

    /* renamed from: d */
    static /* synthetic */ void m77040d(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI) {
        AppMethodBeat.m2504i(42779);
        luckyMoneyMyRecordUI.bMr();
        AppMethodBeat.m2505o(42779);
    }

    /* renamed from: e */
    static /* synthetic */ int m77041e(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI) {
        AppMethodBeat.m2504i(42780);
        int bMC = luckyMoneyMyRecordUI.bMC();
        AppMethodBeat.m2505o(42780);
        return bMC;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(42771);
        super.onCreate(bundle);
        mo17446xE(getResources().getColor(C25738R.color.f12153u8));
        mo17373Nc(getResources().getColor(C25738R.color.f12140tt));
        this.mType = getIntent().getIntExtra("key_type", 2);
        initView();
        bMr();
        C7060h.pYm.mo8381e(11701, Integer.valueOf(bMC()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
        AppMethodBeat.m2505o(42771);
    }

    public final void initView() {
        AppMethodBeat.m2504i(42772);
        setBackBtn(new C344781());
        addIconOptionMenu(0, C1318a.actionbar_icon_dark_more, new C34102());
        this.kFs = (TextView) findViewById(2131825555);
        this.odn = (MMLoadMoreListView) findViewById(2131825554);
        this.gwR = LayoutInflater.from(this).inflate(2130969985, null);
        this.odn.addHeaderView(this.gwR);
        this.kEn = (ImageView) this.gwR.findViewById(2131825541);
        this.oeR = (TextView) this.gwR.findViewById(2131825542);
        this.nSD = (TextView) this.gwR.findViewById(2131825543);
        this.oeS = (TextView) this.gwR.findViewById(2131825545);
        this.oeT = (TextView) this.gwR.findViewById(2131825546);
        this.oeU = (TextView) this.gwR.findViewById(2131825547);
        this.oeV = (TextView) this.gwR.findViewById(2131825548);
        this.oeW = (TextView) this.gwR.findViewById(2131825539);
        this.oeX = (TextView) this.gwR.findViewById(2131825549);
        this.odn.setOnItemClickListener(new C34133());
        this.odn.setOnItemLongClickListener(new C34144());
        this.odn.setOnLoadMoreListener(new C212245());
        this.kEn.setOnClickListener(new C34166());
        bMB();
        AppMethodBeat.m2505o(42772);
    }

    private void bMB() {
        AppMethodBeat.m2504i(42773);
        this.oeX.setVisibility(8);
        this.gwR.findViewById(2131825544).setVisibility(8);
        if (this.mType == 1) {
            setMMTitle(getString(C25738R.string.cro));
            C46063x.m85800a(this.mController.ylL, this.oeR, getString(C25738R.string.ct1, new Object[]{C1853r.m3820YB()}));
            this.oeT.setText(C25738R.string.ct7);
            this.odo = new C34505f(this.mController.ylL);
            this.oeX.setVisibility(0);
        } else {
            setMMTitle(getString(C25738R.string.crm));
            C46063x.m85800a(this.mController.ylL, this.oeR, getString(C25738R.string.cso, new Object[]{C1853r.m3820YB()}));
            this.oeT.setText(C25738R.string.csp);
            this.odo = new C46065d(this.mController.ylL);
            this.gwR.findViewById(2131825544).setVisibility(0);
        }
        this.odn.setAdapter(this.odo);
        C40460b.m69433a(this.kEn, C1853r.m3846Yz(), 0.0f, false);
        this.oeW.setText(getString(C25738R.string.csq, new Object[]{C5046bo.nullAsNil(this.oeY)}));
        AppMethodBeat.m2505o(42773);
    }

    /* renamed from: c */
    public final boolean mo7808c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(42774);
        int i3;
        C21206r c21206r;
        if (c1207m instanceof C3383ai) {
            if (i == 0 && i2 == 0) {
                C3383ai c3383ai = (C3383ai) c1207m;
                LinkedList linkedList = c3383ai.nYQ.nXj;
                this.ocP = c3383ai.nYz;
                this.nYT = c3383ai.nYT;
                if (this.f17208Lp == 0) {
                    this.ofa = c3383ai.nYR;
                    this.oeY = c3383ai.nYS;
                    View findViewById = findViewById(2131825538);
                    ImageView imageView = (ImageView) findViewById(2131825540);
                    if (this.ofa.size() > 1) {
                        imageView.setVisibility(0);
                        findViewById.setOnClickListener(new C344797());
                    }
                    this.oeW.setText(getString(C25738R.string.csq, new Object[]{this.oeY}));
                }
                C21205q c21205q = c3383ai.nYQ;
                if (c21205q != null) {
                    if (this.mType == 1) {
                        this.nSD.setText(C36391e.m59971F(((double) c21205q.nXK) / 100.0d));
                        String str2 = c21205q.nXJ;
                        String string = getString(C25738R.string.ct6, new Object[]{str2});
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getResources().getColor(C25738R.color.f12139tr));
                        int indexOf = string.indexOf(str2);
                        SpannableString spannableString = new SpannableString(string);
                        spannableString.setSpan(foregroundColorSpan, indexOf, str2.length() + indexOf, 33);
                        this.oeX.setText(spannableString);
                    } else {
                        this.nSD.setText(C36391e.m59971F(((double) c21205q.nXI) / 100.0d));
                        this.oeS.setText(c21205q.nXH);
                        this.oeU.setText(c21205q.mLA);
                    }
                }
                if (linkedList != null) {
                    i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= linkedList.size()) {
                            break;
                        }
                        c21206r = (C21206r) linkedList.get(i4);
                        if (!this.ocN.containsKey(c21206r.nSX)) {
                            this.nSx.add(linkedList.get(i4));
                            this.ocN.put(c21206r.nSX, Integer.valueOf(1));
                        }
                        i3 = i4 + 1;
                    }
                    this.f17208Lp += linkedList.size();
                    this.ocG = c3383ai.bLF();
                    this.hZu = false;
                    this.odo.mo62229ck(this.nSx);
                }
                if (this.nSx == null || this.nSx.size() == 0) {
                    this.kFs.setVisibility(0);
                } else {
                    this.kFs.setVisibility(8);
                }
                if (this.ocG) {
                    this.odn.dzN();
                } else {
                    this.odn.dzO();
                }
                AppMethodBeat.m2505o(42774);
                return true;
            }
            this.nYT = null;
        } else if (c1207m instanceof C46058aj) {
            i3 = this.oeZ;
            this.oeZ = -1;
            if (i == 0 && i2 == 0) {
                c21206r = this.odo.getItem(i3);
                if (c21206r != null) {
                    Toast.makeText(this, C25738R.string.crg, 0).show();
                    this.odo.mo62228a(c21206r);
                    this.odo.notifyDataSetChanged();
                } else {
                    C4990ab.m7412e("MicroMsg.LuckyMoneyMyRecordUI", "can't found local record");
                }
                AppMethodBeat.m2505o(42774);
                return true;
            }
        }
        AppMethodBeat.m2505o(42774);
        return false;
    }

    public final int getLayoutId() {
        return 2130969987;
    }

    private void bMr() {
        AppMethodBeat.m2504i(42775);
        this.hZu = true;
        if (this.f17208Lp == 0) {
            this.ocP = "";
        }
        mo24304n(new C3383ai(11, this.f17208Lp, this.mType, this.oeY, "v1.0", this.ocP));
        AppMethodBeat.m2505o(42775);
    }

    private int bMC() {
        if (this.mType == 1) {
            return 8;
        }
        return 9;
    }

    /* Access modifiers changed, original: protected|synthetic */
    public /* synthetic */ Dialog onCreateDialog(int i) {
        AppMethodBeat.m2504i(42776);
        switch (i) {
            case 1:
                View inflate = LayoutInflater.from(this).inflate(2130970001, null);
                ListViewInScrollView listViewInScrollView = (ListViewInScrollView) inflate.findViewById(2131825673);
                final C3417a c3417a = new C3417a();
                List list = this.ofa;
                if (list == null) {
                    c3417a.ofa = new ArrayList();
                } else {
                    c3417a.ofa = list;
                }
                c3417a.notifyDataSetChanged();
                c3417a.biG = 0;
                listViewInScrollView.setAdapter(c3417a);
                listViewInScrollView.setOnItemClickListener(new OnItemClickListener() {
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        AppMethodBeat.m2504i(42765);
                        LuckyMoneyMyRecordUI.this.dismissDialog(1);
                        String item = c3417a.getItem(i);
                        c3417a.biG = i;
                        if (!item.equals(LuckyMoneyMyRecordUI.this.oeY)) {
                            LuckyMoneyMyRecordUI.this.oeY = item;
                            LuckyMoneyMyRecordUI.this.oeW.setText(LuckyMoneyMyRecordUI.this.getString(C25738R.string.csq, new Object[]{LuckyMoneyMyRecordUI.this.oeY}));
                            LuckyMoneyMyRecordUI.this.f17208Lp = 0;
                            LuckyMoneyMyRecordUI.this.nSx.clear();
                            LuckyMoneyMyRecordUI.this.ocN.clear();
                            LuckyMoneyMyRecordUI.m77040d(LuckyMoneyMyRecordUI.this);
                        }
                        C7060h.pYm.mo8381e(11701, Integer.valueOf(LuckyMoneyMyRecordUI.m77041e(LuckyMoneyMyRecordUI.this)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), item);
                        AppMethodBeat.m2505o(42765);
                    }
                });
                C5652a c5652a = new C5652a(this);
                c5652a.mo11446PV(C25738R.string.ct0);
                c5652a.mo11479fn(inflate);
                c5652a.mo11478f(null);
                Dialog aMb = c5652a.aMb();
                AppMethodBeat.m2505o(42776);
                return aMb;
            default:
                AppMethodBeat.m2505o(42776);
                return null;
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m77038b(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI) {
        AppMethodBeat.m2504i(42777);
        if (luckyMoneyMyRecordUI.nSx != null) {
            luckyMoneyMyRecordUI.nSx.clear();
        }
        if (luckyMoneyMyRecordUI.ocN != null) {
            luckyMoneyMyRecordUI.ocN.clear();
        }
        luckyMoneyMyRecordUI.f17208Lp = 0;
        AppMethodBeat.m2505o(42777);
    }

    /* renamed from: a */
    static /* synthetic */ void m77036a(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI, C21206r c21206r, int i) {
        AppMethodBeat.m2504i(42781);
        if (c21206r == null || i < 0 || i > luckyMoneyMyRecordUI.odo.getCount()) {
            C4990ab.m7412e("MicroMsg.LuckyMoneyMyRecordUI", "param is illegal");
            AppMethodBeat.m2505o(42781);
            return;
        }
        luckyMoneyMyRecordUI.mo24304n(new C46058aj(c21206r.nSX, c21206r.nWX, luckyMoneyMyRecordUI.mType, i, "v1.0"));
        AppMethodBeat.m2505o(42781);
    }
}
