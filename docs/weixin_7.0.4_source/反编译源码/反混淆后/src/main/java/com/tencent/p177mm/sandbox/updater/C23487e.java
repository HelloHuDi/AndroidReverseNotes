package com.tencent.p177mm.sandbox.updater;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p209c.C41914i;
import com.tencent.p177mm.p209c.C41914i.C32431a;
import com.tencent.p177mm.protocal.protobuf.bdm;
import com.tencent.p177mm.protocal.protobuf.bhy;
import com.tencent.p177mm.protocal.protobuf.bhz;
import com.tencent.p177mm.protocal.protobuf.bia;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.sandbox.updater.e */
public final class C23487e {
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

    public C23487e(bia bia) {
        AppMethodBeat.m2504i(28894);
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
            AppMethodBeat.m2505o(28894);
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
            AppMethodBeat.m2505o(28894);
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
                    this.nup = C23487e.m36317OI(bhy.value);
                } else if (bhy.key.equalsIgnoreCase("alphaContent")) {
                    this.nuq = C23487e.m36317OI(bhy.value);
                } else if (bhy.key.equalsIgnoreCase("alphaUrl")) {
                    this.nur = bhy.value;
                }
            }
        }
        AppMethodBeat.m2505o(28894);
    }

    public final String dnp() {
        AppMethodBeat.m2504i(28895);
        String substring = this.nuk.substring(0, this.nuk.lastIndexOf(47) + 1);
        String substring2 = this.nuk.substring(this.nuk.lastIndexOf(47) + 1);
        C41914i c41914i = new C41914i(substring, this.versionCode);
        c41914i.mo67557a(new C32431a(this.nuo, this.nun, this.nul, substring2, this.fileSize));
        substring = c41914i.mo67556AM();
        AppMethodBeat.m2505o(28895);
        return substring;
    }

    public final String toString() {
        AppMethodBeat.m2504i(28896);
        String str = "responseState:" + this.nug + "\ncdnUrl:" + this.nuk + "\nfileMd5:" + this.nul + "\npackageType:" + this.nui + "\nnetworkType:" + this.nuj + "\npatchId:" + this.num;
        AppMethodBeat.m2505o(28896);
        return str;
    }

    /* renamed from: OH */
    public static boolean m36316OH(String str) {
        AppMethodBeat.m2504i(28897);
        if (!C5046bo.isNullOrNil(str) && str.length() == 10) {
            try {
                int intValue = Integer.decode(str).intValue();
                if ((intValue & 255) < 0 || (intValue & 255) > 31) {
                    AppMethodBeat.m2505o(28897);
                    return false;
                }
                AppMethodBeat.m2505o(28897);
                return true;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("Tinker.TinkerSyncResponse", e, "checkAplhVersion failed.", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(28897);
        return false;
    }

    /* renamed from: OI */
    private static String m36317OI(String str) {
        AppMethodBeat.m2504i(28898);
        String str2;
        if (C5046bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.m2505o(28898);
            return str2;
        }
        str2 = new String(Base64.decode(str, 0));
        AppMethodBeat.m2505o(28898);
        return str2;
    }
}
