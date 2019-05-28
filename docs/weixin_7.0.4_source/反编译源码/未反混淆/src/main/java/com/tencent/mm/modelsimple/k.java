package com.tencent.mm.modelsimple;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.g.a.a;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.jk;
import com.tencent.mm.model.aw;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.account.ui.DisasterUI;
import com.tencent.mm.protocal.protobuf.aid;
import com.tencent.mm.protocal.protobuf.aie;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.util.HashMap;
import java.util.Map;

public final class k extends m implements com.tencent.mm.network.k {
    private static Map<String, Long> fOE = new HashMap();
    private static Map<String, String> fOF;
    private boolean cCq = false;
    private f ehi;
    private c<a> fOG;
    private final b fmP;

    static {
        AppMethodBeat.i(16588);
        AppMethodBeat.o(16588);
    }

    public k(int i, boolean z) {
        AppMethodBeat.i(16582);
        b.a aVar = new b.a();
        aVar.fsJ = new aid();
        aVar.fsK = new aie();
        aVar.uri = "/cgi-bin/micromsg-bin/getdisasterinfo";
        aVar.fsI = 775;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.fmP = aVar.acD();
        this.fmP.cQh = 1;
        ((aid) this.fmP.fsG.fsP).cCp = i;
        this.cCq = z;
        ajd();
        ab.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo noticeid[%d], manualauthSucc[%b], stack[%s]", Integer.valueOf(i), Boolean.valueOf(this.cCq), bo.dpG());
        AppMethodBeat.o(16582);
    }

    public final int getType() {
        return 775;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(16583);
        aid aid = (aid) this.fmP.fsG.fsP;
        long a = bo.a((Long) fOE.get(aid.cCp), 0);
        ab.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene noticeid[%d], tick[%d], noticeidTickMap[%s]", Integer.valueOf(aid.cCp), Long.valueOf(a), fOE);
        if (a == 0 || bo.az(a) >= 1800000) {
            String bc = bo.bc((String) fOF.get(aid.cCp), "");
            if (bo.isNullOrNil(bc)) {
                this.ehi = fVar;
                int a2 = a(eVar, this.fmP, this);
                AppMethodBeat.o(16583);
                return a2;
            }
            ab.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene found cache[%d, %s]", Integer.valueOf(aid.cCp), bc);
            P(bc, false);
            AppMethodBeat.o(16583);
            return -1;
        }
        ab.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene disasterTick within half an hour, drop it [%s]", Integer.valueOf(aid.cCp));
        AppMethodBeat.o(16583);
        return -1;
    }

