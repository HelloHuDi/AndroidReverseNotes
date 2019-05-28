package com.tinkerboots.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.p1112c.C46817a;
import com.tencent.tinker.lib.p1353d.C36551c;
import com.tencent.tinker.lib.p1353d.C41088d;
import com.tencent.tinker.lib.p1577b.C41087b;
import com.tencent.tinker.lib.p679e.C31097a;
import com.tencent.tinker.lib.p679e.C31097a.C31096a;
import com.tencent.tinker.lib.p679e.C44553d;
import com.tencent.tinker.lib.service.AbstractResultService;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.lib.util.C5952a;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import com.tenpay.android.wechat.PayuSecureEncrypt.EncrptType;
import com.tinkerboots.sdk.p1355b.C24573b;
import com.tinkerboots.sdk.p1355b.C31174c;
import com.tinkerboots.sdk.p688a.C44597a;
import com.tinkerboots.sdk.p688a.p1120b.C36621a;
import com.tinkerboots.sdk.p688a.p1579a.C41146b;
import java.io.File;

/* renamed from: com.tinkerboots.sdk.a */
public final class C44598a {
    public static C44598a ATQ;
    public final C31097a ATR;
    public final C44597a ATS;
    private final ApplicationLike cdV;

    /* renamed from: com.tinkerboots.sdk.a$a */
    public static class C44600a {
        public C41087b ABD;
        public C36551c ABE;
        public C41088d ABF;
        public C46817a ATV;
        public Class<? extends AbstractResultService> ATW;
        public C41146b ATX;
        public final ApplicationLike cdV;
        public final Context context;

        public C44600a(ApplicationLike applicationLike) {
            AppMethodBeat.m2504i(65519);
            if (applicationLike == null) {
                TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("applicationLike must not be null.");
                AppMethodBeat.m2505o(65519);
                throw tinkerRuntimeException;
            }
            this.context = applicationLike.getApplication();
            this.cdV = applicationLike;
            AppMethodBeat.m2505o(65519);
        }
    }

