package com.tencent.p177mm.plugin.p268aa.p270ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p612ui.widget.MMEditText;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.messenger.p993a.C34530b;
import com.tencent.p177mm.plugin.p268aa.p269a.C1954a;
import com.tencent.p177mm.plugin.p268aa.p269a.C32894d;
import com.tencent.p177mm.plugin.p268aa.p269a.C45486k;
import com.tencent.p177mm.plugin.p268aa.p269a.C9797h;
import com.tencent.p177mm.plugin.p268aa.p269a.p717c.C45485e;
import com.tencent.p177mm.plugin.p268aa.p270ui.C9821a.C9822a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.C40437i;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C40463q.C30111a;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C30132m;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.pluginsdk.wallet.C30158b;
import com.tencent.p177mm.protocal.protobuf.C35967y;
import com.tencent.p177mm.protocal.protobuf.C40532j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5692d.C5690a;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.vending.p644j.C7625d;
import com.tencent.p177mm.wallet_core.p650ui.C30901g;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;
import com.tencent.view.C31128d;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAUI */
public class LaunchAAUI extends BaseAAPresenterActivity {
    private String chatroomName = null;
    private TextView gng;
    private Dialog gnn;
    private C45485e goH = ((C45485e) mo21155V(C45485e.class));
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
    private C32894d gpd = new C32894d();
    private int gpe = 0;
    private int gpf = 0;
    private boolean gpg = false;
    private String gph;
    private String gpi;
    private int mode = C1954a.gkU;
    private long timestamp = 0;

    /* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAUI$10 */
    class C670310 implements C5690a {
        C670310() {
        }

