package com.tencent.mm.plugin.wenote.ui.nativenote.b;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.wenote.model.a.c;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.plugin.wenote.model.nativenote.spans.u;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.ttpic.baseutils.IOUtils;

public final class l extends a {
    private WXRTEditText uUV;

    public l(View view, k kVar) {
        super(view, kVar);
        AppMethodBeat.i(27178);
        this.uUV = (WXRTEditText) view.findViewById(R.id.djo);
        if (!(kVar.uQI == 2 && this.uSJ.uQJ)) {
            this.uUV.setKeyListener(null);
            this.uUV.setFocusable(false);
            this.uUV.setClickable(true);
        }
        this.uUV.uPS = this;
        this.uUV.setEditTextType(0);
        this.uSJ.q(this.uUV);
        this.uUV.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public final void onGlobalLayout() {
                AppMethodBeat.i(27175);
                aw.RS().aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(27174);
                        l.this.uUV.hasFocus();
                        AppMethodBeat.o(27174);
                    }
                });
                AppMethodBeat.o(27175);
            }
        });
        AppMethodBeat.o(27178);
    }

    public final void a(c cVar, int i, int i2) {
        LayoutParams layoutParams;
        AppMethodBeat.i(27179);
        this.uUV.setPosInDataList(i);
        final i iVar = (i) cVar;
        iVar.uNY = this.uUV;
        iVar.uNW = null;
        iVar.uNX = null;
        c Ke = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().Ke(i - 1);
        if (Ke != null && Ke.getType() == 1) {
            layoutParams = (LayoutParams) this.uUV.getLayoutParams();
            layoutParams.topMargin = 0;
            this.uUV.setLayoutParams(layoutParams);
        }
        Ke = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.dem().Ke(i + 1);
        if (Ke != null && Ke.getType() == 1) {
            layoutParams = (LayoutParams) this.uUV.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.uUV.setLayoutParams(layoutParams);
        }
        if (this.uSJ.uQI == 2 && this.uSJ.uQJ) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(27177);
                    l.this.uUV.setRichTextEditing(iVar.content);
                    l.this.uUV.deL();
                    l.this.uUV.deN();
                    j.l(l.this.uUV);
                    l.this.uUV.deO();
                    l.this.uUV.deM();
                    if (iVar.uNT) {
                        if (iVar.uNV == -1 || iVar.uNV >= l.this.uUV.getText().toString().length()) {
                            l.this.uUV.setSelection(l.this.uUV.getText().toString().length());
                        } else {
                            l.this.uUV.setSelection(iVar.uNV);
                        }
                        l.this.uUV.requestFocus();
                        al.n(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(27176);
                                if (iVar.uOc != 0) {
                                    int i = l.this.uUV.getSelection().aqm;
                                    if (i == iVar.content.length()) {
                                        l.this.uUV.deL();
                                        l.this.uUV.getText().append(IOUtils.LINE_SEPARATOR_UNIX);
                                        l.this.uUV.deM();
                                        l.this.uUV.setSelection(i);
                                    }
                                    iVar.uOc = 0;
                                    if (iVar.uOd == 1) {
                                        l.this.uUV.a(u.uSB, Boolean.TRUE);
                                        AppMethodBeat.o(27176);
                                        return;
                                    } else if (iVar.uOd == 3) {
                                        l.this.uUV.a(u.uSA, Boolean.TRUE);
                                        AppMethodBeat.o(27176);
                                        return;
                                    } else if (iVar.uOd == 2) {
                                        l.this.uUV.a(u.uSC, Boolean.TRUE);
                                    }
                                }
                                AppMethodBeat.o(27176);
                            }
                        }, 500);
                    } else if (l.this.uUV.hasFocus()) {
                        l.this.uUV.clearFocus();
                    }
                    if (iVar.uOb) {
                        iVar.uOb = false;
                        l.this.uUV.uOb = true;
                        l.this.uUV.onTextContextMenuItem(16908322);
                    }
                    AppMethodBeat.o(27177);
                }
            });
        } else {
            this.uUV.setRichTextEditing(iVar.content);
            j.l(this.uUV);
        }
        ab.i("MicroMsg.Note.NoteTextItemHolder", "TextItemHolder position is " + ki());
        AppMethodBeat.o(27179);
    }

    public final int dfW() {
        return 1;
    }
}
