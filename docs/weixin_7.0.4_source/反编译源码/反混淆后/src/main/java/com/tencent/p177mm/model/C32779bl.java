package com.tencent.p177mm.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.model.bl */
public final class C32779bl {
    public int bJt = -1;
    public String fjx = "";
    public String fjz = "";
    public String fmX = "";
    public String fmY = "";
    public String fmZ = "";
    public long fna = 0;
    public String fnb = "";
    public String fnc = "";
    public int fnd = 0;
    public int fne = 0;
    public long fnf = 0;
    public String fng = "";
    public String fnh = "";
    public String name = "";
    public long time = 0;
    public String title = "";
    public int type = 0;
    public String url = "";

    public C32779bl() {
        AppMethodBeat.m2504i(108667);
        AppMethodBeat.m2505o(108667);
    }

    /* renamed from: d */
    public final void mo53329d(Cursor cursor) {
        AppMethodBeat.m2504i(108668);
        this.fmX = cursor.getString(0);
        this.time = cursor.getLong(1);
        this.type = cursor.getInt(2);
        this.name = cursor.getString(3);
        this.title = cursor.getString(4);
        this.url = cursor.getString(5);
        this.fmY = cursor.getString(6);
        this.fmZ = cursor.getString(7);
        this.fna = cursor.getLong(8);
        this.fnb = cursor.getString(9);
        this.fnc = cursor.getString(10);
        this.fnd = cursor.getInt(11);
        this.fjx = cursor.getString(12);
        this.fjz = cursor.getString(13);
        this.fne = cursor.getInt(14);
        this.fnf = cursor.getLong(15);
        this.fng = cursor.getString(16);
        this.fnh = cursor.getString(17);
        AppMethodBeat.m2505o(108668);
    }

    /* renamed from: kG */
    public static String m53547kG(int i) {
        AppMethodBeat.m2504i(108669);
        String str;
        if (i == 20) {
            str = "newsapp";
            AppMethodBeat.m2505o(108669);
            return str;
        } else if (i == 11) {
            str = "blogapp";
            AppMethodBeat.m2505o(108669);
            return str;
        } else {
            Assert.assertTrue("INFO TYPE NEITHER NEWS NOR WEIBO", false);
            AppMethodBeat.m2505o(108669);
            return null;
        }
    }

    public final boolean aai() {
        return this.fne == 1;
    }

    public final String aaj() {
        return this.fmX == null ? "" : this.fmX;
    }

    public final String getName() {
        return this.name == null ? "" : this.name;
    }

    public final String getTitle() {
        return this.title == null ? "" : this.title;
    }

    public final String getUrl() {
        return this.url == null ? "" : this.url;
    }

    public final String aak() {
        return this.fmY == null ? "" : this.fmY;
    }

    public final String aal() {
        return this.fnb == null ? "" : this.fnb;
    }

    public final String aam() {
        return this.fnc == null ? "" : this.fnc;
    }

    public final String aan() {
        AppMethodBeat.m2504i(108670);
        String str;
        if (this.fjx != null) {
            String[] split = this.fjx.split("\\|");
            if (split == null || split.length <= 0) {
                str = "";
                AppMethodBeat.m2505o(108670);
                return str;
            }
            str = split[0];
            AppMethodBeat.m2505o(108670);
            return str;
        }
        str = "";
        AppMethodBeat.m2505o(108670);
        return str;
    }

    public final String getDigest() {
        return this.fjz == null ? "" : this.fjz;
    }
}
