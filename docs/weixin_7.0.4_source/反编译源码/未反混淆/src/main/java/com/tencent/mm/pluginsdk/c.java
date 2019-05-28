package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.HashMap;

public final class c {

    public static final class b {
        public static final HashMap<Integer, Integer> val;

        static {
            AppMethodBeat.i(114654);
            HashMap hashMap = new HashMap();
            val = hashMap;
            hashMap.put(Integer.valueOf(22), Integer.valueOf(64));
            val.put(Integer.valueOf(9), Integer.valueOf(64));
            val.put(Integer.valueOf(3), Integer.valueOf(64));
            val.put(Integer.valueOf(23), Integer.valueOf(64));
            val.put(Integer.valueOf(25), Integer.valueOf(64));
            val.put(Integer.valueOf(13), Integer.valueOf(64));
            val.put(Integer.valueOf(29), Integer.valueOf(256));
            val.put(Integer.valueOf(34), Integer.valueOf(512));
            val.put(Integer.valueOf(6), Integer.valueOf(512));
            val.put(Integer.valueOf(35), Integer.valueOf(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT));
            val.put(Integer.valueOf(36), Integer.valueOf(4096));
            val.put(Integer.valueOf(37), Integer.valueOf(32768));
            val.put(Integer.valueOf(38), Integer.valueOf(32768));
            val.put(Integer.valueOf(42), Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT));
            val.put(Integer.valueOf(40), Integer.valueOf(65536));
            val.put(Integer.valueOf(41), Integer.valueOf(65536));
            val.put(Integer.valueOf(46), Integer.valueOf(262144));
            val.put(Integer.valueOf(48), Integer.valueOf(SQLiteGlobal.journalSizeLimit));
            val.put(Integer.valueOf(51), Integer.valueOf(1048576));
            val.put(Integer.valueOf(52), Integer.valueOf(2097152));
            AppMethodBeat.o(114654);
        }
    }

    public static final class a {
        public static final HashMap<String, Long> vak;

        public static Long aik(String str) {
            AppMethodBeat.i(114652);
            if (str == null) {
                AppMethodBeat.o(114652);
                return null;
            }
            Long l = (Long) vak.get(str.toLowerCase());
            AppMethodBeat.o(114652);
            return l;
        }

        static {
            AppMethodBeat.i(114653);
            HashMap hashMap = new HashMap();
            vak = hashMap;
            hashMap.put("doc", Long.valueOf(64));
            vak.put("docx", Long.valueOf(128));
            vak.put("ppt", Long.valueOf(256));
            vak.put("pptx", Long.valueOf(512));
            vak.put("xls", Long.valueOf(1024));
            vak.put("xlsx", Long.valueOf(2048));
            vak.put("pdf", Long.valueOf(4096));
            vak.put("1", Long.valueOf(1));
            vak.put(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, Long.valueOf(2));
            vak.put("48", Long.valueOf(4));
            vak.put("43", Long.valueOf(8));
            vak.put("mp3", Long.valueOf(16));
            vak.put("wav", Long.valueOf(16));
            vak.put("wma", Long.valueOf(16));
            vak.put("avi", Long.valueOf(8));
            vak.put("rmvb", Long.valueOf(8));
            vak.put("rm", Long.valueOf(8));
            vak.put("mpg", Long.valueOf(8));
            vak.put("mpeg", Long.valueOf(8));
            vak.put("wmv", Long.valueOf(8));
            vak.put("mp4", Long.valueOf(8));
            vak.put("mkv", Long.valueOf(8));
            AppMethodBeat.o(114653);
        }
    }
}
