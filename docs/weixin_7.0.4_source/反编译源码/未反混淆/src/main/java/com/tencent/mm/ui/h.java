package com.tencent.mm.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bg.e;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.be;
import com.tencent.mm.g.a.ij;
import com.tencent.mm.g.a.ij.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.modelsimple.r;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.account.bind.ui.BindMContactUI;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.a.c;

public final class h {
    int cur = 0;
    ProgressDialog ehJ;
    c gup;
    EditText qmA;
    boolean qmB;
    private View qmy;
    private TextView qmz;
    MMFragmentActivity yhZ;
    b yia;
    a yib = null;
    f yic;
    boolean yid = false;
    boolean yie = false;
    com.tencent.mm.sdk.b.c yif = new com.tencent.mm.sdk.b.c<ij>() {
        {
            AppMethodBeat.i(29306);
            this.xxI = ij.class.getName().hashCode();
            AppMethodBeat.o(29306);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(29307);
            ij ijVar = (ij) bVar;
            if (ijVar == null || ijVar.cDv == null || ijVar.cDv.cDw == null) {
                ab.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert event is illegal event[%s]", ijVar);
            } else {
                ab.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert event launcherUI isResumeStatus[%b], tid[%d]", Boolean.valueOf(h.this.yia.dxp()), Long.valueOf(Thread.currentThread().getId()));
                if (h.this.yia.dxp()) {
                    h.this.yib = null;
                    h.this.a(ijVar.cDv);
                } else {
                    h.this.yib = ijVar.cDv;
                }
            }
            AppMethodBeat.o(29307);
            return false;
        }
    };
    com.tencent.mm.sdk.b.c<be> yig = new com.tencent.mm.sdk.b.c<be>() {
        {
            AppMethodBeat.i(29308);
            this.xxI = be.class.getName().hashCode();
            AppMethodBeat.o(29308);
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            be beVar = (be) bVar;
            h.this.cur = beVar.cuq.cur;
            return false;
        }
    };

    public h(MMFragmentActivity mMFragmentActivity, b bVar) {
        AppMethodBeat.i(29327);
        this.yhZ = mMFragmentActivity;
        this.yia = bVar;
        AppMethodBeat.o(29327);
    }

