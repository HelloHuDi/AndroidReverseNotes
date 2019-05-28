package com.tencent.p177mm.p612ui.contact;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.support.p057v4.app.Fragment;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C26415ao.C26417a;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.openim.p1210a.C32873b;
import com.tencent.p177mm.p184aj.C8935m;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p213cd.p214a.C1351a;
import com.tencent.p177mm.p213cd.p214a.C1354d;
import com.tencent.p177mm.p213cd.p214a.C37629e;
import com.tencent.p177mm.p612ui.AddressView;
import com.tencent.p177mm.p612ui.C40862f;
import com.tencent.p177mm.p612ui.C40862f.C15880b;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.applet.C36043b;
import com.tencent.p177mm.p612ui.base.MMSlideDelView;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C15521c;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23597d;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23599f;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23600g;
import com.tencent.p177mm.p612ui.chatting.view.AvatarImageView;
import com.tencent.p177mm.p612ui.contact.AddressUI.AddressUIFragment;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.sns.p1556e.C39732a;
import com.tencent.p177mm.plugin.sns.p520ui.p1413e.C29210a;
import com.tencent.p177mm.plugin.story.api.C35168e;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.p603e.C7298n;
import com.tencent.p177mm.sdk.p603e.C7298n.C4937b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.storage.C40629f;
import com.tencent.p177mm.storage.C5140bq;
import com.tencent.p177mm.storage.C7616ad;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* renamed from: com.tencent.mm.ui.contact.a */
public class C15824a extends C40862f<String, C40629f> implements C4937b {
    public static final ColorStateList nIp = C1338a.m2870h(C4996ah.getContext(), (int) C25738R.color.a7t);
    public static final ColorStateList nIq = C1338a.m2870h(C4996ah.getContext(), (int) C25738R.color.f12092s0);
    protected List<String> elZ = null;
    private WeakReference<Context> gWO;
    private String gtX = "";
    private C36043b gvm = null;
    protected C23600g jJO;
    protected C15521c jJP;
    protected C23597d jJR = MMSlideDelView.getItemStatusCallBack();
    private boolean jLC = false;
    OnClickListener mjE = new C158272();
    protected C23599f oQS;
    /* renamed from: sb */
    StringBuilder f2990sb = new StringBuilder(32);
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
    C15828a zjI;
    private boolean zjJ = false;
    boolean zjK = false;
    private String zjL;
    LinkedList<View> zjM = new LinkedList();
    boolean zjN;
    HashMap<View, ViewStub> zjO = new HashMap();
    private SparseArray<String> zjP = new SparseArray();
    private SparseArray<Integer> zjQ = new SparseArray();
    private HashSet<String> zjR = new HashSet();
    public HashMap<String, C40629f> zjw = new HashMap();
    protected String zjx = null;
    protected String zjy = null;
    private List<Object> zjz;

    /* renamed from: com.tencent.mm.ui.contact.a$b */
    protected static class C15825b {
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

    /* renamed from: com.tencent.mm.ui.contact.a$1 */
    class C158261 implements OnClickListener {
        C158261() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(33456);
            C4990ab.m7410d("MicroMsg.AddressAdapter", "click avatarIv");
            if (view == null) {
                AppMethodBeat.m2505o(33456);
                return;
            }
            C15824a.this.jJO.mo11108q(view, C15824a.this.jJP.mo8831cZ(view), 2131821088);
            AppMethodBeat.m2505o(33456);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.a$2 */
    class C158272 implements OnClickListener {
        C158272() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(33457);
            C4990ab.m7418v("MicroMsg.AddressAdapter", "on delView clicked");
            C15824a.this.jJR.bIq();
            if (C15824a.this.oQS != null) {
                C15824a.this.oQS.mo11067bN(((ViewStub) C15824a.this.zjO.get(view)).getTag());
            }
            AppMethodBeat.m2505o(33457);
        }
    }

    /* renamed from: com.tencent.mm.ui.contact.a$a */
    public interface C15828a {
    }

