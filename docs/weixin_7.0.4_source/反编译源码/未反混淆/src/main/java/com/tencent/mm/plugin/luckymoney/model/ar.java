package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.r;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import org.json.JSONObject;

public final class ar extends ak {
    public ar(String str, String str2, String str3) {
        AppMethodBeat.i(42423);
        HashMap hashMap = new HashMap();
        hashMap.put("username", str);
        hashMap.put("sendId", str2);
        hashMap.put(DownloadInfoColumns.CHANNELID, "1");
        hashMap.put("ver", str3);
        hashMap.put("sendUserName", r.Yz());
        M(hashMap);
        AppMethodBeat.o(42423);
    }

    public final int getType() {
        return 1668;
    }

    public final String bgF() {
        return "/cgi-bin/mmpay-bin/sharewxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
    }
}
