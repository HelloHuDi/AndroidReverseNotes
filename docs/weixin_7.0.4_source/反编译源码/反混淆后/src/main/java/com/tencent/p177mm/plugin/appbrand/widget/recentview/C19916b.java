package com.tencent.p177mm.plugin.appbrand.widget.recentview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.b */
public final class C19916b {
    long jmK = 0;
    public int jmL;
    int jmM;
    int jmN;
    public int jmO;
    public int jmP;
    int jmQ;
    int jmR;
    StringBuilder jmS = new StringBuilder();
    StringBuilder jmT = new StringBuilder();
    StringBuilder jmU = new StringBuilder();
    StringBuilder jmV = new StringBuilder();
    int jmW;
    public int jmX;
    public int jmY;
    int jmZ;
    public int jna;
    public int jnb;
    public int jnc;
    StringBuilder jnd = new StringBuilder();
    StringBuilder jne = new StringBuilder();
    public StringBuilder jnf = new StringBuilder();
    StringBuilder jng = new StringBuilder();
    public StringBuilder jnh = new StringBuilder();
    public StringBuilder jnj = new StringBuilder();
    public int jnk;
    public int jnl;
    public int jnm;
    public boolean jnn;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.b$1 */
    class C199171 implements Runnable {
        C199171() {
        }

