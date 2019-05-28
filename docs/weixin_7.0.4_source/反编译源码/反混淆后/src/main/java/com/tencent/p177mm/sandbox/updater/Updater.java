package com.tencent.p177mm.sandbox.updater;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C6668bk;
import com.tencent.p177mm.model.C6668bk.C1835a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelsimple.C37948o;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C6300p;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p201az.C32327m;
import com.tencent.p177mm.p209c.C41914i;
import com.tencent.p177mm.p209c.C41914i.C32431a;
import com.tencent.p177mm.p230g.p231a.C32523bi;
import com.tencent.p177mm.p612ui.base.C44275p;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.p1283p.C21426a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.app.C44057a;
import com.tencent.p177mm.pluginsdk.p1079f.C30035i;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.protocal.C4838o;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.ant;
import com.tencent.p177mm.protocal.protobuf.anu;
import com.tencent.p177mm.protocal.protobuf.aph;
import com.tencent.p177mm.protocal.protobuf.bdm;
import com.tencent.p177mm.protocal.protobuf.bhx;
import com.tencent.p177mm.protocal.protobuf.bia;
import com.tencent.p177mm.sandbox.monitor.C15412c;
import com.tencent.p177mm.sandbox.p758a.C7291a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.sandbox.updater.Updater */
public class Updater extends LinearLayout implements C1202f, C21426a {
    private boolean cui;
    private int xvw;
    private C44275p xwC = null;
    private boolean xwD = false;
    private boolean xwE = false;
    private boolean xwF = false;
    private C1202f xwG;
    private C1202f xwH;

    private Updater(Context context) {
        super(context);
    }

