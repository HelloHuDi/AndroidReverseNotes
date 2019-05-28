package com.tencent.mm.sandbox.updater;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.c.i;
import com.tencent.mm.c.i.a;
import com.tencent.mm.protocal.protobuf.bdm;
import com.tencent.mm.protocal.protobuf.bhy;
import com.tencent.mm.protocal.protobuf.bhz;
import com.tencent.mm.protocal.protobuf.bia;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class e {
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

    public e(bia bia) {
        AppMethodBeat.i(28894);
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
            AppMethodBeat.o(28894);
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
            AppMethodBeat.o(28894);
            return;
        }
        Iterator it = bia.wLo.iterator();
        while (it.hasNext()) {
            bhy bhy = (bhy) it.next();
            if (!(bhy == null || bo.isNullOrNil(bhy.key))) {
                if (bhy.key.equalsIgnoreCase("newApkMd5")) {
                    this.nun = bhy.value;
                } else if (bhy.key.equalsIgnoreCase("oldApkMd5")) {
                    this.nuo = bhy.value;
                } else if (bhy.key.equalsIgnoreCase(DownloadInfoColumns.VERSIONCODE)) {
                    this.versionCode = bo.ank(bhy.value);
                } else if (bhy.key.equalsIgnoreCase("clientVersion")) {
                    this.clientVersion = bhy.value;
                } else if (bhy.key.equalsIgnoreCase("alphaTitle")) {
                    this.nup = OI(bhy.value);
                } else if (bhy.key.equalsIgnoreCase("alphaContent")) {
                    this.nuq = OI(bhy.value);
                } else if (bhy.key.equalsIgnoreCase("alphaUrl")) {
                    this.nur = bhy.value;
                }
            }
        }
        AppMethodBeat.o(28894);
    }

    public final String dnp() {
        AppMethodBeat.i(28895);
        String substring = this.nuk.substring(0, this.nuk.lastIndexOf(47) + 1);
        String substring2 = this.nuk.substring(this.nuk.lastIndexOf(47) + 1);
        i iVar = new i(substring, this.versionCode);
        iVar.a(new a(this.nuo, this.nun, this.nul, substring2, this.fileSize));
        substring = iVar.AM();
        AppMethodBeat.o(28895);
        return substring;
    }

    public final String toString() {
        AppMethodBeat.i(28896);
        String str = "responseState:" + this.nug + "\ncdnUrl:" + this.nuk + "\nfileMd5:" + this.nul + "\npackageType:" + this.nui + "\nnetworkType:" + this.nuj + "\npatchId:" + this.num;
        AppMethodBeat.o(28896);
        return str;
    }

    public static boolean OH(String str) {
        AppMethodBeat.i(28897);
        if (!bo.isNullOrNil(str) && str.length() == 10) {
            try {
                int intValue = Integer.decode(str).intValue();
                if ((intValue & 255) < 0 || (intValue & 255) > 31) {
                    AppMethodBeat.o(28897);
                    return false;
                }
                AppMethodBeat.o(28897);
                return true;
            } catch (Exception e) {
                ab.printErrStackTrace("Tinker.TinkerSyncResponse", e, "checkAplhVersion failed.", new Object[0]);
            }
        }
        AppMethodBeat.o(28897);
        return false;
    }

    private static String OI(String str) {
        AppMethodBeat.i(28898);
        String str2;
        if (bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.o(28898);
            return str2;
        }
        str2 = new String(Base64.decode(str, 0));
        AppMethodBeat.o(28898);
        return str2;
    }
}
