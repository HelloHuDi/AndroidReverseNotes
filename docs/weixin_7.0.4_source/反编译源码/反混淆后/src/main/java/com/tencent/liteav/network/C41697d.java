package com.tencent.liteav.network;

import android.os.Bundle;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p140d.C0946a;
import com.tencent.liteav.basic.p811g.C25648a;
import com.tencent.liteav.basic.p811g.C25649b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

/* renamed from: com.tencent.liteav.network.d */
public class C41697d implements C25665f {
    /* renamed from: a */
    private C25665f f17071a = null;
    /* renamed from: b */
    private C17793b f17072b = null;
    /* renamed from: c */
    private long f17073c = 0;
    /* renamed from: d */
    private long f17074d = 0;
    /* renamed from: e */
    private C17793b f17075e = null;
    /* renamed from: f */
    private C17792a f17076f;
    /* renamed from: g */
    private long f17077g = 0;
    /* renamed from: h */
    private long f17078h = 0;

    /* renamed from: com.tencent.liteav.network.d$a */
    public interface C17792a {
        void onSwitchFinish(TXIStreamDownloader tXIStreamDownloader, boolean z);
    }

    /* renamed from: com.tencent.liteav.network.d$b */
    static class C17793b implements C0946a, C25665f {
        /* renamed from: a */
        private final int f4213a = 2;
        /* renamed from: b */
        private long f4214b = 0;
        /* renamed from: c */
        private long f4215c = 0;
        /* renamed from: d */
        private int f4216d = 0;
        /* renamed from: e */
        private boolean f4217e = false;
        /* renamed from: f */
        private long f4218f = 0;
        /* renamed from: g */
        private long f4219g = 0;
        /* renamed from: h */
        private long f4220h = 0;
        /* renamed from: i */
        private ArrayList<C25649b> f4221i = new ArrayList();
        /* renamed from: j */
        private ArrayList<C25648a> f4222j = new ArrayList();
        /* renamed from: k */
        private TXIStreamDownloader f4223k = null;
        /* renamed from: l */
        private WeakReference<C41697d> f4224l;
        /* renamed from: m */
        private C25665f f4225m;

        public C17793b(TXIStreamDownloader tXIStreamDownloader, C41697d c41697d) {
            AppMethodBeat.m2504i(67584);
            this.f4224l = new WeakReference(c41697d);
            this.f4223k = tXIStreamDownloader;
            this.f4223k.setListener(this);
            AppMethodBeat.m2505o(67584);
        }

        /* renamed from: a */
        public void mo32940a(long j) {
            AppMethodBeat.m2504i(67585);
            this.f4216d = 0;
            this.f4214b = j;
            this.f4223k.setListener(this);
            this.f4223k.setNotifyListener(this);
            AppMethodBeat.m2505o(67585);
        }

        /* renamed from: b */
        public void mo32942b(long j) {
            AppMethodBeat.m2504i(67586);
            this.f4214b = 0;
            this.f4218f = j;
            this.f4220h = 0;
            this.f4219g = 0;
            if (this.f4223k != null && this.f4218f == 0) {
                this.f4223k.stopDownload();
                this.f4223k = null;
            }
            AppMethodBeat.m2505o(67586);
        }

        /* renamed from: a */
        public void mo32941a(C25665f c25665f) {
            this.f4225m = c25665f;
        }

        public void onPullAudio(C25648a c25648a) {
            AppMethodBeat.m2504i(67587);
            if (this.f4214b > 0) {
                m27819a(c25648a);
                AppMethodBeat.m2505o(67587);
            } else if (this.f4218f > 0) {
                m27821b(c25648a);
                AppMethodBeat.m2505o(67587);
            } else {
                if (this.f4225m != null) {
                    this.f4225m.onPullAudio(c25648a);
                }
                AppMethodBeat.m2505o(67587);
            }
        }

        public void onPullNAL(C25649b c25649b) {
            AppMethodBeat.m2504i(67588);
            if (c25649b == null) {
                AppMethodBeat.m2505o(67588);
            } else if (this.f4214b > 0) {
                m27820a(c25649b);
                AppMethodBeat.m2505o(67588);
            } else if (this.f4218f > 0) {
                m27822b(c25649b);
                AppMethodBeat.m2505o(67588);
            } else {
                if (this.f4225m != null) {
                    this.f4225m.onPullNAL(c25649b);
                }
                AppMethodBeat.m2505o(67588);
            }
        }

        /* renamed from: a */
        private void m27819a(C25648a c25648a) {
            AppMethodBeat.m2504i(67589);
            if (c25648a == null) {
                AppMethodBeat.m2505o(67589);
            } else if (c25648a.f5249e < this.f4215c || c25648a.f5249e < this.f4214b) {
                AppMethodBeat.m2505o(67589);
            } else if (this.f4225m == null || this.f4215c <= 0 || c25648a.f5249e < this.f4215c) {
                this.f4222j.add(c25648a);
                AppMethodBeat.m2505o(67589);
            } else {
                this.f4225m.onPullAudio(c25648a);
                AppMethodBeat.m2505o(67589);
            }
        }

