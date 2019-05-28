package com.tencent.mm.storage;

import com.tencent.mm.cd.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.o;
import com.tencent.mm.sdk.e.k;

public final class cb extends k implements o {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS verifycontact ( id INTEGER PRIMARY KEY, username varchar(40), nickname varchar(40), fullpy varchar(60), shortpy varchar(40), imgflag int, scene int, content text, status int, reserved1 int,reserved2 int,reserved3 text,reserved4 text)", "CREATE UNIQUE INDEX IF NOT EXISTS verifyContactIndex  ON verifycontact ( username )"};
    private h fni;

    public cb(h hVar) {
        this.fni = hVar;
    }
}
