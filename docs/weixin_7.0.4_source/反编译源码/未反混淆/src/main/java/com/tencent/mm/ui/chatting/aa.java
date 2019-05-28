package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.os.Looper;
import android.os.Message;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ba.e;
import com.tencent.mm.ba.f;
import com.tencent.mm.ba.h;
import com.tencent.mm.cb.f.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.pluginsdk.g.a.a.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.util.Iterator;
import java.util.List;

public final class aa {
    public List<bi> kbM;
    public ak mHandler = new ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(30916);
            if (aa.this.kbM == null || !aw.RK()) {
                AppMethodBeat.o(30916);
                return;
            }
            ab.d("MicroMsg.EggMgr", "post start egg");
            aa.this.a(aa.this.yLz, aa.this.kbM);
            AppMethodBeat.o(30916);
        }
    };
    public ChattingAnimFrame yLy = null;
    public Activity yLz;

    public aa() {
        AppMethodBeat.i(30918);
        AppMethodBeat.o(30918);
    }

    public final void a(Activity activity, List<bi> list) {
        AppMethodBeat.i(30919);
        if (list == null) {
            AppMethodBeat.o(30919);
            return;
        }
        for (bi a : list) {
            if (a(activity, a)) {
                AppMethodBeat.o(30919);
                return;
            }
        }
        AppMethodBeat.o(30919);
    }

    private boolean a(Activity activity, bi biVar) {
        AppMethodBeat.i(30920);
        dCH();
        f bjQ = ((d) g.M(d.class)).getEmojiMgr().bjQ();
        if (bjQ == null) {
            ab.d("MicroMsg.EggMgr", "eggList is null");
            AppMethodBeat.o(30920);
            return false;
        }
        int anT = (int) bo.anT();
        ab.d("MicroMsg.EggMgr", "cursecond is %d, getEggList.size is %d", Integer.valueOf(anT), Integer.valueOf(bjQ.fMi.size()));
        Iterator it = bjQ.fMi.iterator();
        while (it.hasNext()) {
            com.tencent.mm.ba.d dVar = (com.tencent.mm.ba.d) it.next();
            if (are(dVar.fMc)) {
                Iterator it2 = dVar.fLY.iterator();
                while (it2.hasNext()) {
                    e eVar = (e) it2.next();
                    String str = eVar.fMh;
                    if (ah.isNullOrNil(str)) {
                        ab.e("MicroMsg.EggMgr", "error egg keyWord");
                    } else {
                        String str2 = biVar.field_content;
                        if (t.kH(biVar.field_talker)) {
                            str2 = bf.ow(str2);
                        }
                        if (aF(str2, str, eVar.lang)) {
                            if (this.yLy == null) {
                                ViewStub viewStub = (ViewStub) activity.findViewById(R.id.alm);
                                if (viewStub != null) {
                                    viewStub.inflate();
                                }
                                this.yLy = (ChattingAnimFrame) activity.findViewById(R.id.av0);
                            }
                            if (this.yLy == null) {
                                ab.e("MicroMsg.EggMgr", "AnimFrameView should not be null");
                            } else if (dVar.fMa <= anT && ((long) anT) <= ((long) dVar.fMb) + TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) {
                                this.yLy.a(dVar);
                                aE(dVar.cKB, biVar.field_isSend == 1);
                                ab.d("MicroMsg.EggMgr", "match keyWord[%s], time[%d - %d]", str, Integer.valueOf(dVar.fMa), Integer.valueOf(dVar.fMb));
                                AppMethodBeat.o(30920);
                                return true;
                            } else if (dVar.fMa == dVar.fMb && dVar.fMa == 0) {
                                this.yLy.a(dVar);
                                aE(dVar.cKB, biVar.field_isSend == 1);
                                ab.d("MicroMsg.EggMgr", "match keyWord[%s], time[0 - 0]", str);
                                AppMethodBeat.o(30920);
                                return true;
                            } else {
                                ab.d("MicroMsg.EggMgr", "match keyWord[%s], but not match time[%d - %d]", str, Integer.valueOf(dVar.fMa), Integer.valueOf(dVar.fMb));
                                AppMethodBeat.o(30920);
                                return false;
                            }
                        }
                        continue;
                    }
                }
                continue;
            }
        }
        ab.d("MicroMsg.EggMgr", "no match");
        AppMethodBeat.o(30920);
        return false;
    }

    private static boolean are(String str) {
        boolean z = true;
        AppMethodBeat.i(30921);
        if (!ah.isNullOrNil(str)) {
            for (String equals : str.split(",")) {
                if (equals.equals(com.tencent.mm.sdk.platformtools.aa.dor())) {
                    break;
                }
            }
            z = false;
        }
        AppMethodBeat.o(30921);
        return z;
    }

    private static boolean aF(String str, String str2, String str3) {
        AppMethodBeat.i(30922);
        if (ah.isNullOrNil(str) || ah.isNullOrNil(str2) || com.tencent.mm.sdk.platformtools.ah.getContext() == null) {
            AppMethodBeat.o(30922);
            return false;
        }
        String toLowerCase = str.toLowerCase();
        int indexOf = toLowerCase.indexOf(str2.toLowerCase());
        if (indexOf == -1) {
            AppMethodBeat.o(30922);
            return false;
        }
        do {
            int i = indexOf;
            try {
                boolean z;
                if (i >= toLowerCase.length() - 1 || ah.isNullOrNil(str3)) {
                    z = true;
                } else {
                    if (i > 0 && toLowerCase.charAt(i - 1) >= 'a' && toLowerCase.charAt(i - 1) <= 'z') {
                        ab.v("MicroMsg.EggMgr", "letter in the prefix");
                        String substring = str.substring(0, i);
                        indexOf = substring.lastIndexOf(47);
                        if (indexOf != -1) {
                            substring = substring.subSequence(indexOf, substring.length());
                            com.tencent.mm.cb.g.dqQ();
                            com.tencent.mm.sdk.platformtools.ah.getContext();
                            a anW = com.tencent.mm.cb.f.dqL().anW(substring);
                            if (anW != null) {
                                substring = anW.text;
                            } else {
                                substring = null;
                            }
                            if (!ah.isNullOrNil(substring) && substring.length() + indexOf == i) {
                                ab.v("MicroMsg.EggMgr", "letter in the prefix is smiley");
                                indexOf = -2;
                            }
                        }
                        if (indexOf != -2) {
                            z = false;
                            if (z && str2.length() + i < toLowerCase.length() && toLowerCase.charAt(str2.length() + i) >= 'a' && toLowerCase.charAt(str2.length() + i) <= 'z') {
                                ab.v("MicroMsg.EggMgr", "letter in the suffix");
                                z = false;
                            }
                        }
                    }
                    z = true;
                    ab.v("MicroMsg.EggMgr", "letter in the suffix");
                    z = false;
                }
                if (z) {
                    ab.v("MicroMsg.EggMgr", "full match, matchPos = %s, TextLength = %s, keyLength = %s", Integer.valueOf(i), Integer.valueOf(toLowerCase.length()), Integer.valueOf(str2.length()));
                    AppMethodBeat.o(30922);
                    return z;
                }
                indexOf = toLowerCase.indexOf(str2.toLowerCase(), i + 1);
            } catch (Exception e) {
                ab.v("MicroMsg.EggMgr", "Exception in isKeywordMatch, %s", e.getMessage());
                ab.printErrStackTrace("MicroMsg.EggMgr", e, "", new Object[0]);
            }
        } while (indexOf != -1);
        AppMethodBeat.o(30922);
        return false;
    }

    private void dCH() {
        AppMethodBeat.i(30923);
        aw.ZK();
        if (ah.fp(ah.d((Long) c.Ry().get(68108, null))) * 1000 > 21600000) {
            new ak().postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(30917);
                    if (aw.RK()) {
                        aw.Rg().a(new m(37), 0);
                        aw.ZK();
                        c.Ry().set(68108, Long.valueOf(ah.anT()));
                        AppMethodBeat.o(30917);
                        return;
                    }
                    AppMethodBeat.o(30917);
                }
            }, 10000);
        }
        AppMethodBeat.o(30923);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0060 A:{Catch:{ Exception -> 0x00c2 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void aE(int i, boolean z) {
        AppMethodBeat.i(30924);
        try {
            h hVar;
            int i2;
            StringBuilder stringBuilder;
            StringBuilder stringBuilder2 = new StringBuilder();
            aw.ZK();
            byte[] e = com.tencent.mm.vfs.e.e(stringBuilder2.append(c.Rt()).append("eggresult.rep").toString(), 0, -1);
            if (e != null) {
                ab.d("MicroMsg.EggMgr", "data not null, parse it");
                hVar = (h) new h().parseFrom(e);
            } else {
                ab.d("MicroMsg.EggMgr", "data is null, new one");
                hVar = new h();
            }
            Iterator it = hVar.fMm.iterator();
            while (it.hasNext()) {
                com.tencent.mm.ba.g gVar = (com.tencent.mm.ba.g) it.next();
                if (gVar.cKB == i) {
                    if (z) {
                        gVar.fMk++;
                    } else {
                        gVar.fMl++;
                    }
                    i2 = 1;
                    if (i2 == 0) {
                        gVar = new com.tencent.mm.ba.g();
                        gVar.cKB = i;
                        if (z) {
                            gVar.fMk = 1;
                        } else {
                            gVar.fMl = 1;
                        }
                        hVar.fMm.add(gVar);
                    }
                    e = hVar.toByteArray();
                    ab.d("MicroMsg.EggMgr", "report list is %s, then save it", hVar.toString());
                    stringBuilder = new StringBuilder();
                    aw.ZK();
                    com.tencent.mm.vfs.e.b(stringBuilder.append(c.Rt()).append("eggresult.rep").toString(), e, e.length);
                    AppMethodBeat.o(30924);
                }
            }
            i2 = 0;
            if (i2 == 0) {
            }
            e = hVar.toByteArray();
            ab.d("MicroMsg.EggMgr", "report list is %s, then save it", hVar.toString());
            stringBuilder = new StringBuilder();
            aw.ZK();
            com.tencent.mm.vfs.e.b(stringBuilder.append(c.Rt()).append("eggresult.rep").toString(), e, e.length);
            AppMethodBeat.o(30924);
        } catch (Exception e2) {
            ab.w("MicroMsg.EggMgr", "statistics crash : %s", e2.getLocalizedMessage());
            ab.printErrStackTrace("MicroMsg.EggMgr", e2, "", new Object[0]);
            AppMethodBeat.o(30924);
        }
    }
}
