package com.tencent.mm.plugin.exdevice.j;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.nio.ByteBuffer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public final class b {
    public static long KK(String str) {
        int i = 0;
        AppMethodBeat.i(20243);
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.exdevice.Util", "mac string is null or nil");
            AppMethodBeat.o(20243);
            return 0;
        }
        String[] split = str.toUpperCase(Locale.US).split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        Byte[] bArr = new Byte[split.length];
        int length = split.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            String str2 = split[i2];
            bArr[i3] = Byte.valueOf((byte) ((((byte) str2.charAt(0)) >= (byte) 65 ? ((str2.charAt(0) - 65) + 10) << 4 : (str2.charAt(0) - 48) << 4) | (((byte) str2.charAt(1)) >= (byte) 65 ? (str2.charAt(1) - 65) + 10 : str2.charAt(1) - 48)));
            i2++;
            i3++;
        }
        i2 = split.length - 1;
        long j = 0;
        while (i < bArr.length) {
            j |= (bArr[i].longValue() & 255) << (i2 << 3);
            i++;
            i2--;
        }
        AppMethodBeat.o(20243);
        return j;
    }

    public static String ie(long j) {
        int i = 0;
        AppMethodBeat.i(20244);
        byte[] bArr = new byte[6];
        for (int i2 = 0; i2 < 6; i2++) {
            bArr[i2] = (byte) ((int) (j >> (40 - (i2 << 3))));
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (i < 6) {
            if (i != 0) {
                stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            }
            int i3 = bArr[i] & 255;
            if (i3 < 16) {
                stringBuilder.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            stringBuilder.append(Integer.toHexString(i3));
            i++;
        }
        String toUpperCase = stringBuilder.toString().toUpperCase(Locale.US);
        AppMethodBeat.o(20244);
        return toUpperCase;
    }

    public static String aN(byte[] bArr) {
        AppMethodBeat.i(20245);
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.o(20245);
            return null;
        }
        String S = S(bArr, bArr.length);
        AppMethodBeat.o(20245);
        return S;
    }

    public static String S(byte[] bArr, int i) {
        AppMethodBeat.i(20246);
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.o(20246);
            return null;
        }
        if (bArr.length < i) {
            ab.w("MicroMsg.exdevice.Util", "data length is shorter then print command length");
            i = bArr.length;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = bArr[i2] & 255;
            if (i3 < 16) {
                stringBuilder.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            stringBuilder.append(Integer.toHexString(i3));
        }
        String toUpperCase = stringBuilder.toString().toUpperCase(Locale.US);
        AppMethodBeat.o(20246);
        return toUpperCase;
    }

    public static long aO(byte[] bArr) {
        long j = 0;
        for (int i = 0; i < 8; i++) {
            j |= (((long) bArr[i]) & 255) << ((7 - i) << 3);
        }
        return j;
    }

    public static String bqh() {
        int i = 7;
        int i2 = 0;
        AppMethodBeat.i(20247);
        String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        try {
            i2 = bo.getInt(String.valueOf(Calendar.getInstance().get(7)), 0);
            if (i2 != 1) {
                i = i2 - 1;
            }
        } catch (Exception e) {
            ab.e("MicroMsg.exdevice.Util", "parse day failed : %s", e.getMessage());
            i = i2;
        }
        String str = format + i;
        AppMethodBeat.o(20247);
        return str;
    }

    /* renamed from: if */
    public static String m20if(long j) {
        int i = 0;
        AppMethodBeat.i(20248);
        byte[] bArr = new byte[6];
        for (int i2 = 0; i2 < 6; i2++) {
            bArr[i2] = (byte) ((int) (j >> (40 - (i2 << 3))));
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (i < 6) {
            int i3 = bArr[i] & 255;
            if (i3 < 16) {
                stringBuilder.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            stringBuilder.append(Integer.toHexString(i3));
            i++;
        }
        String toUpperCase = stringBuilder.toString().toUpperCase(Locale.US);
        AppMethodBeat.o(20248);
        return toUpperCase;
    }

    public static String KL(String str) {
        AppMethodBeat.i(20249);
        if (str == null || 12 != str.length()) {
            ab.e("MicroMsg.exdevice.Util", "%s is not server string mac", str);
            AppMethodBeat.o(20249);
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder("");
        int i = 0;
        while (i < str.length()) {
            stringBuilder.append(str.charAt(i));
            if (i % 2 != 0 && i < str.length() - 1) {
                stringBuilder.append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            }
            i++;
        }
        ab.i("MicroMsg.exdevice.Util", "%s to %s is ok", str, stringBuilder.toString());
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(20249);
        return stringBuilder2;
    }

    public static long bqi() {
        long j;
        AppMethodBeat.i(20250);
        String value = g.Nu().getValue("DeviceAutoSyncDuration");
        if (bo.isNullOrNil(value)) {
            j = 60000;
        } else {
            try {
                j = Long.parseLong(value) * 1000;
            } catch (Exception e) {
                ab.e("MicroMsg.exdevice.Util", "parse string to time out long failed : %s", e.getMessage());
                j = 60000;
            }
        }
        ab.i("MicroMsg.exdevice.Util", "now sync time out is %d", Long.valueOf(j));
        if (j == 0) {
            AppMethodBeat.o(20250);
            return 60000;
        }
        AppMethodBeat.o(20250);
        return j;
    }

    public static boolean dX(String str, String str2) {
        AppMethodBeat.i(20251);
        ab.i("MicroMsg.exdevice.Util", "isDeviceInDeviceList, device = %s, device list = %s", str, str2);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            AppMethodBeat.o(20251);
            return false;
        }
        try {
            String[] split = str2.split("\\|");
            if (split == null) {
                ab.e("MicroMsg.exdevice.Util", "null == deviceArray");
                AppMethodBeat.o(20251);
                return false;
            }
            for (String equalsIgnoreCase : split) {
                if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                    AppMethodBeat.o(20251);
                    return true;
                }
            }
            AppMethodBeat.o(20251);
            return false;
        } catch (Exception e) {
            ab.e("MicroMsg.exdevice.Util", "aDeviceList.split failed, %s", e.getMessage());
            AppMethodBeat.o(20251);
            return false;
        }
    }

    public static String dY(String str, String str2) {
        AppMethodBeat.i(20252);
        ab.i("MicroMsg.exdevice.Util", "addDeviceToDeviceList, device = %s, device list = %s", str, str2);
        if (bo.isNullOrNil(str) || str2 == null) {
            ab.e("MicroMsg.exdevice.Util", "Error parameters!!!");
            AppMethodBeat.o(20252);
            return null;
        }
        ab.i("MicroMsg.exdevice.Util", "add device to device list successful, new device list = %s", ((new String() + str2) + str) + "|");
        AppMethodBeat.o(20252);
        return ((new String() + str2) + str) + "|";
    }

    public static String dZ(String str, String str2) {
        AppMethodBeat.i(20253);
        ab.i("MicroMsg.exdevice.Util", "moveDevicefromDeviceList, device = %s, device list = %s", str, str2);
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            ab.w("MicroMsg.exdevice.Util", "parameters is null or nil");
            AppMethodBeat.o(20253);
            return null;
        }
        try {
            String[] split = str2.split("\\|");
            if (split == null) {
                ab.e("MicroMsg.exdevice.Util", "null == strArray");
                AppMethodBeat.o(20253);
                return null;
            }
            String str3 = new String();
            int i = 0;
            for (String str4 : split) {
                if (str4.equalsIgnoreCase(str)) {
                    i = 1;
                } else {
                    str3 = (str3 + str4) + "|";
                }
            }
            if (i == 0) {
                ab.e("MicroMsg.exdevice.Util", "remove failed!!!, this device is not in the list");
                AppMethodBeat.o(20253);
                return null;
            }
            ab.i("MicroMsg.exdevice.Util", "add device to device list successful, new device list = %s", str2);
            AppMethodBeat.o(20253);
            return str3;
        } catch (Exception e) {
            ab.e("MicroMsg.exdevice.Util", "aDeviceList.split failed!!!, %s", e.getMessage());
            AppMethodBeat.o(20253);
            return null;
        }
    }

    public static UUID aP(byte[] bArr) {
        AppMethodBeat.i(20254);
        ab.d("MicroMsg.exdevice.Util", "parseUUIDFromByteArray, uuid byte array = %s", aN(bArr));
        if (bo.cb(bArr)) {
            ab.e("MicroMsg.exdevice.Util", "aUUIDByteArray is null or nil");
            AppMethodBeat.o(20254);
            return null;
        } else if (16 != bArr.length) {
            ab.e("MicroMsg.exdevice.Util", "the length (%d) of this byte array is not 16", Integer.valueOf(bArr.length));
            AppMethodBeat.o(20254);
            return null;
        } else {
            ByteBuffer allocate = ByteBuffer.allocate(8);
            ByteBuffer allocate2 = ByteBuffer.allocate(8);
            try {
                allocate.put(bArr, 0, 8);
                allocate.flip();
                allocate2.put(bArr, 8, 8);
                allocate2.flip();
                ab.d("MicroMsg.exdevice.Util", "parse successful, string of uuid = %s", new UUID(allocate.getLong(), allocate2.getLong()).toString());
                AppMethodBeat.o(20254);
                return new UUID(allocate.getLong(), allocate2.getLong());
            } catch (Exception e) {
                ab.e("MicroMsg.exdevice.Util", "%s", e.getMessage());
                AppMethodBeat.o(20254);
                return null;
            }
        }
    }

    public static boolean c(byte[] bArr, int i, byte[] bArr2) {
        AppMethodBeat.i(20255);
        if (bo.cb(bArr) || bo.cb(bArr2) || bArr2.length + i > bArr.length || i < 0 || i >= bArr.length) {
            AppMethodBeat.o(20255);
            return false;
        }
        int i2 = 0;
        while (i2 < bArr2.length && bArr2[i2] == bArr[i2 + i]) {
            i2++;
        }
        if (i2 != bArr2.length) {
            AppMethodBeat.o(20255);
            return false;
        }
        AppMethodBeat.o(20255);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0075 A:{SYNTHETIC, Splitter:B:23:0x0075} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009d A:{SYNTHETIC, Splitter:B:35:0x009d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] bQ(Object obj) {
        byte[] toByteArray;
        IOException e;
        Throwable th;
        AppMethodBeat.i(20256);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream;
        try {
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeObject(obj);
                objectOutputStream.flush();
                toByteArray = byteArrayOutputStream.toByteArray();
                if (toByteArray == null) {
                    try {
                        ab.e("MicroMsg.exdevice.Util", "object2bytes result is null");
                    } catch (IOException e2) {
                        e = e2;
                        try {
                            ab.e("MicroMsg.exdevice.Util", "object2bytes IOException:" + e.getMessage());
                            ab.printErrStackTrace("MicroMsg.exdevice.Util", e, "", new Object[0]);
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                } catch (IOException e3) {
                                    ab.printErrStackTrace("MicroMsg.exdevice.Util", e3, "", new Object[0]);
                                }
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e32) {
                                ab.printErrStackTrace("MicroMsg.exdevice.Util", e32, "", new Object[0]);
                            }
                            AppMethodBeat.o(20256);
                            return toByteArray;
                        } catch (Throwable th2) {
                            th = th2;
                            if (objectOutputStream != null) {
                                try {
                                    objectOutputStream.close();
                                } catch (IOException e322) {
                                    ab.printErrStackTrace("MicroMsg.exdevice.Util", e322, "", new Object[0]);
                                }
                            }
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e3222) {
                                ab.printErrStackTrace("MicroMsg.exdevice.Util", e3222, "", new Object[0]);
                            }
                            AppMethodBeat.o(20256);
                            throw th;
                        }
                    }
                }
                try {
                    objectOutputStream.close();
                } catch (IOException e32222) {
                    ab.printErrStackTrace("MicroMsg.exdevice.Util", e32222, "", new Object[0]);
                }
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e322222) {
                    ab.printErrStackTrace("MicroMsg.exdevice.Util", e322222, "", new Object[0]);
                }
                AppMethodBeat.o(20256);
            } catch (IOException e4) {
                e322222 = e4;
                toByteArray = null;
            }
        } catch (IOException e5) {
            e322222 = e5;
            objectOutputStream = null;
            toByteArray = null;
            ab.e("MicroMsg.exdevice.Util", "object2bytes IOException:" + e322222.getMessage());
            ab.printErrStackTrace("MicroMsg.exdevice.Util", e322222, "", new Object[0]);
            if (objectOutputStream != null) {
            }
            byteArrayOutputStream.close();
            AppMethodBeat.o(20256);
            return toByteArray;
        } catch (Throwable th3) {
            th = th3;
            objectOutputStream = null;
            if (objectOutputStream != null) {
            }
            byteArrayOutputStream.close();
            AppMethodBeat.o(20256);
            throw th;
        }
        return toByteArray;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:20:0x0041=Splitter:B:20:0x0041, B:46:0x00d9=Splitter:B:46:0x00d9, B:33:0x008c=Splitter:B:33:0x008c} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b4 A:{SYNTHETIC, Splitter:B:36:0x00b4} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0101 A:{SYNTHETIC, Splitter:B:49:0x0101} */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0128 A:{SYNTHETIC, Splitter:B:60:0x0128} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Object aQ(byte[] bArr) {
        Object readObject;
        IOException e;
        StreamCorruptedException e2;
        ClassNotFoundException e3;
        Throwable th;
        ObjectInputStream readObject2 = null;
        AppMethodBeat.i(20257);
        if (bArr == null) {
            AppMethodBeat.o(20257);
        } else {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ObjectInputStream objectInputStream;
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    readObject2 = objectInputStream.readObject();
                    try {
                        objectInputStream.close();
                    } catch (IOException e4) {
                        ab.printErrStackTrace("MicroMsg.exdevice.Util", e4, "", new Object[0]);
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e42) {
                        ab.printErrStackTrace("MicroMsg.exdevice.Util", e42, "", new Object[0]);
                    }
                } catch (StreamCorruptedException e5) {
                    e2 = e5;
                } catch (IOException e6) {
                    e42 = e6;
                    ab.e("MicroMsg.exdevice.Util", "bytes2object IOException:" + e42.getMessage());
                    ab.printErrStackTrace("MicroMsg.exdevice.Util", e42, "", new Object[0]);
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e422) {
                            ab.printErrStackTrace("MicroMsg.exdevice.Util", e422, "", new Object[0]);
                        }
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e4222) {
                        ab.printErrStackTrace("MicroMsg.exdevice.Util", e4222, "", new Object[0]);
                    }
                    AppMethodBeat.o(20257);
                    return readObject2;
                } catch (ClassNotFoundException e7) {
                    e3 = e7;
                    ab.e("MicroMsg.exdevice.Util", "bytes2object ClassNotFoundException:" + e3.getMessage());
                    ab.printErrStackTrace("MicroMsg.exdevice.Util", e3, "", new Object[0]);
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e42222) {
                            ab.printErrStackTrace("MicroMsg.exdevice.Util", e42222, "", new Object[0]);
                        }
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e422222) {
                        ab.printErrStackTrace("MicroMsg.exdevice.Util", e422222, "", new Object[0]);
                    }
                    AppMethodBeat.o(20257);
                    return readObject2;
                }
            } catch (StreamCorruptedException e8) {
                e2 = e8;
                objectInputStream = readObject2;
                try {
                    ab.e("MicroMsg.exdevice.Util", "bytes2object StreamCorruptedException:" + e2.getMessage());
                    ab.printErrStackTrace("MicroMsg.exdevice.Util", e2, "", new Object[0]);
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (IOException e4222222) {
                            ab.printErrStackTrace("MicroMsg.exdevice.Util", e4222222, "", new Object[0]);
                        }
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e42222222) {
                        ab.printErrStackTrace("MicroMsg.exdevice.Util", e42222222, "", new Object[0]);
                    }
                    AppMethodBeat.o(20257);
                    return readObject2;
                } catch (Throwable th2) {
                    th = th2;
                    if (objectInputStream != null) {
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e9) {
                        ab.printErrStackTrace("MicroMsg.exdevice.Util", e9, "", new Object[0]);
                    }
                    AppMethodBeat.o(20257);
                    throw th;
                }
            } catch (IOException e10) {
                e42222222 = e10;
                objectInputStream = readObject2;
                ab.e("MicroMsg.exdevice.Util", "bytes2object IOException:" + e42222222.getMessage());
                ab.printErrStackTrace("MicroMsg.exdevice.Util", e42222222, "", new Object[0]);
                if (objectInputStream != null) {
                }
                byteArrayInputStream.close();
                AppMethodBeat.o(20257);
                return readObject2;
            } catch (ClassNotFoundException e11) {
                e3 = e11;
                objectInputStream = readObject2;
                ab.e("MicroMsg.exdevice.Util", "bytes2object ClassNotFoundException:" + e3.getMessage());
                ab.printErrStackTrace("MicroMsg.exdevice.Util", e3, "", new Object[0]);
                if (objectInputStream != null) {
                }
                byteArrayInputStream.close();
                AppMethodBeat.o(20257);
                return readObject2;
            } catch (Throwable th3) {
                th = th3;
                objectInputStream = readObject2;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e92) {
                        ab.printErrStackTrace("MicroMsg.exdevice.Util", e92, "", new Object[0]);
                    }
                }
                byteArrayInputStream.close();
                AppMethodBeat.o(20257);
                throw th;
            }
            AppMethodBeat.o(20257);
        }
        return readObject2;
    }

    public static int J(Context context, int i) {
        i = 0;
        AppMethodBeat.i(20258);
        try {
            Rect rect = new Rect();
            ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            int height = ((Activity) context).getWindow().getDecorView().getHeight();
            if (height - rect.height() >= 0) {
                height -= rect.height();
            } else {
                height = rect.top;
            }
            if (height > 0) {
                i = height;
            }
            AppMethodBeat.o(20258);
        } catch (Exception e) {
            ab.i("MicroMsg.exdevice.Util", "getStatusHeight err: %s", e.toString());
            AppMethodBeat.o(20258);
        } catch (Throwable th) {
            AppMethodBeat.o(20258);
        }
        return i;
    }
}