    public Updater(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void onStart() {
        AppMethodBeat.m2504i(28936);
        C9638aw.m17182Rg().mo14539a(11, (C1202f) this);
        C7060h.pYm.mo8378a(405, 42, 1, true);
        AppMethodBeat.m2505o(28936);
    }

    public final void onStop() {
        AppMethodBeat.m2504i(28937);
        C7060h.pYm.mo8378a(405, 43, 1, true);
        cancel();
        AppMethodBeat.m2505o(28937);
    }

    /* renamed from: e */
    public static Updater m79774e(Context context, final OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(28938);
        if (context == null) {
            AppMethodBeat.m2505o(28938);
            return null;
        } else if ((context instanceof Activity) && (((Activity) context).isFinishing() || ((Activity) context).getWindow() == null)) {
            C4990ab.m7412e("MicroMsg.Updater", "showWithProgress, context isFinishing");
            AppMethodBeat.m2505o(28938);
            return null;
        } else {
            C4996ah.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", C5046bo.anT()).commit();
            C9638aw.getNotification().cancel(34);
            C4990ab.m7416i("MicroMsg.Updater", "showWithProgress");
            Updater updater = (Updater) View.inflate(context, 2130970977, null);
            updater.onStart();
            C44275p d = C44275p.m79967d(context, context.getString(C25738R.string.eyv));
            d.setCancelable(true);
            d.setOnCancelListener(new OnCancelListener(updater) {
                final /* synthetic */ Updater xwI;

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(28931);
                    C9638aw.getNotification().cancel(99);
                    C7060h.pYm.mo8378a(405, 47, 1, true);
                    Updater.m79767LS(2);
                    this.xwI.onStop();
                    if (!(this.xwI.xwD || onCancelListener == null)) {
                        onCancelListener.onCancel(dialogInterface);
                    }
                    AppMethodBeat.m2505o(28931);
                }
            });
            try {
                updater.xwC = d;
                updater.xwC.show();
                updater.cui = true;
                C7060h.pYm.mo8378a(405, 46, 1, true);
                AppMethodBeat.m2505o(28938);
                return updater;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.Updater", "exception in showWithProgress, ", e.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.Updater", e, "", new Object[0]);
                AppMethodBeat.m2505o(28938);
                return null;
            }
        }
    }

    /* renamed from: f */
    public static Updater m79779f(Context context, final OnCancelListener onCancelListener) {
        AppMethodBeat.m2504i(28939);
        C4996ah.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", C5046bo.anT()).commit();
        C9638aw.getNotification().cancel(34);
        C4990ab.m7416i("MicroMsg.Updater", "show update dialog");
        Updater updater = (Updater) View.inflate(context, 2130970977, null);
        updater.onStart();
        C44275p d = C44275p.m79967d(context, "");
        d.setCancelable(true);
        d.setOnCancelListener(new OnCancelListener(updater) {
            final /* synthetic */ Updater xwI;

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(28932);
                C9638aw.getNotification().cancel(99);
                C7060h.pYm.mo8378a(405, 49, 1, true);
                Updater.m79767LS(2);
                this.xwI.onStop();
                if (!(this.xwI.xwD || onCancelListener == null)) {
                    onCancelListener.onCancel(dialogInterface);
                }
                AppMethodBeat.m2505o(28932);
            }
        });
        C7060h.pYm.mo8378a(405, 48, 1, true);
        updater.xwC = d;
        updater.cui = false;
        AppMethodBeat.m2505o(28939);
        return updater;
    }

    /* renamed from: gh */
    public static Updater m79781gh(Context context) {
        AppMethodBeat.m2504i(28940);
        C4996ah.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", C5046bo.anT()).commit();
        C9638aw.getNotification().cancel(34);
        C7060h.pYm.mo8378a(405, 50, 1, true);
        C4990ab.m7416i("MicroMsg.Updater", "updater silence");
        Updater updater = new Updater(context);
        updater.onStart();
        updater.xwE = true;
        AppMethodBeat.m2505o(28940);
        return updater;
    }

    /* renamed from: ez */
    public static void m79777ez(Context context) {
        AppMethodBeat.m2504i(28941);
        context.startActivity(new Intent(context, AppInstallerUI.class));
        AppMethodBeat.m2505o(28941);
    }

    public void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(28942);
        if (i == 0 && i2 == 0) {
            C7060h.pYm.mo8378a(405, 51, 1, true);
            C4990ab.m7416i("MicroMsg.Updater", "isShow " + this.cui);
            if (!(this.cui || this.xwC == null)) {
                this.xwC.show();
            }
            this.xwD = true;
            if (this.xwC != null) {
                this.xwC.cancel();
            }
            final C7291a c7291a = (C7291a) c1207m;
            C9638aw.m17182Rg().mo14541a(new C6668bk(new C1835a() {
                /* renamed from: a */
                public final void mo4918a(final C1902e c1902e) {
                    long j;
                    String dhU;
                    AppMethodBeat.m2504i(28934);
                    if (c1902e == null) {
                        C7060h.pYm.mo8378a(405, 52, 1, true);
                        Assert.assertTrue("updater invalid assert", false);
                    }
                    C9638aw.getNotification().cancel(34);
                    C4990ab.m7416i("MicroMsg.Updater", "go to update");
                    if (!C1448h.getExternalStorageState().equals("mounted")) {
                        C4990ab.m7412e("MicroMsg.Updater", "no sdcard.");
                        C7060h.pYm.mo8378a(405, 53, 1, true);
                        Updater.this.xwE = false;
                    }
                    int dmZ = c7291a.dmZ();
                    C41914i cO = C41914i.m74023cO(c7291a.dnb());
                    String fN = C30035i.m47538fN(Updater.this.getContext());
                    C32431a c32431a = null;
                    if (cO != null) {
                        c32431a = cO.mo67558cN(fN);
                    }
                    if (c32431a == null) {
                        j = (long) dmZ;
                    } else {
                        j = (long) (c32431a.size + dmZ);
                    }
                    if (!C1445f.m3072eW(j)) {
                        C4990ab.m7412e("MicroMsg.Updater", "no enough space.");
                        C7060h.pYm.mo8378a(405, 54, 1, true);
                        Updater.this.xwE = false;
                    }
                    if ((C5059g.cdh & 1) != 0) {
                        C4990ab.m7416i("MicroMsg.Updater", "channel pack, not silence download.");
                        C7060h.pYm.mo8378a(405, 55, 1, true);
                        Updater.this.xwE = false;
                    }
                    if (Updater.this.xvw == 2 && !Updater.this.xwF) {
                        dhU = C44212i.dhU();
                        if (!(C15412c.m23693RP(c7291a.dna()) == null || C5046bo.isNullOrNil(dhU) || !dhU.equals(c7291a.dna()))) {
                            C4990ab.m7417i("MicroMsg.Updater", "we already have this pack %s being to install, just ignore this update request", dhU);
                            C7060h.pYm.mo8378a(405, 56, 1, true);
                            AppMethodBeat.m2505o(28934);
                            return;
                        }
                    }
                    aph bQR = c7291a.bQR();
                    if (bQR == null || bQR.wtp == 0 || C5046bo.isNullOrNil(bQR.wtq)) {
                        if (Updater.this.xwE) {
                            C4990ab.m7416i("MicroMsg.Updater", "summerupdate gonna start UpdaterService checkcontrol");
                            C7060h.pYm.mo8378a(405, 58, 1, true);
                            C9638aw.m17182Rg().mo14539a(725, Updater.this.xwG = new C1202f() {
                                /* JADX WARNING: Removed duplicated region for block: B:14:0x0082  */
                                /* Code decompiled incorrectly, please refer to instructions dump. */
                                public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                                    AppMethodBeat.m2504i(28933);
                                    C9638aw.m17182Rg().mo14546b(221, Updater.this.xwG);
                                    Updater.this.xwG = null;
                                    if (i == 0 && i2 == 0) {
                                        long j;
                                        C37948o c37948o = (C37948o) c1207m;
                                        if (((ant) c37948o.fmP.fsG.fsP).jCt == 0) {
                                            String str2 = ((anu) c37948o.fmP.fsH.fsP).ncM;
                                            if (!C5046bo.isNullOrNil(str2)) {
                                                Map z = C5049br.m7595z(str2, "resourcecontrolinfo");
                                                if (z != null) {
                                                    str2 = (String) z.get(".resourcecontrolinfo.enableupdate");
                                                    String str3 = (String) z.get(".resourcecontrolinfo.expiredtime");
                                                    C4990ab.m7417i("MicroMsg.NetSceneGetResourceControlInfo", "summerupdate getDisableUpdateTime values[%s]", z);
                                                    if (C5046bo.getInt(str2, 1) == 0) {
                                                        j = C5046bo.getLong(str3, 0);
                                                        if (j > System.currentTimeMillis() / 1000) {
                                                            C4990ab.m7417i("MicroMsg.Updater", "summerupdate checkcontrol time[%d] > now[%d] control not auto download and ret", Long.valueOf(j), Long.valueOf(System.currentTimeMillis() / 1000));
                                                            C7060h.pYm.mo8378a(405, 0, 1, true);
                                                            AppMethodBeat.m2505o(28933);
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
                                    C4990ab.m7416i("MicroMsg.Updater", "summerupdate gonna start UpdaterService after checkcontrol");
                                    C7060h.pYm.mo8378a(405, 59, 1, true);
                                    Intent intent = new Intent(Updater.this.getContext(), UpdaterService.class);
                                    Updater.m79769a(Updater.this, intent, c1902e, c7291a);
                                    intent.putExtra("intent_extra_run_in_foreground", true);
                                    intent.putExtra("intent_extra_download_mode", 2);
                                    C25985d.m41477j(intent, "sandbox");
                                    AppMethodBeat.m2505o(28933);
                                }
                            });
                            C9638aw.m17182Rg().mo14541a(new C37948o(), 0);
                        } else {
                            C4990ab.m7416i("MicroMsg.Updater", "gonna start AppUpdaterUI");
                            Intent intent = new Intent(Updater.this.getContext(), AppUpdaterUI.class);
                            Updater.m79769a(Updater.this, intent, c1902e, c7291a);
                            C4990ab.m7417i("MicroMsg.Updater", "current updateType : %s", Integer.valueOf(Updater.this.xvw));
                            if (Updater.this.xvw == 1) {
                                intent.putExtra("intent_extra_download_mode", 0);
                                C7060h.pYm.mo8378a(405, 60, 1, true);
                            } else {
                                C7060h.pYm.mo8378a(405, 61, 1, true);
                                intent.putExtra("intent_extra_download_mode", 1);
                            }
                            Updater.this.getContext().startActivity(intent);
                        }
                        C16112c.m24429PK().mo28556x(262145, true);
                        C44057a.dht();
                        AppMethodBeat.m2505o(28934);
                        return;
                    }
                    dhU = bQR.wtq;
                    Intent intent2 = new Intent();
                    intent2.putExtra("rawUrl", dhU);
                    intent2.putExtra("showShare", false);
                    intent2.putExtra("show_bottom", false);
                    C25985d.m41467b(Updater.this.getContext(), "webview", ".ui.tools.WebViewUI", intent2);
                    C44212i.dnw();
                    C7060h.pYm.mo8378a(405, 57, 1, true);
                    AppMethodBeat.m2505o(28934);
                }
            }), 0);
            onStop();
            AppMethodBeat.m2505o(28942);
            return;
        }
        C7060h.pYm.mo8378a(405, 62, 1, true);
        if (this.xwC != null) {
            C44275p c44275p = this.xwC;
            if (c44275p.iUz != null) {
                c44275p.iUz.setVisibility(8);
            }
            final TextView textView = (TextView) this.xwC.findViewById(2131821803);
            if (i == 4 && i2 == -18) {
                C4879a.xxA.mo10055m(new C32523bi());
                C6300p Rg = C9638aw.m17182Rg();
                C1202f c442104 = new C1202f() {
                    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                        AppMethodBeat.m2504i(28935);
                        C9638aw.m17182Rg().mo14546b(3899, Updater.this.xwH);
                        Updater.this.xwG = null;
                        if (i == 0 && i2 == 0) {
                            bia bia = ((bhx) ((C7472b) c1207m.ftl).fsH.fsP).wLf;
                            C23487e c23487e = new C23487e(bia);
                            if (bia == null || bia.wLk != 3) {
                                if (Updater.this.xwC.findViewById(2131821802) != null) {
                                    Updater.this.xwC.findViewById(2131821802).setVisibility(8);
                                }
                                if (textView != null) {
                                    C7060h.pYm.mo8378a(405, 63, 1, true);
                                    textView.setText(C25738R.string.ez0);
                                }
                                AppMethodBeat.m2505o(28935);
                                return;
                            }
                            Intent intent = new Intent(Updater.this.getContext(), AppUpdaterUI.class);
                            if (C23487e.m36316OH(c23487e.clientVersion)) {
                                String str2 = C5046bo.isNullOrNil(c23487e.nur) ? "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index" : c23487e.nur;
                                Intent intent2 = new Intent("android.intent.action.VIEW");
                                intent2.setClassName(Updater.this.getContext().getPackageName(), Updater.this.getContext().getPackageName() + ".plugin.webview.ui.tools.WebViewUI");
                                intent2.putExtra("rawUrl", str2);
                                intent2.putExtra("useJs", true);
                                intent2.putExtra("vertical_scroll", true);
                                intent2.setFlags(872415232);
                                Updater.this.getContext().startActivity(intent2);
                            } else {
                                Updater.this.mo69846a(intent, c23487e);
                                Updater.this.getContext().startActivity(intent);
                            }
                            if (Updater.this.xwC != null) {
                                Updater.this.xwC.cancel();
                            }
                            Updater.this.onStop();
                            AppMethodBeat.m2505o(28935);
                            return;
                        }
                        if (Updater.this.xwC.findViewById(2131821802) != null) {
                            Updater.this.xwC.findViewById(2131821802).setVisibility(8);
                        }
                        if (textView != null) {
                            C7060h.pYm.mo8378a(405, 63, 1, true);
                            textView.setText(C25738R.string.ez0);
                        }
                        AppMethodBeat.m2505o(28935);
                    }
                };
                this.xwH = c442104;
                Rg.mo14539a(3899, c442104);
            } else if (textView != null) {
                C7060h.pYm.mo8378a(405, 64, 1, true);
                textView.setText(C25738R.string.eyq);
                C44089j.m79307h(textView, 1);
            }
        }
        C44212i.dnA();
        cancel();
        AppMethodBeat.m2505o(28942);
    }

    /* renamed from: a */
    public final void mo69846a(Intent intent, C23487e c23487e) {
        int i;
        String str;
        AppMethodBeat.m2504i(28943);
        intent.putExtra("intent_short_ips", getShortIps());
        intent.putExtra("intent_client_version", C7243d.vxo);
        intent.putExtra("intent_update_type", 3);
        String str2 = "intent_extra_desc";
        if (c23487e.nuh == null || c23487e.nuh.isEmpty() || !c23487e.nuh.containsKey(Integer.valueOf(4))) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            HashMap hashMap = c23487e.nuh;
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
                        } else if (bdm.lang.equalsIgnoreCase(C4988aa.dor())) {
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
        intent.putExtra("intent_extra_md5", c23487e.nul);
        intent.putExtra("intent_extra_size", c23487e.fileSize);
        intent.putExtra("intent_extra_download_url", new String[]{c23487e.nuk});
        intent.putExtra("intent_extra_patchInfo", c23487e.dnp());
        intent.putExtra("intent_extra_updateMode", C5059g.cdh);
        intent.putExtra("intent_extra_marketUrl", C5059g.xyc);
        intent.putExtra("intent_extra_extinfo", "<extinfo></extinfo>");
        intent.putExtra("intent_extra_tinker_patch", true);
        intent.putExtra("intent_extra_download_mode", 1);
        AppMethodBeat.m2505o(28943);
    }

    private void cancel() {
        AppMethodBeat.m2504i(28944);
        C9638aw.m17182Rg().mo14546b(11, (C1202f) this);
        AppMethodBeat.m2505o(28944);
    }

    private String[] getShortIps() {
        int i = 0;
        AppMethodBeat.m2504i(28945);
        if (C1947ae.gii == null || C1947ae.gii.length() <= 0) {
            String string = C4996ah.getContext().getSharedPreferences("system_config_prefs", 0).getString("builtin_short_ips", "");
            if (string == null || string.length() <= 0) {
                string = "0,112.64.200.240,80|0,180.153.82.27,80|0,117.135.130.177,80";
            }
            List akF = C4838o.akF(string);
            String[] strArr = new String[akF.size()];
            while (i < akF.size()) {
                strArr[i] = ((C4838o) akF.get(i)).nJq;
                i++;
            }
            AppMethodBeat.m2505o(28945);
            return strArr;
        }
        String[] strArr2 = new String[]{C1947ae.gii};
        AppMethodBeat.m2505o(28945);
        return strArr2;
    }

    public final void update(int i) {
        AppMethodBeat.m2504i(28946);
        mo69847aA(i, false);
        AppMethodBeat.m2505o(28946);
    }

    /* renamed from: aA */
    public final void mo69847aA(int i, boolean z) {
        AppMethodBeat.m2504i(28947);
        C4990ab.m7416i("MicroMsg.Updater", "summerupdate begin update routine, type=".concat(String.valueOf(i)));
        this.xvw = i;
        this.xwF = z;
        C7060h.pYm.mo8378a(405, 44, 1, true);
        C9638aw.m17182Rg().mo14541a(new C7291a(i), 0);
        AppMethodBeat.m2505o(28947);
    }

    /* renamed from: e */
    public static void m79775e(String str, int i, String str2, String str3) {
        AppMethodBeat.m2504i(28948);
        Intent intent = new Intent(C4996ah.getContext(), UpdaterService.class);
        intent.putExtra("intent_client_version", C7243d.vxo);
        intent.putExtra("intent_update_type", 4);
        intent.putExtra("intent_extra_desc", str2);
        intent.putExtra("intent_extra_md5", str);
        intent.putExtra("intent_extra_size", i);
        intent.putExtra("intent_extra_download_url", new String[]{str3});
        intent.putExtra("intent_extra_updateMode", C5059g.cdh);
        intent.putExtra("intent_extra_marketUrl", C5059g.xyc);
        intent.putExtra("intent_extra_run_in_foreground", true);
        intent.putExtra("intent_extra_download_mode", 2);
        C7060h.pYm.mo8378a(405, 45, 1, true);
        C25985d.m41477j(intent, "sandbox");
        AppMethodBeat.m2505o(28948);
    }

    /* renamed from: LS */
    public static void m79767LS(int i) {
        AppMethodBeat.m2504i(28949);
        if (C9638aw.m17179RK()) {
            C4990ab.m7410d("MicroMsg.Updater", "reportUpdateStat : opCode = ".concat(String.valueOf(i)));
            C9638aw.m17190ZK();
            C18628c.m29077XL().mo7920c(new C32327m(i));
            AppMethodBeat.m2505o(28949);
            return;
        }
        AppMethodBeat.m2505o(28949);
    }

    /* renamed from: a */
    static /* synthetic */ void m79769a(Updater updater, Intent intent, C1902e c1902e, C7291a c7291a) {
        AppMethodBeat.m2504i(28950);
        intent.putExtra("intent_short_ips", updater.getShortIps());
        intent.putExtra("intent_client_version", C7243d.vxo);
        intent.putExtra("intent_extra_session", c1902e.adg().mo5490jQ(1));
        intent.putExtra("intent_extra_cookie", c1902e.adg().ada());
        intent.putExtra("intent_extra_ecdhkey", c1902e.adg().adc());
        intent.putExtra("intent_extra_uin", c1902e.adg().mo5480QF());
        intent.putExtra("intent_update_type", updater.xvw);
        intent.putExtra("intent_extra_desc", ((aph) c7291a.ehh.fsH.fsP).wtl);
        intent.putExtra("intent_extra_md5", c7291a.dna());
        intent.putExtra("intent_extra_size", c7291a.dmZ());
        intent.putExtra("intent_extra_download_url", c7291a.bQQ());
        intent.putExtra("intent_extra_patchInfo", c7291a.dnb());
        intent.putExtra("intent_extra_updateMode", C5059g.cdh);
        intent.putExtra("intent_extra_marketUrl", C5059g.xyc);
        C4990ab.m7411d("MicroMsg.NetSceneGetUpdateInfo", "summerupdate extInfo[%s], stack[%s]", C5046bo.nullAsNil(C1946aa.m4153b(((aph) c7291a.ehh.fsH.fsP).wts)), C5046bo.dpG());
        intent.putExtra("intent_extra_extinfo", r0);
        AppMethodBeat.m2505o(28950);
    }
}
