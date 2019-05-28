package com.tencent.p177mm.plugin.wallet.balance.p552ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C24019s;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.widget.C16001d;
import com.tencent.p177mm.platformtools.C18764x;
import com.tencent.p177mm.platformtools.C18764x.C18765a;
import com.tencent.p177mm.plugin.wallet.balance.p550a.C46340e;
import com.tencent.p177mm.plugin.wallet.p748a.C46332s;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.C43795a;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.plugin.wallet_core.model.C22587ak;
import com.tencent.p177mm.plugin.wallet_core.model.C43807e;
import com.tencent.p177mm.plugin.wallet_core.model.C43809g;
import com.tencent.p177mm.plugin.wallet_core.p1313d.C46362b;
import com.tencent.p177mm.plugin.wallet_core.p561ui.C46373j;
import com.tencent.p177mm.plugin.wallet_core.p561ui.view.C4467c;
import com.tencent.p177mm.plugin.wallet_core.p749c.C35475y;
import com.tencent.p177mm.plugin.wallet_core.p749c.C43785ab;
import com.tencent.p177mm.pluginsdk.wallet.C35899h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import com.tencent.p177mm.wallet_core.p649c.C36381z;
import com.tencent.p177mm.wallet_core.p649c.C44422ad;
import com.tencent.p177mm.wallet_core.p649c.C44423ae;
import com.tencent.p177mm.wallet_core.p650ui.C40947a;
import com.tencent.p177mm.wallet_core.p650ui.WalletBaseUI;
import com.tencent.p177mm.wallet_core.p650ui.formview.C30890a;
import com.tencent.p177mm.wallet_core.p650ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@C5271a(2)
/* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI */
public class WalletBalanceSaveUI extends WalletBaseUI {
    protected Button gHn;
    private final int gnS = C1338a.fromDPToPix(C4996ah.getContext(), 270);
    private View jcl;
    protected WalletFormView kGa;
    protected double pQV;
    private HashMap<String, Integer> pas = new HashMap();
    private ArrayList<Bankcard> tgB;
    protected Bankcard tgC;
    private String tgD;
    protected LinearLayout tgF;

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI$1 */
    class C141341 extends C24019s {
        C141341() {
        }

