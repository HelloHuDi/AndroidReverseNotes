package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.text.Spannable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.nativenote.b.b;
import com.tencent.mm.plugin.wenote.model.nativenote.b.c;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.g;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.j;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.m;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.t;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ae;
import com.tencent.ttpic.baseutils.IOUtils;
import java.util.ArrayList;
import java.util.Iterator;

public final class k implements c {
    private static DisplayMetrics aDu;
    public static int mScreenHeight;
    public static int mScreenWidth;
    private static int uQA = -1;
    public static k uQx = null;
    public static int uQy = -1;
    public int acV;
    public long cvv = -1;
    public int iJp;
    public long uQB = -1;
    public String uQC = "";
    public b uQD = null;
    private boolean uQE = false;
    public int uQF = -1;
    public String uQG = null;
    public long uQH = -1;
    public int uQI = 0;
    public boolean uQJ = false;
    private OnKeyListener uQK = new OnKeyListener() {
        public final boolean onKey(View view, int i, KeyEvent keyEvent) {
            AppMethodBeat.i(26831);
            if (keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 67) {
                AppMethodBeat.o(26831);
                return false;
            } else if (c.dem().size() == 0) {
                AppMethodBeat.o(26831);
                return false;
            } else {
                WXRTEditText deS = k.this.deS();
                if (deS == null) {
                    AppMethodBeat.o(26831);
                    return false;
                }
                int recyclerItemPosition = deS.getRecyclerItemPosition();
                ab.i("MicroMsg.Note.WXRTManager", "current focus pos: %d", Integer.valueOf(recyclerItemPosition));
                com.tencent.mm.plugin.wenote.model.a.c Ke = c.dem().Ke(recyclerItemPosition);
                if (Ke == null) {
                    ab.w("MicroMsg.Note.WXRTManager", "get current item is null %d", Integer.valueOf(recyclerItemPosition));
                    AppMethodBeat.o(26831);
                    return false;
                }
                com.tencent.mm.plugin.wenote.model.a.c Ke2 = c.dem().Ke(recyclerItemPosition - 1);
                if (Ke2 == null) {
                    ab.i("MicroMsg.Note.WXRTManager", "get preItem is null %d", Integer.valueOf(recyclerItemPosition));
                    AppMethodBeat.o(26831);
                    return false;
                }
                i iVar;
                switch (deS.getEditTextType()) {
                    case 0:
                        ab.i("MicroMsg.Note.WXRTManager", "Handle Editor Type EDITTEXT");
                        int selectionStart = deS.getSelectionStart();
                        if (selectionStart == deS.getSelectionEnd()) {
                            if (selectionStart == deS.getParagraphsInSelection().aqm) {
                                deS.uQb = true;
                                k.this.b(u.uSB, Boolean.FALSE);
                                k.this.b(u.uSC, Boolean.FALSE);
                                k.this.b(u.uSA, Boolean.FALSE);
                                k.this.uQD.ol(false);
                                k.this.uQD.om(false);
                                k.this.uQD.on(false);
                                deS.uQb = false;
                            }
                            if (selectionStart == 0 && recyclerItemPosition != 0) {
                                boolean au;
                                String a = deS.a(i.uQr);
                                c.dem().dep();
                                if (Ke2.getType() == 1) {
                                    au = c.dem().au(recyclerItemPosition, true);
                                    iVar = (i) Ke2;
                                    int length = iVar.uNY.getText().toString().length();
                                    iVar.content += a;
                                    iVar.uNV = length;
                                    iVar.uNT = true;
                                    iVar.uNZ = false;
                                } else {
                                    if (bo.isNullOrNil(a)) {
                                        au = c.dem().au(recyclerItemPosition, true);
                                    } else {
                                        au = false;
                                    }
                                    Ke2.uNX.setSelection(0);
                                    Ke2.uNT = true;
                                    Ke2.uNZ = false;
                                }
                                if (!au) {
                                    k.this.uQw.dfP().gD(recyclerItemPosition - 1, 2);
                                    break;
                                }
                                k.this.uQw.dfP().JX(recyclerItemPosition - 1);
                                break;
                            }
                            AppMethodBeat.o(26831);
                            return false;
                        }
                        AppMethodBeat.o(26831);
                        return false;
                        break;
                    case 1:
                        ab.i("MicroMsg.Note.WXRTManager", "Handle Editor Type PREBUTTON");
                        c.dem().dep();
                        if (Ke2.getType() == 1) {
                            iVar = (i) Ke2;
                            if (bo.isNullOrNil(iVar.content)) {
                                Ke.uNW.setSelection(0);
                                Ke.uNT = true;
                                Ke.uNZ = true;
                                c.dem().au(recyclerItemPosition - 1, true);
                                AppMethodBeat.o(26831);
                                return true;
                            }
                            if (iVar.content.endsWith("<br/>")) {
                                iVar.content = iVar.content.substring(0, iVar.content.length() - 5);
                            }
                            iVar.uNV = -1;
                            iVar.uNT = true;
                            iVar.uNZ = false;
                        } else {
                            Ke2.uNX.setSelection(0);
                            Ke2.uNT = true;
                            Ke2.uNZ = false;
                        }
                        k.this.uQw.dfP().gD(recyclerItemPosition - 1, 2);
                        break;
                    case 2:
                        ab.i("MicroMsg.Note.WXRTManager", "Handle Editor Type NEXTBTTTON");
                        if (Ke.getType() == 4 && ((l) Ke).uOh.booleanValue()) {
                            ab.i("MicroMsg.Note.WXRTManager", "Current Item is Voice and Recording");
                            AppMethodBeat.o(26831);
                            return false;
                        } else if (Ke.uOa || Ke.getType() == -1) {
                            c.dem().dep();
                            c.dem().au(recyclerItemPosition, false);
                            k.this.uQw.dfP().JZ(recyclerItemPosition);
                            Ke2 = new i();
                            Ke2.uNT = true;
                            Ke2.uNZ = false;
                            Ke2.content = "";
                            Ke2.uNV = 0;
                            c.dem().a(recyclerItemPosition, Ke2);
                            c.dem().gG(recyclerItemPosition - 1, recyclerItemPosition + 1);
                            k.this.uQw.dfN().bY(recyclerItemPosition);
                            break;
                        } else {
                            c.dem().av(recyclerItemPosition, true);
                            AppMethodBeat.o(26831);
                            return true;
                        }
                        break;
                }
                AppMethodBeat.o(26831);
                return true;
            }
        }
    };
    public final ap uQL = new ap(new a() {
        public final boolean BI() {
            AppMethodBeat.i(26832);
            if (-1 == k.this.uQB) {
                AppMethodBeat.o(26832);
                return false;
            }
            k.this.deV();
            AppMethodBeat.o(26832);
            return true;
        }
    }, true);
    private transient ArrayList<WXRTEditText> uQv = new ArrayList();
    public com.tencent.mm.plugin.wenote.ui.nativenote.a uQw;
    private int uQz;

