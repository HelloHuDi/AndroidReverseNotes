package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.cc;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;

public final class n extends cc {
    protected static a ccO;

    public final a Ag() {
        return ccO;
    }

    public final String toString() {
        AppMethodBeat.i(108385);
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
        AppMethodBeat.o(108385);
        return stringBuffer2;
    }

    static {
        AppMethodBeat.i(108386);
        a aVar = new a();
        aVar.xDb = new Field[16];
        aVar.columns = new String[17];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "googleid";
        aVar.xDd.put("googleid", "TEXT");
        stringBuilder.append(" googleid TEXT");
        stringBuilder.append(", ");
        aVar.columns[1] = "googlename";
        aVar.xDd.put("googlename", "TEXT");
        stringBuilder.append(" googlename TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "googlephotourl";
        aVar.xDd.put("googlephotourl", "TEXT");
        stringBuilder.append(" googlephotourl TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "googlegmail";
        aVar.xDd.put("googlegmail", "TEXT");
        stringBuilder.append(" googlegmail TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "username";
        aVar.xDd.put("username", "TEXT");
        stringBuilder.append(" username TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "nickname";
        aVar.xDd.put("nickname", "TEXT");
        stringBuilder.append(" nickname TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "nicknameqp";
        aVar.xDd.put("nicknameqp", "TEXT");
        stringBuilder.append(" nicknameqp TEXT");
        stringBuilder.append(", ");
        aVar.columns[7] = "usernamepy";
        aVar.xDd.put("usernamepy", "TEXT");
        stringBuilder.append(" usernamepy TEXT");
        stringBuilder.append(", ");
        aVar.columns[8] = "small_url";
        aVar.xDd.put("small_url", "TEXT");
        stringBuilder.append(" small_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[9] = "big_url";
        aVar.xDd.put("big_url", "TEXT");
        stringBuilder.append(" big_url TEXT");
        stringBuilder.append(", ");
        aVar.columns[10] = "ret";
        aVar.xDd.put("ret", "INTEGER");
        stringBuilder.append(" ret INTEGER");
        stringBuilder.append(", ");
        aVar.columns[11] = "status";
        aVar.xDd.put("status", "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.columns[12] = "googleitemid";
        aVar.xDd.put("googleitemid", "TEXT PRIMARY KEY ");
        stringBuilder.append(" googleitemid TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "googleitemid";
        aVar.columns[13] = "googlecgistatus";
        aVar.xDd.put("googlecgistatus", "INTEGER default '2' ");
        stringBuilder.append(" googlecgistatus INTEGER default '2' ");
        stringBuilder.append(", ");
        aVar.columns[14] = "contecttype";
        aVar.xDd.put("contecttype", "TEXT");
        stringBuilder.append(" contecttype TEXT");
        stringBuilder.append(", ");
        aVar.columns[15] = "googlenamepy";
        aVar.xDd.put("googlenamepy", "TEXT");
        stringBuilder.append(" googlenamepy TEXT");
        aVar.columns[16] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        AppMethodBeat.o(108386);
    }
}
