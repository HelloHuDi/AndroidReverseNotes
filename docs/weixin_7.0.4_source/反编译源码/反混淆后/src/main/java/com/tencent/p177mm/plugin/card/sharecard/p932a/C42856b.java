package com.tencent.p177mm.plugin.card.sharecard.p932a;

import android.content.Context;
import android.database.Cursor;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.plugin.card.base.C42837b;
import com.tencent.p177mm.plugin.card.model.C27587c;
import com.tencent.p177mm.plugin.card.model.C33771n.C11290a;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.model.CardInfo;
import com.tencent.p177mm.plugin.card.p931d.C38736l;
import com.tencent.p177mm.plugin.card.p931d.C38738s;
import com.tencent.p177mm.plugin.card.sharecard.model.C11296r;
import com.tencent.p177mm.plugin.card.sharecard.model.C20155k;
import com.tencent.p177mm.plugin.card.sharecard.model.C27592i;
import com.tencent.p177mm.plugin.card.sharecard.model.C27593l;
import com.tencent.p177mm.plugin.card.sharecard.model.C38752m;
import com.tencent.p177mm.plugin.card.sharecard.model.C45790p;
import com.tencent.p177mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.p177mm.plugin.card.sharecard.p354ui.C42862b.C2761a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.view.C31128d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.card.sharecard.a.b */
public final class C42856b {
    private static boolean fpA = false;
    public static boolean kft = false;
    public C2761a kfs = null;
    private Context mContext;

    /* renamed from: com.tencent.mm.plugin.card.sharecard.a.b$2 */
    static class C337762 implements Runnable {
        C337762() {
        }

