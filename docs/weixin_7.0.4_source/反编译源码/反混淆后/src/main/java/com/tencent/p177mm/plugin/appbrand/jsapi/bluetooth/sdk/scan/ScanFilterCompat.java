package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.bluetooth.BluetoothAdapter;
import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.UUID;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanFilterCompat */
public class ScanFilterCompat implements Parcelable {
    public static final Creator<ScanFilterCompat> CREATOR = new C332661();
    private static final ScanFilterCompat hFT = new C10347a().aCV();
    final String hFK;
    final ParcelUuid hFL;
    final ParcelUuid hFM;
    final ParcelUuid hFN;
    final byte[] hFO;
    final byte[] hFP;
    final int hFQ;
    final byte[] hFR;
    final byte[] hFS;
    final String mDeviceName;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanFilterCompat$a */
    public static final class C10347a {
        String hFK;
        ParcelUuid hFL;
        ParcelUuid hFN;
        byte[] hFO;
        byte[] hFP;
        int hFQ = -1;
        byte[] hFR;
        byte[] hFS;
        ParcelUuid hFU;
        String mDeviceName;

        /* renamed from: a */
        public final C10347a mo21819a(ParcelUuid parcelUuid) {
            this.hFL = parcelUuid;
            this.hFU = null;
            return this;
        }

