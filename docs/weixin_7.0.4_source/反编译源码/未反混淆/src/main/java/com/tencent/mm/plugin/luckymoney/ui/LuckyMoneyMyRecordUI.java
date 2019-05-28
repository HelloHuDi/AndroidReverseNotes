package com.tencent.mm.plugin.luckymoney.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.luckymoney.model.ai;
import com.tencent.mm.plugin.luckymoney.model.aj;
import com.tencent.mm.plugin.luckymoney.model.q;
import com.tencent.mm.plugin.luckymoney.model.r;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LuckyMoneyMyRecordUI extends LuckyMoneyBaseUI {
    private int Lp = 0;
    private View gwR;
    private boolean hZu = false;
    private ImageView kEn;
    private TextView kFs;
    private int mType;
    private TextView nSD;
    private List<r> nSx = new LinkedList();
    public String nYT = "";
    private boolean ocG = true;
    private Map<String, Integer> ocN = new HashMap();
    public String ocP = "";
    private MMLoadMoreListView odn;
    private e odo;
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

    class a extends BaseAdapter {
        int biG;
        List<String> ofa;

        a() {
        }

        public final int getCount() {
            AppMethodBeat.i(42766);
            int size = this.ofa.size();
            AppMethodBeat.o(42766);
            return size;
        }

        public final String getItem(int i) {
            AppMethodBeat.i(42767);
            String str = (String) this.ofa.get(i);
            AppMethodBeat.o(42767);
            return str;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(42768);
            CheckedTextView checkedTextView = (CheckedTextView) LayoutInflater.from(LuckyMoneyMyRecordUI.this.mController.ylL).inflate(R.layout.b4p, viewGroup, false);
            checkedTextView.setText(getItem(i));
            if (i == this.biG) {
                checkedTextView.setChecked(true);
            } else {
                checkedTextView.setChecked(false);
            }
            AppMethodBeat.o(42768);
            return checkedTextView;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LuckyMoneyMyRecordUI() {
        AppMethodBeat.i(42770);
        AppMethodBeat.o(42770);
    }

    static /* synthetic */ void c(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI) {
        AppMethodBeat.i(42778);
        luckyMoneyMyRecordUI.bMB();
        AppMethodBeat.o(42778);
    }

    static /* synthetic */ void d(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI) {
        AppMethodBeat.i(42779);
        luckyMoneyMyRecordUI.bMr();
        AppMethodBeat.o(42779);
    }

    static /* synthetic */ int e(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI) {
        AppMethodBeat.i(42780);
        int bMC = luckyMoneyMyRecordUI.bMC();
        AppMethodBeat.o(42780);
        return bMC;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(42771);
        super.onCreate(bundle);
        xE(getResources().getColor(R.color.u8));
        Nc(getResources().getColor(R.color.tt));
        this.mType = getIntent().getIntExtra("key_type", 2);
        initView();
        bMr();
        h.pYm.e(11701, Integer.valueOf(bMC()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
        AppMethodBeat.o(42771);
    }

    public final void initView() {
        AppMethodBeat.i(42772);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(42755);
                LuckyMoneyMyRecordUI.this.finish();
                AppMethodBeat.o(42755);
                return true;
            }
        });
        addIconOptionMenu(0, R.raw.actionbar_icon_dark_more, new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(42758);
                d dVar = new d(LuckyMoneyMyRecordUI.this.mController.ylL, 1, false);
                dVar.rBl = new c() {
                    public final void a(l lVar) {
                        AppMethodBeat.i(42756);
                        lVar.hi(1, R.string.crm);
                        lVar.hi(2, R.string.cro);
                        AppMethodBeat.o(42756);
                    }
                };
                dVar.rBm = new n.d() {
                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.i(42757);
                        switch (menuItem.getItemId()) {
                            case 1:
                                if (LuckyMoneyMyRecordUI.this.mType != 2) {
                                    LuckyMoneyMyRecordUI.this.mType = 2;
                                    LuckyMoneyMyRecordUI.b(LuckyMoneyMyRecordUI.this);
                                    LuckyMoneyMyRecordUI.c(LuckyMoneyMyRecordUI.this);
                                    LuckyMoneyMyRecordUI.d(LuckyMoneyMyRecordUI.this);
                                    AppMethodBeat.o(42757);
                                    return;
                                }
                                break;
                            case 2:
                                if (LuckyMoneyMyRecordUI.this.mType != 1) {
                                    LuckyMoneyMyRecordUI.this.mType = 1;
                                    LuckyMoneyMyRecordUI.b(LuckyMoneyMyRecordUI.this);
                                    LuckyMoneyMyRecordUI.c(LuckyMoneyMyRecordUI.this);
                                    LuckyMoneyMyRecordUI.d(LuckyMoneyMyRecordUI.this);
                                    break;
                                }
                                break;
                        }
                        AppMethodBeat.o(42757);
                    }
                };
                dVar.cpD();
                AppMethodBeat.o(42758);
                return false;
            }
        });
        this.kFs = (TextView) findViewById(R.id.cxg);
        this.odn = (MMLoadMoreListView) findViewById(R.id.cxf);
        this.gwR = LayoutInflater.from(this).inflate(R.layout.aa_, null);
        this.odn.addHeaderView(this.gwR);
        this.kEn = (ImageView) this.gwR.findViewById(R.id.cx3);
        this.oeR = (TextView) this.gwR.findViewById(R.id.cx4);
        this.nSD = (TextView) this.gwR.findViewById(R.id.cx5);
        this.oeS = (TextView) this.gwR.findViewById(R.id.cx7);
        this.oeT = (TextView) this.gwR.findViewById(R.id.cx8);
        this.oeU = (TextView) this.gwR.findViewById(R.id.cx9);
        this.oeV = (TextView) this.gwR.findViewById(R.id.cx_);
        this.oeW = (TextView) this.gwR.findViewById(R.id.cx1);
        this.oeX = (TextView) this.gwR.findViewById(R.id.cxa);
        this.odn.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 3;
                AppMethodBeat.i(42759);
                int i3 = (int) j;
                h.pYm.e(11701, Integer.valueOf(LuckyMoneyMyRecordUI.e(LuckyMoneyMyRecordUI.this)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2));
                if (i3 >= 0 && i3 < LuckyMoneyMyRecordUI.this.odo.getCount()) {
                    r yb = LuckyMoneyMyRecordUI.this.odo.getItem(i3);
                    if (!(yb == null || bo.isNullOrNil(yb.nSX))) {
                        Intent intent = new Intent();
                        if (yb.nXi == 2) {
                            ab.d("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go busi detail");
                            intent.setClass(LuckyMoneyMyRecordUI.this.mController.ylL, LuckyMoneyBusiDetailUI.class);
                        } else {
                            ab.d("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go normal detail");
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
                AppMethodBeat.o(42759);
            }
        });
        this.odn.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(42761);
                if (i <= 0 || i > LuckyMoneyMyRecordUI.this.odo.getCount()) {
                    AppMethodBeat.o(42761);
                } else {
                    final int i2 = i - 1;
                    com.tencent.mm.ui.base.h.a(LuckyMoneyMyRecordUI.this, LuckyMoneyMyRecordUI.this.getResources().getString(R.string.crf), null, LuckyMoneyMyRecordUI.this.getResources().getString(R.string.p4), new com.tencent.mm.ui.base.h.c() {
                        public final void iE(int i) {
                            AppMethodBeat.i(42760);
                            switch (i) {
                                case 0:
                                    r yb = LuckyMoneyMyRecordUI.this.odo.getItem(i2);
                                    if (yb != null) {
                                        LuckyMoneyMyRecordUI.this.oeZ = i2;
                                        LuckyMoneyMyRecordUI.a(LuckyMoneyMyRecordUI.this, yb, i2);
                                        break;
                                    }
                                    break;
                            }
                            AppMethodBeat.o(42760);
                        }
                    });
                    AppMethodBeat.o(42761);
                }
                return true;
            }
        });
        this.odn.setOnLoadMoreListener(new com.tencent.mm.ui.base.MMLoadMoreListView.a() {
            public final void KB() {
                AppMethodBeat.i(42762);
                if (!LuckyMoneyMyRecordUI.this.ocz.bLA()) {
                    LuckyMoneyMyRecordUI.this.hZu = false;
                }
                if (LuckyMoneyMyRecordUI.this.ocG && !LuckyMoneyMyRecordUI.this.hZu) {
                    LuckyMoneyMyRecordUI.d(LuckyMoneyMyRecordUI.this);
                }
                AppMethodBeat.o(42762);
            }
        });
        this.kEn.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(42763);
                if (bo.isNullOrNil(LuckyMoneyMyRecordUI.this.nYT)) {
                    ab.w("MicroMsg.LuckyMoneyMyRecordUI", "hy: no avatar jump h5");
                    AppMethodBeat.o(42763);
                    return;
                }
                e.n(LuckyMoneyMyRecordUI.this, LuckyMoneyMyRecordUI.this.nYT, true);
                AppMethodBeat.o(42763);
            }
        });
        bMB();
        AppMethodBeat.o(42772);
    }

    private void bMB() {
        AppMethodBeat.i(42773);
        this.oeX.setVisibility(8);
        this.gwR.findViewById(R.id.cx6).setVisibility(8);
        if (this.mType == 1) {
            setMMTitle(getString(R.string.cro));
            x.a(this.mController.ylL, this.oeR, getString(R.string.ct1, new Object[]{com.tencent.mm.model.r.YB()}));
            this.oeT.setText(R.string.ct7);
            this.odo = new f(this.mController.ylL);
            this.oeX.setVisibility(0);
        } else {
            setMMTitle(getString(R.string.crm));
            x.a(this.mController.ylL, this.oeR, getString(R.string.cso, new Object[]{com.tencent.mm.model.r.YB()}));
            this.oeT.setText(R.string.csp);
            this.odo = new d(this.mController.ylL);
            this.gwR.findViewById(R.id.cx6).setVisibility(0);
        }
        this.odn.setAdapter(this.odo);
        b.a(this.kEn, com.tencent.mm.model.r.Yz(), 0.0f, false);
        this.oeW.setText(getString(R.string.csq, new Object[]{bo.nullAsNil(this.oeY)}));
        AppMethodBeat.o(42773);
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(42774);
        int i3;
        r rVar;
        if (mVar instanceof ai) {
            if (i == 0 && i2 == 0) {
                ai aiVar = (ai) mVar;
                LinkedList linkedList = aiVar.nYQ.nXj;
                this.ocP = aiVar.nYz;
                this.nYT = aiVar.nYT;
                if (this.Lp == 0) {
                    this.ofa = aiVar.nYR;
                    this.oeY = aiVar.nYS;
                    View findViewById = findViewById(R.id.cx0);
                    ImageView imageView = (ImageView) findViewById(R.id.cx2);
                    if (this.ofa.size() > 1) {
                        imageView.setVisibility(0);
                        findViewById.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.i(42764);
                                LuckyMoneyMyRecordUI.this.showDialog(1);
                                AppMethodBeat.o(42764);
                            }
                        });
                    }
                    this.oeW.setText(getString(R.string.csq, new Object[]{this.oeY}));
                }
                q qVar = aiVar.nYQ;
                if (qVar != null) {
                    if (this.mType == 1) {
                        this.nSD.setText(e.F(((double) qVar.nXK) / 100.0d));
                        String str2 = qVar.nXJ;
                        String string = getString(R.string.ct6, new Object[]{str2});
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getResources().getColor(R.color.tr));
                        int indexOf = string.indexOf(str2);
                        SpannableString spannableString = new SpannableString(string);
                        spannableString.setSpan(foregroundColorSpan, indexOf, str2.length() + indexOf, 33);
                        this.oeX.setText(spannableString);
                    } else {
                        this.nSD.setText(e.F(((double) qVar.nXI) / 100.0d));
                        this.oeS.setText(qVar.nXH);
                        this.oeU.setText(qVar.mLA);
                    }
                }
                if (linkedList != null) {
                    i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= linkedList.size()) {
                            break;
                        }
                        rVar = (r) linkedList.get(i4);
                        if (!this.ocN.containsKey(rVar.nSX)) {
                            this.nSx.add(linkedList.get(i4));
                            this.ocN.put(rVar.nSX, Integer.valueOf(1));
                        }
                        i3 = i4 + 1;
                    }
                    this.Lp += linkedList.size();
                    this.ocG = aiVar.bLF();
                    this.hZu = false;
                    this.odo.ck(this.nSx);
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
                AppMethodBeat.o(42774);
                return true;
            }
            this.nYT = null;
        } else if (mVar instanceof aj) {
            i3 = this.oeZ;
            this.oeZ = -1;
            if (i == 0 && i2 == 0) {
                rVar = this.odo.getItem(i3);
                if (rVar != null) {
                    Toast.makeText(this, R.string.crg, 0).show();
                    this.odo.a(rVar);
                    this.odo.notifyDataSetChanged();
                } else {
                    ab.e("MicroMsg.LuckyMoneyMyRecordUI", "can't found local record");
                }
                AppMethodBeat.o(42774);
                return true;
            }
        }
        AppMethodBeat.o(42774);
        return false;
    }

    public final int getLayoutId() {
        return R.layout.aab;
    }

    private void bMr() {
        AppMethodBeat.i(42775);
        this.hZu = true;
        if (this.Lp == 0) {
            this.ocP = "";
        }
        n(new ai(11, this.Lp, this.mType, this.oeY, "v1.0", this.ocP));
        AppMethodBeat.o(42775);
    }

    private int bMC() {
        if (this.mType == 1) {
            return 8;
        }
        return 9;
    }

    /* Access modifiers changed, original: protected|synthetic */
    public /* synthetic */ Dialog onCreateDialog(int i) {
        AppMethodBeat.i(42776);
        switch (i) {
            case 1:
                View inflate = LayoutInflater.from(this).inflate(R.layout.aap, null);
                ListViewInScrollView listViewInScrollView = (ListViewInScrollView) inflate.findViewById(R.id.d0n);
                final a aVar = new a();
                List list = this.ofa;
                if (list == null) {
                    aVar.ofa = new ArrayList();
                } else {
                    aVar.ofa = list;
                }
                aVar.notifyDataSetChanged();
                aVar.biG = 0;
                listViewInScrollView.setAdapter(aVar);
                listViewInScrollView.setOnItemClickListener(new OnItemClickListener() {
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        AppMethodBeat.i(42765);
                        LuckyMoneyMyRecordUI.this.dismissDialog(1);
                        String item = aVar.getItem(i);
                        aVar.biG = i;
                        if (!item.equals(LuckyMoneyMyRecordUI.this.oeY)) {
                            LuckyMoneyMyRecordUI.this.oeY = item;
                            LuckyMoneyMyRecordUI.this.oeW.setText(LuckyMoneyMyRecordUI.this.getString(R.string.csq, new Object[]{LuckyMoneyMyRecordUI.this.oeY}));
                            LuckyMoneyMyRecordUI.this.Lp = 0;
                            LuckyMoneyMyRecordUI.this.nSx.clear();
                            LuckyMoneyMyRecordUI.this.ocN.clear();
                            LuckyMoneyMyRecordUI.d(LuckyMoneyMyRecordUI.this);
                        }
                        h.pYm.e(11701, Integer.valueOf(LuckyMoneyMyRecordUI.e(LuckyMoneyMyRecordUI.this)), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), item);
                        AppMethodBeat.o(42765);
                    }
                });
                com.tencent.mm.ui.widget.a.c.a aVar2 = new com.tencent.mm.ui.widget.a.c.a(this);
                aVar2.PV(R.string.ct0);
                aVar2.fn(inflate);
                aVar2.f(null);
                Dialog aMb = aVar2.aMb();
                AppMethodBeat.o(42776);
                return aMb;
            default:
                AppMethodBeat.o(42776);
                return null;
        }
    }

    static /* synthetic */ void b(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI) {
        AppMethodBeat.i(42777);
        if (luckyMoneyMyRecordUI.nSx != null) {
            luckyMoneyMyRecordUI.nSx.clear();
        }
        if (luckyMoneyMyRecordUI.ocN != null) {
            luckyMoneyMyRecordUI.ocN.clear();
        }
        luckyMoneyMyRecordUI.Lp = 0;
        AppMethodBeat.o(42777);
    }

    static /* synthetic */ void a(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI, r rVar, int i) {
        AppMethodBeat.i(42781);
        if (rVar == null || i < 0 || i > luckyMoneyMyRecordUI.odo.getCount()) {
            ab.e("MicroMsg.LuckyMoneyMyRecordUI", "param is illegal");
            AppMethodBeat.o(42781);
            return;
        }
        luckyMoneyMyRecordUI.n(new aj(rVar.nSX, rVar.nWX, luckyMoneyMyRecordUI.mType, i, "v1.0"));
        AppMethodBeat.o(42781);
    }
}
