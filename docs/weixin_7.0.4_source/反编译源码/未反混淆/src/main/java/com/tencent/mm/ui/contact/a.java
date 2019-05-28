package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.story.api.e;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.AddressView;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.d;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.chatting.view.AvatarImageView;
import com.tencent.mm.ui.contact.AddressUI.AddressUIFragment;
import com.tencent.mm.ui.f;
import com.tencent.mm.ui.v;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class a extends f<String, com.tencent.mm.storage.f> implements com.tencent.mm.sdk.e.n.b {
    public static final ColorStateList nIp = com.tencent.mm.bz.a.h(ah.getContext(), (int) R.color.a7t);
    public static final ColorStateList nIq = com.tencent.mm.bz.a.h(ah.getContext(), (int) R.color.s0);
    protected List<String> elZ = null;
    private WeakReference<Context> gWO;
    private String gtX = "";
    private com.tencent.mm.ui.applet.b gvm = null;
    protected g jJO;
    protected c jJP;
    protected d jJR = MMSlideDelView.getItemStatusCallBack();
    private boolean jLC = false;
    OnClickListener mjE = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(33457);
            ab.v("MicroMsg.AddressAdapter", "on delView clicked");
            a.this.jJR.bIq();
            if (a.this.oQS != null) {
                a.this.oQS.bN(((ViewStub) a.this.zjO.get(view)).getTag());
            }
            AppMethodBeat.o(33457);
        }
    };
    protected MMSlideDelView.f oQS;
    StringBuilder sb = new StringBuilder(32);
    private int type;
    private String[] yDL = null;
    private List<String> zjA;
    private int zjB = 0;
    protected int[] zjC;
    String[] zjD;
    protected AddressUIFragment zjE;
    private Set<Integer> zjF = new HashSet();
    private int zjG = 0;
    private boolean zjH = true;
    a zjI;
    private boolean zjJ = false;
    boolean zjK = false;
    private String zjL;
    LinkedList<View> zjM = new LinkedList();
    boolean zjN;
    HashMap<View, ViewStub> zjO = new HashMap();
    private SparseArray<String> zjP = new SparseArray();
    private SparseArray<Integer> zjQ = new SparseArray();
    private HashSet<String> zjR = new HashSet();
    public HashMap<String, com.tencent.mm.storage.f> zjw = new HashMap();
    protected String zjx = null;
    protected String zjy = null;
    private List<Object> zjz;

    protected static class b {
        public ImageView eks;
        public TextView nBN;
        public TextView nBO;
        public AddressView nIu;
        public TextView zjT;
        public View zjU;
        public TextView zjV;
        public CategoryTipView zjW;
        public ViewGroup zjX;
    }

    public interface a {
    }

    public final /* synthetic */ void j(Object obj, int i) {
        AppMethodBeat.i(33480);
        eE((String) obj, i);
        AppMethodBeat.o(33480);
    }

    public final void eE(String str, int i) {
        AppMethodBeat.i(33458);
        if (i == 5) {
            this.zjR.add(str);
        }
        super.j(str, i);
        AppMethodBeat.o(33458);
    }

    public final void pause() {
        AppMethodBeat.i(33459);
        this.zjR.clear();
        super.pause();
        AppMethodBeat.o(33459);
    }

    public void notifyDataSetChanged() {
        AppMethodBeat.i(33460);
        this.zjL = r.Yz();
        if (this.zjC == null) {
            dHw();
        }
        if (getCount() == 0) {
            super.notifyDataSetChanged();
            AppMethodBeat.o(33460);
            return;
        }
        this.zjG = dwy();
        ab.i("MicroMsg.AddressAdapter", "newcursor favourCount %d", Integer.valueOf(this.zjG));
        super.notifyDataSetChanged();
        AppMethodBeat.o(33460);
    }

    public a(Context context, String str, String str2, int i) {
        super(context);
        AppMethodBeat.i(33461);
        this.gWO = new WeakReference(context);
        this.context = ah.getContext();
        this.zjx = str;
        this.zjy = str2;
        this.type = i;
        this.zjJ = true;
        this.zjz = new LinkedList();
        this.zjA = new LinkedList();
        this.zjL = r.Yz();
        this.TAG = "MiscroMsg.AddressDrawWithCacheAdapter";
        AppMethodBeat.o(33461);
    }

    public final void setFragment(Fragment fragment) {
        this.zjE = (AddressUIFragment) fragment;
    }

    public final void detach() {
        AppMethodBeat.i(33462);
        if (this.gvm != null) {
            this.gvm.detach();
            this.gvm = null;
        }
        AppMethodBeat.o(33462);
    }

    public final void setPerformItemClickListener(g gVar) {
        this.jJO = gVar;
    }

    public final void a(MMSlideDelView.f fVar) {
        this.oQS = fVar;
    }

    public final void setGetViewPositionCallback(c cVar) {
        this.jJP = cVar;
    }

    public final void fl(List<String> list) {
        AppMethodBeat.i(33463);
        if (this.type != 2) {
            list.add(r.Yz());
        }
        aw.ZK();
        bq RA = com.tencent.mm.model.c.XU().RA("@t.qq.com");
        if (RA != null) {
            list.add(RA.name);
        }
        if (this.type == 3 || this.type == 5 || this.type == 4 || this.type == 1 || this.type == 0) {
            for (String add : t.Zh()) {
                list.add(add);
            }
        }
        list.add("blogapp");
        this.elZ = list;
        AppMethodBeat.o(33463);
    }

    public final int getPositionForSection(int i) {
        if (this.zjC != null && i >= 0 && i < this.zjC.length) {
            i = this.zjC[i];
        }
        return this.zjG + i;
    }

    private boolean dHu() {
        AppMethodBeat.i(33464);
        if (this.zjx.equals("@micromsg.qq.com") || this.zjx.equals("@all.contact.without.chatroom") || this.zjx.equals("@all.contact.without.chatroom.without.openim")) {
            AppMethodBeat.o(33464);
            return true;
        }
        AppMethodBeat.o(33464);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public Cursor dHv() {
        AppMethodBeat.i(33465);
        long currentTimeMillis = System.currentTimeMillis();
        LinkedList linkedList = new LinkedList();
        linkedList.add("weixin");
        aw.ZK();
        Cursor a = com.tencent.mm.model.c.XM().a(this.zjx, this.zjy, this.elZ, linkedList, dHu(), this.zjJ);
        t(a);
        ab.d("MicroMsg.AddressAdapter", "kevin setCursor : " + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(33465);
        return a;
    }

    /* Access modifiers changed, original: protected|final */
    public final void dHw() {
        AppMethodBeat.i(33466);
        int count = getCount();
        if (count == 0) {
            AppMethodBeat.o(33466);
            return;
        }
        int i;
        int i2;
        this.zjG = dwy();
        if (this.yDL != null) {
            this.zjC = t.a(this.zjx, this.zjy, this.elZ, this.yDL);
            this.zjD = t.a(this.zjx, this.zjy, this.yDL, this.elZ);
        } else if (dvr()) {
            long currentTimeMillis = System.currentTimeMillis();
            HashSet hashSet = new HashSet();
            this.zjC = new int[30];
            this.zjD = new String[30];
            i = this.zjG;
            int i3 = 0;
            while (i < count) {
                com.tencent.mm.storage.f fVar = (com.tencent.mm.storage.f) getItem(i);
                if (fVar != null) {
                    String b = b(fVar, i);
                    if (hashSet.add(b)) {
                        this.zjC[i3] = i - this.zjG;
                        this.zjD[i3] = b;
                        i2 = i3 + 1;
                    }
                    i2 = i3;
                } else {
                    ab.d("MicroMsg.AddressAdapter", "newCursor getItem is null");
                    i2 = i3;
                }
                i++;
                i3 = i2;
            }
            ab.d("MicroMsg.AddressAdapter", "newCursor resetShowHead by Memory : " + (System.currentTimeMillis() - currentTimeMillis) + "favourCount : " + this.zjG);
        } else {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.zjC = t.a(this.zjx, this.zjy, this.elZ, this.gtX);
            this.zjD = t.a(this.zjx, this.zjy, this.gtX, this.elZ);
            ab.d("MicroMsg.AddressAdapter", "kevin resetShowHead part1 : " + (System.currentTimeMillis() - currentTimeMillis2));
        }
        this.zjF.clear();
        if (this.zjC != null) {
            for (int i4 : this.zjC) {
                this.zjF.add(Integer.valueOf(i4 - 1));
            }
        }
        AppMethodBeat.o(33466);
    }

    public final void dHx() {
        AppMethodBeat.i(33467);
        this.jJR.bIq();
        AppMethodBeat.o(33467);
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x027f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x02a4  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x030b  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01bb A:{SYNTHETIC, Splitter:B:50:0x01bb} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(33468);
        Context context = (Context) this.gWO.get();
        if (context == null) {
            AppMethodBeat.o(33468);
        } else {
            b bVar;
            if (!this.zjN) {
                for (int i2 = 0; i2 < 8; i2++) {
                    this.zjM.add(v.hu(context).inflate(R.layout.b3, null));
                }
                this.zjN = true;
            }
            com.tencent.mm.storage.f fVar = (com.tencent.mm.storage.f) getItem(i);
            if (view == null) {
                View view2;
                if (this.zjM.size() > 0) {
                    View view3 = (View) this.zjM.getFirst();
                    this.zjM.removeFirst();
                    view2 = view3;
                } else {
                    view2 = View.inflate(context, R.layout.b3, null);
                }
                bVar = new b();
                bVar.nBN = (TextView) view2.findViewById(R.id.nh);
                bVar.nBO = (TextView) view2.findViewById(R.id.nn);
                bVar.nIu = (AddressView) view2.findViewById(R.id.o1);
                bVar.eks = (ImageView) view2.findViewById(R.id.o0);
                bVar.zjT = (TextView) view2.findViewById(R.id.ny);
                bVar.zjU = view2.findViewById(R.id.nx);
                bVar.zjV = (TextView) view2.findViewById(R.id.nz);
                bVar.zjW = (CategoryTipView) view2.findViewById(R.id.nw);
                bVar.zjX = (ViewGroup) view2.findViewById(R.id.nv);
                LayoutParams layoutParams = bVar.zjU.getLayoutParams();
                layoutParams.height = (int) (((float) com.tencent.mm.bz.a.am(this.context, R.dimen.f4)) * com.tencent.mm.bz.a.fZ(this.context));
                bVar.zjU.setLayoutParams(layoutParams);
                if (this.zjE != null) {
                    this.zjE.ein.a(bVar.nIu);
                }
                view2.setTag(bVar);
                view = view2;
            } else {
                bVar = (b) view.getTag();
            }
            if (fVar != null) {
                String b;
                Object b2;
                int paddingLeft;
                CharSequence charSequence;
                aw.ZK();
                ad aoO = com.tencent.mm.model.c.XM().aoO(fVar.field_username);
                ab.d("MicroMsg.AddressAdapter", "user:%s, remark:%s", aoO.field_username, aoO.field_conRemark);
                com.tencent.mm.storage.f fVar2 = (com.tencent.mm.storage.f) getItem(i - 1);
                com.tencent.mm.storage.f fVar3 = (com.tencent.mm.storage.f) getItem(i + 1);
                int i3;
                if (fVar2 == null) {
                    i3 = -1;
                } else {
                    i3 = a(fVar2, i - 1);
                }
                int a = a(fVar, i);
                if (fVar3 != null) {
                    a(fVar3, i + 1);
                }
                bVar.zjW.setTag(Integer.valueOf(a));
                if (this.zjH && i >= 0 && a != i3) {
                    String b3 = b(fVar, i);
                    if (!com.tencent.mm.platformtools.ah.isNullOrNil(b3)) {
                        bVar.zjX.setVisibility(0);
                        bVar.nBN.setVisibility(0);
                        bVar.nBN.setText(b3);
                        bVar.zjW.Pm(((e) com.tencent.mm.kernel.g.M(e.class)).getFavourUserChecker().cwR());
                        b = b(fVar, i);
                        b2 = fVar3 != null ? null : b(fVar3, i + 1);
                        paddingLeft = bVar.zjU.getPaddingLeft();
                        if (b != null || b.equals(b2)) {
                            bVar.nIu.setBackgroundResource(R.drawable.a_q);
                            bVar.zjU.setBackground(null);
                        } else {
                            bVar.nIu.setBackground(null);
                            bVar.zjU.setBackgroundResource(R.drawable.a_q);
                        }
                        bVar.zjU.setPadding(paddingLeft, 0, 0, 0);
                        com.tencent.mm.pluginsdk.ui.a.b.b(bVar.eks, fVar.field_username);
                        if (fVar.field_verifyFlag != 0) {
                            bVar.nIu.setMaskBitmap(null);
                        } else if (com.tencent.mm.model.ao.a.flw != null) {
                            b3 = com.tencent.mm.model.ao.a.flw.kz(fVar.field_verifyFlag);
                            if (b3 != null) {
                                bVar.nIu.setMaskBitmap(m.rk(b3));
                            } else {
                                bVar.nIu.setMaskBitmap(null);
                            }
                        } else {
                            bVar.nIu.setMaskBitmap(null);
                        }
                        bVar.nIu.updateTextColors();
                        charSequence = fVar.xHQ;
                        if (charSequence != null) {
                            try {
                                if (ad.aox(fVar.field_username)) {
                                    charSequence = ((com.tencent.mm.openim.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.openim.a.b.class)).e(ah.getContext(), fVar.Oj(), com.tencent.mm.bz.a.al(this.context, R.dimen.m5));
                                } else {
                                    Context context2 = this.context;
                                    charSequence = fVar.Oj();
                                    String str = fVar.field_username;
                                    if (charSequence == null || charSequence.length() <= 0) {
                                        b2 = str;
                                    }
                                    str = "";
                                    if (str.length() > 0 && !str.equals(charSequence)) {
                                        this.sb.append(charSequence);
                                        this.sb.append("(");
                                        this.sb.append(str);
                                        this.sb.append(")");
                                        charSequence = this.sb.toString();
                                        this.sb.delete(0, this.sb.length());
                                    }
                                    charSequence = j.b(context2, charSequence, com.tencent.mm.bz.a.al(this.context, R.dimen.m5));
                                }
                            } catch (Exception e) {
                                charSequence = null;
                            }
                            if (charSequence == null) {
                                charSequence = "";
                            }
                            bVar.nIu.setName(charSequence);
                        } else {
                            bVar.nIu.setName(charSequence);
                        }
                        bVar.nIu.setDescription(com.tencent.mm.platformtools.ah.nullAsNil(fVar.field_remarkDesc));
                        a(fVar, bVar);
                        com.tencent.mm.plugin.sns.ui.e.a.b(0, (String) bVar.eks.getTag(), (AvatarImageView) bVar.eks);
                        ((AvatarImageView) bVar.eks).dk(fVar.field_username, 0);
                        ((AvatarImageView) bVar.eks).setTag(fVar.field_username);
                        com.tencent.mm.plugin.sns.ui.e.a.a(0, fVar.field_username, (AvatarImageView) bVar.eks);
                        ((AvatarImageView) bVar.eks).setShowStoryHint(com.tencent.mm.plugin.sns.e.a.Xt(fVar.field_username));
                    }
                }
                bVar.zjX.setVisibility(8);
                bVar.nBN.setVisibility(8);
                bVar.zjW.setVisibility(8);
                b = b(fVar, i);
                if (fVar3 != null) {
                }
                paddingLeft = bVar.zjU.getPaddingLeft();
                if (b != null) {
                }
                bVar.nIu.setBackgroundResource(R.drawable.a_q);
                bVar.zjU.setBackground(null);
                bVar.zjU.setPadding(paddingLeft, 0, 0, 0);
                com.tencent.mm.pluginsdk.ui.a.b.b(bVar.eks, fVar.field_username);
                if (fVar.field_verifyFlag != 0) {
                }
                bVar.nIu.updateTextColors();
                charSequence = fVar.xHQ;
                if (charSequence != null) {
                }
                bVar.nIu.setDescription(com.tencent.mm.platformtools.ah.nullAsNil(fVar.field_remarkDesc));
                a(fVar, bVar);
                com.tencent.mm.plugin.sns.ui.e.a.b(0, (String) bVar.eks.getTag(), (AvatarImageView) bVar.eks);
                ((AvatarImageView) bVar.eks).dk(fVar.field_username, 0);
                ((AvatarImageView) bVar.eks).setTag(fVar.field_username);
                com.tencent.mm.plugin.sns.ui.e.a.a(0, fVar.field_username, (AvatarImageView) bVar.eks);
                ((AvatarImageView) bVar.eks).setShowStoryHint(com.tencent.mm.plugin.sns.e.a.Xt(fVar.field_username));
            }
            bVar.nIu.updatePositionFlag();
            bVar.nIu.setContentDescription(bVar.nIu.getNickName() == null ? "" : bVar.nIu.getNickName().toString());
            bVar.eks.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(33456);
                    ab.d("MicroMsg.AddressAdapter", "click avatarIv");
                    if (view == null) {
                        AppMethodBeat.o(33456);
                        return;
                    }
                    a.this.jJO.q(view, a.this.jJP.cZ(view), R.id.o0);
                    AppMethodBeat.o(33456);
                }
            });
            AppMethodBeat.o(33468);
        }
        return view;
    }

    /* Access modifiers changed, original: protected */
    public void a(com.tencent.mm.storage.f fVar, b bVar) {
        AppMethodBeat.i(33469);
        try {
            bVar.zjV.setText(null);
            bVar.zjV.setVisibility(8);
            if (ad.aox(fVar.field_username)) {
                String ba = ((com.tencent.mm.openim.a.b) com.tencent.mm.kernel.g.K(com.tencent.mm.openim.a.b.class)).ba(fVar.field_openImAppid, fVar.field_descWordingId);
                if (ba != null && ba.length() > 0) {
                    bVar.zjV.setVisibility(0);
                    bVar.zjV.setText(ba);
                }
            }
            AppMethodBeat.o(33469);
        } catch (Throwable th) {
            AppMethodBeat.o(33469);
        }
    }

    static {
        AppMethodBeat.i(33482);
        AppMethodBeat.o(33482);
    }

    /* Access modifiers changed, original: protected */
    public int a(com.tencent.mm.storage.f fVar, int i) {
        AppMethodBeat.i(33470);
        if (i < this.zjG) {
            AppMethodBeat.o(33470);
            return 32;
        } else if (fVar == null) {
            ab.e("MicroMsg.AddressAdapter", "contact is null, position:%d", Integer.valueOf(i));
            AppMethodBeat.o(33470);
            return -1;
        } else {
            int i2 = fVar.field_showHead;
            AppMethodBeat.o(33470);
            return i2;
        }
    }

    /* Access modifiers changed, original: protected */
    public String b(com.tencent.mm.storage.f fVar, int i) {
        AppMethodBeat.i(33471);
        String string;
        if (i < this.zjG) {
            string = getString(R.string.e0);
            AppMethodBeat.o(33471);
            return string;
        } else if (fVar.field_showHead == 31) {
            string = "";
            AppMethodBeat.o(33471);
            return string;
        } else if (fVar.field_showHead == 123) {
            string = "#";
            AppMethodBeat.o(33471);
            return string;
        } else if (fVar.field_showHead == 33) {
            string = getString(R.string.dh);
            AppMethodBeat.o(33471);
            return string;
        } else if (fVar.field_showHead == 43) {
            string = getString(R.string.dso);
            AppMethodBeat.o(33471);
            return string;
        } else if (fVar.field_showHead == 32) {
            string = getString(R.string.e0);
            AppMethodBeat.o(33471);
            return string;
        } else {
            string = (String) this.zjP.get(fVar.field_showHead);
            if (string != null) {
                AppMethodBeat.o(33471);
                return string;
            }
            string = String.valueOf((char) fVar.field_showHead);
            this.zjP.put(fVar.field_showHead, string);
            AppMethodBeat.o(33471);
            return string;
        }
    }

    public int getCount() {
        AppMethodBeat.i(33472);
        int count = super.getCount();
        AppMethodBeat.o(33472);
        return count;
    }

    private String getString(int i) {
        AppMethodBeat.i(33473);
        String str = (String) this.zjP.get(i);
        if (str == null) {
            str = this.context.getString(i);
            this.zjP.put(i, str);
        }
        AppMethodBeat.o(33473);
        return str;
    }

    public final com.tencent.mm.cd.a.d<String> dwz() {
        AppMethodBeat.i(33474);
        com.tencent.mm.cd.a.d dVar = (com.tencent.mm.cd.a.d) dHv();
        AppMethodBeat.o(33474);
        return dVar;
    }

    public final ArrayList<com.tencent.mm.storage.f> ao(ArrayList<String> arrayList) {
        AppMethodBeat.i(33475);
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= arrayList.size()) {
                break;
            }
            arrayList2.add((String) arrayList.get(i2));
            i = i2 + 1;
        }
        ArrayList arrayList3 = new ArrayList(arrayList2.size());
        aw.ZK();
        Cursor ev = com.tencent.mm.model.c.XM().ev(arrayList2);
        while (ev.moveToNext()) {
            com.tencent.mm.storage.f fVar = new com.tencent.mm.storage.f();
            fVar.d(ev);
            arrayList3.add(fVar);
        }
        ev.close();
        ab.d("MicroMsg.AddressAdapter", "rebulidAllChangeData :" + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(33475);
        return arrayList3;
    }

    public final SparseArray<String>[] a(HashSet<com.tencent.mm.ui.f.b<String, com.tencent.mm.storage.f>> hashSet, SparseArray<String>[] sparseArrayArr) {
        AppMethodBeat.i(33476);
        SparseArray[] sparseArrayArr2 = new SparseArray[sparseArrayArr.length];
        LinkedList linkedList = new LinkedList();
        linkedList.add("weixin");
        long currentTimeMillis = System.currentTimeMillis();
        aw.ZK();
        Cursor b = com.tencent.mm.model.c.XM().b(this.zjx, this.zjy, this.elZ, linkedList, dHu(), this.zjJ);
        int i;
        if (b instanceof com.tencent.mm.cd.a.e) {
            com.tencent.mm.cd.a.d[] dVarArr = ((com.tencent.mm.cd.a.e) b).ycs;
            int length = dVarArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                dVarArr[i2].MH(5000);
                sparseArrayArr2[i2] = new SparseArray();
                i = 0;
                while (dVarArr[i2].moveToNext()) {
                    sparseArrayArr2[i2].put(i, dVarArr[i2].getString(0));
                    i++;
                }
            }
            this.zjG = dVarArr[0].getCount();
        } else {
            sparseArrayArr2[0] = new SparseArray();
            i = 0;
            while (b.moveToNext()) {
                sparseArrayArr2[0].put(i, b.getString(0));
                i++;
            }
        }
        b.close();
        ab.d("MicroMsg.AddressAdapter", "refreshPosistion last :" + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(33476);
        return sparseArrayArr2;
    }

    public final void dHy() {
        AppMethodBeat.i(33477);
        super.j(null, 1);
        AppMethodBeat.o(33477);
    }

    public void a(int i, n nVar, Object obj) {
        AppMethodBeat.i(33478);
        if (obj == null || !(obj instanceof String)) {
            ab.d("MicroMsg.AddressAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), nVar, obj);
            AppMethodBeat.o(33478);
            return;
        }
        aw.ZK();
        if (nVar == com.tencent.mm.model.c.XM()) {
            if (t.mX((String) obj) || this.zjR.contains((String) obj)) {
                ab.d("MicroMsg.AddressAdapter", "newcursor is stranger ，return");
            } else {
                super.j((String) obj, 2);
                if (this.zjK && this.zjE != null) {
                    this.zjE.zks = true;
                    ab.d("MicroMsg.AddressAdapter", "ADDRESS onNotifyChange");
                    AppMethodBeat.o(33478);
                    return;
                }
            }
        }
        AppMethodBeat.o(33478);
    }

    private static void t(Cursor cursor) {
        AppMethodBeat.i(33479);
        if (cursor instanceof com.tencent.mm.cd.a.e) {
            ArrayList arrayList = new ArrayList();
            Cursor cursor2 = ((com.tencent.mm.cd.a.e) cursor).ycs[0];
            int position = cursor2.getPosition();
            if (cursor2 != null) {
                while (cursor2.moveToNext()) {
                    com.tencent.mm.storage.f fVar = new com.tencent.mm.storage.f();
                    fVar.d(cursor2);
                    arrayList.add(fVar.field_username);
                    ab.d("MicroMsg.AddressAdapter", "mStarUserList add %s %s", fVar.field_username, fVar.field_conRemark);
                }
                cursor2.moveToPosition(position);
            }
            ((e) com.tencent.mm.kernel.g.M(e.class)).getFavourUserChecker().dE(arrayList);
        }
        AppMethodBeat.o(33479);
    }

    public final /* synthetic */ com.tencent.mm.cd.a.a dvz() {
        AppMethodBeat.i(33481);
        com.tencent.mm.storage.f fVar = new com.tencent.mm.storage.f();
        AppMethodBeat.o(33481);
        return fVar;
    }
}
