package com.tencent.mm.plugin.webview.modeltools;

import android.os.Bundle;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.bt.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.j;
import com.tencent.mm.protocal.protobuf.bzz;
import com.tencent.mm.protocal.protobuf.caa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class f {
    private static String hlm = null;
    private static String uoL = null;
    private static b uoM = null;

    public static Bundle a(Bundle bundle, String str, String str2) {
        AppMethodBeat.i(6953);
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
            ab.i("MicroMsg.SmartPickWordHelper", "req: PrefixText: %s, PickedWord: %s, SuffixText: %s", bzz.wYW, bzz.wYV, bzz.wYX);
            a aVar = new a();
            aVar.fsJ = bzz;
            aVar.fsK = new caa();
            aVar.uri = "/cgi-bin/mmsearch-bin/searchsmartpickword";
            aVar.fsI = 2974;
            aVar.fsL = 0;
            aVar.fsM = 0;
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final Bundle bundle2 = new Bundle();
            com.tencent.mm.ipcinvoker.wx_extension.b.a(aVar.acD(), new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
                public final void a(int i, int i2, String str, com.tencent.mm.ai.b bVar) {
                    AppMethodBeat.i(6952);
                    ab.i("MicroMsg.SmartPickWordHelper", "onSceneEnd errType = %d, errCode = %d ,errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    if (i == 0 && i2 == 0) {
                        caa caa = (caa) bVar.fsH.fsP;
                        bundle2.putString("PickedWord", caa.wYV);
                        bundle2.putInt("PrefixOffset", caa.wZh);
                        bundle2.putInt("SuffixOffset", caa.wZi);
                        bundle2.putString("PrefixText", caa.wYW);
                        bundle2.putString("SuffixText", caa.wYX);
                        bundle2.putInt("IsMainOrSub", caa.wZj);
                        f.uoL = caa.wYV;
                        f.uoM = caa.wZk;
                        f.hlm = caa.wDM;
                        ab.i("MicroMsg.SmartPickWordHelper", "response: PrefixText: %s, PickedWord: %s, SuffixText: %s, %d, %d, %d", caa.wYW, caa.wYV, caa.wYX, Integer.valueOf(caa.wZh), Integer.valueOf(caa.wZi), Integer.valueOf(caa.wZj));
                        countDownLatch.countDown();
                        AppMethodBeat.o(6952);
                        return;
                    }
                    countDownLatch.countDown();
                    AppMethodBeat.o(6952);
                }
            });
            try {
                countDownLatch.await(1000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                ab.w("MicroMsg.SmartPickWordHelper", e.getMessage());
                ab.printErrStackTrace("MicroMsg.SmartPickWordHelper", e, "", new Object[0]);
            }
            ab.i("MicroMsg.SmartPickWordHelper", "smartPickWord end");
            AppMethodBeat.o(6953);
            return bundle2;
        } catch (Exception e2) {
            ab.e("MicroMsg.SmartPickWordHelper", "smartPickWord url failed");
            AppMethodBeat.o(6953);
            return null;
        }
    }

    public static void U(Bundle bundle) {
        AppMethodBeat.i(6954);
        if (bundle == null) {
            AppMethodBeat.o(6954);
            return;
        }
        if (hlm != null) {
            bundle.putString("searchId", hlm);
        }
        if (uoM != null) {
            bundle.putString("extQueryInfo", uoM.dlY());
        }
        AppMethodBeat.o(6954);
    }

    public static boolean V(Bundle bundle) {
        AppMethodBeat.i(6955);
        String string = bundle.getString(SearchIntents.EXTRA_QUERY);
        String string2 = bundle.getString("searchId");
        String string3 = bundle.getString("extQueryInfo");
        if (bo.isNullOrNil(string)) {
            AppMethodBeat.o(6955);
        } else {
            String str = e.mCM;
            HashMap hashMap = new HashMap();
            String str2 = null;
            if (string2 != null) {
                str2 = "18:" + string2 + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + string + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D;
                hashMap.put("parentSearchID", str2);
            }
            if (str2 != null) {
                v.Zp().y(str2, true).j("extQueryInfo", string3);
            }
            hashMap.put("clickType", "18");
            ((j) g.K(j.class)).a(ah.getContext(), 17, string, str, hashMap);
            AppMethodBeat.o(6955);
        }
        return false;
    }

    public static void hc(String str, String str2) {
        int i = 1;
        AppMethodBeat.i(6956);
        int i2 = (bo.isNullOrNil(uoL) || bo.isEqual(str, uoL)) ? 0 : 1;
        String str3 = "";
        String str4 = "";
        String str5 = "";
        try {
            str3 = URLEncoder.encode(bo.nullAsNil(str2), "UTF-8");
            str4 = URLEncoder.encode(bo.nullAsNil(str), "UTF-8");
            str5 = URLEncoder.encode(bo.nullAsNil(uoL), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            ab.printErrStackTrace("MicroMsg.SmartPickWordHelper", e, "", new Object[0]);
        }
        h hVar = h.pYm;
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
        hVar.e(13742, objArr);
        AppMethodBeat.o(6956);
    }

    public static void p(String str, Bundle bundle) {
        boolean z;
        int i = 0;
        AppMethodBeat.i(6957);
        if (bundle != null) {
            z = bundle.getBoolean("IsCursorMove", false);
        } else {
            z = false;
        }
        String str2 = "";
        try {
            str2 = URLEncoder.encode(bo.nullAsNil(str), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            ab.printErrStackTrace("MicroMsg.SmartPickWordHelper", e, "", new Object[0]);
        }
        h hVar = h.pYm;
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
        hVar.e(13742, objArr);
        AppMethodBeat.o(6957);
    }

    public static void aeU(String str) {
        AppMethodBeat.i(6958);
        String str2 = "";
        try {
            str2 = URLEncoder.encode(bo.nullAsNil(str), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            ab.printErrStackTrace("MicroMsg.SmartPickWordHelper", e, "", new Object[0]);
        }
        h.pYm.e(13742, Integer.valueOf(1), str2, "", "", Integer.valueOf(4), hlm);
        AppMethodBeat.o(6958);
    }
}
