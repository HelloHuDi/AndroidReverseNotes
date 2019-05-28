package com.tencent.p177mm.plugin.sns.p520ui.item;

import android.annotation.TargetApi;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.widget.QImageView.C15991a;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.plugin.sns.p520ui.C13633av;
import com.tencent.p177mm.plugin.sns.p520ui.C22067aq;
import com.tencent.p177mm.plugin.sns.p520ui.C46251au;
import com.tencent.p177mm.plugin.sns.p520ui.MaskImageView;
import com.tencent.p177mm.plugin.sns.p520ui.PhotosContent;
import com.tencent.p177mm.plugin.sns.p520ui.TagImageView;
import com.tencent.p177mm.plugin.sns.p520ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C13473h;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3950f.C3951a;
import com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.C3953i;
import com.tencent.p177mm.plugin.sns.storage.C21984b;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.baw;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C44222az;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.sns.ui.item.g */
public final class C22125g extends BaseTimeLineItem {
    private MaskImageView rIT;
    private int rqi;
    private int rqj = 103;

    /* renamed from: com.tencent.mm.plugin.sns.ui.item.g$a */
    public static class C13688a extends BaseViewHolder {
    }

    /* renamed from: d */
    public final void mo8945d(BaseViewHolder baseViewHolder) {
        AppMethodBeat.m2504i(40154);
        this.mActivity.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        C4990ab.m7416i("MiroMsg.PhotoTimeLineItem", "viewtype " + this.klY);
        this.rqi = C13373af.cnN();
        if (baseViewHolder.rHC == null || baseViewHolder.rHC.getParent() == null || !(baseViewHolder.rHC.getParent() instanceof ViewGroup)) {
            baseViewHolder.rHT = (PhotosContent) baseViewHolder.mRR.findViewById(2131827892);
            baseViewHolder.rHD = true;
        } else {
            if (this.klY == 2) {
                baseViewHolder.rHC.setLayoutResource(2130970819);
            } else if (this.klY == 3) {
                baseViewHolder.rHC.setLayoutResource(2130970816);
            } else if (this.klY == 4) {
                baseViewHolder.rHC.setLayoutResource(2130970817);
            } else if (this.klY == 5) {
                baseViewHolder.rHC.setLayoutResource(2130970818);
            } else {
                C4990ab.m7412e("MiroMsg.PhotoTimeLineItem", "error viewtyoe in photo item  " + this.klY);
            }
            if (!baseViewHolder.rHD) {
                baseViewHolder.rHT = (PhotosContent) baseViewHolder.rHC.inflate();
                baseViewHolder.rHD = true;
            }
        }
        baseViewHolder.rHT.rlN.clear();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < C22067aq.run[this.klY]) {
                TagImageView tagImageView = (TagImageView) baseViewHolder.rHT.findViewById(C22067aq.rur[i2]);
                baseViewHolder.rHT.mo8756a(tagImageView);
                tagImageView.setOnClickListener(this.qPr.qOL.rjy);
                this.qPr.jMO.mo39887c(tagImageView, this.qPr.qOL.rJV, this.qPr.qOL.rJH);
                i = i2 + 1;
            } else {
                baseViewHolder.rHT.setImageViewWidth(this.rqi);
                AppMethodBeat.m2505o(40154);
                return;
            }
        }
    }

    @TargetApi(16)
    /* renamed from: a */
    public final void mo8944a(BaseViewHolder baseViewHolder, int i, C13633av c13633av, TimeLineObject timeLineObject, int i2, C46251au c46251au) {
        AppMethodBeat.m2504i(40155);
        if (baseViewHolder.rHT == null) {
            AppMethodBeat.m2505o(40155);
            return;
        }
        String str;
        int i3;
        baseViewHolder.rHT.setVisibility(0);
        if (timeLineObject.xfH == null) {
            str = null;
        } else {
            str = timeLineObject.xfH.f17242Id;
        }
        if (!C5046bo.isNullOrNil(str)) {
            C24826a.gkF.mo38858a(str, timeLineObject.jBB, timeLineObject.xfM, c13633av.rAt);
        }
        LinkedList linkedList = new LinkedList();
        int width = ((WindowManager) this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth();
        if (c13633av.rgZ && i2 == 2) {
            final C21984b cqo = c13633av.qBY.cqo();
            if (cqo != null && cqo.qUH > 0.0f && cqo.qUI > 0.0f) {
                float a = C3953i.m6289a((double) cqo.qUH, 1, cqo.qUJ, cqo.qUK);
                float a2 = C3953i.m6289a((double) cqo.qUI, 1, cqo.qUJ, cqo.qUK);
                baw baw;
                if (cqo.qUG == 0) {
                    baw baw2 = new baw();
                    baw2.wFx = a;
                    baw2.wFy = a2;
                    if (a >= ((float) (((width - C1338a.fromDPToPix(this.mActivity, 50)) - this.mActivity.getResources().getDimensionPixelSize(C25738R.dimen.f9979m4)) - this.mActivity.getResources().getDimensionPixelSize(C25738R.dimen.f9979m4)))) {
                        baw2.wFx = (float) (((width - C1338a.fromDPToPix(this.mActivity, 50)) - this.mActivity.getResources().getDimensionPixelSize(C25738R.dimen.f9979m4)) - this.mActivity.getResources().getDimensionPixelSize(C25738R.dimen.f9979m4));
                        baw2.wFy = (float) ((int) ((baw2.wFx * cqo.qUI) / cqo.qUH));
                    }
                    baw2.wFz = baw2.wFx * baw2.wFy;
                    linkedList.add(baw2);
                } else if (cqo.qUG == 1) {
                    width = (((width - C1338a.fromDPToPix(this.mActivity, 50)) - C1338a.fromDPToPix(this.mActivity, 50)) - this.mActivity.getResources().getDimensionPixelSize(C25738R.dimen.f9979m4)) - this.mActivity.getResources().getDimensionPixelSize(C25738R.dimen.f9979m4);
                    i3 = (int) ((((float) width) * cqo.qUI) / cqo.qUH);
                    baw = new baw();
                    if (width > 0) {
                        a = (float) width;
                    }
                    baw.wFx = a;
                    if (i3 > 0) {
                        a = (float) i3;
                    } else {
                        a = a2;
                    }
                    baw.wFy = a;
                    baw.wFz = baw.wFx * baw.wFy;
                    linkedList.add(baw);
                } else if (cqo.qUG == 2) {
                    width = ((width - C1338a.fromDPToPix(this.mActivity, 50)) - this.mActivity.getResources().getDimensionPixelSize(C25738R.dimen.f9979m4)) - this.mActivity.getResources().getDimensionPixelSize(C25738R.dimen.f9979m4);
                    i3 = (int) ((((float) width) * cqo.qUI) / cqo.qUH);
                    baw = new baw();
                    if (width > 0) {
                        a = (float) width;
                    }
                    baw.wFx = a;
                    if (i3 > 0) {
                        a2 = (float) i3;
                    }
                    baw.wFy = a2;
                    baw.wFz = baw.wFx * baw.wFy;
                    linkedList.add(baw);
                }
            }
            if (!C5046bo.isNullOrNil(cqo.qUM)) {
                final PhotosContent photosContent = baseViewHolder.rHT;
                final TagImageView DT = baseViewHolder.rHT.mo8755DT(0);
                C13473h.m21623c("adId", cqo.qUM, false, 41, new C3951a() {
                    public final void cpu() {
                    }

                    public final void cmD() {
                    }

                    /* renamed from: YJ */
                    public final void mo8627YJ(String str) {
                        AppMethodBeat.m2504i(40153);
                        C22125g.this.rIT = (MaskImageView) photosContent.findViewById(2131827901);
                        if (C22125g.this.rIT != null) {
                            C22125g.this.rIT.setVisibility(0);
                            C22125g.this.rIT.setImageBitmap(BitmapFactory.decodeFile(str));
                            float a = C3953i.m6289a((double) cqo.qUN, 1, cqo.qUJ, cqo.qUK);
                            float a2 = C3953i.m6289a((double) cqo.qUO, 1, cqo.qUJ, cqo.qUK);
                            float a3 = C3953i.m6289a((double) cqo.qUP, 1, cqo.qUJ, cqo.qUK);
                            float a4 = C3953i.m6289a((double) cqo.qUQ, 1, cqo.qUJ, cqo.qUK);
                            LayoutParams layoutParams = new LayoutParams((int) a, (int) a2);
                            layoutParams.setMargins((int) ((((float) DT.getRight()) - a3) - a), (int) ((((float) DT.getBottom()) - a4) - a2), 0, 0);
                            C22125g.this.rIT.setLayoutParams(layoutParams);
                        }
                        AppMethodBeat.m2505o(40153);
                    }
                });
            }
        }
        C22067aq c22067aq = c46251au.rpY;
        PhotosContent photosContent2 = baseViewHolder.rHT;
        String str2 = c13633av.riA;
        i3 = this.mActivity.hashCode();
        boolean z = c13633av.rgZ;
        boolean z2 = this.rps;
        C44222az dtg = C44222az.dtg();
        dtg.oyB = timeLineObject.pcX;
        c22067aq.mo37629a(photosContent2, timeLineObject, str2, i3, i2, i, z, z2, dtg, linkedList, c13633av.rAs);
        baseViewHolder.rHT.mo8755DT(0).setScaleType(C15991a.CENTER_CROP);
        AppMethodBeat.m2505o(40155);
    }
}
