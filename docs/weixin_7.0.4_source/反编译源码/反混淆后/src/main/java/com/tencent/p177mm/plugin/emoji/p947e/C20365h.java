package com.tencent.p177mm.plugin.emoji.p947e;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.emoji.p227a.C18190d;
import com.tencent.p177mm.emoji.p227a.C18190d.C18191b;
import com.tencent.p177mm.emoji.p227a.C26072e;
import com.tencent.p177mm.emoji.p228d.C37677d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p1099x.C16112c;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p190at.p191a.C25815a;
import com.tencent.p177mm.p207by.C45274a;
import com.tencent.p177mm.p207by.C45274a.C1336b;
import com.tencent.p177mm.p211cb.C37626b;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p230g.p231a.C26217py;
import com.tencent.p177mm.p230g.p231a.C32519bf;
import com.tencent.p177mm.p230g.p231a.C45317cz;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p249m.C42164b;
import com.tencent.p177mm.p612ui.tools.C5584f;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5659a;
import com.tencent.p177mm.p612ui.widget.p633a.C5663e.C5662c;
import com.tencent.p177mm.p707ba.C6337f;
import com.tencent.p177mm.plugin.emoji.model.C20378d;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.model.EmojiLogic;
import com.tencent.p177mm.plugin.emoji.p383h.C2933b;
import com.tencent.p177mm.plugin.emoji.p384ui.CustomSmileyPreviewUI;
import com.tencent.p177mm.plugin.emoji.p384ui.EmojiAddCustomDialogUI;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.emoji.p726f.C20375n;
import com.tencent.p177mm.plugin.emoji.p726f.C27737e;
import com.tencent.p177mm.plugin.emoji.p726f.C33949c;
import com.tencent.p177mm.plugin.emoji.p726f.C45855a;
import com.tencent.p177mm.plugin.emoji.p727g.C20377d;
import com.tencent.p177mm.plugin.emoji.p947e.C38877b.C277331;
import com.tencent.p177mm.plugin.emoji.p947e.C45852j.C27735a;
import com.tencent.p177mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.p177mm.plugin.emojicapture.api.EmojiCaptureUploadManager.UploadTask;
import com.tencent.p177mm.plugin.gif.C3276f;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p1336a.C44795d;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C14839b.C14845c;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C44796m;
import com.tencent.p177mm.protocal.protobuf.cab;
import com.tencent.p177mm.protocal.protobuf.cac;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5047bp;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C23504as;
import com.tencent.p177mm.storage.C44218ap;
import com.tencent.p177mm.storage.C44219aq;
import com.tencent.p177mm.storage.C44219aq.C44220a;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.emotion.C15438t;
import com.tencent.p177mm.storage.emotion.C15439u;
import com.tencent.p177mm.storage.emotion.C40628r;
import com.tencent.p177mm.storage.emotion.C46625s;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.storage.emotion.EmojiInfo.C30301b;
import com.tencent.p177mm.storage.emotion.EmojiInfo.C30302a;
import com.tencent.p177mm.storage.emotion.SmileyInfo;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.recovery.util.Util;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.xwalk.core.XWalkEnvironment;

/* renamed from: com.tencent.mm.plugin.emoji.e.h */
public final class C20365h implements C44795d {
    /* renamed from: Jd */
    public final EmojiInfo mo35596Jd(String str) {
        AppMethodBeat.m2504i(52888);
        EmojiInfo aqi = C42952j.getEmojiStorageMgr().xYn.aqi(str);
        AppMethodBeat.m2505o(52888);
        return aqi;
    }

    /* renamed from: Je */
    public final EmojiInfo mo35597Je(String str) {
        AppMethodBeat.m2504i(52889);
        EmojiInfo Jd = mo35596Jd(str);
        AppMethodBeat.m2505o(52889);
        return Jd;
    }

    /* renamed from: a */
    public final void mo35617a(Context context, C7620bi c7620bi, String str) {
        AppMethodBeat.m2504i(52892);
        if (context == null || c7620bi == null) {
            C4990ab.m7420w("MicroMsg.emoji.EmojiMgrImpl", "context or msg is null");
            AppMethodBeat.m2505o(52892);
            return;
        }
        C44218ap aps = C44218ap.aps(c7620bi.field_content);
        C8910b me = C8910b.m16064me(c7620bi.field_content);
        if (me == null) {
            me = new C8910b();
            me.fgq = aps.cvZ;
        }
        EmojiInfo aqi = C42952j.getEmojiStorageMgr().xYn.aqi(me.fgq);
        if (c7620bi.field_isSend == 1) {
            if (aqi == null || !aqi.duP()) {
                C42952j.bko().mo45575c(me);
                AppMethodBeat.m2505o(52892);
                return;
            }
            C20365h.m31469a(context, me.fgq, me.appId, me.appName, c7620bi.field_msgSvrId, c7620bi.field_talker, c7620bi.field_content, str);
            AppMethodBeat.m2505o(52892);
        } else if (aqi == null || !aqi.duP()) {
            C42952j.bko().mo45575c(me);
            AppMethodBeat.m2505o(52892);
        } else {
            C20365h.m31469a(context, aqi.mo20410Aq(), me.appId, me.appName, c7620bi.field_msgSvrId, c7620bi.field_talker, c7620bi.field_content, str);
            AppMethodBeat.m2505o(52892);
        }
    }

