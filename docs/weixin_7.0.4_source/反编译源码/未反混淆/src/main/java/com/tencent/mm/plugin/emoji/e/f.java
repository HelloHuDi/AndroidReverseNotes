package com.tencent.mm.plugin.emoji.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.e;

public class f {
    public static f kTO;
    public boolean isRunning = false;
    private String key;

    public static f bjK() {
        AppMethodBeat.i(52865);
        if (kTO == null) {
            synchronized (f.class) {
                try {
                    kTO = new f();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(52865);
                    }
                }
            }
        }
        f fVar = kTO;
        AppMethodBeat.o(52865);
        return fVar;
    }

    private String bjL() {
        AppMethodBeat.i(52866);
        if (bo.isNullOrNil(this.key)) {
            this.key = j.getEmojiStorageMgr().xYn.getKey();
        }
        String str = this.key;
        AppMethodBeat.o(52866);
        return str;
    }

    public final boolean isEnable() {
        AppMethodBeat.i(52867);
        if (bo.isNullOrNil(bjL())) {
            AppMethodBeat.o(52867);
            return false;
        }
        AppMethodBeat.o(52867);
        return true;
    }

    public final boolean c(EmojiInfo emojiInfo, boolean z) {
        AppMethodBeat.i(52868);
        if (emojiInfo == null) {
            ab.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. emoji is null.");
            AppMethodBeat.o(52868);
            return false;
        } else if (isEnable()) {
            String dve = emojiInfo.dve();
            if (e.ct(dve)) {
                boolean z2 = false;
                byte[] e = e.e(dve, 0, 10);
                if (e != null) {
                    try {
                        if (e.length >= 10) {
                            z2 = r.bT(e);
                        }
                    } catch (Throwable th) {
                        ab.printErrStackTrace("MicroMsg.emoji.EmojiFileEncryptMgr", th, "", new Object[0]);
                        z2 = false;
                    }
                }
                if (z || z2) {
                    int i;
                    long currentTimeMillis = System.currentTimeMillis();
                    int asZ = (int) e.asZ(dve);
                    if (asZ > 1024) {
                        i = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                    } else {
                        i = asZ;
                    }
                    Object e2 = e.e(dve, 0, asZ);
                    Object obj = new byte[0];
                    try {
                        obj = AesEcb.aesCryptEcb(e.e(dve, 0, i), bjL().getBytes(), true, false);
                    } catch (Throwable th2) {
                        ab.printErrStackTrace("MicroMsg.emoji.EmojiFileEncryptMgr", th2, "", new Object[0]);
                    }
                    if (obj == null || obj.length < i || e2 == null || e2.length < i) {
                        i = -1;
                    } else {
                        System.arraycopy(obj, 0, e2, 0, i);
                        i = e.b(dve, e2, e2.length);
                    }
                    if (i == 0) {
                        h.pYm.a(252, 1, System.currentTimeMillis() - currentTimeMillis, false);
                        h.pYm.a(252, 6, 1, false);
                        emojiInfo.field_reserved4 |= EmojiInfo.zZi;
                        emojiInfo.field_size = asZ;
                        j.getEmojiStorageMgr().xYn.H(emojiInfo);
                        ab.i("MicroMsg.emoji.EmojiFileEncryptMgr", "encode emoji file length:%d use time:%d", Integer.valueOf(e2.length), Long.valueOf(r8));
                        AppMethodBeat.o(52868);
                        return true;
                    }
                    ab.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. write file failed.");
                    h.pYm.a(252, 3, 1, false);
                    AppMethodBeat.o(52868);
                    return false;
                }
                ab.i("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile file had encrypt.");
                AppMethodBeat.o(52868);
                return true;
            }
            ab.w("MicroMsg.emoji.EmojiFileEncryptMgr", "encodeEmojiFile failed. file not exist. path%s", dve);
            emojiInfo.field_reserved4 = 0;
            j.getEmojiStorageMgr().xYn.H(emojiInfo);
            AppMethodBeat.o(52868);
            return false;
        } else {
            ab.i("MicroMsg.emoji.EmojiFileEncryptMgr", "disable encrypt");
            AppMethodBeat.o(52868);
            return false;
        }
    }

    public final byte[] l(EmojiInfo emojiInfo) {
        AppMethodBeat.i(52869);
        if (emojiInfo == null) {
            ab.w("MicroMsg.emoji.EmojiFileEncryptMgr", "decodeEmojiData failed. emoji is null.");
            AppMethodBeat.o(52869);
            return null;
        }
        String dve = emojiInfo.dve();
        Object e = e.e(dve, 0, -1);
        if (e.asZ(dve) <= 0 || e == null || e.length < 10) {
            ab.i("MicroMsg.emoji.EmojiFileEncryptMgr", "decode emoji file failed. path is no exist :%s ", dve);
            AppMethodBeat.o(52869);
            return null;
        }
        byte[] bArr = new byte[10];
        System.arraycopy(e, 0, bArr, 0, 10);
        if ((emojiInfo.field_reserved4 & EmojiInfo.zZi) != EmojiInfo.zZi || r.bT(bArr)) {
            AppMethodBeat.o(52869);
            return e;
        }
        long currentTimeMillis = System.currentTimeMillis();
        int asZ = (int) e.asZ(dve);
        if (asZ > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            asZ = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        }
        byte[] e2 = e.e(dve, 0, asZ);
        byte[] bArr2 = null;
        if (!bo.isNullOrNil(bjL())) {
            try {
                bArr2 = AesEcb.aesCryptEcb(e2, bjL().getBytes(), false, false);
            } catch (Throwable th) {
                ab.printErrStackTrace("MicroMsg.emoji.EmojiFileEncryptMgr", th, "", new Object[0]);
            }
        }
        if (bo.cb(bArr2) || bo.cb(e)) {
            h.pYm.a(252, 2, 1, false);
            ab.i("MicroMsg.emoji.EmojiFileEncryptMgr", "decode emoji file failed. path:%s return original ", dve);
            AppMethodBeat.o(52869);
            return e;
        }
        System.arraycopy(bArr2, 0, e, 0, asZ);
        h.pYm.a(252, 0, System.currentTimeMillis() - currentTimeMillis, false);
        h.pYm.a(252, 5, 1, false);
        ab.d("MicroMsg.emoji.EmojiFileEncryptMgr", "decode emoji file length:%d use time:%d", Integer.valueOf(e.length), Long.valueOf(r8));
        AppMethodBeat.o(52869);
        return e;
    }

    public final boolean m(EmojiInfo emojiInfo) {
        int i = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        AppMethodBeat.i(52870);
        if (emojiInfo == null) {
            ab.w("MicroMsg.emoji.EmojiFileEncryptMgr", "decodeEmojiData failed. emoji is null.");
            AppMethodBeat.o(52870);
            return false;
        }
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        String dve = emojiInfo.dve();
        int asZ = (int) e.asZ(dve);
        if (asZ <= WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            i = asZ;
        }
        byte[] e = e.e(dve, 0, i);
        if (e.asZ(dve) > 0 && e != null && e.length >= 10) {
            byte[] bArr = new byte[10];
            System.arraycopy(e, 0, bArr, 0, 10);
            if (r.bT(bArr)) {
                z = true;
            } else if ((emojiInfo.field_reserved4 & EmojiInfo.zZi) == EmojiInfo.zZi) {
                bArr = null;
                if (!bo.isNullOrNil(bjL())) {
                    try {
                        bArr = AesEcb.aesCryptEcb(e, bjL().getBytes(), false, false);
                    } catch (Throwable th) {
                        ab.printErrStackTrace("MicroMsg.emoji.EmojiFileEncryptMgr", th, "", new Object[0]);
                    }
                }
                if (!bo.cb(bArr) && r.bT(bArr)) {
                    z = true;
                }
            }
            ab.d("MicroMsg.emoji.EmojiFileEncryptMgr", "checkout use time:%s result:%b", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(z));
            AppMethodBeat.o(52870);
            return z;
        }
        z = false;
        ab.d("MicroMsg.emoji.EmojiFileEncryptMgr", "checkout use time:%s result:%b", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(z));
        AppMethodBeat.o(52870);
        return z;
    }
}
