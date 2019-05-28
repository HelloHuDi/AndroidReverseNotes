package com.tencent.mm.plugin.account.friend.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.q;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.bed;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

final class b extends BaseAdapter {
    private final LayoutInflater ezi;
    private LinkedList<bed> fjr;
    LinkedList<aco> gxf;
    boolean gxg;
    private boolean[] gxh;

    static class a {
        TextView emg;
        TextView gxi;
        TextView gxj;
        TextView gxk;
        CheckBox gxl;
        int type;

        a() {
        }
    }

    public b(LayoutInflater layoutInflater) {
        this.ezi = layoutInflater;
    }

    public final void na(int i) {
        AppMethodBeat.i(108563);
        if (i < 0 || i >= this.gxh.length) {
            AppMethodBeat.o(108563);
            return;
        }
        boolean[] zArr = this.gxh;
        zArr[i] = !zArr[i];
        super.notifyDataSetChanged();
        AppMethodBeat.o(108563);
    }

    public final void a(LinkedList<bed> linkedList, int i) {
        AppMethodBeat.i(108564);
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
        AppMethodBeat.o(108564);
    }

    public final String[] aqw() {
        int i = 0;
        AppMethodBeat.i(108565);
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
                AppMethodBeat.o(108565);
                return strArr;
            }
        }
    }

    public final int getCount() {
        AppMethodBeat.i(108566);
        int size;
        if (this.gxg) {
            if (this.gxf == null) {
                AppMethodBeat.o(108566);
                return 0;
            }
            size = this.gxf.size();
            AppMethodBeat.o(108566);
            return size;
        } else if (this.fjr != null) {
            size = this.fjr.size();
            AppMethodBeat.o(108566);
            return size;
        } else {
            AppMethodBeat.o(108566);
            return 0;
        }
    }

    public final Object getItem(int i) {
        AppMethodBeat.i(108567);
        Object obj;
        if (this.gxg) {
            obj = this.gxf.get(i);
            AppMethodBeat.o(108567);
            return obj;
        }
        obj = this.fjr.get(i);
        AppMethodBeat.o(108567);
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
        AppMethodBeat.i(108568);
        a aVar;
        if (this.gxg) {
            a aVar2;
            aco aco = (aco) this.gxf.get(i);
            if (view == null || ((a) view.getTag()).type != 2) {
                view = this.ezi.inflate(R.layout.a8_, viewGroup, false);
                aVar = new a();
                aVar.type = 2;
                aVar.gxi = (TextView) view.findViewById(R.id.cj7);
                view.setTag(aVar);
                aVar2 = aVar;
            } else {
                aVar2 = (a) view.getTag();
            }
            aVar2.gxi.setText(aco.wkk);
            AppMethodBeat.o(108568);
        } else {
            CharSequence charSequence;
            TextView textView;
            CharSequence charSequence2;
            bed bed = (bed) this.fjr.get(i);
            if (view == null || ((a) view.getTag()).type != 1) {
                view = this.ezi.inflate(R.layout.a89, viewGroup, false);
                aVar = new a();
                aVar.type = 1;
                aVar.emg = (TextView) view.findViewById(R.id.cj5);
                aVar.gxj = (TextView) view.findViewById(R.id.cj6);
                aVar.gxl = (CheckBox) view.findViewById(R.id.bo_);
                aVar.gxk = (TextView) view.findViewById(R.id.bo9);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            if (((q) ((com.tencent.mm.plugin.account.a.a.a) g.M(com.tencent.mm.plugin.account.a.a.a.class)).getInviteFriendOpenStg()).wi(bed.jBB)) {
                aVar.gxk.setVisibility(0);
            } else {
                aVar.gxk.setVisibility(8);
            }
            TextView textView2 = aVar.emg;
            if (bed != null) {
                charSequence = bed.wbw;
                if (charSequence == null || charSequence.length() <= 0) {
                    charSequence = bed.jCH;
                    if (charSequence == null || charSequence.length() <= 0) {
                        charSequence = new p(bed.luF).toString();
                        if (charSequence == null || charSequence.length() <= 0) {
                            charSequence = bed.vLe;
                            if (charSequence != null) {
                            }
                        }
                    }
                }
                textView2.setText(charSequence);
                textView = aVar.gxj;
                if (bed != null) {
                    if (bed.wyY == 0) {
                        charSequence2 = bed.jBB;
                    } else if (bed.wyY == 2) {
                        charSequence2 = bed.jBB;
                    } else if (bed.wyY == 1) {
                        String str = bed.jBB;
                        if (!bo.isNullOrNil(str)) {
                            String[] split = str.split("@");
                            if (split == null || split.length < 2 || bo.isNullOrNil(split[0])) {
                                charSequence2 = "";
                            } else {
                                charSequence2 = "@" + split[0];
                            }
                        }
                    }
                    textView.setText(charSequence2);
                    aVar.gxl.setChecked(this.gxh[i]);
                    AppMethodBeat.o(108568);
                }
                charSequence2 = "";
                textView.setText(charSequence2);
                aVar.gxl.setChecked(this.gxh[i]);
                AppMethodBeat.o(108568);
            }
            charSequence = "";
            textView2.setText(charSequence);
            textView = aVar.gxj;
            if (bed != null) {
            }
            charSequence2 = "";
            textView.setText(charSequence2);
            aVar.gxl.setChecked(this.gxh[i]);
            AppMethodBeat.o(108568);
        }
        return view;
    }
}
