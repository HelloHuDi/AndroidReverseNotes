package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelstat.C26485p.C1876a;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.sight.decode.p512ui.SightPlayImageView;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C21919f;
import com.tencent.p177mm.plugin.sns.model.C29057e;
import com.tencent.p177mm.plugin.sns.p1024b.C13356c;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C34927j;
import com.tencent.p177mm.plugin.sns.p514a.p515b.C39725b;
import com.tencent.p177mm.plugin.sns.p517i.C43549e;
import com.tencent.p177mm.plugin.sns.p520ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.protocal.protobuf.cdg;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashSet;

/* renamed from: com.tencent.mm.plugin.sns.ui.AdListView */
public class AdListView extends ListView {
    C39725b rfN;
    C21919f rfO;
    private C29057e rfP;
    private boolean rfQ = true;
    private HashSet<String> rfR = new HashSet();

    public AdListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(38053);
        AppMethodBeat.m2505o(38053);
    }

    public AdListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(38054);
        AppMethodBeat.m2505o(38054);
    }

    public void setTimelineStat(C21919f c21919f) {
        this.rfO = c21919f;
    }

    public void setTimelineEvent(C29057e c29057e) {
        this.rfP = c29057e;
    }

    /* Access modifiers changed, original: protected */
    public void layoutChildren() {
        AppMethodBeat.m2504i(38055);
        super.layoutChildren();
        AppMethodBeat.m2505o(38055);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(38056);
        super.onLayout(z, i, i2, i3, i4);
        AppMethodBeat.m2505o(38056);
    }

    /* Access modifiers changed, original: protected */
    public void detachViewFromParent(View view) {
        AppMethodBeat.m2504i(38057);
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof BaseViewHolder)) {
            BaseViewHolder baseViewHolder = (BaseViewHolder) view.getTag();
            str = baseViewHolder.position + " " + baseViewHolder.cwT;
        }
        if (C1947ae.giZ) {
            C4990ab.m7410d("MicroMsg.AdListView", "1childview  onRemoved " + str + " count:" + getChildCount());
        }
        super.detachViewFromParent(view);
        AppMethodBeat.m2505o(38057);
    }

    /* Access modifiers changed, original: protected */
    public void detachViewFromParent(int i) {
        AppMethodBeat.m2504i(38058);
        if (C1947ae.giZ) {
            C4990ab.m7410d("MicroMsg.AdListView", "2childview  onRemoved " + i + " count:" + getChildCount());
        }
        super.detachViewFromParent(i);
        AppMethodBeat.m2505o(38058);
    }

    /* Access modifiers changed, original: protected */
    public void attachViewToParent(View view, int i, LayoutParams layoutParams) {
        AppMethodBeat.m2504i(38059);
        super.attachViewToParent(view, i, layoutParams);
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof BaseViewHolder)) {
            BaseViewHolder baseViewHolder = (BaseViewHolder) view.getTag();
            String str2 = baseViewHolder.position + " " + baseViewHolder.cwT;
            boolean z = baseViewHolder.timeLineObject.xfP == 1 || baseViewHolder.timeLineObject.dtW == 1;
            C43549e.qTd.mo69123bl(baseViewHolder.timeLineObject.f15074Id, z);
            C43549e.qTd.mo69126gh(baseViewHolder.timeLineObject.f15074Id, baseViewHolder.timeLineObject.xfH == null ? "" : baseViewHolder.timeLineObject.xfH.f17242Id);
            C43549e.qTd.mo69127kr(baseViewHolder.rHt);
            if (this.rfN != null && baseViewHolder.qFG) {
                this.rfN.mo25431a(baseViewHolder.position, baseViewHolder.cwT, baseViewHolder.mVC, view, baseViewHolder.rHt, baseViewHolder.qCX, baseViewHolder.klY, 1);
            }
            if (!this.rfR.contains(baseViewHolder.cFc) && ((baseViewHolder.qFG && baseViewHolder.timeLineObject.xfI.wbJ == 15) || baseViewHolder.timeLineObject.xfI.wbJ == 18)) {
                z = false;
                if (baseViewHolder.timeLineObject.xfI.wbJ == 15 && (baseViewHolder.rGD.qzM instanceof SightPlayImageView)) {
                    z = ((SightPlayImageView) baseViewHolder.rGD.qzM).qyA.cla();
                }
                C34927j.m57344a(C13373af.cnF().mo62917YS(baseViewHolder.cFc), false, z, 0);
                this.rfR.add(baseViewHolder.cFc);
            }
            if (this.rfO != null) {
                this.rfO.mo25499a(baseViewHolder.cwT, baseViewHolder.timeLineObject);
            }
            if (this.rfP != null) {
                this.rfP.mo37369a(baseViewHolder.position, baseViewHolder.cwT, baseViewHolder.rHt, baseViewHolder.timeLineObject, baseViewHolder.qFG, baseViewHolder.qFH);
            }
            str = str2;
        }
        if (C1947ae.giZ) {
            C4990ab.m7410d("MicroMsg.AdListView", "3childview  onAdded " + str + " count:" + getChildCount());
        }
        AppMethodBeat.m2505o(38059);
    }

    public void onViewAdded(View view) {
        AppMethodBeat.m2504i(38060);
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof BaseViewHolder)) {
            BaseViewHolder baseViewHolder = (BaseViewHolder) view.getTag();
            String str2 = baseViewHolder.position + " " + baseViewHolder.cwT;
            boolean z = baseViewHolder.timeLineObject.xfP == 1 || baseViewHolder.timeLineObject.dtW == 1;
            C43549e.qTd.mo69123bl(baseViewHolder.timeLineObject.f15074Id, z);
            C43549e.qTd.mo69126gh(baseViewHolder.timeLineObject.f15074Id, baseViewHolder.timeLineObject.xfH == null ? "" : baseViewHolder.timeLineObject.xfH.f17242Id);
            C43549e.qTd.mo69127kr(baseViewHolder.rHt);
            if (this.rfN != null && baseViewHolder.qFG) {
                this.rfN.mo25431a(baseViewHolder.position, baseViewHolder.cwT, baseViewHolder.mVC, view, baseViewHolder.rHt, baseViewHolder.qCX, baseViewHolder.klY, 1);
            }
            if (!this.rfR.contains(baseViewHolder.cFc) && ((baseViewHolder.qFG && baseViewHolder.timeLineObject.xfI.wbJ == 15) || baseViewHolder.timeLineObject.xfI.wbJ == 18)) {
                z = false;
                if (baseViewHolder.timeLineObject.xfI.wbJ == 15 && (baseViewHolder.rGD.qzM instanceof SightPlayImageView)) {
                    z = ((SightPlayImageView) baseViewHolder.rGD.qzM).qyA.cla();
                }
                C34927j.m57344a(C13373af.cnF().mo62917YS(baseViewHolder.cFc), false, z, 0);
                this.rfR.add(baseViewHolder.cFc);
            }
            if (this.rfO != null) {
                this.rfO.mo25499a(baseViewHolder.cwT, baseViewHolder.timeLineObject);
            }
            if (this.rfP != null) {
                this.rfP.mo37369a(baseViewHolder.position, baseViewHolder.cwT, baseViewHolder.rHt, baseViewHolder.timeLineObject, baseViewHolder.qFG, baseViewHolder.qFH);
            }
            str = str2;
        }
        if (C1947ae.giZ) {
            C4990ab.m7410d("MicroMsg.AdListView", "4childview  onViewAdded " + str + " count:" + getChildCount());
        }
        AppMethodBeat.m2505o(38060);
    }

    public void onViewRemoved(View view) {
        AppMethodBeat.m2504i(38061);
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof BaseViewHolder)) {
            BaseViewHolder baseViewHolder = (BaseViewHolder) view.getTag();
            String str2 = baseViewHolder.position + " " + baseViewHolder.cwT;
            if (this.rfN != null && baseViewHolder.qFG) {
                this.rfN.mo25437j(baseViewHolder.position, baseViewHolder.cwT, 1);
            }
            if (this.rfO != null) {
                this.rfO.mo25498XJ(baseViewHolder.cwT);
            }
            if (this.rfP != null) {
                this.rfP.mo37368a(baseViewHolder.position, baseViewHolder.cwT, baseViewHolder.rHt, baseViewHolder.timeLineObject, baseViewHolder.qFG);
            }
            if (baseViewHolder.timeLineObject.xfI.wbJ == 3) {
                C46236n YS = C13373af.cnF().mo62917YS(baseViewHolder.cFc);
                int cre = YS == null ? 0 : YS.cre();
                C1876a c1876a = C1876a.Sns;
                String str3 = baseViewHolder.timeLineObject.rjC;
                String jV = C29036i.m46117jV(baseViewHolder.rHt);
                if (!C5046bo.isNullOrNil(str3)) {
                    byte[] bArr = new byte[0];
                    try {
                        bArr = Base64.decode(str3, 0);
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.SnsStatExtUtil", e, null, new Object[0]);
                    }
                    cdg cdg = new cdg();
                    try {
                        cdg.parseFrom(bArr);
                        if (cdg.xcS == null) {
                            str = str2;
                        } else {
                            C4990ab.m7417i("MicroMsg.SnsStatExtUtil", "report adPageExposure(13235): scene(%d), statExtStr:%s(id=%s, uxinfo=%s)", Integer.valueOf(c1876a.value), str3, cdg.xcS.xcV, cdg.xcS.xcW);
                            ((C13356c) C1720g.m3528K(C13356c.class)).mo25461a(13235, cre, c1876a.value, cdg.xcS.xcV, cdg.xcS.xcW, jV);
                        }
                    } catch (Exception e2) {
                        C4990ab.printErrStackTrace("MicroMsg.SnsStatExtUtil", e2, "", new Object[0]);
                        str = str2;
                    }
                }
            }
            str = str2;
        }
        if (C1947ae.giZ) {
            C4990ab.m7410d("MicroMsg.AdListView", "5childview  onViewRemoved " + str + " count:" + getChildCount());
        }
        AppMethodBeat.m2505o(38061);
    }

    public void removeViewInLayout(View view) {
        AppMethodBeat.m2504i(38062);
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof BaseViewHolder)) {
            BaseViewHolder baseViewHolder = (BaseViewHolder) view.getTag();
            str = baseViewHolder.position + " " + baseViewHolder.cwT;
        }
        if (C1947ae.giZ) {
            C4990ab.m7410d("MicroMsg.AdListView", "6removeViewInLayout  onViewRemoved " + str + " count:" + getChildCount());
        }
        super.removeViewInLayout(view);
        AppMethodBeat.m2505o(38062);
    }

    public void removeView(View view) {
        AppMethodBeat.m2504i(38063);
        super.removeView(view);
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof BaseViewHolder)) {
            BaseViewHolder baseViewHolder = (BaseViewHolder) view.getTag();
            str = baseViewHolder.position + " " + baseViewHolder.cwT;
        }
        if (C1947ae.giZ) {
            C4990ab.m7410d("MicroMsg.AdListView", "7removeView  onViewRemoved " + str + " count:" + getChildCount());
        }
        AppMethodBeat.m2505o(38063);
    }

    /* Access modifiers changed, original: protected */
    public void detachViewsFromParent(int i, int i2) {
        AppMethodBeat.m2504i(38064);
        for (int i3 = i; i3 < i + i2; i3++) {
            View childAt = getChildAt(i3);
            String str = "";
            if (childAt.getTag() != null && (childAt.getTag() instanceof BaseViewHolder)) {
                BaseViewHolder baseViewHolder = (BaseViewHolder) childAt.getTag();
                if (this.rfN != null && baseViewHolder.qFG) {
                    this.rfN.mo25437j(baseViewHolder.position, baseViewHolder.cwT, 1);
                }
                if (this.rfO != null) {
                    this.rfO.mo25498XJ(baseViewHolder.cwT);
                }
                if (this.rfP != null) {
                    this.rfP.mo37368a(baseViewHolder.position, baseViewHolder.cwT, baseViewHolder.rHt, baseViewHolder.timeLineObject, baseViewHolder.qFG);
                }
                str = baseViewHolder.position + " " + baseViewHolder.cwT;
            }
            if (C1947ae.giZ) {
                C4990ab.m7410d("MicroMsg.AdListView", "8removeView  detachViewsFromParent " + str + " count:" + getChildCount());
            }
        }
        super.detachViewsFromParent(i, i2);
        AppMethodBeat.m2505o(38064);
    }
}
