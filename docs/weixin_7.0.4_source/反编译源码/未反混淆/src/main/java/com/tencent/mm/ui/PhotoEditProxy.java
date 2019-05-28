package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.m;
import com.tencent.mm.at.l;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.fav.a.ad;
import com.tencent.mm.remoteservice.a;
import com.tencent.mm.remoteservice.d;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac;

public class PhotoEditProxy extends a {
    public PhotoEditProxy(d dVar) {
        super(dVar);
    }

    public int doFav(String str) {
        AppMethodBeat.i(11944);
        int intValue = ((Integer) REMOTE_CALL("doFavInMM", str)).intValue();
        AppMethodBeat.o(11944);
        return intValue;
    }

    public void sendImage(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(11945);
        REMOTE_CALL("sendImageInMM", str, str2, str3, str4);
        AppMethodBeat.o(11945);
    }

    public boolean isAutoSave() {
        AppMethodBeat.i(11946);
        boolean booleanValue = ((Boolean) REMOTE_CALL("isAutoSavePhotoInMM", new Object[0])).booleanValue();
        AppMethodBeat.o(11946);
        return booleanValue;
    }

    public String getSelfUsername() {
        AppMethodBeat.i(11947);
        String str = (String) REMOTE_CALL("getSelfUsernameInMM", new Object[0]);
        AppMethodBeat.o(11947);
        return str;
    }

    public String getFullPath(String str) {
        AppMethodBeat.i(11948);
        String str2 = (String) REMOTE_CALL("getFullPathInMM", str);
        AppMethodBeat.o(11948);
        return str2;
    }

    public void recordImage(String str, String str2, long j, String str3, String str4) {
        AppMethodBeat.i(11949);
        REMOTE_CALL("recordImageInMM", str, str2, Long.valueOf(j), str3, str4);
        AppMethodBeat.o(11949);
    }

    public void recordVideo(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(11950);
        REMOTE_CALL("recordVideoInMM", str, str2, str3, str4);
        AppMethodBeat.o(11950);
    }

    @f
    public void sendImageInMM(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(11951);
        m lVar = new l(4, str3, str4, str2, 0, null, 0, "", "", true, R.drawable.b0p);
        g.RQ();
        g.Rg().a(lVar, 0);
        com.tencent.mm.plugin.messenger.a.g.bOk().eZ(str, str4);
        AppMethodBeat.o(11951);
    }

    @f
    public String getSelfUsernameInMM() {
        AppMethodBeat.i(11952);
        String Yz = r.Yz();
        AppMethodBeat.o(11952);
        return Yz;
    }

    @f
    public boolean isAutoSavePhotoInMM() {
        AppMethodBeat.i(11953);
        boolean z = g.RP().Ry().getBoolean(ac.a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN, true);
        AppMethodBeat.o(11953);
        return z;
    }

    @f
    public int doFavInMM(String str) {
        AppMethodBeat.i(11954);
        cl clVar = new cl();
        ((ad) g.K(ad.class)).a(clVar, 2, str);
        clVar.cvA.cvH = 44;
        com.tencent.mm.sdk.b.a.xxA.m(clVar);
        ab.i("MicroMsg.PhotoEditProxy", "[doFavInMM] path:%s", str);
        int i = clVar.cvB.ret;
        AppMethodBeat.o(11954);
        return i;
    }

    @f
    public String getFullPathInMM(String str) {
        AppMethodBeat.i(11955);
        String fullPath = o.ahl().getFullPath(str);
        AppMethodBeat.o(11955);
        return fullPath;
    }

    @f
    public void recordImageInMM(String str, String str2, long j, String str3, String str4) {
        AppMethodBeat.i(11956);
        ((com.tencent.mm.api.o) g.K(com.tencent.mm.api.o.class)).recordImage(str, str2, j, str3, str4);
        AppMethodBeat.o(11956);
    }

    @f
    public void recordVideoInMM(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(11957);
        ((com.tencent.mm.api.o) g.K(com.tencent.mm.api.o.class)).recordVideo(str, str2, str3, str4);
        AppMethodBeat.o(11957);
    }
}
