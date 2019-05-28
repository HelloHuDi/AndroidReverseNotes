package com.tencent.mm.plugin.wallet.balance.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet.balance.a.e;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.d.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.g;
import com.tencent.mm.plugin.wallet_core.ui.j;
import com.tencent.mm.plugin.wallet_core.ui.view.c;
import com.tencent.mm.pluginsdk.wallet.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.c.ad;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.c.z;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@a(2)
public class WalletBalanceSaveUI extends WalletBaseUI {
    protected Button gHn;
    private final int gnS = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 270);
    private View jcl;
    protected WalletFormView kGa;
    protected double pQV;
    private HashMap<String, Integer> pas = new HashMap();
    private ArrayList<Bankcard> tgB;
    protected Bankcard tgC;
    private String tgD;
    protected LinearLayout tgF;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletBalanceSaveUI() {
        AppMethodBeat.i(45479);
        AppMethodBeat.o(45479);
    }

    static /* synthetic */ void f(WalletBalanceSaveUI walletBalanceSaveUI) {
        AppMethodBeat.i(45488);
        walletBalanceSaveUI.cu();
        AppMethodBeat.o(45488);
    }

    public boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(45480);
        if (i == 0 && i2 == 0) {
            if (mVar instanceof e) {
                boolean a;
                e eVar = (e) mVar;
                if ("1".equals(eVar.cRb)) {
                    ab.i("MicroMsg.WalletBalanceSaveUI", "need realname verify");
                    Bundle bundle = new Bundle();
                    bundle.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceSaveUI");
                    bundle.putString("realname_verify_process_jump_plugin", "wallet");
                    bwP();
                    a = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, bundle, null, 0);
                } else if ("2".equals(eVar.cRb)) {
                    ab.i("MicroMsg.WalletBalanceSaveUI", "need upload credit");
                    a = com.tencent.mm.plugin.wallet_core.id_verify.util.a.a((Activity) this, eVar.cRc, eVar.cRf, eVar.cRd, eVar.cRe, bwP(), null);
                } else {
                    ab.i("MicroMsg.WalletBalanceSaveUI", "realnameGuideFlag =  " + eVar.cRb);
                    a = false;
                }
                if (a) {
                    AppMethodBeat.o(45480);
                } else {
                    String str2;
                    String str3 = ((e) mVar).cBT;
                    ad.o(11, str3, i2);
                    if (this.tgC == null) {
                        str2 = "";
                    } else {
                        str2 = this.tgC.field_bindSerial;
                    }
                    h.a(this, str2, str3, "", 11, 1);
                }
            } else if (mVar instanceof y) {
                cfk();
                cu();
            }
            AppMethodBeat.o(45480);
        } else {
            if (mVar instanceof e) {
                ad.o(11, "", i2);
            }
            AppMethodBeat.o(45480);
        }
        return false;
    }

    private void cfk() {
        int i;
        AppMethodBeat.i(45481);
        s.cNC();
        ak cND = s.cND();
        this.tgB = cND.cQD();
        this.tgC = cND.a(this.tgB, null, false, true);
        if (this.tgC != null && bo.isNullOrNil(this.tgC.field_forbidWord)) {
            this.tgC = null;
            i = 0;
            while (i < this.tgB.size()) {
                if (this.tgB.get(i) != null && bo.isNullOrNil(((Bankcard) this.tgB.get(i)).field_forbidWord)) {
                    this.tgC = (Bankcard) this.tgB.get(i);
                    break;
                }
                i++;
            }
        }
        if (!(this.tgC == null || bo.isNullOrNil(this.tgC.field_forbidWord))) {
            this.tgC = null;
        }
        ArrayList arrayList = this.tgB;
        if (arrayList != null) {
            for (i = 0; i < arrayList.size(); i++) {
                ab.v("MicroMsg.WalletBalanceSaveUI", "pos %s word %s", Integer.valueOf(i), ((Bankcard) arrayList.get(i)).field_forbidWord);
            }
        }
        AppMethodBeat.o(45481);
    }

    public final int getLayoutId() {
        return R.layout.b31;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(45482);
        super.onCreate(bundle);
        if (!r.YM()) {
            a(new com.tencent.mm.plugin.wallet_core.c.ab(), false, false);
        }
        cfk();
        this.tgD = getString(R.string.f9t);
        initView();
        cu();
        z.hL(3, 0);
        AppMethodBeat.o(45482);
    }

    public final void initView() {
        AppMethodBeat.i(45483);
        setMMTitle((int) R.string.f9z);
        this.jcl = findViewById(R.id.f6w);
        this.kGa = (WalletFormView) findViewById(R.id.ay4);
        com.tencent.mm.wallet_core.ui.formview.a.f(this.kGa);
        this.kGa.getTitleTv().setText(ae.dOd());
        e(this.kGa, 2, false);
        this.gHn = (Button) findViewById(R.id.ay8);
        this.gHn.setOnClickListener(new com.tencent.mm.ui.s() {
            public final void bgW() {
                AppMethodBeat.i(45469);
                WalletBalanceSaveUI.this.pQV = bo.getDouble(WalletBalanceSaveUI.this.kGa.getText(), 0.0d);
                if (WalletBalanceSaveUI.this.pQV <= 0.0d || !WalletBalanceSaveUI.this.kGa.asa()) {
                    t.makeText(WalletBalanceSaveUI.this.mController.ylL, R.string.f9y, 0).show();
                    AppMethodBeat.o(45469);
                    return;
                }
                WalletBalanceSaveUI.this.cNd();
                AppMethodBeat.o(45469);
            }
        });
        this.tgF = (LinearLayout) findViewById(R.id.f5y);
        if (this.tgF != null) {
            this.tgF.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(45470);
                    WalletBalanceSaveUI.a(WalletBalanceSaveUI.this);
                    AppMethodBeat.o(45470);
                }
            });
        }
        this.obM = new com.tencent.mm.wallet_core.ui.a() {
            public final void ic(boolean z) {
                AppMethodBeat.i(45471);
                if (z) {
                    WalletBalanceSaveUI.b(WalletBalanceSaveUI.this);
                    AppMethodBeat.o(45471);
                    return;
                }
                WalletBalanceSaveUI.this.jcl.scrollTo(0, 0);
                AppMethodBeat.o(45471);
            }
        };
        AppMethodBeat.o(45483);
    }

    private void cu() {
        AppMethodBeat.i(45484);
        if (this.tgF != null) {
            if (this.tgC != null) {
                final ImageView imageView = (ImageView) this.tgF.findViewById(R.id.f60);
                String str = "";
                com.tencent.mm.plugin.wallet_core.model.e i = b.i(this, this.tgC.field_bankcardType, this.tgC.cPb());
                if (i != null) {
                    str = i.oRi;
                }
                imageView.setImageBitmap(null);
                if (this.tgC.cPc()) {
                    imageView.setBackgroundResource(R.drawable.bki);
                } else {
                    Bitmap a = x.a(new c(str));
                    x.a(new x.a() {
                        public final void m(String str, final Bitmap bitmap) {
                            AppMethodBeat.i(45478);
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(45477);
                                    if (!(WalletBalanceSaveUI.this.tgC == null || imageView == null || imageView.getTag() == null || !imageView.getTag().equals(WalletBalanceSaveUI.this.tgC.field_bindSerial))) {
                                        imageView.setImageBitmap(bitmap);
                                    }
                                    AppMethodBeat.o(45477);
                                }
                            });
                            AppMethodBeat.o(45478);
                        }
                    });
                    if (!(a == null || a == null)) {
                        imageView.setImageBitmap(d.a(a, getResources().getDimensionPixelOffset(R.dimen.aaq), getResources().getDimensionPixelOffset(R.dimen.aaq), true, false));
                    }
                }
                ((TextView) this.tgF.findViewById(R.id.f61)).setText(getString(R.string.f9r, new Object[]{this.tgC.field_bankName, this.tgC.field_bankcardTail}));
                ((TextView) this.tgF.findViewById(R.id.dc)).setText(this.tgC.field_bankcardTypeName);
                if (bo.isNullOrNil(this.tgC.field_avail_save_wording)) {
                    ab.i("MicroMsg.WalletBalanceSaveUI", "hy: wording's missing. use default");
                    ((TextView) this.tgF.findViewById(R.id.f62)).setText("");
                    AppMethodBeat.o(45484);
                    return;
                }
                ((TextView) this.tgF.findViewById(R.id.f62)).setText(this.tgC.field_avail_save_wording);
                AppMethodBeat.o(45484);
                return;
            }
            ((TextView) this.tgF.findViewById(R.id.f61)).setText(this.tgD);
            ((TextView) this.tgF.findViewById(R.id.f62)).setText("");
            ((ImageView) this.tgF.findViewById(R.id.f60)).setImageBitmap(null);
            ((TextView) this.tgF.findViewById(R.id.dc)).setText(getString(R.string.f9q));
        }
        AppMethodBeat.o(45484);
    }

    /* Access modifiers changed, original: protected */
    public void cNd() {
        AppMethodBeat.i(45485);
        if (this.tgC != null) {
            a(new e(this.pQV, "CNY", this.tgC.field_bindSerial, this.tgC.field_bankcardType), true, true);
            AppMethodBeat.o(45485);
            return;
        }
        g cPl = g.cPl();
        if (cPl.aFF()) {
            com.tencent.mm.ui.base.h.b((Context) this, cPl.pbp, getString(R.string.tz), true);
            AppMethodBeat.o(45485);
            return;
        }
        a(new e(this.pQV, "CNY", "", ""), true, true);
        AppMethodBeat.o(45485);
    }

    public final int getForceOrientation() {
        return 1;
    }

    static /* synthetic */ void a(WalletBalanceSaveUI walletBalanceSaveUI) {
        List linkedList;
        AppMethodBeat.i(45486);
        walletBalanceSaveUI.pas.clear();
        final com.tencent.mm.ui.widget.d dVar = new com.tencent.mm.ui.widget.d(walletBalanceSaveUI, 2, true);
        if (walletBalanceSaveUI.tgB == null) {
            linkedList = new LinkedList();
        } else {
            Object linkedList2 = walletBalanceSaveUI.tgB;
        }
        int size = linkedList2.size();
        for (int i = 0; i < linkedList2.size(); i++) {
            Bankcard bankcard = (Bankcard) linkedList2.get(i);
            if (!(walletBalanceSaveUI.tgC == null || bo.isNullOrNil(bankcard.field_bindSerial) || !walletBalanceSaveUI.tgC.field_bindSerial.equals(bankcard.field_bindSerial))) {
                size = i;
            }
        }
        dVar.rBl = new n.c() {
            public final void a(final l lVar) {
                AppMethodBeat.i(45474);
                int size = linkedList2.size();
                for (int i = 0; i < size; i++) {
                    String str;
                    CharSequence spannableString;
                    String str2;
                    Bankcard bankcard = (Bankcard) linkedList2.get(i);
                    String str3 = "";
                    com.tencent.mm.plugin.wallet_core.model.e i2 = b.i(WalletBalanceSaveUI.this, bankcard.field_bankcardType, bankcard.cPb());
                    if (i2 != null) {
                        str = i2.oRi;
                    } else {
                        str = str3;
                    }
                    Bitmap a = x.a(new c(str));
                    x.a(new x.a() {
                        public final void m(final String str, final Bitmap bitmap) {
                            AppMethodBeat.i(45473);
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(45472);
                                    ab.i("MicroMsg.WalletBalanceSaveUI", "dancy test get picture finish, notifyKey:%s, finalIconUrl:%s", str, str);
                                    if (WalletBalanceSaveUI.this.pas.containsKey(str)) {
                                        int intValue = ((Integer) WalletBalanceSaveUI.this.pas.get(str)).intValue();
                                        if (lVar.getItem(intValue) != null) {
                                            lVar.getItem(intValue).setIcon(new BitmapDrawable(d.a(bitmap, WalletBalanceSaveUI.this.getResources().getDimensionPixelOffset(R.dimen.aaq), WalletBalanceSaveUI.this.getResources().getDimensionPixelOffset(R.dimen.aaq), true, false)));
                                            dVar.dKX();
                                        }
                                    }
                                    AppMethodBeat.o(45472);
                                }
                            });
                            AppMethodBeat.o(45473);
                        }
                    });
                    Bitmap bitmap = null;
                    CharSequence charSequence = "";
                    if (!bo.isNullOrNil(bankcard.field_forbidWord)) {
                        charSequence = bankcard.field_forbidWord;
                    }
                    if (bo.isNullOrNil(bankcard.field_forbid_title)) {
                        spannableString = new SpannableString(charSequence);
                        str2 = charSequence;
                    } else {
                        str3 = charSequence + " ";
                        spannableString = new SpannableString(str3 + bankcard.field_forbid_title);
                        AnonymousClass2 anonymousClass2 = new j(WalletBalanceSaveUI.this) {
                            public final void onClick(View view) {
                            }
                        };
                        int length = str3.length();
                        int length2 = str3.length() + bankcard.field_forbid_title.length();
                        spannableString.setSpan(new ForegroundColorSpan(WalletBalanceSaveUI.this.getResources().getColor(R.color.a50)), length, length2, 33);
                        spannableString.setSpan(anonymousClass2, length, length2, 33);
                        str2 = str3;
                    }
                    str3 = bankcard.field_desc;
                    if (bankcard.cPc()) {
                        ab.i("MicroMsg.WalletBalanceSaveUI", "i %d fee %s %s", Integer.valueOf(i), str3, spannableString);
                        lVar.a(i, str3, spannableString, WalletBalanceSaveUI.this.getResources().getDrawable(R.drawable.bki), !bo.isNullOrNil(str2));
                    } else {
                        if (a != null) {
                            bitmap = d.a(a, WalletBalanceSaveUI.this.getResources().getDimensionPixelOffset(R.dimen.aaq), WalletBalanceSaveUI.this.getResources().getDimensionPixelOffset(R.dimen.aaq), true, false);
                        }
                        ab.i("MicroMsg.WalletBalanceSaveUI", "i %d fee %s %s", Integer.valueOf(i), str3, spannableString);
                        lVar.a(i, str3, spannableString, bitmap == null ? null : new BitmapDrawable(bitmap), !bo.isNullOrNil(str2));
                    }
                    if (bitmap == null) {
                        WalletBalanceSaveUI.this.pas.put(str, Integer.valueOf(i));
                    }
                }
                lVar.a(size, WalletBalanceSaveUI.this.getString(R.string.f9t), "", WalletBalanceSaveUI.this.getResources().getDrawable(R.drawable.bkc), false);
                AppMethodBeat.o(45474);
            }
        };
        dVar.rBm = new n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                AppMethodBeat.i(45475);
                if (dVar != null) {
                    dVar.cpE();
                    if (i < linkedList2.size()) {
                        WalletBalanceSaveUI.this.tgC = (Bankcard) WalletBalanceSaveUI.this.tgB.get(i);
                        WalletBalanceSaveUI.f(WalletBalanceSaveUI.this);
                        AppMethodBeat.o(45475);
                        return;
                    }
                    WalletBalanceSaveUI.this.tgC = null;
                    WalletBalanceSaveUI.f(WalletBalanceSaveUI.this);
                }
                AppMethodBeat.o(45475);
            }
        };
        View inflate = View.inflate(walletBalanceSaveUI, R.layout.b2u, null);
        inflate.findViewById(R.id.f5q).setVisibility(8);
        ((TextView) inflate.findViewById(R.id.f5p)).setText(R.string.f8f);
        dVar.pIf = true;
        dVar.zQA = size;
        dVar.zQy = true;
        dVar.F(inflate, false);
        dVar.cpD();
        AppMethodBeat.o(45486);
    }

    static /* synthetic */ void b(WalletBalanceSaveUI walletBalanceSaveUI) {
        AppMethodBeat.i(45487);
        if (walletBalanceSaveUI.jcl != null) {
            final int i;
            int[] iArr = new int[2];
            walletBalanceSaveUI.gHn.getLocationInWindow(iArr);
            int ge = (com.tencent.mm.bz.a.ge(walletBalanceSaveUI) - i) - com.tencent.mm.bz.a.fromDPToPix(walletBalanceSaveUI, 30);
            ab.d("MicroMsg.WalletBalanceSaveUI", "scrollToFormEditPosAfterShowTenPay, editText locationY: %s, height: %s, diff: %s, hardcodeKeyboardHeight: %s", Integer.valueOf(iArr[1] + walletBalanceSaveUI.gHn.getHeight()), Integer.valueOf(com.tencent.mm.bz.a.ge(walletBalanceSaveUI)), Integer.valueOf(ge), Integer.valueOf(walletBalanceSaveUI.gnS));
            if (ge > 0 && ge < walletBalanceSaveUI.gnS) {
                i = walletBalanceSaveUI.gnS - ge;
                ab.d("MicroMsg.WalletBalanceSaveUI", "scrollToFormEditPosAfterShowTenPay, scrollDistance: %s", Integer.valueOf(i));
                walletBalanceSaveUI.jcl.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(45476);
                        WalletBalanceSaveUI.this.jcl.scrollBy(0, i);
                        AppMethodBeat.o(45476);
                    }
                });
            }
        }
        AppMethodBeat.o(45487);
    }
}
