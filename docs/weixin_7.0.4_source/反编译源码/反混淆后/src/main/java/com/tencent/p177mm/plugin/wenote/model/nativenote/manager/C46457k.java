package com.tencent.p177mm.plugin.wenote.model.nativenote.manager;

import android.text.Spannable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C37721gh;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p1565b.C40378c;
import com.tencent.p177mm.plugin.wenote.model.nativenote.p1565b.C46455b;
import com.tencent.p177mm.plugin.wenote.model.nativenote.spans.C17003m;
import com.tencent.p177mm.plugin.wenote.model.nativenote.spans.C23185t;
import com.tencent.p177mm.plugin.wenote.model.nativenote.spans.C29990c;
import com.tencent.p177mm.plugin.wenote.model.nativenote.spans.C29991l;
import com.tencent.p177mm.plugin.wenote.model.nativenote.spans.C29993u;
import com.tencent.p177mm.plugin.wenote.model.nativenote.spans.C36861b;
import com.tencent.p177mm.plugin.wenote.model.nativenote.spans.C46458g;
import com.tencent.p177mm.plugin.wenote.model.nativenote.spans.C46459j;
import com.tencent.p177mm.plugin.wenote.model.p585a.C40365i;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44001c;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44003l;
import com.tencent.p177mm.plugin.wenote.p1333b.C29977c;
import com.tencent.p177mm.plugin.wenote.p587ui.nativenote.C29996a;
import com.tencent.p177mm.pluginsdk.C30036f;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C40619x;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.manager.k */
public final class C46457k implements C40378c {
    private static DisplayMetrics aDu;
    public static int mScreenHeight;
    public static int mScreenWidth;
    private static int uQA = -1;
    public static C46457k uQx = null;
    public static int uQy = -1;
    public int acV;
    public long cvv = -1;
    public int iJp;
    public long uQB = -1;
    public String uQC = "";
    public C46455b uQD = null;
    private boolean uQE = false;
    public int uQF = -1;
    public String uQG = null;
    public long uQH = -1;
    public int uQI = 0;
    public boolean uQJ = false;
    private OnKeyListener uQK = new C403841();
    public final C7564ap uQL = new C7564ap(new C357472(), true);
    private transient ArrayList<WXRTEditText> uQv = new ArrayList();
    public C29996a uQw;
    private int uQz;

