package com.tencent.mm.emoji.loader.f;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.smtt.sdk.TbsReaderView;

@l(dWo = {1, 1, 13}, dWp = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0019\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\fHÆ\u0003JO\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010!\u001a\u00020\u00072\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\fHÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006%"}, dWq = {"Lcom/tencent/mm/emoji/loader/verify/EmojiVerifyConfig;", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "verifyMd5", "", "needDecrypt", "", "aesKey", "path", "tempPath", "fetcherType", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAesKey", "()Ljava/lang/String;", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getFetcherType", "()I", "getNeedDecrypt", "()Z", "getPath", "getTempPath", "getVerifyMd5", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "plugin-emojisdk_release"})
public final class b {
    final EmojiInfo exP;
    final int exR;
    final String eyp;
    final boolean eyq;
    final String eyr;
    final String eys;
    final String path;

    /* JADX WARNING: Missing block: B:21:0x0052, code skipped:
            if ((r5.exR == r6.exR) != false) goto L_0x0054;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        AppMethodBeat.i(63234);
        if (this != obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (j.j(this.exP, bVar.exP) && j.j(this.eyp, bVar.eyp)) {
                    if ((this.eyq == bVar.eyq) && j.j(this.eyr, bVar.eyr) && j.j(this.path, bVar.path) && j.j(this.eys, bVar.eys)) {
                    }
                }
            }
            AppMethodBeat.o(63234);
            return false;
        }
        AppMethodBeat.o(63234);
        return true;
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.i(63233);
        EmojiInfo emojiInfo = this.exP;
        int hashCode = (emojiInfo != null ? emojiInfo.hashCode() : 0) * 31;
        String str = this.eyp;
        hashCode = ((str != null ? str.hashCode() : 0) + hashCode) * 31;
        int i2 = this.eyq;
        if (i2 != 0) {
            i2 = 1;
        }
        hashCode = (i2 + hashCode) * 31;
        str = this.eyr;
        hashCode = ((str != null ? str.hashCode() : 0) + hashCode) * 31;
        str = this.path;
        i2 = ((str != null ? str.hashCode() : 0) + hashCode) * 31;
        String str2 = this.eys;
        if (str2 != null) {
            i = str2.hashCode();
        }
        i2 = ((i2 + i) * 31) + this.exR;
        AppMethodBeat.o(63233);
        return i2;
    }

    public final String toString() {
        AppMethodBeat.i(63232);
        String str = "EmojiVerifyConfig(emojiInfo=" + this.exP + ", verifyMd5=" + this.eyp + ", needDecrypt=" + this.eyq + ", aesKey=" + this.eyr + ", path=" + this.path + ", tempPath=" + this.eys + ", fetcherType=" + this.exR + ")";
        AppMethodBeat.o(63232);
        return str;
    }

    public b(EmojiInfo emojiInfo, String str, boolean z, String str2, String str3, String str4, int i) {
        j.p(emojiInfo, "emojiInfo");
        j.p(str, "verifyMd5");
        j.p(str2, "aesKey");
        j.p(str3, "path");
        j.p(str4, TbsReaderView.KEY_TEMP_PATH);
        AppMethodBeat.i(63231);
        this.exP = emojiInfo;
        this.eyp = str;
        this.eyq = z;
        this.eyr = str2;
        this.path = str3;
        this.eys = str4;
        this.exR = i;
        AppMethodBeat.o(63231);
    }
}
