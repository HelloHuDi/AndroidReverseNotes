package com.tencent.p177mm.plugin.p436hp.p437b;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.report.service.KVCommCrossProcessReceiver;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5013ao;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import com.tencent.ttpic.util.FaceMoveUtil;
import com.tencent.view.C31128d;
import com.tenpay.android.wechat.PayuSecureEncrypt.EncrptType;

/* renamed from: com.tencent.mm.plugin.hp.b.b */
public final class C46028b {
    private static long ntt = 0;

    /* renamed from: com.tencent.mm.plugin.hp.b.b$b */
    public enum C12240b {
        SCENE_PATCH(0),
        SCENE_LOAD(1),
        SCENE_CHECK(2);
        
        public final int value;

        static {
            AppMethodBeat.m2505o(90554);
        }

        private C12240b(int i) {
            this.value = i;
        }
    }

    /* renamed from: com.tencent.mm.plugin.hp.b.b$a */
    public enum C46027a {
        FAILED(0),
        SUCCESS(1);
        
        public final int value;

        static {
            AppMethodBeat.m2505o(90551);
        }

        private C46027a(int i) {
            this.value = i;
        }
    }

    public static void bGf() {
        AppMethodBeat.m2504i(90555);
        C7060h.pYm.mo8378a(338, 9, 1, false);
        AppMethodBeat.m2505o(90555);
    }

    /* renamed from: wW */
    public static void m85603wW(int i) {
        AppMethodBeat.m2504i(90556);
        C4990ab.m7416i("Tinker.HotPatchReportHelper", "hp_report new hotpatch requested");
        switch (i) {
            case 0:
                C7060h.pYm.mo8378a(338, 0, 1, false);
                break;
            case 1:
                C7060h.pYm.mo8378a(338, 20, 1, false);
                break;
            case 2:
                C7060h.pYm.mo8378a(614, 0, 1, false);
                break;
        }
        ntt = C5046bo.m7588yz();
        AppMethodBeat.m2505o(90556);
    }

    /* renamed from: wX */
    public static void m85604wX(int i) {
        AppMethodBeat.m2504i(90557);
        long az = C5046bo.m7525az(ntt);
        C4990ab.m7417i("Tinker.HotPatchReportHelper", "hp_report report download cost = %d", Long.valueOf(az));
        switch (i) {
            case 1:
                C7060h.pYm.mo8378a(338, 40, 1, false);
                break;
        }
        if (az < 0) {
            C4990ab.m7412e("Tinker.HotPatchReportHelper", "hp_report report download cost failed, invalid cost");
            AppMethodBeat.m2505o(90557);
        } else if (az <= 5000) {
            C7060h.pYm.mo15416ag(338, 1, 43);
            AppMethodBeat.m2505o(90557);
        } else if (az <= 60000) {
            C7060h.pYm.mo15416ag(338, 1, 44);
            AppMethodBeat.m2505o(90557);
        } else if (az <= 180000) {
            C7060h.pYm.mo15416ag(338, 1, 45);
            AppMethodBeat.m2505o(90557);
        } else {
            C7060h.pYm.mo15416ag(338, 1, 46);
            AppMethodBeat.m2505o(90557);
        }
    }

    /* renamed from: wY */
    public static void m85605wY(int i) {
        AppMethodBeat.m2504i(90558);
        C4990ab.m7416i("Tinker.HotPatchReportHelper", "hp_report download failed");
        switch (i) {
            case 0:
                C7060h.pYm.mo8378a(338, 41, 1, false);
                AppMethodBeat.m2505o(90558);
                return;
            case 1:
                C7060h.pYm.mo8378a(338, 42, 1, false);
                AppMethodBeat.m2505o(90558);
                return;
            case 2:
                C7060h.pYm.mo8378a(614, 3, 1, false);
                break;
        }
        AppMethodBeat.m2505o(90558);
    }

    /* renamed from: ie */
    public static void m85599ie(boolean z) {
        AppMethodBeat.m2504i(90559);
        C4990ab.m7416i("Tinker.HotPatchReportHelper", "hp_report try to apply hotpatch");
        C7060h.pYm.mo15416ag(338, 2, 71);
        if (z) {
            C7060h.pYm.mo8378a(338, 7, 1, true);
        }
        AppMethodBeat.m2505o(90559);
    }

