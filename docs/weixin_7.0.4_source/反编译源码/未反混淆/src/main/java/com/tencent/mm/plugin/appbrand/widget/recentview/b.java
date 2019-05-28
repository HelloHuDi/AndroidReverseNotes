package com.tencent.mm.plugin.appbrand.widget.recentview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b {
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

    static class a {
        String jnp;
        StringBuilder jnq = new StringBuilder();
        StringBuilder jnr = new StringBuilder();
        StringBuilder jns = new StringBuilder();
        StringBuilder jnt = new StringBuilder();
        StringBuilder jnu = new StringBuilder();
        StringBuilder jnv = new StringBuilder();

        public a(String str) {
            AppMethodBeat.i(114933);
            this.jnp = str;
            AppMethodBeat.o(114933);
        }

        public final String toString() {
            AppMethodBeat.i(114934);
            String format = String.format("DuplicateNameInfo: {duplicatedName: %s, appId: %s, \nnameType: %s, \nlistType: %s, \nposition: %s, \nversion: %s, \nversionType: %s", new Object[]{this.jnp, this.jnq.toString(), this.jnr.toString(), this.jns.toString(), this.jnt.toString(), this.jnu.toString(), this.jnv.toString()});
            AppMethodBeat.o(114934);
            return format;
        }
    }

    public b() {
        AppMethodBeat.i(114935);
        AppMethodBeat.o(114935);
    }

    public final void dw(int i, int i2) {
        AppMethodBeat.i(114936);
        this.jmK = System.currentTimeMillis() / 1000;
        this.jmN = i;
        this.jmW = i2;
        AppMethodBeat.o(114936);
    }

    public final void N(int i, int i2, int i3) {
        AppMethodBeat.i(114937);
        this.jmO = i;
        this.jmX = i2;
        this.jmL = i3;
        d.xDG.execute(new Runnable() {
            public final void run() {
                AppMethodBeat.i(114931);
                if (b.this.jmK <= 0) {
                    ab.d("MicroMsg.AppBrandRecentViewReporter", "[report] mOpenTime <= 0");
                    AppMethodBeat.o(114931);
                    return;
                }
                ab.i("MicroMsg.AppBrandRecentViewReporter", "[report] mOpenTime: %s, mRecentCountAtOpen: %s, mRecentCountAtClose: %s, mCloseType: %s, mScrollRecentCount: %s, mOpenRecentAppBrandList: %s, mDeleteRecentCount: %s, mDeleteRecentAppBrandList: %s, \ndragCountWhenClose: %d, mStarCountAtOpen: %d, mStarCountAtClose: %d, mScrollStarCount: %d, mOpenStarAppBrandList: %s, mDeleteStarCount: %d, mDeleteStarAppBrandList: %s, \nmMoveToFirstCount: %d, mClickRecentAppBrandList: %s, mClickStarAppBrandList: %s, mMoveStarAppBrandToFirstList: %s, mAddCollectionCount: %d, mAddCollectionAppBrandList: %s", Long.valueOf(b.this.jmK), Integer.valueOf(b.this.jmN), Integer.valueOf(b.this.jmO), Integer.valueOf(b.this.jmL), Integer.valueOf(b.this.jmP), b.this.jmS.toString(), Integer.valueOf(b.this.jmQ), b.this.jmT.toString(), Integer.valueOf(b.this.jmM), Integer.valueOf(b.this.jmW), Integer.valueOf(b.this.jmX), Integer.valueOf(b.this.jmY), b.this.jnd.toString(), Integer.valueOf(b.this.jmZ), b.this.jne.toString(), Integer.valueOf(b.this.jna), b.this.jmU.toString(), b.this.jng.toString(), b.this.jnf.toString(), Integer.valueOf(b.this.jmR), b.this.jmV.toString());
                h.pYm.e(15081, Long.valueOf(b.this.jmK), Integer.valueOf(b.this.jmN), Integer.valueOf(b.this.jmO), Integer.valueOf(b.this.jmL), Integer.valueOf(b.this.jmP), b.this.jmS.toString(), Integer.valueOf(b.this.jmQ), b.this.jmT.toString(), Integer.valueOf(b.this.jmM), Integer.valueOf(b.this.jmW), Integer.valueOf(b.this.jmX), Integer.valueOf(b.this.jmY), b.this.jnd.toString(), Integer.valueOf(b.this.jmZ), b.this.jne.toString(), Integer.valueOf(b.this.jna), b.this.jmU.toString(), b.this.jng.toString(), b.this.jnf.toString(), Integer.valueOf(b.this.jmR), b.this.jmV.toString());
                b.a(b.this);
                AppMethodBeat.o(114931);
            }
        });
        AppMethodBeat.o(114937);
    }

    public final void aRY() {
        this.jmM++;
    }

    public final void bA(String str, int i) {
        AppMethodBeat.i(114938);
        ab.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo openRecentAppBrand id: %s, pos: %d", str, Integer.valueOf(i));
        this.jmS.append(str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        this.jmU.append(i + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        AppMethodBeat.o(114938);
    }

    public final void bB(String str, int i) {
        AppMethodBeat.i(114939);
        ab.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo openStarAppBrand id: %s, pos: %d", str, Integer.valueOf(i));
        this.jnd.append(str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        this.jng.append(i + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        AppMethodBeat.o(114939);
    }

    public final void ER(String str) {
        AppMethodBeat.i(114940);
        ab.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo deleteRecentAppBrand id: %s", str);
        this.jmQ++;
        this.jmT.append(str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        AppMethodBeat.o(114940);
    }

    public final void ES(String str) {
        AppMethodBeat.i(114941);
        ab.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo deleteStarAppBrand id: %s", str);
        this.jmZ++;
        this.jne.append(str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        AppMethodBeat.o(114941);
    }

    public final void ET(String str) {
        AppMethodBeat.i(114942);
        ab.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo addRecentAppBrandToCollection id: %s", str);
        this.jmR++;
        this.jmV.append(str + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        AppMethodBeat.o(114942);
    }

    public static void f(List<a> list, List<a> list2) {
        a aVar;
        AppMethodBeat.i(114943);
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
            aVar = (a) arrayList.get(i2);
            if (!(aVar == null || aVar.iXW == null || bo.isNullOrNil(aVar.iXW.appId) || bo.isNullOrNil(aVar.iXW.nickname))) {
                int i3;
                Map map;
                HashMap hashMap2;
                int i4 = i2 < list.size() ? 2 : 1;
                if (i2 < list.size()) {
                    i3 = i2 - 1;
                } else {
                    i3 = (i2 - 1) - list.size();
                }
                ab.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo nickName: %s, type: %d, pos: %d", aVar.iXW.nickname, Integer.valueOf(i4), Integer.valueOf(i3));
                String str = aVar.iXW.appId + "," + aVar.iXW.har + "," + i4 + "," + i3;
                if (hashMap.containsKey(aVar.iXW.nickname)) {
                    ab.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo contains nickName: %s", aVar.iXW.nickname);
                    map = (Map) hashMap.get(aVar.iXW.nickname);
                    if (!map.containsKey(str)) {
                        map.put(str, aVar);
                    }
                } else {
                    ab.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo not contains nickName: %s", aVar.iXW.nickname);
                    hashMap2 = new HashMap();
                    hashMap2.put(str, aVar);
                    hashMap.put(aVar.iXW.nickname, hashMap2);
                }
                if (bo.isNullOrNil(aVar.iXW.bQo)) {
                    ab.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo not shortNickName");
                } else if (aVar.iXW.nickname.equals(aVar.iXW.bQo)) {
                    ab.e("MicroMsg.AppBrandRecentViewReporter", "alvinluo nickname equals shortNickName %s, %s", aVar.iXW.nickname, aVar.iXW.bQo);
                } else if (hashMap.containsKey(aVar.iXW.bQo)) {
                    ab.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo contains shortNickname: %s", aVar.iXW.bQo);
                    map = (Map) hashMap.get(aVar.iXW.bQo);
                    if (!map.containsKey(str)) {
                        map.put(str, aVar);
                    }
                } else {
                    ab.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo not contains shortNickname: %s", aVar.iXW.bQo);
                    hashMap2 = new HashMap();
                    hashMap2.put(str, aVar);
                    hashMap.put(aVar.iXW.bQo, hashMap2);
                }
            }
            i = i2 + 1;
        }
        for (String str2 : hashMap.keySet()) {
            Map map2 = (Map) hashMap.get(str2);
            if (map2 == null || map2.size() <= 1) {
                ab.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo name %s not duplicated", str2);
            } else {
                Set<String> keySet = map2.keySet();
                HashMap hashMap3 = new HashMap();
                for (String str3 : keySet) {
                    aVar = (a) map2.get(str3);
                    if (!(aVar == null || aVar.iXW == null || bo.isNullOrNil(aVar.iXW.appId) || hashMap3.containsKey(aVar.iXW.appId))) {
                        hashMap3.put(aVar.iXW.appId, aVar);
                    }
                }
                if (hashMap3.size() <= 1) {
                    ab.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo name %s not duplicated2", str2);
                } else {
                    a aVar2 = new a(str2);
                    for (String str32 : keySet) {
                        String[] split = str32.split(",");
                        String str4 = split[2];
                        int intValue = Integer.valueOf(split[3]).intValue();
                        aVar = (a) map2.get(str32);
                        if (!(aVar == null || aVar.iXW == null)) {
                            ab.d("MicroMsg.AppBrandRecentViewReporter", "alvinluo duplicated appId: %s, name: %s, shortName: %s, type: %s, pos: %d", aVar.iXW.appId, aVar.iXW.nickname, aVar.iXW.bQo, str4, Integer.valueOf(intValue));
                            if (str2.equals(aVar.iXW.bQo)) {
                                aVar2.jnq.append(aVar.iXW.appId).append("#");
                                aVar2.jnr.append("1#");
                                aVar2.jns.append(str4).append("#");
                                aVar2.jnt.append(intValue).append("#");
                                aVar2.jnu.append(aVar.iXW.axy).append("#");
                                aVar2.jnv.append(aVar.iXW.har + 1).append("#");
                            }
                            if (str2.equals(aVar.iXW.nickname)) {
                                aVar2.jnq.append(aVar.iXW.appId).append("#");
                                aVar2.jnr.append("2#");
                                aVar2.jns.append(str4).append("#");
                                aVar2.jnt.append(intValue).append("#");
                                aVar2.jnu.append(aVar.iXW.axy).append("#");
                                aVar2.jnv.append(aVar.iXW.har + 1).append("#");
                            }
                        }
                    }
                    a(aVar2);
                }
            }
        }
        AppMethodBeat.o(114943);
    }

    private static void a(a aVar) {
        AppMethodBeat.i(114944);
        ab.i("MicroMsg.AppBrandRecentViewReporter", "alvinluo reportDuplicatedName: %s", aVar);
        h.pYm.e(15796, aVar.jnp, aVar.jnq, aVar.jnr.toString(), aVar.jns.toString(), aVar.jnt.toString(), aVar.jnu.toString(), aVar.jnv.toString());
        AppMethodBeat.o(114944);
    }
}
