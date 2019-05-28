package com.tencent.p177mm.plugin.appbrand.jsapi.bluetooth.sdk.scan;

import android.annotation.TargetApi;
import android.bluetooth.le.ScanRecord;
import android.os.ParcelUuid;
import android.support.p057v4.p065f.C6197a;
import android.support.p057v4.widget.C8415j;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bluetooth.sdk.scan.f */
public final class C42488f {
    private final int hFV;
    public final List<ParcelUuid> hFW;
    public final SparseArray<byte[]> hFX;
    public final Map<ParcelUuid, byte[]> hFY;
    private final int hFZ;
    final byte[] mBytes;
    public final String mDeviceName;

    private C42488f(List<ParcelUuid> list, SparseArray<byte[]> sparseArray, Map<ParcelUuid, byte[]> map, int i, int i2, String str, byte[] bArr) {
        this.hFW = list;
        this.hFX = sparseArray;
        this.hFY = map;
        this.mDeviceName = str;
        this.hFV = i;
        this.hFZ = i2;
        this.mBytes = bArr;
    }

    @TargetApi(21)
    C42488f(ScanRecord scanRecord) {
        AppMethodBeat.m2504i(94320);
        this.hFW = scanRecord.getServiceUuids();
        this.hFX = scanRecord.getManufacturerSpecificData();
        this.hFY = scanRecord.getServiceData();
        this.mDeviceName = scanRecord.getDeviceName();
        this.hFV = scanRecord.getAdvertiseFlags();
        this.hFZ = scanRecord.getTxPowerLevel();
        this.mBytes = scanRecord.getBytes();
        AppMethodBeat.m2505o(94320);
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b2 A:{Catch:{ Exception -> 0x0046 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: aj */
    public static C42488f m75261aj(byte[] bArr) {
        AppMethodBeat.m2504i(94321);
        if (bArr == null) {
            AppMethodBeat.m2505o(94321);
            return null;
        }
        C42488f c42488f;
        int i = 0;
        List arrayList = new ArrayList();
        SparseArray sparseArray = new SparseArray();
        C6197a c6197a = new C6197a();
        int i2 = C8415j.INVALID_ID;
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
                            C42488f.m75260a(bArr, i5, i, 2, arrayList);
                            break;
                        case 4:
                        case 5:
                            C42488f.m75260a(bArr, i5, i, 4, arrayList);
                            break;
                        case 6:
                        case 7:
                            C42488f.m75260a(bArr, i5, i, 16, arrayList);
                            break;
                        case 8:
                        case 9:
                            str = new String(C42488f.m75263p(bArr, i5, i));
                            break;
                        case 10:
                            i2 = bArr[i5];
                            break;
                        case 22:
                            c6197a.put(C33268c.m54417ai(C42488f.m75263p(bArr, i5, 2)), C42488f.m75263p(bArr, i5 + 2, i - 2));
                            break;
                        case 255:
                            sparseArray.put(((bArr[i5 + 1] & 255) << 8) + (bArr[i5] & 255), C42488f.m75263p(bArr, i5 + 2, i - 2));
                            break;
                        default:
                            break;
                    }
                    i += i5;
                } else {
                    if (arrayList.isEmpty()) {
                        arrayList = null;
                    }
                    c42488f = new C42488f(arrayList, sparseArray, c6197a, i3, i2, str, bArr);
                    AppMethodBeat.m2505o(94321);
                    return c42488f;
                }
            } catch (Exception e) {
                new StringBuilder("unable to parse scan record: ").append(Arrays.toString(bArr));
                c42488f = new C42488f(null, null, null, -1, C8415j.INVALID_ID, null, bArr);
                AppMethodBeat.m2505o(94321);
                return c42488f;
            }
        }
        if (arrayList.isEmpty()) {
        }
        c42488f = new C42488f(arrayList, sparseArray, c6197a, i3, i2, str, bArr);
        AppMethodBeat.m2505o(94321);
        return c42488f;
    }

    public final String toString() {
        AppMethodBeat.m2504i(94322);
        String str = "ScanRecord [mAdvertiseFlags=" + this.hFV + ", mServiceUuids=" + this.hFW + ", mManufacturerSpecificData=" + C42488f.m75262c(this.hFX) + ", mServiceData=" + C42488f.m75264x(this.hFY) + ", mTxPowerLevel=" + this.hFZ + ", mDeviceName=" + this.mDeviceName + "]";
        AppMethodBeat.m2505o(94322);
        return str;
    }

    /* renamed from: a */
    private static int m75260a(byte[] bArr, int i, int i2, int i3, List<ParcelUuid> list) {
        AppMethodBeat.m2504i(94323);
        while (i2 > 0) {
            list.add(C33268c.m54417ai(C42488f.m75263p(bArr, i, i3)));
            i2 -= i3;
            i += i3;
        }
        AppMethodBeat.m2505o(94323);
        return i;
    }

    /* renamed from: p */
    private static byte[] m75263p(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(94324);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        AppMethodBeat.m2505o(94324);
        return bArr2;
    }

    /* renamed from: c */
    private static String m75262c(SparseArray<byte[]> sparseArray) {
        AppMethodBeat.m2504i(94325);
        String str;
        if (sparseArray == null) {
            str = BuildConfig.COMMAND;
            AppMethodBeat.m2505o(94325);
            return str;
        } else if (sparseArray.size() == 0) {
            str = "{}";
            AppMethodBeat.m2505o(94325);
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
                    AppMethodBeat.m2505o(94325);
                    return str;
                }
            }
        }
    }

    /* renamed from: x */
    private static <T> String m75264x(Map<T, byte[]> map) {
        AppMethodBeat.m2504i(94326);
        String str;
        if (map == null) {
            str = BuildConfig.COMMAND;
            AppMethodBeat.m2505o(94326);
            return str;
        } else if (map.isEmpty()) {
            str = "{}";
            AppMethodBeat.m2505o(94326);
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
            AppMethodBeat.m2505o(94326);
            return str;
        }
    }
}