        /* renamed from: b */
        private void m27821b(C25648a c25648a) {
            AppMethodBeat.m2504i(67590);
            if (this.f4220h > 0) {
                AppMethodBeat.m2505o(67590);
            } else if (this.f4219g <= 0 || c25648a == null || c25648a.f5249e < this.f4219g) {
                if (this.f4225m != null) {
                    this.f4225m.onPullAudio(c25648a);
                }
                AppMethodBeat.m2505o(67590);
            } else {
                this.f4220h = c25648a.f5249e;
                AppMethodBeat.m2505o(67590);
            }
        }

        /* renamed from: a */
        private void m27820a(C25649b c25649b) {
            AppMethodBeat.m2504i(67591);
            C41697d c41697d = (C41697d) this.f4224l.get();
            if (c25649b.f5252b == 0 && !this.f4217e) {
                this.f4216d++;
                if (c41697d != null && (c41697d.f17074d <= c25649b.f5257g || this.f4216d == 2)) {
                    this.f4214b = c41697d.mo67331a(c25649b.f5257g);
                    this.f4217e = true;
                }
                if (c41697d != null) {
                    TXCLog.m15679w("TXCMultiStreamDownloader", " stream_switch pre start begin gop " + this.f4216d + " last iframe ts " + c41697d.f17074d + " pts " + c25649b.f5257g + " from " + this.f4214b + " type " + c25649b.f5252b);
                }
            }
            if (this.f4217e) {
                if (c41697d != null) {
                    c41697d.mo67337b(c25649b.f5257g);
                }
                if (c25649b.f5257g >= this.f4214b) {
                    if (c25649b.f5252b == 0 && this.f4215c == 0) {
                        this.f4215c = c25649b.f5257g;
                        TXCLog.m15679w("TXCMultiStreamDownloader", " stream_switch pre start end " + c25649b.f5257g + " from " + this.f4214b + " type " + c25649b.f5252b);
                    }
                    if (this.f4215c > 0) {
                        if (this.f4225m != null) {
                            Iterator it;
                            if (!this.f4222j.isEmpty()) {
                                it = this.f4222j.iterator();
                                while (it.hasNext()) {
                                    C25648a c25648a = (C25648a) it.next();
                                    if (c25648a.f5249e >= this.f4215c) {
                                        TXCLog.m15677i("TXCMultiStreamDownloader", " stream_switch pre start cache audio pts " + c25648a.f5249e + " from " + this.f4215c);
                                        this.f4225m.onPullAudio(c25648a);
                                    }
                                }
                                TXCLog.m15679w("TXCMultiStreamDownloader", " stream_switch pre start end audio cache  " + this.f4222j.size());
                                this.f4222j.clear();
                            }
                            if (!this.f4221i.isEmpty()) {
                                TXCLog.m15679w("TXCMultiStreamDownloader", " stream_switch pre start end video cache  " + this.f4221i.size());
                                it = this.f4221i.iterator();
                                while (it.hasNext()) {
                                    this.f4225m.onPullNAL((C25649b) it.next());
                                }
                                this.f4221i.clear();
                            }
                            this.f4225m.onPullNAL(c25649b);
                            this.f4225m = null;
                            if (c41697d != null) {
                                c41697d.mo67334a(this.f4223k, true);
                            }
                            this.f4223k.setNotifyListener(null);
                            AppMethodBeat.m2505o(67591);
                            return;
                        }
                        TXCLog.m15677i("TXCMultiStreamDownloader", " stream_switch pre start cache video pts " + c25649b.f5257g + " from " + this.f4215c + " type " + c25649b.f5252b);
                        this.f4221i.add(c25649b);
                    }
                }
                AppMethodBeat.m2505o(67591);
                return;
            }
            AppMethodBeat.m2505o(67591);
        }

        /* renamed from: b */
        private void m27822b(C25649b c25649b) {
            AppMethodBeat.m2504i(67592);
            C41697d c41697d = (C41697d) this.f4224l.get();
            if (c41697d != null) {
                c41697d.mo67338c(c25649b.f5257g);
            }
            if (c25649b.f5257g >= this.f4218f) {
                if (c25649b.f5252b == 0) {
                    this.f4219g = c25649b.f5257g;
                }
                if (this.f4219g > 0) {
                    if (this.f4220h > 0) {
                        TXCLog.m15679w("TXCMultiStreamDownloader", " stream_switch delay stop end video pts " + this.f4219g + " audio ts " + this.f4220h + " from " + this.f4218f);
                        if (c41697d != null) {
                            c41697d.mo67336b();
                        }
                        this.f4225m = null;
                        this.f4223k.setListener(null);
                        this.f4223k.stopDownload();
                        AppMethodBeat.m2505o(67592);
                        return;
                    }
                    TXCLog.m15679w("TXCMultiStreamDownloader", " stream_switch delay stop video end wait audio end video pts " + c25649b.f5257g + " from " + this.f4218f + " type " + c25649b.f5252b);
                    AppMethodBeat.m2505o(67592);
                    return;
                } else if (this.f4225m != null) {
                    this.f4225m.onPullNAL(c25649b);
                    AppMethodBeat.m2505o(67592);
                    return;
                }
            } else if (this.f4225m != null) {
                this.f4225m.onPullNAL(c25649b);
            }
            AppMethodBeat.m2505o(67592);
        }

