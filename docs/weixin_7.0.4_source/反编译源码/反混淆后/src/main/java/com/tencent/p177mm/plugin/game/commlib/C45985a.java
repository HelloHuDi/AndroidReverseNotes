package com.tencent.p177mm.plugin.game.commlib;

import android.content.SharedPreferences;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.p248j.C1761b;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.game.p731d.C12109ac;
import com.tencent.p177mm.plugin.game.p731d.C12118cu;
import com.tencent.p177mm.plugin.game.p731d.C34265ak;
import com.tencent.p177mm.plugin.game.p731d.C39197dd;
import com.tencent.p177mm.plugin.game.p731d.C39199dm;
import com.tencent.p177mm.plugin.game.p731d.C45990ay;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.game.commlib.a */
public final class C45985a {
    private static final String mTq = (C1761b.eSj + "game/");
    public static final String mTr = (mTq + "globalconfig");
    private static C45990ay mTs;

    static {
        AppMethodBeat.m2504i(116984);
        AppMethodBeat.m2505o(116984);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004a A:{SYNTHETIC, Splitter:B:14:0x004a} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004a A:{SYNTHETIC, Splitter:B:14:0x004a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static void m85431a(C45990ay c45990ay) {
        FileOutputStream fileOutputStream;
        IOException e;
        AppMethodBeat.m2504i(116972);
        mTs = c45990ay;
        if (c45990ay.nbD != null) {
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_DOWNLOADER_APP_HIDDEN_BOOLEAN_SYNC, Boolean.valueOf(mTs.nbD.nal));
        }
        File file = new File(mTq);
        if (!(file.exists() && file.isDirectory())) {
            file.mkdirs();
        }
        try {
            byte[] toByteArray = c45990ay.toByteArray();
            fileOutputStream = new FileOutputStream(mTr);
            try {
                fileOutputStream.write(toByteArray);
            } catch (IOException e2) {
                e = e2;
                C4990ab.m7412e("MicroMsg.GameConfigManager", "saveConfig2File: " + e.getMessage());
                if (fileOutputStream != null) {
                }
                C28180e.bDo();
                AppMethodBeat.m2505o(116972);
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream = null;
            C4990ab.m7412e("MicroMsg.GameConfigManager", "saveConfig2File: " + e.getMessage());
            if (fileOutputStream != null) {
            }
            C28180e.bDo();
            AppMethodBeat.m2505o(116972);
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e4) {
            }
        }
        C28180e.bDo();
        AppMethodBeat.m2505o(116972);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003c A:{SYNTHETIC, Splitter:B:17:0x003c} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003c A:{SYNTHETIC, Splitter:B:17:0x003c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void bDc() {
        Exception e;
        synchronized (C45985a.class) {
            AppMethodBeat.m2504i(116973);
            if (mTs != null) {
                AppMethodBeat.m2505o(116973);
            } else {
                FileInputStream fileInputStream;
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    File file = new File(mTr);
                    fileInputStream = new FileInputStream(file);
                    try {
                        byte[] bArr = new byte[((int) file.length())];
                        fileInputStream.read(bArr);
                        C45990ay c45990ay = new C45990ay();
                        mTs = c45990ay;
                        c45990ay.parseFrom(bArr);
                    } catch (Exception e2) {
                        e = e2;
                        C4990ab.m7412e("MicroMsg.GameConfigManager", "parseGlobalConfig: " + e.getMessage());
                        if (fileInputStream != null) {
                        }
                        C4990ab.m7416i("MicroMsg.GameConfigManager", "parseConfigFile, cost: " + (System.currentTimeMillis() - currentTimeMillis));
                        AppMethodBeat.m2505o(116973);
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileInputStream = null;
                    C4990ab.m7412e("MicroMsg.GameConfigManager", "parseGlobalConfig: " + e.getMessage());
                    if (fileInputStream != null) {
                    }
                    C4990ab.m7416i("MicroMsg.GameConfigManager", "parseConfigFile, cost: " + (System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.m2505o(116973);
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                    }
                }
                C4990ab.m7416i("MicroMsg.GameConfigManager", "parseConfigFile, cost: " + (System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.m2505o(116973);
            }
        }
    }

    public static boolean bDd() {
        boolean z;
        AppMethodBeat.m2504i(116974);
        if (mTs != null) {
            z = mTs.nbv;
        } else {
            C45985a.bDc();
            SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences(C4996ah.doA(), 0);
            C4996ah.getContext();
            C4990ab.m7417i("MicroMsg.GameConfigManager", "getShowEntrance, lang = %s", C4988aa.m7402g(sharedPreferences));
            C4990ab.m7417i("MicroMsg.GameConfigManager", "hide game center:[%s]", C5046bo.m7532bc(C26373g.m41964Nu().getValue("HideGameCenter"), "zh_CN".equals(C4988aa.m7402g(sharedPreferences)) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1"));
            z = r0.equalsIgnoreCase(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        C4990ab.m7416i("MicroMsg.GameConfigManager", "getShowEntrance : ".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(116974);
        return z;
    }

    public static C34265ak bDe() {
        AppMethodBeat.m2504i(116975);
        C34265ak c34265ak = null;
        if (mTs != null) {
            c34265ak = mTs.nbw;
            if (c34265ak != null) {
                C4990ab.m7417i("MicroMsg.GameConfigManager", "getGameIndexSettingControl jumpType:%d, jumpUrl:%s", Integer.valueOf(c34265ak.naz), c34265ak.mZj);
            }
        } else {
            C45985a.bDc();
        }
        AppMethodBeat.m2505o(116975);
        return c34265ak;
    }

    public static C12109ac bDf() {
        AppMethodBeat.m2504i(116976);
        C12109ac c12109ac = null;
        if (mTs != null) {
            c12109ac = mTs.nby;
            if (c12109ac != null) {
                C4990ab.m7417i("MicroMsg.GameConfigManager", "getGameDetailSettingControl jumpType:%d, jumpUrl:%s", Integer.valueOf(c12109ac.naz), c12109ac.mZj);
            }
        } else {
            C45985a.bDc();
        }
        AppMethodBeat.m2505o(116976);
        return c12109ac;
    }

    public static C39197dd bDg() {
        AppMethodBeat.m2504i(116977);
        if (mTs != null) {
            C39197dd c39197dd = mTs.nbA;
            AppMethodBeat.m2505o(116977);
            return c39197dd;
        }
        C45985a.bDc();
        AppMethodBeat.m2505o(116977);
        return null;
    }

    public static boolean bDh() {
        AppMethodBeat.m2504i(116978);
        if (mTs == null) {
            C45985a.bDc();
        } else if (mTs.nbC != null) {
            boolean z = mTs.nbC.ndK;
            AppMethodBeat.m2505o(116978);
            return z;
        }
        AppMethodBeat.m2505o(116978);
        return false;
    }

    public static String bDi() {
        AppMethodBeat.m2504i(116979);
        if (mTs == null) {
            C45985a.bDc();
        } else if (mTs.nbB != null) {
            String str = mTs.nbB.mZV;
            AppMethodBeat.m2505o(116979);
            return str;
        }
        AppMethodBeat.m2505o(116979);
        return null;
    }

    public static List<String> bDj() {
        AppMethodBeat.m2504i(116980);
        if (mTs == null) {
            C45985a.bDc();
        } else if (mTs.nbC != null) {
            LinkedList<C12118cu> linkedList = mTs.nbC.ndL;
            if (!C5046bo.m7548ek(linkedList)) {
                ArrayList arrayList = new ArrayList();
                for (C12118cu c12118cu : linkedList) {
                    if (!(c12118cu == null || C5046bo.isNullOrNil(c12118cu.mZV))) {
                        arrayList.add(c12118cu.mZV);
                    }
                }
                AppMethodBeat.m2505o(116980);
                return arrayList;
            }
        }
        AppMethodBeat.m2505o(116980);
        return null;
    }

    public static List<String> bDk() {
        AppMethodBeat.m2504i(116981);
        if (mTs == null) {
            C45985a.bDc();
        } else if (mTs.nbC != null) {
            LinkedList<C12118cu> linkedList = mTs.nbC.ndM;
            if (!C5046bo.m7548ek(linkedList)) {
                ArrayList arrayList = new ArrayList();
                for (C12118cu c12118cu : linkedList) {
                    if (!(c12118cu == null || C5046bo.isNullOrNil(c12118cu.mZV))) {
                        arrayList.add(c12118cu.mZV);
                    }
                }
                AppMethodBeat.m2505o(116981);
                return arrayList;
            }
        }
        AppMethodBeat.m2505o(116981);
        return null;
    }

    public static int bDl() {
        AppMethodBeat.m2504i(116982);
        if (mTs == null) {
            C45985a.bDc();
            AppMethodBeat.m2505o(116982);
            return 0;
        } else if (mTs.nbE != null) {
            int i = mTs.nbE.ndJ;
            AppMethodBeat.m2505o(116982);
            return i;
        } else {
            AppMethodBeat.m2505o(116982);
            return 0;
        }
    }

    public static List<String> bDm() {
        AppMethodBeat.m2504i(116983);
        if (mTs == null) {
            C45985a.bDc();
        } else if (mTs.nbF != null) {
            LinkedList<C39199dm> linkedList = mTs.nbF.nak;
            if (!C5046bo.m7548ek(linkedList)) {
                ArrayList arrayList = new ArrayList();
                for (C39199dm c39199dm : linkedList) {
                    if (!(c39199dm == null || C5046bo.isNullOrNil(c39199dm.ndI))) {
                        arrayList.add(c39199dm.ndI);
                    }
                }
                AppMethodBeat.m2505o(116983);
                return arrayList;
            }
        }
        AppMethodBeat.m2505o(116983);
        return null;
    }
}
