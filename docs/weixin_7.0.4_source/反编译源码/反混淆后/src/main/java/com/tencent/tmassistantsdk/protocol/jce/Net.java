package com.tencent.tmassistantsdk.protocol.jce;

import com.p123qq.taf.jce.JceDisplayer;
import com.p123qq.taf.jce.JceInputStream;
import com.p123qq.taf.jce.JceOutputStream;
import com.p123qq.taf.jce.JceStruct;
import com.p123qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public final class Net extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!Net.class.desiredAssertionStatus());
    private static final String TAG = "Net";
    public String extNetworkOperator = "";
    public int extNetworkType = 0;
    public byte isWap = (byte) 0;
    public byte netType = (byte) 0;

    static {
        AppMethodBeat.m2504i(76073);
        AppMethodBeat.m2505o(76073);
    }

    public final String className() {
        return "jce.Net";
    }

    public final String fullClassName() {
        return TAG;
    }

    public final byte getNetType() {
        return this.netType;
    }

    public final void setNetType(byte b) {
        this.netType = b;
    }

    public final String getExtNetworkOperator() {
        return this.extNetworkOperator;
    }

    public final void setExtNetworkOperator(String str) {
        this.extNetworkOperator = str;
    }

    public final int getExtNetworkType() {
        return this.extNetworkType;
    }

    public final void setExtNetworkType(int i) {
        this.extNetworkType = i;
    }

    public final byte getIsWap() {
        return this.isWap;
    }

    public final void setIsWap(byte b) {
        this.isWap = b;
    }

    public Net(byte b, String str, int i, byte b2) {
        this.netType = b;
        this.extNetworkOperator = str;
        this.extNetworkType = i;
        this.isWap = b2;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(76066);
        if (obj == null) {
            AppMethodBeat.m2505o(76066);
            return false;
        }
        Net net = (Net) obj;
        if (JceUtil.equals(this.netType, net.netType) && JceUtil.equals(this.extNetworkOperator, net.extNetworkOperator) && JceUtil.equals(this.extNetworkType, net.extNetworkType) && JceUtil.equals(this.isWap, net.isWap)) {
            AppMethodBeat.m2505o(76066);
            return true;
        }
        AppMethodBeat.m2505o(76066);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(76067);
        Exception exception;
        try {
            exception = new Exception("Need define key first!");
            AppMethodBeat.m2505o(76067);
            throw exception;
        } catch (Exception exception2) {
            C4990ab.printErrStackTrace(TAG, exception2, "", new Object[0]);
            AppMethodBeat.m2505o(76067);
            return 0;
        }
    }

    public final Object clone() {
        AppMethodBeat.m2504i(76068);
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            if (!$assertionsDisabled) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.m2505o(76068);
                throw assertionError;
            }
        }
        AppMethodBeat.m2505o(76068);
        return obj;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.m2504i(76069);
        jceOutputStream.write(this.netType, 0);
        if (this.extNetworkOperator != null) {
            jceOutputStream.write(this.extNetworkOperator, 1);
        }
        jceOutputStream.write(this.extNetworkType, 2);
        jceOutputStream.write(this.isWap, 3);
        AppMethodBeat.m2505o(76069);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.m2504i(76070);
        this.netType = jceInputStream.read(this.netType, 0, true);
        this.extNetworkOperator = jceInputStream.readString(1, false);
        this.extNetworkType = jceInputStream.read(this.extNetworkType, 2, false);
        this.isWap = jceInputStream.read(this.isWap, 3, false);
        AppMethodBeat.m2505o(76070);
    }

    public final void display(StringBuilder stringBuilder, int i) {
        AppMethodBeat.m2504i(76071);
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.display(this.netType, DownloadInfo.NETTYPE);
        jceDisplayer.display(this.extNetworkOperator, "extNetworkOperator");
        jceDisplayer.display(this.extNetworkType, "extNetworkType");
        jceDisplayer.display(this.isWap, "isWap");
        AppMethodBeat.m2505o(76071);
    }

    public final void displaySimple(StringBuilder stringBuilder, int i) {
        AppMethodBeat.m2504i(76072);
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.displaySimple(this.netType, true);
        jceDisplayer.displaySimple(this.extNetworkOperator, true);
        jceDisplayer.displaySimple(this.extNetworkType, true);
        jceDisplayer.displaySimple(this.isWap, false);
        AppMethodBeat.m2505o(76072);
    }
}
