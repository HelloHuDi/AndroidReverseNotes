package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanResult;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public class ScanResultCompat implements Parcelable {
    public static final Creator<ScanResultCompat> CREATOR = new Creator<ScanResultCompat>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ScanResultCompat[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(94327);
            ScanResultCompat scanResultCompat = new ScanResultCompat(parcel, (byte) 0);
            AppMethodBeat.o(94327);
            return scanResultCompat;
        }
    };
    private BluetoothDevice hGa;
    public f hGb;
    public int hGc;
    private long hGd;

    /* synthetic */ ScanResultCompat(Parcel parcel, byte b) {
        this(parcel);
    }

    public ScanResultCompat(BluetoothDevice bluetoothDevice, f fVar, int i, long j) {
        this.hGa = bluetoothDevice;
        this.hGb = fVar;
        this.hGc = i;
        this.hGd = j;
    }

    @TargetApi(21)
    ScanResultCompat(ScanResult scanResult) {
        AppMethodBeat.i(94328);
        this.hGa = scanResult.getDevice();
        this.hGb = new f(scanResult.getScanRecord());
        this.hGc = scanResult.getRssi();
        this.hGd = System.currentTimeMillis();
        AppMethodBeat.o(94328);
    }

    private ScanResultCompat(Parcel parcel) {
        AppMethodBeat.i(94329);
        if (parcel.readInt() == 1) {
            this.hGa = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(parcel);
        }
        if (parcel.readInt() == 1) {
            this.hGb = f.aj(parcel.createByteArray());
        }
        this.hGc = parcel.readInt();
        this.hGd = parcel.readLong();
        AppMethodBeat.o(94329);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(94330);
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
        AppMethodBeat.o(94330);
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
        AppMethodBeat.i(94331);
        int hashCode = Arrays.hashCode(new Object[]{this.hGa, Integer.valueOf(this.hGc), this.hGb, Long.valueOf(this.hGd)});
        AppMethodBeat.o(94331);
        return hashCode;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(94332);
        if (this == obj) {
            AppMethodBeat.o(94332);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(94332);
            return false;
        } else {
            ScanResultCompat scanResultCompat = (ScanResultCompat) obj;
            if (d.equals(this.hGa, scanResultCompat.hGa) && this.hGc == scanResultCompat.hGc && d.equals(this.hGb, scanResultCompat.hGb) && this.hGd == scanResultCompat.hGd) {
                AppMethodBeat.o(94332);
                return true;
            }
            AppMethodBeat.o(94332);
            return false;
        }
    }

    public String toString() {
        AppMethodBeat.i(94333);
        String str = "ScanResult{mDevice=" + this.hGa + ", mScanRecord=" + d.toString(this.hGb) + ", mRssi=" + this.hGc + ", mTimestampNanos=" + this.hGd + '}';
        AppMethodBeat.o(94333);
        return str;
    }

    static {
        AppMethodBeat.i(94334);
        AppMethodBeat.o(94334);
    }
}
