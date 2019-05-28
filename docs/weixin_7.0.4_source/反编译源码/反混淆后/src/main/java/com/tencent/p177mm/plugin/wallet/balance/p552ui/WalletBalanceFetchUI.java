package com.tencent.p177mm.plugin.wallet.balance.p552ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.p069v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C37807uo;
import com.tencent.p177mm.p612ui.C24019s;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.platformtools.C18764x.C18765a;
import com.tencent.p177mm.plugin.account.p765a.p1216b.C32921a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet.balance.C41322b;
import com.tencent.p177mm.plugin.wallet.balance.C43761a;
import com.tencent.p177mm.plugin.wallet.balance.p550a.C4320b;
import com.tencent.p177mm.plugin.wallet.balance.p550a.C7178d;
import com.tencent.p177mm.plugin.wallet.p748a.C46332s;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.C43795a;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C22587ak;
import com.tencent.p177mm.plugin.wallet_core.model.C22590b;
import com.tencent.p177mm.plugin.wallet_core.model.C22590b.C14235c;
import com.tencent.p177mm.plugin.wallet_core.model.C29631j;
import com.tencent.p177mm.plugin.wallet_core.model.C43807e;
import com.tencent.p177mm.plugin.wallet_core.model.C43809g;
import com.tencent.p177mm.plugin.wallet_core.model.Orders;
import com.tencent.p177mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.p177mm.plugin.wallet_core.p1313d.C46362b;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C14313k;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C46373j;
import com.tencent.p177mm.plugin.wallet_core.p561ui.view.C4467c;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35475y;
import com.tencent.p177mm.plugin.wallet_core.p749c.C36836v;
import com.tencent.p177mm.plugin.wallet_core.utils.C35520e;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.protocal.protobuf.C40557pc;
import com.tencent.p177mm.protocal.protobuf.cgv;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.wallet_core.C24143a;
import com.tencent.p177mm.wallet_core.p649c.C24147k;
import com.tencent.p177mm.wallet_core.p649c.C36377e;
import com.tencent.p177mm.wallet_core.p649c.C36381z;
import com.tencent.p177mm.wallet_core.p649c.C44422ad;
import com.tencent.p177mm.wallet_core.p649c.C44423ae;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.p650ui.C40947a;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p650ui.formview.C30890a;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView.C36397a;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@C5271a(2)
/* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI */
public class WalletBalanceFetchUI extends WalletBaseUI implements C36397a {
    private String czZ = null;
    private Button gHn;
    private final int gnS = C1338a.fromDPToPix(C4996ah.getContext(), 270);
    private View jcl;
    private double pQV;
    private String rMr;
    private ArrayList<Bankcard> tgB;
    private Bankcard tgC;
    private String tgD;
    private WalletFormView tgE;
    private LinearLayout tgF;
    private View tgG;
    private TextView tgH;
    private TextView tgI;
    private TextView tgJ;
    private TextView tgK;
    private TextView tgL;
    private ViewGroup tgM;
    private ViewGroup tgN;
    private int tgO = 0;
    private int tgP = 0;
    private int tgQ = 0;
    private double tgR = 0.0d;
    private int tgS = -1;
    private int tgT = 0;
    private DecimalFormat tgU = new DecimalFormat("0.00");
    private boolean tgV = false;
    private int tgW = 0;
    private int tgX = 0;
    private C4320b tgY;
    private Runnable tgZ = new C141211();
    private boolean tha = false;
    private boolean thb = false;
    private boolean thc = false;
    private boolean thd = false;

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI$20 */
    class C432120 extends C24019s {
        C432120() {
        }

