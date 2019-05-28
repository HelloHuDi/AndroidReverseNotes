package com.tencent.p177mm.plugin.recharge.p491ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.support.p057v4.content.C0380b;
import android.telephony.PhoneNumberUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C32628se;
import com.tencent.p177mm.p230g.p231a.C32652uv;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C30379h.C30381a;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.C19483d;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.C27084e;
import com.tencent.p177mm.plugin.recharge.model.C28810f;
import com.tencent.p177mm.plugin.recharge.model.C39571g;
import com.tencent.p177mm.plugin.recharge.model.C43420a;
import com.tencent.p177mm.plugin.recharge.model.C43421b;
import com.tencent.p177mm.plugin.recharge.p1655a.C46158a;
import com.tencent.p177mm.plugin.recharge.p491ui.C12976b.C3696a;
import com.tencent.p177mm.plugin.recharge.p491ui.form.C39575c;
import com.tencent.p177mm.plugin.recharge.p491ui.form.C39575c.C28818b;
import com.tencent.p177mm.plugin.recharge.p491ui.form.C39575c.C28818b.C215915;
import com.tencent.p177mm.plugin.recharge.p491ui.form.C39575c.C28818b.C288174;
import com.tencent.p177mm.plugin.recharge.p491ui.form.C39575c.C28818b.C288191;
import com.tencent.p177mm.plugin.recharge.p491ui.form.C39575c.C28818b.C288203;
import com.tencent.p177mm.plugin.recharge.p491ui.form.C39575c.C28818b.C288212;
import com.tencent.p177mm.plugin.recharge.p491ui.form.C43426d;
import com.tencent.p177mm.plugin.recharge.p491ui.form.C43426d.C43422a;
import com.tencent.p177mm.plugin.recharge.p491ui.form.InstantAutoCompleteTextView;
import com.tencent.p177mm.plugin.recharge.p491ui.form.MallFormView;
import com.tencent.p177mm.plugin.recharge.p491ui.form.MallFormView.C28815a;
import com.tencent.p177mm.plugin.wallet.p748a.C14101p;
import com.tencent.p177mm.plugin.wallet.p748a.C29528q;
import com.tencent.p177mm.plugin.wallet.p748a.C40050e;
import com.tencent.p177mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.p177mm.pluginsdk.C46482a;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.protocal.C46516g;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.p650ui.C30901g;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI */
public class PhoneRechargeUI extends MMActivity implements C1202f, C43422a {
    private String aIm = "";
    private String desc = "";
    private int errCode = 0;
    protected Dialog gII = null;
    private String mAppId = "";
    private View pGT = null;
    private ImageView pGU = null;
    private TextView pGV = null;
    private MallFormView pGW = null;
    private TextView pGX = null;
    private TextView pGY = null;
    private GridView pGZ = null;
    private ArrayList<C29528q> pGh = null;
    private ArrayList<C29528q> pGi = null;
    private C40050e pGj = null;
    private C40050e pGk = null;
    private C40050e pGl = null;
    private C40050e pGm = null;
    private C40050e pGn = null;
    private GridView pHa = null;
    private TextView pHb = null;
    private TextView pHc = null;
    private TextView pHd = null;
    private TextView pHe = null;
    private TextView pHf = null;
    private TextView pHg = null;
    private C12976b pHh = null;
    private C12976b pHi = null;
    private MallFunction pHj = null;
    private String pHk = "";
    private int pHl;
    private String pHm = "";
    private String pHn = "";
    private C28818b pHo = null;
    private C14101p pHp = null;
    private boolean pHq = false;
    private List<String[]> pHr;
    private boolean piJ = false;
    private C4884c piM = new C703614();

