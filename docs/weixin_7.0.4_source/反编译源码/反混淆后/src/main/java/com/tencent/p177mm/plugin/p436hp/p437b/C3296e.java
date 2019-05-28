package com.tencent.p177mm.plugin.p436hp.p437b;

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
import android.support.p057v4.app.C0363v.C0358c;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.app.C1271v.C1270a;
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelmulti.C37943l;
import com.tencent.p177mm.modelmulti.C37943l.C26455a;
import com.tencent.p177mm.p1637bo.C45186a;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p209c.C32429a;
import com.tencent.p177mm.plugin.downloader.model.C11511k;
import com.tencent.p177mm.plugin.downloader.model.C2886b;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.model.C2900e.C2901a;
import com.tencent.p177mm.plugin.p436hp.p1272a.C21068a.C210691;
import com.tencent.p177mm.plugin.p436hp.p1273d.C21071c;
import com.tencent.p177mm.plugin.p436hp.p1273d.C28317b;
import com.tencent.p177mm.plugin.p436hp.p1273d.C28318d;
import com.tencent.p177mm.plugin.p436hp.tinker.C21075g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.che;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tinker.lib.p679e.C31097a;
import com.tencent.tinker.lib.p679e.C46818c;
import com.tencent.tinker.lib.util.C5952a;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareSecurityCheck;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.hp.b.e */
public final class C3296e implements C11511k {
    final C28317b ntI;
    private long ntJ;

    /* renamed from: com.tencent.mm.plugin.hp.b.e$1 */
    class C32981 implements OnClickListener {
        C32981() {
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.m2504i(90593);
            if (C3296e.this.ntI.bGu()) {
                C3296e.this.bGk();
            }
            AppMethodBeat.m2505o(90593);
        }
    }

    public C3296e(C28317b c28317b) {
        AppMethodBeat.m2504i(90596);
        this.ntI = c28317b;
        C2896d.bij();
        C2886b.m5129a(this);
        AppMethodBeat.m2505o(90596);
    }

