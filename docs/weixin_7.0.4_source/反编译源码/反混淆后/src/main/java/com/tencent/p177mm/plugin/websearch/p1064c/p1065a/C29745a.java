package com.tencent.p177mm.plugin.websearch.p1064c.p1065a;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.websearch.c.a.a */
public abstract class C29745a<T> {
    protected String query;
    protected int ucd = BaseClientBuilder.API_PRIORITY_OTHER;

    /* renamed from: dZ */
    public abstract void mo47990dZ(List<C45966l> list);

    public C29745a(String str) {
        this.query = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C29745a)) {
            return false;
        }
        C29745a c29745a = (C29745a) obj;
        boolean z;
        if (this.query == c29745a.query || (this.query != null && this.query.equalsIgnoreCase(c29745a.query))) {
            z = true;
        } else {
            z = false;
        }
        if (c29745a.ucd == this.ucd && z) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
