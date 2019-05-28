package com.tencent.mm.storage;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;

public final class az {
    public static final az xYM = new az("timeline");
    public static final az xYN = new az("album_friend");
    public static final az xYO = new az("album_self");
    public static final az xYP = new az("album_stranger");
    public static final az xYQ = new az("profile_friend");
    public static final az xYR = new az("profile_stranger");
    public static final az xYS = new az(FFmpegMetadataRetriever.METADATA_KEY_COMMENT);
    public static final az xYT = new az("comment_detail");
    public static final az xYU = new az(FacebookRequestErrorClassification.KEY_OTHER);
    public static final az xYV = new az("snssight");
    public static final az xYW = new az("fts");
    public static final az xYX = new az("storysight");
    public static final az xYY = new az("storyalbum");
    public int oyB = 0;
    public String tag = "";

    static {
        AppMethodBeat.i(59006);
        AppMethodBeat.o(59006);
    }

    public static az dtg() {
        AppMethodBeat.i(58996);
        az azVar = new az("timeline");
        AppMethodBeat.o(58996);
        return azVar;
    }

    public static az dth() {
        AppMethodBeat.i(58997);
        az azVar = new az("album_friend");
        AppMethodBeat.o(58997);
        return azVar;
    }

    public static az dti() {
        AppMethodBeat.i(58998);
        az azVar = new az("album_self");
        AppMethodBeat.o(58998);
        return azVar;
    }

    public static az dtj() {
        AppMethodBeat.i(58999);
        az azVar = new az("album_stranger");
        AppMethodBeat.o(58999);
        return azVar;
    }

    public static az dtk() {
        AppMethodBeat.i(59000);
        az azVar = new az("comment_detail");
        AppMethodBeat.o(59000);
        return azVar;
    }

    public static az dtl() {
        AppMethodBeat.i(59001);
        az azVar = new az("snssight");
        AppMethodBeat.o(59001);
        return azVar;
    }

    public static az dtm() {
        AppMethodBeat.i(59002);
        az azVar = new az("storysight");
        AppMethodBeat.o(59002);
        return azVar;
    }

    public az(String str) {
        this.tag = str;
    }

    public final az Mp(int i) {
        this.oyB = i;
        return this;
    }

    public static az a(az azVar, int i) {
        AppMethodBeat.i(59003);
        az azVar2 = new az(azVar.tag);
        azVar2.oyB = i;
        AppMethodBeat.o(59003);
        return azVar2;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(59004);
        boolean equals;
        if (obj instanceof az) {
            equals = ((az) obj).tag.equals(this.tag);
            AppMethodBeat.o(59004);
            return equals;
        }
        equals = super.equals(obj);
        AppMethodBeat.o(59004);
        return equals;
    }

    public final String toString() {
        AppMethodBeat.i(59005);
        String str = this.tag + "@" + this.oyB;
        AppMethodBeat.o(59005);
        return str;
    }
}
