package com.tencent.mm.plugin.sns.ui.item;

import android.annotation.TargetApi;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.ui.MaskImageView;
import com.tencent.mm.plugin.sns.ui.PhotosContent;
import com.tencent.mm.plugin.sns.ui.TagImageView;
import com.tencent.mm.plugin.sns.ui.aq;
import com.tencent.mm.plugin.sns.ui.au;
import com.tencent.mm.plugin.sns.ui.av;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import java.util.LinkedList;

public final class g extends BaseTimeLineItem {
    private MaskImageView rIT;
    private int rqi;
    private int rqj = 103;

    public static class a extends BaseViewHolder {
    }

    public final void d(BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(40154);
        this.mActivity.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        ab.i("MiroMsg.PhotoTimeLineItem", "viewtype " + this.klY);
        this.rqi = af.cnN();
        if (baseViewHolder.rHC == null || baseViewHolder.rHC.getParent() == null || !(baseViewHolder.rHC.getParent() instanceof ViewGroup)) {
            baseViewHolder.rHT = (PhotosContent) baseViewHolder.mRR.findViewById(R.id.emm);
            baseViewHolder.rHD = true;
        } else {
            if (this.klY == 2) {
                baseViewHolder.rHC.setLayoutResource(R.layout.awt);
            } else if (this.klY == 3) {
                baseViewHolder.rHC.setLayoutResource(R.layout.awq);
            } else if (this.klY == 4) {
                baseViewHolder.rHC.setLayoutResource(R.layout.awr);
            } else if (this.klY == 5) {
                baseViewHolder.rHC.setLayoutResource(R.layout.aws);
            } else {
                ab.e("MiroMsg.PhotoTimeLineItem", "error viewtyoe in photo item  " + this.klY);
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
            if (i2 < aq.run[this.klY]) {
                TagImageView tagImageView = (TagImageView) baseViewHolder.rHT.findViewById(aq.rur[i2]);
                baseViewHolder.rHT.a(tagImageView);
                tagImageView.setOnClickListener(this.qPr.qOL.rjy);
                this.qPr.jMO.c(tagImageView, this.qPr.qOL.rJV, this.qPr.qOL.rJH);
                i = i2 + 1;
            } else {
                baseViewHolder.rHT.setImageViewWidth(this.rqi);
                AppMethodBeat.o(40154);
                return;
            }
        }
    }

    @TargetApi(16)
    public final void a(BaseViewHolder baseViewHolder, int i, av avVar, TimeLineObject timeLineObject, int i2, au auVar) {
        AppMethodBeat.i(40155);
        if (baseViewHolder.rHT == null) {
            AppMethodBeat.o(40155);
            return;
        }
        String str;
        int i3;
        baseViewHolder.rHT.setVisibility(0);
        if (timeLineObject.xfH == null) {
            str = null;
        } else {
            str = timeLineObject.xfH.Id;
        }
        if (!bo.isNullOrNil(str)) {
            com.tencent.mm.plugin.sns.c.a.gkF.a(str, timeLineObject.jBB, timeLineObject.xfM, avVar.rAt);
        }
        LinkedList linkedList = new LinkedList();
        int width = ((WindowManager) this.mActivity.getSystemService("window")).getDefaultDisplay().getWidth();
        if (avVar.rgZ && i2 == 2) {
            final b cqo = avVar.qBY.cqo();
            if (cqo != null && cqo.qUH > 0.0f && cqo.qUI > 0.0f) {
                float a = i.a((double) cqo.qUH, 1, cqo.qUJ, cqo.qUK);
                float a2 = i.a((double) cqo.qUI, 1, cqo.qUJ, cqo.qUK);
                baw baw;
                if (cqo.qUG == 0) {
                    baw baw2 = new baw();
                    baw2.wFx = a;
                    baw2.wFy = a2;
                    if (a >= ((float) (((width - com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 50)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.m4)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.m4)))) {
                        baw2.wFx = (float) (((width - com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 50)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.m4)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.m4));
                        baw2.wFy = (float) ((int) ((baw2.wFx * cqo.qUI) / cqo.qUH));
                    }
                    baw2.wFz = baw2.wFx * baw2.wFy;
                    linkedList.add(baw2);
                } else if (cqo.qUG == 1) {
                    width = (((width - com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 50)) - com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 50)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.m4)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.m4);
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
                    width = ((width - com.tencent.mm.bz.a.fromDPToPix(this.mActivity, 50)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.m4)) - this.mActivity.getResources().getDimensionPixelSize(R.dimen.m4);
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
            if (!bo.isNullOrNil(cqo.qUM)) {
                final PhotosContent photosContent = baseViewHolder.rHT;
                final TagImageView DT = baseViewHolder.rHT.DT(0);
                h.c("adId", cqo.qUM, false, 41, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f.a() {
                    public final void cpu() {
                    }

                    public final void cmD() {
                    }

                    public final void YJ(String str) {
                        AppMethodBeat.i(40153);
                        g.this.rIT = (MaskImageView) photosContent.findViewById(R.id.emv);
                        if (g.this.rIT != null) {
                            g.this.rIT.setVisibility(0);
                            g.this.rIT.setImageBitmap(BitmapFactory.decodeFile(str));
                            float a = i.a((double) cqo.qUN, 1, cqo.qUJ, cqo.qUK);
                            float a2 = i.a((double) cqo.qUO, 1, cqo.qUJ, cqo.qUK);
                            float a3 = i.a((double) cqo.qUP, 1, cqo.qUJ, cqo.qUK);
                            float a4 = i.a((double) cqo.qUQ, 1, cqo.qUJ, cqo.qUK);
                            LayoutParams layoutParams = new LayoutParams((int) a, (int) a2);
                            layoutParams.setMargins((int) ((((float) DT.getRight()) - a3) - a), (int) ((((float) DT.getBottom()) - a4) - a2), 0, 0);
                            g.this.rIT.setLayoutParams(layoutParams);
                        }
                        AppMethodBeat.o(40153);
                    }
                });
            }
        }
        aq aqVar = auVar.rpY;
        PhotosContent photosContent2 = baseViewHolder.rHT;
        String str2 = avVar.riA;
        i3 = this.mActivity.hashCode();
        boolean z = avVar.rgZ;
        boolean z2 = this.rps;
        az dtg = az.dtg();
        dtg.oyB = timeLineObject.pcX;
        aqVar.a(photosContent2, timeLineObject, str2, i3, i2, i, z, z2, dtg, linkedList, avVar.rAs);
        baseViewHolder.rHT.DT(0).setScaleType(com.tencent.mm.ui.widget.QImageView.a.CENTER_CROP);
        AppMethodBeat.o(40155);
    }
}
