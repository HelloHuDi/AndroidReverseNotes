package com.tencent.mm.plugin.hp.b;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import com.tencent.ttpic.util.FaceMoveUtil;
import com.tencent.view.d;
import com.tenpay.android.wechat.PayuSecureEncrypt.EncrptType;

public final class b {
    private static long ntt = 0;

    public enum b {
        SCENE_PATCH(0),
        SCENE_LOAD(1),
        SCENE_CHECK(2);
        
        public final int value;

        static {
            AppMethodBeat.o(90554);
        }

        private b(int i) {
            this.value = i;
        }
    }

    public enum a {
        FAILED(0),
        SUCCESS(1);
        
        public final int value;

        static {
            AppMethodBeat.o(90551);
        }

        private a(int i) {
            this.value = i;
        }
    }

    public static void bGf() {
        AppMethodBeat.i(90555);
        h.pYm.a(338, 9, 1, false);
        AppMethodBeat.o(90555);
    }

    public static void wW(int i) {
        AppMethodBeat.i(90556);
        ab.i("Tinker.HotPatchReportHelper", "hp_report new hotpatch requested");
        switch (i) {
            case 0:
                h.pYm.a(338, 0, 1, false);
                break;
            case 1:
                h.pYm.a(338, 20, 1, false);
                break;
            case 2:
                h.pYm.a(614, 0, 1, false);
                break;
        }
        ntt = bo.yz();
        AppMethodBeat.o(90556);
    }

    public static void wX(int i) {
        AppMethodBeat.i(90557);
        long az = bo.az(ntt);
        ab.i("Tinker.HotPatchReportHelper", "hp_report report download cost = %d", Long.valueOf(az));
        switch (i) {
            case 1:
                h.pYm.a(338, 40, 1, false);
                break;
        }
        if (az < 0) {
            ab.e("Tinker.HotPatchReportHelper", "hp_report report download cost failed, invalid cost");
            AppMethodBeat.o(90557);
        } else if (az <= 5000) {
            h.pYm.ag(338, 1, 43);
            AppMethodBeat.o(90557);
        } else if (az <= 60000) {
            h.pYm.ag(338, 1, 44);
            AppMethodBeat.o(90557);
        } else if (az <= 180000) {
            h.pYm.ag(338, 1, 45);
            AppMethodBeat.o(90557);
        } else {
            h.pYm.ag(338, 1, 46);
            AppMethodBeat.o(90557);
        }
    }

    public static void wY(int i) {
        AppMethodBeat.i(90558);
        ab.i("Tinker.HotPatchReportHelper", "hp_report download failed");
        switch (i) {
            case 0:
                h.pYm.a(338, 41, 1, false);
                AppMethodBeat.o(90558);
                return;
            case 1:
                h.pYm.a(338, 42, 1, false);
                AppMethodBeat.o(90558);
                return;
            case 2:
                h.pYm.a(614, 3, 1, false);
                break;
        }
        AppMethodBeat.o(90558);
    }

    public static void ie(boolean z) {
        AppMethodBeat.i(90559);
        ab.i("Tinker.HotPatchReportHelper", "hp_report try to apply hotpatch");
        h.pYm.ag(338, 2, 71);
        if (z) {
            h.pYm.a(338, 7, 1, true);
        }
        AppMethodBeat.o(90559);
    }

    public static void wZ(int i) {
        AppMethodBeat.i(90560);
        ab.i("Tinker.HotPatchReportHelper", "hp_report try to apply hotpatch fail");
        switch (i) {
            case DownloadResult.CODE_SOCKET_EXCEPTION /*-26*/:
                h.pYm.a(338, 83, 1, false);
                AppMethodBeat.o(90560);
                return;
            case DownloadResult.CODE_SOCKET_TIMEOUT_EXCEPTION /*-25*/:
                h.pYm.a(338, 82, 1, false);
                AppMethodBeat.o(90560);
                return;
            case DownloadResult.CODE_CONNECTION_EXCEPTION /*-24*/:
                h.pYm.a(338, 81, 1, false);
                AppMethodBeat.o(90560);
                return;
            case DownloadResult.CODE_CONNECTION_TIMEOUT_EXCEPTION /*-23*/:
                h.pYm.a(338, 79, 1, false);
                AppMethodBeat.o(90560);
                return;
            case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
                h.pYm.a(338, 80, 1, false);
                AppMethodBeat.o(90560);
                return;
            case DownloadResult.CODE_URL_ERROR /*-21*/:
                h.pYm.a(338, 77, 1, false);
                AppMethodBeat.o(90560);
                return;
            case EncrptType.HASHED_SECRET_ANSWER /*-20*/:
                h.pYm.a(338, 76, 1, false);
                AppMethodBeat.o(90560);
                return;
            case -7:
                h.pYm.a(338, 84, 1, false);
                break;
            case -6:
                h.pYm.a(338, 78, 1, false);
                AppMethodBeat.o(90560);
                return;
            case -5:
                h.pYm.a(338, 85, 1, false);
                AppMethodBeat.o(90560);
                return;
            case -4:
                h.pYm.a(338, 74, 1, false);
                AppMethodBeat.o(90560);
                return;
            case -3:
                h.pYm.a(338, 73, 1, false);
                AppMethodBeat.o(90560);
                return;
            case -2:
                h.pYm.a(338, 75, 1, false);
                AppMethodBeat.o(90560);
                return;
            case -1:
                h.pYm.a(338, 72, 1, false);
                AppMethodBeat.o(90560);
                return;
        }
        AppMethodBeat.o(90560);
    }

