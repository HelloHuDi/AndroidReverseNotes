package com.tencent.p177mm.plugin.account.p765a.p766a;

import android.app.Activity;
import android.content.Context;
import com.tencent.p177mm.kernel.p241b.C7481d;
import com.tencent.p177mm.sdk.p603e.C7296k;
import com.tencent.p177mm.sdk.p603e.C7298n;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.account.a.a.a */
public interface C7599a extends C7481d {
    void clearFriendData();

    C7298n getAddrUploadStg();

    C7296k getFacebookFrdStg();

    C7296k getFrdExtStg();

    LinkedList getFriendData();

    C7296k getGoogleFriendStorage();

    C7296k getInviteFriendOpenStg();

    String getPhoneNum(Context context, String str);

    C7296k getQQGroupStg();

    C7298n getQQListStg();

    void removeSelfAccount(Context context);

    void setFriendData(LinkedList linkedList);

    void showAddrBookUploadConfirm(Activity activity, Runnable runnable, boolean z, int i);

    boolean syncAddrBook(C45491b c45491b);

    void syncAddrBookAndUpload();

    void syncUploadMContactStatus(boolean z, boolean z2);

    void updateAllContact();
}
