package com.tencent.p177mm.plugin.wepkg.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.wepkg.event.ReloadNotify */
public class ReloadNotify implements Parcelable {
    public static Creator<ReloadNotify> CREATOR = new C46981();
    public static Set<String> uWB = new HashSet();
    public String[] uWC;

    /* renamed from: com.tencent.mm.plugin.wepkg.event.ReloadNotify$1 */
    static class C46981 implements Creator<ReloadNotify> {
        C46981() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ReloadNotify[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(63474);
            ReloadNotify reloadNotify = new ReloadNotify(parcel, (byte) 0);
            AppMethodBeat.m2505o(63474);
            return reloadNotify;
        }
    }

    /* synthetic */ ReloadNotify(Parcel parcel, byte b) {
        this(parcel);
    }

    static {
        AppMethodBeat.m2504i(63477);
        AppMethodBeat.m2505o(63477);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(63475);
        parcel.writeStringArray(this.uWC);
        AppMethodBeat.m2505o(63475);
    }

    private ReloadNotify(Parcel parcel) {
        AppMethodBeat.m2504i(63476);
        this.uWC = parcel.createStringArray();
        AppMethodBeat.m2505o(63476);
    }
}
