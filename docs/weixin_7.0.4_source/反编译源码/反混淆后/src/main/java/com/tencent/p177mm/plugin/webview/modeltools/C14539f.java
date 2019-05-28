package com.tencent.p177mm.plugin.webview.modeltools;

import android.os.Bundle;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b.C9557a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p205bt.C1332b;
import com.tencent.p177mm.plugin.fts.p419a.C3163e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.websearch.api.C22757j;
import com.tencent.p177mm.protocal.protobuf.bzz;
import com.tencent.p177mm.protocal.protobuf.caa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.plugin.webview.modeltools.f */
public final class C14539f {
    private static String hlm = null;
    private static String uoL = null;
    private static C1332b uoM = null;

    /* renamed from: a */
    public static Bundle m22741a(Bundle bundle, String str, String str2) {
        AppMethodBeat.m2504i(6953);
        uoL = null;
        hlm = null;
        uoM = null;
        try {
            bzz bzz = new bzz();
            bzz.wYV = bundle.getString("PickedWord");
            bzz.wYW = bundle.getString("PrefixText");
            bzz.wYX = bundle.getString("SuffixText");
            bzz.Scene = bundle.getInt("Scene");
            bzz.wYY = bundle.getInt("MainIndex", -1);
            bzz.Url = str;
            bzz.Title = str2;
            bzz.wYZ = bundle.getString("SubPickedWord");
            bzz.wZa = bundle.getString("SubPrefixText");
            bzz.wZb = bundle.getString("SubSuffixText");
            bzz.wZc = bundle.getInt("SubIndex", -1);
            bzz.wZd = bundle.getInt("TagNewLineBefore", -1);
            bzz.wZe = bundle.getInt("TagNewLineAfter", -1);
            bzz.wZf = bundle.getInt("TagNewLineBeforeSub", -1);
            bzz.wZg = bundle.getInt("TagNewLineAfterSub", -1);
            C4990ab.m7417i("MicroMsg.SmartPickWordHelper", "req: PrefixText: %s, PickedWord: %s, SuffixText: %s", bzz.wYW, bzz.wYV, bzz.wYX);
            C1196a c1196a = new C1196a();
            c1196a.fsJ = bzz;
            c1196a.fsK = new caa();
            c1196a.uri = "/cgi-bin/mmsearch-bin/searchsmartpickword";
            c1196a.fsI = 2974;
            c1196a.fsL = 0;
            c1196a.fsM = 0;
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final Bundle bundle2 = new Bundle();
            C42146b.m74301a(c1196a.acD(), new C9557a() {
                /* renamed from: a */
                public final void mo5951a(int i, int i2, String str, C7472b c7472b) {
                    AppMethodBeat.m2504i(6952);
                    C4990ab.m7417i("MicroMsg.SmartPickWordHelper", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    if (i == 0 && i2 == 0) {
                        caa caa = (caa) c7472b.fsH.fsP;
                        bundle2.putString("PickedWord", caa.wYV);
                        bundle2.putInt("PrefixOffset", caa.wZh);
                        bundle2.putInt("SuffixOffset", caa.wZi);
                        bundle2.putString("PrefixText", caa.wYW);
                        bundle2.putString("SuffixText", caa.wYX);
                        bundle2.putInt("IsMainOrSub", caa.wZj);
                        C14539f.uoL = caa.wYV;
                        C14539f.uoM = caa.wZk;
                        C14539f.hlm = caa.wDM;
                        C4990ab.m7417i("MicroMsg.SmartPickWordHelper", "response: PrefixText: %s, PickedWord: %s, SuffixText: %s, %d, %d, %d", caa.wYW, caa.wYV, caa.wYX, Integer.valueOf(caa.wZh), Integer.valueOf(caa.wZi), Integer.valueOf(caa.wZj));
                        countDownLatch.countDown();
                        AppMethodBeat.m2505o(6952);
                        return;
                    }
                    countDownLatch.countDown();
                    AppMethodBeat.m2505o(6952);
                }
            });
            try {
                countDownLatch.await(1000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                C4990ab.m7420w("MicroMsg.SmartPickWordHelper", e.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.SmartPickWordHelper", e, "", new Object[0]);
            }
            C4990ab.m7416i("MicroMsg.SmartPickWordHelper", "smartPickWord end");
            AppMethodBeat.m2505o(6953);
            return bundle2;
        } catch (Exception e2) {
            C4990ab.m7412e("MicroMsg.SmartPickWordHelper", "smartPickWord url failed");
            AppMethodBeat.m2505o(6953);
            return null;
        }
    }

    /* renamed from: U */
    public static void m22739U(Bundle bundle) {
        AppMethodBeat.m2504i(6954);
        if (bundle == null) {
            AppMethodBeat.m2505o(6954);
            return;
        }
        if (hlm != null) {
            bundle.putString("searchId", hlm);
        }
        if (uoM != null) {
            bundle.putString("extQueryInfo", uoM.dlY());
        }
        AppMethodBeat.m2505o(6954);
    }

    /* renamed from: V */
    public static boolean m22740V(Bundle bundle) {
        AppMethodBeat.m2504i(6955);
        String string = bundle.getString(SearchIntents.EXTRA_QUERY);
        String string2 = bundle.getString("searchId");
        String string3 = bundle.getString("extQueryInfo");
        if (C5046bo.isNullOrNil(string)) {
            AppMethodBeat.m2505o(6955);
        } else {
            String str = C3163e.mCM;
            HashMap hashMap = new HashMap();
            String str2 = null;
            if (string2 != null) {
                str2 = "18:" + string2 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + string + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D;
                hashMap.put("parentSearchID", str2);
            }
            if (str2 != null) {
                C37922v.m64076Zp().mo60676y(str2, true).mo53356j("extQueryInfo", string3);
            }
            hashMap.put("clickType", "18");
            ((C22757j) C1720g.m3528K(C22757j.class)).mo38334a(C4996ah.getContext(), 17, string, str, hashMap);
            AppMethodBeat.m2505o(6955);
        }
        return false;
    }

    /* renamed from: hc */
    public static void m22743hc(String str, String str2) {
        int i = 1;
        AppMethodBeat.m2504i(6956);
        int i2 = (C5046bo.isNullOrNil(uoL) || C5046bo.isEqual(str, uoL)) ? 0 : 1;
        String str3 = "";
        String str4 = "";
        String str5 = "";
        try {
            str3 = URLEncoder.encode(C5046bo.nullAsNil(str2), "UTF-8");
            str4 = URLEncoder.encode(C5046bo.nullAsNil(str), "UTF-8");
            str5 = URLEncoder.encode(C5046bo.nullAsNil(uoL), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            C4990ab.printErrStackTrace("MicroMsg.SmartPickWordHelper", e, "", new Object[0]);
        }
        C7060h c7060h = C7060h.pYm;
        Object[] objArr = new Object[6];
        objArr[0] = Integer.valueOf(2);
        objArr[1] = str3;
        objArr[2] = str5;
        objArr[3] = str4;
        if (i2 == 0) {
            i = 0;
        }
        objArr[4] = Integer.valueOf(i);
        objArr[5] = hlm;
        c7060h.mo8381e(13742, objArr);
        AppMethodBeat.m2505o(6956);
    }

    /* renamed from: p */
    public static void m22744p(String str, Bundle bundle) {
        boolean z;
        int i = 0;
        AppMethodBeat.m2504i(6957);
        if (bundle != null) {
            z = bundle.getBoolean("IsCursorMove", false);
        } else {
            z = false;
        }
        String str2 = "";
        try {
            str2 = URLEncoder.encode(C5046bo.nullAsNil(str), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            C4990ab.printErrStackTrace("MicroMsg.SmartPickWordHelper", e, "", new Object[0]);
        }
        C7060h c7060h = C7060h.pYm;
        Object[] objArr = new Object[7];
        objArr[0] = Integer.valueOf(1);
        objArr[1] = str2;
        objArr[2] = "";
        objArr[3] = "";
        if (z) {
            i = 3;
        }
        objArr[4] = Integer.valueOf(i);
        objArr[5] = "";
        objArr[6] = hlm;
        c7060h.mo8381e(13742, objArr);
        AppMethodBeat.m2505o(6957);
    }

    public static void aeU(String str) {
        AppMethodBeat.m2504i(6958);
        String str2 = "";
        try {
            str2 = URLEncoder.encode(C5046bo.nullAsNil(str), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            C4990ab.printErrStackTrace("MicroMsg.SmartPickWordHelper", e, "", new Object[0]);
        }
        C7060h.pYm.mo8381e(13742, Integer.valueOf(1), str2, "", "", Integer.valueOf(4), hlm);
        AppMethodBeat.m2505o(6958);
    }
}
