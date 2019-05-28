package com.google.p114b.p801b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.b.b.c */
public enum C37294c {
    Cp437((String) new int[]{0, 2}, (int) new String[0]),
    ISO8859_1((String) new int[]{1, 3}, (int) new String[]{"ISO-8859-1"}),
    ISO8859_2((String) 4, (int) new String[]{"ISO-8859-2"}),
    ISO8859_3((String) 5, (int) new String[]{"ISO-8859-3"}),
    ISO8859_4((String) 6, (int) new String[]{"ISO-8859-4"}),
    ISO8859_5((String) 7, (int) new String[]{"ISO-8859-5"}),
    ISO8859_6((String) 8, (int) new String[]{"ISO-8859-6"}),
    ISO8859_7((String) 9, (int) new String[]{"ISO-8859-7"}),
    ISO8859_8((String) 10, (int) new String[]{"ISO-8859-8"}),
    ISO8859_9((String) 11, (int) new String[]{"ISO-8859-9"}),
    ISO8859_10((String) 12, (int) new String[]{"ISO-8859-10"}),
    ISO8859_11((String) 13, (int) new String[]{"ISO-8859-11"}),
    ISO8859_13((String) 15, (int) new String[]{"ISO-8859-13"}),
    ISO8859_14((String) 16, (int) new String[]{"ISO-8859-14"}),
    ISO8859_15((String) 17, (int) new String[]{"ISO-8859-15"}),
    ISO8859_16((String) 18, (int) new String[]{"ISO-8859-16"}),
    SJIS((String) 20, (int) new String[]{"Shift_JIS"}),
    Cp1250((String) 21, (int) new String[]{"windows-1250"}),
    Cp1251((String) 22, (int) new String[]{"windows-1251"}),
    Cp1252((String) 23, (int) new String[]{"windows-1252"}),
    Cp1256((String) 24, (int) new String[]{"windows-1256"}),
    UnicodeBigUnmarked((String) 25, (int) new String[]{"UTF-16BE", "UnicodeBig"}),
    UTF8((String) 26, (int) new String[]{"UTF-8"}),
    ASCII((String) new int[]{27, ErrorCode.NEEDDOWNLOAD_TRUE}, (int) new String[]{"US-ASCII"}),
    GB18030((String) 29, (int) new String[]{"GB2312", "EUC_CN", "GBK"}),
    EUC_KR((String) 30, (int) new String[]{"EUC-KR"});
    
    private static final Map<Integer, C37294c> bzh = null;
    private static final Map<String, C37294c> bzi = null;
    public final int[] bzj;
    private final String[] bzk;

    static {
        bzh = new HashMap();
        bzi = new HashMap();
        for (C37294c c37294c : C37294c.values()) {
            for (int valueOf : c37294c.bzj) {
                bzh.put(Integer.valueOf(valueOf), c37294c);
            }
            bzi.put(c37294c.name(), c37294c);
            for (Object put : c37294c.bzk) {
                bzi.put(put, c37294c);
            }
        }
        AppMethodBeat.m2505o(57145);
    }

    private C37294c(int i) {
        this((String) i, 24, new int[]{28}, new String[0]);
        AppMethodBeat.m2504i(57142);
        AppMethodBeat.m2505o(57142);
    }

    private C37294c(int i, String... strArr) {
        AppMethodBeat.m2504i(57143);
        this.bzj = new int[]{i};
        this.bzk = strArr;
        AppMethodBeat.m2505o(57143);
    }

    private C37294c(int[] iArr, String... strArr) {
        this.bzj = iArr;
        this.bzk = strArr;
    }

    /* renamed from: bh */
    public static C37294c m62695bh(String str) {
        AppMethodBeat.m2504i(57144);
        C37294c c37294c = (C37294c) bzi.get(str);
        AppMethodBeat.m2505o(57144);
        return c37294c;
    }
}
