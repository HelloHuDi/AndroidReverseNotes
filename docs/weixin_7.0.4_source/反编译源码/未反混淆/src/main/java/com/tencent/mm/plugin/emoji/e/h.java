package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.preference.PreferenceManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.j.b;
import com.tencent.mm.emoji.decode.MMGIFJNIFactory;
import com.tencent.mm.g.a.cz;
import com.tencent.mm.g.a.py;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.f.n;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI;
import com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureUploadManager.UploadTask;
import com.tencent.mm.plugin.gif.h;
import com.tencent.mm.pluginsdk.a.d;
import com.tencent.mm.pluginsdk.g.a.a.m;
import com.tencent.mm.protocal.protobuf.cab;
import com.tencent.mm.protocal.protobuf.cac;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.SmileyInfo;
import com.tencent.mm.storage.emotion.r;
import com.tencent.mm.storage.emotion.s;
import com.tencent.mm.storage.emotion.u;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.vfs.e;
import com.tencent.recovery.util.Util;
import com.tencent.ttpic.baseutils.FileUtils;
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

public final class h implements d {
    public final EmojiInfo Jd(String str) {
        AppMethodBeat.i(52888);
        EmojiInfo aqi = j.getEmojiStorageMgr().xYn.aqi(str);
        AppMethodBeat.o(52888);
        return aqi;
    }

    public final EmojiInfo Je(String str) {
        AppMethodBeat.i(52889);
        EmojiInfo Jd = Jd(str);
        AppMethodBeat.o(52889);
        return Jd;
    }

    public final void a(Context context, bi biVar, String str) {
        AppMethodBeat.i(52892);
        if (context == null || biVar == null) {
            ab.w("MicroMsg.emoji.EmojiMgrImpl", "context or msg is null");
            AppMethodBeat.o(52892);
            return;
        }
        ap aps = ap.aps(biVar.field_content);
        b me = b.me(biVar.field_content);
        if (me == null) {
            me = new b();
            me.fgq = aps.cvZ;
        }
        EmojiInfo aqi = j.getEmojiStorageMgr().xYn.aqi(me.fgq);
        if (biVar.field_isSend == 1) {
            if (aqi == null || !aqi.duP()) {
                j.bko().c(me);
                AppMethodBeat.o(52892);
                return;
            }
            a(context, me.fgq, me.appId, me.appName, biVar.field_msgSvrId, biVar.field_talker, biVar.field_content, str);
            AppMethodBeat.o(52892);
        } else if (aqi == null || !aqi.duP()) {
            j.bko().c(me);
            AppMethodBeat.o(52892);
        } else {
            a(context, aqi.Aq(), me.appId, me.appName, biVar.field_msgSvrId, biVar.field_talker, biVar.field_content, str);
            AppMethodBeat.o(52892);
        }
    }

