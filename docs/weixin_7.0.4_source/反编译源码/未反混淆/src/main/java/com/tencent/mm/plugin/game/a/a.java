package com.tencent.mm.plugin.game.a;

import android.content.Context;

public interface a {

    public static class a {
        private static a mTp = null;

        public static void a(a aVar) {
            mTp = aVar;
        }

        public static a bDb() {
            return mTp;
        }
    }

    void W(String str, int i, int i2);

    void a(Context context, String str, String str2, String str3, int i, int i2, int i3, String str4, String str5, String str6);

    void a(Context context, String str, String str2, String str3, int i, String str4, int i2);

    void a(String str, String str2, int i, int i2, String str3, int i3);

    void a(String str, String str2, int i, int i2, String str3, long j, String str4);

    boolean bCS();

    String bCT();

    void dV(Context context);

    void hH(boolean z);

    void j(Context context, String str, String str2);

    void m(String str, String str2, String str3);
}
