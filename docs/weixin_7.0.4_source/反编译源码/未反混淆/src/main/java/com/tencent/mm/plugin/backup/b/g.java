package com.tencent.mm.plugin.backup.b;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.StatFs;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.o;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.backup.f.k;
import com.tencent.mm.plugin.backup.h.d;
import com.tencent.mm.plugin.backup.i.m;
import com.tencent.mm.plugin.backup.i.x;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.protobuf.bts;
import com.tencent.mm.protocal.protobuf.btt;
import com.tencent.mm.protocal.protobuf.gu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.FileSystem;
import com.tencent.mm.vfs.FileSystemManager;
import com.tencent.mm.vfs.e;
import com.tencent.ttpic.model.WMElement;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.http.conn.util.InetAddressUtils;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

public final class g {
    private static List<String> elZ = null;

    public static class a {
        public static String jrk = "<msg>";
        public static String jrl = "</msg>";

        public static String Fg(String str) {
            AppMethodBeat.i(17116);
            com.tencent.mm.plugin.backup.f.k.a Fk = k.Fk(str);
            if (Fk == null) {
                AppMethodBeat.o(17116);
                return null;
            }
            String str2 = Fk.jvN;
            AppMethodBeat.o(17116);
            return str2;
        }

        public static String a(bi biVar, gu guVar) {
            AppMethodBeat.i(17117);
            EmojiInfo aqi = d.aUr().aUs().aUp().aqi(biVar.field_imgPath);
            if (aqi == null) {
                AppMethodBeat.o(17117);
                return null;
            }
            com.tencent.mm.plugin.backup.f.k.a Fl = k.Fl(aqi.Aq());
            if (Fl == null) {
                Fl = new com.tencent.mm.plugin.backup.f.k.a(aqi.Aq(), aqi.Aq(), aqi.Aq(), aqi.Aq());
            }
            StringWriter stringWriter = new StringWriter();
            String bc;
            try {
                XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
                newSerializer.setOutput(stringWriter);
                newSerializer.startDocument("UTF-8", Boolean.TRUE);
                newSerializer.startTag(null, "msg");
                newSerializer.startTag(null, "emoji");
                newSerializer.attribute(null, "fromusername", guVar.vEB.wVI);
                newSerializer.attribute(null, "tousername", guVar.vEC.wVI);
                newSerializer.attribute(null, "type", aqi.field_type);
                newSerializer.attribute(null, "idbuffer", aqi.duW());
                newSerializer.attribute(null, "md5", Fl.jvO);
                newSerializer.attribute(null, "len", "1024");
                newSerializer.attribute(null, "androidmd5", Fl.jvN);
                newSerializer.attribute(null, "androidlen", "1024");
                newSerializer.attribute(null, "productid", aqi.field_groupId);
                newSerializer.attribute(null, "cdnurl", aqi.field_cdnUrl);
                newSerializer.attribute(null, "designerid", aqi.field_designerID);
                newSerializer.attribute(null, "thumburl", aqi.field_thumbUrl);
                newSerializer.attribute(null, "encrypturl", aqi.field_encrypturl);
                newSerializer.attribute(null, "aeskey", aqi.field_aeskey);
                newSerializer.attribute(null, "externurl", aqi.field_externUrl);
                newSerializer.attribute(null, "externmd5", aqi.field_externMd5);
                newSerializer.attribute(null, "width", String.valueOf(aqi.field_width));
                newSerializer.attribute(null, "height", String.valueOf(aqi.field_height));
                newSerializer.attribute(null, "tpurl", aqi.field_tpurl);
                newSerializer.attribute(null, "tpauthkey", aqi.field_tpauthkey);
                newSerializer.attribute(null, "attachedtext", aqi.field_attachedText);
                newSerializer.attribute(null, "attachedtextcolor", aqi.field_attachTextColor);
                newSerializer.attribute(null, "lensid", aqi.field_lensId);
                newSerializer.attribute(null, "activityid", aqi.field_activityid);
                newSerializer.endTag(null, "emoji");
                if (aqi.xy()) {
                    newSerializer.startTag(null, "gameext");
                    Map z = br.z(aqi.getContent(), "gameext");
                    String bc2 = bo.bc((String) z.get(".gameext.$type"), "");
                    bc = bo.bc((String) z.get(".gameext.$content"), "");
                    if (bc2.equals("") || bc.equals("")) {
                        stringWriter.close();
                        bc = "";
                        AppMethodBeat.o(17117);
                        return bc;
                    }
                    newSerializer.attribute(null, "type", String.valueOf(bc2));
                    newSerializer.attribute(null, b.CONTENT, String.valueOf(bc));
                    newSerializer.endTag(null, "gameext");
                }
                newSerializer.endTag(null, "msg");
                newSerializer.endDocument();
                stringWriter.flush();
                stringWriter.close();
                bc = stringWriter.getBuffer().toString();
                try {
                    bc = bc.substring(bc.indexOf(jrk), bc.indexOf(jrl) + jrl.length());
                    ab.d("MicroMsg.BackupUtil.EmojiConvert", "xml ".concat(String.valueOf(bc)));
                    AppMethodBeat.o(17117);
                    return bc;
                } catch (Exception e) {
                    bc = "";
                    AppMethodBeat.o(17117);
                    return bc;
                }
            } catch (XmlPullParserException e2) {
                ab.printErrStackTrace("MicroMsg.BackupUtil.EmojiConvert", e2, "", new Object[0]);
                bc = "";
                AppMethodBeat.o(17117);
                return bc;
            } catch (IllegalArgumentException e3) {
                ab.printErrStackTrace("MicroMsg.BackupUtil.EmojiConvert", e3, "", new Object[0]);
                bc = "";
                AppMethodBeat.o(17117);
                return bc;
            } catch (IllegalStateException e4) {
                ab.printErrStackTrace("MicroMsg.BackupUtil.EmojiConvert", e4, "", new Object[0]);
                bc = "";
                AppMethodBeat.o(17117);
                return bc;
            } catch (IOException e5) {
                ab.printErrStackTrace("MicroMsg.BackupUtil.EmojiConvert", e5, "", new Object[0]);
                bc = "";
                AppMethodBeat.o(17117);
                return bc;
            }
        }
    }

