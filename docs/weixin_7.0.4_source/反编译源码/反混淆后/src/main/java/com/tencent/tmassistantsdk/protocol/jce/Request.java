package com.tencent.tmassistantsdk.protocol.jce;

import com.p123qq.taf.jce.JceDisplayer;
import com.p123qq.taf.jce.JceInputStream;
import com.p123qq.taf.jce.JceOutputStream;
import com.p123qq.taf.jce.JceStruct;
import com.p123qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

public final class Request extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!Request.class.desiredAssertionStatus());
    private static final String TAG = "Request";
    static byte[] cache_body;
    static ReqHead cache_head;
    public byte[] body = null;
    public ReqHead head = null;

    static {
        AppMethodBeat.m2504i(76105);
        AppMethodBeat.m2505o(76105);
    }

    public final String className() {
        return "jce.Request";
    }

    public final String fullClassName() {
        return TAG;
    }

    public final ReqHead getHead() {
        return this.head;
    }

    public final void setHead(ReqHead reqHead) {
        this.head = reqHead;
    }

    public final byte[] getBody() {
        return this.body;
    }

    public final void setBody(byte[] bArr) {
        this.body = bArr;
    }

    public Request(ReqHead reqHead, byte[] bArr) {
        this.head = reqHead;
        this.body = bArr;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(76098);
        if (obj == null) {
            AppMethodBeat.m2505o(76098);
            return false;
        }
        Request request = (Request) obj;
        if (JceUtil.equals(this.head, request.head) && JceUtil.equals(this.body, request.body)) {
            AppMethodBeat.m2505o(76098);
            return true;
        }
        AppMethodBeat.m2505o(76098);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(76099);
        Exception exception;
        try {
            exception = new Exception("Need define key first!");
            AppMethodBeat.m2505o(76099);
            throw exception;
        } catch (Exception exception2) {
            C4990ab.printErrStackTrace(TAG, exception2, "", new Object[0]);
            AppMethodBeat.m2505o(76099);
            return 0;
        }
    }

    public final Object clone() {
        AppMethodBeat.m2504i(76100);
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            if (!$assertionsDisabled) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.m2505o(76100);
                throw assertionError;
            }
        }
        AppMethodBeat.m2505o(76100);
        return obj;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.m2504i(76101);
        jceOutputStream.write(this.head, 0);
        if (this.body != null) {
            jceOutputStream.write(this.body, 1);
        }
        AppMethodBeat.m2505o(76101);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.m2504i(76102);
        if (cache_head == null) {
            cache_head = new ReqHead();
        }
        this.head = (ReqHead) jceInputStream.read(cache_head, 0, true);
        if (cache_body == null) {
            byte[] bArr = new byte[1];
            cache_body = bArr;
            bArr[0] = (byte) 0;
        }
        this.body = jceInputStream.read(cache_body, 1, false);
        AppMethodBeat.m2505o(76102);
    }

    public final void display(StringBuilder stringBuilder, int i) {
        AppMethodBeat.m2504i(76103);
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.display(this.head, "head");
        jceDisplayer.display(this.body, "body");
        AppMethodBeat.m2505o(76103);
    }

    public final void displaySimple(StringBuilder stringBuilder, int i) {
        AppMethodBeat.m2504i(76104);
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.displaySimple(this.head, true);
        jceDisplayer.displaySimple(this.body, false);
        AppMethodBeat.m2505o(76104);
    }
}
