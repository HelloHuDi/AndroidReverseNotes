package com.tencent.p177mm.plugin.backup.p346f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.backup.p1394h.C38658d;
import com.tencent.p177mm.plugin.backup.p1394h.C45748c;
import com.tencent.p177mm.plugin.backup.p342b.C38635g;
import com.tencent.p177mm.plugin.backup.p342b.C38635g.C19941a;
import com.tencent.p177mm.plugin.backup.p346f.C11149i.C11150a;
import com.tencent.p177mm.plugin.backup.p346f.C45745h.C19972a;
import com.tencent.p177mm.plugin.backup.p921i.C19993u;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.protocal.protobuf.C40522gu;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C23504as;
import com.tencent.p177mm.storage.C44218ap;
import com.tencent.p177mm.storage.C7620bi;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.backup.f.b */
public final class C19971b implements C27487l {
    /* renamed from: a */
    public final int mo35220a(String str, C40522gu c40522gu, C7620bi c7620bi) {
        AppMethodBeat.m2504i(17450);
        c7620bi.setContent(c40522gu.vED.wVI);
        String str2 = c40522gu.vEB.wVI;
        String str3 = c40522gu.vEC.wVI;
        if (!((String) C38658d.aUr().aUs().mo61496Ry().get(2, null)).equals(str2)) {
            str3 = str2;
        }
        str2 = c40522gu.vED.wVI;
        Map z = C5049br.m7595z(str2, "msg");
        C23504as dK = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35645dK(str2, str3);
        if (dK == null) {
            C4990ab.m7420w("MicroMsg.BackupItemEmoji", "EmojiMsgInfo is null");
            AppMethodBeat.m2505o(17450);
            return -1;
        }
        EmojiInfo Jd = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35596Jd(dK.cvZ);
        if (Jd == null) {
            C4990ab.m7420w("MicroMsg.BackupItemEmoji", "EmojiInfo is null");
            Jd = new EmojiInfo();
            C23504as.m36332a(dK, Jd);
            Jd.field_catalog = EmojiInfo.yau;
            C38658d.aUr().aUs().aUp().mo48553E(Jd);
        }
        if (z.get(".msg.emoji.$androidmd5") == null) {
            str3 = C19941a.m30841Fg(dK.cvZ);
            if (!C5046bo.isNullOrNil(str3)) {
                dK.cvZ = str3;
                C4990ab.m7411d("MicroMsg.BackupItemEmoji", "convert ip to android md5 %s", str3);
            }
        }
        String str4 = dK.cwg;
        c7620bi.setType(47);
        c7620bi.mo14795jv(dK.cvZ);
        str3 = dK.fWW;
        boolean z2 = (Jd.mo48552xy() || Jd.isGif()) ? false : true;
        c7620bi.setContent(C44218ap.m79810a(str3, 0, z2, dK.cvZ, false, ""));
        if (!Jd.duP()) {
            String Yb = C38658d.aUr().aUs().mo61502Yb();
            if (TextUtils.isEmpty(str4)) {
                C38635g.m65519b(c40522gu, 4, Yb + dK.cvZ + "_thumb");
                C38635g.m65519b(c40522gu, 5, Yb + dK.cvZ);
            } else {
                C5728b c5728b = new C5728b(Yb + str4);
                if (!c5728b.exists()) {
                    c5728b.mkdirs();
                }
                C38635g.m65519b(c40522gu, 4, Yb + str4 + "/" + dK.cvZ + "_cover");
                C38635g.m65519b(c40522gu, 5, Yb + str4 + "/" + dK.cvZ);
            }
        }
        C4990ab.m7410d("MicroMsg.BackupItemEmoji", "id ".concat(String.valueOf(C45748c.m84550l(c7620bi))));
        AppMethodBeat.m2505o(17450);
        return 0;
    }

    /* renamed from: a */
    public final int mo35219a(C40522gu c40522gu, boolean z, C7620bi c7620bi, String str, LinkedList<C19993u> linkedList, HashMap<Long, C19972a> hashMap, boolean z2, long j) {
        int i;
        AppMethodBeat.m2504i(17449);
        if (C5046bo.isNullOrNil(c7620bi.field_content)) {
            i = 0;
        } else {
            i = c7620bi.field_content.getBytes().length;
        }
        String trim = C44218ap.aps(c7620bi.field_content).xXL.trim();
        if (!C38635g.m65506Fd(trim)) {
            trim = c7620bi.field_content;
            if (!C38635g.m65506Fd(trim)) {
                trim = C19941a.m30842a(c7620bi, c40522gu);
                if (c7620bi.field_isSend != 1 && C45748c.m84549kH(c7620bi.field_talker)) {
                    trim = c7620bi.field_talker + " :\n " + trim;
                }
            }
        }
        if (trim == null || !C38635g.m65506Fd(trim)) {
            C4990ab.m7410d("MicroMsg.BackupItemEmoji", "emoji error:".concat(String.valueOf(trim)));
            AppMethodBeat.m2505o(17449);
            return -1;
        }
        bts bts = new bts();
        bts.alV(C5046bo.m7532bc(trim, ""));
        c40522gu.vED = bts;
        EmojiInfo aqi = C38658d.aUr().aUs().aUp().aqi(c7620bi.field_imgPath);
        if (aqi == null || !aqi.duS()) {
            if (aqi != null) {
                String str2;
                if (TextUtils.isEmpty(aqi.field_groupId)) {
                    str2 = C38658d.aUr().aUs().mo61502Yb() + aqi.mo20410Aq() + "_thumb";
                    if (C5730e.asZ(str2) < 0) {
                        C4990ab.m7412e("MicroMsg.BackupItemEmoji", "thumbPath error");
                        AppMethodBeat.m2505o(17449);
                        return -1;
                    }
                    i = C11149i.m18856a(new C11150a(str2, c40522gu, (LinkedList) linkedList, 4, z, "_thumb", z2)) + i;
                } else {
                    str2 = C38658d.aUr().aUs().mo61502Yb() + aqi.field_groupId + "/" + aqi.mo20410Aq() + "_cover";
                    if (C5730e.asZ(str2) < 0) {
                        C4990ab.m7412e("MicroMsg.BackupItemEmoji", "thumbPath error");
                        AppMethodBeat.m2505o(17449);
                        return -1;
                    }
                    i = C11149i.m18856a(new C11150a(str2, c40522gu, (LinkedList) linkedList, 4, z, "_thumb", z2)) + i;
                }
                if (TextUtils.isEmpty(aqi.field_groupId) && aqi.duP()) {
                    i += C11149i.m18856a(new C11150a(C38658d.aUr().aUs().mo61502Yb() + aqi.mo20410Aq(), c40522gu, (LinkedList) linkedList, 5, z, z2, null));
                } else if (aqi.duR()) {
                    i += C11149i.m18856a(new C11150a(C38658d.aUr().aUs().mo61502Yb() + aqi.field_groupId + "/" + aqi.mo20410Aq(), c40522gu, (LinkedList) linkedList, 5, z, z2, null));
                }
            }
            AppMethodBeat.m2505o(17449);
            return i;
        }
        AppMethodBeat.m2505o(17449);
        return i;
    }
}
