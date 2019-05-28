package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.record.a.i;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.plugin.record.ui.RecordMsgFileUI;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.view.d;
import java.util.HashMap;
import java.util.Map;

public final class c implements b {
    public static Map<String, View> pLf = new HashMap();
    private OnClickListener mjE = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(24362);
            com.tencent.mm.plugin.record.ui.a.b bVar = (com.tencent.mm.plugin.record.ui.a.b) view.getTag();
            Intent intent;
            if (bVar.dataType != 0) {
                if (bVar.dataType == 1) {
                    gh ghVar;
                    ab.i("MicroMsg.SightViewWrapper", "click item favid %d, localid %d, itemstatus %d", Integer.valueOf(bVar.mnW.field_id), Long.valueOf(bVar.mnW.field_localId), Integer.valueOf(bVar.mnW.field_itemStatus));
                    if (bVar.mnW.isDone()) {
                        ghVar = new gh();
                        ghVar.cAH.type = 14;
                        ghVar.cAH.cAJ = bVar.cAv;
                        a.xxA.m(ghVar);
                        ab.i("MicroMsg.SightViewWrapper", "favItemInfo is Done,file exist ret = %d", Integer.valueOf(ghVar.cAI.ret));
                        if (ghVar.cAI.ret == 1) {
                            intent = new Intent();
                            intent.putExtra("key_detail_info_id", bVar.mnW.field_localId);
                            intent.putExtra("key_detail_data_id", bVar.cAv.mnd);
                            intent.putExtra("key_detail_can_delete", false);
                            com.tencent.mm.plugin.fav.a.b.a(view.getContext(), ".ui.detail.FavoriteFileDetailUI", intent, 1);
                            AppMethodBeat.o(24362);
                            return;
                        } else if (bo.isNullOrNil(bVar.cAv.wfZ)) {
                            ab.w("MicroMsg.SightViewWrapper", "favItemInfo getCdnDataUrl empty");
                            AppMethodBeat.o(24362);
                            return;
                        } else {
                            ab.w("MicroMsg.SightViewWrapper", "? info is done, source file not exist, cdn data url is not null");
                        }
                    } else if (bVar.mnW.buy() || bVar.mnW.bux()) {
                        ab.i("MicroMsg.SightViewWrapper", "favItemInfo isDownLoadFaied or isUploadFailed, wait download");
                    } else if (bVar.mnW.isDownloading() || bVar.mnW.buw()) {
                        ab.i("MicroMsg.SightViewWrapper", "favItemInfo isDownloading or isUploadding, wait download");
                        AppMethodBeat.o(24362);
                        return;
                    } else {
                        ab.w("MicroMsg.SightViewWrapper", "other status, not done, downloading, uploading, downloadfail, uploadfail");
                    }
                    ghVar = new gh();
                    ghVar.cAH.cvv = bVar.mnW.field_localId;
                    if (bVar.mnW.bux()) {
                        ab.w("MicroMsg.SightViewWrapper", "upload failed, try to restart...");
                        ghVar.cAH.type = 15;
                        a.xxA.m(ghVar);
                        AppMethodBeat.o(24362);
                        return;
                    }
                    ab.w("MicroMsg.SightViewWrapper", "download failed, try to restart...");
                    ghVar.cAH.type = 16;
                    a.xxA.m(ghVar);
                }
                AppMethodBeat.o(24362);
            } else if (n.d(bVar.cAv, bVar.cvx)) {
                ab.i("MicroMsg.SightViewWrapper", "onclick: play sight");
                intent = new Intent(view.getContext(), RecordMsgFileUI.class);
                intent.putExtra("message_id", bVar.cvx);
                intent.putExtra("record_xml", bVar.cKa);
                intent.putExtra("record_data_id", bVar.cAv.mnd);
                view.getContext().startActivity(intent);
                AppMethodBeat.o(24362);
            } else {
                i VH = ((com.tencent.mm.plugin.record.a.a) g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().VH(n.h(bVar.cAv.mnd, bVar.cvx, true));
                String str = "MicroMsg.SightViewWrapper";
                String str2 = "onclick: cdnInfo status %s";
                Object[] objArr = new Object[1];
                objArr[0] = VH == null ? BuildConfig.COMMAND : Integer.valueOf(VH.field_status);
                ab.i(str, str2, objArr);
                if (!(VH == null || 2 == VH.field_status || 3 == VH.field_status)) {
                    if (4 == VH.field_status) {
                        h.bQ(view.getContext(), view.getResources().getString(R.string.bqx));
                        AppMethodBeat.o(24362);
                        return;
                    } else if (VH.field_status == 0 || 1 == VH.field_status) {
                        AppMethodBeat.o(24362);
                        return;
                    }
                }
                n.b(bVar.cAv, bVar.cvx, true);
                AppMethodBeat.o(24362);
            }
        }
    };
    private com.tencent.mm.plugin.record.ui.h.a pKt;

    public c(com.tencent.mm.plugin.record.ui.h.a aVar) {
        AppMethodBeat.i(24363);
        this.pKt = aVar;
        AppMethodBeat.o(24363);
    }

    static {
        AppMethodBeat.i(24366);
        AppMethodBeat.o(24366);
    }

    public final View eK(Context context) {
        AppMethodBeat.i(24364);
        View inflate = View.inflate(context, R.layout.anp, null);
        ((com.tencent.mm.plugin.sight.decode.a.a) inflate.findViewById(R.id.bl)).setDrawableWidth(com.tencent.mm.bz.a.fromDPToPix(context, d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW));
        AppMethodBeat.o(24364);
        return inflate;
    }

    public final void a(View view, int i, com.tencent.mm.plugin.record.ui.a.b bVar) {
        AppMethodBeat.i(24365);
        view.setTag(bVar);
        view.setOnClickListener(this.mjE);
        com.tencent.mm.plugin.sight.decode.a.a aVar = (com.tencent.mm.plugin.sight.decode.a.a) view.findViewById(R.id.bl);
        ImageView imageView = (ImageView) view.findViewById(R.id.l4);
        MMPinProgressBtn mMPinProgressBtn = (MMPinProgressBtn) view.findViewById(R.id.vm);
        aVar.setPosition(i);
        com.tencent.mm.plugin.record.ui.a.c cVar = (com.tencent.mm.plugin.record.ui.a.c) bVar;
        com.tencent.mm.plugin.record.ui.h.a aVar2 = this.pKt;
        Map map = pLf;
        com.tencent.mm.plugin.record.ui.h.a.c cVar2 = new com.tencent.mm.plugin.record.ui.h.a.c();
        cVar2.cAv = cVar.cAv;
        String c;
        if (cVar.dataType == 0) {
            cVar2.pKv = cVar.cvx;
            if (n.d(cVar.cAv, cVar.cvx)) {
                imageView.setVisibility(8);
                mMPinProgressBtn.setVisibility(8);
                c = n.c(cVar.cAv, cVar.cvx);
                if (!c.equals(aVar.getVideoPath())) {
                    aVar.setThumbBmp(aVar2.a(cVar2));
                }
                aVar.bf(c, false);
                AppMethodBeat.o(24365);
                return;
            }
            i VH = ((com.tencent.mm.plugin.record.a.a) g.M(com.tencent.mm.plugin.record.a.a.class)).getRecordMsgCDNStorage().VH(n.h(cVar.cAv.mnd, cVar.cvx, true));
            if (VH == null || 2 == VH.field_status) {
                imageView.setImageResource(R.raw.shortvideo_play_btn);
            } else if (3 == VH.field_status || 4 == VH.field_status) {
                imageView.setImageResource(R.drawable.atu);
            } else if (VH.field_status == 0 || 1 == VH.field_status) {
                imageView.setVisibility(8);
                mMPinProgressBtn.setVisibility(0);
                mMPinProgressBtn.setProgress((int) ((((float) VH.field_offset) / ((float) Math.max(1, VH.field_totalLen))) * 100.0f));
                aVar.clear();
                aVar.setThumbBmp(aVar2.a(cVar2));
                AppMethodBeat.o(24365);
                return;
            } else {
                imageView.setImageResource(R.raw.shortvideo_play_btn);
            }
            imageView.setVisibility(0);
            mMPinProgressBtn.setVisibility(8);
            aVar.clear();
            aVar.setThumbBmp(aVar2.a(cVar2));
            AppMethodBeat.o(24365);
            return;
        }
        if (cVar.dataType == 1) {
            map.put(cVar.cAv.mnd, view);
            ab.d("MicroMsg.SightRecordData", "dataId %s, status %s", Long.valueOf(cVar.mnW.field_localId), Integer.valueOf(cVar.mnW.field_itemStatus));
            cVar2.pKv = cVar.mnW.field_localId;
            gh ghVar = new gh();
            ghVar.cAH.type = 14;
            ghVar.cAH.cAJ = cVar.cAv;
            a.xxA.m(ghVar);
            if (cVar.mnW.isDone() || ghVar.cAI.ret == 1) {
                if (ghVar.cAI.ret == 1) {
                    imageView.setVisibility(8);
                    mMPinProgressBtn.setVisibility(8);
                    ghVar.cAH.type = 2;
                    a.xxA.m(ghVar);
                    c = ghVar.cAI.path;
                    if (bo.isNullOrNil(c)) {
                        ab.w("MicroMsg.SightRecordData", "videoPath is null!");
                        AppMethodBeat.o(24365);
                        return;
                    }
                    if (!c.equals(aVar.getVideoPath())) {
                        aVar.setThumbBmp(aVar2.a(cVar2));
                    }
                    aVar.bf(c, false);
                    AppMethodBeat.o(24365);
                    return;
                } else if (bo.isNullOrNil(cVar.cAv.wfZ)) {
                    imageView.setImageResource(R.drawable.atu);
                } else {
                    ab.w("MicroMsg.SightRecordData", "? info is done, source file not exist, cdn data url is not null");
                    imageView.setImageResource(R.raw.shortvideo_play_btn);
                }
            } else if (cVar.mnW.buy() || cVar.mnW.bux()) {
                imageView.setImageResource(R.raw.shortvideo_play_btn);
            } else if (cVar.mnW.isDownloading()) {
                imageView.setVisibility(8);
                mMPinProgressBtn.setVisibility(0);
                mMPinProgressBtn.dKB();
                aVar.clear();
                aVar.setThumbBmp(aVar2.a(cVar2));
                AppMethodBeat.o(24365);
                return;
            } else {
                ab.w("MicroMsg.SightRecordData", "other status, not done, downloading, uploading, downloadfail, uploadfail");
                imageView.setImageResource(R.raw.shortvideo_play_btn);
            }
            imageView.setVisibility(0);
            mMPinProgressBtn.setVisibility(8);
            aVar.clear();
            aVar.setThumbBmp(aVar2.a(cVar2));
        }
        AppMethodBeat.o(24365);
    }

    public final void destroy() {
        this.pKt = null;
    }

    public final void pause() {
    }
}
