package com.tencent.p177mm.plugin.record.p493ui.p494b;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C37721gh;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.MMPinProgressBtn;
import com.tencent.p177mm.plugin.fav.p407a.C39037b;
import com.tencent.p177mm.plugin.record.p1016a.C21592a;
import com.tencent.p177mm.plugin.record.p1016a.C34792i;
import com.tencent.p177mm.plugin.record.p492b.C43436n;
import com.tencent.p177mm.plugin.record.p493ui.C3706h.C3709a;
import com.tencent.p177mm.plugin.record.p493ui.C3706h.C3709a.C3711c;
import com.tencent.p177mm.plugin.record.p493ui.C3706h.C3713b;
import com.tencent.p177mm.plugin.record.p493ui.RecordMsgFileUI;
import com.tencent.p177mm.plugin.record.p493ui.p1619a.C43438b;
import com.tencent.p177mm.plugin.record.p493ui.p1619a.C44759c;
import com.tencent.p177mm.plugin.sight.decode.p1020a.C34915a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.view.C31128d;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.record.ui.b.c */
public final class C41300c implements C3713b {
    public static Map<String, View> pLf = new HashMap();
    private OnClickListener mjE = new C413011();
    private C3709a pKt;

    /* renamed from: com.tencent.mm.plugin.record.ui.b.c$1 */
    class C413011 implements OnClickListener {
        C413011() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(24362);
            C43438b c43438b = (C43438b) view.getTag();
            Intent intent;
            if (c43438b.dataType != 0) {
                if (c43438b.dataType == 1) {
                    C37721gh c37721gh;
                    C4990ab.m7417i("MicroMsg.SightViewWrapper", "click item favid %d, localid %d, itemstatus %d", Integer.valueOf(c43438b.mnW.field_id), Long.valueOf(c43438b.mnW.field_localId), Integer.valueOf(c43438b.mnW.field_itemStatus));
                    if (c43438b.mnW.isDone()) {
                        c37721gh = new C37721gh();
                        c37721gh.cAH.type = 14;
                        c37721gh.cAH.cAJ = c43438b.cAv;
                        C4879a.xxA.mo10055m(c37721gh);
                        C4990ab.m7417i("MicroMsg.SightViewWrapper", "favItemInfo is Done,file exist ret = %d", Integer.valueOf(c37721gh.cAI.ret));
                        if (c37721gh.cAI.ret == 1) {
                            intent = new Intent();
                            intent.putExtra("key_detail_info_id", c43438b.mnW.field_localId);
                            intent.putExtra("key_detail_data_id", c43438b.cAv.mnd);
                            intent.putExtra("key_detail_can_delete", false);
                            C39037b.m66352a(view.getContext(), ".ui.detail.FavoriteFileDetailUI", intent, 1);
                            AppMethodBeat.m2505o(24362);
                            return;
                        } else if (C5046bo.isNullOrNil(c43438b.cAv.wfZ)) {
                            C4990ab.m7420w("MicroMsg.SightViewWrapper", "favItemInfo getCdnDataUrl empty");
                            AppMethodBeat.m2505o(24362);
                            return;
                        } else {
                            C4990ab.m7420w("MicroMsg.SightViewWrapper", "? info is done, source file not exist, cdn data url is not null");
                        }
                    } else if (c43438b.mnW.buy() || c43438b.mnW.bux()) {
                        C4990ab.m7416i("MicroMsg.SightViewWrapper", "favItemInfo isDownLoadFaied or isUploadFailed, wait download");
                    } else if (c43438b.mnW.isDownloading() || c43438b.mnW.buw()) {
                        C4990ab.m7416i("MicroMsg.SightViewWrapper", "favItemInfo isDownloading or isUploadding, wait download");
                        AppMethodBeat.m2505o(24362);
                        return;
                    } else {
                        C4990ab.m7420w("MicroMsg.SightViewWrapper", "other status, not done, downloading, uploading, downloadfail, uploadfail");
                    }
                    c37721gh = new C37721gh();
                    c37721gh.cAH.cvv = c43438b.mnW.field_localId;
                    if (c43438b.mnW.bux()) {
                        C4990ab.m7420w("MicroMsg.SightViewWrapper", "upload failed, try to restart...");
                        c37721gh.cAH.type = 15;
                        C4879a.xxA.mo10055m(c37721gh);
                        AppMethodBeat.m2505o(24362);
                        return;
                    }
                    C4990ab.m7420w("MicroMsg.SightViewWrapper", "download failed, try to restart...");
                    c37721gh.cAH.type = 16;
                    C4879a.xxA.mo10055m(c37721gh);
                }
                AppMethodBeat.m2505o(24362);
            } else if (C43436n.m77560d(c43438b.cAv, c43438b.cvx)) {
                C4990ab.m7416i("MicroMsg.SightViewWrapper", "onclick: play sight");
                intent = new Intent(view.getContext(), RecordMsgFileUI.class);
                intent.putExtra("message_id", c43438b.cvx);
                intent.putExtra("record_xml", c43438b.cKa);
                intent.putExtra("record_data_id", c43438b.cAv.mnd);
                view.getContext().startActivity(intent);
                AppMethodBeat.m2505o(24362);
            } else {
                C34792i VH = ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37079VH(C43436n.m77564h(c43438b.cAv.mnd, c43438b.cvx, true));
                String str = "MicroMsg.SightViewWrapper";
                String str2 = "onclick: cdnInfo status %s";
                Object[] objArr = new Object[1];
                objArr[0] = VH == null ? BuildConfig.COMMAND : Integer.valueOf(VH.field_status);
                C4990ab.m7417i(str, str2, objArr);
                if (!(VH == null || 2 == VH.field_status || 3 == VH.field_status)) {
                    if (4 == VH.field_status) {
                        C30379h.m48465bQ(view.getContext(), view.getResources().getString(C25738R.string.bqx));
                        AppMethodBeat.m2505o(24362);
                        return;
                    } else if (VH.field_status == 0 || 1 == VH.field_status) {
                        AppMethodBeat.m2505o(24362);
                        return;
                    }
                }
                C43436n.m77557b(c43438b.cAv, c43438b.cvx, true);
                AppMethodBeat.m2505o(24362);
            }
        }
    }

    public C41300c(C3709a c3709a) {
        AppMethodBeat.m2504i(24363);
        this.pKt = c3709a;
        AppMethodBeat.m2505o(24363);
    }

    static {
        AppMethodBeat.m2504i(24366);
        AppMethodBeat.m2505o(24366);
    }

    /* renamed from: eK */
    public final View mo8346eK(Context context) {
        AppMethodBeat.m2504i(24364);
        View inflate = View.inflate(context, 2130970483, null);
        ((C34915a) inflate.findViewById(2131820629)).setDrawableWidth(C1338a.fromDPToPix(context, C31128d.MIC_PTU_ZIPAI_GRADIENT_BLUEYELLOW));
        AppMethodBeat.m2505o(24364);
        return inflate;
    }

    /* renamed from: a */
    public final void mo8344a(View view, int i, C43438b c43438b) {
        AppMethodBeat.m2504i(24365);
        view.setTag(c43438b);
        view.setOnClickListener(this.mjE);
        C34915a c34915a = (C34915a) view.findViewById(2131820629);
        ImageView imageView = (ImageView) view.findViewById(2131820981);
        MMPinProgressBtn mMPinProgressBtn = (MMPinProgressBtn) view.findViewById(2131821370);
        c34915a.setPosition(i);
        C44759c c44759c = (C44759c) c43438b;
        C3709a c3709a = this.pKt;
        Map map = pLf;
        C3711c c3711c = new C3711c();
        c3711c.cAv = c44759c.cAv;
        String c;
        if (c44759c.dataType == 0) {
            c3711c.pKv = c44759c.cvx;
            if (C43436n.m77560d(c44759c.cAv, c44759c.cvx)) {
                imageView.setVisibility(8);
                mMPinProgressBtn.setVisibility(8);
                c = C43436n.m77558c(c44759c.cAv, c44759c.cvx);
                if (!c.equals(c34915a.getVideoPath())) {
                    c34915a.setThumbBmp(c3709a.mo8341a(c3711c));
                }
                c34915a.mo8509bf(c, false);
                AppMethodBeat.m2505o(24365);
                return;
            }
            C34792i VH = ((C21592a) C1720g.m3530M(C21592a.class)).getRecordMsgCDNStorage().mo37079VH(C43436n.m77564h(c44759c.cAv.mnd, c44759c.cvx, true));
            if (VH == null || 2 == VH.field_status) {
                imageView.setImageResource(C1318a.shortvideo_play_btn);
            } else if (3 == VH.field_status || 4 == VH.field_status) {
                imageView.setImageResource(C25738R.drawable.atu);
            } else if (VH.field_status == 0 || 1 == VH.field_status) {
                imageView.setVisibility(8);
                mMPinProgressBtn.setVisibility(0);
                mMPinProgressBtn.setProgress((int) ((((float) VH.field_offset) / ((float) Math.max(1, VH.field_totalLen))) * 100.0f));
                c34915a.clear();
                c34915a.setThumbBmp(c3709a.mo8341a(c3711c));
                AppMethodBeat.m2505o(24365);
                return;
            } else {
                imageView.setImageResource(C1318a.shortvideo_play_btn);
            }
            imageView.setVisibility(0);
            mMPinProgressBtn.setVisibility(8);
            c34915a.clear();
            c34915a.setThumbBmp(c3709a.mo8341a(c3711c));
            AppMethodBeat.m2505o(24365);
            return;
        }
        if (c44759c.dataType == 1) {
            map.put(c44759c.cAv.mnd, view);
            C4990ab.m7411d("MicroMsg.SightRecordData", "dataId %s, status %s", Long.valueOf(c44759c.mnW.field_localId), Integer.valueOf(c44759c.mnW.field_itemStatus));
            c3711c.pKv = c44759c.mnW.field_localId;
            C37721gh c37721gh = new C37721gh();
            c37721gh.cAH.type = 14;
            c37721gh.cAH.cAJ = c44759c.cAv;
            C4879a.xxA.mo10055m(c37721gh);
            if (c44759c.mnW.isDone() || c37721gh.cAI.ret == 1) {
                if (c37721gh.cAI.ret == 1) {
                    imageView.setVisibility(8);
                    mMPinProgressBtn.setVisibility(8);
                    c37721gh.cAH.type = 2;
                    C4879a.xxA.mo10055m(c37721gh);
                    c = c37721gh.cAI.path;
                    if (C5046bo.isNullOrNil(c)) {
                        C4990ab.m7420w("MicroMsg.SightRecordData", "videoPath is null!");
                        AppMethodBeat.m2505o(24365);
                        return;
                    }
                    if (!c.equals(c34915a.getVideoPath())) {
                        c34915a.setThumbBmp(c3709a.mo8341a(c3711c));
                    }
                    c34915a.mo8509bf(c, false);
                    AppMethodBeat.m2505o(24365);
                    return;
                } else if (C5046bo.isNullOrNil(c44759c.cAv.wfZ)) {
                    imageView.setImageResource(C25738R.drawable.atu);
                } else {
                    C4990ab.m7420w("MicroMsg.SightRecordData", "? info is done, source file not exist, cdn data url is not null");
                    imageView.setImageResource(C1318a.shortvideo_play_btn);
                }
            } else if (c44759c.mnW.buy() || c44759c.mnW.bux()) {
                imageView.setImageResource(C1318a.shortvideo_play_btn);
            } else if (c44759c.mnW.isDownloading()) {
                imageView.setVisibility(8);
                mMPinProgressBtn.setVisibility(0);
                mMPinProgressBtn.dKB();
                c34915a.clear();
                c34915a.setThumbBmp(c3709a.mo8341a(c3711c));
                AppMethodBeat.m2505o(24365);
                return;
            } else {
                C4990ab.m7420w("MicroMsg.SightRecordData", "other status, not done, downloading, uploading, downloadfail, uploadfail");
                imageView.setImageResource(C1318a.shortvideo_play_btn);
            }
            imageView.setVisibility(0);
            mMPinProgressBtn.setVisibility(8);
            c34915a.clear();
            c34915a.setThumbBmp(c3709a.mo8341a(c3711c));
        }
        AppMethodBeat.m2505o(24365);
    }

    public final void destroy() {
        this.pKt = null;
    }

    public final void pause() {
    }
}
