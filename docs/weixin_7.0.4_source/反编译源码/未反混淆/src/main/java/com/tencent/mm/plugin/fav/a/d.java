package com.tencent.mm.plugin.fav.a;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import java.util.Iterator;

public final class d {
    private static d meL = null;
    private long endTime = -1;
    private boolean hZu = false;
    ak mHandler = new ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(102624);
            Iterator it = d.this.meK.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar != null) {
                    aVar.onFinish();
                }
            }
            d.this.meK.clear();
            AppMethodBeat.o(102624);
        }
    };
    public ArrayList<a> meK = new ArrayList();
    private Object meM = new Object();
    private Runnable meN = new Runnable() {
        public final void run() {
            AppMethodBeat.i(102623);
            ((ae) g.M(ae.class)).getFavItemInfoStorage().bva();
            d.this.endTime = System.currentTimeMillis();
            ab.d("MicroMsg.FavCleanFirstLoader", "calDataBaseDataTotalLength, used: %dms", Long.valueOf(d.this.endTime - d.this.startTime));
            d.this.endTime = -1;
            d.this.startTime = -1;
            synchronized (d.this.meM) {
                try {
                    g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERFINO_FAV_HAS_DB_DATATOTALLENGTH_BOOLEAN, Boolean.TRUE);
                    d.this.hZu = false;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(102623);
                }
            }
            d.this.mHandler.sendEmptyMessage(0);
        }
    };
    private long startTime = -1;

    public interface a {
        void onFinish();
    }

    private d() {
        AppMethodBeat.i(102625);
        AppMethodBeat.o(102625);
    }

    public static synchronized d bur() {
        d dVar;
        synchronized (d.class) {
            AppMethodBeat.i(102626);
            if (meL == null) {
                meL = new d();
            }
            dVar = meL;
            AppMethodBeat.o(102626);
        }
        return dVar;
    }

    public final void a(a aVar) {
        AppMethodBeat.i(102627);
        synchronized (this.meM) {
            try {
                if (!((Boolean) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERFINO_FAV_HAS_DB_DATATOTALLENGTH_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                    if (aVar != null) {
                        this.meK.add(aVar);
                    }
                    if (this.hZu) {
                        ab.i("MicroMsg.FavCleanFirstLoader", "isLoading is true, ignore");
                        AppMethodBeat.o(102627);
                        return;
                    }
                    this.hZu = true;
                    this.startTime = System.currentTimeMillis();
                    com.tencent.mm.sdk.g.d.post(this.meN, "FavCleanFirstLoader_CalFavDataLength");
                    AppMethodBeat.o(102627);
                } else if (aVar != null) {
                    aVar.onFinish();
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(102627);
            }
        }
    }
}