        public final void bgW() {
            AppMethodBeat.m2504i(45376);
            WalletBalanceFetchUI.m87077g(WalletBalanceFetchUI.this);
            AppMethodBeat.m2505o(45376);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI$13 */
    class C1411813 implements C5681a<Object, C37441a<C40557pc>> {
        C1411813() {
        }

        public final /* synthetic */ Object call(Object obj) {
            int i = 0;
            AppMethodBeat.m2504i(45368);
            C37441a c37441a = (C37441a) obj;
            C4990ab.m7417i("MicroMsg.WalletBalanceFetchUI", "errType: %s, errCode: %s, errMsg: %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode), c37441a.aIm);
            WalletBalanceFetchUI.this.tgY = null;
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                WalletBalanceFetchUI.this.tgN.removeAllViews();
                LayoutParams layoutParams = new LayoutParams(-2, -2);
                if (!(((C40557pc) c37441a.fsy).vWo == null || ((C40557pc) c37441a.fsy).vWo.isEmpty())) {
                    Iterator it = ((C40557pc) c37441a.fsy).vWo.iterator();
                    while (it.hasNext()) {
                        cgv cgv = (cgv) it.next();
                        TextView textView = new TextView(WalletBalanceFetchUI.this.mController.ylL);
                        C35520e.m58294a(textView, cgv, null);
                        if (i != 0) {
                            layoutParams.topMargin = C1338a.m2856al(WalletBalanceFetchUI.this.mController.ylL, C25738R.dimen.f9723do);
                        }
                        WalletBalanceFetchUI.this.tgN.addView(textView, layoutParams);
                        i++;
                    }
                }
            }
            AppMethodBeat.m2505o(45368);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI$16 */
    class C1411916 implements C36073c {
        final /* synthetic */ List thk;
        final /* synthetic */ Context val$context;

        C1411916(List list, Context context) {
            this.thk = list;
            this.val$context = context;
        }

        /* renamed from: a */
        public final void mo5746a(C44273l c44273l) {
            AppMethodBeat.m2504i(45372);
            int i = 0;
            for (final Bankcard bankcard : this.thk) {
                CharSequence spannableString;
                String str;
                Bitmap a;
                C43807e i2 = C46362b.m87144i(this.val$context, bankcard.field_bankcardType, bankcard.cPb());
                String str2 = "";
                if (i2 != null) {
                    str2 = i2.oRi;
                }
                C4990ab.m7411d("MicroMsg.WalletBalanceFetchUI", "logo url: %s", str2);
                Bitmap a2 = C18764x.m29325a(new C4467c(str2));
                CharSequence charSequence = "";
                if (!C5046bo.isNullOrNil(bankcard.field_forbidWord)) {
                    charSequence = bankcard.field_forbidWord;
                }
                if (C5046bo.isNullOrNil(bankcard.field_forbid_title)) {
                    spannableString = new SpannableString(charSequence);
                    str = charSequence;
                } else {
                    String str3 = charSequence + " ";
                    charSequence = new SpannableString(str3 + bankcard.field_forbid_title);
                    C141201 c141201 = new C46373j(this.val$context) {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(45371);
                            Intent intent = new Intent();
                            C4990ab.m7417i("MicroMsg.WalletBalanceFetchUI", "go to url %s", bankcard.field_forbid_url);
                            intent.putExtra("rawUrl", r1);
                            intent.putExtra("geta8key_username", C1853r.m3846Yz());
                            intent.putExtra("pay_channel", 1);
                            C25985d.m41467b(C1411916.this.val$context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
                            AppMethodBeat.m2505o(45371);
                        }
                    };
                    int length = str3.length();
                    int length2 = str3.length() + bankcard.field_forbid_title.length();
                    charSequence.setSpan(new ForegroundColorSpan(this.val$context.getResources().getColor(C25738R.color.a50)), length, length2, 33);
                    charSequence.setSpan(c141201, length, length2, 33);
                    spannableString = charSequence;
                    str = str3;
                }
                if (C5046bo.m7519ac(spannableString)) {
                    spannableString = new SpannableString(bankcard.field_fetchArriveTimeWording);
                }
                str2 = bankcard.field_desc;
                if (a2 != null) {
                    a = C5056d.m7615a(a2, this.val$context.getResources().getDimensionPixelOffset(C25738R.dimen.aaq), this.val$context.getResources().getDimensionPixelOffset(C25738R.dimen.aaq), true, false);
                } else {
                    a = null;
                }
                C4990ab.m7417i("MicroMsg.WalletBalanceFetchUI", "i %d fee %s %s", Integer.valueOf(i), str2, spannableString);
                int i3 = i + 1;
                c44273l.mo70053a(i, str2, spannableString, a == null ? null : new BitmapDrawable(a), !C5046bo.isNullOrNil(str));
                i = i3;
            }
            c44273l.mo70068e(i, this.val$context.getString(C25738R.string.f90));
            AppMethodBeat.m2505o(45372);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI$1 */
    class C141211 implements Runnable {
        C141211() {
        }

        public final void run() {
            AppMethodBeat.m2504i(45353);
            WalletBalanceFetchUI.m87061a(WalletBalanceFetchUI.this);
            AppMethodBeat.m2505o(45353);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI$12 */
    class C2954512 implements OnClickListener {
        C2954512() {
        }

        public final void onClick(View view) {
            String str;
            int i;
            AppMethodBeat.m2504i(45367);
            WalletBalanceFetchUI.this.aoB();
            C46332s.cNC();
            final ArrayList cQD = C46332s.cND().cQD();
            C46332s.cNC();
            C22590b c22590b = C46332s.cND().tCX;
            String str2 = "";
            String str3 = "";
            if (c22590b != null) {
                str3 = c22590b.twA;
                str2 = c22590b.twz;
                str = str3;
            } else {
                str = str3;
            }
            WalletBalanceFetchUI walletBalanceFetchUI = WalletBalanceFetchUI.this;
            AppCompatActivity appCompatActivity = WalletBalanceFetchUI.this.mController.ylL;
            Bankcard b = WalletBalanceFetchUI.this.tgC;
            C295461 c295461 = new C5279d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.m2504i(45366);
                    C7060h c7060h;
                    Object[] objArr;
                    if (i < cQD.size()) {
                        WalletBalanceFetchUI.this.tgC = (Bankcard) cQD.get(i);
                        WalletBalanceFetchUI.m87068c(WalletBalanceFetchUI.this);
                        C4990ab.m7417i("MicroMsg.WalletBalanceFetchUI", "bankcard: %s", WalletBalanceFetchUI.this.tgC.field_desc);
                        c7060h = C7060h.pYm;
                        objArr = new Object[4];
                        objArr[0] = WalletBalanceFetchUI.this.rMr;
                        objArr[1] = Integer.valueOf(2);
                        objArr[2] = WalletBalanceFetchUI.this.tgC != null ? WalletBalanceFetchUI.this.tgC.field_bankcardType : "";
                        objArr[3] = WalletBalanceFetchUI.this.tgC != null ? WalletBalanceFetchUI.this.tgC.field_bindSerial : "";
                        c7060h.mo8381e(16398, objArr);
                    } else {
                        C4990ab.m7416i("MicroMsg.WalletBalanceFetchUI", "add new card");
                        WalletBalanceFetchUI.m87073e(WalletBalanceFetchUI.this);
                        c7060h = C7060h.pYm;
                        objArr = new Object[4];
                        objArr[0] = WalletBalanceFetchUI.this.rMr;
                        objArr[1] = Integer.valueOf(9);
                        objArr[2] = WalletBalanceFetchUI.this.tgC != null ? WalletBalanceFetchUI.this.tgC.field_bankcardType : "";
                        objArr[3] = WalletBalanceFetchUI.this.tgC != null ? WalletBalanceFetchUI.this.tgC.field_bindSerial : "";
                        c7060h.mo8381e(16398, objArr);
                    }
                    WalletBalanceFetchUI.m87075f(WalletBalanceFetchUI.this);
                    WalletBalanceFetchUI.cMW();
                    AppMethodBeat.m2505o(45366);
                }
            };
            C36356d c36356d = new C36356d(appCompatActivity, 2, true);
            c36356d.rBl = new C1411916(cQD, appCompatActivity);
            c36356d.rBm = c295461;
            c36356d.zQy = true;
            View inflate = LayoutInflater.from(appCompatActivity).inflate(2130971046, null);
            if (!C5046bo.isNullOrNil(str2)) {
                ((TextView) inflate.findViewById(2131828598)).setText(str2);
            }
            if (!C5046bo.isNullOrNil(str)) {
                ((TextView) inflate.findViewById(2131828599)).setText(str);
            }
            c36356d.mo57234F(inflate, false);
            int size = cQD.size();
            if (b != null) {
                i = size;
                int i2 = 0;
                while (i2 < cQD.size()) {
                    if (((Bankcard) cQD.get(i2)).field_bindSerial.equals(b.field_bindSerial)) {
                        size = i2;
                    } else {
                        size = i;
                    }
                    i2++;
                    i = size;
                }
            } else {
                i = size;
            }
            c36356d.zQA = i;
            c36356d.cpD();
            AppMethodBeat.m2505o(45367);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI$14 */
    class C2954714 implements DialogInterface.OnClickListener {
        C2954714() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(45369);
            dialogInterface.dismiss();
            C7060h.pYm.mo8381e(16398, WalletBalanceFetchUI.this.rMr, Integer.valueOf(4), "", "");
            AppMethodBeat.m2505o(45369);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI$15 */
    class C2954815 implements DialogInterface.OnClickListener {
        C2954815() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(45370);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", WalletBalanceFetchUI.this.getString(C25738R.string.fev));
            intent.putExtra("showShare", false);
            C25985d.m41467b(WalletBalanceFetchUI.this, "webview", ".ui.tools.WebViewUI", intent);
            dialogInterface.dismiss();
            C7060h.pYm.mo8381e(16398, WalletBalanceFetchUI.this.rMr, Integer.valueOf(3), "", "");
            AppMethodBeat.m2505o(45370);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI$9 */
    class C295499 implements DialogInterface.OnClickListener {
        C295499() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(45363);
            dialogInterface.dismiss();
            WalletBalanceFetchUI.m87085o(WalletBalanceFetchUI.this);
            AppMethodBeat.m2505o(45363);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI$21 */
    class C3540421 implements OnClickListener {
        C3540421() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45377);
            WalletBalanceFetchUI.m87078h(WalletBalanceFetchUI.this);
            AppMethodBeat.m2505o(45377);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI$22 */
    class C3540522 implements TextWatcher {
        C3540522() {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.m2504i(45378);
            if (editable.toString().startsWith(".")) {
                editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            String obj = editable.toString();
            int indexOf = obj.indexOf(".");
            obj.length();
            int lastIndexOf = obj.lastIndexOf(".");
            int length = obj.length();
            if (indexOf >= 0 && length - indexOf > 3) {
                editable.delete(indexOf + 3, length);
            } else if (lastIndexOf != indexOf) {
                editable.delete(lastIndexOf, length);
            }
            WalletBalanceFetchUI.this.pQV = C5046bo.getDouble(editable.toString(), 0.0d);
            WalletBalanceFetchUI.m87079i(WalletBalanceFetchUI.this);
            WalletBalanceFetchUI.cMW();
            WalletBalanceFetchUI.m87080j(WalletBalanceFetchUI.this);
            AppMethodBeat.m2505o(45378);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI$23 */
    class C3540623 implements C40947a {
        C3540623() {
        }

        /* renamed from: ic */
        public final void mo9448ic(boolean z) {
            AppMethodBeat.m2504i(45379);
            if (z) {
                WalletBalanceFetchUI.m87081k(WalletBalanceFetchUI.this);
                AppMethodBeat.m2505o(45379);
                return;
            }
            WalletBalanceFetchUI.this.jcl.scrollTo(0, 0);
            AppMethodBeat.m2505o(45379);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI$11 */
    class C4006011 implements DialogInterface.OnClickListener {
        C4006011() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(45365);
            dialogInterface.dismiss();
            WalletBalanceFetchUI.m87085o(WalletBalanceFetchUI.this);
            AppMethodBeat.m2505o(45365);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI$5 */
    class C437625 implements DialogInterface.OnClickListener {
        C437625() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(45359);
            dialogInterface.dismiss();
            WalletBalanceFetchUI.m87085o(WalletBalanceFetchUI.this);
            AppMethodBeat.m2505o(45359);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI$10 */
    class C4634110 implements DialogInterface.OnClickListener {
        C4634110() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(45364);
            dialogInterface.dismiss();
            String str = "";
            if (WalletBalanceFetchUI.this.tgC != null) {
                str = WalletBalanceFetchUI.this.tgC.field_bankcardType;
            }
            WalletBalanceFetchUI.this.tgT = 1;
            WalletBalanceFetchUI.this.thd = true;
            WalletBalanceFetchUI.this.mo39970a(new C7178d(WalletBalanceFetchUI.this.pQV, "CNY", str, WalletBalanceFetchUI.this.tgT), true, true);
            AppMethodBeat.m2505o(45364);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI$7 */
    class C463447 implements DialogInterface.OnClickListener {
        C463447() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(45361);
            dialogInterface.dismiss();
            C7060h.pYm.mo8381e(16398, WalletBalanceFetchUI.this.rMr, Integer.valueOf(6), "", "");
            AppMethodBeat.m2505o(45361);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletBalanceFetchUI() {
        AppMethodBeat.m2504i(45386);
        AppMethodBeat.m2505o(45386);
    }

    /* renamed from: b */
    static /* synthetic */ void m87066b(WalletBalanceFetchUI walletBalanceFetchUI, C7178d c7178d) {
        AppMethodBeat.m2504i(45424);
        walletBalanceFetchUI.m87060a(c7178d);
        AppMethodBeat.m2505o(45424);
    }

    static /* synthetic */ void cMW() {
    }

    /* renamed from: i */
    static /* synthetic */ void m87079i(WalletBalanceFetchUI walletBalanceFetchUI) {
        AppMethodBeat.m2504i(45419);
        walletBalanceFetchUI.cMQ();
        AppMethodBeat.m2505o(45419);
    }

    /* renamed from: j */
    static /* synthetic */ void m87080j(WalletBalanceFetchUI walletBalanceFetchUI) {
        AppMethodBeat.m2504i(45420);
        walletBalanceFetchUI.cMR();
        AppMethodBeat.m2505o(45420);
    }

    /* renamed from: n */
    static /* synthetic */ void m87084n(WalletBalanceFetchUI walletBalanceFetchUI) {
        AppMethodBeat.m2504i(45422);
        walletBalanceFetchUI.cMS();
        AppMethodBeat.m2505o(45422);
    }

    /* renamed from: o */
    static /* synthetic */ void m87085o(WalletBalanceFetchUI walletBalanceFetchUI) {
        AppMethodBeat.m2504i(45425);
        walletBalanceFetchUI.cMT();
        AppMethodBeat.m2505o(45425);
    }

    public final int getLayoutId() {
        return 2130971048;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(45387);
        this.rMr = UUID.randomUUID().toString();
        super.onCreate(bundle);
        m87063au(getIntent());
        cfk();
        this.tgD = getString(C25738R.string.f9s);
        initView();
        m87070cu();
        C36381z.m59954hL(4, 0);
        AppMethodBeat.m2505o(45387);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(45388);
        C5004al.m7439af(this.tgZ);
        super.onDestroy();
        AppMethodBeat.m2505o(45388);
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00aa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void cfk() {
        String str;
        AppMethodBeat.m2504i(45389);
        C46332s.cNC();
        C22587ak cND = C46332s.cND();
        if (this.tgV) {
            int i;
            Bankcard bankcard;
            Bankcard bankcard2;
            C4990ab.m7416i("MicroMsg.WalletBalanceFetchUI", "is from new bind bankcard");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            if (this.tgB != null && this.tgB.size() > 0) {
                arrayList.addAll(this.tgB);
            }
            this.tgB = cND.cQD();
            if (this.tgB != null && this.tgB.size() > 0) {
                arrayList2.addAll(this.tgB);
            }
            if (arrayList.size() > 0 && arrayList2.size() > 0) {
                ArrayList arrayList3 = new ArrayList();
                for (i = 0; i < arrayList.size(); i++) {
                    bankcard = (Bankcard) arrayList.get(i);
                    for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                        bankcard2 = (Bankcard) arrayList2.get(i2);
                        if (!(bankcard == null || bankcard2 == null || !bankcard.field_bindSerial.equals(bankcard2.field_bindSerial))) {
                            arrayList3.add(bankcard2);
                        }
                    }
                }
                if (arrayList3.size() > 0) {
                    arrayList2.removeAll(arrayList3);
                }
                if (arrayList2.size() > 0) {
                    bankcard = (Bankcard) arrayList2.get(0);
                    if (bankcard != null) {
                        bankcard2 = cND.mo38130a(this.tgB, null, false, true);
                    } else {
                        bankcard2 = bankcard;
                    }
                    i = 0;
                    while (this.tgB != null && i < this.tgB.size()) {
                        bankcard = (Bankcard) this.tgB.get(i);
                        if (bankcard2 == null && bankcard != null && bankcard2.field_bindSerial.equals(bankcard.field_bindSerial)) {
                            this.tgS = i;
                            break;
                        }
                        i++;
                    }
                    this.tgC = bankcard2;
                    this.tgV = false;
                }
            }
            bankcard = null;
            if (bankcard != null) {
            }
            i = 0;
            while (this.tgB != null) {
                bankcard = (Bankcard) this.tgB.get(i);
                if (bankcard2 == null) {
                }
                i++;
            }
            this.tgC = bankcard2;
            this.tgV = false;
        } else {
            this.tgB = cND.cQD();
            this.tgC = cND.mo38130a(this.tgB, null, false, true);
        }
        C7060h c7060h = C7060h.pYm;
        Object[] objArr = new Object[4];
        objArr[0] = this.rMr;
        objArr[1] = Integer.valueOf(1);
        if (this.tgC != null) {
            str = this.tgC.field_bankcardType;
        } else {
            str = "";
        }
        objArr[2] = str;
        if (this.tgC != null) {
            str = this.tgC.field_bindSerial;
        } else {
            str = "";
        }
        objArr[3] = str;
        c7060h.mo8381e(16398, objArr);
        if (cND.tCX != null) {
            this.tgO = cND.tCX.tgO;
            this.tgP = cND.tCX.tgP;
            cMO();
            this.tgQ = cND.tCX.tgQ;
        } else {
            C4990ab.m7412e("MicroMsg.WalletBalanceFetchUI", "BalanceFetchInfo is null");
        }
        this.tgW = 0;
        this.tgX = 0;
        C4990ab.m7416i("MicroMsg.WalletBalanceFetchUI", "is_show_charge:" + this.tgO + " is_cal_charge:" + this.tgP + " min_charge_fee:" + this.tgR + " is_full_fetch_direct:" + this.tgQ);
        AppMethodBeat.m2505o(45389);
    }

    public final boolean bwP() {
        return false;
    }

    public final void initView() {
        AppMethodBeat.m2504i(45390);
        setMMTitle((int) C25738R.string.f8z);
        this.jcl = findViewById(2131828604);
        this.tgF = (LinearLayout) findViewById(2131828607);
        C2954512 c2954512 = new C2954512();
        this.tgG = findViewById(2131828607);
        this.tgG.setOnClickListener(c2954512);
        this.tgF.setOnClickListener(c2954512);
        this.tgE = (WalletFormView) findViewById(2131828613);
        mo39989e(this.tgE, 2, false);
        C30890a.m49301f(this.tgE);
        this.tgE.setOnInputValidChangeListener(this);
        this.gHn = (Button) findViewById(2131822846);
        this.gHn.setOnClickListener(new C432120());
        this.gHn.setEnabled(false);
        this.tgH = (TextView) findViewById(2131828605);
        this.tgI = (TextView) findViewById(2131828606);
        this.tgJ = (TextView) findViewById(2131828618);
        this.tgK = (TextView) findViewById(2131828615);
        this.tgL = (TextView) findViewById(2131828616);
        this.tgM = (ViewGroup) findViewById(2131828614);
        this.tgN = (ViewGroup) findViewById(2131828617);
        this.tgL.setOnClickListener(new C3540421());
        this.tgE.mo64594a(new C3540522());
        this.obM = new C3540623();
        final C37807uo c37807uo = new C37807uo();
        c37807uo.cQJ.cQL = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
        c37807uo.callback = new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(45380);
                if (C5046bo.isNullOrNil(c37807uo.cQK.cQM)) {
                    C4990ab.m7416i("MicroMsg.WalletBalanceFetchUI", "no bulletin data");
                    AppMethodBeat.m2505o(45380);
                    return;
                }
                C36391e.m59985a(WalletBalanceFetchUI.this.tgH, c37807uo.cQK.cQM, c37807uo.cQK.content, c37807uo.cQK.url);
                AppMethodBeat.m2505o(45380);
            }
        };
        C4879a.xxA.mo10055m(c37807uo);
        AppMethodBeat.m2505o(45390);
    }

    public void onResume() {
        AppMethodBeat.m2504i(45391);
        cMT();
        super.onResume();
        AppMethodBeat.m2505o(45391);
    }

    private void cMO() {
        AppMethodBeat.m2504i(45392);
        if (this.tgC != null) {
            this.tgR = C36391e.m59996b(this.tgC.txn, "100", RoundingMode.HALF_UP);
            C4990ab.m7417i("MicroMsg.WalletBalanceFetchUI", "min charge fee: %s", Double.valueOf(this.tgR));
        }
        AppMethodBeat.m2505o(45392);
    }

    /* renamed from: cu */
    private void m87070cu() {
        AppMethodBeat.m2504i(45393);
        if (this.tgE.getTitleTv() != null) {
            this.tgE.getTitleTv().setText(String.format(getString(C25738R.string.dp9), new Object[]{C44423ae.dOd()}));
        } else {
            C4990ab.m7416i("MicroMsg.WalletBalanceFetchUI", "mTotalFeeEHV.getTitleTv() is null");
        }
        final ImageView imageView = (ImageView) this.tgF.findViewById(2131828609);
        if (this.tgC != null) {
            String str = "";
            C43807e i = C46362b.m87144i(this, this.tgC.field_bankcardType, this.tgC.cPb());
            if (i != null) {
                str = i.oRi;
            }
            imageView.setImageBitmap(null);
            if (this.tgC.cPc()) {
                imageView.setBackgroundResource(C25738R.drawable.bki);
            } else {
                Bitmap a = C18764x.m29325a(new C4467c(str));
                C18764x.m29326a(new C18765a() {
                    /* renamed from: m */
                    public final void mo8136m(String str, final Bitmap bitmap) {
                        AppMethodBeat.m2504i(45382);
                        C5004al.m7441d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(45381);
                                if (!(WalletBalanceFetchUI.this.tgC == null || imageView == null || imageView.getTag() == null || !imageView.getTag().equals(WalletBalanceFetchUI.this.tgC.field_bindSerial))) {
                                    imageView.setImageBitmap(bitmap);
                                }
                                AppMethodBeat.m2505o(45381);
                            }
                        });
                        AppMethodBeat.m2505o(45382);
                    }
                });
                if (!(a == null || a == null)) {
                    imageView.setImageBitmap(C5056d.m7615a(a, getResources().getDimensionPixelOffset(C25738R.dimen.aaq), getResources().getDimensionPixelOffset(C25738R.dimen.aaq), true, false));
                }
            }
            ((TextView) this.tgF.findViewById(2131828610)).setText(getString(C25738R.string.f9r, new Object[]{this.tgC.field_bankName, this.tgC.field_bankcardTail}));
            ((TextView) this.tgF.findViewById(2131828610)).setVisibility(0);
            if (!C5046bo.isNullOrNil(this.tgC.field_fetchArriveTimeWording)) {
                ((TextView) this.tgF.findViewById(2131828611)).setText(this.tgC.field_fetchArriveTimeWording);
                ((TextView) this.tgF.findViewById(2131828611)).setVisibility(0);
                if (this.tgC.field_is_hightlight_pre_arrive_time_wording == 1) {
                    ((TextView) this.tgF.findViewById(2131828611)).setTextColor(Color.parseColor("#FA962A"));
                } else {
                    ((TextView) this.tgF.findViewById(2131828611)).setTextColor(Color.parseColor("#B2B2B2"));
                }
            }
            this.tgJ.setText("");
            this.tgJ.setVisibility(8);
        } else {
            imageView.setImageBitmap(null);
            ((TextView) this.tgF.findViewById(2131828610)).setText(this.tgD);
            ((TextView) this.tgF.findViewById(2131828611)).setText("");
            ((TextView) this.tgF.findViewById(2131828611)).setVisibility(8);
            ((ImageView) this.tgF.findViewById(2131828609)).setImageBitmap(null);
            this.tgJ.setVisibility(8);
        }
        C46332s.cNC();
        String str2 = C46332s.cND().thy.twY;
        if (C5046bo.isNullOrNil(str2)) {
            this.tgI.setVisibility(8);
        } else {
            this.tgI.setVisibility(0);
            this.tgI.setText(str2);
        }
        if (this.tgW == 1) {
            this.tgM.setVisibility(8);
            this.tgN.setVisibility(0);
        } else {
            this.tgM.setVisibility(0);
            this.tgN.setVisibility(8);
        }
        cMQ();
        cMR();
        cMP();
        AppMethodBeat.m2505o(45393);
    }

    private void cMP() {
        AppMethodBeat.m2504i(45394);
        C46332s.cNC();
        final C22590b c22590b = C46332s.cND().tCX;
        this.mController.removeAllOptionMenu();
        if (!(c22590b == null || c22590b.twB == null || c22590b.twB.twD == null || c22590b.twB.twD.length <= 0)) {
            addIconOptionMenu(0, C1318a.actionbar_icon_dark_more, new OnMenuItemClickListener() {

                /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI$26$1 */
                class C141221 implements C36073c {
                    C141221() {
                    }

                    /* renamed from: a */
                    public final void mo5746a(C44273l c44273l) {
                        AppMethodBeat.m2504i(45383);
                        C14235c[] c14235cArr = c22590b.twB.twD;
                        int length = c14235cArr.length;
                        int i = 0;
                        int i2 = 0;
                        while (i < length) {
                            C14235c c14235c = c14235cArr[i];
                            if (!C5046bo.isNullOrNil(c14235c.title)) {
                                if (C5046bo.isNullOrNil(c14235c.desc)) {
                                    c44273l.mo70068e(i2, c14235c.title);
                                } else {
                                    c44273l.mo70052a(i2, c14235c.title, c14235c.desc);
                                }
                            }
                            i++;
                            i2++;
                        }
                        AppMethodBeat.m2505o(45383);
                    }
                }

                /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchUI$26$2 */
                class C141242 implements C5279d {
                    C141242() {
                    }

                    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                        AppMethodBeat.m2504i(45384);
                        int itemId = menuItem.getItemId();
                        if (c22590b.twB.twD != null && itemId < c22590b.twB.twD.length) {
                            C14235c c14235c = c22590b.twB.twD[itemId];
                            C4990ab.m7417i("MicroMsg.WalletBalanceFetchUI", "jump type: %s, url: %s", Integer.valueOf(c14235c.ttd), c14235c.kdF);
                            switch (c14235c.ttd) {
                                case 1:
                                    C36391e.m60016n(WalletBalanceFetchUI.this.mController.ylL, c14235c.kdF, true);
                                    break;
                            }
                        }
                        AppMethodBeat.m2505o(45384);
                    }
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.m2504i(45385);
                    C36356d c36356d = new C36356d(WalletBalanceFetchUI.this.mController.ylL, 1, false);
                    c36356d.rBl = new C141221();
                    c36356d.rBm = new C141242();
                    c36356d.cpD();
                    AppMethodBeat.m2505o(45385);
                    return true;
                }
            });
        }
        AppMethodBeat.m2505o(45394);
    }

    private void cMQ() {
        AppMethodBeat.m2504i(45395);
        if (this.pQV <= 0.0d || this.tgC == null) {
            this.gHn.setEnabled(false);
            AppMethodBeat.m2505o(45395);
            return;
        }
        this.gHn.setEnabled(true);
        AppMethodBeat.m2505o(45395);
    }

    private void cMR() {
        AppMethodBeat.m2504i(45396);
        if (this.tgW == 0) {
            this.pQV = C5046bo.getDouble(this.tgE.getText(), 0.0d);
            double d = this.pQV;
            C46332s.cNC();
            if (!(d == C46332s.cND().thy.twU || this.tgC == null)) {
                d = this.pQV;
                C46332s.cNC();
                if (d != C46332s.cND().thy.twU - this.tgC.field_full_fetch_charge_fee) {
                    this.tgT = 0;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            double d2 = this.pQV;
            C46332s.cNC();
            if (d2 > C46332s.cND().thy.twS) {
                this.tgL.setVisibility(8);
                this.tgK.setTextColor(getResources().getColor(C25738R.color.f12266xy));
                stringBuilder.append(getString(C25738R.string.f92));
            } else {
                String str;
                if (!(this.tgC == null || this.tgO == 0 || ((this.tgO == 1 && this.tgC.field_fetch_charge_rate <= 0.0d) || (this.tgO == 1 && this.tgC.field_fetch_charge_rate > 0.0d && this.tgP == 0)))) {
                    d2 = this.tgR;
                    C46332s.cNC();
                    if (d2 < C46332s.cND().thy.twU) {
                        if (this.tgO == 1 && this.tgC.field_fetch_charge_rate > 0.0d && this.tgP == 1 && (this.pQV <= 0.0d || !this.tgE.asa())) {
                            this.tgL.setVisibility(0);
                            this.tgK.setTextColor(getResources().getColor(C25738R.color.f12092s0));
                            C46332s.cNC();
                            str = C46332s.cND().thy.twZ;
                            if (C5046bo.isNullOrNil(str)) {
                                C4990ab.m7416i("MicroMsg.WalletBalanceFetchUI", "hy: wording's missing. use former routine");
                                C46332s.cNC();
                                stringBuilder.append(getString(C25738R.string.f8t, new Object[]{C36391e.m60006e(C46332s.cND().thy.twU, "CNY")}));
                            } else {
                                stringBuilder.append(str);
                            }
                            stringBuilder.append("，");
                        } else if (this.tgO == 1 && this.tgC.field_fetch_charge_rate > 0.0d && this.tgP == 1) {
                            this.tgL.setVisibility(8);
                            this.tgK.setTextColor(getResources().getColor(C25738R.color.f12092s0));
                            d2 = this.pQV;
                            C46332s.cNC();
                            if (d2 != C46332s.cND().thy.twU - this.tgC.field_full_fetch_charge_fee || this.tgC.field_full_fetch_charge_fee <= 0.0d) {
                                if (C5046bo.isNullOrNil(this.tgC.txm)) {
                                    stringBuilder.append(getString(C25738R.string.f8b, new Object[]{C36391e.m60006e(m87056C(this.pQV), "CNY"), (this.tgC.field_fetch_charge_rate * 100.0d) + "%"}));
                                } else {
                                    stringBuilder.append(String.format(this.tgC.txm, new Object[]{C36391e.m60006e(m87056C(this.pQV), "CNY")}));
                                }
                            } else if (C5046bo.isNullOrNil(this.tgC.txm)) {
                                stringBuilder.append(getString(C25738R.string.f8b, new Object[]{C36391e.m60006e(this.tgC.field_full_fetch_charge_fee, "CNY"), (this.tgC.field_fetch_charge_rate * 100.0d) + "%"}));
                            } else {
                                stringBuilder.append(String.format(this.tgC.txm, new Object[]{C36391e.m60006e(this.tgC.field_full_fetch_charge_fee, "CNY")}));
                            }
                        }
                    }
                }
                this.tgL.setVisibility(0);
                this.tgK.setTextColor(getResources().getColor(C25738R.color.f12092s0));
                C46332s.cNC();
                str = C46332s.cND().thy.twZ;
                if (C5046bo.isNullOrNil(str)) {
                    C4990ab.m7416i("MicroMsg.WalletBalanceFetchUI", "hy: wording's missing. use former routine");
                    C46332s.cNC();
                    stringBuilder.append(getString(C25738R.string.f8t, new Object[]{C36391e.m60006e(C46332s.cND().thy.twU, "CNY")}));
                } else {
                    stringBuilder.append(str);
                }
                stringBuilder.append("，");
            }
            this.tgK.setText(stringBuilder.toString());
        }
        AppMethodBeat.m2505o(45396);
    }

    /* renamed from: C */
    private double m87056C(double d) {
        AppMethodBeat.m2504i(45397);
        C46332s.cNC();
        double max = Math.max(C36391e.m60001c((d - C46332s.cND().tCX.pPt), this.tgC.field_fetch_charge_rate, RoundingMode.HALF_UP), this.tgR);
        AppMethodBeat.m2505o(45397);
        return max;
    }

    /* renamed from: a */
    private void m87060a(C7178d c7178d) {
        AppMethodBeat.m2504i(45398);
        if (C5046bo.isNullOrNil(this.czZ)) {
            C4990ab.m7420w("MicroMsg.WalletBalanceFetchUI", "hy: req key is null. abandon");
            AppMethodBeat.m2505o(45398);
            return;
        }
        PayInfo payInfo = new PayInfo();
        payInfo.czZ = this.czZ;
        payInfo.cIf = 21;
        this.mBundle.putParcelable("key_pay_info", payInfo);
        Orders orders = new Orders();
        orders.pTN = c7178d.pPz - c7178d.pPp;
        orders.tAa = c7178d.pPz - c7178d.pPp;
        orders.tAq.add(new Commodity());
        orders.pPp = c7178d.pPp;
        this.mBundle.putParcelable("key_orders", orders);
        this.mBundle.putParcelable("key_bankcard", this.tgC);
        this.mBundle.putString("key_fetch_cashier_desc", c7178d.tfb);
        this.mBundle.putString("key_report_session_id", this.rMr);
        if (dOD() == null) {
            C24143a.m37106a((Activity) this, C41322b.class, this.mBundle, null);
            AppMethodBeat.m2505o(45398);
            return;
        }
        dOE().mo9366p(this.mBundle);
        AppMethodBeat.m2505o(45398);
    }

    /* renamed from: c */
    public final boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(45399);
        if (i == 0 && i2 == 0) {
            if (c1207m instanceof C7178d) {
                boolean a;
                C7178d c7178d = (C7178d) c1207m;
                this.tha = false;
                if (!this.thd) {
                    this.thb = false;
                }
                this.thc = false;
                this.thd = false;
                if ("1".equals(c7178d.cRb)) {
                    C4990ab.m7416i("MicroMsg.WalletBalanceFetchUI", "need realname verify");
                    Bundle bundle = new Bundle();
                    bundle.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceFetchUI");
                    bundle.putString("realname_verify_process_jump_plugin", "wallet");
                    a = C43795a.m78493a(this, bundle, null, 0);
                } else if ("2".equals(c7178d.cRb)) {
                    C4990ab.m7416i("MicroMsg.WalletBalanceFetchUI", "need upload credit");
                    a = C43795a.m78495a((Activity) this, c7178d.cRc, c7178d.cRf, c7178d.cRd, c7178d.cRe, false, null);
                } else {
                    C4990ab.m7416i("MicroMsg.WalletBalanceFetchUI", "realnameGuideFlag =  " + c7178d.cRb);
                    a = false;
                }
                if (a) {
                    AppMethodBeat.m2505o(45399);
                    return false;
                }
                Object obj;
                if (c7178d.tfc) {
                    if (c7178d.tfd != null) {
                        C4990ab.m7416i("MicroMsg.WalletBalanceFetchUI", "debugIdentifyInfoCompleteDialog() show");
                        String str2 = c7178d.tfd.title;
                        String str3 = c7178d.tfd.content;
                        String str4 = c7178d.tfd.tff;
                        final String str5 = c7178d.tfd.tfg;
                        C4990ab.m7416i("MicroMsg.WalletBalanceFetchUI", "showIdentifyInfoCompleteDialog()");
                        View inflate = LayoutInflater.from(this).inflate(2130971047, null);
                        ImageView imageView = (ImageView) inflate.findViewById(2131822694);
                        Button button = (Button) inflate.findViewById(2131828603);
                        ((TextView) inflate.findViewById(2131828601)).setText(str2);
                        ((TextView) inflate.findViewById(2131828602)).setText(str3);
                        ((Button) inflate.findViewById(2131828603)).setText(str4);
                        final Dialog dialog = new Dialog(this, C25738R.style.f11415zt);
                        dialog.setContentView(inflate);
                        dialog.setTitle(null);
                        dialog.setOnCancelListener(new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.m2504i(45373);
                                C4990ab.m7416i("MicroMsg.WalletBalanceFetchUI", "showIdentifyInfoCompleteDialog onCancel");
                                if (dialog != null && dialog.isShowing()) {
                                    dialog.dismiss();
                                }
                                AppMethodBeat.m2505o(45373);
                            }
                        });
                        imageView.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.m2504i(45374);
                                C4990ab.m7416i("MicroMsg.WalletBalanceFetchUI", "showIdentifyInfoCompleteDialog closeIcon click");
                                if (dialog != null && dialog.isShowing()) {
                                    dialog.dismiss();
                                }
                                AppMethodBeat.m2505o(45374);
                            }
                        });
                        button.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                AppMethodBeat.m2504i(45375);
                                C4990ab.m7416i("MicroMsg.WalletBalanceFetchUI", "showIdentifyInfoCompleteDialog completeBtn click");
                                C32921a.m53856b(this, str5, 2, true);
                                if (dialog != null && dialog.isShowing()) {
                                    dialog.dismiss();
                                }
                                AppMethodBeat.m2505o(45375);
                            }
                        });
                        dialog.show();
                        C30379h.m48455a(this, dialog);
                    } else {
                        C4990ab.m7416i("MicroMsg.WalletBalanceFetchUI", "fetchScene.accountTipDialog == null");
                    }
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    AppMethodBeat.m2505o(45399);
                    return false;
                }
                C44422ad.m80307o(21, c7178d.cBT, i2);
                if (!m87067b(c7178d)) {
                    this.czZ = c7178d.cBT;
                    m87060a(c7178d);
                }
            } else if (c1207m instanceof C35475y) {
                final C35475y c35475y = (C35475y) c1207m;
                cMS();
                if (c35475y.bLD()) {
                    final C24147k c24147k = c35475y.nYe;
                    c24147k.mo39945a((Activity) this, new C36377e() {
                        public final void onCancel() {
                            AppMethodBeat.m2504i(45355);
                            if (c24147k.dNM()) {
                                WalletBalanceFetchUI.this.finish();
                            }
                            AppMethodBeat.m2505o(45355);
                        }

                        public final void cMX() {
                            AppMethodBeat.m2504i(45356);
                            if (c24147k.dNM()) {
                                WalletBalanceFetchUI.m87084n(WalletBalanceFetchUI.this);
                            }
                            AppMethodBeat.m2505o(45356);
                        }

                        public final void cMY() {
                            AppMethodBeat.m2504i(45357);
                            if (c24147k.dNM()) {
                                WalletBalanceFetchUI.this.finish();
                            }
                            AppMethodBeat.m2505o(45357);
                        }
                    });
                    AppMethodBeat.m2505o(45399);
                    return true;
                }
            }
        } else if (c1207m instanceof C7178d) {
            C44422ad.m80307o(21, "", i2);
            cMT();
        }
        AppMethodBeat.m2505o(45399);
        return false;
    }

    private void cMS() {
        AppMethodBeat.m2504i(45400);
        cfk();
        m87070cu();
        cMV();
        AppMethodBeat.m2505o(45400);
    }

    public final int getForceOrientation() {
        return 1;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(45402);
        if (i != 1) {
            super.onActivityResult(i, i2, intent);
            AppMethodBeat.m2505o(45402);
        } else if (i2 != -1 || intent == null) {
            C4990ab.m7416i("MicroMsg.WalletBalanceFetchUI", "onActivityResult cancel select");
            AppMethodBeat.m2505o(45402);
        } else {
            int intExtra = intent.getIntExtra("key_select_index", -1);
            int i3 = this.tgS;
            this.tgS = intExtra;
            C4990ab.m7416i("MicroMsg.WalletBalanceFetchUI", "onActivityResult select bankcard index is ".concat(String.valueOf(intExtra)));
            if (this.tgB == null || intExtra < 0 || intExtra >= this.tgB.size()) {
                if (this.tgB == null || intExtra < 0 || intExtra > this.tgB.size()) {
                    this.tgC = null;
                } else {
                    this.tgS = i3;
                }
                cMU();
            } else {
                this.tgC = (Bankcard) this.tgB.get(intExtra);
            }
            m87070cu();
            AppMethodBeat.m2505o(45402);
        }
    }

    /* renamed from: b */
    private boolean m87067b(C7178d c7178d) {
        AppMethodBeat.m2504i(45403);
        boolean z = false;
        if (!this.tha) {
            z = m87069c(c7178d);
        }
        if (!z) {
            z = m87072d(c7178d);
        }
        if (!(z || this.thb)) {
            z = m87074e(c7178d);
        }
        if (!(z || this.thc)) {
            z = m87076f(c7178d);
        }
        AppMethodBeat.m2505o(45403);
        return z;
    }

    private void cMT() {
        this.tha = false;
        this.thb = false;
        this.thc = false;
        this.thd = false;
    }

    /* renamed from: c */
    private boolean m87069c(final C7178d c7178d) {
        AppMethodBeat.m2504i(45404);
        if (c7178d.teW) {
            this.tha = true;
            C30379h.m48453a((Context) this, false, c7178d.teX, "", getString(C25738R.string.f9187s6), getString(C25738R.string.f9076or), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.m2504i(45358);
                    dialogInterface.dismiss();
                    if (!WalletBalanceFetchUI.m87062a(WalletBalanceFetchUI.this, c7178d)) {
                        WalletBalanceFetchUI.this.czZ = c7178d.cBT;
                        WalletBalanceFetchUI.m87066b(WalletBalanceFetchUI.this, c7178d);
                    }
                    AppMethodBeat.m2505o(45358);
                }
            }, new C437625());
            AppMethodBeat.m2505o(45404);
            return true;
        }
        AppMethodBeat.m2505o(45404);
        return false;
    }

    /* renamed from: d */
    private boolean m87072d(final C7178d c7178d) {
        AppMethodBeat.m2504i(45405);
        C29631j c29631j = c7178d.tfa;
        if (c29631j == null) {
            AppMethodBeat.m2505o(45405);
            return false;
        }
        C4990ab.m7416i("MicroMsg.WalletBalanceFetchUI", "show balance Charge tips");
        C14313k.m22492a(this, c29631j, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(45360);
                dialogInterface.dismiss();
                WalletBalanceFetchUI.this.czZ = c7178d.cBT;
                WalletBalanceFetchUI.m87066b(WalletBalanceFetchUI.this, c7178d);
                C7060h.pYm.mo8381e(16398, WalletBalanceFetchUI.this.rMr, Integer.valueOf(5), "", "");
                AppMethodBeat.m2505o(45360);
            }
        }, new C463447());
        AppMethodBeat.m2505o(45405);
        return true;
    }

    /* renamed from: e */
    private boolean m87074e(final C7178d c7178d) {
        AppMethodBeat.m2504i(45406);
        C22590b c22590b = c7178d.teY;
        if (c22590b == null || (TextUtils.isEmpty(c22590b.twx) && (c22590b.twy == null || c22590b.twy.size() <= 0))) {
            AppMethodBeat.m2505o(45406);
            return false;
        }
        this.thb = true;
        C14313k.m22491a(this, c22590b, false, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(45362);
                dialogInterface.dismiss();
                if (!WalletBalanceFetchUI.m87062a(WalletBalanceFetchUI.this, c7178d)) {
                    WalletBalanceFetchUI.this.czZ = c7178d.cBT;
                    WalletBalanceFetchUI.m87066b(WalletBalanceFetchUI.this, c7178d);
                }
                AppMethodBeat.m2505o(45362);
            }
        }, new C295499());
        AppMethodBeat.m2505o(45406);
        return true;
    }