    /* renamed from: wZ */
    public static void m85606wZ(int i) {
        AppMethodBeat.m2504i(90560);
        C4990ab.m7416i("Tinker.HotPatchReportHelper", "hp_report try to apply hotpatch fail");
        switch (i) {
            case DownloadResult.CODE_SOCKET_EXCEPTION /*-26*/:
                C7060h.pYm.mo8378a(338, 83, 1, false);
                AppMethodBeat.m2505o(90560);
                return;
            case DownloadResult.CODE_SOCKET_TIMEOUT_EXCEPTION /*-25*/:
                C7060h.pYm.mo8378a(338, 82, 1, false);
                AppMethodBeat.m2505o(90560);
                return;
            case DownloadResult.CODE_CONNECTION_EXCEPTION /*-24*/:
                C7060h.pYm.mo8378a(338, 81, 1, false);
                AppMethodBeat.m2505o(90560);
                return;
            case DownloadResult.CODE_CONNECTION_TIMEOUT_EXCEPTION /*-23*/:
                C7060h.pYm.mo8378a(338, 79, 1, false);
                AppMethodBeat.m2505o(90560);
                return;
            case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
                C7060h.pYm.mo8378a(338, 80, 1, false);
                AppMethodBeat.m2505o(90560);
                return;
            case DownloadResult.CODE_URL_ERROR /*-21*/:
                C7060h.pYm.mo8378a(338, 77, 1, false);
                AppMethodBeat.m2505o(90560);
                return;
            case EncrptType.HASHED_SECRET_ANSWER /*-20*/:
                C7060h.pYm.mo8378a(338, 76, 1, false);
                AppMethodBeat.m2505o(90560);
                return;
            case -7:
                C7060h.pYm.mo8378a(338, 84, 1, false);
                break;
            case -6:
                C7060h.pYm.mo8378a(338, 78, 1, false);
                AppMethodBeat.m2505o(90560);
                return;
            case -5:
                C7060h.pYm.mo8378a(338, 85, 1, false);
                AppMethodBeat.m2505o(90560);
                return;
            case -4:
                C7060h.pYm.mo8378a(338, 74, 1, false);
                AppMethodBeat.m2505o(90560);
                return;
            case -3:
                C7060h.pYm.mo8378a(338, 73, 1, false);
                AppMethodBeat.m2505o(90560);
                return;
            case -2:
                C7060h.pYm.mo8378a(338, 75, 1, false);
                AppMethodBeat.m2505o(90560);
                return;
            case -1:
                C7060h.pYm.mo8378a(338, 72, 1, false);
                AppMethodBeat.m2505o(90560);
                return;
        }
        AppMethodBeat.m2505o(90560);
    }

    /* renamed from: ac */
    public static void m85595ac(Intent intent) {
        AppMethodBeat.m2504i(90561);
        KVCommCrossProcessReceiver.cgj();
        C4990ab.m7416i("Tinker.HotPatchReportHelper", "hp_report try to apply patch service start");
        if (intent == null) {
            C7060h.pYm.mo15416ag(338, 6, C31128d.MIC_SketchMark);
            AppMethodBeat.m2505o(90561);
        } else if (ShareIntentUtil.m9362n(intent, "patch_path_extra") == null) {
            C7060h.pYm.mo15416ag(338, 6, 128);
            AppMethodBeat.m2505o(90561);
        } else {
            C7060h.pYm.mo8378a(338, 6, 1, true);
            AppMethodBeat.m2505o(90561);
        }
    }

    /* renamed from: r */
    public static void m85600r(long j, boolean z) {
        AppMethodBeat.m2504i(90562);
        if (z) {
            C7060h.pYm.mo8378a(338, 3, 1, true);
        }
        if (z) {
            C7060h.pYm.mo8378a(338, 101, 1, false);
        } else {
            C7060h.pYm.mo8378a(338, 103, 1, false);
        }
        C4990ab.m7417i("Tinker.HotPatchReportHelper", "hp_report report apply cost = %d", Long.valueOf(j));
        if (j < 0) {
            C4990ab.m7412e("Tinker.HotPatchReportHelper", "hp_report report apply cost failed, invalid cost");
            AppMethodBeat.m2505o(90562);
        } else if (j <= 5000) {
            if (z) {
                C7060h.pYm.mo8378a(338, 117, 1, false);
                AppMethodBeat.m2505o(90562);
                return;
            }
            C7060h.pYm.mo8378a(338, 122, 1, false);
            AppMethodBeat.m2505o(90562);
        } else if (j <= 10000) {
            if (z) {
                C7060h.pYm.mo8378a(338, 118, 1, false);
                AppMethodBeat.m2505o(90562);
                return;
            }
            C7060h.pYm.mo8378a(338, 123, 1, false);
            AppMethodBeat.m2505o(90562);
        } else if (j <= 30000) {
            if (z) {
                C7060h.pYm.mo8378a(338, 119, 1, false);
                AppMethodBeat.m2505o(90562);
                return;
            }
            C7060h.pYm.mo8378a(338, 124, 1, false);
            AppMethodBeat.m2505o(90562);
        } else if (j > 60000) {
            if (j >= 3600000) {
                C7060h.pYm.mo8378a(338, 133, 1, false);
            }
            if (z) {
                C7060h.pYm.mo8378a(338, 121, 1, false);
                AppMethodBeat.m2505o(90562);
                return;
            }
            C7060h.pYm.mo8378a(338, 126, 1, false);
            AppMethodBeat.m2505o(90562);
        } else if (z) {
            C7060h.pYm.mo8378a(338, 120, 1, false);
            AppMethodBeat.m2505o(90562);
        } else {
            C7060h.pYm.mo8378a(338, 125, 1, false);
            AppMethodBeat.m2505o(90562);
        }
    }

