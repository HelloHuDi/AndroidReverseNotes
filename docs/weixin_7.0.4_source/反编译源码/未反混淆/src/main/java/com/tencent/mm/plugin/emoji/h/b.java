package com.tencent.mm.plugin.emoji.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.protocal.protobuf.xx;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;

public final class b {

    /* renamed from: com.tencent.mm.plugin.emoji.h.b$1 */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] lgJ = new int[com.tencent.mm.storage.emotion.EmojiInfo.b.values().length];

        static {
            AppMethodBeat.i(62342);
            try {
                lgJ[com.tencent.mm.storage.emotion.EmojiInfo.b.ERR_NON_NETWORK.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                lgJ[com.tencent.mm.storage.emotion.EmojiInfo.b.ERR_WIFI_NETWORK.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                lgJ[com.tencent.mm.storage.emotion.EmojiInfo.b.ERR_MOBILE_NETWORK.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                lgJ[com.tencent.mm.storage.emotion.EmojiInfo.b.ERR_NOT_COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                lgJ[com.tencent.mm.storage.emotion.EmojiInfo.b.ERR_OTHERS.ordinal()] = 5;
                AppMethodBeat.o(62342);
            } catch (NoSuchFieldError e5) {
                AppMethodBeat.o(62342);
            }
        }
    }

    public static int aF(byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            return EmojiInfo.yaq;
        }
        if (bArr[1] == (byte) 80 && bArr[2] == (byte) 78 && bArr[3] == (byte) 71) {
            return EmojiInfo.zYR;
        }
        if (bArr[0] == (byte) 71 && bArr[1] == (byte) 73 && bArr[2] == (byte) 70) {
            return EmojiInfo.zYS;
        }
        if (bArr[6] == (byte) 74 && bArr[7] == (byte) 70 && bArr[8] == (byte) 73 && bArr[9] == (byte) 70) {
            return EmojiInfo.zYV;
        }
        return EmojiInfo.yaq;
    }

    public static String Yb() {
        AppMethodBeat.i(62343);
        String str = ((d) g.M(d.class)).getProvider().getAccPath() + "emoji/";
        AppMethodBeat.o(62343);
        return str;
    }

    public static void a(xx xxVar, EmojiInfo emojiInfo) {
        AppMethodBeat.i(62344);
        if (bo.isNullOrNil(emojiInfo.field_md5) || emojiInfo.field_md5.equals(xxVar.Md5)) {
            emojiInfo.field_md5 = dN(xxVar.Md5, emojiInfo.field_md5);
            emojiInfo.field_cdnUrl = dN(xxVar.Url, emojiInfo.field_cdnUrl);
            emojiInfo.field_thumbUrl = dN(xxVar.ThumbUrl, emojiInfo.field_thumbUrl);
            emojiInfo.field_designerID = dN(xxVar.wdC, emojiInfo.field_designerID);
            emojiInfo.field_encrypturl = dN(xxVar.EncryptUrl, emojiInfo.field_encrypturl);
            emojiInfo.field_aeskey = dN(xxVar.AesKey, emojiInfo.field_aeskey);
            emojiInfo.field_groupId = dN(xxVar.ProductID, emojiInfo.field_groupId);
            emojiInfo.field_externUrl = dN(xxVar.ExternUrl, emojiInfo.field_externUrl);
            emojiInfo.field_externMd5 = dN(xxVar.ExternMd5, emojiInfo.field_externMd5);
            emojiInfo.field_activityid = dN(xxVar.ActivityID, emojiInfo.field_activityid);
            emojiInfo.field_attachedText = dN(xxVar.wdD, emojiInfo.field_attachedText);
            emojiInfo.field_attachTextColor = dN(xxVar.wdE, emojiInfo.field_attachTextColor);
            emojiInfo.field_lensId = dN(xxVar.wdF, emojiInfo.field_lensId);
            AppMethodBeat.o(62344);
            return;
        }
        AppMethodBeat.o(62344);
    }

    public static String dN(String str, String str2) {
        AppMethodBeat.i(62345);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(62345);
            return str2;
        }
        AppMethodBeat.o(62345);
        return str;
    }

    public static boolean w(EmojiInfo emojiInfo) {
        AppMethodBeat.i(62346);
        if (emojiInfo == null || !JX(emojiInfo.field_groupId)) {
            AppMethodBeat.o(62346);
            return false;
        }
        AppMethodBeat.o(62346);
        return true;
    }

    public static boolean JX(String str) {
        AppMethodBeat.i(62347);
        if (bo.isNullOrNil(str) || bo.isEqual(str, "capture") || bo.isEqual(str, EmojiGroupInfo.yar)) {
            AppMethodBeat.o(62347);
            return false;
        }
        AppMethodBeat.o(62347);
        return true;
    }

    public static boolean y(EmojiInfo emojiInfo) {
        AppMethodBeat.i(62349);
        if (emojiInfo == null) {
            AppMethodBeat.o(62349);
            return false;
        } else if (!e.OW()) {
            AppMethodBeat.o(62349);
            return false;
        } else if (x(emojiInfo) || (emojiInfo.field_activityid != null && emojiInfo.field_activityid.startsWith("Selfie"))) {
            AppMethodBeat.o(62349);
            return true;
        } else {
            AppMethodBeat.o(62349);
            return false;
        }
    }

    public static boolean JY(String str) {
        AppMethodBeat.i(62350);
        if (bo.isNullOrNil(str) || bo.isEqual(str, "capture")) {
            AppMethodBeat.o(62350);
            return false;
        }
        AppMethodBeat.o(62350);
        return true;
    }

    public static boolean x(EmojiInfo emojiInfo) {
        AppMethodBeat.i(62348);
        boolean isEqual = bo.isEqual(emojiInfo.field_groupId, "capture");
        AppMethodBeat.o(62348);
        return isEqual;
    }
}
