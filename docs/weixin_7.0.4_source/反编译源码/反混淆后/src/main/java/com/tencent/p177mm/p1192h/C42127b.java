package com.tencent.p177mm.p1192h;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p230g.p231a.C6459ak;
import com.tencent.p177mm.p230g.p231a.C6459ak.C1524a;
import com.tencent.p177mm.p230g.p231a.C6549tm;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.account.p275ui.DisasterUI;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.tencent.mm.h.b */
public final class C42127b {
    public C42126a eeU;
    public Map<Integer, Long> eeV = new HashMap();
    public Map<Long, C42126a> eeW = new HashMap();
    public C4884c eeX = new C263221();

    /* renamed from: com.tencent.mm.h.b$1 */
    class C263221 extends C4884c<C6459ak> {
        C263221() {
            AppMethodBeat.m2504i(16060);
            this.xxI = C6459ak.class.getName().hashCode();
            AppMethodBeat.m2505o(16060);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(16061);
            C6459ak c6459ak = (C6459ak) c4883b;
            C1524a c1524a = c6459ak.cto;
            C42127b c42127b;
            long j;
            C42126a c42126a;
            C6549tm c6549tm;
            switch (c1524a.type) {
                case 1:
                    c42127b = C42127b.this;
                    String str = c1524a.ctq;
                    j = C5046bo.getLong(str, 0);
                    int i = c1524a.position;
                    C4990ab.m7417i("MicroMsg.BroadcastController", "summerdiz cancelUIEvent cancelNoticeIDStr[%s] cancelPosition[%d], oldNoticeInfo[%s] newDisasterNoticeInfoMap[%d] ", str, Integer.valueOf(i), c42127b.eeU, Integer.valueOf(c42127b.eeW.size()));
                    if (c42127b.eeW.size() > 0 && j > 0) {
                        c42126a = (C42126a) c42127b.eeW.get(Long.valueOf(j));
                        if (c42126a != null) {
                            C4990ab.m7417i("MicroMsg.BroadcastController", "summerdiz cancelUIEvent found info[%s]", c42126a);
                            if (i <= 0) {
                                Collection values = c42126a.efe.values();
                                if (values != null) {
                                    Iterator it = values.iterator();
                                    if (it != null) {
                                        while (it.hasNext()) {
                                            c6549tm = (C6549tm) it.next();
                                            if (c6549tm != null && c6549tm.cPH.aIB) {
                                                C4990ab.m7417i("MicroMsg.BroadcastController", "summerdiz cancelPosition[%d] found event[%b]", Long.valueOf(j), Boolean.valueOf(c6549tm.cPH.aIB));
                                                c6549tm.cPH.aIB = false;
                                                C4879a.xxA.mo10055m(c6549tm);
                                            }
                                        }
                                        break;
                                    }
                                }
                            }
                            c6549tm = (C6549tm) c42126a.efe.get(Integer.valueOf(i));
                            if (c6549tm != null) {
                                C4990ab.m7417i("MicroMsg.BroadcastController", "summerdiz cancelPosition[%d] found event[%b]", Integer.valueOf(i), Boolean.valueOf(c6549tm.cPH.aIB));
                                if (c6549tm.cPH.aIB) {
                                    c6549tm.cPH.aIB = false;
                                    C4879a.xxA.mo10055m(c6549tm);
                                    C7060h.pYm.mo8381e(13939, Integer.valueOf(2));
                                    break;
                                }
                            }
                            C4990ab.m7417i("MicroMsg.BroadcastController", "summerdiz cancelPosition[%d] not found event", Integer.valueOf(i));
                        } else {
                            C4990ab.m7416i("MicroMsg.BroadcastController", "summerdiz cancelNoticeID not found info");
                        }
                    }
                    if (c42127b.eeU != null) {
                        if (!C5046bo.isNullOrNil(str) && !str.equals(c42127b.eeU.efb)) {
                            C4990ab.m7417i("MicroMsg.BroadcastController", "summerdiz cancelUIEvent old now:[%s], want to cancel:[%s], drop id", c42127b.eeU.efb, str);
                            break;
                        }
                        c6549tm = (C6549tm) c42127b.eeU.efe.get(Integer.valueOf(0));
                        if (c6549tm != null && c6549tm.cPH.aIB) {
                            C7060h.pYm.mo8381e(13939, Integer.valueOf(2));
                            c6549tm.cPH.aIB = false;
                            C4879a.xxA.mo10055m(c6549tm);
                            break;
                        }
                    }
                    break;
                case 2:
                    c42127b = C42127b.this;
                    int i2 = c6459ak.cto.position;
                    C4990ab.m7417i("MicroMsg.BroadcastController", "summerdiz handlePullNotify position[%d],oldNoticeInfo[%s], positionNoticeIdMap[%d]", Integer.valueOf(i2), c42127b.eeU, Integer.valueOf(c42127b.eeV.size()));
                    if (i2 <= 0 || c42127b.eeV.size() <= 0) {
                        if (c42127b.eeU != null) {
                            c6549tm = (C6549tm) c42127b.eeU.efe.get(Integer.valueOf(0));
                            if (c6549tm != null) {
                                c6459ak.ctp.desc = c6549tm.cPH.desc;
                                c6459ak.ctp.ctr = c6549tm.cPH.ctr;
                                c6459ak.ctp.showType = c6549tm.cPH.showType;
                                c6459ak.ctp.url = c6549tm.cPH.url;
                                c6459ak.ctp.aIB = c6549tm.cPH.aIB;
                                c6459ak.ctp.ctt = c6549tm.cPH.ctt;
                                c6459ak.ctp.cts = c6549tm.cPH.cts;
                                c6459ak.ctp.Title = c6549tm.cPH.Title;
                                c6459ak.ctp.ctu = c6549tm.cPH.ctu;
                                c6459ak.ctp.position = c6549tm.cPH.position;
                                if (c6549tm.cPH.aIB) {
                                    C7060h.pYm.mo8381e(13936, Integer.valueOf(i2));
                                }
                                c42127b.mo67672Jb();
                                break;
                            }
                        }
                    }
                    j = C5046bo.m7514a((Long) c42127b.eeV.get(Integer.valueOf(i2)), 0);
                    C4990ab.m7417i("MicroMsg.BroadcastController", "summerdiz handlePullNotify position[%d] found noticeId[%d]", Integer.valueOf(i2), Long.valueOf(j));
                    if (j > 0) {
                        c42126a = (C42126a) c42127b.eeW.get(Long.valueOf(j));
                        if (c42126a != null) {
                            c6549tm = (C6549tm) c42126a.efe.get(Integer.valueOf(i2));
                            if (c6549tm != null) {
                                c6459ak.ctp.desc = c6549tm.cPH.desc;
                                c6459ak.ctp.ctr = c6549tm.cPH.ctr;
                                c6459ak.ctp.showType = c6549tm.cPH.showType;
                                c6459ak.ctp.url = c6549tm.cPH.url;
                                c6459ak.ctp.aIB = c6549tm.cPH.aIB;
                                c6459ak.ctp.ctt = c6549tm.cPH.ctt;
                                c6459ak.ctp.cts = c6549tm.cPH.cts;
                                c6459ak.ctp.Title = c6549tm.cPH.Title;
                                c6459ak.ctp.ctu = c6549tm.cPH.ctu;
                                c6459ak.ctp.position = c6549tm.cPH.position;
                                if (c6549tm.cPH.aIB) {
                                    C7060h.pYm.mo8381e(13936, Integer.valueOf(i2));
                                    break;
                                }
                            }
                        }
                        c42127b.eeV.remove(Integer.valueOf(i2));
                        break;
                    }
                    break;
                case 4:
                    C42127b.this.mo67674jZ(c1524a.ctq);
                    break;
                case 5:
                    C42127b.this.mo67673a(c6459ak);
                    break;
            }
            AppMethodBeat.m2505o(16061);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.h.b$a */
    static class C42126a {
        String efb = null;
        long efc = 0;
        String efd = null;
        Map<Integer, C6549tm> efe = new HashMap();

        C42126a() {
            AppMethodBeat.m2504i(16064);
            AppMethodBeat.m2505o(16064);
        }

        public final String toString() {
            String str;
            AppMethodBeat.m2504i(16065);
            String str2 = "";
            Iterator it = this.efe.keySet().iterator();
            while (true) {
                str = str2;
                if (!it.hasNext()) {
                    break;
                }
                str2 = str + ((Integer) it.next()) + ",";
            }
            if (str.length() > 0) {
                str = str.substring(0, str.length() - 1);
            }
            str2 = String.format("NoticeInfo(%d){noticeID[%s], disasterTick[%d], content[%s], posistions[%s]}", new Object[]{Integer.valueOf(hashCode()), this.efb, Long.valueOf(this.efc), this.efd, str});
            AppMethodBeat.m2505o(16065);
            return str2;
        }
    }

    public C42127b() {
        AppMethodBeat.m2504i(16066);
        AppMethodBeat.m2505o(16066);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final boolean mo67673a(C6459ak c6459ak) {
        AppMethodBeat.m2504i(16067);
        String str = c6459ak.cto.ctq;
        String str2 = "MicroMsg.BroadcastController";
        String str3 = "summerdiz handleNewDisaster xml len[%d]";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(str == null ? -1 : str.length());
        C4990ab.m7417i(str2, str3, objArr);
        Map z = C5049br.m7595z(str, "e");
        if (z == null) {
            C4990ab.m7412e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster this is not errmsg");
            AppMethodBeat.m2505o(16067);
            return false;
        }
        C4990ab.m7417i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster values[%s]", z);
        long j = C5046bo.getLong((String) z.get(".e.NoticeId"), 0);
        if (j <= 0) {
            C4990ab.m7412e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster noticeID null");
        }
        if (!C1947ae.gjE) {
            try {
                if (C5046bo.m7549fp(C5046bo.getLong((String) z.get(".e.ExpiredTime"), 0)) > 0) {
                    C4990ab.m7417i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster expiredTime is too small, drop id:%d", Long.valueOf(C5046bo.getLong((String) z.get(".e.ExpiredTime"), 0)));
                    AppMethodBeat.m2505o(16067);
                    return false;
                }
            } catch (Exception e) {
                C4990ab.m7417i("MicroMsg.BroadcastController", "parseLong expiredTime error:%s", e);
            }
        }
        C42126a c42126a = new C42126a();
        c42126a.efb = String.valueOf(j);
        String string = C4996ah.getContext().getSharedPreferences("disaster_pref", C1448h.m3078Mu()).getString("disaster_noticeid_list_key", "");
        if (C1947ae.gjF || !string.contains(c42126a.efb)) {
            C42126a c42126a2;
            if (this.eeW.size() > 0) {
                C42126a c42126a3 = (C42126a) this.eeW.get(Long.valueOf(j));
                if (c42126a3 != null) {
                    C4990ab.m7417i("MicroMsg.BroadcastController", "summerdiz  handleNewDisaster found info in map[%s]", c42126a3);
                    c42126a2 = c42126a3;
                } else {
                    this.eeW.put(Long.valueOf(j), c42126a);
                    c42126a2 = c42126a;
                }
            } else {
                this.eeW.put(Long.valueOf(j), c42126a);
                c42126a2 = c42126a;
            }
            string = (String) z.get(".e.Position");
            if (C5046bo.isNullOrNil(string)) {
                C4990ab.m7412e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positionStr is null!");
                AppMethodBeat.m2505o(16067);
                return false;
            }
            ArrayList arrayList = new ArrayList();
            String[] split = string.split(",");
            if (split == null || split.length <= 0) {
                C4990ab.m7412e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positionStr id invaild!");
                AppMethodBeat.m2505o(16067);
                return false;
            }
            Object obj = null;
            int length = split.length;
            int i = 0;
            while (i < length) {
                Object obj2;
                int i2 = C5046bo.getInt(split[i], 0);
                if (i2 > 0) {
                    if (i2 == 1) {
                        obj2 = 1;
                        C4990ab.m7417i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster found tonyTips[%d]", Integer.valueOf(i2));
                        i++;
                        obj = obj2;
                    } else {
                        arrayList.add(Integer.valueOf(i2));
                    }
                }
                obj2 = obj;
                i++;
                obj = obj2;
            }
            if (obj == null && arrayList.size() == 0) {
                C4990ab.m7412e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positions size is 0!");
                AppMethodBeat.m2505o(16067);
                return false;
            }
            C4990ab.m7417i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster curLang[%s]", C4988aa.m7403gw(C4996ah.getContext()));
            String str4 = null;
            String str5 = null;
            String str6 = null;
            int i3 = 0;
            while (true) {
                str2 = ".e.Item" + (i3 == 0 ? "" : Integer.valueOf(i3));
                string = (String) z.get(str2 + ".Language");
                if (string == null && i3 > 3) {
                    string = null;
                    str = null;
                    str2 = null;
                    break;
                } else if (r18.equalsIgnoreCase(string)) {
                    string = (String) z.get(str2 + ".Content");
                    str = (String) z.get(str2 + ".Url");
                    str2 = (String) z.get(str2 + ".Tips");
                    break;
                } else {
                    if ("en".equalsIgnoreCase(string)) {
                        string = (String) z.get(str2 + ".Content");
                        str = (String) z.get(str2 + ".Url");
                        str2 = (String) z.get(str2 + ".Tips");
                    } else {
                        str2 = str6;
                        str = str5;
                        string = str4;
                    }
                    i3++;
                    str6 = str2;
                    str5 = str;
                    str4 = string;
                }
            }
            C4990ab.m7417i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster content[%s] tips[%s]", string, str2);
            if (C5046bo.isNullOrNil(string)) {
                C4990ab.m7416i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster cann't hit curLang");
            } else {
                str4 = string;
                str5 = str;
                str6 = str2;
            }
            if (C5046bo.isNullOrNil(str5)) {
                str5 = C4996ah.getContext().getString(C25738R.string.b6c);
            }
            if (obj != null) {
                if (C5046bo.isNullOrNil(str4)) {
                    str4 = C4996ah.getContext().getString(C25738R.string.b67);
                }
                if (C5046bo.isNullOrNil(str6)) {
                    str6 = C4996ah.getContext().getString(C25738R.string.b6a);
                }
                c6459ak.ctp.desc = str4;
                c6459ak.ctp.ctr = 30;
                c6459ak.ctp.showType = 0;
                c6459ak.ctp.url = str5;
                c6459ak.ctp.aIB = true;
                c6459ak.ctp.ctt = 0;
                c6459ak.ctp.cts = 6;
                c6459ak.ctp.Title = "";
                c6459ak.ctp.ctu = String.valueOf(j);
                c6459ak.ctp.position = 1;
            }
            if (arrayList.size() == 0) {
                C4990ab.m7416i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster no other position need to tip");
                AppMethodBeat.m2505o(16067);
                return false;
            } else if (c42126a2.efc == 0 || C5046bo.m7525az(c42126a2.efc) >= 1800000) {
                c42126a2.efc = C5046bo.m7588yz();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Integer num = (Integer) it.next();
                    Long valueOf = Long.valueOf(C5046bo.m7514a((Long) this.eeV.get(num), 0));
                    if (valueOf.longValue() <= 0 || valueOf.longValue() < j) {
                        C6549tm c6549tm;
                        C6549tm c6549tm2 = (C6549tm) c42126a2.efe.get(num);
                        if (c6549tm2 == null) {
                            c6549tm2 = new C6549tm();
                            c6549tm2.cPH.showType = 0;
                            c6549tm2.cPH.ctr = 30;
                            c6549tm2.cPH.Title = "";
                            c6549tm2.cPH.ctt = 2130970230;
                            c6549tm2.cPH.position = num.intValue();
                            c42126a2.efe.put(num, c6549tm2);
                            c6549tm = c6549tm2;
                        } else {
                            c6549tm = c6549tm2;
                        }
                        if (C5046bo.isNullOrNil(str6)) {
                            str = str4;
                        } else {
                            str = str6;
                        }
                        if (C5046bo.isNullOrNil(str)) {
                            i = C25738R.string.b6_;
                            switch (num.intValue()) {
                                case 2:
                                    i = C25738R.string.b6b;
                                    break;
                                case 3:
                                case 4:
                                    i = C25738R.string.b69;
                                    break;
                            }
                            str = C4996ah.getContext().getString(i);
                        }
                        c6549tm.cPH.desc = str;
                        c6549tm.cPH.url = str5;
                        c6549tm.cPH.aIB = true;
                        c6549tm.cPH.cts = 2;
                        c6549tm.cPH.ctu = c42126a2.efb;
                        this.eeV.put(num, Long.valueOf(j));
                        if (obj == null) {
                            c6459ak.ctp.desc = str;
                            c6459ak.ctp.ctr = 30;
                            c6459ak.ctp.showType = 0;
                            c6459ak.ctp.url = str5;
                            c6459ak.ctp.aIB = true;
                            c6459ak.ctp.ctt = 2130970230;
                            c6459ak.ctp.cts = 2;
                            c6459ak.ctp.Title = "";
                            c6459ak.ctp.ctu = String.valueOf(j);
                            c6459ak.ctp.position = num.intValue();
                        }
                        C5004al.m7441d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(16062);
                                C4879a.xxA.mo10055m(c6549tm);
                                AppMethodBeat.m2505o(16062);
                            }
                        });
                        str6 = str;
                    } else {
                        C4990ab.m7417i("MicroMsg.BroadcastController", "summerdiz p[%d] has bigger oldPositionNoticeId[%d, %d]", num, valueOf, Long.valueOf(j));
                    }
                }
                AppMethodBeat.m2505o(16067);
                return true;
            } else {
                C4990ab.m7416i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster disasterTick within half an hour, drop it");
                AppMethodBeat.m2505o(16067);
                return false;
            }
        }
        C4990ab.m7417i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster noticeIdList %s contain notifyID:%s, drop id", string, c42126a.efb);
        AppMethodBeat.m2505o(16067);
        return false;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: jZ */
    public final boolean mo67674jZ(String str) {
        AppMethodBeat.m2504i(16068);
        C4990ab.m7417i("MicroMsg.BroadcastController", "summerdiz handleEventOOB oldNoticeInfo[%s], event[%s]", this.eeU, str);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(16068);
            return false;
        } else if (str.indexOf("<") < 0) {
            AppMethodBeat.m2505o(16068);
            return false;
        } else {
            Map z = C5049br.m7595z(str, "e");
            if (z == null) {
                C4990ab.m7412e("MicroMsg.BroadcastController", "this is not errmsg");
                AppMethodBeat.m2505o(16068);
                return false;
            }
            C6549tm c6549tm;
            if (this.eeU == null) {
                this.eeU = new C42126a();
                c6549tm = new C6549tm();
                this.eeU.efe.put(Integer.valueOf(0), c6549tm);
                c6549tm.cPH.desc = "";
                c6549tm.cPH.url = "";
                c6549tm.cPH.showType = 0;
                c6549tm.cPH.ctr = 30;
                c6549tm.cPH.aIB = false;
                c6549tm.cPH.Title = "";
                c6549tm.cPH.cts = 0;
                c6549tm.cPH.ctt = 2130970230;
                c6549tm.cPH.ctu = "";
                c6549tm.cPH.position = 0;
            }
            if (!C1947ae.gjD) {
                if (this.eeU.efc == 0 || C5046bo.m7525az(this.eeU.efc) >= 1800000) {
                    this.eeU.efc = C5046bo.m7588yz();
                } else {
                    C4990ab.m7416i("MicroMsg.BroadcastController", "disasterTick within half an hour, drop it");
                    AppMethodBeat.m2505o(16068);
                    return false;
                }
            }
            if (!C1947ae.gjE) {
                try {
                    if (C5046bo.m7549fp(C5046bo.getLong((String) z.get(".e.ExpiredTime"), 0)) > 0) {
                        C4990ab.m7417i("MicroMsg.BroadcastController", "expiredTime is too small, drop id:%d", Long.valueOf(C5046bo.getLong((String) z.get(".e.ExpiredTime"), 0)));
                        AppMethodBeat.m2505o(16068);
                        return false;
                    }
                } catch (Exception e) {
                    C4990ab.m7417i("MicroMsg.BroadcastController", "parseLong expiredTime error:%s", e);
                }
            }
            this.eeU.efb = (String) z.get(".e.NoticeId");
            String string = C4996ah.getContext().getSharedPreferences("disaster_pref", C1448h.m3078Mu()).getString("disaster_noticeid_list_key", "");
            if (C1947ae.gjF || !string.contains(this.eeU.efb)) {
                String str2;
                String str3;
                String gw = C4988aa.m7403gw(C4996ah.getContext());
                String str4 = null;
                String str5 = null;
                String str6 = null;
                int i = 0;
                while (true) {
                    str2 = ".e.Item" + (i == 0 ? "" : Integer.valueOf(i));
                    string = (String) z.get(str2 + ".Language");
                    if (string == null && i > 3) {
                        str3 = null;
                        string = null;
                        str2 = null;
                        break;
                    } else if (gw.equalsIgnoreCase(string)) {
                        string = (String) z.get(str2 + ".Content");
                        str3 = (String) z.get(str2 + ".Url");
                        str2 = (String) z.get(str2 + ".Tips");
                        break;
                    } else {
                        if ("en".equalsIgnoreCase(string)) {
                            string = (String) z.get(str2 + ".Content");
                            str3 = (String) z.get(str2 + ".Url");
                            str2 = (String) z.get(str2 + ".Tips");
                        } else {
                            str2 = str4;
                            str3 = str5;
                            string = str6;
                        }
                        i++;
                        str4 = str2;
                        str5 = str3;
                        str6 = string;
                    }
                }
                if (C5046bo.isNullOrNil(string)) {
                    C4990ab.m7416i("MicroMsg.BroadcastController", "handleEventOOB cann't hit curLang");
                } else {
                    str5 = str3;
                    str6 = string;
                    str4 = str2;
                }
                if (C5046bo.isNullOrNil(str5)) {
                    str5 = C4996ah.getContext().getString(C25738R.string.b6c);
                }
                if (C5046bo.isNullOrNil(str6)) {
                    C4990ab.m7416i("MicroMsg.BroadcastController", "handleEventOOB defContent is also null use hardcode");
                    str6 = C4996ah.getContext().getString(C25738R.string.b66);
                }
                if (C5046bo.isNullOrNil(str4)) {
                    if (C5046bo.isNullOrNil(str6)) {
                        str4 = C4996ah.getContext().getString(C25738R.string.b6_);
                    } else {
                        str4 = str6;
                    }
                }
                c6549tm = (C6549tm) this.eeU.efe.get(Integer.valueOf(0));
                c6549tm.cPH.desc = str4;
                c6549tm.cPH.url = str5;
                c6549tm.cPH.aIB = true;
                c6549tm.cPH.cts = 2;
                c6549tm.cPH.ctu = this.eeU.efb;
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(16063);
                        C4990ab.m7416i("MicroMsg.BroadcastController", "summerdiz handleEventOOB publish uiEvent");
                        C4879a.xxA.mo10055m(c6549tm);
                        AppMethodBeat.m2505o(16063);
                    }
                });
                this.eeU.efd = str6;
                if (C9638aw.m17182Rg().foreground) {
                    mo67672Jb();
                }
                AppMethodBeat.m2505o(16068);
                return true;
            }
            C4990ab.m7417i("MicroMsg.BroadcastController", "noticeIdList %s contain notifyID:%s, drop id", string, this.eeU.efb);
            AppMethodBeat.m2505o(16068);
            return false;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: Jb */
    public final void mo67672Jb() {
        AppMethodBeat.m2504i(16069);
        if (this.eeU == null || this.eeU.efe.get(Integer.valueOf(0)) == null || C5046bo.isNullOrNil(this.eeU.efd)) {
            AppMethodBeat.m2505o(16069);
            return;
        }
        C4990ab.m7417i("MicroMsg.BroadcastController", "summerdize checkShowDisasterContent showDisasterContent[%s]", this.eeU.efd);
        Intent intent = new Intent();
        intent.putExtra("key_disaster_content", this.eeU.efd);
        intent.putExtra("key_disaster_url", ((C6549tm) this.eeU.efe.get(Integer.valueOf(0))).cPH.url);
        intent.setClass(C4996ah.getContext(), DisasterUI.class).addFlags(268435456);
        C4996ah.getContext().startActivity(intent);
        this.eeU.efd = null;
        AppMethodBeat.m2505o(16069);
    }
}
