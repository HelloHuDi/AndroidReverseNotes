package com.tencent.p177mm.storage;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;

/* renamed from: com.tencent.mm.storage.az */
public final class C44222az {
    public static final C44222az xYM = new C44222az("timeline");
    public static final C44222az xYN = new C44222az("album_friend");
    public static final C44222az xYO = new C44222az("album_self");
    public static final C44222az xYP = new C44222az("album_stranger");
    public static final C44222az xYQ = new C44222az("profile_friend");
    public static final C44222az xYR = new C44222az("profile_stranger");
    public static final C44222az xYS = new C44222az(FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
    public static final C44222az xYT = new C44222az("comment_detail");
    public static final C44222az xYU = new C44222az(FacebookRequestErrorClassification.KEY_OTHER);
    public static final C44222az xYV = new C44222az("snssight");
    public static final C44222az xYW = new C44222az("fts");
    public static final C44222az xYX = new C44222az("storysight");
    public static final C44222az xYY = new C44222az("storyalbum");
    public int oyB = 0;
    public String tag = "";

    static {
        AppMethodBeat.m2504i(59006);
        AppMethodBeat.m2505o(59006);
    }

    public static C44222az dtg() {
        AppMethodBeat.m2504i(58996);
        C44222az c44222az = new C44222az("timeline");
        AppMethodBeat.m2505o(58996);
        return c44222az;
    }

    public static C44222az dth() {
        AppMethodBeat.m2504i(58997);
        C44222az c44222az = new C44222az("album_friend");
        AppMethodBeat.m2505o(58997);
        return c44222az;
    }

    public static C44222az dti() {
        AppMethodBeat.m2504i(58998);
        C44222az c44222az = new C44222az("album_self");
        AppMethodBeat.m2505o(58998);
        return c44222az;
    }

    public static C44222az dtj() {
        AppMethodBeat.m2504i(58999);
        C44222az c44222az = new C44222az("album_stranger");
        AppMethodBeat.m2505o(58999);
        return c44222az;
    }

    public static C44222az dtk() {
        AppMethodBeat.m2504i(59000);
        C44222az c44222az = new C44222az("comment_detail");
        AppMethodBeat.m2505o(59000);
        return c44222az;
    }

    public static C44222az dtl() {
        AppMethodBeat.m2504i(59001);
        C44222az c44222az = new C44222az("snssight");
        AppMethodBeat.m2505o(59001);
        return c44222az;
    }

    public static C44222az dtm() {
        AppMethodBeat.m2504i(59002);
        C44222az c44222az = new C44222az("storysight");
        AppMethodBeat.m2505o(59002);
        return c44222az;
    }

    public C44222az(String str) {
        this.tag = str;
    }

    /* renamed from: Mp */
    public final C44222az mo69860Mp(int i) {
        this.oyB = i;
        return this;
    }

    /* renamed from: a */
    public static C44222az m79813a(C44222az c44222az, int i) {
        AppMethodBeat.m2504i(59003);
        C44222az c44222az2 = new C44222az(c44222az.tag);
        c44222az2.oyB = i;
        AppMethodBeat.m2505o(59003);
        return c44222az2;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(59004);
        boolean equals;
        if (obj instanceof C44222az) {
            equals = ((C44222az) obj).tag.equals(this.tag);
            AppMethodBeat.m2505o(59004);
            return equals;
        }
        equals = super.equals(obj);
        AppMethodBeat.m2505o(59004);
        return equals;
    }

    public final String toString() {
        AppMethodBeat.m2504i(59005);
        String str = this.tag + "@" + this.oyB;
        AppMethodBeat.m2505o(59005);
        return str;
    }
}
