package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.a.f.a;
import com.tencent.mm.plugin.emoji.model.j;

public final class g extends f {
    private int kSp = 0;
    private int kSq = 0;
    private int kSr = 0;

    public g(Context context) {
        super(context);
    }

    public final int getCount() {
        AppMethodBeat.i(52751);
        int count = super.getCount();
        AppMethodBeat.o(52751);
        return count;
    }

    public final View b(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(52752);
        final a aVar = (a) view.getTag();
        if (this.kSp > 0) {
            if (i == 0) {
                aVar.kRO.setVisibility(0);
                aVar.kRO.setText(this.mContext.getString(R.string.bas));
            } else if (this.kSq > 0 && i == this.kSp) {
                aVar.kRO.setVisibility(0);
                aVar.kRO.setText(this.mContext.getString(R.string.bbc));
            } else if (i == this.kSp + this.kSq) {
                aVar.kRO.setVisibility(0);
                if (j.getEmojiStorageMgr().dta()) {
                    aVar.kRO.setText(R.string.bbb);
                } else {
                    aVar.kRO.setText(this.mContext.getString(R.string.ba9));
                }
            } else {
                aVar.kRO.setVisibility(8);
            }
        } else if (this.kSq > 0) {
            if (i == 0) {
                aVar.kRO.setVisibility(0);
                aVar.kRO.setText(this.mContext.getString(R.string.bbc));
            } else if (i == this.kSp + this.kSq) {
                aVar.kRO.setVisibility(0);
                if (j.getEmojiStorageMgr().dta()) {
                    aVar.kRO.setText(R.string.bbb);
                } else {
                    aVar.kRO.setText(this.mContext.getString(R.string.ba9));
                }
            } else {
                aVar.kRO.setVisibility(8);
            }
        } else if (i == 0) {
            aVar.kRO.setVisibility(0);
            if (j.getEmojiStorageMgr().dta()) {
                aVar.kRO.setText(R.string.bbb);
            } else {
                aVar.kRO.setText(this.mContext.getString(R.string.ba9));
            }
        } else {
            aVar.kRO.setVisibility(8);
        }
        if (aVar.kRQ != null) {
            aVar.kRQ.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(52750);
                    aVar.kRQ.setPressed(false);
                    AppMethodBeat.o(52750);
                }
            }, 100);
        }
        View b = super.b(i, view, viewGroup);
        AppMethodBeat.o(52752);
        return b;
    }

    public final f tX(int i) {
        AppMethodBeat.i(52753);
        f tX = super.getItem(i);
        AppMethodBeat.o(52753);
        return tX;
    }

    public final int bjw() {
        return this.kSp;
    }

    public final void tU(int i) {
        this.kSp = i;
    }

    public final int bjx() {
        return this.kSq;
    }

    public final void tV(int i) {
        this.kSq = i;
    }

    public final int bjy() {
        return this.kSr;
    }

    public final void tW(int i) {
        this.kSr = i;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bjA() {
        AppMethodBeat.i(52754);
        boolean dta = j.getEmojiStorageMgr().dta();
        AppMethodBeat.o(52754);
        return dta;
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(52755);
        f tX = super.getItem(i);
        AppMethodBeat.o(52755);
        return tX;
    }
}
