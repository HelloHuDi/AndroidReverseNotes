package com.tencent.p177mm.plugin.appbrand.permission;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10441j;
import com.tencent.p177mm.protocal.protobuf.C15381rg;
import java.util.Locale;

/* renamed from: com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle */
public final class AppRuntimeApiPermissionBundle implements Parcelable, C10441j {
    public static final Creator<AppRuntimeApiPermissionBundle> CREATOR = new C196571();
    final byte[] iwG;
    final byte[] iwH;
    final byte[] iwI;

    /* renamed from: com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle$1 */
    static class C196571 implements Creator<AppRuntimeApiPermissionBundle> {
        C196571() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppRuntimeApiPermissionBundle[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(102273);
            AppRuntimeApiPermissionBundle appRuntimeApiPermissionBundle = new AppRuntimeApiPermissionBundle(parcel, (byte) 0);
            AppMethodBeat.m2505o(102273);
            return appRuntimeApiPermissionBundle;
        }
    }

    /* synthetic */ AppRuntimeApiPermissionBundle(Parcel parcel, byte b) {
        this(parcel);
    }

    public AppRuntimeApiPermissionBundle(C15381rg c15381rg) {
        AppMethodBeat.m2504i(102274);
        this.iwG = c15381rg.vYw.toByteArray();
        this.iwH = ((C1332b) c15381rg.vYx.get(0)).toByteArray();
        this.iwI = ((C1332b) c15381rg.vYx.get(1)).toByteArray();
        AppMethodBeat.m2505o(102274);
    }

    public final String toString() {
        AppMethodBeat.m2504i(102275);
        String format = String.format(Locale.US, "PermissionBundle[%d][%d][%d]", new Object[]{Integer.valueOf(this.iwG.length), Integer.valueOf(this.iwH.length), Integer.valueOf(this.iwI.length)});
        AppMethodBeat.m2505o(102275);
        return format;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(102276);
        parcel.writeByteArray(this.iwG);
        parcel.writeByteArray(this.iwH);
        parcel.writeByteArray(this.iwI);
        AppMethodBeat.m2505o(102276);
    }

    private AppRuntimeApiPermissionBundle(Parcel parcel) {
        AppMethodBeat.m2504i(102277);
        this.iwG = parcel.createByteArray();
        this.iwH = parcel.createByteArray();
        this.iwI = parcel.createByteArray();
        AppMethodBeat.m2505o(102277);
    }

    static {
        AppMethodBeat.m2504i(102278);
        AppMethodBeat.m2505o(102278);
    }
}
