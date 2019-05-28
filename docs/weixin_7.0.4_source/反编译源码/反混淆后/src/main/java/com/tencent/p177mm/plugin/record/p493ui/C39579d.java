package com.tencent.p177mm.plugin.record.p493ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p612ui.widget.MMPinProgressBtn;
import com.tencent.p177mm.plugin.fav.p407a.C11855p;
import com.tencent.p177mm.plugin.fav.p407a.C45925c;
import com.tencent.p177mm.plugin.record.p492b.C21601g;
import com.tencent.p177mm.plugin.record.p493ui.C3706h.C3709a;
import com.tencent.p177mm.plugin.record.p493ui.p1619a.C43438b;
import com.tencent.p177mm.plugin.record.p493ui.p494b.C41300c;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C34915a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.record.ui.d */
public final class C39579d extends C3706h {
    private static HashMap<String, Boolean> pKa = new HashMap();
    public C11855p pKb = new C288461();

    /* renamed from: com.tencent.mm.plugin.record.ui.d$1 */
    class C288461 implements C11855p {
        C288461() {
        }

        /* renamed from: d */
        public final void mo23673d(final C45925c c45925c) {
            AppMethodBeat.m2504i(24196);
            if (c45925c.field_favLocalId != ((C13017b) C39579d.this.pKs).mnW.field_localId) {
                C4990ab.m7417i("MicroMsg.FavRecordAdapter", "not equal Id %d %d", Long.valueOf(c45925c.field_favLocalId), Long.valueOf(((C13017b) C39579d.this.pKs).mnW.field_localId));
                AppMethodBeat.m2505o(24196);
                return;
            }
            C4990ab.m7411d("MicroMsg.FavRecordAdapter", "on cdn status changed, fav local id %d, data id %s, status %d", Long.valueOf(c45925c.field_favLocalId), c45925c.field_dataId, Integer.valueOf(c45925c.field_status));
            if (4 == c45925c.field_status) {
                C39579d.pKa.put(C5046bo.m7532bc(c45925c.field_dataId, BuildConfig.COMMAND), Boolean.TRUE);
            }
            if (c45925c.isFinished()) {
                C39579d.this.mty.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(24195);
                        View view = (View) C41300c.pLf.get(c45925c.field_dataId);
                        String str = "MicroMsg.FavRecordAdapter";
                        String str2 = "view is null %s";
                        Object[] objArr = new Object[1];
                        objArr[0] = Boolean.valueOf(view == null);
                        C4990ab.m7411d(str, str2, objArr);
                        if (view == null) {
                            AppMethodBeat.m2505o(24195);
                            return;
                        }
                        C43438b c43438b = (C43438b) view.getTag();
                        str2 = C21601g.m33077a(c43438b);
                        C4990ab.m7411d("MicroMsg.FavRecordAdapter", "dataItemId: %s", c43438b.cAv.mnd);
                        if (c43438b.cAv.mnd.equals(c45925c.field_dataId)) {
                            C4990ab.m7411d("MicroMsg.FavRecordAdapter", "change the sight status %s, dataId %s, progress %s cdnInfo %s", Integer.valueOf(c45925c.field_status), c45925c.field_dataId, Float.valueOf(c45925c.getProgress()), Boolean.valueOf(c45925c.isFinished()));
                            ImageView imageView = (ImageView) view.findViewById(2131820981);
                            MMPinProgressBtn mMPinProgressBtn = (MMPinProgressBtn) view.findViewById(2131821370);
                            C34915a c34915a = (C34915a) view.findViewById(2131820629);
                            imageView.setVisibility(8);
                            mMPinProgressBtn.setVisibility(8);
                            C4990ab.m7416i("MicroMsg.FavRecordAdapter", "setVideoPath ".concat(String.valueOf(str2)));
                            c34915a.setCanPlay(true);
                            c34915a.mo8509bf(str2, false);
                        }
                        AppMethodBeat.m2505o(24195);
                    }
                });
            }
            C39579d.this.ceP();
            AppMethodBeat.m2505o(24196);
        }
    }

    static {
        AppMethodBeat.m2504i(24200);
        AppMethodBeat.m2505o(24200);
    }

    public C39579d(Context context, C3709a c3709a) {
        super(context, c3709a);
        AppMethodBeat.m2504i(24197);
        AppMethodBeat.m2505o(24197);
    }

    /* renamed from: a */
    public final void mo8328a(C28837a c28837a) {
        AppMethodBeat.m2504i(24198);
        C4990ab.m7417i("MicroMsg.FavRecordAdapter", "updateData localId %s,status %s", Long.valueOf(((C13017b) c28837a).mnW.field_localId), Integer.valueOf(((C13017b) c28837a).mnW.field_itemStatus));
        this.pKs = c28837a;
        this.pJZ.clear();
        this.pJZ.addAll(c28837a.pJZ);
        notifyDataSetChanged();
        AppMethodBeat.m2505o(24198);
    }

    /* renamed from: d */
    public final void mo8331d(C43438b c43438b) {
        AppMethodBeat.m2504i(24199);
        C4990ab.m7411d("MicroMsg.FavRecordAdapter", "setupRecord %s", Long.valueOf(((C13017b) this.pKs).mnW.field_localId));
        c43438b.fromScene = 1;
        c43438b.dataType = 1;
        c43438b.mnW = ((C13017b) this.pKs).mnW;
        AppMethodBeat.m2505o(24199);
    }
}
