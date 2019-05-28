package com.tencent.p177mm.plugin.emoji.p383h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.p227a.C26072e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.protocal.protobuf.C40588xx;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.storage.emotion.EmojiInfo.C30301b;

/* renamed from: com.tencent.mm.plugin.emoji.h.b */
public final class C2933b {

    /* renamed from: com.tencent.mm.plugin.emoji.h.b$1 */
    public static /* synthetic */ class C29341 {
        public static final /* synthetic */ int[] lgJ = new int[C30301b.values().length];

        static {
            AppMethodBeat.m2504i(62342);
            try {
                lgJ[C30301b.ERR_NON_NETWORK.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                lgJ[C30301b.ERR_WIFI_NETWORK.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                lgJ[C30301b.ERR_MOBILE_NETWORK.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                lgJ[C30301b.ERR_NOT_COMPLETED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                lgJ[C30301b.ERR_OTHERS.ordinal()] = 5;
                AppMethodBeat.m2505o(62342);
            } catch (NoSuchFieldError e5) {
                AppMethodBeat.m2505o(62342);
            }
        }
    }

    /* renamed from: aF */
    public static int m5223aF(byte[] bArr) {
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

    /* renamed from: Yb */
    public static String m5221Yb() {
        AppMethodBeat.m2504i(62343);
        String str = ((C6835d) C1720g.m3530M(C6835d.class)).getProvider().getAccPath() + "emoji/";
        AppMethodBeat.m2505o(62343);
        return str;
    }

    /* renamed from: a */
    public static void m5222a(C40588xx c40588xx, EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(62344);
        if (C5046bo.isNullOrNil(emojiInfo.field_md5) || emojiInfo.field_md5.equals(c40588xx.Md5)) {
            emojiInfo.field_md5 = C2933b.m5224dN(c40588xx.Md5, emojiInfo.field_md5);
            emojiInfo.field_cdnUrl = C2933b.m5224dN(c40588xx.Url, emojiInfo.field_cdnUrl);
            emojiInfo.field_thumbUrl = C2933b.m5224dN(c40588xx.ThumbUrl, emojiInfo.field_thumbUrl);
            emojiInfo.field_designerID = C2933b.m5224dN(c40588xx.wdC, emojiInfo.field_designerID);
            emojiInfo.field_encrypturl = C2933b.m5224dN(c40588xx.EncryptUrl, emojiInfo.field_encrypturl);
            emojiInfo.field_aeskey = C2933b.m5224dN(c40588xx.AesKey, emojiInfo.field_aeskey);
            emojiInfo.field_groupId = C2933b.m5224dN(c40588xx.ProductID, emojiInfo.field_groupId);
            emojiInfo.field_externUrl = C2933b.m5224dN(c40588xx.ExternUrl, emojiInfo.field_externUrl);
            emojiInfo.field_externMd5 = C2933b.m5224dN(c40588xx.ExternMd5, emojiInfo.field_externMd5);
            emojiInfo.field_activityid = C2933b.m5224dN(c40588xx.ActivityID, emojiInfo.field_activityid);
            emojiInfo.field_attachedText = C2933b.m5224dN(c40588xx.wdD, emojiInfo.field_attachedText);
            emojiInfo.field_attachTextColor = C2933b.m5224dN(c40588xx.wdE, emojiInfo.field_attachTextColor);
            emojiInfo.field_lensId = C2933b.m5224dN(c40588xx.wdF, emojiInfo.field_lensId);
            AppMethodBeat.m2505o(62344);
            return;
        }
        AppMethodBeat.m2505o(62344);
    }

    /* renamed from: dN */
    public static String m5224dN(String str, String str2) {
        AppMethodBeat.m2504i(62345);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(62345);
            return str2;
        }
        AppMethodBeat.m2505o(62345);
        return str;
    }

    /* renamed from: w */
    public static boolean m5225w(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(62346);
        if (emojiInfo == null || !C2933b.m5219JX(emojiInfo.field_groupId)) {
            AppMethodBeat.m2505o(62346);
            return false;
        }
        AppMethodBeat.m2505o(62346);
        return true;
    }

    /* renamed from: JX */
    public static boolean m5219JX(String str) {
        AppMethodBeat.m2504i(62347);
        if (C5046bo.isNullOrNil(str) || C5046bo.isEqual(str, "capture") || C5046bo.isEqual(str, EmojiGroupInfo.yar)) {
            AppMethodBeat.m2505o(62347);
            return false;
        }
        AppMethodBeat.m2505o(62347);
        return true;
    }

    /* renamed from: y */
    public static boolean m5227y(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(62349);
        if (emojiInfo == null) {
            AppMethodBeat.m2505o(62349);
            return false;
        } else if (!C26072e.m41628OW()) {
            AppMethodBeat.m2505o(62349);
            return false;
        } else if (C2933b.m5226x(emojiInfo) || (emojiInfo.field_activityid != null && emojiInfo.field_activityid.startsWith("Selfie"))) {
            AppMethodBeat.m2505o(62349);
            return true;
        } else {
            AppMethodBeat.m2505o(62349);
            return false;
        }
    }

    /* renamed from: JY */
    public static boolean m5220JY(String str) {
        AppMethodBeat.m2504i(62350);
        if (C5046bo.isNullOrNil(str) || C5046bo.isEqual(str, "capture")) {
            AppMethodBeat.m2505o(62350);
            return false;
        }
        AppMethodBeat.m2505o(62350);
        return true;
    }

    /* renamed from: x */
    public static boolean m5226x(EmojiInfo emojiInfo) {
        AppMethodBeat.m2504i(62348);
        boolean isEqual = C5046bo.isEqual(emojiInfo.field_groupId, "capture");
        AppMethodBeat.m2505o(62348);
        return isEqual;
    }
}
