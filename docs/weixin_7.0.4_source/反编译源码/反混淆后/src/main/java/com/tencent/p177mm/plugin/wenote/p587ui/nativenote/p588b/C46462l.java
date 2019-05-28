package com.tencent.p177mm.plugin.wenote.p587ui.nativenote.p588b;

import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C40380c;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.C46457k;
import com.tencent.p177mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.p177mm.plugin.wenote.model.nativenote.spans.C29993u;
import com.tencent.p177mm.plugin.wenote.model.p585a.C40365i;
import com.tencent.p177mm.plugin.wenote.model.p585a.C44001c;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.b.l */
public final class C46462l extends C4689a {
    private WXRTEditText uUV;

    /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.b.l$1 */
    class C299991 implements OnGlobalLayoutListener {

        /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.b.l$1$1 */
        class C300001 implements Runnable {
            C300001() {
            }

            public final void run() {
                AppMethodBeat.m2504i(27174);
                C46462l.this.uUV.hasFocus();
                AppMethodBeat.m2505o(27174);
            }
        }

        C299991() {
        }

        public final void onGlobalLayout() {
            AppMethodBeat.m2504i(27175);
            C9638aw.m17180RS().mo10302aa(new C300001());
            AppMethodBeat.m2505o(27175);
        }
    }

    public C46462l(View view, C46457k c46457k) {
        super(view, c46457k);
        AppMethodBeat.m2504i(27178);
        this.uUV = (WXRTEditText) view.findViewById(2131826414);
        if (!(c46457k.uQI == 2 && this.uSJ.uQJ)) {
            this.uUV.setKeyListener(null);
            this.uUV.setFocusable(false);
            this.uUV.setClickable(true);
        }
        this.uUV.uPS = this;
        this.uUV.setEditTextType(0);
        this.uSJ.mo74685q(this.uUV);
        this.uUV.getViewTreeObserver().addOnGlobalLayoutListener(new C299991());
        AppMethodBeat.m2505o(27178);
    }

    /* renamed from: a */
    public final void mo9809a(C44001c c44001c, int i, int i2) {
        LayoutParams layoutParams;
        AppMethodBeat.m2504i(27179);
        this.uUV.setPosInDataList(i);
        final C40365i c40365i = (C40365i) c44001c;
        c40365i.uNY = this.uUV;
        c40365i.uNW = null;
        c40365i.uNX = null;
        C44001c Ke = C40380c.dem().mo63750Ke(i - 1);
        if (Ke != null && Ke.getType() == 1) {
            layoutParams = (LayoutParams) this.uUV.getLayoutParams();
            layoutParams.topMargin = 0;
            this.uUV.setLayoutParams(layoutParams);
        }
        Ke = C40380c.dem().mo63750Ke(i + 1);
        if (Ke != null && Ke.getType() == 1) {
            layoutParams = (LayoutParams) this.uUV.getLayoutParams();
            layoutParams.bottomMargin = 0;
            this.uUV.setLayoutParams(layoutParams);
        }
        if (this.uSJ.uQI == 2 && this.uSJ.uQJ) {
            C5004al.m7441d(new Runnable() {

                /* renamed from: com.tencent.mm.plugin.wenote.ui.nativenote.b.l$2$1 */
                class C231901 implements Runnable {
                    C231901() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(27176);
                        if (c40365i.uOc != 0) {
                            int i = C46462l.this.uUV.getSelection().aqm;
                            if (i == c40365i.content.length()) {
                                C46462l.this.uUV.deL();
                                C46462l.this.uUV.getText().append(IOUtils.LINE_SEPARATOR_UNIX);
                                C46462l.this.uUV.deM();
                                C46462l.this.uUV.setSelection(i);
                            }
                            c40365i.uOc = 0;
                            if (c40365i.uOd == 1) {
                                C46462l.this.uUV.mo56473a(C29993u.uSB, Boolean.TRUE);
                                AppMethodBeat.m2505o(27176);
                                return;
                            } else if (c40365i.uOd == 3) {
                                C46462l.this.uUV.mo56473a(C29993u.uSA, Boolean.TRUE);
                                AppMethodBeat.m2505o(27176);
                                return;
                            } else if (c40365i.uOd == 2) {
                                C46462l.this.uUV.mo56473a(C29993u.uSC, Boolean.TRUE);
                            }
                        }
                        AppMethodBeat.m2505o(27176);
                    }
                }

                public final void run() {
                    AppMethodBeat.m2504i(27177);
                    C46462l.this.uUV.setRichTextEditing(c40365i.content);
                    C46462l.this.uUV.deL();
                    C46462l.this.uUV.deN();
                    C44089j.m79308l(C46462l.this.uUV);
                    C46462l.this.uUV.deO();
                    C46462l.this.uUV.deM();
                    if (c40365i.uNT) {
                        if (c40365i.uNV == -1 || c40365i.uNV >= C46462l.this.uUV.getText().toString().length()) {
                            C46462l.this.uUV.setSelection(C46462l.this.uUV.getText().toString().length());
                        } else {
                            C46462l.this.uUV.setSelection(c40365i.uNV);
                        }
                        C46462l.this.uUV.requestFocus();
                        C5004al.m7442n(new C231901(), 500);
                    } else if (C46462l.this.uUV.hasFocus()) {
                        C46462l.this.uUV.clearFocus();
                    }
                    if (c40365i.uOb) {
                        c40365i.uOb = false;
                        C46462l.this.uUV.uOb = true;
                        C46462l.this.uUV.onTextContextMenuItem(16908322);
                    }
                    AppMethodBeat.m2505o(27177);
                }
            });
        } else {
            this.uUV.setRichTextEditing(c40365i.content);
            C44089j.m79308l(this.uUV);
        }
        C4990ab.m7416i("MicroMsg.Note.NoteTextItemHolder", "TextItemHolder position is " + mo66453ki());
        AppMethodBeat.m2505o(27179);
    }

    public final int dfW() {
        return 1;
    }
}