    /* renamed from: xa */
    public static void m85607xa(int i) {
        AppMethodBeat.m2504i(90563);
        C4990ab.m7417i("Tinker.HotPatchReportHelper", "hp_report package check failed, error = %d", Integer.valueOf(i));
        switch (i) {
            case -8:
                C7060h.pYm.mo15416ag(338, 107, 131);
                break;
            case -7:
                C7060h.pYm.mo15416ag(338, 107, 113);
                AppMethodBeat.m2505o(90563);
                return;
            case -6:
                C7060h.pYm.mo15416ag(338, 107, 112);
                AppMethodBeat.m2505o(90563);
                return;
            case -5:
                C7060h.pYm.mo15416ag(338, 107, 111);
                AppMethodBeat.m2505o(90563);
                return;
            case -4:
                C7060h.pYm.mo15416ag(338, 107, 110);
                AppMethodBeat.m2505o(90563);
                return;
            case -3:
                C7060h.pYm.mo15416ag(338, 107, 109);
                AppMethodBeat.m2505o(90563);
                return;
            case -2:
                C7060h.pYm.mo15416ag(338, 107, GmsClientSupervisor.DEFAULT_BIND_FLAGS);
                AppMethodBeat.m2505o(90563);
                return;
            case -1:
                C7060h.pYm.mo15416ag(338, 107, 108);
                AppMethodBeat.m2505o(90563);
                return;
        }
        AppMethodBeat.m2505o(90563);
    }

    /* renamed from: h */
    public static void m85597h(Throwable th) {
        AppMethodBeat.m2504i(90564);
        C7060h.pYm.mo8378a(338, 104, 1, false);
        C7060h.pYm.mo8382g("Tinker", "Tinker Exception:apply tinker occur unknown exception " + C5013ao.m7460m(th), null);
        AppMethodBeat.m2505o(90564);
    }

    /* renamed from: i */
    public static void m85598i(Throwable th) {
        AppMethodBeat.m2504i(90565);
        if (th.getMessage().contains("checkDexOptExist failed")) {
            C7060h.pYm.mo8378a(338, 134, 1, false);
            AppMethodBeat.m2505o(90565);
        } else if (th.getMessage().contains("checkDexOptFormat failed")) {
            C7060h.pYm.mo8378a(338, 135, 1, false);
            C7060h.pYm.mo8382g("Tinker", "Tinker Exception:apply tinker occur dexOpt format exception " + C5013ao.m7460m(th), null);
            AppMethodBeat.m2505o(90565);
        } else {
            C7060h.pYm.mo8378a(338, 105, 1, false);
            C7060h.pYm.mo8382g("Tinker", "Tinker Exception:apply tinker occur dexOpt exception " + C5013ao.m7460m(th), null);
            AppMethodBeat.m2505o(90565);
        }
    }

    public static void bGg() {
        AppMethodBeat.m2504i(90566);
        C7060h.pYm.mo8378a(338, 106, 1, false);
        AppMethodBeat.m2505o(90566);
    }

    public static void bGh() {
        AppMethodBeat.m2504i(90567);
        C7060h.pYm.mo8378a(338, 116, 1, false);
        AppMethodBeat.m2505o(90567);
    }

