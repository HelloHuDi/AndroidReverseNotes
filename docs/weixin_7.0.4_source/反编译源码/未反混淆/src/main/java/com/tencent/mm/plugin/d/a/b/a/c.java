package com.tencent.mm.plugin.d.a.b.a;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.d.a.b.a.g.a;
import com.tencent.mm.plugin.d.a.b.h;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@TargetApi(18)
public class c {
    public static final String TAG = c.class.getName();
    private static HashMap<String, Long> jGv = new HashMap();
    private static HashMap<String, Long> jHD;

    static {
        AppMethodBeat.i(18467);
        HashMap hashMap = new HashMap();
        jHD = hashMap;
        hashMap.put(h.jGK, Long.valueOf(1));
        jHD.put(h.jGL, Long.valueOf(1));
        jHD.put(h.jGM, Long.valueOf(16));
        jHD.put(h.jGN, Long.valueOf(16));
        jHD.put(h.jGO, Long.valueOf(16));
        jHD.put(h.jGP, Long.valueOf(16));
        jGv.put(h.jGH, Long.valueOf(0));
        jGv.put(h.jGQ, Long.valueOf(2));
        jGv.put(h.jGT, Long.valueOf(4));
        jGv.put(h.jGX, Long.valueOf(8));
        AppMethodBeat.o(18467);
    }