    public static void ac(Intent intent) {
        AppMethodBeat.i(90561);
        KVCommCrossProcessReceiver.cgj();
        ab.i("Tinker.HotPatchReportHelper", "hp_report try to apply patch service start");
        if (intent == null) {
            h.pYm.ag(338, 6, d.MIC_SketchMark);
            AppMethodBeat.o(90561);
        } else if (ShareIntentUtil.n(intent, "patch_path_extra") == null) {
            h.pYm.ag(338, 6, 128);
            AppMethodBeat.o(90561);
        } else {
            h.pYm.a(338, 6, 1, true);
            AppMethodBeat.o(90561);
        }
    }

    public static void r(long j, boolean z) {
        AppMethodBeat.i(90562);
        if (z) {
            h.pYm.a(338, 3, 1, true);
        }
        if (z) {
            h.pYm.a(338, 101, 1, false);
        } else {
            h.pYm.a(338, 103, 1, false);
        }
        ab.i("Tinker.HotPatchReportHelper", "hp_report report apply cost = %d", Long.valueOf(j));
        if (j < 0) {
            ab.e("Tinker.HotPatchReportHelper", "hp_report report apply cost failed, invalid cost");
            AppMethodBeat.o(90562);
        } else if (j <= 5000) {
            if (z) {
                h.pYm.a(338, 117, 1, false);
                AppMethodBeat.o(90562);
                return;
            }
            h.pYm.a(338, 122, 1, false);
            AppMethodBeat.o(90562);
        } else if (j <= 10000) {
            if (z) {
                h.pYm.a(338, 118, 1, false);
                AppMethodBeat.o(90562);
                return;
            }
            h.pYm.a(338, 123, 1, false);
            AppMethodBeat.o(90562);
        } else if (j <= 30000) {
            if (z) {
                h.pYm.a(338, 119, 1, false);
                AppMethodBeat.o(90562);
                return;
            }
            h.pYm.a(338, 124, 1, false);
            AppMethodBeat.o(90562);
        } else if (j > 60000) {
            if (j >= 3600000) {
                h.pYm.a(338, 133, 1, false);
            }
            if (z) {
                h.pYm.a(338, 121, 1, false);
                AppMethodBeat.o(90562);
                return;
            }
            h.pYm.a(338, 126, 1, false);
            AppMethodBeat.o(90562);
        } else if (z) {
            h.pYm.a(338, 120, 1, false);
            AppMethodBeat.o(90562);
        } else {
            h.pYm.a(338, 125, 1, false);
            AppMethodBeat.o(90562);
        }
    }

    public static void xa(int i) {
        AppMethodBeat.i(90563);
        ab.i("Tinker.HotPatchReportHelper", "hp_report package check failed, error = %d", Integer.valueOf(i));
        switch (i) {
            case -8:
                h.pYm.ag(338, 107, 131);
                break;
            case -7:
                h.pYm.ag(338, 107, 113);
                AppMethodBeat.o(90563);
                return;
            case -6:
                h.pYm.ag(338, 107, 112);
                AppMethodBeat.o(90563);
                return;
            case -5:
                h.pYm.ag(338, 107, 111);
                AppMethodBeat.o(90563);
                return;
            case -4:
                h.pYm.ag(338, 107, 110);
                AppMethodBeat.o(90563);
                return;
            case -3:
                h.pYm.ag(338, 107, 109);
                AppMethodBeat.o(90563);
                return;
            case -2:
                h.pYm.ag(338, 107, GmsClientSupervisor.DEFAULT_BIND_FLAGS);
                AppMethodBeat.o(90563);
                return;
            case -1:
                h.pYm.ag(338, 107, 108);
                AppMethodBeat.o(90563);
                return;
        }
        AppMethodBeat.o(90563);
    }

