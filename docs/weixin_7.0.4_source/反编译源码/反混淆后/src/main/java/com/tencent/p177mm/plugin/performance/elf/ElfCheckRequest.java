package com.tencent.p177mm.plugin.performance.elf;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.performance.elf.ElfCheckRequest */
public class ElfCheckRequest implements Parcelable {
    public static final Creator<ElfCheckRequest> CREATOR = new C35901();
    public long oJs = 0;

    /* renamed from: com.tencent.mm.plugin.performance.elf.ElfCheckRequest$1 */
    static class C35901 implements Creator<ElfCheckRequest> {
        C35901() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ElfCheckRequest[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(111047);
            ElfCheckRequest elfCheckRequest = new ElfCheckRequest(parcel);
            AppMethodBeat.m2505o(111047);
            return elfCheckRequest;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(111048);
        parcel.writeLong(this.oJs);
        AppMethodBeat.m2505o(111048);
    }

    protected ElfCheckRequest(Parcel parcel) {
        AppMethodBeat.m2504i(111049);
        this.oJs = parcel.readLong();
        AppMethodBeat.m2505o(111049);
    }

    static {
        AppMethodBeat.m2504i(111050);
        AppMethodBeat.m2505o(111050);
    }
}
