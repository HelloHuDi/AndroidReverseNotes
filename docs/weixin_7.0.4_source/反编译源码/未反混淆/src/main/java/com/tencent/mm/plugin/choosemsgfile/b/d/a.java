package com.tencent.mm.plugin.choosemsgfile.b.d;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.MsgFile;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class a {
    private Map<Long, MsgFile> kvr = new ConcurrentHashMap();
    public boolean kvs;
    private Set<Long> kvt = new HashSet();
    public int mMaxCount = BaseClientBuilder.API_PRIORITY_OTHER;

    public a() {
        AppMethodBeat.i(54378);
        AppMethodBeat.o(54378);
    }

    public final synchronized void init(int i) {
        AppMethodBeat.i(54379);
        ab.i("MicroMsg.ChooseMsgFileHelper", "init count:%d", Integer.valueOf(i));
        this.mMaxCount = i;
        this.kvr.clear();
        AppMethodBeat.o(54379);
    }

    public final synchronized void uninit() {
        AppMethodBeat.i(54380);
        ab.i("MicroMsg.ChooseMsgFileHelper", "uninit");
        this.kvr.clear();
        this.kvr = null;
        this.kvt.clear();
        this.kvt = null;
        AppMethodBeat.o(54380);
    }

    public final boolean kq() {
        AppMethodBeat.i(54381);
        if (this.kvr == null) {
            ab.e("MicroMsg.ChooseMsgFileHelper", "isInvalid() msgIdToMsgFile is null, return");
            AppMethodBeat.o(54381);
            return false;
        } else if (this.kvr.size() >= this.mMaxCount) {
            AppMethodBeat.o(54381);
            return true;
        } else {
            AppMethodBeat.o(54381);
            return false;
        }
    }

    public final boolean bfD() {
        AppMethodBeat.i(54382);
        if (this.kvr == null) {
            ab.e("MicroMsg.ChooseMsgFileHelper", "isChange() msgIdToMsgFile is null, return");
            AppMethodBeat.o(54382);
            return false;
        } else if (this.kvr.size() == this.mMaxCount - 1 || this.kvr.size() == this.mMaxCount) {
            AppMethodBeat.o(54382);
            return true;
        } else {
            AppMethodBeat.o(54382);
            return false;
        }
    }

    public final boolean a(long j, MsgFile msgFile) {
        AppMethodBeat.i(54383);
        if (j == -1) {
            ab.e("MicroMsg.ChooseMsgFileHelper", "msgid is invalid");
            AppMethodBeat.o(54383);
            return false;
        } else if (msgFile == null) {
            ab.e("MicroMsg.ChooseMsgFileHelper", "msgFile is null");
            AppMethodBeat.o(54383);
            return false;
        } else if (bo.isNullOrNil(msgFile.filePath)) {
            ab.e("MicroMsg.ChooseMsgFileHelper", "filePath is invalid");
            AppMethodBeat.o(54383);
            return false;
        } else if (kq()) {
            ab.e("MicroMsg.ChooseMsgFileHelper", "exceed max:%d", Integer.valueOf(this.mMaxCount));
            AppMethodBeat.o(54383);
            return false;
        } else if (this.kvr == null) {
            ab.e("MicroMsg.ChooseMsgFileHelper", "msgIdToMsgFile is null, return");
            AppMethodBeat.o(54383);
            return false;
        } else {
            ab.i("MicroMsg.ChooseMsgFileHelper", "msgIdToFilePath put msgId:%d filePath:%s", Long.valueOf(j), msgFile);
            this.kvr.put(Long.valueOf(j), msgFile);
            AppMethodBeat.o(54383);
            return true;
        }
    }

    public final boolean gV(long j) {
        AppMethodBeat.i(54384);
        if (j == -1) {
            ab.e("MicroMsg.ChooseMsgFileHelper", "msgid is invalid");
            AppMethodBeat.o(54384);
            return false;
        } else if (this.kvr == null) {
            ab.e("MicroMsg.ChooseMsgFileHelper", "msgIdToMsgFile is null, return");
            AppMethodBeat.o(54384);
            return false;
        } else {
            ab.i("MicroMsg.ChooseMsgFileHelper", "msgIdToFilePath remove msgId:%d", Long.valueOf(j));
            this.kvr.remove(Long.valueOf(j));
            AppMethodBeat.o(54384);
            return true;
        }
    }

    public final boolean gW(long j) {
        AppMethodBeat.i(54385);
        if (this.kvr == null) {
            AppMethodBeat.o(54385);
            return false;
        }
        boolean containsKey = this.kvr.containsKey(Long.valueOf(j));
        AppMethodBeat.o(54385);
        return containsKey;
    }

    public final int getSelectCount() {
        AppMethodBeat.i(54386);
        if (this.kvr == null) {
            AppMethodBeat.o(54386);
            return 0;
        }
        int size = this.kvr.size();
        AppMethodBeat.o(54386);
        return size;
    }

    public final ArrayList<MsgFile> bfE() {
        AppMethodBeat.i(54387);
        if (this.kvr == null || this.kvr.size() == 0) {
            ab.e("MicroMsg.ChooseMsgFileHelper", "msgIdToFilePath is null, return");
            AppMethodBeat.o(54387);
            return null;
        }
        ArrayList<MsgFile> arrayList = new ArrayList();
        for (MsgFile add : this.kvr.values()) {
            arrayList.add(add);
        }
        AppMethodBeat.o(54387);
        return arrayList;
    }

    public final synchronized void gX(long j) {
        AppMethodBeat.i(54388);
        if (this.kvt != null) {
            this.kvt.add(Long.valueOf(j));
        }
        AppMethodBeat.o(54388);
    }

    public final synchronized void gY(long j) {
        AppMethodBeat.i(54389);
        if (this.kvt != null) {
            this.kvt.remove(Long.valueOf(j));
        }
        AppMethodBeat.o(54389);
    }

    public final synchronized boolean gZ(long j) {
        boolean z;
        AppMethodBeat.i(54390);
        if (this.kvt == null || !this.kvt.contains(Long.valueOf(j))) {
            z = false;
            AppMethodBeat.o(54390);
        } else {
            z = true;
            AppMethodBeat.o(54390);
        }
        return z;
    }

    public final synchronized boolean bfF() {
        boolean z;
        AppMethodBeat.i(54391);
        if (this.kvt == null || this.kvt.size() <= 0) {
            z = false;
            AppMethodBeat.o(54391);
        } else {
            z = true;
            AppMethodBeat.o(54391);
        }
        return z;
    }
}