        public final ScanFilterCompat aCV() {
            AppMethodBeat.m2504i(94313);
            ScanFilterCompat scanFilterCompat = new ScanFilterCompat(this.mDeviceName, this.hFK, this.hFL, this.hFU, this.hFN, this.hFO, this.hFP, this.hFQ, this.hFR, this.hFS, (byte) 0);
            AppMethodBeat.m2505o(94313);
            return scanFilterCompat;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.ScanFilterCompat$1 */
    static class C332661 implements Creator<ScanFilterCompat> {
        C332661() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ScanFilterCompat[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            ParcelUuid parcelUuid;
            IllegalArgumentException illegalArgumentException;
            byte[] bArr;
            byte[] bArr2;
            AppMethodBeat.m2504i(94312);
            C10347a c10347a = new C10347a();
            if (parcel.readInt() == 1) {
                c10347a.mDeviceName = parcel.readString();
            }
            if (parcel.readInt() == 1) {
                String readString = parcel.readString();
                if (readString == null || BluetoothAdapter.checkBluetoothAddress(readString)) {
                    c10347a.hFK = readString;
                } else {
                    IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("invalid device address ".concat(String.valueOf(readString)));
                    AppMethodBeat.m2505o(94312);
                    throw illegalArgumentException2;
                }
            }
            if (parcel.readInt() == 1) {
                parcelUuid = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
                c10347a.mo21819a(parcelUuid);
                if (parcel.readInt() == 1) {
                    ParcelUuid parcelUuid2 = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
                    if (c10347a.hFU == null || c10347a.hFL != null) {
                        c10347a.hFL = parcelUuid;
                        c10347a.hFU = parcelUuid2;
                    } else {
                        illegalArgumentException = new IllegalArgumentException("uuid is null while uuidMask is not null!");
                        AppMethodBeat.m2505o(94312);
                        throw illegalArgumentException;
                    }
                }
            }
            if (parcel.readInt() == 1) {
                parcelUuid = (ParcelUuid) parcel.readParcelable(ParcelUuid.class.getClassLoader());
                if (parcel.readInt() == 1) {
                    bArr = new byte[parcel.readInt()];
                    parcel.readByteArray(bArr);
                    if (parcel.readInt() != 0) {
                        bArr2 = new byte[parcel.readInt()];
                        parcel.readByteArray(bArr2);
                        if (parcelUuid == null) {
                            illegalArgumentException = new IllegalArgumentException("serviceDataUuid is null");
                            AppMethodBeat.m2505o(94312);
                            throw illegalArgumentException;
                        }
                        if (c10347a.hFP != null) {
                            if (c10347a.hFO == null) {
                                illegalArgumentException = new IllegalArgumentException("serviceData is null while serviceDataMask is not null");
                                AppMethodBeat.m2505o(94312);
                                throw illegalArgumentException;
                            } else if (c10347a.hFO.length != c10347a.hFP.length) {
                                illegalArgumentException = new IllegalArgumentException("size mismatch for service data and service data mask");
                                AppMethodBeat.m2505o(94312);
                                throw illegalArgumentException;
                            }
                        }
                        c10347a.hFN = parcelUuid;
                        c10347a.hFO = bArr;
                        c10347a.hFP = bArr2;
                    } else if (parcelUuid == null) {
                        illegalArgumentException = new IllegalArgumentException("serviceDataUuid is null");
                        AppMethodBeat.m2505o(94312);
                        throw illegalArgumentException;
                    } else {
                        c10347a.hFN = parcelUuid;
                        c10347a.hFO = bArr;
                        c10347a.hFP = null;
                    }
                }
            }
            int readInt = parcel.readInt();
            if (parcel.readInt() == 1) {
                bArr = new byte[parcel.readInt()];
                parcel.readByteArray(bArr);
                if (parcel.readInt() != 0) {
                    bArr2 = new byte[parcel.readInt()];
                    parcel.readByteArray(bArr2);
                    if (readInt < 0) {
                        illegalArgumentException = new IllegalArgumentException("invalid manufacture id");
                        AppMethodBeat.m2505o(94312);
                        throw illegalArgumentException;
                    }
                    if (c10347a.hFS != null) {
                        if (c10347a.hFR == null) {
                            illegalArgumentException = new IllegalArgumentException("manufacturerData is null while manufacturerDataMask is not null");
                            AppMethodBeat.m2505o(94312);
                            throw illegalArgumentException;
                        } else if (c10347a.hFR.length != c10347a.hFS.length) {
                            illegalArgumentException = new IllegalArgumentException("size mismatch for manufacturerData and manufacturerDataMask");
                            AppMethodBeat.m2505o(94312);
                            throw illegalArgumentException;
                        }
                    }
                    c10347a.hFQ = readInt;
                    c10347a.hFR = bArr;
                    c10347a.hFS = bArr2;
                } else if (readInt < 0) {
                    illegalArgumentException = new IllegalArgumentException("invalid manufacture id");
                    AppMethodBeat.m2505o(94312);
                    throw illegalArgumentException;
                } else {
                    c10347a.hFQ = readInt;
                    c10347a.hFR = bArr;
                    c10347a.hFS = null;
                }
            }
            ScanFilterCompat aCV = c10347a.aCV();
            AppMethodBeat.m2505o(94312);
            return aCV;
        }
    }

    /* synthetic */ ScanFilterCompat(String str, String str2, ParcelUuid parcelUuid, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4, byte b) {
        this(str, str2, parcelUuid, parcelUuid2, parcelUuid3, bArr, bArr2, i, bArr3, bArr4);
    }

    static {
        AppMethodBeat.m2504i(94319);
        AppMethodBeat.m2505o(94319);
    }

    private ScanFilterCompat(String str, String str2, ParcelUuid parcelUuid, ParcelUuid parcelUuid2, ParcelUuid parcelUuid3, byte[] bArr, byte[] bArr2, int i, byte[] bArr3, byte[] bArr4) {
        this.mDeviceName = str;
        this.hFL = parcelUuid;
        this.hFM = parcelUuid2;
        this.hFK = str2;
        this.hFN = parcelUuid3;
        this.hFO = bArr;
        this.hFP = bArr2;
        this.hFQ = i;
        this.hFR = bArr3;
        this.hFS = bArr4;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 0;
        AppMethodBeat.m2504i(94314);
        parcel.writeInt(this.mDeviceName == null ? 0 : 1);
        if (this.mDeviceName != null) {
            parcel.writeString(this.mDeviceName);
        }
        if (this.hFK == null) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        parcel.writeInt(i2);
        if (this.hFK != null) {
            parcel.writeString(this.hFK);
        }
        if (this.hFL == null) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        parcel.writeInt(i2);
        if (this.hFL != null) {
            parcel.writeParcelable(this.hFL, i);
            if (this.hFM == null) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            parcel.writeInt(i2);
            if (this.hFM != null) {
                parcel.writeParcelable(this.hFM, i);
            }
        }
        if (this.hFN == null) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        parcel.writeInt(i2);
        if (this.hFN != null) {
            parcel.writeParcelable(this.hFN, i);
            if (this.hFO == null) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            parcel.writeInt(i2);
            if (this.hFO != null) {
                parcel.writeInt(this.hFO.length);
                parcel.writeByteArray(this.hFO);
                if (this.hFP == null) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                parcel.writeInt(i2);
                if (this.hFP != null) {
                    parcel.writeInt(this.hFP.length);
                    parcel.writeByteArray(this.hFP);
                }
            }
        }
        parcel.writeInt(this.hFQ);
        if (this.hFR == null) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        parcel.writeInt(i2);
        if (this.hFR != null) {
            parcel.writeInt(this.hFR.length);
            parcel.writeByteArray(this.hFR);
            if (this.hFS != null) {
                i3 = 1;
            }
            parcel.writeInt(i3);
            if (this.hFS != null) {
                parcel.writeInt(this.hFS.length);
                parcel.writeByteArray(this.hFS);
            }
        }
        AppMethodBeat.m2505o(94314);
    }

    /* renamed from: a */
    static boolean m75257a(UUID uuid, UUID uuid2, UUID uuid3) {
        AppMethodBeat.m2504i(94315);
        if (uuid2 == null) {
            boolean equals = uuid.equals(uuid3);
            AppMethodBeat.m2505o(94315);
            return equals;
        } else if ((uuid.getLeastSignificantBits() & uuid2.getLeastSignificantBits()) != (uuid3.getLeastSignificantBits() & uuid2.getLeastSignificantBits())) {
            AppMethodBeat.m2505o(94315);
            return false;
        } else if ((uuid.getMostSignificantBits() & uuid2.getMostSignificantBits()) == (uuid3.getMostSignificantBits() & uuid2.getMostSignificantBits())) {
            AppMethodBeat.m2505o(94315);
            return true;
        } else {
            AppMethodBeat.m2505o(94315);
            return false;
        }
    }

    /* renamed from: a */
    static boolean m75258a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        if (bArr3 == null || bArr3.length < bArr.length) {
            return false;
        }
        int i;
        if (bArr2 == null) {
            for (i = 0; i < bArr.length; i++) {
                if (bArr3[i] != bArr[i]) {
                    return false;
                }
            }
            return true;
        }
        for (i = 0; i < bArr.length; i++) {
            if ((bArr2[i] & bArr3[i]) != (bArr2[i] & bArr[i])) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        AppMethodBeat.m2504i(94316);
        String str = "BluetoothLeScanFilter [mDeviceName=" + this.mDeviceName + ", mDeviceAddress=" + this.hFK + ", mUuid=" + this.hFL + ", mUuidMask=" + this.hFM + ", mServiceDataUuid=" + C19344d.toString(this.hFN) + ", mServiceData=" + Arrays.toString(this.hFO) + ", mServiceDataMask=" + Arrays.toString(this.hFP) + ", mManufacturerId=" + this.hFQ + ", mManufacturerData=" + Arrays.toString(this.hFR) + ", mManufacturerDataMask=" + Arrays.toString(this.hFS) + "]";
        AppMethodBeat.m2505o(94316);
        return str;
    }

    public int hashCode() {
        AppMethodBeat.m2504i(94317);
        int hashCode = Arrays.hashCode(new Object[]{this.mDeviceName, this.hFK, Integer.valueOf(this.hFQ), this.hFR, this.hFS, this.hFN, this.hFO, this.hFP, this.hFL, this.hFM});
        AppMethodBeat.m2505o(94317);
        return hashCode;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(94318);
        if (this == obj) {
            AppMethodBeat.m2505o(94318);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.m2505o(94318);
            return false;
        } else {
            ScanFilterCompat scanFilterCompat = (ScanFilterCompat) obj;
            if (C19344d.equals(this.mDeviceName, scanFilterCompat.mDeviceName) && C19344d.equals(this.hFK, scanFilterCompat.hFK) && this.hFQ == scanFilterCompat.hFQ && C19344d.deepEquals(this.hFR, scanFilterCompat.hFR) && C19344d.deepEquals(this.hFS, scanFilterCompat.hFS) && C19344d.deepEquals(this.hFN, scanFilterCompat.hFN) && C19344d.deepEquals(this.hFO, scanFilterCompat.hFO) && C19344d.deepEquals(this.hFP, scanFilterCompat.hFP) && C19344d.equals(this.hFL, scanFilterCompat.hFL) && C19344d.equals(this.hFM, scanFilterCompat.hFM)) {
                AppMethodBeat.m2505o(94318);
                return true;
            }
            AppMethodBeat.m2505o(94318);
            return false;
        }
    }
}
