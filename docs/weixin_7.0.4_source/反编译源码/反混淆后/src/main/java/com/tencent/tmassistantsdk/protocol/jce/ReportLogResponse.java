package com.tencent.tmassistantsdk.protocol.jce;

import com.p123qq.taf.jce.JceDisplayer;
import com.p123qq.taf.jce.JceInputStream;
import com.p123qq.taf.jce.JceOutputStream;
import com.p123qq.taf.jce.JceStruct;
import com.p123qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

public final class ReportLogResponse extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!ReportLogResponse.class.desiredAssertionStatus());
    private static final String TAG = "ReportLogResponse";
    public int ret = 0;

    static {
        AppMethodBeat.m2504i(76089);
        AppMethodBeat.m2505o(76089);
    }

    public final String className() {
        return "jce.ReportLogResponse";
    }

    public final String fullClassName() {
        return TAG;
    }

    public final int getRet() {
        return this.ret;
    }

    public final void setRet(int i) {
        this.ret = i;
    }

    public ReportLogResponse(int i) {
        this.ret = i;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(76082);
        if (obj == null) {
            AppMethodBeat.m2505o(76082);
            return false;
        }
        boolean equals = JceUtil.equals(this.ret, ((ReportLogResponse) obj).ret);
        AppMethodBeat.m2505o(76082);
        return equals;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(76083);
        Exception exception;
        try {
            exception = new Exception("Need define key first!");
            AppMethodBeat.m2505o(76083);
            throw exception;
        } catch (Exception exception2) {
            C4990ab.printErrStackTrace(TAG, exception2, "", new Object[0]);
            AppMethodBeat.m2505o(76083);
            return 0;
        }
    }

    public final Object clone() {
        AppMethodBeat.m2504i(76084);
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            if (!$assertionsDisabled) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.m2505o(76084);
                throw assertionError;
            }
        }
        AppMethodBeat.m2505o(76084);
        return obj;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.m2504i(76085);
        jceOutputStream.write(this.ret, 0);
        AppMethodBeat.m2505o(76085);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.m2504i(76086);
        this.ret = jceInputStream.read(this.ret, 0, true);
        AppMethodBeat.m2505o(76086);
    }

    public final void display(StringBuilder stringBuilder, int i) {
        AppMethodBeat.m2504i(76087);
        new JceDisplayer(stringBuilder, i).display(this.ret, "ret");
        AppMethodBeat.m2505o(76087);
    }

    public final void displaySimple(StringBuilder stringBuilder, int i) {
        AppMethodBeat.m2504i(76088);
        new JceDisplayer(stringBuilder, i).displaySimple(this.ret, false);
        AppMethodBeat.m2505o(76088);
    }
}
