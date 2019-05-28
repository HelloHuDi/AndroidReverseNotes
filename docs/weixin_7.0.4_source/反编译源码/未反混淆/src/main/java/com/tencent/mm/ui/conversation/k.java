package com.tencent.mm.ui.conversation;

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
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.g;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.go;
import com.tencent.mm.g.a.iv;
import com.tencent.mm.g.a.my;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.modelmulti.e;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.dbbackup.DBRecoveryUI;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.f.i;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.FLock;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.u;
import com.tencent.mm.ui.widget.a.c;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.io.File;
import java.lang.ref.WeakReference;

public final class k implements f, g {
    private static boolean zuK = false;
    Activity czX;
    ProgressDialog ehJ = null;
    WeakReference<Activity> gWO;
    WakeLock wakeLock = null;
    private c zuE = null;
    private c zuF = null;
    private boolean zuG = false;
    private com.tencent.mm.compatible.util.g.a zuH = new com.tencent.mm.compatible.util.g.a();
    boolean zuI = false;
    private e zuJ = null;
    a zuL;
    a zuM;
    com.tencent.mm.sdk.b.c zuN = new com.tencent.mm.sdk.b.c<my>() {
        {
            AppMethodBeat.i(34461);
            this.xxI = my.class.getName().hashCode();
            AppMethodBeat.o(34461);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(34462);
            ((my) bVar).cIV.cIW = k.this.dIQ();
            AppMethodBeat.o(34462);
            return false;
        }
    };
    com.tencent.mm.sdk.b.c zuO = new com.tencent.mm.sdk.b.c<tl>() {
        {
            AppMethodBeat.i(34471);
            this.xxI = tl.class.getName().hashCode();
            AppMethodBeat.o(34471);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(34472);
            if (k.this.czX == null) {
                ab.i("MicroMsg.InitHelper", "inithelper hasn't initialized");
                AppMethodBeat.o(34472);
            } else {
                k.this.zuG = false;
                k.c(k.this);
                AppMethodBeat.o(34472);
            }
            return false;
        }
    };
    FLock zuP;

    public interface a {
        void dIR();

        void dIS();
    }

    public k() {
        AppMethodBeat.i(34483);
        AppMethodBeat.o(34483);
    }

    static /* synthetic */ void c(k kVar) {
        AppMethodBeat.i(34490);
        kVar.dIO();
        AppMethodBeat.o(34490);
    }

