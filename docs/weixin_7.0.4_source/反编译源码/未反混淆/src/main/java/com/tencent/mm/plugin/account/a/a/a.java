package com.tencent.mm.plugin.account.a.a;

import android.app.Activity;
import android.content.Context;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.n;
import java.util.LinkedList;

public interface a extends d {
    void clearFriendData();

    n getAddrUploadStg();

    k getFacebookFrdStg();

    k getFrdExtStg();

    LinkedList getFriendData();

    k getGoogleFriendStorage();

    k getInviteFriendOpenStg();

    String getPhoneNum(Context context, String str);

    k getQQGroupStg();

    n getQQListStg();

    void removeSelfAccount(Context context);

    void setFriendData(LinkedList linkedList);

    void showAddrBookUploadConfirm(Activity activity, Runnable runnable, boolean z, int i);

    boolean syncAddrBook(b bVar);

    void syncAddrBookAndUpload();

    void syncUploadMContactStatus(boolean z, boolean z2);

    void updateAllContact();
}
