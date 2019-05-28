package com.tencent.mm.plugin.nfc.b;

import android.nfc.Tag;

public abstract class b {
    protected Tag oTm;
    public byte[] oTn = null;

    public boolean a(Tag tag) {
        this.oTm = tag;
        if (tag != null) {
            this.oTn = tag.getId();
        }
        return true;
    }
}
