package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class AppSimpleDetail extends JceStruct {
    static ArrayList<ApkDownUrl> cache_apkDownUrl;
    public ArrayList<ApkDownUrl> apkDownUrl = null;
    public long apkId = 0;
    public String apkMd5 = "";
    public long appId = 0;
    public String appName = "";
    public String channelId = "";
    public String diffApkMd5 = "";
    public long diffFileSize = 0;
    public long fileSize = 0;
    public String iconUrl = "";
    public String packageName = "";
    public String signatureMd5 = "";
    public int versionCode = 0;
    public String versionName = "";

    public AppSimpleDetail(long j, long j2, String str, String str2, String str3, String str4, int i, String str5, String str6, long j3, ArrayList<ApkDownUrl> arrayList, String str7, long j4, String str8) {
        this.appId = j;
        this.apkId = j2;
        this.appName = str;
        this.iconUrl = str2;
        this.packageName = str3;
        this.versionName = str4;
        this.versionCode = i;
        this.signatureMd5 = str5;
        this.apkMd5 = str6;
        this.fileSize = j3;
        this.apkDownUrl = arrayList;
        this.diffApkMd5 = str7;
        this.diffFileSize = j4;
        this.channelId = str8;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        AppMethodBeat.i(76032);
        jceOutputStream.write(this.appId, 0);
        jceOutputStream.write(this.apkId, 1);
        if (this.appName != null) {
            jceOutputStream.write(this.appName, 2);
        }
        if (this.iconUrl != null) {
            jceOutputStream.write(this.iconUrl, 3);
        }
        if (this.packageName != null) {
            jceOutputStream.write(this.packageName, 4);
        }
        if (this.versionName != null) {
            jceOutputStream.write(this.versionName, 5);
        }
        jceOutputStream.write(this.versionCode, 6);
        if (this.signatureMd5 != null) {
            jceOutputStream.write(this.signatureMd5, 7);
        }
        if (this.apkMd5 != null) {
            jceOutputStream.write(this.apkMd5, 8);
        }
        jceOutputStream.write(this.fileSize, 9);
        if (this.apkDownUrl != null) {
            jceOutputStream.write(this.apkDownUrl, 10);
        }
        if (this.diffApkMd5 != null) {
            jceOutputStream.write(this.diffApkMd5, 11);
        }
        jceOutputStream.write(this.diffFileSize, 12);
        if (this.channelId != null) {
            jceOutputStream.write(this.channelId, 13);
        }
        AppMethodBeat.o(76032);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        AppMethodBeat.i(76033);
        this.appId = jceInputStream.read(this.appId, 0, false);
        this.apkId = jceInputStream.read(this.apkId, 1, false);
        this.appName = jceInputStream.readString(2, false);
        this.iconUrl = jceInputStream.readString(3, false);
        this.packageName = jceInputStream.readString(4, false);
        this.versionName = jceInputStream.readString(5, false);
        this.versionCode = jceInputStream.read(this.versionCode, 6, false);
        this.signatureMd5 = jceInputStream.readString(7, false);
        this.apkMd5 = jceInputStream.readString(8, false);
        this.fileSize = jceInputStream.read(this.fileSize, 9, false);
        if (cache_apkDownUrl == null) {
            cache_apkDownUrl = new ArrayList();
            cache_apkDownUrl.add(new ApkDownUrl());
        }
        this.apkDownUrl = (ArrayList) jceInputStream.read(cache_apkDownUrl, 10, false);
        this.diffApkMd5 = jceInputStream.readString(11, false);
        this.diffFileSize = jceInputStream.read(this.diffFileSize, 12, false);
        this.channelId = jceInputStream.readString(13, false);
        AppMethodBeat.o(76033);
    }
}