    /* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.manager.k$2 */
    class C357472 implements C5015a {
        C357472() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(26832);
            if (-1 == C46457k.this.uQB) {
                AppMethodBeat.m2505o(26832);
                return false;
            }
            C46457k.this.deV();
            AppMethodBeat.m2505o(26832);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wenote.model.nativenote.manager.k$1 */
    class C403841 implements OnKeyListener {
        C403841() {
        }

        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            AppMethodBeat.m2504i(26831);
            if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 67) {
                AppMethodBeat.m2505o(26831);
                return false;
            } else if (C40380c.dem().size() == 0) {
                AppMethodBeat.m2505o(26831);
                return false;
            } else {
                WXRTEditText deS = C46457k.this.deS();
                if (deS == null) {
                    AppMethodBeat.m2505o(26831);
                    return false;
                }
                int recyclerItemPosition = deS.getRecyclerItemPosition();
                C4990ab.m7417i("MicroMsg.Note.WXRTManager", "current focus pos: %d", Integer.valueOf(recyclerItemPosition));
                C44001c Ke = C40380c.dem().mo63750Ke(recyclerItemPosition);
                if (Ke == null) {
                    C4990ab.m7421w("MicroMsg.Note.WXRTManager", "get current item is null %d", Integer.valueOf(recyclerItemPosition));
                    AppMethodBeat.m2505o(26831);
                    return false;
                }
                C44001c Ke2 = C40380c.dem().mo63750Ke(recyclerItemPosition - 1);
                if (Ke2 == null) {
                    C4990ab.m7417i("MicroMsg.Note.WXRTManager", "get preItem is null %d", Integer.valueOf(recyclerItemPosition));
                    AppMethodBeat.m2505o(26831);
                    return false;
                }
                C40365i c40365i;
                switch (deS.getEditTextType()) {
                    case 0:
                        C4990ab.m7416i("MicroMsg.Note.WXRTManager", "Handle Editor Type EDITTEXT");
                        int selectionStart = deS.getSelectionStart();
                        if (selectionStart == deS.getSelectionEnd()) {
                            if (selectionStart == deS.getParagraphsInSelection().aqm) {
                                deS.uQb = true;
                                C46457k.this.mo74681b(C29993u.uSB, Boolean.FALSE);
                                C46457k.this.mo74681b(C29993u.uSC, Boolean.FALSE);
                                C46457k.this.mo74681b(C29993u.uSA, Boolean.FALSE);
                                C46457k.this.uQD.mo74675ol(false);
                                C46457k.this.uQD.mo74676om(false);
                                C46457k.this.uQD.mo74677on(false);
                                deS.uQb = false;
                            }
                            if (selectionStart == 0 && recyclerItemPosition != 0) {
                                boolean au;
                                String a = deS.mo56472a(C44006i.uQr);
                                C40380c.dem().dep();
                                if (Ke2.getType() == 1) {
                                    au = C40380c.dem().mo63762au(recyclerItemPosition, true);
                                    c40365i = (C40365i) Ke2;
                                    int length = c40365i.uNY.getText().toString().length();
                                    c40365i.content += a;
                                    c40365i.uNV = length;
                                    c40365i.uNT = true;
                                    c40365i.uNZ = false;
                                } else {
                                    if (C5046bo.isNullOrNil(a)) {
                                        au = C40380c.dem().mo63762au(recyclerItemPosition, true);
                                    } else {
                                        au = false;
                                    }
                                    Ke2.uNX.setSelection(0);
                                    Ke2.uNT = true;
                                    Ke2.uNZ = false;
                                }
                                if (!au) {
                                    C46457k.this.uQw.dfP().mo27052gD(recyclerItemPosition - 1, 2);
                                    break;
                                }
                                C46457k.this.uQw.dfP().mo27023JX(recyclerItemPosition - 1);
                                break;
                            }
                            AppMethodBeat.m2505o(26831);
                            return false;
                        }
                        AppMethodBeat.m2505o(26831);
                        return false;
                        break;
                    case 1:
                        C4990ab.m7416i("MicroMsg.Note.WXRTManager", "Handle Editor Type PREBUTTON");
                        C40380c.dem().dep();
                        if (Ke2.getType() == 1) {
                            c40365i = (C40365i) Ke2;
                            if (C5046bo.isNullOrNil(c40365i.content)) {
                                Ke.uNW.setSelection(0);
                                Ke.uNT = true;
                                Ke.uNZ = true;
                                C40380c.dem().mo63762au(recyclerItemPosition - 1, true);
                                AppMethodBeat.m2505o(26831);
                                return true;
                            }
                            if (c40365i.content.endsWith("<br/>")) {
                                c40365i.content = c40365i.content.substring(0, c40365i.content.length() - 5);
                            }
                            c40365i.uNV = -1;
                            c40365i.uNT = true;
                            c40365i.uNZ = false;
                        } else {
                            Ke2.uNX.setSelection(0);
                            Ke2.uNT = true;
                            Ke2.uNZ = false;
                        }
                        C46457k.this.uQw.dfP().mo27052gD(recyclerItemPosition - 1, 2);
                        break;
                    case 2:
                        C4990ab.m7416i("MicroMsg.Note.WXRTManager", "Handle Editor Type NEXTBTTTON");
                        if (Ke.getType() == 4 && ((C44003l) Ke).uOh.booleanValue()) {
                            C4990ab.m7416i("MicroMsg.Note.WXRTManager", "Current Item is Voice and Recording");
                            AppMethodBeat.m2505o(26831);
                            return false;
                        } else if (Ke.uOa || Ke.getType() == -1) {
                            C40380c.dem().dep();
                            C40380c.dem().mo63762au(recyclerItemPosition, false);
                            C46457k.this.uQw.dfP().mo27025JZ(recyclerItemPosition);
                            Ke2 = new C40365i();
                            Ke2.uNT = true;
                            Ke2.uNZ = false;
                            Ke2.content = "";
                            Ke2.uNV = 0;
                            C40380c.dem().mo63756a(recyclerItemPosition, Ke2);
                            C40380c.dem().mo63777gG(recyclerItemPosition - 1, recyclerItemPosition + 1);
                            C46457k.this.uQw.dfN().mo61465bY(recyclerItemPosition);
                            break;
                        } else {
                            C40380c.dem().mo63763av(recyclerItemPosition, true);
                            AppMethodBeat.m2505o(26831);
                            return true;
                        }
                        break;
                }
                AppMethodBeat.m2505o(26831);
                return true;
            }
        }
    }

    public C46457k(C29996a c29996a) {
        AppMethodBeat.m2504i(26833);
        this.uQw = c29996a;
        uQx = this;
        this.acV = C30036f.m47542de(c29996a.dfO());
        this.iJp = C5222ae.m7947hA(c29996a.dfO());
        int[] db = C40619x.m70068db(c29996a.dfO());
        mScreenHeight = db[1];
        mScreenWidth = db[0];
        aDu = c29996a.dfO().getResources().getDisplayMetrics();
        this.uQz = ((mScreenHeight - this.acV) - this.iJp) - ((int) C46457k.m87622aU(8.0f));
        this.uQC = C40380c.dem().deu();
        C17003m.uSe = 0.0f;
        AppMethodBeat.m2505o(26833);
    }

    public final WXRTEditText deS() {
        AppMethodBeat.m2504i(26835);
        C40380c dem = C40380c.dem();
        ArrayList arrayList = this.uQv;
        if (arrayList != null) {
            arrayList.clear();
            synchronized (dem) {
                try {
                    if (dem.iPr == null) {
                    } else {
                        Iterator it = dem.iPr.iterator();
                        while (it.hasNext()) {
                            C44001c c44001c = (C44001c) it.next();
                            if (c44001c.uNY != null) {
                                arrayList.add(c44001c.uNY);
                            } else if (!(c44001c.uNW == null || c44001c.uNX == null)) {
                                arrayList.add(c44001c.uNW);
                                arrayList.add(c44001c.uNX);
                            }
                        }
                    }
                } catch (Throwable th) {
                    AppMethodBeat.m2505o(26835);
                }
            }
        }
        if (this.uQv == null) {
            AppMethodBeat.m2505o(26835);
            return null;
        }
        Iterator it2 = this.uQv.iterator();
        while (it2.hasNext()) {
            WXRTEditText wXRTEditText = (WXRTEditText) it2.next();
            if (wXRTEditText.hasFocus()) {
                AppMethodBeat.m2505o(26835);
                return wXRTEditText;
            }
        }
        AppMethodBeat.m2505o(26835);
        return null;
    }

    /* renamed from: g */
    public final void mo63742g(boolean z, long j) {
        AppMethodBeat.m2504i(26836);
        this.uQw.dfP().mo27050g(z, j);
        AppMethodBeat.m2505o(26836);
    }

    public final void deg() {
        AppMethodBeat.m2504i(26837);
        this.uQw.dfP().deg();
        deU();
        AppMethodBeat.m2505o(26837);
    }

    /* renamed from: Kb */
    public final void mo63735Kb(int i) {
        AppMethodBeat.m2504i(26838);
        this.uQw.dfP().mo27029af(i, 0);
        AppMethodBeat.m2505o(26838);
    }

    /* renamed from: a */
    public final void mo63738a(WXRTEditText wXRTEditText, boolean z, int i) {
        AppMethodBeat.m2504i(26839);
        synchronized (this) {
            if (z) {
                try {
                    deU();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(26839);
                    }
                }
            }
            this.uQw.dfP().mo27028a(wXRTEditText, z, i);
        }
        AppMethodBeat.m2505o(26839);
    }

    /* renamed from: a */
    public final void mo63736a(WXRTEditText wXRTEditText, int i, int i2) {
        AppMethodBeat.m2504i(26840);
        if (this.uQI == 2 && this.uQJ) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            this.uQw.dfP().mo27053gE(i, i2);
            if (wXRTEditText.getEditTextType() == 0) {
                Iterator it = C29993u.uSE.iterator();
                z = false;
                z2 = false;
                z3 = false;
                z4 = false;
                while (it.hasNext()) {
                    boolean z5;
                    C23185t c23185t = (C23185t) it.next();
                    if (c23185t.mo38813s(wXRTEditText)) {
                        if (c23185t instanceof C36861b) {
                            z4 = true;
                        } else if (c23185t instanceof C29990c) {
                            z3 = true;
                        } else if (c23185t instanceof C29991l) {
                            z2 = true;
                        } else if (c23185t instanceof C46459j) {
                            z5 = true;
                            z = z5;
                        }
                    }
                    z5 = z;
                    z = z5;
                }
            } else {
                z = false;
                z2 = false;
                z3 = false;
                z4 = false;
            }
            this.uQD.mo74674ok(z4);
            this.uQD.mo74675ol(z3);
            this.uQD.mo74676om(z2);
            this.uQD.mo74677on(z);
            AppMethodBeat.m2505o(26840);
            return;
        }
        AppMethodBeat.m2505o(26840);
    }

    /* renamed from: a */
    public final void mo63737a(WXRTEditText wXRTEditText, Spannable spannable, Spannable spannable2, int i) {
        AppMethodBeat.m2504i(26841);
        String a = wXRTEditText.mo56472a(C44006i.uQr);
        C44001c Ke;
        if (wXRTEditText.getEditTextType() == 0) {
            Ke = C40380c.dem().mo63750Ke(wXRTEditText.getRecyclerItemPosition());
            if (Ke != null && Ke.getType() == 1) {
                int ahm = spannable == null ? 0 : C29977c.ahm(spannable.toString());
                int ahm2 = spannable2 == null ? 0 : C29977c.ahm(spannable2.toString());
                if (C40380c.dem().mo63776gF(ahm2 - ahm, 0)) {
                    this.uQw.dfP().ddW();
                    this.uQw.dfP().mo27023JX(wXRTEditText.getRecyclerItemPosition());
                    AppMethodBeat.m2505o(26841);
                    return;
                }
                C40380c.dem().dep();
                ((C40365i) Ke).uNV = i;
                ((C40365i) Ke).content = a;
                ((C40365i) Ke).uNT = true;
                Ke.uNZ = false;
                C40380c dem = C40380c.dem();
                dem.uPd = (ahm2 - ahm) + dem.uPd;
            }
            AppMethodBeat.m2505o(26841);
            return;
        }
        wXRTEditText.setText("");
        if (C5046bo.isNullOrNil(a)) {
            AppMethodBeat.m2505o(26841);
            return;
        }
        Ke = new C40365i();
        Ke.content = a.equals("<br/>") ? "" : a;
        int a2 = C40380c.dem().mo63752a(Ke, wXRTEditText, true, false, false);
        C40380c.dem().mo63777gG(a2 - 1, a2 + 1);
        AppMethodBeat.m2505o(26841);
    }

    public static C46457k deT() {
        return uQx;
    }

    public final void dei() {
        AppMethodBeat.m2504i(26842);
        this.uQw.dfP().ddU();
        AppMethodBeat.m2505o(26842);
    }

    /* renamed from: b */
    public final void mo63739b(WXRTEditText wXRTEditText) {
        AppMethodBeat.m2504i(26843);
        this.uQw.dfP().mo27027a(wXRTEditText);
        AppMethodBeat.m2505o(26843);
    }

    /* renamed from: aU */
    public static float m87622aU(float f) {
        AppMethodBeat.m2504i(26844);
        float applyDimension = TypedValue.applyDimension(1, f, aDu);
        AppMethodBeat.m2505o(26844);
        return applyDimension;
    }

    /* renamed from: bL */
    private synchronized void m87624bL(String str, boolean z) {
        AppMethodBeat.m2504i(26845);
        C37721gh c37721gh = new C37721gh();
        c37721gh.cAH.type = 19;
        c37721gh.cAH.cvC = C40380c.dem().ahe(str);
        if (c37721gh.cAH.cvC == null) {
            C4990ab.m7412e("MicroMsg.Note.WXRTManager", "updateNoteInfoStorage error, favProtoItem is null");
            AppMethodBeat.m2505o(26845);
        } else {
            c37721gh.cAH.title = str;
            c37721gh.cAH.cvv = this.cvv;
            c37721gh.cAH.cAO = z ? 1 : 0;
            c37721gh.cAH.desc = "fav_update_note_storage";
            C4879a.xxA.mo10055m(c37721gh);
            if (z) {
                this.uQF = c37721gh.cAH.cAK.getIntExtra("fav_note_item_status", -1);
                this.uQG = c37721gh.cAH.cAK.getStringExtra("fav_note_xml");
                this.uQH = c37721gh.cAH.cAK.getLongExtra("fav_note_item_updatetime", -1);
            }
            AppMethodBeat.m2505o(26845);
        }
    }

    private void deU() {
        AppMethodBeat.m2504i(26846);
        if (this.uQB < 0 && this.cvv > 0) {
            this.uQL.mo16770ae(60000, 60000);
            this.uQB = C5046bo.m7588yz();
            this.uQC = C40380c.dem().deu();
        }
        AppMethodBeat.m2505o(26846);
    }

    public final void deV() {
        AppMethodBeat.m2504i(26847);
        if (this.cvv > 0 && this.uQB > 0) {
            String deu = C40380c.dem().deu();
            if (!deu.equals(this.uQC)) {
                this.uQC = deu;
                if (this.uQE) {
                    m87624bL(this.uQC, false);
                } else {
                    this.uQE = true;
                    m87624bL(this.uQC, true);
                    AppMethodBeat.m2505o(26847);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(26847);
    }

    public final WXRTEditText deW() {
        AppMethodBeat.m2504i(26848);
        WXRTEditText deS = deS();
        if (deS != null || this.uQv.size() <= 0) {
            AppMethodBeat.m2505o(26848);
            return deS;
        }
        deS = (WXRTEditText) this.uQv.get(this.uQv.size() - 1);
        AppMethodBeat.m2505o(26848);
        return deS;
    }

    /* renamed from: b */
    public final <V, C extends C46458g<V>> void mo74681b(C23185t<V, C> c23185t, V v) {
        AppMethodBeat.m2504i(26849);
        WXRTEditText deS = deS();
        if (deS != null) {
            if (deS.getEditTextType() == 0) {
                int i = deS.getSelection().aqm;
                int length = deS.getText().length();
                if ((v instanceof Boolean) && ((Boolean) v).booleanValue() && i == length) {
                    deS.deL();
                    deS.getText().append(IOUtils.LINE_SEPARATOR_UNIX);
                    deS.deM();
                    deS.setSelection(i);
                }
                deS.mo56473a((C23185t) c23185t, (Object) v);
                AppMethodBeat.m2505o(26849);
                return;
            }
            deS.uQc = true;
            deS.uOd = c23185t.dfy();
            deS.getText().append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        AppMethodBeat.m2505o(26849);
    }

    /* renamed from: q */
    public final void mo74685q(WXRTEditText wXRTEditText) {
        AppMethodBeat.m2504i(26834);
        if (wXRTEditText.uPQ == 0) {
            wXRTEditText.setTextSize(0, (float) C1338a.m2856al(wXRTEditText.getContext(), C25738R.dimen.f9980m5));
        }
        C35746b.setTextSize(wXRTEditText.getTextSize());
        wXRTEditText.uPG = this;
        wXRTEditText.setRichTextEditing(null);
        wXRTEditText.setOnKeyListener(this.uQK);
        AppMethodBeat.m2505o(26834);
    }

    public static void deX() {
        AppMethodBeat.m2504i(26850);
        if (uQx != null) {
            uQx.uQw.dfP().mo27055oj(true);
        }
        AppMethodBeat.m2505o(26850);
    }
}
