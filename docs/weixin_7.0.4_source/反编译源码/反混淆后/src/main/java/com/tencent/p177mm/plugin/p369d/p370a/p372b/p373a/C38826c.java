package com.tencent.p177mm.plugin.p369d.p370a.p372b.p373a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.plugin.exdevice.p1611j.C42992b;
import com.tencent.p177mm.plugin.p369d.p370a.p372b.C38832h;
import com.tencent.p177mm.plugin.p369d.p370a.p372b.p373a.C24738g.C11471b;
import com.tencent.p177mm.plugin.p369d.p370a.p372b.p373a.C24738g.C24739c;
import com.tencent.p177mm.plugin.p369d.p370a.p372b.p373a.C24738g.C2851a;
import com.tencent.p177mm.plugin.p369d.p370a.p372b.p373a.C42902d.C42901a;
import com.tencent.p177mm.plugin.p369d.p370a.p372b.p373a.C45824b.C11469a;
import com.tencent.p177mm.plugin.p369d.p370a.p372b.p373a.C45824b.C11470b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@TargetApi(18)
/* renamed from: com.tencent.mm.plugin.d.a.b.a.c */
public class C38826c {
    public static final String TAG = C38826c.class.getName();
    private static HashMap<String, Long> jGv = new HashMap();
    private static HashMap<String, Long> jHD;

    static {
        AppMethodBeat.m2504i(18467);
        HashMap hashMap = new HashMap();
        jHD = hashMap;
        hashMap.put(C38832h.jGK, Long.valueOf(1));
        jHD.put(C38832h.jGL, Long.valueOf(1));
        jHD.put(C38832h.jGM, Long.valueOf(16));
        jHD.put(C38832h.jGN, Long.valueOf(16));
        jHD.put(C38832h.jGO, Long.valueOf(16));
        jHD.put(C38832h.jGP, Long.valueOf(16));
        jGv.put(C38832h.jGH, Long.valueOf(0));
        jGv.put(C38832h.jGQ, Long.valueOf(2));
        jGv.put(C38832h.jGT, Long.valueOf(4));
        jGv.put(C38832h.jGX, Long.valueOf(8));
        AppMethodBeat.m2505o(18467);
    }

    /* JADX WARNING: Missing block: B:19:0x00aa, code skipped:
            r2 = r2 + r4;
     */
    /* JADX WARNING: Missing block: B:46:0x001d, code skipped:
            continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: au */
    public static boolean m65876au(byte[] bArr) {
        AppMethodBeat.m2504i(18462);
        if (C5046bo.m7540cb(bArr)) {
            C4990ab.m7412e(TAG, "parseBroadcastServiceUuid error. broadcast data is null or nil");
            AppMethodBeat.m2505o(18462);
            return false;
        }
        int i = 0;
        while (i >= 0 && i < bArr.length) {
            int i2 = i + 1;
            byte b = bArr[i];
            if (i2 + b > bArr.length) {
                C4990ab.m7421w(TAG, "broadcast data len is not enough. offset = %d, current len = %d, broadcast len = %d", Integer.valueOf(i2), Integer.valueOf(b), Integer.valueOf(bArr.length));
                AppMethodBeat.m2505o(18462);
                return false;
            } else if (b <= (byte) 0) {
                C4990ab.m7421w(TAG, "current part of data's len = %d.", Integer.valueOf(b));
                AppMethodBeat.m2505o(18462);
                return false;
            } else {
                int i3 = i2 + 1;
                i = b - 1;
                switch (bArr[i2]) {
                    case (byte) -1:
                        C4990ab.m7417i(TAG, "Manufacturer Specific Data size = %s", Integer.valueOf(i));
                        C4990ab.m7417i(TAG, "Manufacturer Specific Data = %s", C42992b.m76349aN(Arrays.copyOfRange(bArr, i3, i3 + i)));
                        break;
                    case (byte) 2:
                    case (byte) 3:
                        while (2 <= i) {
                            i2 = i3 + 1;
                            int i4 = bArr[i3] & 255;
                            i3 = i2 + 1;
                            i2 = ((bArr[i2] & 255) << 8) | i4;
                            i -= 2;
                            C4990ab.m7411d(TAG, "find 16-bit broacast service = %s", String.format("%08x-0000-1000-8000-00805f9b34fb", new Object[]{Integer.valueOf(i2)}));
                            if (jGv.containsKey(String.format("%08x-0000-1000-8000-00805f9b34fb", new Object[]{Integer.valueOf(i2)}))) {
                                AppMethodBeat.m2505o(18462);
                                return true;
                            }
                        }
                        break;
                    case (byte) 6:
                    case (byte) 7:
                        i2 = i;
                        while (16 <= i2) {
                            try {
                                ByteBuffer order = ByteBuffer.wrap(bArr, i3, 16).order(ByteOrder.LITTLE_ENDIAN);
                                C4990ab.m7411d(TAG, "find 128-bit broacast service = %s", new UUID(order.getLong(), order.getLong()).toString());
                                if (jGv.containsKey(new UUID(order.getLong(), order.getLong()).toString())) {
                                    AppMethodBeat.m2505o(18462);
                                    return true;
                                }
                                i3 += 16;
                                i2 -= 16;
                            } catch (IndexOutOfBoundsException e) {
                                C4990ab.m7412e("BlueToothDeviceFilter.parseUUID", e.toString());
                                i3 += 16;
                                i2 -= 16;
                            } catch (Throwable th) {
                                AppMethodBeat.m2505o(18462);
                            }
                        }
                        i = i3 + i2;
                        continue;
                }
                i += i3;
            }
        }
        AppMethodBeat.m2505o(18462);
        return false;
    }