    private void P(final String str, final boolean z) {
        AppMethodBeat.i(16584);
        aw.RS().aa(new Runnable() {
            public final void run() {
                int i;
                AppMethodBeat.i(16581);
                String str = "MicroMsg.NetSceneGetDisasterInfo";
                String str2 = "summerdiz NetSceneGetDisasterInfo broadcastEvent content len[%d], cache[%b]";
                Object[] objArr = new Object[2];
                if (str == null) {
                    i = -1;
                } else {
                    i = str.length();
                }
                objArr[0] = Integer.valueOf(i);
                objArr[1] = Boolean.valueOf(z);
                ab.i(str, str2, objArr);
                ak akVar = new ak();
                akVar.cto.type = 5;
                akVar.cto.ctq = str;
                com.tencent.mm.sdk.b.a.xxA.m(akVar);
                str = akVar.ctp.ctu;
                int i2 = akVar.ctp.position;
                int i3 = akVar.ctp.cts;
                ab.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo onGYNetEnd event.result.Actionp[%d] noticeId[%s], position[%d], manualauthSucc[%b], noticeidTickMap[%s]", Integer.valueOf(i3), str, Integer.valueOf(i2), Boolean.valueOf(k.this.cCq), k.fOE);
                if (i2 == 1 && i3 == 6) {
                    if (z) {
                        k.aT(str, str);
                    }
                    if (k.this.cCq) {
                        str2 = akVar.ctp.desc;
                        final String str3 = akVar.ctp.url;
                        ab.i("MicroMsg.NetSceneGetDisasterInfo", "summerdize NetSceneGetDisasterInfo onGYNetEnd manualauthSucc showtony after init[%b]", Boolean.valueOf(ah.dox()));
                        if (k.this.fOG == null) {
                            k.this.fOG = new c<a>() {
                                public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                                    AppMethodBeat.i(16580);
                                    com.tencent.mm.sdk.b.a.xxA.d(k.this.fOG);
                                    k.this.fOG = null;
                                    ab.i("MicroMsg.NetSceneGetDisasterInfo", "summerdize NetSceneGetDisasterInfo onGYNetEnd manualauthSucc showtony after 5s[%b]", Boolean.valueOf(ah.dox()));
                                    al.n(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.i(16578);
                                            ab.i("MicroMsg.NetSceneGetDisasterInfo", "summerdize NetSceneGetDisasterInfo onGYNetEnd manualauthSucc showtony[%b]", Boolean.valueOf(ah.dox()));
                                            Intent intent = new Intent();
                                            intent.putExtra("key_disaster_content", str2);
                                            intent.putExtra("key_disaster_url", str3);
                                            intent.setClass(ah.getContext(), DisasterUI.class).addFlags(268435456);
                                            ah.getContext().startActivity(intent);
                                            AppMethodBeat.o(16578);
                                        }
                                    }, 5000);
                                    AppMethodBeat.o(16580);
                                    return true;
                                }
                            };
                        }
                        com.tencent.mm.sdk.b.a.xxA.c(k.this.fOG);
                    } else {
                        jk jkVar = new jk();
                        jkVar.cEJ.content = akVar.ctp.desc;
                        jkVar.cEJ.url = akVar.ctp.url;
                        com.tencent.mm.sdk.b.a.xxA.m(jkVar);
                    }
                    k.fOE.put(str, Long.valueOf(bo.yz()));
                    AppMethodBeat.o(16581);
                    return;
                }
                if (i3 == 2) {
                    if (z) {
                        k.aT(str, str);
                    }
                    k.fOE.put(str, Long.valueOf(bo.yz()));
                }
                AppMethodBeat.o(16581);
            }
        });
        AppMethodBeat.o(16584);
    }

    private synchronized void ajd() {
        AppMethodBeat.i(16585);
        if (fOF == null) {
            ab.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap");
            fOF = new HashMap();
            SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("disaster_pref", h.Mu());
            String string = sharedPreferences.getString("disaster_new_noticeid_list_key", "");
            if (!bo.isNullOrNil(string)) {
                String[] split = string.split(";");
                if (split != null && split.length > 0) {
                    string = "";
                    Editor edit = sharedPreferences.edit();
                    for (String split2 : split) {
                        String[] split3 = split2.split(",");
                        try {
                            if (bo.getLong(split3[0], 0) > 0) {
                                if (bo.fp(bo.getLong(split3[1], 0)) < TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) {
                                    String string2 = sharedPreferences.getString(split3[0], "");
                                    if (!bo.isNullOrNil(string2)) {
                                        string = string + split3[0] + "," + split3[1] + ";";
                                        fOF.put(split3[0], string2);
                                    }
                                } else {
                                    edit.remove(split3[0]).commit();
                                }
                            }
                        } catch (Exception e) {
                            ab.e("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap error:%s", e.getMessage());
                        }
                    }
                    edit.putString("disaster_new_noticeid_list_key", string).commit();
                    ab.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap newNoticeIdList[%s], noticeidTickMap[%s]", string, fOE);
                }
            }
            ab.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap done noticeContentMap[%s]", fOF);
        }
        AppMethodBeat.o(16585);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(16586);
        ab.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            P(((aie) this.fmP.fsH.fsP).content, true);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(16586);
    }

    static /* synthetic */ void aT(String str, String str2) {
        AppMethodBeat.i(16587);
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("disaster_pref", h.Mu());
        String string = sharedPreferences.getString("disaster_new_noticeid_list_key", "");
        if (!bo.isNullOrNil(string)) {
            string = string + ";";
        }
        string = string + str + "," + bo.anT();
        Editor edit = sharedPreferences.edit();
        edit.putString(str, str2);
        edit.putString("disaster_new_noticeid_list_key", string);
        edit.commit();
        fOF.put(str, str2);
        ab.i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz saveDisasterNotice newNoticeIdList[%s], noticeId[%s], content[%s]", sharedPreferences.getString("disaster_new_noticeid_list_key", ""), str, sharedPreferences.getString(str, ""));
        AppMethodBeat.o(16587);
    }
}
