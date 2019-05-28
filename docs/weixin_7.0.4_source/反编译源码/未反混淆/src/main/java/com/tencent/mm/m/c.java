package com.tencent.mm.m;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac;
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

public final class c {
    public static final String evW = (ac.eSj + "configlist/");
    public SparseArray<d> evV = new SparseArray();

    public c() {
        AppMethodBeat.i(57849);
        AppMethodBeat.o(57849);
    }

    static {
        AppMethodBeat.i(57865);
        AppMethodBeat.o(57865);
    }

    public static String iY(int i) {
        AppMethodBeat.i(57850);
        String str = evW + "config_" + i + ".xml";
        AppMethodBeat.o(57850);
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
    public final boolean d(File file, File file2) {
        InputStream fileInputStream;
        OutputStream fileOutputStream;
        Throwable e;
        boolean z = false;
        AppMethodBeat.i(57851);
        if (!file.exists()) {
            AppMethodBeat.o(57851);
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
                    z = d(file3, new File(file2.getPath(), file3.getName()));
                    if (z) {
                        file.delete();
                    }
                    i++;
                } else {
                    AppMethodBeat.o(57851);
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
                        ab.e("MicroMsg.ConfigListDecoder", "exception:%s", bo.l(e));
                        if (fileInputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                        AppMethodBeat.o(57851);
                        return false;
                    } catch (Throwable th) {
                        e = th;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e3) {
                                ab.e("MicroMsg.ConfigListDecoder", "exception:%s", bo.l(e3));
                            }
                        }
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e4) {
                                ab.e("MicroMsg.ConfigListDecoder", "exception:%s", bo.l(e4));
                            }
                        }
                        AppMethodBeat.o(57851);
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    fileOutputStream = null;
                    if (fileInputStream != null) {
                    }
                    if (fileOutputStream != null) {
                    }
                    AppMethodBeat.o(57851);
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
                        ab.e("MicroMsg.ConfigListDecoder", "exception:%s", bo.l(e5));
                    }
                    try {
                        fileOutputStream.close();
                    } catch (IOException e52) {
                        ab.e("MicroMsg.ConfigListDecoder", "exception:%s", bo.l(e52));
                    }
                    AppMethodBeat.o(57851);
                    return true;
                } catch (Exception e6) {
                    e = e6;
                    ab.e("MicroMsg.ConfigListDecoder", "exception:%s", bo.l(e));
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e522) {
                            ab.e("MicroMsg.ConfigListDecoder", "exception:%s", bo.l(e522));
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e5222) {
                            ab.e("MicroMsg.ConfigListDecoder", "exception:%s", bo.l(e5222));
                        }
                    }
                    AppMethodBeat.o(57851);
                    return false;
                }
            } catch (Exception e7) {
                e = e7;
                fileOutputStream = null;
                fileInputStream = null;
                ab.e("MicroMsg.ConfigListDecoder", "exception:%s", bo.l(e));
                if (fileInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                AppMethodBeat.o(57851);
                return false;
            } catch (Throwable th3) {
                e = th3;
                fileOutputStream = null;
                fileInputStream = null;
                if (fileInputStream != null) {
                }
                if (fileOutputStream != null) {
                }
                AppMethodBeat.o(57851);
                throw e;
            }
        }
    }

    public final void init() {
        AppMethodBeat.i(57852);
        for (int load : d.evX) {
            load(load);
        }
        AppMethodBeat.o(57852);
    }

    public final void o(int i, String str) {
        AppMethodBeat.i(57853);
        d dVar = new d(i);
        dVar.evZ = br.z(str, "ConfigList");
        if (dVar.evZ.containsKey(".ConfigList.$version")) {
            dVar.version = Integer.valueOf((String) dVar.evZ.get(".ConfigList.$version")).intValue();
        }
        int i2 = 0;
        while (true) {
            String str2 = ".ConfigList.Config" + (i2 == 0 ? "" : Integer.valueOf(i2));
            if (dVar.evZ.get(str2 + ".$name") != null) {
                String str3 = (String) dVar.evZ.get(str2 + ".$name");
                if (!str3.equalsIgnoreCase("JDWebViewMenu")) {
                    int i3 = 0;
                    while (true) {
                        String str4 = str2 + ".Item" + (i3 == 0 ? "" : Integer.valueOf(i3));
                        String str5 = str2 + ".Item" + (i3 == 0 ? "" : Integer.valueOf(i3)) + ".$key";
                        String str6 = str2 + ".Item" + (i3 == 0 ? "" : Integer.valueOf(i3)) + ".$lang";
                        if (!dVar.evZ.containsKey(str4)) {
                            break;
                        }
                        String str7 = (String) dVar.evZ.get(str5);
                        str4 = (String) dVar.evZ.get(str4);
                        str5 = (String) dVar.evZ.get(str6);
                        ab.d("MicroMsg.ConfigListInfo", "itemKey " + str7 + " itemValue " + str4 + " itemLang " + str5);
                        if (str5 == null || d.kB(str5)) {
                            if (!dVar.evY.containsKey(str3)) {
                                dVar.evY.put(str3, new HashMap());
                            }
                            ((HashMap) dVar.evY.get(str3)).put(str7, str4);
                        }
                        i3++;
                    }
                }
                i2++;
            } else {
                this.evV.put(i, dVar);
                AppMethodBeat.o(57853);
                return;
            }
        }
    }

    public final String O(String str, String str2) {
        AppMethodBeat.i(57854);
        d Nf = Nf();
        if (Nf == null) {
            AppMethodBeat.o(57854);
            return null;
        } else if (Nf.evY.containsKey(str)) {
            String str3 = (String) ((HashMap) Nf.evY.get(str)).get(str2);
            AppMethodBeat.o(57854);
            return str3;
        } else {
            AppMethodBeat.o(57854);
            return null;
        }
    }

    public final d Nf() {
        AppMethodBeat.i(57855);
        if (this.evV.get(1) == null) {
            load(1);
        }
        d dVar = (d) this.evV.get(1);
        AppMethodBeat.o(57855);
        return dVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x004f A:{SYNTHETIC, Splitter:B:15:0x004f} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009c A:{SYNTHETIC, Splitter:B:31:0x009c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void load(int i) {
        Throwable e;
        AppMethodBeat.i(57856);
        InputStream fileInputStream;
        try {
            File file = new File(iY(i));
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
                    o(i, stringBuffer.toString());
                    inputStreamReader.close();
                    bufferedReader.close();
                } catch (Exception e2) {
                    e = e2;
                    try {
                        ab.e("MicroMsg.ConfigListDecoder", "exception:%s", bo.l(e));
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                                AppMethodBeat.o(57856);
                                return;
                            } catch (IOException e3) {
                                ab.e("MicroMsg.ConfigListDecoder", "exception:%s", bo.l(e3));
                                AppMethodBeat.o(57856);
                                return;
                            }
                        }
                        AppMethodBeat.o(57856);
                    } catch (Throwable th) {
                        e = th;
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.o(57856);
                        throw e;
                    }
                }
            }
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                    AppMethodBeat.o(57856);
                    return;
                } catch (IOException e32) {
                    ab.e("MicroMsg.ConfigListDecoder", "exception:%s", bo.l(e32));
                    AppMethodBeat.o(57856);
                    return;
                }
            }
        } catch (Exception e4) {
            e = e4;
            fileInputStream = null;
            ab.e("MicroMsg.ConfigListDecoder", "exception:%s", bo.l(e));
            if (fileInputStream != null) {
            }
            AppMethodBeat.o(57856);
        } catch (Throwable th2) {
            e = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e5) {
                    ab.e("MicroMsg.ConfigListDecoder", "exception:%s", bo.l(e5));
                }
            }
            AppMethodBeat.o(57856);
            throw e;
        }
        AppMethodBeat.o(57856);
    }

    public static int Ng() {
        int i;
        AppMethodBeat.i(57857);
        String value = ((a) g.K(a.class)).Nu().getValue("VoiceVOIPSwitch");
        ab.d("MicroMsg.ConfigListDecoder", "voip is ".concat(String.valueOf(value)));
        try {
            i = bo.getInt(value, 0);
        } catch (Exception e) {
            ab.e("MicroMsg.ConfigListDecoder", "exception:%s", bo.l(e));
            i = 0;
        }
        ab.d("MicroMsg.ConfigListDecoder", "showVoiceVoipEntrance is ".concat(String.valueOf(i)));
        AppMethodBeat.o(57857);
        return i;
    }

    public final boolean Nh() {
        boolean z = true;
        AppMethodBeat.i(57858);
        if (bo.getInt(O("ShowConfig", "hidePoiOversea"), 1) != 1) {
            z = false;
        }
        ab.d("MicroMsg.ConfigListDecoder", "isHidePoiOversea : ".concat(String.valueOf(z)));
        AppMethodBeat.o(57858);
        return z;
    }

    public final boolean Ni() {
        boolean z = true;
        AppMethodBeat.i(57859);
        if (bo.getInt(O("WebViewConfig", "disableWePkg"), 0) != 1) {
            z = false;
        }
        ab.d("MicroMsg.ConfigListDecoder", "disableWePkg : ".concat(String.valueOf(z)));
        AppMethodBeat.o(57859);
        return z;
    }

    public final String Nj() {
        AppMethodBeat.i(57860);
        ab.d("MicroMsg.ConfigListDecoder", "get check url for free wifi : %s", O("FreeWiFiConfig", "CheckURL"));
        AppMethodBeat.o(57860);
        return O("FreeWiFiConfig", "CheckURL");
    }

    public final boolean Nk() {
        boolean z = true;
        AppMethodBeat.i(57861);
        if (bo.getInt(O("ShowConfig", "showRecvTmpMsgBtn"), 0) != 1) {
            z = false;
        }
        ab.d("MicroMsg.ConfigListDecoder", "isShowRecvTmpMsgBtn : ".concat(String.valueOf(z)));
        AppMethodBeat.o(57861);
        return z;
    }

    public final List<String> Nl() {
        AppMethodBeat.i(57862);
        List<String> list = null;
        String O = O("IBeacon", "Content");
        if (!bo.isNullOrNil(O)) {
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
                ab.e("MicroMsg.ConfigListDecoder", "[oneliang] json parse exception: " + e.getMessage());
            }
        }
        AppMethodBeat.o(57862);
        return list;
    }

    public final String Nm() {
        AppMethodBeat.i(57863);
        String O = O("MailApp", "MailAppRedirectUrAndroid");
        AppMethodBeat.o(57863);
        return O;
    }

    public final String getMailAppEnterUlAndroid() {
        AppMethodBeat.i(57864);
        String O = O("MailApp", "MailAppEnterMailAppUrlAndroid");
        AppMethodBeat.o(57864);
        return O;
    }
}
