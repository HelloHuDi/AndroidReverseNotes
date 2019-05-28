package com.tencent.liteav.network;

import android.os.Bundle;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class d implements f {
    private f a = null;
    private b b = null;
    private long c = 0;
    private long d = 0;
    private b e = null;
    private a f;
    private long g = 0;
    private long h = 0;

    public interface a {
        void onSwitchFinish(TXIStreamDownloader tXIStreamDownloader, boolean z);
    }

    static class b implements com.tencent.liteav.basic.d.a, f {
        private final int a = 2;
        private long b = 0;
        private long c = 0;
        private int d = 0;
        private boolean e = false;
        private long f = 0;
        private long g = 0;
        private long h = 0;
        private ArrayList<com.tencent.liteav.basic.g.b> i = new ArrayList();
        private ArrayList<com.tencent.liteav.basic.g.a> j = new ArrayList();
        private TXIStreamDownloader k = null;
        private WeakReference<d> l;
        private f m;

        public b(TXIStreamDownloader tXIStreamDownloader, d dVar) {
            AppMethodBeat.i(67584);
            this.l = new WeakReference(dVar);
            this.k = tXIStreamDownloader;
            this.k.setListener(this);
            AppMethodBeat.o(67584);
        }

        public void a(long j) {
            AppMethodBeat.i(67585);
            this.d = 0;
            this.b = j;
            this.k.setListener(this);
            this.k.setNotifyListener(this);
            AppMethodBeat.o(67585);
        }

        public void b(long j) {
            AppMethodBeat.i(67586);
            this.b = 0;
            this.f = j;
            this.h = 0;
            this.g = 0;
            if (this.k != null && this.f == 0) {
                this.k.stopDownload();
                this.k = null;
            }
            AppMethodBeat.o(67586);
        }

        public void a(f fVar) {
            this.m = fVar;
        }

        public void onPullAudio(com.tencent.liteav.basic.g.a aVar) {
            AppMethodBeat.i(67587);
            if (this.b > 0) {
                a(aVar);
                AppMethodBeat.o(67587);
            } else if (this.f > 0) {
                b(aVar);
                AppMethodBeat.o(67587);
            } else {
                if (this.m != null) {
                    this.m.onPullAudio(aVar);
                }
                AppMethodBeat.o(67587);
            }
        }

        public void onPullNAL(com.tencent.liteav.basic.g.b bVar) {
            AppMethodBeat.i(67588);
            if (bVar == null) {
                AppMethodBeat.o(67588);
            } else if (this.b > 0) {
                a(bVar);
                AppMethodBeat.o(67588);
            } else if (this.f > 0) {
                b(bVar);
                AppMethodBeat.o(67588);
            } else {
                if (this.m != null) {
                    this.m.onPullNAL(bVar);
                }
                AppMethodBeat.o(67588);
            }
        }

        private void a(com.tencent.liteav.basic.g.a aVar) {
            AppMethodBeat.i(67589);
            if (aVar == null) {
                AppMethodBeat.o(67589);
            } else if (aVar.e < this.c || aVar.e < this.b) {
                AppMethodBeat.o(67589);
            } else if (this.m == null || this.c <= 0 || aVar.e < this.c) {
                this.j.add(aVar);
                AppMethodBeat.o(67589);
            } else {
                this.m.onPullAudio(aVar);
                AppMethodBeat.o(67589);
            }
        }

        private void b(com.tencent.liteav.basic.g.a aVar) {
            AppMethodBeat.i(67590);
            if (this.h > 0) {
                AppMethodBeat.o(67590);
            } else if (this.g <= 0 || aVar == null || aVar.e < this.g) {
                if (this.m != null) {
                    this.m.onPullAudio(aVar);
                }
                AppMethodBeat.o(67590);
            } else {
                this.h = aVar.e;
                AppMethodBeat.o(67590);
            }
        }

        private void a(com.tencent.liteav.basic.g.b bVar) {
            AppMethodBeat.i(67591);
            d dVar = (d) this.l.get();
            if (bVar.b == 0 && !this.e) {
                this.d++;
                if (dVar != null && (dVar.d <= bVar.g || this.d == 2)) {
                    this.b = dVar.a(bVar.g);
                    this.e = true;
                }
                if (dVar != null) {
                    TXCLog.w("TXCMultiStreamDownloader", " stream_switch pre start begin gop " + this.d + " last iframe ts " + dVar.d + " pts " + bVar.g + " from " + this.b + " type " + bVar.b);
                }
            }
            if (this.e) {
                if (dVar != null) {
                    dVar.b(bVar.g);
                }
                if (bVar.g >= this.b) {
                    if (bVar.b == 0 && this.c == 0) {
                        this.c = bVar.g;
                        TXCLog.w("TXCMultiStreamDownloader", " stream_switch pre start end " + bVar.g + " from " + this.b + " type " + bVar.b);
                    }
                    if (this.c > 0) {
                        if (this.m != null) {
                            Iterator it;
                            if (!this.j.isEmpty()) {
                                it = this.j.iterator();
                                while (it.hasNext()) {
                                    com.tencent.liteav.basic.g.a aVar = (com.tencent.liteav.basic.g.a) it.next();
                                    if (aVar.e >= this.c) {
                                        TXCLog.i("TXCMultiStreamDownloader", " stream_switch pre start cache audio pts " + aVar.e + " from " + this.c);
                                        this.m.onPullAudio(aVar);
                                    }
                                }
                                TXCLog.w("TXCMultiStreamDownloader", " stream_switch pre start end audio cache  " + this.j.size());
                                this.j.clear();
                            }
                            if (!this.i.isEmpty()) {
                                TXCLog.w("TXCMultiStreamDownloader", " stream_switch pre start end video cache  " + this.i.size());
                                it = this.i.iterator();
                                while (it.hasNext()) {
                                    this.m.onPullNAL((com.tencent.liteav.basic.g.b) it.next());
                                }
                                this.i.clear();
                            }
                            this.m.onPullNAL(bVar);
                            this.m = null;
                            if (dVar != null) {
                                dVar.a(this.k, true);
                            }
                            this.k.setNotifyListener(null);
                            AppMethodBeat.o(67591);
                            return;
                        }
                        TXCLog.i("TXCMultiStreamDownloader", " stream_switch pre start cache video pts " + bVar.g + " from " + this.c + " type " + bVar.b);
                        this.i.add(bVar);
                    }
                }
                AppMethodBeat.o(67591);
                return;
            }
            AppMethodBeat.o(67591);
        }

        private void b(com.tencent.liteav.basic.g.b bVar) {
            AppMethodBeat.i(67592);
            d dVar = (d) this.l.get();
            if (dVar != null) {
                dVar.c(bVar.g);
            }
            if (bVar.g >= this.f) {
                if (bVar.b == 0) {
                    this.g = bVar.g;
                }
                if (this.g > 0) {
                    if (this.h > 0) {
                        TXCLog.w("TXCMultiStreamDownloader", " stream_switch delay stop end video pts " + this.g + " audio ts " + this.h + " from " + this.f);
                        if (dVar != null) {
                            dVar.b();
                        }
                        this.m = null;
                        this.k.setListener(null);
                        this.k.stopDownload();
                        AppMethodBeat.o(67592);
                        return;
                    }
                    TXCLog.w("TXCMultiStreamDownloader", " stream_switch delay stop video end wait audio end video pts " + bVar.g + " from " + this.f + " type " + bVar.b);
                    AppMethodBeat.o(67592);
                    return;
                } else if (this.m != null) {
                    this.m.onPullNAL(bVar);
                    AppMethodBeat.o(67592);
                    return;
                }
            } else if (this.m != null) {
                this.m.onPullNAL(bVar);
            }
            AppMethodBeat.o(67592);
        }

        public void onNotifyEvent(int i, Bundle bundle) {
            AppMethodBeat.i(67593);
            if (i == TXCStreamDownloader.TXE_DOWNLOAD_ERROR_DISCONNECT || i == TXCStreamDownloader.TXE_DOWNLOAD_ERROR_CONNECT_FAILED) {
                d dVar = (d) this.l.get();
                if (dVar != null) {
                    dVar.a(this.k, false);
                }
                this.k.setNotifyListener(null);
            }
            AppMethodBeat.o(67593);
        }
    }

    public void a(f fVar) {
        this.a = fVar;
    }

    public d(a aVar) {
        this.f = aVar;
    }

    public void a() {
        AppMethodBeat.i(67565);
        if (this.b != null) {
            this.b.b(0);
        }
        if (this.e != null) {
            this.e.b(0);
        }
        AppMethodBeat.o(67565);
    }

    public void a(TXIStreamDownloader tXIStreamDownloader, TXIStreamDownloader tXIStreamDownloader2, long j, long j2, String str) {
        AppMethodBeat.i(67566);
        this.c = j;
        this.d = j2;
        this.b = new b(tXIStreamDownloader, this);
        this.b.a((f) this);
        Vector vector = new Vector();
        vector.add(new e(str, false));
        tXIStreamDownloader2.setOriginUrl(str);
        tXIStreamDownloader2.startDownload(vector, false, false, tXIStreamDownloader.mEnableMessage);
        this.e = new b(tXIStreamDownloader2, this);
        this.e.a(this.c);
        AppMethodBeat.o(67566);
    }

    /* Access modifiers changed, original: 0000 */
    public void b() {
        AppMethodBeat.i(67567);
        this.b.a(null);
        this.e.a((f) this);
        this.b = this.e;
        this.e = null;
        TXCLog.w("TXCMultiStreamDownloader", " stream_switch end at " + this.c + " stop ts " + this.h + " start ts " + this.g + " diff ts " + (this.h > this.g ? this.h - this.g : this.g - this.h));
        AppMethodBeat.o(67567);
    }

    /* Access modifiers changed, original: 0000 */
    public void a(TXIStreamDownloader tXIStreamDownloader, boolean z) {
        AppMethodBeat.i(67568);
        if (this.f != null) {
            this.f.onSwitchFinish(tXIStreamDownloader, z);
        }
        AppMethodBeat.o(67568);
    }

    /* Access modifiers changed, original: 0000 */
    public long a(long j) {
        AppMethodBeat.i(67569);
        if (this.b != null) {
            this.b.b(this.c);
        }
        TXCLog.w("TXCMultiStreamDownloader", " stream_switch delay stop begin from " + this.c);
        long j2 = this.c;
        AppMethodBeat.o(67569);
        return j2;
    }

    /* Access modifiers changed, original: 0000 */
    public void b(long j) {
        this.g = j;
    }

    /* Access modifiers changed, original: 0000 */
    public void c(long j) {
        this.h = j;
    }

    public void onPullAudio(com.tencent.liteav.basic.g.a aVar) {
        AppMethodBeat.i(67570);
        if (this.a != null) {
            this.a.onPullAudio(aVar);
        }
        AppMethodBeat.o(67570);
    }

    public void onPullNAL(com.tencent.liteav.basic.g.b bVar) {
        AppMethodBeat.i(67571);
        this.c = bVar.g;
        if (bVar.b == 0) {
            this.d = bVar.g;
        }
        if (this.a != null) {
            this.a.onPullNAL(bVar);
        }
        AppMethodBeat.o(67571);
    }
}
