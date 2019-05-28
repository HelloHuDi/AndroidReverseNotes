package com.tencent.p177mm.sandbox.updater;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMBaseActivity;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sandbox.C15411c;
import com.tencent.p177mm.sandbox.monitor.C15412c;
import com.tencent.p177mm.sandbox.updater.C44215j.C23491a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.sandbox.updater.AppUpdaterUI */
public class AppUpdaterUI extends MMBaseActivity {
    private static AppUpdaterUI xvH = null;
    private C5653c gud = null;
    private Button jAH;
    private OnClickListener xvD = new C486910();
    private Button xvG;
    private C44215j xvI;
    private C30281g xvJ = new C48551();
    private OnClickListener xvK = new C48599();

    /* renamed from: com.tencent.mm.sandbox.updater.AppUpdaterUI$2 */
    class C48532 implements OnCancelListener {
        C48532() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(28815);
            AppUpdaterUI.m7228i(AppUpdaterUI.this);
            AppMethodBeat.m2505o(28815);
        }
    }

    /* renamed from: com.tencent.mm.sandbox.updater.AppUpdaterUI$1 */
    class C48551 implements C30281g {

        /* renamed from: com.tencent.mm.sandbox.updater.AppUpdaterUI$1$2 */
        class C48562 implements OnClickListener {
            C48562() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }

        /* renamed from: com.tencent.mm.sandbox.updater.AppUpdaterUI$1$1 */
        class C48571 implements OnClickListener {
            C48571() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(28808);
                C4990ab.m7410d("MicroMsg.AppUpdaterUI", "go to WebView");
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://weixin.qq.com/m"));
                intent.addFlags(268435456);
                AppUpdaterUI.this.startActivity(intent);
                AppMethodBeat.m2505o(28808);
            }
        }

        C48551() {
        }

        /* renamed from: dN */
        public final void mo10019dN(int i, int i2) {
            AppMethodBeat.m2504i(28809);
            int i3 = (int) (i <= 0 ? 0 : (((long) i2) * 100) / ((long) i));
            if (i3 == 100) {
                AppUpdaterUI.this.xvG.setText(AppUpdaterUI.this.getString(C25738R.string.eyy));
                AppMethodBeat.m2505o(28809);
                return;
            }
            AppUpdaterUI.this.xvG.setText(AppUpdaterUI.this.getString(C25738R.string.eyw) + i3 + "%");
            AppMethodBeat.m2505o(28809);
        }

        public final void dnk() {
            AppMethodBeat.m2504i(28810);
            C4990ab.m7412e("MicroMsg.AppUpdaterUI", "no sdcard.");
            if (AppUpdaterUI.this.gud != null) {
                AppUpdaterUI.this.gud.dismiss();
            }
            if (AppUpdaterUI.this.isFinishing()) {
                AppMethodBeat.m2505o(28810);
                return;
            }
            AppUpdaterUI.m7222c(AppUpdaterUI.this);
            AppMethodBeat.m2505o(28810);
        }

        public final void dnl() {
            AppMethodBeat.m2504i(28811);
            if (AppUpdaterUI.this.gud != null) {
                AppUpdaterUI.this.gud.dismiss();
            }
            if (AppUpdaterUI.this.isFinishing()) {
                AppMethodBeat.m2505o(28811);
                return;
            }
            AppUpdaterUI.m7223d(AppUpdaterUI.this);
            AppMethodBeat.m2505o(28811);
        }

        public final void cpu() {
            AppMethodBeat.m2504i(28812);
            if (AppUpdaterUI.this.isFinishing()) {
                AppMethodBeat.m2505o(28812);
                return;
            }
            AppUpdaterUI.this.xvG.setText(C25738R.string.eyw);
            AppUpdaterUI.this.xvG.setEnabled(false);
            AppMethodBeat.m2505o(28812);
        }

        /* renamed from: YJ */
        public final void mo10016YJ(String str) {
            AppMethodBeat.m2504i(28813);
            if (AppUpdaterUI.this.gud != null) {
                AppUpdaterUI.this.gud.dismiss();
            }
            if (AppUpdaterUI.this.isFinishing()) {
                AppMethodBeat.m2505o(28813);
                return;
            }
            C4990ab.m7410d("MicroMsg.AppUpdaterUI", str);
            if (str != null) {
                AppUpdaterUI.m7220a(AppUpdaterUI.this, str);
                AppUpdaterUI.this.xvG.setEnabled(false);
            }
            AppMethodBeat.m2505o(28813);
        }

        /* renamed from: a */
        public final void mo10017a(C15412c c15412c) {
            AppMethodBeat.m2504i(28814);
            if (AppUpdaterUI.this.isFinishing()) {
                AppMethodBeat.m2505o(28814);
            } else if (c15412c instanceof C40609c) {
                C7060h.pYm.mo8378a(405, 67, 1, true);
                C4990ab.m7412e("MicroMsg.AppUpdaterUI", "download package from cdn error. switch to webserver");
                if (AppUpdaterUI.this.gud != null) {
                    AppUpdaterUI.this.gud.setMessage(AppUpdaterUI.this.getString(C25738R.string.byx, new Object[]{AppUpdaterUI.this.xvI.desc, AppUpdaterUI.this.getString(C25738R.string.eyt), C5046bo.m7565ga((long) AppUpdaterUI.this.xvI.size)}));
                }
                if (AppUpdaterUI.this.xvI.xwU) {
                    C7060h.pYm.mo8378a(405, 68, 1, true);
                    AppUpdaterUI.m7219a(AppUpdaterUI.this, c15412c);
                }
                AppMethodBeat.m2505o(28814);
            } else {
                C7060h.pYm.mo8378a(405, 69, 1, true);
                C30379h.m48432a(AppUpdaterUI.this, (int) C25738R.string.eyu, (int) C25738R.string.f9238tz, new C48571(), new C48562());
                AppMethodBeat.m2505o(28814);
            }
        }
    }

    /* renamed from: com.tencent.mm.sandbox.updater.AppUpdaterUI$8 */
    class C48588 implements OnCancelListener {
        C48588() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(28823);
            AppUpdaterUI.m7226g(AppUpdaterUI.this);
            AppMethodBeat.m2505o(28823);
        }
    }

    /* renamed from: com.tencent.mm.sandbox.updater.AppUpdaterUI$9 */
    class C48599 implements OnClickListener {
        C48599() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(28824);
            AppUpdaterUI.m7226g(AppUpdaterUI.this);
            AppMethodBeat.m2505o(28824);
        }
    }

    /* renamed from: com.tencent.mm.sandbox.updater.AppUpdaterUI$13 */
    class C486113 implements OnCancelListener {
        C486113() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(28828);
            C4990ab.m7410d("MicroMsg.AppUpdaterUI", "click cancel button");
            AppUpdaterUI.m7218a(AppUpdaterUI.this, 12);
            AppUpdaterUI.m7228i(AppUpdaterUI.this);
            AppMethodBeat.m2505o(28828);
        }
    }

    /* renamed from: com.tencent.mm.sandbox.updater.AppUpdaterUI$14 */
    class C486214 implements OnClickListener {
        C486214() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(28829);
            AppUpdaterUI.m7228i(AppUpdaterUI.this);
            AppMethodBeat.m2505o(28829);
        }
    }

    /* renamed from: com.tencent.mm.sandbox.updater.AppUpdaterUI$3 */
    class C48633 implements OnClickListener {
        C48633() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(28816);
            AppUpdaterUI.m7228i(AppUpdaterUI.this);
            AppMethodBeat.m2505o(28816);
        }
    }

    /* renamed from: com.tencent.mm.sandbox.updater.AppUpdaterUI$5 */
    class C48645 implements OnClickListener {
        C48645() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(28818);
            C4990ab.m7410d("MicroMsg.AppUpdaterUI", "update dialog had been canceled");
            if (AppUpdaterUI.this.gud != null && AppUpdaterUI.this.gud.isShowing()) {
                AppUpdaterUI.this.gud.dismiss();
            }
            AppUpdaterUI.m7218a(AppUpdaterUI.this, 6);
            if (AppUpdaterUI.this.xvI.xwY) {
                C7060h.pYm.mo8378a(614, 59, 1, true);
                C4990ab.m7410d("MicroMsg.AppUpdaterUI", "boots download cancel when downloading.");
            }
            AppUpdaterUI.this.xvI.cancel();
            AppUpdaterUI.this.xvI.mo69850aB(2, true);
            AppUpdaterUI.m7225f(AppUpdaterUI.this);
            AppMethodBeat.m2505o(28818);
        }
    }

    /* renamed from: com.tencent.mm.sandbox.updater.AppUpdaterUI$6 */
    class C48656 implements OnClickListener {
        C48656() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(28819);
            if (!(AppUpdaterUI.this.gud == null || AppUpdaterUI.this.gud.isShowing())) {
                AppUpdaterUI.this.gud.show();
            }
            AppMethodBeat.m2505o(28819);
        }
    }

    /* renamed from: com.tencent.mm.sandbox.updater.AppUpdaterUI$7 */
    class C48667 implements Runnable {

        /* renamed from: com.tencent.mm.sandbox.updater.AppUpdaterUI$7$2 */
        class C48672 implements OnCancelListener {
            C48672() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(28821);
                AppUpdaterUI.m7225f(AppUpdaterUI.this);
                AppMethodBeat.m2505o(28821);
            }
        }

        /* renamed from: com.tencent.mm.sandbox.updater.AppUpdaterUI$7$1 */
        class C48681 implements OnClickListener {
            C48681() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(28820);
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(AppUpdaterUI.this.xvI.xvX[0]));
                intent.addFlags(268435456);
                C4996ah.getContext().startActivity(intent);
                AppUpdaterUI.m7225f(AppUpdaterUI.this);
                AppMethodBeat.m2505o(28820);
            }
        }

        C48667() {
        }

        public final void run() {
            AppMethodBeat.m2504i(28822);
            C30379h.m48438a(AppUpdaterUI.this, AppUpdaterUI.this.xvI.desc, AppUpdaterUI.this.getString(C25738R.string.f9238tz), new C48681()).setOnCancelListener(new C48672());
            AppMethodBeat.m2505o(28822);
        }
    }

    /* renamed from: com.tencent.mm.sandbox.updater.AppUpdaterUI$10 */
    class C486910 implements OnClickListener {
        C486910() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(28825);
            C4990ab.m7410d("MicroMsg.AppUpdaterUI", "getBtn (ok button) is click");
            if (AppUpdaterUI.this.xvI.rlf == 1) {
                C44212i.m79788aq(AppUpdaterUI.this, 6);
            }
            if (!C1448h.getExternalStorageState().equals("mounted")) {
                C4990ab.m7412e("MicroMsg.AppUpdaterUI", "no sdcard.");
                AppUpdaterUI.this.gud.dismiss();
                AppUpdaterUI.m7222c(AppUpdaterUI.this);
                AppMethodBeat.m2505o(28825);
            } else if ((AppUpdaterUI.this.xvI.cdh & 1) != 0) {
                C4990ab.m7412e("MicroMsg.AppUpdaterUI", "package has set external update mode");
                Uri parse = Uri.parse(AppUpdaterUI.this.xvI.cdj);
                Intent addFlags = new Intent("android.intent.action.VIEW", parse).addFlags(268435456);
                if (parse == null || addFlags == null || !C5046bo.m7572k(AppUpdaterUI.this, addFlags)) {
                    C4990ab.m7412e("MicroMsg.AppUpdaterUI", "parse market uri failed, jump to weixin.qq.com");
                    AppUpdaterUI.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://weixin.qq.com")).addFlags(268435456));
                } else {
                    C4990ab.m7416i("MicroMsg.AppUpdaterUI", "parse market uri ok");
                    AppUpdaterUI.this.startActivity(addFlags);
                }
                AppUpdaterUI.m7225f(AppUpdaterUI.this);
                AppMethodBeat.m2505o(28825);
            } else {
                String bY = C15412c.m23694bY(AppUpdaterUI.this.xvI.cvZ, AppUpdaterUI.this.xvI.xwY);
                if (C5046bo.isNullOrNil(bY) && AppUpdaterUI.this.xvI.xwT != null) {
                    bY = C15412c.ama(AppUpdaterUI.this.xvI.xwT.cdx);
                }
                C4990ab.m7410d("MicroMsg.AppUpdaterUI", bY);
                if (bY != null) {
                    C4990ab.m7416i("MicroMsg.AppUpdaterUI", "update package already exist.");
                    AppUpdaterUI.m7218a(AppUpdaterUI.this, 8);
                    if (AppUpdaterUI.this.xvI.xwU) {
                        AppUpdaterUI.m7218a(AppUpdaterUI.this, 0);
                    } else {
                        AppUpdaterUI.m7218a(AppUpdaterUI.this, 9);
                    }
                    AppUpdaterUI.this.xvI.mo69850aB(1, true);
                    AppUpdaterUI.this.xvJ.mo10016YJ(bY);
                    AppMethodBeat.m2505o(28825);
                    return;
                }
                C4990ab.m7411d("MicroMsg.AppUpdaterUI", "current downloadMode : %s", Integer.valueOf(AppUpdaterUI.this.xvI.rlf));
                C4990ab.m7411d("MicroMsg.AppUpdaterUI", "current updateType : %s", Integer.valueOf(AppUpdaterUI.this.xvI.xvw));
                if (AppUpdaterUI.this.xvI.rlf == 0) {
                    AppUpdaterUI.this.xvI.dnC();
                    AppMethodBeat.m2505o(28825);
                } else if (AppUpdaterUI.this.xvI.rlf == 1) {
                    C4990ab.m7410d("MicroMsg.AppUpdaterUI", "gonna start UpdaterService");
                    AppUpdaterUI.m7225f(AppUpdaterUI.this);
                    Intent intent = new Intent(AppUpdaterUI.this.getIntent());
                    intent.setClass(AppUpdaterUI.this, UpdaterService.class);
                    intent.putExtra("intent_extra_run_in_foreground", true);
                    C25985d.m41477j(intent, "sandbox");
                    if (AppUpdaterUI.this.xvI.xwY) {
                        C7060h.pYm.mo8378a(614, 56, 1, false);
                        C4990ab.m7410d("MicroMsg.AppUpdaterUI", "boots download start.");
                    }
                    AppMethodBeat.m2505o(28825);
                } else {
                    C4990ab.m7412e("MicroMsg.AppUpdaterUI", "silence download never go here!");
                    AppMethodBeat.m2505o(28825);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.sandbox.updater.AppUpdaterUI$4 */
    class C48704 implements OnCancelListener {
        C48704() {
        }

        public final void onCancel(DialogInterface dialogInterface) {
            AppMethodBeat.m2504i(28817);
            AppUpdaterUI.m7228i(AppUpdaterUI.this);
            AppMethodBeat.m2505o(28817);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public AppUpdaterUI() {
        AppMethodBeat.m2504i(28830);
        AppMethodBeat.m2505o(28830);
    }

    /* renamed from: f */
    static /* synthetic */ void m7225f(AppUpdaterUI appUpdaterUI) {
        AppMethodBeat.m2504i(28839);
        appUpdaterUI.dnj();
        AppMethodBeat.m2505o(28839);
    }

    public static AppUpdaterUI dnh() {
        return xvH;
    }

    public static void dni() {
        AppMethodBeat.m2504i(28831);
        if (xvH != null) {
            xvH.dnj();
        }
        AppMethodBeat.m2505o(28831);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(28832);
        super.onCreate(bundle);
        C4990ab.m7410d("MicroMsg.AppUpdaterUI", "onCreate");
        C15411c.m23691l(hashCode(), this);
        MMActivity.initLanguage(this);
        if (AppInstallerUI.dng() != null && !AppInstallerUI.dng().isFinishing()) {
            C4990ab.m7410d("MicroMsg.AppUpdaterUI", "AppInstallerUI is there, finish self");
            finish();
            AppMethodBeat.m2505o(28832);
        } else if (xvH == null || xvH.isFinishing() || xvH == this) {
            xvH = this;
            setContentView(2130969389);
            this.xvI = C23491a.xxg;
            if (!this.xvI.mo69851aK(getIntent())) {
                C4990ab.m7412e("MicroMsg.AppUpdaterUI", "updaterManager.handleCommand return false");
                dnj();
                AppMethodBeat.m2505o(28832);
            } else if (this.xvI.xvw != 999 || this.xvI.xvX == null || this.xvI.xvX.length <= 0) {
                String string;
                int i;
                C4990ab.m7410d("MicroMsg.AppUpdaterUI", "showUpdateDlg, downloadUrls = " + this.xvI.xvX);
                C5652a c5652a = new C5652a(this);
                c5652a.mo11446PV(C25738R.string.byv);
                c5652a.mo11482rc(true);
                c5652a.mo11478f(new C48588());
                if (!this.xvI.xwU || this.xvI.xwT == null) {
                    C4990ab.m7410d("MicroMsg.AppUpdaterUI", "had try to download full pack.");
                    string = getString(C25738R.string.byx, new Object[]{this.xvI.desc, getString(C25738R.string.eyt), C5046bo.m7565ga((long) this.xvI.size)});
                } else {
                    string = getString(C25738R.string.byx, new Object[]{this.xvI.desc, getString(C25738R.string.eyx), C5046bo.m7565ga((long) this.xvI.xwT.size)});
                }
                if (this.xvI.xvw != 1) {
                    i = C25738R.string.eyp;
                } else {
                    i = C25738R.string.eys;
                }
                c5652a.asE(string);
                c5652a.mo11453Qc(C25738R.string.ez1).mo11462a(false, this.xvD);
                c5652a.mo11454Qd(i);
                this.gud = c5652a.aMb();
                this.gud.setCanceledOnTouchOutside(false);
                this.xvG = this.gud.getButton(-1);
                this.jAH = this.gud.getButton(-2);
                this.gud.show();
                if (this.xvI.rlf == 1) {
                    C44212i.m79788aq(this, 5);
                }
                if (this.xvI.xwY) {
                    C7060h.pYm.mo8378a(614, 60, 1, false);
                }
                C44215j c44215j = this.xvI;
                C30281g c30281g = this.xvJ;
                if (!(c30281g == null || c44215j.xwP.contains(c30281g))) {
                    c44215j.xwP.add(c30281g);
                }
                AppMethodBeat.m2505o(28832);
            } else {
                C4990ab.m7410d("MicroMsg.AppUpdaterUI", "into emergency status");
                new C7306ak().postDelayed(new C48667(), 100);
                AppMethodBeat.m2505o(28832);
            }
        } else {
            C4990ab.m7410d("MicroMsg.AppUpdaterUI", "duplicate instance, finish self");
            C4990ab.m7410d("MicroMsg.AppUpdaterUI", "we already got one instance, does it gonna leak?");
            finish();
            AppMethodBeat.m2505o(28832);
        }
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(28833);
        C4990ab.m7410d("MicroMsg.AppUpdaterUI", "onDestroy");
        C15411c.m23692m(hashCode(), this);
        if (this.xvI != null) {
            C44215j c44215j = this.xvI;
            c44215j.xwP.remove(this.xvJ);
        }
        if (xvH == this) {
            xvH = null;
        }
        super.onDestroy();
        AppMethodBeat.m2505o(28833);
    }

    private void dnj() {
        AppMethodBeat.m2504i(28834);
        if (this.gud != null && this.gud.isShowing()) {
            this.gud.dismiss();
        }
        finish();
        AppMethodBeat.m2505o(28834);
    }

    /* renamed from: c */
    static /* synthetic */ void m7222c(AppUpdaterUI appUpdaterUI) {
        AppMethodBeat.m2504i(28835);
        C4990ab.m7410d("MicroMsg.AppUpdaterUI", "showNoSDCardAlert");
        C7060h.pYm.mo8378a(405, 65, 1, true);
        C30379h.m48438a((Context) appUpdaterUI, appUpdaterUI.getString(C25738R.string.eyz), appUpdaterUI.getString(C25738R.string.f9238tz), new C48633()).setOnCancelListener(new C48704());
        AppMethodBeat.m2505o(28835);
    }

    /* renamed from: d */
    static /* synthetic */ void m7223d(AppUpdaterUI appUpdaterUI) {
        AppMethodBeat.m2504i(28836);
        C4990ab.m7410d("MicroMsg.AppUpdaterUI", "showSDCardFullAlert");
        C7060h.pYm.mo8378a(405, 66, 1, true);
        C30379h.m48438a((Context) appUpdaterUI, appUpdaterUI.getString(C25738R.string.ez2), appUpdaterUI.getString(C25738R.string.f9238tz), new C486214()).setOnCancelListener(new C48532());
        AppMethodBeat.m2505o(28836);
    }

    /* renamed from: g */
    static /* synthetic */ void m7226g(AppUpdaterUI appUpdaterUI) {
        AppMethodBeat.m2504i(28840);
        C4990ab.m7410d("MicroMsg.AppUpdaterUI", "showDownloadCancelAlert");
        if (appUpdaterUI.xvI.xwZ) {
            C30379h.m48459b((Context) appUpdaterUI, (int) C25738R.string.abz, new C48645(), new C48656());
            AppMethodBeat.m2505o(28840);
            return;
        }
        if (appUpdaterUI.xvI.rlf == 1) {
            C44212i.m79788aq(appUpdaterUI, 7);
            if (appUpdaterUI.xvI.xwY) {
                C7060h.pYm.mo8378a(614, 57, 1, true);
                C4990ab.m7410d("MicroMsg.AppUpdaterUI", "boots download cancel.");
            }
        }
        C44212i.m79787ap(appUpdaterUI, 6);
        appUpdaterUI.xvI.mo69850aB(2, true);
        appUpdaterUI.dnj();
        AppMethodBeat.m2505o(28840);
    }

    /* renamed from: i */
    static /* synthetic */ void m7228i(AppUpdaterUI appUpdaterUI) {
        AppMethodBeat.m2504i(28842);
        appUpdaterUI.xvI.cancel();
        appUpdaterUI.xvI.mo69850aB(2, true);
        appUpdaterUI.dnj();
        AppMethodBeat.m2505o(28842);
    }
}