    /* JADX WARNING: Missing block: B:19:0x00aa, code skipped:
            r2 = r2 + r4;
     */
    /* JADX WARNING: Missing block: B:46:0x001d, code skipped:
            continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean au(byte[] bArr) {
        AppMethodBeat.i(18462);
        if (bo.cb(bArr)) {
            ab.e(TAG, "parseBroadcastServiceUuid error. broadcast data is null or nil");
            AppMethodBeat.o(18462);
            return false;
        }
        int i = 0;
        while (i >= 0 && i < bArr.length) {
            int i2 = i + 1;
            byte b = bArr[i];
            if (i2 + b > bArr.length) {
                ab.w(TAG, "broadcast data len is not enough. offset = %d, current len = %d, broadcast len = %d", Integer.valueOf(i2), Integer.valueOf(b), Integer.valueOf(bArr.length));
                AppMethodBeat.o(18462);
                return false;
            } else if (b <= (byte) 0) {
                ab.w(TAG, "current part of data's len = %d.", Integer.valueOf(b));
                AppMethodBeat.o(18462);
                return false;
            } else {
                int i3 = i2 + 1;
                i = b - 1;
                switch (bArr[i2]) {
                    case (byte) -1:
                        ab.i(TAG, "Manufacturer Specific Data size = %s", Integer.valueOf(i));
                        ab.i(TAG, "Manufacturer Specific Data = %s", b.aN(Arrays.copyOfRange(bArr, i3, i3 + i)));
                        break;
                    case (byte) 2:
                    case (byte) 3:
                        while (2 <= i) {
                            i2 = i3 + 1;
                            int i4 = bArr[i3] & 255;
                            i3 = i2 + 1;
                            i2 = ((bArr[i2] & 255) << 8) | i4;
                            i -= 2;
                            ab.d(TAG, "find 16-bit broacast service = %s", String.format("%08x-0000-1000-8000-00805f9b34fb", new Object[]{Integer.valueOf(i2)}));
                            if (jGv.containsKey(String.format("%08x-0000-1000-8000-00805f9b34fb", new Object[]{Integer.valueOf(i2)}))) {
                                AppMethodBeat.o(18462);
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
                                ab.d(TAG, "find 128-bit broacast service = %s", new UUID(order.getLong(), order.getLong()).toString());
                                if (jGv.containsKey(new UUID(order.getLong(), order.getLong()).toString())) {
                                    AppMethodBeat.o(18462);
                                    return true;
                                }
                                i3 += 16;
                                i2 -= 16;
                            } catch (IndexOutOfBoundsException e) {
                                ab.e("BlueToothDeviceFilter.parseUUID", e.toString());
                                i3 += 16;
                                i2 -= 16;
                            } catch (Throwable th) {
                                AppMethodBeat.o(18462);
                            }
                        }
                        i = i3 + i2;
                        continue;
                }
                i += i3;
            }
        }
        AppMethodBeat.o(18462);
        return false;
    }

    public static String gA(long j) {
        String str;
        AppMethodBeat.i(18463);
        for (String str2 : jGv.keySet()) {
            if (((Long) jGv.get(str2)).longValue() == j) {
                AppMethodBeat.o(18463);
                return str2;
            }
        }
        if (jHD.containsValue(Long.valueOf(j))) {
            str2 = h.jGH;
            AppMethodBeat.o(18463);
            return str2;
        }
        AppMethodBeat.o(18463);
        return null;
    }

    public static long a(BluetoothGattService bluetoothGattService) {
        long j = 0;
        AppMethodBeat.i(18464);
        if (bluetoothGattService == null) {
            ab.e(TAG, "service is null");
            AppMethodBeat.o(18464);
            return 0;
        }
        String uuid = bluetoothGattService.getUuid().toString();
        Long l;
        if (!uuid.equalsIgnoreCase(h.jGH) || bluetoothGattService.getCharacteristic(UUID.fromString(h.jGK)) == null) {
            l = (Long) jGv.get(uuid);
            if (l != null) {
                j = l.longValue();
            }
            ab.d(TAG, "service uuid = %s, profileType = %d", uuid, Long.valueOf(j));
            AppMethodBeat.o(18464);
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
        ab.d(TAG, "wechat service, profileType = %d", Long.valueOf(j2));
        AppMethodBeat.o(18464);
        return j2;
    }

    public static boolean b(BluetoothGattService bluetoothGattService) {
        AppMethodBeat.i(18465);
        if (bluetoothGattService == null) {
            ab.e(TAG, "service is null");
            AppMethodBeat.o(18465);
            return false;
        }
        long a = a(bluetoothGattService);
        BluetoothGattCharacteristic characteristic;
        int properties;
        if (0 != (1 & a)) {
            if (bluetoothGattService == null) {
                ab.e(TAG, "service is null");
                AppMethodBeat.o(18465);
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.jGK));
            if (characteristic == null) {
                ab.e(TAG, "no step measurement characteristic found");
                AppMethodBeat.o(18465);
                return false;
            }
            properties = characteristic.getProperties();
            ab.d(TAG, "step measurement characteristic properties = %d", Integer.valueOf(properties));
            if ((properties & 48) == 0 || (properties & 2) == 0) {
                ab.e(TAG, "step measurement characteristic has incorrect proterties(%d)", Integer.valueOf(properties));
                AppMethodBeat.o(18465);
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.jGL));
            if (characteristic != null) {
                properties = characteristic.getProperties();
                if ((properties & 2) == 0 || (properties & 32) == 0) {
                    ab.e(TAG, "step target characteristic has incorrect proterties(%d)", Integer.valueOf(properties));
                    AppMethodBeat.o(18465);
                    return false;
                }
            }
            AppMethodBeat.o(18465);
            return true;
        } else if (0 != (2 & a)) {
            if (bluetoothGattService == null) {
                ab.e(TAG, "service is null");
                AppMethodBeat.o(18465);
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.jGR));
            if (characteristic == null) {
                ab.e(TAG, "weight scale feature characteristic not found");
                AppMethodBeat.o(18465);
                return false;
            }
            if ((characteristic.getProperties() & 2) == 0) {
                ab.e(TAG, "weight scale feature characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(characteristic.getProperties()), Integer.valueOf(2));
                AppMethodBeat.o(18465);
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.jGS));
            if (characteristic == null) {
                ab.e(TAG, "weight measurement characteristic not found");
                AppMethodBeat.o(18465);
                return false;
            }
            if ((characteristic.getProperties() & 32) == 0) {
                ab.e(TAG, "weight measurement characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(characteristic.getProperties()), Integer.valueOf(32));
                AppMethodBeat.o(18465);
                return false;
            }
            AppMethodBeat.o(18465);
            return true;
        } else if (0 != (4 & a)) {
            if (bluetoothGattService == null) {
                ab.e(TAG, "service is null");
                AppMethodBeat.o(18465);
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.jGU));
            if (characteristic == null) {
                ab.e(TAG, "heart rate measurement characteristic not found");
                AppMethodBeat.o(18465);
                return false;
            }
            if ((characteristic.getProperties() & 16) == 0) {
                ab.e(TAG, "heart rate measurement characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(characteristic.getProperties()), Integer.valueOf(16));
                AppMethodBeat.o(18465);
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.jGV));
            if (characteristic != null) {
                if ((characteristic.getProperties() & 2) == 0) {
                    ab.e(TAG, "heart rate body sensor location characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(characteristic.getProperties()), Integer.valueOf(2));
                    AppMethodBeat.o(18465);
                    return false;
                }
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.jGW));
            if (characteristic != null) {
                if ((characteristic.getProperties() & 8) == 0) {
                    ab.e(TAG, "heart rate control point characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(characteristic.getProperties()), Integer.valueOf(8));
                    AppMethodBeat.o(18465);
                    return false;
                }
            }
            AppMethodBeat.o(18465);
            return true;
        } else if (0 != (8 & a)) {
            if (bluetoothGattService == null) {
                ab.e(TAG, "service is null");
                AppMethodBeat.o(18465);
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.jGY));
            if (characteristic == null) {
                ab.e(TAG, "blood pressure measurement characteristic not found");
                AppMethodBeat.o(18465);
                return false;
            }
            if ((characteristic.getProperties() & 32) == 0) {
                ab.e(TAG, "blood pressure measurement characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(characteristic.getProperties()), Integer.valueOf(32));
                AppMethodBeat.o(18465);
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.jHa));
            if (characteristic == null) {
                ab.e(TAG, "blood pressure feature characteristic not found");
                AppMethodBeat.o(18465);
                return false;
            }
            if ((characteristic.getProperties() & 2) == 0) {
                ab.e(TAG, "blood pressure feature characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(characteristic.getProperties()), Integer.valueOf(2));
                AppMethodBeat.o(18465);
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.jGZ));
            if (characteristic != null) {
                if ((characteristic.getProperties() & 16) == 0) {
                    ab.e(TAG, "blood pressure intermediate cuff pressure characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(characteristic.getProperties()), Integer.valueOf(16));
                    AppMethodBeat.o(18465);
                    return false;
                }
            }
            AppMethodBeat.o(18465);
            return true;
        } else if (0 == (a & 16)) {
            AppMethodBeat.o(18465);
            return false;
        } else if (bluetoothGattService == null) {
            ab.e(TAG, "service is null");
            AppMethodBeat.o(18465);
            return false;
        } else {
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.jGM));
            if (characteristic == null) {
                ab.e(TAG, "light color characteristic not found");
                AppMethodBeat.o(18465);
                return false;
            }
            properties = characteristic.getProperties();
            if ((properties & 32) == 0 || (properties & 16) == 0 || (properties & 2) == 0 || (properties & 8) == 0) {
                ab.e(TAG, "light color characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(properties), Integer.valueOf(32));
                AppMethodBeat.o(18465);
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.jGN));
            if (characteristic == null) {
                ab.e(TAG, "light work state characteristic not found");
                AppMethodBeat.o(18465);
                return false;
            }
            properties = characteristic.getProperties();
            if ((properties & 32) == 0 || (properties & 2) == 0 || (properties & 8) == 0) {
                ab.e(TAG, "light work state characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(properties), Integer.valueOf(32));
                AppMethodBeat.o(18465);
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.jGO));
            if (characteristic == null) {
                ab.e(TAG, "light state changed characteristic not found");
                AppMethodBeat.o(18465);
                return false;
            }
            if ((characteristic.getProperties() & 32) == 0) {
                ab.e(TAG, "light state changed characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(characteristic.getProperties()), Integer.valueOf(32));
                AppMethodBeat.o(18465);
                return false;
            }
            characteristic = bluetoothGattService.getCharacteristic(UUID.fromString(h.jGP));
            if (characteristic == null) {
                ab.e(TAG, "control point characteristic not found");
                AppMethodBeat.o(18465);
                return false;
            }
            properties = characteristic.getProperties();
            if ((properties & 32) == 0 || (properties & 8) == 0) {
                ab.e(TAG, "control point characteristic has incorrect properties(%d). properties(%d) needed", Integer.valueOf(properties), Integer.valueOf(32));
                AppMethodBeat.o(18465);
                return false;
            }
            AppMethodBeat.o(18465);
            return true;
        }
    }

    public static byte[] a(BluetoothGattCharacteristic bluetoothGattCharacteristic, byte[] bArr) {
        int i = 0;
        AppMethodBeat.i(18466);
        if (bluetoothGattCharacteristic == null || bArr == null) {
            ab.e(TAG, "characteristic or recvData is null");
            AppMethodBeat.o(18466);
            return null;
        }
        byte[] bQ;
        long j = 0;
        String uuid = bluetoothGattCharacteristic.getUuid().toString();
        BluetoothGattService service = bluetoothGattCharacteristic.getService();
        if (service != null) {
            j = a(service);
        } else {
            ab.e(TAG, "the characteristic has no parent service");
        }
        ab.d(TAG, "recv data. uuid = %s, data = %s", uuid, b.aN(bArr));
        int i2;
        int i3;
        int i4;
        if (0 != (1 & j) && (uuid.equalsIgnoreCase(f.jIf) || uuid.equalsIgnoreCase(f.jIg))) {
            f fVar = new f();
            if (bArr.length <= 0 || (bArr[0] & 1) == 0) {
                ab.e(f.TAG, "pase step data error");
                i2 = 0;
            } else if (uuid == null || !(uuid.equals(f.jIf) || uuid.equals(f.jIg))) {
                ab.e(f.TAG, "uuid is not correct");
                i2 = 0;
            } else {
                fVar.jHc = uuid;
                i2 = 4;
                if ((bArr[0] & 2) != 0) {
                    i2 = 7;
                }
                if ((bArr[0] & 4) != 0) {
                    i2 += 3;
                }
                if (i2 > bArr.length) {
                    ab.e(f.TAG, "data len is not enough");
                    i2 = 0;
                } else {
                    fVar.jIh = 0;
                    i2 = 1;
                    for (i3 = 0; i3 < 3; i3++) {
                        fVar.jIh += (bArr[i2] & 255) << (i3 * 8);
                        i2++;
                    }
                    if ((bArr[0] & 2) != 0) {
                        fVar.jIi = 0;
                        for (i3 = 0; i3 < 3; i3++) {
                            fVar.jIi += (bArr[i2] & 255) << (i3 * 8);
                            i2++;
                        }
                    }
                    if ((bArr[0] & 4) != 0) {
                        fVar.jIj = 0;
                        i4 = i2;
                        for (i3 = 0; i3 < 3; i3++) {
                            fVar.jIj += (bArr[i4] & 255) << (i3 * 8);
                            i4++;
                        }
                    }
                    i2 = 1;
                }
            }
            if (i2 != 0) {
                bQ = b.bQ(fVar);
                ab.d(TAG, "step info. stepCount=%d, stepDistance=%d, stepColarie=%d", Integer.valueOf(fVar.jIh), Integer.valueOf(fVar.jIi), Integer.valueOf(fVar.jIj));
            } else {
                ab.e(TAG, "parse step data error");
                bQ = null;
            }
        } else if (0 != (2 & j) && (uuid.equalsIgnoreCase(g.jGS) || uuid.equalsIgnoreCase(g.jGR))) {
            g gVar = new g();
            if (uuid == null || uuid.length() <= 0 || bArr == null || bArr.length <= 0) {
                ab.e(g.TAG, "characteristicUuid or data is null or nil");
                i2 = 0;
            } else {
                gVar.jHc = uuid;
                String str;
                Object[] objArr;
                if (gVar.jHc.equalsIgnoreCase(g.jGR)) {
                    if (4 > bArr.length) {
                        ab.e(g.TAG, "weight scale feature characteristic data is a 32bit value, but current value len is %d", Integer.valueOf(bArr.length));
                        i2 = 0;
                    } else {
                        boolean z;
                        gVar.jIm = new com.tencent.mm.plugin.d.a.b.a.g.c();
                        gVar.jIm.jIr = (bArr[0] & 1) != 0;
                        com.tencent.mm.plugin.d.a.b.a.g.c cVar = gVar.jIm;
                        if ((bArr[0] & 2) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        cVar.jIs = z;
                        cVar = gVar.jIm;
                        if ((bArr[0] & 4) != 0) {
                            z = true;
                        } else {
                            z = false;
                        }
                        cVar.jIt = z;
                        gVar.jIm.jIu = (byte) ((bArr[0] & 120) >> 3);
                        gVar.jIm.jIv = (byte) (((bArr[0] & 128) >> 7) + ((bArr[1] & 3) << 1));
                        uuid = g.TAG;
                        str = "timestampSupported = %s, multipleUsersSupported = %s, BMISupported = %s, weightResolution = %d, heightResolution = %d";
                        objArr = new Object[5];
                        objArr[0] = gVar.jIm.jIr ? "true" : "false";
                        objArr[1] = gVar.jIm.jIs ? "true" : "false";
                        objArr[2] = gVar.jIm.jIt ? "true" : "false";
                        objArr[3] = Byte.valueOf(gVar.jIm.jIu);
                        objArr[4] = Byte.valueOf(gVar.jIm.jIv);
                        ab.d(uuid, str, objArr);
                    }
                } else if (gVar.jHc.equalsIgnoreCase(g.jGS)) {
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
                        ab.e(g.TAG, "data len is not enough for parse. current len = %d, needed len = %d", Integer.valueOf(bArr.length), Integer.valueOf(i2));
                        i2 = 0;
                    } else {
                        gVar.jIn = new g.b();
                        gVar.jIn.jIo = (b & 1) != 0;
                        gVar.jIn.GO = (bArr[1] & 255) + ((bArr[2] & 255) << 8);
                        if ((b & 2) != 0) {
                            gVar.jIn.jIp = new a();
                            a aVar = gVar.jIn.jIp;
                            String str2 = g.TAG;
                            String str3 = "data size = %d, offset = %d, lenght = %d";
                            Object[] objArr2 = new Object[3];
                            objArr2[0] = Integer.valueOf(bArr == null ? 0 : bArr.length);
                            objArr2[1] = Integer.valueOf(3);
                            objArr2[2] = Integer.valueOf(7);
                            ab.d(str2, str3, objArr2);
                            if (bArr == null || bArr.length < 10) {
                                ab.e(g.TAG, "data input error");
                            } else {
                                aVar.enV = (bArr[3] & 255) + ((bArr[4] & 255) << 8);
                                aVar.enR = bArr[5] & 255;
                                aVar.jHz = bArr[6] & 255;
                                aVar.jHA = bArr[7] & 255;
                                aVar.jHB = bArr[8] & 255;
                                aVar.jHC = bArr[9] & 255;
                                ab.d(g.TAG, "year = %d, month = %d, day = %d, hours = %d, minutes = %d, seconds = %d", Integer.valueOf(aVar.enV), Integer.valueOf(aVar.enR), Integer.valueOf(aVar.jHz), Integer.valueOf(aVar.jHA), Integer.valueOf(aVar.jHB), Integer.valueOf(aVar.jHC));
                            }
                            i2 = 10;
                        } else {
                            i2 = 3;
                        }
                        if ((b & 4) != 0) {
                            gVar.jIn.jHs = bArr[i2] & 255;
                            i2++;
                        }
                        if ((b & 8) != 0) {
                            gVar.jIn.jIq = (bArr[i2] & 255) + ((bArr[i2 + 1] & 255) << 8);
                            i2 += 2;
                            gVar.jIn.mHeight = ((bArr[i2 + 1] & 255) << 8) + (bArr[i2] & 255);
                        }
                        uuid = g.TAG;
                        str = "WeightAndHeightUnit = %s, Weight = %d, TimeStamp = %s, UserId = %d, BMI = %d, Height = %d";
                        objArr = new Object[6];
                        objArr[0] = gVar.jIn.jIo ? "lb&inch" : "kg&meter";
                        objArr[1] = Integer.valueOf(gVar.jIn.GO);
                        objArr[2] = gVar.jIn.jIp == null ? BuildConfig.COMMAND : "object";
                        objArr[3] = Integer.valueOf(gVar.jIn.jHs);
                        objArr[4] = Integer.valueOf(gVar.jIn.jIq);
                        objArr[5] = Integer.valueOf(gVar.jIn.mHeight);
                        ab.d(uuid, str, objArr);
                    }
                }
                i2 = 1;
            }
            if (i2 != 0) {
                bQ = b.bQ(gVar);
                ab.d(TAG, "weight info. weight = %d", Integer.valueOf(gVar.jIn.GO));
            } else {
                ab.e(TAG, "parse weight scale data error");
                bQ = null;
            }
        } else if (0 != (4 & j) && (uuid.equalsIgnoreCase(d.jHe) || uuid.equalsIgnoreCase(d.jHE) || uuid.equalsIgnoreCase(d.jHF))) {
            d dVar = new d();
            if (uuid == null || uuid.length() <= 0 || bArr == null) {
                ab.e(d.TAG, "characteristicUuid or data is null");
            } else {
                dVar.jHc = uuid;
                i4 = bArr.length;
                if (dVar.jHc.equalsIgnoreCase(d.jHe)) {
                    if (bArr.length < 2) {
                        ab.e(d.TAG, "Received data length is not right:".concat(String.valueOf(i4)));
                    } else {
                        dVar.jHM = new a();
                        byte b2 = bArr[0];
                        ab.d(d.TAG, "flag=".concat(String.valueOf(b2)));
                        if ((b2 & 1) == 1 && i4 >= 3) {
                            ab.d(d.TAG, "Value Format = uint16");
                            dVar.jHM.jHN = (((bArr[2] << 8) & 65280) & 65280) + (bArr[1] & 255);
                            i2 = 3;
                        } else if (i4 >= 2) {
                            ab.d(d.TAG, "Value Format = uint8");
                            dVar.jHM.jHN = bArr[1] & 255;
                            i2 = 2;
                        } else {
                            ab.d(d.TAG, "receive data error");
                        }
                        ab.v(d.TAG, "Data received from HR " + dVar.jHM.jHN);
                        if ((b2 & 6) == 4) {
                            ab.d(d.TAG, "Sensor Contact feature is supported, but contact is not detected");
                            dVar.jHM.jHO = 1;
                        } else if ((b2 & 6) == 6) {
                            ab.d(d.TAG, "Sensor Contact feature is supported and contact is detected");
                            dVar.jHM.jHO = 2;
                        } else {
                            ab.d(d.TAG, "Sensor Contact feature is not supported in the current connection");
                            dVar.jHM.jHO = 0;
                        }
                        if ((b2 & 8) == 8 && i4 >= i2 + 2) {
                            ab.d(d.TAG, "Energy Expend Present");
                            i = (bArr[i2 + 1] << 8) & 65280;
                            dVar.jHM.jHP = (bArr[i2] & 255) + (i & 65280);
                            ab.v("H7ConnectThread", "energyExp from HR energyExph " + i + " " + dVar.jHM.jHP);
                            i2 += 2;
                        }
                        if ((b2 & 16) == 16 && i4 >= i2 + 2) {
                            ab.d(d.TAG, "RR Interval Present");
                            i = (bArr[i2 + 1] & 255) << 8;
                            dVar.jHM.jHQ = (bArr[i2] & 255) + (i & 65280);
                            ab.v(d.TAG, "rrInterval from HR rrIntervalh" + i + " " + dVar.jHM.jHQ);
                        }
                    }
                } else if (dVar.jHc.equalsIgnoreCase(d.jHE)) {
                    switch (bArr[0]) {
                        case (byte) 0:
                            dVar.jHL = "Other";
                            break;
                        case (byte) 1:
                            dVar.jHL = "Chest";
                            break;
                        case (byte) 2:
                            dVar.jHL = "Wrist";
                            break;
                        case (byte) 3:
                            dVar.jHL = "Finger";
                            break;
                        case (byte) 4:
                            dVar.jHL = "Hand";
                            break;
                        case (byte) 5:
                            dVar.jHL = "Ear Lobe";
                            break;
                        case (byte) 6:
                            dVar.jHL = "Foot";
                            break;
                        default:
                            dVar.jHL = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                            break;
                    }
                    ab.d(d.TAG, "position=" + dVar.jHL);
                }
                i = 1;
            }
            if (i != 0) {
                bQ = b.bQ(dVar);
            } else {
                ab.e(TAG, "parse heart rate data error");
                bQ = null;
            }
        } else if (0 != (8 & j) && (uuid.equalsIgnoreCase(b.jHe) || uuid.equalsIgnoreCase(b.jHf) || uuid.equalsIgnoreCase(b.jHg))) {
            b bVar = new b();
            if (uuid == null || uuid.length() <= 0 || bArr == null) {
                ab.e(b.TAG, "characteristicUuid or data is null");
            } else {
                bVar.jHc = uuid;
                i2 = bArr.length;
                byte b3;
                if (bVar.jHc.equalsIgnoreCase(b.jHe)) {
                    if (i2 < 7) {
                        ab.e(b.TAG, "data len is not right.");
                    } else {
                        bVar.jHm = new b();
                        b3 = bArr[0];
                        ab.d(b.TAG, "flag=".concat(String.valueOf(b3)));
                        if ((b3 & 1) != 0) {
                            ab.d(b.TAG, "the value unit is kPa.");
                            bVar.jHm.jHp = true;
                        } else {
                            ab.d(b.TAG, "the value unit is mmHg.");
                            bVar.jHm.jHp = false;
                        }
                        bVar.jHm.jHw = b.L(bArr, 1);
                        bVar.jHm.jHx = b.L(bArr, 3);
                        bVar.jHm.jHy = b.L(bArr, 5);
                        i3 = 7;
                        if ((b3 & 2) == 0 || i2 < 14) {
                            ab.d(b.TAG, "TimeStamp not Present.");
                        } else {
                            ab.d(b.TAG, "TimeStamp Present.");
                            bVar.jHm.jHu.M(bArr, 7);
                            i3 = 14;
                        }
                        if ((b3 & 4) == 0 || i2 < i3 + 2) {
                            ab.d(b.TAG, "PulseRate not Present.");
                        } else {
                            ab.d(b.TAG, "PulseRate Present.");
                            bVar.jHm.jHr = (int) b.L(bArr, i3);
                            i3 += 2;
                            ab.d(b.TAG, "PulseRate =" + bVar.jHm.jHr);
                        }
                        if ((b3 & 8) != 0) {
                            ab.d(b.TAG, "UserId Present.");
                            i2 = i3 + 1;
                            bVar.jHm.jHs = bArr[i3];
                            ab.d(b.TAG, "UserId = " + bVar.jHm.jHs);
                        } else {
                            ab.d(b.TAG, "UserId not Present.");
                            i2 = i3;
                        }
                        if ((b3 & 16) != 0) {
                            ab.d(b.TAG, "MeasurementStatus Present.");
                            bVar.jHm.jHt = (bArr[i2] & 255) + (((bArr[i2 + 1] << 8) & 65280) & 65280);
                            ab.d(b.TAG, "MeasurementStatus = " + bVar.jHm.jHt);
                        } else {
                            ab.d(b.TAG, "MeasurementStatus not Present.");
                        }
                    }
                } else if (bVar.jHc.equalsIgnoreCase(b.jHf)) {
                    if (i2 < 3) {
                        ab.e(b.TAG, "data len is not right.");
                    } else {
                        bVar.jHn = new a();
                        b3 = bArr[0];
                        ab.d(b.TAG, "flag=".concat(String.valueOf(b3)));
                        if ((b3 & 1) != 0) {
                            ab.d(b.TAG, "the value unit is kPa.");
                            bVar.jHn.jHp = true;
                        } else {
                            ab.d(b.TAG, "the value unit is mmHg.");
                            bVar.jHn.jHp = false;
                        }
                        bVar.jHn.jHq = b.L(bArr, 1);
                        if ((b3 & 2) == 0 || i2 < 10) {
                            ab.d(b.TAG, "TimeStamp not Present.");
                            i3 = 3;
                        } else {
                            ab.d(b.TAG, "TimeStamp Present.");
                            bVar.jHn.jHu.M(bArr, 3);
                            i3 = 10;
                        }
                        if ((b3 & 4) == 0 || i2 < i3 + 2) {
                            ab.d(b.TAG, "PulseRate not Present.");
                        } else {
                            ab.d(b.TAG, "PulseRate Present.");
                            bVar.jHn.jHr = (int) b.L(bArr, i3);
                            i3 += 2;
                            ab.d(b.TAG, "PulseRate =" + bVar.jHn.jHr);
                        }
                        if ((b3 & 8) != 0) {
                            ab.d(b.TAG, "UserId Present.");
                            i2 = i3 + 1;
                            bVar.jHn.jHs = bArr[i3];
                            ab.d(b.TAG, "UserId = " + bVar.jHn.jHs);
                        } else {
                            ab.d(b.TAG, "UserId not Present.");
                            i2 = i3;
                        }
                        if ((b3 & 16) != 0) {
                            ab.d(b.TAG, "MeasurementStatus Present.");
                            bVar.jHn.jHt = (bArr[i2] & 255) + (((bArr[i2 + 1] << 8) & 65280) & 65280);
                            ab.d(b.TAG, "MeasurementStatus = " + bVar.jHn.jHt);
                        } else {
                            ab.d(b.TAG, "MeasurementStatus not Present.");
                        }
                    }
                } else if (bVar.jHc.equalsIgnoreCase(b.jHg)) {
                    ab.d(b.TAG, "Blood Pressure Feature Characteristic.");
                    if (i2 < 2) {
                        ab.e(b.TAG, "data len is not right.");
                    } else {
                        bVar.jHo = (((bArr[1] << 8) & 65280) & 65280) + (bArr[0] & 255);
                        ab.d(b.TAG, "bloodPressureFeatureParameters=" + bVar.jHo);
                    }
                }
                i = 1;
            }
            if (i != 0) {
                bQ = b.bQ(bVar);
            } else {
                ab.e(TAG, "parse blood pressure data error");
                bQ = null;
            }
        } else if (0 == (j & 16) || !(uuid.equalsIgnoreCase(e.jHS) || uuid.equalsIgnoreCase(e.jHT) || uuid.equalsIgnoreCase(e.jHU) || uuid.equalsIgnoreCase(e.jHV))) {
            ab.e(TAG, "unknown characteristic uuid = %s", uuid);
            bQ = null;
        } else {
            e eVar = new e();
            if (uuid == null || uuid.length() <= 0 || bArr == null) {
                ab.e(e.TAG, "characteristicUuid or data is null");
            } else {
                eVar.jHc = uuid;
                if (eVar.jHc.equalsIgnoreCase(e.jHS)) {
                    if (bArr.length != 3) {
                        ab.e(e.TAG, "Data length incorrect");
                    } else {
                        eVar.jHW = bArr[0];
                        eVar.jHX = bArr[1];
                        eVar.jHY = bArr[2];
                    }
                } else if (eVar.jHc.equalsIgnoreCase(e.jHT)) {
                    if (bArr.length != 1) {
                        ab.e(e.TAG, "Data length incorrect");
                    } else {
                        eVar.jHZ = bArr[0];
                    }
                } else if (eVar.jHc.equalsIgnoreCase(e.jHU)) {
                    if (bArr.length < 2) {
                        ab.e(e.TAG, "Data length incorrect");
                    } else {
                        eVar.jIa[0] = bArr[0];
                        eVar.jIa[1] = bArr[1];
                    }
                } else if (!eVar.jHc.equalsIgnoreCase(e.jHV)) {
                    ab.e(e.TAG, "characteristicUuid is incorrect");
                } else if (bArr.length < 4) {
                    ab.e(e.TAG, "Data length incorrect");
                } else {
                    eVar.jIb = (bArr[0] & 255) + ((bArr[1] & 255) << 8);
                    eVar.jId = bArr[2];
                    eVar.jIc = bArr[3];
                    if (bArr.length > 4) {
                        eVar.jIe = new byte[(bArr.length - 4)];
                        System.arraycopy(bArr, 4, eVar.jIe, 0, bArr.length - 4);
                    } else {
                        eVar.jIe = null;
                    }
                }
                i = 1;
            }
            if (i != 0) {
                bQ = b.bQ(eVar);
            } else {
                ab.e(TAG, "parse light data error");
                bQ = null;
            }
        }
        AppMethodBeat.o(18466);
        return bQ;
    }
}