    /* renamed from: f */
    private boolean m87076f(C7178d c7178d) {
        AppMethodBeat.m2504i(45407);
        C22590b c22590b = c7178d.teZ;
        if (c22590b == null || (TextUtils.isEmpty(c22590b.twx) && (c22590b.twy == null || c22590b.twy.size() <= 0))) {
            AppMethodBeat.m2505o(45407);
            return false;
        }
        this.thc = true;
        C14313k.m22491a(this, c22590b, true, new C4634110(), new C4006011());
        AppMethodBeat.m2505o(45407);
        return true;
    }

    public void onNewIntent(Intent intent) {
        AppMethodBeat.m2504i(45408);
        cMT();
        m87063au(intent);
        AppMethodBeat.m2505o(45408);
    }

    /* renamed from: au */
    private void m87063au(Intent intent) {
        AppMethodBeat.m2504i(45409);
        this.tgV = WalletBalanceFetchUI.m87064av(intent);
        if (this.tgV) {
            C4990ab.m7416i("MicroMsg.WalletBalanceFetchUI", "onNewIntent() bind card success");
            PayInfo payInfo = (PayInfo) this.mBundle.get("key_pay_info");
            if (payInfo == null) {
                payInfo = new PayInfo();
                payInfo.czZ = this.czZ;
                payInfo.cIf = 21;
            }
            mo39970a(new C36836v(payInfo.czZ), true, false);
        }
        AppMethodBeat.m2505o(45409);
    }

