package com.tencent.p177mm.p612ui.conversation;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1447g.C1446a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.modelmulti.C18668n;
import com.tencent.p177mm.modelmulti.C37942k;
import com.tencent.p177mm.modelmulti.C9692e;
import com.tencent.p177mm.network.C1898c;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C32231g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p209c.C32429a;
import com.tencent.p177mm.p209c.C41914i;
import com.tencent.p177mm.p209c.C41914i.C32431a;
import com.tencent.p177mm.p230g.p231a.C32561go;
import com.tencent.p177mm.p230g.p231a.C32641tl;
import com.tencent.p177mm.p230g.p231a.C42011iv;
import com.tencent.p177mm.p230g.p231a.C9418my;
import com.tencent.p177mm.p612ui.C30777u;
import com.tencent.p177mm.p612ui.C30777u.C30784a;
import com.tencent.p177mm.p612ui.LauncherUI;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5659a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5662c;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C33333a;
import com.tencent.p177mm.plugin.dbbackup.DBRecoveryUI;
import com.tencent.p177mm.plugin.p1283p.C21429d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.sns.p1024b.C21877n;
import com.tencent.p177mm.pluginsdk.model.app.C35800q;
import com.tencent.p177mm.pluginsdk.p1079f.C30035i;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.che;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.FLock;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7580z;
import com.tencent.p177mm.storage.C7617ak;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.io.File;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.ui.conversation.k */
public final class C46682k implements C1202f, C32231g {
    private static boolean zuK = false;
    Activity czX;
    ProgressDialog ehJ = null;
    WeakReference<Activity> gWO;
    WakeLock wakeLock = null;
    private C5653c zuE = null;
    private C5653c zuF = null;
    private boolean zuG = false;
    private C1446a zuH = new C1446a();
    boolean zuI = false;
    private C9692e zuJ = null;
    C23972a zuL;
    C36294a zuM;
    C4884c zuN = new C158741();
    C4884c zuO = new C408566();
    FLock zuP;

