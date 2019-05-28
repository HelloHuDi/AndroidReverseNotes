package com.tencent.mm.plugin.music.h;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.e;
import com.tencent.mm.plugin.music.cache.g;
import com.tencent.mm.plugin.music.cache.i;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;

public final class d {
    public static void M(e eVar) {
        AppMethodBeat.i(137698);
        if (eVar == null) {
            ab.e("MicroMsg.Music.MusicUrlParser", "GetShakeMusicUrl, musicWrapper is null");
            AppMethodBeat.o(137698);
            return;
        }
        int i;
        boolean z;
        boolean isWifi = at.isWifi(ah.getContext());
        boolean isNetworkConnected = at.isNetworkConnected(ah.getContext());
        PBool pBool = new PBool();
        String str = bo.isNullOrNil(eVar.fKa) ? eVar.fKc : eVar.fKa;
        String str2 = eVar.fKb;
        String a = e.a(str, str2, isWifi, pBool);
        ab.i("MicroMsg.Music.MusicUrlParser", "parsePlayUrl mSrc:%s", a);
        ab.i("MicroMsg.Music.MusicUrlParser", "songWifiUrl:%s", eVar.fKa);
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
        ab.i(str3, str4, objArr);
        if (isWifi) {
            z = pBool.value;
        } else {
            z = false;
        }
        if (e.Tw(a)) {
            ab.i("MicroMsg.Music.MusicUrlParser", "can match shake music wifi url");
            z = true;
        }
        str3 = "";
        if (!isNetworkConnected) {
            ab.i("MicroMsg.Music.MusicUrlParser", "isNetConnected false, detect right Url to play");
            String a2 = e.a(str, str2, true, pBool);
            str = e.a(str, str2, false, pBool);
            if (a2 == null || !a2.equals(str)) {
                if (c.L(eVar)) {
                    ab.i("MicroMsg.Music.MusicUrlParser", "use exoMusicPlayer");
                } else if (c.zX(eVar.fJS)) {
                    ab.i("MicroMsg.Music.MusicUrlParser", "use qqMusicPlayer");
                    if (i.Tf(a2)) {
                        str3 = a2;
                    } else if (i.Tf(str)) {
                        str3 = str;
                    }
                } else {
                    if (d(eVar, true)) {
                        str = a2;
                    } else if (!d(eVar, false)) {
                        str = str3;
                    }
                    ab.i("MicroMsg.Music.MusicUrlParser", "use musicPlayer");
                    str3 = str;
                }
            }
            if (!(TextUtils.isEmpty(str3) || str3.equals(a))) {
                ab.i("MicroMsg.Music.MusicUrlParser", "reset the mSrc :%s", str3);
                eVar.playUrl = str3;
                g.aV(str3, z);
                AppMethodBeat.o(137698);
            }
        }
        str3 = a;
        eVar.playUrl = str3;
        g.aV(str3, z);
        AppMethodBeat.o(137698);
    }

    private static boolean d(e eVar, boolean z) {
        AppMethodBeat.i(137699);
        File file = new File(b.aW(b.K(eVar), z));
        if (!file.exists() || file.length() <= 0) {
            AppMethodBeat.o(137699);
            return false;
        }
        AppMethodBeat.o(137699);
        return true;
    }
}
