package com.tencent.mm.plugin.recharge.ui;

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
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.se;
import com.tencent.mm.g.a.uv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.jsapi.storage.d;
import com.tencent.mm.plugin.recharge.ui.form.InstantAutoCompleteTextView;
import com.tencent.mm.plugin.recharge.ui.form.MallFormView;
import com.tencent.mm.plugin.recharge.ui.form.c.b;
import com.tencent.mm.plugin.recharge.ui.form.d.a;
import com.tencent.mm.plugin.wallet.a.e;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet.a.q;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.v;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PhoneRechargeUI extends MMActivity implements f, a {
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
    private ArrayList<q> pGh = null;
    private ArrayList<q> pGi = null;
    private e pGj = null;
    private e pGk = null;
    private e pGl = null;
    private e pGm = null;
    private e pGn = null;
    private GridView pHa = null;
    private TextView pHb = null;
    private TextView pHc = null;
    private TextView pHd = null;
    private TextView pHe = null;
    private TextView pHf = null;
    private TextView pHg = null;
    private b pHh = null;
    private b pHi = null;
    private MallFunction pHj = null;
    private String pHk = "";
    private int pHl;
    private String pHm = "";
    private String pHn = "";
    private b pHo = null;
    private p pHp = null;
    private boolean pHq = false;
    private List<String[]> pHr;
    private boolean piJ = false;
    private c piM = new c<uv>() {
        {
            AppMethodBeat.i(44267);
            this.xxI = uv.class.getName().hashCode();
            AppMethodBeat.o(44267);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(44268);
            uv uvVar = (uv) bVar;
            if (uvVar instanceof uv) {
                if (uvVar.cRF.result != -1) {
                    ab.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : cancel");
                } else if (!PhoneRechargeUI.this.piJ) {
                    ab.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : ok");
                    com.tencent.mm.plugin.recharge.a.a.cea().a(new com.tencent.mm.plugin.recharge.model.a(PhoneRechargeUI.this.pGW.getText(), PhoneRechargeUI.this.pHo.pGx != null ? bo.nullAsNil(PhoneRechargeUI.this.pHo.pGx.name) : "", 0));
                    PhoneRechargeUI.this.finish();
                    PhoneRechargeUI.this.piJ = true;
                }
                AppMethodBeat.o(44268);
                return true;
            }
            ab.f("MicroMsg.PhoneRechargeUI", "hy: mismatched event");
            AppMethodBeat.o(44268);
            return false;
        }
    };

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public PhoneRechargeUI() {
        AppMethodBeat.i(44276);
        AppMethodBeat.o(44276);
    }

    static /* synthetic */ String b(PhoneRechargeUI phoneRechargeUI, String str) {
        AppMethodBeat.i(44301);
        String VC = phoneRechargeUI.VC(str);
        AppMethodBeat.o(44301);
        return VC;
    }

    static /* synthetic */ void e(PhoneRechargeUI phoneRechargeUI) {
        AppMethodBeat.i(44299);
        phoneRechargeUI.G(false, false);
        AppMethodBeat.o(44299);
    }

    static /* synthetic */ void n(PhoneRechargeUI phoneRechargeUI) {
        AppMethodBeat.i(44306);
        phoneRechargeUI.cem();
        AppMethodBeat.o(44306);
    }

    private void ceh() {
        AppMethodBeat.i(44277);
        this.mAppId = "";
        cel();
        this.errCode = 0;
        this.aIm = "";
        this.desc = "";
        AppMethodBeat.o(44277);
    }

    private String VC(String str) {
        AppMethodBeat.i(44279);
        String str2;
        if (bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.o(44279);
            return str2;
        }
        try {
            str2 = "";
            if (!(this.pHo == null || this.pHo.pGx == null || bo.isNullOrNil(this.pHo.pGx.name))) {
                str2 = this.pHo.pGx.name;
            }
            if (str2.equals(getString(R.string.fr5))) {
                str2 = "WeChatAccountBindNumber";
            }
            String text = this.pGW.getText();
            str2 = URLEncoder.encode(URLEncoder.encode(str2, ProtocolPackage.ServerEncoding), ProtocolPackage.ServerEncoding);
            if (str.startsWith("http://") || str.startsWith("https://")) {
                ab.i("MicroMsg.PhoneRechargeUI", "new url");
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
                AppMethodBeat.o(44279);
                return str2;
            }
            ab.i("MicroMsg.PhoneRechargeUI", "old url");
            str2 = URLDecoder.decode(str, ProtocolPackage.ServerEncoding) + String.format("?phone=%s&remark=%s", new Object[]{text, str2});
            AppMethodBeat.o(44279);
            return str2;
        } catch (UnsupportedEncodingException e) {
            str2 = str;
            ab.printErrStackTrace("MicroMsg.PhoneRechargeUI", e, "", new Object[0]);
            AppMethodBeat.o(44279);
            return str2;
        }
    }

    private boolean cei() {
        AppMethodBeat.i(44280);
        if (this.pHp != null) {
            String str = (String) g.RP().Ry().get(ac.a.USERINFO_PHONE_RECHARGE_CLOSED_BANNER_STRING, (Object) "");
            if (bo.isNullOrNil(str)) {
                ab.i("MicroMsg.PhoneRechargeUI", "hy: no banner before, show");
                AppMethodBeat.o(44280);
                return false;
            }
            String[] split = str.split(";");
            if (split != null) {
                int length = split.length;
                int i = 0;
                while (i < length) {
                    String str2 = split[i];
                    if (str2 == null || !str2.equals(String.valueOf(this.pHp.id))) {
                        i++;
                    } else {
                        ab.i("MicroMsg.PhoneRechargeUI", "hy: found closed. ");
                        AppMethodBeat.o(44280);
                        return true;
                    }
                }
            }
            ab.i("MicroMsg.PhoneRechargeUI", "hy: not found closed banner.");
            AppMethodBeat.o(44280);
            return false;
        }
        ab.e("MicroMsg.PhoneRechargeUI", "hy: no banner");
        AppMethodBeat.o(44280);
        return true;
    }

    private void o(m mVar) {
        AppMethodBeat.i(44281);
        if (!(this.gII == null || !this.gII.isShowing() || mVar.getType() == d.CTRL_INDEX)) {
            this.gII.dismiss();
            this.gII = null;
        }
        AppMethodBeat.o(44281);
    }

    private void c(final m mVar, boolean z) {
        AppMethodBeat.i(44282);
        if (this.gII == null || !(this.gII == null || this.gII.isShowing())) {
            if (z) {
                this.gII = com.tencent.mm.wallet_core.ui.g.a(this.mController.ylL, true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(44275);
                        g.Rg().c(mVar);
                        AppMethodBeat.o(44275);
                    }
                });
            } else {
                this.gII = com.tencent.mm.wallet_core.ui.g.b(this.mController.ylL, true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(44253);
                        g.Rg().c(mVar);
                        AppMethodBeat.o(44253);
                    }
                });
            }
        }
        g.Rg().a(mVar, 0);
        AppMethodBeat.o(44282);
    }

    public void onResume() {
        AppMethodBeat.i(44283);
        super.onResume();
        G(false, true);
        AppMethodBeat.o(44283);
    }

    public void onDestroy() {
        AppMethodBeat.i(44284);
        super.onDestroy();
        g.Rg().b(1571, (f) this);
        g.Rg().b((int) com.tencent.mm.plugin.appbrand.jsapi.storage.e.CTRL_INDEX, (f) this);
        com.tencent.mm.sdk.b.a.xxA.d(this.piM);
        AppMethodBeat.o(44284);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0052  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void G(boolean z, boolean z2) {
        TextView textView;
        CharSequence string;
        AppMethodBeat.i(44285);
        if (this.pHp == null || cei()) {
            this.pGT.setVisibility(8);
            ab.d("MicroMsg.PhoneRechargeUI", "hy: dismiss banner!");
        } else {
            this.pGT.setVisibility(0);
            this.pGV.setText(this.pHp.name);
            ab.d("MicroMsg.PhoneRechargeUI", "hy: Show banner!");
            com.tencent.mm.protocal.g.gu(6, 0);
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
                    addTextOptionMenu(0, this.pGn.name, new OnMenuItemClickListener() {
                        public final boolean onMenuItemClick(MenuItem menuItem) {
                            AppMethodBeat.i(44254);
                            if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.this.pGn.tmN, PhoneRechargeUI.this.pGn.fjD)) {
                                try {
                                    PhoneRechargeUI.c(PhoneRechargeUI.this, URLDecoder.decode(PhoneRechargeUI.this.pGn.url, ProtocolPackage.ServerEncoding));
                                } catch (UnsupportedEncodingException e) {
                                    ab.printErrStackTrace("MicroMsg.PhoneRechargeUI", e, "", new Object[0]);
                                }
                            }
                            AppMethodBeat.o(44254);
                            return false;
                        }
                    });
                }
                textView = this.pGX;
                string = (this.pGh != null || this.pGh.size() <= 0 || bo.isNullOrNil(((q) this.pGh.get(0)).tnt)) ? getString(R.string.fqy) : ((q) this.pGh.get(0)).tnt;
                textView.setText(string);
                textView = this.pGY;
                string = (this.pGi != null || this.pGi.size() <= 0 || bo.isNullOrNil(((q) this.pGi.get(0)).tnt)) ? getString(R.string.fqz) : ((q) this.pGi.get(0)).tnt;
                textView.setText(string);
                if (this.pGm != null || bo.isNullOrNil(this.pGm.name)) {
                    this.pHc.setVisibility(8);
                } else {
                    this.pHc.setVisibility(0);
                    this.pHc.setText(this.pGm.name);
                    this.pHc.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(44255);
                            if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.this.pGm.tmN, PhoneRechargeUI.this.pGm.fjD)) {
                                ab.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", PhoneRechargeUI.b(PhoneRechargeUI.this, PhoneRechargeUI.this.pGm.url));
                                PhoneRechargeUI.c(PhoneRechargeUI.this, r0);
                            }
                            AppMethodBeat.o(44255);
                        }
                    });
                }
                if (this.pGj != null || bo.isNullOrNil(this.pGj.name)) {
                    this.pHb.setVisibility(8);
                } else {
                    this.pHb.setVisibility(0);
                    this.pHb.setText(this.pGj.name);
                    this.pHb.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(44256);
                            if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.this.pGj.tmN, PhoneRechargeUI.this.pGj.fjD)) {
                                ab.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", PhoneRechargeUI.b(PhoneRechargeUI.this, PhoneRechargeUI.this.pGj.url));
                                PhoneRechargeUI.c(PhoneRechargeUI.this, r0);
                            }
                            AppMethodBeat.o(44256);
                        }
                    });
                }
                if (this.pGk != null || bo.isNullOrNil(this.pGk.name)) {
                    this.pHd.setVisibility(8);
                } else {
                    this.pHd.setVisibility(0);
                    this.pHd.setText(this.pGk.name);
                    this.pHd.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(44257);
                            if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.this.pGk.tmN, PhoneRechargeUI.this.pGk.fjD)) {
                                ab.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", PhoneRechargeUI.b(PhoneRechargeUI.this, PhoneRechargeUI.this.pGk.url));
                                PhoneRechargeUI.c(PhoneRechargeUI.this, r0);
                            }
                            AppMethodBeat.o(44257);
                        }
                    });
                }
                if (this.pGl != null || bo.isNullOrNil(this.pGl.name)) {
                    this.pHe.setVisibility(8);
                } else {
                    this.pHe.setVisibility(0);
                    this.pHe.setText(this.pGl.name);
                    this.pHe.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(44258);
                            if (!PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.this.pGl.tmN, PhoneRechargeUI.this.pGl.fjD)) {
                                ab.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", PhoneRechargeUI.b(PhoneRechargeUI.this, PhoneRechargeUI.this.pGl.url));
                                PhoneRechargeUI.c(PhoneRechargeUI.this, r0);
                            }
                            AppMethodBeat.o(44258);
                        }
                    });
                }
                d(this.pHj);
                AppMethodBeat.o(44285);
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
        d(this.pHj);
        AppMethodBeat.o(44285);
    }

    private boolean cej() {
        AppMethodBeat.i(44286);
        Iterator it = this.pGi.iterator();
        while (it.hasNext()) {
            if (((q) it.next()).status != 0) {
                AppMethodBeat.o(44286);
                return false;
            }
        }
        AppMethodBeat.o(44286);
        return true;
    }

    private boolean cek() {
        AppMethodBeat.i(44287);
        Iterator it = this.pGh.iterator();
        while (it.hasNext()) {
            if (((q) it.next()).status != 0) {
                AppMethodBeat.o(44287);
                return false;
            }
        }
        AppMethodBeat.o(44287);
        return true;
    }

    private void d(MallFunction mallFunction) {
        AppMethodBeat.i(44288);
        if (com.tencent.mm.plugin.recharge.model.b.c(mallFunction)) {
            com.tencent.mm.plugin.recharge.model.b.ced();
            ab.d("MicroMsg.PhoneRechargeUI", this.pHj.tDn.toString());
            VD(this.pHj.tDn.tDC);
        }
        AppMethodBeat.o(44288);
    }

    private void VD(final String str) {
        AppMethodBeat.i(44289);
        h.a(this.mController.ylL, getString(R.string.frd), v.hu(this).inflate(R.layout.anl, null), getString(R.string.fre), getString(R.string.frc), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(44259);
                ab.d("MicroMsg.PhoneRechargeUI", "go to h5: %s", PhoneRechargeUI.b(PhoneRechargeUI.this, str));
                PhoneRechargeUI.c(PhoneRechargeUI.this, r0);
                AppMethodBeat.o(44259);
            }
        }, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(44260);
                dialogInterface.dismiss();
                AppMethodBeat.o(44260);
            }
        });
        AppMethodBeat.o(44289);
    }

    private void cel() {
        AppMethodBeat.i(44290);
        this.pGh = new ArrayList();
        q qVar = new q();
        qVar.name = getString(R.string.fqo);
        qVar.status = 0;
        q qVar2 = new q();
        qVar2.name = getString(R.string.fqp);
        qVar2.status = 0;
        q qVar3 = new q();
        qVar3.name = getString(R.string.fqq);
        qVar3.status = 0;
        q qVar4 = new q();
        qVar4.name = getString(R.string.fqr);
        qVar4.status = 0;
        q qVar5 = new q();
        qVar5.name = getString(R.string.fqs);
        qVar5.status = 0;
        q qVar6 = new q();
        qVar6.name = getString(R.string.fqt);
        qVar6.status = 0;
        this.pGh.add(qVar);
        this.pGh.add(qVar2);
        this.pGh.add(qVar3);
        this.pGh.add(qVar4);
        this.pGh.add(qVar5);
        this.pGh.add(qVar6);
        this.pGi = new ArrayList();
        qVar = new q();
        qVar.name = getString(R.string.fqu);
        qVar.status = 0;
        qVar2 = new q();
        qVar2.name = getString(R.string.fqv);
        qVar2.status = 0;
        qVar3 = new q();
        qVar3.name = getString(R.string.fqw);
        qVar3.status = 0;
        this.pGi.add(qVar);
        this.pGi.add(qVar2);
        this.pGi.add(qVar3);
        AppMethodBeat.o(44290);
    }

    public final int getLayoutId() {
        return R.layout.ake;
    }

    private void VE(String str) {
        AppMethodBeat.i(44291);
        h.a((Context) this, str, "", false, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(44261);
                dialogInterface.dismiss();
                AppMethodBeat.o(44261);
            }
        });
        AppMethodBeat.o(44291);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(44292);
        if (mVar instanceof com.tencent.mm.plugin.recharge.model.f) {
            com.tencent.mm.plugin.recharge.model.f fVar = (com.tencent.mm.plugin.recharge.model.f) mVar;
            if (fVar.cmdId != 0) {
                ab.i("MicroMsg.PhoneRechargeUI", "do delete phone number");
                AppMethodBeat.o(44292);
                return;
            } else if (bo.isNullOrNil(fVar.gDV) || fVar.gDV.equals(this.pGW.getText())) {
                o(mVar);
                if (fVar.pGg) {
                    ab.e("MicroMsg.PhoneRechargeUI", "hy: cgi failed.");
                    VE(fVar.aIm);
                    ceh();
                    AppMethodBeat.o(44292);
                    return;
                }
                boolean z;
                boolean z2;
                this.mAppId = fVar.appId;
                this.pGh = fVar.pGh;
                this.pGj = fVar.pGj;
                this.pGk = fVar.pGk;
                this.pGl = fVar.pGl;
                this.pGm = fVar.pGm;
                this.errCode = fVar.errCode;
                this.aIm = fVar.aIm;
                this.pHk = fVar.desc;
                ab.i("MicroMsg.PhoneRechargeUI", "desc: %s, mobile: %s", this.pHk, this.pGW.getText());
                if (bo.isNullOrNil(this.pHk)) {
                    this.desc = "";
                    this.pHl = getResources().getColor(R.color.w4);
                } else if (this.pHo.pGx != null && this.pHo.pGx.pFM.trim().equals(this.pGW.getText())) {
                    this.pHo.pGx.pFN = this.pHk;
                    this.pHo.setInput(this.pHo.pGx);
                }
                this.pHp = fVar.pGo;
                this.pGi = fVar.pGi;
                if (this.pGi != null) {
                    for (int size = this.pGi.size() - 1; size >= 0; size--) {
                        q qVar = (q) this.pGi.get(size);
                        if (qVar.name.isEmpty()) {
                            this.pGi.remove(qVar);
                        }
                    }
                }
                if (fVar.pGn == null || (fVar.pGn.name.equals(this.pGn.name) && fVar.pGn.url.equals(this.pGn.url) && fVar.pGn.tmN.equals(this.pGn.tmN) && fVar.pGn.fjD.equals(this.pGn.fjD))) {
                    z = false;
                } else {
                    ab.i("MicroMsg.PhoneRechargeUI", "need to update head");
                    this.pGn = fVar.pGn;
                    z = true;
                }
                if (this.pHk.equals("")) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                G(z2, z);
                List list = fVar.pGp;
                if (list != null) {
                    ab.d("MicroMsg.PhoneRechargeUI", "update record history");
                    com.tencent.mm.plugin.recharge.a.a.cea().cK(list);
                    if (this.pHo != null) {
                        if (fVar.pGq) {
                            this.pHo.kd(true);
                        } else {
                            this.pHo.kd(false);
                        }
                    }
                }
                this.pGW.postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(44262);
                        PhoneRechargeUI.this.pGW.cex();
                        AppMethodBeat.o(44262);
                    }
                }, 300);
                AppMethodBeat.o(44292);
                return;
            } else {
                ab.i("MicroMsg.PhoneRechargeUI", "hy: mobiel num not match.abourt, %s, %s", fVar.gDV, this.pGW.getText());
                AppMethodBeat.o(44292);
                return;
            }
        }
        if (mVar instanceof com.tencent.mm.plugin.recharge.model.g) {
            o(mVar);
            if (i == 0 && i2 == 0) {
                PayInfo payInfo = ((com.tencent.mm.plugin.recharge.model.g) mVar).pGr;
                payInfo.cIf = 6;
                payInfo.vwe = 100;
                payInfo.kck = this.pGW.getText();
                payInfo.hHV = this.pHo.pGx != null ? this.pHo.pGx.name : "";
                com.tencent.mm.pluginsdk.wallet.h.a(this, payInfo, 2);
                com.tencent.mm.sdk.b.a.xxA.c(this.piM);
                AppMethodBeat.o(44292);
                return;
            }
            if (bo.isNullOrNil(str)) {
                str = getString(R.string.fu2);
            }
            VE(str);
        }
        AppMethodBeat.o(44292);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(44293);
        switch (i) {
            case 1:
                if (i2 == -1) {
                    this.pHq = true;
                    String str = null;
                    final List arrayList = new ArrayList();
                    Uri data = intent.getData();
                    if (data != null) {
                        if (android.support.v4.content.b.checkSelfPermission(this, "android.permission.READ_CONTACTS") == 0) {
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
                                                ab.d("MicroMsg.PhoneRechargeUI", "hy: username : ".concat(String.valueOf(str2)));
                                                if (string != null) {
                                                    ab.d("MicroMsg.PhoneRechargeUI", "hy: phoneNumber : ".concat(String.valueOf(string)));
                                                    String ws = com.tencent.mm.plugin.recharge.model.b.ws(string);
                                                    ab.d("MicroMsg.PhoneRechargeUI", "hy: phoneNumber : ".concat(String.valueOf(ws)));
                                                    if (PhoneNumberUtils.isGlobalPhoneNumber(ws) && ws.length() == 11) {
                                                        arrayList.add(ws);
                                                    }
                                                    ab.d("MicroMsg.PhoneRechargeUI", "hy: phoneResult : ".concat(String.valueOf(ws)));
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
                                        h.b((Context) this, getString(R.string.cyj), "", true);
                                        break;
                                    }
                                    this.pHo.setInput(new com.tencent.mm.plugin.recharge.model.a((String) arrayList.get(0), str, 1));
                                    cem();
                                    break;
                                }
                                com.tencent.mm.ui.widget.a.c a = h.a((Context) this, getString(R.string.fr8), arrayList, -1, new h.a() {
                                    public final void BB(int i) {
                                        AppMethodBeat.i(44266);
                                        ab.d("MicroMsg.PhoneRechargeUI", "choose: %d", Integer.valueOf(i));
                                        PhoneRechargeUI.this.pHo.setInput(new com.tencent.mm.plugin.recharge.model.a((String) arrayList.get(i), str, 1));
                                        PhoneRechargeUI.n(PhoneRechargeUI.this);
                                        AppMethodBeat.o(44266);
                                    }
                                });
                                if (a != null) {
                                    a.setCanceledOnTouchOutside(true);
                                    break;
                                }
                            } catch (SecurityException e) {
                                ab.e("MicroMsg.PhoneRechargeUI", "hy: permission denied: %s", e.toString());
                                h.b((Context) this, getString(R.string.cyl), "", true);
                                break;
                            }
                        }
                        ab.e("MicroMsg.PhoneRechargeUI", "no contact permission");
                        AppMethodBeat.o(44293);
                        return;
                    }
                    ab.e("MicroMsg.PhoneRechargeUI", "hy: uri == null");
                    AppMethodBeat.o(44293);
                    return;
                }
                break;
            case 2:
                if (i2 == -1) {
                    if (!this.piJ) {
                        ab.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : ok");
                        com.tencent.mm.plugin.recharge.a.a.cea().a(new com.tencent.mm.plugin.recharge.model.a(this.pGW.getText(), this.pGW.getTipsTv().getText().toString(), 0));
                        finish();
                        this.piJ = true;
                        break;
                    }
                }
                ab.i("MicroMsg.PhoneRechargeUI", "hy: MallRecharge pay result : cancel");
                break;
                break;
        }
        super.onActivityResult(i, i2, intent);
        AppMethodBeat.o(44293);
    }

    private void cem() {
        AppMethodBeat.i(44294);
        g.Rg().a(new com.tencent.mm.plugin.recharge.model.f(this.pGW.getText()), 0);
        AppMethodBeat.o(44294);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(44278);
        this.yll = true;
        super.onCreate(bundle);
        xE(this.mController.dyj());
        g.Rg().a(1571, (f) this);
        g.Rg().a((int) com.tencent.mm.plugin.appbrand.jsapi.storage.e.CTRL_INDEX, (f) this);
        this.pHj = (MallFunction) getIntent().getParcelableExtra("key_func_info");
        if (this.pHj == null) {
            ab.e("MicroMsg.PhoneRechargeUI", "hy: function info is null");
            t.makeText(this, "function info is null", 1).show();
            finish();
        }
        cel();
        setMMTitle(this.pHj.cOI);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(44252);
                PhoneRechargeUI.this.aqX();
                PhoneRechargeUI.this.finish();
                AppMethodBeat.o(44252);
                return true;
            }
        });
        this.pGn = new e();
        this.pGn.name = getString(R.string.fr1);
        this.pGn.url = getString(R.string.fr2);
        this.pGT = findViewById(R.id.dmo);
        this.pGU = (ImageView) findViewById(R.id.dmq);
        this.pGV = (TextView) findViewById(R.id.dmp);
        this.pGW = (MallFormView) findViewById(R.id.dms);
        com.tencent.mm.plugin.recharge.ui.form.c.b(this.pGW);
        this.pHo = new b(this.pGW);
        b bVar = this.pHo;
        ab.d(com.tencent.mm.plugin.recharge.ui.form.c.TAG, "hy: setMobileEditTv");
        MallFormView mallFormView = bVar.pIg;
        com.tencent.mm.plugin.recharge.ui.form.c.b.AnonymousClass1 anonymousClass1 = new TextWatcher() {
            private int pGA = 0;

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                AppMethodBeat.i(44368);
                String charSequence2 = charSequence.toString();
                int selectionStart = b.this.pIg.getContentEditText().getSelectionStart();
                Object obj = "";
                if (charSequence2 != null) {
                    StringBuilder stringBuilder = new StringBuilder(charSequence2.replaceAll(" ", ""));
                    int length = stringBuilder.length();
                    if (length >= 4) {
                        stringBuilder.insert(3, ' ');
                    }
                    if (length >= 8) {
                        stringBuilder.insert(8, ' ');
                    }
                    obj = stringBuilder.toString();
                    length = obj.length();
                    if (length > this.pGA) {
                        if ((selectionStart == 4 || selectionStart == 9) && i3 == 1) {
                            selectionStart++;
                        } else if ((selectionStart == 4 || selectionStart == 9) && i3 > 1) {
                            selectionStart += i3;
                        }
                    } else if (length < this.pGA && (selectionStart == 4 || selectionStart == 9)) {
                        selectionStart--;
                    }
                    this.pGA = length;
                }
                if (!charSequence2.equals(obj)) {
                    b.this.pIg.getContentEditText().setText(obj);
                    if (selectionStart < this.pGA) {
                        b.this.pIg.getContentEditText().setSelection(selectionStart);
                        AppMethodBeat.o(44368);
                        return;
                    }
                    b.this.pIg.getContentEditText().setSelection(this.pGA);
                }
                AppMethodBeat.o(44368);
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
            }
        };
        if (mallFormView.pIm != null) {
            mallFormView.pIm.addTextChangedListener(anonymousClass1);
        }
        InstantAutoCompleteTextView instantAutoCompleteTextView = (InstantAutoCompleteTextView) bVar.pIg.getContentEditText();
        bVar.pGw = com.tencent.mm.pluginsdk.a.cJ(bVar.pIg.getContext());
        bVar.pIh = new com.tencent.mm.plugin.recharge.ui.form.d(bVar.pIg, bVar.pGw);
        bVar.pIh.pIU = new com.tencent.mm.plugin.recharge.ui.form.d.d() {
        };
        bVar.pIh.pIV = this;
        bVar.kd(true);
        instantAutoCompleteTextView.setShowAlways(true);
        instantAutoCompleteTextView.setAdapter(bVar.pIh);
        instantAutoCompleteTextView.setOnItemClickListener(new com.tencent.mm.plugin.recharge.ui.form.c.b.AnonymousClass3(instantAutoCompleteTextView));
        bVar.pIg.setOnFocusChangeListener(new com.tencent.mm.plugin.recharge.ui.form.c.b.AnonymousClass4(instantAutoCompleteTextView));
        instantAutoCompleteTextView.setOnClickListener(new com.tencent.mm.plugin.recharge.ui.form.c.b.AnonymousClass5(instantAutoCompleteTextView));
        this.pGZ = (GridView) findViewById(R.id.dmw);
        this.pHb = (TextView) findViewById(R.id.dn3);
        this.pHc = (TextView) findViewById(R.id.dn2);
        this.pHd = (TextView) findViewById(R.id.dn4);
        this.pHe = (TextView) findViewById(R.id.dn1);
        this.pGX = (TextView) findViewById(R.id.dmu);
        this.pGY = (TextView) findViewById(R.id.dmx);
        this.pHa = (GridView) findViewById(R.id.dmz);
        this.pHf = (TextView) findViewById(R.id.dmv);
        this.pHg = (TextView) findViewById(R.id.dmy);
        this.pGW.setOnInputValidChangeListener(new MallFormView.a() {
            public final void hY(boolean z) {
                AppMethodBeat.i(44265);
                if (z) {
                    PhoneRechargeUI.this.aqX();
                    final String ws = com.tencent.mm.plugin.recharge.model.b.ws(PhoneRechargeUI.this.pGW.getText());
                    if (ws == null) {
                        ab.e("MicroMsg.PhoneRechargeUI", "null phone, return");
                        AppMethodBeat.o(44265);
                        return;
                    }
                    com.tencent.mm.sdk.g.d.g(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(44264);
                            long currentTimeMillis = System.currentTimeMillis();
                            final com.tencent.mm.plugin.recharge.model.a a = PhoneRechargeUI.a(PhoneRechargeUI.this, ws);
                            ab.d("MicroMsg.PhoneRechargeUI", "handle cost: %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(44263);
                                    PhoneRechargeUI.this.pHo.setInput(a);
                                    PhoneRechargeUI.VF(ws);
                                    AppMethodBeat.o(44263);
                                }
                            });
                            AppMethodBeat.o(44264);
                        }
                    }, "search_matched_mobile");
                    if (PhoneRechargeUI.this.pHq) {
                        PhoneRechargeUI.this.pHq = false;
                        AppMethodBeat.o(44265);
                        return;
                    }
                    ab.d("MicroMsg.PhoneRechargeUI", "clear focus");
                    PhoneRechargeUI.this.pHq = true;
                    AppMethodBeat.o(44265);
                    return;
                }
                PhoneRechargeUI.this.pGW.getTipsTv().setText("");
                PhoneRechargeUI.this.pGW.getTipsTv().setTextColor(PhoneRechargeUI.this.getResources().getColor(R.color.w4));
                PhoneRechargeUI.d(PhoneRechargeUI.this);
                PhoneRechargeUI.e(PhoneRechargeUI.this);
                if (bo.isNullOrNil(PhoneRechargeUI.this.pGW.getText())) {
                    ((AutoCompleteTextView) PhoneRechargeUI.this.pGW.getContentEditText()).showDropDown();
                }
                AppMethodBeat.o(44265);
            }
        });
        this.pGW.getInfoIv().setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(44269);
                if ((PhoneRechargeUI.this.getPackageManager().checkPermission("android.permission.READ_CONTACTS", ah.getPackageName()) == 0 ? 1 : 0) != 0) {
                    Intent intent = new Intent("android.intent.action.PICK", Contacts.CONTENT_URI);
                    if (bo.k(PhoneRechargeUI.this, intent)) {
                        PhoneRechargeUI.this.startActivityForResult(intent, 1);
                    }
                    AppMethodBeat.o(44269);
                    return;
                }
                h.b(PhoneRechargeUI.this, PhoneRechargeUI.this.getString(R.string.fr6), "", true);
                AppMethodBeat.o(44269);
            }
        });
        this.pHh = new b();
        this.pHh.pGM = new b.a() {
            public final void a(q qVar) {
                AppMethodBeat.i(44270);
                if (qVar == null) {
                    ab.e("MicroMsg.PhoneRechargeUI", "hy: no product item");
                    AppMethodBeat.o(44270);
                    return;
                }
                if (!PhoneRechargeUI.a(PhoneRechargeUI.this, qVar.tmN, qVar.fjD)) {
                    if (!bo.isNullOrNil(qVar.url)) {
                        PhoneRechargeUI.c(PhoneRechargeUI.this, PhoneRechargeUI.b(PhoneRechargeUI.this, qVar.url));
                        AppMethodBeat.o(44270);
                        return;
                    } else if (PhoneRechargeUI.a(PhoneRechargeUI.this, qVar)) {
                        PhoneRechargeUI.d(PhoneRechargeUI.this, qVar.id);
                    }
                }
                AppMethodBeat.o(44270);
            }
        };
        this.pHi = new b();
        this.pHi.pGM = new b.a() {
            public final void a(q qVar) {
                AppMethodBeat.i(44271);
                if (!PhoneRechargeUI.a(PhoneRechargeUI.this, qVar.tmN, qVar.fjD)) {
                    if (!bo.isNullOrNil(qVar.url)) {
                        PhoneRechargeUI.c(PhoneRechargeUI.this, PhoneRechargeUI.b(PhoneRechargeUI.this, qVar.url));
                        AppMethodBeat.o(44271);
                        return;
                    } else if (PhoneRechargeUI.a(PhoneRechargeUI.this, qVar)) {
                        PhoneRechargeUI.d(PhoneRechargeUI.this, qVar.id);
                        AppMethodBeat.o(44271);
                        return;
                    } else {
                        ab.w("MicroMsg.PhoneRechargeUI", "error dataFlow click");
                    }
                }
                AppMethodBeat.o(44271);
            }
        };
        this.pGZ.setAdapter(this.pHh);
        this.pHa.setAdapter(this.pHi);
        this.pGU.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(44272);
                if (PhoneRechargeUI.this.pHp != null) {
                    PhoneRechargeUI.g(PhoneRechargeUI.this);
                } else {
                    ab.e("MicroMsg.PhoneRechargeUI", "hy: no banner but show ad. should not happen");
                }
                PhoneRechargeUI.this.pGT.setVisibility(8);
                AppMethodBeat.o(44272);
            }
        });
        this.pGV.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(44273);
                if (PhoneRechargeUI.this.pHp != null) {
                    com.tencent.mm.protocal.g.gu(6, 1);
                    if (!(PhoneRechargeUI.a(PhoneRechargeUI.this, PhoneRechargeUI.this.pHp.tmN, PhoneRechargeUI.this.pHp.fjD) || bo.isNullOrNil(PhoneRechargeUI.this.pHp.url))) {
                        try {
                            PhoneRechargeUI.c(PhoneRechargeUI.this, URLDecoder.decode(PhoneRechargeUI.this.pHp.url, ProtocolPackage.ServerEncoding));
                            AppMethodBeat.o(44273);
                            return;
                        } catch (UnsupportedEncodingException e) {
                            ab.printErrStackTrace("MicroMsg.PhoneRechargeUI", e, "", new Object[0]);
                        }
                    }
                }
                AppMethodBeat.o(44273);
            }
        });
        this.pGW.cew();
        int gd = (com.tencent.mm.bz.a.gd(this) / 4) - 20;
        ab.i("MicroMsg.PhoneRechargeUI", "max width: %s", Integer.valueOf(gd));
        this.pHb.setMaxWidth(gd);
        this.pHc.setMaxWidth(gd);
        this.pHd.setMaxWidth(gd);
        this.pHe.setMaxWidth(gd);
        this.pHl = getResources().getColor(R.color.w4);
        if (!(this.pHo.pGx == null || bo.isNullOrNil(this.pHo.pGx.name))) {
            this.desc = this.pHo.pGx.name;
        }
        this.pGW.getContentEditText().setHintTextColor(getResources().getColor(R.color.xn));
        if (bo.isNullOrNil(this.pGW.getText())) {
            c(new com.tencent.mm.plugin.recharge.model.f(""), false);
            AppMethodBeat.o(44278);
            return;
        }
        c(new com.tencent.mm.plugin.recharge.model.f(this.pGW.getText()), false);
        AppMethodBeat.o(44278);
    }

    public final void cen() {
        AppMethodBeat.i(44295);
        g.Rg().a(new com.tencent.mm.plugin.recharge.model.f("", 1), 0);
        AppMethodBeat.o(44295);
    }

    static /* synthetic */ void VF(String str) {
        AppMethodBeat.i(44297);
        ab.i("MicroMsg.PhoneRechargeUI", "do scene: %s", str);
        g.Rg().a(new com.tencent.mm.plugin.recharge.model.f(str), 0);
        AppMethodBeat.o(44297);
    }

    static /* synthetic */ boolean a(PhoneRechargeUI phoneRechargeUI, String str, String str2) {
        AppMethodBeat.i(44300);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            AppMethodBeat.o(44300);
            return false;
        }
        CharSequence charSequence = "";
        CharSequence charSequence2 = "";
        CharSequence charSequence3 = "";
        if (!(phoneRechargeUI.pHo == null || phoneRechargeUI.pHo.pGx == null || bo.isNullOrNil(phoneRechargeUI.pHo.pGx.name))) {
            com.tencent.mm.plugin.recharge.model.a aVar = phoneRechargeUI.pHo.pGx;
            charSequence = aVar.pFM;
            charSequence2 = aVar.name;
            charSequence3 = aVar.cvp == 3 ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        ab.i("MicroMsg.PhoneRechargeUI", "weappID: %s, weappPath: %s", str, str2.replace("{phone}", charSequence).replace("{remark}", charSequence2).replace("{isbind}", charSequence3));
        se seVar = new se();
        seVar.cOf.userName = str;
        seVar.cOf.cOh = bo.bc(r0, "");
        seVar.cOf.scene = FilterEnum4Shaka.MIC_WEISHI_v4_4_XINXIAN;
        seVar.cOf.cOi = 0;
        com.tencent.mm.sdk.b.a.xxA.m(seVar);
        AppMethodBeat.o(44300);
        return true;
    }

    static /* synthetic */ void d(PhoneRechargeUI phoneRechargeUI, String str) {
        AppMethodBeat.i(44304);
        phoneRechargeUI.c(new com.tencent.mm.plugin.recharge.model.g(phoneRechargeUI.mAppId, phoneRechargeUI.pHj.pFP, str, "mobile=" + com.tencent.mm.plugin.recharge.model.b.ws(phoneRechargeUI.pGW.getText()) + "&markup=" + (phoneRechargeUI.pHo.pGx != null ? phoneRechargeUI.pHo.pGx.name : "")), true);
        AppMethodBeat.o(44304);
    }

    static /* synthetic */ void g(PhoneRechargeUI phoneRechargeUI) {
        AppMethodBeat.i(44305);
        if (phoneRechargeUI.pHp != null) {
            Object valueOf;
            String str = (String) g.RP().Ry().get(ac.a.USERINFO_PHONE_RECHARGE_CLOSED_BANNER_STRING, (Object) "");
            if (bo.isNullOrNil(str)) {
                valueOf = String.valueOf(phoneRechargeUI.pHp.id);
            } else {
                valueOf = str + ";" + phoneRechargeUI.pHp.id;
            }
            g.RP().Ry().set(ac.a.USERINFO_PHONE_RECHARGE_CLOSED_BANNER_STRING, valueOf);
            g.RP().Ry().dsb();
        }
        AppMethodBeat.o(44305);
    }
}
