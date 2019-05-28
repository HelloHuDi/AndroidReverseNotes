package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.b.a.ba;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.ui.MobileInputUI.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.ArrayList;

public final class i implements f, b {
    ba gBm = new ba();
    MobileInputUI gDo;
    private g gDu = null;
    private SecurityImage gue = null;

    public i() {
        AppMethodBeat.i(125101);
        AppMethodBeat.o(125101);
    }

    public final void a(MobileInputUI mobileInputUI) {
        AppMethodBeat.i(125102);
        this.gDo = mobileInputUI;
        mobileInputUI.grF.setVisibility(0);
        mobileInputUI.gDH.setVisibility(0);
        mobileInputUI.gDI.requestFocus();
        mobileInputUI.gDN.setText(R.string.s1);
        mobileInputUI.gDN.setVisibility(0);
        mobileInputUI.gDP.setVisibility(0);
        final ArrayList arrayList = new ArrayList();
        m mVar = new m(this.gDo, 2001, 0);
        mVar.setTitle((int) R.string.co7);
        arrayList.add(mVar);
        mVar = new m(this.gDo, 2002, 0);
        if (com.tencent.mm.au.b.ahL()) {
            mVar.setTitle((int) R.string.co3);
            arrayList.add(mVar);
        }
        if (arrayList.size() > 1) {
            final d dVar = new d(this.gDo, 1, false);
            dVar.rBl = new c() {
                public final void a(l lVar) {
                    AppMethodBeat.i(125096);
                    if (lVar.size() == 0) {
                        for (m i : arrayList) {
                            lVar.i(i);
                        }
                    }
                    AppMethodBeat.o(125096);
                }
            };
            dVar.rBm = new n.d() {
                public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                    AppMethodBeat.i(125097);
                    switch (menuItem.getItemId()) {
                        case 2001:
                            i.a(i.this);
                            AppMethodBeat.o(125097);
                            return;
                        case 2002:
                            i iVar = i.this;
                            iVar.gBm.daR = 1;
                            iVar.gBm.cVS = 10;
                            iVar.gBm.ajK();
                            iVar.gDo.startActivity(new Intent(iVar.gDo, FacebookLoginUI.class));
                            break;
                    }
                    AppMethodBeat.o(125097);
                }
            };
            dVar.zQf = new a() {
                public final void onDismiss() {
                }
            };
            this.gDo.gDR.setText(R.string.co8);
            this.gDo.gDR.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(125098);
                    i.this.gDo.aqX();
                    dVar.cpD();
                    if (arrayList.contains(mVar)) {
                        i.this.gBm.daR = 1;
                        i.this.gBm.cVS = 9;
                        i.this.gBm.ajK();
                    }
                    AppMethodBeat.o(125098);
                }
            });
        } else {
            this.gDo.gDR.setText(R.string.co7);
            this.gDo.gDR.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(125099);
                    i.a(i.this);
                    AppMethodBeat.o(125099);
                }
            });
        }
        this.gDo.gDR.setVisibility(0);
        AppMethodBeat.o(125102);
    }

    public final void start() {
        AppMethodBeat.i(125103);
        g.Rg().a(145, (f) this);
        StringBuilder stringBuilder = new StringBuilder();
        g.RN();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",L200_100,");
        g.RN();
        com.tencent.mm.plugin.b.a.f(true, stringBuilder.append(com.tencent.mm.kernel.a.lF("L200_100")).append(",1").toString());
        com.tencent.mm.plugin.b.a.wz("L200_100");
        AppMethodBeat.o(125103);
    }

    public final void stop() {
        AppMethodBeat.i(125104);
        g.Rg().b(145, (f) this);
        StringBuilder stringBuilder = new StringBuilder();
        g.RN();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.Rb()).append(",").append(getClass().getName()).append(",L200_100,");
        g.RN();
        com.tencent.mm.plugin.b.a.f(false, stringBuilder.append(com.tencent.mm.kernel.a.lF("L200_100")).append(",2").toString());
        AppMethodBeat.o(125104);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(125105);
        switch (aVar) {
            case GoNext:
                this.gDo.gDU = av.amP(this.gDo.countryCode);
                this.gDo.gDV = this.gDo.gDI.getText().toString();
                String amN = av.amN(this.gDo.gDU + this.gDo.gDV);
                MobileInputUI mobileInputUI = this.gDo;
                Context context = this.gDo;
                this.gDo.getString(R.string.tz);
                mobileInputUI.guc = h.b(context, this.gDo.getString(R.string.dku), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
                g.Rg().a(new com.tencent.mm.modelfriend.a(amN, 13, "", 0, ""), 0);
                break;
        }
        AppMethodBeat.o(125105);
    }

    public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(125106);
        ab.i("MicroMsg.MobileInputLoginLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.gDo.guc != null) {
            this.gDo.guc.dismiss();
            this.gDo.guc = null;
        }
        if ((mVar.getType() == 252 || mVar.getType() == 701) && this.gDu != null) {
            this.gDu.gDc = this.gDo.gDc;
            this.gDu.a(this.gDo, i, i2, str, mVar);
            AppMethodBeat.o(125106);
        } else if (mVar.getType() != 145 || ((com.tencent.mm.modelfriend.a) mVar).Ah() != 13) {
            AppMethodBeat.o(125106);
        } else if (i2 == -41) {
            com.tencent.mm.h.a jY = com.tencent.mm.h.a.jY(str);
            if (jY != null) {
                jY.a(this.gDo, null, null);
                AppMethodBeat.o(125106);
                return;
            }
            h.g(this.gDo, R.string.dl6, R.string.dl7);
            AppMethodBeat.o(125106);
        } else if (i2 == -1) {
            Toast.makeText(this.gDo, this.gDo.getString(R.string.bwo, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            AppMethodBeat.o(125106);
        } else if (i2 == -34) {
            h.b(this.gDo, this.gDo.getString(R.string.a6k), "", true);
            AppMethodBeat.o(125106);
        } else {
            this.gDo.aqX();
            Intent intent = new Intent(this.gDo, MobileInputUI.class);
            intent.putExtra("mobile_input_purpose", -1);
            intent.putExtra("mobile_auth_type", 7);
            intent.putExtra("from_switch_account", this.gDo.gDa);
            intent.putExtra("couttry_code", this.gDo.countryCode);
            intent.putExtra("input_mobile_number", this.gDo.gDV);
            this.gDo.startActivity(intent);
            AppMethodBeat.o(125106);
        }
    }
}