    public final boolean r(Context context, String str, String str2) {
        AppMethodBeat.i(52893);
        if (context == null) {
            ab.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: context is null");
            AppMethodBeat.o(52893);
            return false;
        } else if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            ab.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: userName or imgPath is null");
            AppMethodBeat.o(52893);
            return false;
        } else {
            EmojiInfo aqi = j.getEmojiStorageMgr().xYn.aqi(str2);
            if (aqi == null) {
                ab.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: emoji not found, imgPath %s", str2);
                AppMethodBeat.o(52893);
                return false;
            }
            if (aqi.field_type == EmojiInfo.zYX || aqi.field_type == EmojiInfo.zYY) {
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                String str3 = com.tencent.mm.plugin.emoji.h.b.Yb() + aqi.Aq();
                if (e.ct(str3 + "_thumb")) {
                    wXMediaMessage.thumbData = e.e(str3 + "_thumb", 0, -1);
                } else {
                    wXMediaMessage.setThumbImage(aqi.hk(context));
                }
                wXMediaMessage.mediaObject = new WXEmojiObject(str3);
                py pyVar = new py();
                pyVar.cMe.cEl = wXMediaMessage;
                pyVar.cMe.appId = aqi.field_app_id;
                pyVar.cMe.appName = null;
                pyVar.cMe.toUser = str;
                pyVar.cMe.cMf = 0;
                pyVar.cMe.cMi = aqi.Aq();
                a.xxA.m(pyVar);
            } else {
                if (aqi.field_type == EmojiInfo.zYR) {
                    Cursor MB = EmojiInfo.Mw(aqi.field_catalog) ? j.getEmojiStorageMgr().xYn.MB(aqi.field_catalog) : (aqi.field_catalog == EmojiInfo.yax && aqi.getContent().length() > 0 && EmojiInfo.Mw(bo.getInt(aqi.getContent(), 0))) ? j.getEmojiStorageMgr().xYn.MB(bo.getInt(aqi.getContent(), 0)) : null;
                    if (MB != null) {
                        int gV = bo.gV(MB.getCount() - 1, 0);
                        aqi = new EmojiInfo();
                        MB.moveToPosition(gV);
                        aqi.d(MB);
                        MB.close();
                    }
                }
                j.bkh().a(str, aqi, null);
            }
            AppMethodBeat.o(52893);
            return true;
        }
    }

    public final void a(String str, EmojiInfo emojiInfo, bi biVar) {
        AppMethodBeat.i(52894);
        if (emojiInfo == null && biVar == null) {
            AppMethodBeat.o(52894);
            return;
        }
        if (emojiInfo == null) {
            emojiInfo = j.getEmojiStorageMgr().xYn.aqi(biVar.field_imgPath);
        }
        j.bkh().a(str, emojiInfo, biVar);
        AppMethodBeat.o(52894);
    }

    private static void a(Context context, String str, String str2, String str3, long j, String str4, String str5, String str6) {
        AppMethodBeat.i(52895);
        if (str.equals("-1")) {
            ab.e("MicroMsg.emoji.EmojiMgrImpl", "showEmoji fail cause md5 is no valid");
            AppMethodBeat.o(52895);
            return;
        }
        EmojiInfo aqi = j.getEmojiStorageMgr().xYn.aqi(str);
        if (aqi == null) {
            ab.e("MicroMsg.emoji.EmojiMgrImpl", "showEmoji fail cause md5 is no valid");
            AppMethodBeat.o(52895);
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
        if (t.kH(str4)) {
            str4 = bf.oy(str5);
            intent.putExtra("room_id", str6);
        }
        intent.putExtra("msg_sender", str4);
        context.startActivity(intent);
        AppMethodBeat.o(52895);
    }

    public final as dK(String str, String str2) {
        AppMethodBeat.i(52896);
        Map z = br.z(str, "msg");
        if (z == null) {
            ab.w("MicroMsg.emoji.EmojiMgrImpl", "get from xml, but attrs is null");
            AppMethodBeat.o(52896);
            return null;
        }
        as a = as.a(z, str2, str, "");
        if (a == null) {
            ab.w("MicroMsg.emoji.EmojiMgrImpl", "parserEmojiXml error ".concat(String.valueOf(str)));
            AppMethodBeat.o(52896);
            return null;
        }
        AppMethodBeat.o(52896);
        return a;
    }

    public final EmojiInfo j(String str, int i, int i2, int i3) {
        AppMethodBeat.i(52897);
        EmojiInfo a = a(str, "", i, i2, i3, "");
        AppMethodBeat.o(52897);
        return a;
    }

    public final EmojiInfo a(String str, String str2, int i, int i2, int i3, String str3) {
        AppMethodBeat.i(52898);
        EmojiInfo e = j.getEmojiStorageMgr().xYn.e(str, str2, i, i2, i3, str3);
        AppMethodBeat.o(52898);
        return e;
    }

    public final void updateEmojiInfo(EmojiInfo emojiInfo) {
        AppMethodBeat.i(52899);
        j.getEmojiStorageMgr().xYn.G(emojiInfo);
        AppMethodBeat.o(52899);
    }

    public final String Jf(String str) {
        AppMethodBeat.i(52900);
        String Jf = EmojiLogic.Jf(str);
        AppMethodBeat.o(52900);
        return Jf;
    }

    public final String a(Context context, WXMediaMessage wXMediaMessage, String str) {
        AppMethodBeat.i(52901);
        String b = EmojiLogic.b(context, wXMediaMessage, str);
        AppMethodBeat.o(52901);
        return b;
    }

    public final boolean a(String str, String str2, long j, String str3, com.tencent.mm.ai.e.a aVar) {
        boolean z = false;
        AppMethodBeat.i(52902);
        com.tencent.mm.plugin.emoji.model.d bkh = j.bkh();
        ab.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml ".concat(String.valueOf(str2)));
        as a = as.a(br.z(str2, "msg"), str, str2, str3);
        if (a == null) {
            ab.i("MicroMsg.emoji.EmojiService", "prepareEmoji failed. emoji msg info is null.");
            AppMethodBeat.o(52902);
        } else {
            a.cKK = j;
            ab.i("MicroMsg.emoji.EmojiService", "summerbadcr prepareEmoji msgSvrId[%d], stack[%s]", Long.valueOf(j), bo.dpG());
            bkh.JC(a.cwg);
            if (!EmojiLogic.JB(com.tencent.mm.emoji.a.e.OO())) {
                z = true;
            }
            bkh.a(a, aVar, z);
            AppMethodBeat.o(52902);
        }
        return true;
    }

    public final List<EmojiInfo> Jg(String str) {
        AppMethodBeat.i(52903);
        if (g.RP().isSDCardAvailable()) {
            ArrayList arrayList = (ArrayList) j.getEmojiStorageMgr().xYn.Jg(str);
            AppMethodBeat.o(52903);
            return arrayList;
        }
        List<EmojiInfo> arrayList2 = new ArrayList();
        AppMethodBeat.o(52903);
        return arrayList2;
    }

    public final String getAccPath() {
        AppMethodBeat.i(52904);
        String str = g.RP().eJM;
        AppMethodBeat.o(52904);
        return str;
    }

    public final String Jh(String str) {
        AppMethodBeat.i(52905);
        String Jh = j.getEmojiDescMgr().Jh(str);
        AppMethodBeat.o(52905);
        return Jh;
    }

    public final boolean Ji(String str) {
        AppMethodBeat.i(52906);
        if (str == null || !str.equals("capture")) {
            boolean aqc = j.getEmojiStorageMgr().xYo.aqc(str);
            AppMethodBeat.o(52906);
            return aqc;
        }
        AppMethodBeat.o(52906);
        return true;
    }

    public final ArrayList<String> Jj(String str) {
        AppMethodBeat.i(52907);
        aq emojiDescMgr = j.getEmojiDescMgr();
        if (!emojiDescMgr.mInit) {
            emojiDescMgr.dsY();
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList();
        int asg = f.asg(str);
        if (asg < emojiDescMgr.xXN || asg > emojiDescMgr.xXO) {
            ab.d("MicroMsg.emoji.EmojiDescNewMgr", "input text over checkout limit.");
            AppMethodBeat.o(52907);
            return null;
        }
        if (!(bo.isNullOrNil(str) || emojiDescMgr.xXS == null)) {
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
                arrayList2.add(((aq.a) arrayList.get(i)).cvZ);
            }
        }
        ab.d("MicroMsg.emoji.EmojiDescNewMgr", "cpan[check desc]User time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(52907);
        return arrayList2;
    }

    public final String Jk(String str) {
        AppMethodBeat.i(52908);
        String Jk = EmojiLogic.Jk(str);
        AppMethodBeat.o(52908);
        return Jk;
    }

    public final String Jl(String str) {
        AppMethodBeat.i(52909);
        String Jl = EmojiLogic.Jl(str);
        AppMethodBeat.o(52909);
        return Jl;
    }

    public final int Jm(String str) {
        AppMethodBeat.i(52910);
        int Jm = EmojiLogic.Jm(str);
        AppMethodBeat.o(52910);
        return Jm;
    }

    public final String Jn(String str) {
        AppMethodBeat.i(52911);
        String Jn = EmojiLogic.Jn(str);
        AppMethodBeat.o(52911);
        return Jn;
    }

    public final int o(EmojiInfo emojiInfo) {
        AppMethodBeat.i(52912);
        if (emojiInfo != null) {
            if (emojiInfo.field_catalog == EmojiInfo.yaz || String.valueOf(EmojiInfo.yaz).equals(emojiInfo.field_groupId)) {
                AppMethodBeat.o(52912);
                return R.drawable.jsb;
            } else if (emojiInfo.field_catalog == EmojiInfo.yaA || String.valueOf(EmojiInfo.yaA).equals(emojiInfo.field_groupId)) {
                AppMethodBeat.o(52912);
                return R.drawable.dice;
            }
        }
        AppMethodBeat.o(52912);
        return 0;
    }

    public final int[] p(EmojiInfo emojiInfo) {
        if (emojiInfo != null) {
            if (emojiInfo.field_catalog == EmojiInfo.yaz) {
                return new int[]{R.drawable.jsb_j, R.drawable.jsb_s, R.drawable.jsb_b};
            }
            if (emojiInfo.field_catalog == EmojiInfo.yaA) {
                return new int[]{R.drawable.dice_action_0, R.drawable.dice_action_1, R.drawable.dice_action_2, R.drawable.dice_action_3};
            }
        }
        return null;
    }

    public final byte[] l(EmojiInfo emojiInfo) {
        AppMethodBeat.i(52913);
        if (emojiInfo != null) {
            EmojiInfo Jd = Jd(emojiInfo.field_md5);
            if (!(Jd == null || Jd.field_reserved4 == emojiInfo.field_reserved4)) {
                emojiInfo.field_reserved4 = Jd.field_reserved4;
            }
        }
        byte[] l = f.bjK().l(emojiInfo);
        AppMethodBeat.o(52913);
        return l;
    }

    public final boolean c(EmojiInfo emojiInfo, boolean z) {
        AppMethodBeat.i(52914);
        boolean c = f.bjK().c(emojiInfo, z);
        AppMethodBeat.o(52914);
        return c;
    }

    public final void onDestroy() {
    }

    public final boolean bjN() {
        AppMethodBeat.i(52915);
        boolean OL = com.tencent.mm.emoji.a.e.OL();
        AppMethodBeat.o(52915);
        return OL;
    }

    public final ArrayList<SmileyInfo> bjO() {
        AppMethodBeat.i(52916);
        ArrayList bjO = j.getEmojiStorageMgr().xYv.bjO();
        AppMethodBeat.o(52916);
        return bjO;
    }

    public final ArrayList<r> bjP() {
        AppMethodBeat.i(52917);
        ArrayList bjP = j.getEmojiStorageMgr().xYw.bjP();
        AppMethodBeat.o(52917);
        return bjP;
    }

    public final boolean w(ArrayList<SmileyInfo> arrayList) {
        AppMethodBeat.i(52918);
        boolean an = j.getEmojiStorageMgr().xYv.an(arrayList);
        AppMethodBeat.o(52918);
        return an;
    }

    public final boolean x(ArrayList<r> arrayList) {
        AppMethodBeat.i(52919);
        s sVar = j.getEmojiStorageMgr().xYw;
        if (arrayList == null || arrayList.size() <= 0) {
            ab.i("MicroMsg.emoji.SmileyPanelConfigInfoStorage", "insertSmileyConfigInfoList failed. list is null.");
        } else {
            long iV;
            com.tencent.mm.cd.h hVar;
            if (sVar.bSd instanceof com.tencent.mm.cd.h) {
                com.tencent.mm.cd.h hVar2 = (com.tencent.mm.cd.h) sVar.bSd;
                iV = hVar2.iV(Thread.currentThread().getId());
                hVar = hVar2;
            } else {
                iV = -1;
                hVar = null;
            }
            sVar.bSd.delete("SmileyPanelConfigInfo", null, null);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                sVar.b((c) (r) it.next());
            }
            int i = -1;
            if (hVar != null) {
                i = hVar.mB(iV);
            }
            if (i >= 0) {
                AppMethodBeat.o(52919);
                return true;
            }
        }
        AppMethodBeat.o(52919);
        return false;
    }

    public final String dL(String str, String str2) {
        AppMethodBeat.i(52920);
        String L = EmojiLogic.L(com.tencent.mm.plugin.emoji.h.b.Yb(), str, str2);
        AppMethodBeat.o(52920);
        return L;
    }

    public final com.tencent.mm.ba.f bjQ() {
        AppMethodBeat.i(52921);
        com.tencent.mm.ba.f bjQ = j.bkb().bjQ();
        AppMethodBeat.o(52921);
        return bjQ;
    }

    public final String bjS() {
        AppMethodBeat.i(52924);
        j.bkb();
        String bjS = j.bjS();
        AppMethodBeat.o(52924);
        return bjS;
    }

    public final void bjT() {
        AppMethodBeat.i(52925);
        j.bkb();
        com.tencent.mm.g.a.bf bfVar = new com.tencent.mm.g.a.bf();
        bfVar.cus.filePath = com.tencent.mm.compatible.util.e.eSn + "CheckResUpdate/37.1.data.decompressed";
        bfVar.cus.cut = 37;
        bfVar.cus.cuu = 1;
        j.a(bfVar, j.a.EMOJI, j.kUa);
        AppMethodBeat.o(52925);
    }

    public final int d(EmojiInfo emojiInfo, boolean z) {
        AppMethodBeat.i(52926);
        Object obj = (z || !(emojiInfo == null || emojiInfo.field_activityid == null || !emojiInfo.field_activityid.startsWith("Selfie:"))) ? 1 : null;
        int Nb;
        if (obj != null) {
            Nb = com.tencent.mm.m.b.Nb();
            AppMethodBeat.o(52926);
            return Nb;
        }
        Nb = com.tencent.mm.m.b.MZ();
        AppMethodBeat.o(52926);
        return Nb;
    }

    public final cab bjU() {
        AppMethodBeat.i(52927);
        cab bjU = j.getEmojiStorageMgr().xYq.bjU();
        AppMethodBeat.o(52927);
        return bjU;
    }

    public final void a(cab cab) {
        AppMethodBeat.i(52928);
        j.getEmojiStorageMgr().xYq.b(cab);
        AppMethodBeat.o(52928);
    }

    public final int y(boolean z, boolean z2) {
        AppMethodBeat.i(52929);
        int y = j.getEmojiStorageMgr().xYn.y(z, z2);
        AppMethodBeat.o(52929);
        return y;
    }

    public final int Jp(String str) {
        AppMethodBeat.i(52930);
        int Jp = j.getEmojiStorageMgr().xYn.Jp(str);
        AppMethodBeat.o(52930);
        return Jp;
    }

    public final boolean a(EmojiGroupInfo emojiGroupInfo) {
        AppMethodBeat.i(52931);
        boolean c = j.getEmojiStorageMgr().xYo.c(emojiGroupInfo, "productID");
        AppMethodBeat.o(52931);
        return c;
    }

    public final ArrayList<EmojiGroupInfo> OD() {
        AppMethodBeat.i(52932);
        ArrayList OD = j.getEmojiStorageMgr().xYz.OD();
        AppMethodBeat.o(52932);
        return OD;
    }

    public final int bjV() {
        AppMethodBeat.i(52933);
        int bjV = j.getEmojiStorageMgr().bjV();
        AppMethodBeat.o(52933);
        return bjV;
    }

    public final ArrayList<EmojiInfo> bY(boolean z) {
        AppMethodBeat.i(52934);
        ArrayList bY = j.getEmojiStorageMgr().bY(z);
        AppMethodBeat.o(52934);
        return bY;
    }

    public final ArrayList<EmojiInfo> OC() {
        AppMethodBeat.i(52935);
        ArrayList OC = j.getEmojiStorageMgr().xYz.OC();
        AppMethodBeat.o(52935);
        return OC;
    }

    public final ArrayList<EmojiInfo> kS(String str) {
        AppMethodBeat.i(52936);
        ArrayList kS = j.getEmojiStorageMgr().xYz.kS(str);
        AppMethodBeat.o(52936);
        return kS;
    }

    public final com.tencent.mm.at.a.a bjW() {
        AppMethodBeat.i(52937);
        com.tencent.mm.at.a.a bjW = j.bjW();
        AppMethodBeat.o(52937);
        return bjW;
    }

    public final void g(k.a aVar) {
        AppMethodBeat.i(52938);
        j.getEmojiStorageMgr().xYn.d(aVar);
        AppMethodBeat.o(52938);
    }

    public final void h(k.a aVar) {
        AppMethodBeat.i(52939);
        j.getEmojiStorageMgr().xYn.c(aVar);
        AppMethodBeat.o(52939);
    }

    public final void i(k.a aVar) {
        AppMethodBeat.i(52940);
        j.getEmojiStorageMgr().xYo.d(aVar);
        AppMethodBeat.o(52940);
    }

    public final void j(k.a aVar) {
        AppMethodBeat.i(52941);
        if (((com.tencent.mm.kernel.b.h) g.RM().Rn()).SG()) {
            j.getEmojiStorageMgr().xYo.c(aVar);
        }
        AppMethodBeat.o(52941);
    }

    public final boolean bjX() {
        AppMethodBeat.i(52942);
        boolean OR = com.tencent.mm.emoji.a.e.OR();
        AppMethodBeat.o(52942);
        return OR;
    }

    public final boolean OS() {
        AppMethodBeat.i(52943);
        boolean OS = com.tencent.mm.emoji.a.e.OS();
        AppMethodBeat.o(52943);
        return OS;
    }

    public final boolean OT() {
        AppMethodBeat.i(52944);
        if (bp.dpL() || com.tencent.mm.emoji.a.e.OT()) {
            AppMethodBeat.o(52944);
            return true;
        }
        AppMethodBeat.o(52944);
        return false;
    }

    public final void bZ(String str, int i) {
        AppMethodBeat.i(52945);
        u uVar = j.getEmojiStorageMgr().xYy;
        if (!Util.isNullOrNil(str)) {
            if (uVar.ybh == null) {
                uVar.dvl();
            }
            com.tencent.mm.storage.emotion.t tVar = (com.tencent.mm.storage.emotion.t) uVar.ybh.get(str);
            if (tVar == null) {
                tVar = new com.tencent.mm.storage.emotion.t();
                tVar.key = str;
                uVar.ybh.put(str, tVar);
            }
            tVar.position = i;
            tVar.ybg++;
            tVar.eRt = System.currentTimeMillis();
            String str2 = "event_update_recent";
            if (uVar.ybh == null) {
                uVar.dvl();
            }
            uVar.b(str2, 0, Integer.valueOf(uVar.ybh.size()));
        }
        AppMethodBeat.o(52945);
    }

    public final List<com.tencent.mm.storage.emotion.t> bjY() {
        AppMethodBeat.i(52946);
        List bjY = j.getEmojiStorageMgr().xYy.bjY();
        AppMethodBeat.o(52946);
        return bjY;
    }

    public final void bjZ() {
        AppMethodBeat.i(52947);
        u uVar = j.getEmojiStorageMgr().xYy;
        List<com.tencent.mm.storage.emotion.t> bjY = uVar.bjY();
        JSONArray jSONArray = new JSONArray();
        for (com.tencent.mm.storage.emotion.t tVar : bjY) {
            if (tVar.toJson() != null) {
                jSONArray.put(tVar.toJson());
                if (jSONArray.length() >= 9) {
                    break;
                }
            }
        }
        g.RP().Ry().set(ac.a.USERINFO_RECENT_SMILEY_STRING, jSONArray.toString());
        uVar.ybh = null;
        AppMethodBeat.o(52947);
    }

    public final <T> T c(ac.a aVar, T t) {
        AppMethodBeat.i(52948);
        Object obj = g.RP().Ry().get(aVar, (Object) t);
        AppMethodBeat.o(52948);
        return obj;
    }

    public final void d(ac.a aVar, Object obj) {
        AppMethodBeat.i(52949);
        g.RP().Ry().set(aVar, obj);
        AppMethodBeat.o(52949);
    }

    public final void k(k.a aVar) {
        AppMethodBeat.i(52950);
        j.getEmojiStorageMgr().xYy.c(aVar);
        AppMethodBeat.o(52950);
    }

    /* JADX WARNING: Missing block: B:4:0x0017, code skipped:
            if (r3 <= com.tencent.mm.m.b.Nb()) goto L_0x0019;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean Jq(String str) {
        boolean z = false;
        AppMethodBeat.i(52951);
        com.tencent.mm.plugin.gif.f fVar = new com.tencent.mm.plugin.gif.f(str);
        int cs = com.tencent.mm.a.e.cs(str);
        if (cs != 0) {
            try {
            } catch (Exception e) {
                ab.e("MicroMsg.emoji.EmojiMgrImpl", bo.l(e));
            }
        }
        if (fVar.noD[0] <= com.tencent.mm.m.b.Na() && fVar.noD[1] <= com.tencent.mm.m.b.Na()) {
            z = true;
        }
        AppMethodBeat.o(52951);
        return z;
    }

    public final boolean bka() {
        boolean z;
        AppMethodBeat.i(52952);
        if (g.RP().Ry().getBoolean(ac.a.USERINFO_EMOJI_CAPTURE_TAB_RED_DOT_BOOLEAN, false)) {
            z = false;
        } else {
            z = true;
        }
        com.tencent.mm.emoji.a.e.isSpringFestivalEnable();
        if (z) {
            AppMethodBeat.o(52952);
            return true;
        }
        AppMethodBeat.o(52952);
        return false;
    }

    public final void l(k.a aVar) {
        AppMethodBeat.i(52953);
        j.getEmojiStorageMgr().xYy.d(aVar);
        AppMethodBeat.o(52953);
    }

    public final void Jr(String str) {
        AppMethodBeat.i(52954);
        if (!bo.isNullOrNil(str)) {
            ab.i("MicroMsg.emoji.EmojiMgrImpl", "deleteCaptureEmoji md: ".concat(String.valueOf(str)));
            j.getEmojiStorageMgr().xYn.aqj(str);
            j.getEmojiStorageMgr().xYn.anF("delete_emoji_info_notify");
        }
        AppMethodBeat.o(52954);
    }

    public final void a(UploadTask uploadTask) {
        AppMethodBeat.i(52955);
        if (uploadTask.lgZ == null) {
            AppMethodBeat.o(52955);
            return;
        }
        final EmojiInfo aqi = ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().xYn.aqi(uploadTask.lgZ);
        if (aqi == null) {
            AppMethodBeat.o(52955);
            return;
        }
        final EmojiCaptureReporter emojiCaptureReporter = uploadTask.lha;
        ab.d("MicroMsg.emoji.EmojiMgrImpl", "uploadCaptureEmoji emojiInfo.field_md5: " + aqi.field_md5);
        emojiCaptureReporter.lgP = System.currentTimeMillis();
        emojiCaptureReporter.ezZ = aqi.field_captureEnterTime;
        com.tencent.mm.emoji.a.d dVar = new com.tencent.mm.emoji.a.d(aqi, aqi.dvd(), aqi.field_imitateMd5, new com.tencent.mm.emoji.a.d.b() {
            public final void f(int i, String str, String str2) {
                AppMethodBeat.i(52885);
                g.RS().aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(52884);
                        a.bjF().bjG();
                        AppMethodBeat.o(52884);
                    }
                });
                ab.d("MicroMsg.emoji.EmojiMgrImpl", "uploadCaptureEmoji errorCode: " + i + " gifMd5: " + str + " activityId: " + str2);
                if (i != 0) {
                    aqi.a(EmojiInfo.a.STATUS_UPLOAD_FAIL);
                }
                switch (i) {
                    case 0:
                        emojiCaptureReporter.lgQ = System.currentTimeMillis();
                        EmojiCaptureReporter.d(emojiCaptureReporter.ezZ, emojiCaptureReporter.lgQ - emojiCaptureReporter.lgP, aqi.field_captureScene);
                        aqi.a(EmojiInfo.a.STATUS_SUCCESS);
                        aqi.a(EmojiInfo.b.ERR_SUCCESS);
                        com.tencent.mm.plugin.report.service.h.pYm.e(10431, Integer.valueOf(7), aqi.Aq(), aqi.field_designerID, aqi.field_groupId, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(aqi.field_size), com.tencent.mm.model.r.Yz(), aqi.field_activityid);
                        break;
                    case 2:
                        EmojiCaptureReporter.g(emojiCaptureReporter.ezZ, 2, aqi.field_captureScene);
                        aqi.a(EmojiInfo.b.ERR_OVER_SIZE);
                        break;
                    case 3:
                        EmojiCaptureReporter.g(emojiCaptureReporter.ezZ, 1, aqi.field_captureScene);
                        aqi.a(EmojiInfo.b.ERR_OVER_LIMIT);
                        break;
                    case 4:
                        EmojiCaptureReporter.g(emojiCaptureReporter.ezZ, 5, aqi.field_captureScene);
                        aqi.a(EmojiInfo.b.ERR_NOT_COMPLETED);
                        break;
                    case 5:
                        EmojiCaptureReporter.g(emojiCaptureReporter.ezZ, 7, aqi.field_captureScene);
                        aqi.a(EmojiInfo.b.ERR_NON_NETWORK);
                        break;
                    case 6:
                        EmojiCaptureReporter.g(emojiCaptureReporter.ezZ, 8, aqi.field_captureScene);
                        aqi.a(EmojiInfo.b.ERR_WIFI_NETWORK);
                        break;
                    case 7:
                        EmojiCaptureReporter.g(emojiCaptureReporter.ezZ, 9, aqi.field_captureScene);
                        aqi.a(EmojiInfo.b.ERR_MOBILE_NETWORK);
                        break;
                    case 8:
                        EmojiCaptureReporter.g(emojiCaptureReporter.ezZ, 6, aqi.field_captureScene);
                        aqi.a(EmojiInfo.b.ERR_SPAM);
                        break;
                    case 9:
                        EmojiCaptureReporter.g(emojiCaptureReporter.ezZ, 10, aqi.field_captureScene);
                        aqi.a(EmojiInfo.b.ERR_OVER_UPLOAD_TIME);
                        break;
                    case 10:
                        EmojiCaptureReporter.g(emojiCaptureReporter.ezZ, 4, aqi.field_captureScene);
                        aqi.a(EmojiInfo.b.ERR_LOCAL_FILE);
                        break;
                    default:
                        EmojiCaptureReporter.g(emojiCaptureReporter.ezZ, 3, aqi.field_captureScene);
                        aqi.a(EmojiInfo.b.ERR_OTHERS);
                        break;
                }
                ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().xYn.G(aqi);
                AppMethodBeat.o(52885);
            }
        });
        AppMethodBeat.o(52955);
    }

    public final void q(EmojiInfo emojiInfo) {
        AppMethodBeat.i(52956);
        emojiInfo.field_groupId = "capture";
        ArrayList arrayList = new ArrayList();
        arrayList.add(emojiInfo.Aq());
        ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().xYn.l(1, arrayList);
        ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().xYn.G(emojiInfo);
        cz czVar = new cz();
        czVar.cwc.type = 2;
        a.xxA.m(czVar);
        if (!czVar.cwd.cwe) {
            cab bjU = ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().xYq.bjU();
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
            ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().xYq.b(bjU);
            com.tencent.mm.by.a.dmE();
            com.tencent.mm.by.a.b bVar = com.tencent.mm.by.a.xum;
            com.tencent.mm.by.a.b.alW(String.valueOf("capture"));
        }
        AppMethodBeat.o(52956);
    }

    public final void r(final EmojiInfo emojiInfo) {
        AppMethodBeat.i(52957);
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(52887);
                Context context = ah.getContext();
                com.tencent.mm.ui.widget.a.e.a aVar = new com.tencent.mm.ui.widget.a.e.a(context);
                aVar.asL(context.getString(R.string.b9b)).Qg(R.string.bd3).Qh(context.getResources().getColor(R.color.y0));
                aVar.c(new com.tencent.mm.ui.widget.a.e.c() {
                    public final void d(boolean z, String str) {
                        AppMethodBeat.i(52886);
                        if (z && !bo.isNullOrNil(emojiInfo.Aq())) {
                            ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().Jr(emojiInfo.Aq());
                        }
                        AppMethodBeat.o(52886);
                    }
                }).show();
                AppMethodBeat.o(52887);
            }
        });
        AppMethodBeat.o(52957);
    }

    public final EmojiInfo n(EmojiInfo emojiInfo) {
        AppMethodBeat.i(52890);
        if (emojiInfo.field_catalog == EmojiGroupInfo.yas && emojiInfo.field_type == EmojiInfo.zYR && emojiInfo.getContent().length() > 0 && EmojiInfo.Mw(bo.getInt(emojiInfo.getContent(), 0))) {
            Cursor MB = j.getEmojiStorageMgr().xYn.MB(bo.getInt(emojiInfo.getContent(), 0));
            if (MB != null && MB.getCount() > 1) {
                int gV = bo.gV(MB.getCount() - 1, 0);
                emojiInfo = new EmojiInfo();
                MB.moveToPosition(gV);
                emojiInfo.d(MB);
            }
            if (MB != null) {
                MB.close();
            }
        }
        AppMethodBeat.o(52890);
        return emojiInfo;
    }

    public final boolean a(Context context, EmojiInfo emojiInfo, int i, String str) {
        AppMethodBeat.i(52891);
        if (context == null) {
            ab.e("MicroMsg.emoji.EmojiMgrImpl", "[cpan] save emoji failed. context is null");
            AppMethodBeat.o(52891);
            return false;
        } else if (emojiInfo == null) {
            ab.e("MicroMsg.emoji.EmojiMgrImpl", "[cpan] save emoji failed. emoji is null");
            AppMethodBeat.o(52891);
            return false;
        } else {
            Intent intent = new Intent();
            intent.setClass(context, EmojiAddCustomDialogUI.class);
            intent.putExtra("extra_id", emojiInfo.Aq());
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
            AppMethodBeat.o(52891);
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0231  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Jo(String str) {
        ArrayList arrayList;
        EmojiInfo emojiInfo;
        com.tencent.mm.g.a.bf bfVar;
        AppMethodBeat.i(52922);
        if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.emoji.EmojiCommandMgr", "emoji command is null.");
        }
        if ("sync".equalsIgnoreCase(str)) {
            g.RP().Ry().set(ac.a.USERINFO_EMOJI_RECOVER_CUSTOM_EMOJI_BOOLEAN, Boolean.TRUE);
            g.RP().Ry().set(ac.a.USERINFO_EMOJI_SYNC_CUSTOM_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE);
            g.RP().Ry().set(ac.a.USERINFO_EMOJI_SYNC_CAPTURE_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE);
            g.RP().Ry().set(ac.a.USERINFO_EMOJI_NEXT_CUSTOM_BATCH_DOWNLOAD_TIME_LONG, Long.valueOf(System.currentTimeMillis()));
            g.RP().Ry().set(ac.a.USERINFO_EMOJI_NEXT_CAPTURE_BATCH_DOWNLOAD_TIME_LONG, Long.valueOf(System.currentTimeMillis()));
            g.RP().Ry().set(ac.a.USERINFO_EMOJI_SYNC_STORE_EMOJI_DOWNLOAD_LONG, Long.valueOf(0));
            g.RO().eJo.a(new com.tencent.mm.plugin.emoji.f.e(0), 0);
            g.RO().eJo.a(new com.tencent.mm.plugin.emoji.f.e(1), 0);
            g.RO().eJo.a(new n(8, null, 15, true), 0);
        } else if ("rcheart".equalsIgnoreCase(str)) {
            j.getEmojiStorageMgr().xYo.duN();
        } else if ("recover".equalsIgnoreCase(str)) {
            ab.i("MicroMsg.emoji.EmojiCommandMgr", "recover   begin");
            j.getEmojiStorageMgr().xYn.hi(ah.getContext());
            j.getEmojiStorageMgr().xYo.hi(ah.getContext());
            ab.i("MicroMsg.emoji.EmojiCommandMgr", "recover   end");
        } else if ("clean".equalsIgnoreCase(str)) {
            ab.i("MicroMsg.emoji.EmojiCommandMgr", "begin clean");
            e.bjJ().Jc(com.tencent.mm.plugin.emoji.h.b.Yb());
            g.RP().Ry().set(ac.a.USERINFO_EMOJI_SYNC_CUSTOM_EMOJI_BATCH_DOWNLOAD_BOOLEAN, Boolean.TRUE);
            ab.i("MicroMsg.emoji.EmojiCommandMgr", "end clean");
        } else if ("dump".equalsIgnoreCase(str)) {
            ab.i("MicroMsg.emoji.EmojiCommandMgr", "begin dump emoji db info:");
            arrayList = (ArrayList) j.getEmojiStorageMgr().xYo.duz();
            if (arrayList.size() > 0) {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    EmojiGroupInfo emojiGroupInfo = (EmojiGroupInfo) arrayList.get(i);
                    ab.i("MicroMsg.emoji.EmojiCommandMgr", "i:%d group info:%s", Integer.valueOf(i), emojiGroupInfo.toString());
                }
            }
            Cursor cursor = null;
            try {
                cursor = j.getEmojiStorageMgr().xYn.baR();
                if (cursor == null || !cursor.moveToFirst()) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    ab.i("MicroMsg.emoji.EmojiCommandMgr", "end dump emoji db info:");
                } else {
                    do {
                        new EmojiInfo().d(cursor);
                        ab.i("MicroMsg.emoji.EmojiCommandMgr", "emoji info:%s", emojiInfo.toString());
                    } while (cursor.moveToNext());
                    if (cursor != null) {
                    }
                    ab.i("MicroMsg.emoji.EmojiCommandMgr", "end dump emoji db info:");
                }
            } catch (Exception e) {
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.o(52922);
            }
        } else if ("config".equalsIgnoreCase(str)) {
            com.tencent.mm.pluginsdk.g.a.a.b.c.veg.f(37, 1, -1, false);
            com.tencent.mm.pluginsdk.g.a.a.b.c.veg.f(37, 2, -1, false);
            com.tencent.mm.pluginsdk.g.a.a.b.c.veg.f(37, 4, -1, false);
            g.RP().Ry().set(ac.a.USERINFO_EMOJI_NEW_EMOJI_INT, Integer.valueOf(0));
            g.RP().Ry().set(ac.a.USERINFO_EMOJI_NEW_PANEL_INT, Integer.valueOf(0));
            g.RP().Ry().set(ac.a.USERINFO_EMOJI_EGG_INT, Integer.valueOf(0));
            g.RO().eJo.a(new m(37), 0);
            bfVar = new com.tencent.mm.g.a.bf();
            bfVar.cus.filePath = com.tencent.mm.compatible.util.e.eSn + "CheckResUpdate/37.1.data.decompressed";
            bfVar.cus.cut = 37;
            bfVar.cus.cuu = 1;
            com.tencent.mm.g.a.bf bfVar2 = new com.tencent.mm.g.a.bf();
            bfVar2.cus.filePath = com.tencent.mm.compatible.util.e.eSn + "CheckResUpdate/37.2.data.decompressed";
            bfVar2.cus.cut = 37;
            bfVar2.cus.cuu = 2;
            j.bkb();
            j.a(bfVar, true);
            j.bkb();
            j.b(bfVar2, true);
            e.deleteFile(com.tencent.mm.cb.b.xFA);
        } else if ("tuzki".equalsIgnoreCase(str)) {
            com.tencent.mm.plugin.emoji.f.a.bkq();
            com.tencent.mm.plugin.emoji.f.a.bkr();
        } else {
            if (str.startsWith("reset-first")) {
                g.RP().Ry().set(ac.a.USERINFO_EMOJI_CAPTURE_OPENED_BOOLEAN, Boolean.FALSE);
                g.RP().Ry().set(ac.a.USERINFO_EMOJI_CAPTURE_IMITATE_SAVED_BOOLEAN, Boolean.FALSE);
                g.RP().Ry().set(ac.a.USERINFO_EMOJI_CAPTURE_OUTER_EMOJI_BUTTON_RED_DOT_BOOLEAN, Boolean.FALSE);
                g.RP().Ry().set(ac.a.USERINFO_EMOJI_CAPTURE_TAB_RED_DOT_BOOLEAN, Boolean.FALSE);
            }
        }
        if (bp.dpL()) {
            if ("new".equalsIgnoreCase(str)) {
                com.tencent.mm.x.c.PK().x(262147, true);
                g.RP().Ry().set(208899, Boolean.TRUE);
                g.RP().Ry().set(229633, (Object) "http://mmbiz.qpic.cn/mmemoticon/Q3auHgzwzM5eOptD4jIj72I8icMVEKwzSYkC30IgjMvSibGfqsEdy0ibXayiaZtbibSXV5EPZEWILOvbrjjLtQ9P4QQ/0");
                g.RP().Ry().set(229634, System.currentTimeMillis());
                AppMethodBeat.o(52922);
                return;
            } else if ("free".equalsIgnoreCase(str)) {
                com.tencent.mm.x.c.PK().x(262149, true);
                g.RP().Ry().set(208913, Boolean.TRUE);
                g.RP().Ry().set(229633, (Object) "http://mmbiz.qpic.cn/mmemoticon/Q3auHgzwzM5eOptD4jIj72I8icMVEKwzSYkC30IgjMvSibGfqsEdy0ibXayiaZtbibSXV5EPZEWILOvbrjjLtQ9P4QQ/0");
                g.RP().Ry().set(229634, System.currentTimeMillis());
                AppMethodBeat.o(52922);
                return;
            } else if ("newp".equalsIgnoreCase(str)) {
                g.RP().Ry().set(ac.a.USERINFO_EMOJI_STORE_NEW_ORIGINAL_BOOLEAN, Boolean.TRUE);
                AppMethodBeat.o(52922);
                return;
            } else if ("newpe".equalsIgnoreCase(str)) {
                g.RP().Ry().set(ac.a.USERINFO_EMOJI_STORE_NEW_DESIGNER_EMOJI_BOOLEAN, Boolean.TRUE);
                AppMethodBeat.o(52922);
                return;
            } else {
                if (str.startsWith("add")) {
                    b.Ja(str);
                    AppMethodBeat.o(52922);
                    return;
                }
                if (str.startsWith("backup")) {
                    g.RO().eJo.a(new com.tencent.mm.plugin.emoji.f.c(0, 1, Arrays.asList(str.replace("backup", "").trim().split(","))), 0);
                    AppMethodBeat.o(52922);
                    return;
                }
                if (str.startsWith("h5")) {
                    PreferenceManager.getDefaultSharedPreferences(ah.getContext()).edit().putString("h5", str.replace("h5", "").trim()).commit();
                    AppMethodBeat.o(52922);
                    return;
                }
                String trim;
                if (str.startsWith("md5")) {
                    trim = str.replace("md5", "").trim();
                    if (bo.isNullOrNil(trim)) {
                        trim = "/sdcard/test.png";
                    }
                    ab.i("MicroMsg.emoji.EmojiCommandMgr", com.tencent.mm.a.g.v(new File(trim)));
                    ab.i("MicroMsg.emoji.EmojiCommandMgr", ag.ck(trim));
                    AppMethodBeat.o(52922);
                    return;
                }
                if (str.startsWith("recommend")) {
                    arrayList = com.tencent.mm.plugin.emoji.g.d.JG("<NewRecommendEmotion><Emotion><ProductID>com.tencent.xin.emoticon.person.stiker_144984189945aa5830d33cd7dc</ProductID><RecType>3</RecType><Name>野萌君</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/duc2TvpEgSTWy4k8MnuicFjyiazriaGWDX52HzNWeLVTjtJcjZeZEicTn5kJFPYdicWZTuUZJgiaADK9I/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/DhduwiaBa7lchicgAfwibeykm81eGWXkMDgGJ8DWcOcIc28C7oTic4Y09Pick8Fw69KiaZVxrHl8S2lPY/0</Panel><ButtonType>1</ButtonType></Emotion><Emotion><ProductID>com.tencent.xin.emoticon.person.stiker_14389422638f6ca818af405e21</ProductID><RecType>3</RecType><Name>猪仔和羊妹</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/iaUiazNVkRp7iaZjrMuYgfH8kB5xkyYv20CYzY3W9HCLBr2XybJibGKKtXibMnAfZnRTH/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/PiajxSqBRaEJR9canNKZ7RYI3hx5BPCSwQmuhhlNWD1jzUSOx3CWqEtibd65zOjySd/0</Panel><ButtonType>1</ButtonType></Emotion><Emotion><ProductID>com.tencent.xin.emoticon.person.stiker_1444199720f5ea147582ff0512</ProductID><RecType>3</RecType><Name>让红包飞</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/nMl9ssowtibXLY57PdK8Nsh827vlsw4TGHPgLUehd2R455xnwe3xpoVDIKpAuXU1Aic3XbH1LfMr7fp4DgO7o8IQ/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/duc2TvpEgST18reErFRzNFR8EiahI4Iibp4ZnW1ibJYt4MMLvQvjx3sHGTMuTOgnREq5f2GXLhuzalOOz3icw9NGbA/0</Panel><ButtonType>1</ButtonType></Emotion><Emotion><ProductID>com.tencent.xin.emoticon.xiaobendan</ProductID><RecType>3</RecType><Name>小笨蛋与大坏蛋</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/ajNVdqHZLLC8ILTt0pqcaCVkldLMydoNJcupoR7qUojia3vKlgd74uQ/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/ajNVdqHZLLC8ILTt0pqcaAAEUI4a7z5ECqpUXbQw95PY1mpc4p0FxA/0</Panel><ButtonType>1</ButtonType></Emotion><Emotion><ProductID>com.tencent.xin.emoticon.shin2</ProductID><RecType>3</RecType><Name>野原新之助2</Name><Icon>http://mmbiz.qpic.cn/mmemoticon/iciaySdkria4apGIW1wvSbPC9oxWQPHZyicaccx5JDIp2uE/0</Icon><Panel>http://mmbiz.qpic.cn/mmemoticon/ajNVdqHZLLASEAAX7xw76beia5j4HyA0rq9WgtgscicJo7935UCpCpog/0</Panel><ButtonType>1</ButtonType></Emotion></NewRecommendEmotion>");
                    j.getEmojiStorageMgr().xYo.duF();
                    j.getEmojiStorageMgr().xYo.ak(arrayList);
                    AppMethodBeat.o(52922);
                    return;
                }
                if (str.startsWith("count")) {
                    com.tencent.mm.m.g.Nu().put("CustomEmojiMaxSize", str.replace("count", "").trim());
                    AppMethodBeat.o(52922);
                    return;
                }
                if (str.startsWith("auto")) {
                    com.tencent.mm.m.g.Nu().put("C2CEmojiNotAutoDownloadTimeRange", str.replace("auto", "").trim());
                    AppMethodBeat.o(52922);
                    return;
                }
                if (str.startsWith("bo")) {
                    if (str.replace("bo", "").trim().equalsIgnoreCase("1")) {
                        PreferenceManager.getDefaultSharedPreferences(ah.getContext()).edit().putBoolean("broken", true).commit();
                        AppMethodBeat.o(52922);
                        return;
                    }
                    PreferenceManager.getDefaultSharedPreferences(ah.getContext()).edit().putBoolean("broken", false).commit();
                    AppMethodBeat.o(52922);
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
                    j.getEmojiStorageMgr().xYv.an(arrayList2);
                    AppMethodBeat.o(52922);
                    return;
                }
                if (str.startsWith("panel")) {
                    str.replace("panel", "").trim();
                    bfVar = new com.tencent.mm.g.a.bf();
                    bfVar.cus.cuu = 1;
                    bfVar.cus.cut = 37;
                    bfVar.cus.filePath = com.tencent.mm.compatible.util.e.eSn + "CheckResUpdate/37.1.data";
                    a.xxA.m(bfVar);
                    bfVar = new com.tencent.mm.g.a.bf();
                    bfVar.cus.cuu = 2;
                    bfVar.cus.cut = 37;
                    bfVar.cus.filePath = "/sdcard/tencent/MicroMsg/CheckResUpdate/37.2.data";
                    a.xxA.m(bfVar);
                    bfVar = new com.tencent.mm.g.a.bf();
                    bfVar.cus.cuu = 3;
                    bfVar.cus.cut = 37;
                    bfVar.cus.filePath = com.tencent.mm.compatible.util.e.eSn + "CheckResUpdate/37.3.data";
                    a.xxA.m(bfVar);
                    AppMethodBeat.o(52922);
                    return;
                }
                if (str.startsWith("key")) {
                    trim = com.tencent.mm.a.g.x(String.valueOf(System.currentTimeMillis()).getBytes());
                    ab.i("MicroMsg.emoji.EmojiCommandMgr", "create key :%s" + bo.anv(trim));
                    j.getEmojiStorageMgr().xYn.MC(XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION);
                    emojiInfo = new EmojiInfo();
                    emojiInfo.field_md5 = trim;
                    emojiInfo.field_catalog = XWalkEnvironment.SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION;
                    j.getEmojiStorageMgr().xYn.F(emojiInfo);
                    AppMethodBeat.o(52922);
                    return;
                }
                if (str.startsWith("delete")) {
                    b.IZ(str);
                    AppMethodBeat.o(52922);
                    return;
                }
                if (str.startsWith("delete-db")) {
                    j.getEmojiStorageMgr().xYn.aqj(str.replace("delete-db", "").trim());
                    AppMethodBeat.o(52922);
                    return;
                }
                if (str.startsWith("delete-file")) {
                    b.IY(str);
                    AppMethodBeat.o(52922);
                    return;
                }
                String[] split;
                if (str.startsWith("batchDownload")) {
                    split = str.split(" ");
                    if (split.length > 1) {
                        g.RO().eJo.a(new com.tencent.mm.plugin.emoji.f.e(bo.ank(split[1])), 0);
                    }
                    AppMethodBeat.o(52922);
                    return;
                }
                if (str.startsWith("getInfo")) {
                    split = str.split(" ");
                    if (split.length > 1) {
                        LinkedList linkedList = new LinkedList();
                        linkedList.add(split[1]);
                        g.RO().eJo.a(new com.tencent.mm.plugin.emoji.f.e(linkedList), 0);
                    }
                    AppMethodBeat.o(52922);
                    return;
                }
                if (str.startsWith("test")) {
                    ab.i("MicroMsg.emoji.EmojiCommandMgr", "theTest: %s", str);
                    com.tencent.mm.sdk.g.d.xDG.execute(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(52822);
                            ArrayList<EmojiInfo> bZ = com.tencent.mm.emoji.a.a.OB().bZ(true);
                            bZ.addAll(at.dsZ().xYn.dvj());
                            for (EmojiInfo emojiInfo : bZ) {
                                long currentTimeMillis = System.currentTimeMillis();
                                byte[] l = f.bjK().l(emojiInfo);
                                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                try {
                                    if (com.tencent.mm.sdk.platformtools.r.bU(l)) {
                                        h hVar = new h(l);
                                    } else {
                                        com.tencent.mm.plugin.gif.d dVar = new com.tencent.mm.plugin.gif.d(l);
                                    }
                                } catch (Exception e) {
                                }
                                currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                                ab.i("MicroMsg.emoji.EmojiCommandMgr", "run: %s, %s", Long.valueOf(currentTimeMillis2), Long.valueOf(currentTimeMillis - currentTimeMillis2));
                            }
                            for (EmojiInfo emojiInfo2 : bZ) {
                                long currentTimeMillis3 = System.currentTimeMillis();
                                e.asZ(emojiInfo2.dve());
                                com.tencent.mm.emoji.decode.b decoder = MMGIFJNIFactory.Companion.getDecoder(emojiInfo2);
                                decoder.Or();
                                decoder.destroy();
                                ab.i("MicroMsg.emoji.EmojiCommandMgr", "run: time is %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                                e.tf("/sdcard/temp/emoji/");
                                currentTimeMillis3 = System.currentTimeMillis();
                                BitmapFactory.decodeFile("/sdcard/temp/emoji/" + emojiInfo2.field_md5 + FileUtils.PIC_POSTFIX_JPEG);
                                ab.i("MicroMsg.emoji.EmojiCommandMgr", "run: file time is %s", Long.valueOf(System.currentTimeMillis() - currentTimeMillis3));
                            }
                            AppMethodBeat.o(52822);
                        }
                    });
                }
            }
        }
        AppMethodBeat.o(52922);
    }

    public final boolean bjR() {
        AppMethodBeat.i(52923);
        if (bp.dpL() || com.tencent.mm.emoji.a.e.OU()) {
            AppMethodBeat.o(52923);
            return true;
        }
        AppMethodBeat.o(52923);
        return false;
    }

    public final void b(UploadTask uploadTask) {
        AppMethodBeat.i(52958);
        EmojiInfo Jd = Jd(uploadTask.lgZ);
        if (Jd != null) {
            com.tencent.mm.emoji.d.d dVar = com.tencent.mm.emoji.d.d.eAh;
            com.tencent.mm.emoji.d.d.k(Jd);
            AppMethodBeat.o(52958);
            return;
        }
        ab.w("MicroMsg.emoji.EmojiMgrImpl", "addCaptureEmojiUploadTask: emojiInfo null by md5 %s", uploadTask.lgZ);
        AppMethodBeat.o(52958);
    }
}
