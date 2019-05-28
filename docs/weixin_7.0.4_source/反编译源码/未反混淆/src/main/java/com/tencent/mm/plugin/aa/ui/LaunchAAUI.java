package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.aa.a.a;
import com.tencent.mm.plugin.aa.a.c.e;
import com.tencent.mm.plugin.aa.a.d;
import com.tencent.mm.plugin.aa.a.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.ui.applet.q;
import com.tencent.mm.pluginsdk.ui.e.m;
import com.tencent.mm.pluginsdk.wallet.b;
import com.tencent.mm.protocal.protobuf.j;
import com.tencent.mm.protocal.protobuf.y;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LaunchAAUI extends BaseAAPresenterActivity {
    private String chatroomName = null;
    private TextView gng;
    private Dialog gnn;
    private e goH = ((e) V(e.class));
    private boolean goI = false;
    private MMEditText goJ;
    private TextView goK;
    private TextView goL;
    private TextView goM;
    private TextView goN;
    private WalletFormView goO;
    private TextView goP;
    private TextView goQ;
    private ViewGroup goR;
    private ViewGroup goS;
    private List<String> goT = new ArrayList();
    private ViewGroup goU;
    private ViewGroup goV;
    private TextView goW;
    private ViewGroup goX;
    private Map<String, Double> goY = new HashMap();
    private Map<String, LaunchAAByPersonNameAmountRow> goZ = new HashMap();
    private boolean gor = false;
    private Button gpa;
    private TextView gpb;
    private TextView gpc;
    private d gpd = new d();
    private int gpe = 0;
    private int gpf = 0;
    private boolean gpg = false;
    private String gph;
    private String gpi;
    private int mode = a.gkU;
    private long timestamp = 0;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public LaunchAAUI() {
        AppMethodBeat.i(40842);
        AppMethodBeat.o(40842);
    }

    static /* synthetic */ void c(LaunchAAUI launchAAUI) {
        AppMethodBeat.i(40855);
        launchAAUI.aoH();
        AppMethodBeat.o(40855);
    }

    static /* synthetic */ void g(LaunchAAUI launchAAUI) {
        AppMethodBeat.i(40858);
        launchAAUI.aoI();
        AppMethodBeat.o(40858);
    }

    static /* synthetic */ void h(LaunchAAUI launchAAUI) {
        AppMethodBeat.i(40859);
        launchAAUI.aoK();
        AppMethodBeat.o(40859);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0308  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x032a  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0257  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0283  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(Bundle bundle) {
        SpannableString spannableString;
        List arrayList;
        AppMethodBeat.i(40843);
        super.onCreate(bundle);
        ab.i("MicroMsg.LaunchAAUI", "LaunchAAUI onCreate");
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(40824);
                LaunchAAUI.this.finish();
                AppMethodBeat.o(40824);
                return false;
            }
        });
        this.timestamp = System.currentTimeMillis() / 1000;
        setMMTitle((int) R.string.cm5);
        f.dMn().c(this.goH.gmL).f(new com.tencent.mm.vending.c.a<Void, d>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(40839);
                d dVar = (d) obj;
                ab.i("MicroMsg.LaunchAAUI", "fetch operation data finish");
                if (dVar != null) {
                    LaunchAAUI.this.gpd = dVar;
                    if (!(bo.isNullOrNil(LaunchAAUI.this.gpd.glD) || bo.isNullOrNil(LaunchAAUI.this.gpd.glC))) {
                        LaunchAAUI.a(LaunchAAUI.this, LaunchAAUI.this.gpd.glD, LaunchAAUI.this.gpd.glC);
                    }
                }
                Void voidR = zXH;
                AppMethodBeat.o(40839);
                return voidR;
            }
        }).a((com.tencent.mm.vending.g.d.a) new com.tencent.mm.vending.g.d.a() {
            public final void bi(Object obj) {
                AppMethodBeat.i(40838);
                ab.i("MicroMsg.LaunchAAUI", "fetch operation data failed");
                AppMethodBeat.o(40838);
            }
        });
        this.chatroomName = getIntent().getStringExtra("chatroom_name");
        this.gph = getIntent().getStringExtra("amount");
        this.gpi = getIntent().getStringExtra("title");
        if (bo.isNullOrNil(this.chatroomName)) {
            ab.e("MicroMsg.LaunchAAUI", "chatroomName is null!!!");
            this.chatroomName = "";
        }
        String str = this.chatroomName;
        if (!bo.isNullOrNil(str)) {
            if (!t.kH(str)) {
                ArrayList P = bo.P(str.split(","));
                if (P != null) {
                    P.remove(r.Yz());
                    if (P.size() > 0) {
                        str = (String) P.get(0);
                    }
                }
            }
            this.chatroomName = str;
            this.gnR = findViewById(R.id.bhm);
            this.gnR.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    AppMethodBeat.i(40834);
                    LaunchAAUI.this.aoB();
                    LaunchAAUI.this.aqX();
                    AppMethodBeat.o(40834);
                    return false;
                }
            });
            this.goM = (TextView) findViewById(R.id.coi);
            this.goM.setClickable(true);
            this.goM.setOnTouchListener(new m(this));
            aoF();
            this.gpa = (Button) findViewById(R.id.cos);
            this.gpa.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(40835);
                    LaunchAAUI.a(LaunchAAUI.this);
                    AppMethodBeat.o(40835);
                }
            });
            this.gpb = (TextView) findViewById(R.id.cou);
            this.gpc = (TextView) findViewById(R.id.cot);
            this.goJ = (MMEditText) findViewById(R.id.coo);
            this.goK = (TextView) findViewById(R.id.cop);
            this.gng = (TextView) findViewById(R.id.cor);
            this.goL = (TextView) findViewById(R.id.coq);
            this.goK.setText(R.string.cll);
            this.mode = a.gkU;
            this.goN = (TextView) findViewById(R.id.ch2);
            this.goN.setClickable(true);
            this.goN.setOnTouchListener(new m());
            spannableString = new SpannableString(getString(R.string.ap7));
            spannableString.setSpan(new a(new a.a() {
                public final void aos() {
                    AppMethodBeat.i(40836);
                    LaunchAAUI.this.startActivity(new Intent(LaunchAAUI.this, AAQueryListUI.class));
                    if (LaunchAAUI.this.mode == a.gkU) {
                        h.pYm.e(13721, Integer.valueOf(5), Integer.valueOf(1));
                        AppMethodBeat.o(40836);
                        return;
                    }
                    h.pYm.e(13721, Integer.valueOf(5), Integer.valueOf(2));
                    AppMethodBeat.o(40836);
                }
            }), 0, spannableString.length(), 18);
            this.goN.setText(spannableString);
            this.goN.setVisibility(8);
            this.goJ.addTextChangedListener(new TextWatcher() {
                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void afterTextChanged(Editable editable) {
                    AppMethodBeat.i(40837);
                    LaunchAAUI.c(LaunchAAUI.this);
                    AppMethodBeat.o(40837);
                }
            });
            this.goO = (WalletFormView) findViewById(R.id.cod);
            this.goO.a(new TextWatcher() {
                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void afterTextChanged(Editable editable) {
                    AppMethodBeat.i(40826);
                    if (editable.toString().startsWith(".")) {
                        editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                    }
                    String obj = editable.toString();
                    int indexOf = obj.indexOf(".");
                    int length = obj.length();
                    if (indexOf >= 0 && length - indexOf > 3) {
                        editable.delete(indexOf + 3, length);
                    } else if (indexOf > 6) {
                        editable.delete(6, indexOf);
                    } else if (indexOf == -1 && length > 6) {
                        editable.delete(6, length);
                    }
                    double d = bo.getDouble(editable.toString(), 0.0d);
                    if (LaunchAAUI.this.goT != null && LaunchAAUI.this.goT.size() > 0) {
                        d = (d * 100.0d) / ((double) LaunchAAUI.this.goT.size());
                        LaunchAAUI.this.gpd;
                        if (d > ((double) d.aoj())) {
                            LaunchAAUI.this.gor = true;
                            h.pYm.e(13722, Integer.valueOf(2));
                            LaunchAAUI.c(LaunchAAUI.this);
                            LaunchAAUI.g(LaunchAAUI.this);
                            LaunchAAUI.h(LaunchAAUI.this);
                            AppMethodBeat.o(40826);
                        }
                    }
                    LaunchAAUI.this.gor = false;
                    LaunchAAUI.c(LaunchAAUI.this);
                    LaunchAAUI.g(LaunchAAUI.this);
                    LaunchAAUI.h(LaunchAAUI.this);
                    AppMethodBeat.o(40826);
                }
            });
            a(this.goO, 2, false, false);
            this.goQ = (TextView) findViewById(R.id.col);
            this.goP = (TextView) findViewById(R.id.cok);
            if (t.kH(this.chatroomName)) {
                ab.i("MicroMsg.LaunchAAUI", "is single chat: %s", this.chatroomName);
                arrayList = new ArrayList();
                arrayList.add(r.Yz());
                arrayList.add(this.chatroomName);
            } else {
                arrayList = com.tencent.mm.plugin.aa.a.h.vE(this.chatroomName);
            }
            this.goT = arrayList;
            if (this.goT.size() <= d.aoi()) {
                this.goT.clear();
                this.goQ.setText(getString(R.string.dbc));
                aoH();
            } else if (t.kH(this.chatroomName)) {
                this.goQ.setText(getString(R.string.clh, new Object[]{Integer.valueOf(arrayList.size())}));
            } else {
                this.goQ.setText(getString(R.string.clm, new Object[]{Integer.valueOf(arrayList.size())}));
            }
            this.goQ.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(40827);
                    LaunchAAUI.this.aoB();
                    LaunchAAUI.this.aqX();
                    LaunchAAUI.a(LaunchAAUI.this, arrayList);
                    AppMethodBeat.o(40827);
                }
            });
            this.goR = (ViewGroup) findViewById(R.id.coj);
            this.goS = (ViewGroup) findViewById(R.id.coc);
            this.goO.requestFocus();
            this.goI = false;
            this.goW = (TextView) findViewById(R.id.cog);
            this.goW.setText(R.string.clx);
            this.goW.setTextColor(getResources().getColor(R.color.df));
            this.goU = (ViewGroup) findViewById(R.id.coe);
            this.goV = (ViewGroup) findViewById(R.id.coh);
            this.goX = (ViewGroup) findViewById(R.id.cof);
            this.goX.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(40828);
                    LaunchAAUI.i(LaunchAAUI.this);
                    AppMethodBeat.o(40828);
                }
            });
            if (!bo.isNullOrNil(this.gpi)) {
                ab.i("MicroMsg.LaunchAAUI", "default title: %s", this.gpi);
                this.goJ.setText(this.gpi);
                this.goJ.setSelection(this.gpi.length() > 20 ? 20 : this.gpi.length());
            }
            if (!bo.isNullOrNil(this.gph)) {
                ab.i("MicroMsg.LaunchAAUI", "default amount: %s", this.gph);
                str = com.tencent.mm.wallet_core.ui.e.b(this.gph, "100", RoundingMode.HALF_UP);
                this.goO.setText(str);
                this.goO.setSelection(str.length());
            }
            aoH();
            h.pYm.e(13721, Integer.valueOf(1), Integer.valueOf(1));
            AppMethodBeat.o(40843);
        }
        str = "";
        this.chatroomName = str;
        this.gnR = findViewById(R.id.bhm);
        this.gnR.setOnTouchListener(/* anonymous class already generated */);
        this.goM = (TextView) findViewById(R.id.coi);
        this.goM.setClickable(true);
        this.goM.setOnTouchListener(new m(this));
        aoF();
        this.gpa = (Button) findViewById(R.id.cos);
        this.gpa.setOnClickListener(/* anonymous class already generated */);
        this.gpb = (TextView) findViewById(R.id.cou);
        this.gpc = (TextView) findViewById(R.id.cot);
        this.goJ = (MMEditText) findViewById(R.id.coo);
        this.goK = (TextView) findViewById(R.id.cop);
        this.gng = (TextView) findViewById(R.id.cor);
        this.goL = (TextView) findViewById(R.id.coq);
        this.goK.setText(R.string.cll);
        this.mode = a.gkU;
        this.goN = (TextView) findViewById(R.id.ch2);
        this.goN.setClickable(true);
        this.goN.setOnTouchListener(new m());
        spannableString = new SpannableString(getString(R.string.ap7));
        spannableString.setSpan(new a(/* anonymous class already generated */), 0, spannableString.length(), 18);
        this.goN.setText(spannableString);
        this.goN.setVisibility(8);
        this.goJ.addTextChangedListener(/* anonymous class already generated */);
        this.goO = (WalletFormView) findViewById(R.id.cod);
        this.goO.a(/* anonymous class already generated */);
        a(this.goO, 2, false, false);
        this.goQ = (TextView) findViewById(R.id.col);
        this.goP = (TextView) findViewById(R.id.cok);
        if (t.kH(this.chatroomName)) {
        }
        this.goT = arrayList;
        if (this.goT.size() <= d.aoi()) {
        }
        this.goQ.setOnClickListener(/* anonymous class already generated */);
        this.goR = (ViewGroup) findViewById(R.id.coj);
        this.goS = (ViewGroup) findViewById(R.id.coc);
        this.goO.requestFocus();
        this.goI = false;
        this.goW = (TextView) findViewById(R.id.cog);
        this.goW.setText(R.string.clx);
        this.goW.setTextColor(getResources().getColor(R.color.df));
        this.goU = (ViewGroup) findViewById(R.id.coe);
        this.goV = (ViewGroup) findViewById(R.id.coh);
        this.goX = (ViewGroup) findViewById(R.id.cof);
        this.goX.setOnClickListener(/* anonymous class already generated */);
        if (bo.isNullOrNil(this.gpi)) {
        }
        if (bo.isNullOrNil(this.gph)) {
        }
        aoH();
        h.pYm.e(13721, Integer.valueOf(1), Integer.valueOf(1));
        AppMethodBeat.o(40843);
    }

    public final boolean aoE() {
        return false;
    }

    private void aoF() {
        AppMethodBeat.i(40844);
        String string;
        String string2;
        SpannableStringBuilder spannableStringBuilder;
        if (this.mode == a.gkU) {
            string = getString(R.string.clj);
            string2 = getString(R.string.clk);
            spannableStringBuilder = new SpannableStringBuilder("");
            spannableStringBuilder.append(string);
            spannableStringBuilder.append(string2);
            spannableStringBuilder.setSpan(new a(new a.a() {
                public final void aos() {
                    AppMethodBeat.i(40841);
                    LaunchAAUI.e(LaunchAAUI.this);
                    AppMethodBeat.o(40841);
                }
            }), string.length(), spannableStringBuilder.length(), 18);
            this.goM.setText(spannableStringBuilder);
            AppMethodBeat.o(40844);
            return;
        }
        if (this.mode == a.gkV) {
            string = getString(R.string.clu);
            string2 = getString(R.string.clv);
            spannableStringBuilder = new SpannableStringBuilder("");
            spannableStringBuilder.append(string);
            spannableStringBuilder.append(string2);
            spannableStringBuilder.setSpan(new a(new a.a() {
                public final void aos() {
                    AppMethodBeat.i(40825);
                    LaunchAAUI.e(LaunchAAUI.this);
                    AppMethodBeat.o(40825);
                }
            }), string.length(), spannableStringBuilder.length(), 18);
            this.goM.setText(spannableStringBuilder);
        }
        AppMethodBeat.o(40844);
    }

    private void vJ(String str) {
        AppMethodBeat.i(40845);
        this.gpg = true;
        this.gpb.setVisibility(0);
        this.gpb.startAnimation(AnimationUtils.loadAnimation(this, R.anim.bh));
        this.gpb.setText(str);
        AppMethodBeat.o(40845);
    }

    private void aoG() {
        AppMethodBeat.i(40846);
        this.gpg = false;
        if (this.gpb.getVisibility() != 8) {
            this.gpb.startAnimation(AnimationUtils.loadAnimation(this, R.anim.c1));
            this.gpb.setVisibility(8);
        }
        AppMethodBeat.o(40846);
    }

    private void aoH() {
        AppMethodBeat.i(40847);
        if (this.mode == a.gkU) {
            if (bo.isNullOrNil(this.goO.getText())) {
                dg(false);
                AppMethodBeat.o(40847);
                return;
            } else if (this.gor) {
                dg(false);
                AppMethodBeat.o(40847);
                return;
            } else if (this.goT == null || this.goT.size() == 0) {
                dg(false);
                AppMethodBeat.o(40847);
                return;
            } else if (this.goT.size() > d.aoi() || this.goI) {
                dg(false);
                AppMethodBeat.o(40847);
                return;
            } else {
                ab.d("MicroMsg.LaunchAAUI", "b1: %s, b2: %s, avg: %s", this.goO.getText(), Integer.valueOf(this.goT.size()), Double.valueOf(com.tencent.mm.plugin.aa.a.h.a(this.goO.getText(), this.goT.size(), 5, 4)));
                if (com.tencent.mm.plugin.aa.a.h.a(this.goO.getText(), this.goT.size(), 5, 4) < 0.01d) {
                    ab.i("MicroMsg.LaunchAAUI", "less than 0.01");
                    dg(false);
                    AppMethodBeat.o(40847);
                    return;
                }
            }
        } else if (this.goY == null || this.goY.size() == 0) {
            dg(false);
            AppMethodBeat.o(40847);
            return;
        } else if (this.goY.size() > d.aoi() || this.goI) {
            dg(false);
            AppMethodBeat.o(40847);
            return;
        }
        dg(true);
        AppMethodBeat.o(40847);
    }

    private void dg(boolean z) {
        AppMethodBeat.i(40848);
        this.gpa.setEnabled(z);
        if (z) {
            this.goK.setTextColor(getResources().getColor(R.color.h4));
            this.gng.setTextColor(getResources().getColor(R.color.h4));
            this.goL.setTextColor(getResources().getColor(R.color.h4));
            AppMethodBeat.o(40848);
            return;
        }
        this.goK.setTextColor(getResources().getColor(R.color.dg));
        this.gng.setTextColor(getResources().getColor(R.color.dg));
        this.goL.setTextColor(getResources().getColor(R.color.dg));
        AppMethodBeat.o(40848);
    }

    private void aoI() {
        AppMethodBeat.i(40849);
        double a;
        if (this.mode == a.gkU) {
            if (this.goT == null || this.goT.size() <= 0) {
                this.gng.setText(getString(R.string.aq));
            } else {
                a = com.tencent.mm.plugin.aa.a.h.a(this.goO.getText(), this.goT.size(), 2, 2);
                this.gng.setText(getString(R.string.ao, new Object[]{Double.valueOf(a)}));
            }
            this.goK.setText(R.string.cll);
            AppMethodBeat.o(40849);
        } else if (this.goY == null || this.goY.size() == 0) {
            this.goK.setText(getString(R.string.clw, new Object[]{Integer.valueOf(0)}));
            this.gng.setText(getString(R.string.aq));
            AppMethodBeat.o(40849);
        } else {
            a = 0.0d;
            Iterator it = this.goY.values().iterator();
            while (true) {
                double d = a;
                if (it.hasNext()) {
                    a = ((Double) it.next()).doubleValue() + d;
                } else {
                    this.gng.setText(getString(R.string.ao, new Object[]{Double.valueOf(d)}));
                    this.goK.setText(getString(R.string.clw, new Object[]{Integer.valueOf(this.goY.size())}));
                    AppMethodBeat.o(40849);
                    return;
                }
            }
        }
    }

    private void aoJ() {
        AppMethodBeat.i(40850);
        ((b) g.K(b.class)).eA(7, 5);
        h.pYm.e(13721, Integer.valueOf(3), Integer.valueOf(3));
        HashMap hashMap = new HashMap();
        try {
            Object string;
            String obj = this.goJ.getText().toString();
            if (bo.isNullOrNil(obj)) {
                string = getString(R.string.clz);
            } else {
                String string2 = obj;
            }
            ArrayList arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            long j = 0;
            for (String obj2 : this.goY.keySet()) {
                double doubleValue = ((Double) this.goY.get(obj2)).doubleValue();
                j jVar = new j();
                jVar.cSh = com.tencent.mm.wallet_core.ui.e.iz(String.valueOf(doubleValue), "100");
                jVar.username = obj2;
                arrayList.add(jVar);
                long j2 = jVar.cSh + j;
                arrayList2.add(jVar.cSh);
                j = j2;
            }
            j jVar2 = new j();
            jVar2.username = r.Yz();
            jVar2.cSh = j;
            hashMap.put(k.glP, string2);
            hashMap.put(k.glQ, Long.valueOf(j));
            hashMap.put(k.glV, arrayList);
            hashMap.put(k.glT, this.chatroomName);
            hashMap.put(k.glW, Long.valueOf(this.timestamp));
            if (this.gnn != null) {
                this.gnn.dismiss();
            }
            this.gnn = com.tencent.mm.wallet_core.ui.g.b(this, false, null);
            f.cU(hashMap).c(this.goH.gmK).f(new com.tencent.mm.vending.c.a<Void, com.tencent.mm.vending.j.d<Boolean, String, Long>>() {
                public final /* synthetic */ Object call(Object obj) {
                    AppMethodBeat.i(40833);
                    ab.d("MicroMsg.LaunchAAUI", "finish launch aa, result: %s", ((com.tencent.mm.vending.j.d) obj).get(0));
                    if (LaunchAAUI.this.gnn != null) {
                        LaunchAAUI.this.gnn.dismiss();
                    }
                    if (((Boolean) r9.get(0)).booleanValue()) {
                        LaunchAAUI.l(LaunchAAUI.this);
                        Toast.makeText(LaunchAAUI.this, R.string.cm4, 1).show();
                        h.pYm.e(13722, Integer.valueOf(9));
                    } else {
                        Toast.makeText(LaunchAAUI.this, R.string.cm0, 1).show();
                        h.pYm.e(13722, Integer.valueOf(10));
                    }
                    Void voidR = zXH;
                    AppMethodBeat.o(40833);
                    return voidR;
                }
            }).a((com.tencent.mm.vending.g.d.a) new com.tencent.mm.vending.g.d.a() {
                public final void bi(Object obj) {
                    AppMethodBeat.i(40832);
                    ab.i("MicroMsg.LaunchAAUI", "onInterrupt: %s", obj);
                    if (LaunchAAUI.this.gnn != null) {
                        LaunchAAUI.this.gnn.dismiss();
                    }
                    if (obj != null && (obj instanceof String) && !obj.toString().equalsIgnoreCase("ok")) {
                        Toast.makeText(LaunchAAUI.this, obj.toString(), 1).show();
                    } else if (obj == null || !(obj instanceof y)) {
                        Toast.makeText(LaunchAAUI.this, R.string.cm0, 1).show();
                    } else {
                        com.tencent.mm.plugin.aa.a.h.a(LaunchAAUI.this.mController.ylL, (y) obj);
                    }
                    h.pYm.e(13722, Integer.valueOf(10));
                    AppMethodBeat.o(40832);
                }
            });
            h.pYm.e(13723, Integer.valueOf(2), Integer.valueOf(com.tencent.mm.plugin.aa.a.h.vE(this.chatroomName).size()), Integer.valueOf(arrayList.size() + 1), Long.valueOf(j), string2, bo.c(arrayList2, ","));
            AppMethodBeat.o(40850);
        } catch (Exception e) {
            ab.e("MicroMsg.LaunchAAUI", "launchAAByPerson error: %s", e.getMessage());
            AppMethodBeat.o(40850);
        }
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final int getLayoutId() {
        return R.layout.a9k;
    }

    public void onStop() {
        AppMethodBeat.i(40851);
        super.onStop();
        if (this.goZ != null) {
            this.goZ.clear();
        }
        AppMethodBeat.o(40851);
    }

    private void aoK() {
        AppMethodBeat.i(40852);
        if (!this.goI || this.gpg) {
            if (!this.gor || this.gpg) {
                if (!(this.goI || this.gor)) {
                    aoG();
                }
                AppMethodBeat.o(40852);
                return;
            }
            vJ(getString(R.string.cm1, new Object[]{Float.valueOf(((float) d.aoj()) / 100.0f)}));
            AppMethodBeat.o(40852);
        } else if (this.mode == a.gkU) {
            vJ(getString(R.string.clt, new Object[]{Integer.valueOf(d.aoi())}));
            AppMethodBeat.o(40852);
        } else {
            vJ(getString(R.string.clt, new Object[]{Integer.valueOf(d.aoh())}));
            AppMethodBeat.o(40852);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(40853);
        super.onActivityResult(i, i2, intent);
        String stringExtra;
        String[] split;
        if (i == com.tencent.view.d.MIC_PTU_MEISHI) {
            if (i2 == -1) {
                stringExtra = intent.getStringExtra("Select_Contact");
                if (this.mode == a.gkU) {
                    if (!bo.isNullOrNil(stringExtra)) {
                        split = stringExtra.split(",");
                        this.goT.clear();
                        this.goT.addAll(Arrays.asList(split));
                    }
                    List vE = com.tencent.mm.plugin.aa.a.h.vE(this.chatroomName);
                    TextView textView;
                    Object[] objArr;
                    if (vE == null || this.goT == null || this.goT.size() != vE.size() || !t.kH(this.chatroomName)) {
                        textView = this.goQ;
                        objArr = new Object[1];
                        objArr[0] = Integer.valueOf(this.goT != null ? this.goT.size() : 0);
                        textView.setText(getString(R.string.clm, objArr));
                    } else {
                        textView = this.goQ;
                        objArr = new Object[1];
                        objArr[0] = Integer.valueOf(this.goT != null ? this.goT.size() : 0);
                        textView.setText(getString(R.string.clh, objArr));
                    }
                }
                aoG();
                if (this.goT == null || this.goT.size() <= d.aoi()) {
                    this.goI = false;
                } else {
                    this.goI = true;
                }
                double d = bo.getDouble(this.goO.getText(), 0.0d);
                if (this.goT == null || (d * 100.0d) / ((double) this.goT.size()) <= ((double) d.aoj())) {
                    this.gor = false;
                } else {
                    this.gor = true;
                    h.pYm.e(13722, Integer.valueOf(2));
                }
                aoH();
                aoI();
                aoK();
                AppMethodBeat.o(40853);
                return;
            }
        } else if (i == 236 && i2 == -1) {
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("selectUI");
            this.goY.clear();
            if (stringArrayListExtra != null) {
                try {
                    if (stringArrayListExtra.size() > 0) {
                        Iterator it = stringArrayListExtra.iterator();
                        while (it.hasNext()) {
                            split = ((String) it.next()).split(",");
                            this.goY.put(split[0], Double.valueOf(bo.getDouble(split[1], 0.0d)));
                        }
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.LaunchAAUI", "onActivityResult, SELECT_AMOUNT_SELECT_REQUEST_CODE error: %s", e.getMessage());
                }
            }
            int dimension;
            if (this.goY == null || this.goY.size() <= 0) {
                this.goW.setText(R.string.clx);
                this.goW.setTextColor(getResources().getColor(R.color.df));
                dimension = (int) getResources().getDimension(R.dimen.oi);
                this.goX.setPadding(dimension, dimension, dimension, dimension);
                this.goX.setBackgroundResource(R.drawable.r4);
                this.goV.setVisibility(8);
            } else {
                this.goW.setText(getString(R.string.cly, new Object[]{Integer.valueOf(this.goY.size())}));
                this.goW.setTextColor(getResources().getColor(R.color.h4));
                dimension = (int) getResources().getDimension(R.dimen.oi);
                this.goX.setPadding(dimension, (int) getResources().getDimension(R.dimen.of), dimension, (int) getResources().getDimension(R.dimen.og));
                this.goX.setBackgroundResource(R.drawable.r2);
                this.goV.setVisibility(0);
            }
            this.goV.removeAllViews();
            this.goZ.clear();
            if (this.goY != null && this.goY.size() > 0) {
                int i3 = 0;
                for (String stringExtra2 : this.goY.keySet()) {
                    double doubleValue = ((Double) this.goY.get(stringExtra2)).doubleValue();
                    LaunchAAByPersonNameAmountRow launchAAByPersonNameAmountRow = new LaunchAAByPersonNameAmountRow(this);
                    if (i3 >= this.goY.size() - 1) {
                        launchAAByPersonNameAmountRow.setDividerVisible(false);
                    }
                    launchAAByPersonNameAmountRow.goa.setText(com.tencent.mm.pluginsdk.ui.e.j.b(launchAAByPersonNameAmountRow.getContext(), ((com.tencent.mm.plugin.messenger.a.b) g.K(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(stringExtra2, this.chatroomName), launchAAByPersonNameAmountRow.goa.getTextSize()));
                    launchAAByPersonNameAmountRow.gng.setText(launchAAByPersonNameAmountRow.getContext().getString(R.string.ao, new Object[]{Double.valueOf(doubleValue)}));
                    this.goV.addView(launchAAByPersonNameAmountRow);
                    this.goZ.put(stringExtra2, launchAAByPersonNameAmountRow);
                    i3++;
                }
            }
            if (this.gnR != null) {
                this.gnR.requestLayout();
            }
            this.gpf = 0;
            this.goN.post(new Runnable() {
                public final void run() {
                }
            });
            aoI();
            aoH();
            AppMethodBeat.o(40853);
            return;
        }
        AppMethodBeat.o(40853);
    }

    static /* synthetic */ void a(LaunchAAUI launchAAUI) {
        String string;
        AppMethodBeat.i(40854);
        String obj = launchAAUI.goJ.getText().toString();
        if (bo.isNullOrNil(obj)) {
            string = launchAAUI.getString(R.string.clz);
        } else {
            string = obj;
        }
        ((i) g.K(i.class)).a(launchAAUI.mController, launchAAUI.chatroomName, launchAAUI.getString(R.string.az) + string, launchAAUI.getString(R.string.ay), new q.a() {
            public final void a(boolean z, String str, int i) {
                AppMethodBeat.i(40829);
                if (z) {
                    LaunchAAUI.j(LaunchAAUI.this);
                }
                AppMethodBeat.o(40829);
            }
        });
        AppMethodBeat.o(40854);
    }

    static /* synthetic */ void a(LaunchAAUI launchAAUI, String str, final String str2) {
        AppMethodBeat.i(40856);
        launchAAUI.gpc.setVisibility(0);
        launchAAUI.gpc.startAnimation(AnimationUtils.loadAnimation(launchAAUI, R.anim.bh));
        launchAAUI.gpc.setText(str);
        launchAAUI.gpc.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(40840);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str2);
                com.tencent.mm.bp.d.b(LaunchAAUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(40840);
            }
        });
        AppMethodBeat.o(40856);
    }

    static /* synthetic */ void e(LaunchAAUI launchAAUI) {
        AppMethodBeat.i(40857);
        ab.i("MicroMsg.LaunchAAUI", "switchMode");
        launchAAUI.goI = false;
        if (launchAAUI.mode == a.gkU) {
            launchAAUI.mode = a.gkV;
            launchAAUI.goR.setVisibility(8);
            launchAAUI.goS.setVisibility(8);
            launchAAUI.goU.setVisibility(0);
            launchAAUI.goK.setText(launchAAUI.getString(R.string.clw, new Object[]{Integer.valueOf(0)}));
            if (launchAAUI.goY != null && launchAAUI.goY.size() > d.aoh()) {
                h.pYm.e(13722, Integer.valueOf(8));
                launchAAUI.goI = true;
            }
            if (launchAAUI.goI) {
                launchAAUI.vJ(launchAAUI.getString(R.string.clt, new Object[]{Integer.valueOf(d.aoh())}));
            } else {
                launchAAUI.aoG();
            }
            h.pYm.e(13721, Integer.valueOf(2), Integer.valueOf(1));
        } else {
            launchAAUI.mode = a.gkU;
            launchAAUI.goR.setVisibility(0);
            launchAAUI.goS.setVisibility(0);
            launchAAUI.goU.setVisibility(8);
            launchAAUI.goK.setText(R.string.cll);
            launchAAUI.goI = false;
            if (launchAAUI.goT.size() > d.aoi()) {
                h.pYm.e(13722, Integer.valueOf(8));
                launchAAUI.goI = true;
            }
            launchAAUI.aoK();
            h.pYm.e(13721, Integer.valueOf(3), Integer.valueOf(1));
        }
        launchAAUI.aoB();
        launchAAUI.aqX();
        launchAAUI.aoF();
        launchAAUI.aoI();
        launchAAUI.aoH();
        launchAAUI.goN.post(new Runnable() {
            public final void run() {
            }
        });
        AppMethodBeat.o(40857);
    }

    static /* synthetic */ void i(LaunchAAUI launchAAUI) {
        AppMethodBeat.i(40861);
        Intent intent = new Intent(launchAAUI, LaunchAAByPersonAmountSelectUI.class);
        intent.putExtra("chatroom", launchAAUI.chatroomName);
        intent.putExtra("maxPerAmount", d.aoj());
        if (launchAAUI.goY != null && launchAAUI.goY.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : launchAAUI.goY.keySet()) {
                arrayList.add(str + "," + ((Double) launchAAUI.goY.get(str)).doubleValue());
            }
            intent.putStringArrayListExtra("oldAmountData", arrayList);
        }
        intent.putExtra("maxUserNumber", d.aoh());
        launchAAUI.startActivityForResult(intent, 236);
        h.pYm.e(13721, Integer.valueOf(3), Integer.valueOf(2));
        AppMethodBeat.o(40861);
    }

    static /* synthetic */ void j(LaunchAAUI launchAAUI) {
        AppMethodBeat.i(40862);
        if (launchAAUI.mode != a.gkU) {
            launchAAUI.aoG();
            launchAAUI.aoJ();
        } else if (!bo.isNullOrNil(launchAAUI.goO.getText())) {
            if (launchAAUI.goT == null || launchAAUI.goT.size() == 0) {
                AppMethodBeat.o(40862);
                return;
            }
            launchAAUI.aoG();
            h.pYm.e(13721, Integer.valueOf(2), Integer.valueOf(3));
            HashMap hashMap = new HashMap();
            try {
                Object string;
                String obj = launchAAUI.goJ.getText().toString();
                if (bo.isNullOrNil(obj)) {
                    string = launchAAUI.getString(R.string.clz);
                } else {
                    String string2 = obj;
                }
                double d = bo.getDouble(launchAAUI.goO.getText(), 0.0d);
                hashMap.put(k.glP, string2);
                hashMap.put(k.glQ, Double.valueOf(100.0d * d));
                hashMap.put(k.glT, launchAAUI.chatroomName);
                hashMap.put(k.glW, Long.valueOf(launchAAUI.timestamp));
                int size = launchAAUI.goT != null ? launchAAUI.goT.size() : 0;
                if (size > 0) {
                    long a = com.tencent.mm.wallet_core.ui.e.a(com.tencent.mm.plugin.aa.a.h.bh(d, "100"), String.valueOf(size), RoundingMode.CEILING);
                    ab.d("MicroMsg.LaunchAAUI", "perAmount: %s", Long.valueOf(a));
                    if (a <= 0 || a > d.aoj()) {
                        ab.i("MicroMsg.LaunchAAUI", "illegal avgAmount: %s", Long.valueOf(a));
                        AppMethodBeat.o(40862);
                        return;
                    }
                    hashMap.put(k.glS, Long.valueOf(a));
                    hashMap.put(k.glV, launchAAUI.goT);
                    launchAAUI.gnn = com.tencent.mm.wallet_core.ui.g.b(launchAAUI, false, null);
                    f.D(Integer.valueOf(launchAAUI.mode), hashMap).c(launchAAUI.goH.gmJ).f(new com.tencent.mm.vending.c.a<Void, Boolean>() {
                        public final /* synthetic */ Object call(Object obj) {
                            AppMethodBeat.i(40831);
                            ab.d("MicroMsg.LaunchAAUI", "finish launch aa, result: %s", (Boolean) obj);
                            if (LaunchAAUI.this.gnn != null) {
                                LaunchAAUI.this.gnn.dismiss();
                            }
                            if (r8.booleanValue()) {
                                LaunchAAUI.l(LaunchAAUI.this);
                                Toast.makeText(LaunchAAUI.this, R.string.cm4, 1).show();
                                h.pYm.e(13722, Integer.valueOf(4));
                            } else {
                                Toast.makeText(LaunchAAUI.this, R.string.cm0, 1).show();
                                h.pYm.e(13722, Integer.valueOf(5));
                            }
                            Void voidR = zXH;
                            AppMethodBeat.o(40831);
                            return voidR;
                        }
                    }).a((com.tencent.mm.vending.g.d.a) new com.tencent.mm.vending.g.d.a() {
                        public final void bi(Object obj) {
                            AppMethodBeat.i(40830);
                            ab.i("MicroMsg.LaunchAAUI", "onInterrupt: %s", obj);
                            if (LaunchAAUI.this.gnn != null) {
                                LaunchAAUI.this.gnn.dismiss();
                            }
                            if (obj != null && (obj instanceof String) && !obj.toString().equalsIgnoreCase("ok")) {
                                Toast.makeText(LaunchAAUI.this, obj.toString(), 1).show();
                            } else if (obj == null || !(obj instanceof y)) {
                                Toast.makeText(LaunchAAUI.this, R.string.cm0, 1).show();
                            } else {
                                com.tencent.mm.plugin.aa.a.h.a(LaunchAAUI.this.mController.ylL, (y) obj);
                            }
                            h.pYm.e(13722, Integer.valueOf(5));
                            AppMethodBeat.o(40830);
                        }
                    });
                }
                h.pYm.e(13723, Integer.valueOf(1), com.tencent.mm.plugin.aa.a.h.vE(launchAAUI.chatroomName), Integer.valueOf(size), Double.valueOf(d * 100.0d), string2);
                AppMethodBeat.o(40862);
                return;
            } catch (Exception e) {
                ab.e("MicroMsg.LaunchAAUI", "launchAAByMoney mode: %s error: %s", Integer.valueOf(launchAAUI.mode), e.getMessage());
                AppMethodBeat.o(40862);
                return;
            }
        }
        AppMethodBeat.o(40862);
    }

    static /* synthetic */ void l(LaunchAAUI launchAAUI) {
        AppMethodBeat.i(40863);
        int intExtra = launchAAUI.getIntent().getIntExtra("enter_scene", 1);
        if (intExtra == 3 || intExtra == 5) {
            launchAAUI.setResult(-1);
            launchAAUI.finish();
            AppMethodBeat.o(40863);
            return;
        }
        Intent intent = new Intent();
        intent.setFlags(67108864);
        intent.putExtra("key_should_finish", true);
        com.tencent.mm.bp.d.b(launchAAUI.mController.ylL, "offline", ".ui.WalletOfflineCoinPurseUI", intent);
        AppMethodBeat.o(40863);
    }
}
