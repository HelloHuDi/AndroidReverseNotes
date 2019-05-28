package com.tencent.p177mm.plugin.emoji.p381a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.p381a.C11548f.C11549a;
import com.tencent.p177mm.plugin.emoji.p381a.p946a.C11546f;

/* renamed from: com.tencent.mm.plugin.emoji.a.g */
public final class C16733g extends C11548f {
    private int kSp = 0;
    private int kSq = 0;
    private int kSr = 0;

    public C16733g(Context context) {
        super(context);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(52751);
        int count = super.getCount();
        AppMethodBeat.m2505o(52751);
        return count;
    }

    /* renamed from: b */
    public final View mo7106b(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(52752);
        final C11549a c11549a = (C11549a) view.getTag();
        if (this.kSp > 0) {
            if (i == 0) {
                c11549a.kRO.setVisibility(0);
                c11549a.kRO.setText(this.mContext.getString(C25738R.string.bas));
            } else if (this.kSq > 0 && i == this.kSp) {
                c11549a.kRO.setVisibility(0);
                c11549a.kRO.setText(this.mContext.getString(C25738R.string.bbc));
            } else if (i == this.kSp + this.kSq) {
                c11549a.kRO.setVisibility(0);
                if (C42952j.getEmojiStorageMgr().dta()) {
                    c11549a.kRO.setText(C25738R.string.bbb);
                } else {
                    c11549a.kRO.setText(this.mContext.getString(C25738R.string.ba9));
                }
            } else {
                c11549a.kRO.setVisibility(8);
            }
        } else if (this.kSq > 0) {
            if (i == 0) {
                c11549a.kRO.setVisibility(0);
                c11549a.kRO.setText(this.mContext.getString(C25738R.string.bbc));
            } else if (i == this.kSp + this.kSq) {
                c11549a.kRO.setVisibility(0);
                if (C42952j.getEmojiStorageMgr().dta()) {
                    c11549a.kRO.setText(C25738R.string.bbb);
                } else {
                    c11549a.kRO.setText(this.mContext.getString(C25738R.string.ba9));
                }
            } else {
                c11549a.kRO.setVisibility(8);
            }
        } else if (i == 0) {
            c11549a.kRO.setVisibility(0);
            if (C42952j.getEmojiStorageMgr().dta()) {
                c11549a.kRO.setText(C25738R.string.bbb);
            } else {
                c11549a.kRO.setText(this.mContext.getString(C25738R.string.ba9));
            }
        } else {
            c11549a.kRO.setVisibility(8);
        }
        if (c11549a.kRQ != null) {
            c11549a.kRQ.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(52750);
                    c11549a.kRQ.setPressed(false);
                    AppMethodBeat.m2505o(52750);
                }
            }, 100);
        }
        View b = super.mo7106b(i, view, viewGroup);
        AppMethodBeat.m2505o(52752);
        return b;
    }

    /* renamed from: tX */
    public final C11546f mo30702tX(int i) {
        AppMethodBeat.m2504i(52753);
        C11546f tX = super.getItem(i);
        AppMethodBeat.m2505o(52753);
        return tX;
    }

    public final int bjw() {
        return this.kSp;
    }

    /* renamed from: tU */
    public final void mo7111tU(int i) {
        this.kSp = i;
    }

    public final int bjx() {
        return this.kSq;
    }

    /* renamed from: tV */
    public final void mo7112tV(int i) {
        this.kSq = i;
    }

    public final int bjy() {
        return this.kSr;
    }

    /* renamed from: tW */
    public final void mo7113tW(int i) {
        this.kSr = i;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean bjA() {
        AppMethodBeat.m2504i(52754);
        boolean dta = C42952j.getEmojiStorageMgr().dta();
        AppMethodBeat.m2505o(52754);
        return dta;
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(52755);
        C11546f tX = super.getItem(i);
        AppMethodBeat.m2505o(52755);
        return tX;
    }
}
