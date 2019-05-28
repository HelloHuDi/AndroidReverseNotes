package com.tencent.mm.plugin.game.commlib;

import android.content.SharedPreferences;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.game.d.ac;
import com.tencent.mm.plugin.game.d.ak;
import com.tencent.mm.plugin.game.d.ay;
import com.tencent.mm.plugin.game.d.cu;
import com.tencent.mm.plugin.game.d.dd;
import com.tencent.mm.plugin.game.d.dm;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a {
    private static final String mTq = (b.eSj + "game/");
    public static final String mTr = (mTq + "globalconfig");
    private static ay mTs;

    static {
        AppMethodBeat.i(116984);
        AppMethodBeat.o(116984);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004a A:{SYNTHETIC, Splitter:B:14:0x004a} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004a A:{SYNTHETIC, Splitter:B:14:0x004a} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(ay ayVar) {
        FileOutputStream fileOutputStream;
        IOException e;
        AppMethodBeat.i(116972);
        mTs = ayVar;
        if (ayVar.nbD != null) {
            g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_DOWNLOADER_APP_HIDDEN_BOOLEAN_SYNC, Boolean.valueOf(mTs.nbD.nal));
        }
        File file = new File(mTq);
        if (!(file.exists() && file.isDirectory())) {
            file.mkdirs();
        }
        try {
            byte[] toByteArray = ayVar.toByteArray();
            fileOutputStream = new FileOutputStream(mTr);
            try {
                fileOutputStream.write(toByteArray);
            } catch (IOException e2) {
                e = e2;
                ab.e("MicroMsg.GameConfigManager", "saveConfig2File: " + e.getMessage());
                if (fileOutputStream != null) {
                }
                e.bDo();
                AppMethodBeat.o(116972);
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream = null;
            ab.e("MicroMsg.GameConfigManager", "saveConfig2File: " + e.getMessage());
            if (fileOutputStream != null) {
            }
            e.bDo();
            AppMethodBeat.o(116972);
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e4) {
            }
        }
        e.bDo();
        AppMethodBeat.o(116972);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x003c A:{SYNTHETIC, Splitter:B:17:0x003c} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003c A:{SYNTHETIC, Splitter:B:17:0x003c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void bDc() {
        Exception e;
        synchronized (a.class) {
            AppMethodBeat.i(116973);
            if (mTs != null) {
                AppMethodBeat.o(116973);
            } else {
                FileInputStream fileInputStream;
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    File file = new File(mTr);
                    fileInputStream = new FileInputStream(file);
                    try {
                        byte[] bArr = new byte[((int) file.length())];
                        fileInputStream.read(bArr);
                        ay ayVar = new ay();
                        mTs = ayVar;
                        ayVar.parseFrom(bArr);
                    } catch (Exception e2) {
                        e = e2;
                        ab.e("MicroMsg.GameConfigManager", "parseGlobalConfig: " + e.getMessage());
                        if (fileInputStream != null) {
                        }
                        ab.i("MicroMsg.GameConfigManager", "parseConfigFile, cost: " + (System.currentTimeMillis() - currentTimeMillis));
                        AppMethodBeat.o(116973);
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileInputStream = null;
                    ab.e("MicroMsg.GameConfigManager", "parseGlobalConfig: " + e.getMessage());
                    if (fileInputStream != null) {
                    }
                    ab.i("MicroMsg.GameConfigManager", "parseConfigFile, cost: " + (System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.o(116973);
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e4) {
                    }
                }
                ab.i("MicroMsg.GameConfigManager", "parseConfigFile, cost: " + (System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(116973);
            }
        }
    }

    public static boolean bDd() {
        boolean z;
        AppMethodBeat.i(116974);
        if (mTs != null) {
            z = mTs.nbv;
        } else {
            bDc();
            SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences(ah.doA(), 0);
            ah.getContext();
            ab.i("MicroMsg.GameConfigManager", "getShowEntrance, lang = %s", aa.g(sharedPreferences));
            ab.i("MicroMsg.GameConfigManager", "hide game center:[%s]", bo.bc(com.tencent.mm.m.g.Nu().getValue("HideGameCenter"), "zh_CN".equals(aa.g(sharedPreferences)) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1"));
            z = r0.equalsIgnoreCase(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        ab.i("MicroMsg.GameConfigManager", "getShowEntrance : ".concat(String.valueOf(z)));
        AppMethodBeat.o(116974);
        return z;
    }

    public static ak bDe() {
        AppMethodBeat.i(116975);
        ak akVar = null;
        if (mTs != null) {
            akVar = mTs.nbw;
            if (akVar != null) {
                ab.i("MicroMsg.GameConfigManager", "getGameIndexSettingControl jumpType:%d, jumpUrl:%s", Integer.valueOf(akVar.naz), akVar.mZj);
            }
        } else {
            bDc();
        }
        AppMethodBeat.o(116975);
        return akVar;
    }

    public static ac bDf() {
        AppMethodBeat.i(116976);
        ac acVar = null;
        if (mTs != null) {
            acVar = mTs.nby;
            if (acVar != null) {
                ab.i("MicroMsg.GameConfigManager", "getGameDetailSettingControl jumpType:%d, jumpUrl:%s", Integer.valueOf(acVar.naz), acVar.mZj);
            }
        } else {
            bDc();
        }
        AppMethodBeat.o(116976);
        return acVar;
    }

    public static dd bDg() {
        AppMethodBeat.i(116977);
        if (mTs != null) {
            dd ddVar = mTs.nbA;
            AppMethodBeat.o(116977);
            return ddVar;
        }
        bDc();
        AppMethodBeat.o(116977);
        return null;
    }

    public static boolean bDh() {
        AppMethodBeat.i(116978);
        if (mTs == null) {
            bDc();
        } else if (mTs.nbC != null) {
            boolean z = mTs.nbC.ndK;
            AppMethodBeat.o(116978);
            return z;
        }
        AppMethodBeat.o(116978);
        return false;
    }

    public static String bDi() {
        AppMethodBeat.i(116979);
        if (mTs == null) {
            bDc();
        } else if (mTs.nbB != null) {
            String str = mTs.nbB.mZV;
            AppMethodBeat.o(116979);
            return str;
        }
        AppMethodBeat.o(116979);
        return null;
    }

    public static List<String> bDj() {
        AppMethodBeat.i(116980);
        if (mTs == null) {
            bDc();
        } else if (mTs.nbC != null) {
            LinkedList<cu> linkedList = mTs.nbC.ndL;
            if (!bo.ek(linkedList)) {
                ArrayList arrayList = new ArrayList();
                for (cu cuVar : linkedList) {
                    if (!(cuVar == null || bo.isNullOrNil(cuVar.mZV))) {
                        arrayList.add(cuVar.mZV);
                    }
                }
                AppMethodBeat.o(116980);
                return arrayList;
            }
        }
        AppMethodBeat.o(116980);
        return null;
    }

    public static List<String> bDk() {
        AppMethodBeat.i(116981);
        if (mTs == null) {
            bDc();
        } else if (mTs.nbC != null) {
            LinkedList<cu> linkedList = mTs.nbC.ndM;
            if (!bo.ek(linkedList)) {
                ArrayList arrayList = new ArrayList();
                for (cu cuVar : linkedList) {
                    if (!(cuVar == null || bo.isNullOrNil(cuVar.mZV))) {
                        arrayList.add(cuVar.mZV);
                    }
                }
                AppMethodBeat.o(116981);
                return arrayList;
            }
        }
        AppMethodBeat.o(116981);
        return null;
    }

    public static int bDl() {
        AppMethodBeat.i(116982);
        if (mTs == null) {
            bDc();
            AppMethodBeat.o(116982);
            return 0;
        } else if (mTs.nbE != null) {
            int i = mTs.nbE.ndJ;
            AppMethodBeat.o(116982);
            return i;
        } else {
            AppMethodBeat.o(116982);
            return 0;
        }
    }

    public static List<String> bDm() {
        AppMethodBeat.i(116983);
        if (mTs == null) {
            bDc();
        } else if (mTs.nbF != null) {
            LinkedList<dm> linkedList = mTs.nbF.nak;
            if (!bo.ek(linkedList)) {
                ArrayList arrayList = new ArrayList();
                for (dm dmVar : linkedList) {
                    if (!(dmVar == null || bo.isNullOrNil(dmVar.ndI))) {
                        arrayList.add(dmVar.ndI);
                    }
                }
                AppMethodBeat.o(116983);
                return arrayList;
            }
        }
        AppMethodBeat.o(116983);
        return null;
    }
}
