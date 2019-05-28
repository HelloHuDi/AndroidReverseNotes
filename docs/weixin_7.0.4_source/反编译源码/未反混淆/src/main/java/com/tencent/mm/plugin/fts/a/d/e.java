package com.tencent.mm.plugin.fts.a.d;

import android.view.View;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public interface e {

    public static class a {
        public int businessType = 0;
        public g mDz = null;
        public int mFb = BaseClientBuilder.API_PRIORITY_OTHER;
        public boolean mFc = true;
        public int mFd = BaseClientBuilder.API_PRIORITY_OTHER;
        public boolean mFe = false;
        public List<l> mFf = null;
        public boolean mFg = true;
        public l mFh;
        public int mFi = 0;

        public final String toString() {
            int i = 0;
            AppMethodBeat.i(114298);
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
            AppMethodBeat.o(114298);
            return format;
        }
    }

    public interface b {
        void a(e eVar, String str);
    }

    void a(String str, ak akVar, HashSet<String> hashSet);

    boolean a(View view, com.tencent.mm.plugin.fts.a.d.a.a aVar, boolean z);

    void bAr();

    LinkedList<Integer> bAs();

    int bAt();

    void clearData();

    int getType();

    int vY(int i);

    com.tencent.mm.plugin.fts.a.d.a.a vZ(int i);
}
