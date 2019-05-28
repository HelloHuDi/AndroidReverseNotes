package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class SettingsCfg extends JceStruct implements Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = (!SettingsCfg.class.desiredAssertionStatus());
    private static final String TAG = "SettingsCfg";
    static byte[] cache_cfg;
    public byte[] cfg = null;
    public long revision = 0;
    public byte type = (byte) 0;

    static {
        AppMethodBeat.i(76133);
        AppMethodBeat.o(76133);
    }

    public final String className() {
        return "jce.SettingsCfg";
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

    public final byte[] getCfg() {
        return this.cfg;
    }

    public final void setCfg(byte[] bArr) {
        this.cfg = bArr;
    }

    public final long getRevision() {
        return this.revision;
    }

    public final void setRevision(long j) {
        this.revision = j;
    }

    public SettingsCfg(byte b, byte[] bArr, long j) {
        this.type = b;
        this.cfg = bArr;
        this.revision = j;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(76126);
        if (obj == null) {
            AppMethodBeat.o(76126);
            return false;
        }
        SettingsCfg settingsCfg = (SettingsCfg) obj;
        if (JceUtil.equals(this.type, settingsCfg.type) && JceUtil.equals(this.cfg, settingsCfg.cfg) && JceUtil.equals(this.revision, settingsCfg.revision)) {
            AppMethodBeat.o(76126);
            return true;
        }
        AppMethodBeat.o(76126);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(76127);
        Exception exception;
        try {
            exception = new Exception("Need define key first!");
            AppMethodBeat.o(76127);
            throw exception;
        } catch (Exception exception2) {
            ab.printErrStackTrace(TAG, exception2, "", new Object[0]);
            AppMethodBeat.o(76127);
            return 0;
        }
    }

    public final Object clone() {
        AppMethodBeat.i(76128);
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {
            if (!$assertionsDisabled) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(76128);
                throw assertionError;
            }
        }
        AppMethodBeat.o(76128);
        return obj;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(76129);
        jceOutputStream.write(this.type, 0);
        jceOutputStream.write(this.cfg, 1);
        jceOutputStream.write(this.revision, 2);
        AppMethodBeat.o(76129);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(76130);
        this.type = jceInputStream.read(this.type, 0, true);
        if (cache_cfg == null) {
            byte[] bArr = new byte[1];
            cache_cfg = bArr;
            bArr[0] = (byte) 0;
        }
        this.cfg = jceInputStream.read(cache_cfg, 1, true);
        this.revision = jceInputStream.read(this.revision, 2, false);
        AppMethodBeat.o(76130);
    }

    public final void display(StringBuilder stringBuilder, int i) {
        AppMethodBeat.i(76131);
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.display(this.type, "type");
        jceDisplayer.display(this.cfg, "cfg");
        jceDisplayer.display(this.revision, "revision");
        AppMethodBeat.o(76131);
    }

    public final void displaySimple(StringBuilder stringBuilder, int i) {
        AppMethodBeat.i(76132);
        JceDisplayer jceDisplayer = new JceDisplayer(stringBuilder, i);
        jceDisplayer.displaySimple(this.type, true);
        jceDisplayer.displaySimple(this.cfg, true);
        jceDisplayer.displaySimple(this.revision, false);
        AppMethodBeat.o(76132);
    }
}
