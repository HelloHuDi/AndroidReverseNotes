package com.tencent.p177mm.plugin.account.friend.p272a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p711c.C26303cc;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.plugin.account.friend.a.n */
public final class C45498n extends C26303cc {
    protected static C4924a ccO;

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    public final String toString() {
        AppMethodBeat.m2504i(108385);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("googleIDgoogleid\n");
        stringBuffer.append("googleNamegooglename\n");
        stringBuffer.append("googlePhotoUrlgooglephotourl\n");
        stringBuffer.append("googleGmailgooglegmail\n");
        stringBuffer.append("userNameusername\n");
        stringBuffer.append("nickNamenickname\n");
        stringBuffer.append("nickNameQuanPinnicknameqp\n");
        stringBuffer.append("nickNamePYInitialusernamepy\n");
        stringBuffer.append("smallHeaderUrlsmall_url\n");
        stringBuffer.append("bigHeaderUrlbig_url\n");
        stringBuffer.append("retret\n");
        stringBuffer.append("statusstatus\n");
        stringBuffer.append("googleItemIDgoogleitemid\n");
        stringBuffer.append("cgiStatusgooglecgistatus\n");
        stringBuffer.append("contactTypecontecttype\n");
        stringBuffer.append("googleNamePYInitialgooglenamepy\n");
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(108385);
        return stringBuffer2;
    }

    static {
        AppMethodBeat.m2504i(108386);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[16];
        c4924a.columns = new String[17];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "googleid";
        c4924a.xDd.put("googleid", "TEXT");
        stringBuilder.append(" googleid TEXT");
        stringBuilder.append(", ");
        c4924a.columns[1] = "googlename";
        c4924a.xDd.put("googlename", "TEXT");
        stringBuilder.append(" googlename TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "googlephotourl";
        c4924a.xDd.put("googlephotourl", "TEXT");
        stringBuilder.append(" googlephotourl TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "googlegmail";
        c4924a.xDd.put("googlegmail", "TEXT");
        stringBuilder.append(" googlegmail TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "username";
        c4924a.xDd.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "nickname";
        c4924a.xDd.put("nickname", "TEXT");
        stringBuilder.append(" nickname TEXT");
        stringBuilder.append(", ");
        c4924a.columns[6] = "nicknameqp";
        c4924a.xDd.put("nicknameqp", "TEXT");
        stringBuilder.append(" nicknameqp TEXT");
        stringBuilder.append(", ");
        c4924a.columns[7] = "usernamepy";
        c4924a.xDd.put("usernamepy", "TEXT");
        stringBuilder.append(" usernamepy TEXT");
        stringBuilder.append(", ");
        c4924a.columns[8] = "small_url";
        c4924a.xDd.put("small_url", "TEXT");
        stringBuilder.append(" small_url TEXT");
        stringBuilder.append(", ");
        c4924a.columns[9] = "big_url";
        c4924a.xDd.put("big_url", "TEXT");
        stringBuilder.append(" big_url TEXT");
        stringBuilder.append(", ");
        c4924a.columns[10] = "ret";
        c4924a.xDd.put("ret", "INTEGER");
        stringBuilder.append(" ret INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[11] = "status";
        c4924a.xDd.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        c4924a.columns[12] = "googleitemid";
        c4924a.xDd.put("googleitemid", "TEXT PRIMARY KEY ");
        stringBuilder.append(" googleitemid TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "googleitemid";
        c4924a.columns[13] = "googlecgistatus";
        c4924a.xDd.put("googlecgistatus", "INTEGER default '2' ");
        stringBuilder.append(" googlecgistatus INTEGER default '2' ");
        stringBuilder.append(", ");
        c4924a.columns[14] = "contecttype";
        c4924a.xDd.put("contecttype", "TEXT");
        stringBuilder.append(" contecttype TEXT");
        stringBuilder.append(", ");
        c4924a.columns[15] = "googlenamepy";
        c4924a.xDd.put("googlenamepy", "TEXT");
        stringBuilder.append(" googlenamepy TEXT");
        c4924a.columns[16] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        AppMethodBeat.m2505o(108386);
    }
}
