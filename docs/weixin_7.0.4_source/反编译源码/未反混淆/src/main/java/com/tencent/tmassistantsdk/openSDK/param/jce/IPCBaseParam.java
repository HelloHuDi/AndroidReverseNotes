package com.tencent.tmassistantsdk.openSDK.param.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class IPCBaseParam extends JceStruct {
    public String channelId = "";
    public String hostAppId = "";
    public String taskAppId = "";
    public String taskPackageName = "";
    public String taskVersion = "";
    public String uin = "";
    public String uinType = "";
    public String via = "";

    public IPCBaseParam(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.hostAppId = str;
        this.taskAppId = str2;
        this.taskVersion = str3;
        this.taskPackageName = str4;
        this.uin = str5;
        this.uinType = str6;
        this.via = str7;
        this.channelId = str8;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(75986);
        jceOutputStream.write(this.hostAppId, 0);
        if (this.taskAppId != null) {
            jceOutputStream.write(this.taskAppId, 1);
        }
        jceOutputStream.write(this.taskVersion, 2);
        jceOutputStream.write(this.taskPackageName, 3);
        if (this.uin != null) {
            jceOutputStream.write(this.uin, 4);
        }
        if (this.uinType != null) {
            jceOutputStream.write(this.uinType, 5);
        }
        if (this.via != null) {
            jceOutputStream.write(this.via, 6);
        }
        if (this.channelId != null) {
            jceOutputStream.write(this.channelId, 7);
        }
        AppMethodBeat.o(75986);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(75987);
        this.hostAppId = jceInputStream.readString(0, true);
        this.taskAppId = jceInputStream.readString(1, false);
        this.taskVersion = jceInputStream.readString(2, true);
        this.taskPackageName = jceInputStream.readString(3, true);
        this.uin = jceInputStream.readString(4, false);
        this.uinType = jceInputStream.readString(5, false);
        this.via = jceInputStream.readString(6, false);
        this.channelId = jceInputStream.readString(7, false);
        AppMethodBeat.o(75987);
    }
}
