package com.tencent.p177mm.plugin.emoji.p947e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.jniinterface.AesEcb;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5063r;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.vfs.C5730e;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.emoji.e.f */
public class C20362f {
    public static C20362f kTO;
    public boolean isRunning = false;
    private String key;

    /* renamed from: com.tencent.mm.plugin.emoji.e.f$1 */
    class C203631 implements Runnable {
        C203631() {
        }

        public final void run() {
            AppMethodBeat.m2504i(52864);
            if (C1720g.m3531RK()) {
                ArrayList dvj = C42952j.getEmojiStorageMgr().xYn.dvj();
                if (dvj != null && dvj.size() > 0) {
                    Iterator it = dvj.iterator();
                    while (it.hasNext()) {
                        EmojiInfo emojiInfo = (EmojiInfo) it.next();
                        if (C20362f.this.isRunning) {
                            C20362f.this.mo35591c(emojiInfo, false);
                        }
                    }
                }
                if (C20362f.this.isRunning) {
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_EMOJI_ENCODE_EMOJI_FILE_TASK_LONG, Long.valueOf(System.currentTimeMillis()));
                }
                AppMethodBeat.m2505o(52864);
                return;
            }
            AppMethodBeat.m2505o(52864);
        }
    }

    public static C20362f bjK() {
        AppMethodBeat.m2504i(52865);
        if (kTO == null) {
            synchronized (C20362f.class) {
                try {
                    kTO = new C20362f();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(52865);
                    }
                }
            }
        }
        C20362f c20362f = kTO;
        AppMethodBeat.m2505o(52865);
        return c20362f;
    }

    private String bjL() {
        AppMethodBeat.m2504i(52866);
        if (C5046bo.isNullOrNil(this.key)) {
            this.key = C42952j.getEmojiStorageMgr().xYn.getKey();
        }
        String str = this.key;
        AppMethodBeat.m2505o(52866);
        return str;
    }

    public final boolean isEnable() {
        AppMethodBeat.m2504i(52867);
        if (C5046bo.isNullOrNil(bjL())) {
            AppMethodBeat.m2505o(52867);
            return false;
        }
        AppMethodBeat.m2505o(52867);
        return true;
    }

    /* renamed from: c */
    public final boolean mo35591c(EmojiInfo emojiInfo, boolean z) {
        AppMethodBeat.m2504i(52868);
        if (emojiInfo == null) {
            C4990ab.m7420w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. emoji is null.");
            AppMethodBeat.m2505o(52868);
            return false;
        } else if (isEnable()) {
            String dve = emojiInfo.dve();
            if (C5730e.m8628ct(dve)) {
                boolean z2 = false;
                byte[] e = C5730e.m8632e(dve, 0, 10);
                if (e != null) {
                    try {
                        if (e.length >= 10) {
                            z2 = C5063r.m7678bT(e);
                        }
                    } catch (Throwable th) {
                        C4990ab.printErrStackTrace("MicroMsg.emoji.EmojiFileEncryptMgr", th, "", new Object[0]);
                        z2 = false;
                    }
                }
                if (z || z2) {
                    int i;
                    long currentTimeMillis = System.currentTimeMillis();
                    int asZ = (int) C5730e.asZ(dve);
                    if (asZ > 1024) {
                        i = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                    } else {
                        i = asZ;
                    }
                    Object e2 = C5730e.m8632e(dve, 0, asZ);
                    Object obj = new byte[0];
                    try {
                        obj = AesEcb.aesCryptEcb(C5730e.m8632e(dve, 0, i), bjL().getBytes(), true, false);
                    } catch (Throwable th2) {
                        C4990ab.printErrStackTrace("MicroMsg.emoji.EmojiFileEncryptMgr", th2, "", new Object[0]);
                    }
                    if (obj == null || obj.length < i || e2 == null || e2.length < i) {
                        i = -1;
                    } else {
                        System.arraycopy(obj, 0, e2, 0, i);
                        i = C5730e.m8624b(dve, e2, e2.length);
                    }
                    if (i == 0) {
                        C7060h.pYm.mo8378a(252, 1, System.currentTimeMillis() - currentTimeMillis, false);
                        C7060h.pYm.mo8378a(252, 6, 1, false);
                        emojiInfo.field_reserved4 |= EmojiInfo.zZi;
                        emojiInfo.field_size = asZ;
                        C42952j.getEmojiStorageMgr().xYn.mo48556H(emojiInfo);
                        C4990ab.m7417i("MicroMsg.emoji.EmojiFileEncryptMgr", "encode emoji file length:%d use time:%d", Integer.valueOf(e2.length), Long.valueOf(r8));
                        AppMethodBeat.m2505o(52868);
                        return true;
                    }
                    C4990ab.m7420w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. write file failed.");
                    C7060h.pYm.mo8378a(252, 3, 1, false);
                    AppMethodBeat.m2505o(52868);
                    return false;
                }
                C4990ab.m7416i("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile file had encrypt.");
                AppMethodBeat.m2505o(52868);
                return true;
            }
            C4990ab.m7421w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. file not exist. path%s", dve);
            emojiInfo.field_reserved4 = 0;
            C42952j.getEmojiStorageMgr().xYn.mo48556H(emojiInfo);
            AppMethodBeat.m2505o(52868);
            return false;
        } else {
            C4990ab.m7416i("MicroMsg.emoji.EmojiFileEncryptMgr", "disable encrypt");
            AppMethodBeat.m2505o(52868);
            return false;
        }
    }

    /* renamed from: l */
    public final byte[] mo35593l(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(52869);
        if (emojiInfo == null) {
            C4990ab.m7420w("MicroMsg.emoji.EmojiFileEncryptMgr", "decodeEmojiData failed. emoji is null.");
            AppMethodBeat.m2505o(52869);
            return null;
        }
        String dve = emojiInfo.dve();
        Object e = C5730e.m8632e(dve, 0, -1);
        if (C5730e.asZ(dve) <= 0 || e == null || e.length < 10) {
            C4990ab.m7417i("MicroMsg.emoji.EmojiFileEncryptMgr", "decode emoji file failed. path is no exist :%s ", dve);
            AppMethodBeat.m2505o(52869);
            return null;
        }
        byte[] bArr = new byte[10];
        System.arraycopy(e, 0, bArr, 0, 10);
        if ((emojiInfo.field_reserved4 & EmojiInfo.zZi) != EmojiInfo.zZi || C5063r.m7678bT(bArr)) {
            AppMethodBeat.m2505o(52869);
            return e;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int asZ = (int) C5730e.asZ(dve);
        if (asZ > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            asZ = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        }
        byte[] e2 = C5730e.m8632e(dve, 0, asZ);
        byte[] bArr2 = null;
        if (!C5046bo.isNullOrNil(bjL())) {
            try {
                bArr2 = AesEcb.aesCryptEcb(e2, bjL().getBytes(), false, false);
            } catch (Throwable th) {
                C4990ab.printErrStackTrace("MicroMsg.emoji.EmojiFileEncryptMgr", th, "", new Object[0]);
            }
        }
        if (C5046bo.m7540cb(bArr2) || C5046bo.m7540cb(e)) {
            C7060h.pYm.mo8378a(252, 2, 1, false);
            C4990ab.m7417i("MicroMsg.emoji.EmojiFileEncryptMgr", "decode emoji file failed. path:%s return original ", dve);
            AppMethodBeat.m2505o(52869);
            return e;
        }
        System.arraycopy(bArr2, 0, e, 0, asZ);
        C7060h.pYm.mo8378a(252, 0, System.currentTimeMillis() - currentTimeMillis, false);
        C7060h.pYm.mo8378a(252, 5, 1, false);
        C4990ab.m7411d("MicroMsg.emoji.EmojiFileEncryptMgr", "decode emoji file length:%d use time:%d", Integer.valueOf(e.length), Long.valueOf(r8));
        AppMethodBeat.m2505o(52869);
        return e;
    }

    /* renamed from: m */
    public final boolean mo35594m(EmojiInfo emojiInfo) {
        int i = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        AppMethodBeat.m2504i(52870);
        if (emojiInfo == null) {
            C4990ab.m7420w("MicroMsg.emoji.EmojiFileEncryptMgr", "decodeEmojiData failed. emoji is null.");
            AppMethodBeat.m2505o(52870);
            return false;
        }
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        String dve = emojiInfo.dve();
        int asZ = (int) C5730e.asZ(dve);
        if (asZ <= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            i = asZ;
        }
        byte[] e = C5730e.m8632e(dve, 0, i);
        if (C5730e.asZ(dve) > 0 && e != null && e.length >= 10) {
            byte[] bArr = new byte[10];
            System.arraycopy(e, 0, bArr, 0, 10);
            if (C5063r.m7678bT(bArr)) {
                z = true;
            } else if ((emojiInfo.field_reserved4 & EmojiInfo.zZi) == EmojiInfo.zZi) {
                bArr = null;
                if (!C5046bo.isNullOrNil(bjL())) {
                    try {
                        bArr = AesEcb.aesCryptEcb(e, bjL().getBytes(), false, false);
                    } catch (Throwable th) {
                        C4990ab.printErrStackTrace("MicroMsg.emoji.EmojiFileEncryptMgr", th, "", new Object[0]);
                    }
                }
                if (!C5046bo.m7540cb(bArr) && C5063r.m7678bT(bArr)) {
                    z = true;
                }
            }
            C4990ab.m7411d("MicroMsg.emoji.EmojiFileEncryptMgr", "checkout use time:%s result:%b", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(z));
            AppMethodBeat.m2505o(52870);
            return z;
        }
        z = false;
        C4990ab.m7411d("MicroMsg.emoji.EmojiFileEncryptMgr", "checkout use time:%s result:%b", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(z));
        AppMethodBeat.m2505o(52870);
        return z;
    }
}
