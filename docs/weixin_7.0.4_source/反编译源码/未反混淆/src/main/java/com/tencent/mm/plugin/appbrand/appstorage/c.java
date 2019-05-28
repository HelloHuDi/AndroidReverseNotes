package com.tencent.mm.plugin.appbrand.appstorage;

import a.f.b.j;
import a.l;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ai;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;

@l(dWo = {1, 1, 13}, dWp = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0002\u0014\u0015B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0002R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer;", "Lcom/tencent/mm/model/IDataTransfer;", "appid", "", "(Ljava/lang/String;)V", "mAppId", "clearOldSchemeData", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "getTag", "markHadTransferToMMKV", "needTransfer", "", "sVer", "", "transfer", "transferToMMKV", "Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer$Result;", "storageId", "Companion", "Result", "plugin-appbrand-integration_release"})
public final class c extends ai {
    public static final a gXf = new a();
    private final String mAppId;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006\u001a"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer$Result;", "", "readTime", "", "writeTime", "size", "", "(JJI)V", "getReadTime", "()J", "setReadTime", "(J)V", "getSize", "()I", "getWriteTime", "setWriteTime", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-appbrand-integration_release"})
    static final class b {
        long gXg;
        long gXn;
        final int size;

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (!(obj instanceof b)) {
                    return false;
                }
                b bVar = (b) obj;
                if (!(this.gXg == bVar.gXg)) {
                    return false;
                }
                if (!(this.gXn == bVar.gXn)) {
                    return false;
                }
                if (!(this.size == bVar.size)) {
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
            AppMethodBeat.i(134480);
            String str = "Result(readTime=" + this.gXg + ", writeTime=" + this.gXn + ", size=" + this.size + ")";
            AppMethodBeat.o(134480);
            return str;
        }

        public b(long j, long j2, int i) {
            this.gXg = j;
            this.gXn = j2;
            this.size = i;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appstorage/AppBrandKVStorageTransfer$Companion;", "", "()V", "KEY_HAD_CLEAN_OLD_SCHEME", "", "KEY_HAD_FINISH_TRANSFER", "KEY_HAD_TRANSFER_TO_MMKV", "TAG", "getStorageScheme", "", "appId", "plugin-appbrand-integration_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static int xV(String str) {
            int i;
            AppMethodBeat.i(134479);
            j.p(str, "appId");
            SharedPreferences doB = ah.doB();
            if (doB.getBoolean("keyHadFinishTransfer".concat(String.valueOf(str)), false)) {
                i = 2;
            } else if (!doB.getBoolean("hadTransferToMMKV".concat(String.valueOf(str)), false) || d.gXk.awI()) {
                i = 1;
            } else {
                i = 3;
            }
            ab.i("MicroMsg.AppBrandKVStorageTransfer", "getStorageScheme:".concat(String.valueOf(i)));
            AppMethodBeat.o(134479);
            return i;
        }
    }

    static {
        AppMethodBeat.i(134486);
        AppMethodBeat.o(134486);
    }

    public c(String str) {
        j.p(str, "appid");
        AppMethodBeat.i(134485);
        this.mAppId = str;
        AppMethodBeat.o(134485);
    }

    public final void transfer(int i) {
        AppMethodBeat.i(134481);
        if (d.gXk.awK()) {
            SharedPreferences doB = ah.doB();
            f fVar;
            if (d.gXk.awI()) {
                ab.i("MicroMsg.AppBrandKVStorageTransfer", "rollback phases, clear [had transfer to mmkv] flag");
                doB.edit().putBoolean("hadTransferToMMKV" + this.mAppId, false).apply();
                fVar = f.gXv;
                f.xR(this.mAppId);
                AppMethodBeat.o(134481);
                return;
            }
            boolean z = doB.getBoolean("hadTransferToMMKV" + this.mAppId, false);
            if (z && d.gXk.awH()) {
                j.o(doB, "sharedPreferences");
                b(doB);
                doB.edit().putBoolean("keyHadFinishTransfer" + this.mAppId, true).apply();
                AppMethodBeat.o(134481);
                return;
            } else if (z) {
                ab.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] had transfer to mmkv, return");
                AppMethodBeat.o(134481);
                return;
            } else {
                ab.i("MicroMsg.AppBrandKVStorageTransfer", "start transfer");
                long j = 0;
                long j2 = 0;
                int i2 = 0;
                long currentTimeMillis = System.currentTimeMillis();
                ab.i("MicroMsg.AppBrandKVStorageTransfer", "clear MMKV");
                fVar = f.gXv;
                f.xR(this.mAppId);
                int[] xS = f.xG().xS(this.mAppId);
                j.o(xS, "SubCoreAppBrand.getAppKV…).getAllStorageId(mAppId)");
                int xT = f.xG().xT(this.mAppId);
                for (int nv : xS) {
                    b nv2 = nv(nv);
                    j += nv2.gXg;
                    j2 += nv2.gXn;
                    i2 += nv2.size;
                }
                ab.i("MicroMsg.AppBrandKVStorageTransfer", "finish transfer, cost total time= " + (System.currentTimeMillis() - currentTimeMillis) + " ms read time = " + j + " ms, write time = " + j2 + " ms");
                fVar = f.gXv;
                int xT2 = f.xT(this.mAppId);
                fVar = f.gXv;
                int yc = f.yc(this.mAppId);
                ab.i("MicroMsg.AppBrandKVStorageTransfer", "newbytes =" + xT2 + " oldbytes =" + xT + "  newsize =" + yc + "  oldsize =" + i2 + ' ');
                if (yc != i2) {
                    IllegalStateException illegalStateException = new IllegalStateException("tansfer failed ");
                    if (com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED || com.tencent.mm.sdk.platformtools.f.DEBUG) {
                        Throwable th = illegalStateException;
                        AppMethodBeat.o(134481);
                        throw th;
                    }
                    ab.printErrStackTrace("MicroMsg.AppBrandKVStorageTransfer", illegalStateException, "transfer failed", new Object[0]);
                }
                ab.i("MicroMsg.AppBrandKVStorageTransfer", "finish transfer, prev ");
                h hVar = h.pYm;
                Object[] objArr = new Object[5];
                objArr[0] = this.mAppId;
                objArr[1] = Long.valueOf(j);
                objArr[2] = Long.valueOf(j2);
                objArr[3] = Integer.valueOf(xT2);
                f fVar2 = f.gXv;
                objArr[4] = Integer.valueOf(f.yc(this.mAppId));
                hVar.e(16335, objArr);
                j.o(doB, "sharedPreferences");
                doB.edit().putBoolean("hadTransferToMMKV" + this.mAppId, true).apply();
                if (d.gXk.awH()) {
                    b(doB);
                    doB.edit().putBoolean("keyHadFinishTransfer" + this.mAppId, true).apply();
                }
                AppMethodBeat.o(134481);
                return;
            }
        }
        ab.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] isNeedTransfer = false");
        AppMethodBeat.o(134481);
    }

    private final b nv(int i) {
        AppMethodBeat.i(134482);
        Object obj = f.xG().G(i, this.mAppId)[0];
        if (!(obj instanceof ArrayList)) {
            obj = null;
        }
        ArrayList arrayList = (ArrayList) obj;
        b bVar;
        if (arrayList == null) {
            bVar = new b(0, 0, 0);
            AppMethodBeat.o(134482);
            return bVar;
        } else if (arrayList.size() == 0) {
            bVar = new b(0, 0, 0);
            AppMethodBeat.o(134482);
            return bVar;
        } else {
            ab.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] key size = " + arrayList.size());
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
                Object[] k = f.xG().k(i, this.mAppId, str);
                j.o(k, "SubCoreAppBrand.getAppKV…t(storageId, mAppId, key)");
                currentTimeMillis = (System.currentTimeMillis() - currentTimeMillis) + j;
                next2 = k[1];
                Object obj2 = k[2];
                if ((j.j(str, "") ^ 1) != 0 && k[0] == com.tencent.mm.plugin.appbrand.appstorage.n.a.NONE && (next2 instanceof String) && (obj2 instanceof String)) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    f fVar = f.gXv;
                    f.b(i, this.mAppId, str, (String) next2, (String) obj2);
                    j2 += System.currentTimeMillis() - currentTimeMillis2;
                }
                j = currentTimeMillis;
            }
            bVar = new b(j, j2, arrayList.size());
            AppMethodBeat.o(134482);
            return bVar;
        }
    }

    private final void b(SharedPreferences sharedPreferences) {
        AppMethodBeat.i(134483);
        if (sharedPreferences.getBoolean("keyHadCleanOldScheme" + this.mAppId, false)) {
            ab.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] had clear old scheme data, return");
            AppMethodBeat.o(134483);
            return;
        }
        ab.i("MicroMsg.AppBrandKVStorageTransfer", "[transfer] clear old scheme data");
        f.xG().xR(this.mAppId);
        sharedPreferences.edit().putBoolean("keyHadCleanOldScheme" + this.mAppId, true).apply();
        AppMethodBeat.o(134483);
    }

    public final boolean kw(int i) {
        boolean z = false;
        AppMethodBeat.i(134484);
        if (!ah.doB().getBoolean("keyHadFinishTransfer" + this.mAppId, false)) {
            z = true;
        }
        ab.i("MicroMsg.AppBrandKVStorageTransfer", "needTransfer ".concat(String.valueOf(z)));
        AppMethodBeat.o(134484);
        return z;
    }

    public final String getTag() {
        return "MicroMsg.AppBrandKVStorageTransfer";
    }
}