    public k(com.tencent.mm.plugin.wenote.ui.nativenote.a aVar) {
        AppMethodBeat.i(26833);
        this.uQw = aVar;
        uQx = this;
        this.acV = f.de(aVar.dfO());
        this.iJp = ae.hA(aVar.dfO());
        int[] db = x.db(aVar.dfO());
        mScreenHeight = db[1];
        mScreenWidth = db[0];
        aDu = aVar.dfO().getResources().getDisplayMetrics();
        this.uQz = ((mScreenHeight - this.acV) - this.iJp) - ((int) aU(8.0f));
        this.uQC = c.dem().deu();
        m.uSe = 0.0f;
        AppMethodBeat.o(26833);
    }

    public final WXRTEditText deS() {
        AppMethodBeat.i(26835);
        c dem = c.dem();
        ArrayList arrayList = this.uQv;
        if (arrayList != null) {
            arrayList.clear();
            synchronized (dem) {
                try {
                    if (dem.iPr == null) {
                    } else {
                        Iterator it = dem.iPr.iterator();
                        while (it.hasNext()) {
                            com.tencent.mm.plugin.wenote.model.a.c cVar = (com.tencent.mm.plugin.wenote.model.a.c) it.next();
                            if (cVar.uNY != null) {
                                arrayList.add(cVar.uNY);
                            } else if (!(cVar.uNW == null || cVar.uNX == null)) {
                                arrayList.add(cVar.uNW);
                                arrayList.add(cVar.uNX);
                            }
                        }
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(26835);
                }
            }
        }
        if (this.uQv == null) {
            AppMethodBeat.o(26835);
            return null;
        }
        Iterator it2 = this.uQv.iterator();
        while (it2.hasNext()) {
            WXRTEditText wXRTEditText = (WXRTEditText) it2.next();
            if (wXRTEditText.hasFocus()) {
                AppMethodBeat.o(26835);
                return wXRTEditText;
            }
        }
        AppMethodBeat.o(26835);
        return null;
    }

    public final void g(boolean z, long j) {
        AppMethodBeat.i(26836);
        this.uQw.dfP().g(z, j);
        AppMethodBeat.o(26836);
    }

    public final void deg() {
        AppMethodBeat.i(26837);
        this.uQw.dfP().deg();
        deU();
        AppMethodBeat.o(26837);
    }

    public final void Kb(int i) {
        AppMethodBeat.i(26838);
        this.uQw.dfP().af(i, 0);
        AppMethodBeat.o(26838);
    }

    public final void a(WXRTEditText wXRTEditText, boolean z, int i) {
        AppMethodBeat.i(26839);
        synchronized (this) {
            if (z) {
                try {
                    deU();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(26839);
                    }
                }
            }
            this.uQw.dfP().a(wXRTEditText, z, i);
        }
        AppMethodBeat.o(26839);
    }

