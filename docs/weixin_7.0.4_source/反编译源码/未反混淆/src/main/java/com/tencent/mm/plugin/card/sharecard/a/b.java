package com.tencent.mm.plugin.card.sharecard.a;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.d.s;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.c;
import com.tencent.mm.plugin.card.model.n;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.i;
import com.tencent.mm.plugin.card.sharecard.model.k;
import com.tencent.mm.plugin.card.sharecard.model.l;
import com.tencent.mm.plugin.card.sharecard.model.m;
import com.tencent.mm.plugin.card.sharecard.model.p;
import com.tencent.mm.plugin.card.sharecard.model.r;
import com.tencent.mm.plugin.card.sharecard.ui.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.ac;
import com.tencent.view.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class b {
    private static boolean fpA = false;
    public static boolean kft = false;
    public a kfs = null;
    private Context mContext;

    public b(Context context) {
        this.mContext = context;
        kft = false;
    }

    public static int bbs() {
        int i = 0;
        AppMethodBeat.i(87985);
        c baW = am.baW();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where (status=0 OR status=5) AND card_type=10");
        Cursor a = baW.bSd.a("select count(*) from UserCardInfo" + stringBuilder.toString(), null, 2);
        if (a == null) {
            AppMethodBeat.o(87985);
        } else {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
            AppMethodBeat.o(87985);
        }
        return i;
    }

    public final void at(String str, boolean z) {
        AppMethodBeat.i(87986);
        if (TextUtils.isEmpty(str)) {
            ab.e("MicroMsg.ShareCardDataMgr", "updateGetShareLayoutData json is empty");
            AppMethodBeat.o(87986);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        l Hw = s.Hw(str);
        l lVar = (l) am.bbb().getValue("key_share_card_layout_data");
        if (Hw == null) {
            ab.e("MicroMsg.ShareCardDataMgr", "updateGetShareLayoutData data == null");
            a(Hw, lVar, z);
            am.bbb().putValue("key_share_card_layout_data", Hw);
            AppMethodBeat.o(87986);
            return;
        }
        if (z) {
            com.tencent.mm.plugin.card.d.l.Ho(str);
        }
        a(Hw, z);
        a(Hw, lVar, z);
        am.bbb().putValue("key_share_card_layout_data", Hw);
        int i = 0;
        if (Hw.kfG != null && Hw.kfG.size() > 0) {
            i = Hw.kfG.size();
        }
        if (Hw.kfH != null && Hw.kfH.size() > 0) {
            i += Hw.kfH.size();
        }
        if (i > 0) {
            int currentTimeMillis2 = (int) (System.currentTimeMillis() - currentTimeMillis);
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(d.MIC_PTU_TRANS_KONGCHENG);
            iDKey.SetKey(10);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(d.MIC_PTU_TRANS_KONGCHENG);
            iDKey2.SetKey(11);
            iDKey2.SetValue((long) currentTimeMillis2);
            IDKey iDKey3 = new IDKey();
            iDKey3.SetID(d.MIC_PTU_TRANS_KONGCHENG);
            iDKey3.SetKey(12);
            iDKey3.SetValue((long) i);
            IDKey iDKey4 = new IDKey();
            iDKey4.SetID(d.MIC_PTU_TRANS_KONGCHENG);
            iDKey4.SetKey(14);
            iDKey4.SetValue((long) (currentTimeMillis2 / i));
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            arrayList.add(iDKey3);
            arrayList.add(iDKey4);
            h.pYm.b(arrayList, true);
        }
        AppMethodBeat.o(87986);
    }

    private void a(l lVar, boolean z) {
        AppMethodBeat.i(87987);
        if (lVar == null) {
            ab.e("MicroMsg.ShareCardDataMgr", "don't parserShareCardListData, data is null");
            AppMethodBeat.o(87987);
            return;
        }
        Map hashMap;
        Map hashMap2;
        Map hashMap3;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        int i;
        int i2;
        m mVar;
        String GI;
        p pVar;
        ab.i("MicroMsg.ShareCardDataMgr", "parserShareCardListData()");
        Map map = (Map) am.bbb().getValue("key_share_card_annoucement_map");
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = map;
        }
        map = (Map) am.bbb().getValue("key_share_card_count_map");
        if (map == null) {
            hashMap2 = new HashMap();
        } else {
            hashMap2 = map;
        }
        map = (Map) am.bbb().getValue("key_share_card_username_map");
        if (map == null) {
            hashMap3 = new HashMap();
        } else {
            hashMap3 = map;
        }
        ArrayList arrayList4 = (ArrayList) am.bbb().getValue("key_share_card_local_city_ids");
        if (arrayList4 == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = arrayList4;
        }
        arrayList4 = (ArrayList) am.bbb().getValue("key_share_card_other_city_ids");
        if (arrayList4 == null) {
            arrayList2 = new ArrayList();
        } else {
            arrayList2 = arrayList4;
        }
        arrayList4 = (ArrayList) am.bbb().getValue("key_share_card_other_city_top_info_list");
        if (arrayList4 == null) {
            arrayList3 = new ArrayList();
        } else {
            arrayList3 = arrayList4;
        }
        if (z) {
            arrayList.clear();
            arrayList2.clear();
            arrayList3.clear();
        }
        ArrayList arrayList5 = new ArrayList();
        if (lVar.kfG != null && lVar.kfG.size() > 0) {
            i = 0;
            while (true) {
                i2 = i;
                if (i2 >= lVar.kfG.size()) {
                    break;
                }
                mVar = (m) lVar.kfG.get(i2);
                if (!TextUtils.isEmpty(mVar.kfO)) {
                    hashMap.put(mVar.kbU, mVar.kfO);
                }
                hashMap2.put(mVar.kbU, Integer.valueOf(am.bbe().GH(mVar.kbU)));
                hashMap3.put(mVar.kbU, t(am.bbe().GG(mVar.kbU)));
                if (!arrayList5.contains(mVar.kbU)) {
                    GI = am.bbe().GI(mVar.kbU);
                    if (!TextUtils.isEmpty(GI) && !arrayList.contains(GI)) {
                        arrayList.add(GI);
                    } else if (!arrayList.contains(mVar.cMC)) {
                        arrayList.add(mVar.cMC);
                    }
                    arrayList5.add(mVar.kbU);
                    pVar = new p();
                    pVar.kbU = mVar.kbU;
                    pVar.top = mVar.top;
                    arrayList3.add(pVar);
                }
                i = i2 + 1;
            }
        }
        arrayList5.clear();
        if (lVar.kfH != null && lVar.kfH.size() > 0) {
            i = 0;
            while (true) {
                i2 = i;
                if (i2 >= lVar.kfH.size()) {
                    break;
                }
                mVar = (m) lVar.kfH.get(i2);
                if (!TextUtils.isEmpty(mVar.kfO)) {
                    hashMap.put(mVar.kbU, mVar.kfO);
                }
                hashMap2.put(mVar.kbU, Integer.valueOf(am.bbe().GH(mVar.kbU)));
                hashMap3.put(mVar.kbU, t(am.bbe().GG(mVar.kbU)));
                if (!arrayList5.contains(mVar.kbU)) {
                    GI = am.bbe().GI(mVar.kbU);
                    if (!TextUtils.isEmpty(GI) && !arrayList2.contains(GI)) {
                        arrayList2.add(GI);
                    } else if (!arrayList2.contains(mVar.cMC)) {
                        arrayList2.add(mVar.cMC);
                    }
                    arrayList5.add(mVar.kbU);
                    pVar = new p();
                    pVar.kbU = mVar.kbU;
                    pVar.top = mVar.top;
                    arrayList3.add(pVar);
                }
                i = i2 + 1;
            }
        }
        am.bbb().putValue("key_share_card_annoucement_map", hashMap);
        am.bbb().putValue("key_share_card_count_map", hashMap2);
        am.bbb().putValue("key_share_card_username_map", hashMap3);
        am.bbb().putValue("key_share_card_local_city", lVar.kfI);
        am.bbb().putValue("key_share_card_local_city_ids", arrayList);
        am.bbb().putValue("key_share_card_other_city_ids", arrayList2);
        am.bbb().putValue("key_share_card_other_city_top_info_list", arrayList3);
        AppMethodBeat.o(87987);
    }

    private static void a(l lVar, l lVar2, boolean z) {
        AppMethodBeat.i(87988);
        if (lVar == null && lVar2 == null) {
            ab.e("MicroMsg.ShareCardDataMgr", "don't updateCategoryType(), newData == null && oldData == null");
            AppMethodBeat.o(87988);
        } else if (lVar != null && lVar.kfH == null && lVar.kfG == null && lVar2 != null && lVar2.kfH == null && lVar2.kfG == null) {
            ab.e("MicroMsg.ShareCardDataMgr", "don't updateCategoryType(), newData.local_city_list == null && oldData.local_city_list == null");
            AppMethodBeat.o(87988);
        } else {
            ArrayList arrayList;
            ArrayList arrayList2;
            int i;
            int i2;
            m mVar;
            ab.i("MicroMsg.ShareCardDataMgr", "updateCategoryType()");
            ArrayList arrayList3 = (ArrayList) am.bbb().getValue("key_share_card_local_city_category_info_list");
            if (arrayList3 == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = arrayList3;
            }
            arrayList3 = (ArrayList) am.bbb().getValue("key_share_card_other_city_category_info_list");
            if (arrayList3 == null) {
                arrayList2 = new ArrayList();
            } else {
                arrayList2 = arrayList3;
            }
            int i3 = 0;
            if (z) {
                am.bbe().sU(10);
                arrayList.clear();
                am.bbe().sU(0);
                arrayList2.clear();
                i = 0;
            } else {
                if (!(lVar2 == null || lVar2.kfG == null || lVar2.kfG.size() < 0)) {
                    i3 = lVar2.kfG.size();
                }
                if (lVar2 == null || lVar2.kfH == null || lVar2.kfH.size() < 0) {
                    i = 0;
                } else {
                    i = lVar2.kfH.size();
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            long iV = g.RP().eJN.iV(Thread.currentThread().getId());
            if (lVar != null && lVar.kfG != null && lVar.kfG.size() > 0) {
                i2 = 0;
                while (true) {
                    int i4 = i2;
                    if (i4 >= lVar.kfG.size()) {
                        break;
                    }
                    mVar = (m) lVar.kfG.get(i4);
                    am.bbe().N(mVar.kbU, 10, i4 + i3);
                    i iVar = new i();
                    iVar.kbU = mVar.kbU;
                    iVar.kfC = i4 + i3;
                    arrayList.add(iVar);
                    i2 = i4 + 1;
                }
                if (!(z || lVar2 == null || lVar2.kfG == null)) {
                    lVar.kfG.addAll(lVar2.kfG);
                }
            } else if (!(lVar == null || z || lVar2 == null || lVar2.kfG == null)) {
                lVar.kfG = lVar2.kfG;
            }
            am.bbb().putValue("key_share_card_local_city_category_info_list", arrayList);
            if (lVar != null && lVar.kfH != null && lVar.kfH.size() > 0) {
                i2 = 0;
                while (true) {
                    int i5 = i2;
                    if (i5 >= lVar.kfH.size()) {
                        break;
                    }
                    mVar = (m) lVar.kfH.get(i5);
                    am.bbe().N(mVar.kbU, 0, i5 + i);
                    i iVar2 = new i();
                    iVar2.kbU = mVar.kbU;
                    iVar2.kfC = i5 + i;
                    arrayList2.add(iVar2);
                    i2 = i5 + 1;
                }
                if (!(z || lVar2 == null || lVar2.kfH == null)) {
                    lVar.kfH.addAll(lVar2.kfH);
                }
            } else if (!(lVar == null || z || lVar2 == null || lVar2.kfH == null)) {
                lVar.kfH = lVar2.kfH;
            }
            am.bbb().putValue("key_share_card_other_city_category_info_list", arrayList2);
            g.RP().eJN.mB(iV);
            ab.d("MicroMsg.ShareCardDataMgr", "updateCategoryType  >> updateCategoryInfo use time %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.o(87988);
        }
    }

    public static void bbt() {
        ArrayList arrayList;
        ArrayList arrayList2;
        i iVar;
        AppMethodBeat.i(87989);
        long currentTimeMillis = System.currentTimeMillis();
        long iV = g.RP().eJN.iV(Thread.currentThread().getId());
        ab.i("MicroMsg.ShareCardDataMgr", "updateShareCardCategory()");
        ArrayList arrayList3 = (ArrayList) am.bbb().getValue("key_share_card_local_city_category_info_list");
        if (arrayList3 == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = arrayList3;
        }
        arrayList3 = (ArrayList) am.bbb().getValue("key_share_card_other_city_category_info_list");
        if (arrayList3 == null) {
            arrayList2 = new ArrayList();
        } else {
            arrayList2 = arrayList3;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            iVar = (i) arrayList.get(i);
            am.bbe().N(iVar.kbU, 10, iVar.kfC);
        }
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            iVar = (i) arrayList2.get(i2);
            am.bbe().N(iVar.kbU, 0, iVar.kfC);
        }
        g.RP().eJN.mB(iV);
        ab.i("MicroMsg.ShareCardDataMgr", "updateShareCardCategory  >> updateCategoryInfo use time %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(87989);
    }

    private String t(ArrayList<String> arrayList) {
        AppMethodBeat.i(87990);
        String a = a(this.mContext, (ArrayList) arrayList);
        AppMethodBeat.o(87990);
        return a;
    }

    private static String a(Context context, ArrayList<String> arrayList) {
        AppMethodBeat.i(87991);
        String str;
        if (arrayList == null || arrayList.size() == 0) {
            ab.e("MicroMsg.ShareCardDataMgr", "getShareUserName， username_list == null || username_list.size() == 0");
            str = "";
            AppMethodBeat.o(87991);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < arrayList.size() && i < 2) {
            if (i != 0) {
                stringBuilder.append("、");
            }
            String mK = com.tencent.mm.model.s.mK((String) arrayList.get(i));
            str = com.tencent.mm.model.s.mJ((String) arrayList.get(i));
            if (TextUtils.isEmpty(mK)) {
                stringBuilder.append(str);
            } else {
                stringBuilder.append(mK);
            }
            i++;
        }
        if (context == null) {
            ab.e("MicroMsg.ShareCardDataMgr", "context == null");
            str = "";
            AppMethodBeat.o(87991);
            return str;
        } else if (arrayList.size() == 1 || arrayList.size() == 2) {
            str = context.getString(R.string.ahh, new Object[]{stringBuilder.toString()});
            AppMethodBeat.o(87991);
            return str;
        } else {
            str = context.getString(R.string.agz, new Object[]{stringBuilder.toString(), Integer.valueOf(arrayList.size())});
            AppMethodBeat.o(87991);
            return str;
        }
    }

    public static void GA(final String str) {
        AppMethodBeat.i(87992);
        ab.i("MicroMsg.ShareCardDataMgr", "updateShareUserInfo()");
        if (TextUtils.isEmpty(str)) {
            ab.e("MicroMsg.ShareCardDataMgr", "updateShareUserInfo(), card_tp_id is empty");
            AppMethodBeat.o(87992);
            return;
        }
        final ak akVar = new ak(Looper.getMainLooper());
        com.tencent.mm.sdk.g.d.post(new Runnable() {
            public final void run() {
                ArrayList arrayList = null;
                AppMethodBeat.i(87982);
                ab.i("MicroMsg.ShareCardDataMgr", "begin to getShareUserInfo()");
                k bbe = am.bbe();
                String str = str;
                ab.i("MicroMsg.ShareCardInfoStorage", "getShareUserInfo()");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(" where ( status=0) ");
                stringBuilder.append(" AND (card_tp_id = '" + str + "' )");
                stringBuilder.append(" order by share_time desc ");
                Cursor a = bbe.bSd.a("select * from ShareCardInfo" + stringBuilder.toString(), null, 2);
                if (a == null) {
                    ab.i("MicroMsg.ShareCardInfoStorage", "getShareUserInfo(), cursor == null");
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    while (a.moveToNext()) {
                        ShareCardInfo shareCardInfo = new ShareCardInfo();
                        shareCardInfo.d(a);
                        r rVar;
                        if (arrayList3.contains(shareCardInfo.field_from_username)) {
                            int i = 0;
                            rVar = null;
                            while (i < arrayList2.size()) {
                                rVar = (r) arrayList2.get(i);
                                if (shareCardInfo.field_from_username != null && shareCardInfo.field_from_username.equals(rVar.kfT)) {
                                    break;
                                }
                                i++;
                            }
                            i = 0;
                            if (rVar != null) {
                                rVar.kfV.add(0, shareCardInfo.field_card_id);
                                rVar.kfU++;
                                arrayList2.set(i, rVar);
                            }
                        } else {
                            rVar = new r();
                            rVar.kbU = shareCardInfo.field_card_tp_id;
                            rVar.kfT = shareCardInfo.field_from_username;
                            rVar.kfV = new ArrayList();
                            rVar.kfV.add(shareCardInfo.field_card_id);
                            rVar.kfU = 1;
                            arrayList2.add(rVar);
                            arrayList3.add(shareCardInfo.field_from_username);
                        }
                    }
                    a.close();
                    arrayList = arrayList2;
                }
                ab.i("MicroMsg.ShareCardDataMgr", "end to getShareUserInfo(), 1");
                if (arrayList == null || arrayList.size() == 0) {
                    ab.e("MicroMsg.ShareCardDataMgr", "getShareUserInfo(), share_user_list is null");
                    AppMethodBeat.o(87982);
                    return;
                }
                if (arrayList.get(0) != null) {
                    ((r) arrayList.get(0)).kfW = true;
                }
                ab.i("MicroMsg.ShareCardDataMgr", "end to getShareUserInfo(), 2");
                akVar.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(87981);
                        Map map = (Map) am.bbb().getValue("key_share_user_info_map");
                        if (map == null) {
                            map = new HashMap();
                        }
                        map.put(str, arrayList);
                        am.bbb().putValue("key_share_user_info_map", map);
                        AppMethodBeat.o(87981);
                    }
                });
                AppMethodBeat.o(87982);
            }
        }, "updateShareUserInfo_thread");
        AppMethodBeat.o(87992);
    }

    public static ArrayList<String> sQ(int i) {
        AppMethodBeat.i(87993);
        ArrayList<String> arrayList;
        if (i == 1) {
            arrayList = (ArrayList) am.bbb().getValue("key_share_card_local_city_ids");
            if (arrayList == null || arrayList.size() == 0) {
                ab.e("MicroMsg.ShareCardDataMgr", "getCardIds() ids == null || ids.size() == 0 for showType == ".concat(String.valueOf(i)));
                ArrayList sR = sR(i);
                AppMethodBeat.o(87993);
                return sR;
            }
            AppMethodBeat.o(87993);
            return arrayList;
        } else if (i == 2) {
            arrayList = (ArrayList) am.bbb().getValue("key_share_card_other_city_ids");
            if (arrayList == null || arrayList.size() == 0) {
                ab.e("MicroMsg.ShareCardDataMgr", "getCardIds() ids == null || ids.size() == 0 for showType == ".concat(String.valueOf(i)));
                arrayList = sR(i);
                AppMethodBeat.o(87993);
                return arrayList;
            }
            AppMethodBeat.o(87993);
            return arrayList;
        } else {
            AppMethodBeat.o(87993);
            return null;
        }
    }

    private static ArrayList<String> sR(int i) {
        int i2 = 0;
        AppMethodBeat.i(87994);
        l lVar = (l) am.bbb().getValue("key_share_card_layout_data");
        if (lVar == null) {
            ab.e("MicroMsg.ShareCardDataMgr", "getCardIdsByType() data == null for showType = ".concat(String.valueOf(i)));
            AppMethodBeat.o(87994);
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i3;
        m mVar;
        String GI;
        if (i == 1) {
            if (lVar.kfG != null && lVar.kfG.size() > 0) {
                while (true) {
                    i3 = i2;
                    if (i3 >= lVar.kfG.size()) {
                        break;
                    }
                    mVar = (m) lVar.kfG.get(i3);
                    if (!arrayList2.contains(mVar.kbU)) {
                        GI = am.bbe().GI(mVar.kbU);
                        if (!TextUtils.isEmpty(GI) && !arrayList.contains(GI)) {
                            arrayList.add(GI);
                        } else if (!arrayList.contains(mVar.cMC)) {
                            arrayList.add(mVar.cMC);
                        }
                        arrayList2.add(mVar.kbU);
                    }
                    i2 = i3 + 1;
                }
                am.bbb().putValue("key_share_card_local_city_ids", arrayList);
            }
            AppMethodBeat.o(87994);
            return arrayList;
        } else if (i == 2) {
            if (lVar.kfH != null && lVar.kfH.size() > 0) {
                while (true) {
                    i3 = i2;
                    if (i3 >= lVar.kfH.size()) {
                        break;
                    }
                    mVar = (m) lVar.kfH.get(i3);
                    if (!arrayList2.contains(mVar.kbU)) {
                        GI = am.bbe().GI(mVar.kbU);
                        if (!TextUtils.isEmpty(GI) && !arrayList.contains(GI)) {
                            arrayList.add(GI);
                        } else if (!arrayList.contains(mVar.cMC)) {
                            arrayList.add(mVar.cMC);
                        }
                        arrayList2.add(mVar.kbU);
                    }
                    i2 = i3 + 1;
                }
                am.bbb().putValue("key_share_card_other_city_ids", arrayList);
            }
            AppMethodBeat.o(87994);
            return arrayList;
        } else {
            AppMethodBeat.o(87994);
            return null;
        }
    }

    public static void dn(String str, String str2) {
        AppMethodBeat.i(87995);
        if (fpA) {
            ab.i("MicroMsg.ShareCardDataMgr", "is isUpdating data, don't do updateCardIdsListByCardId");
            AppMethodBeat.o(87995);
            return;
        }
        String dq;
        ab.i("MicroMsg.ShareCardDataMgr", "do updateCardIdsListByCardId");
        fpA = true;
        ArrayList sQ = sQ(1);
        if (sQ != null && sQ.contains(str)) {
            sQ.remove(str);
            dq = am.bbe().dq(str, str2);
            if (!TextUtils.isEmpty(dq)) {
                sQ.add(dq);
            }
            am.bbb().putValue("key_share_card_local_city_ids", sQ);
        }
        sQ = sQ(2);
        if (sQ != null && sQ.contains(str)) {
            sQ.remove(str);
            dq = am.bbe().dq(str, str2);
            if (!TextUtils.isEmpty(dq)) {
                sQ.add(dq);
            }
            am.bbb().putValue("key_share_card_other_city_ids", sQ);
        }
        fpA = false;
        AppMethodBeat.o(87995);
    }

    /* renamed from: do */
    public static void m19do(String str, String str2) {
        AppMethodBeat.i(87996);
        ab.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId card_id:" + str + ", card_tp_id:" + str2);
        ArrayList sQ = sQ(1);
        if (sQ == null || !sQ.contains(str)) {
            ArrayList sQ2 = sQ(2);
            if (sQ2 == null || !sQ2.contains(str)) {
                l lVar = (l) am.bbb().getValue("key_share_card_layout_data");
                if (lVar == null) {
                    ab.e("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId data == null");
                    AppMethodBeat.o(87996);
                    return;
                }
                int GH = am.bbe().GH(str2);
                int GC = GC(str2);
                ab.e("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId realCount:" + GH + " cacheCount:" + GC);
                if (lVar.kfG != null && lVar.kfG.size() > 0 && (GC <= 0 || GH == 1)) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= lVar.kfG.size()) {
                            break;
                        }
                        m mVar = (m) lVar.kfG.get(i2);
                        if (str2 == null || !str2.contains(mVar.kbU)) {
                            i = i2 + 1;
                        } else {
                            sQ.add(str);
                            am.bbb().putValue("key_share_card_local_city_ids", sQ);
                            ab.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId add for local ids, card id is ".concat(String.valueOf(str)));
                            AppMethodBeat.o(87996);
                            return;
                        }
                    }
                }
                ab.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId, not add for local_ids");
                if (sQ2 == null || (GC > 0 && GH != 1)) {
                    ab.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId, not add for other_ids");
                    AppMethodBeat.o(87996);
                    return;
                }
                sQ2.add(str);
                am.bbb().putValue("key_share_card_other_city_ids", sQ2);
                ab.i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId add for other ids, card id is ".concat(String.valueOf(str)));
                AppMethodBeat.o(87996);
                return;
            }
            AppMethodBeat.o(87996);
            return;
        }
        AppMethodBeat.o(87996);
    }

    public static int bbu() {
        AppMethodBeat.i(87997);
        if (bbw()) {
            AppMethodBeat.o(87997);
            return 1;
        } else if (!bbv()) {
            AppMethodBeat.o(87997);
            return 0;
        } else if (kft) {
            AppMethodBeat.o(87997);
            return 3;
        } else {
            AppMethodBeat.o(87997);
            return 4;
        }
    }

    public static boolean bbv() {
        AppMethodBeat.i(87998);
        ArrayList arrayList = (ArrayList) am.bbb().getValue("key_share_card_other_city_ids");
        if (arrayList == null || arrayList.size() <= 0) {
            AppMethodBeat.o(87998);
            return false;
        }
        AppMethodBeat.o(87998);
        return true;
    }

    public static boolean bbw() {
        AppMethodBeat.i(87999);
        ArrayList arrayList = (ArrayList) am.bbb().getValue("key_share_card_local_city_ids");
        if (arrayList == null || arrayList.size() <= 0) {
            AppMethodBeat.o(87999);
            return false;
        }
        AppMethodBeat.o(87999);
        return true;
    }

    public static String GB(String str) {
        AppMethodBeat.i(88000);
        Map map = (Map) am.bbb().getValue("key_share_card_annoucement_map");
        String str2;
        if (map == null) {
            str2 = "";
            AppMethodBeat.o(88000);
            return str2;
        }
        str2 = (String) map.get(str);
        AppMethodBeat.o(88000);
        return str2;
    }

    public static int GC(String str) {
        AppMethodBeat.i(88001);
        Map map = (Map) am.bbb().getValue("key_share_card_count_map");
        if (map == null) {
            AppMethodBeat.o(88001);
            return 0;
        }
        Integer num = (Integer) map.get(str);
        if (num == null) {
            AppMethodBeat.o(88001);
            return 0;
        }
        int intValue = num.intValue();
        AppMethodBeat.o(88001);
        return intValue;
    }

    public static String rt(String str) {
        AppMethodBeat.i(88002);
        Map map = (Map) am.bbb().getValue("key_share_card_username_map");
        String str2;
        if (map == null) {
            str2 = "";
            AppMethodBeat.o(88002);
            return str2;
        }
        str2 = (String) map.get(str);
        AppMethodBeat.o(88002);
        return str2;
    }

    public static ArrayList<r> GD(String str) {
        AppMethodBeat.i(88003);
        Map map = (Map) am.bbb().getValue("key_share_user_info_map");
        if (map == null) {
            map = new HashMap();
        }
        ArrayList<r> arrayList = (ArrayList) map.get(str);
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList();
            AppMethodBeat.o(88003);
            return arrayList2;
        }
        AppMethodBeat.o(88003);
        return arrayList;
    }

    private static void H(String str, String str2, String str3) {
        Map hashMap;
        ArrayList arrayList;
        AppMethodBeat.i(88004);
        Map map = (Map) am.bbb().getValue("key_share_user_info_map");
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = map;
        }
        ArrayList arrayList2 = (ArrayList) hashMap.get(str2);
        if (arrayList2 == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = arrayList2;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            r rVar = (r) arrayList.get(i);
            if (str3 != null && str3.equals(rVar.kfT)) {
                rVar.kfW = false;
                rVar.kfU--;
                rVar.kfV.remove(str);
                arrayList.set(i, rVar);
            }
        }
        hashMap.put(str2, arrayList);
        am.bbb().putValue("key_share_user_info_map", hashMap);
        AppMethodBeat.o(88004);
    }

    public static void bbx() {
        AppMethodBeat.i(88005);
        ab.i("MicroMsg.ShareCardDataMgr", "delelteAllIllegalStatusCard()");
        com.tencent.mm.sdk.g.d.post(new Runnable() {
            public final void run() {
                int i;
                AppMethodBeat.i(87983);
                ab.i("MicroMsg.ShareCardDataMgr", "begin to delelteAllIllegalStatusCard()");
                k bbe = am.bbe();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(" where (status=1 OR status=2 OR status=3 OR status=4 OR status=6)");
                boolean hY = bbe.bSd.hY("ShareCardInfo", "delete from ShareCardInfo" + stringBuilder.toString());
                String str = "MicroMsg.ShareCardInfoStorage";
                StringBuilder stringBuilder2 = new StringBuilder("delelteAllIllegalStatusCard updateRet is ");
                if (hY) {
                    i = 1;
                } else {
                    i = 0;
                }
                ab.i(str, stringBuilder2.append(i).toString());
                ab.i("MicroMsg.ShareCardDataMgr", "end to delelteAllIllegalStatusCard()");
                AppMethodBeat.o(87983);
            }
        }, "delelteAllIllegalStatusCard");
        AppMethodBeat.o(88005);
    }

    public static void ad(Context context, String str) {
        Map hashMap;
        AppMethodBeat.i(88006);
        ab.i("MicroMsg.ShareCardDataMgr", "updateCardCountbyCardTpId() card_tp_id:".concat(String.valueOf(str)));
        Map map = (Map) am.bbb().getValue("key_share_card_count_map");
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = map;
        }
        map = (Map) am.bbb().getValue("key_share_card_username_map");
        if (map == null) {
            map = new HashMap();
        }
        hashMap.put(str, Integer.valueOf(am.bbe().GH(str)));
        map.put(str, a(context, am.bbe().GG(str)));
        am.bbb().putValue("key_share_card_count_map", hashMap);
        am.bbb().putValue("key_share_card_username_map", map);
        AppMethodBeat.o(88006);
    }

    public static boolean sS(int i) {
        AppMethodBeat.i(88007);
        Integer num = (Integer) am.bbb().getValue("key_share_card_show_type");
        ArrayList arrayList;
        if (num == null) {
            AppMethodBeat.o(88007);
            return false;
        } else if (num.intValue() == 0) {
            AppMethodBeat.o(88007);
            return false;
        } else if (i == 0) {
            arrayList = (ArrayList) am.bbb().getValue("key_share_card_other_city_ids");
            if (arrayList == null || arrayList.size() == 0) {
                AppMethodBeat.o(88007);
                return false;
            }
            AppMethodBeat.o(88007);
            return true;
        } else if (i == 10) {
            arrayList = (ArrayList) am.bbb().getValue("key_share_card_local_city_ids");
            if (arrayList == null || arrayList.size() == 0) {
                AppMethodBeat.o(88007);
                return false;
            }
            AppMethodBeat.o(88007);
            return true;
        } else {
            AppMethodBeat.o(88007);
            return false;
        }
    }

    public static boolean GE(String str) {
        AppMethodBeat.i(88008);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(88008);
            return false;
        }
        ArrayList arrayList = (ArrayList) am.bbb().getValue("key_share_card_other_city_top_info_list");
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            if (pVar != null && str.equals(pVar.kbU) && pVar.top == 1) {
                AppMethodBeat.o(88008);
                return true;
            }
        }
        AppMethodBeat.o(88008);
        return false;
    }

    public static void GF(String str) {
        AppMethodBeat.i(88009);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(88009);
            return;
        }
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) am.bbb().getValue("key_share_card_other_city_top_info_list");
        if (arrayList2 == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = arrayList2;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                p pVar = (p) arrayList.get(i2);
                if (pVar != null && str.equals(pVar.kbU) && pVar.top == 1) {
                    pVar.kfS = true;
                    arrayList.set(i2, pVar);
                    am.bbb().putValue("key_share_card_other_city_top_info_list", arrayList);
                    AppMethodBeat.o(88009);
                    return;
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(88009);
                return;
            }
        }
    }

    public static String dp(String str, String str2) {
        AppMethodBeat.i(88010);
        ab.i("MicroMsg.ShareCardDataMgr", "initShareUserCardId()");
        if (str2 != null) {
            ArrayList GD = GD(str2);
            if (GD == null || GD.size() <= 0) {
                ab.e("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), shareUserInfoList is null");
            } else {
                r rVar = (r) GD.get(0);
                if (rVar == null || rVar.kfV == null || rVar.kfV.size() <= 0 || str.equals(rVar.kfV.get(0))) {
                    ab.i("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), mCardId is first!");
                } else {
                    String str3 = (String) rVar.kfV.get(0);
                    ab.i("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), mCardId is not first!, reset it");
                    str = str3;
                }
            }
        } else {
            ab.e("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), card_tp_id is null");
        }
        AppMethodBeat.o(88010);
        return str;
    }

    public static boolean bby() {
        AppMethodBeat.i(88011);
        l lVar = (l) am.bbb().getValue("key_share_card_layout_data");
        if (lVar == null) {
            AppMethodBeat.o(88011);
            return true;
        }
        boolean z = lVar.kfJ;
        AppMethodBeat.o(88011);
        return z;
    }

    public static boolean bbz() {
        AppMethodBeat.i(88012);
        l lVar = (l) am.bbb().getValue("key_share_card_layout_data");
        if (lVar == null) {
            AppMethodBeat.o(88012);
            return true;
        }
        boolean z = lVar.kfK;
        AppMethodBeat.o(88012);
        return z;
    }

    public static boolean bbA() {
        AppMethodBeat.i(88013);
        Integer num = (Integer) g.RP().Ry().get(ac.a.USERINFO_CARD_HAS_UPDATE_CARD_TYPE_INT_SYNC, Integer.valueOf(0));
        if (num == null || num.intValue() != 1) {
            g.RP().Ry().set(ac.a.USERINFO_CARD_HAS_UPDATE_CARD_TYPE_INT_SYNC, Integer.valueOf(1));
            Cursor a = am.baW().a(n.a.NORMAL_TYPE);
            if (a == null || a.getCount() <= 0) {
                ab.e("MicroMsg.ShareCardDataMgr", "updateAllCardInfoByBlockField cursor is null or size is 0");
                AppMethodBeat.o(88013);
                return false;
            }
            a.moveToFirst();
            while (!a.isAfterLast()) {
                CardInfo cardInfo = new CardInfo();
                cardInfo.d(a);
                if (cardInfo.field_card_type == -1) {
                    if (cardInfo.aZV() == null) {
                        ab.e("MicroMsg.ShareCardDataMgr", "updateCardType fail , info.getCardTpInfo() == null");
                    } else {
                        cardInfo.field_card_type = cardInfo.aZV().iAd;
                        if (!am.baW().c(cardInfo, new String[0])) {
                            ab.e("MicroMsg.ShareCardDataMgr", "updateCardType fail , cardId = %s", cardInfo.field_card_id);
                        }
                    }
                }
                a.moveToNext();
            }
            a.close();
            AppMethodBeat.o(88013);
            return true;
        }
        AppMethodBeat.o(88013);
        return false;
    }

    public static void a(Context context, com.tencent.mm.plugin.card.base.b bVar) {
        AppMethodBeat.i(88014);
        ab.i("MicroMsg.ShareCardDataMgr", "updateShareCardData()");
        ab.i("MicroMsg.ShareCardDataMgr", "card id:" + bVar.aZZ() + " cardtpid:" + bVar.baa());
        dn(bVar.aZZ(), bVar.baa());
        if (context != null) {
            ad(context, bVar.baa());
        }
        H(bVar.aZZ(), bVar.baa(), bVar.bab());
        GA(bVar.baa());
        AppMethodBeat.o(88014);
    }

    public final void init() {
        AppMethodBeat.i(87984);
        if (((l) am.bbb().getValue("key_share_card_layout_data")) == null) {
            ab.e("MicroMsg.ShareCardDataMgr", "initShareCardLayoutData, data cache is empty!, load data from db!");
            String beF = com.tencent.mm.plugin.card.d.l.beF();
            if (TextUtils.isEmpty(beF)) {
                ab.e("MicroMsg.ShareCardDataMgr", "initShareCardLayoutData, json is empty");
                AppMethodBeat.o(87984);
                return;
            }
            l Hw = s.Hw(beF);
            if (Hw != null) {
                ab.i("MicroMsg.ShareCardDataMgr", "load share card layout data success!");
                am.bbb().putValue("key_share_card_layout_data", Hw);
                a(Hw, true);
                AppMethodBeat.o(87984);
                return;
            }
            ab.e("MicroMsg.ShareCardDataMgr", "load share card layout data fail!");
            AppMethodBeat.o(87984);
            return;
        }
        ab.i("MicroMsg.ShareCardDataMgr", "the share card layout cache is valid!");
        AppMethodBeat.o(87984);
    }
}
