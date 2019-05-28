package com.tencent.p177mm.pluginsdk.p597ui.applet;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.pluginsdk.ui.applet.m */
public final class C14932m {
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
    public C14932m(int i, int i2) {
        this.start = i;
        this.end = i2;
        this.url = null;
        this.type = 0;
        this.data = null;
    }

    public C14932m(String str, int i, Object obj) {
        this.url = str;
        this.data = obj;
        this.type = i;
    }

    /* renamed from: au */
    public final <T> T mo27270au(Class<T> cls) {
        AppMethodBeat.m2504i(79785);
        if (cls.isInstance(this.data)) {
            Object cast = cls.cast(this.data);
            AppMethodBeat.m2505o(79785);
            return cast;
        }
        AppMethodBeat.m2505o(79785);
        return null;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(79786);
        int hashCode = super.hashCode();
        if (!C5046bo.isNullOrNil(this.url)) {
            hashCode += this.url.hashCode();
        }
        hashCode = ((hashCode + this.type) + this.end) + this.start;
        if (this.data != null) {
            hashCode += this.data.hashCode();
        }
        AppMethodBeat.m2505o(79786);
        return hashCode;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(79787);
        if (!(obj instanceof C14932m)) {
            boolean equals = super.equals(obj);
            AppMethodBeat.m2505o(79787);
            return equals;
        } else if (hashCode() == ((C14932m) obj).hashCode()) {
            AppMethodBeat.m2505o(79787);
            return true;
        } else {
            AppMethodBeat.m2505o(79787);
            return false;
        }
    }
}
