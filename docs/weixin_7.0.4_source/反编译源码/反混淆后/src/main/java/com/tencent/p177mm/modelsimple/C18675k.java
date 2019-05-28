package com.tencent.p177mm.modelsimple;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p230g.p231a.C32508a;
import com.tencent.p177mm.p230g.p231a.C37745jk;
import com.tencent.p177mm.p230g.p231a.C6459ak;
import com.tencent.p177mm.plugin.account.p275ui.DisasterUI;
import com.tencent.p177mm.protocal.protobuf.aid;
import com.tencent.p177mm.protocal.protobuf.aie;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.modelsimple.k */
public final class C18675k extends C1207m implements C1918k {
    private static Map<String, Long> fOE = new HashMap();
    private static Map<String, String> fOF;
    private boolean cCq = false;
    private C1202f ehi;
    private C4884c<C32508a> fOG;
    private final C7472b fmP;

    static {
        AppMethodBeat.m2504i(16588);
        AppMethodBeat.m2505o(16588);
    }

    public C18675k(int i, boolean z) {
        AppMethodBeat.m2504i(16582);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aid();
        c1196a.fsK = new aie();
        c1196a.uri = "/cgi-bin/micromsg-bin/getdisasterinfo";
        c1196a.fsI = 775;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.fmP = c1196a.acD();
        this.fmP.cQh = 1;
        ((aid) this.fmP.fsG.fsP).cCp = i;
        this.cCq = z;
        ajd();
        C4990ab.m7417i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo noticeid[%d], manualauthSucc[%b], stack[%s]", Integer.valueOf(i), Boolean.valueOf(this.cCq), C5046bo.dpG());
        AppMethodBeat.m2505o(16582);
    }

    public final int getType() {
        return 775;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(16583);
        aid aid = (aid) this.fmP.fsG.fsP;
        long a = C5046bo.m7514a((Long) fOE.get(aid.cCp), 0);
        C4990ab.m7417i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene noticeid[%d], tick[%d], noticeidTickMap[%s]", Integer.valueOf(aid.cCp), Long.valueOf(a), fOE);
        if (a == 0 || C5046bo.m7525az(a) >= 1800000) {
            String bc = C5046bo.m7532bc((String) fOF.get(aid.cCp), "");
            if (C5046bo.isNullOrNil(bc)) {
                this.ehi = c1202f;
                int a2 = mo4457a(c1902e, this.fmP, this);
                AppMethodBeat.m2505o(16583);
                return a2;
            }
            C4990ab.m7417i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene found cache[%d, %s]", Integer.valueOf(aid.cCp), bc);
            m29187P(bc, false);
            AppMethodBeat.m2505o(16583);
            return -1;
        }
        C4990ab.m7417i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo doScene disasterTick within half an hour, drop it [%s]", Integer.valueOf(aid.cCp));
        AppMethodBeat.m2505o(16583);
        return -1;
    }

