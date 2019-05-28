package com.tencent.mm.plugin.bottle.a;

import com.tencent.mm.cd.h;
import com.tencent.mm.sdk.e.k;

public final class b extends k {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS bottleinfo1 ( parentclientid text  , childcount int  , bottleid text  PRIMARY KEY , bottletype int  , msgtype int  , voicelen int  , content text  , createtime long  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) "};
    public h fni;

    public b(h hVar) {
        this.fni = hVar;
    }
}
