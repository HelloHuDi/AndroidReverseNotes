package com.tencent.p177mm.plugin.nfc.p472b;

import android.nfc.Tag;

/* renamed from: com.tencent.mm.plugin.nfc.b.b */
public abstract class C12716b {
    protected Tag oTm;
    public byte[] oTn = null;

    /* renamed from: a */
    public boolean mo24725a(Tag tag) {
        this.oTm = tag;
        if (tag != null) {
            this.oTn = tag.getId();
        }
        return true;
    }
}
