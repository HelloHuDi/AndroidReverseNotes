package com.tencent.p177mm.storage;

import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.p455a.C12524o;
import com.tencent.p177mm.sdk.p603e.C7296k;

/* renamed from: com.tencent.mm.storage.cb */
public final class C23513cb extends C7296k implements C12524o {
    public static final String[] fnj = new String[]{"CREATE TABLE IF NOT EXISTS verifycontact ( id INTEGER PRIMARY KEY, username varchar(40), nickname varchar(40), fullpy varchar(60), shortpy varchar(40), imgflag int, scene int, content text, status int, reserved1 int,reserved2 int,reserved3 text,reserved4 text)", "CREATE UNIQUE INDEX IF NOT EXISTS verifyContactIndex  ON verifycontact ( username )"};
    private C7480h fni;

    public C23513cb(C7480h c7480h) {
        this.fni = c7480h;
    }
}
