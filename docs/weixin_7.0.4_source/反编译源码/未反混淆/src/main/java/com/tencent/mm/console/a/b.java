package com.tencent.mm.console.a;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.pluginsdk.cmd.a;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.protocal.protobuf.bdi;
import com.tencent.mm.protocal.protobuf.bdj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.IOException;
import java.util.Iterator;

public final class b implements a {
    static {
        AppMethodBeat.i(16127);
        com.tencent.mm.pluginsdk.cmd.b.a(new b(), "//fts");
        AppMethodBeat.o(16127);
    }

    public static void init() {
    }

    public final boolean a(Context context, String[] strArr, String str) {
        AppMethodBeat.i(16125);
        if (ab.getLogLevel() > 1) {
            AppMethodBeat.o(16125);
            return false;
        } else if (strArr.length < 2) {
            AppMethodBeat.o(16125);
            return true;
        } else {
            String str2 = strArr[1];
            Object obj = -1;
            switch (str2.hashCode()) {
                case -1354714445:
                    if (str2.equals("copydb")) {
                        obj = 2;
                        break;
                    }
                    break;
                case -1183792455:
                    if (str2.equals("insert")) {
                        obj = 7;
                        break;
                    }
                    break;
                case -1132164145:
                    if (str2.equals("clearconfig")) {
                        obj = 5;
                        break;
                    }
                    break;
                case -617644996:
                    if (str2.equals("clearunread")) {
                        obj = 8;
                        break;
                    }
                    break;
                case 3237038:
                    if (str2.equals("info")) {
                        obj = 6;
                        break;
                    }
                    break;
                case 104187309:
                    if (str2.equals("msbiz")) {
                        obj = null;
                        break;
                    }
                    break;
                case 819712873:
                    if (str2.equals("deletedb")) {
                        obj = 1;
                        break;
                    }
                    break;
                case 955180557:
                    if (str2.equals("corrupt")) {
                        obj = 3;
                        break;
                    }
                    break;
                case 967115467:
                    if (str2.equals("inserttest")) {
                        obj = 9;
                        break;
                    }
                    break;
                case 1873247692:
                    if (str2.equals("addchatroomcontact")) {
                        obj = 4;
                        break;
                    }
                    break;
            }
            com.tencent.mm.vfs.b bVar;
            i iVar;
            switch (obj) {
                case null:
                    bdj cVo = ai.cVo();
                    StringBuilder stringBuilder = new StringBuilder();
                    Iterator it = cVo.jBw.iterator();
                    while (it.hasNext()) {
                        bdi bdi = (bdi) it.next();
                        stringBuilder.append(String.format("%s | %.2f | %s", new Object[]{s.mJ(bdi.vHl), Double.valueOf(bdi.wHm), h.formatTime(SQLiteLintUtil.YYYY_MM_DD_HH_mm, bdi.wHn / 1000)}));
                        stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
                    }
                    E(context, stringBuilder.toString());
                    break;
                case 1:
                    aw.ZK();
                    bVar = new com.tencent.mm.vfs.b(c.Rt(), "FTS5IndexMicroMsg_encrypt.db");
                    if (bVar.exists()) {
                        bVar.delete();
                    }
                    Process.killProcess(Process.myPid());
                    break;
                case 2:
                    aw.ZK();
                    bVar = new com.tencent.mm.vfs.b(c.Rt(), "FTS5IndexMicroMsg_encrypt.db");
                    com.tencent.mm.vfs.b bVar2 = new com.tencent.mm.vfs.b("/sdcard/IndexMicroMsg.db");
                    if (bVar2.exists()) {
                        bVar2.delete();
                    }
                    e.y(j.w(bVar.dMD()), j.w(bVar2.dMD()));
                    break;
                case 3:
                    iVar = new i();
                    iVar.hbo = 65522;
                    ((n) g.M(n.class)).search(Downloads.MIN_WAIT_FOR_NETWORK, iVar);
                    break;
                case 4:
                    iVar = new i();
                    iVar.query = strArr[2];
                    iVar.hbo = 65523;
                    ((n) g.M(n.class)).search(Downloads.MIN_WAIT_FOR_NETWORK, iVar);
                    break;
                case 5:
                    ac.a[] aVarArr = new ac.a[]{ac.a.USERINFO_WEB_SEARCH_CONFIG_ZH_CN_STRING, ac.a.USERINFO_WEB_SEARCH_CONFIG_ZH_TW_STRING, ac.a.USERINFO_WEB_SEARCH_CONFIG_ZH_HK_STRING, ac.a.USERINFO_WEB_SEARCH_CONFIG_EN_STRING, ac.a.USERINFO_WEB_SEARCH_CONFIG_AR_STRING, ac.a.USERINFO_WEB_SEARCH_CONFIG_DE_STRING, ac.a.USERINFO_WEB_SEARCH_CONFIG_DE_DE_STRING, ac.a.USERINFO_WEB_SEARCH_CONFIG_ES_STRING, ac.a.USERINFO_WEB_SEARCH_CONFIG_FR_STRING, ac.a.USERINFO_WEB_SEARCH_CONFIG_HE_STRING, ac.a.USERINFO_WEB_SEARCH_CONFIG_HI_STRING, ac.a.USERINFO_WEB_SEARCH_CONFIG_ID_STRING, ac.a.USERINFO_WEB_SEARCH_CONFIG_IN_STRING, ac.a.USERINFO_WEB_SEARCH_CONFIG_IT_STRING, ac.a.USERINFO_WEB_SEARCH_CONFIG_IW_STRING, ac.a.USERINFO_WEB_SEARCH_CONFIG_JA_STRING, ac.a.USERINFO_WEB_SEARCH_CONFIG_KO_STRING, ac.a.USERINFO_WEB_SEARCH_CONFIG_LO_STRING, ac.a.USERINFO_WEB_SEARCH_CONFIG_MS_STRING, ac.a.USERINFO_WEB_SEARCH_CONFIG_MY_STRING, ac.a.USERINFO_WEB_SEARCH_CONFIG_PL_STRING, ac.a.USERINFO_WEB_SEARCH_CONFIG_PT_STRING, ac.a.USERINFO_WEB_SEARCH_CONFIG_RU_STRING, ac.a.USERINFO_WEB_SEARCH_CONFIG_TH_STRING, ac.a.USERINFO_WEB_SEARCH_CONFIG_TR_STRING, ac.a.USERINFO_WEB_SEARCH_CONFIG_VI_STRING};
                    for (int i = 0; i < 26; i++) {
                        ac.a aVar = aVarArr[i];
                        aw.ZK();
                        c.Ry().set(aVar, (Object) "");
                    }
                    break;
                case 6:
                    bVar = new com.tencent.mm.vfs.b(com.tencent.mm.plugin.fts.a.c.mCx, "FTS5IndexMicroMsgInfo.txt");
                    if (bVar.exists()) {
                        try {
                            E(context, e.cy(j.w(bVar.dMD())));
                            break;
                        } catch (IOException e) {
                            break;
                        }
                    }
                    break;
                case 7:
                    iVar = new i();
                    iVar.hbo = 65521;
                    iVar.mEt = 100;
                    if (strArr.length > 2) {
                        try {
                            iVar.mEt = Integer.valueOf(strArr[2]).intValue();
                        } catch (Exception e2) {
                        }
                    }
                    if (strArr.length > 3) {
                        iVar.talker = strArr[3];
                    }
                    ((n) g.M(n.class)).search(Downloads.MIN_WAIT_FOR_NETWORK, iVar);
                    break;
                case 8:
                    iVar = new i();
                    iVar.hbo = 65524;
                    ((n) g.M(n.class)).search(Downloads.MIN_WAIT_FOR_NETWORK, iVar);
                    break;
                case 9:
                    iVar = new i();
                    iVar.hbo = 65525;
                    ((n) g.M(n.class)).search(Downloads.MIN_WAIT_FOR_NETWORK, iVar);
                    break;
            }
            AppMethodBeat.o(16125);
            return true;
        }
    }

    private static void E(Context context, String str) {
        AppMethodBeat.i(16126);
        View textView = new TextView(context);
        textView.setText(str);
        textView.setGravity(19);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new LayoutParams(-1, -2));
        textView.setTextColor(-16711936);
        textView.setTypeface(Typeface.MONOSPACE);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.l5);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        com.tencent.mm.ui.base.h.a(context, null, textView, null);
        AppMethodBeat.o(16126);
    }
}