    public static void h(Throwable th) {
        AppMethodBeat.i(90564);
        h.pYm.a(338, 104, 1, false);
        h.pYm.g("Tinker", "Tinker Exception:apply tinker occur unknown exception " + ao.m(th), null);
        AppMethodBeat.o(90564);
    }

    public static void i(Throwable th) {
        AppMethodBeat.i(90565);
        if (th.getMessage().contains("checkDexOptExist failed")) {
            h.pYm.a(338, 134, 1, false);
            AppMethodBeat.o(90565);
        } else if (th.getMessage().contains("checkDexOptFormat failed")) {
            h.pYm.a(338, 135, 1, false);
            h.pYm.g("Tinker", "Tinker Exception:apply tinker occur dexOpt format exception " + ao.m(th), null);
            AppMethodBeat.o(90565);
        } else {
            h.pYm.a(338, 105, 1, false);
            h.pYm.g("Tinker", "Tinker Exception:apply tinker occur dexOpt exception " + ao.m(th), null);
            AppMethodBeat.o(90565);
        }
    }

    public static void bGg() {
        AppMethodBeat.i(90566);
        h.pYm.a(338, 106, 1, false);
        AppMethodBeat.o(90566);
    }

    public static void bGh() {
        AppMethodBeat.i(90567);
        h.pYm.a(338, 116, 1, false);
        AppMethodBeat.o(90567);
    }

    public static void xb(int i) {
        AppMethodBeat.i(90568);
        switch (i) {
            case 1:
                h.pYm.a(338, 130, 1, false);
                AppMethodBeat.o(90568);
                return;
            case 3:
                h.pYm.a(338, 114, 1, false);
                AppMethodBeat.o(90568);
                return;
            case 5:
                h.pYm.a(338, 115, 1, false);
                AppMethodBeat.o(90568);
                return;
            case 6:
                h.pYm.a(338, 132, 1, false);
                AppMethodBeat.o(90568);
                return;
            case 7:
                h.pYm.a(338, 136, 1, false);
                break;
        }
        AppMethodBeat.o(90568);
    }

    public static void s(long j, boolean z) {
        AppMethodBeat.i(90569);
        h.pYm.a(338, 4, 1, false);
        if (z) {
            ab.i("Tinker.HotPatchReportHelper", "hp_report report load cost = %d", Long.valueOf(j));
            if (j < 0) {
                ab.e("Tinker.HotPatchReportHelper", "hp_report report load cost failed, invalid cost");
                AppMethodBeat.o(90569);
                return;
            } else if (j <= 500) {
                h.pYm.a(338, 177, 1, false);
                AppMethodBeat.o(90569);
                return;
            } else if (j <= 1000) {
                h.pYm.a(338, 178, 1, false);
                AppMethodBeat.o(90569);
                return;
            } else if (j <= 3000) {
                h.pYm.a(338, 179, 1, false);
                AppMethodBeat.o(90569);
                return;
            } else if (j <= 5000) {
                h.pYm.a(338, 180, 1, false);
                AppMethodBeat.o(90569);
                return;
            } else {
                h.pYm.a(338, 181, 1, false);
                AppMethodBeat.o(90569);
                return;
            }
        }
        h.pYm.a(338, 159, 1, false);
        AppMethodBeat.o(90569);
    }

    public static void a(Throwable th, int i) {
        boolean z = false;
        AppMethodBeat.i(90570);
        switch (i) {
            case -4:
                h.pYm.a(338, 188, 1, false);
                break;
            case -3:
                if (!th.getMessage().contains("checkResInstall failed")) {
                    h.pYm.a(338, 184, 1, false);
                    break;
                }
                h.pYm.a(338, 190, 1, false);
                z = true;
                break;
            case -2:
                if (!th.getMessage().contains("checkDexInstall failed")) {
                    h.pYm.a(338, 161, 1, false);
                    ab.e("Tinker.HotPatchReportHelper", "tinker dex reflect fail:" + th.getMessage());
                    break;
                }
                h.pYm.a(338, 189, 1, false);
                ab.i("Tinker.HotPatchReportHelper", "tinker dex check fail:" + th.getMessage());
                z = true;
                break;
            case -1:
                h.pYm.a(338, 160, 1, false);
                break;
        }
        if (!z) {
            Object m = ao.m(th);
            if (i == -4) {
                Context context = ah.getContext();
                String jk = SharePatchFileUtil.jk(context);
                if (!ShareTinkerInternals.isNullOrNil(jk)) {
                    m = "tinker checkSafeModeCount fail:\n".concat(String.valueOf(jk));
                    SharePatchFileUtil.as(SharePatchFileUtil.jj(context));
                }
            }
            h.pYm.g("Tinker", "Tinker Exception:load tinker occur exception ".concat(String.valueOf(m)), null);
        }
        AppMethodBeat.o(90570);
    }

