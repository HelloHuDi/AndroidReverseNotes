package com.tencent.p177mm.p612ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.api.C45153o;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.C9022l;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.plugin.fav.p407a.C6893ad;
import com.tencent.p177mm.plugin.messenger.p993a.C12519g;
import com.tencent.p177mm.remoteservice.C31577a;
import com.tencent.p177mm.remoteservice.C46607d;
import com.tencent.p177mm.remoteservice.C46608f;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.ui.PhotoEditProxy */
public class PhotoEditProxy extends C31577a {
    public PhotoEditProxy(C46607d c46607d) {
        super(c46607d);
    }

    public int doFav(String str) {
        AppMethodBeat.m2504i(11944);
        int intValue = ((Integer) REMOTE_CALL("doFavInMM", str)).intValue();
        AppMethodBeat.m2505o(11944);
        return intValue;
    }

    public void sendImage(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(11945);
        REMOTE_CALL("sendImageInMM", str, str2, str3, str4);
        AppMethodBeat.m2505o(11945);
    }

    public boolean isAutoSave() {
        AppMethodBeat.m2504i(11946);
        boolean booleanValue = ((Boolean) REMOTE_CALL("isAutoSavePhotoInMM", new Object[0])).booleanValue();
        AppMethodBeat.m2505o(11946);
        return booleanValue;
    }

    public String getSelfUsername() {
        AppMethodBeat.m2504i(11947);
        String str = (String) REMOTE_CALL("getSelfUsernameInMM", new Object[0]);
        AppMethodBeat.m2505o(11947);
        return str;
    }

    public String getFullPath(String str) {
        AppMethodBeat.m2504i(11948);
        String str2 = (String) REMOTE_CALL("getFullPathInMM", str);
        AppMethodBeat.m2505o(11948);
        return str2;
    }

    public void recordImage(String str, String str2, long j, String str3, String str4) {
        AppMethodBeat.m2504i(11949);
        REMOTE_CALL("recordImageInMM", str, str2, Long.valueOf(j), str3, str4);
        AppMethodBeat.m2505o(11949);
    }

    public void recordVideo(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(11950);
        REMOTE_CALL("recordVideoInMM", str, str2, str3, str4);
        AppMethodBeat.m2505o(11950);
    }

    @C46608f
    public void sendImageInMM(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(11951);
        C1207m c9022l = new C9022l(4, str3, str4, str2, 0, null, 0, "", "", true, C25738R.drawable.b0p);
        C1720g.m3537RQ();
        C1720g.m3540Rg().mo14541a(c9022l, 0);
        C12519g.bOk().mo46461eZ(str, str4);
        AppMethodBeat.m2505o(11951);
    }

    @C46608f
    public String getSelfUsernameInMM() {
        AppMethodBeat.m2504i(11952);
        String Yz = C1853r.m3846Yz();
        AppMethodBeat.m2505o(11952);
        return Yz;
    }

    @C46608f
    public boolean isAutoSavePhotoInMM() {
        AppMethodBeat.m2504i(11953);
        boolean z = C1720g.m3536RP().mo5239Ry().getBoolean(C5127a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN, true);
        AppMethodBeat.m2505o(11953);
        return z;
    }

    @C46608f
    public int doFavInMM(String str) {
        AppMethodBeat.m2504i(11954);
        C45316cl c45316cl = new C45316cl();
        ((C6893ad) C1720g.m3528K(C6893ad.class)).mo15151a(c45316cl, 2, str);
        c45316cl.cvA.cvH = 44;
        C4879a.xxA.mo10055m(c45316cl);
        C4990ab.m7417i("MicroMsg.PhotoEditProxy", "[doFavInMM] path:%s", str);
        int i = c45316cl.cvB.ret;
        AppMethodBeat.m2505o(11954);
        return i;
    }

    @C46608f
    public String getFullPathInMM(String str) {
        AppMethodBeat.m2504i(11955);
        String fullPath = C32291o.ahl().getFullPath(str);
        AppMethodBeat.m2505o(11955);
        return fullPath;
    }

    @C46608f
    public void recordImageInMM(String str, String str2, long j, String str3, String str4) {
        AppMethodBeat.m2504i(11956);
        ((C45153o) C1720g.m3528K(C45153o.class)).recordImage(str, str2, j, str3, str4);
        AppMethodBeat.m2505o(11956);
    }

    @C46608f
    public void recordVideoInMM(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(11957);
        ((C45153o) C1720g.m3528K(C45153o.class)).recordVideo(str, str2, str3, str4);
        AppMethodBeat.m2505o(11957);
    }
}
