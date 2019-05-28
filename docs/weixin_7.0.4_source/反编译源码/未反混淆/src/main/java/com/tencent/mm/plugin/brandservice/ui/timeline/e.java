package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.l;
import com.tencent.mm.aj.z;
import com.tencent.mm.model.s;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.r.b;
import com.tencent.mm.storage.r.c;
import com.tencent.mm.storage.t;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.List;

public final class e extends BaseAdapter {
    private int emC;
    List<q> iKa;
    c jKp = new c() {
        public final void a(Object obj, com.tencent.mm.storage.r.a aVar) {
            AppMethodBeat.i(14147);
            if (aVar != null) {
                if (aVar.xId == b.INSERT && aVar.jOa != null) {
                    e.this.iKa.add(0, aVar.jOa);
                } else if (aVar.xId == b.DELETE) {
                    e eVar = e.this;
                    q aWp = eVar.aWp();
                    if (aWp != null) {
                        eVar.iKa.clear();
                        List list = eVar.iKa;
                        t aeY = z.aeY();
                        long j = aWp.field_createTime;
                        list.addAll(t.p(aeY.fni.query("BizTimeLineSingleMsgInfo", null, "createTime>=?", new String[]{String.valueOf(j)}, null, null, "createTime DESC")));
                    }
                }
            }
            e.this.notifyDataSetChanged();
            AppMethodBeat.o(14147);
        }
    };
    boolean jNE = false;
    private BizTimeLineNewMsgUI jNS;
    boolean jNT = false;

    static class a {
        ImageView eks;
        TextView gne;
        TextView gtO;
        View iLS;
        TextView timeTv;

        a() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(14155);
        q sg = sg(i);
        AppMethodBeat.o(14155);
        return sg;
    }

    public e(BizTimeLineNewMsgUI bizTimeLineNewMsgUI, List<q> list, int i) {
        AppMethodBeat.i(14149);
        this.jNS = bizTimeLineNewMsgUI;
        z.aeY().a(this.jKp, Looper.getMainLooper());
        this.iKa = list;
        this.emC = i;
        AppMethodBeat.o(14149);
    }

    public final int getCount() {
        AppMethodBeat.i(14150);
        int size = this.iKa.size();
        AppMethodBeat.o(14150);
        return size;
    }

