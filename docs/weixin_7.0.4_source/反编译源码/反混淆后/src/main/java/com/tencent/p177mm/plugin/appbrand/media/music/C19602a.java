package com.tencent.p177mm.plugin.appbrand.media.music;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p198aw.C37494a;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.media.music.a */
public final class C19602a {
    public String cBb;
    public int cBc;
    public String cwz;
    private HashMap<String, C4884c> fBy;
    public String ikS;
    public String ikT;

    /* renamed from: com.tencent.mm.plugin.appbrand.media.music.a$a */
    public static class C19601a {
        private static C19602a ikU = new C19602a();

        static {
            AppMethodBeat.m2504i(137836);
            AppMethodBeat.m2505o(137836);
        }
    }

    /* synthetic */ C19602a(byte b) {
        this();
    }

    private C19602a() {
        AppMethodBeat.m2504i(137837);
        this.fBy = new HashMap();
        AppMethodBeat.m2505o(137837);
    }

    /* renamed from: cD */
    public final boolean mo34809cD(String str, String str2) {
        AppMethodBeat.m2504i(137838);
        if (str2.equalsIgnoreCase("play")) {
            C4990ab.m7417i("MicroMsg.AppBrandMusicPlayerManager", "play option appid %s, pre appid %s", str, this.ikS);
            AppMethodBeat.m2505o(137838);
            return true;
        }
        if (str.equalsIgnoreCase(this.ikS)) {
            C9058e aih = C37494a.aih();
            if (aih != null && aih.fJU.equals(this.ikT)) {
                AppMethodBeat.m2505o(137838);
                return true;
            }
        }
        AppMethodBeat.m2505o(137838);
        return false;
    }

    /* renamed from: a */
    public final void mo34808a(C4884c c4884c, String str) {
        AppMethodBeat.m2504i(137839);
        if (this.fBy.get(str) != null) {
            C4990ab.m7417i("MicroMsg.AppBrandMusicPlayerManager", "listeners already add appid: %s", str);
            AppMethodBeat.m2505o(137839);
            return;
        }
        C4879a.xxA.mo10052c(c4884c);
        this.fBy.put(str, c4884c);
        AppMethodBeat.m2505o(137839);
    }

    /* renamed from: Cv */
    public final void mo34806Cv(String str) {
        AppMethodBeat.m2504i(137840);
        if (this.fBy.get(str) == null) {
            C4990ab.m7417i("MicroMsg.AppBrandMusicPlayerManager", "listeners already remove appid: %s", str);
            AppMethodBeat.m2505o(137840);
            return;
        }
        C4879a.xxA.mo10053d((C4884c) this.fBy.remove(str));
        this.fBy.remove(str);
        AppMethodBeat.m2505o(137840);
    }

    /* renamed from: Cw */
    public final boolean mo34807Cw(String str) {
        AppMethodBeat.m2504i(137841);
        if (TextUtils.isEmpty(str)) {
            C4990ab.m7412e("MicroMsg.AppBrandMusicPlayerManager", "appId is empty");
            AppMethodBeat.m2505o(137841);
            return false;
        } else if (!str.equalsIgnoreCase(this.ikS)) {
            C4990ab.m7412e("MicroMsg.AppBrandMusicPlayerManager", "appId is not equals pre play id");
            AppMethodBeat.m2505o(137841);
            return false;
        } else if (TextUtils.isEmpty(this.ikT)) {
            C4990ab.m7412e("MicroMsg.AppBrandMusicPlayerManager", "now app not play music");
            AppMethodBeat.m2505o(137841);
            return false;
        } else {
            C9058e aih = C37494a.aih();
            if (aih == null) {
                C4990ab.m7412e("MicroMsg.AppBrandMusicPlayerManager", "wrapper is null");
                AppMethodBeat.m2505o(137841);
                return false;
            } else if (!this.ikT.equalsIgnoreCase(aih.fJU)) {
                C4990ab.m7412e("MicroMsg.AppBrandMusicPlayerManager", "musicId is diff");
                AppMethodBeat.m2505o(137841);
                return false;
            } else if (C37494a.aie()) {
                AppMethodBeat.m2505o(137841);
                return true;
            } else {
                C4990ab.m7416i("MicroMsg.AppBrandMusicPlayerManager", "MusicHelper.isPlayingMusic FALSE");
                AppMethodBeat.m2505o(137841);
                return false;
            }
        }
    }
}
