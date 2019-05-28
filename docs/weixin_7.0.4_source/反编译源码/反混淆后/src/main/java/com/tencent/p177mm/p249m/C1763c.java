package com.tencent.p177mm.p249m;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C5128ac;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.m.c */
public final class C1763c {
    public static final String evW = (C5128ac.eSj + "configlist/");
    public SparseArray<C1766d> evV = new SparseArray();

    public C1763c() {
        AppMethodBeat.m2504i(57849);
        AppMethodBeat.m2505o(57849);
    }

    static {
        AppMethodBeat.m2504i(57865);
        AppMethodBeat.m2505o(57865);
    }

    /* renamed from: iY */
    public static String m3628iY(int i) {
        AppMethodBeat.m2504i(57850);
        String str = evW + "config_" + i + ".xml";
        AppMethodBeat.m2505o(57850);
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0078 A:{SYNTHETIC, Splitter:B:30:0x0078} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007d A:{SYNTHETIC, Splitter:B:33:0x007d} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e6 A:{SYNTHETIC, Splitter:B:54:0x00e6} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00eb A:{SYNTHETIC, Splitter:B:57:0x00eb} */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0078 A:{SYNTHETIC, Splitter:B:30:0x0078} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007d A:{SYNTHETIC, Splitter:B:33:0x007d} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e6 A:{SYNTHETIC, Splitter:B:54:0x00e6} */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00eb A:{SYNTHETIC, Splitter:B:57:0x00eb} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: d */
    public final boolean mo5302d(File file, File file2) {
        InputStream fileInputStream;
        OutputStream fileOutputStream;
        Throwable e;
        boolean z = false;
        AppMethodBeat.m2504i(57851);
        if (!file.exists()) {
            AppMethodBeat.m2505o(57851);
            return false;
        } else if (file.isDirectory()) {
            if (!file2.exists()) {
                file2.mkdir();
            }
            File[] listFiles = file.listFiles();
            int i = 0;
            while (true) {
                boolean z2 = z;
                if (i < listFiles.length) {
                    File file3 = listFiles[i];
                    z = mo5302d(file3, new File(file2.getPath(), file3.getName()));
                    if (z) {
                        file.delete();
                    }
                    i++;
                } else {
                    AppMethodBeat.m2505o(57851);
                    return z2;
                }
            }
        } else {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Exception e2) {
                    e = e2;
                    fileOutputStream = null;
                    try {
                        C4990ab.m7413e("MicroMsg.ConfigListDecoder", "exception:%s", C5046bo.m7574l(e));
                        if (fileInputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        AppMethodBeat.m2505o(57851);
                        return false;
                    } catch (Throwable th) {
                        e = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e3) {
                                C4990ab.m7413e("MicroMsg.ConfigListDecoder", "exception:%s", C5046bo.m7574l(e3));
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e4) {
                                C4990ab.m7413e("MicroMsg.ConfigListDecoder", "exception:%s", C5046bo.m7574l(e4));
                            }
                        }
                        AppMethodBeat.m2505o(57851);
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    fileOutputStream = null;
                    if (fileInputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    AppMethodBeat.m2505o(57851);
                    throw e;
                }
                try {
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    file.delete();
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                        C4990ab.m7413e("MicroMsg.ConfigListDecoder", "exception:%s", C5046bo.m7574l(e5));
                    }
                    try {
                        fileOutputStream.close();
                    } catch (IOException e52) {
                        C4990ab.m7413e("MicroMsg.ConfigListDecoder", "exception:%s", C5046bo.m7574l(e52));
                    }
                    AppMethodBeat.m2505o(57851);
                    return true;
                } catch (Exception e6) {
                    e = e6;
                    C4990ab.m7413e("MicroMsg.ConfigListDecoder", "exception:%s", C5046bo.m7574l(e));
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e522) {
                            C4990ab.m7413e("MicroMsg.ConfigListDecoder", "exception:%s", C5046bo.m7574l(e522));
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5222) {
                            C4990ab.m7413e("MicroMsg.ConfigListDecoder", "exception:%s", C5046bo.m7574l(e5222));
                        }
                    }
                    AppMethodBeat.m2505o(57851);
                    return false;
                }
            } catch (Exception e7) {
                e = e7;
                fileOutputStream = null;
                fileInputStream = null;
                C4990ab.m7413e("MicroMsg.ConfigListDecoder", "exception:%s", C5046bo.m7574l(e));
                if (fileInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                AppMethodBeat.m2505o(57851);
                return false;
            } catch (Throwable th3) {
                e = th3;
                fileOutputStream = null;
                fileInputStream = null;
                if (fileInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                AppMethodBeat.m2505o(57851);
                throw e;
            }
        }
    }

    public final void init() {
        AppMethodBeat.m2504i(57852);
        for (int load : C1766d.evX) {
            load(load);
        }
        AppMethodBeat.m2505o(57852);
    }

    /* renamed from: o */
    public final void mo5305o(int i, String str) {
        AppMethodBeat.m2504i(57853);
        C1766d c1766d = new C1766d(i);
        c1766d.evZ = C5049br.m7595z(str, "ConfigList");
        if (c1766d.evZ.containsKey(".ConfigList.$version")) {
            c1766d.version = Integer.valueOf((String) c1766d.evZ.get(".ConfigList.$version")).intValue();
        }
        int i2 = 0;
        while (true) {
            String str2 = ".ConfigList.Config" + (i2 == 0 ? "" : Integer.valueOf(i2));
            if (c1766d.evZ.get(str2 + ".$name") != null) {
                String str3 = (String) c1766d.evZ.get(str2 + ".$name");
                if (!str3.equalsIgnoreCase("JDWebViewMenu")) {
                    int i3 = 0;
                    while (true) {
                        String str4 = str2 + ".Item" + (i3 == 0 ? "" : Integer.valueOf(i3));
                        String str5 = str2 + ".Item" + (i3 == 0 ? "" : Integer.valueOf(i3)) + ".$key";
                        String str6 = str2 + ".Item" + (i3 == 0 ? "" : Integer.valueOf(i3)) + ".$lang";
                        if (!c1766d.evZ.containsKey(str4)) {
                            break;
                        }
                        String str7 = (String) c1766d.evZ.get(str5);
                        str4 = (String) c1766d.evZ.get(str4);
                        str5 = (String) c1766d.evZ.get(str6);
                        C4990ab.m7410d("MicroMsg.ConfigListInfo", "itemKey " + str7 + " itemValue " + str4 + " itemLang " + str5);
                        if (str5 == null || C1766d.m3641kB(str5)) {
                            if (!c1766d.evY.containsKey(str3)) {
                                c1766d.evY.put(str3, new HashMap());
                            }
                            ((HashMap) c1766d.evY.get(str3)).put(str7, str4);
                        }
                        i3++;
                    }
                }
                i2++;
            } else {
                this.evV.put(i, c1766d);
                AppMethodBeat.m2505o(57853);
                return;
            }
        }
    }

    /* renamed from: O */
    public final String mo5301O(String str, String str2) {
        AppMethodBeat.m2504i(57854);
        C1766d Nf = mo5294Nf();
        if (Nf == null) {
            AppMethodBeat.m2505o(57854);
            return null;
        } else if (Nf.evY.containsKey(str)) {
            String str3 = (String) ((HashMap) Nf.evY.get(str)).get(str2);
            AppMethodBeat.m2505o(57854);
            return str3;
        } else {
            AppMethodBeat.m2505o(57854);
            return null;
        }
    }

    /* renamed from: Nf */
    public final C1766d mo5294Nf() {
        AppMethodBeat.m2504i(57855);
        if (this.evV.get(1) == null) {
            load(1);
        }
        C1766d c1766d = (C1766d) this.evV.get(1);
        AppMethodBeat.m2505o(57855);
        return c1766d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004f A:{SYNTHETIC, Splitter:B:15:0x004f} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009c A:{SYNTHETIC, Splitter:B:31:0x009c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void load(int i) {
        Throwable e;
        AppMethodBeat.m2504i(57856);
        InputStream fileInputStream;
        try {
            File file = new File(C1763c.m3628iY(i));
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, ProtocolPackage.ServerEncoding);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    }
                    mo5305o(i, stringBuffer.toString());
                    inputStreamReader.close();
                    bufferedReader.close();
                } catch (Exception e2) {
                    e = e2;
                    try {
                        C4990ab.m7413e("MicroMsg.ConfigListDecoder", "exception:%s", C5046bo.m7574l(e));
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                AppMethodBeat.m2505o(57856);
                                return;
                            } catch (IOException e3) {
                                C4990ab.m7413e("MicroMsg.ConfigListDecoder", "exception:%s", C5046bo.m7574l(e3));
                                AppMethodBeat.m2505o(57856);
                                return;
                            }
                        }
                        AppMethodBeat.m2505o(57856);
                    } catch (Throwable th) {
                        e = th;
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.m2505o(57856);
                        throw e;
                    }
                }
            }
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                    AppMethodBeat.m2505o(57856);
                    return;
                } catch (IOException e32) {
                    C4990ab.m7413e("MicroMsg.ConfigListDecoder", "exception:%s", C5046bo.m7574l(e32));
                    AppMethodBeat.m2505o(57856);
                    return;
                }
            }
        } catch (Exception e4) {
            e = e4;
            fileInputStream = null;
            C4990ab.m7413e("MicroMsg.ConfigListDecoder", "exception:%s", C5046bo.m7574l(e));
            if (fileInputStream != null) {
            }
            AppMethodBeat.m2505o(57856);
        } catch (Throwable th2) {
            e = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e5) {
                    C4990ab.m7413e("MicroMsg.ConfigListDecoder", "exception:%s", C5046bo.m7574l(e5));
                }
            }
            AppMethodBeat.m2505o(57856);
            throw e;
        }
        AppMethodBeat.m2505o(57856);
    }

    /* renamed from: Ng */
    public static int m3627Ng() {
        int i;
        AppMethodBeat.m2504i(57857);
        String value = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("VoiceVOIPSwitch");
        C4990ab.m7410d("MicroMsg.ConfigListDecoder", "voip is ".concat(String.valueOf(value)));
        try {
            i = C5046bo.getInt(value, 0);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.ConfigListDecoder", "exception:%s", C5046bo.m7574l(e));
            i = 0;
        }
        C4990ab.m7410d("MicroMsg.ConfigListDecoder", "showVoiceVoipEntrance is ".concat(String.valueOf(i)));
        AppMethodBeat.m2505o(57857);
        return i;
    }

    /* renamed from: Nh */
    public final boolean mo5295Nh() {
        boolean z = true;
        AppMethodBeat.m2504i(57858);
        if (C5046bo.getInt(mo5301O("ShowConfig", "hidePoiOversea"), 1) != 1) {
            z = false;
        }
        C4990ab.m7410d("MicroMsg.ConfigListDecoder", "isHidePoiOversea : ".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(57858);
        return z;
    }

    /* renamed from: Ni */
    public final boolean mo5296Ni() {
        boolean z = true;
        AppMethodBeat.m2504i(57859);
        if (C5046bo.getInt(mo5301O("WebViewConfig", "disableWePkg"), 0) != 1) {
            z = false;
        }
        C4990ab.m7410d("MicroMsg.ConfigListDecoder", "disableWePkg : ".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(57859);
        return z;
    }

    /* renamed from: Nj */
    public final String mo5297Nj() {
        AppMethodBeat.m2504i(57860);
        C4990ab.m7411d("MicroMsg.ConfigListDecoder", "get check url for free wifi : %s", mo5301O("FreeWiFiConfig", "CheckURL"));
        AppMethodBeat.m2505o(57860);
        return mo5301O("FreeWiFiConfig", "CheckURL");
    }

    /* renamed from: Nk */
    public final boolean mo5298Nk() {
        boolean z = true;
        AppMethodBeat.m2504i(57861);
        if (C5046bo.getInt(mo5301O("ShowConfig", "showRecvTmpMsgBtn"), 0) != 1) {
            z = false;
        }
        C4990ab.m7410d("MicroMsg.ConfigListDecoder", "isShowRecvTmpMsgBtn : ".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(57861);
        return z;
    }

    /* renamed from: Nl */
    public final List<String> mo5299Nl() {
        AppMethodBeat.m2504i(57862);
        List<String> list = null;
        String O = mo5301O("IBeacon", "Content");
        if (!C5046bo.isNullOrNil(O)) {
            list = new ArrayList();
            try {
                Iterator keys = new JSONObject(O.replace(",}", "}")).keys();
                while (keys.hasNext()) {
                    Object next = keys.next();
                    if (next != null) {
                        list.add(next.toString());
                    }
                }
            } catch (JSONException e) {
                C4990ab.m7412e("MicroMsg.ConfigListDecoder", "[oneliang] json parse exception: " + e.getMessage());
            }
        }
        AppMethodBeat.m2505o(57862);
        return list;
    }

    /* renamed from: Nm */
    public final String mo5300Nm() {
        AppMethodBeat.m2504i(57863);
        String O = mo5301O("MailApp", "MailAppRedirectUrAndroid");
        AppMethodBeat.m2505o(57863);
        return O;
    }

    public final String getMailAppEnterUlAndroid() {
        AppMethodBeat.m2504i(57864);
        String O = mo5301O("MailApp", "MailAppEnterMailAppUrlAndroid");
        AppMethodBeat.m2505o(57864);
        return O;
    }
}
