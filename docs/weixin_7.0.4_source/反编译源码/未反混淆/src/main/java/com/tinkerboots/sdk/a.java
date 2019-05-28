package com.tinkerboots.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.b.b;
import com.tencent.tinker.lib.d.c;
import com.tencent.tinker.lib.d.d;
import com.tencent.tinker.lib.service.AbstractResultService;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.SharePatchInfo;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import com.tenpay.android.wechat.PayuSecureEncrypt.EncrptType;
import java.io.File;

public final class a {
    public static a ATQ;
    public final com.tencent.tinker.lib.e.a ATR;
    public final com.tinkerboots.sdk.a.a ATS;
    private final ApplicationLike cdV;

    public static class a {
        public b ABD;
        public c ABE;
        public d ABF;
        public com.tencent.tinker.lib.c.a ATV;
        public Class<? extends AbstractResultService> ATW;
        public com.tinkerboots.sdk.a.a.b ATX;
        public final ApplicationLike cdV;
        public final Context context;

        public a(ApplicationLike applicationLike) {
            AppMethodBeat.i(65519);
            if (applicationLike == null) {
                TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("applicationLike must not be null.");
                AppMethodBeat.o(65519);
                throw tinkerRuntimeException;
            }
            this.context = applicationLike.getApplication();
            this.cdV = applicationLike;
            AppMethodBeat.o(65519);
        }
    }

