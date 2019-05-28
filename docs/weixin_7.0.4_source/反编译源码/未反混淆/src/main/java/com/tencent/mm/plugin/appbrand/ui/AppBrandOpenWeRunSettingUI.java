package com.tencent.mm.plugin.appbrand.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.aj.z;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.sport.a.d;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.q;
import java.util.LinkedList;

public class AppBrandOpenWeRunSettingUI extends MMActivity implements f {
    private ad ehM = null;
    private ImageView eks;
    private TextView gne;
    private TextView gnh;
    private TextView gtO;
    private TextView iGX;
    p iGY;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(AppBrandOpenWeRunSettingUI appBrandOpenWeRunSettingUI) {
        AppMethodBeat.i(133001);
        appBrandOpenWeRunSettingUI.aMk();
        AppMethodBeat.o(133001);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(132998);
        super.onCreate(bundle);
        setMMTitle(getString(R.string.la));
        this.eks = (ImageView) findViewById(R.id.s3);
        this.gtO = (TextView) findViewById(R.id.s4);
        this.gnh = (TextView) findViewById(R.id.s5);
        this.gne = (TextView) findViewById(R.id.s6);
        this.iGX = (TextView) findViewById(R.id.s8);
        this.iGX.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(132994);
                d.kT(13);
                f fVar = AppBrandOpenWeRunSettingUI.this;
                fVar.getString(R.string.tz);
                fVar.iGY = h.b((Context) fVar, fVar.getString(R.string.e_c), true, null);
                fVar.iGY.show();
                g.RO().eJo.a(30, fVar);
                LinkedList linkedList = new LinkedList();
                linkedList.add("gh_43f2581f6fd6");
                LinkedList linkedList2 = new LinkedList();
                linkedList2.add(Integer.valueOf(1));
                g.RO().eJo.a(new m(1, linkedList, linkedList2, "", ""), 0);
                AppMethodBeat.o(132994);
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(132995);
                AppBrandOpenWeRunSettingUI.this.finish();
                AppMethodBeat.o(132995);
                return true;
            }
        });
        String nullAsNil = bo.nullAsNil(getIntent().getStringExtra("OpenWeRunSettingName"));
        this.ehM = ((j) g.K(j.class)).XM().aoO("gh_43f2581f6fd6");
        if (this.ehM == null || ((int) this.ehM.ewQ) == 0) {
            getString(R.string.tz);
            this.iGY = h.b((Context) this, getString(R.string.un), true, null);
            this.iGY.show();
            a.flu.a("gh_43f2581f6fd6", "", new b.a() {
                public final void o(String str, boolean z) {
                    AppMethodBeat.i(132996);
                    ab.i("MicroMsg.AppBrandOpenWeRunSettingUI", "getContactCallBack, suc = %b,user %s", Boolean.valueOf(z), str);
                    AppBrandOpenWeRunSettingUI.this.ehM = ((j) g.K(j.class)).XM().aoO("gh_43f2581f6fd6");
                    AppBrandOpenWeRunSettingUI.a(AppBrandOpenWeRunSettingUI.this);
                    AppBrandOpenWeRunSettingUI.this.iGY.dismiss();
                    AppMethodBeat.o(132996);
                }
            });
        }
        this.gne.setText(getString(R.string.lc, new Object[]{nullAsNil}));
        aMk();
        AppMethodBeat.o(132998);
    }

    public final int getLayoutId() {
        return R.layout.ck;
    }

    private void aMk() {
        AppMethodBeat.i(132999);
        com.tencent.mm.pluginsdk.ui.a.b.b(this.eks, this.ehM.field_username);
        this.gtO.setText(this.ehM.Oj());
        if (com.tencent.mm.n.a.jh(this.ehM.field_type)) {
            this.gnh.setTextColor(q.ii(this.mController.ylL));
            this.gnh.setText(R.string.e_a);
            this.gnh.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ap2, 0, 0, 0);
            this.iGX.setText(R.string.e_a);
            this.iGX.setClickable(false);
            AppMethodBeat.o(132999);
            return;
        }
        this.gnh.setTextColor(q.ij(this.mController.ylL));
        this.gnh.setText(R.string.e_i);
        this.gnh.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ap1, 0, 0, 0);
        this.iGX.setText(R.string.e_9);
        this.iGX.setClickable(true);
        AppMethodBeat.o(132999);
    }

    public void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(133000);
        if (mVar instanceof m) {
            g.RO().eJo.b(30, (f) this);
            if (i == 0 && i2 == 0) {
                String dhl = ((m) mVar).dhl();
                ab.i("MicroMsg.AppBrandOpenWeRunSettingUI", "bind fitness contact %s success", dhl);
                this.ehM = ((j) g.K(j.class)).XM().aoO("gh_43f2581f6fd6");
                ad adVar = this.ehM;
                if (adVar == null || bo.isNullOrNil(dhl)) {
                    ab.e("MicroMsg.AppBrandOpenWeRunSettingUI", "respUsername == " + dhl + ", contact = " + adVar);
                } else {
                    com.tencent.mm.aj.d dVar;
                    if (t.mX(adVar.field_username)) {
                        String nullAsNil = bo.nullAsNil(adVar.field_username);
                        com.tencent.mm.aj.d qX = com.tencent.mm.aj.f.qX(nullAsNil);
                        if (qX != null) {
                            qX.field_username = dhl;
                        }
                        z.aeR().delete(nullAsNil);
                        adVar.iH(nullAsNil);
                        dVar = qX;
                    } else {
                        dVar = null;
                    }
                    adVar.setUsername(dhl);
                    if (((int) adVar.ewQ) == 0) {
                        ((j) g.K(j.class)).XM().aa(adVar);
                    }
                    if (((int) adVar.ewQ) <= 0) {
                        ab.e("MicroMsg.AppBrandOpenWeRunSettingUI", "addContact : insert contact failed");
                    } else {
                        t.q(adVar);
                        ad aoO = ((j) g.K(j.class)).XM().aoO(adVar.field_username);
                        if (dVar != null) {
                            z.aeR().d(dVar);
                        } else {
                            dVar = com.tencent.mm.aj.f.qX(aoO.field_username);
                            if (dVar == null || dVar.adJ()) {
                                ab.d("MicroMsg.AppBrandOpenWeRunSettingUI", "shouldUpdate");
                                a.flu.ai(aoO.field_username, "");
                                com.tencent.mm.ah.b.pY(aoO.field_username);
                            } else if (aoO.dsi()) {
                                ab.d("MicroMsg.AppBrandOpenWeRunSettingUI", "update contact, last check time=%d", Integer.valueOf(aoO.duj));
                                a.flu.ai(aoO.field_username, "");
                                com.tencent.mm.ah.b.pY(aoO.field_username);
                            }
                        }
                    }
                }
                z.aeR().e(z.aeR().qP(this.ehM.field_username));
                g.RP().Ry().set(327825, Boolean.TRUE);
                setResult(-1);
                al.n(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(132997);
                        AppBrandOpenWeRunSettingUI.this.finish();
                        AppMethodBeat.o(132997);
                    }
                }, 1500);
            } else {
                ab.e("MicroMsg.AppBrandOpenWeRunSettingUI", "errType %d | errCode %d | errMsg %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                if (i == 4 && i2 == -24 && !bo.isNullOrNil(str)) {
                    Toast.makeText(ah.getContext(), str, 1).show();
                }
                setResult(1);
            }
            if (this.iGY != null) {
                this.iGY.dismiss();
            }
            aMk();
        }
        AppMethodBeat.o(133000);
    }
}
