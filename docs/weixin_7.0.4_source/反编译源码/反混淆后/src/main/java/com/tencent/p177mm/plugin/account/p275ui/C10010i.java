package com.tencent.p177mm.plugin.account.p275ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelfriend.C32815a;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p1192h.C42124a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p232b.p233a.C42085ba;
import com.tencent.p177mm.p612ui.applet.SecurityImage;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.base.C40671n.C36073c;
import com.tencent.p177mm.p612ui.base.C40671n.C5279d;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p612ui.base.C44274m;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d;
import com.tencent.p177mm.p612ui.widget.p633a.C36356d.C15994a;
import com.tencent.p177mm.plugin.account.p275ui.MobileInputUI.C33008a;
import com.tencent.p177mm.plugin.account.p275ui.MobileInputUI.C38070b;
import com.tencent.p177mm.plugin.p1603b.C42756a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5025av;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.account.ui.i */
public final class C10010i implements C1202f, C38070b {
    C42085ba gBm = new C42085ba();
    MobileInputUI gDo;
    private C10004g gDu = null;
    private SecurityImage gue = null;

    /* renamed from: com.tencent.mm.plugin.account.ui.i$6 */
    class C100096 implements OnCancelListener {
        C100096() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.i$5 */
    class C100125 implements OnClickListener {
        C100125() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(125099);
            C10010i.m17606a(C10010i.this);
            AppMethodBeat.m2505o(125099);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.i$2 */
    class C100152 implements C5279d {
        C100152() {
        }

        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.m2504i(125097);
            switch (menuItem.getItemId()) {
                case 2001:
                    C10010i.m17606a(C10010i.this);
                    AppMethodBeat.m2505o(125097);
                    return;
                case 2002:
                    C10010i c10010i = C10010i.this;
                    c10010i.gBm.daR = 1;
                    c10010i.gBm.cVS = 10;
                    c10010i.gBm.ajK();
                    c10010i.gDo.startActivity(new Intent(c10010i.gDo, FacebookLoginUI.class));
                    break;
            }
            AppMethodBeat.m2505o(125097);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.ui.i$3 */
    class C100163 implements C15994a {
        C100163() {
        }

        public final void onDismiss() {
        }
    }

    public C10010i() {
        AppMethodBeat.m2504i(125101);
        AppMethodBeat.m2505o(125101);
    }

    /* renamed from: a */
    public final void mo21369a(MobileInputUI mobileInputUI) {
        AppMethodBeat.m2504i(125102);
        this.gDo = mobileInputUI;
        mobileInputUI.grF.setVisibility(0);
        mobileInputUI.gDH.setVisibility(0);
        mobileInputUI.gDI.requestFocus();
        mobileInputUI.gDN.setText(C25738R.string.f9182s1);
        mobileInputUI.gDN.setVisibility(0);
        mobileInputUI.gDP.setVisibility(0);
        final ArrayList arrayList = new ArrayList();
        C44274m c44274m = new C44274m(this.gDo, 2001, 0);
        c44274m.setTitle((int) C25738R.string.co7);
        arrayList.add(c44274m);
        c44274m = new C44274m(this.gDo, 2002, 0);
        if (C17950b.ahL()) {
            c44274m.setTitle((int) C25738R.string.co3);
            arrayList.add(c44274m);
        }
        if (arrayList.size() > 1) {
            final C36356d c36356d = new C36356d(this.gDo, 1, false);
            c36356d.rBl = new C36073c() {
                /* renamed from: a */
                public final void mo5746a(C44273l c44273l) {
                    AppMethodBeat.m2504i(125096);
                    if (c44273l.size() == 0) {
                        for (C44274m i : arrayList) {
                            c44273l.mo70073i(i);
                        }
                    }
                    AppMethodBeat.m2505o(125096);
                }
            };
            c36356d.rBm = new C100152();
            c36356d.zQf = new C100163();
            this.gDo.gDR.setText(C25738R.string.co8);
            this.gDo.gDR.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(125098);
                    C10010i.this.gDo.aqX();
                    c36356d.cpD();
                    if (arrayList.contains(c44274m)) {
                        C10010i.this.gBm.daR = 1;
                        C10010i.this.gBm.cVS = 9;
                        C10010i.this.gBm.ajK();
                    }
                    AppMethodBeat.m2505o(125098);
                }
            });
        } else {
            this.gDo.gDR.setText(C25738R.string.co7);
            this.gDo.gDR.setOnClickListener(new C100125());
        }
        this.gDo.gDR.setVisibility(0);
        AppMethodBeat.m2505o(125102);
    }