        public void onNotifyEvent(int i, Bundle bundle) {
            AppMethodBeat.m2504i(67593);
            if (i == TXCStreamDownloader.TXE_DOWNLOAD_ERROR_DISCONNECT || i == TXCStreamDownloader.TXE_DOWNLOAD_ERROR_CONNECT_FAILED) {
                C41697d c41697d = (C41697d) this.f4224l.get();
                if (c41697d != null) {
                    c41697d.mo67334a(this.f4223k, false);
                }
                this.f4223k.setNotifyListener(null);
            }
            AppMethodBeat.m2505o(67593);
        }
    }

    /* renamed from: a */
    public void mo67335a(C25665f c25665f) {
        this.f17071a = c25665f;
    }

    public C41697d(C17792a c17792a) {
        this.f17076f = c17792a;
    }

    /* renamed from: a */
    public void mo67332a() {
        AppMethodBeat.m2504i(67565);
        if (this.f17072b != null) {
            this.f17072b.mo32942b(0);
        }
        if (this.f17075e != null) {
            this.f17075e.mo32942b(0);
        }
        AppMethodBeat.m2505o(67565);
    }

    /* renamed from: a */
    public void mo67333a(TXIStreamDownloader tXIStreamDownloader, TXIStreamDownloader tXIStreamDownloader2, long j, long j2, String str) {
        AppMethodBeat.m2504i(67566);
        this.f17073c = j;
        this.f17074d = j2;
        this.f17072b = new C17793b(tXIStreamDownloader, this);
        this.f17072b.mo32941a((C25665f) this);
        Vector vector = new Vector();
        vector.add(new C17794e(str, false));
        tXIStreamDownloader2.setOriginUrl(str);
        tXIStreamDownloader2.startDownload(vector, false, false, tXIStreamDownloader.mEnableMessage);
        this.f17075e = new C17793b(tXIStreamDownloader2, this);
        this.f17075e.mo32940a(this.f17073c);
        AppMethodBeat.m2505o(67566);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public void mo67336b() {
        AppMethodBeat.m2504i(67567);
        this.f17072b.mo32941a(null);
        this.f17075e.mo32941a((C25665f) this);
        this.f17072b = this.f17075e;
        this.f17075e = null;
        TXCLog.m15679w("TXCMultiStreamDownloader", " stream_switch end at " + this.f17073c + " stop ts " + this.f17078h + " start ts " + this.f17077g + " diff ts " + (this.f17078h > this.f17077g ? this.f17078h - this.f17077g : this.f17077g - this.f17078h));
        AppMethodBeat.m2505o(67567);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public void mo67334a(TXIStreamDownloader tXIStreamDownloader, boolean z) {
        AppMethodBeat.m2504i(67568);
        if (this.f17076f != null) {
            this.f17076f.onSwitchFinish(tXIStreamDownloader, z);
        }
        AppMethodBeat.m2505o(67568);
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: a */
    public long mo67331a(long j) {
        AppMethodBeat.m2504i(67569);
        if (this.f17072b != null) {
            this.f17072b.mo32942b(this.f17073c);
        }
        TXCLog.m15679w("TXCMultiStreamDownloader", " stream_switch delay stop begin from " + this.f17073c);
        long j2 = this.f17073c;
        AppMethodBeat.m2505o(67569);
        return j2;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: b */
    public void mo67337b(long j) {
        this.f17077g = j;
    }

    /* Access modifiers changed, original: 0000 */
    /* renamed from: c */
    public void mo67338c(long j) {
        this.f17078h = j;
    }

    public void onPullAudio(C25648a c25648a) {
        AppMethodBeat.m2504i(67570);
        if (this.f17071a != null) {
            this.f17071a.onPullAudio(c25648a);
        }
        AppMethodBeat.m2505o(67570);
    }

    public void onPullNAL(C25649b c25649b) {
        AppMethodBeat.m2504i(67571);
        this.f17073c = c25649b.f5257g;
        if (c25649b.f5252b == 0) {
            this.f17074d = c25649b.f5257g;
        }
        if (this.f17071a != null) {
            this.f17071a.onPullNAL(c25649b);
        }
        AppMethodBeat.m2505o(67571);
    }
}
