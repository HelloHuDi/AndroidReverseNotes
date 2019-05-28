package com.tencent.mm.plugin.game.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.memory.a.b;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.model.n.i;
import com.tencent.mm.plugin.game.model.o;
import com.tencent.mm.plugin.game.model.r;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.p;
import java.util.LinkedList;

public final class n extends p<com.tencent.mm.plugin.game.model.n> {
    private static w nkH;
    private int csm = 0;
    private int enb = 0;
    private int kmW = 15;
    private Context mContext;
    private int mXC = 0;
    private OnClickListener nkI;
    private OnClickListener nkJ;
    private v nkK;
    private v nkL;
    private long nkM = 0;
    private int nkN = 0;
    private o nkO;
    private f<String, Bitmap> nkP;

    static class a {
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

        a() {
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        AppMethodBeat.i(112081);
        com.tencent.mm.plugin.game.model.n wL = wL(i);
        AppMethodBeat.o(112081);
        return wL;
    }

    public n(Context context, com.tencent.mm.plugin.game.model.n nVar, int i) {
        int i2;
        int i3 = 0;
        super(context, nVar);
        AppMethodBeat.i(112068);
        this.mContext = context;
        this.mXC = i;
        Cursor rawQuery = ((c) g.K(c.class)).bCY().rawQuery("select count(*) from GameRawMessage where " + r.v(2, 5, 6, 10, 11, 100) + " and showInMsgList = 1 and isHidden = 0", new String[0]);
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
        this.csm = ((c) g.K(c.class)).bCY().bEw();
        nkH = new w();
        this.nkI = new o(context, i);
        this.nkJ = new p(context, i);
        this.nkK = new v(context);
        this.nkK.em(i, 1);
        this.nkL = new v(context);
        this.nkL.em(i, 2);
        this.nkO = new o(context, this.mXC);
        i2 = com.tencent.mm.plugin.game.f.c.getScreenWidth(this.mContext);
        this.nkN = com.tencent.mm.bz.a.ao(this.mContext, ((i2 - (this.mContext.getResources().getDimensionPixelSize(R.dimen.dy) * 2)) - this.mContext.getResources().getDimensionPixelSize(R.dimen.k4)) - this.mContext.getResources().getDimensionPixelSize(R.dimen.lo)) / 34;
        this.nkP = new b(30, getClass());
        AppMethodBeat.o(112068);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        AppMethodBeat.i(112069);
        if (view == null) {
            a aVar2 = new a();
            view = View.inflate(this.context, R.layout.a52, null);
            aVar2.nkS = (ImageView) view.findViewById(R.id.rq);
            aVar2.nkR = (LinearLayout) view.findViewById(R.id.btw);
            aVar2.nkT = (LinearLayout) view.findViewById(R.id.c7v);
            aVar2.ejp = (TextView) view.findViewById(R.id.b6e);
            aVar2.nkU = (ImageView) view.findViewById(R.id.c2q);
            aVar2.iqU = (TextView) view.findViewById(R.id.bn0);
            aVar2.nkV = (TextView) view.findViewById(R.id.c7w);
            aVar2.nkW = (LinearLayout) view.findViewById(R.id.c7y);
            aVar2.nkX = (TextView) view.findViewById(R.id.c80);
            aVar2.nkY = (ImageView) view.findViewById(R.id.c7z);
            aVar2.nkZ = (ImageView) view.findViewById(R.id.c81);
            aVar2.nla = (TextView) view.findViewById(R.id.c82);
            aVar2.nlb = (TextView) view.findViewById(R.id.c83);
            aVar2.nld = (GameMessageListContainerView) view.findViewById(R.id.c7x);
            aVar2.nlc = (LinearLayout) view.findViewById(R.id.c84);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        com.tencent.mm.plugin.game.model.n wL = wL(i);
        if (wL == null || !wL.mXf) {
            if (wL != null) {
                wL.bEl();
                aVar.nkR.setVisibility(0);
                aVar.nlc.setVisibility(8);
                aVar.nla.setText(com.tencent.mm.plugin.game.f.b.h(this.context, wL.field_createTime * 1000));
                i iVar;
                ad aoO;
                CharSequence Oj;
                if (wL.field_msgType != 100) {
                    Object obj;
                    aVar.iqU.setVisibility(8);
                    aVar.nkV.setVisibility(8);
                    aVar.nkW.setVisibility(8);
                    aVar.nkY.setVisibility(8);
                    aVar.nkZ.setVisibility(8);
                    aVar.nlb.setVisibility(8);
                    aVar.nlb.setEnabled(false);
                    aVar.nkZ.setEnabled(false);
                    aVar.nkS.setEnabled(false);
                    aVar.ejp.setEnabled(false);
                    aVar.nld.setVisibility(8);
                    aVar.nkU.setVisibility(8);
                    Object obj2;
                    if (bo.ek(wL.mWp)) {
                        obj = null;
                        obj2 = null;
                    } else {
                        iVar = (i) wL.mWp.get(0);
                        aoO = ((j) g.K(j.class)).XM().aoO(iVar.userName);
                        if (aoO != null) {
                            Oj = aoO.Oj();
                        } else {
                            obj2 = null;
                        }
                        if (bo.isNullOrNil(Oj)) {
                            Oj = iVar.bCu;
                        }
                        obj = !bo.isNullOrNil(iVar.mXv) ? 1 : null;
                    }
                    int size = wL.mWp.size();
                    if (!bo.isNullOrNil(wL.mWn) && (wL.mWD & 1) == 0) {
                        aVar.nlb.setText(wL.mWn);
                        aVar.nlb.setVisibility(0);
                        if ((wL.mWD & 2) > 0) {
                            aVar.nlb.setTextColor(this.context.getResources().getColor(R.color.qk));
                            aVar.nlb.setBackgroundResource(R.drawable.p1);
                            aVar.nlb.setOnClickListener(this.nkI);
                            aVar.nlb.setTag(wL);
                            aVar.nlb.setEnabled(true);
                        } else {
                            aVar.nlb.setTextColor(this.context.getResources().getColor(R.color.q3));
                            aVar.nlb.setBackgroundResource(0);
                            aVar.nlb.setOnClickListener(null);
                            aVar.nlb.setEnabled(false);
                        }
                    }
                    if (wL.field_msgType == 10 || wL.field_msgType == 11) {
                        if (!bo.isNullOrNil(wL.mAppName)) {
                            aVar.ejp.setText(com.tencent.mm.pluginsdk.ui.e.j.b(this.context, wL.mAppName, aVar.ejp.getTextSize()), BufferType.SPANNABLE);
                            aVar.ejp.setVisibility(0);
                        } else if (bo.isNullOrNil(Oj)) {
                            aVar.ejp.setVisibility(8);
                        } else {
                            aVar.ejp.setText(com.tencent.mm.pluginsdk.ui.e.j.b(this.context, Oj, aVar.ejp.getTextSize()));
                            aVar.ejp.setVisibility(0);
                        }
                    } else if (bo.isNullOrNil(Oj)) {
                        aVar.ejp.setVisibility(8);
                    } else {
                        aVar.ejp.setText(com.tencent.mm.pluginsdk.ui.e.j.b(this.context, Oj, aVar.ejp.getTextSize()));
                        aVar.ejp.setVisibility(0);
                        if (obj != null) {
                            aVar.ejp.setOnClickListener(this.nkK);
                            aVar.ejp.setTag(wL);
                            aVar.ejp.setEnabled(true);
                        }
                    }
                    switch (wL.field_msgType) {
                        case 2:
                            f(aVar.nkS, wL.mWj);
                            String str = "礼物";
                            if (wL.mWA.contains("爱心")) {
                                str = "爱心";
                            } else if (wL.mWA.contains("体力")) {
                                str = "体力";
                            }
                            if (size > 1) {
                                aVar.iqU.setText(this.context.getResources().getString(R.string.c7a, new Object[]{String.valueOf(size), str}));
                            } else {
                                aVar.iqU.setText(this.context.getResources().getString(R.string.c7b, new Object[]{str}));
                            }
                            aVar.iqU.setVisibility(0);
                            a(wL, aVar);
                            break;
                        case 5:
                            if (bo.ek(wL.mWp)) {
                                aVar.nkS.setVisibility(8);
                            } else {
                                aVar.nkS.setVisibility(0);
                                if (bo.isNullOrNil(((i) wL.mWp.get(0)).mXu)) {
                                    d(aVar.nkS, ((i) wL.mWp.get(0)).userName);
                                } else {
                                    f(aVar.nkS, ((i) wL.mWp.get(0)).mXu);
                                }
                                if (!bo.isNullOrNil(((i) wL.mWp.get(0)).mXv)) {
                                    aVar.nkS.setOnClickListener(this.nkL);
                                    aVar.nkS.setTag(wL);
                                    aVar.nkS.setEnabled(true);
                                }
                            }
                            if (size > 1) {
                                aVar.iqU.setText(this.context.getResources().getString(R.string.c79, new Object[]{String.valueOf(size)}));
                                a(wL, aVar);
                            } else {
                                aVar.iqU.setText(this.context.getResources().getString(R.string.c7_));
                            }
                            aVar.nkW.setVisibility(0);
                            aVar.iqU.setVisibility(0);
                            aVar.nkX.setText(wL.mWL);
                            aVar.nkW.setOnClickListener(this.nkJ);
                            aVar.nkW.setTag(Long.valueOf(wL.field_msgId));
                            if (!bo.isNullOrNil(wL.mWN)) {
                                aVar.nkY.setVisibility(0);
                                f(aVar.nkY, wL.mWN);
                                break;
                            }
                            break;
                        case 6:
                            if (bo.ek(wL.mWp)) {
                                aVar.nkS.setVisibility(8);
                            } else {
                                aVar.nkS.setVisibility(0);
                                if (bo.isNullOrNil(((i) wL.mWp.get(0)).mXu)) {
                                    d(aVar.nkS, ((i) wL.mWp.get(0)).userName);
                                } else {
                                    f(aVar.nkS, ((i) wL.mWp.get(0)).mXu);
                                }
                                if (!bo.isNullOrNil(((i) wL.mWp.get(0)).mXv)) {
                                    aVar.nkS.setOnClickListener(this.nkL);
                                    aVar.nkS.setTag(wL);
                                    aVar.nkS.setEnabled(true);
                                }
                            }
                            aVar.nkW.setVisibility(0);
                            aVar.nkW.setOnClickListener(this.nkJ);
                            aVar.nkW.setTag(Long.valueOf(wL.field_msgId));
                            if (wL.mXa != 1) {
                                if (wL.mXa != 2) {
                                    if (wL.mXa == 3) {
                                        aVar.iqU.setVisibility(0);
                                        if (size > 1) {
                                            aVar.iqU.setText(this.context.getResources().getString(R.string.c77, new Object[]{String.valueOf(size)}));
                                            a(wL, aVar);
                                        } else {
                                            aVar.iqU.setText(this.context.getResources().getString(R.string.c78));
                                        }
                                        aVar.nkX.setText(wL.mWK);
                                        break;
                                    }
                                }
                                aVar.nkV.setVisibility(0);
                                aVar.nkV.setText(com.tencent.mm.pluginsdk.ui.e.j.b(this.context, wL.mWH, aVar.nkV.getTextSize()));
                                aVar.nkX.setText(wL.mWI);
                                break;
                            }
                            aVar.nkV.setVisibility(0);
                            aVar.nkV.setText(com.tencent.mm.pluginsdk.ui.e.j.b(this.context, wL.mWH, aVar.nkV.getTextSize()));
                            aVar.nkX.setText(wL.mWK);
                            break;
                            break;
                        case 10:
                        case 11:
                            if (bo.isNullOrNil(wL.mWj)) {
                                ab.e("MicroMsg.GameMessageAdapter", "mAppIcon is null");
                                aVar.nkS.setVisibility(8);
                            } else {
                                f(aVar.nkS, wL.mWj);
                                aVar.nkS.setVisibility(0);
                            }
                            if (!bo.isNullOrNil(wL.kYQ)) {
                                if (bo.isNullOrNil(wL.mWv)) {
                                    aVar.nkW.setVisibility(0);
                                    aVar.nkX.setText(wL.kYQ);
                                    aVar.nkW.setOnClickListener(this.nkJ);
                                    aVar.nkW.setTag(Long.valueOf(wL.field_msgId));
                                } else {
                                    aVar.nkV.setText(wL.kYQ);
                                    aVar.nkV.setVisibility(0);
                                }
                            }
                            if (!bo.isNullOrNil(wL.mWv)) {
                                f(aVar.nkZ, wL.mWv);
                                aVar.nkZ.setTag(Long.valueOf(wL.field_msgId));
                                aVar.nkZ.setOnTouchListener(nkH);
                                aVar.nkZ.setOnClickListener(this.nkJ);
                                aVar.nkZ.setVisibility(0);
                                aVar.nkZ.setEnabled(true);
                                break;
                            }
                            break;
                        default:
                            ab.e("MicroMsg.GameMessageAdapter", "error msgtype: " + wL.field_msgType);
                            break;
                    }
                }
                if (wL.mWT != null) {
                    f(aVar.nkS, wL.mWT.mXr);
                    aVar.nkS.setVisibility(0);
                    if (bo.isNullOrNil(wL.mWT.mXq)) {
                        aVar.ejp.setVisibility(8);
                    } else {
                        aVar.ejp.setText(wL.mWT.mXq);
                        aVar.ejp.setVisibility(0);
                    }
                    if (bo.isNullOrNil(wL.mWT.mXs)) {
                        aVar.nkU.setVisibility(8);
                    } else {
                        f(aVar.nkU, wL.mWT.mXs);
                        aVar.nkU.setVisibility(0);
                    }
                    if (bo.isNullOrNil(wL.mWT.mXk)) {
                        aVar.ejp.setEnabled(false);
                        aVar.nkS.setEnabled(false);
                    } else {
                        aVar.ejp.setEnabled(true);
                        aVar.nkS.setEnabled(true);
                        com.tencent.mm.plugin.game.model.o.a aVar3 = new com.tencent.mm.plugin.game.model.o.a(wL, wL.mWT.mXk, 1);
                        com.tencent.mm.plugin.game.model.o.a aVar4 = new com.tencent.mm.plugin.game.model.o.a(wL, wL.mWT.mXk, 2);
                        aVar.ejp.setTag(aVar3);
                        aVar.ejp.setOnClickListener(this.nkO);
                        aVar.nkS.setTag(aVar4);
                        aVar.nkS.setOnClickListener(this.nkO);
                    }
                } else if (bo.ek(wL.mWp)) {
                    aVar.nkS.setVisibility(8);
                    aVar.ejp.setVisibility(8);
                    aVar.nkU.setVisibility(8);
                } else {
                    iVar = (i) wL.mWp.get(0);
                    if (bo.isNullOrNil(iVar.bCu)) {
                        aoO = ((j) g.K(j.class)).XM().aoO(iVar.userName);
                        if (aoO == null || bo.isNullOrNil(aoO.Oj())) {
                            Oj = iVar.userName;
                        } else {
                            Oj = aoO.Oj();
                        }
                    } else {
                        Oj = iVar.bCu;
                    }
                    if (bo.isNullOrNil(iVar.mXx)) {
                        aVar.ejp.setEnabled(false);
                        aVar.nkS.setEnabled(false);
                    } else {
                        aVar.ejp.setEnabled(true);
                        aVar.nkS.setEnabled(true);
                        com.tencent.mm.plugin.game.model.o.a aVar5 = new com.tencent.mm.plugin.game.model.o.a(wL, iVar.mXx, 1);
                        com.tencent.mm.plugin.game.model.o.a aVar6 = new com.tencent.mm.plugin.game.model.o.a(wL, iVar.mXx, 2);
                        aVar.ejp.setTag(aVar5);
                        aVar.ejp.setOnClickListener(this.nkO);
                        aVar.nkS.setTag(aVar6);
                        aVar.nkS.setOnClickListener(this.nkO);
                    }
                    if (bo.isNullOrNil(Oj)) {
                        aVar.ejp.setVisibility(8);
                    } else {
                        aVar.ejp.setText(com.tencent.mm.pluginsdk.ui.e.j.b(this.context, Oj, aVar.ejp.getTextSize()), BufferType.SPANNABLE);
                        aVar.ejp.setVisibility(0);
                    }
                    aVar.nkS.setVisibility(0);
                    if (bo.isNullOrNil(iVar.mXu)) {
                        d(aVar.nkS, iVar.userName);
                    } else {
                        f(aVar.nkS, iVar.mXu);
                    }
                    if (bo.isNullOrNil(iVar.mXw)) {
                        aVar.nkU.setVisibility(8);
                    } else {
                        f(aVar.nkU, iVar.mXw);
                        aVar.nkU.setVisibility(0);
                    }
                }
                if (bo.isNullOrNil(wL.mWP)) {
                    aVar.iqU.setVisibility(8);
                } else {
                    if (wL.mWp.size() > 1) {
                        aVar.iqU.setText(this.context.getResources().getString(R.string.c7c, new Object[]{Integer.valueOf(wL.mWp.size())}) + wL.mWP);
                    } else {
                        aVar.iqU.setText(wL.mWP);
                    }
                    aVar.iqU.setVisibility(0);
                }
                if (bo.isNullOrNil(wL.mWQ)) {
                    aVar.nkV.setVisibility(8);
                } else {
                    aVar.nkV.setText(com.tencent.mm.pluginsdk.ui.e.j.b(this.context, wL.mWQ, aVar.nkV.getTextSize()));
                    aVar.nkV.setVisibility(0);
                }
                a(wL, aVar);
                if (bo.isNullOrNil(wL.mWU.mXp)) {
                    aVar.nkW.setVisibility(8);
                } else {
                    aVar.nkW.setVisibility(0);
                    if (bo.isNullOrNil(wL.mWU.mXk)) {
                        aVar.nkW.setEnabled(false);
                    } else {
                        aVar.nkW.setTag(new com.tencent.mm.plugin.game.model.o.a(wL, wL.mWU.mXk, 3));
                        aVar.nkW.setOnClickListener(this.nkO);
                        aVar.nkW.setEnabled(true);
                    }
                    aVar.nkX.setText(com.tencent.mm.pluginsdk.ui.e.j.b(this.context, wL.mWU.mXp, aVar.nkX.getTextSize()));
                    if (bo.isNullOrNil(wL.mWU.mXj)) {
                        aVar.nkY.setVisibility(8);
                    } else {
                        f(aVar.nkY, wL.mWU.mXj);
                        aVar.nkY.setVisibility(0);
                    }
                }
                if (bo.isNullOrNil(wL.mWR)) {
                    aVar.nkZ.setVisibility(8);
                } else {
                    f(aVar.nkZ, wL.mWR);
                    aVar.nkZ.setVisibility(0);
                    if (bo.isNullOrNil(wL.mWS)) {
                        aVar.nkZ.setEnabled(false);
                    } else {
                        aVar.nkZ.setTag(new com.tencent.mm.plugin.game.model.o.a(wL, wL.mWS, 3));
                        aVar.nkZ.setOnClickListener(this.nkO);
                        aVar.nkZ.setEnabled(true);
                    }
                }
                if (bo.isNullOrNil(wL.mWV.mName)) {
                    aVar.nlb.setVisibility(8);
                } else {
                    aVar.nlb.setText(wL.mWV.mName);
                    aVar.nlb.setVisibility(0);
                    if (bo.isNullOrNil(wL.mWV.mXk)) {
                        aVar.nlb.setEnabled(false);
                    } else {
                        aVar.nlb.setTag(new com.tencent.mm.plugin.game.model.o.a(wL, wL.mWV.mXk, 5));
                        aVar.nlb.setOnClickListener(this.nkO);
                        aVar.nlb.setEnabled(true);
                    }
                }
                AppMethodBeat.o(112069);
                return view;
            }
        }
        aVar.nkR.setVisibility(8);
        aVar.nlc.setVisibility(0);
        AppMethodBeat.o(112069);
        return view;
    }

    private void a(com.tencent.mm.plugin.game.model.n nVar, a aVar) {
        AppMethodBeat.i(112070);
        LinkedList linkedList = new LinkedList();
        for (int i = 1; i < nVar.mWp.size(); i++) {
            linkedList.add(nVar.mWp.get(i));
        }
        aVar.nld.a(nVar, linkedList, this.nkN, this.mXC, this.nkP);
        AppMethodBeat.o(112070);
    }

    private void d(ImageView imageView, String str) {
        AppMethodBeat.i(112071);
        if (bo.isNullOrNil(str)) {
            com.tencent.mm.pluginsdk.ui.a.b.b(imageView, str);
            AppMethodBeat.o(112071);
        } else if (this.nkP.aj(str)) {
            Bitmap bitmap = (Bitmap) this.nkP.get(str);
            if (bitmap == null || bitmap.isRecycled()) {
                e(imageView, str);
                AppMethodBeat.o(112071);
                return;
            }
            imageView.setImageBitmap(bitmap);
            AppMethodBeat.o(112071);
        } else {
            e(imageView, str);
            AppMethodBeat.o(112071);
        }
    }

    private void e(ImageView imageView, String str) {
        AppMethodBeat.i(112072);
        Bitmap j = e.bFH().j(imageView, str);
        if (j != null) {
            this.nkP.put(str, j);
        }
        AppMethodBeat.o(112072);
    }

    private void f(ImageView imageView, String str) {
        AppMethodBeat.i(112073);
        if (this.nkP.aj(str)) {
            Bitmap bitmap = (Bitmap) this.nkP.get(str);
            if (bitmap == null || bitmap.isRecycled()) {
                g(imageView, str);
                AppMethodBeat.o(112073);
                return;
            }
            imageView.setImageBitmap(bitmap);
            AppMethodBeat.o(112073);
            return;
        }
        g(imageView, str);
        AppMethodBeat.o(112073);
    }

    private void g(ImageView imageView, final String str) {
        AppMethodBeat.i(112074);
        com.tencent.mm.plugin.game.f.e.a.a aVar = new com.tencent.mm.plugin.game.f.e.a.a();
        aVar.ePF = false;
        e.bFH().a(imageView, str, aVar.bFI(), new e.b() {
            public final void a(View view, Bitmap bitmap) {
                AppMethodBeat.i(112067);
                if (!(bitmap == null || bitmap.isRecycled())) {
                    n.this.nkP.put(str, bitmap);
                }
                AppMethodBeat.o(112067);
            }
        });
        AppMethodBeat.o(112074);
    }

    public final void KC() {
        AppMethodBeat.i(112075);
        setCursor(((c) g.K(c.class)).bCY().rawQuery("select * from GameRawMessage where " + r.v(2, 5, 6, 10, 11, 100) + " and showInMsgList = 1 and isHidden = 0 order by isRead, createTime desc limit " + this.kmW, new String[0]));
        this.kmW = getCount();
        if (this.yle != null) {
            this.yle.apt();
        }
        super.notifyDataSetChanged();
        AppMethodBeat.o(112075);
    }

    public final void KD() {
        AppMethodBeat.i(112076);
        bIf();
        KC();
        AppMethodBeat.o(112076);
    }

    private static com.tencent.mm.plugin.game.model.n a(com.tencent.mm.plugin.game.model.n nVar, Cursor cursor) {
        AppMethodBeat.i(112077);
        if (nVar == null) {
            nVar = new com.tencent.mm.plugin.game.model.n();
        }
        nVar.d(cursor);
        AppMethodBeat.o(112077);
        return nVar;
    }

    public final boolean bdn() {
        return this.kmW >= this.enb;
    }

    public final void bFr() {
        AppMethodBeat.i(112078);
        if (bdn()) {
            if (this.yle != null) {
                this.yle.apt();
            }
            AppMethodBeat.o(112078);
            return;
        }
        this.kmW += 15;
        if (this.kmW > this.enb) {
            this.kmW = this.enb;
        }
        AppMethodBeat.o(112078);
    }

    public final int getCount() {
        AppMethodBeat.i(112079);
        if (this.count < 0) {
            this.count = getCursor().getCount();
        }
        if (this.count <= 0) {
            AppMethodBeat.o(112079);
            return 0;
        }
        int bFs = this.count + bFs();
        AppMethodBeat.o(112079);
        return bFs;
    }

    public final boolean wK(int i) {
        return this.enb > this.csm && this.csm > 0 && i == this.csm;
    }

    public final int bFs() {
        return (this.enb <= this.csm || this.csm <= 0) ? 0 : 1;
    }

    private com.tencent.mm.plugin.game.model.n wL(int i) {
        AppMethodBeat.i(112080);
        com.tencent.mm.plugin.game.model.n nVar;
        if (wK(i)) {
            nVar = (com.tencent.mm.plugin.game.model.n) this.ylb;
            AppMethodBeat.o(112080);
            return nVar;
        }
        if (this.yld != null) {
            nVar = (com.tencent.mm.plugin.game.model.n) this.yld.get(Integer.valueOf(i));
            if (nVar != null) {
                AppMethodBeat.o(112080);
                return nVar;
            }
        }
        int i2;
        if (wM(i)) {
            i2 = i - 1;
        } else {
            i2 = i;
        }
        if (i < 0 || !getCursor().moveToPosition(i2)) {
            AppMethodBeat.o(112080);
            return null;
        } else if (this.yld == null) {
            nVar = a((com.tencent.mm.plugin.game.model.n) this.ylb, getCursor());
            AppMethodBeat.o(112080);
            return nVar;
        } else {
            nVar = a(null, getCursor());
            this.yld.put(Integer.valueOf(i), nVar);
            AppMethodBeat.o(112080);
            return nVar;
        }
    }

    private boolean wM(int i) {
        return this.enb > this.csm && this.csm > 0 && i > this.csm;
    }

    public final /* bridge */ /* synthetic */ Object bFt() {
        return (com.tencent.mm.plugin.game.model.n) this.ylb;
    }
}
