package com.tencent.p177mm.plugin.music.model.p1000e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.memory.p259a.C7598c;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.plugin.music.model.C28571a;
import com.tencent.p177mm.plugin.music.model.C39444d;
import com.tencent.p177mm.plugin.music.p997h.C12673b;
import com.tencent.p177mm.plugin.music.p997h.C46101e;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.music.model.e.b */
public final class C12680b extends C7563j<C28575a> {
    public C4927e bSd;
    public C1177f<String, C28575a> oNq = new C7598c(20);
    public C1177f<String, C28571a> oNr = new C7598c(10);

    public C12680b(C4927e c4927e) {
        super(c4927e, C28575a.ccO, "Music", null);
        AppMethodBeat.m2504i(105034);
        this.bSd = c4927e;
        AppMethodBeat.m2505o(105034);
    }

    /* renamed from: Tp */
    public final C28575a mo24653Tp(String str) {
        AppMethodBeat.m2504i(105035);
        C28575a c28575a;
        if (this.oNq.get(str) != null) {
            c28575a = (C28575a) this.oNq.get(str);
            AppMethodBeat.m2505o(105035);
            return c28575a;
        }
        String format = String.format("Select * From Music Where musicId=?", new Object[0]);
        Cursor a = this.bSd.mo10104a(format, new String[]{str}, 2);
        if (a == null || !a.moveToFirst()) {
            if (a != null) {
                a.close();
            }
            AppMethodBeat.m2505o(105035);
            return null;
        }
        c28575a = new C28575a();
        c28575a.mo8995d(a);
        a.close();
        this.oNq.put(str, c28575a);
        AppMethodBeat.m2505o(105035);
        return c28575a;
    }

    /* renamed from: b */
    public final C28571a mo24655b(C28575a c28575a, boolean z) {
        AppMethodBeat.m2504i(105036);
        C28571a c28571a;
        if (this.oNr.get(c28575a.field_musicId) != null) {
            c28571a = (C28571a) this.oNr.get(c28575a.field_musicId);
            AppMethodBeat.m2505o(105036);
            return c28571a;
        }
        c28571a = mo24656c(c28575a, z);
        AppMethodBeat.m2505o(105036);
        return c28571a;
    }

    /* renamed from: c */
    public final C28571a mo24656c(C28575a c28575a, boolean z) {
        AppMethodBeat.m2504i(105037);
        C28571a a = C28571a.m45375a(c28575a.field_songLyric, C4996ah.getContext().getString(C25738R.string.d43), c28575a.field_songSnsShareUser, C39444d.m67386a(c28575a), c28575a.field_songSinger, z);
        this.oNr.put(c28575a.field_musicId, a);
        AppMethodBeat.m2505o(105037);
        return a;
    }

    /* renamed from: ac */
    public final C28575a mo24654ac(String str, int i, int i2) {
        AppMethodBeat.m2504i(105038);
        C4990ab.m7417i("MicroMsg.Music.MusicStorage", "updateMusicWithColor %s %d %d", str, Integer.valueOf(i), Integer.valueOf(i2));
        C28575a Tp = mo24653Tp(str);
        if (Tp == null) {
            C4990ab.m7413e("MicroMsg.Music.MusicStorage", "updateMusicWithColor can not find music %s", str);
            AppMethodBeat.m2505o(105038);
            return null;
        }
        Tp.field_songBgColor = i;
        Tp.field_songLyricColor = i2;
        mo10103c(Tp, "songBgColor", "songLyricColor");
        this.oNq.put(str, Tp);
        AppMethodBeat.m2505o(105038);
        return Tp;
    }

    /* renamed from: x */
    public final C28575a mo24657x(C9058e c9058e) {
        int i;
        AppMethodBeat.m2504i(105039);
        String K = C12673b.m20670K(c9058e);
        C28575a Tp = mo24653Tp(K);
        if (Tp == null) {
            Tp = new C28575a();
            i = 0;
        } else {
            i = 1;
        }
        Tp.field_musicId = K;
        Tp.field_originMusicId = c9058e.fJU;
        Tp.field_musicType = c9058e.fJS;
        Tp.field_appId = c9058e.fKh;
        if (C5046bo.isNullOrNil(Tp.field_appId)) {
            Tp.field_appId = C39444d.m67390v(c9058e);
        }
        Tp.field_songAlbum = c9058e.fJY;
        Tp.field_songAlbumType = c9058e.fKi;
        Tp.field_songWifiUrl = c9058e.fKa;
        Tp.field_songName = c9058e.fJW;
        Tp.field_songSinger = c9058e.fJX;
        Tp.field_songWapLinkUrl = c9058e.fKb;
        Tp.field_songWebUrl = c9058e.fKc;
        Tp.field_songAlbumLocalPath = c9058e.fKe;
        Tp.field_songMediaId = c9058e.fKk;
        Tp.field_songSnsAlbumUser = c9058e.fKm;
        Tp.field_songAlbumUrl = c9058e.fJZ;
        Tp.field_songSnsShareUser = c9058e.fKo;
        if (!C5046bo.isNullOrNil(c9058e.fKl)) {
            Tp.field_songHAlbumUrl = c9058e.fKl;
        }
        Tp.field_updateTime = System.currentTimeMillis();
        if (Tp.field_songId == 0) {
            C46101e.m86000O(c9058e);
            Tp.field_songId = c9058e.fKj;
        }
        if ((C5046bo.isNullOrNil(Tp.field_songWapLinkUrl) || Tp.field_songWapLinkUrl.equals(Tp.field_songWebUrl)) && !C5046bo.isNullOrNil(Tp.field_songWifiUrl)) {
            Tp.field_songWapLinkUrl = Tp.field_songWifiUrl;
        }
        if (Tp.field_songId == 0 && c9058e.fJS == 4) {
            try {
                Tp.field_songId = Integer.valueOf(c9058e.fJU).intValue();
            } catch (Exception e) {
            }
        }
        Tp.field_hideBanner = c9058e.fKq;
        Tp.field_jsWebUrlDomain = c9058e.fKr;
        Tp.field_startTime = c9058e.startTime;
        Tp.fKs = c9058e.fKs;
        Tp.field_protocol = c9058e.protocol;
        Tp.field_barBackToWebView = c9058e.fKt;
        Tp.field_musicbar_url = c9058e.fKu;
        if (i != 0) {
            C4990ab.m7417i("MicroMsg.Music.MusicStorage", "update music %s", K);
            mo10103c(Tp, new String[0]);
        } else {
            C4990ab.m7417i("MicroMsg.Music.MusicStorage", "insert music %s", K);
            mo10101b((C4925c) Tp);
        }
        this.oNq.put(K, Tp);
        AppMethodBeat.m2505o(105039);
        return Tp;
    }
}
