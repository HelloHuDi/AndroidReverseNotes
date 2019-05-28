package com.tencent.p177mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1853r;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.ar */
public final class C21198ar extends C34442ak {
    public C21198ar(String str, String str2, String str3) {
        AppMethodBeat.m2504i(42423);
        HashMap hashMap = new HashMap();
        hashMap.put("username", str);
        hashMap.put("sendId", str2);
        hashMap.put(DownloadInfoColumns.CHANNELID, "1");
        hashMap.put("ver", str3);
        hashMap.put("sendUserName", C1853r.m3846Yz());
        mo46410M(hashMap);
        AppMethodBeat.m2505o(42423);
    }

    public final int getType() {
        return 1668;
    }

    public final String bgF() {
        return "/cgi-bin/mmpay-bin/sharewxhb";
    }

    /* renamed from: a */
    public final void mo7791a(int i, String str, JSONObject jSONObject) {
    }
}
