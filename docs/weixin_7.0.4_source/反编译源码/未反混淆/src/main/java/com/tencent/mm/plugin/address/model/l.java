package com.tencent.mm.plugin.address.model;

import android.content.res.AssetManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.address.d.a;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public final class l {
    private static final Pattern gIU = Pattern.compile("(-|\\s)+");
    public a gIQ = new a();
    public final List<RcptItem> gIR = new ArrayList();
    public final HashMap<String, List<RcptItem>> gIS = new HashMap();
    public final HashMap<String, List<RcptItem>> gIT = new HashMap();
    public String path;

    public l() {
        AppMethodBeat.i(16760);
        AppMethodBeat.o(16760);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0081 A:{SYNTHETIC, Splitter:B:25:0x0081} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d1 A:{Catch:{ Exception -> 0x018c }} */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x017e A:{SYNTHETIC, Splitter:B:67:0x017e} */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0183 A:{Catch:{ Exception -> 0x01e2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0076 A:{SYNTHETIC, Splitter:B:19:0x0076} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007b A:{Catch:{ Exception -> 0x016a }} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0081 A:{SYNTHETIC, Splitter:B:25:0x0081} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d1 A:{Catch:{ Exception -> 0x018c }} */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x021a A:{Splitter:B:25:0x0081, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x021e A:{SYNTHETIC, Splitter:B:100:0x021e} */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0076 A:{SYNTHETIC, Splitter:B:19:0x0076} */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007b A:{Catch:{ Exception -> 0x016a }} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0081 A:{SYNTHETIC, Splitter:B:25:0x0081} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d1 A:{Catch:{ Exception -> 0x018c }} */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x017e A:{SYNTHETIC, Splitter:B:67:0x017e} */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0183 A:{Catch:{ Exception -> 0x01e2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d1 A:{Catch:{ Exception -> 0x018c }} */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01bc  */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:97:0x021a, code skipped:
            r0 = th;
     */
    /* JADX WARNING: Missing block: B:98:0x021b, code skipped:
            r1 = r2;
     */
    /* JADX WARNING: Missing block: B:101:?, code skipped:
            r1.close();
     */
    /* JADX WARNING: Missing block: B:106:0x0227, code skipped:
            r1 = move-exception;
     */
    /* JADX WARNING: Missing block: B:107:0x0228, code skipped:
            com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.WalletAddrMgr", r1, "", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:135:0x02db, code skipped:
            r0 = e;
     */
    /* JADX WARNING: Missing block: B:136:0x02dc, code skipped:
            r1 = r2;
            r3 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void arT() {
        Throwable e;
        int size;
        int i;
        File file;
        AppMethodBeat.i(16761);
        aw.ZK();
        String accPath = c.getAccPath();
        ab.i("MicroMsg.WalletAddrMgr", "load data %s", accPath);
        try {
            BufferedReader bufferedReader;
            String readLine;
            Object obj;
            Object obj2;
            ab.d("MicroMsg.WalletAddrMgr", "initAddressData");
            AssetManager assets = ah.getContext().getAssets();
            BufferedReader bufferedReader2 = null;
            String str = "";
            String str2 = "";
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            FileReader fileReader;
            try {
                fileReader = new FileReader(accPath + "address");
                try {
                    bufferedReader = new BufferedReader(fileReader);
                    try {
                        arrayList.clear();
                        while (true) {
                            readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            arrayList.add(readLine);
                        }
                        try {
                            fileReader.close();
                            bufferedReader.close();
                            z = true;
                        } catch (Exception e2) {
                            ab.printErrStackTrace("MicroMsg.WalletAddrMgr", e2, "", new Object[0]);
                            z = true;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        bufferedReader2 = bufferedReader;
                        try {
                            ab.printErrStackTrace("MicroMsg.WalletAddrMgr", e, "", new Object[0]);
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (Exception e22) {
                                    ab.printErrStackTrace("MicroMsg.WalletAddrMgr", e22, "", new Object[0]);
                                    bufferedReader = bufferedReader2;
                                }
                            }
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            bufferedReader = bufferedReader2;
                            if (!z) {
                            }
                            ab.d("MicroMsg.WalletAddrMgr", "read from addr ".concat(String.valueOf(z)));
                            size = arrayList.size();
                            obj = str2;
                            obj2 = str;
                            while (i < size) {
                            }
                            this.path = accPath + "addrmgr";
                            file = new File(this.path);
                            if (!file.exists()) {
                            }
                            this.gIQ = (a) new a().parseFrom(decrypt(e.e(this.path, 0, -1), arV()));
                            AppMethodBeat.o(16761);
                        } catch (Throwable th) {
                            e = th;
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (Exception e4) {
                                    ab.printErrStackTrace("MicroMsg.WalletAddrMgr", e4, "", new Object[0]);
                                    AppMethodBeat.o(16761);
                                    throw e;
                                }
                            }
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            AppMethodBeat.o(16761);
                            throw e;
                        }
                    } catch (Throwable th2) {
                        e = th2;
                        bufferedReader2 = bufferedReader;
                        if (fileReader != null) {
                        }
                        if (bufferedReader2 != null) {
                        }
                        AppMethodBeat.o(16761);
                        throw e;
                    }
                } catch (IOException e5) {
                    e = e5;
                    ab.printErrStackTrace("MicroMsg.WalletAddrMgr", e, "", new Object[0]);
                    if (fileReader != null) {
                    }
                    if (bufferedReader2 != null) {
                    }
                    bufferedReader = bufferedReader2;
                    if (z) {
                    }
                    ab.d("MicroMsg.WalletAddrMgr", "read from addr ".concat(String.valueOf(z)));
                    size = arrayList.size();
                    obj = str2;
                    obj2 = str;
                    while (i < size) {
                    }
                    this.path = accPath + "addrmgr";
                    file = new File(this.path);
                    if (file.exists()) {
                    }
                    this.gIQ = (a) new a().parseFrom(decrypt(e.e(this.path, 0, -1), arV()));
                    AppMethodBeat.o(16761);
                }
            } catch (IOException e6) {
                e = e6;
                fileReader = null;
                ab.printErrStackTrace("MicroMsg.WalletAddrMgr", e, "", new Object[0]);
                if (fileReader != null) {
                }
                if (bufferedReader2 != null) {
                }
                bufferedReader = bufferedReader2;
                if (z) {
                }
                ab.d("MicroMsg.WalletAddrMgr", "read from addr ".concat(String.valueOf(z)));
                size = arrayList.size();
                obj = str2;
                obj2 = str;
                while (i < size) {
                }
                this.path = accPath + "addrmgr";
                file = new File(this.path);
                if (file.exists()) {
                }
                this.gIQ = (a) new a().parseFrom(decrypt(e.e(this.path, 0, -1), arV()));
                AppMethodBeat.o(16761);
            } catch (Throwable th3) {
                e = th3;
                fileReader = null;
                if (fileReader != null) {
                }
                if (bufferedReader2 != null) {
                }
                AppMethodBeat.o(16761);
                throw e;
            }
            if (z) {
                BufferedReader bufferedReader3;
                try {
                    arrayList.clear();
                    InputStream open = assets.open("address");
                    bufferedReader3 = new BufferedReader(new InputStreamReader(open, ProtocolPackage.ServerEncoding));
                    while (true) {
                        try {
                            readLine = bufferedReader3.readLine();
                            if (readLine == null) {
                                break;
                            }
                            arrayList.add(readLine);
                        } catch (IOException e7) {
                            e = e7;
                            try {
                                ab.printErrStackTrace("MicroMsg.WalletAddrMgr", e, "", new Object[0]);
                                if (bufferedReader3 != null) {
                                    try {
                                        bufferedReader3.close();
                                    } catch (IOException e8) {
                                        ab.printErrStackTrace("MicroMsg.WalletAddrMgr", e8, "", new Object[0]);
                                    }
                                }
                                if (open != null) {
                                }
                                ab.d("MicroMsg.WalletAddrMgr", "read from addr ".concat(String.valueOf(z)));
                                size = arrayList.size();
                                obj = str2;
                                obj2 = str;
                                while (i < size) {
                                }
                                this.path = accPath + "addrmgr";
                                file = new File(this.path);
                                if (file.exists()) {
                                }
                                this.gIQ = (a) new a().parseFrom(decrypt(e.e(this.path, 0, -1), arV()));
                                AppMethodBeat.o(16761);
                            } catch (Throwable th4) {
                                e = th4;
                                if (bufferedReader3 != null) {
                                }
                                AppMethodBeat.o(16761);
                                throw e;
                            }
                        }
                    }
                    bufferedReader3.close();
                    open.close();
                    try {
                        bufferedReader3.close();
                    } catch (IOException e82) {
                        ab.printErrStackTrace("MicroMsg.WalletAddrMgr", e82, "", new Object[0]);
                    }
                    if (open != null) {
                    }
                } catch (IOException e9) {
                    e = e9;
                    bufferedReader3 = bufferedReader;
                } catch (Throwable th5) {
                }
            }
            ab.d("MicroMsg.WalletAddrMgr", "read from addr ".concat(String.valueOf(z)));
            size = arrayList.size();
            obj = str2;
            obj2 = str;
            for (i = 0; i < size; i++) {
                String str3;
                Object rcptItem;
                Object obj3;
                readLine = (String) arrayList.get(i);
                if (i + 1 < size) {
                    str3 = (String) arrayList.get(i + 1);
                } else {
                    str3 = "";
                }
                readLine = readLine.replace("\t", "-").replace("　", "-");
                str2 = str3.replace("\t", "-").replace("　", "-");
                str3 = readLine.substring(0, 6);
                str = readLine.substring(6);
                String[] split = gIU.split("-".concat(String.valueOf(str)));
                if (split.length == 3) {
                    rcptItem = new RcptItem(split[1], str3, split[2]);
                } else {
                    rcptItem = null;
                }
                List list;
                if (rcptItem == null) {
                    ab.w("MicroMsg.WalletAddrMgr", "analyze address data. missing ".concat(String.valueOf(str)));
                    obj3 = obj;
                } else if (str.startsWith("----")) {
                    if (!this.gIT.containsKey(obj)) {
                        this.gIT.put(obj, new ArrayList());
                    }
                    list = (List) this.gIT.get(obj);
                    list.add(rcptItem);
                    this.gIT.put(obj, list);
                    obj3 = obj;
                } else if (str.startsWith("---")) {
                    if (!this.gIS.containsKey(obj2)) {
                        this.gIS.put(obj2, new ArrayList());
                    }
                    list = (List) this.gIS.get(obj2);
                    if (bm(str2, "----")) {
                        rcptItem.gIP = true;
                    }
                    list.add(rcptItem);
                    this.gIS.put(obj2, list);
                    readLine = str3;
                } else if (str.startsWith("-")) {
                    if (bm(str2, "---")) {
                        rcptItem.gIP = true;
                    }
                    this.gIR.add(rcptItem);
                    obj3 = obj;
                    String obj22 = str3;
                } else {
                    obj3 = obj;
                }
                obj = obj3;
            }
        } catch (Exception e222) {
            ab.printErrStackTrace("MicroMsg.WalletAddrMgr", e222, "", new Object[0]);
        }
        this.path = accPath + "addrmgr";
        file = new File(this.path);
        if (file.exists()) {
            file.mkdir();
        }
        try {
            this.gIQ = (a) new a().parseFrom(decrypt(e.e(this.path, 0, -1), arV()));
            AppMethodBeat.o(16761);
        } catch (Exception e2222) {
            ab.printErrStackTrace("MicroMsg.WalletAddrMgr", e2222, "", new Object[0]);
            AppMethodBeat.o(16761);
        }
    }

    public final b ne(int i) {
        AppMethodBeat.i(16762);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.gIQ.gIY.size()) {
                b bVar = (b) this.gIQ.gIY.get(i3);
                if (bVar.id == i) {
                    AppMethodBeat.o(16762);
                    return bVar;
                }
                i2 = i3 + 1;
            } else {
                AppMethodBeat.o(16762);
                return null;
            }
        }
    }

    public final boolean a(b bVar) {
        AppMethodBeat.i(16763);
        if (this.gIQ == null) {
            this.gIQ = new a();
        }
        for (int i = 0; i < this.gIQ.gIY.size(); i++) {
            if (((b) this.gIQ.gIY.get(i)).id == bVar.id) {
                this.gIQ.gIY.remove(i);
                AppMethodBeat.o(16763);
                return true;
            }
        }
        AppMethodBeat.o(16763);
        return false;
    }

    public final boolean s(LinkedList<bpk> linkedList) {
        AppMethodBeat.i(16764);
        this.gIQ.gIY.clear();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bpk bpk = (bpk) it.next();
            b bVar = new b();
            bVar.id = bpk.id;
            bVar.gJh = bpk.wRW.wVI;
            bVar.gJb = bpk.wRQ.wVI;
            bVar.gJe = bpk.wRT.wVI;
            bVar.gJc = bpk.wRR.wVI;
            bVar.gJf = bpk.wRU.wVI;
            bVar.gJg = bpk.wRV.wVI;
            bVar.gJa = bpk.wRP.wVI;
            bVar.gJd = bpk.wRS.wVI;
            this.gIQ.gIY.add(bVar);
        }
        AppMethodBeat.o(16764);
        return true;
    }

    public final void arU() {
        AppMethodBeat.i(16765);
        try {
            byte[] toByteArray = this.gIQ.toByteArray();
            long currentTimeMillis = System.currentTimeMillis();
            toByteArray = encrypt(toByteArray, arV());
            e.deleteFile(this.path);
            e.b(this.path, toByteArray, toByteArray.length);
            ab.d("MicroMsg.WalletAddrMgr", "hakon saveAddr time %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(16765);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.WalletAddrMgr", e, "", new Object[0]);
            AppMethodBeat.o(16765);
        }
    }

    private byte[] arV() {
        AppMethodBeat.i(16766);
        byte[] bytes = g.x(("addrmgr" + this.path).toString().getBytes()).substring(8, 16).getBytes();
        AppMethodBeat.o(16766);
        return bytes;
    }

    private static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        byte[] doFinal;
        AppMethodBeat.i(16767);
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
            Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
            instance.init(1, generateSecret, new IvParameterSpec("12345678".getBytes()));
            doFinal = instance.doFinal(bArr);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.WalletAddrMgr", e, "", new Object[0]);
            doFinal = null;
        }
        AppMethodBeat.o(16767);
        return doFinal;
    }

    private static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        byte[] doFinal;
        AppMethodBeat.i(16768);
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
            Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
            instance.init(2, generateSecret, new IvParameterSpec("12345678".getBytes()));
            doFinal = instance.doFinal(bArr);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.WalletAddrMgr", e, "", new Object[0]);
            doFinal = null;
        }
        AppMethodBeat.o(16768);
        return doFinal;
    }

    public final List<RcptItem> wC(String str) {
        AppMethodBeat.i(16769);
        if (this.gIS.containsKey(str)) {
            List list = (List) this.gIS.get(str);
            AppMethodBeat.o(16769);
            return list;
        }
        List<RcptItem> arrayList = new ArrayList();
        AppMethodBeat.o(16769);
        return arrayList;
    }

    public final List<RcptItem> wD(String str) {
        AppMethodBeat.i(16770);
        if (this.gIT.containsKey(str)) {
            List list = (List) this.gIT.get(str);
            AppMethodBeat.o(16770);
            return list;
        }
        List<RcptItem> arrayList = new ArrayList();
        AppMethodBeat.o(16770);
        return arrayList;
    }

    public final RcptItem wE(String str) {
        AppMethodBeat.i(16771);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(16771);
            return null;
        }
        for (RcptItem rcptItem : this.gIR) {
            if (rcptItem.name.startsWith(str)) {
                AppMethodBeat.o(16771);
                return rcptItem;
            }
        }
        AppMethodBeat.o(16771);
        return null;
    }

    public final RcptItem bl(String str, String str2) {
        AppMethodBeat.i(16772);
        List<RcptItem> wC = wC(str);
        if (wC == null || wC.size() == 0) {
            AppMethodBeat.o(16772);
            return null;
        }
        for (RcptItem rcptItem : wC) {
            if (rcptItem.name.startsWith(str2)) {
                AppMethodBeat.o(16772);
                return rcptItem;
            }
        }
        AppMethodBeat.o(16772);
        return null;
    }

    static {
        AppMethodBeat.i(16777);
        AppMethodBeat.o(16777);
    }

    private static boolean bm(String str, String str2) {
        AppMethodBeat.i(16773);
        if (str.substring(6).startsWith(str2)) {
            AppMethodBeat.o(16773);
            return true;
        }
        AppMethodBeat.o(16773);
        return false;
    }

    public final RcptItem y(String str, String str2, String str3) {
        AppMethodBeat.i(16774);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(16774);
            return null;
        }
        RcptItem e = e(this.gIR, str);
        if (e == null || TextUtils.isEmpty(e.code)) {
            AppMethodBeat.o(16774);
            return null;
        }
        e = e(wC(e.code), str2);
        if (e == null || TextUtils.isEmpty(e.code)) {
            AppMethodBeat.o(16774);
            return null;
        } else if (TextUtils.isEmpty(str3)) {
            AppMethodBeat.o(16774);
            return e;
        } else {
            RcptItem e2 = e(wD(e.code), str3);
            if (e2 == null) {
                AppMethodBeat.o(16774);
                return e;
            }
            AppMethodBeat.o(16774);
            return e2;
        }
    }

    private static RcptItem e(List<RcptItem> list, String str) {
        AppMethodBeat.i(16775);
        if (list == null || list.isEmpty() || TextUtils.isEmpty(str)) {
            AppMethodBeat.o(16775);
            return null;
        }
        RcptItem rcptItem;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                rcptItem = null;
                break;
            }
            rcptItem = (RcptItem) list.get(i2);
            if (rcptItem != null && str.equals(rcptItem.name)) {
                break;
            }
            i = i2 + 1;
        }
        AppMethodBeat.o(16775);
        return rcptItem;
    }

    public final boolean z(String str, String str2, String str3) {
        AppMethodBeat.i(16776);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(16776);
            return false;
        }
        RcptItem e = e(this.gIR, str);
        if (e == null || TextUtils.isEmpty(e.code)) {
            AppMethodBeat.o(16776);
            return false;
        }
        e = e(wC(e.code), str2);
        if (e == null || TextUtils.isEmpty(e.code)) {
            AppMethodBeat.o(16776);
            return false;
        } else if (TextUtils.isEmpty(str3)) {
            AppMethodBeat.o(16776);
            return true;
        } else if (e(wD(e.code), str3) == null) {
            AppMethodBeat.o(16776);
            return false;
        } else {
            AppMethodBeat.o(16776);
            return true;
        }
    }
}
