package com.tencent.p177mm.console.p845a;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.C34202c;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20846i;
import com.tencent.p177mm.plugin.websearch.api.C35573ai;
import com.tencent.p177mm.pluginsdk.cmd.C44041a;
import com.tencent.p177mm.pluginsdk.cmd.C44042b;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.protocal.protobuf.bdi;
import com.tencent.p177mm.protocal.protobuf.bdj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.IOException;
import java.util.Iterator;

/* renamed from: com.tencent.mm.console.a.b */
public final class C26058b implements C44041a {
    static {
        AppMethodBeat.m2504i(16127);
        C44042b.m79163a(new C26058b(), "//fts");
        AppMethodBeat.m2505o(16127);
    }

    public static void init() {
    }

    /* renamed from: a */
    public final boolean mo7165a(Context context, String[] strArr, String str) {
        AppMethodBeat.m2504i(16125);
        if (C4990ab.getLogLevel() > 1) {
            AppMethodBeat.m2505o(16125);
            return false;
        } else if (strArr.length < 2) {
            AppMethodBeat.m2505o(16125);
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
            C5728b c5728b;
            C20846i c20846i;
            switch (obj) {
                case null:
                    bdj cVo = C35573ai.cVo();
                    StringBuilder stringBuilder = new StringBuilder();
                    Iterator it = cVo.jBw.iterator();
                    while (it.hasNext()) {
                        bdi bdi = (bdi) it.next();
                        stringBuilder.append(String.format("%s | %.2f | %s", new Object[]{C1854s.m3866mJ(bdi.vHl), Double.valueOf(bdi.wHm), C14835h.formatTime(SQLiteLintUtil.YYYY_MM_DD_HH_mm, bdi.wHn / 1000)}));
                        stringBuilder.append(IOUtils.LINE_SEPARATOR_UNIX);
                    }
                    C26058b.m41597E(context, stringBuilder.toString());
                    break;
                case 1:
                    C9638aw.m17190ZK();
                    c5728b = new C5728b(C18628c.m29068Rt(), "FTS5IndexMicroMsg_encrypt.db");
                    if (c5728b.exists()) {
                        c5728b.delete();
                    }
                    Process.killProcess(Process.myPid());
                    break;
                case 2:
                    C9638aw.m17190ZK();
                    c5728b = new C5728b(C18628c.m29068Rt(), "FTS5IndexMicroMsg_encrypt.db");
                    C5728b c5728b2 = new C5728b("/sdcard/IndexMicroMsg.db");
                    if (c5728b2.exists()) {
                        c5728b2.delete();
                    }
                    C5730e.m8644y(C5736j.m8649w(c5728b.dMD()), C5736j.m8649w(c5728b2.dMD()));
                    break;
                case 3:
                    c20846i = new C20846i();
                    c20846i.hbo = 65522;
                    ((C12029n) C1720g.m3530M(C12029n.class)).search(Downloads.MIN_WAIT_FOR_NETWORK, c20846i);
                    break;
                case 4:
                    c20846i = new C20846i();
                    c20846i.query = strArr[2];
                    c20846i.hbo = 65523;
                    ((C12029n) C1720g.m3530M(C12029n.class)).search(Downloads.MIN_WAIT_FOR_NETWORK, c20846i);
                    break;
                case 5:
                    C5127a[] c5127aArr = new C5127a[]{C5127a.USERINFO_WEB_SEARCH_CONFIG_ZH_CN_STRING, C5127a.USERINFO_WEB_SEARCH_CONFIG_ZH_TW_STRING, C5127a.USERINFO_WEB_SEARCH_CONFIG_ZH_HK_STRING, C5127a.USERINFO_WEB_SEARCH_CONFIG_EN_STRING, C5127a.USERINFO_WEB_SEARCH_CONFIG_AR_STRING, C5127a.USERINFO_WEB_SEARCH_CONFIG_DE_STRING, C5127a.USERINFO_WEB_SEARCH_CONFIG_DE_DE_STRING, C5127a.USERINFO_WEB_SEARCH_CONFIG_ES_STRING, C5127a.USERINFO_WEB_SEARCH_CONFIG_FR_STRING, C5127a.USERINFO_WEB_SEARCH_CONFIG_HE_STRING, C5127a.USERINFO_WEB_SEARCH_CONFIG_HI_STRING, C5127a.USERINFO_WEB_SEARCH_CONFIG_ID_STRING, C5127a.USERINFO_WEB_SEARCH_CONFIG_IN_STRING, C5127a.USERINFO_WEB_SEARCH_CONFIG_IT_STRING, C5127a.USERINFO_WEB_SEARCH_CONFIG_IW_STRING, C5127a.USERINFO_WEB_SEARCH_CONFIG_JA_STRING, C5127a.USERINFO_WEB_SEARCH_CONFIG_KO_STRING, C5127a.USERINFO_WEB_SEARCH_CONFIG_LO_STRING, C5127a.USERINFO_WEB_SEARCH_CONFIG_MS_STRING, C5127a.USERINFO_WEB_SEARCH_CONFIG_MY_STRING, C5127a.USERINFO_WEB_SEARCH_CONFIG_PL_STRING, C5127a.USERINFO_WEB_SEARCH_CONFIG_PT_STRING, C5127a.USERINFO_WEB_SEARCH_CONFIG_RU_STRING, C5127a.USERINFO_WEB_SEARCH_CONFIG_TH_STRING, C5127a.USERINFO_WEB_SEARCH_CONFIG_TR_STRING, C5127a.USERINFO_WEB_SEARCH_CONFIG_VI_STRING};
                    for (int i = 0; i < 26; i++) {
                        C5127a c5127a = c5127aArr[i];
                        C9638aw.m17190ZK();
                        C18628c.m29072Ry().set(c5127a, (Object) "");
                    }
                    break;
                case 6:
                    c5728b = new C5728b(C34202c.mCx, "FTS5IndexMicroMsgInfo.txt");
                    if (c5728b.exists()) {
                        try {
                            C26058b.m41597E(context, C5730e.m8631cy(C5736j.m8649w(c5728b.dMD())));
                            break;
                        } catch (IOException e) {
                            break;
                        }
                    }
                    break;
                case 7:
                    c20846i = new C20846i();
                    c20846i.hbo = 65521;
                    c20846i.mEt = 100;
                    if (strArr.length > 2) {
                        try {
                            c20846i.mEt = Integer.valueOf(strArr[2]).intValue();
                        } catch (Exception e2) {
                        }
                    }
                    if (strArr.length > 3) {
                        c20846i.talker = strArr[3];
                    }
                    ((C12029n) C1720g.m3530M(C12029n.class)).search(Downloads.MIN_WAIT_FOR_NETWORK, c20846i);
                    break;
                case 8:
                    c20846i = new C20846i();
                    c20846i.hbo = 65524;
                    ((C12029n) C1720g.m3530M(C12029n.class)).search(Downloads.MIN_WAIT_FOR_NETWORK, c20846i);
                    break;
                case 9:
                    c20846i = new C20846i();
                    c20846i.hbo = 65525;
                    ((C12029n) C1720g.m3530M(C12029n.class)).search(Downloads.MIN_WAIT_FOR_NETWORK, c20846i);
                    break;
            }
            AppMethodBeat.m2505o(16125);
            return true;
        }
    }

    /* renamed from: E */
    private static void m41597E(Context context, String str) {
        AppMethodBeat.m2504i(16126);
        View textView = new TextView(context);
        textView.setText(str);
        textView.setGravity(19);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new LayoutParams(-1, -2));
        textView.setTextColor(-16711936);
        textView.setTypeface(Typeface.MONOSPACE);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C25738R.dimen.f9948l5);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        C30379h.m48435a(context, null, textView, null);
        AppMethodBeat.m2505o(16126);
    }
}
