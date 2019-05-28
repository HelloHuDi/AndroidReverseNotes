package com.tencent.mm.plugin.hp.b;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Process;
import android.support.v4.app.v;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.modelmulti.l;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.k;
import com.tencent.mm.plugin.hp.d.b;
import com.tencent.mm.plugin.hp.d.c;
import com.tencent.mm.plugin.hp.tinker.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tinker.lib.util.a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

public final class e implements k {
    final b ntI;
    private long ntJ;

    public e(b bVar) {
        AppMethodBeat.i(90596);
        this.ntI = bVar;
        d.bij();
        com.tencent.mm.plugin.downloader.model.b.a(this);
        AppMethodBeat.o(90596);
    }

    /* renamed from: if */
    public final boolean m5if(boolean z) {
        boolean z2;
        AppMethodBeat.i(90597);
        a.i("Tinker.SyncResponseProcessor", "process tinker response: %s", this.ntI.toString());
        b bVar = this.ntI;
        if (bVar.nug.intValue() > 4 || bVar.nug.intValue() <= 0) {
            ab.e("Tinker.TinkerSyncResponse", "responseState: %d must between %d and %d", bVar.nug, Integer.valueOf(1), Integer.valueOf(4));
            h.pYm.a(614, 24, 1, false);
            z2 = false;
        } else {
            if (bVar.bGv()) {
                if (TextUtils.isEmpty(bVar.num)) {
                    ab.e("Tinker.TinkerSyncResponse", "sync response patchId should not be null");
                    h.pYm.a(614, 25, 1, false);
                    z2 = false;
                } else if (TextUtils.isEmpty(bVar.nuk)) {
                    ab.e("Tinker.TinkerSyncResponse", "sync response cdnUrl should not be null");
                    h.pYm.a(614, 26, 1, false);
                    z2 = false;
                } else if (TextUtils.isEmpty(bVar.nul)) {
                    ab.e("Tinker.TinkerSyncResponse", "sync response fileMd5 should not be null");
                    h.pYm.a(614, 27, 1, false);
                    z2 = false;
                }
            }
            z2 = true;
        }
        if (z2) {
            int i;
            if (this.ntI.nug.intValue() == 3) {
                i = 1;
            } else {
                z2 = false;
            }
            if (i != 0) {
                final Context context = ah.getContext();
                final com.tencent.tinker.lib.e.a iX = com.tencent.tinker.lib.e.a.iX(context);
                if (iX.ABK) {
                    a.i("Tinker.SyncResponseProcessor", "tinker wait screen to clean patch and kill all process", new Object[0]);
                    l lVar = new l(ah.getContext(), new l.a() {
                        public final void cO(boolean z) {
                            AppMethodBeat.i(90595);
                            if (!z) {
                                a.i("Tinker.SyncResponseProcessor", "app is background now, i can kill quietly", new Object[0]);
                                ShareTinkerInternals.jr(context);
                                iX.bGr();
                                Process.killProcess(Process.myPid());
                            }
                            AppMethodBeat.o(90595);
                        }
                    });
                    SharePatchInfo.a(iX.ABG, new SharePatchInfo(iX.ABJ.ABO, "00000000000000000000000000000000", true, Build.FINGERPRINT, "odex"), iX.ABH);
                } else {
                    a.w("Tinker.SyncResponseProcessor", "SyncResponseProcessor: onPatchRollback, tinker is not loaded, just return", new Object[0]);
                }
                AppMethodBeat.o(90597);
                return true;
            } else if (!this.ntI.bGv()) {
                AppMethodBeat.o(90597);
                return true;
            } else if (this.ntI.bGy()) {
                a.w("Tinker.SyncResponseProcessor", "is lower version skip.", new Object[0]);
                h.pYm.a(614, 78, 1, false);
                AppMethodBeat.o(90597);
                return true;
            } else if (com.tencent.mm.sdk.a.b.dnR()) {
                a.w("Tinker.SyncResponseProcessor", "[tomys] patch downloading is blocked by assist.", new Object[0]);
                AppMethodBeat.o(90597);
                return true;
            } else if (this.ntI.nui.intValue() == 3 && !bo.isNullOrNil(this.ntI.clientVersion) && c.OH(this.ntI.clientVersion)) {
                h.pYm.a(614, 77, 1, false);
                b bVar2 = this.ntI;
                Context context2 = ah.getContext();
                CharSequence string = bo.isNullOrNil(bVar2.nup) ? context2.getString(R.string.t4) : bVar2.nup;
                CharSequence charSequence = bo.isNullOrNil(bVar2.nuq) ? "" : bVar2.nuq;
                String str = bo.isNullOrNil(bVar2.nur) ? "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index" : bVar2.nur;
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setClassName(ah.getPackageName(), ah.getPackageName() + ".plugin.webview.ui.tools.WebViewUI");
                intent.putExtra("rawUrl", str);
                intent.putExtra("useJs", true);
                intent.putExtra("vertical_scroll", true);
                intent.setFlags(872415232);
                PendingIntent activity = PendingIntent.getActivity(context2, 0, intent, 268435456);
                v.c e = com.tencent.mm.bo.a.bt(context2, "reminder_channel_id").g(null).j(System.currentTimeMillis()).d(string).e(charSequence);
                e.EI = activity;
                e.as(com.tencent.mm.bo.a.bWV());
                Notification build = e.build();
                build.flags |= 16;
                if (z) {
                    ((NotificationManager) context2.getSystemService("notification")).notify(19841110, build);
                } else {
                    ab.i("Tinker.SyncResponseProcessor", "ignore action when load from cache,when response is alpha version");
                }
                AppMethodBeat.o(90597);
                return true;
            } else {
                a.i("Tinker.SyncResponseProcessor", "check need show before download. network type:%d msg:%s", this.ntI.nuj, this.ntI.bGx());
                final Context context3 = ah.getContext();
                if (this.ntI.nuj.intValue() == 2 && at.isMobile(ah.getContext()) && this.ntI.bGw()) {
                    if (g.az(context3, this.ntI.num)) {
                        h.pYm.a(614, 44, 1, false);
                        ab.i("Tinker.SyncResponseProcessor", "this patch id :%s show cancel before user, need show again.", this.ntI.num);
                    } else {
                        if (this.ntI.nui.intValue() == 2) {
                            i.a(ah.getContext().getString(R.string.byv), ah.getContext().getString(R.string.byx, new Object[]{this.ntI.bGx(), ah.getContext().getString(R.string.eyx), bo.ga((long) this.ntI.fileSize)}), ah.getContext().getString(R.string.ez1), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(90593);
                                    if (e.this.ntI.bGu()) {
                                        e.this.bGk();
                                    }
                                    AppMethodBeat.o(90593);
                                }
                            }, ah.getContext().getString(R.string.eyp), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.i(90594);
                                    g.aA(context3, e.this.ntI.num);
                                    AppMethodBeat.o(90594);
                                }
                            });
                        } else if (this.ntI.nui.intValue() == 3) {
                            String string2;
                            ab.d("Tinker.SyncResponseProcessor", "showUpdateDialog ");
                            if (bo.isNullOrNil(this.ntI.bGx())) {
                                string2 = context3.getString(R.string.ez8);
                            } else {
                                string2 = this.ntI.bGx();
                            }
                            che che = new che();
                            che.num = this.ntI.num;
                            che.title = context3.getString(R.string.byv);
                            che.xgb = context3.getString(R.string.ez1);
                            che.nna = context3.getString(R.string.eyp);
                            che.nun = this.ntI.nun;
                            che.nuo = this.ntI.nuo;
                            che.iCm = this.ntI.fileSize;
                            che.nuk = this.ntI.nuk;
                            che.cdy = this.ntI.nul;
                            che.versionCode = this.ntI.versionCode;
                            che.xga = com.tencent.mm.plugin.hp.d.d.OJ(this.ntI.nun);
                            che.bzH = string2;
                            com.tencent.mm.plugin.hp.d.d.a(che);
                        }
                        a.wV(4);
                    }
                } else if (this.ntI.bGu() && !g.az(context3, this.ntI.num)) {
                    bGk();
                }
                AppMethodBeat.o(90597);
                return true;
            }
        }
        a.i("Tinker.SyncResponseProcessor", "process check response fail, just return", new Object[0]);
        AppMethodBeat.o(90597);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void bGk() {
        AppMethodBeat.i(90598);
        if (!com.tencent.mm.compatible.util.h.getExternalStorageState().equals("mounted")) {
            ab.e("Tinker.SyncResponseProcessor", "no sdcard.");
            h.pYm.a(614, 50, 1, false);
            AppMethodBeat.o(90598);
        } else if (!f.eW((long) this.ntI.fileSize)) {
            ab.e("Tinker.SyncResponseProcessor", "sdcard is full.");
            h.pYm.a(614, 51, 1, false);
            if (this.ntI.nui.intValue() == 3) {
                h.pYm.a(614, 55, 1, false);
            }
            AppMethodBeat.o(90598);
        } else if (this.ntI.nui.intValue() == 3 && !bo.isNullOrNil(this.ntI.nun) && com.tencent.mm.a.e.ct(com.tencent.mm.plugin.hp.d.d.OJ(this.ntI.nun)) && com.tencent.mm.c.a.cM(com.tencent.mm.plugin.hp.d.d.OJ(this.ntI.nun))) {
            String string;
            Context context = ah.getContext();
            if (bo.isNullOrNil(this.ntI.bGx())) {
                string = context.getString(R.string.ez8);
            } else {
                string = this.ntI.bGx();
            }
            che che = new che();
            che.num = this.ntI.num;
            che.title = context.getString(R.string.byv);
            che.xgb = context.getString(R.string.cdx);
            che.nna = context.getString(R.string.eyp);
            che.nun = this.ntI.nun;
            che.nuo = this.ntI.nuo;
            che.iCm = this.ntI.fileSize;
            che.nuk = this.ntI.nuk;
            che.cdy = this.ntI.nul;
            che.versionCode = this.ntI.versionCode;
            che.xga = com.tencent.mm.plugin.hp.d.d.OJ(this.ntI.nun);
            che.bzH = string;
            com.tencent.mm.plugin.hp.d.d.a(che);
            ab.i("Tinker.SyncResponseProcessor", "file is exist. need no to download. newApkMd5:%s", this.ntI.nun);
            AppMethodBeat.o(90598);
        } else {
            this.ntI.nui.intValue();
            bGl();
            AppMethodBeat.o(90598);
        }
    }

    private void bGl() {
        AppMethodBeat.i(90599);
        ah.getContext();
        com.tencent.mm.plugin.hp.d.d.bGA();
        com.tencent.mm.plugin.hp.d.d.bGB();
        com.tencent.mm.plugin.downloader.model.e.a aVar = new com.tencent.mm.plugin.downloader.model.e.a();
        aVar.It(this.ntI.nuk);
        aVar.Iv(this.ntI.num);
        aVar.Iw(this.ntI.nul);
        aVar.ga(false);
        aVar.bir();
        aVar.tN(2);
        aVar.gb(false);
        this.ntJ = d.bij().a(aVar.kNl);
        ab.i("Tinker.SyncResponseProcessor", "Download task id is :%d", Long.valueOf(this.ntJ));
        h.pYm.a(614, 2, 1, false);
        if (at.isWifi(ah.getContext())) {
            h.pYm.a(614, 7, 1, false);
        } else {
            h.pYm.a(614, 8, 1, false);
        }
        if (this.ntI.nui.intValue() == 3) {
            h.pYm.a(614, 56, 1, false);
            ab.d("Tinker.SyncResponseProcessor", "boots download start silent.");
        }
        AppMethodBeat.o(90599);
    }

    public final void onTaskStarted(long j, String str) {
        AppMethodBeat.i(90600);
        ab.d("Tinker.SyncResponseProcessor", "onTaskStarted taskId %d", Long.valueOf(j));
        AppMethodBeat.o(90600);
    }

    public final void b(long j, String str, boolean z) {
        AppMethodBeat.i(90601);
        ab.i("Tinker.SyncResponseProcessor", "onTaskFinished id:%d path:%s hasChangeUrl:%s", Long.valueOf(j), str, Boolean.valueOf(z));
        if (this.ntJ != j) {
            ab.i("Tinker.SyncResponseProcessor", "onTaskFinished ignore. id is no equal. download id :%s callback id:%s", Long.valueOf(this.ntJ), Long.valueOf(j));
            AppMethodBeat.o(90601);
            return;
        }
        b.wX(2);
        Context context = ah.getContext();
        File file = new File(str);
        boolean z2 = false;
        try {
            z2 = new ShareSecurityCheck(context).aw(file);
        } catch (Exception e) {
            ab.printErrStackTrace("Tinker.SyncResponseProcessor", e, "verify patch signature failed.", new Object[0]);
            h.pYm.a(614, 39, 1, false);
        }
        if (this.ntI.nui.intValue() != 2 || z2) {
            File file2;
            String absolutePath;
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo == null) {
                file2 = null;
            } else {
                file2 = new File(applicationInfo.dataDir, "tinker_server");
                if (!file2.exists()) {
                    file2.mkdirs();
                }
            }
            if (file2 != null) {
                File[] listFiles = file2.listFiles();
                if (listFiles != null) {
                    String name = file.getName();
                    for (File file3 : listFiles) {
                        if (!file3.getName().equals(name)) {
                            SharePatchFileUtil.as(file3);
                        }
                    }
                }
            }
            switch (this.ntI.nui.intValue()) {
                case 1:
                    ab.i("Tinker.SyncResponseProcessor", "coming soon! now can not support full apk update.");
                    break;
                case 2:
                    a.i("Tinker.SyncResponseProcessor", "onReceiveUpgradePatch. try to start apply", new Object[0]);
                    if (!com.tencent.mm.sdk.a.b.dnR()) {
                        if (!com.tencent.mm.app.v.a.cfp.BC()) {
                            a.w("Tinker.SyncResponseProcessor", "patch applying is blocked by TinkerEnsuranceOnFault, update basepack with different clientver to recover.", new Object[0]);
                            break;
                        } else {
                            com.tencent.tinker.lib.e.c.cf(context, file.getAbsolutePath());
                            break;
                        }
                    }
                    a.w("Tinker.SyncResponseProcessor", "[tomys] patch applying is blocked by assist.", new Object[0]);
                    break;
                case 3:
                    absolutePath = file.getAbsolutePath();
                    b bVar = this.ntI;
                    ab.i("MicroMsg.Tinker.CTinkerInstaller", "onReceiveUpgradeBsDiff bsDiffPath:%s , new apk md5：%s", absolutePath, bVar.nun);
                    com.tencent.mm.kernel.g.RS().aa(new com.tencent.mm.plugin.hp.a.a.AnonymousClass1(com.tencent.mm.plugin.hp.d.d.OJ(bVar.nun), context, absolutePath, bVar));
                    break;
            }
            b bVar2 = this.ntI;
            if (bVar2.bGw()) {
                absolutePath = b.a(bVar2.nuh, 2);
            } else {
                absolutePath = "";
            }
            context.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_patch_msg_key", absolutePath).apply();
        } else {
            a.i("Tinker.SyncResponseProcessor", "verify patch signature failed.", new Object[0]);
            b.wY(2);
            h.pYm.a(614, 31, 1, false);
            if (this.ntI.nui.intValue() == 3) {
                h.pYm.a(614, 54, 1, false);
                ab.d("Tinker.SyncResponseProcessor", "boots download patch md5 no equal.");
            }
        }
        d.bij();
        com.tencent.mm.plugin.downloader.model.b.b(this);
        AppMethodBeat.o(90601);
    }

    public final void b(long j, int i, boolean z) {
        AppMethodBeat.i(90602);
        ab.w("Tinker.SyncResponseProcessor", "onTaskFailed");
        if (this.ntJ != j) {
            ab.i("Tinker.SyncResponseProcessor", "onTaskFailed ignore. id is no equal. download id :%s callback id:%s", Long.valueOf(this.ntJ), Long.valueOf(j));
            AppMethodBeat.o(90602);
            return;
        }
        b.wY(2);
        if (this.ntI.nui.intValue() == 3) {
            h.pYm.a(614, 51, 1, false);
        }
        d.bij();
        com.tencent.mm.plugin.downloader.model.b.b(this);
        AppMethodBeat.o(90602);
    }

    public final void onTaskRemoved(long j) {
        AppMethodBeat.i(90603);
        ab.i("Tinker.SyncResponseProcessor", "onTaskRemoved taskId:%d", Long.valueOf(j));
        d.bij();
        com.tencent.mm.plugin.downloader.model.b.b(this);
        AppMethodBeat.o(90603);
    }

    public final void onTaskPaused(long j) {
        AppMethodBeat.i(90604);
        ab.d("Tinker.SyncResponseProcessor", "onTaskPaused taskId:%d", Long.valueOf(j));
        AppMethodBeat.o(90604);
    }

    public final void gm(long j) {
        AppMethodBeat.i(90605);
        ab.d("Tinker.SyncResponseProcessor", "onTaskProgressChanged taskId:%d", Long.valueOf(j));
        AppMethodBeat.o(90605);
    }

    public final void i(long j, String str) {
        AppMethodBeat.i(90606);
        ab.d("Tinker.SyncResponseProcessor", "onTaskResumed taskId:%d filePath:%s", Long.valueOf(j), str);
        AppMethodBeat.o(90606);
    }

    public final void gn(long j) {
    }
}