    /* Access modifiers changed, original: final */
    public final boolean a(a aVar) {
        AppMethodBeat.i(29328);
        if (aVar == null || aVar.cDw == null || aVar.cDw.vzI == null || aVar.cDw.vzI.size() == 0) {
            AppMethodBeat.o(29328);
            return false;
        }
        final int i = aVar.cDw.id;
        String str = aVar.cDw.title;
        String str2 = aVar.cDw.bzH;
        int i2 = aVar.type;
        int size = aVar.cDw.vzI.size();
        if (i2 == 0) {
            if (size == 1) {
                final com.tencent.mm.protocal.b.a.a aVar2 = (com.tencent.mm.protocal.b.a.a) aVar.cDw.vzI.get(0);
                ab.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert id[%d], title[%s], msg[%s], id[%d], action[%d], btnstr[%s], btnurl[%s]", Integer.valueOf(i), str, str2, Integer.valueOf(aVar2.id), Integer.valueOf(aVar2.actionType), aVar2.vzG, aVar2.vzH);
                com.tencent.mm.ui.base.h.a(this.yhZ, str2, str, aVar2.vzG, false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(29318);
                        h.a(h.this, i, aVar2.actionType, aVar2.id, aVar2.vzH);
                        dialogInterface.dismiss();
                        AppMethodBeat.o(29318);
                    }
                });
            } else {
                final com.tencent.mm.protocal.b.a.a aVar3 = (com.tencent.mm.protocal.b.a.a) aVar.cDw.vzI.get(1);
                final com.tencent.mm.protocal.b.a.a aVar4 = (com.tencent.mm.protocal.b.a.a) aVar.cDw.vzI.get(0);
                ab.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert title[%s], msg[%s], id1[%d], action1[%d], btnstr1[%s],btnurl1[%s], id2[%d], action2[%d], btnstr2[%s], btnurl2[%s]", str, str2, Integer.valueOf(aVar3.id), Integer.valueOf(aVar3.actionType), aVar3.vzG, aVar3.vzH, Integer.valueOf(aVar4.id), Integer.valueOf(aVar4.actionType), aVar4.vzG, aVar4.vzH);
                com.tencent.mm.ui.base.h.a(this.yhZ, str2, str, aVar3.vzG, aVar4.vzG, false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(29319);
                        h.a(h.this, i, aVar3.actionType, aVar3.id, aVar3.vzH);
                        dialogInterface.dismiss();
                        AppMethodBeat.o(29319);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(29320);
                        h.a(h.this, i, aVar4.actionType, aVar4.id, aVar4.vzH);
                        dialogInterface.dismiss();
                        AppMethodBeat.o(29320);
                    }
                });
            }
        } else if (i2 == 1) {
            com.tencent.mm.ui.base.h.a(this.yhZ, str2, str, ((com.tencent.mm.protocal.b.a.a) aVar.cDw.vzI.get(0)).vzG, ((com.tencent.mm.protocal.b.a.a) aVar.cDw.vzI.get(1)).vzG, false, aVar.cDx, aVar.cDy);
        }
        AppMethodBeat.o(29328);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final f dxf() {
        AppMethodBeat.i(29329);
        if (this.yic == null) {
            this.yic = new f() {
                public final void onSceneEnd(int i, int i2, String str, m mVar) {
                    AppMethodBeat.i(29323);
                    ab.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + mVar.getType());
                    if (h.this.ehJ != null) {
                        h.this.ehJ.dismiss();
                        h.this.ehJ = null;
                    }
                    if (mVar.getType() == 255) {
                        aw.Rg().b(255, h.this.yic);
                        if (i == 0 && i2 == 0) {
                            h.this.pF(true);
                            AppMethodBeat.o(29323);
                            return;
                        } else if (u.a.a(h.this.yhZ, i, i2, str, 4)) {
                            AppMethodBeat.o(29323);
                            return;
                        } else {
                            h.this.pF(false);
                            AppMethodBeat.o(29323);
                            return;
                        }
                    }
                    if (mVar.getType() == 384) {
                        if (i == 0 && i2 == 0) {
                            aw.ZK();
                            com.tencent.mm.model.c.Ry().set(77830, ((aa) mVar).agg());
                            Intent intent = new Intent(h.this.yhZ, RegByMobileSetPwdUI.class);
                            intent.putExtra("kintent_hint", h.this.getString(R.string.e8s));
                            h.this.yhZ.startActivity(intent);
                            AppMethodBeat.o(29323);
                            return;
                        }
                        h.this.qmB = true;
                        com.tencent.mm.ui.base.h.a(h.this.yhZ, (int) R.string.e9r, (int) R.string.tz, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(29322);
                                h.this.dxg();
                                AppMethodBeat.o(29322);
                            }
                        });
                    }
                    AppMethodBeat.o(29323);
                }
            };
        }
        f fVar = this.yic;
        AppMethodBeat.o(29329);
        return fVar;
    }

    /* Access modifiers changed, original: final */
    public final void pF(boolean z) {
        AppMethodBeat.i(29330);
        ab.d("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert handlePassword ".concat(String.valueOf(z)));
        if (z) {
            dxg();
            AppMethodBeat.o(29330);
            return;
        }
        Intent intent = new Intent(this.yhZ, RegByMobileSetPwdUI.class);
        intent.putExtra("kintent_hint", getString(R.string.e8s));
        this.yhZ.startActivity(intent);
        AppMethodBeat.o(29330);
    }

    /* Access modifiers changed, original: final */
    public final void dxg() {
        AppMethodBeat.i(29331);
        if (this.gup != null) {
            this.gup.show();
            AppMethodBeat.o(29331);
            return;
        }
        if (this.qmy == null) {
            this.qmy = View.inflate(this.yhZ, R.layout.arb, null);
            this.qmz = (TextView) this.qmy.findViewById(R.id.e91);
            this.qmz.setText(getString(R.string.e7i));
            this.qmA = (EditText) this.qmy.findViewById(R.id.e92);
            this.qmA.setInputType(GmsClientSupervisor.DEFAULT_BIND_FLAGS);
        }
        this.gup = com.tencent.mm.ui.base.h.a(this.yhZ, null, this.qmy, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(29325);
                String obj = h.this.qmA.getText().toString();
                h.this.qmA.setText("");
                h.this.qmA.clearFocus();
                ah.a(h.this.yhZ, h.this.qmA);
                if (obj == null || obj.equals("")) {
                    com.tencent.mm.ui.base.h.a(h.this.yhZ, (int) R.string.f0s, (int) R.string.tz, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    AppMethodBeat.o(29325);
                    return;
                }
                h.this.dxf();
                aw.Rg().a(384, h.this.yic);
                final m aaVar = new aa(obj, "", "", "");
                aw.Rg().a(aaVar, 0);
                h hVar = h.this;
                Context context = h.this.yhZ;
                h.this.getString(R.string.tz);
                hVar.ehJ = com.tencent.mm.ui.base.h.b(context, h.this.getString(R.string.e7z), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(29324);
                        aw.Rg().b(384, h.this.yic);
                        h.this.yic = null;
                        aw.Rg().c(aaVar);
                        AppMethodBeat.o(29324);
                    }
                });
                AppMethodBeat.o(29325);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(29326);
                h.this.qmA.setText("");
                h.this.gup.dismiss();
                AppMethodBeat.o(29326);
            }
        });
        AppMethodBeat.o(29331);
    }

    /* Access modifiers changed, original: final */
    public final String getString(int i) {
        AppMethodBeat.i(29332);
        String string = this.yhZ.getString(i);
        AppMethodBeat.o(29332);
        return string;
    }

    static /* synthetic */ void a(h hVar, int i, int i2, int i3, String str) {
        AppMethodBeat.i(29333);
        ab.i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert jumpByActionType  alertId[%d], actionType[%d], btnId[%d], url[%s]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        com.tencent.mm.plugin.report.service.h.pYm.e(13191, Integer.valueOf(i), Integer.valueOf(i3), Boolean.FALSE);
        Intent intent;
        switch (i2) {
            case 1:
                AppMethodBeat.o(29333);
                return;
            case 2:
                intent = new Intent();
                intent.putExtra("rawUrl", str);
                intent.putExtra("showShare", false);
                intent.putExtra("show_bottom", false);
                intent.putExtra("needRedirect", false);
                intent.putExtra("neverGetA8Key", true);
                intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.vxI);
                intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.vxE);
                d.b(hVar.yhZ, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(29333);
                return;
            case 3:
                if (hVar.qmB) {
                    hVar.pF(true);
                    AppMethodBeat.o(29333);
                    return;
                }
                hVar.dxf();
                aw.Rg().a(255, hVar.yic);
                final m rVar = new r(1);
                aw.Rg().a(rVar, 0);
                Context context = hVar.yhZ;
                hVar.getString(R.string.tz);
                hVar.ehJ = com.tencent.mm.ui.base.h.b(context, hVar.getString(R.string.e7z), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(29321);
                        aw.Rg().c(rVar);
                        AppMethodBeat.o(29321);
                    }
                });
                AppMethodBeat.o(29333);
                return;
            case 4:
                Intent intent2 = new Intent();
                intent2.setClass(hVar.yhZ, BindMContactUI.class);
                intent2.putExtra("bind_scene", 3);
                String simCountryIso = ((TelephonyManager) hVar.yhZ.getSystemService("phone")).getSimCountryIso();
                if (!ah.isNullOrNil(simCountryIso)) {
                    com.tencent.mm.au.b.a k = com.tencent.mm.au.b.k(hVar.yhZ, simCountryIso, hVar.getString(R.string.b3_));
                    if (k != null) {
                        intent2.putExtra("country_name", k.fHE);
                        intent2.putExtra("couttry_code", k.fHD);
                    }
                }
                MMWizardActivity.J(hVar.yhZ, intent2);
                AppMethodBeat.o(29333);
                return;
            case 5:
                intent = new Intent();
                intent.putExtra("BaseScanUI_select_scan_mode", 1);
                intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
                intent.setFlags(65536);
                if (!(com.tencent.mm.r.a.bI(hVar.yhZ) || e.akI())) {
                    d.b(hVar.yhZ, "scanner", ".ui.BaseScanUI", intent);
                    break;
                }
        }
        AppMethodBeat.o(29333);
    }
}
