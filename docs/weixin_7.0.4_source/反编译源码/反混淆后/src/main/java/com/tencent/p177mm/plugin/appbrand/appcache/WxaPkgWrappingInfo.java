package com.tencent.p177mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.plugin.appbrand.appstorage.C42367l;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo */
public final class WxaPkgWrappingInfo extends ModulePkgInfo implements Parcelable {
    public static final Creator<WxaPkgWrappingInfo> CREATOR = new C330711();
    public int gVt;
    public int gVu;
    public long gVv;
    public boolean gVw;
    public final LinkedList<ModulePkgInfo> gVx;
    private final Map<String, String> gVy;

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo$1 */
    static class C330711 implements Creator<WxaPkgWrappingInfo> {
        C330711() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WxaPkgWrappingInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(105325);
            WxaPkgWrappingInfo wxaPkgWrappingInfo = new WxaPkgWrappingInfo(parcel);
            AppMethodBeat.m2505o(105325);
            return wxaPkgWrappingInfo;
        }
    }

    /* Access modifiers changed, original: final */
    public final void awr() {
        AppMethodBeat.m2504i(105326);
        synchronized (this.gVy) {
            try {
                Iterator it = this.gVx.iterator();
                while (it.hasNext()) {
                    ModulePkgInfo modulePkgInfo = (ModulePkgInfo) it.next();
                    String yk = C42367l.m74946yk(modulePkgInfo.name);
                    this.gVy.put(yk, modulePkgInfo.name);
                    modulePkgInfo.name = yk;
                }
            } finally {
                AppMethodBeat.m2505o(105326);
            }
        }
    }

    /* renamed from: xL */
    public final String mo53645xL(String str) {
        AppMethodBeat.m2504i(105327);
        if ("__APP__".equals(str)) {
            AppMethodBeat.m2505o(105327);
            return str;
        }
        String str2;
        synchronized (this.gVy) {
            try {
                str2 = (String) this.gVy.get(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(105327);
            }
        }
        if (C5046bo.isNullOrNil(str2)) {
            Object illegalAccessError = new IllegalAccessError("Invalid moduleName for runtime logic, call @smoothieli to fix this");
            throw illegalAccessError;
        }
        AppMethodBeat.m2505o(105327);
        return str2;
    }

    /* renamed from: xM */
    public static WxaPkgWrappingInfo m54056xM(String str) {
        AppMethodBeat.m2504i(105328);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(105328);
            return null;
        }
        C45512ao c45512ao = new C45512ao(new File(str));
        if (!c45512ao.gUe) {
            C4990ab.m7413e("MicroMsg.WxaPkgWrappingInfo#obtain", "wxPkg invalid, path = %s ", str);
            c45512ao.close();
            AppMethodBeat.m2505o(105328);
            return null;
        } else if (c45512ao.avW()) {
            c45512ao.close();
            WxaPkgWrappingInfo wxaPkgWrappingInfo = new WxaPkgWrappingInfo();
            wxaPkgWrappingInfo.gSP = str;
            wxaPkgWrappingInfo.gVw = false;
            wxaPkgWrappingInfo.cvZ = C1178g.m2587cz(str);
            AppMethodBeat.m2505o(105328);
            return wxaPkgWrappingInfo;
        } else {
            C4990ab.m7413e("MicroMsg.WxaPkgWrappingInfo#obtain", "wxPkg read info failed, path = %s ", str);
            c45512ao.close();
            AppMethodBeat.m2505o(105328);
            return null;
        }
    }

    /* renamed from: xN */
    public static WxaPkgWrappingInfo m54057xN(String str) {
        AppMethodBeat.m2504i(105329);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.WxaPkgWrappingInfo#obtainCodeLib", "pkgPath null!");
            AppMethodBeat.m2505o(105329);
            return null;
        }
        WxaPkgWrappingInfo wxaPkgWrappingInfo = new WxaPkgWrappingInfo();
        wxaPkgWrappingInfo.gSP = str;
        wxaPkgWrappingInfo.gVw = false;
        wxaPkgWrappingInfo.cvZ = C1178g.m2587cz(str);
        AppMethodBeat.m2505o(105329);
        return wxaPkgWrappingInfo;
    }

    public WxaPkgWrappingInfo() {
        AppMethodBeat.m2504i(105330);
        this.gVx = new LinkedList();
        this.gVy = new HashMap();
        this.name = "__APP__";
        this.cta = true;
        AppMethodBeat.m2505o(105330);
    }

    public WxaPkgWrappingInfo(Parcel parcel) {
        this();
        AppMethodBeat.m2504i(105331);
        readFromParcel(parcel);
        AppMethodBeat.m2505o(105331);
    }

    /* renamed from: a */
    public final void mo53639a(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        AppMethodBeat.m2504i(105332);
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        wxaPkgWrappingInfo.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        readFromParcel(obtain);
        obtain.recycle();
        AppMethodBeat.m2505o(105332);
    }

    public final String toString() {
        AppMethodBeat.m2504i(105333);
        String str = "WxaPkgWrappingInfo{pkgDebugType=" + this.gVt + ", pkgVersion=" + this.gVu + ", pkgCreateTime=" + this.gVv + ", localPkg=" + this.gVw + ", md5='" + this.cvZ + '\'' + ", pkgPath='" + this.gSP + '\'' + '}';
        AppMethodBeat.m2505o(105333);
        return str;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(105334);
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.gVt);
        parcel.writeInt(this.gVu);
        parcel.writeLong(this.gVv);
        parcel.writeByte(this.gVw ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.gVx);
        AppMethodBeat.m2505o(105334);
    }

    public final void readFromParcel(Parcel parcel) {
        AppMethodBeat.m2504i(105335);
        super.readFromParcel(parcel);
        this.gVt = parcel.readInt();
        this.gVu = parcel.readInt();
        this.gVv = parcel.readLong();
        this.gVw = parcel.readByte() != (byte) 0;
        parcel.readTypedList(this.gVx, ModulePkgInfo.CREATOR);
        AppMethodBeat.m2505o(105335);
    }

    static {
        AppMethodBeat.m2504i(105336);
        AppMethodBeat.m2505o(105336);
    }
}
