package com.tencent.mm.plugin.wepkg.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public class ReloadNotify implements Parcelable {
    public static Creator<ReloadNotify> CREATOR = new Creator<ReloadNotify>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ReloadNotify[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(63474);
            ReloadNotify reloadNotify = new ReloadNotify(parcel, (byte) 0);
            AppMethodBeat.o(63474);
            return reloadNotify;
        }
    };
    public static Set<String> uWB = new HashSet();
    public String[] uWC;

    /* synthetic */ ReloadNotify(Parcel parcel, byte b) {
        this(parcel);
    }

    static {
        AppMethodBeat.i(63477);
        AppMethodBeat.o(63477);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(63475);
        parcel.writeStringArray(this.uWC);
        AppMethodBeat.o(63475);
    }

    private ReloadNotify(Parcel parcel) {
        AppMethodBeat.i(63476);
        this.uWC = parcel.createStringArray();
        AppMethodBeat.o(63476);
    }
}
