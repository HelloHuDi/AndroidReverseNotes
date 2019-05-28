package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class WxaPkgWrappingInfo extends ModulePkgInfo implements Parcelable {
    public static final Creator<WxaPkgWrappingInfo> CREATOR = new Creator<WxaPkgWrappingInfo>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WxaPkgWrappingInfo[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(105325);
            WxaPkgWrappingInfo wxaPkgWrappingInfo = new WxaPkgWrappingInfo(parcel);
            AppMethodBeat.o(105325);
            return wxaPkgWrappingInfo;
        }
    };
    public int gVt;
    public int gVu;
    public long gVv;
    public boolean gVw;
    public final LinkedList<ModulePkgInfo> gVx;
    private final Map<String, String> gVy;

    /* Access modifiers changed, original: final */
    public final void awr() {
        AppMethodBeat.i(105326);
        synchronized (this.gVy) {
            try {
                Iterator it = this.gVx.iterator();
                while (it.hasNext()) {
                    ModulePkgInfo modulePkgInfo = (ModulePkgInfo) it.next();
                    String yk = l.yk(modulePkgInfo.name);
                    this.gVy.put(yk, modulePkgInfo.name);
                    modulePkgInfo.name = yk;
                }
            } finally {
                AppMethodBeat.o(105326);
            }
        }
    }

    public final String xL(String str) {
        AppMethodBeat.i(105327);
        if ("__APP__".equals(str)) {
            AppMethodBeat.o(105327);
            return str;
        }
        String str2;
        synchronized (this.gVy) {
            try {
                str2 = (String) this.gVy.get(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(105327);
            }
        }
        if (bo.isNullOrNil(str2)) {
            Object illegalAccessError = new IllegalAccessError("Invalid moduleName for runtime logic, call @smoothieli to fix this");
            throw illegalAccessError;
        }
        AppMethodBeat.o(105327);
        return str2;
    }

    public static WxaPkgWrappingInfo xM(String str) {
        AppMethodBeat.i(105328);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(105328);
            return null;
        }
        ao aoVar = new ao(new File(str));
        if (!aoVar.gUe) {
            ab.e("MicroMsg.WxaPkgWrappingInfo#obtain", "wxPkg invalid, path = %s ", str);
            aoVar.close();
            AppMethodBeat.o(105328);
            return null;
        } else if (aoVar.avW()) {
            aoVar.close();
            WxaPkgWrappingInfo wxaPkgWrappingInfo = new WxaPkgWrappingInfo();
            wxaPkgWrappingInfo.gSP = str;
            wxaPkgWrappingInfo.gVw = false;
            wxaPkgWrappingInfo.cvZ = g.cz(str);
            AppMethodBeat.o(105328);
            return wxaPkgWrappingInfo;
        } else {
            ab.e("MicroMsg.WxaPkgWrappingInfo#obtain", "wxPkg read info failed, path = %s ", str);
            aoVar.close();
            AppMethodBeat.o(105328);
            return null;
        }
    }

    public static WxaPkgWrappingInfo xN(String str) {
        AppMethodBeat.i(105329);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.WxaPkgWrappingInfo#obtainCodeLib", "pkgPath null!");
            AppMethodBeat.o(105329);
            return null;
        }
        WxaPkgWrappingInfo wxaPkgWrappingInfo = new WxaPkgWrappingInfo();
        wxaPkgWrappingInfo.gSP = str;
        wxaPkgWrappingInfo.gVw = false;
        wxaPkgWrappingInfo.cvZ = g.cz(str);
        AppMethodBeat.o(105329);
        return wxaPkgWrappingInfo;
    }

    public WxaPkgWrappingInfo() {
        AppMethodBeat.i(105330);
        this.gVx = new LinkedList();
        this.gVy = new HashMap();
        this.name = "__APP__";
        this.cta = true;
        AppMethodBeat.o(105330);
    }

    public WxaPkgWrappingInfo(Parcel parcel) {
        this();
        AppMethodBeat.i(105331);
        readFromParcel(parcel);
        AppMethodBeat.o(105331);
    }

    public final void a(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        AppMethodBeat.i(105332);
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        wxaPkgWrappingInfo.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        readFromParcel(obtain);
        obtain.recycle();
        AppMethodBeat.o(105332);
    }

    public final String toString() {
        AppMethodBeat.i(105333);
        String str = "WxaPkgWrappingInfo{pkgDebugType=" + this.gVt + ", pkgVersion=" + this.gVu + ", pkgCreateTime=" + this.gVv + ", localPkg=" + this.gVw + ", md5='" + this.cvZ + '\'' + ", pkgPath='" + this.gSP + '\'' + '}';
        AppMethodBeat.o(105333);
        return str;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(105334);
        super.writeToParcel(parcel, i);
        parcel.writeInt(this.gVt);
        parcel.writeInt(this.gVu);
        parcel.writeLong(this.gVv);
        parcel.writeByte(this.gVw ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.gVx);
        AppMethodBeat.o(105334);
    }

    public final void readFromParcel(Parcel parcel) {
        AppMethodBeat.i(105335);
        super.readFromParcel(parcel);
        this.gVt = parcel.readInt();
        this.gVu = parcel.readInt();
        this.gVv = parcel.readLong();
        this.gVw = parcel.readByte() != (byte) 0;
        parcel.readTypedList(this.gVx, ModulePkgInfo.CREATOR);
        AppMethodBeat.o(105335);
    }

    static {
        AppMethodBeat.i(105336);
        AppMethodBeat.o(105336);
    }
}
