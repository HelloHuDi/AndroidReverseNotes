package com.tencent.p177mm.plugin.wepkg.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wepkg.event.C35760c.C35758a;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.wepkg.event.ForceUpdateNotify */
public class ForceUpdateNotify implements Parcelable {
    public static Creator<ForceUpdateNotify> CREATOR = new C300082();
    public static Set<String> uWB = new HashSet();
    public String[] uWC;

    /* renamed from: com.tencent.mm.plugin.wepkg.event.ForceUpdateNotify$1 */
    static class C300071 implements C35758a {
        C300071() {
        }

        public final void ckg() {
            AppMethodBeat.m2504i(63460);
            ForceUpdateNotify.uWB.clear();
            AppMethodBeat.m2505o(63460);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wepkg.event.ForceUpdateNotify$2 */
    static class C300082 implements Creator<ForceUpdateNotify> {
        C300082() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ForceUpdateNotify[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(63461);
            ForceUpdateNotify forceUpdateNotify = new ForceUpdateNotify(parcel, (byte) 0);
            AppMethodBeat.m2505o(63461);
            return forceUpdateNotify;
        }
    }

    /* synthetic */ ForceUpdateNotify(Parcel parcel, byte b) {
        this(parcel);
    }

    static {
        AppMethodBeat.m2504i(63466);
        AppMethodBeat.m2505o(63466);
    }

    /* renamed from: wy */
    public static void m79020wy(String str) {
        AppMethodBeat.m2504i(63462);
        uWB.add(str);
        AppMethodBeat.m2505o(63462);
    }

    public static void bny() {
        AppMethodBeat.m2504i(63463);
        if (uWB.size() != 0) {
            Set set = uWB;
            C35760c.m58625a(new ForceUpdateNotify((String[]) set.toArray(new String[set.size()])), new C300071());
        }
        AppMethodBeat.m2505o(63463);
    }

    private ForceUpdateNotify(String[] strArr) {
        this.uWC = strArr;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(63464);
        parcel.writeStringArray(this.uWC);
        AppMethodBeat.m2505o(63464);
    }

    private ForceUpdateNotify(Parcel parcel) {
        AppMethodBeat.m2504i(63465);
        this.uWC = parcel.createStringArray();
        AppMethodBeat.m2505o(63465);
    }
}
