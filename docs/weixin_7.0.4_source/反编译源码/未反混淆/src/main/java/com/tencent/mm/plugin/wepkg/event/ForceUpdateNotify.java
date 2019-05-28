package com.tencent.mm.plugin.wepkg.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wepkg.event.c.a;
import java.util.HashSet;
import java.util.Set;

public class ForceUpdateNotify implements Parcelable {
    public static Creator<ForceUpdateNotify> CREATOR = new Creator<ForceUpdateNotify>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ForceUpdateNotify[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(63461);
            ForceUpdateNotify forceUpdateNotify = new ForceUpdateNotify(parcel, (byte) 0);
            AppMethodBeat.o(63461);
            return forceUpdateNotify;
        }
    };
    public static Set<String> uWB = new HashSet();
    public String[] uWC;

    /* synthetic */ ForceUpdateNotify(Parcel parcel, byte b) {
        this(parcel);
    }

    static {
        AppMethodBeat.i(63466);
        AppMethodBeat.o(63466);
    }

    public static void wy(String str) {
        AppMethodBeat.i(63462);
        uWB.add(str);
        AppMethodBeat.o(63462);
    }

    public static void bny() {
        AppMethodBeat.i(63463);
        if (uWB.size() != 0) {
            Set set = uWB;
            c.a(new ForceUpdateNotify((String[]) set.toArray(new String[set.size()])), new a() {
                public final void ckg() {
                    AppMethodBeat.i(63460);
                    ForceUpdateNotify.uWB.clear();
                    AppMethodBeat.o(63460);
                }
            });
        }
        AppMethodBeat.o(63463);
    }

    private ForceUpdateNotify(String[] strArr) {
        this.uWC = strArr;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(63464);
        parcel.writeStringArray(this.uWC);
        AppMethodBeat.o(63464);
    }

    private ForceUpdateNotify(Parcel parcel) {
        AppMethodBeat.i(63465);
        this.uWC = parcel.createStringArray();
        AppMethodBeat.o(63465);
    }
}
