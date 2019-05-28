package com.tencent.p177mm.plugin.wenote.model.nativenote.p586c;

import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C17480i;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C29989f;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C40380c;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p1074a.C14724a;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p1074a.C44005b;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p1565b.C40377a;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p586c.C40379a.C29984a;
import com.tencent.p177mm.plugin.wenote.model.p585a.C40365i;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44001c;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44003l;
import com.tencent.p177mm.plugin.wenote.p1333b.C29977c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.util.ArrayList;
import java.util.Collections;

/* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.c.e */
public final class C4675e implements C29984a {
    public static boolean mHasInit = false;
    public static volatile C4675e uRg = null;
    public C7306ak mHandler = null;
    public int mScreenHeight = 0;
    public int mScreenWidth = 0;
    public C40377a uRA = null;
    public C4670d uRB = null;
    public C46456b uRC = null;
    public C7564ap uRD = null;
    public C7564ap uRE = null;
    public TextView uRF = null;
    public TextView uRG = null;
    public TextView uRH = null;
    public TextView uRI = null;
    public TextView uRJ = null;
    public TextView uRK = null;
    public TextView uRL = null;
    public TextView uRM = null;
    public boolean uRh = true;
    public int uRi = 0;
    public int uRj = 0;
    public int uRk = 14;
    public int uRl = 0;
    public int uRm = 0;
    public int uRn = 0;
    public int uRo = 0;
    public int uRp = 0;
    public int uRq = 0;
    public int uRr = 0;
    public int[] uRs = null;
    public int[] uRt = null;
    public int[] uRu = null;
    public int[] uRv = null;
    public PopupWindow uRw = null;
    public PopupWindow uRx = null;
    public PopupWindow uRy = null;
    public PopupWindow uRz = null;

