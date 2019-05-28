package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.kernel.l;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.plugin.p.b;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.f.e;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.aph;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSummaryPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.tools.r;
import com.tencent.mm.ui.v;
import com.tencent.mm.x.c;

@i
public class SettingsAboutMicroMsgUI extends MMPreference implements f {
    private com.tencent.mm.ui.base.preference.f ehK;
    private boolean qlV = false;
    private aph qlW;
    private int qlX = 0;
    Intent qlY = null;
    private ProgressDialog qlZ;
    private ap qma;
    private f qmb = null;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public final int JC() {
        return R.xml.bt;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127098);
        super.onCreate(bundle);
        dyb();
        initView();
        g.Rg().a(11, (f) this);
        if (d.bQU() != null) {
            g.Rg().a((m) d.bQU().bQT(), 0);
            h.pYm.a(405, 15, 1, true);
        }
        AppMethodBeat.o(127098);
    }

    public void onResume() {
        AppMethodBeat.i(127099);
        super.onResume();
        ciD();
        AppMethodBeat.o(127099);
    }

    public void onDestroy() {
        AppMethodBeat.i(127100);
        g.Rg().b(11, (f) this);
        super.onDestroy();
        AppMethodBeat.o(127100);
    }

    public final void initView() {
        AppMethodBeat.i(127101);
        setMMTitle("");
        xE(getResources().getColor(R.color.d4));
        setBackGroundColorResource(R.color.d4);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127087);
                SettingsAboutMicroMsgUI.this.aqX();
                SettingsAboutMicroMsgUI.this.finish();
                AppMethodBeat.o(127087);
                return true;
            }
        });
        if (this.nDp != null) {
            int dimensionPixelSize = this.mController.ylL.getResources().getDimensionPixelSize(R.dimen.g9);
            this.nDp.setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            this.nDp.setBackgroundColor(getResources().getColor(R.color.d4));
        }
        ciD();
        AppMethodBeat.o(127101);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(127104);
        ab.d("MicroMsg.SettingsAboutMicroMsgUI", "onSceneEnd " + i2 + " errType " + i);
        b bVar = (b) mVar;
        ab.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.getDownloadUrls() " + bVar.bQQ());
        ab.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.getPackVersion() " + bVar.bQP());
        ab.d("MicroMsg.SettingsAboutMicroMsgUI", "updateInfo.now getPackVersion() " + com.tencent.mm.protocal.d.vxo);
        if (d.oEm || (i == 0 && i2 == 0)) {
            this.qlX = bVar.bQP();
            if (this.qlX <= 0 || this.qlX <= com.tencent.mm.protocal.d.vxo) {
                this.qlV = false;
                if (g.RN().QY()) {
                    c.PK().x(262145, false);
                } else {
                    ab.e("MicroMsg.SettingsAboutMicroMsgUI", "SubCoreHub.getNewBadge() uin not ready!");
                }
            } else {
                this.qlV = true;
                if (g.RN().QY()) {
                    c.PK().x(262145, true);
                } else {
                    ab.e("MicroMsg.SettingsAboutMicroMsgUI", "SubCoreHub.getNewBadge() uin not ready!");
                }
            }
            this.qlW = bVar.bQR();
        }
        ciD();
        AppMethodBeat.o(127104);
    }

    public final View ciC() {
        AppMethodBeat.i(127097);
        LinearLayout linearLayout = (LinearLayout) v.hu(this.mController.ylL).inflate(R.layout.arl, null);
        TextView textView = (TextView) linearLayout.findViewById(R.id.e9l);
        TextView textView2 = (TextView) linearLayout.findViewById(R.id.e9m);
        String obj = g.RP().Ry().get(274436, (Object) "").toString();
        if (bo.isNullOrNil(obj)) {
            obj = aa.doq();
        }
        if (!(bo.isNullOrNil(obj) || bo.amU(obj))) {
            obj = "";
        }
        obj = getString(R.string.g7o, new Object[]{aa.dor(), obj, "setting", Integer.valueOf(0), Integer.valueOf(0)});
        textView.setText(String.format("<a href='%s'>%s</a>", new Object[]{getString(R.string.ezj), getString(R.string.cmg)}));
        textView2.setText(String.format("<a href='%s'>%s</a>", new Object[]{obj, getString(R.string.dei)}));
        j.h(textView, 1);
        j.h(textView2, 1);
        ((TextView) linearLayout.findViewById(R.id.e9n)).setText(linearLayout.getResources().getString(R.string.p0, new Object[]{Integer.valueOf(2019)}));
        AppMethodBeat.o(127097);
        return linearLayout;
    }

    private void ciD() {
        IconPreference iconPreference;
        boolean z;
        AppMethodBeat.i(127102);
        this.ehK = this.yCw;
        this.ehK.removeAll();
        this.ehK.addPreferencesFromResource(R.xml.bt);
        SettingsAboutMMHeaderPreference settingsAboutMMHeaderPreference = (SettingsAboutMMHeaderPreference) this.ehK.aqO("settings_about_mm_header");
        String ar = com.tencent.mm.sdk.platformtools.g.ar(this.mController.ylL, com.tencent.mm.protocal.d.vxo);
        if (com.tencent.mm.protocal.d.vxr) {
            ar = ar + " " + getString(R.string.fk);
        }
        settingsAboutMMHeaderPreference.qlS = ar;
        if (aa.doo()) {
            int h = bo.h((Integer) g.RP().Ry().get(12304, null));
            iconPreference = (IconPreference) this.ehK.aqO("settings_update");
            if (h > 0) {
                iconPreference.NL(0);
                iconPreference.ey(String.valueOf(h), r.ik(this.mController.ylL));
            } else {
                iconPreference.NL(8);
                iconPreference.ey("", -1);
            }
        }
        if ((com.tencent.mm.sdk.platformtools.g.cdh & 1) != 0) {
            z = true;
        } else {
            z = false;
        }
        IconSummaryPreference iconSummaryPreference;
        if (this.qlV && !com.tencent.mm.sdk.platformtools.g.xyg) {
            iconSummaryPreference = (IconSummaryPreference) this.ehK.aqO("funtion_update");
            iconSummaryPreference.qlf = 0;
            CharSequence ar2 = com.tencent.mm.sdk.platformtools.g.ar(null, this.qlX);
            iconSummaryPreference.aqR(getString(R.string.s0));
            iconSummaryPreference.setSummary(ar2);
            iconSummaryPreference.dAA();
            this.ehK.aqP("funtion_check_update");
        } else if (z || this.qlW == null || this.qlW.wtp == 0 || bo.isNullOrNil(this.qlW.wtq) || com.tencent.mm.sdk.platformtools.g.xyg) {
            this.ehK.aqP("funtion_update");
        } else {
            ab.i("MicroMsg.SettingsAboutMicroMsgUI", "show alpha update. url:%s, hint:%d", this.qlW.wtq, Integer.valueOf(this.qlW.wtr));
            if (this.qlW.wtr != 0) {
                iconSummaryPreference = (IconSummaryPreference) this.ehK.aqO("funtion_update");
                iconSummaryPreference.qlf = 0;
                iconSummaryPreference.aqR(getString(R.string.s0));
                this.ehK.aqP("funtion_check_update");
            } else {
                this.ehK.aqP("funtion_update");
            }
        }
        if (!aa.doo()) {
            this.ehK.ce("settings_report", true);
        }
        if (!e.vdx.Ch()) {
            this.ehK.ce("funtion_about_wechat", true);
        }
        if (bo.isNullOrNil((String) g.RP().Ry().get(a.USERINFO_CROWDTEST_APPLY_LINK_STRING, null))) {
            this.ehK.aqP("funtion_crowdtest_update");
        } else {
            iconPreference = (IconPreference) this.ehK.aqO("funtion_crowdtest_update");
            if (c.PK().bY(262157, 266263)) {
                iconPreference.NN(0);
            }
        }
        this.ehK.notifyDataSetChanged();
        AppMethodBeat.o(127102);
    }

    public final boolean a(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        AppMethodBeat.i(127103);
        String str = preference.mKey;
        ab.i("MicroMsg.SettingsAboutMicroMsgUI", str + " item has been clicked!");
        Intent intent;
        if (str.equals("settings_update")) {
            if (aa.doo()) {
                g.RN();
                int QF = com.tencent.mm.kernel.a.QF();
                int h = bo.h((Integer) g.RP().Ry().get(12304, null));
                str = getString(R.string.ebk, new Object[]{Integer.valueOf(QF), Integer.valueOf(h)});
                if (str == null) {
                    AppMethodBeat.o(127103);
                    return true;
                }
                g.RP().Ry().set(12304, Integer.valueOf(0));
                intent = new Intent();
                intent.putExtra("title", getString(R.string.ebj));
                intent.putExtra("rawUrl", str);
                intent.putExtra("showShare", false);
                com.tencent.mm.bp.d.b(this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.o(127103);
                return true;
            }
            if (aa.doo()) {
                str = getString(R.string.e7b, new Object[]{aa.dor(), Integer.valueOf(com.tencent.mm.protocal.d.vxo)});
            } else {
                str = "https://blog.wechat.com/";
            }
            intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", false);
            intent.putExtra("show_bottom", false);
            com.tencent.mm.bp.d.b(this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(127103);
            return true;
        } else if (str.equals("funtion_update")) {
            h.pYm.a(405, 16, 1, true);
            str = "";
            if (this.qlV) {
                str = getString(R.string.e7c, new Object[]{aa.dor(), Integer.valueOf(this.qlX)});
            } else if (!(this.qlW == null || this.qlW.wtp == 0 || bo.isNullOrNil(this.qlW.wtq))) {
                str = this.qlW.wtq;
            }
            intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", true);
            intent.putExtra("show_bottom", false);
            com.tencent.mm.bp.d.b(this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(127103);
            return true;
        } else if (str.equals("funtion_check_update")) {
            h.pYm.a(405, 17, 1, true);
            if (d.bQU() != null) {
                d.bQU().bQS();
                if ((com.tencent.mm.sdk.platformtools.g.cdh & 1) != 0) {
                    ab.e("MicroMsg.SettingsAboutMicroMsgUI", "package has set external update mode");
                    Uri parse = Uri.parse(com.tencent.mm.sdk.platformtools.g.xyc);
                    intent = new Intent("android.intent.action.VIEW", parse).addFlags(268435456);
                    if (parse == null || intent == null || !bo.k(this.mController.ylL, intent)) {
                        ab.e("MicroMsg.SettingsAboutMicroMsgUI", "parse market uri failed, jump to weixin.qq.com");
                        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com")).addFlags(268435456));
                        h.pYm.a(405, 18, 1, true);
                    } else {
                        ab.i("MicroMsg.SettingsAboutMicroMsgUI", "parse market uri ok");
                        startActivity(intent);
                        h.pYm.a(405, 19, 1, true);
                    }
                    AppMethodBeat.o(127103);
                    return true;
                } else if (this.qlW == null || this.qlW.wtp == 0 || bo.isNullOrNil(this.qlW.wtq)) {
                    ah.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bo.anT()).commit();
                    com.tencent.mm.plugin.p.a c = d.bQU().c(this, new OnCancelListener() {
                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(127096);
                            h.pYm.a(405, 23, 1, true);
                            AppMethodBeat.o(127096);
                        }
                    });
                    if (c == null) {
                        h.pYm.a(405, 21, 1, true);
                    } else {
                        h.pYm.a(405, 22, 1, true);
                        c.update(3);
                        AppMethodBeat.o(127103);
                        return true;
                    }
                } else {
                    str = this.qlW.wtq;
                    intent = new Intent();
                    intent.putExtra("rawUrl", str);
                    intent.putExtra("showShare", false);
                    intent.putExtra("show_bottom", false);
                    com.tencent.mm.bp.d.b(this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
                    h.pYm.a(405, 20, 1, true);
                    AppMethodBeat.o(127103);
                    return true;
                }
            }
            AppMethodBeat.o(127103);
            return false;
        } else if (str.equals("funtion_about_wechat")) {
            com.tencent.mm.bp.d.b((Context) this, "whatsnew", ".ui.WhatsNewUI", new Intent());
            AppMethodBeat.o(127103);
            return true;
        } else if (str.equals("settings_report")) {
            intent = new Intent();
            intent.putExtra("showShare", false);
            intent.putExtra("show_feedback", false);
            intent.putExtra("rawUrl", "https://support.weixin.qq.com/security/readtemplate?t=complaints/index");
            com.tencent.mm.bp.d.b(this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(127103);
            return true;
        } else if (str.equals("settings_quit_wechat")) {
            com.tencent.mm.ui.base.h.a(this.mController.ylL, (int) R.string.cw1, (int) R.string.cw0, (int) R.string.up, (int) R.string.s2, new OnClickListener() {
                private ap fJs = null;
                private f fQS = null;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    AppMethodBeat.i(127091);
                    com.tencent.mm.modelstat.c.akc().commitNow();
                    ((com.tencent.mm.plugin.expt.a.c) g.K(com.tencent.mm.plugin.expt.a.c.class)).logout();
                    g.RQ();
                    if (com.tencent.mm.kernel.a.jP(g.RN().eIV)) {
                        p Rg = g.Rg();
                        f anonymousClass1 = new f() {
                            public final void onSceneEnd(int i, int i2, String str, m mVar) {
                                AppMethodBeat.i(127088);
                                g.Rg().b((int) com.tencent.view.d.MIC_PTU_TRANS_KONGCHENG, AnonymousClass2.this.fQS);
                                AnonymousClass2.this.fQS = null;
                                if (AnonymousClass2.this.fJs != null) {
                                    AnonymousClass2.this.fJs.stopTimer();
                                    AnonymousClass2.this.fJs = null;
                                }
                                if (SettingsAboutMicroMsgUI.this.qlZ != null) {
                                    SettingsAboutMicroMsgUI.this.qlZ.dismiss();
                                }
                                SettingsAboutMicroMsgUI.b(SettingsAboutMicroMsgUI.this);
                                AppMethodBeat.o(127088);
                            }
                        };
                        this.fQS = anonymousClass1;
                        Rg.a((int) com.tencent.view.d.MIC_PTU_TRANS_KONGCHENG, anonymousClass1);
                        final m abVar = new com.tencent.mm.modelsimple.ab(2);
                        g.Rg().a(abVar, 0);
                        this.fJs = new ap(new ap.a() {
                            public final boolean BI() {
                                AppMethodBeat.i(127089);
                                g.Rg().c(abVar);
                                g.Rg().b((int) com.tencent.view.d.MIC_PTU_TRANS_KONGCHENG, AnonymousClass2.this.fQS);
                                AnonymousClass2.this.fQS = null;
                                if (AnonymousClass2.this.fJs != null) {
                                    AnonymousClass2.this.fJs.stopTimer();
                                    AnonymousClass2.this.fJs = null;
                                }
                                if (SettingsAboutMicroMsgUI.this.qlZ != null) {
                                    SettingsAboutMicroMsgUI.this.qlZ.dismiss();
                                }
                                SettingsAboutMicroMsgUI.b(SettingsAboutMicroMsgUI.this);
                                AppMethodBeat.o(127089);
                                return false;
                            }
                        }, false);
                        this.fJs.ae(5000, 5000);
                        SettingsAboutMicroMsgUI settingsAboutMicroMsgUI = SettingsAboutMicroMsgUI.this;
                        Context context = SettingsAboutMicroMsgUI.this.mController.ylL;
                        SettingsAboutMicroMsgUI.this.getString(R.string.tz);
                        settingsAboutMicroMsgUI.qlZ = com.tencent.mm.ui.base.h.b(context, SettingsAboutMicroMsgUI.this.getString(R.string.g05), true, new OnCancelListener() {
                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(127090);
                                g.Rg().c(abVar);
                                g.Rg().b((int) com.tencent.view.d.MIC_PTU_TRANS_KONGCHENG, AnonymousClass2.this.fQS);
                                AnonymousClass2.this.fQS = null;
                                if (AnonymousClass2.this.fJs != null) {
                                    AnonymousClass2.this.fJs.stopTimer();
                                    AnonymousClass2.this.fJs = null;
                                }
                                if (SettingsAboutMicroMsgUI.this.qlZ != null) {
                                    SettingsAboutMicroMsgUI.this.qlZ.dismiss();
                                }
                                AppMethodBeat.o(127090);
                            }
                        });
                        AppMethodBeat.o(127091);
                        return;
                    }
                    SettingsAboutMicroMsgUI.b(SettingsAboutMicroMsgUI.this);
                    AppMethodBeat.o(127091);
                }
            }, null);
            AppMethodBeat.o(127103);
            return true;
        } else if (str.equals("funtion_crowdtest_update")) {
            c.PK().bZ(262157, 266263);
            str = (String) g.RP().Ry().get(a.USERINFO_CROWDTEST_APPLY_LINK_STRING, null);
            intent = new Intent();
            intent.putExtra("rawUrl", str);
            intent.putExtra("showShare", false);
            intent.putExtra("show_bottom", false);
            com.tencent.mm.bp.d.b(this.mController.ylL, "webview", ".ui.tools.WebViewUI", intent);
            AppMethodBeat.o(127103);
            return true;
        } else {
            AppMethodBeat.o(127103);
            return false;
        }
    }

    static /* synthetic */ void b(SettingsAboutMicroMsgUI settingsAboutMicroMsgUI) {
        AppMethodBeat.i(127105);
        p Rg = g.Rg();
        f anonymousClass3 = new f() {
            public final void onSceneEnd(final int i, final int i2, String str, final m mVar) {
                AppMethodBeat.i(127093);
                ab.d("MicroMsg.SettingsAboutMicroMsgUI", "onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + mVar.getType());
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(127092);
                        g.Rg().b(255, SettingsAboutMicroMsgUI.this.qmb);
                        SettingsAboutMicroMsgUI.this.qmb = null;
                        if (SettingsAboutMicroMsgUI.this.qma != null) {
                            SettingsAboutMicroMsgUI.this.qma.stopTimer();
                            SettingsAboutMicroMsgUI.this.qma = null;
                        }
                        if (SettingsAboutMicroMsgUI.this.qlZ != null) {
                            SettingsAboutMicroMsgUI.this.qlZ.dismiss();
                        }
                        if (mVar.getType() == 255 && ((com.tencent.mm.modelsimple.r) mVar).fPr == 1) {
                            if (i2 == -3 && i == 4) {
                                Intent intent = new Intent(SettingsAboutMicroMsgUI.this.mController.ylL, RegByMobileSetPwdUI.class);
                                intent.putExtra("kintent_hint", SettingsAboutMicroMsgUI.this.getString(R.string.dlz));
                                SettingsAboutMicroMsgUI.this.startActivityForResult(intent, 0);
                                AppMethodBeat.o(127092);
                                return;
                            }
                            SettingsAboutMicroMsgUI.g(SettingsAboutMicroMsgUI.this);
                        }
                        AppMethodBeat.o(127092);
                    }
                });
                AppMethodBeat.o(127093);
            }
        };
        settingsAboutMicroMsgUI.qmb = anonymousClass3;
        Rg.a(255, anonymousClass3);
        final m rVar = new com.tencent.mm.modelsimple.r(2);
        rVar.fPr = 1;
        g.Rg().a(rVar, 0);
        settingsAboutMicroMsgUI.qma = new ap(Looper.getMainLooper(), new ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(127094);
                g.Rg().c(rVar);
                g.Rg().b(255, SettingsAboutMicroMsgUI.this.qmb);
                SettingsAboutMicroMsgUI.this.qmb = null;
                if (SettingsAboutMicroMsgUI.this.qma != null) {
                    SettingsAboutMicroMsgUI.this.qma.stopTimer();
                    SettingsAboutMicroMsgUI.this.qma = null;
                }
                if (SettingsAboutMicroMsgUI.this.qlZ != null) {
                    SettingsAboutMicroMsgUI.this.qlZ.cancel();
                }
                SettingsAboutMicroMsgUI.g(SettingsAboutMicroMsgUI.this);
                AppMethodBeat.o(127094);
                return false;
            }
        }, false);
        settingsAboutMicroMsgUI.qma.ae(3000, 3000);
        Context context = settingsAboutMicroMsgUI.mController.ylL;
        settingsAboutMicroMsgUI.getString(R.string.tz);
        settingsAboutMicroMsgUI.qlZ = com.tencent.mm.ui.base.h.b(context, settingsAboutMicroMsgUI.getString(R.string.g34), false, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(127095);
                g.Rg().c(rVar);
                g.Rg().b(255, SettingsAboutMicroMsgUI.this.qmb);
                SettingsAboutMicroMsgUI.this.qmb = null;
                if (SettingsAboutMicroMsgUI.this.qma != null) {
                    SettingsAboutMicroMsgUI.this.qma.stopTimer();
                    SettingsAboutMicroMsgUI.this.qma = null;
                }
                if (SettingsAboutMicroMsgUI.this.qlZ != null) {
                    SettingsAboutMicroMsgUI.this.qlZ.dismiss();
                }
                AppMethodBeat.o(127095);
            }
        });
        AppMethodBeat.o(127105);
    }

    static /* synthetic */ void g(SettingsAboutMicroMsgUI settingsAboutMicroMsgUI) {
        AppMethodBeat.i(127106);
        aj.amB("welcome_page_show");
        l.m(settingsAboutMicroMsgUI, true);
        com.tencent.mm.plugin.setting.b.gkF.BV();
        ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().IH();
        e.vdx.bd(settingsAboutMicroMsgUI.mController.ylL);
        settingsAboutMicroMsgUI.finish();
        AppMethodBeat.o(127106);
    }
}
