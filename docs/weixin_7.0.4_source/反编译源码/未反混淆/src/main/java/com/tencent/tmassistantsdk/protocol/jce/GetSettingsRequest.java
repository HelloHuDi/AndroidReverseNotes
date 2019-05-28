package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class GetSettingsRequest extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!GetSettingsRequest.class.desiredAssertionStatus());
    private static final String TAG = "GetSettingsRequest";
    public String reserve = "";

    static {
        AppMethodBeat.i(76053);
        AppMethodBeat.o(76053);
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
        AppMethodBeat.i(76046);
        if (obj == null) {
            AppMethodBeat.o(76046);
            return false;
        }
        boolean equals = JceUtil.equals(this.reserve, ((GetSettingsRequest) obj).reserve);
        AppMethodBeat.o(76046);
        return equals;
    }

    public final int hashCode() {
        AppMethodBeat.i(76047);
        Exception exception;
        try {
            exception = new Exception("Need define key first!");
            AppMethodBeat.o(76047);
            throw exception;
        } catch (Exception exception2) {
            ab.printErrStackTrace(TAG, exception2, "", new Object[0]);
            AppMethodBeat.o(76047);
            return 0;
        }
    }

    public final Object clone() {
        AppMethodBeat.i(76048);
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            if (!$assertionsDisabled) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(76048);
                throw assertionError;
            }
        }
        AppMethodBeat.o(76048);
        return obj;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(76049);
        if (this.reserve != null) {
            jceOutputStream.write(this.reserve, 0);
        }
        AppMethodBeat.o(76049);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(76050);
        this.reserve = jceInputStream.readString(0, false);
        AppMethodBeat.o(76050);
    }

    public final void display(StringBuilder stringBuilder, int i) {
        AppMethodBeat.i(76051);
        new JceDisplayer(stringBuilder, i).display(this.reserve, "reserve");
        AppMethodBeat.o(76051);
    }

    public final void displaySimple(StringBuilder stringBuilder, int i) {
        AppMethodBeat.i(76052);
        new JceDisplayer(stringBuilder, i).displaySimple(this.reserve, false);
        AppMethodBeat.o(76052);
    }
}
