package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.collect.model.m;
import com.tencent.mm.plugin.collect.model.s;
import com.tencent.mm.plugin.wallet_core.ui.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.b;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a;

public class CollectCreateQRCodeUI extends WalletBaseUI {
    private String eeO = "";
    private WalletFormView kGa;
    private TextView kGb;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(41238);
        super.onCreate(bundle);
        nf(1335);
        initView();
        AppMethodBeat.o(41238);
    }

    public void onDestroy() {
        AppMethodBeat.i(41239);
        super.onDestroy();
        ng(1335);
        AppMethodBeat.o(41239);
    }

    public final void initView() {
        AppMethodBeat.i(41240);
        setMMTitle((int) R.string.arq);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(41230);
                CollectCreateQRCodeUI.this.setResult(0);
                CollectCreateQRCodeUI.this.finish();
                AppMethodBeat.o(41230);
                return true;
            }
        });
        this.kGa = (WalletFormView) findViewById(R.id.ay4);
        a.f(this.kGa);
        String stringExtra = getIntent().getStringExtra("key_currency_unit");
        if (bo.isNullOrNil(stringExtra)) {
            this.kGa.getTitleTv().setText(ae.dOd());
        } else {
            this.kGa.getTitleTv().setText(stringExtra);
        }
        this.kGa.a(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(41231);
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 2) {
                    editable.delete(indexOf + 3, length);
                }
                AppMethodBeat.o(41231);
            }
        });
        e(this.kGa, 2, false);
        ((Button) findViewById(R.id.ay8)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(41232);
                double d = bo.getDouble(CollectCreateQRCodeUI.this.kGa.getText(), 0.0d);
                g.RQ();
                ab.i("MicroMsg.CollectCreateQRCodeUI", "wallet region: %s", Integer.valueOf(((Integer) g.RP().Ry().get(ac.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(0))).intValue()));
                if (!CollectCreateQRCodeUI.this.kGa.asa()) {
                    t.makeText(CollectCreateQRCodeUI.this.mController.ylL, R.string.f9y, 0).show();
                    AppMethodBeat.o(41232);
                } else if (d < 0.01d) {
                    t.makeText(CollectCreateQRCodeUI.this.mController.ylL, R.string.dnj, 0).show();
                    AppMethodBeat.o(41232);
                } else if (r0 == 8) {
                    CollectCreateQRCodeUI.this.a(new m(Math.round(d * 100.0d), CollectCreateQRCodeUI.this.eeO, r.YG()), true, false);
                    AppMethodBeat.o(41232);
                } else {
                    CollectCreateQRCodeUI.this.a(new s(d, "1", CollectCreateQRCodeUI.this.eeO), true, true);
                    AppMethodBeat.o(41232);
                }
            }
        });
        this.kGb = (TextView) findViewById(R.id.ay7);
        this.kGb.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(41236);
                CollectCreateQRCodeUI.this.aoB();
                com.tencent.mm.plugin.wallet_core.ui.view.a.a(CollectCreateQRCodeUI.this, CollectCreateQRCodeUI.this.getString(R.string.arr), CollectCreateQRCodeUI.this.eeO, "", 32, new b() {
                    public final boolean s(CharSequence charSequence) {
                        AppMethodBeat.i(41233);
                        if (bo.isNullOrNil(charSequence.toString())) {
                            CollectCreateQRCodeUI.this.eeO = "";
                            CollectCreateQRCodeUI.c(CollectCreateQRCodeUI.this);
                        } else {
                            CollectCreateQRCodeUI.this.eeO = charSequence.toString();
                            CollectCreateQRCodeUI.c(CollectCreateQRCodeUI.this);
                        }
                        AppMethodBeat.o(41233);
                        return true;
                    }
                }, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(41235);
                        al.n(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(41234);
                                CollectCreateQRCodeUI.this.aqX();
                                AppMethodBeat.o(41234);
                            }
                        }, 500);
                        AppMethodBeat.o(41235);
                    }
                });
                AppMethodBeat.o(41236);
            }
        });
        AppMethodBeat.o(41240);
    }

    public final int getLayoutId() {
        return R.layout.p0;
    }

    public final boolean c(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(41241);
        Intent intent;
        if (mVar instanceof s) {
            if (i == 0 && i2 == 0) {
                s sVar = (s) mVar;
                intent = new Intent();
                intent.putExtra("ftf_pay_url", sVar.kCI);
                intent.putExtra("ftf_fixed_fee", sVar.kCJ);
                intent.putExtra("ftf_fixed_fee_type", sVar.cuZ);
                intent.putExtra("ftf_fixed_desc", sVar.desc);
                setResult(-1, intent);
                finish();
                AppMethodBeat.o(41241);
                return true;
            }
        } else if (mVar instanceof m) {
            final m mVar2 = (m) mVar;
            if (i != 0 || i2 != 0) {
                ab.e("MicroMsg.CollectCreateQRCodeUI", "net error: %s", mVar2);
            } else if (mVar2.kCl == 0) {
                intent = new Intent();
                intent.putExtra("ftf_pay_url", mVar2.kCn);
                intent.putExtra("ftf_fixed_fee", ((double) mVar2.cSh) / 100.0d);
                intent.putExtra("ftf_fixed_desc", mVar2.desc);
                intent.putExtra("key_currency_unit", mVar2.kCw);
                setResult(-1, intent);
                finish();
                AppMethodBeat.o(41241);
                return true;
            } else if (mVar2.kCo == 0) {
                h.b(this.mController.ylL, mVar2.kCm, mVar2.kCp, false);
                AppMethodBeat.o(41241);
                return true;
            } else if (mVar2.kCo == 1) {
                if (!(bo.isNullOrNil(mVar2.kCq) || bo.isNullOrNil(mVar2.kCr))) {
                    h.d(this.mController.ylL, mVar2.kCm, mVar2.kCp, mVar2.kCr, mVar2.kCq, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.i(41237);
                            if (!bo.isNullOrNil(mVar2.kCs)) {
                                ab.i("MicroMsg.CollectCreateQRCodeUI", "goto h5: %s", mVar2.kCs);
                                e.n(CollectCreateQRCodeUI.this.mController.ylL, mVar2.kCs, true);
                            }
                            AppMethodBeat.o(41237);
                        }
                    }, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                }
                AppMethodBeat.o(41241);
                return true;
            }
        }
        AppMethodBeat.o(41241);
        return false;
    }

    static /* synthetic */ void c(CollectCreateQRCodeUI collectCreateQRCodeUI) {
        AppMethodBeat.i(41242);
        if (bo.isNullOrNil(collectCreateQRCodeUI.eeO)) {
            collectCreateQRCodeUI.kGb.setTextColor(collectCreateQRCodeUI.getResources().getColor(R.color.t7));
            collectCreateQRCodeUI.kGb.setText(R.string.arr);
            AppMethodBeat.o(41242);
            return;
        }
        j jVar = new j(collectCreateQRCodeUI.mController.ylL);
        SpannableString b = com.tencent.mm.pluginsdk.ui.e.j.b((Context) collectCreateQRCodeUI, collectCreateQRCodeUI.getString(R.string.ars, new Object[]{collectCreateQRCodeUI.eeO, collectCreateQRCodeUI.getString(R.string.art)}));
        SpannableString spannableString = new SpannableString(b);
        spannableString.setSpan(jVar, b.length() - r1.length(), b.length(), 33);
        collectCreateQRCodeUI.kGb.setTextColor(collectCreateQRCodeUI.getResources().getColor(R.color.s0));
        collectCreateQRCodeUI.kGb.setText(spannableString);
        AppMethodBeat.o(41242);
    }
}
