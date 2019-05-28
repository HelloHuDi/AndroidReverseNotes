package com.tencent.tmassistantsdk.protocol.jce;

import com.p123qq.taf.jce.JceDisplayer;
import com.p123qq.taf.jce.JceInputStream;
import com.p123qq.taf.jce.JceOutputStream;
import com.p123qq.taf.jce.JceStruct;
import com.p123qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

public final class GetSettingsRequest extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!GetSettingsRequest.class.desiredAssertionStatus());
    private static final String TAG = "GetSettingsRequest";
    public String reserve = "";

    static {
        AppMethodBeat.m2504i(76053);
        AppMethodBeat.m2505o(76053);
    }

    public final String className() {
        return "jce.GetSettingsRequest";
    }

    public final String fullClassName() {
        return TAG;
    }

    public final String getReserve() {
        return this.reserve;
    }

    public final void setReserve(String str) {
        this.reserve = str;
    }

    public GetSettingsRequest(String str) {
        this.reserve = str;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(76046);
        if (obj == null) {
            AppMethodBeat.m2505o(76046);
            return false;
        }
        boolean equals = JceUtil.equals(this.reserve, ((GetSettingsRequest) obj).reserve);
        AppMethodBeat.m2505o(76046);
        return equals;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(76047);
        Exception exception;
        try {
            exception = new Exception("Need define key first!");
            AppMethodBeat.m2505o(76047);
            throw exception;
        } catch (Exception exception2) {
            C4990ab.printErrStackTrace(TAG, exception2, "", new Object[0]);
            AppMethodBeat.m2505o(76047);
            return 0;
        }
    }

    public final Object clone() {
        AppMethodBeat.m2504i(76048);
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            if (!$assertionsDisabled) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.m2505o(76048);
                throw assertionError;
            }
        }
        AppMethodBeat.m2505o(76048);
        return obj;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.m2504i(76049);
        if (this.reserve != null) {
            jceOutputStream.write(this.reserve, 0);
        }
        AppMethodBeat.m2505o(76049);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.m2504i(76050);
        this.reserve = jceInputStream.readString(0, false);
        AppMethodBeat.m2505o(76050);
    }

    public final void display(StringBuilder stringBuilder, int i) {
        AppMethodBeat.m2504i(76051);
        new JceDisplayer(stringBuilder, i).display(this.reserve, "reserve");
        AppMethodBeat.m2505o(76051);
    }

    public final void displaySimple(StringBuilder stringBuilder, int i) {
        AppMethodBeat.m2504i(76052);
        new JceDisplayer(stringBuilder, i).displaySimple(this.reserve, false);
        AppMethodBeat.m2505o(76052);
    }
}
