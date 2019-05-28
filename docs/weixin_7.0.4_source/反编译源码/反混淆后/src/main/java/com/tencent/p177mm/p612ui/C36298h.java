package com.tencent.p177mm.p612ui;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.p057v4.app.C0363v.C0358c;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelsimple.BindWordingContent;
import com.tencent.p177mm.modelsimple.C9703aa;
import com.tencent.p177mm.modelsimple.C9706r;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p1179au.C17950b.C17951a;
import com.tencent.p177mm.p1510r.C35973a;
import com.tencent.p177mm.p1573q.C40600a;
import com.tencent.p177mm.p1637bo.C45186a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p203bg.C17981e;
import com.tencent.p177mm.p230g.p231a.C18295ij;
import com.tencent.p177mm.p230g.p231a.C18295ij.C18294a;
import com.tencent.p177mm.p230g.p231a.C37693be;
import com.tencent.p177mm.p612ui.C30777u.C30784a;
import com.tencent.p177mm.p612ui.LauncherUI.C36032b;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.account.bind.p271ui.BindMContactUI;
import com.tencent.p177mm.plugin.account.bind.p271ui.BindMobileUI;
import com.tencent.p177mm.plugin.account.p275ui.RegByMobileSetPwdUI;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.GeneralControlWrapper;
import com.tencent.p177mm.protocal.JsapiPermissionWrapper;
import com.tencent.p177mm.protocal.p1338b.p1339a.C23368a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.ui.h */
public final class C36298h {
    int cur = 0;
    ProgressDialog ehJ;
    C5653c gup;
    EditText qmA;
    boolean qmB;
    private View qmy;
    private TextView qmz;
    MMFragmentActivity yhZ;
    C36032b yia;
    C18294a yib = null;
    C1202f yic;
    boolean yid = false;
    boolean yie = false;
    C4884c yif = new C307161();
    C4884c<C37693be> yig = new C240132();

