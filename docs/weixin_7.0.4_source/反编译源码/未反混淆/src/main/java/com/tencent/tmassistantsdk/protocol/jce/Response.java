package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class Response extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!Response.class.desiredAssertionStatus());
    private static final String TAG = "Response";
    static byte[] cache_body;
    static RspHead cache_head;
    public byte[] body = null;
    public RspHead head = null;

    static {
        AppMethodBeat.i(76113);
        AppMethodBeat.o(76113);
    }

    public final String className() {
        return "jce.Response";
    }

    public final String fullClassName() {
        return TAG;
    }

    public final RspHead getHead() {
        return this.head;
    }

    public final void setHead(RspHead rspHead) {
        this.head = rspHead;
    }

    public final byte[] getBody() {
        return this.body;
    }

    public final void setBody(byte[] bArr) {
        this.body = bArr;
    }

    public Response(RspHead rspHead, byte[] bArr) {
        this.head = rspHead;
        this.body = bArr;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(76106);
        if (obj == null) {
            AppMethodBeat.o(76106);
            return false;
        }
        Response response = (Response) obj;
        if (JceUtil.equals(this.head, response.head) && JceUtil.equals(this.body, response.body)) {
            AppMethodBeat.o(76106);
            return true;
        }
        AppMethodBeat.o(76106);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(76107);
        Exception exception;
        try {
            exception = new Exception("Need define key first!");
            AppMethodBeat.o(76107);
            throw exception;
        } catch (Exception exception2) {
            ab.printErrStackTrace(TAG, exception2, "", new Object[0]);
            AppMethodBeat.o(76107);
            return 0;
        }
    }

    public final Object clone() {
        AppMethodBeat.i(76108);
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            if (!$assertionsDisabled) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(76108);
                throw assertionError;
            }
        }
        AppMethodBeat.o(76108);
        return obj;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(76109);
        jceOutputStream.write(this.head, 0);
        jceOutputStream.write(this.body, 1);
        AppMethodBeat.o(76109);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(76110);
        if (cache_head == null) {
            cache_head = new RspHead();
        }
        this.head = (RspHead) jceInputStream.read(cache_head, 0, true);
        if (cache_body == null) {
            byte[] bArr = new byte[1];
            cache_body = bArr;
            bArr[0] = (byte) 0;
        }
        this.body = jceInputStream.read(cache_body, 1, true);
        AppMethodBeat.o(76110);
    }

    public final void display(StringBuilder stringBuilder, int i) {
        AppMethodBeat.i(76111);
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.display(this.head, "head");
        jceDisplayer.display(this.body, "body");
        AppMethodBeat.o(76111);
    }

    public final void displaySimple(StringBuilder stringBuilder, int i) {
        AppMethodBeat.i(76112);
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.displaySimple(this.head, true);
        jceDisplayer.displaySimple(this.body, false);
        AppMethodBeat.o(76112);
    }
}
