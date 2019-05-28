package com.tencent.p177mm.plugin.brandservice.p349ui.timeline;

import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.p181af.C1192l;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p184aj.C41747z;
import com.tencent.p177mm.plugin.brandservice.p349ui.p1242b.C42809b;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C23522t;
import com.tencent.p177mm.storage.C40635r.C40633a;
import com.tencent.p177mm.storage.C40635r.C40634c;
import com.tencent.p177mm.storage.C40635r.C40639b;
import com.tencent.p177mm.storage.C46627q;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.e */
public final class C27524e extends BaseAdapter {
    private int emC;
    List<C46627q> iKa;
    C40634c jKp = new C112421();
    boolean jNE = false;
    private BizTimeLineNewMsgUI jNS;
    boolean jNT = false;

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.e$1 */
    class C112421 implements C40634c {
        C112421() {
        }

        /* renamed from: a */
        public final void mo22929a(Object obj, C40633a c40633a) {
            AppMethodBeat.m2504i(14147);
            if (c40633a != null) {
                if (c40633a.xId == C40639b.INSERT && c40633a.jOa != null) {
                    C27524e.this.iKa.add(0, c40633a.jOa);
                } else if (c40633a.xId == C40639b.DELETE) {
                    C27524e c27524e = C27524e.this;
                    C46627q aWp = c27524e.aWp();
                    if (aWp != null) {
                        c27524e.iKa.clear();
                        List list = c27524e.iKa;
                        C23522t aeY = C41747z.aeY();
                        long j = aWp.field_createTime;
                        list.addAll(C23522t.m36351p(aeY.fni.query("BizTimeLineSingleMsgInfo", null, "createTime>=?", new String[]{String.valueOf(j)}, null, null, "createTime DESC")));
                    }
                }
            }
            C27524e.this.notifyDataSetChanged();
            AppMethodBeat.m2505o(14147);
        }
    }

    /* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.e$a */
    static class C27526a {
        ImageView eks;
        TextView gne;
        TextView gtO;
        View iLS;
        TextView timeTv;

        C27526a() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(14155);
        C46627q sg = mo45320sg(i);
        AppMethodBeat.m2505o(14155);
        return sg;
    }

    public C27524e(BizTimeLineNewMsgUI bizTimeLineNewMsgUI, List<C46627q> list, int i) {
        AppMethodBeat.m2504i(14149);
        this.jNS = bizTimeLineNewMsgUI;
        C41747z.aeY().mo39191a(this.jKp, Looper.getMainLooper());
        this.iKa = list;
        this.emC = i;
        AppMethodBeat.m2505o(14149);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(14150);
        int size = this.iKa.size();
        AppMethodBeat.m2505o(14150);
        return size;
    }

