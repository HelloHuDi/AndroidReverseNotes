package com.tencent.p177mm.plugin.account.friend.p273ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.plugin.account.friend.p272a.C9880q;
import com.tencent.p177mm.plugin.account.p765a.p766a.C7599a;
import com.tencent.p177mm.protocal.protobuf.aco;
import com.tencent.p177mm.protocal.protobuf.bed;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.account.friend.ui.b */
final class C38039b extends BaseAdapter {
    private final LayoutInflater ezi;
    private LinkedList<bed> fjr;
    LinkedList<aco> gxf;
    boolean gxg;
    private boolean[] gxh;

    /* renamed from: com.tencent.mm.plugin.account.friend.ui.b$a */
    static class C38038a {
        TextView emg;
        TextView gxi;
        TextView gxj;
        TextView gxk;
        CheckBox gxl;
        int type;

        C38038a() {
        }
    }

    public C38039b(LayoutInflater layoutInflater) {
        this.ezi = layoutInflater;
    }

    /* renamed from: na */
    public final void mo60794na(int i) {
        AppMethodBeat.m2504i(108563);
        if (i < 0 || i >= this.gxh.length) {
            AppMethodBeat.m2505o(108563);
            return;
        }
        boolean[] zArr = this.gxh;
        zArr[i] = !zArr[i];
        super.notifyDataSetChanged();
        AppMethodBeat.m2505o(108563);
    }

    /* renamed from: a */
    public final void mo60788a(LinkedList<bed> linkedList, int i) {
        AppMethodBeat.m2504i(108564);
        if (i >= 0) {
            this.fjr = new LinkedList();
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= linkedList.size()) {
                    break;
                }
                if (i == ((bed) linkedList.get(i3)).weB) {
                    this.fjr.add(linkedList.get(i3));
                }
                i2 = i3 + 1;
            }
        } else {
            this.fjr = linkedList;
        }
        this.gxh = new boolean[this.fjr.size()];
        AppMethodBeat.m2505o(108564);
    }

    public final String[] aqw() {
        int i = 0;
        AppMethodBeat.m2504i(108565);
        int i2 = 0;
        for (boolean z : this.gxh) {
            if (z) {
                i2++;
            }
        }
        String[] strArr = new String[i2];
        int i3 = 0;
        while (true) {
            int i4 = i;
            if (i4 < this.fjr.size()) {
                if (this.gxh[i4]) {
                    i = i3 + 1;
                    strArr[i3] = ((bed) this.fjr.get(i4)).jBB;
                    i2 = i;
                } else {
                    i2 = i3;
                }
                i = i4 + 1;
                i3 = i2;
            } else {
                AppMethodBeat.m2505o(108565);
                return strArr;
            }
        }
    }

    public final int getCount() {
        AppMethodBeat.m2504i(108566);
        int size;
        if (this.gxg) {
            if (this.gxf == null) {
                AppMethodBeat.m2505o(108566);
                return 0;
            }
            size = this.gxf.size();
            AppMethodBeat.m2505o(108566);
            return size;
        } else if (this.fjr != null) {
            size = this.fjr.size();
            AppMethodBeat.m2505o(108566);
            return size;
        } else {
            AppMethodBeat.m2505o(108566);
            return 0;
        }
    }

    public final Object getItem(int i) {
        AppMethodBeat.m2504i(108567);
        Object obj;
        if (this.gxg) {
            obj = this.gxf.get(i);
            AppMethodBeat.m2505o(108567);
            return obj;
        }
        obj = this.fjr.get(i);
        AppMethodBeat.m2505o(108567);
        return obj;
    }

    public final long getItemId(int i) {
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00d5  */
    /* JADX WARNING: Missing block: B:43:0x0121, code skipped:
            if (r1.length() > 0) goto L_0x00ce;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(108568);
        C38038a c38038a;
        if (this.gxg) {
            C38038a c38038a2;
            aco aco = (aco) this.gxf.get(i);
            if (view == null || ((C38038a) view.getTag()).type != 2) {
                view = this.ezi.inflate(2130969874, viewGroup, false);
                c38038a = new C38038a();
                c38038a.type = 2;
                c38038a.gxi = (TextView) view.findViewById(2131825028);
                view.setTag(c38038a);
                c38038a2 = c38038a;
            } else {
                c38038a2 = (C38038a) view.getTag();
            }
            c38038a2.gxi.setText(aco.wkk);
            AppMethodBeat.m2505o(108568);
        } else {
            CharSequence charSequence;
            TextView textView;
            CharSequence charSequence2;
            bed bed = (bed) this.fjr.get(i);
            if (view == null || ((C38038a) view.getTag()).type != 1) {
                view = this.ezi.inflate(2130969873, viewGroup, false);
                c38038a = new C38038a();
                c38038a.type = 1;
                c38038a.emg = (TextView) view.findViewById(2131825026);
                c38038a.gxj = (TextView) view.findViewById(2131825027);
                c38038a.gxl = (CheckBox) view.findViewById(2131823847);
                c38038a.gxk = (TextView) view.findViewById(2131823846);
                view.setTag(c38038a);
            } else {
                c38038a = (C38038a) view.getTag();
            }
            if (((C9880q) ((C7599a) C1720g.m3530M(C7599a.class)).getInviteFriendOpenStg()).mo21240wi(bed.jBB)) {
                c38038a.gxk.setVisibility(0);
            } else {
                c38038a.gxk.setVisibility(8);
            }
            TextView textView2 = c38038a.emg;
            if (bed != null) {
                charSequence = bed.wbw;
                if (charSequence == null || charSequence.length() <= 0) {
                    charSequence = bed.jCH;
                    if (charSequence == null || charSequence.length() <= 0) {
                        charSequence = new C1183p(bed.luF).toString();
                        if (charSequence == null || charSequence.length() <= 0) {
                            charSequence = bed.vLe;
                            if (charSequence != null) {
                            }
                        }
                    }
                }
                textView2.setText(charSequence);
                textView = c38038a.gxj;
                if (bed != null) {
                    if (bed.wyY == 0) {
                        charSequence2 = bed.jBB;
                    } else if (bed.wyY == 2) {
                        charSequence2 = bed.jBB;
                    } else if (bed.wyY == 1) {
                        String str = bed.jBB;
                        if (!C5046bo.isNullOrNil(str)) {
                            String[] split = str.split("@");
                            if (split == null || split.length < 2 || C5046bo.isNullOrNil(split[0])) {
                                charSequence2 = "";
                            } else {
                                charSequence2 = "@" + split[0];
                            }
                        }
                    }
                    textView.setText(charSequence2);
                    c38038a.gxl.setChecked(this.gxh[i]);
                    AppMethodBeat.m2505o(108568);
                }
                charSequence2 = "";
                textView.setText(charSequence2);
                c38038a.gxl.setChecked(this.gxh[i]);
                AppMethodBeat.m2505o(108568);
            }
            charSequence = "";
            textView2.setText(charSequence);
            textView = c38038a.gxj;
            if (bed != null) {
            }
            charSequence2 = "";
            textView.setText(charSequence2);
            c38038a.gxl.setChecked(this.gxh[i]);
            AppMethodBeat.m2505o(108568);
        }
        return view;
    }
}
