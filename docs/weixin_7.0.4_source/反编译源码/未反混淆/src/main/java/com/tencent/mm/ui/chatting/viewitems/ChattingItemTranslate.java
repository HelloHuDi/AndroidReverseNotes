package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.e.f;
import com.tencent.mm.pluginsdk.ui.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.view.d;

public class ChattingItemTranslate extends RelativeLayout {
    private SpannableStringBuilder vji = new SpannableStringBuilder();
    private CharacterStyle vjl = new ForegroundColorSpan(-5066062);
    private int vjo = 3;
    private MMNeat7extView zgY;
    private LinearLayout zgZ;
    private ProgressBar zha;
    private TextView zhb;
    private com.tencent.neattextview.textview.view.NeatTextView.b zhc;
    private boolean zhd;
    private GestureDetector zhe = new GestureDetector(getContext(), new SimpleOnGestureListener() {
        public final boolean onDoubleTap(MotionEvent motionEvent) {
            AppMethodBeat.i(33323);
            if (ChattingItemTranslate.this.zhc == null) {
                AppMethodBeat.o(33323);
                return false;
            }
            boolean fi = ChattingItemTranslate.this.zhc.fi(ChattingItemTranslate.this.zgY);
            AppMethodBeat.o(33323);
            return fi;
        }
    });

    public static class a extends ay {
        public int klY = 1;

        public a(bi biVar, boolean z, int i) {
            super(biVar, z, i, null, 0);
        }
    }

    public enum b {
        NoTransform,
        PreTransform,
        Transforming,
        Transformed;

        static {
            AppMethodBeat.o(33326);
        }
    }

    public ChattingItemTranslate(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(33327);
        AppMethodBeat.o(33327);
    }

    public final void init() {
        AppMethodBeat.i(33328);
        this.zgY = (MMNeat7extView) findViewById(R.id.atm);
        this.zha = (ProgressBar) findViewById(R.id.atl);
        this.zgZ = (LinearLayout) findViewById(R.id.atn);
        this.zhb = (TextView) findViewById(R.id.atp);
        this.zgY.setOnTouchListener(new f(this.zgY, new m(this.zgY.getContext())));
        AppMethodBeat.o(33328);
    }

    public final void a(CharSequence charSequence, b bVar) {
        AppMethodBeat.i(33329);
        if (!bo.ac(charSequence)) {
            this.zgY.setMinWidth(com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 80));
            this.zgY.setMaxWidth(com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), d.MIC_PTU_ZIPAI_MEDSEA));
            this.zgY.setVisibility(0);
            if (bVar == b.Transforming) {
                this.vji.clear();
                this.zgY.ah(a(this.vji, charSequence));
            } else {
                this.zgY.ah(charSequence);
            }
            this.zha.setVisibility(8);
            if (bVar == b.Transformed) {
                qz(true);
            } else {
                qz(false);
            }
        } else if (bVar != b.NoTransform) {
            this.zha.setVisibility(0);
            this.zgY.setVisibility(8);
            qz(false);
        }
        setVisibility(0);
        AppMethodBeat.o(33329);
    }

    public void setBrandWording(String str) {
        AppMethodBeat.i(33330);
        this.zhb.setText(str);
        AppMethodBeat.o(33330);
    }

    public void setOnDoubleClickListener(com.tencent.neattextview.textview.view.NeatTextView.b bVar) {
        this.zhc = bVar;
    }

    private void qz(boolean z) {
        AppMethodBeat.i(33331);
        Context context = ah.getContext();
        if (context == null) {
            AppMethodBeat.o(33331);
        } else if (z) {
            this.zgY.setPadding(com.tencent.mm.bz.a.fromDPToPix(context, 10), com.tencent.mm.bz.a.fromDPToPix(context, 8), com.tencent.mm.bz.a.fromDPToPix(context, 10), com.tencent.mm.bz.a.fromDPToPix(context, 4));
            this.zgZ.setVisibility(0);
            AppMethodBeat.o(33331);
        } else {
            this.zgY.setPadding(com.tencent.mm.bz.a.fromDPToPix(context, 10), com.tencent.mm.bz.a.fromDPToPix(context, 8), com.tencent.mm.bz.a.fromDPToPix(context, 10), com.tencent.mm.bz.a.fromDPToPix(context, 8));
            this.zgZ.setVisibility(8);
            AppMethodBeat.o(33331);
        }
    }

    private SpannableStringBuilder a(SpannableStringBuilder spannableStringBuilder, CharSequence charSequence) {
        AppMethodBeat.i(33332);
        if (spannableStringBuilder == null || charSequence == null || charSequence.length() == 0) {
            AppMethodBeat.o(33332);
        } else {
            int length;
            int i;
            if (charSequence.length() < this.vjo) {
                length = charSequence.length();
                i = 0;
            } else {
                length = charSequence.length();
                i = length - this.vjo;
            }
            spannableStringBuilder.append(charSequence).setSpan(this.vjl, i, length, 33);
            AppMethodBeat.o(33332);
        }
        return spannableStringBuilder;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        AppMethodBeat.i(33333);
        int action = motionEvent.getAction();
        boolean z2 = action == 1 && this.zhd;
        if (z2) {
            ab.d("MicroMsg.ChattingItemTranslate", "ignore Action Up Event this time");
            AppMethodBeat.o(33333);
        } else {
            if (action == 0) {
                this.zhd = false;
            }
            if (this.zhc == null || this.zhe == null) {
                z = false;
            } else {
                z = this.zhe.onTouchEvent(motionEvent);
            }
            if (!z) {
                z = super.onTouchEvent(motionEvent);
            }
            AppMethodBeat.o(33333);
        }
        return z;
    }
}
