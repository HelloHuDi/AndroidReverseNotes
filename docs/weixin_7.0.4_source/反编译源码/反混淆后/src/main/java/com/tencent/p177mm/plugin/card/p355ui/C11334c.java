package com.tencent.p177mm.plugin.card.p355ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.plugin.card.base.C45773c;
import com.tencent.p177mm.plugin.card.model.C33771n.C11290a;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.model.CardInfo;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.card.ui.c */
public class C11334c extends C46692p<CardInfo> {
    private final String TAG = "MicroMsg.CardAdapter";
    private int count = 0;
    private C45773c kgW;
    private C11290a kiz;

    /* renamed from: a */
    public final /* synthetic */ Object mo7687a(Object obj, Cursor cursor) {
        AppMethodBeat.m2504i(88245);
        obj = (CardInfo) obj;
        if (obj == null) {
            obj = new CardInfo();
        }
        if (cursor.isClosed()) {
            C4990ab.m7412e("MicroMsg.CardAdapter", "cursor is closed!");
            AppMethodBeat.m2505o(88245);
        } else {
            obj.mo8995d(cursor);
            AppMethodBeat.m2505o(88245);
        }
        return obj;
    }

    public C11334c(Context context, C11290a c11290a) {
        super(context, new CardInfo());
        AppMethodBeat.m2504i(88240);
        this.kiz = c11290a;
        mo74996pN(true);
        this.kgW = new C2782l(context, this);
        AppMethodBeat.m2505o(88240);
    }

    /* renamed from: KC */
    public void mo6869KC() {
        AppMethodBeat.m2504i(88241);
        C4990ab.m7418v("MicroMsg.CardAdapter", "resetCursor");
        bIf();
        Cursor a = C42852am.baW().mo45384a(this.kiz);
        if (a != null) {
            this.count = a.getCount();
            C4990ab.m7418v("MicroMsg.CardAdapter", "card count:" + this.count);
        }
        setCursor(a);
        notifyDataSetChanged();
        AppMethodBeat.m2505o(88241);
    }

    /* renamed from: KD */
    public void mo6870KD() {
        AppMethodBeat.m2504i(88242);
        bIf();
        mo6869KC();
        AppMethodBeat.m2505o(88242);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(88243);
        View a = this.kgW.mo6879a(i, view, (CardInfo) getItem(i));
        AppMethodBeat.m2505o(88243);
        return a;
    }

    public void release() {
        AppMethodBeat.m2504i(88244);
        bIf();
        this.kgW.release();
        this.kgW = null;
        AppMethodBeat.m2505o(88244);
    }
}
