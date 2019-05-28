package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ap extends az {
    private Context e = null;
    private Long[] f = null;
    private List<Long> g = null;
    private byte[] h = null;
    private boolean i = false;

    public ap(Context context) {
        super(context, 1, 4);
        this.e = context;
    }

    private synchronized boolean f() {
        return this.i;
    }

    public final synchronized void a(boolean z) {
        this.i = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x007f A:{SYNTHETIC, Splitter:B:31:0x007f} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0072 A:{Catch:{ Exception -> 0x00e7, Throwable -> 0x012f }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized aa a() {
        aa aaVar = null;
        synchronized (this) {
            AppMethodBeat.i(98495);
            ax d = ax.d();
            if (d == null || !d.e()) {
                ag.c(" imposiable! ua not ready!", new Object[0]);
                AppMethodBeat.o(98495);
            } else {
                as g = d.g();
                if (g == null) {
                    ag.c(" imposiable! ua S not ready!", new Object[0]);
                    AppMethodBeat.o(98495);
                } else {
                    z a;
                    try {
                        Object obj;
                        if (f()) {
                            List a2 = p.a(this.e);
                            if (a2 != null && a2.size() > 0) {
                                Object obj2 = (byte[]) a2.get(3);
                                this.d = String.valueOf(a2.get(1));
                                ((Integer) a2.get(4)).intValue();
                                obj = obj2;
                                if (obj == null) {
                                    aaVar = az.a(this.a, obj);
                                    AppMethodBeat.o(98495);
                                } else {
                                    List a3;
                                    int e = g.e();
                                    if (!e.l(this.e)) {
                                        e /= 2;
                                    }
                                    if (e >= 0) {
                                        a3 = e.a(this.e, e);
                                    } else {
                                        a3 = null;
                                    }
                                    if (a3 == null || a3.size() <= 0) {
                                        ag.h(" no up datas", new Object[0]);
                                        AppMethodBeat.o(98495);
                                    } else {
                                        aa a4;
                                        ag.h(" size:%d", Integer.valueOf(a3.size()));
                                        a = a(a3);
                                        this.f = new Long[r6];
                                        for (int i = 0; i < this.f.length; i++) {
                                            this.f[i] = Long.valueOf(((av) a3.get(i)).a());
                                        }
                                        a3.clear();
                                        if (a != null) {
                                            obj2 = a.a();
                                        } else {
                                            obj2 = obj;
                                        }
                                        this.h = new byte[obj2.length];
                                        System.arraycopy(obj2, 0, this.h, 0, obj2.length);
                                        this.d = e.b(this.c, 4);
                                        ag.a("comm rid:%s", this.d);
                                        try {
                                            a4 = az.a(this.a, obj2);
                                        } catch (Exception e2) {
                                            b();
                                            a4 = null;
                                        }
                                        AppMethodBeat.o(98495);
                                        aaVar = a4;
                                    }
                                }
                            }
                        }
                        obj = null;
                        if (obj == null) {
                        }
                    } catch (Exception e3) {
                        b();
                        a = null;
                    } catch (Throwable th) {
                        ag.a(th);
                        ag.d(" get req datas error: %s", th.toString());
                        AppMethodBeat.o(98495);
                    }
                }
            }
        }
        return aaVar;
    }

    private z a(List<av> list) {
        AppMethodBeat.i(98496);
        if (list == null || list.size() <= 0) {
            AppMethodBeat.o(98496);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        this.g = new ArrayList();
        int i = 0;
        while (i < size) {
            try {
                av avVar = (av) list.get(i);
                Map e = avVar.e();
                ag.a(" bean.getTP: " + avVar.b(), new Object[0]);
                if (e != null && "UA".equals(avVar.b())) {
                    ag.f(" Pack2Upload eventName:}%s ", avVar.d());
                    ac a = e.a(avVar);
                    if (a != null) {
                        arrayList.add(a);
                    } else {
                        this.g.add(Long.valueOf(avVar.a()));
                    }
                }
                i++;
            } catch (Throwable th) {
                ag.a(th);
                ag.d(" CommonRecordUploadDatas.encode2MixPackage() error1", new Object[0]);
            }
        }
        if (this.g.size() > 0) {
            e.a(this.e, (Long[]) this.g.toArray(new Long[this.g.size()]));
        }
        ag.b(" up erList:" + arrayList.size(), new Object[0]);
        try {
            ad adVar;
            if (arrayList.size() > 0) {
                adVar = new ad();
                adVar.a = arrayList;
            } else {
                adVar = null;
            }
            if (adVar == null) {
                AppMethodBeat.o(98496);
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(Integer.valueOf(1), adVar.a());
            z zVar = new z();
            zVar.a = hashMap;
            AppMethodBeat.o(98496);
            return zVar;
        } catch (Exception e2) {
            ag.a(e2);
            ag.d(" CommonRecordUploadDatas.encode2MixPackage() error2", new Object[0]);
            b();
            AppMethodBeat.o(98496);
            return null;
        }
    }

    public final synchronized void b() {
        AppMethodBeat.i(98497);
        ag.c(" encode failed, clear db data", new Object[0]);
        if (this.f != null && this.f.length > 0) {
            ag.b(" remove num :".concat(String.valueOf(e.a(this.e, this.f))), new Object[0]);
            this.f = null;
        }
        AppMethodBeat.o(98497);
    }

    public final synchronized void b(boolean z) {
        int i = 0;
        synchronized (this) {
            AppMethodBeat.i(98498);
            if (this.f != null) {
                i = this.f.length;
            }
            if (i > 0) {
                ag.b(" t_event remove num :".concat(String.valueOf(e.a(this.e, this.f))), new Object[0]);
            }
            this.f = null;
            if (z && f()) {
                p.a(this.e, this.d);
            } else if (!z) {
                if (this.h != null) {
                    ag.a("comm rid2:%s", this.d);
                    p.a(this.e, this.h, this.d, i);
                }
            }
            this.h = null;
            AppMethodBeat.o(98498);
        }
    }
}
