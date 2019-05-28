package com.tencent.p177mm.plugin.music.model.p1000e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.p230g.p711c.C45395db;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.music.model.e.a */
public final class C28575a extends C45395db {
    public static C4924a ccO = C45395db.m83583Hm();
    public String fKs;
    public String playUrl;

    static {
        AppMethodBeat.m2504i(105033);
        AppMethodBeat.m2505o(105033);
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public final boolean bUu() {
        return (this.field_songBgColor == 0 || this.field_songLyricColor == 0) ? false : true;
    }

    public final boolean bUv() {
        AppMethodBeat.m2504i(105030);
        if (C5046bo.isNullOrNil(this.field_songHAlbumUrl)) {
            AppMethodBeat.m2505o(105030);
            return false;
        }
        AppMethodBeat.m2505o(105030);
        return true;
    }

    /* renamed from: w */
    public final boolean mo46709w(int[] iArr) {
        return this.field_songBgColor == iArr[0] && this.field_songLyricColor == iArr[1];
    }

    /* renamed from: g */
    public final boolean mo46708g(C28575a c28575a) {
        AppMethodBeat.m2504i(105031);
        if (c28575a == null) {
            AppMethodBeat.m2505o(105031);
            return false;
        }
        boolean equals = this.field_musicId.equals(c28575a.field_musicId);
        AppMethodBeat.m2505o(105031);
        return equals;
    }

    public final C9058e bUw() {
        AppMethodBeat.m2504i(105032);
        C9058e c9058e = new C9058e();
        c9058e.fJU = this.field_originMusicId;
        c9058e.fJS = this.field_musicType;
        c9058e.fKh = this.field_appId;
        c9058e.fJY = this.field_songAlbum;
        c9058e.fKi = this.field_songAlbumType;
        c9058e.fJZ = this.field_songAlbumUrl;
        c9058e.fKa = this.field_songWifiUrl;
        c9058e.fJW = this.field_songName;
        c9058e.fJX = this.field_songSinger;
        c9058e.fKb = this.field_songWapLinkUrl;
        c9058e.fKc = this.field_songWebUrl;
        c9058e.fKe = this.field_songAlbumLocalPath;
        c9058e.fKk = this.field_songMediaId;
        c9058e.fKm = this.field_songSnsAlbumUser;
        c9058e.fKo = this.field_songSnsShareUser;
        c9058e.fKq = this.field_hideBanner;
        c9058e.fKr = this.field_jsWebUrlDomain;
        c9058e.startTime = this.field_startTime;
        c9058e.fKs = this.fKs;
        c9058e.protocol = this.field_protocol;
        c9058e.fKt = this.field_barBackToWebView;
        c9058e.fKu = this.field_musicbar_url;
        c9058e.playUrl = this.playUrl;
        AppMethodBeat.m2505o(105032);
        return c9058e;
    }
}
