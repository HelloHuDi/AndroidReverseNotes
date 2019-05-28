package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ScanSettingsCompat implements Parcelable {
    public static final Creator<ScanSettingsCompat> CREATOR = new Creator<ScanSettingsCompat>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ScanSettingsCompat[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(94335);
            ScanSettingsCompat scanSettingsCompat = new ScanSettingsCompat(parcel, (byte) 0);
            AppMethodBeat.o(94335);
            return scanSettingsCompat;
        }
    };
    final int hGe;
    private final int hGf;
    final long hGg;

    public static final class a {
        private int hGe = 0;
        private final int hGf = 1;
        private long hGg = 0;

        public final a of(int i) {
            AppMethodBeat.i(94336);
            if (i < 0 || i > 2) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("invalid scan mode ".concat(String.valueOf(i)));
                AppMethodBeat.o(94336);
                throw illegalArgumentException;
            }
            this.hGe = i;
            AppMethodBeat.o(94336);
            return this;
        }

        public final ScanSettingsCompat aCW() {
            AppMethodBeat.i(94337);
            ScanSettingsCompat scanSettingsCompat = new ScanSettingsCompat(this.hGe, this.hGg, (byte) 0);
            AppMethodBeat.o(94337);
            return scanSettingsCompat;
        }
    }

    /* synthetic */ ScanSettingsCompat(int i, long j, byte b) {
        this(i, j);
    }

    private ScanSettingsCompat(int i, long j) {
        this.hGe = i;
        this.hGf = 1;
        this.hGg = j;
    }

    private ScanSettingsCompat(Parcel parcel) {
        AppMethodBeat.i(94338);
        this.hGe = parcel.readInt();
        this.hGf = parcel.readInt();
        this.hGg = parcel.readLong();
        AppMethodBeat.o(94338);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(94339);
        parcel.writeInt(this.hGe);
        parcel.writeInt(this.hGf);
        parcel.writeLong(this.hGg);
        AppMethodBeat.o(94339);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.i(94340);
        AppMethodBeat.o(94340);
    }
}
