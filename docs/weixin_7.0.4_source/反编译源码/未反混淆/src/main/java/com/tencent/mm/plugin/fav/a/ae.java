package com.tencent.mm.plugin.fav.a;

import com.tencent.mm.kernel.b.d;
import com.tencent.mm.protocal.protobuf.aax;
import com.tencent.mm.protocal.protobuf.abi;
import java.util.List;

public interface ae extends d {
    void checkFavItem(abi abi);

    void checkFavItem(List<aax> list);

    r getCheckCdnService();

    u getEditService();

    o getFavCdnService();

    q getFavCdnStorage();

    s getFavConfigStorage();

    t getFavEditInfoStorage();

    x getFavItemInfoStorage();

    aa getFavSearchStorage();

    l getFavTagSetMgr();

    z getModService();

    ac getSendService();
}
