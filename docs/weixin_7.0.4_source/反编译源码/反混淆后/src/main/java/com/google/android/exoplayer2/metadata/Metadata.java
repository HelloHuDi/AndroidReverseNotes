package com.google.android.exoplayer2.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;

public final class Metadata implements Parcelable {
    public static final Creator<Metadata> CREATOR = new C176781();
    public final Entry[] beW;

    public interface Entry extends Parcelable {
    }

    /* renamed from: com.google.android.exoplayer2.metadata.Metadata$1 */
    static class C176781 implements Creator<Metadata> {
        C176781() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Metadata[0];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(95340);
            Metadata metadata = new Metadata(parcel);
            AppMethodBeat.m2505o(95340);
            return metadata;
        }
    }

    public Metadata(Entry... entryArr) {
        this.beW = entryArr;
    }

    public Metadata(List<? extends Entry> list) {
        AppMethodBeat.m2504i(95341);
        this.beW = new Entry[list.size()];
        list.toArray(this.beW);
        AppMethodBeat.m2505o(95341);
    }

    Metadata(Parcel parcel) {
        AppMethodBeat.m2504i(95342);
        this.beW = new Entry[parcel.readInt()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.beW.length) {
                this.beW[i2] = (Entry) parcel.readParcelable(Entry.class.getClassLoader());
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(95342);
                return;
            }
        }
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(95343);
        if (this == obj) {
            AppMethodBeat.m2505o(95343);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.m2505o(95343);
            return false;
        } else {
            boolean equals = Arrays.equals(this.beW, ((Metadata) obj).beW);
            AppMethodBeat.m2505o(95343);
            return equals;
        }
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(95344);
        int hashCode = Arrays.hashCode(this.beW);
        AppMethodBeat.m2505o(95344);
        return hashCode;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(95345);
        parcel.writeInt(this.beW.length);
        for (Parcelable writeParcelable : this.beW) {
            parcel.writeParcelable(writeParcelable, 0);
        }
        AppMethodBeat.m2505o(95345);
    }

    static {
        AppMethodBeat.m2504i(95346);
        AppMethodBeat.m2505o(95346);
    }
}
