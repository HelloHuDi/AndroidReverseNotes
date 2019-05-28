package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class SnsSightUploadSayFooter extends BasePanelKeybordLayout {
    MMActivity crP;
    ChatFooterPanel eAk;
    private MMEditText jZg = null;
    private ImageButton jZh;
    private boolean oin = true;
    SightRangeWidget rwY;
    SightLocationWidget rwZ;

    static /* synthetic */ void a(SnsSightUploadSayFooter snsSightUploadSayFooter) {
        AppMethodBeat.i(39296);
        snsSightUploadSayFooter.aRe();
        AppMethodBeat.o(39296);
    }

    public SnsSightUploadSayFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(39291);
        this.crP = (MMActivity) context;
        ViewGroup viewGroup = (ViewGroup) inflate(this.crP, R.layout.aw9, this);
        this.jZh = (ImageButton) viewGroup.findViewById(R.id.d0w);
        this.jZh.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(39288);
                SnsSightUploadSayFooter.d(SnsSightUploadSayFooter.this);
                AppMethodBeat.o(39288);
            }
        });
        if (e.vom == null) {
            this.eAk = new d(this.crP);
        } else {
            this.eAk = e.vom.dF(getContext());
            this.eAk.setEntranceScene(ChatFooterPanel.vhj);
            this.eAk.setVisibility(8);
            ((LinearLayout) findViewById(R.id.l_)).addView(this.eAk, -1, 0);
            this.eAk.AD();
            this.eAk.bf(false);
            this.eAk.setOnTextOperationListener(new a() {
                public final void aYY() {
                }

                public final void fC(boolean z) {
                }

                public final void aRg() {
                    AppMethodBeat.i(39289);
                    SnsSightUploadSayFooter.this.jZg.getInputConnection().sendKeyEvent(new KeyEvent(0, 67));
                    SnsSightUploadSayFooter.this.jZg.getInputConnection().sendKeyEvent(new KeyEvent(1, 67));
                    AppMethodBeat.o(39289);
                }

                public final void append(String str) {
                    AppMethodBeat.i(39290);
                    try {
                        SnsSightUploadSayFooter.this.jZg.asB(str);
                        AppMethodBeat.o(39290);
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.SnsSightUploadSayFooter", e, "", new Object[0]);
                        AppMethodBeat.o(39290);
                    }
                }
            });
        }
        this.rwY = (SightRangeWidget) viewGroup.findViewById(R.id.d0x);
        this.rwY.rhg = null;
        this.rwY.style = 1;
        this.rwZ = (SightLocationWidget) viewGroup.findViewById(R.id.eld);
        AppMethodBeat.o(39291);
    }

    public void setMMEditText(MMEditText mMEditText) {
        AppMethodBeat.i(39292);
        this.jZg = mMEditText;
        mMEditText.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                int i = 0;
                AppMethodBeat.i(39286);
                if (SnsSightUploadSayFooter.this.getVisibility() == 8) {
                    SnsSightUploadSayFooter.this.setVisibility(0);
                }
                if (SnsSightUploadSayFooter.this.eAk.getVisibility() == 0) {
                    i = 1;
                }
                if (i != 0) {
                    SnsSightUploadSayFooter.a(SnsSightUploadSayFooter.this);
                }
                AppMethodBeat.o(39286);
            }
        });
        mMEditText.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return false;
            }
        });
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(39287);
                SnsSightUploadSayFooter.this.jZg.performClick();
                SnsSightUploadSayFooter.this.jZg.requestFocus();
                SnsSightUploadSayFooter.this.crP.showVKB();
                AppMethodBeat.o(39287);
            }
        }, 200);
        AppMethodBeat.o(39292);
    }

    private void aRe() {
        AppMethodBeat.i(39293);
        this.eAk.onPause();
        this.eAk.setVisibility(8);
        AppMethodBeat.o(39293);
    }

    public List<View> getPanelView() {
        AppMethodBeat.i(39294);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.eAk);
        AppMethodBeat.o(39294);
        return arrayList;
    }

    public ayt getLocation() {
        AppMethodBeat.i(39295);
        ayt location = this.rwZ.getLocation();
        AppMethodBeat.o(39295);
        return location;
    }

    static /* synthetic */ void d(SnsSightUploadSayFooter snsSightUploadSayFooter) {
        AppMethodBeat.i(39297);
        if (snsSightUploadSayFooter.eAk.getVisibility() == 8) {
            snsSightUploadSayFooter.crP.aqX();
            snsSightUploadSayFooter.eAk.onResume();
            snsSightUploadSayFooter.eAk.setVisibility(0);
            snsSightUploadSayFooter.jZg.requestFocus();
            snsSightUploadSayFooter.jZh.setImageResource(R.raw.sight_icon_keyboard);
            snsSightUploadSayFooter.oin = false;
            AppMethodBeat.o(39297);
            return;
        }
        snsSightUploadSayFooter.oin = false;
        snsSightUploadSayFooter.jZg.requestFocus();
        snsSightUploadSayFooter.aRe();
        snsSightUploadSayFooter.crP.showVKB();
        snsSightUploadSayFooter.jZh.setImageResource(R.raw.sight_icon_emoji);
        AppMethodBeat.o(39297);
    }
}
