package com.tencent.tmassistantsdk.protocol.jce;

import com.p123qq.taf.jce.JceInputStream;
import com.p123qq.taf.jce.JceOutputStream;
import com.p123qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class GetAppSimpleDetailResponse extends JceStruct {
    static ArrayList<AppSimpleDetail> cache_appSimpleDetailList;
    public ArrayList<AppSimpleDetail> appSimpleDetailList = null;
    public int ret = 0;

    public GetAppSimpleDetailResponse(int i, ArrayList<AppSimpleDetail> arrayList) {
        this.ret = i;
        this.appSimpleDetailList = arrayList;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.m2504i(76044);
        jceOutputStream.write(this.ret, 0);
        jceOutputStream.write(this.appSimpleDetailList, 1);
        AppMethodBeat.m2505o(76044);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.m2504i(76045);
        this.ret = jceInputStream.read(this.ret, 0, true);
        if (cache_appSimpleDetailList == null) {
            cache_appSimpleDetailList = new ArrayList();
            cache_appSimpleDetailList.add(new AppSimpleDetail());
        }
        this.appSimpleDetailList = (ArrayList) jceInputStream.read(cache_appSimpleDetailList, 1, true);
        AppMethodBeat.m2505o(76045);
    }
}
