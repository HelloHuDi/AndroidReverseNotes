package com.tencent.p177mm.plugin.choosemsgfile.p358b.p1605d;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.choosemsgfile.compat.MsgFile;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.choosemsgfile.b.d.a */
public final class C42886a {
    private Map<Long, MsgFile> kvr = new ConcurrentHashMap();
    public boolean kvs;
    private Set<Long> kvt = new HashSet();
    public int mMaxCount = BaseClientBuilder.API_PRIORITY_OTHER;

    public C42886a() {
        AppMethodBeat.m2504i(54378);
        AppMethodBeat.m2505o(54378);
    }

    public final synchronized void init(int i) {
        AppMethodBeat.m2504i(54379);
        C4990ab.m7417i("MicroMsg.ChooseMsgFileHelper", "init count:%d", Integer.valueOf(i));
        this.mMaxCount = i;
        this.kvr.clear();
        AppMethodBeat.m2505o(54379);
    }

    public final synchronized void uninit() {
        AppMethodBeat.m2504i(54380);
        C4990ab.m7416i("MicroMsg.ChooseMsgFileHelper", "uninit");
        this.kvr.clear();
        this.kvr = null;
        this.kvt.clear();
        this.kvt = null;
        AppMethodBeat.m2505o(54380);
    }

    /* renamed from: kq */
    public final boolean mo68419kq() {
        AppMethodBeat.m2504i(54381);
        if (this.kvr == null) {
            C4990ab.m7412e("MicroMsg.ChooseMsgFileHelper", "isInvalid() msgIdToMsgFile is null, return");
            AppMethodBeat.m2505o(54381);
            return false;
        } else if (this.kvr.size() >= this.mMaxCount) {
            AppMethodBeat.m2505o(54381);
            return true;
        } else {
            AppMethodBeat.m2505o(54381);
            return false;
        }
    }

    public final boolean bfD() {
        AppMethodBeat.m2504i(54382);
        if (this.kvr == null) {
            C4990ab.m7412e("MicroMsg.ChooseMsgFileHelper", "isChange() msgIdToMsgFile is null, return");
            AppMethodBeat.m2505o(54382);
            return false;
        } else if (this.kvr.size() == this.mMaxCount - 1 || this.kvr.size() == this.mMaxCount) {
            AppMethodBeat.m2505o(54382);
            return true;
        } else {
            AppMethodBeat.m2505o(54382);
            return false;
        }
    }

    /* renamed from: a */
    public final boolean mo68408a(long j, MsgFile msgFile) {
        AppMethodBeat.m2504i(54383);
        if (j == -1) {
            C4990ab.m7412e("MicroMsg.ChooseMsgFileHelper", "msgid is invalid");
            AppMethodBeat.m2505o(54383);
            return false;
        } else if (msgFile == null) {
            C4990ab.m7412e("MicroMsg.ChooseMsgFileHelper", "msgFile is null");
            AppMethodBeat.m2505o(54383);
            return false;
        } else if (C5046bo.isNullOrNil(msgFile.filePath)) {
            C4990ab.m7412e("MicroMsg.ChooseMsgFileHelper", "filePath is invalid");
            AppMethodBeat.m2505o(54383);
            return false;
        } else if (mo68419kq()) {
            C4990ab.m7413e("MicroMsg.ChooseMsgFileHelper", "exceed max:%d", Integer.valueOf(this.mMaxCount));
            AppMethodBeat.m2505o(54383);
            return false;
        } else if (this.kvr == null) {
            C4990ab.m7412e("MicroMsg.ChooseMsgFileHelper", "msgIdToMsgFile is null, return");
            AppMethodBeat.m2505o(54383);
            return false;
        } else {
            C4990ab.m7417i("MicroMsg.ChooseMsgFileHelper", "msgIdToFilePath put msgId:%d filePath:%s", Long.valueOf(j), msgFile);
            this.kvr.put(Long.valueOf(j), msgFile);
            AppMethodBeat.m2505o(54383);
            return true;
        }
    }

    /* renamed from: gV */
    public final boolean mo68412gV(long j) {
        AppMethodBeat.m2504i(54384);
        if (j == -1) {
            C4990ab.m7412e("MicroMsg.ChooseMsgFileHelper", "msgid is invalid");
            AppMethodBeat.m2505o(54384);
            return false;
        } else if (this.kvr == null) {
            C4990ab.m7412e("MicroMsg.ChooseMsgFileHelper", "msgIdToMsgFile is null, return");
            AppMethodBeat.m2505o(54384);
            return false;
        } else {
            C4990ab.m7417i("MicroMsg.ChooseMsgFileHelper", "msgIdToFilePath remove msgId:%d", Long.valueOf(j));
            this.kvr.remove(Long.valueOf(j));
            AppMethodBeat.m2505o(54384);
            return true;
        }
    }

    /* renamed from: gW */
    public final boolean mo68413gW(long j) {
        AppMethodBeat.m2504i(54385);
        if (this.kvr == null) {
            AppMethodBeat.m2505o(54385);
            return false;
        }
        boolean containsKey = this.kvr.containsKey(Long.valueOf(j));
        AppMethodBeat.m2505o(54385);
        return containsKey;
    }

    public final int getSelectCount() {
        AppMethodBeat.m2504i(54386);
        if (this.kvr == null) {
            AppMethodBeat.m2505o(54386);
            return 0;
        }
        int size = this.kvr.size();
        AppMethodBeat.m2505o(54386);
        return size;
    }

    public final ArrayList<MsgFile> bfE() {
        AppMethodBeat.m2504i(54387);
        if (this.kvr == null || this.kvr.size() == 0) {
            C4990ab.m7412e("MicroMsg.ChooseMsgFileHelper", "msgIdToFilePath is null, return");
            AppMethodBeat.m2505o(54387);
            return null;
        }
        ArrayList<MsgFile> arrayList = new ArrayList();
        for (MsgFile add : this.kvr.values()) {
            arrayList.add(add);
        }
        AppMethodBeat.m2505o(54387);
        return arrayList;
    }

    /* renamed from: gX */
    public final synchronized void mo68414gX(long j) {
        AppMethodBeat.m2504i(54388);
        if (this.kvt != null) {
            this.kvt.add(Long.valueOf(j));
        }
        AppMethodBeat.m2505o(54388);
    }

    /* renamed from: gY */
    public final synchronized void mo68415gY(long j) {
        AppMethodBeat.m2504i(54389);
        if (this.kvt != null) {
            this.kvt.remove(Long.valueOf(j));
        }
        AppMethodBeat.m2505o(54389);
    }

    /* renamed from: gZ */
    public final synchronized boolean mo68416gZ(long j) {
        boolean z;
        AppMethodBeat.m2504i(54390);
        if (this.kvt == null || !this.kvt.contains(Long.valueOf(j))) {
            z = false;
            AppMethodBeat.m2505o(54390);
        } else {
            z = true;
            AppMethodBeat.m2505o(54390);
        }
        return z;
    }

    public final synchronized boolean bfF() {
        boolean z;
        AppMethodBeat.m2504i(54391);
        if (this.kvt == null || this.kvt.size() <= 0) {
            z = false;
            AppMethodBeat.m2505o(54391);
        } else {
            z = true;
            AppMethodBeat.m2505o(54391);
        }
        return z;
    }
}
