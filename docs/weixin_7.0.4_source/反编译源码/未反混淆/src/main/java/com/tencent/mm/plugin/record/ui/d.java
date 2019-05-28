package com.tencent.mm.plugin.record.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.record.b.g;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;

public final class d extends h {
    private static HashMap<String, Boolean> pKa = new HashMap();
    public p pKb = new p() {
        public final void d(final c cVar) {
            AppMethodBeat.i(24196);
            if (cVar.field_favLocalId != ((b) d.this.pKs).mnW.field_localId) {
                ab.i("MicroMsg.FavRecordAdapter", "not equal Id %d %d", Long.valueOf(cVar.field_favLocalId), Long.valueOf(((b) d.this.pKs).mnW.field_localId));
                AppMethodBeat.o(24196);
                return;
            }
            ab.d("MicroMsg.FavRecordAdapter", "on cdn status changed, fav local id %d, data id %s, status %d", Long.valueOf(cVar.field_favLocalId), cVar.field_dataId, Integer.valueOf(cVar.field_status));
            if (4 == cVar.field_status) {
                d.pKa.put(bo.bc(cVar.field_dataId, BuildConfig.COMMAND), Boolean.TRUE);
            }
            if (cVar.isFinished()) {
                d.this.mty.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(24195);
                        View view = (View) com.tencent.mm.plugin.record.ui.b.c.pLf.get(cVar.field_dataId);
                        String str = "MicroMsg.FavRecordAdapter";
                        String str2 = "view is null %s";
                        Object[] objArr = new Object[1];
                        objArr[0] = Boolean.valueOf(view == null);
                        ab.d(str, str2, objArr);
                        if (view == null) {
                            AppMethodBeat.o(24195);
                            return;
                        }
                        b bVar = (b) view.getTag();
                        str2 = g.a(bVar);
                        ab.d("MicroMsg.FavRecordAdapter", "dataItemId: %s", bVar.cAv.mnd);
                        if (bVar.cAv.mnd.equals(cVar.field_dataId)) {
                            ab.d("MicroMsg.FavRecordAdapter", "change the sight status %s, dataId %s, progress %s cdnInfo %s", Integer.valueOf(cVar.field_status), cVar.field_dataId, Float.valueOf(cVar.getProgress()), Boolean.valueOf(cVar.isFinished()));
                            ImageView imageView = (ImageView) view.findViewById(R.id.l4);
                            MMPinProgressBtn mMPinProgressBtn = (MMPinProgressBtn) view.findViewById(R.id.vm);
                            a aVar = (a) view.findViewById(R.id.bl);
                            imageView.setVisibility(8);
                            mMPinProgressBtn.setVisibility(8);
                            ab.i("MicroMsg.FavRecordAdapter", "setVideoPath ".concat(String.valueOf(str2)));
                            aVar.setCanPlay(true);
                            aVar.bf(str2, false);
                        }
                        AppMethodBeat.o(24195);
                    }
                });
            }
            d.this.ceP();
            AppMethodBeat.o(24196);
        }
    };

    static {
        AppMethodBeat.i(24200);
        AppMethodBeat.o(24200);
    }

    public d(Context context, h.a aVar) {
        super(context, aVar);
        AppMethodBeat.i(24197);
        AppMethodBeat.o(24197);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(24198);
        ab.i("MicroMsg.FavRecordAdapter", "updateData localId %s,status %s", Long.valueOf(((b) aVar).mnW.field_localId), Integer.valueOf(((b) aVar).mnW.field_itemStatus));
        this.pKs = aVar;
        this.pJZ.clear();
        this.pJZ.addAll(aVar.pJZ);
        notifyDataSetChanged();
        AppMethodBeat.o(24198);
    }

    public final void d(b bVar) {
        AppMethodBeat.i(24199);
        ab.d("MicroMsg.FavRecordAdapter", "setupRecord %s", Long.valueOf(((b) this.pKs).mnW.field_localId));
        bVar.fromScene = 1;
        bVar.dataType = 1;
        bVar.mnW = ((b) this.pKs).mnW;
        AppMethodBeat.o(24199);
    }
}