    public final void start() {
        AppMethodBeat.m2504i(125103);
        C1720g.m3540Rg().mo14539a(145, (C1202f) this);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",L200_100,");
        C1720g.m3534RN();
        C42756a.m75795f(true, stringBuilder.append(C1668a.m3407lF("L200_100")).append(",1").toString());
        C42756a.m75798wz("L200_100");
        AppMethodBeat.m2505o(125103);
    }

    public final void stop() {
        AppMethodBeat.m2504i(125104);
        C1720g.m3540Rg().mo14546b(145, (C1202f) this);
        StringBuilder stringBuilder = new StringBuilder();
        C1720g.m3534RN();
        stringBuilder = stringBuilder.append(C1668a.m3397Rb()).append(",").append(getClass().getName()).append(",L200_100,");
        C1720g.m3534RN();
        C42756a.m75795f(false, stringBuilder.append(C1668a.m3407lF("L200_100")).append(",2").toString());
        AppMethodBeat.m2505o(125104);
    }

    /* renamed from: a */
    public final void mo21368a(C33008a c33008a) {
        AppMethodBeat.m2504i(125105);
        switch (c33008a) {
            case GoNext:
                this.gDo.gDU = C5025av.amP(this.gDo.countryCode);
                this.gDo.gDV = this.gDo.gDI.getText().toString();
                String amN = C5025av.amN(this.gDo.gDU + this.gDo.gDV);
                MobileInputUI mobileInputUI = this.gDo;
                Context context = this.gDo;
                this.gDo.getString(C25738R.string.f9238tz);
                mobileInputUI.guc = C30379h.m48458b(context, this.gDo.getString(C25738R.string.dku), true, new C100096());
                C1720g.m3540Rg().mo14541a(new C32815a(amN, 13, "", 0, ""), 0);
                break;
        }
        AppMethodBeat.m2505o(125105);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(125106);
        C4990ab.m7416i("MicroMsg.MobileInputLoginLogic", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.gDo.guc != null) {
            this.gDo.guc.dismiss();
            this.gDo.guc = null;
        }
        if ((c1207m.getType() == 252 || c1207m.getType() == 701) && this.gDu != null) {
            this.gDu.gDc = this.gDo.gDc;
            this.gDu.mo21363a(this.gDo, i, i2, str, c1207m);
            AppMethodBeat.m2505o(125106);
        } else if (c1207m.getType() != 145 || ((C32815a) c1207m).mo53366Ah() != 13) {
            AppMethodBeat.m2505o(125106);
        } else if (i2 == -41) {
            C42124a jY = C42124a.m74268jY(str);
            if (jY != null) {
                jY.mo67668a(this.gDo, null, null);
                AppMethodBeat.m2505o(125106);
                return;
            }
            C30379h.m48467g(this.gDo, C25738R.string.dl6, C25738R.string.dl7);
            AppMethodBeat.m2505o(125106);
        } else if (i2 == -1) {
            Toast.makeText(this.gDo, this.gDo.getString(C25738R.string.bwo, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            AppMethodBeat.m2505o(125106);
        } else if (i2 == -34) {
            C30379h.m48461b(this.gDo, this.gDo.getString(C25738R.string.a6k), "", true);
            AppMethodBeat.m2505o(125106);
        } else {
            this.gDo.aqX();
            Intent intent = new Intent(this.gDo, MobileInputUI.class);
            intent.putExtra("mobile_input_purpose", -1);
            intent.putExtra("mobile_auth_type", 7);
            intent.putExtra("from_switch_account", this.gDo.gDa);
            intent.putExtra("couttry_code", this.gDo.countryCode);
            intent.putExtra("input_mobile_number", this.gDo.gDV);
            this.gDo.startActivity(intent);
            AppMethodBeat.m2505o(125106);
        }
    }
}