    /* renamed from: j */
    public final /* synthetic */ void mo28048j(Object obj, int i) {
        AppMethodBeat.m2504i(33480);
        mo28043eE((String) obj, i);
        AppMethodBeat.m2505o(33480);
    }

    /* renamed from: eE */
    public final void mo28043eE(String str, int i) {
        AppMethodBeat.m2504i(33458);
        if (i == 5) {
            this.zjR.add(str);
        }
        super.mo28048j(str, i);
        AppMethodBeat.m2505o(33458);
    }

    public final void pause() {
        AppMethodBeat.m2504i(33459);
        this.zjR.clear();
        super.pause();
        AppMethodBeat.m2505o(33459);
    }

    public void notifyDataSetChanged() {
        AppMethodBeat.m2504i(33460);
        this.zjL = C1853r.m3846Yz();
        if (this.zjC == null) {
            dHw();
        }
        if (getCount() == 0) {
            super.notifyDataSetChanged();
            AppMethodBeat.m2505o(33460);
            return;
        }
        this.zjG = dwy();
        C4990ab.m7417i("MicroMsg.AddressAdapter", "newcursor favourCount %d", Integer.valueOf(this.zjG));
        super.notifyDataSetChanged();
        AppMethodBeat.m2505o(33460);
    }

    public C15824a(Context context, String str, String str2, int i) {
        super(context);
        AppMethodBeat.m2504i(33461);
        this.gWO = new WeakReference(context);
        this.context = C4996ah.getContext();
        this.zjx = str;
        this.zjy = str2;
        this.type = i;
        this.zjJ = true;
        this.zjz = new LinkedList();
        this.zjA = new LinkedList();
        this.zjL = C1853r.m3846Yz();
        this.TAG = "MiscroMsg.AddressDrawWithCacheAdapter";
        AppMethodBeat.m2505o(33461);
    }

    public final void setFragment(Fragment fragment) {
        this.zjE = (AddressUIFragment) fragment;
    }

    public final void detach() {
        AppMethodBeat.m2504i(33462);
        if (this.gvm != null) {
            this.gvm.detach();
            this.gvm = null;
        }
        AppMethodBeat.m2505o(33462);
    }

    public final void setPerformItemClickListener(C23600g c23600g) {
        this.jJO = c23600g;
    }

    /* renamed from: a */
    public final void mo28032a(C23599f c23599f) {
        this.oQS = c23599f;
    }

    public final void setGetViewPositionCallback(C15521c c15521c) {
        this.jJP = c15521c;
    }

    /* renamed from: fl */
    public final void mo28044fl(List<String> list) {
        AppMethodBeat.m2504i(33463);
        if (this.type != 2) {
            list.add(C1853r.m3846Yz());
        }
        C9638aw.m17190ZK();
        C5140bq RA = C18628c.m29086XU().mo15356RA("@t.qq.com");
        if (RA != null) {
            list.add(RA.name);
        }
        if (this.type == 3 || this.type == 5 || this.type == 4 || this.type == 1 || this.type == 0) {
            for (String add : C1855t.m3871Zh()) {
                list.add(add);
            }
        }
        list.add("blogapp");
        this.elZ = list;
        AppMethodBeat.m2505o(33463);
    }

    public final int getPositionForSection(int i) {
        if (this.zjC != null && i >= 0 && i < this.zjC.length) {
            i = this.zjC[i];
        }
        return this.zjG + i;
    }

    private boolean dHu() {
        AppMethodBeat.m2504i(33464);
        if (this.zjx.equals("@micromsg.qq.com") || this.zjx.equals("@all.contact.without.chatroom") || this.zjx.equals("@all.contact.without.chatroom.without.openim")) {
            AppMethodBeat.m2505o(33464);
            return true;
        }
        AppMethodBeat.m2505o(33464);
        return false;
    }