    private void cMU() {
        AppMethodBeat.m2504i(45410);
        C43809g cPl = C43809g.cPl();
        if (cPl.aFF()) {
            C30379h.m48461b((Context) this, cPl.pbp, getString(C25738R.string.f9238tz), true);
            AppMethodBeat.m2505o(45410);
            return;
        }
        Bundle bundle = new Bundle();
        Parcelable parcelable = (PayInfo) this.mBundle.get("key_pay_info");
        if (parcelable == null) {
            parcelable = new PayInfo();
            parcelable.czZ = this.czZ;
            parcelable.cIf = 21;
        }
        if (parcelable != null) {
            bundle.putParcelable("key_pay_info", parcelable);
        }
        bundle.putInt("key_scene", 21);
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_need_bind_response", true);
        bundle.putInt("key_bind_scene", 0);
        bundle.putBoolean("key_is_bind_bankcard", true);
        bundle.putInt("from_bind_ui", C43761a.teU);
        C24143a.m37106a((Activity) this, C43761a.class, bundle, null);
        AppMethodBeat.m2505o(45410);
    }

    /* renamed from: av */
    private static boolean m87064av(Intent intent) {
        AppMethodBeat.m2504i(45411);
        if (intent == null || !intent.getBooleanExtra("intent_bind_end", false)) {
            AppMethodBeat.m2505o(45411);
            return false;
        }
        AppMethodBeat.m2505o(45411);
        return true;
    }

