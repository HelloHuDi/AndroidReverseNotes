package com.tencent.mm.plugin.fts.a.a;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import java.util.ArrayList;
import java.util.List;

public abstract class a implements Comparable<a> {
    public boolean mCancelled = false;
    public long mDp = 0;
    public long mDq = 0;
    public List<a> mDr;
    public Object mDs;
    public int mPriority = BaseClientBuilder.API_PRIORITY_OTHER;

    public class a {
        public String mDt;
        public long timestamp;
    }

    public abstract boolean execute();

    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.mPriority - ((a) obj).mPriority;
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
    public final void Ng(String str) {
        if (this.mDr == null) {
            this.mDr = new ArrayList();
        }
        a aVar = new a();
        aVar.mDt = str;
        aVar.timestamp = System.currentTimeMillis();
        this.mDr.add(aVar);
    }

    public String getName() {
        return "";
    }

    public String aAo() {
        return "";
    }
}
