package com.tencent.p177mm.plugin.fav.p407a;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.fav.a.d */
public final class C43054d {
    private static C43054d meL = null;
    private long endTime = -1;
    private boolean hZu = false;
    C7306ak mHandler = new C7306ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(102624);
            Iterator it = C43054d.this.meK.iterator();
            while (it.hasNext()) {
                C27965a c27965a = (C27965a) it.next();
                if (c27965a != null) {
                    c27965a.onFinish();
                }
            }
            C43054d.this.meK.clear();
            AppMethodBeat.m2505o(102624);
        }
    };
    public ArrayList<C27965a> meK = new ArrayList();
    private Object meM = new Object();
    private Runnable meN = new C430551();
    private long startTime = -1;

    /* renamed from: com.tencent.mm.plugin.fav.a.d$a */
    public interface C27965a {
        void onFinish();
    }

    /* renamed from: com.tencent.mm.plugin.fav.a.d$1 */
    class C430551 implements Runnable {
        C430551() {
        }

        public final void run() {
            AppMethodBeat.m2504i(102623);
            ((C7604ae) C1720g.m3530M(C7604ae.class)).getFavItemInfoStorage().bva();
            C43054d.this.endTime = System.currentTimeMillis();
            C4990ab.m7411d("MicroMsg.FavCleanFirstLoader", "calDataBaseDataTotalLength, used: %dms", Long.valueOf(C43054d.this.endTime - C43054d.this.startTime));
            C43054d.this.endTime = -1;
            C43054d.this.startTime = -1;
            synchronized (C43054d.this.meM) {
                try {
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERFINO_FAV_HAS_DB_DATATOTALLENGTH_BOOLEAN, Boolean.TRUE);
                    C43054d.this.hZu = false;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(102623);
                }
            }
            C43054d.this.mHandler.sendEmptyMessage(0);
        }
    }

    private C43054d() {
        AppMethodBeat.m2504i(102625);
        AppMethodBeat.m2505o(102625);
    }

    public static synchronized C43054d bur() {
        C43054d c43054d;
        synchronized (C43054d.class) {
            AppMethodBeat.m2504i(102626);
            if (meL == null) {
                meL = new C43054d();
            }
            c43054d = meL;
            AppMethodBeat.m2505o(102626);
        }
        return c43054d;
    }

    /* renamed from: a */
    public final void mo68585a(C27965a c27965a) {
        AppMethodBeat.m2504i(102627);
        synchronized (this.meM) {
            try {
                if (!((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERFINO_FAV_HAS_DB_DATATOTALLENGTH_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                    if (c27965a != null) {
                        this.meK.add(c27965a);
                    }
                    if (this.hZu) {
                        C4990ab.m7416i("MicroMsg.FavCleanFirstLoader", "isLoading is true, ignore");
                        AppMethodBeat.m2505o(102627);
                        return;
                    }
                    this.hZu = true;
                    this.startTime = System.currentTimeMillis();
                    C7305d.post(this.meN, "FavCleanFirstLoader_CalFavDataLength");
                    AppMethodBeat.m2505o(102627);
                } else if (c27965a != null) {
                    c27965a.onFinish();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(102627);
            }
        }
    }
}