    /* renamed from: sg */
    public final C46627q mo45320sg(int i) {
        AppMethodBeat.m2504i(14151);
        if (i < this.iKa.size()) {
            C46627q c46627q = (C46627q) this.iKa.get(i);
            AppMethodBeat.m2505o(14151);
            return c46627q;
        }
        AppMethodBeat.m2505o(14151);
        return null;
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(14152);
        C46627q sg = mo45320sg(i);
        if (sg == null) {
            C4990ab.m7412e("MicroMsg.BizTimeLineAdapter", "getView info is null");
            AppMethodBeat.m2505o(14152);
        } else {
            C27526a c27526a;
            if (view == null) {
                C27526a c27526a2 = new C27526a();
                view = View.inflate(this.jNS, 2130968869, null);
                c27526a2.eks = (ImageView) view.findViewById(2131821183);
                c27526a2.gtO = (TextView) view.findViewById(2131821809);
                c27526a2.timeTv = (TextView) view.findViewById(2131820988);
                c27526a2.gne = (TextView) view.findViewById(2131821185);
                c27526a2.iLS = view.findViewById(2131821810);
                view.setTag(c27526a2);
                c27526a = c27526a2;
            } else {
                c27526a = (C27526a) view.getTag();
            }
            C40460b.m69434b(c27526a.eks, sg.field_talker);
            c27526a.gtO.setText(C44089j.m79293b(this.jNS, C1854s.m3866mJ(sg.field_talker), c27526a.gtO.getTextSize()));
            c27526a.timeTv.setText(C42809b.m75917e(this.jNS, sg.field_createTime));
            if (sg.drC()) {
                c27526a.gne.setText(C1192l.m2626mi(sg.field_content));
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
                            c27526a.gne.setText(this.jNS.getString(C25738R.string.f9199sn));
                        } else if (sg.drD()) {
                            c27526a.gne.setText(this.jNS.getString(C25738R.string.f9256ug));
                        } else {
                            if (sg.field_type == 43) {
                                i2 = 1;
                            } else {
                                i2 = 0;
                            }
                            if (i2 != 0) {
                                c27526a.gne.setText(this.jNS.getString(C25738R.string.f9253ud));
                            } else {
                                if (sg.field_type == 42 || sg.field_type == 66) {
                                    i2 = 1;
                                } else {
                                    i2 = 0;
                                }
                                if (i2 != 0) {
                                    c27526a.gne.setText(this.jNS.getString(C25738R.string.f9203su));
                                } else {
                                    if ((sg.field_type & CdnLogic.kBizGeneric) == 49) {
                                        i2 = 1;
                                    } else {
                                        i2 = 0;
                                    }
                                    if (i2 != 0) {
                                        C8910b me = C8910b.m16064me(sg.field_content);
                                        if (me != null) {
                                            CharSequence charSequence = "";
                                            switch (me.type) {
                                                case 1:
                                                    charSequence = me.title;
                                                    break;
                                                case 2:
                                                    charSequence = this.jNS.getString(C25738R.string.f9199sn);
                                                    break;
                                                case 3:
                                                    charSequence = this.jNS.getString(C25738R.string.f9174rs) + me.title;
                                                    break;
                                                case 4:
                                                    charSequence = this.jNS.getString(C25738R.string.f9253ud) + me.title;
                                                    break;
                                                case 5:
                                                    charSequence = this.jNS.getString(C25738R.string.f9248u9) + me.getTitle();
                                                    break;
                                                case 16:
                                                    charSequence = this.jNS.getString(C25738R.string.f9203su) + me.getTitle();
                                                    break;
                                                case 2001:
                                                case 436207665:
                                                case 469762097:
                                                    charSequence = "[" + me.fhW + "]" + me.fhS;
                                                    break;
                                            }
                                            if (C5046bo.isNullOrNil(charSequence)) {
                                                charSequence = me.getTitle();
                                            }
                                            c27526a.gne.setText(C44089j.m79293b(this.jNS, charSequence, c27526a.gne.getTextSize()));
                                        }
                                    }
                                    c27526a.gne.setText(this.jNS.getString(C25738R.string.a_3));
                                }
                            }
                        }
                    }
                }
                c27526a.gne.setText(C44089j.m79282a(this.jNS, sg.field_content, (int) c27526a.gne.getTextSize()));
            }
            if (i == getCount() - 1) {
                c27526a.iLS.setVisibility(4);
            } else {
                c27526a.iLS.setVisibility(0);
            }
            mo45321sh(i);
            AppMethodBeat.m2505o(14152);
        }
        return view;
    }

    public final C46627q aWp() {
        AppMethodBeat.m2504i(14153);
        if (this.iKa.size() > 0) {
            C46627q c46627q = (C46627q) this.iKa.get(this.iKa.size() - 1);
            AppMethodBeat.m2505o(14153);
            return c46627q;
        }
        AppMethodBeat.m2505o(14153);
        return null;
    }

    /* renamed from: sh */
    public final void mo45321sh(final int i) {
        AppMethodBeat.m2504i(14154);
        if (this.emC != 1 || this.jNT) {
            if (i == getCount() - 1 && !this.jNE) {
                C5004al.m7442n(new Runnable() {
                    /* JADX WARNING: Removed duplicated region for block: B:10:0x0076  */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void run() {
                        AppMethodBeat.m2504i(14148);
                        if (i == C27524e.this.getCount() - 1 && !C27524e.this.jNE) {
                            int i;
                            C4990ab.m7417i("MicroMsg.BizTimeLineAdapter", "loadMoreData %d/%d", Integer.valueOf(i), Integer.valueOf(C27524e.this.getCount()));
                            C27524e c27524e = C27524e.this;
                            C46627q aWp = c27524e.aWp();
                            if (aWp != null) {
                                C23522t aeY = C41747z.aeY();
                                long j = aWp.field_createTime;
                                List p = C23522t.m36351p(aeY.fni.query("BizTimeLineSingleMsgInfo", null, "createTime<?", new String[]{String.valueOf(j)}, null, null, "createTime DESC limit 20"));
                                c27524e.iKa.addAll(p);
                                c27524e.notifyDataSetChanged();
                                if (p.size() > 0) {
                                    i = 1;
                                    if (i == 0) {
                                        C27524e.this.jNE = true;
                                        BizTimeLineNewMsgUI b = C27524e.this.jNS;
                                        if (b.jNV != null) {
                                            b.jNW.setVisibility(8);
                                            b.jNX.setText(b.getString(C25738R.string.a_a));
                                        }
                                    }
                                }
                            }
                            i = 0;
                            if (i == 0) {
                            }
                        }
                        AppMethodBeat.m2505o(14148);
                    }
                }, 300);
            }
            AppMethodBeat.m2505o(14154);
            return;
        }
        AppMethodBeat.m2505o(14154);
    }
}
