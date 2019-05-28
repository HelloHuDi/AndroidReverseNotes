package com.tencent.mm.plugin.wear.model.e;

import android.content.Intent;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public final class f extends a {
    public final List<Integer> cUA() {
        AppMethodBeat.i(26397);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_ERROR_NET_RECONNECT));
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_ERROR_READ_FAILED));
        arrayList.add(Integer.valueOf(TXCStreamUploader.TXE_UPLOAD_ERROR_WRITE_FAILED));
        AppMethodBeat.o(26397);
        return arrayList;
    }

    /* Access modifiers changed, original: protected|final */
    public final byte[] p(int i, byte[] bArr) {
        String str;
        AppMethodBeat.i(26398);
        String str2 = "";
        try {
            str = new String(bArr, "utf8");
        } catch (UnsupportedEncodingException e) {
            str = str2;
        }
        if (bo.isNullOrNil(str)) {
            ab.i("MicroMsg.Wear.HttpFriendServer", "error to get username");
            AppMethodBeat.o(26398);
        } else {
            ab.i("MicroMsg.Wear.HttpFriendServer", "handle friend request %s", str);
            Intent intent;
            if (i == TXCStreamUploader.TXE_UPLOAD_ERROR_NET_RECONNECT) {
                intent = new Intent();
                intent.setClassName(ah.getPackageName(), ah.getPackageName() + ".plugin.subapp.ui.friend.FMessageTransferUI");
                intent.putExtra("friend_message_transfer_username", str);
                intent.setAction("friend_message_accept_".concat(String.valueOf(str)));
                intent.setFlags(335544320);
                ah.getContext().startActivity(intent);
            } else if (i == TXCStreamUploader.TXE_UPLOAD_ERROR_READ_FAILED) {
                intent = new Intent();
                intent.setClassName(ah.getPackageName(), ah.getPackageName() + ".plugin.subapp.ui.friend.FMessageTransferUI");
                intent.putExtra("friend_message_transfer_username", str);
                intent.setAction("friend_message_ignore_".concat(String.valueOf(str)));
                intent.setFlags(335544320);
                ah.getContext().startActivity(intent);
            } else if (i == TXCStreamUploader.TXE_UPLOAD_ERROR_WRITE_FAILED) {
                Intent intent2 = new Intent();
                intent2.setClassName(ah.getPackageName(), ah.getPackageName() + ".plugin.subapp.ui.friend.FMessageConversationUI");
                intent2.setFlags(335544320);
                ah.getContext().startActivity(intent2);
            }
            AppMethodBeat.o(26398);
        }
        return null;
    }
}