    /* renamed from: gA */
    public static String m65878gA(long j) {
        String str;
        AppMethodBeat.m2504i(18463);
        for (String str2 : jGv.keySet()) {
            if (((Long) jGv.get(str2)).longValue() == j) {
                AppMethodBeat.m2505o(18463);
                return str2;
            }
        }
        if (jHD.containsValue(Long.valueOf(j))) {
            str2 = C38832h.jGH;
            AppMethodBeat.m2505o(18463);
            return str2;
        }
        AppMethodBeat.m2505o(18463);
        return null;
    }

    /* renamed from: a */
    public static long m65874a(BluetoothGattService bluetoothGattService) {
        long j = 0;
        AppMethodBeat.m2504i(18464);
        if (bluetoothGattService == null) {
            C4990ab.m7412e(TAG, "service is null");
            AppMethodBeat.m2505o(18464);
            return 0;
        }
        String uuid = bluetoothGattService.getUuid().toString();
        Long l;
        if (!uuid.equalsIgnoreCase(C38832h.jGH) || bluetoothGattService.getCharacteristic(UUID.fromString(C38832h.jGK)) == null) {
            l = (Long) jGv.get(uuid);
            if (l != null) {
                j = l.longValue();
            }
            C4990ab.m7411d(TAG, "service uuid = %s, profileType = %d", uuid, Long.valueOf(j));
            AppMethodBeat.m2505o(18464);
            return j;
        }
        List characteristics = bluetoothGattService.getCharacteristics();
        long j2 = 0;
        int i = 0;
        while (i < characteristics.size()) {
            long j3;
            l = (Long) jHD.get(((BluetoothGattCharacteristic) characteristics.get(i)).getUuid().toString());
            if (l == null) {
                j3 = 0;
            } else {
                j3 = l.longValue();
            }
            i++;
            j2 = j3 | j2;
        }
        C4990ab.m7411d(TAG, "wechat service, profileType = %d", Long.valueOf(j2));
        AppMethodBeat.m2505o(18464);
        return j2;
    }

