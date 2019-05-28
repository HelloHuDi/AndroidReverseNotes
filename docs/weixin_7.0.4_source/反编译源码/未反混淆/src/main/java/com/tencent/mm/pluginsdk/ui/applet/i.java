package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.t;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a;
import com.tencent.mm.pluginsdk.ui.applet.k.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class i {
    private Context context;
    f ehK;
    private View gwR;
    private View jNV;
    public OnClickListener pLd;
    a rPU;
    String username;
    private j.a vkA;
    private String vkp;
    private HashMap<String, Preference> vkq = new HashMap();
    private boolean vkr = false;
    private boolean vks;
    public j vkt;
    b vku;
    private OnClickListener vkv;
    private OnClickListener vkw;
    private OnClickListener vkx;
    private b vky;
    private k.a vkz;

    public i(Context context) {
        boolean z = false;
        AppMethodBeat.i(79735);
        if (this.vkr) {
            z = true;
        }
        this.vks = z;
        this.vku = null;
        this.pLd = null;
        this.rPU = null;
        this.vkx = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(79731);
                ab.d("MicroMsg.ContactListArchor", "OnClickListener = onClick ");
                AppMethodBeat.o(79731);
            }
        };
        this.vky = new b() {
            public final boolean iD(int i) {
                AppMethodBeat.i(79732);
                if (i.this.vkt.vkL && i.this.vkt.KW(i)) {
                    if (!i.this.vkt.KU(i)) {
                        ab.d("MicroMsg.ContactListArchor", "onItemLongClick ".concat(String.valueOf(i)));
                    }
                    AppMethodBeat.o(79732);
                } else {
                    AppMethodBeat.o(79732);
                }
                return true;
            }
        };
        this.vkz = new k.a() {
            public final void KT(int i) {
                int i2 = 1;
                AppMethodBeat.i(79733);
                if (!(i.this.rPU == null || i.this.vkt == null)) {
                    j jVar = i.this.vkt;
                    int i3 = jVar.vkL ? (jVar.ekq || i != jVar.vkJ + 2) ? 0 : 1 : (jVar.ekq || i != jVar.vkJ + 1) ? 0 : 1;
                    if (i3 == 0) {
                        jVar = i.this.vkt;
                        if (jVar.ekq || i != jVar.vkJ) {
                            i3 = 0;
                        } else {
                            i3 = 1;
                        }
                        if (i3 == 0) {
                            jVar = i.this.vkt;
                            if (jVar.ekq || i != jVar.vkJ + 1) {
                                i2 = 0;
                            }
                            if (i2 != 0) {
                                if (i.this.vkt.vkL) {
                                    if (t.kH(i.this.username)) {
                                        i.this.rPU.iA(i);
                                        AppMethodBeat.o(79733);
                                        return;
                                    }
                                    i.this.vkt.KU(0);
                                    AppMethodBeat.o(79733);
                                    return;
                                }
                            } else if (i.this.vkt.ekq && i.this.vkt.KW(i)) {
                                i.this.rPU.iA(i);
                                AppMethodBeat.o(79733);
                                return;
                            } else if (i.this.vkt.ekq && !i.this.vkt.KW(i)) {
                                i.this.rPU.JT();
                                AppMethodBeat.o(79733);
                                return;
                            } else if (!i.this.vkt.ekq && i.this.vkt.KW(i)) {
                                i.this.rPU.iB(i);
                            }
                        } else if (i.this.vkt.vkM) {
                            i.this.rPU.iC(i);
                            AppMethodBeat.o(79733);
                            return;
                        }
                    }
                }
                AppMethodBeat.o(79733);
            }
        };
        this.vkA = new j.a() {
            public final void dfM() {
                AppMethodBeat.i(79734);
                if (i.this.ehK != null) {
                    i.this.ehK.notifyDataSetChanged();
                }
                AppMethodBeat.o(79734);
            }
        };
        this.context = context;
        this.vkt = new j(this.context);
        this.vkt.vkD = this.vkA;
        AppMethodBeat.o(79735);
    }

    public final void u(String str, List<String> list) {
        List list2;
        AppMethodBeat.i(79736);
        this.username = str;
        if (list2 == null) {
            list2 = new ArrayList(0);
        }
        this.vkt.m9do(list2);
        Qb(str);
        AppMethodBeat.o(79736);
    }

    public final void ag(ArrayList<ad> arrayList) {
        ArrayList arrayList2;
        AppMethodBeat.i(79737);
        if (arrayList2 == null) {
            arrayList2 = new ArrayList(0);
        }
        this.vkt.ah(arrayList2);
        Qb(null);
        AppMethodBeat.o(79737);
    }

    private void Qb(String str) {
        AppMethodBeat.i(79738);
        this.vkt.setUsername(str);
        this.vkt.vkP = this.vks;
        this.vkt.Kh();
        aPw();
        AppMethodBeat.o(79738);
    }

    public final void a(f fVar, String str) {
        AppMethodBeat.i(79739);
        if (fVar == null || str == null) {
            AppMethodBeat.o(79739);
            return;
        }
        this.ehK = fVar;
        this.vkp = str;
        fVar.ce(str, true);
        AppMethodBeat.o(79739);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0024  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x017c  */
    /* JADX WARNING: Missing block: B:10:0x001e, code skipped:
            if (r2 != null) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void KR(int i) {
        Object obj;
        b bVar;
        OnClickListener onClickListener;
        boolean z;
        boolean djB;
        boolean z2;
        int i2;
        int i3;
        int i4;
        j jVar;
        Context context;
        int i5;
        ContactListExpandPreference contactListExpandPreference;
        k kVar;
        AppMethodBeat.i(79740);
        Object obj2 = null;
        if (this.gwR != null) {
            obj2 = 1;
        }
        if (this.jNV != null) {
            ContactListCustomPreference contactListCustomPreference;
            if (this.vkr) {
                j jVar2 = this.vkt;
                Object obj3;
                if (jVar2.vkI > jVar2.vkQ) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
            }
            obj = 1;
            if (obj2 != null) {
                contactListCustomPreference = new ContactListCustomPreference(this.context);
                contactListCustomPreference.setKey(KS(-1));
                contactListCustomPreference.setCustomView(this.gwR);
                contactListCustomPreference.background = R.drawable.k5;
                contactListCustomPreference.pLd = this.vkv;
                this.ehK.a(contactListCustomPreference, i);
                this.vkq.put(contactListCustomPreference.mKey, contactListCustomPreference);
                i++;
            }
            bVar = this.vku == null ? this.vku : this.vky;
            onClickListener = this.pLd == null ? this.pLd : this.vkx;
            z = this.vkt.eih == null && this.vkt.eih.JR();
            djB = this.vkt.djB();
            if (this.vkt.mgP) {
                z2 = z;
            } else {
                z2 = this.vkt.vkF;
            }
            i2 = this.vkt.vkJ;
            i3 = (djB || z2) ? 2 : 1;
            i4 = i2 + i3;
            i2 = 0;
            jVar = this.vkt;
            context = this.context;
            if (context != null) {
                i3 = 0;
            } else {
                float dimension;
                Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                int width = defaultDisplay.getWidth();
                i3 = defaultDisplay.getHeight();
                if (((float) width) / (context.getResources().getDimension(R.dimen.ly) + (context.getResources().getDimension(R.dimen.lo) * 2.0f)) < 5.0f || i3 <= width) {
                    jVar.vkW = false;
                } else {
                    jVar.vkW = true;
                }
                float dimension2 = 2.0f * context.getResources().getDimension(R.dimen.lo);
                if (jVar.vkW) {
                    dimension = context.getResources().getDimension(R.dimen.ly);
                } else {
                    dimension = context.getResources().getDimension(R.dimen.lw);
                }
                i3 = width / ((int) (dimension + dimension2));
                ab.i("MicroMsg.ContactsListArchAdapter", "[getWrapColNum] :%s", Integer.valueOf(i3));
                j.vkC = i3;
                if (i3 == 4) {
                    j.MAX_COUNT = 43;
                }
            }
            i5 = 0;
            while (i5 < this.vkt.getCount() && i5 < i4) {
                contactListExpandPreference = new ContactListExpandPreference(this.context, 1);
                contactListExpandPreference.setKey(KS(i2));
                kVar = contactListExpandPreference.vle;
                kVar.vkt = this.vkt;
                kVar.row = i2;
                kVar.index = i5;
                contactListExpandPreference.vle.vlf = i3;
                contactListExpandPreference.vle.eic = z2;
                contactListExpandPreference.vle.pLd = onClickListener;
                contactListExpandPreference.vle.vkz = this.vkz;
                contactListExpandPreference.vle.vlg = bVar;
                this.ehK.a(contactListExpandPreference, i + i2);
                this.vkq.put(contactListExpandPreference.mKey, contactListExpandPreference);
                i5 += i3;
                i2++;
            }
            if (obj != null) {
                contactListCustomPreference = new ContactListCustomPreference(this.context);
                contactListCustomPreference.setKey(KS(-2));
                contactListCustomPreference.setCustomView(this.jNV);
                contactListCustomPreference.pLd = this.vkw;
                this.ehK.a(contactListCustomPreference, i + i2);
                this.vkq.put(contactListCustomPreference.mKey, contactListCustomPreference);
            }
            AppMethodBeat.o(79740);
        }
        obj = null;
        if (obj2 != null) {
        }
        if (this.vku == null) {
        }
        if (this.pLd == null) {
        }
        if (this.vkt.eih == null) {
        }
        djB = this.vkt.djB();
        if (this.vkt.mgP) {
        }
        i2 = this.vkt.vkJ;
        if (djB) {
        }
        i4 = i2 + i3;
        i2 = 0;
        jVar = this.vkt;
        context = this.context;
        if (context != null) {
        }
        i5 = 0;
        while (i5 < this.vkt.getCount()) {
            contactListExpandPreference = new ContactListExpandPreference(this.context, 1);
            contactListExpandPreference.setKey(KS(i2));
            kVar = contactListExpandPreference.vle;
            kVar.vkt = this.vkt;
            kVar.row = i2;
            kVar.index = i5;
            contactListExpandPreference.vle.vlf = i3;
            contactListExpandPreference.vle.eic = z2;
            contactListExpandPreference.vle.pLd = onClickListener;
            contactListExpandPreference.vle.vkz = this.vkz;
            contactListExpandPreference.vle.vlg = bVar;
            this.ehK.a(contactListExpandPreference, i + i2);
            this.vkq.put(contactListExpandPreference.mKey, contactListExpandPreference);
            i5 += i3;
            i2++;
        }
        if (obj != null) {
        }
        AppMethodBeat.o(79740);
    }

    private void removeAll() {
        AppMethodBeat.i(79741);
        for (String aqP : this.vkq.keySet()) {
            this.ehK.aqP(aqP);
        }
        this.vkq.clear();
        AppMethodBeat.o(79741);
    }

    private static String KS(int i) {
        AppMethodBeat.i(79742);
        String concat;
        if (i >= 0) {
            concat = "pref_contact_list_row_".concat(String.valueOf(i));
            AppMethodBeat.o(79742);
            return concat;
        }
        Object obj = "unkown";
        if (i == -1) {
            obj = TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER;
        } else if (i == -2) {
            obj = "footer";
        }
        concat = "pref_contact_list_row_".concat(String.valueOf(obj));
        AppMethodBeat.o(79742);
        return concat;
    }

    public final void aPw() {
        AppMethodBeat.i(79743);
        if (this.ehK == null || this.vkp == null) {
            AppMethodBeat.o(79743);
            return;
        }
        removeAll();
        KR(this.ehK.indexOf(this.vkp));
        AppMethodBeat.o(79743);
    }

    public final void djz() {
        boolean z = false;
        this.vkr = false;
        if (this.vkr) {
            z = true;
        }
        this.vks = z;
    }
}
