package com.tencent.p177mm.plugin.p436hp.p1273d;

import android.content.Context;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.bdm;
import com.tencent.p177mm.protocal.protobuf.bhy;
import com.tencent.p177mm.protocal.protobuf.bhz;
import com.tencent.p177mm.protocal.protobuf.bia;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.hp.d.b */
public final class C28317b {
    public String clientVersion;
    public final int fileSize;
    public final Integer nug;
    public HashMap<Integer, LinkedList<bdm>> nuh = new HashMap();
    public final Integer nui;
    public final Integer nuj;
    public final String nuk;
    public final String nul;
    public final String num;
    public String nun;
    public String nuo;
    public String nup;
    public String nuq;
    public String nur;
    public int versionCode;

    public C28317b(bia bia) {
        AppMethodBeat.m2504i(90674);
        if (bia == null) {
            this.nug = Integer.valueOf(1);
            this.nuk = "";
            this.nul = "";
            this.nui = Integer.valueOf(-1);
            this.nuj = Integer.valueOf(-1);
            this.num = "";
            this.fileSize = 0;
            this.nun = "";
            this.nuo = "";
            this.versionCode = 0;
            this.clientVersion = "";
            this.nup = "";
            this.nuq = "";
            this.nur = "";
            AppMethodBeat.m2505o(90674);
            return;
        }
        if (bia.wLm != null) {
            this.nul = bia.wLm.wdO;
            this.nuk = bia.wLm.Url;
            this.fileSize = bia.wLm.FileSize;
        } else {
            this.nul = "";
            this.nuk = "";
            this.fileSize = 0;
        }
        this.nug = Integer.valueOf(bia.state);
        this.nuj = Integer.valueOf(bia.wLl);
        if (!(bia.wLj == null || bia.wLj.isEmpty())) {
            int size = bia.wLj.size();
            for (int i = 0; i < size; i++) {
                bhz bhz = (bhz) bia.wLj.get(i);
                if (!(bhz.wLi == null || bhz.wLi.isEmpty())) {
                    this.nuh.put(Integer.valueOf(bhz.type), bhz.wLi);
                }
            }
        }
        this.nui = Integer.valueOf(bia.wLk);
        this.num = bia.pdA;
        if (bia.wLo == null || bia.wLo.isEmpty()) {
            this.nun = "";
            this.nuo = "";
            this.versionCode = 0;
            this.clientVersion = "";
            this.nup = "";
            this.nuq = "";
            this.nur = "";
            AppMethodBeat.m2505o(90674);
            return;
        }
        Iterator it = bia.wLo.iterator();
        while (it.hasNext()) {
            bhy bhy = (bhy) it.next();
            if (!(bhy == null || C5046bo.isNullOrNil(bhy.key))) {
                if (bhy.key.equalsIgnoreCase("newApkMd5")) {
                    this.nun = bhy.value;
                } else if (bhy.key.equalsIgnoreCase("oldApkMd5")) {
                    this.nuo = bhy.value;
                } else if (bhy.key.equalsIgnoreCase(DownloadInfoColumns.VERSIONCODE)) {
                    this.versionCode = C5046bo.ank(bhy.value);
                } else if (bhy.key.equalsIgnoreCase("clientVersion")) {
                    this.clientVersion = bhy.value;
                } else if (bhy.key.equalsIgnoreCase("alphaTitle")) {
                    this.nup = C21071c.m32375OI(bhy.value);
                } else if (bhy.key.equalsIgnoreCase("alphaContent")) {
                    this.nuq = C21071c.m32375OI(bhy.value);
                } else if (bhy.key.equalsIgnoreCase("alphaUrl")) {
                    this.nur = bhy.value;
                }
            }
        }
        AppMethodBeat.m2505o(90674);
    }