    /* renamed from: r */
    public final boolean mo35663r(Context context, String str, String str2) {
        AppMethodBeat.m2504i(52893);
        if (context == null) {
            C4990ab.m7420w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: context is null");
            AppMethodBeat.m2505o(52893);
            return false;
        } else if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            C4990ab.m7420w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: userName or imgPath is null");
            AppMethodBeat.m2505o(52893);
            return false;
        } else {
            EmojiInfo aqi = C42952j.getEmojiStorageMgr().xYn.aqi(str2);
            if (aqi == null) {
                C4990ab.m7421w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: emoji not found, imgPath %s", str2);
                AppMethodBeat.m2505o(52893);
                return false;
            }
            if (aqi.field_type == EmojiInfo.zYX || aqi.field_type == EmojiInfo.zYY) {
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                String str3 = C2933b.m5221Yb() + aqi.mo20410Aq();
                if (C5730e.m8628ct(str3 + "_thumb")) {
                    wXMediaMessage.thumbData = C5730e.m8632e(str3 + "_thumb", 0, -1);
                } else {
                    wXMediaMessage.setThumbImage(aqi.mo48542hk(context));
                }
                wXMediaMessage.mediaObject = new WXEmojiObject(str3);
                C26217py c26217py = new C26217py();
                c26217py.cMe.cEl = wXMediaMessage;
                c26217py.cMe.appId = aqi.field_app_id;
                c26217py.cMe.appName = null;
                c26217py.cMe.toUser = str;
                c26217py.cMe.cMf = 0;
                c26217py.cMe.cMi = aqi.mo20410Aq();
                C4879a.xxA.mo10055m(c26217py);
            } else {
                if (aqi.field_type == EmojiInfo.zYR) {
                    Cursor MB = EmojiInfo.m48209Mw(aqi.field_catalog) ? C42952j.getEmojiStorageMgr().xYn.mo48560MB(aqi.field_catalog) : (aqi.field_catalog == EmojiInfo.yax && aqi.getContent().length() > 0 && EmojiInfo.m48209Mw(C5046bo.getInt(aqi.getContent(), 0))) ? C42952j.getEmojiStorageMgr().xYn.mo48560MB(C5046bo.getInt(aqi.getContent(), 0)) : null;
                    if (MB != null) {
                        int gV = C5046bo.m7560gV(MB.getCount() - 1, 0);
                        aqi = new EmojiInfo();
                        MB.moveToPosition(gV);
                        aqi.mo8995d(MB);
                        MB.close();
                    }
                }
                C42952j.bkh().mo35675a(str, aqi, null);
            }
            AppMethodBeat.m2505o(52893);
            return true;
        }
    }

    /* renamed from: a */
    public final void mo35620a(String str, EmojiInfo emojiInfo, C7620bi c7620bi) {
        AppMethodBeat.m2504i(52894);
        if (emojiInfo == null && c7620bi == null) {
            AppMethodBeat.m2505o(52894);
            return;
        }
        if (emojiInfo == null) {
            emojiInfo = C42952j.getEmojiStorageMgr().xYn.aqi(c7620bi.field_imgPath);
        }
        C42952j.bkh().mo35675a(str, emojiInfo, c7620bi);
        AppMethodBeat.m2505o(52894);
    }

    /* renamed from: a */
    private static void m31469a(Context context, String str, String str2, String str3, long j, String str4, String str5, String str6) {
        AppMethodBeat.m2504i(52895);
        if (str.equals("-1")) {
            C4990ab.m7412e("MicroMsg.emoji.EmojiMgrImpl", "showEmoji fail cause md5 is no valid");
            AppMethodBeat.m2505o(52895);
            return;
        }
        EmojiInfo aqi = C42952j.getEmojiStorageMgr().xYn.aqi(str);
        if (aqi == null) {
            C4990ab.m7412e("MicroMsg.emoji.EmojiMgrImpl", "showEmoji fail cause md5 is no valid");
            AppMethodBeat.m2505o(52895);
            return;
        }
        Intent intent = new Intent(context, CustomSmileyPreviewUI.class);
        intent.putExtra("custom_smiley_preview_md5", str);
        if (str2 != null) {
            intent.putExtra("custom_smiley_preview_appid", str2);
        } else {
            intent.putExtra("custom_smiley_preview_appid", aqi.field_app_id);
        }
        intent.putExtra("custom_smiley_preview_appname", str3);
        intent.putExtra("msg_id", j);
        intent.putExtra("msg_content", str5);
        if (C1855t.m3896kH(str4)) {
            str4 = C1829bf.m3762oy(str5);
            intent.putExtra("room_id", str6);
        }
        intent.putExtra("msg_sender", str4);
        context.startActivity(intent);
        AppMethodBeat.m2505o(52895);
    }

    /* renamed from: dK */
    public final C23504as mo35645dK(String str, String str2) {
        AppMethodBeat.m2504i(52896);
        Map z = C5049br.m7595z(str, "msg");
        if (z == null) {
            C4990ab.m7420w("MicroMsg.emoji.EmojiMgrImpl", "get from xml, but attrs is null");
            AppMethodBeat.m2505o(52896);
            return null;
        }
        C23504as a = C23504as.m36331a(z, str2, str, "");
        if (a == null) {
            C4990ab.m7420w("MicroMsg.emoji.EmojiMgrImpl", "parserEmojiXml error ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(52896);
            return null;
        }
        AppMethodBeat.m2505o(52896);
        return a;
    }

    /* renamed from: j */
    public final EmojiInfo mo35651j(String str, int i, int i2, int i3) {
        AppMethodBeat.m2504i(52897);
        EmojiInfo a = mo35615a(str, "", i, i2, i3, "");
        AppMethodBeat.m2505o(52897);
        return a;
    }

    /* renamed from: a */
    public final EmojiInfo mo35615a(String str, String str2, int i, int i2, int i3, String str3) {
        AppMethodBeat.m2504i(52898);
        EmojiInfo e = C42952j.getEmojiStorageMgr().xYn.mo48578e(str, str2, i, i2, i3, str3);
        AppMethodBeat.m2505o(52898);
        return e;
    }

    public final void updateEmojiInfo(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(52899);
        C42952j.getEmojiStorageMgr().xYn.mo48555G(emojiInfo);
        AppMethodBeat.m2505o(52899);
    }

    /* renamed from: Jf */
    public final String mo35598Jf(String str) {
        AppMethodBeat.m2504i(52900);
        String Jf = EmojiLogic.m44060Jf(str);
        AppMethodBeat.m2505o(52900);
        return Jf;
    }

    /* renamed from: a */
    public final String mo35616a(Context context, WXMediaMessage wXMediaMessage, String str) {
        AppMethodBeat.m2504i(52901);
        String b = EmojiLogic.m44080b(context, wXMediaMessage, str);
        AppMethodBeat.m2505o(52901);
        return b;
    }

    /* renamed from: a */
    public final boolean mo35623a(String str, String str2, long j, String str3, C1197a c1197a) {
        boolean z = false;
        AppMethodBeat.m2504i(52902);
        C20378d bkh = C42952j.bkh();
        C4990ab.m7410d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml ".concat(String.valueOf(str2)));
        C23504as a = C23504as.m36331a(C5049br.m7595z(str2, "msg"), str, str2, str3);
        if (a == null) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiService", "prepareEmoji failed. emoji msg info is null.");
            AppMethodBeat.m2505o(52902);
        } else {
            a.cKK = j;
            C4990ab.m7417i("MicroMsg.emoji.EmojiService", "summerbadcr prepareEmoji msgSvrId[%d], stack[%s]", Long.valueOf(j), C5046bo.dpG());
            bkh.mo35673JC(a.cwg);
            if (!EmojiLogic.m44059JB(C26072e.m41620OO())) {
                z = true;
            }
            bkh.mo35674a(a, c1197a, z);
            AppMethodBeat.m2505o(52902);
        }
        return true;
    }

    /* renamed from: Jg */
    public final List<EmojiInfo> mo35599Jg(String str) {
        AppMethodBeat.m2504i(52903);
        if (C1720g.m3536RP().isSDCardAvailable()) {
            ArrayList arrayList = (ArrayList) C42952j.getEmojiStorageMgr().xYn.mo48557Jg(str);
            AppMethodBeat.m2505o(52903);
            return arrayList;
        }
        List<EmojiInfo> arrayList2 = new ArrayList();
        AppMethodBeat.m2505o(52903);
        return arrayList2;
    }

    public final String getAccPath() {
        AppMethodBeat.m2504i(52904);
        String str = C1720g.m3536RP().eJM;
        AppMethodBeat.m2505o(52904);
        return str;
    }

    /* renamed from: Jh */
    public final String mo35600Jh(String str) {
        AppMethodBeat.m2504i(52905);
        String Jh = C42952j.getEmojiDescMgr().mo69856Jh(str);
        AppMethodBeat.m2505o(52905);
        return Jh;
    }

    /* renamed from: Ji */
    public final boolean mo35601Ji(String str) {
        AppMethodBeat.m2504i(52906);
        if (str == null || !str.equals("capture")) {
            boolean aqc = C42952j.getEmojiStorageMgr().xYo.aqc(str);
            AppMethodBeat.m2505o(52906);
            return aqc;
        }
        AppMethodBeat.m2505o(52906);
        return true;
    }

    /* renamed from: Jj */
    public final ArrayList<String> mo35602Jj(String str) {
        AppMethodBeat.m2504i(52907);
        C44219aq emojiDescMgr = C42952j.getEmojiDescMgr();
        if (!emojiDescMgr.mInit) {
            emojiDescMgr.dsY();
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList();
        int asg = C5584f.asg(str);
        if (asg < emojiDescMgr.xXN || asg > emojiDescMgr.xXO) {
            C4990ab.m7410d("MicroMsg.emoji.EmojiDescNewMgr", "input text over checkout limit.");
            AppMethodBeat.m2505o(52907);
            return null;
        }
        if (!(C5046bo.isNullOrNil(str) || emojiDescMgr.xXS == null)) {
            String toLowerCase = str.toLowerCase();
            ArrayList arrayList3 = new ArrayList();
            if (emojiDescMgr.xXR.containsKey(toLowerCase)) {
                arrayList3.addAll((Collection) emojiDescMgr.xXQ.get(emojiDescMgr.xXR.get(toLowerCase)));
            } else {
                arrayList3.add(toLowerCase);
            }
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                ArrayList arrayList4 = (ArrayList) emojiDescMgr.xXS.get((String) it.next());
                if (!(arrayList4 == null || arrayList4.isEmpty())) {
                    arrayList.addAll(arrayList4);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList, emojiDescMgr.xXT);
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList2.add(((C44220a) arrayList.get(i)).cvZ);
            }
        }
        C4990ab.m7411d("MicroMsg.emoji.EmojiDescNewMgr", "cpan[check desc]User time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(52907);
        return arrayList2;
    }

    /* renamed from: Jk */
    public final String mo35603Jk(String str) {
        AppMethodBeat.m2504i(52908);
        String Jk = EmojiLogic.m44061Jk(str);
        AppMethodBeat.m2505o(52908);
        return Jk;
    }

    /* renamed from: Jl */
    public final String mo35604Jl(String str) {
        AppMethodBeat.m2504i(52909);
        String Jl = EmojiLogic.m44062Jl(str);
        AppMethodBeat.m2505o(52909);
        return Jl;
    }

    /* renamed from: Jm */
    public final int mo35605Jm(String str) {
        AppMethodBeat.m2504i(52910);
        int Jm = EmojiLogic.m44063Jm(str);
        AppMethodBeat.m2505o(52910);
        return Jm;
    }

    /* renamed from: Jn */
    public final String mo35606Jn(String str) {
        AppMethodBeat.m2504i(52911);
        String Jn = EmojiLogic.m44064Jn(str);
        AppMethodBeat.m2505o(52911);
        return Jn;
    }

    /* renamed from: o */
    public final int mo35658o(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(52912);
        if (emojiInfo != null) {
            if (emojiInfo.field_catalog == EmojiInfo.yaz || String.valueOf(EmojiInfo.yaz).equals(emojiInfo.field_groupId)) {
                AppMethodBeat.m2505o(52912);
                return C25738R.drawable.jsb;
            } else if (emojiInfo.field_catalog == EmojiInfo.yaA || String.valueOf(EmojiInfo.yaA).equals(emojiInfo.field_groupId)) {
                AppMethodBeat.m2505o(52912);
                return C25738R.drawable.dice;
            }
        }
        AppMethodBeat.m2505o(52912);
        return 0;
    }

    /* renamed from: p */
    public final int[] mo35660p(EmojiInfo emojiInfo) {
        if (emojiInfo != null) {
            if (emojiInfo.field_catalog == EmojiInfo.yaz) {
                return new int[]{C25738R.drawable.jsb_j, C25738R.drawable.jsb_s, C25738R.drawable.jsb_b};
            }
            if (emojiInfo.field_catalog == EmojiInfo.yaA) {
                return new int[]{C25738R.drawable.dice_action_0, C25738R.drawable.dice_action_1, C25738R.drawable.dice_action_2, C25738R.drawable.dice_action_3};
            }
        }
        return null;
    }

    /* renamed from: l */
    public final byte[] mo35656l(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(52913);
        if (emojiInfo != null) {
            EmojiInfo Jd = mo35596Jd(emojiInfo.field_md5);
            if (!(Jd == null || Jd.field_reserved4 == emojiInfo.field_reserved4)) {
                emojiInfo.field_reserved4 = Jd.field_reserved4;
            }
        }
        byte[] l = C20362f.bjK().mo35593l(emojiInfo);
        AppMethodBeat.m2505o(52913);
        return l;
    }

    /* renamed from: c */
    public final boolean mo35642c(EmojiInfo emojiInfo, boolean z) {
        AppMethodBeat.m2504i(52914);
        boolean c = C20362f.bjK().mo35591c(emojiInfo, z);
        AppMethodBeat.m2505o(52914);
        return c;
    }

    public final void onDestroy() {
    }

    public final boolean bjN() {
        AppMethodBeat.m2504i(52915);
        boolean OL = C26072e.m41617OL();
        AppMethodBeat.m2505o(52915);
        return OL;
    }

    public final ArrayList<SmileyInfo> bjO() {
        AppMethodBeat.m2504i(52916);
        ArrayList bjO = C42952j.getEmojiStorageMgr().xYv.bjO();
        AppMethodBeat.m2505o(52916);
        return bjO;
    }

    public final ArrayList<C40628r> bjP() {
        AppMethodBeat.m2504i(52917);
        ArrayList bjP = C42952j.getEmojiStorageMgr().xYw.bjP();
        AppMethodBeat.m2505o(52917);
        return bjP;
    }

    /* renamed from: w */
    public final boolean mo35665w(ArrayList<SmileyInfo> arrayList) {
        AppMethodBeat.m2504i(52918);
        boolean an = C42952j.getEmojiStorageMgr().xYv.mo69867an(arrayList);
        AppMethodBeat.m2505o(52918);
        return an;
    }

    /* renamed from: x */
    public final boolean mo35666x(ArrayList<C40628r> arrayList) {
        AppMethodBeat.m2504i(52919);
        C46625s c46625s = C42952j.getEmojiStorageMgr().xYw;
        if (arrayList == null || arrayList.size() <= 0) {
            C4990ab.m7416i("MicroMsg.emoji.SmileyPanelConfigInfoStorage", "insertSmileyConfigInfoList failed. list is null.");
        } else {
            long iV;
            C7480h c7480h;
            if (c46625s.bSd instanceof C7480h) {
                C7480h c7480h2 = (C7480h) c46625s.bSd;
                iV = c7480h2.mo15639iV(Thread.currentThread().getId());
                c7480h = c7480h2;
            } else {
                iV = -1;
                c7480h = null;
            }
            c46625s.bSd.delete("SmileyPanelConfigInfo", null, null);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                c46625s.mo10101b((C4925c) (C40628r) it.next());
            }
            int i = -1;
            if (c7480h != null) {
                i = c7480h.mo15640mB(iV);
            }
            if (i >= 0) {
                AppMethodBeat.m2505o(52919);
                return true;
            }
        }
        AppMethodBeat.m2505o(52919);
        return false;
    }

    /* renamed from: dL */
    public final String mo35646dL(String str, String str2) {
        AppMethodBeat.m2504i(52920);
        String L = EmojiLogic.m44073L(C2933b.m5221Yb(), str, str2);
        AppMethodBeat.m2505o(52920);
        return L;
    }

    public final C6337f bjQ() {
        AppMethodBeat.m2504i(52921);
        C6337f bjQ = C45852j.bkb().bjQ();
        AppMethodBeat.m2505o(52921);
        return bjQ;
    }

    public final String bjS() {
        AppMethodBeat.m2504i(52924);
        C45852j.bkb();
        String bjS = C45852j.bjS();
        AppMethodBeat.m2505o(52924);
        return bjS;
    }

    public final void bjT() {
        AppMethodBeat.m2504i(52925);
        C45852j.bkb();
        C32519bf c32519bf = new C32519bf();
        c32519bf.cus.filePath = C6457e.eSn + "CheckResUpdate/37.1.data.decompressed";
        c32519bf.cus.cut = 37;
        c32519bf.cus.cuu = 1;
        C45852j.m84895a(c32519bf, C27735a.EMOJI, C45852j.kUa);
        AppMethodBeat.m2505o(52925);
    }

    /* renamed from: d */
    public final int mo35643d(EmojiInfo emojiInfo, boolean z) {
        AppMethodBeat.m2504i(52926);
        Object obj = (z || !(emojiInfo == null || emojiInfo.field_activityid == null || !emojiInfo.field_activityid.startsWith("Selfie:"))) ? 1 : null;
        int Nb;
        if (obj != null) {
            Nb = C42164b.m74340Nb();
            AppMethodBeat.m2505o(52926);
            return Nb;
        }
        Nb = C42164b.m74338MZ();
        AppMethodBeat.m2505o(52926);
        return Nb;
    }

    public final cab bjU() {
        AppMethodBeat.m2504i(52927);
        cab bjU = C42952j.getEmojiStorageMgr().xYq.bjU();
        AppMethodBeat.m2505o(52927);
        return bjU;
    }

    /* renamed from: a */
    public final void mo35619a(cab cab) {
        AppMethodBeat.m2504i(52928);
        C42952j.getEmojiStorageMgr().xYq.mo64091b(cab);
        AppMethodBeat.m2505o(52928);
    }

    /* renamed from: y */
    public final int mo35667y(boolean z, boolean z2) {
        AppMethodBeat.m2504i(52929);
        int y = C42952j.getEmojiStorageMgr().xYn.mo48592y(z, z2);
        AppMethodBeat.m2505o(52929);
        return y;
    }

    /* renamed from: Jp */
    public final int mo35608Jp(String str) {
        AppMethodBeat.m2504i(52930);
        int Jp = C42952j.getEmojiStorageMgr().xYn.mo48558Jp(str);
        AppMethodBeat.m2505o(52930);
        return Jp;
    }

    /* renamed from: a */
    public final boolean mo35622a(EmojiGroupInfo emojiGroupInfo) {
        AppMethodBeat.m2504i(52931);
        boolean c = C42952j.getEmojiStorageMgr().xYo.mo10103c(emojiGroupInfo, "productID");
        AppMethodBeat.m2505o(52931);
        return c;
    }

    /* renamed from: OD */
    public final ArrayList<EmojiGroupInfo> mo35612OD() {
        AppMethodBeat.m2504i(52932);
        ArrayList OD = C42952j.getEmojiStorageMgr().xYz.mo53135OD();
        AppMethodBeat.m2505o(52932);
        return OD;
    }

    public final int bjV() {
        AppMethodBeat.m2504i(52933);
        int bjV = C42952j.getEmojiStorageMgr().bjV();
        AppMethodBeat.m2505o(52933);
        return bjV;
    }

    /* renamed from: bY */
    public final ArrayList<EmojiInfo> mo35625bY(boolean z) {
        AppMethodBeat.m2504i(52934);
        ArrayList bY = C42952j.getEmojiStorageMgr().mo39170bY(z);
        AppMethodBeat.m2505o(52934);
        return bY;
    }

    /* renamed from: OC */
    public final ArrayList<EmojiInfo> mo35611OC() {
        AppMethodBeat.m2504i(52935);
        ArrayList OC = C42952j.getEmojiStorageMgr().xYz.mo53134OC();
        AppMethodBeat.m2505o(52935);
        return OC;
    }

    /* renamed from: kS */
    public final ArrayList<EmojiInfo> mo35654kS(String str) {
        AppMethodBeat.m2504i(52936);
        ArrayList kS = C42952j.getEmojiStorageMgr().xYz.mo53142kS(str);
        AppMethodBeat.m2505o(52936);
        return kS;
    }

    public final C25815a bjW() {
        AppMethodBeat.m2504i(52937);
        C25815a bjW = C42952j.bjW();
        AppMethodBeat.m2505o(52937);
        return bjW;
    }

    /* renamed from: g */
    public final void mo35647g(C4931a c4931a) {
        AppMethodBeat.m2504i(52938);
        C42952j.getEmojiStorageMgr().xYn.mo10117d(c4931a);
        AppMethodBeat.m2505o(52938);
    }

    /* renamed from: h */
    public final void mo35649h(C4931a c4931a) {
        AppMethodBeat.m2504i(52939);
        C42952j.getEmojiStorageMgr().xYn.mo10116c(c4931a);
        AppMethodBeat.m2505o(52939);
    }

    /* renamed from: i */
    public final void mo35650i(C4931a c4931a) {
        AppMethodBeat.m2504i(52940);
        C42952j.getEmojiStorageMgr().xYo.mo10117d(c4931a);
        AppMethodBeat.m2505o(52940);
    }

    /* renamed from: j */
    public final void mo35652j(C4931a c4931a) {
        AppMethodBeat.m2504i(52941);
        if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
            C42952j.getEmojiStorageMgr().xYo.mo10116c(c4931a);
        }
        AppMethodBeat.m2505o(52941);
    }

    public final boolean bjX() {
        AppMethodBeat.m2504i(52942);
        boolean OR = C26072e.m41623OR();
        AppMethodBeat.m2505o(52942);
        return OR;
    }

    /* renamed from: OS */
    public final boolean mo35613OS() {
        AppMethodBeat.m2504i(52943);
        boolean OS = C26072e.m41624OS();
        AppMethodBeat.m2505o(52943);
        return OS;
    }

    /* renamed from: OT */
    public final boolean mo35614OT() {
        AppMethodBeat.m2504i(52944);
        if (C5047bp.dpL() || C26072e.m41625OT()) {
            AppMethodBeat.m2505o(52944);
            return true;
        }
        AppMethodBeat.m2505o(52944);
        return false;
    }

    /* renamed from: bZ */
    public final void mo35626bZ(String str, int i) {
        AppMethodBeat.m2504i(52945);
        C15439u c15439u = C42952j.getEmojiStorageMgr().xYy;
        if (!Util.isNullOrNil(str)) {
            if (c15439u.ybh == null) {
                c15439u.dvl();
            }
            C15438t c15438t = (C15438t) c15439u.ybh.get(str);
            if (c15438t == null) {
                c15438t = new C15438t();
                c15438t.key = str;
                c15439u.ybh.put(str, c15438t);
            }
            c15438t.position = i;
            c15438t.ybg++;
            c15438t.eRt = System.currentTimeMillis();
            String str2 = "event_update_recent";
            if (c15439u.ybh == null) {
                c15439u.dvl();
            }
            c15439u.mo15641b(str2, 0, Integer.valueOf(c15439u.ybh.size()));
        }
        AppMethodBeat.m2505o(52945);
    }

    public final List<C15438t> bjY() {
        AppMethodBeat.m2504i(52946);
        List bjY = C42952j.getEmojiStorageMgr().xYy.bjY();
        AppMethodBeat.m2505o(52946);
        return bjY;
    }

    public final void bjZ() {
        AppMethodBeat.m2504i(52947);
        C15439u c15439u = C42952j.getEmojiStorageMgr().xYy;
        List<C15438t> bjY = c15439u.bjY();
        JSONArray jSONArray = new JSONArray();
        for (C15438t c15438t : bjY) {
            if (c15438t.toJson() != null) {
                jSONArray.put(c15438t.toJson());
                if (jSONArray.length() >= 9) {
                    break;
                }
            }
        }
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_RECENT_SMILEY_STRING, jSONArray.toString());
        c15439u.ybh = null;
        AppMethodBeat.m2505o(52947);
    }

    /* renamed from: c */
    public final <T> T mo35641c(C5127a c5127a, T t) {
        AppMethodBeat.m2504i(52948);
        Object obj = C1720g.m3536RP().mo5239Ry().get(c5127a, (Object) t);
        AppMethodBeat.m2505o(52948);
        return obj;
    }

    /* renamed from: d */
    public final void mo35644d(C5127a c5127a, Object obj) {
        AppMethodBeat.m2504i(52949);
        C1720g.m3536RP().mo5239Ry().set(c5127a, obj);
        AppMethodBeat.m2505o(52949);
    }

    /* renamed from: k */
    public final void mo35653k(C4931a c4931a) {
        AppMethodBeat.m2504i(52950);
        C42952j.getEmojiStorageMgr().xYy.mo10116c(c4931a);
        AppMethodBeat.m2505o(52950);
    }

    /* JADX WARNING: Missing block: B:4:0x0017, code skipped:
            if (r3 <= com.tencent.p177mm.p249m.C42164b.m74340Nb()) goto L_0x0019;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Jq */
    public final boolean mo35609Jq(String str) {
        boolean z = false;
        AppMethodBeat.m2504i(52951);
        C3276f c3276f = new C3276f(str);
        int cs = C1173e.m2560cs(str);
        if (cs != 0) {
            try {
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.emoji.EmojiMgrImpl", C5046bo.m7574l(e));
            }
        }
        if (c3276f.noD[0] <= C42164b.m74339Na() && c3276f.noD[1] <= C42164b.m74339Na()) {
            z = true;
        }
        AppMethodBeat.m2505o(52951);
        return z;
    }

    public final boolean bka() {
        boolean z;
        AppMethodBeat.m2504i(52952);
        if (C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.USERINFO_EMOJI_CAPTURE_TAB_RED_DOT_BOOLEAN, false)) {
            z = false;
        } else {
            z = true;
        }
        C26072e.isSpringFestivalEnable();
        if (z) {
            AppMethodBeat.m2505o(52952);
            return true;
        }
        AppMethodBeat.m2505o(52952);
        return false;
    }

    /* renamed from: l */
    public final void mo35655l(C4931a c4931a) {
        AppMethodBeat.m2504i(52953);
        C42952j.getEmojiStorageMgr().xYy.mo10117d(c4931a);
        AppMethodBeat.m2505o(52953);
    }

    /* renamed from: Jr */
    public final void mo35610Jr(String str) {
        AppMethodBeat.m2504i(52954);
        if (!C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiMgrImpl", "deleteCaptureEmoji md: ".concat(String.valueOf(str)));
            C42952j.getEmojiStorageMgr().xYn.aqj(str);
            C42952j.getEmojiStorageMgr().xYn.anF("delete_emoji_info_notify");
        }
        AppMethodBeat.m2505o(52954);
    }

    /* renamed from: a */
    public final void mo35618a(UploadTask uploadTask) {
        AppMethodBeat.m2504i(52955);
        if (uploadTask.lgZ == null) {
            AppMethodBeat.m2505o(52955);
            return;
        }
        final EmojiInfo aqi = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiStorageMgr().xYn.aqi(uploadTask.lgZ);
        if (aqi == null) {
            AppMethodBeat.m2505o(52955);
            return;
        }
        final EmojiCaptureReporter emojiCaptureReporter = uploadTask.lha;
        C4990ab.m7410d("MicroMsg.emoji.EmojiMgrImpl", "uploadCaptureEmoji emojiInfo.field_md5: " + aqi.field_md5);
        emojiCaptureReporter.lgP = System.currentTimeMillis();
        emojiCaptureReporter.ezZ = aqi.field_captureEnterTime;
        C18190d c18190d = new C18190d(aqi, aqi.dvd(), aqi.field_imitateMd5, new C18191b() {

            /* renamed from: com.tencent.mm.plugin.emoji.e.h$1$1 */
            class C203671 implements Runnable {
                C203671() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(52884);
                    C45847a.bjF().bjG();
                    AppMethodBeat.m2505o(52884);
                }
            }

            /* renamed from: f */
            public final void mo33667f(int i, String str, String str2) {
                AppMethodBeat.m2504i(52885);
                C1720g.m3539RS().mo10302aa(new C203671());
                C4990ab.m7410d("MicroMsg.emoji.EmojiMgrImpl", "uploadCaptureEmoji errorCode: " + i + " gifMd5: " + str + " activityId: " + str2);
                if (i != 0) {
                    aqi.mo48510a(C30302a.STATUS_UPLOAD_FAIL);
                }
                switch (i) {
                    case 0:
                        emojiCaptureReporter.lgQ = System.currentTimeMillis();
                        EmojiCaptureReporter.m66033d(emojiCaptureReporter.ezZ, emojiCaptureReporter.lgQ - emojiCaptureReporter.lgP, aqi.field_captureScene);
                        aqi.mo48510a(C30302a.STATUS_SUCCESS);
                        aqi.mo48511a(C30301b.ERR_SUCCESS);
                        C7060h.pYm.mo8381e(10431, Integer.valueOf(7), aqi.mo20410Aq(), aqi.field_designerID, aqi.field_groupId, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(aqi.field_size), C1853r.m3846Yz(), aqi.field_activityid);
                        break;
                    case 2:
                        EmojiCaptureReporter.m66036g(emojiCaptureReporter.ezZ, 2, aqi.field_captureScene);
                        aqi.mo48511a(C30301b.ERR_OVER_SIZE);
                        break;
                    case 3:
                        EmojiCaptureReporter.m66036g(emojiCaptureReporter.ezZ, 1, aqi.field_captureScene);
                        aqi.mo48511a(C30301b.ERR_OVER_LIMIT);
                        break;
                    case 4:
                        EmojiCaptureReporter.m66036g(emojiCaptureReporter.ezZ, 5, aqi.field_captureScene);
                        aqi.mo48511a(C30301b.ERR_NOT_COMPLETED);
                        break;
                    case 5:
                        EmojiCaptureReporter.m66036g(emojiCaptureReporter.ezZ, 7, aqi.field_captureScene);
                        aqi.mo48511a(C30301b.ERR_NON_NETWORK);
                        break;
                    case 6:
                        EmojiCaptureReporter.m66036g(emojiCaptureReporter.ezZ, 8, aqi.field_captureScene);
                        aqi.mo48511a(C30301b.ERR_WIFI_NETWORK);
                        break;
                    case 7:
                        EmojiCaptureReporter.m66036g(emojiCaptureReporter.ezZ, 9, aqi.field_captureScene);
                        aqi.mo48511a(C30301b.ERR_MOBILE_NETWORK);
                        break;
                    case 8:
                        EmojiCaptureReporter.m66036g(emojiCaptureReporter.ezZ, 6, aqi.field_captureScene);
                        aqi.mo48511a(C30301b.ERR_SPAM);
                        break;
                    case 9:
                        EmojiCaptureReporter.m66036g(emojiCaptureReporter.ezZ, 10, aqi.field_captureScene);
                        aqi.mo48511a(C30301b.ERR_OVER_UPLOAD_TIME);
                        break;
                    case 10:
                        EmojiCaptureReporter.m66036g(emojiCaptureReporter.ezZ, 4, aqi.field_captureScene);
                        aqi.mo48511a(C30301b.ERR_LOCAL_FILE);
                        break;
                    default:
                        EmojiCaptureReporter.m66036g(emojiCaptureReporter.ezZ, 3, aqi.field_captureScene);
                        aqi.mo48511a(C30301b.ERR_OTHERS);
                        break;
                }
                ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiStorageMgr().xYn.mo48555G(aqi);
                AppMethodBeat.m2505o(52885);
            }
        });
        AppMethodBeat.m2505o(52955);
    }

    /* renamed from: q */
    public final void mo35661q(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(52956);
        emojiInfo.field_groupId = "capture";
        ArrayList arrayList = new ArrayList();
        arrayList.add(emojiInfo.mo20410Aq());
        ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiStorageMgr().xYn.mo48585l(1, arrayList);
        ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiStorageMgr().xYn.mo48555G(emojiInfo);
        C45317cz c45317cz = new C45317cz();
        c45317cz.cwc.type = 2;
        C4879a.xxA.mo10055m(c45317cz);
        if (!c45317cz.cwd.cwe) {
            cab bjU = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiStorageMgr().xYq.bjU();
            if (bjU != null) {
                Iterator it = bjU.wZl.iterator();
                while (it.hasNext()) {
                    cac cac = (cac) it.next();
                    if (cac.ProductID.equals(String.valueOf("capture"))) {
                        cac.vKj = 0;
                        break;
                    }
                }
            }
            ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiStorageMgr().xYq.mo64091b(bjU);
            C45274a.dmE();
            C1336b c1336b = C45274a.xum;
            C1336b.alW(String.valueOf("capture"));
        }
        AppMethodBeat.m2505o(52956);
    }

    /* renamed from: r */
    public final void mo35662r(final EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(52957);
        C5004al.m7441d(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.emoji.e.h$2$1 */
            class C203691 implements C5662c {
                C203691() {
                }

                /* renamed from: d */
                public final void mo5699d(boolean z, String str) {
                    AppMethodBeat.m2504i(52886);
                    if (z && !C5046bo.isNullOrNil(emojiInfo.mo20410Aq())) {
                        ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35610Jr(emojiInfo.mo20410Aq());
                    }
                    AppMethodBeat.m2505o(52886);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(52887);
                Context context = C4996ah.getContext();
                C5659a c5659a = new C5659a(context);
                c5659a.asL(context.getString(C25738R.string.b9b)).mo11509Qg(C25738R.string.bd3).mo11510Qh(context.getResources().getColor(C25738R.color.f12267y0));
                c5659a.mo11523c(new C203691()).show();
                AppMethodBeat.m2505o(52887);
            }
        });
        AppMethodBeat.m2505o(52957);
    }

    /* renamed from: n */
    public final EmojiInfo mo35657n(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(52890);
        if (emojiInfo.field_catalog == EmojiGroupInfo.yas && emojiInfo.field_type == EmojiInfo.zYR && emojiInfo.getContent().length() > 0 && EmojiInfo.m48209Mw(C5046bo.getInt(emojiInfo.getContent(), 0))) {
            Cursor MB = C42952j.getEmojiStorageMgr().xYn.mo48560MB(C5046bo.getInt(emojiInfo.getContent(), 0));
            if (MB != null && MB.getCount() > 1) {
                int gV = C5046bo.m7560gV(MB.getCount() - 1, 0);
                emojiInfo = new EmojiInfo();
                MB.moveToPosition(gV);
                emojiInfo.mo8995d(MB);
            }
            if (MB != null) {
                MB.close();
            }
        }
        AppMethodBeat.m2505o(52890);
        return emojiInfo;
    }

    /* renamed from: a */
    public final boolean mo35621a(Context context, EmojiInfo emojiInfo, int i, String str) {
        AppMethodBeat.m2504i(52891);
        if (context == null) {
            C4990ab.m7412e("MicroMsg.emoji.EmojiMgrImpl", "[cpan] save emoji failed. context is null");
            AppMethodBeat.m2505o(52891);
            return false;
        } else if (emojiInfo == null) {
            C4990ab.m7412e("MicroMsg.emoji.EmojiMgrImpl", "[cpan] save emoji failed. emoji is null");
            AppMethodBeat.m2505o(52891);
            return false;
        } else {
            Intent intent = new Intent();
            intent.setClass(context, EmojiAddCustomDialogUI.class);
            intent.putExtra("extra_id", emojiInfo.mo20410Aq());
            intent.putExtra("extra_scence", i);
            intent.putExtra("extra_move_to_top", true);
            intent.putExtra("extra_username", str);
            intent.putExtra("extra_current", false);
            intent.putExtra("key_is_selfie", false);
            intent.putExtra("key_attached_text", null);
            intent.putExtra("key_attached_emoji_md5", null);
            intent.putExtra("key_imitate_md5", null);
            intent.addFlags(65536);
            context.startActivity(intent);
            AppMethodBeat.m2505o(52891);
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0231  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: Jo */
    public final void mo35607Jo(String str) {
        ArrayList arrayList;
        EmojiInfo emojiInfo;
        C32519bf c32519bf;
        AppMethodBeat.m2504i(52922);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiCommandMgr", "emoji command is null.");
        }
        if ("sync".equalsIgnoreCase(str)) {
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_RECOVER_CUSTOM_EMOJI_BOOLEAN, Boolean.TRUE);
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_SYNC_CUSTOM_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE);
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_SYNC_CAPTURE_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE);
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_NEXT_CUSTOM_BATCH_DOWNLOAD_TIME_LONG, Long.valueOf(System.currentTimeMillis()));
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_NEXT_CAPTURE_BATCH_DOWNLOAD_TIME_LONG, Long.valueOf(System.currentTimeMillis()));
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_SYNC_STORE_EMOJI_DOWNLOAD_LONG, Long.valueOf(0));
            C1720g.m3535RO().eJo.mo14541a(new C27737e(0), 0);
            C1720g.m3535RO().eJo.mo14541a(new C27737e(1), 0);
            C1720g.m3535RO().eJo.mo14541a(new C20375n(8, null, 15, true), 0);
        } else if ("rcheart".equalsIgnoreCase(str)) {
            C42952j.getEmojiStorageMgr().xYo.duN();
        } else if ("recover".equalsIgnoreCase(str)) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiCommandMgr", "recover   begin");
            C42952j.getEmojiStorageMgr().xYn.mo48583hi(C4996ah.getContext());
            C42952j.getEmojiStorageMgr().xYo.mo74787hi(C4996ah.getContext());
            C4990ab.m7416i("MicroMsg.emoji.EmojiCommandMgr", "recover   end");
        } else if ("clean".equalsIgnoreCase(str)) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiCommandMgr", "begin clean");
            C20360e.bjJ().mo35589Jc(C2933b.m5221Yb());
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_SYNC_CUSTOM_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE);
            C4990ab.m7416i("MicroMsg.emoji.EmojiCommandMgr", "end clean");
        } else if ("dump".equalsIgnoreCase(str)) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiCommandMgr", "begin dump emoji db info:");
            arrayList = (ArrayList) C42952j.getEmojiStorageMgr().xYo.duz();
            if (arrayList.size() > 0) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    EmojiGroupInfo emojiGroupInfo = (EmojiGroupInfo) arrayList.get(i);
                    C4990ab.m7417i("MicroMsg.emoji.EmojiCommandMgr", "i:%d group info:%s", Integer.valueOf(i), emojiGroupInfo.toString());
                }
            }
            Cursor cursor = null;
            try {
                cursor = C42952j.getEmojiStorageMgr().xYn.baR();
                if (cursor == null || !cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    C4990ab.m7416i("MicroMsg.emoji.EmojiCommandMgr", "end dump emoji db info:");
                } else {
                    do {
                        new EmojiInfo().mo8995d(cursor);
                        C4990ab.m7417i("MicroMsg.emoji.EmojiCommandMgr", "emoji info:%s", emojiInfo.toString());
                    } while (cursor.moveToNext());
                    if (cursor != null) {
                    }
                    C4990ab.m7416i("MicroMsg.emoji.EmojiCommandMgr", "end dump emoji db info:");
                }
            } catch (Exception e) {
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.m2505o(52922);
            }
        } else if ("config".equalsIgnoreCase(str)) {
            C14845c.veg.mo27152f(37, 1, -1, false);
            C14845c.veg.mo27152f(37, 2, -1, false);
            C14845c.veg.mo27152f(37, 4, -1, false);
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_NEW_EMOJI_INT, Integer.valueOf(0));
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_NEW_PANEL_INT, Integer.valueOf(0));
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_EGG_INT, Integer.valueOf(0));
            C1720g.m3535RO().eJo.mo14541a(new C44796m(37), 0);
            c32519bf = new C32519bf();
            c32519bf.cus.filePath = C6457e.eSn + "CheckResUpdate/37.1.data.decompressed";
            c32519bf.cus.cut = 37;
            c32519bf.cus.cuu = 1;
            C32519bf c32519bf2 = new C32519bf();
            c32519bf2.cus.filePath = C6457e.eSn + "CheckResUpdate/37.2.data.decompressed";
            c32519bf2.cus.cut = 37;
            c32519bf2.cus.cuu = 2;
            C45852j.bkb();
            C45852j.m84893a(c32519bf, true);
            C45852j.bkb();
            C45852j.m84896b(c32519bf2, true);
            C5730e.deleteFile(C37626b.xFA);
        } else if ("tuzki".equalsIgnoreCase(str)) {
            C45855a.bkq();
            C45855a.bkr();
        } else {
            if (str.startsWith("reset-first")) {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_CAPTURE_OPENED_BOOLEAN, Boolean.FALSE);
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_CAPTURE_IMITATE_SAVED_BOOLEAN, Boolean.FALSE);
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_CAPTURE_OUTER_EMOJI_BUTTON_RED_DOT_BOOLEAN, Boolean.FALSE);
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_CAPTURE_TAB_RED_DOT_BOOLEAN, Boolean.FALSE);
            }
        }
        if (C5047bp.dpL()) {
            if ("new".equalsIgnoreCase(str)) {
                C16112c.m24429PK().mo28556x(262147, true);
                C1720g.m3536RP().mo5239Ry().set(208899, Boolean.TRUE);
                C1720g.m3536RP().mo5239Ry().set(229633, (Object) "http://mmbiz.qpic.cn/mmemoticon/Q3auHgzwzM5eOptD4jIj72I8icMVEKwzSYkC30IgjMvSibGfqsEdy0ibXayiaZtbibSXV5EPZEWILOvbrjjLtQ9P4QQ/0");
                C1720g.m3536RP().mo5239Ry().set(229634, System.currentTimeMillis());
                AppMethodBeat.m2505o(52922);
                return;
            } else if ("free".equalsIgnoreCase(str)) {
                C16112c.m24429PK().mo28556x(262149, true);
                C1720g.m3536RP().mo5239Ry().set(208913, Boolean.TRUE);
                C1720g.m3536RP().mo5239Ry().set(229633, (Object) "http://mmbiz.qpic.cn/mmemoticon/Q3auHgzwzM5eOptD4jIj72I8icMVEKwzSYkC30IgjMvSibGfqsEdy0ibXayiaZtbibSXV5EPZEWILOvbrjjLtQ9P4QQ/0");
                C1720g.m3536RP().mo5239Ry().set(229634, System.currentTimeMillis());
                AppMethodBeat.m2505o(52922);
                return;
            } else if ("newp".equalsIgnoreCase(str)) {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_STORE_NEW_ORIGINAL_BOOLEAN, Boolean.TRUE);
                AppMethodBeat.m2505o(52922);
                return;
            } else if ("newpe".equalsIgnoreCase(str)) {
                C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_STORE_NEW_DESIGNER_EMOJI_BOOLEAN, Boolean.TRUE);
                AppMethodBeat.m2505o(52922);
                return;
            } else {
                if (str.startsWith("add")) {
                    C38877b.m65945Ja(str);
                    AppMethodBeat.m2505o(52922);
                    return;
                }
                if (str.startsWith("backup")) {
                    C1720g.m3535RO().eJo.mo14541a(new C33949c(0, 1, Arrays.asList(str.replace("backup", "").trim().split(","))), 0);
                    AppMethodBeat.m2505o(52922);
                    return;
                }
                if (str.startsWith("h5")) {
                    PreferenceManager.getDefaultSharedPreferences(C4996ah.getContext()).edit().putString("h5", str.replace("h5", "").trim()).commit();
                    AppMethodBeat.m2505o(52922);
                    return;
                }
                String trim;
                if (str.startsWith("md5")) {
                    trim = str.replace("md5", "").trim();
                    if (C5046bo.isNullOrNil(trim)) {
                        trim = "/sdcard/test.png";
                    }
                    C4990ab.m7416i("MicroMsg.emoji.EmojiCommandMgr", C1178g.m2589v(new File(trim)));
                    C4990ab.m7416i("MicroMsg.emoji.EmojiCommandMgr", C4995ag.m7428ck(trim));
                    AppMethodBeat.m2505o(52922);
                    return;
                }
                if (str.startsWith("recommend")) {
                    arrayList = C20377d.m31543JG("<NewRecommendEmotion><Emotion><ProductID>com.tencent.xin.emoticon.person.stiker_144984189945aa5830d33cd7dc</ProductID><RecType>3</RecType><Name>野萌君</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/duc2TvpEgSTWy4k8MnuicFjyiazriaGWDX52HzNWeLVTjtJcjZeZEicTn5kJFPYdicWZTuUZJgiaADK9I/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/DhduwiaBa7lchicgAfwibeykm81eGWXkMDgGJ8DWcOcIc28C7oTic4Y09Pick8Fw69KiaZVxrHl8S2lPY/0</Panel><ButtonType>1</ButtonType></Emotion><Emotion><ProductID>com.tencent.xin.emoticon.person.stiker_14389422638f6ca818af405e21</ProductID><RecType>3</RecType><Name>猪仔和羊妹</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/iaUiazNVkRp7iaZjrMuYgfH8kB5xkyYv20CYzY3W9HCLBr2XybJibGKKtXibMnAfZnRTH/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/PiajxSqBRaEJR9canNKZ7RYI3hx5BPCSwQmuhhlNWD1jzUSOx3CWqEtibd65zOjySd/0</Panel><ButtonType>1</ButtonType></Emotion><Emotion><ProductID>com.tencent.xin.emoticon.person.stiker_1444199720f5ea147582ff0512</ProductID><RecType>3</RecType><Name>让红包飞</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/nMl9ssowtibXLY57PdK8Nsh827vlsw4TGHPgLUehd2R455xnwe3xpoVDIKpAuXU1Aic3XbH1LfMr7fp4DgO7o8IQ/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/duc2TvpEgST18reErFRzNFR8EiahI4Iibp4ZnW1ibJYt4MMLvQvjx3sHGTMuTOgnREq5f2GXLhuzalOOz3icw9NGbA/0</Panel><ButtonType>1</ButtonType></Emotion><Emotion><ProductID>com.tencent.xin.emoticon.xiaobendan</ProductID><RecType>3</RecType><Name>小笨蛋与大坏蛋</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/ajNVdqHZLLC8ILTt0pqcaCVkldLMydoNJcupoR7qUojia3vKlgd74uQ/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/ajNVdqHZLLC8ILTt0pqcaAAEUI4a7z5ECqpUXbQw95PY1mpc4p0FxA/0</Panel><ButtonType>1</ButtonType></Emotion><Emotion><ProductID>com.tencent.xin.emoticon.shin2</ProductID><RecType>3</RecType><Name>野原新之助2</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/iciaySdkria4apGIW1wvSbPC9oxWQPHZyicaccx5JDIp2uE/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/ajNVdqHZLLASEAAX7xw76beia5j4HyA0rq9WgtgscicJo7935UCpCpog/0</Panel><ButtonType>1</ButtonType></Emotion></NewRecommendEmotion>");
                    C42952j.getEmojiStorageMgr().xYo.duF();
                    C42952j.getEmojiStorageMgr().xYo.mo74767ak(arrayList);
                    AppMethodBeat.m2505o(52922);
                    return;
                }
                if (str.startsWith("count")) {
                    C26373g.m41964Nu().put("CustomEmojiMaxSize", str.replace("count", "").trim());
                    AppMethodBeat.m2505o(52922);
                    return;
                }
                if (str.startsWith("auto")) {
                    C26373g.m41964Nu().put("C2CEmojiNotAutoDownloadTimeRange", str.replace("auto", "").trim());
                    AppMethodBeat.m2505o(52922);
                    return;
                }
                if (str.startsWith("bo")) {
                    if (str.replace("bo", "").trim().equalsIgnoreCase("1")) {
                        PreferenceManager.getDefaultSharedPreferences(C4996ah.getContext()).edit().putBoolean("broken", true).commit();
                        AppMethodBeat.m2505o(52922);
                        return;
                    }
                    PreferenceManager.getDefaultSharedPreferences(C4996ah.getContext()).edit().putBoolean("broken", false).commit();
                    AppMethodBeat.m2505o(52922);
                    return;
                }
                if (str.startsWith("newsmiley")) {
                    ArrayList arrayList2 = new ArrayList();
                    SmileyInfo smileyInfo = new SmileyInfo("/::AAA", "[机智]", "[机智]", "[机智]", "[机智]", "[机智]", "emoji2.png", 1000);
                    SmileyInfo smileyInfo2 = new SmileyInfo("/::BBB", "[滑稽]", "[滑稽]", "[滑稽]", "[滑稽]", "[滑稽]", "emoji3.png", 1001);
                    SmileyInfo smileyInfo3 = new SmileyInfo("[Pose]", "[摆姿势]", "[摆姿势]", "[摆姿势]", "[摆姿势]", "[摆姿势]", "emoji4.png", 1002);
                    SmileyInfo smileyInfo4 = new SmileyInfo("/::DDD", "[瞪]", "[瞪]", "[瞪]", "[瞪]", "[瞪]", "emoji5.png", 1003);
                    SmileyInfo smileyInfo5 = new SmileyInfo("/::FFF", "[捂脸]", "[捂脸]", "[捂脸]", "[捂脸]", "[捂脸]", "emoji6.png", 1004);
                    SmileyInfo smileyInfo6 = new SmileyInfo("/::Doge", "[Doge]", "[Doge]", "[Doge]", "[Doge]", "[Doge]", "emoji7.png", 1005);
                    arrayList2.add(smileyInfo);
                    arrayList2.add(smileyInfo2);
                    arrayList2.add(smileyInfo3);
                    arrayList2.add(smileyInfo4);
                    arrayList2.add(smileyInfo5);
                    arrayList2.add(smileyInfo6);
                    C42952j.getEmojiStorageMgr().xYv.mo69867an(arrayList2);
                    AppMethodBeat.m2505o(52922);
                    return;
                }
                if (str.startsWith("panel")) {
                    str.replace("panel", "").trim();
                    c32519bf = new C32519bf();
                    c32519bf.cus.cuu = 1;
                    c32519bf.cus.cut = 37;
                    c32519bf.cus.filePath = C6457e.eSn + "CheckResUpdate/37.1.data";
                    C4879a.xxA.mo10055m(c32519bf);
                    c32519bf = new C32519bf();
                    c32519bf.cus.cuu = 2;
                    c32519bf.cus.cut = 37;
                    c32519bf.cus.filePath = "/sdcard/tencent/MicroMsg/CheckResUpdate/37.2.data";
                    C4879a.xxA.mo10055m(c32519bf);
                    c32519bf = new C32519bf();
                    c32519bf.cus.cuu = 3;
                    c32519bf.cus.cut = 37;
                    c32519bf.cus.filePath = C6457e.eSn + "CheckResUpdate/37.3.data";
                    C4879a.xxA.mo10055m(c32519bf);
                    AppMethodBeat.m2505o(52922);
                    return;
                }
                if (str.startsWith("key")) {
                    trim = C1178g.m2591x(String.valueOf(System.currentTimeMillis()).getBytes());
                    C4990ab.m7416i("MicroMsg.emoji.EmojiCommandMgr", "create key :%s" + C5046bo.anv(trim));
                    C42952j.getEmojiStorageMgr().xYn.mo48561MC(XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION);
                    emojiInfo = new EmojiInfo();
                    emojiInfo.field_md5 = trim;
                    emojiInfo.field_catalog = XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION;
                    C42952j.getEmojiStorageMgr().xYn.mo48554F(emojiInfo);
                    AppMethodBeat.m2505o(52922);
                    return;
                }
                if (str.startsWith("delete")) {
                    C38877b.m65944IZ(str);
                    AppMethodBeat.m2505o(52922);
                    return;
                }
                if (str.startsWith("delete-db")) {
                    C42952j.getEmojiStorageMgr().xYn.aqj(str.replace("delete-db", "").trim());
                    AppMethodBeat.m2505o(52922);
                    return;
                }
                if (str.startsWith("delete-file")) {
                    C38877b.m65943IY(str);
                    AppMethodBeat.m2505o(52922);
                    return;
                }
                String[] split;
                if (str.startsWith("batchDownload")) {
                    split = str.split(" ");
                    if (split.length > 1) {
                        C1720g.m3535RO().eJo.mo14541a(new C27737e(C5046bo.ank(split[1])), 0);
                    }
                    AppMethodBeat.m2505o(52922);
                    return;
                }
                if (str.startsWith("getInfo")) {
                    split = str.split(" ");
                    if (split.length > 1) {
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(split[1]);
                        C1720g.m3535RO().eJo.mo14541a(new C27737e(linkedList), 0);
                    }
                    AppMethodBeat.m2505o(52922);
                    return;
                }
                if (str.startsWith("test")) {
                    C4990ab.m7417i("MicroMsg.emoji.EmojiCommandMgr", "theTest: %s", str);
                    C7305d.xDG.execute(new C277331());
                }
            }
        }
        AppMethodBeat.m2505o(52922);
    }

    public final boolean bjR() {
        AppMethodBeat.m2504i(52923);
        if (C5047bp.dpL() || C26072e.m41626OU()) {
            AppMethodBeat.m2505o(52923);
            return true;
        }
        AppMethodBeat.m2505o(52923);
        return false;
    }

    /* renamed from: b */
    public final void mo35624b(UploadTask uploadTask) {
        AppMethodBeat.m2504i(52958);
        EmojiInfo Jd = mo35596Jd(uploadTask.lgZ);
        if (Jd != null) {
            C37677d c37677d = C37677d.eAh;
            C37677d.m63711k(Jd);
            AppMethodBeat.m2505o(52958);
            return;
        }
        C4990ab.m7421w("MicroMsg.emoji.EmojiMgrImpl", "addCaptureEmojiUploadTask: emojiInfo null by md5 %s", uploadTask.lgZ);
        AppMethodBeat.m2505o(52958);
    }
}
