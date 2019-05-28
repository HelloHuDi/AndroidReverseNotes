package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.pn;
import com.tencent.mm.g.a.um;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.c.t;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.aj;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.ui.WalletConfirmCardIDUI;
import com.tencent.mm.plugin.wallet_core.ui.j;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.ndk.Encrypt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class WalletForgotPwdUI extends WalletBaseUI implements com.tencent.mm.wallet_core.ui.formview.WalletFormView.a {
    private LinearLayout eol;
    private Button gEZ;
    private ListView gKd;
    private ArrayList<Bankcard> tlM = new ArrayList();
    c tmk = new c<um>() {
        {
            AppMethodBeat.i(46280);
            this.xxI = um.class.getName().hashCode();
            AppMethodBeat.o(46280);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(46281);
            WalletForgotPwdUI.this.finish();
            AppMethodBeat.o(46281);
            return false;
        }
    };
    private WalletFormView trA;
    private WalletFormView trB;
    private int trC = 1;
    private boolean trD = false;
    private boolean trE = false;
    c trF = new c<pn>() {
        {
            AppMethodBeat.i(46278);
            this.xxI = pn.class.getName().hashCode();
            AppMethodBeat.o(46278);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(46279);
            pn pnVar = (pn) bVar;
            if (pnVar instanceof pn) {
                Encrypt encrypt = new Encrypt();
                String randomKey = encrypt.getRandomKey();
                WalletForgotPwdUI.a(WalletForgotPwdUI.this, encrypt.desedeEncode(pnVar.cLJ.cardId, randomKey), randomKey, pnVar.cLJ.cLK);
                AppMethodBeat.o(46279);
                return true;
            }
            ab.f("MicroMsg.WalletForgotPwdUI", "mismatched scanBandkCardResultEvent event");
            AppMethodBeat.o(46279);
            return false;
        }
    };
    private List<ElementQuery> trx = new LinkedList();
    /* renamed from: try */
    private Bankcard f2try;
    private a trz;

    public class a extends BaseAdapter {
        private Context context;
        List<Bankcard> items = new ArrayList();

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(46288);
            Bankcard Hd = Hd(i);
            AppMethodBeat.o(46288);
            return Hd;
        }

        public a(Context context) {
            AppMethodBeat.i(46284);
            this.context = context;
            AppMethodBeat.o(46284);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            WalletFormView walletFormView;
            AppMethodBeat.i(46285);
            if (view == null) {
                walletFormView = (WalletFormView) View.inflate(this.context, R.layout.b32, null);
            } else {
                walletFormView = (WalletFormView) view;
            }
            final Bankcard Hd = Hd(i);
            if (Hd != null) {
                String str = Hd.field_desc;
                if (Hd.field_bankcardState == 1) {
                    str = str + this.context.getString(R.string.ffc);
                }
                walletFormView.setText(str);
            }
            walletFormView.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(46283);
                    if (Hd == null || Hd.field_bankcardState != 1) {
                        WalletForgotPwdUI.this.f2try = Hd;
                        WalletForgotPwdUI.this.trD = false;
                        WalletForgotPwdUI.a(WalletForgotPwdUI.this);
                        AppMethodBeat.o(46283);
                        return;
                    }
                    com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(a.this.context);
                    aVar.PZ(R.string.ffa);
                    aVar.Qc(R.string.ffb).a(new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(46282);
                            e.n(a.this.context, "https://kf.qq.com/touch/sappfaq/180704b6Zb2q180704IfqY3u.html?scene_id=kf1&platform=15", true);
                            AppMethodBeat.o(46282);
                        }
                    });
                    aVar.Qd(R.string.r4);
                    aVar.rc(false);
                    aVar.aMb().show();
                    AppMethodBeat.o(46283);
                }
            });
            AppMethodBeat.o(46285);
            return walletFormView;
        }

        public final int getCount() {
            AppMethodBeat.i(46286);
            int size = this.items.size();
            AppMethodBeat.o(46286);
            return size;
        }

        private Bankcard Hd(int i) {
            AppMethodBeat.i(46287);
            if (i < 0 || i > this.items.size() - 1) {
                AppMethodBeat.o(46287);
                return null;
            }
            Bankcard bankcard = (Bankcard) this.items.get(i);
            AppMethodBeat.o(46287);
            return bankcard;
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletForgotPwdUI() {
        AppMethodBeat.i(46289);
        AppMethodBeat.o(46289);
    }

    static /* synthetic */ void a(WalletForgotPwdUI walletForgotPwdUI) {
        AppMethodBeat.i(46303);
        walletForgotPwdUI.ari();
        AppMethodBeat.o(46303);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(46290);
        super.onCreate(bundle);
        setMMTitle((int) R.string.fna);
        this.trE = this.mBundle.getBoolean("key_is_force_bind", false);
        if (!this.trE) {
            a(new y(null, 6), true, true);
            AM(4);
        }
        initView();
        com.tencent.mm.sdk.b.a.xxA.c(this.trF);
        com.tencent.mm.sdk.b.a.xxA.c(this.tmk);
        AppMethodBeat.o(46290);
    }

    public void onDestroy() {
        AppMethodBeat.i(46291);
        com.tencent.mm.sdk.b.a.xxA.d(this.trF);
        com.tencent.mm.sdk.b.a.xxA.d(this.tmk);
        super.onDestroy();
        AppMethodBeat.o(46291);
    }

    public void onResume() {
        AppMethodBeat.i(46292);
        super.onResume();
        update();
        AppMethodBeat.o(46292);
    }

    private void update() {
        AppMethodBeat.i(46293);
        s.cNC();
        this.tlM = s.cND().cQB();
        if (this.tlM == null || this.tlM.size() == 0 || this.trE) {
            ab.i("MicroMsg.WalletForgotPwdUI", "No bound bankcard process %s", Boolean.valueOf(this.trE));
            this.tlM = new ArrayList();
            this.eol.setVisibility(0);
            this.gKd.setVisibility(8);
            setMMTitle((int) R.string.fei);
            ((TextView) findViewById(R.id.fa4)).setText(getString(R.string.fm8));
            WalletFormView walletFormView = this.trB;
            s.cNC();
            walletFormView.setText(e.atv(s.cND().bhp()));
            AppMethodBeat.o(46293);
            return;
        }
        ab.i("MicroMsg.WalletForgotPwdUI", "domestic process!");
        if (com.tencent.mm.wallet_core.a.aE(this) != null) {
            a(new t(), true, false);
        }
        this.eol.setVisibility(8);
        this.gEZ.setVisibility(8);
        findViewById(R.id.fa_).setVisibility(0);
        this.trz = new a(this);
        this.gKd.setAdapter(this.trz);
        this.trz.items = this.tlM;
        this.trz.notifyDataSetChanged();
        AppMethodBeat.o(46293);
    }

    public void initView() {
        AppMethodBeat.i(46294);
        this.gKd = (ListView) findViewById(R.id.fa5);
        this.eol = (LinearLayout) findViewById(R.id.fa6);
        this.trB = (WalletFormView) findViewById(R.id.f7y);
        this.trA = (WalletFormView) findViewById(R.id.fa7);
        com.tencent.mm.wallet_core.ui.formview.a.b(this.trA);
        if (this.mBundle.getBoolean("key_is_paymanager", false)) {
            com.tencent.mm.wallet_core.ui.formview.a.d(this, this.trB);
        } else {
            com.tencent.mm.wallet_core.ui.formview.a.e(this, this.trB);
        }
        this.trB.setOnInputValidChangeListener(this);
        this.trA.setOnInputValidChangeListener(this);
        this.gEZ = (Button) findViewById(R.id.ay8);
        this.gEZ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(46272);
                h.pYm.e(11353, Integer.valueOf(1), Integer.valueOf(0));
                WalletForgotPwdUI.a(WalletForgotPwdUI.this);
                AppMethodBeat.o(46272);
            }
        });
        this.trD = false;
        s.cNC();
        this.tlM = s.cND().cQB();
        update();
        findViewById(R.id.fa_).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(46273);
                e.n(WalletForgotPwdUI.this, "https://kf.qq.com/touch/scene_product.html?scene_id=kf3258", false);
                AppMethodBeat.o(46273);
            }
        });
        arW();
        a((View) this.trA, 0, false, false);
        this.trA.setOnInfoIvClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(46274);
                h.pYm.e(11353, Integer.valueOf(2), Integer.valueOf(0));
                MMActivity mMActivity = WalletForgotPwdUI.this;
                s.cNC();
                e.d(mMActivity, s.cND().bhp());
                AppMethodBeat.o(46274);
            }
        });
        this.trA.getInfoIv().setImageResource(R.raw.wallet_scan_camera);
        this.trA.getInfoIv().setVisibility(0);
        AppMethodBeat.o(46294);
    }

    private void ari() {
        AppMethodBeat.i(46296);
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_is_reset_with_new_card", this.mBundle.getBoolean("key_is_reset_with_new_card", false));
        cOC();
        if (this.f2try == null && !this.trD) {
            a(new t(null, this.trA.getText(), null), true, true);
            AppMethodBeat.o(46296);
        } else if (this.trD) {
            aj cRh = r.cPE().cRh();
            if (bo.isNullOrNil(cRh.field_find_passwd_url)) {
                bundle.putBoolean("key_is_force_bind", true);
                bundle.putBoolean("key_is_reset_with_new_card", true);
                if (dOD() != null) {
                    dOD().a((Activity) this, 0, bundle);
                }
                AppMethodBeat.o(46296);
                return;
            }
            ab.i("MicroMsg.WalletForgotPwdUI", "hy: not support bind new bankcard. start to url");
            e.n(this, cRh.field_find_passwd_url, false);
            AppMethodBeat.o(46296);
        } else {
            com.tencent.mm.wallet_core.c aE = com.tencent.mm.wallet_core.a.aE(this);
            bundle.putParcelable("key_bankcard", this.f2try);
            ElementQuery elementQuery = new ElementQuery();
            for (Parcelable parcelable : this.trx) {
                ab.i("MicroMsg.WalletForgotPwdUI", "helios:::" + parcelable.pbn);
                if (!bo.isNullOrNil(parcelable.pbn) && !bo.isNullOrNil(this.f2try.field_bankcardType) && parcelable.pbn.trim().equals(this.f2try.field_bankcardType.trim())) {
                    break;
                }
            }
            Object parcelable2 = elementQuery;
            bundle.putParcelable("elemt_query", parcelable2);
            if (aE != null) {
                aE.a((Activity) this, 0, bundle);
            }
            AppMethodBeat.o(46296);
        }
    }

    public final int getLayoutId() {
        return R.layout.b4_;
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(46297);
        ab.i("MicroMsg.WalletForgotPwdUI", " errCode: %s errMsg :  scene: ", Integer.valueOf(i2), str, mVar);
        if (i == 0 && i2 == 0) {
            String str2;
            if (mVar instanceof t) {
                t tVar = (t) mVar;
                Bundle bundle = new Bundle();
                if (bo.isNullOrNil(tVar.kaE)) {
                    this.trx = tVar.tum;
                    ab.i("MicroMsg.WalletForgotPwdUI", "scene case 1 mCardId is null");
                    AppMethodBeat.o(46297);
                    return true;
                } else if (tVar.tun == null) {
                    bundle.putString("bank_name", "");
                    bundle.putParcelable("elemt_query", new ElementQuery());
                    bundle.putString("key_card_id", this.trA.getText());
                    bundle.putBoolean("key_is_reset_with_new_card", true);
                    com.tencent.mm.wallet_core.a.j(this, bundle);
                } else if (tVar.tun.isError()) {
                    ab.i("MicroMsg.WalletForgotPwdUI", "scene case 2 mTargetElement is error");
                    com.tencent.mm.ui.base.h.g(this, R.string.f_1, R.string.tz);
                    AppMethodBeat.o(46297);
                    return true;
                } else {
                    int i3;
                    str2 = "MicroMsg.WalletForgotPwdUI";
                    String str3 = "scene case 3 bankcards size %d";
                    Object[] objArr = new Object[1];
                    if (this.tlM == null) {
                        i3 = 0;
                    } else {
                        i3 = this.tlM.size();
                    }
                    objArr[0] = Integer.valueOf(i3);
                    ab.i(str2, str3, objArr);
                    if (this.tlM == null || this.tlM.size() == 0) {
                        cOC();
                        bundle.putString("bank_name", tVar.tun.nuL);
                        bundle.putParcelable("elemt_query", tVar.tun);
                        bundle.putString("key_card_id", this.trA.getText());
                        bundle.putBoolean("key_is_reset_with_new_card", true);
                        com.tencent.mm.wallet_core.a.j(this, bundle);
                        AppMethodBeat.o(46297);
                        return true;
                    }
                }
            } else if (mVar instanceof y) {
                String str4 = "MicroMsg.WalletForgotPwdUI";
                str2 = "scene case queryBound adapter is null ? %s";
                Object[] objArr2 = new Object[1];
                objArr2[0] = Boolean.valueOf(this.trz == null);
                ab.i(str4, str2, objArr2);
                if (this.trz != null) {
                    ArrayList arrayList = null;
                    if (r.cPI() != null) {
                        arrayList = r.cPI().cQB();
                    }
                    com.tencent.mm.wallet_core.c aE = com.tencent.mm.wallet_core.a.aE(this);
                    if (aE != null) {
                        aE.dNE();
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList arrayList3 = new ArrayList();
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            Bankcard bankcard = (Bankcard) it.next();
                            if (bankcard.field_bankcardTag == 1) {
                                arrayList2.add(bankcard);
                            } else if (bankcard.field_bankcardTag == 2) {
                                arrayList3.add(bankcard);
                            }
                        }
                        if (arrayList2.size() > 0) {
                            this.tlM = arrayList2;
                        } else {
                            this.tlM = arrayList3;
                        }
                    }
                    str4 = "MicroMsg.WalletForgotPwdUI";
                    str2 = "scene case queryBound adapter update bankcardsize:  %d";
                    Object[] objArr3 = new Object[1];
                    objArr3[0] = Integer.valueOf(this.tlM == null ? 0 : this.tlM.size());
                    ab.i(str4, str2, objArr3);
                    this.trz.items = this.tlM;
                    new ak(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(46275);
                            WalletForgotPwdUI.this.trz.notifyDataSetChanged();
                            WalletForgotPwdUI.c(WalletForgotPwdUI.this);
                            AppMethodBeat.o(46275);
                        }
                    });
                }
            }
        }
        AppMethodBeat.o(46297);
        return false;
    }

    public final boolean bNf() {
        return true;
    }

    private boolean arW() {
        AppMethodBeat.i(46298);
        if (this.gKd.getVisibility() == 0 || (this.trB.asa() && this.trA.asa())) {
            this.gEZ.setEnabled(true);
            this.gEZ.setClickable(true);
            AppMethodBeat.o(46298);
            return true;
        }
        this.gEZ.setEnabled(false);
        this.gEZ.setClickable(false);
        AppMethodBeat.o(46298);
        return false;
    }

    public final void hY(boolean z) {
        AppMethodBeat.i(46299);
        arW();
        AppMethodBeat.o(46299);
    }

    public boolean cNR() {
        return true;
    }

    public final int getForceOrientation() {
        return 1;
    }

    public final boolean bwP() {
        AppMethodBeat.i(46300);
        if (this.tlM == null || this.tlM.size() == 0) {
            aj cRh = r.cPE().cRh();
            if (bo.isNullOrNil(cRh.field_find_passwd_url) && bo.isNullOrNil(cRh.field_forget_passwd_url)) {
                AppMethodBeat.o(46300);
                return false;
            }
            AppMethodBeat.o(46300);
            return true;
        }
        AppMethodBeat.o(46300);
        return false;
    }

    public final boolean bwQ() {
        AppMethodBeat.i(46301);
        AM(bwP() ? 4 : 0);
        AppMethodBeat.o(46301);
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(46302);
        super.onActivityResult(i, i, intent);
        if (i2 == -1 && 1 == i) {
            this.trA.set3DesValStr(intent.getStringExtra("key_bankcard_id"));
            ari();
        }
        AppMethodBeat.o(46302);
    }

    private void cOC() {
        AppMethodBeat.i(46295);
        this.mBundle.remove("elemt_query");
        this.mBundle.remove("key_bankcard");
        this.mBundle.remove("bank_name");
        this.mBundle.remove("key_card_id");
        AppMethodBeat.o(46295);
    }

    static /* synthetic */ void c(WalletForgotPwdUI walletForgotPwdUI) {
        AppMethodBeat.i(46304);
        if (!"1".equals(r.cPE().cRh().field_reset_passwd_flag)) {
            ab.i("MicroMsg.WalletForgotPwdUI", "hy: not support bind new");
            AppMethodBeat.o(46304);
        } else if (bo.isNullOrNil(r.cPE().cRh().field_find_passwd_url)) {
            ab.i("MicroMsg.WalletForgotPwdUI", "hy: support bind new directly");
            ((ViewStub) walletForgotPwdUI.findViewById(R.id.fa8)).inflate();
            ((WalletFormView) walletForgotPwdUI.findViewById(R.id.fa2)).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(46277);
                    WalletForgotPwdUI.this.trD = true;
                    WalletForgotPwdUI.a(WalletForgotPwdUI.this);
                    AppMethodBeat.o(46277);
                }
            });
            AppMethodBeat.o(46304);
        } else {
            CharSequence spannableString;
            ab.i("MicroMsg.WalletForgotPwdUI", "hy: support bind new h5");
            ((ViewStub) walletForgotPwdUI.findViewById(R.id.fa9)).inflate();
            TextView textView = (TextView) walletForgotPwdUI.findViewById(R.id.fa3);
            j jVar = new j(walletForgotPwdUI);
            jVar.tHw = new com.tencent.mm.plugin.wallet_core.ui.j.a() {
                public final void onClick(View view) {
                    AppMethodBeat.i(46276);
                    WalletForgotPwdUI.this.trD = true;
                    WalletForgotPwdUI.a(WalletForgotPwdUI.this);
                    AppMethodBeat.o(46276);
                }
            };
            String string;
            if (r.cPI().cQp()) {
                string = walletForgotPwdUI.getString(R.string.fm3);
                spannableString = new SpannableString(string);
                spannableString.setSpan(jVar, string.length() - 12, string.length(), 33);
            } else {
                string = walletForgotPwdUI.getString(R.string.fm4);
                spannableString = new SpannableString(string);
                spannableString.setSpan(jVar, 0, string.length(), 18);
            }
            textView.setText(spannableString);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            AppMethodBeat.o(46304);
        }
    }

    static /* synthetic */ void a(WalletForgotPwdUI walletForgotPwdUI, String str, String str2, Bitmap bitmap) {
        AppMethodBeat.i(46305);
        Bundle bundle = new Bundle();
        bundle.putString("key_bankcard_id", str);
        bundle.putString("key_bankcard_des", str2);
        bundle.putParcelable("key_bankcard_cropimg", bitmap);
        bundle.putBoolean("key_is_reset_with_new_card", true);
        com.tencent.mm.wallet_core.c aE = com.tencent.mm.wallet_core.a.aE(walletForgotPwdUI);
        if (aE != null) {
            aE.a((Activity) walletForgotPwdUI, WalletConfirmCardIDUI.class, bundle, 1);
        }
        AppMethodBeat.o(46305);
    }
}
