package com.tencent.p177mm.emoji.loader.p848c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\tHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001e"}, dWq = {"Lcom/tencent/mm/emoji/loader/fetcher/EmojiFetcherConfig;", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "url", "", "path", "authKey", "fetcherType", "", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getAuthKey", "()Ljava/lang/String;", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "getFetcherType", "()I", "getPath", "getUrl", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.loader.c.d */
public final class C26078d {
    final EmojiInfo exP;
    final String exQ;
    final int exR;
    final String path;
    final String url;

    /* JADX WARNING: Missing block: B:15:0x003f, code skipped:
            if ((r5.exR == r6.exR) != false) goto L_0x0041;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(63184);
        if (this != obj) {
            if (obj instanceof C26078d) {
                C26078d c26078d = (C26078d) obj;
                if (C25052j.m39373j(this.exP, c26078d.exP) && C25052j.m39373j(this.url, c26078d.url) && C25052j.m39373j(this.path, c26078d.path) && C25052j.m39373j(this.exQ, c26078d.exQ)) {
                }
            }
            AppMethodBeat.m2505o(63184);
            return false;
        }
        AppMethodBeat.m2505o(63184);
        return true;
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.m2504i(63183);
        EmojiInfo emojiInfo = this.exP;
        int hashCode = (emojiInfo != null ? emojiInfo.hashCode() : 0) * 31;
        String str = this.url;
        hashCode = ((str != null ? str.hashCode() : 0) + hashCode) * 31;
        str = this.path;
        int hashCode2 = ((str != null ? str.hashCode() : 0) + hashCode) * 31;
        String str2 = this.exQ;
        if (str2 != null) {
            i = str2.hashCode();
        }
        hashCode2 = ((hashCode2 + i) * 31) + this.exR;
        AppMethodBeat.m2505o(63183);
        return hashCode2;
    }

    public final String toString() {
        AppMethodBeat.m2504i(63182);
        String str = "EmojiFetcherConfig(emojiInfo=" + this.exP + ", url=" + this.url + ", path=" + this.path + ", authKey=" + this.exQ + ", fetcherType=" + this.exR + ")";
        AppMethodBeat.m2505o(63182);
        return str;
    }

    public C26078d(EmojiInfo emojiInfo, String str, String str2, String str3, int i) {
        C25052j.m39376p(emojiInfo, "emojiInfo");
        C25052j.m39376p(str, "url");
        C25052j.m39376p(str2, "path");
        C25052j.m39376p(str3, "authKey");
        AppMethodBeat.m2504i(63181);
        this.exP = emojiInfo;
        this.url = str;
        this.path = str2;
        this.exQ = str3;
        this.exR = i;
        AppMethodBeat.m2505o(63181);
    }
}