    /* renamed from: com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI$14 */
    class C703614 extends C4884c<C32652uv> {
        C703614() {
            AppMethodBeat.m2504i(44267);
            this.xxI = C32652uv.class.getName().hashCode();
            AppMethodBeat.m2505o(44267);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(44268);
            C32652uv c32652uv = (C32652uv) c4883b;
            if (c32652uv instanceof C32652uv) {
                if (c32652uv.cRF.result != -1) {
                    C4990ab.m7416i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : cancel");
                } else if (!PhoneRechargeUI.this.piJ) {
                    C4990ab.m7416i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : ok");
                    C46158a.cea().mo74108a(new C43420a(PhoneRechargeUI.this.pGW.getText(), PhoneRechargeUI.this.pHo.pGx != null ? C5046bo.nullAsNil(PhoneRechargeUI.this.pHo.pGx.name) : "", 0));
                    PhoneRechargeUI.this.finish();
                    PhoneRechargeUI.this.piJ = true;
                }
                AppMethodBeat.m2505o(44268);
                return true;
            }
            C4990ab.m7414f("MicroMsg.PhoneRechargeUI", "hy: mismatched event");
            AppMethodBeat.m2505o(44268);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI$16 */
    class C703716 implements C3696a {
        C703716() {
        }

        /* renamed from: a */
        public final void mo8317a(C29528q c29528q) {
            AppMethodBeat.m2504i(44270);
            if (c29528q == null) {
                C4990ab.m7412e("MicroMsg.PhoneRechargeUI", "hy: no product item");
                AppMethodBeat.m2505o(44270);
                return;
            }
            if (!PhoneRechargeUI.m33040a(PhoneRechargeUI.this, c29528q.tmN, c29528q.fjD)) {
                if (!C5046bo.isNullOrNil(c29528q.url)) {
                    PhoneRechargeUI.m33045c(PhoneRechargeUI.this, PhoneRechargeUI.m33043b(PhoneRechargeUI.this, c29528q.url));
                    AppMethodBeat.m2505o(44270);
                    return;
                } else if (PhoneRechargeUI.m33039a(PhoneRechargeUI.this, c29528q)) {
                    PhoneRechargeUI.m33048d(PhoneRechargeUI.this, c29528q.f13716id);
                }
            }
            AppMethodBeat.m2505o(44270);
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI$17 */
    class C703817 implements C3696a {
        C703817() {
        }

        /* renamed from: a */
        public final void mo8317a(C29528q c29528q) {
            AppMethodBeat.m2504i(44271);
            if (!PhoneRechargeUI.m33040a(PhoneRechargeUI.this, c29528q.tmN, c29528q.fjD)) {
                if (!C5046bo.isNullOrNil(c29528q.url)) {
                    PhoneRechargeUI.m33045c(PhoneRechargeUI.this, PhoneRechargeUI.m33043b(PhoneRechargeUI.this, c29528q.url));
                    AppMethodBeat.m2505o(44271);
                    return;
                } else if (PhoneRechargeUI.m33039a(PhoneRechargeUI.this, c29528q)) {
                    PhoneRechargeUI.m33048d(PhoneRechargeUI.this, c29528q.f13716id);
                    AppMethodBeat.m2505o(44271);
                    return;
                } else {
                    C4990ab.m7420w("MicroMsg.PhoneRechargeUI", "error dataFlow click");
                }
            }
            AppMethodBeat.m2505o(44271);
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI$15 */
    class C1297315 implements OnClickListener {
        C1297315() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44269);
            if ((PhoneRechargeUI.this.getPackageManager().checkPermission("android.permission.READ_CONTACTS", C4996ah.getPackageName()) == 0 ? 1 : 0) != 0) {
                Intent intent = new Intent("android.intent.action.PICK", Contacts.CONTENT_URI);
                if (C5046bo.m7572k(PhoneRechargeUI.this, intent)) {
                    PhoneRechargeUI.this.startActivityForResult(intent, 1);
                }
                AppMethodBeat.m2505o(44269);
                return;
            }
            C30379h.m48461b(PhoneRechargeUI.this, PhoneRechargeUI.this.getString(C25738R.string.fr6), "", true);
            AppMethodBeat.m2505o(44269);
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI$4 */
    class C215764 implements OnClickListener {
        C215764() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44255);
            if (!PhoneRechargeUI.m33040a(PhoneRechargeUI.this, PhoneRechargeUI.this.pGm.tmN, PhoneRechargeUI.this.pGm.fjD)) {
                C4990ab.m7411d("MicroMsg.PhoneRechargeUI", "go to h5: %s", PhoneRechargeUI.m33043b(PhoneRechargeUI.this, PhoneRechargeUI.this.pGm.url));
                PhoneRechargeUI.m33045c(PhoneRechargeUI.this, r0);
            }
            AppMethodBeat.m2505o(44255);
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI$6 */
    class C215776 implements OnClickListener {
        C215776() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44257);
            if (!PhoneRechargeUI.m33040a(PhoneRechargeUI.this, PhoneRechargeUI.this.pGk.tmN, PhoneRechargeUI.this.pGk.fjD)) {
                C4990ab.m7411d("MicroMsg.PhoneRechargeUI", "go to h5: %s", PhoneRechargeUI.m33043b(PhoneRechargeUI.this, PhoneRechargeUI.this.pGk.url));
                PhoneRechargeUI.m33045c(PhoneRechargeUI.this, r0);
            }
            AppMethodBeat.m2505o(44257);
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI$7 */
    class C215787 implements OnClickListener {
        C215787() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44258);
            if (!PhoneRechargeUI.m33040a(PhoneRechargeUI.this, PhoneRechargeUI.this.pGl.tmN, PhoneRechargeUI.this.pGl.fjD)) {
                C4990ab.m7411d("MicroMsg.PhoneRechargeUI", "go to h5: %s", PhoneRechargeUI.m33043b(PhoneRechargeUI.this, PhoneRechargeUI.this.pGl.url));
                PhoneRechargeUI.m33045c(PhoneRechargeUI.this, r0);
            }
            AppMethodBeat.m2505o(44258);
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI$5 */
    class C215795 implements OnClickListener {
        C215795() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44256);
            if (!PhoneRechargeUI.m33040a(PhoneRechargeUI.this, PhoneRechargeUI.this.pGj.tmN, PhoneRechargeUI.this.pGj.fjD)) {
                C4990ab.m7411d("MicroMsg.PhoneRechargeUI", "go to h5: %s", PhoneRechargeUI.m33043b(PhoneRechargeUI.this, PhoneRechargeUI.this.pGj.url));
                PhoneRechargeUI.m33045c(PhoneRechargeUI.this, r0);
            }
            AppMethodBeat.m2505o(44256);
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI$18 */
    class C2158018 implements OnClickListener {
        C2158018() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44272);
            if (PhoneRechargeUI.this.pHp != null) {
                PhoneRechargeUI.m33052g(PhoneRechargeUI.this);
            } else {
                C4990ab.m7412e("MicroMsg.PhoneRechargeUI", "hy: no banner but show ad. should not happen");
            }
            PhoneRechargeUI.this.pGT.setVisibility(8);
            AppMethodBeat.m2505o(44272);
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI$19 */
    class C2158119 implements OnClickListener {
        C2158119() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(44273);
            if (PhoneRechargeUI.this.pHp != null) {
                C46516g.m87805gu(6, 1);
                if (!(PhoneRechargeUI.m33040a(PhoneRechargeUI.this, PhoneRechargeUI.this.pHp.tmN, PhoneRechargeUI.this.pHp.fjD) || C5046bo.isNullOrNil(PhoneRechargeUI.this.pHp.url))) {
                    try {
                        PhoneRechargeUI.m33045c(PhoneRechargeUI.this, URLDecoder.decode(PhoneRechargeUI.this.pHp.url, ProtocolPackage.ServerEncoding));
                        AppMethodBeat.m2505o(44273);
                        return;
                    } catch (UnsupportedEncodingException e) {
                        C4990ab.printErrStackTrace("MicroMsg.PhoneRechargeUI", e, "", new Object[0]);
                    }
                }
            }
            AppMethodBeat.m2505o(44273);
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI$10 */
    class C2158310 implements DialogInterface.OnClickListener {
        C2158310() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(44261);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(44261);
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI$12 */
    class C2158412 implements C28815a {
        C2158412() {
        }

        /* renamed from: hY */
        public final void mo37062hY(boolean z) {
            AppMethodBeat.m2504i(44265);
            if (z) {
                PhoneRechargeUI.this.aqX();
                final String ws = C43421b.m77507ws(PhoneRechargeUI.this.pGW.getText());
                if (ws == null) {
                    C4990ab.m7412e("MicroMsg.PhoneRechargeUI", "null phone, return");
                    AppMethodBeat.m2505o(44265);
                    return;
                }
                C7305d.m12299g(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(44264);
                        long currentTimeMillis = System.currentTimeMillis();
                        final C43420a a = PhoneRechargeUI.m33037a(PhoneRechargeUI.this, ws);
                        C4990ab.m7411d("MicroMsg.PhoneRechargeUI", "handle cost: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                        C5004al.m7441d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(44263);
                                PhoneRechargeUI.this.pHo.setInput(a);
                                PhoneRechargeUI.m33036VF(ws);
                                AppMethodBeat.m2505o(44263);
                            }
                        });
                        AppMethodBeat.m2505o(44264);
                    }
                }, "search_matched_mobile");
                if (PhoneRechargeUI.this.pHq) {
                    PhoneRechargeUI.this.pHq = false;
                    AppMethodBeat.m2505o(44265);
                    return;
                }
                C4990ab.m7410d("MicroMsg.PhoneRechargeUI", "clear focus");
                PhoneRechargeUI.this.pHq = true;
                AppMethodBeat.m2505o(44265);
                return;
            }
            PhoneRechargeUI.this.pGW.getTipsTv().setText("");
            PhoneRechargeUI.this.pGW.getTipsTv().setTextColor(PhoneRechargeUI.this.getResources().getColor(C25738R.color.f12212w4));
            PhoneRechargeUI.m33047d(PhoneRechargeUI.this);
            PhoneRechargeUI.m33050e(PhoneRechargeUI.this);
            if (C5046bo.isNullOrNil(PhoneRechargeUI.this.pGW.getText())) {
                ((AutoCompleteTextView) PhoneRechargeUI.this.pGW.getContentEditText()).showDropDown();
            }
            AppMethodBeat.m2505o(44265);
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI$1 */
    class C215851 implements OnMenuItemClickListener {
        C215851() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(44252);
            PhoneRechargeUI.this.aqX();
            PhoneRechargeUI.this.finish();
            AppMethodBeat.m2505o(44252);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI$3 */
    class C215883 implements OnMenuItemClickListener {
        C215883() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(44254);
            if (!PhoneRechargeUI.m33040a(PhoneRechargeUI.this, PhoneRechargeUI.this.pGn.tmN, PhoneRechargeUI.this.pGn.fjD)) {
                try {
                    PhoneRechargeUI.m33045c(PhoneRechargeUI.this, URLDecoder.decode(PhoneRechargeUI.this.pGn.url, ProtocolPackage.ServerEncoding));
                } catch (UnsupportedEncodingException e) {
                    C4990ab.printErrStackTrace("MicroMsg.PhoneRechargeUI", e, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(44254);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI$11 */
    class C2158911 implements Runnable {
        C2158911() {
        }

        public final void run() {
            AppMethodBeat.m2504i(44262);
            PhoneRechargeUI.this.pGW.cex();
            AppMethodBeat.m2505o(44262);
        }
    }

    /* renamed from: com.tencent.mm.plugin.recharge.ui.PhoneRechargeUI$9 */
    class C215909 implements DialogInterface.OnClickListener {
        C215909() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(44260);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(44260);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public PhoneRechargeUI() {
        AppMethodBeat.m2504i(44276);
        AppMethodBeat.m2505o(44276);
    }

    /* renamed from: b */
    static /* synthetic */ String m33043b(PhoneRechargeUI phoneRechargeUI, String str) {
        AppMethodBeat.m2504i(44301);
        String VC = phoneRechargeUI.m33033VC(str);
        AppMethodBeat.m2505o(44301);
        return VC;
    }

    /* renamed from: e */
    static /* synthetic */ void m33050e(PhoneRechargeUI phoneRechargeUI) {
        AppMethodBeat.m2504i(44299);
        phoneRechargeUI.m33032G(false, false);
        AppMethodBeat.m2505o(44299);
    }

    /* renamed from: n */
    static /* synthetic */ void m33059n(PhoneRechargeUI phoneRechargeUI) {
        AppMethodBeat.m2504i(44306);
        phoneRechargeUI.cem();
        AppMethodBeat.m2505o(44306);
    }

    private void ceh() {
        AppMethodBeat.m2504i(44277);
        this.mAppId = "";
        cel();
        this.errCode = 0;
        this.aIm = "";
        this.desc = "";
        AppMethodBeat.m2505o(44277);
    }

    /* renamed from: VC */
    private String m33033VC(String str) {
        AppMethodBeat.m2504i(44279);
        String str2;
        if (C5046bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.m2505o(44279);
            return str2;
        }
        try {
            str2 = "";
            if (!(this.pHo == null || this.pHo.pGx == null || C5046bo.isNullOrNil(this.pHo.pGx.name))) {
                str2 = this.pHo.pGx.name;
            }
            if (str2.equals(getString(C25738R.string.fr5))) {
                str2 = "WeChatAccountBindNumber";
            }
            String text = this.pGW.getText();
            str2 = URLEncoder.encode(URLEncoder.encode(str2, ProtocolPackage.ServerEncoding), ProtocolPackage.ServerEncoding);
            if (str.startsWith("http://") || str.startsWith("https://")) {
                C4990ab.m7416i("MicroMsg.PhoneRechargeUI", "new url");
                if (str.indexOf("%7Bphone%7D") > 0) {
                    str = str.replace("%7Bphone%7D", text);
                } else {
                    str = str.replace("{phone}", text);
                }
                if (str.indexOf("%7Bremark%7D") > 0) {
                    str2 = str.replace("%7Bremark%7D", str2);
                } else {
                    str2 = str.replace("{remark}", str2);
                }
                AppMethodBeat.m2505o(44279);
                return str2;
            }
            C4990ab.m7416i("MicroMsg.PhoneRechargeUI", "old url");
            str2 = URLDecoder.decode(str, ProtocolPackage.ServerEncoding) + String.format("?phone=%s&remark=%s", new Object[]{text, str2});
            AppMethodBeat.m2505o(44279);
            return str2;
        } catch (UnsupportedEncodingException e) {
            str2 = str;
            C4990ab.printErrStackTrace("MicroMsg.PhoneRechargeUI", e, "", new Object[0]);
            AppMethodBeat.m2505o(44279);
            return str2;
        }
    }

    private boolean cei() {
        AppMethodBeat.m2504i(44280);
        if (this.pHp != null) {
            String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_PHONE_RECHARGE_CLOSED_BANNER_STRING, (Object) "");
            if (C5046bo.isNullOrNil(str)) {
                C4990ab.m7416i("MicroMsg.PhoneRechargeUI", "hy: no banner before, show");
                AppMethodBeat.m2505o(44280);
                return false;
            }
            String[] split = str.split(";");
            if (split != null) {
                int length = split.length;
                int i = 0;
                while (i < length) {
                    String str2 = split[i];
                    if (str2 == null || !str2.equals(String.valueOf(this.pHp.f2951id))) {
                        i++;
                    } else {
                        C4990ab.m7416i("MicroMsg.PhoneRechargeUI", "hy: found closed. ");
                        AppMethodBeat.m2505o(44280);
                        return true;
                    }
                }
            }
            C4990ab.m7416i("MicroMsg.PhoneRechargeUI", "hy: not found closed banner.");
            AppMethodBeat.m2505o(44280);
            return false;
        }
        C4990ab.m7412e("MicroMsg.PhoneRechargeUI", "hy: no banner");
        AppMethodBeat.m2505o(44280);
        return true;
    }

    /* renamed from: o */
    private void m33060o(C1207m c1207m) {
        AppMethodBeat.m2504i(44281);
        if (!(this.gII == null || !this.gII.isShowing() || c1207m.getType() == C19483d.CTRL_INDEX)) {
            this.gII.dismiss();
            this.gII = null;
        }
        AppMethodBeat.m2505o(44281);
    }

    /* renamed from: c */
    private void m33044c(final C1207m c1207m, boolean z) {
        AppMethodBeat.m2504i(44282);
        if (this.gII == null || !(this.gII == null || this.gII.isShowing())) {
            if (z) {
                this.gII = C30901g.m49317a(this.mController.ylL, true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(44275);
                        C1720g.m3540Rg().mo14547c(c1207m);
                        AppMethodBeat.m2505o(44275);
                    }
                });
            } else {
                this.gII = C30901g.m49318b(this.mController.ylL, true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(44253);
                        C1720g.m3540Rg().mo14547c(c1207m);
                        AppMethodBeat.m2505o(44253);
                    }
                });
            }
        }
        C1720g.m3540Rg().mo14541a(c1207m, 0);
        AppMethodBeat.m2505o(44282);
    }

    public void onResume() {
        AppMethodBeat.m2504i(44283);
        super.onResume();
        m33032G(false, true);
        AppMethodBeat.m2505o(44283);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(44284);
        super.onDestroy();
        C1720g.m3540Rg().mo14546b(1571, (C1202f) this);
        C1720g.m3540Rg().mo14546b((int) C27084e.CTRL_INDEX, (C1202f) this);
        C4879a.xxA.mo10053d(this.piM);
        AppMethodBeat.m2505o(44284);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: G */
    private void m33032G(boolean z, boolean z2) {
        TextView textView;
        CharSequence string;
        AppMethodBeat.m2504i(44285);
        if (this.pHp == null || cei()) {
            this.pGT.setVisibility(8);
            C4990ab.m7410d("MicroMsg.PhoneRechargeUI", "hy: dismiss banner!");
        } else {
            this.pGT.setVisibility(0);
            this.pGV.setText(this.pHp.name);
            C4990ab.m7410d("MicroMsg.PhoneRechargeUI", "hy: Show banner!");
            C46516g.m87805gu(6, 0);
        }
        this.pHh.pGL = this.pGh;
        this.pHh.notifyDataSetChanged();
        this.pHi.pGL = this.pGi;
        this.pHi.notifyDataSetChanged();
        if (z) {
            if (cek()) {
                this.pHf.setVisibility(0);
            } else {
                this.pHf.setVisibility(8);
            }
            if (cej()) {
                this.pHg.setVisibility(0);
                if (z2) {
                    addTextOptionMenu(0, this.pGn.name, new C215883());
                }
                textView = this.pGX;
                string = (this.pGh != null || this.pGh.size() <= 0 || C5046bo.isNullOrNil(((C29528q) this.pGh.get(0)).tnt)) ? getString(C25738R.string.fqy) : ((C29528q) this.pGh.get(0)).tnt;
                textView.setText(string);
                textView = this.pGY;
                string = (this.pGi != null || this.pGi.size() <= 0 || C5046bo.isNullOrNil(((C29528q) this.pGi.get(0)).tnt)) ? getString(C25738R.string.fqz) : ((C29528q) this.pGi.get(0)).tnt;
                textView.setText(string);
                if (this.pGm != null || C5046bo.isNullOrNil(this.pGm.name)) {
                    this.pHc.setVisibility(8);
                } else {
                    this.pHc.setVisibility(0);
                    this.pHc.setText(this.pGm.name);
                    this.pHc.setOnClickListener(new C215764());
                }
                if (this.pGj != null || C5046bo.isNullOrNil(this.pGj.name)) {
                    this.pHb.setVisibility(8);
                } else {
                    this.pHb.setVisibility(0);
                    this.pHb.setText(this.pGj.name);
                    this.pHb.setOnClickListener(new C215795());
                }
                if (this.pGk != null || C5046bo.isNullOrNil(this.pGk.name)) {
                    this.pHd.setVisibility(8);
                } else {
                    this.pHd.setVisibility(0);
                    this.pHd.setText(this.pGk.name);
                    this.pHd.setOnClickListener(new C215776());
                }
                if (this.pGl != null || C5046bo.isNullOrNil(this.pGl.name)) {
                    this.pHe.setVisibility(8);
                } else {
                    this.pHe.setVisibility(0);
                    this.pHe.setText(this.pGl.name);
                    this.pHe.setOnClickListener(new C215787());
                }
                m33049d(this.pHj);
                AppMethodBeat.m2505o(44285);
            }
        }
        this.pHf.setVisibility(8);
        this.pHg.setVisibility(8);
        if (z2) {
        }
        textView = this.pGX;
        if (this.pGh != null) {
        }
        textView.setText(string);
        textView = this.pGY;
        if (this.pGi != null) {
        }
        textView.setText(string);
        if (this.pGm != null) {
        }
        this.pHc.setVisibility(8);
        if (this.pGj != null) {
        }
        this.pHb.setVisibility(8);
        if (this.pGk != null) {
        }
        this.pHd.setVisibility(8);
        if (this.pGl != null) {
        }
        this.pHe.setVisibility(8);
        m33049d(this.pHj);
        AppMethodBeat.m2505o(44285);
    }

    private boolean cej() {
        AppMethodBeat.m2504i(44286);
        Iterator it = this.pGi.iterator();
        while (it.hasNext()) {
            if (((C29528q) it.next()).status != 0) {
                AppMethodBeat.m2505o(44286);
                return false;
            }
        }
        AppMethodBeat.m2505o(44286);
        return true;
    }

    private boolean cek() {
        AppMethodBeat.m2504i(44287);
        Iterator it = this.pGh.iterator();
        while (it.hasNext()) {
            if (((C29528q) it.next()).status != 0) {
                AppMethodBeat.m2505o(44287);
                return false;
            }
        }
        AppMethodBeat.m2505o(44287);
        return true;
    }

    /* renamed from: d */
    private void m33049d(MallFunction mallFunction) {
        AppMethodBeat.m2504i(44288);
        if (C43421b.m77505c(mallFunction)) {
            C43421b.ced();
            C4990ab.m7410d("MicroMsg.PhoneRechargeUI", this.pHj.tDn.toString());
            m33034VD(this.pHj.tDn.tDC);
        }
        AppMethodBeat.m2505o(44288);
    }

    /* renamed from: VD */
    private void m33034VD(final String str) {
        AppMethodBeat.m2504i(44289);
        C30379h.m48437a(this.mController.ylL, getString(C25738R.string.frd), C5616v.m8409hu(this).inflate(2130970479, null), getString(C25738R.string.fre), getString(C25738R.string.frc), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(44259);
                C4990ab.m7411d("MicroMsg.PhoneRechargeUI", "go to h5: %s", PhoneRechargeUI.m33043b(PhoneRechargeUI.this, str));
                PhoneRechargeUI.m33045c(PhoneRechargeUI.this, r0);
                AppMethodBeat.m2505o(44259);
            }
        }, new C215909());
        AppMethodBeat.m2505o(44289);
    }

    private void cel() {
        AppMethodBeat.m2504i(44290);
        this.pGh = new ArrayList();
        C29528q c29528q = new C29528q();
        c29528q.name = getString(C25738R.string.fqo);
        c29528q.status = 0;
        C29528q c29528q2 = new C29528q();
        c29528q2.name = getString(C25738R.string.fqp);
        c29528q2.status = 0;
        C29528q c29528q3 = new C29528q();
        c29528q3.name = getString(C25738R.string.fqq);
        c29528q3.status = 0;
        C29528q c29528q4 = new C29528q();
        c29528q4.name = getString(C25738R.string.fqr);
        c29528q4.status = 0;
        C29528q c29528q5 = new C29528q();
        c29528q5.name = getString(C25738R.string.fqs);
        c29528q5.status = 0;
        C29528q c29528q6 = new C29528q();
        c29528q6.name = getString(C25738R.string.fqt);
        c29528q6.status = 0;
        this.pGh.add(c29528q);
        this.pGh.add(c29528q2);
        this.pGh.add(c29528q3);
        this.pGh.add(c29528q4);
        this.pGh.add(c29528q5);
        this.pGh.add(c29528q6);
        this.pGi = new ArrayList();
        c29528q = new C29528q();
        c29528q.name = getString(C25738R.string.fqu);
        c29528q.status = 0;
        c29528q2 = new C29528q();
        c29528q2.name = getString(C25738R.string.fqv);
        c29528q2.status = 0;
        c29528q3 = new C29528q();
        c29528q3.name = getString(C25738R.string.fqw);
        c29528q3.status = 0;
        this.pGi.add(c29528q);
        this.pGi.add(c29528q2);
        this.pGi.add(c29528q3);
        AppMethodBeat.m2505o(44290);
    }

    public final int getLayoutId() {
        return 2130970361;
    }

    /* renamed from: VE */
    private void m33035VE(String str) {
        AppMethodBeat.m2504i(44291);
        C30379h.m48448a((Context) this, str, "", false, new C2158310());
        AppMethodBeat.m2505o(44291);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(44292);
        if (c1207m instanceof C28810f) {
            C28810f c28810f = (C28810f) c1207m;
            if (c28810f.cmdId != 0) {
                C4990ab.m7416i("MicroMsg.PhoneRechargeUI", "do delete phone number");
                AppMethodBeat.m2505o(44292);
                return;
            } else if (C5046bo.isNullOrNil(c28810f.gDV) || c28810f.gDV.equals(this.pGW.getText())) {
                m33060o(c1207m);
                if (c28810f.pGg) {
                    C4990ab.m7412e("MicroMsg.PhoneRechargeUI", "hy: cgi failed.");
                    m33035VE(c28810f.aIm);
                    ceh();
                    AppMethodBeat.m2505o(44292);
                    return;
                }
                boolean z;
                boolean z2;
                this.mAppId = c28810f.appId;
                this.pGh = c28810f.pGh;
                this.pGj = c28810f.pGj;
                this.pGk = c28810f.pGk;
                this.pGl = c28810f.pGl;
                this.pGm = c28810f.pGm;
                this.errCode = c28810f.errCode;
                this.aIm = c28810f.aIm;
                this.pHk = c28810f.desc;
                C4990ab.m7417i("MicroMsg.PhoneRechargeUI", "desc: %s, mobile: %s", this.pHk, this.pGW.getText());
                if (C5046bo.isNullOrNil(this.pHk)) {
                    this.desc = "";
                    this.pHl = getResources().getColor(C25738R.color.f12212w4);
                } else if (this.pHo.pGx != null && this.pHo.pGx.pFM.trim().equals(this.pGW.getText())) {
                    this.pHo.pGx.pFN = this.pHk;
                    this.pHo.setInput(this.pHo.pGx);
                }
                this.pHp = c28810f.pGo;
                this.pGi = c28810f.pGi;
                if (this.pGi != null) {
                    for (int size = this.pGi.size() - 1; size >= 0; size--) {
                        C29528q c29528q = (C29528q) this.pGi.get(size);
                        if (c29528q.name.isEmpty()) {
                            this.pGi.remove(c29528q);
                        }
                    }
                }
                if (c28810f.pGn == null || (c28810f.pGn.name.equals(this.pGn.name) && c28810f.pGn.url.equals(this.pGn.url) && c28810f.pGn.tmN.equals(this.pGn.tmN) && c28810f.pGn.fjD.equals(this.pGn.fjD))) {
                    z = false;
                } else {
                    C4990ab.m7416i("MicroMsg.PhoneRechargeUI", "need to update head");
                    this.pGn = c28810f.pGn;
                    z = true;
                }
                if (this.pHk.equals("")) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                m33032G(z2, z);
                List list = c28810f.pGp;
                if (list != null) {
                    C4990ab.m7410d("MicroMsg.PhoneRechargeUI", "update record history");
                    C46158a.cea().mo74109cK(list);
                    if (this.pHo != null) {
                        if (c28810f.pGq) {
                            this.pHo.mo46968kd(true);
                        } else {
                            this.pHo.mo46968kd(false);
                        }
                    }
                }
                this.pGW.postDelayed(new C2158911(), 300);
                AppMethodBeat.m2505o(44292);
                return;
            } else {
                C4990ab.m7417i("MicroMsg.PhoneRechargeUI", "hy: mobiel num not match.abourt, %s, %s", c28810f.gDV, this.pGW.getText());
                AppMethodBeat.m2505o(44292);
                return;
            }
        }
        if (c1207m instanceof C39571g) {
            m33060o(c1207m);
            if (i == 0 && i2 == 0) {
                PayInfo payInfo = ((C39571g) c1207m).pGr;
                payInfo.cIf = 6;
                payInfo.vwe = 100;
                payInfo.kck = this.pGW.getText();
                payInfo.hHV = this.pHo.pGx != null ? this.pHo.pGx.name : "";
                C35899h.m58853a(this, payInfo, 2);
                C4879a.xxA.mo10052c(this.piM);
                AppMethodBeat.m2505o(44292);
                return;
            }
            if (C5046bo.isNullOrNil(str)) {
                str = getString(C25738R.string.fu2);
            }
            m33035VE(str);
        }
        AppMethodBeat.m2505o(44292);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(44293);
        switch (i) {
            case 1:
                if (i2 == -1) {
                    this.pHq = true;
                    String str = null;
                    final List arrayList = new ArrayList();
                    Uri data = intent.getData();
                    if (data != null) {
                        if (C0380b.checkSelfPermission(this, "android.permission.READ_CONTACTS") == 0) {
                            try {
                                Cursor query = getContentResolver().query(data, null, null, null, null);
                                if (query != null && query.getCount() > 0) {
                                    query.moveToFirst();
                                    int columnIndex = query.getColumnIndex("has_phone_number");
                                    if (columnIndex <= 0 || query.getInt(columnIndex) > 0) {
                                        Cursor query2 = getContentResolver().query(Phone.CONTENT_URI, null, "contact_id = ".concat(String.valueOf(query.getString(query.getColumnIndex("_id")))), null, null);
                                        if (query2 != null && query2.moveToFirst()) {
                                            String str2 = null;
                                            while (!query2.isAfterLast()) {
                                                columnIndex = query2.getColumnIndex("data1");
                                                int columnIndex2 = query2.getColumnIndex(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME);
                                                String string = query2.getString(columnIndex);
                                                str2 = query2.getString(columnIndex2);
                                                C4990ab.m7410d("MicroMsg.PhoneRechargeUI", "hy: username : ".concat(String.valueOf(str2)));
                                                if (string != null) {
                                                    C4990ab.m7410d("MicroMsg.PhoneRechargeUI", "hy: phoneNumber : ".concat(String.valueOf(string)));
                                                    String ws = C43421b.m77507ws(string);
                                                    C4990ab.m7410d("MicroMsg.PhoneRechargeUI", "hy: phoneNumber : ".concat(String.valueOf(ws)));
                                                    if (PhoneNumberUtils.isGlobalPhoneNumber(ws) && ws.length() == 11) {
                                                        arrayList.add(ws);
                                                    }
                                                    C4990ab.m7410d("MicroMsg.PhoneRechargeUI", "hy: phoneResult : ".concat(String.valueOf(ws)));
                                                }
                                                query2.moveToNext();
                                            }
                                            str = str2;
                                        }
                                        if (query2 != null) {
                                            query2.close();
                                        }
                                    }
                                }
                                if (!(query == null || query.isClosed())) {
                                    query.close();
                                }
                                if (arrayList.size() <= 1) {
                                    if (arrayList.size() != 1) {
                                        C30379h.m48461b((Context) this, getString(C25738R.string.cyj), "", true);
                                        break;
                                    }
                                    this.pHo.setInput(new C43420a((String) arrayList.get(0), str, 1));
                                    cem();
                                    break;
                                }
                                C5653c a = C30379h.m48450a((Context) this, getString(C25738R.string.fr8), arrayList, -1, new C30381a() {
                                    /* renamed from: BB */
                                    public final void mo26479BB(int i) {
                                        AppMethodBeat.m2504i(44266);
                                        C4990ab.m7411d("MicroMsg.PhoneRechargeUI", "choose: %d", Integer.valueOf(i));
                                        PhoneRechargeUI.this.pHo.setInput(new C43420a((String) arrayList.get(i), str, 1));
                                        PhoneRechargeUI.m33059n(PhoneRechargeUI.this);
                                        AppMethodBeat.m2505o(44266);
                                    }
                                });
                                if (a != null) {
                                    a.setCanceledOnTouchOutside(true);
                                    break;
                                }
                            } catch (SecurityException e) {
                                C4990ab.m7413e("MicroMsg.PhoneRechargeUI", "hy: permission denied: %s", e.toString());
                                C30379h.m48461b((Context) this, getString(C25738R.string.cyl), "", true);
                                break;
                            }
                        }
                        C4990ab.m7412e("MicroMsg.PhoneRechargeUI", "no contact permission");
                        AppMethodBeat.m2505o(44293);
                        return;
                    }
                    C4990ab.m7412e("MicroMsg.PhoneRechargeUI", "hy: uri == null");
                    AppMethodBeat.m2505o(44293);
                    return;
                }
                break;
            case 2:
                if (i2 == -1) {
                    if (!this.piJ) {
                        C4990ab.m7416i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : ok");
                        C46158a.cea().mo74108a(new C43420a(this.pGW.getText(), this.pGW.getTipsTv().getText().toString(), 0));
                        finish();
                        this.piJ = true;
                        break;
                    }
                }
                C4990ab.m7416i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : cancel");
                break;
                break;
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.m2505o(44293);
    }

    private void cem() {
        AppMethodBeat.m2504i(44294);
        C1720g.m3540Rg().mo14541a(new C28810f(this.pGW.getText()), 0);
        AppMethodBeat.m2505o(44294);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(44278);
        this.yll = true;
        super.onCreate(bundle);
        mo17446xE(this.mController.dyj());
        C1720g.m3540Rg().mo14539a(1571, (C1202f) this);
        C1720g.m3540Rg().mo14539a((int) C27084e.CTRL_INDEX, (C1202f) this);
        this.pHj = (MallFunction) getIntent().getParcelableExtra("key_func_info");
        if (this.pHj == null) {
            C4990ab.m7412e("MicroMsg.PhoneRechargeUI", "hy: function info is null");
            C23639t.makeText(this, "function info is null", 1).show();
            finish();
        }
        cel();
        setMMTitle(this.pHj.cOI);
        setBackBtn(new C215851());
        this.pGn = new C40050e();
        this.pGn.name = getString(C25738R.string.fr1);
        this.pGn.url = getString(C25738R.string.fr2);
        this.pGT = findViewById(2131826525);
        this.pGU = (ImageView) findViewById(2131826527);
        this.pGV = (TextView) findViewById(2131826526);
        this.pGW = (MallFormView) findViewById(2131826529);
        C39575c.m67643b(this.pGW);
        this.pHo = new C28818b(this.pGW);
        C28818b c28818b = this.pHo;
        C4990ab.m7410d(C39575c.TAG, "hy: setMobileEditTv");
        MallFormView mallFormView = c28818b.pIg;
        C288191 c288191 = new C288191();
        if (mallFormView.pIm != null) {
            mallFormView.pIm.addTextChangedListener(c288191);
        }
        InstantAutoCompleteTextView instantAutoCompleteTextView = (InstantAutoCompleteTextView) c28818b.pIg.getContentEditText();
        c28818b.pGw = C46482a.m87692cJ(c28818b.pIg.getContext());
        c28818b.pIh = new C43426d(c28818b.pIg, c28818b.pGw);
        c28818b.pIh.pIU = new C288212();
        c28818b.pIh.pIV = this;
        c28818b.mo46968kd(true);
        instantAutoCompleteTextView.setShowAlways(true);
        instantAutoCompleteTextView.setAdapter(c28818b.pIh);
        instantAutoCompleteTextView.setOnItemClickListener(new C288203(instantAutoCompleteTextView));
        c28818b.pIg.setOnFocusChangeListener(new C288174(instantAutoCompleteTextView));
        instantAutoCompleteTextView.setOnClickListener(new C215915(instantAutoCompleteTextView));
        this.pGZ = (GridView) findViewById(2131826533);
        this.pHb = (TextView) findViewById(2131826540);
        this.pHc = (TextView) findViewById(2131826539);
        this.pHd = (TextView) findViewById(2131826541);
        this.pHe = (TextView) findViewById(2131826538);
        this.pGX = (TextView) findViewById(2131826531);
        this.pGY = (TextView) findViewById(2131826534);
        this.pHa = (GridView) findViewById(2131826536);
        this.pHf = (TextView) findViewById(2131826532);
        this.pHg = (TextView) findViewById(2131826535);
        this.pGW.setOnInputValidChangeListener(new C2158412());
        this.pGW.getInfoIv().setOnClickListener(new C1297315());
        this.pHh = new C12976b();
        this.pHh.pGM = new C703716();
        this.pHi = new C12976b();
        this.pHi.pGM = new C703817();
        this.pGZ.setAdapter(this.pHh);
        this.pHa.setAdapter(this.pHi);
        this.pGU.setOnClickListener(new C2158018());
        this.pGV.setOnClickListener(new C2158119());
        this.pGW.cew();
        int gd = (C1338a.m2868gd(this) / 4) - 20;
        C4990ab.m7417i("MicroMsg.PhoneRechargeUI", "max width: %s", Integer.valueOf(gd));
        this.pHb.setMaxWidth(gd);
        this.pHc.setMaxWidth(gd);
        this.pHd.setMaxWidth(gd);
        this.pHe.setMaxWidth(gd);
        this.pHl = getResources().getColor(C25738R.color.f12212w4);
        if (!(this.pHo.pGx == null || C5046bo.isNullOrNil(this.pHo.pGx.name))) {
            this.desc = this.pHo.pGx.name;
        }
        this.pGW.getContentEditText().setHintTextColor(getResources().getColor(C25738R.color.f12255xn));
        if (C5046bo.isNullOrNil(this.pGW.getText())) {
            m33044c(new C28810f(""), false);
            AppMethodBeat.m2505o(44278);
            return;
        }
        m33044c(new C28810f(this.pGW.getText()), false);
        AppMethodBeat.m2505o(44278);
    }

    public final void cen() {
        AppMethodBeat.m2504i(44295);
        C1720g.m3540Rg().mo14541a(new C28810f("", 1), 0);
        AppMethodBeat.m2505o(44295);
    }

    /* renamed from: VF */
    static /* synthetic */ void m33036VF(String str) {
        AppMethodBeat.m2504i(44297);
        C4990ab.m7417i("MicroMsg.PhoneRechargeUI", "do scene: %s", str);
        C1720g.m3540Rg().mo14541a(new C28810f(str), 0);
        AppMethodBeat.m2505o(44297);
    }

    /* renamed from: a */
    static /* synthetic */ boolean m33040a(PhoneRechargeUI phoneRechargeUI, String str, String str2) {
        AppMethodBeat.m2504i(44300);
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(44300);
            return false;
        }
        CharSequence charSequence = "";
        CharSequence charSequence2 = "";
        CharSequence charSequence3 = "";
        if (!(phoneRechargeUI.pHo == null || phoneRechargeUI.pHo.pGx == null || C5046bo.isNullOrNil(phoneRechargeUI.pHo.pGx.name))) {
            C43420a c43420a = phoneRechargeUI.pHo.pGx;
            charSequence = c43420a.pFM;
            charSequence2 = c43420a.name;
            charSequence3 = c43420a.cvp == 3 ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        C4990ab.m7417i("MicroMsg.PhoneRechargeUI", "weappID: %s, weappPath: %s", str, str2.replace("{phone}", charSequence).replace("{remark}", charSequence2).replace("{isbind}", charSequence3));
        C32628se c32628se = new C32628se();
        c32628se.cOf.userName = str;
        c32628se.cOf.cOh = C5046bo.m7532bc(r0, "");
        c32628se.cOf.scene = FilterEnum4Shaka.MIC_WEISHI_v4_4_XINXIAN;
        c32628se.cOf.cOi = 0;
        C4879a.xxA.mo10055m(c32628se);
        AppMethodBeat.m2505o(44300);
        return true;
    }

    /* renamed from: d */
    static /* synthetic */ void m33048d(PhoneRechargeUI phoneRechargeUI, String str) {
        AppMethodBeat.m2504i(44304);
        phoneRechargeUI.m33044c(new C39571g(phoneRechargeUI.mAppId, phoneRechargeUI.pHj.pFP, str, "mobile=" + C43421b.m77507ws(phoneRechargeUI.pGW.getText()) + "&markup=" + (phoneRechargeUI.pHo.pGx != null ? phoneRechargeUI.pHo.pGx.name : "")), true);
        AppMethodBeat.m2505o(44304);
    }

    /* renamed from: g */
    static /* synthetic */ void m33052g(PhoneRechargeUI phoneRechargeUI) {
        AppMethodBeat.m2504i(44305);
        if (phoneRechargeUI.pHp != null) {
            Object valueOf;
            String str = (String) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_PHONE_RECHARGE_CLOSED_BANNER_STRING, (Object) "");
            if (C5046bo.isNullOrNil(str)) {
                valueOf = String.valueOf(phoneRechargeUI.pHp.f2951id);
            } else {
                valueOf = str + ";" + phoneRechargeUI.pHp.f2951id;
            }
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_PHONE_RECHARGE_CLOSED_BANNER_STRING, valueOf);
            C1720g.m3536RP().mo5239Ry().dsb();
        }
        AppMethodBeat.m2505o(44305);
    }
}
