package com.tencent.p177mm.pluginsdk.p597ui.applet;

import android.content.Context;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p612ui.base.preference.C15541f;
import com.tencent.p177mm.p612ui.base.preference.Preference;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C14926j.C14928a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C30106k.C14929b;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C30106k.C30105a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.ContactListExpandPreference.C30100a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.smtt.sdk.TbsVideoCacheTask;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.tencent.mm.pluginsdk.ui.applet.i */
public final class C30103i {
    private Context context;
    C15541f ehK;
    private View gwR;
    private View jNV;
    public OnClickListener pLd;
    C30100a rPU;
    String username;
    private C14928a vkA;
    private String vkp;
    private HashMap<String, Preference> vkq = new HashMap();
    private boolean vkr = false;
    private boolean vks;
    public C14926j vkt;
    C14929b vku;
    private OnClickListener vkv;
    private OnClickListener vkw;
    private OnClickListener vkx;
    private C14929b vky;
    private C30105a vkz;

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.i$1 */
    class C47411 implements OnClickListener {
        C47411() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(79731);
            C4990ab.m7410d("MicroMsg.ContactListArchor", "OnClickListener = onClick ");
            AppMethodBeat.m2505o(79731);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.i$3 */
    class C149253 implements C30105a {
        C149253() {
        }

