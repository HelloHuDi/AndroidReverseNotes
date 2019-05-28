package com.tencent.p177mm.pluginsdk.model.app;

import android.net.Uri;

/* renamed from: com.tencent.mm.pluginsdk.model.app.ao */
public final class C44058ao {
    public static C44058ao vdg = null;
    public static long vdh = -1;
    public int code = -1;
    public String[] projection = null;
    public String selection = "";
    public String[] selectionArgs = null;
    public Uri uri = null;
    public String vde = "";
    public String[] vdf = null;

    public C44058ao(Uri uri, String[] strArr, String str, String[] strArr2, String str2, int i, String[] strArr3) {
        this.uri = uri;
        this.projection = strArr;
        this.selection = str;
        this.selectionArgs = strArr2;
        this.vde = str2;
        this.code = i;
        this.vdf = strArr3;
    }
}
