package com.tencent.mm.plugin.account;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.account.friend.a.an;
import com.tencent.mm.plugin.account.friend.a.ap;
import com.tencent.mm.plugin.account.friend.a.b;
import com.tencent.mm.plugin.account.friend.a.h;
import com.tencent.mm.plugin.account.friend.a.k;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.plugin.account.model.j;
import com.tencent.mm.protocal.protobuf.aym;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.LinkedList;

public class PluginAccount extends f implements a {
    public void execute(g gVar) {
        AppMethodBeat.i(124596);
        c.aks("account");
        pin(new q(j.class));
        pin(new q(a.class));
        pin(new q(com.tencent.mm.plugin.account.security.a.g.class));
        ab.i("MicroMsg.PluginAccount", "execute PluginAccount");
        AppMethodBeat.o(124596);
    }

    public b getAddrUploadStg() {
        AppMethodBeat.i(124597);
        b addrUploadStg = a.getAddrUploadStg();
        AppMethodBeat.o(124597);
        return addrUploadStg;
    }

    public h getFacebookFrdStg() {
        AppMethodBeat.i(124598);
        h facebookFrdStg = a.getFacebookFrdStg();
        AppMethodBeat.o(124598);
        return facebookFrdStg;
    }

    public k getFrdExtStg() {
        AppMethodBeat.i(124599);
        k frdExtStg = a.getFrdExtStg();
        AppMethodBeat.o(124599);
        return frdExtStg;
    }

    public an getQQGroupStg() {
        AppMethodBeat.i(124600);
        an qQGroupStg = a.getQQGroupStg();
        AppMethodBeat.o(124600);
        return qQGroupStg;
    }

    public com.tencent.mm.plugin.account.friend.a.q getInviteFriendOpenStg() {
        AppMethodBeat.i(124601);
        com.tencent.mm.plugin.account.friend.a.q inviteFriendOpenStg = a.getInviteFriendOpenStg();
        AppMethodBeat.o(124601);
        return inviteFriendOpenStg;
    }

    public ap getQQListStg() {
        AppMethodBeat.i(124602);
        ap qQListStg = a.getQQListStg();
        AppMethodBeat.o(124602);
        return qQListStg;
    }

    public o getGoogleFriendStorage() {
        AppMethodBeat.i(124603);
        o googleFriendStorage = a.getGoogleFriendStorage();
        AppMethodBeat.o(124603);
        return googleFriendStorage;
    }

    public void setFriendData(LinkedList linkedList) {
        AppMethodBeat.i(124604);
        a.setFriendData(linkedList);
        AppMethodBeat.o(124604);
    }

    public LinkedList<aym> getFriendData() {
        AppMethodBeat.i(124605);
        LinkedList friendData = a.getFriendData();
        AppMethodBeat.o(124605);
        return friendData;
    }

    public void clearFriendData() {
        AppMethodBeat.i(124606);
        a.clearFriendData();
        AppMethodBeat.o(124606);
    }

    public void syncAddrBookAndUpload() {
        AppMethodBeat.i(124607);
        ah.getContext();
        com.tencent.mm.platformtools.a.anC();
        AppMethodBeat.o(124607);
    }

    public void showAddrBookUploadConfirm(Activity activity, Runnable runnable, boolean z, int i) {
        AppMethodBeat.i(124608);
        z.showAddrBookUploadConfirm(activity, runnable, z, i);
        AppMethodBeat.o(124608);
    }

    public void removeSelfAccount(Context context) {
        AppMethodBeat.i(124609);
        w.cn(context);
        AppMethodBeat.o(124609);
    }

    public String getPhoneNum(Context context, String str) {
        AppMethodBeat.i(124610);
        String phoneNum = i.getPhoneNum(context, str);
        AppMethodBeat.o(124610);
        return phoneNum;
    }

    public void syncUploadMContactStatus(boolean z, boolean z2) {
        AppMethodBeat.i(124611);
        z.syncUploadMContactStatus(z, z2);
        AppMethodBeat.o(124611);
    }

    public boolean syncAddrBook(com.tencent.mm.plugin.account.a.a.b bVar) {
        AppMethodBeat.i(124612);
        boolean syncAddrBook = com.tencent.mm.platformtools.a.syncAddrBook(bVar);
        AppMethodBeat.o(124612);
        return syncAddrBook;
    }

    public void updateAllContact() {
        AppMethodBeat.i(124613);
        w.co(ah.getContext());
        AppMethodBeat.o(124613);
    }
}