    /* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.c.e$4 */
    public class C46714 implements OnClickListener {
        public final void onClick(View view) {
            AppMethodBeat.m2504i(26861);
            C4990ab.m7416i("NoteSelectManager", "copy");
            if (!C4675e.mHasInit) {
                C4990ab.m7412e("NoteSelectManager", "copy: not init");
                C4675e.this.dfh();
                AppMethodBeat.m2505o(26861);
            } else if (C4675e.m7036l(C4675e.this)) {
                if (C4675e.this.uRA != null) {
                    C4675e.this.uRA.ddY();
                }
                AppMethodBeat.m2505o(26861);
            } else {
                C4675e.this.dfh();
                int dfa = C4675e.this.dfa();
                ArrayList arrayList;
                if (dfa == 2) {
                    SpannableStringBuilder a = C4675e.m7015a(C4675e.this, false, null, "");
                    if (C5046bo.m7519ac(a)) {
                        C4990ab.m7412e("NoteSelectManager", "copy: selectedSpan is null or empty");
                        C4675e.m7031h(C4675e.this);
                        AppMethodBeat.m2505o(26861);
                        return;
                    }
                    C40365i c40365i = new C40365i();
                    c40365i.content = C44005b.m78993a(a);
                    c40365i.uNV = -1;
                    c40365i.uNT = false;
                    arrayList = new ArrayList();
                    arrayList.add(c40365i);
                    C29989f.m47465c(C4996ah.getContext(), arrayList);
                    AppMethodBeat.m2505o(26861);
                } else if (dfa == 3) {
                    arrayList = C4675e.m7022b(C4675e.this, false, null, "");
                    if (arrayList == null || arrayList.size() <= 0) {
                        C4990ab.m7412e("NoteSelectManager", "copy: dataList is null or empty");
                        C4675e.m7031h(C4675e.this);
                        AppMethodBeat.m2505o(26861);
                        return;
                    }
                    C29989f.m47465c(C4996ah.getContext(), arrayList);
                    AppMethodBeat.m2505o(26861);
                } else {
                    C4990ab.m7412e("NoteSelectManager", "copy: not in select");
                    C4675e.m7031h(C4675e.this);
                    AppMethodBeat.m2505o(26861);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.c.e$5 */
    public class C46725 implements OnClickListener {
        public final void onClick(View view) {
            AppMethodBeat.m2504i(26862);
            C4990ab.m7416i("NoteSelectManager", "paste");
            if (!C4675e.mHasInit || !C4675e.this.uRh) {
                C4990ab.m7412e("NoteSelectManager", "paste: not init or not editable");
                C4675e.this.dfh();
                AppMethodBeat.m2505o(26862);
            } else if (C4675e.m7036l(C4675e.this)) {
                if (C4675e.this.uRA != null) {
                    C4675e.this.uRA.ddY();
                }
                AppMethodBeat.m2505o(26862);
            } else {
                ArrayList arrayList;
                C4675e.this.dfh();
                String str = "";
                C4996ah.getContext();
                int deC = C29989f.deC();
                if (deC == 2) {
                    if (C4675e.this.uRA != null) {
                        C4996ah.getContext();
                        if (C29989f.deB()) {
                            C4675e.this.uRA.ddW();
                            AppMethodBeat.m2505o(26862);
                            return;
                        }
                    }
                    ClipboardManager clipboardManager = (ClipboardManager) C4996ah.getContext().getSystemService("clipboard");
                    if (clipboardManager == null) {
                        C4990ab.m7412e("NoteSelectManager", "paste: clipboard is null");
                        C4675e.m7031h(C4675e.this);
                        AppMethodBeat.m2505o(26862);
                        return;
                    }
                    try {
                        String a;
                        CharSequence text = clipboardManager.getText();
                        if (text instanceof Spanned) {
                            a = C44005b.m78993a((Spanned) text);
                        } else {
                            String charSequence = text.toString();
                            StringBuilder stringBuilder = new StringBuilder();
                            C44005b.m78997a(charSequence, stringBuilder, 0, charSequence.length());
                            a = stringBuilder.toString();
                        }
                        if (C5046bo.isNullOrNil(a)) {
                            a = "";
                        }
                        C29989f.clearData();
                        arrayList = null;
                        str = a;
                    } catch (Exception e) {
                        C4990ab.m7413e("NoteSelectManager", "get clipboard data error : ", e);
                        C4675e.m7031h(C4675e.this);
                        AppMethodBeat.m2505o(26862);
                        return;
                    }
                } else if (deC == 3) {
                    ArrayList deA = C29989f.deA();
                    if (deA.size() <= 0) {
                        C4990ab.m7412e("NoteSelectManager", "paste: tempDataList is null or empty");
                        C4675e.m7031h(C4675e.this);
                        AppMethodBeat.m2505o(26862);
                        return;
                    } else if (deA.size() == 1 && deA.get(0) != null && ((C44001c) deA.get(0)).getType() == 1) {
                        arrayList = null;
                        str = ((C40365i) deA.get(0)).content;
                    } else {
                        arrayList = deA;
                    }
                } else {
                    C4990ab.m7412e("NoteSelectManager", "paste: no data");
                    C4675e.m7031h(C4675e.this);
                    AppMethodBeat.m2505o(26862);
                    return;
                }
                if (C5046bo.isNullOrNil(str) && (arrayList == null || arrayList.size() == 0)) {
                    C4990ab.m7412e("NoteSelectManager", "paste: no useful data");
                    C4675e.m7031h(C4675e.this);
                    AppMethodBeat.m2505o(26862);
                } else if (C4675e.this.uRA == null || !C4675e.m7019a(C4675e.this, arrayList, str)) {
                    int dfa = C4675e.this.dfa();
                    if (dfa == 1 || dfa == 2) {
                        C4675e.m7015a(C4675e.this, true, arrayList, str);
                        AppMethodBeat.m2505o(26862);
                    } else if (dfa == 3) {
                        C4675e.m7022b(C4675e.this, true, arrayList, str);
                        AppMethodBeat.m2505o(26862);
                    } else {
                        C4990ab.m7412e("NoteSelectManager", "paste: invalid selection");
                        C4675e.m7031h(C4675e.this);
                        AppMethodBeat.m2505o(26862);
                    }
                } else {
                    C4675e.this.uRA.ddW();
                    AppMethodBeat.m2505o(26862);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.c.e$8 */
    class C46748 implements Runnable {
        C46748() {
        }

        public final void run() {
            AppMethodBeat.m2504i(26865);
            C4675e.this.mo9794oq(true);
            C4675e.this.mo9793op(true);
            AppMethodBeat.m2505o(26865);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.c.e$7 */
    class C46767 implements C5015a {
        C46767() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(26864);
            if (C4675e.this.dfa() == 1 && C4675e.m7024b(C4675e.this)) {
                C4675e.this.dfh();
            }
            AppMethodBeat.m2505o(26864);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.c.e$10 */
    public class C467710 implements OnClickListener {
        public final void onClick(View view) {
            AppMethodBeat.m2504i(26867);
            C4990ab.m7416i("NoteSelectManager", "bold");
            C4675e.this.dfh();
            AppMethodBeat.m2505o(26867);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.c.e$2 */
    public class C46792 implements OnClickListener {
        public final void onClick(View view) {
            AppMethodBeat.m2504i(26859);
            C4990ab.m7416i("NoteSelectManager", "delete");
            if (!C4675e.mHasInit || !C4675e.this.uRh) {
                C4990ab.m7412e("NoteSelectManager", "delete: not init or not editable");
                C4675e.this.dfh();
                AppMethodBeat.m2505o(26859);
            } else if (C4675e.m7036l(C4675e.this)) {
                if (C4675e.this.uRA != null) {
                    C4675e.this.uRA.ddY();
                }
                AppMethodBeat.m2505o(26859);
            } else if (C4675e.this.uRA != null) {
                C4675e.this.uRA.ddZ();
                AppMethodBeat.m2505o(26859);
            } else {
                C4675e.this.dfp();
                AppMethodBeat.m2505o(26859);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.c.e$3 */
    public class C46803 implements OnClickListener {
        public final void onClick(View view) {
            AppMethodBeat.m2504i(26860);
            C4990ab.m7416i("NoteSelectManager", "cut");
            if (!C4675e.mHasInit || !C4675e.this.uRh) {
                C4990ab.m7412e("NoteSelectManager", "cut: not init or not editable");
                C4675e.this.dfh();
                AppMethodBeat.m2505o(26860);
            } else if (C4675e.m7036l(C4675e.this)) {
                if (C4675e.this.uRA != null) {
                    C4675e.this.uRA.ddY();
                }
                AppMethodBeat.m2505o(26860);
            } else {
                C4675e.this.dfh();
                int dfa = C4675e.this.dfa();
                ArrayList arrayList;
                if (dfa == 2) {
                    SpannableStringBuilder a = C4675e.m7015a(C4675e.this, true, null, "");
                    if (C5046bo.m7519ac(a)) {
                        C4990ab.m7412e("NoteSelectManager", "cut: selectedSpan is null or empty");
                        C4675e.m7031h(C4675e.this);
                        AppMethodBeat.m2505o(26860);
                        return;
                    }
                    C40365i c40365i = new C40365i();
                    c40365i.content = C44005b.m78993a(a);
                    c40365i.uNV = -1;
                    c40365i.uNT = false;
                    arrayList = new ArrayList();
                    arrayList.add(c40365i);
                    C29989f.m47465c(C4996ah.getContext(), arrayList);
                    AppMethodBeat.m2505o(26860);
                } else if (dfa == 3) {
                    arrayList = C4675e.m7022b(C4675e.this, true, null, "");
                    if (arrayList == null || arrayList.size() <= 0) {
                        C4990ab.m7412e("NoteSelectManager", "cut: dataList is null or empty");
                        C4675e.m7031h(C4675e.this);
                        AppMethodBeat.m2505o(26860);
                        return;
                    }
                    C29989f.m47465c(C4996ah.getContext(), arrayList);
                    AppMethodBeat.m2505o(26860);
                } else {
                    C4990ab.m7412e("NoteSelectManager", "cut: not in select");
                    C4675e.m7031h(C4675e.this);
                    AppMethodBeat.m2505o(26860);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.c.e$9 */
    class C46819 implements C5015a {
        C46819() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            int i;
            AppMethodBeat.m2504i(26866);
            C4990ab.m7410d("NoteSelectManager", "onTimerExpired: ");
            RecyclerView a = C4675e.m7013a(C4675e.this);
            int i2 = (C4675e.this.uRC == null || C4675e.this.uRC.uQV >= ((float) C4675e.m7012a(C4675e.this, a))) ? 0 : 1;
            if (C4675e.this.uRC == null || C4675e.this.uRC.uQV <= ((float) C4675e.m7026d(C4675e.this))) {
                i = 0;
            } else {
                i = 1;
            }
            if (!C4675e.mHasInit || a == null || C4675e.this.uRC == null || C4675e.this.uRC.getType() != 1 || (i2 == 0 && i == 0)) {
                if (C4675e.this.uRD != null) {
                    C4675e.this.uRD.stopTimer();
                }
            } else if (i2 != 0 && a.canScrollVertically(-1)) {
                if (C4675e.this.uRC.klY == 3) {
                    C4675e.m7027e(C4675e.this);
                }
                C4675e.m7028f(C4675e.this);
                C4675e.this.dfj();
                C4675e.this.dfh();
                a.mo66329a(0, -300, null);
            } else if (i != 0 && a.canScrollVertically(1)) {
                C4675e.m7028f(C4675e.this);
                C4675e.this.dfj();
                C4675e.this.dfh();
                a.mo66329a(0, 300, null);
            }
            AppMethodBeat.m2505o(26866);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.c.e$12 */
    public class C468212 implements OnClickListener {
        public final void onClick(View view) {
            C44001c c44001c = null;
            AppMethodBeat.m2504i(26869);
            C4990ab.m7416i("NoteSelectManager", "select");
            C4675e.this.dfh();
            if (!C4675e.mHasInit) {
                C4990ab.m7412e("NoteSelectManager", "select: not init");
                AppMethodBeat.m2505o(26869);
            } else if (C4675e.this.dfa() != 1) {
                C4990ab.m7412e("NoteSelectManager", "select: not insert");
                C4675e.m7031h(C4675e.this);
                AppMethodBeat.m2505o(26869);
            } else if (C40380c.dem().mo63750Ke(C4675e.this.uRB.coc) == null) {
                C4990ab.m7412e("NoteSelectManager", "select: item is null");
                C4675e.m7031h(C4675e.this);
                AppMethodBeat.m2505o(26869);
            } else {
                RecyclerView a = C4675e.m7013a(C4675e.this);
                if (a == null) {
                    C4990ab.m7412e("NoteSelectManager", "select: recyclerView is null");
                    C4675e.m7031h(C4675e.this);
                    AppMethodBeat.m2505o(26869);
                    return;
                }
                C4669c er = C14729f.m22927er(C14729f.m22928f(a, C4675e.this.uRB.coc));
                if (er == null) {
                    C4990ab.m7412e("NoteSelectManager", "select: rteInfo is null");
                    C4675e.m7031h(C4675e.this);
                    AppMethodBeat.m2505o(26869);
                } else if (er.uRc != null) {
                    Editable text = er.uRc.getText();
                    if (text == null) {
                        C4990ab.m7412e("NoteSelectManager", "select: text is null");
                        C4675e.m7031h(C4675e.this);
                        AppMethodBeat.m2505o(26869);
                    } else if (text.length() > 0) {
                        er.uRc.mo56474ax(C4675e.this.uRB.startOffset, true);
                        AppMethodBeat.m2505o(26869);
                    } else {
                        C44001c Ke = C40380c.dem().mo63750Ke(C4675e.this.uRB.coc - 1);
                        if (Ke != null && Ke.getType() == -3) {
                            Ke = null;
                        }
                        C44001c Ke2 = C40380c.dem().mo63750Ke(C4675e.this.uRB.coc + 1);
                        if (Ke2 == null || Ke2.getType() != -2) {
                            c44001c = Ke2;
                        }
                        if (Ke != null) {
                            if (Ke.getType() == 1) {
                                Spanned ahb = C14724a.ahb(((C40365i) Ke).content);
                                if (ahb == null) {
                                    C4990ab.m7412e("NoteSelectManager", "select: spanned is null");
                                    C4675e.m7031h(C4675e.this);
                                    AppMethodBeat.m2505o(26869);
                                    return;
                                }
                                C4675e.this.mo9777H(C4675e.this.uRB.coc - 1, ahb.length(), C4675e.this.uRB.coc, 0);
                            } else {
                                C4675e.this.mo9777H(C4675e.this.uRB.coc - 1, 0, C4675e.this.uRB.coc, 0);
                            }
                        } else if (c44001c == null) {
                            C4990ab.m7412e("NoteSelectManager", "select: no neighbor");
                            C4675e.m7031h(C4675e.this);
                            AppMethodBeat.m2505o(26869);
                            return;
                        } else if (c44001c.getType() == 1) {
                            C4675e.this.mo9777H(C4675e.this.uRB.coc, 0, C4675e.this.uRB.coc + 1, 0);
                        } else {
                            C4675e.this.mo9777H(C4675e.this.uRB.coc, 0, C4675e.this.uRB.coc + 1, 1);
                        }
                        C4675e.m7027e(C4675e.this);
                        C4675e.this.mo9781ab(true, true);
                        AppMethodBeat.m2505o(26869);
                    }
                } else if (er.uRd == null || er.uRe == null) {
                    C4990ab.m7412e("NoteSelectManager", "select: rteInfo invalid");
                    C4675e.m7031h(C4675e.this);
                    AppMethodBeat.m2505o(26869);
                } else {
                    C4675e.m7027e(C4675e.this);
                    C4675e.this.mo9777H(C4675e.this.uRB.coc, 0, C4675e.this.uRB.coc, 1);
                    C4675e.this.mo9781ab(true, true);
                    AppMethodBeat.m2505o(26869);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.c.e$11 */
    public class C468311 implements OnClickListener {
        public final void onClick(View view) {
            AppMethodBeat.m2504i(26868);
            C4990ab.m7416i("NoteSelectManager", "unbold");
            C4675e.this.dfh();
            AppMethodBeat.m2505o(26868);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.c.e$13 */
    public class C468413 implements OnClickListener {
        public final void onClick(View view) {
            AppMethodBeat.m2504i(26870);
            C4990ab.m7416i("NoteSelectManager", "select all");
            C4675e.this.dfh();
            if (C4675e.mHasInit) {
                int dex = C40380c.dem().dex();
                int dey = C40380c.dem().dey();
                C44001c Ke = C40380c.dem().mo63750Ke(dex);
                C44001c Ke2 = C40380c.dem().mo63750Ke(dey);
                if (Ke == null || Ke2 == null) {
                    C4990ab.m7412e("NoteSelectManager", "select all: item is null");
                    C4675e.m7031h(C4675e.this);
                    AppMethodBeat.m2505o(26870);
                    return;
                }
                int length;
                if (Ke2.getType() == 1) {
                    Spanned ahb = C14724a.ahb(((C40365i) Ke2).content);
                    if (ahb == null) {
                        C4990ab.m7412e("NoteSelectManager", "select all: spanned is null");
                        C4675e.m7031h(C4675e.this);
                        AppMethodBeat.m2505o(26870);
                        return;
                    }
                    length = ahb.length();
                } else {
                    length = 1;
                }
                C4675e.m7027e(C4675e.this);
                C4675e.this.mo9777H(dex, 0, dey, length);
                C4675e.this.dfj();
                C4675e.this.dfh();
                C4675e.m7034j(C4675e.this);
                C4675e.this.mo9794oq(false);
                C4675e.this.mo9792oo(false);
                AppMethodBeat.m2505o(26870);
                return;
            }
            C4990ab.m7412e("NoteSelectManager", "select all: not init");
            AppMethodBeat.m2505o(26870);
        }
    }

    /* renamed from: a */
    static /* synthetic */ RecyclerView m7013a(C4675e c4675e) {
        AppMethodBeat.m2504i(26916);
        RecyclerView recyclerView = c4675e.getRecyclerView();
        AppMethodBeat.m2505o(26916);
        return recyclerView;
    }

    /* renamed from: b */
    static /* synthetic */ ArrayList m7022b(C4675e c4675e, boolean z, ArrayList arrayList, String str) {
        AppMethodBeat.m2504i(26926);
        ArrayList b = c4675e.m7023b(z, arrayList, str);
        AppMethodBeat.m2505o(26926);
        return b;
    }

    /* renamed from: b */
    static /* synthetic */ boolean m7024b(C4675e c4675e) {
        AppMethodBeat.m2504i(26917);
        boolean Ki = c4675e.m7011Ki(2);
        AppMethodBeat.m2505o(26917);
        return Ki;
    }

    /* renamed from: d */
    static /* synthetic */ int m7026d(C4675e c4675e) {
        AppMethodBeat.m2504i(26919);
        int dfn = c4675e.dfn();
        AppMethodBeat.m2505o(26919);
        return dfn;
    }

    /* renamed from: e */
    static /* synthetic */ void m7027e(C4675e c4675e) {
        AppMethodBeat.m2504i(26920);
        c4675e.dfe();
        AppMethodBeat.m2505o(26920);
    }

    /* renamed from: f */
    static /* synthetic */ void m7028f(C4675e c4675e) {
        AppMethodBeat.m2504i(26921);
        c4675e.m7039or(false);
        AppMethodBeat.m2505o(26921);
    }

    /* renamed from: h */
    static /* synthetic */ void m7031h(C4675e c4675e) {
        AppMethodBeat.m2504i(26922);
        c4675e.dfo();
        AppMethodBeat.m2505o(26922);
    }

    private C4675e() {
        mHasInit = false;
    }

    public static C4675e dfb() {
        AppMethodBeat.m2504i(26871);
        if (uRg == null) {
            synchronized (C40380c.class) {
                try {
                    if (uRg == null) {
                        uRg = new C4675e();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(26871);
                    }
                }
            }
        }
        C4675e c4675e = uRg;
        AppMethodBeat.m2505o(26871);
        return c4675e;
    }

    public static boolean isEnabled() {
        return mHasInit;
    }

    public final boolean isEditable() {
        return mHasInit && this.uRh;
    }

    private RecyclerView getRecyclerView() {
        AppMethodBeat.m2504i(26872);
        if (this.uRA != null) {
            RecyclerView def = this.uRA.def();
            AppMethodBeat.m2505o(26872);
            return def;
        }
        AppMethodBeat.m2505o(26872);
        return null;
    }

    private int dfc() {
        AppMethodBeat.m2504i(26873);
        if (this.uRA != null) {
            int dec = this.uRA.dec() + this.uRA.ded();
            AppMethodBeat.m2505o(26873);
            return dec;
        }
        AppMethodBeat.m2505o(26873);
        return 0;
    }

    public final int dfa() {
        AppMethodBeat.m2504i(26874);
        if (mHasInit) {
            if (this.uRB == null) {
                this.uRB = new C4670d();
            }
            int dfa = this.uRB.dfa();
            AppMethodBeat.m2505o(26874);
            return dfa;
        }
        AppMethodBeat.m2505o(26874);
        return 0;
    }

    public final C4670d dfd() {
        AppMethodBeat.m2504i(26875);
        C4670d c4670d;
        if (mHasInit) {
            if (this.uRB == null) {
                this.uRB = new C4670d();
            }
            c4670d = new C4670d(this.uRB.coc, this.uRB.startOffset, this.uRB.endPos, this.uRB.uRf);
            AppMethodBeat.m2505o(26875);
            return c4670d;
        }
        c4670d = new C4670d();
        AppMethodBeat.m2505o(26875);
        return c4670d;
    }

    /* renamed from: H */
    public final boolean mo9777H(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(26876);
        if (mHasInit) {
            boolean z;
            if (this.uRB == null) {
                this.uRB = new C4670d(i, i2, i3, i4);
                z = true;
            } else if (this.uRB.coc == i && this.uRB.startOffset == i2 && this.uRB.endPos == i3 && this.uRB.uRf == i4) {
                z = false;
            } else {
                this.uRB.set(i, i2, i3, i4);
                z = true;
            }
            if (z) {
                C4990ab.m7411d("NoteSelectManager", "setSelectInfo: %d:%d - %d:%d", Integer.valueOf(this.uRB.coc), Integer.valueOf(this.uRB.startOffset), Integer.valueOf(this.uRB.endPos), Integer.valueOf(this.uRB.uRf));
            }
            AppMethodBeat.m2505o(26876);
            return z;
        }
        AppMethodBeat.m2505o(26876);
        return false;
    }

    /* renamed from: Kh */
    public final int mo9778Kh(int i) {
        AppMethodBeat.m2504i(26877);
        if (!mHasInit || this.uRB == null) {
            AppMethodBeat.m2505o(26877);
            return 0;
        } else if (dfa() == 0 || i < this.uRB.coc || i > this.uRB.endPos) {
            AppMethodBeat.m2505o(26877);
            return 0;
        } else if (i == this.uRB.coc && i == this.uRB.endPos) {
            AppMethodBeat.m2505o(26877);
            return 1;
        } else if (i > this.uRB.coc && i < this.uRB.endPos) {
            AppMethodBeat.m2505o(26877);
            return 2;
        } else if (i == this.uRB.coc && i < this.uRB.endPos) {
            AppMethodBeat.m2505o(26877);
            return 4;
        } else if (i <= this.uRB.coc || i != this.uRB.endPos) {
            AppMethodBeat.m2505o(26877);
            return 0;
        } else {
            AppMethodBeat.m2505o(26877);
            return 3;
        }
    }

    /* renamed from: aq */
    private void m7020aq(int i, int i2, int i3) {
        if (mHasInit) {
            switch (i) {
                case 2:
                    if (this.uRt != null && this.uRt.length == 2) {
                        this.uRt[0] = i2;
                        this.uRt[1] = i3;
                        return;
                    }
                    return;
                case 3:
                    if (this.uRu != null && this.uRu.length == 2) {
                        this.uRu[0] = i2;
                        this.uRu[1] = i3;
                        return;
                    }
                    return;
                case 4:
                    if (this.uRv != null && this.uRv.length == 2) {
                        this.uRv[0] = i2;
                        this.uRv[1] = i3;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: z */
    private static boolean m7041z(int[] iArr) {
        return (!mHasInit || iArr == null || iArr.length != 2 || iArr[0] == -1 || iArr[1] == -1) ? false : true;
    }

    private void dfe() {
        AppMethodBeat.m2504i(26878);
        if (this.uRA != null) {
            this.uRA.deb();
        }
        AppMethodBeat.m2505o(26878);
    }

    public final void dff() {
        AppMethodBeat.m2504i(26879);
        if (mHasInit) {
            mo9777H(-1, -1, -1, -1);
            mo9790h(true, 0);
            dfj();
            dfh();
            AppMethodBeat.m2505o(26879);
            return;
        }
        AppMethodBeat.m2505o(26879);
    }

    /* renamed from: ab */
    public final void mo9781ab(boolean z, boolean z2) {
        AppMethodBeat.m2504i(26880);
        if (mHasInit) {
            dfj();
            dfh();
            mo9790h(true, 50);
            mo9794oq(z);
            mo9792oo(z2);
            AppMethodBeat.m2505o(26880);
            return;
        }
        AppMethodBeat.m2505o(26880);
    }

    /* renamed from: h */
    public final void mo9790h(final boolean z, long j) {
        AppMethodBeat.m2504i(26881);
        if (!mHasInit || this.mHandler == null) {
            AppMethodBeat.m2505o(26881);
            return;
        }
        this.mHandler.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(26858);
                RecyclerView a = C4675e.m7013a(C4675e.this);
                if (a == null) {
                    AppMethodBeat.m2505o(26858);
                    return;
                }
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < a.getChildCount()) {
                        View childAt = a.getChildAt(i2);
                        C4669c er = C14729f.m22927er(childAt);
                        if (er != null) {
                            if (er.uRc != null) {
                                if (z) {
                                    er.uRc.postInvalidate();
                                }
                            } else if (!(er.uRd == null || er.uRe == null)) {
                                C4675e.this.mo9780a((LinearLayout) childAt.findViewById(2131826408), (LinearLayout) childAt.findViewById(2131826377), (LinearLayout) childAt.findViewById(2131826409), er.uRd.getPosInDataList());
                            }
                        }
                        i = i2 + 1;
                    } else {
                        AppMethodBeat.m2505o(26858);
                        return;
                    }
                }
            }
        }, j);
        AppMethodBeat.m2505o(26881);
    }

    /* renamed from: a */
    public final void mo9780a(View view, View view2, View view3, int i) {
        AppMethodBeat.m2504i(26882);
        if (!mHasInit || view == null || view2 == null || view3 == null || this.uRB == null) {
            AppMethodBeat.m2505o(26882);
            return;
        }
        switch (mo9778Kh(i)) {
            case 0:
                view.setVisibility(8);
                view2.setVisibility(4);
                view3.setVisibility(4);
                AppMethodBeat.m2505o(26882);
                return;
            case 1:
                if (this.uRB.startOffset == this.uRB.uRf) {
                    view.setVisibility(8);
                } else {
                    view.setVisibility(0);
                }
                view2.setVisibility(4);
                view3.setVisibility(4);
                AppMethodBeat.m2505o(26882);
                return;
            case 2:
                view.setVisibility(0);
                view2.setVisibility(0);
                view3.setVisibility(0);
                AppMethodBeat.m2505o(26882);
                return;
            case 3:
                if (this.uRB.uRf != 0) {
                    view.setVisibility(0);
                    view2.setVisibility(0);
                    view3.setVisibility(4);
                    AppMethodBeat.m2505o(26882);
                    return;
                }
                break;
            case 4:
                if (this.uRB.startOffset == 0) {
                    view.setVisibility(0);
                    view2.setVisibility(4);
                    view3.setVisibility(0);
                    AppMethodBeat.m2505o(26882);
                    return;
                }
                view.setVisibility(8);
                view2.setVisibility(4);
                view3.setVisibility(4);
                AppMethodBeat.m2505o(26882);
                return;
        }
        view.setVisibility(8);
        view2.setVisibility(4);
        view3.setVisibility(4);
        AppMethodBeat.m2505o(26882);
    }

    public final boolean dfg() {
        AppMethodBeat.m2504i(26883);
        if (this.uRz == null || !this.uRz.isShowing()) {
            AppMethodBeat.m2505o(26883);
            return false;
        }
        AppMethodBeat.m2505o(26883);
        return true;
    }

    public final void dfh() {
        AppMethodBeat.m2504i(26884);
        if (this.uRz != null) {
            this.uRz.dismiss();
        }
        AppMethodBeat.m2505o(26884);
    }

    /* renamed from: oo */
    public final void mo9792oo(final boolean z) {
        AppMethodBeat.m2504i(26885);
        this.mHandler.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(26863);
                C4675e.this.mo9793op(z);
                AppMethodBeat.m2505o(26863);
            }
        }, 50);
        AppMethodBeat.m2505o(26885);
    }

    /* renamed from: op */
    public final void mo9793op(boolean z) {
        AppMethodBeat.m2504i(26886);
        if (!mHasInit || this.uRz == null) {
            AppMethodBeat.m2505o(26886);
            return;
        }
        RecyclerView recyclerView = getRecyclerView();
        int dfa = dfa();
        if (recyclerView == null || dfa == 0 || ((dfa == 1 && !z) || (this.uRC != null && this.uRC.getType() == 1))) {
            dfh();
            AppMethodBeat.m2505o(26886);
        } else if (dfq()) {
            int height;
            int i = -1;
            int i2 = -1000;
            int o = m7038o(recyclerView);
            int dfn = dfn();
            int i3 = 0;
            dfa = 0;
            if (!(this.uRz == null || this.uRz.getContentView() == null)) {
                this.uRz.getContentView().measure(0, 0);
                i3 = (this.uRl * 2) + this.uRz.getContentView().getMeasuredHeight();
                dfa = this.uRz.getContentView().getMeasuredWidth() + (this.uRl * 2);
            }
            int i4 = i3 == 0 ? this.uRn : i3;
            if (dfa == 0) {
                i3 = this.uRo;
            } else {
                i3 = dfa;
            }
            int i5;
            if (this.uRw != null && this.uRw.isShowing() && C4675e.m7041z(this.uRt)) {
                i5 = this.uRt[1] - i4;
                height = (this.uRt[1] + this.uRw.getHeight()) - this.uRp;
                if (i5 < o || i5 > dfn) {
                    if (height >= o && height <= dfn) {
                        dfa = this.uRt[0];
                    }
                    dfa = i2;
                    height = i;
                } else {
                    dfa = this.uRt[0];
                    height = i5;
                }
            } else {
                if (this.uRx != null && this.uRx.isShowing() && C4675e.m7041z(this.uRu)) {
                    dfa = this.uRu[1] - i4;
                    height = (this.uRu[1] + this.uRx.getHeight()) - this.uRp;
                    if (dfa >= o && dfa <= dfn) {
                        i2 = this.uRu[0];
                        i = dfa;
                    } else if (height >= o && height <= dfn) {
                        i2 = this.uRu[0];
                        i = height;
                    }
                }
                if (this.uRy != null && this.uRy.isShowing() && C4675e.m7041z(this.uRv)) {
                    height = this.uRv[1] - i4;
                    i5 = (this.uRv[1] + this.uRy.getHeight()) - this.uRp;
                    if (i == -1) {
                        if (height >= o && height <= dfn) {
                            dfa = this.uRv[0];
                        } else if (i5 >= o && i5 <= dfn) {
                            dfa = this.uRv[0];
                            height = i5;
                        }
                    } else if (i + i4 > this.uRv[1] && i5 >= o && i5 <= dfn) {
                        dfa = this.uRv[0];
                        height = i5;
                    }
                }
                dfa = i2;
                height = i;
            }
            if (height == -1) {
                C17480i layoutManager = recyclerView.getLayoutManager();
                if (layoutManager != null && (layoutManager instanceof LinearLayoutManager)) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                    i = linearLayoutManager.mo1780iQ();
                    dfa = linearLayoutManager.mo1782iS();
                    if (this.uRB.coc <= i && this.uRB.endPos >= dfa) {
                        height = 300;
                        dfa = -1000;
                    }
                }
                dfa = -1000;
            }
            if (height == -1) {
                dfh();
                AppMethodBeat.m2505o(26886);
                return;
            }
            i2 = this.mScreenWidth / 3;
            i = (this.mScreenWidth * 2) / 3;
            if (dfa == -1000 || (dfa >= i2 && dfa <= i)) {
                m7033i(recyclerView, (this.mScreenWidth - i3) / 2, height);
                AppMethodBeat.m2505o(26886);
            } else if (dfa < i2) {
                m7033i(recyclerView, this.uRm, height);
                AppMethodBeat.m2505o(26886);
            } else {
                m7033i(recyclerView, (this.mScreenWidth - i3) - this.uRm, height);
                AppMethodBeat.m2505o(26886);
            }
        } else {
            dfh();
            AppMethodBeat.m2505o(26886);
        }
    }

    public final boolean dfi() {
        AppMethodBeat.m2504i(26887);
        if (this.uRw == null || !this.uRw.isShowing()) {
            AppMethodBeat.m2505o(26887);
            return false;
        }
        AppMethodBeat.m2505o(26887);
        return true;
    }

    public final void dfj() {
        AppMethodBeat.m2504i(26888);
        if (mHasInit) {
            m7011Ki(2);
            m7011Ki(3);
            m7011Ki(4);
            AppMethodBeat.m2505o(26888);
            return;
        }
        AppMethodBeat.m2505o(26888);
    }

    /* renamed from: Ki */
    private boolean m7011Ki(int i) {
        boolean z = true;
        AppMethodBeat.m2504i(26889);
        if (this.uRC != null && this.uRC.klY == i && this.uRC.getType() == 1) {
            AppMethodBeat.m2505o(26889);
            return false;
        }
        if (i == 2 && this.uRw != null) {
            this.uRw.dismiss();
            m7020aq(2, -1, -1);
        } else if (i == 3 && this.uRx != null) {
            this.uRx.dismiss();
            m7020aq(3, -1, -1);
        } else if (i != 4 || this.uRy == null) {
            z = false;
        } else {
            this.uRy.dismiss();
            m7020aq(4, -1, -1);
        }
        AppMethodBeat.m2505o(26889);
        return z;
    }

    /* renamed from: oq */
    public final void mo9794oq(boolean z) {
        AppMethodBeat.m2504i(26890);
        if (mHasInit) {
            RecyclerView recyclerView = getRecyclerView();
            int dfa = dfa();
            if (recyclerView == null || dfa == 0 || (dfa == 1 && !z)) {
                dfj();
                AppMethodBeat.m2505o(26890);
                return;
            }
            View f = C14729f.m22928f(recyclerView, this.uRB.coc);
            View f2 = C14729f.m22928f(recyclerView, this.uRB.endPos);
            if (dfa == 1) {
                m7011Ki(3);
                m7011Ki(4);
                m7017a(2, recyclerView, f, this.uRB.startOffset);
                AppMethodBeat.m2505o(26890);
                return;
            }
            m7011Ki(2);
            m7017a(3, recyclerView, f, this.uRB.startOffset);
            m7017a(4, recyclerView, f2, this.uRB.uRf);
            AppMethodBeat.m2505o(26890);
            return;
        }
        AppMethodBeat.m2505o(26890);
    }

    /* renamed from: a */
    private void m7017a(int i, RecyclerView recyclerView, View view, int i2) {
        AppMethodBeat.m2504i(26891);
        if (!mHasInit || recyclerView == null) {
            AppMethodBeat.m2505o(26891);
            return;
        }
        C4669c er = C14729f.m22927er(view);
        if (er == null) {
            m7011Ki(i);
            AppMethodBeat.m2505o(26891);
            return;
        }
        WXRTEditText wXRTEditText;
        if (er.uRc != null) {
            wXRTEditText = er.uRc;
        } else {
            if (!(er.uRd == null || er.uRe == null)) {
                if (i2 == 0) {
                    i2 = 0;
                    wXRTEditText = er.uRd;
                } else if (i2 == 1) {
                    i2 = 0;
                    wXRTEditText = er.uRe;
                }
            }
            wXRTEditText = null;
        }
        if (wXRTEditText == null) {
            m7011Ki(i);
            AppMethodBeat.m2505o(26891);
            return;
        }
        Editable text = wXRTEditText.getText();
        if (text == null || i2 < 0 || i2 > text.length()) {
            m7011Ki(i);
            AppMethodBeat.m2505o(26891);
            return;
        }
        Layout layout = wXRTEditText.getLayout();
        if (layout == null) {
            m7011Ki(i);
            AppMethodBeat.m2505o(26891);
            return;
        }
        boolean a;
        float primaryHorizontal = layout.getPrimaryHorizontal(i2) + ((float) wXRTEditText.getPaddingLeft());
        float lineTop = (float) (layout.getLineTop(layout.getLineForOffset(i2)) + wXRTEditText.getPaddingTop());
        if (wXRTEditText.getEditTextType() != 0) {
            lineTop = (lineTop + ((float) wXRTEditText.getHeight())) - ((float) this.uRi);
            if (i == 3) {
                primaryHorizontal += (float) this.uRr;
            } else if (i == 4) {
                primaryHorizontal -= (float) this.uRr;
            }
        }
        int[] iArr = new int[2];
        wXRTEditText.getLocationOnScreen(iArr);
        switch (i) {
            case 2:
                a = m7018a(2, recyclerView, this.uRw, (int) ((primaryHorizontal + ((float) iArr[0])) - ((float) this.uRq)), (int) (((float) iArr[1]) + lineTop));
                break;
            case 3:
                a = m7018a(3, recyclerView, this.uRx, (int) ((primaryHorizontal + ((float) iArr[0])) - ((float) this.uRx.getWidth())), (int) (((float) iArr[1]) + lineTop));
                break;
            case 4:
                a = m7018a(4, recyclerView, this.uRy, (int) (primaryHorizontal + ((float) iArr[0])), (int) (((float) iArr[1]) + lineTop));
                break;
            default:
                a = false;
                break;
        }
        if (!a) {
            m7011Ki(i);
        }
        AppMethodBeat.m2505o(26891);
    }

    /* renamed from: a */
    private boolean m7018a(int i, RecyclerView recyclerView, PopupWindow popupWindow, int i2, int i3) {
        AppMethodBeat.m2504i(26892);
        if (!mHasInit || recyclerView == null || popupWindow == null) {
            AppMethodBeat.m2505o(26892);
            return false;
        } else if (i3 < m7038o(recyclerView) || i3 > this.mScreenHeight - dfc()) {
            AppMethodBeat.m2505o(26892);
            return false;
        } else {
            if (popupWindow.isShowing()) {
                popupWindow.update(i2, i3, -1, -1, false);
                m7020aq(i, i2, i3);
            } else {
                popupWindow.showAtLocation(recyclerView, 0, i2, i3);
                m7020aq(i, i2, i3);
            }
            if (i == 2) {
                dfk();
                this.uRE.mo16770ae(3000, 0);
            }
            AppMethodBeat.m2505o(26892);
            return true;
        }
    }

    private void dfk() {
        AppMethodBeat.m2504i(26893);
        if (this.uRE == null) {
            this.uRE = new C7564ap(new C46767(), false);
            AppMethodBeat.m2505o(26893);
            return;
        }
        this.uRE.stopTimer();
        AppMethodBeat.m2505o(26893);
    }

    /* renamed from: i */
    private boolean m7033i(RecyclerView recyclerView, int i, int i2) {
        AppMethodBeat.m2504i(26894);
        if (!mHasInit || recyclerView == null || this.uRz == null) {
            AppMethodBeat.m2505o(26894);
            return false;
        } else if (i2 < m7038o(recyclerView) || i2 > this.mScreenHeight - dfc()) {
            AppMethodBeat.m2505o(26894);
            return false;
        } else {
            if (this.uRz.isShowing()) {
                this.uRz.update(i, i2, -1, -1, false);
            } else {
                this.uRz.showAtLocation(recyclerView, 0, i, i2);
            }
            AppMethodBeat.m2505o(26894);
            return true;
        }
    }

    /* renamed from: a */
    public final void mo9779a(int i, MotionEvent motionEvent) {
        AppMethodBeat.m2504i(26895);
        if (!mHasInit || this.mHandler == null) {
            AppMethodBeat.m2505o(26895);
        } else if (this.uRC == null || this.uRC.getType() != 1 || this.uRC.klY == i) {
            switch (motionEvent.getAction()) {
                case 0:
                    dfl();
                    if (!dfg()) {
                        mo9793op(true);
                    }
                    this.uRC.mo74678a(i, motionEvent.getRawX(), motionEvent.getRawY(), motionEvent.getX(), motionEvent.getY(), 0);
                    AppMethodBeat.m2505o(26895);
                    return;
                case 1:
                case 3:
                    dfl();
                    this.mHandler.postDelayed(new C46748(), 200);
                    break;
                case 2:
                    if (this.uRC != null && this.uRC.getType() == 1) {
                        this.uRC.uQU = motionEvent.getRawX();
                        this.uRC.uQV = motionEvent.getRawY();
                        m7039or(true);
                        AppMethodBeat.m2505o(26895);
                        return;
                    }
            }
            AppMethodBeat.m2505o(26895);
        } else {
            AppMethodBeat.m2505o(26895);
        }
    }

    /* renamed from: or */
    private void m7039or(boolean z) {
        AppMethodBeat.m2504i(26896);
        if (!mHasInit || this.uRw == null || this.uRx == null || this.uRy == null || this.uRB == null) {
            AppMethodBeat.m2505o(26896);
            return;
        }
        RecyclerView recyclerView = getRecyclerView();
        if (recyclerView == null) {
            AppMethodBeat.m2505o(26896);
        } else if (this.uRC == null || this.uRC.getType() != 1) {
            AppMethodBeat.m2505o(26896);
        } else {
            int i = this.uRC.klY;
            if (i == 2 || i == 3 || i == 4) {
                int i2;
                float f = this.uRC.uQU - this.uRC.hke;
                float f2 = ((float) (this.uRi / 2)) + (this.uRC.uQV - this.uRC.hkf);
                if (i == 2) {
                    f += (float) (this.uRw.getWidth() / 2);
                } else if (i == 3) {
                    f += (float) this.uRx.getWidth();
                }
                recyclerView.getLocationOnScreen(this.uRs);
                View x = recyclerView.mo66441x(f - ((float) this.uRs[0]), f2 - ((float) this.uRs[1]));
                C4669c er = C14729f.m22927er(x);
                WXRTEditText wXRTEditText = null;
                if (er == null) {
                    i2 = 2;
                } else if (er.uRc != null) {
                    wXRTEditText = er.uRc;
                    int[] iArr = new int[2];
                    wXRTEditText.getLocationOnScreen(iArr);
                    i2 = m7021ar(i, wXRTEditText.getPosInDataList(), wXRTEditText.getOffsetForPosition(f - ((float) iArr[0]), f2 - ((float) iArr[1])));
                } else if (er.uRd == null || er.uRe == null) {
                    i2 = 0;
                } else {
                    WXRTEditText wXRTEditText2;
                    int ar;
                    if (i == 3) {
                        wXRTEditText2 = er.uRd;
                        ar = m7021ar(i, wXRTEditText2.getPosInDataList(), 0);
                        if (ar == 2 || ar == 3) {
                            m7018a(i, recyclerView, this.uRx, (int) (this.uRC.uQU - this.uRC.hke), (int) (this.uRC.uQV - this.uRC.hkf));
                            i2 = ar;
                            wXRTEditText = wXRTEditText2;
                        }
                    } else if (i == 4) {
                        wXRTEditText2 = er.uRe;
                        ar = m7021ar(i, wXRTEditText2.getPosInDataList(), 1);
                        if (ar == 2 || ar == 3) {
                            m7018a(i, recyclerView, this.uRy, (int) (this.uRC.uQU - this.uRC.hke), (int) (this.uRC.uQV - this.uRC.hkf));
                            i2 = ar;
                            wXRTEditText = wXRTEditText2;
                        }
                    } else {
                        int[] iArr2 = new int[2];
                        x.getLocationOnScreen(iArr2);
                        if (f <= ((float) (iArr2[0] + (x.getWidth() / 2)))) {
                            wXRTEditText2 = er.uRd;
                            ar = m7021ar(i, wXRTEditText2.getPosInDataList(), 0);
                        } else {
                            wXRTEditText2 = er.uRe;
                            ar = m7021ar(i, wXRTEditText2.getPosInDataList(), 1);
                        }
                        if (ar == 2 || ar == 3) {
                            m7018a(i, recyclerView, this.uRw, (int) (this.uRC.uQU - this.uRC.hke), (int) (this.uRC.uQV - this.uRC.hkf));
                        }
                    }
                    i2 = ar;
                    wXRTEditText = wXRTEditText2;
                }
                switch (i2) {
                    case 1:
                        i2 = 0;
                        break;
                    case 2:
                        i2 = 1;
                        break;
                    case 3:
                        Editable text = wXRTEditText.getText();
                        int dfa = dfa();
                        if (this.uRh && text != null && dfa == 1) {
                            if (!wXRTEditText.hasFocus()) {
                                wXRTEditText.requestFocus();
                            }
                            if (wXRTEditText.getEditTextType() == 1 || wXRTEditText.getEditTextType() == 2) {
                                wXRTEditText.setIgnoreSelectChangeByMultiSelect(true);
                                wXRTEditText.setSelection(0);
                                wXRTEditText.setIgnoreSelectChangeByMultiSelect(false);
                            } else if (this.uRB.startOffset <= text.length()) {
                                wXRTEditText.setIgnoreSelectChangeByMultiSelect(true);
                                wXRTEditText.setSelection(this.uRB.startOffset);
                                wXRTEditText.setIgnoreSelectChangeByMultiSelect(false);
                            }
                        } else if (this.uRh && text != null && dfa == 2 && wXRTEditText.hasFocus()) {
                            if (wXRTEditText.getEditTextType() == 1 || wXRTEditText.getEditTextType() == 2) {
                                wXRTEditText.setIgnoreSelectChangeByMultiSelect(true);
                                wXRTEditText.setSelection(0);
                                wXRTEditText.setIgnoreSelectChangeByMultiSelect(false);
                            } else if (this.uRB.startOffset <= text.length() && this.uRB.uRf <= text.length()) {
                                wXRTEditText.setIgnoreSelectChangeByMultiSelect(true);
                                wXRTEditText.setSelection(this.uRB.startOffset, this.uRB.uRf);
                                wXRTEditText.setIgnoreSelectChangeByMultiSelect(false);
                            }
                        }
                        if (dfa == 3 || dfa == 0) {
                            dfe();
                        }
                        dfh();
                        mo9790h(true, 0);
                        if (i == 4) {
                            i2 = this.uRB.uRf;
                        } else {
                            i2 = this.uRB.startOffset;
                        }
                        m7017a(i, recyclerView, x, i2);
                        i2 = 1;
                        break;
                    default:
                        AppMethodBeat.m2505o(26896);
                        return;
                }
                if (i2 == 0) {
                    dfm();
                } else if (z && ((this.uRC.uQV < ((float) m7038o(recyclerView)) || this.uRC.uQV > ((float) dfn())) && (this.uRD == null || this.uRD.doT()))) {
                    dfm();
                    this.uRD.mo16770ae(100, 100);
                    AppMethodBeat.m2505o(26896);
                    return;
                }
                AppMethodBeat.m2505o(26896);
                return;
            }
            AppMethodBeat.m2505o(26896);
        }
    }

    /* renamed from: ar */
    private int m7021ar(int i, int i2, int i3) {
        AppMethodBeat.m2504i(26897);
        if (mHasInit) {
            boolean H;
            switch (i) {
                case 2:
                    H = mo9777H(i2, i3, i2, i3);
                    break;
                case 3:
                    if (this.uRB != null && i2 <= this.uRB.endPos && (i2 != this.uRB.endPos || i3 < this.uRB.uRf)) {
                        H = mo9777H(i2, i3, this.uRB.endPos, this.uRB.uRf);
                        break;
                    }
                    AppMethodBeat.m2505o(26897);
                    return 1;
                    break;
                case 4:
                    if (this.uRB != null && i2 >= this.uRB.coc && (i2 != this.uRB.coc || i3 > this.uRB.startOffset)) {
                        H = mo9777H(this.uRB.coc, this.uRB.startOffset, i2, i3);
                        break;
                    }
                    AppMethodBeat.m2505o(26897);
                    return 1;
                default:
                    AppMethodBeat.m2505o(26897);
                    return 0;
            }
            if (H) {
                AppMethodBeat.m2505o(26897);
                return 3;
            }
            AppMethodBeat.m2505o(26897);
            return 2;
        }
        AppMethodBeat.m2505o(26897);
        return 0;
    }

    private void dfl() {
        AppMethodBeat.m2504i(26898);
        if (this.uRC == null) {
            this.uRC = new C46456b();
            AppMethodBeat.m2505o(26898);
            return;
        }
        this.uRC.reset();
        AppMethodBeat.m2505o(26898);
    }

    private void dfm() {
        AppMethodBeat.m2504i(26899);
        if (this.uRD == null) {
            this.uRD = new C7564ap(new C46819(), true);
            AppMethodBeat.m2505o(26899);
            return;
        }
        this.uRD.stopTimer();
        AppMethodBeat.m2505o(26899);
    }

    /* renamed from: o */
    private int m7038o(RecyclerView recyclerView) {
        AppMethodBeat.m2504i(26900);
        int i = 150;
        if (recyclerView != null) {
            recyclerView.getLocationOnScreen(this.uRs);
            if (C4675e.m7041z(this.uRs)) {
                i = this.uRs[1];
            }
        }
        AppMethodBeat.m2505o(26900);
        return i;
    }

    private int dfn() {
        AppMethodBeat.m2504i(26901);
        int i = 0;
        if (this.uRA != null) {
            i = this.uRA.dec();
        }
        if (i == 0 && this.uRA != null) {
            i = this.uRA.ded();
        }
        if (i == 0) {
            i = 150;
        }
        i = this.mScreenHeight - i;
        AppMethodBeat.m2505o(26901);
        return i;
    }

    /* renamed from: g */
    public static void m7030g(TextView textView, int i) {
        AppMethodBeat.m2504i(26902);
        if (textView != null) {
            textView.setTextSize(1, (float) i);
        }
        AppMethodBeat.m2505o(26902);
    }

    private void dfo() {
        AppMethodBeat.m2504i(26903);
        if (this.uRA != null) {
            this.uRA.dea();
        }
        AppMethodBeat.m2505o(26903);
    }

    public final void dfp() {
        AppMethodBeat.m2504i(26904);
        C4990ab.m7416i("NoteSelectManager", "deleteSelectedData");
        if (mHasInit) {
            dfh();
            int dfa = dfa();
            if (dfa == 2) {
                m7016a(true, null, "");
                AppMethodBeat.m2505o(26904);
                return;
            } else if (dfa == 3) {
                m7023b(true, null, "");
                AppMethodBeat.m2505o(26904);
                return;
            } else {
                C4990ab.m7412e("NoteSelectManager", "deleteSelectedData: not in select");
                dfo();
                AppMethodBeat.m2505o(26904);
                return;
            }
        }
        C4990ab.m7412e("NoteSelectManager", "deleteSelectedData: not init");
        AppMethodBeat.m2505o(26904);
    }

    /* renamed from: a */
    private SpannableStringBuilder m7016a(boolean z, ArrayList<C44001c> arrayList, String str) {
        int i = 2;
        AppMethodBeat.m2504i(26905);
        C4670d dfd = dfd();
        dff();
        int dfa = dfd.dfa();
        if (dfa == 1 || dfa == 2) {
            C44001c Ke = C40380c.dem().mo63750Ke(dfd.coc);
            if (Ke == null) {
                C4990ab.m7412e("NoteSelectManager", "getAndProcessSelectedDataInSingleSelect: item is null");
                AppMethodBeat.m2505o(26905);
                return null;
            }
            SpannableStringBuilder spannableStringBuilder;
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            if (Ke.getType() != 1) {
                if (dfa == 1 && z) {
                    ArrayList arrayList2;
                    if (dfd.startOffset == 0) {
                        i = 1;
                    }
                    if (arrayList != null && arrayList.size() > 0) {
                        ArrayList<C44001c> arrayList22 = arrayList;
                    } else if (C5046bo.isNullOrNil(str)) {
                        AppMethodBeat.m2505o(26905);
                        return spannableStringBuilder2;
                    } else {
                        arrayList22 = new ArrayList();
                        C40365i c40365i = new C40365i();
                        c40365i.content = str;
                        c40365i.uNT = false;
                        c40365i.uNV = -1;
                        arrayList22.add(c40365i);
                    }
                    C40380c.dem().mo63753a(arrayList22, i, dfd.coc, dfd.startOffset, dfd.uRf);
                    C40380c.dem().mo63777gG(dfd.coc - 1, (arrayList22.size() + dfd.coc) + 1);
                }
                spannableStringBuilder = spannableStringBuilder2;
            } else if (!z || arrayList == null || arrayList.size() <= 0) {
                spannableStringBuilder = C4675e.m7014a((C40365i) Ke, dfd.startOffset, dfd.uRf, false, z, str, true);
                if (this.uRA != null) {
                    this.uRA.mo27023JX(dfd.coc);
                }
                if (z) {
                    C40380c.dem().dew();
                }
            } else {
                spannableStringBuilder = C4675e.m7014a((C40365i) Ke, dfd.startOffset, dfd.uRf, false, false, "", true);
                C40380c.dem().mo63753a((ArrayList) arrayList, 0, dfd.coc, dfd.startOffset, dfd.uRf);
                C40380c.dem().mo63777gG(dfd.coc, (dfd.coc + arrayList.size()) + 1);
            }
            AppMethodBeat.m2505o(26905);
            return spannableStringBuilder;
        }
        C4990ab.m7412e("NoteSelectManager", "getAndProcessSelectedDataInSingleSelect: incorrect select");
        AppMethodBeat.m2505o(26905);
        return null;
    }

    /* renamed from: b */
    private ArrayList<C44001c> m7023b(boolean z, ArrayList<C44001c> arrayList, String str) {
        AppMethodBeat.m2504i(26906);
        C4670d dfd = dfd();
        dff();
        ArrayList<C44001c> arrayList2 = new ArrayList();
        if (dfd.dfa() != 3) {
            C4990ab.m7412e("NoteSelectManager", "getAndProcessSelectedDataInMultiSelect: incorrect select");
            AppMethodBeat.m2505o(26906);
            return null;
        }
        int i;
        int i2 = dfd.coc;
        int i3 = dfd.endPos;
        while (true) {
            int i4 = i3;
            i = i2;
            if (i4 < dfd.coc) {
                break;
            }
            C44001c Ke = C40380c.dem().mo63750Ke(i4);
            if (Ke != null) {
                C40365i c40365i;
                SpannableStringBuilder a;
                C40365i c40365i2;
                if (i4 == dfd.endPos && Ke.getType() == 1) {
                    c40365i = (C40365i) Ke;
                    a = C4675e.m7014a(c40365i, 0, dfd.uRf, false, z, "", false);
                    if (!C5046bo.m7519ac(a)) {
                        c40365i2 = new C40365i();
                        c40365i2.content = C44005b.m78993a(a);
                        c40365i2.uNV = -1;
                        c40365i2.uNT = false;
                        arrayList2.add(c40365i2);
                    }
                    if (z && C5046bo.isNullOrNil(c40365i.content)) {
                        C40380c.dem().mo63762au(i4, true);
                    }
                } else if (i4 == dfd.coc && Ke.getType() == 1) {
                    c40365i = (C40365i) Ke;
                    a = C4675e.m7014a(c40365i, dfd.startOffset, 0, true, z, "", false);
                    if (!C5046bo.m7519ac(a)) {
                        c40365i2 = new C40365i();
                        c40365i2.content = C44005b.m78993a(a);
                        c40365i2.uNV = -1;
                        c40365i2.uNT = false;
                        arrayList2.add(c40365i2);
                    }
                    if (z && C5046bo.isNullOrNil(c40365i.content)) {
                        C40380c.dem().mo63762au(i4, true);
                    } else {
                        i++;
                    }
                } else {
                    arrayList2.add(C29977c.m47428c(Ke));
                    if (z) {
                        C40380c.dem().mo63762au(i4, true);
                    }
                }
            }
            i2 = i;
            i3 = i4 - 1;
        }
        if (z) {
            i2 = i - 1;
            i3 = i + 1;
            if (arrayList == null || arrayList.size() <= 0) {
                C44001c c40365i3 = new C40365i();
                if (str == null) {
                    str = "";
                }
                c40365i3.content = str;
                c40365i3.uNT = false;
                c40365i3.uNV = -1;
                C40380c.dem().mo63756a(i, c40365i3);
            } else {
                C40380c.dem().mo63765d(i, arrayList);
                i3 = arrayList.size() + i;
            }
            C40380c.dem().mo63777gG(i2, i3);
        }
        Collections.reverse(arrayList2);
        AppMethodBeat.m2505o(26906);
        return arrayList2;
    }

    /* renamed from: a */
    private static SpannableStringBuilder m7014a(C40365i c40365i, int i, int i2, boolean z, boolean z2, String str, boolean z3) {
        SpannableStringBuilder spannableStringBuilder = null;
        AppMethodBeat.m2504i(26907);
        if (c40365i == null) {
            C4990ab.m7412e("NoteSelectManager", "processTextDataItem: textDataItem is null");
            AppMethodBeat.m2505o(26907);
        } else {
            Spanned ahb = C14724a.ahb(c40365i.content);
            if (ahb == null) {
                C4990ab.m7412e("NoteSelectManager", "processTextDataItem: spannedText is null");
                AppMethodBeat.m2505o(26907);
            } else {
                int length;
                if (z) {
                    length = ahb.length();
                } else {
                    length = i2;
                }
                if (str == null) {
                    str = "";
                }
                if (i < 0 || i > ahb.length() || length < 0 || length > ahb.length() || i > length) {
                    C4990ab.m7412e("NoteSelectManager", "processTextDataItem: incorrect offset");
                    AppMethodBeat.m2505o(26907);
                } else {
                    SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) ahb.subSequence(0, i);
                    spannableStringBuilder = (SpannableStringBuilder) ahb.subSequence(i, length);
                    SpannableStringBuilder spannableStringBuilder3 = (SpannableStringBuilder) ahb.subSequence(length, ahb.length());
                    if (z2) {
                        length = spannableStringBuilder2.length();
                        if (!C5046bo.isNullOrNil(str)) {
                            Spanned ahb2 = C14724a.ahb(str);
                            if (ahb2 != null) {
                                length += ahb2.length();
                            }
                        }
                        c40365i.content = C44005b.m78993a(spannableStringBuilder2) + str + C44005b.m78993a(spannableStringBuilder3);
                    }
                    if (z3) {
                        c40365i.uNT = true;
                        c40365i.uNV = length;
                    } else {
                        c40365i.uNT = false;
                        c40365i.uNV = -1;
                    }
                    AppMethodBeat.m2505o(26907);
                }
            }
        }
        return spannableStringBuilder;
    }

    private boolean dfq() {
        AppMethodBeat.m2504i(26908);
        boolean t = C4675e.m7040t(this.uRF, false);
        boolean t2 = C4675e.m7040t(this.uRG, false);
        boolean t3 = C4675e.m7040t(this.uRH, dfr());
        boolean t4 = C4675e.m7040t(this.uRI, dfs());
        boolean t5 = C4675e.m7040t(this.uRJ, dft());
        boolean t6 = C4675e.m7040t(this.uRK, dfu());
        boolean t7 = C4675e.m7040t(this.uRL, dfv());
        boolean t8 = C4675e.m7040t(this.uRM, dfw());
        if (t || t2 || t3 || t4 || t5 || t6 || t7 || t8) {
            AppMethodBeat.m2505o(26908);
            return true;
        }
        AppMethodBeat.m2505o(26908);
        return false;
    }

    /* renamed from: t */
    private static boolean m7040t(View view, boolean z) {
        AppMethodBeat.m2504i(26909);
        if (view == null) {
            AppMethodBeat.m2505o(26909);
            return false;
        } else if (z) {
            view.setVisibility(0);
            AppMethodBeat.m2505o(26909);
            return true;
        } else {
            view.setVisibility(8);
            AppMethodBeat.m2505o(26909);
            return false;
        }
    }

    private boolean dfr() {
        AppMethodBeat.m2504i(26910);
        if (dfa() != 1) {
            AppMethodBeat.m2505o(26910);
            return false;
        }
        C44001c Ke = C40380c.dem().mo63750Ke(this.uRB.coc);
        if (Ke == null || (C40380c.dem().size() <= 1 && Ke.getType() == 1 && C5046bo.isNullOrNil(((C40365i) Ke).content))) {
            AppMethodBeat.m2505o(26910);
            return false;
        }
        AppMethodBeat.m2505o(26910);
        return true;
    }

    private boolean dfs() {
        AppMethodBeat.m2504i(26911);
        int dex = C40380c.dem().dex();
        int dey = C40380c.dem().dey();
        C44001c Ke = C40380c.dem().mo63750Ke(dex);
        C44001c Ke2 = C40380c.dem().mo63750Ke(dey);
        if (Ke == null || Ke2 == null) {
            AppMethodBeat.m2505o(26911);
            return false;
        }
        if (this.uRB != null && this.uRB.coc == dex && this.uRB.startOffset == 0 && this.uRB.endPos == dey) {
            if (Ke2.getType() == 1) {
                Spanned ahb = C14724a.ahb(((C40365i) Ke2).content);
                if (ahb == null) {
                    AppMethodBeat.m2505o(26911);
                    return false;
                } else if (this.uRB.uRf == ahb.length()) {
                    AppMethodBeat.m2505o(26911);
                    return false;
                }
            } else if (Ke2.getType() != 1 && this.uRB.uRf == 1) {
                AppMethodBeat.m2505o(26911);
                return false;
            }
        }
        AppMethodBeat.m2505o(26911);
        return true;
    }

    private boolean dft() {
        boolean z = true;
        AppMethodBeat.m2504i(26912);
        if (this.uRh) {
            int dfa = dfa();
            if (dfa == 0 || dfa == 1) {
                AppMethodBeat.m2505o(26912);
                return false;
            }
            if (this.uRA != null && this.uRA.dee()) {
                z = false;
            }
            AppMethodBeat.m2505o(26912);
            return z;
        }
        AppMethodBeat.m2505o(26912);
        return false;
    }

    private boolean dfu() {
        AppMethodBeat.m2504i(26913);
        int dfa = dfa();
        if (this.uRh && (dfa == 2 || dfa == 3)) {
            AppMethodBeat.m2505o(26913);
            return true;
        }
        AppMethodBeat.m2505o(26913);
        return false;
    }

    private boolean dfv() {
        AppMethodBeat.m2504i(26914);
        int dfa = dfa();
        if (dfa == 2 || dfa == 3) {
            AppMethodBeat.m2505o(26914);
            return true;
        }
        AppMethodBeat.m2505o(26914);
        return false;
    }

    private boolean dfw() {
        AppMethodBeat.m2504i(26915);
        if (!this.uRh || dfa() == 0) {
            AppMethodBeat.m2505o(26915);
            return false;
        }
        C4996ah.getContext();
        if (C29989f.deC() != 1) {
            AppMethodBeat.m2505o(26915);
            return true;
        }
        AppMethodBeat.m2505o(26915);
        return false;
    }

    /* renamed from: j */
    static /* synthetic */ void m7034j(C4675e c4675e) {
        AppMethodBeat.m2504i(26923);
        c4675e.mo9790h(true, 300);
        AppMethodBeat.m2505o(26923);
    }

    /* renamed from: l */
    static /* synthetic */ boolean m7036l(C4675e c4675e) {
        AppMethodBeat.m2504i(26924);
        if (c4675e.dfa() == 3) {
            int i = c4675e.uRB.coc;
            while (true) {
                int i2 = i;
                if (i2 > c4675e.uRB.endPos) {
                    break;
                }
                C44001c Ke = C40380c.dem().mo63750Ke(i2);
                if (Ke != null && Ke.getType() == 4 && ((C44003l) Ke).uOh.booleanValue()) {
                    AppMethodBeat.m2505o(26924);
                    return true;
                }
                i = i2 + 1;
            }
        }
        AppMethodBeat.m2505o(26924);
        return false;
    }
}