    private void cMV() {
        AppMethodBeat.m2504i(45412);
        if (this.tgO != 0) {
            C4990ab.m7416i("MicroMsg.WalletBalanceFetchUI", "showRemainFeeTip is_show_charge =" + this.tgO);
            AppMethodBeat.m2505o(45412);
            return;
        }
        C1720g.m3537RQ();
        boolean booleanValue = ((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_FETCH_CHARGE_TIP_DIALOG_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
        C46332s.cNC();
        if (!(C46332s.cND().tCX == null || booleanValue)) {
            C30379h.m48444a(this, getString(C25738R.string.foj, new Object[]{C36391e.m59972G(r1.pPt)}), getString(C25738R.string.fok), getString(C25738R.string.ffp), getString(C25738R.string.fol), new C2954714(), new C2954815(), (int) C25738R.color.a61);
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_FETCH_CHARGE_TIP_DIALOG_BOOLEAN_SYNC, Boolean.TRUE);
        }
        AppMethodBeat.m2505o(45412);
    }

    /* renamed from: hY */
    public final void mo9407hY(boolean z) {
        AppMethodBeat.m2504i(45401);
        this.tgE.mo64602fx(null);
        AppMethodBeat.m2505o(45401);
    }

    /* renamed from: g */
    static /* synthetic */ void m87077g(WalletBalanceFetchUI walletBalanceFetchUI) {
        String str;
        AppMethodBeat.m2504i(45417);
        walletBalanceFetchUI.pQV = C5046bo.getDouble(walletBalanceFetchUI.tgE.getText(), 0.0d);
        String str2 = "";
        if (walletBalanceFetchUI.tgC != null) {
            str2 = walletBalanceFetchUI.tgC.field_bankcardType;
        } else {
            C43809g cPl = C43809g.cPl();
            if (cPl.aFF()) {
                C30379h.m48461b((Context) walletBalanceFetchUI, cPl.pbp, walletBalanceFetchUI.getString(C25738R.string.f9238tz), true);
                AppMethodBeat.m2505o(45417);
                return;
            }
        }
        if (walletBalanceFetchUI.tgC != null && !C5046bo.isNullOrNil(walletBalanceFetchUI.tgC.field_forbidWord)) {
            C23639t.makeText(walletBalanceFetchUI.mController.ylL, walletBalanceFetchUI.tgC.field_forbidWord, 0).show();
        } else if (walletBalanceFetchUI.pQV <= 0.0d || !walletBalanceFetchUI.tgE.asa()) {
            C23639t.makeText(walletBalanceFetchUI.mController.ylL, C25738R.string.f9y, 0).show();
        } else {
            double d = walletBalanceFetchUI.pQV;
            C46332s.cNC();
            if (d > C46332s.cND().thy.twS) {
                C23639t.makeText(walletBalanceFetchUI.mController.ylL, C25738R.string.f8w, 0).show();
            } else {
                d = walletBalanceFetchUI.pQV;
                C46332s.cNC();
                if (d > C46332s.cND().thy.twU) {
                    C23639t.makeText(walletBalanceFetchUI.mController.ylL, C25738R.string.f8x, 0).show();
                } else {
                    walletBalanceFetchUI.mo39970a(new C7178d(walletBalanceFetchUI.pQV, "CNY", str2, walletBalanceFetchUI.tgT), true, true);
                }
            }
        }
        C7060h c7060h = C7060h.pYm;
        Object[] objArr = new Object[4];
        objArr[0] = walletBalanceFetchUI.rMr;
        objArr[1] = Integer.valueOf(7);
        if (walletBalanceFetchUI.tgC != null) {
            str = walletBalanceFetchUI.tgC.field_bankcardType;
        } else {
            str = "";
        }
        objArr[2] = str;
        if (walletBalanceFetchUI.tgC != null) {
            str = walletBalanceFetchUI.tgC.field_bindSerial;
        } else {
            str = "";
        }
        objArr[3] = str;
        c7060h.mo8381e(16398, objArr);
        AppMethodBeat.m2505o(45417);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: h */
    static /* synthetic */ void m87078h(WalletBalanceFetchUI walletBalanceFetchUI) {
        double d;
        AppMethodBeat.m2504i(45418);
        if (!(walletBalanceFetchUI.tgC == null || walletBalanceFetchUI.tgO == 0 || ((walletBalanceFetchUI.tgO == 1 && walletBalanceFetchUI.tgC.field_fetch_charge_rate <= 0.0d) || (walletBalanceFetchUI.tgO == 1 && walletBalanceFetchUI.tgC.field_fetch_charge_rate > 0.0d && walletBalanceFetchUI.tgP == 0)))) {
            d = walletBalanceFetchUI.tgR;
            C46332s.cNC();
            if (d < C46332s.cND().thy.twU) {
                if (walletBalanceFetchUI.tgC != null) {
                    C46332s.cNC();
                    d = C46332s.cND().thy.twU - walletBalanceFetchUI.tgC.field_full_fetch_charge_fee;
                } else {
                    C46332s.cNC();
                    d = C46332s.cND().thy.twU;
                }
                if (walletBalanceFetchUI.tgQ != 1) {
                    C4990ab.m7416i("MicroMsg.WalletBalanceFetchUI", "do fetch direct to pay!");
                    walletBalanceFetchUI.tgT = 1;
                    if (walletBalanceFetchUI.tgC == null || C5046bo.isNullOrNil(walletBalanceFetchUI.tgC.field_forbidWord)) {
                        String str = "";
                        if (walletBalanceFetchUI.tgC != null) {
                            str = walletBalanceFetchUI.tgC.field_bankcardType;
                        }
                        walletBalanceFetchUI.mo39970a(new C7178d(walletBalanceFetchUI.pQV, "CNY", str, walletBalanceFetchUI.tgT), true, true);
                        AppMethodBeat.m2505o(45418);
                        return;
                    }
                    C23639t.makeText(walletBalanceFetchUI.mController.ylL, walletBalanceFetchUI.tgC.field_forbidWord, 0).show();
                    AppMethodBeat.m2505o(45418);
                    return;
                }
                walletBalanceFetchUI.tgE.setText(walletBalanceFetchUI.tgU.format(d));
                walletBalanceFetchUI.cMQ();
                walletBalanceFetchUI.cMR();
                walletBalanceFetchUI.tgT = 1;
                C4990ab.m7416i("MicroMsg.WalletBalanceFetchUI", "is_full_fetch_direct is 0!");
                AppMethodBeat.m2505o(45418);
                return;
            }
        }
        C46332s.cNC();
        d = C46332s.cND().thy.twU;
        if (walletBalanceFetchUI.tgQ != 1) {
        }
    }

    /* renamed from: k */
    static /* synthetic */ void m87081k(WalletBalanceFetchUI walletBalanceFetchUI) {
        AppMethodBeat.m2504i(45421);
        if (walletBalanceFetchUI.jcl != null) {
            final int i;
            int[] iArr = new int[2];
            walletBalanceFetchUI.gHn.getLocationInWindow(iArr);
            int ge = (C1338a.m2869ge(walletBalanceFetchUI) - i) - C1338a.fromDPToPix(walletBalanceFetchUI, 30);
            C4990ab.m7411d("MicroMsg.WalletBalanceFetchUI", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", Integer.valueOf(iArr[1] + walletBalanceFetchUI.gHn.getHeight()), Integer.valueOf(C1338a.m2869ge(walletBalanceFetchUI)), Integer.valueOf(ge), Integer.valueOf(walletBalanceFetchUI.gnS));
            if (ge > 0 && ge < walletBalanceFetchUI.gnS) {
                i = walletBalanceFetchUI.gnS - ge;
                C4990ab.m7411d("MicroMsg.WalletBalanceFetchUI", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", Integer.valueOf(i));
                walletBalanceFetchUI.jcl.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(45354);
                        WalletBalanceFetchUI.this.jcl.scrollBy(0, i);
                        AppMethodBeat.m2505o(45354);
                    }
                });
            }
        }
        AppMethodBeat.m2505o(45421);
    }
}
