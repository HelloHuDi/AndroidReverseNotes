package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C24349e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ap */
public final class C44826ap extends C44499az {
    /* renamed from: e */
    private Context f17576e = null;
    /* renamed from: f */
    private Long[] f17577f = null;
    /* renamed from: g */
    private List<Long> f17578g = null;
    /* renamed from: h */
    private byte[] f17579h = null;
    /* renamed from: i */
    private boolean f17580i = false;

    public C44826ap(Context context) {
        super(context, 1, 4);
        this.f17576e = context;
    }

    /* renamed from: f */
    private synchronized boolean m81991f() {
        return this.f17580i;
    }

    /* renamed from: a */
    public final synchronized void mo72028a(boolean z) {
        this.f17580i = z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x007f A:{SYNTHETIC, Splitter:B:31:0x007f} */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0072 A:{Catch:{ Exception -> 0x00e7, Throwable -> 0x012f }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final synchronized C36481aa mo41919a() {
        C36481aa c36481aa = null;
        synchronized (this) {
            AppMethodBeat.m2504i(98495);
            C25011ax d = C25011ax.m39275d();
            if (d == null || !d.mo41924e()) {
                C16205ag.m24686c(" imposiable! ua not ready!", new Object[0]);
                AppMethodBeat.m2505o(98495);
            } else {
                C46769as g = d.mo41926g();
                if (g == null) {
                    C16205ag.m24686c(" imposiable! ua S not ready!", new Object[0]);
                    AppMethodBeat.m2505o(98495);
                } else {
                    C24422z a;
                    try {
                        Object obj;
                        if (m81991f()) {
                            List a2 = C44539p.m80851a(this.f17576e);
                            if (a2 != null && a2.size() > 0) {
                                Object obj2 = (byte[]) a2.get(3);
                                this.f17403d = String.valueOf(a2.get(1));
                                ((Integer) a2.get(4)).intValue();
                                obj = obj2;
                                if (obj == null) {
                                    c36481aa = C44499az.m80700a(this.f17400a, obj);
                                    AppMethodBeat.m2505o(98495);
                                } else {
                                    List a3;
                                    int e = g.mo75351e();
                                    if (!C24349e.m37620l(this.f17576e)) {
                                        e /= 2;
                                    }
                                    if (e >= 0) {
                                        a3 = C24349e.m37580a(this.f17576e, e);
                                    } else {
                                        a3 = null;
                                    }
                                    if (a3 == null || a3.size() <= 0) {
                                        C16205ag.m24691h(" no up datas", new Object[0]);
                                        AppMethodBeat.m2505o(98495);
                                    } else {
                                        C36481aa a4;
                                        C16205ag.m24691h(" size:%d", Integer.valueOf(a3.size()));
                                        a = m81990a(a3);
                                        this.f17577f = new Long[r6];
                                        for (int i = 0; i < this.f17577f.length; i++) {
                                            this.f17577f[i] = Long.valueOf(((C24356av) a3.get(i)).mo40527a());
                                        }
                                        a3.clear();
                                        if (a != null) {
                                            obj2 = a.mo65110a();
                                        } else {
                                            obj2 = obj;
                                        }
                                        this.f17579h = new byte[obj2.length];
                                        System.arraycopy(obj2, 0, this.f17579h, 0, obj2.length);
                                        this.f17403d = C24349e.m37595b(this.f17402c, 4);
                                        C16205ag.m24683a("comm rid:%s", this.f17403d);
                                        try {
                                            a4 = C44499az.m80700a(this.f17400a, obj2);
                                        } catch (Exception e2) {
                                            mo70868b();
                                            a4 = null;
                                        }
                                        AppMethodBeat.m2505o(98495);
                                        c36481aa = a4;
                                    }
                                }
                            }
                        }
                        obj = null;
                        if (obj == null) {
                        }
                    } catch (Exception e3) {
                        mo70868b();
                        a = null;
                    } catch (Throwable th) {
                        C16205ag.m24684a(th);
                        C16205ag.m24687d(" get req datas error: %s", th.toString());
                        AppMethodBeat.m2505o(98495);
                    }
                }
            }
        }
        return c36481aa;
    }

    /* renamed from: a */
    private C24422z m81990a(List<C24356av> list) {
        AppMethodBeat.m2504i(98496);
        if (list == null || list.size() <= 0) {
            AppMethodBeat.m2505o(98496);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        this.f17578g = new ArrayList();
        int i = 0;
        while (i < size) {
            try {
                C24356av c24356av = (C24356av) list.get(i);
                Map e = c24356av.mo40537e();
                C16205ag.m24683a(" bean.getTP: " + c24356av.mo40532b(), new Object[0]);
                if (e != null && "UA".equals(c24356av.mo40532b())) {
                    C16205ag.m24689f(" Pack2Upload eventName:}%s ", c24356av.mo40536d());
                    C5853ac a = C24349e.m37575a(c24356av);
                    if (a != null) {
                        arrayList.add(a);
                    } else {
                        this.f17578g.add(Long.valueOf(c24356av.mo40527a()));
                    }
                }
                i++;
            } catch (Throwable th) {
                C16205ag.m24684a(th);
                C16205ag.m24687d(" CommonRecordUploadDatas.encode2MixPackage() error1", new Object[0]);
            }
        }
        if (this.f17578g.size() > 0) {
            C24349e.m37572a(this.f17576e, (Long[]) this.f17578g.toArray(new Long[this.f17578g.size()]));
        }
        C16205ag.m24685b(" up erList:" + arrayList.size(), new Object[0]);
        try {
            C5854ad c5854ad;
            if (arrayList.size() > 0) {
                c5854ad = new C5854ad();
                c5854ad.f1519a = arrayList;
            } else {
                c5854ad = null;
            }
            if (c5854ad == null) {
                AppMethodBeat.m2505o(98496);
                return null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(Integer.valueOf(1), c5854ad.mo65110a());
            C24422z c24422z = new C24422z();
            c24422z.f4879a = hashMap;
            AppMethodBeat.m2505o(98496);
            return c24422z;
        } catch (Exception e2) {
            C16205ag.m24684a(e2);
            C16205ag.m24687d(" CommonRecordUploadDatas.encode2MixPackage() error2", new Object[0]);
            mo70868b();
            AppMethodBeat.m2505o(98496);
            return null;
        }
    }

    /* renamed from: b */
    public final synchronized void mo70868b() {
        AppMethodBeat.m2504i(98497);
        C16205ag.m24686c(" encode failed, clear db data", new Object[0]);
        if (this.f17577f != null && this.f17577f.length > 0) {
            C16205ag.m24685b(" remove num :".concat(String.valueOf(C24349e.m37572a(this.f17576e, this.f17577f))), new Object[0]);
            this.f17577f = null;
        }
        AppMethodBeat.m2505o(98497);
    }

    /* renamed from: b */
    public final synchronized void mo41920b(boolean z) {
        int i = 0;
        synchronized (this) {
            AppMethodBeat.m2504i(98498);
            if (this.f17577f != null) {
                i = this.f17577f.length;
            }
            if (i > 0) {
                C16205ag.m24685b(" t_event remove num :".concat(String.valueOf(C24349e.m37572a(this.f17576e, this.f17577f))), new Object[0]);
            }
            this.f17577f = null;
            if (z && m81991f()) {
                C44539p.m80854a(this.f17576e, this.f17403d);
            } else if (!z) {
                if (this.f17579h != null) {
                    C16205ag.m24683a("comm rid2:%s", this.f17403d);
                    C44539p.m80856a(this.f17576e, this.f17579h, this.f17403d, i);
                }
            }
            this.f17579h = null;
            AppMethodBeat.m2505o(98498);
        }
    }
}
