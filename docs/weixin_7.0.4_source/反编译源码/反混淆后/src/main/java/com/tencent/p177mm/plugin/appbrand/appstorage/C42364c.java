package com.tencent.p177mm.plugin.appbrand.appstorage;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1812ai;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appstorage.C10108n.C10107a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import java.util.ArrayList;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0002R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer;", "Lcom/tencent/mm/model/IDataTransfer;", "appid", "", "(Ljava/lang/String;)V", "mAppId", "clearOldSchemeData", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "getTag", "markHadTransferToMMKV", "needTransfer", "", "sVer", "", "transfer", "transferToMMKV", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer$Result;", "storageId", "Companion", "Result", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.appstorage.c */
public final class C42364c extends C1812ai {
    public static final C42363a gXf = new C42363a();
    private final String mAppId;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer$Result;", "", "readTime", "", "writeTime", "size", "", "(JJI)V", "getReadTime", "()J", "setReadTime", "(J)V", "getSize", "()I", "getWriteTime", "setWriteTime", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.c$b */
    static final class C19081b {
        long gXg;
        long gXn;
        final int size;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (!(obj instanceof C19081b)) {
                    return false;
                }
                C19081b c19081b = (C19081b) obj;
                if (!(this.gXg == c19081b.gXg)) {
                    return false;
                }
                if (!(this.gXn == c19081b.gXn)) {
                    return false;
                }
                if (!(this.size == c19081b.size)) {
                    return false;
                }
            }
            return true;
        }

        public final int hashCode() {
            long j = this.gXg;
            int i = ((int) (j ^ (j >>> 32))) * 31;
            long j2 = this.gXn;
            return ((i + ((int) (j2 ^ (j2 >>> 32)))) * 31) + this.size;
        }

        public final String toString() {
            AppMethodBeat.m2504i(134480);
            String str = "Result(readTime=" + this.gXg + ", writeTime=" + this.gXn + ", size=" + this.size + ")";
            AppMethodBeat.m2505o(134480);
            return str;
        }

        public C19081b(long j, long j2, int i) {
            this.gXg = j;
            this.gXn = j2;
            this.size = i;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer$Companion;", "", "()V", "KEY_HAD_CLEAN_OLD_SCHEME", "", "KEY_HAD_FINISH_TRANSFER", "KEY_HAD_TRANSFER_TO_MMKV", "TAG", "getStorageScheme", "", "appId", "plugin-appbrand-integration_release"})
    /* renamed from: com.tencent.mm.plugin.appbrand.appstorage.c$a */
    public static final class C42363a {
        private C42363a() {
        }

        public /* synthetic */ C42363a(byte b) {
            this();
        }

        /* renamed from: xV */
        public static int m74934xV(String str) {
            int i;
            AppMethodBeat.m2504i(134479);
            C25052j.m39376p(str, "appId");
            SharedPreferences doB = C4996ah.doB();
            if (doB.getBoolean("keyHadFinishTransfer".concat(String.valueOf(str)), false)) {
                i = 2;
            } else if (!doB.getBoolean("hadTransferToMMKV".concat(String.valueOf(str)), false) || C42365d.gXk.awI()) {
                i = 1;
            } else {
                i = 3;
            }
            C4990ab.m7416i("MicroMsg.AppBrandKVStorageTransfer", "getStorageScheme:".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(134479);
            return i;
        }
    }

    static {
        AppMethodBeat.m2504i(134486);
        AppMethodBeat.m2505o(134486);
    }

    public C42364c(String str) {
        C25052j.m39376p(str, "appid");
        AppMethodBeat.m2504i(134485);
        this.mAppId = str;
        AppMethodBeat.m2505o(134485);
    }

    public final void transfer(int i) {
        AppMethodBeat.m2504i(134481);
        if (C42365d.gXk.awK()) {
            SharedPreferences doB = C4996ah.doB();
            C19085f c19085f;
            if (C42365d.gXk.awI()) {
                C4990ab.m7416i("MicroMsg.AppBrandKVStorageTransfer", "rollback phases, clear [had transfer to mmkv] flag");
                doB.edit().putBoolean("hadTransferToMMKV" + this.mAppId, false).apply();
                c19085f = C19085f.gXv;
                C19085f.m29670xR(this.mAppId);
                AppMethodBeat.m2505o(134481);
                return;
            }
            boolean z = doB.getBoolean("hadTransferToMMKV" + this.mAppId, false);
            if (z && C42365d.gXk.awH()) {
                C25052j.m39375o(doB, "sharedPreferences");
                m74935b(doB);
                doB.edit().putBoolean("keyHadFinishTransfer" + this.mAppId, true).apply();
                AppMethodBeat.m2505o(134481);
                return;
            } else if (z) {
                C4990ab.m7416i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] had transfer to mmkv, return");
                AppMethodBeat.m2505o(134481);
                return;
            } else {
                C4990ab.m7416i("MicroMsg.AppBrandKVStorageTransfer", "start transfer");
                long j = 0;
                long j2 = 0;
                int i2 = 0;
                long currentTimeMillis = System.currentTimeMillis();
                C4990ab.m7416i("MicroMsg.AppBrandKVStorageTransfer", "clear MMKV");
                c19085f = C19085f.gXv;
                C19085f.m29670xR(this.mAppId);
                int[] xS = C42340f.m74879xG().mo67876xS(this.mAppId);
                C25052j.m39375o(xS, "SubCoreAppBrand.getAppKV…).getAllStorageId(mAppId)");
                int xT = C42340f.m74879xG().mo67877xT(this.mAppId);
                for (int nv : xS) {
                    C19081b nv2 = m74936nv(nv);
                    j += nv2.gXg;
                    j2 += nv2.gXn;
                    i2 += nv2.size;
                }
                C4990ab.m7416i("MicroMsg.AppBrandKVStorageTransfer", "finish transfer, cost total time= " + (System.currentTimeMillis() - currentTimeMillis) + " ms read time = " + j + " ms, write time = " + j2 + " ms");
                c19085f = C19085f.gXv;
                int xT2 = C19085f.m29671xT(this.mAppId);
                c19085f = C19085f.gXv;
                int yc = C19085f.m29674yc(this.mAppId);
                C4990ab.m7416i("MicroMsg.AppBrandKVStorageTransfer", "newbytes =" + xT2 + " oldbytes =" + xT + "  newsize =" + yc + "  oldsize =" + i2 + ' ');
                if (yc != i2) {
                    IllegalStateException illegalStateException = new IllegalStateException("tansfer failed ");
                    if (C5058f.IS_FLAVOR_RED || C5058f.DEBUG) {
                        Throwable th = illegalStateException;
                        AppMethodBeat.m2505o(134481);
                        throw th;
                    }
                    C4990ab.printErrStackTrace("MicroMsg.AppBrandKVStorageTransfer", illegalStateException, "transfer failed", new Object[0]);
                }
                C4990ab.m7416i("MicroMsg.AppBrandKVStorageTransfer", "finish transfer, prev ");
                C7060h c7060h = C7060h.pYm;
                Object[] objArr = new Object[5];
                objArr[0] = this.mAppId;
                objArr[1] = Long.valueOf(j);
                objArr[2] = Long.valueOf(j2);
                objArr[3] = Integer.valueOf(xT2);
                C19085f c19085f2 = C19085f.gXv;
                objArr[4] = Integer.valueOf(C19085f.m29674yc(this.mAppId));
                c7060h.mo8381e(16335, objArr);
                C25052j.m39375o(doB, "sharedPreferences");
                doB.edit().putBoolean("hadTransferToMMKV" + this.mAppId, true).apply();
                if (C42365d.gXk.awH()) {
                    m74935b(doB);
                    doB.edit().putBoolean("keyHadFinishTransfer" + this.mAppId, true).apply();
                }
                AppMethodBeat.m2505o(134481);
                return;
            }
        }
        C4990ab.m7416i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] isNeedTransfer = false");
        AppMethodBeat.m2505o(134481);
    }

    /* renamed from: nv */
    private final C19081b m74936nv(int i) {
        AppMethodBeat.m2504i(134482);
        Object obj = C42340f.m74879xG().mo67871G(i, this.mAppId)[0];
        if (!(obj instanceof ArrayList)) {
            obj = null;
        }
        ArrayList arrayList = (ArrayList) obj;
        C19081b c19081b;
        if (arrayList == null) {
            c19081b = new C19081b(0, 0, 0);
            AppMethodBeat.m2505o(134482);
            return c19081b;
        } else if (arrayList.size() == 0) {
            c19081b = new C19081b(0, 0, 0);
            AppMethodBeat.m2505o(134482);
            return c19081b;
        } else {
            C4990ab.m7416i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] key size = " + arrayList.size());
            long j = 0;
            long j2 = 0;
            for (Object next : arrayList) {
                Object next2;
                String str;
                if (!(next2 instanceof String)) {
                    next2 = null;
                }
                String str2 = (String) next2;
                if (str2 == null) {
                    str = "";
                } else {
                    str = str2;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Object[] k = C42340f.m74879xG().mo67873k(i, this.mAppId, str);
                C25052j.m39375o(k, "SubCoreAppBrand.getAppKV…t(storageId, mAppId, key)");
                currentTimeMillis = (System.currentTimeMillis() - currentTimeMillis) + j;
                next2 = k[1];
                Object obj2 = k[2];
                if ((C25052j.m39373j(str, "") ^ 1) != 0 && k[0] == C10107a.NONE && (next2 instanceof String) && (obj2 instanceof String)) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    C19085f c19085f = C19085f.gXv;
                    C19085f.m29665b(i, this.mAppId, str, (String) next2, (String) obj2);
                    j2 += System.currentTimeMillis() - currentTimeMillis2;
                }
                j = currentTimeMillis;
            }
            c19081b = new C19081b(j, j2, arrayList.size());
            AppMethodBeat.m2505o(134482);
            return c19081b;
        }
    }

    /* renamed from: b */
    private final void m74935b(SharedPreferences sharedPreferences) {
        AppMethodBeat.m2504i(134483);
        if (sharedPreferences.getBoolean("keyHadCleanOldScheme" + this.mAppId, false)) {
            C4990ab.m7416i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] had clear old scheme data, return");
            AppMethodBeat.m2505o(134483);
            return;
        }
        C4990ab.m7416i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] clear old scheme data");
        C42340f.m74879xG().mo67875xR(this.mAppId);
        sharedPreferences.edit().putBoolean("keyHadCleanOldScheme" + this.mAppId, true).apply();
        AppMethodBeat.m2505o(134483);
    }

    /* renamed from: kw */
    public final boolean mo5386kw(int i) {
        boolean z = false;
        AppMethodBeat.m2504i(134484);
        if (!C4996ah.doB().getBoolean("keyHadFinishTransfer" + this.mAppId, false)) {
            z = true;
        }
        C4990ab.m7416i("MicroMsg.AppBrandKVStorageTransfer", "needTransfer ".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(134484);
        return z;
    }

    public final String getTag() {
        return "MicroMsg.AppBrandKVStorageTransfer";
    }
}
