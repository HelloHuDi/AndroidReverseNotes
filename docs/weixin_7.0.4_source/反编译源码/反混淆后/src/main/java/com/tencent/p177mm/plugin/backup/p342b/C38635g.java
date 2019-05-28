package com.tencent.p177mm.plugin.backup.p342b;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.StatFs;
import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p178a.C37432o;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.plugin.backup.p1394h.C38658d;
import com.tencent.p177mm.plugin.backup.p342b.C45733f.C19940a;
import com.tencent.p177mm.plugin.backup.p342b.C45733f.C27443b;
import com.tencent.p177mm.plugin.backup.p346f.C19973k;
import com.tencent.p177mm.plugin.backup.p346f.C19973k.C19974a;
import com.tencent.p177mm.plugin.backup.p921i.C19990m;
import com.tencent.p177mm.plugin.backup.p921i.C27495x;
import com.tencent.p177mm.pointers.PLong;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.C40522gu;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.protocal.protobuf.btt;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.FileSystem;
import com.tencent.p177mm.vfs.FileSystemManager.C5718d;
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

/* renamed from: com.tencent.mm.plugin.backup.b.g */
public final class C38635g {
    private static List<String> elZ = null;

    /* renamed from: com.tencent.mm.plugin.backup.b.g$a */
    public static class C19941a {
        public static String jrk = "<msg>";
        public static String jrl = "</msg>";

        /* renamed from: Fg */
        public static String m30841Fg(String str) {
            AppMethodBeat.m2504i(17116);
            C19974a Fk = C19973k.m30871Fk(str);
            if (Fk == null) {
                AppMethodBeat.m2505o(17116);
                return null;
            }
            String str2 = Fk.jvN;
            AppMethodBeat.m2505o(17116);
            return str2;
        }

        /* renamed from: a */
        public static String m30842a(C7620bi c7620bi, C40522gu c40522gu) {
            AppMethodBeat.m2504i(17117);
            EmojiInfo aqi = C38658d.aUr().aUs().aUp().aqi(c7620bi.field_imgPath);
            if (aqi == null) {
                AppMethodBeat.m2505o(17117);
                return null;
            }
            C19974a Fl = C19973k.m30872Fl(aqi.mo20410Aq());
            if (Fl == null) {
                Fl = new C19974a(aqi.mo20410Aq(), aqi.mo20410Aq(), aqi.mo20410Aq(), aqi.mo20410Aq());
            }
            StringWriter stringWriter = new StringWriter();
            String bc;
            try {
                XmlSerializer newSerializer = XmlPullParserFactory.newInstance().newSerializer();
                newSerializer.setOutput(stringWriter);
                newSerializer.startDocument("UTF-8", Boolean.TRUE);
                newSerializer.startTag(null, "msg");
                newSerializer.startTag(null, "emoji");
                newSerializer.attribute(null, "fromusername", c40522gu.vEB.wVI);
                newSerializer.attribute(null, "tousername", c40522gu.vEC.wVI);
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
                if (aqi.mo48552xy()) {
                    newSerializer.startTag(null, "gameext");
                    Map z = C5049br.m7595z(aqi.getContent(), "gameext");
                    String bc2 = C5046bo.m7532bc((String) z.get(".gameext.$type"), "");
                    bc = C5046bo.m7532bc((String) z.get(".gameext.$content"), "");
                    if (bc2.equals("") || bc.equals("")) {
                        stringWriter.close();
                        bc = "";
                        AppMethodBeat.m2505o(17117);
                        return bc;
                    }
                    newSerializer.attribute(null, "type", String.valueOf(bc2));
                    newSerializer.attribute(null, C8741b.CONTENT, String.valueOf(bc));
                    newSerializer.endTag(null, "gameext");
                }
                newSerializer.endTag(null, "msg");
                newSerializer.endDocument();
                stringWriter.flush();
                stringWriter.close();
                bc = stringWriter.getBuffer().toString();
                try {
                    bc = bc.substring(bc.indexOf(jrk), bc.indexOf(jrl) + jrl.length());
                    C4990ab.m7410d("MicroMsg.BackupUtil.EmojiConvert", "xml ".concat(String.valueOf(bc)));
                    AppMethodBeat.m2505o(17117);
                    return bc;
                } catch (Exception e) {
                    bc = "";
                    AppMethodBeat.m2505o(17117);
                    return bc;
                }
            } catch (XmlPullParserException e2) {
                C4990ab.printErrStackTrace("MicroMsg.BackupUtil.EmojiConvert", e2, "", new Object[0]);
                bc = "";
                AppMethodBeat.m2505o(17117);
                return bc;
            } catch (IllegalArgumentException e3) {
                C4990ab.printErrStackTrace("MicroMsg.BackupUtil.EmojiConvert", e3, "", new Object[0]);
                bc = "";
                AppMethodBeat.m2505o(17117);
                return bc;
            } catch (IllegalStateException e4) {
                C4990ab.printErrStackTrace("MicroMsg.BackupUtil.EmojiConvert", e4, "", new Object[0]);
                bc = "";
                AppMethodBeat.m2505o(17117);
                return bc;
            } catch (IOException e5) {
                C4990ab.printErrStackTrace("MicroMsg.BackupUtil.EmojiConvert", e5, "", new Object[0]);
                bc = "";
                AppMethodBeat.m2505o(17117);
                return bc;
            }
        }
    }