        /* renamed from: KT */
        public final void mo27250KT(int i) {
            int i2 = 1;
            AppMethodBeat.m2504i(79733);
            if (!(C30103i.this.rPU == null || C30103i.this.vkt == null)) {
                C14926j c14926j = C30103i.this.vkt;
                int i3 = c14926j.vkL ? (c14926j.ekq || i != c14926j.vkJ + 2) ? 0 : 1 : (c14926j.ekq || i != c14926j.vkJ + 1) ? 0 : 1;
                if (i3 == 0) {
                    c14926j = C30103i.this.vkt;
                    if (c14926j.ekq || i != c14926j.vkJ) {
                        i3 = 0;
                    } else {
                        i3 = 1;
                    }
                    if (i3 == 0) {
                        c14926j = C30103i.this.vkt;
                        if (c14926j.ekq || i != c14926j.vkJ + 1) {
                            i2 = 0;
                        }
                        if (i2 != 0) {
                            if (C30103i.this.vkt.vkL) {
                                if (C1855t.m3896kH(C30103i.this.username)) {
                                    C30103i.this.rPU.mo14654iA(i);
                                    AppMethodBeat.m2505o(79733);
                                    return;
                                }
                                C30103i.this.vkt.mo27251KU(0);
                                AppMethodBeat.m2505o(79733);
                                return;
                            }
                        } else if (C30103i.this.vkt.ekq && C30103i.this.vkt.mo27252KW(i)) {
                            C30103i.this.rPU.mo14654iA(i);
                            AppMethodBeat.m2505o(79733);
                            return;
                        } else if (C30103i.this.vkt.ekq && !C30103i.this.vkt.mo27252KW(i)) {
                            C30103i.this.rPU.mo14653JT();
                            AppMethodBeat.m2505o(79733);
                            return;
                        } else if (!C30103i.this.vkt.ekq && C30103i.this.vkt.mo27252KW(i)) {
                            C30103i.this.rPU.mo14655iB(i);
                        }
                    } else if (C30103i.this.vkt.vkM) {
                        C30103i.this.rPU.mo14656iC(i);
                        AppMethodBeat.m2505o(79733);
                        return;
                    }
                }
            }
            AppMethodBeat.m2505o(79733);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.i$2 */
    class C170102 implements C14929b {
        C170102() {
        }

        /* renamed from: iD */
        public final boolean mo4758iD(int i) {
            AppMethodBeat.m2504i(79732);
            if (C30103i.this.vkt.vkL && C30103i.this.vkt.mo27252KW(i)) {
                if (!C30103i.this.vkt.mo27251KU(i)) {
                    C4990ab.m7410d("MicroMsg.ContactListArchor", "onItemLongClick ".concat(String.valueOf(i)));
                }
                AppMethodBeat.m2505o(79732);
            } else {
                AppMethodBeat.m2505o(79732);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.applet.i$4 */
    class C301044 implements C14928a {
        C301044() {
        }

        public final void dfM() {
            AppMethodBeat.m2504i(79734);
            if (C30103i.this.ehK != null) {
                C30103i.this.ehK.notifyDataSetChanged();
            }
            AppMethodBeat.m2505o(79734);
        }
    }

    public C30103i(Context context) {
        boolean z = false;
        AppMethodBeat.m2504i(79735);
        if (this.vkr) {
            z = true;
        }
        this.vks = z;
        this.vku = null;
        this.pLd = null;
        this.rPU = null;
        this.vkx = new C47411();
        this.vky = new C170102();
        this.vkz = new C149253();
        this.vkA = new C301044();
        this.context = context;
        this.vkt = new C14926j(this.context);
        this.vkt.vkD = this.vkA;
        AppMethodBeat.m2505o(79735);
    }

    /* renamed from: u */
    public final void mo48377u(String str, List<String> list) {
        List list2;
        AppMethodBeat.m2504i(79736);
        this.username = str;
        if (list2 == null) {
            list2 = new ArrayList(0);
        }
        this.vkt.mo27258do(list2);
        m47681Qb(str);
        AppMethodBeat.m2505o(79736);
    }

    /* renamed from: ag */
    public final void mo48375ag(ArrayList<C7616ad> arrayList) {
        ArrayList arrayList2;
        AppMethodBeat.m2504i(79737);
        if (arrayList2 == null) {
            arrayList2 = new ArrayList(0);
        }
        this.vkt.mo27254ah(arrayList2);
        m47681Qb(null);
        AppMethodBeat.m2505o(79737);
    }

    /* renamed from: Qb */
    private void m47681Qb(String str) {
        AppMethodBeat.m2504i(79738);
        this.vkt.setUsername(str);
        this.vkt.vkP = this.vks;
        this.vkt.mo27253Kh();
        aPw();
        AppMethodBeat.m2505o(79738);
    }

    /* renamed from: a */
    public final void mo48373a(C15541f c15541f, String str) {
        AppMethodBeat.m2504i(79739);
        if (c15541f == null || str == null) {
            AppMethodBeat.m2505o(79739);
            return;
        }
        this.ehK = c15541f;
        this.vkp = str;
        c15541f.mo27715ce(str, true);
        AppMethodBeat.m2505o(79739);
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
    /* renamed from: KR */
    private void m47679KR(int i) {
        Object obj;
        C14929b c14929b;
        OnClickListener onClickListener;
        boolean z;
        boolean djB;
        boolean z2;
        int i2;
        int i3;
        int i4;
        C14926j c14926j;
        Context context;
        int i5;
        ContactListExpandPreference contactListExpandPreference;
        C30106k c30106k;
        AppMethodBeat.m2504i(79740);
        Object obj2 = null;
        if (this.gwR != null) {
            obj2 = 1;
        }
        if (this.jNV != null) {
            ContactListCustomPreference contactListCustomPreference;
            if (this.vkr) {
                C14926j c14926j2 = this.vkt;
                Object obj3;
                if (c14926j2.vkI > c14926j2.vkQ) {
                    obj3 = 1;
                } else {
                    obj3 = null;
                }
            }
            obj = 1;
            if (obj2 != null) {
                contactListCustomPreference = new ContactListCustomPreference(this.context);
                contactListCustomPreference.setKey(C30103i.m47680KS(-1));
                contactListCustomPreference.setCustomView(this.gwR);
                contactListCustomPreference.background = C25738R.drawable.f6623k5;
                contactListCustomPreference.pLd = this.vkv;
                this.ehK.mo27708a(contactListCustomPreference, i);
                this.vkq.put(contactListCustomPreference.mKey, contactListCustomPreference);
                i++;
            }
            c14929b = this.vku == null ? this.vku : this.vky;
            onClickListener = this.pLd == null ? this.pLd : this.vkx;
            z = this.vkt.eih == null && this.vkt.eih.mo16786JR();
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
            c14926j = this.vkt;
            context = this.context;
            if (context != null) {
                i3 = 0;
            } else {
                float dimension;
                Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
                int width = defaultDisplay.getWidth();
                i3 = defaultDisplay.getHeight();
                if (((float) width) / (context.getResources().getDimension(C25738R.dimen.f9974ly) + (context.getResources().getDimension(C25738R.dimen.f9966lo) * 2.0f)) < 5.0f || i3 <= width) {
                    c14926j.vkW = false;
                } else {
                    c14926j.vkW = true;
                }
                float dimension2 = 2.0f * context.getResources().getDimension(C25738R.dimen.f9966lo);
                if (c14926j.vkW) {
                    dimension = context.getResources().getDimension(C25738R.dimen.f9974ly);
                } else {
                    dimension = context.getResources().getDimension(C25738R.dimen.f9972lw);
                }
                i3 = width / ((int) (dimension + dimension2));
                C4990ab.m7417i("MicroMsg.ContactsListArchAdapter", "[getWrapColNum] :%s", Integer.valueOf(i3));
                C14926j.vkC = i3;
                if (i3 == 4) {
                    C14926j.MAX_COUNT = 43;
                }
            }
            i5 = 0;
            while (i5 < this.vkt.getCount() && i5 < i4) {
                contactListExpandPreference = new ContactListExpandPreference(this.context, 1);
                contactListExpandPreference.setKey(C30103i.m47680KS(i2));
                c30106k = contactListExpandPreference.vle;
                c30106k.vkt = this.vkt;
                c30106k.row = i2;
                c30106k.index = i5;
                contactListExpandPreference.vle.vlf = i3;
                contactListExpandPreference.vle.eic = z2;
                contactListExpandPreference.vle.pLd = onClickListener;
                contactListExpandPreference.vle.vkz = this.vkz;
                contactListExpandPreference.vle.vlg = c14929b;
                this.ehK.mo27708a(contactListExpandPreference, i + i2);
                this.vkq.put(contactListExpandPreference.mKey, contactListExpandPreference);
                i5 += i3;
                i2++;
            }
            if (obj != null) {
                contactListCustomPreference = new ContactListCustomPreference(this.context);
                contactListCustomPreference.setKey(C30103i.m47680KS(-2));
                contactListCustomPreference.setCustomView(this.jNV);
                contactListCustomPreference.pLd = this.vkw;
                this.ehK.mo27708a(contactListCustomPreference, i + i2);
                this.vkq.put(contactListCustomPreference.mKey, contactListCustomPreference);
            }
            AppMethodBeat.m2505o(79740);
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
        c14926j = this.vkt;
        context = this.context;
        if (context != null) {
        }
        i5 = 0;
        while (i5 < this.vkt.getCount()) {
            contactListExpandPreference = new ContactListExpandPreference(this.context, 1);
            contactListExpandPreference.setKey(C30103i.m47680KS(i2));
            c30106k = contactListExpandPreference.vle;
            c30106k.vkt = this.vkt;
            c30106k.row = i2;
            c30106k.index = i5;
            contactListExpandPreference.vle.vlf = i3;
            contactListExpandPreference.vle.eic = z2;
            contactListExpandPreference.vle.pLd = onClickListener;
            contactListExpandPreference.vle.vkz = this.vkz;
            contactListExpandPreference.vle.vlg = c14929b;
            this.ehK.mo27708a(contactListExpandPreference, i + i2);
            this.vkq.put(contactListExpandPreference.mKey, contactListExpandPreference);
            i5 += i3;
            i2++;
        }
        if (obj != null) {
        }
        AppMethodBeat.m2505o(79740);
    }

    private void removeAll() {
        AppMethodBeat.m2504i(79741);
        for (String aqP : this.vkq.keySet()) {
            this.ehK.aqP(aqP);
        }
        this.vkq.clear();
        AppMethodBeat.m2505o(79741);
    }

    /* renamed from: KS */
    private static String m47680KS(int i) {
        AppMethodBeat.m2504i(79742);
        String concat;
        if (i >= 0) {
            concat = "pref_contact_list_row_".concat(String.valueOf(i));
            AppMethodBeat.m2505o(79742);
            return concat;
        }
        Object obj = "unkown";
        if (i == -1) {
            obj = TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_HEADER;
        } else if (i == -2) {
            obj = "footer";
        }
        concat = "pref_contact_list_row_".concat(String.valueOf(obj));
        AppMethodBeat.m2505o(79742);
        return concat;
    }

    public final void aPw() {
        AppMethodBeat.m2504i(79743);
        if (this.ehK == null || this.vkp == null) {
            AppMethodBeat.m2505o(79743);
            return;
        }
        removeAll();
        m47679KR(this.ehK.indexOf(this.vkp));
        AppMethodBeat.m2505o(79743);
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
