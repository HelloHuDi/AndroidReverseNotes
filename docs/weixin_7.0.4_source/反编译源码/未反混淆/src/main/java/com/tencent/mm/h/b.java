package com.tencent.mm.h;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.tm;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.account.ui.DisasterUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class b {
    public a eeU;
    public Map<Integer, Long> eeV = new HashMap();
    public Map<Long, a> eeW = new HashMap();
    public c eeX = new c<ak>() {
        {
            AppMethodBeat.i(16060);
            this.xxI = ak.class.getName().hashCode();
            AppMethodBeat.o(16060);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(16061);
            ak akVar = (ak) bVar;
            com.tencent.mm.g.a.ak.a aVar = akVar.cto;
            b bVar2;
            long j;
            a aVar2;
            tm tmVar;
            switch (aVar.type) {
                case 1:
                    bVar2 = b.this;
                    String str = aVar.ctq;
                    j = bo.getLong(str, 0);
                    int i = aVar.position;
                    ab.i("MicroMsg.BroadcastController", "summerdiz cancelUIEvent cancelNoticeIDStr[%s] cancelPosition[%d], oldNoticeInfo[%s] newDisasterNoticeInfoMap[%d] ", str, Integer.valueOf(i), bVar2.eeU, Integer.valueOf(bVar2.eeW.size()));
                    if (bVar2.eeW.size() > 0 && j > 0) {
                        aVar2 = (a) bVar2.eeW.get(Long.valueOf(j));
                        if (aVar2 != null) {
                            ab.i("MicroMsg.BroadcastController", "summerdiz cancelUIEvent found info[%s]", aVar2);
                            if (i <= 0) {
                                Collection values = aVar2.efe.values();
                                if (values != null) {
                                    Iterator it = values.iterator();
                                    if (it != null) {
                                        while (it.hasNext()) {
                                            tmVar = (tm) it.next();
                                            if (tmVar != null && tmVar.cPH.aIB) {
                                                ab.i("MicroMsg.BroadcastController", "summerdiz cancelPosition[%d] found event[%b]", Long.valueOf(j), Boolean.valueOf(tmVar.cPH.aIB));
                                                tmVar.cPH.aIB = false;
                                                com.tencent.mm.sdk.b.a.xxA.m(tmVar);
                                            }
                                        }
                                        break;
                                    }
                                }
                            }
                            tmVar = (tm) aVar2.efe.get(Integer.valueOf(i));
                            if (tmVar != null) {
                                ab.i("MicroMsg.BroadcastController", "summerdiz cancelPosition[%d] found event[%b]", Integer.valueOf(i), Boolean.valueOf(tmVar.cPH.aIB));
                                if (tmVar.cPH.aIB) {
                                    tmVar.cPH.aIB = false;
                                    com.tencent.mm.sdk.b.a.xxA.m(tmVar);
                                    h.pYm.e(13939, Integer.valueOf(2));
                                    break;
                                }
                            }
                            ab.i("MicroMsg.BroadcastController", "summerdiz cancelPosition[%d] not found event", Integer.valueOf(i));
                        } else {
                            ab.i("MicroMsg.BroadcastController", "summerdiz cancelNoticeID not found info");
                        }
                    }
                    if (bVar2.eeU != null) {
                        if (!bo.isNullOrNil(str) && !str.equals(bVar2.eeU.efb)) {
                            ab.i("MicroMsg.BroadcastController", "summerdiz cancelUIEvent old now:[%s], want to cancel:[%s], drop id", bVar2.eeU.efb, str);
                            break;
                        }
                        tmVar = (tm) bVar2.eeU.efe.get(Integer.valueOf(0));
                        if (tmVar != null && tmVar.cPH.aIB) {
                            h.pYm.e(13939, Integer.valueOf(2));
                            tmVar.cPH.aIB = false;
                            com.tencent.mm.sdk.b.a.xxA.m(tmVar);
                            break;
                        }
                    }
                    break;
                case 2:
                    bVar2 = b.this;
                    int i2 = akVar.cto.position;
                    ab.i("MicroMsg.BroadcastController", "summerdiz handlePullNotify position[%d],oldNoticeInfo[%s], positionNoticeIdMap[%d]", Integer.valueOf(i2), bVar2.eeU, Integer.valueOf(bVar2.eeV.size()));
                    if (i2 <= 0 || bVar2.eeV.size() <= 0) {
                        if (bVar2.eeU != null) {
                            tmVar = (tm) bVar2.eeU.efe.get(Integer.valueOf(0));
                            if (tmVar != null) {
                                akVar.ctp.desc = tmVar.cPH.desc;
                                akVar.ctp.ctr = tmVar.cPH.ctr;
                                akVar.ctp.showType = tmVar.cPH.showType;
                                akVar.ctp.url = tmVar.cPH.url;
                                akVar.ctp.aIB = tmVar.cPH.aIB;
                                akVar.ctp.ctt = tmVar.cPH.ctt;
                                akVar.ctp.cts = tmVar.cPH.cts;
                                akVar.ctp.Title = tmVar.cPH.Title;
                                akVar.ctp.ctu = tmVar.cPH.ctu;
                                akVar.ctp.position = tmVar.cPH.position;
                                if (tmVar.cPH.aIB) {
                                    h.pYm.e(13936, Integer.valueOf(i2));
                                }
                                bVar2.Jb();
                                break;
                            }
                        }
                    }
                    j = bo.a((Long) bVar2.eeV.get(Integer.valueOf(i2)), 0);
                    ab.i("MicroMsg.BroadcastController", "summerdiz handlePullNotify position[%d] found noticeId[%d]", Integer.valueOf(i2), Long.valueOf(j));
                    if (j > 0) {
                        aVar2 = (a) bVar2.eeW.get(Long.valueOf(j));
                        if (aVar2 != null) {
                            tmVar = (tm) aVar2.efe.get(Integer.valueOf(i2));
                            if (tmVar != null) {
                                akVar.ctp.desc = tmVar.cPH.desc;
                                akVar.ctp.ctr = tmVar.cPH.ctr;
                                akVar.ctp.showType = tmVar.cPH.showType;
                                akVar.ctp.url = tmVar.cPH.url;
                                akVar.ctp.aIB = tmVar.cPH.aIB;
                                akVar.ctp.ctt = tmVar.cPH.ctt;
                                akVar.ctp.cts = tmVar.cPH.cts;
                                akVar.ctp.Title = tmVar.cPH.Title;
                                akVar.ctp.ctu = tmVar.cPH.ctu;
                                akVar.ctp.position = tmVar.cPH.position;
                                if (tmVar.cPH.aIB) {
                                    h.pYm.e(13936, Integer.valueOf(i2));
                                    break;
                                }
                            }
                        }
                        bVar2.eeV.remove(Integer.valueOf(i2));
                        break;
                    }
                    break;
                case 4:
                    b.this.jZ(aVar.ctq);
                    break;
                case 5:
                    b.this.a(akVar);
                    break;
            }
            AppMethodBeat.o(16061);
            return false;
        }
    };

    static class a {
        String efb = null;
        long efc = 0;
        String efd = null;
        Map<Integer, tm> efe = new HashMap();

        a() {
            AppMethodBeat.i(16064);
            AppMethodBeat.o(16064);
        }

        public final String toString() {
            String str;
            AppMethodBeat.i(16065);
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
            AppMethodBeat.o(16065);
            return str2;
        }
    }

    public b() {
        AppMethodBeat.i(16066);
        AppMethodBeat.o(16066);
    }

    /* Access modifiers changed, original: final */
    public final boolean a(ak akVar) {
        AppMethodBeat.i(16067);
        String str = akVar.cto.ctq;
        String str2 = "MicroMsg.BroadcastController";
        String str3 = "summerdiz handleNewDisaster xml len[%d]";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(str == null ? -1 : str.length());
        ab.i(str2, str3, objArr);
        Map z = br.z(str, "e");
        if (z == null) {
            ab.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster this is not errmsg");
            AppMethodBeat.o(16067);
            return false;
        }
        ab.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster values[%s]", z);
        long j = bo.getLong((String) z.get(".e.NoticeId"), 0);
        if (j <= 0) {
            ab.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster noticeID null");
        }
        if (!ae.gjE) {
            try {
                if (bo.fp(bo.getLong((String) z.get(".e.ExpiredTime"), 0)) > 0) {
                    ab.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster expiredTime is too small, drop id:%d", Long.valueOf(bo.getLong((String) z.get(".e.ExpiredTime"), 0)));
                    AppMethodBeat.o(16067);
                    return false;
                }
            } catch (Exception e) {
                ab.i("MicroMsg.BroadcastController", "parseLong expiredTime error:%s", e);
            }
        }
        a aVar = new a();
        aVar.efb = String.valueOf(j);
        String string = ah.getContext().getSharedPreferences("disaster_pref", com.tencent.mm.compatible.util.h.Mu()).getString("disaster_noticeid_list_key", "");
        if (ae.gjF || !string.contains(aVar.efb)) {
            a aVar2;
            if (this.eeW.size() > 0) {
                a aVar3 = (a) this.eeW.get(Long.valueOf(j));
                if (aVar3 != null) {
                    ab.i("MicroMsg.BroadcastController", "summerdiz  handleNewDisaster found info in map[%s]", aVar3);
                    aVar2 = aVar3;
                } else {
                    this.eeW.put(Long.valueOf(j), aVar);
                    aVar2 = aVar;
                }
            } else {
                this.eeW.put(Long.valueOf(j), aVar);
                aVar2 = aVar;
            }
            string = (String) z.get(".e.Position");
            if (bo.isNullOrNil(string)) {
                ab.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positionStr is null!");
                AppMethodBeat.o(16067);
                return false;
            }
            ArrayList arrayList = new ArrayList();
            String[] split = string.split(",");
            if (split == null || split.length <= 0) {
                ab.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positionStr id invaild!");
                AppMethodBeat.o(16067);
                return false;
            }
            Object obj = null;
            int length = split.length;
            int i = 0;
            while (i < length) {
                Object obj2;
                int i2 = bo.getInt(split[i], 0);
                if (i2 > 0) {
                    if (i2 == 1) {
                        obj2 = 1;
                        ab.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster found tonyTips[%d]", Integer.valueOf(i2));
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
                ab.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positions size is 0!");
                AppMethodBeat.o(16067);
                return false;
            }
            ab.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster curLang[%s]", aa.gw(ah.getContext()));
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
            ab.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster content[%s] tips[%s]", string, str2);
            if (bo.isNullOrNil(string)) {
                ab.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster cann't hit curLang");
            } else {
                str4 = string;
                str5 = str;
                str6 = str2;
            }
            if (bo.isNullOrNil(str5)) {
                str5 = ah.getContext().getString(R.string.b6c);
            }
            if (obj != null) {
                if (bo.isNullOrNil(str4)) {
                    str4 = ah.getContext().getString(R.string.b67);
                }
                if (bo.isNullOrNil(str6)) {
                    str6 = ah.getContext().getString(R.string.b6a);
                }
                akVar.ctp.desc = str4;
                akVar.ctp.ctr = 30;
                akVar.ctp.showType = 0;
                akVar.ctp.url = str5;
                akVar.ctp.aIB = true;
                akVar.ctp.ctt = 0;
                akVar.ctp.cts = 6;
                akVar.ctp.Title = "";
                akVar.ctp.ctu = String.valueOf(j);
                akVar.ctp.position = 1;
            }
            if (arrayList.size() == 0) {
                ab.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster no other position need to tip");
                AppMethodBeat.o(16067);
                return false;
            } else if (aVar2.efc == 0 || bo.az(aVar2.efc) >= 1800000) {
                aVar2.efc = bo.yz();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Integer num = (Integer) it.next();
                    Long valueOf = Long.valueOf(bo.a((Long) this.eeV.get(num), 0));
                    if (valueOf.longValue() <= 0 || valueOf.longValue() < j) {
                        tm tmVar;
                        tm tmVar2 = (tm) aVar2.efe.get(num);
                        if (tmVar2 == null) {
                            tmVar2 = new tm();
                            tmVar2.cPH.showType = 0;
                            tmVar2.cPH.ctr = 30;
                            tmVar2.cPH.Title = "";
                            tmVar2.cPH.ctt = R.layout.agw;
                            tmVar2.cPH.position = num.intValue();
                            aVar2.efe.put(num, tmVar2);
                            tmVar = tmVar2;
                        } else {
                            tmVar = tmVar2;
                        }
                        if (bo.isNullOrNil(str6)) {
                            str = str4;
                        } else {
                            str = str6;
                        }
                        if (bo.isNullOrNil(str)) {
                            i = R.string.b6_;
                            switch (num.intValue()) {
                                case 2:
                                    i = R.string.b6b;
                                    break;
                                case 3:
                                case 4:
                                    i = R.string.b69;
                                    break;
                            }
                            str = ah.getContext().getString(i);
                        }
                        tmVar.cPH.desc = str;
                        tmVar.cPH.url = str5;
                        tmVar.cPH.aIB = true;
                        tmVar.cPH.cts = 2;
                        tmVar.cPH.ctu = aVar2.efb;
                        this.eeV.put(num, Long.valueOf(j));
                        if (obj == null) {
                            akVar.ctp.desc = str;
                            akVar.ctp.ctr = 30;
                            akVar.ctp.showType = 0;
                            akVar.ctp.url = str5;
                            akVar.ctp.aIB = true;
                            akVar.ctp.ctt = R.layout.agw;
                            akVar.ctp.cts = 2;
                            akVar.ctp.Title = "";
                            akVar.ctp.ctu = String.valueOf(j);
                            akVar.ctp.position = num.intValue();
                        }
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(16062);
                                com.tencent.mm.sdk.b.a.xxA.m(tmVar);
                                AppMethodBeat.o(16062);
                            }
                        });
                        str6 = str;
                    } else {
                        ab.i("MicroMsg.BroadcastController", "summerdiz p[%d] has bigger oldPositionNoticeId[%d, %d]", num, valueOf, Long.valueOf(j));
                    }
                }
                AppMethodBeat.o(16067);
                return true;
            } else {
                ab.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster disasterTick within half an hour, drop it");
                AppMethodBeat.o(16067);
                return false;
            }
        }
        ab.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster noticeIdList %s contain notifyID:%s, drop id", string, aVar.efb);
        AppMethodBeat.o(16067);
        return false;
    }

    /* Access modifiers changed, original: final */
    public final boolean jZ(String str) {
        AppMethodBeat.i(16068);
        ab.i("MicroMsg.BroadcastController", "summerdiz handleEventOOB oldNoticeInfo[%s], event[%s]", this.eeU, str);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(16068);
            return false;
        } else if (str.indexOf("<") < 0) {
            AppMethodBeat.o(16068);
            return false;
        } else {
            Map z = br.z(str, "e");
            if (z == null) {
                ab.e("MicroMsg.BroadcastController", "this is not errmsg");
                AppMethodBeat.o(16068);
                return false;
            }
            tm tmVar;
            if (this.eeU == null) {
                this.eeU = new a();
                tmVar = new tm();
                this.eeU.efe.put(Integer.valueOf(0), tmVar);
                tmVar.cPH.desc = "";
                tmVar.cPH.url = "";
                tmVar.cPH.showType = 0;
                tmVar.cPH.ctr = 30;
                tmVar.cPH.aIB = false;
                tmVar.cPH.Title = "";
                tmVar.cPH.cts = 0;
                tmVar.cPH.ctt = R.layout.agw;
                tmVar.cPH.ctu = "";
                tmVar.cPH.position = 0;
            }
            if (!ae.gjD) {
                if (this.eeU.efc == 0 || bo.az(this.eeU.efc) >= 1800000) {
                    this.eeU.efc = bo.yz();
                } else {
                    ab.i("MicroMsg.BroadcastController", "disasterTick within half an hour, drop it");
                    AppMethodBeat.o(16068);
                    return false;
                }
            }
            if (!ae.gjE) {
                try {
                    if (bo.fp(bo.getLong((String) z.get(".e.ExpiredTime"), 0)) > 0) {
                        ab.i("MicroMsg.BroadcastController", "expiredTime is too small, drop id:%d", Long.valueOf(bo.getLong((String) z.get(".e.ExpiredTime"), 0)));
                        AppMethodBeat.o(16068);
                        return false;
                    }
                } catch (Exception e) {
                    ab.i("MicroMsg.BroadcastController", "parseLong expiredTime error:%s", e);
                }
            }
            this.eeU.efb = (String) z.get(".e.NoticeId");
            String string = ah.getContext().getSharedPreferences("disaster_pref", com.tencent.mm.compatible.util.h.Mu()).getString("disaster_noticeid_list_key", "");
            if (ae.gjF || !string.contains(this.eeU.efb)) {
                String str2;
                String str3;
                String gw = aa.gw(ah.getContext());
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
                if (bo.isNullOrNil(string)) {
                    ab.i("MicroMsg.BroadcastController", "handleEventOOB cann't hit curLang");
                } else {
                    str5 = str3;
                    str6 = string;
                    str4 = str2;
                }
                if (bo.isNullOrNil(str5)) {
                    str5 = ah.getContext().getString(R.string.b6c);
                }
                if (bo.isNullOrNil(str6)) {
                    ab.i("MicroMsg.BroadcastController", "handleEventOOB defContent is also null use hardcode");
                    str6 = ah.getContext().getString(R.string.b66);
                }
                if (bo.isNullOrNil(str4)) {
                    if (bo.isNullOrNil(str6)) {
                        str4 = ah.getContext().getString(R.string.b6_);
                    } else {
                        str4 = str6;
                    }
                }
                tmVar = (tm) this.eeU.efe.get(Integer.valueOf(0));
                tmVar.cPH.desc = str4;
                tmVar.cPH.url = str5;
                tmVar.cPH.aIB = true;
                tmVar.cPH.cts = 2;
                tmVar.cPH.ctu = this.eeU.efb;
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(16063);
                        ab.i("MicroMsg.BroadcastController", "summerdiz handleEventOOB publish uiEvent");
                        com.tencent.mm.sdk.b.a.xxA.m(tmVar);
                        AppMethodBeat.o(16063);
                    }
                });
                this.eeU.efd = str6;
                if (aw.Rg().foreground) {
                    Jb();
                }
                AppMethodBeat.o(16068);
                return true;
            }
            ab.i("MicroMsg.BroadcastController", "noticeIdList %s contain notifyID:%s, drop id", string, this.eeU.efb);
            AppMethodBeat.o(16068);
            return false;
        }
    }

    /* Access modifiers changed, original: final */
    public final void Jb() {
        AppMethodBeat.i(16069);
        if (this.eeU == null || this.eeU.efe.get(Integer.valueOf(0)) == null || bo.isNullOrNil(this.eeU.efd)) {
            AppMethodBeat.o(16069);
            return;
        }
        ab.i("MicroMsg.BroadcastController", "summerdize checkShowDisasterContent showDisasterContent[%s]", this.eeU.efd);
        Intent intent = new Intent();
        intent.putExtra("key_disaster_content", this.eeU.efd);
        intent.putExtra("key_disaster_url", ((tm) this.eeU.efe.get(Integer.valueOf(0))).cPH.url);
        intent.setClass(ah.getContext(), DisasterUI.class).addFlags(268435456);
        ah.getContext().startActivity(intent);
        this.eeU.efd = null;
        AppMethodBeat.o(16069);
    }
}
