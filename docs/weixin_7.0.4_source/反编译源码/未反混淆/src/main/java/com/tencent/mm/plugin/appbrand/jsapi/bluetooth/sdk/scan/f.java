package com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.annotation.TargetApi;
import android.bluetooth.le.ScanRecord;
import android.os.ParcelUuid;
import android.support.v4.f.a;
import android.support.v4.widget.j;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class f {
    private final int hFV;
    public final List<ParcelUuid> hFW;
    public final SparseArray<byte[]> hFX;
    public final Map<ParcelUuid, byte[]> hFY;
    private final int hFZ;
    final byte[] mBytes;
    public final String mDeviceName;

    private f(List<ParcelUuid> list, SparseArray<byte[]> sparseArray, Map<ParcelUuid, byte[]> map, int i, int i2, String str, byte[] bArr) {
        this.hFW = list;
        this.hFX = sparseArray;
        this.hFY = map;
        this.mDeviceName = str;
        this.hFV = i;
        this.hFZ = i2;
        this.mBytes = bArr;
    }

    @TargetApi(21)
    f(ScanRecord scanRecord) {
        AppMethodBeat.i(94320);
        this.hFW = scanRecord.getServiceUuids();
        this.hFX = scanRecord.getManufacturerSpecificData();
        this.hFY = scanRecord.getServiceData();
        this.mDeviceName = scanRecord.getDeviceName();
        this.hFV = scanRecord.getAdvertiseFlags();
        this.hFZ = scanRecord.getTxPowerLevel();
        this.mBytes = scanRecord.getBytes();
        AppMethodBeat.o(94320);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b2 A:{Catch:{ Exception -> 0x0046 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static f aj(byte[] bArr) {
        AppMethodBeat.i(94321);
        if (bArr == null) {
            AppMethodBeat.o(94321);
            return null;
        }
        f fVar;
        int i = 0;
        List arrayList = new ArrayList();
        SparseArray sparseArray = new SparseArray();
        a aVar = new a();
        int i2 = j.INVALID_ID;
        String str = null;
        int i3 = -1;
        while (i < bArr.length) {
            try {
                int i4 = i + 1;
                i = bArr[i] & 255;
                if (i != 0) {
                    i--;
                    int i5 = i4 + 1;
                    switch (bArr[i4] & 255) {
                        case 1:
                            i3 = bArr[i5] & 255;
                            break;
                        case 2:
                        case 3:
                            a(bArr, i5, i, 2, arrayList);
                            break;
                        case 4:
                        case 5:
                            a(bArr, i5, i, 4, arrayList);
                            break;
                        case 6:
                        case 7:
                            a(bArr, i5, i, 16, arrayList);
                            break;
                        case 8:
                        case 9:
                            str = new String(p(bArr, i5, i));
                            break;
                        case 10:
                            i2 = bArr[i5];
                            break;
                        case 22:
                            aVar.put(c.ai(p(bArr, i5, 2)), p(bArr, i5 + 2, i - 2));
                            break;
                        case 255:
                            sparseArray.put(((bArr[i5 + 1] & 255) << 8) + (bArr[i5] & 255), p(bArr, i5 + 2, i - 2));
                            break;
                        default:
                            break;
                    }
                    i += i5;
                } else {
                    if (arrayList.isEmpty()) {
                        arrayList = null;
                    }
                    fVar = new f(arrayList, sparseArray, aVar, i3, i2, str, bArr);
                    AppMethodBeat.o(94321);
                    return fVar;
                }
            } catch (Exception e) {
                new StringBuilder("unable to parse scan record: ").append(Arrays.toString(bArr));
                fVar = new f(null, null, null, -1, j.INVALID_ID, null, bArr);
                AppMethodBeat.o(94321);
                return fVar;
            }
        }
        if (arrayList.isEmpty()) {
        }
        fVar = new f(arrayList, sparseArray, aVar, i3, i2, str, bArr);
        AppMethodBeat.o(94321);
        return fVar;
    }

    public final String toString() {
        AppMethodBeat.i(94322);
        String str = "ScanRecord [mAdvertiseFlags=" + this.hFV + ", mServiceUuids=" + this.hFW + ", mManufacturerSpecificData=" + c(this.hFX) + ", mServiceData=" + x(this.hFY) + ", mTxPowerLevel=" + this.hFZ + ", mDeviceName=" + this.mDeviceName + "]";
        AppMethodBeat.o(94322);
        return str;
    }

    private static int a(byte[] bArr, int i, int i2, int i3, List<ParcelUuid> list) {
        AppMethodBeat.i(94323);
        while (i2 > 0) {
            list.add(c.ai(p(bArr, i, i3)));
            i2 -= i3;
            i += i3;
        }
        AppMethodBeat.o(94323);
        return i;
    }

    private static byte[] p(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(94324);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        AppMethodBeat.o(94324);
        return bArr2;
    }

    private static String c(SparseArray<byte[]> sparseArray) {
        AppMethodBeat.i(94325);
        String str;
        if (sparseArray == null) {
            str = BuildConfig.COMMAND;
            AppMethodBeat.o(94325);
            return str;
        } else if (sparseArray.size() == 0) {
            str = "{}";
            AppMethodBeat.o(94325);
            return str;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('{');
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < sparseArray.size()) {
                    stringBuilder.append(sparseArray.keyAt(i2)).append("=").append(Arrays.toString((byte[]) sparseArray.valueAt(i2)));
                    i = i2 + 1;
                } else {
                    stringBuilder.append('}');
                    str = stringBuilder.toString();
                    AppMethodBeat.o(94325);
                    return str;
                }
            }
        }
    }

    private static <T> String x(Map<T, byte[]> map) {
        AppMethodBeat.i(94326);
        String str;
        if (map == null) {
            str = BuildConfig.COMMAND;
            AppMethodBeat.o(94326);
            return str;
        } else if (map.isEmpty()) {
            str = "{}";
            AppMethodBeat.o(94326);
            return str;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('{');
            Iterator it = map.entrySet().iterator();
            while (it.hasNext()) {
                Object key = ((Entry) it.next()).getKey();
                stringBuilder.append(key).append("=").append(Arrays.toString((byte[]) map.get(key)));
                if (it.hasNext()) {
                    stringBuilder.append(", ");
                }
            }
            stringBuilder.append('}');
            str = stringBuilder.toString();
            AppMethodBeat.o(94326);
            return str;
        }
    }
}
