package com.tencent.tmassistantsdk.protocol.jce;

import com.p123qq.taf.jce.JceDisplayer;
import com.p123qq.taf.jce.JceInputStream;
import com.p123qq.taf.jce.JceOutputStream;
import com.p123qq.taf.jce.JceStruct;
import com.p123qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

public final class RspHead extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!RspHead.class.desiredAssertionStatus());
    private static final String TAG = "RspHead";
    public int cmdId = 0;
    public byte encryptWithPack = (byte) 0;
    public String phoneGuid = "";
    public int requestId = 0;
    public int ret = 0;

    static {
        AppMethodBeat.m2504i(76125);
        AppMethodBeat.m2505o(76125);
    }

    public final String className() {
        return "jce.RspHead";
    }

    public final String fullClassName() {
        return TAG;
    }

    public final int getRequestId() {
        return this.requestId;
    }

    public final void setRequestId(int i) {
        this.requestId = i;
    }

    public final int getCmdId() {
        return this.cmdId;
    }

    public final void setCmdId(int i) {
        this.cmdId = i;
    }

    public final int getRet() {
        return this.ret;
    }

    public final void setRet(int i) {
        this.ret = i;
    }

    public final byte getEncryptWithPack() {
        return this.encryptWithPack;
    }

    public final void setEncryptWithPack(byte b) {
        this.encryptWithPack = b;
    }

    public final String getPhoneGuid() {
        return this.phoneGuid;
    }

    public final void setPhoneGuid(String str) {
        this.phoneGuid = str;
    }

    public RspHead(int i, int i2, int i3, byte b, String str) {
        this.requestId = i;
        this.cmdId = i2;
        this.ret = i3;
        this.encryptWithPack = b;
        this.phoneGuid = str;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(76118);
        if (obj == null) {
            AppMethodBeat.m2505o(76118);
            return false;
        }
        RspHead rspHead = (RspHead) obj;
        if (JceUtil.equals(this.requestId, rspHead.requestId) && JceUtil.equals(this.cmdId, rspHead.cmdId) && JceUtil.equals(this.ret, rspHead.ret) && JceUtil.equals(this.encryptWithPack, rspHead.encryptWithPack) && JceUtil.equals(this.phoneGuid, rspHead.phoneGuid)) {
            AppMethodBeat.m2505o(76118);
            return true;
        }
        AppMethodBeat.m2505o(76118);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(76119);
        Exception exception;
        try {
            exception = new Exception("Need define key first!");
            AppMethodBeat.m2505o(76119);
            throw exception;
        } catch (Exception exception2) {
            C4990ab.printErrStackTrace(TAG, exception2, "", new Object[0]);
            AppMethodBeat.m2505o(76119);
            return 0;
        }
    }

    public final Object clone() {
        AppMethodBeat.m2504i(76120);
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            if (!$assertionsDisabled) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.m2505o(76120);
                throw assertionError;
            }
        }
        AppMethodBeat.m2505o(76120);
        return obj;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.m2504i(76121);
        jceOutputStream.write(this.requestId, 0);
        jceOutputStream.write(this.cmdId, 1);
        jceOutputStream.write(this.ret, 2);
        jceOutputStream.write(this.encryptWithPack, 3);
        if (this.phoneGuid != null) {
            jceOutputStream.write(this.phoneGuid, 4);
        }
        AppMethodBeat.m2505o(76121);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.m2504i(76122);
        this.requestId = jceInputStream.read(this.requestId, 0, true);
        this.cmdId = jceInputStream.read(this.cmdId, 1, true);
        this.ret = jceInputStream.read(this.ret, 2, true);
        this.encryptWithPack = jceInputStream.read(this.encryptWithPack, 3, false);
        this.phoneGuid = jceInputStream.readString(4, false);
        AppMethodBeat.m2505o(76122);
    }

    public final void display(StringBuilder stringBuilder, int i) {
        AppMethodBeat.m2504i(76123);
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.display(this.requestId, "requestId");
        jceDisplayer.display(this.cmdId, "cmdId");
        jceDisplayer.display(this.ret, "ret");
        jceDisplayer.display(this.encryptWithPack, "encryptWithPack");
        jceDisplayer.display(this.phoneGuid, "phoneGuid");
        AppMethodBeat.m2505o(76123);
    }

    public final void displaySimple(StringBuilder stringBuilder, int i) {
        AppMethodBeat.m2504i(76124);
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.displaySimple(this.requestId, true);
        jceDisplayer.displaySimple(this.cmdId, true);
        jceDisplayer.displaySimple(this.ret, true);
        jceDisplayer.displaySimple(this.encryptWithPack, true);
        jceDisplayer.displaySimple(this.phoneGuid, false);
        AppMethodBeat.m2505o(76124);
    }
}
