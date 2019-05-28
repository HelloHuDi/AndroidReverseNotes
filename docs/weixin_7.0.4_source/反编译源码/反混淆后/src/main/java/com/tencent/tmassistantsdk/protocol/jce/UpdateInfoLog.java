package com.tencent.tmassistantsdk.protocol.jce;

import com.p123qq.taf.jce.JceInputStream;
import com.p123qq.taf.jce.JceOutputStream;
import com.p123qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class UpdateInfoLog extends JceStruct {
    public int actionCode = 0;
    public long appid = 0;
    public String extra = "";
    public String packageName = "";
    public byte updateType = (byte) 0;
    public byte yybExistFlag = (byte) 0;

    public UpdateInfoLog(byte b, String str, long j, int i, byte b2, String str2) {
        this.updateType = b;
        this.packageName = str;
        this.appid = j;
        this.actionCode = i;
        this.yybExistFlag = b2;
        this.extra = str2;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.m2504i(76158);
        jceOutputStream.write(this.updateType, 0);
        jceOutputStream.write(this.packageName, 1);
        jceOutputStream.write(this.appid, 2);
        jceOutputStream.write(this.actionCode, 3);
        jceOutputStream.write(this.yybExistFlag, 4);
        if (this.extra != null) {
            jceOutputStream.write(this.extra, 5);
        }
        AppMethodBeat.m2505o(76158);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.m2504i(76159);
        this.updateType = jceInputStream.read(this.updateType, 0, true);
        this.packageName = jceInputStream.readString(1, true);
        this.appid = jceInputStream.read(this.appid, 2, false);
        this.actionCode = jceInputStream.read(this.actionCode, 3, true);
        this.yybExistFlag = jceInputStream.read(this.yybExistFlag, 4, false);
        this.extra = jceInputStream.readString(5, false);
        AppMethodBeat.m2505o(76159);
    }
}