    /* Access modifiers changed, original: final */
    public final boolean dIN() {
        AppMethodBeat.i(34484);
        if (!com.tencent.mm.modelmulti.k.ahT()) {
            AppMethodBeat.o(34484);
            return false;
        } else if (this.zuF == null || !this.zuF.isShowing()) {
            com.tencent.mm.kernel.g.RQ();
            if (com.tencent.mm.kernel.g.RP().Rr()) {
                this.zuF = new com.tencent.mm.ui.widget.a.c.a(this.czX).PV(R.string.b4r).asE(this.czX.getString(R.string.b4q)).rc(false).Qc(R.string.b4s).a(new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(34477);
                        k.this.zuF.dismiss();
                        Intent intent = new Intent(k.this.czX, DBRecoveryUI.class);
                        intent.putExtra("scene", 0);
                        k.this.czX.startActivity(intent);
                        AppMethodBeat.o(34477);
                    }
                }).Qd(R.string.b4p).b(new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(34476);
                        com.tencent.mm.kernel.g.RS().aa(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(34474);
                                z Ry = com.tencent.mm.kernel.g.RP().Ry();
                                Ry.set(89, Integer.valueOf(2));
                                Ry.dsb();
                                AppMethodBeat.o(34474);
                            }
                        });
                        k.this.zuF.dismiss();
                        h.a(k.this.czX, (int) R.string.b4b, (int) R.string.tz, false, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(34475);
                                k.c(k.this);
                                AppMethodBeat.o(34475);
                            }
                        });
                        AppMethodBeat.o(34476);
                    }
                }).aMb();
                this.zuF.show();
            } else {
                dIO();
            }
            AppMethodBeat.o(34484);
            return true;
        } else {
            AppMethodBeat.o(34484);
            return false;
        }
    }

    private void dIO() {
        AppMethodBeat.i(34485);
        if (this.zuG) {
            ab.i("MicroMsg.InitHelper", "summerinit doPreCreate but hasTryDoInitButFailed true ret");
            AppMethodBeat.o(34485);
            return;
        }
        if (!this.wakeLock.isHeld()) {
            ab.w("MicroMsg.InitHelper", "tryDoInit wakelock.acquire!");
            this.wakeLock.acquire();
        }
        this.zuM.dIR();
        if (this.zuJ == null) {
            if (n.qFy != null) {
                n.qFy.cmk();
            }
            this.zuJ = new e(this);
            ab.d("MicroMsg.InitHelper", "dkinit doPreCreate t:%d initScene:%d", Long.valueOf(this.zuH.Mr()), Integer.valueOf(this.zuJ.hashCode()));
            this.zuH.evE = SystemClock.elapsedRealtime();
            aw.Rg().a(this.zuJ, 0);
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(34479);
                String str = "MicroMsg.InitHelper";
                String str2 = "dkinit showProgressDlg t:%d initScene:%d";
                Object[] objArr = new Object[2];
                objArr[0] = Long.valueOf(k.this.zuH.Mr());
                objArr[1] = Integer.valueOf(k.this.zuJ == null ? -2 : k.this.zuJ.hashCode());
                ab.d(str, str2, objArr);
                if (k.this.ehJ != null && k.this.ehJ.isShowing()) {
                    k.this.ehJ.dismiss();
                }
                k kVar = k.this;
                Context a = k.this.czX;
                k.this.czX.getString(R.string.tz);
                kVar.ehJ = h.b(a, k.this.czX.getString(R.string.re), false, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(34478);
                        aw.Rg().c(k.this.zuJ);
                        if (n.qFy != null) {
                            n.qFy.cml();
                        }
                        AppMethodBeat.o(34478);
                    }
                });
                aw.RS().Bn();
                AppMethodBeat.o(34479);
            }
        });
        AppMethodBeat.o(34485);
    }

    public final void a(int i, int i2, m mVar) {
        AppMethodBeat.i(34486);
        if (mVar == null || mVar.getType() != com.tencent.mm.plugin.appbrand.jsapi.k.a.CTRL_INDEX) {
            AppMethodBeat.o(34486);
            return;
        }
        final int i3 = (int) (i2 != 0 ? (((long) i) * 100) / ((long) i2) : 0);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(34480);
                if (k.this.ehJ != null) {
                    k.this.ehJ.setMessage(k.this.czX.getString(R.string.re) + i3 + "%");
                }
                AppMethodBeat.o(34480);
            }
        });
        AppMethodBeat.o(34486);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x01be  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(34487);
        if (mVar.getType() == 138 || mVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.k.a.CTRL_INDEX) {
            int i3;
            String str2 = "MicroMsg.InitHelper";
            String str3 = "dkinit onSceneEnd:[%d,%d,%s] type:%d hash:%d init:%d ";
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(i);
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = str;
            objArr[3] = Integer.valueOf(mVar.getType());
            objArr[4] = Integer.valueOf(hashCode());
            if (this.zuJ == null) {
                i3 = -2;
            } else {
                i3 = this.zuJ.hashCode();
            }
            objArr[5] = Integer.valueOf(i3);
            ab.i(str2, str3, objArr);
            if (this.zuJ != null && mVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.k.a.CTRL_INDEX) {
                this.zuJ = null;
                ab.w("MicroMsg.InitHelper", "summerinit dkinit Kevin init FINISH : %d ", Long.valueOf(this.zuH.Mr()));
                com.tencent.mm.model.ao.a.flu.a(null, null, null);
                if (n.qFy != null) {
                    n.qFy.cml();
                }
                this.zuM.dIS();
                if (this.wakeLock.isHeld()) {
                    ab.w("MicroMsg.InitHelper", "onSceneEnd wakelock.release!");
                    this.wakeLock.release();
                }
                aw.RS().doM();
                if (this.ehJ != null) {
                    this.ehJ.dismiss();
                    this.ehJ = null;
                }
                final Activity activity = (Activity) this.gWO.get();
                if (com.tencent.mm.kernel.g.RK() && com.tencent.mm.kernel.g.RN().eJb && activity != null && !this.czX.getSharedPreferences(ah.doA() + "_fontScaleTip", 0).getBoolean("font_scale_tip_login", false)) {
                    if (1.0f != com.tencent.mm.bz.a.dm(this.czX)) {
                        this.czX.getSharedPreferences(ah.doA() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip_login", true).apply();
                        i3 = 1;
                    } else if (1.0f != this.czX.getResources().getConfiguration().fontScale) {
                        com.tencent.mm.plugin.report.service.h.pYm.e(15181, Integer.valueOf(1));
                        com.tencent.mm.ui.widget.a.e.a aVar = new com.tencent.mm.ui.widget.a.e.a(activity);
                        com.tencent.mm.ui.widget.a.e.a asL = aVar.al(activity.getResources().getString(R.string.bz9)).asL(activity.getResources().getString(R.string.bz6));
                        asL.zQJ = activity.getResources().getString(R.string.bz8);
                        asL.zQK = activity.getResources().getString(R.string.bz7);
                        aVar.c(new com.tencent.mm.ui.widget.a.e.c() {
                            public final void d(boolean z, String str) {
                                AppMethodBeat.i(34481);
                                if (z) {
                                    com.tencent.mm.plugin.report.service.h.pYm.e(15181, Integer.valueOf(3));
                                    Intent intent = new Intent();
                                    intent.setClassName(ah.getPackageName(), "com.tencent.mm.plugin.setting.ui.setting.SettingsFontUI");
                                    activity.startActivity(intent);
                                    AppMethodBeat.o(34481);
                                    return;
                                }
                                com.tencent.mm.plugin.report.service.h.pYm.e(15181, Integer.valueOf(2));
                                AppMethodBeat.o(34481);
                            }
                        }).show();
                        this.czX.getSharedPreferences(ah.doA() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip_login", true).apply();
                        i3 = 1;
                    }
                    if (i3 == 0) {
                        this.czX.getSharedPreferences(ah.doA() + "_fontScaleTip", 0).edit().putBoolean("font_scale_tip", false).apply();
                    }
                }
                i3 = 0;
                if (i3 == 0) {
                }
            }
            if (u.a(this.czX, i, i2, new Intent().setClass(this.czX, LauncherUI.class).putExtra("Intro_Switch", true).putExtra("animation_pop_in", true).addFlags(67108864), str)) {
                ab.i("MicroMsg.InitHelper", "summerinit onSceneEnd accountExpired ret");
                AppMethodBeat.o(34487);
            } else if (aw.RK()) {
                if (!this.zuI) {
                    this.zuI = true;
                    aw.ZK();
                    str2 = (String) com.tencent.mm.model.c.Ry().get(5, null);
                    aw.ZK();
                    if (!((((Integer) com.tencent.mm.model.c.Ry().get(57, Integer.valueOf(0))).intValue() != 0 ? 1 : 0) == 0 || str2 == null)) {
                        h.d(this.czX, this.czX.getString(R.string.dky, new Object[]{str2}), this.czX.getString(R.string.tz), this.czX.getString(R.string.dl0), this.czX.getString(R.string.dkz), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(34464);
                                Intent intent = new Intent();
                                intent.setClassName(k.this.czX, "com.tencent.mm.plugin.account.ui.RegByFacebookSetPwdUI");
                                k.this.czX.startActivity(intent);
                                AppMethodBeat.o(34464);
                            }
                        }, new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                AppMethodBeat.i(34465);
                                dialogInterface.dismiss();
                                AppMethodBeat.o(34465);
                            }
                        });
                    }
                }
                if (i == 4 && i2 == -17 && !zuK) {
                    com.tencent.mm.modelmulti.n.ahW().lN(7);
                    zuK = true;
                }
                if (ay(i, i2, mVar.getType())) {
                    ab.w("MicroMsg.InitHelper", "summerinit onSceneEnd checkUpdate ret");
                    AppMethodBeat.o(34487);
                    return;
                }
                if (mVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.k.a.CTRL_INDEX) {
                    iv ivVar = new iv();
                    if (i == 3 && i2 == -1) {
                        this.zuG = true;
                        ivVar.cDY.cCA = false;
                        com.tencent.mm.sdk.b.a.xxA.m(ivVar);
                        this.zuL.dIn();
                    } else {
                        ivVar.cDY.cCA = true;
                        com.tencent.mm.sdk.b.a.xxA.m(ivVar);
                    }
                }
                if (com.tencent.mm.ui.u.a.a(this.czX, i, i2, str, 4)) {
                    AppMethodBeat.o(34487);
                    return;
                }
                if (mVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.k.a.CTRL_INDEX) {
                    new ak().post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(34482);
                            com.tencent.mm.modelmulti.n.ahW().lN(5);
                            AppMethodBeat.o(34482);
                        }
                    });
                    if ((r.YF() & 128) != 0) {
                        aw.ZK();
                        if (com.tencent.mm.model.c.XR().aoZ("masssendapp") == null) {
                            com.tencent.mm.storage.ak akVar = new com.tencent.mm.storage.ak();
                            akVar.setUsername("masssendapp");
                            akVar.setContent(ah.getContext().getResources().getString(R.string.axn));
                            akVar.eD(com.tencent.mm.platformtools.ah.anU() + FaceGestureDetGLThread.BRIGHTNESS_DURATION);
                            akVar.hO(0);
                            akVar.hM(0);
                            aw.ZK();
                            com.tencent.mm.model.c.XR().d(akVar);
                            i3 = r.YF() & -129;
                            aw.ZK();
                            com.tencent.mm.model.c.Ry().set(40, Integer.valueOf(i3));
                        }
                    }
                }
                if (mVar.getType() == 138 || mVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.k.a.CTRL_INDEX) {
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(34463);
                            go goVar = new go();
                            goVar.cBl.data = "MAIN_UI_EVENT_INIT_FINALLY";
                            com.tencent.mm.sdk.b.a.xxA.m(goVar);
                            AppMethodBeat.o(34463);
                        }
                    });
                    this.zuL.dIn();
                }
                AppMethodBeat.o(34487);
            } else {
                ab.w("MicroMsg.InitHelper", "summerinit onSceneEnd not set uin");
                AppMethodBeat.o(34487);
            }
        } else if (mVar.getType() == 113 || mVar.getType() == 0) {
            ab.i("MicroMsg.InitHelper", "onSceneEnd from GetUpdateInfo, ignore it.");
            AppMethodBeat.o(34487);
        } else {
            ay(i, i2, mVar.getType());
            AppMethodBeat.o(34487);
        }
    }

    private boolean ay(int i, int i2, int i3) {
        AppMethodBeat.i(34488);
        if (com.tencent.mm.kernel.g.RK()) {
            aw.ZK();
            long d = com.tencent.mm.platformtools.ah.d((Long) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_UPDATE_UPDATE_FLAG_LONG, null));
            aw.ZK();
            long d2 = com.tencent.mm.platformtools.ah.d((Long) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_UPDATE_UPDATE_TIME_LONG, null));
            aw.ZK();
            long d3 = com.tencent.mm.platformtools.ah.d((Long) com.tencent.mm.model.c.Ry().get(com.tencent.mm.storage.ac.a.USERINFO_UPDATE_UPDATE_VERION_LONG, null));
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_UPDATE_UPDATE_FLAG_LONG, Long.valueOf(0));
            aw.ZK();
            com.tencent.mm.model.c.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_UPDATE_UPDATE_VERION_LONG, Long.valueOf(0));
            if (d3 == ((long) d.vxo) && com.tencent.mm.platformtools.ah.fp(d2) < 3600) {
                if (d == 1) {
                    if (u.c(this.czX, 4, -17)) {
                        AppMethodBeat.o(34488);
                        return true;
                    }
                } else if (d == 2 && u.c(this.czX, 4, -16)) {
                    AppMethodBeat.o(34488);
                    return true;
                }
            }
            if (i == 4 && (i2 == -16 || i2 == -17)) {
                ab.i("MicroMsg.InitHelper", "trigger check update: errCode:%d, sceneType:%d", Integer.valueOf(i2), Integer.valueOf(i3));
                if (ae.gim) {
                    ah.getContext().getSharedPreferences("system_config_prefs", 0).edit().putLong("recomended_update_ignore", (com.tencent.mm.platformtools.ah.anT() - TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) - 1).commit();
                }
                if (u.c(this.czX, i, i2)) {
                    AppMethodBeat.o(34488);
                    return true;
                }
            }
            AppMethodBeat.o(34488);
            return false;
        }
        ab.w("MicroMsg.InitHelper", "account not ready");
        AppMethodBeat.o(34488);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final int dIP() {
        AppMethodBeat.i(34489);
        if (this.zuJ == null) {
            AppMethodBeat.o(34489);
            return -2;
        }
        int hashCode = this.zuJ.hashCode();
        AppMethodBeat.o(34489);
        return hashCode;
    }

    public final boolean dIQ() {
        return this.zuJ != null;
    }

    static /* synthetic */ boolean d(k kVar) {
        AppMethodBeat.i(34491);
        final che dhY = i.dhY();
        if (i.dhZ() && dhY != null) {
            aw.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(34470);
                    if (dhY != null && dhY.nuo.equalsIgnoreCase(i.fN(ah.getContext()))) {
                        if (com.tencent.mm.vfs.e.ct(dhY.xga) && com.tencent.mm.c.a.cM(dhY.xga)) {
                            al.d(new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(34468);
                                    if (k.this.zuE == null || !k.this.zuE.isShowing()) {
                                        com.tencent.mm.plugin.report.service.h.pYm.a(614, 60, 1, false);
                                        k.this.zuE = h.a(k.this.czX, dhY.bzH, dhY.title, dhY.xgb, dhY.nna, false, new OnClickListener() {
                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                AppMethodBeat.i(34466);
                                                q.a(k.this.czX, new File(dhY.xga), null, false);
                                                com.tencent.mm.plugin.report.service.h.pYm.a(614, 50, 1, false);
                                                dialogInterface.dismiss();
                                                AppMethodBeat.o(34466);
                                            }
                                        }, new OnClickListener() {
                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                AppMethodBeat.i(34467);
                                                com.tencent.mm.plugin.report.service.h.pYm.a(614, 57, 1, false);
                                                dialogInterface.dismiss();
                                                AppMethodBeat.o(34467);
                                            }
                                        });
                                        i.dia();
                                        AppMethodBeat.o(34468);
                                        return;
                                    }
                                    ab.i("MicroMsg.InitHelper", "update dialog is showing.");
                                    AppMethodBeat.o(34468);
                                }
                            });
                            AppMethodBeat.o(34470);
                            return;
                        }
                        al.d(new Runnable() {
                            public final void run() {
                                com.tencent.mm.network.c adg;
                                AppMethodBeat.i(34469);
                                ab.i("MicroMsg.InitHelper", "path:%s,apkMd5:%s", dhY.xga, dhY.nun);
                                try {
                                    adg = aw.Rg().ftA.adg();
                                } catch (Throwable th) {
                                    ab.printErrStackTrace("MicroMsg.InitHelper", th, "", new Object[0]);
                                    adg = null;
                                }
                                if (adg == null) {
                                    AppMethodBeat.o(34469);
                                    return;
                                }
                                String substring = dhY.nuk.substring(0, dhY.nuk.lastIndexOf(47) + 1);
                                String substring2 = dhY.nuk.substring(dhY.nuk.lastIndexOf(47) + 1);
                                com.tencent.mm.c.i iVar = new com.tencent.mm.c.i(substring, dhY.versionCode);
                                iVar.a(new com.tencent.mm.c.i.a(dhY.nuo, dhY.nun, dhY.cdy, substring2, dhY.iCm));
                                Intent intent = new Intent();
                                intent.putExtra("intent_short_ips", i.getShortIps());
                                intent.putExtra("intent_client_version", d.vxo);
                                intent.putExtra("intent_extra_session", adg.jQ(1));
                                intent.putExtra("intent_extra_cookie", adg.ada());
                                intent.putExtra("intent_extra_ecdhkey", adg.adc());
                                intent.putExtra("intent_extra_uin", adg.QF());
                                intent.putExtra("intent_update_type", 3);
                                intent.putExtra("intent_extra_desc", dhY.bzH);
                                intent.putExtra("intent_extra_md5", dhY.cdy);
                                intent.putExtra("intent_extra_size", dhY.iCm);
                                intent.putExtra("intent_extra_download_url", new String[]{dhY.nuk});
                                intent.putExtra("intent_extra_patchInfo", iVar.AM());
                                intent.putExtra("intent_extra_updateMode", com.tencent.mm.sdk.platformtools.g.cdh);
                                intent.putExtra("intent_extra_marketUrl", com.tencent.mm.sdk.platformtools.g.xyc);
                                intent.putExtra("intent_extra_extinfo", "<extinfo></extinfo>");
                                intent.putExtra("intent_extra_tinker_patch", true);
                                intent.putExtra("intent_extra_download_mode", 1);
                                com.tencent.mm.plugin.p.d.bQU().y(k.this.czX, intent);
                                i.dia();
                                AppMethodBeat.o(34469);
                            }
                        });
                    }
                    AppMethodBeat.o(34470);
                }
            });
            ab.i("MicroMsg.InitHelper", "have tinker update.");
            AppMethodBeat.o(34491);
            return true;
        } else if (u.ht(kVar.czX)) {
            com.tencent.mm.plugin.report.service.h.pYm.a(405, 41, 1, true);
            ab.d("MicroMsg.InitHelper", "we got a install");
            AppMethodBeat.o(34491);
            return true;
        } else if (u.as(kVar.czX)) {
            ab.d("MicroMsg.InitHelper", "we got an unfinished silence download");
            AppMethodBeat.o(34491);
            return true;
        } else {
            AppMethodBeat.o(34491);
            return false;
        }
    }
}