    /* renamed from: com.tencent.mm.ui.conversation.k$9 */
    class C54909 implements OnClickListener {
        C54909() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(34477);
            C46682k.this.zuF.dismiss();
            Intent intent = new Intent(C46682k.this.czX, DBRecoveryUI.class);
            intent.putExtra("scene", 0);
            C46682k.this.czX.startActivity(intent);
            AppMethodBeat.m2505o(34477);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.k$13 */
    class C1587313 implements Runnable {
        C1587313() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34482);
            C18668n.ahW().mo44216lN(5);
            AppMethodBeat.m2505o(34482);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.k$1 */
    class C158741 extends C4884c<C9418my> {
        C158741() {
            AppMethodBeat.m2504i(34461);
            this.xxI = C9418my.class.getName().hashCode();
            AppMethodBeat.m2505o(34461);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(34462);
            ((C9418my) c4883b).cIV.cIW = C46682k.this.dIQ();
            AppMethodBeat.m2505o(34462);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.k$3 */
    class C158753 implements OnClickListener {
        C158753() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(34464);
            Intent intent = new Intent();
            intent.setClassName(C46682k.this.czX, "com.tencent.mm.plugin.account.ui.RegByFacebookSetPwdUI");
            C46682k.this.czX.startActivity(intent);
            AppMethodBeat.m2505o(34464);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.k$4 */
    class C306954 implements OnClickListener {
        C306954() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(34465);
            dialogInterface.dismiss();
            AppMethodBeat.m2505o(34465);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.k$2 */
    class C362902 implements Runnable {
        C362902() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34463);
            C32561go c32561go = new C32561go();
            c32561go.cBl.data = "MAIN_UI_EVENT_INIT_FINALLY";
            C4879a.xxA.mo10055m(c32561go);
            AppMethodBeat.m2505o(34463);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.k$8 */
    class C362938 implements OnClickListener {

        /* renamed from: com.tencent.mm.ui.conversation.k$8$1 */
        class C239951 implements Runnable {
            C239951() {
            }

            public final void run() {
                AppMethodBeat.m2504i(34474);
                C7580z Ry = C1720g.m3536RP().mo5239Ry();
                Ry.set(89, Integer.valueOf(2));
                Ry.dsb();
                AppMethodBeat.m2505o(34474);
            }
        }

        /* renamed from: com.tencent.mm.ui.conversation.k$8$2 */
        class C306962 implements OnClickListener {
            C306962() {
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.m2504i(34475);
                C46682k.m88412c(C46682k.this);
                AppMethodBeat.m2505o(34475);
            }
        }

        C362938() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(34476);
            C1720g.m3539RS().mo10302aa(new C239951());
            C46682k.this.zuF.dismiss();
            C30379h.m48433a(C46682k.this.czX, (int) C25738R.string.b4b, (int) C25738R.string.f9238tz, false, new C306962());
            AppMethodBeat.m2505o(34476);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.k$a */
    public interface C36294a {
        void dIR();

        void dIS();
    }

    /* renamed from: com.tencent.mm.ui.conversation.k$6 */
    class C408566 extends C4884c<C32641tl> {
        C408566() {
            AppMethodBeat.m2504i(34471);
            this.xxI = C32641tl.class.getName().hashCode();
            AppMethodBeat.m2505o(34471);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(34472);
            if (C46682k.this.czX == null) {
                C4990ab.m7416i("MicroMsg.InitHelper", "inithelper hasn't initialized");
                AppMethodBeat.m2505o(34472);
            } else {
                C46682k.this.zuG = false;
                C46682k.m88412c(C46682k.this);
                AppMethodBeat.m2505o(34472);
            }
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.k$7 */
    class C408577 implements Runnable {
        C408577() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34473);
            C46682k.m88413d(C46682k.this);
            AppMethodBeat.m2505o(34473);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.k$10 */
    class C4668110 implements Runnable {

        /* renamed from: com.tencent.mm.ui.conversation.k$10$1 */
        class C239941 implements OnCancelListener {
            C239941() {
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.m2504i(34478);
                C9638aw.m17182Rg().mo14547c(C46682k.this.zuJ);
                if (C21877n.qFy != null) {
                    C21877n.qFy.cml();
                }
                AppMethodBeat.m2505o(34478);
            }
        }

        C4668110() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34479);
            String str = "MicroMsg.InitHelper";
            String str2 = "dkinit showProgressDlg t:%d initScene:%d";
            Object[] objArr = new Object[2];
            objArr[0] = Long.valueOf(C46682k.this.zuH.mo4908Mr());
            objArr[1] = Integer.valueOf(C46682k.this.zuJ == null ? -2 : C46682k.this.zuJ.hashCode());
            C4990ab.m7411d(str, str2, objArr);
            if (C46682k.this.ehJ != null && C46682k.this.ehJ.isShowing()) {
                C46682k.this.ehJ.dismiss();
            }
            C46682k c46682k = C46682k.this;
            Context a = C46682k.this.czX;
            C46682k.this.czX.getString(C25738R.string.f9238tz);
            c46682k.ehJ = C30379h.m48458b(a, C46682k.this.czX.getString(C25738R.string.f9161re), false, new C239941());
            C9638aw.m17180RS().mo10299Bn();
            AppMethodBeat.m2505o(34479);
        }
    }

    public C46682k() {
        AppMethodBeat.m2504i(34483);
        AppMethodBeat.m2505o(34483);
    }

    /* renamed from: c */
    static /* synthetic */ void m88412c(C46682k c46682k) {
        AppMethodBeat.m2504i(34490);
        c46682k.dIO();
        AppMethodBeat.m2505o(34490);
    }

    /* Access modifiers changed, original: final */
    public final boolean dIN() {
        AppMethodBeat.m2504i(34484);
        if (!C37942k.ahT()) {
            AppMethodBeat.m2505o(34484);
            return false;
        } else if (this.zuF == null || !this.zuF.isShowing()) {
            C1720g.m3537RQ();
            if (C1720g.m3536RP().mo5233Rr()) {
                this.zuF = new C5652a(this.czX).mo11446PV(C25738R.string.b4r).asE(this.czX.getString(C25738R.string.b4q)).mo11482rc(false).mo11453Qc(C25738R.string.b4s).mo11457a(new C54909()).mo11454Qd(C25738R.string.b4p).mo11476b(new C362938()).aMb();
                this.zuF.show();
            } else {
                dIO();
            }
            AppMethodBeat.m2505o(34484);
            return true;
        } else {
            AppMethodBeat.m2505o(34484);
            return false;
        }
    }

    private void dIO() {
        AppMethodBeat.m2504i(34485);
        if (this.zuG) {
            C4990ab.m7416i("MicroMsg.InitHelper", "summerinit doPreCreate but hasTryDoInitButFailed true ret");
            AppMethodBeat.m2505o(34485);
            return;
        }
        if (!this.wakeLock.isHeld()) {
            C4990ab.m7420w("MicroMsg.InitHelper", "tryDoInit wakelock.acquire!");
            this.wakeLock.acquire();
        }
        this.zuM.dIR();
        if (this.zuJ == null) {
            if (C21877n.qFy != null) {
                C21877n.qFy.cmk();
            }
            this.zuJ = new C9692e(this);
            C4990ab.m7411d("MicroMsg.InitHelper", "dkinit doPreCreate t:%d initScene:%d", Long.valueOf(this.zuH.mo4908Mr()), Integer.valueOf(this.zuJ.hashCode()));
            this.zuH.evE = SystemClock.elapsedRealtime();
            C9638aw.m17182Rg().mo14541a(this.zuJ, 0);
        }
        C5004al.m7441d(new C4668110());
        AppMethodBeat.m2505o(34485);
    }

    /* renamed from: a */
    public final void mo8280a(int i, int i2, C1207m c1207m) {
        AppMethodBeat.m2504i(34486);
        if (c1207m == null || c1207m.getType() != C33333a.CTRL_INDEX) {
            AppMethodBeat.m2505o(34486);
            return;
        }
        final int i3 = (int) (i2 != 0 ? (((long) i) * 100) / ((long) i2) : 0);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(34480);
                if (C46682k.this.ehJ != null) {
                    C46682k.this.ehJ.setMessage(C46682k.this.czX.getString(C25738R.string.f9161re) + i3 + "%");
                }
                AppMethodBeat.m2505o(34480);
            }
        });
        AppMethodBeat.m2505o(34486);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x01be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(34487);
        if (c1207m.getType() == 138 || c1207m.getType() == C33333a.CTRL_INDEX) {
            int i3;
            String str2 = "MicroMsg.InitHelper";
            String str3 = "dkinit onSceneEnd:[%d,%d,%s] type:%d hash:%d init:%d ";
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = str;
            objArr[3] = Integer.valueOf(c1207m.getType());
            objArr[4] = Integer.valueOf(hashCode());
            if (this.zuJ == null) {
                i3 = -2;
            } else {
                i3 = this.zuJ.hashCode();
            }
            objArr[5] = Integer.valueOf(i3);
            C4990ab.m7417i(str2, str3, objArr);
            if (this.zuJ != null && c1207m.getType() == C33333a.CTRL_INDEX) {
                this.zuJ = null;
                C4990ab.m7421w("MicroMsg.InitHelper", "summerinit dkinit Kevin init FINISH : %d ", Long.valueOf(this.zuH.mo4908Mr()));
                C26417a.flu.mo20966a(null, null, null);
                if (C21877n.qFy != null) {
                    C21877n.qFy.cml();
                }
                this.zuM.dIS();
                if (this.wakeLock.isHeld()) {
                    C4990ab.m7420w("MicroMsg.InitHelper", "onSceneEnd wakelock.release!");
                    this.wakeLock.release();
                }
                C9638aw.m17180RS().doM();
                if (this.ehJ != null) {
                    this.ehJ.dismiss();
                    this.ehJ = null;
                }
                final Activity activity = (Activity) this.gWO.get();
                if (C1720g.m3531RK() && C1720g.m3534RN().eJb && activity != null && !this.czX.getSharedPreferences(C4996ah.doA() + "_fontScaleTip", 0).getBoolean("font_scale_tip_login", false)) {
                    if (1.0f != C1338a.m2860dm(this.czX)) {
                        this.czX.getSharedPreferences(C4996ah.doA() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip_login", true).apply();
                        i3 = 1;
                    } else if (1.0f != this.czX.getResources().getConfiguration().fontScale) {
                        C7060h.pYm.mo8381e(15181, Integer.valueOf(1));
                        C5659a c5659a = new C5659a(activity);
                        C5659a asL = c5659a.mo11514al(activity.getResources().getString(C25738R.string.bz9)).asL(activity.getResources().getString(C25738R.string.bz6));
                        asL.zQJ = activity.getResources().getString(C25738R.string.bz8);
                        asL.zQK = activity.getResources().getString(C25738R.string.bz7);
                        c5659a.mo11523c(new C5662c() {
                            /* renamed from: d */
                            public final void mo5699d(boolean z, String str) {
                                AppMethodBeat.m2504i(34481);
                                if (z) {
                                    C7060h.pYm.mo8381e(15181, Integer.valueOf(3));
                                    Intent intent = new Intent();
                                    intent.setClassName(C4996ah.getPackageName(), "com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI");
                                    activity.startActivity(intent);
                                    AppMethodBeat.m2505o(34481);
                                    return;
                                }
                                C7060h.pYm.mo8381e(15181, Integer.valueOf(2));
                                AppMethodBeat.m2505o(34481);
                            }
                        }).show();
                        this.czX.getSharedPreferences(C4996ah.doA() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip_login", true).apply();
                        i3 = 1;
                    }
                    if (i3 == 0) {
                        this.czX.getSharedPreferences(C4996ah.doA() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip", false).apply();
                    }
                }
                i3 = 0;
                if (i3 == 0) {
                }
            }
            if (C30777u.m49118a(this.czX, i, i2, new Intent().setClass(this.czX, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str)) {
                C4990ab.m7416i("MicroMsg.InitHelper", "summerinit onSceneEnd accountExpired ret");
                AppMethodBeat.m2505o(34487);
            } else if (C9638aw.m17179RK()) {
                if (!this.zuI) {
                    this.zuI = true;
                    C9638aw.m17190ZK();
                    str2 = (String) C18628c.m29072Ry().get(5, null);
                    C9638aw.m17190ZK();
                    if (!((((Integer) C18628c.m29072Ry().get(57, Integer.valueOf(0))).intValue() != 0 ? 1 : 0) == 0 || str2 == null)) {
                        C30379h.m48466d(this.czX, this.czX.getString(C25738R.string.dky, new Object[]{str2}), this.czX.getString(C25738R.string.f9238tz), this.czX.getString(C25738R.string.dl0), this.czX.getString(C25738R.string.dkz), new C158753(), new C306954());
                    }
                }
                if (i == 4 && i2 == -17 && !zuK) {
                    C18668n.ahW().mo44216lN(7);
                    zuK = true;
                }
                if (m88410ay(i, i2, c1207m.getType())) {
                    C4990ab.m7420w("MicroMsg.InitHelper", "summerinit onSceneEnd checkUpdate ret");
                    AppMethodBeat.m2505o(34487);
                    return;
                }
                if (c1207m.getType() == C33333a.CTRL_INDEX) {
                    C42011iv c42011iv = new C42011iv();
                    if (i == 3 && i2 == -1) {
                        this.zuG = true;
                        c42011iv.cDY.cCA = false;
                        C4879a.xxA.mo10055m(c42011iv);
                        this.zuL.dIn();
                    } else {
                        c42011iv.cDY.cCA = true;
                        C4879a.xxA.mo10055m(c42011iv);
                    }
                }
                if (C30784a.m49123a(this.czX, i, i2, str, 4)) {
                    AppMethodBeat.m2505o(34487);
                    return;
                }
                if (c1207m.getType() == C33333a.CTRL_INDEX) {
                    new C7306ak().post(new C1587313());
                    if ((C1853r.m3824YF() & 128) != 0) {
                        C9638aw.m17190ZK();
                        if (C18628c.m29083XR().aoZ("masssendapp") == null) {
                            C7617ak c7617ak = new C7617ak();
                            c7617ak.setUsername("masssendapp");
                            c7617ak.setContent(C4996ah.getContext().getResources().getString(C25738R.string.axn));
                            c7617ak.mo14742eD(C42252ah.anU() + FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                            c7617ak.mo14750hO(0);
                            c7617ak.mo14748hM(0);
                            C9638aw.m17190ZK();
                            C18628c.m29083XR().mo15807d(c7617ak);
                            i3 = C1853r.m3824YF() & -129;
                            C9638aw.m17190ZK();
                            C18628c.m29072Ry().set(40, Integer.valueOf(i3));
                        }
                    }
                }
                if (c1207m.getType() == 138 || c1207m.getType() == C33333a.CTRL_INDEX) {
                    C5004al.m7441d(new C362902());
                    this.zuL.dIn();
                }
                AppMethodBeat.m2505o(34487);
            } else {
                C4990ab.m7420w("MicroMsg.InitHelper", "summerinit onSceneEnd not set uin");
                AppMethodBeat.m2505o(34487);
            }
        } else if (c1207m.getType() == 113 || c1207m.getType() == 0) {
            C4990ab.m7416i("MicroMsg.InitHelper", "onSceneEnd from GetUpdateInfo, ignore it.");
            AppMethodBeat.m2505o(34487);
        } else {
            m88410ay(i, i2, c1207m.getType());
            AppMethodBeat.m2505o(34487);
        }
    }

    /* renamed from: ay */
    private boolean m88410ay(int i, int i2, int i3) {
        AppMethodBeat.m2504i(34488);
        if (C1720g.m3531RK()) {
            C9638aw.m17190ZK();
            long d = C42252ah.m74617d((Long) C18628c.m29072Ry().get(C5127a.USERINFO_UPDATE_UPDATE_FLAG_LONG, null));
            C9638aw.m17190ZK();
            long d2 = C42252ah.m74617d((Long) C18628c.m29072Ry().get(C5127a.USERINFO_UPDATE_UPDATE_TIME_LONG, null));
            C9638aw.m17190ZK();
            long d3 = C42252ah.m74617d((Long) C18628c.m29072Ry().get(C5127a.USERINFO_UPDATE_UPDATE_VERION_LONG, null));
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_UPDATE_UPDATE_FLAG_LONG, Long.valueOf(0));
            C9638aw.m17190ZK();
            C18628c.m29072Ry().set(C5127a.USERINFO_UPDATE_UPDATE_VERION_LONG, Long.valueOf(0));
            if (d3 == ((long) C7243d.vxo) && C42252ah.m74621fp(d2) < 3600) {
                if (d == 1) {
                    if (C30777u.m49121c(this.czX, 4, -17)) {
                        AppMethodBeat.m2505o(34488);
                        return true;
                    }
                } else if (d == 2 && C30777u.m49121c(this.czX, 4, -16)) {
                    AppMethodBeat.m2505o(34488);
                    return true;
                }
            }
            if (i == 4 && (i2 == -16 || i2 == -17)) {
                C4990ab.m7417i("MicroMsg.InitHelper", "trigger check update: errCode:%d, sceneType:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                if (C1947ae.gim) {
                    C4996ah.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", (C42252ah.anT() - TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) - 1).commit();
                }
                if (C30777u.m49121c(this.czX, i, i2)) {
                    AppMethodBeat.m2505o(34488);
                    return true;
                }
            }
            AppMethodBeat.m2505o(34488);
            return false;
        }
        C4990ab.m7420w("MicroMsg.InitHelper", "account not ready");
        AppMethodBeat.m2505o(34488);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final int dIP() {
        AppMethodBeat.m2504i(34489);
        if (this.zuJ == null) {
            AppMethodBeat.m2505o(34489);
            return -2;
        }
        int hashCode = this.zuJ.hashCode();
        AppMethodBeat.m2505o(34489);
        return hashCode;
    }

    public final boolean dIQ() {
        return this.zuJ != null;
    }

    /* renamed from: d */
    static /* synthetic */ boolean m88413d(C46682k c46682k) {
        AppMethodBeat.m2504i(34491);
        final che dhY = C30035i.dhY();
        if (C30035i.dhZ() && dhY != null) {
            C9638aw.m17180RS().mo10302aa(new Runnable() {

                /* renamed from: com.tencent.mm.ui.conversation.k$5$1 */
                class C54871 implements Runnable {

                    /* renamed from: com.tencent.mm.ui.conversation.k$5$1$1 */
                    class C54881 implements OnClickListener {
                        C54881() {
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(34466);
                            C35800q.m58698a(C46682k.this.czX, new File(dhY.xga), null, false);
                            C7060h.pYm.mo8378a(614, 50, 1, false);
                            dialogInterface.dismiss();
                            AppMethodBeat.m2505o(34466);
                        }
                    }

                    /* renamed from: com.tencent.mm.ui.conversation.k$5$1$2 */
                    class C54892 implements OnClickListener {
                        C54892() {
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            AppMethodBeat.m2504i(34467);
                            C7060h.pYm.mo8378a(614, 57, 1, false);
                            dialogInterface.dismiss();
                            AppMethodBeat.m2505o(34467);
                        }
                    }

                    C54871() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(34468);
                        if (C46682k.this.zuE == null || !C46682k.this.zuE.isShowing()) {
                            C7060h.pYm.mo8378a(614, 60, 1, false);
                            C46682k.this.zuE = C30379h.m48445a(C46682k.this.czX, dhY.bzH, dhY.title, dhY.xgb, dhY.nna, false, new C54881(), new C54892());
                            C30035i.dia();
                            AppMethodBeat.m2505o(34468);
                            return;
                        }
                        C4990ab.m7416i("MicroMsg.InitHelper", "update dialog is showing.");
                        AppMethodBeat.m2505o(34468);
                    }
                }

                /* renamed from: com.tencent.mm.ui.conversation.k$5$2 */
                class C362922 implements Runnable {
                    C362922() {
                    }

                    public final void run() {
                        C1898c adg;
                        AppMethodBeat.m2504i(34469);
                        C4990ab.m7417i("MicroMsg.InitHelper", "path:%s,apkMd5:%s", dhY.xga, dhY.nun);
                        try {
                            adg = C9638aw.m17182Rg().ftA.adg();
                        } catch (Throwable th) {
                            C4990ab.printErrStackTrace("MicroMsg.InitHelper", th, "", new Object[0]);
                            adg = null;
                        }
                        if (adg == null) {
                            AppMethodBeat.m2505o(34469);
                            return;
                        }
                        String substring = dhY.nuk.substring(0, dhY.nuk.lastIndexOf(47) + 1);
                        String substring2 = dhY.nuk.substring(dhY.nuk.lastIndexOf(47) + 1);
                        C41914i c41914i = new C41914i(substring, dhY.versionCode);
                        c41914i.mo67557a(new C32431a(dhY.nuo, dhY.nun, dhY.cdy, substring2, dhY.iCm));
                        Intent intent = new Intent();
                        intent.putExtra("intent_short_ips", C30035i.getShortIps());
                        intent.putExtra("intent_client_version", C7243d.vxo);
                        intent.putExtra("intent_extra_session", adg.mo5490jQ(1));
                        intent.putExtra("intent_extra_cookie", adg.ada());
                        intent.putExtra("intent_extra_ecdhkey", adg.adc());
                        intent.putExtra("intent_extra_uin", adg.mo5480QF());
                        intent.putExtra("intent_update_type", 3);
                        intent.putExtra("intent_extra_desc", dhY.bzH);
                        intent.putExtra("intent_extra_md5", dhY.cdy);
                        intent.putExtra("intent_extra_size", dhY.iCm);
                        intent.putExtra("intent_extra_download_url", new String[]{dhY.nuk});
                        intent.putExtra("intent_extra_patchInfo", c41914i.mo67556AM());
                        intent.putExtra("intent_extra_updateMode", C5059g.cdh);
                        intent.putExtra("intent_extra_marketUrl", C5059g.xyc);
                        intent.putExtra("intent_extra_extinfo", "<extinfo></extinfo>");
                        intent.putExtra("intent_extra_tinker_patch", true);
                        intent.putExtra("intent_extra_download_mode", 1);
                        C21429d.bQU().mo36885y(C46682k.this.czX, intent);
                        C30035i.dia();
                        AppMethodBeat.m2505o(34469);
                    }
                }

                public final void run() {
                    AppMethodBeat.m2504i(34470);
                    if (dhY != null && dhY.nuo.equalsIgnoreCase(C30035i.m47538fN(C4996ah.getContext()))) {
                        if (C5730e.m8628ct(dhY.xga) && C32429a.m53087cM(dhY.xga)) {
                            C5004al.m7441d(new C54871());
                            AppMethodBeat.m2505o(34470);
                            return;
                        }
                        C5004al.m7441d(new C362922());
                    }
                    AppMethodBeat.m2505o(34470);
                }
            });
            C4990ab.m7416i("MicroMsg.InitHelper", "have tinker update.");
            AppMethodBeat.m2505o(34491);
            return true;
        } else if (C30777u.m49122ht(c46682k.czX)) {
            C7060h.pYm.mo8378a(405, 41, 1, true);
            C4990ab.m7410d("MicroMsg.InitHelper", "we got a install");
            AppMethodBeat.m2505o(34491);
            return true;
        } else if (C30777u.m49119as(c46682k.czX)) {
            C4990ab.m7410d("MicroMsg.InitHelper", "we got an unfinished silence download");
            AppMethodBeat.m2505o(34491);
            return true;
        } else {
            AppMethodBeat.m2505o(34491);
            return false;
        }
    }
}
