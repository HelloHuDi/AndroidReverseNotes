package com.tencent.p177mm.plugin.music.p997h;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p198aw.C9058e;
import com.tencent.p177mm.plugin.music.cache.C39433g;
import com.tencent.p177mm.plugin.music.cache.C43323i;
import com.tencent.p177mm.pointers.PBool;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.music.h.d */
public final class C39438d {
    /* renamed from: M */
    public static void m67374M(C9058e c9058e) {
        AppMethodBeat.m2504i(137698);
        if (c9058e == null) {
            C4990ab.m7412e("MicroMsg.Music.MusicUrlParser", "GetShakeMusicUrl, musicWrapper is null");
            AppMethodBeat.m2505o(137698);
            return;
        }
        int i;
        boolean z;
        boolean isWifi = C5023at.isWifi(C4996ah.getContext());
        boolean isNetworkConnected = C5023at.isNetworkConnected(C4996ah.getContext());
        PBool pBool = new PBool();
        String str = C5046bo.isNullOrNil(c9058e.fKa) ? c9058e.fKc : c9058e.fKa;
        String str2 = c9058e.fKb;
        String a = C46101e.m86005a(str, str2, isWifi, pBool);
        C4990ab.m7417i("MicroMsg.Music.MusicUrlParser", "parsePlayUrl mSrc:%s", a);
        C4990ab.m7417i("MicroMsg.Music.MusicUrlParser", "songWifiUrl:%s", c9058e.fKa);
        String str3 = "MicroMsg.Music.MusicUrlParser";
        String str4 = "isWifi:%d, isQQMusic:%d";
        Object[] objArr = new Object[2];
        if (isWifi) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(pBool.value ? 1 : 0);
        C4990ab.m7417i(str3, str4, objArr);
        if (isWifi) {
            z = pBool.value;
        } else {
            z = false;
        }
        if (C46101e.m86001Tw(a)) {
            C4990ab.m7416i("MicroMsg.Music.MusicUrlParser", "can match shake music wifi url");
            z = true;
        }
        str3 = "";
        if (!isNetworkConnected) {
            C4990ab.m7416i("MicroMsg.Music.MusicUrlParser", "isNetConnected false, detect right Url to play");
            String a2 = C46101e.m86005a(str, str2, true, pBool);
            str = C46101e.m86005a(str, str2, false, pBool);
            if (a2 == null || !a2.equals(str)) {
                if (C34585c.m56719L(c9058e)) {
                    C4990ab.m7416i("MicroMsg.Music.MusicUrlParser", "use exoMusicPlayer");
                } else if (C34585c.m56720zX(c9058e.fJS)) {
                    C4990ab.m7416i("MicroMsg.Music.MusicUrlParser", "use qqMusicPlayer");
                    if (C43323i.m77269Tf(a2)) {
                        str3 = a2;
                    } else if (C43323i.m77269Tf(str)) {
                        str3 = str;
                    }
                } else {
                    if (C39438d.m67375d(c9058e, true)) {
                        str = a2;
                    } else if (!C39438d.m67375d(c9058e, false)) {
                        str = str3;
                    }
                    C4990ab.m7416i("MicroMsg.Music.MusicUrlParser", "use musicPlayer");
                    str3 = str;
                }
            }
            if (!(TextUtils.isEmpty(str3) || str3.equals(a))) {
                C4990ab.m7417i("MicroMsg.Music.MusicUrlParser", "reset the mSrc :%s", str3);
                c9058e.playUrl = str3;
                C39433g.m67352aV(str3, z);
                AppMethodBeat.m2505o(137698);
            }
        }
        str3 = a;
        c9058e.playUrl = str3;
        C39433g.m67352aV(str3, z);
        AppMethodBeat.m2505o(137698);
    }

    /* renamed from: d */
    private static boolean m67375d(C9058e c9058e, boolean z) {
        AppMethodBeat.m2504i(137699);
        File file = new File(C12673b.m20673aW(C12673b.m20670K(c9058e), z));
        if (!file.exists() || file.length() <= 0) {
            AppMethodBeat.m2505o(137699);
            return false;
        }
        AppMethodBeat.m2505o(137699);
        return true;
    }
}
