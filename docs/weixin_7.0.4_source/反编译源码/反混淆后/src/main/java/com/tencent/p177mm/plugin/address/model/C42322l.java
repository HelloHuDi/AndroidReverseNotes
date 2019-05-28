package com.tencent.p177mm.plugin.address.model;

import android.content.res.AssetManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.plugin.address.p1534d.C38090b;
import com.tencent.p177mm.plugin.address.p1534d.C45505a;
import com.tencent.p177mm.protocal.protobuf.bpk;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
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

/* renamed from: com.tencent.mm.plugin.address.model.l */
public final class C42322l {
    private static final Pattern gIU = Pattern.compile("(-|\\s)+");
    public C45505a gIQ = new C45505a();
    public final List<RcptItem> gIR = new ArrayList();
    public final HashMap<String, List<RcptItem>> gIS = new HashMap();
    public final HashMap<String, List<RcptItem>> gIT = new HashMap();
    public String path;

    public C42322l() {
        AppMethodBeat.m2504i(16760);
        AppMethodBeat.m2505o(16760);
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
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.WalletAddrMgr", r1, "", new java.lang.Object[0]);
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
        AppMethodBeat.m2504i(16761);
        C9638aw.m17190ZK();
        String accPath = C18628c.getAccPath();
        C4990ab.m7417i("MicroMsg.WalletAddrMgr", "load data %s", accPath);
        try {
            BufferedReader bufferedReader;
            String readLine;
            Object obj;
            Object obj2;
            C4990ab.m7410d("MicroMsg.WalletAddrMgr", "initAddressData");
            AssetManager assets = C4996ah.getContext().getAssets();
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
                            C4990ab.printErrStackTrace("MicroMsg.WalletAddrMgr", e2, "", new Object[0]);
                            z = true;
                        }
                    } catch (IOException e3) {
                        e = e3;
                        bufferedReader2 = bufferedReader;
                        try {
                            C4990ab.printErrStackTrace("MicroMsg.WalletAddrMgr", e, "", new Object[0]);
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (Exception e22) {
                                    C4990ab.printErrStackTrace("MicroMsg.WalletAddrMgr", e22, "", new Object[0]);
                                    bufferedReader = bufferedReader2;
                                }
                            }
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            bufferedReader = bufferedReader2;
                            if (!z) {
                            }
                            C4990ab.m7410d("MicroMsg.WalletAddrMgr", "read from addr ".concat(String.valueOf(z)));
                            size = arrayList.size();
                            obj = str2;
                            obj2 = str;
                            while (i < size) {
                            }
                            this.path = accPath + "addrmgr";
                            file = new File(this.path);
                            if (!file.exists()) {
                            }
                            this.gIQ = (C45505a) new C45505a().parseFrom(C42322l.decrypt(C1173e.m2569e(this.path, 0, -1), arV()));
                            AppMethodBeat.m2505o(16761);
                        } catch (Throwable th) {
                            e = th;
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (Exception e4) {
                                    C4990ab.printErrStackTrace("MicroMsg.WalletAddrMgr", e4, "", new Object[0]);
                                    AppMethodBeat.m2505o(16761);
                                    throw e;
                                }
                            }
                            if (bufferedReader2 != null) {
                                bufferedReader2.close();
                            }
                            AppMethodBeat.m2505o(16761);
                            throw e;
                        }
                    } catch (Throwable th2) {
                        e = th2;
                        bufferedReader2 = bufferedReader;
                        if (fileReader != null) {
                        }
                        if (bufferedReader2 != null) {
                        }
                        AppMethodBeat.m2505o(16761);
                        throw e;
                    }
                } catch (IOException e5) {
                    e = e5;
                    C4990ab.printErrStackTrace("MicroMsg.WalletAddrMgr", e, "", new Object[0]);
                    if (fileReader != null) {
                    }
                    if (bufferedReader2 != null) {
                    }
                    bufferedReader = bufferedReader2;
                    if (z) {
                    }
                    C4990ab.m7410d("MicroMsg.WalletAddrMgr", "read from addr ".concat(String.valueOf(z)));
                    size = arrayList.size();
                    obj = str2;
                    obj2 = str;
                    while (i < size) {
                    }
                    this.path = accPath + "addrmgr";
                    file = new File(this.path);
                    if (file.exists()) {
                    }
                    this.gIQ = (C45505a) new C45505a().parseFrom(C42322l.decrypt(C1173e.m2569e(this.path, 0, -1), arV()));
                    AppMethodBeat.m2505o(16761);
                }
            } catch (IOException e6) {
                e = e6;
                fileReader = null;
                C4990ab.printErrStackTrace("MicroMsg.WalletAddrMgr", e, "", new Object[0]);
                if (fileReader != null) {
                }
                if (bufferedReader2 != null) {
                }
                bufferedReader = bufferedReader2;
                if (z) {
                }
                C4990ab.m7410d("MicroMsg.WalletAddrMgr", "read from addr ".concat(String.valueOf(z)));
                size = arrayList.size();
                obj = str2;
                obj2 = str;
                while (i < size) {
                }
                this.path = accPath + "addrmgr";
                file = new File(this.path);
                if (file.exists()) {
                }
                this.gIQ = (C45505a) new C45505a().parseFrom(C42322l.decrypt(C1173e.m2569e(this.path, 0, -1), arV()));
                AppMethodBeat.m2505o(16761);
            } catch (Throwable th3) {
                e = th3;
                fileReader = null;
                if (fileReader != null) {
                }
                if (bufferedReader2 != null) {
                }
                AppMethodBeat.m2505o(16761);
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
                                C4990ab.printErrStackTrace("MicroMsg.WalletAddrMgr", e, "", new Object[0]);
                                if (bufferedReader3 != null) {
                                    try {
                                        bufferedReader3.close();
                                    } catch (IOException e8) {
                                        C4990ab.printErrStackTrace("MicroMsg.WalletAddrMgr", e8, "", new Object[0]);
                                    }
                                }
                                if (open != null) {
                                }
                                C4990ab.m7410d("MicroMsg.WalletAddrMgr", "read from addr ".concat(String.valueOf(z)));
                                size = arrayList.size();
                                obj = str2;
                                obj2 = str;
                                while (i < size) {
                                }
                                this.path = accPath + "addrmgr";
                                file = new File(this.path);
                                if (file.exists()) {
                                }
                                this.gIQ = (C45505a) new C45505a().parseFrom(C42322l.decrypt(C1173e.m2569e(this.path, 0, -1), arV()));
                                AppMethodBeat.m2505o(16761);
                            } catch (Throwable th4) {
                                e = th4;
                                if (bufferedReader3 != null) {
                                }
                                AppMethodBeat.m2505o(16761);
                                throw e;
                            }
                        }
                    }
                    bufferedReader3.close();
                    open.close();
                    try {
                        bufferedReader3.close();
                    } catch (IOException e82) {
                        C4990ab.printErrStackTrace("MicroMsg.WalletAddrMgr", e82, "", new Object[0]);
                    }
                    if (open != null) {
                    }
                } catch (IOException e9) {
                    e = e9;
                    bufferedReader3 = bufferedReader;
                } catch (Throwable th5) {
                }
            }
            C4990ab.m7410d("MicroMsg.WalletAddrMgr", "read from addr ".concat(String.valueOf(z)));
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
                    C4990ab.m7420w("MicroMsg.WalletAddrMgr", "analyze address data. missing ".concat(String.valueOf(str)));
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
                    if (C42322l.m74846bm(str2, "----")) {
                        rcptItem.gIP = true;
                    }
                    list.add(rcptItem);
                    this.gIS.put(obj2, list);
                    readLine = str3;
                } else if (str.startsWith("-")) {
                    if (C42322l.m74846bm(str2, "---")) {
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
            C4990ab.printErrStackTrace("MicroMsg.WalletAddrMgr", e222, "", new Object[0]);
        }
        this.path = accPath + "addrmgr";
        file = new File(this.path);
        if (file.exists()) {
            file.mkdir();
        }
        try {
            this.gIQ = (C45505a) new C45505a().parseFrom(C42322l.decrypt(C1173e.m2569e(this.path, 0, -1), arV()));
            AppMethodBeat.m2505o(16761);
        } catch (Exception e2222) {
            C4990ab.printErrStackTrace("MicroMsg.WalletAddrMgr", e2222, "", new Object[0]);
            AppMethodBeat.m2505o(16761);
        }
    }

    /* renamed from: ne */
    public final C38090b mo67843ne(int i) {
        AppMethodBeat.m2504i(16762);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < this.gIQ.gIY.size()) {
                C38090b c38090b = (C38090b) this.gIQ.gIY.get(i3);
                if (c38090b.f16139id == i) {
                    AppMethodBeat.m2505o(16762);
                    return c38090b;
                }
                i2 = i3 + 1;
            } else {
                AppMethodBeat.m2505o(16762);
                return null;
            }
        }
    }

    /* renamed from: a */
    public final boolean mo67839a(C38090b c38090b) {
        AppMethodBeat.m2504i(16763);
        if (this.gIQ == null) {
            this.gIQ = new C45505a();
        }
        for (int i = 0; i < this.gIQ.gIY.size(); i++) {
            if (((C38090b) this.gIQ.gIY.get(i)).f16139id == c38090b.f16139id) {
                this.gIQ.gIY.remove(i);
                AppMethodBeat.m2505o(16763);
                return true;
            }
        }
        AppMethodBeat.m2505o(16763);
        return false;
    }

    /* renamed from: s */
    public final boolean mo67844s(LinkedList<bpk> linkedList) {
        AppMethodBeat.m2504i(16764);
        this.gIQ.gIY.clear();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            bpk bpk = (bpk) it.next();
            C38090b c38090b = new C38090b();
            c38090b.f16139id = bpk.f15076id;
            c38090b.gJh = bpk.wRW.wVI;
            c38090b.gJb = bpk.wRQ.wVI;
            c38090b.gJe = bpk.wRT.wVI;
            c38090b.gJc = bpk.wRR.wVI;
            c38090b.gJf = bpk.wRU.wVI;
            c38090b.gJg = bpk.wRV.wVI;
            c38090b.gJa = bpk.wRP.wVI;
            c38090b.gJd = bpk.wRS.wVI;
            this.gIQ.gIY.add(c38090b);
        }
        AppMethodBeat.m2505o(16764);
        return true;
    }

    public final void arU() {
        AppMethodBeat.m2504i(16765);
        try {
            byte[] toByteArray = this.gIQ.toByteArray();
            long currentTimeMillis = System.currentTimeMillis();
            toByteArray = C42322l.encrypt(toByteArray, arV());
            C1173e.deleteFile(this.path);
            C1173e.m2559b(this.path, toByteArray, toByteArray.length);
            C4990ab.m7411d("MicroMsg.WalletAddrMgr", "hakon saveAddr time %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.m2505o(16765);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.WalletAddrMgr", e, "", new Object[0]);
            AppMethodBeat.m2505o(16765);
        }
    }

    private byte[] arV() {
        AppMethodBeat.m2504i(16766);
        byte[] bytes = C1178g.m2591x(("addrmgr" + this.path).toString().getBytes()).substring(8, 16).getBytes();
        AppMethodBeat.m2505o(16766);
        return bytes;
    }

    private static byte[] encrypt(byte[] bArr, byte[] bArr2) {
        byte[] doFinal;
        AppMethodBeat.m2504i(16767);
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
            Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
            instance.init(1, generateSecret, new IvParameterSpec("12345678".getBytes()));
            doFinal = instance.doFinal(bArr);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.WalletAddrMgr", e, "", new Object[0]);
            doFinal = null;
        }
        AppMethodBeat.m2505o(16767);
        return doFinal;
    }

    private static byte[] decrypt(byte[] bArr, byte[] bArr2) {
        byte[] doFinal;
        AppMethodBeat.m2504i(16768);
        try {
            SecretKey generateSecret = SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(bArr2));
            Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
            instance.init(2, generateSecret, new IvParameterSpec("12345678".getBytes()));
            doFinal = instance.doFinal(bArr);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.WalletAddrMgr", e, "", new Object[0]);
            doFinal = null;
        }
        AppMethodBeat.m2505o(16768);
        return doFinal;
    }

    /* renamed from: wC */
    public final List<RcptItem> mo67845wC(String str) {
        AppMethodBeat.m2504i(16769);
        if (this.gIS.containsKey(str)) {
            List list = (List) this.gIS.get(str);
            AppMethodBeat.m2505o(16769);
            return list;
        }
        List<RcptItem> arrayList = new ArrayList();
        AppMethodBeat.m2505o(16769);
        return arrayList;
    }

    /* renamed from: wD */
    public final List<RcptItem> mo67846wD(String str) {
        AppMethodBeat.m2504i(16770);
        if (this.gIT.containsKey(str)) {
            List list = (List) this.gIT.get(str);
            AppMethodBeat.m2505o(16770);
            return list;
        }
        List<RcptItem> arrayList = new ArrayList();
        AppMethodBeat.m2505o(16770);
        return arrayList;
    }

    /* renamed from: wE */
    public final RcptItem mo67847wE(String str) {
        AppMethodBeat.m2504i(16771);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(16771);
            return null;
        }
        for (RcptItem rcptItem : this.gIR) {
            if (rcptItem.name.startsWith(str)) {
                AppMethodBeat.m2505o(16771);
                return rcptItem;
            }
        }
        AppMethodBeat.m2505o(16771);
        return null;
    }

    /* renamed from: bl */
    public final RcptItem mo67842bl(String str, String str2) {
        AppMethodBeat.m2504i(16772);
        List<RcptItem> wC = mo67845wC(str);
        if (wC == null || wC.size() == 0) {
            AppMethodBeat.m2505o(16772);
            return null;
        }
        for (RcptItem rcptItem : wC) {
            if (rcptItem.name.startsWith(str2)) {
                AppMethodBeat.m2505o(16772);
                return rcptItem;
            }
        }
        AppMethodBeat.m2505o(16772);
        return null;
    }

    static {
        AppMethodBeat.m2504i(16777);
        AppMethodBeat.m2505o(16777);
    }

    /* renamed from: bm */
    private static boolean m74846bm(String str, String str2) {
        AppMethodBeat.m2504i(16773);
        if (str.substring(6).startsWith(str2)) {
            AppMethodBeat.m2505o(16773);
            return true;
        }
        AppMethodBeat.m2505o(16773);
        return false;
    }

    /* renamed from: y */
    public final RcptItem mo67848y(String str, String str2, String str3) {
        AppMethodBeat.m2504i(16774);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AppMethodBeat.m2505o(16774);
            return null;
        }
        RcptItem e = C42322l.m74847e(this.gIR, str);
        if (e == null || TextUtils.isEmpty(e.code)) {
            AppMethodBeat.m2505o(16774);
            return null;
        }
        e = C42322l.m74847e(mo67845wC(e.code), str2);
        if (e == null || TextUtils.isEmpty(e.code)) {
            AppMethodBeat.m2505o(16774);
            return null;
        } else if (TextUtils.isEmpty(str3)) {
            AppMethodBeat.m2505o(16774);
            return e;
        } else {
            RcptItem e2 = C42322l.m74847e(mo67846wD(e.code), str3);
            if (e2 == null) {
                AppMethodBeat.m2505o(16774);
                return e;
            }
            AppMethodBeat.m2505o(16774);
            return e2;
        }
    }

    /* renamed from: e */
    private static RcptItem m74847e(List<RcptItem> list, String str) {
        AppMethodBeat.m2504i(16775);
        if (list == null || list.isEmpty() || TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(16775);
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
        AppMethodBeat.m2505o(16775);
        return rcptItem;
    }

    /* renamed from: z */
    public final boolean mo67849z(String str, String str2, String str3) {
        AppMethodBeat.m2504i(16776);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            AppMethodBeat.m2505o(16776);
            return false;
        }
        RcptItem e = C42322l.m74847e(this.gIR, str);
        if (e == null || TextUtils.isEmpty(e.code)) {
            AppMethodBeat.m2505o(16776);
            return false;
        }
        e = C42322l.m74847e(mo67845wC(e.code), str2);
        if (e == null || TextUtils.isEmpty(e.code)) {
            AppMethodBeat.m2505o(16776);
            return false;
        } else if (TextUtils.isEmpty(str3)) {
            AppMethodBeat.m2505o(16776);
            return true;
        } else if (C42322l.m74847e(mo67846wD(e.code), str3) == null) {
            AppMethodBeat.m2505o(16776);
            return false;
        } else {
            AppMethodBeat.m2505o(16776);
            return true;
        }
    }
}
