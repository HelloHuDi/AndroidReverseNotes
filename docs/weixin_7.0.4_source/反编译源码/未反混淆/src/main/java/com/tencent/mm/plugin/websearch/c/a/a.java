package com.tencent.mm.plugin.websearch.c.a;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.mm.plugin.fts.a.a.l;
import java.util.List;

public abstract class a<T> {
    protected String query;
    protected int ucd = BaseClientBuilder.API_PRIORITY_OTHER;

    public abstract void dZ(List<l> list);

    public a(String str) {
        this.query = str;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        boolean z;
        if (this.query == aVar.query || (this.query != null && this.query.equalsIgnoreCase(aVar.query))) {
            z = true;
        } else {
            z = false;
        }
        if (aVar.ucd == this.ucd && z) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }
}