    /* renamed from: xb */
    public static void m85608xb(int i) {
        AppMethodBeat.m2504i(90568);
        switch (i) {
            case 1:
                C7060h.pYm.mo8378a(338, 130, 1, false);
                AppMethodBeat.m2505o(90568);
                return;
            case 3:
                C7060h.pYm.mo8378a(338, 114, 1, false);
                AppMethodBeat.m2505o(90568);
                return;
            case 5:
                C7060h.pYm.mo8378a(338, 115, 1, false);
                AppMethodBeat.m2505o(90568);
                return;
            case 6:
                C7060h.pYm.mo8378a(338, 132, 1, false);
                AppMethodBeat.m2505o(90568);
                return;
            case 7:
                C7060h.pYm.mo8378a(338, 136, 1, false);
                break;
        }
        AppMethodBeat.m2505o(90568);
    }

    /* renamed from: s */
    public static void m85601s(long j, boolean z) {
        AppMethodBeat.m2504i(90569);
        C7060h.pYm.mo8378a(338, 4, 1, false);
        if (z) {
            C4990ab.m7417i("Tinker.HotPatchReportHelper", "hp_report report load cost = %d", Long.valueOf(j));
            if (j < 0) {
                C4990ab.m7412e("Tinker.HotPatchReportHelper", "hp_report report load cost failed, invalid cost");
                AppMethodBeat.m2505o(90569);
                return;
            } else if (j <= 500) {
                C7060h.pYm.mo8378a(338, 177, 1, false);
                AppMethodBeat.m2505o(90569);
                return;
            } else if (j <= 1000) {
                C7060h.pYm.mo8378a(338, 178, 1, false);
                AppMethodBeat.m2505o(90569);
                return;
            } else if (j <= 3000) {
                C7060h.pYm.mo8378a(338, 179, 1, false);
                AppMethodBeat.m2505o(90569);
                return;
            } else if (j <= 5000) {
                C7060h.pYm.mo8378a(338, 180, 1, false);
                AppMethodBeat.m2505o(90569);
                return;
            } else {
                C7060h.pYm.mo8378a(338, 181, 1, false);
                AppMethodBeat.m2505o(90569);
                return;
            }
        }
        C7060h.pYm.mo8378a(338, 159, 1, false);
        AppMethodBeat.m2505o(90569);
    }

    /* renamed from: a */
    public static void m85594a(Throwable th, int i) {
        boolean z = false;
        AppMethodBeat.m2504i(90570);
        switch (i) {
            case -4:
                C7060h.pYm.mo8378a(338, 188, 1, false);
                break;
            case -3:
                if (!th.getMessage().contains("checkResInstall failed")) {
                    C7060h.pYm.mo8378a(338, 184, 1, false);
                    break;
                }
                C7060h.pYm.mo8378a(338, 190, 1, false);
                z = true;
                break;
            case -2:
                if (!th.getMessage().contains("checkDexInstall failed")) {
                    C7060h.pYm.mo8378a(338, 161, 1, false);
                    C4990ab.m7412e("Tinker.HotPatchReportHelper", "tinker dex reflect fail:" + th.getMessage());
                    break;
                }
                C7060h.pYm.mo8378a(338, 189, 1, false);
                C4990ab.m7416i("Tinker.HotPatchReportHelper", "tinker dex check fail:" + th.getMessage());
                z = true;
                break;
            case -1:
                C7060h.pYm.mo8378a(338, 160, 1, false);
                break;
        }
        if (!z) {
            Object m = C5013ao.m7460m(th);
            if (i == -4) {
                Context context = C4996ah.getContext();
                String jk = SharePatchFileUtil.m9386jk(context);
                if (!ShareTinkerInternals.isNullOrNil(jk)) {
                    m = "tinker checkSafeModeCount fail:\n".concat(String.valueOf(jk));
                    SharePatchFileUtil.m9373as(SharePatchFileUtil.m9385jj(context));
                }
            }
            C7060h.pYm.mo8382g("Tinker", "Tinker Exception:load tinker occur exception ".concat(String.valueOf(m)), null);
        }
        AppMethodBeat.m2505o(90570);
    }