        /* renamed from: bi */
        public final void mo9345bi(Object obj) {
            AppMethodBeat.m2504i(40832);
            C4990ab.m7417i("MicroMsg.LaunchAAUI", "onInterrupt: %s", obj);
            if (LaunchAAUI.this.gnn != null) {
                LaunchAAUI.this.gnn.dismiss();
            }
            if (obj != null && (obj instanceof String) && !obj.toString().equalsIgnoreCase("ok")) {
                Toast.makeText(LaunchAAUI.this, obj.toString(), 1).show();
            } else if (obj == null || !(obj instanceof C35967y)) {
                Toast.makeText(LaunchAAUI.this, C25738R.string.cm0, 1).show();
            } else {
                C9797h.m17454a(LaunchAAUI.this.mController.ylL, (C35967y) obj);
            }
            C7060h.pYm.mo8381e(13722, Integer.valueOf(10));
            AppMethodBeat.m2505o(40832);
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAUI$11 */
    class C670411 implements C5681a<Void, C7625d<Boolean, String, Long>> {
        C670411() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(40833);
            C4990ab.m7411d("MicroMsg.LaunchAAUI", "finish launch aa, result: %s", ((C7625d) obj).get(0));
            if (LaunchAAUI.this.gnn != null) {
                LaunchAAUI.this.gnn.dismiss();
            }
            if (((Boolean) r9.get(0)).booleanValue()) {
                LaunchAAUI.m74681l(LaunchAAUI.this);
                Toast.makeText(LaunchAAUI.this, C25738R.string.cm4, 1).show();
                C7060h.pYm.mo8381e(13722, Integer.valueOf(9));
            } else {
                Toast.makeText(LaunchAAUI.this, C25738R.string.cm0, 1).show();
                C7060h.pYm.mo8381e(13722, Integer.valueOf(10));
            }
            Void voidR = zXH;
            AppMethodBeat.m2505o(40833);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAUI$18 */
    class C981218 implements C5681a<Void, C32894d> {
        C981218() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(40839);
            C32894d c32894d = (C32894d) obj;
            C4990ab.m7416i("MicroMsg.LaunchAAUI", "fetch operation data finish");
            if (c32894d != null) {
                LaunchAAUI.this.gpd = c32894d;
                if (!(C5046bo.isNullOrNil(LaunchAAUI.this.gpd.glD) || C5046bo.isNullOrNil(LaunchAAUI.this.gpd.glC))) {
                    LaunchAAUI.m74667a(LaunchAAUI.this, LaunchAAUI.this.gpd.glD, LaunchAAUI.this.gpd.glC);
                }
            }
            Void voidR = zXH;
            AppMethodBeat.m2505o(40839);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAUI$4 */
    class C98134 implements TextWatcher {
        C98134() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(40826);
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
            double d = C5046bo.getDouble(editable.toString(), 0.0d);
            if (LaunchAAUI.this.goT != null && LaunchAAUI.this.goT.size() > 0) {
                d = (d * 100.0d) / ((double) LaunchAAUI.this.goT.size());
                LaunchAAUI.this.gpd;
                if (d > ((double) C32894d.aoj())) {
                    LaunchAAUI.this.gor = true;
                    C7060h.pYm.mo8381e(13722, Integer.valueOf(2));
                    LaunchAAUI.m74671c(LaunchAAUI.this);
                    LaunchAAUI.m74676g(LaunchAAUI.this);
                    LaunchAAUI.m74677h(LaunchAAUI.this);
                    AppMethodBeat.m2505o(40826);
                }
            }
            LaunchAAUI.this.gor = false;
            LaunchAAUI.m74671c(LaunchAAUI.this);
            LaunchAAUI.m74676g(LaunchAAUI.this);
            LaunchAAUI.m74677h(LaunchAAUI.this);
            AppMethodBeat.m2505o(40826);
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAUI$6 */
    class C98146 implements OnClickListener {
        C98146() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(40828);
            LaunchAAUI.m74678i(LaunchAAUI.this);
            AppMethodBeat.m2505o(40828);
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAUI$7 */
    class C98157 implements C30111a {
        C98157() {
        }

        /* renamed from: a */
        public final void mo6399a(boolean z, String str, int i) {
            AppMethodBeat.m2504i(40829);
            if (z) {
                LaunchAAUI.m74679j(LaunchAAUI.this);
            }
            AppMethodBeat.m2505o(40829);
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAUI$17 */
    class C2654117 implements C5690a {
        C2654117() {
        }

        /* renamed from: bi */
        public final void mo9345bi(Object obj) {
            AppMethodBeat.m2504i(40838);
            C4990ab.m7416i("MicroMsg.LaunchAAUI", "fetch operation data failed");
            AppMethodBeat.m2505o(40838);
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAUI$13 */
    class C3291313 implements Runnable {
        C3291313() {
        }

        public final void run() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAUI$14 */
    class C3291414 implements OnClickListener {
        C3291414() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(40835);
            LaunchAAUI.m74666a(LaunchAAUI.this);
            AppMethodBeat.m2505o(40835);
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAUI$16 */
    class C3291516 implements TextWatcher {
        C3291516() {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(40837);
            LaunchAAUI.m74671c(LaunchAAUI.this);
            AppMethodBeat.m2505o(40837);
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAUI$1 */
    class C329161 implements OnMenuItemClickListener {
        C329161() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(40824);
            LaunchAAUI.this.finish();
            AppMethodBeat.m2505o(40824);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAUI$3 */
    class C329173 implements Runnable {
        C329173() {
        }

        public final void run() {
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAUI$15 */
    class C3670715 implements C9822a {
        C3670715() {
        }

        public final void aos() {
            AppMethodBeat.m2504i(40836);
            LaunchAAUI.this.startActivity(new Intent(LaunchAAUI.this, AAQueryListUI.class));
            if (LaunchAAUI.this.mode == C1954a.gkU) {
                C7060h.pYm.mo8381e(13721, Integer.valueOf(5), Integer.valueOf(1));
                AppMethodBeat.m2505o(40836);
                return;
            }
            C7060h.pYm.mo8381e(13721, Integer.valueOf(5), Integer.valueOf(2));
            AppMethodBeat.m2505o(40836);
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAUI$20 */
    class C3801520 implements C9822a {
        C3801520() {
        }

        public final void aos() {
            AppMethodBeat.m2504i(40841);
            LaunchAAUI.m74674e(LaunchAAUI.this);
            AppMethodBeat.m2505o(40841);
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAUI$2 */
    class C380162 implements C9822a {
        C380162() {
        }

        public final void aos() {
            AppMethodBeat.m2504i(40825);
            LaunchAAUI.m74674e(LaunchAAUI.this);
            AppMethodBeat.m2505o(40825);
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAUI$9 */
    class C380179 implements C5681a<Void, Boolean> {
        C380179() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(40831);
            C4990ab.m7411d("MicroMsg.LaunchAAUI", "finish launch aa, result: %s", (Boolean) obj);
            if (LaunchAAUI.this.gnn != null) {
                LaunchAAUI.this.gnn.dismiss();
            }
            if (r8.booleanValue()) {
                LaunchAAUI.m74681l(LaunchAAUI.this);
                Toast.makeText(LaunchAAUI.this, C25738R.string.cm4, 1).show();
                C7060h.pYm.mo8381e(13722, Integer.valueOf(4));
            } else {
                Toast.makeText(LaunchAAUI.this, C25738R.string.cm0, 1).show();
                C7060h.pYm.mo8381e(13722, Integer.valueOf(5));
            }
            Void voidR = zXH;
            AppMethodBeat.m2505o(40831);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAUI$12 */
    class C4226112 implements OnTouchListener {
        C4226112() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(40834);
            LaunchAAUI.this.aoB();
            LaunchAAUI.this.aqX();
            AppMethodBeat.m2505o(40834);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.aa.ui.LaunchAAUI$8 */
    class C422628 implements C5690a {
        C422628() {
        }

        /* renamed from: bi */
        public final void mo9345bi(Object obj) {
            AppMethodBeat.m2504i(40830);
            C4990ab.m7417i("MicroMsg.LaunchAAUI", "onInterrupt: %s", obj);
            if (LaunchAAUI.this.gnn != null) {
                LaunchAAUI.this.gnn.dismiss();
            }
            if (obj != null && (obj instanceof String) && !obj.toString().equalsIgnoreCase("ok")) {
                Toast.makeText(LaunchAAUI.this, obj.toString(), 1).show();
            } else if (obj == null || !(obj instanceof C35967y)) {
                Toast.makeText(LaunchAAUI.this, C25738R.string.cm0, 1).show();
            } else {
                C9797h.m17454a(LaunchAAUI.this.mController.ylL, (C35967y) obj);
            }
            C7060h.pYm.mo8381e(13722, Integer.valueOf(5));
            AppMethodBeat.m2505o(40830);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public LaunchAAUI() {
        AppMethodBeat.m2504i(40842);
        AppMethodBeat.m2505o(40842);
    }

    /* renamed from: c */
    static /* synthetic */ void m74671c(LaunchAAUI launchAAUI) {
        AppMethodBeat.m2504i(40855);
        launchAAUI.aoH();
        AppMethodBeat.m2505o(40855);
    }

    /* renamed from: g */
    static /* synthetic */ void m74676g(LaunchAAUI launchAAUI) {
        AppMethodBeat.m2504i(40858);
        launchAAUI.aoI();
        AppMethodBeat.m2505o(40858);
    }

    /* renamed from: h */
    static /* synthetic */ void m74677h(LaunchAAUI launchAAUI) {
        AppMethodBeat.m2504i(40859);
        launchAAUI.aoK();
        AppMethodBeat.m2505o(40859);
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
        AppMethodBeat.m2504i(40843);
        super.onCreate(bundle);
        C4990ab.m7416i("MicroMsg.LaunchAAUI", "LaunchAAUI onCreate");
        setBackBtn(new C329161());
        this.timestamp = System.currentTimeMillis() / 1000;
        setMMTitle((int) C25738R.string.cm5);
        C5698f.dMn().mo15892c(this.goH.gmL).mo15896f(new C981218()).mo11586a((C5690a) new C2654117());
        this.chatroomName = getIntent().getStringExtra("chatroom_name");
        this.gph = getIntent().getStringExtra("amount");
        this.gpi = getIntent().getStringExtra("title");
        if (C5046bo.isNullOrNil(this.chatroomName)) {
            C4990ab.m7412e("MicroMsg.LaunchAAUI", "chatroomName is null!!!");
            this.chatroomName = "";
        }
        String str = this.chatroomName;
        if (!C5046bo.isNullOrNil(str)) {
            if (!C1855t.m3896kH(str)) {
                ArrayList P = C5046bo.m7508P(str.split(","));
                if (P != null) {
                    P.remove(C1853r.m3846Yz());
                    if (P.size() > 0) {
                        str = (String) P.get(0);
                    }
                }
            }
            this.chatroomName = str;
            this.gnR = findViewById(2131823601);
            this.gnR.setOnTouchListener(new C4226112());
            this.goM = (TextView) findViewById(2131825225);
            this.goM.setClickable(true);
            this.goM.setOnTouchListener(new C30132m(this));
            aoF();
            this.gpa = (Button) findViewById(2131825234);
            this.gpa.setOnClickListener(new C3291414());
            this.gpb = (TextView) findViewById(2131825236);
            this.gpc = (TextView) findViewById(2131825235);
            this.goJ = (MMEditText) findViewById(2131825230);
            this.goK = (TextView) findViewById(2131825231);
            this.gng = (TextView) findViewById(2131825233);
            this.goL = (TextView) findViewById(2131825232);
            this.goK.setText(C25738R.string.cll);
            this.mode = C1954a.gkU;
            this.goN = (TextView) findViewById(2131824949);
            this.goN.setClickable(true);
            this.goN.setOnTouchListener(new C30132m());
            spannableString = new SpannableString(getString(C25738R.string.ap7));
            spannableString.setSpan(new C9821a(new C3670715()), 0, spannableString.length(), 18);
            this.goN.setText(spannableString);
            this.goN.setVisibility(8);
            this.goJ.addTextChangedListener(new C3291516());
            this.goO = (WalletFormView) findViewById(2131825220);
            this.goO.mo64594a(new C98134());
            mo21157a(this.goO, 2, false, false);
            this.goQ = (TextView) findViewById(2131825228);
            this.goP = (TextView) findViewById(2131825227);
            if (C1855t.m3896kH(this.chatroomName)) {
                C4990ab.m7417i("MicroMsg.LaunchAAUI", "is single chat: %s", this.chatroomName);
                arrayList = new ArrayList();
                arrayList.add(C1853r.m3846Yz());
                arrayList.add(this.chatroomName);
            } else {
                arrayList = C9797h.m17462vE(this.chatroomName);
            }
            this.goT = arrayList;
            if (this.goT.size() <= C32894d.aoi()) {
                this.goT.clear();
                this.goQ.setText(getString(C25738R.string.dbc));
                aoH();
            } else if (C1855t.m3896kH(this.chatroomName)) {
                this.goQ.setText(getString(C25738R.string.clh, new Object[]{Integer.valueOf(arrayList.size())}));
            } else {
                this.goQ.setText(getString(C25738R.string.clm, new Object[]{Integer.valueOf(arrayList.size())}));
            }
            this.goQ.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(40827);
                    LaunchAAUI.this.aoB();
                    LaunchAAUI.this.aqX();
                    LaunchAAUI.m74668a(LaunchAAUI.this, arrayList);
                    AppMethodBeat.m2505o(40827);
                }
            });
            this.goR = (ViewGroup) findViewById(2131825226);
            this.goS = (ViewGroup) findViewById(2131825219);
            this.goO.requestFocus();
            this.goI = false;
            this.goW = (TextView) findViewById(2131825223);
            this.goW.setText(C25738R.string.clx);
            this.goW.setTextColor(getResources().getColor(C25738R.color.f11681df));
            this.goU = (ViewGroup) findViewById(2131825221);
            this.goV = (ViewGroup) findViewById(2131825224);
            this.goX = (ViewGroup) findViewById(2131825222);
            this.goX.setOnClickListener(new C98146());
            if (!C5046bo.isNullOrNil(this.gpi)) {
                C4990ab.m7417i("MicroMsg.LaunchAAUI", "default title: %s", this.gpi);
                this.goJ.setText(this.gpi);
                this.goJ.setSelection(this.gpi.length() > 20 ? 20 : this.gpi.length());
            }
            if (!C5046bo.isNullOrNil(this.gph)) {
                C4990ab.m7417i("MicroMsg.LaunchAAUI", "default amount: %s", this.gph);
                str = C36391e.m59996b(this.gph, "100", RoundingMode.HALF_UP);
                this.goO.setText(str);
                this.goO.setSelection(str.length());
            }
            aoH();
            C7060h.pYm.mo8381e(13721, Integer.valueOf(1), Integer.valueOf(1));
            AppMethodBeat.m2505o(40843);
        }
        str = "";
        this.chatroomName = str;
        this.gnR = findViewById(2131823601);
        this.gnR.setOnTouchListener(new C4226112());
        this.goM = (TextView) findViewById(2131825225);
        this.goM.setClickable(true);
        this.goM.setOnTouchListener(new C30132m(this));
        aoF();
        this.gpa = (Button) findViewById(2131825234);
        this.gpa.setOnClickListener(new C3291414());
        this.gpb = (TextView) findViewById(2131825236);
        this.gpc = (TextView) findViewById(2131825235);
        this.goJ = (MMEditText) findViewById(2131825230);
        this.goK = (TextView) findViewById(2131825231);
        this.gng = (TextView) findViewById(2131825233);
        this.goL = (TextView) findViewById(2131825232);
        this.goK.setText(C25738R.string.cll);
        this.mode = C1954a.gkU;
        this.goN = (TextView) findViewById(2131824949);
        this.goN.setClickable(true);
        this.goN.setOnTouchListener(new C30132m());
        spannableString = new SpannableString(getString(C25738R.string.ap7));
        spannableString.setSpan(new C9821a(new C3670715()), 0, spannableString.length(), 18);
        this.goN.setText(spannableString);
        this.goN.setVisibility(8);
        this.goJ.addTextChangedListener(new C3291516());
        this.goO = (WalletFormView) findViewById(2131825220);
        this.goO.mo64594a(new C98134());
        mo21157a(this.goO, 2, false, false);
        this.goQ = (TextView) findViewById(2131825228);
        this.goP = (TextView) findViewById(2131825227);
        if (C1855t.m3896kH(this.chatroomName)) {
        }
        this.goT = arrayList;
        if (this.goT.size() <= C32894d.aoi()) {
        }
        this.goQ.setOnClickListener(/* anonymous class already generated */);
        this.goR = (ViewGroup) findViewById(2131825226);
        this.goS = (ViewGroup) findViewById(2131825219);
        this.goO.requestFocus();
        this.goI = false;
        this.goW = (TextView) findViewById(2131825223);
        this.goW.setText(C25738R.string.clx);
        this.goW.setTextColor(getResources().getColor(C25738R.color.f11681df));
        this.goU = (ViewGroup) findViewById(2131825221);
        this.goV = (ViewGroup) findViewById(2131825224);
        this.goX = (ViewGroup) findViewById(2131825222);
        this.goX.setOnClickListener(new C98146());
        if (C5046bo.isNullOrNil(this.gpi)) {
        }
        if (C5046bo.isNullOrNil(this.gph)) {
        }
        aoH();
        C7060h.pYm.mo8381e(13721, Integer.valueOf(1), Integer.valueOf(1));
        AppMethodBeat.m2505o(40843);
    }

    public final boolean aoE() {
        return false;
    }

    private void aoF() {
        AppMethodBeat.m2504i(40844);
        String string;
        String string2;
        SpannableStringBuilder spannableStringBuilder;
        if (this.mode == C1954a.gkU) {
            string = getString(C25738R.string.clj);
            string2 = getString(C25738R.string.clk);
            spannableStringBuilder = new SpannableStringBuilder("");
            spannableStringBuilder.append(string);
            spannableStringBuilder.append(string2);
            spannableStringBuilder.setSpan(new C9821a(new C3801520()), string.length(), spannableStringBuilder.length(), 18);
            this.goM.setText(spannableStringBuilder);
            AppMethodBeat.m2505o(40844);
            return;
        }
        if (this.mode == C1954a.gkV) {
            string = getString(C25738R.string.clu);
            string2 = getString(C25738R.string.clv);
            spannableStringBuilder = new SpannableStringBuilder("");
            spannableStringBuilder.append(string);
            spannableStringBuilder.append(string2);
            spannableStringBuilder.setSpan(new C9821a(new C380162()), string.length(), spannableStringBuilder.length(), 18);
            this.goM.setText(spannableStringBuilder);
        }
        AppMethodBeat.m2505o(40844);
    }

    /* renamed from: vJ */
    private void m74682vJ(String str) {
        AppMethodBeat.m2504i(40845);
        this.gpg = true;
        this.gpb.setVisibility(0);
        this.gpb.startAnimation(AnimationUtils.loadAnimation(this, C25738R.anim.f8343bh));
        this.gpb.setText(str);
        AppMethodBeat.m2505o(40845);
    }

    private void aoG() {
        AppMethodBeat.m2504i(40846);
        this.gpg = false;
        if (this.gpb.getVisibility() != 8) {
            this.gpb.startAnimation(AnimationUtils.loadAnimation(this, C25738R.anim.f8359c1));
            this.gpb.setVisibility(8);
        }
        AppMethodBeat.m2505o(40846);
    }

    private void aoH() {
        AppMethodBeat.m2504i(40847);
        if (this.mode == C1954a.gkU) {
            if (C5046bo.isNullOrNil(this.goO.getText())) {
                m74673dg(false);
                AppMethodBeat.m2505o(40847);
                return;
            } else if (this.gor) {
                m74673dg(false);
                AppMethodBeat.m2505o(40847);
                return;
            } else if (this.goT == null || this.goT.size() == 0) {
                m74673dg(false);
                AppMethodBeat.m2505o(40847);
                return;
            } else if (this.goT.size() > C32894d.aoi() || this.goI) {
                m74673dg(false);
                AppMethodBeat.m2505o(40847);
                return;
            } else {
                C4990ab.m7411d("MicroMsg.LaunchAAUI", "b1: %s, b2: %s, avg: %s", this.goO.getText(), Integer.valueOf(this.goT.size()), Double.valueOf(C9797h.m17451a(this.goO.getText(), this.goT.size(), 5, 4)));
                if (C9797h.m17451a(this.goO.getText(), this.goT.size(), 5, 4) < 0.01d) {
                    C4990ab.m7416i("MicroMsg.LaunchAAUI", "less than 0.01");
                    m74673dg(false);
                    AppMethodBeat.m2505o(40847);
                    return;
                }
            }
        } else if (this.goY == null || this.goY.size() == 0) {
            m74673dg(false);
            AppMethodBeat.m2505o(40847);
            return;
        } else if (this.goY.size() > C32894d.aoi() || this.goI) {
            m74673dg(false);
            AppMethodBeat.m2505o(40847);
            return;
        }
        m74673dg(true);
        AppMethodBeat.m2505o(40847);
    }

    /* renamed from: dg */
    private void m74673dg(boolean z) {
        AppMethodBeat.m2504i(40848);
        this.gpa.setEnabled(z);
        if (z) {
            this.goK.setTextColor(getResources().getColor(C25738R.color.f11782h4));
            this.gng.setTextColor(getResources().getColor(C25738R.color.f11782h4));
            this.goL.setTextColor(getResources().getColor(C25738R.color.f11782h4));
            AppMethodBeat.m2505o(40848);
            return;
        }
        this.goK.setTextColor(getResources().getColor(C25738R.color.f11682dg));
        this.gng.setTextColor(getResources().getColor(C25738R.color.f11682dg));
        this.goL.setTextColor(getResources().getColor(C25738R.color.f11682dg));
        AppMethodBeat.m2505o(40848);
    }

    private void aoI() {
        AppMethodBeat.m2504i(40849);
        double a;
        if (this.mode == C1954a.gkU) {
            if (this.goT == null || this.goT.size() <= 0) {
                this.gng.setText(getString(C25738R.string.f8643aq));
            } else {
                a = C9797h.m17451a(this.goO.getText(), this.goT.size(), 2, 2);
                this.gng.setText(getString(C25738R.string.f8641ao, new Object[]{Double.valueOf(a)}));
            }
            this.goK.setText(C25738R.string.cll);
            AppMethodBeat.m2505o(40849);
        } else if (this.goY == null || this.goY.size() == 0) {
            this.goK.setText(getString(C25738R.string.clw, new Object[]{Integer.valueOf(0)}));
            this.gng.setText(getString(C25738R.string.f8643aq));
            AppMethodBeat.m2505o(40849);
        } else {
            a = 0.0d;
            Iterator it = this.goY.values().iterator();
            while (true) {
                double d = a;
                if (it.hasNext()) {
                    a = ((Double) it.next()).doubleValue() + d;
                } else {
                    this.gng.setText(getString(C25738R.string.f8641ao, new Object[]{Double.valueOf(d)}));
                    this.goK.setText(getString(C25738R.string.clw, new Object[]{Integer.valueOf(this.goY.size())}));
                    AppMethodBeat.m2505o(40849);
                    return;
                }
            }
        }
    }

    private void aoJ() {
        AppMethodBeat.m2504i(40850);
        ((C30158b) C1720g.m3528K(C30158b.class)).mo48437eA(7, 5);
        C7060h.pYm.mo8381e(13721, Integer.valueOf(3), Integer.valueOf(3));
        HashMap hashMap = new HashMap();
        try {
            Object string;
            String obj = this.goJ.getText().toString();
            if (C5046bo.isNullOrNil(obj)) {
                string = getString(C25738R.string.clz);
            } else {
                String string2 = obj;
            }
            ArrayList arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            long j = 0;
            for (String obj2 : this.goY.keySet()) {
                double doubleValue = ((Double) this.goY.get(obj2)).doubleValue();
                C40532j c40532j = new C40532j();
                c40532j.cSh = C36391e.m60013iz(String.valueOf(doubleValue), "100");
                c40532j.username = obj2;
                arrayList.add(c40532j);
                long j2 = c40532j.cSh + j;
                arrayList2.add(c40532j.cSh);
                j = j2;
            }
            C40532j c40532j2 = new C40532j();
            c40532j2.username = C1853r.m3846Yz();
            c40532j2.cSh = j;
            hashMap.put(C45486k.glP, string2);
            hashMap.put(C45486k.glQ, Long.valueOf(j));
            hashMap.put(C45486k.glV, arrayList);
            hashMap.put(C45486k.glT, this.chatroomName);
            hashMap.put(C45486k.glW, Long.valueOf(this.timestamp));
            if (this.gnn != null) {
                this.gnn.dismiss();
            }
            this.gnn = C30901g.m49318b(this, false, null);
            C5698f.m8559cU(hashMap).mo15892c(this.goH.gmK).mo15896f(new C670411()).mo11586a((C5690a) new C670310());
            C7060h.pYm.mo8381e(13723, Integer.valueOf(2), Integer.valueOf(C9797h.m17462vE(this.chatroomName).size()), Integer.valueOf(arrayList.size() + 1), Long.valueOf(j), string2, C5046bo.m7536c(arrayList2, ","));
            AppMethodBeat.m2505o(40850);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.LaunchAAUI", "launchAAByPerson error: %s", e.getMessage());
            AppMethodBeat.m2505o(40850);
        }
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final int getLayoutId() {
        return 2130969922;
    }

    public void onStop() {
        AppMethodBeat.m2504i(40851);
        super.onStop();
        if (this.goZ != null) {
            this.goZ.clear();
        }
        AppMethodBeat.m2505o(40851);
    }

    private void aoK() {
        AppMethodBeat.m2504i(40852);
        if (!this.goI || this.gpg) {
            if (!this.gor || this.gpg) {
                if (!(this.goI || this.gor)) {
                    aoG();
                }
                AppMethodBeat.m2505o(40852);
                return;
            }
            m74682vJ(getString(C25738R.string.cm1, new Object[]{Float.valueOf(((float) C32894d.aoj()) / 100.0f)}));
            AppMethodBeat.m2505o(40852);
        } else if (this.mode == C1954a.gkU) {
            m74682vJ(getString(C25738R.string.clt, new Object[]{Integer.valueOf(C32894d.aoi())}));
            AppMethodBeat.m2505o(40852);
        } else {
            m74682vJ(getString(C25738R.string.clt, new Object[]{Integer.valueOf(C32894d.aoh())}));
            AppMethodBeat.m2505o(40852);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(40853);
        super.onActivityResult(i, i2, intent);
        String stringExtra;
        String[] split;
        if (i == C31128d.MIC_PTU_MEISHI) {
            if (i2 == -1) {
                stringExtra = intent.getStringExtra("Select_Contact");
                if (this.mode == C1954a.gkU) {
                    if (!C5046bo.isNullOrNil(stringExtra)) {
                        split = stringExtra.split(",");
                        this.goT.clear();
                        this.goT.addAll(Arrays.asList(split));
                    }
                    List vE = C9797h.m17462vE(this.chatroomName);
                    TextView textView;
                    Object[] objArr;
                    if (vE == null || this.goT == null || this.goT.size() != vE.size() || !C1855t.m3896kH(this.chatroomName)) {
                        textView = this.goQ;
                        objArr = new Object[1];
                        objArr[0] = Integer.valueOf(this.goT != null ? this.goT.size() : 0);
                        textView.setText(getString(C25738R.string.clm, objArr));
                    } else {
                        textView = this.goQ;
                        objArr = new Object[1];
                        objArr[0] = Integer.valueOf(this.goT != null ? this.goT.size() : 0);
                        textView.setText(getString(C25738R.string.clh, objArr));
                    }
                }
                aoG();
                if (this.goT == null || this.goT.size() <= C32894d.aoi()) {
                    this.goI = false;
                } else {
                    this.goI = true;
                }
                double d = C5046bo.getDouble(this.goO.getText(), 0.0d);
                if (this.goT == null || (d * 100.0d) / ((double) this.goT.size()) <= ((double) C32894d.aoj())) {
                    this.gor = false;
                } else {
                    this.gor = true;
                    C7060h.pYm.mo8381e(13722, Integer.valueOf(2));
                }
                aoH();
                aoI();
                aoK();
                AppMethodBeat.m2505o(40853);
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
                            this.goY.put(split[0], Double.valueOf(C5046bo.getDouble(split[1], 0.0d)));
                        }
                    }
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.LaunchAAUI", "onActivityResult, SELECT_AMOUNT_SELECT_REQUEST_CODE error: %s", e.getMessage());
                }
            }
            int dimension;
            if (this.goY == null || this.goY.size() <= 0) {
                this.goW.setText(C25738R.string.clx);
                this.goW.setTextColor(getResources().getColor(C25738R.color.f11681df));
                dimension = (int) getResources().getDimension(C25738R.dimen.f10048oi);
                this.goX.setPadding(dimension, dimension, dimension, dimension);
                this.goX.setBackgroundResource(C25738R.drawable.f6798r4);
                this.goV.setVisibility(8);
            } else {
                this.goW.setText(getString(C25738R.string.cly, new Object[]{Integer.valueOf(this.goY.size())}));
                this.goW.setTextColor(getResources().getColor(C25738R.color.f11782h4));
                dimension = (int) getResources().getDimension(C25738R.dimen.f10048oi);
                this.goX.setPadding(dimension, (int) getResources().getDimension(C25738R.dimen.f10045of), dimension, (int) getResources().getDimension(C25738R.dimen.f10046og));
                this.goX.setBackgroundResource(C25738R.drawable.f6796r2);
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
                    launchAAByPersonNameAmountRow.goa.setText(C44089j.m79293b(launchAAByPersonNameAmountRow.getContext(), ((C34530b) C1720g.m3528K(C34530b.class)).getDisplayName(stringExtra2, this.chatroomName), launchAAByPersonNameAmountRow.goa.getTextSize()));
                    launchAAByPersonNameAmountRow.gng.setText(launchAAByPersonNameAmountRow.getContext().getString(C25738R.string.f8641ao, new Object[]{Double.valueOf(doubleValue)}));
                    this.goV.addView(launchAAByPersonNameAmountRow);
                    this.goZ.put(stringExtra2, launchAAByPersonNameAmountRow);
                    i3++;
                }
            }
            if (this.gnR != null) {
                this.gnR.requestLayout();
            }
            this.gpf = 0;
            this.goN.post(new C3291313());
            aoI();
            aoH();
            AppMethodBeat.m2505o(40853);
            return;
        }
        AppMethodBeat.m2505o(40853);
    }

    /* renamed from: a */
    static /* synthetic */ void m74666a(LaunchAAUI launchAAUI) {
        String string;
        AppMethodBeat.m2504i(40854);
        String obj = launchAAUI.goJ.getText().toString();
        if (C5046bo.isNullOrNil(obj)) {
            string = launchAAUI.getString(C25738R.string.clz);
        } else {
            string = obj;
        }
        ((C40437i) C1720g.m3528K(C40437i.class)).mo56647a(launchAAUI.mController, launchAAUI.chatroomName, launchAAUI.getString(C25738R.string.f8650az) + string, launchAAUI.getString(C25738R.string.f8649ay), new C98157());
        AppMethodBeat.m2505o(40854);
    }

    /* renamed from: a */
    static /* synthetic */ void m74667a(LaunchAAUI launchAAUI, String str, final String str2) {
        AppMethodBeat.m2504i(40856);
        launchAAUI.gpc.setVisibility(0);
        launchAAUI.gpc.startAnimation(AnimationUtils.loadAnimation(launchAAUI, C25738R.anim.f8343bh));
        launchAAUI.gpc.setText(str);
        launchAAUI.gpc.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(40840);
                Intent intent = new Intent();
                intent.putExtra("rawUrl", str2);
                C25985d.m41467b(LaunchAAUI.this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.m2505o(40840);
            }
        });
        AppMethodBeat.m2505o(40856);
    }

    /* renamed from: e */
    static /* synthetic */ void m74674e(LaunchAAUI launchAAUI) {
        AppMethodBeat.m2504i(40857);
        C4990ab.m7416i("MicroMsg.LaunchAAUI", "switchMode");
        launchAAUI.goI = false;
        if (launchAAUI.mode == C1954a.gkU) {
            launchAAUI.mode = C1954a.gkV;
            launchAAUI.goR.setVisibility(8);
            launchAAUI.goS.setVisibility(8);
            launchAAUI.goU.setVisibility(0);
            launchAAUI.goK.setText(launchAAUI.getString(C25738R.string.clw, new Object[]{Integer.valueOf(0)}));
            if (launchAAUI.goY != null && launchAAUI.goY.size() > C32894d.aoh()) {
                C7060h.pYm.mo8381e(13722, Integer.valueOf(8));
                launchAAUI.goI = true;
            }
            if (launchAAUI.goI) {
                launchAAUI.m74682vJ(launchAAUI.getString(C25738R.string.clt, new Object[]{Integer.valueOf(C32894d.aoh())}));
            } else {
                launchAAUI.aoG();
            }
            C7060h.pYm.mo8381e(13721, Integer.valueOf(2), Integer.valueOf(1));
        } else {
            launchAAUI.mode = C1954a.gkU;
            launchAAUI.goR.setVisibility(0);
            launchAAUI.goS.setVisibility(0);
            launchAAUI.goU.setVisibility(8);
            launchAAUI.goK.setText(C25738R.string.cll);
            launchAAUI.goI = false;
            if (launchAAUI.goT.size() > C32894d.aoi()) {
                C7060h.pYm.mo8381e(13722, Integer.valueOf(8));
                launchAAUI.goI = true;
            }
            launchAAUI.aoK();
            C7060h.pYm.mo8381e(13721, Integer.valueOf(3), Integer.valueOf(1));
        }
        launchAAUI.aoB();
        launchAAUI.aqX();
        launchAAUI.aoF();
        launchAAUI.aoI();
        launchAAUI.aoH();
        launchAAUI.goN.post(new C329173());
        AppMethodBeat.m2505o(40857);
    }

    /* renamed from: i */
    static /* synthetic */ void m74678i(LaunchAAUI launchAAUI) {
        AppMethodBeat.m2504i(40861);
        Intent intent = new Intent(launchAAUI, LaunchAAByPersonAmountSelectUI.class);
        intent.putExtra("chatroom", launchAAUI.chatroomName);
        intent.putExtra("maxPerAmount", C32894d.aoj());
        if (launchAAUI.goY != null && launchAAUI.goY.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : launchAAUI.goY.keySet()) {
                arrayList.add(str + "," + ((Double) launchAAUI.goY.get(str)).doubleValue());
            }
            intent.putStringArrayListExtra("oldAmountData", arrayList);
        }
        intent.putExtra("maxUserNumber", C32894d.aoh());
        launchAAUI.startActivityForResult(intent, 236);
        C7060h.pYm.mo8381e(13721, Integer.valueOf(3), Integer.valueOf(2));
        AppMethodBeat.m2505o(40861);
    }

    /* renamed from: j */
    static /* synthetic */ void m74679j(LaunchAAUI launchAAUI) {
        AppMethodBeat.m2504i(40862);
        if (launchAAUI.mode != C1954a.gkU) {
            launchAAUI.aoG();
            launchAAUI.aoJ();
        } else if (!C5046bo.isNullOrNil(launchAAUI.goO.getText())) {
            if (launchAAUI.goT == null || launchAAUI.goT.size() == 0) {
                AppMethodBeat.m2505o(40862);
                return;
            }
            launchAAUI.aoG();
            C7060h.pYm.mo8381e(13721, Integer.valueOf(2), Integer.valueOf(3));
            HashMap hashMap = new HashMap();
            try {
                Object string;
                String obj = launchAAUI.goJ.getText().toString();
                if (C5046bo.isNullOrNil(obj)) {
                    string = launchAAUI.getString(C25738R.string.clz);
                } else {
                    String string2 = obj;
                }
                double d = C5046bo.getDouble(launchAAUI.goO.getText(), 0.0d);
                hashMap.put(C45486k.glP, string2);
                hashMap.put(C45486k.glQ, Double.valueOf(100.0d * d));
                hashMap.put(C45486k.glT, launchAAUI.chatroomName);
                hashMap.put(C45486k.glW, Long.valueOf(launchAAUI.timestamp));
                int size = launchAAUI.goT != null ? launchAAUI.goT.size() : 0;
                if (size > 0) {
                    long a = C36391e.m59979a(C9797h.m17457bh(d, "100"), String.valueOf(size), RoundingMode.CEILING);
                    C4990ab.m7411d("MicroMsg.LaunchAAUI", "perAmount: %s", Long.valueOf(a));
                    if (a <= 0 || a > C32894d.aoj()) {
                        C4990ab.m7417i("MicroMsg.LaunchAAUI", "illegal avgAmount: %s", Long.valueOf(a));
                        AppMethodBeat.m2505o(40862);
                        return;
                    }
                    hashMap.put(C45486k.glS, Long.valueOf(a));
                    hashMap.put(C45486k.glV, launchAAUI.goT);
                    launchAAUI.gnn = C30901g.m49318b(launchAAUI, false, null);
                    C5698f.m8551D(Integer.valueOf(launchAAUI.mode), hashMap).mo15892c(launchAAUI.goH.gmJ).mo15896f(new C380179()).mo11586a((C5690a) new C422628());
                }
                C7060h.pYm.mo8381e(13723, Integer.valueOf(1), C9797h.m17462vE(launchAAUI.chatroomName), Integer.valueOf(size), Double.valueOf(d * 100.0d), string2);
                AppMethodBeat.m2505o(40862);
                return;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.LaunchAAUI", "launchAAByMoney mode: %s error: %s", Integer.valueOf(launchAAUI.mode), e.getMessage());
                AppMethodBeat.m2505o(40862);
                return;
            }
        }
        AppMethodBeat.m2505o(40862);
    }

    /* renamed from: l */
    static /* synthetic */ void m74681l(LaunchAAUI launchAAUI) {
        AppMethodBeat.m2504i(40863);
        int intExtra = launchAAUI.getIntent().getIntExtra("enter_scene", 1);
        if (intExtra == 3 || intExtra == 5) {
            launchAAUI.setResult(-1);
            launchAAUI.finish();
            AppMethodBeat.m2505o(40863);
            return;
        }
        Intent intent = new Intent();
        intent.setFlags(67108864);
        intent.putExtra("key_should_finish", true);
        C25985d.m41467b(launchAAUI.mController.ylL, "offline", ".ui.WalletOfflineCoinPurseUI", intent);
        AppMethodBeat.m2505o(40863);
    }
}
