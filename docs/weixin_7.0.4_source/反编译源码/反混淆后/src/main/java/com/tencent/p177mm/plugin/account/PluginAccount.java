package com.tencent.p177mm.plugin.account;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p842bp.C9204c;
import com.tencent.p177mm.platformtools.C26529w;
import com.tencent.p177mm.platformtools.C32889i;
import com.tencent.p177mm.platformtools.C42257z;
import com.tencent.p177mm.platformtools.C45474a;
import com.tencent.p177mm.plugin.account.friend.p272a.C18818b;
import com.tencent.p177mm.plugin.account.friend.p272a.C18820h;
import com.tencent.p177mm.plugin.account.friend.p272a.C26585an;
import com.tencent.p177mm.plugin.account.friend.p272a.C26586k;
import com.tencent.p177mm.plugin.account.friend.p272a.C38036o;
import com.tencent.p177mm.plugin.account.friend.p272a.C45496ap;
import com.tencent.p177mm.plugin.account.friend.p272a.C9880q;
import com.tencent.p177mm.plugin.account.model.C32978j;
import com.tencent.p177mm.plugin.account.p765a.p766a.C45491b;
import com.tencent.p177mm.plugin.account.p765a.p766a.C7599a;
import com.tencent.p177mm.plugin.account.security.p880a.C45501g;
import com.tencent.p177mm.protocal.protobuf.aym;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.account.PluginAccount */
public class PluginAccount extends C7597f implements C7599a {
    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(124596);
        C9204c.aks("account");
        pin(new C7485q(C32978j.class));
        pin(new C7485q(C32923a.class));
        pin(new C7485q(C45501g.class));
        C4990ab.m7416i("MicroMsg.PluginAccount", "execute PluginAccount");
        AppMethodBeat.m2505o(124596);
    }

    public C18818b getAddrUploadStg() {
        AppMethodBeat.m2504i(124597);
        C18818b addrUploadStg = C32923a.getAddrUploadStg();
        AppMethodBeat.m2505o(124597);
        return addrUploadStg;
    }

    public C18820h getFacebookFrdStg() {
        AppMethodBeat.m2504i(124598);
        C18820h facebookFrdStg = C32923a.getFacebookFrdStg();
        AppMethodBeat.m2505o(124598);
        return facebookFrdStg;
    }

    public C26586k getFrdExtStg() {
        AppMethodBeat.m2504i(124599);
        C26586k frdExtStg = C32923a.getFrdExtStg();
        AppMethodBeat.m2505o(124599);
        return frdExtStg;
    }

    public C26585an getQQGroupStg() {
        AppMethodBeat.m2504i(124600);
        C26585an qQGroupStg = C32923a.getQQGroupStg();
        AppMethodBeat.m2505o(124600);
        return qQGroupStg;
    }

    public C9880q getInviteFriendOpenStg() {
        AppMethodBeat.m2504i(124601);
        C9880q inviteFriendOpenStg = C32923a.getInviteFriendOpenStg();
        AppMethodBeat.m2505o(124601);
        return inviteFriendOpenStg;
    }

    public C45496ap getQQListStg() {
        AppMethodBeat.m2504i(124602);
        C45496ap qQListStg = C32923a.getQQListStg();
        AppMethodBeat.m2505o(124602);
        return qQListStg;
    }

    public C38036o getGoogleFriendStorage() {
        AppMethodBeat.m2504i(124603);
        C38036o googleFriendStorage = C32923a.getGoogleFriendStorage();
        AppMethodBeat.m2505o(124603);
        return googleFriendStorage;
    }

    public void setFriendData(LinkedList linkedList) {
        AppMethodBeat.m2504i(124604);
        C32923a.setFriendData(linkedList);
        AppMethodBeat.m2505o(124604);
    }

    public LinkedList<aym> getFriendData() {
        AppMethodBeat.m2504i(124605);
        LinkedList friendData = C32923a.getFriendData();
        AppMethodBeat.m2505o(124605);
        return friendData;
    }

    public void clearFriendData() {
        AppMethodBeat.m2504i(124606);
        C32923a.clearFriendData();
        AppMethodBeat.m2505o(124606);
    }

    public void syncAddrBookAndUpload() {
        AppMethodBeat.m2504i(124607);
        C4996ah.getContext();
        C45474a.anC();
        AppMethodBeat.m2505o(124607);
    }

    public void showAddrBookUploadConfirm(Activity activity, Runnable runnable, boolean z, int i) {
        AppMethodBeat.m2504i(124608);
        C42257z.showAddrBookUploadConfirm(activity, runnable, z, i);
        AppMethodBeat.m2505o(124608);
    }

    public void removeSelfAccount(Context context) {
        AppMethodBeat.m2504i(124609);
        C26529w.m42357cn(context);
        AppMethodBeat.m2505o(124609);
    }

    public String getPhoneNum(Context context, String str) {
        AppMethodBeat.m2504i(124610);
        String phoneNum = C32889i.getPhoneNum(context, str);
        AppMethodBeat.m2505o(124610);
        return phoneNum;
    }

    public void syncUploadMContactStatus(boolean z, boolean z2) {
        AppMethodBeat.m2504i(124611);
        C42257z.syncUploadMContactStatus(z, z2);
        AppMethodBeat.m2505o(124611);
    }

    public boolean syncAddrBook(C45491b c45491b) {
        AppMethodBeat.m2504i(124612);
        boolean syncAddrBook = C45474a.syncAddrBook(c45491b);
        AppMethodBeat.m2505o(124612);
        return syncAddrBook;
    }

    public void updateAllContact() {
        AppMethodBeat.m2504i(124613);
        C26529w.m42358co(C4996ah.getContext());
        AppMethodBeat.m2505o(124613);
    }
}
