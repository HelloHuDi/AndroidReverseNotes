package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanSettingsCompat */
public class ScanSettingsCompat implements Parcelable {
    public static final Creator<ScanSettingsCompat> CREATOR = new C22381();
    final int hGe;
    private final int hGf;
    final long hGg;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanSettingsCompat$1 */
    static class C22381 implements Creator<ScanSettingsCompat> {
        C22381() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ScanSettingsCompat[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(94335);
            ScanSettingsCompat scanSettingsCompat = new ScanSettingsCompat(parcel, (byte) 0);
            AppMethodBeat.m2505o(94335);
            return scanSettingsCompat;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanSettingsCompat$a */
    public static final class C19343a {
        private int hGe = 0;
        private final int hGf = 1;
        private long hGg = 0;

        /* renamed from: of */
        public final C19343a mo34507of(int i) {
            AppMethodBeat.m2504i(94336);
            if (i < 0 || i > 2) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("invalid scan mode ".concat(String.valueOf(i)));
                AppMethodBeat.m2505o(94336);
                throw illegalArgumentException;
            }
            this.hGe = i;
            AppMethodBeat.m2505o(94336);
            return this;
        }

        public final ScanSettingsCompat aCW() {
            AppMethodBeat.m2504i(94337);
            ScanSettingsCompat scanSettingsCompat = new ScanSettingsCompat(this.hGe, this.hGg, (byte) 0);
            AppMethodBeat.m2505o(94337);
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
        AppMethodBeat.m2504i(94338);
        this.hGe = parcel.readInt();
        this.hGf = parcel.readInt();
        this.hGg = parcel.readLong();
        AppMethodBeat.m2505o(94338);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(94339);
        parcel.writeInt(this.hGe);
        parcel.writeInt(this.hGf);
        parcel.writeLong(this.hGg);
        AppMethodBeat.m2505o(94339);
    }

    public int describeContents() {
        return 0;
    }

    static {
        AppMethodBeat.m2504i(94340);
        AppMethodBeat.m2505o(94340);
    }
}