    public static <T extends com.tencent.mm.bt.a> T a(T t, byte[] bArr) {
        AppMethodBeat.i(17118);
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.o(17118);
            return null;
        }
        try {
            t.parseFrom(bArr);
            AppMethodBeat.o(17118);
            return t;
        } catch (Exception e) {
            ab.e("MicroMsg.BackupUtil", "ERROR: parseProBuf [%s] [%s]", e.getMessage(), bo.l(e));
            AppMethodBeat.o(17118);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A:{SYNTHETIC, Splitter:B:20:0x006b} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007a A:{SYNTHETIC, Splitter:B:27:0x007a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(String str, x xVar) {
        Throwable e;
        AppMethodBeat.i(17119);
        RandomAccessFile randomAccessFile = null;
        try {
            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str);
            if (!bVar.exists()) {
                bVar.mkdirs();
            }
            String str2 = str + xVar.jCx;
            com.tencent.mm.vfs.b bVar2 = new com.tencent.mm.vfs.b(str2);
            if (!bVar2.exists()) {
                bVar2.createNewFile();
            }
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(str2, "rw");
            try {
                randomAccessFile2.setLength((long) xVar.jCz);
                randomAccessFile2.seek((long) xVar.jCA);
                randomAccessFile2.write(xVar.jBi.wR);
                try {
                    randomAccessFile2.close();
                    AppMethodBeat.o(17119);
                } catch (Exception e2) {
                    AppMethodBeat.o(17119);
                }
            } catch (Exception e3) {
                e = e3;
                randomAccessFile = randomAccessFile2;
                try {
                    ab.printErrStackTrace("MicroMsg.BackupUtil", e, "writeMediaToFile fail with exception", new Object[0]);
                    if (randomAccessFile != null) {
                    }
                    AppMethodBeat.o(17119);
                } catch (Throwable th) {
                    e = th;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e4) {
                        }
                    }
                    AppMethodBeat.o(17119);
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                }
                AppMethodBeat.o(17119);
                throw e;
            }
        } catch (Exception e5) {
            e = e5;
            ab.printErrStackTrace("MicroMsg.BackupUtil", e, "writeMediaToFile fail with exception", new Object[0]);
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Exception e6) {
                    AppMethodBeat.o(17119);
                    return;
                }
            }
            AppMethodBeat.o(17119);
        }
    }

    public static long EY(String str) {
        boolean z = false;
        AppMethodBeat.i(17120);
        com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str);
        if (!bVar.exists()) {
            AppMethodBeat.o(17120);
            return -1;
        } else if (bVar.canRead()) {
            FileSystemManager.d dMA = bVar.dMA();
            if (dMA.valid()) {
                FileSystem fileSystem = dMA.zZs;
                if ((fileSystem.aiR() & 1) != 0) {
                    String O = fileSystem.O(dMA.path, true);
                    z = O != null ? new File(O).canWrite() : fileSystem.exists(dMA.path);
                }
            }
            if (z) {
                long length = bVar.length();
                AppMethodBeat.o(17120);
                return length;
            }
            AppMethodBeat.o(17120);
            return -3;
        } else {
            AppMethodBeat.o(17120);
            return -2;
        }
    }

    public static void b(String str, x xVar) {
        AppMethodBeat.i(17121);
        if (TextUtils.isEmpty(str) || xVar == null) {
            ab.e("MicroMsg.BackupUtil", "appendFile dir:%s req:%s ", str, xVar);
            AppMethodBeat.o(17121);
        } else if (TextUtils.isEmpty(xVar.jCx) || xVar.jBi == null || bo.cc(xVar.jBi.wR) <= 0) {
            String str2;
            String str3 = "MicroMsg.BackupUtil";
            String str4 = "appendFile dataid:%s data:%s  %s";
            Object[] objArr = new Object[3];
            objArr[0] = xVar.jCx;
            objArr[1] = xVar.jBi;
            if (xVar.jBi == null) {
                str2 = BuildConfig.COMMAND;
            } else {
                str2 = Integer.valueOf(bo.cc(xVar.jBi.wR));
            }
            objArr[2] = str2;
            ab.e(str3, str4, objArr);
            AppMethodBeat.o(17121);
        } else {
            int i = 3;
            while (true) {
                int i2 = i - 1;
                if (i > 0) {
                    long EY = EY(str + xVar.jCx);
                    i = c(str, xVar);
                    long EY2 = EY(str + xVar.jCx);
                    if (i != 0 || EY2 < ((long) xVar.jBi.wR.length)) {
                        ab.e("MicroMsg.BackupUtil", "appendFile retry:%d append:%d  old:%d  new:%d  data:%d", Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(EY), Long.valueOf(EY2), Integer.valueOf(xVar.jBi.wR.length));
                        i = i2;
                    } else {
                        AppMethodBeat.o(17121);
                        return;
                    }
                }
                AppMethodBeat.o(17121);
                return;
            }
        }
    }

    private static int c(String str, x xVar) {
        AppMethodBeat.i(17122);
        try {
            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str);
            if (!bVar.exists()) {
                bVar.mkdirs();
            }
            String str2 = str + "/" + xVar.jCx;
            com.tencent.mm.vfs.b bVar2 = new com.tencent.mm.vfs.b(str2);
            if (!bVar2.exists()) {
                bVar2.createNewFile();
            }
            byte[] bArr = xVar.jBi.wR;
            int a = e.a(str2, bArr, bArr.length);
            AppMethodBeat.o(17122);
            return a;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BackupUtil", e, "", new Object[0]);
            AppMethodBeat.o(17122);
            return -1;
        }
    }

    public static int b(String str, String str2, byte[] bArr) {
        AppMethodBeat.i(17123);
        try {
            com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(str);
            if (!bVar.exists()) {
                bVar.mkdirs();
            }
            String str3 = str + "/" + str2;
            com.tencent.mm.vfs.b bVar2 = new com.tencent.mm.vfs.b(str3);
            if (!bVar2.exists()) {
                bVar2.createNewFile();
            }
            int a = e.a(str3, bArr, bArr.length);
            AppMethodBeat.o(17123);
            return a;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.BackupUtil", e, "", new Object[0]);
            AppMethodBeat.o(17123);
            return -1;
        }
    }

    public static String ds(Context context) {
        AppMethodBeat.i(17124);
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        String gE;
        if (wifiManager.getWifiState() == 3) {
            try {
                gE = at.gE(context);
                if (bo.isNullOrNil(gE)) {
                    gE = "wifi";
                }
                if (gE.length() >= 2 && gE.startsWith("\"") && gE.endsWith("\"")) {
                    gE = gE.substring(1, gE.length() - 1);
                }
                AppMethodBeat.o(17124);
                return gE;
            } catch (Exception e) {
                ab.e("MicroMsg.BackupUtil", "getConnectionInfo %s", e);
                ab.printErrStackTrace("MicroMsg.BackupUtil", e, "", new Object[0]);
                gE = "";
                AppMethodBeat.o(17124);
                return gE;
            }
        }
        int intValue;
        int i = 13;
        try {
            i = ((Integer) wifiManager.getClass().getField("WIFI_AP_STATE_ENABLED").get(wifiManager)).intValue();
            intValue = ((Integer) wifiManager.getClass().getMethod("getWifiApState", new Class[0]).invoke(wifiManager, new Object[0])).intValue();
        } catch (Exception e2) {
            ab.e("MicroMsg.BackupUtil", "getWifiApState %s", e2);
            ab.printErrStackTrace("MicroMsg.BackupUtil", e2, "", new Object[0]);
            intValue = 0;
        }
        if (intValue == i) {
            ab.i("MicroMsg.BackupUtil", "getWifiName apmode");
            try {
                gE = ((WifiConfiguration) wifiManager.getClass().getMethod("getWifiApConfiguration", new Class[0]).invoke(wifiManager, new Object[0])).SSID;
                AppMethodBeat.o(17124);
                return gE;
            } catch (Exception e3) {
                ab.e("MicroMsg.BackupUtil", "getWifiApConfiguration %s", e3);
                ab.printErrStackTrace("MicroMsg.BackupUtil", e3, "", new Object[0]);
            }
        }
        gE = "";
        AppMethodBeat.o(17124);
        return gE;
    }

    public static String aSF() {
        AppMethodBeat.i(17125);
        StringBuilder stringBuilder = new StringBuilder();
        aw.ZK();
        String stringBuilder2 = stringBuilder.append(c.getAccPath()).append("backupRecover/").toString();
        AppMethodBeat.o(17125);
        return stringBuilder2;
    }

    public static String EZ(String str) {
        AppMethodBeat.i(17126);
        String str2;
        if (str == null || str.equals("")) {
            str2 = "";
            AppMethodBeat.o(17126);
            return str2;
        }
        str2 = aSF() + "backupItem/" + Fb(str);
        AppMethodBeat.o(17126);
        return str2;
    }

    public static String Fa(String str) {
        AppMethodBeat.i(17127);
        String str2;
        if (str == null || str.equals("")) {
            str2 = "";
            AppMethodBeat.o(17127);
            return str2;
        }
        str2 = aSF() + "backupMeida/" + Fb(str);
        AppMethodBeat.o(17127);
        return str2;
    }

    private static String Fb(String str) {
        AppMethodBeat.i(17128);
        String str2;
        if (str == null) {
            str2 = "";
            AppMethodBeat.o(17128);
            return str2;
        }
        String x = com.tencent.mm.a.g.x(str.getBytes());
        str2 = "";
        String str3 = "";
        if (x.length() > 0) {
            str2 = x.charAt(0) + "/";
        }
        if (x.length() >= 2) {
            str3 = x.charAt(1) + "/";
        }
        str2 = str2 + str3;
        AppMethodBeat.o(17128);
        return str2;
    }

    public static int aSG() {
        AppMethodBeat.i(17129);
        Intent registerReceiver = ah.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            AppMethodBeat.o(17129);
            return 100;
        }
        boolean z;
        int intExtra = registerReceiver.getIntExtra("status", -1);
        if (intExtra == 2 || intExtra == 5) {
            z = true;
        } else {
            z = false;
        }
        ab.i("MicroMsg.BackupUtil", "checkBatteryLevel, battery isCharging[%b]", Boolean.valueOf(z));
        if (z) {
            AppMethodBeat.o(17129);
            return 100;
        }
        intExtra = registerReceiver.getIntExtra("level", -1);
        int intExtra2 = registerReceiver.getIntExtra(WMElement.ANIMATE_TYPE_SCALE, -1);
        if (intExtra < 0 || intExtra2 <= 0) {
            intExtra = 100;
        } else {
            intExtra = (intExtra * 100) / intExtra2;
        }
        ab.i("MicroMsg.BackupUtil", "checkBatteryLevel, battery level remaining[%d]", Integer.valueOf(intExtra));
        AppMethodBeat.o(17129);
        return intExtra;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x00f6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean Fc(String str) {
        int ipAddress;
        int intValue;
        Throwable e;
        AppMethodBeat.i(17130);
        String[] split = str.split("\\.");
        int A = o.A(new byte[]{(byte) (bo.getInt(split[0], 0) & 255), (byte) (bo.getInt(split[1], 0) & 255), (byte) (bo.getInt(split[2], 0) & 255), (byte) (bo.getInt(split[3], 0) & 255)});
        int A2 = o.A(new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) 0});
        WifiManager wifiManager = (WifiManager) ah.getContext().getSystemService("wifi");
        if (wifiManager.getWifiState() == 3) {
            ipAddress = wifiManager.getConnectionInfo().getIpAddress();
            String str2 = (ipAddress & 255) + "." + ((ipAddress >> 8) & 255) + "." + ((ipAddress >> 16) & 255) + "." + ((ipAddress >> 24) & 255);
            ab.i("MicroMsg.BackupUtil", "oldIpStr:%s, localIp:%s", str, str2);
            if ((A2 & A) == (ipAddress & A2)) {
                AppMethodBeat.o(17130);
                return true;
            }
            AppMethodBeat.o(17130);
            return false;
        }
        try {
            intValue = ((Integer) wifiManager.getClass().getField("WIFI_AP_STATE_ENABLED").get(wifiManager)).intValue();
            try {
                ipAddress = ((Integer) wifiManager.getClass().getMethod("getWifiApState", new Class[0]).invoke(wifiManager, new Object[0])).intValue();
            } catch (Exception e2) {
                e = e2;
            }
        } catch (Exception e3) {
            e = e3;
            intValue = 13;
        }
        if (ipAddress != intValue) {
            ab.i("MicroMsg.BackupUtil", "matchip in apmode");
            boolean dz = dz(A2, A);
            AppMethodBeat.o(17130);
            return dz;
        }
        ab.i("MicroMsg.BackupUtil", "apState:%d", Integer.valueOf(ipAddress));
        AppMethodBeat.o(17130);
        return false;
        ab.e("MicroMsg.BackupUtil", "getWifiApState %s", e);
        ab.printErrStackTrace("MicroMsg.BackupUtil", e, "", new Object[0]);
        ipAddress = 0;
        if (ipAddress != intValue) {
        }
    }

    private static boolean dz(int i, int i2) {
        AppMethodBeat.i(17131);
        try {
            for (NetworkInterface inetAddresses : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                for (InetAddress inetAddress : Collections.list(inetAddresses.getInetAddresses())) {
                    if (!inetAddress.isLoopbackAddress()) {
                        String toUpperCase = inetAddress.getHostAddress().toUpperCase();
                        ab.i("MicroMsg.BackupUtil", "check ip:%s, isIPv4:%b", toUpperCase, Boolean.valueOf(InetAddressUtils.isIPv4Address(toUpperCase)));
                        if (InetAddressUtils.isIPv4Address(toUpperCase)) {
                            String[] split = toUpperCase.split("\\.");
                            if ((i & i2) == (o.A(new byte[]{(byte) (bo.getInt(split[0], 0) & 255), (byte) (bo.getInt(split[1], 0) & 255), (byte) (bo.getInt(split[2], 0) & 255), (byte) (bo.getInt(split[3], 0) & 255)}) & i)) {
                                AppMethodBeat.o(17131);
                                return true;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        AppMethodBeat.o(17131);
        return false;
    }

    public static boolean Fd(String str) {
        AppMethodBeat.i(17132);
        if (str == null) {
            AppMethodBeat.o(17132);
            return false;
        }
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        if (br.z(str, "msg") != null) {
            AppMethodBeat.o(17132);
            return true;
        }
        AppMethodBeat.o(17132);
        return false;
    }

    public static String a(gu guVar, int i) {
        AppMethodBeat.i(17133);
        String a = a(guVar, i, null);
        AppMethodBeat.o(17133);
        return a;
    }

    /* JADX WARNING: Missing block: B:20:0x0073, code skipped:
            if (com.tencent.mm.vfs.e.ct(Fa(r0) + r0) == false) goto L_0x0079;
     */
    /* JADX WARNING: Missing block: B:21:0x0075, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(17134);
     */
    /* JADX WARNING: Missing block: B:22:0x0079, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(17134);
     */
    /* JADX WARNING: Missing block: B:32:?, code skipped:
            return r0;
     */
    /* JADX WARNING: Missing block: B:33:?, code skipped:
            return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String a(gu guVar, int i, String str) {
        AppMethodBeat.i(17134);
        String str2;
        if (guVar.vJf != i || guVar.vJd == null) {
            int i2 = 0;
            if (guVar.vJc != null && guVar.vJb != null) {
                Iterator it = guVar.vJc.iterator();
                while (true) {
                    int i3 = i2;
                    if (!it.hasNext()) {
                        break;
                    } else if (((btt) it.next()).wVK == i) {
                        str2 = ((bts) guVar.vJb.get(i3)).wVI;
                        if (!bo.isNullOrNil(str) && !str2.endsWith(str)) {
                            i2 = (i3 + 1) + 1;
                        }
                    } else {
                        i2 = i3 + 1;
                    }
                }
            }
            AppMethodBeat.o(17134);
            return null;
        }
        str2 = com.tencent.mm.a.g.x(guVar.vJd.getBuffer().wR);
        AppMethodBeat.o(17134);
        return str2;
    }

    public static int bC(String str, int i) {
        AppMethodBeat.i(17135);
        if (!bo.isNullOrNil(str)) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.BackupUtil", e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(17135);
        return i;
    }

    public static long Fe(String str) {
        AppMethodBeat.i(17136);
        long j = 0;
        if (!bo.isNullOrNil(str)) {
            try {
                j = Long.valueOf(str).longValue();
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.BackupUtil", e, "", new Object[0]);
            }
        }
        AppMethodBeat.o(17136);
        return j;
    }

    public static boolean b(gu guVar, int i, String str) {
        AppMethodBeat.i(17137);
        if (guVar.vJf == i) {
            byte[] bArr = guVar.vJd.getBuffer().wR;
            if (bArr.length <= 0) {
                AppMethodBeat.o(17137);
                return false;
            }
            e.b(str, bArr, bArr.length);
            AppMethodBeat.o(17137);
            return true;
        }
        String a = a(guVar, i, null);
        if (bo.isNullOrNil(a)) {
            AppMethodBeat.o(17137);
            return false;
        }
        e.y(Fa(a) + a, str);
        AppMethodBeat.o(17137);
        return true;
    }

    public static byte[] b(gu guVar, int i) {
        AppMethodBeat.i(17138);
        byte[] e;
        if (guVar.vJf != i || guVar.vJd == null) {
            if (!(guVar.vJc == null || guVar.vJb == null)) {
                Iterator it = guVar.vJc.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    if (((btt) it.next()).wVK == i) {
                        String str = ((bts) guVar.vJb.get(i2)).wVI;
                        str = Fa(str) + str;
                        i2 = (int) e.asZ(str);
                        if (i2 == 0 || i2 > 1048576) {
                            ab.e("MicroMsg.BackupUtil", "thumb not exist or  too big!");
                            AppMethodBeat.o(17138);
                            return null;
                        }
                        e = e.e(str, 0, -1);
                        AppMethodBeat.o(17138);
                        return e;
                    }
                    i2++;
                }
            }
            AppMethodBeat.o(17138);
            return null;
        }
        e = guVar.vJd.getBuffer().wR;
        AppMethodBeat.o(17138);
        return e;
    }

    public static int c(gu guVar, int i) {
        AppMethodBeat.i(17139);
        int asZ;
        if (guVar.vJf != i) {
            if (!(guVar.vJc == null || guVar.vJb == null)) {
                Iterator it = guVar.vJc.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    if (((btt) it.next()).wVK == i) {
                        String str = ((bts) guVar.vJb.get(i2)).wVI;
                        asZ = (int) e.asZ(Fa(str) + str);
                        AppMethodBeat.o(17139);
                        return asZ;
                    }
                    i2++;
                }
            }
            AppMethodBeat.o(17139);
            return 0;
        } else if (guVar.vJd == null) {
            AppMethodBeat.o(17139);
            return 0;
        } else {
            asZ = guVar.vJd.getBuffer().wR.length;
            AppMethodBeat.o(17139);
            return asZ;
        }
    }

    public static boolean d(gu guVar, int i) {
        AppMethodBeat.i(17140);
        if (guVar.vJf != i || guVar.vJd == null) {
            Iterator it = guVar.vJc.iterator();
            while (it.hasNext()) {
                if (((btt) it.next()).wVK == i) {
                    AppMethodBeat.o(17140);
                    return true;
                }
            }
            AppMethodBeat.o(17140);
            return false;
        }
        AppMethodBeat.o(17140);
        return true;
    }

    public static List<String> Ko() {
        AppMethodBeat.i(17141);
        if (elZ != null) {
            List list = elZ;
            AppMethodBeat.o(17141);
            return list;
        }
        elZ = new LinkedList();
        for (Object add : t.fkY) {
            elZ.add(add);
        }
        elZ.add("weixin");
        elZ.add("weibo");
        elZ.add("qqmail");
        elZ.add("fmessage");
        elZ.add("tmessage");
        elZ.add("qmessage");
        elZ.add("qqsync");
        elZ.add("floatbottle");
        elZ.add("lbsapp");
        elZ.add("shakeapp");
        elZ.add("medianote");
        elZ.add("qqfriend");
        elZ.add("readerapp");
        elZ.add("newsapp");
        elZ.add("blogapp");
        elZ.add("facebookapp");
        elZ.add("masssendapp");
        elZ.add("meishiapp");
        elZ.add("feedsapp");
        elZ.add("voipapp");
        elZ.add("officialaccounts");
        elZ.add("helper_entry");
        elZ.add("pc_share");
        elZ.add("cardpackage");
        elZ.add("voicevoipapp");
        elZ.add("voiceinputapp");
        elZ.add("linkedinplugin");
        elZ.add("appbrandcustomerservicemsg");
        List<String> list2 = elZ;
        AppMethodBeat.o(17141);
        return list2;
    }

    public static boolean a(PLong pLong, PLong pLong2, String str) {
        AppMethodBeat.i(17142);
        StatFs statFs = new StatFs(h.getExternalStorageDirectory().getPath());
        pLong.value = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        File dataDirectory = h.getDataDirectory();
        statFs = new StatFs(dataDirectory.getPath());
        long blockCount = (long) statFs.getBlockCount();
        long availableBlocks = (long) statFs.getAvailableBlocks();
        pLong2.value = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        ab.i("MicroMsg.BackupUtil", "checkDataFull, SDAvailSize:%d, DataAvailSize%d, dbSize:%d", Long.valueOf(pLong.value), Long.valueOf(pLong2.value), Long.valueOf(0));
        if (blockCount <= 0) {
            AppMethodBeat.o(17142);
            return false;
        } else if (blockCount - availableBlocks < 0) {
            AppMethodBeat.o(17142);
            return false;
        } else {
            if (pLong.value == pLong2.value || str.startsWith(dataDirectory.getPath())) {
                pLong.value = 0;
            }
            if (0 > pLong2.value) {
                AppMethodBeat.o(17142);
                return false;
            }
            AppMethodBeat.o(17142);
            return true;
        }
    }

    public static long Ff(String str) {
        AppMethodBeat.i(17143);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        long anU = bo.anU();
        try {
            anU = simpleDateFormat.parse(str).getTime();
        } catch (ParseException e) {
            ab.e("MicroMsg.BackupUtil", "dateToTimeStamp failed. date:%s, stack:%s", str, bo.dpG());
        }
        AppMethodBeat.o(17143);
        return anU;
    }

    public static LinkedList<String> A(LinkedList<f.b> linkedList) {
        AppMethodBeat.i(17144);
        LinkedList linkedList2 = new LinkedList();
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                linkedList2.add(((f.b) it.next()).jrf);
            }
        }
        AppMethodBeat.o(17144);
        return linkedList2;
    }

    public static String a(String str, String str2, String... strArr) {
        AppMethodBeat.i(17145);
        if (strArr == null || strArr.length == 0) {
            AppMethodBeat.o(17145);
            return str;
        }
        StringBuilder stringBuilder;
        int i;
        if (str.equals("")) {
            stringBuilder = new StringBuilder(strArr[0]);
            i = 1;
        } else {
            stringBuilder = new StringBuilder(str);
            i = 0;
        }
        for (String str3 : strArr) {
            if (i != 0) {
                i = 0;
            } else {
                stringBuilder.append(str2).append(str3);
            }
        }
        str = stringBuilder.toString();
        AppMethodBeat.o(17145);
        return str;
    }

    public static String[] cX(String str, String str2) {
        AppMethodBeat.i(17146);
        String[] split = str.split(str2);
        AppMethodBeat.o(17146);
        return split;
    }

    public static m gw(long j) {
        AppMethodBeat.i(17147);
        m mVar = new m();
        String deviceID = q.getDeviceID(ah.getContext());
        if (deviceID == null) {
            deviceID = q.LM();
        }
        mVar.jBE = deviceID;
        mVar.jBF = Build.MANUFACTURER;
        mVar.jBG = Build.MODEL;
        mVar.jBH = "Android";
        mVar.jBI = VERSION.RELEASE;
        mVar.jBJ = com.tencent.mm.protocal.d.vxo;
        mVar.jBK = j;
        ab.i("MicroMsg.BackupUtil", "getBackupStartGeneralInfo WechatVersion[%s], freespace[%d], deviceId[%s]", Integer.valueOf(com.tencent.mm.protocal.d.vxo), Long.valueOf(j), mVar.jBE);
        AppMethodBeat.o(17147);
        return mVar;
    }

    public static LinkedList<com.tencent.mm.plugin.backup.b.f.a> b(LinkedList<String> linkedList, LinkedList<Long> linkedList2) {
        AppMethodBeat.i(17148);
        if (linkedList == null || linkedList2 == null || linkedList.isEmpty() || linkedList.size() * 2 != linkedList2.size()) {
            AppMethodBeat.o(17148);
            return null;
        }
        LinkedList<com.tencent.mm.plugin.backup.b.f.a> linkedList3 = new LinkedList();
        HashMap hashMap = new HashMap();
        Iterator it = linkedList2.iterator();
        Iterator it2 = linkedList.iterator();
        long j = 0;
        long j2 = 0;
        while (it2.hasNext()) {
            String str = (String) it2.next();
            if (it.hasNext()) {
                j2 = ((Long) it.next()).longValue();
                if (it.hasNext()) {
                    j = ((Long) it.next()).longValue();
                }
            }
            int size = hashMap.size();
            if (hashMap.get(str) != null) {
                size = ((Integer) hashMap.get(str)).intValue();
            } else {
                hashMap.put(str, Integer.valueOf(size));
            }
            linkedList3.add(new com.tencent.mm.plugin.backup.b.f.a(size, str, j2, j));
        }
        AppMethodBeat.o(17148);
        return linkedList3;
    }
}