    public C44598a(Context context, ApplicationLike applicationLike, C36551c c36551c, C41088d c41088d, C41087b c41087b, C46817a c46817a, Class<? extends AbstractResultService> cls, C41146b c41146b) {
        AppMethodBeat.m2504i(65520);
        C31174c.context = context;
        this.cdV = applicationLike;
        this.ATS = C44597a.m81008a(c41146b);
        C31096a c31096a = new C31096a(applicationLike.getApplication());
        int tinkerFlags = applicationLike.getTinkerFlags();
        TinkerRuntimeException tinkerRuntimeException;
        if (c31096a.status != -1) {
            tinkerRuntimeException = new TinkerRuntimeException("tinkerFlag is already set.");
            AppMethodBeat.m2505o(65520);
            throw tinkerRuntimeException;
        }
        c31096a.status = tinkerFlags;
        if (c36551c == null) {
            tinkerRuntimeException = new TinkerRuntimeException("loadReporter must not be null.");
            AppMethodBeat.m2505o(65520);
            throw tinkerRuntimeException;
        } else if (c31096a.ABE != null) {
            tinkerRuntimeException = new TinkerRuntimeException("loadReporter is already set.");
            AppMethodBeat.m2505o(65520);
            throw tinkerRuntimeException;
        } else {
            c31096a.ABE = c36551c;
            if (c41087b == null) {
                tinkerRuntimeException = new TinkerRuntimeException("listener must not be null.");
                AppMethodBeat.m2505o(65520);
                throw tinkerRuntimeException;
            } else if (c31096a.ABD != null) {
                tinkerRuntimeException = new TinkerRuntimeException("listener is already set.");
                AppMethodBeat.m2505o(65520);
                throw tinkerRuntimeException;
            } else {
                c31096a.ABD = c41087b;
                if (c41088d == null) {
                    tinkerRuntimeException = new TinkerRuntimeException("patchReporter must not be null.");
                    AppMethodBeat.m2505o(65520);
                    throw tinkerRuntimeException;
                } else if (c31096a.ABF != null) {
                    tinkerRuntimeException = new TinkerRuntimeException("patchReporter is already set.");
                    AppMethodBeat.m2505o(65520);
                    throw tinkerRuntimeException;
                } else {
                    c31096a.ABF = c41088d;
                    Boolean valueOf = Boolean.valueOf(applicationLike.getTinkerLoadVerifyFlag());
                    if (valueOf == null) {
                        tinkerRuntimeException = new TinkerRuntimeException("tinkerLoadVerifyFlag must not be null.");
                        AppMethodBeat.m2505o(65520);
                        throw tinkerRuntimeException;
                    } else if (c31096a.ABN != null) {
                        tinkerRuntimeException = new TinkerRuntimeException("tinkerLoadVerifyFlag is already set.");
                        AppMethodBeat.m2505o(65520);
                        throw tinkerRuntimeException;
                    } else {
                        c31096a.ABN = valueOf;
                        C31097a dSh = c31096a.dSh();
                        C31097a.m50179a(dSh);
                        Intent tinkerResultIntent = applicationLike.getTinkerResultIntent();
                        C31097a.ABB = true;
                        TinkerPatchService.m80932a(c46817a, cls);
                        C5952a.m9284i("Tinker.Tinker", "try to install tinker, isEnable: %b, version: %s", Boolean.valueOf(ShareTinkerInternals.m9413Se(dSh.tinkerFlags)), "1.9.10");
                        if (!ShareTinkerInternals.m9413Se(dSh.tinkerFlags)) {
                            C5952a.m9283e("Tinker.Tinker", "tinker is disabled", new Object[0]);
                        } else if (tinkerResultIntent == null) {
                            tinkerRuntimeException = new TinkerRuntimeException("intentResult must not be null.");
                            AppMethodBeat.m2505o(65520);
                            throw tinkerRuntimeException;
                        } else {
                            String auq;
                            dSh.ABJ = new C44553d();
                            C44553d c44553d = dSh.ABJ;
                            C31097a iX = C31097a.m50180iX(dSh.context);
                            c44553d.ACc = ShareIntentUtil.m9355be(tinkerResultIntent);
                            c44553d.iBv = ShareIntentUtil.m9356bf(tinkerResultIntent);
                            c44553d.ABS = ShareIntentUtil.m9365w(tinkerResultIntent, "intent_patch_system_ota");
                            c44553d.ABP = ShareIntentUtil.m9362n(tinkerResultIntent, "intent_patch_oat_dir");
                            c44553d.ABR = "interpet".equals(c44553d.ABP);
                            boolean z = iX.rNw;
                            C5952a.m9284i("Tinker.TinkerLoadResult", "parseTinkerResult loadCode:%d, process name:%s, main process:%b, systemOTA:%b, fingerPrint:%s, oatDir:%s, useInterpretMode:%b", Integer.valueOf(c44553d.ACc), ShareTinkerInternals.m9416aD(r2), Boolean.valueOf(z), Boolean.valueOf(c44553d.ABS), Build.FINGERPRINT, c44553d.ABP, Boolean.valueOf(c44553d.ABR));
                            String n = ShareIntentUtil.m9362n(tinkerResultIntent, "intent_patch_old_version");
                            String n2 = ShareIntentUtil.m9362n(tinkerResultIntent, "intent_patch_new_version");
                            File file = iX.ABC;
                            File file2 = iX.ABG;
                            if (!(n == null || n2 == null)) {
                                if (z) {
                                    c44553d.ABO = n2;
                                } else {
                                    c44553d.ABO = n;
                                }
                                C5952a.m9284i("Tinker.TinkerLoadResult", "parseTinkerResult oldVersion:%s, newVersion:%s, current:%s", n, n2, c44553d.ABO);
                                auq = SharePatchFileUtil.auq(c44553d.ABO);
                                if (!ShareTinkerInternals.isNullOrNil(auq)) {
                                    c44553d.ABT = new File(file.getAbsolutePath() + "/" + auq);
                                    c44553d.ABU = new File(c44553d.ABT.getAbsolutePath(), SharePatchFileUtil.aur(c44553d.ABO));
                                    c44553d.ABV = new File(c44553d.ABT, "dex");
                                    c44553d.ABW = new File(c44553d.ABT, "lib");
                                    c44553d.ABX = new File(c44553d.ABT, "res");
                                    c44553d.ABY = new File(c44553d.ABX, "resources.apk");
                                }
                                c44553d.patchInfo = new SharePatchInfo(n, n2, false, Build.FINGERPRINT, c44553d.ABP);
                                c44553d.ABQ = !n.equals(n2);
                            }
                            Throwable bg = ShareIntentUtil.m9357bg(tinkerResultIntent);
                            if (bg == null) {
                                switch (c44553d.ACc) {
                                    case -10000:
                                        C5952a.m9283e("Tinker.TinkerLoadResult", "can't get the right intent return code", new Object[0]);
                                        tinkerRuntimeException = new TinkerRuntimeException("can't get the right intent return code");
                                        AppMethodBeat.m2505o(65520);
                                        throw tinkerRuntimeException;
                                    case DownloadResult.CODE_CONNECTION_EXCEPTION /*-24*/:
                                        if (c44553d.ABY != null) {
                                            C5952a.m9283e("Tinker.TinkerLoadResult", "patch resource file md5 is mismatch: %s", c44553d.ABY.getAbsolutePath());
                                            iX.ABE.mo40772b(c44553d.ABY, 6);
                                            break;
                                        }
                                        C5952a.m9283e("Tinker.TinkerLoadResult", "resource file md5 mismatch, but patch resource file not found!", new Object[0]);
                                        tinkerRuntimeException = new TinkerRuntimeException("resource file md5 mismatch, but patch resource file not found!");
                                        AppMethodBeat.m2505o(65520);
                                        throw tinkerRuntimeException;
                                    case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
                                        if (c44553d.ABT != null) {
                                            C5952a.m9283e("Tinker.TinkerLoadResult", "patch resource file not found:%s", c44553d.ABY.getAbsolutePath());
                                            iX.ABE.mo40767a(c44553d.ABY, 6, false);
                                            break;
                                        }
                                        C5952a.m9283e("Tinker.TinkerLoadResult", "patch resource file not found, warning why the path is null!!!!", new Object[0]);
                                        tinkerRuntimeException = new TinkerRuntimeException("patch resource file not found, warning why the path is null!!!!");
                                        AppMethodBeat.m2505o(65520);
                                        throw tinkerRuntimeException;
                                    case DownloadResult.CODE_URL_ERROR /*-21*/:
                                        if (c44553d.ABT != null) {
                                            C5952a.m9283e("Tinker.TinkerLoadResult", "patch resource file directory not found:%s", c44553d.ABX.getAbsolutePath());
                                            iX.ABE.mo40767a(c44553d.ABX, 6, true);
                                            break;
                                        }
                                        C5952a.m9283e("Tinker.TinkerLoadResult", "patch resource file directory not found, warning why the path is null!!!!", new Object[0]);
                                        tinkerRuntimeException = new TinkerRuntimeException("patch resource file directory not found, warning why the path is null!!!!");
                                        AppMethodBeat.m2505o(65520);
                                        throw tinkerRuntimeException;
                                    case -19:
                                        C5952a.m9284i("Tinker.TinkerLoadResult", "rewrite patch info file corrupted", new Object[0]);
                                        iX.ABE.mo40768a(n, n2, file2);
                                        break;
                                    case -18:
                                        auq = ShareIntentUtil.m9362n(tinkerResultIntent, "intent_patch_missing_lib_path");
                                        if (auq != null) {
                                            C5952a.m9283e("Tinker.TinkerLoadResult", "patch lib file not found:%s", auq);
                                            iX.ABE.mo40767a(new File(auq), 5, false);
                                            break;
                                        }
                                        C5952a.m9283e("Tinker.TinkerLoadResult", "patch lib file not found, but path is null!!!!", new Object[0]);
                                        tinkerRuntimeException = new TinkerRuntimeException("patch lib file not found, but path is null!!!!");
                                        AppMethodBeat.m2505o(65520);
                                        throw tinkerRuntimeException;
                                    case -17:
                                        if (c44553d.ABT != null) {
                                            C5952a.m9283e("Tinker.TinkerLoadResult", "patch lib file directory not found:%s", c44553d.ABW.getAbsolutePath());
                                            iX.ABE.mo40767a(c44553d.ABW, 5, true);
                                            break;
                                        }
                                        C5952a.m9283e("Tinker.TinkerLoadResult", "patch lib file directory not found, warning why the path is null!!!!", new Object[0]);
                                        tinkerRuntimeException = new TinkerRuntimeException("patch lib file directory not found, warning why the path is null!!!!");
                                        AppMethodBeat.m2505o(65520);
                                        throw tinkerRuntimeException;
                                    case -16:
                                        iX.ABE.mo40771b(2, ShareIntentUtil.m9358bh(tinkerResultIntent));
                                        break;
                                    case -15:
                                        iX.ABE.mo40771b(1, ShareIntentUtil.m9358bh(tinkerResultIntent));
                                        break;
                                    case -13:
                                        auq = ShareIntentUtil.m9362n(tinkerResultIntent, "intent_patch_mismatch_dex_path");
                                        if (auq != null) {
                                            C5952a.m9283e("Tinker.TinkerLoadResult", "patch dex file md5 is mismatch: %s", auq);
                                            iX.ABE.mo40772b(new File(auq), 3);
                                            break;
                                        }
                                        C5952a.m9283e("Tinker.TinkerLoadResult", "patch dex file md5 is mismatch, but path is null!!!!", new Object[0]);
                                        tinkerRuntimeException = new TinkerRuntimeException("patch dex file md5 is mismatch, but path is null!!!!");
                                        AppMethodBeat.m2505o(65520);
                                        throw tinkerRuntimeException;
                                    case -12:
                                        C5952a.m9283e("Tinker.TinkerLoadResult", "patch dex load fail, classloader is null", new Object[0]);
                                        break;
                                    case -11:
                                        auq = ShareIntentUtil.m9362n(tinkerResultIntent, "intent_patch_missing_dex_path");
                                        if (auq != null) {
                                            C5952a.m9283e("Tinker.TinkerLoadResult", "patch dex opt file not found:%s", auq);
                                            iX.ABE.mo40767a(new File(auq), 4, false);
                                            break;
                                        }
                                        C5952a.m9283e("Tinker.TinkerLoadResult", "patch dex opt file not found, but path is null!!!!", new Object[0]);
                                        tinkerRuntimeException = new TinkerRuntimeException("patch dex opt file not found, but path is null!!!!");
                                        AppMethodBeat.m2505o(65520);
                                        throw tinkerRuntimeException;
                                    case -10:
                                        auq = ShareIntentUtil.m9362n(tinkerResultIntent, "intent_patch_missing_dex_path");
                                        if (auq != null) {
                                            C5952a.m9283e("Tinker.TinkerLoadResult", "patch dex file not found:%s", auq);
                                            iX.ABE.mo40767a(new File(auq), 3, false);
                                            break;
                                        }
                                        C5952a.m9283e("Tinker.TinkerLoadResult", "patch dex file not found, but path is null!!!!", new Object[0]);
                                        tinkerRuntimeException = new TinkerRuntimeException("patch dex file not found, but path is null!!!!");
                                        AppMethodBeat.m2505o(65520);
                                        throw tinkerRuntimeException;
                                    case -9:
                                        if (c44553d.ABV != null) {
                                            C5952a.m9283e("Tinker.TinkerLoadResult", "patch dex file directory not found:%s", c44553d.ABV.getAbsolutePath());
                                            iX.ABE.mo40767a(c44553d.ABV, 3, true);
                                            break;
                                        }
                                        C5952a.m9283e("Tinker.TinkerLoadResult", "patch dex file directory not found, warning why the path is null!!!!", new Object[0]);
                                        tinkerRuntimeException = new TinkerRuntimeException("patch dex file directory not found, warning why the path is null!!!!");
                                        AppMethodBeat.m2505o(65520);
                                        throw tinkerRuntimeException;
                                    case -8:
                                        C5952a.m9284i("Tinker.TinkerLoadResult", "patch package check fail", new Object[0]);
                                        if (c44553d.ABU != null) {
                                            iX.ABE.mo40773c(c44553d.ABU, tinkerResultIntent.getIntExtra("intent_patch_package_patch_check", -10000));
                                            break;
                                        }
                                        tinkerRuntimeException = new TinkerRuntimeException("error patch package check fail , but file is null");
                                        AppMethodBeat.m2505o(65520);
                                        throw tinkerRuntimeException;
                                    case -7:
                                        C5952a.m9283e("Tinker.TinkerLoadResult", "patch version file not found, current version:%s", c44553d.ABO);
                                        if (c44553d.ABU != null) {
                                            iX.ABE.mo40767a(c44553d.ABU, 1, false);
                                            break;
                                        }
                                        tinkerRuntimeException = new TinkerRuntimeException("error load patch version file not exist, but file is null");
                                        AppMethodBeat.m2505o(65520);
                                        throw tinkerRuntimeException;
                                    case -6:
                                        C5952a.m9283e("Tinker.TinkerLoadResult", "patch version directory not found, current version:%s", c44553d.ABO);
                                        iX.ABE.mo40767a(c44553d.ABT, 1, true);
                                        break;
                                    case -5:
                                        C5952a.m9283e("Tinker.TinkerLoadResult", "path info blank, wait main process to restart", new Object[0]);
                                        break;
                                    case -4:
                                        C5952a.m9283e("Tinker.TinkerLoadResult", "path info corrupted", new Object[0]);
                                        iX.ABE.mo40768a(n, n2, file2);
                                        break;
                                    case -3:
                                    case -2:
                                        C5952a.m9285w("Tinker.TinkerLoadResult", "can't find patch file, is ok, just return", new Object[0]);
                                        break;
                                    case -1:
                                        C5952a.m9285w("Tinker.TinkerLoadResult", "tinker is disable, just return", new Object[0]);
                                        break;
                                    case 0:
                                        C5952a.m9284i("Tinker.TinkerLoadResult", "oh yeah, tinker load all success", new Object[0]);
                                        iX.ABK = true;
                                        c44553d.ABZ = ShareIntentUtil.m9359bi(tinkerResultIntent);
                                        c44553d.ACa = ShareIntentUtil.m9360bj(tinkerResultIntent);
                                        c44553d.ACb = ShareIntentUtil.m9361bk(tinkerResultIntent);
                                        if (c44553d.ABR) {
                                            iX.ABE.mo40771b(0, null);
                                        }
                                        if (z && c44553d.ABQ) {
                                            iX.ABE.mo40769a(n, n2, file, c44553d.ABT.getName());
                                            break;
                                        }
                                }
                            }
                            C5952a.m9284i("Tinker.TinkerLoadResult", "Tinker load have exception loadCode:%d", Integer.valueOf(c44553d.ACc));
                            int i = -1;
                            switch (c44553d.ACc) {
                                case DownloadResult.CODE_SOCKET_TIMEOUT_EXCEPTION /*-25*/:
                                    i = -4;
                                    break;
                                case DownloadResult.CODE_CONNECTION_TIMEOUT_EXCEPTION /*-23*/:
                                    i = -3;
                                    break;
                                case EncrptType.HASHED_SECRET_ANSWER /*-20*/:
                                    i = -1;
                                    break;
                                case -14:
                                    i = -2;
                                    break;
                            }
                            iX.ABE.mo40770a(bg, i);
                            dSh.ABE.mo40766a(dSh.ABC, dSh.ABJ.ACc, dSh.ABJ.iBv);
                            if (!dSh.ABK) {
                                C5952a.m9285w("Tinker.Tinker", "tinker load fail!", new Object[0]);
                            }
                        }
                        this.ATR = dSh;
                        AppMethodBeat.m2505o(65520);
                    }
                }
            }
        }
    }

