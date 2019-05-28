package com.tencent.p177mm.plugin.game.p433ui;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.memory.p259a.C26399b;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C46692p;
import com.tencent.p177mm.plugin.game.model.C28229n;
import com.tencent.p177mm.plugin.game.model.C28229n.C28233i;
import com.tencent.p177mm.plugin.game.model.C43192o;
import com.tencent.p177mm.plugin.game.model.C43192o.C12173a;
import com.tencent.p177mm.plugin.game.model.C46012r;
import com.tencent.p177mm.plugin.game.p1268a.C45983c;
import com.tencent.p177mm.plugin.game.p428f.C28203e;
import com.tencent.p177mm.plugin.game.p428f.C28203e.C20965b;
import com.tencent.p177mm.plugin.game.p428f.C28203e.C28207a.C12125a;
import com.tencent.p177mm.plugin.game.p428f.C39204b;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C44089j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.game.ui.n */
public final class C43207n extends C46692p<C28229n> {
    private static C39241w nkH;
    private int csm = 0;
    private int enb = 0;
    private int kmW = 15;
    private Context mContext;
    private int mXC = 0;
    private OnClickListener nkI;
    private OnClickListener nkJ;
    private C46018v nkK;
    private C46018v nkL;
    private long nkM = 0;
    private int nkN = 0;
    private C43192o nkO;
    private C1177f<String, Bitmap> nkP;

    /* renamed from: com.tencent.mm.plugin.game.ui.n$a */
    static class C21033a {
        public TextView ejp;
        public TextView iqU;
        public LinearLayout nkR;
        public ImageView nkS;
        public LinearLayout nkT;
        public ImageView nkU;
        public TextView nkV;
        public LinearLayout nkW;
        public TextView nkX;
        public ImageView nkY;
        public ImageView nkZ;
        public TextView nla;
        public TextView nlb;
        public LinearLayout nlc;
        public GameMessageListContainerView nld;

        C21033a() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.m2504i(112081);
        C28229n wL = m76841wL(i);
        AppMethodBeat.m2505o(112081);
        return wL;
    }

