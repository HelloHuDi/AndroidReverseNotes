package com.tencent.mm.pluginsdk.ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class m {
    public int backgroundColor;
    public Object data;
    public int end;
    public String hcl;
    public int linkColor;
    public int start;
    public int type;
    public String url;
    public String username;

    @Deprecated
    public m(int i, int i2) {
        this.start = i;
        this.end = i2;
        this.url = null;
        this.type = 0;
        this.data = null;
    }

    public m(String str, int i, Object obj) {
        this.url = str;
        this.data = obj;
        this.type = i;
    }

    public final <T> T au(Class<T> cls) {
        AppMethodBeat.i(79785);
        if (cls.isInstance(this.data)) {
            Object cast = cls.cast(this.data);
            AppMethodBeat.o(79785);
            return cast;
        }
        AppMethodBeat.o(79785);
        return null;
    }

    public final int hashCode() {
        AppMethodBeat.i(79786);
        int hashCode = super.hashCode();
        if (!bo.isNullOrNil(this.url)) {
            hashCode += this.url.hashCode();
        }
        hashCode = ((hashCode + this.type) + this.end) + this.start;
        if (this.data != null) {
            hashCode += this.data.hashCode();
        }
        AppMethodBeat.o(79786);
        return hashCode;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(79787);
        if (!(obj instanceof m)) {
            boolean equals = super.equals(obj);
            AppMethodBeat.o(79787);
            return equals;
        } else if (hashCode() == ((m) obj).hashCode()) {
            AppMethodBeat.o(79787);
            return true;
        } else {
            AppMethodBeat.o(79787);
            return false;
        }
    }
}
