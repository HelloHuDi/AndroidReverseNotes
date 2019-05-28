package com.tencent.p177mm.plugin.fav.p407a;

import com.tencent.p177mm.kernel.p241b.C7481d;
import com.tencent.p177mm.protocal.protobuf.aax;
import com.tencent.p177mm.protocal.protobuf.abi;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fav.a.ae */
public interface C7604ae extends C7481d {
    void checkFavItem(abi abi);

    void checkFavItem(List<aax> list);

    C20678r getCheckCdnService();

    C34130u getEditService();

    C3071o getFavCdnService();

    C6894q getFavCdnStorage();

    C6895s getFavConfigStorage();

    C34129t getFavEditInfoStorage();

    C11856x getFavItemInfoStorage();

    C34123aa getFavSearchStorage();

    C45927l getFavTagSetMgr();

    C27974z getModService();

    C20672ac getSendService();
}
