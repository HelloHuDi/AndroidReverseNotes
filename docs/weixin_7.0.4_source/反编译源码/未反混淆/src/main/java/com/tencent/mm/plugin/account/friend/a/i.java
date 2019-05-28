package com.tencent.mm.plugin.account.friend.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.protocal.protobuf.aym;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i extends BaseAdapter {
    private Context context;
    public List<String[]> gsD;
    public int[] gty;
    public LinkedList<aym> gvi = new LinkedList();
    private LinkedList<aym> gvj = new LinkedList();
    private List<String[]> gvk = new LinkedList();
    private a gvl;
    public com.tencent.mm.ui.applet.b gvm = new com.tencent.mm.ui.applet.b(new com.tencent.mm.ui.applet.b.a() {
        public final Bitmap wd(String str) {
            AppMethodBeat.i(108338);
            Bitmap a = com.tencent.mm.ah.b.a(str, false, -1);
            AppMethodBeat.o(108338);
            return a;
        }
    });
    private com.tencent.mm.ui.applet.b.b gvn = null;
    int showType = 1;

    public interface a {
        void notifyDataSetChanged();
    }

    static class b {
        TextView gtG;
        ImageView gvq;
        TextView gvr;
        Button gvs;
        Button gvt;
        TextView gvu;
        TextView gvv;

        b() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(108355);
        aym mV = mV(i);
        AppMethodBeat.o(108355);
        return mV;
    }

    public i(Context context, a aVar, int i) {
        AppMethodBeat.i(108344);
        this.context = context;
        this.showType = i;
        this.gvl = aVar;
        this.gty = new int[this.gvi.size()];
        AppMethodBeat.o(108344);
    }

    public final int getSelectCount() {
        int i = 0;
        for (int i2 : this.gty) {
            if (this.showType == 1) {
                if (i2 == 1) {
                    i++;
                }
            } else if (this.showType == 2 && i2 == 2) {
                i++;
            }
        }
        return i;
    }

    public final boolean apN() {
        if (this.gty == null || this.gty.length == 0) {
            return false;
        }
        for (int i : this.gty) {
            if (this.showType == 1) {
                if (i == 0) {
                    return false;
                }
            } else if (this.showType == 2 && i == 0) {
                return false;
            }
        }
        return true;
    }

    public final void mU(int i) {
        AppMethodBeat.i(108345);
        if (this.showType == 1) {
            this.gty[i] = 1;
        } else if (this.showType == 2) {
            this.gty[i] = 2;
        }
        notifyDataSetChanged();
        AppMethodBeat.o(108345);
    }

    public final void dl(boolean z) {
        AppMethodBeat.i(108346);
        int i;
        int i2;
        if (this.showType == 1) {
            for (i = 0; i < this.gty.length; i++) {
                int[] iArr = this.gty;
                if (z) {
                    i2 = 1;
                } else {
                    i2 = 0;
                }
                iArr[i] = i2;
            }
        } else if (this.showType == 2) {
            for (i = 0; i < this.gty.length; i++) {
                int[] iArr2 = this.gty;
                if (z) {
                    i2 = 2;
                } else {
                    i2 = 0;
                }
                iArr2[i] = i2;
            }
        }
        notifyDataSetChanged();
        AppMethodBeat.o(108346);
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.i(108347);
        super.notifyDataSetChanged();
        if (this.gvl != null) {
            this.gvl.notifyDataSetChanged();
        }
        AppMethodBeat.o(108347);
    }

    public final void r(LinkedList<aym> linkedList) {
        AppMethodBeat.i(108348);
        if (linkedList != null) {
            this.gvj.clear();
            this.gvi.clear();
            this.gvk.clear();
            for (String[] strArr : this.gsD) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    aym aym = (aym) it.next();
                    if (this.showType == 1) {
                        if ((aym.jBT == 1 || aym.jBT == 0) && !bo.isNullOrNil(strArr[2]) && aym.pXM.equals(g.x(strArr[2].getBytes()))) {
                            a(aym, strArr);
                        }
                    } else if (this.showType == 2 && aym.jBT == 2 && !bo.isNullOrNil(strArr[2]) && aym.pXM.equals(g.x(strArr[2].getBytes()))) {
                        a(aym, strArr);
                    }
                }
            }
        }
        this.gty = new int[this.gvj.size()];
        this.gvi.addAll(this.gvj);
        this.gvj.clear();
        AppMethodBeat.o(108348);
    }

    private void a(aym aym, String[] strArr) {
        AppMethodBeat.i(108349);
        Iterator it = this.gvj.iterator();
        while (it.hasNext()) {
            aym aym2 = (aym) it.next();
            if (aym2.pXM != null && aym.pXM != null && aym2.pXM.equals(aym.pXM)) {
                ab.d("MicroMsg.FriendAdapter", "tigerreg mobile already added");
                AppMethodBeat.o(108349);
                return;
            }
        }
        this.gvj.add(aym);
        this.gvk.add(new String[]{strArr[2], strArr[1]});
        AppMethodBeat.o(108349);
    }

    public final int getCount() {
        AppMethodBeat.i(108350);
        int size = this.gvi.size();
        AppMethodBeat.o(108350);
        return size;
    }

    public final aym mV(int i) {
        AppMethodBeat.i(108351);
        aym aym = (aym) this.gvi.get(i);
        AppMethodBeat.o(108351);
        return aym;
    }

    public final long getItemId(int i) {
        AppMethodBeat.i(108352);
        long hashCode = (long) ((aym) this.gvi.get(i)).hashCode();
        AppMethodBeat.o(108352);
        return hashCode;
    }

    public final View getView(final int i, View view, ViewGroup viewGroup) {
        b bVar;
        AppMethodBeat.i(108353);
        if (this.showType == 1) {
            if (this.gvn == null) {
                this.gvn = new com.tencent.mm.ui.applet.b.b() {
                    public final String mW(int i) {
                        AppMethodBeat.i(108339);
                        if (i < 0 || i >= i.this.getCount()) {
                            ab.e("MicroMsg.FriendAdapter", "pos is invalid");
                            AppMethodBeat.o(108339);
                            return null;
                        }
                        aym mV = i.this.mV(i);
                        if (mV == null) {
                            AppMethodBeat.o(108339);
                            return null;
                        }
                        String str = mV.jBB;
                        AppMethodBeat.o(108339);
                        return str;
                    }

                    public final int apO() {
                        AppMethodBeat.i(108340);
                        int count = i.this.getCount();
                        AppMethodBeat.o(108340);
                        return count;
                    }
                };
            }
            if (this.gvm != null) {
                this.gvm.a(i, this.gvn);
            }
        }
        aym aym = (aym) this.gvi.get(i);
        if (view == null) {
            bVar = new b();
            if (this.showType == 1) {
                view = View.inflate(this.context, R.layout.zj, null);
                bVar.gtG = (TextView) view.findViewById(R.id.bsy);
                bVar.gvr = (TextView) view.findViewById(R.id.bt3);
                bVar.gvs = (Button) view.findViewById(R.id.bt1);
                bVar.gvt = (Button) view.findViewById(R.id.bt2);
                bVar.gvq = (ImageView) view.findViewById(R.id.bsx);
                bVar.gvu = (TextView) view.findViewById(R.id.bsz);
                bVar.gvv = (TextView) view.findViewById(R.id.bt0);
                view.setTag(bVar);
            } else if (this.showType == 2) {
                view = View.inflate(this.context, R.layout.zk, null);
                bVar.gtG = (TextView) view.findViewById(R.id.bsy);
                bVar.gvr = (TextView) view.findViewById(R.id.bt3);
                bVar.gvs = (Button) view.findViewById(R.id.bt1);
                bVar.gvt = (Button) view.findViewById(R.id.bt2);
                bVar.gvu = (TextView) view.findViewById(R.id.bsz);
                bVar.gvv = (TextView) view.findViewById(R.id.bt0);
                view.setTag(bVar);
            }
        } else {
            bVar = (b) view.getTag();
        }
        bVar.gvv.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(108341);
                i iVar = i.this;
                int i = i;
                if (iVar.showType == 1) {
                    iVar.gty[i] = 0;
                } else if (iVar.showType == 2) {
                    iVar.gty[i] = 0;
                }
                iVar.notifyDataSetChanged();
                AppMethodBeat.o(108341);
            }
        });
        if (this.showType == 1) {
            if (!bo.isNullOrNil(((String[]) this.gvk.get(i))[1])) {
                bVar.gtG.setText(((String[]) this.gvk.get(i))[1]);
            } else if (bo.isNullOrNil(aym.jCH)) {
                bVar.gtG.setText(aym.jBB);
            } else {
                bVar.gtG.setText(aym.jCH);
            }
            bVar.gvs.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(108342);
                    i.this.mU(i);
                    AppMethodBeat.o(108342);
                }
            });
            com.tencent.mm.pluginsdk.ui.a.b.b(bVar.gvq, aym.jBB);
        } else if (this.showType == 2) {
            bVar.gtG.setText(((String[]) this.gvk.get(i))[1]);
            bVar.gvt.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(108343);
                    i.this.mU(i);
                    AppMethodBeat.o(108343);
                }
            });
        }
        switch (this.gty[i]) {
            case 0:
                if (this.showType != 1) {
                    if (this.showType == 2) {
                        bVar.gvr.setVisibility(8);
                        bVar.gvs.setVisibility(8);
                        bVar.gvt.setVisibility(0);
                        bVar.gvu.setVisibility(8);
                        bVar.gvv.setVisibility(8);
                        break;
                    }
                }
                bVar.gvr.setVisibility(8);
                bVar.gvs.setVisibility(0);
                bVar.gvt.setVisibility(8);
                bVar.gvu.setVisibility(8);
                bVar.gvv.setVisibility(8);
                break;
                break;
            case 1:
                bVar.gvs.setVisibility(8);
                bVar.gvr.setVisibility(0);
                bVar.gvu.setVisibility(0);
                bVar.gvv.setVisibility(0);
                break;
            case 2:
                bVar.gvs.setVisibility(8);
                bVar.gvt.setVisibility(8);
                bVar.gvr.setVisibility(0);
                bVar.gvu.setVisibility(0);
                bVar.gvv.setVisibility(0);
                break;
            case 3:
                bVar.gvs.setVisibility(8);
                bVar.gvr.setVisibility(0);
                bVar.gvu.setVisibility(0);
                bVar.gvv.setVisibility(0);
                break;
        }
        AppMethodBeat.o(108353);
        return view;
    }

    public final void wc(String str) {
        AppMethodBeat.i(108354);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.gvk.size(); i++) {
            if (this.gty[i] == 2) {
                arrayList.add(((String[]) this.gvk.get(i))[0]);
            }
        }
        com.tencent.mm.kernel.g.Rg().a(new ai(str, arrayList), 0);
        AppMethodBeat.o(108354);
    }
}
