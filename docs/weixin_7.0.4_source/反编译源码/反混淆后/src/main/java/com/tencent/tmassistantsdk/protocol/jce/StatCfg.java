package com.tencent.tmassistantsdk.protocol.jce;

import com.p123qq.taf.jce.JceDisplayer;
import com.p123qq.taf.jce.JceInputStream;
import com.p123qq.taf.jce.JceOutputStream;
import com.p123qq.taf.jce.JceStruct;
import com.p123qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public final class StatCfg extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!StatCfg.class.desiredAssertionStatus());
    private static final String TAG = "StatCfg";
    public int internal = 0;
    public short lineNum = (short) 0;
    public byte netType = (byte) 0;
    public byte type = (byte) 0;

    static {
        AppMethodBeat.m2504i(76141);
        AppMethodBeat.m2505o(76141);
    }

    public final String className() {
        return "jce.StatCfg";
    }

    public final String fullClassName() {
        return TAG;
    }

    public final byte getType() {
        return this.type;
    }

    public final void setType(byte b) {
        this.type = b;
    }

    public final byte getNetType() {
        return this.netType;
    }

    public final void setNetType(byte b) {
        this.netType = b;
    }

    public final short getLineNum() {
        return this.lineNum;
    }

    public final void setLineNum(short s) {
        this.lineNum = s;
    }

    public final int getInternal() {
        return this.internal;
    }

    public final void setInternal(int i) {
        this.internal = i;
    }

    public StatCfg(byte b, byte b2, short s, int i) {
        this.type = b;
        this.netType = b2;
        this.lineNum = s;
        this.internal = i;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(76134);
        if (obj == null) {
            AppMethodBeat.m2505o(76134);
            return false;
        }
        StatCfg statCfg = (StatCfg) obj;
        if (JceUtil.equals(this.type, statCfg.type) && JceUtil.equals(this.netType, statCfg.netType) && JceUtil.equals(this.lineNum, statCfg.lineNum) && JceUtil.equals(this.internal, statCfg.internal)) {
            AppMethodBeat.m2505o(76134);
            return true;
        }
        AppMethodBeat.m2505o(76134);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(76135);
        Exception exception;
        try {
            exception = new Exception("Need define key first!");
            AppMethodBeat.m2505o(76135);
            throw exception;
        } catch (Exception exception2) {
            C4990ab.printErrStackTrace(TAG, exception2, "", new Object[0]);
            AppMethodBeat.m2505o(76135);
            return 0;
        }
    }

    public final Object clone() {
        AppMethodBeat.m2504i(76136);
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            if (!$assertionsDisabled) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.m2505o(76136);
                throw assertionError;
            }
        }
        AppMethodBeat.m2505o(76136);
        return obj;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.m2504i(76137);
        jceOutputStream.write(this.type, 0);
        jceOutputStream.write(this.netType, 1);
        jceOutputStream.write(this.lineNum, 2);
        jceOutputStream.write(this.internal, 3);
        AppMethodBeat.m2505o(76137);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.m2504i(76138);
        this.type = jceInputStream.read(this.type, 0, true);
        this.netType = jceInputStream.read(this.netType, 1, true);
        this.lineNum = jceInputStream.read(this.lineNum, 2, false);
        this.internal = jceInputStream.read(this.internal, 3, false);
        AppMethodBeat.m2505o(76138);
    }

    public final void display(StringBuilder stringBuilder, int i) {
        AppMethodBeat.m2504i(76139);
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.display(this.type, "type");
        jceDisplayer.display(this.netType, DownloadInfo.NETTYPE);
        jceDisplayer.display(this.lineNum, "lineNum");
        jceDisplayer.display(this.internal, "internal");
        AppMethodBeat.m2505o(76139);
    }

    public final void displaySimple(StringBuilder stringBuilder, int i) {
        AppMethodBeat.m2504i(76140);
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.displaySimple(this.type, true);
        jceDisplayer.displaySimple(this.netType, true);
        jceDisplayer.displaySimple(this.lineNum, true);
        jceDisplayer.displaySimple(this.internal, false);
        AppMethodBeat.m2505o(76140);
    }
}
