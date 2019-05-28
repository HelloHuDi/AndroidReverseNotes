package com.tencent.p177mm.plugin.wear.model.p575e;

import android.content.Intent;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.wear.model.e.f */
public final class C35557f extends C46394a {
    public final List<Integer> cUA() {
        AppMethodBeat.m2504i(26397);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_ERROR_NET_RECONNECT));
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_ERROR_READ_FAILED));
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_ERROR_WRITE_FAILED));
        AppMethodBeat.m2505o(26397);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: p */
    public final byte[] mo9572p(int i, byte[] bArr) {
        String str;
        AppMethodBeat.m2504i(26398);
        String str2 = "";
        try {
            str = new String(bArr, "utf8");
        } catch (UnsupportedEncodingException e) {
            str = str2;
        }
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7416i("MicroMsg.Wear.HttpFriendServer", "error to get username");
            AppMethodBeat.m2505o(26398);
        } else {
            C4990ab.m7417i("MicroMsg.Wear.HttpFriendServer", "handle friend request %s", str);
            Intent intent;
            if (i == TXCStreamUploader.TXE_UPLOAD_ERROR_NET_RECONNECT) {
                intent = new Intent();
                intent.setClassName(C4996ah.getPackageName(), C4996ah.getPackageName() + ".plugin.subapp.ui.friend.FMessageTransferUI");
                intent.putExtra("friend_message_transfer_username", str);
                intent.setAction("friend_message_accept_".concat(String.valueOf(str)));
                intent.setFlags(335544320);
                C4996ah.getContext().startActivity(intent);
            } else if (i == TXCStreamUploader.TXE_UPLOAD_ERROR_READ_FAILED) {
                intent = new Intent();
                intent.setClassName(C4996ah.getPackageName(), C4996ah.getPackageName() + ".plugin.subapp.ui.friend.FMessageTransferUI");
                intent.putExtra("friend_message_transfer_username", str);
                intent.setAction("friend_message_ignore_".concat(String.valueOf(str)));
                intent.setFlags(335544320);
                C4996ah.getContext().startActivity(intent);
            } else if (i == TXCStreamUploader.TXE_UPLOAD_ERROR_WRITE_FAILED) {
                Intent intent2 = new Intent();
                intent2.setClassName(C4996ah.getPackageName(), C4996ah.getPackageName() + ".plugin.subapp.ui.friend.FMessageConversationUI");
                intent2.setFlags(335544320);
                C4996ah.getContext().startActivity(intent2);
            }
            AppMethodBeat.m2505o(26398);
        }
        return null;
    }
}
