package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.a.pn;
import com.tencent.mm.g.a.um;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.a.t;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.ak;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.plugin.wallet_core.utils.d;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tenpay.ndk.Encrypt;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class WalletBankcardIdUI extends WalletBaseUI implements com.tencent.mm.wallet_core.ui.formview.WalletFormView.a {
    private Button gEZ;
    private int gOW = -1;
    protected WalletFormView tEp;
    protected WalletFormView tEq;
    private Bankcard tEr;
    private a tEs;
    private boolean tEt = false;
    private boolean tEu;
    c tmk = new c<um>() {
        {
            AppMethodBeat.i(47159);
            this.xxI = um.class.getName().hashCode();
            AppMethodBeat.o(47159);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(47160);
            WalletBankcardIdUI.this.finish();
            AppMethodBeat.o(47160);
            return false;
        }
    };
    c trF = new c<pn>() {
        {
            AppMethodBeat.i(47161);
            this.xxI = pn.class.getName().hashCode();
            AppMethodBeat.o(47161);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(47162);
            pn pnVar = (pn) bVar;
            if (pnVar instanceof pn) {
                Encrypt encrypt = new Encrypt();
                String randomKey = encrypt.getRandomKey();
                WalletBankcardIdUI.a(WalletBankcardIdUI.this, encrypt.desedeEncode(pnVar.cLJ.cardId, randomKey), randomKey, pnVar.cLJ.cLK);
                WalletBankcardIdUI.this.finish();
                AppMethodBeat.o(47162);
                return true;
            }
            ab.f("Micromsg.WalletInputCardIDUI", "mismatched scanBandkCardResultEvent event");
            AppMethodBeat.o(47162);
            return false;
        }
    };

    static class a extends BaseAdapter {
        private Context mContext = null;
        private LayoutInflater mInflater = null;
        List<t> tEw = new LinkedList();

        class a {
            TextView pMc;
            ImageView tEx;
            TextView tEy;
            TextView tEz;

            a() {
            }
        }

        public a(Context context, List<t> list) {
            AppMethodBeat.i(47170);
            this.mInflater = LayoutInflater.from(context);
            this.tEw = list;
            this.mContext = context;
            AppMethodBeat.o(47170);
        }

        public final int getCount() {
            AppMethodBeat.i(47171);
            if (this.tEw == null) {
                AppMethodBeat.o(47171);
                return 0;
            }
            int size = this.tEw.size();
            AppMethodBeat.o(47171);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(47172);
            Object obj = this.tEw.get(i);
            AppMethodBeat.o(47172);
            return obj;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(47173);
            if (view == null) {
                view = this.mInflater.inflate(R.layout.b3j, viewGroup, false);
                aVar = new a();
                aVar.tEx = (ImageView) view.findViewById(R.id.f8f);
                aVar.pMc = (TextView) view.findViewById(R.id.f8g);
                aVar.tEy = (TextView) view.findViewById(R.id.f8h);
                aVar.tEz = (TextView) view.findViewById(R.id.f8i);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            t tVar = (t) getItem(i);
            if (bo.isNullOrNil(tVar.pcj)) {
                aVar.pMc.setVisibility(8);
            } else {
                aVar.pMc.setText(tVar.pcj);
                aVar.pMc.setVisibility(0);
            }
            if (bo.isNullOrNil(tVar.tnN)) {
                aVar.tEy.setVisibility(8);
            } else {
                aVar.tEy.setText(tVar.tnN);
                aVar.tEy.setVisibility(0);
            }
            if (bo.isNullOrNil(tVar.tmP)) {
                aVar.tEz.setVisibility(8);
            } else {
                aVar.tEz.setText(tVar.tmP);
                aVar.tEz.setVisibility(0);
            }
            String str = tVar.tnT;
            ab.v("Micromsg.WalletInputCardIDUI", "bankType:" + tVar.tnS + ", logurl:" + str);
            aVar.tEx.setImageBitmap(null);
            if (!bo.isNullOrNil(str)) {
                com.tencent.mm.at.a.a.c.a aVar2 = new com.tencent.mm.at.a.a.c.a();
                o.ahq();
                aVar2.ePY = null;
                aVar2.ePK = e.eSn;
                aVar2.ePJ = com.tencent.mm.plugin.wallet_core.d.b.UK(str);
                aVar2.ePH = true;
                aVar2.ePZ = true;
                o.ahp().a(str, aVar.tEx, aVar2.ahG());
            }
            AppMethodBeat.o(47173);
            return view;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletBankcardIdUI() {
        AppMethodBeat.i(47174);
        AppMethodBeat.o(47174);
    }

    public final int getLayoutId() {
        return R.layout.b3a;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(47175);
        super.onCreate(bundle);
        setMMTitle((int) R.string.fgs);
        initView();
        com.tencent.mm.sdk.b.a.xxA.c(this.tmk);
        com.tencent.mm.sdk.b.a.xxA.c(this.trF);
        this.gOW = this.mBundle.getInt("key_bind_scene");
        AppMethodBeat.o(47175);
    }

    public void onDestroy() {
        AppMethodBeat.i(47176);
        com.tencent.mm.sdk.b.a.xxA.d(this.tmk);
        com.tencent.mm.sdk.b.a.xxA.d(this.trF);
        super.onDestroy();
        AppMethodBeat.o(47176);
    }

    public final void initView() {
        AppMethodBeat.i(47177);
        this.gEZ = (Button) findViewById(R.id.ay8);
        this.tEp = (WalletFormView) findViewById(R.id.dm0);
        com.tencent.mm.wallet_core.ui.formview.a.b(this.tEp);
        this.tEq = (WalletFormView) findViewById(R.id.f7y);
        if (this.mBundle.getBoolean("key_bind_show_change_card", false)) {
            com.tencent.mm.wallet_core.ui.formview.a.d(this, this.tEq);
        } else {
            com.tencent.mm.wallet_core.ui.formview.a.e(this, this.tEq);
        }
        this.tEp.setOnInputValidChangeListener(this);
        this.gEZ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47163);
                h.pYm.e(11353, Integer.valueOf(1), Integer.valueOf(0));
                WalletBankcardIdUI.this.ari();
                AppMethodBeat.o(47163);
            }
        });
        com.tencent.mm.wallet_core.c dOD = dOD();
        if (dOD != null) {
            this.tEu = dOD.mqu.getBoolean("key_is_realname_verify_process", false);
        } else {
            this.tEu = false;
        }
        if (this.tEu) {
            setMMTitle((int) R.string.fqh);
        } else {
            setMMTitle((int) R.string.fgs);
        }
        TextView textView = (TextView) findViewById(R.id.f55);
        if (r.cPI().cQi() || r.cPI().cQh()) {
            j jVar = new j(this);
            jVar.tHw = new com.tencent.mm.plugin.wallet_core.ui.j.a() {
                public final void onClick(View view) {
                    AppMethodBeat.i(47164);
                    ab.i("Micromsg.WalletInputCardIDUI", "hy: clickable span on click");
                    WalletBankcardIdUI.a(WalletBankcardIdUI.this);
                    AppMethodBeat.o(47164);
                }
            };
            String string = getString(R.string.fgm);
            SpannableString spannableString = new SpannableString(string);
            spannableString.setSpan(jVar, string.length() - 6, string.length(), 33);
            textView.setText(spannableString);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        } else {
            textView.setVisibility(0);
            String string2 = this.mBundle.getString("key_custom_bind_tips");
            if (!bo.isNullOrNil(string2)) {
                textView.setText(string2);
            }
        }
        FavorPayInfo favorPayInfo = (FavorPayInfo) this.mBundle.getParcelable("key_favor_pay_info");
        Orders orders = (Orders) this.mBundle.getParcelable("key_orders");
        if (!(favorPayInfo == null || orders == null)) {
            b a = c.tDU.a(orders);
            TextView textView2 = (TextView) findViewById(R.id.f7z);
            if (a != null) {
                List acT = a.acT(a.acW(favorPayInfo.tzb));
                if (acT.size() > 0) {
                    this.tEs = new a(this.mController.ylL, acT);
                    textView2.setText(R.string.fgk);
                    textView2.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(47165);
                            WalletBankcardIdUI.this.showDialog(1);
                            AppMethodBeat.o(47165);
                        }
                    });
                    textView2.setVisibility(0);
                } else {
                    textView2.setVisibility(8);
                }
            } else {
                ab.w("Micromsg.WalletInputCardIDUI", "favorlogichelper null");
                textView2.setVisibility(8);
            }
        }
        ak cPI = r.cPI();
        if (!cPI.cQg() || cPI.bhp() == null || bo.isNullOrNil(cPI.bhp().trim()) || !cPI.cQp()) {
            this.tEq.setVisibility(8);
            this.tEp.setHint(getString(R.string.fgo));
        } else {
            this.tEq.setVisibility(0);
            this.tEq.setText(cPI.bhp());
            this.tEp.setHint(getString(R.string.fbz));
            this.tEq.setClickable(false);
            this.tEq.setEnabled(false);
        }
        if (this.mBundle.getInt("key_bind_scene") == 18 || this.mBundle.getInt("key_bind_scene") == 19) {
            this.tEp.setHint(getString(R.string.fgq));
        }
        g.RQ();
        String str = (String) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_SUPPORT_BANK_WORD_STRING, null);
        if (!bo.isNullOrNil(str)) {
            this.tEp.setHint(str);
        }
        this.tEr = (Bankcard) this.mBundle.getParcelable("key_history_bankcard");
        if (this.tEr != null) {
            this.tEp.setText(this.tEr.twO);
            this.tEp.a(new TextWatcher() {
                public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    AppMethodBeat.i(47166);
                    if (WalletBankcardIdUI.this.tEp.asa() && !WalletBankcardIdUI.this.tEt) {
                        WalletBankcardIdUI.this.tEt = true;
                        WalletBankcardIdUI.this.tEp.cey();
                    }
                    AppMethodBeat.o(47166);
                }

                public final void afterTextChanged(Editable editable) {
                }
            });
        }
        arW();
        d.a(this, this.mBundle, 2);
        e(this.tEp, 0, false);
        this.tEp.setOnInfoIvClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(47167);
                h.pYm.e(11353, Integer.valueOf(2), Integer.valueOf(0));
                com.tencent.mm.wallet_core.ui.e.d(WalletBankcardIdUI.this, r.cPI().bhp());
                AppMethodBeat.o(47167);
            }
        });
        if (r.cPI().cQo().cPX()) {
            this.tEp.getInfoIv().setVisibility(0);
            this.tEp.getInfoIv().setImageResource(R.raw.wallet_scan_camera);
        }
        AppMethodBeat.o(47177);
    }

    /* Access modifiers changed, original: protected|final */
    public final void ari() {
        AppMethodBeat.i(47178);
        if (dOD() == null) {
            ab.e("Micromsg.WalletInputCardIDUI", "WalletBankcardIdUI doNext, process is null");
            AppMethodBeat.o(47178);
            return;
        }
        String string = dOD().mqu.getString("kreq_token");
        int i = this.mBundle.getInt("entry_scene", -1);
        if (this.tEr != null) {
            m tVar = new com.tencent.mm.plugin.wallet_core.c.t(cNH(), null, (PayInfo) this.mBundle.getParcelable("key_pay_info"), string, this.gOW, i);
            tVar.pNL = this.tEr.field_bankcardType;
            this.mBundle.putParcelable("key_history_bankcard", this.tEr);
            a(tVar, true, true);
            AppMethodBeat.o(47178);
        } else if (arW()) {
            a(new com.tencent.mm.plugin.wallet_core.c.t(cNH(), this.tEp.getText(), (PayInfo) this.mBundle.getParcelable("key_pay_info"), string, this.gOW, i), true, true);
            AppMethodBeat.o(47178);
        } else {
            com.tencent.mm.ui.base.h.g(this, R.string.fk4, R.string.tz);
            AppMethodBeat.o(47178);
        }
    }

    public Dialog onCreateDialog(int i) {
        AppMethodBeat.i(47179);
        Dialog a;
        if (i == 1) {
            View inflate = getLayoutInflater().inflate(R.layout.b4o, null);
            ((ListViewInScrollView) inflate.findViewById(R.id.n3)).setAdapter(this.tEs);
            com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(this);
            aVar.PV(R.string.fgj);
            aVar.fn(inflate);
            aVar.f(null);
            aVar.Qc(R.string.ffp);
            com.tencent.mm.ui.widget.a.c aMb = aVar.aMb();
            AppMethodBeat.o(47179);
            return aMb;
        } else if (this.tEu && i == 1000) {
            int a2;
            String string = getString(R.string.fgl);
            com.tencent.mm.wallet_core.c aE = com.tencent.mm.wallet_core.a.aE(this);
            if (aE != null) {
                a2 = aE.a((MMActivity) this, 1);
            } else {
                a2 = -1;
            }
            if (a2 != -1) {
                string = getString(a2);
            }
            a = com.tencent.mm.ui.base.h.a((Context) this, true, string, "", getString(R.string.up), getString(R.string.s2), new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(47168);
                    ((com.tencent.mm.plugin.wallet_core.id_verify.a) WalletBankcardIdUI.this.dOD()).c(WalletBankcardIdUI.this, 0);
                    WalletBankcardIdUI.this.finish();
                    AppMethodBeat.o(47168);
                }
            }, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(47169);
                    View findFocus = WalletBankcardIdUI.this.mController.contentView == null ? null : WalletBankcardIdUI.this.mController.contentView.findFocus();
                    if (findFocus != null && (findFocus instanceof EditText)) {
                        WalletBankcardIdUI.this.showVKB();
                    }
                    AppMethodBeat.o(47169);
                }
            });
            AppMethodBeat.o(47179);
            return a;
        } else {
            a = super.onCreateDialog(i);
            AppMethodBeat.o(47179);
            return a;
        }
    }

    public final boolean c(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(47180);
        ab.d("Micromsg.WalletInputCardIDUI", " errCode: " + i2 + " errMsg :" + str);
        Bundle bundle = new Bundle();
        if (i == 0 && i2 == 0) {
            if (mVar instanceof com.tencent.mm.plugin.wallet_core.c.t) {
                com.tencent.mm.plugin.wallet_core.c.t tVar = (com.tencent.mm.plugin.wallet_core.c.t) mVar;
                bundle.putBoolean("key_need_area", tVar.cOU());
                bundle.putBoolean("key_need_profession", tVar.cOV());
                bundle.putParcelableArray("key_profession_list", tVar.tur);
                bundle.putBoolean("key_need_country", tVar.tus == 1);
                bundle.putStringArray("key_country_excludes", tVar.tut);
                if (tVar.tun == null) {
                    bundle.putString("bank_name", "");
                    bundle.putParcelable("elemt_query", new ElementQuery());
                    bundle.putString("key_card_id", this.tEp.getText());
                    com.tencent.mm.wallet_core.a.j(this, bundle);
                } else if (tVar.tun.tyC && tVar.tun.isError()) {
                    com.tencent.mm.ui.base.h.g(this, R.string.f_1, R.string.tz);
                    AppMethodBeat.o(47180);
                    return true;
                } else {
                    bundle.putString("bank_name", tVar.tun.nuL);
                    bundle.putParcelable("elemt_query", tVar.tun);
                    bundle.putString("key_card_id", this.tEp.getText());
                    com.tencent.mm.wallet_core.a.j(this, bundle);
                    AppMethodBeat.o(47180);
                    return true;
                }
            }
        } else if (i2 == 1 && (mVar instanceof com.tencent.mm.plugin.wallet_core.c.t)) {
            bundle.putString("bank_name", "");
            bundle.putParcelable("elemt_query", new ElementQuery());
            bundle.putString("key_card_id", this.tEp.getText());
            com.tencent.mm.wallet_core.a.j(this, bundle);
            AppMethodBeat.o(47180);
            return true;
        }
        AppMethodBeat.o(47180);
        return false;
    }

    private boolean arW() {
        AppMethodBeat.i(47181);
        if (this.tEp.fx(null)) {
            this.gEZ.setEnabled(true);
            this.gEZ.setClickable(true);
            AppMethodBeat.o(47181);
            return true;
        }
        this.gEZ.setEnabled(false);
        this.gEZ.setClickable(false);
        AppMethodBeat.o(47181);
        return false;
    }

    public final void hY(boolean z) {
        AppMethodBeat.i(47182);
        if (!z) {
            this.tEr = null;
            this.mBundle.putParcelable("key_history_bankcard", null);
        }
        arW();
        AppMethodBeat.o(47182);
    }

    public final boolean cNR() {
        return true;
    }

    public final int getForceOrientation() {
        return 1;
    }

    static /* synthetic */ void a(WalletBankcardIdUI walletBankcardIdUI) {
        AppMethodBeat.i(47183);
        LayoutInflater layoutInflater = (LayoutInflater) walletBankcardIdUI.mController.ylL.getSystemService("layout_inflater");
        View view = (TextView) layoutInflater.inflate(R.layout.a7c, null);
        view.setText(walletBankcardIdUI.getString(R.string.fck));
        int dimensionPixelSize = layoutInflater.getContext().getResources().getDimensionPixelSize(R.dimen.l5);
        view.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        com.tencent.mm.ui.base.h.a(walletBankcardIdUI.mController.ylL, walletBankcardIdUI.getString(R.string.fcj), walletBankcardIdUI.getString(R.string.ffp), view, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        AppMethodBeat.o(47183);
    }

    static /* synthetic */ void a(WalletBankcardIdUI walletBankcardIdUI, String str, String str2, Bitmap bitmap) {
        AppMethodBeat.i(47184);
        Bundle bundle = new Bundle();
        bundle.putString("key_bankcard_id", str);
        bundle.putString("key_bankcard_des", str2);
        bundle.putParcelable("key_bankcard_cropimg", bitmap);
        com.tencent.mm.wallet_core.c aE = com.tencent.mm.wallet_core.a.aE(walletBankcardIdUI);
        if (aE != null) {
            aE.b(walletBankcardIdUI, WalletConfirmCardIDUI.class, bundle);
        }
        AppMethodBeat.o(47184);
    }
}
