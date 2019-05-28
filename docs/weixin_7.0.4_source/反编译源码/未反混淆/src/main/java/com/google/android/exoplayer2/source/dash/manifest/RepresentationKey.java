package com.google.android.exoplayer2.source.dash.manifest;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class RepresentationKey implements Parcelable, Comparable<RepresentationKey> {
    public static final Creator<RepresentationKey> CREATOR = new Creator<RepresentationKey>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RepresentationKey[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(94133);
            RepresentationKey representationKey = new RepresentationKey(parcel.readInt(), parcel.readInt(), parcel.readInt());
            AppMethodBeat.o(94133);
            return representationKey;
        }
    };
    public final int bhq;
    public final int bii;
    public final int bij;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        RepresentationKey representationKey = (RepresentationKey) obj;
        int i = this.bhq - representationKey.bhq;
        if (i != 0) {
            return i;
        }
        i = this.bii - representationKey.bii;
        return i == 0 ? this.bij - representationKey.bij : i;
    }

    public RepresentationKey(int i, int i2, int i3) {
        this.bhq = i;
        this.bii = i2;
        this.bij = i3;
    }

    public final String toString() {
        AppMethodBeat.i(94134);
        String str = this.bhq + "." + this.bii + "." + this.bij;
        AppMethodBeat.o(94134);
        return str;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(94135);
        parcel.writeInt(this.bhq);
        parcel.writeInt(this.bii);
        parcel.writeInt(this.bij);
        AppMethodBeat.o(94135);
    }

    static {
        AppMethodBeat.i(94136);
        AppMethodBeat.o(94136);
    }
}
