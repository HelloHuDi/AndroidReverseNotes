package com.tencent.mm.sandbox.updater;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.c.i;
import com.tencent.mm.g.a.bi;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bk;
import com.tencent.mm.modelsimple.o;
import com.tencent.mm.network.e;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.p.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.protocal.protobuf.ant;
import com.tencent.mm.protocal.protobuf.anu;
import com.tencent.mm.protocal.protobuf.aph;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bhx;
import com.tencent.mm.protocal.protobuf.bia;
import com.tencent.mm.sandbox.monitor.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.mm.ui.base.p;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class Updater extends LinearLayout implements f, a {
    private boolean cui;
    private int xvw;
    private p xwC = null;
    private boolean xwD = false;
    private boolean xwE = false;
    private boolean xwF = false;
    private f xwG;
    private f xwH;

    private Updater(Context context) {
        super(context);
    }

    public Updater(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void onStart() {
        AppMethodBeat.i(28936);
        aw.Rg().a(11, (f) this);
        h.pYm.a(405, 42, 1, true);
        AppMethodBeat.o(28936);
    }

    public final void onStop() {
        AppMethodBeat.i(28937);
        h.pYm.a(405, 43, 1, true);
        cancel();
        AppMethodBeat.o(28937);
    }

    public static Updater e(Context context, final OnCancelListener onCancelListener) {
        AppMethodBeat.i(28938);
        if (context == null) {
            AppMethodBeat.o(28938);
            return null;
        } else if ((context instanceof Activity) && (((Activity) context).isFinishing() || ((Activity) context).getWindow() == null)) {
            ab.e("MicroMsg.Updater", "showWithProgress, context isFinishing");
            AppMethodBeat.o(28938);
            return null;
        } else {
            ah.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bo.anT()).commit();
            aw.getNotification().cancel(34);
            ab.i("MicroMsg.Updater", "showWithProgress");
            Updater updater = (Updater) View.inflate(context, R.layout.b11, null);
            updater.onStart();
            p d = p.d(context, context.getString(R.string.eyv));
            d.setCancelable(true);
            d.setOnCancelListener(new OnCancelListener(updater) {
                final /* synthetic */ Updater xwI;

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(28931);
                    aw.getNotification().cancel(99);
                    h.pYm.a(405, 47, 1, true);
                    Updater.LS(2);
                    this.xwI.onStop();
                    if (!(this.xwI.xwD || onCancelListener == null)) {
                        onCancelListener.onCancel(dialogInterface);
                    }
                    AppMethodBeat.o(28931);
                }
            });
            try {
                updater.xwC = d;
                updater.xwC.show();
                updater.cui = true;
                h.pYm.a(405, 46, 1, true);
                AppMethodBeat.o(28938);
                return updater;
            } catch (Exception e) {
                ab.e("MicroMsg.Updater", "exception in showWithProgress, ", e.getMessage());
                ab.printErrStackTrace("MicroMsg.Updater", e, "", new Object[0]);
                AppMethodBeat.o(28938);
                return null;
            }
        }
    }

    public static Updater f(Context context, final OnCancelListener onCancelListener) {
        AppMethodBeat.i(28939);
        ah.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bo.anT()).commit();
        aw.getNotification().cancel(34);
        ab.i("MicroMsg.Updater", "show update dialog");
        Updater updater = (Updater) View.inflate(context, R.layout.b11, null);
        updater.onStart();
        p d = p.d(context, "");
        d.setCancelable(true);
        d.setOnCancelListener(new OnCancelListener(updater) {
            final /* synthetic */ Updater xwI;

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(28932);
                aw.getNotification().cancel(99);
                h.pYm.a(405, 49, 1, true);
                Updater.LS(2);
                this.xwI.onStop();
                if (!(this.xwI.xwD || onCancelListener == null)) {
                    onCancelListener.onCancel(dialogInterface);
                }
                AppMethodBeat.o(28932);
            }
        });
        h.pYm.a(405, 48, 1, true);
        updater.xwC = d;
        updater.cui = false;
        AppMethodBeat.o(28939);
        return updater;
    }

    public static Updater gh(Context context) {
        AppMethodBeat.i(28940);
        ah.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", bo.anT()).commit();
        aw.getNotification().cancel(34);
        h.pYm.a(405, 50, 1, true);
        ab.i("MicroMsg.Updater", "updater silence");
        Updater updater = new Updater(context);
        updater.onStart();
        updater.xwE = true;
        AppMethodBeat.o(28940);
        return updater;
    }

    public static void ez(Context context) {
        AppMethodBeat.i(28941);
        context.startActivity(new Intent(context, AppInstallerUI.class));
        AppMethodBeat.o(28941);
    }

    public void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(28942);
        if (i == 0 && i2 == 0) {
            h.pYm.a(405, 51, 1, true);
            ab.i("MicroMsg.Updater", "isShow " + this.cui);
            if (!(this.cui || this.xwC == null)) {
                this.xwC.show();
            }
            this.xwD = true;
            if (this.xwC != null) {
                this.xwC.cancel();
            }
            final com.tencent.mm.sandbox.a.a aVar = (com.tencent.mm.sandbox.a.a) mVar;
            aw.Rg().a(new bk(new bk.a() {
                public final void a(final e eVar) {
                    long j;
                    String dhU;
                    AppMethodBeat.i(28934);
                    if (eVar == null) {
                        h.pYm.a(405, 52, 1, true);
                        Assert.assertTrue("updater invalid assert", false);
                    }
                    aw.getNotification().cancel(34);
                    ab.i("MicroMsg.Updater", "go to update");
                    if (!com.tencent.mm.compatible.util.h.getExternalStorageState().equals("mounted")) {
                        ab.e("MicroMsg.Updater", "no sdcard.");
                        h.pYm.a(405, 53, 1, true);
                        Updater.this.xwE = false;
                    }
                    int dmZ = aVar.dmZ();
                    i cO = i.cO(aVar.dnb());
                    String fN = com.tencent.mm.pluginsdk.f.i.fN(Updater.this.getContext());
                    i.a aVar = null;
                    if (cO != null) {
                        aVar = cO.cN(fN);
                    }
                    if (aVar == null) {
                        j = (long) dmZ;
                    } else {
                        j = (long) (aVar.size + dmZ);
                    }
                    if (!com.tencent.mm.compatible.util.f.eW(j)) {
                        ab.e("MicroMsg.Updater", "no enough space.");
                        h.pYm.a(405, 54, 1, true);
                        Updater.this.xwE = false;
                    }
                    if ((g.cdh & 1) != 0) {
                        ab.i("MicroMsg.Updater", "channel pack, not silence download.");
                        h.pYm.a(405, 55, 1, true);
                        Updater.this.xwE = false;
                    }
                    if (Updater.this.xvw == 2 && !Updater.this.xwF) {
                        dhU = i.dhU();
                        if (!(c.RP(aVar.dna()) == null || bo.isNullOrNil(dhU) || !dhU.equals(aVar.dna()))) {
                            ab.i("MicroMsg.Updater", "we already have this pack %s being to install, just ignore this update request", dhU);
                            h.pYm.a(405, 56, 1, true);
                            AppMethodBeat.o(28934);
                            return;
                        }
                    }
                    aph bQR = aVar.bQR();
                    if (bQR == null || bQR.wtp == 0 || bo.isNullOrNil(bQR.wtq)) {
                        if (Updater.this.xwE) {
                            ab.i("MicroMsg.Updater", "summerupdate gonna start UpdaterService checkcontrol");
                            h.pYm.a(405, 58, 1, true);
                            aw.Rg().a(725, Updater.this.xwG = new f() {
                                /* JADX WARNING: Removed duplicated region for block: B:14:0x0082  */
                                /* Code decompiled incorrectly, please refer to instructions dump. */
                                public final void onSceneEnd(int i, int i2, String str, m mVar) {
                                    AppMethodBeat.i(28933);
                                    aw.Rg().b(221, Updater.this.xwG);
                                    Updater.this.xwG = null;
                                    if (i == 0 && i2 == 0) {
                                        long j;
                                        o oVar = (o) mVar;
                                        if (((ant) oVar.fmP.fsG.fsP).jCt == 0) {
                                            String str2 = ((anu) oVar.fmP.fsH.fsP).ncM;
                                            if (!bo.isNullOrNil(str2)) {
                                                Map z = br.z(str2, "resourcecontrolinfo");
                                                if (z != null) {
                                                    str2 = (String) z.get(".resourcecontrolinfo.enableupdate");
                                                    String str3 = (String) z.get(".resourcecontrolinfo.expiredtime");
                                                    ab.i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate getDisableUpdateTime values[%s]", z);
                                                    if (bo.getInt(str2, 1) == 0) {
                                                        j = bo.getLong(str3, 0);
                                                        if (j > System.currentTimeMillis() / 1000) {
                                                            ab.i("MicroMsg.Updater", "summerupdate checkcontrol time[%d] > now[%d] control not auto download and ret", Long.valueOf(j), Long.valueOf(System.currentTimeMillis() / 1000));
                                                            h.pYm.a(405, 0, 1, true);
                                                            AppMethodBeat.o(28933);
                                                            return;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        j = 0;
                                        if (j > System.currentTimeMillis() / 1000) {
                                        }
                                    }
                                    ab.i("MicroMsg.Updater", "summerupdate gonna start UpdaterService after checkcontrol");
                                    h.pYm.a(405, 59, 1, true);
                                    Intent intent = new Intent(Updater.this.getContext(), UpdaterService.class);
                                    Updater.a(Updater.this, intent, eVar, aVar);
                                    intent.putExtra("intent_extra_run_in_foreground", true);
                                    intent.putExtra("intent_extra_download_mode", 2);
                                    d.j(intent, "sandbox");
                                    AppMethodBeat.o(28933);
                                }
                            });
                            aw.Rg().a(new o(), 0);
                        } else {
                            ab.i("MicroMsg.Updater", "gonna start AppUpdaterUI");
                            Intent intent = new Intent(Updater.this.getContext(), AppUpdaterUI.class);
                            Updater.a(Updater.this, intent, eVar, aVar);
                            ab.i("MicroMsg.Updater", "current updateType : %s", Integer.valueOf(Updater.this.xvw));
                            if (Updater.this.xvw == 1) {
                                intent.putExtra("intent_extra_download_mode", 0);
                                h.pYm.a(405, 60, 1, true);
                            } else {
                                h.pYm.a(405, 61, 1, true);
                                intent.putExtra("intent_extra_download_mode", 1);
                            }
                            Updater.this.getContext().startActivity(intent);
                        }
                        com.tencent.mm.x.c.PK().x(262145, true);
                        com.tencent.mm.pluginsdk.model.app.a.dht();
                        AppMethodBeat.o(28934);
                        return;
                    }
                    dhU = bQR.wtq;
                    Intent intent2 = new Intent();
                    intent2.putExtra("rawUrl", dhU);
                    intent2.putExtra("showShare", false);
                    intent2.putExtra("show_bottom", false);
                    d.b(Updater.this.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                    i.dnw();
                    h.pYm.a(405, 57, 1, true);
                    AppMethodBeat.o(28934);
                }
            }), 0);
            onStop();
            AppMethodBeat.o(28942);
            return;
        }
        h.pYm.a(405, 62, 1, true);
        if (this.xwC != null) {
            p pVar = this.xwC;
            if (pVar.iUz != null) {
                pVar.iUz.setVisibility(8);
            }
            final TextView textView = (TextView) this.xwC.findViewById(R.id.a70);
            if (i == 4 && i2 == -18) {
                com.tencent.mm.sdk.b.a.xxA.m(new bi());
                com.tencent.mm.ai.p Rg = aw.Rg();
                f anonymousClass4 = new f() {
                    public final void onSceneEnd(int i, int i2, String str, m mVar) {
                        AppMethodBeat.i(28935);
                        aw.Rg().b(3899, Updater.this.xwH);
                        Updater.this.xwG = null;
                        if (i == 0 && i2 == 0) {
                            bia bia = ((bhx) ((b) mVar.ftl).fsH.fsP).wLf;
                            e eVar = new e(bia);
                            if (bia == null || bia.wLk != 3) {
                                if (Updater.this.xwC.findViewById(R.id.a6z) != null) {
                                    Updater.this.xwC.findViewById(R.id.a6z).setVisibility(8);
                                }
                                if (textView != null) {
                                    h.pYm.a(405, 63, 1, true);
                                    textView.setText(R.string.ez0);
                                }
                                AppMethodBeat.o(28935);
                                return;
                            }
                            Intent intent = new Intent(Updater.this.getContext(), AppUpdaterUI.class);
                            if (e.OH(eVar.clientVersion)) {
                                String str2 = bo.isNullOrNil(eVar.nur) ? "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index" : eVar.nur;
                                Intent intent2 = new Intent("android.intent.action.VIEW");
                                intent2.setClassName(Updater.this.getContext().getPackageName(), Updater.this.getContext().getPackageName() + ".plugin.webview.ui.tools.WebViewUI");
                                intent2.putExtra("rawUrl", str2);
                                intent2.putExtra("useJs", true);
                                intent2.putExtra("vertical_scroll", true);
                                intent2.setFlags(872415232);
                                Updater.this.getContext().startActivity(intent2);
                            } else {
                                Updater.this.a(intent, eVar);
                                Updater.this.getContext().startActivity(intent);
                            }
                            if (Updater.this.xwC != null) {
                                Updater.this.xwC.cancel();
                            }
                            Updater.this.onStop();
                            AppMethodBeat.o(28935);
                            return;
                        }
                        if (Updater.this.xwC.findViewById(R.id.a6z) != null) {
                            Updater.this.xwC.findViewById(R.id.a6z).setVisibility(8);
                        }
                        if (textView != null) {
                            h.pYm.a(405, 63, 1, true);
                            textView.setText(R.string.ez0);
                        }
                        AppMethodBeat.o(28935);
                    }
                };
                this.xwH = anonymousClass4;
                Rg.a(3899, anonymousClass4);
            } else if (textView != null) {
                h.pYm.a(405, 64, 1, true);
                textView.setText(R.string.eyq);
                j.h(textView, 1);
            }
        }
        i.dnA();
        cancel();
        AppMethodBeat.o(28942);
    }

    public final void a(Intent intent, e eVar) {
        int i;
        String str;
        AppMethodBeat.i(28943);
        intent.putExtra("intent_short_ips", getShortIps());
        intent.putExtra("intent_client_version", com.tencent.mm.protocal.d.vxo);
        intent.putExtra("intent_update_type", 3);
        String str2 = "intent_extra_desc";
        if (eVar.nuh == null || eVar.nuh.isEmpty() || !eVar.nuh.containsKey(Integer.valueOf(4))) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            HashMap hashMap = eVar.nuh;
            if (hashMap == null || hashMap.isEmpty()) {
                str = "";
            } else {
                str = "";
                LinkedList linkedList = (LinkedList) hashMap.get(Integer.valueOf(4));
                if (linkedList != null && !linkedList.isEmpty()) {
                    int size = linkedList.size();
                    int i2 = 0;
                    while (i2 < size) {
                        String str3;
                        bdm bdm = (bdm) linkedList.get(i2);
                        if (bdm.lang.equalsIgnoreCase("default")) {
                            str3 = new String(Base64.decode(bdm.content, 0));
                        } else if (bdm.lang.equalsIgnoreCase(aa.dor())) {
                            str = new String(Base64.decode(bdm.content, 0));
                            break;
                        } else {
                            str3 = str;
                        }
                        i2++;
                        str = str3;
                    }
                }
            }
        } else {
            str = "";
        }
        intent.putExtra(str2, str);
        intent.putExtra("intent_extra_md5", eVar.nul);
        intent.putExtra("intent_extra_size", eVar.fileSize);
        intent.putExtra("intent_extra_download_url", new String[]{eVar.nuk});
        intent.putExtra("intent_extra_patchInfo", eVar.dnp());
        intent.putExtra("intent_extra_updateMode", g.cdh);
        intent.putExtra("intent_extra_marketUrl", g.xyc);
        intent.putExtra("intent_extra_extinfo", "<extinfo></extinfo>");
        intent.putExtra("intent_extra_tinker_patch", true);
        intent.putExtra("intent_extra_download_mode", 1);
        AppMethodBeat.o(28943);
    }

    private void cancel() {
        AppMethodBeat.i(28944);
        aw.Rg().b(11, (f) this);
        AppMethodBeat.o(28944);
    }

    private String[] getShortIps() {
        int i = 0;
        AppMethodBeat.i(28945);
        if (ae.gii == null || ae.gii.length() <= 0) {
            String string = ah.getContext().getSharedPreferences("system_config_prefs", 0).getString("builtin_short_ips", "");
            if (string == null || string.length() <= 0) {
                string = "0,112.64.200.240,80|0,180.153.82.27,80|0,117.135.130.177,80";
            }
            List akF = com.tencent.mm.protocal.o.akF(string);
            String[] strArr = new String[akF.size()];
            while (i < akF.size()) {
                strArr[i] = ((com.tencent.mm.protocal.o) akF.get(i)).nJq;
                i++;
            }
            AppMethodBeat.o(28945);
            return strArr;
        }
        String[] strArr2 = new String[]{ae.gii};
        AppMethodBeat.o(28945);
        return strArr2;
    }

    public final void update(int i) {
        AppMethodBeat.i(28946);
        aA(i, false);
        AppMethodBeat.o(28946);
    }

    public final void aA(int i, boolean z) {
        AppMethodBeat.i(28947);
        ab.i("MicroMsg.Updater", "summerupdate begin update routine, type=".concat(String.valueOf(i)));
        this.xvw = i;
        this.xwF = z;
        h.pYm.a(405, 44, 1, true);
        aw.Rg().a(new com.tencent.mm.sandbox.a.a(i), 0);
        AppMethodBeat.o(28947);
    }

    public static void e(String str, int i, String str2, String str3) {
        AppMethodBeat.i(28948);
        Intent intent = new Intent(ah.getContext(), UpdaterService.class);
        intent.putExtra("intent_client_version", com.tencent.mm.protocal.d.vxo);
        intent.putExtra("intent_update_type", 4);
        intent.putExtra("intent_extra_desc", str2);
        intent.putExtra("intent_extra_md5", str);
        intent.putExtra("intent_extra_size", i);
        intent.putExtra("intent_extra_download_url", new String[]{str3});
        intent.putExtra("intent_extra_updateMode", g.cdh);
        intent.putExtra("intent_extra_marketUrl", g.xyc);
        intent.putExtra("intent_extra_run_in_foreground", true);
        intent.putExtra("intent_extra_download_mode", 2);
        h.pYm.a(405, 45, 1, true);
        d.j(intent, "sandbox");
        AppMethodBeat.o(28948);
    }

    public static void LS(int i) {
        AppMethodBeat.i(28949);
        if (aw.RK()) {
            ab.d("MicroMsg.Updater", "reportUpdateStat : opCode = ".concat(String.valueOf(i)));
            aw.ZK();
            com.tencent.mm.model.c.XL().c(new com.tencent.mm.az.m(i));
            AppMethodBeat.o(28949);
            return;
        }
        AppMethodBeat.o(28949);
    }

    static /* synthetic */ void a(Updater updater, Intent intent, e eVar, com.tencent.mm.sandbox.a.a aVar) {
        AppMethodBeat.i(28950);
        intent.putExtra("intent_short_ips", updater.getShortIps());
        intent.putExtra("intent_client_version", com.tencent.mm.protocal.d.vxo);
        intent.putExtra("intent_extra_session", eVar.adg().jQ(1));
        intent.putExtra("intent_extra_cookie", eVar.adg().ada());
        intent.putExtra("intent_extra_ecdhkey", eVar.adg().adc());
        intent.putExtra("intent_extra_uin", eVar.adg().QF());
        intent.putExtra("intent_update_type", updater.xvw);
        intent.putExtra("intent_extra_desc", ((aph) aVar.ehh.fsH.fsP).wtl);
        intent.putExtra("intent_extra_md5", aVar.dna());
        intent.putExtra("intent_extra_size", aVar.dmZ());
        intent.putExtra("intent_extra_download_url", aVar.bQQ());
        intent.putExtra("intent_extra_patchInfo", aVar.dnb());
        intent.putExtra("intent_extra_updateMode", g.cdh);
        intent.putExtra("intent_extra_marketUrl", g.xyc);
        ab.d("MicroMsg.NetSceneGetUpdateInfo", "summerupdate extInfo[%s], stack[%s]", bo.nullAsNil(com.tencent.mm.platformtools.aa.b(((aph) aVar.ehh.fsH.fsP).wts)), bo.dpG());
        intent.putExtra("intent_extra_extinfo", r0);
        AppMethodBeat.o(28950);
    }
}