    /* renamed from: t */
    public static void m85602t(boolean z, int i) {
        AppMethodBeat.m2504i(90571);
        C4990ab.m7417i("Tinker.HotPatchReportHelper", "hp_report package check failed, error = %d", Integer.valueOf(i));
        if (z) {
            C7060h.pYm.mo8378a(338, 170, 1, false);
        }
        switch (i) {
            case -8:
                C7060h.pYm.mo15416ag(338, 169, 186);
                break;
            case -7:
                C7060h.pYm.mo15416ag(338, 169, ErrorCode.NEEDDOWNLOAD_FALSE_6);
                AppMethodBeat.m2505o(90571);
                return;
            case -6:
                C7060h.pYm.mo15416ag(338, 169, ErrorCode.NEEDDOWNLOAD_FALSE_5);
                AppMethodBeat.m2505o(90571);
                return;
            case -5:
                C7060h.pYm.mo15416ag(338, 169, ErrorCode.NEEDDOWNLOAD_FALSE_4);
                AppMethodBeat.m2505o(90571);
                return;
            case -4:
                C7060h.pYm.mo15416ag(338, 169, ErrorCode.NEEDDOWNLOAD_FALSE_3);
                AppMethodBeat.m2505o(90571);
                return;
            case -3:
                C7060h.pYm.mo15416ag(338, 169, ErrorCode.NEEDDOWNLOAD_FALSE_2);
                AppMethodBeat.m2505o(90571);
                return;
            case -2:
                C7060h.pYm.mo15416ag(338, 107, FaceMoveUtil.TRIANGLE_COUNT);
                AppMethodBeat.m2505o(90571);
                return;
            case -1:
                C7060h.pYm.mo15416ag(338, 169, ErrorCode.NEEDDOWNLOAD_FALSE_1);
                AppMethodBeat.m2505o(90571);
                return;
        }
        AppMethodBeat.m2505o(90571);
    }

    /* renamed from: xc */
    public static void m85609xc(int i) {
        AppMethodBeat.m2504i(90572);
        switch (i) {
            case 1:
                C7060h.pYm.mo8378a(338, 166, 1, false);
                AppMethodBeat.m2505o(90572);
                return;
            case 2:
                C7060h.pYm.mo8378a(338, 167, 1, false);
                AppMethodBeat.m2505o(90572);
                return;
            case 3:
                C7060h.pYm.mo8378a(338, 164, 1, false);
                AppMethodBeat.m2505o(90572);
                return;
            case 4:
                C7060h.pYm.mo8378a(338, 183, 1, false);
                AppMethodBeat.m2505o(90572);
                return;
            case 5:
                C7060h.pYm.mo8378a(338, 165, 1, false);
                AppMethodBeat.m2505o(90572);
                return;
            case 6:
                C7060h.pYm.mo8378a(338, 187, 1, false);
                break;
        }
        AppMethodBeat.m2505o(90572);
    }

    /* renamed from: xd */
    public static void m85610xd(int i) {
        AppMethodBeat.m2504i(90573);
        switch (i) {
            case 3:
                C7060h.pYm.mo8378a(338, 162, 1, false);
                AppMethodBeat.m2505o(90573);
                return;
            case 5:
                C7060h.pYm.mo8378a(338, 163, 1, false);
                AppMethodBeat.m2505o(90573);
                return;
            case 6:
                C7060h.pYm.mo8378a(338, 185, 1, false);
                break;
        }
        AppMethodBeat.m2505o(90573);
    }

    public static void bGi() {
        AppMethodBeat.m2504i(90574);
        C7060h.pYm.mo8378a(338, 168, 1, false);
        AppMethodBeat.m2505o(90574);
    }

    public static void bGj() {
        AppMethodBeat.m2504i(90575);
        C7060h.pYm.mo8378a(338, 5, 1, false);
        AppMethodBeat.m2505o(90575);
    }

    /* renamed from: a */
    public static void m85593a(int i, Throwable th) {
        AppMethodBeat.m2504i(90576);
        switch (i) {
            case 0:
                C7060h.pYm.mo8378a(338, 193, 1, false);
                break;
            case 1:
                C7060h.pYm.mo8378a(338, 191, 1, false);
                C7060h.pYm.mo8382g("Tinker", "Tinker Exception:interpret occur instruction exception " + C5013ao.m7460m(th), null);
                AppMethodBeat.m2505o(90576);
                return;
            case 2:
                C7060h.pYm.mo8378a(338, 192, 1, false);
                C7060h.pYm.mo8382g("Tinker", "Tinker Exception:interpret occur command exception " + C5013ao.m7460m(th), null);
                AppMethodBeat.m2505o(90576);
                return;
        }
        AppMethodBeat.m2505o(90576);
    }

    /* renamed from: e */
    public static void m85596e(String str, String str2, String str3, int i, int i2) {
        AppMethodBeat.m2504i(90577);
        C7060h.pYm.mo8381e(15974, str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2), Boolean.FALSE);
        C4990ab.m7417i("Tinker.HotPatchReportHelper", "CodeVersion:%s PatchVersion:%s TinkerId:%s Scene:%d Result:%d", str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2));
        AppMethodBeat.m2505o(90577);
    }
}