    /* renamed from: if */
    public final boolean mo7670if(boolean z) {
        boolean z2;
        AppMethodBeat.m2504i(90597);
        C5952a.m9284i("Tinker.SyncResponseProcessor", "process tinker response: %s", this.ntI.toString());
        C28317b c28317b = this.ntI;
        if (c28317b.nug.intValue() > 4 || c28317b.nug.intValue() <= 0) {
            C4990ab.m7413e("Tinker.TinkerSyncResponse", "responseState: %d must between %d and %d", c28317b.nug, Integer.valueOf(1), Integer.valueOf(4));
            C7060h.pYm.mo8378a(614, 24, 1, false);
            z2 = false;
        } else {
            if (c28317b.bGv()) {
                if (TextUtils.isEmpty(c28317b.num)) {
                    C4990ab.m7412e("Tinker.TinkerSyncResponse", "sync response patchId should not be null");
                    C7060h.pYm.mo8378a(614, 25, 1, false);
                    z2 = false;
                } else if (TextUtils.isEmpty(c28317b.nuk)) {
                    C4990ab.m7412e("Tinker.TinkerSyncResponse", "sync response cdnUrl should not be null");
                    C7060h.pYm.mo8378a(614, 26, 1, false);
                    z2 = false;
                } else if (TextUtils.isEmpty(c28317b.nul)) {
                    C4990ab.m7412e("Tinker.TinkerSyncResponse", "sync response fileMd5 should not be null");
                    C7060h.pYm.mo8378a(614, 27, 1, false);
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
                final Context context = C4996ah.getContext();
                final C31097a iX = C31097a.m50180iX(context);
                if (iX.ABK) {
                    C5952a.m9284i("Tinker.SyncResponseProcessor", "tinker wait screen to clean patch and kill all process", new Object[0]);
                    C37943l c37943l = new C37943l(C4996ah.getContext(), new C26455a() {
                        /* renamed from: cO */
                        public final void mo7663cO(boolean z) {
                            AppMethodBeat.m2504i(90595);
                            if (!z) {
                                C5952a.m9284i("Tinker.SyncResponseProcessor", "app is background now, i can kill quietly", new Object[0]);
                                ShareTinkerInternals.m9426jr(context);
                                iX.bGr();
                                Process.killProcess(Process.myPid());
                            }
                            AppMethodBeat.m2505o(90595);
                        }
                    });
                    SharePatchInfo.m9390a(iX.ABG, new SharePatchInfo(iX.ABJ.ABO, "00000000000000000000000000000000", true, Build.FINGERPRINT, "odex"), iX.ABH);
                } else {
                    C5952a.m9285w("Tinker.SyncResponseProcessor", "SyncResponseProcessor: onPatchRollback, tinker is not loaded, just return", new Object[0]);
                }
                AppMethodBeat.m2505o(90597);
                return true;
            } else if (!this.ntI.bGv()) {
                AppMethodBeat.m2505o(90597);
                return true;
            } else if (this.ntI.bGy()) {
                C5952a.m9285w("Tinker.SyncResponseProcessor", "is lower version skip.", new Object[0]);
                C7060h.pYm.mo8378a(614, 78, 1, false);
                AppMethodBeat.m2505o(90597);
                return true;
            } else if (C4872b.dnR()) {
                C5952a.m9285w("Tinker.SyncResponseProcessor", "[tomys] patch downloading is blocked by assist.", new Object[0]);
                AppMethodBeat.m2505o(90597);
                return true;
            } else if (this.ntI.nui.intValue() == 3 && !C5046bo.isNullOrNil(this.ntI.clientVersion) && C21071c.m32374OH(this.ntI.clientVersion)) {
                C7060h.pYm.mo8378a(614, 77, 1, false);
                C28317b c28317b2 = this.ntI;
                Context context2 = C4996ah.getContext();
                CharSequence string = C5046bo.isNullOrNil(c28317b2.nup) ? context2.getString(C25738R.string.f9211t4) : c28317b2.nup;
                CharSequence charSequence = C5046bo.isNullOrNil(c28317b2.nuq) ? "" : c28317b2.nuq;
                String str = C5046bo.isNullOrNil(c28317b2.nur) ? "http://support.weixin.qq.com/cgi-bin/mmsupport-bin/readtemplate?t=page/android_exp__index" : c28317b2.nur;
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setClassName(C4996ah.getPackageName(), C4996ah.getPackageName() + ".plugin.webview.ui.tools.WebViewUI");
                intent.putExtra("rawUrl", str);
                intent.putExtra("useJs", true);
                intent.putExtra("vertical_scroll", true);
                intent.setFlags(872415232);
                PendingIntent activity = PendingIntent.getActivity(context2, 0, intent, 268435456);
                C0358c e = C45186a.m83262bt(context2, "reminder_channel_id").mo625g(null).mo626j(System.currentTimeMillis()).mo621d(string).mo623e(charSequence);
                e.f362EI = activity;
                e.mo616as(C45186a.bWV());
                Notification build = e.build();
                build.flags |= 16;
                if (z) {
                    ((NotificationManager) context2.getSystemService("notification")).notify(19841110, build);
                } else {
                    C4990ab.m7416i("Tinker.SyncResponseProcessor", "ignore action when load from cache,when response is alpha version");
                }
                AppMethodBeat.m2505o(90597);
                return true;
            } else {
                C5952a.m9284i("Tinker.SyncResponseProcessor", "check need show before download. network type:%d msg:%s", this.ntI.nuj, this.ntI.bGx());
                final Context context3 = C4996ah.getContext();
                if (this.ntI.nuj.intValue() == 2 && C5023at.isMobile(C4996ah.getContext()) && this.ntI.bGw()) {
                    if (C21075g.m32383az(context3, this.ntI.num)) {
                        C7060h.pYm.mo8378a(614, 44, 1, false);
                        C4990ab.m7417i("Tinker.SyncResponseProcessor", "this patch id :%s show cancel before user, need show again.", this.ntI.num);
                    } else {
                        if (this.ntI.nui.intValue() == 2) {
                            C46029i.m85611a(C4996ah.getContext().getString(C25738R.string.byv), C4996ah.getContext().getString(C25738R.string.byx, new Object[]{this.ntI.bGx(), C4996ah.getContext().getString(C25738R.string.eyx), C5046bo.m7565ga((long) this.ntI.fileSize)}), C4996ah.getContext().getString(C25738R.string.ez1), new C32981(), C4996ah.getContext().getString(C25738R.string.eyp), new OnClickListener() {
                                public final void onClick(DialogInterface dialogInterface, int i) {
                                    AppMethodBeat.m2504i(90594);
                                    C21075g.m32381aA(context3, C3296e.this.ntI.num);
                                    AppMethodBeat.m2505o(90594);
                                }
                            });
                        } else if (this.ntI.nui.intValue() == 3) {
                            String string2;
                            C4990ab.m7410d("Tinker.SyncResponseProcessor", "showUpdateDialog ");
                            if (C5046bo.isNullOrNil(this.ntI.bGx())) {
                                string2 = context3.getString(C25738R.string.ez8);
                            } else {
                                string2 = this.ntI.bGx();
                            }
                            che che = new che();
                            che.num = this.ntI.num;
                            che.title = context3.getString(C25738R.string.byv);
                            che.xgb = context3.getString(C25738R.string.ez1);
                            che.nna = context3.getString(C25738R.string.eyp);
                            che.nun = this.ntI.nun;
                            che.nuo = this.ntI.nuo;
                            che.iCm = this.ntI.fileSize;
                            che.nuk = this.ntI.nuk;
                            che.cdy = this.ntI.nul;
                            che.versionCode = this.ntI.versionCode;
                            che.xga = C28318d.m44925OJ(this.ntI.nun);
                            che.bzH = string2;
                            C28318d.m44926a(che);
                        }
                        C39251a.m66896wV(4);
                    }
                } else if (this.ntI.bGu() && !C21075g.m32383az(context3, this.ntI.num)) {
                    bGk();
                }
                AppMethodBeat.m2505o(90597);
                return true;
            }
        }
        C5952a.m9284i("Tinker.SyncResponseProcessor", "process check response fail, just return", new Object[0]);
        AppMethodBeat.m2505o(90597);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void bGk() {
        AppMethodBeat.m2504i(90598);
        if (!C1448h.getExternalStorageState().equals("mounted")) {
            C4990ab.m7412e("Tinker.SyncResponseProcessor", "no sdcard.");
            C7060h.pYm.mo8378a(614, 50, 1, false);
            AppMethodBeat.m2505o(90598);
        } else if (!C1445f.m3072eW((long) this.ntI.fileSize)) {
            C4990ab.m7412e("Tinker.SyncResponseProcessor", "sdcard is full.");
            C7060h.pYm.mo8378a(614, 51, 1, false);
            if (this.ntI.nui.intValue() == 3) {
                C7060h.pYm.mo8378a(614, 55, 1, false);
            }
            AppMethodBeat.m2505o(90598);
        } else if (this.ntI.nui.intValue() == 3 && !C5046bo.isNullOrNil(this.ntI.nun) && C1173e.m2561ct(C28318d.m44925OJ(this.ntI.nun)) && C32429a.m53087cM(C28318d.m44925OJ(this.ntI.nun))) {
            String string;
            Context context = C4996ah.getContext();
            if (C5046bo.isNullOrNil(this.ntI.bGx())) {
                string = context.getString(C25738R.string.ez8);
            } else {
                string = this.ntI.bGx();
            }
            che che = new che();
            che.num = this.ntI.num;
            che.title = context.getString(C25738R.string.byv);
            che.xgb = context.getString(C25738R.string.cdx);
            che.nna = context.getString(C25738R.string.eyp);
            che.nun = this.ntI.nun;
            che.nuo = this.ntI.nuo;
            che.iCm = this.ntI.fileSize;
            che.nuk = this.ntI.nuk;
            che.cdy = this.ntI.nul;
            che.versionCode = this.ntI.versionCode;
            che.xga = C28318d.m44925OJ(this.ntI.nun);
            che.bzH = string;
            C28318d.m44926a(che);
            C4990ab.m7417i("Tinker.SyncResponseProcessor", "file is exist. need no to download. newApkMd5:%s", this.ntI.nun);
            AppMethodBeat.m2505o(90598);
        } else {
            this.ntI.nui.intValue();
            bGl();
            AppMethodBeat.m2505o(90598);
        }
    }

    private void bGl() {
        AppMethodBeat.m2504i(90599);
        C4996ah.getContext();
        C28318d.bGA();
        C28318d.bGB();
        C2901a c2901a = new C2901a();
        c2901a.mo7055It(this.ntI.nuk);
        c2901a.mo7057Iv(this.ntI.num);
        c2901a.mo7058Iw(this.ntI.nul);
        c2901a.mo7063ga(false);
        c2901a.bir();
        c2901a.mo7069tN(2);
        c2901a.mo7064gb(false);
        this.ntJ = C2896d.bij().mo7042a(c2901a.kNl);
        C4990ab.m7417i("Tinker.SyncResponseProcessor", "Download task id is :%d", Long.valueOf(this.ntJ));
        C7060h.pYm.mo8378a(614, 2, 1, false);
        if (C5023at.isWifi(C4996ah.getContext())) {
            C7060h.pYm.mo8378a(614, 7, 1, false);
        } else {
            C7060h.pYm.mo8378a(614, 8, 1, false);
        }
        if (this.ntI.nui.intValue() == 3) {
            C7060h.pYm.mo8378a(614, 56, 1, false);
            C4990ab.m7410d("Tinker.SyncResponseProcessor", "boots download start silent.");
        }
        AppMethodBeat.m2505o(90599);
    }

    public final void onTaskStarted(long j, String str) {
        AppMethodBeat.m2504i(90600);
        C4990ab.m7411d("Tinker.SyncResponseProcessor", "onTaskStarted taskId %d", Long.valueOf(j));
        AppMethodBeat.m2505o(90600);
    }

    /* renamed from: b */
    public final void mo7665b(long j, String str, boolean z) {
        AppMethodBeat.m2504i(90601);
        C4990ab.m7417i("Tinker.SyncResponseProcessor", "onTaskFinished id:%d path:%s hasChangeUrl:%s", Long.valueOf(j), str, Boolean.valueOf(z));
        if (this.ntJ != j) {
            C4990ab.m7417i("Tinker.SyncResponseProcessor", "onTaskFinished ignore. id is no equal. download id :%s callback id:%s", Long.valueOf(this.ntJ), Long.valueOf(j));
            AppMethodBeat.m2505o(90601);
            return;
        }
        C46028b.m85604wX(2);
        Context context = C4996ah.getContext();
        File file = new File(str);
        boolean z2 = false;
        try {
            z2 = new ShareSecurityCheck(context).mo12704aw(file);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("Tinker.SyncResponseProcessor", e, "verify patch signature failed.", new Object[0]);
            C7060h.pYm.mo8378a(614, 39, 1, false);
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
                            SharePatchFileUtil.m9373as(file3);
                        }
                    }
                }
            }
            switch (this.ntI.nui.intValue()) {
                case 1:
                    C4990ab.m7416i("Tinker.SyncResponseProcessor", "coming soon! now can not support full apk update.");
                    break;
                case 2:
                    C5952a.m9284i("Tinker.SyncResponseProcessor", "onReceiveUpgradePatch. try to start apply", new Object[0]);
                    if (!C4872b.dnR()) {
                        if (!C1270a.cfp.mo4561BC()) {
                            C5952a.m9285w("Tinker.SyncResponseProcessor", "patch applying is blocked by TinkerEnsuranceOnFault, update basepack with different clientver to recover.", new Object[0]);
                            break;
                        } else {
                            C46818c.m89042cf(context, file.getAbsolutePath());
                            break;
                        }
                    }
                    C5952a.m9285w("Tinker.SyncResponseProcessor", "[tomys] patch applying is blocked by assist.", new Object[0]);
                    break;
                case 3:
                    absolutePath = file.getAbsolutePath();
                    C28317b c28317b = this.ntI;
                    C4990ab.m7417i("MicroMsg.Tinker.CTinkerInstaller", "onReceiveUpgradeBsDiff bsDiffPath:%s , new apk md5：%s", absolutePath, c28317b.nun);
                    C1720g.m3539RS().mo10302aa(new C210691(C28318d.m44925OJ(c28317b.nun), context, absolutePath, c28317b));
                    break;
            }
            C28317b c28317b2 = this.ntI;
            if (c28317b2.bGw()) {
                absolutePath = C28317b.m44924a(c28317b2.nuh, 2);
            } else {
                absolutePath = "";
            }
            context.getSharedPreferences("tinker_patch_share_config", 4).edit().putString("tinker_patch_msg_key", absolutePath).apply();
        } else {
            C5952a.m9284i("Tinker.SyncResponseProcessor", "verify patch signature failed.", new Object[0]);
            C46028b.m85605wY(2);
            C7060h.pYm.mo8378a(614, 31, 1, false);
            if (this.ntI.nui.intValue() == 3) {
                C7060h.pYm.mo8378a(614, 54, 1, false);
                C4990ab.m7410d("Tinker.SyncResponseProcessor", "boots download patch md5 no equal.");
            }
        }
        C2896d.bij();
        C2886b.m5130b(this);
        AppMethodBeat.m2505o(90601);
    }

    /* renamed from: b */
    public final void mo7664b(long j, int i, boolean z) {
        AppMethodBeat.m2504i(90602);
        C4990ab.m7420w("Tinker.SyncResponseProcessor", "onTaskFailed");
        if (this.ntJ != j) {
            C4990ab.m7417i("Tinker.SyncResponseProcessor", "onTaskFailed ignore. id is no equal. download id :%s callback id:%s", Long.valueOf(this.ntJ), Long.valueOf(j));
            AppMethodBeat.m2505o(90602);
            return;
        }
        C46028b.m85605wY(2);
        if (this.ntI.nui.intValue() == 3) {
            C7060h.pYm.mo8378a(614, 51, 1, false);
        }
        C2896d.bij();
        C2886b.m5130b(this);
        AppMethodBeat.m2505o(90602);
    }

    public final void onTaskRemoved(long j) {
        AppMethodBeat.m2504i(90603);
        C4990ab.m7417i("Tinker.SyncResponseProcessor", "onTaskRemoved taskId:%d", Long.valueOf(j));
        C2896d.bij();
        C2886b.m5130b(this);
        AppMethodBeat.m2505o(90603);
    }

    public final void onTaskPaused(long j) {
        AppMethodBeat.m2504i(90604);
        C4990ab.m7411d("Tinker.SyncResponseProcessor", "onTaskPaused taskId:%d", Long.valueOf(j));
        AppMethodBeat.m2505o(90604);
    }

    /* renamed from: gm */
    public final void mo7667gm(long j) {
        AppMethodBeat.m2504i(90605);
        C4990ab.m7411d("Tinker.SyncResponseProcessor", "onTaskProgressChanged taskId:%d", Long.valueOf(j));
        AppMethodBeat.m2505o(90605);
    }

    /* renamed from: i */
    public final void mo7669i(long j, String str) {
        AppMethodBeat.m2504i(90606);
        C4990ab.m7411d("Tinker.SyncResponseProcessor", "onTaskResumed taskId:%d filePath:%s", Long.valueOf(j), str);
        AppMethodBeat.m2505o(90606);
    }

    /* renamed from: gn */
    public final void mo7668gn(long j) {
    }
}
