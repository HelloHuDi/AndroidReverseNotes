package com.tencent.p177mm.plugin.fts.p419a.p420a;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fts.a.a.a */
public abstract class C28106a implements Comparable<C28106a> {
    public boolean mCancelled = false;
    public long mDp = 0;
    public long mDq = 0;
    public List<C28107a> mDr;
    public Object mDs;
    public int mPriority = BaseClientBuilder.API_PRIORITY_OTHER;

    /* renamed from: com.tencent.mm.plugin.fts.a.a.a$a */
    public class C28107a {
        public String mDt;
        public long timestamp;
    }

    public abstract boolean execute();

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.mPriority - ((C28106a) obj).mPriority;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public boolean isCancelled() {
        return this.mCancelled;
    }

    public int getId() {
        return -1;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: Ng */
    public final void mo46026Ng(String str) {
        if (this.mDr == null) {
            this.mDr = new ArrayList();
        }
        C28107a c28107a = new C28107a();
        c28107a.mDt = str;
        c28107a.timestamp = System.currentTimeMillis();
        this.mDr.add(c28107a);
    }

    public String getName() {
        return "";
    }

    public String aAo() {
        return "";
    }
}