    public final boolean bGu() {
        AppMethodBeat.m2504i(90675);
        Context context = C4996ah.getContext();
        if (!C5023at.isConnected(context)) {
            AppMethodBeat.m2505o(90675);
            return false;
        } else if (this.nuj.intValue() == 1) {
            AppMethodBeat.m2505o(90675);
            return true;
        } else if (this.nuj.intValue() == 3) {
            boolean isWifi = C5023at.isWifi(context);
            AppMethodBeat.m2505o(90675);
            return isWifi;
        } else {
            AppMethodBeat.m2505o(90675);
            return true;
        }
    }

    public final boolean bGv() {
        AppMethodBeat.m2504i(90676);
        if (this.nug.intValue() == 2 || this.nug.intValue() == 4) {
            AppMethodBeat.m2505o(90676);
            return true;
        }
        AppMethodBeat.m2505o(90676);
        return false;
    }

    public final boolean bGw() {
        AppMethodBeat.m2504i(90677);
        if (this.nuh == null || this.nuh.isEmpty() || !this.nuh.containsKey(Integer.valueOf(4))) {
            AppMethodBeat.m2505o(90677);
            return false;
        }
        AppMethodBeat.m2505o(90677);
        return true;
    }

    /* renamed from: a */
    public static String m44924a(HashMap<Integer, LinkedList<bdm>> hashMap, int i) {
        AppMethodBeat.m2504i(90678);
        String str;
        if (hashMap == null || hashMap.isEmpty()) {
            str = "";
            AppMethodBeat.m2505o(90678);
            return str;
        }
        str = "";
        LinkedList linkedList = (LinkedList) hashMap.get(Integer.valueOf(i));
        if (!(linkedList == null || linkedList.isEmpty())) {
            int size = linkedList.size();
            int i2 = 0;
            while (i2 < size) {
                String str2;
                bdm bdm = (bdm) linkedList.get(i2);
                if (bdm.lang.equalsIgnoreCase("default")) {
                    str2 = new String(Base64.decode(bdm.content, 0));
                } else if (bdm.lang.equalsIgnoreCase(C4988aa.dor())) {
                    str = new String(Base64.decode(bdm.content, 0));
                    AppMethodBeat.m2505o(90678);
                    return str;
                } else {
                    str2 = str;
                }
                i2++;
                str = str2;
            }
        }
        AppMethodBeat.m2505o(90678);
        return str;
    }

    public final String bGx() {
        AppMethodBeat.m2504i(90679);
        String a;
        if (bGw()) {
            a = C28317b.m44924a(this.nuh, 4);
            AppMethodBeat.m2505o(90679);
            return a;
        }
        a = "";
        AppMethodBeat.m2505o(90679);
        return a;
    }

    public final String toString() {
        AppMethodBeat.m2504i(90680);
        String str = "responseState:" + this.nug + "\ncdnUrl:" + this.nuk + "\nfileMd5:" + this.nul + "\npackageType:" + this.nui + "\nnetworkType:" + this.nuj + "\npatchId:" + this.num;
        AppMethodBeat.m2505o(90680);
        return str;
    }

    public final boolean bGy() {
        AppMethodBeat.m2504i(90681);
        String str = "Tinker.TinkerSyncResponse";
        String str2 = "clientVersion %s currentVersion %s";
        Object[] objArr = new Object[2];
        objArr[0] = this.clientVersion == null ? "" : this.clientVersion;
        objArr[1] = C5058f.CLIENT_VERSION;
        C4990ab.m7417i(str, str2, objArr);
        if (!C5046bo.isNullOrNil(this.clientVersion)) {
            try {
                if ((Integer.decode(this.clientVersion).intValue() & -256) < (Integer.decode(C5058f.CLIENT_VERSION).intValue() & -256)) {
                    AppMethodBeat.m2505o(90681);
                    return true;
                }
                AppMethodBeat.m2505o(90681);
                return false;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("Tinker.TinkerSyncResponse", e, "isLowerClientVersion", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(90681);
        return false;
    }
}