    /* renamed from: a */
    public static <T extends C1331a> T m65510a(T t, byte[] bArr) {
        AppMethodBeat.m2504i(17118);
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.m2505o(17118);
            return null;
        }
        try {
            t.parseFrom(bArr);
            AppMethodBeat.m2505o(17118);
            return t;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.BackupUtil", "ERROR: parseProBuf [%s] [%s]", e.getMessage(), C5046bo.m7574l(e));
            AppMethodBeat.m2505o(17118);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A:{SYNTHETIC, Splitter:B:20:0x006b} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007a A:{SYNTHETIC, Splitter:B:27:0x007a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static void m65514a(String str, C27495x c27495x) {
        Throwable e;
        AppMethodBeat.m2504i(17119);
        RandomAccessFile randomAccessFile = null;
        try {
            C5728b c5728b = new C5728b(str);
            if (!c5728b.exists()) {
                c5728b.mkdirs();
            }
            String str2 = str + c27495x.jCx;
            C5728b c5728b2 = new C5728b(str2);
            if (!c5728b2.exists()) {
                c5728b2.createNewFile();
            }
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(str2, "rw");
            try {
                randomAccessFile2.setLength((long) c27495x.jCz);
                randomAccessFile2.seek((long) c27495x.jCA);
                randomAccessFile2.write(c27495x.jBi.f1226wR);
                try {
                    randomAccessFile2.close();
                    AppMethodBeat.m2505o(17119);
                } catch (Exception e2) {
                    AppMethodBeat.m2505o(17119);
                }
            } catch (Exception e3) {
                e = e3;
                randomAccessFile = randomAccessFile2;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.BackupUtil", e, "writeMediaToFile fail with exception", new Object[0]);
                    if (randomAccessFile != null) {
                    }
                    AppMethodBeat.m2505o(17119);
                } catch (Throwable th) {
                    e = th;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e4) {
                        }
                    }
                    AppMethodBeat.m2505o(17119);
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                }
                AppMethodBeat.m2505o(17119);
                throw e;
            }
        } catch (Exception e5) {
            e = e5;
            C4990ab.printErrStackTrace("MicroMsg.BackupUtil", e, "writeMediaToFile fail with exception", new Object[0]);
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (Exception e6) {
                    AppMethodBeat.m2505o(17119);
                    return;
                }
            }
            AppMethodBeat.m2505o(17119);
        }
    }

    /* renamed from: EY */
    public static long m65501EY(String str) {
        boolean z = false;
        AppMethodBeat.m2504i(17120);
        C5728b c5728b = new C5728b(str);
        if (!c5728b.exists()) {
            AppMethodBeat.m2505o(17120);
            return -1;
        } else if (c5728b.canRead()) {
            C5718d dMA = c5728b.dMA();
            if (dMA.valid()) {
                FileSystem fileSystem = dMA.zZs;
                if ((fileSystem.aiR() & 1) != 0) {
                    String O = fileSystem.mo11610O(dMA.path, true);
                    z = O != null ? new File(O).canWrite() : fileSystem.exists(dMA.path);
                }
            }
            if (z) {
                long length = c5728b.length();
                AppMethodBeat.m2505o(17120);
                return length;
            }
            AppMethodBeat.m2505o(17120);
            return -3;
        } else {
            AppMethodBeat.m2505o(17120);
            return -2;
        }
    }

    /* renamed from: b */
    public static void m65518b(String str, C27495x c27495x) {
        AppMethodBeat.m2504i(17121);
        if (TextUtils.isEmpty(str) || c27495x == null) {
            C4990ab.m7413e("MicroMsg.BackupUtil", "appendFile dir:%s req:%s ", str, c27495x);
            AppMethodBeat.m2505o(17121);
        } else if (TextUtils.isEmpty(c27495x.jCx) || c27495x.jBi == null || C5046bo.m7541cc(c27495x.jBi.f1226wR) <= 0) {
            String str2;
            String str3 = "MicroMsg.BackupUtil";
            String str4 = "appendFile dataid:%s data:%s  %s";
            Object[] objArr = new Object[3];
            objArr[0] = c27495x.jCx;
            objArr[1] = c27495x.jBi;
            if (c27495x.jBi == null) {
                str2 = BuildConfig.COMMAND;
            } else {
                str2 = Integer.valueOf(C5046bo.m7541cc(c27495x.jBi.f1226wR));
            }
            objArr[2] = str2;
            C4990ab.m7413e(str3, str4, objArr);
            AppMethodBeat.m2505o(17121);
        } else {
            int i = 3;
            while (true) {
                int i2 = i - 1;
                if (i > 0) {
                    long EY = C38635g.m65501EY(str + c27495x.jCx);
                    i = C38635g.m65523c(str, c27495x);
                    long EY2 = C38635g.m65501EY(str + c27495x.jCx);
                    if (i != 0 || EY2 < ((long) c27495x.jBi.f1226wR.length)) {
                        C4990ab.m7413e("MicroMsg.BackupUtil", "appendFile retry:%d append:%d  old:%d  new:%d  data:%d", Integer.valueOf(i2), Integer.valueOf(i), Long.valueOf(EY), Long.valueOf(EY2), Integer.valueOf(c27495x.jBi.f1226wR.length));
                        i = i2;
                    } else {
                        AppMethodBeat.m2505o(17121);
                        return;
                    }
                }
                AppMethodBeat.m2505o(17121);
                return;
            }
        }
    }

    /* renamed from: c */
    private static int m65523c(String str, C27495x c27495x) {
        AppMethodBeat.m2504i(17122);
        try {
            C5728b c5728b = new C5728b(str);
            if (!c5728b.exists()) {
                c5728b.mkdirs();
            }
            String str2 = str + "/" + c27495x.jCx;
            C5728b c5728b2 = new C5728b(str2);
            if (!c5728b2.exists()) {
                c5728b2.createNewFile();
            }
            byte[] bArr = c27495x.jBi.f1226wR;
            int a = C5730e.m8619a(str2, bArr, bArr.length);
            AppMethodBeat.m2505o(17122);
            return a;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BackupUtil", e, "", new Object[0]);
            AppMethodBeat.m2505o(17122);
            return -1;
        }
    }

    /* renamed from: b */
    public static int m65516b(String str, String str2, byte[] bArr) {
        AppMethodBeat.m2504i(17123);
        try {
            C5728b c5728b = new C5728b(str);
            if (!c5728b.exists()) {
                c5728b.mkdirs();
            }
            String str3 = str + "/" + str2;
            C5728b c5728b2 = new C5728b(str3);
            if (!c5728b2.exists()) {
                c5728b2.createNewFile();
            }
            int a = C5730e.m8619a(str3, bArr, bArr.length);
            AppMethodBeat.m2505o(17123);
            return a;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.BackupUtil", e, "", new Object[0]);
            AppMethodBeat.m2505o(17123);
            return -1;
        }
    }

    /* renamed from: ds */
    public static String m65526ds(Context context) {
        AppMethodBeat.m2504i(17124);
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        String gE;
        if (wifiManager.getWifiState() == 3) {
            try {
                gE = C5023at.m7474gE(context);
                if (C5046bo.isNullOrNil(gE)) {
                    gE = "wifi";
                }
                if (gE.length() >= 2 && gE.startsWith("\"") && gE.endsWith("\"")) {
                    gE = gE.substring(1, gE.length() - 1);
                }
                AppMethodBeat.m2505o(17124);
                return gE;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.BackupUtil", "getConnectionInfo %s", e);
                C4990ab.printErrStackTrace("MicroMsg.BackupUtil", e, "", new Object[0]);
                gE = "";
                AppMethodBeat.m2505o(17124);
                return gE;
            }
        }
        int intValue;
        int i = 13;
        try {
            i = ((Integer) wifiManager.getClass().getField("WIFI_AP_STATE_ENABLED").get(wifiManager)).intValue();
            intValue = ((Integer) wifiManager.getClass().getMethod("getWifiApState", new Class[0]).invoke(wifiManager, new Object[0])).intValue();
        } catch (Exception e2) {
            C4990ab.m7413e("MicroMsg.BackupUtil", "getWifiApState %s", e2);
            C4990ab.printErrStackTrace("MicroMsg.BackupUtil", e2, "", new Object[0]);
            intValue = 0;
        }
        if (intValue == i) {
            C4990ab.m7416i("MicroMsg.BackupUtil", "getWifiName apmode");
            try {
                gE = ((WifiConfiguration) wifiManager.getClass().getMethod("getWifiApConfiguration", new Class[0]).invoke(wifiManager, new Object[0])).SSID;
                AppMethodBeat.m2505o(17124);
                return gE;
            } catch (Exception e3) {
                C4990ab.m7413e("MicroMsg.BackupUtil", "getWifiApConfiguration %s", e3);
                C4990ab.printErrStackTrace("MicroMsg.BackupUtil", e3, "", new Object[0]);
            }
        }
        gE = "";
        AppMethodBeat.m2505o(17124);
        return gE;
    }

    public static String aSF() {
        AppMethodBeat.m2504i(17125);
        StringBuilder stringBuilder = new StringBuilder();
        C9638aw.m17190ZK();
        String stringBuilder2 = stringBuilder.append(C18628c.getAccPath()).append("backupRecover/").toString();
        AppMethodBeat.m2505o(17125);
        return stringBuilder2;
    }

    /* renamed from: EZ */
    public static String m65502EZ(String str) {
        AppMethodBeat.m2504i(17126);
        String str2;
        if (str == null || str.equals("")) {
            str2 = "";
            AppMethodBeat.m2505o(17126);
            return str2;
        }
        str2 = C38635g.aSF() + "backupItem/" + C38635g.m65504Fb(str);
        AppMethodBeat.m2505o(17126);
        return str2;
    }

    /* renamed from: Fa */
    public static String m65503Fa(String str) {
        AppMethodBeat.m2504i(17127);
        String str2;
        if (str == null || str.equals("")) {
            str2 = "";
            AppMethodBeat.m2505o(17127);
            return str2;
        }
        str2 = C38635g.aSF() + "backupMeida/" + C38635g.m65504Fb(str);
        AppMethodBeat.m2505o(17127);
        return str2;
    }

    /* renamed from: Fb */
    private static String m65504Fb(String str) {
        AppMethodBeat.m2504i(17128);
        String str2;
        if (str == null) {
            str2 = "";
            AppMethodBeat.m2505o(17128);
            return str2;
        }
        String x = C1178g.m2591x(str.getBytes());
        str2 = "";
        String str3 = "";
        if (x.length() > 0) {
            str2 = x.charAt(0) + "/";
        }
        if (x.length() >= 2) {
            str3 = x.charAt(1) + "/";
        }
        str2 = str2 + str3;
        AppMethodBeat.m2505o(17128);
        return str2;
    }

    public static int aSG() {
        AppMethodBeat.m2504i(17129);
        Intent registerReceiver = C4996ah.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            AppMethodBeat.m2505o(17129);
            return 100;
        }
        boolean z;
        int intExtra = registerReceiver.getIntExtra("status", -1);
        if (intExtra == 2 || intExtra == 5) {
            z = true;
        } else {
            z = false;
        }
        C4990ab.m7417i("MicroMsg.BackupUtil", "checkBatteryLevel, battery isCharging[%b]", Boolean.valueOf(z));
        if (z) {
            AppMethodBeat.m2505o(17129);
            return 100;
        }
        intExtra = registerReceiver.getIntExtra("level", -1);
        int intExtra2 = registerReceiver.getIntExtra(WMElement.ANIMATE_TYPE_SCALE, -1);
        if (intExtra < 0 || intExtra2 <= 0) {
            intExtra = 100;
        } else {
            intExtra = (intExtra * 100) / intExtra2;
        }
        C4990ab.m7417i("MicroMsg.BackupUtil", "checkBatteryLevel, battery level remaining[%d]", Integer.valueOf(intExtra));
        AppMethodBeat.m2505o(17129);
        return intExtra;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x00f6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Fc */
    public static boolean m65505Fc(String str) {
        int ipAddress;
        int intValue;
        Throwable e;
        AppMethodBeat.m2504i(17130);
        String[] split = str.split("\\.");
        int A = C37432o.m63090A(new byte[]{(byte) (C5046bo.getInt(split[0], 0) & 255), (byte) (C5046bo.getInt(split[1], 0) & 255), (byte) (C5046bo.getInt(split[2], 0) & 255), (byte) (C5046bo.getInt(split[3], 0) & 255)});
        int A2 = C37432o.m63090A(new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) 0});
        WifiManager wifiManager = (WifiManager) C4996ah.getContext().getSystemService("wifi");
        if (wifiManager.getWifiState() == 3) {
            ipAddress = wifiManager.getConnectionInfo().getIpAddress();
            String str2 = (ipAddress & 255) + "." + ((ipAddress >> 8) & 255) + "." + ((ipAddress >> 16) & 255) + "." + ((ipAddress >> 24) & 255);
            C4990ab.m7417i("MicroMsg.BackupUtil", "oldIpStr:%s, localIp:%s", str, str2);
            if ((A2 & A) == (ipAddress & A2)) {
                AppMethodBeat.m2505o(17130);
                return true;
            }
            AppMethodBeat.m2505o(17130);
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
            C4990ab.m7416i("MicroMsg.BackupUtil", "matchip in apmode");
            boolean dz = C38635g.m65527dz(A2, A);
            AppMethodBeat.m2505o(17130);
            return dz;
        }
        C4990ab.m7417i("MicroMsg.BackupUtil", "apState:%d", Integer.valueOf(ipAddress));
        AppMethodBeat.m2505o(17130);
        return false;
        C4990ab.m7413e("MicroMsg.BackupUtil", "getWifiApState %s", e);
        C4990ab.printErrStackTrace("MicroMsg.BackupUtil", e, "", new Object[0]);
        ipAddress = 0;
        if (ipAddress != intValue) {
        }
    }

    /* renamed from: dz */
    private static boolean m65527dz(int i, int i2) {
        AppMethodBeat.m2504i(17131);
        try {
            for (NetworkInterface inetAddresses : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                for (InetAddress inetAddress : Collections.list(inetAddresses.getInetAddresses())) {
                    if (!inetAddress.isLoopbackAddress()) {
                        String toUpperCase = inetAddress.getHostAddress().toUpperCase();
                        C4990ab.m7417i("MicroMsg.BackupUtil", "check ip:%s, isIPv4:%b", toUpperCase, Boolean.valueOf(InetAddressUtils.isIPv4Address(toUpperCase)));
                        if (InetAddressUtils.isIPv4Address(toUpperCase)) {
                            String[] split = toUpperCase.split("\\.");
                            if ((i & i2) == (C37432o.m63090A(new byte[]{(byte) (C5046bo.getInt(split[0], 0) & 255), (byte) (C5046bo.getInt(split[1], 0) & 255), (byte) (C5046bo.getInt(split[2], 0) & 255), (byte) (C5046bo.getInt(split[3], 0) & 255)}) & i)) {
                                AppMethodBeat.m2505o(17131);
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
        AppMethodBeat.m2505o(17131);
        return false;
    }

    /* renamed from: Fd */
    public static boolean m65506Fd(String str) {
        AppMethodBeat.m2504i(17132);
        if (str == null) {
            AppMethodBeat.m2505o(17132);
            return false;
        }
        int indexOf = str.indexOf(60);
        if (indexOf > 0) {
            str = str.substring(indexOf);
        }
        if (C5049br.m7595z(str, "msg") != null) {
            AppMethodBeat.m2505o(17132);
            return true;
        }
        AppMethodBeat.m2505o(17132);
        return false;
    }

    /* renamed from: a */
    public static String m65511a(C40522gu c40522gu, int i) {
        AppMethodBeat.m2504i(17133);
        String a = C38635g.m65512a(c40522gu, i, null);
        AppMethodBeat.m2505o(17133);
        return a;
    }

    /* JADX WARNING: Missing block: B:20:0x0073, code skipped:
            if (com.tencent.p177mm.vfs.C5730e.m8628ct(com.tencent.p177mm.plugin.backup.p342b.C38635g.m65503Fa(r0) + r0) == false) goto L_0x0079;
     */
    /* JADX WARNING: Missing block: B:21:0x0075, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(17134);
     */
    /* JADX WARNING: Missing block: B:22:0x0079, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(17134);
     */
    /* JADX WARNING: Missing block: B:32:?, code skipped:
            return r0;
     */
    /* JADX WARNING: Missing block: B:33:?, code skipped:
            return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static String m65512a(C40522gu c40522gu, int i, String str) {
        AppMethodBeat.m2504i(17134);
        String str2;
        if (c40522gu.vJf != i || c40522gu.vJd == null) {
            int i2 = 0;
            if (c40522gu.vJc != null && c40522gu.vJb != null) {
                Iterator it = c40522gu.vJc.iterator();
                while (true) {
                    int i3 = i2;
                    if (!it.hasNext()) {
                        break;
                    } else if (((btt) it.next()).wVK == i) {
                        str2 = ((bts) c40522gu.vJb.get(i3)).wVI;
                        if (!C5046bo.isNullOrNil(str) && !str2.endsWith(str)) {
                            i2 = (i3 + 1) + 1;
                        }
                    } else {
                        i2 = i3 + 1;
                    }
                }
            }
            AppMethodBeat.m2505o(17134);
            return null;
        }
        str2 = C1178g.m2591x(c40522gu.vJd.getBuffer().f1226wR);
        AppMethodBeat.m2505o(17134);
        return str2;
    }

    /* renamed from: bC */
    public static int m65521bC(String str, int i) {
        AppMethodBeat.m2504i(17135);
        if (!C5046bo.isNullOrNil(str)) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.BackupUtil", e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(17135);
        return i;
    }

    /* renamed from: Fe */
    public static long m65507Fe(String str) {
        AppMethodBeat.m2504i(17136);
        long j = 0;
        if (!C5046bo.isNullOrNil(str)) {
            try {
                j = Long.valueOf(str).longValue();
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.BackupUtil", e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(17136);
        return j;
    }

    /* renamed from: b */
    public static boolean m65519b(C40522gu c40522gu, int i, String str) {
        AppMethodBeat.m2504i(17137);
        if (c40522gu.vJf == i) {
            byte[] bArr = c40522gu.vJd.getBuffer().f1226wR;
            if (bArr.length <= 0) {
                AppMethodBeat.m2505o(17137);
                return false;
            }
            C5730e.m8624b(str, bArr, bArr.length);
            AppMethodBeat.m2505o(17137);
            return true;
        }
        String a = C38635g.m65512a(c40522gu, i, null);
        if (C5046bo.isNullOrNil(a)) {
            AppMethodBeat.m2505o(17137);
            return false;
        }
        C5730e.m8644y(C38635g.m65503Fa(a) + a, str);
        AppMethodBeat.m2505o(17137);
        return true;
    }

    /* renamed from: b */
    public static byte[] m65520b(C40522gu c40522gu, int i) {
        AppMethodBeat.m2504i(17138);
        byte[] e;
        if (c40522gu.vJf != i || c40522gu.vJd == null) {
            if (!(c40522gu.vJc == null || c40522gu.vJb == null)) {
                Iterator it = c40522gu.vJc.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    if (((btt) it.next()).wVK == i) {
                        String str = ((bts) c40522gu.vJb.get(i2)).wVI;
                        str = C38635g.m65503Fa(str) + str;
                        i2 = (int) C5730e.asZ(str);
                        if (i2 == 0 || i2 > 1048576) {
                            C4990ab.m7412e("MicroMsg.BackupUtil", "thumb not exist or  too big!");
                            AppMethodBeat.m2505o(17138);
                            return null;
                        }
                        e = C5730e.m8632e(str, 0, -1);
                        AppMethodBeat.m2505o(17138);
                        return e;
                    }
                    i2++;
                }
            }
            AppMethodBeat.m2505o(17138);
            return null;
        }
        e = c40522gu.vJd.getBuffer().f1226wR;
        AppMethodBeat.m2505o(17138);
        return e;
    }

    /* renamed from: c */
    public static int m65522c(C40522gu c40522gu, int i) {
        AppMethodBeat.m2504i(17139);
        int asZ;
        if (c40522gu.vJf != i) {
            if (!(c40522gu.vJc == null || c40522gu.vJb == null)) {
                Iterator it = c40522gu.vJc.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    if (((btt) it.next()).wVK == i) {
                        String str = ((bts) c40522gu.vJb.get(i2)).wVI;
                        asZ = (int) C5730e.asZ(C38635g.m65503Fa(str) + str);
                        AppMethodBeat.m2505o(17139);
                        return asZ;
                    }
                    i2++;
                }
            }
            AppMethodBeat.m2505o(17139);
            return 0;
        } else if (c40522gu.vJd == null) {
            AppMethodBeat.m2505o(17139);
            return 0;
        } else {
            asZ = c40522gu.vJd.getBuffer().f1226wR.length;
            AppMethodBeat.m2505o(17139);
            return asZ;
        }
    }

    /* renamed from: d */
    public static boolean m65525d(C40522gu c40522gu, int i) {
        AppMethodBeat.m2504i(17140);
        if (c40522gu.vJf != i || c40522gu.vJd == null) {
            Iterator it = c40522gu.vJc.iterator();
            while (it.hasNext()) {
                if (((btt) it.next()).wVK == i) {
                    AppMethodBeat.m2505o(17140);
                    return true;
                }
            }
            AppMethodBeat.m2505o(17140);
            return false;
        }
        AppMethodBeat.m2505o(17140);
        return true;
    }

    /* renamed from: Ko */
    public static List<String> m65509Ko() {
        AppMethodBeat.m2504i(17141);
        if (elZ != null) {
            List list = elZ;
            AppMethodBeat.m2505o(17141);
            return list;
        }
        elZ = new LinkedList();
        for (Object add : C1855t.fkY) {
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
        AppMethodBeat.m2505o(17141);
        return list2;
    }

    /* renamed from: a */
    public static boolean m65515a(PLong pLong, PLong pLong2, String str) {
        AppMethodBeat.m2504i(17142);
        StatFs statFs = new StatFs(C1448h.getExternalStorageDirectory().getPath());
        pLong.value = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        File dataDirectory = C1448h.getDataDirectory();
        statFs = new StatFs(dataDirectory.getPath());
        long blockCount = (long) statFs.getBlockCount();
        long availableBlocks = (long) statFs.getAvailableBlocks();
        pLong2.value = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        C4990ab.m7417i("MicroMsg.BackupUtil", "checkDataFull, SDAvailSize:%d, DataAvailSize%d, dbSize:%d", Long.valueOf(pLong.value), Long.valueOf(pLong2.value), Long.valueOf(0));
        if (blockCount <= 0) {
            AppMethodBeat.m2505o(17142);
            return false;
        } else if (blockCount - availableBlocks < 0) {
            AppMethodBeat.m2505o(17142);
            return false;
        } else {
            if (pLong.value == pLong2.value || str.startsWith(dataDirectory.getPath())) {
                pLong.value = 0;
            }
            if (0 > pLong2.value) {
                AppMethodBeat.m2505o(17142);
                return false;
            }
            AppMethodBeat.m2505o(17142);
            return true;
        }
    }

    /* renamed from: Ff */
    public static long m65508Ff(String str) {
        AppMethodBeat.m2504i(17143);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        long anU = C5046bo.anU();
        try {
            anU = simpleDateFormat.parse(str).getTime();
        } catch (ParseException e) {
            C4990ab.m7413e("MicroMsg.BackupUtil", "dateToTimeStamp failed. date:%s, stack:%s", str, C5046bo.dpG());
        }
        AppMethodBeat.m2505o(17143);
        return anU;
    }

    /* renamed from: A */
    public static LinkedList<String> m65500A(LinkedList<C27443b> linkedList) {
        AppMethodBeat.m2504i(17144);
        LinkedList linkedList2 = new LinkedList();
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                linkedList2.add(((C27443b) it.next()).jrf);
            }
        }
        AppMethodBeat.m2505o(17144);
        return linkedList2;
    }

    /* renamed from: a */
    public static String m65513a(String str, String str2, String... strArr) {
        AppMethodBeat.m2504i(17145);
        if (strArr == null || strArr.length == 0) {
            AppMethodBeat.m2505o(17145);
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
        AppMethodBeat.m2505o(17145);
        return str;
    }

    /* renamed from: cX */
    public static String[] m65524cX(String str, String str2) {
        AppMethodBeat.m2504i(17146);
        String[] split = str.split(str2);
        AppMethodBeat.m2505o(17146);
        return split;
    }

    /* renamed from: gw */
    public static C19990m m65528gw(long j) {
        AppMethodBeat.m2504i(17147);
        C19990m c19990m = new C19990m();
        String deviceID = C1427q.getDeviceID(C4996ah.getContext());
        if (deviceID == null) {
            deviceID = C1427q.m3028LM();
        }
        c19990m.jBE = deviceID;
        c19990m.jBF = Build.MANUFACTURER;
        c19990m.jBG = Build.MODEL;
        c19990m.jBH = "Android";
        c19990m.jBI = VERSION.RELEASE;
        c19990m.jBJ = C7243d.vxo;
        c19990m.jBK = j;
        C4990ab.m7417i("MicroMsg.BackupUtil", "getBackupStartGeneralInfo WechatVersion[%s], freespace[%d], deviceId[%s]", Integer.valueOf(C7243d.vxo), Long.valueOf(j), c19990m.jBE);
        AppMethodBeat.m2505o(17147);
        return c19990m;
    }

    /* renamed from: b */
    public static LinkedList<C19940a> m65517b(LinkedList<String> linkedList, LinkedList<Long> linkedList2) {
        AppMethodBeat.m2504i(17148);
        if (linkedList == null || linkedList2 == null || linkedList.isEmpty() || linkedList.size() * 2 != linkedList2.size()) {
            AppMethodBeat.m2505o(17148);
            return null;
        }
        LinkedList<C19940a> linkedList3 = new LinkedList();
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
            linkedList3.add(new C19940a(size, str, j2, j));
        }
        AppMethodBeat.m2505o(17148);
        return linkedList3;
    }
}