    /* renamed from: b */
    public static boolean m65877b(BluetoothGattService bluetoothGattService) {
        AppMethodBeat.m2504i(18465);
        if (bluetoothGattService == null) {
            C4990ab.m7412e(TAG, "service is null");
            AppMethodBeat.m2505o(18465);
            return false;
        }
        long a = C38826c.m65874a(bluetoothGattService);
        BluetoothGattCharacteristic characteristic;
        int properties;
        if (0 != (1 & a)) {
            if (bluetoothGattService == null) {
                C4990ab.m7412e(TAG, "service is null");
                AppMethodBeat.m2505o(18465);
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(C38832h.jGK));
            if (characteristic == null) {
                C4990ab.m7412e(TAG, "no step measurement characteristic found");
                AppMethodBeat.m2505o(18465);
                return false;
            }
            properties = characteristic.getProperties();
            C4990ab.m7411d(TAG, "step measurement characteristic properties = %d", Integer.valueOf(properties));
            if ((properties & 48) == 0 || (properties & 2) == 0) {
                C4990ab.m7413e(TAG, "step measurement characteristic has incorrect proterties(%d)", Integer.valueOf(properties));
                AppMethodBeat.m2505o(18465);
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(C38832h.jGL));
            if (characteristic != null) {
                properties = characteristic.getProperties();
                if ((properties & 2) == 0 || (properties & 32) == 0) {
                    C4990ab.m7413e(TAG, "step target characteristic has incorrect proterties(%d)", Integer.valueOf(properties));
                    AppMethodBeat.m2505o(18465);
                    return false;
                }
            }
            AppMethodBeat.m2505o(18465);
            return true;
        } else if (0 != (2 & a)) {
            if (bluetoothGattService == null) {
                C4990ab.m7412e(TAG, "service is null");
                AppMethodBeat.m2505o(18465);
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(C38832h.jGR));
            if (characteristic == null) {
                C4990ab.m7412e(TAG, "weight scale feature characteristic not found");
                AppMethodBeat.m2505o(18465);
                return false;
            }
            if ((characteristic.getProperties() & 2) == 0) {
                C4990ab.m7413e(TAG, "weight scale feature characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(characteristic.getProperties()), Integer.valueOf(2));
                AppMethodBeat.m2505o(18465);
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(C38832h.jGS));
            if (characteristic == null) {
                C4990ab.m7412e(TAG, "weight measurement characteristic not found");
                AppMethodBeat.m2505o(18465);
                return false;
            }
            if ((characteristic.getProperties() & 32) == 0) {
                C4990ab.m7413e(TAG, "weight measurement characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(characteristic.getProperties()), Integer.valueOf(32));
                AppMethodBeat.m2505o(18465);
                return false;
            }
            AppMethodBeat.m2505o(18465);
            return true;
        } else if (0 != (4 & a)) {
            if (bluetoothGattService == null) {
                C4990ab.m7412e(TAG, "service is null");
                AppMethodBeat.m2505o(18465);
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(C38832h.jGU));
            if (characteristic == null) {
                C4990ab.m7412e(TAG, "heart rate measurement characteristic not found");
                AppMethodBeat.m2505o(18465);
                return false;
            }
            if ((characteristic.getProperties() & 16) == 0) {
                C4990ab.m7413e(TAG, "heart rate measurement characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(characteristic.getProperties()), Integer.valueOf(16));
                AppMethodBeat.m2505o(18465);
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(C38832h.jGV));
            if (characteristic != null) {
                if ((characteristic.getProperties() & 2) == 0) {
                    C4990ab.m7413e(TAG, "heart rate body sensor location characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(characteristic.getProperties()), Integer.valueOf(2));
                    AppMethodBeat.m2505o(18465);
                    return false;
                }
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(C38832h.jGW));
            if (characteristic != null) {
                if ((characteristic.getProperties() & 8) == 0) {
                    C4990ab.m7413e(TAG, "heart rate control point characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(characteristic.getProperties()), Integer.valueOf(8));
                    AppMethodBeat.m2505o(18465);
                    return false;
                }
            }
            AppMethodBeat.m2505o(18465);
            return true;
        } else if (0 != (8 & a)) {
            if (bluetoothGattService == null) {
                C4990ab.m7412e(TAG, "service is null");
                AppMethodBeat.m2505o(18465);
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(C38832h.jGY));
            if (characteristic == null) {
                C4990ab.m7412e(TAG, "blood pressure measurement characteristic not found");
                AppMethodBeat.m2505o(18465);
                return false;
            }
            if ((characteristic.getProperties() & 32) == 0) {
                C4990ab.m7413e(TAG, "blood pressure measurement characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(characteristic.getProperties()), Integer.valueOf(32));
                AppMethodBeat.m2505o(18465);
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(C38832h.jHa));
            if (characteristic == null) {
                C4990ab.m7412e(TAG, "blood pressure feature characteristic not found");
                AppMethodBeat.m2505o(18465);
                return false;
            }
            if ((characteristic.getProperties() & 2) == 0) {
                C4990ab.m7413e(TAG, "blood pressure feature characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(characteristic.getProperties()), Integer.valueOf(2));
                AppMethodBeat.m2505o(18465);
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(C38832h.jGZ));
            if (characteristic != null) {
                if ((characteristic.getProperties() & 16) == 0) {
                    C4990ab.m7413e(TAG, "blood pressure intermediate cuff pressure characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(characteristic.getProperties()), Integer.valueOf(16));
                    AppMethodBeat.m2505o(18465);
                    return false;
                }
            }
            AppMethodBeat.m2505o(18465);
            return true;
        } else if (0 == (a & 16)) {
            AppMethodBeat.m2505o(18465);
            return false;
        } else if (bluetoothGattService == null) {
            C4990ab.m7412e(TAG, "service is null");
            AppMethodBeat.m2505o(18465);
            return false;
        } else {
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(C38832h.jGM));
            if (characteristic == null) {
                C4990ab.m7412e(TAG, "light color characteristic not found");
                AppMethodBeat.m2505o(18465);
                return false;
            }
            properties = characteristic.getProperties();
            if ((properties & 32) == 0 || (properties & 16) == 0 || (properties & 2) == 0 || (properties & 8) == 0) {
                C4990ab.m7413e(TAG, "light color characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(properties), Integer.valueOf(32));
                AppMethodBeat.m2505o(18465);
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(C38832h.jGN));
            if (characteristic == null) {
                C4990ab.m7412e(TAG, "light work state characteristic not found");
                AppMethodBeat.m2505o(18465);
                return false;
            }
            properties = characteristic.getProperties();
            if ((properties & 32) == 0 || (properties & 2) == 0 || (properties & 8) == 0) {
                C4990ab.m7413e(TAG, "light work state characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(properties), Integer.valueOf(32));
                AppMethodBeat.m2505o(18465);
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(C38832h.jGO));
            if (characteristic == null) {
                C4990ab.m7412e(TAG, "light state changed characteristic not found");
                AppMethodBeat.m2505o(18465);
                return false;
            }
            if ((characteristic.getProperties() & 32) == 0) {
                C4990ab.m7413e(TAG, "light state changed characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(characteristic.getProperties()), Integer.valueOf(32));
                AppMethodBeat.m2505o(18465);
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(C38832h.jGP));
            if (characteristic == null) {
                C4990ab.m7412e(TAG, "control point characteristic not found");
                AppMethodBeat.m2505o(18465);
                return false;
            }
            properties = characteristic.getProperties();
            if ((properties & 32) == 0 || (properties & 8) == 0) {
                C4990ab.m7413e(TAG, "control point characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(properties), Integer.valueOf(32));
                AppMethodBeat.m2505o(18465);
                return false;
            }
            AppMethodBeat.m2505o(18465);
            return true;
        }
    }

    /* renamed from: a */
    public static byte[] m65875a(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        int i = 0;
        AppMethodBeat.m2504i(18466);
        if (bluetoothGattCharacteristic == null || bArr == null) {
            C4990ab.m7412e(TAG, "characteristic or recvData is null");
            AppMethodBeat.m2505o(18466);
            return null;
        }
        byte[] bQ;
        long j = 0;
        String uuid = bluetoothGattCharacteristic.getUuid().toString();
        BluetoothGattService service = bluetoothGattCharacteristic.getService();
        if (service != null) {
            j = C38826c.m65874a(service);
        } else {
            C4990ab.m7412e(TAG, "the characteristic has no parent service");
        }
        C4990ab.m7411d(TAG, "recv data. uuid = %s, data = %s", uuid, C42992b.m76349aN(bArr));
        int i2;
        int i3;
        int i4;
        if (0 != (1 & j) && (uuid.equalsIgnoreCase(C24737f.jIf) || uuid.equalsIgnoreCase(C24737f.jIg))) {
            C24737f c24737f = new C24737f();
            if (bArr.length <= 0 || (bArr[0] & 1) == 0) {
                C4990ab.m7412e(C24737f.TAG, "pase step data error");
                i2 = 0;
            } else if (uuid == null || !(uuid.equals(C24737f.jIf) || uuid.equals(C24737f.jIg))) {
                C4990ab.m7412e(C24737f.TAG, "uuid is not correct");
                i2 = 0;
            } else {
                c24737f.jHc = uuid;
                i2 = 4;
                if ((bArr[0] & 2) != 0) {
                    i2 = 7;
                }
                if ((bArr[0] & 4) != 0) {
                    i2 += 3;
                }
                if (i2 > bArr.length) {
                    C4990ab.m7412e(C24737f.TAG, "data len is not enough");
                    i2 = 0;
                } else {
                    c24737f.jIh = 0;
                    i2 = 1;
                    for (i3 = 0; i3 < 3; i3++) {
                        c24737f.jIh += (bArr[i2] & 255) << (i3 * 8);
                        i2++;
                    }
                    if ((bArr[0] & 2) != 0) {
                        c24737f.jIi = 0;
                        for (i3 = 0; i3 < 3; i3++) {
                            c24737f.jIi += (bArr[i2] & 255) << (i3 * 8);
                            i2++;
                        }
                    }
                    if ((bArr[0] & 4) != 0) {
                        c24737f.jIj = 0;
                        i4 = i2;
                        for (i3 = 0; i3 < 3; i3++) {
                            c24737f.jIj += (bArr[i4] & 255) << (i3 * 8);
                            i4++;
                        }
                    }
                    i2 = 1;
                }
            }
            if (i2 != 0) {
                bQ = C42992b.m76353bQ(c24737f);
                C4990ab.m7411d(TAG, "step info. stepCount=%d, stepDistance=%d, stepColarie=%d", Integer.valueOf(c24737f.jIh), Integer.valueOf(c24737f.jIi), Integer.valueOf(c24737f.jIj));
            } else {
                C4990ab.m7412e(TAG, "parse step data error");
                bQ = null;
            }
        } else if (0 != (2 & j) && (uuid.equalsIgnoreCase(C24738g.jGS) || uuid.equalsIgnoreCase(C24738g.jGR))) {
            C24738g c24738g = new C24738g();
            if (uuid == null || uuid.length() <= 0 || bArr == null || bArr.length <= 0) {
                C4990ab.m7412e(C24738g.TAG, "characteristicUuid or data is null or nil");
                i2 = 0;
            } else {
                c24738g.jHc = uuid;
                String str;
                Object[] objArr;
                if (c24738g.jHc.equalsIgnoreCase(C24738g.jGR)) {
                    if (4 > bArr.length) {
                        C4990ab.m7413e(C24738g.TAG, "weight scale feature characteristic data is a 32bit value, but current value len is %d", Integer.valueOf(bArr.length));
                        i2 = 0;
                    } else {
                        boolean z;
                        c24738g.jIm = new C24739c();
                        c24738g.jIm.jIr = (bArr[0] & 1) != 0;
                        C24739c c24739c = c24738g.jIm;
                        if ((bArr[0] & 2) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        c24739c.jIs = z;
                        c24739c = c24738g.jIm;
                        if ((bArr[0] & 4) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        c24739c.jIt = z;
                        c24738g.jIm.jIu = (byte) ((bArr[0] & 120) >> 3);
                        c24738g.jIm.jIv = (byte) (((bArr[0] & 128) >> 7) + ((bArr[1] & 3) << 1));
                        uuid = C24738g.TAG;
                        str = "timestampSupported = %s, multipleUsersSupported = %s, BMISupported = %s, weightResolution = %d, heightResolution = %d";
                        objArr = new Object[5];
                        objArr[0] = c24738g.jIm.jIr ? "true" : "false";
                        objArr[1] = c24738g.jIm.jIs ? "true" : "false";
                        objArr[2] = c24738g.jIm.jIt ? "true" : "false";
                        objArr[3] = Byte.valueOf(c24738g.jIm.jIu);
                        objArr[4] = Byte.valueOf(c24738g.jIm.jIv);
                        C4990ab.m7411d(uuid, str, objArr);
                    }
                } else if (c24738g.jHc.equalsIgnoreCase(C24738g.jGS)) {
                    byte b = bArr[0];
                    if ((b & 2) != 0) {
                        i2 = 10;
                    } else {
                        i2 = 3;
                    }
                    if ((b & 4) != 0) {
                        i2++;
                    }
                    if ((b & 8) != 0) {
                        i2 += 4;
                    }
                    if (i2 > bArr.length) {
                        C4990ab.m7413e(C24738g.TAG, "data len is not enough for parse. current len = %d, needed len = %d", Integer.valueOf(bArr.length), Integer.valueOf(i2));
                        i2 = 0;
                    } else {
                        c24738g.jIn = new C11471b();
                        c24738g.jIn.jIo = (b & 1) != 0;
                        c24738g.jIn.f2902GO = (bArr[1] & 255) + ((bArr[2] & 255) << 8);
                        if ((b & 2) != 0) {
                            c24738g.jIn.jIp = new C2851a();
                            C2851a c2851a = c24738g.jIn.jIp;
                            String str2 = C24738g.TAG;
                            String str3 = "data size = %d, offset = %d, lenght = %d";
                            Object[] objArr2 = new Object[3];
                            objArr2[0] = Integer.valueOf(bArr == null ? 0 : bArr.length);
                            objArr2[1] = Integer.valueOf(3);
                            objArr2[2] = Integer.valueOf(7);
                            C4990ab.m7411d(str2, str3, objArr2);
                            if (bArr == null || bArr.length < 10) {
                                C4990ab.m7412e(C24738g.TAG, "data input error");
                            } else {
                                c2851a.enV = (bArr[3] & 255) + ((bArr[4] & 255) << 8);
                                c2851a.enR = bArr[5] & 255;
                                c2851a.jHz = bArr[6] & 255;
                                c2851a.jHA = bArr[7] & 255;
                                c2851a.jHB = bArr[8] & 255;
                                c2851a.jHC = bArr[9] & 255;
                                C4990ab.m7411d(C24738g.TAG, "year = %d, month = %d, day = %d, hours = %d, minutes = %d, seconds = %d", Integer.valueOf(c2851a.enV), Integer.valueOf(c2851a.enR), Integer.valueOf(c2851a.jHz), Integer.valueOf(c2851a.jHA), Integer.valueOf(c2851a.jHB), Integer.valueOf(c2851a.jHC));
                            }
                            i2 = 10;
                        } else {
                            i2 = 3;
                        }
                        if ((b & 4) != 0) {
                            c24738g.jIn.jHs = bArr[i2] & 255;
                            i2++;
                        }
                        if ((b & 8) != 0) {
                            c24738g.jIn.jIq = (bArr[i2] & 255) + ((bArr[i2 + 1] & 255) << 8);
                            i2 += 2;
                            c24738g.jIn.mHeight = ((bArr[i2 + 1] & 255) << 8) + (bArr[i2] & 255);
                        }
                        uuid = C24738g.TAG;
                        str = "WeightAndHeightUnit = %s, Weight = %d, TimeStamp = %s, UserId = %d, BMI = %d, Height = %d";
                        objArr = new Object[6];
                        objArr[0] = c24738g.jIn.jIo ? "lb&inch" : "kg&meter";
                        objArr[1] = Integer.valueOf(c24738g.jIn.f2902GO);
                        objArr[2] = c24738g.jIn.jIp == null ? BuildConfig.COMMAND : "object";
                        objArr[3] = Integer.valueOf(c24738g.jIn.jHs);
                        objArr[4] = Integer.valueOf(c24738g.jIn.jIq);
                        objArr[5] = Integer.valueOf(c24738g.jIn.mHeight);
                        C4990ab.m7411d(uuid, str, objArr);
                    }
                }
                i2 = 1;
            }
            if (i2 != 0) {
                bQ = C42992b.m76353bQ(c24738g);
                C4990ab.m7411d(TAG, "weight info. weight = %d", Integer.valueOf(c24738g.jIn.f2902GO));
            } else {
                C4990ab.m7412e(TAG, "parse weight scale data error");
                bQ = null;
            }
        } else if (0 != (4 & j) && (uuid.equalsIgnoreCase(C42902d.jHe) || uuid.equalsIgnoreCase(C42902d.jHE) || uuid.equalsIgnoreCase(C42902d.jHF))) {
            C42902d c42902d = new C42902d();
            if (uuid == null || uuid.length() <= 0 || bArr == null) {
                C4990ab.m7412e(C42902d.TAG, "characteristicUuid or data is null");
            } else {
                c42902d.jHc = uuid;
                i4 = bArr.length;
                if (c42902d.jHc.equalsIgnoreCase(C42902d.jHe)) {
                    if (bArr.length < 2) {
                        C4990ab.m7412e(C42902d.TAG, "Received data length is not right:".concat(String.valueOf(i4)));
                    } else {
                        c42902d.jHM = new C42901a();
                        byte b2 = bArr[0];
                        C4990ab.m7410d(C42902d.TAG, "flag=".concat(String.valueOf(b2)));
                        if ((b2 & 1) == 1 && i4 >= 3) {
                            C4990ab.m7410d(C42902d.TAG, "Value Format = uint16");
                            c42902d.jHM.jHN = (((bArr[2] << 8) & 65280) & 65280) + (bArr[1] & 255);
                            i2 = 3;
                        } else if (i4 >= 2) {
                            C4990ab.m7410d(C42902d.TAG, "Value Format = uint8");
                            c42902d.jHM.jHN = bArr[1] & 255;
                            i2 = 2;
                        } else {
                            C4990ab.m7410d(C42902d.TAG, "receive data error");
                        }
                        C4990ab.m7418v(C42902d.TAG, "Data received from HR " + c42902d.jHM.jHN);
                        if ((b2 & 6) == 4) {
                            C4990ab.m7410d(C42902d.TAG, "Sensor Contact feature is supported, but contact is not detected");
                            c42902d.jHM.jHO = 1;
                        } else if ((b2 & 6) == 6) {
                            C4990ab.m7410d(C42902d.TAG, "Sensor Contact feature is supported and contact is detected");
                            c42902d.jHM.jHO = 2;
                        } else {
                            C4990ab.m7410d(C42902d.TAG, "Sensor Contact feature is not supported in the current connection");
                            c42902d.jHM.jHO = 0;
                        }
                        if ((b2 & 8) == 8 && i4 >= i2 + 2) {
                            C4990ab.m7410d(C42902d.TAG, "Energy Expend Present");
                            i = (bArr[i2 + 1] << 8) & 65280;
                            c42902d.jHM.jHP = (bArr[i2] & 255) + (i & 65280);
                            C4990ab.m7418v("H7ConnectThread", "energyExp from HR energyExph " + i + " " + c42902d.jHM.jHP);
                            i2 += 2;
                        }
                        if ((b2 & 16) == 16 && i4 >= i2 + 2) {
                            C4990ab.m7410d(C42902d.TAG, "RR Interval Present");
                            i = (bArr[i2 + 1] & 255) << 8;
                            c42902d.jHM.jHQ = (bArr[i2] & 255) + (i & 65280);
                            C4990ab.m7418v(C42902d.TAG, "rrInterval from HR rrIntervalh" + i + " " + c42902d.jHM.jHQ);
                        }
                    }
                } else if (c42902d.jHc.equalsIgnoreCase(C42902d.jHE)) {
                    switch (bArr[0]) {
                        case (byte) 0:
                            c42902d.jHL = "Other";
                            break;
                        case (byte) 1:
                            c42902d.jHL = "Chest";
                            break;
                        case (byte) 2:
                            c42902d.jHL = "Wrist";
                            break;
                        case (byte) 3:
                            c42902d.jHL = "Finger";
                            break;
                        case (byte) 4:
                            c42902d.jHL = "Hand";
                            break;
                        case (byte) 5:
                            c42902d.jHL = "Ear Lobe";
                            break;
                        case (byte) 6:
                            c42902d.jHL = "Foot";
                            break;
                        default:
                            c42902d.jHL = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                            break;
                    }
                    C4990ab.m7410d(C42902d.TAG, "position=" + c42902d.jHL);
                }
                i = 1;
            }
            if (i != 0) {
                bQ = C42992b.m76353bQ(c42902d);
            } else {
                C4990ab.m7412e(TAG, "parse heart rate data error");
                bQ = null;
            }
        } else if (0 != (8 & j) && (uuid.equalsIgnoreCase(C45824b.jHe) || uuid.equalsIgnoreCase(C45824b.jHf) || uuid.equalsIgnoreCase(C45824b.jHg))) {
            C45824b c45824b = new C45824b();
            if (uuid == null || uuid.length() <= 0 || bArr == null) {
                C4990ab.m7412e(C45824b.TAG, "characteristicUuid or data is null");
            } else {
                c45824b.jHc = uuid;
                i2 = bArr.length;
                byte b3;
                if (c45824b.jHc.equalsIgnoreCase(C45824b.jHe)) {
                    if (i2 < 7) {
                        C4990ab.m7412e(C45824b.TAG, "data len is not right.");
                    } else {
                        c45824b.jHm = new C11470b();
                        b3 = bArr[0];
                        C4990ab.m7410d(C45824b.TAG, "flag=".concat(String.valueOf(b3)));
                        if ((b3 & 1) != 0) {
                            C4990ab.m7410d(C45824b.TAG, "the value unit is kPa.");
                            c45824b.jHm.jHp = true;
                        } else {
                            C4990ab.m7410d(C45824b.TAG, "the value unit is mmHg.");
                            c45824b.jHm.jHp = false;
                        }
                        c45824b.jHm.jHw = C45824b.m84812L(bArr, 1);
                        c45824b.jHm.jHx = C45824b.m84812L(bArr, 3);
                        c45824b.jHm.jHy = C45824b.m84812L(bArr, 5);
                        i3 = 7;
                        if ((b3 & 2) == 0 || i2 < 14) {
                            C4990ab.m7410d(C45824b.TAG, "TimeStamp not Present.");
                        } else {
                            C4990ab.m7410d(C45824b.TAG, "TimeStamp Present.");
                            c45824b.jHm.jHu.mo54436M(bArr, 7);
                            i3 = 14;
                        }
                        if ((b3 & 4) == 0 || i2 < i3 + 2) {
                            C4990ab.m7410d(C45824b.TAG, "PulseRate not Present.");
                        } else {
                            C4990ab.m7410d(C45824b.TAG, "PulseRate Present.");
                            c45824b.jHm.jHr = (int) C45824b.m84812L(bArr, i3);
                            i3 += 2;
                            C4990ab.m7410d(C45824b.TAG, "PulseRate =" + c45824b.jHm.jHr);
                        }
                        if ((b3 & 8) != 0) {
                            C4990ab.m7410d(C45824b.TAG, "UserId Present.");
                            i2 = i3 + 1;
                            c45824b.jHm.jHs = bArr[i3];
                            C4990ab.m7410d(C45824b.TAG, "UserId = " + c45824b.jHm.jHs);
                        } else {
                            C4990ab.m7410d(C45824b.TAG, "UserId not Present.");
                            i2 = i3;
                        }
                        if ((b3 & 16) != 0) {
                            C4990ab.m7410d(C45824b.TAG, "MeasurementStatus Present.");
                            c45824b.jHm.jHt = (bArr[i2] & 255) + (((bArr[i2 + 1] << 8) & 65280) & 65280);
                            C4990ab.m7410d(C45824b.TAG, "MeasurementStatus = " + c45824b.jHm.jHt);
                        } else {
                            C4990ab.m7410d(C45824b.TAG, "MeasurementStatus not Present.");
                        }
                    }
                } else if (c45824b.jHc.equalsIgnoreCase(C45824b.jHf)) {
                    if (i2 < 3) {
                        C4990ab.m7412e(C45824b.TAG, "data len is not right.");
                    } else {
                        c45824b.jHn = new C11469a();
                        b3 = bArr[0];
                        C4990ab.m7410d(C45824b.TAG, "flag=".concat(String.valueOf(b3)));
                        if ((b3 & 1) != 0) {
                            C4990ab.m7410d(C45824b.TAG, "the value unit is kPa.");
                            c45824b.jHn.jHp = true;
                        } else {
                            C4990ab.m7410d(C45824b.TAG, "the value unit is mmHg.");
                            c45824b.jHn.jHp = false;
                        }
                        c45824b.jHn.jHq = C45824b.m84812L(bArr, 1);
                        if ((b3 & 2) == 0 || i2 < 10) {
                            C4990ab.m7410d(C45824b.TAG, "TimeStamp not Present.");
                            i3 = 3;
                        } else {
                            C4990ab.m7410d(C45824b.TAG, "TimeStamp Present.");
                            c45824b.jHn.jHu.mo54436M(bArr, 3);
                            i3 = 10;
                        }
                        if ((b3 & 4) == 0 || i2 < i3 + 2) {
                            C4990ab.m7410d(C45824b.TAG, "PulseRate not Present.");
                        } else {
                            C4990ab.m7410d(C45824b.TAG, "PulseRate Present.");
                            c45824b.jHn.jHr = (int) C45824b.m84812L(bArr, i3);
                            i3 += 2;
                            C4990ab.m7410d(C45824b.TAG, "PulseRate =" + c45824b.jHn.jHr);
                        }
                        if ((b3 & 8) != 0) {
                            C4990ab.m7410d(C45824b.TAG, "UserId Present.");
                            i2 = i3 + 1;
                            c45824b.jHn.jHs = bArr[i3];
                            C4990ab.m7410d(C45824b.TAG, "UserId = " + c45824b.jHn.jHs);
                        } else {
                            C4990ab.m7410d(C45824b.TAG, "UserId not Present.");
                            i2 = i3;
                        }
                        if ((b3 & 16) != 0) {
                            C4990ab.m7410d(C45824b.TAG, "MeasurementStatus Present.");
                            c45824b.jHn.jHt = (bArr[i2] & 255) + (((bArr[i2 + 1] << 8) & 65280) & 65280);
                            C4990ab.m7410d(C45824b.TAG, "MeasurementStatus = " + c45824b.jHn.jHt);
                        } else {
                            C4990ab.m7410d(C45824b.TAG, "MeasurementStatus not Present.");
                        }
                    }
                } else if (c45824b.jHc.equalsIgnoreCase(C45824b.jHg)) {
                    C4990ab.m7410d(C45824b.TAG, "Blood Pressure Feature Characteristic.");
                    if (i2 < 2) {
                        C4990ab.m7412e(C45824b.TAG, "data len is not right.");
                    } else {
                        c45824b.jHo = (((bArr[1] << 8) & 65280) & 65280) + (bArr[0] & 255);
                        C4990ab.m7410d(C45824b.TAG, "bloodPressureFeatureParameters=" + c45824b.jHo);
                    }
                }
                i = 1;
            }
            if (i != 0) {
                bQ = C42992b.m76353bQ(c45824b);
            } else {
                C4990ab.m7412e(TAG, "parse blood pressure data error");
                bQ = null;
            }
        } else if (0 == (j & 16) || !(uuid.equalsIgnoreCase(C42903e.jHS) || uuid.equalsIgnoreCase(C42903e.jHT) || uuid.equalsIgnoreCase(C42903e.jHU) || uuid.equalsIgnoreCase(C42903e.jHV))) {
            C4990ab.m7413e(TAG, "unknown characteristic uuid = %s", uuid);
            bQ = null;
        } else {
            C42903e c42903e = new C42903e();
            if (uuid == null || uuid.length() <= 0 || bArr == null) {
                C4990ab.m7412e(C42903e.TAG, "characteristicUuid or data is null");
            } else {
                c42903e.jHc = uuid;
                if (c42903e.jHc.equalsIgnoreCase(C42903e.jHS)) {
                    if (bArr.length != 3) {
                        C4990ab.m7412e(C42903e.TAG, "Data length incorrect");
                    } else {
                        c42903e.jHW = bArr[0];
                        c42903e.jHX = bArr[1];
                        c42903e.jHY = bArr[2];
                    }
                } else if (c42903e.jHc.equalsIgnoreCase(C42903e.jHT)) {
                    if (bArr.length != 1) {
                        C4990ab.m7412e(C42903e.TAG, "Data length incorrect");
                    } else {
                        c42903e.jHZ = bArr[0];
                    }
                } else if (c42903e.jHc.equalsIgnoreCase(C42903e.jHU)) {
                    if (bArr.length < 2) {
                        C4990ab.m7412e(C42903e.TAG, "Data length incorrect");
                    } else {
                        c42903e.jIa[0] = bArr[0];
                        c42903e.jIa[1] = bArr[1];
                    }
                } else if (!c42903e.jHc.equalsIgnoreCase(C42903e.jHV)) {
                    C4990ab.m7412e(C42903e.TAG, "characteristicUuid is incorrect");
                } else if (bArr.length < 4) {
                    C4990ab.m7412e(C42903e.TAG, "Data length incorrect");
                } else {
                    c42903e.jIb = (bArr[0] & 255) + ((bArr[1] & 255) << 8);
                    c42903e.jId = bArr[2];
                    c42903e.jIc = bArr[3];
                    if (bArr.length > 4) {
                        c42903e.jIe = new byte[(bArr.length - 4)];
                        System.arraycopy(bArr, 4, c42903e.jIe, 0, bArr.length - 4);
                    } else {
                        c42903e.jIe = null;
                    }
                }
                i = 1;
            }
            if (i != 0) {
                bQ = C42992b.m76353bQ(c42903e);
            } else {
                C4990ab.m7412e(TAG, "parse light data error");
                bQ = null;
            }
        }
        AppMethodBeat.m2505o(18466);
        return bQ;
    }
}