    public static C44598a dWj() {
        AppMethodBeat.m2504i(65521);
        if (ATQ == null) {
            TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("you must init TinkerClient sdk first");
            AppMethodBeat.m2505o(65521);
            throw tinkerRuntimeException;
        }
        C44598a c44598a = ATQ;
        AppMethodBeat.m2505o(65521);
        return c44598a;
    }

    /* renamed from: rF */
    public final C44598a mo71472rF(final boolean z) {
        AppMethodBeat.m2504i(65522);
        C44598a c44598a;
        if (this.ATS == null || this.ATR == null) {
            C5952a.m9283e("Tinker.TinkerClient", "fetchPatchUpdate, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
            c44598a = ATQ;
            AppMethodBeat.m2505o(65522);
            return c44598a;
        }
        Context context = C31174c.getContext();
        if (!C24573b.m38229jG(context)) {
            C5952a.m9283e("Tinker.TinkerClient", "fetchPatchUpdate, permission refuse, you must access INTERNET and ACCESS_NETWORK_STATE permission first", new Object[0]);
            c44598a = ATQ;
            AppMethodBeat.m2505o(65522);
            return c44598a;
        } else if (ShareTinkerInternals.m9413Se(this.ATR.tinkerFlags) && ShareTinkerInternals.m9422jn(context)) {
            if (this.ATR.rNw) {
                Looper.getMainLooper();
                Looper.myQueue().addIdleHandler(new IdleHandler() {
                    public final boolean queueIdle() {
                        AppMethodBeat.m2504i(65518);
                        C44597a c44597a = C44598a.this.ATS;
                        boolean z = z;
                        SharedPreferences sharedPreferences = C31174c.getContext().getSharedPreferences("patch_server_config", 0);
                        long j = sharedPreferences.getLong("fetch_patch_last_check", 0);
                        if (j == -1) {
                            C5952a.m9284i("Tinker.ServerClient", "tinker sync is disabled, with never check flag!", new Object[0]);
                        } else {
                            j = System.currentTimeMillis() - j;
                            if (z || c44597a.isDebug || j >= c44597a.hgu) {
                                sharedPreferences.edit().putLong("fetch_patch_last_check", System.currentTimeMillis()).commit();
                                C36621a c36621a = c44597a.ATZ;
                                C41146b c41146b = c44597a.ATX;
                                if (c41146b == null) {
                                    RuntimeException runtimeException = new RuntimeException("callback can't be null");
                                    AppMethodBeat.m2505o(65518);
                                    throw runtimeException;
                                } else if (c41146b.bGs()) {
                                    c41146b.bGt();
                                    c41146b.mo36395L(c36621a.AUa.AUb);
                                }
                            } else {
                                C5952a.m9284i("Tinker.ServerClient", "tinker sync should wait interval %ss", Long.valueOf((c44597a.hgu - j) / 1000));
                            }
                        }
                        AppMethodBeat.m2505o(65518);
                        return false;
                    }
                });
            }
            c44598a = ATQ;
            AppMethodBeat.m2505o(65522);
            return c44598a;
        } else {
            C5952a.m9283e("Tinker.TinkerClient", "fetchPatchUpdate, tinker is disable, just return", new Object[0]);
            c44598a = ATQ;
            AppMethodBeat.m2505o(65522);
            return c44598a;
        }
    }

    /* renamed from: iN */
    public final C44598a mo71471iN(String str, String str2) {
        AppMethodBeat.m2504i(65523);
        C44598a c44598a;
        if (this.ATS == null) {
            C5952a.m9283e("Tinker.TinkerClient", "setPatchCondition, tinkerServerClient == null, just return", new Object[0]);
            c44598a = ATQ;
            AppMethodBeat.m2505o(65523);
            return c44598a;
        }
        C5952a.m9284i("Tinker.TinkerClient", "setPatchCondition %s with value %s", str, str2);
        this.ATS.mo71469iO(str, str2);
        c44598a = ATQ;
        AppMethodBeat.m2505o(65523);
        return c44598a;
    }

    /* renamed from: SG */
    public final C44598a mo71470SG(int i) {
        AppMethodBeat.m2504i(65524);
        C44598a c44598a;
        if (this.ATS == null) {
            C5952a.m9283e("Tinker.TinkerClient", "setFetchPatchIntervalByHours, tinkerServerClient == null, just return", new Object[0]);
            c44598a = ATQ;
            AppMethodBeat.m2505o(65524);
            return c44598a;
        }
        C5952a.m9284i("Tinker.TinkerClient", "setFetchPatchIntervalByHours to %d hours", Integer.valueOf(i));
        this.ATS.mo71468SH(i);
        c44598a = ATQ;
        AppMethodBeat.m2505o(65524);
        return c44598a;
    }
}