    public final q sg(int i) {
        AppMethodBeat.i(14151);
        if (i < this.iKa.size()) {
            q qVar = (q) this.iKa.get(i);
            AppMethodBeat.o(14151);
            return qVar;
        }
        AppMethodBeat.o(14151);
        return null;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(14152);
        q sg = sg(i);
        if (sg == null) {
            ab.e("MicroMsg.BizTimeLineAdapter", "getView info is null");
            AppMethodBeat.o(14152);
        } else {
            a aVar;
            if (view == null) {
                a aVar2 = new a();
                view = View.inflate(this.jNS, R.layout.h8, null);
                aVar2.eks = (ImageView) view.findViewById(R.id.qk);
                aVar2.gtO = (TextView) view.findViewById(R.id.a76);
                aVar2.timeTv = (TextView) view.findViewById(R.id.la);
                aVar2.gne = (TextView) view.findViewById(R.id.qm);
                aVar2.iLS = view.findViewById(R.id.a77);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            com.tencent.mm.pluginsdk.ui.a.b.b(aVar.eks, sg.field_talker);
            aVar.gtO.setText(j.b(this.jNS, s.mJ(sg.field_talker), aVar.gtO.getTextSize()));
            aVar.timeTv.setText(com.tencent.mm.plugin.brandservice.ui.b.b.e(this.jNS, sg.field_createTime));
            if (sg.drC()) {
                aVar.gne.setText(l.mi(sg.field_content));
            } else {
                if (!sg.isText()) {
                    int i2;
                    if (sg.field_type == Downloads.MIN_WAIT_FOR_NETWORK) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    if (i2 == 0) {
                        if (sg.drE()) {
                            aVar.gne.setText(this.jNS.getString(R.string.sn));
                        } else if (sg.drD()) {
                            aVar.gne.setText(this.jNS.getString(R.string.ug));
                        } else {
                            if (sg.field_type == 43) {
                                i2 = 1;
                            } else {
                                i2 = 0;
                            }
                            if (i2 != 0) {
                                aVar.gne.setText(this.jNS.getString(R.string.ud));
                            } else {
                                if (sg.field_type == 42 || sg.field_type == 66) {
                                    i2 = 1;
                                } else {
                                    i2 = 0;
                                }
                                if (i2 != 0) {
                                    aVar.gne.setText(this.jNS.getString(R.string.su));
                                } else {
                                    if ((sg.field_type & CdnLogic.kBizGeneric) == 49) {
                                        i2 = 1;
                                    } else {
                                        i2 = 0;
                                    }
                                    if (i2 != 0) {
                                        com.tencent.mm.af.j.b me = com.tencent.mm.af.j.b.me(sg.field_content);
                                        if (me != null) {
                                            CharSequence charSequence = "";
                                            switch (me.type) {
                                                case 1:
                                                    charSequence = me.title;
                                                    break;
                                                case 2:
                                                    charSequence = this.jNS.getString(R.string.sn);
                                                    break;
                                                case 3:
                                                    charSequence = this.jNS.getString(R.string.rs) + me.title;
                                                    break;
                                                case 4:
                                                    charSequence = this.jNS.getString(R.string.ud) + me.title;
                                                    break;
                                                case 5:
                                                    charSequence = this.jNS.getString(R.string.u9) + me.getTitle();
                                                    break;
                                                case 16:
                                                    charSequence = this.jNS.getString(R.string.su) + me.getTitle();
                                                    break;
                                                case 2001:
                                                case 436207665:
                                                case 469762097:
                                                    charSequence = "[" + me.fhW + "]" + me.fhS;
                                                    break;
                                            }
                                            if (bo.isNullOrNil(charSequence)) {
                                                charSequence = me.getTitle();
                                            }
                                            aVar.gne.setText(j.b(this.jNS, charSequence, aVar.gne.getTextSize()));
                                        }
                                    }
                                    aVar.gne.setText(this.jNS.getString(R.string.a_3));
                                }
                            }
                        }
                    }
                }
                aVar.gne.setText(j.a(this.jNS, sg.field_content, (int) aVar.gne.getTextSize()));
            }
            if (i == getCount() - 1) {
                aVar.iLS.setVisibility(4);
            } else {
                aVar.iLS.setVisibility(0);
            }
            sh(i);
            AppMethodBeat.o(14152);
        }
        return view;
    }

    public final q aWp() {
        AppMethodBeat.i(14153);
        if (this.iKa.size() > 0) {
            q qVar = (q) this.iKa.get(this.iKa.size() - 1);
            AppMethodBeat.o(14153);
            return qVar;
        }
        AppMethodBeat.o(14153);
        return null;
    }

    public final void sh(final int i) {
        AppMethodBeat.i(14154);
        if (this.emC != 1 || this.jNT) {
            if (i == getCount() - 1 && !this.jNE) {
                al.n(new Runnable() {
                    /* JADX WARNING: Removed duplicated region for block: B:10:0x0076  */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void run() {
                        AppMethodBeat.i(14148);
                        if (i == e.this.getCount() - 1 && !e.this.jNE) {
                            int i;
                            ab.i("MicroMsg.BizTimeLineAdapter", "loadMoreData %d/%d", Integer.valueOf(i), Integer.valueOf(e.this.getCount()));
                            e eVar = e.this;
                            q aWp = eVar.aWp();
                            if (aWp != null) {
                                t aeY = z.aeY();
                                long j = aWp.field_createTime;
                                List p = t.p(aeY.fni.query("BizTimeLineSingleMsgInfo", null, "createTime<?", new String[]{String.valueOf(j)}, null, null, "createTime DESC limit 20"));
                                eVar.iKa.addAll(p);
                                eVar.notifyDataSetChanged();
                                if (p.size() > 0) {
                                    i = 1;
                                    if (i == 0) {
                                        e.this.jNE = true;
                                        BizTimeLineNewMsgUI b = e.this.jNS;
                                        if (b.jNV != null) {
                                            b.jNW.setVisibility(8);
                                            b.jNX.setText(b.getString(R.string.a_a));
                                        }
                                    }
                                }
                            }
                            i = 0;
                            if (i == 0) {
                            }
                        }
                        AppMethodBeat.o(14148);
                    }
                }, 300);
            }
            AppMethodBeat.o(14154);
            return;
        }
        AppMethodBeat.o(14154);
    }
}
