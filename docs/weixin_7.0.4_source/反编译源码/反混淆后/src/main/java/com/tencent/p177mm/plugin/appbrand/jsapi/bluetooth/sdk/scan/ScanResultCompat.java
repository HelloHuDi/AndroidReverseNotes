package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanResult;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanResultCompat */
public class ScanResultCompat implements Parcelable {
    public static final Creator<ScanResultCompat> CREATOR = new C332671();
    private BluetoothDevice hGa;
    public C42488f hGb;
    public int hGc;
    private long hGd;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanResultCompat$1 */
    static class C332671 implements Creator<ScanResultCompat> {
        C332671() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ScanResultCompat[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(94327);
            ScanResultCompat scanResultCompat = new ScanResultCompat(parcel, (byte) 0);
            AppMethodBeat.m2505o(94327);
            return scanResultCompat;
        }
    }

    /* synthetic */ ScanResultCompat(Parcel parcel, byte b) {
        this(parcel);
    }

    public ScanResultCompat(BluetoothDevice bluetoothDevice, C42488f c42488f, int i, long j) {
        this.hGa = bluetoothDevice;
        this.hGb = c42488f;
        this.hGc = i;
        this.hGd = j;
    }

    @TargetApi(21)
    ScanResultCompat(ScanResult scanResult) {
        AppMethodBeat.m2504i(94328);
        this.hGa = scanResult.getDevice();
        this.hGb = new C42488f(scanResult.getScanRecord());
        this.hGc = scanResult.getRssi();
        this.hGd = System.currentTimeMillis();
        AppMethodBeat.m2505o(94328);
    }

    private ScanResultCompat(Parcel parcel) {
        AppMethodBeat.m2504i(94329);
        if (parcel.readInt() == 1) {
            this.hGa = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(parcel);
        }
        if (parcel.readInt() == 1) {
            this.hGb = C42488f.m75261aj(parcel.createByteArray());
        }
        this.hGc = parcel.readInt();
        this.hGd = parcel.readLong();
        AppMethodBeat.m2505o(94329);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(94330);
        if (this.hGa != null) {
            parcel.writeInt(1);
            this.hGa.writeToParcel(parcel, i);
        } else {
            parcel.writeInt(0);
        }
        if (this.hGb != null) {
            parcel.writeInt(1);
            parcel.writeByteArray(this.hGb.mBytes);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.hGc);
        parcel.writeLong(this.hGd);
        AppMethodBeat.m2505o(94330);
    }

    public int describeContents() {
        return 0;
    }

    public final BluetoothDevice getDevice() {
        if (this.hGa != null) {
            return this.hGa;
        }
        return null;
    }

    public int hashCode() {
        AppMethodBeat.m2504i(94331);
        int hashCode = Arrays.hashCode(new Object[]{this.hGa, Integer.valueOf(this.hGc), this.hGb, Long.valueOf(this.hGd)});
        AppMethodBeat.m2505o(94331);
        return hashCode;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(94332);
        if (this == obj) {
            AppMethodBeat.m2505o(94332);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.m2505o(94332);
            return false;
        } else {
            ScanResultCompat scanResultCompat = (ScanResultCompat) obj;
            if (C19344d.equals(this.hGa, scanResultCompat.hGa) && this.hGc == scanResultCompat.hGc && C19344d.equals(this.hGb, scanResultCompat.hGb) && this.hGd == scanResultCompat.hGd) {
                AppMethodBeat.m2505o(94332);
                return true;
            }
            AppMethodBeat.m2505o(94332);
            return false;
        }
    }

    public String toString() {
        AppMethodBeat.m2504i(94333);
        String str = "ScanResult{mDevice=" + this.hGa + ", mScanRecord=" + C19344d.toString(this.hGb) + ", mRssi=" + this.hGc + ", mTimestampNanos=" + this.hGd + '}';
        AppMethodBeat.m2505o(94333);
        return str;
    }

    static {
        AppMethodBeat.m2504i(94334);
        AppMethodBeat.m2505o(94334);
    }
}