        public final void run() {
            AppMethodBeat.m2504i(114931);
            if (C19916b.this.jmK <= 0) {
                C4990ab.m7410d("MicroMsg.AppBrandRecentViewReporter", "[report] mOpenTime <= 0");
                AppMethodBeat.m2505o(114931);
                return;
            }
            C4990ab.m7417i("MicroMsg.AppBrandRecentViewReporter", "[report] mOpenTime: %s, mRecentCountAtOpen: %s, mRecentCountAtClose: %s, mCloseType: %s, mScrollRecentCount: %s, mOpenRecentAppBrandList: %s, mDeleteRecentCount: %s, mDeleteRecentAppBrandList: %s, \ndragCountWhenClose: %d, mStarCountAtOpen: %d, mStarCountAtClose: %d, mScrollStarCount: %d, mOpenStarAppBrandList: %s, mDeleteStarCount: %d, mDeleteStarAppBrandList: %s, \nmMoveToFirstCount: %d, mClickRecentAppBrandList: %s, mClickStarAppBrandList: %s, mMoveStarAppBrandToFirstList: %s, mAddCollectionCount: %d, mAddCollectionAppBrandList: %s", Long.valueOf(C19916b.this.jmK), Integer.valueOf(C19916b.this.jmN), Integer.valueOf(C19916b.this.jmO), Integer.valueOf(C19916b.this.jmL), Integer.valueOf(C19916b.this.jmP), C19916b.this.jmS.toString(), Integer.valueOf(C19916b.this.jmQ), C19916b.this.jmT.toString(), Integer.valueOf(C19916b.this.jmM), Integer.valueOf(C19916b.this.jmW), Integer.valueOf(C19916b.this.jmX), Integer.valueOf(C19916b.this.jmY), C19916b.this.jnd.toString(), Integer.valueOf(C19916b.this.jmZ), C19916b.this.jne.toString(), Integer.valueOf(C19916b.this.jna), C19916b.this.jmU.toString(), C19916b.this.jng.toString(), C19916b.this.jnf.toString(), Integer.valueOf(C19916b.this.jmR), C19916b.this.jmV.toString());
            C7060h.pYm.mo8381e(15081, Long.valueOf(C19916b.this.jmK), Integer.valueOf(C19916b.this.jmN), Integer.valueOf(C19916b.this.jmO), Integer.valueOf(C19916b.this.jmL), Integer.valueOf(C19916b.this.jmP), C19916b.this.jmS.toString(), Integer.valueOf(C19916b.this.jmQ), C19916b.this.jmT.toString(), Integer.valueOf(C19916b.this.jmM), Integer.valueOf(C19916b.this.jmW), Integer.valueOf(C19916b.this.jmX), Integer.valueOf(C19916b.this.jmY), C19916b.this.jnd.toString(), Integer.valueOf(C19916b.this.jmZ), C19916b.this.jne.toString(), Integer.valueOf(C19916b.this.jna), C19916b.this.jmU.toString(), C19916b.this.jng.toString(), C19916b.this.jnf.toString(), Integer.valueOf(C19916b.this.jmR), C19916b.this.jmV.toString());
            C19916b.m30808a(C19916b.this);
            AppMethodBeat.m2505o(114931);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.b$2 */
    public class C199182 implements Runnable {
        public final void run() {
            int i = 1;
            AppMethodBeat.m2504i(114932);
            if (C19916b.this.jmK <= 0) {
                C4990ab.m7410d("MicroMsg.AppBrandRecentViewReporter", "[report] mOpenTime <= 0");
                AppMethodBeat.m2505o(114932);
                return;
            }
            C4990ab.m7417i("MicroMsg.AppBrandRecentViewReporter", "mOpenTime: %d, mRecentCountAtOpen: %d, mRecentCountAtClose: %d, mCloseType: %d, mOpenRecentAppBrandList: %s, mDeleteRecentCount: %d, mDeleteRecentAppBrandList: %s,\nmStarCountAtOpen: %d, mStarCountAtClose: %d, mOpenStarAppBrandList: %s, mDeleteStarCount: %d, mDeleteStarAppBrandList: %s,\nmClickRecentAppBrandList: %s, mClickStarAppBrandList: %s, mAddCollectionCount: %d, mAddCollectionAppBrandList: %s, fullScreen: %b,\nmMoveStarAppBrandForwardCount: %d, mMoveStarAppBrandBackwardCount: %d, mScrollUpDown: %d, mShowSearchViewCount: %d, mClickSearchViewCount: %d,\nmMoveStarAppBrandForwardList: %s, mMoveStarAppBrandBackwardList: %s, mEnableNativeDynamicBackground: %b", Long.valueOf(C19916b.this.jmK), Integer.valueOf(C19916b.this.jmN), Integer.valueOf(C19916b.this.jmO), Integer.valueOf(C19916b.this.jmL), C19916b.this.jmS.toString(), Integer.valueOf(C19916b.this.jmQ), C19916b.this.jmT.toString(), Integer.valueOf(C19916b.this.jmW), Integer.valueOf(C19916b.this.jmX), C19916b.this.jnd.toString(), Integer.valueOf(C19916b.this.jmZ), C19916b.this.jne.toString(), C19916b.this.jmU.toString(), C19916b.this.jng.toString(), Integer.valueOf(C19916b.this.jmR), C19916b.this.jmV.toString(), Boolean.TRUE, Integer.valueOf(C19916b.this.jnb), Integer.valueOf(C19916b.this.jnc), Integer.valueOf(C19916b.this.jnk), Integer.valueOf(C19916b.this.jnl), Integer.valueOf(C19916b.this.jnm), C19916b.this.jnh.toString(), C19916b.this.jnj.toString(), Boolean.valueOf(C19916b.this.jnn));
            C7060h c7060h = C7060h.pYm;
            Object[] objArr = new Object[32];
            objArr[0] = Long.valueOf(C19916b.this.jmK);
            objArr[1] = Integer.valueOf(C19916b.this.jmN);
            objArr[2] = Integer.valueOf(C19916b.this.jmO);
            objArr[3] = Integer.valueOf(C19916b.this.jmL);
            objArr[4] = Integer.valueOf(0);
            objArr[5] = C19916b.this.jmS.toString();
            objArr[6] = Integer.valueOf(C19916b.this.jmQ);
            objArr[7] = C19916b.this.jmT.toString();
            objArr[8] = Integer.valueOf(0);
            objArr[9] = Integer.valueOf(C19916b.this.jmW);
            objArr[10] = Integer.valueOf(C19916b.this.jmX);
            objArr[11] = Integer.valueOf(0);
            objArr[12] = C19916b.this.jnd.toString();
            objArr[13] = Integer.valueOf(C19916b.this.jmZ);
            objArr[14] = C19916b.this.jne.toString();
            objArr[15] = Integer.valueOf(0);
            objArr[16] = C19916b.this.jmU.toString();
            objArr[17] = C19916b.this.jng.toString();
            objArr[18] = "";
            objArr[19] = Integer.valueOf(C19916b.this.jmR);
            objArr[20] = C19916b.this.jmV.toString();
            objArr[21] = Integer.valueOf(1);
            objArr[22] = Integer.valueOf(0);
            objArr[23] = Integer.valueOf(0);
            objArr[24] = Integer.valueOf(C19916b.this.jnb);
            objArr[25] = Integer.valueOf(C19916b.this.jnc);
            objArr[26] = Integer.valueOf(C19916b.this.jnk);
            objArr[27] = Integer.valueOf(C19916b.this.jnl);
            objArr[28] = Integer.valueOf(C19916b.this.jnm);
            objArr[29] = C19916b.this.jnh.toString();
            objArr[30] = C19916b.this.jnj.toString();
            if (!C19916b.this.jnn) {
                i = 0;
            }
            objArr[31] = Integer.valueOf(i);
            c7060h.mo8381e(15081, objArr);
            C19916b.m30808a(C19916b.this);
            AppMethodBeat.m2505o(114932);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.recentview.b$a */
    static class C19919a {
        String jnp;
        StringBuilder jnq = new StringBuilder();
        StringBuilder jnr = new StringBuilder();
        StringBuilder jns = new StringBuilder();
        StringBuilder jnt = new StringBuilder();
        StringBuilder jnu = new StringBuilder();
        StringBuilder jnv = new StringBuilder();

        public C19919a(String str) {
            AppMethodBeat.m2504i(114933);
            this.jnp = str;
            AppMethodBeat.m2505o(114933);
        }

        public final String toString() {
            AppMethodBeat.m2504i(114934);
            String format = String.format("DuplicateNameInfo: {duplicatedName: %s, appId: %s, \nnameType: %s, \nlistType: %s, \nposition: %s, \nversion: %s, \nversionType: %s", new Object[]{this.jnp, this.jnq.toString(), this.jnr.toString(), this.jns.toString(), this.jnt.toString(), this.jnu.toString(), this.jnv.toString()});
            AppMethodBeat.m2505o(114934);
            return format;
        }
    }

    public C19916b() {
        AppMethodBeat.m2504i(114935);
        AppMethodBeat.m2505o(114935);
    }

    /* renamed from: dw */
    public final void mo35163dw(int i, int i2) {
        AppMethodBeat.m2504i(114936);
        this.jmK = System.currentTimeMillis() / 1000;
        this.jmN = i;
        this.jmW = i2;
        AppMethodBeat.m2505o(114936);
    }

    /* renamed from: N */
    public final void mo35159N(int i, int i2, int i3) {
        AppMethodBeat.m2504i(114937);
        this.jmO = i;
        this.jmX = i2;
        this.jmL = i3;
        C7305d.xDG.execute(new C199171());
        AppMethodBeat.m2505o(114937);
    }

    public final void aRY() {
        this.jmM++;
    }

    /* renamed from: bA */
    public final void mo35161bA(String str, int i) {
        AppMethodBeat.m2504i(114938);
        C4990ab.m7419v("MicroMsg.AppBrandRecentViewReporter", "alvinluo openRecentAppBrand id: %s, pos: %d", str, Integer.valueOf(i));
        this.jmS.append(str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        this.jmU.append(i + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        AppMethodBeat.m2505o(114938);
    }

    /* renamed from: bB */
    public final void mo35162bB(String str, int i) {
        AppMethodBeat.m2504i(114939);
        C4990ab.m7419v("MicroMsg.AppBrandRecentViewReporter", "alvinluo openStarAppBrand id: %s, pos: %d", str, Integer.valueOf(i));
        this.jnd.append(str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        this.jng.append(i + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        AppMethodBeat.m2505o(114939);
    }

    /* renamed from: ER */
    public final void mo35156ER(String str) {
        AppMethodBeat.m2504i(114940);
        C4990ab.m7419v("MicroMsg.AppBrandRecentViewReporter", "alvinluo deleteRecentAppBrand id: %s", str);
        this.jmQ++;
        this.jmT.append(str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        AppMethodBeat.m2505o(114940);
    }

    /* renamed from: ES */
    public final void mo35157ES(String str) {
        AppMethodBeat.m2504i(114941);
        C4990ab.m7419v("MicroMsg.AppBrandRecentViewReporter", "alvinluo deleteStarAppBrand id: %s", str);
        this.jmZ++;
        this.jne.append(str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        AppMethodBeat.m2505o(114941);
    }

    /* renamed from: ET */
    public final void mo35158ET(String str) {
        AppMethodBeat.m2504i(114942);
        C4990ab.m7419v("MicroMsg.AppBrandRecentViewReporter", "alvinluo addRecentAppBrandToCollection id: %s", str);
        this.jmR++;
        this.jmV.append(str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        AppMethodBeat.m2505o(114942);
    }

    /* renamed from: f */
    public static void m30809f(List<C42748a> list, List<C42748a> list2) {
        C42748a c42748a;
        AppMethodBeat.m2504i(114943);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(list);
        arrayList.addAll(list2);
        HashMap hashMap = new HashMap();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                break;
            }
            c42748a = (C42748a) arrayList.get(i2);
            if (!(c42748a == null || c42748a.iXW == null || C5046bo.isNullOrNil(c42748a.iXW.appId) || C5046bo.isNullOrNil(c42748a.iXW.nickname))) {
                int i3;
                Map map;
                HashMap hashMap2;
                int i4 = i2 < list.size() ? 2 : 1;
                if (i2 < list.size()) {
                    i3 = i2 - 1;
                } else {
                    i3 = (i2 - 1) - list.size();
                }
                C4990ab.m7411d("MicroMsg.AppBrandRecentViewReporter", "alvinluo nickName: %s, type: %d, pos: %d", c42748a.iXW.nickname, Integer.valueOf(i4), Integer.valueOf(i3));
                String str = c42748a.iXW.appId + "," + c42748a.iXW.har + "," + i4 + "," + i3;
                if (hashMap.containsKey(c42748a.iXW.nickname)) {
                    C4990ab.m7411d("MicroMsg.AppBrandRecentViewReporter", "alvinluo contains nickName: %s", c42748a.iXW.nickname);
                    map = (Map) hashMap.get(c42748a.iXW.nickname);
                    if (!map.containsKey(str)) {
                        map.put(str, c42748a);
                    }
                } else {
                    C4990ab.m7411d("MicroMsg.AppBrandRecentViewReporter", "alvinluo not contains nickName: %s", c42748a.iXW.nickname);
                    hashMap2 = new HashMap();
                    hashMap2.put(str, c42748a);
                    hashMap.put(c42748a.iXW.nickname, hashMap2);
                }
                if (C5046bo.isNullOrNil(c42748a.iXW.bQo)) {
                    C4990ab.m7410d("MicroMsg.AppBrandRecentViewReporter", "alvinluo not shortNickName");
                } else if (c42748a.iXW.nickname.equals(c42748a.iXW.bQo)) {
                    C4990ab.m7413e("MicroMsg.AppBrandRecentViewReporter", "alvinluo nickname equals shortNickName %s, %s", c42748a.iXW.nickname, c42748a.iXW.bQo);
                } else if (hashMap.containsKey(c42748a.iXW.bQo)) {
                    C4990ab.m7411d("MicroMsg.AppBrandRecentViewReporter", "alvinluo contains shortNickname: %s", c42748a.iXW.bQo);
                    map = (Map) hashMap.get(c42748a.iXW.bQo);
                    if (!map.containsKey(str)) {
                        map.put(str, c42748a);
                    }
                } else {
                    C4990ab.m7411d("MicroMsg.AppBrandRecentViewReporter", "alvinluo not contains shortNickname: %s", c42748a.iXW.bQo);
                    hashMap2 = new HashMap();
                    hashMap2.put(str, c42748a);
                    hashMap.put(c42748a.iXW.bQo, hashMap2);
                }
            }
            i = i2 + 1;
        }
        for (String str2 : hashMap.keySet()) {
            Map map2 = (Map) hashMap.get(str2);
            if (map2 == null || map2.size() <= 1) {
                C4990ab.m7411d("MicroMsg.AppBrandRecentViewReporter", "alvinluo name %s not duplicated", str2);
            } else {
                Set<String> keySet = map2.keySet();
                HashMap hashMap3 = new HashMap();
                for (String str3 : keySet) {
                    c42748a = (C42748a) map2.get(str3);
                    if (!(c42748a == null || c42748a.iXW == null || C5046bo.isNullOrNil(c42748a.iXW.appId) || hashMap3.containsKey(c42748a.iXW.appId))) {
                        hashMap3.put(c42748a.iXW.appId, c42748a);
                    }
                }
                if (hashMap3.size() <= 1) {
                    C4990ab.m7411d("MicroMsg.AppBrandRecentViewReporter", "alvinluo name %s not duplicated2", str2);
                } else {
                    C19919a c19919a = new C19919a(str2);
                    for (String str32 : keySet) {
                        String[] split = str32.split(",");
                        String str4 = split[2];
                        int intValue = Integer.valueOf(split[3]).intValue();
                        c42748a = (C42748a) map2.get(str32);
                        if (!(c42748a == null || c42748a.iXW == null)) {
                            C4990ab.m7411d("MicroMsg.AppBrandRecentViewReporter", "alvinluo duplicated appId: %s, name: %s, shortName: %s, type: %s, pos: %d", c42748a.iXW.appId, c42748a.iXW.nickname, c42748a.iXW.bQo, str4, Integer.valueOf(intValue));
                            if (str2.equals(c42748a.iXW.bQo)) {
                                c19919a.jnq.append(c42748a.iXW.appId).append("#");
                                c19919a.jnr.append("1#");
                                c19919a.jns.append(str4).append("#");
                                c19919a.jnt.append(intValue).append("#");
                                c19919a.jnu.append(c42748a.iXW.axy).append("#");
                                c19919a.jnv.append(c42748a.iXW.har + 1).append("#");
                            }
                            if (str2.equals(c42748a.iXW.nickname)) {
                                c19919a.jnq.append(c42748a.iXW.appId).append("#");
                                c19919a.jnr.append("2#");
                                c19919a.jns.append(str4).append("#");
                                c19919a.jnt.append(intValue).append("#");
                                c19919a.jnu.append(c42748a.iXW.axy).append("#");
                                c19919a.jnv.append(c42748a.iXW.har + 1).append("#");
                            }
                        }
                    }
                    C19916b.m30807a(c19919a);
                }
            }
        }
        AppMethodBeat.m2505o(114943);
    }

    /* renamed from: a */
    private static void m30807a(C19919a c19919a) {
        AppMethodBeat.m2504i(114944);
        C4990ab.m7417i("MicroMsg.AppBrandRecentViewReporter", "alvinluo reportDuplicatedName: %s", c19919a);
        C7060h.pYm.mo8381e(15796, c19919a.jnp, c19919a.jnq, c19919a.jnr.toString(), c19919a.jns.toString(), c19919a.jnt.toString(), c19919a.jnu.toString(), c19919a.jnv.toString());
        AppMethodBeat.m2505o(114944);
    }
}
