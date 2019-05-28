package com.tencent.mm.choosemsgfile.compat;

import android.content.Context;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;

public interface a extends com.tencent.mm.kernel.c.a {

    public interface a {
        void a(int i, String str, ArrayList<MsgFile> arrayList);
    }

    void a(MMActivity mMActivity, String str, int i, String str2, a aVar);

    void a(MMActivity mMActivity, String str, String str2, int i, String str3, a aVar);

    void h(Context context, String str, String str2);
}