    /* renamed from: P */
    private void m29187P(final String str, final boolean z) {
        AppMethodBeat.m2504i(16584);
        C9638aw.m17180RS().mo10302aa(new Runnable() {
            public final void run() {
                int i;
                AppMethodBeat.m2504i(16581);
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
                C4990ab.m7417i(str, str2, objArr);
                C6459ak c6459ak = new C6459ak();
                c6459ak.cto.type = 5;
                c6459ak.cto.ctq = str;
                C4879a.xxA.mo10055m(c6459ak);
                str = c6459ak.ctp.ctu;
                int i2 = c6459ak.ctp.position;
                int i3 = c6459ak.ctp.cts;
                C4990ab.m7417i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo onGYNetEnd event.result.Actionp[%d] noticeId[%s], position[%d], manualauthSucc[%b], noticeidTickMap[%s]", Integer.valueOf(i3), str, Integer.valueOf(i2), Boolean.valueOf(C18675k.this.cCq), C18675k.fOE);
                if (i2 == 1 && i3 == 6) {
                    if (z) {
                        C18675k.m29190aT(str, str);
                    }
                    if (C18675k.this.cCq) {
                        str2 = c6459ak.ctp.desc;
                        final String str3 = c6459ak.ctp.url;
                        C4990ab.m7417i("MicroMsg.NetSceneGetDisasterInfo", "summerdize NetSceneGetDisasterInfo onGYNetEnd manualauthSucc showtony after init[%b]", Boolean.valueOf(C4996ah.dox()));
                        if (C18675k.this.fOG == null) {
                            C18675k.this.fOG = new C4884c<C32508a>() {

                                /* renamed from: com.tencent.mm.modelsimple.k$1$1$1 */
                                class C97051 implements Runnable {
                                    C97051() {
                                    }

                                    public final void run() {
                                        AppMethodBeat.m2504i(16578);
                                        C4990ab.m7417i("MicroMsg.NetSceneGetDisasterInfo", "summerdize NetSceneGetDisasterInfo onGYNetEnd manualauthSucc showtony[%b]", Boolean.valueOf(C4996ah.dox()));
                                        Intent intent = new Intent();
                                        intent.putExtra("key_disaster_content", str2);
                                        intent.putExtra("key_disaster_url", str3);
                                        intent.setClass(C4996ah.getContext(), DisasterUI.class).addFlags(268435456);
                                        C4996ah.getContext().startActivity(intent);
                                        AppMethodBeat.m2505o(16578);
                                    }
                                }

                                /* renamed from: a */
                                public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
                                    AppMethodBeat.m2504i(16580);
                                    C4879a.xxA.mo10053d(C18675k.this.fOG);
                                    C18675k.this.fOG = null;
                                    C4990ab.m7417i("MicroMsg.NetSceneGetDisasterInfo", "summerdize NetSceneGetDisasterInfo onGYNetEnd manualauthSucc showtony after 5s[%b]", Boolean.valueOf(C4996ah.dox()));
                                    C5004al.m7442n(new C97051(), 5000);
                                    AppMethodBeat.m2505o(16580);
                                    return true;
                                }
                            };
                        }
                        C4879a.xxA.mo10052c(C18675k.this.fOG);
                    } else {
                        C37745jk c37745jk = new C37745jk();
                        c37745jk.cEJ.content = c6459ak.ctp.desc;
                        c37745jk.cEJ.url = c6459ak.ctp.url;
                        C4879a.xxA.mo10055m(c37745jk);
                    }
                    C18675k.fOE.put(str, Long.valueOf(C5046bo.m7588yz()));
                    AppMethodBeat.m2505o(16581);
                    return;
                }
                if (i3 == 2) {
                    if (z) {
                        C18675k.m29190aT(str, str);
                    }
                    C18675k.fOE.put(str, Long.valueOf(C5046bo.m7588yz()));
                }
                AppMethodBeat.m2505o(16581);
            }
        });
        AppMethodBeat.m2505o(16584);
    }

    private synchronized void ajd() {
        AppMethodBeat.m2504i(16585);
        if (fOF == null) {
            C4990ab.m7416i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap");
            fOF = new HashMap();
            SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("disaster_pref", C1448h.m3078Mu());
            String string = sharedPreferences.getString("disaster_new_noticeid_list_key", "");
            if (!C5046bo.isNullOrNil(string)) {
                String[] split = string.split(";");
                if (split != null && split.length > 0) {
                    string = "";
                    Editor edit = sharedPreferences.edit();
                    for (String split2 : split) {
                        String[] split3 = split2.split(",");
                        try {
                            if (C5046bo.getLong(split3[0], 0) > 0) {
                                if (C5046bo.m7549fp(C5046bo.getLong(split3[1], 0)) < TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) {
                                    String string2 = sharedPreferences.getString(split3[0], "");
                                    if (!C5046bo.isNullOrNil(string2)) {
                                        string = string + split3[0] + "," + split3[1] + ";";
                                        fOF.put(split3[0], string2);
                                    }
                                } else {
                                    edit.remove(split3[0]).commit();
                                }
                            }
                        } catch (Exception e) {
                            C4990ab.m7413e("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap error:%s", e.getMessage());
                        }
                    }
                    edit.putString("disaster_new_noticeid_list_key", string).commit();
                    C4990ab.m7417i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap newNoticeIdList[%s], noticeidTickMap[%s]", string, fOE);
                }
            }
            C4990ab.m7417i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz loadNoticeContentMap noticeContentMap done noticeContentMap[%s]", fOF);
        }
        AppMethodBeat.m2505o(16585);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(16586);
        C4990ab.m7417i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz NetSceneGetDisasterInfo onGYNetEnd netId[%d], errType[%d], errCode[%d], errMsg[%s]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            m29187P(((aie) this.fmP.fsH.fsP).content, true);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(16586);
    }

    /* renamed from: aT */
    static /* synthetic */ void m29190aT(String str, String str2) {
        AppMethodBeat.m2504i(16587);
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("disaster_pref", C1448h.m3078Mu());
        String string = sharedPreferences.getString("disaster_new_noticeid_list_key", "");
        if (!C5046bo.isNullOrNil(string)) {
            string = string + ";";
        }
        string = string + str + "," + C5046bo.anT();
        Editor edit = sharedPreferences.edit();
        edit.putString(str, str2);
        edit.putString("disaster_new_noticeid_list_key", string);
        edit.commit();
        fOF.put(str, str2);
        C4990ab.m7417i("MicroMsg.NetSceneGetDisasterInfo", "summerdiz saveDisasterNotice newNoticeIdList[%s], noticeId[%s], content[%s]", sharedPreferences.getString("disaster_new_noticeid_list_key", ""), str, sharedPreferences.getString(str, ""));
        AppMethodBeat.m2505o(16587);
    }
}