        public final void bgW() {
            AppMethodBeat.m2504i(45469);
            WalletBalanceSaveUI.this.pQV = C5046bo.getDouble(WalletBalanceSaveUI.this.kGa.getText(), 0.0d);
            if (WalletBalanceSaveUI.this.pQV <= 0.0d || !WalletBalanceSaveUI.this.kGa.asa()) {
                C23639t.makeText(WalletBalanceSaveUI.this.mController.ylL, C25738R.string.f9y, 0).show();
                AppMethodBeat.m2505o(45469);
                return;
            }
            WalletBalanceSaveUI.this.cNd();
            AppMethodBeat.m2505o(45469);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI$3 */
    class C141383 implements C40947a {
        C141383() {
        }

        /* renamed from: ic */
        public final void mo9448ic(boolean z) {
            AppMethodBeat.m2504i(45471);
            if (z) {
                WalletBalanceSaveUI.m22295b(WalletBalanceSaveUI.this);
                AppMethodBeat.m2505o(45471);
                return;
            }
            WalletBalanceSaveUI.this.jcl.scrollTo(0, 0);
            AppMethodBeat.m2505o(45471);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceSaveUI$2 */
    class C141392 implements OnClickListener {
        C141392() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(45470);
            WalletBalanceSaveUI.m22294a(WalletBalanceSaveUI.this);
            AppMethodBeat.m2505o(45470);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public WalletBalanceSaveUI() {
        AppMethodBeat.m2504i(45479);
        AppMethodBeat.m2505o(45479);
    }

    /* renamed from: f */
    static /* synthetic */ void m22300f(WalletBalanceSaveUI walletBalanceSaveUI) {
        AppMethodBeat.m2504i(45488);
        walletBalanceSaveUI.m22297cu();
        AppMethodBeat.m2505o(45488);
    }

    /* renamed from: c */
    public boolean mo7885c(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(45480);
        if (i == 0 && i2 == 0) {
            if (c1207m instanceof C46340e) {
                boolean a;
                C46340e c46340e = (C46340e) c1207m;
                if ("1".equals(c46340e.cRb)) {
                    C4990ab.m7416i("MicroMsg.WalletBalanceSaveUI", "need realname verify");
                    Bundle bundle = new Bundle();
                    bundle.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceSaveUI");
                    bundle.putString("realname_verify_process_jump_plugin", "wallet");
                    bwP();
                    a = C43795a.m78493a(this, bundle, null, 0);
                } else if ("2".equals(c46340e.cRb)) {
                    C4990ab.m7416i("MicroMsg.WalletBalanceSaveUI", "need upload credit");
                    a = C43795a.m78495a((Activity) this, c46340e.cRc, c46340e.cRf, c46340e.cRd, c46340e.cRe, bwP(), null);
                } else {
                    C4990ab.m7416i("MicroMsg.WalletBalanceSaveUI", "realnameGuideFlag =  " + c46340e.cRb);
                    a = false;
                }
                if (a) {
                    AppMethodBeat.m2505o(45480);
                } else {
                    String str2;
                    String str3 = ((C46340e) c1207m).cBT;
                    C44422ad.m80307o(11, str3, i2);
                    if (this.tgC == null) {
                        str2 = "";
                    } else {
                        str2 = this.tgC.field_bindSerial;
                    }
                    C35899h.m58855a(this, str2, str3, "", 11, 1);
                }
            } else if (c1207m instanceof C35475y) {
                cfk();
                m22297cu();
            }
            AppMethodBeat.m2505o(45480);
        } else {
            if (c1207m instanceof C46340e) {
                C44422ad.m80307o(11, "", i2);
            }
            AppMethodBeat.m2505o(45480);
        }
        return false;
    }

    private void cfk() {
        int i;
        AppMethodBeat.m2504i(45481);
        C46332s.cNC();
        C22587ak cND = C46332s.cND();
        this.tgB = cND.cQD();
        this.tgC = cND.mo38130a(this.tgB, null, false, true);
        if (this.tgC != null && C5046bo.isNullOrNil(this.tgC.field_forbidWord)) {
            this.tgC = null;
            i = 0;
            while (i < this.tgB.size()) {
                if (this.tgB.get(i) != null && C5046bo.isNullOrNil(((Bankcard) this.tgB.get(i)).field_forbidWord)) {
                    this.tgC = (Bankcard) this.tgB.get(i);
                    break;
                }
                i++;
            }
        }
        if (!(this.tgC == null || C5046bo.isNullOrNil(this.tgC.field_forbidWord))) {
            this.tgC = null;
        }
        ArrayList arrayList = this.tgB;
        if (arrayList != null) {
            for (i = 0; i < arrayList.size(); i++) {
                C4990ab.m7419v("MicroMsg.WalletBalanceSaveUI", "pos %s word %s", Integer.valueOf(i), ((Bankcard) arrayList.get(i)).field_forbidWord);
            }
        }
        AppMethodBeat.m2505o(45481);
    }

    public final int getLayoutId() {
        return 2130971053;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(45482);
        super.onCreate(bundle);
        if (!C1853r.m3831YM()) {
            mo39970a(new C43785ab(), false, false);
        }
        cfk();
        this.tgD = getString(C25738R.string.f9t);
        initView();
        m22297cu();
        C36381z.m59954hL(3, 0);
        AppMethodBeat.m2505o(45482);
    }

    public final void initView() {
        AppMethodBeat.m2504i(45483);
        setMMTitle((int) C25738R.string.f9z);
        this.jcl = findViewById(2131828642);
        this.kGa = (WalletFormView) findViewById(2131822842);
        C30890a.m49301f(this.kGa);
        this.kGa.getTitleTv().setText(C44423ae.dOd());
        mo39989e(this.kGa, 2, false);
        this.gHn = (Button) findViewById(2131822846);
        this.gHn.setOnClickListener(new C141341());
        this.tgF = (LinearLayout) findViewById(2131828607);
        if (this.tgF != null) {
            this.tgF.setOnClickListener(new C141392());
        }
        this.obM = new C141383();
        AppMethodBeat.m2505o(45483);
    }

    /* renamed from: cu */
    private void m22297cu() {
        AppMethodBeat.m2504i(45484);
        if (this.tgF != null) {
            if (this.tgC != null) {
                final ImageView imageView = (ImageView) this.tgF.findViewById(2131828609);
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
                            AppMethodBeat.m2504i(45478);
                            C5004al.m7441d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(45477);
                                    if (!(WalletBalanceSaveUI.this.tgC == null || imageView == null || imageView.getTag() == null || !imageView.getTag().equals(WalletBalanceSaveUI.this.tgC.field_bindSerial))) {
                                        imageView.setImageBitmap(bitmap);
                                    }
                                    AppMethodBeat.m2505o(45477);
                                }
                            });
                            AppMethodBeat.m2505o(45478);
                        }
                    });
                    if (!(a == null || a == null)) {
                        imageView.setImageBitmap(C5056d.m7615a(a, getResources().getDimensionPixelOffset(C25738R.dimen.aaq), getResources().getDimensionPixelOffset(C25738R.dimen.aaq), true, false));
                    }
                }
                ((TextView) this.tgF.findViewById(2131828610)).setText(getString(C25738R.string.f9r, new Object[]{this.tgC.field_bankName, this.tgC.field_bankcardTail}));
                ((TextView) this.tgF.findViewById(2131820694)).setText(this.tgC.field_bankcardTypeName);
                if (C5046bo.isNullOrNil(this.tgC.field_avail_save_wording)) {
                    C4990ab.m7416i("MicroMsg.WalletBalanceSaveUI", "hy: wording's missing. use default");
                    ((TextView) this.tgF.findViewById(2131828611)).setText("");
                    AppMethodBeat.m2505o(45484);
                    return;
                }
                ((TextView) this.tgF.findViewById(2131828611)).setText(this.tgC.field_avail_save_wording);
                AppMethodBeat.m2505o(45484);
                return;
            }
            ((TextView) this.tgF.findViewById(2131828610)).setText(this.tgD);
            ((TextView) this.tgF.findViewById(2131828611)).setText("");
            ((ImageView) this.tgF.findViewById(2131828609)).setImageBitmap(null);
            ((TextView) this.tgF.findViewById(2131820694)).setText(getString(C25738R.string.f9q));
        }
        AppMethodBeat.m2505o(45484);
    }

    /* Access modifiers changed, original: protected */
    public void cNd() {
        AppMethodBeat.m2504i(45485);
        if (this.tgC != null) {
            mo39970a(new C46340e(this.pQV, "CNY", this.tgC.field_bindSerial, this.tgC.field_bankcardType), true, true);
            AppMethodBeat.m2505o(45485);
            return;
        }
        C43809g cPl = C43809g.cPl();
        if (cPl.aFF()) {
            C30379h.m48461b((Context) this, cPl.pbp, getString(C25738R.string.f9238tz), true);
            AppMethodBeat.m2505o(45485);
            return;
        }
        mo39970a(new C46340e(this.pQV, "CNY", "", ""), true, true);
        AppMethodBeat.m2505o(45485);
    }

    public final int getForceOrientation() {
        return 1;
    }

    /* renamed from: a */
    static /* synthetic */ void m22294a(WalletBalanceSaveUI walletBalanceSaveUI) {
        List linkedList;
        AppMethodBeat.m2504i(45486);
        walletBalanceSaveUI.pas.clear();
        final C16001d c16001d = new C16001d(walletBalanceSaveUI, 2, true);
        if (walletBalanceSaveUI.tgB == null) {
            linkedList = new LinkedList();
        } else {
            Object linkedList2 = walletBalanceSaveUI.tgB;
        }
        int size = linkedList2.size();
        for (int i = 0; i < linkedList2.size(); i++) {
            Bankcard bankcard = (Bankcard) linkedList2.get(i);
            if (!(walletBalanceSaveUI.tgC == null || C5046bo.isNullOrNil(bankcard.field_bindSerial) || !walletBalanceSaveUI.tgC.field_bindSerial.equals(bankcard.field_bindSerial))) {
                size = i;
            }
        }
        c16001d.rBl = new C36073c() {
            /* renamed from: a */
            public final void mo5746a(final C44273l c44273l) {
                AppMethodBeat.m2504i(45474);
                int size = linkedList2.size();
                for (int i = 0; i < size; i++) {
                    String str;
                    CharSequence spannableString;
                    String str2;
                    Bankcard bankcard = (Bankcard) linkedList2.get(i);
                    String str3 = "";
                    C43807e i2 = C46362b.m87144i(WalletBalanceSaveUI.this, bankcard.field_bankcardType, bankcard.cPb());
                    if (i2 != null) {
                        str = i2.oRi;
                    } else {
                        str = str3;
                    }
                    Bitmap a = C18764x.m29325a(new C4467c(str));
                    C18764x.m29326a(new C18765a() {
                        /* renamed from: m */
                        public final void mo8136m(final String str, final Bitmap bitmap) {
                            AppMethodBeat.m2504i(45473);
                            C5004al.m7441d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(45472);
                                    C4990ab.m7417i("MicroMsg.WalletBalanceSaveUI", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", str, str);
                                    if (WalletBalanceSaveUI.this.pas.containsKey(str)) {
                                        int intValue = ((Integer) WalletBalanceSaveUI.this.pas.get(str)).intValue();
                                        if (c44273l.getItem(intValue) != null) {
                                            c44273l.getItem(intValue).setIcon(new BitmapDrawable(C5056d.m7615a(bitmap, WalletBalanceSaveUI.this.getResources().getDimensionPixelOffset(C25738R.dimen.aaq), WalletBalanceSaveUI.this.getResources().getDimensionPixelOffset(C25738R.dimen.aaq), true, false)));
                                            c16001d.dKX();
                                        }
                                    }
                                    AppMethodBeat.m2505o(45472);
                                }
                            });
                            AppMethodBeat.m2505o(45473);
                        }
                    });
                    Bitmap bitmap = null;
                    CharSequence charSequence = "";
                    if (!C5046bo.isNullOrNil(bankcard.field_forbidWord)) {
                        charSequence = bankcard.field_forbidWord;
                    }
                    if (C5046bo.isNullOrNil(bankcard.field_forbid_title)) {
                        spannableString = new SpannableString(charSequence);
                        str2 = charSequence;
                    } else {
                        str3 = charSequence + " ";
                        spannableString = new SpannableString(str3 + bankcard.field_forbid_title);
                        C141292 c141292 = new C46373j(WalletBalanceSaveUI.this) {
                            public final void onClick(View view) {
                            }
                        };
                        int length = str3.length();
                        int length2 = str3.length() + bankcard.field_forbid_title.length();
                        spannableString.setSpan(new ForegroundColorSpan(WalletBalanceSaveUI.this.getResources().getColor(C25738R.color.a50)), length, length2, 33);
                        spannableString.setSpan(c141292, length, length2, 33);
                        str2 = str3;
                    }
                    str3 = bankcard.field_desc;
                    if (bankcard.cPc()) {
                        C4990ab.m7417i("MicroMsg.WalletBalanceSaveUI", "i %d fee %s %s", Integer.valueOf(i), str3, spannableString);
                        c44273l.mo70053a(i, str3, spannableString, WalletBalanceSaveUI.this.getResources().getDrawable(C25738R.drawable.bki), !C5046bo.isNullOrNil(str2));
                    } else {
                        if (a != null) {
                            bitmap = C5056d.m7615a(a, WalletBalanceSaveUI.this.getResources().getDimensionPixelOffset(C25738R.dimen.aaq), WalletBalanceSaveUI.this.getResources().getDimensionPixelOffset(C25738R.dimen.aaq), true, false);
                        }
                        C4990ab.m7417i("MicroMsg.WalletBalanceSaveUI", "i %d fee %s %s", Integer.valueOf(i), str3, spannableString);
                        c44273l.mo70053a(i, str3, spannableString, bitmap == null ? null : new BitmapDrawable(bitmap), !C5046bo.isNullOrNil(str2));
                    }
                    if (bitmap == null) {
                        WalletBalanceSaveUI.this.pas.put(str, Integer.valueOf(i));
                    }
                }
                c44273l.mo70053a(size, WalletBalanceSaveUI.this.getString(C25738R.string.f9t), "", WalletBalanceSaveUI.this.getResources().getDrawable(C25738R.drawable.bkc), false);
                AppMethodBeat.m2505o(45474);
            }
        };
        c16001d.rBm = new C5279d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.m2504i(45475);
                if (c16001d != null) {
                    c16001d.cpE();
                    if (i < linkedList2.size()) {
                        WalletBalanceSaveUI.this.tgC = (Bankcard) WalletBalanceSaveUI.this.tgB.get(i);
                        WalletBalanceSaveUI.m22300f(WalletBalanceSaveUI.this);
                        AppMethodBeat.m2505o(45475);
                        return;
                    }
                    WalletBalanceSaveUI.this.tgC = null;
                    WalletBalanceSaveUI.m22300f(WalletBalanceSaveUI.this);
                }
                AppMethodBeat.m2505o(45475);
            }
        };
        View inflate = View.inflate(walletBalanceSaveUI, 2130971046, null);
        inflate.findViewById(2131828599).setVisibility(8);
        ((TextView) inflate.findViewById(2131828598)).setText(C25738R.string.f8f);
        c16001d.pIf = true;
        c16001d.zQA = size;
        c16001d.zQy = true;
        c16001d.mo57234F(inflate, false);
        c16001d.cpD();
        AppMethodBeat.m2505o(45486);
    }

    /* renamed from: b */
    static /* synthetic */ void m22295b(WalletBalanceSaveUI walletBalanceSaveUI) {
        AppMethodBeat.m2504i(45487);
        if (walletBalanceSaveUI.jcl != null) {
            final int i;
            int[] iArr = new int[2];
            walletBalanceSaveUI.gHn.getLocationInWindow(iArr);
            int ge = (C1338a.m2869ge(walletBalanceSaveUI) - i) - C1338a.fromDPToPix(walletBalanceSaveUI, 30);
            C4990ab.m7411d("MicroMsg.WalletBalanceSaveUI", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", Integer.valueOf(iArr[1] + walletBalanceSaveUI.gHn.getHeight()), Integer.valueOf(C1338a.m2869ge(walletBalanceSaveUI)), Integer.valueOf(ge), Integer.valueOf(walletBalanceSaveUI.gnS));
            if (ge > 0 && ge < walletBalanceSaveUI.gnS) {
                i = walletBalanceSaveUI.gnS - ge;
                C4990ab.m7411d("MicroMsg.WalletBalanceSaveUI", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", Integer.valueOf(i));
                walletBalanceSaveUI.jcl.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(45476);
                        WalletBalanceSaveUI.this.jcl.scrollBy(0, i);
                        AppMethodBeat.m2505o(45476);
                    }
                });
            }
        }
        AppMethodBeat.m2505o(45487);
    }
}
