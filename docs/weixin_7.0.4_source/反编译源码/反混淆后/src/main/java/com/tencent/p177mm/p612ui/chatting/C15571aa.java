package com.tencent.p177mm.p612ui.chatting;

import android.app.Activity;
import android.os.Looper;
import android.os.Message;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1829bf;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p211cb.C26005f;
import com.tencent.p177mm.p211cb.C26005f.C26004a;
import com.tencent.p177mm.p211cb.C9212g;
import com.tencent.p177mm.p707ba.C45180d;
import com.tencent.p177mm.p707ba.C6336e;
import com.tencent.p177mm.p707ba.C6337f;
import com.tencent.p177mm.p707ba.C6338h;
import com.tencent.p177mm.p707ba.C9066g;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C44796m;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.ui.chatting.aa */
public final class C15571aa {
    public List<C7620bi> kbM;
    public C7306ak mHandler = new C7306ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(30916);
            if (C15571aa.this.kbM == null || !C9638aw.m17179RK()) {
                AppMethodBeat.m2505o(30916);
                return;
            }
            C4990ab.m7410d("MicroMsg.EggMgr", "post start egg");
            C15571aa.this.mo27747a(C15571aa.this.yLz, C15571aa.this.kbM);
            AppMethodBeat.m2505o(30916);
        }
    };
    public ChattingAnimFrame yLy = null;
    public Activity yLz;

    /* renamed from: com.tencent.mm.ui.chatting.aa$2 */
    class C155722 implements Runnable {
        C155722() {
        }

        public final void run() {
            AppMethodBeat.m2504i(30917);
            if (C9638aw.m17179RK()) {
                C9638aw.m17182Rg().mo14541a(new C44796m(37), 0);
                C9638aw.m17190ZK();
                C18628c.m29072Ry().set(68108, Long.valueOf(C42252ah.anT()));
                AppMethodBeat.m2505o(30917);
                return;
            }
            AppMethodBeat.m2505o(30917);
        }
    }

    public C15571aa() {
        AppMethodBeat.m2504i(30918);
        AppMethodBeat.m2505o(30918);
    }

    /* renamed from: a */
    public final void mo27747a(Activity activity, List<C7620bi> list) {
        AppMethodBeat.m2504i(30919);
        if (list == null) {
            AppMethodBeat.m2505o(30919);
            return;
        }
        for (C7620bi a : list) {
            if (m23872a(activity, a)) {
                AppMethodBeat.m2505o(30919);
                return;
            }
        }
        AppMethodBeat.m2505o(30919);
    }

    /* renamed from: a */
    private boolean m23872a(Activity activity, C7620bi c7620bi) {
        AppMethodBeat.m2504i(30920);
        dCH();
        C6337f bjQ = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().bjQ();
        if (bjQ == null) {
            C4990ab.m7410d("MicroMsg.EggMgr", "eggList is null");
            AppMethodBeat.m2505o(30920);
            return false;
        }
        int anT = (int) C5046bo.anT();
        C4990ab.m7411d("MicroMsg.EggMgr", "cursecond is %d, getEggList.size is %d", Integer.valueOf(anT), Integer.valueOf(bjQ.fMi.size()));
        Iterator it = bjQ.fMi.iterator();
        while (it.hasNext()) {
            C45180d c45180d = (C45180d) it.next();
            if (C15571aa.are(c45180d.fMc)) {
                Iterator it2 = c45180d.fLY.iterator();
                while (it2.hasNext()) {
                    C6336e c6336e = (C6336e) it2.next();
                    String str = c6336e.fMh;
                    if (C42252ah.isNullOrNil(str)) {
                        C4990ab.m7412e("MicroMsg.EggMgr", "error egg keyWord");
                    } else {
                        String str2 = c7620bi.field_content;
                        if (C1855t.m3896kH(c7620bi.field_talker)) {
                            str2 = C1829bf.m3760ow(str2);
                        }
                        if (C15571aa.m23874aF(str2, str, c6336e.lang)) {
                            if (this.yLy == null) {
                                ViewStub viewStub = (ViewStub) activity.findViewById(2131822381);
                                if (viewStub != null) {
                                    viewStub.inflate();
                                }
                                this.yLy = (ChattingAnimFrame) activity.findViewById(2131822727);
                            }
                            if (this.yLy == null) {
                                C4990ab.m7412e("MicroMsg.EggMgr", "AnimFrameView should not be null");
                            } else if (c45180d.fMa <= anT && ((long) anT) <= ((long) c45180d.fMb) + TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) {
                                this.yLy.mo64215a(c45180d);
                                C15571aa.m23873aE(c45180d.cKB, c7620bi.field_isSend == 1);
                                C4990ab.m7411d("MicroMsg.EggMgr", "match keyWord[%s], time[%d - %d]", str, Integer.valueOf(c45180d.fMa), Integer.valueOf(c45180d.fMb));
                                AppMethodBeat.m2505o(30920);
                                return true;
                            } else if (c45180d.fMa == c45180d.fMb && c45180d.fMa == 0) {
                                this.yLy.mo64215a(c45180d);
                                C15571aa.m23873aE(c45180d.cKB, c7620bi.field_isSend == 1);
                                C4990ab.m7411d("MicroMsg.EggMgr", "match keyWord[%s], time[0 - 0]", str);
                                AppMethodBeat.m2505o(30920);
                                return true;
                            } else {
                                C4990ab.m7411d("MicroMsg.EggMgr", "match keyWord[%s], but not match time[%d - %d]", str, Integer.valueOf(c45180d.fMa), Integer.valueOf(c45180d.fMb));
                                AppMethodBeat.m2505o(30920);
                                return false;
                            }
                        }
                        continue;
                    }
                }
                continue;
            }
        }
        C4990ab.m7410d("MicroMsg.EggMgr", "no match");
        AppMethodBeat.m2505o(30920);
        return false;
    }

    private static boolean are(String str) {
        boolean z = true;
        AppMethodBeat.m2504i(30921);
        if (!C42252ah.isNullOrNil(str)) {
            for (String equals : str.split(",")) {
                if (equals.equals(C4988aa.dor())) {
                    break;
                }
            }
            z = false;
        }
        AppMethodBeat.m2505o(30921);
        return z;
    }

    /* renamed from: aF */
    private static boolean m23874aF(String str, String str2, String str3) {
        AppMethodBeat.m2504i(30922);
        if (C42252ah.isNullOrNil(str) || C42252ah.isNullOrNil(str2) || C4996ah.getContext() == null) {
            AppMethodBeat.m2505o(30922);
            return false;
        }
        String toLowerCase = str.toLowerCase();
        int indexOf = toLowerCase.indexOf(str2.toLowerCase());
        if (indexOf == -1) {
            AppMethodBeat.m2505o(30922);
            return false;
        }
        do {
            int i = indexOf;
            try {
                boolean z;
                if (i >= toLowerCase.length() - 1 || C42252ah.isNullOrNil(str3)) {
                    z = true;
                } else {
                    if (i > 0 && toLowerCase.charAt(i - 1) >= 'a' && toLowerCase.charAt(i - 1) <= 'z') {
                        C4990ab.m7418v("MicroMsg.EggMgr", "letter in the prefix");
                        String substring = str.substring(0, i);
                        indexOf = substring.lastIndexOf(47);
                        if (indexOf != -1) {
                            substring = substring.subSequence(indexOf, substring.length());
                            C9212g.dqQ();
                            C4996ah.getContext();
                            C26004a anW = C26005f.dqL().anW(substring);
                            if (anW != null) {
                                substring = anW.text;
                            } else {
                                substring = null;
                            }
                            if (!C42252ah.isNullOrNil(substring) && substring.length() + indexOf == i) {
                                C4990ab.m7418v("MicroMsg.EggMgr", "letter in the prefix is smiley");
                                indexOf = -2;
                            }
                        }
                        if (indexOf != -2) {
                            z = false;
                            if (z && str2.length() + i < toLowerCase.length() && toLowerCase.charAt(str2.length() + i) >= 'a' && toLowerCase.charAt(str2.length() + i) <= 'z') {
                                C4990ab.m7418v("MicroMsg.EggMgr", "letter in the suffix");
                                z = false;
                            }
                        }
                    }
                    z = true;
                    C4990ab.m7418v("MicroMsg.EggMgr", "letter in the suffix");
                    z = false;
                }
                if (z) {
                    C4990ab.m7419v("MicroMsg.EggMgr", "full match, matchPos = %s, TextLength = %s, keyLength = %s", Integer.valueOf(i), Integer.valueOf(toLowerCase.length()), Integer.valueOf(str2.length()));
                    AppMethodBeat.m2505o(30922);
                    return z;
                }
                indexOf = toLowerCase.indexOf(str2.toLowerCase(), i + 1);
            } catch (Exception e) {
                C4990ab.m7419v("MicroMsg.EggMgr", "Exception in isKeywordMatch, %s", e.getMessage());
                C4990ab.printErrStackTrace("MicroMsg.EggMgr", e, "", new Object[0]);
            }
        } while (indexOf != -1);
        AppMethodBeat.m2505o(30922);
        return false;
    }

    private void dCH() {
        AppMethodBeat.m2504i(30923);
        C9638aw.m17190ZK();
        if (C42252ah.m74621fp(C42252ah.m74617d((Long) C18628c.m29072Ry().get(68108, null))) * 1000 > 21600000) {
            new C7306ak().postDelayed(new C155722(), 10000);
        }
        AppMethodBeat.m2505o(30923);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0060 A:{Catch:{ Exception -> 0x00c2 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: aE */
    private static void m23873aE(int i, boolean z) {
        AppMethodBeat.m2504i(30924);
        try {
            C6338h c6338h;
            int i2;
            StringBuilder stringBuilder;
            StringBuilder stringBuilder2 = new StringBuilder();
            C9638aw.m17190ZK();
            byte[] e = C5730e.m8632e(stringBuilder2.append(C18628c.m29068Rt()).append("eggresult.rep").toString(), 0, -1);
            if (e != null) {
                C4990ab.m7410d("MicroMsg.EggMgr", "data not null, parse it");
                c6338h = (C6338h) new C6338h().parseFrom(e);
            } else {
                C4990ab.m7410d("MicroMsg.EggMgr", "data is null, new one");
                c6338h = new C6338h();
            }
            Iterator it = c6338h.fMm.iterator();
            while (it.hasNext()) {
                C9066g c9066g = (C9066g) it.next();
                if (c9066g.cKB == i) {
                    if (z) {
                        c9066g.fMk++;
                    } else {
                        c9066g.fMl++;
                    }
                    i2 = 1;
                    if (i2 == 0) {
                        c9066g = new C9066g();
                        c9066g.cKB = i;
                        if (z) {
                            c9066g.fMk = 1;
                        } else {
                            c9066g.fMl = 1;
                        }
                        c6338h.fMm.add(c9066g);
                    }
                    e = c6338h.toByteArray();
                    C4990ab.m7411d("MicroMsg.EggMgr", "report list is %s, then save it", c6338h.toString());
                    stringBuilder = new StringBuilder();
                    C9638aw.m17190ZK();
                    C5730e.m8624b(stringBuilder.append(C18628c.m29068Rt()).append("eggresult.rep").toString(), e, e.length);
                    AppMethodBeat.m2505o(30924);
                }
            }
            i2 = 0;
            if (i2 == 0) {
            }
            e = c6338h.toByteArray();
            C4990ab.m7411d("MicroMsg.EggMgr", "report list is %s, then save it", c6338h.toString());
            stringBuilder = new StringBuilder();
            C9638aw.m17190ZK();
            C5730e.m8624b(stringBuilder.append(C18628c.m29068Rt()).append("eggresult.rep").toString(), e, e.length);
            AppMethodBeat.m2505o(30924);
        } catch (Exception e2) {
            C4990ab.m7421w("MicroMsg.EggMgr", "statistics crash : %s", e2.getLocalizedMessage());
            C4990ab.printErrStackTrace("MicroMsg.EggMgr", e2, "", new Object[0]);
            AppMethodBeat.m2505o(30924);
        }
    }
}