        public final void run() {
            int i;
            AppMethodBeat.m2504i(87983);
            C4990ab.m7416i("MicroMsg.ShareCardDataMgr", "begin to delelteAllIllegalStatusCard()");
            C20155k bbe = C42852am.bbe();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" where (status=1 OR status=2 OR status=3 OR status=4 OR status=6)");
            boolean hY = bbe.bSd.mo10108hY("ShareCardInfo", "delete from ShareCardInfo" + stringBuilder.toString());
            String str = "MicroMsg.ShareCardInfoStorage";
            StringBuilder stringBuilder2 = new StringBuilder("delelteAllIllegalStatusCard updateRet is ");
            if (hY) {
                i = 1;
            } else {
                i = 0;
            }
            C4990ab.m7416i(str, stringBuilder2.append(i).toString());
            C4990ab.m7416i("MicroMsg.ShareCardDataMgr", "end to delelteAllIllegalStatusCard()");
            AppMethodBeat.m2505o(87983);
        }
    }

    public C42856b(Context context) {
        this.mContext = context;
        kft = false;
    }

    public static int bbs() {
        int i = 0;
        AppMethodBeat.m2504i(87985);
        C27587c baW = C42852am.baW();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where (status=0 OR status=5) AND card_type=10");
        Cursor a = baW.bSd.mo10104a("select count(*) from UserCardInfo" + stringBuilder.toString(), null, 2);
        if (a == null) {
            AppMethodBeat.m2505o(87985);
        } else {
            if (a.moveToFirst()) {
                i = a.getInt(0);
            }
            a.close();
            AppMethodBeat.m2505o(87985);
        }
        return i;
    }

    /* renamed from: at */
    public final void mo68364at(String str, boolean z) {
        AppMethodBeat.m2504i(87986);
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7412e("MicroMsg.ShareCardDataMgr", "updateGetShareLayoutData json is empty");
            AppMethodBeat.m2505o(87986);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        C27593l Hw = C38738s.m65737Hw(str);
        C27593l c27593l = (C27593l) C42852am.bbb().getValue("key_share_card_layout_data");
        if (Hw == null) {
            C4990ab.m7412e("MicroMsg.ShareCardDataMgr", "updateGetShareLayoutData data == null");
            C42856b.m76080a(Hw, c27593l, z);
            C42852am.bbb().putValue("key_share_card_layout_data", Hw);
            AppMethodBeat.m2505o(87986);
            return;
        }
        if (z) {
            C38736l.m65702Ho(str);
        }
        m76081a(Hw, z);
        C42856b.m76080a(Hw, c27593l, z);
        C42852am.bbb().putValue("key_share_card_layout_data", Hw);
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
            iDKey.SetID(C31128d.MIC_PTU_TRANS_KONGCHENG);
            iDKey.SetKey(10);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(C31128d.MIC_PTU_TRANS_KONGCHENG);
            iDKey2.SetKey(11);
            iDKey2.SetValue((long) currentTimeMillis2);
            IDKey iDKey3 = new IDKey();
            iDKey3.SetID(C31128d.MIC_PTU_TRANS_KONGCHENG);
            iDKey3.SetKey(12);
            iDKey3.SetValue((long) i);
            IDKey iDKey4 = new IDKey();
            iDKey4.SetID(C31128d.MIC_PTU_TRANS_KONGCHENG);
            iDKey4.SetKey(14);
            iDKey4.SetValue((long) (currentTimeMillis2 / i));
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            arrayList.add(iDKey3);
            arrayList.add(iDKey4);
            C7060h.pYm.mo8379b(arrayList, true);
        }
        AppMethodBeat.m2505o(87986);
    }

    /* renamed from: a */
    private void m76081a(C27593l c27593l, boolean z) {
        AppMethodBeat.m2504i(87987);
        if (c27593l == null) {
            C4990ab.m7412e("MicroMsg.ShareCardDataMgr", "don't parserShareCardListData, data is null");
            AppMethodBeat.m2505o(87987);
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
        C38752m c38752m;
        String GI;
        C45790p c45790p;
        C4990ab.m7416i("MicroMsg.ShareCardDataMgr", "parserShareCardListData()");
        Map map = (Map) C42852am.bbb().getValue("key_share_card_annoucement_map");
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = map;
        }
        map = (Map) C42852am.bbb().getValue("key_share_card_count_map");
        if (map == null) {
            hashMap2 = new HashMap();
        } else {
            hashMap2 = map;
        }
        map = (Map) C42852am.bbb().getValue("key_share_card_username_map");
        if (map == null) {
            hashMap3 = new HashMap();
        } else {
            hashMap3 = map;
        }
        ArrayList arrayList4 = (ArrayList) C42852am.bbb().getValue("key_share_card_local_city_ids");
        if (arrayList4 == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = arrayList4;
        }
        arrayList4 = (ArrayList) C42852am.bbb().getValue("key_share_card_other_city_ids");
        if (arrayList4 == null) {
            arrayList2 = new ArrayList();
        } else {
            arrayList2 = arrayList4;
        }
        arrayList4 = (ArrayList) C42852am.bbb().getValue("key_share_card_other_city_top_info_list");
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
        if (c27593l.kfG != null && c27593l.kfG.size() > 0) {
            i = 0;
            while (true) {
                i2 = i;
                if (i2 >= c27593l.kfG.size()) {
                    break;
                }
                c38752m = (C38752m) c27593l.kfG.get(i2);
                if (!TextUtils.isEmpty(c38752m.kfO)) {
                    hashMap.put(c38752m.kbU, c38752m.kfO);
                }
                hashMap2.put(c38752m.kbU, Integer.valueOf(C42852am.bbe().mo35394GH(c38752m.kbU)));
                hashMap3.put(c38752m.kbU, m76090t(C42852am.bbe().mo35393GG(c38752m.kbU)));
                if (!arrayList5.contains(c38752m.kbU)) {
                    GI = C42852am.bbe().mo35395GI(c38752m.kbU);
                    if (!TextUtils.isEmpty(GI) && !arrayList.contains(GI)) {
                        arrayList.add(GI);
                    } else if (!arrayList.contains(c38752m.cMC)) {
                        arrayList.add(c38752m.cMC);
                    }
                    arrayList5.add(c38752m.kbU);
                    c45790p = new C45790p();
                    c45790p.kbU = c38752m.kbU;
                    c45790p.top = c38752m.top;
                    arrayList3.add(c45790p);
                }
                i = i2 + 1;
            }
        }
        arrayList5.clear();
        if (c27593l.kfH != null && c27593l.kfH.size() > 0) {
            i = 0;
            while (true) {
                i2 = i;
                if (i2 >= c27593l.kfH.size()) {
                    break;
                }
                c38752m = (C38752m) c27593l.kfH.get(i2);
                if (!TextUtils.isEmpty(c38752m.kfO)) {
                    hashMap.put(c38752m.kbU, c38752m.kfO);
                }
                hashMap2.put(c38752m.kbU, Integer.valueOf(C42852am.bbe().mo35394GH(c38752m.kbU)));
                hashMap3.put(c38752m.kbU, m76090t(C42852am.bbe().mo35393GG(c38752m.kbU)));
                if (!arrayList5.contains(c38752m.kbU)) {
                    GI = C42852am.bbe().mo35395GI(c38752m.kbU);
                    if (!TextUtils.isEmpty(GI) && !arrayList2.contains(GI)) {
                        arrayList2.add(GI);
                    } else if (!arrayList2.contains(c38752m.cMC)) {
                        arrayList2.add(c38752m.cMC);
                    }
                    arrayList5.add(c38752m.kbU);
                    c45790p = new C45790p();
                    c45790p.kbU = c38752m.kbU;
                    c45790p.top = c38752m.top;
                    arrayList3.add(c45790p);
                }
                i = i2 + 1;
            }
        }
        C42852am.bbb().putValue("key_share_card_annoucement_map", hashMap);
        C42852am.bbb().putValue("key_share_card_count_map", hashMap2);
        C42852am.bbb().putValue("key_share_card_username_map", hashMap3);
        C42852am.bbb().putValue("key_share_card_local_city", c27593l.kfI);
        C42852am.bbb().putValue("key_share_card_local_city_ids", arrayList);
        C42852am.bbb().putValue("key_share_card_other_city_ids", arrayList2);
        C42852am.bbb().putValue("key_share_card_other_city_top_info_list", arrayList3);
        AppMethodBeat.m2505o(87987);
    }

    /* renamed from: a */
    private static void m76080a(C27593l c27593l, C27593l c27593l2, boolean z) {
        AppMethodBeat.m2504i(87988);
        if (c27593l == null && c27593l2 == null) {
            C4990ab.m7412e("MicroMsg.ShareCardDataMgr", "don't updateCategoryType(), newData == null && oldData == null");
            AppMethodBeat.m2505o(87988);
        } else if (c27593l != null && c27593l.kfH == null && c27593l.kfG == null && c27593l2 != null && c27593l2.kfH == null && c27593l2.kfG == null) {
            C4990ab.m7412e("MicroMsg.ShareCardDataMgr", "don't updateCategoryType(), newData.local_city_list == null && oldData.local_city_list == null");
            AppMethodBeat.m2505o(87988);
        } else {
            ArrayList arrayList;
            ArrayList arrayList2;
            int i;
            int i2;
            C38752m c38752m;
            C4990ab.m7416i("MicroMsg.ShareCardDataMgr", "updateCategoryType()");
            ArrayList arrayList3 = (ArrayList) C42852am.bbb().getValue("key_share_card_local_city_category_info_list");
            if (arrayList3 == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = arrayList3;
            }
            arrayList3 = (ArrayList) C42852am.bbb().getValue("key_share_card_other_city_category_info_list");
            if (arrayList3 == null) {
                arrayList2 = new ArrayList();
            } else {
                arrayList2 = arrayList3;
            }
            int i3 = 0;
            if (z) {
                C42852am.bbe().mo35400sU(10);
                arrayList.clear();
                C42852am.bbe().mo35400sU(0);
                arrayList2.clear();
                i = 0;
            } else {
                if (!(c27593l2 == null || c27593l2.kfG == null || c27593l2.kfG.size() < 0)) {
                    i3 = c27593l2.kfG.size();
                }
                if (c27593l2 == null || c27593l2.kfH == null || c27593l2.kfH.size() < 0) {
                    i = 0;
                } else {
                    i = c27593l2.kfH.size();
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            long iV = C1720g.m3536RP().eJN.mo15639iV(Thread.currentThread().getId());
            if (c27593l != null && c27593l.kfG != null && c27593l.kfG.size() > 0) {
                i2 = 0;
                while (true) {
                    int i4 = i2;
                    if (i4 >= c27593l.kfG.size()) {
                        break;
                    }
                    c38752m = (C38752m) c27593l.kfG.get(i4);
                    C42852am.bbe().mo35398N(c38752m.kbU, 10, i4 + i3);
                    C27592i c27592i = new C27592i();
                    c27592i.kbU = c38752m.kbU;
                    c27592i.kfC = i4 + i3;
                    arrayList.add(c27592i);
                    i2 = i4 + 1;
                }
                if (!(z || c27593l2 == null || c27593l2.kfG == null)) {
                    c27593l.kfG.addAll(c27593l2.kfG);
                }
            } else if (!(c27593l == null || z || c27593l2 == null || c27593l2.kfG == null)) {
                c27593l.kfG = c27593l2.kfG;
            }
            C42852am.bbb().putValue("key_share_card_local_city_category_info_list", arrayList);
            if (c27593l != null && c27593l.kfH != null && c27593l.kfH.size() > 0) {
                i2 = 0;
                while (true) {
                    int i5 = i2;
                    if (i5 >= c27593l.kfH.size()) {
                        break;
                    }
                    c38752m = (C38752m) c27593l.kfH.get(i5);
                    C42852am.bbe().mo35398N(c38752m.kbU, 0, i5 + i);
                    C27592i c27592i2 = new C27592i();
                    c27592i2.kbU = c38752m.kbU;
                    c27592i2.kfC = i5 + i;
                    arrayList2.add(c27592i2);
                    i2 = i5 + 1;
                }
                if (!(z || c27593l2 == null || c27593l2.kfH == null)) {
                    c27593l.kfH.addAll(c27593l2.kfH);
                }
            } else if (!(c27593l == null || z || c27593l2 == null || c27593l2.kfH == null)) {
                c27593l.kfH = c27593l2.kfH;
            }
            C42852am.bbb().putValue("key_share_card_other_city_category_info_list", arrayList2);
            C1720g.m3536RP().eJN.mo15640mB(iV);
            C4990ab.m7411d("MicroMsg.ShareCardDataMgr", "updateCategoryType  >> updateCategoryInfo use time %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.m2505o(87988);
        }
    }

    public static void bbt() {
        ArrayList arrayList;
        ArrayList arrayList2;
        C27592i c27592i;
        AppMethodBeat.m2504i(87989);
        long currentTimeMillis = System.currentTimeMillis();
        long iV = C1720g.m3536RP().eJN.mo15639iV(Thread.currentThread().getId());
        C4990ab.m7416i("MicroMsg.ShareCardDataMgr", "updateShareCardCategory()");
        ArrayList arrayList3 = (ArrayList) C42852am.bbb().getValue("key_share_card_local_city_category_info_list");
        if (arrayList3 == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = arrayList3;
        }
        arrayList3 = (ArrayList) C42852am.bbb().getValue("key_share_card_other_city_category_info_list");
        if (arrayList3 == null) {
            arrayList2 = new ArrayList();
        } else {
            arrayList2 = arrayList3;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            c27592i = (C27592i) arrayList.get(i);
            C42852am.bbe().mo35398N(c27592i.kbU, 10, c27592i.kfC);
        }
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            c27592i = (C27592i) arrayList2.get(i2);
            C42852am.bbe().mo35398N(c27592i.kbU, 0, c27592i.kfC);
        }
        C1720g.m3536RP().eJN.mo15640mB(iV);
        C4990ab.m7417i("MicroMsg.ShareCardDataMgr", "updateShareCardCategory  >> updateCategoryInfo use time %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(87989);
    }

    /* renamed from: t */
    private String m76090t(ArrayList<String> arrayList) {
        AppMethodBeat.m2504i(87990);
        String a = C42856b.m76078a(this.mContext, (ArrayList) arrayList);
        AppMethodBeat.m2505o(87990);
        return a;
    }

    /* renamed from: a */
    private static String m76078a(Context context, ArrayList<String> arrayList) {
        AppMethodBeat.m2504i(87991);
        String str;
        if (arrayList == null || arrayList.size() == 0) {
            C4990ab.m7412e("MicroMsg.ShareCardDataMgr", "getShareUserName， username_list == null || username_list.size() == 0");
            str = "";
            AppMethodBeat.m2505o(87991);
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < arrayList.size() && i < 2) {
            if (i != 0) {
                stringBuilder.append("、");
            }
            String mK = C1854s.m3867mK((String) arrayList.get(i));
            str = C1854s.m3866mJ((String) arrayList.get(i));
            if (TextUtils.isEmpty(mK)) {
                stringBuilder.append(str);
            } else {
                stringBuilder.append(mK);
            }
            i++;
        }
        if (context == null) {
            C4990ab.m7412e("MicroMsg.ShareCardDataMgr", "context == null");
            str = "";
            AppMethodBeat.m2505o(87991);
            return str;
        } else if (arrayList.size() == 1 || arrayList.size() == 2) {
            str = context.getString(C25738R.string.ahh, new Object[]{stringBuilder.toString()});
            AppMethodBeat.m2505o(87991);
            return str;
        } else {
            str = context.getString(C25738R.string.agz, new Object[]{stringBuilder.toString(), Integer.valueOf(arrayList.size())});
            AppMethodBeat.m2505o(87991);
            return str;
        }
    }

    /* renamed from: GA */
    public static void m76071GA(final String str) {
        AppMethodBeat.m2504i(87992);
        C4990ab.m7416i("MicroMsg.ShareCardDataMgr", "updateShareUserInfo()");
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7412e("MicroMsg.ShareCardDataMgr", "updateShareUserInfo(), card_tp_id is empty");
            AppMethodBeat.m2505o(87992);
            return;
        }
        final C7306ak c7306ak = new C7306ak(Looper.getMainLooper());
        C7305d.post(new Runnable() {
            public final void run() {
                ArrayList arrayList = null;
                AppMethodBeat.m2504i(87982);
                C4990ab.m7416i("MicroMsg.ShareCardDataMgr", "begin to getShareUserInfo()");
                C20155k bbe = C42852am.bbe();
                String str = str;
                C4990ab.m7416i("MicroMsg.ShareCardInfoStorage", "getShareUserInfo()");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(" where ( status=0) ");
                stringBuilder.append(" AND (card_tp_id = '" + str + "' )");
                stringBuilder.append(" order by share_time desc ");
                Cursor a = bbe.bSd.mo10104a("select * from ShareCardInfo" + stringBuilder.toString(), null, 2);
                if (a == null) {
                    C4990ab.m7416i("MicroMsg.ShareCardInfoStorage", "getShareUserInfo(), cursor == null");
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    while (a.moveToNext()) {
                        ShareCardInfo shareCardInfo = new ShareCardInfo();
                        shareCardInfo.mo8995d(a);
                        C11296r c11296r;
                        if (arrayList3.contains(shareCardInfo.field_from_username)) {
                            int i = 0;
                            c11296r = null;
                            while (i < arrayList2.size()) {
                                c11296r = (C11296r) arrayList2.get(i);
                                if (shareCardInfo.field_from_username != null && shareCardInfo.field_from_username.equals(c11296r.kfT)) {
                                    break;
                                }
                                i++;
                            }
                            i = 0;
                            if (c11296r != null) {
                                c11296r.kfV.add(0, shareCardInfo.field_card_id);
                                c11296r.kfU++;
                                arrayList2.set(i, c11296r);
                            }
                        } else {
                            c11296r = new C11296r();
                            c11296r.kbU = shareCardInfo.field_card_tp_id;
                            c11296r.kfT = shareCardInfo.field_from_username;
                            c11296r.kfV = new ArrayList();
                            c11296r.kfV.add(shareCardInfo.field_card_id);
                            c11296r.kfU = 1;
                            arrayList2.add(c11296r);
                            arrayList3.add(shareCardInfo.field_from_username);
                        }
                    }
                    a.close();
                    arrayList = arrayList2;
                }
                C4990ab.m7416i("MicroMsg.ShareCardDataMgr", "end to getShareUserInfo(), 1");
                if (arrayList == null || arrayList.size() == 0) {
                    C4990ab.m7412e("MicroMsg.ShareCardDataMgr", "getShareUserInfo(), share_user_list is null");
                    AppMethodBeat.m2505o(87982);
                    return;
                }
                if (arrayList.get(0) != null) {
                    ((C11296r) arrayList.get(0)).kfW = true;
                }
                C4990ab.m7416i("MicroMsg.ShareCardDataMgr", "end to getShareUserInfo(), 2");
                c7306ak.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(87981);
                        Map map = (Map) C42852am.bbb().getValue("key_share_user_info_map");
                        if (map == null) {
                            map = new HashMap();
                        }
                        map.put(str, arrayList);
                        C42852am.bbb().putValue("key_share_user_info_map", map);
                        AppMethodBeat.m2505o(87981);
                    }
                });
                AppMethodBeat.m2505o(87982);
            }
        }, "updateShareUserInfo_thread");
        AppMethodBeat.m2505o(87992);
    }

    /* renamed from: sQ */
    public static ArrayList<String> m76087sQ(int i) {
        AppMethodBeat.m2504i(87993);
        ArrayList<String> arrayList;
        if (i == 1) {
            arrayList = (ArrayList) C42852am.bbb().getValue("key_share_card_local_city_ids");
            if (arrayList == null || arrayList.size() == 0) {
                C4990ab.m7412e("MicroMsg.ShareCardDataMgr", "getCardIds() ids == null || ids.size() == 0 for showType == ".concat(String.valueOf(i)));
                ArrayList sR = C42856b.m76088sR(i);
                AppMethodBeat.m2505o(87993);
                return sR;
            }
            AppMethodBeat.m2505o(87993);
            return arrayList;
        } else if (i == 2) {
            arrayList = (ArrayList) C42852am.bbb().getValue("key_share_card_other_city_ids");
            if (arrayList == null || arrayList.size() == 0) {
                C4990ab.m7412e("MicroMsg.ShareCardDataMgr", "getCardIds() ids == null || ids.size() == 0 for showType == ".concat(String.valueOf(i)));
                arrayList = C42856b.m76088sR(i);
                AppMethodBeat.m2505o(87993);
                return arrayList;
            }
            AppMethodBeat.m2505o(87993);
            return arrayList;
        } else {
            AppMethodBeat.m2505o(87993);
            return null;
        }
    }

    /* renamed from: sR */
    private static ArrayList<String> m76088sR(int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(87994);
        C27593l c27593l = (C27593l) C42852am.bbb().getValue("key_share_card_layout_data");
        if (c27593l == null) {
            C4990ab.m7412e("MicroMsg.ShareCardDataMgr", "getCardIdsByType() data == null for showType = ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(87994);
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i3;
        C38752m c38752m;
        String GI;
        if (i == 1) {
            if (c27593l.kfG != null && c27593l.kfG.size() > 0) {
                while (true) {
                    i3 = i2;
                    if (i3 >= c27593l.kfG.size()) {
                        break;
                    }
                    c38752m = (C38752m) c27593l.kfG.get(i3);
                    if (!arrayList2.contains(c38752m.kbU)) {
                        GI = C42852am.bbe().mo35395GI(c38752m.kbU);
                        if (!TextUtils.isEmpty(GI) && !arrayList.contains(GI)) {
                            arrayList.add(GI);
                        } else if (!arrayList.contains(c38752m.cMC)) {
                            arrayList.add(c38752m.cMC);
                        }
                        arrayList2.add(c38752m.kbU);
                    }
                    i2 = i3 + 1;
                }
                C42852am.bbb().putValue("key_share_card_local_city_ids", arrayList);
            }
            AppMethodBeat.m2505o(87994);
            return arrayList;
        } else if (i == 2) {
            if (c27593l.kfH != null && c27593l.kfH.size() > 0) {
                while (true) {
                    i3 = i2;
                    if (i3 >= c27593l.kfH.size()) {
                        break;
                    }
                    c38752m = (C38752m) c27593l.kfH.get(i3);
                    if (!arrayList2.contains(c38752m.kbU)) {
                        GI = C42852am.bbe().mo35395GI(c38752m.kbU);
                        if (!TextUtils.isEmpty(GI) && !arrayList.contains(GI)) {
                            arrayList.add(GI);
                        } else if (!arrayList.contains(c38752m.cMC)) {
                            arrayList.add(c38752m.cMC);
                        }
                        arrayList2.add(c38752m.kbU);
                    }
                    i2 = i3 + 1;
                }
                C42852am.bbb().putValue("key_share_card_other_city_ids", arrayList);
            }
            AppMethodBeat.m2505o(87994);
            return arrayList;
        } else {
            AppMethodBeat.m2505o(87994);
            return null;
        }
    }

    /* renamed from: dn */
    public static void m76083dn(String str, String str2) {
        AppMethodBeat.m2504i(87995);
        if (fpA) {
            C4990ab.m7416i("MicroMsg.ShareCardDataMgr", "is isUpdating data, don't do updateCardIdsListByCardId");
            AppMethodBeat.m2505o(87995);
            return;
        }
        String dq;
        C4990ab.m7416i("MicroMsg.ShareCardDataMgr", "do updateCardIdsListByCardId");
        fpA = true;
        ArrayList sQ = C42856b.m76087sQ(1);
        if (sQ != null && sQ.contains(str)) {
            sQ.remove(str);
            dq = C42852am.bbe().mo35399dq(str, str2);
            if (!TextUtils.isEmpty(dq)) {
                sQ.add(dq);
            }
            C42852am.bbb().putValue("key_share_card_local_city_ids", sQ);
        }
        sQ = C42856b.m76087sQ(2);
        if (sQ != null && sQ.contains(str)) {
            sQ.remove(str);
            dq = C42852am.bbe().mo35399dq(str, str2);
            if (!TextUtils.isEmpty(dq)) {
                sQ.add(dq);
            }
            C42852am.bbb().putValue("key_share_card_other_city_ids", sQ);
        }
        fpA = false;
        AppMethodBeat.m2505o(87995);
    }

    /* renamed from: do */
    public static void m76084do(String str, String str2) {
        AppMethodBeat.m2504i(87996);
        C4990ab.m7416i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId card_id:" + str + ", card_tp_id:" + str2);
        ArrayList sQ = C42856b.m76087sQ(1);
        if (sQ == null || !sQ.contains(str)) {
            ArrayList sQ2 = C42856b.m76087sQ(2);
            if (sQ2 == null || !sQ2.contains(str)) {
                C27593l c27593l = (C27593l) C42852am.bbb().getValue("key_share_card_layout_data");
                if (c27593l == null) {
                    C4990ab.m7412e("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId data == null");
                    AppMethodBeat.m2505o(87996);
                    return;
                }
                int GH = C42852am.bbe().mo35394GH(str2);
                int GC = C42856b.m76073GC(str2);
                C4990ab.m7412e("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId realCount:" + GH + " cacheCount:" + GC);
                if (c27593l.kfG != null && c27593l.kfG.size() > 0 && (GC <= 0 || GH == 1)) {
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= c27593l.kfG.size()) {
                            break;
                        }
                        C38752m c38752m = (C38752m) c27593l.kfG.get(i2);
                        if (str2 == null || !str2.contains(c38752m.kbU)) {
                            i = i2 + 1;
                        } else {
                            sQ.add(str);
                            C42852am.bbb().putValue("key_share_card_local_city_ids", sQ);
                            C4990ab.m7416i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId add for local ids, card id is ".concat(String.valueOf(str)));
                            AppMethodBeat.m2505o(87996);
                            return;
                        }
                    }
                }
                C4990ab.m7416i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId, not add for local_ids");
                if (sQ2 == null || (GC > 0 && GH != 1)) {
                    C4990ab.m7416i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId, not add for other_ids");
                    AppMethodBeat.m2505o(87996);
                    return;
                }
                sQ2.add(str);
                C42852am.bbb().putValue("key_share_card_other_city_ids", sQ2);
                C4990ab.m7416i("MicroMsg.ShareCardDataMgr", "addCardIdsListByCardId add for other ids, card id is ".concat(String.valueOf(str)));
                AppMethodBeat.m2505o(87996);
                return;
            }
            AppMethodBeat.m2505o(87996);
            return;
        }
        AppMethodBeat.m2505o(87996);
    }

    public static int bbu() {
        AppMethodBeat.m2504i(87997);
        if (C42856b.bbw()) {
            AppMethodBeat.m2505o(87997);
            return 1;
        } else if (!C42856b.bbv()) {
            AppMethodBeat.m2505o(87997);
            return 0;
        } else if (kft) {
            AppMethodBeat.m2505o(87997);
            return 3;
        } else {
            AppMethodBeat.m2505o(87997);
            return 4;
        }
    }

    public static boolean bbv() {
        AppMethodBeat.m2504i(87998);
        ArrayList arrayList = (ArrayList) C42852am.bbb().getValue("key_share_card_other_city_ids");
        if (arrayList == null || arrayList.size() <= 0) {
            AppMethodBeat.m2505o(87998);
            return false;
        }
        AppMethodBeat.m2505o(87998);
        return true;
    }

    public static boolean bbw() {
        AppMethodBeat.m2504i(87999);
        ArrayList arrayList = (ArrayList) C42852am.bbb().getValue("key_share_card_local_city_ids");
        if (arrayList == null || arrayList.size() <= 0) {
            AppMethodBeat.m2505o(87999);
            return false;
        }
        AppMethodBeat.m2505o(87999);
        return true;
    }

    /* renamed from: GB */
    public static String m76072GB(String str) {
        AppMethodBeat.m2504i(88000);
        Map map = (Map) C42852am.bbb().getValue("key_share_card_annoucement_map");
        String str2;
        if (map == null) {
            str2 = "";
            AppMethodBeat.m2505o(88000);
            return str2;
        }
        str2 = (String) map.get(str);
        AppMethodBeat.m2505o(88000);
        return str2;
    }

    /* renamed from: GC */
    public static int m76073GC(String str) {
        AppMethodBeat.m2504i(88001);
        Map map = (Map) C42852am.bbb().getValue("key_share_card_count_map");
        if (map == null) {
            AppMethodBeat.m2505o(88001);
            return 0;
        }
        Integer num = (Integer) map.get(str);
        if (num == null) {
            AppMethodBeat.m2505o(88001);
            return 0;
        }
        int intValue = num.intValue();
        AppMethodBeat.m2505o(88001);
        return intValue;
    }

    /* renamed from: rt */
    public static String m76086rt(String str) {
        AppMethodBeat.m2504i(88002);
        Map map = (Map) C42852am.bbb().getValue("key_share_card_username_map");
        String str2;
        if (map == null) {
            str2 = "";
            AppMethodBeat.m2505o(88002);
            return str2;
        }
        str2 = (String) map.get(str);
        AppMethodBeat.m2505o(88002);
        return str2;
    }

    /* renamed from: GD */
    public static ArrayList<C11296r> m76074GD(String str) {
        AppMethodBeat.m2504i(88003);
        Map map = (Map) C42852am.bbb().getValue("key_share_user_info_map");
        if (map == null) {
            map = new HashMap();
        }
        ArrayList<C11296r> arrayList = (ArrayList) map.get(str);
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList();
            AppMethodBeat.m2505o(88003);
            return arrayList2;
        }
        AppMethodBeat.m2505o(88003);
        return arrayList;
    }

    /* renamed from: H */
    private static void m76077H(String str, String str2, String str3) {
        Map hashMap;
        ArrayList arrayList;
        AppMethodBeat.m2504i(88004);
        Map map = (Map) C42852am.bbb().getValue("key_share_user_info_map");
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
            C11296r c11296r = (C11296r) arrayList.get(i);
            if (str3 != null && str3.equals(c11296r.kfT)) {
                c11296r.kfW = false;
                c11296r.kfU--;
                c11296r.kfV.remove(str);
                arrayList.set(i, c11296r);
            }
        }
        hashMap.put(str2, arrayList);
        C42852am.bbb().putValue("key_share_user_info_map", hashMap);
        AppMethodBeat.m2505o(88004);
    }

    public static void bbx() {
        AppMethodBeat.m2504i(88005);
        C4990ab.m7416i("MicroMsg.ShareCardDataMgr", "delelteAllIllegalStatusCard()");
        C7305d.post(new C337762(), "delelteAllIllegalStatusCard");
        AppMethodBeat.m2505o(88005);
    }

    /* renamed from: ad */
    public static void m76082ad(Context context, String str) {
        Map hashMap;
        AppMethodBeat.m2504i(88006);
        C4990ab.m7416i("MicroMsg.ShareCardDataMgr", "updateCardCountbyCardTpId() card_tp_id:".concat(String.valueOf(str)));
        Map map = (Map) C42852am.bbb().getValue("key_share_card_count_map");
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = map;
        }
        map = (Map) C42852am.bbb().getValue("key_share_card_username_map");
        if (map == null) {
            map = new HashMap();
        }
        hashMap.put(str, Integer.valueOf(C42852am.bbe().mo35394GH(str)));
        map.put(str, C42856b.m76078a(context, C42852am.bbe().mo35393GG(str)));
        C42852am.bbb().putValue("key_share_card_count_map", hashMap);
        C42852am.bbb().putValue("key_share_card_username_map", map);
        AppMethodBeat.m2505o(88006);
    }

    /* renamed from: sS */
    public static boolean m76089sS(int i) {
        AppMethodBeat.m2504i(88007);
        Integer num = (Integer) C42852am.bbb().getValue("key_share_card_show_type");
        ArrayList arrayList;
        if (num == null) {
            AppMethodBeat.m2505o(88007);
            return false;
        } else if (num.intValue() == 0) {
            AppMethodBeat.m2505o(88007);
            return false;
        } else if (i == 0) {
            arrayList = (ArrayList) C42852am.bbb().getValue("key_share_card_other_city_ids");
            if (arrayList == null || arrayList.size() == 0) {
                AppMethodBeat.m2505o(88007);
                return false;
            }
            AppMethodBeat.m2505o(88007);
            return true;
        } else if (i == 10) {
            arrayList = (ArrayList) C42852am.bbb().getValue("key_share_card_local_city_ids");
            if (arrayList == null || arrayList.size() == 0) {
                AppMethodBeat.m2505o(88007);
                return false;
            }
            AppMethodBeat.m2505o(88007);
            return true;
        } else {
            AppMethodBeat.m2505o(88007);
            return false;
        }
    }

    /* renamed from: GE */
    public static boolean m76075GE(String str) {
        AppMethodBeat.m2504i(88008);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(88008);
            return false;
        }
        ArrayList arrayList = (ArrayList) C42852am.bbb().getValue("key_share_card_other_city_top_info_list");
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C45790p c45790p = (C45790p) it.next();
            if (c45790p != null && str.equals(c45790p.kbU) && c45790p.top == 1) {
                AppMethodBeat.m2505o(88008);
                return true;
            }
        }
        AppMethodBeat.m2505o(88008);
        return false;
    }

    /* renamed from: GF */
    public static void m76076GF(String str) {
        AppMethodBeat.m2504i(88009);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(88009);
            return;
        }
        ArrayList arrayList;
        ArrayList arrayList2 = (ArrayList) C42852am.bbb().getValue("key_share_card_other_city_top_info_list");
        if (arrayList2 == null) {
            arrayList = new ArrayList();
        } else {
            arrayList = arrayList2;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < arrayList.size()) {
                C45790p c45790p = (C45790p) arrayList.get(i2);
                if (c45790p != null && str.equals(c45790p.kbU) && c45790p.top == 1) {
                    c45790p.kfS = true;
                    arrayList.set(i2, c45790p);
                    C42852am.bbb().putValue("key_share_card_other_city_top_info_list", arrayList);
                    AppMethodBeat.m2505o(88009);
                    return;
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(88009);
                return;
            }
        }
    }

    /* renamed from: dp */
    public static String m76085dp(String str, String str2) {
        AppMethodBeat.m2504i(88010);
        C4990ab.m7416i("MicroMsg.ShareCardDataMgr", "initShareUserCardId()");
        if (str2 != null) {
            ArrayList GD = C42856b.m76074GD(str2);
            if (GD == null || GD.size() <= 0) {
                C4990ab.m7412e("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), shareUserInfoList is null");
            } else {
                C11296r c11296r = (C11296r) GD.get(0);
                if (c11296r == null || c11296r.kfV == null || c11296r.kfV.size() <= 0 || str.equals(c11296r.kfV.get(0))) {
                    C4990ab.m7416i("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), mCardId is first!");
                } else {
                    String str3 = (String) c11296r.kfV.get(0);
                    C4990ab.m7416i("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), mCardId is not first!, reset it");
                    str = str3;
                }
            }
        } else {
            C4990ab.m7412e("MicroMsg.ShareCardDataMgr", "initShareUserCardId(), card_tp_id is null");
        }
        AppMethodBeat.m2505o(88010);
        return str;
    }

    public static boolean bby() {
        AppMethodBeat.m2504i(88011);
        C27593l c27593l = (C27593l) C42852am.bbb().getValue("key_share_card_layout_data");
        if (c27593l == null) {
            AppMethodBeat.m2505o(88011);
            return true;
        }
        boolean z = c27593l.kfJ;
        AppMethodBeat.m2505o(88011);
        return z;
    }

    public static boolean bbz() {
        AppMethodBeat.m2504i(88012);
        C27593l c27593l = (C27593l) C42852am.bbb().getValue("key_share_card_layout_data");
        if (c27593l == null) {
            AppMethodBeat.m2505o(88012);
            return true;
        }
        boolean z = c27593l.kfK;
        AppMethodBeat.m2505o(88012);
        return z;
    }

    public static boolean bbA() {
        AppMethodBeat.m2504i(88013);
        Integer num = (Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_CARD_HAS_UPDATE_CARD_TYPE_INT_SYNC, Integer.valueOf(0));
        if (num == null || num.intValue() != 1) {
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CARD_HAS_UPDATE_CARD_TYPE_INT_SYNC, Integer.valueOf(1));
            Cursor a = C42852am.baW().mo45384a(C11290a.NORMAL_TYPE);
            if (a == null || a.getCount() <= 0) {
                C4990ab.m7412e("MicroMsg.ShareCardDataMgr", "updateAllCardInfoByBlockField cursor is null or size is 0");
                AppMethodBeat.m2505o(88013);
                return false;
            }
            a.moveToFirst();
            while (!a.isAfterLast()) {
                CardInfo cardInfo = new CardInfo();
                cardInfo.mo8995d(a);
                if (cardInfo.field_card_type == -1) {
                    if (cardInfo.aZV() == null) {
                        C4990ab.m7412e("MicroMsg.ShareCardDataMgr", "updateCardType fail , info.getCardTpInfo() == null");
                    } else {
                        cardInfo.field_card_type = cardInfo.aZV().iAd;
                        if (!C42852am.baW().mo10103c(cardInfo, new String[0])) {
                            C4990ab.m7413e("MicroMsg.ShareCardDataMgr", "updateCardType fail , cardId = %s", cardInfo.field_card_id);
                        }
                    }
                }
                a.moveToNext();
            }
            a.close();
            AppMethodBeat.m2505o(88013);
            return true;
        }
        AppMethodBeat.m2505o(88013);
        return false;
    }

    /* renamed from: a */
    public static void m76079a(Context context, C42837b c42837b) {
        AppMethodBeat.m2504i(88014);
        C4990ab.m7416i("MicroMsg.ShareCardDataMgr", "updateShareCardData()");
        C4990ab.m7416i("MicroMsg.ShareCardDataMgr", "card id:" + c42837b.aZZ() + " cardtpid:" + c42837b.baa());
        C42856b.m76083dn(c42837b.aZZ(), c42837b.baa());
        if (context != null) {
            C42856b.m76082ad(context, c42837b.baa());
        }
        C42856b.m76077H(c42837b.aZZ(), c42837b.baa(), c42837b.bab());
        C42856b.m76071GA(c42837b.baa());
        AppMethodBeat.m2505o(88014);
    }

    public final void init() {
        AppMethodBeat.m2504i(87984);
        if (((C27593l) C42852am.bbb().getValue("key_share_card_layout_data")) == null) {
            C4990ab.m7412e("MicroMsg.ShareCardDataMgr", "initShareCardLayoutData, data cache is empty!, load data from db!");
            String beF = C38736l.beF();
            if (TextUtils.isEmpty(beF)) {
                C4990ab.m7412e("MicroMsg.ShareCardDataMgr", "initShareCardLayoutData, json is empty");
                AppMethodBeat.m2505o(87984);
                return;
            }
            C27593l Hw = C38738s.m65737Hw(beF);
            if (Hw != null) {
                C4990ab.m7416i("MicroMsg.ShareCardDataMgr", "load share card layout data success!");
                C42852am.bbb().putValue("key_share_card_layout_data", Hw);
                m76081a(Hw, true);
                AppMethodBeat.m2505o(87984);
                return;
            }
            C4990ab.m7412e("MicroMsg.ShareCardDataMgr", "load share card layout data fail!");
            AppMethodBeat.m2505o(87984);
            return;
        }
        C4990ab.m7416i("MicroMsg.ShareCardDataMgr", "the share card layout cache is valid!");
        AppMethodBeat.m2505o(87984);
    }
}