    public static void t(boolean z, int i) {
        AppMethodBeat.i(90571);
        ab.i("Tinker.HotPatchReportHelper", "hp_report package check failed, error = %d", Integer.valueOf(i));
        if (z) {
            h.pYm.a(338, 170, 1, false);
        }
        switch (i) {
            case -8:
                h.pYm.ag(338, 169, 186);
                break;
            case -7:
                h.pYm.ag(338, 169, ErrorCode.NEEDDOWNLOAD_FALSE_6);
                AppMethodBeat.o(90571);
                return;
            case -6:
                h.pYm.ag(338, 169, ErrorCode.NEEDDOWNLOAD_FALSE_5);
                AppMethodBeat.o(90571);
                return;
            case -5:
                h.pYm.ag(338, 169, ErrorCode.NEEDDOWNLOAD_FALSE_4);
                AppMethodBeat.o(90571);
                return;
            case -4:
                h.pYm.ag(338, 169, ErrorCode.NEEDDOWNLOAD_FALSE_3);
                AppMethodBeat.o(90571);
                return;
            case -3:
                h.pYm.ag(338, 169, ErrorCode.NEEDDOWNLOAD_FALSE_2);
                AppMethodBeat.o(90571);
                return;
            case -2:
                h.pYm.ag(338, 107, FaceMoveUtil.TRIANGLE_COUNT);
                AppMethodBeat.o(90571);
                return;
            case -1:
                h.pYm.ag(338, 169, ErrorCode.NEEDDOWNLOAD_FALSE_1);
                AppMethodBeat.o(90571);
                return;
        }
        AppMethodBeat.o(90571);
    }

    public static void xc(int i) {
        AppMethodBeat.i(90572);
        switch (i) {
            case 1:
                h.pYm.a(338, 166, 1, false);
                AppMethodBeat.o(90572);
                return;
            case 2:
                h.pYm.a(338, 167, 1, false);
                AppMethodBeat.o(90572);
                return;
            case 3:
                h.pYm.a(338, 164, 1, false);
                AppMethodBeat.o(90572);
                return;
            case 4:
                h.pYm.a(338, 183, 1, false);
                AppMethodBeat.o(90572);
                return;
            case 5:
                h.pYm.a(338, 165, 1, false);
                AppMethodBeat.o(90572);
                return;
            case 6:
                h.pYm.a(338, 187, 1, false);
                break;
        }
        AppMethodBeat.o(90572);
    }

    public static void xd(int i) {
        AppMethodBeat.i(90573);
        switch (i) {
            case 3:
                h.pYm.a(338, 162, 1, false);
                AppMethodBeat.o(90573);
                return;
            case 5:
                h.pYm.a(338, 163, 1, false);
                AppMethodBeat.o(90573);
                return;
            case 6:
                h.pYm.a(338, 185, 1, false);
                break;
        }
        AppMethodBeat.o(90573);
    }

    public static void bGi() {
        AppMethodBeat.i(90574);
        h.pYm.a(338, 168, 1, false);
        AppMethodBeat.o(90574);
    }

    public static void bGj() {
        AppMethodBeat.i(90575);
        h.pYm.a(338, 5, 1, false);
        AppMethodBeat.o(90575);
    }

    public static void a(int i, Throwable th) {
        AppMethodBeat.i(90576);
        switch (i) {
            case 0:
                h.pYm.a(338, 193, 1, false);
                break;
            case 1:
                h.pYm.a(338, 191, 1, false);
                h.pYm.g("Tinker", "Tinker Exception:interpret occur instruction exception " + ao.m(th), null);
                AppMethodBeat.o(90576);
                return;
            case 2:
                h.pYm.a(338, 192, 1, false);
                h.pYm.g("Tinker", "Tinker Exception:interpret occur command exception " + ao.m(th), null);
                AppMethodBeat.o(90576);
                return;
        }
        AppMethodBeat.o(90576);
    }

    public static void e(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.i(90577);
        h.pYm.e(15974, str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2), Boolean.FALSE);
        ab.i("Tinker.HotPatchReportHelper", "CodeVersion:%s PatchVersion:%s TinkerId:%s Scene:%d Result:%d", str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.o(90577);
    }
}
