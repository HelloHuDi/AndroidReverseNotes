package com.tencent.p177mm.p235i;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.i.c */
public final class C18496c {
    public String cHr;
    public int field_finishedLength;
    public boolean field_isUploadTask = false;
    public boolean field_mtlnotify;
    public int field_status;
    public int field_toltalLength;

    public final String toString() {
        AppMethodBeat.m2504i(128589);
        String format = String.format("id:%s total:%d finLen:%d status:%d,mtl:%b, upload:%b", new Object[]{this.cHr, Integer.valueOf(this.field_toltalLength), Integer.valueOf(this.field_finishedLength), Integer.valueOf(this.field_status), Boolean.valueOf(this.field_mtlnotify), Boolean.valueOf(this.field_isUploadTask)});
        AppMethodBeat.m2505o(128589);
        return format;
    }
}