    public a(Context context, ApplicationLike applicationLike, c cVar, d dVar, b bVar, com.tencent.tinker.lib.c.a aVar, Class<? extends AbstractResultService> cls, com.tinkerboots.sdk.a.a.b bVar2) {
        AppMethodBeat.i(65520);
        com.tinkerboots.sdk.b.c.context = context;
        this.cdV = applicationLike;
        this.ATS = com.tinkerboots.sdk.a.a.a(bVar2);
        com.tencent.tinker.lib.e.a.a aVar2 = new com.tencent.tinker.lib.e.a.a(applicationLike.getApplication());
        int tinkerFlags = applicationLike.getTinkerFlags();
        TinkerRuntimeException tinkerRuntimeException;
        if (aVar2.status != -1) {
            tinkerRuntimeException = new TinkerRuntimeException("tinkerFlag is already set.");
            AppMethodBeat.o(65520);
            throw tinkerRuntimeException;
        }
        aVar2.status = tinkerFlags;
        if (cVar == null) {
            tinkerRuntimeException = new TinkerRuntimeException("loadReporter must not be null.");
            AppMethodBeat.o(65520);
            throw tinkerRuntimeException;
        } else if (aVar2.ABE != null) {
            tinkerRuntimeException = new TinkerRuntimeException("loadReporter is already set.");
            AppMethodBeat.o(65520);
            throw tinkerRuntimeException;
        } else {
            aVar2.ABE = cVar;
            if (bVar == null) {
                tinkerRuntimeException = new TinkerRuntimeException("listener must not be null.");
                AppMethodBeat.o(65520);
                throw tinkerRuntimeException;
            } else if (aVar2.ABD != null) {
                tinkerRuntimeException = new TinkerRuntimeException("listener is already set.");
                AppMethodBeat.o(65520);
                throw tinkerRuntimeException;
            } else {
                aVar2.ABD = bVar;
                if (dVar == null) {
                    tinkerRuntimeException = new TinkerRuntimeException("patchReporter must not be null.");
                    AppMethodBeat.o(65520);
                    throw tinkerRuntimeException;
                } else if (aVar2.ABF != null) {
                    tinkerRuntimeException = new TinkerRuntimeException("patchReporter is already set.");
                    AppMethodBeat.o(65520);
                    throw tinkerRuntimeException;
                } else {
                    aVar2.ABF = dVar;
                    Boolean valueOf = Boolean.valueOf(applicationLike.getTinkerLoadVerifyFlag());
                    if (valueOf == null) {
                        tinkerRuntimeException = new TinkerRuntimeException("tinkerLoadVerifyFlag must not be null.");
                        AppMethodBeat.o(65520);
                        throw tinkerRuntimeException;
                    } else if (aVar2.ABN != null) {
                        tinkerRuntimeException = new TinkerRuntimeException("tinkerLoadVerifyFlag is already set.");
                        AppMethodBeat.o(65520);
                        throw tinkerRuntimeException;
                    } else {
                        aVar2.ABN = valueOf;
                        com.tencent.tinker.lib.e.a dSh = aVar2.dSh();
                        com.tencent.tinker.lib.e.a.a(dSh);
                        Intent tinkerResultIntent = applicationLike.getTinkerResultIntent();
                        com.tencent.tinker.lib.e.a.ABB = true;
                        TinkerPatchService.a(aVar, cls);
                        com.tencent.tinker.lib.util.a.i("Tinker.Tinker", "try to install tinker, isEnable: %b, version: %s", Boolean.valueOf(ShareTinkerInternals.Se(dSh.tinkerFlags)), "1.9.10");
                        if (!ShareTinkerInternals.Se(dSh.tinkerFlags)) {
                            com.tencent.tinker.lib.util.a.e("Tinker.Tinker", "tinker is disabled", new Object[0]);
                        } else if (tinkerResultIntent == null) {
                            tinkerRuntimeException = new TinkerRuntimeException("intentResult must not be null.");
                            AppMethodBeat.o(65520);
                            throw tinkerRuntimeException;
                        } else {
                            String auq;
                            dSh.ABJ = new com.tencent.tinker.lib.e.d();
                            com.tencent.tinker.lib.e.d dVar2 = dSh.ABJ;
                            com.tencent.tinker.lib.e.a iX = com.tencent.tinker.lib.e.a.iX(dSh.context);
                            dVar2.ACc = ShareIntentUtil.be(tinkerResultIntent);
                            dVar2.iBv = ShareIntentUtil.bf(tinkerResultIntent);
                            dVar2.ABS = ShareIntentUtil.w(tinkerResultIntent, "intent_patch_system_ota");
                            dVar2.ABP = ShareIntentUtil.n(tinkerResultIntent, "intent_patch_oat_dir");
                            dVar2.ABR = "interpet".equals(dVar2.ABP);
                            boolean z = iX.rNw;
                            com.tencent.tinker.lib.util.a.i("Tinker.TinkerLoadResult", "parseTinkerResult loadCode:%d, process name:%s, main process:%b, systemOTA:%b, fingerPrint:%s, oatDir:%s, useInterpretMode:%b", Integer.valueOf(dVar2.ACc), ShareTinkerInternals.aD(r2), Boolean.valueOf(z), Boolean.valueOf(dVar2.ABS), Build.FINGERPRINT, dVar2.ABP, Boolean.valueOf(dVar2.ABR));
                            String n = ShareIntentUtil.n(tinkerResultIntent, "intent_patch_old_version");
                            String n2 = ShareIntentUtil.n(tinkerResultIntent, "intent_patch_new_version");
                            File file = iX.ABC;
                            File file2 = iX.ABG;
                            if (!(n == null || n2 == null)) {
                                if (z) {
                                    dVar2.ABO = n2;
                                } else {
                                    dVar2.ABO = n;
                                }
                                com.tencent.tinker.lib.util.a.i("Tinker.TinkerLoadResult", "parseTinkerResult oldVersion:%s, newVersion:%s, current:%s", n, n2, dVar2.ABO);
                                auq = SharePatchFileUtil.auq(dVar2.ABO);
                                if (!ShareTinkerInternals.isNullOrNil(auq)) {
                                    dVar2.ABT = new File(file.getAbsolutePath() + "/" + auq);
                                    dVar2.ABU = new File(dVar2.ABT.getAbsolutePath(), SharePatchFileUtil.aur(dVar2.ABO));
                                    dVar2.ABV = new File(dVar2.ABT, "dex");
                                    dVar2.ABW = new File(dVar2.ABT, "lib");
                                    dVar2.ABX = new File(dVar2.ABT, "res");
                                    dVar2.ABY = new File(dVar2.ABX, "resources.apk");
                                }
                                dVar2.patchInfo = new SharePatchInfo(n, n2, false, Build.FINGERPRINT, dVar2.ABP);
                                dVar2.ABQ = !n.equals(n2);
                            }
                            Throwable bg = ShareIntentUtil.bg(tinkerResultIntent);
                            if (bg == null) {
                                switch (dVar2.ACc) {
                                    case -10000:
                                        com.tencent.tinker.lib.util.a.e("Tinker.TinkerLoadResult", "can't get the right intent return code", new Object[0]);
                                        tinkerRuntimeException = new TinkerRuntimeException("can't get the right intent return code");
                                        AppMethodBeat.o(65520);
                                        throw tinkerRuntimeException;
                                    case DownloadResult.CODE_CONNECTION_EXCEPTION /*-24*/:
                                        if (dVar2.ABY != null) {
                                            com.tencent.tinker.lib.util.a.e("Tinker.TinkerLoadResult", "patch resource file md5 is mismatch: %s", dVar2.ABY.getAbsolutePath());
                                            iX.ABE.b(dVar2.ABY, 6);
                                            break;
                                        }
                                        com.tencent.tinker.lib.util.a.e("Tinker.TinkerLoadResult", "resource file md5 mismatch, but patch resource file not found!", new Object[0]);
                                        tinkerRuntimeException = new TinkerRuntimeException("resource file md5 mismatch, but patch resource file not found!");
                                        AppMethodBeat.o(65520);
                                        throw tinkerRuntimeException;
                                    case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
                                        if (dVar2.ABT != null) {
                                            com.tencent.tinker.lib.util.a.e("Tinker.TinkerLoadResult", "patch resource file not found:%s", dVar2.ABY.getAbsolutePath());
                                            iX.ABE.a(dVar2.ABY, 6, false);
                                            break;
                                        }
                                        com.tencent.tinker.lib.util.a.e("Tinker.TinkerLoadResult", "patch resource file not found, warning why the path is null!!!!", new Object[0]);
                                        tinkerRuntimeException = new TinkerRuntimeException("patch resource file not found, warning why the path is null!!!!");
                                        AppMethodBeat.o(65520);
                                        throw tinkerRuntimeException;
                                    case DownloadResult.CODE_URL_ERROR /*-21*/:
                                        if (dVar2.ABT != null) {
                                            com.tencent.tinker.lib.util.a.e("Tinker.TinkerLoadResult", "patch resource file directory not found:%s", dVar2.ABX.getAbsolutePath());
                                            iX.ABE.a(dVar2.ABX, 6, true);
                                            break;
                                        }
                                        com.tencent.tinker.lib.util.a.e("Tinker.TinkerLoadResult", "patch resource file directory not found, warning why the path is null!!!!", new Object[0]);
                                        tinkerRuntimeException = new TinkerRuntimeException("patch resource file directory not found, warning why the path is null!!!!");
                                        AppMethodBeat.o(65520);
                                        throw tinkerRuntimeException;
                                    case -19:
                                        com.tencent.tinker.lib.util.a.i("Tinker.TinkerLoadResult", "rewrite patch info file corrupted", new Object[0]);
                                        iX.ABE.a(n, n2, file2);
                                        break;
                                    case -18:
                                        auq = ShareIntentUtil.n(tinkerResultIntent, "intent_patch_missing_lib_path");
                                        if (auq != null) {
                                            com.tencent.tinker.lib.util.a.e("Tinker.TinkerLoadResult", "patch lib file not found:%s", auq);
                                            iX.ABE.a(new File(auq), 5, false);
                                            break;
                                        }
                                        com.tencent.tinker.lib.util.a.e("Tinker.TinkerLoadResult", "patch lib file not found, but path is null!!!!", new Object[0]);
                                        tinkerRuntimeException = new TinkerRuntimeException("patch lib file not found, but path is null!!!!");
                                        AppMethodBeat.o(65520);
                                        throw tinkerRuntimeException;
                                    case -17:
                                        if (dVar2.ABT != null) {
                                            com.tencent.tinker.lib.util.a.e("Tinker.TinkerLoadResult", "patch lib file directory not found:%s", dVar2.ABW.getAbsolutePath());
                                            iX.ABE.a(dVar2.ABW, 5, true);
                                            break;
                                        }
                                        com.tencent.tinker.lib.util.a.e("Tinker.TinkerLoadResult", "patch lib file directory not found, warning why the path is null!!!!", new Object[0]);
                                        tinkerRuntimeException = new TinkerRuntimeException("patch lib file directory not found, warning why the path is null!!!!");
                                        AppMethodBeat.o(65520);
                                        throw tinkerRuntimeException;
                                    case -16:
                                        iX.ABE.b(2, ShareIntentUtil.bh(tinkerResultIntent));
                                        break;
                                    case -15:
                                        iX.ABE.b(1, ShareIntentUtil.bh(tinkerResultIntent));
                                        break;
                                    case -13:
                                        auq = ShareIntentUtil.n(tinkerResultIntent, "intent_patch_mismatch_dex_path");
                                        if (auq != null) {
                                            com.tencent.tinker.lib.util.a.e("Tinker.TinkerLoadResult", "patch dex file md5 is mismatch: %s", auq);
                                            iX.ABE.b(new File(auq), 3);
                                            break;
                                        }
                                        com.tencent.tinker.lib.util.a.e("Tinker.TinkerLoadResult", "patch dex file md5 is mismatch, but path is null!!!!", new Object[0]);
                                        tinkerRuntimeException = new TinkerRuntimeException("patch dex file md5 is mismatch, but path is null!!!!");
                                        AppMethodBeat.o(65520);
                                        throw tinkerRuntimeException;
                                    case -12:
                                        com.tencent.tinker.lib.util.a.e("Tinker.TinkerLoadResult", "patch dex load fail, classloader is null", new Object[0]);
                                        break;
                                    case -11:
                                        auq = ShareIntentUtil.n(tinkerResultIntent, "intent_patch_missing_dex_path");
                                        if (auq != null) {
                                            com.tencent.tinker.lib.util.a.e("Tinker.TinkerLoadResult", "patch dex opt file not found:%s", auq);
                                            iX.ABE.a(new File(auq), 4, false);
                                            break;
                                        }
                                        com.tencent.tinker.lib.util.a.e("Tinker.TinkerLoadResult", "patch dex opt file not found, but path is null!!!!", new Object[0]);
                                        tinkerRuntimeException = new TinkerRuntimeException("patch dex opt file not found, but path is null!!!!");
                                        AppMethodBeat.o(65520);
                                        throw tinkerRuntimeException;
                                    case -10:
                                        auq = ShareIntentUtil.n(tinkerResultIntent, "intent_patch_missing_dex_path");
                                        if (auq != null) {
                                            com.tencent.tinker.lib.util.a.e("Tinker.TinkerLoadResult", "patch dex file not found:%s", auq);
                                            iX.ABE.a(new File(auq), 3, false);
                                            break;
                                        }
                                        com.tencent.tinker.lib.util.a.e("Tinker.TinkerLoadResult", "patch dex file not found, but path is null!!!!", new Object[0]);
                                        tinkerRuntimeException = new TinkerRuntimeException("patch dex file not found, but path is null!!!!");
                                        AppMethodBeat.o(65520);
                                        throw tinkerRuntimeException;
                                    case -9:
                                        if (dVar2.ABV != null) {
                                            com.tencent.tinker.lib.util.a.e("Tinker.TinkerLoadResult", "patch dex file directory not found:%s", dVar2.ABV.getAbsolutePath());
                                            iX.ABE.a(dVar2.ABV, 3, true);
                                            break;
                                        }
                                        com.tencent.tinker.lib.util.a.e("Tinker.TinkerLoadResult", "patch dex file directory not found, warning why the path is null!!!!", new Object[0]);
                                        tinkerRuntimeException = new TinkerRuntimeException("patch dex file directory not found, warning why the path is null!!!!");
                                        AppMethodBeat.o(65520);
                                        throw tinkerRuntimeException;
                                    case -8:
                                        com.tencent.tinker.lib.util.a.i("Tinker.TinkerLoadResult", "patch package check fail", new Object[0]);
                                        if (dVar2.ABU != null) {
                                            iX.ABE.c(dVar2.ABU, tinkerResultIntent.getIntExtra("intent_patch_package_patch_check", -10000));
                                            break;
                                        }
                                        tinkerRuntimeException = new TinkerRuntimeException("error patch package check fail , but file is null");
                                        AppMethodBeat.o(65520);
                                        throw tinkerRuntimeException;
                                    case -7:
                                        com.tencent.tinker.lib.util.a.e("Tinker.TinkerLoadResult", "patch version file not found, current version:%s", dVar2.ABO);
                                        if (dVar2.ABU != null) {
                                            iX.ABE.a(dVar2.ABU, 1, false);
                                            break;
                                        }
                                        tinkerRuntimeException = new TinkerRuntimeException("error load patch version file not exist, but file is null");
                                        AppMethodBeat.o(65520);
                                        throw tinkerRuntimeException;
                                    case -6:
                                        com.tencent.tinker.lib.util.a.e("Tinker.TinkerLoadResult", "patch version directory not found, current version:%s", dVar2.ABO);
                                        iX.ABE.a(dVar2.ABT, 1, true);
                                        break;
                                    case -5:
                                        com.tencent.tinker.lib.util.a.e("Tinker.TinkerLoadResult", "path info blank, wait main process to restart", new Object[0]);
                                        break;
                                    case -4:
                                        com.tencent.tinker.lib.util.a.e("Tinker.TinkerLoadResult", "path info corrupted", new Object[0]);
                                        iX.ABE.a(n, n2, file2);
                                        break;
                                    case -3:
                                    case -2:
                                        com.tencent.tinker.lib.util.a.w("Tinker.TinkerLoadResult", "can't find patch file, is ok, just return", new Object[0]);
                                        break;
                                    case -1:
                                        com.tencent.tinker.lib.util.a.w("Tinker.TinkerLoadResult", "tinker is disable, just return", new Object[0]);
                                        break;
                                    case 0:
                                        com.tencent.tinker.lib.util.a.i("Tinker.TinkerLoadResult", "oh yeah, tinker load all success", new Object[0]);
                                        iX.ABK = true;
                                        dVar2.ABZ = ShareIntentUtil.bi(tinkerResultIntent);
                                        dVar2.ACa = ShareIntentUtil.bj(tinkerResultIntent);
                                        dVar2.ACb = ShareIntentUtil.bk(tinkerResultIntent);
                                        if (dVar2.ABR) {
                                            iX.ABE.b(0, null);
                                        }
                                        if (z && dVar2.ABQ) {
                                            iX.ABE.a(n, n2, file, dVar2.ABT.getName());
                                            break;
                                        }
                                }
                            }
                            com.tencent.tinker.lib.util.a.i("Tinker.TinkerLoadResult", "Tinker load have exception loadCode:%d", Integer.valueOf(dVar2.ACc));
                            int i = -1;
                            switch (dVar2.ACc) {
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
                            iX.ABE.a(bg, i);
                            dSh.ABE.a(dSh.ABC, dSh.ABJ.ACc, dSh.ABJ.iBv);
                            if (!dSh.ABK) {
                                com.tencent.tinker.lib.util.a.w("Tinker.Tinker", "tinker load fail!", new Object[0]);
                            }
                        }
                        this.ATR = dSh;
                        AppMethodBeat.o(65520);
                    }
                }
            }
        }
    }

    public static a dWj() {
        AppMethodBeat.i(65521);
        if (ATQ == null) {
            TinkerRuntimeException tinkerRuntimeException = new TinkerRuntimeException("you must init TinkerClient sdk first");
            AppMethodBeat.o(65521);
            throw tinkerRuntimeException;
        }
        a aVar = ATQ;
        AppMethodBeat.o(65521);
        return aVar;
    }

    public final a rF(final boolean z) {
        AppMethodBeat.i(65522);
        a aVar;
        if (this.ATS == null || this.ATR == null) {
            com.tencent.tinker.lib.util.a.e("Tinker.TinkerClient", "fetchPatchUpdate, tinkerServerClient or tinkerClient is null, just return", new Object[0]);
            aVar = ATQ;
            AppMethodBeat.o(65522);
            return aVar;
        }
        Context context = com.tinkerboots.sdk.b.c.getContext();
        if (!com.tinkerboots.sdk.b.b.jG(context)) {
            com.tencent.tinker.lib.util.a.e("Tinker.TinkerClient", "fetchPatchUpdate, permission refuse, you must access INTERNET and ACCESS_NETWORK_STATE permission first", new Object[0]);
            aVar = ATQ;
            AppMethodBeat.o(65522);
            return aVar;
        } else if (ShareTinkerInternals.Se(this.ATR.tinkerFlags) && ShareTinkerInternals.jn(context)) {
            if (this.ATR.rNw) {
                Looper.getMainLooper();
                Looper.myQueue().addIdleHandler(new IdleHandler() {
                    public final boolean queueIdle() {
                        AppMethodBeat.i(65518);
                        com.tinkerboots.sdk.a.a aVar = a.this.ATS;
                        boolean z = z;
                        SharedPreferences sharedPreferences = com.tinkerboots.sdk.b.c.getContext().getSharedPreferences("patch_server_config", 0);
                        long j = sharedPreferences.getLong("fetch_patch_last_check", 0);
                        if (j == -1) {
                            com.tencent.tinker.lib.util.a.i("Tinker.ServerClient", "tinker sync is disabled, with never check flag!", new Object[0]);
                        } else {
                            j = System.currentTimeMillis() - j;
                            if (z || aVar.isDebug || j >= aVar.hgu) {
                                sharedPreferences.edit().putLong("fetch_patch_last_check", System.currentTimeMillis()).commit();
                                com.tinkerboots.sdk.a.b.a aVar2 = aVar.ATZ;
                                com.tinkerboots.sdk.a.a.b bVar = aVar.ATX;
                                if (bVar == null) {
                                    RuntimeException runtimeException = new RuntimeException("callback can't be null");
                                    AppMethodBeat.o(65518);
                                    throw runtimeException;
                                } else if (bVar.bGs()) {
                                    bVar.bGt();
                                    bVar.L(aVar2.AUa.AUb);
                                }
                            } else {
                                com.tencent.tinker.lib.util.a.i("Tinker.ServerClient", "tinker sync should wait interval %ss", Long.valueOf((aVar.hgu - j) / 1000));
                            }
                        }
                        AppMethodBeat.o(65518);
                        return false;
                    }
                });
            }
            aVar = ATQ;
            AppMethodBeat.o(65522);
            return aVar;
        } else {
            com.tencent.tinker.lib.util.a.e("Tinker.TinkerClient", "fetchPatchUpdate, tinker is disable, just return", new Object[0]);
            aVar = ATQ;
            AppMethodBeat.o(65522);
            return aVar;
        }
    }

    public final a iN(String str, String str2) {
        AppMethodBeat.i(65523);
        a aVar;
        if (this.ATS == null) {
            com.tencent.tinker.lib.util.a.e("Tinker.TinkerClient", "setPatchCondition, tinkerServerClient == null, just return", new Object[0]);
            aVar = ATQ;
            AppMethodBeat.o(65523);
            return aVar;
        }
        com.tencent.tinker.lib.util.a.i("Tinker.TinkerClient", "setPatchCondition %s with value %s", str, str2);
        this.ATS.iO(str, str2);
        aVar = ATQ;
        AppMethodBeat.o(65523);
        return aVar;
    }

    public final a SG(int i) {
        AppMethodBeat.i(65524);
        a aVar;
        if (this.ATS == null) {
            com.tencent.tinker.lib.util.a.e("Tinker.TinkerClient", "setFetchPatchIntervalByHours, tinkerServerClient == null, just return", new Object[0]);
            aVar = ATQ;
            AppMethodBeat.o(65524);
            return aVar;
        }
        com.tencent.tinker.lib.util.a.i("Tinker.TinkerClient", "setFetchPatchIntervalByHours to %d hours", Integer.valueOf(i));
        this.ATS.SH(i);
        aVar = ATQ;
        AppMethodBeat.o(65524);
        return aVar;
    }
}