    /* Access modifiers changed, original: protected */
    public Cursor dHv() {
        AppMethodBeat.m2504i(33465);
        long currentTimeMillis = System.currentTimeMillis();
        LinkedList linkedList = new LinkedList();
        linkedList.add("weixin");
        C9638aw.m17190ZK();
        Cursor a = C18628c.m29078XM().mo15703a(this.zjx, this.zjy, this.elZ, linkedList, dHu(), this.zjJ);
        C15824a.m24178t(a);
        C4990ab.m7410d("MicroMsg.AddressAdapter", "kevin setCursor : " + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(33465);
        return a;
    }

    /* Access modifiers changed, original: protected|final */
    public final void dHw() {
        AppMethodBeat.m2504i(33466);
        int count = getCount();
        if (count == 0) {
            AppMethodBeat.m2505o(33466);
            return;
        }
        int i;
        int i2;
        this.zjG = dwy();
        if (this.yDL != null) {
            this.zjC = C1855t.m3883a(this.zjx, this.zjy, this.elZ, this.yDL);
            this.zjD = C1855t.m3885a(this.zjx, this.zjy, this.yDL, this.elZ);
        } else if (dvr()) {
            long currentTimeMillis = System.currentTimeMillis();
            HashSet hashSet = new HashSet();
            this.zjC = new int[30];
            this.zjD = new String[30];
            i = this.zjG;
            int i3 = 0;
            while (i < count) {
                C40629f c40629f = (C40629f) getItem(i);
                if (c40629f != null) {
                    String b = mo28035b(c40629f, i);
                    if (hashSet.add(b)) {
                        this.zjC[i3] = i - this.zjG;
                        this.zjD[i3] = b;
                        i2 = i3 + 1;
                    }
                    i2 = i3;
                } else {
                    C4990ab.m7410d("MicroMsg.AddressAdapter", "newCursor getItem is null");
                    i2 = i3;
                }
                i++;
                i3 = i2;
            }
            C4990ab.m7410d("MicroMsg.AddressAdapter", "newCursor resetShowHead by Memory : " + (System.currentTimeMillis() - currentTimeMillis) + "favourCount : " + this.zjG);
        } else {
            long currentTimeMillis2 = System.currentTimeMillis();
            this.zjC = C1855t.m3882a(this.zjx, this.zjy, this.elZ, this.gtX);
            this.zjD = C1855t.m3884a(this.zjx, this.zjy, this.gtX, this.elZ);
            C4990ab.m7410d("MicroMsg.AddressAdapter", "kevin resetShowHead part1 : " + (System.currentTimeMillis() - currentTimeMillis2));
        }
        this.zjF.clear();
        if (this.zjC != null) {
            for (int i4 : this.zjC) {
                this.zjF.add(Integer.valueOf(i4 - 1));
            }
        }
        AppMethodBeat.m2505o(33466);
    }

    public final void dHx() {
        AppMethodBeat.m2504i(33467);
        this.jJR.bIq();
        AppMethodBeat.m2505o(33467);
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x027f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x02a4  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x030b  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x01bb A:{SYNTHETIC, Splitter:B:50:0x01bb} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(33468);
        Context context = (Context) this.gWO.get();
        if (context == null) {
            AppMethodBeat.m2505o(33468);
        } else {
            C15825b c15825b;
            if (!this.zjN) {
                for (int i2 = 0; i2 < 8; i2++) {
                    this.zjM.add(C5616v.m8409hu(context).inflate(2130968642, null));
                }
                this.zjN = true;
            }
            C40629f c40629f = (C40629f) getItem(i);
            if (view == null) {
                View view2;
                if (this.zjM.size() > 0) {
                    View view3 = (View) this.zjM.getFirst();
                    this.zjM.removeFirst();
                    view2 = view3;
                } else {
                    view2 = View.inflate(context, 2130968642, null);
                }
                c15825b = new C15825b();
                c15825b.nBN = (TextView) view2.findViewById(2131821069);
                c15825b.nBO = (TextView) view2.findViewById(2131821075);
                c15825b.nIu = (AddressView) view2.findViewById(2131821089);
                c15825b.eks = (ImageView) view2.findViewById(2131821088);
                c15825b.zjT = (TextView) view2.findViewById(2131821086);
                c15825b.zjU = view2.findViewById(2131821085);
                c15825b.zjV = (TextView) view2.findViewById(2131821087);
                c15825b.zjW = (CategoryTipView) view2.findViewById(2131821084);
                c15825b.zjX = (ViewGroup) view2.findViewById(2131821083);
                LayoutParams layoutParams = c15825b.zjU.getLayoutParams();
                layoutParams.height = (int) (((float) C1338a.m2857am(this.context, C25738R.dimen.f9768f4)) * C1338a.m2863fZ(this.context));
                c15825b.zjU.setLayoutParams(layoutParams);
                if (this.zjE != null) {
                    this.zjE.ein.mo27290a(c15825b.nIu);
                }
                view2.setTag(c15825b);
                view = view2;
            } else {
                c15825b = (C15825b) view.getTag();
            }
            if (c40629f != null) {
                String b;
                Object b2;
                int paddingLeft;
                CharSequence charSequence;
                C9638aw.m17190ZK();
                C7616ad aoO = C18628c.m29078XM().aoO(c40629f.field_username);
                C4990ab.m7411d("MicroMsg.AddressAdapter", "user:%s, remark:%s", aoO.field_username, aoO.field_conRemark);
                C40629f c40629f2 = (C40629f) getItem(i - 1);
                C40629f c40629f3 = (C40629f) getItem(i + 1);
                int i3;
                if (c40629f2 == null) {
                    i3 = -1;
                } else {
                    i3 = mo28030a(c40629f2, i - 1);
                }
                int a = mo28030a(c40629f, i);
                if (c40629f3 != null) {
                    mo28030a(c40629f3, i + 1);
                }
                c15825b.zjW.setTag(Integer.valueOf(a));
                if (this.zjH && i >= 0 && a != i3) {
                    String b3 = mo28035b(c40629f, i);
                    if (!C42252ah.isNullOrNil(b3)) {
                        c15825b.zjX.setVisibility(0);
                        c15825b.nBN.setVisibility(0);
                        c15825b.nBN.setText(b3);
                        c15825b.zjW.mo27997Pm(((C35168e) C1720g.m3530M(C35168e.class)).getFavourUserChecker().cwR());
                        b = mo28035b(c40629f, i);
                        b2 = c40629f3 != null ? null : mo28035b(c40629f3, i + 1);
                        paddingLeft = c15825b.zjU.getPaddingLeft();
                        if (b != null || b.equals(b2)) {
                            c15825b.nIu.setBackgroundResource(C25738R.drawable.a_q);
                            c15825b.zjU.setBackground(null);
                        } else {
                            c15825b.nIu.setBackground(null);
                            c15825b.zjU.setBackgroundResource(C25738R.drawable.a_q);
                        }
                        c15825b.zjU.setPadding(paddingLeft, 0, 0, 0);
                        C40460b.m69434b(c15825b.eks, c40629f.field_username);
                        if (c40629f.field_verifyFlag != 0) {
                            c15825b.nIu.setMaskBitmap(null);
                        } else if (C26417a.flw != null) {
                            b3 = C26417a.flw.mo37873kz(c40629f.field_verifyFlag);
                            if (b3 != null) {
                                c15825b.nIu.setMaskBitmap(C8935m.m16106rk(b3));
                            } else {
                                c15825b.nIu.setMaskBitmap(null);
                            }
                        } else {
                            c15825b.nIu.setMaskBitmap(null);
                        }
                        c15825b.nIu.updateTextColors();
                        charSequence = c40629f.xHQ;
                        if (charSequence != null) {
                            try {
                                if (C7616ad.aox(c40629f.field_username)) {
                                    charSequence = ((C32873b) C1720g.m3528K(C32873b.class)).mo44308e(C4996ah.getContext(), c40629f.mo64094Oj(), C1338a.m2856al(this.context, C25738R.dimen.f9980m5));
                                } else {
                                    Context context2 = this.context;
                                    charSequence = c40629f.mo64094Oj();
                                    String str = c40629f.field_username;
                                    if (charSequence == null || charSequence.length() <= 0) {
                                        b2 = str;
                                    }
                                    str = "";
                                    if (str.length() > 0 && !str.equals(charSequence)) {
                                        this.f2990sb.append(charSequence);
                                        this.f2990sb.append("(");
                                        this.f2990sb.append(str);
                                        this.f2990sb.append(")");
                                        charSequence = this.f2990sb.toString();
                                        this.f2990sb.delete(0, this.f2990sb.length());
                                    }
                                    charSequence = C44089j.m79294b(context2, charSequence, C1338a.m2856al(this.context, C25738R.dimen.f9980m5));
                                }
                            } catch (Exception e) {
                                charSequence = null;
                            }
                            if (charSequence == null) {
                                charSequence = "";
                            }
                            c15825b.nIu.setName(charSequence);
                        } else {
                            c15825b.nIu.setName(charSequence);
                        }
                        c15825b.nIu.setDescription(C42252ah.nullAsNil(c40629f.field_remarkDesc));
                        mo28031a(c40629f, c15825b);
                        C29210a.m46386b(0, (String) c15825b.eks.getTag(), (AvatarImageView) c15825b.eks);
                        ((AvatarImageView) c15825b.eks).mo70201dk(c40629f.field_username, 0);
                        ((AvatarImageView) c15825b.eks).setTag(c40629f.field_username);
                        C29210a.m46385a(0, c40629f.field_username, (AvatarImageView) c15825b.eks);
                        ((AvatarImageView) c15825b.eks).setShowStoryHint(C39732a.m67943Xt(c40629f.field_username));
                    }
                }
                c15825b.zjX.setVisibility(8);
                c15825b.nBN.setVisibility(8);
                c15825b.zjW.setVisibility(8);
                b = mo28035b(c40629f, i);
                if (c40629f3 != null) {
                }
                paddingLeft = c15825b.zjU.getPaddingLeft();
                if (b != null) {
                }
                c15825b.nIu.setBackgroundResource(C25738R.drawable.a_q);
                c15825b.zjU.setBackground(null);
                c15825b.zjU.setPadding(paddingLeft, 0, 0, 0);
                C40460b.m69434b(c15825b.eks, c40629f.field_username);
                if (c40629f.field_verifyFlag != 0) {
                }
                c15825b.nIu.updateTextColors();
                charSequence = c40629f.xHQ;
                if (charSequence != null) {
                }
                c15825b.nIu.setDescription(C42252ah.nullAsNil(c40629f.field_remarkDesc));
                mo28031a(c40629f, c15825b);
                C29210a.m46386b(0, (String) c15825b.eks.getTag(), (AvatarImageView) c15825b.eks);
                ((AvatarImageView) c15825b.eks).mo70201dk(c40629f.field_username, 0);
                ((AvatarImageView) c15825b.eks).setTag(c40629f.field_username);
                C29210a.m46385a(0, c40629f.field_username, (AvatarImageView) c15825b.eks);
                ((AvatarImageView) c15825b.eks).setShowStoryHint(C39732a.m67943Xt(c40629f.field_username));
            }
            c15825b.nIu.updatePositionFlag();
            c15825b.nIu.setContentDescription(c15825b.nIu.getNickName() == null ? "" : c15825b.nIu.getNickName().toString());
            c15825b.eks.setOnClickListener(new C158261());
            AppMethodBeat.m2505o(33468);
        }
        return view;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo28031a(C40629f c40629f, C15825b c15825b) {
        AppMethodBeat.m2504i(33469);
        try {
            c15825b.zjV.setText(null);
            c15825b.zjV.setVisibility(8);
            if (C7616ad.aox(c40629f.field_username)) {
                String ba = ((C32873b) C1720g.m3528K(C32873b.class)).mo44306ba(c40629f.field_openImAppid, c40629f.field_descWordingId);
                if (ba != null && ba.length() > 0) {
                    c15825b.zjV.setVisibility(0);
                    c15825b.zjV.setText(ba);
                }
            }
            AppMethodBeat.m2505o(33469);
        } catch (Throwable th) {
            AppMethodBeat.m2505o(33469);
        }
    }

    static {
        AppMethodBeat.m2504i(33482);
        AppMethodBeat.m2505o(33482);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public int mo28030a(C40629f c40629f, int i) {
        AppMethodBeat.m2504i(33470);
        if (i < this.zjG) {
            AppMethodBeat.m2505o(33470);
            return 32;
        } else if (c40629f == null) {
            C4990ab.m7413e("MicroMsg.AddressAdapter", "contact is null, position:%d", Integer.valueOf(i));
            AppMethodBeat.m2505o(33470);
            return -1;
        } else {
            int i2 = c40629f.field_showHead;
            AppMethodBeat.m2505o(33470);
            return i2;
        }
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: b */
    public String mo28035b(C40629f c40629f, int i) {
        AppMethodBeat.m2504i(33471);
        String string;
        if (i < this.zjG) {
            string = getString(C25738R.string.f8752e0);
            AppMethodBeat.m2505o(33471);
            return string;
        } else if (c40629f.field_showHead == 31) {
            string = "";
            AppMethodBeat.m2505o(33471);
            return string;
        } else if (c40629f.field_showHead == 123) {
            string = "#";
            AppMethodBeat.m2505o(33471);
            return string;
        } else if (c40629f.field_showHead == 33) {
            string = getString(C25738R.string.f8734dh);
            AppMethodBeat.m2505o(33471);
            return string;
        } else if (c40629f.field_showHead == 43) {
            string = getString(C25738R.string.dso);
            AppMethodBeat.m2505o(33471);
            return string;
        } else if (c40629f.field_showHead == 32) {
            string = getString(C25738R.string.f8752e0);
            AppMethodBeat.m2505o(33471);
            return string;
        } else {
            string = (String) this.zjP.get(c40629f.field_showHead);
            if (string != null) {
                AppMethodBeat.m2505o(33471);
                return string;
            }
            string = String.valueOf((char) c40629f.field_showHead);
            this.zjP.put(c40629f.field_showHead, string);
            AppMethodBeat.m2505o(33471);
            return string;
        }
    }

    public int getCount() {
        AppMethodBeat.m2504i(33472);
        int count = super.getCount();
        AppMethodBeat.m2505o(33472);
        return count;
    }

    private String getString(int i) {
        AppMethodBeat.m2504i(33473);
        String str = (String) this.zjP.get(i);
        if (str == null) {
            str = this.context.getString(i);
            this.zjP.put(i, str);
        }
        AppMethodBeat.m2505o(33473);
        return str;
    }

    public final C1354d<String> dwz() {
        AppMethodBeat.m2504i(33474);
        C1354d c1354d = (C1354d) dHv();
        AppMethodBeat.m2505o(33474);
        return c1354d;
    }

    /* renamed from: ao */
    public final ArrayList<C40629f> mo28034ao(ArrayList<String> arrayList) {
        AppMethodBeat.m2504i(33475);
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
        C9638aw.m17190ZK();
        Cursor ev = C18628c.m29078XM().mo15759ev(arrayList2);
        while (ev.moveToNext()) {
            C40629f c40629f = new C40629f();
            c40629f.mo64095d(ev);
            arrayList3.add(c40629f);
        }
        ev.close();
        C4990ab.m7410d("MicroMsg.AddressAdapter", "rebulidAllChangeData :" + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(33475);
        return arrayList3;
    }

    /* renamed from: a */
    public final SparseArray<String>[] mo28033a(HashSet<C15880b<String, C40629f>> hashSet, SparseArray<String>[] sparseArrayArr) {
        AppMethodBeat.m2504i(33476);
        SparseArray[] sparseArrayArr2 = new SparseArray[sparseArrayArr.length];
        LinkedList linkedList = new LinkedList();
        linkedList.add("weixin");
        long currentTimeMillis = System.currentTimeMillis();
        C9638aw.m17190ZK();
        Cursor b = C18628c.m29078XM().mo15727b(this.zjx, this.zjy, this.elZ, linkedList, dHu(), this.zjJ);
        int i;
        if (b instanceof C37629e) {
            C1354d[] c1354dArr = ((C37629e) b).ycs;
            int length = c1354dArr.length;
            for (int i2 = 0; i2 < length; i2++) {
                c1354dArr[i2].mo4716MH(5000);
                sparseArrayArr2[i2] = new SparseArray();
                i = 0;
                while (c1354dArr[i2].moveToNext()) {
                    sparseArrayArr2[i2].put(i, c1354dArr[i2].getString(0));
                    i++;
                }
            }
            this.zjG = c1354dArr[0].getCount();
        } else {
            sparseArrayArr2[0] = new SparseArray();
            i = 0;
            while (b.moveToNext()) {
                sparseArrayArr2[0].put(i, b.getString(0));
                i++;
            }
        }
        b.close();
        C4990ab.m7410d("MicroMsg.AddressAdapter", "refreshPosistion last :" + (System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.m2505o(33476);
        return sparseArrayArr2;
    }

    public final void dHy() {
        AppMethodBeat.m2504i(33477);
        super.mo28048j(null, 1);
        AppMethodBeat.m2505o(33477);
    }

    /* renamed from: a */
    public void mo10136a(int i, C7298n c7298n, Object obj) {
        AppMethodBeat.m2504i(33478);
        if (obj == null || !(obj instanceof String)) {
            C4990ab.m7411d("MicroMsg.AddressAdapter", "onNotifyChange obj not String event:%d stg:%s obj:%s", Integer.valueOf(i), c7298n, obj);
            AppMethodBeat.m2505o(33478);
            return;
        }
        C9638aw.m17190ZK();
        if (c7298n == C18628c.m29078XM()) {
            if (C1855t.m3911mX((String) obj) || this.zjR.contains((String) obj)) {
                C4990ab.m7410d("MicroMsg.AddressAdapter", "newcursor is stranger ，return");
            } else {
                super.mo28048j((String) obj, 2);
                if (this.zjK && this.zjE != null) {
                    this.zjE.zks = true;
                    C4990ab.m7410d("MicroMsg.AddressAdapter", "ADDRESS onNotifyChange");
                    AppMethodBeat.m2505o(33478);
                    return;
                }
            }
        }
        AppMethodBeat.m2505o(33478);
    }

    /* renamed from: t */
    private static void m24178t(Cursor cursor) {
        AppMethodBeat.m2504i(33479);
        if (cursor instanceof C37629e) {
            ArrayList arrayList = new ArrayList();
            Cursor cursor2 = ((C37629e) cursor).ycs[0];
            int position = cursor2.getPosition();
            if (cursor2 != null) {
                while (cursor2.moveToNext()) {
                    C40629f c40629f = new C40629f();
                    c40629f.mo64095d(cursor2);
                    arrayList.add(c40629f.field_username);
                    C4990ab.m7411d("MicroMsg.AddressAdapter", "mStarUserList add %s %s", c40629f.field_username, c40629f.field_conRemark);
                }
                cursor2.moveToPosition(position);
            }
            ((C35168e) C1720g.m3530M(C35168e.class)).getFavourUserChecker().mo8983dE(arrayList);
        }
        AppMethodBeat.m2505o(33479);
    }

    public final /* synthetic */ C1351a dvz() {
        AppMethodBeat.m2504i(33481);
        C40629f c40629f = new C40629f();
        AppMethodBeat.m2505o(33481);
        return c40629f;
    }
}
