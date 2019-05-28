package com.tencent.mm.plugin.card.ui.v2;

import a.f.b.j;
import a.k.u;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bih;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

@l(dWo = {1, 1, 13}, dWp = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 42\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00014B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH\u0016J\u0010\u0010\"\u001a\u0004\u0018\u00010\n2\u0006\u0010!\u001a\u00020\u001fJ\u000e\u0010#\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%J\u000e\u0010&\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%J\u000e\u0010'\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%J\u0016\u0010(\u001a\u00020\u001f2\u0006\u0010$\u001a\u00020%2\u0006\u0010)\u001a\u00020\u001fJ\u0018\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u001fH\u0016J\u0018\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u001fH\u0016J\u000e\u00101\u001a\u00020+2\u0006\u0010$\u001a\u00020%J\u000e\u0010\u0016\u001a\u00020+2\u0006\u00102\u001a\u00020%JZ\u00103\u001a\u00020+2\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b2\u001a\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b2\u001a\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bJ\u000e\u0010\u001d\u001a\u00020+2\u0006\u00102\u001a\u00020%R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u0007\u0010\u0005R.\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR.\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R.\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000fR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017¨\u00065"}, dWq = {"Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketVH;", "isInvalid", "", "(Z)V", "()Z", "setInvalid", "jumpList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "Lkotlin/collections/ArrayList;", "getJumpList", "()Ljava/util/ArrayList;", "setJumpList", "(Ljava/util/ArrayList;)V", "licenseList", "getLicenseList", "setLicenseList", "licenseTitle", "getLicenseTitle", "()Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;", "setLicenseTitle", "(Lcom/tencent/mm/plugin/card/ui/v2/CardTicketListModel;)V", "ticketList", "getTicketList", "setTicketList", "ticketTitle", "getTicketTitle", "setTicketTitle", "getItemCount", "", "getItemViewType", "position", "getModelByPos", "getPosByCardId", "cardId", "", "getPosInLicenseListByCardId", "getPosInTicketListByCardId", "getRelativePosByType", "cardType", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "removeModelByCardId", "title", "setModelList", "Companion", "plugin-card_release"})
public final class c extends android.support.v7.widget.RecyclerView.a<f> {
    public static final a kqc = new a();
    private ArrayList<d> kpW;
    private ArrayList<d> kpX;
    private ArrayList<d> kpY;
    private d kpZ;
    private d kqa;
    private boolean kqb;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/card/ui/v2/CardTicketAdapter$Companion;", "", "()V", "LIST_ITEM_CARD", "", "LIST_ITEM_TICKET_ENTRANCE", "LIST_ITEM_TITLE", "TAG", "", "plugin-card_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(89297);
        AppMethodBeat.o(89297);
    }

    public /* synthetic */ c() {
        this(false);
    }

    public c(boolean z) {
        this.kqb = z;
    }

    public final int getItemViewType(int i) {
        AppMethodBeat.i(89289);
        d tl = tl(i);
        if (tl != null) {
            int i2 = tl.type;
            AppMethodBeat.o(89289);
            return i2;
        }
        AppMethodBeat.o(89289);
        return -1;
    }

    public final int getItemCount() {
        AppMethodBeat.i(89290);
        int i = 0;
        if (this.kpZ != null) {
            i = 1;
        }
        ArrayList arrayList = this.kpY;
        if (arrayList != null) {
            i += arrayList.size();
        }
        arrayList = this.kpW;
        if (arrayList != null) {
            i += arrayList.size();
        }
        if (this.kqa != null) {
            i++;
        }
        arrayList = this.kpX;
        if (arrayList != null) {
            i += arrayList.size();
        }
        AppMethodBeat.o(89290);
        return i;
    }

    public final d tl(int i) {
        d dVar;
        AppMethodBeat.i(89291);
        String str = "MicroMsg.CardTicketAdapter";
        String str2 = "pos: %s, jSize: %s, tSize: %s, lSize: %s";
        Object[] objArr = new Object[4];
        objArr[0] = Integer.valueOf(i);
        ArrayList arrayList = this.kpY;
        objArr[1] = arrayList != null ? Integer.valueOf(arrayList.size()) : null;
        arrayList = this.kpW;
        objArr[2] = arrayList != null ? Integer.valueOf(arrayList.size()) : null;
        arrayList = this.kpX;
        objArr[3] = arrayList != null ? Integer.valueOf(arrayList.size()) : null;
        ab.d(str, str2, objArr);
        int i2 = -1;
        if (this.kpZ != null) {
            if (i == 0) {
                dVar = this.kpZ;
                AppMethodBeat.o(89291);
                return dVar;
            }
            i2 = 0;
        }
        ArrayList arrayList2 = this.kpY;
        if (arrayList2 != null) {
            if (i <= i2 || i > arrayList2.size() + i2) {
                i2 += arrayList2.size();
            } else {
                dVar = (d) arrayList2.get((i - i2) - 1);
                AppMethodBeat.o(89291);
                return dVar;
            }
        }
        arrayList2 = this.kpW;
        if (arrayList2 != null) {
            if (i <= i2 || i > arrayList2.size() + i2) {
                i2 += arrayList2.size();
            } else {
                dVar = (d) arrayList2.get((i - i2) - 1);
                AppMethodBeat.o(89291);
                return dVar;
            }
        }
        if (this.kqa != null) {
            i2++;
            if (i == i2) {
                dVar = this.kqa;
                AppMethodBeat.o(89291);
                return dVar;
            }
        }
        arrayList2 = this.kpX;
        if (arrayList2 == null || i <= i2 || i > arrayList2.size() + i2) {
            AppMethodBeat.o(89291);
            return null;
        }
        dVar = (d) arrayList2.get((i - i2) - 1);
        AppMethodBeat.o(89291);
        return dVar;
    }

    public final int bO(String str, int i) {
        AppMethodBeat.i(89292);
        j.p(str, "cardId");
        int size;
        ArrayList<d> arrayList;
        bih bih;
        switch (i) {
            case 1:
                j.p(str, "cardId");
                ArrayList arrayList2 = this.kpY;
                if (arrayList2 != null) {
                    size = arrayList2.size() + 0;
                } else {
                    size = 0;
                }
                arrayList = this.kpW;
                if (arrayList != null) {
                    int i2 = 0;
                    for (d dVar : arrayList) {
                        Object obj;
                        bih = dVar.kqe;
                        if (bih != null) {
                            obj = bih.vCb;
                        } else {
                            obj = null;
                        }
                        if (j.j(obj, str)) {
                            int i3 = i2 + size;
                            AppMethodBeat.o(89292);
                            return i3;
                        }
                        i2++;
                    }
                }
                AppMethodBeat.o(89292);
                return 0;
            default:
                j.p(str, "cardId");
                arrayList = this.kpX;
                if (arrayList != null) {
                    size = 0;
                    for (d dVar2 : arrayList) {
                        bih = dVar2.kqe;
                        if (j.j(bih != null ? bih.vCb : null, str)) {
                            AppMethodBeat.o(89292);
                            return size;
                        }
                        size++;
                    }
                }
                AppMethodBeat.o(89292);
                return 0;
        }
    }

    /* JADX WARNING: Missing block: B:24:0x0072, code skipped:
            if (r0.isEmpty() != false) goto L_0x0074;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void GZ(String str) {
        int i;
        int size;
        int i2;
        bih bih;
        String str2;
        AppMethodBeat.i(89293);
        j.p(str, "cardId");
        if (this.kpZ != null) {
            i = 1;
        } else {
            i = 0;
        }
        ArrayList arrayList = this.kpY;
        if (arrayList != null) {
            size = i + arrayList.size();
        } else {
            size = i;
        }
        ArrayList<d> arrayList2 = this.kpW;
        if (arrayList2 != null) {
            i2 = 0;
            for (d dVar : arrayList2) {
                bih = dVar.kqe;
                if (bih != null) {
                    str2 = bih.vCb;
                } else {
                    str2 = null;
                }
                if (u.I(str2, str, false)) {
                    arrayList2.remove(dVar);
                    ab.d("MicroMsg.CardTicketAdapter", "remove ticket: %s, %s", Integer.valueOf(i2), Integer.valueOf(size));
                    if (arrayList2.isEmpty()) {
                        if (this.kpY != null) {
                            ArrayList arrayList3 = this.kpY;
                            if (arrayList3 == null) {
                                j.dWJ();
                            }
                        }
                        this.kpZ = null;
                    }
                    notifyDataSetChanged();
                    AppMethodBeat.o(89293);
                    return;
                }
                i2++;
            }
            size += arrayList2.size();
        }
        if (this.kqa != null) {
            size++;
        }
        arrayList2 = this.kpX;
        if (arrayList2 != null) {
            i2 = 0;
            for (d dVar2 : arrayList2) {
                bih = dVar2.kqe;
                if (bih != null) {
                    str2 = bih.vCb;
                } else {
                    str2 = null;
                }
                if (u.I(str2, str, false)) {
                    arrayList2.remove(dVar2);
                    ab.d("MicroMsg.CardTicketAdapter", "remove license: %s, %s", Integer.valueOf(i2), Integer.valueOf(size));
                    if (arrayList2.isEmpty()) {
                        this.kqa = null;
                    }
                    notifyDataSetChanged();
                    AppMethodBeat.o(89293);
                    return;
                }
                i2++;
            }
            AppMethodBeat.o(89293);
            return;
        }
        AppMethodBeat.o(89293);
    }

    public final void a(ArrayList<d> arrayList, ArrayList<d> arrayList2, ArrayList<d> arrayList3) {
        AppMethodBeat.i(89294);
        this.kpY = arrayList;
        this.kpW = arrayList2;
        this.kpX = arrayList3;
        notifyDataSetChanged();
        AppMethodBeat.o(89294);
    }

    public final void Ha(String str) {
        AppMethodBeat.i(89295);
        j.p(str, "title");
        if (bo.isNullOrNil(str)) {
            this.kpZ = null;
            AppMethodBeat.o(89295);
            return;
        }
        d dVar;
        if (this.kpZ == null) {
            this.kpZ = new d();
            dVar = this.kpZ;
            if (dVar == null) {
                j.dWJ();
            }
            dVar.type = 0;
        }
        dVar = this.kpZ;
        if (dVar == null) {
            j.dWJ();
        }
        dVar.title = str;
        AppMethodBeat.o(89295);
    }

    public final void Hb(String str) {
        AppMethodBeat.i(89296);
        j.p(str, "title");
        if (bo.isNullOrNil(str)) {
            this.kqa = null;
            AppMethodBeat.o(89296);
            return;
        }
        d dVar;
        if (this.kqa == null) {
            this.kqa = new d();
            dVar = this.kqa;
            if (dVar == null) {
                j.dWJ();
            }
            dVar.type = 0;
        }
        dVar = this.kqa;
        if (dVar == null) {
            j.dWJ();
        }
        dVar.title = str;
        AppMethodBeat.o(89296);
    }
}