    public C43207n(Context context, C28229n c28229n, int i) {
        int i2;
        int i3 = 0;
        super(context, c28229n);
        AppMethodBeat.m2504i(112068);
        this.mContext = context;
        this.mXC = i;
        Cursor rawQuery = ((C45983c) C1720g.m3528K(C45983c.class)).bCY().rawQuery("select count(*) from GameRawMessage where " + C46012r.m85504v(2, 5, 6, 10, 11, 100) + " and showInMsgList = 1 and isHidden = 0", new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                i2 = rawQuery.getInt(0);
            } else {
                i2 = 0;
            }
            rawQuery.close();
            i3 = i2;
        }
        this.enb = i3;
        this.csm = ((C45983c) C1720g.m3528K(C45983c.class)).bCY().bEw();
        nkH = new C39241w();
        this.nkI = new C43208o(context, i);
        this.nkJ = new C43209p(context, i);
        this.nkK = new C46018v(context);
        this.nkK.mo73919em(i, 1);
        this.nkL = new C46018v(context);
        this.nkL.mo73919em(i, 2);
        this.nkO = new C43192o(context, this.mXC);
        i2 = C46001c.getScreenWidth(this.mContext);
        this.nkN = C1338a.m2859ao(this.mContext, ((i2 - (this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9732dy) * 2)) - this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9918k4)) - this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f9966lo)) / 34;
        this.nkP = new C26399b(30, getClass());
        AppMethodBeat.m2505o(112068);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        C21033a c21033a;
        AppMethodBeat.m2504i(112069);
        if (view == null) {
            C21033a c21033a2 = new C21033a();
            view = View.inflate(this.context, 2130969755, null);
            c21033a2.nkS = (ImageView) view.findViewById(2131821226);
            c21033a2.nkR = (LinearLayout) view.findViewById(2131824055);
            c21033a2.nkT = (LinearLayout) view.findViewById(2131824572);
            c21033a2.ejp = (TextView) view.findViewById(2131823149);
            c21033a2.nkU = (ImageView) view.findViewById(2131824382);
            c21033a2.iqU = (TextView) view.findViewById(2131823800);
            c21033a2.nkV = (TextView) view.findViewById(2131824573);
            c21033a2.nkW = (LinearLayout) view.findViewById(2131824575);
            c21033a2.nkX = (TextView) view.findViewById(2131824577);
            c21033a2.nkY = (ImageView) view.findViewById(2131824576);
            c21033a2.nkZ = (ImageView) view.findViewById(2131824578);
            c21033a2.nla = (TextView) view.findViewById(2131824579);
            c21033a2.nlb = (TextView) view.findViewById(2131824580);
            c21033a2.nld = (GameMessageListContainerView) view.findViewById(2131824574);
            c21033a2.nlc = (LinearLayout) view.findViewById(2131824581);
            view.setTag(c21033a2);
            c21033a = c21033a2;
        } else {
            c21033a = (C21033a) view.getTag();
        }
        C28229n wL = m76841wL(i);
        if (wL == null || !wL.mXf) {
            if (wL != null) {
                wL.bEl();
                c21033a.nkR.setVisibility(0);
                c21033a.nlc.setVisibility(8);
                c21033a.nla.setText(C39204b.m66794h(this.context, wL.field_createTime * 1000));
                C28233i c28233i;
                C7616ad aoO;
                CharSequence Oj;
                if (wL.field_msgType != 100) {
                    Object obj;
                    c21033a.iqU.setVisibility(8);
                    c21033a.nkV.setVisibility(8);
                    c21033a.nkW.setVisibility(8);
                    c21033a.nkY.setVisibility(8);
                    c21033a.nkZ.setVisibility(8);
                    c21033a.nlb.setVisibility(8);
                    c21033a.nlb.setEnabled(false);
                    c21033a.nkZ.setEnabled(false);
                    c21033a.nkS.setEnabled(false);
                    c21033a.ejp.setEnabled(false);
                    c21033a.nld.setVisibility(8);
                    c21033a.nkU.setVisibility(8);
                    Object obj2;
                    if (C5046bo.m7548ek(wL.mWp)) {
                        obj = null;
                        obj2 = null;
                    } else {
                        c28233i = (C28233i) wL.mWp.get(0);
                        aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c28233i.userName);
                        if (aoO != null) {
                            Oj = aoO.mo16707Oj();
                        } else {
                            obj2 = null;
                        }
                        if (C5046bo.isNullOrNil(Oj)) {
                            Oj = c28233i.bCu;
                        }
                        obj = !C5046bo.isNullOrNil(c28233i.mXv) ? 1 : null;
                    }
                    int size = wL.mWp.size();
                    if (!C5046bo.isNullOrNil(wL.mWn) && (wL.mWD & 1) == 0) {
                        c21033a.nlb.setText(wL.mWn);
                        c21033a.nlb.setVisibility(0);
                        if ((wL.mWD & 2) > 0) {
                            c21033a.nlb.setTextColor(this.context.getResources().getColor(C25738R.color.f12048qk));
                            c21033a.nlb.setBackgroundResource(C25738R.drawable.f6746p1);
                            c21033a.nlb.setOnClickListener(this.nkI);
                            c21033a.nlb.setTag(wL);
                            c21033a.nlb.setEnabled(true);
                        } else {
                            c21033a.nlb.setTextColor(this.context.getResources().getColor(C25738R.color.f12032q3));
                            c21033a.nlb.setBackgroundResource(0);
                            c21033a.nlb.setOnClickListener(null);
                            c21033a.nlb.setEnabled(false);
                        }
                    }
                    if (wL.field_msgType == 10 || wL.field_msgType == 11) {
                        if (!C5046bo.isNullOrNil(wL.mAppName)) {
                            c21033a.ejp.setText(C44089j.m79293b(this.context, wL.mAppName, c21033a.ejp.getTextSize()), BufferType.SPANNABLE);
                            c21033a.ejp.setVisibility(0);
                        } else if (C5046bo.isNullOrNil(Oj)) {
                            c21033a.ejp.setVisibility(8);
                        } else {
                            c21033a.ejp.setText(C44089j.m79293b(this.context, Oj, c21033a.ejp.getTextSize()));
                            c21033a.ejp.setVisibility(0);
                        }
                    } else if (C5046bo.isNullOrNil(Oj)) {
                        c21033a.ejp.setVisibility(8);
                    } else {
                        c21033a.ejp.setText(C44089j.m79293b(this.context, Oj, c21033a.ejp.getTextSize()));
                        c21033a.ejp.setVisibility(0);
                        if (obj != null) {
                            c21033a.ejp.setOnClickListener(this.nkK);
                            c21033a.ejp.setTag(wL);
                            c21033a.ejp.setEnabled(true);
                        }
                    }
                    switch (wL.field_msgType) {
                        case 2:
                            m76839f(c21033a.nkS, wL.mWj);
                            String str = "礼物";
                            if (wL.mWA.contains("爱心")) {
                                str = "爱心";
                            } else if (wL.mWA.contains("体力")) {
                                str = "体力";
                            }
                            if (size > 1) {
                                c21033a.iqU.setText(this.context.getResources().getString(C25738R.string.c7a, new Object[]{String.valueOf(size), str}));
                            } else {
                                c21033a.iqU.setText(this.context.getResources().getString(C25738R.string.c7b, new Object[]{str}));
                            }
                            c21033a.iqU.setVisibility(0);
                            m76836a(wL, c21033a);
                            break;
                        case 5:
                            if (C5046bo.m7548ek(wL.mWp)) {
                                c21033a.nkS.setVisibility(8);
                            } else {
                                c21033a.nkS.setVisibility(0);
                                if (C5046bo.isNullOrNil(((C28233i) wL.mWp.get(0)).mXu)) {
                                    m76837d(c21033a.nkS, ((C28233i) wL.mWp.get(0)).userName);
                                } else {
                                    m76839f(c21033a.nkS, ((C28233i) wL.mWp.get(0)).mXu);
                                }
                                if (!C5046bo.isNullOrNil(((C28233i) wL.mWp.get(0)).mXv)) {
                                    c21033a.nkS.setOnClickListener(this.nkL);
                                    c21033a.nkS.setTag(wL);
                                    c21033a.nkS.setEnabled(true);
                                }
                            }
                            if (size > 1) {
                                c21033a.iqU.setText(this.context.getResources().getString(C25738R.string.c79, new Object[]{String.valueOf(size)}));
                                m76836a(wL, c21033a);
                            } else {
                                c21033a.iqU.setText(this.context.getResources().getString(C25738R.string.c7_));
                            }
                            c21033a.nkW.setVisibility(0);
                            c21033a.iqU.setVisibility(0);
                            c21033a.nkX.setText(wL.mWL);
                            c21033a.nkW.setOnClickListener(this.nkJ);
                            c21033a.nkW.setTag(Long.valueOf(wL.field_msgId));
                            if (!C5046bo.isNullOrNil(wL.mWN)) {
                                c21033a.nkY.setVisibility(0);
                                m76839f(c21033a.nkY, wL.mWN);
                                break;
                            }
                            break;
                        case 6:
                            if (C5046bo.m7548ek(wL.mWp)) {
                                c21033a.nkS.setVisibility(8);
                            } else {
                                c21033a.nkS.setVisibility(0);
                                if (C5046bo.isNullOrNil(((C28233i) wL.mWp.get(0)).mXu)) {
                                    m76837d(c21033a.nkS, ((C28233i) wL.mWp.get(0)).userName);
                                } else {
                                    m76839f(c21033a.nkS, ((C28233i) wL.mWp.get(0)).mXu);
                                }
                                if (!C5046bo.isNullOrNil(((C28233i) wL.mWp.get(0)).mXv)) {
                                    c21033a.nkS.setOnClickListener(this.nkL);
                                    c21033a.nkS.setTag(wL);
                                    c21033a.nkS.setEnabled(true);
                                }
                            }
                            c21033a.nkW.setVisibility(0);
                            c21033a.nkW.setOnClickListener(this.nkJ);
                            c21033a.nkW.setTag(Long.valueOf(wL.field_msgId));
                            if (wL.mXa != 1) {
                                if (wL.mXa != 2) {
                                    if (wL.mXa == 3) {
                                        c21033a.iqU.setVisibility(0);
                                        if (size > 1) {
                                            c21033a.iqU.setText(this.context.getResources().getString(C25738R.string.c77, new Object[]{String.valueOf(size)}));
                                            m76836a(wL, c21033a);
                                        } else {
                                            c21033a.iqU.setText(this.context.getResources().getString(C25738R.string.c78));
                                        }
                                        c21033a.nkX.setText(wL.mWK);
                                        break;
                                    }
                                }
                                c21033a.nkV.setVisibility(0);
                                c21033a.nkV.setText(C44089j.m79293b(this.context, wL.mWH, c21033a.nkV.getTextSize()));
                                c21033a.nkX.setText(wL.mWI);
                                break;
                            }
                            c21033a.nkV.setVisibility(0);
                            c21033a.nkV.setText(C44089j.m79293b(this.context, wL.mWH, c21033a.nkV.getTextSize()));
                            c21033a.nkX.setText(wL.mWK);
                            break;
                            break;
                        case 10:
                        case 11:
                            if (C5046bo.isNullOrNil(wL.mWj)) {
                                C4990ab.m7412e("MicroMsg.GameMessageAdapter", "mAppIcon is null");
                                c21033a.nkS.setVisibility(8);
                            } else {
                                m76839f(c21033a.nkS, wL.mWj);
                                c21033a.nkS.setVisibility(0);
                            }
                            if (!C5046bo.isNullOrNil(wL.kYQ)) {
                                if (C5046bo.isNullOrNil(wL.mWv)) {
                                    c21033a.nkW.setVisibility(0);
                                    c21033a.nkX.setText(wL.kYQ);
                                    c21033a.nkW.setOnClickListener(this.nkJ);
                                    c21033a.nkW.setTag(Long.valueOf(wL.field_msgId));
                                } else {
                                    c21033a.nkV.setText(wL.kYQ);
                                    c21033a.nkV.setVisibility(0);
                                }
                            }
                            if (!C5046bo.isNullOrNil(wL.mWv)) {
                                m76839f(c21033a.nkZ, wL.mWv);
                                c21033a.nkZ.setTag(Long.valueOf(wL.field_msgId));
                                c21033a.nkZ.setOnTouchListener(nkH);
                                c21033a.nkZ.setOnClickListener(this.nkJ);
                                c21033a.nkZ.setVisibility(0);
                                c21033a.nkZ.setEnabled(true);
                                break;
                            }
                            break;
                        default:
                            C4990ab.m7412e("MicroMsg.GameMessageAdapter", "error msgtype: " + wL.field_msgType);
                            break;
                    }
                }
                if (wL.mWT != null) {
                    m76839f(c21033a.nkS, wL.mWT.mXr);
                    c21033a.nkS.setVisibility(0);
                    if (C5046bo.isNullOrNil(wL.mWT.mXq)) {
                        c21033a.ejp.setVisibility(8);
                    } else {
                        c21033a.ejp.setText(wL.mWT.mXq);
                        c21033a.ejp.setVisibility(0);
                    }
                    if (C5046bo.isNullOrNil(wL.mWT.mXs)) {
                        c21033a.nkU.setVisibility(8);
                    } else {
                        m76839f(c21033a.nkU, wL.mWT.mXs);
                        c21033a.nkU.setVisibility(0);
                    }
                    if (C5046bo.isNullOrNil(wL.mWT.mXk)) {
                        c21033a.ejp.setEnabled(false);
                        c21033a.nkS.setEnabled(false);
                    } else {
                        c21033a.ejp.setEnabled(true);
                        c21033a.nkS.setEnabled(true);
                        C12173a c12173a = new C12173a(wL, wL.mWT.mXk, 1);
                        C12173a c12173a2 = new C12173a(wL, wL.mWT.mXk, 2);
                        c21033a.ejp.setTag(c12173a);
                        c21033a.ejp.setOnClickListener(this.nkO);
                        c21033a.nkS.setTag(c12173a2);
                        c21033a.nkS.setOnClickListener(this.nkO);
                    }
                } else if (C5046bo.m7548ek(wL.mWp)) {
                    c21033a.nkS.setVisibility(8);
                    c21033a.ejp.setVisibility(8);
                    c21033a.nkU.setVisibility(8);
                } else {
                    c28233i = (C28233i) wL.mWp.get(0);
                    if (C5046bo.isNullOrNil(c28233i.bCu)) {
                        aoO = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(c28233i.userName);
                        if (aoO == null || C5046bo.isNullOrNil(aoO.mo16707Oj())) {
                            Oj = c28233i.userName;
                        } else {
                            Oj = aoO.mo16707Oj();
                        }
                    } else {
                        Oj = c28233i.bCu;
                    }
                    if (C5046bo.isNullOrNil(c28233i.mXx)) {
                        c21033a.ejp.setEnabled(false);
                        c21033a.nkS.setEnabled(false);
                    } else {
                        c21033a.ejp.setEnabled(true);
                        c21033a.nkS.setEnabled(true);
                        C12173a c12173a3 = new C12173a(wL, c28233i.mXx, 1);
                        C12173a c12173a4 = new C12173a(wL, c28233i.mXx, 2);
                        c21033a.ejp.setTag(c12173a3);
                        c21033a.ejp.setOnClickListener(this.nkO);
                        c21033a.nkS.setTag(c12173a4);
                        c21033a.nkS.setOnClickListener(this.nkO);
                    }
                    if (C5046bo.isNullOrNil(Oj)) {
                        c21033a.ejp.setVisibility(8);
                    } else {
                        c21033a.ejp.setText(C44089j.m79293b(this.context, Oj, c21033a.ejp.getTextSize()), BufferType.SPANNABLE);
                        c21033a.ejp.setVisibility(0);
                    }
                    c21033a.nkS.setVisibility(0);
                    if (C5046bo.isNullOrNil(c28233i.mXu)) {
                        m76837d(c21033a.nkS, c28233i.userName);
                    } else {
                        m76839f(c21033a.nkS, c28233i.mXu);
                    }
                    if (C5046bo.isNullOrNil(c28233i.mXw)) {
                        c21033a.nkU.setVisibility(8);
                    } else {
                        m76839f(c21033a.nkU, c28233i.mXw);
                        c21033a.nkU.setVisibility(0);
                    }
                }
                if (C5046bo.isNullOrNil(wL.mWP)) {
                    c21033a.iqU.setVisibility(8);
                } else {
                    if (wL.mWp.size() > 1) {
                        c21033a.iqU.setText(this.context.getResources().getString(C25738R.string.c7c, new Object[]{Integer.valueOf(wL.mWp.size())}) + wL.mWP);
                    } else {
                        c21033a.iqU.setText(wL.mWP);
                    }
                    c21033a.iqU.setVisibility(0);
                }
                if (C5046bo.isNullOrNil(wL.mWQ)) {
                    c21033a.nkV.setVisibility(8);
                } else {
                    c21033a.nkV.setText(C44089j.m79293b(this.context, wL.mWQ, c21033a.nkV.getTextSize()));
                    c21033a.nkV.setVisibility(0);
                }
                m76836a(wL, c21033a);
                if (C5046bo.isNullOrNil(wL.mWU.mXp)) {
                    c21033a.nkW.setVisibility(8);
                } else {
                    c21033a.nkW.setVisibility(0);
                    if (C5046bo.isNullOrNil(wL.mWU.mXk)) {
                        c21033a.nkW.setEnabled(false);
                    } else {
                        c21033a.nkW.setTag(new C12173a(wL, wL.mWU.mXk, 3));
                        c21033a.nkW.setOnClickListener(this.nkO);
                        c21033a.nkW.setEnabled(true);
                    }
                    c21033a.nkX.setText(C44089j.m79293b(this.context, wL.mWU.mXp, c21033a.nkX.getTextSize()));
                    if (C5046bo.isNullOrNil(wL.mWU.mXj)) {
                        c21033a.nkY.setVisibility(8);
                    } else {
                        m76839f(c21033a.nkY, wL.mWU.mXj);
                        c21033a.nkY.setVisibility(0);
                    }
                }
                if (C5046bo.isNullOrNil(wL.mWR)) {
                    c21033a.nkZ.setVisibility(8);
                } else {
                    m76839f(c21033a.nkZ, wL.mWR);
                    c21033a.nkZ.setVisibility(0);
                    if (C5046bo.isNullOrNil(wL.mWS)) {
                        c21033a.nkZ.setEnabled(false);
                    } else {
                        c21033a.nkZ.setTag(new C12173a(wL, wL.mWS, 3));
                        c21033a.nkZ.setOnClickListener(this.nkO);
                        c21033a.nkZ.setEnabled(true);
                    }
                }
                if (C5046bo.isNullOrNil(wL.mWV.mName)) {
                    c21033a.nlb.setVisibility(8);
                } else {
                    c21033a.nlb.setText(wL.mWV.mName);
                    c21033a.nlb.setVisibility(0);
                    if (C5046bo.isNullOrNil(wL.mWV.mXk)) {
                        c21033a.nlb.setEnabled(false);
                    } else {
                        c21033a.nlb.setTag(new C12173a(wL, wL.mWV.mXk, 5));
                        c21033a.nlb.setOnClickListener(this.nkO);
                        c21033a.nlb.setEnabled(true);
                    }
                }
                AppMethodBeat.m2505o(112069);
                return view;
            }
        }
        c21033a.nkR.setVisibility(8);
        c21033a.nlc.setVisibility(0);
        AppMethodBeat.m2505o(112069);
        return view;
    }

    /* renamed from: a */
    private void m76836a(C28229n c28229n, C21033a c21033a) {
        AppMethodBeat.m2504i(112070);
        LinkedList linkedList = new LinkedList();
        for (int i = 1; i < c28229n.mWp.size(); i++) {
            linkedList.add(c28229n.mWp.get(i));
        }
        c21033a.nld.mo54842a(c28229n, linkedList, this.nkN, this.mXC, this.nkP);
        AppMethodBeat.m2505o(112070);
    }

    /* renamed from: d */
    private void m76837d(ImageView imageView, String str) {
        AppMethodBeat.m2504i(112071);
        if (C5046bo.isNullOrNil(str)) {
            C40460b.m69434b(imageView, str);
            AppMethodBeat.m2505o(112071);
        } else if (this.nkP.mo4405aj(str)) {
            Bitmap bitmap = (Bitmap) this.nkP.get(str);
            if (bitmap == null || bitmap.isRecycled()) {
                m76838e(imageView, str);
                AppMethodBeat.m2505o(112071);
                return;
            }
            imageView.setImageBitmap(bitmap);
            AppMethodBeat.m2505o(112071);
        } else {
            m76838e(imageView, str);
            AppMethodBeat.m2505o(112071);
        }
    }

    /* renamed from: e */
    private void m76838e(ImageView imageView, String str) {
        AppMethodBeat.m2504i(112072);
        Bitmap j = C28203e.bFH().mo46102j(imageView, str);
        if (j != null) {
            this.nkP.put(str, j);
        }
        AppMethodBeat.m2505o(112072);
    }

    /* renamed from: f */
    private void m76839f(ImageView imageView, String str) {
        AppMethodBeat.m2504i(112073);
        if (this.nkP.mo4405aj(str)) {
            Bitmap bitmap = (Bitmap) this.nkP.get(str);
            if (bitmap == null || bitmap.isRecycled()) {
                m76840g(imageView, str);
                AppMethodBeat.m2505o(112073);
                return;
            }
            imageView.setImageBitmap(bitmap);
            AppMethodBeat.m2505o(112073);
            return;
        }
        m76840g(imageView, str);
        AppMethodBeat.m2505o(112073);
    }

    /* renamed from: g */
    private void m76840g(ImageView imageView, final String str) {
        AppMethodBeat.m2504i(112074);
        C12125a c12125a = new C12125a();
        c12125a.ePF = false;
        C28203e.bFH().mo46099a(imageView, str, c12125a.bFI(), new C20965b() {
            /* renamed from: a */
            public final void mo36291a(View view, Bitmap bitmap) {
                AppMethodBeat.m2504i(112067);
                if (!(bitmap == null || bitmap.isRecycled())) {
                    C43207n.this.nkP.put(str, bitmap);
                }
                AppMethodBeat.m2505o(112067);
            }
        });
        AppMethodBeat.m2505o(112074);
    }

    /* renamed from: KC */
    public final void mo6869KC() {
        AppMethodBeat.m2504i(112075);
        setCursor(((C45983c) C1720g.m3528K(C45983c.class)).bCY().rawQuery("select * from GameRawMessage where " + C46012r.m85504v(2, 5, 6, 10, 11, 100) + " and showInMsgList = 1 and isHidden = 0 order by isRead, createTime desc limit " + this.kmW, new String[0]));
        this.kmW = getCount();
        if (this.yle != null) {
            this.yle.apt();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.m2505o(112075);
    }

    /* renamed from: KD */
    public final void mo6870KD() {
        AppMethodBeat.m2504i(112076);
        bIf();
        mo6869KC();
        AppMethodBeat.m2505o(112076);
    }

    /* renamed from: a */
    private static C28229n m76835a(C28229n c28229n, Cursor cursor) {
        AppMethodBeat.m2504i(112077);
        if (c28229n == null) {
            c28229n = new C28229n();
        }
        c28229n.mo8995d(cursor);
        AppMethodBeat.m2505o(112077);
        return c28229n;
    }

    public final boolean bdn() {
        return this.kmW >= this.enb;
    }

    public final void bFr() {
        AppMethodBeat.m2504i(112078);
        if (bdn()) {
            if (this.yle != null) {
                this.yle.apt();
            }
            AppMethodBeat.m2505o(112078);
            return;
        }
        this.kmW += 15;
        if (this.kmW > this.enb) {
            this.kmW = this.enb;
        }
        AppMethodBeat.m2505o(112078);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(112079);
        if (this.count < 0) {
            this.count = getCursor().getCount();
        }
        if (this.count <= 0) {
            AppMethodBeat.m2505o(112079);
            return 0;
        }
        int bFs = this.count + bFs();
        AppMethodBeat.m2505o(112079);
        return bFs;
    }

    /* renamed from: wK */
    public final boolean mo10892wK(int i) {
        return this.enb > this.csm && this.csm > 0 && i == this.csm;
    }

    public final int bFs() {
        return (this.enb <= this.csm || this.csm <= 0) ? 0 : 1;
    }

    /* renamed from: wL */
    private C28229n m76841wL(int i) {
        AppMethodBeat.m2504i(112080);
        C28229n c28229n;
        if (mo10892wK(i)) {
            c28229n = (C28229n) this.ylb;
            AppMethodBeat.m2505o(112080);
            return c28229n;
        }
        if (this.yld != null) {
            c28229n = (C28229n) this.yld.get(Integer.valueOf(i));
            if (c28229n != null) {
                AppMethodBeat.m2505o(112080);
                return c28229n;
            }
        }
        int i2;
        if (m76842wM(i)) {
            i2 = i - 1;
        } else {
            i2 = i;
        }
        if (i < 0 || !getCursor().moveToPosition(i2)) {
            AppMethodBeat.m2505o(112080);
            return null;
        } else if (this.yld == null) {
            c28229n = C43207n.m76835a((C28229n) this.ylb, getCursor());
            AppMethodBeat.m2505o(112080);
            return c28229n;
        } else {
            c28229n = C43207n.m76835a(null, getCursor());
            this.yld.put(Integer.valueOf(i), c28229n);
            AppMethodBeat.m2505o(112080);
            return c28229n;
        }
    }

    /* renamed from: wM */
    private boolean m76842wM(int i) {
        return this.enb > this.csm && this.csm > 0 && i > this.csm;
    }

    public final /* bridge */ /* synthetic */ Object bFt() {
        return (C28229n) this.ylb;
    }
}