    /* renamed from: com.tencent.mm.ui.h$13 */
    class C1589713 implements OnClickListener {
        C1589713() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(29326);
            C36298h.this.qmA.setText("");
            C36298h.this.gup.dismiss();
            AppMethodBeat.m2505o(29326);
        }
    }

    /* renamed from: com.tencent.mm.ui.h$2 */
    class C240132 extends C4884c<C37693be> {
        C240132() {
            AppMethodBeat.m2504i(29308);
            this.xxI = C37693be.class.getName().hashCode();
            AppMethodBeat.m2505o(29308);
        }

        /* renamed from: a */
        public final /* bridge */ /* synthetic */ boolean mo4653a(C4883b c4883b) {
            C37693be c37693be = (C37693be) c4883b;
            C36298h.this.cur = c37693be.cuq.cur;
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.h$11 */
    class C3071311 implements C1202f {

        /* renamed from: com.tencent.mm.ui.h$11$1 */
        class C240121 implements OnClickListener {
            C240121() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(29322);
                C36298h.this.dxg();
                AppMethodBeat.m2505o(29322);
            }
        }

        C3071311() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(29323);
            C4990ab.m7416i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert onSceneEnd " + i + " errCode " + i2 + " errMsg " + str + "  " + c1207m.getType());
            if (C36298h.this.ehJ != null) {
                C36298h.this.ehJ.dismiss();
                C36298h.this.ehJ = null;
            }
            if (c1207m.getType() == 255) {
                C9638aw.m17182Rg().mo14546b(255, C36298h.this.yic);
                if (i == 0 && i2 == 0) {
                    C36298h.this.mo57167pF(true);
                    AppMethodBeat.m2505o(29323);
                    return;
                } else if (C30784a.m49123a(C36298h.this.yhZ, i, i2, str, 4)) {
                    AppMethodBeat.m2505o(29323);
                    return;
                } else {
                    C36298h.this.mo57167pF(false);
                    AppMethodBeat.m2505o(29323);
                    return;
                }
            }
            if (c1207m.getType() == 384) {
                if (i == 0 && i2 == 0) {
                    C9638aw.m17190ZK();
                    C18628c.m29072Ry().set(77830, ((C9703aa) c1207m).agg());
                    Intent intent = new Intent(C36298h.this.yhZ, RegByMobileSetPwdUI.class);
                    intent.putExtra("kintent_hint", C36298h.this.getString(C25738R.string.e8s));
                    C36298h.this.yhZ.startActivity(intent);
                    AppMethodBeat.m2505o(29323);
                    return;
                }
                C36298h.this.qmB = true;
                C30379h.m48431a(C36298h.this.yhZ, (int) C25738R.string.e9r, (int) C25738R.string.f9238tz, new C240121());
            }
            AppMethodBeat.m2505o(29323);
        }
    }

    /* renamed from: com.tencent.mm.ui.h$12 */
    class C3071512 implements OnClickListener {

        /* renamed from: com.tencent.mm.ui.h$12$1 */
        class C158961 implements OnClickListener {
            C158961() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        C3071512() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(29325);
            String obj = C36298h.this.qmA.getText().toString();
            C36298h.this.qmA.setText("");
            C36298h.this.qmA.clearFocus();
            C42252ah.m74605a(C36298h.this.yhZ, C36298h.this.qmA);
            if (obj == null || obj.equals("")) {
                C30379h.m48431a(C36298h.this.yhZ, (int) C25738R.string.f0s, (int) C25738R.string.f9238tz, new C158961());
                AppMethodBeat.m2505o(29325);
                return;
            }
            C36298h.this.dxf();
            C9638aw.m17182Rg().mo14539a(384, C36298h.this.yic);
            final C1207m c9703aa = new C9703aa(obj, "", "", "");
            C9638aw.m17182Rg().mo14541a(c9703aa, 0);
            C36298h c36298h = C36298h.this;
            Context context = C36298h.this.yhZ;
            C36298h.this.getString(C25738R.string.f9238tz);
            c36298h.ehJ = C30379h.m48458b(context, C36298h.this.getString(C25738R.string.e7z), true, new OnCancelListener() {
                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.m2504i(29324);
                    C9638aw.m17182Rg().mo14546b(384, C36298h.this.yic);
                    C36298h.this.yic = null;
                    C9638aw.m17182Rg().mo14547c(c9703aa);
                    AppMethodBeat.m2505o(29324);
                }
            });
            AppMethodBeat.m2505o(29325);
        }
    }

    /* renamed from: com.tencent.mm.ui.h$1 */
    class C307161 extends C4884c<C18295ij> {
        C307161() {
            AppMethodBeat.m2504i(29306);
            this.xxI = C18295ij.class.getName().hashCode();
            AppMethodBeat.m2505o(29306);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(29307);
            C18295ij c18295ij = (C18295ij) c4883b;
            if (c18295ij == null || c18295ij.cDv == null || c18295ij.cDv.cDw == null) {
                C4990ab.m7417i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert event is illegal event[%s]", c18295ij);
            } else {
                C4990ab.m7417i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert event launcherUI isResumeStatus[%b], tid[%d]", Boolean.valueOf(C36298h.this.yia.dxp()), Long.valueOf(Thread.currentThread().getId()));
                if (C36298h.this.yia.dxp()) {
                    C36298h.this.yib = null;
                    C36298h.this.mo57163a(c18295ij.cDv);
                } else {
                    C36298h.this.yib = c18295ij.cDv;
                }
            }
            AppMethodBeat.m2505o(29307);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.h$3 */
    class C307173 implements OnClickListener {
        C307173() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
        }
    }

    /* renamed from: com.tencent.mm.ui.h$4 */
    class C362994 implements OnClickListener {

        /* renamed from: com.tencent.mm.ui.h$4$1 */
        class C240141 implements Runnable {
            C240141() {
            }

            public final void run() {
                AppMethodBeat.m2504i(29309);
                C1720g.m3537RQ().mo5257lL("");
                MMAppMgr.aAd();
                AppMethodBeat.m2505o(29309);
            }
        }

        C362994() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(29310);
            C5004al.m7441d(new C240141());
            AppMethodBeat.m2505o(29310);
        }
    }

    /* renamed from: com.tencent.mm.ui.h$6 */
    class C363026 implements Runnable {

        /* renamed from: com.tencent.mm.ui.h$6$3 */
        class C363033 implements OnClickListener {
            C363033() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(29315);
                dialogInterface.dismiss();
                AppMethodBeat.m2505o(29315);
            }
        }

        C363026() {
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x016c  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x017c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            boolean z;
            AppMethodBeat.m2504i(29316);
            SharedPreferences doB = C4996ah.doB();
            long j = doB.getLong("show_sdcard_full_time", 0);
            long currentTimeMillis = System.currentTimeMillis();
            boolean z2 = currentTimeMillis - j > 10800000 || j > currentTimeMillis;
            C36298h c36298h = C36298h.this;
            int On = C40600a.m70011On();
            boolean Mo = C1445f.m3071Mo();
            C4990ab.m7417i("MicroMsg.LauncherUI.GlobalAlertMgr", "%d check mobile available space _dataRet[%d] checkSdIsFull[%b] needShowAlert[%b] testCode[%d] ", Integer.valueOf(c36298h.hashCode()), Integer.valueOf(On), Boolean.valueOf(Mo), Boolean.valueOf(z2), Integer.valueOf(c36298h.cur));
            if (c36298h.cur == 1) {
                On = 1;
                z = true;
                c36298h.cur = 4;
            } else {
                if (c36298h.cur == 2) {
                    z = true;
                    On = 2;
                } else if (c36298h.cur == 3) {
                    On = 0;
                    Mo = true;
                    z = true;
                } else if (c36298h.cur == 4) {
                    c36298h.cur = 0;
                    z2 = false;
                    if (z2) {
                        doB.edit().putLong("show_sdcard_full_time", currentTimeMillis).commit();
                    }
                    if (!z2) {
                        C9638aw.m17190ZK();
                        if (((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_BIND_MOBILE_XML_TIP_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                            C9638aw.m17190ZK();
                            if (C42252ah.isNullOrNil((String) C18628c.m29072Ry().get(6, (Object) ""))) {
                                C9638aw.m17190ZK();
                                z = ((Boolean) C18628c.m29072Ry().get(C5127a.USERINFO_BIND_MOBILE_XML_FORCE_BIND_BOOLEAN, Boolean.FALSE)).booleanValue();
                                C9638aw.m17190ZK();
                                final String str = (String) C18628c.m29072Ry().get(C5127a.USERINFO_BIND_MOBILE_XML_WORDING_STRING, C36298h.this.getString(C25738R.string.a72));
                                C4990ab.m7417i("MicroMsg.LauncherUI.GlobalAlertMgr", "summerbindmobile tip[%b], bindMobile[%s], force[%b], wording[%s]", Boolean.valueOf(r2), r0, Boolean.valueOf(z), str);
                                if (z) {
                                    C30379h.m48447a(C36298h.this.yhZ, str, C36298h.this.getString(C25738R.string.f9238tz), C36298h.this.getString(C25738R.string.f9187s6), false, new OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            AppMethodBeat.m2504i(29313);
                                            Intent intent = new Intent();
                                            intent.setClass(C36298h.this.yhZ, BindMobileUI.class);
                                            intent.putExtra("kstyle_bind_wording", new BindWordingContent(str, ""));
                                            MMWizardActivity.m23791J(C36298h.this.yhZ, intent);
                                            dialogInterface.dismiss();
                                            AppMethodBeat.m2505o(29313);
                                        }
                                    });
                                } else {
                                    C30379h.m48466d(C36298h.this.yhZ, str, C36298h.this.getString(C25738R.string.f9238tz), C36298h.this.getString(C25738R.string.f9187s6), C36298h.this.getString(C25738R.string.f9076or), new OnClickListener() {
                                        public final void onClick(DialogInterface dialogInterface, int i) {
                                            AppMethodBeat.m2504i(29314);
                                            Intent intent = new Intent();
                                            intent.setClass(C36298h.this.yhZ, BindMobileUI.class);
                                            intent.putExtra("kstyle_bind_wording", new BindWordingContent(str, ""));
                                            MMWizardActivity.m23791J(C36298h.this.yhZ, intent);
                                            dialogInterface.dismiss();
                                            AppMethodBeat.m2505o(29314);
                                        }
                                    }, new C363033());
                                }
                            } else {
                                C4990ab.m7417i("MicroMsg.LauncherUI.GlobalAlertMgr", "summerbindmobile has bind[%s]", (String) C18628c.m29072Ry().get(6, (Object) ""));
                            }
                            C9638aw.m17190ZK();
                            C18628c.m29072Ry().set(C5127a.USERINFO_BIND_MOBILE_XML_TIP_BOOLEAN, Boolean.FALSE);
                            C9638aw.m17190ZK();
                            C18628c.m29072Ry().set(C5127a.USERINFO_BIND_MOBILE_XML_WORDING_STRING, (Object) "");
                            C9638aw.m17190ZK();
                            C18628c.m29072Ry().dsb();
                        }
                    }
                    AppMethodBeat.m2505o(29316);
                } else {
                    z = z2;
                }
                c36298h.cur = 0;
            }
            C5652a c5652a;
            if (On == 1) {
                if (z) {
                    z2 = true;
                    c5652a = new C5652a(c36298h.yhZ);
                    c5652a.mo11446PV(C25738R.string.apc);
                    c5652a.asE(c36298h.yhZ.getString(C25738R.string.apb));
                    c5652a.mo11482rc(false);
                    c5652a.mo11453Qc(C25738R.string.ap9).mo11457a(new C307173());
                    c5652a.aMb().show();
                    C4990ab.m7411d("MicroMsg.LauncherUI.GlobalAlertMgr", "%d show no space notification isShowLackSpaceNotification[%b]", Integer.valueOf(c36298h.hashCode()), Boolean.valueOf(c36298h.yid));
                    if (!c36298h.yid) {
                        C9638aw.getNotification().cancel(45);
                        c36298h.yid = true;
                        PendingIntent activity = PendingIntent.getActivity(C4996ah.getContext(), 45, new Intent(C4996ah.getContext(), LauncherUI.class), 134217728);
                        C0358c z3 = C45186a.m83262bt(C4996ah.getContext(), "reminder_channel_id").mo625g(c36298h.getString(C25738R.string.apc)).mo621d(c36298h.getString(C25738R.string.apc)).mo623e(c36298h.getString(C25738R.string.apb)).mo628z(false);
                        z3.f362EI = activity;
                        z3.mo627k(2, true);
                        Notification build = z3.build();
                        build.icon = C45186a.bWV();
                        build.flags |= 32;
                        C9638aw.getNotification().mo41574a(45, build, false);
                    }
                    C7060h.pYm.mo8378a(282, 20, 1, false);
                }
                z2 = false;
            } else if (On == 2) {
                if (z) {
                    z2 = true;
                    C9638aw.hold();
                    c5652a = new C5652a(c36298h.yhZ);
                    c5652a.mo11446PV(C25738R.string.apa);
                    c5652a.asE(c36298h.yhZ.getString(C25738R.string.ap_));
                    c5652a.mo11482rc(false);
                    c5652a.mo11453Qc(C25738R.string.ap8).mo11457a(new C362994());
                    c5652a.aMb().show();
                    C7060h.pYm.mo8378a(282, 2, 1, false);
                }
                z2 = false;
            } else {
                C4990ab.m7411d("MicroMsg.LauncherUI.GlobalAlertMgr", "%d cancel no space notification isShowLackSpaceNotification[%b] hadCheckNotification[%b]", Integer.valueOf(c36298h.hashCode()), Boolean.valueOf(c36298h.yid), Boolean.valueOf(c36298h.yie));
                if (!c36298h.yie || c36298h.yid) {
                    C9638aw.getNotification().cancel(45);
                    c36298h.yid = false;
                }
                c36298h.yie = true;
                if (Mo && z) {
                    C30379h.m48466d(c36298h.yhZ, c36298h.getString(C25738R.string.dz8), c36298h.getString(C25738R.string.dz9), c36298h.getString(C25738R.string.f9079ov), c36298h.getString(C25738R.string.f9153r6), new C363055(), null);
                    C7060h.pYm.mo8378a(282, 0, 1, false);
                    z2 = true;
                }
                z2 = false;
            }
            C4990ab.m7417i("MicroMsg.LauncherUI.GlobalAlertMgr", "%d check mobile available space isShowAlert[%b]", Integer.valueOf(c36298h.hashCode()), Boolean.valueOf(z2));
            if (z2) {
            }
            if (z2) {
            }
            AppMethodBeat.m2505o(29316);
        }

        public final String toString() {
            AppMethodBeat.m2504i(29317);
            String str = super.toString() + "|doOnResumeCheck";
            AppMethodBeat.m2505o(29317);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.ui.h$5 */
    class C363055 implements OnClickListener {
        C363055() {
        }

        public final void onClick(final DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(29312);
            C5004al.m7441d(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(29311);
                    C9638aw.m17190ZK();
                    if (C18628c.isSDCardAvailable()) {
                        Intent intent = new Intent();
                        intent.putExtra("had_detected_no_sdcard_space", true);
                        C25985d.m41467b(C36298h.this.yhZ, "clean", ".ui.CleanUI", intent);
                    } else {
                        C23639t.m36492hO(C36298h.this.yhZ);
                    }
                    dialogInterface.dismiss();
                    C7060h.pYm.mo8378a(282, 1, 1, false);
                    AppMethodBeat.m2505o(29311);
                }
            });
            AppMethodBeat.m2505o(29312);
        }
    }

    public C36298h(MMFragmentActivity mMFragmentActivity, C36032b c36032b) {
        AppMethodBeat.m2504i(29327);
        this.yhZ = mMFragmentActivity;
        this.yia = c36032b;
        AppMethodBeat.m2505o(29327);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final boolean mo57163a(C18294a c18294a) {
        AppMethodBeat.m2504i(29328);
        if (c18294a == null || c18294a.cDw == null || c18294a.cDw.vzI == null || c18294a.cDw.vzI.size() == 0) {
            AppMethodBeat.m2505o(29328);
            return false;
        }
        final int i = c18294a.cDw.f17912id;
        String str = c18294a.cDw.title;
        String str2 = c18294a.cDw.bzH;
        int i2 = c18294a.type;
        int size = c18294a.cDw.vzI.size();
        if (i2 == 0) {
            if (size == 1) {
                final C23368a c23368a = (C23368a) c18294a.cDw.vzI.get(0);
                C4990ab.m7417i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert id[%d], title[%s], msg[%s], id[%d], action[%d], btnstr[%s], btnurl[%s]", Integer.valueOf(i), str, str2, Integer.valueOf(c23368a.f4411id), Integer.valueOf(c23368a.actionType), c23368a.vzG, c23368a.vzH);
                C30379h.m48447a(this.yhZ, str2, str, c23368a.vzG, false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(29318);
                        C36298h.m59753a(C36298h.this, i, c23368a.actionType, c23368a.f4411id, c23368a.vzH);
                        dialogInterface.dismiss();
                        AppMethodBeat.m2505o(29318);
                    }
                });
            } else {
                final C23368a c23368a2 = (C23368a) c18294a.cDw.vzI.get(1);
                final C23368a c23368a3 = (C23368a) c18294a.cDw.vzI.get(0);
                C4990ab.m7417i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert title[%s], msg[%s], id1[%d], action1[%d], btnstr1[%s],btnurl1[%s], id2[%d], action2[%d], btnstr2[%s], btnurl2[%s]", str, str2, Integer.valueOf(c23368a2.f4411id), Integer.valueOf(c23368a2.actionType), c23368a2.vzG, c23368a2.vzH, Integer.valueOf(c23368a3.f4411id), Integer.valueOf(c23368a3.actionType), c23368a3.vzG, c23368a3.vzH);
                C30379h.m48445a(this.yhZ, str2, str, c23368a2.vzG, c23368a3.vzG, false, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(29319);
                        C36298h.m59753a(C36298h.this, i, c23368a2.actionType, c23368a2.f4411id, c23368a2.vzH);
                        dialogInterface.dismiss();
                        AppMethodBeat.m2505o(29319);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.m2504i(29320);
                        C36298h.m59753a(C36298h.this, i, c23368a3.actionType, c23368a3.f4411id, c23368a3.vzH);
                        dialogInterface.dismiss();
                        AppMethodBeat.m2505o(29320);
                    }
                });
            }
        } else if (i2 == 1) {
            C30379h.m48445a(this.yhZ, str2, str, ((C23368a) c18294a.cDw.vzI.get(0)).vzG, ((C23368a) c18294a.cDw.vzI.get(1)).vzG, false, c18294a.cDx, c18294a.cDy);
        }
        AppMethodBeat.m2505o(29328);
        return true;
    }

    /* Access modifiers changed, original: final */
    public final C1202f dxf() {
        AppMethodBeat.m2504i(29329);
        if (this.yic == null) {
            this.yic = new C3071311();
        }
        C1202f c1202f = this.yic;
        AppMethodBeat.m2505o(29329);
        return c1202f;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: pF */
    public final void mo57167pF(boolean z) {
        AppMethodBeat.m2504i(29330);
        C4990ab.m7410d("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert handlePassword ".concat(String.valueOf(z)));
        if (z) {
            dxg();
            AppMethodBeat.m2505o(29330);
            return;
        }
        Intent intent = new Intent(this.yhZ, RegByMobileSetPwdUI.class);
        intent.putExtra("kintent_hint", getString(C25738R.string.e8s));
        this.yhZ.startActivity(intent);
        AppMethodBeat.m2505o(29330);
    }

    /* Access modifiers changed, original: final */
    public final void dxg() {
        AppMethodBeat.m2504i(29331);
        if (this.gup != null) {
            this.gup.show();
            AppMethodBeat.m2505o(29331);
            return;
        }
        if (this.qmy == null) {
            this.qmy = View.inflate(this.yhZ, 2130970617, null);
            this.qmz = (TextView) this.qmy.findViewById(2131827352);
            this.qmz.setText(getString(C25738R.string.e7i));
            this.qmA = (EditText) this.qmy.findViewById(2131827353);
            this.qmA.setInputType(GmsClientSupervisor.DEFAULT_BIND_FLAGS);
        }
        this.gup = C30379h.m48436a(this.yhZ, null, this.qmy, new C3071512(), new C1589713());
        AppMethodBeat.m2505o(29331);
    }

    /* Access modifiers changed, original: final */
    public final String getString(int i) {
        AppMethodBeat.m2504i(29332);
        String string = this.yhZ.getString(i);
        AppMethodBeat.m2505o(29332);
        return string;
    }

    /* renamed from: a */
    static /* synthetic */ void m59753a(C36298h c36298h, int i, int i2, int i3, String str) {
        AppMethodBeat.m2504i(29333);
        C4990ab.m7417i("MicroMsg.LauncherUI.GlobalAlertMgr", "summeralert jumpByActionType  alertId[%d], actionType[%d], btnId[%d], url[%s]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        C7060h.pYm.mo8381e(13191, Integer.valueOf(i), Integer.valueOf(i3), Boolean.FALSE);
        Intent intent;
        switch (i2) {
            case 1:
                AppMethodBeat.m2505o(29333);
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
                C25985d.m41467b(c36298h.yhZ, "webview", ".ui.tools.WebViewUI", intent);
                AppMethodBeat.m2505o(29333);
                return;
            case 3:
                if (c36298h.qmB) {
                    c36298h.mo57167pF(true);
                    AppMethodBeat.m2505o(29333);
                    return;
                }
                c36298h.dxf();
                C9638aw.m17182Rg().mo14539a(255, c36298h.yic);
                final C1207m c9706r = new C9706r(1);
                C9638aw.m17182Rg().mo14541a(c9706r, 0);
                Context context = c36298h.yhZ;
                c36298h.getString(C25738R.string.f9238tz);
                c36298h.ehJ = C30379h.m48458b(context, c36298h.getString(C25738R.string.e7z), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.m2504i(29321);
                        C9638aw.m17182Rg().mo14547c(c9706r);
                        AppMethodBeat.m2505o(29321);
                    }
                });
                AppMethodBeat.m2505o(29333);
                return;
            case 4:
                Intent intent2 = new Intent();
                intent2.setClass(c36298h.yhZ, BindMContactUI.class);
                intent2.putExtra("bind_scene", 3);
                String simCountryIso = ((TelephonyManager) c36298h.yhZ.getSystemService("phone")).getSimCountryIso();
                if (!C42252ah.isNullOrNil(simCountryIso)) {
                    C17951a k = C17950b.m28210k(c36298h.yhZ, simCountryIso, c36298h.getString(C25738R.string.b3_));
                    if (k != null) {
                        intent2.putExtra("country_name", k.fHE);
                        intent2.putExtra("couttry_code", k.fHD);
                    }
                }
                MMWizardActivity.m23791J(c36298h.yhZ, intent2);
                AppMethodBeat.m2505o(29333);
                return;
            case 5:
                intent = new Intent();
                intent.putExtra("BaseScanUI_select_scan_mode", 1);
                intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
                intent.setFlags(65536);
                if (!(C35973a.m59178bI(c36298h.yhZ) || C17981e.akI())) {
                    C25985d.m41467b(c36298h.yhZ, "scanner", ".ui.BaseScanUI", intent);
                    break;
                }
        }
        AppMethodBeat.m2505o(29333);
    }
}
