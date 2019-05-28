package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelstat.p.a;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.a.b.b;
import com.tencent.mm.plugin.sns.a.b.j;
import com.tencent.mm.plugin.sns.b.c;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.e;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.protocal.protobuf.cdg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;

public class AdListView extends ListView {
    b rfN;
    f rfO;
    private e rfP;
    private boolean rfQ = true;
    private HashSet<String> rfR = new HashSet();

    public AdListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(38053);
        AppMethodBeat.o(38053);
    }

    public AdListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(38054);
        AppMethodBeat.o(38054);
    }

    public void setTimelineStat(f fVar) {
        this.rfO = fVar;
    }

    public void setTimelineEvent(e eVar) {
        this.rfP = eVar;
    }

    /* Access modifiers changed, original: protected */
    public void layoutChildren() {
        AppMethodBeat.i(38055);
        super.layoutChildren();
        AppMethodBeat.o(38055);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(38056);
        super.onLayout(z, i, i2, i3, i4);
        AppMethodBeat.o(38056);
    }

    /* Access modifiers changed, original: protected */
    public void detachViewFromParent(View view) {
        AppMethodBeat.i(38057);
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof BaseViewHolder)) {
            BaseViewHolder baseViewHolder = (BaseViewHolder) view.getTag();
            str = baseViewHolder.position + " " + baseViewHolder.cwT;
        }
        if (ae.giZ) {
            ab.d("MicroMsg.AdListView", "1childview  onRemoved " + str + " count:" + getChildCount());
        }
        super.detachViewFromParent(view);
        AppMethodBeat.o(38057);
    }

    /* Access modifiers changed, original: protected */
    public void detachViewFromParent(int i) {
        AppMethodBeat.i(38058);
        if (ae.giZ) {
            ab.d("MicroMsg.AdListView", "2childview  onRemoved " + i + " count:" + getChildCount());
        }
        super.detachViewFromParent(i);
        AppMethodBeat.o(38058);
    }

    /* Access modifiers changed, original: protected */
    public void attachViewToParent(View view, int i, LayoutParams layoutParams) {
        AppMethodBeat.i(38059);
        super.attachViewToParent(view, i, layoutParams);
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof BaseViewHolder)) {
            BaseViewHolder baseViewHolder = (BaseViewHolder) view.getTag();
            String str2 = baseViewHolder.position + " " + baseViewHolder.cwT;
            boolean z = baseViewHolder.timeLineObject.xfP == 1 || baseViewHolder.timeLineObject.dtW == 1;
            com.tencent.mm.plugin.sns.i.e.qTd.bl(baseViewHolder.timeLineObject.Id, z);
            com.tencent.mm.plugin.sns.i.e.qTd.gh(baseViewHolder.timeLineObject.Id, baseViewHolder.timeLineObject.xfH == null ? "" : baseViewHolder.timeLineObject.xfH.Id);
            com.tencent.mm.plugin.sns.i.e.qTd.kr(baseViewHolder.rHt);
            if (this.rfN != null && baseViewHolder.qFG) {
                this.rfN.a(baseViewHolder.position, baseViewHolder.cwT, baseViewHolder.mVC, view, baseViewHolder.rHt, baseViewHolder.qCX, baseViewHolder.klY, 1);
            }
            if (!this.rfR.contains(baseViewHolder.cFc) && ((baseViewHolder.qFG && baseViewHolder.timeLineObject.xfI.wbJ == 15) || baseViewHolder.timeLineObject.xfI.wbJ == 18)) {
                z = false;
                if (baseViewHolder.timeLineObject.xfI.wbJ == 15 && (baseViewHolder.rGD.qzM instanceof SightPlayImageView)) {
                    z = ((SightPlayImageView) baseViewHolder.rGD.qzM).qyA.cla();
                }
                j.a(af.cnF().YS(baseViewHolder.cFc), false, z, 0);
                this.rfR.add(baseViewHolder.cFc);
            }
            if (this.rfO != null) {
                this.rfO.a(baseViewHolder.cwT, baseViewHolder.timeLineObject);
            }
            if (this.rfP != null) {
                this.rfP.a(baseViewHolder.position, baseViewHolder.cwT, baseViewHolder.rHt, baseViewHolder.timeLineObject, baseViewHolder.qFG, baseViewHolder.qFH);
            }
            str = str2;
        }
        if (ae.giZ) {
            ab.d("MicroMsg.AdListView", "3childview  onAdded " + str + " count:" + getChildCount());
        }
        AppMethodBeat.o(38059);
    }

    public void onViewAdded(View view) {
        AppMethodBeat.i(38060);
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof BaseViewHolder)) {
            BaseViewHolder baseViewHolder = (BaseViewHolder) view.getTag();
            String str2 = baseViewHolder.position + " " + baseViewHolder.cwT;
            boolean z = baseViewHolder.timeLineObject.xfP == 1 || baseViewHolder.timeLineObject.dtW == 1;
            com.tencent.mm.plugin.sns.i.e.qTd.bl(baseViewHolder.timeLineObject.Id, z);
            com.tencent.mm.plugin.sns.i.e.qTd.gh(baseViewHolder.timeLineObject.Id, baseViewHolder.timeLineObject.xfH == null ? "" : baseViewHolder.timeLineObject.xfH.Id);
            com.tencent.mm.plugin.sns.i.e.qTd.kr(baseViewHolder.rHt);
            if (this.rfN != null && baseViewHolder.qFG) {
                this.rfN.a(baseViewHolder.position, baseViewHolder.cwT, baseViewHolder.mVC, view, baseViewHolder.rHt, baseViewHolder.qCX, baseViewHolder.klY, 1);
            }
            if (!this.rfR.contains(baseViewHolder.cFc) && ((baseViewHolder.qFG && baseViewHolder.timeLineObject.xfI.wbJ == 15) || baseViewHolder.timeLineObject.xfI.wbJ == 18)) {
                z = false;
                if (baseViewHolder.timeLineObject.xfI.wbJ == 15 && (baseViewHolder.rGD.qzM instanceof SightPlayImageView)) {
                    z = ((SightPlayImageView) baseViewHolder.rGD.qzM).qyA.cla();
                }
                j.a(af.cnF().YS(baseViewHolder.cFc), false, z, 0);
                this.rfR.add(baseViewHolder.cFc);
            }
            if (this.rfO != null) {
                this.rfO.a(baseViewHolder.cwT, baseViewHolder.timeLineObject);
            }
            if (this.rfP != null) {
                this.rfP.a(baseViewHolder.position, baseViewHolder.cwT, baseViewHolder.rHt, baseViewHolder.timeLineObject, baseViewHolder.qFG, baseViewHolder.qFH);
            }
            str = str2;
        }
        if (ae.giZ) {
            ab.d("MicroMsg.AdListView", "4childview  onViewAdded " + str + " count:" + getChildCount());
        }
        AppMethodBeat.o(38060);
    }

    public void onViewRemoved(View view) {
        AppMethodBeat.i(38061);
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof BaseViewHolder)) {
            BaseViewHolder baseViewHolder = (BaseViewHolder) view.getTag();
            String str2 = baseViewHolder.position + " " + baseViewHolder.cwT;
            if (this.rfN != null && baseViewHolder.qFG) {
                this.rfN.j(baseViewHolder.position, baseViewHolder.cwT, 1);
            }
            if (this.rfO != null) {
                this.rfO.XJ(baseViewHolder.cwT);
            }
            if (this.rfP != null) {
                this.rfP.a(baseViewHolder.position, baseViewHolder.cwT, baseViewHolder.rHt, baseViewHolder.timeLineObject, baseViewHolder.qFG);
            }
            if (baseViewHolder.timeLineObject.xfI.wbJ == 3) {
                n YS = af.cnF().YS(baseViewHolder.cFc);
                int cre = YS == null ? 0 : YS.cre();
                a aVar = a.Sns;
                String str3 = baseViewHolder.timeLineObject.rjC;
                String jV = i.jV(baseViewHolder.rHt);
                if (!bo.isNullOrNil(str3)) {
                    byte[] bArr = new byte[0];
                    try {
                        bArr = Base64.decode(str3, 0);
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.SnsStatExtUtil", e, null, new Object[0]);
                    }
                    cdg cdg = new cdg();
                    try {
                        cdg.parseFrom(bArr);
                        if (cdg.xcS == null) {
                            str = str2;
                        } else {
                            ab.i("MicroMsg.SnsStatExtUtil", "report adPageExposure(13235): scene(%d), statExtStr:%s(id=%s, uxinfo=%s)", Integer.valueOf(aVar.value), str3, cdg.xcS.xcV, cdg.xcS.xcW);
                            ((c) g.K(c.class)).a(13235, cre, aVar.value, cdg.xcS.xcV, cdg.xcS.xcW, jV);
                        }
                    } catch (Exception e2) {
                        ab.printErrStackTrace("MicroMsg.SnsStatExtUtil", e2, "", new Object[0]);
                        str = str2;
                    }
                }
            }
            str = str2;
        }
        if (ae.giZ) {
            ab.d("MicroMsg.AdListView", "5childview  onViewRemoved " + str + " count:" + getChildCount());
        }
        AppMethodBeat.o(38061);
    }

    public void removeViewInLayout(View view) {
        AppMethodBeat.i(38062);
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof BaseViewHolder)) {
            BaseViewHolder baseViewHolder = (BaseViewHolder) view.getTag();
            str = baseViewHolder.position + " " + baseViewHolder.cwT;
        }
        if (ae.giZ) {
            ab.d("MicroMsg.AdListView", "6removeViewInLayout  onViewRemoved " + str + " count:" + getChildCount());
        }
        super.removeViewInLayout(view);
        AppMethodBeat.o(38062);
    }

    public void removeView(View view) {
        AppMethodBeat.i(38063);
        super.removeView(view);
        String str = "";
        if (view.getTag() != null && (view.getTag() instanceof BaseViewHolder)) {
            BaseViewHolder baseViewHolder = (BaseViewHolder) view.getTag();
            str = baseViewHolder.position + " " + baseViewHolder.cwT;
        }
        if (ae.giZ) {
            ab.d("MicroMsg.AdListView", "7removeView  onViewRemoved " + str + " count:" + getChildCount());
        }
        AppMethodBeat.o(38063);
    }

    /* Access modifiers changed, original: protected */
    public void detachViewsFromParent(int i, int i2) {
        AppMethodBeat.i(38064);
        for (int i3 = i; i3 < i + i2; i3++) {
            View childAt = getChildAt(i3);
            String str = "";
            if (childAt.getTag() != null && (childAt.getTag() instanceof BaseViewHolder)) {
                BaseViewHolder baseViewHolder = (BaseViewHolder) childAt.getTag();
                if (this.rfN != null && baseViewHolder.qFG) {
                    this.rfN.j(baseViewHolder.position, baseViewHolder.cwT, 1);
                }
                if (this.rfO != null) {
                    this.rfO.XJ(baseViewHolder.cwT);
                }
                if (this.rfP != null) {
                    this.rfP.a(baseViewHolder.position, baseViewHolder.cwT, baseViewHolder.rHt, baseViewHolder.timeLineObject, baseViewHolder.qFG);
                }
                str = baseViewHolder.position + " " + baseViewHolder.cwT;
            }
            if (ae.giZ) {
                ab.d("MicroMsg.AdListView", "8removeView  detachViewsFromParent " + str + " count:" + getChildCount());
            }
        }
        super.detachViewsFromParent(i, i2);
        AppMethodBeat.o(38064);
    }
}