    public final void a(WXRTEditText wXRTEditText, int i, int i2) {
        AppMethodBeat.i(26840);
        if (this.uQI == 2 && this.uQJ) {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4;
            this.uQw.dfP().gE(i, i2);
            if (wXRTEditText.getEditTextType() == 0) {
                Iterator it = u.uSE.iterator();
                z = false;
                z2 = false;
                z3 = false;
                z4 = false;
                while (it.hasNext()) {
                    boolean z5;
                    t tVar = (t) it.next();
                    if (tVar.s(wXRTEditText)) {
                        if (tVar instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.b) {
                            z4 = true;
                        } else if (tVar instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.c) {
                            z3 = true;
                        } else if (tVar instanceof com.tencent.mm.plugin.wenote.model.nativenote.spans.l) {
                            z2 = true;
                        } else if (tVar instanceof j) {
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
            this.uQD.ok(z4);
            this.uQD.ol(z3);
            this.uQD.om(z2);
            this.uQD.on(z);
            AppMethodBeat.o(26840);
            return;
        }
        AppMethodBeat.o(26840);
    }

    public final void a(WXRTEditText wXRTEditText, Spannable spannable, Spannable spannable2, int i) {
        AppMethodBeat.i(26841);
        String a = wXRTEditText.a(i.uQr);
        com.tencent.mm.plugin.wenote.model.a.c Ke;
        if (wXRTEditText.getEditTextType() == 0) {
            Ke = c.dem().Ke(wXRTEditText.getRecyclerItemPosition());
            if (Ke != null && Ke.getType() == 1) {
                int ahm = spannable == null ? 0 : com.tencent.mm.plugin.wenote.b.c.ahm(spannable.toString());
                int ahm2 = spannable2 == null ? 0 : com.tencent.mm.plugin.wenote.b.c.ahm(spannable2.toString());
                if (c.dem().gF(ahm2 - ahm, 0)) {
                    this.uQw.dfP().ddW();
                    this.uQw.dfP().JX(wXRTEditText.getRecyclerItemPosition());
                    AppMethodBeat.o(26841);
                    return;
                }
                c.dem().dep();
                ((i) Ke).uNV = i;
                ((i) Ke).content = a;
                ((i) Ke).uNT = true;
                Ke.uNZ = false;
                c dem = c.dem();
                dem.uPd = (ahm2 - ahm) + dem.uPd;
            }
            AppMethodBeat.o(26841);
            return;
        }
        wXRTEditText.setText("");
        if (bo.isNullOrNil(a)) {
            AppMethodBeat.o(26841);
            return;
        }
        Ke = new i();
        Ke.content = a.equals("<br/>") ? "" : a;
        int a2 = c.dem().a(Ke, wXRTEditText, true, false, false);
        c.dem().gG(a2 - 1, a2 + 1);
        AppMethodBeat.o(26841);
    }

    public static k deT() {
        return uQx;
    }

    public final void dei() {
        AppMethodBeat.i(26842);
        this.uQw.dfP().ddU();
        AppMethodBeat.o(26842);
    }

    public final void b(WXRTEditText wXRTEditText) {
        AppMethodBeat.i(26843);
        this.uQw.dfP().a(wXRTEditText);
        AppMethodBeat.o(26843);
    }

    public static float aU(float f) {
        AppMethodBeat.i(26844);
        float applyDimension = TypedValue.applyDimension(1, f, aDu);
        AppMethodBeat.o(26844);
        return applyDimension;
    }

    private synchronized void bL(String str, boolean z) {
        AppMethodBeat.i(26845);
        gh ghVar = new gh();
        ghVar.cAH.type = 19;
        ghVar.cAH.cvC = c.dem().ahe(str);
        if (ghVar.cAH.cvC == null) {
            ab.e("MicroMsg.Note.WXRTManager", "updateNoteInfoStorage error, favProtoItem is null");
            AppMethodBeat.o(26845);
        } else {
            ghVar.cAH.title = str;
            ghVar.cAH.cvv = this.cvv;
            ghVar.cAH.cAO = z ? 1 : 0;
            ghVar.cAH.desc = "fav_update_note_storage";
            com.tencent.mm.sdk.b.a.xxA.m(ghVar);
            if (z) {
                this.uQF = ghVar.cAH.cAK.getIntExtra("fav_note_item_status", -1);
                this.uQG = ghVar.cAH.cAK.getStringExtra("fav_note_xml");
                this.uQH = ghVar.cAH.cAK.getLongExtra("fav_note_item_updatetime", -1);
            }
            AppMethodBeat.o(26845);
        }
    }

    private void deU() {
        AppMethodBeat.i(26846);
        if (this.uQB < 0 && this.cvv > 0) {
            this.uQL.ae(60000, 60000);
            this.uQB = bo.yz();
            this.uQC = c.dem().deu();
        }
        AppMethodBeat.o(26846);
    }

    public final void deV() {
        AppMethodBeat.i(26847);
        if (this.cvv > 0 && this.uQB > 0) {
            String deu = c.dem().deu();
            if (!deu.equals(this.uQC)) {
                this.uQC = deu;
                if (this.uQE) {
                    bL(this.uQC, false);
                } else {
                    this.uQE = true;
                    bL(this.uQC, true);
                    AppMethodBeat.o(26847);
                    return;
                }
            }
        }
        AppMethodBeat.o(26847);
    }

    public final WXRTEditText deW() {
        AppMethodBeat.i(26848);
        WXRTEditText deS = deS();
        if (deS != null || this.uQv.size() <= 0) {
            AppMethodBeat.o(26848);
            return deS;
        }
        deS = (WXRTEditText) this.uQv.get(this.uQv.size() - 1);
        AppMethodBeat.o(26848);
        return deS;
    }

    public final <V, C extends g<V>> void b(t<V, C> tVar, V v) {
        AppMethodBeat.i(26849);
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
                deS.a((t) tVar, (Object) v);
                AppMethodBeat.o(26849);
                return;
            }
            deS.uQc = true;
            deS.uOd = tVar.dfy();
            deS.getText().append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        AppMethodBeat.o(26849);
    }

    public final void q(WXRTEditText wXRTEditText) {
        AppMethodBeat.i(26834);
        if (wXRTEditText.uPQ == 0) {
            wXRTEditText.setTextSize(0, (float) com.tencent.mm.bz.a.al(wXRTEditText.getContext(), R.dimen.m5));
        }
        b.setTextSize(wXRTEditText.getTextSize());
        wXRTEditText.uPG = this;
        wXRTEditText.setRichTextEditing(null);
        wXRTEditText.setOnKeyListener(this.uQK);
        AppMethodBeat.o(26834);
    }

    public static void deX() {
        AppMethodBeat.i(26850);
        if (uQx != null) {
            uQx.uQw.dfP().oj(true);
        }
        AppMethodBeat.o(26850);
    }
}
