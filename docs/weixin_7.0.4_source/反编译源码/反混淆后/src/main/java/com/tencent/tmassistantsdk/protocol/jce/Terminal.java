package com.tencent.tmassistantsdk.protocol.jce;

import com.p123qq.taf.jce.JceDisplayer;
import com.p123qq.taf.jce.JceInputStream;
import com.p123qq.taf.jce.JceOutputStream;
import com.p123qq.taf.jce.JceStruct;
import com.p123qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

public final class Terminal extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!Terminal.class.desiredAssertionStatus());
    private static final String TAG = "Terminal";
    public String androidId = "";
    public String androidIdSdCard = "";
    public String imei = "";
    public String imsi = "";
    public String macAdress = "";

    static {
        AppMethodBeat.m2504i(76149);
        AppMethodBeat.m2505o(76149);
    }

    public final String className() {
        return "jce.Terminal";
    }

    public final String fullClassName() {
        return TAG;
    }

    public final String getImei() {
        return this.imei;
    }

    public final void setImei(String str) {
        this.imei = str;
    }

    public final String getMacAdress() {
        return this.macAdress;
    }

    public final void setMacAdress(String str) {
        this.macAdress = str;
    }

    public final String getAndroidId() {
        return this.androidId;
    }

    public final void setAndroidId(String str) {
        this.androidId = str;
    }

    public final String getAndroidIdSdCard() {
        return this.androidIdSdCard;
    }

    public final void setAndroidIdSdCard(String str) {
        this.androidIdSdCard = str;
    }

    public final String getImsi() {
        return this.imsi;
    }

    public final void setImsi(String str) {
        this.imsi = str;
    }

    public Terminal(String str, String str2, String str3, String str4, String str5) {
        this.imei = str;
        this.macAdress = str2;
        this.androidId = str3;
        this.androidIdSdCard = str4;
        this.imsi = str5;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(76142);
        if (obj == null) {
            AppMethodBeat.m2505o(76142);
            return false;
        }
        Terminal terminal = (Terminal) obj;
        if (JceUtil.equals(this.imei, terminal.imei) && JceUtil.equals(this.macAdress, terminal.macAdress) && JceUtil.equals(this.androidId, terminal.androidId) && JceUtil.equals(this.androidIdSdCard, terminal.androidIdSdCard) && JceUtil.equals(this.imsi, terminal.imsi)) {
            AppMethodBeat.m2505o(76142);
            return true;
        }
        AppMethodBeat.m2505o(76142);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(76143);
        Exception exception;
        try {
            exception = new Exception("Need define key first!");
            AppMethodBeat.m2505o(76143);
            throw exception;
        } catch (Exception exception2) {
            C4990ab.printErrStackTrace(TAG, exception2, "", new Object[0]);
            AppMethodBeat.m2505o(76143);
            return 0;
        }
    }

    public final Object clone() {
        AppMethodBeat.m2504i(76144);
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            if (!$assertionsDisabled) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.m2505o(76144);
                throw assertionError;
            }
        }
        AppMethodBeat.m2505o(76144);
        return obj;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.m2504i(76145);
        if (this.imei != null) {
            jceOutputStream.write(this.imei, 0);
        }
        if (this.macAdress != null) {
            jceOutputStream.write(this.macAdress, 1);
        }
        if (this.androidId != null) {
            jceOutputStream.write(this.androidId, 2);
        }
        if (this.androidIdSdCard != null) {
            jceOutputStream.write(this.androidIdSdCard, 3);
        }
        if (this.imsi != null) {
            jceOutputStream.write(this.imsi, 4);
        }
        AppMethodBeat.m2505o(76145);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.m2504i(76146);
        this.imei = jceInputStream.readString(0, false);
        this.macAdress = jceInputStream.readString(1, false);
        this.androidId = jceInputStream.readString(2, false);
        this.androidIdSdCard = jceInputStream.readString(3, false);
        this.imsi = jceInputStream.readString(4, false);
        AppMethodBeat.m2505o(76146);
    }

    public final void display(StringBuilder stringBuilder, int i) {
        AppMethodBeat.m2504i(76147);
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.display(this.imei, "imei");
        jceDisplayer.display(this.macAdress, "macAdress");
        jceDisplayer.display(this.androidId, "androidId");
        jceDisplayer.display(this.androidIdSdCard, "androidIdSdCard");
        jceDisplayer.display(this.imsi, "imsi");
        AppMethodBeat.m2505o(76147);
    }

    public final void displaySimple(StringBuilder stringBuilder, int i) {
        AppMethodBeat.m2504i(76148);
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.displaySimple(this.imei, true);
        jceDisplayer.displaySimple(this.macAdress, true);
        jceDisplayer.displaySimple(this.androidId, true);
        jceDisplayer.displaySimple(this.androidIdSdCard, true);
        jceDisplayer.displaySimple(this.imsi, false);
        AppMethodBeat.m2505o(76148);
    }
}
