package com.tencent.mm.plugin.appbrand.permission;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bt.b;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.protocal.protobuf.rg;
import java.util.Locale;

public final class AppRuntimeApiPermissionBundle implements Parcelable, j {
    public static final Creator<AppRuntimeApiPermissionBundle> CREATOR = new Creator<AppRuntimeApiPermissionBundle>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppRuntimeApiPermissionBundle[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(102273);
            AppRuntimeApiPermissionBundle appRuntimeApiPermissionBundle = new AppRuntimeApiPermissionBundle(parcel, (byte) 0);
            AppMethodBeat.o(102273);
            return appRuntimeApiPermissionBundle;
        }
    };
    final byte[] iwG;
    final byte[] iwH;
    final byte[] iwI;

    /* synthetic */ AppRuntimeApiPermissionBundle(Parcel parcel, byte b) {
        this(parcel);
    }

    public AppRuntimeApiPermissionBundle(rg rgVar) {
        AppMethodBeat.i(102274);
        this.iwG = rgVar.vYw.toByteArray();
        this.iwH = ((b) rgVar.vYx.get(0)).toByteArray();
        this.iwI = ((b) rgVar.vYx.get(1)).toByteArray();
        AppMethodBeat.o(102274);
    }

    public final String toString() {
        AppMethodBeat.i(102275);
        String format = String.format(Locale.US, "PermissionBundle[%d][%d][%d]", new Object[]{Integer.valueOf(this.iwG.length), Integer.valueOf(this.iwH.length), Integer.valueOf(this.iwI.length)});
        AppMethodBeat.o(102275);
        return format;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(102276);
        parcel.writeByteArray(this.iwG);
        parcel.writeByteArray(this.iwH);
        parcel.writeByteArray(this.iwI);
        AppMethodBeat.o(102276);
    }

    private AppRuntimeApiPermissionBundle(Parcel parcel) {
        AppMethodBeat.i(102277);
        this.iwG = parcel.createByteArray();
        this.iwH = parcel.createByteArray();
        this.iwI = parcel.createByteArray();
        AppMethodBeat.o(102277);
    }

    static {
        AppMethodBeat.i(102278);
        AppMethodBeat.o(102278);
    }
}
