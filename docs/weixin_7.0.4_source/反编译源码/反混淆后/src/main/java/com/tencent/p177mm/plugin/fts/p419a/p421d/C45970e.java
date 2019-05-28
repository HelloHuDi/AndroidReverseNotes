package com.tencent.p177mm.plugin.fts.p419a.p421d;

import android.view.View;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20840g;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C45966l;
import com.tencent.p177mm.plugin.fts.p419a.p421d.p422a.C3154a;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fts.a.d.e */
public interface C45970e {

    /* renamed from: com.tencent.mm.plugin.fts.a.d.e$a */
    public static class C34203a {
        public int businessType = 0;
        public C20840g mDz = null;
        public int mFb = BaseClientBuilder.API_PRIORITY_OTHER;
        public boolean mFc = true;
        public int mFd = BaseClientBuilder.API_PRIORITY_OTHER;
        public boolean mFe = false;
        public List<C45966l> mFf = null;
        public boolean mFg = true;
        public C45966l mFh;
        public int mFi = 0;

        public final String toString() {
            int i = 0;
            AppMethodBeat.m2504i(114298);
            String str = "{%d, %b, %d, %b, %d, %d, %d}";
            Object[] objArr = new Object[7];
            objArr[0] = Integer.valueOf(this.mFb);
            objArr[1] = Boolean.valueOf(this.mFc);
            objArr[2] = Integer.valueOf(this.mFd);
            objArr[3] = Boolean.valueOf(this.mFe);
            objArr[4] = Integer.valueOf(this.businessType);
            if (this.mFf != null) {
                i = this.mFf.size();
            }
            objArr[5] = Integer.valueOf(i);
            objArr[6] = Integer.valueOf(this.mFi);
            String format = String.format(str, objArr);
            AppMethodBeat.m2505o(114298);
            return format;
        }
    }

    /* renamed from: com.tencent.mm.plugin.fts.a.d.e$b */
    public interface C39133b {
        /* renamed from: a */
        void mo7490a(C45970e c45970e, String str);
    }

    /* renamed from: a */
    void mo62049a(String str, C7306ak c7306ak, HashSet<String> hashSet);

    /* renamed from: a */
    boolean mo7424a(View view, C3154a c3154a, boolean z);

    void bAr();

    LinkedList<Integer> bAs();

    int bAt();

    void clearData();

    int getType();

    /* renamed from: vY */
    int mo51308vY(int i);

    /* renamed from: vZ */
    C3154a mo62055vZ(int i);
}
